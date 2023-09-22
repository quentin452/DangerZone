
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Brutalfly extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private int lastX;
    private int lastZ;
    private int lastY;
    private int stuck_count;
    private int wing_sound;
    private int health_ticker;
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;

    public Brutalfly(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.lastX = 0;
        this.lastZ = 0;
        this.lastY = 0;
        this.stuck_count = 0;
        this.wing_sound = 0;
        this.health_ticker = 100;
        this.TargetSorter = null;
        this.moveSpeed = 0.35f;
        this.setSize(5.0f, 2.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 100;
        this.isImmuneToFire = true;
        this.fireResistance = 500;
        this.TargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Brutalfly_stats.attack);
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
        return OreSpawnMain.Brutalfly_stats.defense;
    }

    public int getBrutalflyHealth() {
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
        return OreSpawnMain.Brutalfly_stats.health;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6;
        ++this.wing_sound;
        if (this.wing_sound > 30) {
            if (!this.worldObj.isRemote) {
                this.worldObj.playSoundAtEntity(this, Tags.MODID + ":MothraWings", 1.0f, 1.0f);
            }
            this.wing_sound = 0;
        }
        --this.health_ticker;
        if (this.health_ticker <= 0) {
            if (this.getHealth() < this.mygetMaxHealth()) {
                this.heal(1.0f);
            }
            this.health_ticker = 100;
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
        int keep_trying = 30;
        int shoot = 3;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.lastX == (int) this.posX && this.lastY == (int) this.posY && this.lastZ == (int) this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int) this.posX;
            this.lastY = (int) this.posY;
            this.lastZ = (int) this.posZ;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
            shoot = 2;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.stuck_count > 30 || this.worldObj.rand.nextInt(200) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 9.0f) {
            int down = 0;
            int dist = 20;
            for (int i = -5; i <= 5; i += 5) {
                for (int j = -5; j <= 5; j += 5) {
                    int k = 1;
                    while (k < 20) {
                        final Block bid = this.worldObj
                            .getBlock((int) this.posX + j, (int) this.posY - k, (int) this.posZ + i);
                        if (bid != Blocks.air) {
                            if (k < dist) {
                                dist = k;
                                break;
                            }
                            break;
                        } else {
                            ++k;
                        }
                    }
                }
            }
            if (dist > 10) {
                down = dist - 10 + 1;
            }
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                xdir = 1;
                zdir = 1;
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = -1;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = -1;
                }
                int newz = this.rand.nextInt(20) + 8;
                newz *= zdir;
                int newx = this.rand.nextInt(20) + 8;
                newx *= xdir;
                this.currentFlightTarget.set(
                    (int) this.posX + newx,
                    (int) this.posY + this.worldObj.rand.nextInt(7) - 1 - down,
                    (int) this.posZ + newz);
                bid = this.worldObj.getBlock(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
            }
            this.stuck_count = 0;
        }
        if (this.worldObj.rand.nextInt(6) == 0) {
            EntityPlayer target = null;
            target = (EntityPlayer) this.worldObj
                .findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(30.0, 20.0, 30.0), this);
            if (target != null) {
                if (!target.capabilities.isCreativeMode) {
                    if (this.getEntitySenses()
                        .canSee(target)) {
                        this.currentFlightTarget.set((int) target.posX, (int) target.posY + 4, (int) target.posZ);
                        if (this.rand.nextInt(shoot) == 0) {
                            this.attackWithSomething(target);
                        }
                    }
                } else {
                    target = null;
                }
            }
            if (target == null && this.worldObj.rand.nextInt(3) == 0) {
                EntityLivingBase e = null;
                e = this.findSomethingToAttack();
                if (e != null) {
                    this.currentFlightTarget.set((int) e.posX, (int) e.posY + 5, (int) e.posZ);
                    if (this.getDistanceSqToEntity(e) > 25.0) {
                        if (this.worldObj.rand.nextInt(shoot) == 0) {
                            this.attackWithSomething(e);
                        }
                    } else {
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
        this.moveForward = 1.0f;
        this.rotationYaw += var5 / 8.0f;
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
        if (e != null && e instanceof Brutalfly) {
            return false;
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
        for (byte k = -2; k <= 2; ++k) {
            for (byte j = -2; j <= 2; ++j) {
                for (byte i = 1; i < 4; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Brutalfly")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.posY < 70.0) {
            return false;
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
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
        Brutalfly target;
        target = (Brutalfly) this.worldObj
            .findNearestEntityWithinAABB(Brutalfly.class, this.boundingBox.expand(64.0, 32.0, 64.0), this);
        return target == null;
    }

    public void initCreature() {}

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(8) - OreSpawnMain.OreSpawnRand.nextInt(8),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int i = 0; i < 20; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle(
                "largeexplode",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.0,
                0.0);
        }
        for (int var4 = 0; var4 < 53; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (int var4 = 0; var4 < 20; ++var4) {
            spawnCreature(this.worldObj, "Butterfly", this.posX + 0.5, this.posY + 1.0, this.posZ + 0.5);
        }
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        if (par0World == null) {
            return null;
        }
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    private void attackWithSomething(final EntityLivingBase par1) {
        final double xzoff = 2.25;
        final double yoff = 0.0;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            final EntitySmallFireball sf = new EntitySmallFireball(
                this.worldObj,
                this,
                par1.posX - cx,
                par1.posY + 0.55 - (this.posY + yoff),
                par1.posZ - cz);
            sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            sf.setPosition(cx, this.posY + yoff, cz);
            this.worldObj.playSoundAtEntity(
                this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(sf);
        } else if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
            if (this.worldObj.rand.nextInt(2) == 0) {
                final EntitySmallFireball sf = new EntitySmallFireball(
                    this.worldObj,
                    this,
                    par1.posX - cx,
                    par1.posY + 0.55 - (this.posY + yoff),
                    par1.posZ - cz);
                sf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                sf.setPosition(cx, this.posY + yoff, cz);
                this.worldObj.playSoundAtEntity(
                    this,
                    "random.bow",
                    0.75f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(sf);
            } else {
                final BetterFireball bf = new BetterFireball(
                    this.worldObj,
                    this,
                    par1.posX - cx,
                    par1.posY + 0.55 - (this.posY + yoff),
                    par1.posZ - cz);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                bf.setNotMe();
                this.worldObj.playSoundAtEntity(
                    this,
                    "random.fuse",
                    1.0f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(bf);
            }
        } else {
            final BetterFireball bf = new BetterFireball(
                this.worldObj,
                this,
                par1.posX - cx,
                par1.posY + 0.55 - (this.posY + yoff),
                par1.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            bf.setNotMe();
            this.worldObj.playSoundAtEntity(
                this,
                "random.fuse",
                1.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(bf);
        }
        if (this.getHealth() < this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (par1EntityLiving instanceof Brutalfly) {
            return false;
        }
        if (par1EntityLiving instanceof Mothra) {
            return false;
        }
        if (par1EntityLiving instanceof Vortex) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(25.0, 20.0, 25.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
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
