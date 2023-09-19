package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AlosaurusInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AlosaurusModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class AlosaurusRenderer extends RenderLiving {

    private static final ResourceLocation cockatriceTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/Alosaurus.png");
    protected AlosaurusModel model;

    public AlosaurusRenderer(AlosaurusModel modelC, float f) {
        super(modelC, f);
        model = (AlosaurusModel) mainModel;
    }

    public void renderCockatrice(AlosaurusInstance entity, double par2, double par4, double par6, float par8,
        float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1, double par2, double par4, double par6, float par8, float par9) {
        renderCockatrice((AlosaurusInstance) par1, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1, double par2, double par4, double par6, float par8, float par9) {
        renderCockatrice((AlosaurusInstance) par1, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return cockatriceTextures;
    }
}
