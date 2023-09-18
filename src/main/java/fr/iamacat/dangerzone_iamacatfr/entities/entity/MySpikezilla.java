
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MySpikezilla extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private int dmgDelay;
    private int jumped;
    private int jump_timer;
    private int ticker;
    private RenderInfo renderdata;
    private int stream_count;
    private EntityAIWander wander;
    private int head_found;
    private int largemob;

    public MySpikezilla(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.75f;
        this.dmgDelay = 0;
        this.jumped = 0;
        this.jump_timer = 0;
        this.ticker = 0;
        this.renderdata = new RenderInfo();
        this.stream_count = 8;
        this.wander = null;
        this.head_found = 0;
        this.largemob = 0;
        /*
         * if (Basic.Snap == 0) {
         this.setSize(8.0f, 35.0f);
         * }
         */
        this.setSize(8.0f, 35.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 25000;
        this.tasks.addTask(0, new EntityAISwimming( this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage( this, 1.0, false));
        this.wander = new EntityAIWander( this, 1.0);
        this.tasks.addTask(2, this.wander);
        this.tasks.addTask(4, new EntityAILookIdle( this));
        this.tasks.addTask(5, new EntityAIWander( this, 1.0));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget( this, false));
        this.TargetSorter = new GenericTargetSorter(this);
        this.fireResistance = 10000;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(350.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(10.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (byte)0);
        // this.dataWatcher.addObject(21, Basic.Snap);
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

    public int getPlayNicely() {
        return this.dataWatcher.getWatchableObjectInt(21);
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

    protected boolean canDespawn() {
        return this.isNoDespawnRequired() && false;
    }

    public int mygetMaxHealth() {
        return 7250;
    }

    public int getTotalArmorValue() {
        return 22;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        final double xzoff = 0.0;
        final double myoff = 20.0;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (this.isAirBorne) {
            this.getNavigator()
                .setPath(null, 0.0);
        }
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected void fall(final float par1) {}

    protected void updateFallState(final double par1, final boolean par3) {}

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(10) == 0) {
            return Tags.MODID + ":bosshurt";
        }
        return Tags.MODID + ":bosshurt";
    }

    protected String getHurtSound() {
        return "mob.enderdragon.growl";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":fanfare";
    }

    protected float getSoundVolume() {
        return 2.75f;
    }

    protected float getSoundPitch() {
        return 0.5f;
    }

    protected int getDropItemId() {
        return 0;
    }

    private void holdTheLine(final List<Entity> par1, final Entity par2) {
        final double CenterX = this.boundingBox.minX + this.boundingBox.maxX;
        final double CenterY = this.boundingBox.minZ + this.boundingBox.maxZ;
        for (final Entity e : par1) {
            if (e instanceof EntityLivingBase) {
                final double dX = e.posX - CenterX;
                final double dZ = e.posZ - CenterY;
                final double sqDist = dX * dX + dZ * dZ;
                e.addVelocity(dX / sqDist, 0.20000000298023224, dZ / sqDist);
            }
        }
    }

    protected void Jump() {
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
        this.motionY += 0.649;
        this.posY += 0.3;
        final float f = 0.6f + Math.abs(this.worldObj.rand.nextFloat() * 0.45f);
        this.motionX += f * Math.cos(Math.toRadians(this.rotationYawHead + 90.0f));
        this.motionZ += f * Math.sin(Math.toRadians(this.rotationYawHead + 90.0f));
        this.isAirBorne = true;
        this.doJumpDamage(this.posX, this.posY, this.posZ, 7.5, 425.0, 3);
        this.getNavigator()
            .setPath((PathEntity) null, 0.0);
    }

    protected void jumpAtEntity(final EntityLivingBase e) {
        this.motionY += 1.25;
        this.posY += 0.38;
        double d1 = e.posX - this.posX;
        final double d2 = e.posZ - this.posZ;
        final float d3 = (float) Math.atan2(d2, d1);
        final float f2 = (float) (d3 * 180.0 / 3.141592653589793) - 90.0f;
        this.rotationYaw = f2;
        d1 = Math.sqrt(d1 * d1 + d2 * d2);
        this.motionX += d1 * 0.05 * Math.cos(d3);
        this.motionZ += d1 * 0.35 * Math.sin(d3);
        this.isAirBorne = true;
        this.doJumpDamage(this.posX, this.posY, this.posZ, 7.5, 425.0, 1);
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
        if (this.motionY > 2.0) {
            this.motionY /= 3.0;
        }
        if (this.motionX > 2.0) {
            this.motionX /= 3.0;
        }
        if (this.motionZ > 2.0) {
            this.motionZ /= 3.0;
        }
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
        if (this.worldObj.rand.nextInt(200) == 0) {
            this.setAttackTarget(null);
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
            if (this.motionY < -0.95) {
                this.jumped = 1;
            }
            if (this.motionY > -0.95) {
                this.jumped = 2;
            }
            if (this.motionY < -1.5) {
                this.jumped = 2;
            }
            if (this.jumped != 0 && this.motionY > -0.1) {
                double df = 1.0;
                if (this.jumped == 2) {
                    df = 1.5;
                }
                this.doJumpDamage(this.posX, this.posY, this.posZ, 25.0, 350.0 * df, 1);
                this.doJumpDamage(this.posX, this.posY, this.posZ, 25.0, 450.0 * df, 1);
                this.doJumpDamage(this.posX, this.posY, this.posZ, 25.0, 650.0 * df, 2);
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
        final double dx = this.posX + 16.0 * Math.sin(Math.toRadians(this.rotationYawHead));
        final double dz = this.posZ - 16.0 * Math.cos(Math.toRadians(this.rotationYawHead));
        k = -3 + this.ticker % 12;
        /*
         * if (Basic.Snap == 0) {
         * for (int l = -xzrange; l <= xzrange; ++l) {
         * for (int m = -xzrange; m <= xzrange; ++m) {
         * final Block bid2 = this.worldObj.getBlock((int)dx + l, (int)this.posY + k, (int)dz + m);
         * }
         * }
         * }
         */
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && k == 0
            && this.worldObj.rand.nextInt(3) == 1) {
            this.doJumpDamage(dx, this.posY, this.posZ, 16.5, 355.0, 2);
        }
        if (this.worldObj.rand.nextInt(5 - this.largemob) == 1) {
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
                } else if (e instanceof MySpikezilla) {
                    this.setAttackTarget(null);
                    e = null;
                }
            }
            if (e == null) {
                e = this.findSomethingToAttack();
            }
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.2);
                this.setAttacking((byte) 1);
                if (this.worldObj.rand.nextInt() == 1) {
                    this.doJumpDamage(dx, this.posY, this.posZ, 16.5, 355.0, 2);
                }
                if (this.worldObj.rand.nextInt(6) == 1) {
                    this.faceEntity(e, 10.0f, 10.0f);
                    this.strikeTheGround(e);
                    this.MeteorStrike(e);
                    this.MagicCannon(e);
                    this.PhoenixFlame(e);
                } else if (this.worldObj.rand.nextInt(20 - this.largemob * 10) == 1 && this.jump_timer == 0) {
                    this.jumpAtEntity(e);
                    this.doJumpDamage(dx, this.posY, this.posZ, 16.5, 355.0, 1);
                    this.MagicCannon(e);
                    this.jump_timer = 20;
                } else if (this.MygetDistanceSqToEntity(e) < 300.0) {
                    this.setAttacking((byte) 1);
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.0);
                    if (this.worldObj.rand.nextInt(4 - this.largemob) == 0
                        || this.worldObj.rand.nextInt(3 - this.largemob) == 1) {
                        this.attackEntityAsMob(e);
                        final float s = e.height * e.width;
                        if (s > 50.0f && !(e instanceof MySpikezilla)
                            && !(e instanceof MyMLPHydra)
                            && !(e instanceof MyWindigo)
                            && !(e instanceof MyCrabzilla)
                            && !(e instanceof MyUrsaMAJOR)) {
                            e.setDead();
                            e.setHealth(0.0f);
                        }
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.0);
                    if (this.getHorizontalDistanceSqToEntity(e) > 625.0) {
                        if (this.stream_count > 0) {
                            this.setAttacking((byte) 1);
                            final double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                            final double rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                            final double pi = 3.1415926545;
                            double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                            if (rdd > pi) {
                                rdd -= pi * 2.0;
                            }
                            rdd = Math.abs(rdd);
                            if (rdd < 0.5) {
                                this.faceEntity(e, 10.0f, 10.0f);
                                this.MeteorStrike(e);
                                this.MagicCannon(e);
                                this.PhoenixFlame(e);
                                if (this.worldObj.rand.nextInt(18 - this.largemob * 10) == 1 && this.jump_timer == 0) {
                                    this.jumpAtEntity(e);
                                    this.doJumpDamage(dx, this.posY, this.posZ, 16.5, 355.0, 1);
                                    this.jump_timer = 10;
                                }
                            }
                            if (rdd < 2.0) {
                                this.faceEntity(e, 10.0f, 10.0f);
                                this.PhoenixFlame(e);
                                this.WindyMagic(e);
                            }
                            if (rdd < 0.1) {
                                this.faceEntity(e, 10.0f, 10.0f);
                                this.MagicCannon(e);
                                this.WindyMagic(e);
                            }
                        } else {
                            this.setAttacking((byte) 0);
                        }
                    } else {
                        this.setAttacking((byte) 0);
                    }
                }
            } else {
                this.setAttacking((byte) 0);
                this.stream_count = 8;
            }
        }
        if (this.worldObj.rand.nextInt(10) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(2.0f);
        }
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
        if (par1EntityLiving instanceof MySpikezilla) {
            return true;
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
                .canSee(par1EntityLiving)
            && par1EntityLiving instanceof EntityVillager;
    }

    private EntityLivingBase doJumpDamage(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB( EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()) {
                DamageSource var9;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage);
                var8.attackEntityFrom(DamageSource.inWall, (float) damage);
                final double ks = 0.05;
                final double inair = 0.05;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private EntityLivingBase justStandThere(final double X, final double Y, final double Z, final double dist,
        final double damage, final int knock) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(X - dist, Y - 10.0, Z - dist, X + dist, Y + 10.0, Z + dist);
        final List var5 = this.worldObj.getEntitiesWithinAABB( EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && var8 != this
                && var8.isEntityAlive()) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage);
                var8.attackEntityFrom(DamageSource.inWall, (float) damage);
                final double ks = 1.25;
                final double inair = -0.5;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    private EntityLivingBase findSomethingToAttack() {
        List var5 = null;
        Iterator var6 = null;
        Entity var7 = null;
        EntityLivingBase var8 = null;
        EntityLivingBase ret = null;
        int vf = 0;
        var5 = this.worldObj
            .getEntitiesWithinAABB( EntityLivingBase.class, this.boundingBox.expand(64.0, 0.0, 64.0));
        if (var5 == null) {
            return null;
        }
        Collections.sort((List<Object>) var5, this.TargetSorter);
        var6 = var5.iterator();
        this.head_found = 0;
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

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (this.worldObj.rand.nextInt(60) != 1) {
            return false;
        }
        for (int k = -8; k < 8; ++k) {
            for (int j = -8; j < 8; ++j) {
                for (int i = 5; i < 10; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MySpikezilla")) {
                            return true;
                        }
                    }
                }
            }
        }
        MySpikezilla target;
        target = (MySpikezilla) this.worldObj.findNearestEntityWithinAABB(
             MySpikezilla.class,
            this.boundingBox.expand(72.0, 36.0, 72.0),
            this);
        return target == null;
    }

    public final byte getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public final void setAttacking(byte par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 ;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + rand.nextInt(3) - rand.nextInt(3),
            this.posY + 1.0,
            this.posZ + rand.nextInt(3) - rand.nextInt(3),
            is);
        final float f3 = (float) Math.atan2(rand.nextInt() - this.posZ, rand.nextInt() - this.posX);
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
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
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    private void MeteorStrike(final EntityLivingBase e) {
        final double yoff = 65.0;
        final double xzoff = 18.0;
        if (this.rand.nextInt(10) == 1) {
            final FireCannon var2 = new FireCannon(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                this.rotationYaw,
                this.rotationPitch);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var2);
        }
        for (int i = 0; i < 25; ++i) {
            final FireCannon var3 = new FireCannon(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var3.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                this.rotationYawHead,
                this.rotationPitch);
            final double var4 = e.posX - var3.posX;
            final double var5 = e.posY + 0.25 - var3.posY;
            final double var6 = e.posZ - var3.posZ;
            final float var7 = MathHelper.sqrt_double(var4 * var4 + var6 * var6) * 0.2f;
            var3.setThrowableHeading(var4, var5 + var7, var6, 2.5f, 25.5f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var3);
        }
    }

    private void MagicCannon(final EntityLivingBase e) {
        final double yoff = 52.0;
        final double xzoff = 20.0 - this.rand.nextInt(4);
        if (this.rand.nextInt(2) == 1) {
            final MavisBall var2 = new MavisBall(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                this.rotationYaw,
                this.rotationPitch);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld((Entity) var2);
        }
        for (int i = 0; i < 30; ++i) {
            final MavisBall var3 = new MavisBall(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var3.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                this.rotationYawHead,
                this.rotationPitch);
            final double var4 = e.posX - var3.posX;
            final double var5 = e.posY + 0.25 - var3.posY;
            final double var6 = e.posZ - var3.posZ;
            final float var7 = MathHelper.sqrt_double(var4 * var4 + var6 * var6) * 0.2f;
            var3.setThrowableHeading(var4, var5 + var7, var6, 2.5f, 27.5f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var3);
        }
    }

    private void PhoenixFlame(final EntityLivingBase e) {
        final double yoff = 58.0;
        final double xzoff = 20.0;
        if (this.rand.nextInt(10) == 1) {
            final PhoenixArrow var2 = new PhoenixArrow(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                this.rotationYaw,
                this.rotationPitch);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var2);
        }
        for (int i = 0; i < 10; ++i) {
            final PhoenixArrow var3 = new PhoenixArrow(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var3.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                this.rotationYawHead,
                this.rotationPitch);
            final double var4 = e.posX - var3.posX;
            final double var5 = e.posY + 0.25 - var3.posY;
            final double var6 = e.posZ - var3.posZ;
            final float var7 = MathHelper.sqrt_double(var4 * var4 + var6 * var6) * 0.2f;
            var3.setThrowableHeading(var4, var5 + var7, var6, 2.5f, 25.5f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var3);
        }
    }

    private void WindyMagic(final EntityLivingBase e) {
        final double yoff = 58.0;
        final double xzoff = 22.0;
        if (this.rand.nextInt(10) == 1) {
            final WindigoPower var2 = new WindigoPower(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var2.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYawHead)),
                this.rotationYaw,
                this.rotationPitch);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.bow",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var2);
        }
        for (int i = 0; i < 1; ++i) {
            final WindigoPower var3 = new WindigoPower(
                this.worldObj,
                e.posX - this.posX,
                e.posY + 0.75 - (this.posY + yoff),
                e.posZ - this.posZ);
            var3.setLocationAndAngles(
                this.posX - xzoff * Math.sin(Math.toRadians(this.rotationYawHead)),
                this.posY + yoff,
                this.posZ + xzoff * Math.cos(Math.toRadians(this.rotationYaw)),
                this.rotationYawHead,
                this.rotationPitch);
            final double var4 = e.posX - var3.posX;
            final double var5 = e.posY + 0.25 - var3.posY;
            final double var6 = e.posZ - var3.posZ;
            final float var7 = MathHelper.sqrt_double(var4 * var4 + var6 * var6) * 0.2f;
            var3.setThrowableHeading(var4, var5 + var7, var6, 2.5f, 25.5f);
            this.worldObj.playSoundAtEntity(
                (Entity) this,
                "random.explode",
                0.75f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(var3);
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity instanceof EntityLivingBase) {
            final float s = par1Entity.height * par1Entity.width;
            final EntityLivingBase e = (EntityLivingBase) par1Entity;
            if (s > 50.0f && !(par1Entity instanceof MySpikezilla)
                && !(par1Entity instanceof MyMLPHydra)
                && !(par1Entity instanceof MyWindigo)
                && !(par1Entity instanceof MyCrabzilla)
                && !(par1Entity instanceof MyUrsaMAJOR)) {
                e.setDead();
                e.setHealth(0.0f);
            }
            if (s > 50.0f && !MobUtils.isPony(par1Entity)
                && !(par1Entity instanceof MySpikezilla)
                && !(par1Entity instanceof MyMLPHydra)
                && !(par1Entity instanceof MyUrsaMAJOR)
                && !(par1Entity instanceof MyWindigo)) {
                final double xzoff = 10.0;
                final double yoff = 14.0;
                e.setHealth(e.getHealth() / 32.0f - 25750.0f);
                e.setHealth(e.getHealth() / 32.0f - 25750.0f);
                e.setDead();
            }
        }
        if (par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource((Explosion) null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(2) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartHead, var21, 350.0f);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 350.0f);
                dr.attackEntityFromPart(dr.dragonPartBody, var21, 350.0f);
            }
        }
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity instanceof EntityLivingBase) {
                final double ks = 3.25;
                double inair = 1.75;
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
        if (dm > 2000.0f) {
            dm = 2000.0f;
        }
        Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLivingBase) {
            final EntityLivingBase enl = (EntityLivingBase) e;
            s = enl.height * enl.width;
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, dm);
            this.dmgDelay = 25;
            e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase && !(e instanceof MySpikezilla)) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.2);
            }
        }
        return ret;
    }

    public void onStruckByLightning(final EntityLightningBolt par1EntityLightningBolt) {}

    private void strikeTheGround(final EntityLivingBase e) {
        if (e == null) {
            return;
        }
        final float var2 = 750.0f;
        e.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
        e.setFire(30);
        for (int var3 = 0; var3 < 20; ++var3) {
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
            this.worldObj.spawnParticle(
                "fireworksSpark",
                e.posX,
                e.posY,
                e.posZ,
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian(),
                this.worldObj.rand.nextGaussian());
        }
        this.worldObj.playSoundAtEntity(
            e,
            "random.explode",
            0.5f,
            1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
        if (!this.worldObj.isRemote) {
            this.worldObj.createExplosion(
                this,
                e.posX,
                e.posY,
                e.posZ,
                16.5f,
                this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing"));
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largerflame",
                this.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                this.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
        }
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        ItemStack is = null;
        this.dropItemRand(Items.blaze_rod, 1);
        /*
         * for (int var5 = 50 + this.worldObj.rand.nextInt(30), var6 = 0; var6 < var5; ++var6) {
         * this.dropBlockRand(Basic.hardAppleBlock, 1);
         * }
         */
        int var5 = 100 + this.worldObj.rand.nextInt(160);
        /*
         * for (int var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand(Basic.twilightStar, 1);
         * }
         * for (int var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand(Basic.twilightStar, 1);
         * }
         * for (int var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand(Basic.twilightStar, 1);
         * }
         */
        var5 = 50 + this.worldObj.rand.nextInt(60);
        /*
         * for (int var6 = 0; var6 < var5; ++var6) {
         * this.dropItemRand((Item)Basic.hardApple, 1);
         * }
         */
        for (int i = 25 + this.worldObj.rand.nextInt(15), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.worldObj.rand.nextInt(80);
            switch (var7) {
                case 0: {
                    // is = this.dropItemRand(Basic.alicornSword, 1);
                    break;
                }
                case 1: {
                    // is = this.dropItemRand(Basic.twilicornItem, 1);
                    break;
                }
            }
        }
    }
}
