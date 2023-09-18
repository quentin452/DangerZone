
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.config.DangerZoneConfig;

public class FireCannon extends EntityThrowable {

    private float my_rotation;
    private int my_index;

    public FireCannon(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 49;
        this.setSize(2.5f, 2.5f);
    }

    public FireCannon(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 49;
    }

    public FireCannon(final World worldObj, final double d, final double e, final double f) {
        super(worldObj, d, e, f);
        this.my_rotation = 0.0f;
        this.my_index = 49;
    }

    public int getWaterBallIndex() {
        return this.my_index;
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit instanceof MyKingbowser) {
            return;
        }
        if (par1MovingObjectPosition.entityHit != null) {
            final float var2 = (float) DangerZoneConfig.MeteorStrikeDamage;
            par1MovingObjectPosition.entityHit
                .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }
        for (int mx = 160, var3 = 0; var3 < mx; ++var3) {
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
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion(
                this,
                this.posX,
                this.posY,
                this.posZ,
                4.0f,
                this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing"));
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.my_rotation += 0.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
        for (int pn = 16, i = 0; i < pn; ++i) {
            this.worldObj.spawnParticle(
                "flame",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0);
            this.worldObj.spawnParticle(
                "angryVillager",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0,
                this.worldObj.rand.nextGaussian() / 10.0);
        }
    }
}
