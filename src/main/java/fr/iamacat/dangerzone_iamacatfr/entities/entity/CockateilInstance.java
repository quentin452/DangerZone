
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class CockateilInstance extends EntityAnimal {

    private ChunkCoordinates currentFlightTarget;
    public int birdtype;
    private boolean killedByPlayer;
    private static final ResourceLocation texture1;
    private static final ResourceLocation texture2;
    private static final ResourceLocation texture3;
    private static final ResourceLocation texture4;
    private static final ResourceLocation texture5;
    private static final ResourceLocation texture6;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private int flyup;

    public CockateilInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.killedByPlayer = false;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.flyup = 0;
        this.setSize(0.5f, 0.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 2;
        this.isImmuneToFire = false;
        this.fireResistance = 2;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.33000001311302185);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1.0);
    }

    public ResourceLocation getTexture() {
        switch (this.birdtype = this.getBirdType()) {
            case 0: {
                return CockateilInstance.texture1;
            }
            case 1: {
                return CockateilInstance.texture2;
            }
            case 2: {
                return CockateilInstance.texture3;
            }
            case 3: {
                return CockateilInstance.texture4;
            }
            case 4: {
                return CockateilInstance.texture5;
            }
            case 5: {
                return CockateilInstance.texture6;
            }
            default: {
                return null;
            }
        }
    }

    protected void entityInit() {
        super.entityInit();
        this.birdtype = this.rand.nextInt(6);
        this.dataWatcher.addObject(22, (Object) this.birdtype);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public int getBirdType() {
        return this.dataWatcher.getWatchableObjectInt(22);
    }

    public void setBirdType(final int par1) {
        this.dataWatcher.updateObject(22, (Object) par1);
    }

    protected float getSoundVolume() {
        return 0.55f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        if (this.worldObj.isDaytime() && !this.worldObj.isRaining()) {
            return Tags.MODID + ":birds";
        }
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":duck_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":duck_hurt";
    }

    public boolean canBePushed() {
        return true;
    }

    public int mygetMaxHealth() {
        return 2;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityPlayer) {
            this.killedByPlayer = true;
        }
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        } else if (this.posY < this.currentFlightTarget.posY) {
            this.motionY *= 0.7;
        } else {
            this.motionY *= 0.5;
        }
    }

    public int getAttackStrength(final Entity par1Entity) {
        return 1;
    }

    public void setFlyUp() {
        this.flyup = 2;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 35;
        int stayup = 0;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.provider.dimensionId == DimensionInitDangerZone.CrystalDimensionId) {
            stayup = 2;
        }
        if (this.lastX == (int) this.posX && this.lastZ == (int) this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int) this.posX;
            this.lastZ = (int) this.posZ;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.stuck_count > 40 || this.rand.nextInt(250) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 4.1f) {
            Block bid = Blocks.stone;
            this.stuck_count = 0;
            while (bid != Blocks.air && keep_trying != 0) {
                zdir = this.rand.nextInt(8) + 5 - this.flyup * 2;
                xdir = this.rand.nextInt(8) + 5 - this.flyup * 2;
                if (this.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget.set(
                    (int) this.posX + xdir,
                    (int) this.posY + this.rand.nextInt(9 + stayup) - 5 + this.flyup,
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
                --keep_trying;
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.3 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.3 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.3 - this.motionX) * 0.25;
        this.motionY += (Math.signum(var2) * 0.699999 - this.motionY) * 0.200000001;
        this.motionZ += (Math.signum(var3) * 0.3 - this.motionZ) * 0.25;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.8f;
        this.rotationYaw += var5 / 3.0f;
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean getCanSpawnHere() {
        return this.worldObj.isDaytime()
            && (this.worldObj.provider.dimensionId == DimensionInitDangerZone.CrystalDimensionId || this.posY >= 50.0);
    }

    protected Item getDropItem() {
        this.birdtype = this.getBirdType();
        if (this.birdtype == 5 && this.killedByPlayer && this.worldObj.rand.nextInt(3) == 1) {
            return ItemInitDangerZone.RubyIngot;
        }
        return Items.feather;
    }

    public void initCreature() {}

    public EntityAgeable createChild(final EntityAgeable var1) {
        return null;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("BirdType", this.getBirdType());
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setBirdType(this.birdtype = par1NBTTagCompound.getInteger("BirdType"));
    }

    static {
        texture1 = new ResourceLocation(Tags.MODID + ":Bird1.png");
        texture2 = new ResourceLocation(Tags.MODID + ":Bird2.png");
        texture3 = new ResourceLocation(Tags.MODID + ":Bird3.png");
        texture4 = new ResourceLocation(Tags.MODID + ":Bird4.png");
        texture5 = new ResourceLocation(Tags.MODID + ":Bird5.png");
        texture6 = new ResourceLocation(Tags.MODID + ":Bird6.png");
    }
}
