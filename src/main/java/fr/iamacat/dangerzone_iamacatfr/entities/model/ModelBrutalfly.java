
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelBrutalfly extends ModelBase {

    ModelRenderer body;
    ModelRenderer leftwing;
    ModelRenderer rightwing;
    ModelRenderer leftwing2;
    ModelRenderer rightwing2;
    ModelRenderer leftwing3;
    ModelRenderer rightwing3;
    ModelRenderer head;
    ModelRenderer leftwing4;
    ModelRenderer rightwing4;
    ModelRenderer leftwing5;
    ModelRenderer leftwing6;
    ModelRenderer rightwing5;
    ModelRenderer rightwing6;
    private float wingspeed;

    public ModelBrutalfly(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.wingspeed = f1;
        (this.body = new ModelRenderer((ModelBase) this, 21, 19)).addBox(0.0f, 0.0f, -4.0f, 1, 1, 8);
        this.body.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leftwing = new ModelRenderer((ModelBase) this, 43, 24)).addBox(0.0f, 0.0f, -4.0f, 1, 1, 5);
        this.leftwing.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing.setTextureSize(64, 32);
        this.leftwing.mirror = true;
        this.setRotation(this.leftwing, 0.0f, 0.0f, 0.0f);
        (this.rightwing = new ModelRenderer((ModelBase) this, 43, 17)).addBox(-1.0f, 0.0f, -4.0f, 1, 1, 5);
        this.rightwing.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing.setTextureSize(64, 32);
        this.rightwing.mirror = true;
        this.setRotation(this.rightwing, 0.0f, 0.0f, 0.0f);
        (this.leftwing2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.0f, 0.0f, -6.0f, 6, 1, 7);
        this.leftwing2.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing2.setTextureSize(64, 32);
        this.leftwing2.mirror = true;
        this.setRotation(this.leftwing2, 0.0f, 0.0f, 0.0f);
        (this.rightwing2 = new ModelRenderer((ModelBase) this, 29, 0)).addBox(-7.0f, 0.0f, -6.0f, 6, 1, 7);
        this.rightwing2.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing2.setTextureSize(64, 32);
        this.rightwing2.mirror = true;
        this.setRotation(this.rightwing2, 0.0f, 0.0f, 0.0f);
        (this.leftwing3 = new ModelRenderer((ModelBase) this, 0, 9)).addBox(0.0f, 0.0f, 1.0f, 5, 1, 5);
        this.leftwing3.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing3.setTextureSize(64, 32);
        this.leftwing3.mirror = true;
        this.setRotation(this.leftwing3, 0.0f, 0.0f, 0.0f);
        (this.rightwing3 = new ModelRenderer((ModelBase) this, 27, 9)).addBox(-5.0f, 0.0f, 1.0f, 5, 1, 5);
        this.rightwing3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing3.setTextureSize(64, 32);
        this.rightwing3.mirror = true;
        this.setRotation(this.rightwing3, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 21, 11)).addBox(0.0f, 0.0f, -6.0f, 1, 1, 1);
        this.head.setRotationPoint(0.0f, 17.0f, 1.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.leftwing4 = new ModelRenderer((ModelBase) this, 2, 24)).addBox(0.0f, 0.0f, 6.0f, 2, 1, 7);
        this.leftwing4.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing4.setTextureSize(64, 32);
        this.leftwing4.mirror = true;
        this.setRotation(this.leftwing4, 0.0f, 0.0f, 0.0f);
        (this.rightwing4 = new ModelRenderer((ModelBase) this, 2, 16)).addBox(-2.0f, 0.0f, 6.0f, 2, 1, 7);
        this.rightwing4.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing4.setTextureSize(64, 32);
        this.rightwing4.mirror = true;
        this.setRotation(this.rightwing4, 0.0f, 0.0f, 0.0f);
        (this.leftwing5 = new ModelRenderer((ModelBase) this, 21, 16)).addBox(1.0f, 0.0f, -7.0f, 1, 1, 1);
        this.leftwing5.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing5.setTextureSize(64, 32);
        this.leftwing5.mirror = true;
        this.setRotation(this.leftwing5, 0.0f, 0.0f, 0.0f);
        (this.leftwing6 = new ModelRenderer((ModelBase) this, 50, 10)).addBox(7.0f, 0.0f, -6.0f, 2, 1, 1);
        this.leftwing6.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing6.setTextureSize(64, 32);
        this.leftwing6.mirror = true;
        this.setRotation(this.leftwing6, 0.0f, 0.0f, 0.0f);
        (this.rightwing5 = new ModelRenderer((ModelBase) this, 27, 16)).addBox(-2.0f, 0.0f, -7.0f, 1, 1, 1);
        this.rightwing5.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing5.setTextureSize(64, 32);
        this.rightwing5.mirror = true;
        this.setRotation(this.rightwing5, 0.0f, 0.0f, 0.0f);
        (this.rightwing6 = new ModelRenderer((ModelBase) this, 50, 13)).addBox(-9.0f, 0.0f, -6.0f, 2, 1, 1);
        this.rightwing6.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing6.setTextureSize(64, 32);
        this.rightwing6.mirror = true;
        this.setRotation(this.rightwing6, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.head.render(f5);
        this.body.render(f5);
        this.rightwing.rotateAngleZ = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f;
        this.rightwing2.rotateAngleZ = this.rightwing.rotateAngleZ;
        this.rightwing3.rotateAngleZ = this.rightwing.rotateAngleZ;
        this.rightwing4.rotateAngleZ = this.rightwing.rotateAngleZ;
        this.rightwing5.rotateAngleZ = this.rightwing.rotateAngleZ;
        this.rightwing6.rotateAngleZ = this.rightwing.rotateAngleZ;
        this.leftwing.rotateAngleZ = -this.rightwing.rotateAngleZ;
        this.leftwing2.rotateAngleZ = -this.rightwing.rotateAngleZ;
        this.leftwing3.rotateAngleZ = -this.rightwing.rotateAngleZ;
        this.leftwing4.rotateAngleZ = -this.rightwing.rotateAngleZ;
        this.leftwing5.rotateAngleZ = -this.rightwing.rotateAngleZ;
        this.leftwing6.rotateAngleZ = -this.rightwing.rotateAngleZ;
        this.leftwing.render(f5);
        this.rightwing.render(f5);
        this.leftwing2.render(f5);
        this.rightwing2.render(f5);
        this.leftwing3.render(f5);
        this.rightwing3.render(f5);
        this.leftwing4.render(f5);
        this.rightwing4.render(f5);
        this.leftwing5.render(f5);
        this.rightwing5.render(f5);
        this.leftwing6.render(f5);
        this.rightwing6.render(f5);
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
