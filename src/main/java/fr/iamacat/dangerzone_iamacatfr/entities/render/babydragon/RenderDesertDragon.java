

package fr.iamacat.dangerzone_iamacatfr.entities.render.babydragon;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBirchDragon;
import fr.iamacat.dangerzone_iamacatfr.entities.model.babydragon.ModelTinyDragon;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderDesertDragon extends RenderLiving
{
    private static final ResourceLocation texture;
    private ModelBase scaleAmount;

    public RenderDesertDragon() {
        super((ModelBase)new ModelTinyDragon(), 0.55f);
    }

    public RenderDesertDragon(final ModelBase p_i1267_1_, final ModelBase p_i1267_2_, final float p_i1267_3_) {
        super(p_i1267_1_, p_i1267_3_);
        this.scaleAmount = p_i1267_2_;
    }

    protected int shouldRenderPass(final EntityBirchDragon p_77032_1_, final int p_77032_2_, final float p_77032_3_) {
        if (p_77032_1_.isInvisible()) {
            return 0;
        }
        if (p_77032_2_ == 0) {
            this.setRenderPassModel(this.scaleAmount);
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            return 1;
        }
        if (p_77032_2_ == 1) {
            GL11.glDisable(3042);
            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        }
        return -1;
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderDesertDragon.texture;
    }

    protected void preRenderCallback(final EntityLivingBase p_77041_1_, final float p_77041_2_) {
        final float scale = 1.0f;
        GL11.glScalef(scale, scale, scale);
    }

    static {
        texture = new ResourceLocation(Tags.MODID +":textures/entity/babydragon/desert.png");
    }
}
