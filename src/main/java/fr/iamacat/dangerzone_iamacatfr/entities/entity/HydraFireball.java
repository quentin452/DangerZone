
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;

public class HydraFireball extends EntityFireball {

    private int e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    public EntityLivingBase a;
    private int j;
    private int au;
    public double b;
    public double c;
    public double d;
    public int field_92012_e;
    private int size4;

    public HydraFireball(final World par1World) {
        super(par1World);
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = 0;
        this.i = false;
        this.au = 0;
        this.field_92012_e = 1;
        this.size4 = 0;
        this.setSize(2.0f, 2.0f);
    }

    protected void entityInit() {}

    public HydraFireball(final World par1World, final EntityLivingBase par2EntityLiving, final double par3,
        final double par5, final double par7) {
        super(par1World);
        this.e = -1;
        this.f = -1;
        this.g = -1;
        this.h = 0;
        this.i = false;
        this.au = 0;
        this.field_92012_e = 1;
        this.size4 = 0;
        this.a = par2EntityLiving;
        this.setSize(1.0f, 1.0f);
        this.setLocationAndAngles(
            par2EntityLiving.posX,
            par2EntityLiving.posY,
            par2EntityLiving.posZ,
            par2EntityLiving.rotationYaw,
            par2EntityLiving.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        final double motionX = 0.0;
        this.motionZ = motionX;
        this.motionY = motionX;
        this.motionX = motionX;
        final double var9 = MathHelper.sqrt_double(par3 * par3 + par5 * par5 + par7 * par7);
        this.b = par3 / var9 * 0.1;
        this.c = par5 / var9 * 0.1;
        this.d = par7 / var9 * 0.1;
    }

    public void sizeBig() {
        this.size4 = 1;
        this.field_92012_e = 16;
    }

    public void onUpdate() {
        Vec3 var15 = null;
        Vec3 var16 = null;
        MovingObjectPosition var17 = null;
        Entity var18 = null;
        List var19 = null;
        double var20 = 0.0;
        Entity var21 = null;
        final float var22 = 0.3f;
        double var23 = 0.0;
        float var24 = 0.0f;
        float var25 = 0.0f;
        float var26 = 0.0f;
        if (this.j >= 600 || this.au >= 600) {
            this.setDead();
            return;
        }
        if (!this.worldObj.isRemote && ((this.a != null && this.a.isDead)
            || !this.worldObj.blockExists((int) this.posX, (int) this.posY, (int) this.posZ))) {
            this.setDead();
        } else {
            super.onUpdate();
            this.setFire(1);
            if (this.i) {
                final Block var27 = this.worldObj.getBlock(this.e, this.f, this.g);
                if (var27 != Blocks.air) {
                    ++this.au;
                }
                this.i = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
            } else {
                ++this.au;
            }
            var15 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            var16 = Vec3
                .createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            var17 = this.worldObj.rayTraceBlocks(var15, var16, false);
            var15 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            var16 = Vec3
                .createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (var17 != null) {
                var16 = Vec3.createVectorHelper(var17.hitVec.xCoord, var17.hitVec.yCoord, var17.hitVec.zCoord);
            }
            var18 = null;
            var19 = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                (Entity) this,
                this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
                    .expand(1.0, 1.0, 1.0));
            var20 = 0.0;
            for (int var28 = 0; var28 < var19.size(); ++var28) {
                var21 = (Entity) var19.get(var28);
                if (this.a == var21) {
                    var17 = null;
                    break;
                }
                if (var21 instanceof HydraFireball) {
                    var17 = null;
                    break;
                }
                if (var21 instanceof MyMLPHydra) {
                    var17 = null;
                    break;
                }
                if (MobUtils.isPony(var21)) {
                    var17 = null;
                    break;
                }
                if (this.size4 != 0 && (var21 instanceof EntityPlayer || var21 instanceof MyFlameDragon
                    || var21 instanceof MyTwilicorn)) {
                    var17 = null;
                    break;
                }
                if (var21.canBeCollidedWith() && (!var21.isEntityEqual((Entity) this.a) || this.au >= 25)) {
                    final AxisAlignedBB var29 = var21.boundingBox
                        .expand((double) var22, (double) var22, (double) var22);
                    final MovingObjectPosition var30 = var29.calculateIntercept(var15, var16);
                    if (var30 != null) {
                        var23 = var15.distanceTo(var30.hitVec);
                        if (var23 < var20 || var20 == 0.0) {
                            var18 = var21;
                            var20 = var23;
                        }
                    }
                }
            }
            if (var18 != null) {
                var17 = new MovingObjectPosition(var18);
            }
            if (var17 != null) {
                this.onImpact(var17);
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            var24 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) + 90.0f;
            this.rotationPitch = (float) (Math.atan2(var24, this.motionY) * 180.0 / 3.141592653589793) - 90.0f;
            while (this.rotationPitch - this.prevRotationPitch < -180.0f) {
                this.prevRotationPitch -= 360.0f;
            }
            while (this.rotationPitch - this.prevRotationPitch >= 180.0f) {
                this.prevRotationPitch += 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0f) {
                this.prevRotationYaw -= 360.0f;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0f) {
                this.prevRotationYaw += 360.0f;
            }
            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2f;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2f;
            var25 = this.getMotionFactor();
            if (this.isInWater()) {
                for (int var31 = 0; var31 < 4; ++var31) {
                    var26 = 0.25f;
                    this.worldObj.spawnParticle(
                        "bubble",
                        this.posX - this.motionX * var26,
                        this.posY - this.motionY * var26,
                        this.posZ - this.motionZ * var26,
                        this.motionX,
                        this.motionY,
                        this.motionZ);
                }
                var25 = 0.8f;
            }
            this.motionX += this.b;
            this.motionY += this.c;
            this.motionZ += this.d;
            this.motionX *= var25;
            this.motionY *= var25;
            this.motionZ *= var25;
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 0.75, this.posZ, 0.0, 0.0, 0.0);
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (par1MovingObjectPosition.entityHit != null) {
                if (par1MovingObjectPosition.entityHit instanceof HydraFireball) {
                    return;
                }
                if (par1MovingObjectPosition.entityHit instanceof MyTwilicorn) {
                    return;
                }
                if (this.size4 != 0 && (par1MovingObjectPosition.entityHit instanceof MyFlameDragon
                    || par1MovingObjectPosition.entityHit instanceof EntityPlayer)) {
                    this.setDead();
                    return;
                }
                par1MovingObjectPosition.entityHit.attackEntityFrom(
                    DamageSource.causeFireballDamage((EntityFireball) this, (Entity) this.a),
                    1850.0f);
                par1MovingObjectPosition.entityHit.setFire(60);
            } else {
                int i = par1MovingObjectPosition.blockX;
                int j = par1MovingObjectPosition.blockY;
                int k = par1MovingObjectPosition.blockZ;
                switch (par1MovingObjectPosition.sideHit) {
                    case 0: {
                        --j;
                        break;
                    }
                    case 1: {
                        ++j;
                        break;
                    }
                    case 2: {
                        --k;
                        break;
                    }
                    case 3: {
                        ++k;
                        break;
                    }
                    case 4: {
                        --i;
                        break;
                    }
                    case 5: {
                        ++i;
                        break;
                    }
                }
                if (this.worldObj.isAirBlock(i, j, k)) {
                    this.worldObj.setBlock(i, j, k, Blocks.ice);
                }
            }
            this.setDead();
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ExplosionPower", this.field_92012_e);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        if (par1NBTTagCompound.hasKey("ExplosionPower")) {
            this.field_92012_e = par1NBTTagCompound.getInteger("ExplosionPower");
        }
    }
}
