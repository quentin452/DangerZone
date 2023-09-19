package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class WhaleRenderer {

    public static int mobid;
    public Object instance;

    public void load() {}

    public void generateNether(final World world, final Random random, final int chunkX, final int chunkZ) {}

    public void generateSurface(final World world, final Random random, final int chunkX, final int chunkZ) {}

    public int addFuel(final ItemStack fuel) {
        return 0;
    }

    public void serverLoad(final FMLServerStartingEvent event) {}

    static {
        WhaleRenderer.mobid = 0;
    }

    public static class WhaleInstance extends EntitySquid {

        World world;

        public WhaleInstance(final World var1) {
            super(var1);
            this.world = null;
            this.world = var1;
            this.experienceValue = 5;
            this.isImmuneToFire = false;
            this.addRandomArmor();
        }

        protected void addRandomArmor() {}

        protected void dropRareDrop(final int par1) {
            this.dropItem(Items.cooked_fished, 1);
        }

        public boolean isAIEnabled() {
            return false;
        }

        protected void dropFewItems(final boolean var1, final int var2) {
            // this.entityDropItem(new ItemStack(mcreator_rawWhaleMeat.block), 0.0f);
        }

        protected String getLivingSound() {
            return null;
        }

        protected String getHurtSound() {
            return null;
        }

        protected String getDeathSound() {
            return null;
        }

        public void onStruckByLightning(final EntityLightningBolt entityLightningBolt) {
            final int i = (int) this.posX;
            final int j = (int) this.posY;
            final int k = (int) this.posZ;
            final Entity entity = this;
        }

        protected void fall(final float l) {
            final int i = (int) this.posX;
            final int j = (int) this.posY;
            final int k = (int) this.posZ;
            super.fall(l);
            final Entity entity = (Entity) this;
        }

        public void onCriticalHit(final Entity entity) {
            final int i = (int) this.posX;
            final int j = (int) this.posY;
            final int k = (int) this.posZ;
        }

        public void onKillEntity(final EntityLiving entityLiving) {
            final int i = (int) this.posX;
            final int j = (int) this.posY;
            final int k = (int) this.posZ;
            final Entity entity = this;
        }

        public boolean interact(final EntityPlayer entity) {
            final int i = (int) this.posX;
            final int j = (int) this.posY;
            final int k = (int) this.posZ;
            return true;
        }

        public String getEntityName() {
            return "whale";
        }
    }

    public static class ModelWhale extends ModelBase {

        ModelRenderer Shape1;
        ModelRenderer Shape2;
        ModelRenderer Shape3;
        ModelRenderer Shape4;
        ModelRenderer Shape5;
        ModelRenderer Shape6;
        ModelRenderer Shape7;
        ModelRenderer Shape8;
        ModelRenderer Shape9;
        ModelRenderer Shape10;

        public ModelWhale() {
            this.textureWidth = 256;
            this.textureHeight = 64;
            (this.Shape1 = new ModelRenderer(this, 132, 41)).addBox(0.0f, 0.0f, 0.0f, 11, 11, 12);
            this.Shape1.setRotationPoint(-5.5f, 11.0f, -18.0f);
            this.Shape1.setTextureSize(256, 64);
            this.Shape1.mirror = true;
            this.setRotation(this.Shape1, 0.0f, 0.0f, 0.0f);
            (this.Shape2 = new ModelRenderer(this, 52, 25)).addBox(0.0f, 0.0f, 0.0f, 14, 14, 25);
            this.Shape2.setRotationPoint(-7.0f, 10.0f, -8.0f);
            this.Shape2.setTextureSize(256, 64);
            this.Shape2.mirror = true;
            this.setRotation(this.Shape2, 0.0f, 0.0f, 0.0f);
            (this.Shape3 = new ModelRenderer(this, 83, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 1, 6);
            this.Shape3.setRotationPoint(6.0f, 20.0f, -3.0f);
            this.Shape3.setTextureSize(256, 64);
            this.Shape3.mirror = true;
            this.setRotation(this.Shape3, 0.0f, 0.0f, 0.2974289f);
            (this.Shape4 = new ModelRenderer(this, 49, 0)).addBox(0.0f, 0.0f, 0.0f, 9, 1, 6);
            this.Shape4.setRotationPoint(-6.0f, 21.0f, 0.0f);
            this.Shape4.setTextureSize(256, 64);
            this.Shape4.mirror = true;
            this.setRotation(this.Shape4, 0.0f, 0.0f, 2.844164f);
            (this.Shape5 = new ModelRenderer(this, 0, 40)).addBox(0.0f, 0.0f, 0.0f, 12, 11, 13);
            this.Shape5.setRotationPoint(-6.0f, 11.0f, 16.33333f);
            this.Shape5.setTextureSize(256, 64);
            this.Shape5.mirror = true;
            this.setRotation(this.Shape5, 0.0f, 0.0f, 0.0f);
            (this.Shape6 = new ModelRenderer(this, 0, 20)).addBox(0.0f, 0.0f, 0.0f, 10, 9, 9);
            this.Shape6.setRotationPoint(-5.0f, 12.0f, 28.4f);
            this.Shape6.setTextureSize(256, 64);
            this.Shape6.mirror = true;
            this.setRotation(this.Shape6, 0.0f, 0.0f, 0.0f);
            (this.Shape7 = new ModelRenderer(this, 134, 27)).addBox(0.0f, 0.0f, 0.0f, 7, 7, 6);
            this.Shape7.setRotationPoint(-3.0f, 13.0f, 37.0f);
            this.Shape7.setTextureSize(256, 64);
            this.Shape7.mirror = true;
            this.setRotation(this.Shape7, 0.0f, 0.0f, 0.0f);
            (this.Shape8 = new ModelRenderer(this, 0, 0)).addBox(0.0f, 0.0f, 0.0f, 5, 5, 6);
            this.Shape8.setRotationPoint(-2.0f, 14.0f, 40.73333f);
            this.Shape8.setTextureSize(256, 64);
            this.Shape8.mirror = true;
            this.setRotation(this.Shape8, 0.0f, 0.0f, 0.0f);
            (this.Shape9 = new ModelRenderer(this, 81, 17)).addBox(0.0f, 0.0f, 0.0f, 9, 1, 5);
            this.Shape9.setRotationPoint(2.0f, 17.0f, 44.0f);
            this.Shape9.setTextureSize(256, 64);
            this.Shape9.mirror = true;
            this.setRotation(this.Shape9, 0.0f, -0.7807508f, 0.0f);
            (this.Shape10 = new ModelRenderer(this, 49, 17)).addBox(0.0f, 0.0f, 0.0f, 10, 1, 5);
            this.Shape10.setRotationPoint(3.0f, 16.93333f, 46.53333f);
            this.Shape10.setTextureSize(256, 64);
            this.Shape10.mirror = true;
            this.setRotation(this.Shape10, 0.0f, -2.302802f, 0.0f);
        }

        public void render(final Entity entity, final float f, final float f1, final float f2, final float f3,
            final float f4, final float f5) {
            super.render(entity, f, f1, f2, f3, f4, f5);
            this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
            this.Shape1.render(f5);
            this.Shape2.render(f5);
            this.Shape3.render(f5);
            this.Shape4.render(f5);
            this.Shape5.render(f5);
            this.Shape6.render(f5);
            this.Shape7.render(f5);
            this.Shape8.render(f5);
            this.Shape9.render(f5);
            this.Shape10.render(f5);
        }

        private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
            model.rotateAngleX = x;
            model.rotateAngleY = y;
            model.rotateAngleZ = z;
        }

        public void setRotationAngles(final float f, final float f1, final float f2, final float f3, final float f4,
            final float f5, final Entity e) {
            super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        }
    }
}
