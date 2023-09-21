
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityButterfly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityLunaMoth;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Mothra;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelButterfly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderButterfly extends RenderLiving {

    protected ModelButterfly model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderButterfly(final ModelButterfly par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelButterfly) this.mainModel;
        this.scale = par3;
    }

    public void renderButterfly(final EntityButterfly par1EntityButterfly, final double par2, final double par4,
                                final double par6, final float par8, final float par9) {
        super.doRender(par1EntityButterfly, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderButterfly((EntityButterfly) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderButterfly((EntityButterfly) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final EntityButterfly par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((EntityButterfly) par1EntityLiving, par2);
    }

    public int shouldRenderPass(final EntityLivingBase par1EntityLiving, final int par2, final float par3) {
        int doit = 0;
        if (par1EntityLiving instanceof Mothra) {
            ++doit;
        } else if (par1EntityLiving instanceof EntityLunaMoth) {
            final EntityLunaMoth e = (EntityLunaMoth) par1EntityLiving;
            if (e.moth_type == 0) {
                ++doit;
            }
        }
        if (doit != 0) {
            GL11.glDepthMask(true);
            if (par2 == 1) {
                final float var4 = par1EntityLiving.ticksExisted + par3;
                this.bindTexture(RenderButterfly.texture);
                GL11.glMatrixMode(5890);
                GL11.glLoadIdentity();
                final float var5 = var4 * 0.01f;
                final float var6 = var4 * 0.01f;
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
        final EntityButterfly a = (EntityButterfly) entity;
        return a.getTexture(a);
    }

    static {
        texture = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    }
}
