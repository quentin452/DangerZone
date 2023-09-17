

package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAISwimmingEntity extends EntityAIBase
{
    private EntityLiving field_46106_a;

    public EntityAISwimmingEntity(final EntityLiving par1EntityLiving) {
        this.field_46106_a = par1EntityLiving;
        this.setMutexBits(4);
        par1EntityLiving.getNavigator().setCanSwim(true);
    }

    public boolean shouldExecute() {
        return this.field_46106_a.isInWater() || this.field_46106_a.handleLavaMovement();
    }

    public void updateTask() {
        if (this.field_46106_a.getRNG().nextFloat() < 0.5f) {
            this.field_46106_a.getJumpHelper().setJumping();
        }
    }
}
