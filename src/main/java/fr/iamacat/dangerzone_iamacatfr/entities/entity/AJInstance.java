
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.AIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class AJInstance extends EntityTameable {

    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int stream_count;
    private int dmgDelay;
    private float moveSpeed;
    public int ajismad;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public AJInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.stream_count = 0;
        this.dmgDelay = 0;
        this.moveSpeed = 0.35f;
        this.ajismad = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.35f;
        this.setSize(1.0f, 1.25f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 100;
        this.fireResistance = 3;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.renderdata = new InfoRenderer();
        this.tasks.addTask(0, new EntityAISwimming( this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new AIFollowOwner((EntityTameable) this, 1.0f, 20.0f, 5.0f));
        this.tasks
            .addTask(3, new EntityAITempt( this, 1.200000047683716, Items.fish, false));
        this.tasks.addTask(4, new EntityAIWander(this, 1.0));
        this.tasks
            .addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.followRange)
            .setBaseValue(70.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(225.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
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

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory
                .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack) null);
            var2 = null;
        }
        if (super.interact(par1EntityPlayer)) {
            return true;
        }
        // if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
        if (var2 != null && var2.getItem() == Items.apple && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(1) == 0) {
                        this.setTamed(true);
                        this.func_152115_b(
                            par1EntityPlayer.getUniqueID()
                                .toString());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState((Entity) this, (byte) 7);
                        this.heal(this.mygetMaxHealth() - this.getHealth());
                    } else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState((Entity) this, (byte) 6);
                    }
                }
            } else if (this.func_152114_e((EntityLivingBase) par1EntityPlayer)) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity) this, (byte) 7);
                }
                if (this.mygetMaxHealth() > this.getHealth()) {
                    this.heal(this.mygetMaxHealth() - this.getHealth());
                }
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
        if (this.isTamed() && var2 != null
            && var2.getItem() == Item.getItemFromBlock((Block) Blocks.deadbush)
            && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 16.0
            && this.func_152114_e((EntityLivingBase) par1EntityPlayer)) {
            this.setCustomNameTag(var2.getDisplayName());
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
        if (var2.getItem() == Item.getItemFromBlock(Blocks.hay_block)
            && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 16.0) {
            this.ajismad = 1;
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
        if (this.isTamed() && var2 != null
            && var2.getItem() == Items.name_tag
            && par1EntityPlayer.getDistanceSqToEntity((Entity) this) < 25.0
            && this.func_152114_e((EntityLivingBase) par1EntityPlayer)) {
            if (!this.isSitting()) {
                this.setSitting(true);
            } else {
                this.setSitting(false);
            }
            return true;
        }
        return false;
    }

    protected boolean canDespawn() {
        if (this.isChild()) {
            this.func_110163_bv();
            return false;
        }
        return !this.isNoDespawnRequired() && !this.isTamed();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 1850;
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
        return 23;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.isInWater()) {
            this.moveSpeed = 0.25f;
        } else {
            this.moveSpeed = 0.45f;
        }
    }

    public void onDeathUpdate() {
        super.onDeathUpdate();
        for (int i = 0; i < 20; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj
                .spawnParticle("explode", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
            this.worldObj
                .spawnParticle("explode", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
            this.worldObj
                .spawnParticle("explode", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
    }

    public int getAJHealth() {
        return (int) this.getHealth();
    }

    public int getAttackStrength(final Entity par1Entity) {
        int var2 = 4;
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            var2 = 12;
            if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                var2 = 12;
            } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                var2 = 12;
            }
        }
        return var2;
    }

    protected String getLivingSound() {
        return Tags.MODID + ":aj_a1";
    }

    protected String getHurtSound() {
        return "player.hit";
    }

    protected String getDeathSound() {
        return "player.hit";
    }

    protected float getSoundVolume() {
        return 0.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItemId() {
        return Items.apple;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();
        var3 = new EntityItem(
            this.worldObj,
            this.posX + random.nextInt(3) - random.nextInt(3),
            this.posY + 1.0,
            this.posZ + random.nextInt(3) - random.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();
        var3 = new EntityItem(
            this.worldObj,
            this.posX + random.nextInt(3) - random.nextInt(3),
            this.posY + 1.0,
            this.posZ + random.nextInt(3) - random.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(Items.apple, 1);
        this.dropItemRand(Items.apple, 1);
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
        /*
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.appleHelmet, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.appleChest, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.appleLegs, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.appleBoots, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Items.appleword, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.applePick, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.appleHoe, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.appleAxe, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Items.applepade, 1);
         * }
         */
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.apple, 1);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), 275.0f);
        if (var4) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 2.0;
                double inair = 0.15;
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

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("cactus")) {
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof AJInstance) {
            return false;
        }
        if (this.dmgDelay <= 0) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.dmgDelay = 5;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof AJInstance) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving(e, 1.5);
        }
        return ret;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (!this.isInWater() && this.worldObj.rand.nextInt(25) == 0 && !this.isSitting()) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 12; ++i) {
                int j = i;
                if (j > 10) {
                    j = 10;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ((double) this.tx, (double) (this.ty - 1), (double) this.tz, 1.33);
            } else if (this.getHealth() <= 0.0f) {
                this.setDead();
                return;
            }
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 1) {
            EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                this.setAttacking(1);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.0);
                if (this.getDistanceSqToEntity(e) < (10.0f + e.width / 2.0f) * (10.0f + e.width / 2.0f)) {
                    this.setAttacking(1);
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.0);
                    if (this.worldObj.rand.nextInt(1) == 0 || this.worldObj.rand.nextInt(2) == 1) {
                        this.attackEntityAsMob(e);
                        this.ForceFeed(e);
                        this.earthQuake(this.posX, this.posY, this.posZ, 5.0, 275.0, 2);
                        this.getNavigator()
                            .tryMoveToEntityLiving(e, 1.0);
                    }
                }
                if (this.getHealth() < 75.0f) {
                    this.setAttacking(0);
                    e = null;
                }
                if (this.getDistanceSqToEntity(e) < (100.0f + e.width / 2.0f) * (100.0f + e.width / 2.0f)) {
                    e = this.findSomethingToAttack();
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 2.0);
                    this.faceEntity(e, 10.0f, 10.0f);
                    this.ForceFeed(e);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(90) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(12.0f);
        }
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
            return this.ajismad == 1;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityAnimal) {
            return false;
        }
        if (par1EntityLiving instanceof EntityVillager) {
            return this.ajismad == 1;
        }
        if (par1EntityLiving instanceof DashInstance) {
            return this.ajismad == 1;
        }
        if (par1EntityLiving instanceof DashCloudInstance) {
            return this.ajismad == 1;
        }
        if (par1EntityLiving instanceof TwilightMagicInstance) {
            return false;
        }
        if (par1EntityLiving instanceof TwilicornInstance) {
            return this.ajismad == 1;
        }
        return !this.isTamed() && MobUtils.isAttackableNonMob(par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        if (this.isChild()) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB( EntityLivingBase.class, this.boundingBox.expand(32.0, 16.0, 32.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        this.setAttackTarget(null);
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (byte) par1);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("AJMad", this.ajismad);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.ajismad = par1NBTTagCompound.getInteger("AJMad");
    }

    private void ForceFeed(final EntityLivingBase e) {
        final double yoff = 1.75;
        final double xzoff = 1.5;
        if (this.stream_count > 0) {
            this.setAttacking(2);
            if (this.rand.nextInt(15) == 1) {
                final ProjectileApplesInstance var2 = new ProjectileApplesInstance(
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
            final ProjectileApplesInstance var2 = new ProjectileApplesInstance(
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
            var2.setThrowableHeading(var3, var4 + var6, var5, 2.4f, 7.5f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var2);
            --this.stream_count;
        } else {
            this.setAttacking(0);
        }
        if (this.stream_count <= 0 && this.rand.nextInt(4) == 1) {
            this.stream_count = 8;
        }
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("AJInstance")) {
                            return true;
                        }
                    }
                }
            }
        }
        AJInstance target = null;
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        target = (AJInstance) this.worldObj.findNearestEntityWithinAABB(
             AJInstance.class,
            this.boundingBox.expand(256.0, 256.0, 256.0),
            this);
        return target == null;
    }

    private EntityLivingBase earthQuake(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB( EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, this.TargetSorter);
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
                && !(var8 instanceof TwilicornInstance)
                && !(var8 instanceof AJInstance)
                && !(var8 instanceof EntityTameable)
                && !(var8 instanceof EntityPlayer)) {
                DamageSource var9;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage);
                var8.attackEntityFrom(DamageSource.inWall, (float) damage);
                this.worldObj.playSoundAtEntity(
                    (Entity) var8,
                    "random.explode",
                    2.25f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
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
                final double ks = 1.25;
                final double inair = 0.15;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return this.spawnBabyAnimal(entityageable);
    }

    public AJInstance spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        final AJInstance w = new AJInstance(this.worldObj);
        if (this.isTamed()) {
            this.func_152115_b(this.func_152113_b());
            w.setTamed(true);
        }
        return w;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == Items.apple;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }
}
