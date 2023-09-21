
package fr.iamacat.dangerzone_iamacatfr.entities.model;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.AttackSquid;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelAttackSquid extends ModelBase {

    private float wingspeed;
    ModelRenderer tent1;
    ModelRenderer tent2;
    ModelRenderer tent3;
    ModelRenderer tent4;
    ModelRenderer tent5;
    ModelRenderer tent6;
    ModelRenderer tent7;
    ModelRenderer body;
    ModelRenderer tent8;

    public ModelAttackSquid(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.tent1 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, 0.0f, -1.0f, 2, 9, 2);
        this.tent1.setRotationPoint(5.0f, 15.0f, -1.0f);
        this.tent1.setTextureSize(64, 32);
        this.tent1.mirror = true;
        this.setRotation(this.tent1, -0.9250245f, -1.745329f, 0.0f);
        (this.tent2 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-8.0f, -1.0f, -1.0f, 8, 2, 2);
        this.tent2.setRotationPoint(-2.0f, 15.0f, -3.0f);
        this.tent2.setTextureSize(64, 32);
        this.tent2.mirror = true;
        this.setRotation(this.tent2, -0.1745329f, -0.6632251f, -0.2443461f);
        (this.tent3 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.tent3.setRotationPoint(1.0f, 15.0f, -4.0f);
        this.tent3.setTextureSize(64, 32);
        this.tent3.mirror = true;
        this.setRotation(this.tent3, -1.134464f, 0.3316126f, 0.0f);
        (this.tent4 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.tent4.setRotationPoint(-3.0f, 15.0f, -1.0f);
        this.tent4.setTextureSize(64, 32);
        this.tent4.mirror = true;
        this.setRotation(this.tent4, 0.5585054f, -1.692969f, 0.0f);
        (this.tent5 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, 0.0f, -1.0f, 2, 10, 2);
        this.tent5.setRotationPoint(1.0f, 15.0f, 3.0f);
        this.tent5.setTextureSize(64, 32);
        this.tent5.mirror = true;
        this.setRotation(this.tent5, 0.5410521f, 0.2268928f, 0.0f);
        (this.tent6 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 8);
        this.tent6.setRotationPoint(-2.0f, 15.0f, 2.0f);
        this.tent6.setTextureSize(64, 32);
        this.tent6.mirror = true;
        this.setRotation(this.tent6, -0.418879f, -0.6806784f, 0.0f);
        (this.tent7 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(0.0f, -1.0f, -1.0f, 8, 2, 2);
        this.tent7.setRotationPoint(3.0f, 15.0f, 1.0f);
        this.tent7.setTextureSize(64, 32);
        this.tent7.mirror = true;
        this.setRotation(this.tent7, -0.1919862f, -0.6632251f, 0.418879f);
        (this.body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 8);
        this.body.setRotationPoint(1.0f, 16.0f, -1.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, -0.1919862f, -0.6806784f, 0.0f);
        (this.tent8 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, -1.0f, -8.0f, 2, 2, 8);
        this.tent8.setRotationPoint(3.0f, 15.0f, -4.0f);
        this.tent8.setTextureSize(64, 32);
        this.tent8.mirror = true;
        this.setRotation(this.tent8, 0.1919862f, -0.6806784f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final AttackSquid e = (AttackSquid) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangleA = 0.0f;
        float newangleB = 0.0f;
        float newangle8 = 0.0f;
        float newangle9 = 0.0f;
        float newangle10 = 0.0f;
        float newangle11 = 0.0f;
        float newangle12 = 0.0f;
        float newangle13 = 0.0f;
        float newangle14 = 0.0f;
        float newangle15 = 0.0f;
        final float pi4 = 0.7853982f;
        if (f1 > 0.1) {
            newangleA = MathHelper.cos(f2 * 0.25f * this.wingspeed) * 3.1415927f * 0.04f * f1;
            newangleB = MathHelper.cos(f2 * 0.39f * this.wingspeed) * 3.1415927f * 0.04f * f1;
            newangle9 = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle10 = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle11 = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle12 = MathHelper.cos(f2 * 1.9f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle13 = MathHelper.cos(f2 * 1.8f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle14 = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle15 = MathHelper.cos(f2 * 1.6f * this.wingspeed) * 3.1415927f * 0.4f * f1;
            newangle8 = MathHelper.cos(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.4f * f1;
        } else {
            newangleA = MathHelper.cos(f2 * 0.25f * this.wingspeed) * 3.1415927f * 0.01f;
            newangleB = MathHelper.cos(f2 * 0.39f * this.wingspeed) * 3.1415927f * 0.01f;
            newangle9 = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle10 = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle11 = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle12 = MathHelper.cos(f2 * 1.9f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle13 = MathHelper.cos(f2 * 1.8f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle14 = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle15 = MathHelper.cos(f2 * 1.6f * this.wingspeed) * 3.1415927f * 0.1f;
            newangle8 = MathHelper.cos(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.1f;
        }
        this.tent1.rotateAngleX = newangle9 - 1.03f;
        this.tent7.rotateAngleZ = newangle10 + 0.37f;
        this.tent5.rotateAngleX = newangle11 + 0.6f;
        this.tent6.rotateAngleX = newangle12 - 0.48f;
        this.tent4.rotateAngleX = newangle13 + 0.63f;
        this.tent2.rotateAngleZ = newangle14 - 0.26f;
        this.tent3.rotateAngleX = newangle15 - 1.03f;
        this.tent8.rotateAngleX = newangle8 + 0.43f;
        this.body.rotateAngleX = newangleA;
        this.body.rotateAngleZ = newangleB;
        newangleA = (float) Math.toRadians(f3) * 0.75f;
        this.body.rotateAngleY = newangleA;
        this.tent1.render(f5);
        this.tent2.render(f5);
        this.tent3.render(f5);
        this.tent4.render(f5);
        this.tent5.render(f5);
        this.tent6.render(f5);
        this.tent7.render(f5);
        this.body.render(f5);
        this.tent8.render(f5);
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
