
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.entities.render.InfoRenderer;
import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
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
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TrevorPhillipsInstance extends EntityMob {

    private GenericTargetSorterInstance TargetSorter;
    private InfoRenderer renderdata;
    private int reload_ticker;
    private int was_attacked_ticker;
    private float moveSpeed;

    public TrevorPhillipsInstance(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new InfoRenderer();
        this.reload_ticker = 0;
        this.was_attacked_ticker = 0;
        this.moveSpeed = 0.34f;
        this.setSize(1.0f, 2.0f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 120;
        this.fireResistance = 120;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
        this.renderdata = new InfoRenderer();
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIWander(this, 1.0));
        this.tasks.addTask(2, new EntityAIMoveThroughVillage(this, 0.8999999761581421, false));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        // this.setCurrentItemOrArmor(0, new ItemStack(Basic.dagger));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(10.0);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(200.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, (Object) 0);
        this.dataWatcher.addObject(21, (Object) 0);
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

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 100;
    }

    public int getTrevorHealth() {
        return 100;
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
        if (this.getHealth() < 20.0f) {
            return 20;
        }
        return 12;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    protected void jump() {
        this.motionY += 0.45;
        super.jump();
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.worldObj.isRemote) {}
    }

    protected void addRandomArmor() {
        super.addRandomArmor();
        if (this.rand.nextFloat() < 2.0f) {
            final int i = this.rand.nextInt(2);
            if (i == 0) {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.stick));
            } else {
                this.setCurrentItemOrArmor(0, new ItemStack(Items.iron_shovel));
            }
        }
    }

    public int getAttackStrength(final Entity par1Entity) {
        int var2 = 0;
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            var2 = 5;
            if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                var2 = 6;
            } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                var2 = 7;
            }
        }
        return var2;
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(4) == 0) {
            return Tags.MODID + ":trevor_a";
        }
        return Tags.MODID + ":trevor_a";
    }

    protected String getHurtSound() {
        return "player.hit";
    }

    protected String getDeathSound() {
        return "player.hit";
    }

    protected float getSoundVolume() {
        return 2.0f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    /*
     * protected Item getDropItemId() {
     * return Basic.eggTimberWolf;
     * }
     */

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
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
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
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        ItemStack is = null;
        for (int var5 = 5 + this.worldObj.rand.nextInt(10), var6 = 0; var6 < var5; ++var6) {
            this.dropBlockRand(Blocks.cactus, 16);
        }
        for (int i = 10 + this.worldObj.rand.nextInt(15), var7 = 0; var7 < i; ++var7) {
            final int var8 = this.worldObj.rand.nextInt(15);
            switch (var8) {
                case 0: {
                    is = this.dropItemRand(Items.fire_charge, 6);
                    break;
                }
                case 1: {
                    is = this.dropItemRand(Items.fermented_spider_eye, 1);
                    break;
                }
                case 2: {
                    // is = this.dropItemRand(Basic.dagger, 1);
                    break;
                }
            }
        }
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
            final double ks = 0.1;
            double inair = 0.05;
            final float f3 = (float) Math.atan2(par1Entity.posZ - this.posZ, par1Entity.posX - this.posX);
            if (par1Entity.isDead || par1Entity instanceof EntityPlayer) {
                inair *= 2.0;
            }
            par1Entity.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
        }
        return super.attackEntityAsMob(par1Entity);
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        for (int k = -1; k < 2; ++k) {
            for (int j = -1; j < 2; ++j) {
                for (int i = 1; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.lava && bid != Blocks.flowing_lava && bid != Blocks.fire) {
                        this.heal(2.0f);
                    }
                }
            }
        }
        if (this.reload_ticker > 0) {
            --this.reload_ticker;
        }
        if (this.was_attacked_ticker > 0) {
            --this.was_attacked_ticker;
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.reload_ticker == 0
            && this.worldObj.rand.nextInt(8) == 1) {
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
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity(e) < 256.0) {
                    if (this.getDistanceSqToEntity(e) < (8.5f + e.width / 2.0f) * (8.5f + e.width / 2.0f)) {
                        this.trevorSmash(this.posX, this.posY, this.posZ, 7.0);
                        this.attackEntityAsMob(e);
                    } else {
                        final double rr = Math.atan2(e.posZ - this.posZ, e.posX - this.posX);
                        final double rhdir = Math.toRadians((this.rotationYawHead + 90.0f) % 360.0f);
                        final double pi = 3.1415926545;
                        double rdd = Math.abs(rr - rhdir) % (pi * 2.0);
                        if (rdd > pi) {
                            rdd -= pi * 2.0;
                        }
                        rdd = Math.abs(rdd);
                        if (rdd < 0.5) {
                            if (this.getDistanceSqToEntity(e) > 285.0) {
                                this.reload_ticker = 30;
                                this.worldObj.playSoundAtEntity(this, Tags.MODID + ":slap", 3.5f, 1.0f);
                            } else {
                                this.reload_ticker = 10;
                                this.worldObj.playSoundAtEntity(this, Tags.MODID + ":slap", 2.5f, 1.0f);
                            }
                        }
                        this.setAttacking(1);
                    }
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 0.75);
                    if (this.worldObj.rand.nextInt(4) == 0) {
                        double dx = e.posX;
                        double dz = e.posZ;
                        dx += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                        dz += (this.worldObj.rand.nextFloat() - this.worldObj.rand.nextFloat()) * 2.0;
                    }
                }
            }
        }
        if (this.reload_ticker <= 0 && this.was_attacked_ticker <= 0) {
            this.setAttacking(0);
        }
    }

    public boolean attackEntityFrom(final DamageSource par1DamageSource, final float par2) {
        boolean ret = false;
        if (par1DamageSource.getDamageType()
            .equals("cactus")) {
            return false;
        }
        if (this.getShielding() != 0 || this.was_attacked_ticker != 0) {
            return false;
        }
        this.was_attacked_ticker = 2;
        this.setAttacking(1);
        ret = super.attackEntityFrom(par1DamageSource, par2);
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLiving) {
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving((Entity) e, 1.2);
            ret = true;
        }
        return ret;
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
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (p.capabilities.isCreativeMode) {
                return false;
            }
        }
        return !(par1EntityLiving instanceof TrevorPhillipsInstance);
    }

    private EntityLivingBase findSomethingToAttack() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 16.0, 16.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
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

    public final int getShielding() {
        return this.dataWatcher.getWatchableObjectInt(21);
    }

    public final void setShielding(final int par1) {
        this.dataWatcher.updateObject(21, par1);
    }

    private EntityLivingBase trevorSmash(final double X, final double Y, final double Z, final double damage) {
        final AxisAlignedBB bb = AxisAlignedBB.getBoundingBox(X - 8.0, Y - 2.0, Z - 8.0, X + 8.0, Y + 2.0, Z + 8.0);
        final List var5 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && var8 != null
                && !(var8 instanceof TrevorPhillipsInstance)
                && var8.isEntityAlive()) {
                DamageSource var9 = null;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage);
                var8.attackEntityFrom(DamageSource.fall, (float) damage);
                final double ks = 0.05;
                final double inair = 0.1;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    public boolean getCanSpawnHere() {
        for (int k = -3; k < 3; ++k) {
            for (int j = -3; j < 3; ++j) {
                for (int i = 0; i < 5; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("TrevorPhillipsInstance")) {
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
        TrevorPhillipsInstance target;
        target = (TrevorPhillipsInstance) this.worldObj.findNearestEntityWithinAABB(
            TrevorPhillipsInstance.class,
            this.boundingBox.expand(128.0, 64.0, 128.0),
            this);
        return target == null;
    }
}
