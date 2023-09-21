
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Shoes;
import net.minecraft.entity.Entity;

public class RenderShoe extends RenderSpinner {

    @Override
    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        if (par1Entity instanceof Shoes) {
            final Shoes var2 = (Shoes) par1Entity;
            this.spinItemIconIndex = var2.getShoeId();
        }
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }
}
