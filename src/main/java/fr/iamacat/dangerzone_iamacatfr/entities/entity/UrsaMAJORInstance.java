
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class UrsaMAJORInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private float moveSpeed;
    private int dmgDelay;
    private int jumped;
    private int jump_timer;
    private int ticker;
    private InfoRenderer renderdata;
    private int stream_count;
    private EntityAIWander wander;
    private int head_found;

    public UrsaMAJORInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.75f;
        this.dmgDelay = 0;
        this.jumped = 0;
        this.jump_timer = 0;
        this.ticker = 0;
        this.renderdata = new InfoRenderer();
        this.stream_count = 8;
        this.wander = null;
        this.head_found = 0;
        this.setSize(16.0f, 35.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 10000;
        this.renderDistanceWeight = 16.0;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.wander = new EntityAIWander(this, 1.0);
        this.tasks.addTask(2, this.wander);
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityLiving.class, 50.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.fireResistance = 10000;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, 0);
        // this.dataWatcher.addObject(21, (Object)Basic.Snap);
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
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1650.0);
    }

    public int getPlayNicely() {
        return this.dataWatcher.getWatchableObjectInt(21);
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

    /*
     * protected boolean canDespawn() {
     * return !this.isNoDespawnRequired() && Basic.Snap != 0;
     * }
     */

    public int mygetMaxHealth() {
        return 12750;
    }

    public int getTotalArmorValue() {
        return 23;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        final double xzoff = 0.0;
        final double myoff = 20.0;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
        if (this.isAirBorne) {
            this.getNavigator()
                .setPath((PathEntity) null, 0.0);
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected String getLivingSound() {
        return Tags.MODID + ":ursaroar";
    }

    protected String getHurtSound() {
        return "random.anvil_land";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":ursaroar";
    }

    protected float getSoundVolume() {
        return 5.65f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected int getDropItemId() {
        return 0;
    }

    protected void jump() {
        while (this.rotationYaw < 0.0f) {
            this.rotationYaw += 360.0f;
        }
        while (this.rotationYawHead < 0.0f) {
            this.rotationYawHead += 360.0f;
        }
        while (this.rotationYaw > 360.0f) {
            this.rotationYaw -= 360.0f;
        }
        while (this.rotationYawHead > 360.0f) {
            this.rotationYawHead -= 360.0f;
        }
        this.motionY += 0.449999988079071;
        this.posY += 0.5;
        final float f = 0.2f + Math.abs(this.worldObj.rand.nextFloat() * 0.45f);
        this.motionX += f * Math.cos(Math.toRadians(this.rotationYawHead + 90.0f));
        this.motionZ += f * Math.sin(Math.toRadians(this.rotationYawHead + 90.0f));
        this.isAirBorne = true;
        this.getNavigator()
            .setPath((PathEntity) null, 0.0);
    }

    protected void jumpAtEntity(final EntityLivingBase e) {
        this.motionY += 1.25;
        this.posY += 1.549999952316284;
        double d1 = e.posX - this.posX;
        final double d2 = e.posZ - this.posZ;
        final float d3 = (float) Math.atan2(d2, d1);
        final float f2 = (float) (d3 * 180.0 / 3.141592653589793) - 90.0f;
        this.rotationYaw = f2;
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        this.motionX += d1 * 0.05 * Math.cos(d3);
        this.motionZ += d1 * 0.05 * Math.sin(d3);
        this.isAirBorne = true;
        this.getNavigator()
            .setPath((PathEntity) null, 0.0);
    }

    private double getHorizontalDistanceSqToEntity(final Entity e) {
        final double d1 = e.posZ - this.posZ;
        final double d2 = e.posX - this.posX;
        return d1 * d1 + d2 * d2;
    }

    public double MygetDistanceSqToEntity(final Entity par1Entity) {
        final double d0 = this.posX - par1Entity.posX;
        double d2 = par1Entity.posY - this.posY;
        final double d3 = this.posZ - par1Entity.posZ;
        if (d2 > 0.0 && d2 < 20.0) {
            d2 = 0.0;
        }
        if (d2 > 20.0) {
            d2 -= 10.0;
        }
        return d0 * d0 + d2 * d2 + d3 * d3;
    }

    protected void updateAITasks() {
        EntityLivingBase e = null;
        int xzrange = 9;
        if (this.isDead) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        // this.dataWatcher.updateObject(21, (Object)Basic.Snap);
        super.updateAITasks();
        ++this.ticker;
        if (this.ticker > 30000) {
            this.ticker = 0;
        }
        if (this.ticker % 100 == 0) {
            this.stream_count = 8;
        }
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (this.jump_timer > 0) {
            --this.jump_timer;
        }
        // Basic.hydraspawned = 1;
        if (this.worldObj.rand.nextInt(200) == 0) {
            this.setAttackTarget((EntityLivingBase) null);
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            if (this.motionY < -0.95) {
                this.jumped = 1;
            }
            if (this.motionY < -1.5) {
                this.jumped = 2;
            }
            if (this.jumped != 0 && this.motionY > -0.1) {
                double df = 1.0;
                if (this.jumped == 2) {
                    df = 5.5;
                }
                this.doJumpDamage(this.posX, this.posY, this.posZ, 50.0, 1650.0 * df, 0);
                this.doJumpDamage(this.posX, this.posY, this.posZ, 75.0, 3300.0 * df, 0);
                this.doJumpDamage(this.posX, this.posY, this.posZ, 125.0, 6600.0 * df, 0);
                this.jumped = 0;
            }
        }
        xzrange = 12;
        if (this.getAttacking() != 0) {
            xzrange = 16;
        }
        int k = -3 + this.ticker % 30;
        /*
         * if (Basic.Snap == 0) {
         * for (int i = -xzrange; i <= xzrange; ++i) {
         * for (int j = -xzrange; j <= xzrange; ++j) {
         * final Block bid = this.worldObj.getBlock((int)this.posX + i, (int)this.posY + k, (int)this.posZ + j);
         * }
         * }
         * }
         */
        final double dx = this.posX + 64.0 * Math.sin(Math.toRadians(this.rotationYawHead));
        final double dz = this.posZ - 64.0 * Math.cos(Math.toRadians(this.rotationYawHead));
        k = -3 + this.ticker % 12;
        /*
         * if (Basic.Snap == 0) {
         * for (int l = -xzrange; l <= xzrange; ++l) {
         * for (int m = -xzrange; m <= xzrange; ++m) {}
         * }
         * }
         * if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && Basic.Snap == 0 && k == 0 &&
         * this.worldObj.rand.nextInt(6) == 1) {
         * this.doJumpDamage(this.posX, this.posY, this.posZ, 180.0, 825.0, 1);
         * }
         */
        if (this.worldObj.rand.nextInt(5) == 1) {
            e = this.getAttackTarget();
            /*
             * if (Basic.Snap != 0) {
             * e = null;
             * }
             */
            if (e != null) {
                if (!e.isEntityAlive()) {
                    this.setAttackTarget(null);
                    e = null;
                } else if (e instanceof UrsaMAJORInstance) {
                    this.setAttackTarget(null);
                    e = null;
                }
            }
            if (e != null) {
                // this.wander.setBusy(1);
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.worldObj.rand.nextInt(65) == 1 && this.MygetDistanceSqToEntity((Entity) e) > 300.0) {
                    this.doLightningAttack(e);
                } else if (this.worldObj.rand.nextInt(20) == 1 && this.jump_timer == 0) {
                    this.jumpAtEntity(e);
                    this.jump_timer = 10;
                } else if (this.MygetDistanceSqToEntity((Entity) e) < 700.0f + e.width / 6.0f * (e.width / 2.0f)) {
                    this.setAttacking(1);
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.0);
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(3) == 1) {
                        this.attackEntityAsMob((Entity) e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving((Entity) e, 1.0);
                    if (this.getHorizontalDistanceSqToEntity((Entity) e) > 625.0) {
                        if (this.stream_count > 0) {
                            this.setAttacking(1);
                            final double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            final double rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                            final double pi = 3.1415926545;
                            double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5) {}
                        } else {
                            this.setAttacking(0);
                        }
                    } else {
                        this.setAttacking(0);
                    }
                }
            } else {
                this.setAttacking(0);
                // this.wander.setBusy(0);
                this.stream_count = 8;
            }
        }
        if (this.worldObj.rand.nextInt(15) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(6.0f);
        }
        if (this.worldObj.rand.nextInt(10) == 1 && this.getHealth() < 150.0f) {
            this.heal(100.0f - this.getHealth());
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
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
        if (MobUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof UrsaMAJORInstance) {
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

    private boolean isVillagerTarget(final EntityLivingBase par1EntityLiving, final boolean par2) {
        return this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && par1EntityLiving != null
            && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee((Entity) par1EntityLiving)
            && par1EntityLiving instanceof EntityVillager;
    }

    private EntityLivingBase doJumpDamage(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 30.0, Z - dist, X + dist, Y + 30.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()
                && !(var8 instanceof UrsaMAJORInstance)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage);
                var8.attackEntityFrom(DamageSource.fall, (float) damage);
                if (knock == 0) {
                    continue;
                }
                final double ks = 3.5;
                final double inair = 0.75;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * this.head_found = 1;
         * return null;
         * }
         */
        List var5 = null;
        Iterator var6 = null;
        Entity var7 = null;
        EntityLivingBase var8 = null;
        EntityLivingBase ret = null;
        int vf = 0;
        var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(64.0, 40.0, 64.0));
        if (var5 == null) {
            return null;
        }
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        var6 = var5.iterator();
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (vf == 0 && this.isVillagerTarget(var8, false)) {
                ret = var8;
                vf = 1;
            }
            if (ret == null && vf == 0 && this.isSuitableTarget(var8, false)) {
                ret = var8;
            }
        }
        return ret;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.550000011920929, 0.6499999761581421, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    private ItemStack dropBlockRand(final Block index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.550000011920929, 0.6499999761581421, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = 19.0;
        final double xzoff = 22.0;
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
            bf.setBig();
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.fuse",
                1.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity) bf);
            for (int i = 0; i < 5; ++i) {
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
                if (this.worldObj.rand.nextInt(2) == 1) {
                    bf.setSmall();
                }
                this.worldObj.playSoundAtEntity(
                    (Entity) this,
                    "random.bow",
                    4.0f,
                    4.0f / (this.getRNG()
                        .nextFloat() * 0.4f + 0.8f));
                this.worldObj.spawnEntityInWorld((Entity) bf);
            }
            --this.stream_count;
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final float s = par1Entity.height * par1Entity.width;
            if (s > 50.0f && !MobUtils.isPony(par1Entity)
                && !(par1Entity instanceof HydraInstance)
                && !(par1Entity instanceof SpikezillaInstance)
                && !(par1Entity instanceof UrsaMAJORInstance)
                && !(par1Entity instanceof WindigoInstance)) {
                final EntityLivingBase e = (EntityLivingBase) par1Entity;
                final double xzoff = 10.0;
                final double yoff = 14.0;
                e.setHealth(e.getHealth() / 32.0f - 25750.0f);
                e.setHealth(e.getHealth() / 32.0f - 25750.0f);
                e.setDead();
            }
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource((Explosion) null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(6) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 3300.0f);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 3300.0f);
            }
        }
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 7.2;
                double inair = 6.3;
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
        float dm = par2;
        float s = 0.0f;
        if (this.dmgDelay > 0) {
            return false;
        }
        if (dm > 1750.0f) {
            dm = 1750.0f;
        }
        Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLivingBase) {
            final EntityLivingBase enl = (EntityLivingBase) e;
            s = enl.height * enl.width;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, dm);
            this.dmgDelay = 1;
            e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase && !(e instanceof UrsaMAJORInstance)) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving((Entity) e, 1.2);
            }
        }
        return ret;
    }

    public void onStruckByLightning(final EntityLightningBolt par1EntityLightningBolt) {}

    private void doLightningAttack(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 100.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase) this), var2);
        e.setFire(5);
        for (int var3 = 0; var3 < 20; ++var3) {
            this.worldObj.spawnParticle(
                "witchMagic",
                e.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posZ + this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "witchMagic",
                e.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "witchMagic",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
        }
        this.worldObj.playSoundAtEntity(
            (Entity) e,
            "random.explode",
            0.5f,
            1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion(
                (Entity) this,
                e.posX,
                e.posY,
                e.posZ,
                12.0f,
                this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing"));
        }
        this.worldObj.addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, e.posX, e.posY + 1.0, e.posZ));
        this.worldObj
            .addWeatherEffect((Entity) new EntityLightningBolt(this.worldObj, this.posX, this.posY + 15.0, this.posZ));
    }

    private EntityLivingBase getFucked(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 20.0, Z - dist, X + dist, Y + 20.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()
                && !(var8 instanceof UrsaMAJORInstance)) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource((Explosion) null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.inWall, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.drown, (float) damage / 1.2f);
                var8.attackEntityFrom(DamageSource.lava, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.outOfWorld, (float) damage / 1650.0f);
                this.worldObj.playSoundAtEntity(
                    (Entity) var8,
                    "random.explode",
                    2.25f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final int mx = 60;
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                this.worldObj.spawnParticle(
                    "fireworksSpark",
                    this.posX,
                    this.posY,
                    this.posZ,
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian(),
                    this.worldObj.rand.nextGaussian());
                final double ks = 5.75;
                final double inair = 0.45;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        final ItemStack is = null;
        /*
         * this.dropItemRand(Basic.twilightStar, 1);
         * this.dropItemRand(Basic.ursaClaws, 1);
         * this.dropItemRand(Basic.ursaClaws, 1);
         * for (int var5 = 50 + this.worldObj.rand.nextInt(30), var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand(Basic.yoshiSword, 1);
         * }
         * for (int var5 = 100 + this.worldObj.rand.nextInt(160), var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand(Basic.bowserRod, 1);
         * }
         * for (int var5 = 50 + this.worldObj.rand.nextInt(60), var6 = 0; var6 < var5; ++var6) {
         * this.dropBlockRand(Basic.robotBlock, 1);
         * }
         */
        for (int i = 25 + this.worldObj.rand.nextInt(15), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.worldObj.rand.nextInt(80);
        }
    }

    @SideOnly(Side.CLIENT)
    public static class RenderTheMob21 extends RenderLiving {

        private static final ResourceLocation twibeartexture;

        public RenderTheMob21(final ModelBase par1ModelBase, final float par2) {
            super(par1ModelBase, par2);
        }

        protected ResourceLocation getEntityTexture(final Entity entity) {
            return RenderTheMob21.twibeartexture;
        }

        static {
            twibeartexture = new ResourceLocation(Tags.MODID + ":" + "textures/entity/ursamajor.png");
        }
    }
}
