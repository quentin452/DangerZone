package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public class EntityAIWatchTarget extends EntityAIBase
{
	private EntityLiving theWatcher;
	protected Entity targetEntity;
	private float maxDistance;
	private int lookTime;

	public EntityAIWatchTarget(EntityLiving watcher, float dist)
	{
		this.theWatcher = watcher;
		this.maxDistance = dist;
		this.setMutexBits(2);
	}

	@Override
	public boolean shouldExecute()
	{
		if (this.theWatcher.getAttackTarget() == null)
		{
			return false;
		}
		else
		{
			this.targetEntity = this.theWatcher.getAttackTarget();
			return true;
		}
	}

	@Override
	public boolean continueExecuting()
	{
		return !this.targetEntity.isEntityAlive() ? false : (this.theWatcher.getDistanceSqToEntity(this.targetEntity) > this.maxDistance * this.maxDistance ? false : this.lookTime > 0);
	}

	@Override
	public void startExecuting()
	{
		this.lookTime = 120 + this.theWatcher.getRNG().nextInt(40);
	}

	@Override
	public void resetTask()
	{
		this.targetEntity = null;
	}

	@Override
	public void updateTask()
	{
		this.theWatcher.getLookHelper().setLookPosition(this.targetEntity.posX, this.targetEntity.posY + this.targetEntity.getEyeHeight(), this.targetEntity.posZ, 10.0F, this.theWatcher.getVerticalFaceSpeed());
		--this.lookTime;
	}
}
