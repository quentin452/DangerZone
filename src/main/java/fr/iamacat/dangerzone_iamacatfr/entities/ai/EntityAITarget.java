
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericTameable;

public abstract class EntityAITarget extends EntityAIBase {

    protected EntityLiving taskOwner;
    protected float targetDistance;
    protected boolean shouldCheckSight;
    private boolean nearbyOnly;
    private int pathState;
    private int pathCheckCooldown;
    private int field_75298_g;

    public EntityAITarget(final EntityLiving par1EntityLiving, final float par2, final boolean par3) {
        this(par1EntityLiving, par2, par3, false);
    }

    public EntityAITarget(final EntityLiving par1EntityLiving, final float par2, final boolean par3,
        final boolean par4) {
        this.pathState = 0;
        this.pathCheckCooldown = 0;
        this.field_75298_g = 0;
        this.taskOwner = par1EntityLiving;
        this.targetDistance = par2;
        this.shouldCheckSight = par3;
        this.nearbyOnly = par4;
    }

    public boolean continueExecuting() {
        final EntityLivingBase attackTarget = this.taskOwner.getAttackTarget();
        if (attackTarget == null) {
            return false;
        }
        if (!attackTarget.isEntityAlive()) {
            return false;
        }
        if (this.taskOwner.getDistanceSqToEntity((Entity) attackTarget) > this.targetDistance * this.targetDistance) {
            return false;
        }
        final double followDistance = this.getFollowDistance();
        if (this.taskOwner.getDistanceSqToEntity((Entity) attackTarget) > followDistance * followDistance) {
            return false;
        }
        if (this.shouldCheckSight) {
            if (this.taskOwner.getEntitySenses()
                .canSee((Entity) attackTarget)) {
                this.field_75298_g = 0;
            } else if (++this.field_75298_g > 60) {
                return false;
            }
        }
        return true;
    }

    protected double getFollowDistance() {
        final IAttributeInstance attributeinstance = this.taskOwner
            .getEntityAttribute(SharedMonsterAttributes.followRange);
        return (attributeinstance == null) ? 16.0 : attributeinstance.getAttributeValue();
    }

    public void startExecuting() {
        this.pathState = 0;
        this.pathCheckCooldown = 0;
        this.field_75298_g = 0;
    }

    public void resetTask() {
        this.taskOwner.setAttackTarget((EntityLivingBase) null);
    }

    protected boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this.taskOwner) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (!this.taskOwner.canAttackClass(par1EntityLiving.getClass())) {
            return false;
        }
        if (this.taskOwner instanceof EntityTameable && ((EntityTameable) this.taskOwner).isTamed()) {
            if (par1EntityLiving instanceof EntityTameable && ((EntityTameable) par1EntityLiving).isTamed()) {
                return false;
            }
            if (par1EntityLiving == ((EntityTameable) this.taskOwner).getOwner()) {
                return false;
            }
        } else
            if (this.taskOwner instanceof EntityGenericTameable && ((EntityGenericTameable) this.taskOwner).isTamed()) {
                if (par1EntityLiving instanceof EntityGenericTameable
                    && ((EntityGenericTameable) par1EntityLiving).isTamed()) {
                    return false;
                }
                if (par1EntityLiving == ((EntityGenericTameable) this.taskOwner).getOwner()) {
                    return false;
                }
            } else if (par1EntityLiving instanceof EntityPlayer && !par2
                && ((EntityPlayer) par1EntityLiving).capabilities.disableDamage) {
                    return false;
                }
        if (this.taskOwner instanceof EntityGenericCreature
            && !((EntityGenericCreature) this.taskOwner).isWithinHomeDistance(
                MathHelper.floor_double(par1EntityLiving.posX),
                MathHelper.floor_double(par1EntityLiving.posY),
                MathHelper.floor_double(par1EntityLiving.posZ))) {
            return false;
        }
        if (this.taskOwner instanceof EntityCreature && !((EntityCreature) this.taskOwner).isWithinHomeDistance(
            MathHelper.floor_double(par1EntityLiving.posX),
            MathHelper.floor_double(par1EntityLiving.posY),
            MathHelper.floor_double(par1EntityLiving.posZ))) {
            return false;
        }
        if (this.shouldCheckSight && !this.taskOwner.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (this.nearbyOnly) {
            if (--this.pathCheckCooldown <= 0) {
                this.pathState = 0;
            }
            if (this.pathState == 0) {
                this.pathState = (this.canEasilyReach(par1EntityLiving) ? 1 : 2);
            }
            if (this.pathState == 2) {
                return false;
            }
        }
        return true;
    }

    private boolean canEasilyReach(final EntityLivingBase par1EntityLiving) {
        this.pathCheckCooldown = 10 + this.taskOwner.getRNG()
            .nextInt(5);
        final PathEntity var2 = this.taskOwner.getNavigator()
            .getPathToEntityLiving((Entity) par1EntityLiving);
        if (var2 == null) {
            return false;
        }
        final PathPoint var3 = var2.getFinalPathPoint();
        if (var3 == null) {
            return false;
        }
        final int var4 = var3.xCoord - MathHelper.floor_double(par1EntityLiving.posX);
        final int var5 = var3.zCoord - MathHelper.floor_double(par1EntityLiving.posZ);
        return var4 * var4 + var5 * var5 <= 2.25;
    }
}
