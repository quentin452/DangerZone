
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Frog;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelFrog extends ModelBase {

    private float wingspeed;
    ModelRenderer body;
    ModelRenderer jaw;
    ModelRenderer lfleg;
    ModelRenderer rfleg;
    ModelRenderer lleg1;
    ModelRenderer rleg1;
    ModelRenderer lleg2;
    ModelRenderer rleg2;
    ModelRenderer leye;
    ModelRenderer reye;

    public ModelFrog(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase) this, 41, 0)).addBox(-4.0f, -10.0f, 0.0f, 8, 11, 2);
        this.body.setRotationPoint(0.0f, 24.0f, 2.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.7330383f, 0.0f, 0.0f);
        (this.jaw = new ModelRenderer((ModelBase) this, 42, 15)).addBox(-4.0f, -8.0f, 0.0f, 8, 8, 1);
        this.jaw.setRotationPoint(0.0f, 24.0f, 2.0f);
        this.jaw.setTextureSize(64, 64);
        this.jaw.mirror = true;
        this.setRotation(this.jaw, 1.22173f, 0.0f, 0.0f);
        (this.lfleg = new ModelRenderer((ModelBase) this, 14, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 5, 1);
        this.lfleg.setRotationPoint(3.0f, 20.0f, 0.0f);
        this.lfleg.setTextureSize(64, 64);
        this.lfleg.mirror = true;
        this.setRotation(this.lfleg, -0.5235988f, 0.0f, -0.4712389f);
        (this.rfleg = new ModelRenderer((ModelBase) this, 20, 0)).addBox(-1.0f, 0.0f, 0.0f, 1, 5, 1);
        this.rfleg.setRotationPoint(-3.0f, 20.0f, 0.0f);
        this.rfleg.setTextureSize(64, 64);
        this.rfleg.mirror = true;
        this.setRotation(this.rfleg, -0.5235988f, 0.0f, 0.4712389f);
        (this.lleg1 = new ModelRenderer((ModelBase) this, 10, 8)).addBox(0.0f, -9.0f, -1.0f, 1, 9, 2);
        this.lleg1.setRotationPoint(3.0f, 24.0f, 3.0f);
        this.lleg1.setTextureSize(64, 64);
        this.lleg1.mirror = true;
        this.setRotation(this.lleg1, 0.0f, 0.0f, 0.2268928f);
        (this.rleg1 = new ModelRenderer((ModelBase) this, 18, 8)).addBox(-1.0f, -9.0f, -1.0f, 1, 9, 2);
        this.rleg1.setRotationPoint(-3.0f, 24.0f, 3.0f);
        this.rleg1.setTextureSize(64, 64);
        this.rleg1.mirror = true;
        this.setRotation(this.rleg1, 0.0f, 0.0f, -0.2268928f);
        (this.lleg2 = new ModelRenderer((ModelBase) this, 11, 20)).addBox(0.0f, 0.0f, 0.0f, 1, 10, 1);
        this.lleg2.setRotationPoint(5.0f, 15.0f, 3.0f);
        this.lleg2.setTextureSize(64, 64);
        this.lleg2.mirror = true;
        this.setRotation(this.lleg2, 0.0f, 0.0f, -0.3839724f);
        (this.rleg2 = new ModelRenderer((ModelBase) this, 19, 20)).addBox(-1.0f, 0.0f, 0.0f, 1, 10, 1);
        this.rleg2.setRotationPoint(-5.0f, 15.0f, 3.0f);
        this.rleg2.setTextureSize(64, 64);
        this.rleg2.mirror = true;
        this.setRotation(this.rleg2, 0.0f, 0.0f, 0.3839724f);
        (this.leye = new ModelRenderer((ModelBase) this, 0, 8)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.leye.setRotationPoint(2.0f, 17.0f, -2.0f);
        this.leye.setTextureSize(64, 64);
        this.leye.mirror = true;
        this.setRotation(this.leye, 0.7330383f, 0.0f, 0.0f);
        (this.reye = new ModelRenderer((ModelBase) this, 0, 4)).addBox(0.0f, 0.0f, 0.0f, 1, 2, 1);
        this.reye.setRotationPoint(-3.0f, 17.0f, -2.0f);
        this.reye.setTextureSize(64, 64);
        this.reye.mirror = true;
        this.setRotation(this.reye, 0.7330383f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Frog c = (Frog) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * this.wingspeed * 1.4f) * 3.1415927f * 0.55f * f1;
        } else {
            newangle = 0.0f;
        }
        this.lfleg.rotateAngleY = newangle;
        this.rfleg.rotateAngleY = -newangle;
        this.lleg2.rotateAngleY = -newangle / 2.0f;
        this.rleg2.rotateAngleY = newangle / 2.0f;
        if (c.getSinging() != 0) {
            newangle = MathHelper.cos(f2 * 0.85f * this.wingspeed) * 3.1415927f * 0.15f;
        } else {
            newangle = 0.0f;
        }
        this.jaw.rotateAngleX = newangle + 1.22f;
        if (c.motionY > 0.10000000149011612 || c.motionY < -0.10000000149011612) {
            this.lleg1.rotateAngleZ = 2.44f;
            this.rleg1.rotateAngleZ = -2.44f;
        } else {
            this.lleg1.rotateAngleZ = 0.227f;
            this.rleg1.rotateAngleZ = -0.227f;
        }
        this.lleg2.rotationPointY = this.lleg1.rotationPointY - (float) Math.cos(this.lleg1.rotateAngleZ) * 9.0f;
        this.lleg2.rotationPointX = this.lleg1.rotationPointX + (float) Math.sin(this.lleg1.rotateAngleZ) * 9.0f;
        this.rleg2.rotationPointY = this.rleg1.rotationPointY - (float) Math.cos(this.rleg1.rotateAngleZ) * 9.0f;
        this.rleg2.rotationPointX = this.rleg1.rotationPointX + (float) Math.sin(this.rleg1.rotateAngleZ) * 9.0f;
        this.body.render(f5);
        this.jaw.render(f5);
        this.lfleg.render(f5);
        this.rfleg.render(f5);
        this.lleg1.render(f5);
        this.rleg1.render(f5);
        this.lleg2.render(f5);
        this.rleg2.render(f5);
        this.leye.render(f5);
        this.reye.render(f5);
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
