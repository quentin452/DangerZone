package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.SpikezillaInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.SpikezillaModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class SpikezillaRenderer extends RenderLiving {

    private static final ResourceLocation TEXTURE = new ResourceLocation(Tags.MODID, "textures/entity/spikezilla.png");
    protected SpikezillaModel model;
    private final float scale;

    public SpikezillaRenderer(SpikezillaModel par1ModelBase, float par2, float par3) {
        super(par1ModelBase, par2 * par3);
        this.model = (SpikezillaModel) this.mainModel;
        this.scale = par2 * par3;
    }

    public void renderSPIKE(final SpikezillaInstance par1EntityMolenoid, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityMolenoid, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderSPIKE((SpikezillaInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        GL11.glDisable(GL11.GL_CULL_FACE);
        renderSPIKE((SpikezillaInstance) par1Entity, par2, par4, par6, par8, par9);
        GL11.glEnable(GL11.GL_CULL_FACE);
    }

    protected void preRenderScale(SpikezillaInstance par1Entity, float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((SpikezillaInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(Entity entity) {
        return TEXTURE;
    }
}
