
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class PhoenixArrowInstance extends EntityThrowable {

    public PhoenixArrowInstance(final World par1World) {
        super(par1World);
        this.setSize(1.5f, 1.5f);
    }

    public PhoenixArrowInstance(final World par1World, final EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public PhoenixArrowInstance(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
    }

    public PhoenixArrowInstance(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (!this.worldObj.isRemote) {
            if (par1MovingObjectPosition.entityHit != null) {
                final Entity entityHit = par1MovingObjectPosition.entityHit;
                EntityLivingBase thrower = this.getThrower();

                if (thrower != null) {
                    entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) thrower), 450.0f);
                    entityHit.setFire(20);
                }

                final int maxParticles = 40;
                for (int i = 0; i < maxParticles; ++i) {
                    this.worldObj.spawnParticle(

                        "flame",
                        this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                        this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                        this.posZ + this.rand.nextFloat(),
                        0.0,
                        0.0,
                        0.0);
                    this.worldObj.spawnParticle(
                        "flame",
                        this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                        this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                        this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                        0.0,
                        0.0,
                        0.0);
                    this.worldObj.spawnParticle(
                        "flame",
                        this.posX,
                        this.posY,
                        this.posZ,
                        this.worldObj.rand.nextGaussian(),
                        this.worldObj.rand.nextGaussian(),
                        this.worldObj.rand.nextGaussian());
                }

                this.playSound("random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
            }

            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        for (int mx = 16, i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle(
                "flame",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0);
            this.worldObj.spawnParticle(
                "flame",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0);
        }
    }
}
