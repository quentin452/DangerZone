
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyAJ;

public class AppleJack extends ModelBase {

    private float wingspeed;
    ModelRenderer LegBR1;
    ModelRenderer AJBody;
    ModelRenderer MareHead;
    ModelRenderer AJNeck;
    ModelRenderer LegBL1;
    ModelRenderer LegR1;
    ModelRenderer LegL1;
    ModelRenderer Tail1;
    ModelRenderer LegBL2;
    ModelRenderer Mane;
    ModelRenderer LegL3;
    ModelRenderer LegR2;
    ModelRenderer LegR3;
    ModelRenderer LegL2;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer AJTail2;
    ModelRenderer AJTail1;
    ModelRenderer LegBR2;
    ModelRenderer AJHat4;
    ModelRenderer AJHat2;
    ModelRenderer AJHat1;
    ModelRenderer AJHat3;

    public AppleJack(final float f1) {
        this.wingspeed = 0.5f;
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.LegBR1 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(0.0f, -1.0f, -3.0f, 3, 5, 4);
        this.LegBR1.setRotationPoint(-4.0f, 12.0f, 6.0f);
        this.LegBR1.setTextureSize(256, 256);
        this.LegBR1.mirror = true;
        this.setRotation(this.LegBR1, 0.0872665f, 0.0f, 0.0f);
        (this.AJBody = new ModelRenderer((ModelBase) this, 21, 1)).addBox(-6.0f, -10.0f, -7.0f, 8, 15, 7);
        this.AJBody.setRotationPoint(2.0f, 6.0f, 2.0f);
        this.AJBody.setTextureSize(256, 256);
        this.AJBody.mirror = true;
        this.setRotation(this.AJBody, 1.570796f, 0.0f, 0.0f);
        (this.MareHead = new ModelRenderer((ModelBase) this, 54, 0)).addBox(-4.0f, -3.9f, -4.2f, 8, 8, 8);
        this.MareHead.setRotationPoint(0.0f, 0.5f, -8.0f);
        this.MareHead.setTextureSize(256, 256);
        this.MareHead.mirror = true;
        this.setRotation(this.MareHead, 0.0f, 0.0f, 0.0f);
        (this.AJNeck = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -0.5f, 4, 9, 5);
        this.AJNeck.setRotationPoint(-2.0f, 4.0f, -10.0f);
        this.AJNeck.setTextureSize(256, 256);
        this.AJNeck.mirror = true;
        this.setRotation(this.AJNeck, 0.2792527f, 0.0f, 0.0f);
        (this.LegBL1 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(0.0f, -1.0f, -3.0f, 3, 5, 4);
        this.LegBL1.setRotationPoint(1.0f, 12.0f, 6.0f);
        this.LegBL1.setTextureSize(256, 256);
        this.LegBL1.mirror = true;
        this.setRotation(this.LegBL1, 0.0872665f, 0.0f, 0.0f);
        (this.LegR1 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, -1.0f, -3.0f, 3, 5, 4);
        this.LegR1.setRotationPoint(-1.5f, 12.0f, -4.0f);
        this.LegR1.setTextureSize(256, 256);
        this.LegR1.mirror = true;
        this.setRotation(this.LegR1, -0.0349066f, 0.0f, 0.0f);
        (this.LegL1 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, -1.0f, -3.0f, 3, 5, 4);
        this.LegL1.setRotationPoint(1.5f, 12.0f, -4.0f);
        this.LegL1.setTextureSize(256, 256);
        this.LegL1.mirror = true;
        this.setRotation(this.LegL1, -0.0349066f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 92, 0)).addBox(-1.0f, -1.0f, -1.0f, 2, 3, 2);
        this.Tail1.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.Tail1.setTextureSize(256, 256);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 2.119181f, 0.0f, 0.0f);
        (this.LegBL2 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(0.0f, 4.0f, -2.5f, 3, 9, 4);
        this.LegBL2.setRotationPoint(1.0f, 12.0f, 6.0f);
        this.LegBL2.setTextureSize(256, 256);
        this.LegBL2.mirror = true;
        this.setRotation(this.LegBL2, 0.0698132f, 0.0f, 0.0f);
        (this.Mane = new ModelRenderer((ModelBase) this, 1, 46)).addBox(-4.0f, -4.0f, -5.0f, 9, 9, 9);
        this.Mane.setRotationPoint(-0.5f, 0.5f, -8.1f);
        this.Mane.setTextureSize(256, 256);
        this.Mane.mirror = true;
        this.setRotation(this.Mane, 0.0f, 0.0f, 0.0f);
        (this.LegL3 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 8.0f, -2.8f, 3, 4, 4);
        this.LegL3.setRotationPoint(1.5f, 12.0f, -4.0f);
        this.LegL3.setTextureSize(256, 256);
        this.LegL3.mirror = true;
        this.setRotation(this.LegL3, -0.0698132f, 0.0f, 0.0f);
        (this.LegR2 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 4.0f, -2.9f, 3, 4, 4);
        this.LegR2.setRotationPoint(-1.5f, 12.0f, -4.0f);
        this.LegR2.setTextureSize(256, 256);
        this.LegR2.mirror = true;
        this.setRotation(this.LegR2, -0.0523599f, 0.0f, 0.0f);
        (this.LegR3 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 8.0f, -2.8f, 3, 4, 4);
        this.LegR3.setRotationPoint(-1.5f, 12.0f, -4.0f);
        this.LegR3.setTextureSize(256, 256);
        this.LegR3.mirror = true;
        this.setRotation(this.LegR3, -0.0698132f, 0.0f, 0.0f);
        (this.LegL2 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 4.0f, -2.9f, 3, 4, 4);
        this.LegL2.setRotationPoint(1.5f, 12.0f, -4.0f);
        this.LegL2.setTextureSize(256, 256);
        this.LegL2.mirror = true;
        this.setRotation(this.LegL2, -0.0523599f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 102, 0)).addBox(-1.5f, 1.5f, -0.2f, 3, 3, 2);
        this.Tail2.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.Tail2.setTextureSize(256, 256);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 1.710216f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 116, 0)).addBox(-2.0f, 4.0f, 0.6f, 4, 4, 2);
        this.Tail3.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.Tail3.setTextureSize(256, 256);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 1.487144f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase) this, 130, 0)).addBox(-2.0f, 1.6f, 5.5f, 4, 6, 3);
        this.Tail4.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.Tail4.setTextureSize(256, 256);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.4089647f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase) this, 150, 0)).addBox(-2.0f, 3.0f, 7.8f, 4, 6, 3);
        this.Tail5.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.Tail5.setTextureSize(256, 256);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.AJTail2 = new ModelRenderer((ModelBase) this, 190, 0)).addBox(-2.0f, 10.0f, 8.0f, 4, 2, 3);
        this.AJTail2.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.AJTail2.setTextureSize(256, 256);
        this.AJTail2.mirror = true;
        this.setRotation(this.AJTail2, 0.0f, 0.0f, 0.0f);
        (this.AJTail1 = new ModelRenderer((ModelBase) this, 170, 0)).addBox(-1.0f, 8.0f, 9.0f, 2, 2, 1);
        this.AJTail1.setRotationPoint(0.0f, 8.0f, 7.0f);
        this.AJTail1.setTextureSize(256, 256);
        this.AJTail1.mirror = true;
        this.setRotation(this.AJTail1, 0.0f, 0.0f, 0.0f);
        (this.LegBR2 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(0.0f, 4.0f, -2.5f, 3, 9, 4);
        this.LegBR2.setRotationPoint(-4.0f, 12.0f, 6.0f);
        this.LegBR2.setTextureSize(256, 256);
        this.LegBR2.mirror = true;
        this.setRotation(this.LegBR2, 0.0698132f, 0.0f, 0.0f);
        (this.AJHat4 = new ModelRenderer((ModelBase) this, 0, 145)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 10);
        this.AJHat4.setRotationPoint(-5.0f, -4.5f, -10.0f);
        this.AJHat4.setTextureSize(256, 256);
        this.AJHat4.mirror = true;
        this.setRotation(this.AJHat4, -0.3490659f, 0.0f, 0.0f);
        (this.AJHat2 = new ModelRenderer((ModelBase) this, 0, 115)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 10);
        this.AJHat2.setRotationPoint(1.0f, -4.5f, -10.0f);
        this.AJHat2.setTextureSize(256, 256);
        this.AJHat2.mirror = true;
        this.setRotation(this.AJHat2, -0.3490659f, 0.0f, 0.0f);
        (this.AJHat1 = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 6);
        this.AJHat1.setRotationPoint(-3.0f, -7.0f, -7.0f);
        this.AJHat1.setTextureSize(256, 256);
        this.AJHat1.mirror = true;
        this.setRotation(this.AJHat1, -0.3490659f, 0.0f, 0.0f);
        (this.AJHat3 = new ModelRenderer((ModelBase) this, 0, 130)).addBox(0.0f, 0.0f, 2.0f, 4, 1, 8);
        this.AJHat3.setRotationPoint(-2.0f, -4.5f, -10.0f);
        this.AJHat3.setTextureSize(256, 256);
        this.AJHat3.mirror = true;
        this.setRotation(this.AJHat3, -0.3490659f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final MyAJ e = (MyAJ) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.1f * f1;
            newangle2 = MathHelper.cos((float) (f2 * 1.3f * this.wingspeed + 0.7853981633974483)) * 3.141593f
                * 0.1f
                * f1;
        } else {
            newangle = 0.0f;
        }
        this.MareHead.rotateAngleY = (float) Math.toRadians(f3);
        this.Mane.rotateAngleY = this.MareHead.rotateAngleY;
        this.LegL1.rotateAngleX = -0.087f + newangle;
        this.LegL2.rotateAngleX = -0.087f + newangle;
        this.LegL3.rotateAngleX = -0.087f + newangle;
        this.LegR1.rotateAngleX = -0.087f + newangle;
        this.LegR2.rotateAngleX = -0.087f + newangle;
        this.LegR3.rotateAngleX = -0.087f + newangle;
        this.LegBL1.rotateAngleX = -0.349f - newangle;
        this.LegBL2.rotateAngleX = -newangle;
        this.LegBR1.rotateAngleX = -0.349f - newangle;
        this.LegBR2.rotateAngleX = newangle;
        this.LegBR1.render(f5);
        this.AJBody.render(f5);
        this.MareHead.render(f5);
        this.AJNeck.render(f5);
        this.LegBL1.render(f5);
        this.LegR1.render(f5);
        this.LegL1.render(f5);
        this.Tail1.render(f5);
        this.LegBL2.render(f5);
        this.Mane.render(f5);
        this.LegL3.render(f5);
        this.LegR2.render(f5);
        this.LegR3.render(f5);
        this.LegL2.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.Tail4.render(f5);
        this.Tail5.render(f5);
        this.AJTail2.render(f5);
        this.AJTail1.render(f5);
        this.LegBR2.render(f5);
        this.AJHat4.render(f5);
        this.AJHat2.render(f5);
        this.AJHat1.render(f5);
        this.AJHat3.render(f5);
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
