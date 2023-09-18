
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;

public class EntityAIMoveTowardsRestriction extends EntityAIBase {

    private EntityGenericCreature theEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private float movementSpeed;

    public EntityAIMoveTowardsRestriction(final EntityGenericCreature par1EntityCreature, final float par2) {
        this.theEntity = par1EntityCreature;
        this.movementSpeed = par2;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.theEntity.isWithinHomeDistanceCurrentPosition()) {
            return false;
        }
        final ChunkCoordinates chunkcoordinates = this.theEntity.getHomePosition();
        final Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockTowards(
            this.theEntity,
            16,
            7,
            Vec3.createVectorHelper(
                (double) chunkcoordinates.posX,
                (double) chunkcoordinates.posY,
                (double) chunkcoordinates.posZ));
        if (vec3 == null) {
            return false;
        }
        this.movePosX = vec3.xCoord;
        this.movePosY = vec3.yCoord;
        this.movePosZ = vec3.zCoord;
        return true;
    }

    public boolean continueExecuting() {
        return !this.theEntity.getNavigator()
            .noPath();
    }

    public void startExecuting() {
        this.theEntity.getNavigator()
            .tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, (double) this.movementSpeed);
    }
}
