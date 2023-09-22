
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.MassoInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class MassoRenderer extends RenderLiving {

    private static final ResourceLocation skin;

    public MassoRenderer(final ModelBase modelbase, final float shadowSize) {
        super(modelbase, shadowSize);
    }

    public void func_177_a(final MassoInstance entityMasso, final double d, final double d1, final double d2,
        final float f, final float f1) {
        super.doRender(entityMasso, d, d1, d2, f, f1);
    }

    public void doRenderLiving(final EntityLivingBase entityliving, final double d, final double d1, final double d2,
        final float f, final float f1) {
        this.func_177_a((MassoInstance) entityliving, d, d1, d2, f, f1);
    }

    public void doRender(final Entity entity, final double d, final double d1, final double d2, final float f,
        final float f1) {
        this.func_177_a((MassoInstance) entity, d, d1, d2, f, f1);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return MassoRenderer.skin;
    }

    static {
        skin = new ResourceLocation(Tags.MODID, "textures/entity/Masso.png");
    }
}
