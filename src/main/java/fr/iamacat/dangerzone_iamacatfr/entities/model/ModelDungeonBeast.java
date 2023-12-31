
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DungeonBeast;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;

public class ModelDungeonBeast extends ModelBase {

    private float wingspeed;
    ModelRenderer tail7;
    ModelRenderer head3;
    ModelRenderer neck;
    ModelRenderer lhornbase;
    ModelRenderer leye;
    ModelRenderer ljaw3;
    ModelRenderer ljaw1;
    ModelRenderer ljaw2;
    ModelRenderer rjaw1;
    ModelRenderer rjaw2;
    ModelRenderer rjaw3;
    ModelRenderer t1s3;
    ModelRenderer rshoulder;
    ModelRenderer rheel;
    ModelRenderer lshoulder;
    ModelRenderer rleg1;
    ModelRenderer rleg2;
    ModelRenderer lleg1;
    ModelRenderer lleg2;
    ModelRenderer rfoot;
    ModelRenderer ltoe3;
    ModelRenderer ltoe2;
    ModelRenderer ltoe1;
    ModelRenderer head1;
    ModelRenderer horn2;
    ModelRenderer rhornbase;
    ModelRenderer rh1;
    ModelRenderer lh1;
    ModelRenderer lh2;
    ModelRenderer rh2;
    ModelRenderer rh3;
    ModelRenderer lh3;
    ModelRenderer lh4;
    ModelRenderer rh4;
    ModelRenderer horn1;
    ModelRenderer t2s3;
    ModelRenderer tail3;
    ModelRenderer t4s1;
    ModelRenderer t6s1;
    ModelRenderer tail6;
    ModelRenderer body;
    ModelRenderer bodys1;
    ModelRenderer bodys2;
    ModelRenderer tail1;
    ModelRenderer bodys3;
    ModelRenderer t1s1;
    ModelRenderer t1s2;
    ModelRenderer tail2;
    ModelRenderer t3s2;
    ModelRenderer t2s2;
    ModelRenderer t2s1;
    ModelRenderer t3s1;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer t5s1;
    ModelRenderer head2;
    ModelRenderer reye;
    ModelRenderer lfoot;
    ModelRenderer rfoot2;
    ModelRenderer lfoot2;
    ModelRenderer lheel;
    ModelRenderer rtoe3;
    ModelRenderer rtoe2;
    ModelRenderer rtoe1;

