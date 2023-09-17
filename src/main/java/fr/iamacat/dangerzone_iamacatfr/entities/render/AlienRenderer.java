package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AlienInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AlienModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class AlienRenderer extends RenderLiving
{
    protected AlienModel model;

    public AlienRenderer(AlienModel modelL, float f)
    {
        super(modelL, f);
        model = (AlienModel)mainModel;
    }

    public void renderLizalfos(AlienInstance entity, double par2, double par4, double par6, float par8, float par9)
    {
        super.doRender(entity, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(EntityLiving par1, double par2, double par4, double par6, float par8, float par9)
    {
        renderLizalfos((AlienInstance)par1, par2, par4, par6, par8, par9);
    }

    public void doRender(Entity par1, double par2, double par4, double par6, float par8, float par9)
    {
        renderLizalfos((AlienInstance)par1, par2, par4, par6, par8, par9);
    }

    private static final ResourceLocation lizalfosTextures = new ResourceLocation(Tags.MODID + ":textures/entity/Alien.png");

    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return lizalfosTextures;
    }
}
