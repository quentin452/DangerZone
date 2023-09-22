
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Cricket;

public class ModelCricket extends ModelBase {

    private float wingspeed;
    ModelRenderer body;
    ModelRenderer head;
    ModelRenderer abdomen;
    ModelRenderer lfleg;
    ModelRenderer lrleg;
    ModelRenderer rfleg;
    ModelRenderer rrleg;
    ModelRenderer lleg1;
    ModelRenderer rleg1;
    ModelRenderer lleg2;
    ModelRenderer rleg2;

    public ModelCricket(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.body = new ModelRenderer((ModelBase) this, 0, 25)).addBox(-1.0f, -1.0f, -3.0f, 3, 3, 6);
        this.body.setRotationPoint(0.0f, 21.0f, 0.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 0, 17)).addBox(-1.0f, -2.0f, -1.0f, 3, 4, 3);
        this.head.setRotationPoint(0.0f, 21.0f, -5.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, -0.1745329f, 0.0f, 0.0f);
        (this.abdomen = new ModelRenderer((ModelBase) this, 0, 36)).addBox(-0.5f, -1.0f, 3.0f, 2, 2, 3);
        this.abdomen.setRotationPoint(0.0f, 21.0f, 0.0f);
        this.abdomen.setTextureSize(64, 64);
        this.abdomen.mirror = true;
        this.setRotation(this.abdomen, 0.0f, 0.0f, 0.0f);
        (this.lfleg = new ModelRenderer((ModelBase) this, 25, 0)).addBox(2.0f, 0.0f, 0.0f, 5, 1, 1);
        this.lfleg.setRotationPoint(0.0f, 21.0f, -2.0f);
        this.lfleg.setTextureSize(64, 64);
        this.lfleg.mirror = true;
        this.setRotation(this.lfleg, 0.0f, 0.4712389f, 0.418879f);
        (this.lrleg = new ModelRenderer((ModelBase) this, 23, 4)).addBox(1.0f, 0.0f, -2.0f, 6, 1, 1);
        this.lrleg.setRotationPoint(0.0f, 21.0f, 0.0f);
        this.lrleg.setTextureSize(64, 64);
        this.lrleg.mirror = true;
        this.setRotation(this.lrleg, 0.0f, -0.296706f, 0.418879f);
        (this.rfleg = new ModelRenderer((ModelBase) this, 25, 8)).addBox(-7.0f, 0.0f, 0.0f, 5, 1, 1);
        this.rfleg.setRotationPoint(1.0f, 21.0f, -2.0f);
        this.rfleg.setTextureSize(64, 64);
        this.rfleg.mirror = true;
        this.setRotation(this.rfleg, 0.0f, -0.5410521f, -0.4363323f);
        (this.rrleg = new ModelRenderer((ModelBase) this, 25, 12)).addBox(-7.0f, -1.0f, 0.0f, 5, 1, 1);
        this.rrleg.setRotationPoint(1.0f, 22.0f, -2.0f);
        this.rrleg.setTextureSize(64, 64);
        this.rrleg.mirror = true;
        this.setRotation(this.rrleg, 0.0f, 0.3839724f, -0.418879f);
        (this.lleg1 = new ModelRenderer((ModelBase) this, 40, 0)).addBox(-1.0f, -1.0f, 0.0f, 1, 2, 8);
        this.lleg1.setRotationPoint(2.0f, 22.0f, 0.0f);
        this.lleg1.setTextureSize(64, 64);
        this.lleg1.mirror = true;
        this.setRotation(this.lleg1, 0.5585054f, 0.4363323f, 0.0f);
        (this.rleg1 = new ModelRenderer((ModelBase) this, 40, 11)).addBox(0.0f, -1.0f, 0.0f, 1, 2, 8);
        this.rleg1.setRotationPoint(-1.0f, 22.0f, 0.0f);
        this.rleg1.setTextureSize(64, 64);
        this.rleg1.mirror = true;
        this.setRotation(this.rleg1, 0.5585054f, -0.4363323f, 0.0f);
        (this.lleg2 = new ModelRenderer((ModelBase) this, 21, 23)).addBox(-0.5f, -6.5f, 4.5f, 1, 1, 8);
        this.lleg2.setRotationPoint(2.0f, 22.0f, 0.0f);
        this.lleg2.setTextureSize(64, 64);
        this.lleg2.mirror = true;
        this.setRotation(this.lleg2, -0.3665191f, 0.3490659f, 0.0f);
        (this.rleg2 = new ModelRenderer((ModelBase) this, 21, 34)).addBox(-0.5f, -6.5f, 4.0f, 1, 1, 8);
        this.rleg2.setRotationPoint(-1.0f, 22.0f, 0.0f);
        this.rleg2.setTextureSize(64, 64);
        this.rleg2.mirror = true;
        this.setRotation(this.rleg2, -0.3665191f, -0.3490659f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Cricket c = (Cricket) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.lfleg.rotateAngleY = 0.47f + newangle;
        this.rfleg.rotateAngleY = -0.54f + newangle;
        this.lrleg.rotateAngleY = -0.296f - newangle;
        this.rrleg.rotateAngleY = 0.384f - newangle;
        if (c.getSinging() != 0) {
            newangle = MathHelper.cos(f2 * 3.0f * this.wingspeed) * 3.1415927f * 0.25f;
            this.lleg1.rotateAngleY = -0.035f;
            this.lleg2.rotateAngleY = -0.105f;
            this.rleg1.rotateAngleY = 0.035f;
            this.rleg2.rotateAngleY = 0.105f;
        } else {
            newangle = 0.0f;
            this.lleg1.rotateAngleY = 0.436f;
            this.lleg2.rotateAngleY = 0.349f;
            this.rleg1.rotateAngleY = -0.436f;
            this.rleg2.rotateAngleY = -0.349f;
        }
        this.lleg1.rotateAngleX = newangle + 0.558f;
        this.lleg2.rotateAngleX = newangle - 0.366f;
        this.rleg1.rotateAngleX = -newangle + 0.558f;
        this.rleg2.rotateAngleX = -newangle - 0.366f;
        this.body.render(f5);
        this.head.render(f5);
        this.abdomen.render(f5);
        this.lfleg.render(f5);
        this.lrleg.render(f5);
        this.rfleg.render(f5);
        this.rrleg.render(f5);
        this.lleg1.render(f5);
        this.rleg1.render(f5);
        this.lleg2.render(f5);
        this.rleg2.render(f5);
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
