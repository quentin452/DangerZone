
package danger.orespawn.entities.renderer;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import danger.orespawn.entities.model.ModelChainsaw;

public class RenderChainsaw implements IItemRenderer {

    protected ModelChainsaw modelChainsaw;
    private static final ResourceLocation texture;

    public RenderChainsaw() {
        this.modelChainsaw = new ModelChainsaw();
    }

    public boolean handleRenderType(final ItemStack item, final IItemRenderer.ItemRenderType type) {
        switch (type) {
            case EQUIPPED: {
                return true;
            }
            case EQUIPPED_FIRST_PERSON: {
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public boolean shouldUseRenderHelper(final IItemRenderer.ItemRenderType type, final ItemStack item,
        final IItemRenderer.ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(final IItemRenderer.ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED: {
                this.renderSwordF5(-3.0f, -3.0f, -2.0f, 0.25f);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                this.renderSword(-10.0f, 1.0f, -4.0f, 0.25f);
                break;
            }
        }
    }

    private void renderSword(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(150.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(100.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderChainsaw.texture);
        this.modelChainsaw.render();
        GL11.glPopMatrix();
    }

    private void renderSwordF5(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        GL11.glRotatef(-20.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-20.0f, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderChainsaw.texture);
        this.modelChainsaw.render();
        GL11.glPopMatrix();
    }

    static {
        texture = new ResourceLocation("orespawn", "Chainsawtexture.png");
    }
}
