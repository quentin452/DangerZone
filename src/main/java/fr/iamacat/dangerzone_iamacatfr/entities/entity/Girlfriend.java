
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.*;
import fr.iamacat.dangerzone_iamacatfr.items.ItemOreSpawnArmor;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.item.EntityItem;
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

public class Girlfriend extends EntityTameable implements IRangedAttackMob {

    public int which_girl;
    public int which_wet_girl;
    public int wet_count;
    private int auto_heal;
    private int force_sync;
    private int fight_sound_ticker;
    private int taunt_sound_ticker;
    private int had_target;
    private int voice;
    private int is_princess;
    public MyEntityAIDance Dance;
    private float moveSpeed;
    private int voice_enable;
    public int passenger;
    public int feelingBetter;
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
    private static final ResourceLocation DryTexture28;
    private static final ResourceLocation DryTexture29;
    private static final ResourceLocation DryTexture30;
    private static final ResourceLocation DryTexture31;
    private static final ResourceLocation DryTexture32;
    private static final ResourceLocation DryTexture33;
    private static final ResourceLocation DryTexture34;
    private static final ResourceLocation DryTexture35;
    private static final ResourceLocation DryTexture36;
    private static final ResourceLocation DryTexture37;
    private static final ResourceLocation DryTexture38;
    private static final ResourceLocation DryTexture39;
    private static final ResourceLocation DryTexture40;
    private static final ResourceLocation ValentineTexture;
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
    private static final ResourceLocation PrincessTexture1;
    private static final ResourceLocation PrincessTexture2;

