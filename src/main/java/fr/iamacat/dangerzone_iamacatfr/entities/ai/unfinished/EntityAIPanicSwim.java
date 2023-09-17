

package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericWaterMob;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityStates;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;

public class EntityAIPanicSwim extends EntityAIBase
{
    private EntityGenericWaterMob entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private float speed;
    private double maxDepth;
    boolean shouldHop;
    int slimeJumpDelay;

    public EntityAIPanicSwim(final EntityGenericWaterMob par1EntityCreature, final float par2, final double maxDepth) {
        this.shouldHop = false;
        this.slimeJumpDelay = 0;
        this.entity = par1EntityCreature;
        this.speed = par2;
        this.maxDepth = maxDepth;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.entity.getEntityState() != EntityStates.fleeing) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.swimRandomlyTowardHeightLevel(this.entity, 10, 7, this.entity.getMaxFlightHeight());
        if (var1 == null) {
            return false;
        }
        this.xPosition = var1.xCoord;
        this.yPosition = var1.yCoord;
        this.zPosition = var1.zCoord;
        return this.entity.isTargetPositionValid(new ChunkCoordinates((int)this.xPosition, (int)this.yPosition, (int)this.zPosition));
    }

    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
    }

    public boolean continueExecuting() {
        return !this.entity.getNavigator().noPath();
    }

    public void resetTask() {
        super.resetTask();
    }
}
