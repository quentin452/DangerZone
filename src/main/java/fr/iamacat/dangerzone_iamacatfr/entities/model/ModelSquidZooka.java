
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

public class ModelSquidZooka extends ModelBase {

    ModelRenderer Barrel;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer tail6;
    ModelRenderer tail7;
    ModelRenderer sight3;
    ModelRenderer sight2;
    ModelRenderer sight1;
    ModelRenderer handle1;

    public ModelSquidZooka() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Barrel = new ModelRenderer((ModelBase) this, 29, 19)).addBox(-1.0f, -1.0f, -19.0f, 2, 2, 34);
        this.Barrel.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Barrel.setTextureSize(128, 128);
        this.Barrel.mirror = true;
        this.setRotation(this.Barrel, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 0, 53)).addBox(-1.5f, -1.5f, 15.0f, 3, 3, 1);
        this.tail1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail1.setTextureSize(128, 128);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 0, 58)).addBox(-2.0f, -2.0f, 16.0f, 4, 4, 1);
        this.tail2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail2.setTextureSize(128, 128);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase) this, 0, 64)).addBox(-2.5f, -2.5f, 17.0f, 5, 5, 1);
        this.tail3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail3.setTextureSize(128, 128);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, 0.0f, 0.0f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase) this, 0, 71)).addBox(-3.0f, -3.0f, 18.0f, 6, 6, 6);
        this.tail4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail4.setTextureSize(128, 128);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, 0.0f, 0.0f, 0.0f);
        (this.tail5 = new ModelRenderer((ModelBase) this, 0, 84)).addBox(-2.5f, -2.5f, 24.0f, 5, 5, 1);
        this.tail5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail5.setTextureSize(128, 128);
        this.tail5.mirror = true;
        this.setRotation(this.tail5, 0.0f, 0.0f, 0.0f);
        (this.tail6 = new ModelRenderer((ModelBase) this, 0, 91)).addBox(-2.0f, -2.0f, 25.0f, 4, 4, 1);
        this.tail6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail6.setTextureSize(128, 128);
        this.tail6.mirror = true;
        this.setRotation(this.tail6, 0.0f, 0.0f, 0.0f);
        (this.tail7 = new ModelRenderer((ModelBase) this, 0, 97)).addBox(-1.5f, -1.5f, 26.0f, 3, 3, 1);
        this.tail7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.tail7.setTextureSize(128, 128);
        this.tail7.mirror = true;
        this.setRotation(this.tail7, 0.0f, 0.0f, 0.0f);
        (this.sight3 = new ModelRenderer((ModelBase) this, 25, 0)).addBox(1.0f, -2.0f, -10.0f, 1, 1, 2);
        this.sight3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.sight3.setTextureSize(128, 128);
        this.sight3.mirror = true;
        this.setRotation(this.sight3, 0.0f, 0.0f, 0.0f);
        (this.sight2 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(0.5f, -4.0f, -12.0f, 2, 2, 6);
        this.sight2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.sight2.setTextureSize(128, 128);
        this.sight2.mirror = true;
        this.setRotation(this.sight2, 0.0f, 0.0f, 0.0f);
        (this.sight1 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(1.0f, -1.0f, -10.0f, 1, 1, 2);
        this.sight1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.sight1.setTextureSize(128, 128);
        this.sight1.mirror = true;
        this.setRotation(this.sight1, 0.0f, 0.0f, 0.0f);
        (this.handle1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 1.0f, 0.0f, 1, 7, 1);
        this.handle1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.handle1.setTextureSize(128, 128);
        this.handle1.mirror = true;
        this.setRotation(this.handle1, 0.0f, 0.0f, 0.0f);
    }

    public void render() {
        final float f5 = 1.0f;
        GL11.glPushMatrix();
        GL11.glRotatef(180.0f, 0.0f, 0.0f, 1.0f);
        this.Barrel.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.tail4.render(f5);
        this.tail5.render(f5);
        this.tail6.render(f5);
        this.tail7.render(f5);
        this.sight3.render(f5);
        this.sight2.render(f5);
        this.sight1.render(f5);
        this.handle1.render(f5);
        GL11.glPopMatrix();
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