    public Girlfriend(final World par1World) {
        super(par1World);
        this.which_girl = 0;
        this.which_wet_girl = 0;
        this.wet_count = 0;
        this.auto_heal = 200;
        this.force_sync = 50;
        this.fight_sound_ticker = 0;
        this.taunt_sound_ticker = 0;
        this.had_target = 0;
        this.voice = 0;
        this.is_princess = 0;
        this.Dance = null;
        this.moveSpeed = 0.3f;
        this.voice_enable = 1;
        this.passenger = 0;
        this.feelingBetter = 0;
        this.which_girl = this.rand.nextInt(41);
        this.which_wet_girl = this.rand.nextInt(18);
        this.voice = this.rand.nextInt(10);
        this.setSize(0.5f, 1.6f);
        if (OreSpawnMain.valentines_day != 0) {
            this.setSize(2.5f, 8.0f);
        }
        this.isImmuneToFire = true;
        this.fireResistance = 100;
        this.getNavigator()
            .setAvoidsWater(false);
        this.setSitting(false);
        this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.4f, 12.0f, 1.5f));
        this.tasks.addTask(2, new EntityAITempt(this, 1.25, Item.getItemFromBlock((Block) Blocks.red_flower), false));
        this.Dance = new MyEntityAIDance(this);
        this.tasks.addTask(3, this.Dance);
        this.tasks.addTask(4, new EntityAIArrowAttack((IRangedAttackMob) this, 1.25, 20, 10.0f));
        this.tasks.addTask(5, new EntityAISwimming(this));
        this.tasks.addTask(6, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(8, new MyEntityAIWander(this, 0.75f));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.tasks.addTask(10, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(11, new EntityAIMoveIndoors(this));
        this.targetTasks.addTask(1, new MyValentineTarget(this, EntityPlayer.class, 16.0f, 0, true, true));
        this.targetTasks.addTask(2, new MyValentineTarget(this, Boyfriend.class, 16.0f, 0, true, true));
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
            this.targetTasks.addTask(4, new MyEntityAIJealousy(this, Girlfriend.class, 6.0f, 5, true));
        }
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(5, new MyEntityAIJealousy(this, Girlfriend.class, 3.0f, 15, true));
        }
        this.experienceValue = 0;
    }

    protected void entityInit() {
        super.entityInit();
        this.which_girl = this.rand.nextInt(41);
        this.dataWatcher.addObject(20, (Object) this.which_girl);
        this.wet_count = 0;
        this.which_wet_girl = this.rand.nextInt(18);
        this.dataWatcher.addObject(22, (Object) this.which_wet_girl);
        this.voice = this.rand.nextInt(10);
        this.dataWatcher.addObject(21, (Object) this.voice);
        this.dataWatcher.addObject(23, (Object) this.voice_enable);
        this.dataWatcher.addObject(24, (Object) this.is_princess);
        this.dataWatcher.addObject(25, (Object) this.feelingBetter);
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
        par1NBTTagCompound.setInteger("IsPrincess", this.dataWatcher.getWatchableObjectInt(24));
        par1NBTTagCompound.setInteger("feelingBetter", this.dataWatcher.getWatchableObjectInt(25));
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setTameSkin(this.which_girl = par1NBTTagCompound.getInteger("GirlType"));
        this.setWetTameSkin(this.which_wet_girl = par1NBTTagCompound.getInteger("WetGirlType"));
        this.voice = par1NBTTagCompound.getInteger("GirlVoice");
        this.dataWatcher.updateObject(21, (Object) this.voice);
        this.voice_enable = par1NBTTagCompound.getInteger("GirlVoiceEnable");
        this.dataWatcher.updateObject(23, (Object) this.voice_enable);
        this.is_princess = par1NBTTagCompound.getInteger("IsPrincess");
        this.dataWatcher.updateObject(24, (Object) this.is_princess);
        this.feelingBetter = par1NBTTagCompound.getInteger("feelingBetter");
        this.dataWatcher.updateObject(25, (Object) this.feelingBetter);
        if (OreSpawnMain.valentines_day != 0 && this.feelingBetter != 0) {
            this.setSize(0.5f, 1.6f);
        }
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
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setAttackTarget(null);
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
                                        .playSoundAtEntity(this, "orespawn:o_fight", 0.5f, this.getSoundPitch());
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
                                        .playSoundAtEntity(this, "orespawn:o_taunt", 0.5f, this.getSoundPitch());
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
                        this.worldObj.playSoundAtEntity(this, "orespawn:o_woohoo", 0.4f, this.getSoundPitch());
                    }
                }
            }
        }
    }

    public void setPrincess(final int par1) {
        this.is_princess = par1;
    }

    public ResourceLocation getTexture() {
        if (OreSpawnMain.valentines_day != 0 && this.feelingBetter == 0) {
            return Girlfriend.ValentineTexture;
        }
        if (this.wet_count <= 0) {
            final int txture = this.getTameSkin();
            if (this.is_princess == 1) {
                return Girlfriend.PrincessTexture1;
            }
            if (this.is_princess == 2) {
                return Girlfriend.PrincessTexture2;
            }
            if (txture == 0) {
                return Girlfriend.DryTexture0;
            }
            if (txture == 1) {
                return Girlfriend.DryTexture1;
            }
            if (txture == 2) {
                return Girlfriend.DryTexture2;
            }
            if (txture == 3) {
                return Girlfriend.DryTexture3;
            }
            if (txture == 4) {
                return Girlfriend.DryTexture4;
            }
            if (txture == 5) {
                return Girlfriend.DryTexture5;
            }
            if (txture == 6) {
                return Girlfriend.DryTexture6;
            }
            if (txture == 7) {
                return Girlfriend.DryTexture7;
            }
            if (txture == 8) {
                return Girlfriend.DryTexture8;
            }
            if (txture == 9) {
                return Girlfriend.DryTexture9;
            }
            if (txture == 10) {
                return Girlfriend.DryTexture10;
            }
            if (txture == 11) {
                return Girlfriend.DryTexture11;
            }
            if (txture == 12) {
                return Girlfriend.DryTexture12;
            }
            if (txture == 13) {
                return Girlfriend.DryTexture13;
            }
            if (txture == 14) {
                return Girlfriend.DryTexture14;
            }
            if (txture == 15) {
                return Girlfriend.DryTexture15;
            }
            if (txture == 16) {
                return Girlfriend.DryTexture16;
            }
            if (txture == 17) {
                return Girlfriend.DryTexture17;
            }
            if (txture == 18) {
                return Girlfriend.DryTexture18;
            }
            if (txture == 19) {
                return Girlfriend.DryTexture19;
            }
            if (txture == 20) {
                return Girlfriend.DryTexture20;
            }
            if (txture == 21) {
                return Girlfriend.DryTexture21;
            }
            if (txture == 22) {
                return Girlfriend.DryTexture22;
            }
            if (txture == 23) {
                return Girlfriend.DryTexture23;
            }
            if (txture == 24) {
                return Girlfriend.DryTexture24;
            }
            if (txture == 25) {
                return Girlfriend.DryTexture25;
            }
            if (txture == 26) {
                return Girlfriend.DryTexture26;
            }
            if (txture == 27) {
                return Girlfriend.DryTexture27;
            }
            if (txture == 28) {
                return Girlfriend.DryTexture28;
            }
            if (txture == 29) {
                return Girlfriend.DryTexture29;
            }
            if (txture == 30) {
                return Girlfriend.DryTexture30;
            }
            if (txture == 31) {
                return Girlfriend.DryTexture31;
            }
            if (txture == 32) {
                return Girlfriend.DryTexture32;
            }
            if (txture == 33) {
                return Girlfriend.DryTexture33;
            }
            if (txture == 34) {
                return Girlfriend.DryTexture34;
            }
            if (txture == 35) {
                return Girlfriend.DryTexture35;
            }
            if (txture == 36) {
                return Girlfriend.DryTexture36;
            }
            if (txture == 37) {
                return Girlfriend.DryTexture37;
            }
            if (txture == 38) {
                return Girlfriend.DryTexture38;
            }
            if (txture == 39) {
                return Girlfriend.DryTexture39;
            }
            if (txture == 40) {
                return Girlfriend.DryTexture40;
            }
        } else {
            final int temp = this.getWetTameSkin();
            if (temp == 0) {
                return Girlfriend.WetTexture0;
            }
            if (temp == 1) {
                return Girlfriend.WetTexture1;
            }
            if (temp == 2) {
                return Girlfriend.WetTexture2;
            }
            if (temp == 3) {
                return Girlfriend.WetTexture3;
            }
            if (temp == 4) {
                return Girlfriend.WetTexture4;
            }
            if (temp == 5) {
                return Girlfriend.WetTexture5;
            }
            if (temp == 6) {
                return Girlfriend.WetTexture6;
            }
            if (temp == 7) {
                return Girlfriend.WetTexture7;
            }
            if (temp == 8) {
                return Girlfriend.WetTexture8;
            }
            if (temp == 9) {
                return Girlfriend.WetTexture9;
            }
            if (temp == 10) {
                return Girlfriend.WetTexture10;
            }
            if (temp == 11) {
                return Girlfriend.WetTexture11;
            }
            if (temp == 12) {
                return Girlfriend.WetTexture12;
            }
            if (temp == 13) {
                return Girlfriend.WetTexture13;
            }
            if (temp == 14) {
                return Girlfriend.WetTexture14;
            }
            if (temp == 15) {
                return Girlfriend.WetTexture15;
            }
            if (temp == 16) {
                return Girlfriend.WetTexture16;
            }
            if (temp == 17) {
                return Girlfriend.WetTexture17;
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
        this.which_girl = par1;
    }

    public int getWetTameSkin() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setWetTameSkin(final int par1) {
        this.dataWatcher.updateObject(22, (Object) par1);
        this.which_wet_girl = par1;
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
        if (OreSpawnMain.valentines_day != 0 && this.feelingBetter == 0) {
            return 800;
        }
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
            if (this.mygetMaxHealth() > this.getGirlfriendHealth()) {
                this.heal(1.0f);
            }
            this.auto_heal = 100;
        }
        --this.force_sync;
        if (this.force_sync <= 0) {
            this.force_sync = 20;
            if (!this.worldObj.isRemote) {
                this.dataWatcher.updateObject(21, (Object) this.voice);
                this.dataWatcher.updateObject(23, (Object) this.voice_enable);
                this.dataWatcher.updateObject(24, (Object) this.is_princess);
                this.dataWatcher.updateObject(25, (Object) this.feelingBetter);
                this.setSitting(this.isSitting());
            } else {
                this.voice = this.getVoice();
                this.voice_enable = this.dataWatcher.getWatchableObjectInt(23);
                final int nowfeeling = this.dataWatcher.getWatchableObjectInt(25);
                if (nowfeeling != this.feelingBetter && nowfeeling != 0) {
                    this.feelingBetter = nowfeeling;
                    this.setSize(0.5f, 1.6f);
                }
            }
        }
    }

    public int getGirlfriendHealth() {
        return (int) this.getHealth();
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null
            && (var2.getItem() == Item.getItemFromBlock((Block) Blocks.red_flower)
                || var2.getItem() == Item.getItemFromBlock(OreSpawnMain.CrystalFlowerRedBlock))
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(3) == 0) {
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
            && (var2.getItem() == Item.getItemFromBlock(Blocks.yellow_flower)
                || var2.getItem() == Item.getItemFromBlock(OreSpawnMain.CrystalFlowerYellowBlock))
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                if (this.wet_count > 0 || this.isInWater() || this.handleLavaMovement()) {
                    ++this.which_wet_girl;
                    if (this.which_wet_girl > 17) {
                        this.which_wet_girl = 0;
                    }
                    this.setWetTameSkin(this.which_wet_girl);
                    this.worldObj.setEntityState(this, (byte) 7);
                    if (this.isInWater() || this.handleLavaMovement()) {
                        this.wet_count = 500;
                    }
                } else {
                    ++this.which_girl;
                    if (this.which_girl > 40) {
                        this.which_girl = 0;
                    }
                    this.setTameSkin(this.which_girl);
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
                        if (itm == OreSpawnMain.CrystalPinkHelmet || itm == OreSpawnMain.TigersEyeHelmet) {
                            final ItemStack v4 = this.getEquipmentInSlot(4);
                            this.setCurrentItemOrArmor(4, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.CrystalPinkBody || itm == OreSpawnMain.TigersEyeBody) {
                            final ItemStack v4 = this.getEquipmentInSlot(3);
                            this.setCurrentItemOrArmor(3, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.CrystalPinkLegs || itm == OreSpawnMain.TigersEyeLegs) {
                            final ItemStack v4 = this.getEquipmentInSlot(2);
                            this.setCurrentItemOrArmor(2, var2);
                            this.setCurrentItemOrArmor(0, v4);
                        }
                        if (itm == OreSpawnMain.CrystalPinkBoots || itm == OreSpawnMain.TigersEyeBoots) {
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
                healthMessage = String
                    .format("I have %d health. Thank you for asking! xoxo", this.getGirlfriendHealth());
                par1EntityPlayer.addChatComponentMessage((IChatComponent) new ChatComponentText(healthMessage));
            }
            return true;
        }
        return super.interact(par1EntityPlayer);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Item.getItemFromBlock((Block) Blocks.red_flower);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected String getLivingSound() {
        if (this.isSitting() || this.voice_enable == 0) {
            return null;
        }
        if (this.Dance.is_dancing != 0) {
            return null;
        }
        if (this.rand.nextInt(11) != 1) {
            return null;
        }
        final Entity victim = this.getAttackTarget();
        if (victim != null) {
            return null;
        }
        if (this.isInWater() || this.handleLavaMovement()) {
            return "orespawn:o_water";
        }
        if (this.rand.nextInt(4) != 0) {
            if (this.posY < 60.0) {
                return null;
            }
            if (this.worldObj.isThundering()) {
                return "orespawn:o_thunder";
            }
            if (this.worldObj.isRaining()) {
                return "orespawn:o_rain";
            }
            if (!this.worldObj.isDaytime()
                && this.worldObj.canBlockSeeTheSky((int) this.posX, (int) this.posY, (int) this.posZ)) {
                if (this.worldObj.rand.nextInt(3) == 0) {
                    return "orespawn:o_dark";
                }
                return null;
            }
        }
        if (!this.isTamed()) {
            return null;
        }
        if (this.mygetMaxHealth() > this.getHealth() || (OreSpawnMain.valentines_day != 0 && this.feelingBetter == 0)) {
            return "orespawn:o_hurt";
        }
        return "orespawn:o_happy";
    }

    protected String getHurtSound() {
        if (this.voice_enable == 0) {
            return null;
        }
        return "orespawn:o_ow";
    }

    protected String getDeathSound() {
        return this.isTamed() ? "orespawn:o_death_girlfriend" : "orespawn:o_death_single";
    }

    protected float getSoundVolume() {
        return 0.3f;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block) Blocks.red_flower);
    }

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
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
        final Item v6 = OreSpawnMain.MyItemShoes;
        final Item v7 = OreSpawnMain.MyItemShoes_1;
        final Item v8 = OreSpawnMain.MyItemShoes_2;
        final Item v9 = OreSpawnMain.MyItemShoes_3;
        var3 = this.rand.nextInt(16);
        var3 += 4;
        for (int var5 = 0; var5 < var3; ++var5) {
            this.dropItem(v6, 1);
        }
        var3 = this.rand.nextInt(16);
        var3 += 4;
        for (int var5 = 0; var5 < var3; ++var5) {
            this.dropItem(v7, 1);
        }
        var3 = this.rand.nextInt(16);
        var3 += 4;
        for (int var5 = 0; var5 < var3; ++var5) {
            this.dropItem(v8, 1);
        }
        var3 = this.rand.nextInt(16);
        var3 += 4;
        for (int var5 = 0; var5 < var3; ++var5) {
            this.dropItem(v9, 1);
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
            final Shoes var10 = new Shoes(this.worldObj, this, 2 + this.rand.nextInt(4));
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
                    var2 += this.rand.nextInt((int) var2 / 2 + 2);
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
        this.attackEntityWithRangedAttack(entityliving);
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float p2 = par2;
        if (p2 > 10.0f) {
            p2 = 10.0f;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            if (par1DamageSource.getDamageType()
                .equals("inWall") && OreSpawnMain.valentines_day != 0) {
                return ret;
            }
            if (OreSpawnMain.valentines_day != 0 && !this.worldObj.isRemote && this.feelingBetter == 0) {
                final Entity e = par1DamageSource.getEntity();
                if (e != null && e instanceof EntityPlayer) {
                    final EntityPlayer eb = (EntityPlayer) e;
                    final ItemStack ist = eb.getCurrentEquippedItem();
                    if (ist != null) {
                        final Item it = ist.getItem();
                        if (it == OreSpawnMain.MyRoseSword) {
                            if (this.worldObj.rand.nextInt(4) == 1) {
                                this.feelingBetter = 1;
                                this.setAttackTarget(null);
                                this.setSize(0.5f, 1.6f);
                                this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                                    .setBaseValue(this.mygetMaxHealth());
                                for (int morelove = this.worldObj.rand.nextInt(10), i = 0; i < 10 + morelove; ++i) {
                                    this.dropItemRand(OreSpawnMain.MyLove, 1);
                                }
                            } else {
                                this.dropItemRand(OreSpawnMain.MyLove, 1);
                            }
                        }
                    }
                }
            }
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
                        if (s != null && s.equals("Girlfriend")) {
                            return true;
                        }
                    }
                }
            }
        }
        return super.getCanSpawnHere();
    }

    static {
        DryTexture0 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend0.png");
        DryTexture1 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend1.png");
        DryTexture2 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend2.png");
        DryTexture3 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend3.png");
        DryTexture4 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend4.png");
        DryTexture5 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend5.png");
        DryTexture6 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend6.png");
        DryTexture7 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend7.png");
        DryTexture8 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend8.png");
        DryTexture9 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend9.png");
        DryTexture10 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend10.png");
        DryTexture11 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend11.png");
        DryTexture12 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend12.png");
        DryTexture13 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend13.png");
        DryTexture14 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend14.png");
        DryTexture15 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend15.png");
        DryTexture16 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend16.png");
        DryTexture17 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend17.png");
        DryTexture18 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend18.png");
        DryTexture19 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend19.png");
        DryTexture20 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend20.png");
        DryTexture21 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend21.png");
        DryTexture22 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend22.png");
        DryTexture23 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend23.png");
        DryTexture24 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend24.png");
        DryTexture25 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend25.png");
        DryTexture26 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend26.png");
        DryTexture27 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend27.png");
        DryTexture28 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend28.png");
        DryTexture29 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend29.png");
        DryTexture30 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend30.png");
        DryTexture31 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend31.png");
        DryTexture32 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend32.png");
        DryTexture33 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend33.png");
        DryTexture34 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend34.png");
        DryTexture35 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend35.png");
        DryTexture36 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend36.png");
        DryTexture37 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend37.png");
        DryTexture38 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend38.png");
        DryTexture39 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend39.png");
        DryTexture40 = new ResourceLocation(Tags.MODID+":textures/entity/girlfriend40.png");
        ValentineTexture = new ResourceLocation(Tags.MODID+":girlfriendv.png");
        WetTexture0 = new ResourceLocation(Tags.MODID+":textures/entity/bikini0.png");
        WetTexture1 = new ResourceLocation(Tags.MODID+":textures/entity/bikini1.png");
        WetTexture2 = new ResourceLocation(Tags.MODID+":textures/entity/bikini2.png");
        WetTexture3 = new ResourceLocation(Tags.MODID+":textures/entity/bikini3.png");
        WetTexture4 = new ResourceLocation(Tags.MODID+":textures/entity/bikini4.png");
        WetTexture5 = new ResourceLocation(Tags.MODID+":textures/entity/bikini5.png");
        WetTexture6 = new ResourceLocation(Tags.MODID+":textures/entity/bikini6.png");
        WetTexture7 = new ResourceLocation(Tags.MODID+":textures/entity/bikini7.png");
        WetTexture8 = new ResourceLocation(Tags.MODID+":textures/entity/bikini8.png");
        WetTexture9 = new ResourceLocation(Tags.MODID+":textures/entity/bikini9.png");
        WetTexture10 = new ResourceLocation(Tags.MODID+":textures/entity/bikini10.png");
        WetTexture11 = new ResourceLocation(Tags.MODID+":textures/entity/bikini11.png");
        WetTexture12 = new ResourceLocation(Tags.MODID+":textures/entity/bikini12.png");
        WetTexture13 = new ResourceLocation(Tags.MODID+":textures/entity/bikini13.png");
        WetTexture14 = new ResourceLocation(Tags.MODID+":textures/entity/bikini14.png");
        WetTexture15 = new ResourceLocation(Tags.MODID+":textures/entity/bikini15.png");
        WetTexture16 = new ResourceLocation(Tags.MODID+":textures/entity/bikini16.png");
        WetTexture17 = new ResourceLocation(Tags.MODID+":textures/entity/bikini17.png");
        PrincessTexture1 = new ResourceLocation(Tags.MODID+":textures/entity/FrogPrincess.png");
        PrincessTexture2 = new ResourceLocation(Tags.MODID+":textures/entity/FrogPrincess2.png");
    }
}
