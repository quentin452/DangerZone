
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericAnimal;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityStates;

public class EntityAIFollowOwner extends EntityAIBase {

    private EntityGenericAnimal thePet;
    private EntityLivingBase theOwner;
    World theWorld;
    private float moveSpeed;
    private PathNavigate petPathfinder;
    private int field_75343_h;
    float maxDist;
    float minDist;
    private boolean field_75344_i;

    public EntityAIFollowOwner(final EntityGenericAnimal par1EntityTameable, final float par2, final float par3,
        final float par4) {
        this.thePet = par1EntityTameable;
        this.theWorld = par1EntityTameable.worldObj;
        this.moveSpeed = par2;
        this.petPathfinder = par1EntityTameable.getNavigator();
        this.minDist = par3;
        this.maxDist = par4;
        this.setMutexBits(3);
    }

    public boolean shouldExecute() {
        final EntityLivingBase var1 = this.thePet.getOwner();
        if (var1 == null) {
            return false;
        }
        if (this.thePet.getEntityState() != EntityStates.following) {
            return false;
        }
        if (this.thePet.getDistanceSqToEntity(var1) < this.minDist * this.minDist) {
            return false;
        }
        this.theOwner = var1;
        return true;
    }

    public boolean continueExecuting() {
        return !this.petPathfinder.noPath()
            && this.thePet.getDistanceSqToEntity((Entity) this.theOwner) > this.maxDist * this.maxDist
            && !this.thePet.isSitting();
    }

    public void startExecuting() {
        this.field_75343_h = 0;
        this.field_75344_i = this.thePet.getNavigator()
            .getAvoidsWater();
        this.thePet.getNavigator()
            .setAvoidsWater(false);
    }

    public void resetTask() {
        this.theOwner = null;
        this.petPathfinder.clearPathEntity();
        this.thePet.getNavigator()
            .setAvoidsWater(this.field_75344_i);
    }

    public void updateTask() {
        this.thePet.getLookHelper()
            .setLookPositionWithEntity((Entity) this.theOwner, 10.0f, (float) this.thePet.getVerticalFaceSpeed());
        if (!this.thePet.isSitting() && --this.field_75343_h <= 0) {
            this.field_75343_h = 10;
            if (!this.petPathfinder.tryMoveToEntityLiving((Entity) this.theOwner, (double) this.moveSpeed)
                && this.thePet.getDistanceSqToEntity((Entity) this.theOwner) >= 144.0) {
                final int var1 = MathHelper.floor_double(this.theOwner.posX) - 2;
                final int var2 = MathHelper.floor_double(this.theOwner.posZ) - 2;
                final int var3 = MathHelper.floor_double(this.theOwner.boundingBox.minY);
                for (int var4 = 0; var4 <= 4; ++var4) {
                    for (int var5 = 0; var5 <= 4; ++var5) {
                        if ((var4 < 1 || var5 < 1 || var4 > 3 || var5 > 3)
                            && World.doesBlockHaveSolidTopSurface(
                                (IBlockAccess) this.theWorld,
                                var1 + var4,
                                var3 - 1,
                                var2 + var5)
                            && !this.theWorld.getBlock(var1 + var4, var3, var2 + var5)
                                .isNormalCube()
                            && !this.theWorld.getBlock(var1 + var4, var3 + 1, var2 + var5)
                                .isNormalCube()) {
                            this.thePet.setLocationAndAngles(
                                (double) (var1 + var4 + 0.5f),
                                (double) var3,
                                (double) (var2 + var5 + 0.5f),
                                this.thePet.rotationYaw,
                                this.thePet.rotationPitch);
                            this.petPathfinder.clearPathEntity();
                            return;
                        }
                    }
                }
            }
        }
    }
}
