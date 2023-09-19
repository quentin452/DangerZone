
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TRex;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelTRex extends ModelBase {

    private float wingspeed;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer jaw;
    ModelRenderer leftleg;
    ModelRenderer leftleg2;
    ModelRenderer leftleg3;
    ModelRenderer Shape11;
    ModelRenderer rightleg;
    ModelRenderer rightleg2;
    ModelRenderer rightleg3;
    ModelRenderer leftleg4;
    ModelRenderer rightleg4;
    ModelRenderer Shape17;
    ModelRenderer TailExtension;
    ModelRenderer Spine1;
    ModelRenderer Spine2;
    ModelRenderer Spine3;
    ModelRenderer Spine4;
    ModelRenderer Spine5;

    public ModelTRex(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.wingspeed = f1;
        (this.Shape18 = new ModelRenderer((ModelBase) this, 91, 114)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.Shape18.setRotationPoint(3.3f, -25.0f, -23.0f);
        this.Shape18.setTextureSize(128, 128);
        this.Shape18.mirror = true;
        this.setRotation(this.Shape18, 0.5759587f, 0.0f, 0.5585054f);
        (this.Shape19 = new ModelRenderer((ModelBase) this, 71, 114)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 5);
        this.Shape19.setRotationPoint(-4.0f, -24.0f, -23.0f);
        this.Shape19.setTextureSize(128, 128);
        this.Shape19.mirror = true;
        this.setRotation(this.Shape19, 0.5759587f, 0.0f, -0.5585054f);
        (this.Shape20 = new ModelRenderer((ModelBase) this, 91, 30)).addBox(0.0f, 0.0f, 0.0f, 2, 7, 5);
        this.Shape20.setRotationPoint(5.0f, -8.0f, -6.0f);
        this.Shape20.setTextureSize(128, 128);
        this.Shape20.mirror = true;
        this.setRotation(this.Shape20, 0.3839724f, 0.0f, 0.0f);
        (this.Shape21 = new ModelRenderer((ModelBase) this, 93, 46)).addBox(-2.0f, 0.0f, 0.0f, 2, 7, 5);
        this.Shape21.setRotationPoint(-4.0f, -8.0f, -6.0f);
        this.Shape21.setTextureSize(128, 128);
        this.Shape21.mirror = true;
        this.setRotation(this.Shape21, 0.3839724f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-7.0f, 0.0f, 0.0f, 10, 18, 31);
        this.Shape1.setRotationPoint(2.5f, -19.0f, -8.0f);
        this.Shape1.setTextureSize(128, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase) this, 62, 0)).addBox(-5.0f, 0.0f, 0.0f, 10, 11, 11);
        this.Shape2.setRotationPoint(0.5f, -19.0f, 23.0f);
        this.Shape2.setTextureSize(128, 128);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 10, 54)).addBox(-3.0f, 0.0f, 0.0f, 7, 7, 25);
        this.Shape3.setRotationPoint(0.0f, -19.0f, 34.0f);
        this.Shape3.setTextureSize(128, 128);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase) this, 68, 88)).addBox(-5.0f, 0.0f, 0.0f, 8, 9, 16);
        this.Shape4.setRotationPoint(1.5f, -25.0f, -16.0f);
        this.Shape4.setTextureSize(128, 128);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, -0.4014257f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase) this, 75, 65)).addBox(0.0f, 0.0f, 0.0f, 9, 9, 12);
        this.Shape5.setRotationPoint(-4.0f, -25.0f, -27.0f);
        this.Shape5.setTextureSize(128, 128);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase) this, 0, 50)).addBox(0.0f, 0.0f, 0.0f, 7, 9, 9);
        this.Shape6.setRotationPoint(-3.0f, -25.0f, -36.0f);
        this.Shape6.setTextureSize(128, 128);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 0, 86)).addBox(-5.0f, 0.0f, -10.0f, 7, 1, 13);
        this.jaw.setRotationPoint(2.0f, -15.0f, -24.0f);
        this.jaw.setTextureSize(128, 128);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.5201081f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, 0.0f, 3, 16, 10);
        this.leftleg.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, -0.1745329f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase) this, 0, 106)).addBox(-1.0f, 12.0f, -8.0f, 3, 15, 5);
        this.leftleg2.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg2.setTextureSize(128, 128);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, 0.5061455f, 0.0f, 0.0f);
        (this.leftleg3 = new ModelRenderer((ModelBase) this, 112, 89)).addBox(-1.0f, 19.0f, 16.0f, 3, 9, 3);
        this.leftleg3.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg3.setTextureSize(128, 128);
        this.leftleg3.mirror = true;
        this.setRotation(this.leftleg3, -0.4014257f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase) this, 0, 72)).addBox(0.0f, 0.0f, 0.0f, 2, 10, 2);
        this.Shape11.setRotationPoint(5.0f, -5.0f, -3.0f);
        this.Shape11.setTextureSize(128, 128);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, -0.5235988f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase) this, 54, 51)).addBox(0.0f, 0.0f, 0.0f, 3, 16, 10);
        this.rightleg.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, -0.1745329f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase) this, 23, 106)).addBox(0.0f, 12.0f, -8.0f, 3, 15, 5);
        this.rightleg2.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg2.setTextureSize(128, 128);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, 0.5061455f, 0.0f, 0.0f);
        (this.rightleg3 = new ModelRenderer((ModelBase) this, 70, 90)).addBox(0.0f, 19.0f, 16.0f, 3, 9, 3);
        this.rightleg3.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg3.setTextureSize(128, 128);
        this.rightleg3.mirror = true;
        this.setRotation(this.rightleg3, -0.4014257f, 0.0f, 0.0f);
        (this.leftleg4 = new ModelRenderer((ModelBase) this, 42, 113)).addBox(-1.0f, 31.0f, -1.0f, 3, 3, 8);
        this.leftleg4.setRotationPoint(6.0f, -10.0f, 11.0f);
        this.leftleg4.setTextureSize(128, 128);
        this.leftleg4.mirror = true;
        this.setRotation(this.leftleg4, 0.0f, 0.0f, 0.0f);
        (this.rightleg4 = new ModelRenderer((ModelBase) this, 44, 93)).addBox(0.0f, 31.0f, -1.0f, 3, 3, 8);
        this.rightleg4.setRotationPoint(-7.0f, -10.0f, 11.0f);
        this.rightleg4.setTextureSize(128, 128);
        this.rightleg4.mirror = true;
        this.setRotation(this.rightleg4, 0.0f, 0.0f, 0.0f);
        (this.Shape17 = new ModelRenderer((ModelBase) this, 112, 60)).addBox(-2.0f, 0.0f, 0.0f, 2, 10, 2);
        this.Shape17.setRotationPoint(-4.0f, -3.533333f, -3.0f);
        this.Shape17.setTextureSize(128, 128);
        this.Shape17.mirror = true;
        this.setRotation(this.Shape17, -0.5235988f, 0.0f, 0.0f);
        (this.TailExtension = new ModelRenderer((ModelBase) this, 0, 10)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 10);
        this.TailExtension.setRotationPoint(-1.0f, -19.0f, 59.0f);
        this.TailExtension.setTextureSize(128, 128);
        this.TailExtension.mirror = true;
        this.setRotation(this.TailExtension, 0.0f, 0.0f, 0.0f);
        (this.Spine1 = new ModelRenderer((ModelBase) this, 73, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 3);
        this.Spine1.setRotationPoint(-1.0f, -21.0f, 0.0f);
        this.Spine1.setTextureSize(128, 128);
        this.Spine1.mirror = true;
        this.setRotation(this.Spine1, 0.0f, 0.0f, 0.0f);
        (this.Spine2 = new ModelRenderer((ModelBase) this, 73, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 3);
        this.Spine2.setRotationPoint(-0.5f, -21.0f, 6.0f);
        this.Spine2.setTextureSize(128, 128);
        this.Spine2.mirror = true;
        this.setRotation(this.Spine2, 0.0f, 0.0f, 0.0f);
        (this.Spine3 = new ModelRenderer((ModelBase) this, 73, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 3);
        this.Spine3.setRotationPoint(-0.5f, -21.0f, 12.0f);
        this.Spine3.setTextureSize(128, 128);
        this.Spine3.mirror = true;
        this.setRotation(this.Spine3, 0.0f, 0.0f, 0.0f);
        (this.Spine4 = new ModelRenderer((ModelBase) this, 73, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 3);
        this.Spine4.setRotationPoint(-0.5f, -24.0f, -9.0f);
        this.Spine4.setTextureSize(128, 128);
        this.Spine4.mirror = true;
        this.setRotation(this.Spine4, -0.4014257f, 0.0f, 0.0f);
        (this.Spine5 = new ModelRenderer((ModelBase) this, 73, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 3);
        this.Spine5.setRotationPoint(-0.5f, -26.0f, -14.0f);
        this.Spine5.setTextureSize(128, 128);
        this.Spine5.mirror = true;
        this.setRotation(this.Spine5, -0.4014257f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final TRex e = (TRex) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.rightleg.rotateAngleX = -0.174f + newangle;
        this.rightleg2.rotateAngleX = 0.506f + newangle;
        this.rightleg3.rotateAngleX = -0.401f + newangle;
        this.rightleg4.rotateAngleX = newangle;
        this.leftleg.rotateAngleX = -0.174f - newangle;
        this.leftleg2.rotateAngleX = 0.506f - newangle;
        this.leftleg3.rotateAngleX = -0.401f - newangle;
        this.leftleg4.rotateAngleX = -newangle;
        if (e.getAttacking() != 0) {
            this.jaw.rotateAngleX = 0.52f + MathHelper.cos(f2 * 0.45f) * 3.1415927f * 0.18f;
        } else {
            this.jaw.rotateAngleX = 0.1f;
        }
        this.Shape17.rotateAngleX = -0.523f + MathHelper.cos(f2 * 0.1f) * 3.1415927f * 0.05f;
        this.Shape11.rotateAngleX = -0.523f + MathHelper.cos(f2 * 0.1f) * 3.1415927f * 0.05f;
        this.Shape18.render(f5);
        this.Shape19.render(f5);
        this.Shape20.render(f5);
        this.Shape21.render(f5);
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.jaw.render(f5);
        this.leftleg.render(f5);
        this.leftleg2.render(f5);
        this.leftleg3.render(f5);
        this.Shape11.render(f5);
        this.rightleg.render(f5);
        this.rightleg2.render(f5);
        this.rightleg3.render(f5);
        this.leftleg4.render(f5);
        this.rightleg4.render(f5);
        this.Shape17.render(f5);
        this.TailExtension.render(f5);
        this.Spine1.render(f5);
        this.Spine2.render(f5);
        this.Spine3.render(f5);
        this.Spine4.render(f5);
        this.Spine5.render(f5);
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
