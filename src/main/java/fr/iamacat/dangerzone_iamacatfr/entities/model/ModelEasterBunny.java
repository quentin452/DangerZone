
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EasterBunny;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelEasterBunny extends ModelBase {

    private float wingspeed;
    ModelRenderer body;
    ModelRenderer tail;
    ModelRenderer lfoot;
    ModelRenderer lleg;
    ModelRenderer upperbody;
    ModelRenderer head;
    ModelRenderer nose;
    ModelRenderer lear;
    ModelRenderer lpaw;
    ModelRenderer rleg;
    ModelRenderer rfoot;
    ModelRenderer rear;
    ModelRenderer rpaw;

    public ModelEasterBunny(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 128;
        (this.body = new ModelRenderer((ModelBase) this, 0, 44)).addBox(-3.0f, 0.0f, -3.0f, 6, 6, 7);
        this.body.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase) this, 0, 58)).addBox(-2.0f, 0.0f, -2.0f, 4, 4, 4);
        this.tail.setRotationPoint(0.0f, 19.0f, 6.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
        (this.lfoot = new ModelRenderer((ModelBase) this, 0, 30)).addBox(-1.0f, 2.0f, -5.0f, 3, 1, 7);
        this.lfoot.setRotationPoint(3.0f, 21.0f, 1.0f);
        this.lfoot.setTextureSize(64, 32);
        this.lfoot.mirror = true;
        this.setRotation(this.lfoot, 0.0f, 0.0f, 0.0f);
        (this.lleg = new ModelRenderer((ModelBase) this, 0, 20)).addBox(0.0f, -2.0f, -2.0f, 1, 4, 5);
        this.lleg.setRotationPoint(3.0f, 21.0f, 1.0f);
        this.lleg.setTextureSize(64, 32);
        this.lleg.mirror = true;
        this.setRotation(this.lleg, 0.0f, 0.0f, 0.0f);
        (this.upperbody = new ModelRenderer((ModelBase) this, 42, 27)).addBox(-2.0f, 0.0f, -2.0f, 4, 1, 5);
        this.upperbody.setRotationPoint(0.0f, 16.0f, -1.0f);
        this.upperbody.setTextureSize(64, 32);
        this.upperbody.mirror = true;
        this.setRotation(this.upperbody, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 40, 17)).addBox(-2.5f, 0.0f, -2.0f, 5, 4, 5);
        this.head.setRotationPoint(0.0f, 12.0f, -2.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.nose = new ModelRenderer((ModelBase) this, 44, 9)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 1);
        this.nose.setRotationPoint(0.0f, 15.0f, -5.0f);
        this.nose.setTextureSize(64, 32);
        this.nose.mirror = true;
        this.setRotation(this.nose, 0.0f, 0.0f, 0.0f);
        (this.lear = new ModelRenderer((ModelBase) this, 54, 0)).addBox(0.0f, -10.0f, -1.0f, 1, 10, 3);
        this.lear.setRotationPoint(2.0f, 13.0f, -1.0f);
        this.lear.setTextureSize(64, 32);
        this.lear.mirror = true;
        this.setRotation(this.lear, -0.2268928f, 0.0f, 0.0f);
        (this.lpaw = new ModelRenderer((ModelBase) this, 6, 7)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.lpaw.setRotationPoint(0.5f, 19.0f, -4.0f);
        this.lpaw.setTextureSize(64, 32);
        this.lpaw.mirror = true;
        this.setRotation(this.lpaw, 0.0f, 0.0f, 0.0f);
        (this.rleg = new ModelRenderer((ModelBase) this, 21, 20)).addBox(0.0f, -2.0f, -2.0f, 1, 4, 5);
        this.rleg.setRotationPoint(-4.0f, 21.0f, 1.0f);
        this.rleg.setTextureSize(64, 32);
        this.rleg.mirror = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
        (this.rfoot = new ModelRenderer((ModelBase) this, 21, 30)).addBox(-1.0f, 2.0f, -5.0f, 3, 1, 7);
        this.rfoot.setRotationPoint(-4.0f, 21.0f, 1.0f);
        this.rfoot.setTextureSize(64, 32);
        this.rfoot.mirror = true;
        this.setRotation(this.rfoot, 0.0f, 0.0f, 0.0f);
        (this.rear = new ModelRenderer((ModelBase) this, 32, 0)).addBox(0.0f, -10.0f, -1.0f, 1, 10, 3);
        this.rear.setRotationPoint(-3.0f, 13.0f, -1.0f);
        this.rear.setTextureSize(64, 32);
        this.rear.mirror = true;
        this.setRotation(this.rear, -0.418879f, 0.0f, 0.0f);
        (this.rpaw = new ModelRenderer((ModelBase) this, 0, 7)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.rpaw.setRotationPoint(-1.5f, 19.0f, -4.0f);
        this.rpaw.setTextureSize(64, 32);
        this.rpaw.mirror = true;
        this.setRotation(this.rpaw, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final EasterBunny e = (EasterBunny) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 2.6f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle2 = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.1f * f1;
        } else {
            newangle = 0.0f;
            newangle2 = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.01f;
        }
        final ModelRenderer lleg = this.lleg;
        final ModelRenderer lfoot = this.lfoot;
        final float n = newangle;
        lfoot.rotateAngleX = n;
        lleg.rotateAngleX = n;
        final ModelRenderer rleg = this.rleg;
        final ModelRenderer rfoot = this.rfoot;
        final float n2 = -newangle;
        rfoot.rotateAngleX = n2;
        rleg.rotateAngleX = n2;
        this.lear.rotateAngleX = -0.226f + newangle2;
        this.rear.rotateAngleX = -0.418f - newangle2;
        this.body.render(f5);
        this.tail.render(f5);
        this.lfoot.render(f5);
        this.lleg.render(f5);
        this.upperbody.render(f5);
        this.head.render(f5);
        this.nose.render(f5);
        this.lear.render(f5);
        this.lpaw.render(f5);
        this.rleg.render(f5);
        this.rfoot.render(f5);
        this.rear.render(f5);
        this.rpaw.render(f5);
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
