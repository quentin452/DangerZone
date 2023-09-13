package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;

public class EnchantedGoldenAppleCowRenderer extends RenderLiving {

    public EnchantedGoldenAppleCowRenderer(ModelBase p_i1253_1_, float p_i1253_2_) {
        super(p_i1253_1_, p_i1253_2_);
    }

    protected ResourceLocation getEntityTexture(EntityCow entity) {
        return new ResourceLocation(Tags.MODID, "textures/entity/enchanted_golden_apple_cow.png");
    }

    protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
        return this.getEntityTexture((EntityCow) p_110775_1_);
    }
}
