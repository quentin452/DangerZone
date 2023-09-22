package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import fr.iamacat.dangerzone_iamacatfr.entities.model.EyeRayModel;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EyeRayRenderer extends RenderLiving {

    protected EyeRayModel model;

    public EyeRayRenderer(EyeRayModel modelER, float f) {
        super(modelER, f);
        model = (EyeRayModel) mainModel;
    }

    public void renderEyeRay(EyeRayInstance entity, double par2, double par4, double par6, float par8, float par9) {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1, double par2, double par4, double par6, float par8, float par9) {
        renderEyeRay((EyeRayInstance) par1, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1, double par2, double par4, double par6, float par8, float par9) {
        renderEyeRay((EyeRayInstance) par1, par2, par4, par6, par8, par9);
    }

    private static final ResourceLocation eyeRayTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/EyeRay.png");

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return eyeRayTextures;
    }
}
