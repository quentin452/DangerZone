
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CassowaryInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.ModelCassowary;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
public class RenderCassowary extends RenderLiving {

    protected ModelCassowary model;
    private float scale;
    private static final ResourceLocation texture;

    public RenderCassowary(final ModelCassowary par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelCassowary) this.mainModel;
        this.scale = par3;
    }

    public void renderCassowary(final CassowaryInstance par1EntityCassowary, final double par2, final double par4,
                                final double par6, final float par8, final float par9) {
        super.doRender(par1EntityCassowary, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderCassowary((CassowaryInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderCassowary((CassowaryInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final CassowaryInstance par1Entity, final float par2) {
        if (par1Entity != null && par1Entity.isChild()) {
            GL11.glScalef(this.scale / 2.0f, this.scale / 2.0f, this.scale / 2.0f);
            return;
        }
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((CassowaryInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderCassowary.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID + ":Cassowary.png");
    }
}
