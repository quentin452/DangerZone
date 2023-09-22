
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.PitchBlack;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelPitchBlack;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderPitchBlack extends RenderLiving {

    protected ModelPitchBlack model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderPitchBlack(final ModelPitchBlack par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelPitchBlack) this.mainModel;
        this.scale = par3;
    }

    public void renderPitchBlack(final PitchBlack par1EntityPitchBlack, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityPitchBlack, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderPitchBlack((PitchBlack) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderPitchBlack((PitchBlack) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final PitchBlack par1Entity, final float par2) {
        final float pscale = par1Entity.getPitchBlackScale();
        GL11.glScalef(pscale, pscale, pscale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((PitchBlack) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderPitchBlack.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":PitchBlacktexture.png");
    }
}
