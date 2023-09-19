
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DashInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class RainbowDashModel extends ModelBase {

    private float wingspeed;
    ModelRenderer RDHead;
    ModelRenderer RDBody;
    ModelRenderer RDLeg7;
    ModelRenderer RDLeg9;
    ModelRenderer RDLeg1;
    ModelRenderer RDLeg4;
    ModelRenderer RDNeck;
    ModelRenderer RDTail1;
    ModelRenderer RDMane;
    ModelRenderer RDWingL1;
    ModelRenderer RDWingL3;
    ModelRenderer RDWingL6;
    ModelRenderer RDLeg5;
    ModelRenderer RDLeg6;
    ModelRenderer RDLeg2;
    ModelRenderer RDLeg3;
    ModelRenderer RDWingL2;
    ModelRenderer RDWingL4;
    ModelRenderer RDWingL5;
    ModelRenderer RDWingL7;
    ModelRenderer RDWingR1;
    ModelRenderer RDWingR3;
    ModelRenderer RDWingR6;
    ModelRenderer RDWingR2;
    ModelRenderer RDWingR4;
    ModelRenderer RDWingR5;
    ModelRenderer RDWingR7;
    ModelRenderer RDTail2;
    ModelRenderer RDTail3;
    ModelRenderer RDTail4;
    ModelRenderer RDTail6;
    ModelRenderer RDTail5;
    ModelRenderer RDTail7;
    ModelRenderer RDTail8;
    ModelRenderer RDTail9;
    ModelRenderer RDTail11;
    ModelRenderer RDTail10;
    ModelRenderer RDLeg8;
    ModelRenderer RDLeg10;

    public RainbowDashModel(final float f1) {
        this.wingspeed = 1.0f;
        this.textureWidth = 128;
        this.textureHeight = 64;
        (this.RDHead = new ModelRenderer((ModelBase) this, 54, 0)).addBox(-4.0f, -3.9f, -5.9f, 8, 8, 8);
        this.RDHead.setRotationPoint(0.0f, 0.0f, -7.0f);
        this.RDHead.setTextureSize(128, 64);
        this.RDHead.mirror = true;
        this.setRotation(this.RDHead, 0.0f, 0.0f, 0.0f);
        (this.RDBody = new ModelRenderer((ModelBase) this, 24, 1)).addBox(-5.5f, -9.0f, -7.0f, 7, 14, 6);
        this.RDBody.setRotationPoint(2.0f, 5.0f, 2.0f);
        this.RDBody.setTextureSize(128, 64);
        this.RDBody.mirror = true;
        this.setRotation(this.RDBody, 1.570796f, 0.0f, 0.0f);
        (this.RDLeg7 = new ModelRenderer((ModelBase) this, 0, 23)).addBox(-1.0f, -1.0f, -2.0f, 3, 5, 3);
        this.RDLeg7.setRotationPoint(-3.0f, 12.0f, 6.0f);
        this.RDLeg7.setTextureSize(128, 64);
        this.RDLeg7.mirror = true;
        this.setRotation(this.RDLeg7, 0.0872665f, 0.0f, 0.0f);
        (this.RDLeg9 = new ModelRenderer((ModelBase) this, 0, 23)).addBox(-1.0f, 0.0f, -2.0f, 3, 5, 3);
        this.RDLeg9.setRotationPoint(2.0f, 11.0f, 6.0f);
        this.RDLeg9.setTextureSize(128, 64);
        this.RDLeg9.mirror = true;
        this.setRotation(this.RDLeg9, 0.0872665f, 0.0f, 0.0f);
        (this.RDLeg1 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-2.0f, 0.0f, -3.0f, 3, 4, 3);
        this.RDLeg1.setRotationPoint(-1.5f, 12.0f, -4.0f);
        this.RDLeg1.setTextureSize(128, 64);
        this.RDLeg1.mirror = true;
        this.setRotation(this.RDLeg1, -0.0349066f, 0.0f, 0.0f);
        (this.RDLeg4 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 0.0f, -3.0f, 3, 4, 3);
        this.RDLeg4.setRotationPoint(1.5f, 12.0f, -4.0f);
        this.RDLeg4.setTextureSize(128, 64);
        this.RDLeg4.mirror = true;
        this.setRotation(this.RDLeg4, -0.0349066f, 0.0f, 0.0f);
        (this.RDNeck = new ModelRenderer((ModelBase) this, 50, 32)).addBox(0.0f, 0.0f, 0.0f, 4, 9, 4);
        this.RDNeck.setRotationPoint(-2.0f, 2.0f, -10.0f);
        this.RDNeck.setTextureSize(128, 64);
        this.RDNeck.mirror = true;
        this.setRotation(this.RDNeck, 0.2792527f, 0.0f, 0.0f);
        (this.RDTail1 = new ModelRenderer((ModelBase) this, 67, 32)).addBox(-1.0f, 0.0f, 0.0f, 2, 3, 2);
        this.RDTail1.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail1.setTextureSize(128, 64);
        this.RDTail1.mirror = true;
        this.setRotation(this.RDTail1, 2.119181f, 0.0f, 0.0f);
        (this.RDMane = new ModelRenderer((ModelBase) this, 1, 46)).addBox(-4.5f, -4.0f, -6.0f, 9, 9, 9);
        this.RDMane.setRotationPoint(0.0f, 0.0f, -7.0f);
        this.RDMane.setTextureSize(128, 64);
        this.RDMane.mirror = true;
        this.setRotation(this.RDMane, 0.0f, 0.0f, 0.0f);
        (this.RDWingL1 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.RDWingL1.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL1.setTextureSize(128, 64);
        this.RDWingL1.mirror = true;
        this.setRotation(this.RDWingL1, 0.0f, 0.482599f, 0.0f);
        (this.RDWingL3 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.RDWingL3.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL3.setTextureSize(128, 64);
        this.RDWingL3.mirror = true;
        this.setRotation(this.RDWingL3, 0.0f, 0.0068161f, 0.0f);
        (this.RDWingL6 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.RDWingL6.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL6.setTextureSize(128, 64);
        this.RDWingL6.mirror = true;
        this.setRotation(this.RDWingL6, 0.0f, -0.4515136f, 0.0f);
        (this.RDLeg5 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 4.0f, -2.9f, 3, 4, 3);
        this.RDLeg5.setRotationPoint(1.5f, 12.0f, -4.0f);
        this.RDLeg5.setTextureSize(128, 64);
        this.RDLeg5.mirror = true;
        this.setRotation(this.RDLeg5, -0.0523599f, 0.0f, 0.0f);
        (this.RDLeg6 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-1.0f, 8.0f, -2.8f, 3, 4, 3);
        this.RDLeg6.setRotationPoint(1.5f, 12.0f, -4.0f);
        this.RDLeg6.setTextureSize(128, 64);
        this.RDLeg6.mirror = true;
        this.setRotation(this.RDLeg6, -0.0698132f, 0.0f, 0.0f);
        (this.RDLeg2 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-0.5f, 4.0f, -2.9f, 3, 4, 3);
        this.RDLeg2.setRotationPoint(-3.0f, 12.0f, -4.0f);
        this.RDLeg2.setTextureSize(128, 64);
        this.RDLeg2.mirror = true;
        this.setRotation(this.RDLeg2, -0.0523599f, 0.0f, 0.0f);
        (this.RDLeg3 = new ModelRenderer((ModelBase) this, 0, 16)).addBox(-0.5f, 8.0f, -2.8f, 3, 4, 3);
        this.RDLeg3.setRotationPoint(-3.0f, 12.0f, -4.0f);
        this.RDLeg3.setTextureSize(128, 64);
        this.RDLeg3.mirror = true;
        this.setRotation(this.RDLeg3, -0.0698132f, 0.0f, 0.0f);
        (this.RDWingL2 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(3.0f, 0.0f, 0.8f, 5, 1, 1);
        this.RDWingL2.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL2.setTextureSize(128, 64);
        this.RDWingL2.mirror = true;
        this.setRotation(this.RDWingL2, 0.0f, 0.6920385f, 0.0f);
        (this.RDWingL4 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(2.0f, 0.0f, 0.0f, 6, 1, 1);
        this.RDWingL4.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL4.setTextureSize(128, 64);
        this.RDWingL4.mirror = true;
        this.setRotation(this.RDWingL4, 0.0f, 0.2557062f, 0.0f);
        (this.RDWingL5 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(2.0f, 0.0f, 0.0f, 6, 1, 1);
        this.RDWingL5.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL5.setTextureSize(128, 64);
        this.RDWingL5.mirror = true;
        this.setRotation(this.RDWingL5, 0.0f, 0.0288134f, 0.0f);
        (this.RDWingL7 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(2.0f, 0.0f, 0.5f, 5, 1, 1);
        this.RDWingL7.setRotationPoint(3.5f, 8.0f, -2.0f);
        this.RDWingL7.setTextureSize(128, 64);
        this.RDWingL7.mirror = true;
        this.setRotation(this.RDWingL7, 0.0f, -0.2155327f, 0.0f);
        (this.RDWingR1 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.RDWingR1.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR1.setTextureSize(128, 64);
        this.RDWingR1.mirror = true;
        this.setRotation(this.RDWingR1, 0.0f, 2.658992f, 0.0f);
        (this.RDWingR3 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 4, 1, 1);
        this.RDWingR3.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR3.setTextureSize(128, 64);
        this.RDWingR3.mirror = true;
        this.setRotation(this.RDWingR3, 0.0f, 3.134768f, 0.0f);
        (this.RDWingR6 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(0.0f, 0.0f, 0.0f, 3, 1, 1);
        this.RDWingR6.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR6.setTextureSize(128, 64);
        this.RDWingR6.mirror = true;
        this.setRotation(this.RDWingR6, 0.0f, -2.690076f, 0.0f);
        (this.RDWingR2 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(3.0f, 0.0f, -0.8f, 5, 1, 1);
        this.RDWingR2.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR2.setTextureSize(128, 64);
        this.RDWingR2.mirror = true;
        this.setRotation(this.RDWingR2, 0.0f, 2.449552f, 0.0f);
        (this.RDWingR4 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(2.0f, 0.0f, 0.0f, 6, 1, 1);
        this.RDWingR4.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR4.setTextureSize(128, 64);
        this.RDWingR4.mirror = true;
        this.setRotation(this.RDWingR4, 0.0f, 2.885885f, 0.0f);
        (this.RDWingR5 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(2.0f, 0.0f, 0.0f, 6, 1, 1);
        this.RDWingR5.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR5.setTextureSize(128, 64);
        this.RDWingR5.mirror = true;
        this.setRotation(this.RDWingR5, -0.0081449f, 3.112777f, 0.0f);
        (this.RDWingR7 = new ModelRenderer((ModelBase) this, 1, 1)).addBox(2.0f, 0.0f, -0.5f, 5, 1, 1);
        this.RDWingR7.setRotationPoint(-3.5f, 8.0f, -1.0f);
        this.RDWingR7.setTextureSize(128, 64);
        this.RDWingR7.mirror = true;
        this.setRotation(this.RDWingR7, 0.0f, -2.926062f, 0.0f);
        (this.RDTail2 = new ModelRenderer((ModelBase) this, 76, 32)).addBox(-1.5f, 2.0f, 0.8f, 3, 3, 2);
        this.RDTail2.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail2.setTextureSize(128, 64);
        this.RDTail2.mirror = true;
        this.setRotation(this.RDTail2, 1.822475f, 0.0f, 0.0f);
        (this.RDTail3 = new ModelRenderer((ModelBase) this, 88, 32)).addBox(-2.0f, 3.8f, 2.2f, 4, 4, 2);
        this.RDTail3.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail3.setTextureSize(128, 64);
        this.RDTail3.mirror = true;
        this.setRotation(this.RDTail3, 1.490862f, 0.0f, 0.0f);
        (this.RDTail4 = new ModelRenderer((ModelBase) this, 76, 43)).addBox(-2.0f, 0.5f, 6.2f, 4, 6, 3);
        this.RDTail4.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail4.setTextureSize(128, 64);
        this.RDTail4.mirror = true;
        this.setRotation(this.RDTail4, 0.4363323f, 0.0f, 0.0f);
        (this.RDTail6 = new ModelRenderer((ModelBase) this, 102, 32)).addBox(-1.0f, 3.0f, 7.5f, 2, 4, 1);
        this.RDTail6.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail6.setTextureSize(128, 64);
        this.RDTail6.mirror = true;
        this.setRotation(this.RDTail6, 0.6457718f, 0.0f, 0.0f);
        (this.RDTail5 = new ModelRenderer((ModelBase) this, 92, 43)).addBox(-2.0f, 2.0f, 8.0f, 4, 6, 3);
        this.RDTail5.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail5.setTextureSize(128, 64);
        this.RDTail5.mirror = true;
        this.setRotation(this.RDTail5, 0.0f, 0.0f, 0.0f);
        (this.RDTail7 = new ModelRenderer((ModelBase) this, 76, 54)).addBox(-1.5f, 4.0f, 9.5f, 3, 6, 1);
        this.RDTail7.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail7.setTextureSize(128, 64);
        this.RDTail7.mirror = true;
        this.setRotation(this.RDTail7, 0.1396263f, 0.0f, 0.0f);
        (this.RDTail8 = new ModelRenderer((ModelBase) this, 107, 43)).addBox(-1.5f, 5.0f, 8.5f, 3, 6, 1);
        this.RDTail8.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail8.setTextureSize(128, 64);
        this.RDTail8.mirror = true;
        this.setRotation(this.RDTail8, 0.1047198f, 0.0f, 0.0f);
        (this.RDTail9 = new ModelRenderer((ModelBase) this, 110, 33)).addBox(-1.0f, 11.0f, 6.8f, 2, 3, 1);
        this.RDTail9.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail9.setTextureSize(128, 64);
        this.RDTail9.mirror = true;
        this.setRotation(this.RDTail9, 0.2617994f, 0.0f, 0.0f);
        (this.RDTail11 = new ModelRenderer((ModelBase) this, 94, 54)).addBox(-1.0f, 1.0f, 8.6f, 2, 6, 1);
        this.RDTail11.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail11.setTextureSize(128, 64);
        this.RDTail11.mirror = true;
        this.setRotation(this.RDTail11, -0.1745329f, 0.0f, 0.0f);
        (this.RDTail10 = new ModelRenderer((ModelBase) this, 86, 54)).addBox(-1.0f, 5.0f, 8.0f, 2, 6, 1);
        this.RDTail10.setRotationPoint(0.0f, 9.0f, 7.0f);
        this.RDTail10.setTextureSize(128, 64);
        this.RDTail10.mirror = true;
        this.setRotation(this.RDTail10, 0.0349066f, 0.0f, 0.0f);
        (this.RDLeg8 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, 2.0f, -1.5f, 3, 10, 3);
        this.RDLeg8.setRotationPoint(-3.0f, 12.0f, 6.0f);
        this.RDLeg8.setTextureSize(128, 64);
        this.RDLeg8.mirror = true;
        this.setRotation(this.RDLeg8, 0.0523599f, 0.0f, 0.0f);
        (this.RDLeg10 = new ModelRenderer((ModelBase) this, 0, 18)).addBox(-1.0f, 2.0f, -1.5f, 3, 10, 3);
        this.RDLeg10.setRotationPoint(2.0f, 12.0f, 6.0f);
        this.RDLeg10.setTextureSize(128, 64);
        this.RDLeg10.mirror = true;
        this.setRotation(this.RDLeg10, 0.0523599f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final DashInstance e = (DashInstance) entity;
        float newangle = 0.0f;
        final float lspeed = 0.0f;
        final InfoRenderer r = null;
        final float tailspeed = 0.76f;
        final float tailamp = 0.45f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.141593f * 0.28f;
        this.RDHead.rotateAngleY = (float) Math.toRadians(f3);
        this.RDMane.rotateAngleY = this.RDHead.rotateAngleY;
        this.RDWingL1.rotateAngleZ = newangle;
        this.RDWingL2.rotateAngleZ = newangle;
        this.RDWingL3.rotateAngleZ = newangle;
        this.RDWingL4.rotateAngleZ = newangle;
        this.RDWingL5.rotateAngleZ = newangle;
        this.RDWingL6.rotateAngleZ = newangle;
        this.RDWingL7.rotateAngleZ = newangle;
        this.RDWingR1.rotateAngleZ = -newangle;
        this.RDWingR2.rotateAngleZ = -newangle;
        this.RDWingR3.rotateAngleZ = -newangle;
        this.RDWingR4.rotateAngleZ = -newangle;
        this.RDWingR5.rotateAngleZ = -newangle;
        this.RDWingR6.rotateAngleZ = -newangle;
        this.RDWingR7.rotateAngleZ = -newangle;
        this.RDHead.render(f5);
        this.RDBody.render(f5);
        this.RDLeg7.render(f5);
        this.RDLeg9.render(f5);
        this.RDLeg1.render(f5);
        this.RDLeg4.render(f5);
        this.RDNeck.render(f5);
        this.RDTail1.render(f5);
        this.RDMane.render(f5);
        this.RDWingL1.render(f5);
        this.RDWingL3.render(f5);
        this.RDWingL6.render(f5);
        this.RDLeg5.render(f5);
        this.RDLeg6.render(f5);
        this.RDLeg2.render(f5);
        this.RDLeg3.render(f5);
        this.RDWingL2.render(f5);
        this.RDWingL4.render(f5);
        this.RDWingL5.render(f5);
        this.RDWingL7.render(f5);
        this.RDWingR1.render(f5);
        this.RDWingR3.render(f5);
        this.RDWingR6.render(f5);
        this.RDWingR2.render(f5);
        this.RDWingR4.render(f5);
        this.RDWingR5.render(f5);
        this.RDWingR7.render(f5);
        this.RDTail2.render(f5);
        this.RDTail3.render(f5);
        this.RDTail4.render(f5);
        this.RDTail6.render(f5);
        this.RDTail5.render(f5);
        this.RDTail7.render(f5);
        this.RDTail8.render(f5);
        this.RDTail9.render(f5);
        this.RDTail11.render(f5);
        this.RDTail10.render(f5);
        this.RDLeg8.render(f5);
        this.RDLeg10.render(f5);
    }

    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(final float par1, final float par2, final float par3, final float par4,
        final float par5, final float par6, final Entity entity) {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6, entity);
    }
}
