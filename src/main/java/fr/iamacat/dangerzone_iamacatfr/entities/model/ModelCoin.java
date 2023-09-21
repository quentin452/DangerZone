
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCoin extends ModelBase {

    private float wingspeed;
    ModelRenderer Shape1;

    public ModelCoin(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-128.0f, -128.0f, 0.0f, 256, 256, 1);
        this.Shape1.setRotationPoint(0.0f, -109.0f, 0.0f);
        this.Shape1.setTextureSize(512, 512);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        newangle = MathHelper.cos(f2 * 0.05f * this.wingspeed) * 3.1415927f;
        this.Shape1.rotateAngleY = newangle;
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
