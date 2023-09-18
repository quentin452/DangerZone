
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyMoose;

public class Moose extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer FLegC;
    ModelRenderer BLegC;
    ModelRenderer BLegL1;
    ModelRenderer BLegR1;
    ModelRenderer BLegL2;
    ModelRenderer BLegR2;
    ModelRenderer LLegF;
    ModelRenderer RLegF;
    ModelRenderer Head2;
    ModelRenderer Head3;
    ModelRenderer Nose;
    ModelRenderer Head1;
    ModelRenderer Neck;
    ModelRenderer Tail;
    ModelRenderer HornL1;
    ModelRenderer HornR1;
    ModelRenderer HornR3;
    ModelRenderer HornL5;
    ModelRenderer HornR4;
    ModelRenderer HornR5;
    ModelRenderer HornR2;
    ModelRenderer HornL2;
    ModelRenderer HornL4;
    ModelRenderer HornL3;
    ModelRenderer Eyes;

    public Moose() {
        this.wingspeed = 0.2f;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.Body = new ModelRenderer((ModelBase) this, 100, 0)).addBox(-4.0f, 3.0f, -11.0f, 12, 10, 20);
        this.Body.setRotationPoint(-2.0f, -4.0f, 1.0f);
        this.Body.setTextureSize(512, 512);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.1487144f, 0.0f, 0.0f);
        (this.FLegC = new ModelRenderer((ModelBase) this, 100, 60)).addBox(-8.0f, 6.0f, -8.0f, 16, 5, 5);
        this.FLegC.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.FLegC.setTextureSize(512, 512);
        this.FLegC.mirror = true;
        this.setRotation(this.FLegC, 0.0f, 0.0f, 0.0f);
        (this.BLegC = new ModelRenderer((ModelBase) this, 100, 40)).addBox(-8.0f, 3.0f, 3.0f, 16, 5, 5);
        this.BLegC.setRotationPoint(0.0f, -1.0f, 3.0f);
        this.BLegC.setTextureSize(512, 512);
        this.BLegC.mirror = true;
        this.setRotation(this.BLegC, 0.0f, 0.0f, 0.0f);
        (this.BLegL1 = new ModelRenderer((ModelBase) this, 100, 80)).addBox(0.0f, 0.0f, 0.0f, 3, 7, 4);
        this.BLegL1.setRotationPoint(5.0f, 7.0f, 6.0f);
        this.BLegL1.setTextureSize(512, 512);
        this.BLegL1.mirror = true;
        this.setRotation(this.BLegL1, 0.1115358f, 0.0f, 0.0f);
        (this.BLegR1 = new ModelRenderer((ModelBase) this, 100, 80)).addBox(0.0f, 0.0f, 0.0f, 3, 7, 4);
        this.BLegR1.setRotationPoint(-8.0f, 7.0f, 6.0f);
        this.BLegR1.setTextureSize(512, 512);
        this.BLegR1.mirror = true;
        this.setRotation(this.BLegR1, 0.1487144f, 0.0f, 0.0f);
        (this.BLegL2 = new ModelRenderer((ModelBase) this, 100, 100)).addBox(0.0f, 0.0f, 0.0f, 3, 10, 4);
        this.BLegL2.setRotationPoint(5.0f, 14.0f, 8.0f);
        this.BLegL2.setTextureSize(512, 512);
        this.BLegL2.mirror = true;
        this.setRotation(this.BLegL2, 0.1115358f, 0.0f, 0.0f);
        (this.BLegR2 = new ModelRenderer((ModelBase) this, 100, 100)).addBox(0.0f, 0.0f, 0.0f, 3, 10, 4);
        this.BLegR2.setRotationPoint(-8.0f, 14.0f, 8.0f);
        this.BLegR2.setTextureSize(512, 512);
        this.BLegR2.mirror = true;
        this.setRotation(this.BLegR2, 0.1115358f, 0.0f, 0.0f);
        (this.LLegF = new ModelRenderer((ModelBase) this, 100, 120)).addBox(0.0f, 0.0f, 0.0f, 3, 16, 4);
        this.LLegF.setRotationPoint(5.0f, 9.0f, -7.0f);
        this.LLegF.setTextureSize(512, 512);
        this.LLegF.mirror = true;
        this.setRotation(this.LLegF, -0.0743572f, 0.0f, 0.0f);
        (this.RLegF = new ModelRenderer((ModelBase) this, 100, 120)).addBox(0.0f, 0.0f, 0.0f, 3, 16, 4);
        this.RLegF.setRotationPoint(-8.0f, 9.0f, -7.0f);
        this.RLegF.setTextureSize(512, 512);
        this.RLegF.mirror = true;
        this.setRotation(this.RLegF, -0.0743572f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase) this, 0, 80)).addBox(0.5f, 0.0f, 0.0f, 7, 7, 4);
        this.Head2.setRotationPoint(-4.0f, 1.0f, -18.0f);
        this.Head2.setTextureSize(512, 512);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.1115358f, 0.0f, 0.0f);
        (this.Head3 = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 4);
        this.Head3.setRotationPoint(-3.0f, 2.0f, -22.0f);
        this.Head3.setTextureSize(512, 512);
        this.Head3.mirror = true;
        this.setRotation(this.Head3, 0.1115358f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase) this, 0, 120)).addBox(0.0f, 0.0f, 0.0f, 4, 3, 4);
        this.Nose.setRotationPoint(-2.0f, 4.0f, -23.0f);
        this.Nose.setTextureSize(512, 512);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.1115358f, 0.0f, 0.0f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 0, 60)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 5);
        this.Head1.setRotationPoint(-4.0f, 0.0f, -16.0f);
        this.Head1.setTextureSize(512, 512);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.1115358f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 0, 40)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 10);
        this.Neck.setRotationPoint(-2.0f, 0.0f, -15.0f);
        this.Neck.setTextureSize(512, 512);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, -0.3717861f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase) this, 50, 0)).addBox(-0.5f, 0.0f, 0.0f, 3, 3, 3);
        this.Tail.setRotationPoint(-1.0f, 1.0f, 10.0f);
        this.Tail.setTextureSize(512, 512);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0f, 0.0f, 0.0f);
        (this.HornL1 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornL1.setRotationPoint(10.0f, -1.0f, -13.0f);
        this.HornL1.setTextureSize(512, 512);
        this.HornL1.mirror = true;
        this.setRotation(this.HornL1, 0.0f, 0.0f, 1.151917f);
        (this.HornR1 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornR1.setRotationPoint(-11.0f, -1.0f, -13.0f);
        this.HornR1.setTextureSize(512, 512);
        this.HornR1.mirror = true;
        this.setRotation(this.HornR1, 0.0f, 0.0f, -1.151917f);
        (this.HornR3 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornR3.setRotationPoint(-10.0f, -2.0f, -13.0f);
        this.HornR3.setTextureSize(512, 512);
        this.HornR3.mirror = true;
        this.setRotation(this.HornR3, -0.8551081f, 0.0f, 1.933288f);
        (this.HornL5 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornL5.setRotationPoint(10.0f, -1.0f, -12.0f);
        this.HornL5.setTextureSize(512, 512);
        this.HornL5.mirror = true;
        this.setRotation(this.HornL5, -2.565324f, 0.0f, 1.821752f);
        (this.HornR4 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornR4.setRotationPoint(-10.0f, -1.0f, -13.0f);
        this.HornR4.setTextureSize(512, 512);
        this.HornR4.mirror = true;
        this.setRotation(this.HornR4, -1.375609f, 0.0f, 1.933288f);
        (this.HornR5 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornR5.setRotationPoint(-7.0f, 0.0f, -13.0f);
        this.HornR5.setTextureSize(512, 512);
        this.HornR5.mirror = true;
        this.setRotation(this.HornR5, -1.673038f, 0.0f, 1.301251f);
        (this.HornR2 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornR2.setRotationPoint(-9.0f, -1.0f, -13.0f);
        this.HornR2.setTextureSize(512, 512);
        this.HornR2.mirror = true;
        this.setRotation(this.HornR2, 0.2602503f, -0.0743572f, 1.933288f);
        (this.HornL2 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornL2.setRotationPoint(11.0f, -1.0f, -12.0f);
        this.HornL2.setTextureSize(512, 512);
        this.HornL2.mirror = true;
        this.setRotation(this.HornL2, 2.881342f, -0.0371786f, 1.449966f);
        (this.HornL4 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornL4.setRotationPoint(9.0f, 0.0f, -13.0f);
        this.HornL4.setTextureSize(512, 512);
        this.HornL4.mirror = true;
        this.setRotation(this.HornL4, -1.970466f, 0.0f, 1.933288f);
        (this.HornL3 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 1, 8, 1);
        this.HornL3.setRotationPoint(7.0f, 1.0f, -13.0f);
        this.HornL3.setTextureSize(512, 512);
        this.HornL3.mirror = true;
        this.setRotation(this.HornL3, -1.673038f, 0.0f, 1.933288f);
        (this.Eyes = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 2);
        this.Eyes.setRotationPoint(-4.0f, 3.0f, -18.0f);
        this.Eyes.setTextureSize(512, 512);
        this.Eyes.mirror = true;
        this.setRotation(this.Eyes, 0.3717861f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final MyMoose e = (MyMoose) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.LLegF.rotateAngleX = newangle;
        this.BLegR2.rotateAngleX = newangle;
        this.BLegR1.rotateAngleX = newangle;
        this.RLegF.rotateAngleX = -newangle;
        this.BLegL2.rotateAngleX = -newangle;
        this.BLegL1.rotateAngleX = -newangle;
        this.Body.render(f5);
        this.FLegC.render(f5);
        this.BLegC.render(f5);
        this.BLegL1.render(f5);
        this.BLegR1.render(f5);
        this.BLegL2.render(f5);
        this.BLegR2.render(f5);
        this.LLegF.render(f5);
        this.RLegF.render(f5);
        this.Head2.render(f5);
        this.Head3.render(f5);
        this.Nose.render(f5);
        this.Head1.render(f5);
        this.Neck.render(f5);
        this.Tail.render(f5);
        this.HornL1.render(f5);
        this.HornR1.render(f5);
        this.HornR3.render(f5);
        this.HornL5.render(f5);
        this.HornR4.render(f5);
        this.HornR5.render(f5);
        this.HornR2.render(f5);
        this.HornL2.render(f5);
        this.HornL4.render(f5);
        this.HornL3.render(f5);
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
