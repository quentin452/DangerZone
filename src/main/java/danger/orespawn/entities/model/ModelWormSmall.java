
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWormSmall extends ModelBase {

    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer tail;

    public ModelWormSmall() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.head = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.head.setRotationPoint(0.0f, 14.0f, 0.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 6, 0)).addBox(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.body.setRotationPoint(0.0f, 19.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase) this, 12, 0)).addBox(-0.5f, -5.0f, -0.5f, 1, 5, 1);
        this.tail.setRotationPoint(0.0f, 24.0f, 0.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.tail.rotateAngleX = newangle;
        float d1 = (float) (Math.sin(newangle) * 5.0);
        float d2 = (float) (Math.cos(newangle) * 5.0);
        this.body.rotationPointZ = this.tail.rotationPointZ - d1;
        newangle = MathHelper.cos(f2 * 0.35f) * 3.1415927f * 0.1f;
        this.tail.rotateAngleZ = newangle;
        float d3 = (float) (Math.cos(newangle) * d2);
        float d4 = (float) (Math.sin(newangle) * d2);
        this.body.rotationPointX = this.tail.rotationPointX + d4;
        this.body.rotationPointY = (float) (this.tail.rotationPointY - 5.0 + (5.0 - d3));
        newangle = MathHelper.cos(f2 * 0.45f) * 3.1415927f * 0.15f;
        this.body.rotateAngleX = newangle;
        d1 = (float) (Math.sin(newangle) * 5.0);
        d2 = (float) (Math.cos(newangle) * 5.0);
        this.head.rotationPointZ = this.body.rotationPointZ - d1;
        newangle = MathHelper.cos(f2 * 0.25f) * 3.1415927f * 0.1f;
        this.body.rotateAngleZ = newangle;
        d3 = (float) (Math.cos(newangle) * d2);
        d4 = (float) (Math.sin(newangle) * d2);
        this.head.rotationPointX = this.body.rotationPointX + d4;
        this.head.rotationPointY = (float) (this.body.rotationPointY - 5.0 + (5.0 - d3));
        this.head.rotateAngleX = 0.62f + MathHelper.cos(f2 * 0.65f) * 3.1415927f * 0.15f;
        this.head.rotateAngleZ = MathHelper.cos(f2 * 0.3f) * 3.1415927f * 0.05f;
        this.head.render(f5);
        this.body.render(f5);
        this.tail.render(f5);
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
