
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
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;

public class PurplePower extends EntityLiving {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private int purple_type;

    public PurplePower(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.purple_type = 0;
        this.setSize(0.75f, 0.75f);
        this.experienceValue = 35;
        this.isImmuneToFire = true;
        this.fireResistance = 25;
        this.TargetSorter = new GenericTargetSorter(this);
        this.noClip = true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.25);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(500.0);
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
        this.purple_type = par1;
        this.dataWatcher.updateObject(20, (Object) par1);
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
        return 1000;
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
                    "fireworksSpark",
                    this.posX,
                    this.posY + 1.25,
                    this.posZ,
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
                    ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
            }
        } else if (this.worldObj.isRemote && this.worldObj.rand.nextInt(6) == 1) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY + 0.6499999761581421,
                this.posZ,
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f),
                ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 5.0f));
        }
        if (this.worldObj.isRemote) {
            this.purple_type = this.getPurpleType();
        } else {
            this.setPurpleType(this.purple_type);
        }
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(2500) == 1) {
            if (this.getPurpleType() == 10) {
                this.worldObj.newExplosion(
                    null,
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
            Vec3.createVectorHelper(this.posX, this.posY + 0.55, this.posZ),
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
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
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
        } else if (this.rand.nextInt(7) == 2 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            e = this.findSomethingToAttack();
            if (e != null) {
                this.currentFlightTarget.set((int) e.posX, (int) (e.posY + e.height / 2.0f), (int) e.posZ);
                if (this.getDistanceSqToEntity(e) < (4.0f + e.width / 2.0f) * (4.0f + e.width / 2.0f)) {
                    this.attackEntityAsMob(e);
                    this.setDead();
                }
            }
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            this.setDead();
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.4 - this.motionX) * 0.2;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.20000000149011612;
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode && (this.getPurpleType() <= 0 || this.getPurpleType() == 10);
        }
        if (this.getPurpleType() != 0 && this.getPurpleType() != 10 && par1EntityLiving instanceof EntityTameable) {
            final EntityTameable e = (EntityTameable) par1EntityLiving;
            if (e.isTamed()) {
                return false;
            }
        }
        return !MyUtils.isRoyalty(par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(32.0, 24.0, 32.0));
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
            if (this.getPurpleType() == 0 || this.getPurpleType() == 10) {
                e.setHealth(e.getHealth() / 4.0f - 1.0f);
                var4 = e.attackEntityFrom(DamageSource.causeMobDamage(this), e.getMaxHealth() / 8.0f);
                if (this.getPurpleType() == 10) {
                    this.worldObj.newExplosion(
                        null,
                        e.posX,
                        e.posY - 0.25,
                        e.posZ,
                        9.1f,
                        true,
                        this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing"));
                }
            } else {
                e.setHealth(e.getHealth() * 15.0f / 16.0f);
                var4 = e.attackEntityFrom(DamageSource.causeMobDamage(this), 5.0f);
                if (this.getPurpleType() == 1) {
                    e.setFire(10);
                }
                if (this.getPurpleType() == 2) {
                    e.addPotionEffect(new PotionEffect(Potion.poison.id, 50, 0));
                }
                if (this.getPurpleType() == 3) {
                    e.addPotionEffect(new PotionEffect(Potion.weakness.id, 50, 0));
                }
            }
        }
        return var4;
    }

    protected Item getDropItem() {
        return null;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("PurpleType", this.purple_type);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.purple_type = par1NBTTagCompound.getInteger("PurpleType");
    }
}
