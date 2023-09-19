
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilyMagicInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class TwilyMagic2Renderer extends TwilyMagicRenderer {

    private static final ResourceLocation rdmagic;

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final TwilyMagicInstance r = (TwilyMagicInstance) entity;
        return TwilyMagic2Renderer.rdmagic;
    }

    static {
        rdmagic = new ResourceLocation(Tags.MODID + ":" + "textures/items/twilightstar.png");
    }
}
