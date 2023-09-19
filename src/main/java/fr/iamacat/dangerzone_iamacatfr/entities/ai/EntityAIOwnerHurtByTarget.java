
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericTameableInstance;
import net.minecraft.entity.EntityLivingBase;

public class EntityAIOwnerHurtByTarget extends EntityAITarget {

    GenericTameableInstance theDefendingTameable;
    EntityLivingBase theOwnerAttacker;

    public EntityAIOwnerHurtByTarget(final GenericTameableInstance par1EntityTameable) {
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
        this.theOwnerAttacker = var1.getAITarget();
        return this.isSuitableTarget(this.theOwnerAttacker, false);
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.theOwnerAttacker);
        super.startExecuting();
    }
}
