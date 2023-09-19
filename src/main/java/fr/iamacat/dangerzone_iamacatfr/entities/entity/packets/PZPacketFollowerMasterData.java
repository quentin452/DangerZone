
package fr.iamacat.dangerzone_iamacatfr.entities.entity.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraft.world.World;

public class PZPacketFollowerMasterData implements IMessage, IMessageHandler<PZPacketFollowerMasterData, IMessage> {

    int childEntityID;
    int masterEntityID;
    int followerIndex;

    public PZPacketFollowerMasterData setPacketData(final int childEntityID, final int masterEntityID,
        final int followerIndex) {
        this.childEntityID = childEntityID;
        this.masterEntityID = masterEntityID;
        this.followerIndex = followerIndex;
        return this;
    }

    public IMessage onMessage(final PZPacketFollowerMasterData message, final MessageContext ctx) {
        if (ctx.side != Side.CLIENT) {
            return null;
        }
        final EntityPlayer player = DangerZone.packetProxy.getClientPlayer();
        final World worldObj = player.worldObj;
        final Entity childEntity = worldObj.getEntityByID(message.childEntityID);
        final Entity masterEntity = worldObj.getEntityByID(message.masterEntityID);
        // todo if (message.followerIndex == -1 || message.masterEntityID == -1 || childEntity == null || !(childEntity
        // instanceof EntityFollower) || masterEntity == null || !(masterEntity instanceof EntityMaster)) {
        // return null;
        // }
        // ((EntityFollower)childEntity).linkMasterWithFollower(message.masterEntityID, message.followerIndex); todo
        return null;
    }

    public void fromBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            this.childEntityID = buffer.readInt();
            this.masterEntityID = buffer.readInt();
            this.followerIndex = buffer.readInt();
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem decoding the packet in PZPacketFollowerMasterData: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }

    public void toBytes(final ByteBuf buf) {
        final PacketBuffer buffer = new PacketBuffer(buf);
        try {
            buffer.writeInt(this.childEntityID);
            buffer.writeInt(this.masterEntityID);
            buffer.writeInt(this.followerIndex);
        } catch (Exception e) {
            DangerLogger.LOGGER
                .error("There was a problem encoding the packet in PZPacketFollowerMasterData: " + e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
