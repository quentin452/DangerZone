package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.*;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class DeadIrukandjInstance extends EntityThrowable {
    // todo fix none model are sended when throwed

    private float my_rotation;
    private final int my_index;
    private int is_special;
    private int is_iceball;
    private int is_acid;
    private int is_irukandji;
    private int ticksalive;

    public DeadIrukandjInstance(final World world, final EntityLivingBase entityLivingBase) {
        super(world, entityLivingBase);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public DeadIrukandjInstance(final World world) {
        super(world);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public DeadIrukandjInstance(final World world, final EntityLivingBase entityLivingBase, final int par3) {
        super(world, entityLivingBase);
        this.my_rotation = 0.0f;
        this.my_index = 81;
        this.is_special = 0;
        this.is_iceball = 0;
        this.is_acid = 0;
        this.is_irukandji = 0;
        this.ticksalive = 0;
    }

    public DeadIrukandjInstance(final World world, final double par2, final double par4, final double par6) {
        super(world, par2, par4, par6);
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
        int isAcid = this.is_acid;
        float var2 = 16.0f;
        if (par1MovingObjectPosition.entityHit != null) {
            if (isAcid != 0) {
                boolean shouldSetDead = par1MovingObjectPosition.entityHit instanceof JumpyBugInstance
                    || par1MovingObjectPosition.entityHit instanceof SpitInstance;
                setEntityDeadIfCondition(par1MovingObjectPosition.entityHit, shouldSetDead);
            } else {
                boolean shouldSetDead = par1MovingObjectPosition.entityHit instanceof RoboJefferyInstance
                    || par1MovingObjectPosition.entityHit instanceof RoboPounderInstance
                    || par1MovingObjectPosition.entityHit instanceof RoboGunnerInstance
                    || par1MovingObjectPosition.entityHit instanceof RoboWarriorInstance
                    || par1MovingObjectPosition.entityHit instanceof RoboSniperInstance
                    || par1MovingObjectPosition.entityHit instanceof SpiderRobotInstance;
                setEntityDeadIfCondition(par1MovingObjectPosition.entityHit, shouldSetDead);

                if (par1MovingObjectPosition.entityHit instanceof DragonInstance) {
                    DragonInstance d = (DragonInstance) par1MovingObjectPosition.entityHit;
                    setEntityDeadIfCondition(d, d.riddenByEntity != null);
                }

                if (par1MovingObjectPosition.entityHit instanceof EntityPlayer) {
                    EntityPlayer d2 = (EntityPlayer) par1MovingObjectPosition.entityHit;
                    setEntityDeadIfCondition(d2, d2.ridingEntity != null);
                }

                par1MovingObjectPosition.entityHit
                    .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);

                if (this.is_iceball == 0) {
                    par1MovingObjectPosition.entityHit.setFire(1);
                }
            }
        }

        if (this.is_irukandji != 0 && !this.worldObj.isRemote) {
            this.dropItem(ItemInitDangerZone.ItemIrukandjiArrow, 1);
        }

        this.setDead();
    }

    private void setEntityDeadIfCondition(Entity entity, boolean shouldSetDead) {
        if (shouldSetDead) {
            entity.setDead();
        }
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
        this.prevRotationPitch = this.my_rotation;
        this.rotationPitch = this.my_rotation;
        if (this.is_acid != 0) {
            return;
        }

        int mx = this.is_special != 0 ? 10 : this.is_iceball != 0 ? 2 : 4;

        for (int i = 0; i < mx; ++i) {
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
