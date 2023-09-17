

package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

import java.util.Random;

public class RandomPositionGenerator
{
    private static Vec3 staticVector;

    public static Vec3 findRandomTarget(final EntityGenericCreature par0EntityCreature, final int par1, final int par2) {
        return findRandomTargetBlock(par0EntityCreature, par1, par2, null);
    }

    public static Vec3 findRandomTargetBlockTowards(final EntityGenericCreature par0EntityCreature, final int par1, final int par2, final Vec3 par3Vec3) {
        RandomPositionGenerator.staticVector.xCoord = par3Vec3.xCoord - par0EntityCreature.posX;
        RandomPositionGenerator.staticVector.yCoord = par3Vec3.yCoord - par0EntityCreature.posY;
        RandomPositionGenerator.staticVector.zCoord = par3Vec3.zCoord - par0EntityCreature.posZ;
        return findRandomTargetBlock(par0EntityCreature, par1, par2, RandomPositionGenerator.staticVector);
    }

    public static Vec3 findRandomTargetBlockAwayFrom(final EntityGenericCreature par0EntityCreature, final int par1, final int par2, final Vec3 par3Vec3) {
        RandomPositionGenerator.staticVector.xCoord = par0EntityCreature.posX - par3Vec3.xCoord;
        RandomPositionGenerator.staticVector.yCoord = par0EntityCreature.posY - par3Vec3.yCoord;
        RandomPositionGenerator.staticVector.zCoord = par0EntityCreature.posZ - par3Vec3.zCoord;
        return findRandomTargetBlock(par0EntityCreature, par1, par2, RandomPositionGenerator.staticVector);
    }

    public static Vec3 flyRandomlyTowardHeightLevel(final EntityGenericCreature par0EntityCreature, final int par1, final int par2, final int heightLevel) {
        return flyToRandomTargetBlockAtHeight(par0EntityCreature, par1, par2, null, heightLevel);
    }

    public static Vec3 swimRandomlyTowardHeightLevel(final EntityGenericCreature par0EntityCreature, final int par1, final int par2, final int heightLevel) {
        return swimToRandomTargetBlockAtHeight(par0EntityCreature, par1, par2, null, heightLevel);
    }

    private static Vec3 findRandomTargetBlock(final EntityGenericCreature par0EntityCreature, final int par1, final int par2, final Vec3 par3Vec3) {
        final Random var4 = par0EntityCreature.getRNG();
        boolean var5 = false;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        float var9 = -99999.0f;
        boolean var12;
        if (par0EntityCreature.hasHome()) {
            final double var10 = par0EntityCreature.getHomePosition().getDistanceSquared(MathHelper.floor_double(par0EntityCreature.posX), MathHelper.floor_double(par0EntityCreature.posY), MathHelper.floor_double(par0EntityCreature.posZ)) + 4.0f;
            final double var11 = par0EntityCreature.getMaximumHomeDistance() + par1;
            var12 = (var10 < var11 * var11);
        }
        else {
            var12 = false;
        }
        for (int var13 = 0; var13 < 10; ++var13) {
            int var14 = var4.nextInt(2 * par1) - par1;
            int var15 = var4.nextInt(2 * par2) - par2;
            int var16 = var4.nextInt(2 * par1) - par1;
            if (par3Vec3 == null || var14 * par3Vec3.xCoord + var16 * par3Vec3.zCoord >= 0.0) {
                var14 += MathHelper.floor_double(par0EntityCreature.posX);
                var15 += MathHelper.floor_double(par0EntityCreature.posY);
                var16 += MathHelper.floor_double(par0EntityCreature.posZ);
                if (!var12 || par0EntityCreature.isWithinHomeDistance(var14, var15, var16)) {
                    final float var17 = par0EntityCreature.getBlockPathWeight(var14, var15, var16);
                    if (var17 > var9) {
                        var9 = var17;
                        var6 = var14;
                        var7 = var15;
                        var8 = var16;
                        var5 = true;
                    }
                }
            }
        }
        if (var5) {
            return Vec3.createVectorHelper((double)var6, (double)var7, (double)var8);
        }
        return null;
    }

