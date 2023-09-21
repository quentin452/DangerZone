
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Hydrolisc;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelHydrolisc;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderHydrolisc extends RenderLiving {

    protected ModelHydrolisc model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderHydrolisc(final ModelHydrolisc par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelHydrolisc) this.mainModel;
        this.scale = par3;
    }

    public void renderHydrolisc(final Hydrolisc par1EntityHydrolisc, final double par2, final double par4,
                                final double par6, final float par8, final float par9) {
        super.doRender(par1EntityHydrolisc, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderHydrolisc((Hydrolisc) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderHydrolisc((Hydrolisc) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Hydrolisc par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Hydrolisc) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderHydrolisc.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID+":hydrolisc.png");
    }
}
