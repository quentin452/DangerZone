
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class LeechModel extends ModelBase {

    ModelRenderer Cheek1;
    ModelRenderer Cheek2;
    ModelRenderer Face;
    ModelRenderer t1;
    ModelRenderer t2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer cld2;
    ModelRenderer cld1;
    ModelRenderer t3;
    ModelRenderer Eye2;
    ModelRenderer Eye1;
    ModelRenderer cld4;
    ModelRenderer cld3;
    ModelRenderer Mouth;
    ModelRenderer lec1;
    ModelRenderer Lec7;
    ModelRenderer Lec5;
    ModelRenderer lec3;
    ModelRenderer Lec6;
    ModelRenderer lec4;
    ModelRenderer lec2;
    ModelRenderer Lec8;

    public LeechModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Cheek1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-26.0f, -10.0f, -7.0f, 20, 20, 20);
        this.Cheek1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Cheek1.setTextureSize(256, 128);
        this.Cheek1.mirror = true;
        this.setRotation(this.Cheek1, 0.0f, 0.0f, 0.0f);
        (this.Cheek2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(6.0f, -10.0f, -7.0f, 20, 20, 20);
        this.Cheek2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Cheek2.setTextureSize(256, 128);
        this.Cheek2.mirror = true;
        this.setRotation(this.Cheek2, 0.0f, 0.0f, 0.0f);
        (this.Face = new ModelRenderer((ModelBase) this, 87, 0)).addBox(-10.0f, -8.0f, -5.0f, 20, 16, 22);
        this.Face.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Face.setTextureSize(256, 128);
        this.Face.mirror = true;
        this.setRotation(this.Face, 0.0f, 0.0f, 0.0f);
        (this.t1 = new ModelRenderer((ModelBase) this, 0, 80)).addBox(-6.0f, -6.0f, 9.0f, 12, 10, 25);
        this.t1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.t1.setTextureSize(256, 128);
        this.t1.mirror = true;
        this.setRotation(this.t1, 0.0f, 0.0f, 0.0f);
        (this.t2 = new ModelRenderer((ModelBase) this, 85, 80)).addBox(-5.0f, -5.0f, 22.0f, 10, 8, 25);
        this.t2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.t2.setTextureSize(256, 128);
        this.t2.mirror = true;
        this.setRotation(this.t2, 0.0f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 45)).addBox(5.0f, 3.0f, -6.99f, 13, 10, 20);
        this.Shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape1.setTextureSize(256, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, -0.8726646f);
        (this.Shape2 = new ModelRenderer((ModelBase) this, 0, 45)).addBox(-18.0f, 3.0f, -6.99f, 13, 10, 20);
        this.Shape2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape2.setTextureSize(256, 128);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.8726646f);
        (this.cld2 = new ModelRenderer((ModelBase) this, 80, 50)).addBox(-5.0f, -2.5f, -5.0f, 10, 5, 10);
        this.cld2.setRotationPoint(36.0f, -5.0f, 13.0f);
        this.cld2.setTextureSize(256, 128);
        this.cld2.mirror = true;
        this.setRotation(this.cld2, 0.0f, 0.0f, 0.0f);
        (this.cld1 = new ModelRenderer((ModelBase) this, 80, 50)).addBox(-5.0f, -2.5f, -5.0f, 10, 5, 10);
        this.cld1.setRotationPoint(-36.0f, -5.0f, 13.0f);
        this.cld1.setTextureSize(256, 128);
        this.cld1.mirror = true;
        this.setRotation(this.cld1, 0.0f, 0.0f, 0.0f);
        (this.t3 = new ModelRenderer((ModelBase) this, 165, 80)).addBox(-4.0f, -4.0f, 37.0f, 8, 6, 20);
        this.t3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.t3.setTextureSize(256, 128);
        this.t3.mirror = true;
        this.setRotation(this.t3, 0.0f, 0.0f, 0.0f);
        (this.Eye2 = new ModelRenderer((ModelBase) this, 180, 0)).addBox(2.0f, -5.0f, -6.0f, 4, 4, 10);
        this.Eye2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Eye2.setTextureSize(256, 128);
        this.Eye2.mirror = true;
        this.setRotation(this.Eye2, 0.0f, 0.0f, 0.0f);
        (this.Eye1 = new ModelRenderer((ModelBase) this, 180, 0)).addBox(-6.0f, -5.0f, -6.0f, 4, 4, 10);
        this.Eye1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Eye1.setTextureSize(256, 128);
        this.Eye1.mirror = true;
        this.setRotation(this.Eye1, 0.0f, 0.0f, 0.0f);
        (this.cld4 = new ModelRenderer((ModelBase) this, 125, 50)).addBox(-4.0f, -2.0f, -4.0f, 8, 4, 8);
        this.cld4.setRotationPoint(19.0f, -5.0f, 40.0f);
        this.cld4.setTextureSize(256, 128);
        this.cld4.mirror = true;
        this.setRotation(this.cld4, 0.0f, 0.0f, 0.0f);
        (this.cld3 = new ModelRenderer((ModelBase) this, 125, 50)).addBox(-4.0f, -2.0f, -4.0f, 8, 4, 8);
        this.cld3.setRotationPoint(-19.0f, -5.0f, 40.0f);
        this.cld3.setTextureSize(256, 128);
        this.cld3.mirror = true;
        this.setRotation(this.cld3, 0.0f, 0.0f, 0.0f);
        (this.Mouth = new ModelRenderer((ModelBase) this, 210, 0)).addBox(-3.0f, 1.0f, -6.0f, 6, 6, 10);
        this.Mouth.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Mouth.setTextureSize(256, 128);
        this.Mouth.mirror = true;
        this.setRotation(this.Mouth, 0.0f, 0.0f, 0.0f);
        (this.lec1 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -6.0f, 1, 1, 6);
        this.lec1.setRotationPoint(0.0f, 2.0f, -6.0f);
        this.lec1.setTextureSize(256, 128);
        this.lec1.mirror = true;
        this.setRotation(this.lec1, -0.6108652f, 0.0f, 0.0f);
        (this.Lec7 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -6.0f, 1, 1, 6);
        this.Lec7.setRotationPoint(-2.0f, 4.0f, -6.0f);
        this.Lec7.setTextureSize(256, 128);
        this.Lec7.mirror = true;
        this.setRotation(this.Lec7, -0.6108652f, 0.0f, -1.570796f);
        (this.Lec5 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -6.0f, 1, 1, 6);
        this.Lec5.setRotationPoint(0.0f, 6.0f, -6.0f);
        this.Lec5.setTextureSize(256, 128);
        this.Lec5.mirror = true;
        this.setRotation(this.Lec5, -0.6108652f, 0.0f, -3.141593f);
        (this.lec3 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -6.0f, 1, 1, 6);
        this.lec3.setRotationPoint(2.0f, 4.0f, -6.0f);
        this.lec3.setTextureSize(256, 128);
        this.lec3.mirror = true;
        this.setRotation(this.lec3, -0.6108652f, 0.0f, 1.570796f);
        (this.Lec6 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -12.0f, 1, 1, 6);
        this.Lec6.setRotationPoint(0.0f, 6.0f, -6.0f);
        this.Lec6.setTextureSize(256, 128);
        this.Lec6.mirror = true;
        this.setRotation(this.Lec6, -0.6108652f, 0.0f, -3.141593f);
        (this.lec4 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -12.0f, 1, 1, 6);
        this.lec4.setRotationPoint(2.0f, 4.0f, -6.0f);
        this.lec4.setTextureSize(256, 128);
        this.lec4.mirror = true;
        this.setRotation(this.lec4, -0.6108652f, 0.0f, 1.570796f);
        (this.lec2 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -12.0f, 1, 1, 6);
        this.lec2.setRotationPoint(0.0f, 2.0f, -6.0f);
        this.lec2.setTextureSize(256, 128);
        this.lec2.mirror = true;
        this.setRotation(this.lec2, -0.6108652f, 0.0f, 0.0f);
        (this.Lec8 = new ModelRenderer((ModelBase) this, 222, 22)).addBox(-0.5f, 0.0f, -12.0f, 1, 1, 6);
        this.Lec8.setRotationPoint(-2.0f, 4.0f, -6.0f);
        this.Lec8.setTextureSize(256, 128);
        this.Lec8.mirror = true;
        this.setRotation(this.Lec8, -0.6108652f, 0.0f, -1.570796f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 0.1f * 1.75f) * 3.141593f * 0.6f;
        this.TailEvent(newangle);
        this.cld1.rotateAngleX = newangle;
        this.cld2.rotateAngleX = newangle;
        this.cld3.rotateAngleX = newangle;
        this.cld4.rotateAngleX = newangle;
        newangle = MathHelper.sin(f2 * 0.9f * 1.0f) * 3.1415927f * 0.35f;
        newangle = Math.abs(newangle);
        this.lec1.rotateAngleY = newangle;
        this.lec2.rotateAngleY = newangle;
        this.lec3.rotateAngleY = newangle;
        this.lec4.rotateAngleY = newangle;
        this.Lec5.rotateAngleY = newangle;
        this.Lec6.rotateAngleY = newangle;
        this.Lec7.rotateAngleY = newangle;
        this.Lec8.rotateAngleY = newangle;
        GL11.glScalef(0.6f, 0.6f, 0.6f);
        GL11.glTranslatef(0.0f, 0.5f, 0.0f);
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(6.75f, 6.75f, 6.75f, 0.75f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 940.0f, 1240.0f);
        this.Face.render(f5);
        this.t1.render(f5);
        this.t2.render(f5);
        this.cld2.render(f5);
        this.cld1.render(f5);
        this.t3.render(f5);
        this.Eye2.render(f5);
        this.Eye1.render(f5);
        this.cld4.render(f5);
        this.cld3.render(f5);
        this.Mouth.render(f5);
        this.lec1.render(f5);
        this.Lec7.render(f5);
        this.Lec5.render(f5);
        this.lec3.render(f5);
        this.Lec6.render(f5);
        this.lec4.render(f5);
        this.lec2.render(f5);
        this.Lec8.render(f5);
        this.Cheek1.render(f5);
        this.Cheek2.render(f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    private void TailEvent(final float angle) {
        this.t1.rotateAngleY = angle * 0.15f;
        this.t2.rotateAngleY = angle * 0.18f;
        this.t3.rotateAngleY = angle * 0.22f;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4,
        final float par5, final float par6, final Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
    }
}
