
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilyMagic;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderTwilyMagic2 extends RenderTwilyMagic {

    private static final ResourceLocation rdmagic;

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final TwilyMagic r = (TwilyMagic) entity;
        return RenderTwilyMagic2.rdmagic;
    }

    static {
        rdmagic = new ResourceLocation(Tags.MODID + ":" + "textures/items/twilightstar.png");
    }
}
