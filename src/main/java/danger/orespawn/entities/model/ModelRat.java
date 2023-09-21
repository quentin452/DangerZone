
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import danger.orespawn.entities.entityinstance.Rat;

public class ModelRat extends ModelBase {

    private float wingspeed;
    ModelRenderer body;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer lfleg;
    ModelRenderer rfleg;
    ModelRenderer lrleg;
    ModelRenderer rrleg;
    ModelRenderer body2;
    ModelRenderer head;
    ModelRenderer nose;
    ModelRenderer lear;
    ModelRenderer rear;

    public ModelRat(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase) this, 27, 0)).addBox(-2.0f, -1.0f, 0.0f, 5, 3, 10);
        this.body.setRotationPoint(0.0f, 20.0f, -3.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 0, 30)).addBox(-0.5f, -1.0f, 0.0f, 2, 2, 9);
        this.tail1.setRotationPoint(0.0f, 21.0f, 7.0f);
        this.tail1.setTextureSize(64, 64);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 0, 43)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 12);
        this.tail2.setRotationPoint(0.0f, 21.0f, 16.0f);
        this.tail2.setTextureSize(64, 64);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.lfleg = new ModelRenderer((ModelBase) this, 0, 14)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.lfleg.setRotationPoint(2.0f, 22.0f, -2.0f);
        this.lfleg.setTextureSize(64, 64);
        this.lfleg.mirror = true;
        this.setRotation(this.lfleg, 0.0f, 0.0f, 0.0f);
        (this.rfleg = new ModelRenderer((ModelBase) this, 10, 14)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.rfleg.setRotationPoint(-2.0f, 22.0f, -2.0f);
        this.rfleg.setTextureSize(64, 64);
        this.rfleg.mirror = true;
        this.setRotation(this.rfleg, 0.0f, 0.0f, 0.0f);
        (this.lrleg = new ModelRenderer((ModelBase) this, 0, 18)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.lrleg.setRotationPoint(2.0f, 20.0f, 4.0f);
        this.lrleg.setTextureSize(64, 64);
        this.lrleg.mirror = true;
        this.setRotation(this.lrleg, 0.0f, 0.0f, 0.0f);
        (this.rrleg = new ModelRenderer((ModelBase) this, 9, 18)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 2);
        this.rrleg.setRotationPoint(-3.0f, 20.0f, 4.0f);
        this.rrleg.setTextureSize(64, 64);
        this.rrleg.mirror = true;
        this.setRotation(this.rrleg, 0.0f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 6);
        this.body2.setRotationPoint(0.0f, 18.0f, 0.0f);
        this.body2.setTextureSize(64, 64);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 27, 17)).addBox(-1.0f, -2.0f, -3.0f, 3, 2, 4);
        this.head.setRotationPoint(0.0f, 22.0f, -4.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.nose = new ModelRenderer((ModelBase) this, 27, 25)).addBox(0.0f, -1.0f, -5.0f, 1, 1, 2);
        this.nose.setRotationPoint(0.0f, 22.0f, -4.0f);
        this.nose.setTextureSize(64, 64);
        this.nose.mirror = true;
        this.setRotation(this.nose, 0.0f, 0.0f, 0.0f);
        (this.lear = new ModelRenderer((ModelBase) this, 0, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.lear.setRotationPoint(1.5f, 19.5f, -4.0f);
        this.lear.setTextureSize(64, 64);
        this.lear.mirror = true;
        this.setRotation(this.lear, 0.0f, 0.0f, 0.0f);
        (this.rear = new ModelRenderer((ModelBase) this, 5, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.rear.setRotationPoint(-1.5f, 19.5f, -4.0f);
        this.rear.setTextureSize(64, 64);
        this.rear.mirror = true;
        this.setRotation(this.rear, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Rat r = (Rat) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.rfleg.rotateAngleX = newangle;
        this.lfleg.rotateAngleX = -newangle;
        this.rrleg.rotateAngleX = -newangle;
        this.lrleg.rotateAngleX = newangle;
        if (r.getAttacking() != 0) {
            newangle = MathHelper.cos(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.25f;
        } else {
            newangle = MathHelper.cos(f2 * 0.4f * this.wingspeed) * 3.1415927f * 0.05f;
        }
        this.tail1.rotateAngleY = newangle * 0.5f;
        this.tail2.rotateAngleY = newangle * 1.25f;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 9.0f;
        this.tail2.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 9.0f;
        this.body.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.lfleg.render(f5);
        this.rfleg.render(f5);
        this.lrleg.render(f5);
        this.rrleg.render(f5);
        this.body2.render(f5);
        this.head.render(f5);
        this.nose.render(f5);
        this.lear.render(f5);
        this.rear.render(f5);
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
