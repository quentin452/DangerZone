
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class RainbowCannonInstance extends EntityThrowable {

    public RainbowCannonInstance(final World par1World) {
        super(par1World);
        this.setSize(1.0f, 1.0f);
    }

    public RainbowCannonInstance(final World par1World, final EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public RainbowCannonInstance(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
    }

    public RainbowCannonInstance(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            if (par1MovingObjectPosition.entityHit instanceof DashInstance) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof TwilicornInstance) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof BetterFireballInstance) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof AJInstance) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof TwilightMagicInstance) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof RainbowCannonInstance) {
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
