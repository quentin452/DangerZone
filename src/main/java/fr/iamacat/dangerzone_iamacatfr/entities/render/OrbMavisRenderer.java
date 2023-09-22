
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.MavisBallInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class OrbMavisRenderer extends Render {

    public static ResourceLocation texture;

    public void renderBall(final MavisBallInstance par1EntityArrow, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.bindTexture(OrbMavisRenderer.texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glRotatef(
            par1EntityArrow.prevRotationYaw + (par1EntityArrow.rotationYaw - par1EntityArrow.prevRotationYaw) * par9
                - 90.0f,
            0.0f,
            1.0f,
            0.0f);
        GL11.glRotatef(
            par1EntityArrow.prevRotationPitch
                + (par1EntityArrow.rotationPitch - par1EntityArrow.prevRotationPitch) * par9,
            0.0f,
            0.0f,
            1.0f);
        final Tessellator var10 = Tessellator.instance;
        final byte var11 = 0;
        final float var12 = 0.0f;
        final float var13 = 0.5f;
        final float var14 = (0 + var11 * 10) / 32.0f;
        final float var15 = (5 + var11 * 10) / 32.0f;
        final float var16 = 0.0f;
        final float var17 = 0.15625f;
        final float var18 = (5 + var11 * 10) / 32.0f;
        final float var19 = (10 + var11 * 10) / 32.0f;
        final float var20 = 0.05625f;
        GL11.glEnable(32826);
        GL11.glRotatef(45.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(var20, var20, var20);
        GL11.glTranslatef(-4.0f, 0.0f, 0.0f);
        GL11.glNormal3f(var20, 0.0f, 0.0f);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0, -2.0, -2.0, (double) var16, (double) var18);
        var10.addVertexWithUV(-7.0, -2.0, 2.0, (double) var17, (double) var18);
        var10.addVertexWithUV(-7.0, 2.0, 2.0, (double) var17, (double) var19);
        var10.addVertexWithUV(-7.0, 2.0, -2.0, (double) var16, (double) var19);
        var10.draw();
        GL11.glNormal3f(-var20, 0.0f, 0.0f);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0, 2.0, -2.0, (double) var16, (double) var18);
        var10.addVertexWithUV(-7.0, 2.0, 2.0, (double) var17, (double) var18);
        var10.addVertexWithUV(-7.0, -2.0, 2.0, (double) var17, (double) var19);
        var10.addVertexWithUV(-7.0, -2.0, -2.0, (double) var16, (double) var19);
        var10.draw();
        for (int var21 = 0; var21 < 4; ++var21) {
            GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
            GL11.glNormal3f(0.0f, 0.0f, var20);
            var10.startDrawingQuads();
            var10.addVertexWithUV(-8.0, -2.0, 0.0, (double) var12, (double) var14);
            var10.addVertexWithUV(8.0, -2.0, 0.0, (double) var13, (double) var14);
            var10.addVertexWithUV(8.0, 2.0, 0.0, (double) var13, (double) var15);
            var10.addVertexWithUV(-8.0, 2.0, 0.0, (double) var12, (double) var15);
            var10.draw();
        }
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderBall((MavisBallInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return OrbMavisRenderer.texture;
    }

    static {
        OrbMavisRenderer.texture = new ResourceLocation(Tags.MODID + ":textures/items/MavisOrbModel.png");
    }
}
