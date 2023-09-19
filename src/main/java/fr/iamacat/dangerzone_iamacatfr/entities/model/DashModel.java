
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DashInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;

public class DashModel extends ModelBase {

    private float wingspeed;
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
    ModelRenderer wr1;
    ModelRenderer wr2;
    ModelRenderer wr3;
    ModelRenderer wr4;
    ModelRenderer w1;
    ModelRenderer w2;
    ModelRenderer w3;
    ModelRenderer w4;

    public DashModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.MareHead = new ModelRenderer((ModelBase) this, 54, 0)).addBox(-4.0f, -3.9f, -5.9f, 8, 8, 8);
        this.MareHead.setRotationPoint(0.0f, 0.0f, -8.0f);
        this.MareHead.setTextureSize(128, 64);
        this.MareHead.mirror = true;
        this.setRotation(this.MareHead, 0.0f, 0.0f, 0.0f);
        (this.MareBody = new ModelRenderer((ModelBase) this, 24, 1)).addBox(-6.0f, -10.0f, -7.0f, 8, 15, 6);
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
        (this.MareNeck = new ModelRenderer((ModelBase) this, 50, 32)).addBox(0.0f, 0.0f, 0.0f, 4, 9, 4);
        this.MareNeck.setRotationPoint(-2.0f, 2.0f, -11.0f);
        this.MareNeck.setTextureSize(128, 64);
        this.MareNeck.mirror = true;
        this.setRotation(this.MareNeck, 0.2792527f, 0.0f, 0.0f);
        (this.MareTailConnection = new ModelRenderer((ModelBase) this, 92, 0)).addBox(-1.0f, 0.0f, 0.0f, 2, 4, 1);
        this.MareTailConnection.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.MareTailConnection.setTextureSize(128, 64);
        this.MareTailConnection.mirror = true;
        this.setRotation(this.MareTailConnection, 2.119181f, 0.0f, 0.0f);
        (this.MareTail = new ModelRenderer((ModelBase) this, 24, 31)).addBox(0.0f, 0.0f, 0.0f, 5, 12, 3);
        this.MareTail.setRotationPoint(-2.0f, 5.0f, 10.0f);
        this.MareTail.setTextureSize(128, 64);
        this.MareTail.mirror = true;
        this.setRotation(this.MareTail, 0.0f, 0.0f, 0.0f);
        (this.MareHeadWear = new ModelRenderer((ModelBase) this, 1, 46)).addBox(-4.5f, -4.0f, -6.0f, 9, 9, 9);
        this.MareHeadWear.setRotationPoint(0.0f, 0.0f, -8.0f);
        this.MareHeadWear.setTextureSize(128, 64);
        this.MareHeadWear.mirror = true;
        this.setRotation(this.MareHeadWear, 0.0f, 0.0f, 0.0f);
        (this.wr1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 1, 2);
        this.wr1.setRotationPoint(-4.0f, 8.0f, 0.0f);
        this.wr1.setTextureSize(128, 64);
        this.wr1.mirror = true;
        this.setRotation(this.wr1, 0.0f, 2.881397f, 0.0f);
        (this.wr2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 2);
        this.wr2.setRotationPoint(-4.0f, 8.0f, 0.0f);
        this.wr2.setTextureSize(128, 64);
        this.wr2.mirror = true;
        this.setRotation(this.wr2, 0.0f, -3.065686f, 0.0f);
        (this.wr3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 2);
        this.wr3.setRotationPoint(-4.0f, 8.0f, 0.0f);
        this.wr3.setTextureSize(128, 64);
        this.wr3.mirror = true;
        this.setRotation(this.wr3, 0.0f, -2.722714f, 0.0f);
        (this.wr4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 1, 2);
        this.wr4.setRotationPoint(-4.0f, 8.0f, 0.0f);
        this.wr4.setTextureSize(128, 64);
        this.wr4.mirror = true;
        this.setRotation(this.wr4, 0.0f, -2.303835f, 0.0f);
        (this.w1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 1, 2);
        this.w1.setRotationPoint(4.0f, 8.0f, -2.0f);
        this.w1.setTextureSize(128, 64);
        this.w1.mirror = true;
        this.setRotation(this.w1, 0.0f, 0.1858931f, 0.0f);
        (this.w2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 2);
        this.w2.setRotationPoint(4.0f, 8.0f, -2.0f);
        this.w2.setTextureSize(128, 64);
        this.w2.mirror = true;
        this.setRotation(this.w2, 0.0f, -0.1502636f, 0.0f);
        (this.w3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 2);
        this.w3.setRotationPoint(4.0f, 8.0f, -2.0f);
        this.w3.setTextureSize(128, 64);
        this.w3.mirror = true;
        this.setRotation(this.w3, 0.0f, -0.5038735f, 0.0f);
        (this.w4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 1, 2);
        this.w4.setRotationPoint(4.0f, 8.0f, -2.0f);
        this.w4.setTextureSize(128, 64);
        this.w4.mirror = true;
        this.setRotation(this.w4, 0.0f, -0.8652289f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final DashInstance e = (DashInstance) entity;
        float newangle = 0.0f;
        final float lspeed = 0.0f;
        final InfoRenderer r = null;
        final float tailspeed = 0.76f;
        final float tailamp = 0.45f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.141593f * 0.28f;
        this.MareHead.rotateAngleY = (float) Math.toRadians(f3);
        this.MareHeadWear.rotateAngleY = this.MareHead.rotateAngleY;
        this.MareHead.rotateAngleX = (float) Math.toRadians(f4) / 3.0f;
        this.MareHeadWear.rotateAngleX = (float) Math.toRadians(f4) / 3.0f;
        this.w1.rotateAngleZ = newangle;
        this.w2.rotateAngleZ = newangle * 4.0f / 3.0f;
        this.w3.rotationPointY = this.w1.rotationPointY;
        this.w3.rotationPointX = this.w1.rotationPointX;
        this.w3.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.w4.rotationPointY = this.w1.rotationPointY;
        this.w4.rotationPointX = this.w1.rotationPointX;
        this.w4.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.w4.rotationPointY = this.w1.rotationPointY;
        this.w4.rotationPointX = this.w1.rotationPointX;
        this.wr1.rotateAngleZ = -newangle;
        this.wr2.rotateAngleZ = -newangle * 4.0f / 3.0f;
        this.wr2.rotationPointY = this.wr1.rotationPointY;
        this.wr2.rotationPointX = this.wr1.rotationPointX;
        this.wr3.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.wr3.rotationPointY = this.wr1.rotationPointY;
        this.wr3.rotationPointX = this.wr1.rotationPointX;
        this.wr4.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.wr4.rotationPointY = this.wr1.rotationPointY;
        this.wr4.rotationPointX = this.wr1.rotationPointX;
        this.MareNeck.rotateAngleY = (float) Math.toRadians(f3) / 2.0f;
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
        this.wr1.render(f5);
        this.wr2.render(f5);
        this.wr3.render(f5);
        this.wr4.render(f5);
        this.w1.render(f5);
        this.w2.render(f5);
        this.w3.render(f5);
        this.w4.render(f5);
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
