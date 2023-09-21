
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMosquito extends ModelBase {

    ModelRenderer body;
    ModelRenderer leftwing1;
    ModelRenderer rightwing1;
    ModelRenderer leftwing2;
    ModelRenderer rightwing2;

    public ModelMosquito() {
        this.textureWidth = 32;
        this.textureHeight = 32;
        (this.body = new ModelRenderer((ModelBase) this, 8, 18)).addBox(0.0f, 0.0f, -2.0f, 1, 1, 8);
        this.body.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leftwing1 = new ModelRenderer((ModelBase) this, 16, 13)).addBox(1.0f, 0.0f, -1.0f, 3, 1, 3);
        this.leftwing1.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing1.setTextureSize(64, 32);
        this.leftwing1.mirror = true;
        this.setRotation(this.leftwing1, 0.0f, 0.0f, 0.0f);
        (this.rightwing1 = new ModelRenderer((ModelBase) this, 2, 13)).addBox(-4.0f, 0.0f, -1.0f, 3, 1, 3);
        this.rightwing1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing1.setTextureSize(64, 32);
        this.rightwing1.mirror = true;
        this.setRotation(this.rightwing1, 0.0f, 0.0f, 0.0f);
        (this.leftwing2 = new ModelRenderer((ModelBase) this, 15, 8)).addBox(0.0f, 0.0f, 0.0f, 5, 1, 1);
        this.leftwing2.setRotationPoint(1.0f, 17.0f, 0.0f);
        this.leftwing2.setTextureSize(64, 32);
        this.leftwing2.mirror = true;
        this.setRotation(this.leftwing2, 0.0f, 0.0f, 0.0f);
        (this.rightwing2 = new ModelRenderer((ModelBase) this, 2, 8)).addBox(-5.0f, 0.0f, 0.0f, 5, 1, 1);
        this.rightwing2.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rightwing2.setTextureSize(64, 32);
        this.rightwing2.mirror = true;
        this.setRotation(this.rightwing2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.body.render(f5);
        this.rightwing1.rotateAngleZ = MathHelper.cos(f2 * 3.0f) * 3.1415927f * 0.25f;
        this.rightwing2.rotateAngleZ = this.rightwing1.rotateAngleZ;
        this.leftwing1.rotateAngleZ = -this.rightwing1.rotateAngleZ;
        this.leftwing2.rotateAngleZ = -this.rightwing1.rotateAngleZ;
        this.leftwing1.render(f5);
        this.rightwing1.render(f5);
        this.leftwing2.render(f5);
        this.rightwing2.render(f5);
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
