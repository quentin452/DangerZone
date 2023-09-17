

package fr.iamacat.dangerzone_iamacatfr.entities.ai;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericWaterMob;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.Vec3;

public class EntityAIWanderSwim extends EntityAIBase
{
    private EntityGenericWaterMob entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private float speed;
    private double maxDepth;

    public EntityAIWanderSwim(final EntityGenericWaterMob par1EntityCreature, final float speed, final double maxDepth) {
        this.entity = par1EntityCreature;
        this.speed = speed;
        this.maxDepth = maxDepth;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (this.entity.getAge() >= 100 && this.entity.isEntityGrounded()) {
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

    public boolean continueExecuting() {
        return this.entity.getRNG().nextInt(100) != 0 && !this.entity.atTargetPosition() && this.entity.isTargetPositionValid();
    }

    public void startExecuting() {
        this.entity.setTargetPosition(new ChunkCoordinates((int)this.xPosition, (int)this.yPosition, (int)this.zPosition));
    }
}
