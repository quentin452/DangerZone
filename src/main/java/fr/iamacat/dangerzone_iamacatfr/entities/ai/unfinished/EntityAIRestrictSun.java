

package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIRestrictSun extends EntityAIBase
{
    private EntityGenericCreature theEntity;

    public EntityAIRestrictSun(final EntityGenericCreature p_i1652_1_) {
        this.theEntity = p_i1652_1_;
    }

    public boolean shouldExecute() {
        return this.theEntity.worldObj.isDaytime();
    }

    public void startExecuting() {
        this.theEntity.getNavigator().setAvoidSun(true);
    }

    public void resetTask() {
        this.theEntity.getNavigator().setAvoidSun(false);
    }
}
