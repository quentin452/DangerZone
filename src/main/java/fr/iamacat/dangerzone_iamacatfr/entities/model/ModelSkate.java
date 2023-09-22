
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Skate;

public class ModelSkate extends ModelBase {

    private float wingspeed;
    ModelRenderer body;
    ModelRenderer tail1;
    ModelRenderer Shape1;

    public ModelSkate(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.body = new ModelRenderer((ModelBase) this, 0, 13)).addBox(-3.0f, 0.0f, -3.0f, 6, 1, 6);
        this.body.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.7853982f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.5f, 0.0f, 0.0f, 1, 1, 11);
        this.tail1.setRotationPoint(0.0f, 22.0f, 3.0f);
        this.tail1.setTextureSize(64, 32);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 21)).addBox(-0.5f, 0.0f, 0.0f, 1, 1, 4);
        this.Shape1.setRotationPoint(0.0f, 22.0f, 5.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.7853982f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Skate e = (Skate) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.2f) * 3.1415927f * 0.15f * f1;
        } else {
            newangle = MathHelper.cos(f2 * 0.4f) * 3.1415927f * 0.05f;
        }
        this.Shape1.rotateAngleX = 0.785f + newangle;
        this.body.render(f5);
        this.tail1.render(f5);
        this.Shape1.render(f5);
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
