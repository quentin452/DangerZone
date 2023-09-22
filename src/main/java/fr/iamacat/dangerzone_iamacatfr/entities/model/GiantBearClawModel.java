
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;

import org.lwjgl.opengl.GL11;

public class GiantBearClawModel extends ModelBase {

    ModelRenderer BearPaw;
    ModelRenderer Wrist;
    ModelRenderer Claw1;
    ModelRenderer Claw2;
    ModelRenderer Claw3;
    ModelRenderer Claw4;
    ModelRenderer Claw5;
    ModelRenderer Claw6;
    ModelRenderer Claw7;
    ModelRenderer Claw8;

    public GiantBearClawModel() {
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.BearPaw = new ModelRenderer((ModelBase) this, 160, 0)).addBox(30.0f, -50.0f, 0.0f, 40, 40, 40);
        this.BearPaw.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.BearPaw.setTextureSize(512, 256);
        this.BearPaw.mirror = true;
        this.setRotation(this.BearPaw, 0.0f, 0.1745329f, 0.0f);
        (this.Wrist = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, -50.0f, -5.0f, 40, 40, 40);
        this.Wrist.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Wrist.setTextureSize(512, 256);
        this.Wrist.mirror = true;
        this.setRotation(this.Wrist, 0.0f, 0.0f, 0.0f);
        (this.Claw1 = new ModelRenderer((ModelBase) this, 0, 160)).addBox(68.0f, -16.0f, 35.0f, 35, 5, 5);
        this.Claw1.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw1.setTextureSize(512, 256);
        this.Claw1.mirror = true;
        this.setRotation(this.Claw1, 0.0f, 0.1919862f, 0.0f);
        (this.Claw2 = new ModelRenderer((ModelBase) this, 0, 120)).addBox(68.0f, -38.0f, 35.0f, 35, 5, 5);
        this.Claw2.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw2.setTextureSize(512, 256);
        this.Claw2.mirror = true;
        this.setRotation(this.Claw2, 0.0f, 0.1919862f, 0.0f);
        (this.Claw3 = new ModelRenderer((ModelBase) this, 0, 140)).addBox(68.0f, -27.0f, 35.0f, 35, 5, 5);
        this.Claw3.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw3.setTextureSize(512, 256);
        this.Claw3.mirror = true;
        this.setRotation(this.Claw3, 0.0f, 0.1919862f, 0.0f);
        (this.Claw4 = new ModelRenderer((ModelBase) this, 0, 100)).addBox(68.0f, -49.0f, 35.0f, 35, 5, 5);
        this.Claw4.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw4.setTextureSize(512, 256);
        this.Claw4.mirror = true;
        this.setRotation(this.Claw4, 0.0f, 0.1919862f, 0.0f);
        (this.Claw5 = new ModelRenderer((ModelBase) this, 0, 180)).addBox(92.0f, -48.0f, 50.0f, 35, 3, 5);
        this.Claw5.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw5.setTextureSize(512, 256);
        this.Claw5.mirror = true;
        this.setRotation(this.Claw5, 0.0f, 0.3490659f, 0.0f);
        (this.Claw6 = new ModelRenderer((ModelBase) this, 0, 200)).addBox(92.0f, -37.0f, 50.0f, 35, 3, 5);
        this.Claw6.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw6.setTextureSize(512, 256);
        this.Claw6.mirror = true;
        this.setRotation(this.Claw6, 0.0f, 0.3490659f, 0.0f);
        (this.Claw7 = new ModelRenderer((ModelBase) this, 0, 220)).addBox(92.0f, -26.0f, 50.0f, 35, 3, 5);
        this.Claw7.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw7.setTextureSize(512, 256);
        this.Claw7.mirror = true;
        this.setRotation(this.Claw7, 0.0f, 0.3490659f, 0.0f);
        (this.Claw8 = new ModelRenderer((ModelBase) this, 0, 240)).addBox(92.0f, -15.0f, 50.0f, 35, 3, 5);
        this.Claw8.setRotationPoint(0.0f, 20.0f, 0.0f);
        this.Claw8.setTextureSize(512, 256);
        this.Claw8.mirror = true;
        this.setRotation(this.Claw8, 0.0f, 0.3490659f, 0.0f);
    }

    public void render() {
        final float f5 = 1.0f;
        GL11.glPushMatrix();
        GL11.glEnable(2977);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glColor4f(3.75f, 3.75f, 3.75f, 0.45f);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 940.0f, 1240.0f);
        this.BearPaw.render(f5);
        this.Wrist.render(f5);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
        this.Claw1.render(f5);
        this.Claw2.render(f5);
        this.Claw3.render(f5);
        this.Claw4.render(f5);
        this.Claw5.render(f5);
        this.Claw6.render(f5);
        this.Claw7.render(f5);
        this.Claw8.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
