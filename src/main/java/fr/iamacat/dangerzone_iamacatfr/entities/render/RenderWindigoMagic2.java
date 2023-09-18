
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FireCannon;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class RenderWindigoMagic2 extends RenderMeteor {

    private static final ResourceLocation loltex;

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final FireCannon r = (FireCannon) entity;
        return RenderWindigoMagic2.loltex;
    }

    static {
        loltex = new ResourceLocation(Tags.MODID + ":" + "textures/items/windigoitem.png");
    }
}
