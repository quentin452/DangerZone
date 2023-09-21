
package danger.orespawn.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.Chipmunk;
import danger.orespawn.entities.entityinstance.EntityCannonFodder;
import danger.orespawn.entities.model.ModelChipmunk;

public class RenderChipmunk extends RenderLiving {

    protected ModelChipmunk model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;

    public RenderChipmunk(final ModelChipmunk par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelChipmunk) this.mainModel;
        this.scale = par3;
    }

    public void renderChipmunk(final Chipmunk par1EntityChipmunk, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityChipmunk, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderChipmunk((Chipmunk) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderChipmunk((Chipmunk) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Chipmunk par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Chipmunk) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        if (entity instanceof EntityCannonFodder) {
            final EntityCannonFodder c = (EntityCannonFodder) entity;
            if (c.get_is_activated() != 0) {
                if (c.getHatColor() == 2) {
                    return RenderChipmunk.texture2;
                }
                if (c.getHatColor() == 3) {
                    return RenderChipmunk.texture3;
                }
            }
        }
        return RenderChipmunk.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "chipmunktexture.png");
        texture2 = new ResourceLocation("orespawn", "chipmunktexture2.png");
        texture3 = new ResourceLocation("orespawn", "chipmunktexture3.png");
    }
}
