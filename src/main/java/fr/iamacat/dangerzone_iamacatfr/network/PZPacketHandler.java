
package fr.iamacat.dangerzone_iamacatfr.network;


import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.packets.*;
import fr.iamacat.dangerzone_iamacatfr.network.packet.PZPacketPlaySound;
import fr.iamacat.dangerzone_iamacatfr.network.packet.PZPacketStreamSound;
import fr.iamacat.dangerzone_iamacatfr.network.packet.PZPacketTameParticle;
import net.minecraft.entity.player.EntityPlayerMP;

public class PZPacketHandler
{
    public final SimpleNetworkWrapper network;

    public PZPacketHandler() {
        this.network = NetworkRegistry.INSTANCE.newSimpleChannel("DangerZone");
    }

    public void init() {
        int messageID = 0;
        this.network.registerMessage(PZPacketPlaySound.class, PZPacketPlaySound.class, messageID++, Side.CLIENT);
        this.network.registerMessage(PZPacketStreamSound.class, PZPacketStreamSound.class, messageID++, Side.CLIENT);
        this.network.registerMessage(PZPacketTameParticle.class, PZPacketTameParticle.class, messageID++, Side.CLIENT);
        this.network.registerMessage(PZPacketAnimTime.class, PZPacketAnimTime.class, messageID++, Side.CLIENT);
        this.network.registerMessage(PZPacketFollowerMasterData.class, PZPacketFollowerMasterData.class, messageID++, Side.CLIENT);
        this.network.registerMessage(PZPacketNameSync.class, PZPacketNameSync.class, messageID++, Side.SERVER);
        this.network.registerMessage(PZPacketTileText.class, PZPacketTileText.class, messageID++, Side.SERVER);
        this.network.registerMessage(PZPacketKeyBind.class, PZPacketKeyBind.class, messageID++, Side.SERVER);
    }

    public void sendToAll(final IMessage message) {
        this.network.sendToAll(message);
    }

    public void sendToPlayer(final IMessage message, final EntityPlayerMP player) {
        this.network.sendTo(message, player);
    }

    public void sendToAllAround(final IMessage message, final NetworkRegistry.TargetPoint point) {
        this.network.sendToAllAround(message, point);
    }

    public void sendToDimension(final IMessage message, final int dimensionID) {
        this.network.sendToDimension(message, dimensionID);
    }

    public void sendToServer(final IMessage message) {
        this.network.sendToServer(message);
    }
}
