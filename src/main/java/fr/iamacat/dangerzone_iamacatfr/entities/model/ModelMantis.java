
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Mantis;

public class ModelMantis extends ModelBase {

    private float wingspeed;
    ModelRenderer lfleg1;
    ModelRenderer lfleg2;
    ModelRenderer lfleg3;
    ModelRenderer lfleg4;
    ModelRenderer lrleg1;
    ModelRenderer lrleg2;
    ModelRenderer lrleg3;
    ModelRenderer lrleg4;
    ModelRenderer abdomen;
    ModelRenderer thorax;
    ModelRenderer neck1;
    ModelRenderer neck2;
    ModelRenderer head1;
    ModelRenderer head2;
    ModelRenderer leye;
    ModelRenderer reye;
    ModelRenderer lantenna;
    ModelRenderer rantenna;
    ModelRenderer larm1;
    ModelRenderer larm2;
    ModelRenderer larm3;
    ModelRenderer lfwing;
    ModelRenderer rfwing;
    ModelRenderer lrwing;
    ModelRenderer rrwing;
    ModelRenderer rarm1;
    ModelRenderer rarm2;
    ModelRenderer rarm3;
    ModelRenderer rlfleg3;
    ModelRenderer rfleg4;
    ModelRenderer rfleg2;
    ModelRenderer rfleg1;
    ModelRenderer rrleg3;
    ModelRenderer rrleg4;
    ModelRenderer rrleg2;
    ModelRenderer rrleg1;

