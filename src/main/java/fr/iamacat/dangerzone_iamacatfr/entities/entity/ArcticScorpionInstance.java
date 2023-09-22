
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.*;

public class ArcticScorpionInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int dmgDelay;
    private float moveSpeed;
    private float knockResistance;
    public int atcgothit;
    public int atcmad;
    public int atcnoexplode;

    public ArcticScorpionInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.dmgDelay = 0;
        this.moveSpeed = 0.48f;
        this.knockResistance = 2.75f;
        this.atcgothit = 0;
        this.atcmad = 0;
        this.atcnoexplode = 0;
        this.setSize(4.0f, 2.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 3750;
        this.fireResistance = 100;
        this.renderDistanceWeight = 1.0;
        this.isImmuneToFire = true;
        this.TargetSorter = new GenericTargetSorterInstance(this);
        this.renderdata = new InfoRenderer();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        if (this.renderdata == null) {
            this.renderdata = new InfoRenderer();
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

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(this.knockResistance);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(125.0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        EntityLivingBase e;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        e = this.findSomethingToAttack();
        if (e != null) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                this.posY + 1.25,
                e.posZ,
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()));
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                this.posY + 1.25,
                e.posZ,
                this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()));
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                this.posY + 1.25,
                e.posZ,
                this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(),
                this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(),
                this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                this.posY + 1.25,
                e.posZ,
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()));
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                this.posY + 1.25,
                e.posZ,
                this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat(),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()));
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                this.posY + 1.25,
                e.posZ,
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()),
                (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()));
            final double a = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
        }
    }

    public int mygetMaxHealth() {
        return 650;
    }

    public InfoRenderer getRenderInfo() {
        return this.renderdata;
    }

    public void setRenderInfo(final InfoRenderer r) {
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
        return 23;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    public void onDeathUpdate() {
        super.onDeathUpdate();
        for (int i = 0; i < 30; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj
                .spawnParticle("magicCrit", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
    }

    protected void jump() {
        super.jump();
        this.motionY += 0.25;
        this.posY += 0.5;
    }

    public int getScorpionHealth() {
        return (int) this.getHealth();
    }

    protected String getLivingSound() {
        return "";
    }

    protected String getHurtSound() {
        return "mob.irongolem.hit";
    }

    protected String getDeathSound() {
        return "mob.irongolem.hit";
    }

    protected float getSoundVolume() {
        return 2.5f;
    }

    protected float getSoundPitch() {
        return 0.2f;
    }

    /*
     * protected Item getDropItem() {
     * return (Item)Basic.twiMeat;
     * }
     */

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();
        var3 = new EntityItem(
            this.worldObj,
            this.posX + random.nextInt(3) - random.nextInt(3),
            this.posY + 1.0,
            this.posZ + random.nextInt(3) - random.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        Random random = new Random();
        var3 = new EntityItem(
            this.worldObj,
            this.posX + random.nextInt(3) - random.nextInt(3),
            this.posY + 1.0,
            this.posZ + random.nextInt(3) - random.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(random.nextInt() - this.posZ, random.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        /*
         * this.dropItemRand(Basic.diamondGems, 10);
         * this.dropItemRand(Basic.twilightStar, 8);
         * this.dropItemRand(Basic.auroraGem, 4);
         * int i = 4 + this.worldObj.rand.nextInt(28);
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.balloons, 1);
         * }
         * for (int var4 = 0; var4 < 10; ++var4) {
         * this.dropItemRand(Basic.twilicornBone, 1);
         * }
         * for (int var4 = 0; var4 < 20; ++var4) {
         * this.dropItemRand((Item)Basic.derpMuffin, 1);
         * }
         * i = 4 + this.worldObj.rand.nextInt(16);
         * for (int var4 = 0; var4 < 3; ++var4) {
         * this.dropItemRand(Basic.stinger, 1);
         * }
         * for (int var4 = 0; var4 < 24; ++var4) {
         * this.dropBlockRand(Basic.arcticBlock, 1);
         * }
         * for (int var4 = 0; var4 < 30; ++var4) {
         * this.dropBlockRand(Blocks.packed_ice, 1);
         * }
         * i = 1 + this.worldObj.rand.nextInt(5);
         */
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final double ks = 4.25;
        double inair = 0.45;
        final double pi = 3.14159265359;
        int var2 = 6;
        boolean ret = false;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var3;
            var3 = DamageSource.setExplosionSource(null);
            var3.setExplosion();
            dr.attackEntityFromPart(dr.dragonPartHead, var3, 125.0f);
            ret = true;
        }
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
                    var2 = 12;
                    if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                        var2 = 12;
                    } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                        var2 = 12;
                    }
                }
                if (this.worldObj.rand.nextInt(3) == 1) {
                    ((EntityLivingBase) par1Entity)
                        .addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, var2 * 80, 127));
                }
                final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
            return true;
        }
        return false;
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (this.dmgDelay > 0) {
            return false;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, par2);
            this.dmgDelay = 22;
            final Entity e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLiving) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.2);
            }
            if (e != null && e instanceof EntityPlayer && this.getHealth() < this.getMaxHealth() * 9.0f / 10.0f) {
                this.atcgothit = 1;
            }
        }
        return ret;
    }

    public double getMountedYOffset() {
        return 1.25;
    }

    public double getMountedZOffset() {
        return 1.5;
    }

    protected void updateAITasks() {
        EntityLivingBase e;
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(4) == 0) {
            e = this.getAttackTarget();
            if (e != null && !e.isEntityAlive()) {
                this.setAttackTarget(null);
                e = null;
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.worldObj.rand.nextInt(40) == 1) {
                    this.MagicExplode(e);
                } else {
                    this.Pinch(this.posX, this.posY, this.posZ, 6.5, 125.0, 1);
                }
                this.faceEntity(e, 10.0f, 10.0f);
                this.setAttacking(1);
                if (this.getDistanceSqToEntity(e) < (10.5 + e.width / 2.0f) * (10.5f + e.width / 2.0f)) {
                    this.attackEntityAsMob(e);
                    if (!this.worldObj.isRemote) {
                        if (this.worldObj.rand.nextInt(9) == 1) {
                            this.worldObj.playSoundAtEntity(e, Tags.MODID + ":pincer_a1", 3.0f, 0.8f);
                        } else {
                            this.worldObj.playSoundAtEntity(e, Tags.MODID + ":pincer_a2", 3.0f, 0.8f);
                        }
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.8);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(70) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(2.0f);
        }
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving) {
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == this) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
        if (MobUtils.isPony(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySkeleton) {
            return false;
        }
        if (par1EntityLiving instanceof EntityEnderman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySlime) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityWitch) {
            return false;
        }
        if (par1EntityLiving instanceof EntityBlaze) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCaveSpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGhast) {
            return false;
        }
        if (par1EntityLiving instanceof EntityGolem) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySnowman) {
            return false;
        }
        if (par1EntityLiving instanceof EntityIronGolem) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMagmaCube) {
            return false;
        }
        if (par1EntityLiving instanceof ArcticScorpionInstance) {
            return false;
        }
        if (par1EntityLiving instanceof WindigoInstance) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        return true;
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(48.0, 12.0, 48.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8)) {
                return var8;
            }
        }
        return null;
    }

    public boolean getCanSpawnHere() {
        for (byte k = -6; k < 6; ++k) {
            for (byte j = -5; j < 5; ++j) {
                for (byte i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MyArcticScorpion")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        ArcticScorpionInstance target;
        target = (ArcticScorpionInstance) this.worldObj
            .findNearestEntityWithinAABB(ArcticScorpionInstance.class, this.boundingBox.expand(64.0, 32.0, 64.0), this);
        return target == null;
    }

    private EntityLivingBase Pinch(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()
                && !(var8 instanceof ArcticScorpionInstance)
                && !(var8 instanceof WindigoInstance)
                && !(var8 instanceof DarknessInstance)) {
                DamageSource var9;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, 175.0f);
                var8.attackEntityFrom(DamageSource.inWall, 175.0f);
                final double ks = 4.25;
                final double inair = 0.45;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private void MagicExplode(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 2250.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), var2);
        this.doExplodeDamage(e.posX, e.posY, e.posZ, 5.0, 2250.0, 0);
        this.worldObj.playSoundAtEntity(
            (Entity) e,
            "random.explode",
            0.5f,
            1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
            this.worldObj
                .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY - 16.0, e.posZ));
        }
    }

    private EntityLivingBase doExplodeDamage(final double X, final double Y, final double Z, final double dist,
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
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()
                && !(var8 instanceof WindigoInstance)
                && !(var8 instanceof DarknessInstance)) {
                DamageSource var9;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage);
                var8.attackEntityFrom(DamageSource.magic, (float) damage);
                this.worldObj.playSoundAtEntity(
                    var8,
                    "random.explode",
                    2.25f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 0.0;
                final double inair = 0.0;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("HitByPlayer", this.atcgothit);
        par1NBTTagCompound.setInteger("MadToday", this.atcmad);
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.atcgothit = par1NBTTagCompound.getInteger("HitByPlayer");
        this.atcmad = par1NBTTagCompound.getInteger("MadToday");
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }
}