    private static Vec3 flyToRandomTargetBlockAtHeight(final EntityGenericCreature entity, final int par1, final int par2, final Vec3 par3Vec3, final int heightLevel) {
        final Random var4 = entity.getRNG();
        boolean var5 = false;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        float var9 = -99999.0f;
        boolean var12;
        if (entity.hasHome()) {
            final double var10 = entity.getHomePosition().getDistanceSquared(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ)) + 4.0f;
            final double var11 = entity.getMaximumHomeDistance() + par1;
            var12 = (var10 < var11 * var11);
        }
        else {
            var12 = false;
        }
        for (int var13 = 0; var13 < 10; ++var13) {
            int var14 = var4.nextInt(2 * par1) - par1;
            int var15;
            if (entity.posY > entity.worldObj.getPrecipitationHeight((int)entity.posX, (int)entity.posZ) + heightLevel * 1.25) {
                var15 = var4.nextInt(2 * par2) - par2 * 3 / 2;
            }
            else if (entity.posY < entity.worldObj.getPrecipitationHeight((int)entity.posX, (int)entity.posZ) + heightLevel) {
                var15 = var4.nextInt(2 * par2) - par2 / 2;
            }
            else {
                var15 = var4.nextInt(2 * par2) - par2;
            }
            int var16 = var4.nextInt(2 * par1) - par1;
            if (par3Vec3 == null || var14 * par3Vec3.xCoord + var16 * par3Vec3.zCoord >= 0.0) {
                var14 += MathHelper.floor_double(entity.posX);
                var15 += MathHelper.floor_double(entity.posY);
                var16 += MathHelper.floor_double(entity.posZ);
                if (!var12 || entity.isWithinHomeDistance(var14, var15, var16)) {
                    final float var17 = entity.getBlockPathWeight(var14, var15, var16);
                    if (var17 > var9) {
                        var9 = var17;
                        var6 = var14;
                        var7 = var15;
                        var8 = var16;
                        var5 = true;
                    }
                }
            }
        }
        if (var5) {
            return Vec3.createVectorHelper((double)var6, (double)var7, (double)var8);
        }
        return null;
    }

    private static Vec3 swimToRandomTargetBlockAtHeight(final EntityGenericCreature entity, final int par1, final int par2, final Vec3 par3Vec3, final int heightLevel) {
        final Random var4 = entity.getRNG();
        boolean var5 = false;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        float var9 = -99999.0f;
        boolean var12;
        if (entity.hasHome()) {
            final double var10 = entity.getHomePosition().getDistanceSquared(MathHelper.floor_double(entity.posX), MathHelper.floor_double(entity.posY), MathHelper.floor_double(entity.posZ)) + 4.0f;
            final double var11 = entity.getMaximumHomeDistance() + par1;
            var12 = (var10 < var11 * var11);
        }
        else {
            var12 = false;
        }
        for (int var13 = 0; var13 < 10; ++var13) {
            int var14 = var4.nextInt(2 * par1) - par1;
            int var15;
            if (entity.posY > 60.0) {
                var15 = var4.nextInt(2 * par2) - par2 * 3 / 2;
            }
            else if (entity.posY < 62.0) {
                var15 = var4.nextInt(2 * par2) - par2 / 2;
            }
            else {
                var15 = var4.nextInt(2 * par2) - par2;
            }
            int var16 = var4.nextInt(2 * par1) - par1;
            if (par3Vec3 == null || var14 * par3Vec3.xCoord + var16 * par3Vec3.zCoord >= 0.0) {
                var14 += MathHelper.floor_double(entity.posX);
                var15 += MathHelper.floor_double(entity.posY);
                var16 += MathHelper.floor_double(entity.posZ);
                if (!var12 || entity.isWithinHomeDistance(var14, var15, var16)) {
                    final float var17 = entity.getBlockPathWeight(var14, var15, var16);
                    if (var17 > var9) {
                        var9 = var17;
                        var6 = var14;
                        var7 = var15;
                        var8 = var16;
                        var5 = true;
                    }
                }
            }
        }
        if (var5) {
            return Vec3.createVectorHelper((double)var6, (double)var7, (double)var8);
        }
        return null;
    }

    static {
        RandomPositionGenerator.staticVector = Vec3.createVectorHelper(0.0, 0.0, 0.0);
    }
}
