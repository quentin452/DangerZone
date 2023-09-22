
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.util.MobUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ParaspriteInstance extends EntityMob {

    private ChunkCoordinates currentFlightTarget;
    private GenericTargetSorterInstance TargetSorter;
    private int stuck_count;
    private int lastX;
    private int lastZ;
    private Entity rt;

    public ParaspriteInstance(final World par1World) {
        super(par1World);
        this.currentFlightTarget = null;
        this.TargetSorter = null;
        this.stuck_count = 0;
        this.lastX = 0;
        this.lastZ = 0;
        this.rt = null;
        this.setSize(0.45f, 0.45f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 100;
        this.isImmuneToFire = false;
        this.fireResistance = 5;
        this.TargetSorter = new GenericTargetSorterInstance((Entity) this);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(0.3199999928474426);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(1.0);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(20, 0);
    }

    protected boolean canDespawn() {
        return !this.isNoDespawnRequired();
    }

    public final int getAttacking() {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    public final void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (Object) (byte) par1);
    }

    protected float getSoundVolume() {
        return 1.25f;
    }

    protected float getSoundPitch() {
        return 2.0f;
    }

    protected String getLivingSound() {
        return "";
    }

    protected String getHurtSound() {
        return "damage.hit";
    }

    protected String getDeathSound() {
        return "damage.hit";
    }

    public boolean canBePushed() {
        return true;
    }

    protected void collideWithEntity(final Entity par1Entity) {}

    public int mygetMaxHealth() {
        return 6;
    }

    protected BlockFlower getDropItemId() {
        return Blocks.yellow_flower;
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
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
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
        var3.addVelocity(Math.cos(f3) * 0.25, 0.44999998807907104, Math.sin(f3) * 0.25);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld((Entity) var3);
        }
        return is;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        this.dropItemRand(Items.stick, 1);
        this.dropItemRand(Items.wheat_seeds, 1);
        for (int var4 = 2 + this.worldObj.rand.nextInt(10), i = 0; i < var4; ++i) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (int var4 = 1 + this.worldObj.rand.nextInt(3), i = 0; i < var4; ++i) {
            this.dropItemRand(Items.pumpkin_seeds, 1);
        }
        final int var4 = 2 + this.worldObj.rand.nextInt(3);
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        this.motionY *= 0.6;
        if (this.isInWater() && this.worldObj.rand.nextInt(20) == 1) {
            this.attackEntityAsMob((Entity) this);
        }
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
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.lastX == (int) this.posX && this.lastZ == (int) this.posZ) {
            ++this.stuck_count;
        } else {
            this.stuck_count = 0;
            this.lastX = (int) this.posX;
            this.lastZ = (int) this.posZ;
        }
        if (this.currentFlightTarget == null) {
            this.currentFlightTarget = new ChunkCoordinates((int) this.posX, (int) this.posY, (int) this.posZ);
        }
        Block bid = Blocks.air;
        if (this.stuck_count > 50 || this.rand.nextInt(300) == 0
            || this.currentFlightTarget.getDistanceSquared((int) this.posX, (int) this.posY, (int) this.posZ) < 2.1f) {
            bid = Blocks.stone;
            this.stuck_count = 0;
        }
        while (bid != Blocks.air && keep_trying != 0) {
            zdir = this.rand.nextInt(9) + 4;
            xdir = this.rand.nextInt(9) + 4;
            if (this.rand.nextInt(2) == 0) {
                zdir = -zdir;
            }
            if (this.rand.nextInt(2) == 0) {
                xdir = -xdir;
            }
            this.currentFlightTarget
                .set((int) this.posX + xdir, (int) this.posY + this.rand.nextInt(6) - 3, (int) this.posZ + zdir);
            bid = this.worldObj
                .getBlock(this.currentFlightTarget.posX, this.currentFlightTarget.posY, this.currentFlightTarget.posZ);
            if (bid == Blocks.air && !this.canSeeTarget(
                this.currentFlightTarget.posX,
                this.currentFlightTarget.posY,
                this.currentFlightTarget.posZ)) {
                bid = Blocks.stone;
            }
            --keep_trying;
            if (this.rand.nextInt(8) == 0 && this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL) {
                EntityLivingBase e = null;
                e = (EntityLivingBase) this.rt;
                if (e != null && e.isDead) {
                    e = null;
                }
                if (e == null) {
                    e = this.findSomethingToAttack();
                }
                if (e != null) {
                    this.setAttacking(1);
                    this.currentFlightTarget.set((int) e.posX, (int) e.posY + 1, (int) e.posZ);
                    if (this.getDistanceSqToEntity((Entity) e) >= (5.5f + e.width / 2.0f) * (5.5f + e.width / 2.0f)) {
                        continue;
                    }
                    this.attackEntityAsMob((Entity) e);
                } else {
                    this.setAttacking(0);
                }
            }
        }
        final double var1 = this.currentFlightTarget.posX + 0.5 - this.posX;
        final double var2 = this.currentFlightTarget.posY + 0.1 - this.posY;
        final double var3 = this.currentFlightTarget.posZ + 0.5 - this.posZ;
        this.motionX += (Math.signum(var1) * 0.5 - this.motionX) * 0.3000000014901161;
        this.motionY += (Math.signum(var2) * 0.699999988079071 - this.motionY) * 0.2000000014901161;
        this.motionZ += (Math.signum(var3) * 0.5 - this.motionZ) * 0.3000000014901161;
        final float var4 = (float) (Math.atan2(this.motionZ, this.motionX) * 180.0 / 3.141592653589793) - 90.0f;
        final float var5 = MathHelper.wrapAngleTo180_float(var4 - this.rotationYaw);
        this.moveForward = 1.0f;
        this.rotationYaw += var5 / 4.0f;
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
        final boolean ret = super.attackEntityFrom(par1DamageSource, par2);
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof EntityLivingBase && this.currentFlightTarget != null) {
            this.rt = e;
            this.currentFlightTarget.set((int) e.posX, (int) e.posY, (int) e.posZ);
        }
        return ret;
    }

    public boolean getCanSpawnHere() {
        for (byte k = -2; k <= 2; ++k) {
            for (byte j = -2; j <= 2; ++j) {
                for (byte i = 1; i < 4; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((byte) this.posX + j, (byte) this.posY + i, (byte) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("Mantis")) {
                            return true;
                        }
                    }
                }
            }
        }
        for (int k = -2; k < 2; ++k) {
            for (int j = -2; j < 2; ++j) {
                for (int i = 1; i < 6; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid != Blocks.air) {
                        return false;
                    }
                }
            }
        }
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        ParaspriteInstance target = null;
        target = (ParaspriteInstance) this.worldObj.findNearestEntityWithinAABB(
            ParaspriteInstance.class,
            this.boundingBox.expand(32.0, 16.0, 32.0),
            (Entity) this);
        return target == null;
    }

    public int getTotalArmorValue() {
        return 12;
    }

    public void initCreature() {}

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
        if (!this.getEntitySenses()
            .canSee((Entity) par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving.isInWater()) {
            return false;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            return !p.capabilities.isCreativeMode;
        }
        if (par1EntityLiving instanceof ParaspriteInstance) {
            return false;
        }
        if (par1EntityLiving instanceof EntitySquid) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (par1EntityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) par1EntityLiving;
            if (!p.capabilities.isCreativeMode) {
                return true;
            }
        }
        return MobUtils.isAttackableNonMob(par1EntityLiving);
    }

    private EntityLivingBase findSomethingToAttack() {
        /*
         * if (Basic.Snap != 0) {
         * return null;
         * }
         */
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(16.0, 8.0, 16.0));
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
}
