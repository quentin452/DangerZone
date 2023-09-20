
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CannonFodderInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.VelocityRaptor;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelVelocityRaptor extends ModelBase {

    private float wingspeed;
    ModelRenderer hf3;
    ModelRenderer hf4;
    ModelRenderer hf2;
    ModelRenderer hf1;
    ModelRenderer lff2;
    ModelRenderer lff1;
    ModelRenderer lff3;
    ModelRenderer rff2;
    ModelRenderer rff3;
    ModelRenderer rff1;
    ModelRenderer tf4;
    ModelRenderer tf1;
    ModelRenderer Shape1;
    ModelRenderer neck;
    ModelRenderer head1;
    ModelRenderer lf1;
    ModelRenderer lf2;
    ModelRenderer head2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer bl1;
    ModelRenderer br1;
    ModelRenderer bl2;
    ModelRenderer br2;
    ModelRenderer bl3;
    ModelRenderer bl4;
    ModelRenderer br3;
    ModelRenderer rf1;
    ModelRenderer rf2;
    ModelRenderer tf2;
    ModelRenderer tf3;
    ModelRenderer br4;
    ModelRenderer Hat1;
    ModelRenderer Hat2;

    public ModelVelocityRaptor(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.hf3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 3);
        this.hf3.setRotationPoint(0.0f, 7.0f, -2.0f);
        this.hf3.setTextureSize(128, 128);
        this.hf3.mirror = true;
        this.setRotation(this.hf3, 0.4537856f, 0.0f, 0.0f);
        (this.hf4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -0.2f, 0.0f, 0, 1, 3);
        this.hf4.setRotationPoint(0.0f, 8.0f, -1.5f);
        this.hf4.setTextureSize(128, 128);
        this.hf4.mirror = true;
        this.setRotation(this.hf4, 0.2443461f, 0.0f, 0.0f);
        (this.hf2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 3);
        this.hf2.setRotationPoint(0.0f, 7.0f, -3.5f);
        this.hf2.setTextureSize(128, 128);
        this.hf2.mirror = true;
        this.setRotation(this.hf2, 0.6632251f, 0.0f, 0.0f);
        (this.hf1 = new ModelRenderer((ModelBase) this, 0, 1)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 2);
        this.hf1.setRotationPoint(0.0f, 7.0f, -4.5f);
        this.hf1.setTextureSize(128, 128);
        this.hf1.mirror = true;
        this.setRotation(this.hf1, 0.9424778f, 0.0f, 0.0f);
        (this.lff2 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(0.5f, 2.5f, 3.0f, 0, 1, 3);
        this.lff2.setRotationPoint(2.0f, 14.0f, 1.0f);
        this.lff2.setTextureSize(128, 128);
        this.lff2.mirror = true;
        this.setRotation(this.lff2, -0.4537856f, 0.0f, 0.0f);
        (this.lff1 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(0.5f, 2.0f, 2.0f, 0, 1, 3);
        this.lff1.setRotationPoint(2.0f, 14.0f, 1.0f);
        this.lff1.setTextureSize(128, 128);
        this.lff1.mirror = true;
        this.setRotation(this.lff1, -0.2792527f, 0.0f, 0.0f);
        (this.lff3 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(0.5f, 1.0f, 4.0f, 0, 1, 3);
        this.lff3.setRotationPoint(2.0f, 14.0f, 1.0f);
        this.lff3.setTextureSize(128, 128);
        this.lff3.mirror = true;
        this.setRotation(this.lff3, -1.047198f, 0.0f, 0.0f);
        (this.rff2 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(-0.5f, 2.5f, 3.0f, 0, 1, 3);
        this.rff2.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.rff2.setTextureSize(128, 128);
        this.rff2.mirror = true;
        this.setRotation(this.rff2, -0.4537856f, 0.0f, 0.0f);
        (this.rff3 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(-0.5f, 1.0f, 4.0f, 0, 1, 3);
        this.rff3.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.rff3.setTextureSize(128, 128);
        this.rff3.mirror = true;
        this.setRotation(this.rff3, -1.047198f, 0.0f, 0.0f);
        (this.rff1 = new ModelRenderer((ModelBase) this, 0, 6)).addBox(-0.5f, 2.0f, 2.0f, 0, 1, 3);
        this.rff1.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.rff1.setTextureSize(128, 128);
        this.rff1.mirror = true;
        this.setRotation(this.rff1, -0.2792527f, 0.0f, 0.0f);
        (this.tf4 = new ModelRenderer((ModelBase) this, 0, 3)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 3);
        this.tf4.setRotationPoint(0.0f, 11.0f, 25.0f);
        this.tf4.setTextureSize(128, 128);
        this.tf4.mirror = true;
        this.setRotation(this.tf4, -0.5410521f, 0.0f, 0.0f);
        (this.tf1 = new ModelRenderer((ModelBase) this, 0, 3)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 3);
        this.tf1.setRotationPoint(0.0f, 11.0f, 19.0f);
        this.tf1.setTextureSize(128, 128);
        this.tf1.mirror = true;
        this.setRotation(this.tf1, -0.5410521f, 0.0f, 0.0f);
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-2.0f, 0.0f, 0.0f, 4, 7, 11);
        this.Shape1.setRotationPoint(0.0f, 10.0f, 0.0f);
        this.Shape1.setTextureSize(128, 128);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase) this, 0, 19)).addBox(-1.0f, -7.0f, -2.0f, 2, 8, 3);
        this.neck.setRotationPoint(0.0f, 12.0f, 2.0f);
        this.neck.setTextureSize(128, 128);
        this.neck.mirror = true;
        this.setRotation(this.neck, 1.082104f, 0.0f, 0.0f);
        (this.head1 = new ModelRenderer((ModelBase) this, 0, 49)).addBox(-2.0f, 0.0f, -7.0f, 3, 4, 7);
        this.head1.setRotationPoint(0.5f, 7.0f, -1.0f);
        this.head1.setTextureSize(128, 128);
        this.head1.mirror = true;
        this.setRotation(this.head1, 0.0f, 0.0f, 0.0f);
        (this.lf1 = new ModelRenderer((ModelBase) this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 2);
        this.lf1.setRotationPoint(2.0f, 14.0f, 1.0f);
        this.lf1.setTextureSize(128, 128);
        this.lf1.mirror = true;
        this.setRotation(this.lf1, 0.2792527f, 0.0f, 0.0f);
        (this.lf2 = new ModelRenderer((ModelBase) this, 16, 19)).addBox(0.0f, 1.0f, 2.0f, 1, 4, 1);
        this.lf2.setRotationPoint(2.0f, 14.0f, 1.0f);
        this.lf2.setTextureSize(128, 128);
        this.lf2.mirror = true;
        this.setRotation(this.lf2, -0.4363323f, 0.0f, 0.0f);
        (this.head2 = new ModelRenderer((ModelBase) this, 20, 0)).addBox(-1.0f, 0.0f, -10.0f, 2, 4, 4);
        this.head2.setRotationPoint(0.0f, 7.0f, -1.0f);
        this.head2.setTextureSize(128, 128);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 0, 38)).addBox(-1.0f, 0.0f, 0.0f, 2, 5, 4);
        this.tail1.setRotationPoint(0.0f, 10.0f, 11.0f);
        this.tail1.setTextureSize(128, 128);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, 0.0f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 26, 11)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 10);
        this.tail2.setRotationPoint(-0.5f, 10.0f, 15.0f);
        this.tail2.setTextureSize(128, 128);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, 0.0f, 0.0f, 0.0f);
        (this.bl1 = new ModelRenderer((ModelBase) this, 22, 24)).addBox(-1.0f, 0.0f, 0.0f, 2, 6, 4);
        this.bl1.setRotationPoint(2.0f, 13.0f, 6.0f);
        this.bl1.setTextureSize(128, 128);
        this.bl1.mirror = true;
        this.setRotation(this.bl1, 0.0f, 0.0f, 0.0f);
        (this.br1 = new ModelRenderer((ModelBase) this, 36, 0)).addBox(-1.0f, 0.0f, 0.0f, 2, 6, 4);
        this.br1.setRotationPoint(-2.0f, 13.0f, 6.0f);
        this.br1.setTextureSize(128, 128);
        this.br1.mirror = true;
        this.setRotation(this.br1, 0.0f, 0.0f, 0.0f);
        (this.bl2 = new ModelRenderer((ModelBase) this, 12, 26)).addBox(-1.0f, 5.0f, -3.0f, 2, 5, 2);
        this.bl2.setRotationPoint(2.0f, 13.0f, 6.0f);
        this.bl2.setTextureSize(128, 128);
        this.bl2.mirror = true;
        this.setRotation(this.bl2, 0.4886922f, 0.0f, 0.0f);
        (this.br2 = new ModelRenderer((ModelBase) this, 13, 36)).addBox(-1.0f, 5.0f, -3.0f, 2, 5, 2);
        this.br2.setRotationPoint(-2.0f, 13.0f, 6.0f);
        this.br2.setTextureSize(128, 128);
        this.br2.mirror = true;
        this.setRotation(this.br2, 0.4886922f, 0.0f, 0.0f);
        (this.bl3 = new ModelRenderer((ModelBase) this, 28, 39)).addBox(-1.0f, 9.0f, -1.0f, 2, 2, 4);
        this.bl3.setRotationPoint(2.0f, 13.0f, 6.0f);
        this.bl3.setTextureSize(128, 128);
        this.bl3.mirror = true;
        this.setRotation(this.bl3, 0.0f, 0.0f, 0.0f);
        (this.br3 = new ModelRenderer((ModelBase) this, 18, 45)).addBox(-1.0f, 9.0f, -1.0f, 2, 2, 4);
        this.br3.setRotationPoint(-2.0f, 13.0f, 6.0f);
        this.br3.setTextureSize(128, 128);
        this.br3.mirror = true;
        this.setRotation(this.br3, 0.0f, 0.0f, 0.0f);
        (this.rf1 = new ModelRenderer((ModelBase) this, 35, 31)).addBox(-1.0f, 0.0f, 0.0f, 1, 3, 2);
        this.rf1.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.rf1.setTextureSize(128, 128);
        this.rf1.mirror = true;
        this.setRotation(this.rf1, 0.2792527f, 0.0f, 0.0f);
        (this.rf2 = new ModelRenderer((ModelBase) this, 11, 19)).addBox(-1.0f, 1.0f, 2.0f, 1, 4, 1);
        this.rf2.setRotationPoint(-2.0f, 14.0f, 1.0f);
        this.rf2.setTextureSize(128, 128);
        this.rf2.mirror = true;
        this.setRotation(this.rf2, -0.4363323f, 0.0f, 0.0f);
        (this.tf2 = new ModelRenderer((ModelBase) this, 0, 3)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 3);
        this.tf2.setRotationPoint(0.0f, 11.0f, 21.0f);
        this.tf2.setTextureSize(128, 128);
        this.tf2.mirror = true;
        this.setRotation(this.tf2, -0.5410521f, 0.0f, 0.0f);
        (this.tf3 = new ModelRenderer((ModelBase) this, 0, 3)).addBox(0.0f, 0.0f, 0.0f, 0, 1, 3);
        this.tf3.setRotationPoint(0.0f, 11.0f, 23.0f);
        this.tf3.setTextureSize(128, 128);
        this.tf3.mirror = true;
        this.setRotation(this.tf3, -0.5410521f, 0.0f, 0.0f);
        (this.bl4 = new ModelRenderer((ModelBase) this, 31, 10)).addBox(-1.0f, 6.0f, -5.0f, 1, 3, 1);
        this.bl4.setRotationPoint(2.0f, 13.0f, 6.0f);
        this.bl4.setTextureSize(128, 128);
        this.bl4.mirror = true;
        this.setRotation(this.bl4, 0.6283185f, 0.0f, 0.0f);
        (this.br4 = new ModelRenderer((ModelBase) this, 31, 15)).addBox(0.0f, 6.0f, -5.0f, 1, 3, 1);
        this.br4.setRotationPoint(-2.0f, 13.0f, 6.0f);
        this.br4.setTextureSize(128, 128);
        this.br4.mirror = true;
        this.setRotation(this.br4, 0.6283185f, 0.0f, 0.0f);
        (this.Hat1 = new ModelRenderer((ModelBase) this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 5);
        this.Hat1.setRotationPoint(-2.0f, 6.0f, -6.0f);
        this.Hat1.setTextureSize(128, 128);
        this.Hat1.mirror = true;
        this.setRotation(this.Hat1, 0.0f, 0.0f, 0.0f);
        (this.Hat2 = new ModelRenderer((ModelBase) this, 50, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 3);
        this.Hat2.setRotationPoint(-1.5f, 4.0f, -4.0f);
        this.Hat2.setTextureSize(128, 128);
        this.Hat2.mirror = true;
        this.setRotation(this.Hat2, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final VelocityRaptor c = (VelocityRaptor) entity;
        float hf = 0.0f;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.bl1.rotateAngleX = newangle;
        this.bl2.rotateAngleX = newangle + 0.488f;
        this.bl3.rotateAngleX = newangle;
        this.bl4.rotateAngleX = newangle + 0.628f;
        this.br1.rotateAngleX = -newangle;
        this.br2.rotateAngleX = -newangle + 0.488f;
        this.br3.rotateAngleX = -newangle;
        this.br4.rotateAngleX = -newangle + 0.628f;
        hf = c.getVHealth() / c.getMaxHealth();
        newangle = MathHelper.cos(f2 * 1.25f * this.wingspeed * hf) * 3.1415927f * 0.1f * hf;
        this.hf1.rotateAngleY = newangle;
        this.hf2.rotateAngleY = -newangle;
        this.hf3.rotateAngleY = newangle;
        this.hf4.rotateAngleY = -newangle;
        newangle = MathHelper.cos(f2 * 0.3f) * 3.1415927f * 0.05f;
        this.lf1.rotateAngleX = newangle + 0.279f;
        this.lf2.rotateAngleX = newangle - 0.436f;
        this.lff1.rotateAngleX = newangle - 0.279f;
        this.lff2.rotateAngleX = newangle - 0.453f;
        this.lff3.rotateAngleX = newangle - 1.047f;
        this.rf1.rotateAngleX = -newangle + 0.279f;
        this.rf2.rotateAngleX = -newangle - 0.436f;
        this.rff1.rotateAngleX = -newangle - 0.279f;
        this.rff2.rotateAngleX = -newangle - 0.453f;
        this.rff3.rotateAngleX = -newangle - 1.047f;
        newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.1f;
        this.lff1.rotateAngleY = newangle;
        this.lff2.rotateAngleY = -newangle;
        this.lff3.rotateAngleY = newangle;
        this.rff1.rotateAngleY = -newangle;
        this.rff2.rotateAngleY = newangle;
        this.rff3.rotateAngleY = -newangle;
        if (c.isSitting()) {
            newangle = 0.0f;
        } else {
            newangle = MathHelper.cos(f2 * 1.4f * this.wingspeed * hf) * 3.1415927f * 0.25f * hf;
        }
        this.tf1.rotateAngleZ = newangle;
        this.tf2.rotateAngleZ = -newangle;
        this.tf3.rotateAngleZ = newangle;
        this.tf4.rotateAngleZ = -newangle;
        this.hf3.render(f5);
        this.hf4.render(f5);
        this.hf2.render(f5);
        this.hf1.render(f5);
        this.tf1.render(f5);
        this.tf2.render(f5);
        this.tf3.render(f5);
        this.tf4.render(f5);
        this.lf1.render(f5);
        this.lf2.render(f5);
        this.lff2.render(f5);
        this.lff1.render(f5);
        this.lff3.render(f5);
        this.rf1.render(f5);
        this.rf2.render(f5);
        this.rff2.render(f5);
        this.rff3.render(f5);
        this.rff1.render(f5);
        this.bl1.render(f5);
        this.bl2.render(f5);
        this.bl3.render(f5);
        this.bl4.render(f5);
        this.br1.render(f5);
        this.br2.render(f5);
        this.br3.render(f5);
        this.br4.render(f5);
        this.Shape1.render(f5);
        this.neck.render(f5);
        this.head1.render(f5);
        this.head2.render(f5);
        this.tail1.render(f5);
        this.tail2.render(f5);
        if (c instanceof CannonFodderInstance && c.get_is_activated() != 0) {
            this.Hat1.render(f5);
            if (c.get_is_activated() > 1) {
                this.Hat2.render(f5);
            }
        }
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
