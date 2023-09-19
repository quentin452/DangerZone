package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.GhostInstance;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIGhostFly extends EntityAIBase {

    private final GhostInstance entity;

    public EntityAIGhostFly(GhostInstance par1EntityCreature) {
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
