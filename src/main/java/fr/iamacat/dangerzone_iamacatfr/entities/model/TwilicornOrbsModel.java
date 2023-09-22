
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;

public class TwilicornOrbsModel extends ModelBase {

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
    ModelRenderer SOrb1;
    ModelRenderer SOrb2;
    ModelRenderer SOrb3;
    ModelRenderer SOrb4;
    ModelRenderer SOrb5;
    ModelRenderer SOrb6;
    ModelRenderer SOrb7;
    ModelRenderer SOrb8;
    ModelRenderer SOrb9;
    ModelRenderer SSOrb1;
    ModelRenderer SSOrb2;
    ModelRenderer SSOrb3;
    ModelRenderer SSOrb4;
    ModelRenderer SSOrb5;
    ModelRenderer SSOrb6;
    ModelRenderer SSOrb7;
    ModelRenderer SSOrb8;
    ModelRenderer SSOrb9;

    public TwilicornOrbsModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 128;
        this.textureHeight = 128;
        (this.Orb1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb1.setTextureSize(128, 128);
        this.Orb1.mirror = true;
        this.setRotation(this.Orb1, 0.0f, 0.0f, 0.0f);
        (this.Orb2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb2.setTextureSize(128, 128);
        this.Orb2.mirror = true;
        this.setRotation(this.Orb2, 0.0f, 0.0f, 0.0f);
        (this.Orb3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb3.setTextureSize(128, 128);
        this.Orb3.mirror = true;
        this.setRotation(this.Orb3, 0.0f, 0.0f, 0.0f);
        (this.Orb4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb4.setTextureSize(128, 128);
        this.Orb4.mirror = true;
        this.setRotation(this.Orb4, 0.0f, 0.0f, 0.0f);
        (this.Orb5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb5.setTextureSize(128, 128);
        this.Orb5.mirror = true;
        this.setRotation(this.Orb5, 0.0f, 0.0f, 0.0f);
        (this.Orb6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb6.setTextureSize(128, 128);
        this.Orb6.mirror = true;
        this.setRotation(this.Orb6, 0.0f, 0.0f, 0.0f);
        (this.Orb7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb7.setTextureSize(128, 128);
        this.Orb7.mirror = true;
        this.setRotation(this.Orb7, 0.0f, 0.0f, 0.0f);
        (this.Orb8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb8.setTextureSize(128, 128);
        this.Orb8.mirror = true;
        this.setRotation(this.Orb8, 0.0f, 0.0f, 0.0f);
        (this.Orb9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 16, 16, 16);
        this.Orb9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Orb9.setTextureSize(128, 128);
        this.Orb9.mirror = true;
        this.setRotation(this.Orb9, 0.0f, 0.0f, 0.0f);
        (this.SOrb1 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb1.setTextureSize(128, 128);
        this.SOrb1.mirror = true;
        this.setRotation(this.SOrb1, 0.0f, 0.0f, 0.0f);
        (this.SOrb2 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb2.setTextureSize(128, 128);
        this.SOrb2.mirror = true;
        this.setRotation(this.SOrb2, 0.0f, 0.0f, 0.0f);
        (this.SOrb3 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb3.setTextureSize(128, 128);
        this.SOrb3.mirror = true;
        this.setRotation(this.SOrb3, 0.0f, 0.0f, 0.0f);
        (this.SOrb4 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb4.setTextureSize(128, 128);
        this.SOrb4.mirror = true;
        this.setRotation(this.SOrb4, 0.0f, 0.0f, 0.0f);
        (this.SOrb5 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb5.setTextureSize(128, 128);
        this.SOrb5.mirror = true;
        this.setRotation(this.SOrb5, 0.0f, 0.0f, 0.0f);
        (this.SOrb6 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb6.setTextureSize(128, 128);
        this.SOrb6.mirror = true;
        this.setRotation(this.SOrb6, 0.0f, 0.0f, 0.0f);
        (this.SOrb7 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb7.setTextureSize(128, 128);
        this.SOrb7.mirror = true;
        this.setRotation(this.SOrb7, 0.0f, 0.0f, 0.0f);
        (this.SOrb8 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb8.setTextureSize(128, 128);
        this.SOrb8.mirror = true;
        this.setRotation(this.SOrb8, 0.0f, 0.0f, 0.0f);
        (this.SOrb9 = new ModelRenderer((ModelBase) this, 0, 32)).addBox(20.0f, 0.0f, 20.0f, 8, 8, 8);
        this.SOrb9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SOrb9.setTextureSize(128, 128);
        this.SOrb9.mirror = true;
        this.setRotation(this.SOrb9, 0.0f, 0.0f, 0.0f);
        (this.SSOrb1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb1.setTextureSize(128, 128);
        this.SSOrb1.mirror = true;
        this.setRotation(this.SSOrb1, 0.0f, 0.0f, 0.0f);
        (this.SSOrb2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb2.setTextureSize(128, 128);
        this.SSOrb2.mirror = true;
        this.setRotation(this.SSOrb2, 0.0f, 0.0f, 0.0f);
        (this.SSOrb3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb3.setTextureSize(128, 128);
        this.SSOrb3.mirror = true;
        this.setRotation(this.SSOrb3, 0.0f, 0.0f, 0.0f);
        (this.SSOrb4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb4.setTextureSize(128, 128);
        this.SSOrb4.mirror = true;
        this.setRotation(this.SSOrb4, 0.0f, 0.0f, 0.0f);
        (this.SSOrb5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb5.setTextureSize(128, 128);
        this.SSOrb5.mirror = true;
        this.setRotation(this.SSOrb5, 0.0f, 0.0f, 0.0f);
        (this.SSOrb6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb6.setTextureSize(128, 128);
        this.SSOrb6.mirror = true;
        this.setRotation(this.SSOrb6, 0.0f, 0.0f, 0.0f);
        (this.SSOrb7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb7.setTextureSize(128, 128);
        this.SSOrb7.mirror = true;
        this.setRotation(this.SSOrb7, 0.0f, 0.0f, 0.0f);
        (this.SSOrb8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb8.setTextureSize(128, 128);
        this.SSOrb8.mirror = true;
        this.setRotation(this.SSOrb8, 0.0f, 0.0f, 0.0f);
        (this.SSOrb9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 30);
        this.SSOrb9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.SSOrb9.setTextureSize(128, 128);
        this.SSOrb9.mirror = true;
        this.setRotation(this.SSOrb9, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final float rf1 = 1.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        final float upangle = 0.0f;
        float nextangle = 0.0f;
        final float newangle2 = 0.0f;
        final InfoRenderer r = null;
        final float pi4 = 1.570795f;
        newangle = MathHelper.cos(f2 * 2.0f * this.wingspeed) * 3.141593f * 0.12f * f1;
        nextangle = MathHelper.cos((f2 + 0.1f) * 2.0f * this.wingspeed) * 3.141593f * 0.12f * f1;
        final ModelRenderer orb1 = this.Orb1;
        orb1.rotateAngleX += 0.1f;
        if (this.Orb1.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb1;
            tmp2112_2109.rotateAngleX -= (float) 9.283185307179586;
        }
        final ModelRenderer orb2 = this.Orb2;
        orb2.rotateAngleX -= 0.05f;
        if (this.Orb2.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb2;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 8.283185307179586);
        }
        final ModelRenderer orb3 = this.Orb3;
        orb3.rotateAngleX -= 0.15f;
        if (this.Orb3.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb3;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 7.283185307179586);
        }
        final ModelRenderer orb4 = this.Orb4;
        orb4.rotateAngleX -= 0.15f;
        if (this.Orb4.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb4;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer orb5 = this.Orb5;
        orb5.rotateAngleX += 0.05f;
        if (this.Orb5.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb5;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 5.283185307179586);
        }
        final ModelRenderer orb6 = this.Orb6;
        orb6.rotateAngleX += 0.1f;
        if (this.Orb6.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb6;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 4.283185307179586);
        }
        final ModelRenderer orb7 = this.Orb7;
        orb7.rotateAngleX -= 0.1f;
        if (this.Orb7.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb7;
            tmp2112_2109.rotateAngleX -= (float) 3.283185307179586;
        }
        final ModelRenderer orb8 = this.Orb8;
        orb8.rotateAngleX -= 0.05f;
        if (this.Orb8.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb8;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 2.283185307179586);
        }
        final ModelRenderer orb9 = this.Orb9;
        orb9.rotateAngleX += 0.15f;
        if (this.Orb9.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.Orb9;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 1.283185307179586);
        }
        final ModelRenderer sOrb1 = this.SOrb1;
        sOrb1.rotateAngleX += 0.25f;
        if (this.SOrb1.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb1;
            tmp2112_2109.rotateAngleX -= (float) 2.283185307179586;
        }
        final ModelRenderer sOrb2 = this.SOrb2;
        sOrb2.rotateAngleX += 0.25f;
        if (this.SOrb2.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb2;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 3.283185307179586);
        }
        final ModelRenderer sOrb3 = this.SOrb3;
        sOrb3.rotateAngleX += 0.45f;
        if (this.SOrb3.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb3;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 8.283185307179586);
        }
        final ModelRenderer sOrb4 = this.SOrb4;
        sOrb4.rotateAngleX += 0.35f;
        if (this.SOrb4.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb4;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer sOrb5 = this.SOrb5;
        sOrb5.rotateAngleX += 0.45f;
        if (this.SOrb5.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb5;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 1.283185307179586);
        }
        final ModelRenderer sOrb6 = this.SOrb6;
        sOrb6.rotateAngleX += 0.25f;
        if (this.SOrb6.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb6;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 7.283185307179586);
        }
        final ModelRenderer sOrb7 = this.SOrb7;
        sOrb7.rotateAngleX += 0.35f;
        if (this.SOrb7.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb7;
            tmp2112_2109.rotateAngleX -= (float) 9.283185307179586;
        }
        final ModelRenderer sOrb8 = this.SOrb8;
        sOrb8.rotateAngleX += 0.45f;
        if (this.SOrb8.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb8;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 5.283185307179586);
        }
        final ModelRenderer sOrb9 = this.SOrb9;
        sOrb9.rotateAngleX += 0.25f;
        if (this.SOrb9.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SOrb9;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 3.283185307179586);
        }
        final ModelRenderer ssOrb1 = this.SSOrb1;
        ssOrb1.rotateAngleX += 0.65f;
        if (this.SSOrb1.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb1;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer ssOrb2 = this.SSOrb2;
        ssOrb2.rotateAngleX += 0.55f;
        if (this.SSOrb2.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb2;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer ssOrb3 = this.SSOrb3;
        ssOrb3.rotateAngleX += 0.75f;
        if (this.SSOrb3.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb3;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer ssOrb4 = this.SSOrb4;
        ssOrb4.rotateAngleX += 0.65f;
        if (this.SSOrb4.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb4;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer ssOrb5 = this.SSOrb5;
        ssOrb5.rotateAngleX += 0.75f;
        if (this.SSOrb5.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb5;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer ssOrb6 = this.SSOrb6;
        ssOrb6.rotateAngleX += 0.55f;
        if (this.SSOrb6.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb6;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer ssOrb7 = this.SSOrb7;
        ssOrb7.rotateAngleX += 0.75f;
        if (this.SSOrb7.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb7;
            tmp2112_2109.rotateAngleX -= (float) 6.283185307179586;
        }
        final ModelRenderer ssOrb8 = this.SSOrb8;
        ssOrb8.rotateAngleX += 0.65f;
        if (this.SSOrb8.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb8;
            tmp2112_2109.rotateAngleY = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        final ModelRenderer ssOrb9 = this.SSOrb9;
        ssOrb9.rotateAngleX += 0.55f;
        if (this.SSOrb9.rotateAngleX > 3.141592653589793) {
            final ModelRenderer tmp2112_2109 = this.SSOrb9;
            tmp2112_2109.rotateAngleZ = (float) (tmp2112_2109.rotateAngleX - 6.283185307179586);
        }
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 980.0f, 980.0f);
        this.Orb1.render(f5);
        this.Orb2.render(f5);
        this.Orb3.render(f5);
        this.Orb4.render(f5);
        this.Orb5.render(f5);
        this.Orb6.render(f5);
        this.Orb7.render(f5);
        this.Orb8.render(f5);
        this.Orb9.render(f5);
        this.SOrb1.render(f5);
        this.SOrb2.render(f5);
        this.SOrb3.render(f5);
        this.SOrb4.render(f5);
        this.SOrb5.render(f5);
        this.SOrb6.render(f5);
        this.SOrb7.render(f5);
        this.SOrb8.render(f5);
        this.SOrb9.render(f5);
        this.SSOrb1.render(f5);
        this.SSOrb2.render(f5);
        this.SSOrb3.render(f5);
        this.SSOrb4.render(f5);
        this.SSOrb5.render(f5);
        this.SSOrb6.render(f5);
        this.SSOrb7.render(f5);
        this.SSOrb8.render(f5);
        this.SSOrb9.render(f5);
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
