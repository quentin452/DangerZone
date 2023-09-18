
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyTwilightMagic;

public class TwilightMagic extends ModelBase {

    float wingspeed;
    ModelRenderer S1;
    ModelRenderer S2;
    ModelRenderer S3;
    ModelRenderer S4;
    ModelRenderer S5;
    ModelRenderer S6;
    ModelRenderer S7;
    ModelRenderer S8;
    ModelRenderer S9;
    ModelRenderer S10;
    ModelRenderer S11;
    ModelRenderer S12;

    public TwilightMagic(final float f1) {
        this.wingspeed = 2.0f;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.S1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S1.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.S1.setTextureSize(512, 512);
        this.S1.mirror = true;
        this.setRotation(this.S1, 0.0f, -0.4089647f, 0.8179294f);
        (this.S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S2.setTextureSize(512, 512);
        this.S2.mirror = true;
        this.setRotation(this.S2, 0.0f, 0.1487144f, -0.6320364f);
        (this.S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S3.setTextureSize(512, 512);
        this.S3.mirror = true;
        this.setRotation(this.S3, 0.0f, 1.59868f, -0.6320364f);
        (this.S4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S4.setTextureSize(512, 512);
        this.S4.mirror = true;
        this.setRotation(this.S4, 0.0f, 1.07818f, 0.2602503f);
        (this.S5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S5.setTextureSize(512, 512);
        this.S5.mirror = true;
        this.setRotation(this.S5, 0.0f, 2.825574f, 0.2230717f);
        (this.S6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S6.setTextureSize(512, 512);
        this.S6.mirror = true;
        this.setRotation(this.S6, 0.0f, -0.5205006f, -1.07818f);
        (this.S7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S7.setTextureSize(512, 512);
        this.S7.mirror = true;
        this.setRotation(this.S7, 0.0f, -1.003822f, -0.2602503f);
        (this.S8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S8.setTextureSize(512, 512);
        this.S8.mirror = true;
        this.setRotation(this.S8, -0.1487144f, -1.821752f, 0.0743572f);
        (this.S9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S9.setTextureSize(512, 512);
        this.S9.mirror = true;
        this.setRotation(this.S9, 0.0f, -2.119181f, -0.6320364f);
        (this.S10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S10.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S10.setTextureSize(512, 512);
        this.S10.mirror = true;
        this.setRotation(this.S10, 0.0f, -3.141593f, -0.6320364f);
        (this.S11 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S11.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S11.setTextureSize(512, 512);
        this.S11.mirror = true;
        this.setRotation(this.S11, 0.0f, 2.267895f, -0.6320364f);
        (this.S12 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 1, 1);
        this.S12.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.S12.setTextureSize(512, 512);
        this.S12.mirror = true;
        this.setRotation(this.S12, 0.0f, 2.267895f, 1.115358f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final MyTwilightMagic p = (MyTwilightMagic) entity;
        float rf1 = 1.0f;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.S1.rotateAngleZ = newangle;
            this.S1.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S2.rotateAngleZ = newangle;
            this.S2.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S3.rotateAngleZ = newangle;
            this.S3.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S4.rotateAngleZ = newangle;
            this.S4.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S5.rotateAngleZ = newangle;
            this.S5.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S6.rotateAngleZ = newangle;
            this.S6.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S7.rotateAngleZ = newangle;
            this.S7.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S8.rotateAngleZ = newangle;
            this.S8.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S9.rotateAngleZ = newangle;
            this.S9.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S10.rotateAngleZ = newangle;
            this.S10.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S11.rotateAngleZ = newangle;
            this.S11.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 1.0f, 1.0f);
        for (int i = 0; i < 6; ++i) {
            this.S12.rotateAngleZ = newangle;
            this.S12.render(f5);
            newangle += 1.047198f;
        }
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 1.0f, 240.0f);
        this.S1.render(f5);
        this.S2.render(f5);
        this.S3.render(f5);
        this.S4.render(f5);
        this.S5.render(f5);
        this.S6.render(f5);
        this.S7.render(f5);
        this.S8.render(f5);
        this.S9.render(f5);
        this.S10.render(f5);
        this.S11.render(f5);
        this.S12.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4,
        final float par5, final float par6, final Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
    }
}
