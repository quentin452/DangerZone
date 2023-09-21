
package danger.orespawn.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.Baryonyx;
import danger.orespawn.entities.model.ModelBaryonyx;

public class RenderBaryonyx extends RenderLiving {

    protected ModelBaryonyx model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderBaryonyx(final ModelBaryonyx par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelBaryonyx) this.mainModel;
        this.scale = par3;
    }

    public void renderBaryonyx(final Baryonyx par1EntityBaryonyx, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityBaryonyx, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderBaryonyx((Baryonyx) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderBaryonyx((Baryonyx) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Baryonyx par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Baryonyx) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderBaryonyx.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "Baryonyx.png");
    }
}
