
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class GenericLivingRenderer extends RenderLiving implements WrapperRenderer {

    public final ResourceLocation livingTexture;

    public GenericLivingRenderer(final ModelBase modelBase, final float shadowSize,
                                 final ResourceLocation livingTexture) {
        super(modelBase, shadowSize);
        this.livingTexture = livingTexture;
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return this.livingTexture;
    }

    public Render getRender() {
        return (Render) this;
    }
}
