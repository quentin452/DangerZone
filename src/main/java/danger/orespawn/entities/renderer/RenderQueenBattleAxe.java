
package danger.orespawn.entities.renderer;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import danger.orespawn.entities.model.ModelQueenBattleAxe;

public class RenderQueenBattleAxe implements IItemRenderer {

    protected ModelQueenBattleAxe modelQueenBattleAxe;
    private static final ResourceLocation texture;

    public RenderQueenBattleAxe() {
        this.modelQueenBattleAxe = new ModelQueenBattleAxe();
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
                this.renderSwordF5(3.0f, -8.0f, -2.0f, 0.35f);
                break;
            }
            case EQUIPPED_FIRST_PERSON: {
                this.renderSword(-2.0f, -4.0f, -6.0f, 0.35f);
                break;
            }
        }
    }

    private void renderSword(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(50.0f, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(15.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderQueenBattleAxe.texture);
        this.modelQueenBattleAxe.render();
        GL11.glPopMatrix();
    }

    private void renderSwordF5(final float x, final float y, final float z, final float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 1.0f, 0.25f, 0.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(RenderQueenBattleAxe.texture);
        this.modelQueenBattleAxe.render();
        GL11.glPopMatrix();
    }

    static {
        texture = new ResourceLocation("orespawn", "QueenBattleAxetexture.png");
    }
}
