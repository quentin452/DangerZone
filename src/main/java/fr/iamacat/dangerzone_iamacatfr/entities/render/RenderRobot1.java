
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Robot1;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelRobot1;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderRobot1 extends RenderLiving {

    protected ModelRobot1 model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderRobot1(final ModelRobot1 par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelRobot1) this.mainModel;
        this.scale = par3;
    }

    public void renderRobot1(final Robot1 par1EntityRobot1, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1EntityRobot1, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderRobot1((Robot1) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderRobot1((Robot1) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Robot1 par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Robot1) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderRobot1.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":Robot1.png");
    }
}
