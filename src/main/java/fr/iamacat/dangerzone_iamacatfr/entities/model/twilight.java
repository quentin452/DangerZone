
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class twilight extends ModelBase {

    ModelRenderer MareHead;
    ModelRenderer MareBody;
    ModelRenderer MareLeg4;
    ModelRenderer MareLeg3;
    ModelRenderer MareLeg2;
    ModelRenderer MareLeg1;
    ModelRenderer MareNeck;
    ModelRenderer MareTailConnection;
    ModelRenderer MareTail;
    ModelRenderer MareHeadWear;
    ModelRenderer MareHorn;
    ModelRenderer MareWing1Part1;
    ModelRenderer MareWing2Part1;

    public twilight() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.MareHead = new ModelRenderer((ModelBase) this, 54, 0)).addBox(-4.0f, -4.0f, -6.0f, 8, 8, 8);
        this.MareHead.setRotationPoint(0.0f, 0.0f, -8.0f);
        this.MareHead.setTextureSize(128, 64);
        this.MareHead.mirror = true;
        this.setRotation(this.MareHead, 0.0f, 0.0f, 0.0f);
        (this.MareBody = new ModelRenderer((ModelBase) this, 21, 1)).addBox(-6.0f, -10.0f, -7.0f, 8, 15, 6);
        this.MareBody.setRotationPoint(2.0f, 5.0f, 2.0f);
        this.MareBody.setTextureSize(128, 64);
        this.MareBody.mirror = true;
        this.setRotation(this.MareBody, 1.570796f, 0.0f, 0.0f);
        (this.MareLeg4 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 0.0f, -2.0f, 3, 12, 3);
        this.MareLeg4.setRotationPoint(-3.0f, 12.0f, 6.0f);
        this.MareLeg4.setTextureSize(128, 64);
        this.MareLeg4.mirror = true;
        this.setRotation(this.MareLeg4, 0.0872665f, 0.0f, 0.0f);
        (this.MareLeg3 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 0.0f, -2.0f, 3, 12, 3);
        this.MareLeg3.setRotationPoint(2.0f, 12.0f, 6.0f);
        this.MareLeg3.setTextureSize(128, 64);
        this.MareLeg3.mirror = true;
        this.setRotation(this.MareLeg3, 0.0872665f, 0.0f, 0.0f);
        (this.MareLeg2 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 0.0f, -3.0f, 3, 12, 3);
        this.MareLeg2.setRotationPoint(-2.0f, 12.0f, -4.0f);
        this.MareLeg2.setTextureSize(128, 64);
        this.MareLeg2.mirror = true;
        this.setRotation(this.MareLeg2, -0.0349066f, 0.0f, 0.0f);
        (this.MareLeg1 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 0.0f, -3.0f, 3, 12, 3);
        this.MareLeg1.setRotationPoint(2.0f, 12.0f, -4.0f);
        this.MareLeg1.setTextureSize(128, 64);
        this.MareLeg1.mirror = true;
        this.setRotation(this.MareLeg1, -0.0349066f, 0.0f, 0.0f);
        (this.MareNeck = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 9, 4);
        this.MareNeck.setRotationPoint(-2.0f, 2.0f, -11.0f);
        this.MareNeck.setTextureSize(128, 64);
        this.MareNeck.mirror = true;
        this.setRotation(this.MareNeck, 0.2792527f, 0.0f, 0.0f);
        (this.MareTailConnection = new ModelRenderer((ModelBase) this, 92, 0)).addBox(-1.0f, 0.0f, 0.0f, 2, 2, 1);
        this.MareTailConnection.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.MareTailConnection.setTextureSize(128, 64);
        this.MareTailConnection.mirror = true;
        this.setRotation(this.MareTailConnection, 2.119181f, 0.0f, 0.0f);
        (this.MareTail = new ModelRenderer((ModelBase) this, 24, 31)).addBox(0.0f, 0.0f, 0.0f, 4, 10, 3);
        this.MareTail.setRotationPoint(-2.0f, 6.0f, 8.0f);
        this.MareTail.setTextureSize(128, 64);
        this.MareTail.mirror = true;
        this.setRotation(this.MareTail, 0.0f, 0.0f, 0.0f);
        (this.MareHeadWear = new ModelRenderer((ModelBase) this, 1, 46)).addBox(-4.0f, -4.0f, -6.0f, 9, 9, 9);
        this.MareHeadWear.setRotationPoint(0.0f, 0.0f, -8.0f);
        this.MareHeadWear.setTextureSize(128, 64);
        this.MareHeadWear.mirror = true;
        this.setRotation(this.MareHeadWear, 0.0f, 0.0f, 0.0f);
        (this.MareHorn = new ModelRenderer((ModelBase) this, 120, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.MareHorn.setRotationPoint(0.0f, -6.0f, -17.0f);
        this.MareHorn.setTextureSize(128, 64);
        this.MareHorn.mirror = true;
        this.setRotation(this.MareHorn, 0.6632251f, 0.0f, 0.0f);
        (this.MareWing1Part1 = new ModelRenderer((ModelBase) this, 111, 53)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 6);
        this.MareWing1Part1.setRotationPoint(4.0f, 7.0f, -4.0f);
        this.MareWing1Part1.setTextureSize(128, 64);
        this.MareWing1Part1.mirror = true;
        this.setRotation(this.MareWing1Part1, 0.0f, 0.0f, 0.0f);
        (this.MareWing2Part1 = new ModelRenderer((ModelBase) this, 111, 53)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 6);
        this.MareWing2Part1.setRotationPoint(-5.0f, 7.0f, -4.0f);
        this.MareWing2Part1.setTextureSize(128, 64);
        this.MareWing2Part1.mirror = true;
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.MareHead.render(f5);
        this.MareBody.render(f5);
        this.MareLeg4.render(f5);
        this.MareLeg3.render(f5);
        this.MareLeg2.render(f5);
        this.MareLeg1.render(f5);
        this.MareNeck.render(f5);
        this.MareTailConnection.render(f5);
        this.MareTail.render(f5);
        this.MareHeadWear.render(f5);
        this.MareHorn.render(f5);
        this.MareWing1Part1.render(f5);
        this.MareWing2Part1.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4,
        final float par5, final float par6, final Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
        this.MareHead.rotateAngleX = 0.0f;
        this.MareHead.rotateAngleY = 0.0f;
        this.MareLeg1.rotateAngleX = MathHelper.cos(par1 * 0.7f + 3.1415927f) * 1.0f * par2;
        this.MareLeg3.rotateAngleX = MathHelper.cos(par1 * 0.7f) * 1.0f * par2;
        this.MareLeg1.rotateAngleZ = 0.0f;
        this.MareLeg3.rotateAngleZ = 0.0f;
        this.MareLeg2.rotateAngleX = MathHelper.cos(par1 * 0.7f + 3.1415927f) * 1.0f * par2;
        this.MareLeg4.rotateAngleX = MathHelper.cos(par1 * 0.7f) * 1.0f * par2;
        this.MareLeg2.rotateAngleZ = 0.0f;
        this.MareLeg4.rotateAngleZ = 0.0f;
    }
}
