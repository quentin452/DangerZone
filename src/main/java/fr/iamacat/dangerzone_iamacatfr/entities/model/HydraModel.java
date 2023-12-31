
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.HydraInstance;

public class HydraModel extends ModelBase {

    private float wingspeed;
    ModelRenderer BodyBottom;
    ModelRenderer LLegP;
    ModelRenderer RLegP;
    ModelRenderer Tail2;
    ModelRenderer Tail4;
    ModelRenderer BodyCentre;
    ModelRenderer NC2;
    ModelRenderer NL2;
    ModelRenderer NR2;
    ModelRenderer NB2;
    ModelRenderer HL;
    ModelRenderer HC;
    ModelRenderer HR;
    ModelRenderer HB;
    ModelRenderer ML;
    ModelRenderer MC;
    ModelRenderer MR;
    ModelRenderer MB;
    ModelRenderer S2;
    ModelRenderer S1;
    ModelRenderer BS3;
    ModelRenderer BS2;
    ModelRenderer BS1;
    ModelRenderer S3;
    ModelRenderer RL1;
    ModelRenderer LL1;
    ModelRenderer RL2;
    ModelRenderer NR1;
    ModelRenderer NC1;
    ModelRenderer NL1;
    ModelRenderer LL2;
    ModelRenderer NB1;
    ModelRenderer SK7;
    ModelRenderer SK8;
    ModelRenderer SK5;
    ModelRenderer SK3;
    ModelRenderer SK1;
    ModelRenderer SK2;
    ModelRenderer SK4;
    ModelRenderer SK6;
    ModelRenderer Tail1;
    ModelRenderer Tail3;

