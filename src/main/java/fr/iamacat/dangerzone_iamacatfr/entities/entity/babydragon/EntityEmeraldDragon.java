
package fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EntityEmeraldDragon extends DecoyCaveDragonTameable {

    private float field_70926_e;
    private float field_70924_f;
    private boolean isShaking;
    private boolean field_70928_h;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;

    public EntityEmeraldDragon(final World p_i1696_1_) {
        super(p_i1696_1_);
        this.setSize(0.6f, 0.8f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(1, (EntityAIBase) new EntityAISwimming((EntityLiving) this));
        this.tasks.addTask(2, (EntityAIBase) this.aiSit);
        this.tasks.addTask(3, (EntityAIBase) new EntityAILeapAtTarget((EntityLiving) this, 0.4f));
        this.tasks.addTask(4, (EntityAIBase) new EntityAIAttackOnCollide((EntityCreature) this, 1.0, true));
        this.tasks.addTask(5, (EntityAIBase) new EntityAIFollowOwner((EntityTameable) this, 1.0, 10.0f, 2.0f));
        this.tasks.addTask(6, (EntityAIBase) new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(7, (EntityAIBase) new EntityAIWander((EntityCreature) this, 1.0));
        this.tasks.addTask(
            8,
            (EntityAIBase) new EntityAITempt((EntityCreature) this, 1.2, ItemInitDangerZone.rainbowOpalChunk, false));
        this.tasks.addTask(
            9,
            (EntityAIBase) new EntityAITempt((EntityCreature) this, 1.2, ItemInitDangerZone.rainbowOpalChunk, false));
        this.tasks.addTask(
            10,
            (EntityAIBase) new EntityAIWatchClosest((EntityLiving) this, (Class) EntityPlayer.class, 8.0f));
        this.tasks.addTask(11, (EntityAIBase) new EntityAILookIdle((EntityLiving) this));
        this.isImmuneToFire = true;
        this.experienceValue = 10;
        this.targetTasks.addTask(1, (EntityAIBase) new EntityAIOwnerHurtByTarget((EntityTameable) this));
        this.targetTasks.addTask(2, (EntityAIBase) new EntityAIOwnerHurtTarget((EntityTameable) this));
        this.targetTasks.addTask(3, (EntityAIBase) new EntityAIHurtByTarget((EntityCreature) this, true));
        this.targetTasks.addTask(
            4,
            (EntityAIBase) new EntityAITargetNonTamed((EntityTameable) this, (Class) EntitySheep.class, 200, false));
        this.setTamed(false);
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.5);
        if (this.isTamed()) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(999.0);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(20.0);
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public void setAttackTarget(final EntityLivingBase p_70624_1_) {
        super.setAttackTarget(p_70624_1_);
        if (p_70624_1_ == null) {
            this.setAngry(false);
        } else if (!this.isTamed()) {
            this.setAngry(true);
        }
    }

    protected void updateAITick() {
        this.dataWatcher.updateObject(18, (Object) this.getHealth());
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, this.getHealth());
        this.dataWatcher.addObject(19, (byte) 0);
        this.dataWatcher.addObject(20, (byte) BlockColored.func_150032_b(1));
    }

    protected void func_145780_a(final int p_145780_1_, final int p_145780_2_, final int p_145780_3_,
        final Block p_145780_4_) {
        this.playSound("mob.wolf.step", 0.15f, 1.0f);
    }

    public void writeEntityToNBT(final NBTTagCompound p_70014_1_) {
        super.writeEntityToNBT(p_70014_1_);
        p_70014_1_.setBoolean("Angry", this.isAngry());
        p_70014_1_.setByte("CollarColor", (byte) this.getCollarColor());
    }

    public void readEntityFromNBT(final NBTTagCompound p_70037_1_) {
        super.readEntityFromNBT(p_70037_1_);
        this.setAngry(p_70037_1_.getBoolean("Angry"));
        if (p_70037_1_.hasKey("CollarColor", 99)) {
            this.setCollarColor(p_70037_1_.getByte("CollarColor"));
        }
    }

    protected void fall(final float p_70069_1_) {}

    protected String getLivingSound() {
        return this.isAngry() ? Tags.MODID + ":mob.tinydragon.tinydragon"
            : ((this.rand.nextInt(3) == 0) ? ((this.isTamed() && this.dataWatcher.getWatchableObjectFloat(18) < 10.0f)
                ? Tags.MODID + ":mob.tinydragon.tinydragon"
                : Tags.MODID + ":mob.tinydragon.tinydragon") : Tags.MODID + ":mob.tinydragon.tinydragon");
    }

    protected String getHurtSound() {
        return Tags.MODID + ":mob.tinydragon.enthralled";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":mob.tinydragon.enthralled";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }

    protected Item getDropItem() {
        return this.isBurning() ? ItemInitDangerZone.dragonMeatCooked : ItemInitDangerZone.dragonMeat;
    }

    protected void dropFewItems(final boolean p_70628_1_, final int p_70628_2_) {
        for (int j = this.rand.nextInt(3) + 1 + this.rand.nextInt(1 + p_70628_2_), k = 0; k < j; ++k) {
            if (this.isBurning()) {
                this.dropItem(ItemInitDangerZone.dragonMeatCooked, 1);
            } else {
                this.dropItem(ItemInitDangerZone.dragonMeat, 1);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(final float p_70070_1_) {
        return 15728880;
    }

    public float getBrightness(final float p_70013_1_) {
        return 1.0f;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
            this.worldObj.setEntityState((Entity) this, (byte) 8);
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.field_70924_f = this.field_70926_e;
        if (this.func_70922_bv()) {
            this.field_70926_e += (1.0f - this.field_70926_e) * 0.4f;
        } else {
            this.field_70926_e += (0.0f - this.field_70926_e) * 0.4f;
        }
        if (this.func_70922_bv()) {
            this.numTicksToChaseTarget = 10;
        }
        if (this.isWet()) {
            this.isShaking = true;
            this.field_70928_h = false;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        } else if ((this.isShaking || this.field_70928_h) && this.field_70928_h) {
            if (this.timeWolfIsShaking == 0.0f) {
                this.playSound(
                    "mob.wolf.shake",
                    this.getSoundVolume(),
                    (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2f + 1.0f);
            }
            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05f;
            if (this.prevTimeWolfIsShaking >= 2.0f) {
                this.isShaking = false;
                this.field_70928_h = false;
                this.prevTimeWolfIsShaking = 0.0f;
                this.timeWolfIsShaking = 0.0f;
            }
            if (this.timeWolfIsShaking > 0.4f) {
                final float f = (float) this.boundingBox.minY;
                for (int i = (int) (MathHelper.sin((this.timeWolfIsShaking - 0.4f) * 3.1415927f) * 7.0f), j = 0; j
                    < i; ++j) {
                    final float f2 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    final float f3 = (this.rand.nextFloat() * 2.0f - 1.0f) * this.width * 0.5f;
                    this.worldObj.spawnParticle(
                        "splash",
                        this.posX + f2,
                        (double) (f + 0.8f),
                        this.posZ + f3,
                        this.motionX,
                        this.motionY,
                        this.motionZ);
                }
            }
        }
    }

    protected boolean func_146066_aG() {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean getWolfShaking() {
        return this.isShaking;
    }

    @SideOnly(Side.CLIENT)
    public float getShadingWhileShaking(final float p_70915_1_) {
        return 0.75f
            + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70915_1_) / 2.0f
                * 0.25f;
    }

    @SideOnly(Side.CLIENT)
    public float getShakeAngle(final float p_70923_1_, final float p_70923_2_) {
        float f2 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * p_70923_1_
            + p_70923_2_) / 1.8f;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        return MathHelper.sin(f2 * 3.1415927f) * MathHelper.sin(f2 * 3.1415927f * 11.0f) * 0.15f * 3.1415927f;
    }

    public float getEyeHeight() {
        return this.height * 0.8f;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(final float p_70917_1_) {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * p_70917_1_) * 0.15f * 3.1415927f;
    }

    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    public boolean attackEntityFrom(final DamageSource p_70097_1_, float p_70097_2_) {
        if (this.isEntityInvulnerable()) {
            return false;
        }
        final Entity entity = p_70097_1_.getEntity();
        this.aiSit.setSitting(false);
        if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
            p_70097_2_ = (p_70097_2_ + 1.0f) / 2.0f;
        }
        return super.attackEntityFrom(p_70097_1_, p_70097_2_);
    }

    public void setTamed(final boolean p_70903_1_) {
        super.setTamed(p_70903_1_);
        if (p_70903_1_) {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(200.0);
        } else {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
                .setBaseValue(20.0);
        }
    }

    public boolean interact(final EntityPlayer p_70085_1_) {
        final ItemStack itemstack = p_70085_1_.inventory.getCurrentItem();
        if (this.isTamed()) {
            if (itemstack != null) {
                if (itemstack.getItem() instanceof ItemFood) {
                    final ItemFood itemfood = (ItemFood) itemstack.getItem();
                    if (itemfood.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 20.0f) {
                        if (!p_70085_1_.capabilities.isCreativeMode) {
                            final ItemStack itemStack = itemstack;
                            --itemStack.stackSize;
                        }
                        this.heal((float) itemfood.func_150905_g(itemstack));
                        if (itemstack.stackSize <= 0) {
                            p_70085_1_.inventory
                                .setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack) null);
                        }
                        return true;
                    }
                } else if (itemstack.getItem() == Items.dye) {
                    final int i = BlockColored.func_150032_b(itemstack.getItemDamage());
                    if (i != this.getCollarColor()) {
                        this.setCollarColor(i);
                        if (!p_70085_1_.capabilities.isCreativeMode) {
                            final ItemStack itemStack2 = itemstack;
                            if (--itemStack2.stackSize <= 0) {
                                p_70085_1_.inventory
                                    .setInventorySlotContents(p_70085_1_.inventory.currentItem, (ItemStack) null);
                            }
                        }
                        return true;
                    }
                }
            }
            if (this.func_152114_e((EntityLivingBase) p_70085_1_) && !this.worldObj.isRemote
                && !this.isBreedingItem(itemstack)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity(null);
                this.setTarget((Entity) null);
                this.setAttackTarget(null);
            }
        } else if (itemstack != null && itemstack.getItem() == ItemInitDangerZone.rainbowOpalChunk && !this.isAngry()) {
            if (!p_70085_1_.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = itemstack;
                --itemStack3.stackSize;
            }
            if (itemstack.stackSize <= 0) {
                p_70085_1_.inventory.setInventorySlotContents(p_70085_1_.inventory.currentItem, null);
            }
            if (!this.worldObj.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity) null);
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);
                    this.setHealth(999.0f);
                    this.func_152115_b(
                        p_70085_1_.getUniqueID()
                            .toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState((Entity) this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState((Entity) this, (byte) 6);
                }
            }
            return true;
        }
        return super.interact(p_70085_1_);
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(final byte p_70103_1_) {
        if (p_70103_1_ == 8) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0f;
            this.prevTimeWolfIsShaking = 0.0f;
        } else {
            super.handleHealthUpdate(p_70103_1_);
        }
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        return this.isAngry() ? 1.5393804f
            : (this.isTamed() ? ((0.55f - (20.0f - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02f) * 3.1415927f)
                : 0.62831855f);
    }

    public boolean isBreedingItem(final ItemStack p_70877_1_) {
        return p_70877_1_ != null && p_70877_1_.getItem() == Items.beef;
    }

    public int getMaxSpawnedInChunk() {
        return 2;
    }

    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectInt(16) & 0x2) != 0x0;
    }

    public void setAngry(final boolean p_70916_1_) {
        final int b0 = this.dataWatcher.getWatchableObjectInt(16);
        if (p_70916_1_) {
            this.dataWatcher.updateObject(16, (Object) (byte) (b0 | 0x2));
        } else {
            this.dataWatcher.updateObject(16, (Object) (byte) (b0 & 0xFFFFFFFD));
        }
    }

    public int getCollarColor() {
        return this.dataWatcher.getWatchableObjectInt(20) & 0xF;
    }

    public void setCollarColor(final int p_82185_1_) {
        this.dataWatcher.updateObject(20, (Object) (byte) (p_82185_1_ & 0xF));
    }

    public EntityEmeraldDragon createChild(final EntityAgeable p_90011_1_) {
        final EntityEmeraldDragon entityalpsdragon = new EntityEmeraldDragon(this.worldObj);
        final String s = this.func_152113_b();
        if (s != null && s.trim()
            .length() > 0) {
            entityalpsdragon.func_152115_b(s);
            entityalpsdragon.setTamed(true);
        }
        return entityalpsdragon;
    }

    public void func_70918_i(final boolean p_70918_1_) {
        if (p_70918_1_) {
            this.dataWatcher.updateObject(19, (Object) 1);
        } else {
            this.dataWatcher.updateObject(19, (Object) 0);
        }
    }

    public boolean canMateWith(final EntityAnimal p_70878_1_) {
        if (p_70878_1_ == this) {
            return false;
        }
        if (!this.isTamed()) {
            return false;
        }
        if (!(p_70878_1_ instanceof EntityEmeraldDragon)) {
            return false;
        }
        final EntityEmeraldDragon entityalpsdragon = (EntityEmeraldDragon) p_70878_1_;
        return entityalpsdragon.isTamed() && !entityalpsdragon.isSitting()
            && (this.isInLove() && entityalpsdragon.isInLove());
    }

    public String mobName() {
        return "EmeraldDragon";
    }

    public boolean getCanSpawnHere() {
        return this.posY <= 32.0 && super.getCanSpawnHere();
    }

    protected boolean isValidLightLevel() {
        return true;
    }

    public boolean func_70922_bv() {
        return this.dataWatcher.getWatchableObjectInt(19) == 1;
    }

    protected boolean canDespawn() {
        return false;
    }

    public boolean func_142018_a(final EntityLivingBase p_142018_1_, final EntityLivingBase p_142018_2_) {
        if (!(p_142018_1_ instanceof EntityCreeper) && !(p_142018_1_ instanceof EntityGhast)) {
            if (p_142018_1_ instanceof EntityEmeraldDragon) {
                final EntityEmeraldDragon entityalpsdragon = (EntityEmeraldDragon) p_142018_1_;
                if (entityalpsdragon.isTamed() && entityalpsdragon.getOwner() == p_142018_2_) {
                    return false;
                }
            }
            return (!(p_142018_1_ instanceof EntityPlayer) || !(p_142018_2_ instanceof EntityPlayer)
                || ((EntityPlayer) p_142018_2_).canAttackPlayer((EntityPlayer) p_142018_1_))
                && (!(p_142018_1_ instanceof EntityHorse) || !((EntityHorse) p_142018_1_).isTame());
        }
        return false;
    }
}
