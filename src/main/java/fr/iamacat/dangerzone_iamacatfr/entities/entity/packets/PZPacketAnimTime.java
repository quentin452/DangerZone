
package fr.iamacat.dangerzone_iamacatfr.entities.entity.packets;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericCreatureInstance;
import io.netty.buffer.ByteBuf;

public class PZPacketAnimTime implements IMessage, IMessageHandler<PZPacketAnimTime, IMessage> {

    private int entityIDtoSync;
    private int animTime;

    public PZPacketAnimTime setPacketData(final int entityIDtoSync, final int animTime) {
        this.entityIDtoSync = entityIDtoSync;
        this.animTime = animTime;
        return this;
    }

    public IMessage onMessage(final PZPacketAnimTime message, final MessageContext ctx) {
        if (ctx.side != Side.CLIENT) {
            return null;
        }
        final EntityPlayer player = DangerZone.packetProxy.getClientPlayer();
        final World worldObj = player.worldObj;
        final Entity entity = worldObj.getEntityByID(message.entityIDtoSync);
        if (entity != null && entity instanceof GenericCreatureInstance) {
            ((GenericCreatureInstance) entity).setAnimTime(message.animTime);
        }
        return null;
    }

    public void fromBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            this.entityIDtoSync = buffer.readInt();
            this.animTime = buffer.readInt();
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem encoding the packet in PZPacketAnimTime: " + buffer + ".", this);
            e.printStackTrace();
        }
    }

    public void toBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            buffer.writeInt(this.entityIDtoSync);
            buffer.writeInt(this.animTime);
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem encoding the packet in PZPacketAnimTime : " + buffer + ".", this);
            e.printStackTrace();
        }
    }
}
