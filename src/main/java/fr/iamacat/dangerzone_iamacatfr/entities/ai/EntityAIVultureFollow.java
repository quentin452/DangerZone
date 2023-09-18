
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.EnumSet;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityStates;

public class EntityAIVultureFollow extends EntityAIBase {

    World worldObj;
    EntityGenericCreature attacker;
    EntityLivingBase entityTarget;
    int attackTick;
    float moveSpeed;
    boolean continuousPathing;
    PathEntity entityPathEntity;
    Class classTarget;
    private int changeDirectionCooldown;
    float attackDistanceSq;
    int heightToFollow;
    private EnumSet<EntityStates> setOfValidStates;

    public EntityAIVultureFollow(final EntityGenericCreature par1EntityLiving, final Class par2Class, final float par3,
        final boolean par4, final float attackDistanceSq) {
        this.heightToFollow = 10;
        this.setOfValidStates = EnumSet.allOf(EntityStates.class);
        this.attackTick = 0;
        this.attacker = par1EntityLiving;
        this.worldObj = par1EntityLiving.worldObj;
        this.moveSpeed = par3;
        this.continuousPathing = par4;
        this.setMutexBits(3);
        this.classTarget = par2Class;
        this.attackDistanceSq = attackDistanceSq;
    }

    public EntityAIVultureFollow(final EntityGenericCreature par1EntityLiving, final Class par2Class, final float par3,
        final boolean par4) {
        this(par1EntityLiving, par2Class, par3, par4, par1EntityLiving.width * 2.0f * par1EntityLiving.width * 2.0f);
    }

    public EntityAIVultureFollow(final EntityGenericCreature par1EntityLiving, final float par2, final boolean par3) {
        this(par1EntityLiving, null, par2, par3);
    }

    public EntityAIVultureFollow(final EntityGenericCreature par1EntityLiving, final float par2, final boolean par3,
        final float attackDistanceSq) {
        this(par1EntityLiving, null, par2, par3, attackDistanceSq);
    }

    public EntityAIVultureFollow setValidStates(final EnumSet<EntityStates> setOfValidStates) {
        this.setOfValidStates = setOfValidStates;
        return this;
    }

    public boolean shouldExecute() {
        final EntityLivingBase var1 = this.attacker.getAttackTarget();
        if (!this.setOfValidStates.contains(this.attacker.getEntityState())) {
            return false;
        }
        if (var1 == null) {
            return false;
        }
        if (this.classTarget != null && !this.classTarget.isAssignableFrom(var1.getClass())) {
            return false;
        }
        this.entityTarget = var1;
        if (this.attacker.isEntityGrounded()) {
            this.entityPathEntity = this.attacker.getNavigator()
                .getPathToEntityLiving(this.entityTarget);
            return this.entityPathEntity != null;
        }
        return this.attacker.setTargetPosition(
            new ChunkCoordinates(
                (int) this.entityTarget.posX,
                (int) this.entityTarget.posY + this.heightToFollow,
                (int) this.entityTarget.posZ));
    }

    public boolean continueExecuting() {
        final EntityLivingBase var1 = this.attacker.getAttackTarget();
        if (var1 == null || !this.entityTarget.isEntityAlive()) {
            return false;
        }
        if (this.continuousPathing) {
            return this.attacker.isWithinHomeDistance(
                MathHelper.floor_double(this.entityTarget.posX),
                MathHelper.floor_double(this.entityTarget.posY),
                MathHelper.floor_double(this.entityTarget.posZ));
        }
        if (this.attacker.isEntityGrounded()) {
            return !this.attacker.getNavigator()
                .noPath();
        }
        return !this.attacker.atTargetPosition() && this.attacker.isTargetPositionValid();
    }

    public void startExecuting() {
        if (this.attacker.isEntityGrounded()) {
            this.attacker.getNavigator()
                .setPath(this.entityPathEntity, (double) this.moveSpeed);
        } else {
            this.attacker.setTargetPosition(
                new ChunkCoordinates(
                    (int) this.entityTarget.posX,
                    (int) (this.entityTarget.posY + this.heightToFollow),
                    (int) this.entityTarget.posZ));
        }
        this.changeDirectionCooldown = 0;
    }

    public void resetTask() {
        this.entityTarget = null;
        this.attacker.getNavigator()
            .clearPathEntity();
    }

    public void updateTask() {
        this.attacker.getLookHelper()
            .setLookPositionWithEntity((Entity) this.entityTarget, 30.0f, 30.0f);
        if ((this.continuousPathing || this.attacker.getEntitySenses()
            .canSee((Entity) this.entityTarget)) && --this.changeDirectionCooldown <= 0) {
            this.changeDirectionCooldown = 4 + this.attacker.getRNG()
                .nextInt(7);
            if (this.attacker.isEntityGrounded()) {
                this.attacker.getNavigator()
                    .tryMoveToEntityLiving((Entity) this.entityTarget, (double) this.moveSpeed);
            } else {
                this.attacker.setTargetPosition(
                    new ChunkCoordinates(
                        (int) this.entityTarget.posX,
                        (int) (this.entityTarget.posY + this.heightToFollow),
                        (int) this.entityTarget.posZ));
            }
        }
        this.attackTick = Math.max(this.attackTick - 1, 0);
        final double var1 = this.attackDistanceSq;
        if (this.attacker
            .getDistanceSq(this.entityTarget.posX, this.entityTarget.boundingBox.minY, this.entityTarget.posZ) <= var1
            && this.attackTick <= 0) {
            this.attackTick = 20;
            if (this.attacker.getHeldItem() != null) {
                this.attacker.swingItem();
            }
            this.attacker.attackEntityAsMob((Entity) this.entityTarget);
        }
    }
}
