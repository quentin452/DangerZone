
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.RubberDucky;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRubberDucky extends ModelBase {

    private float wingspeed;
    ModelRenderer bottom;
    ModelRenderer body;
    ModelRenderer back;
    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer beak;
    ModelRenderer Lwing;
    ModelRenderer Rwing;

    public ModelRubberDucky(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.bottom = new ModelRenderer((ModelBase) this, 0, 56)).addBox(-2.0f, 0.0f, -2.0f, 4, 1, 4);
        this.bottom.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.bottom.setTextureSize(64, 64);
        this.bottom.mirror = true;
        this.setRotation(this.bottom, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 0, 45)).addBox(-3.0f, 0.0f, -3.0f, 6, 2, 8);
        this.body.setRotationPoint(0.0f, 21.0f, 0.0f);
        this.body.setTextureSize(64, 64);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.back = new ModelRenderer((ModelBase) this, 0, 33)).addBox(-3.0f, 0.0f, -3.0f, 6, 1, 10);
        this.back.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.back.setTextureSize(64, 64);
        this.back.mirror = true;
        this.setRotation(this.back, 0.0f, 0.0f, 0.0f);
        (this.neck = new ModelRenderer((ModelBase) this, 17, 27)).addBox(-1.0f, 0.0f, -1.0f, 2, 1, 2);
        this.neck.setRotationPoint(0.0f, 19.0f, -1.0f);
        this.neck.setTextureSize(64, 64);
        this.neck.mirror = true;
        this.setRotation(this.neck, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 13, 18)).addBox(-2.0f, -4.0f, -2.0f, 4, 4, 4);
        this.head.setRotationPoint(0.0f, 19.0f, -1.0f);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.beak = new ModelRenderer((ModelBase) this, 0, 21)).addBox(-1.5f, -1.0f, -5.0f, 3, 1, 3);
        this.beak.setRotationPoint(0.0f, 19.0f, -1.0f);
        this.beak.setTextureSize(64, 64);
        this.beak.mirror = true;
        this.setRotation(this.beak, 0.0f, 0.0f, 0.0f);
        (this.Lwing = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -0.5f, 0.0f, 2, 1, 5);
        this.Lwing.setRotationPoint(3.0f, 21.0f, -2.0f);
        this.Lwing.setTextureSize(64, 64);
        this.Lwing.mirror = true;
        this.setRotation(this.Lwing, 0.0f, 0.0f, 0.0f);
        (this.Rwing = new ModelRenderer((ModelBase) this, 17, 0)).addBox(-2.0f, -0.5f, 0.0f, 2, 1, 5);
        this.Rwing.setRotationPoint(-3.0f, 21.0f, -2.0f);
        this.Rwing.setTextureSize(64, 64);
        this.Rwing.mirror = true;
        this.setRotation(this.Rwing, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final RubberDucky c = (RubberDucky) entity;
        RenderInfo r = null;
        final float hf = 0.0f;
        float newangle = 0.0f;
        float nextangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 2.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.head.rotateAngleY = (float) Math.toRadians(f3) * 0.45f;
        this.beak.rotateAngleY = this.head.rotateAngleY;
        this.head.rotateAngleX = (float) Math.toRadians(f4) * 0.65f;
        this.beak.rotateAngleX = this.head.rotateAngleX;
        r = c.getRenderInfo();
        newangle = MathHelper.cos(f2 * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.3f) * 1.0f * this.wingspeed) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (c.worldObj.rand.nextInt(3) == 1) {
                r.ri1 = 1;
            }
            if (c.getKillCount() >= 5) {
                if (c.worldObj.rand.nextInt(2) == 1) {
                    r.ri1 = 1;
                }
                newangle *= 4.0f;
            }
        }
        if (r.ri1 == 0) {
            newangle = 0.0f;
        }
        if (c.isSitting()) {
            newangle = 0.0f;
        }
        newangle = Math.abs(newangle);
        this.Lwing.rotateAngleZ = -newangle;
        this.Lwing.rotateAngleY = newangle / 2.0f;
        this.Rwing.rotateAngleZ = newangle;
        this.Rwing.rotateAngleY = -newangle / 2.0f;
        c.setRenderInfo(r);
        this.bottom.render(f5);
        this.body.render(f5);
        this.back.render(f5);
        this.neck.render(f5);
        this.head.render(f5);
        this.beak.render(f5);
        this.Lwing.render(f5);
        this.Rwing.render(f5);
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
