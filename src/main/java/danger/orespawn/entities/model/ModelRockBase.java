
package danger.orespawn.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

import danger.orespawn.entities.entityinstance.RockBase;

public class ModelRockBase extends ModelBase {

    private float wingspeed;
    ModelRenderer RockShape1;
    ModelRenderer RockShape2;
    ModelRenderer RockShape3;
    ModelRenderer RockSmallShape2;
    ModelRenderer RockSmallShape1;
    ModelRenderer RockTNTShape1;
    ModelRenderer RockTNTShape2;
    ModelRenderer RockTNTShape3;
    ModelRenderer RockTNTShape4;
    ModelRenderer RockSpikeyShape1;
    ModelRenderer RockSpikeyShape2;
    ModelRenderer RockSpikeyShape3;
    ModelRenderer CrystalShape1;
    ModelRenderer CrystalShape2;
    ModelRenderer CrystalShape3a;
    ModelRenderer CrystalShape3b;
    ModelRenderer CrystalShape3c;
    ModelRenderer CrystalShape3d;
    ModelRenderer CrystalShape4a;
    ModelRenderer CrystalShape4b;
    ModelRenderer CrystalShape4c;
    ModelRenderer CrystalShape4d;

    public ModelRockBase(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 64;
        (this.RockShape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-3.0f, 0.0f, -1.0f, 6, 1, 2);
        this.RockShape1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockShape1.setTextureSize(64, 32);
        this.RockShape1.mirror = true;
        this.setRotation(this.RockShape1, 0.0f, 0.0f, 0.0f);
        (this.RockShape2 = new ModelRenderer((ModelBase) this, 0, 4)).addBox(-3.0f, 0.0f, 1.0f, 3, 1, 1);
        this.RockShape2.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockShape2.setTextureSize(64, 64);
        this.RockShape2.mirror = true;
        this.setRotation(this.RockShape2, 0.0f, 0.0f, 0.0f);
        (this.RockShape3 = new ModelRenderer((ModelBase) this, 0, 7)).addBox(0.0f, 0.0f, -2.0f, 2, 1, 1);
        this.RockShape3.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockShape3.setTextureSize(64, 64);
        this.RockShape3.mirror = true;
        this.setRotation(this.RockShape3, 0.0f, 0.0f, 0.0f);
        (this.RockSmallShape2 = new ModelRenderer((ModelBase) this, 0, 4)).addBox(-2.0f, 0.0f, 0.0f, 3, 1, 1);
        this.RockSmallShape2.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockSmallShape2.setTextureSize(64, 64);
        this.RockSmallShape2.mirror = true;
        this.setRotation(this.RockSmallShape2, 0.0f, 0.0f, 0.0f);
        (this.RockSmallShape1 = new ModelRenderer((ModelBase) this, 0, 7)).addBox(0.0f, 0.0f, -1.0f, 2, 1, 1);
        this.RockSmallShape1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockSmallShape1.setTextureSize(64, 64);
        this.RockSmallShape1.mirror = true;
        this.setRotation(this.RockSmallShape1, 0.0f, 0.0f, 0.0f);
        (this.RockTNTShape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-3.0f, 0.0f, -1.0f, 6, 1, 2);
        this.RockTNTShape1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockTNTShape1.setTextureSize(64, 64);
        this.RockTNTShape1.mirror = true;
        this.setRotation(this.RockTNTShape1, 0.0f, 0.0f, 0.0f);
        (this.RockTNTShape2 = new ModelRenderer((ModelBase) this, 0, 4)).addBox(-3.0f, 0.0f, 1.0f, 3, 1, 1);
        this.RockTNTShape2.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockTNTShape2.setTextureSize(64, 64);
        this.RockTNTShape2.mirror = true;
        this.setRotation(this.RockTNTShape2, 0.0f, 0.0f, 0.0f);
        (this.RockTNTShape3 = new ModelRenderer((ModelBase) this, 0, 7)).addBox(0.0f, 0.0f, -2.0f, 2, 1, 1);
        this.RockTNTShape3.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockTNTShape3.setTextureSize(64, 64);
        this.RockTNTShape3.mirror = true;
        this.setRotation(this.RockTNTShape3, 0.0f, 0.0f, 0.0f);
        (this.RockTNTShape4 = new ModelRenderer((ModelBase) this, 0, 10)).addBox(-4.0f, 0.0f, -2.0f, 3, 1, 3);
        this.RockTNTShape4.setRotationPoint(0.0f, 22.0f, 0.0f);
        this.RockTNTShape4.setTextureSize(64, 64);
        this.RockTNTShape4.mirror = true;
        this.setRotation(this.RockTNTShape4, 0.0f, 0.0f, 0.0f);
        (this.RockSpikeyShape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-3.0f, 0.0f, -1.0f, 6, 1, 2);
        this.RockSpikeyShape1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockSpikeyShape1.setTextureSize(64, 64);
        this.RockSpikeyShape1.mirror = true;
        this.setRotation(this.RockSpikeyShape1, 0.0f, 0.0f, 0.0f);
        (this.RockSpikeyShape2 = new ModelRenderer((ModelBase) this, 0, 4)).addBox(-4.0f, 0.0f, -1.0f, 3, 1, 1);
        this.RockSpikeyShape2.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockSpikeyShape2.setTextureSize(64, 64);
        this.RockSpikeyShape2.mirror = true;
        this.setRotation(this.RockSpikeyShape2, 0.0f, 1.570796f, 0.0f);
        (this.RockSpikeyShape3 = new ModelRenderer((ModelBase) this, 0, 7)).addBox(1.0f, 0.0f, 1.0f, 2, 1, 1);
        this.RockSpikeyShape3.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.RockSpikeyShape3.setTextureSize(64, 64);
        this.RockSpikeyShape3.mirror = true;
        this.setRotation(this.RockSpikeyShape3, 0.0f, 1.570796f, 0.0f);
        (this.CrystalShape1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, -4.0f, -1.0f, 2, 5, 2);
        this.CrystalShape1.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape1.setTextureSize(64, 64);
        this.CrystalShape1.mirror = true;
        this.setRotation(this.CrystalShape1, 0.0f, 0.0f, 0.0f);
        (this.CrystalShape2 = new ModelRenderer((ModelBase) this, 10, 0)).addBox(-0.5f, -7.0f, -0.5f, 1, 3, 1);
        this.CrystalShape2.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape2.setTextureSize(64, 64);
        this.CrystalShape2.mirror = true;
        this.setRotation(this.CrystalShape2, 0.0f, 0.0f, 0.0f);
        (this.CrystalShape3a = new ModelRenderer((ModelBase) this, 0, 8)).addBox(-1.0f, -5.0f, -1.0f, 1, 5, 1);
        this.CrystalShape3a.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape3a.setTextureSize(64, 64);
        this.CrystalShape3a.mirror = true;
        this.setRotation(this.CrystalShape3a, 0.5410521f, 0.0f, 0.0f);
        (this.CrystalShape3b = new ModelRenderer((ModelBase) this, 0, 8)).addBox(0.0f, -5.0f, 0.0f, 1, 5, 1);
        this.CrystalShape3b.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape3b.setTextureSize(64, 64);
        this.CrystalShape3b.mirror = true;
        this.setRotation(this.CrystalShape3b, -0.5410521f, 0.0f, 0.0f);
        (this.CrystalShape3c = new ModelRenderer((ModelBase) this, 0, 8)).addBox(0.0f, -5.0f, -1.0f, 1, 5, 1);
        this.CrystalShape3c.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape3c.setTextureSize(64, 64);
        this.CrystalShape3c.mirror = true;
        this.setRotation(this.CrystalShape3c, 0.0f, 0.0f, 0.5410521f);
        (this.CrystalShape3d = new ModelRenderer((ModelBase) this, 0, 8)).addBox(-1.0f, -5.0f, 0.0f, 1, 5, 1);
        this.CrystalShape3d.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape3d.setTextureSize(64, 64);
        this.CrystalShape3d.mirror = true;
        this.setRotation(this.CrystalShape3d, 0.0f, 0.0f, -0.5410521f);
        (this.CrystalShape4a = new ModelRenderer((ModelBase) this, 0, 16)).addBox(0.0f, -3.0f, -1.0f, 1, 3, 1);
        this.CrystalShape4a.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape4a.setTextureSize(64, 64);
        this.CrystalShape4a.mirror = true;
        this.setRotation(this.CrystalShape4a, 1.308997f, 0.0f, 0.0f);
        (this.CrystalShape4b = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, -3.0f, 0.0f, 1, 3, 1);
        this.CrystalShape4b.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape4b.setTextureSize(64, 64);
        this.CrystalShape4b.mirror = true;
        this.setRotation(this.CrystalShape4b, -1.308997f, 0.0f, 0.0f);
        (this.CrystalShape4c = new ModelRenderer((ModelBase) this, 0, 16)).addBox(0.0f, -3.0f, 0.0f, 1, 3, 1);
        this.CrystalShape4c.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape4c.setTextureSize(64, 64);
        this.CrystalShape4c.mirror = true;
        this.setRotation(this.CrystalShape4c, 0.0f, 0.0f, 1.308997f);
        (this.CrystalShape4d = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, -3.0f, -1.0f, 1, 3, 1);
        this.CrystalShape4d.setRotationPoint(0.0f, 23.0f, 0.0f);
        this.CrystalShape4d.setTextureSize(64, 64);
        this.CrystalShape4d.mirror = true;
        this.setRotation(this.CrystalShape4d, 0.0f, 0.0f, -1.308997f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final RockBase r = (RockBase) entity;
        int rt = 0;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        rt = r.getRockType();
        if (rt < 1 || rt > 12) {
            return;
        }
        if (rt == 1) {
            this.RockSmallShape1.render(f5);
            this.RockSmallShape2.render(f5);
        } else if (rt == 7) {
            this.RockSpikeyShape1.render(f5);
            this.RockSpikeyShape2.render(f5);
            this.RockSpikeyShape3.render(f5);
        } else if (rt == 8) {
            this.RockTNTShape1.render(f5);
            this.RockTNTShape2.render(f5);
            this.RockTNTShape3.render(f5);
            this.RockTNTShape4.render(f5);
        } else if (rt >= 9 && rt <= 12) {
            GL11.glPushMatrix();
            GL11.glEnable(2977);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0f, 240.0f);
            GL11.glColor4f(0.75f, 0.75f, 0.75f, 0.55f);
            this.CrystalShape1.render(f5);
            this.CrystalShape2.render(f5);
            this.CrystalShape3a.render(f5);
            this.CrystalShape3b.render(f5);
            this.CrystalShape3c.render(f5);
            this.CrystalShape3d.render(f5);
            this.CrystalShape4a.render(f5);
            this.CrystalShape4b.render(f5);
            this.CrystalShape4c.render(f5);
            this.CrystalShape4d.render(f5);
            GL11.glDisable(3042);
            GL11.glPopMatrix();
        } else {
            this.RockShape1.render(f5);
            this.RockShape2.render(f5);
            this.RockShape3.render(f5);
        }
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
