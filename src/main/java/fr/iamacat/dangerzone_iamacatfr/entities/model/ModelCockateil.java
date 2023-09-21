
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCockateil extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer Head;
    ModelRenderer Beak;
    ModelRenderer LowerBeak;
    ModelRenderer feather2;
    ModelRenderer feather1;
    ModelRenderer feather3;
    ModelRenderer tailfeather1;
    ModelRenderer rwing1;
    ModelRenderer lwing1;
    ModelRenderer leg;
    ModelRenderer otherleg;
    ModelRenderer lwing2;
    ModelRenderer rwing2;
    ModelRenderer tailfeather2;
    ModelRenderer tailfeather3;

    public ModelCockateil(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 3, 6);
        this.Body.setRotationPoint(-1.0f, 18.0f, 0.0f);
        this.Body.setTextureSize(64, 32);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 22, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 4);
        this.Head.setRotationPoint(0.0f, 16.0f, -3.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Beak = new ModelRenderer((ModelBase) this, 0, 21)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 3);
        this.Beak.setRotationPoint(1.0f, 17.0f, -6.0f);
        this.Beak.setTextureSize(64, 32);
        this.Beak.mirror = true;
        this.setRotation(this.Beak, 0.0f, 0.0f, 0.0f);
        (this.LowerBeak = new ModelRenderer((ModelBase) this, 1, 17)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 1);
        this.LowerBeak.setRotationPoint(1.0f, 18.0f, -4.0f);
        this.LowerBeak.setTextureSize(64, 32);
        this.LowerBeak.mirror = true;
        this.setRotation(this.LowerBeak, 0.0f, 0.0f, 0.0f);
        (this.feather2 = new ModelRenderer((ModelBase) this, 15, 9)).addBox(0.0f, -2.5f, -0.75f, 1, 3, 1);
        this.feather2.setRotationPoint(1.0f, 16.0f, 0.0f);
        this.feather2.setTextureSize(64, 32);
        this.feather2.mirror = true;
        this.setRotation(this.feather2, -0.6426736f, 0.0f, 0.0f);
        (this.feather1 = new ModelRenderer((ModelBase) this, 11, 9)).addBox(0.0f, -2.5f, -0.5f, 1, 3, 1);
        this.feather1.setRotationPoint(1.0f, 16.0f, -2.0f);
        this.feather1.setTextureSize(64, 32);
        this.feather1.mirror = true;
        this.setRotation(this.feather1, -0.2230717f, 0.0f, 0.0f);
        (this.feather3 = new ModelRenderer((ModelBase) this, 19, 9)).addBox(0.0f, -3.0f, 0.5f, 1, 4, 1);
        this.feather3.setRotationPoint(1.0f, 16.0f, 1.0f);
        this.feather3.setTextureSize(64, 32);
        this.feather3.mirror = true;
        this.setRotation(this.feather3, -1.276259f, 0.0f, 0.0f);
        (this.tailfeather1 = new ModelRenderer((ModelBase) this, 46, 15)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 3);
        this.tailfeather1.setRotationPoint(0.0f, 18.0f, 6.0f);
        this.tailfeather1.setTextureSize(64, 32);
        this.tailfeather1.mirror = true;
        this.setRotation(this.tailfeather1, 0.0f, 0.0f, 0.0f);
        (this.rwing1 = new ModelRenderer((ModelBase) this, 23, 9)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 4);
        this.rwing1.setRotationPoint(-1.0f, 18.0f, 1.0f);
        this.rwing1.setTextureSize(64, 32);
        this.rwing1.mirror = true;
        this.setRotation(this.rwing1, 0.0f, 0.0f, 1.595066f);
        (this.lwing1 = new ModelRenderer((ModelBase) this, 33, 9)).addBox(-1.0f, 0.0f, 0.0f, 1, 4, 4);
        this.lwing1.setRotationPoint(4.0f, 18.0f, 1.0f);
        this.lwing1.setTextureSize(64, 32);
        this.lwing1.mirror = true;
        this.setRotation(this.lwing1, 0.0f, 0.0f, -1.561488f);
        (this.leg = new ModelRenderer((ModelBase) this, 4, 12)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.leg.setRotationPoint(2.0f, 21.0f, 3.0f);
        this.leg.setTextureSize(64, 32);
        this.leg.mirror = true;
        this.setRotation(this.leg, 0.8726646f, 0.0f, 0.0f);
        (this.otherleg = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.otherleg.setRotationPoint(0.0f, 21.0f, 3.0f);
        this.otherleg.setTextureSize(64, 32);
        this.otherleg.mirror = true;
        this.setRotation(this.otherleg, 0.6108652f, 0.0f, 0.0f);
        (this.lwing2 = new ModelRenderer((ModelBase) this, 10, 14)).addBox(4.0f, 0.0f, 0.0f, 3, 1, 3);
        this.lwing2.setRotationPoint(4.0f, 18.0f, 1.0f);
        this.lwing2.setTextureSize(64, 32);
        this.lwing2.mirror = true;
        this.setRotation(this.lwing2, 0.0f, 0.0f, 0.0f);
        (this.rwing2 = new ModelRenderer((ModelBase) this, 10, 19)).addBox(-7.0f, 0.0f, 0.0f, 3, 1, 3);
        this.rwing2.setRotationPoint(-1.0f, 18.0f, 1.0f);
        this.rwing2.setTextureSize(64, 32);
        this.rwing2.mirror = true;
        this.setRotation(this.rwing2, 0.0f, 0.0f, 0.0f);
        (this.tailfeather2 = new ModelRenderer((ModelBase) this, 44, 20)).addBox(-0.5f, 0.0f, 3.0f, 4, 1, 4);
        this.tailfeather2.setRotationPoint(0.0f, 18.0f, 6.0f);
        this.tailfeather2.setTextureSize(64, 32);
        this.tailfeather2.mirror = true;
        this.setRotation(this.tailfeather2, 0.0f, 0.0f, 0.0f);
        (this.tailfeather3 = new ModelRenderer((ModelBase) this, 36, 26)).addBox(-1.0f, 0.0f, 7.0f, 5, 1, 4);
        this.tailfeather3.setRotationPoint(0.0f, 18.0f, 6.0f);
        this.tailfeather3.setTextureSize(64, 32);
        this.tailfeather3.mirror = true;
        this.setRotation(this.tailfeather3, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 1.5f * this.wingspeed) * 3.1415927f * 0.35f;
        this.lwing1.rotateAngleZ = -1.5f + newangle;
        this.lwing2.rotateAngleZ = newangle;
        this.rwing1.rotateAngleZ = 1.5f - newangle;
        this.rwing2.rotateAngleZ = -newangle;
        newangle = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.1415927f * 0.1f;
        this.tailfeather1.rotateAngleX = newangle;
        this.tailfeather2.rotateAngleX = newangle;
        this.tailfeather3.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.08f;
        this.feather1.rotateAngleZ = newangle;
        newangle = MathHelper.cos(f2 * 1.2f * this.wingspeed) * 3.1415927f * 0.08f;
        this.feather2.rotateAngleZ = newangle;
        newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.08f;
        this.feather3.rotateAngleZ = newangle;
        this.Body.render(f5);
        this.Head.render(f5);
        this.Beak.render(f5);
        this.LowerBeak.render(f5);
        this.feather2.render(f5);
        this.feather1.render(f5);
        this.feather3.render(f5);
        this.tailfeather1.render(f5);
        this.rwing1.render(f5);
        this.lwing1.render(f5);
        this.leg.render(f5);
        this.otherleg.render(f5);
        this.lwing2.render(f5);
        this.rwing2.render(f5);
        this.tailfeather2.render(f5);
        this.tailfeather3.render(f5);
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
