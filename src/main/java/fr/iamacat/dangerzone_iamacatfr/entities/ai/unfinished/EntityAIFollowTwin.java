package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.AlienInstance;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIFollowTwin extends EntityAIBase
{
	private AlienInstance entityOwner;
	private float speed;
	private int field_75345_d;

    public EntityAIFollowTwin(AlienInstance entity, float par2)
    {
    	this.entityOwner = entity;
        this.speed = par2;
    }

	@Override
	public boolean shouldExecute()
	{
		return !entityOwner.isTwinDead() || this.entityOwner.getAttackTarget() != null;
	}

	public boolean continueExecuting()
    {
        if (this.entityOwner.isTwinDead() || this.entityOwner.getAttackTarget() != null)
            return false;
        else
        {
            double var1 = this.entityOwner.getDistanceSqToEntity(this.entityOwner.getTwin());
            return var1 >= 16.0D/* && var1 <= 256.0D*/;
        }
    }

	public void startExecuting()
    {
        this.field_75345_d = 0;
    }

	public void updateTask()
    {
        if (--this.field_75345_d <= 0)
        {
            this.field_75345_d = 10;
            this.entityOwner.getNavigator().tryMoveToEntityLiving(this.entityOwner.getTwin(), this.speed);
        }
    }
}
