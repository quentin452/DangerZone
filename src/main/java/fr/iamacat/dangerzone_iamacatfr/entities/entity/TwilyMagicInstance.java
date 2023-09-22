
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class TwilyMagicInstance extends EntityThrowable {

    public TwilyMagicInstance(final World par1World) {
        super(par1World);
        this.setSize(2.0f, 2.0f);
    }

    public TwilyMagicInstance(final World par1World, final EntityLivingBase par3EntityPlayer) {
        super(par1World, par3EntityPlayer);
    }

    public TwilyMagicInstance(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
    }

    public TwilyMagicInstance(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit instanceof TwilyMagicInstance) {
            return;
        }
        if (par1MovingObjectPosition.entityHit instanceof TwilicornArrowInstance) {
            return;
        }
        if (par1MovingObjectPosition.entityHit != null) {
            final Entity e = par1MovingObjectPosition.entityHit;
            e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this.getThrower()), 9750.0f);
            final float var2 = 40.0f;
            if (MobUtils.isPony(par1MovingObjectPosition.entityHit)) {
                this.setDead();
                return;
            }
        }
        for (int mx = 20, var3 = 0; var3 < mx; ++var3) {
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
        }
        this.playSound("random.explode", 1.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion(
                (Entity) this,
                this.posX,
                this.posY,
                this.posZ,
                2.5f,
                this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing"));
        }
        this.worldObj
            .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, this.posX, this.posY + 1.0, this.posZ));
        this.setDead();
    }

    public void onUpdate() {
        super.onUpdate();
        for (int mx = 16, i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
            this.worldObj.spawnParticle(
                "portal",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
            this.worldObj.spawnParticle(
                "portal",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0,
                this.worldObj.rand.nextGaussian() / 5.0);
        }
    }
}
