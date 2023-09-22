
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.AJInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AppleJackModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class AJRenderer extends RenderLiving {

    protected AppleJackModel model;
    private float scale;
    private static final ResourceLocation texture5;

    public AJRenderer(final AppleJackModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (AppleJackModel) this.mainModel;
        this.scale = par3;
    }

    public void renderAJ(final AJInstance par1EntityMolenoid, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1EntityMolenoid, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderAJ((AJInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAJ((AJInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final AJInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((AJInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return AJRenderer.texture5;
    }

    static {
        texture5 = new ResourceLocation(Tags.MODID + ":" + "textures/entity/applejack.png");
    }
}
