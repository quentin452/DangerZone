
package danger.orespawn.entities.renderer;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.entities.entityinstance.EntityThrownRock;

@SideOnly(Side.CLIENT)
public class RenderThrownRock extends Render {

    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private static final ResourceLocation texture7;
    private static final ResourceLocation texture8;
    private static final ResourceLocation texture9;
    private static final ResourceLocation texture10;
    private static final ResourceLocation texture11;
    private static final ResourceLocation texture12;

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.bindTexture(this.getEntityTexture(par1Entity));
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glEnable(32826);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        final Tessellator var10 = Tessellator.instance;
        this.func_77026_a(var10, 0, par1Entity.rotationPitch);
        GL11.glDisable(32826);
        GL11.glPopMatrix();
    }

    private void func_77026_a(final Tessellator par1Tessellator, final int par2, final float par3) {
        final float var3 = (par2 % 16 * 16 + 0) / 16.0f;
        final float var4 = (par2 % 16 * 16 + 16) / 16.0f;
        final float var5 = (par2 / 16 * 16 + 0) / 16.0f;
        final float var6 = (par2 / 16 * 16 + 16) / 16.0f;
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
        final EntityThrownRock r = (EntityThrownRock) entity;
        if (r.getRockType() == 1) {
            return RenderThrownRock.texture1;
        }
        if (r.getRockType() == 2) {
            return RenderThrownRock.texture2;
        }
        if (r.getRockType() == 3) {
            return RenderThrownRock.texture3;
        }
        if (r.getRockType() == 4) {
            return RenderThrownRock.texture4;
        }
        if (r.getRockType() == 5) {
            return RenderThrownRock.texture5;
        }
        if (r.getRockType() == 6) {
            return RenderThrownRock.texture6;
        }
        if (r.getRockType() == 7) {
            return RenderThrownRock.texture7;
        }
        if (r.getRockType() == 8) {
            return RenderThrownRock.texture8;
        }
        if (r.getRockType() == 9) {
            return RenderThrownRock.texture9;
        }
        if (r.getRockType() == 10) {
            return RenderThrownRock.texture10;
        }
        if (r.getRockType() == 11) {
            return RenderThrownRock.texture11;
        }
        if (r.getRockType() == 12) {
            return RenderThrownRock.texture12;
        }
        return RenderThrownRock.texture1;
    }

    static {
        texture1 = new ResourceLocation("orespawn", "textures/items/rocksmall.png");
        texture2 = new ResourceLocation("orespawn", "textures/items/rock.png");
        texture3 = new ResourceLocation("orespawn", "textures/items/rockred.png");
        texture4 = new ResourceLocation("orespawn", "textures/items/rockgreen.png");
        texture5 = new ResourceLocation("orespawn", "textures/items/rockblue.png");
        texture6 = new ResourceLocation("orespawn", "textures/items/rockpurple.png");
        texture7 = new ResourceLocation("orespawn", "textures/items/rockspikey.png");
        texture8 = new ResourceLocation("orespawn", "textures/items/rocktnt.png");
        texture9 = new ResourceLocation("orespawn", "textures/items/rockcrystalred.png");
        texture10 = new ResourceLocation("orespawn", "textures/items/rockcrystalgreen.png");
        texture11 = new ResourceLocation("orespawn", "textures/items/rockcrystalblue.png");
        texture12 = new ResourceLocation("orespawn", "textures/items/rockcrystaltnt.png");
    }
}
