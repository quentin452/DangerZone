
package fr.iamacat.dangerzone_iamacatfr.entities.ai;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GenericCreatureInstance;

public class EntityAIMoveThroughVillage extends EntityAIBase {

    private GenericCreatureInstance theEntity;
    private double movementSpeed;
    private PathEntity entityPathNavigate;
    private VillageDoorInfo doorInfo;
    private boolean isNocturnal;
    private List<VillageDoorInfo> doorList;

    public EntityAIMoveThroughVillage(final GenericCreatureInstance p_i1638_1_, final double p_i1638_2_,
                                      final boolean p_i1638_4_) {
        this.doorList = new ArrayList<VillageDoorInfo>();
        this.theEntity = p_i1638_1_;
        this.movementSpeed = p_i1638_2_;
        this.isNocturnal = p_i1638_4_;
        this.setMutexBits(1);
    }

    public boolean shouldExecute() {
        this.func_75414_f();
        if (this.isNocturnal && this.theEntity.worldObj.isDaytime()) {
            return false;
        }
        final Village village = this.theEntity.worldObj.villageCollectionObj.findNearestVillage(
            MathHelper.floor_double(this.theEntity.posX),
            MathHelper.floor_double(this.theEntity.posY),
            MathHelper.floor_double(this.theEntity.posZ),
            0);
        if (village == null) {
            return false;
        }
        this.doorInfo = this.func_75412_a(village);
        if (this.doorInfo == null) {
            return false;
        }
        final boolean flag = this.theEntity.getNavigator()
            .getCanBreakDoors();
        this.theEntity.getNavigator()
            .setBreakDoors(false);
        this.entityPathNavigate = this.theEntity.getNavigator()
            .getPathToXYZ((double) this.doorInfo.posX, (double) this.doorInfo.posY, (double) this.doorInfo.posZ);
        this.theEntity.getNavigator()
            .setBreakDoors(flag);
        if (this.entityPathNavigate != null) {
            return true;
        }
        final Vec3 vec3 = RandomPositionGenerator.findRandomTargetBlockTowards(
            this.theEntity,
            10,
            7,
            Vec3.createVectorHelper(
                (double) this.doorInfo.posX,
                (double) this.doorInfo.posY,
                (double) this.doorInfo.posZ));
        if (vec3 == null) {
            return false;
        }
        this.theEntity.getNavigator()
            .setBreakDoors(false);
        this.entityPathNavigate = this.theEntity.getNavigator()
            .getPathToXYZ(vec3.xCoord, vec3.yCoord, vec3.zCoord);
        this.theEntity.getNavigator()
            .setBreakDoors(flag);
        return this.entityPathNavigate != null;
    }

    public boolean continueExecuting() {
        if (this.theEntity.getNavigator()
            .noPath()) {
            return false;
        }
        final float f = this.theEntity.width + 4.0f;
        return this.theEntity
            .getDistanceSq((double) this.doorInfo.posX, (double) this.doorInfo.posY, (double) this.doorInfo.posZ)
            > f * f;
    }

    public void startExecuting() {
        this.theEntity.getNavigator()
            .setPath(this.entityPathNavigate, this.movementSpeed);
    }

    public void resetTask() {
        if (this.theEntity.getNavigator()
            .noPath()
            || this.theEntity.getDistanceSq(this.doorInfo.posX, this.doorInfo.posY, (double) this.doorInfo.posZ)
                < 16.0) {
            this.doorList.add(this.doorInfo);
        }
    }

    private VillageDoorInfo func_75412_a(final Village p_75412_1_) {
        VillageDoorInfo villagedoorinfo = null;
        int i = Integer.MAX_VALUE;
        final List<VillageDoorInfo> list = p_75412_1_.getVillageDoorInfoList();
        for (final VillageDoorInfo villagedoorinfo2 : list) {
            final int j = villagedoorinfo2.getDistanceSquared(
                MathHelper.floor_double(this.theEntity.posX),
                MathHelper.floor_double(this.theEntity.posY),
                MathHelper.floor_double(this.theEntity.posZ));
            if (j < i && !this.func_75413_a(villagedoorinfo2)) {
                villagedoorinfo = villagedoorinfo2;
                i = j;
            }
        }
        return villagedoorinfo;
    }

    private boolean func_75413_a(final VillageDoorInfo p_75413_1_) {
        for (final VillageDoorInfo villagedoorinfo1 : this.doorList) {
            if (p_75413_1_.posX == villagedoorinfo1.posX && p_75413_1_.posY == villagedoorinfo1.posY
                && p_75413_1_.posZ == villagedoorinfo1.posZ) {
                return true;
            }
        }
        return false;
    }

    private void func_75414_f() {
        if (this.doorList.size() > 15) {
            this.doorList.remove(0);
        }
    }
}
