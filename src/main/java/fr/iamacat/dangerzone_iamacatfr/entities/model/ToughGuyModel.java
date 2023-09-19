
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.ToughGuyInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ToughGuyModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Chest;
    ModelRenderer Belly;
    ModelRenderer Belly2;
    ModelRenderer BodyBottom;
    ModelRenderer LegL;
    ModelRenderer FootL;
    ModelRenderer LegR;
    ModelRenderer FootR;
    ModelRenderer Shoulders;
    ModelRenderer ArmL;
    ModelRenderer ArmR;
    ModelRenderer HandL;
    ModelRenderer HandR;
    ModelRenderer MuscleL;
    ModelRenderer MuscleR;
    ModelRenderer Head;
    ModelRenderer SixPack6;
    ModelRenderer SixPack5;
    ModelRenderer SixPack3;
    ModelRenderer SixPack4;
    ModelRenderer SixPack1;
    ModelRenderer SixPack2;

    public ToughGuyModel() {
        this.wingspeed = 1.0f;
        this.textureWidth = 1024;
        this.textureHeight = 1024;
        (this.Chest = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 24, 10, 16);
        this.Chest.setRotationPoint(-11.0f, -17.0f, -7.0f);
        this.Chest.setTextureSize(1024, 1024);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 0.0f, 0.0f, 0.0f);
        (this.Belly = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 22, 9, 14);
        this.Belly.setRotationPoint(-10.0f, -12.0f, -6.0f);
        this.Belly.setTextureSize(1024, 1024);
        this.Belly.mirror = true;
        this.setRotation(this.Belly, 0.0f, 0.0f, 0.0f);
        (this.Belly2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 7, 13);
        this.Belly2.setRotationPoint(-9.0f, -6.0f, -5.5f);
        this.Belly2.setTextureSize(1024, 1024);
        this.Belly2.mirror = true;
        this.setRotation(this.Belly2, 0.0f, 0.0f, 0.0f);
        (this.BodyBottom = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 18, 6, 11);
        this.BodyBottom.setRotationPoint(-8.0f, -3.0f, -4.5f);
        this.BodyBottom.setTextureSize(1024, 1024);
        this.BodyBottom.mirror = true;
        this.setRotation(this.BodyBottom, 0.0f, 0.0f, 0.0f);
        (this.LegL = new ModelRenderer((ModelBase) this, 90, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 10, 10);
        this.LegL.setRotationPoint(3.0f, 3.0f, -4.0f);
        this.LegL.setTextureSize(1024, 1024);
        this.LegL.mirror = true;
        this.setRotation(this.LegL, 0.0f, 0.0f, 0.0f);
        (this.FootL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 12, 7);
        this.FootL.setRotationPoint(4.5f, 12.0f, -2.5f);
        this.FootL.setTextureSize(1024, 1024);
        this.FootL.mirror = true;
        this.setRotation(this.FootL, 0.0f, 0.0f, 0.0f);
        (this.LegR = new ModelRenderer((ModelBase) this, 90, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 10, 10);
        this.LegR.setRotationPoint(-12.0f, 3.0f, -4.0f);
        this.LegR.setTextureSize(1024, 1024);
        this.LegR.mirror = true;
        this.setRotation(this.LegR, 0.0f, 0.0f, 0.0f);
        (this.FootR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 12, 7);
        this.FootR.setRotationPoint(-10.5f, 12.0f, -2.5f);
        this.FootR.setTextureSize(1024, 1024);
        this.FootR.mirror = true;
        this.setRotation(this.FootR, 0.0f, 0.0f, 0.0f);
        (this.Shoulders = new ModelRenderer((ModelBase) this, 30, 30)).addBox(0.0f, 0.0f, 0.0f, 42, 10, 10);
        this.Shoulders.setRotationPoint(-20.0f, -16.0f, -4.0f);
        this.Shoulders.setTextureSize(1024, 1024);
        this.Shoulders.mirror = true;
        this.setRotation(this.Shoulders, 0.0f, 0.0f, 0.0f);
        (this.ArmL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 12, 8);
        this.ArmL.setRotationPoint(13.0f, -10.0f, -2.0f);
        this.ArmL.setTextureSize(1024, 1024);
        this.ArmL.mirror = true;
        this.setRotation(this.ArmL, -0.4089647f, 0.0f, 0.0f);
        (this.ArmR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 12, 8);
        this.ArmR.setRotationPoint(-19.0f, -10.0f, -2.0f);
        this.ArmR.setTextureSize(1024, 1024);
        this.ArmR.mirror = true;
        this.setRotation(this.ArmR, -0.4089647f, 0.0f, 0.0f);
        (this.HandL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 15, 7);
        this.HandL.setRotationPoint(13.5f, -3.0f, -2.0f);
        this.HandL.setTextureSize(1024, 1024);
        this.HandL.mirror = true;
        this.setRotation(this.HandL, -1.264073f, 0.0f, 0.0f);
        (this.HandR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 15, 7);
        this.HandR.setRotationPoint(-18.5f, -3.0f, -2.0f);
        this.HandR.setTextureSize(1024, 1024);
        this.HandR.mirror = true;
        this.setRotation(this.HandR, -1.264073f, 0.0f, 0.0f);
        (this.MuscleL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -6.0f, 6, 7, 8);
        this.MuscleL.setRotationPoint(14.0f, -6.0f, 0.0f);
        this.MuscleL.setTextureSize(1024, 1024);
        this.MuscleL.mirror = true;
        this.setRotation(this.MuscleL, -0.4089647f, 0.0f, 0.0f);
        (this.MuscleR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -6.0f, 6, 7, 8);
        this.MuscleR.setRotationPoint(-18.0f, -6.0f, 0.0f);
        this.MuscleR.setTextureSize(1024, 1024);
        this.MuscleR.mirror = true;
        this.setRotation(this.MuscleR, -0.4089647f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 30)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.Head.setRotationPoint(-2.0f, -25.0f, -1.0f);
        this.Head.setTextureSize(1024, 1024);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.SixPack6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 3);
        this.SixPack6.setRotationPoint(2.0f, 1.0f, -7.0f);
        this.SixPack6.setTextureSize(1024, 1024);
        this.SixPack6.mirror = true;
        this.setRotation(this.SixPack6, 0.0f, 0.0f, 0.0f);
        (this.SixPack5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 3);
        this.SixPack5.setRotationPoint(-5.0f, 1.0f, -7.0f);
        this.SixPack5.setTextureSize(1024, 1024);
        this.SixPack5.mirror = true;
        this.setRotation(this.SixPack5, 0.0f, 0.0f, 0.0f);
        (this.SixPack3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 3);
        this.SixPack3.setRotationPoint(-5.0f, -3.0f, -7.0f);
        this.SixPack3.setTextureSize(1024, 1024);
        this.SixPack3.mirror = true;
        this.setRotation(this.SixPack3, 0.0f, 0.0f, 0.0f);
        (this.SixPack4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 3);
        this.SixPack4.setRotationPoint(2.0f, -3.0f, -7.0f);
        this.SixPack4.setTextureSize(1024, 1024);
        this.SixPack4.mirror = true;
        this.setRotation(this.SixPack4, 0.0f, 0.0f, 0.0f);
        (this.SixPack1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 3);
        this.SixPack1.setRotationPoint(-5.0f, -7.0f, -7.0f);
        this.SixPack1.setTextureSize(1024, 1024);
        this.SixPack1.mirror = true;
        this.setRotation(this.SixPack1, 0.0f, 0.0f, 0.0f);
        (this.SixPack2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 3);
        this.SixPack2.setRotationPoint(2.0f, -7.0f, -7.0f);
        this.SixPack2.setTextureSize(1024, 1024);
        this.SixPack2.mirror = true;
        this.setRotation(this.SixPack2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final ToughGuyInstance e = (ToughGuyInstance) entity;
        InfoRenderer r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle1;
        if (f1 > 0.1) {
            newangle1 = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.141593f * 0.12f * f1;
        } else {
            newangle1 = 0.0f;
        }
        this.LegL.rotateAngleX = newangle1;
        this.FootL.rotateAngleX = newangle1;
        this.LegR.rotateAngleX = -newangle1;
        this.FootR.rotateAngleX = -newangle1;
        this.Head.rotateAngleY = (float) Math.toRadians(f3);
        float newangle2 = MathHelper.sin((float) Math.toRadians(f2 * 20.0f * this.wingspeed));
        final float nextangle = MathHelper.sin((float) Math.toRadians(f2 * 20.0f * this.wingspeed + 1.5f));
        r = e.getRenderInfo();
        if (nextangle > 0.0f && newangle2 < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() == 0) {
                r.ri1 = 0;
            } else {
                while (r.ri1 == 0) {
                    r.ri1 = e.worldObj.rand.nextInt(4);
                }
            }
        }
        newangle2 = (float) Math.toRadians(f2 * 60.0f * this.wingspeed);
        if (r.ri1 == 1 || r.ri1 == 3) {
            this.ArmR.rotateAngleX = newangle2;
            this.MuscleR.rotateAngleX = newangle2;
            this.HandR.rotateAngleX = newangle2;
        } else {
            this.ArmR.rotateAngleX = 0.0f;
            this.MuscleR.rotateAngleX = 0.0f;
            this.HandR.rotateAngleX = 0.0f;
        }
        if (r.ri1 == 2 || r.ri1 == 3) {
            this.ArmL.rotateAngleX = newangle2;
            this.MuscleL.rotateAngleX = newangle2;
            this.HandL.rotateAngleX = newangle2;
        } else {
            this.ArmL.rotateAngleX = 0.0f;
            this.MuscleL.rotateAngleX = 0.0f;
            this.HandL.rotateAngleX = 0.0f;
        }
        e.setRenderInfo(r);
        this.Chest.render(f5);
        this.Belly.render(f5);
        this.Belly2.render(f5);
        this.BodyBottom.render(f5);
        this.LegL.render(f5);
        this.FootL.render(f5);
        this.LegR.render(f5);
        this.FootR.render(f5);
        this.Shoulders.render(f5);
        this.ArmL.render(f5);
        this.ArmR.render(f5);
        this.HandL.render(f5);
        this.HandR.render(f5);
        this.MuscleL.render(f5);
        this.MuscleR.render(f5);
        this.Head.render(f5);
        this.SixPack6.render(f5);
        this.SixPack5.render(f5);
        this.SixPack3.render(f5);
        this.SixPack4.render(f5);
        this.SixPack1.render(f5);
        this.SixPack2.render(f5);
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
