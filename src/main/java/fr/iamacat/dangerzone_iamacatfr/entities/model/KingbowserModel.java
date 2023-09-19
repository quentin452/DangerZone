
package fr.iamacat.dangerzone_iamacatfr.entities.model;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.KingbowserInstance;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import org.lwjgl.opengl.GL11;

public class KingbowserModel extends ModelBase {

    private float wingspeed;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;
    ModelRenderer tail;
    ModelRenderer tailend;
    ModelRenderer rightleg2;
    ModelRenderer leftleg2;
    ModelRenderer shield;
    ModelRenderer Spike5;
    ModelRenderer Spike6;
    ModelRenderer Spike4;
    ModelRenderer Snout;
    ModelRenderer Spike7;
    ModelRenderer Spike8;
    ModelRenderer Spike9;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;

    public KingbowserModel() {
        this.wingspeed = 0.4f;
        this.textureWidth = 512;
        this.textureHeight = 512;
        (this.head = new ModelRenderer((ModelBase) this, 0, 22)).addBox(-4.0f, -8.0f, -4.0f, 10, 10, 10);
        this.head.setRotationPoint(-1.0f, -2.0f, 0.0f);
        this.head.setTextureSize(512, 512);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase) this, 16, 52)).addBox(-4.5f, 0.0f, -4.0f, 9, 12, 8);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(512, 512);
        this.body.mirror = true;
        this.setRotation(this.body, 0.5205006f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase) this, 40, 160)).addBox(-3.0f, -2.0f, -2.0f, 4, 8, 4);
        this.rightarm.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.rightarm.setTextureSize(512, 512);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, -1.59868f, 0.4461433f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase) this, 40, 160)).addBox(-1.0f, -2.0f, -2.0f, 4, 8, 4);
        this.leftarm.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.leftarm.setTextureSize(512, 512);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, -1.561502f, -0.2974289f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase) this, 16, 120)).addBox(-2.0f, 0.0f, -2.0f, 5, 12, 5);
        this.rightleg.setRotationPoint(-6.0f, 6.0f, 2.0f);
        this.rightleg.setTextureSize(512, 512);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, -0.2617994f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase) this, 16, 78)).addBox(-2.0f, 0.0f, -2.0f, 5, 12, 5);
        this.leftleg.setRotationPoint(5.0f, 6.0f, 2.0f);
        this.leftleg.setTextureSize(512, 512);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, -0.2617994f, 0.0f, 0.0f);
        (this.rightarm2 = new ModelRenderer((ModelBase) this, 40, 160)).addBox(0.0f, 0.0f, 0.0f, 4, 8, 4);
        this.rightarm2.setRotationPoint(-10.0f, 0.0f, -7.0f);
        this.rightarm2.setTextureSize(512, 512);
        this.rightarm2.mirror = true;
        this.setRotation(this.rightarm2, -1.59868f, -0.5205006f, 0.0f);
        (this.leftarm2 = new ModelRenderer((ModelBase) this, 40, 160)).addBox(0.0f, 0.0f, 0.0f, 4, 8, 4);
        this.leftarm2.setRotationPoint(6.0f, 0.0f, -6.0f);
        this.leftarm2.setTextureSize(512, 512);
        this.leftarm2.mirror = true;
        this.setRotation(this.leftarm2, -1.59868f, 0.5948578f, 0.0f);
        (this.tail = new ModelRenderer((ModelBase) this, 80, 16)).addBox(0.0f, 0.0f, 0.0f, 6, 14, 5);
        this.tail.setRotationPoint(-3.0f, 10.0f, 4.0f);
        this.tail.setTextureSize(512, 512);
        this.tail.mirror = true;
        this.setRotation(this.tail, 0.669215f, 0.0f, 0.0f);
        (this.tailend = new ModelRenderer((ModelBase) this, 120, 16)).addBox(0.0f, 0.0f, 0.0f, 4, 14, 3);
        this.tailend.setRotationPoint(-3.0f, 21.0f, 14.0f);
        this.tailend.setTextureSize(512, 512);
        this.tailend.mirror = true;
        this.setRotation(this.tailend, 1.115358f, 0.0f, 0.0f);
        (this.rightleg2 = new ModelRenderer((ModelBase) this, 0, 120)).addBox(-0.5f, 0.0f, 4.0f, 6, 8, 6);
        this.rightleg2.setRotationPoint(-8.0f, 17.5f, -7.0f);
        this.rightleg2.setTextureSize(512, 512);
        this.rightleg2.mirror = true;
        this.setRotation(this.rightleg2, 0.0728151f, 0.0f, 0.0f);
        (this.leftleg2 = new ModelRenderer((ModelBase) this, 0, 99)).addBox(-0.5f, 0.0f, 0.0f, 6, 8, 6);
        this.leftleg2.setRotationPoint(3.0f, 17.46667f, -4.0f);
        this.leftleg2.setTextureSize(512, 512);
        this.leftleg2.mirror = true;
        this.setRotation(this.leftleg2, 0.0728081f, 0.0f, 0.0f);
        (this.shield = new ModelRenderer((ModelBase) this, 44, 16)).addBox(0.0f, 0.0f, 0.0f, 12, 12, 3);
        this.shield.setRotationPoint(-6.0f, -1.0f, 4.0f);
        this.shield.setTextureSize(512, 512);
        this.shield.mirror = true;
        this.setRotation(this.shield, 0.5205006f, 0.0f, 0.0f);
        (this.Spike5 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike5.setRotationPoint(0.0f, 0.0f, 12.0f);
        this.Spike5.setTextureSize(512, 512);
        this.Spike5.mirror = true;
        this.setRotation(this.Spike5, -1.041001f, 0.0f, 0.0f);
        (this.Spike6 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike6.setRotationPoint(4.0f, 0.0f, 12.0f);
        this.Spike6.setTextureSize(512, 512);
        this.Spike6.mirror = true;
        this.setRotation(this.Spike6, -1.041001f, 0.0f, 0.0f);
        (this.Spike4 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike4.setRotationPoint(-4.0f, 0.0f, 12.0f);
        this.Spike4.setTextureSize(512, 512);
        this.Spike4.mirror = true;
        this.setRotation(this.Spike4, -1.041001f, 0.0f, 0.0f);
        (this.Snout = new ModelRenderer((ModelBase) this, 0, 9)).addBox(0.0f, 0.0f, 0.0f, 8, 4, 1);
        this.Snout.setRotationPoint(-4.0f, -5.0f, -5.0f);
        this.Snout.setTextureSize(512, 512);
        this.Snout.mirror = true;
        this.setRotation(this.Snout, 0.0f, 0.0f, 0.0f);
        (this.Spike7 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike7.setRotationPoint(-4.0f, 3.0f, 15.0f);
        this.Spike7.setTextureSize(512, 512);
        this.Spike7.mirror = true;
        this.setRotation(this.Spike7, -1.041001f, 0.0f, 0.0f);
        (this.Spike8 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike8.setRotationPoint(0.0f, 3.0f, 15.0f);
        this.Spike8.setTextureSize(512, 512);
        this.Spike8.mirror = true;
        this.setRotation(this.Spike8, -1.041001f, 0.0f, 0.0f);
        (this.Spike9 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike9.setRotationPoint(4.0f, 3.0f, 15.0f);
        this.Spike9.setTextureSize(512, 512);
        this.Spike9.mirror = true;
        this.setRotation(this.Spike9, -1.041001f, 0.0f, 0.0f);
        (this.Spike1 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike1.setRotationPoint(-4.0f, -3.0f, 10.0f);
        this.Spike1.setTextureSize(512, 512);
        this.Spike1.mirror = true;
        this.setRotation(this.Spike1, -1.041001f, 0.0f, 0.0f);
        (this.Spike2 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike2.setRotationPoint(0.0f, -3.0f, 10.0f);
        this.Spike2.setTextureSize(512, 512);
        this.Spike2.mirror = true;
        this.setRotation(this.Spike2, -1.041001f, 0.0f, 0.0f);
        (this.Spike3 = new ModelRenderer((ModelBase) this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 1, 4, 1);
        this.Spike3.setRotationPoint(4.0f, -3.0f, 10.0f);
        this.Spike3.setTextureSize(512, 512);
        this.Spike3.mirror = true;
        this.setRotation(this.Spike3, -1.041001f, 0.0f, 0.0f);
    }

    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
        final float f4, final float f5) {
        final KingbowserInstance e = (KingbowserInstance) entity;
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        float newangle = 0.0f;
        if (f1 > 0.1) {
            newangle = MathHelper.cos(f2 * 1.1f * this.wingspeed) * 3.141593f * 0.2f * f1;
        } else {
            newangle = 0.0f;
        }
        this.rightleg.rotateAngleX = 0.59f + newangle;
        this.rightleg2.rotateAngleX = -0.15f + newangle;
        this.rightleg2.rotationPointZ = (float) (Math.sin(this.rightleg.rotateAngleX) * 8.0);
        this.leftleg.rotateAngleX = 0.26f - newangle;
        this.leftleg2.rotateAngleX = -0.44f - newangle;
        this.leftleg2.rotationPointZ = (float) (Math.sin(this.leftleg.rotateAngleX) * 8.0);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glTranslatef(0.0f, -1.0f, 0.0f);
        this.head.render(f5);
        this.body.render(f5);
        this.rightarm.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.leftleg.render(f5);
        this.rightarm2.render(f5);
        this.leftarm2.render(f5);
        this.tail.render(f5);
        this.tailend.render(f5);
        this.rightleg2.render(f5);
        this.leftleg2.render(f5);
        this.shield.render(f5);
        this.Spike5.render(f5);
        this.Spike6.render(f5);
        this.Spike4.render(f5);
        this.Snout.render(f5);
        this.Spike7.render(f5);
        this.Spike8.render(f5);
        this.Spike9.render(f5);
        this.Spike1.render(f5);
        this.Spike2.render(f5);
        this.Spike3.render(f5);
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
