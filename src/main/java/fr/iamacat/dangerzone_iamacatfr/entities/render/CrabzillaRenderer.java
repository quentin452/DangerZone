package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CrabzillaInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.CrabzillaModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CrabzillaRenderer extends RenderLiving {

    protected CrabzillaModel model;
    private final float scale;
    private static final ResourceLocation texturecrab;

    public CrabzillaRenderer(final CrabzillaModel par1ModelBase, final float par2, final float par3) {
        super(par1ModelBase, par2 * par3);
        this.model = (CrabzillaModel) this.mainModel;
        this.scale = par3;
    }

    public void renderMyCrabzilla(final CrabzillaInstance par1EntityMyCrabzilla, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityMyCrabzilla, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderMyCrabzilla((CrabzillaInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderMyCrabzilla((CrabzillaInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final CrabzillaInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((CrabzillaInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return CrabzillaRenderer.texturecrab;
    }

    static {
        texturecrab = new ResourceLocation(Tags.MODID + ":" + "textures/entity/crabzilla.png");
    }
}
