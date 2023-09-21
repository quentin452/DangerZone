
package fr.iamacat.dangerzone_iamacatfr.entities.model;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.EmperorScorpion;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEmperorScorpion extends ModelBase {

    private float wingspeed;
    ModelRenderer Head;
    ModelRenderer Seg1;
    ModelRenderer Seg2;
    ModelRenderer Seg3;
    ModelRenderer Seg4;
    ModelRenderer Seg5;
    ModelRenderer Seg6;
    ModelRenderer Seg7;
    ModelRenderer Seg8;
    ModelRenderer Tailseg1;
    ModelRenderer Tailseg2;
    ModelRenderer Tailseg3;
    ModelRenderer Tailseg4;
    ModelRenderer Tailseg5;
    ModelRenderer Tailseg6;
    ModelRenderer Tailseg7;
    ModelRenderer Tailseg8;
    ModelRenderer Stinger1;
    ModelRenderer Stinger2;
    ModelRenderer Stinger3;
    ModelRenderer LeftShoulder;
    ModelRenderer LeftArmSeg1;
    ModelRenderer LeftArmSeg2;
    ModelRenderer LeftArmSeg3;
    ModelRenderer LeftArmSeg4;
    ModelRenderer RightShoulder;
    ModelRenderer RightArmSeg1;
    ModelRenderer RightArmSeg2;
    ModelRenderer RightArmSeg3;
    ModelRenderer RightArmSeg4;
    ModelRenderer RightPincer;
    ModelRenderer LeftPincer;
    ModelRenderer Lefteye;
    ModelRenderer Righteye;
    ModelRenderer RightMandible;
    ModelRenderer LeftMandible;
    ModelRenderer RightManPart2;
    ModelRenderer LeftManPart2;
    ModelRenderer Leg1Seg1;
    ModelRenderer Leg1Seg2;
    ModelRenderer Leg1Seg3;
    ModelRenderer Leg1Seg4;
    ModelRenderer Leg1Seg5;
    ModelRenderer Leg2Seg1;
    ModelRenderer Leg2Seg2;
    ModelRenderer Leg2Seg3;
    ModelRenderer Leg2Seg4;
    ModelRenderer Leg2Seg5;
    ModelRenderer Leg3Seg1;
    ModelRenderer Leg3Seg2;
    ModelRenderer Leg3Seg3;
    ModelRenderer Leg3Seg4;
    ModelRenderer Leg3Seg5;
    ModelRenderer Leg4Seg1;
    ModelRenderer Leg4Seg2;
    ModelRenderer Leg4Seg3;
    ModelRenderer Leg4Seg4;
    ModelRenderer Leg4Seg5;
    ModelRenderer Leg5Seg1;
    ModelRenderer Leg5Seg2;
    ModelRenderer Leg5Seg3;
    ModelRenderer Leg5Seg4;
    ModelRenderer Leg5Seg5;
    ModelRenderer Leg6Seg1;
    ModelRenderer Leg6Seg2;
    ModelRenderer Leg6Seg3;
    ModelRenderer Leg6Seg4;
    ModelRenderer Leg6Seg5;
    ModelRenderer Leg7Seg1;
    ModelRenderer Leg7Seg2;
    ModelRenderer Leg7Seg3;
    ModelRenderer Leg7Seg4;
    ModelRenderer Leg7Seg5;
    ModelRenderer Leg8Seg1;
    ModelRenderer Leg8Seg2;
    ModelRenderer Leg8Seg3;
    ModelRenderer Leg8Seg4;
    ModelRenderer Leg8Seg5;

    public ModelEmperorScorpion(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Head = new ModelRenderer((ModelBase) this, 0, 104)).addBox(-9.0f, -4.0f, -16.0f, 18, 8, 16);
        this.Head.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Head.setTextureSize(256, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Seg1 = new ModelRenderer((ModelBase) this, 0, 78)).addBox(-9.0f, -4.0f, 0.0f, 18, 8, 4);
        this.Seg1.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg1.setTextureSize(256, 128);
        this.Seg1.mirror = true;
        this.setRotation(this.Seg1, 0.0f, 0.0f, 0.0f);
        (this.Seg2 = new ModelRenderer((ModelBase) this, 0, 65)).addBox(-8.5f, -4.1f, 4.0f, 17, 8, 4);
        this.Seg2.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg2.setTextureSize(256, 128);
        this.Seg2.mirror = true;
        this.setRotation(this.Seg2, 0.0f, 0.0f, 0.0f);
        (this.Seg3 = new ModelRenderer((ModelBase) this, 0, 50)).addBox(-9.5f, -4.0f, 8.0f, 19, 8, 5);
        this.Seg3.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg3.setTextureSize(256, 128);
        this.Seg3.mirror = true;
        this.setRotation(this.Seg3, 0.0f, 0.0f, 0.0f);
        (this.Seg4 = new ModelRenderer((ModelBase) this, 0, 35)).addBox(-9.0f, -4.1f, 13.0f, 18, 8, 6);
        this.Seg4.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg4.setTextureSize(256, 128);
        this.Seg4.mirror = true;
        this.setRotation(this.Seg4, 0.0f, 0.0f, 0.0f);
        (this.Seg5 = new ModelRenderer((ModelBase) this, 45, 91)).addBox(-8.5f, -4.0f, 19.0f, 17, 8, 3);
        this.Seg5.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg5.setTextureSize(256, 128);
        this.Seg5.mirror = true;
        this.setRotation(this.Seg5, 0.0f, 0.0f, 0.0f);
        (this.Seg6 = new ModelRenderer((ModelBase) this, 45, 79)).addBox(-8.0f, -4.1f, 22.0f, 16, 8, 3);
        this.Seg6.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg6.setTextureSize(256, 128);
        this.Seg6.mirror = true;
        this.setRotation(this.Seg6, 0.0f, 0.0f, 0.0f);
        (this.Seg7 = new ModelRenderer((ModelBase) this, 43, 66)).addBox(-7.0f, -4.0f, 25.0f, 14, 8, 3);
        this.Seg7.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg7.setTextureSize(256, 128);
        this.Seg7.mirror = true;
        this.setRotation(this.Seg7, 0.0f, 0.0f, 0.0f);
        (this.Seg8 = new ModelRenderer((ModelBase) this, 49, 53)).addBox(-5.5f, -4.1f, 28.0f, 11, 8, 2);
        this.Seg8.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Seg8.setTextureSize(256, 128);
        this.Seg8.mirror = true;
        this.setRotation(this.Seg8, 0.0f, 0.0f, 0.0f);
        (this.Tailseg1 = new ModelRenderer((ModelBase) this, 92, 0)).addBox(-4.0f, -1.0f, 0.0f, 8, 4, 10);
        this.Tailseg1.setRotationPoint(0.0f, 13.0f, 20.0f);
        this.Tailseg1.setTextureSize(256, 128);
        this.Tailseg1.mirror = true;
        this.setRotation(this.Tailseg1, 0.5948578f, 0.0f, 0.0f);
        (this.Tailseg2 = new ModelRenderer((ModelBase) this, 90, 15)).addBox(-3.5f, -2.0f, 0.0f, 7, 4, 12);
        this.Tailseg2.setRotationPoint(0.0f, 10.0f, 27.0f);
        this.Tailseg2.setTextureSize(256, 128);
        this.Tailseg2.mirror = true;
        this.setRotation(this.Tailseg2, 1.07818f, 0.0f, 0.0f);
        (this.Tailseg3 = new ModelRenderer((ModelBase) this, 96, 32)).addBox(-3.0f, -2.0f, 1.0f, 6, 4, 10);
        this.Tailseg3.setRotationPoint(0.0f, 2.0f, 32.0f);
        this.Tailseg3.setTextureSize(256, 128);
        this.Tailseg3.mirror = true;
        this.setRotation(this.Tailseg3, 1.710216f, 0.0f, 0.0f);
        (this.Tailseg4 = new ModelRenderer((ModelBase) this, 96, 47)).addBox(-2.5f, -2.0f, 0.0f, 5, 4, 11);
        this.Tailseg4.setRotationPoint(0.0f, -7.0f, 31.0f);
        this.Tailseg4.setTextureSize(256, 128);
        this.Tailseg4.mirror = true;
        this.setRotation(this.Tailseg4, 2.267895f, 0.0f, 0.0f);
        (this.Tailseg5 = new ModelRenderer((ModelBase) this, 98, 63)).addBox(-2.0f, -2.0f, 0.0f, 4, 4, 11);
        this.Tailseg5.setRotationPoint(0.0f, -14.0f, 25.0f);
        this.Tailseg5.setTextureSize(256, 128);
        this.Tailseg5.mirror = true;
        this.setRotation(this.Tailseg5, 2.899932f, 0.0f, 0.0f);
        (this.Tailseg6 = new ModelRenderer((ModelBase) this, 98, 79)).addBox(-2.0f, -2.0f, 0.0f, 4, 4, 11);
        this.Tailseg6.setRotationPoint(0.0f, -17.0f, 16.0f);
        this.Tailseg6.setTextureSize(256, 128);
        this.Tailseg6.mirror = true;
        this.setRotation(this.Tailseg6, -2.602503f, 0.0f, 0.0f);
        (this.Tailseg7 = new ModelRenderer((ModelBase) this, 94, 95)).addBox(-3.0f, -2.0f, 0.0f, 6, 4, 11);
        this.Tailseg7.setRotationPoint(0.0f, -12.0f, 8.0f);
        this.Tailseg7.setTextureSize(256, 128);
        this.Tailseg7.mirror = true;
        this.setRotation(this.Tailseg7, -0.2230717f, 0.0f, 0.0f);
        (this.Tailseg8 = new ModelRenderer((ModelBase) this, 102, 111)).addBox(-4.0f, -2.0f, 4.0f, 8, 4, 5);
        this.Tailseg8.setRotationPoint(0.0f, -12.0f, 8.0f);
        this.Tailseg8.setTextureSize(256, 128);
        this.Tailseg8.mirror = true;
        this.setRotation(this.Tailseg8, -0.2230717f, 0.0f, 0.0f);
        (this.Stinger1 = new ModelRenderer((ModelBase) this, 83, 0)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 3);
        this.Stinger1.setRotationPoint(0.0f, -10.0f, 18.0f);
        this.Stinger1.setTextureSize(256, 128);
        this.Stinger1.mirror = true;
        this.setRotation(this.Stinger1, 0.2230717f, 0.0f, 0.0f);
        (this.Stinger2 = new ModelRenderer((ModelBase) this, 83, 0)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 3);
        this.Stinger2.setRotationPoint(0.0f, -10.5f, 20.5f);
        this.Stinger2.setTextureSize(256, 128);
        this.Stinger2.mirror = true;
        this.setRotation(this.Stinger2, -0.2602503f, 0.0f, 0.0f);
        (this.Stinger3 = new ModelRenderer((ModelBase) this, 79, 5)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 5);
        this.Stinger3.setRotationPoint(0.0f, -10.0f, 23.0f);
        this.Stinger3.setTextureSize(256, 128);
        this.Stinger3.mirror = true;
        this.setRotation(this.Stinger3, -0.8551081f, 0.0f, 0.0f);
        (this.LeftShoulder = new ModelRenderer((ModelBase) this, 69, 103)).addBox(-3.0f, -3.0f, -4.0f, 6, 6, 4);
        this.LeftShoulder.setRotationPoint(7.0f, 13.0f, -22.0f);
        this.LeftShoulder.setTextureSize(256, 128);
        this.LeftShoulder.mirror = true;
        this.setRotation(this.LeftShoulder, 0.0f, -0.8551081f, 0.0f);
        (this.LeftArmSeg1 = new ModelRenderer((ModelBase) this, 55, 0)).addBox(-3.0f, -3.0f, -10.0f, 4, 6, 13);
        this.LeftArmSeg1.setRotationPoint(10.0f, 13.0f, -24.0f);
        this.LeftArmSeg1.setTextureSize(256, 128);
        this.LeftArmSeg1.mirror = true;
        this.setRotation(this.LeftArmSeg1, 0.0f, -2.044824f, 0.0f);
        (this.LeftArmSeg2 = new ModelRenderer((ModelBase) this, 130, 0)).addBox(-7.0f, -3.0f, -17.0f, 8, 6, 17);
        this.LeftArmSeg2.setRotationPoint(19.0f, 13.0f, -22.0f);
        this.LeftArmSeg2.setTextureSize(256, 128);
        this.LeftArmSeg2.mirror = true;
        this.setRotation(this.LeftArmSeg2, 0.0f, -0.7435722f, 0.0f);
        (this.LeftArmSeg3 = new ModelRenderer((ModelBase) this, 130, 50)).addBox(-3.0f, -3.0f, -24.0f, 4, 6, 24);
        this.LeftArmSeg3.setRotationPoint(29.0f, 13.0f, -33.0f);
        this.LeftArmSeg3.setTextureSize(256, 128);
        this.LeftArmSeg3.mirror = true;
        this.setRotation(this.LeftArmSeg3, 0.0f, 0.3717861f, 0.0f);
        (this.LeftArmSeg4 = new ModelRenderer((ModelBase) this, 181, 0)).addBox(-3.0f, -3.0f, -14.0f, 8, 6, 12);
        this.LeftArmSeg4.setRotationPoint(29.0f, 13.0f, -33.0f);
        this.LeftArmSeg4.setTextureSize(256, 128);
        this.LeftArmSeg4.mirror = true;
        this.setRotation(this.LeftArmSeg4, 0.0f, 1.487144f, 0.0f);
        (this.RightShoulder = new ModelRenderer((ModelBase) this, 69, 103)).addBox(-3.0f, -3.0f, -4.0f, 6, 6, 4);
        this.RightShoulder.setRotationPoint(-7.0f, 13.0f, -22.0f);
        this.RightShoulder.setTextureSize(256, 128);
        this.RightShoulder.mirror = true;
        this.setRotation(this.RightShoulder, 0.0f, 0.8551066f, 0.0f);
        (this.RightArmSeg1 = new ModelRenderer((ModelBase) this, 55, 0)).addBox(-1.0f, -3.0f, -10.0f, 4, 6, 13);
        this.RightArmSeg1.setRotationPoint(-10.0f, 13.0f, -24.0f);
        this.RightArmSeg1.setTextureSize(256, 128);
        this.RightArmSeg1.mirror = true;
        this.setRotation(this.RightArmSeg1, 0.0f, 2.044828f, 0.0f);
        (this.RightArmSeg2 = new ModelRenderer((ModelBase) this, 130, 0)).addBox(-1.0f, -3.0f, -17.0f, 8, 6, 17);
        this.RightArmSeg2.setRotationPoint(-19.0f, 13.0f, -22.0f);
        this.RightArmSeg2.setTextureSize(256, 128);
        this.RightArmSeg2.mirror = true;
        this.setRotation(this.RightArmSeg2, 0.0f, 0.7435801f, 0.0f);
        (this.RightArmSeg3 = new ModelRenderer((ModelBase) this, 130, 50)).addBox(-1.0f, -3.0f, -24.0f, 4, 6, 24);
        this.RightArmSeg3.setRotationPoint(-29.0f, 13.0f, -33.0f);
        this.RightArmSeg3.setTextureSize(256, 128);
        this.RightArmSeg3.mirror = true;
        this.setRotation(this.RightArmSeg3, 0.0f, -0.37179f, 0.0f);
        (this.RightArmSeg4 = new ModelRenderer((ModelBase) this, 181, 0)).addBox(-5.0f, -3.0f, -14.0f, 8, 6, 12);
        this.RightArmSeg4.setRotationPoint(-29.0f, 13.0f, -33.0f);
        this.RightArmSeg4.setTextureSize(256, 128);
        this.RightArmSeg4.mirror = true;
        this.setRotation(this.RightArmSeg4, 0.0f, -1.487143f, 0.0f);
        (this.RightPincer = new ModelRenderer((ModelBase) this, 130, 24)).addBox(-1.0f, -3.0f, -19.0f, 2, 6, 19);
        this.RightPincer.setRotationPoint(-17.0f, 13.0f, -33.0f);
        this.RightPincer.setTextureSize(256, 128);
        this.RightPincer.mirror = true;
        this.setRotation(this.RightPincer, 0.0f, -0.0743611f, 0.0f);
        (this.LeftPincer = new ModelRenderer((ModelBase) this, 130, 24)).addBox(-1.0f, -3.0f, -19.0f, 2, 6, 19);
        this.LeftPincer.setRotationPoint(17.0f, 13.0f, -33.0f);
        this.LeftPincer.setTextureSize(256, 128);
        this.LeftPincer.mirror = true;
        this.setRotation(this.LeftPincer, 0.0f, 0.0743685f, 0.0f);
        (this.Lefteye = new ModelRenderer((ModelBase) this, 0, 113)).addBox(-0.5f, -5.0f, -7.5f, 3, 2, 3);
        this.Lefteye.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Lefteye.setTextureSize(256, 128);
        this.Lefteye.mirror = true;
        this.setRotation(this.Lefteye, 0.0f, 0.0f, 0.2974289f);
        (this.Righteye = new ModelRenderer((ModelBase) this, 0, 113)).addBox(-2.5f, -5.0f, -7.5f, 3, 2, 3);
        this.Righteye.setRotationPoint(0.0f, 13.0f, -8.0f);
        this.Righteye.setTextureSize(256, 128);
        this.Righteye.mirror = true;
        this.setRotation(this.Righteye, 0.0f, 0.0f, -0.2974216f);
        (this.RightMandible = new ModelRenderer((ModelBase) this, 76, 55)).addBox(-2.0f, -3.0f, -4.0f, 4, 4, 4);
        this.RightMandible.setRotationPoint(-2.0f, 13.0f, -23.0f);
        this.RightMandible.setTextureSize(256, 128);
        this.RightMandible.mirror = true;
        this.setRotation(this.RightMandible, 0.1115358f, 0.3346075f, 0.0f);
        (this.LeftMandible = new ModelRenderer((ModelBase) this, 76, 55)).addBox(-2.0f, -3.0f, -4.0f, 4, 4, 4);
        this.LeftMandible.setRotationPoint(2.0f, 13.0f, -23.0f);
        this.LeftMandible.setTextureSize(256, 128);
        this.LeftMandible.mirror = true;
        this.setRotation(this.LeftMandible, 0.111544f, -0.3346145f, 0.0f);
        (this.RightManPart2 = new ModelRenderer((ModelBase) this, 82, 64)).addBox(-0.5f, -0.5f, -6.0f, 1, 1, 6);
        this.RightManPart2.setRotationPoint(-3.0f, 11.0f, -26.0f);
        this.RightManPart2.setTextureSize(256, 128);
        this.RightManPart2.mirror = true;
        this.setRotation(this.RightManPart2, 1.189716f, 0.0f, 0.0f);
        (this.LeftManPart2 = new ModelRenderer((ModelBase) this, 82, 64)).addBox(-0.5f, -0.5f, -6.0f, 1, 1, 6);
        this.LeftManPart2.setRotationPoint(3.0f, 11.0f, -26.0f);
        this.LeftManPart2.setTextureSize(256, 128);
        this.LeftManPart2.mirror = true;
        this.setRotation(this.LeftManPart2, 1.188848f, 0.0f, 0.0f);
        (this.Leg1Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(0.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg1Seg1.setRotationPoint(9.0f, 13.0f, -10.0f);
        this.Leg1Seg1.setTextureSize(256, 128);
        this.Leg1Seg1.mirror = true;
        this.setRotation(this.Leg1Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg1Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg1Seg2.setRotationPoint(12.0f, 13.0f, -10.0f);
        this.Leg1Seg2.setTextureSize(256, 128);
        this.Leg1Seg2.mirror = true;
        this.setRotation(this.Leg1Seg2, 0.0f, 0.0f, -0.9294576f);
        (this.Leg1Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg1Seg3.setRotationPoint(18.0f, 3.0f, -10.0f);
        this.Leg1Seg3.setTextureSize(256, 128);
        this.Leg1Seg3.mirror = true;
        this.setRotation(this.Leg1Seg3, 0.0f, 0.0f, 0.6320361f);
        (this.Leg1Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(0.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg1Seg4.setRotationPoint(26.0f, 12.0f, -10.0f);
        this.Leg1Seg4.setTextureSize(256, 128);
        this.Leg1Seg4.mirror = true;
        this.setRotation(this.Leg1Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg1Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg1Seg5.setRotationPoint(27.0f, 19.0f, -10.0f);
        this.Leg1Seg5.setTextureSize(256, 128);
        this.Leg1Seg5.mirror = true;
        this.setRotation(this.Leg1Seg5, 0.0f, 0.0f, 0.669215f);
        (this.Leg2Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(0.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg2Seg1.setRotationPoint(8.5f, 13.0f, -4.0f);
        this.Leg2Seg1.setTextureSize(256, 128);
        this.Leg2Seg1.mirror = true;
        this.setRotation(this.Leg2Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg2Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg2Seg2.setRotationPoint(12.0f, 13.0f, -4.0f);
        this.Leg2Seg2.setTextureSize(256, 128);
        this.Leg2Seg2.mirror = true;
        this.setRotation(this.Leg2Seg2, 0.0f, 0.0f, -0.9294576f);
        (this.Leg2Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg2Seg3.setRotationPoint(18.0f, 3.0f, -4.0f);
        this.Leg2Seg3.setTextureSize(256, 128);
        this.Leg2Seg3.mirror = true;
        this.setRotation(this.Leg2Seg3, 0.0f, 0.0f, 0.6320361f);
        (this.Leg2Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(0.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg2Seg4.setRotationPoint(26.0f, 12.0f, -4.0f);
        this.Leg2Seg4.setTextureSize(256, 128);
        this.Leg2Seg4.mirror = true;
        this.setRotation(this.Leg2Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg2Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg2Seg5.setRotationPoint(27.0f, 19.0f, -4.0f);
        this.Leg2Seg5.setTextureSize(256, 128);
        this.Leg2Seg5.mirror = true;
        this.setRotation(this.Leg2Seg5, 0.0f, 0.0f, 0.669215f);
        (this.Leg3Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(0.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg3Seg1.setRotationPoint(9.5f, 13.0f, 2.0f);
        this.Leg3Seg1.setTextureSize(256, 128);
        this.Leg3Seg1.mirror = true;
        this.setRotation(this.Leg3Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg3Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg3Seg2.setRotationPoint(12.0f, 13.0f, 2.0f);
        this.Leg3Seg2.setTextureSize(256, 128);
        this.Leg3Seg2.mirror = true;
        this.setRotation(this.Leg3Seg2, 0.0f, 0.0f, -0.9294576f);
        (this.Leg3Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg3Seg3.setRotationPoint(18.0f, 3.0f, 2.0f);
        this.Leg3Seg3.setTextureSize(256, 128);
        this.Leg3Seg3.mirror = true;
        this.setRotation(this.Leg3Seg3, 0.0f, 0.0f, 0.6320361f);
        (this.Leg3Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(0.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg3Seg4.setRotationPoint(26.0f, 12.0f, 2.0f);
        this.Leg3Seg4.setTextureSize(256, 128);
        this.Leg3Seg4.mirror = true;
        this.setRotation(this.Leg3Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg3Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg3Seg5.setRotationPoint(27.0f, 19.0f, 2.0f);
        this.Leg3Seg5.setTextureSize(256, 128);
        this.Leg3Seg5.mirror = true;
        this.setRotation(this.Leg3Seg5, 0.0f, 0.0f, 0.669215f);
        (this.Leg4Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(0.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg4Seg1.setRotationPoint(9.0f, 13.0f, 8.0f);
        this.Leg4Seg1.setTextureSize(256, 128);
        this.Leg4Seg1.mirror = true;
        this.setRotation(this.Leg4Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg4Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg4Seg2.setRotationPoint(12.0f, 13.0f, 8.0f);
        this.Leg4Seg2.setTextureSize(256, 128);
        this.Leg4Seg2.mirror = true;
        this.setRotation(this.Leg4Seg2, 0.0f, 0.0f, -0.9294576f);
        (this.Leg4Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(0.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg4Seg3.setRotationPoint(18.0f, 3.0f, 8.0f);
        this.Leg4Seg3.setTextureSize(256, 128);
        this.Leg4Seg3.mirror = true;
        this.setRotation(this.Leg4Seg3, 0.0f, 0.0f, 0.6320361f);
        (this.Leg4Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(0.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg4Seg4.setRotationPoint(26.0f, 12.0f, 8.0f);
        this.Leg4Seg4.setTextureSize(256, 128);
        this.Leg4Seg4.mirror = true;
        this.setRotation(this.Leg4Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg4Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg4Seg5.setRotationPoint(27.0f, 19.0f, 8.0f);
        this.Leg4Seg5.setTextureSize(256, 128);
        this.Leg4Seg5.mirror = true;
        this.setRotation(this.Leg4Seg5, 0.0f, 0.0f, 0.669215f);
        (this.Leg5Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(-4.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg5Seg1.setRotationPoint(-9.0f, 13.0f, -10.0f);
        this.Leg5Seg1.setTextureSize(256, 128);
        this.Leg5Seg1.mirror = true;
        this.setRotation(this.Leg5Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg5Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg5Seg2.setRotationPoint(-12.0f, 14.0f, -10.0f);
        this.Leg5Seg2.setTextureSize(256, 128);
        this.Leg5Seg2.mirror = true;
        this.setRotation(this.Leg5Seg2, 0.0f, 0.0f, 0.9294653f);
        (this.Leg5Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg5Seg3.setRotationPoint(-18.0f, 4.0f, -10.0f);
        this.Leg5Seg3.setTextureSize(256, 128);
        this.Leg5Seg3.mirror = true;
        this.setRotation(this.Leg5Seg3, 0.0f, 0.0f, -0.6320364f);
        (this.Leg5Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(-3.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg5Seg4.setRotationPoint(-26.0f, 12.0f, -10.0f);
        this.Leg5Seg4.setTextureSize(256, 128);
        this.Leg5Seg4.mirror = true;
        this.setRotation(this.Leg5Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg5Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg5Seg5.setRotationPoint(-27.0f, 19.0f, -10.0f);
        this.Leg5Seg5.setTextureSize(256, 128);
        this.Leg5Seg5.mirror = true;
        this.setRotation(this.Leg5Seg5, 0.0f, 0.0f, 2.240008f);
        (this.Leg6Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(-4.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg6Seg1.setRotationPoint(-8.5f, 13.0f, -4.0f);
        this.Leg6Seg1.setTextureSize(256, 128);
        this.Leg6Seg1.mirror = true;
        this.setRotation(this.Leg6Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg6Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg6Seg2.setRotationPoint(-12.0f, 14.0f, -4.0f);
        this.Leg6Seg2.setTextureSize(256, 128);
        this.Leg6Seg2.mirror = true;
        this.setRotation(this.Leg6Seg2, 0.0f, 0.0f, 0.9294576f);
        (this.Leg6Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg6Seg3.setRotationPoint(-18.0f, 4.0f, -4.0f);
        this.Leg6Seg3.setTextureSize(256, 128);
        this.Leg6Seg3.mirror = true;
        this.setRotation(this.Leg6Seg3, 0.0f, 0.0f, -0.6320361f);
        (this.Leg6Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(-3.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg6Seg4.setRotationPoint(-26.0f, 12.0f, -4.0f);
        this.Leg6Seg4.setTextureSize(256, 128);
        this.Leg6Seg4.mirror = true;
        this.setRotation(this.Leg6Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg6Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg6Seg5.setRotationPoint(-27.0f, 19.0f, -4.0f);
        this.Leg6Seg5.setTextureSize(256, 128);
        this.Leg6Seg5.mirror = true;
        this.setRotation(this.Leg6Seg5, 0.0f, 0.0f, 2.240008f);
        (this.Leg7Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(-4.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg7Seg1.setRotationPoint(-9.5f, 13.0f, 2.0f);
        this.Leg7Seg1.setTextureSize(256, 128);
        this.Leg7Seg1.mirror = true;
        this.setRotation(this.Leg7Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg7Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg7Seg2.setRotationPoint(-12.0f, 14.0f, 2.0f);
        this.Leg7Seg2.setTextureSize(256, 128);
        this.Leg7Seg2.mirror = true;
        this.setRotation(this.Leg7Seg2, 0.0f, 0.0f, 0.9294576f);
        (this.Leg7Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg7Seg3.setRotationPoint(-18.0f, 4.0f, 2.0f);
        this.Leg7Seg3.setTextureSize(256, 128);
        this.Leg7Seg3.mirror = true;
        this.setRotation(this.Leg7Seg3, 0.0f, 0.0f, -0.6320361f);
        (this.Leg7Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(-3.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg7Seg4.setRotationPoint(-26.0f, 12.0f, 2.0f);
        this.Leg7Seg4.setTextureSize(256, 128);
        this.Leg7Seg4.mirror = true;
        this.setRotation(this.Leg7Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg7Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg7Seg5.setRotationPoint(-27.0f, 19.0f, 2.0f);
        this.Leg7Seg5.setTextureSize(256, 128);
        this.Leg7Seg5.mirror = true;
        this.setRotation(this.Leg7Seg5, 0.0f, 0.0f, 2.240008f);
        (this.Leg8Seg1 = new ModelRenderer((ModelBase) this, 20, 20)).addBox(-4.0f, -1.5f, -2.0f, 4, 3, 4);
        this.Leg8Seg1.setRotationPoint(-9.0f, 13.0f, 8.0f);
        this.Leg8Seg1.setTextureSize(256, 128);
        this.Leg8Seg1.mirror = true;
        this.setRotation(this.Leg8Seg1, 0.0f, 0.0f, 0.0f);
        (this.Leg8Seg2 = new ModelRenderer((ModelBase) this, 21, 0)).addBox(-12.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg8Seg2.setRotationPoint(-12.0f, 14.0f, 8.0f);
        this.Leg8Seg2.setTextureSize(256, 128);
        this.Leg8Seg2.mirror = true;
        this.setRotation(this.Leg8Seg2, 0.0f, 0.0f, 0.9294576f);
        (this.Leg8Seg3 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(-13.0f, -1.5f, -1.5f, 13, 3, 3);
        this.Leg8Seg3.setRotationPoint(-18.0f, 4.0f, 8.0f);
        this.Leg8Seg3.setTextureSize(256, 128);
        this.Leg8Seg3.mirror = true;
        this.setRotation(this.Leg8Seg3, 0.0f, 0.0f, -0.6320361f);
        (this.Leg8Seg4 = new ModelRenderer((ModelBase) this, 0, 14)).addBox(-3.0f, -1.5f, -1.5f, 3, 10, 3);
        this.Leg8Seg4.setRotationPoint(-26.0f, 12.0f, 8.0f);
        this.Leg8Seg4.setTextureSize(256, 128);
        this.Leg8Seg4.mirror = true;
        this.setRotation(this.Leg8Seg4, 0.0f, 0.0f, 0.0f);
        (this.Leg8Seg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -1.5f, 7, 3, 3);
        this.Leg8Seg5.setRotationPoint(-27.0f, 19.0f, 8.0f);
        this.Leg8Seg5.setTextureSize(256, 128);
        this.Leg8Seg5.mirror = true;
        this.setRotation(this.Leg8Seg5, 0.0f, 0.0f, 2.240008f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final EmperorScorpion e = (EmperorScorpion) entity;
        RenderInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float upangle = 0.0f;
        float nextangle = 0.0f;
        final float pi4 = 1.570795f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        upangle = 0.0f;
        if (nextangle > newangle) {
            upangle = 0.47f * f1 - Math.abs(newangle);
        }
        this.doLeftLeg(this.Leg1Seg1, this.Leg1Seg2, this.Leg1Seg3, this.Leg1Seg4, this.Leg1Seg5, newangle, upangle);
        this.doRightLeg(this.Leg5Seg1, this.Leg5Seg2, this.Leg5Seg3, this.Leg5Seg4, this.Leg5Seg5, -newangle, upangle);
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed - 1.0f * pi4) * 3.1415927f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed - 1.0f * pi4) * 3.1415927f * 0.12f * f1;
        upangle = 0.0f;
        if (nextangle > newangle) {
            upangle = 0.47f * f1 - Math.abs(newangle);
        }
        this.doLeftLeg(this.Leg2Seg1, this.Leg2Seg2, this.Leg2Seg3, this.Leg2Seg4, this.Leg2Seg5, newangle, upangle);
        this.doRightLeg(this.Leg6Seg1, this.Leg6Seg2, this.Leg6Seg3, this.Leg6Seg4, this.Leg6Seg5, -newangle, upangle);
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed - 2.0f * pi4) * 3.1415927f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed - 2.0f * pi4) * 3.1415927f * 0.12f * f1;
        upangle = 0.0f;
        if (nextangle > newangle) {
            upangle = 0.47f * f1 - Math.abs(newangle);
        }
        this.doLeftLeg(this.Leg3Seg1, this.Leg3Seg2, this.Leg3Seg3, this.Leg3Seg4, this.Leg3Seg5, newangle, upangle);
        this.doRightLeg(this.Leg7Seg1, this.Leg7Seg2, this.Leg7Seg3, this.Leg7Seg4, this.Leg7Seg5, -newangle, upangle);
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed - 3.0f * pi4) * 3.1415927f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed - 3.0f * pi4) * 3.1415927f * 0.12f * f1;
        upangle = 0.0f;
        if (nextangle > newangle) {
            upangle = 0.47f * f1 - Math.abs(newangle);
        }
        this.doLeftLeg(this.Leg4Seg1, this.Leg4Seg2, this.Leg4Seg3, this.Leg4Seg4, this.Leg4Seg5, newangle, upangle);
        this.doRightLeg(this.Leg8Seg1, this.Leg8Seg2, this.Leg8Seg3, this.Leg8Seg4, this.Leg8Seg5, -newangle, upangle);
        if (e.getAttacking() == 0) {
            newangle = MathHelper.cos(f2 * 0.5f * this.wingspeed) * 3.1415927f * 0.05f;
        } else {
            newangle = MathHelper.cos(f2 * 2.5f * this.wingspeed) * 3.1415927f * 0.15f;
        }
        this.LeftManPart2.rotateAngleZ = newangle;
        this.RightManPart2.rotateAngleZ = -newangle;
        r = e.getRenderInfo();
        newangle = MathHelper.cos(f2 * 3.0f * this.wingspeed) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.1f) * 3.0f * this.wingspeed) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() == 0) {
                r.ri1 = e.worldObj.rand.nextInt(20);
                r.ri2 = e.worldObj.rand.nextInt(25);
            } else {
                r.ri1 = e.worldObj.rand.nextInt(4);
                r.ri2 = e.worldObj.rand.nextInt(3);
            }
        }
        if (r.ri1 == 1 || r.ri1 == 3) {
            this.doLeftClaw(newangle);
        } else {
            this.doLeftClaw(0.0f);
        }
        if (r.ri1 == 2 || r.ri1 == 3) {
            this.doRightClaw(newangle);
        } else {
            this.doRightClaw(0.0f);
        }
        if (r.ri2 == 1) {
            this.doTail(newangle);
        } else {
            this.doTail(0.0f);
        }
        e.setRenderInfo(r);
        this.Head.render(f5);
        this.Seg1.render(f5);
        this.Seg2.render(f5);
        this.Seg3.render(f5);
        this.Seg4.render(f5);
        this.Seg5.render(f5);
        this.Seg6.render(f5);
        this.Seg7.render(f5);
        this.Seg8.render(f5);
        this.Tailseg1.render(f5);
        this.Tailseg2.render(f5);
        this.Tailseg3.render(f5);
        this.Tailseg4.render(f5);
        this.Tailseg5.render(f5);
        this.Tailseg6.render(f5);
        this.Tailseg7.render(f5);
        this.Tailseg8.render(f5);
        this.Stinger1.render(f5);
        this.Stinger2.render(f5);
        this.Stinger3.render(f5);
        this.LeftShoulder.render(f5);
        this.LeftArmSeg1.render(f5);
        this.LeftArmSeg2.render(f5);
        this.LeftArmSeg3.render(f5);
        this.LeftArmSeg4.render(f5);
        this.RightShoulder.render(f5);
        this.RightArmSeg1.render(f5);
        this.RightArmSeg2.render(f5);
        this.RightArmSeg3.render(f5);
        this.RightArmSeg4.render(f5);
        this.RightPincer.render(f5);
        this.LeftPincer.render(f5);
        this.Lefteye.render(f5);
        this.Righteye.render(f5);
        this.RightMandible.render(f5);
        this.LeftMandible.render(f5);
        this.RightManPart2.render(f5);
        this.LeftManPart2.render(f5);
        this.Leg1Seg1.render(f5);
        this.Leg1Seg2.render(f5);
        this.Leg1Seg3.render(f5);
        this.Leg1Seg4.render(f5);
        this.Leg1Seg5.render(f5);
        this.Leg2Seg1.render(f5);
        this.Leg2Seg2.render(f5);
        this.Leg2Seg3.render(f5);
        this.Leg2Seg4.render(f5);
        this.Leg2Seg5.render(f5);
        this.Leg3Seg1.render(f5);
        this.Leg3Seg2.render(f5);
        this.Leg3Seg3.render(f5);
        this.Leg3Seg4.render(f5);
        this.Leg3Seg5.render(f5);
        this.Leg4Seg1.render(f5);
        this.Leg4Seg2.render(f5);
        this.Leg4Seg3.render(f5);
        this.Leg4Seg4.render(f5);
        this.Leg4Seg5.render(f5);
        this.Leg5Seg1.render(f5);
        this.Leg5Seg2.render(f5);
        this.Leg5Seg3.render(f5);
        this.Leg5Seg4.render(f5);
        this.Leg5Seg5.render(f5);
        this.Leg6Seg1.render(f5);
        this.Leg6Seg2.render(f5);
        this.Leg6Seg3.render(f5);
        this.Leg6Seg4.render(f5);
        this.Leg6Seg5.render(f5);
        this.Leg7Seg1.render(f5);
        this.Leg7Seg2.render(f5);
        this.Leg7Seg3.render(f5);
        this.Leg7Seg4.render(f5);
        this.Leg7Seg5.render(f5);
        this.Leg8Seg1.render(f5);
        this.Leg8Seg2.render(f5);
        this.Leg8Seg3.render(f5);
        this.Leg8Seg4.render(f5);
        this.Leg8Seg5.render(f5);
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

    private void doLeftLeg(final ModelRenderer seg1, final ModelRenderer seg2, final ModelRenderer seg3,
        final ModelRenderer seg4, final ModelRenderer seg5, final float angle, final float upangle) {
        seg2.rotateAngleY = angle;
        seg3.rotateAngleY = angle;
        seg4.rotateAngleY = angle;
        seg5.rotateAngleY = angle;
        seg3.rotationPointZ = (float) (seg2.rotationPointZ - Math.sin(angle) * 6.0);
        seg3.rotationPointX = (float) (seg2.rotationPointX - Math.abs(Math.sin(angle) * 6.0) + 6.0);
        seg4.rotationPointZ = (float) (seg3.rotationPointZ - Math.sin(angle) * 9.0);
        seg4.rotationPointX = (float) (seg3.rotationPointX - Math.abs(Math.sin(angle) * 9.0) + 9.0);
        seg5.rotationPointZ = (float) (seg4.rotationPointZ - Math.sin(angle) * 1.0);
        seg5.rotationPointX = (float) (seg4.rotationPointX - Math.abs(Math.sin(angle) * 1.0) + 1.0);
        seg2.rotateAngleZ = -upangle - 0.929f;
        seg3.rotateAngleZ = -upangle + 0.632f;
        seg3.rotationPointY = seg2.rotationPointY + (float) (11.5 * Math.sin(seg2.rotateAngleZ));
        seg4.rotationPointY = seg3.rotationPointY + (float) (11.5 * Math.sin(seg3.rotateAngleZ));
        seg5.rotationPointY = seg4.rotationPointY + 6.5f;
    }

    private void doRightLeg(final ModelRenderer seg1, final ModelRenderer seg2, final ModelRenderer seg3,
        final ModelRenderer seg4, final ModelRenderer seg5, final float angle, final float upangle) {
        seg2.rotateAngleY = angle;
        seg3.rotateAngleY = angle;
        seg4.rotateAngleY = angle;
        seg5.rotateAngleY = -angle;
        seg3.rotationPointZ = (float) (seg2.rotationPointZ + Math.sin(angle) * 6.0);
        seg3.rotationPointX = (float) (seg2.rotationPointX + Math.abs(Math.sin(angle) * 6.0) - 6.0);
        seg4.rotationPointZ = (float) (seg3.rotationPointZ + Math.sin(angle) * 9.0);
        seg4.rotationPointX = (float) (seg3.rotationPointX + Math.abs(Math.sin(angle) * 9.0) - 9.0);
        seg5.rotationPointZ = (float) (seg4.rotationPointZ + Math.sin(angle) * 1.0);
        seg5.rotationPointX = (float) (seg4.rotationPointX + Math.abs(Math.sin(angle) * 1.0) - 1.0);
        seg2.rotateAngleZ = upangle + 0.929f;
        seg3.rotateAngleZ = upangle - 0.632f;
        seg3.rotationPointY = seg2.rotationPointY - (float) (11.5 * Math.sin(seg2.rotateAngleZ));
        seg4.rotationPointY = seg3.rotationPointY - (float) (11.5 * Math.sin(seg3.rotateAngleZ));
        seg5.rotationPointY = seg4.rotationPointY + 6.5f;
    }

    private void doLeftClaw(final float angle) {
        this.LeftArmSeg1.rotateAngleY = -1.57f + angle;
        this.LeftArmSeg2.rotationPointZ = (float) (-22.0 - Math.cos(this.LeftArmSeg1.rotateAngleY) * 12.0);
        this.LeftArmSeg3.rotationPointZ = this.LeftArmSeg2.rotationPointZ - 11.0f;
        this.LeftArmSeg4.rotationPointZ = this.LeftArmSeg2.rotationPointZ - 11.0f;
        this.LeftPincer.rotationPointZ = this.LeftArmSeg2.rotationPointZ - 11.0f;
        this.LeftArmSeg3.rotateAngleY = 0.074f + angle;
        this.LeftPincer.rotateAngleY = 0.371f - angle;
    }

    private void doRightClaw(final float angle) {
        this.RightArmSeg1.rotateAngleY = 1.57f - angle;
        this.RightArmSeg2.rotationPointZ = (float) (-22.0 - Math.cos(this.RightArmSeg1.rotateAngleY) * 12.0);
        this.RightArmSeg3.rotationPointZ = this.RightArmSeg2.rotationPointZ - 11.0f;
        this.RightArmSeg4.rotationPointZ = this.RightArmSeg2.rotationPointZ - 11.0f;
        this.RightPincer.rotationPointZ = this.RightArmSeg2.rotationPointZ - 11.0f;
        this.RightArmSeg3.rotateAngleY = -0.074f - angle;
        this.RightPincer.rotateAngleY = -0.371f + angle;
    }

    private void doTail(final float angle) {
        this.Tailseg1.rotateAngleX = 0.594f + angle;
        this.Tailseg2.rotateAngleX = this.Tailseg1.rotateAngleX + 0.48399997f + angle;
        this.Tailseg2.rotationPointY = (float) (this.Tailseg1.rotationPointY
            - Math.sin(this.Tailseg1.rotateAngleX) * 9.0);
        this.Tailseg2.rotationPointZ = (float) (this.Tailseg1.rotationPointZ
            + Math.cos(this.Tailseg1.rotateAngleX) * 9.0);
        this.Tailseg3.rotateAngleX = this.Tailseg2.rotateAngleX + 0.6320001f + angle;
        this.Tailseg3.rotationPointY = (float) (this.Tailseg2.rotationPointY
            - Math.sin(this.Tailseg2.rotateAngleX) * 10.0);
        this.Tailseg3.rotationPointZ = (float) (this.Tailseg2.rotationPointZ
            + Math.cos(this.Tailseg2.rotateAngleX) * 10.0);
        this.Tailseg4.rotateAngleX = this.Tailseg3.rotateAngleX + 0.5569999f - angle;
        this.Tailseg4.rotationPointY = (float) (this.Tailseg3.rotationPointY
            - Math.sin(this.Tailseg3.rotateAngleX) * 10.0);
        this.Tailseg4.rotationPointZ = (float) (this.Tailseg3.rotationPointZ
            + Math.cos(this.Tailseg3.rotateAngleX) * 10.0);
        this.Tailseg5.rotateAngleX = this.Tailseg4.rotateAngleX + 0.63199997f - angle;
        this.Tailseg5.rotationPointY = (float) (this.Tailseg4.rotationPointY
            - Math.sin(this.Tailseg4.rotateAngleX) * 10.0);
        this.Tailseg5.rotationPointZ = (float) (this.Tailseg4.rotationPointZ
            + Math.cos(this.Tailseg4.rotateAngleX) * 10.0);
        this.Tailseg6.rotateAngleX = this.Tailseg5.rotateAngleX - 5.501f - angle * 3.0f / 2.0f - 0.4f;
        this.Tailseg6.rotationPointY = (float) (this.Tailseg5.rotationPointY
            - Math.sin(this.Tailseg5.rotateAngleX) * 10.0);
        this.Tailseg6.rotationPointZ = (float) (this.Tailseg5.rotationPointZ
            + Math.cos(this.Tailseg5.rotateAngleX) * 10.0);
        this.Tailseg7.rotateAngleX = this.Tailseg6.rotateAngleX - 2.822f - angle * 2.5f - 2.2f;
        this.Tailseg7.rotationPointY = (float) (this.Tailseg6.rotationPointY
            - Math.sin(this.Tailseg6.rotateAngleX) * 10.0);
        this.Tailseg7.rotationPointZ = (float) (this.Tailseg6.rotationPointZ
            + Math.cos(this.Tailseg6.rotateAngleX) * 10.0);
        this.Tailseg8.rotateAngleX = this.Tailseg7.rotateAngleX;
        this.Tailseg8.rotationPointY = this.Tailseg7.rotationPointY;
        this.Tailseg8.rotationPointZ = this.Tailseg7.rotationPointZ;
        this.Stinger1.rotateAngleX = this.Tailseg7.rotateAngleX + 0.0f + angle * 0.66f;
        this.Stinger1.rotationPointY = (float) (this.Tailseg7.rotationPointY
            - Math.sin(this.Tailseg7.rotateAngleX) * 10.0);
        this.Stinger1.rotationPointZ = (float) (this.Tailseg7.rotationPointZ
            + Math.cos(this.Tailseg7.rotateAngleX) * 10.0);
        this.Stinger2.rotateAngleX = this.Stinger1.rotateAngleX - 0.48f + angle;
        this.Stinger2.rotationPointY = (float) (this.Stinger1.rotationPointY
            - Math.sin(this.Stinger1.rotateAngleX) * 3.0);
        this.Stinger2.rotationPointZ = (float) (this.Stinger1.rotationPointZ
            + Math.cos(this.Stinger1.rotateAngleX) * 3.0);
        this.Stinger3.rotateAngleX = this.Stinger2.rotateAngleX - 1.01f + angle * 1.7f;
        this.Stinger3.rotationPointY = (float) (this.Stinger2.rotationPointY
            - Math.sin(this.Stinger2.rotateAngleX) * 3.0);
        this.Stinger3.rotationPointZ = (float) (this.Stinger2.rotationPointZ
            + Math.cos(this.Stinger2.rotateAngleX) * 3.0);
    }
}
