
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.AIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TwilicornInstance  extends EntityTameable
{
    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    public int activity;
    private int owner_flying;
    private float moveSpeed;
    private int syncit;
    private int ok_to_grow;
    private int kill_count;
    private int fed_count;
    private int day_count;
    private int is_day;
    private int flutter;
    private int stream_count;
    private int gothitcount;
    private int gothitcountmob;
    private int hugemob;
    private int twipower;
    private int stuck_count;
    private int lastX;
    private int lastZ;

    public TwilicornInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.activity = 1;
        this.owner_flying = 0;
        this.moveSpeed = 0.3f;
        this.syncit = 0;
        this.ok_to_grow = 0;
        this.kill_count = 0;
        this.fed_count = 0;
        this.day_count = 0;
        this.is_day = 0;
        this.flutter = 0;
        this.stream_count = 0;
        this.gothitcount = 0;
        this.gothitcountmob = 0;
        this.hugemob = 0;
        this.twipower = Integer.MAX_VALUE;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.setSize(0.75f, 1.25f);
        this.moveSpeed = 0.32f;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.getNavigator().setAvoidsWater(true);
        this.setSitting(false);
        this.tasks.addTask(1, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
        this.tasks.addTask(2, (EntityAIBase)new AIFollowOwner((EntityTameable)this, 1.75f, 16.0f, 2.5f));
        this.tasks.addTask(3, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25, ItemInitDangerZone.twilightStar, false));
        this.tasks.addTask(4, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityLiving.class, 6.0f));
        this.tasks.addTask(7, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
        this.TargetSorter = new GenericTargetSorter((Entity)this);
        this.experienceValue = 7555;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(1.5);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(1.0);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(70.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.activity = 1;
        this.dataWatcher.addObject(22, (Object)0);
        this.dataWatcher.addObject(21, (Object)this.activity);
        this.dataWatcher.addObject(20, (Object)1);
        this.setSitting(false);
        this.setTamed(false);
        this.noClip = false;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("DataWatcherMove", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("DataWatcherFire", this.dataWatcher.getWatchableObjectInt(20));
        par1NBTTagCompound.setInteger("Enough", this.ok_to_grow);
        par1NBTTagCompound.setInteger("TwilightKills", this.kill_count);
        par1NBTTagCompound.setInteger("TwilightSat", this.fed_count);
        par1NBTTagCompound.setInteger("ExistedTime", this.day_count);
        par1NBTTagCompound.setInteger("FullPowerAlicorn", this.hugemob);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.activity = par1NBTTagCompound.getInteger("DataWatcherMove");
        this.dataWatcher.updateObject(21, (Object)this.activity);
        this.dataWatcher.updateObject(20, (Object)par1NBTTagCompound.getInteger("DataWatcherFire"));
        this.ok_to_grow = par1NBTTagCompound.getInteger("Enough");
        this.kill_count = par1NBTTagCompound.getInteger("TwilightKills");
        this.fed_count = par1NBTTagCompound.getInteger("TwilightSat");
        this.day_count = par1NBTTagCompound.getInteger("ExistedTime");
        this.hugemob = par1NBTTagCompound.getInteger("FullPowerAlicorn");
    }

    public int getActive() {
        final int i = this.dataWatcher.getWatchableObjectInt(21);
        return this.activity = i;
    }

    public void setActive(final int par1) {
        this.activity = par1;
        this.dataWatcher.updateObject(21, (Object)0);
        this.dataWatcher.updateObject(21, (Object)par1);
    }

    public int getTwiFire() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setTwiFire(final int par1) {
        this.dataWatcher.updateObject(20, (Object)par1);
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setAttacking(final int par1) {
        this.dataWatcher.updateObject(22, (Object)par1);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        if (this.hugemob == 1) {
            return Integer.MAX_VALUE;
        }
        return 1250;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == ItemInitDangerZone.twilightStar && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 25.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(1) == 0) {
                        this.setTamed(true);
                        this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState((Entity)this, (byte)7);
                        this.heal(this.mygetMaxHealth() - this.getHealth());
                    }
                    else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState((Entity)this, (byte)6);
                    }
                }
            }
            else if (this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                }
                if (this.mygetMaxHealth() > this.getHealth()) {}
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        /*if (var2 != null && var2.getItem() == ItemInitDangerZone.auroraGem && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0) {
            if (!this.worldObj.isRemote) {
                this.setTamed(true);
                this.func_152115_b(par1EntityPlayer.getUniqueID().toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)7);
                this.heal(this.mygetMaxHealth() - this.getHealth());
                this.ok_to_grow = 1;
                this.kill_count = 1000;
                this.fed_count = 1000;
                this.day_count = 1000;
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack2 = var2;
                --itemStack2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }


            return true;
        }

         */
        if (this.isTamed() && var2 != null && this.func_152114_e((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && var2.getItem() instanceof ItemFood) {
            if (!this.worldObj.isRemote) {
                final ItemFood var3 = (ItemFood)var2.getItem();
                if (this.mygetMaxHealth() > this.getHealth()) {
                    this.heal((float)(var3.func_150905_g(var2) * 1250));
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity)this, (byte)7);
                    ++this.fed_count;
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = var2;
                --itemStack3.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        /*if (this.isTamed() && var2 != null && var2.getItem() == ItemInitDangerZone.apples && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)6);
                this.setTwiFire(0);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack4 = var2;
                --itemStack4.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }

         */
        /*if (this.isTamed() && var2 != null && var2.getItem() == ItemInitDangerZone.balloons && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState((Entity)this, (byte)6);
                this.setTwiFire(1);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack5 = var2;
                --itemStack5.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }

         */
        if (this.isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            this.setCustomNameTag(var2.getDisplayName());
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack6 = var2;
                --itemStack6.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }
            }
            return true;
        }
        if (this.isTamed() && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0 && this.func_152114_e((EntityLivingBase)par1EntityPlayer)) {
            if (!this.isSitting()) {
                this.setSitting(true);
                this.setActive(1);
            }
            else {
                this.setSitting(false);
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public void setCool() {
        this.ok_to_grow = 1;
        this.kill_count = 0;
        this.fed_count = 0;
        this.day_count = 0;
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == ItemInitDangerZone.twilightStar;
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        return "";
    }

    protected String getHurtSound() {
        return "damage.hit";
    }

    protected String getDeathSound() {
        return "damage.hit";
    }

    protected float getSoundVolume() {
        return 0.5f;
    }

    public int getTotalArmorValue() {
        if (this.hugemob != 0) {
            return 24;
        }
        return 22;
    }

    protected Item getDropItemId() {
        return ItemInitDangerZone.twilightStar;
    }

   /* private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + Basic.TwilightRand.nextInt(3) - Basic.TwilightRand.nextInt(3), this.posY + 1.0, this.posZ + Basic.TwilightRand.nextInt(3) - Basic.TwilightRand.nextInt(3), is);
        final float f3 = (float)Math.atan2(Basic.TwilightRand2.nextInt() - this.posZ, Basic.TwilightRand2.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.15000000596046448, 0.25, Math.sin(f3) * 0.15000000596046448);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    */

   /* private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(this.worldObj, this.posX + Basic.TwilightRand.nextInt(3) - Basic.TwilightRand.nextInt(3), this.posY + 1.0, this.posZ + Basic.TwilightRand.nextInt(3) - Basic.TwilightRand.nextInt(3), is);
        final float f3 = (float)Math.atan2(Basic.TwilightRand2.nextInt() - this.posZ, Basic.TwilightRand2.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.15000000596046448, 0.25, Math.sin(f3) * 0.15000000596046448);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity)var3);
        }
        return is;
    }

    */

    protected void dropFewItems(final boolean par1, final int par2) {
        /*this.dropItemRand(ItemInitDangerZone.twilicornHelmet, 1);
        this.dropItemRand(Basic.twilicornChest, 1);
        this.dropItemRand(Basic.twilicornLegs, 1);
        this.dropItemRand(Basic.twilicornBoots, 1);
        this.dropItemRand(Basic.twilicornBow, 1);
        this.dropItemRand(Basic.twilicornItem, 1);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropBlockRand(Basic.twilicornBlock, 64);
        this.dropItemRand(Basic.twilightStar, 64);
        this.dropItemRand(Basic.twilicornSword, 1);
        this.dropItemRand(Basic.twilicornSpade, 1);
        this.dropItemRand(Basic.twilicornHoe, 1);
        this.dropItemRand(Basic.twilicornAxe, 1);
        this.dropItemRand(Basic.twilicornPick, 1);
        this.dropItemRand(Basic.eggMyself, 1);
        this.dropItemRand((Item)Basic.twiMeat, 12);
        for (int var5 = 50 + this.worldObj.rand.nextInt(30), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Basic.twilightStar, 1);
        }
        for (int var5 = 100 + this.worldObj.rand.nextInt(160), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand((Item)Basic.twiMeat, 1);
        }
        for (int var5 = 50 + this.worldObj.rand.nextInt(60), var6 = 0; var6 < var5; ++var6) {
            this.dropBlockRand(Basic.twilicornBlock, 1);
        }

         */
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {
    }

    protected void updateFallState(final double par1, final boolean par3) {
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public float getAttackStrength(final Entity par1Entity) {
        return 195.0f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final float s = par1Entity.height * par1Entity.width;
            if (s > 50.0f && !(par1Entity instanceof HydraInstance) && !(par1Entity instanceof SpikezillaInstance) && !(par1Entity instanceof SpikezillaInstance) && !(par1Entity instanceof WindigoInstance) && !(par1Entity instanceof CrabzillaInstance) && !(par1Entity instanceof UrsaMAJORInstance)) {
                this.hugemob = 1;
                final EntityLivingBase e = (EntityLivingBase)par1Entity;
                if (this.worldObj.rand.nextInt(2) == 1) {
                    e.setHealth(e.getHealth() / 16.0f - 2750.0f);
                    for (int mx = 60, var3 = 0; var3 < mx; ++var3) {
                        final float f = 0.75f;
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                        e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    }
                    if (this.worldObj.rand.nextInt(275) == 1) {
                        final double xzoff = 1.0;
                        final double yoff = 1.0;
                        for (int var4 = 0; var4 < 75; ++var4) {
                            final Entity ds = spawnCreature(this.worldObj, "MyTwilightMagic", this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                        }
                    }
                    this.hugemob = 1;
                }
            }
        }
        final float var5 = this.getAttackStrength(par1Entity);
        boolean var6 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var5);
        if (par1Entity instanceof EntityLivingBase) {
            final EntityLivingBase el = (EntityLivingBase)par1Entity;
            final float f2 = 0.75f;
            if (el.getHealth() <= 0.0f) {
                ++this.kill_count;
                el.setHealth(el.getHealth() / 4.0f - 1.0f);
                var6 = el.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), el.getMaxHealth() / 8.0f);
                this.worldObj.spawnParticle("witchMagic", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                for (int mx2 = 60, var7 = 0; var7 < mx2; ++var7) {
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                    el.worldObj.spawnParticle("fireworksSpark", this.posX - f2 * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f2 * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
                }
            }
        }
        return var6;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        final Entity e = par1DamageSource.getEntity();
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
        if (par1DamageSource.getDamageType().equals("inWall")) {
            return false;
        }
        if (!par1DamageSource.getDamageType().equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, dm);
            this.setSitting(false);
            this.setActive(2);
        }
        return ret;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ), Vec3.createVectorHelper(pX, pY, pZ), false) == null;
    }

    private void MagicCannon(final EntityLivingBase e) {
        final double yoff = 1.95;
        final double xzoff = 1.5;
        if (this.stream_count > 0) {
            this.setAttacking(2);
            if (this.rand.nextInt(2) == 1) {
                final TwilyMagicInstance var2 = new TwilyMagicInstance(this.worldObj, e.posX - this.posX, e.posY + 0.75 - (this.posY + yoff), e.posZ - this.posZ);
                var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)), this.rotationYaw, this.rotationPitch);
                this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)var2);
            }
            final TwilyMagicInstance var2 = new TwilyMagicInstance(this.worldObj, e.posX - this.posX, e.posY + 0.75 - (this.posY + yoff), e.posZ - this.posZ);
            var2.setLocationAndAngles(this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)), this.rotationYawHead, this.rotationPitch);
            final double var3 = e.posX - var2.posX;
            final double var4 = e.posY + 0.25 - var2.posY;
            final double var5 = e.posZ - var2.posZ;
            final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
            var2.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 5.0f);
            this.worldObj.playSoundAtEntity((Entity)this, "random.explode", 0.75f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)var2);
            --this.stream_count;
        }
        else {
            this.setAttacking(0);
        }
        if (this.stream_count <= 0 && this.rand.nextInt(4) == 1) {
            this.stream_count = 8;
        }
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.flutter;
        if (this.flutter > 20) {
            if (!this.worldObj.isRemote) {
                this.worldObj.playSoundAtEntity(this, Tags.MODID +":flap_a1", 0.4f, 2.0f);
            }
            this.flutter = 0;
        }
        if ((this.gothitcount < 5 && this.getHealth() < 250.0f && this.hugemob == 1) || (this.gothitcountmob < 75 && this.getHealth() < 250.0f && this.hugemob == 1)) {
            this.setHealth(250.0f);
            this.heal(250.0f - this.getHealth());
        }
        if (this.getActive() == 2) {
            this.noClip = true;
        }
        else {
            this.noClip = false;
        }
    }

    public void onLivingUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)this.moveSpeed);
        super.onLivingUpdate();
        EntityLivingBase e = null;
        if (this.isInWater()) {
            this.motionY += 0.07;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        ++this.syncit;
        if (this.syncit > 20) {
            this.syncit = 0;
            if (this.worldObj.isRemote) {
                this.getActive();
            }
            else {
                final int j = this.activity;
                this.setActive(j);
            }
        }
        if (this.activity == 2) {
            this.motionY *= 0.0;
            final float f = 0.25f;
            this.worldObj.spawnParticle("witchMagic", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("witchMagic", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("witchMagic", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
        }
        e = this.findSomethingToAttack();
        if (e != null) {
            final double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
            final double b = Math.atan2(e.posZ - this.posZ - 0.5, e.posX - this.posX - 0.5);
            final double c = Math.atan2(e.posZ - this.posZ + 1.0, e.posX - this.posX + 1.0);
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(a));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.369999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.5, Math.sin(a));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.339999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 11.0, Math.sin(a));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.429999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.5, Math.sin(a));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.459999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.0, Math.sin(a));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(a));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.369999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.2, Math.sin(a));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.339999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.4, Math.sin(a));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.429999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.8, Math.sin(a));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.459999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.6, Math.sin(a));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(b));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.369999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.5, Math.sin(b));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.339999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 11.0, Math.sin(b));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.429999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.5, Math.sin(b));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.459999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.0, Math.sin(b));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(b));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.369999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.2, Math.sin(b));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.339999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.4, Math.sin(b));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.429999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.8, Math.sin(b));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.459999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.6, Math.sin(b));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(c));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.369999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.5, Math.sin(c));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.339999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 11.0, Math.sin(c));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.429999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.5, Math.sin(c));
            this.worldObj.spawnParticle("fireworksSpark", this.posX, this.posY + 1.459999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.0, Math.sin(c));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.399999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.0, Math.sin(c));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.369999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.2, Math.sin(c));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.339999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 10.4, Math.sin(c));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.429999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.8, Math.sin(c));
            this.worldObj.spawnParticle("witchMagic", this.posX, this.posY + 1.459999976158142, this.posZ, Math.cos(a), (e.posY - this.posY) / 9.6, Math.sin(c));
        }
    }

    protected void updateAITasks() {
        final double xzoff = 1.5;
        final double yoff = 1.0;
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(2500) == 1) {
            this.setRevengeTarget((EntityLivingBase)null);
        }
        if (this.activity != 2) {
            super.updateAITasks();
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        if (this.worldObj.rand.nextInt(1) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(2.0f);
        }
        if (!this.isSitting()) {
            if (this.activity == 0) {
                this.setActive(1);
            }
            if (this.worldObj.rand.nextInt(100) == 1) {
                if (this.worldObj.rand.nextInt(20) == 1) {
                    this.setActive(2);
                }
                else {
                    this.setActive(1);
                }
            }
            if (this.activity == 1 && this.isTamed() && this.getOwner() != null) {
                final EntityLivingBase e = this.getOwner();
                if (this.getDistanceSqToEntity((Entity)e) > 256.0) {
                    this.setActive(2);
                }
            }
            this.Flutter();
        }
        else if (this.isTamed() && this.getOwner() != null) {
            final EntityLivingBase e = this.getOwner();
            if (this.getDistanceSqToEntity((Entity)e) > 256.0) {
                this.setSitting(false);
                this.setActive(2);
            }
        }
        if (this.is_day == 0) {
            this.is_day = 1;
            if (!this.worldObj.isDaytime()) {
                this.is_day = -1;
            }
        }
        else {
            if (this.is_day == -1 && this.worldObj.isDaytime()) {
                ++this.day_count;
            }
            this.is_day = 1;
            if (!this.worldObj.isDaytime()) {
                this.is_day = -1;
            }
        }
        if (this.worldObj.rand.nextInt(8) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(5.0f);
        }
        if (this.worldObj.rand.nextInt(10) == 1 && this.hugemob != 0 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(175.0f);
        }
    }

    private void Flutter() {
        int xdir = 1;
        int zdir = 1;
        int restless = 10;
        if (this.worldObj.rand.nextInt(475) == 1) {
            final double xzoff = 1.0;
            final double yoff = 1.0;
            for (int var4 = 0; var4 < 45; ++var4) {
                final Entity ds = spawnCreature(this.worldObj, "MyTwilightMagic", this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + yoff, this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
            }
        }
        int do_new = 0;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        int has_owner = 0;
        double rr = 0.0;
        double rhdir = 0.0;
        double rdd = 0.0;
        final double pi = 3.1415926545;
        EntityLivingBase e = null;
        if (this.currentFlightTarget == null) {
            do_new = 1;
            this.currentFlightTarget = new ChunkCoordinates((int)this.posX, (int)this.posY, (int)this.posZ);
        }
        if (this.activity == 2 && this.worldObj.rand.nextInt(300) == 0) {
            do_new = 1;
        }
        if (this.lastX == (int)this.posX && this.lastZ == (int)this.posZ) {
            ++this.stuck_count;
            if (this.stuck_count > 10) {
                this.setAttacking(this.stuck_count = 0);
                this.setActive(1);
                do_new = 1;
            }
        }
        else {
            this.stuck_count = 0;
            this.lastX = (int)this.posX;
            this.lastZ = (int)this.posZ;
        }
        if (this.isTamed() && this.getOwner() != null) {
            e = this.getOwner();
            has_owner = 1;
            ox = e.posX;
            oy = e.posY + 1.0;
            oz = e.posZ;
            if (this.getDistanceSqToEntity((Entity)e) > 120.0) {
                do_new = 1;
            }
            if (this.owner_flying != 0 && this.getDistanceSqToEntity((Entity)e) > 42.0) {
                do_new = 1;
            }
        }
        if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity((Entity)e, 10.0f, 10.0f);
                if (this.isTamed() && this.getHealth() / this.mygetMaxHealth() < 0.25f) {
                    this.setActive(2);
                    this.setAttacking(0);
                    do_new = 0;
                    this.currentFlightTarget.set((int)(this.posX + (this.posX - e.posX)), (int)(this.posY + 1.0), (int)(this.posZ + (this.posZ - e.posZ)));
                }
                else {
                    this.setActive(2);
                    this.setAttacking(1);
                    this.currentFlightTarget.set((int)e.posX, (int)(e.posY + 3.0), (int)e.posZ);
                    do_new = 0;
                    if (this.getDistanceSqToEntity((Entity)e) < (20.0f + e.width / 2.0f) * (20.0f + e.width / 2.0f)) {
                        this.attackEntityAsMob((Entity)e);
                        this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.0);
                        this.faceEntity((Entity)e, 10.0f, 10.0f);
                        this.MagicBolt(e);
                        this.MagicCannon(e);
                        this.MagicExplode(e);
                        this.MagicSigma(e);
                        if (this.hugemob != 0) {
                            this.faceEntity((Entity)e, 10.0f, 10.0f);
                            this.MagicBoltOp(e);
                            this.MagicCannon(e);
                            this.MagicCannon(e);
                            this.MagicExplodeOp(e);
                            this.attackEntityAsMob((Entity)e);
                            this.MagicSigma(e);
                        }
                    }
                    if (this.getDistanceSqToEntity((Entity)e) < (60.0f + e.width / 2.0f) * (60.0f + e.width / 2.0f)) {
                        this.faceEntity((Entity)e, 10.0f, 10.0f);
                        this.MagicBolt(e);
                        this.MagicExplode(e);
                        this.MagicCannon(e);
                        if (this.hugemob != 0) {
                            this.faceEntity((Entity)e, 10.0f, 10.0f);
                            this.MagicBoltOp(e);
                            this.MagicCannon(e);
                            this.MagicCannon(e);
                            this.MagicExplodeOp(e);
                            this.attackEntityAsMob((Entity)e);
                            this.attackEntityAsMob((Entity)e);
                            this.attackEntityAsMob((Entity)e);
                            this.attackEntityAsMob((Entity)e);
                        }
                    }
                    else if (this.getDistanceSqToEntity((Entity)e) > 175.0 && this.getDistanceSqToEntity((Entity)e) < 244.0 && !this.isInWater() && this.getTwiFire() != 0 && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1)) {
                        final int which = this.worldObj.rand.nextInt(3);
                        if (which == 0) {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5 && this.getTwiFire() != 0) {
                                this.faceEntity((Entity)e, 10.0f, 10.0f);
                                this.MagicBolt(e);
                                this.MagicExplode(e);
                                this.MagicCannon(e);
                                if (this.hugemob != 0) {
                                    this.faceEntity((Entity)e, 10.0f, 10.0f);
                                    this.MagicBoltOp(e);
                                    this.MagicCannon(e);
                                    this.MagicCannon(e);
                                    this.MagicExplodeOp(e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.attackEntityAsMob((Entity)e);
                                }
                            }
                        }
                        else if (which == 1) {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5 && this.getTwiFire() != 0) {
                                this.faceEntity((Entity)e, 10.0f, 10.0f);
                                this.MagicBolt(e);
                                this.MagicExplode(e);
                                this.MagicSigma(e);
                                if (this.hugemob != 0) {
                                    this.faceEntity((Entity)e, 10.0f, 10.0f);
                                    this.MagicBoltOp(e);
                                    this.MagicExplodeOp(e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.attackEntityAsMob((Entity)e);
                                }
                            }
                        }
                        else {
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5 && this.getTwiFire() != 0) {
                                this.MagicBolt(e);
                                this.MagicExplode(e);
                                this.MagicSigma(e);
                                this.faceEntity((Entity)e, 10.0f, 10.0f);
                                if (this.hugemob != 0) {
                                    this.MagicBoltOp(e);
                                    this.MagicExplodeOp(e);
                                    this.MagicSigma(e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.attackEntityAsMob((Entity)e);
                                    this.faceEntity((Entity)e, 10.0f, 10.0f);
                                }
                            }
                            if (this.getDistanceSqToEntity((Entity)e) < (175.0f + e.width / 2.0f) * (175.0f + e.width / 2.0f)) {
                                e = null;
                                e = this.findSomethingToAttack();
                            }
                            else {
                                this.getNavigator().tryMoveToEntityLiving((Entity)e, 1.2);
                            }
                        }
                    }
                }
            }
            else {
                this.setAttacking(0);
            }
        }
        if (this.activity == 1) {
            return;
        }
        if (do_new != 0) {
            Block bid = Blocks.stone;
            final Block byd = Blocks.water;
            while (bid != Blocks.air && restless != 0) {
                int gox = (int)this.posX;
                int goy = (int)this.posY;
                int goz = (int)this.posZ;
                if (has_owner == 1) {
                    gox = (int)ox;
                    goy = (int)oy;
                    goz = (int)oz;
                    if (this.owner_flying == 0) {
                        zdir = this.worldObj.rand.nextInt(4) + 6;
                        xdir = this.worldObj.rand.nextInt(4) + 6;
                    }
                    else {
                        zdir = this.worldObj.rand.nextInt(8);
                        xdir = this.worldObj.rand.nextInt(8);
                    }
                }
                else {
                    zdir = this.worldObj.rand.nextInt(5) + 6;
                    xdir = this.worldObj.rand.nextInt(5) + 6;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.set(gox + xdir, goy + (this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2), goz + zdir);
                bid = this.worldObj.getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
            }
        }
        --restless;
        double speed_factor = 1.75;
        final double var5 = this.currentFlightTarget.posX + 2.5 - this.posX;
        final double var6 = this.currentFlightTarget.posY + 2.0 - this.posY;
        final double var7 = this.currentFlightTarget.posZ + 2.5 - this.posZ;
        if (this.owner_flying != 0) {
            speed_factor = 1.75;
            if (this.isTamed() && this.getOwner() != null) {
                e = this.getOwner();
                if (this.getDistanceSqToEntity((Entity)e) > 49.0) {
                    speed_factor = 2.5;
                }
            }
        }
        this.motionX += (Math.signum(var5) * 0.5 - this.motionX) * 0.15 * speed_factor;
        this.motionY += (Math.signum(var6) * 0.75 - this.motionY) * 0.21 * speed_factor;
        this.motionZ += (Math.signum(var7) * 0.5 - this.motionZ) * 0.15 * speed_factor;
        final float var8 = (float)(Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var9 = MathHelper.wrapAngleTo180_float(var8 - this.rotationYaw);
        this.moveForward = (float)(0.75 * speed_factor);
        final float f = 0.25f;
        this.worldObj.spawnParticle("witchMagic", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
        this.rotationYaw += var9 / 3.0f;
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null && par1EntityLiving != this && par1EntityLiving.isEntityAlive() && this.getEntitySenses().canSee((Entity)par1EntityLiving) && !(par1EntityLiving instanceof AJInstance) && !(par1EntityLiving instanceof EntityAnimal) && !(par1EntityLiving instanceof DashInstance) && !(par1EntityLiving instanceof DashCloudInstance) && !(par1EntityLiving instanceof TwilightMagicInstance) && !(par1EntityLiving instanceof TwilicornInstance) && (par1EntityLiving instanceof EntityMob || !(par1EntityLiving instanceof EntityPlayer));
    }

    private EntityLivingBase findSomethingToAttack() {
     /*   if (ItemInitDangerZone.Snap != 0) {
            return null;
        }

      */
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(72.0, 36.0, 72.0));
        Collections.sort((List<Object>)var5, (Comparator<? super Object>)this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.isSuitableTarget(var8, false) && this.canSeeTarget(var8.posX, var8.posY, var8.posZ)) {
                return var8;
            }
        }
        return null;
    }

    private void MagicSigma(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 1.0;
        TwilightFireballInstance bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count > 0) {
            bf = new TwilightFireballInstance(this.worldObj, (EntityLivingBase)this, e.posX - cx, e.posY + e.height / 2.0f - (this.posY + yoff), e.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            bf.setTwi();
            this.worldObj.playSoundAtEntity((Entity)this, "random.explode", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity)bf);
            for (int i = 0; i < 50; ++i) {
                final float r1 = 16.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r2 = 14.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r3 = 12.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                bf = new TwilightFireballInstance(this.worldObj, (EntityLivingBase)this, e.posX - cx + r1, e.posY + e.height / 2.0f - (this.posY + yoff) + r2, e.posZ - cz + r3);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                this.worldObj.playSoundAtEntity((Entity)this, "random.explode", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity)bf);
            }
            --this.stream_count;
        }
    }

    private void Fireballs2(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 3.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0f, 1.0f / (this.getRNG().nextFloat() * 0.4f + 0.8f));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
        lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
        var3 = e.posX - lb.posX;
        var4 = e.posY + 0.25 - lb.posY;
        var5 = e.posZ - lb.posZ;
        var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
        lb.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 4.0f);
        final ThunderBolt thunderBolt = lb;
        thunderBolt.motionX *= 3.0;
        final ThunderBolt thunderBolt2 = lb;
        thunderBolt2.motionY *= 3.0;
        final ThunderBolt thunderBolt3 = lb;
        thunderBolt3.motionZ *= 3.0;
        this.worldObj.spawnEntityInWorld((Entity)lb);
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
        }
        return var8;
    }

    private EntityLivingBase MagicNova(final double X, final double Y, final double Z, final double dist, final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>)var5, (Comparator<? super Object>)this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase)var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null && var8 != this && var8.isEntityAlive() && !(var8 instanceof TwilicornInstance) && !(var8 instanceof DashInstance) && !(var8 instanceof AJInstance) && !(var8 instanceof EntityPlayer) && !(var8 instanceof WindigoInstance) && !(var8 instanceof TwilightMagicInstance)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion)null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float)damage / 1.0f);
                var8.attackEntityFrom(DamageSource.fall, (float)damage / 1.0f);
                this.worldObj.playSoundAtEntity((Entity)var8, "random.explode", 2.25f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 1.75;
                final double inair = 2.75;
                final float f3 = (float)Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private void MagicBolt(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 2750.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
        e.setFire(35);
        for (int var3 = 0; var3 < 20; ++var3) {}
        this.worldObj.playSoundAtEntity((Entity)e, "random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.MagicNova(this.posX, this.posY, this.posZ, 4.0, 2750.0, 1);
        }
        for (int mx = 60, var4 = 0; var4 < mx; ++var4) {
            final float f = 0.75f;
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
        }
    }

    private void MagicBoltOp(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 72750.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
        e.setHealth(e.getHealth() / 16.0f - 2750.0f);
        for (int var3 = 0; var3 < 20; ++var3) {}
        this.worldObj.playSoundAtEntity((Entity)e, "random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.MagicNova(this.posX, this.posY, this.posZ, 6.0, 72750.0, 1);
        }
        for (int var3 = 20; var3 < 20; ++var3) {
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
        }
    }

    private void MagicExplode(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 2750.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
        for (int var3 = 0; var3 < 20; ++var3) {}
        this.worldObj.playSoundAtEntity((Entity)e, "random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.MagicNova(this.posX, this.posY, this.posZ, 4.0, 2750.0, 1);
        }
        for (int mx = 60, var4 = 0; var4 < mx; ++var4) {
            final float f = 0.75f;
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
            e.worldObj.spawnParticle("fireworksSpark", this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)), this.posY + 0.4, this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)), (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionX * 3.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0, (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0 + this.motionZ * 3.0);
        }
    }

    private void MagicExplodeOp(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 72750.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
        e.setHealth(e.getHealth() / 16.0f - 2750.0f);
        for (int var3 = 0; var3 < 20; ++var3) {}
        this.worldObj.playSoundAtEntity((Entity)e, "random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.MagicNova(this.posX, this.posY, this.posZ, 6.0, 72750.0, 1);
        }
        for (int var3 = 20; var3 < 20; ++var3) {
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle("fireworksSpark", e.posX, e.posY, e.posZ, this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian(), this.worldObj.rand.nextGaussian());
        }
    }
}
