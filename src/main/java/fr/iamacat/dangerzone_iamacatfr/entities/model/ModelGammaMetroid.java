
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GammaMetroid;

public class ModelGammaMetroid extends ModelBase {

    private float wingspeed;
    ModelRenderer Shell3;
    ModelRenderer Shell4;
    ModelRenderer Head;
    ModelRenderer BeakUpper;
    ModelRenderer BeakLower;
    ModelRenderer LeftTusk;
    ModelRenderer MiddleTusk;
    ModelRenderer RightTusk;
    ModelRenderer LeftFrontUpperLeg;
    ModelRenderer LeftFrontLowerLeg;
    ModelRenderer LeftRearUpperLeg;
    ModelRenderer LeftRearLowerLeg;
    ModelRenderer RightFrontUpperLeg;
    ModelRenderer RightFrontLowerLeg;
    ModelRenderer RightRearUpperLeg;
    ModelRenderer RightRearLowerLeg;
    ModelRenderer Core;
    ModelRenderer Bellyinside;
    ModelRenderer Bellyoutside;
    ModelRenderer Shell1;
    ModelRenderer Shell2;

    public ModelGammaMetroid(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 64;
        (this.Shell3 = new ModelRenderer((ModelBase) this, 128, 0)).addBox(-6.0f, -6.0f, 0.0f, 12, 12, 7);
        this.Shell3.setRotationPoint(0.0f, 7.0f, 10.0f);
        this.Shell3.setTextureSize(256, 64);
        this.Shell3.mirror = true;
        this.setRotation(this.Shell3, -0.9599311f, 0.6283185f, 0.5235988f);
        (this.Shell4 = new ModelRenderer((ModelBase) this, 48, 34)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 8);
        this.Shell4.setRotationPoint(-3.0f, 9.0f, 13.0f);
        this.Shell4.setTextureSize(256, 64);
        this.Shell4.mirror = true;
        this.setRotation(this.Shell4, -0.2792527f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 48, 48)).addBox(0.0f, 0.0f, 0.0f, 16, 8, 6);
        this.Head.setRotationPoint(-8.0f, -1.0f, -11.0f);
        this.Head.setTextureSize(256, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.BeakUpper = new ModelRenderer((ModelBase) this, 114, 44)).addBox(-3.0f, 0.0f, -3.0f, 6, 4, 6);
        this.BeakUpper.setRotationPoint(0.0f, 5.0f, -11.0f);
        this.BeakUpper.setTextureSize(256, 64);
        this.BeakUpper.mirror = true;
        this.setRotation(this.BeakUpper, 0.1047198f, 0.7853982f, 0.1047198f);
        (this.BeakLower = new ModelRenderer((ModelBase) this, 120, 54)).addBox(-1.5f, 0.0f, -1.5f, 3, 6, 3);
        this.BeakLower.setRotationPoint(0.0f, 9.0f, -12.0f);
        this.BeakLower.setTextureSize(256, 64);
        this.BeakLower.mirror = true;
        this.setRotation(this.BeakLower, 0.1396263f, 0.7853982f, 0.1396263f);
        (this.LeftTusk = new ModelRenderer((ModelBase) this, 76, 50)).addBox(0.0f, 0.0f, -12.0f, 2, 2, 12);
        this.LeftTusk.setRotationPoint(5.0f, 6.0f, -10.0f);
        this.LeftTusk.setTextureSize(256, 64);
        this.LeftTusk.mirror = true;
        this.setRotation(this.LeftTusk, 0.1047198f, 0.0872665f, 0.0f);
        (this.MiddleTusk = new ModelRenderer((ModelBase) this, 76, 50)).addBox(-1.0f, 0.0f, -12.0f, 2, 2, 12);
        this.MiddleTusk.setRotationPoint(0.0f, -2.0f, -10.0f);
        this.MiddleTusk.setTextureSize(256, 64);
        this.MiddleTusk.mirror = true;
        this.setRotation(this.MiddleTusk, 0.122173f, 0.0f, 0.0f);
        (this.RightTusk = new ModelRenderer((ModelBase) this, 76, 50)).addBox(-2.0f, 0.0f, -12.0f, 2, 2, 12);
        this.RightTusk.setRotationPoint(-5.0f, 6.0f, -10.0f);
        this.RightTusk.setTextureSize(256, 64);
        this.RightTusk.mirror = true;
        this.setRotation(this.RightTusk, 0.1047198f, -0.0872665f, 0.0f);
        (this.LeftFrontUpperLeg = new ModelRenderer((ModelBase) this, 64, 0)).addBox(0.0f, 0.0f, -1.5f, 3, 8, 3);
        this.LeftFrontUpperLeg.setRotationPoint(8.0f, 8.0f, -2.0f);
        this.LeftFrontUpperLeg.setTextureSize(256, 64);
        this.LeftFrontUpperLeg.mirror = true;
        this.setRotation(this.LeftFrontUpperLeg, -0.1745329f, 0.0f, -0.6632251f);
        (this.LeftFrontLowerLeg = new ModelRenderer((ModelBase) this, 48, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.LeftFrontLowerLeg.setRotationPoint(14.0f, 13.0f, -3.5f);
        this.LeftFrontLowerLeg.setTextureSize(256, 64);
        this.LeftFrontLowerLeg.mirror = true;
        this.setRotation(this.LeftFrontLowerLeg, -0.2617994f, 0.1396263f, 0.0f);
        (this.LeftRearUpperLeg = new ModelRenderer((ModelBase) this, 64, 0)).addBox(-1.0f, 0.0f, -1.5f, 3, 8, 3);
        this.LeftRearUpperLeg.setRotationPoint(8.0f, 9.0f, 7.0f);
        this.LeftRearUpperLeg.setTextureSize(256, 64);
        this.LeftRearUpperLeg.mirror = true;
        this.setRotation(this.LeftRearUpperLeg, 0.1745329f, 0.0f, -0.8203047f);
        (this.LeftRearLowerLeg = new ModelRenderer((ModelBase) this, 48, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.LeftRearLowerLeg.setRotationPoint(14.0f, 14.0f, 8.5f);
        this.LeftRearLowerLeg.setTextureSize(256, 64);
        this.LeftRearLowerLeg.mirror = true;
        this.setRotation(this.LeftRearLowerLeg, 0.3141593f, -0.1570796f, -0.2792527f);
        (this.RightFrontUpperLeg = new ModelRenderer((ModelBase) this, 64, 0)).addBox(-3.0f, 0.0f, -1.5f, 3, 8, 3);
        this.RightFrontUpperLeg.setRotationPoint(-8.0f, 8.0f, -2.0f);
        this.RightFrontUpperLeg.setTextureSize(256, 64);
        this.RightFrontUpperLeg.mirror = true;
        this.setRotation(this.RightFrontUpperLeg, -0.1745329f, 0.0f, 0.6632251f);
        (this.RightFrontLowerLeg = new ModelRenderer((ModelBase) this, 48, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.RightFrontLowerLeg.setRotationPoint(-14.0f, 13.0f, -3.5f);
        this.RightFrontLowerLeg.setTextureSize(256, 64);
        this.RightFrontLowerLeg.mirror = true;
        this.setRotation(this.RightFrontLowerLeg, -0.2617994f, -0.1396263f, 0.0f);
        (this.RightRearUpperLeg = new ModelRenderer((ModelBase) this, 64, 0)).addBox(-2.0f, 0.0f, -1.5f, 3, 8, 3);
        this.RightRearUpperLeg.setRotationPoint(-8.0f, 9.0f, 7.0f);
        this.RightRearUpperLeg.setTextureSize(256, 64);
        this.RightRearUpperLeg.mirror = true;
        this.setRotation(this.RightRearUpperLeg, 0.1745329f, 0.0f, 0.8203047f);
        (this.RightRearLowerLeg = new ModelRenderer((ModelBase) this, 48, 0)).addBox(-1.0f, 0.0f, -1.0f, 2, 11, 2);
        this.RightRearLowerLeg.setRotationPoint(-14.0f, 14.0f, 8.5f);
        this.RightRearLowerLeg.setTextureSize(256, 64);
        this.RightRearLowerLeg.mirror = true;
        this.setRotation(this.RightRearLowerLeg, 0.3141593f, 0.1570796f, 0.2792527f);
        (this.Core = new ModelRenderer((ModelBase) this, 82, 33)).addBox(-3.0f, 0.0f, -3.0f, 6, 6, 6);
        this.Core.setRotationPoint(0.0f, 8.0f, 3.0f);
        this.Core.setTextureSize(256, 64);
        this.Core.mirror = true;
        this.setRotation(this.Core, -0.122173f, 0.0f, 0.0f);
        (this.Bellyinside = new ModelRenderer((ModelBase) this, 150, 3)).addBox(-8.0f, -1.0f, -8.0f, 16, 1, 16);
        this.Bellyinside.setRotationPoint(0.0f, 8.0f, 2.0f);
        this.Bellyinside.setTextureSize(256, 64);
        this.Bellyinside.mirror = true;
        this.setRotation(this.Bellyinside, -0.122173f, 0.0f, 0.0f);
        (this.Bellyoutside = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-8.0f, -6.0f, -8.0f, 16, 14, 16);
        this.Bellyoutside.setRotationPoint(0.0f, 8.0f, 2.0f);
        this.Bellyoutside.setTextureSize(256, 64);
        this.Bellyoutside.mirror = true;
        this.setRotation(this.Bellyoutside, -0.122173f, 0.0f, 0.0f);
        (this.Shell1 = new ModelRenderer((ModelBase) this, 64, 0)).addBox(-10.0f, -10.0f, 2.0f, 19, 19, 12);
        this.Shell1.setRotationPoint(0.0f, 4.0f, -7.0f);
        this.Shell1.setTextureSize(256, 64);
        this.Shell1.mirror = true;
        this.setRotation(this.Shell1, 0.0f, 0.0f, 0.7853982f);
        (this.Shell2 = new ModelRenderer((ModelBase) this, 0, 30)).addBox(-9.0f, -9.0f, 0.0f, 16, 16, 8);
        this.Shell2.setRotationPoint(0.0f, 4.5f, 5.0f);
        this.Shell2.setTextureSize(256, 64);
        this.Shell2.mirror = true;
        this.setRotation(this.Shell2, -0.5235988f, 0.3665191f, 0.715585f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final GammaMetroid e = (GammaMetroid) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.cos(f2 * 0.81f * this.wingspeed) * 3.1415927f * 0.08f;
        this.LeftTusk.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.87f * this.wingspeed) * 3.1415927f * 0.08f;
        this.RightTusk.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.99f * this.wingspeed) * 3.1415927f * 0.08f;
        this.MiddleTusk.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 1.11f * this.wingspeed) * 3.1415927f * 0.08f;
        this.LeftTusk.rotateAngleY = newangle;
        newangle = MathHelper.cos(f2 * 1.17f * this.wingspeed) * 3.1415927f * 0.08f;
        this.RightTusk.rotateAngleY = newangle;
        newangle = MathHelper.cos(f2 * 1.25f * this.wingspeed) * 3.1415927f * 0.08f;
        this.MiddleTusk.rotateAngleY = newangle;
        float nextangle = 0.0f;
        float upangle = 0.0f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        upangle = 0.0f;
        if (nextangle > newangle) {
            upangle = 0.47f * f1 - Math.abs(newangle);
        }
        this.doLeftFLeg(this.LeftFrontUpperLeg, this.LeftFrontLowerLeg, newangle, upangle);
        this.doRightFLeg(this.RightFrontUpperLeg, this.RightFrontLowerLeg, -newangle, upangle);
        this.doLeftRLeg(this.LeftRearUpperLeg, this.LeftRearLowerLeg, -newangle, upangle);
        this.doRightRLeg(this.RightRearUpperLeg, this.RightRearLowerLeg, newangle, upangle);
        newangle = MathHelper.cos(f2 * 0.4f * this.wingspeed) * 3.1415927f * 0.05f;
        if (e.isSitting()) {
            newangle = 0.0f;
        }
        this.Shell1.rotateAngleX = newangle / 4.0f;
        this.Shell1.rotateAngleY = -(newangle / 4.0f);
        this.Shell2.rotateAngleX = newangle - 0.49f;
        this.Shell2.rotateAngleY = -newangle + 0.33f;
        this.Shell3.rotateAngleX = newangle - 0.96f;
        this.Shell3.rotateAngleY = -newangle + 0.63f;
        this.Shell4.rotateAngleX = newangle - 0.28f;
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.1415927f * 0.1f;
        newangle = Math.abs(newangle);
        this.BeakLower.rotateAngleX = newangle + 0.14f;
        this.BeakLower.rotateAngleZ = newangle + 0.14f;
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        this.Core.render(f5);
        this.Shell3.render(f5);
        this.Shell4.render(f5);
        this.Head.render(f5);
        this.BeakUpper.render(f5);
        this.BeakLower.render(f5);
        this.LeftTusk.render(f5);
        this.MiddleTusk.render(f5);
        this.RightTusk.render(f5);
        this.LeftFrontUpperLeg.render(f5);
        this.LeftFrontLowerLeg.render(f5);
        this.LeftRearUpperLeg.render(f5);
        this.LeftRearLowerLeg.render(f5);
        this.RightFrontUpperLeg.render(f5);
        this.RightFrontLowerLeg.render(f5);
        this.RightRearUpperLeg.render(f5);
        this.RightRearLowerLeg.render(f5);
        this.Bellyinside.render(f5);
        this.Shell1.render(f5);
        this.Shell2.render(f5);
        this.Bellyoutside.render(f5);
        GL11.glDisable(3042);
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

    private void doLeftFLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle,
        final float upangle) {
        seg2.rotateAngleX = angle - 0.17f;
        seg3.rotateAngleX = angle - 0.26f;
        seg3.rotationPointZ = (float) (seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0) - 0.5f;
        seg2.rotateAngleZ = -upangle - 0.66f;
        seg3.rotateAngleZ = -upangle;
        seg3.rotationPointY = seg2.rotationPointY + (float) (5.0 * Math.cos(seg2.rotateAngleX));
        seg3.rotationPointX = (float) (seg2.rotationPointX + Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0) + 1.0);
    }

    private void doLeftRLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle,
        final float upangle) {
        seg2.rotateAngleX = angle + 0.17f;
        seg3.rotateAngleX = angle + 0.31f;
        seg3.rotationPointZ = (float) (seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0) - 0.5f;
        seg2.rotateAngleZ = -upangle - 0.82f;
        seg3.rotateAngleZ = -upangle;
        seg3.rotationPointY = seg2.rotationPointY + (float) (5.0 * Math.cos(seg2.rotateAngleX));
        seg3.rotationPointX = (float) (seg2.rotationPointX + Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0) + 1.5);
    }

