package fr.iamacat.dangerzone_iamacatfr.entities.projectile;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DarkCrystalInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.DirectedLightningInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.util.WorldHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityDarkLightning extends EntityProjectile {

    public EntityDarkLightning(World par1World) {
        super(par1World);
        this.isImmuneToFire = true;
        this.setSize(0.325F, 0.325F);
    }

    public EntityDarkLightning(World par1World, EntityLivingBase entity, double par2, double par4, double par6) {
        super(par1World, entity, par2, par4, par6);
    }

    @Override
    public float getMotionFactor() {
        return 0.766736F;
    }

    @Override
    protected void onImpact(MovingObjectPosition var1) {
        if (this.worldObj.isRemote) {
            // spawn particles on impact with something
        } else {
            if (var1.entityHit != null && !(var1.entityHit instanceof BeeInstance)
                && !(var1.entityHit instanceof DarkCrystalInstance)
                && !(var1.entityHit instanceof EntityDarkLightning)) {
                var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.shootingEntity), 5.0F);
                this.worldObj.spawnEntityInWorld(
                    new DirectedLightningInstance(
                        this.worldObj,
                        var1.entityHit.posX,
                        var1.entityHit.posY,
                        var1.entityHit.posZ,
                        this));
                if (var1.entityHit instanceof EntityLivingBase)
                    ((EntityLivingBase) var1.entityHit).addPotionEffect(new PotionEffect(Potion.blindness.id, 120, 1));
            }
            if (var1 != null) this.setDead();
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (this.ticksInAir % 20 == 0 && this.ticksInAir > 10
            && this.ticksInAir <= 120
            && !this.isDead
            && !this.worldObj.isRemote) {
            int y = WorldHelper.getDistanceToGround(this);
            this.worldObj.spawnEntityInWorld(
                new DirectedLightningInstance(this.worldObj, this.posX, this.posY - y, this.posZ, this));
        }

        if (!this.worldObj.isRemote && this.ticksExisted >= 120) this.setDead();
    }

    @Override
    protected String getParticleString() {
        return "witchMagic";
    }

}
