
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DemonSpiderInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.BlackWidowModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class BlackWidowRenderer extends RenderLiving {

    protected BlackWidowModel model;
    private float scale;
    private static final ResourceLocation texturebw;

    public BlackWidowRenderer(final BlackWidowModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (BlackWidowModel) this.mainModel;
        this.scale = par3;
    }

    public void renderDemonSpiderEntity(final DemonSpiderInstance par1EntityHerculesBeetle, final double par2,
        final double par4, final double par6, final float par8, final float par9) {
        super.doRender(par1EntityHerculesBeetle, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderDemonSpiderEntity((DemonSpiderInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderDemonSpiderEntity((DemonSpiderInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final DemonSpiderInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((DemonSpiderInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return BlackWidowRenderer.texturebw;
    }

    static {
        texturebw = new ResourceLocation(Tags.MODID + ":" + "textures/entity/blackwidow.png");
    }
}
