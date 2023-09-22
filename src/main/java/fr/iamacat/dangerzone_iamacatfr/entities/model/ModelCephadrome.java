
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Cephadrome;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;

public class ModelCephadrome extends ModelBase {

    private float wingspeed;
    ModelRenderer leftfoot;
    ModelRenderer butt;
    ModelRenderer rightfoot;
    ModelRenderer topfin1;
    ModelRenderer topfin2;
    ModelRenderer topfin3;
    ModelRenderer topfin4;
    ModelRenderer leftshoulder;
    ModelRenderer lefwingfin1;
    ModelRenderer tailfin1;
    ModelRenderer tailmembrane2;
    ModelRenderer tailfin2;
    ModelRenderer tailfin4;
    ModelRenderer tailfin3;
    ModelRenderer tailmembrane1;
    ModelRenderer topmem1;
    ModelRenderer topmem2;
    ModelRenderer topmem3;
    ModelRenderer topmem4;
    ModelRenderer neck1;
    ModelRenderer body;
    ModelRenderer chest1;
    ModelRenderer leftleg1;
    ModelRenderer mouth;
    ModelRenderer neck2;
    ModelRenderer head;
    ModelRenderer hammerhead;
    ModelRenderer chest;
    ModelRenderer neck3;
    ModelRenderer tail1;
    ModelRenderer rightleg1;
    ModelRenderer leftleg2;
    ModelRenderer rightleg2;
    ModelRenderer body2;
    ModelRenderer leftleg3;
    ModelRenderer rightleg3;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer tailmembrane3;
    ModelRenderer leftwingfin2;
    ModelRenderer leftwingfin3;
    ModelRenderer leftwingfin4;
    ModelRenderer leftwingmembrane;
    ModelRenderer rightshoulder;
    ModelRenderer rightwingfin1;
    ModelRenderer rightwingfin2;
    ModelRenderer rightwingfin3;
    ModelRenderer rightwingfin4;
    ModelRenderer rightwingmembrane;
    ModelRenderer hammerhead2;

