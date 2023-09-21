package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.TermiteInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.TermiteModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class TermiteRenderer  extends RenderLiving {

    protected TermiteModel model;
    private float scale;

    public TermiteRenderer(final TermiteModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 0.25f;
        this.model = (TermiteModel) this.mainModel;
        this.scale = par3;
    }

    public void renderAnt(final TermiteInstance par1EntityAnt, final double par2, final double par4, final double par6,
                          final float par8, final float par9) {
        super.doRender(par1EntityAnt, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
                         final float par8, final float par9) {
        this.renderAnt((TermiteInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
                         final float par8, final float par9) {
        this.renderAnt((TermiteInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final TermiteInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((TermiteInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final TermiteInstance a = (TermiteInstance) entity;
        return a.getTexture(a);
    }
}
