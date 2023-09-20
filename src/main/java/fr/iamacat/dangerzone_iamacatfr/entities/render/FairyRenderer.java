package fr.iamacat.dangerzone_iamacatfr.entities.render;

import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.FairyModel;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import org.lwjgl.opengl.GL11;

import java.util.Map;

@SideOnly(Side.CLIENT)
public class FairyRenderer extends RenderLiving {

    protected FairyModel model;
    private float scale;

    public FairyRenderer(final FairyModel par1ModelBase, final float par2, final float par3) {
        super((ModelBase) par1ModelBase, par2 * par3);
        this.scale = 1.0f;
        this.model = (FairyModel) this.mainModel;
        this.scale = par3;
    }

    public void renderFairy(final FairyInstance par1EntityFairy, final double par2, final double par4, final double par6,
                            final float par8, final float par9) {
        super.doRender(par1EntityFairy, par2, par4, par6, par8, par9);
    }

    public void doRender(final EntityLiving par1EntityLiving, final double par2, final double par4, final double par6,
                         final float par8, final float par9) {
        this.renderFairy((FairyInstance) par1EntityLiving, par2, par4, par6, par8, par9);
    }

    public void doRender(final Entity par1Entity, final double par2, final double par4, final double par6,
                         final float par8, final float par9) {
        this.renderFairy((FairyInstance) par1Entity, par2, par4, par6, par8, par9);
    }

    protected void preRenderScale(final FairyInstance par1Entity, final float par2) {
        GL11.glScalef(this.scale, this.scale, this.scale);
    }

    protected void preRenderCallback(final EntityLivingBase par1EntityLiving, final float par2) {
        this.preRenderScale((FairyInstance) par1EntityLiving, par2);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        final FairyInstance a = (FairyInstance) entity;
        return a.getTexture(a);
    }
}
