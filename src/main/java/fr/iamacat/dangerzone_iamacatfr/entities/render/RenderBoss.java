package fr.iamacat.dangerzone_iamacatfr.entities.render;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.TragicBoss;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.BossStatus;
import org.lwjgl.opengl.GL11;

public abstract class RenderBoss extends RenderLiving {

	protected float scale;

	public RenderBoss(ModelBase model, float shadowSize, float scale) {
		super(model, shadowSize);
		this.scale = scale;
	}

	public RenderBoss(ModelBase model, float shadowSize) {
		this(model, shadowSize, 1.0F);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase entity, float par2)
	{
		GL11.glScalef(scale, scale, scale);
	}

	public void doRender(TragicBoss boss, double par2, double par4, double par6, float par8, float par9)
	{
		BossStatus.setBossStatus(boss, true);
		super.doRender(boss, par2, par4, par6, par8, par9);
	}

	@Override
	public void doRender(EntityLiving entity, double par2, double par4, double par6, float par8, float par9)
	{
		this.doRender((TragicBoss)entity, par2, par4, par6, par8, par9);
	}

}
