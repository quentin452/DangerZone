
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class Shoes extends EntityThrowable {

    public int ShoeId;
    private float my_rotation;

    public Shoes(final World par1World) {
        super(par1World);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = this.rand.nextInt(4) + 2;
        this.dataWatcher.addObject(20, this.ShoeId);
    }

    public Shoes(final World par1World, final int par2) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.ShoeId = par2;
        this.dataWatcher.addObject(20, this.ShoeId);
    }

    public Shoes(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = this.rand.nextInt(4) + 2;
        this.dataWatcher.addObject(20, this.ShoeId);
    }

    public Shoes(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.ShoeId = par3;
        this.dataWatcher.addObject(20, this.ShoeId);
    }

    public Shoes(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.ShoeId = 0;
        this.my_rotation = 0.0f;
        this.ShoeId = this.rand.nextInt(4) + 2;
        this.dataWatcher.addObject(20, this.ShoeId);
    }

    public int getShoeId() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            float var2 = 2.0f;
            if (this.getShoeId() == 6) {
                var2 = 6.0f;
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityCreeper) {
                var2 += 4.0f;
            }
            if (par1MovingObjectPosition.entityHit instanceof Girlfriend) {
                var2 = 1.0f;
            }
            if (par1MovingObjectPosition.entityHit instanceof Boyfriend) {
                var2 = 1.0f;
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityPlayer) {
                var2 = 0.0f;
            }
            if (OreSpawnMain.valentines_day != 0) {
                var2 = 10.0f;
            }
            par1MovingObjectPosition.entityHit
                .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
        }
        for (int var3 = 0; var3 < 4; ++var3) {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
            this.worldObj.spawnParticle("reddust", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.my_rotation += 20.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
    }
}
