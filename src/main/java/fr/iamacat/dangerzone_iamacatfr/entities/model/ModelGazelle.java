
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Gazelle;

public class ModelGazelle extends ModelBase {

    private float wingspeed;
    ModelRenderer Chest;
    ModelRenderer lfleg1;
    ModelRenderer lrleg2;
    ModelRenderer lrleg1;
    ModelRenderer rfleg3;
    ModelRenderer rrleg2;
    ModelRenderer rrleg3;
    ModelRenderer rfleg2;
    ModelRenderer lrleg4;
    ModelRenderer tail;
    ModelRenderer lear;
    ModelRenderer rrleg1;
    ModelRenderer rfleg1;
    ModelRenderer lrleg3;
    ModelRenderer lfleg2;
    ModelRenderer rrleg5;
    ModelRenderer rrleg4;
    ModelRenderer lfleg3;
    ModelRenderer rfleg4;
    ModelRenderer lfleg4;
    ModelRenderer lrleg5;
    ModelRenderer Body;
    ModelRenderer neck;
    ModelRenderer la3;
    ModelRenderer throatfluff;
    ModelRenderer rear;
    ModelRenderer head;
    ModelRenderer ra1;
    ModelRenderer la1;
    ModelRenderer la2;
    ModelRenderer ra2;
    ModelRenderer ra3;
    ModelRenderer nose;
    ModelRenderer mouth;

