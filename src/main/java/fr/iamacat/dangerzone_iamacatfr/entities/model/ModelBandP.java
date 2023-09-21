
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.BandP;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBandP extends ModelBase {

    private float wingspeed;
    ModelRenderer belly;
    ModelRenderer chest;
    ModelRenderer head;
    ModelRenderer lleg;
    ModelRenderer rleg;
    ModelRenderer larm;
    ModelRenderer rarm;

    public ModelBandP(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 128;
        (this.belly = new ModelRenderer((ModelBase) this, 0, 61)).addBox(-8.0f, -5.0f, -7.0f, 16, 10, 16);
        this.belly.setRotationPoint(0.0f, 12.0f, 0.0f);
        this.belly.setTextureSize(64, 32);
        this.belly.mirror = true;
        this.setRotation(this.belly, 0.0698132f, 0.0f, 0.0f);
        (this.chest = new ModelRenderer((ModelBase) this, 0, 42)).addBox(-5.0f, -3.0f, -5.0f, 10, 6, 10);
        this.chest.setRotationPoint(0.0f, 5.0f, 2.0f);
        this.chest.setTextureSize(64, 32);
        this.chest.mirror = true;
        this.setRotation(this.chest, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 11)).addBox(-3.0f, -5.0f, -3.0f, 6, 6, 6);
        this.head.setRotationPoint(0.0f, 1.0f, 3.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.lleg = new ModelRenderer((ModelBase) this, 25, 90)).addBox(-2.0f, 0.0f, -3.0f, 6, 8, 6);
        this.lleg.setRotationPoint(2.0f, 16.0f, 2.0f);
        this.lleg.setTextureSize(64, 32);
        this.lleg.mirror = true;
        this.setRotation(this.lleg, 0.0f, 0.0f, 0.0f);
        (this.rleg = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-4.0f, 0.0f, -3.0f, 6, 8, 6);
        this.rleg.setRotationPoint(-2.0f, 16.0f, 2.0f);
        this.rleg.setTextureSize(64, 32);
        this.rleg.mirror = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
        (this.larm = new ModelRenderer((ModelBase) this, 0, 25)).addBox(-1.0f, -1.0f, -2.0f, 4, 10, 4);
        this.larm.setRotationPoint(6.0f, 4.0f, 3.0f);
        this.larm.setTextureSize(64, 32);
        this.larm.mirror = true;
        this.setRotation(this.larm, 0.0f, 0.0f, -0.4886922f);
        (this.rarm = new ModelRenderer((ModelBase) this, 18, 25)).addBox(-3.0f, -1.0f, -2.0f, 4, 10, 4);
        this.rarm.setRotationPoint(-6.0f, 4.0f, 3.0f);
        this.rarm.setTextureSize(64, 32);
        this.rarm.mirror = true;
        this.setRotation(this.rarm, 0.0f, 0.0f, 0.4886922f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final BandP e = (BandP) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        float newangle3 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
            newangle2 = MathHelper.cos(f2 * 2.6f * this.wingspeed) * 3.1415927f * 0.025f * f1;
            newangle3 = newangle;
        } else {
            newangle = 0.0f;
            newangle2 = MathHelper.cos(f2 * 0.6f * this.wingspeed) * 3.1415927f * 0.005f;
            newangle3 = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.02f;
        }
        this.lleg.rotateAngleX = newangle;
        this.rleg.rotateAngleX = -newangle;
        this.belly.rotateAngleX = 0.07f + newangle2;
        this.larm.rotateAngleX = -newangle3;
        this.rarm.rotateAngleX = newangle3;
        this.belly.rotateAngleY = -newangle / 2.0f;
        this.head.rotateAngleY = (float) Math.toRadians(f3);
        this.head.rotateAngleX = (float) Math.toRadians(f4);
        this.belly.render(f5);
        this.chest.render(f5);
        this.head.render(f5);
        this.lleg.render(f5);
        this.rleg.render(f5);
        this.larm.render(f5);
        this.rarm.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4,
        final float par5, final float par6, final Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);
    }
}
