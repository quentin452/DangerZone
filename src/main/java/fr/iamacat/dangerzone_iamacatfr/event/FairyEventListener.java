package fr.iamacat.dangerzone_iamacatfr.event;

import java.util.Map;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.PacketBuffer;

import com.google.common.collect.Maps;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerCustomPacketEvent;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import io.netty.buffer.ByteBuf;

public class FairyEventListener {

    public enum PacketType {

        SET_FAIRY_NAME(0, PacketSetFairyName.class);

        public final byte packet_id;
        protected final Class<? extends FairyPacket> packet_class;

        private PacketType(final int id, Class<? extends FairyPacket> clazz) {
            packet_id = (byte) id;
            packet_class = clazz;
        }

        public static PacketType get(final byte id) {
            return map.get(id);
        }

        public static final Map<Byte, PacketType> map = Maps.newHashMap();
        static {
            for (PacketType type : PacketType.values()) {
                map.put(type.packet_id, type);
            }
        }
    }

    @SubscribeEvent
    public void onPacket(ServerCustomPacketEvent event) {
        if (event.packet.channel()
            .equals(Tags.MODID)) {
            final NetHandlerPlayServer handler = (NetHandlerPlayServer) event.handler;
            handlePacket(event.packet, handler.playerEntity);
        }
    }

    protected void handlePacket(FMLProxyPacket proxyPacket, EntityPlayerMP player) {
        final ByteBuf payload = proxyPacket.payload();
        if (payload.readableBytes() > 0) {
            final PacketBuffer buf = new PacketBuffer(payload);

            final byte id = buf.readByte();
            final PacketType type = PacketType.get(id);
            if (type == null) {
                DangerLogger.LOGGER.error("Got unknown packet type " + id);
                return;
            }

            final FairyPacket packet;
            try {
                packet = type.packet_class.newInstance();
            } catch (Exception e) {
                // ERROR, unable to actually process
                e.printStackTrace();
                return;
            }

            packet.init(buf);
            packet.handle(proxyPacket.getOrigin());
        }
    }

}
