package fr.iamacat.dangerzone_iamacatfr.entities.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class RedAntModel extends ModelBase {

    public ModelRenderer brownantHead;
    public ModelRenderer brownantNeck;
    public ModelRenderer brownantBody;
    public ModelRenderer brownantLeg1;
    public ModelRenderer brownantLeg2;
    public ModelRenderer brownantLeg3;
    public ModelRenderer brownantLeg4;
    public ModelRenderer brownantLeg5;
    public ModelRenderer brownantLeg6;
    public ModelRenderer brownantLeg7;
    public ModelRenderer brownantLeg8;

    public RedAntModel() {
        float f = 0.0F;
        byte b0 = 20;
        this.brownantHead = new ModelRenderer(this, 32, 4);
        this.brownantHead.addBox(-2.0F, -2.0F, -4.0F, 4, 4, 4, f);
        this.brownantHead.setRotationPoint(0.0F, b0, -1.5F);
        this.brownantNeck = new ModelRenderer(this, 0, 0);
        this.brownantNeck.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3, f);
        this.brownantNeck.setRotationPoint(0.0F, b0, 0.0F);
        this.brownantBody = new ModelRenderer(this, 0, 12);
        this.brownantBody.addBox(-2.5F, -2.0F, -3.0F, 5, 4, 6, f);
        this.brownantBody.setRotationPoint(0.0F, b0, 4.5F);
        this.brownantLeg1 = new ModelRenderer(this, 18, 0);
        this.brownantLeg1.addBox(-7.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg1.setRotationPoint(-2.0F, b0, 1.0F);
        this.brownantLeg2 = new ModelRenderer(this, 18, 0);
        this.brownantLeg2.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg2.setRotationPoint(2.0F, b0, 1.0F);
        this.brownantLeg3 = new ModelRenderer(this, 18, 0);
        this.brownantLeg3.addBox(-7.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg3.setRotationPoint(-2.0F, b0, 0.5F);
        this.brownantLeg4 = new ModelRenderer(this, 18, 0);
        this.brownantLeg4.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg4.setRotationPoint(2.0F, b0, 0.5F);
        this.brownantLeg5 = new ModelRenderer(this, 18, 0);
        this.brownantLeg5.addBox(-7.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg5.setRotationPoint(-2.0F, b0, 0.0F);
        this.brownantLeg6 = new ModelRenderer(this, 18, 0);
        this.brownantLeg6.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg6.setRotationPoint(2.0F, b0, 0.0F);
        this.brownantLeg7 = new ModelRenderer(this, 18, 0);
        this.brownantLeg7.addBox(-7.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg7.setRotationPoint(-2.0F, b0, -0.5F);
        this.brownantLeg8 = new ModelRenderer(this, 18, 0);
        this.brownantLeg8.addBox(-0.5F, -0.5F, -0.5F, 8, 1, 1, f);
        this.brownantLeg8.setRotationPoint(2.0F, b0, -0.5F);
    }

    public void render(Entity p_78088_1_, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_,
        float p_78088_6_, float p_78088_7_) {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, p_78088_7_, p_78088_1_);
        this.brownantHead.render(p_78088_7_);
        this.brownantNeck.render(p_78088_7_);
        this.brownantBody.render(p_78088_7_);
        this.brownantLeg1.render(p_78088_7_);
        this.brownantLeg2.render(p_78088_7_);
        this.brownantLeg3.render(p_78088_7_);
        this.brownantLeg4.render(p_78088_7_);
        this.brownantLeg5.render(p_78088_7_);
        this.brownantLeg6.render(p_78088_7_);
        this.brownantLeg7.render(p_78088_7_);
        this.brownantLeg8.render(p_78088_7_);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_,
        float p_78087_5_, float p_78087_6_, Entity p_78087_7_) {
        this.brownantHead.rotateAngleY = p_78087_4_ / (180F / (float) Math.PI);
        this.brownantHead.rotateAngleX = p_78087_5_ / (180F / (float) Math.PI);
        float f6 = ((float) Math.PI / 4F);
        this.brownantLeg1.rotateAngleZ = -f6;
        this.brownantLeg2.rotateAngleZ = f6;
        this.brownantLeg3.rotateAngleZ = -f6 * 0.74F;
        this.brownantLeg4.rotateAngleZ = f6 * 0.74F;
        this.brownantLeg5.rotateAngleZ = -f6 * 0.74F;
        this.brownantLeg6.rotateAngleZ = f6 * 0.74F;
        this.brownantLeg7.rotateAngleZ = -f6;
        this.brownantLeg8.rotateAngleZ = f6;
        float f7 = -0.0F;
        float f8 = 0.3926991F;
        this.brownantLeg1.rotateAngleY = f8 * 2.0F + f7;
        this.brownantLeg2.rotateAngleY = -f8 * 2.0F - f7;
        this.brownantLeg3.rotateAngleY = f8 + f7;
        this.brownantLeg4.rotateAngleY = -f8 - f7;
        this.brownantLeg5.rotateAngleY = -f8 + f7;
        this.brownantLeg6.rotateAngleY = f8 - f7;
        this.brownantLeg7.rotateAngleY = -f8 * 2.0F + f7;
        this.brownantLeg8.rotateAngleY = f8 * 2.0F - f7;
        float f9 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + 0.0F) * 0.4F) * p_78087_2_;
        float f10 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * p_78087_2_;
        float f11 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * p_78087_2_;
        float f12 = -(MathHelper.cos(p_78087_1_ * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * p_78087_2_;
        float f13 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + 0.0F) * 0.4F) * p_78087_2_;
        float f14 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + (float) Math.PI) * 0.4F) * p_78087_2_;
        float f15 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * p_78087_2_;
        float f16 = Math.abs(MathHelper.sin(p_78087_1_ * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * p_78087_2_;
        this.brownantLeg1.rotateAngleY += f9;
        this.brownantLeg2.rotateAngleY -= f9;
        this.brownantLeg3.rotateAngleY += f10;
        this.brownantLeg4.rotateAngleY -= f10;
        this.brownantLeg5.rotateAngleY += f11;
        this.brownantLeg6.rotateAngleY -= f11;
        this.brownantLeg7.rotateAngleY += f12;
        this.brownantLeg8.rotateAngleY -= f12;
        this.brownantLeg1.rotateAngleZ += f13;
        this.brownantLeg2.rotateAngleZ -= f13;
        this.brownantLeg3.rotateAngleZ += f14;
        this.brownantLeg4.rotateAngleZ -= f14;
        this.brownantLeg5.rotateAngleZ += f15;
        this.brownantLeg6.rotateAngleZ -= f15;
        this.brownantLeg7.rotateAngleZ += f16;
        this.brownantLeg8.rotateAngleZ -= f16;
    }
}
