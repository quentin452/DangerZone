package fr.iamacat.dangerzone_iamacatfr.network;

public abstract interface ISidedProxy {

    public abstract void preInit();

    public abstract void load();

    public default void registerRenders() {}

    // public abstract ConcurrentHashMap<EntityLivingBase, MobModifier> getRareMobs();

    // public abstract void onHealthPacketForClient(String paramString, int paramInt, float paramFloat1, float
    // paramFloat2);

    public abstract void onKnockBackPacket(float paramFloat1, float paramFloat2);

    public abstract void onConfusionPacket(boolean paramBool);

    // public abstract void onMobModsPacketToClient(String paramString, int paramInt);

    // public abstract void onVelocityPacket(float paramFloat1, float paramFloat2, float paramFloat3);

    // public abstract void onAirPacket(int paramInt);
}
