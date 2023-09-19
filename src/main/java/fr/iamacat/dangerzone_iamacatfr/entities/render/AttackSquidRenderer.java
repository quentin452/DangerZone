
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.AttackSquidInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AttackSquidModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class AttackSquidRenderer extends RenderLiving {

    protected AttackSquidModel model;
    private float scale;
    private static final ResourceLocation texture;

    public AttackSquidRenderer(final AttackSquidModel par1ModelBase, final float par2, final float par3) {
        super(par1ModelBase, par2 * par3);
        this.model = (AttackSquidModel) this.mainModel;
        this.scale = par3;
    }

    public void renderAttackSquid(final AttackSquidInstance par1EntityAttackSquid, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityAttackSquid, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAttackSquid((AttackSquidInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderAttackSquid((AttackSquidInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final AttackSquidInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((AttackSquidInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return AttackSquidRenderer.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":AttackSquid.png");
    }
}
