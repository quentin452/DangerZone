
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
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
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ThePrincess extends EntityTameable {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    public int activity;
    private int owner_flying;
    private float moveSpeed;
    private int syncit;
    private int head1ext;
    private int head2ext;
    private int head3ext;
    private int head1dir;
    private int head2dir;
    private int head3dir;
    private int ok_to_grow;
    private int kill_count;
    private int fed_count;
    private int day_count;
    private int is_day;
    private int attack_level;
    private int ticker;

    public ThePrincess(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.activity = 1;
        this.owner_flying = 0;
        this.moveSpeed = 0.3f;
        this.syncit = 0;
        this.head1ext = 0;
        this.head2ext = 0;
        this.head3ext = 0;
        this.head1dir = 1;
        this.head2dir = 1;
        this.head3dir = 1;
        this.ok_to_grow = 0;
        this.kill_count = 0;
        this.fed_count = 0;
        this.day_count = 0;
        this.is_day = 0;
        this.attack_level = 1;
        this.ticker = 0;
        this.setSize(0.75f, 1.25f);
        this.moveSpeed = 0.32f;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.getNavigator()
            .setAvoidsWater(true);
        this.setSitting(false);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new MyEntityAIFollowOwner((EntityTameable) this, 1.15f, 12.0f, 2.0f));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25, Items.beef, false));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityLiving.class, 6.0f));
        this.tasks.addTask(5, new MyEntityAIWander(this, 0.75f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.tasks.addTask(7, new EntityAIMoveIndoors(this));
        this.TargetSorter = new GenericTargetSorter(this);
        this.experienceValue = 50;
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
            .setBaseValue(10.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.activity = 1;
        this.dataWatcher.addObject(22, (Object) 0);
        this.dataWatcher.addObject(21, (Object) this.activity);
        this.dataWatcher.addObject(20, (Object) 1);
        this.dataWatcher.addObject(23, (Object) this.attack_level);
        this.setSitting(false);
        this.setTamed(false);
        this.noClip = false;
    }

    public int getPower() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public void setPower(final int par1) {
        this.dataWatcher.updateObject(23, (Object) par1);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20));
        par1NBTTagCompound.setInteger("SpyroGrow", this.ok_to_grow);
        par1NBTTagCompound.setInteger("SpyroKill", this.kill_count);
        par1NBTTagCompound.setInteger("SpyroFed", this.fed_count);
        par1NBTTagCompound.setInteger("SpyroDay", this.day_count);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
        this.dataWatcher.updateObject(21, (Object) this.activity);
        this.dataWatcher.updateObject(20, (Object) par1NBTTagCompound.getInteger("SpyroFire"));
        this.ok_to_grow = par1NBTTagCompound.getInteger("SpyroGrow");
        this.kill_count = par1NBTTagCompound.getInteger("SpyroKill");
        this.fed_count = par1NBTTagCompound.getInteger("SpyroFed");
        this.day_count = par1NBTTagCompound.getInteger("SpyroDay");
    }

    public int getActivity() {
        final int i = this.dataWatcher.getWatchableObjectInt(21);
        return this.activity = i;
    }

    public void setActivity(final int par1) {
        this.activity = par1;
        this.dataWatcher.updateObject(21, (Object) 0);
        this.dataWatcher.updateObject(21, (Object) par1);
    }

    public int getSpyroFire() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setSpyroFire(final int par1) {
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setAttacking(final int par1) {
        this.dataWatcher.updateObject(22, (Object) par1);
    }

    public int getHead1Ext() {
        return this.head1ext;
    }

    public int getHead2Ext() {
        return this.head2ext;
    }

    public int getHead3Ext() {
        return this.head3ext;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        return 400;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.worldObj.isRemote) {
                this.setTamed(true);
                this.func_152115_b(
                    par1EntityPlayer.getUniqueID()
                        .toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 7);
                this.heal(this.mygetMaxHealth() - this.getHealth());
                this.ok_to_grow = 1;
                this.kill_count = 1000;
                this.fed_count = 1000;
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
        if (this.isTamed() && var2 != null
            && this.func_152114_e(par1EntityPlayer)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
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
                final ItemStack itemStack2 = var2;
                --itemStack2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Item.getItemFromBlock(Blocks.ice)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 6);
                this.setSpyroFire(0);
                String healthMessage = new String();
                healthMessage = String.format("Princess fireballs extinguished.", new Object[0]);
                par1EntityPlayer.addChatComponentMessage(new ChatComponentText(healthMessage));
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = var2;
                --itemStack3.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Items.flint_and_steel
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 6);
                this.setSpyroFire(1);
                String healthMessage = new String();
                healthMessage = String.format("Princess fireballs lit!", new Object[0]);
                par1EntityPlayer.addChatComponentMessage((IChatComponent) new ChatComponentText(healthMessage));
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack4 = var2;
                --itemStack4.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Items.name_tag
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            this.setCustomNameTag(var2.getDisplayName());
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack5 = var2;
                --itemStack5.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.isSitting()) {
                this.setSitting(true);
                this.setActivity(1);
            } else {
                this.setSitting(false);
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public void set_ok_to_grow() {
        this.ok_to_grow = 1;
        this.kill_count = 0;
        this.fed_count = 0;
        this.day_count = 0;
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.beef;
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        if (this.isSitting()) {
            return null;
        }
        if (this.getAttacking() == 0) {
            return null;
        }
        return Tags.MODID + ":roar";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":duck_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":cryo_death";
    }

    protected float getSoundVolume() {
        return 0.6f;
    }

    public int getTotalArmorValue() {
        return 14;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        int var3 = 0;
        var3 = this.worldObj.rand.nextInt(4);
        ++var3;
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.beef, 1);
        }
    }

    protected float getSoundPitch() {
        return (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.2f + 1.5f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

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
        return 9.0f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final float var2 = this.getAttackStrength(par1Entity);
        final boolean var3 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
        if (par1Entity instanceof EntityLivingBase) {
            final EntityLivingBase el = (EntityLivingBase) par1Entity;
            if (el.getHealth() <= 0.0f) {
                ++this.kill_count;
            }
        }
        return var3;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.setSitting(false);
            this.setActivity(2);
        }
        return ret;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.getActivity() == 2) {
            this.noClip = true;
        } else {
            this.noClip = false;
        }
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
        if (this.worldObj.isRemote && this.getPower() > 400) {
            final float f = 0.25f;
            if (this.worldObj.rand.nextInt(6) == 1) {
                for (int i = 0; i < 2; ++i) {
                    this.worldObj.spawnParticle(
                        "fireworksSpark",
                        this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + 0.4,
                        this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)),
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0
                            + this.motionX * 3.0,
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0,
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 7.0
                            + this.motionZ * 3.0);
                }
            }
        }
    }

    public void onLivingUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onLivingUpdate();
        if (this.isInWater()) {
            this.motionY += 0.07;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        ++this.syncit;
        if (this.syncit > 20) {
            this.syncit = 0;
            if (this.worldObj.isRemote) {
                this.getActivity();
            } else {
                final int j = this.activity;
                this.setActivity(j);
            }
        }
        if (this.activity == 2) {
            this.motionY *= 0.6;
        }
    }

    protected void updateAITasks() {
        final double xzoff = 1.5;
        final double yoff = 1.0;
        EntityLiving newent = null;
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.activity != 2) {
            super.updateAITasks();
        }
        ++this.ticker;
        if (this.ticker % 10 == 0) {
            this.setPower(this.attack_level);
        }
        if (this.worldObj.rand.nextInt(200) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(1.0f);
        }
        if (!this.isTamed()) {
            final EntityPlayer p = this.worldObj.getClosestPlayerToEntity(this, 10.0);
            if (p != null) {
                this.setTamed(true);
                this.func_152115_b(
                    p.getUniqueID()
                        .toString());
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 7);
                this.heal(this.mygetMaxHealth() - this.getHealth());
            }
        }
        ++this.attack_level;
        if (this.getAttacking() != 0) {
            this.attack_level += 4;
        }
        if (this.getSpyroFire() == 0) {
            this.attack_level = 0;
        }
        if (this.attack_level > 500) {
            if (this.getAttacking() != 0) {
                for (int j = 3, i = 0; i < j; ++i) {
                    final Entity ppwr = spawnCreature(
                        this.worldObj,
                        "PurplePower",
                        this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + yoff,
                        this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                    if (ppwr != null) {
                        final PurplePower p2 = (PurplePower) ppwr;
                        p2.motionX = this.motionX * 3.0;
                        p2.motionZ = this.motionZ * 3.0;
                        p2.setPurpleType(1 + this.worldObj.rand.nextInt(3));
                    }
                }
            } else {
                if (this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing")) {
                    for (int m = 0; m < 5; ++m) {
                        final int i = this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5);
                        final int k = this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5);
                        int j = -5;
                        while (j < 5) {
                            final Block bid = this.worldObj
                                .getBlock((int) this.posX + i, (int) this.posY + j, (int) this.posZ + k);
                            if (bid == Blocks.grass) {
                                if (this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    != Blocks.air) {
                                    break;
                                }
                                final int which = this.worldObj.rand.nextInt(8);
                                if (which == 0) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        (Block) Blocks.red_flower);
                                }
                                if (which == 1) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        (Block) Blocks.yellow_flower);
                                }
                                if (which == 2) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        BlockInitDangerZone.MyFlowerBlueBlock);
                                }
                                if (which == 3) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        BlockInitDangerZone.MyFlowerPinkBlock);
                                }
                                if (which == 4) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        BlockInitDangerZone.CrystalFlowerRedBlock);
                                }
                                if (which == 5) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        BlockInitDangerZone.CrystalFlowerGreenBlock);
                                }
                                if (which == 6) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        BlockInitDangerZone.CrystalFlowerBlueBlock);
                                }
                                if (which == 7) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        BlockInitDangerZone.CrystalFlowerYellowBlock);
                                    break;
                                }
                                break;
                            } else {
                                if (bid == Blocks.dirt && this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    == Blocks.air) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j,
                                        (int) this.posZ + k,
                                        Blocks.grass);
                                    break;
                                }
                                if (bid == Blocks.stone && this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    == Blocks.air) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        Blocks.dirt);
                                    break;
                                }
                                if (bid == Blocks.sand && this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    == Blocks.air) {
                                    if (this.worldObj.rand.nextInt(2) == 0) {
                                        this.worldObj.setBlock(
                                            (int) this.posX + i,
                                            (int) this.posY + j + 1,
                                            (int) this.posZ + k,
                                            Blocks.cactus);
                                        break;
                                    }
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j,
                                        (int) this.posZ + k,
                                        Blocks.dirt);
                                    break;
                                } else {
                                    if (bid == Blocks.lava && this.worldObj
                                        .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                        == Blocks.air) {
                                        this.worldObj.setBlock(
                                            (int) this.posX + i,
                                            (int) this.posY + j,
                                            (int) this.posZ + k,
                                            Blocks.water);
                                        break;
                                    }
                                    if (bid == Blocks.flowing_lava && this.worldObj
                                        .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                        == Blocks.air) {
                                        this.worldObj.setBlock(
                                            (int) this.posX + i,
                                            (int) this.posY + j,
                                            (int) this.posZ + k,
                                            (Block) Blocks.flowing_water);
                                        break;
                                    }
                                    if (bid == Blocks.air && j > 0) {
                                        break;
                                    }
                                    ++j;
                                }
                            }
                        }
                    }
                }
                for (int m = 0; m < 2; ++m) {
                    final int i = this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4);
                    final int k = this.worldObj.rand.nextInt(4) - this.worldObj.rand.nextInt(4);
                    final int j = 1 + this.worldObj.rand.nextInt(4);
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + i, (int) this.posY + j, (int) this.posZ + k);
                    if (bid == Blocks.air) {
                        if (this.worldObj.rand.nextInt(2) == 0) {
                            newent = (EntityLiving) spawnCreature(
                                this.worldObj,
                                "Butterfly",
                                this.posX + i,
                                this.posY + j,
                                this.posZ + k);
                        } else {
                            newent = (EntityLiving) spawnCreature(
                                this.worldObj,
                                "Bird",
                                this.posX + i,
                                this.posY + j,
                                this.posZ + k);
                        }
                    }
                }
            }
            this.attack_level = 1;
        }
        if (!this.isSitting()) {
            if (this.activity == 0) {
                this.setActivity(1);
            }
            if (this.worldObj.rand.nextInt(100) == 1) {
                if (this.worldObj.rand.nextInt(20) == 1) {
                    this.setActivity(2);
                } else {
                    this.setActivity(1);
                }
            }
            this.owner_flying = 0;
            if (this.isTamed() && this.getOwner() != null) {
                final EntityPlayer e = (EntityPlayer) this.getOwner();
                if (e.capabilities.isFlying) {
                    this.owner_flying = 1;
                    this.setActivity(2);
                }
            }
            if (this.activity == 1 && this.isTamed() && this.getOwner() != null) {
                final EntityLivingBase e2 = this.getOwner();
                if (this.getDistanceSqToEntity(e2) > 256.0) {
                    this.setActivity(2);
                }
            }
            this.do_movement();
        } else if (this.isTamed() && this.getOwner() != null) {
            final EntityLivingBase e2 = this.getOwner();
            if (this.getDistanceSqToEntity(e2) > 256.0) {
                this.setSitting(false);
                this.setActivity(2);
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

    private void do_movement() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 10;
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
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.activity == 2 && this.worldObj.rand.nextInt(300) == 0) {
            do_new = 1;
        }
        if (this.isTamed() && this.getOwner() != null) {
            e = this.getOwner();
            has_owner = 1;
            ox = e.posX;
            oy = e.posY + 1.0;
            oz = e.posZ;
            if (this.getDistanceSqToEntity(e) > 100.0) {
                do_new = 1;
            }
            if (this.owner_flying != 0 && this.getDistanceSqToEntity(e) > 36.0) {
                do_new = 1;
            }
        }
        if (this.worldObj.rand.nextInt(7) == 1 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                if (this.isTamed() && this.getHealth() / this.mygetMaxHealth() < 0.25f) {
                    this.setActivity(2);
                    this.setAttacking(0);
                    do_new = 0;
                    this.currentFlightTarget.set(
                        (int) (this.posX + (this.posX - e.posX)),
                        (int) (this.posY + 1.0),
                        (int) (this.posZ + (this.posZ - e.posZ)));
                } else {
                    this.setActivity(2);
                    this.setAttacking(1);
                    this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                    do_new = 0;
                    if (this.getDistanceSqToEntity(e) < (3.0f + e.width / 2.0f) * (3.0f + e.width / 2.0f)) {
                        this.attackEntityAsMob(e);
                    } else if (this.getDistanceSqToEntity(e) > 25.0 && this.getDistanceSqToEntity(e) < 144.0
                        && !this.isInWater()
                        && this.getSpyroFire() != 0
                        && (this.worldObj.rand.nextInt(3) == 0 || this.worldObj.rand.nextInt(4) == 1)) {
                            final int which = this.worldObj.rand.nextInt(3);
                            if (which == 0) {
                                rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                                rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                                rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                                if (rdd > pi) {
                                    rdd -= pi * 2.0;
                                }
                                rdd = Math.abs(rdd);
                                if (rdd < 0.5) {
                                    this.firecanon(e);
                                }
                            } else if (which == 1) {
                                rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                                rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                                rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                                if (rdd > pi) {
                                    rdd -= pi * 2.0;
                                }
                                rdd = Math.abs(rdd);
                                if (rdd < 0.5) {
                                    this.firecanonl(e);
                                }
                            } else {
                                rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                                rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                                rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                                if (rdd > pi) {
                                    rdd -= pi * 2.0;
                                }
                                rdd = Math.abs(rdd);
                                if (rdd < 0.5) {
                                    this.firecanoni(e);
                                }
                            }
                        }
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.activity == 1) {
            return;
        }
        if (this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            do_new = 1;
        }
        if (do_new != 0) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; bid = this.worldObj.getBlock(
                this.currentFlightTarget.posX,
                this.currentFlightTarget.posY,
                this.currentFlightTarget.posZ), --keep_trying) {
                int gox = (int) this.posX;
                int goy = (int) this.posY;
                int goz = (int) this.posZ;
                if (has_owner == 1) {
                    gox = (int) ox;
                    goy = (int) oy;
                    goz = (int) oz;
                    if (this.owner_flying == 0) {
                        zdir = this.worldObj.rand.nextInt(4) + 6;
                        xdir = this.worldObj.rand.nextInt(4) + 6;
                    } else {
                        zdir = this.worldObj.rand.nextInt(8);
                        xdir = this.worldObj.rand.nextInt(8);
                    }
                } else {
                    zdir = this.worldObj.rand.nextInt(5) + 6;
                    xdir = this.worldObj.rand.nextInt(5) + 6;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget
                    .set(gox + xdir, goy + (this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2), goz + zdir);
            }
        }
        double speed_factor = 1.0;
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        if (this.owner_flying != 0) {
            speed_factor = 1.75;
            if (this.isTamed() && this.getOwner() != null) {
                e = this.getOwner();
                if (this.getDistanceSqToEntity(e) > 49.0) {
                    speed_factor = 3.5;
                }
            }
        }
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.15 * speed_factor;
        this.motionY += (Math.signum(var2) * 0.7 - this.motionY) * 0.21 * speed_factor;
        this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.15 * speed_factor;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = (float) (0.75 * speed_factor);
        this.rotationYaw += var5 / 3.0f;
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee(par1EntityLiving)
            && !MyUtils.isRoyalty(par1EntityLiving)
            && (par1EntityLiving instanceof EntityMob || par1EntityLiving instanceof Mothra
                || par1EntityLiving instanceof DragonflyInstance
                || par1EntityLiving instanceof EntityMosquito);
    }

    private EntityLivingBase findSomethingToAttack() {

        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(12.0, 6.0, 12.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false) && this.canSeeTarget(var8.posX, var8.posY, var8.posZ)) {
                return var8;
            }
        }
        return null;
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 3.0;
        BetterFireballInstance bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
        bf = new BetterFireballInstance(
            this.worldObj,
            this,
            e.posX - cx + r1,
            e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
            e.posZ - cz + r3);
        bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
        bf.setPosition(cx, this.posY + yoff, cz);
        bf.setBig();
        if (this.worldObj.rand.nextInt(2) == 1) {
            bf.setSmall();
        }
        this.worldObj.playSoundAtEntity(
            this,
            "random.bow",
            1.0f,
            1.0f / (this.getRNG()
                .nextFloat() * 0.4f + 0.8f));
        this.worldObj.spawnEntityInWorld(bf);
    }

    private void firecanonl(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 3.0;
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
        this.worldObj.spawnEntityInWorld(lb);
    }

    private void firecanoni(final EntityLivingBase e) {
        final double yoff = 1.0;
        final double xzoff = 3.0;
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
        var3 = e.posX - lb.posX;
        var4 = e.posY + 0.25 - lb.posY;
        var5 = e.posZ - lb.posZ;
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
}
