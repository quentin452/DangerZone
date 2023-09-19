
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.EntityLivingBase;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericTameableInstance;

public class EntityAIOwnerHurtTarget extends EntityAITarget {

    GenericTameableInstance theDefendingTameable;
    EntityLivingBase theTarget;

    public EntityAIOwnerHurtTarget(final GenericTameableInstance par1EntityTameable) {
        super(par1EntityTameable, 32.0f, false);
        this.theDefendingTameable = par1EntityTameable;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (!this.theDefendingTameable.isTamed()) {
            return false;
        }
        final EntityLivingBase var1 = this.theDefendingTameable.getOwner();
        if (var1 == null) {
            return false;
        }
        this.theTarget = var1.getAITarget();
        return this.isSuitableTarget(this.theTarget, false);
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theTarget);
        super.startExecuting();
    }
}
