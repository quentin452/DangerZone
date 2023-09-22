
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BandP extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private int whatset;
    private int whatami;
    public ItemStack[] MymainInventory;
    int got_stuff;

    public BandP(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.32f;
        this.whatset = 0;
        this.whatami = 0;
        this.MymainInventory = new ItemStack[100];
        this.got_stuff = 0;
        this.setSize(0.75f, 1.75f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 1000;
        this.fireResistance = 2;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAIMoveThroughVillage(this, 0.5, false));
        this.tasks.addTask(1, new MyEntityAIWanderALot(this, 16, 0.5));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(3, new EntityAILookIdle(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveIndoors(this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.BandP_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && this.got_stuff == 0;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (!this.worldObj.isRemote && this.whatset == 0) {
            this.whatset = 1;
            this.setWhat(this.whatami = this.worldObj.rand.nextInt(2));
        }
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.BandP_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.BandP_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        return "mob.villager.idle";
    }

    protected String getHurtSound() {
        return "mob.villager.hit";
    }

    protected String getDeathSound() {
        return "mob.villager.death";
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.emerald;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        if (index == null) {
            return null;
        }
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int var4 = 10 + this.worldObj.rand.nextInt(5), i = 0; i < var4; ++i) {
            this.dropItemRand(Items.emerald, 1);
        }
        if (this.getWhat() == 0) {
            for (int var4 = 2 + this.worldObj.rand.nextInt(3), i = 0; i < var4; ++i) {
                this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
                this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
            }
        }
        for (int i = 0; i < this.MymainInventory.length; ++i) {
            if (this.MymainInventory[i] != null && this.MymainInventory[i].stackSize != 0) {
                final ItemStack is = this
                    .dropItemRand(this.MymainInventory[i].getItem(), this.MymainInventory[i].stackSize);
                if (this.MymainInventory[i].stackSize == 1) {
                    is.setItemDamage(this.MymainInventory[i].getItemDamage());
                }
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(12) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity(e) < 9.0) {
                    this.attackEntityAsMob(e);
                    if (e instanceof EntityPlayer) {
                        final EntityPlayer p = (EntityPlayer) e;
                        int k = -1;
                        int kp = -1;
                        for (int i = 0; i < this.MymainInventory.length; ++i) {
                            if (this.MymainInventory[i] == null) {
                                k = i;
                                break;
                            }
                        }
                        if (k >= 0) {
                            for (int i = p.inventory.armorInventory.length - 1; i >= 0; --i) {
                                if (p.inventory.armorInventory[i] != null) {
                                    kp = i;
                                    break;
                                }
                            }
                            if (kp >= 0) {
                                this.MymainInventory[k] = p.inventory.armorInventory[kp];
                                p.inventory.armorInventory[kp] = null;
                                ++this.got_stuff;
                            }
                            if (kp < 0) {
                                for (int i = p.inventory.mainInventory.length - 1; i >= 0; --i) {
                                    if (p.inventory.mainInventory[i] != null) {
                                        kp = i;
                                        break;
                                    }
                                }
                                if (kp >= 0) {
                                    this.MymainInventory[k] = p.inventory.mainInventory[kp];
                                    p.inventory.mainInventory[kp] = null;
                                    ++this.got_stuff;
                                }
                            }
                        }
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.25);
                }
            }
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
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
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return par1EntityLiving instanceof EntityVillager || par1EntityLiving instanceof Girlfriend
            || par1EntityLiving instanceof Boyfriend;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(20.0, 6.0, 20.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public int getWhat() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setWhat(final int par1) {
        this.dataWatcher.updateObject(20, par1);
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
                        if (s != null && s.equals("Criminal")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (this.posY < 100.0) {
            return false;
        }
        BandP target = null;
        target = (BandP) this.worldObj
            .findNearestEntityWithinAABB(BandP.class, this.boundingBox.expand(32.0, 12.0, 32.0), this);
        if (target != null) {
            return false;
        }
        EntityVillager target2 = null;
        target2 = (EntityVillager) this.worldObj
            .findNearestEntityWithinAABB(EntityVillager.class, this.boundingBox.expand(36.0, 12.0, 36.0), this);
        return target2 != null;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.got_stuff != 0) {
            par1NBTTagCompound.setTag("Inventory", (NBTBase) this.writeToNBT(new NBTTagList()));
        }
        par1NBTTagCompound.setInteger("GotStuff", this.got_stuff);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.got_stuff = par1NBTTagCompound.getInteger("GotStuff");
        if (this.got_stuff != 0) {
            final NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Inventory", 10);
            this.readFromNBT(nbttaglist);
        }
    }

    public NBTTagList writeToNBT(final NBTTagList par1NBTTagList) {
        for (byte i = 0; i < this.MymainInventory.length; ++i) {
            if (this.MymainInventory[i] != null) {
                final NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", i);
                this.MymainInventory[i].writeToNBT(nbttagcompound);
                par1NBTTagList.appendTag(nbttagcompound);
            }
        }
        return par1NBTTagList;
    }

    public void readFromNBT(final NBTTagList par1NBTTagList) {
        this.MymainInventory = new ItemStack[100];
        for (int i = 0; i < par1NBTTagList.tagCount(); ++i) {
            final NBTTagCompound nbttagcompound = par1NBTTagList.getCompoundTagAt(i);
            final int j = nbttagcompound.getByte("Slot") & 0xFF;
            final ItemStack itemstack = ItemStack.loadItemStackFromNBT(nbttagcompound);
            if (itemstack != null && j >= 0 && j < this.MymainInventory.length) {
                this.MymainInventory[j] = itemstack;
            }
        }
    }
}
