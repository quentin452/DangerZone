
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Chipmunk;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityCannonFodder;

public class ModelChipmunk extends ModelBase {

    private float wingspeed;
    ModelRenderer Cheek2;
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Leg3;
    ModelRenderer Leg4;
    ModelRenderer Tail2;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer MouthUnder;
    ModelRenderer Cheek1;
    ModelRenderer Ear2;
    ModelRenderer Nose;
    ModelRenderer Ear1;
    ModelRenderer Body;
    ModelRenderer BodyTail;
    ModelRenderer Tail1;
    ModelRenderer Hat1;
    ModelRenderer Hat2;

    public ModelChipmunk(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Cheek2 = new ModelRenderer((ModelBase) this, 14, 0)).addBox(0.5f, -1.5f, -3.5f, 2, 2, 2);
        this.Cheek2.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Cheek2.setTextureSize(64, 32);
        this.Cheek2.mirror = true;
        this.setRotation(this.Cheek2, 0.0f, 0.0f, 0.0f);
        (this.Leg1 = new ModelRenderer((ModelBase) this, 22, 7)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Leg1.setRotationPoint(-2.0f, 23.0f, -4.0f);
        this.Leg1.setTextureSize(64, 32);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0f, 0.0f, 0.0f);
        (this.Leg2 = new ModelRenderer((ModelBase) this, 22, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Leg2.setRotationPoint(1.0f, 23.0f, -4.0f);
        this.Leg2.setTextureSize(64, 32);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, 0.0f, 0.0f);
        (this.Leg3 = new ModelRenderer((ModelBase) this, 22, 11)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Leg3.setRotationPoint(1.0f, 23.0f, 0.0f);
        this.Leg3.setTextureSize(64, 32);
        this.Leg3.mirror = true;
        this.setRotation(this.Leg3, 0.0f, 0.0f, 0.0f);
        (this.Leg4 = new ModelRenderer((ModelBase) this, 22, 13)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.Leg4.setRotationPoint(-2.0f, 23.0f, 0.0f);
        this.Leg4.setTextureSize(64, 32);
        this.Leg4.mirror = true;
        this.setRotation(this.Leg4, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 28, 15)).addBox(-0.5f, 1.0f, 2.5f, 3, 3, 4);
        this.Tail2.setRotationPoint(-1.0f, 20.0f, 1.0f);
        this.Tail2.setTextureSize(64, 32);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.7662421f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 26, 9)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 4);
        this.Neck.setRotationPoint(-1.5f, 22.0f, -5.0f);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 1.570796f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.0f, -3.0f, 0.0f, 4, 4, 3);
        this.Head.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 1.570796f, 0.0f, 0.0f);
        (this.MouthUnder = new ModelRenderer((ModelBase) this, 20, 4)).addBox(-1.0f, -1.9f, -3.8f, 2, 2, 1);
        this.MouthUnder.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.MouthUnder.setTextureSize(64, 32);
        this.MouthUnder.mirror = true;
        this.setRotation(this.MouthUnder, 0.0f, 0.0f, 0.0f);
        (this.Cheek1 = new ModelRenderer((ModelBase) this, 22, 0)).addBox(-2.5f, -1.5f, -3.5f, 2, 2, 2);
        this.Cheek1.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Cheek1.setTextureSize(64, 32);
        this.Cheek1.mirror = true;
        this.setRotation(this.Cheek1, 0.0f, 0.0f, 0.0f);
        (this.Ear2 = new ModelRenderer((ModelBase) this, 18, 11)).addBox(1.0f, 0.0f, 3.0f, 1, 1, 1);
        this.Ear2.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Ear2.setTextureSize(64, 32);
        this.Ear2.mirror = true;
        this.setRotation(this.Ear2, 1.570796f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase) this, 18, 7)).addBox(-0.5f, -2.0f, -4.2f, 1, 1, 1);
        this.Nose.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Nose.setTextureSize(64, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.0f, 0.0f, 0.0f);
        (this.Ear1 = new ModelRenderer((ModelBase) this, 18, 9)).addBox(-2.0f, 0.0f, 3.0f, 1, 1, 1);
        this.Ear1.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Ear1.setTextureSize(64, 32);
        this.Ear1.mirror = true;
        this.setRotation(this.Ear1, 1.570796f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase) this, 0, 7)).addBox(0.0f, 0.0f, 0.0f, 4, 3, 5);
        this.Body.setRotationPoint(-2.0f, 20.0f, -4.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.BodyTail = new ModelRenderer((ModelBase) this, 0, 15)).addBox(0.0f, 0.0f, 0.0f, 5, 4, 3);
        this.BodyTail.setRotationPoint(-2.5f, 19.0f, -1.0f);
        this.BodyTail.setTextureSize(64, 32);
        this.BodyTail.mirror = true;
        this.setRotation(this.BodyTail, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 16, 15)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.Tail1.setRotationPoint(-1.0f, 20.0f, 1.0f);
        this.Tail1.setTextureSize(64, 32);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.3064968f, 0.0f, 0.0f);
        (this.Hat1 = new ModelRenderer((ModelBase) this, 40, 0)).addBox(-2.5f, -4.0f, -4.0f, 5, 1, 5);
        this.Hat1.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Hat1.setTextureSize(64, 32);
        this.Hat1.mirror = true;
        this.setRotation(this.Hat1, 0.0f, 0.0f, 0.0f);
        (this.Hat2 = new ModelRenderer((ModelBase) this, 40, 0)).addBox(-2.0f, -6.0f, -3.0f, 4, 2, 4);
        this.Hat2.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.Hat2.setTextureSize(64, 32);
        this.Hat2.mirror = true;
        this.setRotation(this.Hat2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Chipmunk c = (Chipmunk) entity;
        final float hf = 0.0f;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 2.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.Leg1.rotateAngleX = newangle;
        this.Leg3.rotateAngleX = newangle;
        this.Leg2.rotateAngleX = -newangle;
        this.Leg4.rotateAngleX = -newangle;
        this.Head.rotateAngleY = (float) Math.toRadians(f3) * 0.45f;
        this.Nose.rotateAngleY = this.Head.rotateAngleY;
        this.Ear1.rotateAngleY = this.Head.rotateAngleY;
        this.Ear2.rotateAngleY = this.Head.rotateAngleY;
        this.MouthUnder.rotateAngleY = this.Head.rotateAngleY;
        this.Cheek1.rotateAngleY = this.Head.rotateAngleY;
        this.Cheek2.rotateAngleY = this.Head.rotateAngleY;
        this.Hat1.rotateAngleY = this.Head.rotateAngleY;
        this.Hat2.rotateAngleY = this.Head.rotateAngleY;
        if (!c.isSitting()) {
            this.Tail1.rotateAngleX = 0.306f + MathHelper.cos(f2 * 0.25f) * 3.1415927f * 0.06f;
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
            final ModelRenderer tail1 = this.Tail1;
            tail1.rotateAngleX += newangle;
            this.Tail2.rotateAngleX = 0.306f + this.Tail1.rotateAngleX;
        }
        this.Cheek2.render(f5);
        this.Leg1.render(f5);
        this.Leg2.render(f5);
        this.Leg3.render(f5);
        this.Leg4.render(f5);
        this.Tail2.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
        this.MouthUnder.render(f5);
        this.Cheek1.render(f5);
        this.Ear2.render(f5);
        this.Nose.render(f5);
        this.Ear1.render(f5);
        this.Body.render(f5);
        this.BodyTail.render(f5);
        this.Tail1.render(f5);
        if (c instanceof EntityCannonFodder && c.get_is_activated() != 0) {
            this.Hat1.render(f5);
            if (c.get_is_activated() > 1) {
                this.Hat2.render(f5);
            }
        }
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
