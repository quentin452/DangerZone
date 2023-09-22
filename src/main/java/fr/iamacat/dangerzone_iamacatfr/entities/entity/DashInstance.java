
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.AIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.network.MovementInputProxy;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
public class DashInstance extends EntityTameable {

    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private double velocityX;
    private double velocityY;
    private double velocityZ;
    private int stream_count;
    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int dmgDelay;
    private int wing_sound;
    private ChunkCoordinates currentFlightTarget;
    private boolean target_in_sight;
    private int owner_flying;
    private int flyaway;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private int gothitcount;
    private int gothitcountmob;
    private int unstick_timer;
    private float moveSpeed;
    private float deltasmooth;
    protected MovementInputProxy riderInput;

    public DashInstance(final World par1World) {
        super(par1World);
        this.stream_count = 0;
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.dmgDelay = 0;
        this.wing_sound = 0;
        this.currentFlightTarget = null;
        this.target_in_sight = false;
        this.owner_flying = 0;
        this.flyaway = 0;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.gothitcount = 0;
        this.gothitcountmob = 0;
        this.unstick_timer = 0;
        this.moveSpeed = 4.95f;
        this.deltasmooth = 0.0f;
        this.setSize(0.75f, 1.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 2000;
        this.fireResistance = 10;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.setSitting(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new AIFollowOwner((EntityTameable) this, 1.1f, 16.0f, 2.0f));
        // this.tasks.addTask(2, (EntityAIBase)new EntityAITempt(this, 1.25, Basic.lightningCloud,
        // false));
        this.tasks.addTask(3, new EntityAIWander(this, 0.75));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 9.0f));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        /*
         * if (Basic.Snap == 0) {
         * this.targetTasks.addTask(1, (EntityAIBase)new EntityAINearestAttackableTarget(this,
         * EntityLiving.class, 0, true, false, IMob.mobSelector));
         * }
         */
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.riddenByEntity = null;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.renderdata = new InfoRenderer();
    }

    public DashInstance(final World par1World, final double par2, final double par4, final double par6) {
        this(par1World);
        this.setPosition(par2, par4 + this.yOffset, par6);
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(275.0);
    }

    public int getTrackingRange() {
        return 128;
    }

    public int getUpdateFrequency() {
        return 10;
    }

    public boolean sendsVelocityUpdates() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.dataWatcher.addObject(21, (Object) 0);
        this.dataWatcher.addObject(22, (Object) 0);
        this.setActivity(0);
        this.setAttacking(0);
        this.setBeingRidden(0);
        this.setTamed(false);
        if (this.renderdata == null) {
            this.renderdata = new InfoRenderer();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }

    public int mygetMaxHealth() {
        return 1200;
    }

    public int getRainbowHealth() {
        return (int) this.getHealth();
    }

    public InfoRenderer getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(final InfoRenderer r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }

    public int getTotalArmorValue() {
        return 21;
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public String getLivingSound() {
        return Tags.MODID + ":dash_a";
    }

    protected String getHurtSound() {
        return "damage.hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":rainboom";
    }

    protected float getSoundVolume() {
        return 0.5f;
    }

    public float getSoundPitch() {
        return 1.0f;
    }

    public boolean canBePushed() {
        return false;
    }

    public double getMountedYOffset() {
        return 0.75;
    }

    /*
     * protected ItemFood getDropItemId() {
     * return Basic.dashMeat;
     * }
     */

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
            this.worldObj.spawnEntityInWorld((Entity) var3);
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
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int i = 4 + this.worldObj.rand.nextInt(6), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.feather, 1);
        }
        int i = 16 + this.worldObj.rand.nextInt(6);
        /*
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.dashMeat, 1);
         * }
         * i = 2 + this.worldObj.rand.nextInt(6);
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand(Basic.lightningCloud, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         * }
         * for (int var4 = 0; var4 < i; ++var4) {
         * this.dropItemRand((Item)Basic.rainbow, 1);
         */
        // }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final float s = par1Entity.height * par1Entity.width;
            if (this.getHealth() < 150.0f) {
                final EntityLivingBase e = (EntityLivingBase) par1Entity;
                e.heal(-200.0f);
                this.doRainboomDamage(this.posX, this.posY, this.posZ, 16.0, 375.0, 1);
            }
        }
        final double ks = 4.5;
        double inair = 0.55;
        float iskraken = 1.0f;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource((Explosion) null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(1) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 225.0f);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 225.0f);
            }
        } else if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            if (par1Entity instanceof LeviathanInstance) {
                iskraken = 4.0f;
            }
            par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), iskraken * 555.0f);
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        Entity e = par1DamageSource.getEntity();
        if (this.dmgDelay > 0) {
            return false;
        }
        float dm = par2;
        if (dm > 1750.0f) {
            dm = 1750.0f;
        }
        if (e != null && e instanceof EntityPlayer) {
            ++this.gothitcount;
        }
        if (e != null) {
            ++this.gothitcountmob;
        }
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return ret;
        }
        if (!this.worldObj.isRemote) {
            this.setSitting(false);
        }
        if (!this.worldObj.isRemote) {
            this.setActivity(1);
        }
        e = par1DamageSource.getEntity();
        if (e != null && e instanceof PhoenixInstance) {
            return false;
        }
        ret = super.attackEntityFrom(par1DamageSource, dm);
        this.dmgDelay = 8;
        if (e != null && e instanceof EntityLivingBase && !this.worldObj.isRemote) {
            if (this.isTamed() && e instanceof EntityPlayer) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving((Entity) e, 1.8);
            ret = true;
        }
        return ret;
    }

    public void updateAITasks() {
        if (this.worldObj.isRemote) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setAttackTarget((EntityLivingBase) null);
        }
    }

    protected void updateAITick() {
        if (this.riddenByEntity != null) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        super.updateAITick();
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
        if (par1EntityLiving instanceof AJInstance) {
            return false;
        }
        return !(par1EntityLiving instanceof DashInstance)
            && !(par1EntityLiving instanceof DashCloudInstance)
            && !(par1EntityLiving instanceof EntityAnimal)
            && !(par1EntityLiving instanceof EntityVillager)
            && !this.isTamed()
            && MobUtils.isAttackableNonMob(par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(96.0, 48.0, 96.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        for (byte k = -3; k < 3; ++k) {
            for (byte j = -3; j < 3; ++j) {
                for (byte i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MyDash")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.worldObj.rand.nextInt(16) != 0) {
            return false;
        }
        DashInstance target = null;
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        target = (DashInstance) this.worldObj.findNearestEntityWithinAABB(
            DashInstance.class,
            this.boundingBox.expand(256.0, 256.0, 256.0),
            (Entity) this);
        return target == null && this.posY >= 50.0;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 1.25, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(final double par1, final double par3, final double par5, final float par7,
        final float par8, final int par9) {
        super.setPositionAndRotation2(par1, par3, par5, par7, par8, par9);
        this.boatPosRotationIncrements = par9;
        this.boatX = par1;
        this.boatY = par3;
        this.boatZ = par5;
        this.boatYaw = par7;
        this.boatPitch = par8;
        this.boatYawHead = par7;
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(final double par1, final double par3, final double par5) {
        super.setVelocity(par1, par3, par5);
    }

    public void onUpdate() {
        EntityLivingBase e = null;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (this.getActivity() == 1) {
            ++this.wing_sound;
            if (this.wing_sound > 20) {
                if (!this.worldObj.isRemote) {
                    this.worldObj.playSoundAtEntity((Entity) this, Tags.MODID + ":flap_a1", 0.8f, 1.0f);
                }
                this.wing_sound = 0;
            }
        }
        if (this.isInWater()) {
            this.motionY += 0.07;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.getActivity() == 0 && this.isTamed() && this.getOwner() != null && !this.isSitting()) {
            e = this.getOwner();
            if (e != null && this.getDistanceSqToEntity((Entity) e) > 144.0) {
                this.setActivity(1);
            }
        }
    }

    private void Dash() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        int do_new = 0;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        this.noClip = false;
        int has_owner = 0;
        EntityLivingBase e = null;
        double speed_factor = 0.5;
        double var1 = 0.0;
        double var2 = 0.0;
        double var3 = 0.0;
        final double gh = 1.25;
        double obstruction_factor = 0.0;
        final double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        int toofar = 0;
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.currentFlightTarget == null) {
            do_new = 1;
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.isSitting()) {
            return;
        }
        if (this.riddenByEntity != null) {
            return;
        }
        if (this.unstick_timer > 0) {
            --this.unstick_timer;
        }
        if (this.lastX == (int) this.posX && this.lastZ == (int) this.posZ) {
            ++this.stuck_count;
            if (this.stuck_count > 10) {
                this.stuck_count = 0;
                this.unstick_timer = 100;
                this.target_in_sight = false;
                this.setAttacking(0);
                this.setActivity(1);
                do_new = 1;
            }
        } else {
            this.stuck_count = 0;
            this.lastX = (int) this.posX;
            this.lastZ = (int) this.posZ;
        }
        if (this.posY < this.currentFlightTarget.posY + 2.0) {
            this.motionY *= 0.7;
        } else if (this.posY > this.currentFlightTarget.posY - 2.0) {
            this.motionY *= 0.5;
        } else {
            this.motionY *= 0.61;
        }
        if (this.worldObj.rand.nextInt(60) == 1) {
            do_new = 1;
        }
        this.doRainboomDamage(this.posX, this.posY, this.posZ, 16.0, 275.0, 1);
        if (this.isTamed() && this.getOwner() != null) {
            e = this.getOwner();
            has_owner = 1;
            ox = e.posX;
            oy = e.posY;
            oz = e.posZ;
            if (this.getDistanceSqToEntity((Entity) e) > 144.0) {
                toofar = 1;
                this.target_in_sight = false;
                this.setAttacking(0);
                this.flyaway = 0;
                do_new = 1;
            }
        }
        if (this.flyaway > 0) {
            --this.flyaway;
        }
        if (toofar == 0 && this.unstick_timer == 0
            && this.flyaway == 0
            && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.noClip = true;
                if (this.isTamed() && this.getHealth() / this.mygetMaxHealth() < 0.25f) {
                    this.setActivity(1);
                    this.setAttacking(1);
                    this.RainbowAtk(e);
                    this.target_in_sight = false;
                    do_new = 0;
                    this.currentFlightTarget.set(
                        (int) (this.posX + (this.posX - e.posX)),
                        (int) (this.posY + 1.0),
                        (int) (this.posZ + (this.posZ - e.posZ)));
                } else {
                    this.setActivity(1);
                    this.setAttacking(1);
                    this.RainbowAtk(e);
                    this.target_in_sight = true;
                    this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                    do_new = 0;
                    if (this.getDistanceSqToEntity((Entity) e) < (16.0f + e.width / 2.0f) * (16.0f + e.width / 2.0f)) {
                        this.attackEntityAsMob((Entity) e);
                    }
                    if (this.getHealth() < 75.0f) {
                        this.setActivity(0);
                        this.setAttacking(0);
                        do_new = 1;
                        this.flyaway = 1;
                        this.currentFlightTarget = new ChunkCoordinates(
                            (int) this.posX,
                            (int) this.posY,
                            (int) this.posZ);
                    }
                    if (this.worldObj.rand.nextInt(600) == 1) {
                        e = null;
                        do_new = 1;
                        this.setAttacking(0);
                    }
                }
            } else {
                this.noClip = false;
                this.target_in_sight = false;
                this.setAttacking(this.flyaway = 0);
            }
        }
        if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                int gox = (int) this.posX;
                int goy = (int) this.posY;
                int goz = (int) this.posZ;
                if (has_owner == 1 && this.unstick_timer == 0) {
                    gox = (int) ox;
                    goy = (int) oy;
                    goz = (int) oz;
                    if (this.owner_flying == 0) {
                        zdir = this.worldObj.rand.nextInt(18) + 6;
                        xdir = this.worldObj.rand.nextInt(18) + 6;
                    } else {
                        zdir = this.worldObj.rand.nextInt(16);
                        xdir = this.worldObj.rand.nextInt(16);
                    }
                } else {
                    zdir = this.worldObj.rand.nextInt(20) + 6;
                    xdir = this.worldObj.rand.nextInt(20) + 6;
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    xdir = -xdir;
                }
                this.currentFlightTarget
                    .set(gox + xdir, goy + this.worldObj.rand.nextInt(12 + this.owner_flying * 2) - 4, goz + zdir);
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
        }
        obstruction_factor = 0.0;
        int dist = 2;
        dist += (int) (velocity * 4.0);
        for (int k = 1; k < dist; ++k) {
            for (int i = 1; i < dist * 2; ++i) {
                final double dx = i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f));
                final double dz = i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f));
                final Block bid2 = this.worldObj
                    .getBlock((int) (this.posX + dx), (int) this.posY - k, (int) (this.posZ + dz));
                if (bid2 != Blocks.air) {
                    obstruction_factor += 0.05;
                }
            }
        }
        this.motionY += obstruction_factor * 0.05;
        this.posY += obstruction_factor * 0.05;
        speed_factor = 1.5;
        var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        var2 = this.currentFlightTarget.posY + 0.5 - this.posY;
        var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        if (this.owner_flying != 0) {
            speed_factor = 2.25;
            if (this.isTamed() && this.getOwner() != null) {
                e = this.getOwner();
                if (this.getDistanceSqToEntity((Entity) e) > 49.0) {
                    speed_factor = 2.5;
                }
            }
        }
        this.motionX += (Math.signum(var1) - this.motionX) * 0.25 * speed_factor;
        this.motionY += (Math.signum(var2) - this.motionY) * 0.2 * speed_factor;
        this.motionZ += (Math.signum(var3) - this.motionZ) * 0.25 * speed_factor;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = (float) (0.75 * speed_factor);
        this.rotationYaw += var5 / 1.0f;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    public void onLivingUpdate() {
        List list = null;
        Entity listEntity = null;
        final double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 1.15;
        double gh = 1.0;
        double rt = 0.0;
        double pi = 3.1415926545;
        double deltav = 0.0;
        int dist = 2;
        this.FlyAway();
        if (this.getActivity() == 0) {
            super.onLivingUpdate();
        } else if (this.isDead) {
            super.onLivingUpdate();
            return;
        }
        if (this.isDead) {
            return;
        }
        if (this.worldObj.isRemote) {
            if (this.boatPosRotationIncrements > 0 && this.getActivity() != 0) {
                final double d8 = this.posX + (this.boatX - this.posX) / this.boatPosRotationIncrements;
                final double d9 = this.posY + (this.boatY - this.posY) / this.boatPosRotationIncrements;
                final double d10 = this.posZ + (this.boatZ - this.posZ) / this.boatPosRotationIncrements;
                this.setPosition(d8, d9, d10);
                this.rotationPitch += (float) ((this.boatPitch - this.rotationPitch) / this.boatPosRotationIncrements);
                double d11 = MathHelper.wrapAngleTo180_double(this.boatYaw - this.rotationYaw);
                if (this.riddenByEntity != null) {
                    d11 = MathHelper
                        .wrapAngleTo180_double((double) (this.riddenByEntity.rotationYaw - this.rotationYaw));
                }
                this.setRotation(
                    this.rotationYaw += (float) (d11 / this.boatPosRotationIncrements),
                    this.rotationPitch);
                this.rotationYawHead = this.rotationYaw;
                --this.boatPosRotationIncrements;
            }
        } else {
            if (this.riddenByEntity != null) {
                this.setBeingRidden(1);
            } else {
                this.setBeingRidden(0);
            }
            if (this.getActivity() != 0) {
                if (this.riddenByEntity != null) {
                    if (this.motionX < -2.0) {
                        this.motionX = -2.0;
                    }
                    if (this.motionX > 2.0) {
                        this.motionX = 2.0;
                    }
                    if (this.motionZ < -2.0) {
                        this.motionZ = -2.0;
                    }
                    if (this.motionZ > 2.0) {
                        this.motionZ = 2.0;
                    }
                    final double velocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                    gh = 1.55;
                    Block bid = this.worldObj
                        .getBlock((int) this.posX, (int) ((float) this.posY - (float) gh), (int) this.posZ);
                    if (bid != Blocks.air) {
                        this.motionY += 0.03;
                        this.posY += 0.1;
                    } else {
                        this.motionY -= 0.018;
                    }
                    obstruction_factor = 0.0;
                    dist = 3;
                    dist += (int) (velocity * 7.0);
                    for (int k = 1; k < dist; ++k) {
                        for (int i = 1; i < dist * 2; ++i) {
                            final double dx = i * Math.cos(Math.toRadians(this.rotationYaw + 90.0f));
                            final double dz = i * Math.sin(Math.toRadians(this.rotationYaw + 90.0f));
                            bid = this.worldObj
                                .getBlock((int) (this.posX + dx), (int) this.posY - k, (int) (this.posZ + dz));
                            if (bid != Blocks.air) {
                                obstruction_factor += 0.05;
                            }
                        }
                    }
                    this.motionY += obstruction_factor * 0.07;
                    this.posY += obstruction_factor * 0.07;
                    if (this.motionY > 2.0) {
                        this.motionY = 2.0;
                    }
                    if (this.riddenByEntity != null) {
                        double d12;
                        for (d12 = this.riddenByEntity.rotationYaw, d12 %= 360.0; d12 < 0.0; d12 += 360.0) {}
                        double d13;
                        for (d13 = this.rotationYaw, d13 %= 360.0; d13 < 0.0; d13 += 360.0) {}
                        for (relative_g = (d12 - d13) % 180.0; relative_g < 0.0; relative_g += 180.0) {}
                        if (relative_g > 90.0) {
                            relative_g -= 180.0;
                        }
                        if (velocity > 0.01) {
                            d12 = 1.85 - velocity;
                            d12 = Math.abs(d12);
                            if (d12 < 0.01) {
                                d12 = 0.01;
                            }
                            if (d12 > 0.9) {
                                d12 = 0.9;
                            }
                            this.rotationYaw = this.riddenByEntity.rotationYaw + (float) (relative_g * d12);
                        } else {
                            this.rotationYaw = this.riddenByEntity.rotationYaw;
                        }
                        relative_g = Math.abs(relative_g) * velocity;
                        if (relative_g > 50.0) {
                            relative_g = 0.0;
                        }
                    }
                    this.rotationPitch = 2.0f * (float) velocity;
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                    this.rotationYawHead = this.rotationYaw;
                    double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                    if (this.riderInput != null) {
                        final double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
                        final double rhm = Math.atan2(this.motionZ, this.motionX);
                        final double rhdir = Math.toRadians((this.riddenByEntity.rotationYaw + 90.0f) % 360.0f);
                        rt = 0.0;
                        pi = 3.1415926545;
                        deltav = 0.0;
                        final float im = this.riderInput.moveForward;
                        if (this.riderInput.jump) {
                            this.motionY += 0.025;
                            this.motionY += velocity * 0.028;
                        }
                        double rdv = Math.abs(rhm - rhdir) % (pi * 2.0);
                        if (rdv > pi) {
                            rdv -= pi * 2.0;
                        }
                        rdv = Math.abs(rdv);
                        if (Math.abs(newvelocity) < 0.01) {
                            rdv = 0.0;
                        }
                        if (rdv > 1.5) {
                            newvelocity = -newvelocity;
                        }
                        if (Math.abs(im) > 0.001f) {
                            if (im > 0.0f) {
                                deltav = 0.018;
                                if (max_speed > 1.0) {
                                    deltav += 0.05;
                                }
                                if (this.deltasmooth < 0.0f) {
                                    this.deltasmooth = 0.0f;
                                }
                                this.deltasmooth += (float) (deltav / 10.0);
                                if (this.deltasmooth > deltav) {
                                    this.deltasmooth = (float) deltav;
                                }
                            } else {
                                max_speed = 0.35;
                                deltav = -0.02;
                                if (this.deltasmooth > 0.0f) {
                                    this.deltasmooth = 0.0f;
                                }
                                this.deltasmooth += (float) (deltav / 10.0);
                                if (this.deltasmooth < deltav) {
                                    this.deltasmooth = (float) deltav;
                                }
                            }
                            newvelocity += this.deltasmooth;
                            if (newvelocity >= 0.0) {
                                if (newvelocity > max_speed) {
                                    newvelocity = max_speed;
                                }
                                this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                                this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                            } else {
                                if (newvelocity < -max_speed) {
                                    newvelocity = -max_speed;
                                }
                                newvelocity = -newvelocity;
                                this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                                this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * newvelocity;
                            }
                        } else if (newvelocity >= 0.0) {
                            this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                            this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 90.0f)) * newvelocity;
                        } else {
                            this.motionX = Math.cos(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                            this.motionZ = Math.sin(Math.toRadians(this.rotationYaw + 270.0f)) * (newvelocity * -1.0);
                        }
                    }
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    this.motionX *= 0.985;
                    this.motionY *= 0.94;
                    this.motionZ *= 0.985;
                    if (!this.worldObj.isRemote) {
                        list = this.worldObj.getEntitiesWithinAABBExcludingEntity(
                            (Entity) this,
                            this.boundingBox.expand(0.5, 0.5, 0.5));
                        if (list != null && !list.isEmpty()) {
                            for (int l = 0; l < list.size(); ++l) {
                                listEntity = (Entity) list.get(l);
                                if (listEntity != this.riddenByEntity && !listEntity.isDead
                                    && listEntity.canBePushed()) {
                                    listEntity.applyEntityCollision((Entity) this);
                                }
                            }
                        }
                    }
                    if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                        this.riddenByEntity = null;
                    }
                } else {
                    this.Dash();
                }
            }
        }
    }

    public void FlyAway() {
        EntityLivingBase e = null;
        EntityPlayer pl = null;
        if (this.worldObj.isRemote) {
            return;
        }
        if (!this.isSitting() && this.getActivity() == 0
            && this.riddenByEntity == null
            && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL
            && this.worldObj.rand.nextInt(10) == 1) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.setActivity(1);
            }
        }
        if (this.worldObj.rand.nextInt(360) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(50.0f);
        }
        if (this.worldObj.rand.nextInt(180) == 1 && this.getHealth() < 300.0f) {
            this.heal(75.0f);
        }
        if (this.worldObj.rand.nextInt(90) == 1 && this.getHealth() < 300.0f) {
            this.heal(75.0f);
        }
        if (this.worldObj.rand.nextInt(45) == 1 && this.getHealth() < 150.0f) {
            this.heal(75.0f);
        }
        if (this.isSitting()) {
            return;
        }
        this.owner_flying = 0;
        if (this.isTamed() && this.getOwner() != null && this.riddenByEntity == null && !this.isSitting()) {
            pl = (EntityPlayer) this.getOwner();
            if (pl.capabilities.isFlying) {
                this.setActivity(this.owner_flying = 1);
            }
        }
        if (this.isTamed() && this.getOwner() != null && !this.isSitting()) {
            pl = (EntityPlayer) this.getOwner();
            if (this.getDistanceSqToEntity((Entity) pl) > 400.0) {
                this.setActivity(1);
            }
        }
        if (this.worldObj.rand.nextInt(50) == 1 && !this.isSitting()
            && !this.target_in_sight
            && this.riddenByEntity == null) {
            if (this.worldObj.rand.nextInt(15) == 1) {
                this.setActivity(1);
            } else {
                this.setActivity(1);
            }
        }
    }

    public void updateRiderPosition() {
        if (this.riddenByEntity != null) {
            final float f = 0.65f;
            this.riddenByEntity.setPosition(
                this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)),
                this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset(),
                this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)));
        }
    }

    protected void playTameEffect(final boolean par1) {
        String s = "heart";
        if (!par1) {
            s = "smoke";
        }
        for (int i = 0; i < 60; ++i) {
            final double d0 = this.rand.nextGaussian() * 0.08;
            final double d2 = this.rand.nextGaussian() * 0.08;
            final double d3 = this.rand.nextGaussian() * 0.08;
            this.worldObj.spawnParticle(
                s,
                this.posX + (this.rand.nextFloat() - this.rand.nextFloat()) * 2.5f,
                this.posY + 0.5 + this.rand.nextFloat() * 1.5,
                this.posZ + (this.rand.nextFloat() - this.rand.nextFloat()) * 2.5f,
                d0,
                d2,
                d3);
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory
                .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
            var2 = null;
        }
        if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0) {
            final EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity) this, 10.0);
            if (!this.worldObj.isRemote) {
                this.setTamed(true);
                this.func_152115_b(
                    p.getUniqueID()
                        .toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity) this, (byte) 7);
                this.heal(this.mygetMaxHealth() - this.getHealth());
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory
                        .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                }
            }
            return true;
        }
        if (this.isTamed()) {
            return false;
        }
        if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0) {
            final EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity) this, 10.0);
            if (!this.worldObj.isRemote) {
                if (this.worldObj.rand.nextInt(1) == 0) {
                    this.setTamed(true);
                    this.func_152115_b(
                        p.getUniqueID()
                            .toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity) this, (byte) 7);
                    this.heal(this.mygetMaxHealth() - this.getHealth());
                } else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState((Entity) this, (byte) 6);
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack2 = var2;
                --itemStack2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory
                        .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                }
            }
            return true;
        }
        if (var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0) {
            if (!this.worldObj.isRemote) {
                par1EntityPlayer.mountEntity((Entity) this);
                this.setActivity(1);
                this.setSitting(false);
            }
            return true;
        }
        if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0) {
            if (this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity) this, (byte) 7);
            }
            if (this.mygetMaxHealth() > this.getHealth()) {
                this.heal(this.mygetMaxHealth() - this.getHealth());
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = var2;
                --itemStack3.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory
                        .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                }
            }
            return true;
        }
        if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0) {
            if (!this.worldObj.isRemote) {
                this.setTamed(false);
                this.func_152115_b("");
                this.playTameEffect(false);
                this.worldObj.setEntityState(this, (byte) 6);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack4 = var2;
                --itemStack4.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory
                        .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Items.name_tag
            && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0) {
            this.setCustomNameTag(var2.getDisplayName());
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack5 = var2;
                --itemStack5.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory
                        .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
                }
            }
            return true;
        }
        if (var2 != null && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 49.0
            && this.riddenByEntity == null) {
            if (!this.isSitting()) {
                this.setSitting(true);
                this.setActivity(0);
            } else {
                this.setSitting(false);
                this.setActivity(0);
            }
            return true;
        }
        return false;
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setAttacking(final int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    public int getActivity() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public void setActivity(final int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(21, (Object) par1);
    }

    public int getBeingRidden() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setBeingRidden(final int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(22, (Object) par1);
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && this.riddenByEntity == null && !this.isTamed();
    }

    private EntityLivingBase doRainboomDamage(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()
                && !(var8 instanceof DashInstance)
                && !(var8 instanceof AJInstance)
                && !(var8 instanceof DashCloudInstance)
                && !(var8 instanceof EntityPig)
                && !(var8 instanceof EntityTameable)
                && !(var8 instanceof EntityPlayer)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.fall, (float) damage / 1.0f);
                if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(16) == 1) {
                    this.worldObj.playSoundAtEntity((Entity) var8, Tags.MODID + ":lightningdeath", 4.5f, 3.0f);
                }
                final int mx = 60;
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                final double ks = 1.75;
                final double inair = 0.45;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
        }
        return var8;
    }

    private void RainbowAtk(final EntityLivingBase e) {
        final double yoff = 1.75;
        final double xzoff = 1.5;
        if (this.stream_count > 0) {
            this.setAttacking(2);
            if (this.rand.nextInt(15) == 1) {
                final RainbowCannonInstance var2 = new RainbowCannonInstance(
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
                    (Entity) this,
                    "random.bow",
                    0.75f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity) var2);
            }
            final RainbowCannonInstance var2 = new RainbowCannonInstance(
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
            var2.setThrowableHeading(var3, var4 + var6, var5, 5.4f, 10.0f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity) var2);
            --this.stream_count;
        } else {
            this.setAttacking(0);
        }
        if (this.stream_count <= 0 && this.rand.nextInt(4) == 1) {
            this.stream_count = 6;
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Attacking", this.getAttacking());
        par1NBTTagCompound.setInteger("Flying", this.getActivity());
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setAttacking(par1NBTTagCompound.getInteger("Attacking"));
        this.setActivity(par1NBTTagCompound.getInteger("Flying"));
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob23 extends RenderLiving {

        private static final ResourceLocation dashtexture;

        public RenderTheMob23(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob23.dashtexture;
        }

        static {
            dashtexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/DashModel.png");
        }
    }
}
