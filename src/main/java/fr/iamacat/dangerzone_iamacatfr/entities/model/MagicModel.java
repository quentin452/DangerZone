
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.PowerOrbsInstance;

public class MagicModel extends ModelBase {

    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;

    public MagicModel(final float f1) {
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape1.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape1.setTextureSize(256, 256);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.4461433f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape2.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape2.setTextureSize(256, 256);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, -0.5948578f, 1.041001f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape3.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape3.setTextureSize(256, 256);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 2.565324f, 0.5576792f);
        (this.Shape4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape4.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape4.setTextureSize(256, 256);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.7063936f, -1.487144f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape5.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape5.setTextureSize(256, 256);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, -0.2602503f, -0.7807508f);
        (this.Shape6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape6.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape6.setTextureSize(256, 256);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 3.141593f, 0.4833219f);
        (this.Shape7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 8);
        this.Shape7.setRotationPoint(-4.0f, 1.0f, -4.0f);
        this.Shape7.setTextureSize(256, 256);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0f, 3.141593f, -1.59868f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final PowerOrbsInstance p = (PowerOrbsInstance) entity;
        float rf1 = 1.0f;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape1.rotateAngleZ = newangle;
            this.Shape1.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape2.rotateAngleZ = newangle;
            this.Shape2.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape3.rotateAngleZ = newangle;
            this.Shape3.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape4.rotateAngleZ = newangle;
            this.Shape4.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape5.rotateAngleZ = newangle;
            this.Shape5.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape6.rotateAngleZ = newangle;
            this.Shape6.render(f5);
            newangle += 1.047198f;
        }
        rf1 = p.worldObj.rand.nextFloat() * 360.0f;
        GL11.glRotatef(rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 6; ++i) {
            this.Shape7.rotateAngleZ = newangle;
            this.Shape7.render(f5);
            newangle += 1.047198f;
        }
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
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
