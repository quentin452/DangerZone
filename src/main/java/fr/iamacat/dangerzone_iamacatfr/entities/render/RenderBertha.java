
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.FMLClientHandler;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelBertha;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderBertha implements IItemRenderer {

    private static final ResourceLocation texture = new ResourceLocation(Tags.MODID + ":Berthatexture.png");
    protected ModelBertha modelBertha;

    public RenderBertha() {
        this.modelBertha = new ModelBertha();
    }

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        GL11.glPushMatrix();
        if (type == ItemRenderType.EQUIPPED) {
            renderSword(-4.0f, 2.0f, -3.0f, 0.25f);
        } else if (type == ItemRenderType.EQUIPPED_FIRST_PERSON) {
            renderSwordFirstPerson(6.0f, 3.0f, -5.0f, 0.25f);
        }
        GL11.glPopMatrix();
    }

    private void renderSword(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(190.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(25.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(texture);
        modelBertha.render();
        GL11.glPopMatrix();
    }

    private void renderSwordFirstPerson(float x, float y, float z, float scale) {
        GL11.glPushMatrix();
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glRotatef(-90.0f, 0.0f, 0.0f, 1.0f);
        GL11.glScalef(scale, scale, scale);
        GL11.glTranslatef(x, y, z);
        FMLClientHandler.instance()
            .getClient().renderEngine.bindTexture(texture);
        modelBertha.render();
        GL11.glPopMatrix();
    }
}
