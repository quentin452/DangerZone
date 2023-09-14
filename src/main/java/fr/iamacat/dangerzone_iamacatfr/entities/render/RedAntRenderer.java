package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.RedAntInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.RedAntModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RedAntRenderer extends RenderLiving {

    // todo finish the texture
    private static final ResourceLocation spiderTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/red_ant.png");

    public RedAntRenderer() {
        super(new RedAntModel(), 0.5F);
        this.setRenderPassModel(new RedAntModel());
    }

    protected float getDeathMaxRotation() {
        return 180.0F;
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(RedAntInstance p_77032_1_, int p_77032_2_) {
        if (p_77032_2_ != 0) {
            return -1;
        } else {
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);

            GL11.glDepthMask(!p_77032_1_.isInvisible());

            char c0 = 61680;
            int j = c0 % 65536;
            int k = 0;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture() {
        return spiderTextures;
    }

    protected float getDeathMaxRotation(EntityLivingBase p_77037_1_) {
        return this.getDeathMaxRotation();
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLivingBase p_77032_1_, int p_77032_2_, float p_77032_3_) {
        return this.shouldRenderPass((RedAntInstance) p_77032_1_, p_77032_2_);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture();
    }
}
