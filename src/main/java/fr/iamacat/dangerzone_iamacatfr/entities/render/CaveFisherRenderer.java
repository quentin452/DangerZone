package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.model.CaveFisherModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class CaveFisherRenderer extends RenderLiving {

    private static final ResourceLocation caveFisherTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/CaveFisher.png");
    protected CaveFisherModel model;

    public CaveFisherRenderer(CaveFisherModel modelCF, float f) {
        super(modelCF, f);
        model = (CaveFisherModel) mainModel;
    }

    public void renderCaveFisher(CaveFisherInstance entity, double par2, double par4, double par6, float par8,
        float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1, double par2, double par4, double par6, float par8, float par9) {
        renderCaveFisher((CaveFisherInstance) par1, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1, double par2, double par4, double par6, float par8, float par9) {
        renderCaveFisher((CaveFisherInstance) par1, par2, par4, par6, par8, par9);
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return caveFisherTextures;
    }
}
