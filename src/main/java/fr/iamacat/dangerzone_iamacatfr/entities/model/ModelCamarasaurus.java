
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Camarasaurus;

public class ModelCamarasaurus extends ModelBase {

    private float wingspeed;
    ModelRenderer Body1;
    ModelRenderer Body2;
    ModelRenderer Body3;
    ModelRenderer Body4;
    ModelRenderer Tail0;
    ModelRenderer Neck1;
    ModelRenderer Neck2;
    ModelRenderer Neck3;
    ModelRenderer Head1;
    ModelRenderer Head2;
    ModelRenderer Tail1;
    ModelRenderer Tail2;
    ModelRenderer Tail3;
    ModelRenderer BLegupleft;
    ModelRenderer FLegupleft;
    ModelRenderer BLegupright;
    ModelRenderer FLegupright;
    ModelRenderer BLegdownright;
    ModelRenderer FLegdownleft;
    ModelRenderer FLegdownright;
    ModelRenderer BLegdownleft;

    public ModelCamarasaurus(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 256;
        (this.Body1 = new ModelRenderer((ModelBase) this, 0, 135)).addBox(-6.0f, 0.0f, 0.0f, 12, 12, 12);
        this.Body1.setRotationPoint(0.0f, -1.0f, 0.0f);
        this.Body1.setTextureSize(256, 256);
        this.Body1.mirror = true;
        this.setRotation(this.Body1, 0.0f, 0.0f, 0.0f);
        (this.Body2 = new ModelRenderer((ModelBase) this, 0, 160)).addBox(-5.0f, 0.0f, 0.0f, 10, 10, 6);
        this.Body2.setRotationPoint(0.0f, -2.0f, -4.0f);
        this.Body2.setTextureSize(256, 256);
        this.Body2.mirror = true;
        this.setRotation(this.Body2, -0.1858931f, 0.0f, 0.0f);
        (this.Body3 = new ModelRenderer((ModelBase) this, 0, 177)).addBox(-4.0f, 0.0f, 0.0f, 8, 8, 4);
        this.Body3.setRotationPoint(0.0f, -3.0f, -6.0f);
        this.Body3.setTextureSize(256, 256);
        this.Body3.mirror = true;
        this.setRotation(this.Body3, -0.3346075f, 0.0f, 0.0f);
        (this.Body4 = new ModelRenderer((ModelBase) this, 0, 120)).addBox(-5.0f, 0.0f, 0.0f, 10, 10, 4);
        this.Body4.setRotationPoint(0.0f, 0.0f, 11.0f);
        this.Body4.setTextureSize(256, 256);
        this.Body4.mirror = true;
        this.setRotation(this.Body4, 0.0f, 0.0f, 0.0f);
        (this.Tail0 = new ModelRenderer((ModelBase) this, 0, 107)).addBox(-3.0f, -2.0f, 0.0f, 6, 6, 6);
        this.Tail0.setRotationPoint(0.0f, 3.0f, 14.0f);
        this.Tail0.setTextureSize(256, 256);
        this.Tail0.mirror = true;
        this.setRotation(this.Tail0, -0.0743572f, 0.0f, 0.0f);
        (this.Neck1 = new ModelRenderer((ModelBase) this, 0, 190)).addBox(-3.0f, 0.0f, 0.0f, 6, 6, 5);
        this.Neck1.setRotationPoint(0.0f, -4.0f, -9.0f);
        this.Neck1.setTextureSize(256, 256);
        this.Neck1.mirror = true;
        this.setRotation(this.Neck1, -0.4089647f, 0.0f, 0.0f);
        (this.Neck2 = new ModelRenderer((ModelBase) this, 0, 202)).addBox(-2.0f, 0.0f, -6.0f, 4, 4, 7);
        this.Neck2.setRotationPoint(0.0f, -3.0f, -9.0f);
        this.Neck2.setTextureSize(256, 256);
        this.Neck2.mirror = true;
        this.setRotation(this.Neck2, -0.5948578f, 0.0f, 0.0f);
        (this.Neck3 = new ModelRenderer((ModelBase) this, 0, 214)).addBox(-2.0f, -2.0f, -12.0f, 4, 4, 13);
        this.Neck3.setRotationPoint(0.0f, -5.0f, -15.0f);
        this.Neck3.setTextureSize(256, 256);
        this.Neck3.mirror = true;
        this.setRotation(this.Neck3, -0.8179294f, 0.0f, 0.0f);
        (this.Head1 = new ModelRenderer((ModelBase) this, 0, 232)).addBox(-4.0f, -3.0f, -6.0f, 8, 6, 6);
        this.Head1.setRotationPoint(0.0f, -13.0f, -22.0f);
        this.Head1.setTextureSize(256, 256);
        this.Head1.mirror = true;
        this.setRotation(this.Head1, -0.1115358f, 0.0f, 0.0f);
        (this.Head2 = new ModelRenderer((ModelBase) this, 0, 245)).addBox(-3.0f, -2.0f, -4.0f, 6, 4, 4);
        this.Head2.setRotationPoint(0.0f, -13.0f, -27.0f);
        this.Head2.setTextureSize(256, 256);
        this.Head2.mirror = true;
        this.setRotation(this.Head2, 0.0f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 0, 93)).addBox(-2.0f, -3.0f, 0.0f, 4, 4, 9);
        this.Tail1.setRotationPoint(0.0f, 5.0f, 19.0f);
        this.Tail1.setTextureSize(256, 256);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, -0.1115358f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 0, 82)).addBox(-1.0f, -1.0f, 0.0f, 2, 2, 8);
        this.Tail2.setRotationPoint(0.0f, 4.0f, 26.0f);
        this.Tail2.setTextureSize(256, 256);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, -0.0743572f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 0, 73)).addBox(-0.5f, -0.5f, 0.0f, 1, 1, 7);
        this.Tail3.setRotationPoint(0.0f, 4.5f, 34.0f);
        this.Tail3.setTextureSize(256, 256);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, -0.0371786f, 0.0f, 0.0f);
        (this.BLegupleft = new ModelRenderer((ModelBase) this, 49, 157)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 6);
        this.BLegupleft.setRotationPoint(2.0f, 9.0f, 7.0f);
        this.BLegupleft.setTextureSize(256, 256);
        this.BLegupleft.mirror = true;
        this.setRotation(this.BLegupleft, -0.1487195f, 0.0f, 0.0f);
        (this.FLegupleft = new ModelRenderer((ModelBase) this, 49, 141)).addBox(0.0f, 0.0f, -6.0f, 6, 9, 6);
        this.FLegupleft.setRotationPoint(2.0f, 8.0f, 2.0f);
        this.FLegupleft.setTextureSize(256, 256);
        this.FLegupleft.mirror = true;
        this.setRotation(this.FLegupleft, 0.0f, 0.0f, 0.0f);
        (this.BLegupright = new ModelRenderer((ModelBase) this, 49, 126)).addBox(-6.0f, 0.0f, 0.0f, 6, 8, 6);
        this.BLegupright.setRotationPoint(-2.0f, 9.0f, 7.0f);
        this.BLegupright.setTextureSize(256, 256);
        this.BLegupright.mirror = true;
        this.setRotation(this.BLegupright, -0.1487144f, 0.0f, 0.0f);
        (this.FLegupright = new ModelRenderer((ModelBase) this, 49, 110)).addBox(-6.0f, 0.0f, -6.0f, 6, 9, 6);
        this.FLegupright.setRotationPoint(-2.0f, 8.0f, 2.0f);
        this.FLegupright.setTextureSize(256, 256);
        this.FLegupright.mirror = true;
        this.setRotation(this.FLegupright, 0.0f, 0.0f, 0.0f);
        (this.BLegdownright = new ModelRenderer((ModelBase) this, 115, 157)).addBox(-5.0f, 7.0f, -1.0f, 5, 8, 5);
        this.BLegdownright.setRotationPoint(-2.0f, 9.0f, 7.0f);
        this.BLegdownright.setTextureSize(256, 256);
        this.BLegdownright.mirror = true;
        this.setRotation(this.BLegdownright, 0.0f, 0.0f, 0.0f);
        (this.FLegdownleft = new ModelRenderer((ModelBase) this, 94, 143)).addBox(0.0f, 8.0f, -6.0f, 5, 8, 5);
        this.FLegdownleft.setRotationPoint(2.0f, 8.0f, 2.0f);
        this.FLegdownleft.setTextureSize(256, 256);
        this.FLegdownleft.mirror = true;
        this.setRotation(this.FLegdownleft, 0.0f, 0.0f, 0.0f);
        (this.FLegdownright = new ModelRenderer((ModelBase) this, 94, 157)).addBox(-5.0f, 8.0f, -6.0f, 5, 8, 5);
        this.FLegdownright.setRotationPoint(-2.0f, 8.0f, 2.0f);
        this.FLegdownright.setTextureSize(256, 256);
        this.FLegdownright.mirror = true;
        this.setRotation(this.FLegdownright, 0.0f, 0.0f, 0.0f);
        (this.BLegdownleft = new ModelRenderer((ModelBase) this, 115, 143)).addBox(0.0f, 7.0f, -1.0f, 5, 8, 5);
        this.BLegdownleft.setRotationPoint(2.0f, 9.0f, 7.0f);
        this.BLegdownleft.setTextureSize(256, 256);
        this.BLegdownleft.mirror = true;
        this.setRotation(this.BLegdownleft, 0.0f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Camarasaurus c = (Camarasaurus) entity;
        float hf = 0.0f;
        float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        this.FLegupleft.rotateAngleX = newangle;
        this.FLegdownleft.rotateAngleX = newangle;
        this.FLegupright.rotateAngleX = -newangle;
        this.FLegdownright.rotateAngleX = -newangle;
        this.BLegupleft.rotateAngleX = -0.15f - newangle;
        this.BLegdownleft.rotateAngleX = -newangle;
        this.BLegupright.rotateAngleX = -0.15f + newangle;
        this.BLegdownright.rotateAngleX = newangle;
        hf = c.getCamarasaurusHealth() / c.getMaxHealth();
        newangle = MathHelper.cos(f2 * 1.5f * this.wingspeed * hf) * 3.1415927f * 0.25f * hf;
        if (c.isSitting()) {
            newangle = 0.0f;
        }
        this.Tail0.rotateAngleY = newangle * 0.25f;
        this.Tail1.rotationPointZ = this.Tail0.rotationPointZ + (float) Math.cos(this.Tail0.rotateAngleY) * 5.0f;
        this.Tail1.rotationPointX = this.Tail0.rotationPointX + (float) Math.sin(this.Tail0.rotateAngleY) * 5.0f;
        this.Tail1.rotateAngleY = newangle * 0.5f;
        this.Tail2.rotationPointZ = this.Tail1.rotationPointZ + (float) Math.cos(this.Tail1.rotateAngleY) * 8.0f;
        this.Tail2.rotationPointX = this.Tail1.rotationPointX + (float) Math.sin(this.Tail1.rotateAngleY) * 8.0f;
        this.Tail2.rotateAngleY = newangle * 0.75f;
        this.Tail3.rotationPointZ = this.Tail2.rotationPointZ + (float) Math.cos(this.Tail2.rotateAngleY) * 7.0f;
        this.Tail3.rotationPointX = this.Tail2.rotationPointX + (float) Math.sin(this.Tail2.rotateAngleY) * 7.0f;
        this.Tail3.rotateAngleY = newangle * 1.0f;
        this.Neck1.rotateAngleY = (float) Math.toRadians(f3) * 0.125f;
        this.Neck2.rotationPointZ = this.Neck1.rotationPointZ;
        this.Neck2.rotationPointX = this.Neck1.rotationPointX;
        this.Neck2.rotateAngleY = (float) Math.toRadians(f3) * 0.25f;
        this.Neck3.rotationPointZ = this.Neck2.rotationPointZ - (float) Math.cos(this.Neck2.rotateAngleY) * 6.0f;
        this.Neck3.rotationPointX = this.Neck2.rotationPointX - (float) Math.sin(this.Neck2.rotateAngleY) * 6.0f;
        this.Neck3.rotateAngleY = (float) Math.toRadians(f3) * 0.38f;
        this.Head1.rotationPointZ = this.Neck3.rotationPointZ - (float) Math.cos(this.Neck3.rotateAngleY) * 7.0f;
        this.Head1.rotationPointX = this.Neck3.rotationPointX - (float) Math.sin(this.Neck3.rotateAngleY) * 7.0f;
        this.Head1.rotateAngleY = (float) Math.toRadians(f3);
        this.Head2.rotationPointZ = this.Head1.rotationPointZ - (float) Math.cos(this.Head1.rotateAngleY) * 5.0f;
        this.Head2.rotationPointX = this.Head1.rotationPointX - (float) Math.sin(this.Head1.rotateAngleY) * 5.0f;
        this.Head2.rotateAngleY = (float) Math.toRadians(f3);
        this.Body1.render(f5);
        this.Body2.render(f5);
        this.Body3.render(f5);
        this.Body4.render(f5);
        this.Tail0.render(f5);
        this.Neck1.render(f5);
        this.Neck2.render(f5);
        this.Neck3.render(f5);
        this.Head1.render(f5);
        this.Head2.render(f5);
        this.Tail1.render(f5);
        this.Tail2.render(f5);
        this.Tail3.render(f5);
        this.FLegupleft.render(f5);
        this.FLegdownleft.render(f5);
        this.FLegupright.render(f5);
        this.FLegdownright.render(f5);
        this.BLegupleft.render(f5);
        this.BLegdownright.render(f5);
        this.BLegupright.render(f5);
        this.BLegdownleft.render(f5);
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
