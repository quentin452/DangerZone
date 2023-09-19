
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.model.TwilicornModel;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilicornInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class TwilicornRenderer extends RenderLiving {

    protected TwilicornModel model;
    private float scale;
    private static final ResourceLocation texture3;

    public TwilicornRenderer(final TwilicornModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (TwilicornModel) this.mainModel;
        this.scale = par3;
    }

    public void renderMyTwilicorn(final TwilicornInstance par1EntityThePrince, final double par2, final double par4,
                                  final double par6, final float par8, final float par9) {
        super.doRender( par1EntityThePrince, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderMyTwilicorn((TwilicornInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderMyTwilicorn((TwilicornInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final TwilicornInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((TwilicornInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return TwilicornRenderer.texture3;
    }

    static {
        texture3 = new ResourceLocation(Tags.MODID + ":" + "textures/entity/twilicorn.png");
    }
}
