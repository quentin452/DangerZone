
package danger.orespawn.entities.ai;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import danger.orespawn.entities.entityinstance.EntityCannonFodder;

public class MyEntityAIAvoidEntity extends EntityAIBase {

    private EntityCreature theEntity;
    private double farSpeed;
    private double nearSpeed;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathEntity entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;

    public MyEntityAIAvoidEntity(final EntityCreature par1EntityCreature, final Class par2Class, final float par3,
        final double par4, final double par6) {
        this.theEntity = par1EntityCreature;
        this.targetEntityClass = par2Class;
        this.distanceFromEntity = par3;
        this.farSpeed = par4;
        this.nearSpeed = par6;
        this.entityPathNavigate = par1EntityCreature.getNavigator();
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.theEntity != null && this.theEntity instanceof EntityCannonFodder) {
            final EntityCannonFodder cf = (EntityCannonFodder) this.theEntity;
            if (cf.get_is_activated() != 0) {
                return false;
            }
        }
        if (this.targetEntityClass == EntityPlayer.class) {
            if (this.theEntity instanceof EntityTameable && ((EntityTameable) this.theEntity).isTamed()) {
                return false;
            }
            this.closestLivingEntity = this.theEntity.worldObj
                .getClosestPlayerToEntity(this.theEntity, this.distanceFromEntity);
            if (this.closestLivingEntity == null) {
                return false;
            }
        } else {
            final List list = this.theEntity.worldObj.selectEntitiesWithinAABB(
                this.targetEntityClass,
                this.theEntity.boundingBox.expand(this.distanceFromEntity, 3.0, this.distanceFromEntity),
                IMob.mobSelector);
            if (list.isEmpty()) {
                return false;
            }
            this.closestLivingEntity = (Entity) list.get(0);
        }
        final Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockAwayFrom(
            this.theEntity,
            16,
            7,
            Vec3.createVectorHelper(
                this.closestLivingEntity.posX,
                this.closestLivingEntity.posY,
                this.closestLivingEntity.posZ));
        if (vec3 == null) {
            return false;
        }
        if (this.closestLivingEntity.getDistanceSq(vec3.xCoord, vec3.yCoord, vec3.zCoord)
            < this.closestLivingEntity.getDistanceSqToEntity(this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
        return this.entityPathEntity != null && this.entityPathEntity.isDestinationSame(vec3);
    }

    public boolean continueExecuting() {
        return !this.entityPathNavigate.noPath();
    }

    public void startExecuting() {
        this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
    }

    public void resetTask() {
        this.closestLivingEntity = null;
    }

    public void updateTask() {
        if (this.theEntity.getDistanceSqToEntity(this.closestLivingEntity) < 49.0) {
            this.theEntity.getNavigator()
                .setSpeed(this.nearSpeed);
        } else {
            this.theEntity.getNavigator()
                .setSpeed(this.farSpeed);
        }
    }

    static EntityCreature func_98217_a(final MyEntityAIAvoidEntity par0EntityAIAvoidEntity) {
        return par0EntityAIAvoidEntity.theEntity;
    }
}