    public ModelGazelle(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.Chest = new ModelRenderer((ModelBase) this, 12, 57)).addBox(0.0f, 0.0f, 0.0f, 5, 2, 3);
        this.Chest.setRotationPoint(-2.5f, 8.0f, -6.0f);
        this.Chest.setTextureSize(64, 64);
        this.Chest.mirror = true;
        this.setRotation(this.Chest, 2.342252f, 0.0f, 0.0f);
        (this.lfleg1 = new ModelRenderer((ModelBase) this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 3);
        this.lfleg1.setRotationPoint(2.0f, 6.0f, -6.0f);
        this.lfleg1.setTextureSize(64, 64);
        this.lfleg1.mirror = true;
        this.setRotation(this.lfleg1, 0.2974289f, 0.0f, 0.0f);
        (this.lrleg2 = new ModelRenderer((ModelBase) this, 16, 49)).addBox(0.0f, 5.0f, -1.0f, 2, 2, 6);
        this.lrleg2.setRotationPoint(2.0f, 4.0f, 3.0f);
        this.lrleg2.setTextureSize(64, 64);
        this.lrleg2.mirror = true;
        this.setRotation(this.lrleg2, 0.1858931f, 0.0f, 0.0f);
        (this.lrleg1 = new ModelRenderer((ModelBase) this, 23, 31)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 3);
        this.lrleg1.setRotationPoint(2.0f, 4.0f, 3.0f);
        this.lrleg1.setTextureSize(64, 64);
        this.lrleg1.mirror = true;
        this.setRotation(this.lrleg1, 0.0f, 0.0f, 0.0f);
        (this.rfleg3 = new ModelRenderer((ModelBase) this, 40, 49)).addBox(0.0f, 10.0f, 6.0f, 2, 6, 2);
        this.rfleg3.setRotationPoint(-4.0f, 5.966667f, -6.0f);
        this.rfleg3.setTextureSize(64, 64);
        this.rfleg3.mirror = true;
        this.setRotation(this.rfleg3, -0.4089647f, 0.0f, 0.0f);
        (this.rrleg2 = new ModelRenderer((ModelBase) this, 16, 49)).addBox(0.0f, 5.0f, -1.0f, 2, 2, 6);
        this.rrleg2.setRotationPoint(-4.0f, 4.0f, 3.0f);
        this.rrleg2.setTextureSize(64, 64);
        this.rrleg2.mirror = true;
        this.setRotation(this.rrleg2, 0.1858931f, 0.0f, 0.0f);
        (this.rrleg3 = new ModelRenderer((ModelBase) this, 32, 11)).addBox(0.0f, 4.0f, 5.0f, 2, 12, 2);
        this.rrleg3.setRotationPoint(-4.0f, 3.966667f, 3.0f);
        this.rrleg3.setTextureSize(64, 64);
        this.rrleg3.mirror = true;
        this.setRotation(this.rrleg3, -0.0743572f, 0.0f, 0.0f);
        (this.rfleg2 = new ModelRenderer((ModelBase) this, 24, 11)).addBox(0.0f, 2.0f, 2.0f, 2, 12, 2);
        this.rfleg2.setRotationPoint(-4.0f, 5.966667f, -6.0f);
        this.rfleg2.setTextureSize(64, 64);
        this.rfleg2.mirror = true;
        this.setRotation(this.rfleg2, -0.0743572f, 0.0f, 0.0f);
        (this.lrleg4 = new ModelRenderer((ModelBase) this, 32, 49)).addBox(0.0f, 11.0f, 9.5f, 2, 6, 2);
        this.lrleg4.setRotationPoint(2.0f, 4.0f, 3.0f);
        this.lrleg4.setTextureSize(64, 64);
        this.lrleg4.mirror = true;
        this.setRotation(this.lrleg4, -0.4089647f, 0.0f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase) this, 0, 49)).addBox(0.0f, 0.0f, 0.0f, 4, 4, 4);
        this.tail.setRotationPoint(-2.0f, 0.0f, 4.0f);
        this.tail.setTextureSize(64, 64);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.9666439f, 0.0f, 0.0f);
        (this.lear = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-5.0f, -3.0f, 2.0f, 3, 2, 1);
        this.lear.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.lear.setTextureSize(64, 64);
        this.lear.mirror = true;
        this.setRotation(this.lear, -0.1047198f, 1.570796f, 0.0f);
        (this.rrleg1 = new ModelRenderer((ModelBase) this, 23, 31)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 3);
        this.rrleg1.setRotationPoint(-4.0f, 4.0f, 3.0f);
        this.rrleg1.setTextureSize(64, 64);
        this.rrleg1.mirror = true;
        this.setRotation(this.rrleg1, 0.0f, 0.0f, 0.0f);
        (this.rfleg1 = new ModelRenderer((ModelBase) this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 2, 6, 3);
        this.rfleg1.setRotationPoint(-4.0f, 6.0f, -6.0f);
        this.rfleg1.setTextureSize(64, 64);
        this.rfleg1.mirror = true;
        this.setRotation(this.rfleg1, 0.2974289f, 0.0f, 0.0f);
        (this.lrleg3 = new ModelRenderer((ModelBase) this, 32, 11)).addBox(0.0f, 4.0f, 5.0f, 2, 12, 2);
        this.lrleg3.setRotationPoint(2.0f, 3.966667f, 3.0f);
        this.lrleg3.setTextureSize(64, 64);
        this.lrleg3.mirror = true;
        this.setRotation(this.lrleg3, -0.0743572f, 0.0f, 0.0f);
        (this.lfleg2 = new ModelRenderer((ModelBase) this, 24, 11)).addBox(0.0f, 2.0f, 2.0f, 2, 12, 2);
        this.lfleg2.setRotationPoint(2.0f, 5.966667f, -6.0f);
        this.lfleg2.setTextureSize(64, 64);
        this.lfleg2.mirror = true;
        this.setRotation(this.lfleg2, -0.0743572f, 0.0f, 0.0f);
        (this.rrleg5 = new ModelRenderer((ModelBase) this, 0, 58)).addBox(-0.5f, 17.0f, 2.0f, 3, 3, 3);
        this.rrleg5.setRotationPoint(-4.0f, 4.0f, 3.0f);
        this.rrleg5.setTextureSize(64, 64);
        this.rrleg5.mirror = true;
        this.setRotation(this.rrleg5, 0.0f, 0.0f, 0.0f);
        this.rrleg5.mirror = false;
        (this.rrleg4 = new ModelRenderer((ModelBase) this, 32, 49)).addBox(0.0f, 11.0f, 9.5f, 2, 6, 2);
        this.rrleg4.setRotationPoint(-4.0f, 3.966667f, 3.0f);
        this.rrleg4.setTextureSize(64, 64);
        this.rrleg4.mirror = true;
        this.setRotation(this.rrleg4, -0.4089647f, 0.0f, 0.0f);
        (this.lfleg3 = new ModelRenderer((ModelBase) this, 40, 49)).addBox(0.0f, 10.0f, 6.0f, 2, 6, 2);
        this.lfleg3.setRotationPoint(2.0f, 5.966667f, -6.0f);
        this.lfleg3.setTextureSize(64, 64);
        this.lfleg3.mirror = true;
        this.setRotation(this.lfleg3, -0.4089647f, 0.0f, 0.0f);
        (this.rfleg4 = new ModelRenderer((ModelBase) this, 0, 58)).addBox(-0.5f, 15.0f, -1.0f, 3, 3, 3);
        this.rfleg4.setRotationPoint(-4.0f, 6.0f, -6.0f);
        this.rfleg4.setTextureSize(64, 64);
        this.rfleg4.mirror = true;
        this.setRotation(this.rfleg4, 0.0f, 0.0f, 0.0f);
        (this.lfleg4 = new ModelRenderer((ModelBase) this, 0, 58)).addBox(-0.5f, 15.0f, -1.0f, 3, 3, 3);
        this.lfleg4.setRotationPoint(2.0f, 6.0f, -6.0f);
        this.lfleg4.setTextureSize(64, 64);
        this.lfleg4.mirror = true;
        this.setRotation(this.lfleg4, 0.0f, 0.0f, 0.0f);
        (this.lrleg5 = new ModelRenderer((ModelBase) this, 0, 58)).addBox(-0.5f, 17.0f, 2.0f, 3, 3, 3);
        this.lrleg5.setRotationPoint(2.0f, 4.0f, 3.0f);
        this.lrleg5.setTextureSize(64, 64);
        this.lrleg5.mirror = true;
        this.setRotation(this.lrleg5, 0.0f, 0.0f, 0.0f);
        (this.Body = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.0f, 0.0f, 0.0f, 6, 6, 13);
        this.Body.setRotationPoint(-3.0f, 2.0f, -7.0f);
        this.Body.setTextureSize(64, 64);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.2230717f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase) this, 0, 31)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 13);
        this.neck.setRotationPoint(-2.5f, 6.0f, -8.0f);
        this.neck.setTextureSize(64, 64);
        this.neck.mirror = true;
        this.setRotation(this.neck, 1.524323f, 0.0f, 0.0f);
        (this.la3 = new ModelRenderer((ModelBase) this, 4, 12)).addBox(0.5f, -12.5f, 3.0f, 1, 5, 1);
        this.la3.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.la3.setTextureSize(64, 64);
        this.la3.mirror = true;
        this.setRotation(this.la3, -0.3346075f, 0.0f, 0.0f);
        (this.throatfluff = new ModelRenderer((ModelBase) this, 36, 41)).addBox(0.0f, -2.0f, 0.0f, 4, 3, 5);
        this.throatfluff.setRotationPoint(-2.0f, 0.0f, -8.0f);
        this.throatfluff.setTextureSize(64, 64);
        this.throatfluff.mirror = true;
        this.setRotation(this.throatfluff, 1.07818f, 0.0f, 0.0f);
        (this.rear = new ModelRenderer((ModelBase) this, 18, 0)).addBox(-5.0f, -3.0f, -3.0f, 3, 2, 1);
        this.rear.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.rear.setTextureSize(64, 64);
        this.rear.mirror = true;
        this.setRotation(this.rear, 0.1047198f, 1.570796f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-3.0f, -3.0f, -3.0f, 6, 6, 6);
        this.head.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.ra1 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(-1.5f, -5.0f, 0.0f, 1, 4, 1);
        this.ra1.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.ra1.setTextureSize(64, 64);
        this.ra1.mirror = true;
        this.setRotation(this.ra1, -0.3717861f, 0.0f, 0.0f);
        (this.la1 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(0.5f, -5.0f, 0.0f, 1, 4, 1);
        this.la1.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.la1.setTextureSize(64, 64);
        this.la1.mirror = true;
        this.setRotation(this.la1, -0.3717861f, 0.0f, 0.0f);
        (this.la2 = new ModelRenderer((ModelBase) this, 0, 17)).addBox(0.5f, -8.5f, -3.0f, 1, 5, 1);
        this.la2.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.la2.setTextureSize(64, 64);
        this.la2.mirror = true;
        this.setRotation(this.la2, -1.041001f, 0.0f, 0.0f);
        (this.ra2 = new ModelRenderer((ModelBase) this, 0, 17)).addBox(-1.5f, -8.5f, -3.0f, 1, 5, 1);
        this.ra2.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.ra2.setTextureSize(64, 64);
        this.ra2.mirror = true;
        this.setRotation(this.ra2, -1.041001f, 0.0f, 0.0f);
        (this.ra3 = new ModelRenderer((ModelBase) this, 4, 12)).addBox(-1.5f, -12.5f, 3.0f, 1, 5, 1);
        this.ra3.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.ra3.setTextureSize(64, 64);
        this.ra3.mirror = true;
        this.setRotation(this.ra3, -0.3346075f, 0.0f, 0.0f);
        (this.nose = new ModelRenderer((ModelBase) this, 24, 0)).addBox(-2.5f, 0.0f, -7.0f, 5, 3, 5);
        this.nose.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.nose.setTextureSize(64, 64);
        this.nose.mirror = true;
        this.setRotation(this.nose, 0.0f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase) this, 28, 57)).addBox(-2.0f, 2.0f, -6.0f, 4, 2, 5);
        this.mouth.setRotationPoint(0.0f, -9.0f, -6.0f);
        this.mouth.setTextureSize(64, 64);
        this.mouth.mirror = true;
        this.setRotation(this.mouth, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Gazelle g = (Gazelle) entity;
        final float hf = 0.0f;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        } else {
            newangle = 0.0f;
        }
        this.lfleg1.rotateAngleX = 0.297f + newangle;
        this.lfleg2.rotateAngleX = -0.074f + newangle;
        this.lfleg3.rotateAngleX = -0.409f + newangle;
        this.lfleg4.rotateAngleX = newangle;
        this.rfleg1.rotateAngleX = 0.297f - newangle;
        this.rfleg2.rotateAngleX = -0.074f - newangle;
        this.rfleg3.rotateAngleX = -0.409f - newangle;
        this.rfleg4.rotateAngleX = -newangle;
        this.lrleg1.rotateAngleX = -newangle;
        this.lrleg2.rotateAngleX = 0.185f - newangle;
        this.lrleg3.rotateAngleX = -0.074f - newangle;
        this.lrleg4.rotateAngleX = -0.409f - newangle;
        this.lrleg5.rotateAngleX = -newangle;
        this.rrleg1.rotateAngleX = newangle;
        this.rrleg2.rotateAngleX = 0.185f + newangle;
        this.rrleg3.rotateAngleX = -0.074f + newangle;
        this.rrleg4.rotateAngleX = -0.409f + newangle;
        this.rrleg5.rotateAngleX = newangle;
        newangle = MathHelper.cos(f2 * 0.5f) * 3.1415927f * 0.02f;
        this.head.rotateAngleY = (float) Math.toRadians(f3) * 0.45f;
        this.nose.rotateAngleY = this.head.rotateAngleY;
        this.mouth.rotateAngleY = this.head.rotateAngleY;
        this.lear.rotateAngleY = 1.57f + this.head.rotateAngleY + newangle;
        this.rear.rotateAngleY = 1.57f + this.head.rotateAngleY + newangle;
        this.la1.rotateAngleY = this.head.rotateAngleY;
        this.la2.rotateAngleY = this.head.rotateAngleY;
        this.la3.rotateAngleY = this.head.rotateAngleY;
        this.ra1.rotateAngleY = this.head.rotateAngleY;
        this.ra2.rotateAngleY = this.head.rotateAngleY;
        this.ra3.rotateAngleY = this.head.rotateAngleY;
        if (!g.isSitting()) {
            this.tail.rotateAngleX = 1.0f + MathHelper.cos(f2 * 0.1f) * 3.1415927f * 0.06f;
        }
        this.Chest.render(f5);
        this.lfleg1.render(f5);
        this.lrleg2.render(f5);
        this.lrleg1.render(f5);
        this.rfleg3.render(f5);
        this.rrleg2.render(f5);
        this.rrleg3.render(f5);
        this.rfleg2.render(f5);
        this.lrleg4.render(f5);
        this.tail.render(f5);
        this.lear.render(f5);
        this.rrleg1.render(f5);
        this.rfleg1.render(f5);
        this.lrleg3.render(f5);
        this.lfleg2.render(f5);
        this.rrleg5.render(f5);
        this.rrleg4.render(f5);
        this.lfleg3.render(f5);
        this.rfleg4.render(f5);
        this.lfleg4.render(f5);
        this.lrleg5.render(f5);
        this.Body.render(f5);
        this.neck.render(f5);
        this.la3.render(f5);
        this.throatfluff.render(f5);
        this.rear.render(f5);
        this.head.render(f5);
        this.ra1.render(f5);
        this.la1.render(f5);
        this.la2.render(f5);
        this.ra2.render(f5);
        this.ra3.render(f5);
        this.nose.render(f5);
        this.mouth.render(f5);
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
