
package danger.orespawn.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.ThePrincess;
import danger.orespawn.entities.model.ModelThePrincess;

public class RenderThePrincess extends RenderLiving {

    protected ModelThePrincess model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;

    public RenderThePrincess(final ModelThePrincess par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelThePrincess) this.mainModel;
        this.scale = par3;
    }

    public void renderThePrincess(final ThePrincess par1EntityThePrincess, final double par2, final double par4,
        final double par6, final float par8, final float par9) {
        super.doRender(par1EntityThePrincess, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderThePrincess((ThePrincess) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderThePrincess((ThePrincess) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final ThePrincess par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((ThePrincess) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final ThePrincess t = (ThePrincess) entity;
        if (t.getAttacking() != 0) {
            return RenderThePrincess.texture2;
        }
        return RenderThePrincess.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "ThePrincesstexture.png");
        texture2 = new ResourceLocation("orespawn", "ThePrincesstexture2.png");
    }
}
