
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWhale extends ModelBase {

    ModelRenderer belly;
    ModelRenderer body;
    ModelRenderer back;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tailfin1;
    ModelRenderer tailfin2;
    ModelRenderer backfin;
    ModelRenderer head;
    ModelRenderer jaw;
    ModelRenderer lfin1;
    ModelRenderer lfin2;
    ModelRenderer rfin1;
    ModelRenderer rfin2;

    public ModelWhale() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.belly = new ModelRenderer((ModelBase) this, 0, 92)).addBox(-6.0f, 0.0f, 0.0f, 12, 2, 32);
        this.belly.setRotationPoint(0.0f, 22.0f, 6.0f);
        this.belly.setTextureSize(256, 256);
        this.belly.mirror = true;
        this.setRotation(this.belly, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 0, 188)).addBox(-10.0f, 0.0f, 0.0f, 20, 12, 52);
        this.body.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.body.setTextureSize(256, 256);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.back = new ModelRenderer((ModelBase) this, 0, 45)).addBox(-4.0f, 0.0f, 0.0f, 8, 2, 40);
        this.back.setRotationPoint(0.0f, 8.0f, 3.0f);
        this.back.setTextureSize(256, 256);
        this.back.mirror = true;
        this.setRotation(this.back, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 186, 0)).addBox(-6.0f, 0.0f, 0.0f, 12, 7, 14);
        this.tail1.setRotationPoint(0.0f, 11.0f, 52.0f);
        this.tail1.setTextureSize(256, 256);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 186, 24)).addBox(-4.0f, 0.0f, 0.0f, 8, 5, 10);
        this.tail2.setRotationPoint(0.0f, 12.0f, 66.0f);
        this.tail2.setTextureSize(256, 256);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.tailfin1 = new ModelRenderer((ModelBase) this, 186, 43)).addBox(0.0f, 0.0f, 0.0f, 17, 2, 11);
        this.tailfin1.setRotationPoint(2.0f, 13.0f, 74.0f);
        this.tailfin1.setTextureSize(256, 256);
        this.tailfin1.mirror = true;
        this.setRotation(this.tailfin1, 0.0872665f, -0.0872665f, 0.0f);
        (this.tailfin2 = new ModelRenderer((ModelBase) this, 186, 59)).addBox(-17.0f, 0.0f, 0.0f, 17, 2, 11);
        this.tailfin2.setRotationPoint(-2.0f, 13.0f, 74.0f);
        this.tailfin2.setTextureSize(256, 256);
        this.tailfin2.mirror = true;
        this.setRotation(this.tailfin2, 0.0872665f, 0.0872665f, 0.0f);
        (this.backfin = new ModelRenderer((ModelBase) this, 0, 15)).addBox(-0.5f, 0.0f, 0.0f, 1, 4, 8);
        this.backfin.setRotationPoint(0.0f, 8.0f, 11.0f);
        this.backfin.setTextureSize(256, 256);
        this.backfin.mirror = true;
        this.setRotation(this.backfin, 0.3665191f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 155)).addBox(-8.0f, 0.0f, -16.0f, 16, 8, 22);
        this.head.setRotationPoint(0.0f, 11.0f, -6.0f);
        this.head.setTextureSize(256, 256);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 0, 130)).addBox(-7.0f, -1.0f, -20.0f, 14, 2, 20);
        this.jaw.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.jaw.setTextureSize(256, 256);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 0.0698132f, 0.0f, 0.0f);
        (this.lfin1 = new ModelRenderer((ModelBase) this, 96, 0)).addBox(0.0f, -1.0f, -3.0f, 4, 3, 6);
        this.lfin1.setRotationPoint(10.0f, 18.0f, 8.0f);
        this.lfin1.setTextureSize(256, 256);
        this.lfin1.mirror = true;
        this.setRotation(this.lfin1, 0.0f, -0.0872665f, 0.0f);
        (this.lfin2 = new ModelRenderer((ModelBase) this, 120, 0)).addBox(2.0f, -0.5f, -3.0f, 22, 2, 8);
        this.lfin2.setRotationPoint(10.0f, 18.0f, 8.0f);
        this.lfin2.setTextureSize(256, 256);
        this.lfin2.mirror = true;
        this.setRotation(this.lfin2, 0.0f, -0.0872665f, 0.0f);
        (this.rfin1 = new ModelRenderer((ModelBase) this, 96, 12)).addBox(-4.0f, -1.0f, -3.0f, 4, 3, 6);
        this.rfin1.setRotationPoint(-10.0f, 18.0f, 8.0f);
        this.rfin1.setTextureSize(256, 256);
        this.rfin1.mirror = true;
        this.setRotation(this.rfin1, 0.0f, 0.0872665f, 0.0f);
        (this.rfin2 = new ModelRenderer((ModelBase) this, 120, 13)).addBox(-24.0f, -0.5f, -3.0f, 22, 2, 8);
        this.rfin2.setRotationPoint(-10.0f, 18.0f, 8.0f);
        this.rfin2.setTextureSize(256, 256);
        this.rfin2.mirror = true;
        this.setRotation(this.rfin2, 0.0f, 0.0872665f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 0.3f) * 3.1415927f * 0.2f * f1;
        } else {
            newangle = MathHelper.cos(f2 * 0.08f) * 3.1415927f * 0.05f;
        }
        this.lfin2.rotateAngleZ = 0.436f + newangle;
        this.lfin1.rotateAngleZ = this.lfin2.rotateAngleZ / 2.0f;
        this.rfin2.rotateAngleZ = -0.436f - newangle;
        this.rfin1.rotateAngleZ = this.rfin2.rotateAngleZ / 2.0f;
        newangle = MathHelper.cos(f2 * 0.03f) * 3.1415927f * 0.02f;
        this.jaw.rotateAngleX = 0.087f + newangle;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 0.4f) * 3.1415927f * 0.16f * f1;
        } else {
            newangle = MathHelper.cos(f2 * 0.05f) * 3.1415927f * 0.03f;
        }
        this.tail1.rotateAngleX = newangle * 0.5f;
        this.tail2.rotateAngleX = newangle * 1.25f;
        final ModelRenderer tailfin1 = this.tailfin1;
        final ModelRenderer tailfin2 = this.tailfin2;
        final float n = newangle * 2.25f;
        tailfin2.rotateAngleX = n;
        tailfin1.rotateAngleX = n;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleX) * 14.0f;
        this.tail2.rotationPointY = this.tail1.rotationPointY - (float) Math.sin(this.tail1.rotateAngleX) * 14.0f;
        final ModelRenderer tailfin3 = this.tailfin1;
        final ModelRenderer tailfin4 = this.tailfin2;
        final float n2 = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleX) * 8.0f;
        tailfin4.rotationPointZ = n2;
        tailfin3.rotationPointZ = n2;
        final ModelRenderer tailfin5 = this.tailfin1;
        final ModelRenderer tailfin6 = this.tailfin2;
        final float n3 = this.tail2.rotationPointY - (float) Math.sin(this.tail2.rotateAngleX) * 8.0f;
        tailfin6.rotationPointY = n3;
        tailfin5.rotationPointY = n3;
        this.belly.render(f5);
        this.body.render(f5);
        this.back.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.tailfin1.render(f5);
        this.tailfin2.render(f5);
        this.backfin.render(f5);
        this.head.render(f5);
        this.jaw.render(f5);
        this.lfin1.render(f5);
        this.lfin2.render(f5);
        this.rfin1.render(f5);
        this.rfin2.render(f5);
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
