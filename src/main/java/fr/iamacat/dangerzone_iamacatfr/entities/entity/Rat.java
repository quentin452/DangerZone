
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Rat extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private String myowner;

    public Rat(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.myowner = null;
        this.setSize(0.25f, 0.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 5;
        this.fireResistance = 10;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.350000023841858));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(3, new MyEntityAIWanderALot(this, 10, 1.0));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.TargetSorter = new GenericTargetSorter(this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Rat_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && this.myowner == null;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Rat_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Rat_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
        this.posY += 0.25;
    }

    protected String getLivingSound() {
        return Tags.MODID + ":ratlive";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":rathit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":ratdead";
    }

    protected float getSoundVolume() {
        return 0.45f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(5) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.setAttacking(1);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.25);
                if (this.getDistanceSqToEntity(e) < 4.0 && (this.rand.nextInt(8) == 0 || this.rand.nextInt(7) == 1)) {
                    this.attackEntityAsMob(e);
                }
            } else {
                this.setAttacking(0);
                if (this.myowner != null) {
                    final EntityPlayer p = this.worldObj.getPlayerEntityByName(this.myowner);
                    if (p != null) {
                        if (this.getDistanceSqToEntity(p) > 64.0) {
                            this.getNavigator()
                                .tryMoveToEntityLiving(p, 1.75);
                        }
                        if (this.getDistanceSqToEntity(p) > 256.0) {
                            this.setPosition(
                                p.posX + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(),
                                p.posY,
                                p.posZ + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                        }
                    }
                }
            }
        }
        if (this.worldObj.rand.nextInt(250) == 1) {
            this.heal(1.0f);
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof Irukandji) {
            return false;
        }
        if (par1EntityLiving instanceof Skate) {
            return false;
        }
        if (par1EntityLiving instanceof Whale) {
            return false;
        }
        if (par1EntityLiving instanceof Flounder) {
            return false;
        }
        if (par1EntityLiving instanceof Rat) {
            return false;
        }
        if (par1EntityLiving instanceof Ghost) {
            return false;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
            return false;
        }
        if (par1EntityLiving instanceof DungeonBeast) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
            if (this.myowner != null) {
                if (this.myowner.equals(
                    p.getUniqueID()
                        .toString())) {
                    return false;
                }
                if (OreSpawnMain.RatPlayerFriendly != 0) {
                    return false;
                }
            }
        }
        if (this.myowner != null && par1EntityLiving instanceof EntityTameable) {
            final EntityTameable e = (EntityTameable) par1EntityLiving;
            if (OreSpawnMain.RatPetFriendly != 0 && e.isTamed()) {
                return false;
            }
            if (e.func_152113_b() != null && this.myowner.equals(e.func_152113_b())) {
                return false;
            }
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(9.0, 2.0, 9.0));
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

    public void setOwner(final EntityLivingBase e) {
        EntityPlayer p = null;
        if (e != null && e instanceof EntityPlayer) {
            p = (EntityPlayer) e;
            final String s = p.getUniqueID()
                .toString();
            if (s != null) {
                this.myowner = s;
            }
        }
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        if (this.myowner == null) {
            this.myowner = "null";
        }
        par1NBTTagCompound.setString("MyOwner", this.myowner);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.myowner = par1NBTTagCompound.getString("MyOwner");
        if (this.myowner != null && this.myowner.equals("null")) {
            this.myowner = null;
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return ret;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        return ret;
    }

    public boolean getCanSpawnHere() {
        int sc = 0;
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Rat")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID5) {
            if (this.posY > 50.0) {
                return false;
            }
            for (int k = -1; k <= 1; ++k) {
                for (int j = -1; j <= 1; ++j) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + 1, (int) this.posZ + k);
                    if (bid == Blocks.air) {
                        ++sc;
                    }
                }
            }
            if (sc < 4) {
                return false;
            }
        }
        return this.findBuddies() <= 8;
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Rat.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }
}
