
package fr.iamacat.dangerzone_iamacatfr.entities.model;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.Robot3;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRobot3 extends ModelBase {

    private float wingspeed;
    ModelRenderer rleg1;
    ModelRenderer lleg1;
    ModelRenderer rleg2;
    ModelRenderer lleg2;
    ModelRenderer hips;
    ModelRenderer waist1;
    ModelRenderer waist2;
    ModelRenderer body3;
    ModelRenderer lazer;
    ModelRenderer body2;
    ModelRenderer body1;
    ModelRenderer body4;
    ModelRenderer waist3;
    ModelRenderer larm3;
    ModelRenderer rarm3;
    ModelRenderer larm2;
    ModelRenderer rarm2;
    ModelRenderer larm1;
    ModelRenderer rarm1;

    public ModelRobot3(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.rleg1 = new ModelRenderer((ModelBase) this, 20, 100)).addBox(-23.0f, 26.0f, -8.0f, 16, 29, 16);
        this.rleg1.setRotationPoint(-9.0f, -31.0f, 0.0f);
        this.rleg1.setTextureSize(512, 512);
        this.rleg1.mirror = true;
        this.setRotation(this.rleg1, 0.0f, 0.0f, 0.0f);
        (this.lleg1 = new ModelRenderer((ModelBase) this, 20, 159)).addBox(7.0f, 25.0f, -8.0f, 16, 29, 16);
        this.lleg1.setRotationPoint(9.0f, -30.0f, 0.0f);
        this.lleg1.setTextureSize(512, 512);
        this.lleg1.mirror = true;
        this.setRotation(this.lleg1, 0.0f, 0.0f, 0.0f);
        (this.rleg2 = new ModelRenderer((ModelBase) this, 20, 212)).addBox(-14.0f, 0.0f, -7.0f, 14, 29, 14);
        this.rleg2.setRotationPoint(-9.0f, -31.0f, 0.0f);
        this.rleg2.setTextureSize(512, 512);
        this.rleg2.mirror = true;
        this.setRotation(this.rleg2, 0.0f, 0.0f, 0.2792527f);
        (this.lleg2 = new ModelRenderer((ModelBase) this, 20, 265)).addBox(0.0f, 0.0f, -7.0f, 13, 29, 14);
        this.lleg2.setRotationPoint(9.0f, -31.0f, 0.0f);
        this.lleg2.setTextureSize(512, 512);
        this.lleg2.mirror = true;
        this.setRotation(this.lleg2, 0.0f, 0.0f, -0.2792527f);
        (this.hips = new ModelRenderer((ModelBase) this, 20, 316)).addBox(0.0f, 0.0f, 0.0f, 18, 16, 16);
        this.hips.setRotationPoint(-9.0f, -43.0f, -8.0f);
        this.hips.setTextureSize(512, 512);
        this.hips.mirror = true;
        this.setRotation(this.hips, 0.0f, 0.0f, 0.0f);
        (this.waist1 = new ModelRenderer((ModelBase) this, 20, 359)).addBox(0.0f, 0.0f, 0.0f, 12, 12, 12);
        this.waist1.setRotationPoint(-6.0f, -55.0f, -4.0f);
        this.waist1.setTextureSize(512, 512);
        this.waist1.mirror = true;
        this.setRotation(this.waist1, -0.1f, 0.0f, 0.0f);
        (this.waist2 = new ModelRenderer((ModelBase) this, 20, 391)).addBox(0.0f, 0.0f, 0.0f, 12, 12, 12);
        this.waist2.setRotationPoint(-6.0f, -67.0f, -4.0f);
        this.waist2.setTextureSize(512, 512);
        this.waist2.mirror = true;
        this.setRotation(this.waist2, 0.0f, 0.0f, 0.0f);
        (this.body3 = new ModelRenderer((ModelBase) this, 20, 426)).addBox(-23.0f, -25.0f, 10.0f, 47, 47, 25);
        this.body3.setRotationPoint(0.0f, -88.0f, -10.0f);
        this.body3.setTextureSize(512, 512);
        this.body3.mirror = true;
        this.setRotation(this.body3, 0.2f, 0.0f, 0.0f);
        (this.lazer = new ModelRenderer((ModelBase) this, 20, 50)).addBox(-8.0f, -8.0f, -22.0f, 17, 16, 22);
        this.lazer.setRotationPoint(0.0f, -88.0f, -11.0f);
        this.lazer.setTextureSize(512, 512);
        this.lazer.mirror = true;
        this.setRotation(this.lazer, 0.4f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 101, 103)).addBox(9.0f, -24.0f, -12.0f, 15, 47, 47);
        this.body2.setRotationPoint(0.0f, -88.0f, -11.0f);
        this.body2.setTextureSize(512, 512);
        this.body2.mirror = true;
        this.setRotation(this.body2, 0.2f, 0.0f, 0.0f);
        (this.body1 = new ModelRenderer((ModelBase) this, 101, 210)).addBox(-23.0f, -24.0f, -12.0f, 15, 47, 47);
        this.body1.setRotationPoint(0.0f, -88.0f, -11.0f);
        this.body1.setTextureSize(512, 512);
        this.body1.mirror = true;
        this.setRotation(this.body1, 0.2f, 0.0f, 0.0f);
        (this.body4 = new ModelRenderer((ModelBase) this, 101, 321)).addBox(-8.0f, -24.0f, -12.0f, 18, 16, 22);
        this.body4.setRotationPoint(0.0f, -88.0f, -11.0f);
        this.body4.setTextureSize(512, 512);
        this.body4.mirror = true;
        this.setRotation(this.body4, 0.2f, 0.0f, 0.0f);
        (this.waist3 = new ModelRenderer((ModelBase) this, 99, 375)).addBox(0.0f, 0.0f, -1.0f, 12, 17, 12);
        this.waist3.setRotationPoint(-6.0f, -83.0f, -6.0f);
        this.waist3.setTextureSize(512, 512);
        this.waist3.mirror = true;
        this.setRotation(this.waist3, 0.2f, 0.0f, 0.0f);
        (this.larm3 = new ModelRenderer((ModelBase) this, 121, 54)).addBox(0.0f, -10.0f, -9.0f, 20, 18, 18);
        this.larm3.setRotationPoint(24.0f, -92.0f, 2.0f);
        this.larm3.setTextureSize(512, 512);
        this.larm3.mirror = true;
        this.setRotation(this.larm3, 1.0f, 0.0f, 0.0f);
        (this.rarm3 = new ModelRenderer((ModelBase) this, 26, 8)).addBox(-20.0f, -9.0f, -9.0f, 20, 18, 18);
        this.rarm3.setRotationPoint(-23.0f, -92.0f, 2.0f);
        this.rarm3.setTextureSize(512, 512);
        this.rarm3.mirror = true;
        this.setRotation(this.rarm3, 1.0f, 0.0f, 0.0f);
        (this.larm2 = new ModelRenderer((ModelBase) this, 207, 47)).addBox(3.0f, 8.0f, -7.0f, 14, 29, 14);
        this.larm2.setRotationPoint(24.0f, -92.0f, 2.0f);
        this.larm2.setTextureSize(512, 512);
        this.larm2.mirror = true;
        this.setRotation(this.larm2, 1.0f, 0.0f, 0.0f);
        (this.rarm2 = new ModelRenderer((ModelBase) this, 161, 372)).addBox(-17.0f, 9.0f, -7.0f, 14, 29, 14);
        this.rarm2.setRotationPoint(-23.0f, -92.0f, 2.0f);
        this.rarm2.setTextureSize(512, 512);
        this.rarm2.mirror = true;
        this.setRotation(this.rarm2, 1.0f, 0.0f, 0.0f);
        (this.larm1 = new ModelRenderer((ModelBase) this, 185, 433)).addBox(0.0f, -12.0f, 30.0f, 14, 37, 14);
        this.larm1.setRotationPoint(27.0f, -92.0f, 2.0f);
        this.larm1.setTextureSize(512, 512);
        this.larm1.mirror = true;
        this.setRotation(this.larm1, -1.0f, 0.0f, 0.0f);
        (this.rarm1 = new ModelRenderer((ModelBase) this, 239, 105)).addBox(-17.0f, -12.0f, 30.0f, 14, 37, 14);
        this.rarm1.setRotationPoint(-23.0f, -92.0f, 2.0f);
        this.rarm1.setTextureSize(512, 512);
        this.rarm1.mirror = true;
        this.setRotation(this.rarm1, -1.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Robot3 e = (Robot3) entity;
        RenderInfo r = null;
        float newangle = 0.0f;
        float nextangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 0.55f * this.wingspeed) * 3.1415927f * 0.12f * f1;
        } else {
            newangle = 0.0f;
        }
        this.lleg1.rotateAngleX = newangle;
        this.lleg2.rotateAngleX = newangle;
        this.rleg1.rotateAngleX = -newangle;
        this.rleg2.rotateAngleX = -newangle;
        this.lazer.rotateAngleY = (float) Math.toRadians(f3 / 2.0);
        r = e.getRenderInfo();
        newangle = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.3f) * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() != 0) {
                r.ri1 = 1;
            }
        }
        if (r.ri1 == 0) {
            newangle = 0.0f;
        }
        this.rarm1.rotateAngleX = newangle - 1.0f;
        this.rarm2.rotateAngleX = newangle + 1.0f;
        this.rarm3.rotateAngleX = newangle + 1.0f;
        this.larm1.rotateAngleX = newangle - 1.0f;
        this.larm2.rotateAngleX = newangle + 1.0f;
        this.larm3.rotateAngleX = newangle + 1.0f;
        e.setRenderInfo(r);
        this.rleg1.render(f5);
        this.lleg1.render(f5);
        this.rleg2.render(f5);
        this.lleg2.render(f5);
        this.hips.render(f5);
        this.waist1.render(f5);
        this.waist2.render(f5);
        this.body3.render(f5);
        this.lazer.render(f5);
        this.body2.render(f5);
        this.body1.render(f5);
        this.body4.render(f5);
        this.waist3.render(f5);
        this.larm3.render(f5);
        this.rarm3.render(f5);
        this.larm2.render(f5);
        this.rarm2.render(f5);
        this.larm1.render(f5);
        this.rarm1.render(f5);
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
