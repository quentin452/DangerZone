
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;

public class IceBall extends LaserBall {

    private int my_index;
    private int icemaker;

    public IceBall(final World par1World) {
        super(par1World);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }

    public IceBall(final World par1World, final int par2) {
        super(par1World);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }

    public IceBall(final World par1World, final EntityLivingBase par2EntityLiving) {
        super(par1World, par2EntityLiving);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }

    public IceBall(final World par1World, final EntityLivingBase par2EntityLiving, final int par3) {
        super(par1World, par2EntityLiving);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }

    public IceBall(final World par1World, final double par2, final double par4, final double par6) {
        super(par1World, par2, par4, par6);
        this.my_index = 84;
        this.icemaker = 0;
        super.setIceBall();
    }

    public int getIceBallIndex() {
        return this.my_index;
    }

    public void setIceMaker(final int i) {
        this.icemaker = i;
    }

    @Override
    protected void onImpact(final MovingObjectPosition par1MovingObjectPosition) {
        if (par1MovingObjectPosition.entityHit != null && MyUtils.isRoyalty(par1MovingObjectPosition.entityHit)) {
            this.setDead();
            return;
        }
        super.onImpact(par1MovingObjectPosition);
        if (this.icemaker != 0) {
            for (int i = 0; i < 5; ++i) {
                int x = this.worldObj.rand.nextInt(4);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    x = -x;
                }
                int y = this.worldObj.rand.nextInt(4);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    y = -y;
                }
                int z = this.worldObj.rand.nextInt(4);
                if (this.worldObj.rand.nextInt(2) == 1) {
                    z = -z;
                }
                x += (int) par1MovingObjectPosition.hitVec.xCoord;
                y += (int) par1MovingObjectPosition.hitVec.yCoord;
                z += (int) par1MovingObjectPosition.hitVec.zCoord;
                this.worldObj.setBlock(x, y, z, Blocks.ice);
            }
        }
        this.setDead();
    }
}
