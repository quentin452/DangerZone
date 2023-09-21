
package danger.orespawn.entities.entityinstance;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWanderALot;
import danger.orespawn.entities.renderer.RenderInfo;
import danger.orespawn.utils.GenericTargetSorter;
import danger.orespawn.utils.MyUtils;

public class Godzilla extends EntityMob {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private int hurt_timer;
    private int jumped;
    private int jump_timer;
    private int ticker;
    private RenderInfo renderdata;
    private int stream_count;
    private MyEntityAIWanderALot wander;
    private int head_found;
    private int large_unknown_detected;

    public Godzilla(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.75f;
        this.hurt_timer = 0;
        this.jumped = 0;
        this.jump_timer = 0;
        this.ticker = 0;
        this.renderdata = new RenderInfo();
        this.stream_count = 8;
        this.wander = null;
        this.head_found = 0;
        this.large_unknown_detected = 0;
        if (OreSpawnMain.PlayNicely == 0) {
            this.setSize(9.9f, 25.0f);
        } else {
            this.setSize(2.475f, 6.25f);
        }
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 10000;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.wander = new MyEntityAIWanderALot(this, 15, 1.0);
        this.tasks.addTask(2, this.wander);
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityLiving.class, 50.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
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
            .setBaseValue(OreSpawnMain.Godzilla_stats.attack);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.dataWatcher.addObject(21, (Object) OreSpawnMain.PlayNicely);
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
        return !this.isNoDespawnRequired() && OreSpawnMain.PlayNicely != 0;
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.Godzilla_stats.health;
    }

