
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Bee;

public class ModelBee extends ModelBase {

    private float wingspeed;
    ModelRenderer Sting;
    ModelRenderer Abdomnem1;
    ModelRenderer Abdomnem2;
    ModelRenderer Abdomnem3;
    ModelRenderer Abdomnem4;
    ModelRenderer Abdomnem5;
    ModelRenderer MainBody;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer WingRight;
    ModelRenderer WingLeft;
    ModelRenderer RA1;
    ModelRenderer LA1;
    ModelRenderer LA2;
    ModelRenderer RA2;
    ModelRenderer RA3;
    ModelRenderer LA3;
    ModelRenderer LeftPom;
    ModelRenderer RightPom;
    ModelRenderer LeftPincerExtra;
    ModelRenderer LeftPincerMain;
    ModelRenderer RightPincerMain;
    ModelRenderer RightPincerExtra;

    public ModelBee(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.Sting = new ModelRenderer((ModelBase) this, 68, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.Sting.setRotationPoint(0.0f, 16.0f, 1.0f);
        this.Sting.setTextureSize(256, 256);
        this.Sting.mirror = true;
        this.setRotation(this.Sting, -0.7853982f, 0.0f, 0.0f);
        (this.Abdomnem1 = new ModelRenderer((ModelBase) this, 64, 12)).addBox(-2.0f, 0.0f, 0.0f, 4, 8, 4);
        this.Abdomnem1.setRotationPoint(0.0f, 9.0f, 2.0f);
        this.Abdomnem1.setTextureSize(256, 256);
        this.Abdomnem1.mirror = true;
        this.setRotation(this.Abdomnem1, -0.5235988f, 0.0f, 0.0f);
        (this.Abdomnem2 = new ModelRenderer((ModelBase) this, 60, 24)).addBox(-3.0f, 0.0f, 0.0f, 6, 6, 6);
        this.Abdomnem2.setRotationPoint(0.0f, 5.0f, 0.0f);
        this.Abdomnem2.setTextureSize(256, 256);
        this.Abdomnem2.mirror = true;
        this.setRotation(this.Abdomnem2, 0.0f, 0.0f, 0.0f);
        (this.Abdomnem3 = new ModelRenderer((ModelBase) this, 56, 36)).addBox(-4.0f, 0.0f, 0.0f, 8, 7, 8);
        this.Abdomnem3.setRotationPoint(0.0f, 1.0f, -2.0f);
        this.Abdomnem3.setTextureSize(256, 256);
        this.Abdomnem3.mirror = true;
        this.setRotation(this.Abdomnem3, 0.2617994f, 0.0f, 0.0f);
        (this.Abdomnem4 = new ModelRenderer((ModelBase) this, 53, 51)).addBox(-5.0f, 0.0f, 0.0f, 10, 12, 10);
        this.Abdomnem4.setRotationPoint(0.0f, -6.0f, -8.0f);
        this.Abdomnem4.setTextureSize(256, 256);
        this.Abdomnem4.mirror = true;
        this.setRotation(this.Abdomnem4, 0.5934119f, 0.0f, 0.0f);
        (this.Abdomnem5 = new ModelRenderer((ModelBase) this, 48, 73)).addBox(-6.0f, 0.0f, 0.0f, 12, 12, 12);
        this.Abdomnem5.setRotationPoint(0.0f, -6.0f, -15.0f);
        this.Abdomnem5.setTextureSize(256, 256);
        this.Abdomnem5.mirror = true;
        this.setRotation(this.Abdomnem5, 1.099557f, 0.0f, 0.0f);
        (this.MainBody = new ModelRenderer((ModelBase) this, 48, 97)).addBox(-6.0f, 0.0f, -6.0f, 12, 14, 12);
        this.MainBody.setRotationPoint(0.0f, -12.0f, -24.0f);
        this.MainBody.setTextureSize(256, 256);
        this.MainBody.mirror = true;
        this.setRotation(this.MainBody, 1.48353f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 55, 123)).addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8);
        this.Neck.setRotationPoint(0.0f, -12.0f, -23.0f);
        this.Neck.setTextureSize(256, 256);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 51, 139)).addBox(-5.0f, -5.0f, -10.0f, 10, 10, 10);
        this.Head.setRotationPoint(0.0f, -13.0f, -28.0f);
        this.Head.setTextureSize(256, 256);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.2617994f, 0.0f, 0.0f);
        (this.WingRight = new ModelRenderer((ModelBase) this, 0, 91)).addBox(0.0f, 0.0f, 0.0f, 0, 8, 24);
        this.WingRight.setRotationPoint(-4.0f, -14.0f, -15.0f);
        this.WingRight.setTextureSize(256, 256);
        this.WingRight.mirror = true;
        this.setRotation(this.WingRight, -0.7853982f, -0.5235988f, 2.617994f);
        (this.WingLeft = new ModelRenderer((ModelBase) this, 96, 91)).addBox(0.0f, 0.0f, 0.0f, 0, 8, 24);
        this.WingLeft.setRotationPoint(3.0f, -14.0f, -15.0f);
        this.WingLeft.setTextureSize(256, 256);
        this.WingLeft.mirror = true;
        this.setRotation(this.WingLeft, -0.7853982f, 0.5235988f, -2.617994f);
        (this.RA1 = new ModelRenderer((ModelBase) this, 47, 152)).addBox(0.0f, -6.0f, -1.0f, 1, 6, 1);
        this.RA1.setRotationPoint(-3.0f, -17.0f, -31.0f);
        this.RA1.setTextureSize(256, 256);
        this.RA1.mirror = true;
        this.setRotation(this.RA1, 0.2617994f, 0.5235988f, 0.0f);
        (this.LA1 = new ModelRenderer((ModelBase) this, 91, 152)).addBox(0.0f, -6.0f, -1.0f, 1, 6, 1);
        this.LA1.setRotationPoint(2.0f, -17.0f, -32.0f);
        this.LA1.setTextureSize(256, 256);
        this.LA1.mirror = true;
        this.setRotation(this.LA1, 0.2617994f, -0.5235988f, 0.0f);
        (this.LA2 = new ModelRenderer((ModelBase) this, 91, 145)).addBox(0.0f, -11.0f, 0.0f, 1, 6, 1);
        this.LA2.setRotationPoint(2.0f, -17.0f, -32.0f);
        this.LA2.setTextureSize(256, 256);
        this.LA2.mirror = true;
        this.setRotation(this.LA2, 0.4363323f, -0.6108652f, 0.0f);
        (this.RA2 = new ModelRenderer((ModelBase) this, 47, 145)).addBox(0.0f, -11.0f, 0.0f, 1, 6, 1);
        this.RA2.setRotationPoint(-3.0f, -17.0f, -31.0f);
        this.RA2.setTextureSize(256, 256);
        this.RA2.mirror = true;
        this.setRotation(this.RA2, 0.4363323f, 0.6108652f, 0.0f);
        (this.RA3 = new ModelRenderer((ModelBase) this, 47, 138)).addBox(0.0f, -16.0f, 2.0f, 1, 6, 1);
        this.RA3.setRotationPoint(-3.0f, -17.0f, -31.0f);
        this.RA3.setTextureSize(256, 256);
        this.RA3.mirror = true;
        this.setRotation(this.RA3, 0.6108652f, 0.6981317f, 0.0f);
        (this.LA3 = new ModelRenderer((ModelBase) this, 91, 138)).addBox(0.0f, -16.0f, 2.0f, 1, 6, 1);
        this.LA3.setRotationPoint(2.0f, -17.0f, -32.0f);
        this.LA3.setTextureSize(256, 256);
        this.LA3.mirror = true;
        this.setRotation(this.LA3, 0.6108652f, -0.6981317f, 0.0f);
        (this.LeftPom = new ModelRenderer((ModelBase) this, 89, 134)).addBox(4.0f, -16.0f, -6.0f, 2, 2, 2);
        this.LeftPom.setRotationPoint(2.0f, -17.0f, -32.0f);
        this.LeftPom.setTextureSize(256, 256);
        this.LeftPom.mirror = true;
        this.setRotation(this.LeftPom, 0.0f, 0.0f, 0.0f);
        (this.RightPom = new ModelRenderer((ModelBase) this, 45, 134)).addBox(-5.0f, -16.0f, -7.0f, 2, 2, 2);
        this.RightPom.setRotationPoint(-3.0f, -17.0f, -31.0f);
        this.RightPom.setTextureSize(256, 256);
        this.RightPom.mirror = true;
        this.setRotation(this.RightPom, 0.0f, 0.0f, 0.0f);
        (this.LeftPincerExtra = new ModelRenderer((ModelBase) this, 71, 166)).addBox(-2.0f, 0.0f, -6.0f, 2, 1, 2);
        this.LeftPincerExtra.setRotationPoint(2.0f, -8.0f, -36.0f);
        this.LeftPincerExtra.setTextureSize(256, 256);
        this.LeftPincerExtra.mirror = true;
        this.setRotation(this.LeftPincerExtra, 0.1745329f, -0.1745329f, 0.0f);
        (this.LeftPincerMain = new ModelRenderer((ModelBase) this, 71, 159)).addBox(0.0f, 0.0f, -6.0f, 2, 1, 6);
        this.LeftPincerMain.setRotationPoint(2.0f, -8.0f, -36.0f);
        this.LeftPincerMain.setTextureSize(256, 256);
        this.LeftPincerMain.mirror = true;
        this.setRotation(this.LeftPincerMain, 0.1745329f, -0.1745329f, 0.0f);
        (this.RightPincerMain = new ModelRenderer((ModelBase) this, 55, 159)).addBox(0.0f, 0.0f, -6.0f, 2, 1, 6);
        this.RightPincerMain.setRotationPoint(-4.0f, -8.0f, -36.0f);
        this.RightPincerMain.setTextureSize(256, 256);
        this.RightPincerMain.mirror = true;
        this.setRotation(this.RightPincerMain, 0.1745329f, 0.1745329f, 0.0f);
        (this.RightPincerExtra = new ModelRenderer((ModelBase) this, 63, 166)).addBox(2.0f, 0.0f, -6.0f, 2, 1, 2);
        this.RightPincerExtra.setRotationPoint(-4.0f, -8.0f, -36.0f);
        this.RightPincerExtra.setTextureSize(256, 256);
        this.RightPincerExtra.mirror = true;
        this.setRotation(this.RightPincerExtra, 0.1745329f, 0.1745329f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        final Bee b = (Bee) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.3f;
        this.WingLeft.rotateAngleZ = -1.745f - newangle;
        this.WingRight.rotateAngleZ = 1.754f + newangle;
        newangle = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.1f;
        this.LeftPincerMain.rotateAngleY = -0.274f + newangle;
        this.LeftPincerExtra.rotateAngleY = -0.274f + newangle;
        this.RightPincerMain.rotateAngleY = 0.274f - newangle;
        this.RightPincerExtra.rotateAngleY = 0.274f - newangle;
        newangle = MathHelper.cos(f2 * 0.21f * this.wingspeed) * 3.1415927f * 0.06f;
        this.LA1.rotateAngleX = 0.261f + newangle;
        this.LA2.rotateAngleX = 0.436f + newangle;
        this.LA3.rotateAngleX = 0.611f + newangle;
        this.LeftPom.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.27f * this.wingspeed) * 3.1415927f * 0.06f;
        this.RA1.rotateAngleX = 0.261f + newangle;
        this.RA2.rotateAngleX = 0.436f + newangle;
        this.RA3.rotateAngleX = 0.611f + newangle;
        this.RightPom.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.31f * this.wingspeed) * 3.1415927f * 0.06f;
        this.LA1.rotateAngleZ = newangle;
        this.LA2.rotateAngleZ = newangle;
        this.LA3.rotateAngleZ = newangle;
        this.LeftPom.rotateAngleZ = newangle;
        newangle = MathHelper.cos(f2 * 0.37f * this.wingspeed) * 3.1415927f * 0.06f;
        this.RA1.rotateAngleZ = newangle;
        this.RA2.rotateAngleZ = newangle;
        this.RA3.rotateAngleZ = newangle;
        this.RightPom.rotateAngleZ = newangle;
        if (b.getAttacking() == 0) {
            newangle = MathHelper.cos(f2 * 0.021f * this.wingspeed) * 3.1415927f * 0.023f;
        } else {
            newangle = MathHelper.cos(f2 * 0.11f * this.wingspeed) * 3.1415927f * 0.055f;
        }
        this.Abdomnem5.rotateAngleX = 1.099f + newangle;
        this.Abdomnem4.rotateAngleX = this.Abdomnem5.rotateAngleX + newangle - 0.35f;
        this.Abdomnem4.rotationPointY = (float) (this.Abdomnem5.rotationPointY
            + Math.cos(this.Abdomnem5.rotateAngleX) * 10.0);
        this.Abdomnem4.rotationPointZ = (float) (this.Abdomnem5.rotationPointZ
            + Math.sin(this.Abdomnem5.rotateAngleX) * 10.0);
        this.Abdomnem3.rotateAngleX = this.Abdomnem4.rotateAngleX + newangle - 0.35f;
        this.Abdomnem3.rotationPointY = (float) (this.Abdomnem4.rotationPointY
            + Math.cos(this.Abdomnem4.rotateAngleX) * 10.0);
        this.Abdomnem3.rotationPointZ = (float) (this.Abdomnem4.rotationPointZ
            + Math.sin(this.Abdomnem4.rotateAngleX) * 10.0);
        this.Abdomnem2.rotateAngleX = this.Abdomnem3.rotateAngleX + newangle - 0.35f;
        this.Abdomnem2.rotationPointY = (float) (this.Abdomnem3.rotationPointY
            + Math.cos(this.Abdomnem3.rotateAngleX) * 6.0);
        this.Abdomnem2.rotationPointZ = (float) (this.Abdomnem3.rotationPointZ
            + Math.sin(this.Abdomnem3.rotateAngleX) * 6.0);
        this.Abdomnem1.rotateAngleX = this.Abdomnem2.rotateAngleX + newangle - 0.35f;
        this.Abdomnem1.rotationPointY = (float) (this.Abdomnem2.rotationPointY
            + Math.cos(this.Abdomnem2.rotateAngleX) * 5.0);
        this.Abdomnem1.rotationPointZ = (float) (this.Abdomnem2.rotationPointZ
            + Math.sin(this.Abdomnem2.rotateAngleX) * 5.0);
        this.Sting.rotateAngleX = this.Abdomnem1.rotateAngleX + newangle - 0.35f;
        this.Sting.rotationPointY = (float) (this.Abdomnem1.rotationPointY
            + Math.cos(this.Abdomnem1.rotateAngleX) * 7.0);
        this.Sting.rotationPointZ = 1.0f
            + (float) (this.Abdomnem1.rotationPointZ + Math.sin(this.Abdomnem1.rotateAngleX) * 7.0);
        this.Sting.render(f5);
        this.Abdomnem1.render(f5);
        this.Abdomnem2.render(f5);
        this.Abdomnem3.render(f5);
        this.Abdomnem4.render(f5);
        this.Abdomnem5.render(f5);
        this.MainBody.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.WingRight.render(f5);
        this.WingLeft.render(f5);
        this.RA1.render(f5);
        this.LA1.render(f5);
        this.LA2.render(f5);
        this.RA2.render(f5);
        this.RA3.render(f5);
        this.LA3.render(f5);
        this.LeftPom.render(f5);
        this.RightPom.render(f5);
        this.LeftPincerExtra.render(f5);
        this.LeftPincerMain.render(f5);
        this.RightPincerMain.render(f5);
        this.RightPincerExtra.render(f5);
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
