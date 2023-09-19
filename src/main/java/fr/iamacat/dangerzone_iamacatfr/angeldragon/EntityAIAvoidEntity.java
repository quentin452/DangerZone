
package fr.iamacat.dangerzone_iamacatfr.angeldragon;

import java.util.List;

import net.minecraft.command.IEntitySelector;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.util.Vec3;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.RandomPositionGenerator;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericCreatureInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericTameableInstance;
import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;

public class EntityAIAvoidEntity extends EntityAIBase {

    public final IEntitySelector field_98218_a;
    private GenericCreatureInstance theEntity;
    private double farSpeed;
    private double nearSpeed;
    private Entity closestLivingEntity;
    private float distanceFromEntity;
    private PathEntity entityPathEntity;
    private PathNavigate entityPathNavigate;
    private Class targetEntityClass;
    private boolean shouldHop;
    private int slimeJumpDelay;

    public EntityAIAvoidEntity(final GenericCreatureInstance par1, final Class par2, final float par3, final double par4,
                               final double par5) {
        this.field_98218_a = (IEntitySelector) new IEntitySelector() {

            public boolean isEntityApplicable(final Entity p_82704_1_) {
                return p_82704_1_.isEntityAlive() && EntityAIAvoidEntity.this.theEntity.getEntitySenses()
                    .canSee(p_82704_1_);
            }
        };
        this.shouldHop = false;
        this.slimeJumpDelay = 0;
        this.theEntity = par1;
        this.targetEntityClass = par2;
        this.distanceFromEntity = par3;
        this.farSpeed = par4;
        this.nearSpeed = par5;
        this.entityPathNavigate = par1.getNavigator();
        this.setMutexBits(1);
    }

    public EntityAIAvoidEntity(final GenericCreatureInstance par1, final Class par2, final float par3, final double par4,
                               final double par5, final boolean shouldHop) {
        this(par1, par2, par3, par4, par5);
        this.shouldHop = shouldHop;
    }

    public boolean shouldExecute() {
        if (this.targetEntityClass == EntityPlayer.class) {
            if (this.theEntity instanceof GenericTameableInstance && ((GenericTameableInstance) this.theEntity).isTamed()) {
                return false;
            }
            this.closestLivingEntity = (Entity) this.theEntity.worldObj
                .getClosestPlayerToEntity((Entity) this.theEntity, (double) this.distanceFromEntity);
            if (this.closestLivingEntity == null) {
                return false;
            }
        } else {
            final List<Entity> list = this.theEntity.worldObj.selectEntitiesWithinAABB(
                this.targetEntityClass,
                this.theEntity.boundingBox
                    .expand((double) this.distanceFromEntity, 3.0, (double) this.distanceFromEntity),
                this.field_98218_a);
            if (list.isEmpty()) {
                return false;
            }
            this.closestLivingEntity = list.get(0);
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
            < this.closestLivingEntity.getDistanceSqToEntity((Entity) this.theEntity)) {
            return false;
        }
        this.entityPathEntity = this.entityPathNavigate.getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
        return this.entityPathEntity != null && this.entityPathEntity.isDestinationSame(vec3);
    }

    public boolean continueExecuting() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        return !this.entityPathNavigate.noPath();
    }

    public void startExecuting() {
        this.entityPathNavigate.setPath(this.entityPathEntity, this.farSpeed);
        if (this.shouldHop) {
            this.tryToHop();
        }
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

    public void tryToHop() {
        if (this.theEntity.onGround && this.slimeJumpDelay-- <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            this.theEntity.getJumpHelper()
                .setJumping();
            this.theEntity.getNavigator()
                .setSpeed(this.nearSpeed);
        } else {
            this.theEntity.getNavigator()
                .setSpeed(0.0);
        }
    }

    protected int getJumpDelay() {
        if (this.theEntity.getEntityState() == EntityStates.fleeing) {
            return this.theEntity.getRNG()
                .nextInt(3);
        }
        return this.theEntity.getRNG()
            .nextInt(5) + 2;
    }
}
