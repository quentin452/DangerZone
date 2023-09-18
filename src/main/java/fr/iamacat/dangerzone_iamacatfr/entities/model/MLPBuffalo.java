
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyMLPBuffalo;

public class MLPBuffalo extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer LegRB;
    ModelRenderer LegL;
    ModelRenderer LegLB;
    ModelRenderer LegR;
    ModelRenderer Head;
    ModelRenderer HornL;
    ModelRenderer HornR;
    ModelRenderer Tail;

    public MLPBuffalo() {
        this.wingspeed = 0.8f;
        this.textureWidth = 1024;
        this.textureHeight = 1024;
        (this.Body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-22.0f, -29.0f, -23.0f, 45, 45, 50);
        this.Body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Body.setTextureSize(1024, 1024);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LegRB = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.LegRB.setRotationPoint(-21.0f, 16.0f, 20.0f);
        this.LegRB.setTextureSize(1024, 1024);
        this.LegRB.mirror = true;
        this.setRotation(this.LegRB, 0.0f, 0.0f, 0.0f);
        (this.LegL = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.LegL.setRotationPoint(16.0f, 16.0f, -21.0f);
        this.LegL.setTextureSize(1024, 1024);
        this.LegL.mirror = true;
        this.setRotation(this.LegL, 0.0f, 0.0f, 0.0f);
        (this.LegLB = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.LegLB.setRotationPoint(16.0f, 16.0f, 20.0f);
        this.LegLB.setTextureSize(1024, 1024);
        this.LegLB.mirror = true;
        this.setRotation(this.LegLB, 0.0f, 0.0f, 0.0f);
        (this.LegR = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.LegR.setRotationPoint(-21.0f, 16.0f, -22.0f);
        this.LegR.setTextureSize(1024, 1024);
        this.LegR.mirror = true;
        this.setRotation(this.LegR, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 0.0f, -2.0f, 12, 12, 12);
        this.Head.setRotationPoint(-5.0f, -5.0f, -33.0f);
        this.Head.setTextureSize(1024, 1024);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.HornL = new ModelRenderer((ModelBase) this, 0, 140)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.HornL.setRotationPoint(5.0f, -3.0f, -41.0f);
        this.HornL.setTextureSize(1024, 1024);
        this.HornL.mirror = true;
        this.setRotation(this.HornL, 0.0f, 0.0f, 0.0f);
        (this.HornR = new ModelRenderer((ModelBase) this, 0, 140)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.HornR.setRotationPoint(-4.0f, -3.0f, -41.0f);
        this.HornR.setTextureSize(1024, 1024);
        this.HornR.mirror = true;
        this.setRotation(this.HornR, 0.0f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase) this, 500, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        this.Tail.setRotationPoint(-2.0f, -2.0f, 27.0f);
        this.Tail.setTextureSize(1024, 1024);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final MyMLPBuffalo e = (MyMLPBuffalo) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.LegL.rotateAngleX = newangle;
        this.LegRB.rotateAngleX = newangle;
        this.LegR.rotateAngleX = -newangle;
        this.LegLB.rotateAngleX = -newangle;
        this.Body.render(f5);
        this.LegRB.render(f5);
        this.LegL.render(f5);
        this.LegLB.render(f5);
        this.LegR.render(f5);
        this.Head.render(f5);
        this.HornL.render(f5);
        this.HornR.render(f5);
        this.Tail.render(f5);
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
