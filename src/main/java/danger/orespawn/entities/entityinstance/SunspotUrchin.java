
package danger.orespawn.entities.entityinstance;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class SunspotUrchin extends EntityThrowable {

    private float my_rotation;
    private int my_index;

    public SunspotUrchin(final World par1World) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 50;
    }

    public SunspotUrchin(final World par1World, final int par2) {
        super(par1World);
        this.my_rotation = 0.0f;
        this.my_index = 50;
    }

    public SunspotUrchin(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 50;
    }

    public SunspotUrchin(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_rotation = 0.0f;
        this.my_index = 50;
    }

    public SunspotUrchin(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_rotation = 0.0f;
        this.my_index = 50;
    }

    public int getUrchinIndex() {
        return this.my_index;
    }

    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null) {
            float var2 = 3.0f;
            if (par1MovingObjectPosition.entityHit instanceof EntityCreeper) {
                var2 = 6.0f;
            }
            if (!(par1MovingObjectPosition.entityHit instanceof EntityPlayer)) {
                par1MovingObjectPosition.entityHit
                    .attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), var2);
                if (!par1MovingObjectPosition.entityHit.isImmuneToFire()) {
                    par1MovingObjectPosition.entityHit.setFire(5);
                }
            }
        } else {
            int i = par1MovingObjectPosition.blockX;
            int j = par1MovingObjectPosition.blockY;
            int k = par1MovingObjectPosition.blockZ;
            switch (par1MovingObjectPosition.sideHit) {
                case 0: {
                    --j;
                    break;
                }
                case 1: {
                    ++j;
                    break;
                }
                case 2: {
                    --k;
                    break;
                }
                case 3: {
                    ++k;
                    break;
                }
                case 4: {
                    --i;
                    break;
                }
                case 5: {
                    ++i;
                    break;
                }
            }
            if (this.worldObj.isAirBlock(i, j, k)) {
                this.worldObj.setBlock(i, j, k, (Block) Blocks.fire);
            }
        }
        for (int var3 = 0; var3 < 5; ++var3) {
            this.worldObj.spawnParticle(
                "smoke",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextFloat(),
                this.worldObj.rand.nextFloat(),
                this.worldObj.rand.nextFloat());
            this.worldObj.spawnParticle(
                "reddust",
                this.posX,
                this.posY,
                this.posZ,
                this.worldObj.rand.nextFloat(),
                this.worldObj.rand.nextFloat(),
                this.worldObj.rand.nextFloat());
        }
        if (!this.worldObj.isRemote) {
            this.setDead();
        }
    }

    public void onUpdate() {
        super.onUpdate();
        this.setFire(1);
        this.my_rotation += 30.0f;
        while (this.my_rotation > 360.0f) {
            this.my_rotation -= 360.0f;
        }
        final float my_rotation = this.my_rotation;
        this.prevRotationPitch = my_rotation;
        this.rotationPitch = my_rotation;
        this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0, 0.0, 0.0);
    }
}
