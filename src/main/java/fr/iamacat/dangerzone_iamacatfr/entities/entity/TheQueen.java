
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.*;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TheQueen extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private EntityLivingBase rt;
    private double attdam;
    private int hurt_timer;
    private int homex;
    private int homez;
    private int stream_count;
    private int stream_count_l;
    private int ticker;
    private int player_hit_count;
    private int backoff_timer;
    private int guard_mode;
    private volatile int head_found;
    private int wing_sound;
    private int attack_level;
    private EntityLivingBase ev;
    private float evh;
    private int mood;
    private int always_mad;

    public TheQueen(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.rt = null;
        this.attdam = 250.0;
        this.hurt_timer = 0;
        this.homex = 0;
        this.homez = 0;
        this.stream_count = 0;
        this.stream_count_l = 0;
        this.ticker = 0;
        this.player_hit_count = 0;
        this.backoff_timer = 0;
        this.guard_mode = 0;
        this.head_found = 0;
        this.wing_sound = 0;
        this.attack_level = 1;
        this.ev = null;
        this.evh = 0.0f;
        this.mood = 0;
        this.always_mad = 0;
        if (OreSpawnMain.PlayNicely == 0) {
            this.setSize(22.0f, 24.0f);
        } else {
            this.setSize(5.5f, 6.0f);
        }
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 25000;
        this.isImmuneToFire = true;
        this.fireResistance = 5000;
        this.noClip = true;
        this.TargetSorter = new GenericTargetSorter(this);
        this.renderDistanceWeight = 12.0;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.6200000047683716);
        this.attdam = OreSpawnMain.TheQueen_stats.attack;
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(this.attdam);
    }

    protected void entityInit() {
        final int i = 0;
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) i);
        this.dataWatcher.addObject(21, (Object) OreSpawnMain.PlayNicely);
        this.dataWatcher.addObject(22, (Object) this.mood);
        this.dataWatcher.addObject(23, (Object) this.attack_level);
    }

    public int getPlayNicely() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public int getIsHappy() {
        return this.dataWatcher.getWatchableObjectInt(22);
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

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) par1);
    }

    public int getPower() {
        return this.dataWatcher.getWatchableObjectInt(23);
    }

    public void setPower(final int par1) {
        this.dataWatcher.updateObject(23, (Object) par1);
    }

    protected float getSoundVolume() {
        return 1.35f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected String getLivingSound() {
        return "orespawn:king_living";
    }

    protected String getHurtSound() {
        return "orespawn:king_hit";
    }

    protected String getDeathSound() {
        return "orespawn:trex_death";
    }

    public boolean canBePushed() {
        return false;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return OreSpawnMain.TheQueen_stats.health;
    }

    protected Item getDropItem() {
        return Item.getItemFromBlock((Block) Blocks.yellow_flower);
    }

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20),
            this.posY + 12.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(20) - OreSpawnMain.OreSpawnRand.nextInt(20),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(OreSpawnMain.MyRoyal, 1);
        this.dropItemRand(OreSpawnMain.ThePrinceEgg, 1);
        spawnCreature(this.worldObj, "The Princess", this.posX, this.posY + 10.0, this.posZ);
        for (int i = 0; i < 56; ++i) {
            this.dropItemRand(OreSpawnMain.MyQueenScale, 1);
            this.dropItemRand(Items.beef, 1);
            this.dropItemRand(Items.bone, 1);
            this.dropItemRand(Items.rotten_flesh, 1);
        }
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public boolean isHappy() {
        return this.getIsHappy() == 0;
    }

    public void onUpdate() {
        super.onUpdate();
        ++this.wing_sound;
        if (this.wing_sound > 30) {
            if (!this.worldObj.isRemote) {
                this.worldObj.playSoundAtEntity(this, "orespawn:MothraWings", 1.75f, 0.75f);
            }
            this.wing_sound = 0;
        }
        this.noClip = true;
        this.motionY *= 0.6;
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() * 3 / 4) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 20;
        }
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() / 2) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 100;
        }
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() / 3) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 500;
        }
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() / 4) {
            this.attdam = OreSpawnMain.TheQueen_stats.attack * 1000;
        }
        if (this.worldObj.isRemote && this.getPower() > 800) {
            final float f = 7.0f;
            if (this.worldObj.rand.nextInt(4) == 1) {
                for (int i = 0; i < 10; ++i) {
                    this.worldObj.spawnParticle(
                        "fireworksSpark",
                        this.posX - f * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + 14.0,
                        this.posZ + f * Math.cos(Math.toRadians(this.rotationYaw)),
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 5.0
                            + this.motionX * 3.0,
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 5.0,
                        (this.worldObj.rand.nextGaussian() - this.worldObj.rand.nextGaussian()) / 5.0
                            + this.motionZ * 3.0);
                }
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase && !this.worldObj.isRemote) {
            final EntityLivingBase e = (EntityLivingBase) par1Entity;
            if (!e.isDead) {
                if (this.ev == e) {
                    if (this.evh < e.getHealth()) {
                        e.setHealth(this.evh);
                    }
                } else {
                    this.ev = e;
                }
                if (e.width * e.height > 30.0f) {
                    e.setHealth(e.getHealth() * 3.0f / 4.0f);
                    e.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.attdam);
                }
                this.evh = e.getHealth();
                if (this.evh <= 0.0f) {
                    this.ev.setDead();
                }
            } else {
                this.ev = null;
                this.evh = 0.0f;
            }
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource(null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(6) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, (float) this.attdam);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, (float) this.attdam);
            }
        }
        final boolean var22 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.attdam);
        if (var22) {
            final double ks = 2.75;
            double inair = 0.2;
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            inair += this.worldObj.rand.nextFloat() * 0.25f;
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 1.5;
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

    private boolean tooFarFromHome() {
        float d1 = (float) (this.posX - this.homex);
        final float d2 = (float) (this.posZ - this.homez);
        d1 = (float) Math.sqrt(d1 * d1 + d2 * d2);
        return d1 > 120.0f;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
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
        EntityLiving newent = null;
        final double xzoff = 8.0;
        final double yoff = 14.0;
        List kinglist = null;
        Iterator var6 = null;
        TheKing var7 = null;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.ev != null) {
            if (this.getDistanceSqToEntity(this.ev) < 2000.0 && !this.ev.isDead) {
                if (this.evh < this.ev.getHealth()) {
                    this.ev.setHealth(this.evh);
                } else {
                    this.evh = this.ev.getHealth();
                }
                if (this.evh <= 0.0f) {
                    this.ev.setDead();
                }
            } else {
                this.ev = null;
                this.evh = 0.0f;
            }
        }
        if (this.attack_level > 1000) {
            if (this.mood == 1) {
                int j = 15;
                if (this.player_hit_count < 10) {
                    j = 45;
                }
                for (int i = 0; i < j; ++i) {
                    final Entity ppwr = spawnCreature(
                        this.worldObj,
                        "PurplePower",
                        this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw)),
                        this.posY + yoff,
                        this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)));
                    if (ppwr != null) {
                        ppwr.motionX = this.motionX * 3.0;
                        ppwr.motionZ = this.motionZ * 3.0;
                    }
                }
            } else {
                if (this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing")) {
                    for (int m = 0; m < 25; ++m) {
                        final int i = this.worldObj.rand.nextInt(25) - this.worldObj.rand.nextInt(25);
                        final int k = this.worldObj.rand.nextInt(25) - this.worldObj.rand.nextInt(25);
                        int j = -20;
                        while (j < 20) {
                            final Block bid = this.worldObj
                                .getBlock((int) this.posX + i, (int) this.posY + j, (int) this.posZ + k);
                            if (bid == Blocks.grass) {
                                if (this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    != Blocks.air) {
                                    break;
                                }
                                which = this.worldObj.rand.nextInt(8);
                                if (which == 0) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        (Block) Blocks.red_flower);
                                }
                                if (which == 1) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        (Block) Blocks.yellow_flower);
                                }
                                if (which == 2) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        OreSpawnMain.MyFlowerBlueBlock);
                                }
                                if (which == 3) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        OreSpawnMain.MyFlowerPinkBlock);
                                }
                                if (which == 4) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        OreSpawnMain.CrystalFlowerRedBlock);
                                }
                                if (which == 5) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        OreSpawnMain.CrystalFlowerGreenBlock);
                                }
                                if (which == 6) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        OreSpawnMain.CrystalFlowerBlueBlock);
                                }
                                if (which == 7) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        OreSpawnMain.CrystalFlowerYellowBlock);
                                    break;
                                }
                                break;
                            } else {
                                if (bid == Blocks.dirt && this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    == Blocks.air) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j,
                                        (int) this.posZ + k,
                                        (Block) Blocks.grass);
                                    break;
                                }
                                if (bid == Blocks.stone && this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    == Blocks.air) {
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j + 1,
                                        (int) this.posZ + k,
                                        Blocks.dirt);
                                    break;
                                }
                                if (bid == Blocks.sand && this.worldObj
                                    .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                    == Blocks.air) {
                                    if (this.worldObj.rand.nextInt(2) == 0) {
                                        this.worldObj.setBlock(
                                            (int) this.posX + i,
                                            (int) this.posY + j + 1,
                                            (int) this.posZ + k,
                                            Blocks.cactus);
                                        break;
                                    }
                                    this.worldObj.setBlock(
                                        (int) this.posX + i,
                                        (int) this.posY + j,
                                        (int) this.posZ + k,
                                        Blocks.dirt);
                                    break;
                                } else {
                                    if (bid == Blocks.lava && this.worldObj
                                        .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                        == Blocks.air) {
                                        this.worldObj.setBlock(
                                            (int) this.posX + i,
                                            (int) this.posY + j,
                                            (int) this.posZ + k,
                                            Blocks.water);
                                        break;
                                    }
                                    if (bid == Blocks.flowing_lava && this.worldObj
                                        .getBlock((int) this.posX + i, (int) this.posY + j + 1, (int) this.posZ + k)
                                        == Blocks.air) {
                                        this.worldObj.setBlock(
                                            (int) this.posX + i,
                                            (int) this.posY + j,
                                            (int) this.posZ + k,
                                            Blocks.flowing_water);
                                        break;
                                    }
                                    if (bid == Blocks.air && j > 0) {
                                        break;
                                    }
                                    ++j;
                                }
                            }
                        }
                    }
                }
                for (int m = 0; m < 10; ++m) {
                    final int i = this.worldObj.rand.nextInt(15) - this.worldObj.rand.nextInt(15);
                    final int k = this.worldObj.rand.nextInt(15) - this.worldObj.rand.nextInt(15);
                    final int j = this.worldObj.rand.nextInt(20);
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + i, (int) this.posY + j, (int) this.posZ + k);
                    if (bid == Blocks.air) {
                        if (this.worldObj.rand.nextInt(2) == 0) {
                            newent = (EntityLiving) spawnCreature(
                                this.worldObj,
                                "Butterfly",
                                this.posX + i,
                                this.posY + j,
                                this.posZ + k);
                        } else {
                            newent = (EntityLiving) spawnCreature(
                                this.worldObj,
                                "Bird",
                                this.posX + i,
                                this.posY + j,
                                this.posZ + k);
                        }
                    }
                }
            }
            this.attack_level = 1;
        }
        if (this.attack_level > 1) {
            --this.attack_level;
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if ((this.homex == 0 && this.homez == 0) || this.guard_mode == 0) {
            this.homex = (int) this.posX;
            this.homez = (int) this.posZ;
        }
        if (this.getHealth() > this.mygetMaxHealth() - 2 && this.worldObj.rand.nextInt(500) == 1) {
            this.mood = 0;
        }
        if (this.always_mad != 0) {
            this.mood = 1;
        }
        if (this.mood == 0) {
            this.attack_level += 10;
        }
        ++this.ticker;
        if (this.ticker > 30000) {
            this.ticker = 0;
        }
        if (this.ticker % 60 == 0) {
            this.stream_count = 10;
        }
        if (this.ticker % 70 == 0) {
            this.stream_count_l = 6;
        }
        if (this.ticker % 10 == 0) {
            this.dataWatcher.updateObject(21, (Object) OreSpawnMain.PlayNicely);
            this.dataWatcher.updateObject(22, (Object) this.mood);
            this.setPower(this.attack_level);
        }
        if (this.backoff_timer > 0) {
            --this.backoff_timer;
        }
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() / 2) {
            attrand = 3;
        }
        this.noClip = true;
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.tooFarFromHome() || this.worldObj.rand.nextInt(200) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 9.1f) {
            zdir = this.worldObj.rand.nextInt(120);
            xdir = this.worldObj.rand.nextInt(120);
            if (this.worldObj.rand.nextInt(2) == 0) {
                zdir = -zdir;
            }
            if (this.worldObj.rand.nextInt(2) == 0) {
                xdir = -xdir;
            }
            int dist = 0;
            for (int i = -5; i <= 5; i += 5) {
                for (int j = -5; j <= 5; j += 5) {
                    Block bid = this.worldObj.getBlock(this.homex + j, (int) this.posY, this.homez + i);
                    if (bid != Blocks.air) {
                        for (int k = 1; k < 20; ++k) {
                            bid = this.worldObj.getBlock(this.homex + j, (int) this.posY + k, this.homez + i);
                            ++dist;
                            if (bid == Blocks.air) {
                                break;
                            }
                        }
                    } else {
                        for (int k = 1; k < 20; ++k) {
                            bid = this.worldObj.getBlock(this.homex + j, (int) this.posY - k, this.homez + i);
                            --dist;
                            if (bid != Blocks.air) {
                                break;
                            }
                        }
                    }
                }
            }
            dist = dist / 9 + 2;
            if ((int) (this.posY + dist) > 230) {
                dist = 230 - (int) this.posY;
            }
            this.currentFlightTarget.set(this.homex + xdir, (int) (this.posY + dist), this.homez + zdir);
            if (this.mood == 0) {
                kinglist = this.worldObj
                    .getEntitiesWithinAABB(TheKing.class, this.boundingBox.expand(64.0, 32.0, 64.0));
                if (kinglist != null) {
                    Collections.sort((List<Object>) kinglist, (Comparator<? super Object>) this.TargetSorter);
                    var6 = kinglist.iterator();
                    if (var6.hasNext()) {
                        var7 = null;
                        var7 = (TheKing) var6.next();
                        this.guard_mode = 0;
                        zdir = this.worldObj.rand.nextInt(16);
                        xdir = this.worldObj.rand.nextInt(16);
                        if (this.worldObj.rand.nextInt(2) == 0) {
                            zdir = -zdir;
                        }
                        if (this.worldObj.rand.nextInt(2) == 0) {
                            xdir = -xdir;
                        }
                        this.currentFlightTarget.set(
                            (int) var7.posX + xdir,
                            (int) (var7.posY + (this.worldObj.rand.nextInt(8) - this.worldObj.rand.nextInt(8))),
                            (int) var7.posZ + zdir);
                    }
                }
            }
        } else if (this.worldObj.rand.nextInt(attrand) == 0) {
            e = this.rt;
            if (OreSpawnMain.PlayNicely != 0 || this.isHappy()) {
                e = null;
            }
            if (e != null && (e instanceof TheQueen || e instanceof QueenHead)) {
                this.rt = null;
                e = null;
            }
            if (e != null) {
                float d1 = (float) (e.posX - this.homex);
                final float d2 = (float) (e.posZ - this.homez);
                d1 = (float) Math.sqrt(d1 * d1 + d2 * d2);
                if (e.isDead || this.worldObj.rand.nextInt(450) == 1 || (d1 > 128.0f && this.guard_mode == 1)) {
                    e = null;
                    this.rt = null;
                }
                if (e != null && !this.MyCanSee(e)) {
                    e = null;
                }
            }
            f = this.findSomethingToAttack();
            if (this.head_found == 0 && this.mood == 1) {
                newent = (EntityLiving) spawnCreature(
                    this.worldObj,
                    "QueenHead",
                    this.posX,
                    this.posY + 20.0,
                    this.posZ);
            }
            if (e == null) {
                e = f;
            }
            if (e != null) {
                final float d1 = e.width * e.height;
                if (this.attack_level < 1000) {
                    this.attack_level += 15;
                    if (this.getHealth() < this.mygetMaxHealth() / 2) {
                        this.attack_level += 15;
                    }
                    if (d1 > 50.0f) {
                        this.attack_level += 15;
                    }
                    if (d1 > 100.0f) {
                        this.attack_level += 15;
                    }
                    if (d1 > 200.0f) {
                        this.attack_level += 25;
                    }
                }
                this.setAttacking(1);
                if (this.backoff_timer == 0) {
                    int dist = (int) (e.posY + e.height / 2.0f + 1.0);
                    if (dist > 230) {
                        dist = 230;
                    }
                    this.currentFlightTarget.set((int) e.posX, dist, (int) e.posZ);
                    if (this.worldObj.rand.nextInt(50) == 1) {
                        this.backoff_timer = 90 + this.worldObj.rand.nextInt(90);
                    }
                } else
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
                                    Block bid = this.worldObj
                                        .getBlock((int) e.posX + j, (int) this.posY, (int) e.posZ + i);
                                    if (bid != Blocks.air) {
                                        for (int k = 1; k < 20; ++k) {
                                            bid = this.worldObj
                                                .getBlock((int) e.posX + j, (int) this.posY + k, (int) e.posZ + i);
                                            ++dist;
                                            if (bid == Blocks.air) {
                                                break;
                                            }
                                        }
                                    } else {
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
                            }
                            dist = dist / 9 + 2;
                            if ((int) (this.posY + dist) > 230) {
                                dist = 230 - (int) this.posY;
                            }
                            this.currentFlightTarget
                                .set((int) e.posX + xdir, (int) (this.posY + dist), (int) e.posZ + zdir);
                        }
                if (this.getDistanceSqToEntity(e) < 900.0) {
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        this.doJumpDamage(
                            this.posX,
                            this.posY,
                            this.posZ,
                            15.0,
                            OreSpawnMain.TheQueen_stats.attack / 4,
                            0);
                    }
                    this.attackEntityAsMob(e);
                }
                final double dx = this.posX + 20.0 * Math.sin(Math.toRadians(this.rotationYaw));
                final double dz = this.posZ - 20.0 * Math.cos(Math.toRadians(this.rotationYaw));
                if (this.worldObj.rand.nextInt(3) == 1) {
                    this.doJumpDamage(dx, this.posY + 10.0, dz, 15.0, OreSpawnMain.TheQueen_stats.attack / 2, 1);
                }
                if (this.getHorizontalDistanceSqToEntity(e) > 900.0) {
                    which = this.worldObj.rand.nextInt(2);
                    if (which == 0) {
                        if (this.stream_count > 0) {
                            this.setAttacking(1);
                            rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                            rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5) {
                                this.firecanon(e);
                            }
                        }
                    } else if (this.stream_count_l > 0) {
                        this.setAttacking(1);
                        rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                        rhdir = Math.toRadians((this.rotationYaw + 90.0f) % 360.0f);
                        rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                        if (rdd > pi) {
                            rdd -= pi * 2.0;
                        }
                        rdd = Math.abs(rdd);
                        if (rdd < 0.5) {
                            this.firecanonl(e);
                        }
                    }
                }
            } else {
                this.setAttacking(0);
                this.stream_count = 10;
                this.stream_count_l = 6;
            }
        }
        var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.65 - this.motionX) * 0.35;
        this.motionY += (Math.signum(var2) * 0.69999 - this.motionY) * 0.3;
        this.motionZ += (Math.signum(var3) * 0.65 - this.motionZ) * 0.35;
        var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.75f;
        this.rotationYaw += var5 / 8.0f;
        if (this.worldObj.rand.nextInt(32) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(5.0f);
            if (this.player_hit_count < 10) {
                this.heal(50.0f);
            }
        }
        if (this.player_hit_count < 10 && this.getHealth() < 2000.0f) {
            this.heal(2000.0f - this.getHealth());
        }
    }

    private double getHorizontalDistanceSqToEntity(final Entity e) {
        final double d1 = e.posZ - this.posZ;
        final double d2 = e.posX - this.posX;
        return d1 * d1 + d2 * d2;
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = 14.0;
        final double xzoff = 32.0;
        BetterFireball bf = null;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count > 0) {
            bf = new BetterFireball(
                this.worldObj,
                this,
                e.posX - cx,
                e.posY + e.height / 2.0f - (this.posY + yoff),
                e.posZ - cz);
            bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
            bf.setPosition(cx, this.posY + yoff, cz);
            bf.setReallyBig();
            this.worldObj.playSoundAtEntity(
                this,
                "random.fuse",
                1.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(bf);
            for (int i = 0; i < 6; ++i) {
                final float r1 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r2 = 3.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                final float r3 = 5.0f * (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
                bf = new BetterFireball(
                    this.worldObj,
                    this,
                    e.posX - cx + r1,
                    e.posY + e.height / 2.0f - (this.posY + yoff) + r2,
                    e.posZ - cz + r3);
                bf.setLocationAndAngles(cx, this.posY + yoff, cz, this.rotationYaw, 0.0f);
                bf.setPosition(cx, this.posY + yoff, cz);
                bf.setBig();
                if (this.worldObj.rand.nextInt(2) == 1) {
                    bf.setSmall();
                }
                this.worldObj.playSoundAtEntity(
                    this,
                    "random.bow",
                    1.0f,
                    1.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld(bf);
            }
            --this.stream_count;
        }
    }

    private void firecanonl(final EntityLivingBase e) {
        final double yoff = 14.0;
        final double xzoff = 32.0;
        double var3 = 0.0;
        double var4 = 0.0;
        double var5 = 0.0;
        float var6 = 0.0f;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        if (this.stream_count_l > 0) {
            this.worldObj.playSoundAtEntity(
                this,
                "random.bow",
                1.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            for (int i = 0; i < 3; ++i) {
                final ThunderBolt lb = new ThunderBolt(this.worldObj, cx, this.posY + yoff, cz);
                lb.setLocationAndAngles(cx, this.posY + yoff, cz, 0.0f, 0.0f);
                var3 = e.posX - lb.posX;
                var4 = e.posY + 0.25 - lb.posY;
                var5 = e.posZ - lb.posZ;
                var6 = MathHelper.sqrt_double(var3 * var3 + var5 * var5) * 0.2f;
                lb.setThrowableHeading(var3, var4 + var6, var5, 1.4f, 4.0f);
                final ThunderBolt thunderBolt = lb;
                thunderBolt.motionX *= 3.0;
                final ThunderBolt thunderBolt2 = lb;
                thunderBolt2.motionY *= 3.0;
                final ThunderBolt thunderBolt3 = lb;
                thunderBolt3.motionZ *= 3.0;
                this.worldObj.spawnEntityInWorld(lb);
            }
            --this.stream_count_l;
        }
    }

    protected boolean canTriggerWalking() {
        return true;
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    public boolean doesEntityNotTriggerPressurePlate() {
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        float dm = par2;
        if (this.hurt_timer > 0) {
            return false;
        }
        if (dm > 750.0f) {
            dm = 750.0f;
        }
        if (par1DamageSource.getDamageType()
            .equals("inWall")) {
            return false;
        }
        this.mood = 1;
        if (par1DamageSource.isExplosion()) {
            float s = this.getHealth();
            s += par2 / 2.0f;
            if (s > this.getMaxHealth()) {
                s = this.getMaxHealth();
            }
            this.setHealth(s);
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLivingBase) {
            if (e instanceof PurplePower) {
                return false;
            }
            final float s = e.height * e.width;
            if (e instanceof EntityMob && s < 3.0f) {
                e.setDead();
                return false;
            }
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            this.hurt_timer = 20;
            ret = super.attackEntityFrom(par1DamageSource, dm);
            if (e != null && e instanceof EntityPlayer) {
                ++this.player_hit_count;
            }
            if (e != null && e instanceof EntityLivingBase
                && this.currentFlightTarget != null
                && !MyUtils.isRoyalty(e)) {
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
        return true;
    }

    public int getTotalArmorValue() {
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() * 2 / 3) {
            return OreSpawnMain.TheQueen_stats.defense + 2;
        }
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() / 2) {
            return OreSpawnMain.TheQueen_stats.defense + 3;
        }
        if (this.player_hit_count < 10 && this.getHealth() < this.mygetMaxHealth() / 3) {
            return OreSpawnMain.TheQueen_stats.defense + 5;
        }
        return OreSpawnMain.TheQueen_stats.defense;
    }

    public void onStruckByLightning(final EntityLightningBolt par1EntityLightningBolt) {}

    public void initCreature() {}

    public boolean MyCanSee(final EntityLivingBase e) {
        final double xzoff = 10.0;
        int nblks = 20;
        final double cx = this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYaw));
        final double cz = this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw));
        float startx = (float) cx;
        float starty = (float) (this.posY + 14.0);
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
            if (bid != Blocks.air) {
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
        if (par1EntityLiving instanceof QueenHead) {
            this.head_found = 1;
            return false;
        }
        if (MyUtils.isRoyalty(par1EntityLiving)) {
            return false;
        }
        float d1 = (float) (par1EntityLiving.posX - this.homex);
        final float d2 = (float) (par1EntityLiving.posZ - this.homez);
        d1 = (float) Math.sqrt(d1 * d1 + d2 * d2);
        if (d1 > 144.0f) {
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
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        if (par1EntityLiving instanceof EntityHorse) {
            return true;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityDragon) {
            return true;
        }
        final MyUtils oreSpawnUtils2 = OreSpawnMain.OreSpawnUtils;
        return MyUtils.isAttackableNonMob(par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0 || this.isHappy()) {
            this.head_found = 1;
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(80.0, 60.0, 80.0));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        EntityLivingBase ret = null;
        this.head_found = 0;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false) && ret == null) {
                ret = var8;
            }
            if (ret != null && this.head_found != 0) {
                break;
            }
        }
        return ret;
    }

    public void setGuardMode(final int i) {
        this.guard_mode = i;
    }

    public void setBadMood(final int i) {
        this.always_mad = i;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("KingHomeX", this.homex);
        par1NBTTagCompound.setInteger("KingHomeZ", this.homez);
        par1NBTTagCompound.setInteger("GuardMode", this.guard_mode);
        par1NBTTagCompound.setInteger("PlayerHits", this.player_hit_count);
        par1NBTTagCompound.setInteger("MeanMode", this.always_mad);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.homex = par1NBTTagCompound.getInteger("KingHomeX");
        this.homez = par1NBTTagCompound.getInteger("KingHomeZ");
        this.guard_mode = par1NBTTagCompound.getInteger("GuardMode");
        this.player_hit_count = par1NBTTagCompound.getInteger("PlayerHits");
        this.always_mad = par1NBTTagCompound.getInteger("MeanMode");
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

    private EntityLivingBase doJumpDamage(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (var8 == null) {
                continue;
            }
            if (var8 == this) {
                continue;
            }
            if (!var8.isEntityAlive()) {
                continue;
            }
            if (MyUtils.isRoyalty(var8)) {
                continue;
            }
            if (var8 instanceof Ghost) {
                continue;
            }
            if (var8 instanceof GhostSkelly) {
                continue;
            }
            DamageSource var9 = null;
            var9 = DamageSource.setExplosionSource(null);
            var9.setExplosion();
            var8.attackEntityFrom(var9, (float) damage / 2.0f);
            var8.attackEntityFrom(DamageSource.fall, (float) damage / 2.0f);
            this.worldObj.playSoundAtEntity(
                var8,
                "random.explode",
                0.65f,
                1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
            if (knock == 0) {
                continue;
            }
            final double ks = 2.75;
            final double inair = 0.65;
            final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
            var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return null;
    }
}
