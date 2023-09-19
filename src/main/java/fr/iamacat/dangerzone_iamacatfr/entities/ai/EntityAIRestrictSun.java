
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.ai.EntityAIBase;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericCreatureInstance;

public class EntityAIRestrictSun extends EntityAIBase {

    private GenericCreatureInstance theEntity;

    public EntityAIRestrictSun(final GenericCreatureInstance p_i1652_1_) {
        this.theEntity = p_i1652_1_;
    }

    public boolean shouldExecute() {
        return this.theEntity.worldObj.isDaytime();
    }

    public void startExecuting() {
        this.theEntity.getNavigator()
            .setAvoidSun(true);
    }

    public void resetTask() {
        this.theEntity.getNavigator()
            .setAvoidSun(false);
    }
}
