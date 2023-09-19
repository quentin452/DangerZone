package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class GhostRenderer extends RenderLiving {

    public static ResourceLocation texture;

    public GhostRenderer(final ModelBase par1ModelBase, final float par2) {
        super(par1ModelBase, par2);
        GhostRenderer.texture = new ResourceLocation(Tags.MODID + ":textures/entity/ghost1.png");
    }

    protected ResourceLocation getEntityTexture(final Entity par1Entity) {
        return GhostRenderer.texture;
    }
}
