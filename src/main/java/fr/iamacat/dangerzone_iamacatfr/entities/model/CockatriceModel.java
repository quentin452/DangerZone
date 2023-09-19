
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CockatriceInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class CockatriceModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Tail4;
    ModelRenderer Tail5;
    ModelRenderer Tail6;
    ModelRenderer Tail7;
    ModelRenderer Body1;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Head;
    ModelRenderer HeadLayer1;
    ModelRenderer HeadLayer2;
    ModelRenderer Beak3;
    ModelRenderer Beak2;
    ModelRenderer Beak1;
    ModelRenderer Mouth;
    ModelRenderer EyeR;
    ModelRenderer EyeL;
    ModelRenderer Mane1;
    ModelRenderer Mane2;
    ModelRenderer Tail6S1;
    ModelRenderer Tail6S2;
    ModelRenderer Tail7S1;
    ModelRenderer Tail7S2;
    ModelRenderer LegL1;
    ModelRenderer LegL2;
    ModelRenderer ClawL1;
    ModelRenderer ClawL2;
    ModelRenderer ClawL5;
    ModelRenderer ClawL4;
    ModelRenderer ClawL3;
    ModelRenderer LegR1;
    ModelRenderer LegR2;
    ModelRenderer ClawR1;
    ModelRenderer ClawR2;
    ModelRenderer ClawR5;
    ModelRenderer ClawR3;
    ModelRenderer ClawR4;
    ModelRenderer WingFrameL1;
    ModelRenderer WingFrameL2;
    ModelRenderer WingL;
    ModelRenderer WingFrameR1;
    ModelRenderer WingFrameR2;
    ModelRenderer WingR;

    public CockatriceModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.Body2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 12, 10, 8);
        this.Body2.setRotationPoint(-6.0f, 4.0f, -6.0f);
        this.Body2.setTextureSize(512, 512);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, 0.0f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 11, 9, 8);
        this.Body3.setRotationPoint(-5.5f, 4.5f, -2.0f);
        this.Body3.setTextureSize(512, 512);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 10, 8, 8);
        this.Body4.setRotationPoint(-5.0f, 5.0f, 1.0f);
        this.Body4.setTextureSize(512, 512);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 7, 8);
        this.Tail1.setRotationPoint(-4.5f, 5.5f, 5.0f);
        this.Tail1.setTextureSize(512, 512);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 8);
        this.Tail2.setRotationPoint(-4.0f, 6.0f, 10.0f);
        this.Tail2.setTextureSize(512, 512);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 7, 5, 8);
        this.Tail3.setRotationPoint(-3.5f, 6.5f, 15.0f);
        this.Tail3.setTextureSize(512, 512);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, 0.0f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 4, 8);
        this.Tail4.setRotationPoint(-2.5f, 7.0f, 20.0f);
        this.Tail4.setTextureSize(512, 512);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, 0.0f, 0.0f, 0.0f);
        (this.Tail5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 3, 8);
        this.Tail5.setRotationPoint(-2.0f, 7.5f, 26.0f);
        this.Tail5.setTextureSize(512, 512);
        this.Tail5.mirror = true;
        this.setRotation(this.Tail5, 0.0f, 0.0f, 0.0f);
        (this.Tail6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 10);
        this.Tail6.setRotationPoint(-1.5f, 8.0f, 32.0f);
        this.Tail6.setTextureSize(512, 512);
        this.Tail6.mirror = true;
        this.setRotation(this.Tail6, 0.0f, 0.0f, 0.0f);
        (this.Tail7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 1, 10);
        this.Tail7.setRotationPoint(-1.0f, 8.5f, 41.0f);
        this.Tail7.setTextureSize(512, 512);
        this.Tail7.mirror = true;
        this.setRotation(this.Tail7, 0.0f, 0.0f, 0.0f);
        (this.Body1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -3.0f, -1.0f, 12, 10, 8);
        this.Body1.setRotationPoint(-6.0f, 4.0f, -7.0f);
        this.Body1.setTextureSize(512, 512);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, -0.669215f, 0.0f, 0.0f);
        (this.Neck1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -3.0f, -5.0f, 11, 9, 8);
        this.Neck1.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Neck1.setTextureSize(512, 512);
        this.Neck1.mirror = true;
        this.setRotation(this.Neck1, -1.003822f, 0.0f, 0.0f);
        (this.Neck2 = new ModelRenderer((ModelBase) this, 0, 55)).addBox(1.0f, -0.5f, -9.0f, 9, 7, 8);
        this.Neck2.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Neck2.setTextureSize(512, 512);
        this.Neck2.mirror = true;
        this.setRotation(this.Neck2, -1.352888f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 55)).addBox(2.0f, 0.9f, -14.0f, 7, 7, 8);
        this.Head.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Head.setTextureSize(512, 512);
        this.Head.mirror = true;
        this.setRotation(this.Head, -1.570796f, 0.0f, 0.0f);
        (this.HeadLayer1 = new ModelRenderer((ModelBase) this, 0, 55)).addBox(1.0f, 0.9f, -13.0f, 9, 7, 6);
        this.HeadLayer1.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.HeadLayer1.setTextureSize(512, 512);
        this.HeadLayer1.mirror = true;
        this.setRotation(this.HeadLayer1, -1.570796f, 0.0f, 0.0f);
        (this.HeadLayer2 = new ModelRenderer((ModelBase) this, 0, 55)).addBox(2.0f, 0.4f, -13.0f, 7, 8, 6);
        this.HeadLayer2.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.HeadLayer2.setTextureSize(512, 512);
        this.HeadLayer2.mirror = true;
        this.setRotation(this.HeadLayer2, -1.570796f, 0.0f, 0.0f);
        (this.Beak3 = new ModelRenderer((ModelBase) this, 0, 99)).addBox(4.0f, 7.0f, -10.0f, 3, 4, 1);
        this.Beak3.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Beak3.setTextureSize(512, 512);
        this.Beak3.mirror = true;
        this.setRotation(this.Beak3, -1.570796f, 0.0f, 0.0f);
        (this.Beak2 = new ModelRenderer((ModelBase) this, 0, 99)).addBox(4.5f, 7.0f, -10.5f, 2, 4, 1);
        this.Beak2.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Beak2.setTextureSize(512, 512);
        this.Beak2.mirror = true;
        this.setRotation(this.Beak2, -1.570796f, 0.0f, 0.0f);
        (this.Beak1 = new ModelRenderer((ModelBase) this, 0, 99)).addBox(4.5f, 8.0f, -10.0f, 2, 4, 1);
        this.Beak1.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Beak1.setTextureSize(512, 512);
        this.Beak1.mirror = true;
        this.setRotation(this.Beak1, -1.570796f, 0.0f, 0.0f);
        (this.Mouth = new ModelRenderer((ModelBase) this, 0, 99)).addBox(4.5f, 7.0f, -9.0f, 2, 3, 1);
        this.Mouth.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Mouth.setTextureSize(512, 512);
        this.Mouth.mirror = true;
        this.setRotation(this.Mouth, -1.570796f, 0.0f, 0.0f);
        (this.EyeR = new ModelRenderer((ModelBase) this, 99, 0)).addBox(0.5f, 7.0f, -12.5f, 2, 2, 1);
        this.EyeR.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.EyeR.setTextureSize(512, 512);
        this.EyeR.mirror = true;
        this.setRotation(this.EyeR, -1.570796f, 0.0f, 0.1745329f);
        (this.EyeL = new ModelRenderer((ModelBase) this, 99, 0)).addBox(8.5f, 7.0f, -10.5f, 2, 2, 1);
        this.EyeL.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.EyeL.setTextureSize(512, 512);
        this.EyeL.mirror = true;
        this.setRotation(this.EyeL, -1.570796f, 0.0f, -0.1745329f);
        (this.Mane1 = new ModelRenderer((ModelBase) this, 111, 0)).addBox(5.0f, 5.0f, -17.5f, 1, 2, 4);
        this.Mane1.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Mane1.setTextureSize(512, 512);
        this.Mane1.mirror = true;
        this.setRotation(this.Mane1, -1.518436f, 0.0f, 0.0f);
        (this.Mane2 = new ModelRenderer((ModelBase) this, 111, 0)).addBox(5.0f, 4.0f, -17.5f, 1, 2, 4);
        this.Mane2.setRotationPoint(-5.5f, 4.5f, -7.0f);
        this.Mane2.setTextureSize(512, 512);
        this.Mane2.mirror = true;
        this.setRotation(this.Mane2, -1.570796f, 0.0f, 0.0f);
        (this.Tail6S1 = new ModelRenderer((ModelBase) this, 111, 0)).addBox(1.0f, -1.0f, 3.0f, 1, 2, 1);
        this.Tail6S1.setRotationPoint(-1.5f, 8.0f, 32.0f);
        this.Tail6S1.setTextureSize(512, 512);
        this.Tail6S1.mirror = true;
        this.setRotation(this.Tail6S1, 0.0f, 0.0f, 0.0f);
        (this.Tail6S2 = new ModelRenderer((ModelBase) this, 111, 0)).addBox(1.0f, -1.0f, 7.0f, 1, 2, 1);
        this.Tail6S2.setRotationPoint(-1.5f, 8.0f, 32.0f);
        this.Tail6S2.setTextureSize(512, 512);
        this.Tail6S2.mirror = true;
        this.setRotation(this.Tail6S2, 0.0f, 0.0f, 0.0f);
        (this.Tail7S1 = new ModelRenderer((ModelBase) this, 111, 0)).addBox(0.5f, -1.0f, 2.0f, 1, 2, 1);
        this.Tail7S1.setRotationPoint(-1.0f, 8.5f, 41.0f);
        this.Tail7S1.setTextureSize(512, 512);
        this.Tail7S1.mirror = true;
        this.setRotation(this.Tail7S1, 0.0f, 0.0f, 0.0f);
        (this.Tail7S2 = new ModelRenderer((ModelBase) this, 111, 0)).addBox(0.5f, -1.0f, 6.0f, 1, 2, 1);
        this.Tail7S2.setRotationPoint(-1.0f, 8.5f, 41.0f);
        this.Tail7S2.setTextureSize(512, 512);
        this.Tail7S2.mirror = true;
        this.setRotation(this.Tail7S2, 0.0f, 0.0f, 0.0f);
        (this.LegL1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 4, 5);
        this.LegL1.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.LegL1.setTextureSize(512, 512);
        this.LegL1.mirror = true;
        this.setRotation(this.LegL1, 0.0f, 0.0f, 0.0f);
        (this.LegL2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.2f, 1.0f, 0.5f, 3, 4, 4);
        this.LegL2.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.LegL2.setTextureSize(512, 512);
        this.LegL2.mirror = true;
        this.setRotation(this.LegL2, 0.0f, 0.0f, 0.0f);
        (this.ClawL1 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(1.0f, 3.0f, 2.5f, 1, 4, 1);
        this.ClawL1.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.ClawL1.setTextureSize(512, 512);
        this.ClawL1.mirror = true;
        this.setRotation(this.ClawL1, 0.0f, 0.0f, 0.0f);
        (this.ClawL2 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(1.0f, 7.0f, -1.5f, 1, 1, 5);
        this.ClawL2.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.ClawL2.setTextureSize(512, 512);
        this.ClawL2.mirror = true;
        this.setRotation(this.ClawL2, 0.0f, 0.0f, 0.0f);
        (this.ClawL5 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(1.0f, 7.0f, -2.5f, 1, 1, 3);
        this.ClawL5.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.ClawL5.setTextureSize(512, 512);
        this.ClawL5.mirror = true;
        this.setRotation(this.ClawL5, 0.0f, 0.4712389f, 0.0f);
        (this.ClawL4 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(1.0f, 7.0f, -4.0f, 1, 1, 3);
        this.ClawL4.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.ClawL4.setTextureSize(512, 512);
        this.ClawL4.mirror = true;
        this.setRotation(this.ClawL4, 0.0f, -0.4712389f, 0.0f);
        (this.ClawL3 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(1.0f, 7.0f, -3.5f, 1, 1, 3);
        this.ClawL3.setRotationPoint(6.0f, 8.0f, -5.0f);
        this.ClawL3.setTextureSize(512, 512);
        this.ClawL3.mirror = true;
        this.setRotation(this.ClawL3, 0.0f, 0.0f, 0.0f);
        (this.LegR1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-3.0f, 0.0f, 0.0f, 3, 4, 5);
        this.LegR1.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.LegR1.setTextureSize(512, 512);
        this.LegR1.mirror = true;
        this.setRotation(this.LegR1, 0.0f, 0.0f, 0.0f);
        (this.LegR2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.8f, 1.0f, 0.5f, 3, 4, 4);
        this.LegR2.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.LegR2.setTextureSize(512, 512);
        this.LegR2.mirror = true;
        this.setRotation(this.LegR2, 0.0f, 0.0f, 0.0f);
        (this.ClawR1 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(-2.0f, 3.0f, 2.5f, 1, 4, 1);
        this.ClawR1.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.ClawR1.setTextureSize(512, 512);
        this.ClawR1.mirror = true;
        this.setRotation(this.ClawR1, 0.0f, 0.0f, 0.0f);
        (this.ClawR2 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(-2.0f, 7.0f, -1.5f, 1, 1, 5);
        this.ClawR2.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.ClawR2.setTextureSize(512, 512);
        this.ClawR2.mirror = true;
        this.setRotation(this.ClawR2, 0.0f, 0.0f, 0.0f);
        (this.ClawR5 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(-2.0f, 7.0f, -3.0f, 1, 1, 3);
        this.ClawR5.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.ClawR5.setTextureSize(512, 512);
        this.ClawR5.mirror = true;
        this.setRotation(this.ClawR5, 0.0f, -0.4712389f, 0.0f);
        (this.ClawR3 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(-2.0f, 7.0f, -4.5f, 1, 1, 3);
        this.ClawR3.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.ClawR3.setTextureSize(512, 512);
        this.ClawR3.mirror = true;
        this.setRotation(this.ClawR3, 0.0f, 0.0f, 0.0f);
        (this.ClawR4 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(-2.0f, 7.0f, -4.5f, 1, 1, 3);
        this.ClawR4.setRotationPoint(-6.0f, 8.0f, -5.0f);
        this.ClawR4.setTextureSize(512, 512);
        this.ClawR4.mirror = true;
        this.setRotation(this.ClawR4, 0.0f, 0.4712389f, 0.0f);
        (this.WingFrameL1 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(0.0f, 0.0f, 0.0f, 8, 1, 1);
        this.WingFrameL1.setRotationPoint(6.0f, 4.0f, -3.0f);
        this.WingFrameL1.setTextureSize(512, 512);
        this.WingFrameL1.mirror = true;
        this.setRotation(this.WingFrameL1, 0.0f, 0.0f, 0.0f);
        (this.WingFrameL2 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(8.0f, 0.0f, 0.0f, 8, 1, 1);
        this.WingFrameL2.setRotationPoint(6.0f, 4.0f, -3.0f);
        this.WingFrameL2.setTextureSize(512, 512);
        this.WingFrameL2.mirror = true;
        this.setRotation(this.WingFrameL2, 0.0f, 0.0f, 0.0f);
        (this.WingL = new ModelRenderer((ModelBase) this, 0, 26)).addBox(0.0f, 0.0f, 0.0f, 16, 0, 10);
        this.WingL.setRotationPoint(6.0f, 4.5f, -3.0f);
        this.WingL.setTextureSize(512, 512);
        this.WingL.mirror = true;
        this.setRotation(this.WingL, 0.0f, 0.0f, 0.0f);
        (this.WingFrameR1 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(-8.0f, 0.0f, 0.0f, 8, 1, 1);
        this.WingFrameR1.setRotationPoint(-6.0f, 4.0f, -3.0f);
        this.WingFrameR1.setTextureSize(512, 512);
        this.WingFrameR1.mirror = true;
        this.setRotation(this.WingFrameR1, 0.0f, 0.0f, 0.0f);
        (this.WingFrameR2 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(-16.0f, 0.0f, 0.0f, 8, 1, 1);
        this.WingFrameR2.setRotationPoint(-6.0f, 4.0f, -3.0f);
        this.WingFrameR2.setTextureSize(512, 512);
        this.WingFrameR2.mirror = true;
        this.setRotation(this.WingFrameR2, 0.0f, 0.0f, 0.0f);
        (this.WingR = new ModelRenderer((ModelBase) this, 0, 40)).addBox(-16.0f, 0.0f, 0.0f, 16, 0, 10);
        this.WingR.setRotationPoint(-6.0f, 4.5f, -3.0f);
        this.WingR.setTextureSize(512, 512);
        this.WingR.mirror = true;
        this.setRotation(this.WingR, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final CockatriceInstance e = (CockatriceInstance) entity;
        float newangle = 0.0f;
        final float lspeed = 0.0f;
        final InfoRenderer r = null;
        final float tailspeed = 0.76f;
        final float tailamp = 0.45f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.141593f * 0.28f;
        this.WingFrameL1.rotateAngleZ = newangle;
        this.WingL.rotateAngleZ = newangle * 4.0f / 3.0f;
        this.WingFrameL2.rotateAngleZ = newangle * 4.0f / 3.0f;
        this.WingFrameR1.rotateAngleZ = -newangle;
        this.WingR.rotateAngleZ = -newangle * 4.0f / 3.0f;
        this.WingFrameR2.rotateAngleZ = -newangle * 4.0f / 3.0f;
        this.LegL1.rotateAngleX = -newangle;
        this.LegL2.rotateAngleX = -newangle;
        this.ClawL1.rotateAngleX = -newangle;
        this.ClawL2.rotateAngleX = -newangle;
        this.ClawL3.rotateAngleX = -newangle;
        this.ClawL4.rotateAngleX = -newangle;
        this.ClawL5.rotateAngleX = -newangle;
        this.LegR1.rotateAngleX = newangle;
        this.LegR2.rotateAngleX = newangle;
        this.ClawR1.rotateAngleX = newangle;
        this.ClawR2.rotateAngleX = newangle;
        this.ClawR3.rotateAngleX = newangle;
        this.ClawR4.rotateAngleX = newangle;
        this.ClawR5.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.141593f * 0.28f;
        this.Neck1.rotateAngleX = -newangle;
        this.Neck2.rotateAngleX = -newangle;
        this.Head.rotateAngleX = -newangle;
        this.HeadLayer1.rotateAngleX = -newangle;
        this.HeadLayer2.rotateAngleX = -newangle;
        this.EyeL.rotateAngleX = -newangle;
        this.EyeR.rotateAngleX = -newangle;
        this.Beak1.rotateAngleX = -newangle;
        this.Beak2.rotateAngleX = -newangle;
        this.Beak3.rotateAngleX = -newangle;
        this.Mouth.rotateAngleX = -newangle;
        this.Mane1.rotateAngleX = -newangle;
        this.Mane2.rotateAngleX = -newangle;
        newangle = MathHelper.cos(f2 * 0.1f * 1.75f) * 3.141593f * 0.6f;
        this.TailEvent(newangle);
        this.Body2.render(f5);
        this.Body3.render(f5);
        this.Body4.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.Tail4.render(f5);
        this.Tail5.render(f5);
        this.Tail6.render(f5);
        this.Tail7.render(f5);
        this.Body1.render(f5);
        this.Neck1.render(f5);
        this.Neck2.render(f5);
        this.Head.render(f5);
        this.HeadLayer1.render(f5);
        this.HeadLayer2.render(f5);
        this.Beak3.render(f5);
        this.Beak2.render(f5);
        this.Beak1.render(f5);
        this.Mouth.render(f5);
        this.EyeR.render(f5);
        this.EyeL.render(f5);
        this.Mane1.render(f5);
        this.Mane2.render(f5);
        this.Tail6S1.render(f5);
        this.Tail6S2.render(f5);
        this.Tail7S1.render(f5);
        this.Tail7S2.render(f5);
        this.LegL1.render(f5);
        this.LegL2.render(f5);
        this.ClawL1.render(f5);
        this.ClawL2.render(f5);
        this.ClawL5.render(f5);
        this.ClawL4.render(f5);
        this.ClawL3.render(f5);
        this.LegR1.render(f5);
        this.LegR2.render(f5);
        this.ClawR1.render(f5);
        this.ClawR2.render(f5);
        this.ClawR5.render(f5);
        this.ClawR3.render(f5);
        this.ClawR4.render(f5);
        this.WingFrameL1.render(f5);
        this.WingFrameL2.render(f5);
        this.WingL.render(f5);
        this.WingFrameR1.render(f5);
        this.WingFrameR2.render(f5);
        this.WingR.render(f5);
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
        this.Body4.rotateAngleY = angle * 0.12f;
        this.Tail1.rotateAngleY = angle * 0.2f;
        this.Tail2.rotateAngleY = angle * 0.35f;
        this.Tail3.rotateAngleY = angle * 0.5f;
        this.Tail3.rotationPointZ = this.Tail2.rotationPointZ + (float) Math.cos(this.Tail2.rotateAngleY) * 6.0f;
        this.Tail3.rotationPointX = this.Tail2.rotationPointX + (float) Math.sin(this.Tail2.rotateAngleY) * 6.0f;
        this.Tail4.rotateAngleY = angle * 0.65f;
        this.Tail4.rotationPointZ = this.Tail3.rotationPointZ + (float) Math.cos(this.Tail3.rotateAngleY) * 6.0f;
        this.Tail4.rotationPointX = this.Tail3.rotationPointX + (float) Math.sin(this.Tail3.rotateAngleY) * 6.0f;
        this.Tail5.rotateAngleY = angle * 0.8f;
        this.Tail5.rotationPointZ = this.Tail4.rotationPointZ + (float) Math.cos(this.Tail4.rotateAngleY) * 6.0f;
        this.Tail5.rotationPointX = this.Tail4.rotationPointX + (float) Math.sin(this.Tail4.rotateAngleY) * 6.0f;
        this.Tail6.rotateAngleY = angle * 0.95f;
        this.Tail6.rotationPointZ = this.Tail5.rotationPointZ + (float) Math.cos(this.Tail5.rotateAngleY) * 6.0f;
        this.Tail6.rotationPointX = this.Tail5.rotationPointX + (float) Math.sin(this.Tail5.rotateAngleY) * 6.0f;
        this.Tail6S1.rotateAngleY = angle * 0.95f;
        this.Tail6S1.rotationPointZ = this.Tail5.rotationPointZ + (float) Math.cos(this.Tail5.rotateAngleY) * 6.0f;
        this.Tail6S1.rotationPointX = this.Tail5.rotationPointX + (float) Math.sin(this.Tail5.rotateAngleY) * 6.0f;
        this.Tail6S2.rotateAngleY = angle * 0.95f;
        this.Tail6S2.rotationPointZ = this.Tail5.rotationPointZ + (float) Math.cos(this.Tail5.rotateAngleY) * 6.0f;
        this.Tail6S2.rotationPointX = this.Tail5.rotationPointX + (float) Math.sin(this.Tail5.rotateAngleY) * 6.0f;
        this.Tail7.rotateAngleY = angle * 1.4f;
        this.Tail7.rotationPointZ = this.Tail6.rotationPointZ + (float) Math.cos(this.Tail6.rotateAngleY) * 10.0f;
        this.Tail7.rotationPointX = this.Tail6.rotationPointX + (float) Math.sin(this.Tail6.rotateAngleY) * 10.0f;
        this.Tail7S1.rotateAngleY = angle * 1.4f;
        this.Tail7S1.rotationPointZ = this.Tail6.rotationPointZ + (float) Math.cos(this.Tail6.rotateAngleY) * 10.0f;
        this.Tail7S1.rotationPointX = this.Tail6.rotationPointX + (float) Math.sin(this.Tail6.rotateAngleY) * 10.0f;
        this.Tail7S2.rotateAngleY = angle * 1.4f;
        this.Tail7S2.rotationPointZ = this.Tail6.rotationPointZ + (float) Math.cos(this.Tail6.rotateAngleY) * 10.0f;
        this.Tail7S2.rotationPointX = this.Tail6.rotationPointX + (float) Math.sin(this.Tail6.rotateAngleY) * 10.0f;
    }
}