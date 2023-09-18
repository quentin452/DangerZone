
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.entity.Entity;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.LaserBallMLP;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.LongHit;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilightCannon;

public class RenderRanged extends RenderMagic {

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        if (par1Entity instanceof LongHit) {
            return;
        }
        if (par1Entity instanceof TwilightCannon) {
            final TwilightCannon var2 = (TwilightCannon) par1Entity;
            this.spinItemIconIndex = var2.getTwilightOrbIndex();
        }
        if (par1Entity instanceof LaserBallMLP) {
            final LaserBallMLP var3 = (LaserBallMLP) par1Entity;
            this.spinItemIconIndex = var3.getLaserBallIndex();
        }
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}
