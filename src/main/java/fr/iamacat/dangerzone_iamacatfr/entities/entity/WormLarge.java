
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class WormLarge extends EntityMob {

    private int wormsSpawned;

    public WormLarge(final World par1World) {
        super(par1World);
        this.wormsSpawned = 0;
        this.setSize(1.55f, 2.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 2050;
        this.noClip = true;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(2, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.20000000298023224);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.WormLarge_stats.attack);
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
        return 1.0f;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":big_splat";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":alo_death";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    protected void collideWithNearbyEntities() {}

    public int mygetMaxHealth() {
        return OreSpawnMain.WormLarge_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.WormLarge_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
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

    public void onLivingUpdate() {
        EntityPlayer target = null;
        WormMedium worms = null;
        EntityCreature newent = null;
        super.onLivingUpdate();
        worms = (WormMedium) this.worldObj
            .findNearestEntityWithinAABB(WormMedium.class, this.boundingBox.expand(8.0, 8.0, 8.0), this);
        if (worms == null) {
            target = (EntityPlayer) this.worldObj
                .findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0, 8.0, 8.0), this);
        }
        if ((worms == null && target != null) || OreSpawnMain.PlayNicely != 0) {
            if (target != null) {
                this.pointAtEntity(target);
            }
            Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY, (int) this.posZ);
            if (bid == Blocks.tallgrass) {
                bid = Blocks.air;
            }
            if (bid != Blocks.air) {
                this.motionY += 0.25;
                this.posY += 0.10000000149011612;
            } else {
                this.noClip = false;
            }
        } else {
            this.noClip = true;
            Block bid = this.worldObj.getBlock((int) this.posX, (int) (this.posY + 3.5), (int) this.posZ);
            if (bid == Blocks.tallgrass) {
                bid = Blocks.air;
            }
            if (bid != Blocks.air) {
                this.motionY += 0.10000000149011612;
                this.posY += 0.05000000074505806;
                if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.stone) {
                    this.setDead();
                }
            }
        }
        if (this.noClip) {
            this.motionY -= 0.01;
            this.motionX = 0.0;
            this.motionZ = 0.0;
            this.moveForward = 0.0f;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        if (this.wormsSpawned != 0) {
            return;
        }
        this.wormsSpawned = 1;
        for (int i = 0; i < 20; ++i) {
            newent = (EntityCreature) spawnCreature(
                this.worldObj,
                "Small Worm",
                this.posX + this.worldObj.rand.nextInt(6) - this.worldObj.rand.nextInt(6),
                this.posY,
                this.posZ + this.worldObj.rand.nextInt(6) - this.worldObj.rand.nextInt(6));
            newent = (EntityCreature) spawnCreature(
                this.worldObj,
                "Medium Worm",
                this.posX + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5),
                this.posY,
                this.posZ + this.worldObj.rand.nextInt(5) - this.worldObj.rand.nextInt(5));
        }
    }

    public void onUpdate() {
        if (this.isNoDespawnRequired()) {
            this.noClip = false;
        }
        super.onUpdate();
        this.motionY *= 0.85;
    }

    protected void updateAITasks() {
        int bid = 0;
        EntityPlayer target = null;
        WormMedium worms = null;
        if (this.isDead) {
            return;
        }
        if (!this.noClip) {
            super.updateAITasks();
        }
        if (OreSpawnMain.PlayNicely != 0) {
            return;
        }
        worms = (WormMedium) this.worldObj
            .findNearestEntityWithinAABB(WormMedium.class, this.boundingBox.expand(8.0, 8.0, 8.0), this);
        if (worms != null) {
            return;
        }
        target = (EntityPlayer) this.worldObj
            .findNearestEntityWithinAABB(EntityPlayer.class, this.boundingBox.expand(8.0, 6.0, 8.0), this);
        if (target != null && target.capabilities.isCreativeMode) {
            target = null;
        }
        if (target != null) {
            this.pointAtEntity(target);
            this.getNavigator()
                .tryMoveToXYZ(target.posX, target.posY, target.posZ, 1.0);
            if (this.worldObj.rand.nextInt(10) == 1 && this.getDistanceToEntity(target) < 3.0) {
                super.attackEntityAsMob(target);
                if (this.worldObj.rand.nextInt(4) == 1) {
                    ItemStack boots = target.getEquipmentInSlot(4);
                    if (boots != null) {
                        target.setCurrentItemOrArmor(4, null);
                        bid = boots.getMaxDamage() - boots.getItemDamage();
                        if (bid > 10) {
                            bid /= 10;
                        } else {
                            bid = 1;
                        }
                        boots.damageItem(bid, this);
                        final EntityItem var3 = new EntityItem(
                            this.worldObj,
                            this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5),
                            this.posY + 3.0,
                            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5),
                            boots);
                        this.worldObj.spawnEntityInWorld(var3);
                    } else {
                        boots = target.getEquipmentInSlot(3);
                        if (boots != null) {
                            target.setCurrentItemOrArmor(3, null);
                            bid = boots.getMaxDamage() - boots.getItemDamage();
                            if (bid > 10) {
                                bid /= 10;
                            } else {
                                bid = 1;
                            }
                            boots.damageItem(bid, this);
                            final EntityItem var3 = new EntityItem(
                                this.worldObj,
                                this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5),
                                this.posY + 3.0,
                                this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5),
                                boots);
                            this.worldObj.spawnEntityInWorld(var3);
                        }
                    }
                }
                if (this.worldObj.rand.nextInt(4) == 1) {
                    final ItemStack boots = target.getEquipmentInSlot(0);
                    if (boots != null) {
                        target.setCurrentItemOrArmor(0, null);
                        bid = boots.getMaxDamage() - boots.getItemDamage();
                        if (bid > 10) {
                            bid /= 10;
                        } else {
                            bid = 1;
                        }
                        boots.damageItem(bid, this);
                        final EntityItem var3 = new EntityItem(
                            this.worldObj,
                            this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5),
                            this.posY + 3.0,
                            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) - OreSpawnMain.OreSpawnRand.nextInt(5),
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

    protected void fall(final float par1) {
        if (!this.noClip) {
            super.fall(par1);
        }
    }

    protected void updateFallState(final double par1, final boolean par3) {
        if (!this.noClip) {
            super.updateFallState(par1, par3);
        }
    }

    public boolean doesEntityNotTriggerPressurePlate() {
        return true;
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Large Worm")) {
                            this.wormsSpawned = 1;
                            return true;
                        }
                    }
                }
            }
        }
        if (this.posY < 50.0) {
            return false;
        }
        WormLarge target = null;
        target = (WormLarge) this.worldObj
            .findNearestEntityWithinAABB(WormLarge.class, this.boundingBox.expand(32.0, 8.0, 32.0), this);
        if (target != null) {
            return false;
        }
        for (int i = -6; i <= 6; ++i) {
            for (int j = -6; j <= 6; ++j) {
                for (int k = -2; k >= -8; --k) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + i, (int) this.posY + k, (int) this.posZ + j);
                    if (bid == Blocks.air) {
                        return false;
                    }
                }
            }
        }
        for (int i = -6; i <= 6; ++i) {
            for (int j = -6; j <= 6; ++j) {
                for (int k = 2; k <= 8; ++k) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + i, (int) this.posY + k, (int) this.posZ + j);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        return true;
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

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("wormsSpawned", this.wormsSpawned);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.wormsSpawned = par1NBTTagCompound.getInteger("wormsSpawned");
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
        }
        return var8;
    }

    protected Item getDropItem() {
        return Items.rotten_flesh;
    }

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            this.posY + 2.5 + this.worldObj.rand.nextInt(4),
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(OreSpawnMain.WormTooth, 1);
        this.dropItemRand(Items.item_frame, 1);
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.rotten_flesh, 1);
        }
        for (int var4 = 0; var4 < 6; ++var4) {
            this.dropItemRand(Items.leather, 1);
        }
        for (int var4 = 0; var4 < 8; ++var4) {
            this.dropItemRand(Item.getItemFromBlock(Blocks.dirt), 1);
        }
        for (int var4 = 0; var4 < 16; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (int var4 = 0; var4 < 5; ++var4) {
            this.dropItemRand(Items.diamond, 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(OreSpawnMain.UraniumNugget, 1);
        }
        for (int var4 = 0; var4 < 4; ++var4) {
            this.dropItemRand(OreSpawnMain.TitaniumNugget, 1);
        }
    }
}
