package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.SpikezillaInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.SpikezillaModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class SpikezillaRenderer extends RenderLiving {

    protected SpikezillaModel model;
    private float scale;
    private static final ResourceLocation texturespk;

    public SpikezillaRenderer(final SpikezillaModel par1ModelBase, final float par2, final float par3) {
        super(par1ModelBase, par2 * par3);
        this.model = (SpikezillaModel) this.mainModel;
        this.scale = par3;
    }

    public void renderSPIKE(final SpikezillaInstance par1EntityMolenoid, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityMolenoid, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderSPIKE((SpikezillaInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        GL11.glDisable(GL11.GL_CULL_FACE);
        this.renderSPIKE((SpikezillaInstance) par1Entity, par2, par4, par6, par8, par9);
        GL11.glEnable(GL11.GL_CULL_FACE);
    }

    protected void preRenderScale(final SpikezillaInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((SpikezillaInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return SpikezillaRenderer.texturespk;
    }

    static {
        texturespk = new ResourceLocation(Tags.MODID + ":" + "textures/entity/spikezilla.png");
    }
}
