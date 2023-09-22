
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class PitchBlack extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private float MyMoveSpeed;
    private int damage_ticker;
    private int wing_sound;

    public PitchBlack(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.MyMoveSpeed = 0.2f;
        this.damage_ticker = 0;
        this.wing_sound = 0;
        this.setSize(2.0f, 3.0f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 200;
        this.isImmuneToFire = false;
        this.fireResistance = 25;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMoveThroughVillage(this, 1.0, false));
        this.tasks.addTask(2, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.MyMoveSpeed = 0.2f;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((this.MyMoveSpeed + 0.1f * this.getPitchBlackScale()));
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue((this.getPitchBlackScale() * OreSpawnMain.PitchBlack_stats.attack));
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.dataWatcher.addObject(21, (Object) 0);
        this.dataWatcher.addObject(22, (Object) 0);
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
        float t = 0.5f;
        if (this.worldObj != null) {
            if (this.worldObj.rand.nextInt(4) == 1) {
                t = 1.0f;
            }
            if (this.worldObj.rand.nextInt(8) == 2) {
                t = 2.0f;
            }
            if (this.worldObj.rand.nextInt(32) == 3) {
                t = 3.0f;
            }
            if (this.worldObj.rand.nextInt(64) == 4) {
                t = 4.0f;
            }
        } else {
            if (OreSpawnMain.OreSpawnRand.nextInt(4) == 1) {
                t = 1.0f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(8) == 2) {
                t = 2.0f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(32) == 3) {
                t = 3.0f;
            }
            if (OreSpawnMain.OreSpawnRand.nextInt(64) == 4) {
                t = 4.0f;
            }
        }
        if (OreSpawnMain.NightmareSize == 1) {
            t = 0.5f;
        }
        if (OreSpawnMain.NightmareSize == 2) {
            t = 1.0f;
        }
        if (OreSpawnMain.NightmareSize == 3) {
            t = 2.0f;
        }
        if (OreSpawnMain.NightmareSize == 4) {
            t = 3.0f;
        }
        if (OreSpawnMain.NightmareSize == 5) {
            t = 4.0f;
        }
        this.setPitchBlackScale(t);
        this.experienceValue = (int) (100.0f * t);
        this.fireResistance = (int) (25.0f * t);
        this.setSize(2.5f * this.getPitchBlackScale(), 3.5f * this.getPitchBlackScale());
    }

    public void readEntityFromNBT(final NBTTagCompound par1NBTTagCompound) {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setPitchBlackScale(par1NBTTagCompound.getFloat("Fscale"));
        this.setSize(2.5f * this.getPitchBlackScale(), 3.5f * this.getPitchBlackScale());
        this.experienceValue = (int) (100.0f * this.getPitchBlackScale());
        this.fireResistance = (int) (25.0f * this.getPitchBlackScale());
    }

    public void writeEntityToNBT(final NBTTagCompound par1NBTTagCompound) {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setFloat("Fscale", this.getPitchBlackScale());
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, par1);
    }

    public final int getActivity() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public final void setActivity(final int par1) {
        this.dataWatcher.updateObject(21, par1);
    }

    public float getPitchBlackScale() {
        final int i = this.dataWatcher.getWatchableObjectInt(22);
        final float f = (float) i;
        return f / 10.0f;
    }

    public void setPitchBlackScale(final float par1) {
        final float f = par1 * 10.0001f;
        final int i = (int) f;
        this.dataWatcher.updateObject(22, (Object) i);
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.PitchBlack_stats.defense + (int) (2.0f * this.getPitchBlackScale());
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
        return !this.isNoDespawnRequired() && this.worldObj.isDaytime();
    }

    protected float getSoundVolume() {
        return 0.75f;
    }

    protected float getSoundPitch() {
        return 1.0f - 0.7f * (4.0f / this.getPitchBlackScale());
    }

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(5) != 2) {
            return null;
        }
        return Tags.MODID + ":pitchblack_living";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":pitchblack_hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":pitchblack_dead";
    }

    public int mygetMaxHealth() {
        return (int) (OreSpawnMain.PitchBlack_stats.health * this.getPitchBlackScale());
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        this.MyMoveSpeed = 0.2f;
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((this.MyMoveSpeed + 0.1f * this.getPitchBlackScale()));
        super.onUpdate();
        this.setSize(2.5f * this.getPitchBlackScale(), 3.5f * this.getPitchBlackScale());
        ++this.wing_sound;
        if (this.wing_sound > 20) {
            if (!this.worldObj.isRemote) {
                this.worldObj.playSoundAtEntity(this, Tags.MODID + ":MothraWings", 1.0f, 1.0f);
            }
            this.wing_sound = 0;
        }
        this.motionY *= 0.6;
        if (!this.worldObj.isRemote && this.worldObj.rand.nextInt(250) == 1) {
            this.heal(1.0f + this.getPitchBlackScale());
            if (this.worldObj.rand.nextInt(5) == 0) {
                Block bid = Blocks.air;
                if (this.posY > 10.0) {
                    for (int i = 0; i < 10; ++i) {
                        bid = this.worldObj.getBlock((int) this.posX, (int) this.posY - i, (int) this.posZ);
                        if (bid != Blocks.air) {
                            break;
                        }
                    }
                } else {
                    bid = Blocks.stone;
                }
                if (bid != Blocks.air) {
                    Entity e = null;
                    e = this.findSomethingToAttack();
                    if (e == null) {
                        this.setActivity(0);
                    }
                }
            } else {
                this.setActivity(1);
                this.getNavigator()
                    .setPath((PathEntity) null, 0.0);
            }
        }
        if (this.getActivity() == 0 && this.worldObj.rand.nextInt(10) == 1) {
            Entity e2 = null;
            e2 = this.findSomethingToAttack();
            if (e2 != null) {
                this.setActivity(1);
                this.getNavigator()
                    .setPath((PathEntity) null, 0.0);
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        boolean var4 = false;
        if (par1Entity != null && par1Entity instanceof EntityDragon) {
            final EntityDragon dr = (EntityDragon) par1Entity;
            DamageSource var5 = null;
            var5 = DamageSource.setExplosionSource(null);
            var5.setExplosion();
            if (this.worldObj.rand.nextInt(8) == 1) {
                dr.attackEntityFromPart(
                    dr.dragonPartHead,
                    var5,
                    OreSpawnMain.PitchBlack_stats.attack * this.getPitchBlackScale());
            } else {
                dr.attackEntityFromPart(
                    dr.dragonPartBody,
                    var5,
                    OreSpawnMain.PitchBlack_stats.attack * this.getPitchBlackScale());
            }
            var4 = true;
        } else {
            var4 = par1Entity.attackEntityFrom(
                DamageSource.causeMobDamage(this),
                OreSpawnMain.PitchBlack_stats.attack * this.getPitchBlackScale());
            if (var4 && par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 1.15 * this.getPitchBlackScale();
                double inair = 0.08 * this.getPitchBlackScale();
                final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
                if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                    inair *= 2.0;
                }
                par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return var4;
    }

    public boolean canSeeTarget(final double pX, final double pY, final double pZ) {
        return this.worldObj.rayTraceBlocks(
            Vec3.createVectorHelper(this.posX, this.posY + 0.75, this.posZ),
            Vec3.createVectorHelper(pX, pY, pZ),
            false) == null;
    }

    protected void updateAITasks() {
        int xdir = 1;
        int zdir = 1;
        int keep_trying = 50;
        if (this.damage_ticker > 0) {
            --this.damage_ticker;
        }
        if (this.getActivity() == 0) {
            super.updateAITasks();
            return;
        }
        if (this.isDead) {
            return;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        if (this.getActivity() == 0) {
            return;
        }
        if (this.rand.nextInt(150) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            for (Block bid = Blocks.stone; bid != Blocks.air && keep_trying > 0; --keep_trying) {
                zdir = this.rand.nextInt(20) + 5 * (int) this.getPitchBlackScale();
                xdir = this.rand.nextInt(20) + 5 * (int) this.getPitchBlackScale();
                if (this.rand.nextInt(2) == 0) {
                    zdir = -zdir;
                }
                if (this.rand.nextInt(2) == 0) {
                    xdir = -xdir;
                }
                this.currentFlightTarget
                    .set((int) this.posX + xdir, (int) this.posY + this.rand.nextInt(11) - 5, (int) this.posZ + zdir);
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
            }
        } else if (this.rand.nextInt(8) == 0) {
            Entity e = null;
            e = this.findSomethingToAttack();
            if (e != null) {
                double d1 = 5.0 + e.width / 2.0f;
                d1 += this.getPitchBlackScale();
                d1 *= d1;
                this.setAttacking(1);
                if (e instanceof EntityDragon && d1 < 100.0) {
                    d1 = 100.0;
                }
                if (e instanceof Godzilla && d1 < 100.0) {
                    d1 = 100.0;
                }
                if (e instanceof GodzillaHead && d1 < 100.0) {
                    d1 = 100.0;
                }
                this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 2.0), (int) e.posZ);
                if (this.getDistanceSqToEntity(e) < d1) {
                    this.attackEntityAsMob(e);
                }
            } else {
                this.setAttacking(0);
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.4 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.4 - this.posZ;
        final double myspeed = 0.5f + this.getPitchBlackScale() / 10.0f;
        this.motionX += (Math.signum(var1) * myspeed - this.motionX) * 0.33;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.20000000149011612;
        this.motionZ += (Math.signum(var3) * myspeed - this.motionZ) * 0.33;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 0.1f + (float) myspeed;
        this.rotationYaw += var5 / 5.0f;
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
        if (this.damage_ticker > 0) {
            return ret;
        }
        this.damage_ticker = 20;
        ret = super.attackEntityFrom(par1DamageSource, par2);
        final Entity e = par1DamageSource.getEntity();
        if (e != null && this.currentFlightTarget != null) {
            this.currentFlightTarget.set((int) e.posX, (int) (e.posY + 2.0), (int) e.posZ);
        }
        this.setActivity(1);
        this.getNavigator()
            .setPath((PathEntity) null, 0.0);
        return ret;
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
                        if (s != null && s.equals("Nightmare")) {
                            float t = this.getPitchBlackScale();
                            if (t > 1.0f) {
                                t = 1.0f;
                            }
                            this.setPitchBlackScale(t);
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.isDaytime()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == DimensionInitDangerZone.DimensionID6) {
            PitchBlack target = null;
            target = (PitchBlack) this.worldObj
                .findNearestEntityWithinAABB(PitchBlack.class, this.boundingBox.expand(16.0, 16.0, 16.0), this);
            if (target != null) {
                return false;
            }
        }
        if (this.getPitchBlackScale() < 1.1f) {
            return true;
        }
        int ix = 1;
        if (this.getPitchBlackScale() > 3.1f) {
            ix = 2;
        }
        final int iy = ix * 3;
        for (int k = -ix; k <= ix; ++k) {
            for (int j = -ix; j <= ix; ++j) {
                for (int i = 1; i <= iy; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
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
        if (!(par1EntityLiving instanceof EntityLivingBase)) {
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
        if (par1EntityLiving instanceof PitchBlack) {
            return false;
        }
        if (par1EntityLiving instanceof EnderReaper) {
            return false;
        }
        if (par1EntityLiving instanceof LeafMonster) {
            return false;
        }
        if (par1EntityLiving instanceof TerribleTerror) {
            return false;
        }
        if (par1EntityLiving instanceof LurkingTerror) {
            return false;
        }
        if (par1EntityLiving instanceof CreepingHorror) {
            return false;
        }
        if (par1EntityLiving instanceof Island) {
            return false;
        }
        if (par1EntityLiving instanceof IslandToo) {
            return false;
        }
        if (par1EntityLiving instanceof Triffid) {
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

    private Entity findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        final double d1 = 16.0 + this.getPitchBlackScale() * 6.0f;
        final double d2 = 10.0 + this.getPitchBlackScale() * 4.0f;
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(d1, d2, d1));
        Collections.sort((List<Object>) var5, (Comparator<? super Object>) this.TargetSorter);
        final Iterator var6 = var5.iterator();
        EntityLivingBase var7 = null;
        while (var6.hasNext()) {
            var7 = (EntityLivingBase) var6.next();
            if (this.isSuitableTarget(var7, false)) {
                return var7;
            }
        }
        return null;
    }

    protected Item getDropItem() {
        return OreSpawnMain.MyNightmareScale;
    }

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale()
                - OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale(),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale()
                - OreSpawnMain.OreSpawnRand.nextInt(5) * this.getPitchBlackScale(),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int i = 3 + this.worldObj.rand.nextInt(2 + (int) (5.0f * this.getPitchBlackScale())), var4 = 0; var4
            < i; ++var4) {
            this.dropItemRand(Items.rotten_flesh, 1);
            final int j = this.worldObj.rand.nextInt(10);
            if (j == 0) {
                this.dropItemRand(Items.feather, 1);
            }
            if (j == 1) {
                this.dropItemRand(Items.string, 1);
            }
            if (j == 2) {
                this.dropItemRand(Items.flint, 1);
            }
            if (j == 3) {
                this.dropItemRand(Items.beef, 1);
            }
        }
        this.dropItemRand(OreSpawnMain.MyNightmareScale, 1);
        this.dropItemRand(Items.item_frame, 1);
        for (int i = 2 + (int) this.getPitchBlackScale()
            + this.worldObj.rand.nextInt(2 + (int) (5.0f * this.getPitchBlackScale())), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(OreSpawnMain.ZooKeeper, 1);
        }
    }
}
