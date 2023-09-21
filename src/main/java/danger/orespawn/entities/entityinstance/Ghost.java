
package danger.orespawn.entities.entityinstance;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class Ghost extends EntityAmbientCreature {

    private ChunkCoordinates currentFlightTarget;

    public Ghost(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.setSize(0.5f, 1.5f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 5;
        this.noClip = true;
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

    protected void entityInit() {
        super.entityInit();
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    protected float getSoundVolume() {
        return 0.3f;
    }

    protected float getSoundPitch() {
        return 1.5f;
    }

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(2) == 0) {
            return "orespawn:ghost_sound";
        }
        return null;
    }

    protected String getHurtSound() {
        return null;
    }

    protected String getDeathSound() {
        return null;
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    protected void collideWithNearbyEntities() {}

    public int mygetMaxHealth() {
        return 2;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        if (this.isNoDespawnRequired()) {
            this.noClip = false;
        }
        super.onUpdate();
        this.motionY *= 0.65;
    }

    protected void updateAITasks() {
        int i = 0;
        int j = 0;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.worldObj.rand.nextInt(40) == 1
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.0f) {
            EntityPlayer target = null;
            target = (EntityPlayer) this.worldObj
                .findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(16.0, 16.0, 16.0), this);
            if (target != null) {
                this.currentFlightTarget.set(
                    (int) target.posX + this.rand.nextInt(3) - this.rand.nextInt(3),
                    (int) target.posY + 1,
                    (int) target.posZ + this.rand.nextInt(3) - this.rand.nextInt(3));
            } else {
                for (i = 0; i < 3; ++i) {
                    final Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY + i, (int) this.posZ);
                    if (bid == Blocks.air) {
                        break;
                    }
                }
                for (j = -1; j >= -3; --j) {
                    final Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY + j, (int) this.posZ);
                    if (bid != Blocks.air) {
                        break;
                    }
                }
                this.currentFlightTarget.set(
                    (int) this.posX + this.rand.nextInt(10) - this.rand.nextInt(10),
                    (int) this.posY + i + j + this.rand.nextInt(4) + 1,
                    (int) this.posZ + this.rand.nextInt(10) - this.rand.nextInt(10));
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.1 - this.motionX) * 0.05;
        this.motionY += (Math.signum(var2) * 0.7 - this.motionY) * 0.1;
        this.motionZ += (Math.signum(var3) * 0.1 - this.motionZ) * 0.05;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.05f;
        this.rotationYaw += var5 / 6.0f;
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
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Ghost")) {
                            return true;
                        }
                    }
                }
            }
        }
        return !this.worldObj.isDaytime();
    }

    public void initCreature() {}

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return ret;
        }
        ret = super.attackEntityFrom(par1DamageSource, par2);
        return ret;
    }
}
