
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import danger.orespawn.entities.entityinstance.GiantRobot;
import danger.orespawn.entities.renderer.RenderGiantRobotInfo;

public class ModelGiantRobot extends ModelBase {

    private float wingspeed;
    private float hipy;
    ModelRenderer Hip;
    ModelRenderer Thigh;
    ModelRenderer Shin;
    ModelRenderer Foot1;
    ModelRenderer Foot2;
    ModelRenderer Foot3;
    ModelRenderer Thigh2;
    ModelRenderer Thigh3;
    ModelRenderer Back1;
    ModelRenderer Back2;
    ModelRenderer Back3;
    ModelRenderer Shoulders;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Knuckles;

    public ModelGiantRobot(final float f1) {
        this.wingspeed = 1.0f;
        this.hipy = 0.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 512;
        (this.Hip = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-4.0f, -4.0f, -15.0f, 8, 8, 30);
        this.Hip.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Hip.setTextureSize(64, 32);
        this.Hip.mirror = true;
        this.setRotation(this.Hip, 0.0f, 0.0f, 0.0f);
        (this.Thigh = new ModelRenderer((ModelBase) this, 0, 115)).addBox(-3.0f, -3.0f, -3.0f, 6, 43, 6);
        this.Thigh.setRotationPoint(0.0f, -58.0f, 0.0f);
        this.Thigh.setTextureSize(64, 32);
        this.Thigh.mirror = true;
        this.setRotation(this.Thigh, 0.0f, 0.0f, 0.0f);
        (this.Shin = new ModelRenderer((ModelBase) this, 0, 167)).addBox(-3.0f, -3.0f, -3.0f, 6, 43, 6);
        this.Shin.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Shin.setTextureSize(64, 32);
        this.Shin.mirror = true;
        this.setRotation(this.Shin, 0.0f, 0.0f, 0.0f);
        (this.Foot1 = new ModelRenderer((ModelBase) this, 0, 282)).addBox(-7.0f, 38.0f, -11.0f, 14, 4, 17);
        this.Foot1.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Foot1.setTextureSize(64, 32);
        this.Foot1.mirror = true;
        this.setRotation(this.Foot1, 0.0f, 0.0f, 0.0f);
        (this.Foot2 = new ModelRenderer((ModelBase) this, 0, 246)).addBox(-6.0f, 19.0f, -8.0f, 12, 19, 13);
        this.Foot2.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Foot2.setTextureSize(64, 32);
        this.Foot2.mirror = true;
        this.setRotation(this.Foot2, 0.0f, 0.0f, 0.0f);
        (this.Foot3 = new ModelRenderer((ModelBase) this, 0, 219)).addBox(-5.0f, 5.0f, -5.0f, 10, 14, 9);
        this.Foot3.setRotationPoint(0.0f, -18.0f, 0.0f);
        this.Foot3.setTextureSize(64, 32);
        this.Foot3.mirror = true;
        this.setRotation(this.Foot3, 0.0f, 0.0f, 0.0f);
        (this.Thigh2 = new ModelRenderer((ModelBase) this, 0, 43)).addBox(-7.0f, -8.0f, -7.0f, 14, 24, 14);
        this.Thigh2.setRotationPoint(0.0f, -58.0f, 0.0f);
        this.Thigh2.setTextureSize(64, 32);
        this.Thigh2.mirror = true;
        this.setRotation(this.Thigh2, 0.0f, 0.0f, 0.0f);
        (this.Thigh3 = new ModelRenderer((ModelBase) this, 0, 84)).addBox(-5.0f, 16.0f, -5.0f, 10, 17, 10);
        this.Thigh3.setRotationPoint(0.0f, -58.0f, 0.0f);
        this.Thigh3.setTextureSize(64, 32);
        this.Thigh3.mirror = true;
        this.setRotation(this.Thigh3, 0.0f, 0.0f, 0.0f);
        (this.Back1 = new ModelRenderer((ModelBase) this, 125, 138)).addBox(-4.0f, -20.0f, -4.0f, 8, 24, 8);
        this.Back1.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Back1.setTextureSize(64, 32);
        this.Back1.mirror = true;
        this.setRotation(this.Back1, 0.0f, 0.0f, 0.0f);
        (this.Back2 = new ModelRenderer((ModelBase) this, 125, 95)).addBox(-13.0f, -42.0f, -10.0f, 26, 24, 16);
        this.Back2.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Back2.setTextureSize(64, 32);
        this.Back2.mirror = true;
        this.setRotation(this.Back2, 0.0f, 0.0f, 0.0f);
        (this.Back3 = new ModelRenderer((ModelBase) this, 125, 43)).addBox(-17.0f, -68.0f, -13.0f, 34, 26, 20);
        this.Back3.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Back3.setTextureSize(64, 32);
        this.Back3.mirror = true;
        this.setRotation(this.Back3, 0.0f, 0.0f, 0.0f);
        (this.Shoulders = new ModelRenderer((ModelBase) this, 60, 200)).addBox(-22.0f, -64.0f, -4.0f, 44, 8, 8);
        this.Shoulders.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Shoulders.setTextureSize(64, 32);
        this.Shoulders.mirror = true;
        this.setRotation(this.Shoulders, 0.0f, 0.0f, 0.0f);
        (this.Neck = new ModelRenderer((ModelBase) this, 125, 29)).addBox(-4.0f, -70.0f, -4.0f, 8, 2, 8);
        this.Neck.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Neck.setTextureSize(64, 32);
        this.Neck.mirror = true;
        this.setRotation(this.Neck, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 127, 0)).addBox(-7.0f, -82.0f, -7.0f, 14, 12, 14);
        this.Head.setRotationPoint(0.0f, -60.0f, 0.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Arm1 = new ModelRenderer((ModelBase) this, 77, 250)).addBox(-6.0f, -6.0f, -6.0f, 12, 21, 12);
        this.Arm1.setRotationPoint(28.0f, -120.0f, 0.0f);
        this.Arm1.setTextureSize(64, 32);
        this.Arm1.mirror = true;
        this.setRotation(this.Arm1, 0.0f, 0.0f, 0.0f);
        (this.Arm2 = new ModelRenderer((ModelBase) this, 73, 300)).addBox(-4.0f, 15.0f, -4.0f, 8, 24, 8);
        this.Arm2.setRotationPoint(28.0f, -120.0f, 0.0f);
        this.Arm2.setTextureSize(64, 32);
        this.Arm2.mirror = true;
        this.setRotation(this.Arm2, 0.0f, 0.0f, 0.0f);
        (this.Arm3 = new ModelRenderer((ModelBase) this, 61, 350)).addBox(-3.0f, -3.0f, -3.0f, 6, 33, 6);
        this.Arm3.setRotationPoint(28.0f, -81.0f, 0.0f);
        this.Arm3.setTextureSize(64, 32);
        this.Arm3.mirror = true;
        this.setRotation(this.Arm3, 0.0f, 0.0f, 0.0f);
        (this.Knuckles = new ModelRenderer((ModelBase) this, 56, 400)).addBox(-7.0f, 30.0f, -5.0f, 14, 12, 10);
        this.Knuckles.setRotationPoint(28.0f, -81.0f, 0.0f);
        this.Knuckles.setTextureSize(256, 512);
        this.Knuckles.mirror = true;
        this.setRotation(this.Knuckles, 0.0f, 0.0f, 0.0f);
        this.hipy = this.Hip.rotationPointY;
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final GiantRobot e = (GiantRobot) entity;
        RenderGiantRobotInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderGiantRobotInfo();
        float movescale = f1 * 0.65f;
        if (movescale > 1.0f) {
            movescale = 1.0f;
        }
        r.hipxdisplayangle = (float) (Math.cos(-f2 * this.wingspeed) * 3.141592653589793
            * 0.10000000149011612
            * movescale);
        r.hipydisplayangle = (float) (Math.sin(-f2 * this.wingspeed) * 3.141592653589793
            * 0.10000000149011612
            * movescale);
        r.thighdisplayangle[0] = (float) (Math.cos(-f2 * this.wingspeed + 1.5707963267948966) * 3.141592653589793
            * 0.15000000596046448
            * movescale) - (float) (0.19634954084936207 * movescale);
        r.thighdisplayangle[1] = (float) (Math.cos(-f2 * this.wingspeed + 3.141592653589793 + 1.5707963267948966)
            * 3.141592653589793
            * 0.15000000596046448
            * movescale) - (float) (0.19634954084936207 * movescale);
        r.shindisplayangle[0] = (float) ((float) (Math.cos(-f2 * this.wingspeed + 3.141592653589793) * 3.141592653589793
            * 0.20000000298023224
            * movescale) + 0.6283185400806344 * movescale);
        r.shindisplayangle[1] = (float) ((float) (Math.cos(-f2 * this.wingspeed) * 3.141592653589793
            * 0.20000000298023224
            * movescale) + 0.6283185400806344 * movescale);
        final float newangle = (float) (Math.cos(-f2 * this.wingspeed * 2.0f) * movescale);
        this.Hip.rotationPointY = this.hipy + newangle * 4.0f;
        this.Hip.rotateAngleX = r.hipxdisplayangle;
        this.Hip.rotateAngleY = (float) (r.hipydisplayangle + 1.5707963267948966);
        this.Hip.render(f5);
        final ModelRenderer thigh = this.Thigh;
        final ModelRenderer thigh2 = this.Thigh2;
        final ModelRenderer thigh3 = this.Thigh3;
        final float rotateAngleX = r.thighdisplayangle[0];
        thigh3.rotateAngleX = rotateAngleX;
        thigh2.rotateAngleX = rotateAngleX;
        thigh.rotateAngleX = rotateAngleX;
        final ModelRenderer thigh4 = this.Thigh;
        final ModelRenderer thigh5 = this.Thigh2;
        final ModelRenderer thigh6 = this.Thigh3;
        final float rotationPointY = this.Hip.rotationPointY - (float) Math.sin(this.Hip.rotateAngleX) * 13.0f;
        thigh6.rotationPointY = rotationPointY;
        thigh5.rotationPointY = rotationPointY;
        thigh4.rotationPointY = rotationPointY;
        final ModelRenderer thigh7 = this.Thigh;
        final ModelRenderer thigh8 = this.Thigh2;
        final ModelRenderer thigh9 = this.Thigh3;
        final float rotationPointZ = this.Hip.rotationPointZ
            + (float) Math.cos(this.Hip.rotateAngleX) * (float) Math.cos(this.Hip.rotateAngleY) * 13.0f;
        thigh9.rotationPointZ = rotationPointZ;
        thigh8.rotationPointZ = rotationPointZ;
        thigh7.rotationPointZ = rotationPointZ;
        final ModelRenderer thigh10 = this.Thigh;
        final ModelRenderer thigh11 = this.Thigh2;
        final ModelRenderer thigh12 = this.Thigh3;
        final float rotationPointX = this.Hip.rotationPointX
            + (float) Math.cos(this.Hip.rotateAngleX) * (float) Math.sin(this.Hip.rotateAngleY) * 13.0f;
        thigh12.rotationPointX = rotationPointX;
        thigh11.rotationPointX = rotationPointX;
        thigh10.rotationPointX = rotationPointX;
        this.Thigh.render(f5);
        this.Thigh2.render(f5);
        this.Thigh3.render(f5);
        this.Shin.rotateAngleX = r.shindisplayangle[0];
        this.Shin.rotationPointY = this.Thigh.rotationPointY + (float) Math.cos(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointZ = this.Thigh.rotationPointZ + (float) Math.sin(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointX = this.Thigh.rotationPointX;
        this.Shin.render(f5);
        final ModelRenderer foot1 = this.Foot1;
        final ModelRenderer foot2 = this.Foot2;
        final ModelRenderer foot3 = this.Foot3;
        final float rotateAngleX2 = r.shindisplayangle[0];
        foot3.rotateAngleX = rotateAngleX2;
        foot2.rotateAngleX = rotateAngleX2;
        foot1.rotateAngleX = rotateAngleX2;
        final ModelRenderer foot4 = this.Foot1;
        final ModelRenderer foot5 = this.Foot2;
        final ModelRenderer foot6 = this.Foot3;
        final float rotationPointY2 = this.Shin.rotationPointY;
        foot6.rotationPointY = rotationPointY2;
        foot5.rotationPointY = rotationPointY2;
        foot4.rotationPointY = rotationPointY2;
        final ModelRenderer foot7 = this.Foot1;
        final ModelRenderer foot8 = this.Foot2;
        final ModelRenderer foot9 = this.Foot3;
        final float rotationPointZ2 = this.Shin.rotationPointZ;
        foot9.rotationPointZ = rotationPointZ2;
        foot8.rotationPointZ = rotationPointZ2;
        foot7.rotationPointZ = rotationPointZ2;
        final ModelRenderer foot10 = this.Foot1;
        final ModelRenderer foot11 = this.Foot2;
        final ModelRenderer foot12 = this.Foot3;
        final float rotationPointX2 = this.Shin.rotationPointX;
        foot12.rotationPointX = rotationPointX2;
        foot11.rotationPointX = rotationPointX2;
        foot10.rotationPointX = rotationPointX2;
        this.Foot1.render(f5);
        this.Foot2.render(f5);
        this.Foot3.render(f5);
        final ModelRenderer thigh13 = this.Thigh;
        final ModelRenderer thigh14 = this.Thigh2;
        final ModelRenderer thigh15 = this.Thigh3;
        final float rotateAngleX3 = r.thighdisplayangle[1];
        thigh15.rotateAngleX = rotateAngleX3;
        thigh14.rotateAngleX = rotateAngleX3;
        thigh13.rotateAngleX = rotateAngleX3;
        final ModelRenderer thigh16 = this.Thigh;
        final ModelRenderer thigh17 = this.Thigh2;
        final ModelRenderer thigh18 = this.Thigh3;
        final float rotationPointY3 = this.Hip.rotationPointY + (float) Math.sin(this.Hip.rotateAngleX) * 13.0f;
        thigh18.rotationPointY = rotationPointY3;
        thigh17.rotationPointY = rotationPointY3;
        thigh16.rotationPointY = rotationPointY3;
        final ModelRenderer thigh19 = this.Thigh;
        final ModelRenderer thigh20 = this.Thigh2;
        final ModelRenderer thigh21 = this.Thigh3;
        final float rotationPointZ3 = this.Hip.rotationPointZ
            - (float) Math.cos(this.Hip.rotateAngleX) * (float) Math.cos(this.Hip.rotateAngleY) * 13.0f;
        thigh21.rotationPointZ = rotationPointZ3;
        thigh20.rotationPointZ = rotationPointZ3;
        thigh19.rotationPointZ = rotationPointZ3;
        final ModelRenderer thigh22 = this.Thigh;
        final ModelRenderer thigh23 = this.Thigh2;
        final ModelRenderer thigh24 = this.Thigh3;
        final float rotationPointX3 = this.Hip.rotationPointX
            - (float) Math.cos(this.Hip.rotateAngleX) * (float) Math.sin(this.Hip.rotateAngleY) * 13.0f;
        thigh24.rotationPointX = rotationPointX3;
        thigh23.rotationPointX = rotationPointX3;
        thigh22.rotationPointX = rotationPointX3;
        this.Thigh.render(f5);
        this.Thigh2.render(f5);
        this.Thigh3.render(f5);
        this.Shin.rotateAngleX = r.shindisplayangle[1];
        this.Shin.rotationPointY = this.Thigh.rotationPointY + (float) Math.cos(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointZ = this.Thigh.rotationPointZ + (float) Math.sin(this.Thigh.rotateAngleX) * 40.0f;
        this.Shin.rotationPointX = this.Thigh.rotationPointX;
        this.Shin.render(f5);
        final ModelRenderer foot13 = this.Foot1;
        final ModelRenderer foot14 = this.Foot2;
        final ModelRenderer foot15 = this.Foot3;
        final float rotateAngleX4 = r.shindisplayangle[1];
        foot15.rotateAngleX = rotateAngleX4;
        foot14.rotateAngleX = rotateAngleX4;
        foot13.rotateAngleX = rotateAngleX4;
        final ModelRenderer foot16 = this.Foot1;
        final ModelRenderer foot17 = this.Foot2;
        final ModelRenderer foot18 = this.Foot3;
        final float rotationPointY4 = this.Shin.rotationPointY;
        foot18.rotationPointY = rotationPointY4;
        foot17.rotationPointY = rotationPointY4;
        foot16.rotationPointY = rotationPointY4;
        final ModelRenderer foot19 = this.Foot1;
        final ModelRenderer foot20 = this.Foot2;
        final ModelRenderer foot21 = this.Foot3;
        final float rotationPointZ4 = this.Shin.rotationPointZ;
        foot21.rotationPointZ = rotationPointZ4;
        foot20.rotationPointZ = rotationPointZ4;
        foot19.rotationPointZ = rotationPointZ4;
        final ModelRenderer foot22 = this.Foot1;
        final ModelRenderer foot23 = this.Foot2;
        final ModelRenderer foot24 = this.Foot3;
        final float rotationPointX4 = this.Shin.rotationPointX;
        foot24.rotationPointX = rotationPointX4;
        foot23.rotationPointX = rotationPointX4;
        foot22.rotationPointX = rotationPointX4;
        this.Foot1.render(f5);
        this.Foot2.render(f5);
        this.Foot3.render(f5);
        float shoulderangle = -r.hipydisplayangle;
        float a1angle;
        float a2angle = a1angle = r.thighdisplayangle[1];
        float b1angle;
        float b2angle = b1angle = r.thighdisplayangle[0];
        if (e.getAttacking() != 0) {
            shoulderangle = (float) (-(Math.sin(f2 * this.wingspeed * 2.0f) * 3.141592653589793 * 0.20000000298023224));
            a1angle = (float) ((float) (Math.sin(f2 * this.wingspeed * 2.0f) * 3.141592653589793 / 5.0)
                - 0.7853981633974483);
            a2angle = (float) (-a1angle + 3.141592653589793);
            a1angle += (float) 0.6283185307179586;
            a2angle += (float) 0.6283185307179586;
            b1angle = (float) ((float) (-(Math.sin(f2 * this.wingspeed * 2.0f) * 3.141592653589793 / 5.0))
                - 0.7853981633974483);
            b2angle = (float) (-b1angle + 3.141592653589793);
            b1angle += (float) 0.6283185307179586;
            b2angle += (float) 0.6283185307179586;
        }
        this.Back3.rotateAngleY = shoulderangle / 2.0f;
        this.Shoulders.rotateAngleY = shoulderangle;
        final ModelRenderer arm1 = this.Arm1;
        final ModelRenderer arm2 = this.Arm2;
        final float n = this.Hip.rotationPointY - 60.0f;
        arm2.rotationPointY = n;
        arm1.rotationPointY = n;
        final ModelRenderer arm3 = this.Arm1;
        final ModelRenderer arm4 = this.Arm2;
        final float n2 = this.Hip.rotationPointX + 26.0f;
        arm4.rotationPointX = n2;
        arm3.rotationPointX = n2;
        final ModelRenderer arm5 = this.Arm1;
        final ModelRenderer arm6 = this.Arm2;
        final float n3 = this.Shoulders.rotationPointZ - (float) Math.sin(this.Shoulders.rotateAngleY) * 26.0f;
        arm6.rotationPointZ = n3;
        arm5.rotationPointZ = n3;
        final ModelRenderer arm7 = this.Arm1;
        final ModelRenderer arm8 = this.Arm2;
        final float n4 = a1angle;
        arm8.rotateAngleX = n4;
        arm7.rotateAngleX = n4;
        this.Arm1.render(f5);
        this.Arm2.render(f5);
        final ModelRenderer arm9 = this.Arm3;
        final ModelRenderer knuckles = this.Knuckles;
        final float n5 = (float) (a2angle - 0.19634954084936207);
        knuckles.rotateAngleX = n5;
        arm9.rotateAngleX = n5;
        final ModelRenderer arm10 = this.Arm3;
        final ModelRenderer knuckles2 = this.Knuckles;
        final float n6 = this.Arm1.rotationPointY + (float) Math.cos(this.Arm1.rotateAngleX) * 41.0f;
        knuckles2.rotationPointY = n6;
        arm10.rotationPointY = n6;
        final ModelRenderer arm11 = this.Arm3;
        final ModelRenderer knuckles3 = this.Knuckles;
        final float n7 = this.Arm1.rotationPointZ + (float) Math.sin(this.Arm1.rotateAngleX) * 41.0f;
        knuckles3.rotationPointZ = n7;
        arm11.rotationPointZ = n7;
        final ModelRenderer arm12 = this.Arm3;
        final ModelRenderer knuckles4 = this.Knuckles;
        final float rotationPointX5 = this.Arm1.rotationPointX;
        knuckles4.rotationPointX = rotationPointX5;
        arm12.rotationPointX = rotationPointX5;
        this.Arm3.render(f5);
        this.Knuckles.render(f5);
        final ModelRenderer arm13 = this.Arm1;
        final ModelRenderer arm14 = this.Arm2;
        final float n8 = this.Hip.rotationPointY - 60.0f;
        arm14.rotationPointY = n8;
        arm13.rotationPointY = n8;
        final ModelRenderer arm15 = this.Arm1;
        final ModelRenderer arm16 = this.Arm2;
        final float n9 = this.Hip.rotationPointX - 26.0f;
        arm16.rotationPointX = n9;
        arm15.rotationPointX = n9;
        final ModelRenderer arm17 = this.Arm1;
        final ModelRenderer arm18 = this.Arm2;
        final float n10 = this.Shoulders.rotationPointZ + (float) Math.sin(this.Shoulders.rotateAngleY) * 26.0f;
        arm18.rotationPointZ = n10;
        arm17.rotationPointZ = n10;
        final ModelRenderer arm19 = this.Arm1;
        final ModelRenderer arm20 = this.Arm2;
        final float n11 = b1angle;
        arm20.rotateAngleX = n11;
        arm19.rotateAngleX = n11;
        this.Arm1.render(f5);
        this.Arm2.render(f5);
        final ModelRenderer arm21 = this.Arm3;
        final ModelRenderer knuckles5 = this.Knuckles;
        final float n12 = (float) (b2angle - 0.19634954084936207);
        knuckles5.rotateAngleX = n12;
        arm21.rotateAngleX = n12;
        final ModelRenderer arm22 = this.Arm3;
        final ModelRenderer knuckles6 = this.Knuckles;
        final float n13 = this.Arm1.rotationPointY + (float) Math.cos(this.Arm1.rotateAngleX) * 41.0f;
        knuckles6.rotationPointY = n13;
        arm22.rotationPointY = n13;
        final ModelRenderer arm23 = this.Arm3;
        final ModelRenderer knuckles7 = this.Knuckles;
        final float n14 = this.Arm1.rotationPointZ + (float) Math.sin(this.Arm1.rotateAngleX) * 41.0f;
        knuckles7.rotationPointZ = n14;
        arm23.rotationPointZ = n14;
        final ModelRenderer arm24 = this.Arm3;
        final ModelRenderer knuckles8 = this.Knuckles;
        final float rotationPointX6 = this.Arm1.rotationPointX;
        knuckles8.rotationPointX = rotationPointX6;
        arm24.rotationPointX = rotationPointX6;
        this.Arm3.render(f5);
        this.Knuckles.render(f5);
        final ModelRenderer back1 = this.Back1;
        final ModelRenderer back2 = this.Back2;
        final ModelRenderer back3 = this.Back3;
        final float rotationPointY5 = this.Hip.rotationPointY;
        back3.rotationPointY = rotationPointY5;
        back2.rotationPointY = rotationPointY5;
        back1.rotationPointY = rotationPointY5;
        final ModelRenderer shoulders = this.Shoulders;
        final ModelRenderer neck = this.Neck;
        final ModelRenderer head = this.Head;
        final float rotationPointY6 = this.Hip.rotationPointY;
        head.rotationPointY = rotationPointY6;
        neck.rotationPointY = rotationPointY6;
        shoulders.rotationPointY = rotationPointY6;
        this.Head.rotateAngleY = (float) Math.toRadians(f3);
        this.Head.rotateAngleX = (float) Math.toRadians(f4) / 3.0f;
        this.Back1.render(f5);
        this.Back2.render(f5);
        this.Back3.render(f5);
        this.Shoulders.render(f5);
        this.Neck.render(f5);
        this.Head.render(f5);
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
