
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.*;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class WindigoInstance extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorterInstance TargetSorter;
    private EntityLivingBase rt;
    private double attdam;
    private int dmgDelay;
    private int homex;
    private int homez;
    private int stream_count;
    private int stream_count_l;
    private int stream_count_i;
    private int ticker;
    private int gothitcount;
    private int backoff_timer;
    private int guard_mode;
    private int wing_sound;
    private int hugemob;
    private int isEnd;
    private int dialogTimer;
    private int gothit;
    private final int mad;
    private int MobBattleMode;

    public WindigoInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.rt = null;
        this.attdam = 750.0;
        this.dmgDelay = 0;
        this.homex = 0;
        this.homez = 0;
        this.stream_count = 0;
        this.stream_count_l = 0;
        this.stream_count_i = 0;
        this.ticker = 0;
        this.gothitcount = 0;
        this.backoff_timer = 0;
        this.guard_mode = 0;
        this.wing_sound = 0;
        this.hugemob = 0;
        this.isEnd = 0;
        this.dialogTimer = 0;
        this.gothit = 0;
        this.mad = 0;
        this.MobBattleMode = 0;
        this.setSize(25.0f, 30.0f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 175000;
        this.isImmuneToFire = true;
        this.fireResistance = 5000;
        this.noClip = false;
        this.TargetSorter = new GenericTargetSorterInstance(this);
        this.renderDistanceWeight = 12.0;
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(1.6200000047683716);
        this.attdam = 1750.0;
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(this.attdam);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, 0);
        this.dataWatcher.addObject(21, 0);
        this.dataWatcher.addObject(22, this.isEnd);
    }

    public int getPlayNicely() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderDist(final double par1) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public boolean isInRangeToRenderVec3D(final Vec3 par1Vec3) {
        return true;
    }

    protected boolean canDespawn() {
        return false;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    protected float getSoundVolume() {
        return 2.35f;
    }

    protected float getSoundPitch() {
        return 0.2f;
    }

    protected String getLivingSound() {
        return Tags.MODID + ":windigo_a";
    }

    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":lightningdeath";
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 9750;
    }

    /*
     * protected ItemFood getDropItemId() {
     * return Basic.twiMeat;
     * }
     */

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.75, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.75, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final Item it = null;
        final Block bl = null;
        Entity twi = null;
        Entity rbd = null;
        Entity apj = null;
        TwilicornInstance tw = null;
        DashInstance rd = null;
        AJInstance aj = null;
        twi = spawnCreature(this.worldObj, "MyTwilicorn", this.posX, this.posY + 10.0, this.posZ);
        rbd = spawnCreature(this.worldObj, "MyDash", this.posX, this.posY + 10.0, this.posZ);
        apj = spawnCreature(this.worldObj, "AJInstance", this.posX, this.posY + 5.0, this.posZ);
        if (twi != null) {
            tw = (TwilicornInstance) twi;
            final EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity) tw, 128.0);
            if (p != null) {
                tw.setTamed(true);
                tw.func_152115_b(
                    p.getUniqueID()
                        .toString());
                tw.worldObj.setEntityState((Entity) this, (byte) 7);
                tw.heal(this.mygetMaxHealth() - this.getHealth());
            }
        }
        if (rbd != null) {
            rd = (DashInstance) rbd;
            final EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity) tw, 128.0);
            if (p != null) {
                rd.setTamed(true);
                rd.func_152115_b(
                    p.getUniqueID()
                        .toString());
                rd.worldObj.setEntityState((Entity) this, (byte) 7);
                rd.heal(this.mygetMaxHealth() - this.getHealth());
            }
        }
        if (apj != null) {
            aj = (AJInstance) apj;
            final EntityPlayer p = this.worldObj.getClosestPlayerToEntity((Entity) tw, 128.0);
            if (p != null) {
                aj.setTamed(true);
                aj.func_152115_b(
                    p.getUniqueID()
                        .toString());
                aj.worldObj.setEntityState((Entity) this, (byte) 7);
                aj.heal(this.mygetMaxHealth() - this.getHealth());
            }
        }
        /*
         * this.dropItemRand(Basic.alicornSword, 1);
         * this.dropItemRand(Basic.alicornSword, 1);
         * this.dropItemRand(Basic.twilicornHelmet, 1);
         * this.dropItemRand(Basic.twilicornChest, 1);
         * this.dropItemRand(Basic.twilicornLegs, 1);
         * this.dropItemRand(Basic.twilicornBoots, 1);
         * this.dropItemRand(Basic.twilicornBow, 1);
         * this.dropItemRand(Basic.twilicornItem, 1);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropBlockRand(Basic.twilicornBlock, 64);
         * this.dropItemRand(Basic.twilightStar, 64);
         * this.dropItemRand(Basic.twilicornSword, 1);
         * this.dropItemRand(Basic.twilicornSpade, 1);
         * this.dropItemRand(Basic.twilicornHoe, 1);
         * this.dropItemRand(Basic.twilicornAxe, 1);
         * this.dropItemRand(Basic.twilicornPick, 1);
         * for (int var5 = 50 + this.worldObj.rand.nextInt(30), var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand(Basic.twilightStar, 1);
         * }
         * for (int var5 = 100 + this.worldObj.rand.nextInt(160), var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand((Item)Basic.twiMeat, 1);
         * }
         * for (int var5 = 50 + this.worldObj.rand.nextInt(60), var6 = 0; var6 < var5; ++var6) {
         * this.dropBlockRand(Basic.twilicornBlock, 1);
         * }
         * for (int var6 = 0; var6 < 128; ++var6) {
         * this.dropBlockRand(Basic.arcticBlock, 1);
         * }
         */
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.wing_sound;
        if (this.wing_sound > 30) {
            if (!this.worldObj.isRemote) {
                this.worldObj.playSoundAtEntity((Entity) this, Tags.MODID + ":flap_a", 2.75f, 0.75f);
            }
            this.wing_sound = 0;
        }
        this.noClip = false;
        this.motionY *= 0.6;
        if (this.getHealth() < (float) (this.mygetMaxHealth() * 2) / 3) {
            this.attdam = 750.0;
        }
        if (this.getHealth() < (float) this.mygetMaxHealth() / 2) {
            this.attdam = 1000.0;
        }
        if (this.getHealth() < (float) this.mygetMaxHealth() / 4) {
            this.attdam = 1250.0;
        }
        if (this.getHealth() < (float) this.mygetMaxHealth() / 8) {
            this.attdam = 1750.0;
        }
        if (this.worldObj.isRemote) {
            final float f = 7.0f;
            this.worldObj.spawnParticle(
                "witchMagic",
                this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)),
                this.posY + 14.0,
                this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)),
                (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 2.0 + this.motionX * 2.0,
                (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 6.0,
                (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 8.0 + this.motionZ * 50.0);
            this.isEnd = this.dataWatcher.getWatchableObjectInt(22);
            if (this.isEnd != 0 && this.worldObj.rand.nextInt(3) == 1) {
                for (int i = 0; i < 10; ++i) {
                    this.worldObj.spawnParticle(
                        "witchMagic",
                        this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + 14.0,
                        this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)),
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 2.0
                            + this.motionX * 2.0,
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 6.0,
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 8.0
                            + this.motionZ * 50.0);
                }
            }
        }
    }

    public void onDeathUpdate(final Entity par1Entity) {
        super.onDeathUpdate();
        for (int i = 0; i < 60; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 16.0f;
            this.worldObj.spawnParticle(
                "hugeexplosion",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "fireworksSpark",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.75,
                0.0);
        }
        if (this.gothitcount < 25 && this.getHealth() < 750.0f) {
            this.setHealth(750.0f);
            this.heal(750.0f - this.getHealth());
        }
        final EntityLivingBase e = (EntityLivingBase) par1Entity;
        final float s = par1Entity.height * par1Entity.width;
        if (s > 35.0f && !MobUtils.isPony(par1Entity)
            && !(par1Entity instanceof HydraInstance)
            && !(par1Entity instanceof SpikezillaInstance)
            && !(par1Entity instanceof UrsaMAJORInstance)
            && !(par1Entity instanceof CrabzillaInstance)) {
            e.setDead();
            this.setHealth(750.0f);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final EntityLivingBase e = (EntityLivingBase) par1Entity;
        final float s = par1Entity.height * par1Entity.width;
        if (s > 50.0f && !(par1Entity instanceof HydraInstance)
            && !(par1Entity instanceof SpikezillaInstance)
            && !(par1Entity instanceof WindigoInstance)
            && !(par1Entity instanceof CrabzillaInstance)
            && !(par1Entity instanceof UrsaMAJORInstance)) {
            e.setDead();
            e.setHealth(0.0f);
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource((Explosion) null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(2) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartWing1, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartWing2, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartTail1, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartTail2, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartTail3, var21, (float) this.attdam);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartWing1, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartWing2, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartTail1, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartTail2, var21, (float) this.attdam);
                dr.attackEntityFromPart(dr.dragonPartTail3, var21, (float) this.attdam);
            }
        }
        final boolean var22 = par1Entity
            .attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), (float) this.attdam);
        if (var22) {
            final double ks = 4.75;
            double inair = 0.45;
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            inair += this.worldObj.rand.nextFloat() * 0.25f;
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return var22;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 8.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    private void msgToPlayers(final String s) {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(80.0, 64.0, 80.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityPlayer var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityPlayer) var7;
        }
    }

    private EntityPlayer findNearestPlayer() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityPlayer.class, this.boundingBox.expand(80.0, 64.0, 80.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityPlayer var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            if (var7 instanceof EntityPlayer) {
                var8 = (EntityPlayer) var7;
            }
            if (var8 != null) {
                break;
            }
        }
        return var8;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        final int xzrange = 18;
        int attrand = 5;
        final int updown = 0;
        int which = 0;
        EntityLivingBase e = null;
        EntityLivingBase f = null;
        double rr = 0.0;
        double rhdir = 0.0;
        double rdd = 0.0;
        final double pi = 3.1415926545;
        double var1 = 0.0;
        double var2 = 0.0;
        double var3 = 0.0;
        float var4 = 0.0f;
        float var5 = 0.0f;
        EntityPlayer p = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        this.dataWatcher.updateObject(22, this.isEnd);
        // this.dataWatcher.updateObject(21, (Object)Basic.Snap);
        if (this.isEnd != 1) {
            if (this.isEnd == 2) {
                this.dmgDelay = 10;
                this.gothitcount = 0;
                this.stream_count = 10;
                this.stream_count_l = 10;
                this.stream_count_i = 10;
                attrand = 3;
                this.guard_mode = 0;
                this.hugemob = 1;
                if (this.backoff_timer > 0) {
                    --this.backoff_timer;
                }
            }
            if (this.dmgDelay > 0) {
                --this.dmgDelay;
            }
            if ((this.homex == 0 && this.homez == 0) || this.guard_mode == 0) {
                this.homex = (int) this.posX;
                this.homez = (int) this.posZ;
            }
            ++this.ticker;
            if (this.ticker > 30000) {
                this.ticker = 0;
            }
            if (this.ticker % 80 == 0) {
                this.stream_count = 10;
            }
            if (this.ticker % 90 == 0) {
                this.stream_count_l = 5;
            }
            if (this.ticker % 70 == 0) {
                this.stream_count_i = 8;
            }
            if (this.backoff_timer > 0) {
                --this.backoff_timer;
            }
            if (this.gothitcount < 75 && this.getHealth() < this.mygetMaxHealth() / 2) {
                attrand = 3;
            }
            this.noClip = true;
            if (this.currentFlightTarget == null) {
                this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
            }
            if (this.worldObj.rand.nextInt(2000) == 0
                || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ)
                    < 9.1f) {
                zdir = this.worldObj.rand.nextInt(220);
                xdir = this.worldObj.rand.nextInt(220);
                if (this.worldObj.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.worldObj.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                int dist = 0;
                for (int i = -2; i <= 5; i += 2) {
                    for (int j = -2; j <= 5; j += 2) {
                        Block bid = this.worldObj.getBlock(this.homex + j, (int) this.posY, this.homez + i);
                        if (bid != Blocks.air) {
                            for (int k = 1; k < 20; ++k) {
                                bid = this.worldObj.getBlock(this.homex + j, (int) this.posY + k, this.homez + i);
                                ++dist;
                                if (bid == Blocks.air) {
                                    break;
                                }
                            }
                        }
                        for (int k = 1; k < 20; ++k) {
                            bid = this.worldObj.getBlock(this.homex + j, (int) this.posY - k, this.homez + i);
                            --dist;
                            if (bid != Blocks.air) {
                                break;
                            }
                        }
                    }
                }
                dist = dist / 9 + 2;
                this.currentFlightTarget.set(this.homex + xdir, (int) (this.posY + dist), this.homez + zdir);
            } else if (this.worldObj.rand.nextInt(attrand) == 0) {
                e = this.rt;
                if (e != null) {
                    float d1 = (float) (e.posX - this.homex);
                    final float d2 = (float) (e.posZ - this.homez);
                    d1 = (float) Math.sqrt(d1 * d1 + d2 * d2);
                    if (e.isDead) {
                        e = null;
                        this.rt = null;
                    }
                }
                f = this.findSomethingToAttack();
                if (e == null) {
                    e = f;
                }
                if (e != null) {
                    this.setAttacking(1);
                    this.currentFlightTarget.set((int) e.posX, (int) e.posY, (int) e.posZ);
                    if (this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ)
                        < 9.1f) {
                        zdir = this.worldObj.rand.nextInt(20) + 30;
                        xdir = this.worldObj.rand.nextInt(20) + 30;
                        if (this.worldObj.rand.nextInt(2) == 0) {
                            zdir = -zdir;
                        }
                        if (this.worldObj.rand.nextInt(2) == 0) {
                            xdir = -xdir;
                        }
                        int dist = 0;
                        for (int i = -5; i <= 5; i += 5) {
                            for (int j = -5; j <= 5; j += 5) {
                                Block bid = this.worldObj.getBlock((int) e.posX + j, (int) this.posY, (int) e.posZ + i);
                                if (bid != Blocks.air) {
                                    for (int k = 1; k < 20; ++k) {
                                        bid = this.worldObj
                                            .getBlock((int) e.posX + j, (int) this.posY + k, (int) e.posZ + i);
                                        ++dist;
                                        if (bid == Blocks.air) {
                                            break;
                                        }
                                    }
                                }
                                for (int k = 1; k < 20; ++k) {
                                    bid = this.worldObj
                                        .getBlock((int) e.posX + j, (int) this.posY - k, (int) e.posZ + i);
                                    --dist;
                                    if (bid != Blocks.air) {
                                        break;
                                    }
                                }
                            }
                        }
                        dist = dist / 9 + 2;
                        this.currentFlightTarget
                            .set((int) e.posX + xdir, (int) (this.posY + dist), (int) e.posZ + zdir);
                    }
                    final double d3 = this.getDistanceSqToEntity((Entity) e);
                    if (d3 < 281.0) {
                        final double a = Math.atan2(this.posZ - e.posZ, this.posX - e.posX);
                        final double pm = 1.0;
                        e.addVelocity(
                            Math.cos(a) * (20.0 - Math.sqrt(d3)) * 1.2000000014901162,
                            (20.0 - Math.sqrt(d3)) * 0.0700000007450581 * pm,
                            Math.sin(a) * (20.0 - Math.sqrt(d3)) * 1.2000000014901162);
                    }
                    if (this.getDistanceSqToEntity((Entity) e) < 2750.0) {
                        final float s = e.height * e.width;
                        if (s > 50.0f && !(e instanceof HydraInstance)
                            && !(e instanceof WindigoInstance)
                            && !(e instanceof SpikezillaInstance)
                            && !(e instanceof CrabzillaInstance)
                            && !(e instanceof UrsaMAJORInstance)) {
                            e.setDead();
                            e.setHealth(0.0f);
                        }
                        if (this.getHealth() > 2500.0f && this.worldObj.rand.nextInt(6) == 1) {
                            this.Storm(this.posX, this.posY, this.posZ, 42.0, this.attdam, 1);
                        } else {
                            this.Storm(this.posX, this.posY, this.posZ, 48.0, this.attdam, 1);
                        }
                    }
                    if (this.getDistanceSqToEntity((Entity) e) < 720.0) {
                        this.attackEntityAsMob((Entity) e);
                    }
                    final double dx = this.posX + 20.0 * Math.sin(Math.toRadians(this.rotationYawHead));
                    final double dz = this.posZ - 50.0 * Math.cos(Math.toRadians(this.rotationYawHead));
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        this.Storm(this.posX, this.posY + 12.0, dz, 30.0, 2750.0, 1);
                    }
                    if (this.getHorizontalDistanceSqToEntity((Entity) e) > 750.0) {
                        this.MagicBolt(e);
                        this.LaunchBeams(e);
                        which = this.worldObj.rand.nextInt(3);
                        if (which == 0) {
                            if (this.stream_count > 0) {
                                this.setAttacking(1);
                                rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                                rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                                rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                                if (rdd > pi) {
                                    rdd -= pi * 2.0;
                                }
                                rdd = Math.abs(rdd);
                                if (rdd < 0.5) {}
                                if (this.worldObj.rand.nextInt(4) == 1
                                    && this.getDistanceSqToEntity((Entity) e) > 450.0) {
                                    this.MagicBolt(e);
                                    this.MagicBolt(e);
                                    this.LaunchBeams(e);
                                }
                            }
                        } else if (which == 1) {
                            if (this.stream_count_l > 0) {
                                this.setAttacking(1);
                                rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                                rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                                rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                                if (rdd > pi) {
                                    rdd -= pi * 2.0;
                                }
                                rdd = Math.abs(rdd);
                                if (rdd < 0.2) {
                                    this.LaunchBeams(e);
                                }
                            }
                        } else if (this.stream_count_i > 0) {
                            this.setAttacking(1);
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.3) {
                                this.LaunchBeams(e);
                            }
                        }
                    }
                } else {
                    this.setAttacking(0);
                    this.stream_count = 10;
                    this.stream_count_l = 5;
                    this.stream_count_i = 8;
                }
            }
            if (this.getAttacking() != 0 && this.worldObj.rand.nextInt(75) == 1) {
                final double xzoff = 10.0;
                final double yoff = 14.0;
                final Entity as = spawnCreature(
                    this.worldObj,
                    "MyArcticScorpion",
                    this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)),
                    this.posY + yoff,
                    this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                if (as != null) {
                    final ArcticScorpionInstance atcs = (ArcticScorpionInstance) as;
                    this.motionX *= 3.0;
                    this.motionZ *= 3.0;
                    atcs.atcgothit = 1;
                    atcs.atcmad = 1;
                    atcs.atcnoexplode = 1;
                }
            }
            if (this.getAttacking() != 0 && this.worldObj.rand.nextInt(125) == 1) {
                final double xzoff = 1.0;
                final double yoff = 14.0;
                for (int var6 = 0; var6 < 5; ++var6) {
                    final Entity ds = spawnCreature(
                        this.worldObj,
                        "MyDarkness",
                        this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + yoff,
                        this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                }
            }
            if (this.getAttacking() != 0 && this.worldObj.rand.nextInt(125) == 1
                && this.getHealth() < 2500.0f
                && this.getHealth() > 750.0f) {
                final double xzoff = 1.0;
                final double yoff = 14.0;
                for (int var6 = 0; var6 < 8; ++var6) {
                    final Entity ds = spawnCreature(
                        this.worldObj,
                        "MyDarkness",
                        this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + yoff,
                        this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                }
            }
            if (this.worldObj.rand.nextInt(125) == 1 && this.getHealth() < 750.0f) {
                final double xzoff = 1.0;
                final double yoff = 14.0;
                for (int var6 = 0; var6 < 10; ++var6) {
                    final Entity ds = spawnCreature(
                        this.worldObj,
                        "MyDarkness",
                        this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + yoff,
                        this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                }
            }
            var1 = this.currentFlightTarget.posX + 0.25 - this.posX;
            var2 = this.currentFlightTarget.posY + 0.25 - this.posY;
            var3 = this.currentFlightTarget.posZ + 0.25 - this.posZ;
            this.motionX += (Math.signum(var1) * 0.6 - this.motionX) * 0.15;
            this.motionY += (Math.signum(var2) * 0.75 - this.motionY) * 0.12;
            this.motionZ += (Math.signum(var3) * 0.6 - this.motionZ) * 0.15;
            var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
            var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
            this.moveForward = 1.2f;
            this.rotationYaw += var5 / 1.0f;
            this.moveEntity(this.motionX, this.motionY, this.motionZ);
            if (this.worldObj.rand.nextInt(30) == 1 && this.getHealth() > 2500.0f) {
                this.heal(8.0f);
                if (this.hugemob != 0) {
                    this.heal(9750.0f);
                }
            }
            if (this.worldObj.rand.nextInt(20) == 1 && this.getHealth() < 2500.0f && this.getHealth() > 750.0f) {
                this.heal(20.0f);
            }
            if (this.worldObj.rand.nextInt(60) == 1 && this.getHealth() < 750.0f) {
                this.heal(30.0f);
            }
            int l = -3 + this.ticker % 30;
            /*
             * if (Basic.Snap == 0) {
             * for (int i = -xzrange; i <= xzrange; ++i) {
             * for (int j = -xzrange; j <= xzrange; ++j) {
             * final Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j);
             * if (!this.isBreakable(bid)) {
             * if (bid == Blocks.water && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.ice);
             * }
             * if (bid == Blocks.lava && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.obsidian);
             * }
             * if (bid == Blocks.flowing_water && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.ice);
             * }
             * if (bid == Blocks.flowing_lava && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.obsidian);
             * }
             * if (bid == Blocks.grass && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.snow);
             * }
             * if (bid == Blocks.dirt && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.snow);
             * }
             * if (bid == Blocks.sand && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.snow);
             * }
             * if (bid == Blocks.leaves && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.ice);
             * }
             * if (bid == Blocks.mycelium && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.snow);
             * }
             * if (bid == Blocks.stone && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Basic.arcticBlock);
             * }
             * if (bid == Blocks.log && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Basic.arcticBlock);
             * }
             * if (bid == Blocks.netherrack && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.snow);
             * }
             * if (bid == Blocks.nether_brick && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.packed_ice);
             * }
             * if (bid == Blocks.nether_brick_fence &&
             * this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.ice);
             * }
             * if (bid == Blocks.nether_brick_stairs &&
             * this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.ice);
             * }
             * if (bid == Blocks.fire && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.air);
             * }
             * if (bid == Blocks.quartz_ore && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + i, (int)this.posY + l, (int)this.posZ + j, Blocks.water);
             * }
             * }
             * }
             * }
             * }
             */
            final double dx2 = this.posX + 16.0 * Math.sin(Math.toRadians(this.rotationYawHead));
            final double dz2 = this.posZ - 16.0 * Math.cos(Math.toRadians(this.rotationYawHead));
            l = -3 + this.ticker % 12;
            /*
             * if (Basic.Snap == 0) {
             * for (int m = -xzrange; m <= xzrange; ++m) {
             * for (int j2 = -xzrange; j2 <= xzrange; ++j2) {
             * final Block bid2 = this.worldObj.getBlock((int)dx2 + m, (int)this.posY + l, (int)dz2 + j2);
             * if (!this.isBreakable(bid2)) {
             * if (bid2 == Blocks.water && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.lava && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.obsidian);
             * }
             * if (bid2 == Blocks.flowing_water && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
             * {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.flowing_lava && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.obsidian);
             * }
             * if (bid2 == Blocks.grass && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.dirt && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.sand && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.leaves && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.mycelium && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.stone && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Basic.arcticBlock);
             * }
             * if (bid2 == Blocks.log && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Basic.arcticBlock);
             * }
             * if (bid2 == Blocks.netherrack && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.nether_brick && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.packed_ice);
             * }
             * if (bid2 == Blocks.nether_brick_fence &&
             * this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.nether_brick_stairs &&
             * this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.fire && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.air);
             * }
             * if (bid2 == Blocks.quartz_ore && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.water);
             * }
             * }
             * }
             * }
             * }
             */
            /*
             * if (Basic.Snap == 0) {
             * for (int m = -xzrange; m <= xzrange; ++m) {
             * for (int j2 = -xzrange; j2 <= xzrange; ++j2) {
             * final Block bid2 = this.worldObj.getBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2);
             * if (!this.isBreakable(bid2)) {
             * if (bid2 == Blocks.water && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.lava && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.obsidian);
             * }
             * if (bid2 == Blocks.flowing_water && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing"))
             * {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.flowing_lava && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.obsidian);
             * }
             * if (bid2 == Blocks.grass && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.dirt && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.sand && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.leaves && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.mycelium && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.stone && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Basic.arcticBlock);
             * }
             * if (bid2 == Blocks.log && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Basic.arcticBlock);
             * }
             * if (bid2 == Blocks.netherrack && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.snow);
             * }
             * if (bid2 == Blocks.nether_brick && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.packed_ice);
             * }
             * if (bid2 == Blocks.nether_brick_fence &&
             * this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.nether_brick_stairs &&
             * this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.ice);
             * }
             * if (bid2 == Blocks.fire && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.air);
             * }
             * if (bid2 == Blocks.quartz_ore && this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing")) {
             * this.worldObj.setBlock((int)this.posX + m, (int)this.posY + l, (int)this.posZ + j2, Blocks.water);
             * }
             * }
             * }
             * }
             * }
             */
            return;
        }
        this.noClip = false;
        this.motionX = 0.0;
        this.motionY = 0.0;
        this.motionZ = 0.0;
        this.dmgDelay = 10;
        if (this.isDead) {
            return;
        }
        p = this.findNearestPlayer();
        if (p != null) {
            this.faceEntity((Entity) p, 10.0f, 10.0f);
            p.motionX = 0.0;
            p.motionY = 0.0;
            p.motionZ = 0.0;
            final double dd0 = this.posX - p.posX;
            final double dd2 = this.posZ - p.posZ;
            final float f2 = (float) (Math.atan2(dd2, dd0) * 180.0 / 3.141592653589793) - 90.0f;
            this.isEnd = 2;
        }
    }

    private boolean isBreakable(final Block bid) {
        return bid != null && this.worldObj.getGameRules()
            .getGameRuleBooleanValue("mobGriefing")
            && bid != Blocks.grass
            && bid != Blocks.dirt
            && bid != Blocks.water
            && bid != Blocks.flowing_water
            && bid != Blocks.log
            && bid != Blocks.mycelium
            && bid != Blocks.lava
            && bid != Blocks.leaves
            && bid != Blocks.flowing_lava
            && bid != Blocks.stone
            && bid != Blocks.sand
            && bid != Blocks.netherrack
            && bid != Blocks.nether_brick_fence
            && bid != Blocks.nether_brick_stairs
            && bid != Blocks.nether_brick
            && bid != Blocks.fire
            && bid != Blocks.quartz_ore;
    }

    private double getHorizontalDistanceSqToEntity(final Entity e) {
        final double d1 = e.posZ - this.posZ;
        final double d2 = e.posX - this.posX;
        return d1 * d1 + d2 * d2;
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = 14.0;
        final double xzoff = 36.0;
        BetterFireballInstance bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count > 0) {
            bf = new BetterFireballInstance(
                this.worldObj,
                (EntityLivingBase) this,
                e.posX - cx,
                e.posY + e.height / 2.0f - (this.posY + yoff),
                e.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            bf.setHuge();
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                2.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity) bf);
            for (int i = 0; i < 2; ++i) {
                final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                bf = new BetterFireballInstance(
                    this.worldObj,
                    (EntityLivingBase) this,
                    e.posX - cx + r1,
                    e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
                    e.posZ - cz + r3);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                bf.setBig();
                if (this.worldObj.rand.nextInt(2) == 1) {
                    bf.setHuge();
                }
                this.worldObj.playSoundAtEntity(
                    (Entity) this,
                    "random.explode",
                    2.0f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity) bf);
            }
            --this.stream_count;
        }
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float dm = par2;
        if (this.dmgDelay > 0) {
            return false;
        }
        if (dm > 2000.0f) {
            dm = 2000.0f;
        }
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLivingBase) {
            final EntityLivingBase enl = (EntityLivingBase) e;
            final float s = enl.height * enl.width;
            if (s > 30.0f && !MobUtils.isPony((Entity) enl)
                && !(enl instanceof HydraInstance)
                && !(enl instanceof UrsaMAJORInstance)) {
                dm /= 10.0f;
                this.dmgDelay = 20;
                this.hugemob = 1;
            }
            if (e instanceof EntityMob && s < 3.0f) {
                e.setDead();
                return false;
            }
            if (e != null && e instanceof EntityPlayer && this.getHealth() < this.getMaxHealth() * 9.0f / 10.0f) {
                this.gothit = 1;
            }
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            this.dmgDelay = 20;
            ret = super.attackEntityFrom(par1DamageSource, dm);
            if (e != null && e instanceof EntityPlayer) {
                ++this.gothitcount;
            }
            if (this.MobBattleMode != 0) {
                this.gothitcount = 80;
            }
            if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null && !MobUtils.isPony(e)) {
                this.rt = (EntityLivingBase) e;
                int dist = (int) e.posY;
                if (dist > 230) {
                    dist = 230;
                }
                this.currentFlightTarget.set((int) e.posX, dist, (int) e.posZ);
            }
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        if (this.worldObj.rand.nextInt(10) != 1) {
            return false;
        }
        for (int k = -10; k < 10; ++k) {
            for (int j = -10; j < 10; ++j) {
                for (int i = 6; i < 10; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("WindigoInstance")) {
                            return true;
                        }
                    }
                }
            }
        }
        WindigoInstance target = null;
        target = (WindigoInstance) this.worldObj.findNearestEntityWithinAABB(
            WindigoInstance.class,
            this.boundingBox.expand(256.0, 256.0, 256.0),
            (Entity) this);
        return target == null;
    }

    public boolean TooMany() {
        DarknessInstance target = null;
        target = (DarknessInstance) this.worldObj.findNearestEntityWithinAABB(
            DarknessInstance.class,
            this.boundingBox.expand(64.0, 32.0, 64.0),
            (Entity) this);
        return target != null;
    }

    public int getTotalArmorValue() {
        if (this.hugemob != 0 && this.MobBattleMode != 1) {
            return 25;
        }
        if (this.gothitcount < 75 && this.getHealth() < 750.0f) {
            return 25;
        }
        return 24;
    }

    public void onStruckByLightning(final EntityLightningBolt par1EntityLightningBolt) {}

    public void initCreature() {}

    public boolean MyCanSee(final EntityLivingBase e) {
        final double xzoff = 22.0;
        int nblks = 20;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        float startx = (float) cx;
        float starty = (float) (this.posY + this.height * 7.0f / 8.0f);
        float startz = (float) cz;
        float dx = (float) ((e.posX - startx) / 20.0);
        float dy = (float) ((e.posY + e.height / 2.0f - starty) / 20.0);
        float dz = (float) ((e.posZ - startz) / 20.0);
        if (Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks *= (int) Math.abs(dx);
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if (Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks *= (int) Math.abs(dy);
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if (Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks *= (int) Math.abs(dz);
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            startx += dx;
            starty += dy;
            startz += dz;
            final Block bid = this.worldObj.getBlock((int) startx, (int) starty, (int) startz);
            if (bid != Blocks.flowing_water && bid != Blocks.water
                && bid != Blocks.leaves
                && bid != Blocks.vine
                && bid != Blocks.air) {
                return false;
            }
        }
        return true;
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
        if (MobUtils.isPony((Entity) par1EntityLiving)) {
            return par1EntityLiving instanceof TwilicornInstance;
        }
        float d1 = (float) (par1EntityLiving.posX - this.homex);
        final float d2 = (float) (par1EntityLiving.posZ - this.homez);
        d1 = (float) Math.sqrt(d1 * d1 + d2 * d2);
        if (d1 > 144.0f) {
            return false;
        }
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode && (this.gothit != 0 || this.mad != 0);
        }
        return par1EntityLiving instanceof EntityVillager || (this.MyCanSee(par1EntityLiving)
            && (par1EntityLiving instanceof EntityHorse || par1EntityLiving instanceof EntityDragon
                || (!(par1EntityLiving instanceof ArcticScorpionInstance)
                    && (par1EntityLiving instanceof HydraInstance || par1EntityLiving instanceof UrsaMAJORInstance
                        || !MobUtils.isAttackableNonMob(par1EntityLiving)
                        || true))));
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(128.0, 128.0, 128.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false)) {
                return var8;
            }
        }
        return null;
    }

    public void setGuardMode(final int i) {
        this.guard_mode = i;
    }

    public void setFree() {
        this.isEnd = 1;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("SpawnX", this.homex);
        par1NBTTagCompound.setInteger("SpawnZ", this.homez);
        par1NBTTagCompound.setInteger("HomeSick", this.guard_mode);
        par1NBTTagCompound.setInteger("AntiCheatClock", this.gothitcount);
        par1NBTTagCompound.setInteger("IfTooLaggy", this.isEnd);
        par1NBTTagCompound.setInteger("Count", this.dialogTimer);
        par1NBTTagCompound.setInteger("Mob Battle Mode (Set To 1)", this.MobBattleMode);
        par1NBTTagCompound.setInteger("Annoyed by Player", this.gothit);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.homex = par1NBTTagCompound.getInteger("SpawnX");
        this.homez = par1NBTTagCompound.getInteger("SpawnZ");
        this.guard_mode = par1NBTTagCompound.getInteger("HomeSick");
        this.gothitcount = par1NBTTagCompound.getInteger("AntiCheatClock");
        this.isEnd = par1NBTTagCompound.getInteger("IfTooLaggy");
        this.dialogTimer = par1NBTTagCompound.getInteger("Count");
        this.MobBattleMode = par1NBTTagCompound.getInteger("Mob Battle Mode (Set To 1)");
        this.gothit = par1NBTTagCompound.getInteger("Annoyed By Player");
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

    private EntityLivingBase Storm(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (var8 != null && var8 != this
                && var8.isEntityAlive()
                && !(var8 instanceof WindigoInstance)
                && !(var8 instanceof ArcticScorpionInstance)
                && !(var8 instanceof DarknessInstance)) {
                DamageSource var9;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, 750.0f);
                var8.attackEntityFrom(DamageSource.inWall, 750.0f);
                this.worldObj.playSoundAtEntity(
                    var8,
                    "random.explode",
                    2.65f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 4.75;
                final double inair = 0.45;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private void LaunchBeams(final EntityLivingBase e) {
        final double yoff = 32.75;
        final double xzoff = 24.5;
        if (this.stream_count > 0) {
            this.setAttacking(2);
            final WindigoPowerInstance var2 = new WindigoPowerInstance(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                this.rotationYawHead,
                this.rotationPitch);
            final double var3 = e.posX - var2.posX;
            final double var4 = e.posY + 0.25 - var2.posY;
            final double var5 = e.posZ - var2.posZ;
            final float var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
            var2.setThrowableHeading(var3, var4 + var6, var5, 6.4f, 10.0f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var2);
            --this.stream_count;
        } else {
            this.setAttacking(0);
        }
        if (this.stream_count <= 0 && this.rand.nextInt(4) == 1) {
            this.stream_count = 8;
        }
    }

    private void windchill(final EntityLivingBase e) {
        final double yoff = 1.75;
        final double xzoff = 1.5;
        BetterFireballInstance bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count > 0) {
            bf = new BetterFireballInstance(
                this.worldObj,
                (EntityLivingBase) this,
                e.posX - cx,
                e.posY + e.height / 2.0f - (this.posY + yoff),
                e.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            bf.setWind();
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                1.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(bf);
            for (int i = 0; i < 10; ++i) {
                final float r1 = 10.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r2 = 10.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r3 = 10.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                bf = new BetterFireballInstance(
                    this.worldObj,
                    (EntityLivingBase) this,
                    e.posX - cx + r1,
                    e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
                    e.posZ - cz + r3);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                this.worldObj.playSoundAtEntity(
                    this,
                    "random.explode",
                    1.0f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(bf);
            }
            --this.stream_count;
        }
    }

    private void MagicBolt(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 1000.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
        for (int var3 = 0; var3 < 20; ++var3) {}
        this.worldObj.playSoundAtEntity(
            e,
            "random.explode",
            1.5f,
            1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {}
        this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
        this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
    }
}
