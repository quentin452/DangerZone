
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyMavis;

public class Mavis extends ModelBase {

    private float wingspeed;
    ModelRenderer Chest;
    ModelRenderer Belly;
    ModelRenderer Body;
    ModelRenderer BodyOut;
    ModelRenderer SkinnyLegL;
    ModelRenderer SkinnylegR;
    ModelRenderer LegL;
    ModelRenderer LegR;
    ModelRenderer ShoeR;
    ModelRenderer ShoeL;
    ModelRenderer SkinnyArmL;
    ModelRenderer SkinnyArmR;
    ModelRenderer Arm2L;
    ModelRenderer Arm2R;
    ModelRenderer Arm1L;
    ModelRenderer Arm1R;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Breast;
    ModelRenderer HairTop;
    ModelRenderer HairR;
    ModelRenderer HairL;
    ModelRenderer HearB;

    public Mavis() {
        this.wingspeed = 0.8f;
        this.textureWidth = 1024;
        this.textureHeight = 1024;
        (this.Chest = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 6);
        this.Chest.setRotationPoint(-3.0f, -14.0f, -1.0f);
        this.Chest.setTextureSize(1024, 1024);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 0.0f, 0.0f, 0.0f);
        (this.Belly = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 5, 5);
        this.Belly.setRotationPoint(-2.0f, -7.0f, -0.5f);
        this.Belly.setTextureSize(1024, 1024);
        this.Belly.mirror = true;
        this.setRotation(this.Belly, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 8, 6);
        this.Body.setRotationPoint(-2.5f, -3.0f, -1.0f);
        this.Body.setTextureSize(1024, 1024);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.BodyOut = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 5, 7);
        this.BodyOut.setRotationPoint(-3.0f, -1.0f, -1.5f);
        this.BodyOut.setTextureSize(1024, 1024);
        this.BodyOut.mirror = true;
        this.setRotation(this.BodyOut, 0.0f, 0.0f, 0.0f);
        (this.SkinnyLegL = new ModelRenderer((ModelBase) this, 0, 60)).addBox(0.0f, 0.0f, 0.0f, 3, 9, 4);
        this.SkinnyLegL.setRotationPoint(2.0f, 5.0f, 0.0f);
        this.SkinnyLegL.setTextureSize(1024, 1024);
        this.SkinnyLegL.mirror = true;
        this.setRotation(this.SkinnyLegL, 0.0f, 0.0f, 0.0f);
        (this.SkinnylegR = new ModelRenderer((ModelBase) this, 0, 60)).addBox(0.0f, 0.0f, 0.0f, 3, 9, 3);
        this.SkinnylegR.setRotationPoint(-3.0f, 5.0f, 0.0f);
        this.SkinnylegR.setTextureSize(1024, 1024);
        this.SkinnylegR.mirror = true;
        this.setRotation(this.SkinnylegR, 0.0f, 0.0f, 0.0f);
        (this.LegL = new ModelRenderer((ModelBase) this, 0, 80)).addBox(0.0f, 8.0f, 0.0f, 2, 8, 3);
        this.LegL.setRotationPoint(2.5f, 5.0f, 0.0f);
        this.LegL.setTextureSize(1024, 1024);
        this.LegL.mirror = true;
        this.setRotation(this.LegL, 0.1047198f, 0.0f, 0.0f);
        (this.LegR = new ModelRenderer((ModelBase) this, 0, 80)).addBox(0.0f, 8.0f, 0.0f, 2, 8, 3);
        this.LegR.setRotationPoint(-2.5f, 5.0f, 0.0f);
        this.LegR.setTextureSize(1024, 1024);
        this.LegR.mirror = true;
        this.setRotation(this.LegR, 0.0f, 0.0f, 0.0f);
        (this.ShoeR = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 16.0f, 0.0f, 4, 2, 3);
        this.ShoeR.setRotationPoint(-3.5f, 5.0f, -1.0f);
        this.ShoeR.setTextureSize(1024, 1024);
        this.ShoeR.mirror = true;
        this.setRotation(this.ShoeR, 0.0f, 0.0f, 0.0f);
        (this.ShoeL = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 16.0f, 0.0f, 4, 2, 3);
        this.ShoeL.setRotationPoint(1.5f, 5.0f, 0.0f);
        this.ShoeL.setTextureSize(1024, 1024);
        this.ShoeL.mirror = true;
        this.setRotation(this.ShoeL, 0.1047198f, 0.0f, 0.0f);
        (this.SkinnyArmL = new ModelRenderer((ModelBase) this, 30, 30)).addBox(0.0f, 0.0f, 0.0f, 2, 10, 2);
        this.SkinnyArmL.setRotationPoint(4.3f, -13.0f, 1.0f);
        this.SkinnyArmL.setTextureSize(1024, 1024);
        this.SkinnyArmL.mirror = true;
        this.setRotation(this.SkinnyArmL, 0.0f, 0.0f, -0.260246f);
        (this.SkinnyArmR = new ModelRenderer((ModelBase) this, 30, 30)).addBox(0.0f, 0.0f, 0.0f, 2, 10, 2);
        this.SkinnyArmR.setRotationPoint(-4.7f, -13.0f, 1.0f);
        this.SkinnyArmR.setTextureSize(1024, 1024);
        this.SkinnyArmR.mirror = true;
        this.setRotation(this.SkinnyArmR, 0.0f, 0.0f, 0.2602503f);
        (this.Arm2L = new ModelRenderer((ModelBase) this, 30, 50)).addBox(0.0f, -1.0f, 0.0f, 2, 8, 1);
        this.Arm2L.setRotationPoint(7.0f, -3.0f, 2.0f);
        this.Arm2L.setTextureSize(1024, 1024);
        this.Arm2L.mirror = true;
        this.setRotation(this.Arm2L, -1.041001f, 0.0f, 0.0f);
        (this.Arm2R = new ModelRenderer((ModelBase) this, 30, 50)).addBox(0.0f, -1.0f, 0.0f, 2, 8, 1);
        this.Arm2R.setRotationPoint(-7.0f, -3.0f, 2.0f);
        this.Arm2R.setTextureSize(1024, 1024);
        this.Arm2R.mirror = true;
        this.setRotation(this.Arm2R, -1.041001f, 0.0f, 0.0f);
        (this.Arm1L = new ModelRenderer((ModelBase) this, 30, 50)).addBox(0.0f, -0.5f, 0.0f, 2, 8, 1);
        this.Arm1L.setRotationPoint(7.0f, -3.6f, 2.0f);
        this.Arm1L.setTextureSize(1024, 1024);
        this.Arm1L.mirror = true;
        this.setRotation(this.Arm1L, -0.9599311f, 0.0f, 0.0f);
        (this.Arm1R = new ModelRenderer((ModelBase) this, 30, 50)).addBox(0.0f, -0.5f, 0.0f, 2, 8, 1);
        this.Arm1R.setRotationPoint(-7.0f, -3.6f, 2.0f);
        this.Arm1R.setTextureSize(1024, 1024);
        this.Arm1R.mirror = true;
        this.setRotation(this.Arm1R, -0.9599311f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 0, 18)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 2);
        this.Neck.setRotationPoint(0.0f, -17.0f, 1.0f);
        this.Neck.setTextureSize(1024, 1024);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 30)).addBox(0.0f, 0.0f, 0.0f, 8, 7, 7);
        this.Head.setRotationPoint(-2.5f, -24.0f, -2.0f);
        this.Head.setTextureSize(1024, 1024);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Breast = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 4);
        this.Breast.setRotationPoint(-3.0f, -12.0f, -2.0f);
        this.Breast.setTextureSize(1024, 1024);
        this.Breast.mirror = true;
        this.setRotation(this.Breast, 0.2602503f, 0.0f, 0.0f);
        (this.HairTop = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 7);
        this.HairTop.setRotationPoint(-2.5f, -25.0f, -2.0f);
        this.HairTop.setTextureSize(1024, 1024);
        this.HairTop.mirror = true;
        this.setRotation(this.HairTop, 0.0f, 0.0f, 0.0f);
        (this.HairR = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 9, 6);
        this.HairR.setRotationPoint(-3.0f, -24.0f, -1.0f);
        this.HairR.setTextureSize(1024, 1024);
        this.HairR.mirror = true;
        this.setRotation(this.HairR, 0.0f, 0.0f, 0.0f);
        (this.HairL = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 9, 6);
        this.HairL.setRotationPoint(5.0f, -24.0f, -1.0f);
        this.HairL.setTextureSize(1024, 1024);
        this.HairL.mirror = true;
        this.setRotation(this.HairL, 0.0f, 0.0f, 0.0f);
        (this.HearB = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 9, 1);
        this.HearB.setRotationPoint(-3.0f, -24.0f, 5.0f);
        this.HearB.setTextureSize(1024, 1024);
        this.HearB.mirror = true;
        this.setRotation(this.HearB, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final MyMavis e = (MyMavis) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        float newangle3 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        if (f1 > 0.1) {
            newangle2 = MathHelper.cos(f2 * 0.6f * this.wingspeed) * 2.141593f * 0.25f * f1;
        } else {
            newangle2 = 0.0f;
        }
        if (f1 > 0.1) {
            newangle3 = MathHelper.cos(f2 * 0.1f * this.wingspeed) * 1.141593f * 0.25f * f1;
        } else {
            newangle3 = 0.0f;
        }
        this.SkinnyLegL.rotateAngleX = -newangle;
        this.ShoeR.rotateAngleX = newangle;
        this.LegR.rotateAngleX = newangle;
        this.SkinnylegR.rotateAngleX = newangle;
        this.LegL.rotateAngleX = -newangle;
        this.ShoeL.rotateAngleX = -newangle;
        this.Chest.render(f5);
        this.Belly.render(f5);
        this.Body.render(f5);
        this.BodyOut.render(f5);
        this.SkinnyLegL.render(f5);
        this.SkinnylegR.render(f5);
        this.LegL.render(f5);
        this.LegR.render(f5);
        this.ShoeR.render(f5);
        this.ShoeL.render(f5);
        this.SkinnyArmL.render(f5);
        this.SkinnyArmR.render(f5);
        this.Arm2L.render(f5);
        this.Arm2R.render(f5);
        this.Arm1L.render(f5);
        this.Arm1R.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.Breast.render(f5);
        this.HairTop.render(f5);
        this.HairR.render(f5);
        this.HairL.render(f5);
        this.HearB.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4,
        final float par5, final float par6, final Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
    }
}
