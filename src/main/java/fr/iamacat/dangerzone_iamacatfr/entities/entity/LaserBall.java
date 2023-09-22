
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;

public class LaserBall extends EntityThrowable {

    private float my_rotation;
    private int my_index;
    private int is_special;
    private int is_iceball;
    private int is_acid;
    private int is_irukandji;
    private int ticksalive;

    public LaserBall(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public LaserBall(final World par1World, final int par2) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public LaserBall(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public LaserBall(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public LaserBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public int getLaserBallIndex() {
        return this.my_index;
    }

    public void setSpecial() {
        this.is_special = 1;
    }

    public void setIceBall() {
        this.is_iceball = 1;
    }

    public void setAcid() {
        this.is_acid = 1;
    }

    public void setIrukandji() {
        this.is_irukandji = 1;
        this.is_acid = 1;
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            final float var2 = 16.0f;
            if (this.is_irukandji != 0) {
                par1MovingObjectPosition.entityHit
                    .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 100.0f);
                this.setDead();
                return;
            }
            if (this.is_acid != 0) {
                if (par1MovingObjectPosition.entityHit instanceof TrooperBug) {
                    this.setDead();
                    return;
                }
                if (par1MovingObjectPosition.entityHit instanceof SpitBug) {
                    this.setDead();
                    return;
                }
            }
            if (this.is_iceball == 0 && this.is_acid == 0) {
                if (par1MovingObjectPosition.entityHit instanceof Robot2) {
                    this.setDead();
                    return;
                }
                if (par1MovingObjectPosition.entityHit instanceof Robot3) {
                    this.setDead();
                    return;
                }
                if (par1MovingObjectPosition.entityHit instanceof Robot4) {
                    this.setDead();
                    return;
                }
                if (par1MovingObjectPosition.entityHit instanceof Robot5) {
                    this.setDead();
                    return;
                }
                if (par1MovingObjectPosition.entityHit instanceof GiantRobot) {
                    this.setDead();
                    return;
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof Dragon && this.is_acid == 0) {
                final Dragon d = (Dragon) par1MovingObjectPosition.entityHit;
                if (d.riddenByEntity != null) {
                    this.setDead();
                    return;
                }
                if (d.getDragonType() != 0 && this.is_iceball != 0) {
                    this.setDead();
                    return;
                }
            }
            if (par1MovingObjectPosition.entityHit instanceof EntityPlayer && this.is_acid == 0) {
                final EntityPlayer d2 = (EntityPlayer) par1MovingObjectPosition.entityHit;
                if (d2.ridingEntity != null) {
                    this.setDead();
                    return;
                }
            }
            par1MovingObjectPosition.entityHit
                .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
            if (this.is_iceball == 0) {
                par1MovingObjectPosition.entityHit.setFire(1);
            }
        } else if (this.is_irukandji != 0 && !this.worldObj.isRemote) {
            this.dropItem(OreSpawnMain.MyIrukandji, 1);
        }
        if (this.is_acid == 0) {
            int mx = 10;
            if (this.is_special != 0) {
                mx = 20;
            }
            for (int var3 = 0; var3 < mx; ++var3) {
                this.worldObj.spawnParticle(
                    "smoke",
                    this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                    this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                    this.posZ + this.rand.nextFloat(),
                    0.0,
                    0.0,
                    0.0);
                this.worldObj.spawnParticle(
                    "largesmoke",
                    this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                    this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                    this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                    0.0,
                    0.0,
                    0.0);
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
            }
            this.playSound("random.explode", 0.5f, 1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
            if (!this.worldObj.isRemote && (this.is_special != 0 || this.is_iceball != 0)) {
                this.worldObj.createExplosion(
                    this,
                    this.posX,
                    this.posY,
                    this.posZ,
                    3.0f,
                    this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing"));
            }
        }
        this.setDead();
    }

    public void onUpdate() {
        ++this.ticksalive;
        if (this.ticksalive > 200) {
            this.setDead();
            return;
        }
        super.onUpdate();
        this.my_rotation += 50.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
        if (this.is_acid != 0) {
            return;
        }
        int mx = 4;
        if (this.is_special != 0) {
            mx = 10;
        }
        if (this.is_iceball != 0 && this.is_special == 0) {
            mx = 2;
        }
        for (int i = 0; i < mx; ++i) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextGaussian() / 2.0,
                this.worldObj.rand.nextGaussian() / 2.0,
                this.worldObj.rand.nextGaussian() / 2.0);
            if (this.is_iceball == 0) {
                this.worldObj.spawnParticle(
                    "reddust",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian() / 10.0,
                    this.worldObj.rand.nextGaussian() / 10.0,
                    this.worldObj.rand.nextGaussian() / 10.0);
            }
        }
    }
}
