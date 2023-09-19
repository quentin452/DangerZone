
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CannonFodderInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Lizard;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelLizard;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
public class RenderLizard extends RenderLiving {

    protected ModelLizard model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;

    public RenderLizard(final ModelLizard par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelLizard) this.mainModel;
        this.scale = par3;
    }

    public void renderLizard(final Lizard par1EntityLizard, final double par2, final double par4, final double par6,
                             final float par8, final float par9) {
        super.doRender(par1EntityLizard, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderLizard((Lizard) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderLizard((Lizard) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Lizard par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Lizard) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        if (entity instanceof CannonFodderInstance) {
            final CannonFodderInstance c = (CannonFodderInstance) entity;
            if (c.get_is_activated() != 0) {
                if (c.getHatColor() == 2) {
                    return RenderLizard.texture2;
                }
                if (c.getHatColor() == 3) {
                    return RenderLizard.texture3;
                }
            }
        }
        return RenderLizard.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":Lizard.png");
        texture2 = new ResourceLocation(Tags.MODID + ":Lizard2.png");
        texture3 = new ResourceLocation(Tags.MODID + ":Lizard3.png");
    }
}
