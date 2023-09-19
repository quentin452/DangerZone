
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Stinky extends EntityTameable {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    public int activity;
    private int owner_flying;
    private float moveSpeed;
    private int skin_color;
    private int syncit;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public Stinky(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.activity = 1;
        this.owner_flying = 0;
        this.moveSpeed = 0.3f;
        this.skin_color = -1;
        this.syncit = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(0.75f, 0.75f);
        this.moveSpeed = 0.3f;
        this.fireResistance = 1000;
        this.isImmuneToFire = true;
        this.getNavigator()
            .setAvoidsWater(true);
        this.setSitting(false);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks
            .addTask(2, new EntityAIAvoidEntity(this, EntityMob.class, 8.0f, 0.30000001192092896, 0.4000000059604645));
        this.tasks.addTask(3, new MyEntityAIFollowOwner((EntityTameable) this, 1.15f, 12.0f, 2.0f));
        this.tasks.addTask(4, new EntityAITempt(this, 1.25, Items.beef, false));
        this.tasks.addTask(5, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new MyEntityAIWander(this, 0.75f));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.tasks.addTask(9, new EntityAIMoveIndoors(this));
        this.TargetSorter = new GenericTargetSorter(this);
        this.experienceValue = 35;
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
        this.setSitting(false);
        this.setTamed(false);
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("SpyroActivity", this.dataWatcher.getWatchableObjectInt(21));
        par1NBTTagCompound.setInteger("SpyroFire", this.dataWatcher.getWatchableObjectInt(20));
        par1NBTTagCompound.setInteger("StinkySkin", this.dataWatcher.getWatchableObjectInt(22));
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.activity = par1NBTTagCompound.getInteger("SpyroActivity");
        this.dataWatcher.updateObject(21, (Object) this.activity);
        this.dataWatcher.updateObject(20, (Object) par1NBTTagCompound.getInteger("SpyroFire"));
        this.skin_color = par1NBTTagCompound.getInteger("StinkySkin");
        this.dataWatcher.updateObject(22, (Object) this.skin_color);
    }

    public int getActivity() {
        final int i = this.dataWatcher.getWatchableObjectInt(21);
        return this.activity = i;
    }

    public void setActivity(final int par1) {
        this.activity = par1;
        this.dataWatcher.updateObject(21, (Object) par1);
    }

    public int getSpyroFire() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setSpyroFire(final int par1) {
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    public int getSkin() {
        final int i = this.dataWatcher.getWatchableObjectInt(22);
        return this.skin_color = i;
    }

    public void setSkin(final int par1) {
        this.skin_color = par1;
        this.dataWatcher.updateObject(22, (Object) 0);
        this.dataWatcher.updateObject(22, (Object) par1);
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        return 100;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null && var2.getItem() == Items.beef && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.worldObj.rand.nextInt(2) == 1) {
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
            && var2.getItem() == Item.getItemFromBlock(Blocks.deadbush)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.setTamed(false);
                this.setHealth((float) this.mygetMaxHealth());
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

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.beef;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && !this.isTamed();
    }

    protected String getLivingSound() {
        return null;
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
        return 6;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        int var3 = 0;
        if (this.isTamed()) {
            var3 = this.worldObj.rand.nextInt(4);
            ++var3;
            for (int var4 = 0; var4 < var3; ++var4) {
                this.dropItem(Items.beef, 1);
            }
        }
    }

    protected float getSoundPitch() {
        return this.isChild() ? ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1f + 1.5f)
            : ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 0.1f + 1.0f);
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
        return this.worldObj.isDaytime() && this.findBuddies() <= 2;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public float getAttackStrength(final Entity par1Entity) {
        return 10.0f;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final float var2 = this.getAttackStrength(par1Entity);
        final boolean var3 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
        return var3;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
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

    private void dropItemFront(final Item index, final int par1) {
        final float f = 0.75f + Math.abs(this.worldObj.rand.nextFloat() * 0.75f);
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX - f * Math.sin(Math.toRadians(this.rotationYawHead)),
            this.posY + 0.9,
            this.posZ + f * Math.cos(Math.toRadians(this.rotationYawHead)),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    private void dropItemRear(final Item index, final int par1) {
        final float f = 0.55f + Math.abs(this.worldObj.rand.nextFloat() * 0.55f);
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + f * Math.sin(Math.toRadians(this.rotationYawHead)),
            this.posY + 0.25,
            this.posZ - f * Math.cos(Math.toRadians(this.rotationYawHead)),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    public void onUpdate() {
        super.onUpdate();
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(1750) == 1) {
            this.playSound("random.burp", 1.0f, 1.0f);
            this.dropItemFront(Items.coal, 1);
        }
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2000) == 2) {
            this.playSound(Tags.MODID + ":fart", 1.0f, 1.5f);
            if (this.skin_color == 0) {
                this.dropItemRear(Items.blaze_powder, 1);
            }
            if (this.skin_color == 1) {
                this.dropItemRear(Items.rotten_flesh, 1);
            }
            if (this.skin_color == 2) {
                this.dropItemRear(Items.melon_seeds, 1);
            }
            if (this.skin_color == 3) {
                this.dropItemRear(ItemInitDangerZone.UraniumNugget, 1);
            }
            if (this.skin_color == 4) {
                this.dropItemRear(Items.wheat, 1);
            }
            if (this.skin_color == 5) {
                this.dropItemRear(Items.brick, 1);
            }
            if (this.skin_color == 6) {
                this.dropItemRear(Item.getItemFromBlock(Blocks.torch), 1);
            }
            if (this.skin_color == 7) {
                this.dropItemRear(Items.emerald, 1);
            }
            if (this.skin_color == 8) {
                this.dropItemRear(Items.gold_ingot, 1);
            }
            if (this.skin_color == 9) {
                this.dropItemRear(Item.getItemFromBlock((Block) Blocks.leaves), 1);
            }
            if (this.skin_color == 10) {
                this.dropItemRear(ItemInitDangerZone.TitaniumNugget, 1);
            }
            if (this.skin_color == 11) {
                this.dropItemRear(ItemInitDangerZone.ItemAppleSeed, 1);
            }
            if (this.skin_color == 12) {
                this.dropItemRear(Items.diamond, 1);
            }
            if (this.skin_color == 13) {
                this.dropItemRear(Item.getItemFromBlock((Block) Blocks.sand), 1);
            }
            if (this.skin_color == 14) {
                this.dropItemRear(Item.getItemFromBlock(Blocks.cobblestone), 1);
            }
            if (this.skin_color == 15) {
                this.dropItemRear(Items.bone, 1);
            }
            if (this.skin_color == 16) {
                this.dropItemRear(Items.string, 1);
            }
            if (this.skin_color == 17) {
                this.dropItemRear(ItemInitDangerZone.MyCherrySeed, 1);
            }
            if (this.skin_color == 18) {
                this.dropItemRear(ItemInitDangerZone.MyPeachSeed, 1);
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
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2000) == 1) {
            final int i = this.worldObj.rand.nextInt(19);
            this.setSkin(i);
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.skin_color < 0) {
            this.skin_color = this.worldObj.rand.nextInt(19);
        }
        ++this.syncit;
        if (this.syncit > 20) {
            this.syncit = 0;
            if (this.worldObj.isRemote) {
                this.getActivity();
                this.getSkin();
            } else {
                int j = this.activity;
                this.setActivity(j);
                j = this.skin_color;
                this.setSkin(j);
            }
        }
        if (this.activity == 2) {
            this.motionY *= 0.6;
        }
    }

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if (bid == Blocks.coal_ore) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.worldObj.getBlock(x - dx, y + i, z + j);
                if (bid == Blocks.coal_ore) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x - dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
                if (bid == Blocks.coal_ore) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.worldObj.getBlock(x + i, y - dy, z + j);
                if (bid == Blocks.coal_ore) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y - dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dy; j <= dy; ++j) {
                Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
                if (bid == Blocks.coal_ore) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z + dz;
                        ++found;
                    }
                }
                bid = this.worldObj.getBlock(x + i, y + j, z - dz);
                if (bid == Blocks.coal_ore) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z - dz;
                        ++found;
                    }
                }
            }
        }
        return found != 0;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.activity != 2) {
            super.updateAITasks();
        }
        if (this.worldObj.rand.nextInt(100) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(1.0f);
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
        }
    }

    private void do_movement() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        int do_new = 0;
        double ox = 0.0;
        double oy = 0.0;
        double oz = 0.0;
        int has_owner = 0;
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
            oy = e.posY;
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
                    do_new = 0;
                    this.currentFlightTarget.set(
                        (int) (this.posX + (this.posX - e.posX)),
                        (int) (this.posY + 1.0),
                        (int) (this.posZ + (this.posZ - e.posZ)));
                } else {
                    this.setActivity(2);
                    this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 1.0), (int) e.posZ);
                    do_new = 0;
                    if (this.getDistanceSqToEntity(e) < (3.0f + e.width / 2.0f) * (3.0f + e.width / 2.0f)) {
                        this.attackEntityAsMob(e);
                    }
                }
            }
        }
        if (this.activity == 1) {
            if (this.worldObj.rand.nextInt(50) == 0 ) {
                this.closest = 99999;
                final int tx = 0;
                this.tz = tx;
                this.ty = tx;
                this.tx = tx;
                for (int i = 1; i < 9; ++i) {
                    int j = i;
                    if (j > 2) {
                        j = 2;
                    }
                    if (this.scan_it((int) this.posX, (int) this.posY + 1, (int) this.posZ, i, j, i)) {
                        break;
                    }
                    if (i >= 4) {
                        ++i;
                    }
                }
                if (this.closest < 99999) {
                    this.getNavigator()
                        .tryMoveToXYZ(this.tx, this.ty, this.tz, 1.25);
                    if (this.closest < 12) {
                        this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
                        this.heal(1.0f);
                        this.playSound("random.burp", 0.5f, this.worldObj.rand.nextFloat() * 0.2f + 1.5f);
                    }
                }
            }
            return;
        }
        if (this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            do_new = 1;
        }
        if (do_new != 0) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
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
                    .set(gox + xdir, goy + this.worldObj.rand.nextInt(6 + this.owner_flying * 2) - 2, goz + zdir);
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
            && (par1EntityLiving instanceof Mothra || par1EntityLiving instanceof EntityMob);
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

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Stinky.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }
}
