
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class BerthaHit extends EntityThrowable {

    private int hit_type;

    public BerthaHit(final World par1World) {
        super(par1World);
        this.hit_type = 0;
    }

    public BerthaHit(final World par1World, final int par2) {
        super(par1World);
        this.hit_type = 0;
    }

    public BerthaHit(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.hit_type = 0;
        this.setSize(0.33f, 0.33f);
        this.setLocationAndAngles(
            par2EntityLiving.posX,
            par2EntityLiving.posY + par2EntityLiving.getEyeHeight(),
            par2EntityLiving.posZ,
            par2EntityLiving.rotationYaw,
            par2EntityLiving.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.posY -= 0.1;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f) * 0.16f;
        this.setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0f;
        final float f = 0.4f;
        this.motionX = -MathHelper.sin(this.rotationYaw / 180.0f * 3.1415927f)
            * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f)
            * f;
        this.motionZ = MathHelper.cos(this.rotationYaw / 180.0f * 3.1415927f)
            * MathHelper.cos(this.rotationPitch / 180.0f * 3.1415927f)
            * f;
        this.motionY = -MathHelper.sin((this.rotationPitch + this.func_70183_g()) / 180.0f * 3.1415927f) * f;
        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.func_70182_d(), 0.1f);
    }

    public BerthaHit(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.hit_type = 0;
    }

    public BerthaHit(final World par1World, final double par2, final double par4, final double par6) {
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
            if ((OreSpawnMain.big_bertha_pvp == 0 && e instanceof EntityPlayer) || e instanceof Girlfriend
                || e instanceof Boyfriend) {
                this.setDead();
                return;
            }
            if (OreSpawnMain.big_bertha_pvp == 0 && e instanceof EntityTameable) {
                final EntityTameable t = (EntityTameable) e;
                if (t.isTamed()) {
                    this.setDead();
                    return;
                }
            }
            if (this.hit_type == 0 && this.getDistanceSqToEntity(this.getThrower()) < 81.0 && e != this.getThrower()) {
                e.attackEntityFrom(
                    DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()),
                    (float) OreSpawnMain.bertha_stats.damage);
                e.setFire(10);
                final double ks = 2.25;
                double inair = 0.35;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 2 && this.getDistanceSqToEntity(this.getThrower()) < 101.0 && e != this.getThrower()) {
                e.attackEntityFrom(
                    DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()),
                    (float) OreSpawnMain.royal_stats.damage);
                final double ks = 1.5;
                double inair = 0.25;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            if (this.hit_type == 3 && this.getDistanceSqToEntity(this.getThrower()) < 64.0 && e != this.getThrower()) {
                e.attackEntityFrom(
                    DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()),
                    (float) OreSpawnMain.hammy_stats.damage);
                final double ks = 1.25;
                double inair = 0.65;
                final float f3 = (float) Math.atan2(e.posZ - this.getThrower().posZ, e.posX - this.getThrower().posX);
                if (e.isDead) {
                    inair *= 2.0;
                }
                e.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
                if (!this.worldObj.isRemote && this.hit_type == 3
                    && this.getDistanceSqToEntity(this.getThrower()) < 64.0) {
                    this.worldObj.newExplosion(
                        null,
                        this.posX,
                        this.posY,
                        this.posZ,
                        1.5f,
                        true,
                        this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing"));
                }
            }
        } else
            if (!this.worldObj.isRemote && this.hit_type == 3 && this.getDistanceSqToEntity(this.getThrower()) < 64.0) {
                this.worldObj.newExplosion(
                    null,
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

    public void onUpdate() {
        super.onUpdate();
    }
}
