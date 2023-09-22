
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Robot2 extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int just_for_fun;
    private float moveSpeed;

    public Robot2(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.just_for_fun = 0;
        this.moveSpeed = 0.3f;
        this.setSize(3.0f, 6.2f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 100;
        this.fireResistance = 200;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorter(this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new MyEntityAIWanderALot(this, 14, 1.0));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 0.8999999761581421, false));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.Robot2_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        if (this.renderdata == null) {
            this.renderdata = new RenderInfo();
        }
        this.renderdata.rf1 = 0.0f;
        this.renderdata.rf2 = 0.0f;
        this.renderdata.rf3 = 0.0f;
        this.renderdata.rf4 = 0.0f;
        this.renderdata.ri1 = 0;
        this.renderdata.ri2 = 0;
        this.renderdata.ri3 = 0;
        this.renderdata.ri4 = 0;
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Robot2_stats.health;
    }

    public RenderInfo getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(final RenderInfo r) {
        this.renderdata.rf1 = r.rf1;
        this.renderdata.rf2 = r.rf2;
        this.renderdata.rf3 = r.rf3;
        this.renderdata.rf4 = r.rf4;
        this.renderdata.ri1 = r.ri1;
        this.renderdata.ri2 = r.ri2;
        this.renderdata.ri3 = r.ri3;
        this.renderdata.ri4 = r.ri4;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.Robot2_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void jump() {
        this.motionY += 0.25;
        super.jump();
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return Tags.MODID + ":robot_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":robot_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":robot_death";
    }

    protected float getSoundVolume() {
        return 1.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock(Blocks.iron_block);
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        ItemStack is = null;
        for (int var5 = 2 + this.worldObj.rand.nextInt(8), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
        }
        for (int var5 = 5 + this.worldObj.rand.nextInt(6), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.iron_ingot, 1);
        }
        for (int i = 5 + this.worldObj.rand.nextInt(10), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.worldObj.rand.nextInt(15);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(Items.redstone, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.repeater, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Items.comparator, 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
                    break;
                }
                case 4: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.dispenser), 1);
                    break;
                }
                case 5: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block) Blocks.sticky_piston), 1);
                    break;
                }
                case 6: {
                    is = this.dropItemRand(Item.getItemFromBlock((Block) Blocks.piston), 1);
                    break;
                }
                case 7: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.lever), 1);
                    break;
                }
                case 8: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.redstone_block), 1);
                    break;
                }
                case 9: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.light_weighted_pressure_plate), 1);
                    break;
                }
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        return super.attackEntityAsMob(par1Entity);
    }

    protected void destroyBlock(final EntityLivingBase e) {
        final double x = e.posX + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat();
        final double y = e.posY - 1.0;
        final double z = e.posZ + this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat();
        final Block bid = this.worldObj.getBlock((int) x, (int) y, (int) z);
        if (bid == Blocks.obsidian) {
            return;
        }
        if (bid == Blocks.bedrock) {
            return;
        }
        if (bid == Blocks.quartz_block) {
            return;
        }
        if (bid == Blocks.mob_spawner) {
            return;
        }
        if (bid == Blocks.redstone_block) {
            return;
        }
        if (bid == Blocks.iron_block) {
            return;
        }
        if (bid == Blocks.chest) {
            return;
        }
        if (bid != Blocks.air && this.worldObj.getGameRules()
            .getGameRuleBooleanValue("mobGriefing")) {
            this.worldObj.setBlock((int) x, (int) y, (int) z, Blocks.air);
        }
    }

    protected void destroyNearbyBlocks() {
        for (int i = 0; i < 50; ++i) {
            final double x = this.posX + this.worldObj.rand.nextFloat() * 6.5 - this.worldObj.rand.nextFloat() * 6.5;
            final double y = this.posY + 0.1 + this.worldObj.rand.nextFloat() * 8.5;
            final double z = this.posZ + this.worldObj.rand.nextFloat() * 6.5 - this.worldObj.rand.nextFloat() * 6.5;
            final Block bid = this.worldObj.getBlock((int) x, (int) y, (int) z);
            if (bid != Blocks.obsidian) {
                if (bid != Blocks.bedrock) {
                    if (bid != Blocks.quartz_block) {
                        if (bid != Blocks.mob_spawner) {
                            if (bid != Blocks.redstone_block) {
                                if (bid != Blocks.iron_block) {
                                    if (bid != Blocks.chest) {
                                        if (bid != Blocks.air && this.worldObj.getGameRules()
                                            .getGameRuleBooleanValue("mobGriefing")) {
                                            this.worldObj.setBlock((int) x, (int) y, (int) z, Blocks.air);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(6) == 1 && OreSpawnMain.PlayNicely == 0) {
            EntityLivingBase e = null;
            if (this.worldObj.rand.nextInt(50) == 1) {
                this.setAttackTarget(null);
            }
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                final double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                final double rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                final double pi = 3.1415926545;
                double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                if (rdd > pi) {
                    rdd -= pi * 2.0;
                }
                rdd = Math.abs(rdd);
                this.faceEntity(e, 10.0f, 10.0f);
                if (rdd < 1.25) {
                    if (this.getDistanceSqToEntity(e) < (5.0f + e.width / 2.0f) * (5.0f + e.width / 2.0f)) {
                        this.setAttacking(1);
                        if (this.worldObj.rand.nextInt(5) == 0 || this.worldObj.rand.nextInt(6) == 1) {
                            this.attackEntityAsMob(e);
                            for (int i = 0; i < 6; ++i) {
                                this.destroyBlock(e);
                            }
                        }
                        this.destroyNearbyBlocks();
                    }
                } else {
                    this.setAttacking(0);
                }
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.0);
            } else {
                this.setAttacking(0);
            }
        }
        if (this.getAttacking() == 0 && OreSpawnMain.PlayNicely == 0) {
            if (this.worldObj.rand.nextInt(450) == 1) {
                this.just_for_fun = 50;
            }
            if (this.just_for_fun > 0) {
                --this.just_for_fun;
            }
            if (this.just_for_fun > 0) {
                this.setAttacking(1);
                if (this.worldObj.rand.nextInt(3) == 1) {
                    this.destroyNearbyBlocks();
                }
            } else {
                this.setAttacking(0);
            }
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLiving) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.2);
            }
            return ret;
        }
        return false;
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(14.0, 3.0, 14.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        for (final Object var7 : var5) {
            final EntityLivingBase var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    public boolean getCanSpawnHere() {
        for (byte k = -3; k < 3; ++k) {
            for (byte j = -3; j < 3; ++j) {
                for (byte i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Robo-Pounder")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j <= 1; ++j) {
                for (int i = 1; i < 6; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air && bid != Blocks.tallgrass) {
                        return false;
                    }
                }
            }
        }
        return this.isValidLightLevel();
    }
}
