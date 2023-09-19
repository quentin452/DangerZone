package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.RatInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.RatModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class RatRenderer extends RenderLiving {

    protected RatModel model;

    public RatRenderer(RatModel modelT, float f) {
        super(modelT, f);
        model = (RatModel) mainModel;
    }

    public void renderThoqqua(RatInstance entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1, double par2, double par4, double par6, float par8, float par9) {
        renderThoqqua((RatInstance) par1, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1, double par2, double par4, double par6, float par8, float par9) {
        renderThoqqua((RatInstance) par1, par2, par4, par6, par8, par9);
    }

    private static final ResourceLocation thoqquaTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/Rat.png");

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return thoqquaTextures;
    }
}
