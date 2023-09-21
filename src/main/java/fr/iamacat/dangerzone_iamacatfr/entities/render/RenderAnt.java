
package fr.iamacat.dangerzone_iamacatfr.entities.render;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityAnt;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelAnt;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAnt extends RenderLiving {

    protected ModelAnt model;
    private float scale;

    public RenderAnt(final ModelAnt par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 0.25f;
        this.model = (ModelAnt) this.mainModel;
        this.scale = par3;
    }

    public void renderAnt(final EntityAnt par1EntityAnt, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1EntityAnt, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAnt((EntityAnt) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAnt((EntityAnt) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final EntityAnt par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((EntityAnt) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final EntityAnt a = (EntityAnt) entity;
        return a.getTexture(a);
    }
}