    private void doRightFLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle,
        final float upangle) {
        seg2.rotateAngleX = angle - 0.17f;
        seg3.rotateAngleX = angle - 0.26f;
        seg3.rotationPointZ = (float) (seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0) - 0.5f;
        seg2.rotateAngleZ = -upangle + 0.34f;
        seg3.rotateAngleZ = -upangle;
        seg3.rotationPointY = seg2.rotationPointY + (float) (5.0 * Math.cos(seg2.rotateAngleX));
        seg3.rotationPointX = (float) (seg2.rotationPointX - Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0) - 1.0);
    }

    private void doRightRLeg(final ModelRenderer seg2, final ModelRenderer seg3, final float angle,
        final float upangle) {
        seg2.rotateAngleX = angle + 0.17f;
        seg3.rotateAngleX = angle + 0.31f;
        seg3.rotationPointZ = (float) (seg2.rotationPointZ + Math.sin(seg2.rotateAngleX) * 7.0) - 0.5f;
        seg2.rotateAngleZ = -upangle + 0.82f;
        seg3.rotateAngleZ = -upangle;
        seg3.rotationPointY = seg2.rotationPointY + (float) (5.0 * Math.cos(seg2.rotateAngleX));
        seg3.rotationPointX = (float) (seg2.rotationPointX - Math.abs(Math.sin(seg2.rotateAngleZ) * 7.0) - 1.5);
    }
}
