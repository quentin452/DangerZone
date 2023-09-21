
package danger.orespawn.entities.renderer;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import danger.orespawn.entities.model.ModelSquidZooka;

public class RenderSquidZooka implements IItemRenderer {

    protected ModelSquidZooka modelSquidZooka;
    private static final ResourceLocation texture;

    public RenderSquidZooka() {
        this.modelSquidZooka = new ModelSquidZooka();
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
                this.renderSwordF5(2.0f, 8.0f, 2.0f, 0.35f);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                this.renderSword(4.0f, 2.0f, 2.0f, 0.35f);
                break;
            }
        }
    }

    private void renderSword(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(-30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderSquidZooka.texture);
        this.modelSquidZooka.render();
        GL11.glPopMatrix();
    }

    private void renderSwordF5(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(30.0f, 0.0f, 1.0f, 0.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderSquidZooka.texture);
        this.modelSquidZooka.render();
        GL11.glPopMatrix();
    }

    static {
        texture = new ResourceLocation("orespawn", "SquidZookatexture.png");
    }
}
