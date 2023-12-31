
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Dragon;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;

public class ModelDragon extends ModelBase {

    private float wingspeed;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer tail6;
    ModelRenderer wing15;
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer wing14;
    ModelRenderer spike5;
    ModelRenderer spike6;
    ModelRenderer spike7;
    ModelRenderer spike8;
    ModelRenderer spike9;
    ModelRenderer spike10;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer body2;
    ModelRenderer neck1;
    ModelRenderer body3;
    ModelRenderer neck2;
    ModelRenderer neck3;
    ModelRenderer leg5;
    ModelRenderer leg6;
    ModelRenderer leg7;
    ModelRenderer leg9;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer leg10;
    ModelRenderer leg11;
    ModelRenderer foot3;
    ModelRenderer foot4;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer mouth1;
    ModelRenderer mouth2;
    ModelRenderer tail5;
    ModelRenderer wing1;
    ModelRenderer wing2;
    ModelRenderer wing3;
    ModelRenderer wing4;
    ModelRenderer wing5;
    ModelRenderer wing6;
    ModelRenderer wing7;
    ModelRenderer wing8;
    ModelRenderer wing9;
    ModelRenderer wing10;
    ModelRenderer wing11;
    ModelRenderer wing12;
    ModelRenderer tail4;

    public ModelDragon(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.horn1 = new ModelRenderer((ModelBase) this, 0, 39)).addBox(2.0f, -4.0f, 1.0f, 2, 2, 6);
        this.horn1.setRotationPoint(0.0f, 6.0f, -23.0f);
        this.horn1.setTextureSize(256, 128);
        this.horn1.mirror = true;
        this.setRotation(this.horn1, 0.4089647f, 0.2602503f, 0.0f);
        (this.horn2 = new ModelRenderer((ModelBase) this, 0, 39)).addBox(-4.0f, -4.0f, 1.0f, 2, 2, 6);
        this.horn2.setRotationPoint(0.0f, 6.0f, -23.0f);
        this.horn2.setTextureSize(256, 128);
        this.horn2.mirror = true;
        this.setRotation(this.horn2, 0.4089647f, -0.2602503f, 0.0f);
        (this.tail6 = new ModelRenderer((ModelBase) this, 0, 49)).addBox(-1.0f, 0.0f, -2.0f, 2, 6, 4);
        this.tail6.setRotationPoint(0.0f, 7.0f, 43.0f);
        this.tail6.setTextureSize(256, 128);
        this.tail6.mirror = true;
        this.setRotation(this.tail6, 1.570796f, 0.0f, 0.0f);
        (this.wing15 = new ModelRenderer((ModelBase) this, 0, 62)).addBox(1.0f, -1.0f, 1.0f, 12, 1, 8);
        this.wing15.setRotationPoint(4.0f, 3.0f, -5.0f);
        this.wing15.setTextureSize(256, 128);
        this.wing15.mirror = true;
        this.setRotation(this.wing15, -0.0743572f, -0.4089594f, 0.0f);
        (this.spike1 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -3.0f, -5.0f, 2, 2, 4);
        this.spike1.setRotationPoint(0.0f, 6.0f, -17.0f);
        this.spike1.setTextureSize(256, 128);
        this.spike1.mirror = true;
        this.setRotation(this.spike1, 0.0f, 0.0f, 0.0f);
        (this.spike2 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -3.0f, -5.0f, 2, 2, 4);
        this.spike2.setRotationPoint(0.0f, 6.0f, -11.0f);
        this.spike2.setTextureSize(256, 128);
        this.spike2.mirror = true;
        this.setRotation(this.spike2, 0.0f, 0.0f, 0.0f);
        (this.spike3 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -4.0f, 1.0f, 2, 2, 4);
        this.spike3.setRotationPoint(0.0f, 7.0f, 25.0f);
        this.spike3.setTextureSize(256, 128);
        this.spike3.mirror = true;
        this.setRotation(this.spike3, 0.0f, 0.0f, 0.0f);
        (this.spike4 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -2.0f, 0.0f, 2, 2, 4);
        this.spike4.setRotationPoint(0.0f, 3.0f, -7.0f);
        this.spike4.setTextureSize(256, 128);
        this.spike4.mirror = true;
        this.setRotation(this.spike4, 0.0f, 0.0f, 0.0f);
        (this.wing14 = new ModelRenderer((ModelBase) this, 0, 62)).addBox(-13.0f, -1.0f, 0.0f, 12, 1, 8);
        this.wing14.setRotationPoint(-4.0f, 3.0f, -5.0f);
        this.wing14.setTextureSize(256, 128);
        this.wing14.mirror = true;
        this.setRotation(this.wing14, -0.0698132f, 0.4089656f, 0.0f);
        (this.spike5 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -2.0f, 0.0f, 2, 2, 4);
        this.spike5.setRotationPoint(0.0f, 3.0f, -1.0f);
        this.spike5.setTextureSize(256, 128);
        this.spike5.mirror = true;
        this.setRotation(this.spike5, 0.0f, 0.0f, 0.0f);
        (this.spike6 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -2.0f, 0.0f, 2, 2, 4);
        this.spike6.setRotationPoint(0.0f, 3.0f, 5.0f);
        this.spike6.setTextureSize(256, 128);
        this.spike6.mirror = true;
        this.setRotation(this.spike6, 0.0f, 0.0f, 0.0f);
        (this.spike7 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -4.0f, 1.0f, 2, 2, 4);
        this.spike7.setRotationPoint(0.0f, 7.0f, 13.0f);
        this.spike7.setTextureSize(256, 128);
        this.spike7.mirror = true;
        this.setRotation(this.spike7, 0.0f, 0.0f, 0.0f);
        (this.spike8 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -2.0f, 1.0f, 2, 2, 4);
        this.spike8.setRotationPoint(0.0f, 5.0f, 19.0f);
        this.spike8.setTextureSize(256, 128);
        this.spike8.mirror = true;
        this.setRotation(this.spike8, 0.0f, 0.0f, 0.0f);
        (this.spike9 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -4.0f, 1.0f, 2, 2, 4);
        this.spike9.setRotationPoint(0.0f, 7.0f, 31.0f);
        this.spike9.setTextureSize(256, 128);
        this.spike9.mirror = true;
        this.setRotation(this.spike9, 0.0f, 0.0f, 0.0f);
        (this.spike10 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-1.0f, -4.0f, 2.0f, 2, 2, 4);
        this.spike10.setRotationPoint(0.0f, 7.0f, 36.0f);
        this.spike10.setTextureSize(256, 128);
        this.spike10.mirror = true;
        this.setRotation(this.spike10, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 81)).addBox(-4.0f, -4.0f, -8.0f, 8, 8, 8);
        this.head.setRotationPoint(0.0f, 6.0f, -23.0f);
        this.head.setTextureSize(256, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 1, 99)).addBox(-6.0f, -10.0f, -7.0f, 12, 18, 10);
        this.body.setRotationPoint(0.0f, 5.0f, 2.0f);
        this.body.setTextureSize(256, 128);
        this.body.mirror = true;
        this.setRotation(this.body, 1.570796f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase) this, 47, 112)).addBox(-4.0f, -1.0f, -2.0f, 4, 9, 5);
        this.leg1.setRotationPoint(-4.0f, 11.0f, 8.0f);
        this.leg1.setTextureSize(256, 128);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, -0.6320364f, 0.0f, 0.0f);
        (this.leg2 = new ModelRenderer((ModelBase) this, 47, 112)).addBox(1.0f, -1.0f, -2.0f, 4, 9, 5);
        this.leg2.setRotationPoint(3.0f, 11.0f, 8.0f);
        this.leg2.setTextureSize(256, 128);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, -0.6320364f, 0.0f, 0.0f);
        (this.leg3 = new ModelRenderer((ModelBase) this, 18, 47)).addBox(-3.0f, -2.0f, -2.0f, 4, 9, 4);
        this.leg3.setRotationPoint(-4.0f, 11.0f, -5.0f);
        this.leg3.setTextureSize(256, 128);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.5576792f, 0.0f, 0.0f);
        (this.leg4 = new ModelRenderer((ModelBase) this, 18, 47)).addBox(0.0f, -2.0f, -2.0f, 4, 9, 4);
        this.leg4.setRotationPoint(3.0f, 11.0f, -5.0f);
        this.leg4.setTextureSize(256, 128);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.5576792f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 68, 94)).addBox(-5.0f, 0.0f, 0.0f, 10, 22, 10);
        this.body2.setRotationPoint(0.0f, 12.0f, -10.0f);
        this.body2.setTextureSize(256, 128);
        this.body2.mirror = true;
        this.setRotation(this.body2, 1.570796f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase) this, 43, 85)).addBox(-3.0f, -3.0f, 0.0f, 6, 6, 6);
        this.neck1.setRotationPoint(0.0f, 7.0f, 25.0f);
        this.neck1.setTextureSize(256, 128);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, 0.0f, 0.0f, 0.0f);
        (this.body3 = new ModelRenderer((ModelBase) this, 70, 59)).addBox(-4.0f, 0.0f, 0.0f, 8, 24, 8);
        this.body3.setRotationPoint(0.0f, 11.0f, -11.0f);
        this.body3.setTextureSize(256, 128);
        this.body3.mirror = true;
        this.setRotation(this.body3, 1.570796f, 0.0f, 0.0f);
        (this.neck2 = new ModelRenderer((ModelBase) this, 43, 85)).addBox(-3.0f, -2.0f, -6.0f, 6, 6, 6);
        this.neck2.setRotationPoint(0.0f, 6.0f, -11.0f);
        this.neck2.setTextureSize(256, 128);
        this.neck2.mirror = true;
        this.setRotation(this.neck2, 0.0f, 0.0f, 0.0f);
        (this.neck3 = new ModelRenderer((ModelBase) this, 43, 85)).addBox(-3.0f, -2.0f, -6.0f, 6, 6, 6);
        this.neck3.setRotationPoint(0.0f, 6.0f, -17.0f);
        this.neck3.setTextureSize(256, 128);
        this.neck3.mirror = true;
        this.setRotation(this.neck3, 0.0f, 0.0f, 0.0f);
        (this.leg5 = new ModelRenderer((ModelBase) this, 47, 99)).addBox(0.0f, 3.0f, 3.0f, 4, 8, 4);
        this.leg5.setRotationPoint(3.0f, 11.0f, -5.0f);
        this.leg5.setTextureSize(256, 128);
        this.leg5.mirror = true;
        this.setRotation(this.leg5, -0.5576792f, 0.0f, 0.0f);
        (this.leg6 = new ModelRenderer((ModelBase) this, 47, 99)).addBox(-3.0f, 3.0f, 3.0f, 4, 8, 4);
        this.leg6.setRotationPoint(-4.0f, 11.0f, -5.0f);
        this.leg6.setTextureSize(256, 128);
        this.leg6.mirror = true;
        this.setRotation(this.leg6, -0.5576792f, 0.0f, 0.0f);
        (this.leg7 = new ModelRenderer((ModelBase) this, 38, 73)).addBox(1.0f, 2.0f, -8.0f, 4, 5, 4);
        this.leg7.setRotationPoint(3.0f, 11.0f, 8.0f);
        this.leg7.setTextureSize(256, 128);
        this.leg7.mirror = true;
        this.setRotation(this.leg7, 0.8922867f, 0.0f, 0.0f);
        (this.leg9 = new ModelRenderer((ModelBase) this, 38, 73)).addBox(-4.0f, 2.0f, -8.0f, 4, 5, 4);
        this.leg9.setRotationPoint(-4.0f, 11.0f, 8.0f);
        this.leg9.setTextureSize(256, 128);
        this.leg9.mirror = true;
        this.setRotation(this.leg9, 0.8922867f, 0.0f, 0.0f);
        (this.foot1 = new ModelRenderer((ModelBase) this, 43, 63)).addBox(-3.0f, 11.0f, -5.0f, 4, 2, 6);
        this.foot1.setRotationPoint(-4.0f, 11.0f, -5.0f);
        this.foot1.setTextureSize(256, 128);
        this.foot1.mirror = true;
        this.setRotation(this.foot1, 0.0f, 0.0f, 0.0f);
        (this.foot2 = new ModelRenderer((ModelBase) this, 43, 63)).addBox(0.0f, 11.0f, -5.0f, 4, 2, 6);
        this.foot2.setRotationPoint(3.0f, 11.0f, -5.0f);
        this.foot2.setTextureSize(256, 128);
        this.foot2.mirror = true;
        this.setRotation(this.foot2, 0.0f, 0.0f, 0.0f);
        (this.leg10 = new ModelRenderer((ModelBase) this, 39, 52)).addBox(1.0f, 6.0f, 2.0f, 4, 5, 4);
        this.leg10.setRotationPoint(3.0f, 11.0f, 8.0f);
        this.leg10.setTextureSize(256, 128);
        this.leg10.mirror = true;
        this.setRotation(this.leg10, -0.5576792f, 0.0f, 0.0f);
        (this.leg11 = new ModelRenderer((ModelBase) this, 39, 52)).addBox(-4.0f, 6.0f, 2.0f, 4, 5, 4);
        this.leg11.setRotationPoint(-4.0f, 11.0f, 8.0f);
        this.leg11.setTextureSize(256, 128);
        this.leg11.mirror = true;
        this.setRotation(this.leg11, -0.5576792f, 0.0f, 0.0f);
        (this.foot3 = new ModelRenderer((ModelBase) this, 43, 63)).addBox(1.0f, 11.0f, -7.0f, 4, 2, 6);
        this.foot3.setRotationPoint(3.0f, 11.0f, 8.0f);
        this.foot3.setTextureSize(256, 128);
        this.foot3.mirror = true;
        this.setRotation(this.foot3, 0.0f, 0.0f, 0.0f);
        (this.foot4 = new ModelRenderer((ModelBase) this, 43, 63)).addBox(-4.0f, 11.0f, -7.0f, 4, 2, 6);
        this.foot4.setRotationPoint(-4.0f, 11.0f, 8.0f);
        this.foot4.setTextureSize(256, 128);
        this.foot4.mirror = true;
        this.setRotation(this.foot4, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 43, 85)).addBox(-3.0f, -3.0f, 0.0f, 6, 6, 6);
        this.tail1.setRotationPoint(0.0f, 7.0f, 13.0f);
        this.tail1.setTextureSize(256, 128);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 43, 85)).addBox(-3.0f, -3.0f, 0.0f, 6, 6, 6);
        this.tail2.setRotationPoint(0.0f, 7.0f, 19.0f);
        this.tail2.setTextureSize(256, 128);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase) this, 56, 45)).addBox(-3.0f, -3.0f, 0.0f, 4, 6, 6);
        this.tail3.setRotationPoint(1.0f, 7.0f, 31.0f);
        this.tail3.setTextureSize(256, 128);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, 0.0f, 0.0f, 0.0f);
        (this.mouth1 = new ModelRenderer((ModelBase) this, 90, 22)).addBox(-3.0f, -1.0f, -15.0f, 6, 3, 8);
        this.mouth1.setRotationPoint(0.0f, 6.0f, -23.0f);
        this.mouth1.setTextureSize(256, 128);
        this.mouth1.mirror = true;
        this.setRotation(this.mouth1, 0.0f, 0.0f, 0.0f);
        (this.mouth2 = new ModelRenderer((ModelBase) this, 90, 6)).addBox(-2.0f, 1.0f, -5.0f, 4, 2, 8);
        this.mouth2.setRotationPoint(0.0f, 7.0f, -32.0f);
        this.mouth2.setTextureSize(256, 128);
        this.mouth2.mirror = true;
        this.setRotation(this.mouth2, 0.0698132f, 0.0f, 0.0f);
        (this.tail5 = new ModelRenderer((ModelBase) this, 87, 36)).addBox(0.0f, 0.0f, -5.0f, 0, 11, 10);
        this.tail5.setRotationPoint(0.0f, 7.0f, 49.0f);
        this.tail5.setTextureSize(256, 128);
        this.tail5.mirror = true;
        this.setRotation(this.tail5, 1.570796f, 0.0f, 0.0f);
        (this.wing1 = new ModelRenderer((ModelBase) this, 26, 40)).addBox(0.0f, -1.0f, -1.0f, 11, 2, 2);
        this.wing1.setRotationPoint(4.0f, 3.0f, -5.0f);
        this.wing1.setTextureSize(256, 128);
        this.wing1.mirror = true;
        this.setRotation(this.wing1, 0.0f, -0.4833219f, 0.0f);
        (this.wing2 = new ModelRenderer((ModelBase) this, 110, 88)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 36);
        this.wing2.setRotationPoint(19.0f, 3.0f, -23.0f);
        this.wing2.setTextureSize(256, 128);
        this.wing2.mirror = true;
        this.setRotation(this.wing2, 0.0f, 1.041001f, 0.0f);
        (this.wing3 = new ModelRenderer((ModelBase) this, 109, 60)).addBox(-1.0f, -1.0f, -24.0f, 2, 2, 24);
        this.wing3.setRotationPoint(12.0f, 3.0f, -1.0f);
        this.wing3.setTextureSize(256, 128);
        this.wing3.mirror = true;
        this.setRotation(this.wing3, -0.0090881f, -0.3497888f, 0.0f);
        (this.wing4 = new ModelRenderer((ModelBase) this, 26, 40)).addBox(-11.0f, -1.0f, -1.0f, 11, 2, 2);
        this.wing4.setRotationPoint(-4.0f, 3.0f, -5.0f);
        this.wing4.setTextureSize(256, 128);
        this.wing4.mirror = true;
        this.setRotation(this.wing4, 0.0f, 0.4833166f, 0.0f);
        (this.wing5 = new ModelRenderer((ModelBase) this, 109, 60)).addBox(-1.0f, -1.0f, -24.0f, 2, 2, 24);
        this.wing5.setRotationPoint(-12.0f, 3.0f, -1.0f);
        this.wing5.setTextureSize(256, 128);
        this.wing5.mirror = true;
        this.setRotation(this.wing5, -0.0090932f, 0.3323281f, 0.0f);
        (this.wing6 = new ModelRenderer((ModelBase) this, 110, 88)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 36);
        this.wing6.setRotationPoint(-20.0f, 3.0f, -23.0f);
        this.wing6.setTextureSize(256, 128);
        this.wing6.mirror = true;
        this.setRotation(this.wing6, 0.0f, -1.041002f, 0.0f);
        (this.wing7 = new ModelRenderer((ModelBase) this, 124, 21)).addBox(-8.0f, 0.0f, 1.0f, 8, 1, 36);
        this.wing7.setRotationPoint(19.0f, 2.0f, -23.0f);
        this.wing7.setTextureSize(256, 128);
        this.wing7.mirror = true;
        this.setRotation(this.wing7, 0.0f, 1.041001f, 0.0f);
        (this.wing8 = new ModelRenderer((ModelBase) this, 122, 10)).addBox(-11.0f, -1.0f, 0.0f, 28, 1, 8);
        this.wing8.setRotationPoint(12.0f, 3.0f, -1.0f);
        this.wing8.setTextureSize(256, 128);
        this.wing8.mirror = true;
        this.setRotation(this.wing8, 0.002272f, 1.264073f, -0.0174533f);
        (this.wing9 = new ModelRenderer((ModelBase) this, 0, 10)).addBox(-25.0f, -1.0f, 7.0f, 18, 1, 26);
        this.wing9.setRotationPoint(19.0f, 3.0f, -23.0f);
        this.wing9.setTextureSize(256, 128);
        this.wing9.mirror = true;
        this.setRotation(this.wing9, 0.002272f, 1.264073f, 0.0f);
        (this.wing10 = new ModelRenderer((ModelBase) this, 122, 10)).addBox(-23.0f, -1.0f, 0.0f, 33, 1, 8);
        this.wing10.setRotationPoint(-12.0f, 3.0f, -1.0f);
        this.wing10.setTextureSize(256, 128);
        this.wing10.mirror = true;
        this.setRotation(this.wing10, -0.0022689f, -1.226894f, 0.0f);
        (this.wing11 = new ModelRenderer((ModelBase) this, 124, 21)).addBox(0.0f, -1.0f, 1.0f, 8, 1, 36);
        this.wing11.setRotationPoint(-20.0f, 3.0f, -23.0f);
        this.wing11.setTextureSize(256, 128);
        this.wing11.mirror = true;
        this.setRotation(this.wing11, 0.0f, -1.041002f, 0.0f);
        (this.wing12 = new ModelRenderer((ModelBase) this, 0, 10)).addBox(7.0f, -1.0f, 7.0f, 18, 1, 26);
        this.wing12.setRotationPoint(-20.0f, 3.0f, -23.0f);
        this.wing12.setTextureSize(256, 128);
        this.wing12.mirror = true;
        this.setRotation(this.wing12, 0.002272f, -1.264072f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase) this, 56, 45)).addBox(-3.0f, -3.0f, 0.0f, 4, 6, 6);
        this.tail4.setRotationPoint(1.0f, 7.0f, 37.0f);
        this.tail4.setTextureSize(256, 128);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, float f3, final float f4,
        final float f5) {
        final Dragon e = (Dragon) entity;
        float newangle = 0.0f;
        float lspeed = 0.0f;
        RenderInfo r = null;
        float tailspeed = 0.76f;
        float tailamp = 0.45f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderInfo();
        if (f1 > 0.001) {
            lspeed = (float) ((e.prevPosX - e.posX) * (e.prevPosX - e.posX)
                + (e.prevPosZ - e.posZ) * (e.prevPosZ - e.posZ));
            lspeed = (float) Math.sqrt(lspeed);
            newangle = MathHelper.cos(f2 * 1.25f * this.wingspeed) * 3.1415927f * lspeed * 0.6f;
        } else {
            newangle = 0.0f;
        }
        if (e.getActivity() != 0) {
            newangle = 1.0f;
            this.leg4.rotateAngleX = 0.557f - newangle;
            this.leg5.rotateAngleX = -0.557f - newangle;
            this.foot2.rotateAngleX = -newangle;
            this.leg3.rotateAngleX = 0.557f - newangle;
            this.leg6.rotateAngleX = -0.557f - newangle;
            this.foot1.rotateAngleX = -newangle;
            this.leg2.rotateAngleX = -0.632f + newangle;
            this.leg7.rotateAngleX = 0.89f + newangle;
            this.leg10.rotateAngleX = -0.557f + newangle;
            this.foot3.rotateAngleX = newangle;
            this.leg1.rotateAngleX = -0.632f + newangle;
            this.leg9.rotateAngleX = 0.89f + newangle;
            this.leg11.rotateAngleX = -0.557f + newangle;
            this.foot4.rotateAngleX = newangle;
        } else {
            this.leg4.rotateAngleX = 0.557f + newangle;
            this.leg5.rotateAngleX = -0.557f + newangle;
            this.foot2.rotateAngleX = newangle;
            this.leg3.rotateAngleX = 0.557f - newangle;
            this.leg6.rotateAngleX = -0.557f - newangle;
            this.foot1.rotateAngleX = -newangle;
            this.leg2.rotateAngleX = -0.632f - newangle;
            this.leg7.rotateAngleX = 0.89f - newangle;
            this.leg10.rotateAngleX = -0.557f - newangle;
            this.foot3.rotateAngleX = -newangle;
            this.leg1.rotateAngleX = -0.632f + newangle;
            this.leg9.rotateAngleX = 0.89f + newangle;
            this.leg11.rotateAngleX = -0.557f + newangle;
            this.foot4.rotateAngleX = newangle;
        }
        if (e.getAttacking() != 0) {
            if (e.getActivity() != 0) {
                newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.1415927f * 0.28f;
            } else {
                newangle = -0.45f + MathHelper.cos(f2 * 0.85f * this.wingspeed) * 3.1415927f * 0.2f;
            }
        } else if (e.getActivity() != 0) {
            newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.1415927f * 0.28f;
        } else {
            newangle = -0.85f + MathHelper.cos(f2 * 0.2f * this.wingspeed) * 3.1415927f * 0.028f;
        }
        this.wing1.rotateAngleZ = newangle;
        this.wing15.rotateAngleZ = newangle;
        this.wing3.rotateAngleZ = newangle * 4.0f / 3.0f;
        this.wing3.rotationPointY = this.wing1.rotationPointY + (float) Math.sin(this.wing1.rotateAngleZ) * 7.0f;
        this.wing3.rotationPointX = this.wing1.rotationPointX + (float) Math.cos(this.wing1.rotateAngleZ) * 7.0f;
        this.wing8.rotateAngleZ = newangle * 4.0f / 3.0f;
        this.wing8.rotationPointY = this.wing3.rotationPointY;
        this.wing8.rotationPointX = this.wing3.rotationPointX;
        this.wing2.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.wing2.rotationPointY = this.wing3.rotationPointY + (float) Math.sin(this.wing3.rotateAngleZ) * 6.0f;
        this.wing2.rotationPointX = this.wing3.rotationPointX + (float) Math.cos(this.wing3.rotateAngleZ) * 6.0f;
        this.wing7.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.wing7.rotationPointY = this.wing2.rotationPointY;
        this.wing7.rotationPointX = this.wing2.rotationPointX;
        this.wing9.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.wing9.rotationPointY = this.wing2.rotationPointY;
        this.wing9.rotationPointX = this.wing2.rotationPointX;
        this.wing4.rotateAngleZ = -newangle;
        this.wing14.rotateAngleZ = -newangle;
        this.wing5.rotateAngleZ = -newangle * 4.0f / 3.0f;
        this.wing5.rotationPointY = this.wing4.rotationPointY - (float) Math.sin(this.wing4.rotateAngleZ) * 7.0f;
        this.wing5.rotationPointX = this.wing4.rotationPointX - (float) Math.cos(this.wing4.rotateAngleZ) * 7.0f;
        this.wing10.rotateAngleZ = -newangle * 4.0f / 3.0f;
        this.wing10.rotationPointY = this.wing5.rotationPointY;
        this.wing10.rotationPointX = this.wing5.rotationPointX;
        this.wing6.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.wing6.rotationPointY = this.wing5.rotationPointY - (float) Math.sin(this.wing5.rotateAngleZ) * 6.0f;
        this.wing6.rotationPointX = this.wing5.rotationPointX - (float) Math.cos(this.wing5.rotateAngleZ) * 6.0f;
        this.wing11.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.wing11.rotationPointY = this.wing6.rotationPointY;
        this.wing11.rotationPointX = this.wing6.rotationPointX;
        this.wing12.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.wing12.rotationPointY = this.wing6.rotationPointY;
        this.wing12.rotationPointX = this.wing6.rotationPointX;
        if (e.getAttacking() != 0) {
            tailspeed = 0.96f;
            tailamp = 0.75f;
        }
        if (e.getActivity() == 0 && e.getAttacking() == 0) {
            tailspeed = 0.22f;
            tailamp = 0.22f;
        }
        if (e.isSitting()) {
            tailspeed = 0.0f;
            tailamp = 0.0f;
        }
        this.tail1.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * 0.04f;
        this.spike10.rotationPointZ = this.tail1.rotationPointZ;
        this.spike10.rotationPointX = this.tail1.rotationPointX;
        this.spike10.rotateAngleY = this.tail1.rotateAngleY;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 6.0f;
        this.tail2.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 6.0f;
        this.tail2.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * tailamp * 0.125f;
        this.spike7.rotationPointZ = this.tail2.rotationPointZ;
        this.spike7.rotationPointX = this.tail2.rotationPointX;
        this.spike7.rotateAngleY = this.tail2.rotateAngleY;
        this.neck1.rotationPointZ = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleY) * 6.0f;
        this.neck1.rotationPointX = this.tail2.rotationPointX + (float) Math.sin(this.tail2.rotateAngleY) * 6.0f;
        this.neck1.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * tailamp * 0.25f;
        this.spike8.rotationPointZ = this.neck1.rotationPointZ;
        this.spike8.rotationPointX = this.neck1.rotationPointX;
        this.spike8.rotateAngleY = this.neck1.rotateAngleY;
        this.tail3.rotationPointZ = this.neck1.rotationPointZ + (float) Math.cos(this.neck1.rotateAngleY) * 6.0f;
        this.tail3.rotationPointX = this.neck1.rotationPointX + 1.0f + (float) Math.sin(this.neck1.rotateAngleY) * 6.0f;
        this.tail3.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * tailamp * 0.375f;
        this.spike3.rotationPointZ = this.tail3.rotationPointZ;
        this.spike3.rotationPointX = this.tail3.rotationPointX - 1.0f;
        this.spike3.rotateAngleY = this.tail3.rotateAngleY;
        this.tail4.rotationPointZ = this.tail3.rotationPointZ + (float) Math.cos(this.tail3.rotateAngleY) * 6.0f;
        this.tail4.rotationPointX = this.tail3.rotationPointX + (float) Math.sin(this.tail3.rotateAngleY) * 6.0f;
        this.tail4.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * tailamp * 0.5f;
        this.spike9.rotationPointZ = this.tail4.rotationPointZ;
        this.spike9.rotationPointX = this.tail4.rotationPointX - 1.0f;
        this.spike9.rotateAngleY = this.tail4.rotateAngleY;
        this.tail6.rotationPointZ = this.tail4.rotationPointZ + (float) Math.cos(this.tail4.rotateAngleY) * 6.0f;
        this.tail6.rotationPointX = this.tail4.rotationPointX - 1.0f + (float) Math.sin(this.tail4.rotateAngleY) * 6.0f;
        this.tail6.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * tailamp * 0.625f;
        this.tail5.rotationPointZ = this.tail6.rotationPointZ + (float) Math.cos(this.tail6.rotateAngleY) * 6.0f;
        this.tail5.rotationPointX = this.tail6.rotationPointX - 0.5f + (float) Math.sin(this.tail6.rotateAngleY) * 6.0f;
        this.tail5.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * tailamp * 0.75f;
        if (e.getActivity() == 1) {
            f3 = (e.prevRotationYaw - e.rotationYaw) * 8.0f;
            f3 = -f3;
            final RenderInfo renderInfo = r;
            renderInfo.rf1 += (f3 - r.rf1) / 60.0f;
            if (r.rf1 > 50.0f) {
                r.rf1 = 50.0f;
            }
            if (r.rf1 < -50.0f) {
                r.rf1 = -50.0f;
            }
            f3 = r.rf1;
        } else {
            f3 /= 2.0f;
        }
        this.neck2.rotateAngleY = (float) Math.toRadians(f3) * 0.25f;
        this.spike2.rotateAngleY = this.neck2.rotateAngleY;
        this.neck3.rotationPointZ = this.neck2.rotationPointZ - (float) Math.cos(this.neck2.rotateAngleY) * 6.0f;
        this.neck3.rotationPointX = this.neck2.rotationPointX - (float) Math.sin(this.neck2.rotateAngleY) * 6.0f;
        this.neck3.rotateAngleY = (float) Math.toRadians(f3) * 0.5f;
        this.spike1.rotationPointZ = this.neck3.rotationPointZ;
        this.spike1.rotationPointX = this.neck3.rotationPointX;
        this.spike1.rotateAngleY = this.neck3.rotateAngleY;
        this.head.rotationPointZ = this.neck3.rotationPointZ - (float) Math.cos(this.neck3.rotateAngleY) * 6.0f;
        this.head.rotationPointX = this.neck3.rotationPointX - (float) Math.sin(this.neck3.rotateAngleY) * 6.0f;
        this.head.rotateAngleY = (float) Math.toRadians(f3) * 0.75f;
        this.mouth1.rotationPointZ = this.head.rotationPointZ;
        this.mouth1.rotationPointX = this.head.rotationPointX;
        this.mouth1.rotateAngleY = this.head.rotateAngleY;
        this.horn1.rotationPointZ = this.head.rotationPointZ;
        this.horn1.rotationPointX = this.head.rotationPointX;
        this.horn1.rotateAngleY = this.head.rotateAngleY + 0.26f;
        this.horn2.rotationPointZ = this.head.rotationPointZ;
        this.horn2.rotationPointX = this.head.rotationPointX;
        this.horn2.rotateAngleY = this.head.rotateAngleY - 0.26f;
        this.mouth2.rotationPointZ = this.head.rotationPointZ - (float) Math.cos(this.head.rotateAngleY) * 9.0f;
        this.mouth2.rotationPointX = this.head.rotationPointX - (float) Math.sin(this.head.rotateAngleY) * 9.0f;
        this.mouth2.rotateAngleY = this.head.rotateAngleY;
        newangle = MathHelper.cos(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.14f;
        if (e.getAttacking() != 0) {
            this.mouth2.rotateAngleX = 0.4f + newangle;
        } else {
            this.mouth2.rotateAngleX = 0.07f;
        }
        e.setRenderInfo(r);
        this.horn1.render(f5);
        this.horn2.render(f5);
        this.tail6.render(f5);
        this.wing15.render(f5);
        this.spike1.render(f5);
        this.spike2.render(f5);
        this.spike3.render(f5);
        this.spike4.render(f5);
        this.wing14.render(f5);
        this.spike5.render(f5);
        this.spike6.render(f5);
        this.spike7.render(f5);
        this.spike8.render(f5);
        this.spike9.render(f5);
        this.spike10.render(f5);
        this.head.render(f5);
        this.body.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.leg3.render(f5);
        this.leg4.render(f5);
        this.body2.render(f5);
        this.neck1.render(f5);
        this.body3.render(f5);
        this.neck2.render(f5);
        this.neck3.render(f5);
        this.leg5.render(f5);
        this.leg6.render(f5);
        this.leg7.render(f5);
        this.leg9.render(f5);
        this.foot1.render(f5);
        this.foot2.render(f5);
        this.leg10.render(f5);
        this.leg11.render(f5);
        this.foot3.render(f5);
        this.foot4.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.mouth1.render(f5);
        this.mouth2.render(f5);
        this.tail5.render(f5);
        this.wing1.render(f5);
        this.wing2.render(f5);
        this.wing3.render(f5);
        this.wing4.render(f5);
        this.wing5.render(f5);
        this.wing6.render(f5);
        this.wing7.render(f5);
        this.wing8.render(f5);
        this.wing9.render(f5);
        this.wing10.render(f5);
        this.wing11.render(f5);
        this.wing12.render(f5);
        this.tail4.render(f5);
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
