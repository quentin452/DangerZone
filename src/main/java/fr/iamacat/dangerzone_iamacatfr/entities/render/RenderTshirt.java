
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Tshirt;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelTshirt;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderTshirt extends RenderLiving {

    protected ModelTshirt model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderTshirt(final ModelTshirt par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelTshirt) this.mainModel;
        this.scale = par3;
    }

    public void renderTshirt(final Tshirt par1EntityTshirt, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1EntityTshirt, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderTshirt((Tshirt) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderTshirt((Tshirt) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Tshirt par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Tshirt) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderTshirt.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":textures/entity/Tshirttexture.png");
    }
}
