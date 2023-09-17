
package fr.iamacat.dangerzone_iamacatfr.entities.ai.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

public class EntityAIWander extends EntityAIBase
{
    private EntityGenericCreature entity;
    private double xPosition;
    private double yPosition;
    private double zPosition;
    private float speed;
    private int chanceToMove;
    boolean shouldHop;
    int slimeJumpDelay;

    public EntityAIWander(final EntityGenericCreature par1EntityCreature, final float speed, final int chanceToMove) {
        this.shouldHop = false;
        this.slimeJumpDelay = 0;
        this.entity = par1EntityCreature;
        this.speed = speed;
        this.setMutexBits(1);
        this.chanceToMove = chanceToMove;
    }

    public EntityAIWander(final EntityGenericCreature par1EntityCreature, final float speed, final int chanceToMove, final boolean shouldHop) {
        this(par1EntityCreature, speed, chanceToMove);
        this.shouldHop = shouldHop;
    }

    public boolean shouldExecute() {
        if (this.entity.getAge() >= 100 && !this.entity.isEntityGrounded()) {
            return false;
        }
        if (this.entity.getRNG().nextInt(this.chanceToMove) != 0) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.findRandomTarget(this.entity, 10, 7);
        if (var1 == null) {
            return false;
        }
        this.xPosition = var1.xCoord;
        this.yPosition = var1.yCoord;
        this.zPosition = var1.zCoord;
        return true;
    }

    public boolean continueExecuting() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        return !this.entity.getNavigator().noPath();
    }

    public void startExecuting() {
        this.entity.getNavigator().tryMoveToXYZ(this.xPosition, this.yPosition, this.zPosition, this.speed);
        if (this.shouldHop) {
            this.tryToHop();
        }
    }

    public void tryToHop() {
        if (this.entity.onGround && this.slimeJumpDelay-- <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            this.entity.getJumpHelper().setJumping();
            this.entity.getNavigator().setSpeed(this.speed);
        }
        else {
            this.entity.getNavigator().setSpeed(0.0);
        }
    }

    protected int getJumpDelay() {
        return this.entity.getRNG().nextInt(20) + 10;
    }
}
