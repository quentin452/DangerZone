
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyMavis;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;

public class MavisBall extends EntityThrowable implements IProjectile {

    private final double randomX;
    private final double randomY;
    private final double randomZ;

    public MavisBall(final World par1World) {
        super(par1World);
        this.setSize(1.2f, 1.2f);
        this.randomX = this.rand.nextGaussian() / 10.0;
        this.randomY = this.rand.nextGaussian() / 10.0;
        this.randomZ = this.rand.nextGaussian() / 10.0;
    }

    public MavisBall(final World par1World, final EntityLivingBase par3EntityPlayer, double randomX, double randomY, double randomZ) {
        super(par1World, par3EntityPlayer);
        this.randomX = randomX;
        this.randomY = randomY;
        this.randomZ = randomZ;
    }

    public MavisBall(final World par1World, final EntityLivingBase par2EntityLiving, final int par3, double randomX, double randomY, double randomZ) {
        super(par1World, par2EntityLiving);
        this.randomX = randomX;
        this.randomY = randomY;
        this.randomZ = randomZ;
    }

    public MavisBall(final World par1World, final double par2, final double par4, final double par6, double randomX, double randomY, double randomZ) {
        super(par1World, par2, par4, par6);
        this.randomX = randomX;
        this.randomY = randomY;
        this.randomZ = randomZ;
    }


    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            if (par1MovingObjectPosition.entityHit instanceof MyMavis) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof MavisBall) {
                return;
            }
            final Entity e = par1MovingObjectPosition.entityHit;
            e.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.getThrower()), 125.0f);
            final float var2 = 40.0f;
            if (MobUtils.isPony(par1MovingObjectPosition.entityHit)) {
                this.setDead();
                return;
            }
        }
        for (int mx = 20, var3 = 0; var3 < mx; ++var3) {
            this.worldObj.spawnParticle(
                "magicCrit",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "magicCrit",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "magicCrit",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
        }
        this.playSound("random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {}
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        for (int mx = 16, i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle(
                "portal",
                this.posX,
                this.posY,
                this.posZ,
                this.randomX,
                this.randomY,
                this.randomZ);
            this.worldObj.spawnParticle(
                "magicCrit",
                this.posX,
                this.posY,
                this.posZ,
                this.randomX,
                this.randomY,
                this.randomZ);
        }
    }
}