    public ModelMantis(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.lfleg1 = new ModelRenderer((ModelBase) this, 28, 35)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.lfleg1.setRotationPoint(27.0f, 16.0f, -3.0f);
        this.lfleg1.setTextureSize(256, 256);
        this.lfleg1.mirror = true;
        this.setRotation(this.lfleg1, 0.0f, 0.0f, -0.6283185f);
        (this.lfleg2 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(0.0f, 0.0f, 0.0f, 1, 22, 1);
        this.lfleg2.setRotationPoint(21.0f, -5.0f, -3.0f);
        this.lfleg2.setTextureSize(256, 256);
        this.lfleg2.mirror = true;
        this.setRotation(this.lfleg2, 0.0f, 0.0f, -0.2792527f);
        (this.lfleg3 = new ModelRenderer((ModelBase) this, 64, 2)).addBox(0.0f, 0.0f, 0.0f, 20, 1, 1);
        this.lfleg3.setRotationPoint(2.0f, -5.0f, 0.0f);
        this.lfleg3.setTextureSize(256, 256);
        this.lfleg3.mirror = true;
        this.setRotation(this.lfleg3, 0.0f, 0.1570796f, 0.0f);
        (this.lfleg4 = new ModelRenderer((ModelBase) this, 64, 20)).addBox(15.0f, 0.0f, -2.0f, 4, 1, 5);
        this.lfleg4.setRotationPoint(2.0f, -5.0f, 0.0f);
        this.lfleg4.setTextureSize(256, 256);
        this.lfleg4.mirror = true;
        this.setRotation(this.lfleg4, 0.0f, 0.1570796f, 0.0f);
        (this.lrleg1 = new ModelRenderer((ModelBase) this, 35, 35)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.lrleg1.setRotationPoint(32.0f, 18.0f, 11.0f);
        this.lrleg1.setTextureSize(256, 256);
        this.lrleg1.mirror = true;
        this.setRotation(this.lrleg1, 0.0f, 0.0f, -0.8726646f);
        (this.lrleg2 = new ModelRenderer((ModelBase) this, 14, 32)).addBox(0.0f, 0.0f, 0.0f, 1, 22, 1);
        this.lrleg2.setRotationPoint(21.0f, 0.0f, 11.0f);
        this.lrleg2.setTextureSize(256, 256);
        this.lrleg2.mirror = true;
        this.setRotation(this.lrleg2, 0.0f, 0.0f, -0.5410521f);
        (this.lrleg3 = new ModelRenderer((ModelBase) this, 64, 11)).addBox(0.0f, 0.0f, 0.0f, 20, 1, 1);
        this.lrleg3.setRotationPoint(2.0f, 0.0f, 8.0f);
        this.lrleg3.setTextureSize(256, 256);
        this.lrleg3.mirror = true;
        this.setRotation(this.lrleg3, 0.0f, -0.1570796f, 0.0f);
        (this.lrleg4 = new ModelRenderer((ModelBase) this, 64, 36)).addBox(15.0f, 0.0f, -2.0f, 4, 1, 5);
        this.lrleg4.setRotationPoint(2.0f, 0.0f, 8.0f);
        this.lrleg4.setTextureSize(256, 256);
        this.lrleg4.mirror = true;
        this.setRotation(this.lrleg4, 0.0f, -0.1570796f, 0.0f);
        (this.abdomen = new ModelRenderer((ModelBase) this, 118, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 5, 53);
        this.abdomen.setRotationPoint(-4.0f, -11.0f, 0.0f);
        this.abdomen.setTextureSize(256, 256);
        this.abdomen.mirror = true;
        this.setRotation(this.abdomen, -0.5061455f, 0.0f, 0.0f);
        (this.thorax = new ModelRenderer((ModelBase) this, 145, 62)).addBox(0.0f, 0.0f, 0.0f, 15, 3, 13);
        this.thorax.setRotationPoint(-7.0f, -14.0f, -12.0f);
        this.thorax.setTextureSize(256, 256);
        this.thorax.mirror = true;
        this.setRotation(this.thorax, -0.2443461f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase) this, 145, 82)).addBox(0.0f, 0.0f, 0.0f, 9, 1, 15);
        this.neck1.setRotationPoint(-4.0f, -15.0f, -27.0f);
        this.neck1.setTextureSize(256, 256);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, -0.0698132f, 0.0f, 0.0f);
        (this.neck2 = new ModelRenderer((ModelBase) this, 40, 150)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 2);
        this.neck2.setRotationPoint(-1.0f, -15.0f, -29.0f);
        this.neck2.setTextureSize(256, 256);
        this.neck2.mirror = true;
        this.setRotation(this.neck2, 0.0f, 0.0f, 0.0f);
        (this.head1 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 1);
        this.head1.setRotationPoint(0.0f, -16.0f, -30.0f);
        this.head1.setTextureSize(256, 256);
        this.head1.mirror = true;
        this.setRotation(this.head1, 0.0f, 0.0f, 0.1396263f);
        (this.head2 = new ModelRenderer((ModelBase) this, 10, 150)).addBox(-2.0f, 0.0f, 0.0f, 2, 6, 1);
        this.head2.setRotationPoint(0.0f, -16.0f, -30.0f);
        this.head2.setTextureSize(256, 256);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0f, 0.0f, -0.1745329f);
        (this.leye = new ModelRenderer((ModelBase) this, 20, 150)).addBox(1.0f, 0.0f, -0.5f, 2, 2, 1);
        this.leye.setRotationPoint(0.0f, -16.0f, -30.0f);
        this.leye.setTextureSize(256, 256);
        this.leye.mirror = true;
        this.setRotation(this.leye, 0.0f, 0.0f, 0.1396263f);
        (this.reye = new ModelRenderer((ModelBase) this, 30, 150)).addBox(-3.0f, 0.0f, -0.5f, 2, 2, 1);
        this.reye.setRotationPoint(0.0f, -16.0f, -30.0f);
        this.reye.setTextureSize(256, 256);
        this.reye.mirror = true;
        this.setRotation(this.reye, 0.0f, 0.0f, -0.1745329f);
        (this.lantenna = new ModelRenderer((ModelBase) this, 53, 150)).addBox(0.0f, -20.0f, 0.0f, 1, 20, 1);
        this.lantenna.setRotationPoint(0.0f, -16.0f, -30.0f);
        this.lantenna.setTextureSize(256, 256);
        this.lantenna.mirror = true;
        this.setRotation(this.lantenna, 0.0f, 0.0f, 0.2792527f);
        (this.rantenna = new ModelRenderer((ModelBase) this, 60, 150)).addBox(-1.0f, -20.0f, 0.0f, 1, 20, 1);
        this.rantenna.setRotationPoint(0.0f, -16.0f, -30.0f);
        this.rantenna.setTextureSize(256, 256);
        this.rantenna.mirror = true;
        this.setRotation(this.rantenna, 0.0f, 0.0f, -0.2792527f);
        (this.larm1 = new ModelRenderer((ModelBase) this, 51, 0)).addBox(0.0f, 0.0f, -1.0f, 1, 23, 4);
        this.larm1.setRotationPoint(2.0f, -14.0f, -23.0f);
        this.larm1.setTextureSize(256, 256);
        this.larm1.mirror = true;
        this.setRotation(this.larm1, 0.0349066f, 0.0f, 0.0f);
        (this.larm2 = new ModelRenderer((ModelBase) this, 30, 0)).addBox(0.0f, -18.0f, -2.0f, 1, 18, 2);
        this.larm2.setRotationPoint(2.0f, 8.0f, -22.0f);
        this.larm2.setTextureSize(256, 256);
        this.larm2.mirror = true;
        this.setRotation(this.larm2, 0.5585054f, 0.0f, 0.0f);
        (this.larm3 = new ModelRenderer((ModelBase) this, 16, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 21, 1);
        this.larm3.setRotationPoint(2.0f, -7.0f, -33.0f);
        this.larm3.setTextureSize(256, 256);
        this.larm3.mirror = true;
        this.setRotation(this.larm3, 0.0f, 0.0f, 0.0f);
        (this.lfwing = new ModelRenderer((ModelBase) this, 0, 67)).addBox(0.0f, 0.0f, 0.0f, 48, 1, 12);
        this.lfwing.setRotationPoint(2.0f, -11.0f, 0.0f);
        this.lfwing.setTextureSize(256, 256);
        this.lfwing.mirror = true;
        this.setRotation(this.lfwing, -0.2268928f, 0.0f, -0.6981317f);
        (this.rfwing = new ModelRenderer((ModelBase) this, 0, 83)).addBox(-48.0f, 0.0f, 0.0f, 48, 1, 12);
        this.rfwing.setRotationPoint(-1.0f, -11.0f, 0.0f);
        this.rfwing.setTextureSize(256, 256);
        this.rfwing.mirror = true;
        this.setRotation(this.rfwing, -0.2268928f, 0.0f, 0.6981317f);
        (this.lrwing = new ModelRenderer((ModelBase) this, 0, 100)).addBox(0.0f, 0.0f, 0.0f, 42, 1, 17);
        this.lrwing.setRotationPoint(2.0f, -6.0f, 10.0f);
        this.lrwing.setTextureSize(256, 256);
        this.lrwing.mirror = true;
        this.setRotation(this.lrwing, -0.2268928f, 0.0f, -0.3490659f);
        (this.rrwing = new ModelRenderer((ModelBase) this, 0, 122)).addBox(-42.0f, 0.0f, 0.0f, 42, 1, 17);
        this.rrwing.setRotationPoint(-1.0f, -6.0f, 10.0f);
        this.rrwing.setTextureSize(256, 256);
        this.rrwing.mirror = true;
        this.setRotation(this.rrwing, -0.2268928f, 0.0f, 0.3490659f);
        (this.rarm1 = new ModelRenderer((ModelBase) this, 38, 0)).addBox(0.0f, 0.0f, -1.0f, 1, 23, 4);
        this.rarm1.setRotationPoint(-1.0f, -14.0f, -23.0f);
        this.rarm1.setTextureSize(256, 256);
        this.rarm1.mirror = true;
        this.setRotation(this.rarm1, 0.0349066f, 0.0f, 0.0f);
        (this.rarm2 = new ModelRenderer((ModelBase) this, 22, 0)).addBox(0.0f, -18.0f, -2.0f, 1, 18, 2);
        this.rarm2.setRotationPoint(-1.0f, 8.0f, -22.0f);
        this.rarm2.setTextureSize(256, 256);
        this.rarm2.mirror = true;
        this.setRotation(this.rarm2, 0.5585054f, 0.0f, 0.0f);
        (this.rarm3 = new ModelRenderer((ModelBase) this, 10, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 21, 1);
        this.rarm3.setRotationPoint(-1.0f, -7.0f, -33.0f);
        this.rarm3.setTextureSize(256, 256);
        this.rarm3.mirror = true;
        this.setRotation(this.rarm3, 0.0f, 0.0f, 0.0f);
        (this.rlfleg3 = new ModelRenderer((ModelBase) this, 64, 6)).addBox(-20.0f, 0.0f, 0.0f, 20, 1, 1);
        this.rlfleg3.setRotationPoint(-1.0f, -5.0f, 0.0f);
        this.rlfleg3.setTextureSize(256, 256);
        this.rlfleg3.mirror = true;
        this.setRotation(this.rlfleg3, 0.0f, -0.1570796f, 0.0f);
        (this.rfleg4 = new ModelRenderer((ModelBase) this, 64, 28)).addBox(-19.0f, 0.0f, -2.0f, 4, 1, 5);
        this.rfleg4.setRotationPoint(-1.0f, -5.0f, 0.0f);
        this.rfleg4.setTextureSize(256, 256);
        this.rfleg4.mirror = true;
        this.setRotation(this.rfleg4, 0.0f, -0.1570796f, 0.0f);
        (this.rfleg2 = new ModelRenderer((ModelBase) this, 7, 32)).addBox(0.0f, 0.0f, 0.0f, 1, 22, 1);
        this.rfleg2.setRotationPoint(-21.0f, -5.0f, -3.0f);
        this.rfleg2.setTextureSize(256, 256);
        this.rfleg2.mirror = true;
        this.setRotation(this.rfleg2, 0.0f, 0.0f, 0.2792527f);
        (this.rfleg1 = new ModelRenderer((ModelBase) this, 42, 35)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.rfleg1.setRotationPoint(-27.0f, 16.0f, -3.0f);
        this.rfleg1.setTextureSize(256, 256);
        this.rfleg1.mirror = true;
        this.setRotation(this.rfleg1, 0.0f, 0.0f, 0.6283185f);
        (this.rrleg3 = new ModelRenderer((ModelBase) this, 64, 16)).addBox(-20.0f, 0.0f, 0.0f, 20, 1, 1);
        this.rrleg3.setRotationPoint(-1.0f, 0.0f, 8.0f);
        this.rrleg3.setTextureSize(256, 256);
        this.rrleg3.mirror = true;
        this.setRotation(this.rrleg3, 0.0f, 0.1570796f, 0.0f);
        (this.rrleg4 = new ModelRenderer((ModelBase) this, 64, 44)).addBox(-19.0f, 0.0f, -2.0f, 4, 1, 5);
        this.rrleg4.setRotationPoint(-1.0f, 0.0f, 8.0f);
        this.rrleg4.setTextureSize(256, 256);
        this.rrleg4.mirror = true;
        this.setRotation(this.rrleg4, 0.0f, 0.1570796f, 0.0f);
        (this.rrleg2 = new ModelRenderer((ModelBase) this, 21, 32)).addBox(0.0f, 0.0f, 0.0f, 1, 22, 1);
        this.rrleg2.setRotationPoint(-21.0f, 0.0f, 11.0f);
        this.rrleg2.setTextureSize(256, 256);
        this.rrleg2.mirror = true;
        this.setRotation(this.rrleg2, 0.0f, 0.0f, 0.5410521f);
        (this.rrleg1 = new ModelRenderer((ModelBase) this, 49, 35)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.rrleg1.setRotationPoint(-32.0f, 18.0f, 11.0f);
        this.rrleg1.setTextureSize(256, 256);
        this.rrleg1.mirror = true;
        this.setRotation(this.rrleg1, 0.0f, 0.0f, 0.8726646f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        final Mantis b = (Mantis) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 0.9f * this.wingspeed) * 3.1415927f * 0.25f;
        this.lfwing.rotateAngleZ = -0.698f - newangle;
        this.rfwing.rotateAngleZ = 0.698f + newangle;
        newangle = MathHelper.cos(f2 * 0.9f * this.wingspeed) * 3.1415927f * 0.35f;
        this.lrwing.rotateAngleZ = -0.349f + newangle;
        this.rrwing.rotateAngleZ = 0.349f - newangle;
        float a1;
        if (b.getAttacking() == 0) {
            newangle = MathHelper.cos(f2 * 0.051f * this.wingspeed) * 3.1415927f * 0.013f;
            a1 = -0.2f;
        } else {
            newangle = MathHelper.cos(f2 * 0.51f * this.wingspeed) * 3.1415927f * 0.25f;
            a1 = -0.698f;
        }
        this.larm1.rotateAngleX = a1 + newangle;
        this.larm2.rotationPointZ = (float) (this.larm1.rotationPointZ + 1.0f
            + Math.sin(this.larm1.rotateAngleX) * 22.0);
        this.larm2.rotationPointY = (float) (this.larm1.rotationPointY + Math.cos(this.larm1.rotateAngleX) * 22.0);
        this.larm2.rotateAngleX = -a1 - newangle;
        this.larm3.rotationPointZ = (float) (this.larm2.rotationPointZ + 1.0f
            - Math.sin(this.larm2.rotateAngleX) * 17.0);
        this.larm3.rotationPointY = (float) (this.larm2.rotationPointY - Math.cos(this.larm2.rotateAngleX) * 17.0);
        this.larm3.rotateAngleX = a1 + newangle;
        this.rarm1.rotateAngleX = a1 - newangle;
        this.rarm2.rotationPointZ = (float) (this.rarm1.rotationPointZ + 1.0f
            + Math.sin(this.rarm1.rotateAngleX) * 22.0);
        this.rarm2.rotationPointY = (float) (this.rarm1.rotationPointY + Math.cos(this.rarm1.rotateAngleX) * 22.0);
        this.rarm2.rotateAngleX = -a1 + newangle;
        this.rarm3.rotationPointZ = (float) (this.rarm2.rotationPointZ + 1.0f
            - Math.sin(this.rarm2.rotateAngleX) * 17.0);
        this.rarm3.rotationPointY = (float) (this.rarm2.rotationPointY - Math.cos(this.rarm2.rotateAngleX) * 17.0);
        this.rarm3.rotateAngleX = a1 - newangle;
        this.lfleg1.render(f5);
        this.lfleg2.render(f5);
        this.lfleg3.render(f5);
        this.lfleg4.render(f5);
        this.lrleg1.render(f5);
        this.lrleg2.render(f5);
        this.lrleg3.render(f5);
        this.lrleg4.render(f5);
        this.abdomen.render(f5);
        this.thorax.render(f5);
        this.neck1.render(f5);
        this.neck2.render(f5);
        this.head1.render(f5);
        this.head2.render(f5);
        this.leye.render(f5);
        this.reye.render(f5);
        this.lantenna.render(f5);
        this.rantenna.render(f5);
        this.larm1.render(f5);
        this.larm2.render(f5);
        this.larm3.render(f5);
        this.lfwing.render(f5);
        this.rfwing.render(f5);
        this.lrwing.render(f5);
        this.rrwing.render(f5);
        this.rarm1.render(f5);
        this.rarm2.render(f5);
        this.rarm3.render(f5);
        this.rlfleg3.render(f5);
        this.rfleg4.render(f5);
        this.rfleg2.render(f5);
        this.rfleg1.render(f5);
        this.rrleg3.render(f5);
        this.rrleg4.render(f5);
        this.rrleg2.render(f5);
        this.rrleg1.render(f5);
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
