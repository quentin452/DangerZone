
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.PurplePower;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelPurplePower;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderPurplePower extends RenderLiving {

    protected ModelPurplePower model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture10;

    public RenderPurplePower(final ModelPurplePower par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelPurplePower) this.mainModel;
        this.scale = par3;
    }

    public void renderPurplePower(final PurplePower par1EntityPurplePower, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityPurplePower, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderPurplePower((PurplePower) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final PurplePower par1Entity, final float par2) {
        float localscale = this.scale;
        if (par1Entity.getPurpleType() != 0) {
            localscale = 0.55f;
        }
        GL11.glScalef(localscale, localscale, localscale);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final PurplePower p = (PurplePower) entity;
        final int i = p.getPurpleType();
        if (i == 1) {
            return RenderPurplePower.texture2;
        }
        if (i == 2) {
            return RenderPurplePower.texture3;
        }
        if (i == 3) {
            return RenderPurplePower.texture4;
        }
        if (i == 10) {
            return RenderPurplePower.texture10;
        }
        return RenderPurplePower.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":PurplePowertexture.png");
        texture2 = new ResourceLocation(Tags.MODID + ":PurplePowertexture2.png");
        texture3 = new ResourceLocation(Tags.MODID + ":PurplePowertexture3.png");
        texture4 = new ResourceLocation(Tags.MODID + ":PurplePowertexture4.png");
        texture10 = new ResourceLocation(Tags.MODID + ":PurplePowertexture10.png");
    }
}
