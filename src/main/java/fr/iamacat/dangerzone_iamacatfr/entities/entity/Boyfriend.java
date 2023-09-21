
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIJealousy;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAINearestAttackableTarget;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.items.ItemOreSpawnArmor;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class Boyfriend extends EntityTameable implements IRangedAttackMob {

    public int which_guy;
    public int which_wet_guy;
    public int wet_count;
    private int auto_heal;
    private int force_sync;
    private int fight_sound_ticker;
    private int taunt_sound_ticker;
    private int had_target;
    private int voice;
    private final float moveSpeed;
    private int voice_enable;
    public int passenger;
    private int is_prince;
    private static final ResourceLocation DryTexture0;
    private static final ResourceLocation DryTexture1;
    private static final ResourceLocation DryTexture2;
    private static final ResourceLocation DryTexture3;
    private static final ResourceLocation DryTexture4;
    private static final ResourceLocation DryTexture5;
    private static final ResourceLocation DryTexture6;
    private static final ResourceLocation DryTexture7;
    private static final ResourceLocation DryTexture8;
    private static final ResourceLocation DryTexture9;
    private static final ResourceLocation DryTexture10;
    private static final ResourceLocation DryTexture11;
    private static final ResourceLocation DryTexture12;
    private static final ResourceLocation DryTexture13;
    private static final ResourceLocation DryTexture14;
    private static final ResourceLocation DryTexture15;
    private static final ResourceLocation DryTexture16;
    private static final ResourceLocation DryTexture17;
    private static final ResourceLocation DryTexture18;
    private static final ResourceLocation DryTexture19;
    private static final ResourceLocation DryTexture20;
    private static final ResourceLocation DryTexture21;
    private static final ResourceLocation DryTexture22;
    private static final ResourceLocation DryTexture23;
    private static final ResourceLocation DryTexture24;
    private static final ResourceLocation DryTexture25;
    private static final ResourceLocation DryTexture26;
    private static final ResourceLocation DryTexture27;
    private static final ResourceLocation WetTexture0;
    private static final ResourceLocation WetTexture1;
    private static final ResourceLocation WetTexture2;
    private static final ResourceLocation WetTexture3;
    private static final ResourceLocation WetTexture4;
    private static final ResourceLocation WetTexture5;
    private static final ResourceLocation WetTexture6;
    private static final ResourceLocation WetTexture7;
    private static final ResourceLocation WetTexture8;
    private static final ResourceLocation WetTexture9;
    private static final ResourceLocation WetTexture10;
    private static final ResourceLocation WetTexture11;
    private static final ResourceLocation WetTexture12;
    private static final ResourceLocation WetTexture13;
    private static final ResourceLocation WetTexture14;
    private static final ResourceLocation WetTexture15;
    private static final ResourceLocation WetTexture16;
    private static final ResourceLocation WetTexture17;
    private static final ResourceLocation PrinceTexture1;
    private static final ResourceLocation PrinceTexture2;

    public Boyfriend(final World par1World) {
        super(par1World);
        this.which_guy = 0;
        this.which_wet_guy = 0;
        this.wet_count = 0;
        this.auto_heal = 200;
        this.force_sync = 50;
        this.fight_sound_ticker = 0;
        this.taunt_sound_ticker = 0;
        this.had_target = 0;
        this.voice = 0;
        this.moveSpeed = 0.3f;
        this.voice_enable = 1;
        this.passenger = 0;
        this.is_prince = 0;
        this.which_guy = this.rand.nextInt(28);
        this.voice = this.rand.nextInt(10);
        this.which_wet_guy = this.rand.nextInt(18);
        this.setSize(0.5f, 1.6f);
        this.isImmuneToFire = true;
        this.fireResistance = 100;
        this.getNavigator()
            .setAvoidsWater(false);
        this.setSitting(false);
        this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.4f, 12.0f, 1.5f));
        this.tasks.addTask(2, new EntityAITempt(this, 1.25, Items.cooked_beef, false));
        this.tasks.addTask(4, new EntityAIArrowAttack((IRangedAttackMob) this, 1.25, 20, 10.0f));
        this.tasks.addTask(5, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new MyEntityAIWander(this, 0.75f));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.tasks.addTask(10, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(11, new EntityAIMoveIndoors(this));
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(
                2,
                new MyEntityAINearestAttackableTarget(
                    this,
                    EntityCreeper.class,
                    20.0f,
                    0,
                    true,
                    true,
                    IMob.mobSelector));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(
                3,
                new MyEntityAINearestAttackableTarget(
                    this,
                    EntityLiving.class,
                    15.0f,
                    0,
                    true,
                    true,
                    IMob.mobSelector));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(4, new MyEntityAIJealousy(this, Boyfriend.class, 6.0f, 5, true));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(5, new MyEntityAIJealousy(this, Boyfriend.class, 3.0f, 15, true));
        }
        this.experienceValue = 0;
    }

    protected void entityInit() {
        super.entityInit();
        this.which_guy = this.rand.nextInt(28);
        this.dataWatcher.addObject(20, (Object) this.which_guy);
        this.wet_count = 0;
        this.which_wet_guy = this.rand.nextInt(18);
        this.dataWatcher.addObject(22, (Object) this.which_wet_guy);
        this.voice = this.rand.nextInt(10);
        this.dataWatcher.addObject(21, (Object) this.voice);
        this.dataWatcher.addObject(23, (Object) this.voice_enable);
        this.dataWatcher.addObject(24, (Object) this.is_prince);
        this.auto_heal = 200;
        this.force_sync = 50;
        this.fight_sound_ticker = 0;
        this.taunt_sound_ticker = 0;
        this.had_target = 0;
        this.setSitting(false);
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
            .setBaseValue(8.0);
    }

    public int getTotalArmorValue() {
        int i = 0;
        for (final ItemStack itemstack : this.getLastActiveItems()) {
            if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                final int l = ((ItemArmor) itemstack.getItem()).damageReduceAmount;
                i += l;
            }
        }
        if (i < 8) {
            i = 8;
        }
        if (i > 23) {
            i = 23;
        }
        return i;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        this.passenger = 0;
        if (this.isTamed() && !this.isSitting()) {
            final Entity e = this.getOwner();
            if (e != null && e instanceof EntityPlayer) {
                final EntityPlayer p = (EntityPlayer) e;
                final Entity r = e.ridingEntity;
                if (r != null && r instanceof Elevator) {
                    final float f = -0.45f;
                    this.setPosition(
                        r.posX - f * Math.sin(Math.toRadians(r.rotationYaw)),
                        r.posY,
                        r.posZ + f * Math.cos(Math.toRadians(r.rotationYaw)));
                    this.rotationYaw = r.rotationYaw;
                    this.rotationPitch = r.rotationPitch;
                    final float n = 0.0f;
                    this.limbSwingAmount = n;
                    this.limbSwing = n;
                    this.fallDistance = 0.0f;
                    this.passenger = 1;
                }
            }
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("GirlType", this.getTameSkin());
        par1NBTTagCompound.setInteger("WetGirlType", this.getWetTameSkin());
        par1NBTTagCompound.setInteger("GirlVoice", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("GirlVoiceEnable", this.dataWatcher.getWatchableObjectInt(23));
        par1NBTTagCompound.setInteger("IsPrince", this.dataWatcher.getWatchableObjectInt(24));
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setTameSkin(this.which_guy = par1NBTTagCompound.getInteger("GirlType"));
        this.setWetTameSkin(this.which_wet_guy = par1NBTTagCompound.getInteger("WetGirlType"));
        this.voice = par1NBTTagCompound.getInteger("GirlVoice");
        this.dataWatcher.updateObject(21, (Object) this.voice);
        this.voice_enable = par1NBTTagCompound.getInteger("GirlVoiceEnable");
        this.dataWatcher.updateObject(23, (Object) this.voice_enable);
        this.is_prince = par1NBTTagCompound.getInteger("IsPrince");
        this.dataWatcher.updateObject(24, (Object) this.is_prince);
    }

    protected void updateAITick() {
        super.updateAITick();
        final ItemStack stack = this.getCurrentEquippedItem();
        Entity victim = this.getAttackTarget();
        if (OreSpawnMain.PlayNicely != 0) {
            victim = null;
        }
        if (this.worldObj.rand.nextInt(100) == 1) {
            this.setRevengeTarget(null);
        }
        if (stack != null && !this.isSitting()) {
            if (victim != null) {
                if (victim instanceof EntityLivingBase && this.getHeldItem() != null) {
                    if (this.getDistanceToEntity(victim) < 4.0f
                        || (stack.getItem() == OreSpawnMain.MyBertha && this.getDistanceToEntity(victim) < 10.0f)) {
                        --this.attackTime;
                        if (this.attackTime <= 0) {
                            this.attackTime = 25;
                            this.swingItem();
                            this.attackTargetEntityWithCurrentItem(victim);
                            --this.fight_sound_ticker;
                            if (this.fight_sound_ticker <= 0) {
                                if (!this.worldObj.isRemote && this.voice_enable != 0) {
                                    this.worldObj
                                        .playSoundAtEntity(this, "orespawn:b_fight", 0.5f, this.getSoundPitch());
                                }
                                this.fight_sound_ticker = 3;
                            }
                            this.had_target = 1;
                        }
                    } else
                        if (this.getDistanceToEntity(victim) < 7.0f && stack.getItem() != OreSpawnMain.MyUltimateBow) {
                            --this.taunt_sound_ticker;
                            if (this.taunt_sound_ticker <= 0) {
                                if (!this.worldObj.isRemote && this.voice_enable != 0) {
                                    this.worldObj
                                        .playSoundAtEntity(this, "orespawn:b_taunt", 0.5f, this.getSoundPitch());
                                }
                                this.taunt_sound_ticker = 300;
                            }
                            this.getNavigator()
                                .tryMoveToEntityLiving(victim, 1.25);
                        }
                }
            } else {
                this.fight_sound_ticker = 0;
                this.attackTime = 0;
                if (this.had_target != 0) {
                    this.had_target = 0;
                    if (!this.worldObj.isRemote && this.voice_enable != 0) {
                        this.worldObj.playSoundAtEntity(this, "orespawn:b_woohoo", 0.4f, this.getSoundPitch());
                    }
                }
            }
        }
    }

    public void setPrince(final int par1) {
        this.is_prince = par1;
    }

    public ResourceLocation getTexture() {
        if (this.wet_count <= 0) {
            final int txture = this.getTameSkin();
            if (this.is_prince == 1) {
                return Boyfriend.PrinceTexture1;
            }
            if (this.is_prince == 2) {
                return Boyfriend.PrinceTexture2;
            }
            if (txture == 0) {
                return Boyfriend.DryTexture0;
            }
            if (txture == 1) {
                return Boyfriend.DryTexture1;
            }
            if (txture == 2) {
                return Boyfriend.DryTexture2;
            }
            if (txture == 3) {
                return Boyfriend.DryTexture3;
            }
            if (txture == 4) {
                return Boyfriend.DryTexture4;
            }
            if (txture == 5) {
                return Boyfriend.DryTexture5;
            }
            if (txture == 6) {
                return Boyfriend.DryTexture6;
            }
            if (txture == 7) {
                return Boyfriend.DryTexture7;
            }
            if (txture == 8) {
                return Boyfriend.DryTexture8;
            }
            if (txture == 9) {
                return Boyfriend.DryTexture9;
            }
            if (txture == 10) {
                return Boyfriend.DryTexture10;
            }
            if (txture == 11) {
                return Boyfriend.DryTexture11;
            }
            if (txture == 12) {
                return Boyfriend.DryTexture12;
            }
            if (txture == 13) {
                return Boyfriend.DryTexture13;
            }
            if (txture == 14) {
                return Boyfriend.DryTexture14;
            }
            if (txture == 15) {
                return Boyfriend.DryTexture15;
            }
            if (txture == 16) {
                return Boyfriend.DryTexture16;
            }
            if (txture == 17) {
                return Boyfriend.DryTexture17;
            }
            if (txture == 18) {
                return Boyfriend.DryTexture18;
            }
            if (txture == 19) {
                return Boyfriend.DryTexture19;
            }
            if (txture == 20) {
                return Boyfriend.DryTexture20;
            }
            if (txture == 21) {
                return Boyfriend.DryTexture21;
            }
            if (txture == 22) {
                return Boyfriend.DryTexture22;
            }
            if (txture == 23) {
                return Boyfriend.DryTexture23;
            }
            if (txture == 24) {
                return Boyfriend.DryTexture24;
            }
            if (txture == 25) {
                return Boyfriend.DryTexture25;
            }
            if (txture == 26) {
                return Boyfriend.DryTexture26;
            }
            if (txture == 27) {
                return Boyfriend.DryTexture27;
            }
        } else {
            final int temp = this.getWetTameSkin();
            if (temp == 0) {
                return Boyfriend.WetTexture0;
            }
            if (temp == 1) {
                return Boyfriend.WetTexture1;
            }
            if (temp == 2) {
                return Boyfriend.WetTexture2;
            }
            if (temp == 3) {
                return Boyfriend.WetTexture3;
            }
            if (temp == 4) {
                return Boyfriend.WetTexture4;
            }
            if (temp == 5) {
                return Boyfriend.WetTexture5;
            }
            if (temp == 6) {
                return Boyfriend.WetTexture6;
            }
            if (temp == 7) {
                return Boyfriend.WetTexture7;
            }
            if (temp == 8) {
                return Boyfriend.WetTexture8;
            }
            if (temp == 9) {
                return Boyfriend.WetTexture9;
            }
            if (temp == 10) {
                return Boyfriend.WetTexture10;
            }
            if (temp == 11) {
                return Boyfriend.WetTexture11;
            }
            if (temp == 12) {
                return Boyfriend.WetTexture12;
            }
            if (temp == 13) {
                return Boyfriend.WetTexture13;
            }
            if (temp == 14) {
                return Boyfriend.WetTexture14;
            }
            if (temp == 15) {
                return Boyfriend.WetTexture15;
            }
            if (temp == 16) {
                return Boyfriend.WetTexture16;
            }
            if (temp == 17) {
                return Boyfriend.WetTexture17;
            }
        }
        return null;
    }

    public int getTameSkin() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public int getVoice() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public void setTameSkin(final int par1) {
        this.dataWatcher.updateObject(20, (Object) par1);
        this.which_guy = par1;
    }

    public int getWetTameSkin() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setWetTameSkin(final int par1) {
        this.dataWatcher.updateObject(22, (Object) par1);
        this.which_wet_guy = par1;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected void fall(final float par1) {
        float i = (float) MathHelper.ceiling_float_int(par1 - 3.0f);
        if (i > 0.0f) {
            if (i > 3.0f) {
                this.playSound("damage.fallbig", 1.0f, 1.0f);
                i = 3.0f;
            } else {
                this.playSound("damage.fallsmall", 1.0f, 1.0f);
            }
            this.attackEntityFrom(DamageSource.fall, i);
        }
    }

    public int mygetMaxHealth() {
        return 80;
    }

    public void onLivingUpdate() {
        this.updateArmSwingProgress();
        super.onLivingUpdate();
        if (this.isInWater() || this.handleLavaMovement()) {
            this.wet_count = 500;
        } else if (this.wet_count > 0) {
            --this.wet_count;
        }
        --this.auto_heal;
        if (this.auto_heal <= 0) {
            if (this.mygetMaxHealth() > this.getBoyfriendHealth()) {
                this.heal(1.0f);
            }
            this.auto_heal = 150;
        }
        --this.force_sync;
        if (this.force_sync <= 0) {
            this.force_sync = 20;
            if (!this.worldObj.isRemote) {
                this.dataWatcher.updateObject(21, (Object) this.voice);
                this.dataWatcher.updateObject(23, (Object) this.voice_enable);
                this.dataWatcher.updateObject(24, (Object) this.is_prince);
                this.setSitting(this.isSitting());
            } else {
                this.voice = this.getVoice();
                this.voice_enable = this.dataWatcher.getWatchableObjectInt(23);
                this.is_prince = this.dataWatcher.getWatchableObjectInt(24);
            }
        }
    }

    public int getBoyfriendHealth() {
        return (int) this.getHealth();
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null && (var2.getItem() == Items.cooked_beef || var2.getItem() == OreSpawnMain.MyPeacock)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.worldObj.rand.nextInt(3) == 0) {
                        this.setTamed(true);
                        this.func_152115_b(
                            par1EntityPlayer.getUniqueID()
                                .toString());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState(this, (byte) 7);
                        this.heal(this.mygetMaxHealth() - this.getHealth());
                    } else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState(this, (byte) 6);
                    }
                }
            } else if (this.func_152114_e(par1EntityPlayer)) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
                if (this.mygetMaxHealth() > this.getHealth()) {
                    this.heal(this.mygetMaxHealth() - this.getHealth());
                }
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
            && var2.getItem() == Item.getItemFromBlock((Block) Blocks.deadbush)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.setTamed(false);
                this.func_152115_b("");
                this.playTameEffect(false);
                this.worldObj.setEntityState(this, (byte) 6);
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
            && var2.getItem() == OreSpawnMain.MyRuby
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.voice_enable = 0;
                this.dataWatcher.updateObject(23, (Object) this.voice_enable);
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 7);
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
            && var2.getItem() == OreSpawnMain.MyAmethyst
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.voice_enable = 1;
                this.dataWatcher.updateObject(23, (Object) this.voice_enable);
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 7);
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
            && (var2.getItem() == Items.leather || var2.getItem() == OreSpawnMain.MyPeacockFeather)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                if (this.wet_count > 0 || this.isInWater() || this.handleLavaMovement()) {
                    ++this.which_wet_guy;
                    if (this.which_wet_guy > 17) {
                        this.which_wet_guy = 0;
                    }
                    this.setWetTameSkin(this.which_wet_guy);
                    this.worldObj.setEntityState(this, (byte) 7);
                    if (this.isInWater() || this.handleLavaMovement()) {
                        this.wet_count = 500;
                    }
                } else {
                    ++this.which_guy;
                    if (this.which_guy > 27) {
                        this.which_guy = 0;
                    }
                    this.setTameSkin(this.which_guy);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack5 = var2;
                --itemStack5.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && this.func_152114_e(par1EntityPlayer)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (var2.getItem() instanceof ItemFood) {
                if (!this.worldObj.isRemote) {
                    final ItemFood var3 = (ItemFood) var2.getItem();
                    if (this.mygetMaxHealth() > this.getHealth()) {
                        this.heal((float) (var3.func_150905_g(var2) * 5));
                    }
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
                if (!par1EntityPlayer.capabilities.isCreativeMode) {
                    final ItemStack itemStack6 = var2;
                    --itemStack6.stackSize;
                    if (var2.stackSize <= 0) {
                        par1EntityPlayer.inventory
                            .setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    }
                }
            } else {
                if (!this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
                final ItemStack var4 = this.getCurrentEquippedItem();
                this.setCurrentItemOrArmor(0, var2);
                if (var2.getItem() == Items.diamond) {
                    this.setSitting(true);
                } else {
                    this.setSitting(false);
                }
                if (var4 != null) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var4);
                } else {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                    final Item itm = var2.getItem();
                    if (itm instanceof ItemOreSpawnArmor) {
                        if (itm == OreSpawnMain.EmeraldHelmet || itm == OreSpawnMain.AmethystHelmet
                            || itm == OreSpawnMain.UltimateHelmet) {
                            final ItemStack v4 = this.getEquipmentInSlot(4);
                            this.setCurrentItemOrArmor(4, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldBody || itm == OreSpawnMain.AmethystBody
                            || itm == OreSpawnMain.UltimateBody) {
                            final ItemStack v4 = this.getEquipmentInSlot(3);
                            this.setCurrentItemOrArmor(3, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldLegs || itm == OreSpawnMain.AmethystLegs
                            || itm == OreSpawnMain.UltimateLegs) {
                            final ItemStack v4 = this.getEquipmentInSlot(2);
                            this.setCurrentItemOrArmor(2, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.EmeraldBoots || itm == OreSpawnMain.AmethystBoots
                            || itm == OreSpawnMain.UltimateBoots) {
                            final ItemStack v4 = this.getEquipmentInSlot(1);
                            this.setCurrentItemOrArmor(1, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                    }
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            this.setSitting(false);
            this.setTamed(true);
            this.func_152115_b(
                par1EntityPlayer.getUniqueID()
                    .toString());
            this.playTameEffect(true);
            this.worldObj.setEntityState(this, (byte) 7);
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack7 = var2;
                --itemStack7.stackSize;
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
                final ItemStack itemStack8 = var2;
                --itemStack8.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 == null
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            ItemStack var4 = this.getEquipmentInSlot(0);
            int it = 0;
            if (var4 == null) {
                ++it;
                var4 = this.getEquipmentInSlot(it);
            }
            if (var4 == null) {
                ++it;
                var4 = this.getEquipmentInSlot(it);
            }
            if (var4 == null) {
                ++it;
                var4 = this.getEquipmentInSlot(it);
            }
            if (var4 == null) {
                ++it;
                var4 = this.getEquipmentInSlot(it);
            }
            if (var4 != null) {
                par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var4);
                this.setCurrentItemOrArmor(it, null);
                this.setSitting(false);
                if (!this.worldObj.isRemote) {
                    this.worldObj.setEntityState(this, (byte) 6);
                }
            } else if (!this.worldObj.isRemote) {
                this.setSitting(false);
                this.playTameEffect(true);
                this.worldObj.setEntityState(this, (byte) 7);
                String healthMessage = new String();
                healthMessage = String.format("I have %d health. Thanks for asking!", this.getBoyfriendHealth());
                par1EntityPlayer.addChatComponentMessage((IChatComponent) new ChatComponentText(healthMessage));
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null
            && (par1ItemStack.getItem() == Items.cooked_beef || par1ItemStack.getItem() == OreSpawnMain.MyPeacock);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        if (this.isSitting() || this.voice_enable == 0) {
            return null;
        }
        if (OreSpawnMain.bro_mode != 0 && this.worldObj.rand.nextInt(2) == 1) {
            return null;
        }
        if (this.worldObj.rand.nextInt(11) != 1) {
            return null;
        }
        final Entity victim = this.getAttackTarget();
        if (victim != null) {
            return null;
        }
        if (this.isInWater() || this.handleLavaMovement()) {
            return "orespawn:b_water";
        }
        if (this.worldObj.rand.nextInt(4) != 0) {
            if (this.posY < 60.0) {
                return null;
            }
            if (this.worldObj.isThundering()) {
                return "orespawn:b_thunder";
            }
            if (this.worldObj.isRaining()) {
                return "orespawn:b_rain";
            }
            if (!this.worldObj.isDaytime()
                && this.worldObj.canBlockSeeTheSky((int) this.posX, (int) this.posY, (int) this.posZ)) {
                if (this.worldObj.rand.nextInt(3) == 0) {
                    return "orespawn:b_dark";
                }
                return null;
            }
        }
        if (!this.isTamed()) {
            return null;
        }
        if (this.mygetMaxHealth() > this.getHealth()) {
            return "orespawn:b_hurt";
        }
        if (OreSpawnMain.bro_mode != 0) {
            return "orespawn:bb_happy";
        }
        return "orespawn:b_happy";
    }

    protected String getHurtSound() {
        if (this.voice_enable == 0) {
            return null;
        }
        if (OreSpawnMain.bro_mode != 0 && this.worldObj.rand.nextInt(2) == 1) {
            return null;
        }
        return "orespawn:b_ow";
    }

    protected String getDeathSound() {
        if (OreSpawnMain.bro_mode != 0) {
            return null;
        }
        return this.isTamed() ? "orespawn:b_death_boyfriend" : "orespawn:b_death_single";
    }

    protected float getSoundVolume() {
        return 0.3f;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block) Blocks.red_flower);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        int var3 = 0;
        if (this.isTamed()) {
            var3 = this.rand.nextInt(5);
            var3 += 2;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.dropItem(Item.getItemFromBlock((Block) Blocks.red_flower), 1);
            }
        }
        final Item v6 = OreSpawnMain.MyItemGameController;
        var3 = this.worldObj.rand.nextInt(26);
        var3 += 10;
        for (int var5 = 0; var5 < var3; ++var5) {
            this.dropItem(v6, 1);
        }
        if (this.isTamed()) {
            ItemStack var6 = this.getCurrentEquippedItem();
            if (var6 != null && var6.stackSize > 0) {
                this.dropItem(var6.getItem(), var6.stackSize);
            }
            var6 = this.getEquipmentInSlot(1);
            if (var6 != null && var6.stackSize > 0) {
                this.dropItem(var6.getItem(), var6.stackSize);
            }
            var6 = this.getEquipmentInSlot(2);
            if (var6 != null && var6.stackSize > 0) {
                this.dropItem(var6.getItem(), var6.stackSize);
            }
            var6 = this.getEquipmentInSlot(3);
            if (var6 != null && var6.stackSize > 0) {
                this.dropItem(var6.getItem(), var6.stackSize);
            }
            var6 = this.getEquipmentInSlot(4);
            if (var6 != null && var6.stackSize > 0) {
                this.dropItem(var6.getItem(), var6.stackSize);
            }
        }
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase par1EntityLiving) {
        ItemStack it = null;
        if (this.isSwingInProgress) {
            return;
        }
        it = this.getCurrentEquippedItem();
        if (it != null && it.getItem() == OreSpawnMain.MyUltimateBow) {
            final EntityArrow var8 = new UltimateArrow(this.worldObj, this, par1EntityLiving, 2.0f, 10.0f);
            if (this.worldObj.rand.nextInt(4) == 1) {
                var8.setIsCritical(true);
            }
            final int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, it);
            if (var9 > 0) {
                var8.setKnockbackStrength(var9);
            }
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, it) > 0) {
                var8.setFire(100);
            }
            it.damageItem(1, this);
            this.worldObj.playSoundAtEntity(
                this,
                "random.bow",
                1.0f,
                1.0f / (this.worldObj.rand.nextFloat() * 0.4f + 1.2f) + 0.5f);
            var8.canBePickedUp = 2;
            this.worldObj.spawnEntityInWorld(var8);
        } else {
            final Shoes var10 = new Shoes(this.worldObj, this, 6);
            final double var11 = par1EntityLiving.posX - this.posX;
            final double var12 = par1EntityLiving.posY + par1EntityLiving.getEyeHeight() - 1.1 - var10.posY;
            final double var13 = par1EntityLiving.posZ - this.posZ;
            final float var14 = MathHelper.sqrt_double(var11 * var11 + var13 * var13) * 0.2f;
            var10.setThrowableHeading(var11, var12 + var14, var13, 1.8f, 4.0f);
            this.worldObj.playSoundAtEntity(
                this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var10);
        }
        this.swingItem();
    }

    public ItemStack getCurrentEquippedItem() {
        return this.getEquipmentInSlot(0);
    }

    public void attackTargetEntityWithCurrentItem(final Entity par1Entity) {
        final ItemStack stack = this.getCurrentEquippedItem();
        if (stack != null) {
            float var2 = 0.0f;
            if (this.isPotionActive(Potion.damageBoost)) {
                var2 += 3 << this.getActivePotionEffect(Potion.damageBoost)
                    .getAmplifier();
            }
            if (this.isPotionActive(Potion.weakness)) {
                var2 -= 2 << this.getActivePotionEffect(Potion.weakness)
                    .getAmplifier();
            }
            int var3 = 0;
            float var4 = (float) this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
                .getAttributeValue();
            if (par1Entity instanceof EntityLiving) {
                var4 += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLivingBase) par1Entity);
                var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLivingBase) par1Entity);
            }
            if (this.isSprinting()) {
                ++var3;
            }
            if (var2 > 0.0f || var4 > 0.0f) {
                final boolean var5 = this.fallDistance > 0.0f && !this.onGround
                    && !this.isOnLadder()
                    && !this.isInWater()
                    && !this.handleLavaMovement()
                    && !this.isPotionActive(Potion.blindness)
                    && this.ridingEntity == null
                    && par1Entity instanceof EntityLiving;
                if (var5) {
                    var2 += this.worldObj.rand.nextInt((int) var2 / 2 + 2);
                }
                var2 += var4;
                final boolean var6 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
                if (var6 && var3 > 0) {
                    par1Entity.addVelocity(
                        (-MathHelper.sin(this.rotationYaw * 3.1415927f / 180.0f) * var3 * 0.5f),
                        0.1,
                        (MathHelper.cos(this.rotationYaw * 3.1415927f / 180.0f) * var3 * 0.5f));
                    this.motionX *= 0.6;
                    this.motionZ *= 0.6;
                    this.setSprinting(false);
                }
                final ItemStack var7 = this.getCurrentEquippedItem();
                if (par1Entity instanceof EntityLiving) {
                    final int var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var7);
                    if (var8 > 0 && var6) {
                        par1Entity.setFire(var8 * 4);
                    }
                }
            }
        }
    }

    protected float getSoundPitch() {
        return (this.voice - 5) * 0.02f + 1.0f;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public void attackEntityWithRangedAttack(final EntityLivingBase entityliving, final float f) {
        this.attackEntityWithRangedAttack(entityliving);;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float p2 = par2;
        if (p2 > 10.0f) {
            p2 = 10.0f;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, p2);
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Boyfriend")) {
                            return true;
                        }
                    }
                }
            }
        }
        return super.getCanSpawnHere();
    }

    static {
        DryTexture0 = new ResourceLocation(Tags.MODID+":boyfriend0.png");
        DryTexture1 = new ResourceLocation(Tags.MODID+":boyfriend1.png");
        DryTexture2 = new ResourceLocation(Tags.MODID+":boyfriend2.png");
        DryTexture3 = new ResourceLocation(Tags.MODID+":boyfriend3.png");
        DryTexture4 = new ResourceLocation(Tags.MODID+":boyfriend4.png");
        DryTexture5 = new ResourceLocation(Tags.MODID+":boyfriend5.png");
        DryTexture6 = new ResourceLocation(Tags.MODID+":boyfriend6.png");
        DryTexture7 = new ResourceLocation(Tags.MODID+":boyfriend7.png");
        DryTexture8 = new ResourceLocation(Tags.MODID+":boyfriend8.png");
        DryTexture9 = new ResourceLocation(Tags.MODID+":boyfriend9.png");
        DryTexture10 = new ResourceLocation(Tags.MODID+":boyfriend10.png");
        DryTexture11 = new ResourceLocation(Tags.MODID+":boyfriend11.png");
        DryTexture12 = new ResourceLocation(Tags.MODID+":boyfriend12.png");
        DryTexture13 = new ResourceLocation(Tags.MODID+":boyfriend13.png");
        DryTexture14 = new ResourceLocation(Tags.MODID+":boyfriend14.png");
        DryTexture15 = new ResourceLocation(Tags.MODID+":boyfriend15.png");
        DryTexture16 = new ResourceLocation(Tags.MODID+":boyfriend16.png");
        DryTexture17 = new ResourceLocation(Tags.MODID+":boyfriend17.png");
        DryTexture18 = new ResourceLocation(Tags.MODID+":boyfriend18.png");
        DryTexture19 = new ResourceLocation(Tags.MODID+":boyfriend19.png");
        DryTexture20 = new ResourceLocation(Tags.MODID+":boyfriend20.png");
        DryTexture21 = new ResourceLocation(Tags.MODID+":boyfriend21.png");
        DryTexture22 = new ResourceLocation(Tags.MODID+":boyfriend22.png");
        DryTexture23 = new ResourceLocation(Tags.MODID+":boyfriend23.png");
        DryTexture24 = new ResourceLocation(Tags.MODID+":boyfriend24.png");
        DryTexture25 = new ResourceLocation(Tags.MODID+":boyfriend25.png");
        DryTexture26 = new ResourceLocation(Tags.MODID+":boyfriend26.png");
        DryTexture27 = new ResourceLocation(Tags.MODID+":boyfriend27.png");
        WetTexture0 = new ResourceLocation(Tags.MODID+":swimshorts0.png");
        WetTexture1 = new ResourceLocation(Tags.MODID+":swimshorts1.png");
        WetTexture2 = new ResourceLocation(Tags.MODID+":swimshorts2.png");
        WetTexture3 = new ResourceLocation(Tags.MODID+":swimshorts3.png");
        WetTexture4 = new ResourceLocation(Tags.MODID+":swimshorts4.png");
        WetTexture5 = new ResourceLocation(Tags.MODID+":swimshorts5.png");
        WetTexture6 = new ResourceLocation(Tags.MODID+":swimshorts6.png");
        WetTexture7 = new ResourceLocation(Tags.MODID+":swimshorts7.png");
        WetTexture8 = new ResourceLocation(Tags.MODID+":swimshorts8.png");
        WetTexture9 = new ResourceLocation(Tags.MODID+":swimshorts9.png");
        WetTexture10 = new ResourceLocation(Tags.MODID+":swimshorts10.png");
        WetTexture11 = new ResourceLocation(Tags.MODID+":swimshorts11.png");
        WetTexture12 = new ResourceLocation(Tags.MODID+":swimshorts12.png");
        WetTexture13 = new ResourceLocation(Tags.MODID+":swimshorts13.png");
        WetTexture14 = new ResourceLocation(Tags.MODID+":swimshorts14.png");
        WetTexture15 = new ResourceLocation(Tags.MODID+":swimshorts15.png");
        WetTexture16 = new ResourceLocation(Tags.MODID+":swimshorts16.png");
        WetTexture17 = new ResourceLocation(Tags.MODID+":swimshorts17.png");
        PrinceTexture1 = new ResourceLocation(Tags.MODID+":FrogPrince.png");
        PrinceTexture2 = new ResourceLocation(Tags.MODID+":FrogPrince2.png");
    }
}
