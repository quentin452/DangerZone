
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class SkullBossInstance extends EntityMob implements IMob {

    private ChunkCoordinates currentFlightTarget;
    private int lastX;
    private int lastZ;
    private int lastY;
    private int stuck_count;
    private GenericTargetSorterInstance TargetSorter;
    private final float moveSpeed;
    private int dmgDelay;
    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;

    public SkullBossInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.lastX = 0;
        this.lastZ = 0;
        this.lastY = 0;
        this.stuck_count = 0;
        this.TargetSorter = null;
        this.moveSpeed = 0.35f;
        this.dmgDelay = 0;
        this.setSize(3.0f, 4.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 1000;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1.0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    protected void entityInit() {
        super.entityInit();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public int getTotalArmorValue() {
        return 18;
    }

    public int getMothraHealth() {
        return (int) this.getHealth();
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return "random.explode";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    protected void collideWithNearbyEntities() {}

    public int mygetMaxHealth() {
        return 550;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle(
            "flame",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
        this.worldObj.spawnParticle(
            "flame",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f,
            (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f);
        this.worldObj.spawnParticle(
            "flame",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f,
            (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f,
            (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f);
        this.motionY *= 0.4;
        if (this.getHealth() < this.mygetMaxHealth() && this.worldObj.rand.nextInt(5) == 1) {
            this.heal(1.0f);
        }
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        int shoot = 2;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.isRemote && this.boatPosRotationIncrements > 0) {
            final double d4 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
            final double d5 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
            final double d6 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
            this.setPosition(d4, d5, d6);
            this.rotationPitch += (float) ((this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
            double d7 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
            if (this.riddenByEntity != null) {
                d7 = MathHelper.wrapAngleTo180_double((double) (this.riddenByEntity.rotationYaw - this.rotationYaw));
            }
            this.setRotation(this.rotationYaw += (float) (d7 / this.boatPosRotationIncrements), this.rotationPitch);
            this.rotationYawHead = this.rotationYaw;
            --this.boatPosRotationIncrements;
        }
        if (this.lastX == (int) this.posX && this.lastY == (int) this.posY && this.lastZ == (int) this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int) this.posX;
            this.lastY = (int) this.posY;
            this.lastZ = (int) this.posZ;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            shoot = 1;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.stuck_count > 2 || this.worldObj.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 9.0f) {
            int down = 0;
            int dist = 3;
            for (int i = -5; i <= 5; i += 5) {
                for (int j = -5; j <= 5; j += 5) {
                    int k = 1;
                    while (k < 20) {
                        final Block bid = this.worldObj
                            .getBlock((int) this.posX + j, (int) this.posY - k, (int) this.posZ + i);
                        if (bid != Blocks.air) {
                            if (k >= dist) {
                                break;
                            }
                            dist = k;
                            break;
                        } else {
                            ++k;
                        }
                    }
                }
            }
            if (dist > 10) {
                down = dist - 5 + 1;
            }
            for (Block bid2 = Blocks.stone; bid2 != Blocks.air && keep_trying != 0; --keep_trying) {
                xdir = 1;
                zdir = 1;
                if (this.rand.nextInt(2) == 0) {
                    xdir = -1;
                }
                if (this.rand.nextInt(2) == 0) {
                    zdir = -1;
                }
                int newz = this.rand.nextInt(20) + 16;
                newz *= zdir;
                int newx = this.rand.nextInt(20) + 16;
                newx *= xdir;
                this.currentFlightTarget.set(
                    (int) this.posX + newx,
                    (int) this.posY + this.rand.nextInt(7) - 1 - down,
                    (int) this.posZ + newz);
                bid2 = this.worldObj.getBlock(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ);
                if (bid2 == Blocks.air && !this.canSeeTarget(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ)) {
                    bid2 = Blocks.stone;
                }
            }
            this.stuck_count = 0;
        } else if (this.worldObj.rand.nextInt(10) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            EntityPlayer target = null;
            target = (EntityPlayer) this.worldObj.findNearestEntityWithinAABB(
                EntityPlayer.class,
                this.boundingBox.expand(65.0, 30.0, 65.0),
                (Entity) this);
            if (target != null) {
                if (!target.capabilities.isCreativeMode) {
                    if (this.getEntitySenses()
                        .canSee((Entity) target)) {
                        this.currentFlightTarget.set((int) target.posX, (int) target.posY, (int) target.posZ);
                        if (this.worldObj.rand.nextInt(4) == 1 || this.worldObj.rand.nextInt(5) == 1) {
                            this.firecanon((EntityLivingBase) target);
                            this.MeteorStrike((EntityLivingBase) target);
                        }
                    }
                } else {
                    target = null;
                }
            }
            if (target == null && this.worldObj.rand.nextInt(3) == 0) {
                EntityLivingBase e = null;
                EntityLivingBase f = null;
                f = this.findSomethingToAttack();
                if (e == null) {
                    e = f;
                }
                e = this.findSomethingToAttack();
                if (e != null) {
                    if (this.getDistanceSqToEntity(e) < (35.0f + e.width / 2.0f) * (35.0f + e.width / 2.0f)) {
                        if (this.worldObj.rand.nextInt(5) == 1 || this.worldObj.rand.nextInt(6) == 1) {
                            this.firecanon(e);
                            this.MeteorStrike(e);
                        }
                        if (this.getDistanceSqToEntity(e) < (15.0f + e.width / 2.0f) * (15.0f + e.width / 2.0f)) {
                            final int down2 = 0;
                            int newz2 = this.rand.nextInt(5) + 6;
                            newz2 *= zdir;
                            int newx2 = this.rand.nextInt(5) + 6;
                            newx2 *= xdir;
                            this.currentFlightTarget.set(
                                (int) this.posX + newx2,
                                (int) this.posY + this.rand.nextInt(3) - 1 - down2,
                                (int) this.posZ + newz2);
                        }
                    }
                    this.currentFlightTarget.set((int) e.posX, (int) e.posY + 5, (int) e.posZ);
                    this.firecanon(e);
                    this.MeteorStrike(e);
                    if (this.getDistanceSqToEntity(e) < (5.0f + e.width / 2.0f) * (5.0f + e.width / 2.0f)) {
                        this.attackEntityAsMob(e);
                    }
                }
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.30001;
        this.motionY += (Math.signum(var2) * 0.7 - this.motionY) * 0.20001;
        this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.30001;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.8f;
        this.rotationYaw += var5 / 16.0f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = 2.0;
        double inair = -0.25;
        int var2 = 6;
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
                    var2 = 8;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        var2 = 10;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        var2 = 12;
                    }
                }
                if (this.worldObj.rand.nextInt(3) == 1) {}
                final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }

    private void MeteorStrike(final EntityLivingBase e) {
        final double yoff = -3.5;
        final double xzoff = 1.5;
        if (this.rand.nextInt(30) == 1) {
            final FireCannon var2 = new FireCannon(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                this.rotationYaw,
                this.rotationPitch);
            this.worldObj.playSoundAtEntity(
                this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var2);
        }
        final FireCannon var2 = new FireCannon(
            this.worldObj,
            e.posX - this.posX,
            e.posY + 0.75 - (this.posY + yoff),
            e.posZ - this.posZ);
        var2.setLocationAndAngles(
            this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
            this.posY + yoff,
            this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
            this.rotationYawHead,
            this.rotationPitch);
        final double var3 = e.posX - var2.posX;
        final double var4 = e.posY + 0.25 - var2.posY;
        final double var5 = e.posZ - var2.posZ;
        final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
        var2.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
        this.worldObj.playSoundAtEntity(
            (Entity) this,
            "random.explode",
            0.75f,
            1.0f / (this.getRNG()
                .nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(var2);
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof SkullBossInstance) {
            return false;
        }
        if (this.dmgDelay > 0) {
            return false;
        }
        float dm = par2;
        if (!par1DamageSource.getDamageType()
            .equals("explosion")) {
            dm = 0.0f;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.dmgDelay = 15;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int) e.posX, (int) e.posY + 2, (int) e.posZ);
        }
        return ret;
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
    }

    public boolean getCanSpawnHere() {
        for (int k = -4; k <= 4; ++k) {
            for (int j = -4; j <= 4; ++j) {
                for (int i = 1; i < 4; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("BigBadSkull")) {
                            return true;
                        }
                    }
                }
            }
        }
        for (int k = -4; k < 4; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 1; i < 10; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        SkullBossInstance target = null;
        target = (SkullBossInstance) this.worldObj
            .findNearestEntityWithinAABB(SkullBossInstance.class, this.boundingBox.expand(64.0, 32.0, 64.0), this);
        return target == null;
    }

    public void initCreature() {}

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        /*
         * for (int i = 8 + this.worldObj.rand.nextInt(6), var4 = 0; var4 < i; ++var4) {
         * this.dropBlockRand(Basic.boneBrick, 5);
         * }
         * for (int i = 16 + this.worldObj.rand.nextInt(6), var4 = 0; var4 < i; ++var4) {
         * this.dropBlockRand(Basic.boneOre, 8);
         * }
         * for (int i = 2 + this.worldObj.rand.nextInt(6), var4 = 0; var4 < i; ++var4) {
         * this.dropBlockRand(Basic.boneWall, 4);
         * }
         * if (this.worldObj.rand.nextInt(5) == 1) {
         * this.dropItemRand(Basic.bowserBone, 5);
         * }
         * if (this.worldObj.rand.nextInt(5) == 1) {
         * this.dropItemRand(Basic.phoenixFeather, 3);
         * }
         */
        if (this.worldObj.rand.nextInt(5) == 1) {
            this.dropBlockRand((Block) Blocks.fire, 15);
        }
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = -0.5;
        final double xzoff = 3.0;
        BetterFireballInstance bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new BetterFireballInstance(
            this.worldObj,
            (EntityLivingBase) this,
            e.posX - cx + r1,
            e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
            e.posZ - cz + r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setBowser();
        this.worldObj.playSoundAtEntity(this, Tags.MODID + ":slap", 3.0f, 1.0f);
        this.worldObj.spawnEntityInWorld(bf);
        this.heal(5.0f);
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof SkullBossInstance) {
            return false;
        }
        if (par1EntityLiving instanceof SkullInstance) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGhast) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(65.0, 30.0, 65.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }
}
