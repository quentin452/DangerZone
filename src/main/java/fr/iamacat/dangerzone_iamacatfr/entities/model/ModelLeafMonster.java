
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.LeafMonster;

public class ModelLeafMonster extends ModelBase {

    ModelRenderer body;
    ModelRenderer larm;
    ModelRenderer rarm;
    ModelRenderer lleg;
    ModelRenderer rleg;

    public ModelLeafMonster() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.body = new ModelRenderer((ModelBase) this, 32, 32)).addBox(-8.0f, -8.0f, -8.0f, 16, 16, 16);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.larm = new ModelRenderer((ModelBase) this, 64, 0)).addBox(0.0f, -16.0f, -8.0f, 16, 16, 16);
        this.larm.setRotationPoint(8.0f, -8.0f, 0.0f);
        this.larm.setTextureSize(64, 32);
        this.larm.mirror = true;
        this.setRotation(this.larm, 0.0f, 0.0f, 0.0f);
        (this.rarm = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-16.0f, -16.0f, -8.0f, 16, 16, 16);
        this.rarm.setRotationPoint(-8.0f, -8.0f, 0.0f);
        this.rarm.setTextureSize(64, 32);
        this.rarm.mirror = true;
        this.setRotation(this.rarm, 0.0f, 0.0f, 0.0f);
        (this.lleg = new ModelRenderer((ModelBase) this, 64, 64)).addBox(0.0f, 0.0f, -8.0f, 16, 16, 16);
        this.lleg.setRotationPoint(8.0f, 8.0f, 0.0f);
        this.lleg.setTextureSize(64, 32);
        this.lleg.mirror = true;
        this.setRotation(this.lleg, 0.0f, 0.0f, 0.0f);
        (this.rleg = new ModelRenderer((ModelBase) this, 0, 64)).addBox(-16.0f, 0.0f, -8.0f, 16, 16, 16);
        this.rleg.setRotationPoint(-8.0f, 8.0f, 0.0f);
        this.rleg.setTextureSize(64, 32);
        this.rleg.mirror = true;
        this.setRotation(this.rleg, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final LeafMonster lm = (LeafMonster) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (lm.getAttacking() == 0) {
            this.body.rotationPointY = 16.0f;
            this.rarm.rotationPointY = 8.0f;
            this.larm.rotationPointY = 8.0f;
            this.rarm.rotateAngleY = 0.0f;
            this.larm.rotateAngleY = 0.0f;
            this.rarm.rotateAngleX = 0.0f;
            this.larm.rotateAngleX = 0.0f;
            this.lleg.rotateAngleX = 0.0f;
            this.rleg.rotateAngleX = 0.0f;
        } else {
            this.body.rotationPointY = 0.0f;
            this.rarm.rotationPointY = -8.0f;
            this.larm.rotationPointY = -8.0f;
            float newangle;
            if (f1 > 0.1) {
                newangle = MathHelper.cos(f2 * 0.95f) * 3.1415927f * 0.25f * f1;
            } else {
                newangle = 0.0f;
            }
            this.lleg.rotateAngleX = newangle;
            this.rleg.rotateAngleX = -newangle;
            newangle = MathHelper.cos(f2 * 0.7f) * 3.1415927f * 0.55f;
            this.rarm.rotateAngleY = -Math.abs(newangle);
            this.larm.rotateAngleY = Math.abs(newangle);
            this.rarm.rotateAngleX = -Math.abs(newangle);
            this.larm.rotateAngleX = -Math.abs(newangle);
        }
        this.body.render(f5);
        this.larm.render(f5);
        this.rarm.render(f5);
        this.lleg.render(f5);
        this.rleg.render(f5);
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