    public ModelCephadrome(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.leftfoot = new ModelRenderer((ModelBase) this, 41, 194)).addBox(-2.0f, 34.0f, -12.0f, 9, 4, 10);
        this.leftfoot.setRotationPoint(7.0f, -14.0f, 17.0f);
        this.leftfoot.setTextureSize(512, 256);
        this.leftfoot.mirror = true;
        this.setRotation(this.leftfoot, 0.0f, 0.0f, 0.0f);
        (this.butt = new ModelRenderer((ModelBase) this, 367, 235)).addBox(0.0f, 0.0f, -2.0f, 9, 14, 6);
        this.butt.setRotationPoint(-4.5f, -8.0f, 29.0f);
        this.butt.setTextureSize(512, 256);
        this.butt.mirror = true;
        this.setRotation(this.butt, -0.8726646f, 0.0f, 0.0f);
        (this.rightfoot = new ModelRenderer((ModelBase) this, 41, 170)).addBox(-7.0f, 34.0f, -12.0f, 9, 4, 10);
        this.rightfoot.setRotationPoint(-7.0f, -14.0f, 17.0f);
        this.rightfoot.setTextureSize(512, 256);
        this.rightfoot.mirror = true;
        this.setRotation(this.rightfoot, 0.0f, 0.0f, 0.0f);
        (this.topfin1 = new ModelRenderer((ModelBase) this, 64, 112)).addBox(-3.0f, -2.0f, -30.0f, 6, 3, 30);
        this.topfin1.setRotationPoint(0.0f, -15.0f, -7.0f);
        this.topfin1.setTextureSize(512, 256);
        this.topfin1.mirror = true;
        this.setRotation(this.topfin1, -1.850049f, 0.0f, 0.0f);
        (this.topfin2 = new ModelRenderer((ModelBase) this, 69, 81)).addBox(-3.0f, -2.0f, -25.0f, 6, 3, 25);
        this.topfin2.setRotationPoint(0.0f, -15.0f, -2.0f);
        this.topfin2.setTextureSize(512, 256);
        this.topfin2.mirror = true;
        this.setRotation(this.topfin2, -2.076942f, 0.0f, 0.0f);
        (this.topfin3 = new ModelRenderer((ModelBase) this, -1, 140)).addBox(-3.0f, -2.0f, -20.0f, 6, 3, 20);
        this.topfin3.setRotationPoint(0.0f, -16.0f, 3.0f);
        this.topfin3.setTextureSize(512, 256);
        this.topfin3.mirror = true;
        this.setRotation(this.topfin3, -2.426008f, 0.0f, 0.0f);
        (this.topfin4 = new ModelRenderer((ModelBase) this, 148, 148)).addBox(-3.0f, -2.0f, -10.0f, 6, 3, 10);
        this.topfin4.setRotationPoint(0.0f, -17.0f, 13.0f);
        this.topfin4.setTextureSize(512, 256);
        this.topfin4.mirror = true;
        this.setRotation(this.topfin4, -2.635447f, 0.0f, 0.0f);
        (this.leftshoulder = new ModelRenderer((ModelBase) this, 144, 236)).addBox(0.0f, 0.0f, 1.0f, 6, 8, 11);
        this.leftshoulder.setRotationPoint(6.0f, -16.0f, -14.0f);
        this.leftshoulder.setTextureSize(512, 256);
        this.leftshoulder.mirror = true;
        this.setRotation(this.leftshoulder, -0.1745329f, 0.0f, 0.0f);
        (this.lefwingfin1 = new ModelRenderer((ModelBase) this, 147, 96)).addBox(0.0f, -2.0f, -2.0f, 70, 5, 3);
        this.lefwingfin1.setRotationPoint(9.0f, -12.0f, -11.0f);
        this.lefwingfin1.setTextureSize(512, 256);
        this.lefwingfin1.mirror = true;
        this.setRotation(this.lefwingfin1, -0.2617994f, -0.1745329f, 0.0f);
        (this.tailfin1 = new ModelRenderer((ModelBase) this, 168, 0)).addBox(-6.0f, -1.0f, 0.0f, 12, 3, 30);
        this.tailfin1.setRotationPoint(0.0f, -9.0f, 56.0f);
        this.tailfin1.setTextureSize(512, 256);
        this.tailfin1.mirror = true;
        this.setRotation(this.tailfin1, 0.1396263f, 0.0f, 0.0f);
        (this.tailmembrane2 = new ModelRenderer((ModelBase) this, 201, 38)).addBox(0.0f, -8.0f, 3.0f, 0, 10, 19);
        this.tailmembrane2.setRotationPoint(0.0f, 0.0f, 56.0f);
        this.tailmembrane2.setTextureSize(512, 256);
        this.tailmembrane2.mirror = true;
        this.setRotation(this.tailmembrane2, -0.296706f, 0.0f, 0.0f);
        (this.tailfin2 = new ModelRenderer((ModelBase) this, 186, 184)).addBox(-4.0f, 0.0f, 0.0f, 8, 2, 27);
        this.tailfin2.setRotationPoint(0.0f, -7.0f, 56.0f);
        this.tailfin2.setTextureSize(512, 256);
        this.tailfin2.mirror = true;
        this.setRotation(this.tailfin2, -0.1919862f, 0.0f, 0.0f);
        (this.tailfin4 = new ModelRenderer((ModelBase) this, 186, 137)).addBox(-4.0f, 1.0f, 1.0f, 8, 3, 22);
        this.tailfin4.setRotationPoint(0.0f, -3.0f, 56.0f);
        this.tailfin4.setTextureSize(512, 256);
        this.tailfin4.mirror = true;
        this.setRotation(this.tailfin4, -0.837758f, 0.0f, 0.0f);
        (this.tailfin3 = new ModelRenderer((ModelBase) this, 185, 216)).addBox(-4.0f, 0.0f, 1.0f, 8, 2, 23);
        this.tailfin3.setRotationPoint(0.0f, -5.0f, 57.0f);
        this.tailfin3.setTextureSize(512, 256);
        this.tailfin3.mirror = true;
        this.setRotation(this.tailfin3, -0.5759587f, 0.0f, 0.0f);
        (this.tailmembrane1 = new ModelRenderer((ModelBase) this, 245, 38)).addBox(0.0f, 0.0f, 4.0f, 0, 11, 21);
        this.tailmembrane1.setRotationPoint(0.0f, -9.0f, 56.0f);
        this.tailmembrane1.setTextureSize(512, 256);
        this.tailmembrane1.mirror = true;
        this.setRotation(this.tailmembrane1, 0.1396263f, 0.0f, 0.0f);
        (this.topmem1 = new ModelRenderer((ModelBase) this, 25, 0)).addBox(0.0f, -25.0f, 0.0f, 0, 24, 10);
        this.topmem1.setRotationPoint(0.0f, -15.0f, -6.0f);
        this.topmem1.setTextureSize(512, 256);
        this.topmem1.mirror = true;
        this.setRotation(this.topmem1, -0.2617994f, 0.0f, 0.0f);
        (this.topmem2 = new ModelRenderer((ModelBase) this, 135, 0)).addBox(1.0f, -22.0f, 0.0f, 0, 20, 10);
        this.topmem2.setRotationPoint(-1.0f, -15.0f, -2.0f);
        this.topmem2.setTextureSize(512, 256);
        this.topmem2.mirror = true;
        this.setRotation(this.topmem2, -0.5235988f, 0.0f, 0.0f);
        (this.topmem3 = new ModelRenderer((ModelBase) this, 258, 0)).addBox(0.0f, -18.0f, 0.0f, 0, 18, 8);
        this.topmem3.setRotationPoint(0.0f, -16.0f, 3.0f);
        this.topmem3.setTextureSize(512, 256);
        this.topmem3.mirror = true;
        this.setRotation(this.topmem3, -0.8901179f, 0.0f, 0.0f);
        (this.topmem4 = new ModelRenderer((ModelBase) this, 282, 0)).addBox(0.0f, -9.0f, 0.0f, 0, 9, 10);
        this.topmem4.setRotationPoint(0.0f, -17.0f, 13.0f);
        this.topmem4.setTextureSize(512, 256);
        this.topmem4.mirror = true;
        this.setRotation(this.topmem4, -1.117011f, 0.0f, 0.0f);
        (this.neck1 = new ModelRenderer((ModelBase) this, 404, 235)).addBox(-6.0f, -5.0f, -10.0f, 10, 9, 10);
        this.neck1.setRotationPoint(1.0f, -6.0f, -33.0f);
        this.neck1.setTextureSize(512, 256);
        this.neck1.mirror = true;
        this.setRotation(this.neck1, 0.3665191f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 28, 220)).addBox(-6.0f, -11.0f, -10.0f, 12, 15, 19);
        this.body.setRotationPoint(0.0f, -7.0f, 3.0f);
        this.body.setTextureSize(512, 256);
        this.body.mirror = true;
        this.setRotation(this.body, 0.1745329f, 0.0f, 0.0f);
        (this.chest1 = new ModelRenderer((ModelBase) this, 98, 210)).addBox(-3.0f, -4.0f, -2.0f, 10, 11, 5);
        this.chest1.setRotationPoint(-2.0f, -6.0f, -13.0f);
        this.chest1.setTextureSize(512, 256);
        this.chest1.mirror = true;
        this.setRotation(this.chest1, 1.029744f, 0.0f, 0.0f);
        (this.leftleg1 = new ModelRenderer((ModelBase) this, 135, 183)).addBox(-1.0f, 0.0f, -4.0f, 7, 18, 10);
        this.leftleg1.setRotationPoint(7.0f, -14.0f, 17.0f);
        this.leftleg1.setTextureSize(512, 256);
        this.leftleg1.mirror = true;
        this.setRotation(this.leftleg1, -0.5759587f, 0.0f, 0.0f);
        (this.mouth = new ModelRenderer((ModelBase) this, 92, 150)).addBox(-7.0f, 1.0f, 3.0f, 14, 15, 4);
        this.mouth.setRotationPoint(0.0f, -6.0f, -43.0f);
        this.mouth.setTextureSize(512, 256);
        this.mouth.mirror = true;
        this.setRotation(this.mouth, -0.8726646f, 0.0f, 0.0f);
        (this.neck2 = new ModelRenderer((ModelBase) this, 152, 110)).addBox(-6.0f, -5.0f, -17.0f, 11, 10, 17);
        this.neck2.setRotationPoint(0.5f, -10.0f, -19.0f);
        this.neck2.setTextureSize(512, 256);
        this.neck2.mirror = true;
        this.setRotation(this.neck2, 0.2617994f, 0.0f, 0.0f);
        (this.head = new ModelRenderer((ModelBase) this, 275, 219)).addBox(-10.0f, -3.0f, -16.0f, 20, 7, 16);
        this.head.setRotationPoint(0.0f, -6.0f, -43.0f);
        this.head.setTextureSize(512, 256);
        this.head.mirror = true;
        this.setRotation(this.head, 0.5061455f, 0.0f, 0.0f);
        (this.hammerhead = new ModelRenderer((ModelBase) this, 258, 134)).addBox(-18.0f, -2.0f, -15.0f, 36, 6, 14);
        this.hammerhead.setRotationPoint(0.0f, -6.0f, -43.0f);
        this.hammerhead.setTextureSize(512, 256);
        this.hammerhead.mirror = true;
        this.setRotation(this.hammerhead, 0.4537856f, 0.0f, 0.0f);
        (this.chest = new ModelRenderer((ModelBase) this, 100, 15)).addBox(-3.0f, -3.0f, 0.0f, 9, 29, 7);
        this.chest.setRotationPoint(-1.5f, 0.0f, -5.0f);
        this.chest.setTextureSize(512, 256);
        this.chest.mirror = true;
        this.setRotation(this.chest, 1.413717f, 0.0f, 0.0f);
        (this.neck3 = new ModelRenderer((ModelBase) this, 264, 173)).addBox(-6.0f, -5.0f, -16.0f, 12, 11, 16);
        this.neck3.setRotationPoint(0.0f, -11.0f, -6.0f);
        this.neck3.setTextureSize(512, 256);
        this.neck3.mirror = true;
        this.setRotation(this.neck3, 0.0872665f, 0.0f, 0.0f);
        (this.tail1 = new ModelRenderer((ModelBase) this, 51, 5)).addBox(-5.0f, -6.0f, 0.0f, 10, 13, 14);
        this.tail1.setRotationPoint(0.0f, -10.0f, 22.0f);
        this.tail1.setTextureSize(512, 256);
        this.tail1.mirror = true;
        this.setRotation(this.tail1, -0.1745329f, 0.0f, 0.0f);
        (this.rightleg1 = new ModelRenderer((ModelBase) this, 94, 175)).addBox(-6.0f, 0.0f, -4.0f, 7, 18, 10);
        this.rightleg1.setRotationPoint(-7.0f, -14.0f, 17.0f);
        this.rightleg1.setTextureSize(512, 256);
        this.rightleg1.mirror = true;
        this.setRotation(this.rightleg1, -0.5759587f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase) this, 28, 112)).addBox(-1.0f, 6.0f, -17.0f, 7, 12, 7);
        this.leftleg2.setRotationPoint(7.0f, -14.0f, 17.0f);
        this.leftleg2.setTextureSize(512, 256);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, 0.9773844f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase) this, 32, 90)).addBox(-6.0f, 6.0f, -17.0f, 7, 12, 7);
        this.rightleg2.setRotationPoint(-7.0f, -14.0f, 17.0f);
        this.rightleg2.setTextureSize(512, 256);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, 0.9773844f, 0.0f, 0.0f);
        (this.body2 = new ModelRenderer((ModelBase) this, 400, 179)).addBox(0.0f, 3.0f, 3.0f, 12, 16, 16);
        this.body2.setRotationPoint(-6.0f, -23.0f, 6.0f);
        this.body2.setTextureSize(512, 256);
        this.body2.mirror = true;
        this.setRotation(this.body2, -0.1919862f, 0.0f, 0.0f);
        (this.leftleg3 = new ModelRenderer((ModelBase) this, 351, 192)).addBox(-1.0f, 17.0f, 10.0f, 7, 17, 6);
        this.leftleg3.setRotationPoint(7.0f, -14.0f, 17.0f);
        this.leftleg3.setTextureSize(512, 256);
        this.leftleg3.mirror = true;
        this.setRotation(this.leftleg3, -0.5235988f, 0.0f, 0.0f);
        (this.rightleg3 = new ModelRenderer((ModelBase) this, 323, 192)).addBox(-6.0f, 17.0f, 10.0f, 7, 17, 6);
        this.rightleg3.setRotationPoint(-7.0f, -14.0f, 17.0f);
        this.rightleg3.setTextureSize(512, 256);
        this.rightleg3.mirror = true;
        this.setRotation(this.rightleg3, -0.5235988f, 0.0f, 0.0f);
        (this.tail2 = new ModelRenderer((ModelBase) this, 51, 55)).addBox(-6.0f, -6.0f, 0.0f, 9, 12, 14);
        this.tail2.setRotationPoint(1.5f, -7.0f, 35.0f);
        this.tail2.setTextureSize(512, 256);
        this.tail2.mirror = true;
        this.setRotation(this.tail2, -0.1396263f, 0.0f, 0.0f);
        (this.tail3 = new ModelRenderer((ModelBase) this, 105, 52)).addBox(-5.0f, -6.0f, 0.0f, 8, 11, 14);
        this.tail3.setRotationPoint(1.0f, -5.0f, 48.0f);
        this.tail3.setTextureSize(512, 256);
        this.tail3.mirror = true;
        this.setRotation(this.tail3, -0.1396263f, 0.0f, 0.0f);
        (this.tailmembrane3 = new ModelRenderer((ModelBase) this, 155, 38)).addBox(0.0f, -10.0f, 0.0f, 0, 10, 18);
        this.tailmembrane3.setRotationPoint(0.0f, 2.0f, 56.0f);
        this.tailmembrane3.setTextureSize(512, 256);
        this.tailmembrane3.mirror = true;
        this.setRotation(this.tailmembrane3, -0.837758f, 0.0f, 0.0f);
        (this.leftwingfin2 = new ModelRenderer((ModelBase) this, 160, 83)).addBox(0.0f, -2.0f, 0.0f, 64, 4, 2);
        this.leftwingfin2.setRotationPoint(9.0f, -12.0f, -11.0f);
        this.leftwingfin2.setTextureSize(512, 256);
        this.leftwingfin2.mirror = true;
        this.setRotation(this.leftwingfin2, -0.2617994f, -0.4363323f, 0.0f);
        (this.leftwingfin3 = new ModelRenderer((ModelBase) this, 209, 106)).addBox(0.0f, -2.0f, 0.0f, 48, 4, 2);
        this.leftwingfin3.setRotationPoint(9.0f, -11.0f, -10.0f);
        this.leftwingfin3.setTextureSize(512, 256);
        this.leftwingfin3.mirror = true;
        this.setRotation(this.leftwingfin3, -0.2617994f, -0.7853982f, 0.0f);
        (this.leftwingfin4 = new ModelRenderer((ModelBase) this, 233, 120)).addBox(0.0f, 0.0f, 0.0f, 37, 4, 2);
        this.leftwingfin4.setRotationPoint(9.0f, -13.0f, -6.0f);
        this.leftwingfin4.setTextureSize(512, 256);
        this.leftwingfin4.mirror = true;
        this.setRotation(this.leftwingfin4, -0.2617994f, -1.186824f, 0.0f);
        (this.leftwingmembrane = new ModelRenderer((ModelBase) this, 300, 27)).addBox(3.0f, 0.0f, 0.0f, 64, 0, 34);
        this.leftwingmembrane.setRotationPoint(9.0f, -13.0f, -10.0f);
        this.leftwingmembrane.setTextureSize(512, 256);
        this.leftwingmembrane.mirror = true;
        this.setRotation(this.leftwingmembrane, -0.0872665f, -0.1745329f, 0.0f);
        (this.rightshoulder = new ModelRenderer((ModelBase) this, 0, 193)).addBox(0.0f, 0.0f, 0.0f, 6, 8, 11);
        this.rightshoulder.setRotationPoint(-12.0f, -16.0f, -13.0f);
        this.rightshoulder.setTextureSize(512, 256);
        this.rightshoulder.mirror = true;
        this.setRotation(this.rightshoulder, -0.1745329f, 0.0f, 0.0f);
        (this.rightwingfin1 = new ModelRenderer((ModelBase) this, 344, 109)).addBox(-69.0f, -2.0f, 0.0f, 69, 5, 3);
        this.rightwingfin1.setRotationPoint(-10.0f, -12.0f, -13.0f);
        this.rightwingfin1.setTextureSize(512, 256);
        this.rightwingfin1.mirror = true;
        this.setRotation(this.rightwingfin1, -0.2617994f, 0.1745329f, 0.0f);
        (this.rightwingfin2 = new ModelRenderer((ModelBase) this, 349, 119)).addBox(-63.0f, -2.0f, 0.0f, 64, 4, 2);
        this.rightwingfin2.setRotationPoint(-9.0f, -12.0f, -11.0f);
        this.rightwingfin2.setTextureSize(512, 256);
        this.rightwingfin2.mirror = true;
        this.setRotation(this.rightwingfin2, -0.2617994f, 0.4363323f, 0.0f);
        (this.rightwingfin3 = new ModelRenderer((ModelBase) this, 368, 128)).addBox(-49.0f, 0.0f, 0.0f, 48, 4, 2);
        this.rightwingfin3.setRotationPoint(-9.0f, -13.0f, -9.0f);
        this.rightwingfin3.setTextureSize(512, 256);
        this.rightwingfin3.mirror = true;
        this.setRotation(this.rightwingfin3, -0.2617994f, 0.7679449f, 0.0f);
        (this.rightwingfin4 = new ModelRenderer((ModelBase) this, 379, 137)).addBox(-35.0f, 0.0f, 0.0f, 37, 4, 2);
        this.rightwingfin4.setRotationPoint(-9.0f, -13.0f, -6.0f);
        this.rightwingfin4.setTextureSize(512, 256);
        this.rightwingfin4.mirror = true;
        this.setRotation(this.rightwingfin4, -0.2617994f, 1.186824f, 0.0f);
        (this.rightwingmembrane = new ModelRenderer((ModelBase) this, 300, 67)).addBox(-67.0f, -1.0f, 0.0f, 64, 0, 34);
        this.rightwingmembrane.setRotationPoint(-9.0f, -12.0f, -12.0f);
        this.rightwingmembrane.setTextureSize(512, 256);
        this.rightwingmembrane.mirror = true;
        this.setRotation(this.rightwingmembrane, -0.0872665f, 0.1745329f, 0.0f);
        (this.hammerhead2 = new ModelRenderer((ModelBase) this, 258, 157)).addBox(-25.0f, 0.0f, -14.0f, 50, 4, 7);
        this.hammerhead2.setRotationPoint(0.0f, -7.0f, -43.0f);
        this.hammerhead2.setTextureSize(512, 256);
        this.hammerhead2.mirror = true;
        this.setRotation(this.hammerhead2, 0.4537856f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, float f3, final float f4,
        final float f5) {
        final Cephadrome e = (Cephadrome) entity;
        RenderInfo r = null;
        float newangle = 0.0f;
        float lspeed = 0.0f;
        final float pi4 = 0.7853982f;
        float tailspeed = 0.76f;
        float tailamp = 0.1f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        r = e.getRenderInfo();
        if (f1 > 0.001) {
            lspeed = (float) ((e.prevPosX - e.posX) * (e.prevPosX - e.posX)
                + (e.prevPosZ - e.posZ) * (e.prevPosZ - e.posZ));
            lspeed = (float) Math.sqrt(lspeed);
            newangle = MathHelper.cos(f2 * 0.75f * this.wingspeed) * 3.1415927f * lspeed * 0.4f;
            if (newangle > 0.5) {
                newangle = 0.75f;
            }
            if (newangle < -0.5) {
                newangle = -0.75f;
            }
        } else {
            newangle = 0.0f;
        }
        if (e.getActivity() != 0) {
            newangle = 1.0f;
            this.rightleg1.rotateAngleX = -0.58f + newangle;
            this.rightleg2.rotateAngleX = 0.98f + newangle;
            this.rightleg3.rotateAngleX = -0.52f + newangle;
            this.rightfoot.rotateAngleX = newangle;
            this.leftleg1.rotateAngleX = -0.58f + newangle;
            this.leftleg2.rotateAngleX = 0.98f + newangle;
            this.leftleg3.rotateAngleX = -0.52f + newangle;
            this.leftfoot.rotateAngleX = newangle;
        } else {
            this.rightleg1.rotateAngleX = -0.58f + newangle;
            this.rightleg2.rotateAngleX = 0.98f + newangle;
            this.rightleg3.rotateAngleX = -0.52f + newangle;
            this.rightfoot.rotateAngleX = newangle;
            this.leftleg1.rotateAngleX = -0.58f - newangle;
            this.leftleg2.rotateAngleX = 0.98f - newangle;
            this.leftleg3.rotateAngleX = -0.52f - newangle;
            this.leftfoot.rotateAngleX = -newangle;
        }
        if (e.getActivity() != 0) {
            newangle = MathHelper.cos(f2 * 0.55f * this.wingspeed) * 3.1415927f * 0.28f;
        } else if (e.getAttacking() == 0) {
            newangle = -0.85f + MathHelper.cos(f2 * 0.2f * this.wingspeed) * 3.1415927f * 0.028f;
        } else {
            newangle = -0.65f + MathHelper.cos(f2 * 0.9f * this.wingspeed) * 3.1415927f * 0.068f;
        }
        this.lefwingfin1.rotateAngleZ = newangle;
        this.leftwingfin2.rotateAngleZ = newangle;
        this.leftwingfin3.rotateAngleZ = newangle;
        this.leftwingfin4.rotateAngleZ = newangle;
        this.leftwingmembrane.rotateAngleZ = newangle;
        this.rightwingfin1.rotateAngleZ = -newangle;
        this.rightwingfin2.rotateAngleZ = -newangle;
        this.rightwingfin3.rotateAngleZ = -newangle;
        this.rightwingfin4.rotateAngleZ = -newangle;
        this.rightwingmembrane.rotateAngleZ = -newangle;
        newangle = MathHelper.cos(f2 * 0.15f * this.wingspeed) * 3.1415927f * 0.05f;
        this.topfin1.rotateAngleX = -1.85f - Math.abs(newangle);
        this.topmem1.rotateAngleX = -0.26f - Math.abs(newangle);
        this.topfin2.rotateAngleX = -2.07f - Math.abs(newangle / 2.0f);
        this.topmem2.rotateAngleX = -0.52f - Math.abs(newangle / 2.0f);
        this.topfin3.rotateAngleX = -2.42f - Math.abs(newangle / 4.0f);
        this.topmem3.rotateAngleX = -0.89f - Math.abs(newangle / 4.0f);
        this.topfin4.rotateAngleX = -2.63f - Math.abs(newangle / 8.0f);
        this.topmem4.rotateAngleX = -1.11f - Math.abs(newangle / 8.0f);
        if (e.getActivity() == 0 && e.getAttacking() == 0) {
            tailspeed = 0.22f;
            tailamp = 0.03f;
        }
        this.tail1.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed) * 3.1415927f * 0.04f;
        this.tail2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 13.0f;
        this.tail2.rotationPointX = this.tail1.rotationPointX + 1.5f
            + (float) Math.sin(this.tail1.rotateAngleY) * 13.0f;
        this.tail2.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed - pi4) * 3.1415927f * tailamp;
        this.tail3.rotationPointZ = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleY) * 13.0f;
        this.tail3.rotationPointX = this.tail2.rotationPointX - 0.5f
            + (float) Math.sin(this.tail2.rotateAngleY) * 13.0f;
        this.tail3.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed - 2.0f * pi4) * 3.1415927f * tailamp;
        this.tailfin1.rotationPointZ = this.tail3.rotationPointZ + (float) Math.cos(this.tail3.rotateAngleY) * 10.0f;
        this.tailfin1.rotationPointX = this.tail3.rotationPointX - 1.0f
            + (float) Math.sin(this.tail3.rotateAngleY) * 10.0f;
        this.tailfin1.rotateAngleY = MathHelper.cos(f2 * tailspeed * this.wingspeed - 3.0f * pi4) * 3.1415927f
            * tailamp;
        this.tailfin2.rotationPointZ = this.tailfin1.rotationPointZ;
        this.tailfin2.rotationPointX = this.tailfin1.rotationPointX;
        this.tailfin2.rotateAngleY = this.tailfin1.rotateAngleY;
        this.tailfin3.rotationPointZ = this.tailfin1.rotationPointZ;
        this.tailfin3.rotationPointX = this.tailfin1.rotationPointX;
        this.tailfin3.rotateAngleY = this.tailfin1.rotateAngleY;
        this.tailfin4.rotationPointZ = this.tailfin1.rotationPointZ;
        this.tailfin4.rotationPointX = this.tailfin1.rotationPointX;
        this.tailfin4.rotateAngleY = this.tailfin1.rotateAngleY;
        this.tailmembrane1.rotationPointZ = this.tailfin1.rotationPointZ;
        this.tailmembrane1.rotationPointX = this.tailfin1.rotationPointX;
        this.tailmembrane1.rotateAngleY = this.tailfin1.rotateAngleY;
        this.tailmembrane2.rotationPointZ = this.tailfin1.rotationPointZ;
        this.tailmembrane2.rotationPointX = this.tailfin1.rotationPointX;
        this.tailmembrane2.rotateAngleY = this.tailfin1.rotateAngleY;
        this.tailmembrane3.rotationPointZ = this.tailfin1.rotationPointZ;
        this.tailmembrane3.rotationPointX = this.tailfin1.rotationPointX;
        this.tailmembrane3.rotateAngleY = this.tailfin1.rotateAngleY;
        if (e.getActivity() == 1) {
            f3 = (e.prevRotationYaw - e.rotationYaw) * 10.0f;
            f3 = -f3;
            final RenderInfo renderInfo = r;
            renderInfo.rf1 += (f3 - r.rf1) / 50.0f;
            if (r.rf1 > 50.0f) {
                r.rf1 = 50.0f;
            }
            if (r.rf1 < -50.0f) {
                r.rf1 = -50.0f;
            }
            f3 = r.rf1;
        } else {
            f3 /= 2.0f;
        }
        this.neck3.rotateAngleY = (float) Math.toRadians(f3) * 0.125f;
        this.neck2.rotationPointZ = this.neck3.rotationPointZ - (float) Math.cos(this.neck3.rotateAngleY) * 14.0f;
        this.neck2.rotationPointX = this.neck3.rotationPointX + 0.5f
            - (float) Math.sin(this.neck3.rotateAngleY) * 14.0f;
        this.neck2.rotateAngleY = (float) Math.toRadians(f3) * 0.25f;
        this.neck1.rotationPointZ = this.neck2.rotationPointZ - (float) Math.cos(this.neck2.rotateAngleY) * 14.0f;
        this.neck1.rotationPointX = this.neck2.rotationPointX + 0.5f
            - (float) Math.sin(this.neck2.rotateAngleY) * 14.0f;
        this.neck1.rotateAngleY = (float) Math.toRadians(f3) * 0.5f;
        this.head.rotationPointZ = this.neck1.rotationPointZ - (float) Math.cos(this.neck1.rotateAngleY) * 8.0f;
        this.head.rotationPointX = this.neck1.rotationPointX - (float) Math.sin(this.neck1.rotateAngleY) * 8.0f;
        this.head.rotateAngleY = (float) Math.toRadians(f3) * 0.75f;
        this.hammerhead.rotationPointZ = this.head.rotationPointZ;
        this.hammerhead.rotationPointX = this.head.rotationPointX;
        this.hammerhead.rotateAngleY = this.head.rotateAngleY;
        this.hammerhead2.rotationPointZ = this.head.rotationPointZ;
        this.hammerhead2.rotationPointX = this.head.rotationPointX;
        this.hammerhead2.rotateAngleY = this.head.rotateAngleY;
        this.mouth.rotationPointZ = this.head.rotationPointZ;
        this.mouth.rotationPointX = this.head.rotationPointX;
        this.mouth.rotateAngleY = this.head.rotateAngleY;
        newangle = MathHelper.cos(f2 * 0.5f * this.wingspeed) * 3.1415927f * 0.14f;
        if (e.getAttacking() != 0) {
            this.mouth.rotateAngleX = -0.61f + newangle;
        } else {
            this.mouth.rotateAngleX = -0.87f;
        }
        e.setRenderInfo(r);
        this.leftfoot.render(f5);
        this.butt.render(f5);
        this.rightfoot.render(f5);
        this.topfin1.render(f5);
        this.topfin2.render(f5);
        this.topfin3.render(f5);
        this.topfin4.render(f5);
        this.leftshoulder.render(f5);
        this.lefwingfin1.render(f5);
        this.tailfin1.render(f5);
        this.tailmembrane2.render(f5);
        this.tailfin2.render(f5);
        this.tailfin4.render(f5);
        this.tailfin3.render(f5);
        this.tailmembrane1.render(f5);
        this.topmem1.render(f5);
        this.topmem2.render(f5);
        this.topmem3.render(f5);
        this.topmem4.render(f5);
        this.neck1.render(f5);
        this.body.render(f5);
        this.chest1.render(f5);
        this.leftleg1.render(f5);
        this.mouth.render(f5);
        this.neck2.render(f5);
        this.head.render(f5);
        this.hammerhead.render(f5);
        this.chest.render(f5);
        this.neck3.render(f5);
        this.tail1.render(f5);
        this.rightleg1.render(f5);
        this.leftleg2.render(f5);
        this.rightleg2.render(f5);
        this.body2.render(f5);
        this.leftleg3.render(f5);
        this.rightleg3.render(f5);
        this.tail2.render(f5);
        this.tail3.render(f5);
        this.tailmembrane3.render(f5);
        this.leftwingfin2.render(f5);
        this.leftwingfin3.render(f5);
        this.leftwingfin4.render(f5);
        this.leftwingmembrane.render(f5);
        this.rightshoulder.render(f5);
        this.rightwingfin1.render(f5);
        this.rightwingfin2.render(f5);
        this.rightwingfin3.render(f5);
        this.rightwingfin4.render(f5);
        this.rightwingmembrane.render(f5);
        this.hammerhead2.render(f5);
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
