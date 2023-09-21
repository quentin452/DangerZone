
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWormMedium extends ModelBase {

    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer tail;
    ModelRenderer tooth1;
    ModelRenderer tooth2;
    ModelRenderer tooth3;
    ModelRenderer tooth4;
    ModelRenderer head2;

    public ModelWormMedium() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.head = new ModelRenderer((ModelBase) this, 24, 0)).addBox(-1.5f, -12.0f, -1.5f, 3, 12, 3);
        this.head.setRotationPoint(0.0f, 1.0f, 0.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 37, 0)).addBox(-1.5f, -12.0f, -1.5f, 3, 12, 3);
        this.body.setRotationPoint(0.0f, 13.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase) this, 50, 0)).addBox(-1.5f, -12.0f, -1.5f, 3, 12, 3);
        this.tail.setRotationPoint(0.0f, 25.0f, 0.0f);
        this.tail.setTextureSize(64, 32);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.0f, 0.0f, 0.0f);
        (this.tooth1 = new ModelRenderer((ModelBase) this, 15, 0)).addBox(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth1.setRotationPoint(1.0f, -11.0f, 0.0f);
        this.tooth1.setTextureSize(64, 32);
        this.tooth1.mirror = true;
        this.setRotation(this.tooth1, 0.0f, 0.0f, 0.0f);
        (this.tooth2 = new ModelRenderer((ModelBase) this, 5, 0)).addBox(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth2.setRotationPoint(-1.0f, -11.0f, 0.0f);
        this.tooth2.setTextureSize(64, 32);
        this.tooth2.mirror = true;
        this.setRotation(this.tooth2, 0.0f, 0.0f, 0.0f);
        (this.tooth3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth3.setRotationPoint(0.0f, -11.0f, 1.0f);
        this.tooth3.setTextureSize(64, 32);
        this.tooth3.mirror = true;
        this.setRotation(this.tooth3, 0.0f, 0.0f, 0.0f);
        (this.tooth4 = new ModelRenderer((ModelBase) this, 10, 0)).addBox(-0.5f, -3.0f, -0.5f, 1, 3, 1);
        this.tooth4.setRotationPoint(0.0f, -11.0f, -1.0f);
        this.tooth4.setTextureSize(64, 32);
        this.tooth4.mirror = true;
        this.setRotation(this.tooth4, 0.0f, 0.0f, 0.0f);
        (this.head2 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(-2.0f, -8.0f, -2.0f, 4, 8, 4);
        this.head2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head2.setTextureSize(64, 32);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = MathHelper.cos(f2 * 0.45f) * 3.1415927f * 0.1f;
        this.tail.rotateAngleX = newangle;
        float d1 = (float) (Math.sin(newangle) * 12.0);
        float d2 = (float) (Math.cos(newangle) * 12.0);
        this.body.rotationPointZ = this.tail.rotationPointZ - d1;
        newangle = MathHelper.cos(f2 * 0.25f) * 3.1415927f * 0.08f;
        this.tail.rotateAngleZ = newangle;
        float d3 = (float) (Math.cos(newangle) * d2);
        float d4 = (float) (Math.sin(newangle) * d2);
        this.body.rotationPointX = this.tail.rotationPointX + d4;
        this.body.rotationPointY = (float) (this.tail.rotationPointY - 12.0 + (12.0 - d3));
        newangle = MathHelper.cos(f2 * 0.35f) * 3.1415927f * 0.1f;
        this.body.rotateAngleX = newangle;
        d1 = (float) (Math.sin(newangle) * 12.0);
        d2 = (float) (Math.cos(newangle) * 12.0);
        final ModelRenderer head2 = this.head2;
        final ModelRenderer head3 = this.head;
        final float n = this.body.rotationPointZ - d1;
        head3.rotationPointZ = n;
        head2.rotationPointZ = n;
        newangle = MathHelper.cos(f2 * 0.15f) * 3.1415927f * 0.07f;
        this.body.rotateAngleZ = newangle;
        d3 = (float) (Math.cos(newangle) * d2);
        d4 = (float) (Math.sin(newangle) * d2);
        final ModelRenderer head4 = this.head2;
        final ModelRenderer head5 = this.head;
        final float n2 = this.body.rotationPointX + d4;
        head5.rotationPointX = n2;
        head4.rotationPointX = n2;
        final ModelRenderer head6 = this.head2;
        final ModelRenderer head7 = this.head;
        final float n3 = (float) (this.body.rotationPointY - 12.0 + (12.0 - d3));
        head7.rotationPointY = n3;
        head6.rotationPointY = n3;
        final ModelRenderer head8 = this.head2;
        final ModelRenderer head9 = this.head;
        final float n4 = 0.62f + MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        head9.rotateAngleX = n4;
        head8.rotateAngleX = n4;
        final ModelRenderer head10 = this.head2;
        final ModelRenderer head11 = this.head;
        final float n5 = MathHelper.cos(f2 * 0.25f) * 3.1415927f * 0.05f;
        head11.rotateAngleZ = n5;
        head10.rotateAngleZ = n5;
        newangle = this.head.rotateAngleX;
        final ModelRenderer tooth1 = this.tooth1;
        final ModelRenderer tooth2 = this.tooth2;
        final ModelRenderer tooth3 = this.tooth3;
        final ModelRenderer tooth4 = this.tooth4;
        final float n6 = newangle;
        tooth4.rotateAngleX = n6;
        tooth3.rotateAngleX = n6;
        tooth2.rotateAngleX = n6;
        tooth1.rotateAngleX = n6;
        d1 = (float) (Math.sin(newangle) * 12.0);
        d2 = (float) (Math.cos(newangle) * 12.0);
        final ModelRenderer tooth5 = this.tooth1;
        final ModelRenderer tooth6 = this.tooth2;
        final ModelRenderer tooth7 = this.tooth3;
        final ModelRenderer tooth8 = this.tooth4;
        final float n7 = this.head.rotationPointZ - d1;
        tooth8.rotationPointZ = n7;
        tooth7.rotationPointZ = n7;
        tooth6.rotationPointZ = n7;
        tooth5.rotationPointZ = n7;
        newangle = this.head.rotateAngleZ;
        final ModelRenderer tooth9 = this.tooth1;
        final ModelRenderer tooth10 = this.tooth2;
        final ModelRenderer tooth11 = this.tooth3;
        final ModelRenderer tooth12 = this.tooth4;
        final float n8 = newangle;
        tooth12.rotateAngleZ = n8;
        tooth11.rotateAngleZ = n8;
        tooth10.rotateAngleZ = n8;
        tooth9.rotateAngleZ = n8;
        d3 = (float) (Math.cos(newangle) * d2);
        d4 = (float) (Math.sin(newangle) * d2);
        final ModelRenderer tooth13 = this.tooth1;
        final ModelRenderer tooth14 = this.tooth2;
        final ModelRenderer tooth15 = this.tooth3;
        final ModelRenderer tooth16 = this.tooth4;
        final float n9 = this.head.rotationPointX + d4;
        tooth16.rotationPointX = n9;
        tooth15.rotationPointX = n9;
        tooth14.rotationPointX = n9;
        tooth13.rotationPointX = n9;
        final ModelRenderer tooth17 = this.tooth1;
        final ModelRenderer tooth18 = this.tooth2;
        final ModelRenderer tooth19 = this.tooth3;
        final ModelRenderer tooth20 = this.tooth4;
        final float n10 = (float) (this.head.rotationPointY - 12.0 + (12.0 - d3));
        tooth20.rotationPointY = n10;
        tooth19.rotationPointY = n10;
        tooth18.rotationPointY = n10;
        tooth17.rotationPointY = n10;
        final ModelRenderer tooth21 = this.tooth1;
        ++tooth21.rotationPointZ;
        final ModelRenderer tooth22 = this.tooth2;
        --tooth22.rotationPointZ;
        this.tooth1.rotateAngleX = this.tooth1.rotateAngleX - 0.4f - MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.tooth2.rotateAngleX = this.tooth2.rotateAngleX + 0.4f + MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        final ModelRenderer tooth23 = this.tooth3;
        ++tooth23.rotationPointX;
        final ModelRenderer tooth24 = this.tooth4;
        --tooth24.rotationPointX;
        this.tooth3.rotateAngleZ = this.tooth3.rotateAngleZ + 0.4f + MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.tooth4.rotateAngleZ = this.tooth4.rotateAngleZ - 0.4f - MathHelper.cos(f2 * 0.55f) * 3.1415927f * 0.15f;
        this.head.render(f5);
        this.body.render(f5);
        this.tail.render(f5);
        this.tooth1.render(f5);
        this.tooth2.render(f5);
        this.tooth3.render(f5);
        this.tooth4.render(f5);
        this.head2.render(f5);
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
