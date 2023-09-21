
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.client.FMLClientHandler;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelSlice;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;

public class RenderSlice implements IItemRenderer {

    protected ModelSlice modelSlice;
    private static final ResourceLocation texture;

    public RenderSlice() {
        this.modelSlice = new ModelSlice();
    }

    public boolean handleRenderType(final ItemStack item, final ItemRenderType type) {
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

    public boolean shouldUseRenderHelper(final ItemRenderType type, final ItemStack item,
        final ItemRendererHelper helper) {
        return true;
    }

    public void renderItem(final ItemRenderType type, final ItemStack item, final Object... data) {
        switch (type) {
            case EQUIPPED: {
                this.renderSwordF5(-4.0f, 2.0f, -3.0f, 0.3f);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                this.renderSword(6.0f, 3.0f, -5.0f, 0.3f);
                break;
            }
        }
    }

    private void renderSword(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderSlice.texture);
        this.modelSlice.render();
        GL11.glPopMatrix();
    }

    private void renderSwordF5(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderSlice.texture);
        this.modelSlice.render();
        GL11.glPopMatrix();
    }

    static {
        texture = new ResourceLocation(Tags.MODID+":Slicetexture.png");
    }
}
