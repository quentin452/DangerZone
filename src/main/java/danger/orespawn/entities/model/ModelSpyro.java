
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import danger.orespawn.entities.entityinstance.Spyro;

public class ModelSpyro extends ModelBase {

    private float wingspeed;
    ModelRenderer RightFrontPaw;
    ModelRenderer WingLeft;
    ModelRenderer LegRightFrontTop;
    ModelRenderer LegRightFrontBottom;
    ModelRenderer LegRightBackTop;
    ModelRenderer LegRightBackBottom;
    ModelRenderer RightBackPaw;
    ModelRenderer LegLeftFrontTop;
    ModelRenderer SnoutRight;
    ModelRenderer LeftFrontPaw;
    ModelRenderer LegLeftBackTop;
    ModelRenderer LegLeftBackBottom;
    ModelRenderer LeftBackPaw;
    ModelRenderer LegLeftFrontBottom;
    ModelRenderer TailPieceSmall;
    ModelRenderer JawPiece;
    ModelRenderer HeadPieceBottom;
    ModelRenderer HeadPieceTop;
    ModelRenderer HornRightBottom;
    ModelRenderer HornLeftBottom;
    ModelRenderer HornRightTop;
    ModelRenderer HornLeftTop;
    ModelRenderer Torso;
    ModelRenderer SnoutLeft;
    ModelRenderer WingPieceLeft;
    ModelRenderer WingRight;
    ModelRenderer WingPieceRight;
    ModelRenderer Neck;
    ModelRenderer TailBack;
    ModelRenderer TailFront;
    ModelRenderer ScaleBackHead;
    ModelRenderer TailPieceLarge;
    ModelRenderer ScaleTailPiece;
    ModelRenderer ScaleHead;
    ModelRenderer ScaleTop1;
    ModelRenderer ScaleBackPiece1;
    ModelRenderer ScaleBackPiece2;

