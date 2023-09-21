
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Fairy;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelFairy;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderFairy extends RenderLiving {

    protected ModelFairy model;
    private float scale;

    public RenderFairy(final ModelFairy par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelFairy) this.mainModel;
        this.scale = par3;
    }

    public void renderFairy(final Fairy par1EntityFairy, final double par2, final double par4, final double par6,
                            final float par8, final float par9) {
        super.doRender(par1EntityFairy, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderFairy((Fairy) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderFairy((Fairy) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Fairy par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Fairy) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final Fairy a = (Fairy) entity;
        return a.getTexture(a);
    }
}
