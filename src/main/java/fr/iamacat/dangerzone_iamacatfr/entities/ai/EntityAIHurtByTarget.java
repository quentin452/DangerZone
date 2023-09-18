
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.List;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;

public class EntityAIHurtByTarget extends EntityAITarget {

    boolean shouldCallAllies;
    EntityLivingBase entityPathNavigate;
    int fleeChance;
    EntityGenericCreature genericTaskOwner;

    public EntityAIHurtByTarget(final EntityGenericCreature par1EntityLiving, final boolean shouldCallAllies,
        final boolean shouldCheckSight) {
        super((EntityLiving) par1EntityLiving, 16.0f, shouldCheckSight);
        this.fleeChance = 0;
        this.shouldCallAllies = shouldCallAllies;
        this.setMutexBits(1);
        this.genericTaskOwner = par1EntityLiving;
    }

    public boolean shouldExecute() {
        return this.isSuitableTarget(this.taskOwner.getAITarget(), false);
    }

    @Override
    public boolean continueExecuting() {
        return this.shouldExecute();
    }

    @Override
    public void startExecuting() {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());
        this.entityPathNavigate = this.taskOwner.getAITarget();
        if (this.shouldCallAllies) {
            final List<EntityLiving> var1 = this.taskOwner.worldObj.getEntitiesWithinAABB(
                (Class) this.taskOwner.getClass(),
                AxisAlignedBB
                    .getBoundingBox(
                        this.taskOwner.posX,
                        this.taskOwner.posY,
                        this.taskOwner.posZ,
                        this.taskOwner.posX + 1.0,
                        this.taskOwner.posY + 1.0,
                        this.taskOwner.posZ + 1.0)
                    .expand((double) this.targetDistance, 4.0, (double) this.targetDistance));
            for (final EntityLiving var3 : var1) {
                if (this.taskOwner != var3 && var3.getAttackTarget() == null) {
                    var3.setAttackTarget(this.taskOwner.getAITarget());
                }
            }
        }
        super.startExecuting();
    }

    public void updateTask() {
        this.startExecuting();
    }
}
