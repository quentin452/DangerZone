
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.HerculesBeetle;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelHerculesBeetle extends ModelBase {

    private float wingspeed;
    ModelRenderer body1;
    ModelRenderer body2;
    ModelRenderer head1;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head4;
    ModelRenderer head5;
    ModelRenderer head6;
    ModelRenderer head8;
    ModelRenderer jaw1;
    ModelRenderer jaw2;
    ModelRenderer jaw3;
    ModelRenderer jaw4;
    ModelRenderer head7;
    ModelRenderer lfleg1;
    ModelRenderer lfleg2;
    ModelRenderer lfleg3;
    ModelRenderer lmleg1;
    ModelRenderer lmleg2;
    ModelRenderer lmleg3;
    ModelRenderer lrleg1;
    ModelRenderer lrleg2;
    ModelRenderer lrleg3;
    ModelRenderer jaw5;
    ModelRenderer jaw6;
    ModelRenderer jaw7;
    ModelRenderer jaw8;
    ModelRenderer rfleg1;
    ModelRenderer rfleg2;
    ModelRenderer rfleg3;
    ModelRenderer rmleg1;
    ModelRenderer rmleg2;
    ModelRenderer rmleg3;
    ModelRenderer rrleg1;
    ModelRenderer rrleg2;
    ModelRenderer rrleg3;
    ModelRenderer jaw9;

    public ModelHerculesBeetle(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.body1 = new ModelRenderer((ModelBase) this, 0, 30)).addBox(-8.0f, 0.0f, 0.0f, 16, 16, 23);
        this.body1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body1.setTextureSize(256, 256);
        this.body1.mirror = true;
        this.setRotation(this.body1, 0.0f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 80, 41)).addBox(-6.0f, 0.0f, 0.0f, 12, 12, 4);
        this.body2.setRotationPoint(0.0f, 3.0f, 23.0f);
        this.body2.setTextureSize(256, 256);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.0f, 0.0f, 0.0f);
        (this.head1 = new ModelRenderer((ModelBase) this, 0, 71)).addBox(-9.0f, 0.0f, 0.0f, 18, 16, 12);
        this.head1.setRotationPoint(0.0f, -1.0f, -10.0f);
        this.head1.setTextureSize(256, 256);
        this.head1.mirror = true;
        this.setRotation(this.head1, -0.122173f, 0.0f, 0.0f);
        (this.head2 = new ModelRenderer((ModelBase) this, 0, 100)).addBox(-7.0f, 0.0f, 0.0f, 14, 10, 6);
        this.head2.setRotationPoint(0.0f, -2.0f, -16.0f);
        this.head2.setTextureSize(256, 256);
        this.head2.mirror = true;
        this.setRotation(this.head2, -0.122173f, 0.0f, 0.0f);
        (this.head3 = new ModelRenderer((ModelBase) this, 0, 117)).addBox(-5.0f, 0.0f, 0.0f, 10, 6, 9);
        this.head3.setRotationPoint(0.0f, -3.0f, -25.0f);
        this.head3.setTextureSize(256, 256);
        this.head3.mirror = true;
        this.setRotation(this.head3, -0.122173f, 0.0f, 0.0f);
        (this.head4 = new ModelRenderer((ModelBase) this, 0, 133)).addBox(-4.0f, 0.0f, 0.0f, 8, 4, 12);
        this.head4.setRotationPoint(0.0f, -4.0f, -37.0f);
        this.head4.setTextureSize(256, 256);
        this.head4.mirror = true;
        this.setRotation(this.head4, -0.122173f, 0.0f, 0.0f);
        (this.head5 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(-3.0f, 0.0f, 0.0f, 6, 3, 21);
        this.head5.setRotationPoint(0.0f, -4.0f, -58.0f);
        this.head5.setTextureSize(256, 256);
        this.head5.mirror = true;
        this.setRotation(this.head5, 0.0f, 0.0f, 0.0f);
        (this.head6 = new ModelRenderer((ModelBase) this, 0, 175)).addBox(-2.0f, 0.0f, 0.0f, 4, 2, 14);
        this.head6.setRotationPoint(0.0f, -2.0f, -72.0f);
        this.head6.setTextureSize(256, 256);
        this.head6.mirror = true;
        this.setRotation(this.head6, 0.122173f, 0.0f, 0.0f);
        (this.head8 = new ModelRenderer((ModelBase) this, 6, 193)).addBox(0.0f, 0.0f, 0.0f, 1, 3, 1);
        this.head8.setRotationPoint(0.0f, -2.0f, -46.0f);
        this.head8.setTextureSize(256, 256);
        this.head8.mirror = true;
        this.setRotation(this.head8, -0.2094395f, 0.0f, 0.0f);
        (this.jaw1 = new ModelRenderer((ModelBase) this, 114, 0)).addBox(-3.0f, -3.0f, -4.0f, 6, 7, 5);
        this.jaw1.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw1.setTextureSize(256, 256);
        this.jaw1.mirror = true;
        this.setRotation(this.jaw1, 0.122173f, 0.0f, 0.0f);
        (this.jaw2 = new ModelRenderer((ModelBase) this, 115, 14)).addBox(-2.5f, -3.0f, -27.0f, 5, 5, 23);
        this.jaw2.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw2.setTextureSize(256, 256);
        this.jaw2.mirror = true;
        this.setRotation(this.jaw2, 0.122173f, 0.0f, 0.0f);
        (this.jaw3 = new ModelRenderer((ModelBase) this, 115, 43)).addBox(-1.5f, 0.0f, -44.0f, 3, 5, 18);
        this.jaw3.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw3.setTextureSize(256, 256);
        this.jaw3.mirror = true;
        this.setRotation(this.jaw3, 0.0f, 0.0f, 0.0f);
        (this.jaw4 = new ModelRenderer((ModelBase) this, 115, 70)).addBox(-0.5f, -2.0f, -45.0f, 1, 5, 1);
        this.jaw4.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw4.setTextureSize(256, 256);
        this.jaw4.mirror = true;
        this.setRotation(this.jaw4, 0.0f, 0.0f, 0.0f);
        (this.head7 = new ModelRenderer((ModelBase) this, 0, 193)).addBox(-0.5f, 0.0f, 0.0f, 1, 4, 1);
        this.head7.setRotationPoint(0.0f, -2.0f, -73.0f);
        this.head7.setTextureSize(256, 256);
        this.head7.mirror = true;
        this.setRotation(this.head7, 0.122173f, 0.0f, 0.0f);
        (this.lfleg1 = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, -0.5f, 10, 3, 3);
        this.lfleg1.setRotationPoint(6.0f, 15.0f, -5.0f);
        this.lfleg1.setTextureSize(256, 256);
        this.lfleg1.mirror = true;
        this.setRotation(this.lfleg1, 0.0f, 0.3490659f, 0.0872665f);
        (this.lfleg2 = new ModelRenderer((ModelBase) this, 60, 8)).addBox(10.0f, -1.0f, 0.0f, 11, 2, 2);
        this.lfleg2.setRotationPoint(6.0f, 15.0f, -5.0f);
        this.lfleg2.setTextureSize(256, 256);
        this.lfleg2.mirror = true;
        this.setRotation(this.lfleg2, 0.0f, 0.3490659f, 0.2617994f);
        (this.lfleg3 = new ModelRenderer((ModelBase) this, 60, 14)).addBox(21.0f, -2.0f, 0.5f, 10, 1, 1);
        this.lfleg3.setRotationPoint(6.0f, 15.0f, -5.0f);
        this.lfleg3.setTextureSize(256, 256);
        this.lfleg3.mirror = true;
        this.setRotation(this.lfleg3, 0.0f, 0.3490659f, 0.3490659f);
        (this.lmleg1 = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, -0.5f, 10, 3, 3);
        this.lmleg1.setRotationPoint(6.0f, 15.0f, 0.0f);
        this.lmleg1.setTextureSize(256, 256);
        this.lmleg1.mirror = true;
        this.setRotation(this.lmleg1, 0.0f, 0.0f, 0.0872665f);
        (this.lmleg2 = new ModelRenderer((ModelBase) this, 60, 8)).addBox(10.0f, -1.0f, 0.0f, 11, 2, 2);
        this.lmleg2.setRotationPoint(6.0f, 15.0f, 0.0f);
        this.lmleg2.setTextureSize(256, 256);
        this.lmleg2.mirror = true;
        this.setRotation(this.lmleg2, 0.0f, 0.0f, 0.2617994f);
        (this.lmleg3 = new ModelRenderer((ModelBase) this, 60, 14)).addBox(21.0f, -2.0f, 0.5f, 10, 1, 1);
        this.lmleg3.setRotationPoint(6.0f, 15.0f, 0.0f);
        this.lmleg3.setTextureSize(256, 256);
        this.lmleg3.mirror = true;
        this.setRotation(this.lmleg3, 0.0f, 0.0f, 0.3490659f);
        (this.lrleg1 = new ModelRenderer((ModelBase) this, 60, 0)).addBox(0.0f, 0.0f, -0.5f, 10, 3, 3);
        this.lrleg1.setRotationPoint(6.0f, 15.0f, 5.0f);
        this.lrleg1.setTextureSize(256, 256);
        this.lrleg1.mirror = true;
        this.setRotation(this.lrleg1, 0.0f, -0.3490659f, 0.0872665f);
        (this.lrleg2 = new ModelRenderer((ModelBase) this, 60, 8)).addBox(10.0f, -1.0f, 0.0f, 11, 2, 2);
        this.lrleg2.setRotationPoint(6.0f, 15.0f, 5.0f);
        this.lrleg2.setTextureSize(256, 256);
        this.lrleg2.mirror = true;
        this.setRotation(this.lrleg2, 0.0f, -0.3490659f, 0.2617994f);
        (this.lrleg3 = new ModelRenderer((ModelBase) this, 60, 14)).addBox(21.0f, -2.0f, 0.5f, 10, 1, 1);
        this.lrleg3.setRotationPoint(6.0f, 15.0f, 5.0f);
        this.lrleg3.setTextureSize(256, 256);
        this.lrleg3.mirror = true;
        this.setRotation(this.lrleg3, 0.0f, -0.3490659f, 0.3490659f);
        (this.jaw5 = new ModelRenderer((ModelBase) this, 115, 78)).addBox(2.0f, -2.0f, -9.0f, 2, 3, 3);
        this.jaw5.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw5.setTextureSize(256, 256);
        this.jaw5.mirror = true;
        this.setRotation(this.jaw5, 0.122173f, 0.0f, 0.0f);
        (this.jaw6 = new ModelRenderer((ModelBase) this, 127, 78)).addBox(-4.0f, -2.0f, -9.0f, 2, 3, 3);
        this.jaw6.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw6.setTextureSize(256, 256);
        this.jaw6.mirror = true;
        this.setRotation(this.jaw6, 0.122173f, 0.0f, 0.0f);
        (this.jaw7 = new ModelRenderer((ModelBase) this, 115, 86)).addBox(5.0f, 1.0f, -6.0f, 9, 1, 1);
        this.jaw7.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw7.setTextureSize(256, 256);
        this.jaw7.mirror = true;
        this.setRotation(this.jaw7, 0.0f, 0.5585054f, 0.2268928f);
        (this.jaw8 = new ModelRenderer((ModelBase) this, 115, 89)).addBox(-14.0f, 1.0f, -6.0f, 9, 1, 1);
        this.jaw8.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw8.setTextureSize(256, 256);
        this.jaw8.mirror = true;
        this.setRotation(this.jaw8, 0.0f, -0.5585054f, -0.2268928f);
        (this.rfleg1 = new ModelRenderer((ModelBase) this, 30, 0)).addBox(-10.0f, 0.0f, -0.5f, 10, 3, 3);
        this.rfleg1.setRotationPoint(-6.0f, 15.0f, -5.0f);
        this.rfleg1.setTextureSize(256, 256);
        this.rfleg1.mirror = true;
        this.setRotation(this.rfleg1, 0.0f, -0.3490659f, -0.0872665f);
        (this.rfleg2 = new ModelRenderer((ModelBase) this, 30, 8)).addBox(-21.0f, -1.0f, 0.0f, 11, 2, 2);
        this.rfleg2.setRotationPoint(-6.0f, 15.0f, -5.0f);
        this.rfleg2.setTextureSize(256, 256);
        this.rfleg2.mirror = true;
        this.setRotation(this.rfleg2, 0.0f, -0.3490659f, -0.2617994f);
        (this.rfleg3 = new ModelRenderer((ModelBase) this, 30, 14)).addBox(-31.0f, -2.0f, 0.5f, 10, 1, 1);
        this.rfleg3.setRotationPoint(-6.0f, 15.0f, -5.0f);
        this.rfleg3.setTextureSize(256, 256);
        this.rfleg3.mirror = true;
        this.setRotation(this.rfleg3, 0.0f, -0.3490659f, -0.3490659f);
        (this.rmleg1 = new ModelRenderer((ModelBase) this, 30, 0)).addBox(-10.0f, 0.0f, -0.5f, 10, 3, 3);
        this.rmleg1.setRotationPoint(-6.0f, 15.0f, 0.0f);
        this.rmleg1.setTextureSize(256, 256);
        this.rmleg1.mirror = true;
        this.setRotation(this.rmleg1, 0.0f, 0.0f, -0.0872665f);
        (this.rmleg2 = new ModelRenderer((ModelBase) this, 30, 8)).addBox(-21.0f, -1.0f, 0.0f, 11, 2, 2);
        this.rmleg2.setRotationPoint(-6.0f, 15.0f, 0.0f);
        this.rmleg2.setTextureSize(256, 256);
        this.rmleg2.mirror = true;
        this.setRotation(this.rmleg2, 0.0f, 0.0f, -0.2617994f);
        (this.rmleg3 = new ModelRenderer((ModelBase) this, 30, 14)).addBox(-31.0f, -2.0f, 0.5f, 10, 1, 1);
        this.rmleg3.setRotationPoint(-6.0f, 15.0f, 0.0f);
        this.rmleg3.setTextureSize(256, 256);
        this.rmleg3.mirror = true;
        this.setRotation(this.rmleg3, 0.0f, 0.0f, -0.3490659f);
        (this.rrleg1 = new ModelRenderer((ModelBase) this, 30, 0)).addBox(-10.0f, 0.0f, -0.5f, 10, 3, 3);
        this.rrleg1.setRotationPoint(-6.0f, 15.0f, 5.0f);
        this.rrleg1.setTextureSize(256, 256);
        this.rrleg1.mirror = true;
        this.setRotation(this.rrleg1, 0.0f, 0.3490659f, -0.0872665f);
        (this.rrleg2 = new ModelRenderer((ModelBase) this, 30, 8)).addBox(-21.0f, -1.0f, 0.0f, 11, 2, 2);
        this.rrleg2.setRotationPoint(-6.0f, 15.0f, 5.0f);
        this.rrleg2.setTextureSize(256, 256);
        this.rrleg2.mirror = true;
        this.setRotation(this.rrleg2, 0.0f, 0.3490659f, -0.2617994f);
        (this.rrleg3 = new ModelRenderer((ModelBase) this, 30, 14)).addBox(-31.0f, -2.0f, 0.5f, 10, 1, 1);
        this.rrleg3.setRotationPoint(-6.0f, 15.0f, 5.0f);
        this.rrleg3.setTextureSize(256, 256);
        this.rrleg3.mirror = true;
        this.setRotation(this.rrleg3, 0.0f, 0.3490659f, -0.3490659f);
        (this.jaw9 = new ModelRenderer((ModelBase) this, 121, 70)).addBox(-0.5f, -12.0f, -25.0f, 1, 5, 1);
        this.jaw9.setRotationPoint(0.0f, 12.0f, -12.0f);
        this.jaw9.setTextureSize(256, 256);
        this.jaw9.mirror = true;
        this.setRotation(this.jaw9, 0.3141593f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        float newangle = 0.0f;
        final HerculesBeetle b = (HerculesBeetle) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * this.wingspeed * 0.45f) * 3.1415927f * 0.12f * f1;
        this.lfleg1.rotateAngleY = 0.349f + newangle;
        final ModelRenderer lfleg3 = this.lfleg3;
        final ModelRenderer lfleg4 = this.lfleg2;
        final float rotateAngleY = this.lfleg1.rotateAngleY;
        lfleg4.rotateAngleY = rotateAngleY;
        lfleg3.rotateAngleY = rotateAngleY;
        this.lmleg1.rotateAngleY = -newangle;
        final ModelRenderer lmleg3 = this.lmleg3;
        final ModelRenderer lmleg4 = this.lmleg2;
        final float rotateAngleY2 = this.lmleg1.rotateAngleY;
        lmleg4.rotateAngleY = rotateAngleY2;
        lmleg3.rotateAngleY = rotateAngleY2;
        this.lrleg1.rotateAngleY = -0.349f + newangle;
        final ModelRenderer lrleg3 = this.lrleg3;
        final ModelRenderer lrleg4 = this.lrleg2;
        final float rotateAngleY3 = this.lrleg1.rotateAngleY;
        lrleg4.rotateAngleY = rotateAngleY3;
        lrleg3.rotateAngleY = rotateAngleY3;
        this.rfleg1.rotateAngleY = -0.349f + newangle;
        final ModelRenderer rfleg3 = this.rfleg3;
        final ModelRenderer rfleg4 = this.rfleg2;
        final float rotateAngleY4 = this.rfleg1.rotateAngleY;
        rfleg4.rotateAngleY = rotateAngleY4;
        rfleg3.rotateAngleY = rotateAngleY4;
        this.rmleg1.rotateAngleY = -newangle;
        final ModelRenderer rmleg3 = this.rmleg3;
        final ModelRenderer rmleg4 = this.rmleg2;
        final float rotateAngleY5 = this.rmleg1.rotateAngleY;
        rmleg4.rotateAngleY = rotateAngleY5;
        rmleg3.rotateAngleY = rotateAngleY5;
        this.rrleg1.rotateAngleY = 0.349f + newangle;
        final ModelRenderer rrleg3 = this.rrleg3;
        final ModelRenderer rrleg4 = this.rrleg2;
        final float rotateAngleY6 = this.rrleg1.rotateAngleY;
        rrleg4.rotateAngleY = rotateAngleY6;
        rrleg3.rotateAngleY = rotateAngleY6;
        if (b.getAttacking() == 0) {
            newangle = MathHelper.cos(f2 * 0.051f * this.wingspeed) * 3.1415927f * 0.01f;
        } else {
            newangle = MathHelper.cos(f2 * 0.51f * this.wingspeed) * 3.1415927f * 0.07f;
        }
        this.jaw1.rotateAngleX = 0.122f + newangle;
        this.jaw2.rotateAngleX = 0.122f + newangle;
        this.jaw3.rotateAngleX = 0.0f + newangle;
        this.jaw4.rotateAngleX = 0.0f + newangle;
        this.jaw5.rotateAngleX = 0.122f + newangle;
        this.jaw6.rotateAngleX = 0.122f + newangle;
        this.jaw7.rotateAngleX = 0.0f + newangle;
        this.jaw8.rotateAngleX = 0.0f + newangle;
        this.jaw9.rotateAngleX = 0.314f + newangle;
        this.body1.render(f5);
        this.body2.render(f5);
        this.head1.render(f5);
        this.head2.render(f5);
        this.head3.render(f5);
        this.head4.render(f5);
        this.head5.render(f5);
        this.head6.render(f5);
        this.head8.render(f5);
        this.jaw1.render(f5);
        this.jaw2.render(f5);
        this.jaw3.render(f5);
        this.jaw4.render(f5);
        this.head7.render(f5);
        this.lfleg1.render(f5);
        this.lfleg2.render(f5);
        this.lfleg3.render(f5);
        this.lmleg1.render(f5);
        this.lmleg2.render(f5);
        this.lmleg3.render(f5);
        this.lrleg1.render(f5);
        this.lrleg2.render(f5);
        this.lrleg3.render(f5);
        this.jaw5.render(f5);
        this.jaw6.render(f5);
        this.jaw7.render(f5);
        this.jaw8.render(f5);
        this.rfleg1.render(f5);
        this.rfleg2.render(f5);
        this.rfleg3.render(f5);
        this.rmleg1.render(f5);
        this.rmleg2.render(f5);
        this.rmleg3.render(f5);
        this.rrleg1.render(f5);
        this.rrleg2.render(f5);
        this.rrleg3.render(f5);
        this.jaw9.render(f5);
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
