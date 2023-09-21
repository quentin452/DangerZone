
package danger.orespawn.entities.entityinstance;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class UltimateArrow extends EntityArrow {

    private int xTile;
    private int yTile;
    private int zTile;
    private Block inTile;
    private int inData;
    private boolean inGround;
    private int ticksInGround;
    private int ticksInAir;
    private int knockbackStrength;

    public UltimateArrow(final World par1World) {
        super(par1World);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.air;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }

    public UltimateArrow(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.air;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }

    public UltimateArrow(final World par1World, final EntityLiving par2EntityLiving,
        final EntityLivingBase par3EntityLiving, final float par4, final float par5) {
        super(par1World, par2EntityLiving, par3EntityLiving, par4, par5);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.air;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }

    public UltimateArrow(final World par1World, final EntityPlayer par3EntityPlayer, final float par3) {
        super(par1World, par3EntityPlayer, par3);
        this.xTile = -1;
        this.yTile = -1;
        this.zTile = -1;
        this.inTile = Blocks.air;
        this.inData = 0;
        this.inGround = false;
        this.ticksInAir = 0;
    }

    protected void entityInit() {
        this.dataWatcher.addObject(16, (Object) 0);
    }

    public void setThrowableHeading(double par1, double par3, double par5, final float par7, final float par8) {
        final float var9 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= var9;
        par3 /= var9;
        par5 /= var9;
        par1 *= par7;
        par3 *= par7;
        par5 *= par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        final float var10 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        final float n = (float) (Math.atan2(par1, par5) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float) (Math.atan2(par3, var10) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
        this.ticksInGround = 0;
    }

    public void onUpdate() {
        super.onEntityUpdate();
        if (this.prevRotationPitch == 0.0f && this.prevRotationYaw == 0.0f) {
            final float var1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            final float n = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationYaw = n;
            this.prevRotationYaw = n;
            final float n2 = (float) (Math.atan2(this.motionY, var1) * 180.0 / 3.141592653589793);
            this.rotationPitch = n2;
            this.prevRotationPitch = n2;
        }
        final Block var2 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
        if (var2 != Blocks.air) {
            var2.setBlockBoundsBasedOnState((IBlockAccess) this.worldObj, this.xTile, this.yTile, this.zTile);
            final AxisAlignedBB var3 = var2
                .getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
            if (var3 != null && var3.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            --this.arrowShake;
        }
        if (this.inGround) {
            final Block var4 = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
            final int var5 = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if (var4 != Blocks.air) {
                ++this.ticksInGround;
                if (this.ticksInGround == 500) {
                    this.setDead();
                }
            } else {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            ++this.ticksInAir;
            Vec3 var6 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 var7 = Vec3
                .createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition var8 = this.worldObj.rayTraceBlocks(var6, var7, true);
            var6 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            var7 = Vec3
                .createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (var8 != null) {
                var7 = Vec3.createVectorHelper(var8.hitVec.xCoord, var8.hitVec.yCoord, var8.hitVec.zCoord);
            }
            Entity var9 = null;
            final List var10 = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                this,
                this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
                    .expand(1.0, 1.0, 1.0));
            double var11 = 0.0;
            for (int var12 = 0; var12 < var10.size(); ++var12) {
                final Entity var13 = (Entity) var10.get(var12);
                if (var13.canBeCollidedWith() && (var13 != this.shootingEntity || this.ticksInAir >= 5)
                    && !(var13 instanceof Elevator)) {
                    if (var13 instanceof Cephadrome) {
                        final Cephadrome c = (Cephadrome) var13;
                        if (c.riddenByEntity != null) {
                            continue;
                        }
                    }
                    if (var13 instanceof Dragon) {
                        final Dragon c2 = (Dragon) var13;
                        if (c2.riddenByEntity != null) {
                            continue;
                        }
                    }
                    if (var13 instanceof EntityHorse) {
                        final EntityHorse c3 = (EntityHorse) var13;
                        if (c3.riddenByEntity != null) {
                            continue;
                        }
                    }
                    final float var14 = 0.3f;
                    final AxisAlignedBB var15 = var13.boundingBox.expand(var14, var14, var14);
                    final MovingObjectPosition var16 = var15.calculateIntercept(var6, var7);
                    if (var16 != null) {
                        final double var17 = var6.distanceTo(var16.hitVec);
                        if (var17 < var11 || var11 == 0.0) {
                            var9 = var13;
                            var11 = var17;
                        }
                    }
                }
            }
            if (var9 != null) {
                var8 = new MovingObjectPosition(var9);
            }
            if (var8 != null) {
                if (var8.entityHit != null) {
                    final float var18 = MathHelper.sqrt_double(
                        this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    float var19 = (float) MathHelper.ceiling_double_int(var18 * OreSpawnMain.UltimateBowDamage);
                    if (OreSpawnMain.ultimate_sword_pvp == 0) {
                        if (var8.entityHit instanceof EntityPlayer || var8.entityHit instanceof Girlfriend
                            || var8.entityHit instanceof Boyfriend) {
                            final EntityLivingBase e = (EntityLivingBase) var8.entityHit;
                            this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                            e.heal(1.0f);
                            this.setDead();
                            return;
                        }
                        if (var8.entityHit instanceof EntityTameable) {
                            final EntityTameable t = (EntityTameable) var8.entityHit;
                            if (t.isTamed()) {
                                this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                                t.heal(1.0f);
                                this.setDead();
                                return;
                            }
                        }
                    }
                    if (this.getIsCritical()) {
                        var19 += this.rand.nextInt((int) var19 / 2 + 2);
                    }
                    DamageSource var20 = null;
                    if (this.shootingEntity == null) {
                        var20 = DamageSource.causeArrowDamage((EntityArrow) this, this);
                    } else {
                        var20 = DamageSource.causeArrowDamage((EntityArrow) this, this.shootingEntity);
                    }
                    if (this.isBurning()) {
                        var8.entityHit.setFire(5);
                    }
                    if (var8.entityHit.attackEntityFrom(var20, var19)) {
                        if (var8.entityHit instanceof EntityLiving) {
                            final EntityLiving var21 = (EntityLiving) var8.entityHit;
                            if (!this.worldObj.isRemote) {
                                var21.setArrowCountInEntity(var21.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0) {
                                final float var22 = MathHelper
                                    .sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                                if (var22 > 0.0f) {
                                    var8.entityHit.addVelocity(
                                        this.motionX * this.knockbackStrength * 0.6000000238418579 / var22,
                                        0.1,
                                        this.motionZ * this.knockbackStrength * 0.6000000238418579 / var22);
                                }
                            }
                            if (this.shootingEntity != null && var8.entityHit != this.shootingEntity
                                && var8.entityHit instanceof EntityPlayer
                                && this.shootingEntity instanceof EntityPlayerMP) {
                                ((EntityPlayerMP) this.shootingEntity).playerNetServerHandler
                                    .sendPacket((Packet) new S2BPacketChangeGameState(6, 0.0f));
                            }
                        }
                        this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                        this.setDead();
                    } else {
                        this.motionX *= -0.10000000149;
                        this.motionY *= -0.10000000149;
                        this.motionZ *= -0.10000000149;
                        this.rotationYaw += 180.0f;
                        this.prevRotationYaw += 180.0f;
                        this.ticksInAir = 0;
                    }
                } else {
                    this.xTile = var8.blockX;
                    this.yTile = var8.blockY;
                    this.zTile = var8.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (float) (var8.hitVec.xCoord - this.posX);
                    this.motionY = (float) (var8.hitVec.yCoord - this.posY);
                    this.motionZ = (float) (var8.hitVec.zCoord - this.posZ);
                    final float var18 = MathHelper.sqrt_double(
                        this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / var18 * 0.05;
                    this.posY -= this.motionY / var18 * 0.05;
                    this.posZ -= this.motionZ / var18 * 0.05;
                    this.playSound("random.bowhit", 1.0f, 1.2f / (this.rand.nextFloat() * 0.2f + 0.9f));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.setIsCritical(false);
                    if (this.inTile != Blocks.air) {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
                    }
                }
            }
            if (this.getIsCritical()) {
                for (int var12 = 0; var12 < 4; ++var12) {
                    this.worldObj.spawnParticle(
                        "crit",
                        this.posX + this.motionX * var12 / 4.0,
                        this.posY + this.motionY * var12 / 4.0,
                        this.posZ + this.motionZ * var12 / 4.0,
                        -this.motionX,
                        -this.motionY + 0.2,
                        -this.motionZ);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            final float var18 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
            this.rotationPitch = (float) (Math.atan2(this.motionY, var18) * 180.0 / 3.141592653589793);
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
            float var23 = 0.99f;
            final float var14 = 0.05f;
            if (this.isInWater()) {
                for (int var24 = 0; var24 < 4; ++var24) {
                    final float var22 = 0.25f;
                    this.worldObj.spawnParticle(
                        "bubble",
                        this.posX - this.motionX * var22,
                        this.posY - this.motionY * var22,
                        this.posZ - this.motionZ * var22,
                        this.motionX,
                        this.motionY,
                        this.motionZ);
                }
                var23 = 0.8f;
            }
            this.motionX *= var23;
            this.motionY *= var23;
            this.motionZ *= var23;
            this.motionY -= var14;
            this.setPosition(this.posX, this.posY, this.posZ);
            this.func_145775_I();
        }
    }

    public void setKnockbackStrength(final int par1) {
        this.knockbackStrength = par1;
    }

    public void setDamage(final double par1) {}

    public double getDamage() {
        return OreSpawnMain.UltimateBowDamage;
    }
}
