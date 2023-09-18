
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;

public class MyPowerOrbs extends EntityLiving {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;

    public MyPowerOrbs(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.setSize(0.75f, 0.75f);
        this.experienceValue = 35;
        this.isImmuneToFire = true;
        this.fireResistance = 25;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
        this.noClip = true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    public void setPurpleType(final int par1) {
        if (this.worldObj == null) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
    }

    public int getPurpleType() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    protected boolean canDespawn() {
        return false;
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 750;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        final EntityLivingBase e = null;
        super.onUpdate();
        this.motionY *= 0.6;
        if (this.getPurpleType() == 0) {
            if (this.worldObj.isRemote && this.worldObj.rand.nextInt(4) == 1) {
                this.worldObj.spawnParticle(
                    "witchMagic",
                    this.posX,
                    this.posY + 1.25,
                    this.posZ,
                    (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
                    (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
                    (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
            }
        } else if (this.worldObj.isRemote && this.worldObj.rand.nextInt(6) == 1) {
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX,
                this.posY + 0.6499999761581421,
                this.posZ,
                (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f),
                (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f),
                (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f));
        }
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2500) == 1) {
            if (this.getPurpleType() == 10) {
                this.worldObj.newExplosion(
                    (Entity) null,
                    this.posX,
                    this.posY + 0.25,
                    this.posZ,
                    9.1f,
                    true,
                    this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing"));
            }
            this.setDead();
        }
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 1.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        EntityLivingBase e = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        Block bid = Blocks.air;
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            bid = Blocks.stone;
        }
        while (bid != Blocks.air && keep_trying != 0) {
            zdir = this.rand.nextInt(10) + 8;
            xdir = this.rand.nextInt(10) + 8;
            if (this.rand.nextInt(2) == 0) {
                zdir = -zdir;
            }
            if (this.rand.nextInt(2) == 0) {
                xdir = -xdir;
            }
            this.currentFlightTarget
                .set((int) this.posX + xdir, (int) this.posY + this.rand.nextInt(20) - 10, (int) this.posZ + zdir);
            bid = this.worldObj
                .getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
            if (bid == Blocks.air && !this.canSeeTarget(
                this.currentFlightTarget.posX,
                this.currentFlightTarget.posY,
                this.currentFlightTarget.posZ)) {
                bid = Blocks.stone;
            }
            --keep_trying;
            if (this.rand.nextInt(7) == 2 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                e = this.findSomethingToAttack();
                if (e == null) {
                    continue;
                }
                this.currentFlightTarget.set((int) e.posX, (int) (e.posY + e.height / 2.0f), (int) e.posZ);
                if (this.getDistanceSqToEntity((Entity) e) >= (4.0f + e.width / 2.0f) * (4.0f + e.width / 2.0f)) {
                    continue;
                }
                this.attackEntityAsMob((Entity) e);
                this.setDead();
            }
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.4 - this.motionX) * 0.2;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.2000000014901161;
        this.motionZ += (Math.signum(var3) * 0.4 - this.motionZ) * 0.2;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.75f;
        this.rotationYaw += var5 / 4.0f;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        final Entity e = par1DamageSource.getEntity();
        float dm = par2;
        if (e != null && e instanceof EntityArrow) {
            return false;
        }
        if (dm > 10.0f) {
            dm = 10.0f;
        }
        ret = super.attackEntityFrom(par1DamageSource, dm);
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int) e.posX, (int) (e.posY + e.height / 2.0f), (int) e.posZ);
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    public int getTotalArmorValue() {
        return 25;
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
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return !MobUtils.isPony((Entity) par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB((Class) EntityLivingBase.class, this.boundingBox.expand(32.0, 24.0, 32.0));
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

    public boolean attackEntityAsMob(final Entity par1Entity) {
        boolean var4 = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final EntityLivingBase e = (EntityLivingBase) par1Entity;
            e.setHealth(e.getMaxHealth() / 1.05f);
            var4 = e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), e.getMaxHealth() / 8.0f);
        }
        return var4;
    }

    protected int getDropItemId() {
        return 0;
    }
}
