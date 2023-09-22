
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.BearInstance;

public class BearModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer LegL;
    ModelRenderer LegR;
    ModelRenderer BodyCentre;
    ModelRenderer FootL;
    ModelRenderer FootR;
    ModelRenderer LegMuscle;
    ModelRenderer Bum;
    ModelRenderer BodyTop;
    ModelRenderer Tail;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Face;
    ModelRenderer Nose;
    ModelRenderer EarL;
    ModelRenderer EarR;
    ModelRenderer Larm;
    ModelRenderer Rarm;
    ModelRenderer Claw3;
    ModelRenderer Claw2;
    ModelRenderer Claw1;
    ModelRenderer Claw5;
    ModelRenderer Claw4;
    ModelRenderer Claw6;
    ModelRenderer Eyes;

    public BearModel() {
        this.wingspeed = 0.2f;
        this.textureWidth = 1024;
        this.textureHeight = 1024;
        (this.Body = new ModelRenderer((ModelBase) this, 300, 0)).addBox(0.0f, 0.0f, 1.0f, 60, 35, 65);
        this.Body.setRotationPoint(-30.0f, -46.0f, 3.0f);
        this.Body.setTextureSize(1024, 1024);
        this.Body.mirror = true;
        this.setRotation(this.Body, -0.8203047f, 0.0f, 0.0f);
        (this.LegL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 20, 10);
        this.LegL.setRotationPoint(30.0f, 5.0f, 12.0f);
        this.LegL.setTextureSize(1024, 1024);
        this.LegL.mirror = true;
        this.setRotation(this.LegL, 0.0f, 0.0f, 0.0f);
        (this.LegR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 20, 10);
        this.LegR.setRotationPoint(-40.0f, 5.0f, 13.0f);
        this.LegR.setTextureSize(1024, 1024);
        this.LegR.mirror = true;
        this.setRotation(this.LegR, 0.0f, 0.0f, 0.0f);
        (this.BodyCentre = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.0f, 1.0f, -7.0f, 58, 33, 65);
        this.BodyCentre.setRotationPoint(-30.0f, -46.0f, 3.0f);
        this.BodyCentre.setTextureSize(1024, 1024);
        this.BodyCentre.mirror = true;
        this.setRotation(this.BodyCentre, -0.8203047f, 0.0f, 0.0f);
        (this.FootL = new ModelRenderer((ModelBase) this, 122, 122)).addBox(0.0f, 0.0f, 0.0f, 12, 5, 12);
        this.FootL.setRotationPoint(29.0f, 21.0f, 11.0f);
        this.FootL.setTextureSize(1024, 1024);
        this.FootL.mirror = true;
        this.setRotation(this.FootL, 0.0f, 0.0f, 0.0f);
        (this.FootR = new ModelRenderer((ModelBase) this, 122, 122)).addBox(0.0f, 0.0f, 0.0f, 12, 5, 12);
        this.FootR.setRotationPoint(-41.0f, 21.0f, 12.0f);
        this.FootR.setTextureSize(1024, 1024);
        this.FootR.mirror = true;
        this.setRotation(this.FootR, 0.0f, 0.0f, 0.0f);
        (this.LegMuscle = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 84, 14, 14);
        this.LegMuscle.setRotationPoint(-42.0f, -4.0f, 10.0f);
        this.LegMuscle.setTextureSize(1024, 1024);
        this.LegMuscle.mirror = true;
        this.setRotation(this.LegMuscle, 0.0f, 0.0f, 0.0f);
        (this.Bum = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 9.0f, 52, 30, 65);
        this.Bum.setRotationPoint(-26.0f, -47.0f, 0.0f);
        this.Bum.setTextureSize(1024, 1024);
        this.Bum.mirror = true;
        this.setRotation(this.Bum, -0.8203047f, 0.0f, 0.0f);
        (this.BodyTop = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -11.0f, 48, 30, 49);
        this.BodyTop.setRotationPoint(-24.0f, -45.0f, 0.0f);
        this.BodyTop.setTextureSize(1024, 1024);
        this.BodyTop.mirror = true;
        this.setRotation(this.BodyTop, -0.8203047f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 14, 14, 14);
        this.Tail.setRotationPoint(-7.0f, 15.0f, 29.0f);
        this.Tail.setTextureSize(1024, 1024);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.3717861f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 22, 18, 50);
        this.Neck.setRotationPoint(-10.0f, -51.2f, -16.0f);
        this.Neck.setTextureSize(1024, 1024);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, -0.8203047f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 26, 24, 15);
        this.Head.setRotationPoint(-12.0f, -60.0f, -28.0f);
        this.Head.setTextureSize(1024, 1024);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Face = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 24, 22, 15);
        this.Face.setRotationPoint(-11.0f, -59.0f, -35.0f);
        this.Face.setTextureSize(1024, 1024);
        this.Face.mirror = true;
        this.setRotation(this.Face, 0.0f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase) this, 0, 120)).addBox(0.0f, 0.0f, 0.0f, 15, 10, 15);
        this.Nose.setRotationPoint(-6.0f, -50.0f, -43.0f);
        this.Nose.setTextureSize(1024, 1024);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0f, 0.0f, 0.0f);
        (this.EarL = new ModelRenderer((ModelBase) this, 0, 160)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 2);
        this.EarL.setRotationPoint(6.0f, -64.0f, -20.0f);
        this.EarL.setTextureSize(1024, 1024);
        this.EarL.mirror = true;
        this.setRotation(this.EarL, 0.0f, 0.0f, 0.0f);
        (this.EarR = new ModelRenderer((ModelBase) this, 0, 160)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 2);
        this.EarR.setRotationPoint(-10.0f, -64.0f, -20.0f);
        this.EarR.setTextureSize(1024, 1024);
        this.EarR.mirror = true;
        this.setRotation(this.EarR, 0.0f, 0.0f, 0.0f);
        (this.Larm = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 35, 10);
        this.Larm.setRotationPoint(29.0f, -24.0f, 2.0f);
        this.Larm.setTextureSize(1024, 1024);
        this.Larm.mirror = true;
        this.setRotation(this.Larm, -1.301251f, 0.0f, 0.0f);
        (this.Rarm = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 35, 10);
        this.Rarm.setRotationPoint(-40.0f, -24.0f, 2.0f);
        this.Rarm.setTextureSize(1024, 1024);
        this.Rarm.mirror = true;
        this.setRotation(this.Rarm, -1.301251f, 0.0f, 0.0f);
        (this.Claw3 = new ModelRenderer((ModelBase) this, 222, 222)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Claw3.setRotationPoint(30.0f, -14.0f, -29.0f);
        this.Claw3.setTextureSize(1024, 1024);
        this.Claw3.mirror = true;
        this.setRotation(this.Claw3, 0.0f, 0.0f, 0.0f);
        (this.Claw2 = new ModelRenderer((ModelBase) this, 222, 222)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Claw2.setRotationPoint(34.0f, -14.0f, -29.0f);
        this.Claw2.setTextureSize(1024, 1024);
        this.Claw2.mirror = true;
        this.setRotation(this.Claw2, 0.0f, 0.0f, 0.0f);
        (this.Claw1 = new ModelRenderer((ModelBase) this, 222, 222)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Claw1.setRotationPoint(38.0f, -14.0f, -29.0f);
        this.Claw1.setTextureSize(1024, 1024);
        this.Claw1.mirror = true;
        this.setRotation(this.Claw1, 0.0f, 0.0f, 0.0f);
        (this.Claw5 = new ModelRenderer((ModelBase) this, 222, 222)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Claw5.setRotationPoint(-36.0f, -14.0f, -29.0f);
        this.Claw5.setTextureSize(1024, 1024);
        this.Claw5.mirror = true;
        this.setRotation(this.Claw5, 0.0f, 0.0f, 0.0f);
        (this.Claw4 = new ModelRenderer((ModelBase) this, 222, 222)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Claw4.setRotationPoint(-32.0f, -14.0f, -29.0f);
        this.Claw4.setTextureSize(1024, 1024);
        this.Claw4.mirror = true;
        this.setRotation(this.Claw4, 0.0f, 0.0f, 0.0f);
        (this.Claw6 = new ModelRenderer((ModelBase) this, 222, 222)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 10);
        this.Claw6.setRotationPoint(-40.0f, -14.0f, -29.0f);
        this.Claw6.setTextureSize(1024, 1024);
        this.Claw6.mirror = true;
        this.setRotation(this.Claw6, 0.0f, 0.0f, 0.0f);
        (this.Eyes = new ModelRenderer((ModelBase) this, 0, 200)).addBox(0.0f, 0.0f, 0.0f, 28, 2, 6);
        this.Eyes.setRotationPoint(-13.0f, -54.0f, -31.0f);
        this.Eyes.setTextureSize(1024, 1024);
        this.Eyes.mirror = true;
        this.setRotation(this.Eyes, 0.2230717f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final BearInstance e = (BearInstance) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.Claw1.rotateAngleX = -40.0f - newangle;
        this.Claw2.rotateAngleX = -40.0f - newangle;
        this.Claw3.rotateAngleX = -40.0f - newangle;
        this.Claw4.rotateAngleX = -40.0f + newangle;
        this.Claw5.rotateAngleX = -40.0f + newangle;
        this.Claw6.rotateAngleX = -40.0f + newangle;
        this.LegL.rotateAngleX = newangle;
        this.FootL.rotateAngleX = newangle;
        this.LegR.rotateAngleX = -newangle;
        this.FootR.rotateAngleX = -newangle;
        this.Body.render(f5);
        this.LegL.render(f5);
        this.LegR.render(f5);
        this.BodyCentre.render(f5);
        this.FootL.render(f5);
        this.FootR.render(f5);
        this.LegMuscle.render(f5);
        this.Bum.render(f5);
        this.BodyTop.render(f5);
        this.Tail.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.Face.render(f5);
        this.Nose.render(f5);
        this.EarL.render(f5);
        this.EarR.render(f5);
        this.Larm.render(f5);
        this.Rarm.render(f5);
        this.Claw3.render(f5);
        this.Claw2.render(f5);
        this.Claw1.render(f5);
        this.Claw5.render(f5);
        this.Claw4.render(f5);
        this.Claw6.render(f5);
        this.Eyes.render(f5);
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
