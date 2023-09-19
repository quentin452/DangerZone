
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class BeaverModel extends ModelBase {

    ModelRenderer body;
    ModelRenderer leg4;
    ModelRenderer leg3;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer HEADROT;
    ModelRenderer TAILROT;

    public BeaverModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.setTextureOffset("HEADROT.head", 38, 14);
        this.setTextureOffset("HEADROT.nose", 38, 24);
        this.setTextureOffset("HEADROT.teeth2", 46, 24);
        this.setTextureOffset("HEADROT.teeth1", 46, 24);
        this.setTextureOffset("TAILROT.tail1", 0, 0);
        this.setTextureOffset("TAILROT.tail2", 0, 3);
        this.setTextureOffset("TAILROT.tail3", 0, 5);
        this.setTextureOffset("TAILROT.tail4", 12, 0);
        this.setTextureOffset("TAILROT.tail5", 12, 5);
        (this.body = new ModelRenderer((ModelBase) this, 0, 14)).addBox(-4.5f, -4.0f, -10.0f, 9, 8, 10);
        this.body.setRotationPoint(0.0f, 18.0f, 7.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.leg4 = new ModelRenderer((ModelBase) this, 8, 10)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.leg4.setRotationPoint(3.5f, 22.0f, 6.0f);
        this.leg4.setTextureSize(64, 32);
        this.leg4.mirror = true;
        this.setRotation(this.leg4, 0.0f, 0.0f, 0.0f);
        (this.leg3 = new ModelRenderer((ModelBase) this, 0, 10)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.leg3.setRotationPoint(-3.5f, 22.0f, 6.0f);
        this.leg3.setTextureSize(64, 32);
        this.leg3.mirror = true;
        this.setRotation(this.leg3, 0.0f, 0.0f, 0.0f);
        (this.leg1 = new ModelRenderer((ModelBase) this, 0, 10)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.leg1.setRotationPoint(-3.5f, 22.0f, -2.0f);
        this.leg1.setTextureSize(64, 32);
        this.leg1.mirror = true;
        this.setRotation(this.leg1, 0.0f, 0.0f, 0.0f);
        (this.leg2 = new ModelRenderer((ModelBase) this, 8, 10)).addBox(-1.0f, 0.0f, -1.0f, 2, 2, 2);
        this.leg2.setRotationPoint(3.5f, 22.0f, -2.0f);
        this.leg2.setTextureSize(64, 32);
        this.leg2.mirror = true;
        this.setRotation(this.leg2, 0.0f, 0.0f, 0.0f);
        (this.HEADROT = new ModelRenderer((ModelBase) this, "HEADROT")).setRotationPoint(0.0f, 18.0f, -3.0f);
        this.setRotation(this.HEADROT, 0.0f, 0.0f, 0.0f);
        this.HEADROT.mirror = true;
        this.HEADROT.addBox("head", -3.0f, -3.0f, -4.0f, 6, 6, 4);
        this.HEADROT.addBox("nose", -1.5f, 1.0f, -5.0f, 3, 2, 1);
        this.HEADROT.addBox("teeth2", 0.0f, 3.0f, -5.0f, 1, 1, 1);
        this.HEADROT.addBox("teeth1", -1.0f, 3.0f, -5.0f, 1, 1, 1);
        (this.TAILROT = new ModelRenderer((ModelBase) this, "TAILROT")).setRotationPoint(0.0f, 20.0f, 7.0f);
        this.setRotation(this.TAILROT, 0.0f, 0.0f, 0.0f);
        this.TAILROT.mirror = true;
        this.TAILROT.addBox("tail1", -1.5f, -0.5f, 0.0f, 3, 1, 2);
        this.TAILROT.addBox("tail2", -2.0f, -0.5f, 2.0f, 4, 1, 1);
        this.TAILROT.addBox("tail3", -2.5f, -0.5f, 3.0f, 5, 1, 1);
        this.TAILROT.addBox("tail4", -3.0f, -0.5f, 4.0f, 6, 1, 4);
        this.TAILROT.addBox("tail5", -2.5f, -0.5f, 8.0f, 5, 1, 1);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        final float field_78145_g = 8.0f;
        final float field_78151_h = 4.0f;
        if (this.isChild) {
            final float var8 = 2.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0f, field_78145_g * f5, field_78151_h * f5);
            this.HEADROT.render(f5);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0f / var8, 1.0f / var8, 1.0f / var8);
            GL11.glTranslatef(0.0f, 24.0f * f5, 0.0f);
            this.body.render(f5);
            this.leg4.render(f5);
            this.leg3.render(f5);
            this.leg1.render(f5);
            this.leg2.render(f5);
            this.TAILROT.render(f5);
            GL11.glPopMatrix();
        } else {
            this.body.render(f5);
            this.leg4.render(f5);
            this.leg3.render(f5);
            this.leg1.render(f5);
            this.leg2.render(f5);
            this.HEADROT.render(f5);
            this.TAILROT.render(f5);
        }
    }

    public void setLivingAnimations(final EntityLivingBase par1EntityLiving, final float par2, final float par3,
        final float par4) {
        this.leg1.rotateAngleX = MathHelper.cos(par2 * 0.6662f * 2.0f) * 1.8f * par3;
        this.leg2.rotateAngleX = MathHelper.cos(par2 * 0.6662f * 2.0f + 3.1415927f) * 1.8f * par3;
        this.leg3.rotateAngleX = MathHelper.cos(par2 * 0.6662f * 2.0f + 3.1415927f) * 1.8f * par3;
        this.leg4.rotateAngleX = MathHelper.cos(par2 * 0.6662f * 2.0f) * 1.8f * par3;
        this.TAILROT.rotateAngleX = MathHelper.cos(par2 * 0.6662f * 2.0f) * 1.8f * par3;
        super.setLivingAnimations(par1EntityLiving, par2, par3, par4);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4,
        final float f5, final Entity par7Entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, par7Entity);
        this.HEADROT.rotateAngleX = Math.min(Math.max(f4, -30.0f), 30.0f) * 0.017453292f;
        this.HEADROT.rotateAngleY = Math.min(Math.max(f3, -45.0f), 45.0f) * 0.017453292f;
    }
}
