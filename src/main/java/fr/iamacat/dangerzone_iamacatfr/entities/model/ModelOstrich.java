
package fr.iamacat.dangerzone_iamacatfr.entities.model;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityCannonFodder;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Ostrich;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelOstrich extends ModelBase {

    private float wingspeed;
    ModelRenderer Body1;
    ModelRenderer body2;
    ModelRenderer LLeg1;
    ModelRenderer Rleg1;
    ModelRenderer LLeg2;
    ModelRenderer Lfoot1;
    ModelRenderer RLeg2;
    ModelRenderer Lfoot2;
    ModelRenderer Lfoot3;
    ModelRenderer LClaw1;
    ModelRenderer LClaw2;
    ModelRenderer LClaw3;
    ModelRenderer Lfoot4;
    ModelRenderer LClaw4;
    ModelRenderer Rfoot1;
    ModelRenderer Rfoot2;
    ModelRenderer Rclaw1;
    ModelRenderer Rfoot3;
    ModelRenderer Rclaw3;
    ModelRenderer Rfoot4;
    ModelRenderer Rclaw2;
    ModelRenderer Rclaw4;
    ModelRenderer Body3;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer Body4;
    ModelRenderer head;
    ModelRenderer leftleg;
    ModelRenderer Neck1;
    ModelRenderer Head1;
    ModelRenderer mouth1;
    ModelRenderer neck2;
    ModelRenderer rightleg;
    ModelRenderer Lwing;
    ModelRenderer Rwing;
    ModelRenderer Hat1;
    ModelRenderer Hat2;

    public ModelOstrich(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 128;
        (this.Body1 = new ModelRenderer((ModelBase) this, 0, 28)).addBox(-4.0f, 0.0f, 0.0f, 8, 9, 8);
        this.Body1.setRotationPoint(0.0f, 0.0f, -6.0f);
        this.Body1.setTextureSize(256, 128);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, -0.2230717f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 25, 111)).addBox(-4.0f, 0.0f, 0.0f, 8, 8, 8);
        this.body2.setRotationPoint(0.0f, 2.0f, -1.0f);
        this.body2.setTextureSize(256, 128);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.0f, 0.0f, 0.0f);
        (this.LLeg1 = new ModelRenderer((ModelBase) this, 25, 70)).addBox(-1.0f, 3.0f, -5.0f, 2, 7, 3);
        this.LLeg1.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.LLeg1.setTextureSize(256, 128);
        this.LLeg1.mirror = true;
        this.setRotation(this.LLeg1, 0.4833219f, 0.0f, 0.0f);
        (this.Rleg1 = new ModelRenderer((ModelBase) this, 25, 70)).addBox(-2.0f, 3.0f, -5.0f, 2, 7, 3);
        this.Rleg1.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rleg1.setTextureSize(256, 128);
        this.Rleg1.mirror = true;
        this.setRotation(this.Rleg1, 0.4833219f, 0.0f, 0.0f);
        (this.LLeg2 = new ModelRenderer((ModelBase) this, 29, 59)).addBox(-1.0f, 7.0f, 4.0f, 2, 7, 3);
        this.LLeg2.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.LLeg2.setTextureSize(256, 128);
        this.LLeg2.mirror = true;
        this.setRotation(this.LLeg2, -0.4370552f, 0.0f, 0.0f);
        (this.Lfoot1 = new ModelRenderer((ModelBase) this, 29, 50)).addBox(-1.0f, 14.0f, -5.0f, 2, 2, 6);
        this.Lfoot1.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.Lfoot1.setTextureSize(256, 128);
        this.Lfoot1.mirror = true;
        this.setRotation(this.Lfoot1, 0.0f, 0.0f, 0.0f);
        (this.RLeg2 = new ModelRenderer((ModelBase) this, 29, 59)).addBox(-2.0f, 7.0f, 4.0f, 2, 7, 3);
        this.RLeg2.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.RLeg2.setTextureSize(256, 128);
        this.RLeg2.mirror = true;
        this.setRotation(this.RLeg2, -0.4370552f, 0.0f, 0.0f);
        (this.Lfoot2 = new ModelRenderer((ModelBase) this, 0, 9)).addBox(-1.0f, 15.0f, -4.0f, 2, 1, 5);
        this.Lfoot2.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.Lfoot2.setTextureSize(256, 128);
        this.Lfoot2.mirror = true;
        this.setRotation(this.Lfoot2, 0.0f, 0.2602503f, 0.0f);
        (this.Lfoot3 = new ModelRenderer((ModelBase) this, 0, 9)).addBox(-1.0f, 15.0f, -4.0f, 2, 1, 5);
        this.Lfoot3.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.Lfoot3.setTextureSize(256, 128);
        this.Lfoot3.mirror = true;
        this.setRotation(this.Lfoot3, 0.0f, -0.260246f, 0.0f);
        (this.LClaw1 = new ModelRenderer((ModelBase) this, 16, 10)).addBox(0.0f, 14.0f, -7.0f, 0, 2, 3);
        this.LClaw1.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.LClaw1.setTextureSize(256, 128);
        this.LClaw1.mirror = true;
        this.setRotation(this.LClaw1, 0.0f, 0.0f, 0.0f);
        (this.LClaw2 = new ModelRenderer((ModelBase) this, 19, 16)).addBox(-0.5f, 15.0f, -5.0f, 0, 1, 3);
        this.LClaw2.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.LClaw2.setTextureSize(256, 128);
        this.LClaw2.mirror = true;
        this.setRotation(this.LClaw2, 0.0f, 0.260246f, 0.0f);
        (this.LClaw3 = new ModelRenderer((ModelBase) this, 19, 16)).addBox(0.5f, 15.0f, -5.0f, 0, 1, 3);
        this.LClaw3.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.LClaw3.setTextureSize(256, 128);
        this.LClaw3.mirror = true;
        this.setRotation(this.LClaw3, 0.0f, -0.260246f, 0.0f);
        (this.Lfoot4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 14.0f, -1.0f, 2, 2, 4);
        this.Lfoot4.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.Lfoot4.setTextureSize(256, 128);
        this.Lfoot4.mirror = true;
        this.setRotation(this.Lfoot4, 0.0f, 0.0f, 0.0f);
        (this.LClaw4 = new ModelRenderer((ModelBase) this, 16, 10)).addBox(0.0f, 14.0f, 2.0f, 0, 2, 3);
        this.LClaw4.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.LClaw4.setTextureSize(256, 128);
        this.LClaw4.mirror = true;
        this.setRotation(this.LClaw4, 0.0f, 0.0f, 0.0f);
        (this.Rfoot1 = new ModelRenderer((ModelBase) this, 29, 50)).addBox(-2.0f, 14.0f, -5.0f, 2, 2, 6);
        this.Rfoot1.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rfoot1.setTextureSize(256, 128);
        this.Rfoot1.mirror = true;
        this.setRotation(this.Rfoot1, 0.0f, 0.0f, 0.0f);
        (this.Rfoot2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.0f, 14.0f, -1.0f, 2, 2, 4);
        this.Rfoot2.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rfoot2.setTextureSize(256, 128);
        this.Rfoot2.mirror = true;
        this.setRotation(this.Rfoot2, 0.0f, 0.0f, 0.0f);
        (this.Rclaw1 = new ModelRenderer((ModelBase) this, 16, 10)).addBox(-1.0f, 14.0f, -7.0f, 0, 2, 3);
        this.Rclaw1.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rclaw1.setTextureSize(256, 128);
        this.Rclaw1.mirror = true;
        this.setRotation(this.Rclaw1, 0.0f, 0.0f, 0.0f);
        (this.Rfoot3 = new ModelRenderer((ModelBase) this, 0, 9)).addBox(-2.0f, 15.0f, -4.0f, 2, 1, 5);
        this.Rfoot3.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rfoot3.setTextureSize(256, 128);
        this.Rfoot3.mirror = true;
        this.setRotation(this.Rfoot3, 0.0f, -0.260246f, 0.0f);
        (this.Rclaw3 = new ModelRenderer((ModelBase) this, 19, 16)).addBox(-0.5f, 15.0f, -5.0f, 0, 1, 3);
        this.Rclaw3.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rclaw3.setTextureSize(256, 128);
        this.Rclaw3.mirror = true;
        this.setRotation(this.Rclaw3, 0.0f, -0.260246f, 0.0f);
        (this.Rfoot4 = new ModelRenderer((ModelBase) this, 0, 9)).addBox(-2.0f, 15.0f, -4.0f, 2, 1, 5);
        this.Rfoot4.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rfoot4.setTextureSize(256, 128);
        this.Rfoot4.mirror = true;
        this.setRotation(this.Rfoot4, 0.0f, 0.2602503f, 0.0f);
        (this.Rclaw2 = new ModelRenderer((ModelBase) this, 19, 16)).addBox(-1.5f, 15.0f, -5.0f, 0, 1, 3);
        this.Rclaw2.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rclaw2.setTextureSize(256, 128);
        this.Rclaw2.mirror = true;
        this.setRotation(this.Rclaw2, 0.0f, 0.260246f, 0.0f);
        (this.Rclaw4 = new ModelRenderer((ModelBase) this, 16, 10)).addBox(-1.0f, 14.0f, 2.0f, 0, 2, 3);
        this.Rclaw4.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.Rclaw4.setTextureSize(256, 128);
        this.Rclaw4.mirror = true;
        this.setRotation(this.Rclaw4, 0.0f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase) this, 17, 96)).addBox(-3.0f, 0.0f, 0.0f, 6, 7, 3);
        this.Body3.setRotationPoint(0.0f, 2.0f, 6.0f);
        this.Body3.setTextureSize(256, 128);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 33, 81)).addBox(-2.0f, 0.0f, 0.0f, 4, 0, 14);
        this.Tail1.setRotationPoint(0.0f, 3.0f, 9.0f);
        this.Tail1.setTextureSize(256, 128);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, -0.5948578f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 36, 97)).addBox(-1.0f, 0.0f, 0.0f, 3, 0, 13);
        this.Tail2.setRotationPoint(0.0f, 3.0f, 8.0f);
        this.Tail2.setTextureSize(256, 128);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, -0.5948578f, 0.3346075f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 36, 97)).addBox(-2.0f, 0.0f, 0.0f, 3, 0, 13);
        this.Tail3.setRotationPoint(0.0f, 3.0f, 8.0f);
        this.Tail3.setTextureSize(256, 128);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, -0.5948578f, -0.3346145f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase) this, 17, 89)).addBox(-2.0f, 0.0f, 0.0f, 4, 3, 3);
        this.Body4.setRotationPoint(0.0f, 6.0f, 7.0f);
        this.Body4.setTextureSize(256, 128);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 1.003822f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 74, 48)).addBox(-1.0f, -24.0f, -7.0f, 2, 2, 4);
        this.head.setRotationPoint(0.0f, 5.0f, -7.0f);
        this.head.setTextureSize(256, 128);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 6, 5);
        this.leftleg.setRotationPoint(3.0f, 8.0f, 1.0f);
        this.leftleg.setTextureSize(256, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, -0.2974289f, 0.0f, 0.0f);
        (this.Neck1 = new ModelRenderer((ModelBase) this, 79, 84)).addBox(-1.5f, -21.0f, -2.0f, 3, 21, 3);
        this.Neck1.setRotationPoint(0.0f, 5.0f, -7.0f);
        this.Neck1.setTextureSize(256, 128);
        this.Neck1.mirror = true;
        this.setRotation(this.Neck1, 0.0f, -0.0349066f, 0.0f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 0, 70)).addBox(-2.0f, -25.0f, -3.0f, 4, 4, 4);
        this.Head1.setRotationPoint(0.0f, 5.0f, -7.0f);
        this.Head1.setTextureSize(256, 128);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.mouth1 = new ModelRenderer((ModelBase) this, 74, 64)).addBox(-1.0f, -22.0f, -6.0f, 2, 1, 3);
        this.mouth1.setRotationPoint(0.0f, 5.0f, -7.0f);
        this.mouth1.setTextureSize(256, 128);
        this.mouth1.mirror = true;
        this.setRotation(this.mouth1, 0.0f, 0.0f, 0.0f);
        (this.neck2 = new ModelRenderer((ModelBase) this, 0, 99)).addBox(-1.0f, -2.0f, -2.0f, 2, 4, 3);
        this.neck2.setRotationPoint(0.0f, 5.0f, -6.9f);
        this.neck2.setTextureSize(256, 128);
        this.neck2.mirror = true;
        this.setRotation(this.neck2, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-3.0f, 0.0f, -2.0f, 4, 6, 5);
        this.rightleg.setRotationPoint(-2.0f, 8.0f, 1.0f);
        this.rightleg.setTextureSize(256, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, -0.2974216f, 0.0f, 0.0f);
        (this.Lwing = new ModelRenderer((ModelBase) this, 0, 107)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 11);
        this.Lwing.setRotationPoint(4.0f, 1.0f, -5.0f);
        this.Lwing.setTextureSize(256, 128);
        this.Lwing.mirror = true;
        this.setRotation(this.Lwing, 0.0f, 0.0f, 0.0f);
        (this.Rwing = new ModelRenderer((ModelBase) this, 0, 107)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 11);
        this.Rwing.setRotationPoint(-5.0f, 1.0f, -5.0f);
        this.Rwing.setTextureSize(256, 128);
        this.Rwing.mirror = true;
        this.setRotation(this.Rwing, 0.0f, 0.0f, 0.0f);
        (this.Hat1 = new ModelRenderer((ModelBase) this, 40, 0)).addBox(-2.5f, -26.0f, -4.0f, 5, 1, 5);
        this.Hat1.setRotationPoint(0.0f, 5.0f, -7.0f);
        this.Hat1.setTextureSize(256, 128);
        this.Hat1.mirror = true;
        this.setRotation(this.Hat1, 0.0f, 0.0f, 0.0f);
        (this.Hat2 = new ModelRenderer((ModelBase) this, 40, 0)).addBox(-2.0f, -28.0f, -3.0f, 4, 2, 4);
        this.Hat2.setRotationPoint(0.0f, 5.0f, -7.0f);
        this.Hat2.setTextureSize(256, 128);
        this.Hat2.mirror = true;
        this.setRotation(this.Hat2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, float f3, final float f4,
        final float f5) {
        final Ostrich o = (Ostrich) entity;
        RenderInfo r = null;
        final float hf = 0.0f;
        float newangle = 0.0f;
        float nextangle = 0.0f;
        float lspeed = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        lspeed = (float) ((o.prevPosX - o.posX) * (o.prevPosX - o.posX)
            + (o.prevPosZ - o.posZ) * (o.prevPosZ - o.posZ));
        lspeed = (float) Math.sqrt(lspeed);
        newangle = MathHelper.cos(f2 * 1.25f * this.wingspeed) * 3.1415927f * lspeed * 0.4f;
        if (newangle > 0.5) {
            newangle = 0.75f;
        }
        if (newangle < -0.5) {
            newangle = -0.75f;
        }
        this.leftleg.rotateAngleX = -0.297f + newangle;
        this.LLeg1.rotateAngleX = 0.483f + newangle;
        this.LLeg2.rotateAngleX = -0.437f + newangle;
        this.Lfoot1.rotateAngleX = newangle;
        this.Lfoot2.rotateAngleX = newangle;
        this.Lfoot3.rotateAngleX = newangle;
        this.Lfoot4.rotateAngleX = newangle;
        this.LClaw1.rotateAngleX = newangle;
        this.LClaw2.rotateAngleX = newangle;
        this.LClaw3.rotateAngleX = newangle;
        this.LClaw4.rotateAngleX = newangle;
        this.rightleg.rotateAngleX = -0.297f - newangle;
        this.Rleg1.rotateAngleX = 0.483f - newangle;
        this.RLeg2.rotateAngleX = -0.437f - newangle;
        this.Rfoot1.rotateAngleX = -newangle;
        this.Rfoot2.rotateAngleX = -newangle;
        this.Rfoot3.rotateAngleX = -newangle;
        this.Rfoot4.rotateAngleX = -newangle;
        this.Rclaw1.rotateAngleX = -newangle;
        this.Rclaw2.rotateAngleX = -newangle;
        this.Rclaw3.rotateAngleX = -newangle;
        this.Rclaw4.rotateAngleX = -newangle;
        this.Tail1.rotateAngleX = -0.594f + MathHelper.cos(f2 * 0.05f) * 3.1415927f * 0.06f;
        this.Tail2.rotateAngleX = this.Tail1.rotateAngleX;
        this.Tail3.rotateAngleX = this.Tail1.rotateAngleX;
        this.Tail3.rotateAngleY = -0.334f + MathHelper.cos(f2 * 0.061f) * 3.1415927f * 0.08f;
        this.Tail2.rotateAngleY = 0.334f - MathHelper.cos(f2 * 0.072f) * 3.1415927f * 0.08f;
        r = o.getRenderInfo();
        if (o.riddenByEntity != null) {
            f3 = (o.prevRotationYaw - o.rotationYaw) * 20.0f;
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
        if (o.isSitting() && o.get_is_activated() == 0) {
            f3 = 0.0f;
            this.Head1.rotateAngleX = 3.1415f;
            this.head.rotateAngleX = this.Head1.rotateAngleX;
            this.mouth1.rotateAngleX = this.Head1.rotateAngleX;
            this.Neck1.rotateAngleX = this.Head1.rotateAngleX;
            this.Hat1.rotateAngleX = this.Head1.rotateAngleX;
            this.Hat2.rotateAngleX = this.Head1.rotateAngleX;
        } else {
            this.Head1.rotateAngleX = 0.0f;
            this.head.rotateAngleX = this.Head1.rotateAngleX;
            this.mouth1.rotateAngleX = this.Head1.rotateAngleX;
            this.Neck1.rotateAngleX = this.Head1.rotateAngleX;
            this.Hat1.rotateAngleX = this.Head1.rotateAngleX;
            this.Hat2.rotateAngleX = this.Head1.rotateAngleX;
        }
        this.Head1.rotateAngleY = (float) Math.toRadians(f3) * 0.65f;
        this.head.rotateAngleY = this.Head1.rotateAngleY;
        this.mouth1.rotateAngleY = this.Head1.rotateAngleY;
        this.Hat1.rotateAngleY = this.Head1.rotateAngleY;
        this.Hat2.rotateAngleY = this.Head1.rotateAngleY;
        newangle = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.3f) * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (o.worldObj.rand.nextInt(3) == 1) {
                r.ri1 = 1;
            }
        }
        if (r.ri1 == 0) {
            newangle = 0.0f;
        }
        newangle = Math.abs(newangle);
        this.Lwing.rotateAngleZ = -newangle;
        this.Lwing.rotateAngleY = newangle / 2.0f;
        this.Rwing.rotateAngleZ = newangle;
        this.Rwing.rotateAngleY = -newangle / 2.0f;
        o.setRenderInfo(r);
        this.Body1.render(f5);
        this.body2.render(f5);
        this.LLeg1.render(f5);
        this.Rleg1.render(f5);
        this.LLeg2.render(f5);
        this.Lfoot1.render(f5);
        this.RLeg2.render(f5);
        this.Lfoot2.render(f5);
        this.Lfoot3.render(f5);
        this.LClaw1.render(f5);
        this.LClaw2.render(f5);
        this.LClaw3.render(f5);
        this.Lfoot4.render(f5);
        this.LClaw4.render(f5);
        this.Rfoot1.render(f5);
        this.Rfoot2.render(f5);
        this.Rclaw1.render(f5);
        this.Rfoot3.render(f5);
        this.Rclaw3.render(f5);
        this.Rfoot4.render(f5);
        this.Rclaw2.render(f5);
        this.Rclaw4.render(f5);
        this.Body3.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.Body4.render(f5);
        this.head.render(f5);
        this.leftleg.render(f5);
        this.Neck1.render(f5);
        this.Head1.render(f5);
        this.mouth1.render(f5);
        this.neck2.render(f5);
        this.rightleg.render(f5);
        this.Lwing.render(f5);
        this.Rwing.render(f5);
        if (o instanceof EntityCannonFodder && o.get_is_activated() != 0) {
            this.Hat1.render(f5);
            if (o.get_is_activated() > 1) {
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
