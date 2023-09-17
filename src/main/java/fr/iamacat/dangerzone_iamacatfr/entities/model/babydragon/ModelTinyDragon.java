

package fr.iamacat.dangerzone_iamacatfr.entities.model.babydragon;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTinyDragon extends ModelBase
{
    ModelRenderer body;
    ModelRenderer neck1;
    ModelRenderer neck;
    ModelRenderer neckbase;
    ModelRenderer head;
    ModelRenderer Rleg1;
    ModelRenderer Lleg1;
    ModelRenderer Lhorn1;
    ModelRenderer Rhorn1;
    ModelRenderer snout;
    ModelRenderer Lhorn2;
    ModelRenderer Rhorn2;
    ModelRenderer tail1;
    ModelRenderer Rleg2;
    ModelRenderer Lleg2;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer Lwing;
    ModelRenderer Rwing;

    public ModelTinyDragon() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase)this, 0, 12)).addBox(-4.5f, -3.0f, -5.0f, 8, 8, 10);
        this.body.setRotationPoint(0.5f, 15.0f, 1.0f);
        this.body.setTextureSize(128, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase)this, 0, 31)).addBox(-2.0f, -3.0f, -2.0f, 4, 5, 5);
        this.neck1.setRotationPoint(0.0f, 16.0f, -5.0f);
        this.neck1.setTextureSize(128, 64);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, 0.715585f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase)this, 0, 42)).addBox(-2.0f, -8.0f, -3.0f, 4, 8, 4);
        this.neck.setRotationPoint(0.0f, 15.0f, -5.5f);
        this.neck.setTextureSize(128, 64);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.0f, 0.0f, 0.0f);
        (this.neckbase = new ModelRenderer((ModelBase)this, 0, 55)).addBox(-3.0f, -4.0f, 0.0f, 6, 6, 3);
        this.neckbase.setRotationPoint(0.0f, 17.0f, 5.0f);
        this.neckbase.setTextureSize(128, 64);
        this.neckbase.mirror = true;
        this.setRotation(this.neckbase, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-2.5f, -5.0f, -3.0f, 5, 5, 5);
        this.head.setRotationPoint(0.0f, 9.0f, -7.0f);
        this.head.setTextureSize(128, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.Rleg1 = new ModelRenderer((ModelBase)this, 19, 53)).addBox(-1.5f, 0.0f, -1.0f, 3, 8, 3);
        this.Rleg1.setRotationPoint(2.0f, 16.0f, 5.5f);
        this.Rleg1.setTextureSize(128, 64);
        this.Rleg1.mirror = true;
        this.setRotation(this.Rleg1, 0.0f, 0.0f, 0.0f);
        (this.Lleg1 = new ModelRenderer((ModelBase)this, 19, 53)).addBox(-1.5f, 0.0f, -0.5f, 3, 8, 3);
        this.Lleg1.setRotationPoint(-2.0f, 16.0f, 5.0f);
        this.Lleg1.setTextureSize(128, 64);
        this.Lleg1.mirror = true;
        this.setRotation(this.Lleg1, 0.0f, 0.0f, 0.0f);
        (this.Lhorn1 = new ModelRenderer((ModelBase)this, 19, 47)).addBox(-3.0f, -5.5f, 1.0f, 2, 2, 3);
        this.Lhorn1.setRotationPoint(0.0f, 9.0f, -7.0f);
        this.Lhorn1.setTextureSize(128, 64);
        this.Lhorn1.mirror = true;
        this.setRotation(this.Lhorn1, 0.0f, 0.0f, 0.0f);
        (this.Rhorn1 = new ModelRenderer((ModelBase)this, 19, 47)).addBox(1.0f, -5.5f, 1.0f, 2, 2, 3);
        this.Rhorn1.setRotationPoint(0.0f, 9.0f, -7.0f);
        this.Rhorn1.setTextureSize(128, 64);
        this.Rhorn1.mirror = true;
        this.setRotation(this.Rhorn1, 0.0f, 0.0f, 0.0f);
        (this.snout = new ModelRenderer((ModelBase)this, 32, 57)).addBox(-1.5f, -3.0f, -6.0f, 3, 3, 4);
        this.snout.setRotationPoint(0.0f, 9.0f, -7.0f);
        this.snout.setTextureSize(128, 64);
        this.snout.mirror = true;
        this.setRotation(this.snout, 0.0f, 0.0f, 0.0f);
        (this.Lhorn2 = new ModelRenderer((ModelBase)this, 19, 42)).addBox(-2.5f, -5.0f, 2.5f, 1, 1, 3);
        this.Lhorn2.setRotationPoint(0.0f, 9.0f, -7.0f);
        this.Lhorn2.setTextureSize(128, 64);
        this.Lhorn2.mirror = true;
        this.setRotation(this.Lhorn2, 0.0f, 0.0f, 0.0f);
        (this.Rhorn2 = new ModelRenderer((ModelBase)this, 19, 42)).addBox(1.5f, -5.0f, 2.5f, 1, 1, 3);
        this.Rhorn2.setRotationPoint(0.0f, 9.0f, -7.0f);
        this.Rhorn2.setTextureSize(128, 64);
        this.Rhorn2.mirror = true;
        this.setRotation(this.Rhorn2, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase)this, 47, 55)).addBox(-3.0f, -3.0f, -3.0f, 6, 6, 3);
        this.tail1.setRotationPoint(0.0f, 16.5f, -2.0f);
        this.tail1.setTextureSize(128, 64);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.Rleg2 = new ModelRenderer((ModelBase)this, 19, 53)).addBox(-1.5f, 0.0f, -1.5f, 3, 8, 3);
        this.Rleg2.setRotationPoint(2.0f, 16.0f, -3.0f);
        this.Rleg2.setTextureSize(128, 64);
        this.Rleg2.mirror = true;
        this.setRotation(this.Rleg2, 0.0f, 0.0f, 0.0f);
        (this.Lleg2 = new ModelRenderer((ModelBase)this, 19, 53)).addBox(-1.5f, 0.0f, -1.5f, 3, 8, 3);
        this.Lleg2.setRotationPoint(-2.0f, 16.0f, -3.0f);
        this.Lleg2.setTextureSize(128, 64);
        this.Lleg2.mirror = true;
        this.setRotation(this.Lleg2, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase)this, 19, 31)).addBox(-2.5f, -2.5f, 0.0f, 5, 5, 5);
        this.tail2.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.tail2.setTextureSize(128, 64);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, -0.3839724f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase)this, 32, 46)).addBox(-2.0f, -1.0f, 4.0f, 4, 4, 4);
        this.tail3.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.tail3.setTextureSize(128, 64);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, -0.2094395f, 0.0f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase)this, 37, 13)).addBox(-1.5f, 0.5f, 6.0f, 3, 3, 5);
        this.tail4.setRotationPoint(0.0f, 16.0f, 7.0f);
        this.tail4.setTextureSize(128, 64);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, -0.0698132f, 0.0f, 0.0f);
        (this.Lwing = new ModelRenderer((ModelBase)this, 59, 0)).addBox(-18.0f, 0.0f, -5.0f, 18, 0, 10);
        this.Lwing.setRotationPoint(-2.0f, 12.6f, 0.0f);
        this.Lwing.setTextureSize(128, 64);
        this.Lwing.mirror = true;
        this.setRotation(this.Lwing, 0.0f, 0.0f, 0.4014257f);
        (this.Rwing = new ModelRenderer((ModelBase)this, 59, 11)).addBox(0.0f, 0.0f, -5.0f, 18, 0, 10);
        this.Rwing.setRotationPoint(2.0f, 12.6f, 0.0f);
        this.Rwing.setTextureSize(128, 64);
        this.Rwing.mirror = true;
        this.setRotation(this.Rwing, 0.0f, 0.0f, -0.4014257f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.body.render(f5);
        this.neck1.render(f5);
        this.neck.render(f5);
        this.neckbase.render(f5);
        this.head.render(f5);
        this.Rleg1.render(f5);
        this.Lleg1.render(f5);
        this.Lhorn1.render(f5);
        this.Rhorn1.render(f5);
        this.snout.render(f5);
        this.Lhorn2.render(f5);
        this.Rhorn2.render(f5);
        this.tail1.render(f5);
        this.Rleg2.render(f5);
        this.Lleg2.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.tail4.render(f5);
        this.Lwing.render(f5);
        this.Rwing.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4, final float par5, final float par6) {
        final float f6 = 57.295776f;
        this.head.rotateAngleX = par5 / 57.295776f;
        this.head.rotateAngleY = par4 / 57.295776f;
        this.Lhorn1.rotateAngleX = par5 / 57.295776f;
        this.Lhorn1.rotateAngleY = par4 / 57.295776f;
        this.Rhorn1.rotateAngleX = par5 / 57.295776f;
        this.Rhorn1.rotateAngleY = par4 / 57.295776f;
        this.Lhorn2.rotateAngleX = par5 / 57.295776f;
        this.Lhorn2.rotateAngleY = par4 / 57.295776f;
        this.Rhorn2.rotateAngleX = par5 / 57.295776f;
        this.Rhorn2.rotateAngleY = par4 / 57.295776f;
        this.snout.rotateAngleX = par5 / 57.295776f;
        this.snout.rotateAngleY = par4 / 57.295776f;
        this.Lleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.Rleg1.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.Lleg2.rotateAngleX = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.4f * par2;
        this.Rleg2.rotateAngleX = MathHelper.cos(par1 * 0.6662f) * 1.4f * par2;
        this.tail1.rotateAngleY = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 0.7f * par2;
        this.tail2.rotateAngleY = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 0.8f * par2;
        this.tail3.rotateAngleY = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 0.9f * par2;
        this.tail4.rotateAngleY = MathHelper.cos(par1 * 0.6662f + 3.1415927f) * 1.0f * par2;
    }
}
