package fr.iamacat.dangerzone_iamacatfr.network;

import cpw.mods.fml.common.network.FMLEventChannel;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.other.RiderControlMessage;
import fr.iamacat.dangerzone_iamacatfr.entities.other.RiderControlMessageHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.network.play.server.S13PacketDestroyEntities;
import net.minecraft.network.play.server.S1BPacketEntityAttach;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

import java.util.List;

public class CommonProxy {

    protected FMLEventChannel eventChannel;

    public void sendToServer(FMLProxyPacket packet) {
        eventChannel.sendToServer(packet);
    }

    public void registerRenders() {}

    public void openRenameGUI(FairyInstance fairy) {
        // should only ever be implemented on client
    }

    public EntityPlayer getCurrentPlayer() {
        return null;
    }

    public void sendToAllPlayers(Packet packet) {
        List<EntityPlayerMP> players = MinecraftServer.getServer()
            .getConfigurationManager().playerEntityList;
        for (EntityPlayerMP player : players) {
            player.playerNetServerHandler.sendPacket(packet);
        }
    }

    public void sendChat(EntityPlayerMP player, String s) {
        if (player != null && !s.isEmpty())
            player.playerNetServerHandler.sendPacket(new S02PacketChat(new ChatComponentText(s)));
    }

    @Deprecated
    public void sendDisband(EntityPlayerMP player, String s) {
        sendChat(player, s);
        /*
         * if (player != null) {
         * final S02PacketChat packet = new S02PacketChat(new ChatComponentText(s));
         * player.playerNetServerHandler.sendPacket(packet);
         * }
         * //Shouldn't enable this by default, could be spammy.
         * //MinecraftServer.logger.info(s);
         */
    }

    public void sendFairyDespawn(Entity entity) {
        final int[] eid = new int[] { entity.getEntityId() };
        final S13PacketDestroyEntities packet = new S13PacketDestroyEntities(eid);
        sendToAllPlayers(packet);
        entity.setDead();
    }

    private SimpleNetworkWrapper network;

    public SimpleNetworkWrapper getNetwork() {
        return this.network;
    }

    public void registerRenderThings() {}

    public void registerKeyboardInput() {}

    public void registerNetworkStuff() {
        (this.network = NetworkRegistry.INSTANCE.newSimpleChannel("RiderControls"))
            .registerMessage(RiderControlMessageHandler.class, RiderControlMessage.class, 0, Side.SERVER);
    }

    public int setArmorPrefix(final String string) {
        return 0;
    }
}
