
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFishHook;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.*;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class UltimateFishHook extends EntityFishHook {

    private static final List field_146039_d;
    private static final List field_146041_e;
    private static final List field_146036_f;
    private static final List orespawn_lava_fish;
    private static final List orespawn_fish;
    private int field_146037_g;
    private int field_146048_h;
    private int field_146050_i;
    private Block field_146046_j;
    private boolean field_146051_au;
    private int field_146049_av;
    private int field_146047_aw;
    private int fish_on_hook;
    private int fish_wait_time;
    private int ticks_catchable;
    private float fish_direction;
    public Entity field_146043_c;
    private int field_146055_aB;
    private double field_146056_aC;
    private double field_146057_aD;
    private double field_146058_aE;
    private double field_146059_aF;
    private double field_146060_aG;
    @SideOnly(Side.CLIENT)
    private double field_146061_aH;
    @SideOnly(Side.CLIENT)
    private double field_146052_aI;
    @SideOnly(Side.CLIENT)
    private double field_146053_aJ;
    private int fishing_in_lava;

    public UltimateFishHook(final World par1World) {
        super(par1World);
        this.fishing_in_lava = 0;
        this.field_146037_g = -1;
        this.field_146048_h = -1;
        this.field_146050_i = -1;
        this.setSize(0.25f, 0.25f);
        this.ignoreFrustumCheck = true;
        this.fireResistance = 3000;
        this.isImmuneToFire = true;
    }

    @SideOnly(Side.CLIENT)
    public UltimateFishHook(final World par1World, final double par2, final double par4, final double par6,
        final EntityPlayer par8EntityPlayer) {
        this(par1World);
        this.setPosition(par2, par4, par6);
        this.ignoreFrustumCheck = true;
        this.field_146042_b = par8EntityPlayer;
        par8EntityPlayer.fishEntity = this;
        this.fireResistance = 3000;
        this.isImmuneToFire = true;
    }

    public UltimateFishHook(final World par1World, final EntityPlayer par2EntityPlayer) {
        super(par1World);
        this.fishing_in_lava = 0;
        this.field_146037_g = -1;
        this.field_146048_h = -1;
        this.field_146050_i = -1;
        this.ignoreFrustumCheck = true;
        this.field_146042_b = par2EntityPlayer;
        ((UltimateFishHook) (this.field_146042_b.fishEntity = this)).setSize(0.25f, 0.25f);
        this.setLocationAndAngles(
            par2EntityPlayer.posX,
            par2EntityPlayer.posY + 1.62 - par2EntityPlayer.yOffset,
            par2EntityPlayer.posZ,
            par2EntityPlayer.rotationYaw,
            par2EntityPlayer.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.10000000149011612;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        final float f = 0.4f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f)
            * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f)
            * f;
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f)
            * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f)
            * f;
        this.motionY = -MathHelper.sin(this.rotationPitch / 180.0f * 3.1415927f) * f;
        this.func_146035_c(this.motionX, this.motionY, this.motionZ, 1.5f, 1.0f);
        this.fireResistance = 3000;
        this.isImmuneToFire = true;
    }

    protected void entityInit() {
        this.fireResistance = 3000;
        this.isImmuneToFire = true;
    }

    public void func_146035_c(double p_146035_1_, double p_146035_3_, double p_146035_5_, final float p_146035_7_,
        final float p_146035_8_) {
        final float f2 = MathHelper
            .sqrt_double(p_146035_1_ * p_146035_1_ + p_146035_3_ * p_146035_3_ + p_146035_5_ * p_146035_5_);
        p_146035_1_ /= f2;
        p_146035_3_ /= f2;
        p_146035_5_ /= f2;
        p_146035_1_ += this.rand.nextGaussian() * 0.007499999832361937 * p_146035_8_;
        p_146035_3_ += this.rand.nextGaussian() * 0.007499999832361937 * p_146035_8_;
        p_146035_5_ += this.rand.nextGaussian() * 0.007499999832361937 * p_146035_8_;
        p_146035_1_ *= p_146035_7_;
        p_146035_3_ *= p_146035_7_;
        p_146035_5_ *= p_146035_7_;
        this.motionX = p_146035_1_;
        this.motionY = p_146035_3_;
        this.motionZ = p_146035_5_;
        final float f3 = MathHelper.sqrt_double(p_146035_1_ * p_146035_1_ + p_146035_5_ * p_146035_5_);
        final float n = (float) (Math.atan2(p_146035_1_, p_146035_5_) * 180.0 / 3.141592653589793);
        this.rotationYaw = n;
        this.prevRotationYaw = n;
        final float n2 = (float) (Math.atan2(p_146035_3_, f3) * 180.0 / 3.141592653589793);
        this.rotationPitch = n2;
        this.prevRotationPitch = n2;
        this.field_146049_av = 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(final double par1) {
        double d1 = this.boundingBox.getAverageEdgeLength() * 4.0;
        d1 *= 64.0;
        return par1 < d1 * d1;
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(final double par1, final double par3, final double par5, final float par7,
        final float par8, final int par9) {
        this.field_146056_aC = par1;
        this.field_146057_aD = par3;
        this.field_146058_aE = par5;
        this.field_146059_aF = par7;
        this.field_146060_aG = par8;
        this.field_146055_aB = par9;
        this.motionX = this.field_146061_aH;
        this.motionY = this.field_146052_aI;
        this.motionZ = this.field_146053_aJ;
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(final double par1, final double par3, final double par5) {
        this.motionX = par1;
        this.field_146061_aH = par1;
        this.motionY = par3;
        this.field_146052_aI = par3;
        this.motionZ = par5;
        this.field_146053_aJ = par5;
    }

    public void onUpdate() {
        if (this.field_146055_aB > 0) {
            final double d7 = this.posX + (this.field_146056_aC - this.posX) / this.field_146055_aB;
            final double d8 = this.posY + (this.field_146057_aD - this.posY) / this.field_146055_aB;
            final double d9 = this.posZ + (this.field_146058_aE - this.posZ) / this.field_146055_aB;
            final double d10 = MathHelper.wrapAngleTo180_double(this.field_146059_aF - this.rotationYaw);
            this.rotationYaw += (float) (d10 / this.field_146055_aB);
            this.rotationPitch += (float) ((this.field_146060_aG - this.rotationPitch) / this.field_146055_aB);
            --this.field_146055_aB;
            this.setPosition(d7, d8, d9);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        } else {
            if (!this.worldObj.isRemote) {
                final ItemStack itemstack = this.field_146042_b.getCurrentEquippedItem();
                if (this.field_146042_b.isDead || !this.field_146042_b.isEntityAlive()
                    || itemstack == null
                    || itemstack.getItem() != OreSpawnMain.MyUltimateFishingRod
                    || this.getDistanceSqToEntity(this.field_146042_b) > 1024.0) {
                    this.setDead();
                    this.field_146042_b.fishEntity = null;
                    return;
                }
                if (this.field_146043_c != null) {
                    if (!this.field_146043_c.isDead) {
                        this.posX = this.field_146043_c.posX;
                        this.posY = this.field_146043_c.boundingBox.minY + this.field_146043_c.height * 0.8;
                        this.posZ = this.field_146043_c.posZ;
                        return;
                    }
                    this.field_146043_c = null;
                }
            }
            if (this.field_146044_a > 0) {
                --this.field_146044_a;
            }
            if (this.field_146051_au) {
                if (this.worldObj.getBlock(this.field_146037_g, this.field_146048_h, this.field_146050_i)
                    == this.field_146046_j) {
                    ++this.field_146049_av;
                    if (this.field_146049_av == 1200) {
                        this.setDead();
                    }
                    return;
                }
                this.field_146051_au = false;
                this.motionX *= this.rand.nextFloat() * 0.2f;
                this.motionY *= this.rand.nextFloat() * 0.2f;
                this.motionZ *= this.rand.nextFloat() * 0.2f;
                this.field_146049_av = 0;
                this.field_146047_aw = 0;
            } else {
                ++this.field_146047_aw;
            }
            Vec3 vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec32 = Vec3
                .createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec31, vec32);
            vec31 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec32 = Vec3
                .createVectorHelper(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (movingobjectposition != null) {
                vec32 = Vec3.createVectorHelper(
                    movingobjectposition.hitVec.xCoord,
                    movingobjectposition.hitVec.yCoord,
                    movingobjectposition.hitVec.zCoord);
            }
            Entity entity = null;
            final List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                this,
                this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ)
                    .expand(1.0, 1.0, 1.0));
            double d11 = 0.0;
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity2 = (Entity) list.get(i);
                if (entity2.canBeCollidedWith() && (entity2 != this.field_146042_b || this.field_146047_aw >= 5)) {
                    final float f = 0.3f;
                    final AxisAlignedBB axisalignedbb = entity2.boundingBox.expand(f, f, f);
                    final MovingObjectPosition movingobjectposition2 = axisalignedbb.calculateIntercept(vec31, vec32);
                    if (movingobjectposition2 != null) {
                        final double d12 = vec31.distanceTo(movingobjectposition2.hitVec);
                        if (d12 < d11 || d11 == 0.0) {
                            entity = entity2;
                            d11 = d12;
                        }
                    }
                }
            }
            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }
            if (movingobjectposition != null) {
                if (movingobjectposition.entityHit != null) {
                    if (movingobjectposition.entityHit
                        .attackEntityFrom(DamageSource.causeThrownDamage(this, this.field_146042_b), 0.0f)) {
                        this.field_146043_c = movingobjectposition.entityHit;
                    }
                } else {
                    this.field_146051_au = true;
                }
            }
            if (!this.field_146051_au) {
                this.moveEntity(this.motionX, this.motionY, this.motionZ);
                final float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0 / 3.141592653589793);
                this.rotationPitch = (float) (Math.atan2(this.motionY, f2) * 180.0 / 3.141592653589793);
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
                float f3 = 0.92f;
                if (this.onGround || this.isCollidedHorizontally) {
                    f3 = 0.5f;
                }
                final byte b0 = 5;
                double d13 = 0.0;
                for (int j = 0; j < b0; ++j) {
                    final double d14 = this.boundingBox.minY
                        + (this.boundingBox.maxY - this.boundingBox.minY) * (j + 0) / b0
                        - 0.125
                        + 0.125;
                    final double d15 = this.boundingBox.minY
                        + (this.boundingBox.maxY - this.boundingBox.minY) * (j + 1) / b0
                        - 0.125
                        + 0.125;
                    final AxisAlignedBB axisalignedbb2 = AxisAlignedBB.getBoundingBox(
                        this.boundingBox.minX,
                        d14,
                        this.boundingBox.minZ,
                        this.boundingBox.maxX,
                        d15,
                        this.boundingBox.maxZ);
                    if (this.worldObj.isAABBInMaterial(axisalignedbb2, Material.water)) {
                        d13 += 1.0 / b0;
                    }
                    if (this.worldObj.isAABBInMaterial(axisalignedbb2, Material.lava)) {
                        d13 += 1.0 / b0;
                    }
                }
                if (!this.worldObj.isRemote && d13 > 0.0) {
                    final WorldServer worldserver = (WorldServer) this.worldObj;
                    int k = 1;
                    if (this.rand.nextFloat() < 0.25f && this.worldObj.canLightningStrikeAt(
                        MathHelper.floor_double(this.posX),
                        MathHelper.floor_double(this.posY) + 1,
                        MathHelper.floor_double(this.posZ))) {
                        k = 2;
                    }
                    if (this.rand.nextFloat() < 0.5f && !this.worldObj.canBlockSeeTheSky(
                        MathHelper.floor_double(this.posX),
                        MathHelper.floor_double(this.posY) + 1,
                        MathHelper.floor_double(this.posZ))) {
                        --k;
                    }
                    if (this.fish_on_hook > 0) {
                        --this.fish_on_hook;
                        if (this.fish_on_hook <= 0) {
                            this.fish_wait_time = 0;
                            this.ticks_catchable = 0;
                        }
                    } else if (this.ticks_catchable > 0) {
                        this.ticks_catchable -= k;
                        if (this.ticks_catchable <= 0) {
                            this.motionY -= 0.20000000298023224;
                            this.playSound(
                                "random.splash",
                                0.25f,
                                1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.4f);
                            final float f4 = (float) MathHelper.floor_double(this.boundingBox.minY);
                            worldserver.func_147487_a(
                                "bubble",
                                this.posX,
                                (f4 + 1.0f),
                                this.posZ,
                                (int) (1.0f + this.width * 20.0f),
                                this.width,
                                0.0,
                                this.width,
                                0.20000000298023224);
                            worldserver.func_147487_a(
                                "wake",
                                this.posX,
                                (f4 + 1.0f),
                                this.posZ,
                                (int) (1.0f + this.width * 20.0f),
                                this.width,
                                0.0,
                                this.width,
                                0.20000000298023224);
                            this.fish_on_hook = MathHelper.getRandomIntegerInRange(this.rand, 10, 30);
                        } else {
                            this.fish_direction += (float) (this.rand.nextGaussian() * 4.0);
                            final float f4 = this.fish_direction * 0.017453292f;
                            final float f5 = MathHelper.sin(f4);
                            final float f6 = MathHelper.cos(f4);
                            final double d16 = this.posX + f5 * this.ticks_catchable * 0.1f;
                            final double d17 = MathHelper.floor_double(this.boundingBox.minY) + 1.0f;
                            final double d18 = this.posZ + f6 * this.ticks_catchable * 0.1f;
                            if (this.rand.nextFloat() < 0.15f) {
                                worldserver
                                    .func_147487_a("bubble", d16, d17 - 0.10000000149011612, d18, 1, f5, 0.1, f6, 0.0);
                            }
                            final float f7 = f5 * 0.04f;
                            final float f8 = f6 * 0.04f;
                            worldserver.func_147487_a("wake", d16, d17, d18, 0, f8, 0.01, (-f7), 1.0);
                            worldserver.func_147487_a("wake", d16, d17, d18, 0, (-f8), 0.01, f7, 1.0);
                        }
                    } else if (this.fish_wait_time > 0) {
                        this.fish_wait_time -= k;
                        float f4 = 0.15f;
                        if (this.fish_wait_time < 20) {
                            f4 += (float) ((20 - this.fish_wait_time) * 0.05);
                        } else if (this.fish_wait_time < 40) {
                            f4 += (float) ((40 - this.fish_wait_time) * 0.02);
                        } else if (this.fish_wait_time < 60) {
                            f4 += (float) ((60 - this.fish_wait_time) * 0.01);
                        }
                        if (this.rand.nextFloat() < f4) {
                            final float f5 = MathHelper.randomFloatClamp(this.rand, 0.0f, 360.0f) * 0.017453292f;
                            final float f6 = MathHelper.randomFloatClamp(this.rand, 25.0f, 60.0f);
                            final double d16 = this.posX + MathHelper.sin(f5) * f6 * 0.1f;
                            final double d17 = MathHelper.floor_double(this.boundingBox.minY) + 1.0f;
                            final double d18 = this.posZ + MathHelper.cos(f5) * f6 * 0.1f;
                            worldserver.func_147487_a(
                                "splash",
                                d16,
                                d17,
                                d18,
                                2 + this.rand.nextInt(2),
                                0.10000000149011612,
                                0.0,
                                0.10000000149011612,
                                0.0);
                        }
                        if (this.fish_wait_time <= 0) {
                            this.fish_direction = MathHelper.randomFloatClamp(this.rand, 0.0f, 360.0f);
                            this.ticks_catchable = MathHelper.getRandomIntegerInRange(this.rand, 100, 200);
                        }
                    } else {
                        this.fish_wait_time = MathHelper.getRandomIntegerInRange(this.rand, 50, 300);
                        this.fish_wait_time -= EnchantmentHelper.func_151387_h(this.field_146042_b) * 20 * 5;
                    }
                    if (this.fish_on_hook > 0) {
                        this.motionY -= this.rand.nextFloat() * this.rand.nextFloat() * this.rand.nextFloat() * 0.2;
                    }
                }
                final double d12 = d13 * 2.0 - 1.0;
                this.motionY += 0.03999999910593033 * d12;
                if (d13 > 0.0) {
                    f3 *= (float) 0.9;
                    this.motionY *= 0.8;
                }
                this.motionX *= f3;
                this.motionY *= f3;
                this.motionZ *= f3;
                this.setPosition(this.posX, this.posY, this.posZ);
            }
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setShort("xTile", (short) this.field_146037_g);
        par1NBTTagCompound.setShort("yTile", (short) this.field_146048_h);
        par1NBTTagCompound.setShort("zTile", (short) this.field_146050_i);
        par1NBTTagCompound.setByte("inTile", (byte) Block.getIdFromBlock(this.field_146046_j));
        par1NBTTagCompound.setByte("shake", (byte) this.field_146044_a);
        par1NBTTagCompound.setByte("inGround", (byte) (this.field_146051_au ? 1 : 0));
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        this.field_146037_g = par1NBTTagCompound.getShort("xTile");
        this.field_146048_h = par1NBTTagCompound.getShort("yTile");
        this.field_146050_i = par1NBTTagCompound.getShort("zTile");
        this.field_146046_j = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 0xFF);
        this.field_146044_a = (par1NBTTagCompound.getByte("shake") & 0xFF);
        this.field_146051_au = (par1NBTTagCompound.getByte("inGround") == 1);
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0.0f;
    }

    public int func_146034_e() {
        if (this.worldObj.isRemote) {
            return 0;
        }
        byte b0 = 0;
        if (this.field_146043_c != null) {
            final double d0 = this.field_146042_b.posX - this.posX;
            final double d2 = this.field_146042_b.posY - this.posY;
            final double d3 = this.field_146042_b.posZ - this.posZ;
            final double d4 = MathHelper.sqrt_double(d0 * d0 + d2 * d2 + d3 * d3);
            final double d5 = 0.1;
            final Entity field_146043_c = this.field_146043_c;
            field_146043_c.motionX += d0 * d5;
            final Entity field_146043_c2 = this.field_146043_c;
            field_146043_c2.motionY += d2 * d5 + MathHelper.sqrt_double(d4) * 0.08;
            final Entity field_146043_c3 = this.field_146043_c;
            field_146043_c3.motionZ += d3 * d5;
            b0 = 3;
        } else if (this.fish_on_hook > 0) {
            final EntityItem entityitem = new EntityItem(
                this.worldObj,
                this.posX,
                this.posY + 1.25,
                this.posZ,
                this.func_146033_f());
            final double d6 = this.field_146042_b.posX - this.posX;
            final double d7 = this.field_146042_b.posY - this.posY;
            final double d8 = this.field_146042_b.posZ - this.posZ;
            final double d9 = MathHelper.sqrt_double(d6 * d6 + d7 * d7 + d8 * d8);
            final double d10 = 0.1;
            entityitem.motionX = d6 * d10;
            entityitem.motionY = d7 * d10 + MathHelper.sqrt_double(d9) * 0.08;
            entityitem.motionZ = d8 * d10;
            entityitem.fireResistance = 3000;
            this.worldObj.spawnEntityInWorld(entityitem);
            this.field_146042_b.worldObj.spawnEntityInWorld(
                new EntityXPOrb(
                    this.field_146042_b.worldObj,
                    this.field_146042_b.posX,
                    this.field_146042_b.posY + 0.5,
                    this.field_146042_b.posZ + 0.5,
                    this.rand.nextInt(6) + 1));
            b0 = 1;
        }
        if (this.field_146051_au) {
            b0 = 2;
        }
        this.setDead();
        this.field_146042_b.fishEntity = null;
        return b0;
    }

    private ItemStack func_146033_f() {
        float f = this.worldObj.rand.nextFloat();
        final int i = EnchantmentHelper.func_151386_g(this.field_146042_b);
        final int j = EnchantmentHelper.func_151387_h(this.field_146042_b);
        float f2 = 0.1f - i * 0.025f - j * 0.01f;
        float f3 = 0.05f + i * 0.01f - j * 0.01f;
        f2 = MathHelper.clamp_float(f2, 0.0f, 1.0f);
        f3 = MathHelper.clamp_float(f3, 0.0f, 1.0f);
        final Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ);
        if (this.handleLavaMovement() || bid == Blocks.lava || bid == Blocks.flowing_lava) {
            this.field_146042_b.addStat(StatList.fishCaughtStat, 1);
            return ((WeightedRandomFishable) WeightedRandom
                .getRandomItem(this.rand, (Collection) UltimateFishHook.orespawn_lava_fish)).func_150708_a(this.rand);
        }
        if (f < f2) {
            this.field_146042_b.addStat(StatList.field_151183_A, 1);
            return ((WeightedRandomFishable) WeightedRandom
                .getRandomItem(this.rand, (Collection) UltimateFishHook.field_146039_d)).func_150708_a(this.rand);
        }
        f -= f2;
        if (f < f3) {
            this.field_146042_b.addStat(StatList.field_151184_B, 1);
            return ((WeightedRandomFishable) WeightedRandom
                .getRandomItem(this.rand, (Collection) UltimateFishHook.field_146041_e)).func_150708_a(this.rand);
        }
        final float f4 = this.worldObj.rand.nextFloat();
        this.field_146042_b.addStat(StatList.fishCaughtStat, 1);
        if (f4 < 0.5f) {
            return ((WeightedRandomFishable) WeightedRandom
                .getRandomItem(this.rand, (Collection) UltimateFishHook.field_146036_f)).func_150708_a(this.rand);
        }
        return ((WeightedRandomFishable) WeightedRandom
            .getRandomItem(this.rand, (Collection) UltimateFishHook.orespawn_fish)).func_150708_a(this.rand);
    }

    public void setDead() {
        super.setDead();
        if (this.field_146042_b != null) {
            this.field_146042_b.fishEntity = null;
        }
    }

    static {
        field_146039_d = Arrays.asList(
            new WeightedRandomFishable(new ItemStack(Items.leather_boots), 10).func_150709_a(0.9f),
            new WeightedRandomFishable(new ItemStack(Items.leather), 10),
            new WeightedRandomFishable(new ItemStack(Items.bone), 10),
            new WeightedRandomFishable(new ItemStack(Items.potionitem), 10),
            new WeightedRandomFishable(new ItemStack(Items.string), 5),
            new WeightedRandomFishable(new ItemStack(Items.fishing_rod), 2).func_150709_a(0.9f),
            new WeightedRandomFishable(new ItemStack(Items.bowl), 10),
            new WeightedRandomFishable(new ItemStack(Items.stick), 5),
            new WeightedRandomFishable(new ItemStack(Items.dye, 10, 0), 1),
            new WeightedRandomFishable(new ItemStack((Block) Blocks.tripwire_hook), 10),
            new WeightedRandomFishable(new ItemStack(Items.rotten_flesh), 10));
        field_146041_e = Arrays.asList(
            new WeightedRandomFishable(new ItemStack(Blocks.waterlily), 1),
            new WeightedRandomFishable(new ItemStack(Items.name_tag), 1),
            new WeightedRandomFishable(new ItemStack(Items.saddle), 1),
            new WeightedRandomFishable(new ItemStack(Items.bow), 1).func_150709_a(0.25f)
                .func_150707_a(),
            new WeightedRandomFishable(new ItemStack(Items.fishing_rod), 1).func_150709_a(0.25f)
                .func_150707_a(),
            new WeightedRandomFishable(new ItemStack(Items.book), 1).func_150707_a());
        field_146036_f = Arrays.asList(
            new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.COD.func_150976_a()), 60),
            new WeightedRandomFishable(new ItemStack(Items.fish, 1, ItemFishFood.FishType.SALMON.func_150976_a()), 25),
            new WeightedRandomFishable(
                new ItemStack(Items.fish, 1, ItemFishFood.FishType.CLOWNFISH.func_150976_a()),
                2),
            new WeightedRandomFishable(
                new ItemStack(Items.fish, 1, ItemFishFood.FishType.PUFFERFISH.func_150976_a()),
                13));
        orespawn_lava_fish = Arrays.asList(
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySunspotUrchin), 25),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyLavaEel), 10),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySunFish), 15),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MySparkFish), 10),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyFireFish), 15));
        orespawn_fish = Arrays.asList(
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyBlueFish), 25),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyPinkFish), 10),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyRockFish), 15),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyWoodFish), 10),
            new WeightedRandomFishable(new ItemStack(OreSpawnMain.MyGreyFish), 15));
    }
}
