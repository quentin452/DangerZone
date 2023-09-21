
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.*;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
// todo add a spawn for this entity
public class DarknessInstance extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorterInstance TargetSorter;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private Entity rt;
    private int MagicType;
    public int TwilightMagicOrbMode;
    public int darkscorpionmagic;

    public DarknessInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.rt = null;
        this.MagicType = 0;
        this.TwilightMagicOrbMode = 0;
        this.darkscorpionmagic = 0;
        this.setSize(1.5f, 1.5f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 100;
        this.isImmuneToFire = false;
        this.fireResistance = 5;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.noClip = false;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.2199999928474426);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(5.0);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
    }

    protected boolean canDespawn() {
        return true;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    protected float getSoundVolume() {
        return 0.35f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 45;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.worldObj.spawnParticle(
            "fireworksSpark",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
        this.worldObj.spawnParticle(
            "fireworksSpark",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
        this.worldObj.spawnParticle(
            "fireworksSpark",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
        this.worldObj.spawnParticle(
            "explode",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
        this.worldObj.spawnParticle(
            "explode",
            this.posX,
            this.posY + 1.25,
            this.posZ,
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f),
            (double) ((this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) / 2.0f));
        this.motionY *= 0.6;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = false;
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final EntityLivingBase e = (EntityLivingBase) par1Entity;
            final float ghp = e.getMaxHealth() / 99.0f;
            e.setHealth(e.getHealth() - ghp);
        }
        return var4;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 1.55, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    private EntityLivingBase createExplodeSource(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (var8 != null && var8 != this && var8.isEntityAlive() && !(var8 instanceof TwilightMagicInstance)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.fall, (float) damage / 1.0f);
                this.worldObj.playSoundAtEntity(
                    (Entity) var8,
                    "random.explode",
                    2.65f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 0.0;
                final double inair = 0.1;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        EntityLivingBase e = null;
        int keep_trying = 50;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null && e == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (e == null) {
            e = this.findSomethingToAttack();
        }
        if (this.lastX == (int) this.posX && this.lastZ == (int) this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int) this.posX;
            this.lastZ = (int) this.posZ;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        Block bid = Blocks.air;
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.5f) {
            bid = Blocks.stone;
        }
        if (this.stuck_count > 10
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            bid = Blocks.stone;
            this.stuck_count = 0;
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
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                e = this.findSomethingToAttack();
                if (e == null) {
                    continue;
                }
                this.setAttacking(1);
                this.currentFlightTarget.set((int) e.posX, (int) (e.posY + e.height / 2.0f), (int) e.posZ);
                if (this.getDistanceSqToEntity((Entity) e) >= (8.0f + e.width / 2.0f) * (8.0f + e.width / 2.0f)
                    || (this.worldObj.rand.nextInt(2) != 1 && this.worldObj.rand.nextInt(1) != 0)) {
                    continue;
                }
                this.attackEntityAsMob((Entity) e);
                final float ghp = e.getMaxHealth() / 95.0f;
                e.setHealth(e.getHealth() - ghp);
            }
        }
        this.noClip = false;
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.5 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 1.2 - this.motionX) * 0.6000000014901161;
        this.motionY += (Math.signum(var2) * 1.099999988079071 - this.motionY) * 0.4000000014901161;
        this.motionZ += (Math.signum(var3) * 1.2 - this.motionZ) * 0.6000000014901161;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 1.2f;
        this.rotationYaw += var5 / 4.0f;
    }

    public boolean canBePushed() {
        return false;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase) {
                this.rt = e;
            }
        }
        return ret;
    }

    public int getTotalArmorValue() {
        return 24;
    }

    public void initCreature() {}

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
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving.isInWater()) {
            return false;
        }
        if (par1EntityLiving instanceof DarknessInstance) {
            return false;
        }
        if (par1EntityLiving instanceof TwilightMagicInstance) {
            return true;
        }
        if (par1EntityLiving instanceof ArcticScorpionInstance) {
            return false;
        }
        if (par1EntityLiving instanceof TwilicornInstance) {
            return false;
        }
        if (par1EntityLiving instanceof DashInstance) {
            return false;
        }
        if (par1EntityLiving instanceof AJInstance) {
            return false;
        }
        if (par1EntityLiving instanceof WindigoInstance) {
            return false;
        }
        if (par1EntityLiving instanceof ParaspriteInstance) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return !MobUtils.isAttackableNonMob(par1EntityLiving) || true;
    }

    private EntityLivingBase setExplodeSource(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (var8 != null && var8 != this && var8.isEntityAlive() && !MobUtils.isPony((Entity) var8)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.fall, (float) damage / 1.0f);
                this.worldObj.playSoundAtEntity(
                    (Entity) var8,
                    "random.explode",
                    2.65f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 0.0;
                final double inair = -4.0;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(64.0, 32.0, 64.0));
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
}
