package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CrabModel extends ModelBase {

    // fields
    ModelRenderer body;
    ModelRenderer helmetBase;
    ModelRenderer Leg8;
    ModelRenderer Leg6;
    ModelRenderer Leg4;
    ModelRenderer rightArm;
    ModelRenderer Leg5;
    ModelRenderer Leg3;
    ModelRenderer clawbase;
    ModelRenderer clawtop;
    ModelRenderer clawbottom;
    ModelRenderer righteye;
    ModelRenderer lefteye;

    public ModelRenderer helmet;
    public ModelRenderer righthorn1;
    public ModelRenderer righthorn2;
    public ModelRenderer lefthorn1;
    public ModelRenderer lefthorn2;

    public CrabModel() {
        textureWidth = 64;
        textureHeight = 32;

        body = new ModelRenderer(this, 32, 4);
        body.addBox(-2.5F, -2.5F, -5F, 5, 5, 5);
        body.setRotationPoint(0F, 19F, 0F);

        helmetBase = new ModelRenderer(this, 0, 0);
        helmetBase.addBox(0, 0, 0, 0, 0, 0);
        helmetBase.setRotationPoint(0F, 18F, 0F);
        this.helmetBase.rotateAngleX = -100F / (180F / (float) Math.PI);
        this.helmetBase.rotateAngleY = -30F / (180F / (float) Math.PI);

        this.helmet = new ModelRenderer(this, 0, 14);
        this.helmet.addBox(-3.5F, -11.0F, -3.5F, 7, 11, 7);
        this.helmet.rotateAngleY = 45F / (180F / (float) Math.PI);

        this.righthorn1 = new ModelRenderer(this, 28, 14);
        this.righthorn1.addBox(-6F, -1.5F, -1.5F, 7, 3, 3);
        this.righthorn1.setRotationPoint(-3.5F, -9F, 0.0F);
        this.righthorn1.rotateAngleY = -15F / (180F / (float) Math.PI);
        this.righthorn1.rotateAngleZ = 10F / (180F / (float) Math.PI);

        this.righthorn2 = new ModelRenderer(this, 28, 20);
        this.righthorn2.addBox(-3.0F, -1.0F, -1.0F, 3, 2, 2);
        this.righthorn2.setRotationPoint(-5.5F, 0.0F, 0.0F);
        this.righthorn2.rotateAngleY = -15F / (180F / (float) Math.PI);
        this.righthorn2.rotateAngleZ = 10F / (180F / (float) Math.PI);

        this.righthorn1.addChild(righthorn2);

        this.lefthorn1 = new ModelRenderer(this, 28, 14);
        this.lefthorn1.mirror = true;
        this.lefthorn1.addBox(-1F, -1.5F, -1.5F, 7, 3, 3);
        this.lefthorn1.setRotationPoint(3.5F, -9F, 0.0F);
        this.lefthorn1.rotateAngleY = 15F / (180F / (float) Math.PI);
        this.lefthorn1.rotateAngleZ = -10F / (180F / (float) Math.PI);

        this.lefthorn2 = new ModelRenderer(this, 28, 20);
        this.lefthorn2.addBox(0.0F, -1.0F, -1.0F, 3, 2, 2);
        this.lefthorn2.setRotationPoint(5.5F, 0.0F, 0.0F);
        this.lefthorn2.rotateAngleY = 15F / (180F / (float) Math.PI);
        this.lefthorn2.rotateAngleZ = -10F / (180F / (float) Math.PI);

        this.lefthorn1.addChild(lefthorn2);

        this.helmetBase.addChild(helmet);
        this.helmetBase.addChild(righthorn1);
        this.helmetBase.addChild(lefthorn1);

        Leg8 = new ModelRenderer(this, 18, 0);
        Leg8.addBox(-1F, -1F, -1F, 8, 2, 2);
        Leg8.setRotationPoint(3F, 20F, -3F);
        setRotation(Leg8, 0F, 0.5759587F, 0.1919862F);

        Leg6 = new ModelRenderer(this, 18, 0);
        Leg6.addBox(-1F, -1F, -1F, 8, 2, 2);
        Leg6.setRotationPoint(3F, 20F, -2F);
        setRotation(Leg6, 0F, 0.2792527F, 0.1919862F);

        Leg4 = new ModelRenderer(this, 18, 0);
        Leg4.addBox(-1F, -1F, -1F, 8, 2, 2);
        Leg4.setRotationPoint(3F, 20F, -1F);
        setRotation(Leg4, 0F, -0.2792527F, 0.1919862F);

        rightArm = new ModelRenderer(this, 38, 0);
        rightArm.addBox(-7F, -1F, -1F, 8, 2, 2);
        rightArm.setRotationPoint(-3F, 20F, -3F);
        setRotation(rightArm, 0F, -1.319531F, -0.1919862F);

        Leg5 = new ModelRenderer(this, 18, 0);
        Leg5.addBox(-7F, -1F, -1F, 8, 2, 2);
        Leg5.setRotationPoint(-3F, 20F, -2F);
        setRotation(Leg5, 0F, -0.2792527F, -0.1919862F);

        Leg3 = new ModelRenderer(this, 18, 0);
        Leg3.addBox(-7F, -1F, -1F, 8, 2, 2);
        Leg3.setRotationPoint(-3F, 20F, -1F);
        setRotation(Leg3, 0F, 0.2792527F, -0.1919862F);

        clawbase = new ModelRenderer(this, 0, 0);
        clawbase.addBox(0F, -1.5F, -1F, 3, 3, 2);
        clawbase.setRotationPoint(-6F, 0F, -0.5F);
        setRotation(clawbase, 0.0F, (float) (Math.PI / 2.0F), 0);

        clawtop = new ModelRenderer(this, 0, 5);
        clawtop.addBox(0F, -0.5F, -1F, 3, 1, 2);
        clawtop.setRotationPoint(3F, -1F, 0F);
        setRotation(clawtop, 0F, 0F, -0.1858931F);

        clawbottom = new ModelRenderer(this, 0, 8);
        clawbottom.addBox(0F, -0.5F, -1F, 3, 2, 2);
        clawbottom.setRotationPoint(3F, 0F, 0F);
        setRotation(clawbottom, 0F, 0F, 0.2602503F);

        this.clawbase.addChild(clawtop);
        this.clawbase.addChild(clawbottom);

        this.rightArm.addChild(clawbase);

        righteye = new ModelRenderer(this, 10, 0);
        righteye.addBox(-1F, -3F, -1F, 2, 3, 2);
        righteye.setRotationPoint(-1F, -1F, -4F);
        setRotation(righteye, (float) (Math.PI / 4.0F), 0.0F, -(float) (Math.PI / 4.0F));

        lefteye = new ModelRenderer(this, 10, 0);
        lefteye.addBox(-1F, -3F, -1F, 2, 3, 2);
        lefteye.setRotationPoint(1F, -1F, -4F);
        setRotation(lefteye, (float) (Math.PI / 4.0F), 0.0F, (float) (Math.PI / 4.0F));

        this.body.addChild(righteye);
        this.body.addChild(lefteye);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        this.setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);
        body.render(par7);
        helmetBase.render(par7);
        Leg8.render(par7);
        Leg6.render(par7);
        Leg4.render(par7);
        rightArm.render(par7);
        Leg5.render(par7);
        Leg3.render(par7);
        // clawbase.render(par7);
        // clawtop.render(par7);
        // clawbottom.render(par7);
        // righteye.render(par7);
        // lefteye.render(par7);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    /**
     * Sets the model's various rotation angles. For bipeds, par1 and par2 are used for animating the movement of arms
     * and legs, where par1 represents the time(so that arms and legs swing back and forth) and par2 represents how
     * "far" arms and legs can swing at most.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6,
        Entity par7Entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, par7Entity);

        this.body.rotateAngleY = par4 / (180F / (float) Math.PI);
        this.body.rotateAngleX = par5 / (180F / (float) Math.PI);
        float f6 = ((float) Math.PI / 4F);
        // this.Leg1.rotateAngleZ = -f6;
        // this.Leg2.rotateAngleZ = f6;
        this.Leg3.rotateAngleZ = -f6 * 0.74F;
        this.Leg4.rotateAngleZ = f6 * 0.74F;
        this.Leg5.rotateAngleZ = -f6 * 0.74F;
        this.Leg6.rotateAngleZ = f6 * 0.74F;
        // this.Leg7.rotateAngleZ = -f6;
        this.Leg8.rotateAngleZ = f6;
        float f7 = -0.0F;
        float f8 = 0.3926991F;
        // this.Leg1.rotateAngleY = f8 * 2.0F + f7;
        // this.Leg2.rotateAngleY = -f8 * 2.0F - f7;
        this.Leg3.rotateAngleY = f8 * 1.0F + f7;
        this.Leg4.rotateAngleY = -f8 * 1.0F - f7;
        this.Leg5.rotateAngleY = -f8 * 1.0F + f7;
        this.Leg6.rotateAngleY = f8 * 1.0F - f7;
        // this.Leg7.rotateAngleY = -f8 * 2.0F + f7;
        this.Leg8.rotateAngleY = f8 * 2.0F - f7;
        float f10 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + (float) Math.PI) * 0.4F) * par2;
        float f11 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float) Math.PI / 2F)) * 0.4F) * par2;
        float f12 = -(MathHelper.cos(par1 * 0.6662F * 2.0F + ((float) Math.PI * 3F / 2F)) * 0.4F) * par2;
        float f14 = Math.abs(MathHelper.sin(par1 * 0.6662F + (float) Math.PI) * 0.4F) * par2;
        float f15 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float) Math.PI / 2F)) * 0.4F) * par2;
        float f16 = Math.abs(MathHelper.sin(par1 * 0.6662F + ((float) Math.PI * 3F / 2F)) * 0.4F) * par2;
        // this.Leg1.rotateAngleY += f9;
        // this.Leg2.rotateAngleY += -f9;
        this.Leg3.rotateAngleY += f10;
        this.Leg4.rotateAngleY += -f10;
        this.Leg5.rotateAngleY += f11;
        this.Leg6.rotateAngleY += -f11;
        // this.Leg7.rotateAngleY += f12;
        this.Leg8.rotateAngleY += -f12;
        // this.Leg1.rotateAngleZ += f13;
        // this.Leg2.rotateAngleZ += -f13;
        this.Leg3.rotateAngleZ += f14;
        this.Leg4.rotateAngleZ += -f14;
        this.Leg5.rotateAngleZ += f15;
        this.Leg6.rotateAngleZ += -f15;
        // this.Leg7.rotateAngleZ += f16;
        this.Leg8.rotateAngleZ += -f16;

        // swing right arm as if it were an arm, not a leg
        this.rightArm.rotateAngleY = -1.319531F;
        this.rightArm.rotateAngleY += MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 2.0F * par2 * 0.5F;

    }

}
