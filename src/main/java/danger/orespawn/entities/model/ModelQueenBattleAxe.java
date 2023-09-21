
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelQueenBattleAxe extends ModelBase {

    ModelRenderer Handle1;
    ModelRenderer Head1;
    ModelRenderer Grip;
    ModelRenderer Pin;
    ModelRenderer Blade1;
    ModelRenderer Blade2;
    ModelRenderer Blade3;
    ModelRenderer Blade4;
    ModelRenderer Top;

    public ModelQueenBattleAxe() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Handle1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-7.0f, -0.5f, 0.0f, 31, 1, 1);
        this.Handle1.setRotationPoint(-0.5f, -12.0f, 0.0f);
        this.Handle1.setTextureSize(128, 64);
        this.Handle1.mirror = true;
        this.setRotation(this.Handle1, 0.0f, 0.0f, 1.570796f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 29, 18)).addBox(-2.0f, -4.5f, -0.5f, 3, 4, 2);
        this.Head1.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Head1.setTextureSize(128, 64);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.Grip = new ModelRenderer((ModelBase) this, 0, 7)).addBox(-1.92f, 13.0f, -0.5f, 2, 11, 2);
        this.Grip.setRotationPoint(0.5f, -12.0f, 0.0f);
        this.Grip.setTextureSize(128, 64);
        this.Grip.mirror = true;
        this.setRotation(this.Grip, 0.0f, 0.0f, 0.0f);
        (this.Pin = new ModelRenderer((ModelBase) this, 38, 11)).addBox(-1.0f, -3.0f, -1.0f, 1, 1, 3);
        this.Pin.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Pin.setTextureSize(128, 64);
        this.Pin.mirror = true;
        this.setRotation(this.Pin, 0.0f, 0.0f, 0.0f);
        (this.Blade1 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade1.setRotationPoint(-0.5f, -14.5f, 0.0f);
        this.Blade1.setTextureSize(128, 64);
        this.Blade1.mirror = true;
        this.setRotation(this.Blade1, 0.0f, 0.0f, -0.5934119f);
        (this.Blade2 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade2.setRotationPoint(-0.5f, -14.5f, 0.0f);
        this.Blade2.setTextureSize(128, 64);
        this.Blade2.mirror = true;
        this.setRotation(this.Blade2, 0.0f, 0.0f, -0.1919862f);
        (this.Blade3 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade3.setRotationPoint(-0.5f, -14.5f, 0.0f);
        this.Blade3.setTextureSize(128, 64);
        this.Blade3.mirror = true;
        this.setRotation(this.Blade3, 0.0f, 0.0f, 0.2094395f);
        (this.Blade4 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(-10.0f, -2.0f, 0.0f, 20, 4, 1);
        this.Blade4.setRotationPoint(-0.5f, -14.5f, 0.0f);
        this.Blade4.setTextureSize(128, 64);
        this.Blade4.mirror = true;
        this.setRotation(this.Blade4, 0.0f, 0.0f, 0.5934119f);
        (this.Top = new ModelRenderer((ModelBase) this, 13, 4)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 2);
        this.Top.setRotationPoint(-1.5f, -21.0f, -0.5f);
        this.Top.setTextureSize(128, 64);
        this.Top.mirror = true;
        this.setRotation(this.Top, 0.0f, 0.0f, 0.0f);
    }

    public void render() {
        final float f5 = 1.0f;
        this.Handle1.render(f5);
        this.Head1.render(f5);
        this.Grip.render(f5);
        this.Pin.render(f5);
        this.Blade1.render(f5);
        this.Blade2.render(f5);
        this.Blade3.render(f5);
        this.Blade4.render(f5);
        this.Top.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
