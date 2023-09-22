
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;

public class Firefly extends EntityAmbientCreature {

    private static final ResourceLocation texture1;
    int my_blink;
    int blinker;
    int myspace;
    private ChunkCoordinates currentFlightTarget;

    public Firefly(final World par1World) {
        super(par1World);
        this.my_blink = 0;
        this.blinker = 0;
        this.myspace = 0;
        this.currentFlightTarget = null;
        this.my_blink = 20 + this.rand.nextInt(20);
        this.setSize(0.4f, 0.8f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.renderDistanceWeight = 3.0;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.10000000149011612);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(0.0);
    }

    public ResourceLocation getTexture(final Firefly a) {
        return Firefly.texture1;
    }

    protected void entityInit() {
        super.entityInit();
    }

    public float getBlink() {
        if (this.blinker < this.my_blink / 2) {
            return 240.0f;
        }
        return 0.0f;
    }

    protected float getSoundVolume() {
        return 0.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
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

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    protected void collideWithNearbyEntities() {}

    public int mygetMaxHealth() {
        return 1;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock(OreSpawnMain.ExtremeTorch);
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.600000023841;
        ++this.blinker;
        if (this.blinker > this.my_blink) {
            this.blinker = 0;
        }
        if (this.isNoDespawnRequired()) {
            return;
        }
        long t = this.worldObj.getWorldTime();
        t %= 24000L;
        if (t > 11000L) {
            return;
        }
        if (this.worldObj.rand.nextInt(500) == 1) {
            this.setDead();
        }
    }

    protected void updateAITasks() {
        int keep_trying = 25;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.rand.nextInt(40) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.0f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; bid = this.worldObj.getBlock(
                this.currentFlightTarget.posX,
                this.currentFlightTarget.posY,
                this.currentFlightTarget.posZ), --keep_trying) {
                this.currentFlightTarget.set(
                    (int) this.posX + this.rand.nextInt(4) - this.rand.nextInt(4),
                    (int) this.posY + this.rand.nextInt(4) - 2,
                    (int) this.posZ + this.rand.nextInt(4) - this.rand.nextInt(4));
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.2 - this.motionX) * 0.1;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.1;
        this.motionZ += (Math.signum(var3) * 0.2 - this.motionZ) * 0.1;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.2f;
        this.rotationYaw += var5 / 4.0f;
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean getCanSpawnHere() {
        final Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ);
        return bid == Blocks.air && !this.worldObj.isDaytime()
            && this.findBuddies() <= 10
            && (this.worldObj.provider.dimensionId == DimensionInitDangerZone.DimensionID4 || this.posY >= 50.0);
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Firefly.class, this.boundingBox.expand(20.0, 8.0, 20.0));
        return var5.size();
    }

    public void initCreature() {}

    protected boolean canDespawn() {
        return this.worldObj.isDaytime() && !this.isNoDespawnRequired();
    }

    static {
        texture1 = new ResourceLocation(Tags.MODID+":Fireflytexture.png");
    }
}
