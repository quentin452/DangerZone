
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.IAnimals;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public abstract class EntityGenericWaterMob extends EntityGenericAnimal implements IAnimals {

    private float randomSpeed;
    private float randomVecX;
    private float randomVecY;
    private float randomVecZ;
    protected int mobInterval;
    protected float mobSpeed;
    private float randomMotionVecX;
    private float randomMotionVecY;
    private float randomMotionVecZ;

    public EntityGenericWaterMob(final World var1) {
        super(var1);
        this.randomSpeed = 0.9f;
        this.randomVecX = 0.0f;
        this.randomVecY = 0.0f;
        this.randomVecZ = 0.0f;
        this.mobInterval = 30;
        this.mobSpeed = 0.3f;
    }

    public boolean isInWater() {
        return this.worldObj.handleMaterialAcceleration(
            this.boundingBox.expand(0.0, -0.6000000238418579, 0.0),
            Material.water,
            (Entity) this);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected boolean canDespawn() {
        return true;
    }

    protected int getExperiencePoints(final EntityPlayer p_70693_1_) {
        return 1 + this.worldObj.rand.nextInt(3);
    }

    public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();
        if (this.isEntityAlive() && !this.isInWater()) {
            --i;
            this.setAir(i);
            if (this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.drown, 2.0f);
            }
        } else {
            this.setAir(300);
        }
    }

    public boolean isTargetPositionValid() {
        return this.isTargetPositionValid(this.targetPosition);
    }

    public boolean isTargetPositionValid(final ChunkCoordinates targetPosition) {
        return targetPosition == null
            || (!this.worldObj.isAirBlock(targetPosition.posX, targetPosition.posY, targetPosition.posZ)
                && this.worldObj.getBlock(targetPosition.posX, targetPosition.posY, targetPosition.posZ)
                    .getMaterial()
                    .equals(Material.water));
    }

    protected void updateAITasks() {
        if (!this.isEntityGrounded() && this.targetPosition != null && this.inWater) {
            final double var1 = this.targetPosition.posX + 0.5 - this.posX;
            final double var2 = this.targetPosition.posY + 0.6 - this.posY;
            final double var3 = this.targetPosition.posZ + 0.5 - this.posZ;
            this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.10000000149011612 * 0.3;
            this.motionY += (Math.signum(var2) * 0.6 - this.motionY) * 0.10000000149011612 * 0.3;
            this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.10000000149011612 * 0.3;
            final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
            final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
            this.moveForward = 0.5f;
            this.rotationYaw += var5;
        } else if (!this.isInWater()) {
            this.rotationPitch = 0.0f;
            if (this.onGround && this.rand.nextInt(30) == 0) {
                this.motionY = 0.30000001192092896;
                this.motionX = -0.4f + this.rand.nextFloat() * 0.8f;
                this.motionZ = -0.4f + this.rand.nextFloat() * 0.8f;
            }
        }
        if (this.entityAge > 100) {
            final float randomMotionVecX = 0.0f;
            this.randomMotionVecZ = randomMotionVecX;
            this.randomMotionVecY = randomMotionVecX;
            this.randomMotionVecX = randomMotionVecX;
        } else if (this.rand.nextInt(50) == 0 || !this.inWater
            || (this.randomMotionVecX == 0.0f && this.randomMotionVecY == 0.0f && this.randomMotionVecZ == 0.0f)) {
                final float f = this.rand.nextFloat() * 3.1415927f * 2.0f;
                this.randomMotionVecX = MathHelper.cos(f) * 0.2f;
                this.randomMotionVecY = -0.1f + this.rand.nextFloat() * 0.2f;
                this.randomMotionVecZ = MathHelper.sin(f) * 0.2f;
            }
        super.updateAITasks();
    }

    public boolean setTargetPosition(final ChunkCoordinates targetPosition) {
        if (this.isTargetPositionValid(targetPosition)) {
            this.targetPosition = targetPosition;
            return true;
        }
        return false;
    }

    public boolean atTargetPosition() {
        return this.targetPosition == null || this.getDistance(
            (double) this.targetPosition.posX,
            (double) this.targetPosition.posY,
            (double) this.targetPosition.posZ) < 2.0;
    }
}
