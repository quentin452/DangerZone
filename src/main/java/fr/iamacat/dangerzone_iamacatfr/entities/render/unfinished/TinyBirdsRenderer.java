package fr.iamacat.dangerzone_iamacatfr.entities.render.unfinished;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.TinyBirdsInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class TinyBirdsRenderer extends BirdsRenderer {

    final ResourceLocation textureLocSparrow;
    final ResourceLocation textureLocFinch;
    final ResourceLocation textureLocCardinal;
    final ResourceLocation textureLocBluebird;

    public TinyBirdsRenderer(ModelBase par1ModelBase, float par2) {
        super(par1ModelBase, par2, "tinybirdbrown.png");

        textureLocSparrow = new ResourceLocation(Tags.MODID + ":textures/entity/tinybirdbrown.png");
        textureLocFinch = new ResourceLocation(Tags.MODID + ":textures/entity/tinybirdgold.png");
        textureLocCardinal = new ResourceLocation(Tags.MODID + ":textures/entity/tinybirdred.png");
        textureLocBluebird = new ResourceLocation(Tags.MODID + ":textures/entity/tinybirdblue.png");
    }

    /**
     * Return our specific texture
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        if (par1Entity instanceof TinyBirdsInstance) {
            TinyBirdsInstance birdInstance = (TinyBirdsInstance) par1Entity;
            switch (birdInstance.getBirdType()) {
                case 1:
                    return textureLocBluebird;
                case 2:
                    return textureLocCardinal;
                case 3:
                    return textureLocFinch;
                default:
                    return textureLocSparrow;
            }
        }

        // fallback
        return textureLocSparrow;
    }

}
