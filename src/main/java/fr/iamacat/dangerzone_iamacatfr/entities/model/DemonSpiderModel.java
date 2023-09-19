
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class DemonSpiderModel extends ModelBase {

    ModelRenderer Head;
    ModelRenderer Body;
    ModelRenderer RearEnd;
    ModelRenderer Leg1;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer Leg2;
    ModelRenderer Leg7;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer Leg8;
    ModelRenderer BLeg3;
    ModelRenderer BLeg2;
    ModelRenderer BLeg4;
    ModelRenderer BLeg6;
    ModelRenderer BLeg5;
    ModelRenderer BLeg1;
    ModelRenderer BLeg7;
    ModelRenderer BLeg8;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    ModelRenderer Pincer1;
    ModelRenderer Pincer2;

    public DemonSpiderModel() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.Head = new ModelRenderer((ModelBase) this, 151, 6)).addBox(-9.0f, -8.0f, -24.0f, 18, 18, 18);
        this.Head.setRotationPoint(0.0f, 0.0f, -3.0f);
        this.Head.setTextureSize(512, 512);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase) this, 16, 145)).addBox(-4.333333f, -3.0f, -13.0f, 9, 9, 32);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(512, 512);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.RearEnd = new ModelRenderer((ModelBase) this, 22, 92)).addBox(-9.0f, -6.0f, 12.0f, 18, 15, 25);
        this.RearEnd.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.RearEnd.setTextureSize(512, 512);
        this.RearEnd.mirror = true;
        this.setRotation(this.RearEnd, 0.0f, 0.0f, 0.0f);
        (this.Leg1 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg1.setRotationPoint(4.0f, 0.0f, -1.0f);
        this.Leg1.setTextureSize(512, 512);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0f, 0.5759587f, 0.1919862f);
        (this.Leg6 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg6.setRotationPoint(4.0f, 0.0f, 0.0f);
        this.Leg6.setTextureSize(512, 512);
        this.Leg6.mirror = true;
        this.setRotation(this.Leg6, 0.0f, 0.2792527f, 0.1919862f);
        (this.Leg4 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg4.setRotationPoint(4.0f, 0.0f, 1.0f);
        this.Leg4.setTextureSize(512, 512);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0f, -0.2792527f, 0.1919862f);
        (this.Leg2 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-1.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg2.setRotationPoint(4.0f, 0.0f, 2.0f);
        this.Leg2.setTextureSize(512, 512);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, -0.5759587f, 0.1919862f);
        (this.Leg7 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-25.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg7.setRotationPoint(-4.0f, 0.0f, -1.0f);
        this.Leg7.setTextureSize(512, 512);
        this.Leg7.mirror = true;
        this.setRotation(this.Leg7, 0.0f, -0.5759587f, -0.1919862f);
        (this.Leg5 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-25.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg5.setRotationPoint(-4.0f, 0.0f, 0.0f);
        this.Leg5.setTextureSize(512, 512);
        this.Leg5.mirror = true;
        this.setRotation(this.Leg5, 0.0f, -0.2792527f, -0.1919862f);
        (this.Leg3 = new ModelRenderer((ModelBase) this, 25, 0)).addBox(-25.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg3.setRotationPoint(-4.0f, 0.0f, 1.0f);
        this.Leg3.setTextureSize(512, 512);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0f, 0.2792527f, -0.1919862f);
        (this.Leg8 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-25.0f, -1.0f, -1.0f, 26, 2, 2);
        this.Leg8.setRotationPoint(-4.0f, 0.0f, 2.0f);
        this.Leg8.setTextureSize(512, 512);
        this.Leg8.mirror = true;
        this.setRotation(this.Leg8, 0.0f, 0.5759587f, -0.1919862f);
        (this.BLeg3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg3.setRotationPoint(27.0f, 5.0f, 7.0f);
        this.BLeg3.setTextureSize(512, 512);
        this.BLeg3.mirror = true;
        this.setRotation(this.BLeg3, 0.0f, -0.2617994f, 1.518436f);
        (this.BLeg2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg2.setRotationPoint(26.0f, 5.0f, -7.0f);
        this.BLeg2.setTextureSize(512, 512);
        this.BLeg2.mirror = true;
        this.setRotation(this.BLeg2, 0.0f, 0.2443461f, 1.48353f);
        (this.BLeg4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg4.setRotationPoint(24.0f, 4.0f, 14.0f);
        this.BLeg4.setTextureSize(512, 512);
        this.BLeg4.mirror = true;
        this.setRotation(this.BLeg4, 0.0f, -0.6981317f, 1.466077f);
        (this.BLeg6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg6.setRotationPoint(-28.0f, 4.0f, -6.0f);
        this.BLeg6.setTextureSize(512, 512);
        this.BLeg6.mirror = true;
        this.setRotation(this.BLeg6, 0.0f, 2.844887f, 1.37881f);
        (this.BLeg5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg5.setRotationPoint(-25.0f, 4.0f, -14.0f);
        this.BLeg5.setTextureSize(512, 512);
        this.BLeg5.mirror = true;
        this.setRotation(this.BLeg5, 0.0f, 2.443461f, 1.37881f);
        (this.BLeg1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg1.setRotationPoint(25.0f, 4.0f, -15.0f);
        this.BLeg1.setTextureSize(512, 512);
        this.BLeg1.mirror = true;
        this.setRotation(this.BLeg1, 0.0f, 0.5585054f, 1.43117f);
        (this.BLeg7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg7.setRotationPoint(-28.0f, 4.0f, 9.0f);
        this.BLeg7.setTextureSize(512, 512);
        this.BLeg7.mirror = true;
        this.setRotation(this.BLeg7, 0.0f, -2.96706f, 1.466077f);
        (this.BLeg8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 33, 2, 2);
        this.BLeg8.setRotationPoint(-24.0f, 4.0f, 16.0f);
        this.BLeg8.setTextureSize(512, 512);
        this.BLeg8.mirror = true;
        this.setRotation(this.BLeg8, 0.0f, -2.583087f, 1.32645f);
        (this.Spike1 = new ModelRenderer((ModelBase) this, 94, 33)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 18);
        this.Spike1.setRotationPoint(0.0f, 0.0f, 37.0f);
        this.Spike1.setTextureSize(512, 512);
        this.Spike1.mirror = true;
        this.setRotation(this.Spike1, 0.0f, 0.0f, 0.0f);
        (this.Spike2 = new ModelRenderer((ModelBase) this, 15, 35)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Spike2.setRotationPoint(1.0f, 0.0f, 36.0f);
        this.Spike2.setTextureSize(512, 512);
        this.Spike2.mirror = true;
        this.setRotation(this.Spike2, 0.0f, 0.0f, 0.0f);
        (this.Spike3 = new ModelRenderer((ModelBase) this, 0, 35)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.Spike3.setRotationPoint(-1.0f, 0.0f, 36.0f);
        this.Spike3.setTextureSize(512, 512);
        this.Spike3.mirror = true;
        this.setRotation(this.Spike3, 0.0f, 0.0f, 0.0f);
        (this.Pincer1 = new ModelRenderer((ModelBase) this, 0, 38)).addBox(0.0f, 0.0f, 0.0f, 6, 1, 1);
        this.Pincer1.setRotationPoint(3.0f, 3.0f, -27.0f);
        this.Pincer1.setTextureSize(512, 512);
        this.Pincer1.mirror = true;
        this.setRotation(this.Pincer1, 0.0f, 0.6457718f, 0.0f);
        (this.Pincer2 = new ModelRenderer((ModelBase) this, 0, 38)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.Pincer2.setRotationPoint(-3.0f, 3.0f, -27.0f);
        this.Pincer2.setTextureSize(512, 512);
        this.Pincer2.mirror = true;
        this.setRotation(this.Pincer2, 0.0f, -2.356194f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Head.render(f5);
        this.Body.render(f5);
        this.RearEnd.render(f5);
        this.Leg1.render(f5);
        this.Leg6.render(f5);
        this.Leg4.render(f5);
        this.Leg2.render(f5);
        this.Leg7.render(f5);
        this.Leg5.render(f5);
        this.Leg3.render(f5);
        this.Leg8.render(f5);
        this.BLeg3.render(f5);
        this.BLeg2.render(f5);
        this.BLeg4.render(f5);
        this.BLeg6.render(f5);
        this.BLeg5.render(f5);
        this.BLeg1.render(f5);
        this.BLeg7.render(f5);
        this.BLeg8.render(f5);
        this.Spike1.render(f5);
        this.Spike2.render(f5);
        this.Spike3.render(f5);
        this.Pincer1.render(f5);
        this.Pincer2.render(f5);
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
