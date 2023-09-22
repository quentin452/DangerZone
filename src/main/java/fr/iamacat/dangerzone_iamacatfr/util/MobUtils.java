
package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;

public class MobUtils {

    public static boolean isPony(final Entity e) {
        return e instanceof EntityLivingBase && (e instanceof WindigoInstance || e instanceof ArcticScorpionInstance
            || e instanceof DarknessInstance
            || e instanceof DashCloudInstance);
    }

    public static boolean isWindy(final Entity e) {
        return e instanceof EntityLivingBase
            && (e instanceof WindigoInstance || e instanceof ArcticScorpionInstance || e instanceof PowerOrbsInstance);
    }

    public static boolean isAttackableNonMob(final EntityLivingBase par1EntityLiving) {
        return par1EntityLiving instanceof EntityMob || isPony((Entity) par1EntityLiving)
            || par1EntityLiving instanceof EntityVillager;
    }

    public static boolean isIgnoreable(final EntityLivingBase par1EntityLiving) {
        return false;
    }
}
