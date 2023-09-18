
package fr.iamacat.dangerzone_iamacatfr.entities.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyRainbowCentipede;
import fr.iamacat.dangerzone_iamacatfr.entities.model.GiantCentipede;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class RenderRainbowCentipede extends RenderLiving {

    protected GiantCentipede model;
    private float scale;
    private static final ResourceLocation texture2;

    public RenderRainbowCentipede(final GiantCentipede par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (GiantCentipede) this.mainModel;
        this.scale = par3;
    }

    public void renderMyRainbowCentipede(final MyRainbowCentipede par1EntityMyRainbowCentipede, final double par2,
        final double par4, final double par6, final float par8, final float par9) {
        super.doRender((EntityLiving) par1EntityMyRainbowCentipede, par2, par4, par6, par8, par9);
    }

    public void doRenderLiving(final EntityLiving par1EntityLiving, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        this.renderMyRainbowCentipede((MyRainbowCentipede) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderMyRainbowCentipede((MyRainbowCentipede) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final MyRainbowCentipede par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((MyRainbowCentipede) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return RenderRainbowCentipede.texture2;
    }

    static {
        texture2 = new ResourceLocation(Tags.MODID + ":" + "textures/entity/giantcentipede.png");
    }
}
