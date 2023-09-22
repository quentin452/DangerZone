package fr.iamacat.dangerzone_iamacatfr.entities.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EntityDarkEnergy extends EntityProjectile {

    public EntityDarkEnergy(World par1World) {
        super(par1World);
    }

    public EntityDarkEnergy(World par1World, EntityLivingBase par2EntityLivingBase, double par3, double par5,
        double par7) {
        super(par1World, par2EntityLivingBase, par3, par5, par7);
    }

    @Override
    public float getMotionFactor() {
        return 0.965F;
    }

    @Override
    protected void onImpact(MovingObjectPosition mop) {
        if (this.worldObj.isRemote) return;

        if (mop.entityHit != null) {
            if (mop.entityHit instanceof EntityDarkEnergy) return;

            if (mop.entityHit instanceof EntityLivingBase) {
                mop.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), 3.0F);
                ((EntityLivingBase) mop.entityHit)
                    .addPotionEffect(new PotionEffect(Potion.blindness.id, 120, 0 + rand.nextInt(2)));
            }
        }

        if (mop != null) this.setDead();
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.worldObj.isRemote && this.ticksExisted >= 80) this.setDead();

        if (!this.worldObj.isRemote && this.ticksExisted % 18 == 1) {
            this.worldObj.playSoundAtEntity(this, Tags.MODID + ":random.rocketflying", 0.4F, 1.85F);
        }
    }

    @Override
    protected String getParticleString() {
        return "smoke";
    }
}
