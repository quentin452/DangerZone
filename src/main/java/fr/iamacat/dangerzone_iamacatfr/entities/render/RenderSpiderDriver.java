
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.SpiderDriver;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.RenderSpider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.util.ResourceLocation;


public class RenderSpiderDriver extends RenderSpider {

    private static final ResourceLocation texture;

    public RenderSpiderDriver(final ModelSpider modelSpider, final float par2) {}

    public void renderSpiderDriver(final SpiderDriver par1EntitySpiderDriver, final double par2, final double par4,
                                   final double par6, final float par8, final float par9) {
        super.doRender(par1EntitySpiderDriver, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderSpiderDriver((SpiderDriver) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderSpiderDriver((SpiderDriver) par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderSpiderDriver.texture;
    }

    protected ResourceLocation getSpiderTextures(final EntitySpider par1EntitySpider) {
        return RenderSpiderDriver.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":spiderdriver.png");
    }
}
