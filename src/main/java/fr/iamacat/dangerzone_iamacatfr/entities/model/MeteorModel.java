
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class MeteorModel extends ModelBase {

    ModelRenderer Rock1;
    ModelRenderer Rock2;
    ModelRenderer Rock3;
    ModelRenderer Rock4;

    public MeteorModel() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Rock1 = new ModelRenderer((ModelBase) this, 0, 44)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 8);
        this.Rock1.setRotationPoint(-6.0f, 7.0f, -12.0f);
        this.Rock1.setTextureSize(128, 128);
        this.Rock1.mirror = true;
        this.setRotation(this.Rock1, 0.0f, 0.0f, 0.0f);
        (this.Rock2 = new ModelRenderer((ModelBase) this, 0, 22)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 8);
        this.Rock2.setRotationPoint(1.0f, 7.0f, -5.0f);
        this.Rock2.setTextureSize(128, 128);
        this.Rock2.mirror = true;
        this.setRotation(this.Rock2, 0.0f, 0.0f, 0.0f);
        (this.Rock3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 8);
        this.Rock3.setRotationPoint(-3.0f, 3.0f, -7.0f);
        this.Rock3.setTextureSize(128, 128);
        this.Rock3.mirror = true;
        this.setRotation(this.Rock3, 0.0f, 0.0f, 0.0f);
        (this.Rock4 = new ModelRenderer((ModelBase) this, 0, 66)).addBox(0.0f, 0.0f, 0.0f, 8, 6, 8);
        this.Rock4.setRotationPoint(-6.0f, 9.0f, -2.0f);
        this.Rock4.setTextureSize(128, 128);
        this.Rock4.mirror = true;
        this.setRotation(this.Rock4, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Rock1.render(f5);
        this.Rock2.render(f5);
        this.Rock3.render(f5);
        this.Rock4.render(f5);
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
}
