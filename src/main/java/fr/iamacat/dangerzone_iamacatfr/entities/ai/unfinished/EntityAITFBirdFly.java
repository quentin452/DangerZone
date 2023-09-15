package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import net.minecraft.entity.ai.EntityAIBase;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TinyBirdsInstance;

public class EntityAITFBirdFly extends EntityAIBase {

    private TinyBirdsInstance entity;

    public EntityAITFBirdFly(TinyBirdsInstance par1EntityCreature) {
        this.entity = par1EntityCreature;
        this.setMutexBits(5);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    @Override
    public boolean shouldExecute() {
        return !entity.isBirdLanded();
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    @Override
    public boolean continueExecuting() {
        return !entity.isBirdLanded();
    }

}
