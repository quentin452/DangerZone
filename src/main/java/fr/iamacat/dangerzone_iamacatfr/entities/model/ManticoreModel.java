
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.ManticoreInstance;

public class ManticoreModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Body5;
    ModelRenderer Body6;
    ModelRenderer Body7;
    ModelRenderer Body8;
    ModelRenderer Body10;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer Tail7;
    ModelRenderer Tail8;
    ModelRenderer Tail9;
    ModelRenderer Tail10;
    ModelRenderer Tail11;
    ModelRenderer StingerNest;
    ModelRenderer Stinger1;
    ModelRenderer Stinger2ByTwilicornOrHurricaneSHL;
    ModelRenderer Body1;
    ModelRenderer Neck;
    ModelRenderer ManeTop;
    ModelRenderer ManeLeftTop;
    ModelRenderer ManeRightTop;
    ModelRenderer ManeLeft;
    ModelRenderer ManeRight;
    ModelRenderer Head;
    ModelRenderer ManeLeftBottom;
    ModelRenderer ManeRightBottom;
    ModelRenderer Face;
    ModelRenderer Jaws;
    ModelRenderer EarL;
    ModelRenderer EarR;
    ModelRenderer Nose;
    ModelRenderer TeethL;
    ModelRenderer TeethR;
    ModelRenderer ManeBackTop;
    ModelRenderer ManeBackLeft;
    ModelRenderer ManeRightBack;
    ModelRenderer FrontLegSegment;
    ModelRenderer FLL1;
    ModelRenderer FLR1;
    ModelRenderer FLL2;
    ModelRenderer FLR2;
    ModelRenderer FLL3;
    ModelRenderer FLR3;
    ModelRenderer FLL4;
    ModelRenderer FLR4;
    ModelRenderer FLL5;
    ModelRenderer FLR5;
    ModelRenderer C6;
    ModelRenderer C5;
    ModelRenderer C4;
    ModelRenderer C7;
    ModelRenderer C9;
    ModelRenderer C11;
    ModelRenderer C2;
    ModelRenderer C3;
    ModelRenderer C1;
    ModelRenderer C8;
    ModelRenderer C12;
    ModelRenderer C10;
    ModelRenderer EyeR;
    ModelRenderer EyeL;
    ModelRenderer BackLegSegment;
    ModelRenderer BLL1;
    ModelRenderer BLR1;
    ModelRenderer BLR2;
    ModelRenderer BLL2;
    ModelRenderer BLR3;
    ModelRenderer BLL3;
    ModelRenderer BLL4;
    ModelRenderer BLR4;
    ModelRenderer BLR5;
    ModelRenderer BLL5;
    ModelRenderer WindL1;
    ModelRenderer WindL2;
    ModelRenderer WindL3;
    ModelRenderer WindL4;
    ModelRenderer WingL5;
    ModelRenderer WindR2;
    ModelRenderer WingR1;
    ModelRenderer WindR3;
    ModelRenderer WindR4;
    ModelRenderer WindR5;
    ModelRenderer WindL6;
    ModelRenderer WindL8;
    ModelRenderer WindL7;
    ModelRenderer WindR6;
    ModelRenderer WindR8;
    ModelRenderer WindR7;
    ModelRenderer WindR9;
    ModelRenderer WindL9;

    public ManticoreModel() {
        this.wingspeed = 1.0f;
        this.textureWidth = 2048;
        this.textureHeight = 2048;
        (this.Body2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 30, 20);
        this.Body2.setRotationPoint(-20.0f, -32.0f, 0.0f);
        this.Body2.setTextureSize(64, 32);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 38, 28, 20);
        this.Body3.setRotationPoint(-19.0f, -31.0f, 9.0f);
        this.Body3.setTextureSize(64, 32);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 36, 26, 20);
        this.Body4.setRotationPoint(-18.0f, -30.0f, 16.0f);
        this.Body4.setTextureSize(64, 32);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 0.0f, 0.0f, 0.0f);
        (this.Body5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 34, 24, 20);
        this.Body5.setRotationPoint(-17.0f, -29.0f, 24.0f);
        this.Body5.setTextureSize(64, 32);
        this.Body5.mirror = true;
        this.setRotation(this.Body5, 0.0f, 0.0f, 0.0f);
        (this.Body6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 32, 22, 20);
        this.Body6.setRotationPoint(-17.0f, -28.0f, 30.0f);
        this.Body6.setTextureSize(64, 32);
        this.Body6.mirror = true;
        this.setRotation(this.Body6, 0.0f, 0.0f, 0.0f);
        (this.Body7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 30, 20, 20);
        this.Body7.setRotationPoint(-16.0f, -27.0f, 36.0f);
        this.Body7.setTextureSize(64, 32);
        this.Body7.mirror = true;
        this.setRotation(this.Body7, 0.0174533f, 0.0f, 0.0f);
        (this.Body8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 28, 18, 20);
        this.Body8.setRotationPoint(-15.0f, -26.0f, 41.0f);
        this.Body8.setTextureSize(64, 32);
        this.Body8.mirror = true;
        this.setRotation(this.Body8, 0.0349066f, 0.0f, 0.0f);
        (this.Body10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 24, 16, 20);
        this.Body10.setRotationPoint(-13.0f, -25.0f, 44.0f);
        this.Body10.setTextureSize(64, 32);
        this.Body10.mirror = true;
        this.setRotation(this.Body10, 0.0698132f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 22, 14, 20);
        this.Tail1.setRotationPoint(-12.0f, -25.0f, 50.0f);
        this.Tail1.setTextureSize(64, 32);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.1047198f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 18, 12, 20);
        this.Tail2.setRotationPoint(-10.0f, -25.0f, 55.0f);
        this.Tail2.setTextureSize(64, 32);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.1745329f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 16, 12, 20);
        this.Tail3.setRotationPoint(-9.0f, -28.0f, 72.0f);
        this.Tail3.setTextureSize(64, 32);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.3839724f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 14, 10, 20);
        this.Tail4.setRotationPoint(-8.0f, -31.0f, 87.0f);
        this.Tail4.setTextureSize(64, 32);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.7853982f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 12, 10, 20);
        this.Tail5.setRotationPoint(-7.0f, -42.0f, 99.0f);
        this.Tail5.setTextureSize(64, 32);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 1.099557f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 10, 10, 20);
        this.Tail6.setRotationPoint(-6.0f, -54.0f, 106.0f);
        this.Tail6.setTextureSize(64, 32);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 1.500983f, 0.0f, 0.0f);
        (this.Tail7 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 10, 10, 20);
        this.Tail7.setRotationPoint(-6.0f, -69.0f, 107.0f);
        this.Tail7.setTextureSize(64, 32);
        this.Tail7.mirror = true;
        this.setRotation(this.Tail7, 1.745329f, 0.0f, 0.0f);
        (this.Tail8 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 20);
        this.Tail8.setRotationPoint(-5.0f, -83.0f, 106.0f);
        this.Tail8.setTextureSize(64, 32);
        this.Tail8.mirror = true;
        this.setRotation(this.Tail8, 2.146755f, 0.0f, 0.0f);
        (this.Tail9 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 20);
        this.Tail9.setRotationPoint(-5.0f, -96.0f, 99.0f);
        this.Tail9.setTextureSize(64, 32);
        this.Tail9.mirror = true;
        this.setRotation(this.Tail9, 2.600541f, 0.0f, 0.0f);
        (this.Tail10 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 20);
        this.Tail10.setRotationPoint(-5.0f, -106.0f, 85.0f);
        this.Tail10.setTextureSize(64, 32);
        this.Tail10.mirror = true;
        this.setRotation(this.Tail10, 2.96706f, 0.0f, 0.0f);
        (this.Tail11 = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 20);
        this.Tail11.setRotationPoint(-5.0f, -110.0f, 70.0f);
        this.Tail11.setTextureSize(64, 32);
        this.Tail11.mirror = true;
        this.setRotation(this.Tail11, 3.141593f, 0.0f, 0.0f);
        (this.StingerNest = new ModelRenderer((ModelBase) this, 0, 444)).addBox(0.0f, 0.0f, 0.0f, 10, 15, 10);
        this.StingerNest.setRotationPoint(-6.0f, -119.0f, 51.0f);
        this.StingerNest.setTextureSize(64, 32);
        this.StingerNest.mirror = true;
        this.setRotation(this.StingerNest, -0.3346075f, 0.0f, 0.0f);
        (this.Stinger1 = new ModelRenderer((ModelBase) this, 0, 555)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.Stinger1.setRotationPoint(-1.5f, -106.0f, 51.0f);
        this.Stinger1.setTextureSize(64, 32);
        this.Stinger1.mirror = true;
        this.setRotation(this.Stinger1, 0.0f, 0.0f, 0.0f);
        (this.Stinger2ByTwilicornOrHurricaneSHL = new ModelRenderer((ModelBase) this, 0, 555))
            .addBox(0.0f, 0.0f, 0.0f, 1, 6, 1);
        this.Stinger2ByTwilicornOrHurricaneSHL.setRotationPoint(-1.5f, -97.0f, 51.0f);
        this.Stinger2ByTwilicornOrHurricaneSHL.setTextureSize(64, 32);
        this.Stinger2ByTwilicornOrHurricaneSHL.mirror = true;
        this.setRotation(this.Stinger2ByTwilicornOrHurricaneSHL, -1.07818f, 0.0f, 0.0f);
        (this.Body1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 30, 20);
        this.Body1.setRotationPoint(-20.0f, -32.0f, -19.0f);
        this.Body1.setTextureSize(64, 32);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, 0.0f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 26, 26, 20);
        this.Neck.setRotationPoint(-13.0f, -30.0f, -34.0f);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.ManeTop = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 24, 14, 20);
        this.ManeTop.setRotationPoint(-12.0f, -46.0f, -44.0f);
        this.ManeTop.setTextureSize(64, 32);
        this.ManeTop.mirror = true;
        this.setRotation(this.ManeTop, 0.0f, 0.0f, 0.0f);
        (this.ManeLeftTop = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 14, 20);
        this.ManeLeftTop.setRotationPoint(12.0f, -46.0f, -44.0f);
        this.ManeLeftTop.setTextureSize(64, 32);
        this.ManeLeftTop.mirror = true;
        this.setRotation(this.ManeLeftTop, 0.0f, 0.0f, 0.7435722f);
        (this.ManeRightTop = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 14, 20);
        this.ManeRightTop.setRotationPoint(-26.6f, -32.5f, -44.0f);
        this.ManeRightTop.setTextureSize(64, 32);
        this.ManeRightTop.mirror = true;
        this.setRotation(this.ManeRightTop, 0.0f, 0.0f, -0.7435801f);
        (this.ManeLeft = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 14, 18, 20);
        this.ManeLeft.setRotationPoint(12.0f, -32.0f, -44.0f);
        this.ManeLeft.setTextureSize(64, 32);
        this.ManeLeft.mirror = true;
        this.setRotation(this.ManeLeft, 0.0f, 0.0f, 0.0f);
        (this.ManeRight = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 14, 18, 20);
        this.ManeRight.setRotationPoint(-26.0f, -32.0f, -44.0f);
        this.ManeRight.setTextureSize(64, 32);
        this.ManeRight.mirror = true;
        this.setRotation(this.ManeRight, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 12, 10);
        this.Head.setRotationPoint(-9.0f, -34.0f, -52.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.ManeLeftBottom = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 18, 20);
        this.ManeLeftBottom.setRotationPoint(13.0f, -20.0f, -44.0f);
        this.ManeLeftBottom.setTextureSize(64, 32);
        this.ManeLeftBottom.mirror = true;
        this.setRotation(this.ManeLeftBottom, 0.0f, 0.0f, 0.2792527f);
        (this.ManeRightBottom = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 18, 20);
        this.ManeRightBottom.setRotationPoint(-22.0f, -17.0f, -44.0f);
        this.ManeRightBottom.setTextureSize(64, 32);
        this.ManeRightBottom.mirror = true;
        this.setRotation(this.ManeRightBottom, 0.0f, 0.0f, -0.2792527f);
        (this.Face = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 14, 15, 18);
        this.Face.setRotationPoint(-6.0f, -23.0f, -51.0f);
        this.Face.setTextureSize(64, 32);
        this.Face.mirror = true;
        this.setRotation(this.Face, 0.0f, 0.0f, 0.0f);
        (this.Jaws = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 14, 10);
        this.Jaws.setRotationPoint(-7.0f, -11.0f, -54.0f);
        this.Jaws.setTextureSize(64, 32);
        this.Jaws.mirror = true;
        this.setRotation(this.Jaws, 0.0f, 0.0f, 0.0f);
        (this.EarL = new ModelRenderer((ModelBase) this, 1000, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 10, 10);
        this.EarL.setRotationPoint(7.0f, -41.0f, -52.0f);
        this.EarL.setTextureSize(64, 32);
        this.EarL.mirror = true;
        this.setRotation(this.EarL, 0.0f, 0.0f, 0.0523599f);
        (this.EarR = new ModelRenderer((ModelBase) this, 1000, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 10, 10);
        this.EarR.setRotationPoint(-10.0f, -41.0f, -52.0f);
        this.EarR.setTextureSize(64, 32);
        this.EarR.mirror = true;
        this.setRotation(this.EarR, 0.0f, 0.0f, -0.0523599f);
        (this.Nose = new ModelRenderer((ModelBase) this, 0, 80)).addBox(0.0f, 0.0f, 0.0f, 6, 14, 8);
        this.Nose.setRotationPoint(-2.0f, -27.0f, -53.0f);
        this.Nose.setTextureSize(64, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, -0.2602503f, 0.0f, 0.0f);
        (this.TeethL = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 2);
        this.TeethL.setRotationPoint(6.0f, -18.0f, -53.0f);
        this.TeethL.setTextureSize(64, 32);
        this.TeethL.mirror = true;
        this.setRotation(this.TeethL, 0.0f, 0.0f, 0.0f);
        (this.TeethR = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 2);
        this.TeethR.setRotationPoint(-6.0f, -18.0f, -53.0f);
        this.TeethR.setTextureSize(64, 32);
        this.TeethR.mirror = true;
        this.setRotation(this.TeethR, 0.0f, 0.0f, 0.0f);
        (this.ManeBackTop = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 24, 14, 20);
        this.ManeBackTop.setRotationPoint(-12.0f, -46.0f, -25.0f);
        this.ManeBackTop.setTextureSize(64, 32);
        this.ManeBackTop.mirror = true;
        this.setRotation(this.ManeBackTop, -0.3316126f, 0.0f, 0.0f);
        (this.ManeBackLeft = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 14, 20);
        this.ManeBackLeft.setRotationPoint(12.0f, -46.0f, -24.0f);
        this.ManeBackLeft.setTextureSize(64, 32);
        this.ManeBackLeft.mirror = true;
        this.setRotation(this.ManeBackLeft, -0.3316126f, 0.0f, 0.7435722f);
        (this.ManeRightBack = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 14, 20);
        this.ManeRightBack.setRotationPoint(-26.6f, -32.5f, -24.0f);
        this.ManeRightBack.setTextureSize(64, 32);
        this.ManeRightBack.mirror = true;
        this.setRotation(this.ManeRightBack, -0.3316126f, 0.0f, -0.7435801f);
        (this.FrontLegSegment = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 60, 16, 16);
        this.FrontLegSegment.setRotationPoint(-30.0f, -22.0f, -13.0f);
        this.FrontLegSegment.setTextureSize(64, 32);
        this.FrontLegSegment.mirror = true;
        this.setRotation(this.FrontLegSegment, -0.2974289f, 0.0f, 0.0f);
        (this.FLL1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 16, 10);
        this.FLL1.setRotationPoint(20.0f, -6.0f, -15.0f);
        this.FLL1.setTextureSize(64, 32);
        this.FLL1.mirror = true;
        this.setRotation(this.FLL1, 0.2230717f, 0.0f, 0.0f);
        (this.FLR1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 16, 10);
        this.FLR1.setRotationPoint(-30.0f, -6.0f, -15.0f);
        this.FLR1.setTextureSize(64, 32);
        this.FLR1.mirror = true;
        this.setRotation(this.FLR1, 0.2230717f, 0.0f, 0.0f);
        (this.FLL2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 9.0f, 4.0f, 10, 10, 10);
        this.FLL2.setRotationPoint(20.0f, -6.0f, -15.0f);
        this.FLL2.setTextureSize(64, 32);
        this.FLL2.mirror = true;
        this.setRotation(this.FLL2, 0.0f, 0.0f, 0.0f);
        (this.FLR2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 8.0f, 4.0f, 10, 10, 10);
        this.FLR2.setRotationPoint(-30.0f, -4.0f, -15.0f);
        this.FLR2.setTextureSize(64, 32);
        this.FLR2.mirror = true;
        this.setRotation(this.FLR2, 0.0f, 0.0f, 0.0f);
        (this.FLL3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 4.0f, 13.0f, 10, 20, 10);
        this.FLL3.setRotationPoint(20.0f, -6.0f, -15.0f);
        this.FLL3.setTextureSize(64, 32);
        this.FLL3.mirror = true;
        this.setRotation(this.FLL3, -0.7807508f, 0.0f, 0.0f);
        (this.FLR3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 4.0f, 14.0f, 10, 20, 10);
        this.FLR3.setRotationPoint(-30.0f, -6.0f, -15.0f);
        this.FLR3.setTextureSize(64, 32);
        this.FLR3.mirror = true;
        this.setRotation(this.FLR3, -0.7807508f, 0.0f, 0.0f);
        (this.FLL4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 24.0f, -7.0f, 12, 10, 10);
        this.FLL4.setRotationPoint(20.0f, -6.0f, -15.0f);
        this.FLL4.setTextureSize(64, 32);
        this.FLL4.mirror = true;
        this.setRotation(this.FLL4, 0.0f, 0.0f, 0.0f);
        (this.FLR4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 24.0f, -5.0f, 12, 10, 10);
        this.FLR4.setRotationPoint(-31.0f, -6.0f, -15.0f);
        this.FLR4.setTextureSize(64, 32);
        this.FLR4.mirror = true;
        this.setRotation(this.FLR4, 0.0f, 0.0f, 0.0f);
        (this.FLL5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 19.0f, -31.0f, 12, 9, 22);
        this.FLL5.setRotationPoint(20.0f, -6.0f, -15.0f);
        this.FLL5.setTextureSize(64, 32);
        this.FLL5.mirror = true;
        this.setRotation(this.FLL5, 0.3490659f, 0.0f, 0.0f);
        (this.FLR5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 19.0f, -30.0f, 12, 9, 22);
        this.FLR5.setRotationPoint(-31.0f, -6.0f, -15.0f);
        this.FLR5.setTextureSize(64, 32);
        this.FLR5.mirror = true;
        this.setRotation(this.FLR5, 0.3490659f, 0.0f, 0.0f);
        (this.C6 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C6.setRotationPoint(19.0f, -6.0f, -15.0f);
        this.C6.setTextureSize(64, 32);
        this.C6.mirror = true;
        this.setRotation(this.C6, 0.0f, 0.0f, 0.0f);
        (this.C5 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C5.setRotationPoint(21.0f, -6.0f, -15.0f);
        this.C5.setTextureSize(64, 32);
        this.C5.mirror = true;
        this.setRotation(this.C5, 0.0f, 0.0f, 0.0f);
        (this.C4 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C4.setRotationPoint(23.0f, -6.0f, -15.0f);
        this.C4.setTextureSize(64, 32);
        this.C4.mirror = true;
        this.setRotation(this.C4, 0.0f, 0.0f, 0.0f);
        (this.C7 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C7.setRotationPoint(-20.0f, -6.0f, -15.0f);
        this.C7.setTextureSize(64, 32);
        this.C7.mirror = true;
        this.setRotation(this.C7, 0.0f, 0.0f, 0.0f);
        (this.C9 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C9.setRotationPoint(-24.0f, -6.0f, -15.0f);
        this.C9.setTextureSize(64, 32);
        this.C9.mirror = true;
        this.setRotation(this.C9, 0.0f, 0.0f, 0.0f);
        (this.C11 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C11.setRotationPoint(-28.0f, -6.0f, -15.0f);
        this.C11.setTextureSize(64, 32);
        this.C11.mirror = true;
        this.setRotation(this.C11, 0.0f, 0.0f, 0.0f);
        (this.C2 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C2.setRotationPoint(27.0f, -6.0f, -15.0f);
        this.C2.setTextureSize(64, 32);
        this.C2.mirror = true;
        this.setRotation(this.C2, 0.0f, 0.0f, 0.0f);
        (this.C3 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C3.setRotationPoint(25.0f, -6.0f, -15.0f);
        this.C3.setTextureSize(64, 32);
        this.C3.mirror = true;
        this.setRotation(this.C3, 0.0f, 0.0f, 0.0f);
        (this.C1 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C1.setRotationPoint(29.0f, -6.0f, -15.0f);
        this.C1.setTextureSize(64, 32);
        this.C1.mirror = true;
        this.setRotation(this.C1, 0.0f, 0.0f, 0.0f);
        (this.C8 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C8.setRotationPoint(-22.0f, -6.0f, -15.0f);
        this.C8.setTextureSize(64, 32);
        this.C8.mirror = true;
        this.setRotation(this.C8, 0.0f, 0.0f, 0.0f);
        (this.C12 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C12.setRotationPoint(-30.0f, -6.0f, -15.0f);
        this.C12.setTextureSize(64, 32);
        this.C12.mirror = true;
        this.setRotation(this.C12, 0.0f, 0.0f, 0.0f);
        (this.C10 = new ModelRenderer((ModelBase) this, 888, 0)).addBox(0.0f, 29.0f, -29.0f, 1, 2, 10);
        this.C10.setRotationPoint(-26.0f, -6.0f, -15.0f);
        this.C10.setTextureSize(64, 32);
        this.C10.mirror = true;
        this.setRotation(this.C10, 0.0f, 0.0f, 0.0f);
        (this.EyeR = new ModelRenderer((ModelBase) this, 0, 60)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 5);
        this.EyeR.setRotationPoint(-8.0f, -28.0f, -53.0f);
        this.EyeR.setTextureSize(64, 32);
        this.EyeR.mirror = true;
        this.setRotation(this.EyeR, 0.0f, 0.0f, 0.0f);
        (this.EyeL = new ModelRenderer((ModelBase) this, 0, 60)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 5);
        this.EyeL.setRotationPoint(5.0f, -28.0f, -53.0f);
        this.EyeL.setTextureSize(64, 32);
        this.EyeL.mirror = true;
        this.setRotation(this.EyeL, 0.0f, 0.0f, 0.0f);
        (this.BackLegSegment = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 46, 16, 16);
        this.BackLegSegment.setRotationPoint(-24.0f, -22.0f, 32.0f);
        this.BackLegSegment.setTextureSize(64, 32);
        this.BackLegSegment.mirror = true;
        this.setRotation(this.BackLegSegment, -0.2974289f, 0.0f, 0.0f);
        (this.BLL1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 16, 10);
        this.BLL1.setRotationPoint(12.0f, -6.0f, 31.0f);
        this.BLL1.setTextureSize(64, 32);
        this.BLL1.mirror = true;
        this.setRotation(this.BLL1, 0.2230717f, 0.0f, 0.0f);
        (this.BLR1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 16, 10);
        this.BLR1.setRotationPoint(-27.0f, -6.0f, 31.0f);
        this.BLR1.setTextureSize(64, 32);
        this.BLR1.mirror = true;
        this.setRotation(this.BLR1, 0.2230717f, 0.0f, 0.0f);
        (this.BLR2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 11.0f, 3.0f, 10, 10, 10);
        this.BLR2.setRotationPoint(-27.0f, -6.0f, 31.0f);
        this.BLR2.setTextureSize(64, 32);
        this.BLR2.mirror = true;
        this.setRotation(this.BLR2, 0.0f, 0.0f, 0.0f);
        (this.BLL2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 11.0f, 3.0f, 10, 10, 10);
        this.BLL2.setRotationPoint(12.0f, -6.0f, 31.0f);
        this.BLL2.setTextureSize(64, 32);
        this.BLL2.mirror = true;
        this.setRotation(this.BLL2, 0.0f, 0.0f, 0.0f);
        (this.BLR3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 6.0f, 14.0f, 10, 20, 10);
        this.BLR3.setRotationPoint(-27.0f, -6.0f, 31.0f);
        this.BLR3.setTextureSize(64, 32);
        this.BLR3.mirror = true;
        this.setRotation(this.BLR3, -0.7807508f, 0.0f, 0.0f);
        (this.BLL3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 6.0f, 14.0f, 10, 20, 10);
        this.BLL3.setRotationPoint(12.0f, -6.0f, 31.0f);
        this.BLL3.setTextureSize(64, 32);
        this.BLL3.mirror = true;
        this.setRotation(this.BLL3, -0.7807508f, 0.0f, 0.0f);
        (this.BLL4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 25.0f, -7.0f, 12, 10, 10);
        this.BLL4.setRotationPoint(10.0f, -6.0f, 31.0f);
        this.BLL4.setTextureSize(64, 32);
        this.BLL4.mirror = true;
        this.setRotation(this.BLL4, 0.0f, 0.0f, 0.0f);
        (this.BLR4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 25.0f, -7.0f, 12, 10, 10);
        this.BLR4.setRotationPoint(-27.0f, -6.0f, 31.0f);
        this.BLR4.setTextureSize(64, 32);
        this.BLR4.mirror = true;
        this.setRotation(this.BLR4, 0.0f, 0.0f, 0.0f);
        (this.BLR5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 21.0f, -30.0f, 12, 9, 22);
        this.BLR5.setRotationPoint(-27.0f, -6.0f, 31.0f);
        this.BLR5.setTextureSize(64, 32);
        this.BLR5.mirror = true;
        this.setRotation(this.BLR5, 0.3490659f, 0.0f, 0.0f);
        (this.BLL5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 21.0f, -30.0f, 12, 9, 22);
        this.BLL5.setRotationPoint(10.0f, -6.0f, 31.0f);
        this.BLL5.setTextureSize(64, 32);
        this.BLL5.mirror = true;
        this.setRotation(this.BLL5, 0.3490659f, 0.0f, 0.0f);
        (this.WindL1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 25);
        this.WindL1.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL1.setTextureSize(64, 32);
        this.WindL1.mirror = true;
        this.setRotation(this.WindL1, 1.524323f, 0.0f, 0.6320364f);
        (this.WindL2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 25.0f, 4, 6, 25);
        this.WindL2.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL2.setTextureSize(64, 32);
        this.WindL2.mirror = true;
        this.setRotation(this.WindL2, 1.524323f, 0.0f, 0.6320364f);
        (this.WindL3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -42.0f, 26.0f, 4, 4, 40);
        this.WindL3.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL3.setTextureSize(64, 32);
        this.WindL3.mirror = true;
        this.setRotation(this.WindL3, 0.5205006f, 0.0f, 0.6320364f);
        (this.WindL4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -52.0f, 2.0f, 4, 4, 40);
        this.WindL4.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL4.setTextureSize(64, 32);
        this.WindL4.mirror = true;
        this.setRotation(this.WindL4, -0.0743572f, 0.0f, 0.6320364f);
        (this.WingL5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -42.0f, -29.0f, 4, 4, 40);
        this.WingL5.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WingL5.setTextureSize(64, 32);
        this.WingL5.mirror = true;
        this.setRotation(this.WingL5, -0.7063936f, 0.0f, 0.6320364f);
        (this.WindR2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 25.0f, 4, 6, 25);
        this.WindR2.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR2.setTextureSize(64, 32);
        this.WindR2.mirror = true;
        this.setRotation(this.WindR2, 1.524323f, 0.0f, -0.6320361f);
        (this.WingR1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 6, 25);
        this.WingR1.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WingR1.setTextureSize(64, 32);
        this.WingR1.mirror = true;
        this.setRotation(this.WingR1, 1.524323f, 0.0f, -0.6320361f);
        (this.WindR3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -34.0f, 36.0f, 4, 4, 40);
        this.WindR3.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR3.setTextureSize(64, 32);
        this.WindR3.mirror = true;
        this.setRotation(this.WindR3, 0.7807508f, 0.0f, -0.6320361f);
        (this.WindR4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -49.0f, 6.0f, 4, 4, 40);
        this.WindR4.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR4.setTextureSize(64, 32);
        this.WindR4.mirror = true;
        this.setRotation(this.WindR4, 0.0743572f, 0.0f, -0.6320361f);
        (this.WindR5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -40.0f, -27.0f, 4, 4, 40);
        this.WindR5.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR5.setTextureSize(64, 32);
        this.WindR5.mirror = true;
        this.setRotation(this.WindR5, -0.7063936f, 0.0f, -0.6320361f);
        (this.WindL6 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -50.0f, 2.0f, 2, 51, 20);
        this.WindL6.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL6.setTextureSize(64, 32);
        this.WindL6.mirror = true;
        this.setRotation(this.WindL6, -0.0371786f, 0.0f, 0.6320364f);
        (this.WindL8 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -65.0f, -43.0f, 2, 38, 20);
        this.WindL8.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL8.setTextureSize(64, 32);
        this.WindL8.mirror = true;
        this.setRotation(this.WindL8, -1.07818f, 0.0f, 0.6320364f);
        (this.WindL7 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -66.0f, 4.0f, 2, 32, 20);
        this.WindL7.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL7.setTextureSize(64, 32);
        this.WindL7.mirror = true;
        this.setRotation(this.WindL7, -0.3808742f, 0.0f, 0.6320364f);
        (this.WindR6 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -50.0f, 0.0f, 2, 51, 20);
        this.WindR6.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR6.setTextureSize(64, 32);
        this.WindR6.mirror = true;
        this.setRotation(this.WindR6, -0.0371786f, 0.0f, -0.6320361f);
        (this.WindR8 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -76.0f, -33.0f, 2, 38, 20);
        this.WindR8.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR8.setTextureSize(64, 32);
        this.WindR8.mirror = true;
        this.setRotation(this.WindR8, -0.8179294f, 0.0f, -0.6320361f);
        (this.WindR7 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -70.0f, 10.0f, 2, 42, 20);
        this.WindR7.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR7.setTextureSize(64, 32);
        this.WindR7.mirror = true;
        this.setRotation(this.WindR7, -0.2298877f, 0.0f, -0.6320361f);
        (this.WindR9 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(1.0f, -37.0f, -1.0f, 2, 42, 20);
        this.WindR9.setRotationPoint(-20.0f, -30.0f, 0.0f);
        this.WindR9.setTextureSize(64, 32);
        this.WindR9.mirror = true;
        this.setRotation(this.WindR9, -0.5205006f, 0.0f, -0.6320361f);
        (this.WindL9 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, -53.0f, 0.0f, 2, 42, 20);
        this.WindL9.setRotationPoint(17.0f, -32.0f, 0.0f);
        this.WindL9.setTextureSize(64, 32);
        this.WindL9.mirror = true;
        this.setRotation(this.WindL9, -0.4461433f, 0.0f, 0.6320361f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final ManticoreInstance e = (ManticoreInstance) entity;
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = 0.65f + MathHelper.cos(f2 * 0.9f * this.wingspeed) * 3.141593f * 0.068f;
        this.WindL1.rotateAngleZ = newangle;
        this.WindL2.rotateAngleZ = newangle;
        this.WindL3.rotateAngleZ = newangle;
        this.WindL4.rotateAngleZ = newangle;
        this.WingL5.rotateAngleZ = newangle;
        this.WindL6.rotateAngleZ = newangle;
        this.WindL7.rotateAngleZ = newangle;
        this.WindL8.rotateAngleZ = newangle;
        this.WindL9.rotateAngleZ = newangle;
        this.WingR1.rotateAngleZ = -newangle;
        this.WindR2.rotateAngleZ = -newangle;
        this.WindR3.rotateAngleZ = -newangle;
        this.WindR4.rotateAngleZ = -newangle;
        this.WindR5.rotateAngleZ = -newangle;
        this.WindR6.rotateAngleZ = -newangle;
        this.WindR7.rotateAngleZ = -newangle;
        this.WindR8.rotateAngleZ = -newangle;
        this.WindR9.rotateAngleZ = -newangle;
        newangle2 = -1.65f + MathHelper.cos(f2 * 0.9f * this.wingspeed) * 3.141593f * 0.068f;
        newangle = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.141593f * 0.15f;
        this.Body2.render(f5);
        this.Body3.render(f5);
        this.Body4.render(f5);
        this.Body5.render(f5);
        this.Body6.render(f5);
        this.Body7.render(f5);
        this.Body8.render(f5);
        this.Body10.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.Tail4.render(f5);
        this.Tail5.render(f5);
        this.Tail6.render(f5);
        this.Tail7.render(f5);
        this.Tail8.render(f5);
        this.Tail9.render(f5);
        this.Tail10.render(f5);
        this.Tail11.render(f5);
        this.StingerNest.render(f5);
        this.Stinger1.render(f5);
        this.Stinger2ByTwilicornOrHurricaneSHL.render(f5);
        this.Body1.render(f5);
        this.Neck.render(f5);
        this.ManeTop.render(f5);
        this.ManeLeftTop.render(f5);
        this.ManeRightTop.render(f5);
        this.ManeLeft.render(f5);
        this.ManeRight.render(f5);
        this.Head.render(f5);
        this.ManeLeftBottom.render(f5);
        this.ManeRightBottom.render(f5);
        this.Face.render(f5);
        this.Jaws.render(f5);
        this.EarL.render(f5);
        this.EarR.render(f5);
        this.Nose.render(f5);
        this.TeethL.render(f5);
        this.TeethR.render(f5);
        this.ManeBackTop.render(f5);
        this.ManeBackLeft.render(f5);
        this.ManeRightBack.render(f5);
        this.FrontLegSegment.render(f5);
        this.FLL1.render(f5);
        this.FLR1.render(f5);
        this.FLL2.render(f5);
        this.FLR2.render(f5);
        this.FLL3.render(f5);
        this.FLR3.render(f5);
        this.FLL4.render(f5);
        this.FLR4.render(f5);
        this.FLL5.render(f5);
        this.FLR5.render(f5);
        this.C6.render(f5);
        this.C5.render(f5);
        this.C4.render(f5);
        this.C7.render(f5);
        this.C9.render(f5);
        this.C11.render(f5);
        this.C2.render(f5);
        this.C3.render(f5);
        this.C1.render(f5);
        this.C8.render(f5);
        this.C12.render(f5);
        this.C10.render(f5);
        this.EyeR.render(f5);
        this.EyeL.render(f5);
        this.BackLegSegment.render(f5);
        this.BLL1.render(f5);
        this.BLR1.render(f5);
        this.BLR2.render(f5);
        this.BLL2.render(f5);
        this.BLR3.render(f5);
        this.BLL3.render(f5);
        this.BLL4.render(f5);
        this.BLR4.render(f5);
        this.BLR5.render(f5);
        this.BLL5.render(f5);
        this.WindL1.render(f5);
        this.WindL2.render(f5);
        this.WindL3.render(f5);
        this.WindL4.render(f5);
        this.WingL5.render(f5);
        this.WindR2.render(f5);
        this.WingR1.render(f5);
        this.WindR3.render(f5);
        this.WindR4.render(f5);
        this.WindR5.render(f5);
        this.WindL6.render(f5);
        this.WindL8.render(f5);
        this.WindL7.render(f5);
        this.WindR6.render(f5);
        this.WindR8.render(f5);
        this.WindR7.render(f5);
        this.WindR9.render(f5);
        this.WindL9.render(f5);
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
