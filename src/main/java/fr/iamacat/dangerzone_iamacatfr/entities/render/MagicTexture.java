
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyMagic;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class MagicTexture extends Render {

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
    private static final ResourceLocation texturetwilightcannon;

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
        par1Tessellator
            .addVertexWithUV((double) (0.0f - var8), (double) (0.0f - var9), 0.0, (double) var3, (double) var6);
        par1Tessellator
            .addVertexWithUV((double) (var7 - var8), (double) (0.0f - var9), 0.0, (double) var4, (double) var6);
        par1Tessellator
            .addVertexWithUV((double) (var7 - var8), (double) (var7 - var9), 0.0, (double) var4, (double) var5);
        par1Tessellator
            .addVertexWithUV((double) (0.0f - var8), (double) (var7 - var9), 0.0, (double) var3, (double) var5);
        par1Tessellator.draw();
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final MyMagic r = (MyMagic) entity;
        if (r.getRockType() == 1) {
            return MagicTexture.texture1;
        }
        if (r.getRockType() == 2) {
            return MagicTexture.texture2;
        }
        if (r.getRockType() == 3) {
            return MagicTexture.texture3;
        }
        if (r.getRockType() == 4) {
            return MagicTexture.texture4;
        }
        if (r.getRockType() == 5) {
            return MagicTexture.texture5;
        }
        if (r.getRockType() == 6) {
            return MagicTexture.texture6;
        }
        if (r.getRockType() == 7) {
            return MagicTexture.texture7;
        }
        if (r.getRockType() == 8) {
            return MagicTexture.texture8;
        }
        if (r.getRockType() == 9) {
            return MagicTexture.texture9;
        }
        if (r.getRockType() == 10) {
            return MagicTexture.texture10;
        }
        if (r.getRockType() == 11) {
            return MagicTexture.texture11;
        }
        if (r.getRockType() == 12) {
            return MagicTexture.texture12;
        }
        return MagicTexture.texture1;
    }

    static {
        texture1 = new ResourceLocation(Tags.MODID + ":" + "textures/items/twilightstar.png");
        texture2 = new ResourceLocation("", "");
        texture3 = new ResourceLocation("", "");
        texture4 = new ResourceLocation("", "");
        texture5 = new ResourceLocation("", "");
        texture6 = new ResourceLocation("", "");
        texture7 = new ResourceLocation("", "");
        texture8 = new ResourceLocation("", "");
        texture9 = new ResourceLocation("", "");
        texture10 = new ResourceLocation("", "");
        texture11 = new ResourceLocation("", "");
        texture12 = new ResourceLocation(Tags.MODID + ":" + "textures/items/twilightstar.png");
        texturetwilightcannon = new ResourceLocation(Tags.MODID + ":" + "textures/items/twilightstar.png");
    }
}
