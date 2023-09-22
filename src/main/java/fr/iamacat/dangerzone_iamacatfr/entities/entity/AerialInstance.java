
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

// todo add a spawn for this entity
public class AerialInstance extends EntityLiving {

    protected ChunkCoordinates targetPosition;
    protected int maxFlightHeight;

    public boolean setTargetPosition(final ChunkCoordinates targetPosition) {
        if (this.isTargetPositionValid(targetPosition)) {
            this.targetPosition = targetPosition;
            return true;
        }
        return false;
    }

    public int getMaxFlightHeight() {
        return this.maxFlightHeight;
    }

    public AerialInstance(final World par1World) {
        super(par1World);
        this.maxFlightHeight = 20;
    }

    protected void entityInit() {
        super.entityInit();
        if (this.defaultGrounded()) {
            this.dataWatcher.addObject(17, (Object) 1);
        } else {
            this.dataWatcher.addObject(17, (Object) 0);
        }
    }

    public boolean defaultGrounded() {
        return true;
    }

    public boolean isEntityGrounded() {
        return this.dataWatcher.getWatchableObjectInt(17) != 0;
    }

    protected void setEntityGrounded(final Boolean par1) {
        if (par1) {
            this.dataWatcher.updateObject(17, 1);
        } else {
            this.dataWatcher.updateObject(17, 0);
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setInteger("Is Grounded", this.dataWatcher.getWatchableObjectInt(17));
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        if (par1NBTTagCompound.hasKey("Is Grounded")) {
            this.dataWatcher.updateObject(17, (int) par1NBTTagCompound.getByte("Is Grounded"));

        }
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    protected void updateAITasks() {
        if (!this.isEntityGrounded() && this.targetPosition != null) {
            final double var1 = this.targetPosition.posX + 0.5 - this.posX;
            final double var2 = this.targetPosition.posY + 0.1 - this.posY;
            final double var3 = this.targetPosition.posZ + 0.5 - this.posZ;
            this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.10000000149011612 * 0.3;
            this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.10000000149011612 * 0.3;
            this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.10000000149011612 * 0.3;
            final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
            final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
            this.moveForward = 0.5f;
            this.rotationYaw += var5;
        }
        super.updateAITasks();
    }

    protected boolean shouldBeFlying() {
        return false;
    }

    public boolean isTargetPositionValid() {
        return this.isTargetPositionValid(this.targetPosition);
    }

    public boolean isTargetPositionValid(final ChunkCoordinates targetPosition) {
        return targetPosition == null
            || (this.worldObj.isAirBlock(targetPosition.posX, targetPosition.posY, targetPosition.posZ)
                && targetPosition.posY >= 3
                && !this.worldObj.getBlock(targetPosition.posX, targetPosition.posY, targetPosition.posZ)
                    .getMaterial()
                    .equals(Material.water));
    }

    public boolean atTargetPosition() {
        return this.targetPosition == null || this.getDistance(
            (double) this.targetPosition.posX,
            (double) this.targetPosition.posY,
            (double) this.targetPosition.posZ) < 2.0;
    }

    public void moveEntityWithHeading(final float par1, final float par2) {
        if (this.isEntityGrounded()) {
            super.moveEntityWithHeading(par1, par2);
            return;
        }
        if (this.isInWater()) {
            this.moveFlying(par1, par2, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.800000011920929;
            this.motionY *= 0.800000011920929;
            this.motionZ *= 0.800000011920929;
        } else if (this.handleLavaMovement()) {
            this.moveFlying(par1, par2, 0.02f);
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.5;
            this.motionY *= 0.5;
            this.motionZ *= 0.5;
        } else {
            float var3 = 0.91f;
            if (this.onGround) {
                var3 = 0.54600006f;
                final Block block = this.worldObj.getBlock(
                    MathHelper.floor_double(this.posX),
                    MathHelper.floor_double(this.boundingBox.minY) - 1,
                    MathHelper.floor_double(this.posZ));
                if (block != null) {
                    var3 = block.slipperiness * 0.91f;
                }
            }
            final float var4 = 0.16277136f / (var3 * var3 * var3);
            this.moveFlying(par1, par2, this.onGround ? (0.1f * var4) : 0.02f);
            var3 = 0.91f;
            if (this.onGround) {
                var3 = 0.54600006f;
                final Block block2 = this.worldObj.getBlock(
                    MathHelper.floor_double(this.posX),
                    MathHelper.floor_double(this.boundingBox.minY) - 1,
                    MathHelper.floor_double(this.posZ));
                if (block2 != null) {
                    var3 = block2.slipperiness * 0.91f;
                }
            }
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            this.motionX *= var3;
            this.motionY *= var3;
            this.motionZ *= var3;
        }
        this.prevLimbSwingAmount = this.limbSwingAmount;
        final double var5 = this.posX - this.prevPosX;
        final double var6 = this.posZ - this.prevPosZ;
        float var7 = MathHelper.sqrt_double(var5 * var5 + var6 * var6) * 4.0f;
        if (var7 > 1.0f) {
            var7 = 1.0f;
        }
        this.limbSwingAmount += (var7 - this.limbSwingAmount) * 0.4f;
        this.limbSwing += this.limbSwing;
    }

    protected void adjustRotationToWaypoint() {
        final double var8 = this.targetPosition.posX - this.posX;
        final double var9 = this.targetPosition.posZ - this.posZ;
        final float var10 = (float) (Math.atan2(var9, var8) * 180.0 / 3.141592653589793);
        float var11 = MathHelper.wrapAngleTo180_float(var10 - this.rotationYaw);
        if (var11 > 30.0f) {
            var11 = 30.0f;
        }
        if (var11 < -30.0f) {
            var11 = -30.0f;
        }
        final float n = this.rotationYaw + var11;
        this.rotationYaw = n;
        this.renderYawOffset = n;
    }
}
