
package danger.orespawn.entities.renderer;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.Dragon;
import danger.orespawn.entities.model.ModelDragon;

public class RenderDragon extends RenderLiving {

    protected ModelDragon model;
    private float scale;
    private static final ResourceLocation texture;
    private static final ResourceLocation texture2;

    public RenderDragon(final ModelDragon par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (ModelDragon) this.mainModel;
        this.scale = par3;
    }

    public void renderDragon(final Dragon par1EntityDragon, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        super.doRender(par1EntityDragon, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderDragon((Dragon) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
        final float par8, final float par9) {
        this.renderDragon((Dragon) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final Dragon par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((Dragon) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final Dragon d = (Dragon) entity;
        if (d.getDragonType() != 0) {
            return RenderDragon.texture2;
        }
        return RenderDragon.texture;
    }

    static {
        texture = new ResourceLocation("orespawn", "Dragon.png");
        texture2 = new ResourceLocation("orespawn", "WhiteDragon.png");
    }
}
