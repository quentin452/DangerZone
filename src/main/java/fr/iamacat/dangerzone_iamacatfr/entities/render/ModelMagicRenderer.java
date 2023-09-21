
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.PowerOrbsInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.MagicModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ModelMagicRenderer extends RenderLiving {

    protected MagicModel model;
    private float scale;
    private static final ResourceLocation m;
    private static final ResourceLocation m2;
    private static final ResourceLocation m3;
    private static final ResourceLocation m4;
    private static final ResourceLocation m10;

    public ModelMagicRenderer(final MagicModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (MagicModel) this.mainModel;
        this.scale = par3;
    }

    public void renderMyPowerOrbs(final PowerOrbsInstance par1EntityMyPowerOrbs, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityMyPowerOrbs, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderMyPowerOrbs((PowerOrbsInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final PowerOrbsInstance par1Entity, final float par2) {
        float localscale = this.scale;
        if (par1Entity.getPurpleType() != 0) {
            localscale = 0.55f;
        }
        GL11.glScalef(localscale, localscale, localscale);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final PowerOrbsInstance p = (PowerOrbsInstance) entity;
        final int i = p.getPurpleType();
        if (i == 1) {
            return ModelMagicRenderer.m2;
        }
        if (i == 2) {
            return ModelMagicRenderer.m3;
        }
        if (i == 3) {
            return ModelMagicRenderer.m4;
        }
        if (i == 10) {
            return ModelMagicRenderer.m10;
        }
        return ModelMagicRenderer.m;
    }

    static {
        m = new ResourceLocation(Tags.MODID+":Magic1.png");
        m2 = new ResourceLocation(Tags.MODID+":");
        m3 = new ResourceLocation(Tags.MODID+":");
        m4 = new ResourceLocation(Tags.MODID+":");
        m10 = new ResourceLocation(Tags.MODID+":");
    }
}
