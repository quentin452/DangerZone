
package danger.orespawn.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.Basilisk;
import danger.orespawn.entities.model.ModelBasilisk;

public class RenderBasilisk extends RenderLiving {

    protected ModelBasilisk model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderBasilisk(final ModelBasilisk par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelBasilisk) this.mainModel;
        this.scale = par3;
    }

    public void renderBasilisk(final Basilisk par1EntityBasilisk, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityBasilisk, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderBasilisk((Basilisk) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderBasilisk((Basilisk) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Basilisk par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Basilisk) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderBasilisk.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "basilisk.png");
    }
}
