package fr.iamacat.dangerzone_iamacatfr.network;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public abstract interface ISidedProxy {


    EntityPlayer getCurrentPlayer();

    public abstract void preInit();

    public abstract void load();

    public default void registerRenders() {}

    // public abstract ConcurrentHashMap<EntityLivingBase, MobModifier> getRareMobs();

    // public abstract void onHealthPacketForClient(String paramString, int paramInt, float paramFloat1, float
    // paramFloat2);

    public abstract void onKnockBackPacket(float paramFloat1, float paramFloat2);

    public abstract void onConfusionPacket(boolean paramBool);


    void sendChat(EntityPlayerMP player, String s);


    EntityPlayer getClientPlayer();

    void registerSoundThings();

    int setArmorPrefix(String ultimate);

    void registerRenderThings();

    void registerKeyboardInput();

    void registerNetworkStuff();

    // public abstract void onMobModsPacketToClient(String paramString, int paramInt);

    // public abstract void onVelocityPacket(float paramFloat1, float paramFloat2, float paramFloat3);

    // public abstract void onAirPacket(int paramInt);
}
