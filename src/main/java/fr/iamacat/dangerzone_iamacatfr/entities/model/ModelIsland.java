
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelIsland extends ModelBase {

    private float wingspeed;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelIsland(final float f) {
        this.wingspeed = 1.0f;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.Shape1.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.Shape2.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.7853982f, 0.7853982f, 0.7853982f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 32, 16)).addBox(-4.0f, -4.0f, -4.0f, 8, 8, 8);
        this.Shape3.setRotationPoint(0.0f, 16.0f, 0.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.7853982f, 0.7853982f, 0.7853982f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.cos(f2 * 0.05f * this.wingspeed) * 3.1415927f;
        this.Shape1.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.051f * this.wingspeed) * 3.1415927f;
        this.Shape1.rotateAngleY = newangle;
        newangle = MathHelper.cos(f2 * 0.052f * this.wingspeed) * 3.1415927f;
        this.Shape1.rotateAngleZ = newangle;
        newangle = MathHelper.cos(f2 * 0.053f * this.wingspeed) * 3.1415927f;
        this.Shape2.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.054f * this.wingspeed) * 3.1415927f;
        this.Shape2.rotateAngleY = newangle;
        newangle = MathHelper.cos(f2 * 0.055f * this.wingspeed) * 3.1415927f;
        this.Shape2.rotateAngleZ = newangle;
        newangle = MathHelper.cos(f2 * 0.056f * this.wingspeed) * 3.1415927f;
        this.Shape3.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.057f * this.wingspeed) * 3.1415927f;
        this.Shape3.rotateAngleY = newangle;
        newangle = MathHelper.cos(f2 * 0.058f * this.wingspeed) * 3.1415927f;
        this.Shape3.rotateAngleZ = newangle;
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
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
