
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ThePrinceTeen extends EntityTameable {

    private int boatPosRotationIncrements;
    private double boatX;
    private double boatY;
    private double boatZ;
    private double boatYaw;
    private double boatPitch;
    private double boatYawHead;
    private int updateit;
    private int playing;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int hurt_timer;
    private int wing_sound;
    private ChunkCoordinates currentFlightTarget;
    private boolean target_in_sight;
    private int owner_flying;
    private int flyaway;
    private float moveSpeed;
    private float deltasmooth;
    private int which_attack;
    private int fireballticker;
    private int head1ext;
    private int head2ext;
    private int head3ext;
    private int head1dir;
    private int head2dir;
    private int head3dir;
    private int kill_count;
    private int day_count;
    private int is_day;

    public ThePrinceTeen(final World par1World) {
        super(par1World);
        this.updateit = 1;
        this.playing = 0;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.hurt_timer = 0;
        this.wing_sound = 0;
        this.currentFlightTarget = null;
        this.target_in_sight = false;
        this.owner_flying = 0;
        this.flyaway = 0;
        this.moveSpeed = 0.32f;
        this.deltasmooth = 0.0f;
        this.which_attack = 0;
        this.fireballticker = 0;
        this.head1ext = 0;
        this.head2ext = 0;
        this.head3ext = 0;
        this.head1dir = 1;
        this.head2dir = 1;
        this.head3dir = 1;
        this.kill_count = 0;
        this.day_count = 0;
        this.is_day = 0;
        this.setSize(3.25f, 4.25f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 300;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.setSitting(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new MyEntityAIFollowOwner((EntityTameable) this, 1.1f, 12.0f, 2.0f));
        this.tasks.addTask(2, new EntityAITempt(this, 1.25, Items.beef, false));
        this.tasks.addTask(3, new MyEntityAIWander(this, 0.75f));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 9.0f));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.tasks.addTask(6, new EntityAIMoveIndoors(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, false));
        this.riddenByEntity = null;
        this.TargetSorter = new GenericTargetSorter(this);
        this.renderdata = new RenderInfo();
    }

    public ThePrinceTeen(final World par1World, final double par2, final double par4, final double par6) {
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
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(50.0);
    }

    public boolean shouldRiderSit() {
        return true;
    }

    public int getTrackingRange() {
        return 64;
    }

    public int getUpdateFrequency() {
        return 10;
    }

    public boolean sendsVelocityUpdates() {
        return true;
    }

    public int getHead1Ext() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public int getHead2Ext() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public int getHead3Ext() {
        return this.dataWatcher.getWatchableObjectInt(25);
    }

    public void setHead1Ext(final int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(22, (Object) par1);
    }

    public void setHead2Ext(final int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(23, (Object) par1);
    }

    public void setHead3Ext(final int par1) {
        if (this.worldObj != null && this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(25, (Object) par1);
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
        this.dataWatcher.addObject(24, (Object) 1);
        this.dataWatcher.addObject(22, (Object) 0);
        this.dataWatcher.addObject(23, (Object) 0);
        this.dataWatcher.addObject(25, (Object) 0);
        this.setActivity(0);
        this.setAttacking(0);
        this.setTamed(false);
        this.setThePrinceTeenFire(1);
        this.noClip = false;
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
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
        return 1500;
    }

    public int getThePrinceTeenHealth() {
        return (int) this.getHealth();
    }

    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(final RenderInfo r) {
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
        return 18;
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public String getLivingSound() {
        if (this.isSitting()) {
            return null;
        }
        if (this.getActivity() == 1 && this.riddenByEntity == null) {
            return Tags.MODID + ":roar";
        }
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":alo_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":alo_death";
    }

    protected float getSoundVolume() {
        return 0.6f;
    }

    public float getSoundPitch() {
        return 0.75f;
    }

    public boolean canBePushed() {
        return false;
    }

    public double getMountedYOffset() {
        return 2.75;
    }

    protected Item getDropItem() {
        return Constants.ThePrinceSpawnEgg;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(2) - rand.nextInt(2),
            this.posY + 1.0,
            this.posZ + rand.nextInt(2) - rand.nextInt(2),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(Constants.ThePrinceSpawnEgg, 1);
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = 1.75;
        double inair = 0.1;
        float iskraken = 1.0f;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            if (par1Entity instanceof Kraken) {
                iskraken = 2.0f;
            }
            par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), iskraken * 45.0f);
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            if (par1Entity instanceof EntityLiving) {
                final EntityLiving e = (EntityLiving) par1Entity;
                if (e.getHealth() <= 0.0f) {
                    ++this.kill_count;
                }
            }
        }
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        Entity e = null;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (par1DamageSource.getDamageType()
            .equals("cactus")) {
            return ret;
        }
        if (par1DamageSource.getDamageType()
            .equals("inFire")) {
            return ret;
        }
        if (par1DamageSource.getDamageType()
            .equals("onFire")) {
            return ret;
        }
        if (par1DamageSource.getDamageType()
            .equals("lava")) {
            return ret;
        }
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return ret;
        }
        this.setSitting(false);
        this.setActivity(1);
        e = par1DamageSource.getEntity();
        if (e != null && e instanceof BetterFireballInstancemMLP) {
            e.setDead();
            return ret;
        }
        if (e != null && e instanceof EntitySmallFireball) {
            e.setDead();
            return ret;
        }
        if (e != null && e instanceof ThePrinceTeen) {
            return false;
        }
        if (e != null && e instanceof Spyro) {
            return false;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        this.hurt_timer = 20;
        if (e != null && e instanceof EntityLivingBase) {
            if (this.isTamed() && e instanceof EntityPlayer) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving(e, 1.2);
            ret = true;
        }
        return ret;
    }

    public void updateAITasks() {
        EntityLivingBase e = null;
        super.updateAITasks();
        if (!this.isSitting() && this.getActivity() == 0
            && this.riddenByEntity == null
            && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL
            && this.worldObj.rand.nextInt(10) == 1) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.setActivity(1);
            } else {
                this.setAttacking(0);
            }
        }
        if (this.kill_count > 25 && this.day_count > 10) {
            Entity ent = null;
            ThePrinceAdult d = null;
            ent = spawnCreature(this.worldObj, "The Young Adult Prince", this.posX, this.posY, this.posZ);
            if (ent != null) {
                d = (ThePrinceAdult) ent;
                if (this.isTamed()) {
                    d.setTamed(true);
                    d.func_152115_b(this.func_152113_b());
                }
                this.setDead();
            }
        }
        if (this.is_day == 0) {
            this.is_day = 1;
            if (!this.worldObj.isDaytime()) {
                this.is_day = -1;
            }
        } else {
            if (this.is_day == -1 && this.worldObj.isDaytime()) {
                ++this.day_count;
            }
            this.is_day = 1;
            if (!this.worldObj.isDaytime()) {
                this.is_day = -1;
            }
        }
    }

    public void always_do() {
        EntityPlayer p = null;
        if (this.worldObj.rand.nextInt(250) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(2.0f);
        }
        if (this.worldObj.rand.nextInt(250) == 0) {
            this.setAttackTarget(null);
        }
        if (this.isSitting()) {
            return;
        }
        this.owner_flying = 0;
        if (this.isTamed() && this.getOwner() != null && this.riddenByEntity == null && !this.isSitting()) {
            p = (EntityPlayer) this.getOwner();
            if (p.capabilities.isFlying) {
                this.setActivity(this.owner_flying = 1);
            }
        }
        if (this.worldObj.rand.nextInt(50) == 1 && !this.isSitting()
            && !this.target_in_sight
            && this.riddenByEntity == null) {
            if (this.worldObj.rand.nextInt(15) == 1) {
                this.setActivity(1);
            } else {
                this.setActivity(0);
            }
        }
    }

    public void fly_with_rider() {
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        if (this.isSitting()) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.worldObj.rand.nextInt(5) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.setAttacking(1);
                if (this.getDistanceSqToEntity(e) < (8.0f + e.width / 2.0f) * (8.0f + e.width / 2.0f)) {
                    this.attackEntityAsMob(e);
                } else if (this.getDistanceSqToEntity(e) > 100.0 && this.getDistanceSqToEntity(e) < 625.0
                    && !this.isInWater()
                    && this.getThePrinceTeenFire() != 0) {
                        this.shoot_something(e.posX, e.posY, e.posZ);
                    }
            } else {
                this.setAttacking(0);
            }
        }
    }

    protected void updateAITick() {
        if (this.riddenByEntity != null) {
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
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (MyUtils.isRoyalty(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof Mothra) {
            return true;
        }
        if (par1EntityLiving instanceof Kraken) {
            return true;
        }
        if (par1EntityLiving instanceof Leon) {
            final Leon l = (Leon) par1EntityLiving;
            return !l.isTamed();
        }
        if (par1EntityLiving instanceof WaterDragon) {
            final WaterDragon i = (WaterDragon) par1EntityLiving;
            return !i.isTamed();
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            final GammaMetroid j = (GammaMetroid) par1EntityLiving;
            return !j.isTamed();
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {

        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(25.0, 20.0, 25.0));
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

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        return false;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
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
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (this.getActivity() != 0) {
            this.noClip = true;
        } else {
            this.noClip = false;
        }
        if (!this.worldObj.isRemote) {
            if (this.worldObj.rand.nextInt(10) == 1) {
                final int i = this.worldObj.rand.nextInt(3);
                if (i == 0) {
                    this.head1dir = 2;
                }
                if (i == 1) {
                    this.head1dir = -2;
                }
                if (i == 2) {
                    this.head1dir = 0;
                }
            }
            if (this.worldObj.rand.nextInt(10) == 1) {
                final int i = this.worldObj.rand.nextInt(3);
                if (i == 0) {
                    this.head2dir = 2;
                }
                if (i == 1) {
                    this.head2dir = -2;
                }
                if (i == 2) {
                    this.head2dir = 0;
                }
            }
            if (this.worldObj.rand.nextInt(10) == 1) {
                final int i = this.worldObj.rand.nextInt(3);
                if (i == 0) {
                    this.head3dir = 2;
                }
                if (i == 1) {
                    this.head3dir = -2;
                }
                if (i == 2) {
                    this.head3dir = 0;
                }
            }
            this.head1ext += this.head1dir;
            if (this.head1ext < 0) {
                this.head1ext = 0;
            }
            if (this.head1ext > 60) {
                this.head1ext = 60;
            }
            this.head2ext += this.head2dir;
            if (this.head2ext < 0) {
                this.head2ext = 0;
            }
            if (this.head2ext > 60) {
                this.head2ext = 60;
            }
            this.head3ext += this.head3dir;
            if (this.head3ext < 0) {
                this.head3ext = 0;
            }
            if (this.head3ext > 60) {
                this.head3ext = 60;
            }
            this.setHead1Ext(this.head1ext);
            this.setHead2Ext(this.head2ext);
            this.setHead3Ext(this.head3ext);
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.getActivity() == 1) {
            ++this.wing_sound;
            if (this.wing_sound > 20) {
                if (!this.worldObj.isRemote) {
                    this.worldObj.playSoundAtEntity(this, Tags.MODID + ":MothraWings", 0.5f, 1.0f);
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
            if (this.getDistanceSqToEntity(e) > 400.0) {
                this.setActivity(1);
            }
        }
    }

    private void fly_without_rider() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 10;
        int do_new = 0;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
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
        if (this.currentFlightTarget == null) {
            do_new = 1;
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.riddenByEntity != null) {
            return;
        }
        if (this.isTamed() && this.getOwner() != null) {
            e = this.getOwner();
            has_owner = 1;
            ox = e.posX;
            oy = e.posY;
            oz = e.posZ;
            if (this.getDistanceSqToEntity(e) > 400.0) {
                toofar = 1;
                this.target_in_sight = false;
                this.setAttacking(0);
                this.setSitting(false);
                this.flyaway = 0;
                do_new = 1;
            }
        }
        if (this.isSitting()) {
            return;
        }
        if (this.posY < this.currentFlightTarget.posY + 2.0) {
            this.motionY *= 0.7;
        } else if (this.posY > this.currentFlightTarget.posY - 2.0) {
            this.motionY *= 0.5;
        } else {
            this.motionY *= 0.61;
        }
        if (this.worldObj.rand.nextInt(300) == 1) {
            do_new = 1;
        }
        if (this.flyaway > 0) {
            --this.flyaway;
        }
        if (toofar == 0 && this.flyaway == 0
            && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL
            && this.worldObj.rand.nextInt(7) == 1) {
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                if (this.isTamed() && this.getHealth() / this.mygetMaxHealth() < 0.25f) {
                    this.setActivity(1);
                    this.setAttacking(0);
                    this.target_in_sight = false;
                    do_new = 0;
                    this.currentFlightTarget.set(
                        (int) (this.posX + (this.posX - e.posX)),
                        (int) (this.posY + 1.0),
                        (int) (this.posZ + (this.posZ - e.posZ)));
                } else {
                    this.setActivity(1);
                    this.setAttacking(1);
                    this.target_in_sight = true;
                    this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                    do_new = 0;
                    if (this.getDistanceSqToEntity(e) < (8.0f + e.width / 2.0f) * (8.0f + e.width / 2.0f)) {
                        this.attackEntityAsMob(e);
                        this.flyaway = 5 + this.worldObj.rand.nextInt(15);
                        do_new = 1;
                    } else if (this.getDistanceSqToEntity(e) < 400.0 && !this.isInWater()
                        && this.getThePrinceTeenFire() != 0
                        && this.worldObj.rand.nextInt(2) == 1) {
                            this.shoot_something(e.posX, e.posY, e.posZ);
                        }
                }
            } else {
                this.target_in_sight = false;
                this.setAttacking(this.flyaway = 0);
            }
        }
        if (this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            do_new = 1;
        }
        if ((do_new != 0 && !this.target_in_sight) || (do_new != 0 && this.flyaway != 0)) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                int gox = (int) this.posX;
                int goy = (int) this.posY;
                int goz = (int) this.posZ;
                if (has_owner == 1) {
                    gox = (int) ox;
                    goy = (int) oy;
                    goz = (int) oz;
                    if (this.owner_flying == 0) {
                        zdir = this.worldObj.rand.nextInt(14) + 5;
                        xdir = this.worldObj.rand.nextInt(14) + 5;
                    } else {
                        zdir = this.worldObj.rand.nextInt(6);
                        xdir = this.worldObj.rand.nextInt(6);
                    }
                } else {
                    zdir = this.worldObj.rand.nextInt(10) + 16;
                    xdir = this.worldObj.rand.nextInt(10) + 16;
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 1) {
                    xdir = -xdir;
                }
                this.currentFlightTarget
                    .set(gox + xdir, goy + this.worldObj.rand.nextInt(9 + this.owner_flying * 2) - 4, goz + zdir);
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
                final Block bid = this.worldObj
                    .getBlock((int) (this.posX + dx), (int) this.posY - k, (int) (this.posZ + dz));
                if (bid != Blocks.air) {
                    obstruction_factor += 0.05;
                }
            }
        }
        this.motionY += obstruction_factor * 0.05;
        this.posY += obstruction_factor * 0.05;
        speed_factor = 0.5;
        var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        if (this.owner_flying != 0) {
            speed_factor = 1.75;
            if (this.isTamed() && this.getOwner() != null) {
                e = this.getOwner();
                if (this.getDistanceSqToEntity(e) > 64.0) {
                    speed_factor = 3.5;
                }
            }
        }
        this.motionX += (Math.signum(var1) - this.motionX) * 0.15 * speed_factor;
        this.motionY += (Math.signum(var2) - this.motionY) * 0.21 * speed_factor;
        this.motionZ += (Math.signum(var3) - this.motionZ) * 0.15 * speed_factor;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = (float) (0.75 * speed_factor);
        this.rotationYaw += var5 / 4.0f;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
    }

    public void onLivingUpdate() {
        List list = null;
        Entity listEntity = null;
        final double d6 = this.rand.nextFloat() * 2.0f - 1.0f;
        final double d7 = (this.rand.nextInt(2) * 2 - 1) * 0.7;
        double obstruction_factor = 0.0;
        double relative_g = 0.0;
        double max_speed = 0.95;
        double gh = 1.0;
        double rt = 0.0;
        double pi = 3.1415926545;
        double deltav = 0.0;
        int dist = 2;
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
                    d11 = MathHelper.wrapAngleTo180_double(this.riddenByEntity.rotationYaw - this.rotationYaw);
                }
                this.setRotation(
                    this.rotationYaw += (float) (d11 / this.boatPosRotationIncrements),
                    this.rotationPitch);
                this.rotationYawHead = this.rotationYaw;
                --this.boatPosRotationIncrements;
            }
        } else {
            if (this.getActivity() != 0) {
                if (this.fireballticker > 0) {
                    --this.fireballticker;
                }
                if (this.riddenByEntity != null) {
                    final EntityPlayer pp = (EntityPlayer) this.riddenByEntity;
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
                    gh = 1.25;
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
                    double d8;
                    for (d8 = this.riddenByEntity.rotationYaw, d8 %= 360.0; d8 < 0.0; d8 += 360.0) {}
                    double d9;
                    for (d9 = this.rotationYaw, d9 %= 360.0; d9 < 0.0; d9 += 360.0) {}
                    for (relative_g = (d8 - d9) % 180.0; relative_g < 0.0; relative_g += 180.0) {}
                    if (relative_g > 90.0) {
                        relative_g -= 180.0;
                    }
                    if (velocity > 0.01) {
                        d8 = 1.85 - velocity;
                        d8 = Math.abs(d8);
                        if (d8 < 0.01) {
                            d8 = 0.01;
                        }
                        if (d8 > 0.9) {
                            d8 = 0.9;
                        }
                        this.rotationYaw = this.riddenByEntity.rotationYaw + (float) (relative_g * d8);
                    } else {
                        this.rotationYaw = this.riddenByEntity.rotationYaw;
                    }
                    relative_g = Math.abs(relative_g) * velocity;
                    if (relative_g > 50.0) {
                        relative_g = 0.0;
                    }
                    this.rotationPitch = 2.0f * (float) velocity;
                    this.setRotation(this.rotationYaw, this.rotationPitch);
                    double newvelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
                    final double rr = Math.atan2(this.riddenByEntity.motionZ, this.riddenByEntity.motionX);
                    final double rhm = Math.atan2(this.motionZ, this.motionX);
                    final double rhdir = Math.toRadians((this.riddenByEntity.rotationYaw + 90.0f) % 360.0f);
                    rt = 0.0;
                    pi = 3.1415926545;
                    deltav = 0.0;
                    final float im = pp.moveForward;
                    if (DangerZone.flyup_keystate != 0) {
                        this.motionY += 0.035;
                        this.motionY += velocity * 0.046;
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
                            deltav = 0.025;
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
                    if (this.fireballticker == 0 && (pp.moveStrafing < -0.001f || pp.moveStrafing > 0.001f)) {
                        double yoff = 1.5;
                        final double xzoff = 7.5;
                        ++this.which_attack;
                        if (this.which_attack > 2) {
                            this.which_attack = 0;
                        }
                        if (this.which_attack == 0) {
                            yoff += this.getHead1Ext() * 0.04f;
                            double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw - 10.0f));
                            double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw - 10.0f));
                            final BetterFireballInstancemMLP bf = new BetterFireballInstancemMLP(
                                this.worldObj,
                                this,
                                0.0,
                                0.0,
                                0.0);
                            bf.setNotMe();
                            bf.setPosition(cx, this.posY + yoff, cz);
                            cx = Math.cos(Math.toRadians(pp.rotationYawHead + 90.0f));
                            cz = Math.sin(Math.toRadians(pp.rotationYawHead + 90.0f));
                            final double cy = -Math.sin(Math.toRadians(pp.rotationPitch));
                            final double d12 = MathHelper.sqrt_double(cx * cx + cy * cy + cz * cz);
                            bf.accelerationX = cx / d12 * 0.1;
                            bf.accelerationY = cy / d12 * 0.1;
                            bf.accelerationZ = cz / d12 * 0.1;
                            bf.motionX = this.motionX;
                            bf.motionY = this.motionY;
                            bf.motionZ = this.motionZ;
                            final BetterFireballInstancemMLP betterFireball = bf;
                            betterFireball.posX -= this.motionX * 3.0;
                            final BetterFireballInstancemMLP betterFireball2 = bf;
                            betterFireball2.posY -= this.motionY * 3.0;
                            final BetterFireballInstancemMLP betterFireball3 = bf;
                            betterFireball3.posZ -= this.motionZ * 3.0;
                            this.worldObj.playSoundAtEntity(
                                this,
                                "random.fuse",
                                1.0f,
                                1.0f / (this.getRNG()
                                    .nextFloat() * 0.4f + 0.8f));
                            this.worldObj.spawnEntityInWorld(bf);
                        }
                        if (this.which_attack == 1) {
                            yoff += this.getHead3Ext() * 0.04f;
                            final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw + 10.0f));
                            final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw + 10.0f));
                            final IceBall var2 = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
                            var2.setLocationAndAngles(
                                cx,
                                this.posY + yoff,
                                cz,
                                pp.rotationYaw + 90.0f,
                                pp.rotationPitch);
                            var2.setIceMaker(1);
                            final double var3 = Math.cos(Math.toRadians(pp.rotationYaw + 90.0f));
                            final double var4 = -Math.sin(Math.toRadians(pp.rotationPitch));
                            final double var5 = Math.sin(Math.toRadians(pp.rotationYaw + 90.0f));
                            final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
                            var2.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
                            final IceBall iceBall = var2;
                            iceBall.posX -= this.motionX * 3.0;
                            final IceBall iceBall2 = var2;
                            iceBall2.posY -= this.motionY * 3.0;
                            final IceBall iceBall3 = var2;
                            iceBall3.posZ -= this.motionZ * 3.0;
                            final IceBall iceBall4 = var2;
                            iceBall4.motionX *= 2.0;
                            final IceBall iceBall5 = var2;
                            iceBall5.motionY *= 2.0;
                            final IceBall iceBall6 = var2;
                            iceBall6.motionZ *= 2.0;
                            this.worldObj.playSoundAtEntity(
                                this,
                                "fireworks.launch",
                                0.75f,
                                1.0f / (this.getRNG()
                                    .nextFloat() * 0.4f + 0.8f));
                            this.worldObj.spawnEntityInWorld(var2);
                        }
                        if (this.which_attack == 2) {
                            yoff += this.getHead2Ext() * 0.04f;
                            final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
                            final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
                            final ThunderBolt lb = new ThunderBolt(this.worldObj, pp);
                            lb.setLocationAndAngles(cx, this.posY + yoff, cz, pp.rotationYaw + 90.0f, pp.rotationPitch);
                            final ThunderBolt thunderBolt = lb;
                            thunderBolt.motionX *= 3.0;
                            final ThunderBolt thunderBolt2 = lb;
                            thunderBolt2.motionY *= 3.0;
                            final ThunderBolt thunderBolt3 = lb;
                            thunderBolt3.motionZ *= 3.0;
                            this.worldObj.playSoundAtEntity(
                                this,
                                "random.bow",
                                0.75f,
                                1.0f / (this.getRNG()
                                    .nextFloat() * 0.4f + 0.8f));
                            this.worldObj.spawnEntityInWorld(lb);
                        }
                        this.fireballticker = 10;
                    }
                    this.moveEntity(this.motionX, this.motionY, this.motionZ);
                    this.motionX *= 0.985;
                    this.motionY *= 0.94;
                    this.motionZ *= 0.985;
                    if (!this.worldObj.isRemote) {
                        list = this.worldObj
                            .getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand(3.25, 4.0, 3.25));
                        if (list != null && !list.isEmpty()) {
                            for (int l = 0; l < list.size(); ++l) {
                                listEntity = (Entity) list.get(l);
                                if (listEntity != this.riddenByEntity && !listEntity.isDead
                                    && listEntity.canBePushed()) {
                                    listEntity.applyEntityCollision(this);
                                }
                            }
                        }
                    }
                    this.fly_with_rider();
                    if (this.riddenByEntity != null && this.riddenByEntity.isDead) {
                        this.riddenByEntity = null;
                    }
                } else {
                    this.fly_without_rider();
                }
            }
            this.always_do();
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
        for (int i = 0; i < 20; ++i) {
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
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
            if (!this.worldObj.isRemote) {
                this.setTamed(true);
                this.func_152115_b(
                    par1EntityPlayer.getUniqueID()
                        .toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 7);
                this.heal(this.mygetMaxHealth() - this.getHealth());
                this.kill_count = 1000;
                this.day_count = 1000;
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed()) {
            if (!this.func_152114_e(par1EntityPlayer)) {
                return false;
            }
            if (var2 == null && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
                if (!this.worldObj.isRemote) {
                    par1EntityPlayer.mountEntity(this);
                    this.setActivity(1);
                    this.setSitting(false);
                }
                return true;
            }
            if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
                if (this.mygetMaxHealth() > this.getHealth()) {
                    this.heal(this.mygetMaxHealth() - this.getHealth());
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack2 = var2;
                    --itemStack2.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
                return true;
            }
            if (var2 != null && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0
                && var2.getItem() instanceof ItemFood) {
                if (!this.worldObj.isRemote) {
                    final ItemFood var3 = (ItemFood) var2.getItem();
                    if (this.mygetMaxHealth() > this.getHealth()) {
                        this.heal((float) (var3.func_150905_g(var2) * 10));
                    }
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack3 = var2;
                    --itemStack3.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
                return true;
            }
            if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.ice)
                && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
                if (!this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 6);
                    this.setThePrinceTeenFire(0);
                    String healthMessage = new String();
                    healthMessage = String.format("Fireballs extinguished.", new Object[0]);
                    par1EntityPlayer.addChatComponentMessage((IChatComponent) new ChatComponentText(healthMessage));
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack4 = var2;
                    --itemStack4.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
                return true;
            }
            if (var2 != null && var2.getItem() == Items.flint_and_steel
                && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
                if (!this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 6);
                    this.setThePrinceTeenFire(1);
                    String healthMessage = new String();
                    healthMessage = "Fireballs lit!";
                    par1EntityPlayer.addChatComponentMessage((IChatComponent) new ChatComponentText(healthMessage));
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack5 = var2;
                    --itemStack5.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
                return true;
            }
            if (var2 != null && var2.getItem() == Items.diamond
                && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0
                && !this.worldObj.isRemote) {
                Entity ent = null;
                ThePrince d = null;
                ent = spawnCreature(this.worldObj, "The Prince", this.posX, this.posY, this.posZ);
                if (ent != null) {
                    d = (ThePrince) ent;
                    if (this.isTamed()) {
                        d.setTamed(true);
                        d.func_152115_b(
                            par1EntityPlayer.getUniqueID()
                                .toString());
                        d.set_ok_to_grow();
                    }
                    this.setDead();
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack6 = var2;
                    --itemStack6.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
                return true;
            }
            if (this.isTamed() && var2 != null
                && var2.getItem() == Items.name_tag
                && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0
                && this.func_152114_e(par1EntityPlayer)) {
                this.setCustomNameTag(var2.getDisplayName());
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack7 = var2;
                    --itemStack7.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
                return true;
            }
            if (var2 != null && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
                if (!this.isSitting()) {
                    this.setSitting(true);
                    this.setActivity(0);
                } else {
                    this.setSitting(false);
                    this.setActivity(0);
                }
                return true;
            }
        }
        return false;
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.beef;
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

    public int getThePrinceTeenFire() {
        return this.dataWatcher.getWatchableObjectInt(24);
    }

    public void setThePrinceTeenFire(final int par1) {
        if (this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(24, (Object) par1);
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && this.riddenByEntity == null && !this.isTamed();
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("ThePrinceTeenAttacking", this.getAttacking());
        par1NBTTagCompound.setInteger("ThePrinceTeenActivity", this.getActivity());
        par1NBTTagCompound.setInteger("ThePrinceTeenFire", this.getThePrinceTeenFire());
        par1NBTTagCompound.setInteger("SpyroKill", this.kill_count);
        par1NBTTagCompound.setInteger("SpyroDay", this.day_count);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setAttacking(par1NBTTagCompound.getInteger("ThePrinceTeenAttacking"));
        this.setActivity(par1NBTTagCompound.getInteger("ThePrinceTeenActivity"));
        this.setThePrinceTeenFire(par1NBTTagCompound.getInteger("ThePrinceTeenFire"));
        this.kill_count = par1NBTTagCompound.getInteger("SpyroKill");
        this.day_count = par1NBTTagCompound.getInteger("SpyroDay");
    }

    private void shoot_something(final double x, final double y, final double z) {
        double rr = 0.0;
        double rhdir = 0.0;
        double rdd = 0.0;
        final double pi = 3.1415926545;
        final int which = this.worldObj.rand.nextInt(3);
        if (which == 0) {
            rr = Math.atan2(z - this.posZ, x - this.posX);
            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (rdd < 0.5) {
                this.firecanon(x, y, z);
            }
        } else if (which == 1) {
            rr = Math.atan2(z - this.posZ, x - this.posX);
            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (rdd < 0.5) {
                this.firecanonl(x, y, z);
            }
        } else {
            rr = Math.atan2(z - this.posZ, x - this.posX);
            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
            if (rdd > pi) {
                rdd -= pi * 2.0;
            }
            rdd = Math.abs(rdd);
            if (rdd < 0.5) {
                this.firecanoni(x, y, z);
            }
        }
    }

    private void firecanon(final double x, final double y, final double z) {
        final double yoff = 3.5;
        final double xzoff = 6.0;
        BetterFireballInstancemMLP bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new BetterFireballInstancemMLP(
            this.worldObj,
            this,
            x - cx + r1,
            y + 0.25 - (this.posY + yoff) + r2,
            z - cz + r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setBig();
        this.worldObj.playSoundAtEntity(
            this,
            "random.bow",
            1.0f,
            1.0f / (this.getRNG()
                .nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(bf);
    }

    private void firecanonl(final double x, final double y, final double z) {
        final double yoff = 3.5;
        final double xzoff = 6.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        this.worldObj.playSoundAtEntity(
            this,
            "random.bow",
            1.0f,
            1.0f / (this.getRNG()
                .nextFloat() * 0.4f + 0.8f));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
        var3 = x - lb.posX;
        var4 = y + 0.25 - lb.posY;
        var5 = z - lb.posZ;
        var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
        lb.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 4.0f);
        final ThunderBolt thunderBolt = lb;
        thunderBolt.motionX *= 3.0;
        final ThunderBolt thunderBolt2 = lb;
        thunderBolt2.motionY *= 3.0;
        final ThunderBolt thunderBolt3 = lb;
        thunderBolt3.motionZ *= 3.0;
        this.worldObj.spawnEntityInWorld(lb);
    }

    private void firecanoni(final double x, final double y, final double z) {
        final double yoff = 3.5;
        final double xzoff = 6.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        this.worldObj.playSoundAtEntity(
            this,
            "random.bow",
            1.0f,
            1.0f / (this.getRNG()
                .nextFloat() * 0.4f + 0.8f));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final IceBall lb = new IceBall(this.worldObj, cx, this.posY + yoff, cz);
        lb.setIceMaker(1);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
        var3 = x - lb.posX;
        var4 = y + 0.25 - lb.posY;
        var5 = z - lb.posZ;
        var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
        lb.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 4.0f);
        final IceBall iceBall = lb;
        iceBall.motionX *= 3.0;
        final IceBall iceBall2 = lb;
        iceBall2.motionY *= 3.0;
        final IceBall iceBall3 = lb;
        iceBall3.motionZ *= 3.0;
        this.worldObj.spawnEntityInWorld(lb);
    }
}
