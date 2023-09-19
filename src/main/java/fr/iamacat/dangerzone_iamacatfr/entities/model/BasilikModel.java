
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class BasilikModel extends ModelBase {

    ModelRenderer bodyTorso;
    ModelRenderer bodyTop;
    ModelRenderer bodyBottom;
    ModelRenderer tailTop;
    ModelRenderer bellyTop;
    ModelRenderer bellyBottom;
    ModelRenderer backOne;
    ModelRenderer backTwo;
    ModelRenderer head;
    ModelRenderer neck;
    ModelRenderer jaw;
    ModelRenderer topFangRight;
    ModelRenderer topFangLeft;
    ModelRenderer bottomFangLeft;
    ModelRenderer bottomFangRight;
    ModelRenderer tailOne;
    ModelRenderer tailTwo;
    ModelRenderer tailThree;
    ModelRenderer tailFour;
    ModelRenderer tailEndOne;
    ModelRenderer tailEndTwo;
    ModelRenderer tailEndThree;
    ModelRenderer tailEndFour;
    ModelRenderer tailEndFive;
    ModelRenderer alphaHood;
    ModelRenderer hoodTop;
    ModelRenderer hoodLower;

    public BasilikModel(float v) {
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.bodyTorso = new ModelRenderer((ModelBase) this, 0, 47)).addBox(-6.0f, 0.0f, -4.0f, 12, 13, 4);
        this.bodyTorso.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bodyTorso.setTextureSize(128, 64);
        this.bodyTorso.mirror = true;
        this.setRotation(this.bodyTorso, 0.0f, 0.0f, 0.0f);
        (this.bodyTop = new ModelRenderer((ModelBase) this, 32, 52)).addBox(-5.0f, -6.0f, -6.0f, 10, 6, 6);
        this.bodyTop.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bodyTop.setTextureSize(128, 64);
        this.bodyTop.mirror = true;
        this.setRotation(this.bodyTop, 0.7853982f, 0.0f, 0.0f);
        (this.bodyBottom = new ModelRenderer((ModelBase) this, 64, 48)).addBox(-5.0f, 10.0f, -10.0f, 10, 12, 4);
        this.bodyBottom.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bodyBottom.setTextureSize(128, 64);
        this.bodyBottom.mirror = true;
        this.setRotation(this.bodyBottom, 0.5235988f, 0.0f, 0.0f);
        (this.tailTop = new ModelRenderer((ModelBase) this, 64, 48)).addBox(-5.0f, 14.0f, -20.0f, 10, 12, 4);
        this.tailTop.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.tailTop.setTextureSize(128, 64);
        this.tailTop.mirror = true;
        this.setRotation(this.tailTop, 1.047198f, 0.0f, 0.0f);
        (this.bellyTop = new ModelRenderer((ModelBase) this, 92, 48)).addBox(-3.0f, 3.0f, -6.0f, 6, 12, 4);
        this.bellyTop.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bellyTop.setTextureSize(128, 64);
        this.bellyTop.mirror = true;
        this.setRotation(this.bellyTop, 0.0f, 0.0f, 0.0f);
        (this.bellyBottom = new ModelRenderer((ModelBase) this, 60, 0)).addBox(-3.0f, 12.0f, -11.0f, 6, 9, 5);
        this.bellyBottom.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.bellyBottom.setTextureSize(128, 64);
        this.bellyBottom.mirror = true;
        this.setRotation(this.bellyBottom, 0.4014257f, 0.0f, 0.0f);
        (this.backOne = new ModelRenderer((ModelBase) this, 110, 0)).addBox(-3.0f, 8.0f, -8.0f, 6, 20, 3);
        this.backOne.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.backOne.setTextureSize(128, 64);
        this.backOne.mirror = true;
        this.setRotation(this.backOne, 0.6108652f, 0.0f, 0.0f);
        (this.backTwo = new ModelRenderer((ModelBase) this, 110, 0)).addBox(-3.0f, 0.0f, 0.0f, 6, 30, 3);
        this.backTwo.setRotationPoint(0.0f, 19.0f, 10.0f);
        this.backTwo.setTextureSize(128, 64);
        this.backTwo.mirror = true;
        this.setRotation(this.backTwo, 1.48353f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 31)).addBox(-4.0f, -10.0f, -4.0f, 8, 10, 6);
        this.head.setRotationPoint(0.0f, -10.0f, -8.0f);
        this.head.setTextureSize(128, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 1.745329f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase) this, 28, 43)).addBox(-5.0f, -4.0f, -8.0f, 10, 4, 4);
        this.neck.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.neck.setTextureSize(128, 64);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 28, 32)).addBox(-3.0f, 4.0f, -9.0f, 6, 2, 9);
        this.jaw.setRotationPoint(0.0f, -10.0f, -8.0f);
        this.jaw.setTextureSize(128, 64);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.2094395f, 0.0f, 0.0f);
        (this.topFangRight = new ModelRenderer((ModelBase) this, 0, 31)).addBox(-3.8f, 5.0f, -9.0f, 1, 2, 2);
        this.topFangRight.setRotationPoint(0.0f, -10.0f, -8.0f);
        this.topFangRight.setTextureSize(128, 64);
        this.topFangRight.mirror = true;
        this.setRotation(this.topFangRight, 0.0f, 0.0f, 0.0f);
        (this.topFangLeft = new ModelRenderer((ModelBase) this, 0, 31)).addBox(2.8f, 5.0f, -9.0f, 1, 2, 2);
        this.topFangLeft.setRotationPoint(0.0f, -10.0f, -8.0f);
        this.topFangLeft.setTextureSize(128, 64);
        this.topFangLeft.mirror = true;
        this.setRotation(this.topFangLeft, 0.0f, 0.0f, 0.0f);
        (this.bottomFangLeft = new ModelRenderer((ModelBase) this, 22, 31)).addBox(2.8f, 6.0f, -9.0f, 1, 3, 1);
        this.bottomFangLeft.setRotationPoint(0.0f, -10.0f, -8.0f);
        this.bottomFangLeft.setTextureSize(128, 64);
        this.bottomFangLeft.mirror = true;
        this.setRotation(this.bottomFangLeft, 0.0872665f, 0.0f, 0.0f);
        (this.bottomFangRight = new ModelRenderer((ModelBase) this, 22, 31)).addBox(-3.8f, 7.0f, -9.0f, 1, 3, 1);
        this.bottomFangRight.setRotationPoint(0.0f, -11.0f, -8.0f);
        this.bottomFangRight.setTextureSize(128, 64);
        this.bottomFangRight.mirror = true;
        this.setRotation(this.bottomFangRight, 0.0872665f, 0.0f, 0.0f);
        (this.tailOne = new ModelRenderer((ModelBase) this, 58, 32)).addBox(-5.0f, 0.0f, 0.0f, 10, 4, 11);
        this.tailOne.setRotationPoint(0.0f, 19.0f, 13.0f);
        this.tailOne.setTextureSize(128, 64);
        this.tailOne.mirror = true;
        this.setRotation(this.tailOne, -0.0872665f, 0.0f, 0.0f);
        (this.tailTwo = new ModelRenderer((ModelBase) this, 58, 32)).addBox(-5.0f, 1.0f, 10.0f, 10, 4, 11);
        this.tailTwo.setRotationPoint(0.0f, 19.0f, 13.0f);
        this.tailTwo.setTextureSize(128, 64);
        this.tailTwo.mirror = true;
        this.setRotation(this.tailTwo, 0.0f, -0.0174533f, 0.0f);
        (this.tailThree = new ModelRenderer((ModelBase) this, 58, 32)).addBox(-5.0f, 1.0f, 21.0f, 10, 4, 11);
        this.tailThree.setRotationPoint(0.0f, 19.0f, 13.0f);
        this.tailThree.setTextureSize(128, 64);
        this.tailThree.mirror = true;
        this.setRotation(this.tailThree, 0.0f, 0.0f, 0.0f);
        (this.tailFour = new ModelRenderer((ModelBase) this, 58, 32)).addBox(-5.0f, 1.0f, 32.0f, 10, 4, 11);
        this.tailFour.setRotationPoint(0.0f, 19.0f, 13.0f);
        this.tailFour.setTextureSize(128, 64);
        this.tailFour.mirror = true;
        this.setRotation(this.tailFour, 0.0f, 0.0174533f, 0.0f);
        (this.tailEndOne = new ModelRenderer((ModelBase) this, 74, 17)).addBox(-4.0f, 0.0f, 0.0f, 8, 4, 10);
        this.tailEndOne.setRotationPoint(0.0f, 20.0f, 56.0f);
        this.tailEndOne.setTextureSize(128, 64);
        this.tailEndOne.mirror = true;
        this.setRotation(this.tailEndOne, 0.0f, 0.0523599f, 0.0f);
        (this.tailEndTwo = new ModelRenderer((ModelBase) this, 74, 17)).addBox(-4.0f, 0.0f, 10.0f, 8, 4, 10);
        this.tailEndTwo.setRotationPoint(0.0f, 20.0f, 56.0f);
        this.tailEndTwo.setTextureSize(128, 64);
        this.tailEndTwo.mirror = true;
        this.setRotation(this.tailEndTwo, 0.0f, -0.0174533f, 0.0f);
        (this.tailEndThree = new ModelRenderer((ModelBase) this, 100, 35)).addBox(-3.0f, 0.0f, 0.0f, 6, 4, 8);
        this.tailEndThree.setRotationPoint(0.0f, 20.0f, 76.0f);
        this.tailEndThree.setTextureSize(128, 64);
        this.tailEndThree.mirror = true;
        this.setRotation(this.tailEndThree, 0.0f, 0.0f, 0.0f);
        (this.tailEndFour = new ModelRenderer((ModelBase) this, 100, 35)).addBox(-3.0f, 0.0f, 8.0f, 6, 4, 8);
        this.tailEndFour.setRotationPoint(0.0f, 20.0f, 76.0f);
        this.tailEndFour.setTextureSize(128, 64);
        this.tailEndFour.mirror = true;
        this.setRotation(this.tailEndFour, 0.0f, -0.0174533f, 0.0f);
        (this.tailEndFive = new ModelRenderer((ModelBase) this, 82, 0)).addBox(-2.0f, 0.0f, 0.0f, 4, 4, 10);
        this.tailEndFive.setRotationPoint(0.0f, 20.0f, 92.0f);
        this.tailEndFive.setTextureSize(128, 64);
        this.tailEndFive.mirror = true;
        this.setRotation(this.tailEndFive, 0.0f, 0.0f, 0.0f);
        (this.alphaHood = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-13.0f, 3.0f, -2.0f, 26, 6, 3);
        this.alphaHood.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.alphaHood.setTextureSize(128, 64);
        this.alphaHood.mirror = true;
        this.setRotation(this.alphaHood, 0.0f, 0.0f, 0.0f);
        (this.hoodTop = new ModelRenderer((ModelBase) this, 0, 9)).addBox(-10.0f, -3.0f, -3.0f, 20, 6, 3);
        this.hoodTop.setRotationPoint(0.0f, -7.0f, 0.0f);
        this.hoodTop.setTextureSize(128, 64);
        this.hoodTop.mirror = true;
        this.setRotation(this.hoodTop, 0.3316126f, 0.0f, 0.0f);
        (this.hoodLower = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-10.0f, 9.0f, 0.0f, 20, 6, 3);
        this.hoodLower.setRotationPoint(0.0f, -7.0f, -2.0f);
        this.hoodLower.setTextureSize(128, 64);
        this.hoodLower.mirror = true;
        this.setRotation(this.hoodLower, -0.0349066f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.bodyTorso.render(f5);
        this.bodyTop.render(f5);
        this.bodyBottom.render(f5);
        this.tailTop.render(f5);
        this.bellyTop.render(f5);
        this.bellyBottom.render(f5);
        this.backOne.render(f5);
        this.backTwo.render(f5);
        this.head.render(f5);
        this.neck.render(f5);
        this.jaw.render(f5);
        this.topFangRight.render(f5);
        this.topFangLeft.render(f5);
        this.bottomFangLeft.render(f5);
        this.bottomFangRight.render(f5);
        this.tailOne.render(f5);
        this.tailTwo.render(f5);
        this.tailThree.render(f5);
        this.tailFour.render(f5);
        this.tailEndOne.render(f5);
        this.tailEndTwo.render(f5);
        this.tailEndThree.render(f5);
        this.tailEndFour.render(f5);
        this.tailEndFive.render(f5);
        this.alphaHood.render(f5);
        this.hoodTop.render(f5);
        this.hoodLower.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4,
        final float f5, final Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
}
