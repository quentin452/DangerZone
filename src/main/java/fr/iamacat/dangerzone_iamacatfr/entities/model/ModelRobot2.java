
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Robot2;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;

public class ModelRobot2 extends ModelBase {

    private float wingspeed;
    ModelRenderer rleg1;
    ModelRenderer rleg2;
    ModelRenderer Shape3;
    ModelRenderer lleg2;
    ModelRenderer lleg1;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer rarm3;
    ModelRenderer rarm2;
    ModelRenderer rarm1;
    ModelRenderer larm3;
    ModelRenderer larm2;
    ModelRenderer larm1;
    ModelRenderer head;

    public ModelRobot2(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 512;
        (this.rleg1 = new ModelRenderer((ModelBase) this, 10, 250)).addBox(-14.0f, 24.0f, -7.0f, 16, 24, 16);
        this.rleg1.setRotationPoint(-10.0f, -24.0f, 0.0f);
        this.rleg1.setTextureSize(256, 512);
        this.rleg1.mirror = true;
        this.setRotation(this.rleg1, 0.0f, 0.0f, 0.0f);
        (this.rleg2 = new ModelRenderer((ModelBase) this, 10, 150)).addBox(-12.0f, 0.0f, -6.0f, 12, 24, 12);
        this.rleg2.setRotationPoint(-10.0f, -24.0f, 1.0f);
        this.rleg2.setTextureSize(256, 512);
        this.rleg2.mirror = true;
        this.setRotation(this.rleg2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 10, 50)).addBox(-4.0f, 0.0f, -2.0f, 26, 8, 12);
        this.Shape3.setRotationPoint(-9.0f, -32.0f, -3.0f);
        this.Shape3.setTextureSize(256, 512);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.lleg2 = new ModelRenderer((ModelBase) this, 10, 200)).addBox(0.0f, 0.0f, -6.0f, 12, 24, 12);
        this.lleg2.setRotationPoint(10.0f, -24.0f, 1.0f);
        this.lleg2.setTextureSize(256, 512);
        this.lleg2.mirror = true;
        this.setRotation(this.lleg2, 0.0f, 0.0f, 0.0f);
        (this.lleg1 = new ModelRenderer((ModelBase) this, 10, 300)).addBox(-2.0f, 24.0f, -7.0f, 16, 24, 16);
        this.lleg1.setRotationPoint(10.0f, -24.0f, 0.0f);
        this.lleg1.setTextureSize(256, 512);
        this.lleg1.mirror = true;
        this.setRotation(this.lleg1, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase) this, 10, 100)).addBox(-4.0f, -8.0f, -3.0f, 8, 8, 8);
        this.Shape6.setRotationPoint(0.0f, -32.0f, 0.0f);
        this.Shape6.setTextureSize(256, 512);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase) this, 10, 350)).addBox(0.0f, 0.0f, 0.0f, 26, 8, 12);
        this.Shape7.setRotationPoint(-13.0f, -48.0f, -5.0f);
        this.Shape7.setTextureSize(256, 512);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase) this, 16, 400)).addBox(0.0f, 0.0f, 0.0f, 44, 18, 14);
        this.Shape8.setRotationPoint(-22.0f, -66.0f, -6.0f);
        this.Shape8.setTextureSize(256, 512);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        (this.rarm3 = new ModelRenderer((ModelBase) this, 100, 100)).addBox(-16.0f, -16.0f, -7.0f, 16, 24, 17);
        this.rarm3.setRotationPoint(-22.0f, -58.0f, 0.0f);
        this.rarm3.setTextureSize(256, 512);
        this.rarm3.mirror = true;
        this.setRotation(this.rarm3, 0.0f, 0.0f, 0.0f);
        (this.rarm2 = new ModelRenderer((ModelBase) this, 100, 200)).addBox(-14.0f, 8.0f, -5.0f, 12, 24, 12);
        this.rarm2.setRotationPoint(-22.0f, -58.0f, 0.0f);
        this.rarm2.setTextureSize(256, 512);
        this.rarm2.mirror = true;
        this.setRotation(this.rarm2, 0.0f, 0.0f, 0.0f);
        (this.rarm1 = new ModelRenderer((ModelBase) this, 100, 300)).addBox(-14.0f, 32.0f, -5.0f, 12, 24, 12);
        this.rarm1.setRotationPoint(-22.0f, -58.0f, 0.0f);
        this.rarm1.setTextureSize(256, 512);
        this.rarm1.mirror = true;
        this.setRotation(this.rarm1, 0.0f, 0.0f, 0.0f);
        (this.larm3 = new ModelRenderer((ModelBase) this, 100, 50)).addBox(0.0f, -16.0f, -7.0f, 16, 24, 17);
        this.larm3.setRotationPoint(22.0f, -58.0f, 0.0f);
        this.larm3.setTextureSize(256, 512);
        this.larm3.mirror = true;
        this.setRotation(this.larm3, 0.0f, 0.0f, 0.0f);
        (this.larm2 = new ModelRenderer((ModelBase) this, 100, 150)).addBox(2.0f, 8.0f, -5.0f, 12, 24, 12);
        this.larm2.setRotationPoint(21.0f, -58.0f, 0.0f);
        this.larm2.setTextureSize(256, 512);
        this.larm2.mirror = true;
        this.setRotation(this.larm2, 0.0f, 0.0f, 0.0f);
        (this.larm1 = new ModelRenderer((ModelBase) this, 100, 250)).addBox(2.0f, 32.0f, -5.0f, 12, 24, 12);
        this.larm1.setRotationPoint(21.0f, -58.0f, 0.0f);
        this.larm1.setTextureSize(256, 512);
        this.larm1.mirror = true;
        this.setRotation(this.larm1, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 50, 10)).addBox(-7.0f, -12.0f, -5.0f, 15, 12, 10);
        this.head.setRotationPoint(0.0f, -66.0f, 1.0f);
        this.head.setTextureSize(256, 512);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Robot2 e = (Robot2) entity;
        RenderInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        } else {
            newangle = 0.0f;
        }
        this.lleg1.rotateAngleX = newangle;
        this.lleg2.rotateAngleX = newangle;
        this.rleg1.rotateAngleX = -newangle;
        this.rleg2.rotateAngleX = -newangle;
        this.head.rotateAngleY = (float) Math.toRadians(f3);
        newangle = MathHelper.sin((float) Math.toRadians(f2 * 20.0f * this.wingspeed));
        final float nextangle = MathHelper.sin((float) Math.toRadians(f2 * 20.0f * this.wingspeed + 1.5f));
        r = e.getRenderInfo();
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() == 0) {
                r.ri1 = 0;
            } else {
                while (r.ri1 == 0) {
                    r.ri1 = e.worldObj.rand.nextInt(4);
                }
            }
        }
        newangle = (float) Math.toRadians(f2 * 20.0f * this.wingspeed);
        if (r.ri1 == 1 || r.ri1 == 3) {
            this.rarm1.rotateAngleX = newangle;
            this.rarm2.rotateAngleX = newangle;
            this.rarm3.rotateAngleX = newangle;
        } else {
            this.rarm1.rotateAngleX = 0.0f;
            this.rarm2.rotateAngleX = 0.0f;
            this.rarm3.rotateAngleX = 0.0f;
        }
        if (r.ri1 == 2 || r.ri1 == 3) {
            this.larm1.rotateAngleX = newangle;
            this.larm2.rotateAngleX = newangle;
            this.larm3.rotateAngleX = newangle;
        } else {
            this.larm1.rotateAngleX = 0.0f;
            this.larm2.rotateAngleX = 0.0f;
            this.larm3.rotateAngleX = 0.0f;
        }
        e.setRenderInfo(r);
        this.rleg1.render(f5);
        this.rleg2.render(f5);
        this.Shape3.render(f5);
        this.lleg2.render(f5);
        this.lleg1.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.rarm3.render(f5);
        this.rarm2.render(f5);
        this.rarm1.render(f5);
        this.larm3.render(f5);
        this.larm2.render(f5);
        this.larm1.render(f5);
        this.head.render(f5);
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
