
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.CaterKiller;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCaterKiller extends ModelBase {

    private float wingspeed;
    ModelRenderer Head;
    ModelRenderer falsehead;
    ModelRenderer seg1;
    ModelRenderer ltusk1;
    ModelRenderer ltusk2;
    ModelRenderer rtusk1;
    ModelRenderer rtusk2;
    ModelRenderer ljaw;
    ModelRenderer rjaw;
    ModelRenderer seg1lspike;
    ModelRenderer seg1rspike;
    ModelRenderer seg1ltopspike;
    ModelRenderer seg1rtopspike;
    ModelRenderer seg1lleg;
    ModelRenderer seg1rleg;
    ModelRenderer seg2;
    ModelRenderer seg2lfoot;
    ModelRenderer seg2rfoot;
    ModelRenderer seg2ltopspike;
    ModelRenderer seg2rtopspike;
    ModelRenderer seg2lspike;
    ModelRenderer seg2rspike;
    ModelRenderer seg3;
    ModelRenderer seg3lfoot;
    ModelRenderer seg3rfoot;
    ModelRenderer seg3lspike;
    ModelRenderer seg3rspike;
    ModelRenderer seg3ltopspike;
    ModelRenderer seg3rtopspike;
    ModelRenderer seg3lbackspike;
    ModelRenderer seg3rbackspike;

    public ModelCaterKiller(final float f1) {
        this.wingspeed = 1.0f;
        this.wingspeed = f1;
        this.textureWidth = 256;
        this.textureHeight = 512;
        (this.Head = new ModelRenderer((ModelBase) this, 0, 50)).addBox(-8.0f, -8.0f, -8.0f, 16, 16, 8);
        this.Head.setRotationPoint(0.0f, -8.0f, -12.0f);
        this.Head.setTextureSize(64, 32);
        this.Head.mirror = true;
        this.setRotation(this.Head, 0.0f, 0.0f, 0.0f);
        (this.falsehead = new ModelRenderer((ModelBase) this, 0, 100)).addBox(-10.0f, -27.0f, -11.0f, 20, 20, 10);
        this.falsehead.setRotationPoint(0.0f, -8.0f, -12.0f);
        this.falsehead.setTextureSize(64, 32);
        this.falsehead.mirror = true;
        this.setRotation(this.falsehead, -0.1570796f, 0.0f, 0.0f);
        (this.seg1 = new ModelRenderer((ModelBase) this, 0, 200)).addBox(-14.0f, -31.0f, 0.0f, 28, 32, 14);
        this.seg1.setRotationPoint(0.0f, -8.0f, -12.0f);
        this.seg1.setTextureSize(64, 32);
        this.seg1.mirror = true;
        this.setRotation(this.seg1, 0.0f, 0.0f, 0.0f);
        (this.ltusk1 = new ModelRenderer((ModelBase) this, 0, 140)).addBox(-1.0f, -1.0f, -1.0f, 33, 3, 3);
        this.ltusk1.setRotationPoint(9.0f, -25.0f, -19.0f);
        this.ltusk1.setTextureSize(64, 32);
        this.ltusk1.mirror = true;
        this.setRotation(this.ltusk1, 0.0f, 0.5585054f, 0.0f);
        (this.ltusk2 = new ModelRenderer((ModelBase) this, 0, 160)).addBox(0.0f, 0.0f, 0.0f, 20, 1, 1);
        this.ltusk2.setRotationPoint(36.0f, -25.0f, -36.0f);
        this.ltusk2.setTextureSize(64, 32);
        this.ltusk2.mirror = true;
        this.setRotation(this.ltusk2, 0.0f, 0.8028515f, 0.0f);
        (this.rtusk1 = new ModelRenderer((ModelBase) this, 0, 150)).addBox(-33.0f, 0.0f, 0.0f, 33, 3, 3);
        this.rtusk1.setRotationPoint(-8.0f, -25.0f, -17.0f);
        this.rtusk1.setTextureSize(64, 32);
        this.rtusk1.mirror = true;
        this.setRotation(this.rtusk1, 0.0f, -0.5585054f, 0.0f);
        (this.rtusk2 = new ModelRenderer((ModelBase) this, 0, 170)).addBox(-20.0f, 0.0f, 0.0f, 20, 1, 1);
        this.rtusk2.setRotationPoint(-36.0f, -24.0f, -34.0f);
        this.rtusk2.setTextureSize(64, 32);
        this.rtusk2.mirror = true;
        this.setRotation(this.rtusk2, 0.0f, -0.8028515f, 0.0f);
        (this.ljaw = new ModelRenderer((ModelBase) this, 100, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 4);
        this.ljaw.setRotationPoint(4.0f, -1.0f, -18.0f);
        this.ljaw.setTextureSize(64, 32);
        this.ljaw.mirror = true;
        this.setRotation(this.ljaw, 0.0f, 0.0f, 0.1396263f);
        (this.rjaw = new ModelRenderer((ModelBase) this, 125, 50)).addBox(0.0f, 0.0f, 0.0f, 1, 7, 4);
        this.rjaw.setRotationPoint(-5.0f, -1.0f, -18.0f);
        this.rjaw.setTextureSize(64, 32);
        this.rjaw.mirror = true;
        this.setRotation(this.rjaw, 0.0f, 0.0f, -0.1396263f);
        (this.seg1lspike = new ModelRenderer((ModelBase) this, 0, 260)).addBox(-1.0f, -1.0f, -1.0f, 33, 2, 2);
        this.seg1lspike.setRotationPoint(14.0f, -32.0f, -6.0f);
        this.seg1lspike.setTextureSize(64, 32);
        this.seg1lspike.mirror = true;
        this.setRotation(this.seg1lspike, 0.0f, 0.3316126f, -0.122173f);
        (this.seg1rspike = new ModelRenderer((ModelBase) this, 0, 270)).addBox(-33.0f, -1.0f, -1.0f, 33, 2, 2);
        this.seg1rspike.setRotationPoint(-13.0f, -32.0f, -6.0f);
        this.seg1rspike.setTextureSize(64, 32);
        this.seg1rspike.mirror = true;
        this.setRotation(this.seg1rspike, 0.0f, -0.3316126f, 0.122173f);
        (this.seg1ltopspike = new ModelRenderer((ModelBase) this, 125, 260)).addBox(-2.0f, -8.0f, -2.0f, 4, 9, 4);
        this.seg1ltopspike.setRotationPoint(8.0f, -39.0f, -6.0f);
        this.seg1ltopspike.setTextureSize(64, 32);
        this.seg1ltopspike.mirror = true;
        this.setRotation(this.seg1ltopspike, 0.0f, 0.0f, 0.1396263f);
        (this.seg1rtopspike = new ModelRenderer((ModelBase) this, 150, 260)).addBox(-2.0f, -8.0f, -2.0f, 4, 9, 4);
        this.seg1rtopspike.setRotationPoint(-10.0f, -39.0f, -6.0f);
        this.seg1rtopspike.setTextureSize(64, 32);
        this.seg1rtopspike.mirror = true;
        this.setRotation(this.seg1rtopspike, 0.0f, 0.0f, -0.1396263f);
        (this.seg1lleg = new ModelRenderer((ModelBase) this, 125, 200)).addBox(-1.0f, 0.0f, -1.0f, 2, 16, 2);
        this.seg1lleg.setRotationPoint(8.0f, -8.0f, -5.0f);
        this.seg1lleg.setTextureSize(64, 32);
        this.seg1lleg.mirror = true;
        this.setRotation(this.seg1lleg, 0.0f, 0.0f, 0.1570796f);
        (this.seg1rleg = new ModelRenderer((ModelBase) this, 150, 200)).addBox(0.0f, 0.0f, 0.0f, 2, 16, 2);
        this.seg1rleg.setRotationPoint(-9.0f, -8.0f, -5.0f);
        this.seg1rleg.setTextureSize(64, 32);
        this.seg1rleg.mirror = true;
        this.setRotation(this.seg1rleg, 0.0f, 0.0f, -0.1570796f);
        (this.seg2 = new ModelRenderer((ModelBase) this, 0, 300)).addBox(-20.0f, -17.0f, -9.0f, 40, 34, 18);
        this.seg2.setRotationPoint(0.0f, -2.0f, 32.0f);
        this.seg2.setTextureSize(64, 32);
        this.seg2.mirror = true;
        this.setRotation(this.seg2, 0.0f, 0.0f, 0.0f);
        (this.seg2lfoot = new ModelRenderer((ModelBase) this, 125, 300)).addBox(-5.0f, 0.0f, -5.0f, 10, 10, 10);
        this.seg2lfoot.setRotationPoint(13.0f, 14.0f, 32.0f);
        this.seg2lfoot.setTextureSize(64, 32);
        this.seg2lfoot.mirror = true;
        this.setRotation(this.seg2lfoot, 0.0f, 0.0f, 0.0f);
        (this.seg2rfoot = new ModelRenderer((ModelBase) this, 175, 300)).addBox(-5.0f, 0.0f, -5.0f, 10, 10, 10);
        this.seg2rfoot.setRotationPoint(-13.0f, 14.0f, 32.0f);
        this.seg2rfoot.setTextureSize(64, 32);
        this.seg2rfoot.mirror = true;
        this.setRotation(this.seg2rfoot, 0.0f, 0.0f, 0.0f);
        (this.seg2ltopspike = new ModelRenderer((ModelBase) this, 100, 360)).addBox(-2.0f, -9.0f, -2.0f, 4, 9, 4);
        this.seg2ltopspike.setRotationPoint(14.0f, -18.0f, 32.0f);
        this.seg2ltopspike.setTextureSize(64, 32);
        this.seg2ltopspike.mirror = true;
        this.setRotation(this.seg2ltopspike, 0.0f, 0.0f, 0.1396263f);
        (this.seg2rtopspike = new ModelRenderer((ModelBase) this, 125, 360)).addBox(-2.0f, -9.0f, -2.0f, 4, 9, 4);
        this.seg2rtopspike.setRotationPoint(-14.0f, -18.0f, 32.0f);
        this.seg2rtopspike.setTextureSize(64, 32);
        this.seg2rtopspike.mirror = true;
        this.setRotation(this.seg2rtopspike, 0.0f, 0.0f, -0.1396263f);
        (this.seg2lspike = new ModelRenderer((ModelBase) this, 0, 360)).addBox(0.0f, -1.0f, -1.0f, 20, 2, 2);
        this.seg2lspike.setRotationPoint(18.0f, -9.0f, 32.0f);
        this.seg2lspike.setTextureSize(64, 32);
        this.seg2lspike.mirror = true;
        this.setRotation(this.seg2lspike, 0.0f, 0.0f, -0.0698132f);
        (this.seg2rspike = new ModelRenderer((ModelBase) this, 0, 370)).addBox(-20.0f, -1.0f, -1.0f, 20, 2, 2);
        this.seg2rspike.setRotationPoint(-18.0f, -9.0f, 32.0f);
        this.seg2rspike.setTextureSize(64, 32);
        this.seg2rspike.mirror = true;
        this.setRotation(this.seg2rspike, 0.0f, 0.0f, 0.0698132f);
        (this.seg3 = new ModelRenderer((ModelBase) this, 0, 400)).addBox(-15.0f, -14.0f, -7.0f, 30, 28, 14);
        this.seg3.setRotationPoint(0.0f, 3.0f, 48.0f);
        this.seg3.setTextureSize(64, 32);
        this.seg3.mirror = true;
        this.setRotation(this.seg3, 0.0f, 0.0f, 0.0f);
        (this.seg3lfoot = new ModelRenderer((ModelBase) this, 100, 400)).addBox(-4.0f, 0.0f, -6.0f, 8, 8, 12);
        this.seg3lfoot.setRotationPoint(10.0f, 16.0f, 48.0f);
        this.seg3lfoot.setTextureSize(64, 32);
        this.seg3lfoot.mirror = true;
        this.setRotation(this.seg3lfoot, 0.0f, 0.0f, 0.0f);
        (this.seg3rfoot = new ModelRenderer((ModelBase) this, 150, 400)).addBox(-4.0f, 0.0f, -6.0f, 8, 8, 12);
        this.seg3rfoot.setRotationPoint(-10.0f, 16.0f, 48.0f);
        this.seg3rfoot.setTextureSize(64, 32);
        this.seg3rfoot.mirror = true;
        this.setRotation(this.seg3rfoot, 0.0f, 0.0f, 0.0f);
        (this.seg3lspike = new ModelRenderer((ModelBase) this, 0, 450)).addBox(0.0f, -1.0f, -1.0f, 14, 2, 2);
        this.seg3lspike.setRotationPoint(14.0f, -4.0f, 48.0f);
        this.seg3lspike.setTextureSize(64, 32);
        this.seg3lspike.mirror = true;
        this.setRotation(this.seg3lspike, 0.0f, 0.0f, -0.0698132f);
        (this.seg3rspike = new ModelRenderer((ModelBase) this, 0, 460)).addBox(-14.0f, -1.0f, -1.0f, 14, 2, 2);
        this.seg3rspike.setRotationPoint(-14.0f, -4.0f, 48.0f);
        this.seg3rspike.setTextureSize(64, 32);
        this.seg3rspike.mirror = true;
        this.setRotation(this.seg3rspike, 0.0f, 0.0f, 0.0698132f);
        (this.seg3ltopspike = new ModelRenderer((ModelBase) this, 100, 450)).addBox(-2.0f, -13.0f, -2.0f, 3, 13, 3);
        this.seg3ltopspike.setRotationPoint(10.0f, -10.0f, 48.0f);
        this.seg3ltopspike.setTextureSize(64, 32);
        this.seg3ltopspike.mirror = true;
        this.setRotation(this.seg3ltopspike, 0.0f, 0.0f, 0.1396263f);
        (this.seg3rtopspike = new ModelRenderer((ModelBase) this, 120, 450)).addBox(-2.0f, -13.0f, -2.0f, 3, 13, 3);
        this.seg3rtopspike.setRotationPoint(-10.0f, -10.0f, 48.0f);
        this.seg3rtopspike.setTextureSize(64, 32);
        this.seg3rtopspike.mirror = true;
        this.setRotation(this.seg3rtopspike, 0.0f, 0.0f, -0.1396263f);
        (this.seg3lbackspike = new ModelRenderer((ModelBase) this, 50, 450)).addBox(-2.0f, -20.0f, -2.0f, 4, 20, 4);
        this.seg3lbackspike.setRotationPoint(13.0f, -8.0f, 54.0f);
        this.seg3lbackspike.setTextureSize(64, 32);
        this.seg3lbackspike.mirror = true;
        this.setRotation(this.seg3lbackspike, -0.9773844f, 0.2792527f, 0.1396263f);
        (this.seg3rbackspike = new ModelRenderer((ModelBase) this, 75, 450)).addBox(-2.0f, -20.0f, -2.0f, 4, 20, 4);
        this.seg3rbackspike.setRotationPoint(-13.0f, -8.0f, 54.0f);
        this.seg3rbackspike.setTextureSize(64, 32);
        this.seg3rbackspike.mirror = true;
        this.setRotation(this.seg3rbackspike, -0.9773844f, -0.3490659f, 0.1396263f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final CaterKiller e = (CaterKiller) entity;
        float newangle = 0.0f;
        float headoff = 0.0f;
        float zpi = 0.0f;
        float zdist = 0.0f;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        if (e.getAttacking() != 0) {
            newangle = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 3.1415927f * 0.07f;
        } else {
            newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.025f;
        }
        this.ljaw.rotateAngleZ = 0.139f + newangle;
        this.rjaw.rotateAngleZ = -0.139f - newangle;
        if (e.getAttacking() != 0) {
            headoff = MathHelper.cos(f2 * 1.7f * this.wingspeed) * 8.0f;
        } else {
            headoff = MathHelper.cos(f2 * 0.3f * this.wingspeed) * 2.0f;
        }
        this.Head.rotationPointY = -8.0f + headoff;
        this.falsehead.rotationPointY = -8.0f + headoff;
        this.ltusk1.rotationPointY = -25.0f + headoff;
        this.ltusk2.rotationPointY = -25.0f + headoff;
        this.rtusk1.rotationPointY = -25.0f + headoff;
        this.rtusk2.rotationPointY = -25.0f + headoff;
        this.ljaw.rotationPointY = -1.0f + headoff;
        this.rjaw.rotationPointY = -1.0f + headoff;
        newangle = MathHelper.cos(f2 * 2.11f * this.wingspeed) * 3.1415927f * 0.08f;
        this.ltusk2.rotateAngleY = 0.802f + newangle;
        newangle = MathHelper.cos(f2 * 2.3f * this.wingspeed) * 3.1415927f * 0.08f;
        this.rtusk2.rotateAngleY = -0.802f + newangle;
        this.Head.render(f5);
        this.falsehead.render(f5);
        this.ltusk1.render(f5);
        this.ltusk2.render(f5);
        this.rtusk1.render(f5);
        this.rtusk2.render(f5);
        this.ljaw.render(f5);
        this.rjaw.render(f5);
        for (int i = 0; i < 3; ++i) {
            this.seg1.rotationPointY = -8.0f + headoff / (i + 1) + 8 * i;
            this.seg1lspike.rotationPointY = -32.0f + headoff / (i + 1) + 8 * i;
            this.seg1rspike.rotationPointY = -32.0f + headoff / (i + 1) + 8 * i;
            this.seg1ltopspike.rotationPointY = -39.0f + headoff / (i + 1) + 8 * i;
            this.seg1rtopspike.rotationPointY = -39.0f + headoff / (i + 1) + 8 * i;
            this.seg1lleg.rotationPointY = -8.0f + headoff / (i + 1) + 8 * i;
            this.seg1rleg.rotationPointY = -8.0f + headoff / (i + 1) + 8 * i;
            this.seg1.rotationPointZ = (float) (-12 + 14 * i);
            this.seg1lspike.rotationPointZ = (float) (-6 + 14 * i);
            this.seg1rspike.rotationPointZ = (float) (-6 + 14 * i);
            this.seg1ltopspike.rotationPointZ = (float) (-6 + 14 * i);
            this.seg1rtopspike.rotationPointZ = (float) (-6 + 14 * i);
            this.seg1lleg.rotationPointZ = (float) (-5 + 14 * i);
            this.seg1rleg.rotationPointZ = (float) (-5 + 14 * i);
            newangle = MathHelper.cos((float) (f2 * 0.91f * this.wingspeed + 0.39269908169872414 * i)) * 3.1415927f
                * 0.08f;
            this.seg1lspike.rotateAngleZ = newangle;
            this.seg1rspike.rotateAngleZ = -newangle;
            if (e.getAttacking() != 0) {
                newangle = MathHelper.cos((float) (f2 * 2.91f * this.wingspeed + 0.39269908169872414 * i)) * 3.1415927f
                    * 0.15f;
            } else {
                newangle = MathHelper.cos((float) (f2 * 0.35f * this.wingspeed + 0.39269908169872414 * i)) * 3.1415927f
                    * 0.04f;
            }
            this.seg1lleg.rotateAngleX = newangle;
            this.seg1rleg.rotateAngleX = -newangle;
            this.seg1.render(f5);
            this.seg1lspike.render(f5);
            this.seg1rspike.render(f5);
            this.seg1ltopspike.render(f5);
            this.seg1rtopspike.render(f5);
            this.seg1lleg.render(f5);
            this.seg1rleg.render(f5);
        }
        for (int i = 0; i < 6; ++i) {
            zdist = MathHelper.cos(f2 * 1.7f * this.wingspeed + zpi) * 1.5f * f1;
            this.seg2.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            this.seg2lfoot.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            this.seg2rfoot.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            this.seg2ltopspike.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            this.seg2rtopspike.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            this.seg2lspike.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            this.seg2rspike.rotationPointZ = 39.0f + (16.0f + zdist) * i;
            newangle = MathHelper.cos((float) (f2 * 0.4f * this.wingspeed - 0.39269908169872414 * i)) * 3.1415927f
                * 0.07f;
            this.seg2lspike.rotateAngleZ = newangle;
            this.seg2rspike.rotateAngleZ = -newangle;
            this.seg2.render(f5);
            this.seg2lfoot.render(f5);
            this.seg2rfoot.render(f5);
            this.seg2ltopspike.render(f5);
            this.seg2rtopspike.render(f5);
            this.seg2lspike.render(f5);
            this.seg2rspike.render(f5);
            zpi += 0.7853982f;
        }
        this.seg3.rotationPointZ = this.seg2rspike.rotationPointZ + 16.0f;
        this.seg3lfoot.rotationPointZ = this.seg3.rotationPointZ;
        this.seg3rfoot.rotationPointZ = this.seg3.rotationPointZ;
        this.seg3lspike.rotationPointZ = this.seg3.rotationPointZ;
        this.seg3rspike.rotationPointZ = this.seg3.rotationPointZ;
        this.seg3ltopspike.rotationPointZ = this.seg3.rotationPointZ;
        this.seg3rtopspike.rotationPointZ = this.seg3.rotationPointZ;
        this.seg3lbackspike.rotationPointZ = this.seg3.rotationPointZ + 6.0f;
        this.seg3rbackspike.rotationPointZ = this.seg3.rotationPointZ + 6.0f;
        int i = 6;
        newangle = MathHelper.cos((float) (f2 * 0.4f * this.wingspeed - 0.39269908169872414 * i)) * 3.1415927f * 0.07f;
        this.seg3lspike.rotateAngleZ = newangle;
        this.seg3rspike.rotateAngleZ = -newangle;
        newangle = MathHelper.cos(f2 * 0.81f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3lbackspike.rotateAngleX = -0.977f + newangle;
        newangle = MathHelper.cos(f2 * 0.87f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3rbackspike.rotateAngleX = -0.977f + newangle;
        newangle = MathHelper.cos(f2 * 1.11f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3lbackspike.rotateAngleY = 0.28f + newangle;
        newangle = MathHelper.cos(f2 * 1.3f * this.wingspeed) * 3.1415927f * 0.04f;
        this.seg3rbackspike.rotateAngleY = -0.28f + newangle;
        this.seg3.render(f5);
        this.seg3lfoot.render(f5);
        this.seg3rfoot.render(f5);
        this.seg3lspike.render(f5);
        this.seg3rspike.render(f5);
        this.seg3ltopspike.render(f5);
        this.seg3rtopspike.render(f5);
        this.seg3lbackspike.render(f5);
        this.seg3rbackspike.render(f5);
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
