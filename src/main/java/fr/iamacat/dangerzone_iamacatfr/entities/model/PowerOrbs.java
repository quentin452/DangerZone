
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MyDarkness;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;

public class PowerOrbs extends ModelBase {

    private float wingspeed;
    ModelRenderer Orb1;
    ModelRenderer Orb2;
    ModelRenderer Orb3;
    ModelRenderer Orb4;
    ModelRenderer Orb5;
    ModelRenderer Orb6;
    ModelRenderer Orb7;
    ModelRenderer Orb8;
    ModelRenderer Orb9;
    ModelRenderer Orb10;

    public PowerOrbs(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Orb1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb1.setTextureSize(64, 32);
        this.Orb1.mirror = true;
        this.setRotation(this.Orb1, 0.0f, 0.0f, 0.0f);
        (this.Orb2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb2.setTextureSize(64, 32);
        this.Orb2.mirror = true;
        this.setRotation(this.Orb2, 0.0f, 0.0f, 0.0f);
        (this.Orb3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb3.setTextureSize(64, 32);
        this.Orb3.mirror = true;
        this.setRotation(this.Orb3, 0.0f, 0.0f, 0.0f);
        (this.Orb4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb4.setTextureSize(64, 32);
        this.Orb4.mirror = true;
        this.setRotation(this.Orb4, 0.0f, 0.0f, 0.0f);
        (this.Orb5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb5.setTextureSize(64, 32);
        this.Orb5.mirror = true;
        this.setRotation(this.Orb5, 0.0f, 0.0f, 0.0f);
        (this.Orb6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb6.setTextureSize(64, 32);
        this.Orb6.mirror = true;
        this.setRotation(this.Orb6, 0.0f, 0.0f, 0.0f);
        (this.Orb7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb7.setTextureSize(64, 32);
        this.Orb7.mirror = true;
        this.setRotation(this.Orb7, 0.0f, 0.0f, 0.0f);
        (this.Orb8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb8.setTextureSize(64, 32);
        this.Orb8.mirror = true;
        this.setRotation(this.Orb8, 0.0f, 0.0f, 0.0f);
        (this.Orb9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb9.setTextureSize(64, 32);
        this.Orb9.mirror = true;
        this.setRotation(this.Orb9, 0.0f, 0.0f, 0.0f);
        (this.Orb10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb10.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb10.setTextureSize(64, 32);
        this.Orb10.mirror = true;
        this.setRotation(this.Orb10, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final MyDarkness p = (MyDarkness) entity;
        final float rf1 = 1.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float upangle = 0.0f;
        float nextangle = 0.0f;
        final float newangle2 = 0.0f;
        final RenderInfo r = null;
        final float pi4 = 1.570795f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.141593f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed) * 3.141593f * 0.12f * f1;
        final ModelRenderer orb1 = this.Orb1;
        orb1.rotateAngleX += 0.15f;
        if (this.Orb1.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb1;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer orb2 = this.Orb2;
        orb2.rotateAngleX += 0.25f;
        if (this.Orb2.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb2;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer orb3 = this.Orb3;
        orb3.rotateAngleX += 0.05f;
        if (this.Orb3.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb3;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer orb4 = this.Orb4;
        orb4.rotateAngleX += 0.05f;
        if (this.Orb4.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb4;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer orb5 = this.Orb5;
        orb5.rotateAngleX += 0.15f;
        if (this.Orb5.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb5;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer orb6 = this.Orb6;
        orb6.rotateAngleX += 0.25f;
        if (this.Orb6.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb6;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer orb7 = this.Orb7;
        orb7.rotateAngleX += 0.05f;
        if (this.Orb7.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb7;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer orb8 = this.Orb8;
        orb8.rotateAngleX += 0.15f;
        if (this.Orb8.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb8;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer orb9 = this.Orb9;
        orb9.rotateAngleX += 0.25f;
        if (this.Orb9.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb9;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer orb10 = this.Orb10;
        orb10.rotateAngleZ += 0.02f;
        if (this.Orb10.rotateAngleZ > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb10;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 480.0f, 680.0f);
        this.Orb1.render(f5);
        this.Orb2.render(f5);
        this.Orb3.render(f5);
        this.Orb4.render(f5);
        this.Orb5.render(f5);
        this.Orb6.render(f5);
        this.Orb7.render(f5);
        this.Orb8.render(f5);
        this.Orb9.render(f5);
        this.Orb10.render(f5);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
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
