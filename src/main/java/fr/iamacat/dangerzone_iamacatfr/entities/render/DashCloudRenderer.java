
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DashCloudInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.DashCloudModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class DashCloudRenderer extends RenderLiving {

    protected DashCloudModel model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texturedashcl;

    public DashCloudRenderer(final DashCloudModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (DashCloudModel) this.mainModel;
        this.scale = par3;
    }

    public void renderButterfly(final DashCloudInstance par1MyDashCloud, final double par2, final double par4,
                                final double par6, final float par8, final float par9) {
        super.doRender( par1MyDashCloud, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderButterfly((DashCloudInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderButterfly((DashCloudInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final DashCloudInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((DashCloudInstance) par1EntityLiving, par2);
    }

    public int shouldRenderPass(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        int doit = 0;
        if (par1EntityLiving instanceof DashCloudInstance) {
            ++doit;
        }
        if (doit != 0) {
            GL11.glDepthMask(true);
            if (par2 == 1) {
                final float var4 = par1EntityLiving.ticksExisted + par3;
                this.bindTexture(DashCloudRenderer.texture);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                final float var5 = var4 * 0.06f;
                final float var6 = var4 * 0.06f;
                GL11.glTranslatef(var5, var6, 0.0f);
                this.setRenderPassModel((ModelBase) this.model);
                GL11.glMatrixMode(5888);
                GL11.glEnable(3042);
                final float var7 = 0.5f;
                GL11.glColor4f(var7, var7, var7, 1.0f);
                GL11.glDisable(2896);
                GL11.glBlendFunc(1, 1);
                return 1;
            }
            if (par2 == 2) {
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(5888);
                GL11.glEnable(2896);
                GL11.glDisable(3042);
            }
        }
        return -1;
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final DashCloudInstance a = (DashCloudInstance) entity;
        return DashCloudRenderer.texturedashcl;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/dashcloudlayer.png");
        texturedashcl = new ResourceLocation(Tags.MODID + ":" + "textures/entity/dashcloud.png");
    }
}
