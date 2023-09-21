
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.AppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.CrystalCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EnchantedGoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;


public class EnchantedGoldenAppleCowRenderer extends RenderLiving {

    protected ModelCow model;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;

    public EnchantedGoldenAppleCowRenderer(final ModelCow par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        this.model = (ModelCow) this.mainModel;
    }

    public void renderEnchantedCow(final EnchantedGoldenAppleCowInstance par1EntityEnchantedCow, final double par2, final double par4,
                                   final double par6, final float par8, final float par9) {
        super.doRender(par1EntityEnchantedCow, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderEnchantedCow((EnchantedGoldenAppleCowInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderEnchantedCow((EnchantedGoldenAppleCowInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    public int shouldRenderPass(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        if (par1EntityLiving instanceof EnchantedGoldenAppleCowInstance && par2 == 3) {
            this.setRenderPassModel((ModelBase) this.model);
            GL11.glColor3f(1.0f, 1.0f, 1.0f);
            return 31;
        }
        return -1;
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        if (entity instanceof EnchantedGoldenAppleCowInstance) {
            return EnchantedGoldenAppleCowRenderer.texture2;
        }
        if (entity instanceof GoldenAppleCowInstance) {
            return EnchantedGoldenAppleCowRenderer.texture2;
        }
        if (entity instanceof CrystalCowInstance) {
            return EnchantedGoldenAppleCowRenderer.texture3;
        }
        return EnchantedGoldenAppleCowRenderer.texture1;
    }

    static {
        texture3 = new ResourceLocation(Tags.MODID + ":textures/entity/crystal_cow.png");
        texture1 = new ResourceLocation(Tags.MODID + ":textures/entity/red_cow.png");
        texture2 = new ResourceLocation(Tags.MODID + ":textures/entity/enchanted_golden_apple_cow.png");
    }
}