    public HydraModel() {
        this.wingspeed = 0.2f;
        this.textureWidth = 2048;
        this.textureHeight = 2048;
        (this.BodyBottom = new ModelRenderer((ModelBase) this, 0, 780)).addBox(0.0f, 0.0f, 0.0f, 147, 120, 240);
        this.BodyBottom.setRotationPoint(-64.0f, -159.0f, -73.0f);
        this.BodyBottom.setTextureSize(2048, 2048);
        this.BodyBottom.mirror = true;
        this.setRotation(this.BodyBottom, -0.2390342f, 0.0f, 0.0f);
        (this.LLegP = new ModelRenderer((ModelBase) this, 1600, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 80, 80);
        this.LLegP.setRotationPoint(82.0f, -120.0f, 0.0f);
        this.LLegP.setTextureSize(2048, 2048);
        this.LLegP.mirror = true;
        this.setRotation(this.LLegP, -0.136591f, 0.0f, 0.0f);
        (this.RLegP = new ModelRenderer((ModelBase) this, 1600, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 80, 80);
        this.RLegP.setRotationPoint(-106.0f, -120.0f, 0.0f);
        this.RLegP.setTextureSize(2048, 2048);
        this.RLegP.mirror = true;
        this.setRotation(this.RLegP, -0.136591f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 0, 1600)).addBox(0.0f, 0.0f, 0.0f, 90, 90, 240);
        this.Tail2.setRotationPoint(-36.0f, -82.0f, 110.0f);
        this.Tail2.setTextureSize(2048, 2048);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, -0.1024432f, 0.0f, 0.0f);
        (this.Tail4 = new ModelRenderer((ModelBase) this, 800, 1200)).addBox(0.0f, 0.0f, 0.0f, 60, 60, 240);
        this.Tail4.setRotationPoint(-21.0f, -48.0f, 300.0f);
        this.Tail4.setTextureSize(2048, 2048);
        this.Tail4.mirror = true;
        this.setRotation(this.Tail4, -0.0682955f, 0.0f, 0.0f);
        (this.BodyCentre = new ModelRenderer((ModelBase) this, 0, 400)).addBox(0.0f, 0.0f, 0.0f, 147, 120, 240);
        this.BodyCentre.setRotationPoint(-64.0f, -310.0f, -134.0f);
        this.BodyCentre.setTextureSize(2048, 2048);
        this.BodyCentre.mirror = true;
        this.setRotation(this.BodyCentre, -0.9902846f, 0.0f, 0.0f);
        (this.NC2 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, -150.0f, 0.0f, 40, 200, 40);
        this.NC2.setRotationPoint(-24.0f, -427.0f, -292.0f);
        this.NC2.setTextureSize(2048, 2048);
        this.NC2.mirror = true;
        this.setRotation(this.NC2, 0.5554565f, 0.0f, 0.0f);
        (this.NL2 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, -150.0f, 0.0f, 40, 200, 40);
        this.NL2.setRotationPoint(25.0f, -427.0f, -262.0f);
        this.NL2.setTextureSize(2048, 2048);
        this.NL2.mirror = true;
        this.setRotation(this.NL2, 0.6358755f, 0.0f, 0.1115358f);
        (this.NR2 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, -150.0f, 0.0f, 40, 200, 40);
        this.NR2.setRotationPoint(-90.0f, -451.0f, -285.0f);
        this.NR2.setTextureSize(2048, 2048);
        this.NR2.mirror = true;
        this.setRotation(this.NR2, 0.3756252f, 0.0f, -0.136591f);
        (this.NB2 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, -250.0f, 0.0f, 40, 200, 40);
        this.NB2.setRotationPoint(0.0f, -427.0f, -220.0f);
        this.NB2.setTextureSize(2048, 2048);
        this.NB2.mirror = true;
        this.setRotation(this.NB2, 0.3073297f, 0.0f, 0.0f);
        (this.HL = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 60, 60, 80);
        this.HL.setRotationPoint(32.0f, -604.0f, -384.0f);
        this.HL.setTextureSize(2048, 2048);
        this.HL.mirror = true;
        this.setRotation(this.HL, 0.0f, 0.0f, 0.0f);
        (this.HC = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 60, 60, 80);
        this.HC.setRotationPoint(-38.0f, -606.0f, -410.0f);
        this.HC.setTextureSize(2048, 2048);
        this.HC.mirror = true;
        this.setRotation(this.HC, 0.0f, 0.0f, 0.0f);
        (this.HR = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 60, 60, 80);
        this.HR.setRotationPoint(-119.0f, -627.0f, -371.0f);
        this.HR.setTextureSize(2048, 2048);
        this.HR.mirror = true;
        this.setRotation(this.HR, 0.0f, 0.0f, 0.0f);
        (this.HB = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 60, 60, 80);
        this.HB.setRotationPoint(-14.0f, -716.0f, -320.0f);
        this.HB.setTextureSize(2048, 2048);
        this.HB.mirror = true;
        this.setRotation(this.HB, 0.0f, 0.0f, 0.0f);
        (this.ML = new ModelRenderer((ModelBase) this, 333, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 30, 50);
        this.ML.setRotationPoint(43.0f, -582.0f, -428.0f);
        this.ML.setTextureSize(2048, 2048);
        this.ML.mirror = true;
        this.setRotation(this.ML, 0.0f, 0.0f, 0.0f);
        (this.MC = new ModelRenderer((ModelBase) this, 333, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 30, 50);
        this.MC.setRotationPoint(-27.0f, -585.0f, -454.0f);
        this.MC.setTextureSize(2048, 2048);
        this.MC.mirror = true;
        this.setRotation(this.MC, 0.0f, 0.0f, 0.0f);
        (this.MR = new ModelRenderer((ModelBase) this, 333, 0)).addBox(0.0f, 0.0f, 0.0f, 40, 30, 50);
        this.MR.setRotationPoint(-109.0f, -598.0f, -414.0f);
        this.MR.setTextureSize(2048, 2048);
        this.MR.mirror = true;
        this.setRotation(this.MR, 0.0f, 0.0f, 0.0f);
        (this.MB = new ModelRenderer((ModelBase) this, 333, 0)).addBox(-5.0f, -16.0f, -4.0f, 40, 30, 50);
        this.MB.setRotationPoint(0.0f, -677.0f, -357.0f);
        this.MB.setTextureSize(2048, 2048);
        this.MB.mirror = true;
        this.setRotation(this.MB, 0.0f, 0.0f, 0.0f);
        (this.S2 = new ModelRenderer((ModelBase) this, 1600, 1600)).addBox(0.0f, 0.0f, 0.0f, 5, 60, 5);
        this.S2.setRotationPoint(0.0f, -190.0f, 22.0f);
        this.S2.setTextureSize(2048, 2048);
        this.S2.mirror = true;
        this.setRotation(this.S2, -0.136591f, 0.0f, 0.0f);
        (this.S1 = new ModelRenderer((ModelBase) this, 1600, 1600)).addBox(0.0f, 0.0f, 0.0f, 5, 60, 5);
        this.S1.setRotationPoint(0.0f, -194.0f, -10.0f);
        this.S1.setTextureSize(2048, 2048);
        this.S1.mirror = true;
        this.setRotation(this.S1, -0.136591f, 0.0f, 0.0f);
        (this.BS3 = new ModelRenderer((ModelBase) this, 1600, 1600)).addBox(0.0f, 0.0f, 0.0f, 5, 60, 5);
        this.BS3.setRotationPoint(0.0f, -72.0f, 460.0f);
        this.BS3.setTextureSize(2048, 2048);
        this.BS3.mirror = true;
        this.setRotation(this.BS3, -0.136591f, 0.0f, 0.0f);
        (this.BS2 = new ModelRenderer((ModelBase) this, 1600, 1600)).addBox(0.0f, 0.0f, 0.0f, 5, 60, 5);
        this.BS2.setRotationPoint(0.0f, -76.0f, 430.0f);
        this.BS2.setTextureSize(2048, 2048);
        this.BS2.mirror = true;
        this.setRotation(this.BS2, -0.136591f, 0.0f, 0.0f);
        (this.BS1 = new ModelRenderer((ModelBase) this, 1600, 1600)).addBox(0.0f, 0.0f, 0.0f, 5, 60, 5);
        this.BS1.setRotationPoint(0.0f, -80.0f, 400.0f);
        this.BS1.setTextureSize(2048, 2048);
        this.BS1.mirror = true;
        this.setRotation(this.BS1, -0.136591f, 0.0f, 0.0f);
        (this.S3 = new ModelRenderer((ModelBase) this, 1600, 1600)).addBox(0.0f, 0.0f, 0.0f, 5, 60, 5);
        this.S3.setRotationPoint(0.0f, -180.0f, 52.0f);
        this.S3.setTextureSize(2048, 2048);
        this.S3.mirror = true;
        this.setRotation(this.S3, -0.136591f, 0.0f, 0.0f);
        (this.RL1 = new ModelRenderer((ModelBase) this, 1400, 0)).addBox(0.0f, 56.0f, 0.0f, 40, 40, 40);
        this.RL1.setRotationPoint(-106.0f, -100.0f, 0.0f);
        this.RL1.setTextureSize(2048, 2048);
        this.RL1.mirror = true;
        this.setRotation(this.RL1, -0.0994124f, 0.0f, 0.0f);
        (this.LL1 = new ModelRenderer((ModelBase) this, 1400, 0)).addBox(0.0f, 75.0f, 0.0f, 40, 40, 40);
        this.LL1.setRotationPoint(82.0f, -120.0f, 0.0f);
        this.LL1.setTextureSize(2048, 2048);
        this.LL1.mirror = true;
        this.setRotation(this.LL1, -0.0994124f, 0.0f, 0.0f);
        (this.RL2 = new ModelRenderer((ModelBase) this, 1200, 0)).addBox(0.0f, 110.0f, -10.0f, 40, 50, 40);
        this.RL2.setRotationPoint(-106.0f, -120.0f, 0.0f);
        this.RL2.setTextureSize(2048, 2048);
        this.RL2.mirror = true;
        this.setRotation(this.RL2, 0.0f, 0.0f, 0.0f);
        (this.NR1 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, 50.0f, 0.0f, 40, 200, 40);
        this.NR1.setRotationPoint(-90.0f, -457.0f, -280.0f);
        this.NR1.setTextureSize(2048, 2048);
        this.NR1.mirror = true;
        this.setRotation(this.NR1, 0.2815427f, 0.0f, -0.136591f);
        (this.NC1 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, 50.0f, 0.0f, 40, 200, 40);
        this.NC1.setRotationPoint(-24.0f, -433.0f, -285.0f);
        this.NC1.setTextureSize(2048, 2048);
        this.NC1.mirror = true;
        this.setRotation(this.NC1, 0.3498382f, 0.0f, 0.0f);
        (this.NL1 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, 27.0f, 47.0f, 40, 200, 40);
        this.NL1.setRotationPoint(25.0f, -427.0f, -285.0f);
        this.NL1.setTextureSize(2048, 2048);
        this.NL1.mirror = true;
        this.setRotation(this.NL1, 0.1897322f, 0.0f, 0.0f);
        (this.LL2 = new ModelRenderer((ModelBase) this, 1200, 0)).addBox(0.0f, 110.0f, -10.0f, 40, 50, 40);
        this.LL2.setRotationPoint(82.0f, -120.0f, 0.0f);
        this.LL2.setTextureSize(2048, 2048);
        this.LL2.mirror = true;
        this.setRotation(this.LL2, 0.0f, 0.0f, 0.0f);
        (this.NB1 = new ModelRenderer((ModelBase) this, 888, 888)).addBox(0.0f, -50.0f, 0.0f, 40, 200, 40);
        this.NB1.setRotationPoint(0.0f, -427.0f, -220.0f);
        this.NB1.setTextureSize(2048, 2048);
        this.NB1.mirror = true;
        this.setRotation(this.NB1, 0.2329725f, 0.0f, 0.0f);
        (this.SK7 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK7.setRotationPoint(-18.0f, -682.0f, -271.0f);
        this.SK7.setTextureSize(2048, 2048);
        this.SK7.mirror = true;
        this.setRotation(this.SK7, 1.833875f, 0.0f, 0.0f);
        (this.SK8 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK8.setRotationPoint(45.0f, -682.0f, -276.0f);
        this.SK8.setTextureSize(2048, 2048);
        this.SK8.mirror = true;
        this.setRotation(this.SK8, 1.833875f, 0.0f, 0.0f);
        (this.SK5 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK5.setRotationPoint(30.0f, -562.0f, -334.0f);
        this.SK5.setTextureSize(2048, 2048);
        this.SK5.mirror = true;
        this.setRotation(this.SK5, 1.833875f, 0.0f, 0.0f);
        (this.SK3 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK3.setRotationPoint(-42.0f, -562.0f, -364.0f);
        this.SK3.setTextureSize(2048, 2048);
        this.SK3.mirror = true;
        this.setRotation(this.SK3, 1.833875f, 0.0f, 0.0f);
        (this.SK1 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK1.setRotationPoint(-122.0f, -584.0f, -322.0f);
        this.SK1.setTextureSize(2048, 2048);
        this.SK1.mirror = true;
        this.setRotation(this.SK1, 1.833875f, 0.0f, 0.0f);
        (this.SK2 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK2.setRotationPoint(-60.0f, -584.0f, -327.0f);
        this.SK2.setTextureSize(2048, 2048);
        this.SK2.mirror = true;
        this.setRotation(this.SK2, 1.833875f, 0.0f, 0.0f);
        (this.SK4 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK4.setRotationPoint(20.0f, -562.0f, -370.0f);
        this.SK4.setTextureSize(2048, 2048);
        this.SK4.mirror = true;
        this.setRotation(this.SK4, 1.833875f, 0.0f, 0.0f);
        (this.SK6 = new ModelRenderer((ModelBase) this, 555, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 80, 27);
        this.SK6.setRotationPoint(91.0f, -562.0f, -340.0f);
        this.SK6.setTextureSize(2048, 2048);
        this.SK6.mirror = true;
        this.setRotation(this.SK6, 1.833875f, 0.0f, 0.0f);
        (this.Tail1 = new ModelRenderer((ModelBase) this, 0, 1200)).addBox(8.0f, 7.0f, 90.0f, 130, 105, 240);
        this.Tail1.setRotationPoint(-64.0f, -139.0f, -73.0f);
        this.Tail1.setTextureSize(2048, 2048);
        this.Tail1.mirror = true;
        this.setRotation(this.Tail1, -0.164677f, 0.0f, 0.0f);
        (this.Tail3 = new ModelRenderer((ModelBase) this, 800, 1600)).addBox(8.0f, 5.0f, 93.0f, 75, 75, 240);
        this.Tail3.setRotationPoint(-36.0f, -74.0f, 110.0f);
        this.Tail3.setTextureSize(2048, 2048);
        this.Tail3.mirror = true;
        this.setRotation(this.Tail3, -0.0733038f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final HydraInstance e = (HydraInstance) entity;
        final float newangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        final float newangle2 = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 3.141593f * 0.12f * f1;
        this.LL1.rotateAngleX = newangle2;
        this.LL2.rotateAngleX = newangle2;
        this.RL1.rotateAngleX = -newangle2;
        this.RL2.rotateAngleX = -newangle2;
        this.BodyBottom.render(f5);
        this.LLegP.render(f5);
        this.RLegP.render(f5);
        this.Tail2.render(f5);
        this.Tail4.render(f5);
        this.BodyCentre.render(f5);
        this.NC2.render(f5);
        this.NL2.render(f5);
        this.NR2.render(f5);
        this.NB2.render(f5);
        this.HL.render(f5);
        this.HC.render(f5);
        this.HR.render(f5);
        this.HB.render(f5);
        this.ML.render(f5);
        this.MC.render(f5);
        this.MR.render(f5);
        this.MB.render(f5);
        this.S2.render(f5);
        this.S1.render(f5);
        this.BS3.render(f5);
        this.BS2.render(f5);
        this.BS1.render(f5);
        this.S3.render(f5);
        this.RL1.render(f5);
        this.LL1.render(f5);
        this.RL2.render(f5);
        this.NR1.render(f5);
        this.NC1.render(f5);
        this.NL1.render(f5);
        this.LL2.render(f5);
        this.NB1.render(f5);
        this.SK7.render(f5);
        this.SK8.render(f5);
        this.SK5.render(f5);
        this.SK3.render(f5);
        this.SK1.render(f5);
        this.SK2.render(f5);
        this.SK4.render(f5);
        this.SK6.render(f5);
        this.Tail1.render(f5);
        this.Tail3.render(f5);
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
