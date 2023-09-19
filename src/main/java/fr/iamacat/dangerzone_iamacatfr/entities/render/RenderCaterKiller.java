
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CaterKillerInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelCaterKiller;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderCaterKiller extends RenderLiving {

    protected ModelCaterKiller model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderCaterKiller(final ModelCaterKiller par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelCaterKiller) this.mainModel;
        this.scale = par3;
    }

    public void renderCaterKiller(final CaterKillerInstance par1EntityCaterKiller, final double par2, final double par4,
                                  final double par6, final float par8, final float par9) {
        super.doRender(par1EntityCaterKiller, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderCaterKiller((CaterKillerInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderCaterKiller((CaterKillerInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final CaterKillerInstance par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.getPlayNicely() != 0) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((CaterKillerInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderCaterKiller.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":CaterKillertexture.png");
    }
}
