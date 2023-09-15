package fr.iamacat.dangerzone_iamacatfr.entities.model.unfinished;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.TinyBirdsInstance;

@SideOnly(Side.CLIENT)
public class TinyBirdsModel extends ModelBase {

    // fields
    ModelRenderer beak;
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer tail;

    public TinyBirdsModel() {
        textureWidth = 32;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-1.5F, -1.5F, -1.5F, 3, 3, 3);
        head.setRotationPoint(0F, 20.5F, -0.5F);
        head.setTextureSize(32, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);

        beak = new ModelRenderer(this, 12, 0);
        beak.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1);
        beak.setRotationPoint(0F, 0.5F, -2F);

        head.addChild(beak);

        body = new ModelRenderer(this, 0, 6);
        body.addBox(-1.5F, 0F, -1F, 3, 3, 3);
        body.setRotationPoint(0F, 20F, 0F);
        body.setTextureSize(32, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 12, 2);
        rightarm.addBox(-1F, 0F, -1.5F, 1, 2, 3);
        rightarm.setRotationPoint(-1.5F, 20.5F, 1F);
        rightarm.setTextureSize(32, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 12, 2);
        leftarm.addBox(0F, 0F, -1.5F, 1, 2, 3);
        leftarm.setRotationPoint(1.5F, 20.5F, 1F);
        leftarm.setTextureSize(32, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 12);
        rightleg.addBox(0F, 0F, 0F, 1, 1, 1);
        rightleg.setRotationPoint(-1.5F, 23F, 0F);
        rightleg.setTextureSize(32, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 12);
        leftleg.addBox(0.5F, 0F, 0F, 1, 1, 1);
        leftleg.setRotationPoint(0F, 23F, 0F);
        leftleg.setTextureSize(32, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        tail = new ModelRenderer(this, 0, 14);
        tail.addBox(-1.5F, -0.5F, 0F, 3, 1, 2);
        tail.setRotationPoint(0F, 22F, 2F);
        tail.setTextureSize(32, 32);
        tail.mirror = true;
        setRotation(tail, 0F, 0F, 0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7) {
        setRotationAngles(par2, par3, par4, par5, par6, par7, par1Entity);

        if (isChild) {
            float f = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5F * par7, 0.75F * par7);
            head.render(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f, 1.0F / f, 1.0F / f);
            GL11.glTranslatef(0.0F, 24F * par7, 0.0F);
            body.render(par7);
            rightleg.render(par7);
            leftleg.render(par7);
            rightarm.render(par7);
            leftarm.render(par7);
            GL11.glPopMatrix();
        } else {
            head.render(par7);
            body.render(par7);
            rightleg.render(par7);
            leftleg.render(par7);
            rightarm.render(par7);
            leftarm.render(par7);
            tail.render(par7);
            // beak.render(par7);
        }
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6,
        Entity par7Entity) {
        head.rotateAngleX = par5 / (180F / (float) Math.PI);
        head.rotateAngleY = par4 / (180F / (float) Math.PI);

        rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.4F * par2;
        leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float) Math.PI) * 1.4F * par2;

        rightarm.rotateAngleZ = par3;
        leftarm.rotateAngleZ = -par3;

        if (((TinyBirdsInstance) par7Entity).isBirdLanded()) {
            rightleg.rotationPointY = 23;
            leftleg.rotationPointY = 23;
        } else {
            rightleg.rotationPointY = 22.5F;
            leftleg.rotationPointY = 22.5F;
        }

    }
}
