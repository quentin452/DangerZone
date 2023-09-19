
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.ThunderHoovesInstance;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ThunderHoovesModel extends ModelBase {

    private float wingspeed;
    ModelRenderer Body;
    ModelRenderer LegLF;
    ModelRenderer LegRF;
    ModelRenderer LegLB;
    ModelRenderer LegRB;
    ModelRenderer Under;
    ModelRenderer Back;
    ModelRenderer Head;
    ModelRenderer Beard;
    ModelRenderer HornR;
    ModelRenderer HornL;
    ModelRenderer HeadBand;
    ModelRenderer HeadP1;
    ModelRenderer HeadP2;
    ModelRenderer HeadP3;
    ModelRenderer HeadP4;
    ModelRenderer HeadP5;
    ModelRenderer HeadP6;
    ModelRenderer FeatherR;
    ModelRenderer FeatherL;
    ModelRenderer Tail;

    public ThunderHoovesModel() {
        this.wingspeed = 0.8f;
        this.textureWidth = 2048;
        this.textureHeight = 2048;
        (this.Body = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 75, 50, 80);
        this.Body.setRotationPoint(-28.0f, -43.0f, -38.0f);
        this.Body.setTextureSize(2048, 2048);
        this.Body.mirror = true;
        this.setRotation(this.Body, 0.0f, 0.0f, 0.0f);
        (this.LegLF = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 17, 8);
        this.LegLF.setRotationPoint(36.0f, 7.0f, -36.0f);
        this.LegLF.setTextureSize(2048, 2048);
        this.LegLF.mirror = true;
        this.setRotation(this.LegLF, 0.0f, 0.0f, 0.0f);
        (this.LegRF = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 17, 8);
        this.LegRF.setRotationPoint(-24.0f, 7.0f, -31.0f);
        this.LegRF.setTextureSize(2048, 2048);
        this.LegRF.mirror = true;
        this.setRotation(this.LegRF, 0.0f, 0.0f, 0.0f);
        (this.LegLB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 17, 8);
        this.LegLB.setRotationPoint(37.0f, 7.0f, 31.0f);
        this.LegLB.setTextureSize(2048, 2048);
        this.LegLB.mirror = true;
        this.setRotation(this.LegLB, 0.0f, 0.0f, 0.0f);
        (this.LegRB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 8, 17, 8);
        this.LegRB.setRotationPoint(-24.0f, 7.0f, 31.0f);
        this.LegRB.setTextureSize(2048, 2048);
        this.LegRB.mirror = true;
        this.setRotation(this.LegRB, 0.0f, 0.0f, 0.0f);
        (this.Under = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 50, 2, 50);
        this.Under.setRotationPoint(-14.0f, 7.0f, -23.0f);
        this.Under.setTextureSize(2048, 2048);
        this.Under.mirror = true;
        this.setRotation(this.Under, 0.0f, 0.0f, 0.0f);
        (this.Back = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 50, 2, 50);
        this.Back.setRotationPoint(-14.0f, -45.0f, -23.0f);
        this.Back.setTextureSize(2048, 2048);
        this.Back.mirror = true;
        this.setRotation(this.Back, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 600, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 20, 20);
        this.Head.setRotationPoint(-2.0f, -25.0f, -57.0f);
        this.Head.setTextureSize(2048, 2048);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Beard = new ModelRenderer((ModelBase) this, 300, 200)).addBox(0.0f, 0.0f, 0.0f, 10, 15, 2);
        this.Beard.setRotationPoint(3.0f, -6.0f, -43.0f);
        this.Beard.setTextureSize(2048, 2048);
        this.Beard.mirror = true;
        this.setRotation(this.Beard, 0.0f, 0.0f, 0.0f);
        (this.HornR = new ModelRenderer((ModelBase) this, 200, 200)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.HornR.setRotationPoint(1.0f, -22.0f, -64.0f);
        this.HornR.setTextureSize(2048, 2048);
        this.HornR.mirror = true;
        this.setRotation(this.HornR, 0.0f, 0.0f, 0.0f);
        (this.HornL = new ModelRenderer((ModelBase) this, 200, 200)).addBox(0.0f, 0.0f, 0.0f, 1, 1, 8);
        this.HornL.setRotationPoint(15.0f, -22.0f, -64.0f);
        this.HornL.setTextureSize(2048, 2048);
        this.HornL.mirror = true;
        this.setRotation(this.HornL, 0.0f, 0.0f, 0.0f);
        (this.HeadBand = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 20, 3, 1);
        this.HeadBand.setRotationPoint(-2.0f, -25.0f, -57.0f);
        this.HeadBand.setTextureSize(2048, 2048);
        this.HeadBand.mirror = true;
        this.setRotation(this.HeadBand, 0.0f, 0.0f, 0.0f);
        (this.HeadP1 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.HeadP1.setRotationPoint(0.0f, -36.0f, -54.0f);
        this.HeadP1.setTextureSize(2048, 2048);
        this.HeadP1.mirror = true;
        this.setRotation(this.HeadP1, 0.0f, 0.2792527f, 0.0f);
        (this.HeadP2 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.HeadP2.setRotationPoint(3.0f, -36.0f, -55.0f);
        this.HeadP2.setTextureSize(2048, 2048);
        this.HeadP2.mirror = true;
        this.setRotation(this.HeadP2, 0.0f, 0.0f, 0.0f);
        (this.HeadP3 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.HeadP3.setRotationPoint(6.0f, -36.0f, -55.0f);
        this.HeadP3.setTextureSize(2048, 2048);
        this.HeadP3.mirror = true;
        this.setRotation(this.HeadP3, 0.0f, 0.0f, 0.0f);
        (this.HeadP4 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.HeadP4.setRotationPoint(9.0f, -36.0f, -55.0f);
        this.HeadP4.setTextureSize(2048, 2048);
        this.HeadP4.mirror = true;
        this.setRotation(this.HeadP4, 0.0f, 0.0f, 0.0f);
        (this.HeadP5 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.HeadP5.setRotationPoint(12.0f, -36.0f, -55.0f);
        this.HeadP5.setTextureSize(2048, 2048);
        this.HeadP5.mirror = true;
        this.setRotation(this.HeadP5, 0.0f, 0.0f, 0.0f);
        (this.HeadP6 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(0.0f, 0.0f, 0.0f, 2, 12, 1);
        this.HeadP6.setRotationPoint(15.0f, -36.0f, -54.0f);
        this.HeadP6.setTextureSize(2048, 2048);
        this.HeadP6.mirror = true;
        this.setRotation(this.HeadP6, 0.0f, -0.2792527f, 0.0f);
        (this.FeatherR = new ModelRenderer((ModelBase) this, 500, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 20, 5);
        this.FeatherR.setRotationPoint(-3.0f, -20.0f, -54.0f);
        this.FeatherR.setTextureSize(2048, 2048);
        this.FeatherR.mirror = true;
        this.setRotation(this.FeatherR, 0.0f, 0.0f, 0.0f);
        (this.FeatherL = new ModelRenderer((ModelBase) this, 500, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 20, 5);
        this.FeatherL.setRotationPoint(18.0f, -20.0f, -54.0f);
        this.FeatherL.setTextureSize(2048, 2048);
        this.FeatherL.mirror = true;
        this.setRotation(this.FeatherL, 0.0f, 0.0f, 0.0f);
        (this.Tail = new ModelRenderer((ModelBase) this, 0, 200)).addBox(0.0f, 0.0f, 0.0f, 8, 8, 6);
        this.Tail.setRotationPoint(5.0f, -15.0f, 42.0f);
        this.Tail.setTextureSize(2048, 2048);
        this.Tail.mirror = true;
        this.setRotation(this.Tail, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final ThunderHoovesInstance e = (ThunderHoovesInstance) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.141593f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.LegLF.rotateAngleX = newangle;
        this.LegRB.rotateAngleX = newangle;
        this.LegRF.rotateAngleX = -newangle;
        this.LegLB.rotateAngleX = -newangle;
        this.Body.render(f5);
        this.LegLF.render(f5);
        this.LegRF.render(f5);
        this.LegLB.render(f5);
        this.LegRB.render(f5);
        this.Under.render(f5);
        this.Back.render(f5);
        this.Head.render(f5);
        this.Beard.render(f5);
        this.HornR.render(f5);
        this.HornL.render(f5);
        this.HeadBand.render(f5);
        this.HeadP1.render(f5);
        this.HeadP2.render(f5);
        this.HeadP3.render(f5);
        this.HeadP4.render(f5);
        this.HeadP5.render(f5);
        this.HeadP6.render(f5);
        this.FeatherR.render(f5);
        this.FeatherL.render(f5);
        this.Tail.render(f5);
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
