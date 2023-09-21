
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGoldFish extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Dorsalfin;
    ModelRenderer Mouth;
    ModelRenderer Jaw;
    ModelRenderer Pectoralfin1;
    ModelRenderer Pectoralfin2;
    ModelRenderer Pectoralfin3;
    ModelRenderer Pectoralfin4;
    ModelRenderer Bottomfin;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Caudalfin1;
    ModelRenderer Caudalfin2;
    ModelRenderer Bottomfin1;
    ModelRenderer Bottomfin2;

    public ModelGoldFish(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.Body = new ModelRenderer((ModelBase) this, 0, 15)).addBox(-2.0f, -2.0f, 0.0f, 4, 4, 10);
        this.Body.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 0, 30)).addBox(-1.5f, -2.0f, -3.0f, 3, 4, 3);
        this.Head.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Head.setTextureSize(64, 64);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Dorsalfin = new ModelRenderer((ModelBase) this, 29, 0)).addBox(0.0f, -6.0f, 0.0f, 0, 4, 10);
        this.Dorsalfin.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Dorsalfin.setTextureSize(64, 64);
        this.Dorsalfin.mirror = true;
        this.setRotation(this.Dorsalfin, 0.0f, 0.0f, 0.0f);
        (this.Mouth = new ModelRenderer((ModelBase) this, 0, 38)).addBox(-1.5f, 0.6f, -3.5f, 3, 3, 3);
        this.Mouth.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Mouth.setTextureSize(64, 64);
        this.Mouth.mirror = true;
        this.setRotation(this.Mouth, -0.7853982f, 0.0f, 0.0f);
        (this.Jaw = new ModelRenderer((ModelBase) this, 13, 30)).addBox(-1.0f, 0.0f, -3.0f, 3, 1, 3);
        this.Jaw.setRotationPoint(-0.5f, 15.6f, -7.4f);
        this.Jaw.setTextureSize(64, 64);
        this.Jaw.mirror = true;
        this.setRotation(this.Jaw, -0.2284419f, 0.0f, 0.0f);
        (this.Pectoralfin1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin1.setRotationPoint(-2.0f, 14.0f, -3.0f);
        this.Pectoralfin1.setTextureSize(64, 64);
        this.Pectoralfin1.mirror = true;
        this.setRotation(this.Pectoralfin1, -0.2974289f, -0.3346075f, 0.0f);
        (this.Pectoralfin2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin2.setRotationPoint(2.0f, 14.0f, -3.0f);
        this.Pectoralfin2.setTextureSize(64, 64);
        this.Pectoralfin2.mirror = true;
        this.setRotation(this.Pectoralfin2, -0.2974216f, 0.3346145f, 0.0f);
        (this.Pectoralfin3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin3.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.Pectoralfin3.setTextureSize(64, 64);
        this.Pectoralfin3.mirror = true;
        this.setRotation(this.Pectoralfin3, -0.2974289f, -0.3346075f, 0.0f);
        (this.Pectoralfin4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -1.5f, 0.0f, 0, 3, 5);
        this.Pectoralfin4.setRotationPoint(2.0f, 14.0f, 1.0f);
        this.Pectoralfin4.setTextureSize(64, 64);
        this.Pectoralfin4.mirror = true;
        this.setRotation(this.Pectoralfin4, -0.2974289f, 0.3346145f, 0.0f);
        (this.Bottomfin = new ModelRenderer((ModelBase) this, 20, 8)).addBox(0.0f, 2.0f, 6.0f, 0, 3, 4);
        this.Bottomfin.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Bottomfin.setTextureSize(64, 64);
        this.Bottomfin.mirror = true;
        this.setRotation(this.Bottomfin, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 29, 15)).addBox(-1.5f, -2.0f, 0.0f, 3, 4, 6);
        this.Tail1.setRotationPoint(0.0f, 14.0f, 5.0f);
        this.Tail1.setTextureSize(64, 64);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 0, 8)).addBox(-1.0f, -1.5f, 6.0f, 2, 3, 4);
        this.Tail2.setRotationPoint(0.0f, 14.0f, 5.0f);
        this.Tail2.setTextureSize(64, 64);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Caudalfin1 = new ModelRenderer((ModelBase) this, 13, 35)).addBox(-0.5f, 5.5f, 6.0f, 1, 3, 4);
        this.Caudalfin1.setRotationPoint(0.0f, 14.0f, 5.0f);
        this.Caudalfin1.setTextureSize(64, 64);
        this.Caudalfin1.mirror = true;
        this.setRotation(this.Caudalfin1, 0.8179294f, 0.0f, 0.0f);
        (this.Caudalfin2 = new ModelRenderer((ModelBase) this, 15, 35)).addBox(-0.5f, 5.5f, 6.0f, 1, 4, 3);
        this.Caudalfin2.setRotationPoint(0.0f, 14.0f, 5.0f);
        this.Caudalfin2.setTextureSize(64, 64);
        this.Caudalfin2.mirror = true;
        this.setRotation(this.Caudalfin2, 0.8179294f, 0.0f, 0.0f);
        (this.Bottomfin1 = new ModelRenderer((ModelBase) this, 20, 0)).addBox(-1.0f, 2.0f, 1.0f, 0, 5, 2);
        this.Bottomfin1.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Bottomfin1.setTextureSize(64, 64);
        this.Bottomfin1.mirror = true;
        this.setRotation(this.Bottomfin1, 0.2974289f, 0.0f, 0.3346145f);
        (this.Bottomfin2 = new ModelRenderer((ModelBase) this, 20, 0)).addBox(1.0f, 2.0f, 1.0f, 0, 5, 2);
        this.Bottomfin2.setRotationPoint(0.0f, 14.0f, -5.0f);
        this.Bottomfin2.setTextureSize(64, 64);
        this.Bottomfin2.mirror = true;
        this.setRotation(this.Bottomfin2, 0.2974289f, 0.0f, -0.3346075f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin1.rotateAngleY = 0.4f + newangle;
        newangle = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin2.rotateAngleY = -0.4f + newangle;
        newangle = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin3.rotateAngleY = 0.4f + newangle;
        newangle = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Pectoralfin4.rotateAngleY = -0.4f + newangle;
        newangle = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.25f;
        this.Bottomfin1.rotateAngleY = newangle;
        this.Bottomfin2.rotateAngleY = -newangle;
        newangle = MathHelper.cos(f2 * 0.7f * this.wingspeed) * 3.1415927f * 0.1f;
        this.Jaw.rotateAngleX = -0.25f + newangle;
        this.Body.render(f5);
        this.Head.render(f5);
        this.Dorsalfin.render(f5);
        this.Mouth.render(f5);
        this.Jaw.render(f5);
        this.Pectoralfin1.render(f5);
        this.Pectoralfin2.render(f5);
        this.Pectoralfin3.render(f5);
        this.Pectoralfin4.render(f5);
        this.Bottomfin.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Caudalfin1.render(f5);
        this.Caudalfin2.render(f5);
        this.Bottomfin1.render(f5);
        this.Bottomfin2.render(f5);
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
