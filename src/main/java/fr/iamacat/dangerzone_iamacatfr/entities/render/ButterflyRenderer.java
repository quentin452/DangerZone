package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.ButterflyInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class ButterflyRenderer extends RenderLiving {

    private static final ResourceLocation beigeTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_beige.png");
    private static final ResourceLocation blueTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_blue.png");
    private static final ResourceLocation glassTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_glass.png");
    private static final ResourceLocation limeTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_lime.png");
    private static final ResourceLocation orangeTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_orange.png");
    private static final ResourceLocation purpleTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_purple.png");
    private static final ResourceLocation redTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_red.png");
    private static final ResourceLocation whiteTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_white.png");
    private static final ResourceLocation yellowTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_yellow.png");
    private static final ResourceLocation cyanTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_cyan.png");
    private static final ResourceLocation brownTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_brown.png");
    private static final ResourceLocation blackTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_black.png");
    private static final ResourceLocation greenTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_green.png");
    private static final ResourceLocation grayTextures = new ResourceLocation(
        Tags.MODID + ":textures/entity/butterfly/butterfly_gray.png");

    public ButterflyRenderer(ModelBase p_i1265_1_, float p_i1265_2_) {
        super(p_i1265_1_, p_i1265_2_);
        this.shadowSize = 0.2F;
    }

    protected ResourceLocation getEntityTexture(ButterflyInstance entity) {
        switch (entity.getDataWatcher()
            .getWatchableObjectInt(20)) {
            case 0:
                return beigeTextures;
            case 1:
                return blueTextures;
            case 2:
                return glassTextures;
            case 3:
                return limeTextures;
            case 4:
                return purpleTextures;
            case 5:
                return redTextures;
            case 6:
                return whiteTextures;
            case 7:
                return yellowTextures;
            case 8:
                return cyanTextures;
            case 9:
                return brownTextures;
            case 10:
                return blackTextures;
            case 11:
                return greenTextures;
            case 12:
                return grayTextures;
            default:
                return orangeTextures;
        }
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return this.getEntityTexture((ButterflyInstance) entity);
    }
}
