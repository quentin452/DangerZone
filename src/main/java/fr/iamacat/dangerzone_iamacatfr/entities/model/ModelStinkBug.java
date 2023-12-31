
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelStinkBug extends ModelBase {

    private float wingspeed;
    ModelRenderer f6;
    ModelRenderer b10;
    ModelRenderer l6;
    ModelRenderer l4;
    ModelRenderer f4;
    ModelRenderer l5;
    ModelRenderer f5;
    ModelRenderer l3;
    ModelRenderer l2;
    ModelRenderer l1;
    ModelRenderer f3;
    ModelRenderer f2;
    ModelRenderer f1;
    ModelRenderer jaw;
    ModelRenderer b9;
    ModelRenderer head;
    ModelRenderer b4;
    ModelRenderer h1;
    ModelRenderer h2;
    ModelRenderer body;
    ModelRenderer t21;
    ModelRenderer tail;
    ModelRenderer t22;
    ModelRenderer t20;
    ModelRenderer t19;
    ModelRenderer t6;
    ModelRenderer t11;
    ModelRenderer t9;
    ModelRenderer t4;
    ModelRenderer t2;
    ModelRenderer t7;
    ModelRenderer t12;
    ModelRenderer t10;
    ModelRenderer t8;
    ModelRenderer t5;
    ModelRenderer t3;
    ModelRenderer t1;
    ModelRenderer t18;
    ModelRenderer t16;
    ModelRenderer t14;
    ModelRenderer t13;
    ModelRenderer t15;
    ModelRenderer t17;
    ModelRenderer b1;
    ModelRenderer b2;
    ModelRenderer b3;
    ModelRenderer b8;
    ModelRenderer b7;
    ModelRenderer b6;
    ModelRenderer b5;

    public ModelStinkBug(final float ff1) {
        this.wingspeed = 1.0f;
        this.wingspeed = ff1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.f6 = new ModelRenderer((ModelBase) this, 20, 16)).addBox(-2.0f, 0.0f, -1.0f, 2, 2, 2);
        this.f6.setRotationPoint(-3.5f, 16.0f, 3.0f);
        this.f6.setTextureSize(64, 32);
        this.f6.mirror = true;
        this.setRotation(this.f6, 0.0f, 0.0f, 0.0f);
        (this.b10 = new ModelRenderer((ModelBase) this, 0, 2)).addBox(-0.5f, -1.5f, -0.5f, 1, 2, 1);
        this.b10.setRotationPoint(0.0f, 11.0f, 1.0f);
        this.b10.setTextureSize(64, 32);
        this.b10.mirror = true;
        this.setRotation(this.b10, -0.5235988f, 0.0f, 0.0f);
        (this.l6 = new ModelRenderer((ModelBase) this, 20, 13)).addBox(-2.0f, 0.0f, -1.0f, 2, 1, 2);
        this.l6.setRotationPoint(-3.0f, 15.0f, 3.0f);
        this.l6.setTextureSize(64, 32);
        this.l6.mirror = true;
        this.setRotation(this.l6, 0.0f, 0.0f, 0.0f);
        (this.l4 = new ModelRenderer((ModelBase) this, 20, 13)).addBox(-2.0f, 0.0f, -1.0f, 2, 1, 2);
        this.l4.setRotationPoint(-3.0f, 15.0f, -3.0f);
        this.l4.setTextureSize(64, 32);
        this.l4.mirror = true;
        this.setRotation(this.l4, 0.0f, 0.0f, 0.0f);
        (this.f4 = new ModelRenderer((ModelBase) this, 20, 16)).addBox(-2.0f, 0.0f, -1.0f, 2, 2, 2);
        this.f4.setRotationPoint(-3.5f, 16.0f, -3.0f);
        this.f4.setTextureSize(64, 32);
        this.f4.mirror = true;
        this.setRotation(this.f4, 0.0f, 0.0f, 0.0f);
        (this.l5 = new ModelRenderer((ModelBase) this, 20, 13)).addBox(-2.0f, 0.0f, -1.0f, 2, 1, 2);
        this.l5.setRotationPoint(-3.0f, 15.0f, 0.0f);
        this.l5.setTextureSize(64, 32);
        this.l5.mirror = true;
        this.setRotation(this.l5, 0.0f, 0.0f, 0.0f);
        (this.f5 = new ModelRenderer((ModelBase) this, 20, 16)).addBox(-2.0f, 0.0f, -1.0f, 2, 2, 2);
        this.f5.setRotationPoint(-3.5f, 16.0f, 0.0f);
        this.f5.setTextureSize(64, 32);
        this.f5.mirror = true;
        this.setRotation(this.f5, 0.0f, 0.0f, 0.0f);
        (this.l3 = new ModelRenderer((ModelBase) this, 20, 13)).addBox(0.0f, 0.0f, -1.0f, 2, 1, 2);
        this.l3.setRotationPoint(3.0f, 15.0f, 3.0f);
        this.l3.setTextureSize(64, 32);
        this.l3.mirror = true;
        this.setRotation(this.l3, 0.0f, 0.0f, 0.0f);
        (this.l2 = new ModelRenderer((ModelBase) this, 20, 13)).addBox(0.0f, 0.0f, -1.0f, 2, 1, 2);
        this.l2.setRotationPoint(3.0f, 15.0f, 0.0f);
        this.l2.setTextureSize(64, 32);
        this.l2.mirror = true;
        this.setRotation(this.l2, 0.0f, 0.0f, 0.0f);
        (this.l1 = new ModelRenderer((ModelBase) this, 20, 13)).addBox(0.0f, 0.0f, -1.0f, 2, 1, 2);
        this.l1.setRotationPoint(3.0f, 15.0f, -3.0f);
        this.l1.setTextureSize(64, 32);
        this.l1.mirror = true;
        this.setRotation(this.l1, 0.0f, 0.0f, 0.0f);
        (this.f3 = new ModelRenderer((ModelBase) this, 20, 16)).addBox(0.0f, 0.0f, -1.0f, 2, 2, 2);
        this.f3.setRotationPoint(3.5f, 16.0f, 3.0f);
        this.f3.setTextureSize(64, 32);
        this.f3.mirror = true;
        this.setRotation(this.f3, 0.0f, 0.0f, 0.0f);
        (this.f2 = new ModelRenderer((ModelBase) this, 20, 16)).addBox(0.0f, 0.0f, -1.0f, 2, 2, 2);
        this.f2.setRotationPoint(3.5f, 16.0f, 0.0f);
        this.f2.setTextureSize(64, 32);
        this.f2.mirror = true;
        this.setRotation(this.f2, 0.0f, 0.0f, 0.0f);
        (this.f1 = new ModelRenderer((ModelBase) this, 20, 16)).addBox(0.0f, 0.0f, -1.0f, 2, 2, 2);
        this.f1.setRotationPoint(3.5f, 16.0f, -3.0f);
        this.f1.setTextureSize(64, 32);
        this.f1.mirror = true;
        this.setRotation(this.f1, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 28, 8)).addBox(-3.5f, 0.0f, -8.0f, 5, 1, 4);
        this.jaw.setRotationPoint(1.0f, 15.0f, 0.0f);
        this.jaw.setTextureSize(64, 32);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.122173f, 0.0f, 0.0f);
        (this.b9 = new ModelRenderer((ModelBase) this, 0, 2)).addBox(-0.5f, -1.5f, -0.5f, 1, 2, 1);
        this.b9.setRotationPoint(0.0f, 11.0f, -1.0f);
        this.b9.setTextureSize(64, 32);
        this.b9.mirror = true;
        this.setRotation(this.b9, 0.5235988f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 28, 0)).addBox(-3.5f, -3.5f, -8.0f, 5, 4, 4);
        this.head.setRotationPoint(1.0f, 15.0f, 0.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.b4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.0f, -0.5f, 2.5f, 1, 1, 1);
        this.b4.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b4.setTextureSize(64, 32);
        this.b4.mirror = true;
        this.setRotation(this.b4, 0.0f, 0.0f, 0.0f);
        (this.h1 = new ModelRenderer((ModelBase) this, 0, 2)).addBox(-0.5f, -2.0f, -0.5f, 1, 2, 1);
        this.h1.setRotationPoint(-1.5f, 12.0f, -7.0f);
        this.h1.setTextureSize(64, 32);
        this.h1.mirror = true;
        this.setRotation(this.h1, 0.5235988f, 0.3490659f, 0.0f);
        (this.h2 = new ModelRenderer((ModelBase) this, 0, 2)).addBox(-0.5f, -2.0f, -0.5f, 1, 2, 1);
        this.h2.setRotationPoint(1.5f, 12.0f, -7.0f);
        this.h2.setTextureSize(64, 32);
        this.h2.mirror = true;
        this.setRotation(this.h2, 0.5235988f, -0.3490659f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-4.0f, -4.0f, -4.0f, 6, 5, 8);
        this.body.setRotationPoint(1.0f, 15.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.t21 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, 3.5f, 4.0f, 1, 1, 1);
        this.t21.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t21.setTextureSize(64, 32);
        this.t21.mirror = true;
        this.setRotation(this.t21, -0.3316126f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase) this, 0, 13)).addBox(-2.0f, 0.0f, 0.0f, 4, 4, 6);
        this.tail.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, -0.3316126f, 0.0f, 0.0f);
        (this.t22 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, 3.5f, 4.0f, 1, 1, 1);
        this.t22.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t22.setTextureSize(64, 32);
        this.t22.mirror = true;
        this.setRotation(this.t22, -0.3316126f, 0.0f, 0.0f);
        (this.t20 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, 3.5f, 2.0f, 1, 1, 1);
        this.t20.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t20.setTextureSize(64, 32);
        this.t20.mirror = true;
        this.setRotation(this.t20, -0.3316126f, 0.0f, 0.0f);
        (this.t19 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, 3.5f, 2.0f, 1, 1, 1);
        this.t19.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t19.setTextureSize(64, 32);
        this.t19.mirror = true;
        this.setRotation(this.t19, -0.3316126f, 0.0f, 0.0f);
        (this.t6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, 2.5f, 4.0f, 1, 1, 1);
        this.t6.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t6.setTextureSize(64, 32);
        this.t6.mirror = true;
        this.setRotation(this.t6, -0.3316126f, 0.0f, 0.0f);
        (this.t11 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, -0.5f, 4.0f, 1, 1, 1);
        this.t11.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t11.setTextureSize(64, 32);
        this.t11.mirror = true;
        this.setRotation(this.t11, -0.3316126f, 0.0f, 0.0f);
        (this.t9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, -0.5f, 2.0f, 1, 1, 1);
        this.t9.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t9.setTextureSize(64, 32);
        this.t9.mirror = true;
        this.setRotation(this.t9, -0.3316126f, 0.0f, 0.0f);
        (this.t4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, 2.5f, 2.0f, 1, 1, 1);
        this.t4.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t4.setTextureSize(64, 32);
        this.t4.mirror = true;
        this.setRotation(this.t4, -0.3316126f, 0.0f, 0.0f);
        (this.t2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, 2.5f, 0.0f, 1, 1, 1);
        this.t2.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t2.setTextureSize(64, 32);
        this.t2.mirror = true;
        this.setRotation(this.t2, -0.3316126f, 0.0f, 0.0f);
        (this.t7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, -0.5f, 0.0f, 1, 1, 1);
        this.t7.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t7.setTextureSize(64, 32);
        this.t7.mirror = true;
        this.setRotation(this.t7, -0.3316126f, 0.0f, 0.0f);
        (this.t12 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, -0.5f, 4.0f, 1, 1, 1);
        this.t12.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t12.setTextureSize(64, 32);
        this.t12.mirror = true;
        this.setRotation(this.t12, -0.3316126f, 0.0f, 0.0f);
        (this.t10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, -0.5f, 2.0f, 1, 1, 1);
        this.t10.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t10.setTextureSize(64, 32);
        this.t10.mirror = true;
        this.setRotation(this.t10, -0.3316126f, 0.0f, 0.0f);
        (this.t8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, -0.5f, 0.0f, 1, 1, 1);
        this.t8.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t8.setTextureSize(64, 32);
        this.t8.mirror = true;
        this.setRotation(this.t8, -0.3316126f, 0.0f, 0.0f);
        (this.t5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, 0.5f, 4.0f, 1, 1, 1);
        this.t5.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t5.setTextureSize(64, 32);
        this.t5.mirror = true;
        this.setRotation(this.t5, -0.3316126f, 0.0f, 0.0f);
        (this.t3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, 0.5f, 2.0f, 1, 1, 1);
        this.t3.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t3.setTextureSize(64, 32);
        this.t3.mirror = true;
        this.setRotation(this.t3, -0.3316126f, 0.0f, 0.0f);
        (this.t1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, 0.5f, 0.0f, 1, 1, 1);
        this.t1.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t1.setTextureSize(64, 32);
        this.t1.mirror = true;
        this.setRotation(this.t1, -0.3316126f, 0.0f, 0.0f);
        (this.t18 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, 2.5f, 4.0f, 1, 1, 1);
        this.t18.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t18.setTextureSize(64, 32);
        this.t18.mirror = true;
        this.setRotation(this.t18, -0.3316126f, 0.0f, 0.0f);
        (this.t16 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, 2.5f, 2.0f, 1, 1, 1);
        this.t16.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t16.setTextureSize(64, 32);
        this.t16.mirror = true;
        this.setRotation(this.t16, -0.3316126f, 0.0f, 0.0f);
        (this.t14 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, 2.5f, 0.0f, 1, 1, 1);
        this.t14.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t14.setTextureSize(64, 32);
        this.t14.mirror = true;
        this.setRotation(this.t14, -0.3316126f, 0.0f, 0.0f);
        (this.t13 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, 0.5f, 0.0f, 1, 1, 1);
        this.t13.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t13.setTextureSize(64, 32);
        this.t13.mirror = true;
        this.setRotation(this.t13, -0.3316126f, 0.0f, 0.0f);
        (this.t15 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, 0.5f, 2.0f, 1, 1, 1);
        this.t15.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t15.setTextureSize(64, 32);
        this.t15.mirror = true;
        this.setRotation(this.t15, -0.3316126f, 0.0f, 0.0f);
        (this.t17 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, 0.5f, 4.0f, 1, 1, 1);
        this.t17.setRotationPoint(0.0f, 11.5f, 4.0f);
        this.t17.setTextureSize(64, 32);
        this.t17.mirror = true;
        this.setRotation(this.t17, -0.3316126f, 0.0f, 0.0f);
        (this.b1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.0f, -0.5f, -3.5f, 1, 1, 1);
        this.b1.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b1.setTextureSize(64, 32);
        this.b1.mirror = true;
        this.setRotation(this.b1, 0.0f, 0.0f, 0.0f);
        (this.b2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, -0.5f, -1.5f, 1, 1, 1);
        this.b2.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b2.setTextureSize(64, 32);
        this.b2.mirror = true;
        this.setRotation(this.b2, 0.0f, 0.0f, 0.0f);
        (this.b3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(1.5f, -0.5f, 0.5f, 1, 1, 1);
        this.b3.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b3.setTextureSize(64, 32);
        this.b3.mirror = true;
        this.setRotation(this.b3, 0.0f, 0.0f, 0.0f);
        (this.b8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.0f, -0.5f, 2.5f, 1, 1, 1);
        this.b8.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b8.setTextureSize(64, 32);
        this.b8.mirror = true;
        this.setRotation(this.b8, 0.0f, 0.0f, 0.0f);
        (this.b7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, -0.5f, 0.5f, 1, 1, 1);
        this.b7.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b7.setTextureSize(64, 32);
        this.b7.mirror = true;
        this.setRotation(this.b7, 0.0f, 0.0f, 0.0f);
        (this.b6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.5f, -0.5f, -1.5f, 1, 1, 1);
        this.b6.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b6.setTextureSize(64, 32);
        this.b6.mirror = true;
        this.setRotation(this.b6, 0.0f, 0.0f, 0.0f);
        (this.b5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.966667f, -0.5f, -3.5f, 1, 1, 1);
        this.b5.setRotationPoint(0.0f, 11.0f, 0.0f);
        this.b5.setTextureSize(64, 32);
        this.b5.mirror = true;
        this.setRotation(this.b5, 0.0f, 0.0f, 0.0f);
        final ModelRenderer f6 = this.f6;
        f6.rotationPointY += 6.0f;
        final ModelRenderer b10 = this.b10;
        b10.rotationPointY += 6.0f;
        final ModelRenderer l6 = this.l6;
        l6.rotationPointY += 6.0f;
        final ModelRenderer l7 = this.l4;
        l7.rotationPointY += 6.0f;
        final ModelRenderer f7 = this.f4;
        f7.rotationPointY += 6.0f;
        final ModelRenderer l8 = this.l5;
        l8.rotationPointY += 6.0f;
        final ModelRenderer f8 = this.f5;
        f8.rotationPointY += 6.0f;
        final ModelRenderer l9 = this.l3;
        l9.rotationPointY += 6.0f;
        final ModelRenderer l10 = this.l2;
        l10.rotationPointY += 6.0f;
        final ModelRenderer l11 = this.l1;
        l11.rotationPointY += 6.0f;
        final ModelRenderer f9 = this.f3;
        f9.rotationPointY += 6.0f;
        final ModelRenderer f10 = this.f2;
        f10.rotationPointY += 6.0f;
        final ModelRenderer f11 = this.f1;
        f11.rotationPointY += 6.0f;
        final ModelRenderer jaw = this.jaw;
        jaw.rotationPointY += 6.0f;
        final ModelRenderer b11 = this.b9;
        b11.rotationPointY += 6.0f;
        final ModelRenderer head = this.head;
        head.rotationPointY += 6.0f;
        final ModelRenderer b12 = this.b4;
        b12.rotationPointY += 6.0f;
        final ModelRenderer h1 = this.h1;
        h1.rotationPointY += 6.0f;
        final ModelRenderer h2 = this.h2;
        h2.rotationPointY += 6.0f;
        final ModelRenderer body = this.body;
        body.rotationPointY += 6.0f;
        final ModelRenderer t21 = this.t21;
        t21.rotationPointY += 6.0f;
        final ModelRenderer tail = this.tail;
        tail.rotationPointY += 6.0f;
        final ModelRenderer t22 = this.t22;
        t22.rotationPointY += 6.0f;
        final ModelRenderer t23 = this.t20;
        t23.rotationPointY += 6.0f;
        final ModelRenderer t24 = this.t19;
        t24.rotationPointY += 6.0f;
        final ModelRenderer t25 = this.t6;
        t25.rotationPointY += 6.0f;
        final ModelRenderer t26 = this.t11;
        t26.rotationPointY += 6.0f;
        final ModelRenderer t27 = this.t9;
        t27.rotationPointY += 6.0f;
        final ModelRenderer t28 = this.t4;
        t28.rotationPointY += 6.0f;
        final ModelRenderer t29 = this.t2;
        t29.rotationPointY += 6.0f;
        final ModelRenderer t30 = this.t7;
        t30.rotationPointY += 6.0f;
        final ModelRenderer t31 = this.t12;
        t31.rotationPointY += 6.0f;
        final ModelRenderer t32 = this.t10;
        t32.rotationPointY += 6.0f;
        final ModelRenderer t33 = this.t8;
        t33.rotationPointY += 6.0f;
        final ModelRenderer t34 = this.t5;
        t34.rotationPointY += 6.0f;
        final ModelRenderer t35 = this.t3;
        t35.rotationPointY += 6.0f;
        final ModelRenderer t36 = this.t1;
        t36.rotationPointY += 6.0f;
        final ModelRenderer t37 = this.t18;
        t37.rotationPointY += 6.0f;
        final ModelRenderer t38 = this.t16;
        t38.rotationPointY += 6.0f;
        final ModelRenderer t39 = this.t14;
        t39.rotationPointY += 6.0f;
        final ModelRenderer t40 = this.t13;
        t40.rotationPointY += 6.0f;
        final ModelRenderer t41 = this.t15;
        t41.rotationPointY += 6.0f;
        final ModelRenderer t42 = this.t17;
        t42.rotationPointY += 6.0f;
        final ModelRenderer b13 = this.b1;
        b13.rotationPointY += 6.0f;
        final ModelRenderer b14 = this.b2;
        b14.rotationPointY += 6.0f;
        final ModelRenderer b15 = this.b3;
        b15.rotationPointY += 6.0f;
        final ModelRenderer b16 = this.b8;
        b16.rotationPointY += 6.0f;
        final ModelRenderer b17 = this.b7;
        b17.rotationPointY += 6.0f;
        final ModelRenderer b18 = this.b6;
        b18.rotationPointY += 6.0f;
        final ModelRenderer b19 = this.b5;
        b19.rotationPointY += 6.0f;
    }

    public void render(final Entity entity, final float ff, final float ff1, final float ff2, final float ff3,
        final float ff4, final float ff5) {
        super.render(entity, ff, ff1, ff2, ff3, ff4, ff5);
        this.setRotationAngles(ff, ff1, ff2, ff3, ff4, ff5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.sin(ff2 * 3.1f * this.wingspeed) * 3.1415927f * 0.3f * ff1;
        final ModelRenderer f1 = this.f1;
        final ModelRenderer f2 = this.f3;
        final ModelRenderer f3 = this.f3;
        final float rotateAngleX = newangle;
        f3.rotateAngleX = rotateAngleX;
        f2.rotateAngleX = rotateAngleX;
        f1.rotateAngleX = rotateAngleX;
        final ModelRenderer f4 = this.f2;
        final ModelRenderer f5 = this.f4;
        final ModelRenderer f6 = this.f6;
        final float rotateAngleX2 = -newangle;
        f6.rotateAngleX = rotateAngleX2;
        f5.rotateAngleX = rotateAngleX2;
        f4.rotateAngleX = rotateAngleX2;
        newangle = MathHelper.sin(ff2 * 0.4f * this.wingspeed) * 3.1415927f * 0.2f;
        this.b9.rotateAngleZ = newangle;
        this.b10.rotateAngleZ = -newangle;
        newangle = MathHelper.sin(ff2 * 0.2f * this.wingspeed) * 3.1415927f * 0.04f;
        this.jaw.rotateAngleX = 0.18f + newangle;
        this.h1.rotateAngleX = 0.52f + MathHelper.sin(ff2 * 0.4f * this.wingspeed) * 3.1415927f * 0.15f;
        this.h1.rotateAngleY = -0.3f + MathHelper.sin(ff2 * 0.43f * this.wingspeed) * 3.1415927f * 0.15f;
        this.h2.rotateAngleX = 0.52f + MathHelper.sin(ff2 * 0.46f * this.wingspeed) * 3.1415927f * 0.15f;
        this.h2.rotateAngleY = 0.3f + MathHelper.sin(ff2 * 0.49f * this.wingspeed) * 3.1415927f * 0.15f;
        this.tail.rotateAngleX = -0.2f + MathHelper.sin(ff2 * 0.1f * this.wingspeed) * 3.1415927f * 0.1f;
        final ModelRenderer t1 = this.t1;
        final ModelRenderer t2 = this.t2;
        final ModelRenderer t3 = this.t3;
        final ModelRenderer t4 = this.t4;
        final ModelRenderer t5 = this.t5;
        final float rotateAngleX3 = this.tail.rotateAngleX;
        t5.rotateAngleX = rotateAngleX3;
        t4.rotateAngleX = rotateAngleX3;
        t3.rotateAngleX = rotateAngleX3;
        t2.rotateAngleX = rotateAngleX3;
        t1.rotateAngleX = rotateAngleX3;
        final ModelRenderer t6 = this.t6;
        final ModelRenderer t7 = this.t7;
        final ModelRenderer t8 = this.t8;
        final ModelRenderer t9 = this.t9;
        final ModelRenderer t10 = this.t10;
        final float rotateAngleX4 = this.tail.rotateAngleX;
        t10.rotateAngleX = rotateAngleX4;
        t9.rotateAngleX = rotateAngleX4;
        t8.rotateAngleX = rotateAngleX4;
        t7.rotateAngleX = rotateAngleX4;
        t6.rotateAngleX = rotateAngleX4;
        final ModelRenderer t11 = this.t11;
        final ModelRenderer t12 = this.t12;
        final ModelRenderer t13 = this.t13;
        final ModelRenderer t14 = this.t14;
        final ModelRenderer t15 = this.t15;
        final float rotateAngleX5 = this.tail.rotateAngleX;
        t15.rotateAngleX = rotateAngleX5;
        t14.rotateAngleX = rotateAngleX5;
        t13.rotateAngleX = rotateAngleX5;
        t12.rotateAngleX = rotateAngleX5;
        t11.rotateAngleX = rotateAngleX5;
        final ModelRenderer t16 = this.t16;
        final ModelRenderer t17 = this.t17;
        final ModelRenderer t18 = this.t18;
        final ModelRenderer t19 = this.t19;
        final ModelRenderer t20 = this.t20;
        final float rotateAngleX6 = this.tail.rotateAngleX;
        t20.rotateAngleX = rotateAngleX6;
        t19.rotateAngleX = rotateAngleX6;
        t18.rotateAngleX = rotateAngleX6;
        t17.rotateAngleX = rotateAngleX6;
        t16.rotateAngleX = rotateAngleX6;
        final ModelRenderer t21 = this.t21;
        final ModelRenderer t22 = this.t22;
        final float rotateAngleX7 = this.tail.rotateAngleX;
        t22.rotateAngleX = rotateAngleX7;
        t21.rotateAngleX = rotateAngleX7;
        this.f6.render(ff5);
        this.b10.render(ff5);
        this.l6.render(ff5);
        this.l4.render(ff5);
        this.f4.render(ff5);
        this.l5.render(ff5);
        this.f5.render(ff5);
        this.l3.render(ff5);
        this.l2.render(ff5);
        this.l1.render(ff5);
        this.f3.render(ff5);
        this.f2.render(ff5);
        this.f1.render(ff5);
        this.jaw.render(ff5);
        this.b9.render(ff5);
        this.head.render(ff5);
        this.b4.render(ff5);
        this.h1.render(ff5);
        this.h2.render(ff5);
        this.body.render(ff5);
        this.t21.render(ff5);
        this.tail.render(ff5);
        this.t22.render(ff5);
        this.t20.render(ff5);
        this.t19.render(ff5);
        this.t6.render(ff5);
        this.t11.render(ff5);
        this.t9.render(ff5);
        this.t4.render(ff5);
        this.t2.render(ff5);
        this.t7.render(ff5);
        this.t12.render(ff5);
        this.t10.render(ff5);
        this.t8.render(ff5);
        this.t5.render(ff5);
        this.t3.render(ff5);
        this.t1.render(ff5);
        this.t18.render(ff5);
        this.t16.render(ff5);
        this.t14.render(ff5);
        this.t13.render(ff5);
        this.t15.render(ff5);
        this.t17.render(ff5);
        this.b1.render(ff5);
        this.b2.render(ff5);
        this.b3.render(ff5);
        this.b8.render(ff5);
        this.b7.render(ff5);
        this.b6.render(ff5);
        this.b5.render(ff5);
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
