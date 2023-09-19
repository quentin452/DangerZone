package fr.iamacat.dangerzone_iamacatfr.network;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

public abstract interface ISidedProxy {

    void openRenameGUI(FairyInstance fairy);

    EntityPlayer getCurrentPlayer();

    public abstract void preInit();

    public abstract void load();

    public default void registerRenders() {}

    // public abstract ConcurrentHashMap<EntityLivingBase, MobModifier> getRareMobs();

    // public abstract void onHealthPacketForClient(String paramString, int paramInt, float paramFloat1, float
    // paramFloat2);

    public abstract void onKnockBackPacket(float paramFloat1, float paramFloat2);

    public abstract void onConfusionPacket(boolean paramBool);

    void sendFairyDespawn(FairyInstance fairyInstance);

    void sendFairyMount(FairyInstance fairy, Entity ridingEntity);

    void sendChat(EntityPlayerMP player, String s);

    void sendFairyRename(FairyInstance fairy, String nameText);

    EntityPlayer getClientPlayer();

    // public abstract void onMobModsPacketToClient(String paramString, int paramInt);

    // public abstract void onVelocityPacket(float paramFloat1, float paramFloat2, float paramFloat3);

    // public abstract void onAirPacket(int paramInt);
}
