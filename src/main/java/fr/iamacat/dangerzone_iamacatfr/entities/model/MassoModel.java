
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class MassoModel extends ModelBase {

    private float field_78152_i;
    ModelRenderer Head1;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Body;
    ModelRenderer Chest;
    ModelRenderer RightLegThigh;
    ModelRenderer RightLegLower1;
    ModelRenderer RightFoot;
    ModelRenderer RightThigh;
    ModelRenderer RightLegLower2;
    ModelRenderer Foot2;
    ModelRenderer Upperarm1;
    ModelRenderer Forearm1;
    ModelRenderer Hand1;
    ModelRenderer Claw1;
    ModelRenderer Upperarm2;
    ModelRenderer Forearm2;
    ModelRenderer Hand2;
    ModelRenderer Claw2;
    ModelRenderer TailBase;
    ModelRenderer Tail;
    ModelRenderer TailMiddle;
    ModelRenderer TailEnd;
    ModelRenderer TailTip;
    ModelRenderer Head2;
    ModelRenderer Head3;

    public MassoModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Head1 = new ModelRenderer(this, 0, 17)).addBox(-2.0f, 0.0f, -10.0f, 4, 3, 1);
        this.Head1.setRotationPoint(0.0f, 0.0f, -33.0f);
        this.Head1.setTextureSize(128, 128);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, 0.0f, 0.0f, 0.0f);
        (this.Neck1 = new ModelRenderer(this, 32, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 18);
        this.Neck1.setRotationPoint(-2.0f, -1.5f, -34.0f);
        this.Neck1.setTextureSize(128, 128);
        this.Neck1.mirror = true;
        this.setRotation(this.Neck1, -0.2443461f, 0.0f, 0.0f);
        (this.Neck2 = new ModelRenderer((ModelBase) this, 77, 1)).addBox(0.0f, 0.0f, 0.0f, 5, 6, 9);
        this.Neck2.setRotationPoint(-2.5f, 2.0f, -18.0f);
        this.Neck2.setTextureSize(128, 128);
        this.Neck2.mirror = true;
        this.setRotation(this.Neck2, -0.1570796f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase) this, 42, 24)).addBox(-5.0f, -2.0f, -3.0f, 12, 17, 12);
        this.Body.setRotationPoint(-1.0f, 10.0f, 0.0f);
        this.Body.setTextureSize(128, 128);
        this.Body.mirror = true;
        this.setRotation(this.Body, 1.570796f, 0.0f, 0.0f);
        (this.Chest = new ModelRenderer((ModelBase) this, 1, 24)).addBox(0.0f, -1.0f, 2.0f, 10, 10, 10);
        this.Chest.setRotationPoint(-5.0f, 13.0f, -10.0f);
        this.Chest.setTextureSize(128, 128);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 1.48353f, 0.0f, 0.0f);
        (this.RightLegThigh = new ModelRenderer((ModelBase) this, 71, 81)).addBox(-4.0f, -1.0f, -3.0f, 3, 12, 7);
        this.RightLegThigh.setRotationPoint(-3.5f, 5.0f, 8.0f);
        this.RightLegThigh.setTextureSize(128, 128);
        this.RightLegThigh.mirror = true;
        this.setRotation(this.RightLegThigh, 0.0f, 0.0f, 0.0f);
        (this.RightLegLower1 = new ModelRenderer((ModelBase) this, 71, 111)).addBox(-3.0f, 11.0f, 0.0f, 2, 6, 3);
        this.RightLegLower1.setRotationPoint(-3.5f, 5.0f, 9.0f);
        this.RightLegLower1.setTextureSize(128, 128);
        this.RightLegLower1.mirror = true;
        this.setRotation(this.RightLegLower1, 0.0f, 0.0f, 0.0f);
        (this.RightFoot = new ModelRenderer((ModelBase) this, 71, 120)).addBox(-3.5f, 16.0f, -2.0f, 3, 2, 6);
        this.RightFoot.setRotationPoint(-3.5f, 6.0f, 8.0f);
        this.RightFoot.setTextureSize(128, 128);
        this.RightFoot.mirror = true;
        this.setRotation(this.RightFoot, 0.0f, 0.0f, 0.0f);
        (this.RightThigh = new ModelRenderer((ModelBase) this, 94, 81)).addBox(0.0f, -1.0f, -3.0f, 3, 12, 7);
        this.RightThigh.setRotationPoint(4.5f, 5.0f, 8.0f);
        this.RightThigh.setTextureSize(128, 128);
        this.RightThigh.mirror = true;
        this.setRotation(this.RightThigh, 0.0f, 0.0f, 0.0f);
        (this.RightLegLower2 = new ModelRenderer((ModelBase) this, 94, 110)).addBox(1.0f, 10.0f, 1.0f, 2, 6, 3);
        this.RightLegLower2.setRotationPoint(3.5f, 6.0f, 8.0f);
        this.RightLegLower2.setTextureSize(128, 128);
        this.RightLegLower2.mirror = true;
        this.setRotation(this.RightLegLower2, 0.0f, 0.0f, 0.0f);
        (this.Foot2 = new ModelRenderer((ModelBase) this, 71, 120)).addBox(0.5f, 16.0f, -2.0f, 3, 2, 6);
        this.Foot2.setRotationPoint(3.5f, 6.0f, 8.0f);
        this.Foot2.setTextureSize(128, 128);
        this.Foot2.mirror = true;
        this.setRotation(this.Foot2, 0.0f, 0.0f, 0.0f);
        (this.Upperarm1 = new ModelRenderer((ModelBase) this, 93, 44)).addBox(-1.0f, 0.0f, -1.0f, 2, 7, 3);
        this.Upperarm1.setRotationPoint(-4.5f, 8.0f, -8.0f);
        this.Upperarm1.setTextureSize(128, 128);
        this.Upperarm1.mirror = true;
        this.setRotation(this.Upperarm1, 0.5235988f, 0.0f, 0.0f);
        (this.Forearm1 = new ModelRenderer((ModelBase) this, 93, 55)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 2);
        this.Forearm1.setRotationPoint(-5.5f, 12.0f, -4.0f);
        this.Forearm1.setTextureSize(128, 128);
        this.Forearm1.mirror = true;
        this.setRotation(this.Forearm1, -0.5410521f, -0.1047198f, -0.1745329f);
        (this.Hand1 = new ModelRenderer((ModelBase) this, 93, 65)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Hand1.setRotationPoint(-4.0f, 17.9f, -7.6f);
        this.Hand1.setTextureSize(128, 128);
        this.Hand1.mirror = true;
        this.setRotation(this.Hand1, -0.3141593f, -0.1570796f, -0.2792527f);
        (this.Claw1 = new ModelRenderer((ModelBase) this, 93, 71)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 0);
        this.Claw1.setRotationPoint(-4.0f, 17.9f, -7.6f);
        this.Claw1.setTextureSize(128, 128);
        this.Claw1.mirror = true;
        this.setRotation(this.Claw1, -0.6108652f, -0.3665191f, -0.2792527f);
        (this.Upperarm2 = new ModelRenderer((ModelBase) this, 104, 44)).addBox(0.0f, 0.0f, -1.0f, 2, 7, 3);
        this.Upperarm2.setRotationPoint(3.5f, 8.0f, -8.0f);
        this.Upperarm2.setTextureSize(128, 128);
        this.Upperarm2.mirror = true;
        this.setRotation(this.Upperarm2, 0.6108652f, 0.0f, 0.0f);
        (this.Forearm2 = new ModelRenderer((ModelBase) this, 104, 55)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 2);
        this.Forearm2.setRotationPoint(4.5f, 12.0f, -4.0f);
        this.Forearm2.setTextureSize(128, 128);
        this.Forearm2.mirror = true;
        this.setRotation(this.Forearm2, -0.5410521f, 0.0872665f, 0.1745329f);
        (this.Hand2 = new ModelRenderer((ModelBase) this, 104, 65)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.Hand2.setRotationPoint(3.1f, 17.8f, -7.6f);
        this.Hand2.setTextureSize(128, 128);
        this.Hand2.mirror = true;
        this.setRotation(this.Hand2, -0.3141593f, 0.1570796f, 0.2792527f);
        (this.Claw2 = new ModelRenderer((ModelBase) this, 104, 71)).addBox(0.0f, 0.0f, 0.0f, 2, 3, 0);
        this.Claw2.setRotationPoint(2.1f, 17.5f, -7.1f);
        this.Claw2.setTextureSize(128, 128);
        this.Claw2.mirror = true;
        this.setRotation(this.Claw2, -0.6108652f, 0.3665191f, 0.2792527f);
        (this.TailBase = new ModelRenderer((ModelBase) this, 91, 25)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 10);
        this.TailBase.setRotationPoint(-4.0f, 11.5f, 13.0f);
        this.TailBase.setTextureSize(128, 128);
        this.TailBase.mirror = true;
        this.setRotation(this.TailBase, 1.570796f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase) this, 1, 54)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 14);
        this.Tail.setRotationPoint(-3.0f, 2.0f, 20.0f);
        this.Tail.setTextureSize(128, 128);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, -0.0698132f, 0.0f, 0.0f);
        (this.TailMiddle = new ModelRenderer((ModelBase) this, 42, 54)).addBox(0.0f, 0.0f, 0.0f, 5, 6, 20);
        this.TailMiddle.setRotationPoint(-2.5f, 4.0f, 33.0f);
        this.TailMiddle.setTextureSize(128, 128);
        this.TailMiddle.mirror = true;
        this.setRotation(this.TailMiddle, -0.1745329f, 0.0f, 0.0f);
        (this.TailEnd = new ModelRenderer((ModelBase) this, 1, 81)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 15);
        this.TailEnd.setRotationPoint(-2.0f, 8.5f, 52.0f);
        this.TailEnd.setTextureSize(128, 128);
        this.TailEnd.mirror = true;
        this.setRotation(this.TailEnd, -0.0698132f, 0.0f, 0.0f);
        (this.TailTip = new ModelRenderer((ModelBase) this, 40, 81)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 12);
        this.TailTip.setRotationPoint(-1.5f, 10.0f, 65.0f);
        this.TailTip.setTextureSize(128, 128);
        this.TailTip.mirror = true;
        this.setRotation(this.TailTip, -0.0349066f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(-2.5f, -2.0f, -7.0f, 5, 5, 7);
        this.Head2.setRotationPoint(0.0f, 0.0f, -33.0f);
        this.Head2.setTextureSize(128, 128);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.Head3 = new ModelRenderer((ModelBase) this, 13, 16)).addBox(-2.0f, -1.0f, -9.0f, 4, 4, 3);
        this.Head3.setRotationPoint(0.0f, 0.0f, -33.0f);
        this.Head3.setTextureSize(128, 128);
        this.Head3.mirror = true;
        this.setRotation(this.Head3, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5);
        this.Head1.render(f5);
        this.Neck1.render(f5);
        this.Neck2.render(f5);
        this.Body.render(f5);
        this.Chest.render(f5);
        this.RightLegThigh.render(f5);
        this.RightLegLower1.render(f5);
        this.RightFoot.render(f5);
        this.RightThigh.render(f5);
        this.RightLegLower2.render(f5);
        this.Foot2.render(f5);
        this.Upperarm1.render(f5);
        this.Forearm1.render(f5);
        this.Hand1.render(f5);
        this.Claw1.render(f5);
        this.Upperarm2.render(f5);
        this.Forearm2.render(f5);
        this.Hand2.render(f5);
        this.Claw2.render(f5);
        this.TailBase.render(f5);
        this.Tail.render(f5);
        this.TailMiddle.render(f5);
        this.TailEnd.render(f5);
        this.TailTip.render(f5);
        this.Head2.render(f5);
        this.Head3.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4,
        final float f5) {
        this.Foot2.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.RightLegLower2.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.RightThigh.rotateAngleX = MathHelper.cos(f * 0.6662f) * 1.4f * f1;
        this.RightFoot.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightLegLower1.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.RightLegThigh.rotateAngleX = MathHelper.cos(f * 0.6662f + 3.1415927f) * 1.4f * f1;
        this.Head1.rotateAngleY = f3 / 57.29578f;
        this.Head1.rotateAngleX = f4 / 57.29578f;
        this.Head2.rotateAngleY = f3 / 57.29578f;
        this.Head2.rotateAngleX = f4 / 57.29578f;
        this.Head3.rotateAngleY = f3 / 57.29578f;
        this.Head3.rotateAngleX = f4 / 57.29578f;
    }
}
