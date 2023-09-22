
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.SeaMonster;

public class ModelSeaMonster extends ModelBase {

    private float wingspeed;
    ModelRenderer TailTip;
    ModelRenderer TailBase;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer BodyBack;
    ModelRenderer Neck6;
    ModelRenderer BodyFront;
    ModelRenderer NeckBase;
    ModelRenderer Neck2;
    ModelRenderer Neck3;
    ModelRenderer Neck4;
    ModelRenderer Neck5;
    ModelRenderer BottomJaw;
    ModelRenderer FinBackRight;
    ModelRenderer FinBackLeft;
    ModelRenderer FinFrontLeft;
    ModelRenderer FinFrontRight;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer TopJaw;
    ModelRenderer RightEye;
    ModelRenderer LeftEye;

    public ModelSeaMonster(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.TailTip = new ModelRenderer((ModelBase) this, 158, 36)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 6);
        this.TailTip.setRotationPoint(0.0f, 16.0f, 70.0f);
        this.TailTip.setTextureSize(256, 128);
        this.TailTip.mirror = true;
        this.setRotation(this.TailTip, 0.0f, 0.0f, 0.0f);
        (this.TailBase = new ModelRenderer((ModelBase) this, 68, 64)).addBox(-7.0f, -7.0f, 0.0f, 14, 14, 12);
        this.TailBase.setRotationPoint(0.0f, 16.0f, 26.0f);
        this.TailBase.setTextureSize(256, 128);
        this.TailBase.mirror = true;
        this.setRotation(this.TailBase, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 74, 90)).addBox(-6.0f, -6.0f, 0.0f, 12, 12, 8);
        this.Tail2.setRotationPoint(0.0f, 16.0f, 38.0f);
        this.Tail2.setTextureSize(256, 128);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 78, 110)).addBox(-5.0f, -5.0f, 0.0f, 10, 10, 6);
        this.Tail3.setRotationPoint(0.0f, 16.0f, 46.0f);
        this.Tail3.setTextureSize(256, 128);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.BodyBack = new ModelRenderer((ModelBase) this, 62, 32)).addBox(-8.0f, -8.0f, 0.0f, 16, 16, 16);
        this.BodyBack.setRotationPoint(0.0f, 16.0f, 10.0f);
        this.BodyBack.setTextureSize(256, 128);
        this.BodyBack.mirror = true;
        this.setRotation(this.BodyBack, 0.0f, 0.0f, 0.0f);
        (this.Neck6 = new ModelRenderer((ModelBase) this, 20, 28)).addBox(-2.0f, -6.0f, -2.0f, 4, 6, 4);
        this.Neck6.setRotationPoint(0.0f, -21.0f, -25.0f);
        this.Neck6.setTextureSize(256, 128);
        this.Neck6.mirror = true;
        this.setRotation(this.Neck6, 1.22173f, 0.0f, 0.0f);
        (this.BodyFront = new ModelRenderer((ModelBase) this, 62, 0)).addBox(-8.0f, -8.0f, -16.0f, 16, 16, 16);
        this.BodyFront.setRotationPoint(0.0f, 16.0f, 10.0f);
        this.BodyFront.setTextureSize(256, 128);
        this.BodyFront.mirror = true;
        this.setRotation(this.BodyFront, 0.0f, 0.0f, 0.0f);
        (this.NeckBase = new ModelRenderer((ModelBase) this, 8, 96)).addBox(-5.0f, -10.0f, -5.0f, 10, 10, 10);
        this.NeckBase.setRotationPoint(0.0f, 12.0f, -2.0f);
        this.NeckBase.setTextureSize(256, 128);
        this.NeckBase.mirror = true;
        this.setRotation(this.NeckBase, 0.7853982f, 0.0f, 0.0f);
        (this.Neck2 = new ModelRenderer((ModelBase) this, 14, 78)).addBox(-3.0f, -10.0f, -4.0f, 6, 10, 8);
        this.Neck2.setRotationPoint(0.0f, 6.0f, -9.0f);
        this.Neck2.setTextureSize(256, 128);
        this.Neck2.mirror = true;
        this.setRotation(this.Neck2, 0.6981317f, 0.0f, 0.0f);
        (this.Neck3 = new ModelRenderer((ModelBase) this, 16, 62)).addBox(-3.0f, -10.0f, -3.0f, 6, 10, 6);
        this.Neck3.setRotationPoint(0.0f, -1.0f, -15.0f);
        this.Neck3.setTextureSize(256, 128);
        this.Neck3.mirror = true;
        this.setRotation(this.Neck3, 0.5235988f, 0.0f, 0.0f);
        (this.Neck4 = new ModelRenderer((ModelBase) this, 20, 48)).addBox(-2.0f, -10.0f, -2.0f, 4, 10, 4);
        this.Neck4.setRotationPoint(0.0f, -9.0f, -20.0f);
        this.Neck4.setTextureSize(256, 128);
        this.Neck4.mirror = true;
        this.setRotation(this.Neck4, 0.2617994f, 0.0f, 0.0f);
        (this.Neck5 = new ModelRenderer((ModelBase) this, 20, 38)).addBox(-2.0f, -6.0f, -2.0f, 4, 6, 4);
        this.Neck5.setRotationPoint(0.0f, -17.6f, -22.0f);
        this.Neck5.setTextureSize(256, 128);
        this.Neck5.mirror = true;
        this.setRotation(this.Neck5, 0.7853982f, 0.0f, 0.0f);
        (this.BottomJaw = new ModelRenderer((ModelBase) this, 10, 0)).addBox(-4.0f, 0.0f, -10.0f, 8, 3, 10);
        this.BottomJaw.setRotationPoint(0.0f, -23.0f, -29.0f);
        this.BottomJaw.setTextureSize(256, 128);
        this.BottomJaw.mirror = true;
        this.setRotation(this.BottomJaw, 0.1745329f, 0.0f, 0.0f);
        (this.FinBackRight = new ModelRenderer((ModelBase) this, 132, 95)).addBox(-8.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinBackRight.setRotationPoint(-7.0f, 16.0f, 16.0f);
        this.FinBackRight.setTextureSize(256, 128);
        this.FinBackRight.mirror = true;
        this.setRotation(this.FinBackRight, -0.5235988f, -0.6981317f, 0.0f);
        (this.FinBackLeft = new ModelRenderer((ModelBase) this, 132, 61)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinBackLeft.setRotationPoint(7.0f, 16.0f, 16.0f);
        this.FinBackLeft.setTextureSize(256, 128);
        this.FinBackLeft.mirror = true;
        this.setRotation(this.FinBackLeft, -0.5235988f, 0.6981317f, 0.0f);
        (this.FinFrontLeft = new ModelRenderer((ModelBase) this, 132, 44)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinFrontLeft.setRotationPoint(7.0f, 16.0f, -1.0f);
        this.FinFrontLeft.setTextureSize(256, 128);
        this.FinFrontLeft.mirror = true;
        this.setRotation(this.FinFrontLeft, -0.5235988f, 0.6981317f, 0.0f);
        (this.FinFrontRight = new ModelRenderer((ModelBase) this, 132, 78)).addBox(-8.0f, 0.0f, 0.0f, 8, 1, 16);
        this.FinFrontRight.setRotationPoint(-7.0f, 16.0f, -1.0f);
        this.FinFrontRight.setTextureSize(256, 128);
        this.FinFrontRight.mirror = true;
        this.setRotation(this.FinFrontRight, -0.5235988f, -0.6981317f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase) this, 152, 0)).addBox(-4.0f, -4.0f, 0.0f, 8, 8, 6);
        this.Tail4.setRotationPoint(0.0f, 16.0f, 52.0f);
        this.Tail4.setTextureSize(256, 128);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.0f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase) this, 154, 14)).addBox(-3.0f, -3.0f, 0.0f, 6, 6, 6);
        this.Tail5.setRotationPoint(0.0f, 16.0f, 58.0f);
        this.Tail5.setTextureSize(256, 128);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase) this, 156, 26)).addBox(-2.0f, -2.0f, 0.0f, 4, 4, 6);
        this.Tail6.setRotationPoint(0.0f, 16.0f, 64.0f);
        this.Tail6.setTextureSize(256, 128);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 0.0f, 0.0f, 0.0f);
        (this.TopJaw = new ModelRenderer((ModelBase) this, 10, 13)).addBox(-4.0f, -4.0f, -10.0f, 8, 4, 10);
        this.TopJaw.setRotationPoint(0.0f, -23.0f, -29.0f);
        this.TopJaw.setTextureSize(256, 128);
        this.TopJaw.mirror = true;
        this.setRotation(this.TopJaw, 0.0f, 0.0f, 0.0f);
        (this.RightEye = new ModelRenderer((ModelBase) this, 46, 16)).addBox(-3.0f, -6.0f, -5.0f, 2, 2, 1);
        this.RightEye.setRotationPoint(0.0f, -23.0f, -29.0f);
        this.RightEye.setTextureSize(256, 128);
        this.RightEye.mirror = true;
        this.setRotation(this.RightEye, 0.0f, 0.0f, 0.0f);
        (this.LeftEye = new ModelRenderer((ModelBase) this, 4, 16)).addBox(1.0f, -6.0f, -5.0f, 2, 2, 1);
        this.LeftEye.setRotationPoint(0.0f, -23.0f, -29.0f);
        this.LeftEye.setTextureSize(256, 128);
        this.LeftEye.mirror = true;
        this.setRotation(this.LeftEye, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final SeaMonster e = (SeaMonster) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float pi4 = 0.7853982f;
        if (f1 > 0.1 || e.getAttacking() != 0) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.2f * f1;
        } else {
            newangle = 0.0f;
        }
        this.TailBase.rotateAngleY = newangle / 7.0f;
        this.Tail2.rotationPointZ = this.TailBase.rotationPointZ + (float) Math.cos(this.TailBase.rotateAngleY) * 10.0f;
        this.Tail2.rotationPointX = this.TailBase.rotationPointX + (float) Math.sin(this.TailBase.rotateAngleY) * 10.0f;
        this.Tail2.rotateAngleY = newangle / 6.0f;
        this.Tail3.rotationPointZ = this.Tail2.rotationPointZ + (float) Math.cos(this.Tail2.rotateAngleY) * 7.0f;
        this.Tail3.rotationPointX = this.Tail2.rotationPointX + (float) Math.sin(this.Tail2.rotateAngleY) * 7.0f;
        this.Tail3.rotateAngleY = newangle / 5.0f;
        this.Tail4.rotationPointZ = this.Tail3.rotationPointZ + (float) Math.cos(this.Tail3.rotateAngleY) * 5.0f;
        this.Tail4.rotationPointX = this.Tail3.rotationPointX + (float) Math.sin(this.Tail3.rotateAngleY) * 5.0f;
        this.Tail4.rotateAngleY = newangle / 4.0f;
        this.Tail5.rotationPointZ = this.Tail4.rotationPointZ + (float) Math.cos(this.Tail4.rotateAngleY) * 5.0f;
        this.Tail5.rotationPointX = this.Tail4.rotationPointX + (float) Math.sin(this.Tail4.rotateAngleY) * 5.0f;
        this.Tail5.rotateAngleY = newangle / 3.0f;
        this.Tail6.rotationPointZ = this.Tail5.rotationPointZ + (float) Math.cos(this.Tail5.rotateAngleY) * 5.0f;
        this.Tail6.rotationPointX = this.Tail5.rotationPointX + (float) Math.sin(this.Tail5.rotateAngleY) * 5.0f;
        this.Tail6.rotateAngleY = newangle / 2.0f;
        this.TailTip.rotationPointZ = this.Tail6.rotationPointZ + (float) Math.cos(this.Tail6.rotateAngleY) * 5.0f;
        this.TailTip.rotationPointX = this.Tail6.rotationPointX + (float) Math.sin(this.Tail6.rotateAngleY) * 5.0f;
        this.TailTip.rotateAngleY = newangle;
        if (f1 > 0.1 || e.getAttacking() != 0) {
            newangle = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.2f * f1;
        } else {
            newangle = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.02f;
        }
        this.FinFrontLeft.rotateAngleX = newangle - 0.523f;
        this.FinFrontLeft.rotateAngleY = newangle + 0.698f;
        this.FinBackLeft.rotateAngleX = -newangle - 0.523f;
        this.FinBackLeft.rotateAngleY = -newangle + 0.698f;
        this.FinFrontRight.rotateAngleX = newangle - 0.523f;
        this.FinFrontRight.rotateAngleY = newangle - 0.698f;
        this.FinBackRight.rotateAngleX = -newangle - 0.523f;
        this.FinBackRight.rotateAngleY = -newangle - 0.698f;
        if (f1 > 0.1 || e.getAttacking() != 0) {
            newangle = 0.455f * f1 + MathHelper.cos(f2 * 0.9f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.02f;
        }
        this.NeckBase.rotateAngleX = 0.455f + newangle / 5.0f;
        this.Neck2.rotationPointZ = this.NeckBase.rotationPointZ - (float) Math.sin(this.NeckBase.rotateAngleX) * 9.0f;
        this.Neck2.rotationPointY = this.NeckBase.rotationPointY - (float) Math.cos(this.NeckBase.rotateAngleX) * 9.0f;
        this.Neck2.rotateAngleX = this.NeckBase.rotateAngleX + newangle / 4.0f;
        this.Neck3.rotationPointZ = this.Neck2.rotationPointZ - (float) Math.sin(this.Neck2.rotateAngleX) * 9.0f;
        this.Neck3.rotationPointY = this.Neck2.rotationPointY - (float) Math.cos(this.Neck2.rotateAngleX) * 9.0f;
        this.Neck3.rotateAngleX = this.Neck2.rotateAngleX + newangle / 3.0f;
        this.Neck4.rotationPointZ = this.Neck3.rotationPointZ - (float) Math.sin(this.Neck3.rotateAngleX) * 9.0f;
        this.Neck4.rotationPointY = this.Neck3.rotationPointY - (float) Math.cos(this.Neck3.rotateAngleX) * 9.0f;
        this.Neck4.rotateAngleX = this.Neck3.rotateAngleX + newangle / 2.0f;
        this.Neck5.rotationPointZ = this.Neck4.rotationPointZ - (float) Math.sin(this.Neck4.rotateAngleX) * 9.0f;
        this.Neck5.rotationPointY = this.Neck4.rotationPointY - (float) Math.cos(this.Neck4.rotateAngleX) * 9.0f;
        this.Neck5.rotateAngleX = this.Neck4.rotateAngleX - newangle / 2.0f;
        this.Neck6.rotationPointZ = this.Neck5.rotationPointZ - (float) Math.sin(this.Neck5.rotateAngleX) * 5.0f;
        this.Neck6.rotationPointY = this.Neck5.rotationPointY - (float) Math.cos(this.Neck5.rotateAngleX) * 5.0f;
        this.Neck6.rotateAngleX = this.Neck5.rotateAngleX - newangle / 3.0f;
        final ModelRenderer bottomJaw = this.BottomJaw;
        final ModelRenderer leftEye = this.LeftEye;
        final ModelRenderer rightEye = this.RightEye;
        final ModelRenderer topJaw = this.TopJaw;
        final float n = this.Neck6.rotationPointZ - (float) Math.sin(this.Neck6.rotateAngleX) * 5.0f;
        topJaw.rotationPointZ = n;
        rightEye.rotationPointZ = n;
        leftEye.rotationPointZ = n;
        bottomJaw.rotationPointZ = n;
        final ModelRenderer bottomJaw2 = this.BottomJaw;
        final ModelRenderer leftEye2 = this.LeftEye;
        final ModelRenderer rightEye2 = this.RightEye;
        final ModelRenderer topJaw2 = this.TopJaw;
        final float n2 = this.Neck6.rotationPointY - (float) Math.cos(this.Neck6.rotateAngleX) * 5.0f;
        topJaw2.rotationPointY = n2;
        rightEye2.rotationPointY = n2;
        leftEye2.rotationPointY = n2;
        bottomJaw2.rotationPointY = n2;
        newangle = (float) Math.toRadians(f3) * 0.5f;
        final ModelRenderer bottomJaw3 = this.BottomJaw;
        final ModelRenderer leftEye3 = this.LeftEye;
        final ModelRenderer rightEye3 = this.RightEye;
        final ModelRenderer topJaw3 = this.TopJaw;
        final float n3 = newangle;
        topJaw3.rotateAngleY = n3;
        rightEye3.rotateAngleY = n3;
        leftEye3.rotateAngleY = n3;
        bottomJaw3.rotateAngleY = n3;
        if (e.getAttacking() != 0) {
            newangle = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.17f;
            this.BottomJaw.rotateAngleX = 0.45f + newangle;
        } else {
            newangle = MathHelper.cos(f2 * 0.2f * this.wingspeed) * 3.1415927f * 0.05f;
            this.BottomJaw.rotateAngleX = 0.17f + newangle;
        }
        this.TailTip.render(f5);
        this.TailBase.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.BodyBack.render(f5);
        this.Neck6.render(f5);
        this.BodyFront.render(f5);
        this.NeckBase.render(f5);
        this.Neck2.render(f5);
        this.Neck3.render(f5);
        this.Neck4.render(f5);
        this.Neck5.render(f5);
        this.BottomJaw.render(f5);
        this.FinBackRight.render(f5);
        this.FinBackLeft.render(f5);
        this.FinFrontLeft.render(f5);
        this.FinFrontRight.render(f5);
        this.Tail4.render(f5);
        this.Tail5.render(f5);
        this.Tail6.render(f5);
        this.TopJaw.render(f5);
        this.RightEye.render(f5);
        this.LeftEye.render(f5);
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
