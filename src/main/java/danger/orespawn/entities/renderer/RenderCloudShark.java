
package danger.orespawn.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.CloudShark;
import danger.orespawn.entities.model.ModelCloudShark;

public class RenderCloudShark extends RenderLiving {

    protected ModelCloudShark model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderCloudShark(final ModelCloudShark par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelCloudShark) this.mainModel;
        this.scale = par3;
    }

    public void renderCloudShark(final CloudShark par1EntityCloudShark, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityCloudShark, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderCloudShark((CloudShark) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderCloudShark((CloudShark) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final CloudShark par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((CloudShark) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderCloudShark.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "CloudShark.png");
    }
}
