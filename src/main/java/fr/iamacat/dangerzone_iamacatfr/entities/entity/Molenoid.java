
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Molenoid extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;

    public Molenoid(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.35f;
        this.setSize(3.9f, 2.6f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 40;
        this.fireResistance = 100;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(2, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(18);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 200;
    }

    public int getTotalArmorValue() {
        return 12;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(3) == 0) {
            return Tags.MODID + ":molenoid_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":molenoid_hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":molenoid_death";
    }

    protected float getSoundVolume() {
        return 1.1f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(4) - rand.nextInt(4),
            this.posY + 1.0,
            this.posZ + rand.nextInt(4) - rand.nextInt(4),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(ItemInitDangerZone.MolenoidNose, 1);
        this.dropItemRand(Items.item_frame, 1);
        for (int var4 = 0; var4 < 10; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.beef, 1);
        }
    }

    public void initCreature() {}

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        return !par1DamageSource.getDamageType()
            .equals("inWall") && super.attackEntityFrom(par1DamageSource, par2);
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 0.8;
                double inair = 0.1;
                final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }

    protected void updateAITasks() {
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(4) == 0) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity(e) < (6.0f + e.width / 2.0f) * (6.0f + e.width / 2.0f)) {
                    this.setAttacking(1);
                    if (this.getDistanceSqToEntity(e) < 16.0
                        && (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1)) {
                        this.attackEntityAsMob(e);
                    /*} else if (DangerZone.PlayNicely == 0) {
                        for (int j = 1 + this.worldObj.rand.nextInt(4), k = 0; k < j; ++k) {
                            double dx = e.posX;
                            double dz = e.posZ;
                            dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                            dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                            for (int i = 4; i > -3; --i) {
                                if (this.worldObj.getBlock((int) dx, (int) e.posY + i + 1, (int) dz) == Blocks.air
                                    && this.worldObj.getBlock((int) dx, (int) e.posY + i, (int) dz) != Blocks.air) {
                                    this.worldObj
                                        .setBlock((int) dx, (int) e.posY + i + 1, (int) dz, DangerZone.MyMoleDirtBlock);
                                    break;
                                }
                            }
                        }*/
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.25);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.worldObj.rand.nextInt(2) == 0) {
            double spd = 0.0;
            spd = this.motionX * this.motionX + this.motionZ * this.motionZ;
            spd = Math.sqrt(spd);
            if (spd > this.moveSpeed) {
                spd = this.moveSpeed;
            }
            final int odds = (int) (100.0 * spd / this.moveSpeed);
            if (odds > 0 && this.worldObj.rand.nextInt(100) < odds) {
                double dx = this.posX + 6.0 * Math.sin(Math.toRadians(this.rotationYawHead));
                double dz = this.posZ - 6.0 * Math.cos(Math.toRadians(this.rotationYawHead));
                dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
                dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
                for (int l = 4; l > -4; --l) {
                    if (this.worldObj.getBlock((int) dx, (int) this.posY + l + 1, (int) dz) == Blocks.air
                        && this.worldObj.getBlock((int) dx, (int) this.posY + l, (int) dz) != Blocks.air) {
                        this.worldObj.setBlock((int) dx, (int) this.posY + l + 1, (int) dz, BlockInitDangerZone.MoleDirtBlock);
                        break;
                    }
                }
            }
        }
        double dx = this.posX - 3.0 * Math.sin(Math.toRadians(this.rotationYawHead));
        double dz = this.posZ + 3.0 * Math.cos(Math.toRadians(this.rotationYawHead));
        dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
        dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 3.0;
        int dir = 1;
        if (e != null) {
            if ((int) e.posY > (int) this.posY) {
                dir = 2;
            }
            if ((int) e.posY < (int) this.posY) {
                dir = 0;
            }
        }
        /*if (DangerZone.PlayNicely == 0) {
            for (int m = dir; m < dir + 3; ++m) {
                final Block bid = this.worldObj.getBlock((int) dx, (int) this.posY + m, (int) dz);
                if ((bid == Blocks.dirt || bid == Blocks.grass
                    || bid == Blocks.gravel
                    || bid == Blocks.sand
                    || bid == Blocks.leaves) && this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing")) {
                    this.worldObj.setBlock((int) dx, (int) this.posY + m, (int) dz, Blocks.air);
                }
                if (bid == DangerZone.MyMoleDirtBlock) {
                    this.worldObj.setBlock((int) dx, (int) this.posY + m, (int) dz, Blocks.air);
                }
            }
        }

         */
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
        if (!this.MyCanSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        if (par1EntityLiving instanceof Molenoid) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        final MyUtils oreSpawnUtils = DangerZone.OreSpawnUtils;
        return MyUtils.isAttackableNonMob(par1EntityLiving);
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
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
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
                        if (s != null && s.equals("Molenoid")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j < 1; ++j) {
                for (int i = 1; i < 4; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        Molenoid target = null;
        target = (Molenoid) this.worldObj
            .findNearestEntityWithinAABB(Molenoid.class, this.boundingBox.expand(16.0, 8.0, 16.0), this);
        return target == null;
    }

    public boolean MyCanSee(final EntityLivingBase e) {
        final double xzoff = 2.0;
        int nblks = 10;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        float startx = (float) cx;
        float starty = (float) (this.posY + 1.0);
        float startz = (float) cz;
        float dx = (float) ((e.posX - startx) / 10.0);
        float dy = (float) ((e.posY + e.height / 2.0f - starty) / 10.0);
        float dz = (float) ((e.posZ - startz) / 10.0);
        if (Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks *= (int) Math.abs(dx);
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if (Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks *= (int) Math.abs(dy);
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if (Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks *= (int) Math.abs(dz);
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            startx += dx;
            starty += dy;
            startz += dz;
            final Block bid = this.worldObj.getBlock((int) startx, (int) starty, (int) startz);
            if (bid != Blocks.air) {
                if (bid != BlockInitDangerZone.MoleDirtBlock) {
                    if (bid != Blocks.dirt) {
                        if (bid != Blocks.grass) {
                            if (bid != Blocks.tallgrass) {
                                if (bid != Blocks.sand) {
                                    if (bid != Blocks.gravel) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
