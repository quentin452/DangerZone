
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.PhoenixInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class PhoenixModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Body3;
    ModelRenderer Body;
    ModelRenderer Body2;
    ModelRenderer Spine;
    ModelRenderer Bum;
    ModelRenderer Tail;
    ModelRenderer NeckShield;
    ModelRenderer BumShield;
    ModelRenderer TailF1;
    ModelRenderer TailF2;
    ModelRenderer TailF3;
    ModelRenderer TailF5;
    ModelRenderer TailF6;
    ModelRenderer TailF4;
    ModelRenderer Head;
    ModelRenderer Cheek;
    ModelRenderer Brain;
    ModelRenderer Nose;
    ModelRenderer Mouth;
    ModelRenderer Tip;
    ModelRenderer Eyes;
    ModelRenderer FeatherC;
    ModelRenderer FeatherL;
    ModelRenderer FeatherR;
    ModelRenderer BallC;
    ModelRenderer BallL;
    ModelRenderer BallR;
    ModelRenderer WingL2;
    ModelRenderer WingL;
    ModelRenderer WingL3;
    ModelRenderer WingL4;
    ModelRenderer WingL5;
    ModelRenderer WingL6;
    ModelRenderer WindR;
    ModelRenderer WingR2;
    ModelRenderer WingR3;
    ModelRenderer WingR4;
    ModelRenderer WingR5;
    ModelRenderer WingR6;

    public PhoenixModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 1024;
        this.textureHeight = 1024;
        (this.Body3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 18, 12, 50);
        this.Body3.setRotationPoint(-9.5f, -29.0f, -35.0f);
        this.Body3.setTextureSize(64, 32);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 16, 50);
        this.Body.setRotationPoint(-10.0f, -30.0f, -30.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 15, 10, 50);
        this.Body2.setRotationPoint(-8.0f, -29.0f, -44.0f);
        this.Body2.setTextureSize(64, 32);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Spine = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 8, 110);
        this.Spine.setRotationPoint(-6.0f, -29.0f, -59.0f);
        this.Spine.setTextureSize(64, 32);
        this.Spine.mirror = true;
        this.setRotation(this.Spine, 0.0f, 0.0f, 0.0f);
        (this.Bum = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.5f, -0.5f, 0.0f, 18, 12, 50);
        this.Bum.setRotationPoint(-9.5f, -29.0f, -14.0f);
        this.Bum.setTextureSize(64, 32);
        this.Bum.mirror = true;
        this.setRotation(this.Bum, 0.0f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 2, 25);
        this.Tail.setRotationPoint(-4.0f, -27.0f, 47.0f);
        this.Tail.setTextureSize(64, 32);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.1115358f, 0.0f, 0.0f);
        (this.NeckShield = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 6, 35);
        this.NeckShield.setRotationPoint(-6.0f, -26.0f, -55.0f);
        this.NeckShield.setTextureSize(64, 32);
        this.NeckShield.mirror = true;
        this.setRotation(this.NeckShield, -0.1745329f, 0.0f, 0.0f);
        (this.BumShield = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 6, 55);
        this.BumShield.setRotationPoint(-6.0f, -20.0f, -4.4f);
        this.BumShield.setTextureSize(64, 32);
        this.BumShield.mirror = true;
        this.setRotation(this.BumShield, 0.111544f, 0.0f, 0.0f);
        (this.TailF1 = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 25);
        this.TailF1.setRotationPoint(2.0f, -29.0f, 72.0f);
        this.TailF1.setTextureSize(64, 32);
        this.TailF1.mirror = true;
        this.setRotation(this.TailF1, 0.3346075f, 0.1858931f, 0.0f);
        (this.TailF2 = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 25);
        this.TailF2.setRotationPoint(0.0f, -29.0f, 72.0f);
        this.TailF2.setTextureSize(64, 32);
        this.TailF2.mirror = true;
        this.setRotation(this.TailF2, 0.3717861f, 0.0371786f, 0.0f);
        (this.TailF3 = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 25);
        this.TailF3.setRotationPoint(-3.0f, -29.0f, 72.0f);
        this.TailF3.setTextureSize(64, 32);
        this.TailF3.mirror = true;
        this.setRotation(this.TailF3, 0.2602503f, -0.2602503f, 0.0f);
        (this.TailF5 = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 45);
        this.TailF5.setRotationPoint(1.0f, -38.0f, 94.0f);
        this.TailF5.setTextureSize(64, 32);
        this.TailF5.mirror = true;
        this.setRotation(this.TailF5, 0.1858931f, 0.0f, 0.0f);
        (this.TailF6 = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 45);
        this.TailF6.setRotationPoint(-9.0f, -35.0f, 94.0f);
        this.TailF6.setTextureSize(64, 32);
        this.TailF6.mirror = true;
        this.setRotation(this.TailF6, -0.0743572f, -0.2602503f, 0.0f);
        (this.TailF4 = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 45);
        this.TailF4.setRotationPoint(6.0f, -37.0f, 94.0f);
        this.TailF4.setTextureSize(64, 32);
        this.TailF4.mirror = true;
        this.setRotation(this.TailF4, -0.0743572f, 0.1858931f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 12, 8);
        this.Head.setRotationPoint(-8.0f, -30.0f, -66.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Cheek = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 6, 18);
        this.Cheek.setRotationPoint(-8.0f, -24.0f, -82.0f);
        this.Cheek.setTextureSize(64, 32);
        this.Cheek.mirror = true;
        this.setRotation(this.Cheek, 0.0f, 0.0f, 0.0f);
        (this.Brain = new ModelRenderer((ModelBase) this, 400, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 6, 18);
        this.Brain.setRotationPoint(-8.0f, -27.0f, -82.0f);
        this.Brain.setTextureSize(64, 32);
        this.Brain.mirror = true;
        this.setRotation(this.Brain, 0.1858931f, 0.0f, 0.0f);
        (this.Nose = new ModelRenderer((ModelBase) this, 0, 180)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 14);
        this.Nose.setRotationPoint(-6.0f, -24.0f, -91.0f);
        this.Nose.setTextureSize(64, 32);
        this.Nose.mirror = true;
        this.setRotation(this.Nose, 0.1858931f, 0.0f, 0.0f);
        (this.Mouth = new ModelRenderer((ModelBase) this, 0, 180)).addBox(0.0f, 0.0f, 0.0f, 12, 4, 12);
        this.Mouth.setRotationPoint(-6.0f, -22.0f, -91.0f);
        this.Mouth.setTextureSize(64, 32);
        this.Mouth.mirror = true;
        this.setRotation(this.Mouth, 0.0f, 0.0f, 0.0f);
        (this.Tip = new ModelRenderer((ModelBase) this, 0, 140)).addBox(0.0f, 0.0f, 0.0f, 10, 4, 14);
        this.Tip.setRotationPoint(-5.0f, -22.0f, -97.0f);
        this.Tip.setTextureSize(64, 32);
        this.Tip.mirror = true;
        this.setRotation(this.Tip, 0.1858931f, 0.0f, 0.0f);
        (this.Eyes = new ModelRenderer((ModelBase) this, 250, 250)).addBox(0.0f, 0.0f, 0.0f, 18, 2, 8);
        this.Eyes.setRotationPoint(-9.0f, -26.0f, -78.0f);
        this.Eyes.setTextureSize(64, 32);
        this.Eyes.mirror = true;
        this.setRotation(this.Eyes, 0.1858931f, 0.0f, 0.0f);
        (this.FeatherC = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 25);
        this.FeatherC.setRotationPoint(-1.0f, -30.0f, -68.0f);
        this.FeatherC.setTextureSize(64, 32);
        this.FeatherC.mirror = true;
        this.setRotation(this.FeatherC, 0.3717861f, 0.0371786f, 0.0f);
        (this.FeatherL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 25);
        this.FeatherL.setRotationPoint(1.0f, -30.0f, -68.0f);
        this.FeatherL.setTextureSize(64, 32);
        this.FeatherL.mirror = true;
        this.setRotation(this.FeatherL, 0.3717861f, 0.2602503f, 0.0f);
        (this.FeatherR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 25);
        this.FeatherR.setRotationPoint(-3.0f, -30.0f, -68.0f);
        this.FeatherR.setTextureSize(64, 32);
        this.FeatherR.mirror = true;
        this.setRotation(this.FeatherR, 0.37179f, -0.1305382f, 0.0f);
        (this.BallC = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.BallC.setRotationPoint(-1.0f, -40.0f, -46.0f);
        this.BallC.setTextureSize(64, 32);
        this.BallC.mirror = true;
        this.setRotation(this.BallC, 0.3717861f, 0.0f, 0.0f);
        (this.BallL = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.BallL.setRotationPoint(6.0f, -40.0f, -46.0f);
        this.BallL.setTextureSize(64, 32);
        this.BallL.mirror = true;
        this.setRotation(this.BallL, 0.3717861f, 0.2443461f, 0.0f);
        (this.BallR = new ModelRenderer((ModelBase) this, 0, 500)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.BallR.setRotationPoint(-7.0f, -40.0f, -47.0f);
        this.BallR.setTextureSize(64, 32);
        this.BallR.mirror = true;
        this.setRotation(this.BallR, 0.3717861f, -0.2443461f, 0.0f);
        (this.WingL2 = new ModelRenderer((ModelBase) this, 250, 0)).addBox(25.0f, 0.0f, 0.0f, 25, 3, 27);
        this.WingL2.setRotationPoint(9.0f, -23.0f, -28.0f);
        this.WingL2.setTextureSize(64, 32);
        this.WingL2.mirror = true;
        this.setRotation(this.WingL2, 0.0f, 0.0f, 0.0f);
        (this.WingL = new ModelRenderer((ModelBase) this, 250, 0)).addBox(0.0f, 0.0f, 0.0f, 25, 3, 32);
        this.WingL.setRotationPoint(9.0f, -23.0f, -28.0f);
        this.WingL.setTextureSize(64, 32);
        this.WingL.mirror = true;
        this.setRotation(this.WingL, 0.0f, 0.0f, 0.0f);
        (this.WingL3 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(45.0f, 0.0f, 0.0f, 32, 3, 9);
        this.WingL3.setRotationPoint(9.0f, -23.0f, -28.0f);
        this.WingL3.setTextureSize(64, 32);
        this.WingL3.mirror = true;
        this.setRotation(this.WingL3, 0.0f, 0.0f, 0.0f);
        (this.WingL4 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(40.0f, 0.0f, -5.0f, 28, 3, 9);
        this.WingL4.setRotationPoint(9.0f, -23.0f, -28.0f);
        this.WingL4.setTextureSize(64, 32);
        this.WingL4.mirror = true;
        this.setRotation(this.WingL4, 0.0f, -0.2602503f, 0.0f);
        (this.WingL5 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(38.0f, 0.0f, -10.0f, 28, 3, 9);
        this.WingL5.setRotationPoint(9.0f, -23.0f, -28.0f);
        this.WingL5.setTextureSize(64, 32);
        this.WingL5.mirror = true;
        this.setRotation(this.WingL5, 0.0f, -0.5576792f, 0.0f);
        (this.WingL6 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(33.0f, 0.0f, -11.0f, 28, 3, 9);
        this.WingL6.setRotationPoint(9.0f, -23.0f, -28.0f);
        this.WingL6.setTextureSize(64, 32);
        this.WingL6.mirror = true;
        this.setRotation(this.WingL6, 0.0f, -0.8551081f, 0.0f);
        (this.WindR = new ModelRenderer((ModelBase) this, 250, 0)).addBox(-25.0f, 0.0f, 0.0f, 25, 3, 32);
        this.WindR.setRotationPoint(-10.0f, -23.0f, -28.0f);
        this.WindR.setTextureSize(64, 32);
        this.WindR.mirror = true;
        this.setRotation(this.WindR, 0.0f, 0.0f, 0.0f);
        (this.WingR2 = new ModelRenderer((ModelBase) this, 250, 0)).addBox(-50.0f, 0.0f, 0.0f, 25, 3, 27);
        this.WingR2.setRotationPoint(-10.0f, -23.0f, -28.0f);
        this.WingR2.setTextureSize(64, 32);
        this.WingR2.mirror = true;
        this.setRotation(this.WingR2, 0.0f, 0.0f, 0.0f);
        (this.WingR3 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(-69.0f, 0.0f, 0.0f, 32, 3, 9);
        this.WingR3.setRotationPoint(-10.0f, -23.0f, -28.0f);
        this.WingR3.setTextureSize(64, 32);
        this.WingR3.mirror = true;
        this.setRotation(this.WingR3, 0.0f, 0.0f, 0.0f);
        (this.WingR4 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(-70.0f, 0.0f, -3.0f, 28, 3, 9);
        this.WingR4.setRotationPoint(-10.0f, -23.0f, -28.0f);
        this.WingR4.setTextureSize(64, 32);
        this.WingR4.mirror = true;
        this.setRotation(this.WingR4, 0.0f, 0.260246f, 0.0f);
        (this.WingR5 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(-65.0f, 0.0f, -6.0f, 28, 3, 9);
        this.WingR5.setRotationPoint(-10.0f, -23.0f, -28.0f);
        this.WingR5.setTextureSize(64, 32);
        this.WingR5.mirror = true;
        this.setRotation(this.WingR5, 0.0f, 0.5576851f, 0.0f);
        (this.WingR6 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(-60.0f, 0.0f, -8.0f, 28, 3, 9);
        this.WingR6.setRotationPoint(-10.0f, -23.0f, -28.0f);
        this.WingR6.setTextureSize(64, 32);
        this.WingR6.mirror = true;
        this.setRotation(this.WingR6, 0.0f, 0.8551066f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final PhoenixInstance e = (PhoenixInstance) entity;
        float newangle = 0.0f;
        final float lspeed = 0.0f;
        final InfoRenderer r = null;
        final float tailspeed = 0.76f;
        final float tailamp = 0.45f;
        float T1 = 0.0f;
        float T2 = 0.0f;
        float T3 = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.141593f * 0.28f;
        this.WingL.rotateAngleZ = newangle;
        this.WingL2.rotateAngleZ = newangle * 4.0f / 3.0f;
        this.WingL2.rotationPointY = this.WingL.rotationPointY;
        this.WingL2.rotationPointX = this.WingL.rotationPointX;
        this.WingL3.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.WingL3.rotationPointY = this.WingL2.rotationPointY + (float) Math.sin(this.WingL2.rotateAngleZ) * 6.0f;
        this.WingL3.rotationPointX = this.WingL2.rotationPointX + (float) Math.cos(this.WingL2.rotateAngleZ) * 6.0f;
        this.WingL4.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.WingL4.rotationPointY = this.WingL3.rotationPointY;
        this.WingL4.rotationPointX = this.WingL3.rotationPointX;
        this.WingL5.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.WingL5.rotationPointY = this.WingL4.rotationPointY;
        this.WingL5.rotationPointX = this.WingL4.rotationPointX;
        this.WingL6.rotateAngleZ = newangle * 3.0f / 2.0f;
        this.WingL6.rotationPointY = this.WingL5.rotationPointY;
        this.WingL6.rotationPointX = this.WingL5.rotationPointX;
        this.WindR.rotateAngleZ = -newangle;
        this.WingR2.rotateAngleZ = -newangle * 4.0f / 3.0f;
        this.WingR2.rotationPointY = this.WindR.rotationPointY;
        this.WingR2.rotationPointX = this.WindR.rotationPointX;
        this.WingR3.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.WingR3.rotationPointY = this.WindR.rotationPointY - (float) Math.sin(this.WindR.rotateAngleZ) * 6.0f;
        this.WingR3.rotationPointX = this.WindR.rotationPointX - (float) Math.cos(this.WindR.rotateAngleZ) * 6.0f;
        this.WingR4.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.WingR4.rotationPointY = this.WingR3.rotationPointY;
        this.WingR4.rotationPointX = this.WingR3.rotationPointX;
        this.WingR5.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.WingR5.rotationPointY = this.WingR4.rotationPointY;
        this.WingR5.rotationPointX = this.WingR4.rotationPointX;
        this.WingR6.rotateAngleZ = -newangle * 3.0f / 2.0f;
        this.WingR6.rotationPointY = this.WingR5.rotationPointY;
        this.WingR6.rotationPointX = this.WingR5.rotationPointX;
        T1 = MathHelper.cos(f2 * 0.19f * 1.75f) * 3.141593f * 0.08f;
        T2 = MathHelper.cos(f2 * 1.12f * 1.75f) * 3.141593f * 0.1f;
        T3 = MathHelper.cos(f2 * 0.55f * 1.75f) * 3.141593f * 0.04f;
        this.TailEvent(T1);
        this.TailEvent2(T2);
        this.TailEvent3(T3);
        this.Body3.render(f5);
        this.Body.render(f5);
        this.Body2.render(f5);
        this.Spine.render(f5);
        this.Bum.render(f5);
        this.Tail.render(f5);
        this.NeckShield.render(f5);
        this.BumShield.render(f5);
        this.TailF1.render(f5);
        this.TailF2.render(f5);
        this.TailF3.render(f5);
        this.TailF5.render(f5);
        this.TailF6.render(f5);
        this.TailF4.render(f5);
        this.Head.render(f5);
        this.Cheek.render(f5);
        this.Brain.render(f5);
        this.Nose.render(f5);
        this.Mouth.render(f5);
        this.Tip.render(f5);
        this.Eyes.render(f5);
        this.FeatherC.render(f5);
        this.FeatherL.render(f5);
        this.FeatherR.render(f5);
        this.BallC.render(f5);
        this.BallL.render(f5);
        this.BallR.render(f5);
        this.WingL2.render(f5);
        this.WingL.render(f5);
        this.WingL3.render(f5);
        this.WingL4.render(f5);
        this.WingL5.render(f5);
        this.WingL6.render(f5);
        this.WindR.render(f5);
        this.WingR2.render(f5);
        this.WingR3.render(f5);
        this.WingR4.render(f5);
        this.WingR5.render(f5);
        this.WingR6.render(f5);
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
        this.TailF1.rotateAngleY = angle * 0.12f;
        this.TailF2.rotateAngleY = angle * 0.12f;
        this.TailF2.rotationPointZ = this.TailF1.rotationPointZ + (float) Math.cos(this.TailF1.rotateAngleY) * 4.0f;
        this.TailF2.rotationPointX = this.TailF1.rotationPointX + (float) Math.sin(this.TailF1.rotateAngleY) * 4.0f;
    }

    private void TailEvent2(final float angle) {
        this.TailF3.rotateAngleY = angle * 0.12f;
        this.TailF4.rotateAngleY = angle * 0.12f;
        this.TailF4.rotationPointZ = this.TailF3.rotationPointZ + (float) Math.cos(this.TailF3.rotateAngleY) * 4.0f;
        this.TailF4.rotationPointX = this.TailF3.rotationPointX + (float) Math.sin(this.TailF3.rotateAngleY) * 4.0f;
    }

    private void TailEvent3(final float angle) {
        this.TailF5.rotateAngleY = angle * 0.12f;
        this.TailF6.rotateAngleY = angle * 0.12f;
        this.TailF6.rotationPointZ = this.TailF5.rotationPointZ + (float) Math.cos(this.TailF5.rotateAngleY) * 4.0f;
        this.TailF6.rotationPointX = this.TailF5.rotationPointX + (float) Math.sin(this.TailF5.rotateAngleY) * 4.0f;
    }
}
