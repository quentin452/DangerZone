
package fr.iamacat.dangerzone_iamacatfr.entities.render;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityCannonFodder;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Ostrich;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelOstrich;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderOstrich extends RenderLiving {

    protected ModelOstrich model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;

    public RenderOstrich(final ModelOstrich par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelOstrich) this.mainModel;
        this.scale = par3;
    }

    public void renderOstrich(final Ostrich par1EntityOstrich, final double par2, final double par4, final double par6,
                              final float par8, final float par9) {
        super.doRender(par1EntityOstrich, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderOstrich((Ostrich) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderOstrich((Ostrich) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Ostrich par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Ostrich) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        if (entity instanceof EntityCannonFodder) {
            final EntityCannonFodder c = (EntityCannonFodder) entity;
            if (c.get_is_activated() != 0) {
                if (c.getHatColor() == 2) {
                    return RenderOstrich.texture2;
                }
                if (c.getHatColor() == 3) {
                    return RenderOstrich.texture3;
                }
            }
        }
        return RenderOstrich.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID+":Ostrichtexture.png");
        texture2 = new ResourceLocation(Tags.MODID+":Ostrichtexture2.png");
        texture3 = new ResourceLocation(Tags.MODID+":Ostrichtexture3.png");
    }
}
