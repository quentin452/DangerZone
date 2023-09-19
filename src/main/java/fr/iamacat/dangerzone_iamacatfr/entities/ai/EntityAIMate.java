
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericBreedableInstance;

public class EntityAIMate extends EntityAIBase {

    private GenericBreedableInstance theAnimal;
    World theWorld;
    private GenericBreedableInstance targetMate;
    int spawnBabyDelay;
    float moveSpeed;
    boolean shouldHop;
    int slimeJumpDelay;

    public EntityAIMate(final GenericBreedableInstance par1EntityAnimal, final float par2) {
        this.spawnBabyDelay = 0;
        this.shouldHop = false;
        this.slimeJumpDelay = 0;
        this.theAnimal = par1EntityAnimal;
        this.theWorld = par1EntityAnimal.worldObj;
        this.moveSpeed = par2;
        this.setMutexBits(3);
    }

    public EntityAIMate(final GenericBreedableInstance par1EntityAnimal, final float par2, final boolean shouldHop) {
        this(par1EntityAnimal, par2);
        this.shouldHop = shouldHop;
    }

    public boolean shouldExecute() {
        if (!this.theAnimal.isInLove()) {
            return false;
        }
        this.targetMate = this.getNearbyMate();
        return this.targetMate != null;
    }

    public boolean continueExecuting() {
        if (this.shouldHop) {
            this.tryToHop();
        }
        return this.targetMate.isEntityAlive() && this.targetMate.isInLove() && this.spawnBabyDelay < 60;
    }

    public void resetTask() {
        this.targetMate = null;
        this.spawnBabyDelay = 0;
    }

    public void updateTask() {
        this.theAnimal.getLookHelper()
            .setLookPositionWithEntity((Entity) this.targetMate, 10.0f, (float) this.theAnimal.getVerticalFaceSpeed());
        this.theAnimal.getNavigator()
            .tryMoveToEntityLiving((Entity) this.targetMate, (double) this.moveSpeed);
        ++this.spawnBabyDelay;
        if (this.shouldHop) {
            this.tryToHop();
        }
        if (this.spawnBabyDelay == 60) {
            this.spawnBaby();
        }
    }

    private GenericBreedableInstance getNearbyMate() {
        final float var1 = 8.0f;
        final List<GenericBreedableInstance> var2 = this.theWorld.getEntitiesWithinAABB(
            this.theAnimal.getClass(),
            this.theAnimal.boundingBox.expand((double) var1, (double) var1, (double) var1));
        for (final GenericBreedableInstance var4 : var2) {
            if (this.theAnimal.canMateWith(var4)) {
                return var4;
            }
        }
        return null;
    }

    private void spawnBaby() {
        final GenericBreedableInstance var1 = this.theAnimal.getBabyAnimalEntity(this.targetMate);
        if (var1 != null) {
            this.theAnimal.setGrowingAge(6000);
            this.targetMate.setGrowingAge(6000);
            this.theAnimal.resetInLove();
            this.targetMate.resetInLove();
            var1.setGrowingAge(-24000);
            var1.setLocationAndAngles(this.theAnimal.posX, this.theAnimal.posY, this.theAnimal.posZ, 0.0f, 0.0f);
            this.theWorld.spawnEntityInWorld((Entity) var1);
            final Random var2 = this.theAnimal.getRNG();
            for (int var3 = 0; var3 < 7; ++var3) {
                final double var4 = var2.nextGaussian() * 0.02;
                final double var5 = var2.nextGaussian() * 0.02;
                final double var6 = var2.nextGaussian() * 0.02;
                this.theWorld.spawnParticle(
                    "heart",
                    this.theAnimal.posX + var2.nextFloat() * this.theAnimal.width * 2.0f - this.theAnimal.width,
                    this.theAnimal.posY + 0.5 + var2.nextFloat() * this.theAnimal.height,
                    this.theAnimal.posZ + var2.nextFloat() * this.theAnimal.width * 2.0f - this.theAnimal.width,
                    var4,
                    var5,
                    var6);
            }
            this.theWorld.spawnEntityInWorld(
                (Entity) new EntityXPOrb(
                    this.theWorld,
                    this.theAnimal.posX,
                    this.theAnimal.posY,
                    this.theAnimal.posZ,
                    var2.nextInt(4) + 1));
        }
    }

    public void tryToHop() {
        if (this.theAnimal.onGround && this.slimeJumpDelay-- <= 0) {
            this.slimeJumpDelay = this.getJumpDelay();
            this.theAnimal.getJumpHelper()
                .setJumping();
            this.theAnimal.getNavigator()
                .setSpeed((double) this.moveSpeed);
        } else {
            this.theAnimal.getNavigator()
                .setSpeed(0.0);
        }
    }

    protected int getJumpDelay() {
        return this.theAnimal.getRNG()
            .nextInt(20) + 10;
    }
}
