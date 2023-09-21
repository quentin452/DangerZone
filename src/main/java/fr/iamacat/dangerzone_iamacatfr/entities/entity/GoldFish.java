
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class GoldFish extends EntityAnimal {

    private ChunkCoordinates currentFlightTarget;

    public GoldFish(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.setSize(0.75f, 0.5f);
        this.experienceValue = 5;
        this.isImmuneToFire = false;
        this.fireResistance = 5;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.2199999988079071);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1.0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired() && !this.worldObj.isDaytime();
    }

    protected float getSoundVolume() {
        return 0.45f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return "splash";
    }

    protected String getHurtSound() {
        return "splash";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":little_splat";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 6;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        int updown = 0;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if ((int) this.posY < 120) {
            updown = 2;
        }
        if ((int) this.posY > 140) {
            updown = -2;
        }
        if (this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying != 0; --keep_trying) {
                zdir = this.rand.nextInt(5) + 5;
                xdir = this.rand.nextInt(5) + 5;
                if (this.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.set(
                    (int) this.posX + xdir,
                    (int) this.posY + this.rand.nextInt(11) - 5 + updown,
                    (int) this.posZ + zdir);
                bid = this.worldObj.getBlock(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ);
                if (bid == Blocks.air && !this.canSeeTarget(
                    this.currentFlightTarget.posX,
                    this.currentFlightTarget.posY,
                    this.currentFlightTarget.posZ)) {
                    bid = Blocks.stone;
                }
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.4 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.4 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.4 - this.motionX) * 0.3;
        this.motionY += (Math.signum(var2) * 0.7 - this.motionY) * 0.2;
        this.motionZ += (Math.signum(var3) * 0.4 - this.motionZ) * 0.3;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.75f;
        this.rotationYaw += var5 / 6.0f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        return true;
    }

    protected Item getDropItem() {
        final int i = this.worldObj.rand.nextInt(3);
        if (i == 0) {
            return Item.getItemFromBlock(Blocks.gold_block);
        }
        if (i == 1) {
            return OreSpawnMain.UraniumNugget;
        }
        if (i == 2) {
            return OreSpawnMain.TitaniumNugget;
        }
        return null;
    }

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }
}
