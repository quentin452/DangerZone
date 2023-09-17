
package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericTameable;

import net.minecraft.entity.EntityLivingBase;

public class EntityAIOwnerHurtByTarget extends EntityAITarget
{
    EntityGenericTameable theDefendingTameable;
    EntityLivingBase theOwnerAttacker;

    public EntityAIOwnerHurtByTarget(final EntityGenericTameable par1EntityTameable) {
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
