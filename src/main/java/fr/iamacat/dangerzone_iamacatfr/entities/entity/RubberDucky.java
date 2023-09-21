
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RubberDucky extends EntityTameable {

    private GenericTargetSorter TargetSorter;
    public boolean should_despawn;
    private EntityLivingBase buddy;
    private float moveSpeed;
    private int killcount;
    private int died;
    private RenderInfo renderdata;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public RubberDucky(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.should_despawn = true;
        this.buddy = null;
        this.moveSpeed = 0.22f;
        this.killcount = 0;
        this.died = 0;
        this.renderdata = new RenderInfo();
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.22f;
        this.setSize(0.33f, 0.5f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 15;
        this.fireResistance = 3;
        this.isImmuneToFire = false;
        this.renderdata = new RenderInfo();
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(1, new MyEntityAIFollowOwner((EntityTameable) this, 2.0f, 10.0f, 2.0f));
        this.tasks.addTask(2, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25, Items.fish, false));
        this.tasks.addTask(4, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityLiving.class, 6.0f));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
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
            .setBaseValue(6.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(23, (Object) 0);
        this.dataWatcher.addObject(22, (Object) 0);
        this.setSitting(false);
        if (this.getGrowingAge() < 0) {
            this.setGrowingAge(-this.getGrowingAge());
        }
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

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (this.isInWater()) {
            this.motionY += 0.10000000149011612;
            if (this.motionY < -0.05000000074505806) {
                this.motionY = -0.05000000074505806;
            }
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        Entity w = null;
        w = par1DamageSource.getEntity();
        ret = super.attackEntityFrom(par1DamageSource, par2);
        this.setSitting(false);
        if (!this.worldObj.isRemote && w != null
            && w instanceof EntityPlayer
            && (this.isDead || this.getHealth() <= 0.0f)
            && this.died == 0) {
            this.died = 1;
            this.setKillCount(++this.killcount);
            if (this.killcount < 10) {
                for (int m = 0; m < 20; ++m) {
                    int i = this.worldObj.rand.nextInt(3);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        i = -i;
                    }
                    int k = this.worldObj.rand.nextInt(3);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        k = -k;
                    }
                    for (int j = 3; j > -3; --j) {
                        if (this.worldObj.getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                            == Blocks.air
                            && this.worldObj.getBlock((int) this.posX + i, (int) this.posY + j, (int) this.posZ + k)
                                != Blocks.air) {
                            final Entity e = spawnCreature(
                                this.worldObj,
                                "Rubber Ducky",
                                (int) this.posX + i + 1,
                                (int) this.posY + j + 1,
                                (int) this.posZ + k);
                            if (e != null) {
                                final RubberDucky d = (RubberDucky) e;
                                d.setKillCount(this.killcount);
                            }
                            return ret;
                        }
                    }
                }
            }
        }
        return ret;
    }

    public int mygetMaxHealth() {
        return 5;
    }

    public int getTotalArmorValue() {
        return 1;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected boolean isAIEnabled() {
        return true;
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

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(10) == 1) {
            return Tags.MODID + ":duck_hurt";
        }
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":duck_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":duck_hurt";
    }

    protected float getSoundVolume() {
        return 0.8f;
    }

    protected float getSoundPitch() {
        return 1.2f;
    }

    protected Item getDropItem() {
        if (this.worldObj.rand.nextInt(2) == 1) {
            return Items.feather;
        }
        if (this.worldObj.rand.nextInt(2) == 1) {
            return OreSpawnMain.RubberDuckyEgg;
        }
        return null;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (super.interact(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.getItem() == Items.fish && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(2) == 0) {
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
        if (this.isTamed() && this.func_152114_e(par1EntityPlayer)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0) {
            if (!this.isSitting() && this.getKillCount() < 5) {
                this.setSitting(true);
            } else {
                this.setSitting(false);
            }
            return true;
        }
        return true;
    }

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
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
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
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
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
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
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
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
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
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
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
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
        super.updateAITasks();
        if (!this.isInWater() && this.worldObj.rand.nextInt(50) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 14; ++i) {
                int j = i;
                if (j > 5) {
                    j = 5;
                }
                if (this.scan_it((int) this.posX, (int) this.posY - 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, this.ty - 1, this.tz, 1.33);
            }
        }
        if (this.killcount > 0 && this.worldObj.rand.nextInt(200) == 1) {
            this.setKillCount(--this.killcount);
        }
        if (this.getHealth() < this.mygetMaxHealth() && this.worldObj.rand.nextInt(300) == 1) {
            this.heal(1.0f);
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                if (this.getDistanceSqToEntity(e) < 12.0) {
                    this.setAttacking(1);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob(e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.2);
                }
            } else {
                if (this.buddy != null && !this.buddy.isDead && this.worldObj.rand.nextInt(15) == 1) {
                    this.getNavigator()
                        .tryMoveToEntityLiving(this.buddy, 1.0);
                }
                this.setAttacking(0);
            }
        }
        if (this.buddy != null && !this.buddy.isDead && this.worldObj.rand.nextInt(20) == 1) {
            this.getNavigator()
                .tryMoveToEntityLiving(this.buddy, 1.0);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        float i = 1.0f;
        if (this.getKillCount() >= 5) {
            i = 2.0f;
        }
        final boolean flag = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), i);
        return flag;
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
        if (par1EntityLiving instanceof AttackSquid) {
            return true;
        }
        if (par1EntityLiving instanceof EntitySquid) {
            return true;
        }
        if (par1EntityLiving instanceof RubberDucky && this.worldObj.rand.nextInt(10) == 1) {
            this.buddy = par1EntityLiving;
        }
        if (this.getKillCount() >= 5 && par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(8.0, 4.0, 8.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        this.setAttackTarget(null);
        this.buddy = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Killcount", this.killcount);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setKillCount(par1NBTTagCompound.getInteger("Killcount"));
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(23, par1);
    }

    public final int getKillCount() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public final void setKillCount(final int par1) {
        this.dataWatcher.updateObject(22, par1);
        this.killcount = par1;
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
                        if (s != null && s.equals("Rubber Ducky")) {
                            return true;
                        }
                    }
                }
            }
        }
        return this.posY >= 50.0 && this.worldObj.isDaytime();
    }

    protected boolean canDespawn() {
        if (this.isChild()) {
            this.func_110163_bv();
            return false;
        }
        return !this.isNoDespawnRequired() && !this.isTamed() && this.should_despawn;
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return (EntityAgeable) this.spawnBabyAnimal(entityageable);
    }

    public RubberDucky spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new RubberDucky(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.fish;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }
}
