

package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericAnimal;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityStates;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIStayStill extends EntityAIBase
{
    private EntityGenericAnimal theEntity;
    EntityStates triggeringState;

    public EntityAIStayStill(final EntityGenericAnimal par1EntityTameable, final EntityStates triggeringState) {
        this.theEntity = par1EntityTameable;
        this.setMutexBits(5);
        this.triggeringState = triggeringState;
    }

    public boolean shouldExecute() {
        return !this.theEntity.isInWater() && this.theEntity.onGround && this.theEntity.getEntityState() == this.triggeringState;
    }

    public void startExecuting() {
        this.theEntity.getNavigator().clearPathEntity();
    }

    public void resetTask() {
    }
}
