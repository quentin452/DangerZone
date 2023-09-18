
package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;

public class MobUtils {

    public static boolean isPony(final Entity e) {
        return e instanceof EntityLivingBase && (e instanceof MyTwilicorn || e instanceof MyWindigo
            || e instanceof MyArcticScorpion
            || e instanceof MyDarkness
            || e instanceof MyTwilightMagic
            || e instanceof MyDashCloud);
    }

    public static boolean isWindy(final Entity e) {
        return e instanceof EntityLivingBase
            && (e instanceof MyWindigo || e instanceof MyArcticScorpion || e instanceof MyPowerOrbs);
    }

    public static boolean isAttackableNonMob(final EntityLivingBase par1EntityLiving) {
        return par1EntityLiving instanceof EntityMob || isPony((Entity) par1EntityLiving)
            || par1EntityLiving instanceof EntityVillager;
    }

    public static boolean isIgnoreable(final EntityLivingBase par1EntityLiving) {
        return false;
    }
}
