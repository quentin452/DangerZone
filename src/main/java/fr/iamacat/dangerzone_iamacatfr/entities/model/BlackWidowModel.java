
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DemonSpiderInstance;

public class BlackWidowModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Head2;
    ModelRenderer Head1;
    ModelRenderer Neck;
    ModelRenderer End7;
    ModelRenderer End6;
    ModelRenderer End5;
    ModelRenderer End4;
    ModelRenderer End8;
    ModelRenderer End10;
    ModelRenderer End11;
    ModelRenderer End9;
    ModelRenderer End3;
    ModelRenderer End2;
    ModelRenderer End1;
    ModelRenderer BiterL1;
    ModelRenderer BiterR1;
    ModelRenderer BiterL2;
    ModelRenderer BiterR2;
    ModelRenderer WebberL;
    ModelRenderer WebberR;
    ModelRenderer LegR1;
    ModelRenderer LegR2;
    ModelRenderer LegR3;
    ModelRenderer LegR4;
    ModelRenderer LegL1;
    ModelRenderer LegL2;
    ModelRenderer LegL3;
    ModelRenderer LegL4;
    ModelRenderer LL1S2;
    ModelRenderer LL2S2;
    ModelRenderer LL3S2;
    ModelRenderer LL4S2;
    ModelRenderer LR1S2;
    ModelRenderer LR2S2;
    ModelRenderer LR3S2;
    ModelRenderer LR4S2;
    ModelRenderer LR1S3;
    ModelRenderer LR2S3;
    ModelRenderer LR3S3;
    ModelRenderer LR4S3;
    ModelRenderer LL1S3;
    ModelRenderer LL2S3;
    ModelRenderer LL3S3;
    ModelRenderer LL4S3;

    public BlackWidowModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 1024;
        this.textureHeight = 1024;
        (this.Head2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 12, 20);
        this.Head2.setRotationPoint(-6.0f, -14.0f, -29.0f);
        this.Head2.setTextureSize(1024, 1024);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 200, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 10, 24);
        this.Head1.setRotationPoint(-5.0f, -13.0f, -31.0f);
        this.Head1.setTextureSize(1024, 1024);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 24);
        this.Neck.setRotationPoint(-4.0f, -12.0f, -28.0f);
        this.Neck.setTextureSize(1024, 1024);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.End7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 30, 30, 40);
        this.End7.setRotationPoint(-15.0f, -24.0f, 4.0f);
        this.End7.setTextureSize(1024, 1024);
        this.End7.mirror = true;
        this.setRotation(this.End7, 0.0f, 0.0f, 0.0f);
        (this.End6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 28, 28, 44);
        this.End6.setRotationPoint(-14.0f, -23.0f, 2.0f);
        this.End6.setTextureSize(1024, 1024);
        this.End6.mirror = true;
        this.setRotation(this.End6, 0.0f, 0.0f, 0.0f);
        (this.End5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 26, 26, 48);
        this.End5.setRotationPoint(-14.0f, -22.0f, 0.0f);
        this.End5.setTextureSize(1024, 1024);
        this.End5.mirror = true;
        this.setRotation(this.End5, 0.0f, 0.0f, 0.0f);
        (this.End4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 24, 24, 52);
        this.End4.setRotationPoint(-13.0f, -21.0f, -2.0f);
        this.End4.setTextureSize(1024, 1024);
        this.End4.mirror = true;
        this.setRotation(this.End4, 0.0f, 0.0f, 0.0f);
        (this.End8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 26, 32, 36);
        this.End8.setRotationPoint(-14.0f, -25.0f, 6.0f);
        this.End8.setTextureSize(1024, 1024);
        this.End8.mirror = true;
        this.setRotation(this.End8, 0.0f, 0.0f, 0.0f);
        (this.End10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 32, 24, 36);
        this.End10.setRotationPoint(-16.0f, -21.0f, 6.0f);
        this.End10.setTextureSize(1024, 1024);
        this.End10.mirror = true;
        this.setRotation(this.End10, 0.0f, 0.0f, 0.0f);
        (this.End11 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 34, 20, 32);
        this.End11.setRotationPoint(-17.0f, -19.0f, 8.0f);
        this.End11.setTextureSize(1024, 1024);
        this.End11.mirror = true;
        this.setRotation(this.End11, 0.0f, 0.0f, 0.0f);
        (this.End9 = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 0.0f, 0.0f, 22, 34, 32);
        this.End9.setRotationPoint(-11.0f, -26.0f, 8.0f);
        this.End9.setTextureSize(1024, 1024);
        this.End9.mirror = true;
        this.setRotation(this.End9, 0.0f, 0.0f, 0.0f);
        (this.End3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 22, 22, 54);
        this.End3.setRotationPoint(-12.0f, -20.0f, -3.0f);
        this.End3.setTextureSize(1024, 1024);
        this.End3.mirror = true;
        this.setRotation(this.End3, 0.0f, 0.0f, 0.0f);
        (this.End2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 20, 56);
        this.End2.setRotationPoint(-11.0f, -19.0f, -4.0f);
        this.End2.setTextureSize(1024, 1024);
        this.End2.mirror = true;
        this.setRotation(this.End2, 0.0f, 0.0f, 0.0f);
        (this.End1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 12, 10);
        this.End1.setRotationPoint(-6.0f, -14.0f, -6.0f);
        this.End1.setTextureSize(1024, 1024);
        this.End1.mirror = true;
        this.setRotation(this.End1, 0.0f, 0.0f, 0.0f);
        (this.BiterL1 = new ModelRenderer((ModelBase) this, 200, 100)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 8);
        this.BiterL1.setRotationPoint(3.0f, -3.0f, -28.0f);
        this.BiterL1.setTextureSize(1024, 1024);
        this.BiterL1.mirror = true;
        this.setRotation(this.BiterL1, -2.565324f, 0.0f, 0.0f);
        (this.BiterR1 = new ModelRenderer((ModelBase) this, 200, 100)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 8);
        this.BiterR1.setRotationPoint(-5.0f, -3.0f, -28.0f);
        this.BiterR1.setTextureSize(1024, 1024);
        this.BiterR1.mirror = true;
        this.setRotation(this.BiterR1, -2.565324f, 0.0f, 0.0f);
        (this.BiterL2 = new ModelRenderer((ModelBase) this, 200, 222)).addBox(0.5f, 5.0f, 5.0f, 1, 1, 8);
        this.BiterL2.setRotationPoint(3.0f, -3.0f, -28.0f);
        this.BiterL2.setTextureSize(1024, 1024);
        this.BiterL2.mirror = true;
        this.setRotation(this.BiterL2, -1.896109f, 0.0f, 0.0f);
        (this.BiterR2 = new ModelRenderer((ModelBase) this, 200, 222)).addBox(0.5f, 5.0f, 5.0f, 1, 1, 8);
        this.BiterR2.setRotationPoint(-5.0f, -3.0f, -28.0f);
        this.BiterR2.setTextureSize(1024, 1024);
        this.BiterR2.mirror = true;
        this.setRotation(this.BiterR2, -1.896109f, 0.0f, 0.0f);
        (this.WebberL = new ModelRenderer((ModelBase) this, 200, 166)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.WebberL.setRotationPoint(1.0f, -3.0f, -29.0f);
        this.WebberL.setTextureSize(1024, 1024);
        this.WebberL.mirror = true;
        this.setRotation(this.WebberL, -1.721576f, 0.0f, 0.0f);
        (this.WebberR = new ModelRenderer((ModelBase) this, 200, 166)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.WebberR.setRotationPoint(-2.0f, -3.0f, -29.0f);
        this.WebberR.setTextureSize(1024, 1024);
        this.WebberR.mirror = true;
        this.setRotation(this.WebberR, -1.721576f, 0.0f, 0.0f);
        (this.LegR1 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(-12.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegR1.setRotationPoint(-2.0f, -2.0f, -28.0f);
        this.LegR1.setTextureSize(1024, 1024);
        this.LegR1.mirror = true;
        this.setRotation(this.LegR1, 0.0f, 0.0f, 0.0f);
        (this.LegR2 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(-12.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegR2.setRotationPoint(-2.0f, -2.0f, -23.0f);
        this.LegR2.setTextureSize(1024, 1024);
        this.LegR2.mirror = true;
        this.setRotation(this.LegR2, 0.0f, 0.0f, 0.0f);
        (this.LegR3 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(-12.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegR3.setRotationPoint(-2.0f, -2.0f, -18.0f);
        this.LegR3.setTextureSize(1024, 1024);
        this.LegR3.mirror = true;
        this.setRotation(this.LegR3, 0.0f, 0.0f, 0.0f);
        (this.LegR4 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(-12.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegR4.setRotationPoint(-2.0f, -2.0f, -13.0f);
        this.LegR4.setTextureSize(1024, 1024);
        this.LegR4.mirror = true;
        this.setRotation(this.LegR4, 0.0f, 0.0f, 0.0f);
        (this.LegL1 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegL1.setRotationPoint(0.0f, -2.0f, -28.0f);
        this.LegL1.setTextureSize(1024, 1024);
        this.LegL1.mirror = true;
        this.setRotation(this.LegL1, 0.0f, 0.0f, 0.0f);
        (this.LegL2 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegL2.setRotationPoint(0.0f, -2.0f, -23.0f);
        this.LegL2.setTextureSize(1024, 1024);
        this.LegL2.mirror = true;
        this.setRotation(this.LegL2, 0.0f, 0.0f, 0.0f);
        (this.LegL3 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegL3.setRotationPoint(0.0f, -2.0f, -18.0f);
        this.LegL3.setTextureSize(1024, 1024);
        this.LegL3.mirror = true;
        this.setRotation(this.LegL3, 0.0f, 0.0f, 0.0f);
        (this.LegL4 = new ModelRenderer((ModelBase) this, 0, 333)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 4);
        this.LegL4.setRotationPoint(0.0f, -2.0f, -13.0f);
        this.LegL4.setTextureSize(1024, 1024);
        this.LegL4.mirror = true;
        this.setRotation(this.LegL4, 0.0f, 0.0f, 0.0f);
        (this.LL1S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(12.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LL1S2.setRotationPoint(0.0f, -2.0f, -28.0f);
        this.LL1S2.setTextureSize(1024, 1024);
        this.LL1S2.mirror = true;
        this.setRotation(this.LL1S2, 0.0f, 0.0f, 0.0f);
        (this.LL2S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(12.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LL2S2.setRotationPoint(0.0f, -2.0f, -23.0f);
        this.LL2S2.setTextureSize(1024, 1024);
        this.LL2S2.mirror = true;
        this.setRotation(this.LL2S2, 0.0f, 0.0f, 0.0f);
        (this.LL3S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(12.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LL3S2.setRotationPoint(0.0f, -2.0f, -18.0f);
        this.LL3S2.setTextureSize(1024, 1024);
        this.LL3S2.mirror = true;
        this.setRotation(this.LL3S2, 0.0f, 0.0f, 0.0f);
        (this.LL4S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(12.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LL4S2.setRotationPoint(0.0f, -2.0f, -13.0f);
        this.LL4S2.setTextureSize(1024, 1024);
        this.LL4S2.mirror = true;
        this.setRotation(this.LL4S2, 0.0f, 0.0f, 0.0f);
        (this.LR1S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-30.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LR1S2.setRotationPoint(-2.0f, -2.0f, -28.0f);
        this.LR1S2.setTextureSize(1024, 1024);
        this.LR1S2.mirror = true;
        this.setRotation(this.LR1S2, 0.0f, 0.0f, 0.0f);
        (this.LR2S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-30.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LR2S2.setRotationPoint(-2.0f, -2.0f, -23.0f);
        this.LR2S2.setTextureSize(1024, 1024);
        this.LR2S2.mirror = true;
        this.setRotation(this.LR2S2, 0.0f, 0.0f, 0.0f);
        (this.LR3S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-30.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LR3S2.setRotationPoint(-2.0f, -2.0f, -18.0f);
        this.LR3S2.setTextureSize(1024, 1024);
        this.LR3S2.mirror = true;
        this.setRotation(this.LR3S2, 0.0f, 0.0f, 0.0f);
        (this.LR4S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-30.0f, 1.0f, 1.0f, 18, 2, 2);
        this.LR4S2.setRotationPoint(-2.0f, -2.0f, -13.0f);
        this.LR4S2.setTextureSize(1024, 1024);
        this.LR4S2.mirror = true;
        this.setRotation(this.LR4S2, 0.0f, 0.0f, 0.0f);
        (this.LR1S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-46.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LR1S3.setRotationPoint(-2.0f, -2.0f, -28.0f);
        this.LR1S3.setTextureSize(1024, 1024);
        this.LR1S3.mirror = true;
        this.setRotation(this.LR1S3, 0.0f, 0.0f, -1.041002f);
        (this.LR2S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-46.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LR2S3.setRotationPoint(-2.0f, -2.0f, -23.0f);
        this.LR2S3.setTextureSize(1024, 1024);
        this.LR2S3.mirror = true;
        this.setRotation(this.LR2S3, 0.0f, 0.0f, -1.041002f);
        (this.LR3S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-46.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LR3S3.setRotationPoint(-2.0f, -2.0f, -18.0f);
        this.LR3S3.setTextureSize(1024, 1024);
        this.LR3S3.mirror = true;
        this.setRotation(this.LR3S3, 0.0f, 0.0f, -1.041002f);
        (this.LR4S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-46.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LR4S3.setRotationPoint(-2.0f, -2.0f, -13.0f);
        this.LR4S3.setTextureSize(1024, 1024);
        this.LR4S3.mirror = true;
        this.setRotation(this.LR4S3, 0.0f, 0.0f, -1.041002f);
        (this.LL1S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(16.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LL1S3.setRotationPoint(0.0f, -2.0f, -28.0f);
        this.LL1S3.setTextureSize(1024, 1024);
        this.LL1S3.mirror = true;
        this.setRotation(this.LL1S3, 0.0f, 0.0f, 1.041002f);
        (this.LL2S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(16.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LL2S3.setRotationPoint(0.0f, -2.0f, -23.0f);
        this.LL2S3.setTextureSize(1024, 1024);
        this.LL2S3.mirror = true;
        this.setRotation(this.LL2S3, 0.0f, 0.0f, 1.041002f);
        (this.LL3S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(16.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LL3S3.setRotationPoint(0.0f, -2.0f, -18.0f);
        this.LL3S3.setTextureSize(1024, 1024);
        this.LL3S3.mirror = true;
        this.setRotation(this.LL3S3, 0.0f, 0.0f, 1.041002f);
        (this.LL4S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(16.0f, -25.0f, 1.0f, 30, 2, 2);
        this.LL4S3.setRotationPoint(0.0f, -2.0f, -13.0f);
        this.LL4S3.setTextureSize(1024, 1024);
        this.LL4S3.mirror = true;
        this.setRotation(this.LL4S3, 0.0f, 0.0f, 1.041002f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        final DemonSpiderInstance b = (DemonSpiderInstance) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * this.wingspeed * 0.45f) * 3.141593f * 0.12f * f1;
        this.LegL1.rotateAngleY = 0.549f - newangle;
        this.LL1S2.rotateAngleY = 0.549f - newangle;
        this.LL1S3.rotateAngleY = 0.549f - newangle;
        this.LegL2.rotateAngleY = 0.349f + newangle;
        this.LL2S2.rotateAngleY = 0.349f + newangle;
        this.LL2S3.rotateAngleY = 0.349f + newangle;
        this.LegL3.rotateAngleY = 0.149f - newangle;
        this.LL3S2.rotateAngleY = 0.149f - newangle;
        this.LL3S3.rotateAngleY = 0.149f - newangle;
        this.LegL4.rotateAngleY = -0.149f + newangle;
        this.LL4S2.rotateAngleY = -0.149f + newangle;
        this.LL4S3.rotateAngleY = -0.149f + newangle;
        this.LegR1.rotateAngleY = -0.149f - newangle;
        this.LR1S2.rotateAngleY = -0.149f - newangle;
        this.LR1S3.rotateAngleY = -0.149f - newangle;
        this.LegR2.rotateAngleY = 0.149f + newangle;
        this.LR2S2.rotateAngleY = 0.149f + newangle;
        this.LR2S3.rotateAngleY = 0.149f + newangle;
        this.LegR3.rotateAngleY = 0.349f - newangle;
        this.LR3S2.rotateAngleY = 0.349f - newangle;
        this.LR3S3.rotateAngleY = 0.349f - newangle;
        this.LegR4.rotateAngleY = 0.549f + newangle;
        this.LR4S2.rotateAngleY = 0.549f + newangle;
        this.LR4S3.rotateAngleY = 0.549f + newangle;
        this.Head2.render(f5);
        this.Head1.render(f5);
        this.Neck.render(f5);
        this.End7.render(f5);
        this.End6.render(f5);
        this.End5.render(f5);
        this.End4.render(f5);
        this.End8.render(f5);
        this.End10.render(f5);
        this.End11.render(f5);
        this.End9.render(f5);
        this.End3.render(f5);
        this.End2.render(f5);
        this.End1.render(f5);
        this.BiterL1.render(f5);
        this.BiterR1.render(f5);
        this.BiterL2.render(f5);
        this.BiterR2.render(f5);
        this.WebberL.render(f5);
        this.WebberR.render(f5);
        this.LegR1.render(f5);
        this.LegR2.render(f5);
        this.LegR3.render(f5);
        this.LegR4.render(f5);
        this.LegL1.render(f5);
        this.LegL2.render(f5);
        this.LegL3.render(f5);
        this.LegL4.render(f5);
        this.LL1S2.render(f5);
        this.LL2S2.render(f5);
        this.LL3S2.render(f5);
        this.LL4S2.render(f5);
        this.LR1S2.render(f5);
        this.LR2S2.render(f5);
        this.LR3S2.render(f5);
        this.LR4S2.render(f5);
        this.LR1S3.render(f5);
        this.LR2S3.render(f5);
        this.LR3S3.render(f5);
        this.LR4S3.render(f5);
        this.LL1S3.render(f5);
        this.LL2S3.render(f5);
        this.LL3S3.render(f5);
        this.LL4S3.render(f5);
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
