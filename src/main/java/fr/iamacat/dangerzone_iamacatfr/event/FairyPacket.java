package fr.iamacat.dangerzone_iamacatfr.event;

import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;

import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import io.netty.buffer.Unpooled;

public abstract class FairyPacket extends FMLProxyPacket {

    protected FairyPacket(FairyEventListener.PacketType packetType) {
        super(new PacketBuffer(Unpooled.buffer()), Tags.MODID);

        final PacketBuffer buf = (PacketBuffer) this.payload();
        buf.writeByte(packetType.packet_id);
    }

    protected abstract void pack();

    public abstract void init(PacketBuffer buf);

    public abstract void handle(NetworkManager networkManager);

}
