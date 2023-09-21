
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Cassowary;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCassowary extends ModelBase {

    private float wingspeed;
    ModelRenderer tail;
    ModelRenderer body;
    ModelRenderer neck1;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer beak;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer crest;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer gobbler;

    public ModelCassowary(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.tail = new ModelRenderer((ModelBase) this, 38, 16)).addBox(-3.0f, 0.0f, 0.0f, 6, 9, 7);
        this.tail.setRotationPoint(0.0f, 8.0f, 1.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.8922867f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 0, 13)).addBox(-4.0f, 0.0f, 0.0f, 8, 10, 9);
        this.body.setRotationPoint(0.0f, 5.0f, -3.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.3346075f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase) this, 48, 0)).addBox(-2.0f, 0.0f, 0.0f, 4, 5, 4);
        this.neck1.setRotationPoint(0.0f, 4.0f, -1.0f);
        this.neck1.setTextureSize(64, 32);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, -1.189716f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase) this, 38, 0)).addBox(-1.0f, 0.0f, 0.0f, 2, 7, 2);
        this.neck.setRotationPoint(0.0f, 8.0f, -3.0f);
        this.neck.setTextureSize(64, 32);
        this.neck.mirror = true;
        this.setRotation(this.neck, -2.806985f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 24, 0)).addBox(-1.0f, -2.0f, -3.0f, 2, 2, 4);
        this.head.setRotationPoint(0.0f, 2.0f, -6.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0371786f, 0.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase) this, 28, 7)).addBox(-0.5f, 0.0f, 3.0f, 1, 1, 3);
        this.beak.setRotationPoint(0.0f, 2.0f, -6.0f);
        this.beak.setTextureSize(64, 32);
        this.beak.mirror = true;
        this.setRotation(this.beak, -3.104414f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.5f, 0.0f, -1.0f, 1, 11, 2);
        this.leg1.setRotationPoint(3.0f, 12.0f, 3.0f);
        this.leg1.setTextureSize(64, 32);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0f, 0.0f, 0.0f);
        (this.leg2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.5f, 0.0f, -1.0f, 1, 11, 2);
        this.leg2.setRotationPoint(-3.0f, 12.0f, 3.0f);
        this.leg2.setTextureSize(64, 32);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0f, 0.0f, 0.0f);
        (this.crest = new ModelRenderer((ModelBase) this, 10, 0)).addBox(-0.5f, -4.0f, 1.0f, 1, 4, 5);
        this.crest.setRotationPoint(0.0f, 2.0f, -6.0f);
        this.crest.setTextureSize(64, 32);
        this.crest.mirror = true;
        this.setRotation(this.crest, 1.710216f, 0.0f, 0.0f);
        (this.foot1 = new ModelRenderer((ModelBase) this, 47, 10)).addBox(-1.033333f, 11.0f, -2.0f, 2, 1, 3);
        this.foot1.setRotationPoint(-3.0f, 12.0f, 3.0f);
        this.foot1.setTextureSize(64, 32);
        this.foot1.mirror = true;
        this.setRotation(this.foot1, 0.0f, 0.0f, 0.0f);
        (this.foot2 = new ModelRenderer((ModelBase) this, 47, 10)).addBox(-1.0f, 11.0f, -2.0f, 2, 1, 3);
        this.foot2.setRotationPoint(3.0f, 12.0f, 3.0f);
        this.foot2.setTextureSize(64, 32);
        this.foot2.mirror = true;
        this.setRotation(this.foot2, 0.0f, 0.0f, 0.0f);
        (this.gobbler = new ModelRenderer((ModelBase) this, 38, 10)).addBox(-0.5f, -1.0f, -2.5f, 1, 5, 1);
        this.gobbler.setRotationPoint(0.0f, 8.0f, -3.0f);
        this.gobbler.setTextureSize(64, 32);
        this.gobbler.mirror = true;
        this.setRotation(this.gobbler, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Cassowary e = (Cassowary) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        float newangle2 = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.15f * f1;
            newangle2 = MathHelper.cos(f2 * 2.6f * this.wingspeed) * 3.1415927f * 0.1f * f1;
        } else {
            newangle2 = (newangle = 0.0f);
        }
        final ModelRenderer leg1 = this.leg1;
        final ModelRenderer foot2 = this.foot2;
        final float n = newangle;
        foot2.rotateAngleX = n;
        leg1.rotateAngleX = n;
        final ModelRenderer leg2 = this.leg2;
        final ModelRenderer foot3 = this.foot1;
        final float n2 = -newangle;
        foot3.rotateAngleX = n2;
        leg2.rotateAngleX = n2;
        this.neck.rotateAngleX = -2.827f + newangle2;
        this.gobbler.rotateAngleX = newangle2;
        final ModelRenderer head = this.head;
        final ModelRenderer crest = this.crest;
        final ModelRenderer beak = this.beak;
        final float rotationPointZ = this.neck.rotationPointZ + MathHelper.sin(this.neck.rotateAngleX) * 7.0f;
        beak.rotationPointZ = rotationPointZ;
        crest.rotationPointZ = rotationPointZ;
        head.rotationPointZ = rotationPointZ;
        final ModelRenderer head2 = this.head;
        final ModelRenderer crest2 = this.crest;
        final ModelRenderer beak2 = this.beak;
        final float rotationPointY = this.neck.rotationPointY + MathHelper.cos(this.neck.rotateAngleX) * 7.0f;
        beak2.rotationPointY = rotationPointY;
        crest2.rotationPointY = rotationPointY;
        head2.rotationPointY = rotationPointY;
        this.tail.render(f5);
        this.body.render(f5);
        this.neck1.render(f5);
        this.neck.render(f5);
        this.head.render(f5);
        this.beak.render(f5);
        this.leg1.render(f5);
        this.leg2.render(f5);
        this.crest.render(f5);
        this.foot1.render(f5);
        this.foot2.render(f5);
        this.gobbler.render(f5);
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
