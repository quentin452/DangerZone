
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCryolophosaurus extends ModelBase {

    private float wingspeed;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer jaw;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer rightleg;
    ModelRenderer Shape11;
    ModelRenderer rightleg2;
    ModelRenderer rightleg3;
    ModelRenderer rightleg4;
    ModelRenderer leftleg;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer leftleg2;
    ModelRenderer leftleg3;
    ModelRenderer leftleg4;

    public ModelCryolophosaurus(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.wingspeed = f1;
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 9, 18);
        this.Shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape1.setTextureSize(128, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase) this, 53, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 11);
        this.Shape2.setRotationPoint(1.0f, -2.0f, -7.0f);
        this.Shape2.setTextureSize(128, 128);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, -0.2268928f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 0, 41)).addBox(0.0f, 0.0f, 0.0f, 6, 4, 10);
        this.Shape3.setRotationPoint(1.0f, -2.0f, -15.0f);
        this.Shape3.setTextureSize(128, 128);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 0, 30)).addBox(0.0f, 0.0f, 0.0f, 4, 9, 1);
        this.jaw.setRotationPoint(2.0f, 1.0f, -8.0f);
        this.jaw.setTextureSize(128, 128);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, -1.256637f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase) this, 91, 0)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 7);
        this.Shape5.setRotationPoint(1.0f, 0.0f, 18.0f);
        this.Shape5.setTextureSize(128, 128);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase) this, 36, 31)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 14);
        this.Shape6.setRotationPoint(2.0f, 0.0f, 25.0f);
        this.Shape6.setTextureSize(128, 128);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase) this, 43, 8)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 2);
        this.Shape7.setRotationPoint(-1.0f, 8.0f, 0.0f);
        this.Shape7.setTextureSize(128, 128);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.1919862f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase) this, 9, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.Shape8.setRotationPoint(-1.0f, 11.0f, 1.0f);
        this.Shape8.setTextureSize(128, 128);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, -0.2617994f, 0.0f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 4, 1);
        this.Shape9.setRotationPoint(3.0f, -4.0f, -9.0f);
        this.Shape9.setTextureSize(128, 128);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, -0.9424778f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase) this, 0, 58)).addBox(0.0f, 0.0f, 0.0f, 2, 10, 6);
        this.rightleg.setRotationPoint(-1.0f, 2.0f, 12.0f);
        this.rightleg.setTextureSize(128, 128);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, -0.2792527f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase) this, 39, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 3, 3);
        this.Shape11.setRotationPoint(2.0f, -1.0f, -18.0f);
        this.Shape11.setTextureSize(128, 128);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase) this, 0, 77)).addBox(0.0f, 7.0f, -5.0f, 2, 10, 3);
        this.rightleg2.setRotationPoint(-1.0f, 2.0f, 12.0f);
        this.rightleg2.setTextureSize(128, 128);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, 0.3839724f, 0.0f, 0.0f);
        (this.rightleg3 = new ModelRenderer((ModelBase) this, 35, 31)).addBox(0.0f, 10.0f, 12.0f, 2, 7, 2);
        this.rightleg3.setRotationPoint(-1.0f, 2.0f, 12.0f);
        this.rightleg3.setTextureSize(128, 128);
        this.rightleg3.mirror = true;
        this.setRotation(this.rightleg3, -0.6806784f, 0.0f, 0.0f);
        (this.rightleg4 = new ModelRenderer((ModelBase) this, 68, 55)).addBox(0.0f, 20.0f, -5.0f, 2, 2, 6);
        this.rightleg4.setRotationPoint(-1.0f, 2.0f, 12.0f);
        this.rightleg4.setTextureSize(128, 128);
        this.rightleg4.mirror = true;
        this.setRotation(this.rightleg4, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase) this, 22, 58)).addBox(0.0f, 0.0f, 0.0f, 2, 10, 6);
        this.leftleg.setRotationPoint(7.0f, 2.0f, 12.0f);
        this.leftleg.setTextureSize(128, 128);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, -0.2792527f, 0.0f, 0.0f);
        (this.Shape16 = new ModelRenderer((ModelBase) this, 0, 8)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 2);
        this.Shape16.setRotationPoint(8.0f, 8.0f, 0.0f);
        this.Shape16.setTextureSize(128, 128);
        this.Shape16.mirror = true;
        this.setRotation(this.Shape16, 0.1919862f, 0.0f, 0.0f);
        (this.Shape17 = new ModelRenderer((ModelBase) this, 9, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.Shape17.setRotationPoint(8.0f, 11.0f, 1.0f);
        this.Shape17.setTextureSize(128, 128);
        this.Shape17.mirror = true;
        this.setRotation(this.Shape17, -0.2617994f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase) this, 16, 77)).addBox(0.0f, 7.0f, -5.0f, 2, 10, 3);
        this.leftleg2.setRotationPoint(7.0f, 2.0f, 12.0f);
        this.leftleg2.setTextureSize(128, 128);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, 0.3839724f, 0.0f, 0.0f);
        (this.leftleg3 = new ModelRenderer((ModelBase) this, 67, 31)).addBox(0.0f, 10.0f, 12.0f, 2, 7, 2);
        this.leftleg3.setRotationPoint(7.0f, 2.0f, 12.0f);
        this.leftleg3.setTextureSize(128, 128);
        this.leftleg3.mirror = true;
        this.setRotation(this.leftleg3, -0.6806784f, 0.0f, 0.0f);
        (this.leftleg4 = new ModelRenderer((ModelBase) this, 47, 56)).addBox(0.0f, 20.0f, -5.0f, 2, 2, 6);
        this.leftleg4.setRotationPoint(7.0f, 2.0f, 12.0f);
        this.leftleg4.setTextureSize(128, 128);
        this.leftleg4.mirror = true;
        this.setRotation(this.leftleg4, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.rightleg.rotateAngleX = -0.2792527f + newangle;
        this.rightleg2.rotateAngleX = 0.384f + newangle;
        this.rightleg3.rotateAngleX = -0.68f + newangle;
        this.rightleg4.rotateAngleX = newangle;
        this.leftleg.rotateAngleX = -0.2792527f - newangle;
        this.leftleg2.rotateAngleX = 0.384f - newangle;
        this.leftleg3.rotateAngleX = -0.68f - newangle;
        this.leftleg4.rotateAngleX = -newangle;
        this.jaw.rotateAngleX = -1.15f + MathHelper.cos(f2 * 0.28f) * 3.1415927f * 0.1f;
        this.Shape1.render(f5);
        this.Shape2.render(f5);
        this.Shape3.render(f5);
        this.jaw.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.rightleg.render(f5);
        this.Shape11.render(f5);
        this.rightleg2.render(f5);
        this.rightleg3.render(f5);
        this.rightleg4.render(f5);
        this.leftleg.render(f5);
        this.Shape16.render(f5);
        this.Shape17.render(f5);
        this.leftleg2.render(f5);
        this.leftleg3.render(f5);
        this.leftleg4.render(f5);
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
