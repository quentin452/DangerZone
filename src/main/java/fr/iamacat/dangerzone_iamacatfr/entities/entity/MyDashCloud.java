
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MyDashCloud extends MyCloud implements IMob {

    private static final ResourceLocation texturedashcloud;
    private ChunkCoordinates currentFlightTarget;
    private int lastX;
    private int lastZ;
    private int lastY;
    private int stuck_count;
    private int wing_sound;
    private int health_ticker;
    private GenericTargetSorter TargetSorter;
    private float moveSpeed;

    public MyDashCloud(final World par1World) {
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
        this.setSize(5.0f, 5.2f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 100;
        this.noClip = true;
        this.renderDistanceWeight = 12.0;
        this.isImmuneToFire = true;
        this.fireResistance = 500;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
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

    public void onDeathUpdate() {
        super.onDeathUpdate();
        for (int i = 0; i < 20; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            this.worldObj.spawnParticle(
                "largeexplode",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.75,
                0.0);
        }
    }

    public int getTotalArmorValue() {
        return 10;
    }

    public int getMothraHealth() {
        return (int) this.getHealth();
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 4.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return "random.explode";
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
        return 120;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6;
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
        int shoot = 2;
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
        if (this.stuck_count > 50 || this.worldObj.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 9.0f) {
            int down = 0;
            int dist = 20;
            for (int i = -2; i <= 2; i += 2) {
                for (int j = -2; j <= 2; j += 2) {
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
                down = dist - 10 + 1;
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
                int newz = this.rand.nextInt(20) + 8;
                newz *= zdir;
                int newx = this.rand.nextInt(20) + 8;
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
                this.boundingBox.expand(6.0, 32.0, 6.0),
                (Entity) this);
            if (target != null) {
                if (!target.capabilities.isCreativeMode) {
                    if (this.getEntitySenses()
                        .canSee((Entity) target)) {
                        this.currentFlightTarget.set((int) target.posX, (int) target.posY + 12, (int) target.posZ);
                        if (this.rand.nextInt(shoot) == 0) {
                            this.LightningBolt((EntityLivingBase) target);
                        }
                    }
                } else {
                    target = null;
                }
            }
            if (target == null && this.worldObj.rand.nextInt(1) == 0) {
                EntityLivingBase e = null;
                e = this.findSomethingToAttack();
                if (e != null
                    && this.getDistanceSqToEntity((Entity) e) < (25.0f + e.width / 2.0f) * (25.0f + e.width / 2.0f)) {
                    this.currentFlightTarget.set((int) e.posX, (int) e.posY + 16, (int) e.posZ);
                    this.LightningBolt(e);
                }
            }
        }
        final double var1 = this.currentFlightTarget.posX + 1.2 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.6 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 1.2 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.30001;
        this.motionY += (Math.signum(var2) * 0.7 - this.motionY) * 0.20001;
        this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.30001;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 1.0f;
        this.rotationYaw += var5 / 32.0f;
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
        if (e != null && e instanceof MyDashCloud) {
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
        for (int k = -2; k <= 2; ++k) {
            for (int j = -2; j <= 2; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MyDashCloud")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.posY < 70.0) {
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
        MyDashCloud target = null;
        target = (MyDashCloud) this.worldObj.findNearestEntityWithinAABB(
             MyDashCloud.class,
            this.boundingBox.expand(64.0, 32.0, 64.0),
            (Entity) this);
        return target == null;
    }

    public void initCreature() {}

    protected void dropFewItems(final boolean par1, final int par2) {}

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

    private void LightningBolt(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 250.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), var2);
        for (int var3 = 0; var3 < 20; ++var3) {}
        this.worldObj.playSoundAtEntity(
            (Entity) e,
            "random.explode",
            1.5f,
            1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {}
        this.worldObj.addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY + 1.0, e.posZ));
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && !MobUtils.isIgnoreable(par1EntityLiving)
            && this.getEntitySenses()
                .canSee((Entity) par1EntityLiving)
            && !(par1EntityLiving instanceof MyDashCloud)
            && !(par1EntityLiving instanceof MyDash)
            && !(par1EntityLiving instanceof EntityPlayer)
            && !(par1EntityLiving instanceof MyTwilicorn)
            && !(par1EntityLiving instanceof MyAJ);
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB( EntityLivingBase.class, this.boundingBox.expand(128.0, 64.0, 128.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
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

    static {
        texturedashcloud = new ResourceLocation(Tags.MODID + ":" + "textures/entity/dashcloud.png");
    }
}
