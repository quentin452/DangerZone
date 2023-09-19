
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CageInstance;
import net.minecraft.entity.Entity;


public class RenderCage extends RenderSpinner {

    @Override
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.spinItemIconIndex = 160;
        if (par1Entity instanceof CageInstance) {
            final CageInstance var2 = (CageInstance) par1Entity;
            this.spinItemIconIndex = var2.getCageIndex();
        }
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}