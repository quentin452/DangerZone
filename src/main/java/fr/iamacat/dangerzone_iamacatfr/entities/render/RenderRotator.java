
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Rotator;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelRotator;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderRotator extends RenderLiving {

    protected ModelRotator model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderRotator(final ModelRotator par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelRotator) this.mainModel;
        this.scale = par3;
    }

    public void renderRotator(final Rotator par1EntityRotator, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1EntityRotator, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderRotator((Rotator) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderRotator((Rotator) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Rotator par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Rotator) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderRotator.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":Rotatortexture.png");
    }
}
