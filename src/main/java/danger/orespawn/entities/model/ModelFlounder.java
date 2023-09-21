
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelFlounder extends ModelBase {

    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer rfin;
    ModelRenderer lfin;

    public ModelFlounder() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.body = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-4.0f, 0.0f, -5.0f, 8, 1, 12);
        this.body.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 5)).addBox(-2.0f, 0.0f, 0.0f, 4, 1, 2);
        this.head.setRotationPoint(0.0f, 22.0f, -7.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 30, 0)).addBox(-2.0f, 0.0f, 0.0f, 4, 1, 2);
        this.tail1.setRotationPoint(0.0f, 22.0f, 7.0f);
        this.tail1.setTextureSize(64, 32);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 30, 4)).addBox(-3.0f, 0.0f, 2.0f, 6, 1, 3);
        this.tail2.setRotationPoint(0.0f, 22.0f, 7.0f);
        this.tail2.setTextureSize(64, 32);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.rfin = new ModelRenderer((ModelBase) this, 12, 0)).addBox(-3.0f, 0.0f, 0.0f, 3, 1, 2);
        this.rfin.setRotationPoint(-4.0f, 22.0f, -2.0f);
        this.rfin.setTextureSize(64, 32);
        this.rfin.mirror = true;
        this.setRotation(this.rfin, 0.0f, 0.0f, 0.0f);
        (this.lfin = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.lfin.setRotationPoint(4.0f, 22.0f, -2.0f);
        this.lfin.setTextureSize(64, 32);
        this.lfin.mirror = true;
        this.setRotation(this.lfin, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle;
        float newangle2;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f) * 3.1415927f * 0.25f * f1;
            newangle2 = MathHelper.cos(f2 * 1.7f) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
            newangle2 = 0.0f;
        }
        this.lfin.rotateAngleZ = newangle;
        this.rfin.rotateAngleZ = newangle2;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.2f) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = MathHelper.cos(f2 * 0.7f) * 3.1415927f * 0.05f;
        }
        final ModelRenderer tail1 = this.tail1;
        final ModelRenderer tail2 = this.tail2;
        final float n = newangle;
        tail2.rotateAngleX = n;
        tail1.rotateAngleX = n;
        this.body.render(f5);
        this.head.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        this.rfin.render(f5);
        this.lfin.render(f5);
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
