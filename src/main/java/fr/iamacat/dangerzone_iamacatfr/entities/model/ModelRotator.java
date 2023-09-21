
package fr.iamacat.dangerzone_iamacatfr.entities.model;


import fr.iamacat.dangerzone_iamacatfr.entities.entity.Rotator;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelRotator extends ModelBase {

    float wingspeed;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;

    public ModelRotator(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.Shape1 = new ModelRenderer((ModelBase) this, 0, 12)).addBox(-2.0f, 3.9f, 0.0f, 4, 1, 1);
        this.Shape1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
        (this.Shape2 = new ModelRenderer((ModelBase) this, 0, 7)).addBox(-4.0f, 7.6f, 0.0f, 8, 2, 2);
        this.Shape2.setRotationPoint(0.0f, 0.0f, -0.5f);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-7.0f, 13.7f, 0.0f, 14, 3, 3);
        this.Shape3.setRotationPoint(0.0f, 0.0f, -1.0f);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Rotator r = (Rotator) entity;
        RenderInfo ri = null;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        ri = r.getRenderInfo();
        GL11.glRotatef(ri.rf1, 1.0f, 0.0f, 0.0f);
        for (int i = 0; i < 8; ++i) {
            this.Shape1.rotateAngleZ = newangle;
            this.Shape1.render(f5);
            newangle += 0.7853982f;
        }
        GL11.glRotatef(-ri.rf1, 1.0f, 0.0f, 0.0f);
        newangle = 0.0f;
        GL11.glRotatef(ri.rf1, 0.0f, 1.0f, 0.0f);
        for (int i = 0; i < 8; ++i) {
            this.Shape2.rotateAngleZ = newangle;
            this.Shape2.render(f5);
            newangle += 0.7853982f;
        }
        GL11.glRotatef(-ri.rf1, 0.0f, 1.0f, 0.0f);
        newangle = 0.0f;
        GL11.glRotatef(ri.rf1, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 8; ++i) {
            this.Shape3.rotateAngleZ = newangle;
            this.Shape3.render(f5);
            newangle += 0.7853982f;
        }
        GL11.glRotatef(-ri.rf1, 0.0f, 0.0f, 1.0f);
        final RenderInfo renderInfo = ri;
        renderInfo.rf1 += 2.0f;
        if (ri.rf1 > 359.0) {
            ri.rf1 = 0.0f;
        }
        r.setRenderInfo(ri);
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
