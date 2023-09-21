
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelSlice extends ModelBase {

    ModelRenderer Grip;
    ModelRenderer Blade1;
    ModelRenderer Handguard2;
    ModelRenderer Handguard1;
    ModelRenderer hg2;
    ModelRenderer hg4;
    ModelRenderer hg3;
    ModelRenderer hg1;
    ModelRenderer BaseGrip;
    ModelRenderer Bottom;
    ModelRenderer Blade2;
    ModelRenderer Blade3;
    ModelRenderer Blade4;
    ModelRenderer Shape1;

    public ModelSlice() {
        this.textureWidth = 64;
        this.textureHeight = 128;
        (this.Grip = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -6.0f, 0.0f, 1, 12, 1);
        this.Grip.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Grip.setTextureSize(64, 128);
        this.Grip.mirror = true;
        this.setRotation(this.Grip, 0.0f, 0.0f, 0.0f);
        (this.Blade1 = new ModelRenderer((ModelBase) this, 6, 49)).addBox(0.0f, -41.0f, 0.0f, 1, 34, 3);
        this.Blade1.setRotationPoint(0.5f, 0.0f, -2.3f);
        this.Blade1.setTextureSize(64, 128);
        this.Blade1.mirror = true;
        this.setRotation(this.Blade1, 0.0f, 0.3490659f, 0.0f);
        (this.Handguard2 = new ModelRenderer((ModelBase) this, 16, 0)).addBox(0.0f, -7.0f, -4.0f, 1, 1, 9);
        this.Handguard2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Handguard2.setTextureSize(64, 128);
        this.Handguard2.mirror = true;
        this.setRotation(this.Handguard2, 0.0f, 0.0f, 0.0f);
        (this.Handguard1 = new ModelRenderer((ModelBase) this, 18, 12)).addBox(-3.0f, -7.0f, 0.0f, 7, 1, 1);
        this.Handguard1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Handguard1.setTextureSize(64, 128);
        this.Handguard1.mirror = true;
        this.setRotation(this.Handguard1, 0.0f, 0.0f, 0.0f);
        (this.hg2 = new ModelRenderer((ModelBase) this, 0, 15)).addBox(0.0f, -9.0f, -7.0f, 1, 3, 3);
        this.hg2.setRotationPoint(0.5f, 0.0f, 0.0f);
        this.hg2.setTextureSize(64, 128);
        this.hg2.mirror = true;
        this.setRotation(this.hg2, 0.0f, 0.0f, 0.0f);
        (this.hg4 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(0.0f, -9.0f, 5.0f, 1, 3, 3);
        this.hg4.setRotationPoint(0.5f, 0.0f, 0.0f);
        this.hg4.setTextureSize(64, 128);
        this.hg4.mirror = true;
        this.setRotation(this.hg4, 0.0f, 0.0f, 0.0f);
        (this.hg3 = new ModelRenderer((ModelBase) this, 0, 29)).addBox(-4.0f, -9.0f, 0.0f, 3, 3, 1);
        this.hg3.setRotationPoint(-2.0f, 0.0f, 0.5f);
        this.hg3.setTextureSize(64, 128);
        this.hg3.mirror = true;
        this.setRotation(this.hg3, 0.0f, 0.0f, 0.0f);
        (this.hg1 = new ModelRenderer((ModelBase) this, 0, 34)).addBox(4.0f, -9.0f, 0.0f, 3, 3, 1);
        this.hg1.setRotationPoint(0.0f, 0.0f, 0.5f);
        this.hg1.setTextureSize(64, 128);
        this.hg1.mirror = true;
        this.setRotation(this.hg1, 0.0f, 0.0f, 0.0f);
        (this.BaseGrip = new ModelRenderer((ModelBase) this, 0, 39)).addBox(-1.0f, 5.0f, -1.0f, 3, 1, 3);
        this.BaseGrip.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.BaseGrip.setTextureSize(64, 128);
        this.BaseGrip.mirror = true;
        this.setRotation(this.BaseGrip, 0.0f, 0.0f, 0.0f);
        (this.Bottom = new ModelRenderer((ModelBase) this, 0, 45)).addBox(0.0f, 6.0f, 0.0f, 1, 1, 1);
        this.Bottom.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Bottom.setTextureSize(64, 128);
        this.Bottom.mirror = true;
        this.setRotation(this.Bottom, 0.0f, 0.0f, 0.0f);
        (this.Blade2 = new ModelRenderer((ModelBase) this, 24, 49)).addBox(-1.0f, -41.0f, 0.0f, 1, 34, 3);
        this.Blade2.setRotationPoint(0.5f, 0.0f, -2.3f);
        this.Blade2.setTextureSize(64, 128);
        this.Blade2.mirror = true;
        this.setRotation(this.Blade2, 0.0f, -0.3490659f, 0.0f);
        (this.Blade3 = new ModelRenderer((ModelBase) this, 15, 49)).addBox(0.0f, -41.0f, 0.0f, 1, 34, 3);
        this.Blade3.setRotationPoint(1.5f, 0.0f, 0.4f);
        this.Blade3.setTextureSize(64, 128);
        this.Blade3.mirror = true;
        this.setRotation(this.Blade3, 0.0f, -0.3490659f, 0.0f);
        (this.Blade4 = new ModelRenderer((ModelBase) this, 33, 49)).addBox(0.0f, -41.0f, 0.0f, 1, 34, 3);
        this.Blade4.setRotationPoint(-1.5f, 0.0f, 0.7f);
        this.Blade4.setTextureSize(64, 128);
        this.Blade4.mirror = true;
        this.setRotation(this.Blade4, 0.0f, 0.3490659f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase) this, 6, 0)).addBox(0.0f, -6.0f, 0.0f, 1, 6, 3);
        this.Shape1.setRotationPoint(0.5f, -40.0f, -1.0f);
        this.Shape1.setTextureSize(64, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
    }

    public void render() {
        final float f5 = 1.0f;
        this.Grip.render(f5);
        this.Blade1.render(f5);
        this.Handguard2.render(f5);
        this.Handguard1.render(f5);
        this.hg2.render(f5);
        this.hg4.render(f5);
        this.hg3.render(f5);
        this.hg1.render(f5);
        this.BaseGrip.render(f5);
        this.Bottom.render(f5);
        this.Blade2.render(f5);
        this.Blade3.render(f5);
        this.Blade4.render(f5);
        this.Shape1.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
