package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class BeeModel extends ModelBase {

    private ModelRenderer eye;
    private ModelRenderer shell;

    private ModelRenderer clawNobRight;
    private ModelRenderer clawNobLeft;
    private ModelRenderer clawLeftLower;
    private ModelRenderer clawRightLower;

    private ModelRenderer legMR;
    private ModelRenderer legML;
    private ModelRenderer legBL;
    private ModelRenderer legBR;
    private ModelRenderer legUL;
    private ModelRenderer legUR;

    private ModelRenderer legTipML;
    private ModelRenderer legTipMR;
    private ModelRenderer legTipBL;
    private ModelRenderer legTipBR;
    private ModelRenderer legTipUL;
    private ModelRenderer legTipUR;

    public BeeModel() {
        textureWidth = 128;
        textureHeight = 64;

        shell = new ModelRenderer(this, 0, 0);
        shell.addBox(0F, 0F, 0F, 0, 0, 0);
        shell.setRotationPoint(0F, -1F, 0F);

        eye = new ModelRenderer(this, 20, 7);
        eye.addBox(-3F, -1F, -3F, 6, 6, 6);
        shell.addChild(eye);

        ModelRenderer shellTop = new ModelRenderer(this, 60, 0);
        shellTop.addBox(-9F, -9F, -7F, 18, 3, 16);
        shell.addChild(shellTop);

        ModelRenderer shellBottom = new ModelRenderer(this, 64, 20);
        shellBottom.addBox(-8F, 10F, -5F, 16, 2, 14);
        shell.addChild(shellBottom);

        ModelRenderer shellTopMid = new ModelRenderer(this, 10, 40);
        shellTopMid.addBox(-11F, -6F, -9F, 22, 3, 20);
        shell.addChild(shellTopMid);

        ModelRenderer shellBack = new ModelRenderer(this, 0, 20);
        shellBack.addBox(-12F, -3F, 8F, 24, 10, 5);
        shell.addChild(shellBack);

        ModelRenderer shellBottomMid = new ModelRenderer(this, 10, 40);
        shellBottomMid.addBox(-11F, 7F, -9F, 22, 3, 20);
        shell.addChild(shellBottomMid);

        ModelRenderer toothUR = new ModelRenderer(this, 24, 0);
        toothUR.addBox(-8F, -3F, -9F, 6, 3, 3);
        shell.addChild(toothUR);

        ModelRenderer toothUL = new ModelRenderer(this, 24, 0);
        toothUL.addBox(2F, -3F, -9F, 6, 3, 3);
        shell.addChild(toothUL);

        ModelRenderer toothLR = new ModelRenderer(this, 24, 0);
        toothLR.addBox(-10F, 4F, -9F, 6, 3, 3);
        shell.addChild(toothLR);

        ModelRenderer toothLL = new ModelRenderer(this, 24, 0);
        toothLL.addBox(3F, 4F, -9F, 6, 3, 3);
        shell.addChild(toothLL);

        ModelRenderer shellLeftThickness = new ModelRenderer(this, 96, 40);
        shellLeftThickness.addBox(10F, -3F, -2F, 4, 10, 10);
        shell.addChild(shellLeftThickness);

        ModelRenderer shellRightThickness = new ModelRenderer(this, 96, 40);
        shellRightThickness.addBox(-14F, -3F, -2F, 4, 10, 10);
        shell.addChild(shellRightThickness);

        ModelRenderer shellRightThin = new ModelRenderer(this, 80, 40);
        shellRightThin.addBox(-12F, -3F, -5F, 4, 10, 3);
        shell.addChild(shellRightThin);

        ModelRenderer shellLeftThin = new ModelRenderer(this, 80, 40);
        shellLeftThin.addBox(8F, -3F, -5F, 4, 10, 3);
        shell.addChild(shellLeftThin);

        clawNobRight = new ModelRenderer(this, 0, 10);
        clawNobRight.addBox(-13F, 12F, -5F, 4, 4, 4);
        clawNobRight.rotateAngleX = -0.5948578F;
        shell.addChild(clawNobRight);

        clawNobLeft = new ModelRenderer(this, 0, 10);
        clawNobLeft.addBox(8F, 12F, -5F, 4, 4, 4);
        clawNobLeft.rotateAngleX = -0.5948578F;
        shell.addChild(clawNobLeft);

        ModelRenderer clawArmRight = new ModelRenderer(this, 48, 0);
        clawArmRight.addBox(-12F, 16F, -3F, 2, 8, 2);
        clawNobRight.addChild(clawArmRight);

        ModelRenderer clawArmLeft = new ModelRenderer(this, 48, 0);
        clawArmLeft.addBox(9F, 16F, -3F, 2, 8, 2);
        clawNobLeft.addChild(clawArmLeft);

        ModelRenderer clawLeftUpper = new ModelRenderer(this, 0, 38);
        clawLeftUpper.addBox(10F, 24F, -3F, 5, 7, 5);
        clawArmLeft.addChild(clawLeftUpper);

        clawLeftLower = new ModelRenderer(this, 0, 52);
        clawLeftLower.addBox(8F, 24F, -3F, 1, 5, 4);
        clawArmLeft.addChild(clawLeftLower);

        ModelRenderer clawRightUpper = new ModelRenderer(this, 0, 38);
        clawRightUpper.addBox(-16F, 24F, -3F, 5, 7, 5);
        clawArmRight.addChild(clawRightUpper);

        clawRightLower = new ModelRenderer(this, 0, 52);
        clawRightLower.addBox(-10F, 24F, -3F, 1, 5, 4);
        clawArmRight.addChild(clawRightLower);

        legMR = new ModelRenderer(this, 0, 0);
        legMR.addBox(-18F, 0F, 4F, 6, 2, 2);
        legMR.rotateAngleZ = -1.067F;
        shell.addChild(legMR);

        legTipMR = new ModelRenderer(this, 0, 0);
        legTipMR.addBox(-22F, 0F, 4F, 4, 1, 1);
        legMR.addChild(legTipMR);

        legML = new ModelRenderer(this, 0, 0);
        legML.addBox(12F, 0F, 4F, 6, 2, 2);
        legML.rotateAngleZ = 1.067F;
        shell.addChild(legML);

        legTipML = new ModelRenderer(this, 0, 0);
        legTipML.addBox(18F, 0F, 4F, 4, 1, 1);
        legML.addChild(legTipML);

        legBL = new ModelRenderer(this, 0, 0);
        legBL.addBox(14F, 0F, 1F, 6, 2, 2);
        legBL.rotateAngleZ = 0.7346075F;
        shell.addChild(legBL);

        legTipBL = new ModelRenderer(this, 0, 0);
        legTipBL.addBox(20F, 0F, 1F, 4, 1, 1);
        legBL.addChild(legTipBL);

        legBR = new ModelRenderer(this, 0, 0);
        legBR.addBox(-20F, 0F, 1F, 6, 2, 2);
        legBR.rotateAngleZ = -0.7346075F;
        shell.addChild(legBR);

        legTipBR = new ModelRenderer(this, 0, 0);
        legTipBR.addBox(-24F, 0F, 1F, 4, 1, 1);
        legBR.addChild(legTipBR);

        legUL = new ModelRenderer(this, 0, 0);
        legUL.addBox(11F, 0F, -1F, 6, 2, 2);
        legUL.rotateAngleZ = 1.2346075F;
        shell.addChild(legUL);

        legTipUL = new ModelRenderer(this, 0, 0);
        legTipUL.addBox(17F, 0F, -1F, 4, 1, 1);
        legUL.addChild(legTipUL);

        legUR = new ModelRenderer(this, 0, 0);
        legUR.addBox(-17F, 0F, -1F, 6, 2, 2);
        legUR.rotateAngleZ = -1.2346075F;
        shell.addChild(legUR);

        legTipUR = new ModelRenderer(this, 0, 0);
        legTipUR.addBox(-21F, 0F, -1F, 4, 1, 1);
        legUR.addChild(legTipUR);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        shell.render(f5);
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        if (!(entity instanceof BeeInstance)) return;

        BeeInstance eny = (BeeInstance) entity;

        clawNobRight.rotateAngleX = -0.5948578F;
        clawNobLeft.rotateAngleX = -0.5948578F;
        clawNobRight.offsetY = 0.0F;
        clawNobLeft.offsetY = 0.0F;
        clawNobRight.offsetZ = 0.0F;
        clawNobLeft.offsetZ = 0.0F;
        clawNobRight.rotateAngleZ = 0.0F;
        clawNobLeft.rotateAngleZ = 0.0F;

        shell.rotateAngleY = 0.0F;
        shell.rotateAngleX = 0.0F;
        shell.rotateAngleZ = 0.0F;

        shell.offsetY = 0.0F;

        eye.rotateAngleY = f3 / (180F / (float) Math.PI);
        eye.rotateAngleX = f4 / (180F / (float) Math.PI);
        eye.rotateAngleZ = 0.0F;

        legBL.rotateAngleZ = 0.7346075F + this.simplifyAngle(eny.ticksExisted + 13, 40.0F) * -0.0615F;
        legTipBL.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 13, 40.0F) * -0.019F;
        legTipBL.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 13, 40.0F) * 0.01275F;

        legBR.rotateAngleZ = -0.7346075F + this.simplifyAngle(eny.ticksExisted - 13, 40.0F) * 0.0615F;
        legTipBR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 13, 40.0F) * 0.019F;
        legTipBR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 13, 40.0F) * -0.01275F;

        legML.rotateAngleZ = 1.067F + this.simplifyAngle(eny.ticksExisted + 33, 40.0F) * -0.0615F;
        legTipML.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 33, 40.0F) * -0.019F;
        legTipML.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 33, 40.0F) * 0.01275F;

        legMR.rotateAngleZ = -1.067F + this.simplifyAngle(eny.ticksExisted - 33, 40.0F) * 0.0615F;
        legTipMR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 33, 40.0F) * 0.019F;
        legTipMR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 33, 40.0F) * -0.01275F;

        legUL.rotateAngleZ = 1.2346075F + this.simplifyAngle(eny.ticksExisted + 17, 40.0F) * -0.0615F;
        legTipUL.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 17, 40.0F) * -0.019F;
        legTipUL.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 17, 40.0F) * 0.01275F;

        legUR.rotateAngleZ = -1.2346075F + this.simplifyAngle(eny.ticksExisted - 17, 40.0F) * 0.0615F;
        legTipUR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 17, 40.0F) * 0.019F;
        legTipUR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 17, 40.0F) * -0.01275F;

        clawNobRight.rotateAngleZ = 0.055F + this.simplifyAngle(f, 40.0F) * f1 * -0.105F;
        clawNobLeft.rotateAngleZ = -0.055F + this.simplifyAngle(f, 40.0F) * f1 * 0.105F;

        if (eny.getHurtTime() > 0) {
            clawNobRight.rotateAngleX = -0.825F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * 0.425F;
            clawNobLeft.rotateAngleX = -0.825F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * 0.425F;
            clawNobRight.offsetY = 0.225F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * -0.225F;
            clawNobRight.offsetZ = 0.115F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * -0.115F;
            clawNobLeft.offsetY = 0.225F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * -0.225F;
            clawNobLeft.offsetZ = 0.115F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * -0.115F;

            clawNobRight.rotateAngleZ = 0.125F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * -0.125F;
            clawNobLeft.rotateAngleZ = -0.125F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * 0.125F;

            shell.rotateAngleX = -0.115F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * 0.115F;
            shell.rotateAngleZ = -0.065F + this.simplifyAngle(eny.getHurtTime(), 10.0F) * 0.065F;

            eye.rotateAngleY = MathHelper.cos(eny.getHurtTime() + eny.getEntityId());
            eye.rotateAngleZ = MathHelper.sin(eny.getHurtTime() - eny.getEntityId());
            eye.rotateAngleX = MathHelper.sin(eny.getHurtTime());
        } else {
            if (eny.getAttackTime() > 0) {
                shell.rotateAngleZ = -0.065F + this.simplifyAngle(eny.getAttackTime(), 10.0F) * 0.165F;

                clawNobLeft.rotateAngleX = -0.865F + this.simplifyAngle(eny.getAttackTime(), 10.0F) * 0.465F;
                clawNobLeft.offsetY = 0.235F + this.simplifyAngle(eny.getAttackTime(), 10.0F) * -0.235F;
            } else {
                if (eny.getThunderstormTicks() > 0) {
                    shell.rotateAngleX = -0.45F;
                    clawNobRight.offsetY = 0.425F;
                    clawNobLeft.offsetY = 0.425F;
                    clawNobRight.offsetZ = 0.215F;
                    clawNobLeft.offsetZ = 0.215F;

                    clawNobLeft.rotateAngleX = -1.45F + MathHelper.cos(eny.ticksExisted + 10294) * 0.045F;
                    clawNobLeft.rotateAngleY = MathHelper.cos(eny.ticksExisted + 42) * 0.045F;

                    clawNobRight.rotateAngleX = -1.45F + MathHelper.sin(eny.ticksExisted + 5498418) * 0.045F;
                    clawNobRight.rotateAngleY = MathHelper.sin(eny.ticksExisted + 16481) * 0.045F;

                    legBL.rotateAngleZ = 0.7346075F + this.simplifyAngle(eny.ticksExisted + 13, 4.0F) * -0.0615F;
                    legTipBL.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 13, 4.0F) * -0.019F;
                    legTipBL.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 13, 4.0F) * 0.01275F;

                    legBR.rotateAngleZ = -0.7346075F + this.simplifyAngle(eny.ticksExisted - 13, 4.0F) * 0.0615F;
                    legTipBR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 13, 4.0F) * 0.019F;
                    legTipBR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 13, 4.0F) * -0.01275F;

                    legML.rotateAngleZ = 1.067F + this.simplifyAngle(eny.ticksExisted + 33, 4.0F) * -0.0615F;
                    legTipML.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 33, 4.0F) * -0.019F;
                    legTipML.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 33, 4.0F) * 0.01275F;

                    legMR.rotateAngleZ = -1.067F + this.simplifyAngle(eny.ticksExisted - 33, 4.0F) * 0.0615F;
                    legTipMR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 33, 4.0F) * 0.019F;
                    legTipMR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 33, 4.0F) * -0.01275F;

                    legUL.rotateAngleZ = 1.2346075F + this.simplifyAngle(eny.ticksExisted + 17, 4.0F) * -0.0615F;
                    legTipUL.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 17, 4.0F) * -0.019F;
                    legTipUL.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 17, 4.0F) * 0.01275F;

                    legUR.rotateAngleZ = -1.2346075F + this.simplifyAngle(eny.ticksExisted - 17, 4.0F) * 0.0615F;
                    legTipUR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 17, 4.0F) * 0.019F;
                    legTipUR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 17, 4.0F) * -0.01275F;
                } else {
                    if (eny.getDarkEnergyTicks() > 0) {
                        shell.rotateAngleZ = 0.0475F + this.simplifyAngle(eny.ticksExisted, 5.0F) * -0.095F;
                        clawNobLeft.rotateAngleZ = 0.0475F + this.simplifyAngle(eny.ticksExisted - 3, 5.0F) * -0.095F;
                        clawNobRight.rotateAngleZ = 0.0475F + this.simplifyAngle(eny.ticksExisted + 3, 5.0F) * -0.095F;

                        clawNobLeft.rotateAngleX = -1.45F + MathHelper.cos(eny.ticksExisted + 10294) * 0.045F;
                        clawNobLeft.rotateAngleY = MathHelper.cos(eny.ticksExisted + 42) * 0.045F;

                        clawNobRight.rotateAngleX = -1.45F + MathHelper.sin(eny.ticksExisted + 5498418) * 0.045F;
                        clawNobRight.rotateAngleY = MathHelper.sin(eny.ticksExisted + 16481) * 0.045F;

                        clawNobRight.offsetY = 0.425F;
                        clawNobLeft.offsetY = 0.425F;
                        clawNobRight.offsetZ = 0.215F;
                        clawNobLeft.offsetZ = 0.215F;

                        legBL.rotateAngleZ = 0.7346075F + this.simplifyAngle(eny.ticksExisted + 13, 4.0F) * -0.0615F;
                        legTipBL.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 13, 4.0F) * -0.019F;
                        legTipBL.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 13, 4.0F) * 0.01275F;

                        legBR.rotateAngleZ = -0.7346075F + this.simplifyAngle(eny.ticksExisted - 13, 4.0F) * 0.0615F;
                        legTipBR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 13, 4.0F) * 0.019F;
                        legTipBR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 13, 4.0F) * -0.01275F;

                        legML.rotateAngleZ = 1.067F + this.simplifyAngle(eny.ticksExisted + 33, 4.0F) * -0.0615F;
                        legTipML.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 33, 4.0F) * -0.019F;
                        legTipML.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 33, 4.0F) * 0.01275F;

                        legMR.rotateAngleZ = -1.067F + this.simplifyAngle(eny.ticksExisted - 33, 4.0F) * 0.0615F;
                        legTipMR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 33, 4.0F) * 0.019F;
                        legTipMR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 33, 4.0F) * -0.01275F;

                        legUL.rotateAngleZ = 1.2346075F + this.simplifyAngle(eny.ticksExisted + 17, 4.0F) * -0.0615F;
                        legTipUL.rotateAngleZ = 0.00745F + this.simplifyAngle(eny.ticksExisted + 17, 4.0F) * -0.019F;
                        legTipUL.offsetZ = -0.01275F + this.simplifyAngle(eny.ticksExisted + 17, 4.0F) * 0.01275F;

                        legUR.rotateAngleZ = -1.2346075F + this.simplifyAngle(eny.ticksExisted - 17, 4.0F) * 0.0615F;
                        legTipUR.rotateAngleZ = -0.00745F + this.simplifyAngle(eny.ticksExisted - 17, 4.0F) * 0.019F;
                        legTipUR.offsetZ = 0.01275F + this.simplifyAngle(eny.ticksExisted - 17, 4.0F) * -0.01275F;
                    } else {
                        if (eny.getTractorBeamTicks() > 0) {
                            clawNobRight.rotateAngleZ = 0.556F;
                            clawNobRight.offsetY = 0.956F;
                            clawNobRight.offsetX = 0.115F;
                            clawNobRight.offsetZ = 0.267F;

                            clawNobLeft.rotateAngleZ = -0.556F;
                            clawNobLeft.offsetY = 0.956F;
                            clawNobLeft.offsetX = -0.115F;
                            clawNobLeft.offsetZ = 0.267F;

                            eye.rotateAngleZ = MathHelper.cos(eny.getTractorBeamTicks());

                            clawNobLeft.rotateAngleX = -1.45F + MathHelper.cos(eny.ticksExisted + 10294) * 0.045F;
                            clawNobLeft.rotateAngleY = MathHelper.cos(eny.ticksExisted + 42) * 0.045F;

                            clawNobRight.rotateAngleX = -1.45F + MathHelper.sin(eny.ticksExisted + 5498418) * 0.045F;
                            clawNobRight.rotateAngleY = MathHelper.sin(eny.ticksExisted + 16481) * 0.045F;

                            legBL.rotateAngleZ = 0.7346075F;
                            legTipBL.rotateAngleZ = 0.0F;
                            legTipBL.offsetZ = 0.0F;

                            legBR.rotateAngleZ = -0.7346075F;
                            legTipBR.rotateAngleZ = 0.0F;
                            legTipBR.offsetZ = 0.0F;

                            legML.rotateAngleZ = 1.067F;
                            legTipML.rotateAngleZ = 0.0F;
                            legTipML.offsetZ = 0.0F;

                            legMR.rotateAngleZ = -1.067F;
                            legTipMR.rotateAngleZ = 0.0F;
                            legTipMR.offsetZ = 0.0F;

                            legUL.rotateAngleZ = 1.2346075F;
                            legTipUL.rotateAngleZ = 0.00745F;
                            legTipUL.offsetZ = 0.0F;

                            legUR.rotateAngleZ = -1.2346075F;
                            legTipUR.rotateAngleZ = 0.0F;
                            legTipUR.offsetZ = 0.0F;
                        } else {
                            if (eny.getSlamTicks() > 0) {
                                shell.offsetY = -0.4F + this.simplifyAngle(eny.ticksExisted, 40.0F) * 0.8F;

                                clawNobRight.rotateAngleX = -0.825F
                                    + this.simplifyAngle(eny.ticksExisted, 40.0F) * 0.425F;
                                clawNobLeft.rotateAngleX = -0.825F
                                    + this.simplifyAngle(eny.ticksExisted, 40.0F) * 0.425F;
                                clawNobRight.offsetY = 0.425F + this.simplifyAngle(eny.ticksExisted, 40.0F) * -0.425F;
                                clawNobRight.offsetZ = 0.215F + this.simplifyAngle(eny.ticksExisted, 40.0F) * -0.215F;
                                clawNobLeft.offsetY = 0.425F + this.simplifyAngle(eny.ticksExisted, 40.0F) * -0.425F;
                                clawNobLeft.offsetZ = 0.215F + this.simplifyAngle(eny.ticksExisted, 40.0F) * -0.215F;

                                clawNobRight.rotateAngleZ = 0.125F
                                    + this.simplifyAngle(eny.ticksExisted, 40.0F) * -0.125F;
                                clawNobLeft.rotateAngleZ = -0.125F
                                    + this.simplifyAngle(eny.ticksExisted, 40.0F) * 0.125F;

                                shell.rotateAngleX = -0.115F + this.simplifyAngle(eny.ticksExisted, 40.0F) * 0.115F;
                                shell.rotateAngleZ = -0.065F + this.simplifyAngle(eny.ticksExisted, 40.0F) * 0.065F;
                            }
                        }
                    }
                }
            }
        }
    }

    private float simplifyAngle(float par1, float par2) {
        return (Math.abs(par1 % par2 - par2 * 0.5F) - par2 * 0.25F) / (par2 * 0.25F);
    }
}
