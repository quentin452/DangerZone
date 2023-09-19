
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericAnimalInstance;
import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIStayStill extends EntityAIBase {

    private GenericAnimalInstance theEntity;
    EntityStates triggeringState;

    public EntityAIStayStill(final GenericAnimalInstance par1EntityTameable, final EntityStates triggeringState) {
        this.theEntity = par1EntityTameable;
        this.setMutexBits(5);
        this.triggeringState = triggeringState;
    }

    public boolean shouldExecute() {
        return !this.theEntity.isInWater() && this.theEntity.onGround
            && this.theEntity.getEntityState() == this.triggeringState;
    }

    public void startExecuting() {
        this.theEntity.getNavigator()
            .clearPathEntity();
    }

    public void resetTask() {}
}
