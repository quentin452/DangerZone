
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class WormSmall extends EntityMob {

    public int upcount;
    public int downcount;

    public WormSmall(final World par1World) {
        super(par1World);
        this.upcount = 50;
        this.downcount = 0;
        this.setSize(0.25f, 1.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 0;
        this.noClip = true;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.10000000149011612);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(3);
    }

    protected void entityInit() {
        super.entityInit();
    }

    protected boolean canDespawn() {
        return false;
    }

    protected float getSoundVolume() {
        return 0.5f;
    }

    protected float getSoundPitch() {
        return 1.5f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":little_splat";
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
        return 10;
    }

    public int getTotalArmorValue() {
        return 0;
    }

    protected boolean isAIEnabled() {
        return true;
    }


    public void onLivingUpdate() {
        EntityPlayer target;
        super.onLivingUpdate();
        target = (EntityPlayer) this.worldObj
            .findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0, 8.0, 8.0), this);
        if (target != null) {
            if (this.upcount > 0) {
                --this.upcount;
                if (this.upcount == 0) {
                    this.downcount = 100 + this.worldObj.rand.nextInt(150);
                }
                if (target != null) {
                    this.pointAtEntity(target);
                }
                Block bid = this.worldObj.getBlock((int) this.posX, (int) (this.posY + 0.25), (int) this.posZ);
                if (bid == Blocks.tallgrass) {
                    bid = Blocks.air;
                }
                if (bid != Blocks.air) {
                    if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                        this.setDead();
                    }
                    this.motionY += 0.15000000596046448;
                    this.posY += 0.10000000149011612;
                }
            } else {
                if (this.downcount > 0) {
                    --this.downcount;
                } else {
                    this.upcount = 25 + this.worldObj.rand.nextInt(50);
                }
                Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY + 2, (int) this.posZ);
                if (bid == Blocks.tallgrass) {
                    bid = Blocks.air;
                }
                if (bid != Blocks.air) {
                    if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                        this.setDead();
                    }
                    this.motionY += 0.20000000298023224;
                    this.posY += 0.05000000074505806;
                }
            }
        } else {
            this.upcount = this.worldObj.rand.nextInt(50);
            this.downcount = 0;
            Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY + 2, (int) this.posZ);
            if (bid == Blocks.tallgrass) {
                bid = Blocks.air;
            }
            if (bid != Blocks.air) {
                if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                    this.setDead();
                }
                this.motionY += 0.10000000149011612;
                this.posY += 0.05000000074505806;
            }
        }
        this.motionY -= 0.01;
        this.motionX = 0.0;
        this.motionZ = 0.0;
        this.moveForward = 0.0f;
    }

    public void onUpdate() {
        if (this.isNoDespawnRequired()) {
            this.noClip = false;
        }
        super.onUpdate();
        this.motionY *= 0.75;
    }

    public void pointAtEntity(final EntityLivingBase e) {
        final double d1 = e.posX - this.posX;
        final double d2 = e.posZ - this.posZ;
        final float d3 = (float) Math.atan2(d2, d1);
        final float n;
        final float f2 = n = (float) (d3 * 180.0 / 3.141592653589793) - 90.0f;
        this.rotationYawHead = n;
        this.rotationYaw = n;
    }

    protected void updateAITasks() {
        int bid = 0;
        EntityPlayer target = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        target = (EntityPlayer) this.worldObj
            .findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(1.5, 4.0, 1.5), this);
        if (target != null && target.capabilities.isCreativeMode) {
            target = null;
        }
        if (target != null) {
            this.pointAtEntity(target);
            if (this.upcount > 0 && this.worldObj.rand.nextInt(15) == 1 && !target.capabilities.isCreativeMode) {
                super.attackEntityAsMob(target);
                if (this.worldObj.rand.nextInt(6) == 1) {
                    final ItemStack boots = target.getEquipmentInSlot(1);
                    if (boots != null) {
                        target.setCurrentItemOrArmor(1, null);
                        bid = boots.getMaxDamage() - boots.getItemDamage();
                        if (bid > 20) {
                            bid /= 20;
                        } else {
                            bid = 1;
                        }
                        boots.damageItem(bid, this);
                        final EntityItem var3 = new EntityItem(
                            this.worldObj,
                            this.posX + rand.nextInt(5) - rand.nextInt(5),
                            this.posY + 3.0,
                            this.posZ + rand.nextInt(5) - rand.nextInt(5),
                            boots);
                        this.worldObj.spawnEntityInWorld(var3);
                    }
                }
            }
        }
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

    protected Item getDropItem() {
        return null;
    }
}