    public int getTotalArmorValue() {
        if (this.large_unknown_detected != 0) {
            return 25;
        }
        return OreSpawnMain.Godzilla_stats.defense;
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
        if (this.worldObj.rand.nextInt(5) == 0) {
            return "orespawn:godzilla_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:alo_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:godzilla_death";
    }

    protected float getSoundVolume() {
        return 1.65f;
    }

    protected float getSoundPitch() {
        return 1.1f;
    }

    protected Item getDropItem() {
        return null;
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
        this.motionY += 0.44999998807907104;
        this.posY += 0.5;
        final float f = 0.2f + Math.abs(this.worldObj.rand.nextFloat() * 0.45f);
        this.motionX += f * Math.cos(Math.toRadians(this.rotationYawHead + 90.0f));
        this.motionZ += f * Math.sin(Math.toRadians(this.rotationYawHead + 90.0f));
        this.isAirBorne = true;
        this.getNavigator()
            .setPath(null, 0.0);
    }

    protected void jumpAtEntity(final EntityLivingBase e) {
        this.motionY += 1.25;
        this.posY += 1.5499999523162842;
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
            .setPath(null, 0.0);
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
        EntityLivingBase e;
        int xzrange = 9;
        if (this.isDead) {
            return;
        }
        if (this.worldObj.isRemote) {
            return;
        }
        this.dataWatcher.updateObject(21, OreSpawnMain.PlayNicely);
        super.updateAITasks();
        ++this.ticker;
        if (this.ticker > 30000) {
            this.ticker = 0;
        }
        if (this.ticker % 100 == 0) {
            this.stream_count = 8;
        }
        if (this.hurt_timer > 0) {
            --this.hurt_timer;
        }
        if (this.jump_timer > 0) {
            --this.jump_timer;
        }
        OreSpawnMain.godzilla_has_spawned = 1;
        if (this.worldObj.rand.nextInt(200) == 0) {
            this.setAttackTarget(null);
        }
        if (OreSpawnMain.PlayNicely == 0) {
            if (this.motionY < -0.95) {
                this.jumped = 1;
            }
            if (this.motionY < -1.5) {
                this.jumped = 2;
            }
            if (this.jumped != 0 && this.motionY > -0.1) {
                double df = 1.0;
                if (this.jumped == 2) {
                    df = 1.5;
                }
                this.doJumpDamage(this.posX, this.posY, this.posZ, 10.0, OreSpawnMain.Godzilla_stats.attack * df, 0);
                this.doJumpDamage(
                    this.posX,
                    this.posY,
                    this.posZ,
                    15.0,
                    OreSpawnMain.Godzilla_stats.attack / 2 * df,
                    0);
                this.doJumpDamage(
                    this.posX,
                    this.posY,
                    this.posZ,
                    25.0,
                    OreSpawnMain.Godzilla_stats.attack / 4 * df,
                    0);
                this.jumped = 0;
            }
        }
        xzrange = 12;
        if (this.getAttacking() != 0) {
            xzrange = 16;
        }
        int k = -3 + this.ticker % 30;
        if (OreSpawnMain.PlayNicely == 0) {
            for (int i = -xzrange; i <= xzrange; ++i) {
                for (int j = -xzrange; j <= xzrange; ++j) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + i, (int) this.posY + k, (int) this.posZ + j);
                    if (this.isCrushable(bid)) {
                        this.worldObj
                            .setBlock((int) this.posX + i, (int) this.posY + k, (int) this.posZ + j, Blocks.air);
                        Item item = Item.getItemFromBlock(bid);
                        if (item != null) {
                            if (this.worldObj.rand.nextInt(15) == 1) {
                                this.dropItemRand(item, 1);
                            }
                        }
                    } else {
                        if (bid == Blocks.grass && this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing")) {
                            this.worldObj
                                .setBlock((int) this.posX + i, (int) this.posY + k, (int) this.posZ + j, Blocks.dirt);
                        }
                        if (bid == Blocks.farmland && this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing")) {
                            this.worldObj
                                .setBlock((int) this.posX + i, (int) this.posY + k, (int) this.posZ + j, Blocks.dirt);
                        }
                    }
                }
            }
        }
        final double dx = this.posX + 16.0 * Math.sin(Math.toRadians(this.rotationYawHead));
        final double dz = this.posZ - 16.0 * Math.cos(Math.toRadians(this.rotationYawHead));
        k = -3 + this.ticker % 12;
        if (OreSpawnMain.PlayNicely == 0) {
            for (int i = -xzrange; i <= xzrange; ++i) {
                for (int j = -xzrange; j <= xzrange; ++j) {
                    final Block bid = this.worldObj.getBlock((int) dx + i, (int) this.posY + k, (int) dz + j);
                    if (this.isCrushable(bid)) {
                        this.worldObj.setBlock((int) dx + i, (int) this.posY + k, (int) dz + j, Blocks.air);
                        if (bid != null) {
                            Item item = Item.getItemFromBlock(bid);
                            if (item != null) {
                                this.dropItemRandAt(item, 1, dx, dz);
                            }
                        }
                    } else {
                        if (bid == Blocks.grass && this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing")) {
                            this.worldObj.setBlock((int) dx + i, (int) this.posY + k, (int) dz + j, Blocks.dirt);
                        }
                        if (bid == Blocks.farmland && this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing")) {
                            this.worldObj.setBlock((int) dx + i, (int) this.posY + k, (int) dz + j, Blocks.dirt);
                        }
                    }
                }
            }
        }
        if (OreSpawnMain.PlayNicely == 0 && k == 0) {
            this.doJumpDamage(dx, this.posY, dz, 15.0, OreSpawnMain.Godzilla_stats.attack / 2, 1);
        }
        if (this.worldObj.rand.nextInt(5 - this.large_unknown_detected) == 1) {
            e = this.getAttackTarget();
            if (OreSpawnMain.PlayNicely != 0) {
                e = null;
            }
            if (e != null) {
                if (!e.isEntityAlive()) {
                    this.setAttackTarget(null);
                    e = null;
                } else if (e instanceof Godzilla || e instanceof GodzillaHead) {
                    this.setAttackTarget(null);
                    e = null;
                }
            }
            if (e == null) {
                e = this.findSomethingToAttack();
                if (this.head_found == 0) {
                    final EntityLiving newent = (EntityLiving) spawnCreature(
                        this.worldObj,
                        "MobzillaHead",
                        this.posX,
                        this.posY + 20.0,
                        this.posZ);
                }
            }
            if (e != null) {
                this.wander.setBusy(1);
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.worldObj.rand.nextInt(65) == 1 && this.MygetDistanceSqToEntity(e) > 300.0) {
                    this.doLightningAttack(e);
                } else
                    if (this.worldObj.rand.nextInt(20 - this.large_unknown_detected * 5) == 1 && this.jump_timer == 0) {
                        this.jumpAtEntity(e);
                        this.jump_timer = 30;
                    } else if (this.MygetDistanceSqToEntity(e) < 300.0f + e.width / 2.0f * (e.width / 2.0f)) {
                        this.setAttacking(1);
                        this.getNavigator()
                            .tryMoveToEntityLiving(e, 1.0);
                        if (this.worldObj.rand.nextInt(4 - this.large_unknown_detected) == 0
                            || this.worldObj.rand.nextInt(3 - this.large_unknown_detected) == 1) {
                            this.attackEntityAsMob(e);
                        }
                    } else {
                        this.getNavigator()
                            .tryMoveToEntityLiving(e, 1.0);
                        if (this.getHorizontalDistanceSqToEntity(e) > 625.0) {
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
                                if (rdd < 0.5) {
                                    this.firecanon(e);
                                }
                            } else {
                                this.setAttacking(0);
                            }
                        } else {
                            this.setAttacking(0);
                        }
                    }
            } else {
                this.setAttacking(0);
                this.wander.setBusy(0);
                this.stream_count = 8;
            }
        }
        if (this.worldObj.rand.nextInt(35) == 1 && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(5.0f);
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
        if (par1EntityLiving instanceof Godzilla) {
            return false;
        }
        if (par1EntityLiving instanceof GodzillaHead) {
            return false;
        }
        if (par1EntityLiving instanceof EntityCreeper) {
            return false;
        }
        if (par1EntityLiving instanceof EntityZombie) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySpider) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySkeleton) {
            return false;
        }
        if (par1EntityLiving instanceof Ghost) {
            return false;
        }
        if (par1EntityLiving instanceof GhostSkelly) {
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
        return par1EntityLiving != null && par1EntityLiving != this
            && par1EntityLiving.isEntityAlive()
            && this.getEntitySenses()
                .canSee(par1EntityLiving)
            && par1EntityLiving instanceof EntityVillager;
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
            if (var8 instanceof Godzilla) {
                continue;
            }
            if (var8 instanceof GodzillaHead) {
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
                0.85f,
                1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
            if (knock == 0) {
                continue;
            }
            final double ks = 3.5;
            final double inair = 0.75;
            final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
            var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return null;
    }

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            this.head_found = 1;
            return null;
        }
        List var5;
        Iterator var6;
        Entity var7;
        EntityLivingBase var8;
        EntityLivingBase ret = null;
        int vf = 0;
        var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(64.0, 40.0, 64.0));
        if (var5 == null) {
            return null;
        }
        Collections.sort((List<Object>) var5, this.TargetSorter);
        var6 = var5.iterator();
        this.head_found = 0;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (var8 instanceof GodzillaHead) {
                this.head_found = 1;
            }
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
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (OreSpawnMain.godzilla_has_spawned != 0) {
            return false;
        }
        if (this.worldObj.rand.nextInt(40) != 1) {
            return false;
        }
        for (int k = -8; k <= 8; ++k) {
            for (int j = -8; j <= 8; ++j) {
                for (int i = 5; i < 15; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        Godzilla target;
        target = (Godzilla) this.worldObj
            .findNearestEntityWithinAABB(Godzilla.class, this.boundingBox.expand(64.0, 16.0, 64.0), this);
        if (target != null) {
            return false;
        }
        if (!this.worldObj.isRemote) {
            OreSpawnMain.godzilla_has_spawned = 1;
        }
        return true;
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    private ItemStack dropItemRand(final Item index, final int par1) {

        // verify if the item is null
        if (index == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }

        EntityItem var3;
        final ItemStack is = new ItemStack(index, par1, 0);

        double x = posX + rand.nextInt(10) - rand.nextInt(10);
        double y = posY + 4.0 + rand.nextInt(10);
        double z = posZ + rand.nextInt(10) - rand.nextInt(10);

        // verify coordinates
        if (isWithinWorldBounds(x, y, z)) {
            var3 = new EntityItem(worldObj, x, y, z, is);
            if (var3 != null) {
                worldObj.spawnEntityInWorld(var3);
            }
        }

        return is;

    }

    private ItemStack dropItemRandAt(final Item index, final int par1, final double dx, final double dz) {
        // verify if the item is null
        if (index == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        EntityItem var3;
        final ItemStack is = new ItemStack(index, par1, 0);

        // verify if coordinates are in the world
        if (isWithinWorldBounds(dx, this.posY, dz)) {
            var3 = new EntityItem(this.worldObj, dx, this.posY + 4.0 + this.worldObj.rand.nextInt(6), dz, is);

            if (var3 != null) {
                this.worldObj.spawnEntityInWorld(var3);
            }
        }
        return is;
    }

    private boolean isWithinWorldBounds(double x, double z, double dz) {

        int worldSize = (int) worldObj.getWorldInfo()
            .getWorldTotalTime();

        return x >= 0 && x < worldSize && z >= 0 && z < worldSize;

    }

    private boolean isCrushable(final Block bid) {
        return bid != null && this.worldObj.getGameRules()
            .getGameRuleBooleanValue("mobGriefing")
            && bid != Blocks.grass
            && bid != Blocks.dirt
            && bid != Blocks.stone
            && bid != Blocks.farmland
            && bid != Blocks.water
            && bid != Blocks.flowing_water
            && bid != Blocks.lava
            && bid != Blocks.flowing_lava
            && bid != Blocks.bedrock
            && bid != Blocks.obsidian
            && bid != Blocks.sand
            && bid != Blocks.gravel
            && bid != Blocks.iron_block
            && bid != Blocks.diamond_block
            && bid != Blocks.emerald_block
            && bid != Blocks.gold_block
            && bid != Blocks.netherrack
            && bid != Blocks.end_stone
            && bid != OreSpawnMain.MyBlockAmethystBlock
            && bid != OreSpawnMain.MyBlockRubyBlock
            && bid != OreSpawnMain.MyBlockUraniumBlock
            && bid != OreSpawnMain.MyBlockTitaniumBlock
            && bid != OreSpawnMain.CrystalStone
            && bid != OreSpawnMain.CrystalGrass;
    }

    private void firecanon(final EntityLivingBase e) {
        final double yoff = 19.0;
        final double xzoff = 22.0;
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
            bf.setBig();
            this.worldObj.playSoundAtEntity(
                this,
                "random.fuse",
                1.0f,
                1.0f / (this.getRNG()
                    .nextFloat() * 0.4f + 0.8f));
            this.worldObj.spawnEntityInWorld(bf);
            for (int i = 0; i < 5; ++i) {
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

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final float s = par1Entity.height * par1Entity.width;
            if (s > 30.0f && !MyUtils.isRoyalty(par1Entity)
                && !(par1Entity instanceof Godzilla)
                && !(par1Entity instanceof GodzillaHead)
                && !(par1Entity instanceof PitchBlack)
                && !(par1Entity instanceof Kraken)) {
                final EntityLivingBase e = (EntityLivingBase) par1Entity;
                e.setHealth(e.getHealth() / 2.0f);
                e.attackEntityFrom(DamageSource.causeMobDamage(this), OreSpawnMain.Godzilla_stats.attack * 10.0f);
                this.large_unknown_detected = 1;
            }
        }
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var21 = null;
            var21 = DamageSource.setExplosionSource(null);
            var21.setExplosion();
            if (this.worldObj.rand.nextInt(6) == 1) {
                dr.attackEntityFromPart(dr.dragonPartHead, var21, OreSpawnMain.Godzilla_stats.attack / 2.0f);
            } else {
                dr.attackEntityFromPart(dr.dragonPartBody, var21, OreSpawnMain.Godzilla_stats.attack / 2.0f);
            }
        }
        if (super.attackEntityAsMob(par1Entity)) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 3.2;
                double inair = 0.3;
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
        if (this.hurt_timer > 0) {
            return false;
        }
        if (dm > 750.0f) {
            dm = 750.0f;
        }
        Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLivingBase) {
            final EntityLivingBase enl = (EntityLivingBase) e;
            s = enl.height * enl.width;
            if (s > 30.0f && !MyUtils.isRoyalty(enl)
                && !(enl instanceof Godzilla)
                && !(enl instanceof GodzillaHead)
                && !(enl instanceof PitchBlack)
                && !(enl instanceof Kraken)) {
                dm /= 10.0f;
                this.hurt_timer = 50;
                this.large_unknown_detected = 1;
            }
        }
        if (!par1DamageSource.getDamageType()
            .equals("cactus")) {
            ret = super.attackEntityFrom(par1DamageSource, dm);
            this.hurt_timer = 20;
            e = par1DamageSource.getEntity();
            if (e != null && e instanceof EntityLivingBase
                && !(e instanceof GodzillaHead)
                && !(e instanceof Godzilla)) {
                this.setAttackTarget((EntityLivingBase) e);
                this.setTarget(e);
                this.getNavigator()
                    .tryMoveToEntityLiving(e, 1.2);
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
        e.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
        e.setFire(5);
        for (int var3 = 0; var3 < 20; ++var3) {
            this.worldObj.spawnParticle(
                "smoke",
                e.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posZ + this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
            this.worldObj.spawnParticle(
                "largesmoke",
                e.posX + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posY + this.rand.nextFloat() - this.rand.nextFloat(),
                e.posZ + this.rand.nextFloat() - this.rand.nextFloat(),
                0.0,
                0.0,
                0.0);
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
                3.0f,
                this.worldObj.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing"));
        }
        this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, e.posX, e.posY + 1.0, e.posZ));
        this.worldObj.addWeatherEffect(new EntityLightningBolt(this.worldObj, this.posX, this.posY + 15.0, this.posZ));
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        ItemStack is = null;
        this.dropItemRand(Items.item_frame, 1);
        for (int var5 = 50 + this.worldObj.rand.nextInt(30), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(OreSpawnMain.MyGodzillaScale, 1);
        }
        for (int var5 = 100 + this.worldObj.rand.nextInt(160), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.beef, 1);
        }
        for (int var5 = 50 + this.worldObj.rand.nextInt(60), var6 = 0; var6 < var5; ++var6) {
            this.dropItemRand(Items.bone, 1);
        }
        for (int i = 25 + this.worldObj.rand.nextInt(15), var6 = 0; var6 < i; ++var6) {
            final int var7 = this.worldObj.rand.nextInt(80);
            switch (var7) {
                case 0: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateSword, 1);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.diamond, 1);
                    break;
                }
                case 2: {
                    is = this.dropItemRand(Item.getItemFromBlock(Blocks.diamond_block), 1);
                    break;
                }
                case 3: {
                    is = this.dropItemRand(Items.diamond_sword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 4: {
                    is = this.dropItemRand(Items.diamond_shovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 5: {
                    is = this.dropItemRand(Items.diamond_pickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 6: {
                    is = this.dropItemRand(Items.diamond_axe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 7: {
                    is = this.dropItemRand(Items.diamond_hoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 8: {
                    is = this.dropItemRand(Items.diamond_helmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(2));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 9: {
                    is = this.dropItemRand(Items.diamond_chestplate, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 10: {
                    is = this.dropItemRand(Items.diamond_leggings, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 11: {
                    is = this.dropItemRand(Items.diamond_boots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 12: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateBow, 1);
                    break;
                }
                case 13: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
                    break;
                }
                case 14: {
                    is = this.dropItemRand(Items.iron_ingot, 1);
                    break;
                }
                case 15: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
                    break;
                }
                case 16: {
                    is = this.dropItemRand(Items.iron_sword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 17: {
                    is = this.dropItemRand(Items.iron_shovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 18: {
                    is = this.dropItemRand(Items.iron_pickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 19: {
                    is = this.dropItemRand(Items.iron_axe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 20: {
                    is = this.dropItemRand(Items.iron_hoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 21: {
                    is = this.dropItemRand(Items.iron_helmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 22: {
                    is = this.dropItemRand(Items.iron_chestplate, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 23: {
                    is = this.dropItemRand(Items.iron_leggings, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 24: {
                    is = this.dropItemRand(Items.iron_boots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 25: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
                    break;
                }
                case 26: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.iron_block), 1);
                    break;
                }
                case 27: {
                    is = this.dropItemRand(Items.gold_nugget, 1);
                    break;
                }
                case 28: {
                    is = this.dropItemRand(Items.gold_ingot, 1);
                    break;
                }
                case 29: {
                    is = this.dropItemRand(Items.golden_carrot, 1);
                    break;
                }
                case 30: {
                    is = this.dropItemRand(Items.golden_sword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 31: {
                    is = this.dropItemRand(Items.golden_shovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 32: {
                    is = this.dropItemRand(Items.golden_pickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 33: {
                    is = this.dropItemRand(Items.golden_axe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 34: {
                    is = this.dropItemRand(Items.golden_hoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 35: {
                    is = this.dropItemRand(Items.golden_helmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 36: {
                    is = this.dropItemRand(Items.golden_chestplate, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 37: {
                    is = this.dropItemRand(Items.golden_leggings, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 38: {
                    is = this.dropItemRand(Items.golden_boots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 39: {
                    this.dropItemRand(Items.golden_apple, 1);
                    break;
                }
                case 40: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gold_block), 1);
                    break;
                }
                case 41: {
                    EntityItem var8 = null;
                    is = new ItemStack(Items.golden_apple, 1, 1);
                    var8 = new EntityItem(
                        this.worldObj,
                        this.posX + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3),
                        this.posY + 1.0,
                        this.posZ + OreSpawnMain.OreSpawnRand.nextInt(3) - OreSpawnMain.OreSpawnRand.nextInt(3),
                        is);
                    if (var8 != null) {
                        this.worldObj.spawnEntityInWorld(var8);
                    }
                    break;
                }
                case 42: {
                    is = this.dropItemRand(OreSpawnMain.MyExperienceSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 43: {
                    is = this.dropItemRand(OreSpawnMain.ExperienceHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 44: {
                    is = this.dropItemRand(OreSpawnMain.ExperienceBody, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 45: {
                    is = this.dropItemRand(OreSpawnMain.ExperienceLegs, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 46: {
                    is = this.dropItemRand(OreSpawnMain.ExperienceBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 47: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystSword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 48: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystShovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 49: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 50: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 51: {
                    is = this.dropItemRand(OreSpawnMain.MyAmethystHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 52: {
                    is = this.dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyBlockAmethystBlock), 1);
                    break;
                }
                case 53: {
                    is = this.dropItemRand(OreSpawnMain.AmethystHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 54: {
                    is = this.dropItemRand(OreSpawnMain.AmethystBody, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 55: {
                    is = this.dropItemRand(OreSpawnMain.AmethystLegs, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 56: {
                    is = this.dropItemRand(OreSpawnMain.AmethystBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 57: {
                    is = this.dropItemRand(OreSpawnMain.RubyHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 58: {
                    is = this.dropItemRand(OreSpawnMain.RubyBody, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 59: {
                    is = this.dropItemRand(OreSpawnMain.RubyLegs, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 60: {
                    is = this.dropItemRand(OreSpawnMain.RubyBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 61: {
                    is = this.dropItemRand(OreSpawnMain.MyRubySword, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.baneOfArthropods, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.knockback, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.looting, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireAspect, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.sharpness, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 62: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyShovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 63: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyPickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 64: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 65: {
                    is = this.dropItemRand(OreSpawnMain.MyRubyHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 66: {
                    is = this.dropItemRand(Item.getItemFromBlock(OreSpawnMain.MyBlockRubyBlock), 1);
                    break;
                }
                case 67: {
                    is = this.dropItemRand(OreSpawnMain.UltimateHelmet, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.respiration, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.aquaAffinity, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 68: {
                    is = this.dropItemRand(OreSpawnMain.UltimateBody, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 69: {
                    is = this.dropItemRand(OreSpawnMain.UltimateLegs, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.protection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.blastProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fireProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.projectileProtection, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 70: {
                    is = this.dropItemRand(OreSpawnMain.UltimateBoots, 1);
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.featherFalling, 5 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                        break;
                    }
                    break;
                }
                case 71: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateShovel, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 73: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimatePickaxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.fortune, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 74: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateAxe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
                case 75: {
                    is = this.dropItemRand(OreSpawnMain.MyUltimateHoe, 1);
                    if (this.worldObj.rand.nextInt(2) == 1) {
                        is.addEnchantment(Enchantment.unbreaking, 2 + this.worldObj.rand.nextInt(4));
                    }
                    if (this.worldObj.rand.nextInt(6) == 1) {
                        is.addEnchantment(Enchantment.efficiency, 1 + this.worldObj.rand.nextInt(5));
                        break;
                    }
                    break;
                }
            }
        }
    }
}
