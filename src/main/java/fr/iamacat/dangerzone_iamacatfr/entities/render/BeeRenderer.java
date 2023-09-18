package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import fr.iamacat.dangerzone_iamacatfr.entities.model.BeeModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class BeeRenderer extends RenderBoss {

    private static final ResourceLocation texture = new ResourceLocation(Tags.MODID + ":textures/entity/BeeNWasp.png");

    public BeeRenderer() {
        super(new BeeModel(), 0.725F, 2.55F);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity) {
        return texture;
    }

}
