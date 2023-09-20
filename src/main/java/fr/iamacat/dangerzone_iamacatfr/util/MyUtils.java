
package fr.iamacat.dangerzone_iamacatfr.util;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;

public class MyUtils {

    public static boolean isRoyalty(final Entity e) {
        return e instanceof EntityLivingBase && (e instanceof ThePrince || e instanceof ThePrinceTeen
            || e instanceof ThePrinceAdult
            || e instanceof ThePrincess
            || e instanceof TheKing
            || e instanceof KingHead
            || e instanceof TheQueen
            || e instanceof QueenHead
            || e instanceof PurplePower);
    }

    public static boolean isAttackableNonMob(final EntityLivingBase par1EntityLiving) {
        return par1EntityLiving instanceof EntityMob || par1EntityLiving instanceof Mothra
            || par1EntityLiving instanceof Leon
            || par1EntityLiving instanceof DragonInstance
            || par1EntityLiving instanceof Spyro
            || isRoyalty(par1EntityLiving)
            || par1EntityLiving instanceof GammaMetroid
            || par1EntityLiving instanceof CephadromeInstance
            || par1EntityLiving instanceof WaterDragon
            || par1EntityLiving instanceof GirlfriendInstance
            || par1EntityLiving instanceof BoyfriendInstance
            || par1EntityLiving instanceof EntityVillager
            || par1EntityLiving instanceof Stinky;
    }

    public static boolean isIgnoreable(final EntityLivingBase par1EntityLiving) {
        return par1EntityLiving instanceof RockBase
            || par1EntityLiving instanceof ButterflyInstance
            || par1EntityLiving instanceof EntityMosquito
            || par1EntityLiving instanceof DragonflyInstance
            || par1EntityLiving instanceof Firefly
            || par1EntityLiving instanceof CricketInstance
            || par1EntityLiving instanceof CockateilInstance
            || par1EntityLiving instanceof UnstableAntInstance
            || par1EntityLiving instanceof BrownAntInstance
            || par1EntityLiving instanceof RedAntInstance
            || par1EntityLiving instanceof RainbowAntInstance
            || par1EntityLiving instanceof TermiteInstance
            || par1EntityLiving instanceof GhostInstance
            || par1EntityLiving instanceof HoverboardInstance;
    }
}
