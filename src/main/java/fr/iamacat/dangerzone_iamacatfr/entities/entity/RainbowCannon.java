
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class RainbowCannon extends EntityThrowable {

    public RainbowCannon(final World par1World) {
        super(par1World);
        this.setSize(1.0f, 1.0f);
    }

    public RainbowCannon(final World par1World, final EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public RainbowCannon(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
    }

    public RainbowCannon(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            if (par1MovingObjectPosition.entityHit instanceof MyDash) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof MyTwilicorn) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof BetterFireball) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof MyAJ) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof MyTwilightMagic) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof RainbowCannon) {
                return;
            }
            final Entity e = par1MovingObjectPosition.entityHit;
            e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this.getThrower()), 250.0f);
            final float var2 = 40.0f;
        }
        for (int mx = 60, var3 = 0; var3 < mx; ++var3) {
            this.worldObj.spawnParticle(
                "spell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "spell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "spell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
        }
        this.playSound("random.explode", 2.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        for (int mx = 16, i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle(
                "instantSpell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
            this.worldObj.spawnParticle(
                "instantSpell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
            this.worldObj.spawnParticle(
                "instantSpell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
            this.worldObj.spawnParticle(
                "spell",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
        }
    }
}
