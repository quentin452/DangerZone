
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EnderKnight;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelEnderKnight;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderEnderKnight extends RenderLiving {

    protected ModelEnderKnight model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderEnderKnight(final ModelEnderKnight par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelEnderKnight) this.mainModel;
        this.scale = par3;
    }

    public void renderEnderKnight(final EnderKnight par1EntityEnderKnight, final double par2, final double par4,
                                  final double par6, final float par8, final float par9) {
        super.doRender(par1EntityEnderKnight, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderEnderKnight((EnderKnight) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderEnderKnight((EnderKnight) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final EnderKnight par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((EnderKnight) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderEnderKnight.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":EnderKnighttexture.png");
    }
}
