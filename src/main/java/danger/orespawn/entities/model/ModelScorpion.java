
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import danger.orespawn.entities.entityinstance.Scorpion;
import danger.orespawn.entities.renderer.RenderInfo;

public class ModelScorpion extends ModelBase {

    private float wingspeed;
    ModelRenderer body;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tail4;
    ModelRenderer tail5;
    ModelRenderer tail6;
    ModelRenderer lleg1;
    ModelRenderer rleg1;
    ModelRenderer rleg2;
    ModelRenderer lleg3;
    ModelRenderer rleg4;
    ModelRenderer rleg3;
    ModelRenderer lleg4;
    ModelRenderer lleg2;
    ModelRenderer head;
    ModelRenderer larm2;
    ModelRenderer rarm2;
    ModelRenderer larm1;
    ModelRenderer rarm1;
    ModelRenderer lclaw;
    ModelRenderer rclaw;

    public ModelScorpion(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 88;
        this.textureHeight = 24;
        (this.body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 8);
        this.body.setRotationPoint(-3.0f, 17.0f, -4.0f);
        this.body.setTextureSize(88, 24);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 28, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 5);
        this.tail1.setRotationPoint(-2.0f, 17.0f, 3.0f);
        this.tail1.setTextureSize(88, 24);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.2617994f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 46, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 5);
        this.tail2.setRotationPoint(-1.5f, 16.8f, 6.0f);
        this.tail2.setTextureSize(88, 24);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 1.029744f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase) this, 62, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.tail3.setRotationPoint(-1.5f, 14.5f, 8.0f);
        this.tail3.setTextureSize(88, 24);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, 1.727876f, 0.0f, 0.0f);
        (this.tail4 = new ModelRenderer((ModelBase) this, 0, 17)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 5);
        this.tail4.setRotationPoint(-1.0f, 12.0f, 9.0f);
        this.tail4.setTextureSize(88, 24);
        this.tail4.mirror = true;
        this.setRotation(this.tail4, 2.513274f, 0.0f, 0.0f);
        (this.tail5 = new ModelRenderer((ModelBase) this, 70, 7)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.tail5.setRotationPoint(-1.0f, 9.0f, 6.0f);
        this.tail5.setTextureSize(88, 24);
        this.tail5.mirror = true;
        this.setRotation(this.tail5, 3.141593f, 0.0f, 0.0f);
        (this.tail6 = new ModelRenderer((ModelBase) this, 62, 7)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.tail6.setRotationPoint(-0.5f, 8.0f, 2.0f);
        this.tail6.setTextureSize(88, 24);
        this.tail6.mirror = true;
        this.setRotation(this.tail6, 3.141593f, 0.0f, 0.0f);
        (this.lleg1 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.lleg1.setRotationPoint(2.0f, 18.0f, -3.0f);
        this.lleg1.setTextureSize(88, 24);
        this.lleg1.mirror = true;
        this.setRotation(this.lleg1, 0.0f, 0.4886922f, 0.3665191f);
        (this.rleg1 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.rleg1.setRotationPoint(-2.0f, 18.0f, -1.0f);
        this.rleg1.setTextureSize(88, 24);
        this.rleg1.mirror = true;
        this.setRotation(this.rleg1, 0.0f, 2.6529f, -0.3665191f);
        (this.rleg2 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.rleg2.setRotationPoint(-2.0f, 18.0f, 1.0f);
        this.rleg2.setTextureSize(88, 24);
        this.rleg2.mirror = true;
        this.setRotation(this.rleg2, 0.0f, 2.897247f, -0.3665191f);
        (this.lleg3 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.lleg3.setRotationPoint(2.0f, 18.0f, 1.0f);
        this.lleg3.setTextureSize(88, 24);
        this.lleg3.mirror = true;
        this.setRotation(this.lleg3, 0.0f, -0.2443461f, 0.3665191f);
        (this.rleg4 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.rleg4.setRotationPoint(-2.0f, 18.0f, 5.0f);
        this.rleg4.setTextureSize(88, 24);
        this.rleg4.mirror = true;
        this.setRotation(this.rleg4, 0.0f, -2.6529f, -0.3665191f);
        (this.rleg3 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.rleg3.setRotationPoint(-2.0f, 18.0f, 3.0f);
        this.rleg3.setTextureSize(88, 24);
        this.rleg3.mirror = true;
        this.setRotation(this.rleg3, 0.0f, -2.897247f, -0.3665191f);
        (this.lleg4 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.lleg4.setRotationPoint(2.0f, 18.0f, 3.0f);
        this.lleg4.setTextureSize(88, 24);
        this.lleg4.mirror = true;
        this.setRotation(this.lleg4, 0.0f, -0.4886922f, 0.3665191f);
        (this.lleg2 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 11, 2, 2);
        this.lleg2.setRotationPoint(2.0f, 18.0f, -1.0f);
        this.lleg2.setTextureSize(88, 24);
        this.lleg2.mirror = true;
        this.setRotation(this.lleg2, 0.0f, 0.2443461f, 0.3665191f);
        (this.head = new ModelRenderer((ModelBase) this, 28, 9)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 4);
        this.head.setRotationPoint(-2.5f, 17.5f, -8.0f);
        this.head.setTextureSize(88, 24);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.larm2 = new ModelRenderer((ModelBase) this, 46, 8)).addBox(0.0f, 0.0f, 0.0f, 6, 2, 2);
        this.larm2.setRotationPoint(1.0f, 18.0f, -6.0f);
        this.larm2.setTextureSize(88, 24);
        this.larm2.mirror = true;
        this.setRotation(this.larm2, 0.0f, 0.5235988f, 0.1745329f);
        (this.rarm2 = new ModelRenderer((ModelBase) this, 46, 8)).addBox(0.0f, 0.0f, -2.0f, 6, 2, 2);
        this.rarm2.setRotationPoint(-1.0f, 18.0f, -6.0f);
        this.rarm2.setTextureSize(88, 24);
        this.rarm2.mirror = true;
        this.setRotation(this.rarm2, 0.0f, 2.617994f, -0.1745329f);
        (this.larm1 = new ModelRenderer((ModelBase) this, 70, 13)).addBox(-2.0f, 0.0f, -3.0f, 2, 2, 3);
        this.larm1.setRotationPoint(7.0f, 19.0f, -7.2f);
        this.larm1.setTextureSize(88, 24);
        this.larm1.mirror = true;
        this.setRotation(this.larm1, 0.1745329f, 0.1745329f, 0.0f);
        (this.rarm1 = new ModelRenderer((ModelBase) this, 70, 13)).addBox(0.0f, 0.0f, -3.0f, 2, 2, 3);
        this.rarm1.setRotationPoint(-7.0f, 19.0f, -7.2f);
        this.rarm1.setTextureSize(88, 24);
        this.rarm1.mirror = true;
        this.setRotation(this.rarm1, 0.1745329f, -0.1745329f, 0.0f);
        (this.lclaw = new ModelRenderer((ModelBase) this, 46, 12)).addBox(-3.0f, 0.0f, -4.0f, 3, 2, 4);
        this.lclaw.setRotationPoint(7.0f, 19.0f, -10.0f);
        this.lclaw.setTextureSize(88, 24);
        this.lclaw.mirror = true;
        this.setRotation(this.lclaw, 0.0174533f, 0.3839724f, 0.1396263f);
        (this.rclaw = new ModelRenderer((ModelBase) this, 46, 12)).addBox(0.0f, 0.0f, -4.0f, 3, 2, 4);
        this.rclaw.setRotationPoint(-7.0f, 19.0f, -10.0f);
        this.rclaw.setTextureSize(88, 24);
        this.rclaw.mirror = true;
        this.setRotation(this.rclaw, 0.0174533f, -0.3839724f, 0.1396263f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Scorpion e = (Scorpion) entity;
        RenderInfo r = null;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float upangle = 0.0f;
        float nextangle = 0.0f;
        final float pi4 = 1.570795f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        this.lleg1.rotateAngleY = newangle + 0.49f;
        this.rleg1.rotateAngleY = -newangle + 2.65f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed - 1.0f * pi4) * 3.1415927f * 0.12f * f1;
        this.lleg2.rotateAngleY = newangle + 0.24f;
        this.rleg2.rotateAngleY = -newangle + 2.9f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed - 2.0f * pi4) * 3.1415927f * 0.12f * f1;
        this.lleg3.rotateAngleY = newangle - 0.24f;
        this.rleg3.rotateAngleY = -newangle - 2.9f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed - 3.0f * pi4) * 3.1415927f * 0.12f * f1;
        this.lleg4.rotateAngleY = newangle - 0.49f;
        this.rleg4.rotateAngleY = -newangle - 2.65f;
        r = e.getRenderInfo();
        newangle = MathHelper.cos(f2 * 3.0f * this.wingspeed) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.1f) * 3.0f * this.wingspeed) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() == 0) {
                r.ri1 = e.worldObj.rand.nextInt(20);
                r.ri2 = e.worldObj.rand.nextInt(25);
            } else {
                r.ri1 = e.worldObj.rand.nextInt(4);
                r.ri2 = e.worldObj.rand.nextInt(3);
            }
        }
        if (r.ri1 == 1 || r.ri1 == 3) {
            this.doLeftClaw(newangle);
        } else {
            this.doLeftClaw(0.0f);
        }
        if (r.ri1 == 2 || r.ri1 == 3) {
            this.doRightClaw(newangle);
        } else {
            this.doRightClaw(0.0f);
        }
        if (r.ri2 == 1) {
            this.doTail(newangle);
        } else {
            this.doTail(0.0f);
        }
        e.setRenderInfo(r);
        this.body.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.tail4.render(f5);
        this.tail5.render(f5);
        this.tail6.render(f5);
        this.lleg1.render(f5);
        this.rleg1.render(f5);
        this.rleg2.render(f5);
        this.lleg3.render(f5);
        this.rleg4.render(f5);
        this.rleg3.render(f5);
        this.lleg4.render(f5);
        this.lleg2.render(f5);
        this.head.render(f5);
        this.larm2.render(f5);
        this.rarm2.render(f5);
        this.larm1.render(f5);
        this.rarm1.render(f5);
        this.lclaw.render(f5);
        this.rclaw.render(f5);
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

    private void doLeftClaw(final float angle) {
        this.larm2.rotateAngleY = 0.52f + angle;
        this.larm1.rotationPointZ = (float) (this.larm2.rotationPointZ - Math.sin(this.larm2.rotateAngleY) * 4.5);
        this.lclaw.rotationPointZ = this.larm1.rotationPointZ - 3.0f;
        this.lclaw.rotateAngleY = 0.381f - angle;
    }

    private void doRightClaw(final float angle) {
        this.rarm2.rotateAngleY = 2.61f - angle;
        this.rarm1.rotationPointZ = (float) (this.rarm2.rotationPointZ - Math.sin(this.rarm2.rotateAngleY) * 4.5);
        this.rclaw.rotationPointZ = this.rarm1.rotationPointZ - 3.0f;
        this.rclaw.rotateAngleY = -0.381f + angle;
    }

    private void doTail(final float angle) {
        this.tail1.rotateAngleX = 0.26f + angle;
        this.tail2.rotateAngleX = this.tail1.rotateAngleX + 0.76900005f + angle;
        this.tail2.rotationPointY = (float) (this.tail1.rotationPointY - Math.sin(this.tail1.rotateAngleX) * 4.0);
        this.tail2.rotationPointZ = (float) (this.tail1.rotationPointZ + Math.cos(this.tail1.rotateAngleX) * 4.0);
        this.tail3.rotateAngleX = this.tail2.rotateAngleX + 0.701f + angle;
        this.tail3.rotationPointY = (float) (this.tail2.rotationPointY - Math.sin(this.tail2.rotateAngleX) * 4.0);
        this.tail3.rotationPointZ = (float) (this.tail2.rotationPointZ + Math.cos(this.tail2.rotateAngleX) * 4.0);
        this.tail4.rotateAngleX = this.tail3.rotateAngleX - 5.501f - angle * 3.0f / 2.0f - 0.4f;
        this.tail4.rotationPointY = (float) (this.tail3.rotationPointY - Math.sin(this.tail3.rotateAngleX) * 3.0);
        this.tail4.rotationPointZ = (float) (this.tail3.rotationPointZ + Math.cos(this.tail3.rotateAngleX) * 3.0);
        this.tail5.rotationPointY = (float) (this.tail4.rotationPointY - Math.sin(this.tail4.rotateAngleX) * 4.0);
        this.tail5.rotationPointZ = (float) (this.tail4.rotationPointZ + Math.cos(this.tail4.rotateAngleX) * 4.0);
        this.tail6.rotationPointY = (float) (this.tail5.rotationPointY - Math.sin(this.tail5.rotateAngleX) * 4.0);
        this.tail6.rotationPointZ = (float) (this.tail5.rotationPointZ + Math.cos(this.tail5.rotateAngleX) * 4.0);
    }
}
