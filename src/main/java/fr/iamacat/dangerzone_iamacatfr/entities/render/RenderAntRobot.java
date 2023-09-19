
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.RedAntRobotInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelAntRobot;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderAntRobot extends RenderLiving {

    protected ModelAntRobot model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderAntRobot(final ModelAntRobot par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelAntRobot) this.mainModel;
        this.scale = par3;
    }

    public void renderAntRobot(final RedAntRobotInstance par1EntityAntRobot, final double par2, final double par4,
                               final double par6, final float par8, final float par9) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glRotatef(180.0f - par8, 0.0f, 1.0f, 0.0f);
        this.bindTexture(RenderAntRobot.texture);
        GL11.glScalef(-1.0f, -1.0f, 1.0f);
        this.model.render(par1EntityAntRobot, 0.0f, 0.0f, -0.1f, 0.0f, 0.0f, 0.0625f);
        GL11.glPopMatrix();
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAntRobot((RedAntRobotInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAntRobot((RedAntRobotInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final RedAntRobotInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((RedAntRobotInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderAntRobot.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":AntRobottexture.png");
    }
}
