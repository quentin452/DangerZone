
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.Vec3;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericCreatureInstance;
import fr.iamacat.dangerzone_iamacatfr.util.EntityStates;

public class EntityAIPanic extends EntityAIBase {

    private GenericCreatureInstance theEntityCreature;
    private float speed;
    private double randPosX;
    private double randPosY;
    private double randPosZ;
    boolean shouldHop;
    int slimeJumpDelay;

    public EntityAIPanic(final GenericCreatureInstance par1EntityCreature, final float par2) {
        this.shouldHop = false;
        this.slimeJumpDelay = 0;
        this.theEntityCreature = par1EntityCreature;
        this.speed = par2;
        this.setMutexBits(1);
    }

    public EntityAIPanic(final GenericCreatureInstance par1EntityCreature, final float par2, final boolean shouldHop) {
        this(par1EntityCreature, par2);
        this.shouldHop = shouldHop;
    }

    public boolean shouldExecute() {
        if (this.theEntityCreature.getEntityState() != EntityStates.fleeing) {
            return false;
        }
        final Vec3 var1 = RandomPositionGenerator.findRandomTarget(this.theEntityCreature, 5, 4);
        if (var1 == null) {
            return false;
        }
        this.randPosX = var1.xCoord;
        this.randPosY = var1.yCoord;
        this.randPosZ = var1.zCoord;
        return true;
    }

    public void startExecuting() {
        this.theEntityCreature.getNavigator()
            .tryMoveToXYZ(this.randPosX, this.randPosY, this.randPosZ, (double) this.speed);
        if (this.shouldHop) {
            this.tryToHop();
        }
    }

    public boolean continueExecuting() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        return !this.theEntityCreature.getNavigator()
            .noPath();
    }

    public void resetTask() {
        super.resetTask();
    }

    public void tryToHop() {
        if (this.theEntityCreature.onGround && this.slimeJumpDelay-- <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            this.theEntityCreature.getJumpHelper()
                .setJumping();
            this.theEntityCreature.getNavigator()
                .setSpeed((double) this.speed);
        } else {
            this.theEntityCreature.getNavigator()
                .setSpeed(0.0);
        }
    }

    protected int getJumpDelay() {
        if (this.theEntityCreature.getEntityState() == EntityStates.fleeing) {
            return this.theEntityCreature.getRNG()
                .nextInt(3);
        }
        return this.theEntityCreature.getRNG()
            .nextInt(5) + 2;
    }
}