    public ModelDungeonBeast(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.tail7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -0.5f, -0.5333334f, 3, 1, 1);
        this.tail7.setRotationPoint(-24.0f, 23.5f, 0.0f);
        this.tail7.setTextureSize(64, 32);
        this.tail7.mirror = true;
        this.setRotation(this.tail7, 0.0f, 0.0f, 3.141593f);
        (this.head3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.0f, -2.466667f, 4.3f, 4, 4, 2);
        this.head3.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.head3.setTextureSize(64, 32);
        this.head3.mirror = true;
        this.setRotation(this.head3, 0.0f, 0.8028515f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, -2.533333f, 3, 3, 5);
        this.neck.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.neck.setTextureSize(64, 32);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.0f, 0.0f, -0.1745329f);
        (this.lhornbase = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.5f, -3.0f, 0.5f, 3, 1, 2);
        this.lhornbase.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.lhornbase.setTextureSize(64, 32);
        this.lhornbase.mirror = true;
        this.setRotation(this.lhornbase, 0.0f, 0.0f, 0.0f);
        (this.leye = new ModelRenderer((ModelBase) this, 14, 15)).addBox(3.0f, -1.466667f, 3.3f, 2, 1, 2);
        this.leye.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.leye.setTextureSize(64, 32);
        this.leye.mirror = true;
        this.setRotation(this.leye, 0.0f, 0.4363323f, 0.0f);
        (this.ljaw3 = new ModelRenderer((ModelBase) this, 10, 28)).addBox(3.5f, 0.0f, 1.5f, 1, 1, 1);
        this.ljaw3.setRotationPoint(10.0f, 16.0f, 2.0f);
        this.ljaw3.setTextureSize(64, 32);
        this.ljaw3.mirror = true;
        this.setRotation(this.ljaw3, 0.0f, 0.5235988f, 0.0f);
        (this.ljaw1 = new ModelRenderer((ModelBase) this, 10, 20)).addBox(0.0f, 0.0f, -1.466667f, 3, 1, 2);
        this.ljaw1.setRotationPoint(10.0f, 16.0f, 2.0f);
        this.ljaw1.setTextureSize(64, 32);
        this.ljaw1.mirror = true;
        this.setRotation(this.ljaw1, 0.0f, -0.3490659f, 0.0f);
        (this.ljaw2 = new ModelRenderer((ModelBase) this, 10, 24)).addBox(2.0f, 0.0f, 0.3f, 2, 1, 2);
        this.ljaw2.setRotationPoint(10.0f, 16.0f, 2.0f);
        this.ljaw2.setTextureSize(64, 32);
        this.ljaw2.mirror = true;
        this.setRotation(this.ljaw2, 0.0f, 0.3490659f, 0.0f);
        (this.rjaw1 = new ModelRenderer((ModelBase) this, 10, 20)).addBox(0.0f, 0.0f, -0.4666667f, 3, 1, 2);
        this.rjaw1.setRotationPoint(10.0f, 16.0f, -2.0f);
        this.rjaw1.setTextureSize(64, 32);
        this.rjaw1.mirror = true;
        this.setRotation(this.rjaw1, 0.0f, 0.3490659f, 0.0f);
        (this.rjaw2 = new ModelRenderer((ModelBase) this, 10, 24)).addBox(2.0f, 0.0f, -2.3f, 2, 1, 2);
        this.rjaw2.setRotationPoint(10.0f, 16.0f, -2.0f);
        this.rjaw2.setTextureSize(64, 32);
        this.rjaw2.mirror = true;
        this.setRotation(this.rjaw2, 0.0f, -0.3490659f, 0.0f);
        (this.rjaw3 = new ModelRenderer((ModelBase) this, 10, 28)).addBox(3.5f, 0.0f, -2.5f, 1, 1, 1);
        this.rjaw3.setRotationPoint(10.0f, 16.0f, -2.0f);
        this.rjaw3.setTextureSize(64, 32);
        this.rjaw3.mirror = true;
        this.setRotation(this.rjaw3, 0.0f, -0.5235988f, 0.0f);
        (this.t1s3 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(-3.0f, -7.0f, -0.5f, 1, 4, 1);
        this.t1s3.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.t1s3.setTextureSize(64, 32);
        this.t1s3.mirror = true;
        this.setRotation(this.t1s3, 0.0f, 0.0f, -0.8726646f);
        (this.rshoulder = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.0f, -2.2f, -5.0f, 4, 4, 2);
        this.rshoulder.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.rshoulder.setTextureSize(64, 32);
        this.rshoulder.mirror = true;
        this.setRotation(this.rshoulder, 0.0f, 0.0f, 0.0f);
        (this.rheel = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.3f, 0.3f, 6.0f, 1, 1, 1);
        this.rheel.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rheel.setTextureSize(64, 32);
        this.rheel.mirror = true;
        this.setRotation(this.rheel, -1.570796f, 0.0f, 0.0f);
        (this.lshoulder = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.0f, -2.2f, 3.0f, 4, 4, 2);
        this.lshoulder.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.lshoulder.setTextureSize(64, 32);
        this.lshoulder.mirror = true;
        this.setRotation(this.lshoulder, 0.0f, 0.0f, 0.0f);
        (this.rleg1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.466667f, -2.0f, -5.0f, 3, 3, 6);
        this.rleg1.setRotationPoint(3.0f, 15.0f, -4.0f);
        this.rleg1.setTextureSize(64, 32);
        this.rleg1.mirror = true;
        this.setRotation(this.rleg1, 0.6981317f, 0.0f, 0.0f);
        (this.rleg2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -0.2f, 0.0f, 2, 2, 6);
        this.rleg2.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rleg2.setTextureSize(64, 32);
        this.rleg2.mirror = true;
        this.setRotation(this.rleg2, -1.570796f, 0.0f, 0.0f);
        (this.lleg1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.466667f, -2.0f, -1.0f, 3, 3, 6);
        this.lleg1.setRotationPoint(3.0f, 15.0f, 4.0f);
        this.lleg1.setTextureSize(64, 32);
        this.lleg1.mirror = true;
        this.setRotation(this.lleg1, -0.6981317f, 0.0f, 0.0f);
        (this.lleg2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -1.8f, 0.0f, 2, 2, 6);
        this.lleg2.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.lleg2.setTextureSize(64, 32);
        this.lleg2.mirror = true;
        this.setRotation(this.lleg2, -1.570796f, 0.0f, 0.0f);
        (this.rfoot = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, -0.7f, 5.0f, 3, 3, 2);
        this.rfoot.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rfoot.setTextureSize(64, 32);
        this.rfoot.mirror = true;
        this.setRotation(this.rfoot, -1.570796f, 0.0f, 0.0f);
        (this.ltoe3 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-3.7f, -1.5f, 4.5f, 1, 1, 2);
        this.ltoe3.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.ltoe3.setTextureSize(64, 32);
        this.ltoe3.mirror = true;
        this.setRotation(this.ltoe3, -1.570796f, 0.7853982f, -0.7853982f);
        (this.ltoe2 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-3.0f, -1.3f, 5.2f, 1, 1, 2);
        this.ltoe2.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.ltoe2.setTextureSize(64, 32);
        this.ltoe2.mirror = true;
        this.setRotation(this.ltoe2, -1.570796f, 0.0f, -0.7853982f);
        (this.ltoe1 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-3.0f, -0.6f, 5.2f, 1, 1, 2);
        this.ltoe1.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.ltoe1.setTextureSize(64, 32);
        this.ltoe1.mirror = true;
        this.setRotation(this.ltoe1, -1.570796f, -0.7853982f, -0.7853982f);
        (this.head1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.0f, -2.466667f, -3.0f, 4, 4, 6);
        this.head1.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.head1.setTextureSize(64, 32);
        this.head1.mirror = true;
        this.setRotation(this.head1, 0.0f, 0.0f, 0.0f);
        (this.horn2 = new ModelRenderer((ModelBase) this, 75, 6)).addBox(-7.0f, -4.0f, -0.5f, 1, 2, 1);
        this.horn2.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.horn2.setTextureSize(64, 32);
        this.horn2.mirror = true;
        this.setRotation(this.horn2, 0.0f, 0.0f, 2.181662f);
        (this.rhornbase = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.5f, -3.0f, -2.5f, 3, 1, 2);
        this.rhornbase.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.rhornbase.setTextureSize(64, 32);
        this.rhornbase.mirror = true;
        this.setRotation(this.rhornbase, 0.0f, 0.0f, 0.0f);
        (this.rh1 = new ModelRenderer((ModelBase) this, 0, 28)).addBox(4.0f, -3.0f, -2.5f, 2, 3, 2);
        this.rh1.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.rh1.setTextureSize(64, 32);
        this.rh1.mirror = true;
        this.setRotation(this.rh1, 0.0f, 0.0f, -0.5235988f);
        (this.lh1 = new ModelRenderer((ModelBase) this, 0, 28)).addBox(4.0f, -3.0f, 0.5f, 2, 3, 2);
        this.lh1.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.lh1.setTextureSize(64, 32);
        this.lh1.mirror = true;
        this.setRotation(this.lh1, 0.0f, 0.0f, -0.5235988f);
        (this.lh2 = new ModelRenderer((ModelBase) this, 0, 23)).addBox(5.0f, -4.0f, 1.0f, 1, 3, 1);
        this.lh2.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.lh2.setTextureSize(64, 32);
        this.lh2.mirror = true;
        this.setRotation(this.lh2, 0.0f, 0.0f, -0.8726646f);
        (this.rh2 = new ModelRenderer((ModelBase) this, 0, 23)).addBox(5.0f, -4.0f, -2.0f, 1, 3, 1);
        this.rh2.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.rh2.setTextureSize(64, 32);
        this.rh2.mirror = true;
        this.setRotation(this.rh2, 0.0f, 0.0f, -0.8726646f);
        (this.rh3 = new ModelRenderer((ModelBase) this, 0, 19)).addBox(6.1f, -2.4f, -2.0f, 1, 2, 1);
        this.rh3.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.rh3.setTextureSize(64, 32);
        this.rh3.mirror = true;
        this.setRotation(this.rh3, 0.0f, 0.0f, -1.396263f);
        (this.lh3 = new ModelRenderer((ModelBase) this, 0, 19)).addBox(6.1f, -2.4f, 1.0f, 1, 2, 1);
        this.lh3.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.lh3.setTextureSize(64, 32);
        this.lh3.mirror = true;
        this.setRotation(this.lh3, 0.0f, 0.0f, -1.396263f);
        (this.lh4 = new ModelRenderer((ModelBase) this, 0, 15)).addBox(6.5f, -1.8f, 1.0f, 1, 2, 1);
        this.lh4.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.lh4.setTextureSize(64, 32);
        this.lh4.mirror = true;
        this.setRotation(this.lh4, 0.0f, 0.0f, -1.745329f);
        (this.rh4 = new ModelRenderer((ModelBase) this, 0, 15)).addBox(6.5f, -1.8f, -2.0f, 1, 2, 1);
        this.rh4.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.rh4.setTextureSize(64, 32);
        this.rh4.mirror = true;
        this.setRotation(this.rh4, 0.0f, 0.0f, -1.745329f);
        (this.horn1 = new ModelRenderer((ModelBase) this, 75, 6)).addBox(-8.0f, -2.5f, -0.5f, 1, 2, 1);
        this.horn1.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.horn1.setTextureSize(64, 32);
        this.horn1.mirror = true;
        this.setRotation(this.horn1, 0.0f, 0.0f, 2.617994f);
        (this.t2s3 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(3.0f, 3.466667f, -0.5333334f, 1, 3, 1);
        this.t2s3.setRotationPoint(-6.0f, 17.0f, 0.0f);
        this.t2s3.setTextureSize(64, 32);
        this.t2s3.mirror = true;
        this.setRotation(this.t2s3, 0.0f, 0.0f, 2.007129f);
        (this.tail3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -1.5f, -2.5f, 6, 3, 5);
        this.tail3.setRotationPoint(-10.0f, 20.0f, 0.0f);
        this.tail3.setTextureSize(64, 32);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, 0.0f, 0.0f, 2.530727f);
        (this.t4s1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(0.5333334f, 1.533333f, -0.4666667f, 1, 2, 1);
        this.t4s1.setRotationPoint(-14.0f, 22.8f, 0.0f);
        this.t4s1.setTextureSize(64, 32);
        this.t4s1.mirror = true;
        this.setRotation(this.t4s1, 0.0f, 0.0f, 2.356194f);
        (this.t6s1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(0.0f, 0.5f, -0.5f, 1, 1, 1);
        this.t6s1.setRotationPoint(-21.0f, 23.5f, 0.0f);
        this.t6s1.setTextureSize(64, 32);
        this.t6s1.mirror = true;
        this.setRotation(this.t6s1, 0.0f, 0.0f, 2.356194f);
        (this.tail6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -0.5f, -1.0f, 4, 1, 2);
        this.tail6.setRotationPoint(-21.0f, 23.5f, 0.0f);
        this.tail6.setTextureSize(64, 32);
        this.tail6.mirror = true;
        this.setRotation(this.tail6, 0.0f, 0.0f, 3.141593f);
        (this.body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -3.0f, -4.0f, 7, 6, 8);
        this.body.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.bodys1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(6.0f, -3.0f, -0.5f, 1, 4, 1);
        this.bodys1.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.bodys1.setTextureSize(64, 32);
        this.bodys1.mirror = true;
        this.setRotation(this.bodys1, 0.0f, 0.0f, -0.5235988f);
        (this.bodys2 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(4.0f, -4.0f, -0.5f, 1, 4, 1);
        this.bodys2.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.bodys2.setTextureSize(64, 32);
        this.bodys2.mirror = true;
        this.setRotation(this.bodys2, 0.0f, 0.0f, -0.5235988f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -2.533333f, -3.5f, 7, 5, 7);
        this.tail1.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.tail1.setTextureSize(64, 32);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 2.792527f);
        (this.bodys3 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(2.0f, -5.0f, -0.5f, 1, 4, 1);
        this.bodys3.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.bodys3.setTextureSize(64, 32);
        this.bodys3.mirror = true;
        this.setRotation(this.bodys3, 0.0f, 0.0f, -0.5235988f);
        (this.t1s1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(1.0f, -5.0f, -0.5f, 1, 4, 1);
        this.t1s1.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.t1s1.setTextureSize(64, 32);
        this.t1s1.mirror = true;
        this.setRotation(this.t1s1, 0.0f, 0.0f, -0.8726646f);
        (this.t1s2 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(-1.0f, -6.0f, -0.5f, 1, 4, 1);
        this.t1s2.setRotationPoint(-1.0f, 15.0f, 0.0f);
        this.t1s2.setTextureSize(64, 32);
        this.t1s2.mirror = true;
        this.setRotation(this.t1s2, 0.0f, 0.0f, -0.8726646f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -2.0f, -3.0f, 7, 4, 6);
        this.tail2.setRotationPoint(-6.0f, 17.0f, 0.0f);
        this.tail2.setTextureSize(64, 32);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 2.530727f);
        (this.t3s2 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(2.5f, 2.466667f, -0.5333334f, 1, 3, 1);
        this.t3s2.setRotationPoint(-10.0f, 20.0f, 0.0f);
        this.t3s2.setTextureSize(64, 32);
        this.t3s2.mirror = true;
        this.setRotation(this.t3s2, 0.0f, 0.0f, 2.007129f);
        (this.t2s2 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(1.0f, 2.466667f, -0.5333334f, 1, 3, 1);
        this.t2s2.setRotationPoint(-6.0f, 17.0f, 0.0f);
        this.t2s2.setTextureSize(64, 32);
        this.t2s2.mirror = true;
        this.setRotation(this.t2s2, 0.0f, 0.0f, 2.007129f);
        (this.t2s1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(-1.0f, 1.466667f, -0.5333334f, 1, 3, 1);
        this.t2s1.setRotationPoint(-6.0f, 17.0f, 0.0f);
        this.t2s1.setTextureSize(64, 32);
        this.t2s1.mirror = true;
        this.setRotation(this.t2s1, 0.0f, 0.0f, 2.007129f);
        (this.t3s1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(0.5f, 1.466667f, -0.5333334f, 1, 3, 1);
        this.t3s1.setRotationPoint(-10.0f, 20.0f, 0.0f);
        this.t3s1.setTextureSize(64, 32);
        this.t3s1.mirror = true;
        this.setRotation(this.t3s1, 0.0f, 0.0f, 2.007129f);
        (this.tail4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -1.0f, -2.0f, 5, 2, 4);
        this.tail4.setRotationPoint(-14.0f, 22.8f, 0.0f);
        this.tail4.setTextureSize(64, 32);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, 0.0f, 0.0f, 3.054326f);
        (this.tail5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -0.5f, -1.5f, 4, 1, 3);
        this.tail5.setRotationPoint(-18.0f, 23.2f, 0.0f);
        this.tail5.setTextureSize(64, 32);
        this.tail5.mirror = true;
        this.setRotation(this.tail5, 0.0f, 0.0f, 3.054326f);
        (this.t5s1 = new ModelRenderer((ModelBase) this, 75, 0)).addBox(0.0f, 0.5f, -0.5f, 1, 2, 1);
        this.t5s1.setRotationPoint(-18.0f, 23.2f, 0.0f);
        this.t5s1.setTextureSize(64, 32);
        this.t5s1.mirror = true;
        this.setRotation(this.t5s1, 0.0f, 0.0f, 2.356194f);
        (this.head2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(2.0f, -2.466667f, -6.3f, 4, 4, 2);
        this.head2.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.head2.setTextureSize(64, 32);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0f, -0.8028515f, 0.0f);
        (this.reye = new ModelRenderer((ModelBase) this, 5, 15)).addBox(3.0f, -1.466667f, -5.3f, 2, 1, 2);
        this.reye.setRotationPoint(5.0f, 15.0f, 0.0f);
        this.reye.setTextureSize(64, 32);
        this.reye.mirror = true;
        this.setRotation(this.reye, 0.0f, -0.4363323f, 0.0f);
        (this.lfoot = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.5f, -2.3f, 5.0f, 3, 3, 2);
        this.lfoot.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.lfoot.setTextureSize(64, 32);
        this.lfoot.mirror = true;
        this.setRotation(this.lfoot, -1.570796f, 0.0f, 0.0f);
        (this.rfoot2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.6f, -1.5f, 5.0f, 2, 2, 2);
        this.rfoot2.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rfoot2.setTextureSize(64, 32);
        this.rfoot2.mirror = true;
        this.setRotation(this.rfoot2, -1.570796f, 0.7853982f, 0.0f);
        (this.lfoot2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.7f, -0.5f, 5.0f, 2, 2, 2);
        this.lfoot2.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.lfoot2.setTextureSize(64, 32);
        this.lfoot2.mirror = true;
        this.setRotation(this.lfoot2, -1.570796f, -0.7853982f, 0.0f);
        (this.lheel = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.3f, -1.3f, 6.0f, 1, 1, 1);
        this.lheel.setRotationPoint(3.0f, 17.0f, 7.0f);
        this.lheel.setTextureSize(64, 32);
        this.lheel.mirror = true;
        this.setRotation(this.lheel, -1.570796f, 0.0f, 0.0f);
        (this.rtoe3 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-3.7f, 0.6f, 4.5f, 1, 1, 2);
        this.rtoe3.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rtoe3.setTextureSize(64, 32);
        this.rtoe3.mirror = true;
        this.setRotation(this.rtoe3, -1.570796f, -0.7853982f, -0.7853982f);
        (this.rtoe2 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-3.0f, 0.3f, 5.2f, 1, 1, 2);
        this.rtoe2.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rtoe2.setTextureSize(64, 32);
        this.rtoe2.mirror = true;
        this.setRotation(this.rtoe2, -1.570796f, 0.0f, -0.7853982f);
        (this.rtoe1 = new ModelRenderer((ModelBase) this, 32, 0)).addBox(-3.0f, -0.6f, 5.2f, 1, 1, 2);
        this.rtoe1.setRotationPoint(3.0f, 17.0f, -7.0f);
        this.rtoe1.setTextureSize(64, 32);
        this.rtoe1.mirror = true;
        this.setRotation(this.rtoe1, -1.570796f, 0.7853982f, -0.7853982f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final DungeonBeast e = (DungeonBeast) entity;
        RenderInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float upangle = 0.0f;
        float nextangle = 0.0f;
        float tailamp = 0.0f;
        final float pi4 = 0.39269876f;
        newangle = MathHelper.cos(f2 * 1.4f * this.wingspeed) * 3.1415927f * 0.22f * f1;
        final ModelRenderer rleg1 = this.rleg1;
        final ModelRenderer rleg2 = this.rleg2;
        final ModelRenderer rfoot = this.rfoot;
        final ModelRenderer rfoot2 = this.rfoot2;
        final ModelRenderer rheel = this.rheel;
        final float rotateAngleZ = newangle;
        rheel.rotateAngleZ = rotateAngleZ;
        rfoot2.rotateAngleZ = rotateAngleZ;
        rfoot.rotateAngleZ = rotateAngleZ;
        rleg2.rotateAngleZ = rotateAngleZ;
        rleg1.rotateAngleZ = rotateAngleZ;
        this.rtoe2.rotateAngleZ = -0.785f + newangle;
        final ModelRenderer lleg1 = this.lleg1;
        final ModelRenderer lleg2 = this.lleg2;
        final ModelRenderer lfoot = this.lfoot;
        final ModelRenderer lfoot2 = this.lfoot2;
        final ModelRenderer lheel = this.lheel;
        final float rotateAngleZ2 = -newangle;
        lheel.rotateAngleZ = rotateAngleZ2;
        lfoot2.rotateAngleZ = rotateAngleZ2;
        lfoot.rotateAngleZ = rotateAngleZ2;
        lleg2.rotateAngleZ = rotateAngleZ2;
        lleg1.rotateAngleZ = rotateAngleZ2;
        this.ltoe2.rotateAngleZ = -0.785f - newangle;
        this.bodys1.rotateAngleX = MathHelper.cos(f2 * 0.5f * this.wingspeed) * 3.1415927f * 0.07f;
        this.bodys2.rotateAngleX = MathHelper.cos(f2 * 0.5f * this.wingspeed + pi4) * 3.1415927f * 0.07f;
        this.bodys3.rotateAngleX = MathHelper.cos(f2 * 0.5f * this.wingspeed + 2.0f * pi4) * 3.1415927f * 0.07f;
        this.t1s1.rotateAngleX = MathHelper.cos(f2 * 0.5f * this.wingspeed + 3.0f * pi4) * 3.1415927f * 0.07f;
        this.t1s2.rotateAngleX = MathHelper.cos(f2 * 0.5f * this.wingspeed + 4.0f * pi4) * 3.1415927f * 0.07f;
        this.t1s3.rotateAngleX = MathHelper.cos(f2 * 0.5f * this.wingspeed + 5.0f * pi4) * 3.1415927f * 0.07f;
        this.t2s1.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 6.0f * pi4) * 3.1415927f * 0.07f;
        this.t2s2.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 7.0f * pi4) * 3.1415927f * 0.07f;
        this.t2s3.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 8.0f * pi4) * 3.1415927f * 0.07f;
        this.t3s1.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 9.0f * pi4) * 3.1415927f * 0.07f;
        this.t3s2.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 10.0f * pi4) * 3.1415927f * 0.07f;
        this.t4s1.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 11.0f * pi4) * 3.1415927f * 0.07f;
        this.t5s1.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 12.0f * pi4) * 3.1415927f * 0.07f;
        this.t6s1.rotateAngleX = -MathHelper.cos(f2 * 0.5f * this.wingspeed + 13.0f * pi4) * 3.1415927f * 0.07f;
        if (e.getAttacking() == 0) {
            tailamp = f1;
        } else {
            tailamp = 1.25f;
        }
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.1415927f * 0.25f * tailamp;
        this.tail1.rotateAngleY = newangle * 0.25f;
        final ModelRenderer t1s1 = this.t1s1;
        final ModelRenderer t1s2 = this.t1s2;
        final ModelRenderer t1s3 = this.t1s3;
        final float rotateAngleY = this.tail1.rotateAngleY;
        t1s3.rotateAngleY = rotateAngleY;
        t1s2.rotateAngleY = rotateAngleY;
        t1s1.rotateAngleY = rotateAngleY;
        this.tail2.rotateAngleY = newangle * 0.5f;
        this.tail2.rotationPointX = this.tail1.rotationPointX - (float) Math.cos(this.tail1.rotateAngleY) * 6.0f;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ - (float) Math.sin(this.tail1.rotateAngleY) * 6.0f;
        final ModelRenderer t2s1 = this.t2s1;
        final ModelRenderer t2s2 = this.t2s2;
        final ModelRenderer t2s3 = this.t2s3;
        final float rotateAngleY2 = this.tail2.rotateAngleY;
        t2s3.rotateAngleY = rotateAngleY2;
        t2s2.rotateAngleY = rotateAngleY2;
        t2s1.rotateAngleY = rotateAngleY2;
        final ModelRenderer t2s4 = this.t2s1;
        final ModelRenderer t2s5 = this.t2s2;
        final ModelRenderer t2s6 = this.t2s3;
        final float rotationPointZ = this.tail2.rotationPointZ;
        t2s6.rotationPointZ = rotationPointZ;
        t2s5.rotationPointZ = rotationPointZ;
        t2s4.rotationPointZ = rotationPointZ;
        final ModelRenderer t2s7 = this.t2s1;
        final ModelRenderer t2s8 = this.t2s2;
        final ModelRenderer t2s9 = this.t2s3;
        final float rotationPointX = this.tail2.rotationPointX;
        t2s9.rotationPointX = rotationPointX;
        t2s8.rotationPointX = rotationPointX;
        t2s7.rotationPointX = rotationPointX;
        this.tail3.rotateAngleY = newangle * 0.75f;
        this.tail3.rotationPointX = this.tail2.rotationPointX - (float) Math.cos(this.tail2.rotateAngleY) * 5.0f;
        this.tail3.rotationPointZ = this.tail2.rotationPointZ - (float) Math.sin(this.tail2.rotateAngleY) * 5.0f;
        final ModelRenderer t3s1 = this.t3s1;
        final ModelRenderer t3s2 = this.t3s2;
        final float rotateAngleY3 = this.tail3.rotateAngleY;
        t3s2.rotateAngleY = rotateAngleY3;
        t3s1.rotateAngleY = rotateAngleY3;
        final ModelRenderer t3s3 = this.t3s1;
        final ModelRenderer t3s4 = this.t3s2;
        final float rotationPointZ2 = this.tail3.rotationPointZ;
        t3s4.rotationPointZ = rotationPointZ2;
        t3s3.rotationPointZ = rotationPointZ2;
        final ModelRenderer t3s5 = this.t3s1;
        final ModelRenderer t3s6 = this.t3s2;
        final float rotationPointX2 = this.tail3.rotationPointX;
        t3s6.rotationPointX = rotationPointX2;
        t3s5.rotationPointX = rotationPointX2;
        this.tail4.rotateAngleY = newangle;
        this.tail4.rotationPointX = this.tail3.rotationPointX - (float) Math.cos(this.tail3.rotateAngleY) * 4.5f;
        this.tail4.rotationPointZ = this.tail3.rotationPointZ - (float) Math.sin(this.tail3.rotateAngleY) * 4.5f;
        this.t4s1.rotateAngleY = this.tail4.rotateAngleY;
        this.t4s1.rotationPointZ = this.tail4.rotationPointZ;
        this.t4s1.rotationPointX = this.tail4.rotationPointX;
        this.tail5.rotateAngleY = newangle * 1.25f;
        this.tail5.rotationPointX = this.tail4.rotationPointX - (float) Math.cos(this.tail4.rotateAngleY) * 4.0f;
        this.tail5.rotationPointZ = this.tail4.rotationPointZ - (float) Math.sin(this.tail4.rotateAngleY) * 4.0f;
        this.t5s1.rotateAngleY = this.tail5.rotateAngleY;
        this.t5s1.rotationPointZ = this.tail5.rotationPointZ;
        this.t5s1.rotationPointX = this.tail5.rotationPointX;
        this.tail6.rotateAngleY = newangle * 1.5f;
        this.tail6.rotationPointX = this.tail5.rotationPointX - (float) Math.cos(this.tail5.rotateAngleY) * 3.0f;
        this.tail6.rotationPointZ = this.tail5.rotationPointZ - (float) Math.sin(this.tail5.rotateAngleY) * 3.0f;
        this.t6s1.rotateAngleY = this.tail6.rotateAngleY;
        this.t6s1.rotationPointZ = this.tail6.rotationPointZ;
        this.t6s1.rotationPointX = this.tail6.rotationPointX;
        this.tail7.rotateAngleY = newangle * 1.75f;
        this.tail7.rotationPointX = this.tail6.rotationPointX - (float) Math.cos(this.tail6.rotateAngleY) * 3.0f;
        this.tail7.rotationPointZ = this.tail6.rotationPointZ - (float) Math.sin(this.tail6.rotateAngleY) * 3.0f;
        r = e.getRenderInfo();
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            if (e.getAttacking() == 0) {
                r.ri1 = e.worldObj.rand.nextInt(15);
                r.ri2 = e.worldObj.rand.nextInt(15);
            } else {
                r.ri1 = 0;
                r.ri2 = 0;
            }
        }
        if (r.ri1 == 0) {
            this.ljaw1.rotateAngleY = -0.349f + newangle;
            this.ljaw2.rotateAngleY = 0.349f + newangle;
            this.ljaw3.rotateAngleY = 0.523f + newangle;
            this.rjaw1.rotateAngleY = 0.349f - newangle;
            this.rjaw2.rotateAngleY = -0.349f - newangle;
            this.rjaw3.rotateAngleY = -0.523f - newangle;
        } else {
            this.ljaw1.rotateAngleY = -0.349f;
            this.ljaw2.rotateAngleY = 0.349f;
            this.ljaw3.rotateAngleY = 0.523f;
            this.rjaw1.rotateAngleY = 0.349f;
            this.rjaw2.rotateAngleY = -0.349f;
            this.rjaw3.rotateAngleY = -0.523f;
        }
        e.setRenderInfo(r);
        GL11.glRotatef(90.0f, 0.0f, 1.0f, 0.0f);
        this.tail7.render(f5);
        this.head3.render(f5);
        this.neck.render(f5);
        this.lhornbase.render(f5);
        this.leye.render(f5);
        this.ljaw3.render(f5);
        this.ljaw1.render(f5);
        this.ljaw2.render(f5);
        this.rjaw1.render(f5);
        this.rjaw2.render(f5);
        this.rjaw3.render(f5);
        this.t1s3.render(f5);
        this.rshoulder.render(f5);
        this.rheel.render(f5);
        this.lshoulder.render(f5);
        this.rleg1.render(f5);
        this.rleg2.render(f5);
        this.lleg1.render(f5);
        this.lleg2.render(f5);
        this.rfoot.render(f5);
        this.ltoe2.render(f5);
        this.head1.render(f5);
        this.horn2.render(f5);
        this.rhornbase.render(f5);
        this.rh1.render(f5);
        this.lh1.render(f5);
        this.lh2.render(f5);
        this.rh2.render(f5);
        this.rh3.render(f5);
        this.lh3.render(f5);
        this.lh4.render(f5);
        this.rh4.render(f5);
        this.horn1.render(f5);
        this.t2s3.render(f5);
        this.tail3.render(f5);
        this.t4s1.render(f5);
        this.t6s1.render(f5);
        this.tail6.render(f5);
        this.body.render(f5);
        this.bodys1.render(f5);
        this.bodys2.render(f5);
        this.tail1.render(f5);
        this.bodys3.render(f5);
        this.t1s1.render(f5);
        this.t1s2.render(f5);
        this.tail2.render(f5);
        this.t3s2.render(f5);
        this.t2s2.render(f5);
        this.t2s1.render(f5);
        this.t3s1.render(f5);
        this.tail4.render(f5);
        this.tail5.render(f5);
        this.t5s1.render(f5);
        this.head2.render(f5);
        this.reye.render(f5);
        this.lfoot.render(f5);
        this.rfoot2.render(f5);
        this.lfoot2.render(f5);
        this.lheel.render(f5);
        this.rtoe2.render(f5);
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
