
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityCannonFodder;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.VelocityRaptor;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelVelocityRaptor;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderVelocityRaptor extends RenderLiving {

    protected ModelVelocityRaptor model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;

    public RenderVelocityRaptor(final ModelVelocityRaptor par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelVelocityRaptor) this.mainModel;
        this.scale = par3;
    }

    public void renderVelocityRaptor(final VelocityRaptor par1EntityVelocityRaptor, final double par2,
        final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityVelocityRaptor, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderVelocityRaptor((VelocityRaptor) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderVelocityRaptor((VelocityRaptor) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final VelocityRaptor par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((VelocityRaptor) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        if (entity instanceof EntityCannonFodder) {
            final EntityCannonFodder c = (EntityCannonFodder) entity;
            if (c.get_is_activated() != 0) {
                if (c.getHatColor() == 2) {
                    return RenderVelocityRaptor.texture2;
                }
                if (c.getHatColor() == 3) {
                    return RenderVelocityRaptor.texture3;
                }
            }
        }
        return RenderVelocityRaptor.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":velocityraptor.png");
        texture2 = new ResourceLocation(Tags.MODID + ":velocityraptor2.png");
        texture3 = new ResourceLocation(Tags.MODID + ":velocityraptor3.png");
    }
}
