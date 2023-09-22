
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.entity.Entity;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.LaserBallSecondInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.LongHitInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilightCannonInstance;

public class RangedRenderer extends MagicRenderer {

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        if (par1Entity instanceof LongHitInstance) {
            return;
        }
        if (par1Entity instanceof TwilightCannonInstance) {
            final TwilightCannonInstance var2 = (TwilightCannonInstance) par1Entity;
            this.spinItemIconIndex = var2.getTwilightOrbIndex();
        }
        if (par1Entity instanceof LaserBallSecondInstance) {
            final LaserBallSecondInstance var3 = (LaserBallSecondInstance) par1Entity;
            this.spinItemIconIndex = var3.getLaserBallIndex();
        }
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}
