

package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAISmoothSwimming extends EntityAIBase
{
    private EntityLiving theEntity;
    private boolean smootherSwimming;

    public EntityAISmoothSwimming(final EntityLiving par1EntityLiving) {
        this.smootherSwimming = false;
        this.theEntity = par1EntityLiving;
        this.setMutexBits(4);
        par1EntityLiving.getNavigator().setCanSwim(true);
    }

    public EntityAISmoothSwimming(final EntityLiving par1EntityLiving, final boolean smootherSwimming) {
        this(par1EntityLiving);
        this.smootherSwimming = smootherSwimming;
    }

    public boolean shouldExecute() {
        return this.theEntity.isInWater() || this.theEntity.handleLavaMovement();
    }

    public void updateTask() {
        if (this.theEntity.getRNG().nextFloat() < 0.8f) {
            this.theEntity.getJumpHelper().setJumping();
        }
    }
}
