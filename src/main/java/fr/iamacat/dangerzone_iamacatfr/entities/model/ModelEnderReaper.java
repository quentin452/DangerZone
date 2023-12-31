
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.EnderReaper;

public class ModelEnderReaper extends ModelBase {

    ModelRenderer rwing1;
    ModelRenderer lwing1;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;
    ModelRenderer Shape22;
    ModelRenderer Shape23;
    ModelRenderer Shape24;
    ModelRenderer Shape25;
    ModelRenderer Shape26;
    ModelRenderer Shape27;
    ModelRenderer Shape28;
    ModelRenderer Shape29;
    ModelRenderer Shape30;
    ModelRenderer Shape31;
    ModelRenderer Shape32;
    ModelRenderer Shape33;
    ModelRenderer Shape34;
    ModelRenderer Shape35;
    ModelRenderer Shape36;
    ModelRenderer Shape37;
    ModelRenderer Shape38;
    ModelRenderer Shape39;
    ModelRenderer Shape40;
    ModelRenderer Shape41;
    ModelRenderer Shape42;
    ModelRenderer Shape43;
    ModelRenderer Shape44;
    ModelRenderer Shape45;
    ModelRenderer Shape46;
    ModelRenderer Shape47;
    ModelRenderer Shape48;
    ModelRenderer Shape49;
    ModelRenderer rarm2;
    ModelRenderer rarm3;
    ModelRenderer relbow;
    ModelRenderer rarm1;
    ModelRenderer Shape54;
    ModelRenderer larm3;
    ModelRenderer larm2;
    ModelRenderer lelbow;
    ModelRenderer larm1;
    ModelRenderer scythe1;
    ModelRenderer scythe2;
    ModelRenderer scythe3;
    ModelRenderer head;
    ModelRenderer lwing3;
    ModelRenderer lwing2;
    ModelRenderer rwing3;
    ModelRenderer rwing2;
    private float wingspeed;

