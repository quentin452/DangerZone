
package fr.iamacat.dangerzone_iamacatfr.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericTameableInstance;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;

public class PZPacketTameParticle implements IMessage, IMessageHandler<PZPacketTameParticle, IMessage> {

    private int entityIdToTriggerEffect;
    private boolean tameingSuccess;

    public PZPacketTameParticle setPacketData(final int entityIdToTriggerEffect, final boolean tameingSuccess) {
        this.entityIdToTriggerEffect = entityIdToTriggerEffect;
        this.tameingSuccess = tameingSuccess;
        return this;
    }

    public IMessage onMessage(final PZPacketTameParticle message, final MessageContext ctx) {
        if (ctx.side != Side.CLIENT) {
            return null;
        }
        final EntityPlayer player = OreSpawnMain.packetproxy.getClientPlayer();
        final Entity entity = player.worldObj.getEntityByID(message.entityIdToTriggerEffect);
        if (entity != null && entity instanceof GenericTameableInstance) {
            ((GenericTameableInstance) entity).playTameEffect(message.tameingSuccess);
        }
        return null;
    }

    public void fromBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            this.entityIdToTriggerEffect = buffer.readInt();
            this.tameingSuccess = buffer.readBoolean();
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem decoding the packet in PZPacketStreamSound : " + buffer + ".", this);
            e.printStackTrace();
        }
    }

    public void toBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            buffer.writeInt(this.entityIdToTriggerEffect);
            buffer.writeBoolean(this.tameingSuccess);
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem encoding the packet in PZTameParticle : " + buffer + ".", this);
            e.printStackTrace();
        }
    }
}
