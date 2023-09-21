
package danger.orespawn.entities.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpinner extends Render {

    public int spinItemIconIndex;
    private static final ResourceLocation texture;

    public RenderSpinner() {
        this.spinItemIconIndex = 160;
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.bindTexture(RenderSpinner.texture);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        final Tessellator var10 = Tessellator.instance;
        this.func_77026_a(var10, this.spinItemIconIndex, par1Entity.rotationPitch);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_77026_a(final Tessellator par1Tessellator, final int par2, final float par3) {
        final float var3 = (par2 % 16 * 16 + 0) / 256.0f;
        final float var4 = (par2 % 16 * 16 + 16) / 256.0f;
        final float var5 = (par2 / 16 * 16 + 0) / 256.0f;
        final float var6 = (par2 / 16 * 16 + 16) / 256.0f;
        final float var7 = 1.0f;
        final float var8 = 0.5f;
        final float var9 = 0.25f;
        GL11.glRotatef(180.0f - this.renderManager.playerViewY, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(par3, 0.0f, 0.0f, 1.0f);
        par1Tessellator.startDrawingQuads();
        par1Tessellator.setNormal(0.0f, 1.0f, 0.0f);
        par1Tessellator.addVertexWithUV((0.0f - var8), (0.0f - var9), 0.0, var3, var6);
        par1Tessellator.addVertexWithUV((var7 - var8), (0.0f - var9), 0.0, var4, var6);
        par1Tessellator.addVertexWithUV((var7 - var8), (var7 - var9), 0.0, var4, var5);
        par1Tessellator.addVertexWithUV((0.0f - var8), (var7 - var9), 0.0, var3, var5);
        par1Tessellator.draw();
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderSpinner.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "spinners.png");
    }
}
