
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericAnimalInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericCreatureInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

public class EntityAIMoveTowardsTarget extends EntityAIBase {

    private GenericAnimalInstance theEntity;
    private EntityLivingBase targetEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private float speed;
    private float maxTargetDistance;

    public EntityAIMoveTowardsTarget(final GenericAnimalInstance par1EntityCreature, final float par2,
        final float par3) {
        this.theEntity = par1EntityCreature;
        this.speed = par2;
        this.maxTargetDistance = par3;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        this.targetEntity = this.theEntity.getAttackTarget();
        if (this.targetEntity == null) {
            return false;
        }
        if (this.targetEntity.getDistanceSqToEntity((Entity) this.theEntity)
            > this.maxTargetDistance * this.maxTargetDistance) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.findRandomTargetBlockTowards(
            (GenericCreatureInstance) this.theEntity,
            16,
            7,
            Vec3.createVectorHelper(this.targetEntity.posX, this.targetEntity.posY, this.targetEntity.posZ));
        if (var1 == null) {
            return false;
        }
        this.movePosX = var1.xCoord;
        this.movePosY = var1.yCoord;
        this.movePosZ = var1.zCoord;
        return true;
    }

    public boolean continueExecuting() {
        return !this.theEntity.getNavigator()
            .noPath() && this.targetEntity.isEntityAlive()
            && this.targetEntity.getDistanceSqToEntity((Entity) this.theEntity)
                < this.maxTargetDistance * this.maxTargetDistance;
    }

    public void resetTask() {
        this.targetEntity = null;
    }

    public void startExecuting() {
        this.theEntity.getNavigator()
            .tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, (double) this.speed);
    }
}
