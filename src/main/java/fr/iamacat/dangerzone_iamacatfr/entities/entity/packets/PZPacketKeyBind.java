
package fr.iamacat.dangerzone_iamacatfr.entities.entity.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class PZPacketKeyBind implements IMessage, IMessageHandler<PZPacketKeyBind, IMessage> {

    private String keyBindCode;
    private int keyBindValue;

    public PZPacketKeyBind setPacketData(final String keyCode, final int keyValue) {
        this.keyBindCode = keyCode;
        this.keyBindValue = keyValue;
        return this;
    }

    public IMessage onMessage(final PZPacketKeyBind message, final MessageContext ctx) {
        if (ctx.side != Side.SERVER) {
            return null;
        }
        if (message.keyBindCode.equalsIgnoreCase("jump")) {
            final EntityPlayerMP player = ctx.getServerHandler().playerEntity;
            // if (player.ridingEntity != null && player.ridingEntity instanceof EntityCamel) {
            // //((EntityCamel)player.ridingEntity).setMountJump();// todo
            // }
        }
        if (message.keyBindCode.equalsIgnoreCase("inventory")) {
            final EntityPlayerMP player = ctx.getServerHandler().playerEntity;
            // if (player.ridingEntity != null && player.ridingEntity instanceof EntityCamel) {
            // player.openGui((Object) DangerZone.modInstance, 5, player.worldObj, player.ridingEntity.getEntityId(), 0,
            // 0);
            // }
        }
        if (message.keyBindCode.equalsIgnoreCase("dismount")) {
            final EntityPlayerMP player = ctx.getServerHandler().playerEntity;
            // if (player.ridingEntity != null && player.ridingEntity instanceof EntityCamel) {
            // ((EntityCamel)player.ridingEntity).riderDismount();// todo
            // }
        }
        return null;
    }

    public void fromBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            final int kBCLength = buffer.readInt();
            this.keyBindCode = buffer.readStringFromBuffer(kBCLength);
            this.keyBindValue = buffer.readInt();
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem decoding the packet in PZPacketKeyBind: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    public void toBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            final byte[] keyBindCodeBytes = this.keyBindCode.getBytes("UTF-8");
            buffer.writeInt(keyBindCodeBytes.length);
            buffer.writeBytes(keyBindCodeBytes);
            buffer.writeInt(this.keyBindValue);
        } catch (IOException e) {
            DangerLogger.LOGGER
                .error("There was a problem encoding the packet in PZPacketKeyBind: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
