
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class InkSack extends EntityThrowable {

    private float my_rotation;
    private int my_index;

    public InkSack(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }

    public InkSack(final World par1World, final int par2) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }

    public InkSack(final World par1World, final EntityLiving par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }

    public InkSack(final World par1World, final EntityLiving par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }

    public InkSack(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_rotation = 0.0f;
        this.my_index = 65;
    }

    public int getInkSackIndex() {
        return this.my_index;
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            float var2 = 1.0f;
            if (par1MovingObjectPosition.entityHit instanceof EntityCreeper) {
                var2 = 4.0f;
            }
            if (par1MovingObjectPosition.entityHit instanceof WaterDragon) {
                return;
            }
            if (par1MovingObjectPosition.entityHit instanceof AttackSquidInstance) {
                return;
            }
            par1MovingObjectPosition.entityHit
                .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
            if (par1MovingObjectPosition.entityHit instanceof EntityLivingBase && this.worldObj.rand.nextInt(2) == 0) {
                ((EntityLiving) par1MovingObjectPosition.entityHit).addPotionEffect(
                    new PotionEffect(Potion.blindness.id, 100 + 50 * this.worldObj.rand.nextInt(8), 0));
            }
        }
        for (int var3 = 0; var3 < 4; ++var3) {
            this.worldObj.spawnParticle(
                "smoke",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
        }
        this.playSound("random.splash", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.my_rotation += 30.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
    }
}
