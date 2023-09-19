
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelHammy extends ModelBase {

    ModelRenderer Handle1;
    ModelRenderer Handle2;
    ModelRenderer Handle3;
    ModelRenderer Head1;
    ModelRenderer Head2;
    ModelRenderer Head3;
    ModelRenderer Head4;
    ModelRenderer Band1;
    ModelRenderer Band2;
    ModelRenderer Band3;
    ModelRenderer Band4;
    ModelRenderer Band5;
    ModelRenderer Band6;
    ModelRenderer Band7;
    ModelRenderer Band8;
    ModelRenderer Point1;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    ModelRenderer Spike4;
    ModelRenderer Band1b;
    ModelRenderer Band2b;
    ModelRenderer Band3b;
    ModelRenderer Band4b;
    ModelRenderer Band5b;
    ModelRenderer Band6b;
    ModelRenderer Band7b;
    ModelRenderer Band8b;
    ModelRenderer Point1b;
    ModelRenderer Spike2b;
    ModelRenderer Spike1b;
    ModelRenderer Spike3b;
    ModelRenderer Spike4b;

    public ModelHammy() {
        this.textureWidth = 128;
        this.textureHeight = 256;
        (this.Handle1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.5f, -12.0f, -1.0f, 1, 36, 2);
        this.Handle1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Handle1.setTextureSize(128, 256);
        this.Handle1.mirror = true;
        this.setRotation(this.Handle1, 0.0f, 0.0f, 0.0f);
        (this.Handle2 = new ModelRenderer((ModelBase) this, 7, 0)).addBox(-0.5f, -12.0f, -1.0f, 1, 36, 2);
        this.Handle2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Handle2.setTextureSize(128, 256);
        this.Handle2.mirror = true;
        this.setRotation(this.Handle2, 0.0f, 1.047198f, 0.0f);
        (this.Handle3 = new ModelRenderer((ModelBase) this, 14, 0)).addBox(-0.5f, -12.0f, -1.0f, 1, 36, 2);
        this.Handle3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Handle3.setTextureSize(128, 256);
        this.Handle3.mirror = true;
        this.setRotation(this.Handle3, 0.0f, -1.047198f, 0.0f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 0, 230)).addBox(-20.0f, -22.0f, -7.0f, 40, 6, 14);
        this.Head1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head1.setTextureSize(128, 256);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase) this, 0, 184)).addBox(-20.0f, -26.0f, -3.0f, 40, 14, 6);
        this.Head2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head2.setTextureSize(128, 256);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.Head3 = new ModelRenderer((ModelBase) this, 0, 161)).addBox(-20.0f, -16.5f, 6.4f, 40, 6, 14);
        this.Head3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head3.setTextureSize(128, 256);
        this.Head3.mirror = true;
        this.setRotation(this.Head3, 0.7853982f, 0.0f, 0.0f);
        (this.Head4 = new ModelRenderer((ModelBase) this, 0, 207)).addBox(-20.0f, -16.5f, -20.4f, 40, 6, 14);
        this.Head4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Head4.setTextureSize(128, 256);
        this.Head4.mirror = true;
        this.setRotation(this.Head4, -0.7853982f, 0.0f, 0.0f);
        (this.Band1 = new ModelRenderer((ModelBase) this, 0, 88)).addBox(12.0f, -22.5f, -8.0f, 5, 7, 1);
        this.Band1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band1.setTextureSize(128, 256);
        this.Band1.mirror = true;
        this.setRotation(this.Band1, 0.0f, 0.0f, 0.0f);
        (this.Band2 = new ModelRenderer((ModelBase) this, 0, 128)).addBox(12.0f, -22.5f, 7.0f, 5, 7, 1);
        this.Band2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band2.setTextureSize(128, 256);
        this.Band2.mirror = true;
        this.setRotation(this.Band2, 0.0f, 0.0f, 0.0f);
        (this.Band3 = new ModelRenderer((ModelBase) this, 0, 98)).addBox(12.0f, -17.0f, 5.4f, 5, 7, 1);
        this.Band3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band3.setTextureSize(128, 256);
        this.Band3.mirror = true;
        this.setRotation(this.Band3, 0.7853982f, 0.0f, 0.0f);
        (this.Band4 = new ModelRenderer((ModelBase) this, 0, 118)).addBox(12.0f, -16.9f, -6.4f, 5, 7, 1);
        this.Band4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band4.setTextureSize(128, 256);
        this.Band4.mirror = true;
        this.setRotation(this.Band4, -0.7853982f, 0.0f, 0.0f);
        (this.Band5 = new ModelRenderer((ModelBase) this, 0, 108)).addBox(12.0f, -12.0f, -3.5f, 5, 1, 7);
        this.Band5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band5.setTextureSize(128, 256);
        this.Band5.mirror = true;
        this.setRotation(this.Band5, 0.0f, 0.0f, 0.0f);
        (this.Band6 = new ModelRenderer((ModelBase) this, 0, 79)).addBox(12.0f, -16.5f, -21.4f, 5, 6, 1);
        this.Band6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band6.setTextureSize(128, 256);
        this.Band6.mirror = true;
        this.setRotation(this.Band6, -0.7853982f, 0.0f, 0.0f);
        (this.Band7 = new ModelRenderer((ModelBase) this, 0, 138)).addBox(12.0f, -17.0f, 20.4f, 5, 7, 1);
        this.Band7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band7.setTextureSize(128, 256);
        this.Band7.mirror = true;
        this.setRotation(this.Band7, 0.7853982f, 0.0f, 0.0f);
        (this.Band8 = new ModelRenderer((ModelBase) this, 0, 148)).addBox(12.0f, -27.0f, -3.5f, 5, 1, 7);
        this.Band8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band8.setTextureSize(128, 256);
        this.Band8.mirror = true;
        this.setRotation(this.Band8, 0.0f, 0.0f, 0.0f);
        (this.Point1 = new ModelRenderer((ModelBase) this, 28, 130)).addBox(-2.5f, -29.5f, -0.5f, 5, 5, 1);
        this.Point1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Point1.setTextureSize(128, 256);
        this.Point1.mirror = true;
        this.setRotation(this.Point1, 0.0f, 0.0f, 0.7853982f);
        (this.Spike1 = new ModelRenderer((ModelBase) this, 67, 0)).addBox(14.0f, -20.0f, -10.0f, 1, 1, 20);
        this.Spike1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike1.setTextureSize(128, 256);
        this.Spike1.mirror = true;
        this.setRotation(this.Spike1, 0.0f, 0.0f, 0.0f);
        (this.Spike2 = new ModelRenderer((ModelBase) this, 49, 0)).addBox(14.0f, -29.0f, 0.0f, 1, 20, 1);
        this.Spike2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike2.setTextureSize(128, 256);
        this.Spike2.mirror = true;
        this.setRotation(this.Spike2, 0.0f, 0.0f, 0.0f);
        (this.Spike3 = new ModelRenderer((ModelBase) this, 55, 0)).addBox(14.0f, -23.5f, 13.0f, 1, 20, 1);
        this.Spike3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike3.setTextureSize(128, 256);
        this.Spike3.mirror = true;
        this.setRotation(this.Spike3, 0.7853982f, 0.0f, 0.0f);
        (this.Spike4 = new ModelRenderer((ModelBase) this, 61, 0)).addBox(-15.0f, -23.5f, -14.0f, 1, 20, 1);
        this.Spike4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike4.setTextureSize(128, 256);
        this.Spike4.mirror = true;
        this.setRotation(this.Spike4, -0.7853982f, 0.0f, 0.0f);
        (this.Band1b = new ModelRenderer((ModelBase) this, 0, 88)).addBox(-17.0f, -22.5f, -8.0f, 5, 7, 1);
        this.Band1b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band1b.setTextureSize(128, 256);
        this.Band1b.mirror = true;
        this.setRotation(this.Band1b, 0.0f, 0.0f, 0.0f);
        (this.Band2b = new ModelRenderer((ModelBase) this, 0, 128)).addBox(-17.0f, -22.5f, 7.0f, 5, 7, 1);
        this.Band2b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band2b.setTextureSize(128, 256);
        this.Band2b.mirror = true;
        this.setRotation(this.Band2b, 0.0f, 0.0f, 0.0f);
        (this.Band3b = new ModelRenderer((ModelBase) this, 0, 98)).addBox(-17.0f, -17.0f, 5.4f, 5, 7, 1);
        this.Band3b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band3b.setTextureSize(128, 256);
        this.Band3b.mirror = true;
        this.setRotation(this.Band3b, 0.7853982f, 0.0f, 0.0f);
        (this.Band4b = new ModelRenderer((ModelBase) this, 0, 118)).addBox(-17.0f, -16.9f, -6.4f, 5, 7, 1);
        this.Band4b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band4b.setTextureSize(128, 256);
        this.Band4b.mirror = true;
        this.setRotation(this.Band4b, -0.7853982f, 0.0f, 0.0f);
        (this.Band5b = new ModelRenderer((ModelBase) this, 0, 108)).addBox(-17.0f, -12.0f, -3.5f, 5, 1, 7);
        this.Band5b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band5b.setTextureSize(128, 256);
        this.Band5b.mirror = true;
        this.setRotation(this.Band5b, 0.0f, 0.0f, 0.0f);
        (this.Band6b = new ModelRenderer((ModelBase) this, 0, 79)).addBox(-17.0f, -16.5f, -21.4f, 5, 6, 1);
        this.Band6b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band6b.setTextureSize(128, 256);
        this.Band6b.mirror = true;
        this.setRotation(this.Band6b, -0.7853982f, 0.0f, 0.0f);
        (this.Band7b = new ModelRenderer((ModelBase) this, 0, 138)).addBox(-17.0f, -17.0f, 20.4f, 5, 7, 1);
        this.Band7b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band7b.setTextureSize(128, 256);
        this.Band7b.mirror = true;
        this.setRotation(this.Band7b, 0.7853982f, 0.0f, 0.0f);
        (this.Band8b = new ModelRenderer((ModelBase) this, 0, 148)).addBox(-17.0f, -27.0f, -3.5f, 5, 1, 7);
        this.Band8b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Band8b.setTextureSize(128, 256);
        this.Band8b.mirror = true;
        this.setRotation(this.Band8b, 0.0f, 0.0f, 0.0f);
        (this.Point1b = new ModelRenderer((ModelBase) this, 28, 130)).addBox(-29.5f, -2.5f, -0.5f, 5, 5, 1);
        this.Point1b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Point1b.setTextureSize(128, 256);
        this.Point1b.mirror = true;
        this.setRotation(this.Point1b, 0.0f, 0.0f, 0.7853982f);
        (this.Spike2b = new ModelRenderer((ModelBase) this, 49, 0)).addBox(-15.0f, -29.0f, 0.0f, 1, 20, 1);
        this.Spike2b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike2b.setTextureSize(128, 256);
        this.Spike2b.mirror = true;
        this.setRotation(this.Spike2b, 0.0f, 0.0f, 0.0f);
        (this.Spike1b = new ModelRenderer((ModelBase) this, 67, 0)).addBox(-15.0f, -20.0f, -10.0f, 1, 1, 20);
        this.Spike1b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike1b.setTextureSize(128, 256);
        this.Spike1b.mirror = true;
        this.setRotation(this.Spike1b, 0.0f, 0.0f, 0.0f);
        (this.Spike3b = new ModelRenderer((ModelBase) this, 55, 0)).addBox(-15.0f, -23.5f, 13.0f, 1, 20, 1);
        this.Spike3b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike3b.setTextureSize(128, 256);
        this.Spike3b.mirror = true;
        this.setRotation(this.Spike3b, 0.7853982f, 0.0f, 0.0f);
        (this.Spike4b = new ModelRenderer((ModelBase) this, 61, 0)).addBox(14.0f, -23.5f, -14.0f, 1, 20, 1);
        this.Spike4b.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Spike4b.setTextureSize(128, 256);
        this.Spike4b.mirror = true;
        this.setRotation(this.Spike4b, -0.7853982f, 0.0f, 0.0f);
    }

    public void render() {
        final float f5 = 1.0f;
        this.Handle1.render(f5);
        this.Handle2.render(f5);
        this.Handle3.render(f5);
        this.Head1.render(f5);
        this.Head2.render(f5);
        this.Head3.render(f5);
        this.Head4.render(f5);
        this.Band1.render(f5);
        this.Band2.render(f5);
        this.Band3.render(f5);
        this.Band4.render(f5);
        this.Band5.render(f5);
        this.Band6.render(f5);
        this.Band7.render(f5);
        this.Band8.render(f5);
        this.Point1.render(f5);
        this.Spike1.render(f5);
        this.Spike2.render(f5);
        this.Spike3.render(f5);
        this.Spike4.render(f5);
        this.Band1b.render(f5);
        this.Band2b.render(f5);
        this.Band3b.render(f5);
        this.Band4b.render(f5);
        this.Band5b.render(f5);
        this.Band6b.render(f5);
        this.Band7b.render(f5);
        this.Band8b.render(f5);
        this.Point1b.render(f5);
        this.Spike2b.render(f5);
        this.Spike1b.render(f5);
        this.Spike3b.render(f5);
        this.Spike4b.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
