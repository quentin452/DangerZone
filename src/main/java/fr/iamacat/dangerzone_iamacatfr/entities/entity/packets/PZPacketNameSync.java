
package fr.iamacat.dangerzone_iamacatfr.entities.entity.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericTameableInstance;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class PZPacketNameSync implements IMessage, IMessageHandler<PZPacketNameSync, IMessage> {

    private int entityIdToBeNamed;
    private String entityName;
    private String RentityName;

    public PZPacketNameSync setPacketData(final int entityIdToBeNamed, final String entityName) {
        this.entityIdToBeNamed = entityIdToBeNamed;
        this.entityName = entityName;
        return this;
    }

    public IMessage onMessage(final PZPacketNameSync message, final MessageContext ctx) {
        if (ctx.side != Side.SERVER) {
            return null;
        }
        final EntityPlayer player = (EntityPlayer) ctx.getServerHandler().playerEntity;
        final Entity entity = player.worldObj.getEntityByID(message.entityIdToBeNamed);
        if (entity != null && entity instanceof GenericTameableInstance) {
            ((GenericTameableInstance) entity).setEntityTamed(message.RentityName);
        }
        return null;
    }

    public void fromBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            this.entityIdToBeNamed = buffer.readInt();
            final int nameLength = buffer.readInt();
            this.entityName = buffer.readStringFromBuffer(nameLength);
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem decoding the packet in PZPacketNameSync: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    public void toBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            buffer.writeInt(this.entityIdToBeNamed);
            final byte[] entityNameBytes = this.entityName.getBytes("UTF-8");
            buffer.writeInt(entityNameBytes.length);
            buffer.writeBytes(entityNameBytes);
        } catch (IOException e) {
            DangerLogger.LOGGER
                .error("There was a problem encoding the packet in PZPacketNameSync: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
