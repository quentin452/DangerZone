
package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;

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
            || par1EntityLiving instanceof Dragon
            || par1EntityLiving instanceof Spyro
            || isRoyalty(par1EntityLiving)
            || par1EntityLiving instanceof GammaMetroid
            || par1EntityLiving instanceof Cephadrome
            || par1EntityLiving instanceof WaterDragon
            || par1EntityLiving instanceof Girlfriend
            || par1EntityLiving instanceof Boyfriend
            || par1EntityLiving instanceof EntityVillager
            || par1EntityLiving instanceof Stinky;
    }

    public static boolean isIgnoreable(final EntityLivingBase par1EntityLiving) {
        return par1EntityLiving instanceof RockBase || par1EntityLiving instanceof EntityAnt
            || par1EntityLiving instanceof EntityButterfly
            || par1EntityLiving instanceof EntityMosquito
            || par1EntityLiving instanceof Dragonfly
            || par1EntityLiving instanceof Firefly
            || par1EntityLiving instanceof Cricket
            || par1EntityLiving instanceof Cockateil
            || par1EntityLiving instanceof Termite
            || par1EntityLiving instanceof Ghost
            || par1EntityLiving instanceof GhostSkelly
            || par1EntityLiving instanceof Elevator;
    }
}
