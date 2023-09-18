package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class LongHit extends EntityThrowable {

    private int hit_type;

    public LongHit(final World par1World) {
        super(par1World);
        this.hit_type = 0;
        this.setSize(0.2f, 0.3f);
    }

    public LongHit(final World par1World, final int par2) {
        super(par1World);
        this.hit_type = 0;
    }

    public LongHit(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.hit_type = 0;
        this.setSize(0.33f, 0.33f);
        this.setLocationAndAngles(
            par2EntityLiving.posX,
            par2EntityLiving.posY + par2EntityLiving.getEyeHeight(),
            par2EntityLiving.posZ,
            par2EntityLiving.rotationYaw,
            par2EntityLiving.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f) * 0.16f;
        this.posY -= 0.1;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        final float f = 0.4f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.141593f)
            * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f)
            * f;
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.141593f)
            * MathHelper.cos(this.rotationPitch / 180.0f * 3.141593f)
            * f;
        this.motionY = -MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0f * 3.141593f) * f;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 0.1f);
    }

    public LongHit(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.hit_type = 0;
    }

    public LongHit(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.hit_type = 0;
    }

    public void setHitType(final int i) {
        this.hit_type = i;
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (this.isDead) {
            return;
        }
        if (par1MovingObjectPosition.entityHit != null && this.getThrower() != null) {
            final Entity e = par1MovingObjectPosition.entityHit;
            if (this.hit_type == 0 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 95.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 600.0f);
                e.setFire(60);
                final double ks = 1.25;
                double inair = 0.25;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 2 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 250.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 750.0f);
                final double ks = 2.75;
                double inair = 0.35;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 3 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 64.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 55.0f);
                final double ks = 1.25;
                double inair = 0.65;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (!this.worldObj.isRemote && this.hit_type == 3
                    && this.getDistanceSqToEntity((Entity) this.getThrower()) < 64.0) {
                    this.worldObj.newExplosion(
                        (Entity) null,
                        this.posX,
                        this.posY,
                        this.posZ,
                        1.5f,
                        true,
                        this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing"));
                }
            }
            if (this.hit_type == 4 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 750.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 1750.0f);
                final double ks = 4.75;
                double inair = 0.45;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 5 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 250.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 700.0f);
                final double ks = 2.75;
                double inair = 0.35;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 6 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 85.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 950.0f);
                final double ks = 1.0;
                double inair = 0.45;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 7 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 250.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.outOfWorld, 175.0f);
                if (e != null) {
                    this.doSplashDamage(e.posX, e.posY, e.posZ, 8.0, 175.0, 1);
                }
                final double ks = 1.0;
                double inair = 0.45;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 8 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 750.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.inWall, 2000.0f);
                if (e != null) {
                    this.doSplashDamage(e.posX, e.posY, e.posZ, 32.0, 2000.0, 1);
                }
                final double ks = 0.0;
                double inair = 0.45;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 9 && this.getDistanceSqToEntity((Entity) this.getThrower()) < 6750.0
                && e != this.getThrower()) {
                e.attackEntityFrom(DamageSource.magic, 45.0f);
                final double ks = 2.0;
                double inair = 0.05;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        } else if (!this.worldObj.isRemote && this.hit_type == 3
            && this.getDistanceSqToEntity((Entity) this.getThrower()) < 64.0) {
                this.worldObj.newExplosion(
                    (Entity) null,
                    this.posX,
                    this.posY,
                    this.posZ,
                    2.1f,
                    true,
                    this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing"));
            }
        this.setDead();
    }

    private EntityLivingBase doSplashDamage(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB((Class) EntityLivingBase.class, bb);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8.isEntityAlive()
                && !(var8 instanceof MyDash)
                && !(var8 instanceof EntityPlayer)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.outOfWorld, (float) damage / 1.0f);
                final double ks = 1.2;
                final double inair = 0.15;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    public void onUpdate() {
        super.onUpdate();
    }
}
