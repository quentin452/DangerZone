
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FireCannon;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class Meteor2Renderer extends MeteorRenderer {

    private static final ResourceLocation RLMeteor;

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final FireCannon r = (FireCannon) entity;
        return Meteor2Renderer.RLMeteor;
    }

    static {
        RLMeteor = new ResourceLocation(Tags.MODID + ":" + "textures/items/meteoritem.png");
    }
}
