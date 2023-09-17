

package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.BaryonyxInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class BaryonyxRenderer extends RenderLiving
{
    private float scale;
    private static final ResourceLocation skin;

    protected void preRenderScale(final BaryonyxInstance par1EntityBaryonyx, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    public BaryonyxRenderer(final ModelBase par1ModelBase, final float par2, final float par3) {
        super(par1ModelBase, par2 * par3);
        this.scale = par3;
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLivingBase, final float par2) {
        this.preRenderScale((BaryonyxInstance)par1EntityLivingBase, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return BaryonyxRenderer.skin;
    }

    static {
        skin = new ResourceLocation(Tags.MODID, "textures/entity/Bary.png");
    }
}