    public ModelEnderReaper(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.rwing1 = new ModelRenderer((ModelBase) this, 20, 430)).addBox(0.0f, 0.0f, 0.0f, 0, 50, 17);
        this.rwing1.setRotationPoint(-4.0f, -6.9f, 8.5f);
        this.rwing1.setTextureSize(512, 512);
        this.rwing1.mirror = true;
        this.setRotation(this.rwing1, 1.745f, -0.785f, 0.0f);
        (this.lwing1 = new ModelRenderer((ModelBase) this, 20, 350)).addBox(0.0f, 0.0f, 0.0f, 0, 50, 17);
        this.lwing1.setRotationPoint(4.0f, -6.9f, 8.5f);
        this.lwing1.setTextureSize(512, 512);
        this.lwing1.mirror = true;
        this.setRotation(this.lwing1, 1.745f, 0.785f, 0.0f);
        (this.Shape3 = new ModelRenderer((ModelBase) this, 20, 320)).addBox(-4.0f, 0.0f, -2.0f, 2, 12, 1);
        this.Shape3.setRotationPoint(3.0f, -14.0f, 10.0f);
        this.Shape3.setTextureSize(512, 512);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0f, 0.0f, 0.0f);
        (this.Shape4 = new ModelRenderer((ModelBase) this, 40, 320)).addBox(-4.0f, 0.0f, -2.0f, 2, 6, 1);
        this.Shape4.setRotationPoint(3.0f, -2.0f, 10.0f);
        this.Shape4.setTextureSize(512, 512);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, -0.247f, 0.0f, 0.0f);
        (this.Shape5 = new ModelRenderer((ModelBase) this, 20, 310)).addBox(-4.0f, 0.0f, -2.0f, 1, 3, 1);
        this.Shape5.setRotationPoint(3.5f, 4.0f, 8.0f);
        this.Shape5.setTextureSize(512, 512);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, -0.768f, 0.0f, 0.0f);
        (this.Shape6 = new ModelRenderer((ModelBase) this, 20, 292)).addBox(-4.0f, 0.0f, -2.0f, 2, 6, 2);
        this.Shape6.setRotationPoint(3.0f, -12.0f, 7.5f);
        this.Shape6.setTextureSize(512, 512);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, -2.356f, 0.0f, 0.0f);
        (this.Shape7 = new ModelRenderer((ModelBase) this, 20, 280)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape7.setRotationPoint(5.0f, -14.0f, 10.0f);
        this.Shape7.setTextureSize(512, 512);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
        (this.Shape8 = new ModelRenderer((ModelBase) this, 20, 269)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape8.setRotationPoint(-1.0f, -14.0f, 10.0f);
        this.Shape8.setTextureSize(512, 512);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
        (this.Shape9 = new ModelRenderer((ModelBase) this, 20, 257)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape9.setRotationPoint(-1.0f, -12.0f, 10.0f);
        this.Shape9.setTextureSize(512, 512);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0f, 0.0f, 0.0f);
        (this.Shape10 = new ModelRenderer((ModelBase) this, 20, 246)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape10.setRotationPoint(-1.0f, -10.0f, 10.0f);
        this.Shape10.setTextureSize(512, 512);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0f, 0.0f, 0.0f);
        (this.Shape11 = new ModelRenderer((ModelBase) this, 20, 237)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape11.setRotationPoint(-1.0f, -8.0f, 10.0f);
        this.Shape11.setTextureSize(512, 512);
        this.Shape11.mirror = true;
        this.setRotation(this.Shape11, 0.0f, 0.0f, 0.0f);
        (this.Shape12 = new ModelRenderer((ModelBase) this, 20, 228)).addBox(-4.0f, 0.0f, -2.0f, 2, 1, 1);
        this.Shape12.setRotationPoint(1.0f, -6.0f, 10.0f);
        this.Shape12.setTextureSize(512, 512);
        this.Shape12.mirror = true;
        this.setRotation(this.Shape12, 0.0f, 0.0f, 0.0f);
        (this.Shape13 = new ModelRenderer((ModelBase) this, 20, 219)).addBox(-4.0f, 0.0f, -2.0f, 3, 1, 1);
        this.Shape13.setRotationPoint(1.0f, -4.0f, 10.0f);
        this.Shape13.setTextureSize(512, 512);
        this.Shape13.mirror = true;
        this.setRotation(this.Shape13, 0.0f, 0.0f, 0.0f);
        (this.Shape14 = new ModelRenderer((ModelBase) this, 20, 209)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.Shape14.setRotationPoint(3.5f, -14.0f, 11.0f);
        this.Shape14.setTextureSize(512, 512);
        this.Shape14.mirror = true;
        this.setRotation(this.Shape14, 0.0f, 0.0f, 0.0f);
        (this.Shape15 = new ModelRenderer((ModelBase) this, 20, 201)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.Shape15.setRotationPoint(3.5f, -12.0f, 11.0f);
        this.Shape15.setTextureSize(512, 512);
        this.Shape15.mirror = true;
        this.setRotation(this.Shape15, 0.0f, 0.0f, 0.0f);
        (this.Shape16 = new ModelRenderer((ModelBase) this, 20, 194)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.Shape16.setRotationPoint(3.5f, -10.0f, 11.0f);
        this.Shape16.setTextureSize(512, 512);
        this.Shape16.mirror = true;
        this.setRotation(this.Shape16, 0.0f, 0.0f, 0.0f);
        (this.Shape17 = new ModelRenderer((ModelBase) this, 20, 185)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.Shape17.setRotationPoint(3.5f, -8.0f, 11.0f);
        this.Shape17.setTextureSize(512, 512);
        this.Shape17.mirror = true;
        this.setRotation(this.Shape17, 0.0f, 0.0f, 0.0f);
        (this.Shape18 = new ModelRenderer((ModelBase) this, 20, 175)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.Shape18.setRotationPoint(3.5f, -6.0f, 11.0f);
        this.Shape18.setTextureSize(512, 512);
        this.Shape18.mirror = true;
        this.setRotation(this.Shape18, 0.0f, 0.0f, 0.0f);
        (this.Shape19 = new ModelRenderer((ModelBase) this, 20, 165)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 1);
        this.Shape19.setRotationPoint(3.5f, -4.0f, 11.0f);
        this.Shape19.setTextureSize(512, 512);
        this.Shape19.mirror = true;
        this.setRotation(this.Shape19, 0.0f, 0.0f, 0.0f);
        (this.Shape20 = new ModelRenderer((ModelBase) this, 20, 155)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape20.setRotationPoint(5.0f, -12.0f, 10.0f);
        this.Shape20.setTextureSize(512, 512);
        this.Shape20.mirror = true;
        this.setRotation(this.Shape20, 0.0f, 0.0f, 0.0f);
        (this.Shape21 = new ModelRenderer((ModelBase) this, 20, 146)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape21.setRotationPoint(5.0f, -10.0f, 10.0f);
        this.Shape21.setTextureSize(512, 512);
        this.Shape21.mirror = true;
        this.setRotation(this.Shape21, 0.0f, 0.0f, 0.0f);
        (this.Shape22 = new ModelRenderer((ModelBase) this, 20, 139)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape22.setRotationPoint(5.0f, -8.0f, 10.0f);
        this.Shape22.setTextureSize(512, 512);
        this.Shape22.mirror = true;
        this.setRotation(this.Shape22, 0.0f, 0.0f, 0.0f);
        (this.Shape23 = new ModelRenderer((ModelBase) this, 20, 132)).addBox(-4.0f, 0.0f, -2.0f, 3, 1, 1);
        this.Shape23.setRotationPoint(5.0f, -6.0f, 10.0f);
        this.Shape23.setTextureSize(512, 512);
        this.Shape23.mirror = true;
        this.setRotation(this.Shape23, 0.0f, 0.0f, 0.0f);
        (this.Shape24 = new ModelRenderer((ModelBase) this, 20, 124)).addBox(-4.0f, 0.0f, -2.0f, 2, 1, 1);
        this.Shape24.setRotationPoint(5.0f, -4.0f, 10.0f);
        this.Shape24.setTextureSize(512, 512);
        this.Shape24.mirror = true;
        this.setRotation(this.Shape24, 0.0f, 0.0f, 0.0f);
        (this.Shape25 = new ModelRenderer((ModelBase) this, 20, 114)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 3);
        this.Shape25.setRotationPoint(6.0f, -4.0f, 8.0f);
        this.Shape25.setTextureSize(512, 512);
        this.Shape25.mirror = true;
        this.setRotation(this.Shape25, 0.0f, 0.0f, 0.0f);
        (this.Shape26 = new ModelRenderer((ModelBase) this, 20, 106)).addBox(-4.0f, 0.0f, -2.0f, 2, 1, 1);
        this.Shape26.setRotationPoint(5.0f, -4.0f, 8.0f);
        this.Shape26.setTextureSize(512, 512);
        this.Shape26.mirror = true;
        this.setRotation(this.Shape26, 0.0f, 0.0f, 0.0f);
        (this.Shape27 = new ModelRenderer((ModelBase) this, 20, 94)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 5);
        this.Shape27.setRotationPoint(7.0f, -6.0f, 6.0f);
        this.Shape27.setTextureSize(512, 512);
        this.Shape27.mirror = true;
        this.setRotation(this.Shape27, 0.0f, 0.0f, 0.0f);
        (this.Shape28 = new ModelRenderer((ModelBase) this, 20, 83)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 5);
        this.Shape28.setRotationPoint(8.0f, -8.0f, 5.0f);
        this.Shape28.setTextureSize(512, 512);
        this.Shape28.mirror = true;
        this.setRotation(this.Shape28, 0.0f, 0.0f, 0.0f);
        (this.Shape29 = new ModelRenderer((ModelBase) this, 20, 70)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape29.setRotationPoint(8.0f, -10.0f, 4.0f);
        this.Shape29.setTextureSize(512, 512);
        this.Shape29.mirror = true;
        this.setRotation(this.Shape29, 0.0f, 0.0f, 0.0f);
        (this.Shape30 = new ModelRenderer((ModelBase) this, 20, 59)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape30.setRotationPoint(8.0f, -12.0f, 4.0f);
        this.Shape30.setTextureSize(512, 512);
        this.Shape30.mirror = true;
        this.setRotation(this.Shape30, 0.0f, 0.0f, 0.0f);
        (this.Shape31 = new ModelRenderer((ModelBase) this, 20, 47)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape31.setRotationPoint(8.0f, -14.0f, 4.0f);
        this.Shape31.setTextureSize(512, 512);
        this.Shape31.mirror = true;
        this.setRotation(this.Shape31, 0.0f, 0.0f, 0.0f);
        (this.Shape32 = new ModelRenderer((ModelBase) this, 20, 37)).addBox(-4.0f, 0.0f, -2.0f, 2, 1, 1);
        this.Shape32.setRotationPoint(6.0f, -6.0f, 6.0f);
        this.Shape32.setTextureSize(512, 512);
        this.Shape32.mirror = true;
        this.setRotation(this.Shape32, 0.0f, 0.0f, 0.0f);
        (this.Shape33 = new ModelRenderer((ModelBase) this, 20, 29)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape33.setRotationPoint(5.0f, -8.0f, 5.0f);
        this.Shape33.setTextureSize(512, 512);
        this.Shape33.mirror = true;
        this.setRotation(this.Shape33, 0.0f, 0.0f, 0.0f);
        (this.Shape34 = new ModelRenderer((ModelBase) this, 40, 312)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape34.setRotationPoint(5.0f, -10.0f, 4.0f);
        this.Shape34.setTextureSize(512, 512);
        this.Shape34.mirror = true;
        this.setRotation(this.Shape34, 0.0f, 0.0f, 0.0f);
        (this.Shape35 = new ModelRenderer((ModelBase) this, 40, 301)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape35.setRotationPoint(5.0f, -12.0f, 4.0f);
        this.Shape35.setTextureSize(512, 512);
        this.Shape35.mirror = true;
        this.setRotation(this.Shape35, 0.0f, 0.0f, 0.0f);
        (this.Shape36 = new ModelRenderer((ModelBase) this, 40, 291)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape36.setRotationPoint(5.0f, -14.0f, 4.0f);
        this.Shape36.setTextureSize(512, 512);
        this.Shape36.mirror = true;
        this.setRotation(this.Shape36, 0.0f, 0.0f, 0.0f);
        (this.Shape37 = new ModelRenderer((ModelBase) this, 40, 278)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 3);
        this.Shape37.setRotationPoint(1.0f, -4.0f, 8.0f);
        this.Shape37.setTextureSize(512, 512);
        this.Shape37.mirror = true;
        this.setRotation(this.Shape37, 0.0f, 0.0f, 0.0f);
        (this.Shape38 = new ModelRenderer((ModelBase) this, 40, 265)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 5);
        this.Shape38.setRotationPoint(0.0f, -6.0f, 6.0f);
        this.Shape38.setTextureSize(512, 512);
        this.Shape38.mirror = true;
        this.setRotation(this.Shape38, 0.0f, 0.0f, 0.0f);
        (this.Shape39 = new ModelRenderer((ModelBase) this, 40, 251)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape39.setRotationPoint(-1.0f, -8.0f, 5.0f);
        this.Shape39.setTextureSize(512, 512);
        this.Shape39.mirror = true;
        this.setRotation(this.Shape39, 0.0f, 0.0f, 0.0f);
        (this.Shape40 = new ModelRenderer((ModelBase) this, 40, 235)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape40.setRotationPoint(-1.0f, -10.0f, 4.0f);
        this.Shape40.setTextureSize(512, 512);
        this.Shape40.mirror = true;
        this.setRotation(this.Shape40, 0.0f, 0.0f, 0.0f);
        (this.Shape41 = new ModelRenderer((ModelBase) this, 40, 222)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape41.setRotationPoint(-1.0f, -12.0f, 4.0f);
        this.Shape41.setTextureSize(512, 512);
        this.Shape41.mirror = true;
        this.setRotation(this.Shape41, 0.0f, 0.0f, 0.0f);
        (this.Shape42 = new ModelRenderer((ModelBase) this, 40, 209)).addBox(-4.0f, 0.0f, -2.0f, 1, 1, 6);
        this.Shape42.setRotationPoint(-1.0f, -14.0f, 4.0f);
        this.Shape42.setTextureSize(512, 512);
        this.Shape42.mirror = true;
        this.setRotation(this.Shape42, 0.0f, 0.0f, 0.0f);
        (this.Shape43 = new ModelRenderer((ModelBase) this, 40, 200)).addBox(-4.0f, 0.0f, -2.0f, 2, 1, 1);
        this.Shape43.setRotationPoint(1.0f, -4.0f, 8.0f);
        this.Shape43.setTextureSize(512, 512);
        this.Shape43.mirror = true;
        this.setRotation(this.Shape43, 0.0f, 0.0f, 0.0f);
        (this.Shape44 = new ModelRenderer((ModelBase) this, 40, 189)).addBox(-4.0f, 0.0f, -2.0f, 2, 1, 1);
        this.Shape44.setRotationPoint(0.0f, -6.0f, 6.0f);
        this.Shape44.setTextureSize(512, 512);
        this.Shape44.mirror = true;
        this.setRotation(this.Shape44, 0.0f, 0.0f, 0.0f);
        (this.Shape45 = new ModelRenderer((ModelBase) this, 40, 180)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape45.setRotationPoint(-1.0f, -8.0f, 5.0f);
        this.Shape45.setTextureSize(512, 512);
        this.Shape45.mirror = true;
        this.setRotation(this.Shape45, 0.0f, 0.0f, 0.0f);
        (this.Shape46 = new ModelRenderer((ModelBase) this, 40, 170)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape46.setRotationPoint(-1.0f, -10.0f, 4.0f);
        this.Shape46.setTextureSize(512, 512);
        this.Shape46.mirror = true;
        this.setRotation(this.Shape46, 0.0f, 0.0f, 0.0f);
        (this.Shape47 = new ModelRenderer((ModelBase) this, 40, 161)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape47.setRotationPoint(-1.0f, -12.0f, 4.0f);
        this.Shape47.setTextureSize(512, 512);
        this.Shape47.mirror = true;
        this.setRotation(this.Shape47, 0.0f, 0.0f, 0.0f);
        (this.Shape48 = new ModelRenderer((ModelBase) this, 40, 151)).addBox(-4.0f, 0.0f, -2.0f, 4, 1, 1);
        this.Shape48.setRotationPoint(-1.0f, -14.0f, 4.0f);
        this.Shape48.setTextureSize(512, 512);
        this.Shape48.mirror = true;
        this.setRotation(this.Shape48, 0.0f, 0.0f, 0.0f);
        (this.Shape49 = new ModelRenderer((ModelBase) this, 40, 140)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 3);
        this.Shape49.setRotationPoint(-7.5f, -15.5f, 3.0f);
        this.Shape49.setTextureSize(512, 512);
        this.Shape49.mirror = true;
        this.setRotation(this.Shape49, 0.0f, 0.0f, 0.524f);
        (this.rarm2 = new ModelRenderer((ModelBase) this, 40, 122)).addBox(-4.0f, 0.0f, -2.0f, 1, 12, 1);
        this.rarm2.setRotationPoint(-5.0f, -11.5f, 8.0f);
        this.rarm2.setTextureSize(512, 512);
        this.rarm2.mirror = true;
        this.setRotation(this.rarm2, 0.0f, -0.5f, 0.524f);
        (this.rarm3 = new ModelRenderer((ModelBase) this, 49, 122)).addBox(-4.0f, 0.0f, -2.0f, 1, 12, 1);
        this.rarm3.setRotationPoint(-4.0f, -11.5f, 6.0f);
        this.rarm3.setTextureSize(512, 512);
        this.rarm3.mirror = true;
        this.setRotation(this.rarm3, 0.0f, -0.5f, 0.524f);
        (this.relbow = new ModelRenderer((ModelBase) this, 40, 111)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 3);
        this.relbow.setRotationPoint(-11.0f, -3.5f, 3.0f);
        this.relbow.setTextureSize(512, 512);
        this.relbow.mirror = true;
        this.setRotation(this.relbow, 0.0f, -0.5f, 0.524f);
        (this.rarm1 = new ModelRenderer((ModelBase) this, 40, 91)).addBox(-2.0f, -1.0f, -1.0f, 1, 11, 2);
        this.rarm1.setRotationPoint(-10.5f, -2.0f, 2.5f);
        this.rarm1.setTextureSize(512, 512);
        this.rarm1.mirror = true;
        this.setRotation(this.rarm1, -0.76f, 0.0f, 0.3f);
        (this.Shape54 = new ModelRenderer((ModelBase) this, 40, 78)).addBox(0.0f, 0.0f, 0.0f, 3, 2, 3);
        this.Shape54.setRotationPoint(5.0f, -14.0f, 3.0f);
        this.Shape54.setTextureSize(512, 512);
        this.Shape54.mirror = true;
        this.setRotation(this.Shape54, 0.0f, 0.0f, -0.524f);
        (this.larm3 = new ModelRenderer((ModelBase) this, 40, 58)).addBox(-4.0f, 0.0f, -2.0f, 1, 12, 1);
        this.larm3.setRotationPoint(9.5f, -15.0f, 3.0f);
        this.larm3.setTextureSize(512, 512);
        this.larm3.mirror = true;
        this.setRotation(this.larm3, 0.0f, 0.5f, -0.524f);
        (this.larm2 = new ModelRenderer((ModelBase) this, 40, 35)).addBox(-4.0f, 0.0f, -2.0f, 1, 12, 1);
        this.larm2.setRotationPoint(10.5f, -15.0f, 5.0f);
        this.larm2.setTextureSize(512, 512);
        this.larm2.mirror = true;
        this.setRotation(this.larm2, 0.0f, 0.5f, -0.524f);
        (this.lelbow = new ModelRenderer((ModelBase) this, 55, 38)).addBox(0.0f, 0.0f, 0.0f, 2, 2, 4);
        this.lelbow.setRotationPoint(10.0f, -3.0f, 3.0f);
        this.lelbow.setTextureSize(512, 512);
        this.lelbow.mirror = true;
        this.setRotation(this.lelbow, 0.0f, 0.5f, -0.524f);
        (this.larm1 = new ModelRenderer((ModelBase) this, 56, 53)).addBox(0.0f, 0.0f, -1.0f, 1, 9, 2);
        this.larm1.setRotationPoint(12.0f, -3.0f, 2.5f);
        this.larm1.setTextureSize(512, 512);
        this.larm1.mirror = true;
        this.setRotation(this.larm1, 0.0f, -0.6f, -0.3f);
        (this.scythe1 = new ModelRenderer((ModelBase) this, 57, 70)).addBox(0.0f, -39.0f, 1.0f, 1, 39, 1);
        this.scythe1.setRotationPoint(-17.0f, 6.0f, -2.0f);
        this.scythe1.setTextureSize(512, 512);
        this.scythe1.mirror = true;
        this.setRotation(this.scythe1, 0.0f, 0.0f, 1.0f);
        (this.scythe2 = new ModelRenderer((ModelBase) this, 58, 118)).addBox(0.0f, -39.0f, 1.0f, 16, 6, 0);
        this.scythe2.setRotationPoint(-17.0f, 6.0f, -2.0f);
        this.scythe2.setTextureSize(512, 512);
        this.scythe2.mirror = true;
        this.setRotation(this.scythe2, 0.0f, 0.0f, 1.0f);
        (this.scythe3 = new ModelRenderer((ModelBase) this, 61, 133)).addBox(9.0f, -34.0f, 1.0f, 7, 5, 0);
        this.scythe3.setRotationPoint(-17.0f, 6.0f, -2.0f);
        this.scythe3.setTextureSize(512, 512);
        this.scythe3.mirror = true;
        this.setRotation(this.scythe3, 0.0f, 0.0f, 1.0f);
        (this.head = new ModelRenderer((ModelBase) this, 58, 145)).addBox(-3.0f, -6.0f, -3.0f, 6, 6, 5);
        this.head.setRotationPoint(0.0f, -16.0f, 4.0f);
        this.head.setTextureSize(512, 512);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.lwing3 = new ModelRenderer((ModelBase) this, 71, 58)).addBox(-0.5f, 0.0f, 0.0f, 1, 19, 3);
        this.lwing3.setRotationPoint(4.0f, -11.7f, 8.5f);
        this.lwing3.setTextureSize(512, 512);
        this.lwing3.mirror = true;
        this.setRotation(this.lwing3, 2.356f, 0.785f, 0.0f);
        (this.lwing2 = new ModelRenderer((ModelBase) this, 58, 168)).addBox(-0.5f, 11.0f, -2.0f, 1, 19, 3);
        this.lwing2.setRotationPoint(4.0f, -23.9f, 8.5f);
        this.lwing2.setTextureSize(512, 512);
        this.lwing2.mirror = true;
        this.setRotation(this.lwing2, 1.745f, 0.785f, 0.0f);
        (this.rwing3 = new ModelRenderer((ModelBase) this, 71, 88)).addBox(-0.5f, 0.0f, 0.0f, 1, 19, 3);
        this.rwing3.setRotationPoint(-4.0f, -11.7f, 8.5f);
        this.rwing3.setTextureSize(512, 512);
        this.rwing3.mirror = true;
        this.setRotation(this.rwing3, 2.356f, -0.785f, 0.0f);
        (this.rwing2 = new ModelRenderer((ModelBase) this, 73, 168)).addBox(-0.5f, 12.0f, -2.0f, 1, 19, 3);
        this.rwing2.setRotationPoint(-4.0f, -23.9f, 8.5f);
        this.rwing2.setTextureSize(512, 512);
        this.rwing2.mirror = true;
        this.setRotation(this.rwing2, 1.745f, -0.785f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final EnderReaper e = (EnderReaper) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.25f * f1;
        } else {
            newangle = 0.0f;
        }
        final ModelRenderer scythe3 = this.scythe3;
        final ModelRenderer scythe4 = this.scythe2;
        final ModelRenderer scythe5 = this.scythe1;
        final float rotateAngleZ = 1.0f - Math.abs(newangle);
        scythe5.rotateAngleZ = rotateAngleZ;
        scythe4.rotateAngleZ = rotateAngleZ;
        scythe3.rotateAngleZ = rotateAngleZ;
        if (e.isScreaming()) {
            newangle = MathHelper.cos(f2 * 1.9f * this.wingspeed) * 3.1415927f * 0.25f;
            final ModelRenderer scythe6 = this.scythe3;
            final ModelRenderer scythe7 = this.scythe2;
            final ModelRenderer scythe8 = this.scythe1;
            final float rotateAngleZ2 = 1.0f + newangle;
            scythe8.rotateAngleZ = rotateAngleZ2;
            scythe7.rotateAngleZ = rotateAngleZ2;
            scythe6.rotateAngleZ = rotateAngleZ2;
            this.larm1.rotateAngleX = -0.436f;
            this.larm1.rotateAngleY = -0.488f;
            newangle = MathHelper.cos(f2 * 2.7f * this.wingspeed) * 3.1415927f * 0.3f;
        } else {
            this.larm1.rotateAngleX = -2.436f;
            this.larm1.rotateAngleY = 1.0f;
            newangle = MathHelper.cos(f2 * 0.7f * this.wingspeed) * 3.1415927f * 0.06f;
        }
        final ModelRenderer lwing1 = this.lwing1;
        final ModelRenderer lwing2 = this.lwing2;
        final ModelRenderer lwing3 = this.lwing3;
        final float rotateAngleY = 0.785f + newangle;
        lwing3.rotateAngleY = rotateAngleY;
        lwing2.rotateAngleY = rotateAngleY;
        lwing1.rotateAngleY = rotateAngleY;
        final ModelRenderer rwing1 = this.rwing1;
        final ModelRenderer rwing2 = this.rwing2;
        final ModelRenderer rwing3 = this.rwing3;
        final float rotateAngleY2 = -0.785f - newangle;
        rwing3.rotateAngleY = rotateAngleY2;
        rwing2.rotateAngleY = rotateAngleY2;
        rwing1.rotateAngleY = rotateAngleY2;
        this.head.rotateAngleY = (float) Math.toRadians(f3) * 0.45f;
        if (this.head.rotateAngleY > 0.45f) {
            this.head.rotateAngleY = 0.45f;
        }
        if (this.head.rotateAngleY < -0.45f) {
            this.head.rotateAngleY = -0.45f;
        }
        this.rwing1.render(f5);
        this.lwing1.render(f5);
        this.Shape3.render(f5);
        this.Shape4.render(f5);
        this.Shape5.render(f5);
        this.Shape6.render(f5);
        this.Shape7.render(f5);
        this.Shape8.render(f5);
        this.Shape9.render(f5);
        this.Shape10.render(f5);
        this.Shape11.render(f5);
        this.Shape12.render(f5);
        this.Shape13.render(f5);
        this.Shape14.render(f5);
        this.Shape15.render(f5);
        this.Shape16.render(f5);
        this.Shape17.render(f5);
        this.Shape18.render(f5);
        this.Shape19.render(f5);
        this.Shape20.render(f5);
        this.Shape21.render(f5);
        this.Shape22.render(f5);
        this.Shape23.render(f5);
        this.Shape24.render(f5);
        this.Shape25.render(f5);
        this.Shape26.render(f5);
        this.Shape27.render(f5);
        this.Shape28.render(f5);
        this.Shape29.render(f5);
        this.Shape30.render(f5);
        this.Shape31.render(f5);
        this.Shape32.render(f5);
        this.Shape33.render(f5);
        this.Shape34.render(f5);
        this.Shape35.render(f5);
        this.Shape36.render(f5);
        this.Shape37.render(f5);
        this.Shape38.render(f5);
        this.Shape39.render(f5);
        this.Shape40.render(f5);
        this.Shape41.render(f5);
        this.Shape42.render(f5);
        this.Shape43.render(f5);
        this.Shape44.render(f5);
        this.Shape45.render(f5);
        this.Shape46.render(f5);
        this.Shape47.render(f5);
        this.Shape48.render(f5);
        this.Shape49.render(f5);
        this.rarm2.render(f5);
        this.rarm3.render(f5);
        this.relbow.render(f5);
        this.rarm1.render(f5);
        this.Shape54.render(f5);
        this.larm3.render(f5);
        this.larm2.render(f5);
        this.lelbow.render(f5);
        this.larm1.render(f5);
        this.scythe1.render(f5);
        this.scythe2.render(f5);
        this.scythe3.render(f5);
        this.head.render(f5);
        this.lwing3.render(f5);
        this.lwing2.render(f5);
        this.rwing3.render(f5);
        this.rwing2.render(f5);
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
