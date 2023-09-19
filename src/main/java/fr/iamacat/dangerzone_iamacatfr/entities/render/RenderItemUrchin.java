
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import net.minecraft.entity.Entity;


public class RenderItemUrchin extends RenderSpinner {

    @Override
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        if (par1Entity instanceof BerthaHit) {
            return;
        }
        if (par1Entity instanceof SunspotUrchin) {
            final SunspotUrchin var2 = (SunspotUrchin) par1Entity;
            this.spinItemIconIndex = var2.getUrchinIndex();
        }
        if (par1Entity instanceof WaterBallInstance) {
            final WaterBallInstance var3 = (WaterBallInstance) par1Entity;
            this.spinItemIconIndex = var3.getWaterBallIndex();
        }
        if (par1Entity instanceof InkSack) {
            final InkSack var4 = (InkSack) par1Entity;
            this.spinItemIconIndex = var4.getInkSackIndex();
        }
        if (par1Entity instanceof LaserBallInstance) {
            final LaserBallInstance var5 = (LaserBallInstance) par1Entity;
            this.spinItemIconIndex = var5.getLaserBallIndex();
        }
        if (par1Entity instanceof IceBall) {
            final IceBall var6 = (IceBall) par1Entity;
            this.spinItemIconIndex = var6.getIceBallIndex();
        }
        if (par1Entity instanceof AcidEntityInstance) {
            final AcidEntityInstance var7 = (AcidEntityInstance) par1Entity;
            this.spinItemIconIndex = var7.getAcidIndex();
        }
        if (par1Entity instanceof DeadIrukandjiInstance) {
            final DeadIrukandjiInstance var8 = (DeadIrukandjiInstance) par1Entity;
            this.spinItemIconIndex = var8.getIrukandjiIndex();
        }
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}
