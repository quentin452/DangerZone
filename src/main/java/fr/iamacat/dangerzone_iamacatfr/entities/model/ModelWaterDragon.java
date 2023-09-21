
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.WaterDragon;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWaterDragon extends ModelBase {

    private float wingspeed;
    ModelRenderer Head;
    ModelRenderer neck1;
    ModelRenderer body1;
    ModelRenderer Leg8;
    ModelRenderer Leg2;
    ModelRenderer Leg7;
    ModelRenderer Leg1;
    ModelRenderer neck2;
    ModelRenderer neck3;
    ModelRenderer neck4;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer tail1;
    ModelRenderer tailmiddle;
    ModelRenderer tailtop;
    ModelRenderer tailbottom;
    ModelRenderer nose;
    ModelRenderer headfin;
    ModelRenderer rightear;
    ModelRenderer leftear;
    ModelRenderer neackfin;
    ModelRenderer Bodyfin;
    ModelRenderer jaw;

    public ModelWaterDragon(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Head = new ModelRenderer((ModelBase) this, 79, 64)).addBox(-4.0f, -4.0f, -8.0f, 7, 8, 8);
        this.Head.setRotationPoint(0.0f, 0.0f, -3.0f);
        this.Head.setTextureSize(128, 128);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase) this, 29, 70)).addBox(-2.0f, 0.0f, -3.0f, 5, 5, 5);
        this.neck1.setRotationPoint(-1.0f, 4.0f, -5.0f);
        this.neck1.setTextureSize(128, 128);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, -0.1858931f, 0.0f, 0.0f);
        (this.body1 = new ModelRenderer((ModelBase) this, 0, 33)).addBox(-5.0f, -4.0f, -6.0f, 9, 9, 9);
        this.body1.setRotationPoint(0.0f, 19.0f, 2.0f);
        this.body1.setTextureSize(128, 128);
        this.body1.mirror = true;
        this.setRotation(this.body1, 0.0f, 0.0f, 0.0f);
        (this.Leg8 = new ModelRenderer((ModelBase) this, 23, 25)).addBox(0.0f, -1.0f, -1.0f, 9, 2, 3);
        this.Leg8.setRotationPoint(3.0f, 22.0f, -2.0f);
        this.Leg8.setTextureSize(128, 128);
        this.Leg8.mirror = true;
        this.setRotation(this.Leg8, 0.0f, 0.5759587f, 0.1919862f);
        (this.Leg2 = new ModelRenderer((ModelBase) this, 80, 18)).addBox(0.0f, -1.0f, -1.0f, 9, 2, 3);
        this.Leg2.setRotationPoint(2.0f, 22.0f, 13.0f);
        this.Leg2.setTextureSize(128, 128);
        this.Leg2.mirror = true;
        this.setRotation(this.Leg2, 0.0f, -0.5759587f, 0.1919862f);
        (this.Leg7 = new ModelRenderer((ModelBase) this, 23, 18)).addBox(-9.0f, -1.0f, -1.0f, 9, 2, 3);
        this.Leg7.setRotationPoint(-4.0f, 22.0f, -1.0f);
        this.Leg7.setTextureSize(128, 128);
        this.Leg7.mirror = true;
        this.setRotation(this.Leg7, 0.0f, -0.5759587f, -0.1919862f);
        (this.Leg1 = new ModelRenderer((ModelBase) this, 80, 25)).addBox(-9.0f, -1.0f, -2.0f, 9, 2, 3);
        this.Leg1.setRotationPoint(-3.0f, 22.0f, 14.0f);
        this.Leg1.setTextureSize(128, 128);
        this.Leg1.mirror = true;
        this.setRotation(this.Leg1, 0.0f, 0.5759587f, -0.1919862f);
        (this.neck2 = new ModelRenderer((ModelBase) this, 0, 11)).addBox(-2.0f, 0.0f, -2.0f, 5, 5, 5);
        this.neck2.setRotationPoint(-1.0f, 9.0f, -7.0f);
        this.neck2.setTextureSize(128, 128);
        this.neck2.mirror = true;
        this.setRotation(this.neck2, 0.1115358f, 0.0f, 0.0f);
        (this.neck3 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(-2.0f, 0.0f, -2.0f, 5, 5, 5);
        this.neck3.setRotationPoint(-1.0f, 14.0f, -6.0f);
        this.neck3.setTextureSize(128, 128);
        this.neck3.mirror = true;
        this.setRotation(this.neck3, 0.4461433f, 0.0f, 0.0f);
        (this.neck4 = new ModelRenderer((ModelBase) this, 26, 12)).addBox(-3.0f, 0.0f, -2.0f, 5, 3, 3);
        this.neck4.setRotationPoint(0.0f, 18.0f, -4.0f);
        this.neck4.setTextureSize(128, 128);
        this.neck4.mirror = true;
        this.setRotation(this.neck4, 1.226894f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 0, 52)).addBox(-5.0f, -5.0f, 0.0f, 7, 7, 9);
        this.body2.setRotationPoint(1.0f, 21.0f, 5.0f);
        this.body2.setTextureSize(128, 128);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.0f, 0.0f, 0.0f);
        (this.body3 = new ModelRenderer((ModelBase) this, 0, 69)).addBox(-3.0f, -3.0f, 0.0f, 5, 5, 7);
        this.body3.setRotationPoint(0.0f, 20.0f, 14.0f);
        this.body3.setTextureSize(128, 128);
        this.body3.mirror = true;
        this.setRotation(this.body3, 0.0f, 0.0f, 0.0f);
        (this.body4 = new ModelRenderer((ModelBase) this, 0, 89)).addBox(-1.0f, -1.0f, 0.0f, 3, 3, 5);
        this.body4.setRotationPoint(-1.0f, 19.0f, 21.0f);
        this.body4.setTextureSize(128, 128);
        this.body4.mirror = true;
        this.setRotation(this.body4, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 0, 82)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 3);
        this.tail1.setRotationPoint(-1.0f, 19.0f, 25.0f);
        this.tail1.setTextureSize(128, 128);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tailmiddle = new ModelRenderer((ModelBase) this, 55, 37)).addBox(-1.0f, -6.0f, 0.0f, 2, 11, 9);
        this.tailmiddle.setRotationPoint(0.0f, 19.0f, 28.0f);
        this.tailmiddle.setTextureSize(128, 128);
        this.tailmiddle.mirror = true;
        this.setRotation(this.tailmiddle, 0.0f, 0.0f, 0.0f);
        (this.tailtop = new ModelRenderer((ModelBase) this, 82, 36)).addBox(-1.0f, -11.0f, 0.0f, 2, 11, 9);
        this.tailtop.setRotationPoint(0.0f, 14.0f, 28.0f);
        this.tailtop.setTextureSize(128, 128);
        this.tailtop.mirror = true;
        this.setRotation(this.tailtop, -0.6320364f, 0.0f, 0.0f);
        (this.tailbottom = new ModelRenderer((ModelBase) this, 56, 60)).addBox(0.0f, 0.0f, 0.0f, 2, 11, 9);
        this.tailbottom.setRotationPoint(-1.0f, 23.0f, 28.0f);
        this.tailbottom.setTextureSize(128, 128);
        this.tailbottom.mirror = true;
        this.setRotation(this.tailbottom, 0.6320361f, 0.0f, -0.0174533f);
        (this.nose = new ModelRenderer((ModelBase) this, 54, 19)).addBox(-3.0f, -2.0f, -5.0f, 5, 5, 5);
        this.nose.setRotationPoint(0.0f, -2.0f, -11.0f);
        this.nose.setTextureSize(128, 128);
        this.nose.mirror = true;
        this.setRotation(this.nose, 0.0f, 0.0f, 0.0f);
        (this.headfin = new ModelRenderer((ModelBase) this, 0, 99)).addBox(0.0f, -5.0f, 0.0f, 0, 10, 9);
        this.headfin.setRotationPoint(0.0f, -4.0f, -6.0f);
        this.headfin.setTextureSize(128, 128);
        this.headfin.mirror = true;
        this.setRotation(this.headfin, 0.1396263f, 0.0f, 0.0f);
        (this.rightear = new ModelRenderer((ModelBase) this, 38, 32)).addBox(0.0f, 0.0f, 0.0f, 0, 5, 5);
        this.rightear.setRotationPoint(-4.0f, -2.0f, -5.0f);
        this.rightear.setTextureSize(128, 128);
        this.rightear.mirror = true;
        this.setRotation(this.rightear, 0.0698132f, -0.418879f, 0.0f);
        (this.leftear = new ModelRenderer((ModelBase) this, 38, 32)).addBox(0.0f, 0.0f, 0.0f, 0, 5, 5);
        this.leftear.setRotationPoint(3.0f, -2.0f, -5.0f);
        this.leftear.setTextureSize(128, 128);
        this.leftear.mirror = true;
        this.setRotation(this.leftear, 0.0698132f, 0.418879f, 0.0f);
        (this.neackfin = new ModelRenderer((ModelBase) this, 42, 47)).addBox(0.0f, -1.0f, 0.0f, 0, 5, 5);
        this.neackfin.setRotationPoint(0.0f, 3.0f, -3.0f);
        this.neackfin.setTextureSize(128, 128);
        this.neackfin.mirror = true;
        this.setRotation(this.neackfin, -0.185895f, 0.0f, 0.0f);
        (this.Bodyfin = new ModelRenderer((ModelBase) this, 21, 91)).addBox(0.0f, -6.0f, -3.0f, 0, 10, 9);
        this.Bodyfin.setRotationPoint(0.0f, 15.0f, 2.0f);
        this.Bodyfin.setTextureSize(128, 128);
        this.Bodyfin.mirror = true;
        this.setRotation(this.Bodyfin, -0.0698132f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 76, 8)).addBox(-2.0f, 0.0f, -5.0f, 5, 1, 5);
        this.jaw.setRotationPoint(-1.0f, 3.0f, -10.0f);
        this.jaw.setTextureSize(128, 128);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final WaterDragon e = (WaterDragon) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float pi4 = 0.7853982f;
        final float root13 = (float) Math.sqrt(13.0);
        final float root14 = (float) Math.sqrt(20.0);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.2f * f1;
        } else {
            newangle = 0.0f;
        }
        this.body3.rotateAngleY = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.4f * f1;
        this.body4.rotationPointZ = this.body3.rotationPointZ + (float) Math.cos(this.body3.rotateAngleY) * 7.0f;
        this.body4.rotationPointX = this.body3.rotationPointX - 1.0f + (float) Math.sin(this.body3.rotateAngleY) * 7.0f;
        this.body4.rotateAngleY = MathHelper.cos(f2 * 1.3f * this.wingspeed - pi4) * 3.1415927f * 0.4f * f1;
        this.tail1.rotationPointZ = this.body4.rotationPointZ + (float) Math.cos(this.body4.rotateAngleY) * 5.0f;
        this.tail1.rotationPointX = this.body4.rotationPointX + (float) Math.sin(this.body4.rotateAngleY) * 5.0f;
        this.tail1.rotateAngleY = MathHelper.cos(f2 * 1.3f * this.wingspeed - 2.0f * pi4) * 3.1415927f * 0.4f * f1;
        this.tailmiddle.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 3.0f;
        this.tailmiddle.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 3.0f;
        this.tailmiddle.rotateAngleY = MathHelper.cos(f2 * 1.3f * this.wingspeed - 3.0f * pi4) * 3.1415927f * 0.4f * f1;
        this.tailtop.rotateAngleY = this.tailmiddle.rotateAngleY;
        this.tailtop.rotationPointZ = this.tailmiddle.rotationPointZ;
        this.tailtop.rotationPointX = this.tailmiddle.rotationPointX;
        this.tailbottom.rotateAngleY = this.tailmiddle.rotateAngleY;
        this.tailbottom.rotationPointZ = this.tailmiddle.rotationPointZ;
        this.tailbottom.rotationPointX = this.tailmiddle.rotationPointX;
        this.Leg8.rotateAngleY = 0.58f + newangle;
        this.Leg2.rotateAngleY = -0.58f + newangle;
        this.Leg7.rotateAngleY = -0.58f - newangle;
        this.Leg1.rotateAngleY = 0.58f - newangle;
        newangle = MathHelper.cos(f2 * 0.8f * this.wingspeed) * 3.1415927f * 0.1f;
        this.leftear.rotateAngleY = 0.62f + newangle;
        this.rightear.rotateAngleY = -0.62f - newangle;
        newangle = MathHelper.cos(f2 * 0.7f * this.wingspeed) * 3.1415927f * 0.02f;
        if (e.isSitting()) {
            newangle = 0.0f;
        }
        this.Bodyfin.rotateAngleZ = newangle;
        newangle = MathHelper.cos(f2 * 0.6f * this.wingspeed) * 3.1415927f * 0.1f;
        if (e.isSitting()) {
            newangle = 0.0f;
        }
        this.neackfin.rotateAngleY = newangle;
        newangle = MathHelper.cos(f2 * 0.5f * this.wingspeed) * 3.1415927f * 0.05f;
        if (e.isSitting()) {
            newangle = 0.0f;
        }
        this.headfin.rotateAngleY = newangle;
        if (e.getAttacking() == 1) {
            newangle = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.25f;
            this.jaw.rotateAngleX = newangle;
        } else if (e.getAttacking() == 2) {
            this.jaw.rotateAngleX = 0.45f;
        } else {
            this.jaw.rotateAngleX = -0.25f;
        }
        newangle = (float) Math.toRadians(f3) * 0.75f;
        this.Head.rotateAngleY = newangle;
        this.nose.rotateAngleY = newangle;
        this.nose.rotationPointZ = this.Head.rotationPointZ - (float) Math.cos(this.Head.rotateAngleY) * 8.0f;
        this.nose.rotationPointX = this.Head.rotationPointX - (float) Math.sin(this.Head.rotateAngleY) * 8.0f;
        this.jaw.rotateAngleY = newangle;
        this.jaw.rotationPointZ = this.Head.rotationPointZ - (float) Math.cos(this.Head.rotateAngleY) * 7.0f;
        this.jaw.rotationPointX = this.Head.rotationPointX - (float) Math.sin(this.Head.rotateAngleY) * 7.0f - 1.0f;
        this.headfin.rotateAngleY = newangle;
        this.headfin.rotationPointZ = this.Head.rotationPointZ - (float) Math.cos(this.Head.rotateAngleY) * 3.0f;
        this.headfin.rotationPointX = this.Head.rotationPointX - (float) Math.sin(this.Head.rotateAngleY) * 3.0f;
        final ModelRenderer leftear = this.leftear;
        leftear.rotateAngleY += newangle;
        this.leftear.rotationPointZ = this.Head.rotationPointZ
            - (float) Math.cos(this.Head.rotateAngleY - pi4) * root13;
        this.leftear.rotationPointX = this.Head.rotationPointX
            - (float) Math.sin(this.Head.rotateAngleY - pi4) * root13;
        final ModelRenderer rightear = this.rightear;
        rightear.rotateAngleY += newangle;
        this.rightear.rotationPointZ = this.Head.rotationPointZ
            - (float) Math.cos(this.Head.rotateAngleY + pi4) * root14;
        this.rightear.rotationPointX = this.Head.rotationPointX
            - (float) Math.sin(this.Head.rotateAngleY + pi4) * root14;
        this.Head.render(f5);
        this.neck1.render(f5);
        this.body1.render(f5);
        this.Leg8.render(f5);
        this.Leg2.render(f5);
        this.Leg7.render(f5);
        this.Leg1.render(f5);
        this.neck2.render(f5);
        this.neck3.render(f5);
        this.neck4.render(f5);
        this.body2.render(f5);
        this.body3.render(f5);
        this.body4.render(f5);
        this.tail1.render(f5);
        this.tailmiddle.render(f5);
        this.tailtop.render(f5);
        this.tailbottom.render(f5);
        this.nose.render(f5);
        this.headfin.render(f5);
        this.rightear.render(f5);
        this.leftear.render(f5);
        this.neackfin.render(f5);
        this.Bodyfin.render(f5);
        this.jaw.render(f5);
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