    public ModelSpyro(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.RightFrontPaw = new ModelRenderer((ModelBase) this, 12, 31)).addBox(0.0f, 5.0f, -4.0f, 2, 1, 4);
        this.RightFrontPaw.setRotationPoint(3.0f, 18.0f, -2.0f);
        this.RightFrontPaw.setTextureSize(64, 64);
        this.RightFrontPaw.mirror = true;
        this.setRotation(this.RightFrontPaw, 0.0f, 0.0f, 0.0f);
        (this.WingLeft = new ModelRenderer((ModelBase) this, 2, 51)).addBox(-10.0f, -1.0f, -2.0f, 10, 0, 4);
        this.WingLeft.setRotationPoint(-1.0f, 16.0f, 0.0f);
        this.WingLeft.setTextureSize(64, 64);
        this.WingLeft.mirror = true;
        this.setRotation(this.WingLeft, 0.1745329f, 0.0f, -0.1745329f);
        (this.LegRightFrontTop = new ModelRenderer((ModelBase) this, 20, 19)).addBox(0.0f, 0.0f, -2.0f, 2, 3, 3);
        this.LegRightFrontTop.setRotationPoint(3.0f, 18.0f, -2.0f);
        this.LegRightFrontTop.setTextureSize(64, 64);
        this.LegRightFrontTop.mirror = true;
        this.setRotation(this.LegRightFrontTop, -0.0872665f, 0.0f, 0.0f);
        (this.LegRightFrontBottom = new ModelRenderer((ModelBase) this, 0, 25)).addBox(0.0f, 2.0f, -1.5f, 2, 4, 2);
        this.LegRightFrontBottom.setRotationPoint(3.0f, 18.0f, -2.0f);
        this.LegRightFrontBottom.setTextureSize(64, 64);
        this.LegRightFrontBottom.mirror = true;
        this.setRotation(this.LegRightFrontBottom, -0.1745329f, 0.0f, 0.0f);
        (this.LegRightBackTop = new ModelRenderer((ModelBase) this, 30, 19)).addBox(0.0f, 0.0f, -2.0f, 2, 3, 3);
        this.LegRightBackTop.setRotationPoint(3.0f, 18.0f, 3.0f);
        this.LegRightBackTop.setTextureSize(64, 64);
        this.LegRightBackTop.mirror = true;
        this.setRotation(this.LegRightBackTop, 0.1396263f, 0.0f, 0.0f);
        (this.LegRightBackBottom = new ModelRenderer((ModelBase) this, 16, 25)).addBox(0.0f, 2.0f, -1.0f, 2, 4, 2);
        this.LegRightBackBottom.setRotationPoint(3.0f, 18.0f, 3.0f);
        this.LegRightBackBottom.setTextureSize(64, 64);
        this.LegRightBackBottom.mirror = true;
        this.setRotation(this.LegRightBackBottom, -0.1745329f, 0.0f, 0.0f);
        (this.RightBackPaw = new ModelRenderer((ModelBase) this, 36, 31)).addBox(0.0f, 5.0f, -3.0f, 2, 1, 4);
        this.RightBackPaw.setRotationPoint(3.0f, 18.0f, 3.0f);
        this.RightBackPaw.setTextureSize(64, 64);
        this.RightBackPaw.mirror = true;
        this.setRotation(this.RightBackPaw, 0.0f, 0.0f, 0.0f);
        (this.LegLeftFrontTop = new ModelRenderer((ModelBase) this, 0, 19)).addBox(-2.0f, 0.0f, -1.0f, 2, 3, 3);
        this.LegLeftFrontTop.setRotationPoint(-2.0f, 18.0f, -3.0f);
        this.LegLeftFrontTop.setTextureSize(64, 64);
        this.LegLeftFrontTop.mirror = true;
        this.setRotation(this.LegLeftFrontTop, -0.0872665f, 0.0f, 0.0f);
        (this.SnoutRight = new ModelRenderer((ModelBase) this, 48, 2)).addBox(1.0f, -3.0f, -5.0f, 1, 1, 1);
        this.SnoutRight.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.SnoutRight.setTextureSize(64, 64);
        this.SnoutRight.mirror = true;
        this.setRotation(this.SnoutRight, 0.0f, 0.0f, 0.0f);
        (this.LeftFrontPaw = new ModelRenderer((ModelBase) this, 0, 31)).addBox(-2.0f, 5.0f, -3.0f, 2, 1, 4);
        this.LeftFrontPaw.setRotationPoint(-2.0f, 18.0f, -3.0f);
        this.LeftFrontPaw.setTextureSize(64, 64);
        this.LeftFrontPaw.mirror = true;
        this.setRotation(this.LeftFrontPaw, 0.0f, 0.0f, 0.0f);
        (this.LegLeftBackTop = new ModelRenderer((ModelBase) this, 10, 19)).addBox(-2.0f, 0.0f, -2.0f, 2, 3, 3);
        this.LegLeftBackTop.setRotationPoint(-2.0f, 18.0f, 3.0f);
        this.LegLeftBackTop.setTextureSize(64, 64);
        this.LegLeftBackTop.mirror = true;
        this.setRotation(this.LegLeftBackTop, 0.1396263f, 0.0f, 0.0f);
        (this.LegLeftBackBottom = new ModelRenderer((ModelBase) this, 24, 25)).addBox(-2.0f, 2.0f, -1.0f, 2, 4, 2);
        this.LegLeftBackBottom.setRotationPoint(-2.0f, 18.0f, 3.0f);
        this.LegLeftBackBottom.setTextureSize(64, 64);
        this.LegLeftBackBottom.mirror = true;
        this.setRotation(this.LegLeftBackBottom, -0.1745329f, 0.0f, 0.0f);
        (this.LeftBackPaw = new ModelRenderer((ModelBase) this, 24, 31)).addBox(-2.0f, 5.0f, -3.0f, 2, 1, 4);
        this.LeftBackPaw.setRotationPoint(-2.0f, 18.0f, 3.0f);
        this.LeftBackPaw.setTextureSize(64, 64);
        this.LeftBackPaw.mirror = true;
        this.setRotation(this.LeftBackPaw, 0.0f, 0.0f, 0.0f);
        (this.LegLeftFrontBottom = new ModelRenderer((ModelBase) this, 8, 25)).addBox(-2.0f, 2.0f, -0.5f, 2, 4, 2);
        this.LegLeftFrontBottom.setRotationPoint(-2.0f, 18.0f, -3.0f);
        this.LegLeftFrontBottom.setTextureSize(64, 64);
        this.LegLeftFrontBottom.mirror = true;
        this.setRotation(this.LegLeftFrontBottom, -0.1745329f, 0.0f, 0.0f);
        (this.TailPieceSmall = new ModelRenderer((ModelBase) this, 28, 36)).addBox(0.0f, -0.5f, 4.0f, 1, 1, 1);
        this.TailPieceSmall.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.TailPieceSmall.setTextureSize(64, 64);
        this.TailPieceSmall.mirror = true;
        this.setRotation(this.TailPieceSmall, 0.1745329f, 0.0f, 0.0f);
        (this.JawPiece = new ModelRenderer((ModelBase) this, 52, 0)).addBox(-2.0f, -1.0f, -4.0f, 3, 1, 3);
        this.JawPiece.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.JawPiece.setTextureSize(64, 64);
        this.JawPiece.mirror = true;
        this.setRotation(this.JawPiece, 0.1745329f, 0.0f, 0.0f);
        (this.HeadPieceBottom = new ModelRenderer((ModelBase) this, 30, 7)).addBox(-3.0f, -2.0f, -5.0f, 5, 2, 6);
        this.HeadPieceBottom.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.HeadPieceBottom.setTextureSize(64, 64);
        this.HeadPieceBottom.mirror = true;
        this.setRotation(this.HeadPieceBottom, 0.0f, 0.0f, 0.0f);
        (this.HeadPieceTop = new ModelRenderer((ModelBase) this, 30, 0)).addBox(-3.0f, -5.0f, -3.0f, 5, 3, 4);
        this.HeadPieceTop.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.HeadPieceTop.setTextureSize(64, 64);
        this.HeadPieceTop.mirror = true;
        this.setRotation(this.HeadPieceTop, 0.0f, 0.0f, 0.0f);
        (this.HornRightBottom = new ModelRenderer((ModelBase) this, 8, 14)).addBox(0.0f, -6.0f, -3.5f, 2, 3, 2);
        this.HornRightBottom.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.HornRightBottom.setTextureSize(64, 64);
        this.HornRightBottom.mirror = true;
        this.setRotation(this.HornRightBottom, -0.7853982f, 0.7853982f, 0.0f);
        (this.HornLeftBottom = new ModelRenderer((ModelBase) this, 0, 14)).addBox(-2.75f, -6.5f, -3.0f, 2, 3, 2);
        this.HornLeftBottom.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.HornLeftBottom.setTextureSize(64, 64);
        this.HornLeftBottom.mirror = true;
        this.setRotation(this.HornLeftBottom, -0.7853982f, -0.7853982f, 0.0f);
        (this.HornRightTop = new ModelRenderer((ModelBase) this, 20, 14)).addBox(0.5f, -9.0f, -3.0f, 1, 3, 1);
        this.HornRightTop.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.HornRightTop.setTextureSize(64, 64);
        this.HornRightTop.mirror = true;
        this.setRotation(this.HornRightTop, -0.7853982f, 0.7853982f, 0.0f);
        (this.HornLeftTop = new ModelRenderer((ModelBase) this, 16, 14)).addBox(-2.2f, -9.5f, -2.5f, 1, 3, 1);
        this.HornLeftTop.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.HornLeftTop.setTextureSize(64, 64);
        this.HornLeftTop.mirror = true;
        this.setRotation(this.HornLeftTop, -0.7853982f, -0.7853982f, 0.0f);
        (this.Torso = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.0f, -2.0f, -5.0f, 5, 4, 10);
        this.Torso.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.Torso.setTextureSize(64, 64);
        this.Torso.mirror = true;
        this.setRotation(this.Torso, 0.0f, 0.0f, 0.0f);
        (this.SnoutLeft = new ModelRenderer((ModelBase) this, 48, 0)).addBox(-3.0f, -3.0f, -5.0f, 1, 1, 1);
        this.SnoutLeft.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.SnoutLeft.setTextureSize(64, 64);
        this.SnoutLeft.mirror = true;
        this.setRotation(this.SnoutLeft, 0.0f, 0.0f, 0.0f);
        (this.WingPieceLeft = new ModelRenderer((ModelBase) this, 4, 42)).addBox(-1.0f, -2.0f, -1.0f, 1, 2, 1);
        this.WingPieceLeft.setRotationPoint(0.0f, 17.2f, 0.0f);
        this.WingPieceLeft.setTextureSize(64, 64);
        this.WingPieceLeft.mirror = true;
        this.setRotation(this.WingPieceLeft, 0.1745329f, 0.0f, -0.1745329f);
        (this.WingRight = new ModelRenderer((ModelBase) this, 2, 45)).addBox(0.0f, -1.0f, -2.0f, 10, 0, 4);
        this.WingRight.setRotationPoint(2.0f, 16.0f, 0.0f);
        this.WingRight.setTextureSize(64, 64);
        this.WingRight.mirror = true;
        this.setRotation(this.WingRight, 0.1745329f, 0.0f, 0.1745329f);
        (this.WingPieceRight = new ModelRenderer((ModelBase) this, 0, 42)).addBox(-1.0f, -2.0f, 0.0f, 1, 2, 1);
        this.WingPieceRight.setRotationPoint(2.0f, 17.5f, -1.0f);
        this.WingPieceRight.setTextureSize(64, 64);
        this.WingPieceRight.mirror = true;
        this.setRotation(this.WingPieceRight, 0.1745329f, 0.0f, 0.1745329f);
        (this.Neck = new ModelRenderer((ModelBase) this, 52, 7)).addBox(-1.0f, -2.0f, -1.0f, 3, 3, 3);
        this.Neck.setRotationPoint(0.0f, 17.0f, -4.0f);
        this.Neck.setTextureSize(64, 64);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.4537856f, 0.0f, 0.0f);
        (this.TailBack = new ModelRenderer((ModelBase) this, 0, 36)).addBox(-1.0f, -1.0f, -1.0f, 2, 2, 4);
        this.TailBack.setRotationPoint(0.5f, 17.5f, 5.0f);
        this.TailBack.setTextureSize(64, 64);
        this.TailBack.mirror = true;
        this.setRotation(this.TailBack, 0.4537856f, 0.0f, 0.0f);
        (this.TailFront = new ModelRenderer((ModelBase) this, 12, 36)).addBox(0.0f, 0.0f, -1.0f, 1, 1, 4);
        this.TailFront.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.TailFront.setTextureSize(64, 64);
        this.TailFront.mirror = true;
        this.setRotation(this.TailFront, 0.2617994f, 0.0f, 0.0f);
        (this.ScaleBackHead = new ModelRenderer((ModelBase) this, 38, 36)).addBox(-1.0f, -3.0f, 2.0f, 1, 2, 1);
        this.ScaleBackHead.setRotationPoint(1.0f, 16.0f, -4.0f);
        this.ScaleBackHead.setTextureSize(64, 64);
        this.ScaleBackHead.mirror = true;
        this.setRotation(this.ScaleBackHead, 0.0f, 0.0f, 0.0f);
        (this.TailPieceLarge = new ModelRenderer((ModelBase) this, 22, 36)).addBox(0.0f, -1.0f, 2.0f, 1, 2, 2);
        this.TailPieceLarge.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.TailPieceLarge.setTextureSize(64, 64);
        this.TailPieceLarge.mirror = true;
        this.setRotation(this.TailPieceLarge, 0.1745329f, 0.0f, 0.0f);
        (this.ScaleTailPiece = new ModelRenderer((ModelBase) this, 48, 36)).addBox(-0.5f, -2.0f, 0.2f, 1, 1, 2);
        this.ScaleTailPiece.setRotationPoint(0.5f, 17.5f, 5.0f);
        this.ScaleTailPiece.setTextureSize(64, 64);
        this.ScaleTailPiece.mirror = true;
        this.setRotation(this.ScaleTailPiece, 0.4537856f, 0.0f, 0.0f);
        (this.ScaleHead = new ModelRenderer((ModelBase) this, 42, 36)).addBox(-1.0f, -6.0f, 0.0f, 1, 2, 2);
        this.ScaleHead.setRotationPoint(1.0f, 16.0f, -3.0f);
        this.ScaleHead.setTextureSize(64, 64);
        this.ScaleHead.mirror = true;
        this.setRotation(this.ScaleHead, 0.0f, 0.0f, 0.0f);
        (this.ScaleTop1 = new ModelRenderer((ModelBase) this, 48, 36)).addBox(-1.0f, -6.0f, -4.0f, 1, 1, 2);
        this.ScaleTop1.setRotationPoint(1.0f, 16.0f, -2.0f);
        this.ScaleTop1.setTextureSize(64, 64);
        this.ScaleTop1.mirror = true;
        this.setRotation(this.ScaleTop1, 0.0f, 0.0f, 0.0f);
        (this.ScaleBackPiece1 = new ModelRenderer((ModelBase) this, 48, 36)).addBox(0.0f, -1.0f, -1.0f, 1, 1, 2);
        this.ScaleBackPiece1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.ScaleBackPiece1.setTextureSize(64, 64);
        this.ScaleBackPiece1.mirror = true;
        this.setRotation(this.ScaleBackPiece1, 0.0f, 0.0f, 0.0f);
        (this.ScaleBackPiece2 = new ModelRenderer((ModelBase) this, 48, 36)).addBox(0.0f, -1.0f, -1.0f, 1, 1, 2);
        this.ScaleBackPiece2.setRotationPoint(0.0f, 17.0f, 3.0f);
        this.ScaleBackPiece2.setTextureSize(64, 64);
        this.ScaleBackPiece2.mirror = true;
        this.setRotation(this.ScaleBackPiece2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Spyro c = (Spyro) entity;
        final float hf = 0.0f;
        float newangle = 0.0f;
        final int current_activity = c.getActivity();
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 2.3f * this.wingspeed) * 3.1415927f * 0.4f * f1;
        } else {
            newangle = 0.0f;
        }
        if (current_activity == 3) {
            newangle *= 0.5f;
        }
        this.WingLeft.rotateAngleZ = newangle;
        this.WingRight.rotateAngleZ = -newangle;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        if (current_activity == 3) {
            newangle = 0.0f;
        }
        if (current_activity != 2) {
            this.LegRightFrontTop.rotateAngleX = newangle - 0.087f;
            this.LegRightFrontBottom.rotateAngleX = newangle - 0.17f;
            this.RightFrontPaw.rotateAngleX = newangle;
            this.LegLeftFrontTop.rotateAngleX = -newangle - 0.087f;
            this.LegLeftFrontBottom.rotateAngleX = -newangle - 0.17f;
            this.LeftFrontPaw.rotateAngleX = -newangle;
            this.LegRightBackBottom.rotateAngleX = -newangle + 0.139f;
            this.LegRightBackTop.rotateAngleX = -newangle - 0.174f;
            this.RightBackPaw.rotateAngleX = -newangle;
            this.LegLeftBackBottom.rotateAngleX = newangle + 0.139f;
            this.LegLeftBackTop.rotateAngleX = newangle - 0.174f;
            this.LeftBackPaw.rotateAngleX = newangle;
        } else {
            newangle = -1.0f;
            this.LegRightFrontTop.rotateAngleX = newangle - 0.087f;
            this.LegRightFrontBottom.rotateAngleX = newangle - 0.17f;
            this.RightFrontPaw.rotateAngleX = newangle;
            this.LegLeftFrontTop.rotateAngleX = newangle - 0.087f;
            this.LegLeftFrontBottom.rotateAngleX = newangle - 0.17f;
            this.LeftFrontPaw.rotateAngleX = newangle;
            newangle = 1.0f;
            this.LegRightBackBottom.rotateAngleX = newangle + 0.139f;
            this.LegRightBackTop.rotateAngleX = newangle - 0.174f;
            this.RightBackPaw.rotateAngleX = newangle;
            this.LegLeftBackBottom.rotateAngleX = newangle + 0.139f;
            this.LegLeftBackTop.rotateAngleX = newangle - 0.174f;
            this.LeftBackPaw.rotateAngleX = newangle;
        }
        newangle = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.25f;
        if (c.isSitting() || current_activity == 3) {
            newangle = 0.0f;
        }
        this.TailBack.rotateAngleY = newangle;
        this.ScaleTailPiece.rotateAngleY = newangle;
        this.TailFront.rotationPointZ = this.TailBack.rotationPointZ
            + (float) Math.cos(this.TailBack.rotateAngleY) * 3.0f;
        this.TailFront.rotationPointX = this.TailBack.rotationPointX
            + (float) Math.sin(this.TailBack.rotateAngleY) * 3.0f
            - 0.5f;
        this.TailFront.rotateAngleY = newangle * 1.6f;
        this.TailPieceLarge.rotationPointZ = this.TailFront.rotationPointZ;
        this.TailPieceLarge.rotationPointX = this.TailFront.rotationPointX;
        this.TailPieceLarge.rotateAngleY = this.TailFront.rotateAngleY;
        this.TailPieceSmall.rotationPointZ = this.TailFront.rotationPointZ;
        this.TailPieceSmall.rotationPointX = this.TailFront.rotationPointX;
        this.TailPieceSmall.rotateAngleY = this.TailFront.rotateAngleY;
        this.HeadPieceTop.rotateAngleY = (float) Math.toRadians(f3);
        this.HeadPieceBottom.rotateAngleY = (float) Math.toRadians(f3);
        this.JawPiece.rotateAngleY = (float) Math.toRadians(f3);
        this.SnoutRight.rotateAngleY = (float) Math.toRadians(f3);
        this.SnoutLeft.rotateAngleY = (float) Math.toRadians(f3);
        this.ScaleTop1.rotateAngleY = (float) Math.toRadians(f3);
        this.ScaleHead.rotateAngleY = (float) Math.toRadians(f3);
        this.ScaleBackHead.rotateAngleY = (float) Math.toRadians(f3);
        this.HornRightBottom.rotateAngleY = (float) Math.toRadians(f3) + 0.785f;
        this.HornRightTop.rotateAngleY = (float) Math.toRadians(f3) + 0.785f;
        this.HornLeftBottom.rotateAngleY = (float) Math.toRadians(f3) - 0.785f;
        this.HornLeftTop.rotateAngleY = (float) Math.toRadians(f3) - 0.785f;
        this.HeadPieceTop.rotateAngleX = (float) Math.toRadians(f4);
        this.HeadPieceBottom.rotateAngleX = (float) Math.toRadians(f4);
        this.JawPiece.rotateAngleX = (float) Math.toRadians(f4);
        this.SnoutRight.rotateAngleX = (float) Math.toRadians(f4);
        this.SnoutLeft.rotateAngleX = (float) Math.toRadians(f4);
        this.ScaleTop1.rotateAngleX = (float) Math.toRadians(f4);
        this.ScaleHead.rotateAngleX = (float) Math.toRadians(f4);
        this.ScaleBackHead.rotateAngleX = (float) Math.toRadians(f4);
        this.HornRightBottom.rotateAngleX = (float) Math.toRadians(f4) - 0.785f;
        this.HornRightTop.rotateAngleX = (float) Math.toRadians(f4) - 0.785f;
        this.HornLeftBottom.rotateAngleX = (float) Math.toRadians(f4) - 0.785f;
        this.HornLeftTop.rotateAngleX = (float) Math.toRadians(f4) - 0.785f;
        this.RightFrontPaw.render(f5);
        this.WingLeft.render(f5);
        this.LegRightFrontTop.render(f5);
        this.LegRightFrontBottom.render(f5);
        this.LegRightBackTop.render(f5);
        this.LegRightBackBottom.render(f5);
        this.RightBackPaw.render(f5);
        this.LegLeftFrontTop.render(f5);
        this.SnoutRight.render(f5);
        this.LeftFrontPaw.render(f5);
        this.LegLeftBackTop.render(f5);
        this.LegLeftBackBottom.render(f5);
        this.LeftBackPaw.render(f5);
        this.LegLeftFrontBottom.render(f5);
        this.TailPieceSmall.render(f5);
        this.JawPiece.render(f5);
        this.HeadPieceBottom.render(f5);
        this.HeadPieceTop.render(f5);
        this.HornRightBottom.render(f5);
        this.HornLeftBottom.render(f5);
        this.HornRightTop.render(f5);
        this.HornLeftTop.render(f5);
        this.Torso.render(f5);
        this.SnoutLeft.render(f5);
        this.WingPieceLeft.render(f5);
        this.WingRight.render(f5);
        this.WingPieceRight.render(f5);
        this.Neck.render(f5);
        this.TailBack.render(f5);
        this.TailFront.render(f5);
        this.ScaleBackHead.render(f5);
        this.TailPieceLarge.render(f5);
        this.ScaleTailPiece.render(f5);
        this.ScaleHead.render(f5);
        this.ScaleTop1.render(f5);
        this.ScaleBackPiece1.render(f5);
        this.ScaleBackPiece2.render(f5);
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
