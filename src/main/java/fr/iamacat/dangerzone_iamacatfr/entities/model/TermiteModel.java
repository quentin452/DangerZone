package fr.iamacat.dangerzone_iamacatfr.entities.model;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

@SideOnly(Side.CLIENT)
public class TermiteModel extends ModelBase {

    ModelRenderer thorax;
    ModelRenderer thorax1;
    ModelRenderer thorax3;
    ModelRenderer abdomen;
    ModelRenderer abdomen1;
    ModelRenderer head;
    ModelRenderer jawsr;
    ModelRenderer jawsl;
    ModelRenderer llegtop1;
    ModelRenderer llegbot1;
    ModelRenderer llegtop2;
    ModelRenderer llegbot2;
    ModelRenderer llegtop3;
    ModelRenderer llegbot3;
    ModelRenderer rlegtop1;
    ModelRenderer rlegbot1;
    ModelRenderer rlegtop2;
    ModelRenderer rlegbot2;
    ModelRenderer rlegtop3;
    ModelRenderer rlegbot3;

    public TermiteModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        (this.thorax = new ModelRenderer((ModelBase) this, 22, 0)).addBox(0.0f, 0.0f, 0.0f, 3, 3, 3);
        this.thorax.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.thorax.setTextureSize(64, 32);
        this.thorax.mirror = true;
        this.setRotation(this.thorax, 0.0f, 0.0f, 0.0f);
        (this.thorax1 = new ModelRenderer((ModelBase) this, 18, 0)).addBox(1.0f, 1.0f, -1.0f, 1, 1, 1);
        this.thorax1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.thorax1.setTextureSize(64, 32);
        this.thorax1.mirror = true;
        this.setRotation(this.thorax1, 0.0f, 0.0f, 0.0f);
        (this.thorax3 = new ModelRenderer((ModelBase) this, 34, 0)).addBox(1.0f, 1.0f, 3.0f, 1, 1, 1);
        this.thorax3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.thorax3.setTextureSize(64, 32);
        this.thorax3.mirror = true;
        this.setRotation(this.thorax3, 0.0f, 0.0f, 0.0f);
        (this.abdomen = new ModelRenderer((ModelBase) this, 38, 0)).addBox(0.0f, 0.0f, 4.0f, 3, 3, 5);
        this.abdomen.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.abdomen.setTextureSize(64, 32);
        this.abdomen.mirror = true;
        this.setRotation(this.abdomen, 0.0f, 0.0f, 0.0f);
        (this.abdomen1 = new ModelRenderer((ModelBase) this, 54, 0)).addBox(1.0f, 1.0f, 9.0f, 1, 1, 1);
        this.abdomen1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.abdomen1.setTextureSize(64, 32);
        this.abdomen1.mirror = true;
        this.setRotation(this.abdomen1, 0.0f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 6, 0)).addBox(0.0f, -1.0f, -4.0f, 3, 3, 3);
        this.head.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.jawsr = new ModelRenderer((ModelBase) this, 0, 9)).addBox(-1.0f, 0.0f, -6.0f, 1, 1, 3);
        this.jawsr.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.jawsr.setTextureSize(64, 32);
        this.jawsr.mirror = true;
        this.setRotation(this.jawsr, 0.0f, 0.0f, 0.0f);
        (this.jawsl = new ModelRenderer((ModelBase) this, 0, 14)).addBox(3.0f, 0.0f, -6.0f, 1, 1, 3);
        this.jawsl.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.jawsl.setTextureSize(64, 32);
        this.jawsl.mirror = true;
        this.setRotation(this.jawsl, 0.0f, 0.0f, 0.0f);
        (this.llegtop1 = new ModelRenderer((ModelBase) this, 15, 10)).addBox(3.0f, 1.0f, 1.0f, 3, 1, 1);
        this.llegtop1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.llegtop1.setTextureSize(64, 32);
        this.llegtop1.mirror = true;
        this.setRotation(this.llegtop1, 0.0f, 0.0f, 0.3839724f);
        (this.llegbot1 = new ModelRenderer((ModelBase) this, 15, 19)).addBox(5.0f, -3.0f, 1.0f, 3, 1, 1);
        this.llegbot1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.llegbot1.setTextureSize(64, 32);
        this.llegbot1.mirror = true;
        this.setRotation(this.llegbot1, 0.0f, 0.0f, 1.064651f);
        (this.llegtop2 = new ModelRenderer((ModelBase) this, 15, 13)).addBox(3.0f, 1.0f, 2.0f, 3, 1, 1);
        this.llegtop2.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.llegtop2.setTextureSize(64, 32);
        this.llegtop2.mirror = true;
        this.setRotation(this.llegtop2, 0.0f, -0.2094395f, 0.3839724f);
        (this.llegbot2 = new ModelRenderer((ModelBase) this, 15, 22)).addBox(5.0f, -3.0f, 2.0f, 3, 1, 1);
        this.llegbot2.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.llegbot2.setTextureSize(64, 32);
        this.llegbot2.mirror = true;
        this.setRotation(this.llegbot2, 0.0f, -0.2268928f, 1.064651f);
        (this.llegtop3 = new ModelRenderer((ModelBase) this, 15, 16)).addBox(3.0f, 1.0f, 0.0f, 3, 1, 1);
        this.llegtop3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.llegtop3.setTextureSize(64, 32);
        this.llegtop3.mirror = true;
        this.setRotation(this.llegtop3, 0.0f, 0.3490659f, 0.3839724f);
        (this.llegbot3 = new ModelRenderer((ModelBase) this, 15, 25)).addBox(5.0f, -3.0f, 0.0f, 3, 1, 1);
        this.llegbot3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.llegbot3.setTextureSize(64, 32);
        this.llegbot3.mirror = true;
        this.setRotation(this.llegbot3, 0.0f, 0.3490659f, 1.064651f);
        (this.rlegtop1 = new ModelRenderer((ModelBase) this, 25, 10)).addBox(-4.0f, 2.0f, 1.0f, 3, 1, 1);
        this.rlegtop1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rlegtop1.setTextureSize(64, 32);
        this.rlegtop1.mirror = true;
        this.setRotation(this.rlegtop1, 0.0f, 0.0f, -0.4712389f);
        (this.rlegbot1 = new ModelRenderer((ModelBase) this, 25, 19)).addBox(-7.0f, 0.0f, 1.0f, 3, 1, 1);
        this.rlegbot1.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rlegbot1.setTextureSize(64, 32);
        this.rlegbot1.mirror = true;
        this.setRotation(this.rlegbot1, 0.0f, 0.0f, -0.9773844f);
        (this.rlegtop2 = new ModelRenderer((ModelBase) this, 25, 13)).addBox(-4.0f, 2.0f, 0.0f, 3, 1, 1);
        this.rlegtop2.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rlegtop2.setTextureSize(64, 32);
        this.rlegtop2.mirror = true;
        this.setRotation(this.rlegtop2, 0.0f, -0.5934119f, -0.4712389f);
        (this.rlegbot2 = new ModelRenderer((ModelBase) this, 25, 22)).addBox(-7.0f, 0.0f, 0.0f, 3, 1, 1);
        this.rlegbot2.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rlegbot2.setTextureSize(64, 32);
        this.rlegbot2.mirror = true;
        this.setRotation(this.rlegbot2, 0.0f, -0.5934119f, -0.9773844f);
        (this.rlegtop3 = new ModelRenderer((ModelBase) this, 25, 16)).addBox(-4.0f, 2.0f, 2.0f, 3, 1, 1);
        this.rlegtop3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rlegtop3.setTextureSize(64, 32);
        this.rlegtop3.mirror = true;
        this.setRotation(this.rlegtop3, 0.0f, 0.418879f, -0.4712389f);
        (this.rlegbot3 = new ModelRenderer((ModelBase) this, 25, 25)).addBox(-7.0f, 0.0f, 2.0f, 3, 1, 1);
        this.rlegbot3.setRotationPoint(0.0f, 17.0f, 0.0f);
        this.rlegbot3.setTextureSize(64, 32);
        this.rlegbot3.mirror = true;
        this.setRotation(this.rlegbot3, 0.0f, 0.418879f, -0.9773844f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
                       final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.llegtop1.rotateAngleX = MathHelper.cos(f2 * 2.7f) * 3.1415927f * 0.45f * f1;
        this.llegbot1.rotateAngleX = this.llegtop1.rotateAngleX;
        this.rlegtop2.rotateAngleX = this.llegtop1.rotateAngleX;
        this.rlegbot2.rotateAngleX = this.llegtop1.rotateAngleX;
        this.rlegtop3.rotateAngleX = this.llegtop1.rotateAngleX;
        this.rlegbot3.rotateAngleX = this.llegtop1.rotateAngleX;
        this.rlegtop1.rotateAngleX = -this.llegtop1.rotateAngleX;
        this.rlegbot1.rotateAngleX = -this.llegtop1.rotateAngleX;
        this.llegtop2.rotateAngleX = -this.llegtop1.rotateAngleX;
        this.llegbot2.rotateAngleX = -this.llegtop1.rotateAngleX;
        this.llegtop3.rotateAngleX = -this.llegtop1.rotateAngleX;
        this.llegbot3.rotateAngleX = -this.llegtop1.rotateAngleX;
        this.jawsl.rotateAngleY = MathHelper.cos(f2 * 0.4f) * 3.1415927f * 0.05f;
        this.jawsr.rotateAngleY = -this.jawsl.rotateAngleY;
        this.thorax.render(f5);
        this.thorax1.render(f5);
        this.thorax3.render(f5);
        this.abdomen.render(f5);
        this.abdomen1.render(f5);
        this.head.render(f5);
        this.jawsr.render(f5);
        this.jawsl.render(f5);
        this.llegtop1.render(f5);
        this.llegbot1.render(f5);
        this.llegtop2.render(f5);
        this.llegbot2.render(f5);
        this.llegtop3.render(f5);
        this.llegbot3.render(f5);
        this.rlegtop1.render(f5);
        this.rlegbot1.render(f5);
        this.rlegtop2.render(f5);
        this.rlegbot2.render(f5);
        this.rlegtop3.render(f5);
        this.rlegbot3.render(f5);
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
