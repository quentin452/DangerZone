
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelBattleAxe extends ModelBase {

    ModelRenderer Handle1;
    ModelRenderer Head1;
    ModelRenderer Grip;
    ModelRenderer Pin;
    ModelRenderer Top;
    ModelRenderer Blade1;
    ModelRenderer Blade2;
    ModelRenderer Blade3;
    ModelRenderer Blade4;
    ModelRenderer Blade5;
    ModelRenderer Blade6;
    ModelRenderer Blade7;
    ModelRenderer Blade8;
    ModelRenderer Blade9;
    ModelRenderer Blade10;

    public ModelBattleAxe() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.Handle1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-7.0f, -0.5f, 0.0f, 31, 2, 1);
        this.Handle1.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Handle1.setTextureSize(128, 64);
        this.Handle1.mirror = true;
        this.setRotation(this.Handle1, 0.0f, 0.0f, 1.570796f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 29, 18)).addBox(-2.0f, -4.5f, -0.5f, 3, 4, 2);
        this.Head1.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Head1.setTextureSize(128, 64);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.Grip = new ModelRenderer((ModelBase) this, 0, 7)).addBox(-1.92f, 13.0f, -0.5f, 3, 11, 2);
        this.Grip.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Grip.setTextureSize(128, 64);
        this.Grip.mirror = true;
        this.setRotation(this.Grip, 0.0f, 0.0f, 0.0f);
        (this.Pin = new ModelRenderer((ModelBase) this, 38, 11)).addBox(-1.0f, -3.0f, -1.0f, 1, 1, 3);
        this.Pin.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Pin.setTextureSize(128, 64);
        this.Pin.mirror = true;
        this.setRotation(this.Pin, 0.0f, 0.0f, 0.0f);
        (this.Top = new ModelRenderer((ModelBase) this, 24, 11)).addBox(-2.0f, -8.0f, -0.5f, 3, 2, 2);
        this.Top.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Top.setTextureSize(128, 64);
        this.Top.mirror = true;
        this.setRotation(this.Top, 0.0f, 0.0f, 0.0f);
        (this.Blade1 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(6.0f, -8.0f, 0.0f, 3, 10, 1);
        this.Blade1.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade1.setTextureSize(128, 64);
        this.Blade1.mirror = true;
        this.setRotation(this.Blade1, 0.0f, 0.0f, 0.5061455f);
        (this.Blade2 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(8.5f, -6.9f, 0.0f, 3, 10, 1);
        this.Blade2.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade2.setTextureSize(128, 64);
        this.Blade2.mirror = true;
        this.setRotation(this.Blade2, 0.0f, 0.0f, -0.5061455f);
        (this.Blade3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, -3.0f, 0.0f, 10, 1, 1);
        this.Blade3.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade3.setTextureSize(128, 64);
        this.Blade3.mirror = true;
        this.setRotation(this.Blade3, 0.0f, 0.0f, 0.0f);
        (this.Blade4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -2.0f, 0.0f, 7, 1, 1);
        this.Blade4.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade4.setTextureSize(128, 64);
        this.Blade4.mirror = true;
        this.setRotation(this.Blade4, 0.0f, 0.0f, 0.5061455f);
        (this.Blade5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, -3.5f, 0.0f, 8, 1, 1);
        this.Blade5.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade5.setTextureSize(128, 64);
        this.Blade5.mirror = true;
        this.setRotation(this.Blade5, 0.0f, 0.0f, -0.5061455f);
        (this.Blade6 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(-12.2f, -5.2f, 0.0f, 3, 10, 1);
        this.Blade6.setRotationPoint(0.0f, -13.0f, 0.0f);
        this.Blade6.setTextureSize(128, 64);
        this.Blade6.mirror = true;
        this.setRotation(this.Blade6, 0.0f, 0.0f, 0.5061455f);
        (this.Blade7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-9.9f, -3.0f, 0.0f, 8, 1, 1);
        this.Blade7.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade7.setTextureSize(128, 64);
        this.Blade7.mirror = true;
        this.setRotation(this.Blade7, 0.0f, 0.0f, 0.5061455f);
        (this.Blade8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-10.0f, -3.0f, 0.0f, 10, 1, 1);
        this.Blade8.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade8.setTextureSize(128, 64);
        this.Blade8.mirror = true;
        this.setRotation(this.Blade8, 0.0f, 0.0f, 0.0f);
        (this.Blade9 = new ModelRenderer((ModelBase) this, 70, 0)).addBox(-10.0f, -8.5f, 0.0f, 3, 10, 1);
        this.Blade9.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade9.setTextureSize(128, 64);
        this.Blade9.mirror = true;
        this.setRotation(this.Blade9, 0.0f, 0.0f, -0.5061455f);
        (this.Blade10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-7.0f, -2.5f, 0.0f, 7, 1, 1);
        this.Blade10.setRotationPoint(0.0f, -12.0f, 0.0f);
        this.Blade10.setTextureSize(128, 64);
        this.Blade10.mirror = true;
        this.setRotation(this.Blade10, 0.0f, 0.0f, -0.5061455f);
    }

    public void render() {
        final float f5 = 1.0f;
        this.Handle1.render(f5);
        this.Head1.render(f5);
        this.Grip.render(f5);
        this.Pin.render(f5);
        this.Top.render(f5);
        this.Blade1.render(f5);
        this.Blade2.render(f5);
        this.Blade3.render(f5);
        this.Blade4.render(f5);
        this.Blade5.render(f5);
        this.Blade6.render(f5);
        this.Blade7.render(f5);
        this.Blade8.render(f5);
        this.Blade9.render(f5);
        this.Blade10.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
