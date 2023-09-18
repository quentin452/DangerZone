
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityGenericCreature;

public class EntityAIFleeSun extends EntityAIBase {

    private EntityGenericCreature theCreature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private double movementSpeed;
    private World theWorld;

    public EntityAIFleeSun(final EntityGenericCreature p_i1623_1_, final double p_i1623_2_) {
        this.theCreature = p_i1623_1_;
        this.movementSpeed = p_i1623_2_;
        this.theWorld = p_i1623_1_.worldObj;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        if (!this.theWorld.isDaytime()) {
            return false;
        }
        if (!this.theCreature.isBurning()) {
            return false;
        }
        if (!this.theWorld.canBlockSeeTheSky(
            MathHelper.floor_double(this.theCreature.posX),
            (int) this.theCreature.boundingBox.minY,
            MathHelper.floor_double(this.theCreature.posZ))) {
            return false;
        }
        final Vec3 vec3 = this.findPossibleShelter();
        if (vec3 == null) {
            return false;
        }
        this.shelterX = vec3.xCoord;
        this.shelterY = vec3.yCoord;
        this.shelterZ = vec3.zCoord;
        return true;
    }

    public boolean continueExecuting() {
        return !this.theCreature.getNavigator()
            .noPath();
    }

    public void startExecuting() {
        this.theCreature.getNavigator()
            .tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.movementSpeed);
    }

    private Vec3 findPossibleShelter() {
        final Random random = this.theCreature.getRNG();
        for (int i = 0; i < 10; ++i) {
            final int j = MathHelper.floor_double(this.theCreature.posX + random.nextInt(20) - 10.0);
            final int k = MathHelper.floor_double(this.theCreature.boundingBox.minY + random.nextInt(6) - 3.0);
            final int l = MathHelper.floor_double(this.theCreature.posZ + random.nextInt(20) - 10.0);
            if (!this.theWorld.canBlockSeeTheSky(j, k, l) && this.theCreature.getBlockPathWeight(j, k, l) < 0.0f) {
                return Vec3.createVectorHelper((double) j, (double) k, (double) l);
            }
        }
        return null;
    }
}
