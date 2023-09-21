
package fr.iamacat.dangerzone_iamacatfr.entities.entity;


import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class LeafMonster extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;

    public LeafMonster(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.25f;
        this.setSize(1.0f, 2.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 5;
        this.fireResistance = 0;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.350000023841858));
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
            .setBaseValue(OreSpawnMain.LeafMonster_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.LeafMonster_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.LeafMonster_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void fall(final float par1) {
        float i = (float) MathHelper.ceiling_float_int(par1 - 3.0f);
        if (i > 0.0f) {
            if (i > 2.0f) {
                this.playSound("damage.fallbig", 1.0f, 1.0f);
                i = 2.0f;
            } else {
                this.playSound("damage.fallsmall", 1.0f, 1.0f);
            }
            this.attackEntityFrom(DamageSource.fall, i);
        }
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (this.getAttacking() == 0) {
            int px = (int) this.posX;
            final int py = (int) this.posY;
            final int pz = (int) this.posZ;
            this.posX = px;
            this.posY = py;
            this.posZ = pz;
            if (this.posX > 0.0) {
                this.posX += 0.5;
            }
            if (this.posZ > 0.0) {
                this.posZ += 0.5;
            }
            if (this.posX < 0.0) {
                this.posX -= 0.5;
            }
            if (this.posZ < 0.0) {
                this.posZ -= 0.5;
            }
            this.rotationPitch = 0.0f;
            px = (int) this.rotationYawHead;
            px /= 90;
            final float n = (float) (px * 90);
            this.rotationYawHead = n;
            this.rotationYaw = n;
        }
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":leaves_hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":leaves_death";
    }

    protected float getSoundVolume() {
        return 0.65f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        final int i = this.worldObj.rand.nextInt(3);
        if (i == 0) {
            return Item.getItemFromBlock(Blocks.log);
        }
        if (i == 1) {
            return Item.getItemFromBlock((Block) Blocks.leaves);
        }
        return Items.rotten_flesh;
    }

    protected void updateAITasks() {
        super.updateAITasks();
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(100) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(4) == 1) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                this.setAttacking(1);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.25);
                if (this.getDistanceSqToEntity(e) < 5.0 && (this.rand.nextInt(8) == 0 || this.rand.nextInt(10) == 1)) {
                    this.attackEntityAsMob(e);
                }
            } else {
                this.setAttacking(0);
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
        if (par1EntityLiving instanceof EntityAnt) {
            return true;
        }
        if (par1EntityLiving instanceof EntityButterfly) {
            return true;
        }
        if (par1EntityLiving instanceof EntityLunaMoth) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (!p.capabilities.isCreativeMode) {
                return true;
            }
        }
        return false;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(4.0, 6.0, 4.0));
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
                        if (s != null && s.equals("Leaf Monster")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
            if (this.posY > 20.0) {
                return false;
            }
        } else if (this.posY < 50.0) {
            return false;
        }
        return this.findBuddies() <= 4;
    }

    private int findBuddies() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(LeafMonster.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }
}
