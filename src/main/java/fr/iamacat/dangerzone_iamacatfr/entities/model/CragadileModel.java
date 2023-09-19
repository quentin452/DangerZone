
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CragadileInstance;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class CragadileModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer Neck;
    ModelRenderer NeckTip;
    ModelRenderer Head;
    ModelRenderer NoseTip;
    ModelRenderer FaceL;
    ModelRenderer FaceR;
    ModelRenderer Shape1;
    ModelRenderer Mouth;
    ModelRenderer EyeL;
    ModelRenderer EyeR;
    ModelRenderer Body2;
    ModelRenderer Nody3;
    ModelRenderer Body4;
    ModelRenderer Body5;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer LegLF;
    ModelRenderer LegLB;
    ModelRenderer LegRF;
    ModelRenderer LegRB;
    ModelRenderer FeetLF;
    ModelRenderer FeetLB;
    ModelRenderer FeetRF;
    ModelRenderer FeetRB;
    ModelRenderer S1;
    ModelRenderer S3;
    ModelRenderer S6;
    ModelRenderer S2;
    ModelRenderer S4;
    ModelRenderer S5;

    public CragadileModel(final float f1) {
        this.wingspeed = 0.5f;
        this.textureWidth = 2048;
        this.textureHeight = 2048;
        (this.Body = new ModelRenderer((ModelBase) this, 0, 300)).addBox(0.0f, 0.0f, 0.0f, 70, 35, 60);
        this.Body.setRotationPoint(-32.0f, -13.0f, -19.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 0, 200)).addBox(0.0f, 0.0f, 0.0f, 55, 28, 20);
        this.Neck.setRotationPoint(-23.0f, -9.0f, -39.0f);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.NeckTip = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 50, 26, 12);
        this.NeckTip.setRotationPoint(-21.0f, -7.0f, -51.0f);
        this.NeckTip.setTextureSize(64, 32);
        this.NeckTip.mirror = true;
        this.setRotation(this.NeckTip, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 500, 0)).addBox(0.0f, 0.0f, 0.0f, 50, 18, 65);
        this.Head.setRotationPoint(-20.0f, -16.0f, -109.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.NoseTip = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -18.0f, 23, 12, 50);
        this.NoseTip.setRotationPoint(-7.0f, -19.0f, -130.0f);
        this.NoseTip.setTextureSize(64, 32);
        this.NoseTip.mirror = true;
        this.setRotation(this.NoseTip, -0.1858931f, 0.0f, 0.0f);
        (this.FaceL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -10.0f, 30, 15, 74);
        this.FaceL.setRotationPoint(-2.0f, -16.0f, -109.0f);
        this.FaceL.setTextureSize(64, 32);
        this.FaceL.mirror = true;
        this.setRotation(this.FaceL, 0.0f, 0.2602503f, 0.2602503f);
        (this.FaceR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -10.0f, 30, 15, 74);
        this.FaceR.setRotationPoint(-19.0f, -8.0f, -115.0f);
        this.FaceR.setTextureSize(64, 32);
        this.FaceR.mirror = true;
        this.setRotation(this.FaceR, 0.0f, -0.260246f, -0.260246f);
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 23, 9, 31);
        this.Shape1.setRotationPoint(-7.0f, -18.0f, -141.4667f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, -0.3717861f, 0.0f, 0.0f);
        (this.Mouth = new ModelRenderer((ModelBase) this, 300, 300)).addBox(0.0f, 0.0f, 0.0f, 46, 10, 64);
        this.Mouth.setRotationPoint(-20.0f, 19.0f, -110.0f);
        this.Mouth.setTextureSize(64, 32);
        this.Mouth.mirror = true;
        this.setRotation(this.Mouth, 0.2230717f, 0.0f, 0.0f);
        (this.EyeL = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 14, 20);
        this.EyeL.setRotationPoint(25.0f, -25.0f, -90.0f);
        this.EyeL.setTextureSize(64, 32);
        this.EyeL.mirror = true;
        this.setRotation(this.EyeL, -0.1858931f, 0.0f, 0.0f);
        (this.EyeR = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 14, 20);
        this.EyeR.setRotationPoint(-20.0f, -25.0f, -90.0f);
        this.EyeR.setTextureSize(64, 32);
        this.EyeR.mirror = true;
        this.setRotation(this.EyeR, -0.1858931f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase) this, 0, 450)).addBox(0.0f, 0.0f, 0.0f, 65, 32, 50);
        this.Body2.setRotationPoint(-30.0f, -12.0f, 23.0f);
        this.Body2.setTextureSize(64, 32);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Nody3 = new ModelRenderer((ModelBase) this, 0, 550)).addBox(0.0f, 0.0f, 0.0f, 60, 28, 40);
        this.Nody3.setRotationPoint(-28.0f, -10.0f, 65.4f);
        this.Nody3.setTextureSize(64, 32);
        this.Nody3.mirror = true;
        this.setRotation(this.Nody3, 0.0f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase) this, 0, 650)).addBox(0.0f, 0.0f, 0.0f, 55, 25, 35);
        this.Body4.setRotationPoint(-25.0f, -9.0f, 93.0f);
        this.Body4.setTextureSize(64, 32);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 0.0f, 0.0f, 0.0f);
        (this.Body5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -2.0f, 0.0f, 50, 20, 35);
        this.Body5.setRotationPoint(-22.0f, -5.0f, 120.0f);
        this.Body5.setTextureSize(64, 32);
        this.Body5.mirror = true;
        this.setRotation(this.Body5, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 35, 15, 65);
        this.Tail1.setRotationPoint(-14.0f, -4.0f, 140.0f);
        this.Tail1.setTextureSize(64, 32);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 25, 12, 65);
        this.Tail2.setRotationPoint(-9.0f, -3.0f, 195.0f);
        this.Tail2.setTextureSize(64, 32);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.LegLF = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 30, 20, 20);
        this.LegLF.setRotationPoint(23.0f, -4.0f, -19.0f);
        this.LegLF.setTextureSize(64, 32);
        this.LegLF.mirror = true;
        this.setRotation(this.LegLF, 0.0f, 0.0f, 0.2230717f);
        (this.LegLB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 30, 20, 20);
        this.LegLB.setRotationPoint(23.0f, -4.0f, 40.0f);
        this.LegLB.setTextureSize(64, 32);
        this.LegLB.mirror = true;
        this.setRotation(this.LegLB, 0.0f, 0.0f, 0.2230717f);
        (this.LegRF = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 30, 20, 20);
        this.LegRF.setRotationPoint(-47.0f, 0.0f, -19.0f);
        this.LegRF.setTextureSize(64, 32);
        this.LegRF.mirror = true;
        this.setRotation(this.LegRF, 0.0f, 0.0f, -0.2230705f);
        (this.LegRB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 30, 20, 20);
        this.LegRB.setRotationPoint(-47.0f, 0.0f, 40.0f);
        this.LegRB.setTextureSize(64, 32);
        this.LegRB.mirror = true;
        this.setRotation(this.LegRB, 0.0f, 0.0f, -0.2230705f);
        (this.FeetLF = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 20, 12);
        this.FeetLF.setRotationPoint(41.0f, 7.0f, -15.0f);
        this.FeetLF.setTextureSize(64, 32);
        this.FeetLF.mirror = true;
        this.setRotation(this.FeetLF, 0.0f, 0.0f, -0.2230705f);
        (this.FeetLB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 20, 12);
        this.FeetLB.setRotationPoint(41.0f, 7.0f, 44.0f);
        this.FeetLB.setTextureSize(64, 32);
        this.FeetLB.mirror = true;
        this.setRotation(this.FeetLB, 0.0f, 0.0f, -0.2230705f);
        (this.FeetRF = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 20, 12);
        this.FeetRF.setRotationPoint(-47.0f, 1.0f, -15.0f);
        this.FeetRF.setTextureSize(64, 32);
        this.FeetRF.mirror = true;
        this.setRotation(this.FeetRF, 0.0f, 0.0f, 0.2230705f);
        (this.FeetRB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 20, 12);
        this.FeetRB.setRotationPoint(-47.0f, 1.0f, 44.0f);
        this.FeetRB.setTextureSize(64, 32);
        this.FeetRB.mirror = true;
        this.setRotation(this.FeetRB, 0.0f, 0.0f, 0.2230705f);
        (this.S1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 16, 12);
        this.S1.setRotationPoint(-8.0f, -26.0f, -12.0f);
        this.S1.setTextureSize(64, 32);
        this.S1.mirror = true;
        this.setRotation(this.S1, -0.4089647f, 0.0f, 1.1E-6f);
        (this.S3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 16, 12);
        this.S3.setRotationPoint(-8.0f, -26.0f, 8.0f);
        this.S3.setTextureSize(64, 32);
        this.S3.mirror = true;
        this.setRotation(this.S3, -0.4089647f, 0.0f, 1.1E-6f);
        (this.S6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 16, 12);
        this.S6.setRotationPoint(-8.0f, -26.0f, 30.0f);
        this.S6.setTextureSize(64, 32);
        this.S6.mirror = true;
        this.setRotation(this.S6, -0.4089647f, 0.0f, 1.1E-6f);
        (this.S2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 16, 12);
        this.S2.setRotationPoint(10.0f, -26.0f, -12.0f);
        this.S2.setTextureSize(64, 32);
        this.S2.mirror = true;
        this.setRotation(this.S2, -0.4089647f, 0.0f, 1.1E-6f);
        (this.S4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 16, 12);
        this.S4.setRotationPoint(10.0f, -26.0f, 8.0f);
        this.S4.setTextureSize(64, 32);
        this.S4.mirror = true;
        this.setRotation(this.S4, -0.4089647f, 0.0f, 1.1E-6f);
        (this.S5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 16, 12);
        this.S5.setRotationPoint(10.0f, -26.0f, 30.0f);
        this.S5.setTextureSize(64, 32);
        this.S5.mirror = true;
        this.setRotation(this.S5, -0.4089647f, 0.0f, 1.1E-6f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final CragadileInstance e = (CragadileInstance) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.LegLF.rotateAngleX = newangle;
        this.LegRB.rotateAngleX = newangle;
        this.LegRF.rotateAngleX = -newangle;
        this.LegLB.rotateAngleX = -newangle;
        this.FeetLF.rotateAngleX = newangle;
        this.FeetRB.rotateAngleX = newangle;
        this.FeetRF.rotateAngleX = -newangle;
        this.FeetLB.rotateAngleX = -newangle;
        newangle = MathHelper.cos(f2 * 0.1f * 1.75f) * 3.141593f * 0.2f;
        this.TailEvent(newangle);
        this.Body.render(f5);
        this.Neck.render(f5);
        this.NeckTip.render(f5);
        this.Head.render(f5);
        this.NoseTip.render(f5);
        this.FaceL.render(f5);
        this.FaceR.render(f5);
        this.Shape1.render(f5);
        this.Mouth.render(f5);
        this.EyeL.render(f5);
        this.EyeR.render(f5);
        this.Body2.render(f5);
        this.Nody3.render(f5);
        this.Body4.render(f5);
        this.Body5.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.LegLF.render(f5);
        this.LegLB.render(f5);
        this.LegRF.render(f5);
        this.LegRB.render(f5);
        this.FeetLF.render(f5);
        this.FeetLB.render(f5);
        this.FeetRF.render(f5);
        this.FeetRB.render(f5);
        this.S1.render(f5);
        this.S3.render(f5);
        this.S6.render(f5);
        this.S2.render(f5);
        this.S4.render(f5);
        this.S5.render(f5);
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

    private void TailEvent(final float angle) {
        this.Body2.rotateAngleY = angle * 0.12f;
        this.Nody3.rotateAngleY = angle * 0.25f;
        this.Body4.rotateAngleY = angle * 0.5f;
        this.Body4.rotationPointZ = this.Nody3.rotationPointZ + (float) Math.cos(this.Nody3.rotateAngleY) * 30.0f;
        this.Body4.rotationPointX = this.Nody3.rotationPointX + (float) Math.sin(this.Nody3.rotateAngleY) * 30.0f
            + 2.0f;
        this.Body5.rotateAngleY = angle * 0.5f;
        this.Body5.rotationPointZ = this.Body4.rotationPointZ + (float) Math.cos(this.Body4.rotateAngleY) * 25.0f;
        this.Body5.rotationPointX = this.Body4.rotationPointX + (float) Math.sin(this.Body4.rotateAngleY) * 25.0f;
        this.Tail1.rotateAngleY = angle * 0.75f;
        this.Tail1.rotationPointZ = this.Body5.rotationPointZ + (float) Math.cos(this.Body5.rotateAngleY) * 20.0f;
        this.Tail1.rotationPointX = this.Body5.rotationPointX + (float) Math.sin(this.Body5.rotateAngleY) * 20.0f
            + 4.0f;
        this.Tail2.rotateAngleY = angle * 1.25f;
        this.Tail2.rotationPointZ = this.Tail1.rotationPointZ + (float) Math.cos(this.Tail1.rotateAngleY) * 30.0f;
        this.Tail2.rotationPointX = this.Tail1.rotationPointX + (float) Math.sin(this.Tail1.rotateAngleY) * 30.0f
            + 4.0f;
    }
}
