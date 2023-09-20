
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Kraken;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class ModelKraken extends ModelBase {

    private float wingspeed;
    ModelRenderer Lefteye;
    ModelRenderer Backbody;
    ModelRenderer Centerbody;
    ModelRenderer Head;
    ModelRenderer Sucktioncupleft;
    ModelRenderer Finright;
    ModelRenderer Tailbase1;
    ModelRenderer Tail2;
    ModelRenderer Tailtip;
    ModelRenderer Finleft;
    ModelRenderer Frontbody;
    ModelRenderer Mouth1;
    ModelRenderer Tent54;
    ModelRenderer Tent62;
    ModelRenderer Tent63;
    ModelRenderer Tent64;
    ModelRenderer Tent58;
    ModelRenderer Tent66;
    ModelRenderer Tent67;
    ModelRenderer Tent68;
    ModelRenderer Tent28;
    ModelRenderer Tent51;
    ModelRenderer Tent52;
    ModelRenderer Tent53;
    ModelRenderer Tent65;
    ModelRenderer Tent55;
    ModelRenderer Tent56;
    ModelRenderer Tent57;
    ModelRenderer Sucktioncupright;
    ModelRenderer Righteye;
    ModelRenderer Mouth2;
    ModelRenderer Mouth3;
    ModelRenderer Mouth4;
    ModelRenderer Mouth5;
    ModelRenderer Mouth6;
    ModelRenderer Mouth7;
    ModelRenderer Mouth8;
    ModelRenderer Tent61;
    ModelRenderer Tent38;
    ModelRenderer Tent22;
    ModelRenderer Tent23;
    ModelRenderer Tent24;
    ModelRenderer Tent25;
    ModelRenderer Tent26;
    ModelRenderer Tent27;
    ModelRenderer Tooth1;
    ModelRenderer Tent48;
    ModelRenderer Tent32;
    ModelRenderer Tent33;
    ModelRenderer Tent34;
    ModelRenderer Tent35;
    ModelRenderer Tent36;
    ModelRenderer Tent37;
    ModelRenderer Jet;
    ModelRenderer Tent41;
    ModelRenderer Tent42;
    ModelRenderer Tent43;
    ModelRenderer Tent44;
    ModelRenderer Tent45;
    ModelRenderer Tent46;
    ModelRenderer Tent47;
    ModelRenderer Tent21;
    ModelRenderer Tent11;
    ModelRenderer Tent12;
    ModelRenderer Tent13;
    ModelRenderer Tent14;
    ModelRenderer Tent15;
    ModelRenderer Tent16;
    ModelRenderer Tent31;
    ModelRenderer Tent18;
    ModelRenderer Tooth2;
    ModelRenderer Tooth3;
    ModelRenderer Tooth4;
    ModelRenderer Tooth5;
    ModelRenderer Tooth6;
    ModelRenderer Tooth7;
    ModelRenderer Tooth8;
    ModelRenderer Tooth9;
    ModelRenderer Tooth10;
    ModelRenderer Tooth11;
    ModelRenderer Tooth12;
    ModelRenderer Tooth13;
    ModelRenderer Tooth14;
    ModelRenderer Tooth15;
    ModelRenderer Tooth16;
    ModelRenderer Tooth17;
    ModelRenderer Tooth18;
    ModelRenderer Tooth19;
    ModelRenderer Tooth20;
    ModelRenderer Tooth21;
    ModelRenderer Tooth22;
    ModelRenderer Tooth23;
    ModelRenderer Tooth24;
    ModelRenderer Tooth25;
    ModelRenderer Tooth26;
    ModelRenderer Tooth27;
    ModelRenderer Tooth28;
    ModelRenderer Tooth29;
    ModelRenderer Tooth30;
    ModelRenderer Tooth31;
    ModelRenderer Tooth32;
    ModelRenderer Tooth33;
    ModelRenderer Tooth34;
    ModelRenderer Tooth35;
    ModelRenderer Tooth36;
    ModelRenderer Tooth37;
    ModelRenderer Tooth38;
    ModelRenderer Tooth39;
    ModelRenderer Tooth40;
    ModelRenderer Tooth41;
    ModelRenderer Tent17;

    public ModelKraken(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.Lefteye = new ModelRenderer((ModelBase) this, 56, 458)).addBox(0.0f, -8.0f, -12.0f, 4, 16, 24);
        this.Lefteye.setRotationPoint(20.0f, -24.0f, -90.0f);
        this.Lefteye.setTextureSize(64, 32);
        this.Lefteye.mirror = true;
        this.setRotation(this.Lefteye, 0.0f, 0.0f, 0.0f);
        (this.Backbody = new ModelRenderer((ModelBase) this, 320, 272)).addBox(-24.0f, -24.0f, 0.0f, 48, 48, 48);
        this.Backbody.setRotationPoint(0.0f, -24.0f, 28.0f);
        this.Backbody.setTextureSize(64, 32);
        this.Backbody.mirror = true;
        this.setRotation(this.Backbody, 0.0f, 0.0f, 0.0f);
        (this.Centerbody = new ModelRenderer((ModelBase) this, 320, 176)).addBox(-24.0f, -24.0f, -24.0f, 48, 48, 48);
        this.Centerbody.setRotationPoint(0.0f, -24.0f, 4.0f);
        this.Centerbody.setTextureSize(64, 32);
        this.Centerbody.mirror = true;
        this.setRotation(this.Centerbody, 0.0f, 0.0f, 0.0f);
        (this.Head = new ModelRenderer((ModelBase) this, 336, 0)).addBox(-20.0f, -20.0f, -40.0f, 40, 40, 40);
        this.Head.setRotationPoint(0.0f, -24.0f, -68.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.Sucktioncupleft = new ModelRenderer((ModelBase) this, 80, 84)).addBox(-8.0f, -4.0f, -32.0f, 16, 8, 32);
        this.Sucktioncupleft.setRotationPoint(32.0f, -26.0f, -336.0f);
        this.Sucktioncupleft.setTextureSize(64, 32);
        this.Sucktioncupleft.mirror = true;
        this.setRotation(this.Sucktioncupleft, 0.3490659f, 0.2617994f, 0.0f);
        (this.Finright = new ModelRenderer((ModelBase) this, 0, 329)).addBox(-40.0f, -8.0f, -32.0f, 40, 12, 104);
        this.Finright.setRotationPoint(-12.0f, -21.0f, 83.0f);
        this.Finright.setTextureSize(64, 32);
        this.Finright.mirror = true;
        this.setRotation(this.Finright, 0.0f, 0.0f, 0.0f);
        (this.Tailbase1 = new ModelRenderer((ModelBase) this, 368, 368)).addBox(-20.0f, -20.0f, 0.0f, 40, 40, 32);
        this.Tailbase1.setRotationPoint(0.0f, -24.0f, 75.0f);
        this.Tailbase1.setTextureSize(64, 32);
        this.Tailbase1.mirror = true;
        this.setRotation(this.Tailbase1, 0.0f, 0.0f, 0.0f);
        (this.Tail2 = new ModelRenderer((ModelBase) this, 384, 440)).addBox(-16.0f, -16.0f, 0.0f, 32, 32, 32);
        this.Tail2.setRotationPoint(0.0f, -24.0f, 107.0f);
        this.Tail2.setTextureSize(64, 32);
        this.Tail2.mirror = true;
        this.setRotation(this.Tail2, 0.0f, 0.0f, 0.0f);
        (this.Tailtip = new ModelRenderer((ModelBase) this, 272, 457)).addBox(-12.0f, -12.0f, 0.0f, 24, 24, 32);
        this.Tailtip.setRotationPoint(0.0f, -24.0f, 139.0f);
        this.Tailtip.setTextureSize(64, 32);
        this.Tailtip.mirror = true;
        this.setRotation(this.Tailtip, 0.0f, 0.0f, 0.0f);
        (this.Finleft = new ModelRenderer((ModelBase) this, 0, 201)).addBox(0.0f, -8.0f, -32.0f, 40, 12, 104);
        this.Finleft.setRotationPoint(12.0f, -21.0f, 83.0f);
        this.Finleft.setTextureSize(64, 32);
        this.Finleft.mirror = true;
        this.setRotation(this.Finleft, 0.0f, 0.0f, 0.0f);
        (this.Frontbody = new ModelRenderer((ModelBase) this, 320, 80)).addBox(-20.0f, -20.0f, -47.0f, 48, 48, 48);
        this.Frontbody.setRotationPoint(-4.0f, -28.0f, -21.0f);
        this.Frontbody.setTextureSize(64, 32);
        this.Frontbody.mirror = true;
        this.setRotation(this.Frontbody, 0.0f, 0.0f, 0.0f);
        (this.Mouth1 = new ModelRenderer((ModelBase) this, 232, 160)).addBox(-2.0f, -8.0f, -24.0f, 4, 16, 24);
        this.Mouth1.setRotationPoint(11.0f, -28.0f, -104.0f);
        this.Mouth1.setTextureSize(64, 32);
        this.Mouth1.mirror = true;
        this.setRotation(this.Mouth1, -0.3839724f, -0.3839724f, -0.7853982f);
        (this.Tent54 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent54.setRotationPoint(37.0f, -51.0f, -191.0f);
        this.Tent54.setTextureSize(64, 32);
        this.Tent54.mirror = true;
        this.setRotation(this.Tent54, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent62 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent62.setRotationPoint(-21.0f, -46.0f, -133.0f);
        this.Tent62.setTextureSize(64, 32);
        this.Tent62.mirror = true;
        this.setRotation(this.Tent62, -0.2617994f, 0.3490659f, 0.0f);
        (this.Tent63 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent63.setRotationPoint(-31.0f, -54.0f, -159.5333f);
        this.Tent63.setTextureSize(64, 32);
        this.Tent63.mirror = true;
        this.setRotation(this.Tent63, -0.0872665f, 0.1745329f, 0.0f);
        (this.Tent64 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent64.setRotationPoint(-36.0f, -57.0f, -188.0f);
        this.Tent64.setTextureSize(64, 32);
        this.Tent64.mirror = true;
        this.setRotation(this.Tent64, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent58 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent58.setRotationPoint(40.0f, -36.0f, -308.0f);
        this.Tent58.setTextureSize(64, 32);
        this.Tent58.mirror = true;
        this.setRotation(this.Tent58, 0.3490659f, 0.2617994f, 0.0f);
        (this.Tent66 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent66.setRotationPoint(-31.0f, -51.0f, -250.0f);
        this.Tent66.setTextureSize(64, 32);
        this.Tent66.mirror = true;
        this.setRotation(this.Tent66, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent67 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent67.setRotationPoint(-28.0f, -48.0f, -281.0f);
        this.Tent67.setTextureSize(64, 32);
        this.Tent67.mirror = true;
        this.setRotation(this.Tent67, 0.2617994f, -0.1745329f, 0.0f);
        (this.Tent68 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent68.setRotationPoint(-23.0f, -40.0f, -309.0f);
        this.Tent68.setTextureSize(64, 32);
        this.Tent68.mirror = true;
        this.setRotation(this.Tent68, 0.3490659f, -0.2617994f, 0.0f);
        (this.Tent28 = new ModelRenderer((ModelBase) this, 0, 57)).addBox(-1.0f, -1.0f, -32.0f, 1, 1, 32);
        this.Tent28.setRotationPoint(-17.0f, 50.0f, -307.0f);
        this.Tent28.setTextureSize(64, 32);
        this.Tent28.mirror = true;
        this.setRotation(this.Tent28, 0.0872665f, -0.1745329f, 0.0f);
        (this.Tent51 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent51.setRotationPoint(14.0f, -38.0f, -105.0f);
        this.Tent51.setTextureSize(64, 32);
        this.Tent51.mirror = true;
        this.setRotation(this.Tent51, -0.2617994f, -0.2617994f, 0.0f);
        (this.Tent52 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent52.setRotationPoint(22.0f, -46.0f, -134.0f);
        this.Tent52.setTextureSize(64, 32);
        this.Tent52.mirror = true;
        this.setRotation(this.Tent52, -0.2617994f, -0.3490659f, -0.0523599f);
        (this.Tent53 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent53.setRotationPoint(32.0f, -54.0f, -161.0f);
        this.Tent53.setTextureSize(64, 32);
        this.Tent53.mirror = true;
        this.setRotation(this.Tent53, 0.0872665f, -0.1745329f, 0.0f);
        (this.Tent65 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent65.setRotationPoint(-34.0f, -54.0f, -219.0f);
        this.Tent65.setTextureSize(64, 32);
        this.Tent65.mirror = true;
        this.setRotation(this.Tent65, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent55 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent55.setRotationPoint(40.0f, -49.0f, -219.0f);
        this.Tent55.setTextureSize(64, 32);
        this.Tent55.mirror = true;
        this.setRotation(this.Tent55, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent56 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent56.setRotationPoint(42.0f, -46.0f, -249.0f);
        this.Tent56.setTextureSize(64, 32);
        this.Tent56.mirror = true;
        this.setRotation(this.Tent56, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent57 = new ModelRenderer((ModelBase) this, 80, 124)).addBox(-2.0f, -2.0f, -32.0f, 4, 4, 32);
        this.Tent57.setRotationPoint(45.0f, -44.0f, -279.0f);
        this.Tent57.setTextureSize(64, 32);
        this.Tent57.mirror = true;
        this.setRotation(this.Tent57, 0.2617994f, 0.1745329f, 0.0f);
        (this.Sucktioncupright = new ModelRenderer((ModelBase) this, 80, 84)).addBox(-8.0f, -4.0f, -32.0f, 16, 8, 32);
        this.Sucktioncupright.setRotationPoint(-14.0f, -30.0f, -336.0f);
        this.Sucktioncupright.setTextureSize(64, 32);
        this.Sucktioncupright.mirror = true;
        this.setRotation(this.Sucktioncupright, 0.3490659f, -0.2617994f, 0.0f);
        (this.Righteye = new ModelRenderer((ModelBase) this, 0, 458)).addBox(-4.0f, -8.0f, -12.0f, 4, 16, 24);
        this.Righteye.setRotationPoint(-20.0f, -24.0f, -90.0f);
        this.Righteye.setTextureSize(64, 32);
        this.Righteye.mirror = true;
        this.setRotation(this.Righteye, 0.0f, 0.0f, 0.0f);
        (this.Mouth2 = new ModelRenderer((ModelBase) this, 232, 92)).addBox(-2.0f, -8.0f, -24.0f, 4, 16, 24);
        this.Mouth2.setRotationPoint(-12.0f, -28.0f, -104.0f);
        this.Mouth2.setTextureSize(64, 32);
        this.Mouth2.mirror = true;
        this.setRotation(this.Mouth2, -0.3839724f, 0.3839724f, 0.7853982f);
        (this.Mouth3 = new ModelRenderer((ModelBase) this, 232, 12)).addBox(-2.0f, -8.0f, -24.0f, 4, 16, 24);
        this.Mouth3.setRotationPoint(-10.0f, -12.0f, -104.0f);
        this.Mouth3.setTextureSize(64, 32);
        this.Mouth3.mirror = true;
        this.setRotation(this.Mouth3, 0.3839724f, 0.3839724f, -0.8004762f);
        (this.Mouth4 = new ModelRenderer((ModelBase) this, 288, 427)).addBox(-8.0f, -2.0f, -24.0f, 16, 4, 24);
        this.Mouth4.setRotationPoint(0.0f, -9.0f, -104.0f);
        this.Mouth4.setTextureSize(64, 32);
        this.Mouth4.mirror = true;
        this.setRotation(this.Mouth4, 0.3839724f, 0.0f, 0.0f);
        (this.Mouth5 = new ModelRenderer((ModelBase) this, 288, 387)).addBox(-2.0f, -8.0f, -24.0f, 4, 16, 24);
        this.Mouth5.setRotationPoint(11.0f, -12.0f, -104.0f);
        this.Mouth5.setTextureSize(64, 32);
        this.Mouth5.mirror = true;
        this.setRotation(this.Mouth5, 0.3839724f, -0.3839724f, 0.7853982f);
        (this.Mouth6 = new ModelRenderer((ModelBase) this, 175, 160)).addBox(-2.0f, -8.0f, -24.0f, 4, 16, 24);
        this.Mouth6.setRotationPoint(10.0f, -21.0f, -104.0f);
        this.Mouth6.setTextureSize(64, 32);
        this.Mouth6.mirror = true;
        this.setRotation(this.Mouth6, 0.0f, -0.3839724f, 0.0f);
        (this.Mouth7 = new ModelRenderer((ModelBase) this, 232, 52)).addBox(-2.0f, -8.0f, -24.0f, 4, 16, 24);
        this.Mouth7.setRotationPoint(-10.0f, -21.0f, -104.0f);
        this.Mouth7.setTextureSize(64, 32);
        this.Mouth7.mirror = true;
        this.setRotation(this.Mouth7, 0.0f, 0.3839724f, 0.0f);
        (this.Mouth8 = new ModelRenderer((ModelBase) this, 232, 132)).addBox(-8.0f, -2.0f, -24.0f, 16, 4, 24);
        this.Mouth8.setRotationPoint(0.0f, -31.0f, -104.0f);
        this.Mouth8.setTextureSize(64, 32);
        this.Mouth8.mirror = true;
        this.setRotation(this.Mouth8, -0.3839724f, 0.0f, 0.0f);
        (this.Tent61 = new ModelRenderer((ModelBase) this, 80, 161)).addBox(-4.0f, -4.0f, -32.0f, 8, 8, 32);
        this.Tent61.setRotationPoint(-14.0f, -38.0f, -105.0f);
        this.Tent61.setTextureSize(64, 32);
        this.Tent61.mirror = true;
        this.setRotation(this.Tent61, -0.2617994f, 0.2617994f, 0.0f);
        (this.Tent38 = new ModelRenderer((ModelBase) this, 0, 57)).addBox(0.0f, 0.0f, -32.0f, 1, 1, 32);
        this.Tent38.setRotationPoint(57.0f, 39.0f, -307.0f);
        this.Tent38.setTextureSize(64, 32);
        this.Tent38.mirror = true;
        this.setRotation(this.Tent38, 0.0f, 0.0f, 0.0f);
        (this.Tent22 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent22.setRotationPoint(-21.0f, 0.0f, -133.0f);
        this.Tent22.setTextureSize(64, 32);
        this.Tent22.mirror = true;
        this.setRotation(this.Tent22, 0.2617994f, 0.1745329f, 0.0f);
        (this.Tent23 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent23.setRotationPoint(-26.0f, 8.0f, -161.0f);
        this.Tent23.setTextureSize(64, 32);
        this.Tent23.mirror = true;
        this.setRotation(this.Tent23, 0.3490659f, 0.0f, 0.0f);
        (this.Tent24 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-3.0f, -3.0f, -32.0f, 5, 5, 32);
        this.Tent24.setRotationPoint(-26.0f, 19.0f, -191.0f);
        this.Tent24.setTextureSize(64, 32);
        this.Tent24.mirror = true;
        this.setRotation(this.Tent24, 0.3490659f, 0.0f, 0.0f);
        (this.Tent25 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-3.0f, -3.0f, -32.0f, 5, 5, 32);
        this.Tent25.setRotationPoint(-26.0f, 29.0f, -219.0f);
        this.Tent25.setTextureSize(64, 32);
        this.Tent25.mirror = true;
        this.setRotation(this.Tent25, 0.2617994f, -0.0872665f, 0.0f);
        (this.Tent26 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-2.0f, -2.0f, -32.0f, 3, 3, 32);
        this.Tent26.setRotationPoint(-24.0f, 37.0f, -248.0f);
        this.Tent26.setTextureSize(64, 32);
        this.Tent26.mirror = true;
        this.setRotation(this.Tent26, 0.2617994f, -0.0872665f, 0.0f);
        (this.Tent27 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-2.0f, -2.0f, -32.0f, 3, 3, 32);
        this.Tent27.setRotationPoint(-22.0f, 45.0f, -277.0f);
        this.Tent27.setTextureSize(64, 32);
        this.Tent27.mirror = true;
        this.setRotation(this.Tent27, 0.1745329f, -0.1745329f, 0.0f);
        (this.Tooth1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth1.setRotationPoint(-7.0f, -7.0f, -119.0f);
        this.Tooth1.setTextureSize(64, 32);
        this.Tooth1.mirror = true;
        this.setRotation(this.Tooth1, -0.1745329f, -0.3490659f, 0.0f);
        (this.Tent48 = new ModelRenderer((ModelBase) this, 0, 57)).addBox(0.0f, 0.0f, -32.0f, 1, 1, 32);
        this.Tent48.setRotationPoint(82.0f, -5.0f, -302.0f);
        this.Tent48.setTextureSize(64, 32);
        this.Tent48.mirror = true;
        this.setRotation(this.Tent48, 0.0872665f, 0.2617994f, 0.0f);
        (this.Tent32 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent32.setRotationPoint(24.0f, 0.0f, -134.0f);
        this.Tent32.setTextureSize(64, 32);
        this.Tent32.mirror = true;
        this.setRotation(this.Tent32, 0.2617994f, -0.3490659f, 0.0f);
        (this.Tent33 = new ModelRenderer((ModelBase) this, 0, 161)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent33.setRotationPoint(34.0f, 8.0f, -162.0f);
        this.Tent33.setTextureSize(64, 32);
        this.Tent33.mirror = true;
        this.setRotation(this.Tent33, 0.3490659f, -0.2617994f, 0.0f);
        (this.Tent34 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-2.0f, -2.0f, -32.0f, 5, 5, 32);
        this.Tent34.setRotationPoint(41.0f, 18.0f, -190.0f);
        this.Tent34.setTextureSize(64, 32);
        this.Tent34.mirror = true;
        this.setRotation(this.Tent34, 0.2617994f, -0.2617994f, 0.0f);
        (this.Tent35 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-2.0f, -2.0f, -32.0f, 5, 5, 32);
        this.Tent35.setRotationPoint(49.0f, 26.0f, -218.0f);
        this.Tent35.setTextureSize(64, 32);
        this.Tent35.mirror = true;
        this.setRotation(this.Tent35, 0.1745329f, -0.1745329f, 0.0f);
        (this.Tent36 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-1.0f, -1.0f, -32.0f, 3, 3, 32);
        this.Tent36.setRotationPoint(54.0f, 31.0f, -247.0f);
        this.Tent36.setTextureSize(64, 32);
        this.Tent36.mirror = true;
        this.setRotation(this.Tent36, 0.1745329f, -0.0872665f, 0.0f);
        (this.Tent37 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-1.0f, -1.0f, -32.0f, 3, 3, 32);
        this.Tent37.setRotationPoint(57.0f, 36.0f, -276.0f);
        this.Tent37.setTextureSize(64, 32);
        this.Tent37.mirror = true;
        this.setRotation(this.Tent37, 0.0872665f, 0.0f, 0.0f);
        (this.Jet = new ModelRenderer((ModelBase) this, 80, 42)).addBox(-5.0f, -5.0f, -32.0f, 10, 10, 32);
        this.Jet.setRotationPoint(0.0f, -7.0f, -64.0f);
        this.Jet.setTextureSize(64, 32);
        this.Jet.mirror = true;
        this.setRotation(this.Jet, 0.3490659f, 0.0f, 0.0f);
        (this.Tent41 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent41.setRotationPoint(16.0f, -23.0f, -105.0f);
        this.Tent41.setTextureSize(64, 32);
        this.Tent41.mirror = true;
        this.setRotation(this.Tent41, 0.0872665f, -0.4363323f, 0.0f);
        (this.Tent42 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent42.setRotationPoint(28.0f, -21.0f, -132.0f);
        this.Tent42.setTextureSize(64, 32);
        this.Tent42.mirror = true;
        this.setRotation(this.Tent42, 0.0872665f, -0.5235988f, 0.0f);
        (this.Tent43 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent43.setRotationPoint(43.0f, -18.0f, -159.0f);
        this.Tent43.setTextureSize(64, 32);
        this.Tent43.mirror = true;
        this.setRotation(this.Tent43, 0.0872665f, -0.6108652f, 0.0f);
        (this.Tent44 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-2.0f, -2.0f, -32.0f, 5, 5, 32);
        this.Tent44.setRotationPoint(60.0f, -16.0f, -185.0f);
        this.Tent44.setTextureSize(64, 32);
        this.Tent44.mirror = true;
        this.setRotation(this.Tent44, 0.0872665f, -0.4363323f, 0.0f);
        (this.Tent45 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-2.0f, -2.0f, -32.0f, 5, 5, 32);
        this.Tent45.setRotationPoint(73.0f, -13.0f, -213.0f);
        this.Tent45.setTextureSize(64, 32);
        this.Tent45.mirror = true;
        this.setRotation(this.Tent45, 0.0872665f, -0.2617994f, 0.0f);
        (this.Tent46 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-1.0f, -1.0f, -32.0f, 3, 3, 32);
        this.Tent46.setRotationPoint(81.0f, -10.0f, -242.0f);
        this.Tent46.setTextureSize(64, 32);
        this.Tent46.mirror = true;
        this.setRotation(this.Tent46, 0.0872665f, -0.0872665f, 0.0f);
        (this.Tent47 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-1.0f, -1.0f, -32.0f, 3, 3, 32);
        this.Tent47.setRotationPoint(84.0f, -7.0f, -272.0f);
        this.Tent47.setTextureSize(64, 32);
        this.Tent47.mirror = true;
        this.setRotation(this.Tent47, 0.0872665f, 0.0872665f, 0.0f);
        (this.Tent21 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent21.setRotationPoint(-14.0f, -8.0f, -105.0f);
        this.Tent21.setTextureSize(64, 32);
        this.Tent21.mirror = true;
        this.setRotation(this.Tent21, 0.2617994f, 0.2617994f, 0.0f);
        (this.Tent11 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent11.setRotationPoint(-14.0f, -23.0f, -105.0f);
        this.Tent11.setTextureSize(64, 32);
        this.Tent11.mirror = true;
        this.setRotation(this.Tent11, 0.0872665f, 0.4363323f, 0.0f);
        (this.Tent12 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent12.setRotationPoint(-26.0f, -20.0f, -132.0f);
        this.Tent12.setTextureSize(64, 32);
        this.Tent12.mirror = true;
        this.setRotation(this.Tent12, 0.0872665f, 0.3490659f, 0.0f);
        (this.Tent13 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent13.setRotationPoint(-36.0f, -17.0f, -160.0f);
        this.Tent13.setTextureSize(64, 32);
        this.Tent13.mirror = true;
        this.setRotation(this.Tent13, 0.0872665f, 0.2617994f, 0.0f);
        (this.Tent14 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-2.0f, -2.0f, -32.0f, 5, 5, 32);
        this.Tent14.setRotationPoint(-44.0f, -15.0f, -188.0f);
        this.Tent14.setTextureSize(64, 32);
        this.Tent14.mirror = true;
        this.setRotation(this.Tent14, 0.0872665f, 0.4363323f, 0.0f);
        (this.Tent15 = new ModelRenderer((ModelBase) this, 0, 125)).addBox(-2.0f, -2.0f, -32.0f, 5, 5, 32);
        this.Tent15.setRotationPoint(-57.0f, -12.0f, -217.0f);
        this.Tent15.setTextureSize(64, 32);
        this.Tent15.mirror = true;
        this.setRotation(this.Tent15, 0.0872665f, 0.2617994f, 0.0f);
        (this.Tent16 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-1.0f, -1.0f, -32.0f, 3, 3, 32);
        this.Tent16.setRotationPoint(-65.0f, -9.0f, -246.0f);
        this.Tent16.setTextureSize(64, 32);
        this.Tent16.mirror = true;
        this.setRotation(this.Tent16, 0.0872665f, 0.0872665f, 0.0f);
        (this.Tent31 = new ModelRenderer((ModelBase) this, 0, 162)).addBox(-4.0f, -4.0f, -32.0f, 7, 7, 32);
        this.Tent31.setRotationPoint(16.0f, -8.0f, -105.0f);
        this.Tent31.setTextureSize(64, 32);
        this.Tent31.mirror = true;
        this.setRotation(this.Tent31, 0.2617994f, -0.2617994f, 0.0f);
        (this.Tent18 = new ModelRenderer((ModelBase) this, 0, 57)).addBox(-1.0f, -1.0f, -32.0f, 1, 1, 32);
        this.Tent18.setRotationPoint(-62.0f, -3.0f, -307.0f);
        this.Tent18.setTextureSize(64, 32);
        this.Tent18.mirror = true;
        this.setRotation(this.Tent18, 0.0872665f, -0.1745329f, 0.0f);
        (this.Tooth2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth2.setRotationPoint(-3.0f, -6.0f, -117.0f);
        this.Tooth2.setTextureSize(64, 32);
        this.Tooth2.mirror = true;
        this.setRotation(this.Tooth2, -0.3490659f, 0.0f, 0.0f);
        (this.Tooth3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth3.setRotationPoint(-1.0f, -6.0f, -117.0f);
        this.Tooth3.setTextureSize(64, 32);
        this.Tooth3.mirror = true;
        this.setRotation(this.Tooth3, -0.3490659f, 0.0f, 0.0f);
        (this.Tooth4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth4.setRotationPoint(1.0f, -6.0f, -117.0f);
        this.Tooth4.setTextureSize(64, 32);
        this.Tooth4.mirror = true;
        this.setRotation(this.Tooth4, -0.3490659f, 0.0f, 0.0f);
        (this.Tooth5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth5.setRotationPoint(3.0f, -6.0f, -117.0f);
        this.Tooth5.setTextureSize(64, 32);
        this.Tooth5.mirror = true;
        this.setRotation(this.Tooth5, -0.3490659f, 0.0f, 0.0f);
        (this.Tooth6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth6.setRotationPoint(5.0f, -6.0f, -117.0f);
        this.Tooth6.setTextureSize(64, 32);
        this.Tooth6.mirror = true;
        this.setRotation(this.Tooth6, -0.3490659f, 0.0f, 0.0f);
        (this.Tooth7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth7.setRotationPoint(9.0f, -7.0f, -118.0f);
        this.Tooth7.setTextureSize(64, 32);
        this.Tooth7.mirror = true;
        this.setRotation(this.Tooth7, -0.3490659f, 0.1745329f, 0.0f);
        (this.Tooth8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth8.setRotationPoint(10.0f, -9.0f, -119.0f);
        this.Tooth8.setTextureSize(64, 32);
        this.Tooth8.mirror = true;
        this.setRotation(this.Tooth8, -0.3490659f, 0.1745329f, 0.0f);
        (this.Tooth9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth9.setRotationPoint(12.0f, -10.0f, -118.0f);
        this.Tooth9.setTextureSize(64, 32);
        this.Tooth9.mirror = true;
        this.setRotation(this.Tooth9, -0.3490659f, 0.1745329f, 0.0f);
        (this.Tooth10 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth10.setRotationPoint(14.0f, -11.0f, -118.0f);
        this.Tooth10.setTextureSize(64, 32);
        this.Tooth10.mirror = true;
        this.setRotation(this.Tooth10, -0.3490659f, 0.1745329f, 0.0f);
        (this.Tooth11 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth11.setRotationPoint(15.0f, -16.0f, -120.0f);
        this.Tooth11.setTextureSize(64, 32);
        this.Tooth11.mirror = true;
        this.setRotation(this.Tooth11, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth12 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth12.setRotationPoint(15.0f, -18.0f, -120.0f);
        this.Tooth12.setTextureSize(64, 32);
        this.Tooth12.mirror = true;
        this.setRotation(this.Tooth12, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth13 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth13.setRotationPoint(15.0f, -20.0f, -120.0f);
        this.Tooth13.setTextureSize(64, 32);
        this.Tooth13.mirror = true;
        this.setRotation(this.Tooth13, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth14 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth14.setRotationPoint(15.0f, -22.0f, -120.0f);
        this.Tooth14.setTextureSize(64, 32);
        this.Tooth14.mirror = true;
        this.setRotation(this.Tooth14, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth15 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth15.setRotationPoint(15.0f, -24.0f, -120.0f);
        this.Tooth15.setTextureSize(64, 32);
        this.Tooth15.mirror = true;
        this.setRotation(this.Tooth15, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth16 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth16.setRotationPoint(15.0f, -26.0f, -120.0f);
        this.Tooth16.setTextureSize(64, 32);
        this.Tooth16.mirror = true;
        this.setRotation(this.Tooth16, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth17 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth17.setRotationPoint(15.0f, -28.0f, -120.0f);
        this.Tooth17.setTextureSize(64, 32);
        this.Tooth17.mirror = true;
        this.setRotation(this.Tooth17, 0.0f, 0.3490659f, 0.0f);
        (this.Tooth18 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth18.setRotationPoint(13.0f, -31.0f, -122.0f);
        this.Tooth18.setTextureSize(64, 32);
        this.Tooth18.mirror = true;
        this.setRotation(this.Tooth18, 0.1745329f, 0.3490659f, 0.0f);
        (this.Tooth19 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth19.setRotationPoint(11.0f, -33.0f, -122.0f);
        this.Tooth19.setTextureSize(64, 32);
        this.Tooth19.mirror = true;
        this.setRotation(this.Tooth19, 0.1745329f, 0.3490659f, 0.0f);
        (this.Tooth20 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth20.setRotationPoint(9.0f, -35.0f, -122.0f);
        this.Tooth20.setTextureSize(64, 32);
        this.Tooth20.mirror = true;
        this.setRotation(this.Tooth20, 0.1745329f, 0.3490659f, 0.0f);
        (this.Tooth21 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth21.setRotationPoint(9.0f, -35.0f, -122.0f);
        this.Tooth21.setTextureSize(64, 32);
        this.Tooth21.mirror = true;
        this.setRotation(this.Tooth21, 0.1745329f, 0.3490659f, 0.0f);
        (this.Tooth22 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth22.setRotationPoint(5.0f, -37.0f, -122.0f);
        this.Tooth22.setTextureSize(64, 32);
        this.Tooth22.mirror = true;
        this.setRotation(this.Tooth22, 0.3490659f, 0.0f, 0.0f);
        (this.Tooth23 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth23.setRotationPoint(3.0f, -37.0f, -122.0f);
        this.Tooth23.setTextureSize(64, 32);
        this.Tooth23.mirror = true;
        this.setRotation(this.Tooth23, 0.3490659f, 0.0f, 0.0f);
        (this.Tooth24 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth24.setRotationPoint(1.0f, -37.0f, -122.0f);
        this.Tooth24.setTextureSize(64, 32);
        this.Tooth24.mirror = true;
        this.setRotation(this.Tooth24, 0.3490659f, 0.0f, 0.0f);
        (this.Tooth25 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth25.setRotationPoint(-1.0f, -37.0f, -122.0f);
        this.Tooth25.setTextureSize(64, 32);
        this.Tooth25.mirror = true;
        this.setRotation(this.Tooth25, 0.3490659f, 0.0f, 0.0f);
        (this.Tooth26 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth26.setRotationPoint(-3.0f, -37.0f, -122.0f);
        this.Tooth26.setTextureSize(64, 32);
        this.Tooth26.mirror = true;
        this.setRotation(this.Tooth26, 0.3490659f, 0.0f, 0.0f);
        (this.Tooth27 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth27.setRotationPoint(-5.0f, -37.0f, -122.0f);
        this.Tooth27.setTextureSize(64, 32);
        this.Tooth27.mirror = true;
        this.setRotation(this.Tooth27, 0.3490659f, 0.0f, 0.0f);
        (this.Tooth28 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(-1.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth28.setRotationPoint(-8.0f, -36.0f, -122.0f);
        this.Tooth28.setTextureSize(64, 32);
        this.Tooth28.mirror = true;
        this.setRotation(this.Tooth28, 0.3490659f, -0.1745329f, 0.0f);
        (this.Tooth29 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth29.setRotationPoint(-11.0f, -34.0f, -122.0f);
        this.Tooth29.setTextureSize(64, 32);
        this.Tooth29.mirror = true;
        this.setRotation(this.Tooth29, 0.3490659f, -0.1745329f, 0.0f);
        (this.Tooth30 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth30.setRotationPoint(-13.0f, -32.0f, -122.0f);
        this.Tooth30.setTextureSize(64, 32);
        this.Tooth30.mirror = true;
        this.setRotation(this.Tooth30, 0.3490659f, -0.1745329f, 0.0f);
        (this.Tooth31 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth31.setRotationPoint(-14.0f, -30.0f, -122.0f);
        this.Tooth31.setTextureSize(64, 32);
        this.Tooth31.mirror = true;
        this.setRotation(this.Tooth31, 0.3490659f, -0.1745329f, 0.0f);
        (this.Tooth32 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth32.setRotationPoint(-16.0f, -26.0f, -122.0f);
        this.Tooth32.setTextureSize(64, 32);
        this.Tooth32.mirror = true;
        this.setRotation(this.Tooth32, 0.0f, -0.3490659f, 0.0f);
        (this.Tooth33 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth33.setRotationPoint(-16.0f, -24.0f, -122.0f);
        this.Tooth33.setTextureSize(64, 32);
        this.Tooth33.mirror = true;
        this.setRotation(this.Tooth33, 0.0f, -0.3490659f, 0.0f);
        (this.Tooth34 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth34.setRotationPoint(-16.0f, -22.0f, -122.0f);
        this.Tooth34.setTextureSize(64, 32);
        this.Tooth34.mirror = true;
        this.setRotation(this.Tooth34, 0.0f, -0.3490659f, 0.0f);
        (this.Tooth35 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth35.setRotationPoint(-16.0f, -20.0f, -122.0f);
        this.Tooth35.setTextureSize(64, 32);
        this.Tooth35.mirror = true;
        this.setRotation(this.Tooth35, 0.0f, -0.3490659f, 0.0f);
        (this.Tooth36 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth36.setRotationPoint(-16.0f, -18.0f, -122.0f);
        this.Tooth36.setTextureSize(64, 32);
        this.Tooth36.mirror = true;
        this.setRotation(this.Tooth36, 0.0f, -0.3490659f, 0.0f);
        (this.Tooth37 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth37.setRotationPoint(-16.0f, -16.0f, -122.0f);
        this.Tooth37.setTextureSize(64, 32);
        this.Tooth37.mirror = true;
        this.setRotation(this.Tooth37, 0.0f, -0.3490659f, 0.0f);
        (this.Tooth38 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth38.setRotationPoint(-15.0f, -12.0f, -120.0f);
        this.Tooth38.setTextureSize(64, 32);
        this.Tooth38.mirror = true;
        this.setRotation(this.Tooth38, -0.1745329f, -0.3490659f, 0.0f);
        (this.Tooth39 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth39.setRotationPoint(-13.0f, -10.0f, -120.0f);
        this.Tooth39.setTextureSize(64, 32);
        this.Tooth39.mirror = true;
        this.setRotation(this.Tooth39, -0.1745329f, -0.3490659f, 0.0f);
        (this.Tooth40 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth40.setRotationPoint(-11.0f, -8.0f, -120.0f);
        this.Tooth40.setTextureSize(64, 32);
        this.Tooth40.mirror = true;
        this.setRotation(this.Tooth40, -0.1745329f, -0.3490659f, 0.0f);
        (this.Tooth41 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, -8.0f, 1, 1, 8);
        this.Tooth41.setRotationPoint(-9.0f, -7.0f, -119.0f);
        this.Tooth41.setTextureSize(64, 32);
        this.Tooth41.mirror = true;
        this.setRotation(this.Tooth41, -0.1745329f, -0.3490659f, 0.0f);
        (this.Tent17 = new ModelRenderer((ModelBase) this, 0, 90)).addBox(-1.0f, -1.0f, -32.0f, 3, 3, 32);
        this.Tent17.setRotationPoint(-68.0f, -6.0f, -277.0f);
        this.Tent17.setTextureSize(64, 32);
        this.Tent17.mirror = true;
        this.setRotation(this.Tent17, 0.0872665f, -0.1745329f, 0.0f);
        final ModelRenderer lefteye = this.Lefteye;
        lefteye.rotationPointZ += 90.0f;
        final ModelRenderer backbody = this.Backbody;
        backbody.rotationPointZ += 90.0f;
        final ModelRenderer centerbody = this.Centerbody;
        centerbody.rotationPointZ += 90.0f;
        final ModelRenderer head = this.Head;
        head.rotationPointZ += 90.0f;
        final ModelRenderer sucktioncupleft = this.Sucktioncupleft;
        sucktioncupleft.rotationPointZ += 90.0f;
        final ModelRenderer finright = this.Finright;
        finright.rotationPointZ += 90.0f;
        final ModelRenderer tailbase1 = this.Tailbase1;
        tailbase1.rotationPointZ += 90.0f;
        final ModelRenderer tail2 = this.Tail2;
        tail2.rotationPointZ += 90.0f;
        final ModelRenderer tailtip = this.Tailtip;
        tailtip.rotationPointZ += 90.0f;
        final ModelRenderer finleft = this.Finleft;
        finleft.rotationPointZ += 90.0f;
        final ModelRenderer frontbody = this.Frontbody;
        frontbody.rotationPointZ += 90.0f;
        final ModelRenderer mouth1 = this.Mouth1;
        mouth1.rotationPointZ += 90.0f;
        final ModelRenderer tent54 = this.Tent54;
        tent54.rotationPointZ += 90.0f;
        final ModelRenderer tent55 = this.Tent62;
        tent55.rotationPointZ += 90.0f;
        final ModelRenderer tent56 = this.Tent63;
        tent56.rotationPointZ += 90.0f;
        final ModelRenderer tent57 = this.Tent64;
        tent57.rotationPointZ += 90.0f;
        final ModelRenderer tent58 = this.Tent58;
        tent58.rotationPointZ += 90.0f;
        final ModelRenderer tent59 = this.Tent66;
        tent59.rotationPointZ += 90.0f;
        final ModelRenderer tent60 = this.Tent67;
        tent60.rotationPointZ += 90.0f;
        final ModelRenderer tent61 = this.Tent68;
        tent61.rotationPointZ += 90.0f;
        final ModelRenderer tent62 = this.Tent28;
        tent62.rotationPointZ += 90.0f;
        final ModelRenderer tent63 = this.Tent51;
        tent63.rotationPointZ += 90.0f;
        final ModelRenderer tent64 = this.Tent52;
        tent64.rotationPointZ += 90.0f;
        final ModelRenderer tent65 = this.Tent53;
        tent65.rotationPointZ += 90.0f;
        final ModelRenderer tent66 = this.Tent65;
        tent66.rotationPointZ += 90.0f;
        final ModelRenderer tent67 = this.Tent55;
        tent67.rotationPointZ += 90.0f;
        final ModelRenderer tent68 = this.Tent56;
        tent68.rotationPointZ += 90.0f;
        final ModelRenderer tent69 = this.Tent57;
        tent69.rotationPointZ += 90.0f;
        final ModelRenderer sucktioncupright = this.Sucktioncupright;
        sucktioncupright.rotationPointZ += 90.0f;
        final ModelRenderer righteye = this.Righteye;
        righteye.rotationPointZ += 90.0f;
        final ModelRenderer mouth2 = this.Mouth2;
        mouth2.rotationPointZ += 90.0f;
        final ModelRenderer mouth3 = this.Mouth3;
        mouth3.rotationPointZ += 90.0f;
        final ModelRenderer mouth4 = this.Mouth4;
        mouth4.rotationPointZ += 90.0f;
        final ModelRenderer mouth5 = this.Mouth5;
        mouth5.rotationPointZ += 90.0f;
        final ModelRenderer mouth6 = this.Mouth6;
        mouth6.rotationPointZ += 90.0f;
        final ModelRenderer mouth7 = this.Mouth7;
        mouth7.rotationPointZ += 90.0f;
        final ModelRenderer mouth8 = this.Mouth8;
        mouth8.rotationPointZ += 90.0f;
        final ModelRenderer tent70 = this.Tent61;
        tent70.rotationPointZ += 90.0f;
        final ModelRenderer tent71 = this.Tent38;
        tent71.rotationPointZ += 90.0f;
        final ModelRenderer tent72 = this.Tent22;
        tent72.rotationPointZ += 90.0f;
        final ModelRenderer tent73 = this.Tent23;
        tent73.rotationPointZ += 90.0f;
        final ModelRenderer tent74 = this.Tent24;
        tent74.rotationPointZ += 90.0f;
        final ModelRenderer tent75 = this.Tent25;
        tent75.rotationPointZ += 90.0f;
        final ModelRenderer tent76 = this.Tent26;
        tent76.rotationPointZ += 90.0f;
        final ModelRenderer tent77 = this.Tent27;
        tent77.rotationPointZ += 90.0f;
        final ModelRenderer tooth1 = this.Tooth1;
        tooth1.rotationPointZ += 90.0f;
        final ModelRenderer tent78 = this.Tent48;
        tent78.rotationPointZ += 90.0f;
        final ModelRenderer tent79 = this.Tent32;
        tent79.rotationPointZ += 90.0f;
        final ModelRenderer tent80 = this.Tent33;
        tent80.rotationPointZ += 90.0f;
        final ModelRenderer tent81 = this.Tent34;
        tent81.rotationPointZ += 90.0f;
        final ModelRenderer tent82 = this.Tent35;
        tent82.rotationPointZ += 90.0f;
        final ModelRenderer tent83 = this.Tent36;
        tent83.rotationPointZ += 90.0f;
        final ModelRenderer tent84 = this.Tent37;
        tent84.rotationPointZ += 90.0f;
        final ModelRenderer jet = this.Jet;
        jet.rotationPointZ += 90.0f;
        final ModelRenderer tent85 = this.Tent41;
        tent85.rotationPointZ += 90.0f;
        final ModelRenderer tent86 = this.Tent42;
        tent86.rotationPointZ += 90.0f;
        final ModelRenderer tent87 = this.Tent43;
        tent87.rotationPointZ += 90.0f;
        final ModelRenderer tent88 = this.Tent44;
        tent88.rotationPointZ += 90.0f;
        final ModelRenderer tent89 = this.Tent45;
        tent89.rotationPointZ += 90.0f;
        final ModelRenderer tent90 = this.Tent46;
        tent90.rotationPointZ += 90.0f;
        final ModelRenderer tent91 = this.Tent47;
        tent91.rotationPointZ += 90.0f;
        final ModelRenderer tent92 = this.Tent21;
        tent92.rotationPointZ += 90.0f;
        final ModelRenderer tent93 = this.Tent11;
        tent93.rotationPointZ += 90.0f;
        final ModelRenderer tent94 = this.Tent12;
        tent94.rotationPointZ += 90.0f;
        final ModelRenderer tent95 = this.Tent13;
        tent95.rotationPointZ += 90.0f;
        final ModelRenderer tent96 = this.Tent14;
        tent96.rotationPointZ += 90.0f;
        final ModelRenderer tent97 = this.Tent15;
        tent97.rotationPointZ += 90.0f;
        final ModelRenderer tent98 = this.Tent16;
        tent98.rotationPointZ += 90.0f;
        final ModelRenderer tent99 = this.Tent31;
        tent99.rotationPointZ += 90.0f;
        final ModelRenderer tent100 = this.Tent18;
        tent100.rotationPointZ += 90.0f;
        final ModelRenderer tooth2 = this.Tooth2;
        tooth2.rotationPointZ += 90.0f;
        final ModelRenderer tooth3 = this.Tooth3;
        tooth3.rotationPointZ += 90.0f;
        final ModelRenderer tooth4 = this.Tooth4;
        tooth4.rotationPointZ += 90.0f;
        final ModelRenderer tooth5 = this.Tooth5;
        tooth5.rotationPointZ += 90.0f;
        final ModelRenderer tooth6 = this.Tooth6;
        tooth6.rotationPointZ += 90.0f;
        final ModelRenderer tooth7 = this.Tooth7;
        tooth7.rotationPointZ += 90.0f;
        final ModelRenderer tooth8 = this.Tooth8;
        tooth8.rotationPointZ += 90.0f;
        final ModelRenderer tooth9 = this.Tooth9;
        tooth9.rotationPointZ += 90.0f;
        final ModelRenderer tooth10 = this.Tooth10;
        tooth10.rotationPointZ += 90.0f;
        final ModelRenderer tooth11 = this.Tooth11;
        tooth11.rotationPointZ += 90.0f;
        final ModelRenderer tooth12 = this.Tooth12;
        tooth12.rotationPointZ += 90.0f;
        final ModelRenderer tooth13 = this.Tooth13;
        tooth13.rotationPointZ += 90.0f;
        final ModelRenderer tooth14 = this.Tooth14;
        tooth14.rotationPointZ += 90.0f;
        final ModelRenderer tooth15 = this.Tooth15;
        tooth15.rotationPointZ += 90.0f;
        final ModelRenderer tooth16 = this.Tooth16;
        tooth16.rotationPointZ += 90.0f;
        final ModelRenderer tooth17 = this.Tooth17;
        tooth17.rotationPointZ += 90.0f;
        final ModelRenderer tooth18 = this.Tooth18;
        tooth18.rotationPointZ += 90.0f;
        final ModelRenderer tooth19 = this.Tooth19;
        tooth19.rotationPointZ += 90.0f;
        final ModelRenderer tooth20 = this.Tooth20;
        tooth20.rotationPointZ += 90.0f;
        final ModelRenderer tooth21 = this.Tooth21;
        tooth21.rotationPointZ += 90.0f;
        final ModelRenderer tooth22 = this.Tooth22;
        tooth22.rotationPointZ += 90.0f;
        final ModelRenderer tooth23 = this.Tooth23;
        tooth23.rotationPointZ += 90.0f;
        final ModelRenderer tooth24 = this.Tooth24;
        tooth24.rotationPointZ += 90.0f;
        final ModelRenderer tooth25 = this.Tooth25;
        tooth25.rotationPointZ += 90.0f;
        final ModelRenderer tooth26 = this.Tooth26;
        tooth26.rotationPointZ += 90.0f;
        final ModelRenderer tooth27 = this.Tooth27;
        tooth27.rotationPointZ += 90.0f;
        final ModelRenderer tooth28 = this.Tooth28;
        tooth28.rotationPointZ += 90.0f;
        final ModelRenderer tooth29 = this.Tooth29;
        tooth29.rotationPointZ += 90.0f;
        final ModelRenderer tooth30 = this.Tooth30;
        tooth30.rotationPointZ += 90.0f;
        final ModelRenderer tooth31 = this.Tooth31;
        tooth31.rotationPointZ += 90.0f;
        final ModelRenderer tooth32 = this.Tooth32;
        tooth32.rotationPointZ += 90.0f;
        final ModelRenderer tooth33 = this.Tooth33;
        tooth33.rotationPointZ += 90.0f;
        final ModelRenderer tooth34 = this.Tooth34;
        tooth34.rotationPointZ += 90.0f;
        final ModelRenderer tooth35 = this.Tooth35;
        tooth35.rotationPointZ += 90.0f;
        final ModelRenderer tooth36 = this.Tooth36;
        tooth36.rotationPointZ += 90.0f;
        final ModelRenderer tooth37 = this.Tooth37;
        tooth37.rotationPointZ += 90.0f;
        final ModelRenderer tooth38 = this.Tooth38;
        tooth38.rotationPointZ += 90.0f;
        final ModelRenderer tooth39 = this.Tooth39;
        tooth39.rotationPointZ += 90.0f;
        final ModelRenderer tooth40 = this.Tooth40;
        tooth40.rotationPointZ += 90.0f;
        final ModelRenderer tooth41 = this.Tooth41;
        tooth41.rotationPointZ += 90.0f;
        final ModelRenderer tent101 = this.Tent17;
        tent101.rotationPointZ += 90.0f;
        final ModelRenderer lefteye2 = this.Lefteye;
        lefteye2.rotationPointY += 30.0f;
        final ModelRenderer backbody2 = this.Backbody;
        backbody2.rotationPointY += 30.0f;
        final ModelRenderer centerbody2 = this.Centerbody;
        centerbody2.rotationPointY += 30.0f;
        final ModelRenderer head2 = this.Head;
        head2.rotationPointY += 30.0f;
        final ModelRenderer sucktioncupleft2 = this.Sucktioncupleft;
        sucktioncupleft2.rotationPointY += 30.0f;
        final ModelRenderer finright2 = this.Finright;
        finright2.rotationPointY += 30.0f;
        final ModelRenderer tailbase2 = this.Tailbase1;
        tailbase2.rotationPointY += 30.0f;
        final ModelRenderer tail3 = this.Tail2;
        tail3.rotationPointY += 30.0f;
        final ModelRenderer tailtip2 = this.Tailtip;
        tailtip2.rotationPointY += 30.0f;
        final ModelRenderer finleft2 = this.Finleft;
        finleft2.rotationPointY += 30.0f;
        final ModelRenderer frontbody2 = this.Frontbody;
        frontbody2.rotationPointY += 30.0f;
        final ModelRenderer mouth9 = this.Mouth1;
        mouth9.rotationPointY += 30.0f;
        final ModelRenderer tent102 = this.Tent54;
        tent102.rotationPointY += 30.0f;
        final ModelRenderer tent103 = this.Tent62;
        tent103.rotationPointY += 30.0f;
        final ModelRenderer tent104 = this.Tent63;
        tent104.rotationPointY += 30.0f;
        final ModelRenderer tent105 = this.Tent64;
        tent105.rotationPointY += 30.0f;
        final ModelRenderer tent106 = this.Tent58;
        tent106.rotationPointY += 30.0f;
        final ModelRenderer tent107 = this.Tent66;
        tent107.rotationPointY += 30.0f;
        final ModelRenderer tent108 = this.Tent67;
        tent108.rotationPointY += 30.0f;
        final ModelRenderer tent109 = this.Tent68;
        tent109.rotationPointY += 30.0f;
        final ModelRenderer tent110 = this.Tent28;
        tent110.rotationPointY += 30.0f;
        final ModelRenderer tent111 = this.Tent51;
        tent111.rotationPointY += 30.0f;
        final ModelRenderer tent112 = this.Tent52;
        tent112.rotationPointY += 30.0f;
        final ModelRenderer tent113 = this.Tent53;
        tent113.rotationPointY += 30.0f;
        final ModelRenderer tent114 = this.Tent65;
        tent114.rotationPointY += 30.0f;
        final ModelRenderer tent115 = this.Tent55;
        tent115.rotationPointY += 30.0f;
        final ModelRenderer tent116 = this.Tent56;
        tent116.rotationPointY += 30.0f;
        final ModelRenderer tent117 = this.Tent57;
        tent117.rotationPointY += 30.0f;
        final ModelRenderer sucktioncupright2 = this.Sucktioncupright;
        sucktioncupright2.rotationPointY += 30.0f;
        final ModelRenderer righteye2 = this.Righteye;
        righteye2.rotationPointY += 30.0f;
        final ModelRenderer mouth10 = this.Mouth2;
        mouth10.rotationPointY += 30.0f;
        final ModelRenderer mouth11 = this.Mouth3;
        mouth11.rotationPointY += 30.0f;
        final ModelRenderer mouth12 = this.Mouth4;
        mouth12.rotationPointY += 30.0f;
        final ModelRenderer mouth13 = this.Mouth5;
        mouth13.rotationPointY += 30.0f;
        final ModelRenderer mouth14 = this.Mouth6;
        mouth14.rotationPointY += 30.0f;
        final ModelRenderer mouth15 = this.Mouth7;
        mouth15.rotationPointY += 30.0f;
        final ModelRenderer mouth16 = this.Mouth8;
        mouth16.rotationPointY += 30.0f;
        final ModelRenderer tent118 = this.Tent61;
        tent118.rotationPointY += 30.0f;
        final ModelRenderer tent119 = this.Tent38;
        tent119.rotationPointY += 30.0f;
        final ModelRenderer tent120 = this.Tent22;
        tent120.rotationPointY += 30.0f;
        final ModelRenderer tent121 = this.Tent23;
        tent121.rotationPointY += 30.0f;
        final ModelRenderer tent122 = this.Tent24;
        tent122.rotationPointY += 30.0f;
        final ModelRenderer tent123 = this.Tent25;
        tent123.rotationPointY += 30.0f;
        final ModelRenderer tent124 = this.Tent26;
        tent124.rotationPointY += 30.0f;
        final ModelRenderer tent125 = this.Tent27;
        tent125.rotationPointY += 30.0f;
        final ModelRenderer tooth42 = this.Tooth1;
        tooth42.rotationPointY += 30.0f;
        final ModelRenderer tent126 = this.Tent48;
        tent126.rotationPointY += 30.0f;
        final ModelRenderer tent127 = this.Tent32;
        tent127.rotationPointY += 30.0f;
        final ModelRenderer tent128 = this.Tent33;
        tent128.rotationPointY += 30.0f;
        final ModelRenderer tent129 = this.Tent34;
        tent129.rotationPointY += 30.0f;
        final ModelRenderer tent130 = this.Tent35;
        tent130.rotationPointY += 30.0f;
        final ModelRenderer tent131 = this.Tent36;
        tent131.rotationPointY += 30.0f;
        final ModelRenderer tent132 = this.Tent37;
        tent132.rotationPointY += 30.0f;
        final ModelRenderer jet2 = this.Jet;
        jet2.rotationPointY += 30.0f;
        final ModelRenderer tent133 = this.Tent41;
        tent133.rotationPointY += 30.0f;
        final ModelRenderer tent134 = this.Tent42;
        tent134.rotationPointY += 30.0f;
        final ModelRenderer tent135 = this.Tent43;
        tent135.rotationPointY += 30.0f;
        final ModelRenderer tent136 = this.Tent44;
        tent136.rotationPointY += 30.0f;
        final ModelRenderer tent137 = this.Tent45;
        tent137.rotationPointY += 30.0f;
        final ModelRenderer tent138 = this.Tent46;
        tent138.rotationPointY += 30.0f;
        final ModelRenderer tent139 = this.Tent47;
        tent139.rotationPointY += 30.0f;
        final ModelRenderer tent140 = this.Tent21;
        tent140.rotationPointY += 30.0f;
        final ModelRenderer tent141 = this.Tent11;
        tent141.rotationPointY += 30.0f;
        final ModelRenderer tent142 = this.Tent12;
        tent142.rotationPointY += 30.0f;
        final ModelRenderer tent143 = this.Tent13;
        tent143.rotationPointY += 30.0f;
        final ModelRenderer tent144 = this.Tent14;
        tent144.rotationPointY += 30.0f;
        final ModelRenderer tent145 = this.Tent15;
        tent145.rotationPointY += 30.0f;
        final ModelRenderer tent146 = this.Tent16;
        tent146.rotationPointY += 30.0f;
        final ModelRenderer tent147 = this.Tent31;
        tent147.rotationPointY += 30.0f;
        final ModelRenderer tent148 = this.Tent18;
        tent148.rotationPointY += 30.0f;
        final ModelRenderer tooth43 = this.Tooth2;
        tooth43.rotationPointY += 30.0f;
        final ModelRenderer tooth44 = this.Tooth3;
        tooth44.rotationPointY += 30.0f;
        final ModelRenderer tooth45 = this.Tooth4;
        tooth45.rotationPointY += 30.0f;
        final ModelRenderer tooth46 = this.Tooth5;
        tooth46.rotationPointY += 30.0f;
        final ModelRenderer tooth47 = this.Tooth6;
        tooth47.rotationPointY += 30.0f;
        final ModelRenderer tooth48 = this.Tooth7;
        tooth48.rotationPointY += 30.0f;
        final ModelRenderer tooth49 = this.Tooth8;
        tooth49.rotationPointY += 30.0f;
        final ModelRenderer tooth50 = this.Tooth9;
        tooth50.rotationPointY += 30.0f;
        final ModelRenderer tooth51 = this.Tooth10;
        tooth51.rotationPointY += 30.0f;
        final ModelRenderer tooth52 = this.Tooth11;
        tooth52.rotationPointY += 30.0f;
        final ModelRenderer tooth53 = this.Tooth12;
        tooth53.rotationPointY += 30.0f;
        final ModelRenderer tooth54 = this.Tooth13;
        tooth54.rotationPointY += 30.0f;
        final ModelRenderer tooth55 = this.Tooth14;
        tooth55.rotationPointY += 30.0f;
        final ModelRenderer tooth56 = this.Tooth15;
        tooth56.rotationPointY += 30.0f;
        final ModelRenderer tooth57 = this.Tooth16;
        tooth57.rotationPointY += 30.0f;
        final ModelRenderer tooth58 = this.Tooth17;
        tooth58.rotationPointY += 30.0f;
        final ModelRenderer tooth59 = this.Tooth18;
        tooth59.rotationPointY += 30.0f;
        final ModelRenderer tooth60 = this.Tooth19;
        tooth60.rotationPointY += 30.0f;
        final ModelRenderer tooth61 = this.Tooth20;
        tooth61.rotationPointY += 30.0f;
        final ModelRenderer tooth62 = this.Tooth21;
        tooth62.rotationPointY += 30.0f;
        final ModelRenderer tooth63 = this.Tooth22;
        tooth63.rotationPointY += 30.0f;
        final ModelRenderer tooth64 = this.Tooth23;
        tooth64.rotationPointY += 30.0f;
        final ModelRenderer tooth65 = this.Tooth24;
        tooth65.rotationPointY += 30.0f;
        final ModelRenderer tooth66 = this.Tooth25;
        tooth66.rotationPointY += 30.0f;
        final ModelRenderer tooth67 = this.Tooth26;
        tooth67.rotationPointY += 30.0f;
        final ModelRenderer tooth68 = this.Tooth27;
        tooth68.rotationPointY += 30.0f;
        final ModelRenderer tooth69 = this.Tooth28;
        tooth69.rotationPointY += 30.0f;
        final ModelRenderer tooth70 = this.Tooth29;
        tooth70.rotationPointY += 30.0f;
        final ModelRenderer tooth71 = this.Tooth30;
        tooth71.rotationPointY += 30.0f;
        final ModelRenderer tooth72 = this.Tooth31;
        tooth72.rotationPointY += 30.0f;
        final ModelRenderer tooth73 = this.Tooth32;
        tooth73.rotationPointY += 30.0f;
        final ModelRenderer tooth74 = this.Tooth33;
        tooth74.rotationPointY += 30.0f;
        final ModelRenderer tooth75 = this.Tooth34;
        tooth75.rotationPointY += 30.0f;
        final ModelRenderer tooth76 = this.Tooth35;
        tooth76.rotationPointY += 30.0f;
        final ModelRenderer tooth77 = this.Tooth36;
        tooth77.rotationPointY += 30.0f;
        final ModelRenderer tooth78 = this.Tooth37;
        tooth78.rotationPointY += 30.0f;
        final ModelRenderer tooth79 = this.Tooth38;
        tooth79.rotationPointY += 30.0f;
        final ModelRenderer tooth80 = this.Tooth39;
        tooth80.rotationPointY += 30.0f;
        final ModelRenderer tooth81 = this.Tooth40;
        tooth81.rotationPointY += 30.0f;
        final ModelRenderer tooth82 = this.Tooth41;
        tooth82.rotationPointY += 30.0f;
        final ModelRenderer tent149 = this.Tent17;
        tent149.rotationPointY += 30.0f;
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final Kraken e = (Kraken) entity;
        RenderInfo r = null;
        float newangle = 0.0f;
        float nextangle = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        this.Finright.rotateAngleZ = MathHelper.cos(f2 * 0.43f * this.wingspeed) * 3.1415927f * 0.15f;
        this.Finleft.rotateAngleZ = MathHelper.cos(f2 * 0.32f * this.wingspeed) * 3.1415927f * 0.14f;
        final float pi4 = 0.39269876f;
        this.dangle_tentacle(
            f2,
            5,
            e.getAttacking(),
            this.Tent51,
            this.Tent52,
            this.Tent53,
            this.Tent54,
            this.Tent55,
            this.Tent56,
            this.Tent57,
            this.Tent58);
        this.dangle_tentacle(
            f2,
            6,
            e.getAttacking(),
            this.Tent61,
            this.Tent62,
            this.Tent63,
            this.Tent64,
            this.Tent65,
            this.Tent66,
            this.Tent67,
            this.Tent68);
        this.Sucktioncupleft.rotationPointY = this.Tent58.rotationPointY
            + (float) Math.sin(this.Tent58.rotateAngleX) * 30.0f * (float) Math.cos(this.Tent58.rotateAngleY);
        this.Sucktioncupleft.rotationPointZ = this.Tent58.rotationPointZ
            - (float) Math.cos(this.Tent58.rotateAngleX) * 30.0f * (float) Math.cos(this.Tent58.rotateAngleY);
        this.Sucktioncupleft.rotationPointX = this.Tent58.rotationPointX
            - (float) Math.sin(this.Tent58.rotateAngleY) * 30.0f * (float) Math.cos(this.Tent58.rotateAngleX);
        this.Sucktioncupleft.rotateAngleX = this.Tent58.rotateAngleX;
        this.Sucktioncupleft.rotateAngleY = this.Tent58.rotateAngleY;
        this.Sucktioncupright.rotationPointY = this.Tent68.rotationPointY
            + (float) Math.sin(this.Tent68.rotateAngleX) * 30.0f * (float) Math.cos(this.Tent68.rotateAngleY);
        this.Sucktioncupright.rotationPointZ = this.Tent68.rotationPointZ
            - (float) Math.cos(this.Tent68.rotateAngleX) * 30.0f * (float) Math.cos(this.Tent68.rotateAngleY);
        this.Sucktioncupright.rotationPointX = this.Tent68.rotationPointX
            - (float) Math.sin(this.Tent68.rotateAngleY) * 30.0f * (float) Math.cos(this.Tent68.rotateAngleX);
        this.Sucktioncupright.rotateAngleX = this.Tent68.rotateAngleX;
        this.Sucktioncupright.rotateAngleY = this.Tent68.rotateAngleY;
        r = e.getRenderInfo();
        newangle = MathHelper.cos(f2 * 0.66f) * 3.1415927f * 0.15f;
        nextangle = MathHelper.cos((f2 + 0.1f) * 0.66f) * 3.1415927f * 0.15f;
        if (nextangle > 0.0f && newangle < 0.0f) {
            r.ri1 = 0;
            if (e.getAttacking() == 0) {
                r.ri1 = e.worldObj.rand.nextInt(10);
                r.ri2 = e.worldObj.rand.nextInt(15);
            } else {
                r.ri1 = e.worldObj.rand.nextInt(4);
                r.ri2 = e.worldObj.rand.nextInt(3);
            }
        }
        if (r.ri1 == 1 || r.ri1 == 3) {
            newangle = MathHelper.cos(f2 * 0.5f * this.wingspeed) * 3.1415927f * 0.015f;
        } else {
            newangle = 0.0f;
        }
        this.Mouth1.rotateAngleX = -0.38f + newangle;
        this.Mouth1.rotateAngleY = -0.38f + newangle;
        this.Mouth2.rotateAngleX = -0.38f + newangle;
        this.Mouth2.rotateAngleY = 0.38f - newangle;
        this.Mouth3.rotateAngleX = 0.38f - newangle;
        this.Mouth3.rotateAngleY = 0.38f - newangle;
        this.Mouth5.rotateAngleX = 0.38f - newangle;
        this.Mouth5.rotateAngleY = -0.38f + newangle;
        this.Mouth4.rotateAngleX = 0.38f - newangle;
        this.Mouth6.rotateAngleY = -0.38f + newangle;
        this.Mouth7.rotateAngleY = 0.38f - newangle;
        this.Mouth8.rotateAngleX = -0.38f + newangle;
        newangle *= 7.0f;
        this.Tooth2.rotateAngleX = -0.35f - newangle;
        this.Tooth3.rotateAngleX = -0.34f - newangle;
        this.Tooth4.rotateAngleX = -0.33f - newangle;
        this.Tooth5.rotateAngleX = -0.36f - newangle;
        this.Tooth6.rotateAngleX = -0.32f - newangle;
        this.Tooth11.rotateAngleY = 0.35f + newangle;
        this.Tooth12.rotateAngleY = 0.37f + newangle;
        this.Tooth13.rotateAngleY = 0.33f + newangle;
        this.Tooth14.rotateAngleY = 0.34f + newangle;
        this.Tooth15.rotateAngleY = 0.36f + newangle;
        this.Tooth16.rotateAngleY = 0.35f + newangle;
        this.Tooth17.rotateAngleY = 0.32f + newangle;
        this.Tooth22.rotateAngleX = 0.31f + newangle;
        this.Tooth23.rotateAngleX = 0.37f + newangle;
        this.Tooth24.rotateAngleX = 0.33f + newangle;
        this.Tooth25.rotateAngleX = 0.34f + newangle;
        this.Tooth26.rotateAngleX = 0.36f + newangle;
        this.Tooth27.rotateAngleX = 0.35f + newangle;
        this.Tooth31.rotateAngleY = -0.35f - newangle;
        this.Tooth32.rotateAngleY = -0.37f - newangle;
        this.Tooth33.rotateAngleY = -0.33f - newangle;
        this.Tooth34.rotateAngleY = -0.34f - newangle;
        this.Tooth35.rotateAngleY = -0.36f - newangle;
        this.Tooth36.rotateAngleY = -0.35f - newangle;
        this.Tooth37.rotateAngleY = -0.32f - newangle;
        this.Tooth7.rotateAngleX = -0.35f - newangle;
        this.Tooth7.rotateAngleY = 0.33f + newangle;
        this.Tooth8.rotateAngleX = -0.31f - newangle;
        this.Tooth8.rotateAngleY = 0.37f + newangle;
        this.Tooth9.rotateAngleX = -0.32f - newangle;
        this.Tooth9.rotateAngleY = 0.3f + newangle;
        this.Tooth10.rotateAngleX = -0.33f - newangle;
        this.Tooth10.rotateAngleY = 0.33f + newangle;
        this.Tooth18.rotateAngleX = 0.35f + newangle;
        this.Tooth18.rotateAngleY = 0.33f + newangle;
        this.Tooth19.rotateAngleX = 0.31f + newangle;
        this.Tooth19.rotateAngleY = 0.37f + newangle;
        this.Tooth20.rotateAngleX = 0.37f + newangle;
        this.Tooth20.rotateAngleY = 0.37f + newangle;
        this.Tooth21.rotateAngleX = 0.3f + newangle;
        this.Tooth21.rotateAngleY = 0.3f + newangle;
        this.Tooth28.rotateAngleX = 0.37f + newangle;
        this.Tooth28.rotateAngleY = -0.3f - newangle;
        this.Tooth29.rotateAngleX = 0.33f + newangle;
        this.Tooth29.rotateAngleY = -0.32f - newangle;
        this.Tooth30.rotateAngleX = 0.3f + newangle;
        this.Tooth30.rotateAngleY = -0.37f - newangle;
        this.Tooth31.rotateAngleX = 0.37f + newangle;
        this.Tooth31.rotateAngleY = -0.3f - newangle;
        this.Tooth38.rotateAngleX = -0.34f - newangle;
        this.Tooth38.rotateAngleY = -0.33f - newangle;
        this.Tooth39.rotateAngleX = -0.35f - newangle;
        this.Tooth39.rotateAngleY = -0.37f - newangle;
        this.Tooth40.rotateAngleX = -0.39f - newangle;
        this.Tooth40.rotateAngleY = -0.33f - newangle;
        this.Tooth41.rotateAngleX = -0.34f - newangle;
        this.Tooth41.rotateAngleY = -0.36f - newangle;
        this.Tooth1.rotateAngleX = -0.35f - newangle;
        this.Tooth1.rotateAngleY = -0.32f - newangle;
        e.setRenderInfo(r);
        this.dangle_tentacle(
            f2,
            1,
            0,
            this.Tent11,
            this.Tent12,
            this.Tent13,
            this.Tent14,
            this.Tent15,
            this.Tent16,
            this.Tent17,
            this.Tent18);
        this.dangle_tentacle(
            f2,
            2,
            0,
            this.Tent21,
            this.Tent22,
            this.Tent23,
            this.Tent24,
            this.Tent25,
            this.Tent26,
            this.Tent27,
            this.Tent28);
        this.dangle_tentacle(
            f2,
            3,
            0,
            this.Tent31,
            this.Tent32,
            this.Tent33,
            this.Tent34,
            this.Tent35,
            this.Tent36,
            this.Tent37,
            this.Tent38);
        this.dangle_tentacle(
            f2,
            4,
            0,
            this.Tent41,
            this.Tent42,
            this.Tent43,
            this.Tent44,
            this.Tent45,
            this.Tent46,
            this.Tent47,
            this.Tent48);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        GL11.glRotatef(90.0f, 1.0f, 0.0f, 0.0f);
        GL11.glTranslatef(0.0f, 0.0f, 0.0f);
        this.Lefteye.render(f5);
        this.Backbody.render(f5);
        this.Centerbody.render(f5);
        this.Head.render(f5);
        this.Sucktioncupleft.render(f5);
        this.Finright.render(f5);
        this.Tailbase1.render(f5);
        this.Tail2.render(f5);
        this.Tailtip.render(f5);
        this.Finleft.render(f5);
        this.Frontbody.render(f5);
        this.Mouth1.render(f5);
        this.Tent54.render(f5);
        this.Tent62.render(f5);
        this.Tent63.render(f5);
        this.Tent64.render(f5);
        this.Tent58.render(f5);
        this.Tent66.render(f5);
        this.Tent67.render(f5);
        this.Tent68.render(f5);
        this.Tent28.render(f5);
        this.Tent51.render(f5);
        this.Tent52.render(f5);
        this.Tent53.render(f5);
        this.Tent65.render(f5);
        this.Tent55.render(f5);
        this.Tent56.render(f5);
        this.Tent57.render(f5);
        this.Sucktioncupright.render(f5);
        this.Righteye.render(f5);
        this.Mouth2.render(f5);
        this.Mouth3.render(f5);
        this.Mouth4.render(f5);
        this.Mouth5.render(f5);
        this.Mouth6.render(f5);
        this.Mouth7.render(f5);
        this.Mouth8.render(f5);
        this.Tent61.render(f5);
        this.Tent38.render(f5);
        this.Tent22.render(f5);
        this.Tent23.render(f5);
        this.Tent24.render(f5);
        this.Tent25.render(f5);
        this.Tent26.render(f5);
        this.Tent27.render(f5);
        this.Tooth1.render(f5);
        this.Tent48.render(f5);
        this.Tent32.render(f5);
        this.Tent33.render(f5);
        this.Tent34.render(f5);
        this.Tent35.render(f5);
        this.Tent36.render(f5);
        this.Tent37.render(f5);
        this.Jet.render(f5);
        this.Tent41.render(f5);
        this.Tent42.render(f5);
        this.Tent43.render(f5);
        this.Tent44.render(f5);
        this.Tent45.render(f5);
        this.Tent46.render(f5);
        this.Tent47.render(f5);
        this.Tent21.render(f5);
        this.Tent11.render(f5);
        this.Tent12.render(f5);
        this.Tent13.render(f5);
        this.Tent14.render(f5);
        this.Tent15.render(f5);
        this.Tent16.render(f5);
        this.Tent31.render(f5);
        this.Tent18.render(f5);
        this.Tooth2.render(f5);
        this.Tooth3.render(f5);
        this.Tooth4.render(f5);
        this.Tooth5.render(f5);
        this.Tooth6.render(f5);
        this.Tooth7.render(f5);
        this.Tooth8.render(f5);
        this.Tooth9.render(f5);
        this.Tooth10.render(f5);
        this.Tooth11.render(f5);
        this.Tooth12.render(f5);
        this.Tooth13.render(f5);
        this.Tooth14.render(f5);
        this.Tooth15.render(f5);
        this.Tooth16.render(f5);
        this.Tooth17.render(f5);
        this.Tooth18.render(f5);
        this.Tooth19.render(f5);
        this.Tooth20.render(f5);
        this.Tooth21.render(f5);
        this.Tooth22.render(f5);
        this.Tooth23.render(f5);
        this.Tooth24.render(f5);
        this.Tooth25.render(f5);
        this.Tooth26.render(f5);
        this.Tooth27.render(f5);
        this.Tooth28.render(f5);
        this.Tooth29.render(f5);
        this.Tooth30.render(f5);
        this.Tooth31.render(f5);
        this.Tooth32.render(f5);
        this.Tooth33.render(f5);
        this.Tooth34.render(f5);
        this.Tooth35.render(f5);
        this.Tooth36.render(f5);
        this.Tooth37.render(f5);
        this.Tooth38.render(f5);
        this.Tooth39.render(f5);
        this.Tooth40.render(f5);
        this.Tooth41.render(f5);
        this.Tent17.render(f5);
        GL11.glPopMatrix();
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

    private void dangle_tentacle(final float f2, final int dir, final int att, final ModelRenderer p1,
        final ModelRenderer p2, final ModelRenderer p3, final ModelRenderer p4, final ModelRenderer p5,
        final ModelRenderer p6, final ModelRenderer p7, final ModelRenderer p8) {
        final float pi4 = 0.314159f;
        final int dist = 30;
        float differ = 0.1f;
        float xoff = 0.0f;
        float ydiffer = 0.1f;
        float yoff = 0.0f;
        float s = -1.0f;
        float amp = 0.1f;
        if (dir == 1) {
            differ = 0.101f;
        }
        if (dir == 2) {
            differ = 0.097f;
        }
        if (dir == 3) {
            differ = 0.093f;
        }
        if (dir == 4) {
            differ = 0.087f;
        }
        if (dir == 1) {
            ydiffer = 0.102f;
        }
        if (dir == 2) {
            ydiffer = 0.098f;
        }
        if (dir == 3) {
            ydiffer = 0.092f;
        }
        if (dir == 4) {
            ydiffer = 0.088f;
        }
        if (dir == 2) {
            xoff = 0.26f;
        }
        if (dir == 3) {
            xoff = 0.26f;
        }
        if (dir == 1) {
            yoff = 0.44f;
        }
        if (dir == 4) {
            yoff = -0.44f;
        }
        if (dir == 5) {
            differ = 0.2f;
        }
        if (dir == 6) {
            differ = 0.2f;
        }
        if (dir == 5) {
            xoff = -0.25f;
        }
        if (dir == 6) {
            xoff = -0.25f;
        }
        if (dir == 6) {
            s = 1.0f;
        }
        if (att != 0) {
            if (dir == 5) {
                differ = 0.5f;
                amp = 0.03f;
                xoff = 0.0f;
            }
            if (dir == 6) {
                differ = 0.5f;
                amp = 0.03f;
                xoff = 0.0f;
            }
        }
        p1.rotateAngleX = xoff + s * MathHelper.cos(f2 * differ * this.wingspeed) * 3.1415927f * amp;
        p1.rotateAngleY = yoff - MathHelper.cos(f2 * ydiffer * this.wingspeed) * 3.1415927f * amp;
        p2.rotationPointY = p1.rotationPointY
            + (float) Math.sin(p1.rotateAngleX) * dist * (float) Math.cos(p1.rotateAngleY);
        p2.rotationPointZ = p1.rotationPointZ
            - (float) Math.cos(p1.rotateAngleX) * dist * (float) Math.cos(p1.rotateAngleY);
        p2.rotationPointX = p1.rotationPointX
            - (float) Math.sin(p1.rotateAngleY) * dist * (float) Math.cos(p1.rotateAngleX);
        p2.rotateAngleX = xoff / 2.0f + s * MathHelper.cos(f2 * differ * this.wingspeed - pi4) * 3.1415927f * amp;
        p2.rotateAngleY = yoff / 2.0f - MathHelper.cos(f2 * ydiffer * this.wingspeed - pi4) * 3.1415927f * amp;
        p3.rotationPointY = p2.rotationPointY
            + (float) Math.sin(p2.rotateAngleX) * dist * (float) Math.cos(p2.rotateAngleY);
        p3.rotationPointZ = p2.rotationPointZ
            - (float) Math.cos(p2.rotateAngleX) * dist * (float) Math.cos(p2.rotateAngleY);
        p3.rotationPointX = p2.rotationPointX
            - (float) Math.sin(p2.rotateAngleY) * dist * (float) Math.cos(p2.rotateAngleX);
        p3.rotateAngleX = s * MathHelper.cos(f2 * differ * this.wingspeed - 2.0f * pi4) * 3.1415927f * amp;
        p3.rotateAngleY = -MathHelper.cos(f2 * ydiffer * this.wingspeed - 2.0f * pi4) * 3.1415927f * amp;
        p4.rotationPointY = p3.rotationPointY
            + (float) Math.sin(p3.rotateAngleX) * dist * (float) Math.cos(p3.rotateAngleY);
        p4.rotationPointZ = p3.rotationPointZ
            - (float) Math.cos(p3.rotateAngleX) * dist * (float) Math.cos(p3.rotateAngleY);
        p4.rotationPointX = p3.rotationPointX
            - (float) Math.sin(p3.rotateAngleY) * dist * (float) Math.cos(p3.rotateAngleX);
        p4.rotateAngleX = s * MathHelper.cos(f2 * differ * this.wingspeed - 3.0f * pi4) * 3.1415927f * amp;
        p4.rotateAngleY = -MathHelper.cos(f2 * ydiffer * this.wingspeed - 3.0f * pi4) * 3.1415927f * amp;
        p5.rotationPointY = p4.rotationPointY
            + (float) Math.sin(p4.rotateAngleX) * dist * (float) Math.cos(p4.rotateAngleY);
        p5.rotationPointZ = p4.rotationPointZ
            - (float) Math.cos(p4.rotateAngleX) * dist * (float) Math.cos(p4.rotateAngleY);
        p5.rotationPointX = p4.rotationPointX
            - (float) Math.sin(p4.rotateAngleY) * dist * (float) Math.cos(p4.rotateAngleX);
        p5.rotateAngleX = s * MathHelper.cos(f2 * differ * this.wingspeed - 4.0f * pi4) * 3.1415927f * amp;
        p5.rotateAngleY = -MathHelper.cos(f2 * ydiffer * this.wingspeed - 4.0f * pi4) * 3.1415927f * amp;
        p6.rotationPointY = p5.rotationPointY
            + (float) Math.sin(p5.rotateAngleX) * dist * (float) Math.cos(p5.rotateAngleY);
        p6.rotationPointZ = p5.rotationPointZ
            - (float) Math.cos(p5.rotateAngleX) * dist * (float) Math.cos(p5.rotateAngleY);
        p6.rotationPointX = p5.rotationPointX
            - (float) Math.sin(p5.rotateAngleY) * dist * (float) Math.cos(p5.rotateAngleX);
        p6.rotateAngleX = s * MathHelper.cos(f2 * differ * this.wingspeed - 5.0f * pi4) * 3.1415927f * amp;
        p6.rotateAngleY = -MathHelper.cos(f2 * ydiffer * this.wingspeed - 5.0f * pi4) * 3.1415927f * amp;
        p7.rotationPointY = p6.rotationPointY
            + (float) Math.sin(p6.rotateAngleX) * dist * (float) Math.cos(p6.rotateAngleY);
        p7.rotationPointZ = p6.rotationPointZ
            - (float) Math.cos(p6.rotateAngleX) * dist * (float) Math.cos(p6.rotateAngleY);
        p7.rotationPointX = p6.rotationPointX
            - (float) Math.sin(p6.rotateAngleY) * dist * (float) Math.cos(p6.rotateAngleX);
        p7.rotateAngleX = s * MathHelper.cos(f2 * differ * this.wingspeed - 6.0f * pi4) * 3.1415927f * amp;
        p7.rotateAngleY = -MathHelper.cos(f2 * ydiffer * this.wingspeed - 6.0f * pi4) * 3.1415927f * amp;
        p8.rotationPointY = p7.rotationPointY
            + (float) Math.sin(p7.rotateAngleX) * dist * (float) Math.cos(p7.rotateAngleY);
        p8.rotationPointZ = p7.rotationPointZ
            - (float) Math.cos(p7.rotateAngleX) * dist * (float) Math.cos(p7.rotateAngleY);
        p8.rotationPointX = p7.rotationPointX
            - (float) Math.sin(p7.rotateAngleY) * dist * (float) Math.cos(p7.rotateAngleX);
        p8.rotateAngleX = s * MathHelper.cos(f2 * differ * this.wingspeed - 7.0f * pi4) * 3.1415927f * amp;
        p8.rotateAngleY = -MathHelper.cos(f2 * ydiffer * this.wingspeed - 7.0f * pi4) * 3.1415927f * amp;
    }
}
