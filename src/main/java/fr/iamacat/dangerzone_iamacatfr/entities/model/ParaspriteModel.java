
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.ParaspriteInstance;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ParaspriteModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Head;
    ModelRenderer WingL1;
    ModelRenderer Head2;
    ModelRenderer WingL2;
    ModelRenderer WingR1;
    ModelRenderer WingR2;
    ModelRenderer EyeR;
    ModelRenderer EyeL;
    ModelRenderer Leg2;
    ModelRenderer Leg1;
    ModelRenderer Leg3;
    ModelRenderer Leg4;

    public ParaspriteModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Head = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 14, 14, 14);
        this.Head.setRotationPoint(-7.0f, -4.0f, -7.0f);
        this.Head.setTextureSize(128, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.WingL1 = new ModelRenderer((ModelBase) this, 0, 71)).addBox(0.0f, 0.0f, 0.0f, 18, 0, 10);
        this.WingL1.setRotationPoint(7.0f, -3.0f, -5.0f);
        this.WingL1.setTextureSize(128, 128);
        this.WingL1.mirror = true;
        this.setRotation(this.WingL1, 0.0f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(0.0f, 0.0f, 0.0f, 16, 12, 12);
        this.Head2.setRotationPoint(-8.0f, -3.0f, -6.0f);
        this.Head2.setTextureSize(128, 128);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.WingL2 = new ModelRenderer((ModelBase) this, 0, 59)).addBox(0.0f, 0.0f, 0.0f, 18, 0, 10);
        this.WingL2.setRotationPoint(7.0f, -3.0f, -5.0f);
        this.WingL2.setTextureSize(128, 128);
        this.WingL2.mirror = true;
        this.setRotation(this.WingL2, 0.0f, 0.0f, -0.3141593f);
        (this.WingR1 = new ModelRenderer((ModelBase) this, 0, 95)).addBox(-18.0f, 0.0f, 0.0f, 18, 0, 10);
        this.WingR1.setRotationPoint(-7.0f, -3.0f, -5.0f);
        this.WingR1.setTextureSize(128, 128);
        this.WingR1.mirror = true;
        this.setRotation(this.WingR1, 0.0f, 0.0f, 0.0f);
        (this.WingR2 = new ModelRenderer((ModelBase) this, 0, 83)).addBox(-18.0f, 0.0f, 0.0f, 18, 0, 10);
        this.WingR2.setRotationPoint(-7.0f, -3.0f, -5.0f);
        this.WingR2.setTextureSize(128, 128);
        this.WingR2.mirror = true;
        this.setRotation(this.WingR2, 0.0f, 0.0f, 0.3141593f);
        (this.EyeR = new ModelRenderer((ModelBase) this, 80, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 1);
        this.EyeR.setRotationPoint(-7.0f, -2.0f, -8.0f);
        this.EyeR.setTextureSize(128, 128);
        this.EyeR.mirror = true;
        this.setRotation(this.EyeR, 0.0f, 0.0f, 0.0f);
        (this.EyeL = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 1);
        this.EyeL.setRotationPoint(1.0f, -2.0f, -8.0f);
        this.EyeL.setTextureSize(128, 128);
        this.EyeL.mirror = true;
        this.setRotation(this.EyeL, 0.0f, 0.0f, 0.0f);
        (this.Leg2 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(-5.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Leg2.setRotationPoint(3.0f, 11.0f, -3.0f);
        this.Leg2.setTextureSize(128, 128);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, 0.0f, 0.0f);
        (this.Leg1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Leg1.setRotationPoint(1.0f, 11.0f, -3.0f);
        this.Leg1.setTextureSize(128, 128);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0f, 0.0f, 0.0f);
        (this.Leg3 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Leg3.setRotationPoint(2.0f, 11.0f, 3.0f);
        this.Leg3.setTextureSize(128, 128);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0f, 0.0f, 0.0f);
        (this.Leg4 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(-5.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Leg4.setRotationPoint(2.0f, 11.0f, 3.0f);
        this.Leg4.setTextureSize(128, 128);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final ParaspriteInstance e = (ParaspriteInstance) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        this.Leg1.rotateAngleX = newangle;
        this.Leg2.rotateAngleX = -newangle;
        this.Leg3.rotateAngleX = newangle;
        this.Leg4.rotateAngleX = -newangle;
        newangle = MathHelper.cos(f2 * 2.3f * this.wingspeed) * 3.141593f * 0.4f * f1;
        this.WingR1.rotateAngleZ = newangle - 0.4f;
        this.WingR2.rotateAngleZ = newangle - 0.6f;
        this.WingL1.rotateAngleZ = -newangle + 0.4f;
        this.WingL2.rotateAngleZ = -newangle + 0.6f;
        this.Head.render(f5);
        this.WingL1.render(f5);
        this.Head2.render(f5);
        this.WingL2.render(f5);
        this.WingR1.render(f5);
        this.WingR2.render(f5);
        this.EyeR.render(f5);
        this.EyeL.render(f5);
        this.Leg2.render(f5);
        this.Leg1.render(f5);
        this.Leg3.render(f5);
        this.Leg4.render(f5);
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
