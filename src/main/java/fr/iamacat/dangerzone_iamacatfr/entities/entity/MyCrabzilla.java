
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityTameable;
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

import fr.iamacat.dangerzone_iamacatfr.entities.ai.AIFollowOwner;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderInfo;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MyCrabzilla extends EntityTameable {

    private GenericTargetSorter TargetSorter;
    private RenderInfo renderdata;
    private int stream_count;
    private int dmgDelay;
    private float moveSpeed;
    private float knockResistance;
    private double attdam;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public MyCrabzilla(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.renderdata = new RenderInfo();
        this.stream_count = 0;
        this.dmgDelay = 0;
        this.moveSpeed = 0.45f;
        this.knockResistance = 4.75f;
        this.attdam = 125.0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.25f;
        this.setSize(3.74f, 10.0f);
        this.getNavigator()
            .setAvoidsWater(false);
        this.canBreatheUnderwater();
        this.experienceValue = 100;
        this.fireResistance = 3;
        this.isImmuneToFire = true;
        this.renderDistanceWeight = 12.0;
        this.TargetSorter = new GenericTargetSorter((Entity) this);
        this.renderdata = new RenderInfo();
        this.tasks.addTask(0, new EntityAISwimming( this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new AIFollowOwner((EntityTameable) this, 2.0f, 10.0f, 2.0f));
        this.tasks
            .addTask(3, new EntityAITempt( this, 1.200000047683716, Items.fish, false));
        this.tasks.addTask(4, new EntityAIWander( this, 1.0));
        this.tasks
            .addTask(5, new EntityAIWatchClosest( this,  EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle( this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget( this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue((double) this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance)
            .setBaseValue(12.0);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.attdam = 175.0;
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(this.attdam);
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

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        return false;
    }

    protected boolean canDespawn() {
        return false;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue((double) this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return 2250;
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
        return 23;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
        if (this.isInWater()) {
            this.moveSpeed = 0.85f;
        } else {
            this.moveSpeed = 0.35f;
        }
    }

    public void onDeathUpdate() {
        super.onDeathUpdate();
        for (int i = 0; i < 20; ++i) {
            final float var1 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            final float var2 = (this.rand.nextFloat() - 0.5f) * 4.0f;
            final float var3 = (this.rand.nextFloat() - 0.5f) * 8.0f;
            this.worldObj.spawnParticle(
                "angryVillager",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.75,
                0.0);
            this.worldObj.spawnParticle(
                "instantSpell",
                this.posX + var1,
                this.posY + 2.0 + var2,
                this.posZ + var3,
                0.0,
                0.75,
                0.0);
            this.worldObj
                .spawnParticle("spell", this.posX + var1, this.posY + 2.0 + var2, this.posZ + var3, 0.0, 0.75, 0.0);
        }
    }

    public int getOversizedCrabHealth() {
        return (int) this.getHealth();
    }

    public int getAttackStrength(final Entity par1Entity) {
        int var2 = 4;
        if (this.worldObj.difficultySetting == EnumDifficulty.EASY) {
            var2 = 8;
            if (this.worldObj.difficultySetting == EnumDifficulty.NORMAL) {
                var2 = 8;
            } else if (this.worldObj.difficultySetting == EnumDifficulty.HARD) {
                var2 = 10;
            }
        }
        return var2;
    }

    protected String getLivingSound() {
        if (this.rand.nextInt(3) == 0) {
            return "";
        }
        return "";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":bosshurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":bosshurt";
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 1.4f;
    }

    protected Item getDropItemId() {
        return Items.beef;
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
        ItemStack is = null;
        this.dropItemRand(Items.golden_apple, 5);
        /*
         * for (int var4 = 0; var4 < 2; ++var4) {
         * this.dropBlockRand(Basic.phoenixBlock, 1);
         * }
         * for (int var4 = 0; var4 < 4; ++var4) {
         * this.dropItemRand(Basic.eggLeviathan, 1);
         * }
         * for (int var4 = 0; var4 < 6; ++var4) {
         * this.dropItemRand(Basic.eggParasprite, 1);
         * }
         * for (int var4 = 0; var4 < 12; ++var4) {
         * this.dropItemRand(Basic.diamondGems, 1);
         * }
         * for (int var4 = 0; var4 < 12; ++var4) {
         * this.dropItemRand(Basic.butterFlies, 1);
         * }
         * for (int var4 = 0; var4 < 16; ++var4) {
         * this.dropBlockRand(Basic.robotBlock, 1);
         * }
         */
        for (int i = 1 + this.worldObj.rand.nextInt(5), var4 = 0; var4 < i; ++var4) {
            final int var5 = this.worldObj.rand.nextInt(20);
            switch (var5) {
                case 0: {
                    // is = this.dropBlockRand(Basic.hardAppleBlock, 1);
                    break;
                }
                case 1: {
                    // is = this.dropItemRand(Basic.darkHelmet, 1);
                    break;
                }
            }
        }
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 475.0f);
        if (var4) {
            if (par1Entity != null && par1Entity instanceof EntityLivingBase) {
                final double ks = 2.6;
                double inair = 0.75;
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
        if (dm > 1750.0f) {
            dm = 1750.0f;
        }
        if (par1DamageSource.getDamageType()
            .equals("cactus")) {
            return false;
        }
        final Entity e = par1DamageSource.getEntity();
        if (e != null && e instanceof MyCrabzilla) {
            return false;
        }
        if (this.dmgDelay <= 0) {
            ret = super.attackEntityFrom(par1DamageSource, dm);
            this.dmgDelay = 25;
        }
        if (e != null && e instanceof EntityLiving) {
            if (e instanceof MyCrabzilla) {
                return false;
            }
            this.setAttackTarget((EntityLivingBase) e);
            this.setTarget(e);
            this.getNavigator()
                .tryMoveToEntityLiving((Entity) e, 1.2);
        }
        return ret;
    }

    private boolean Scanfor(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.worldObj.getBlock(x - dx, y + i, z + j);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    final int d = dx * dx + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x - dx;
                        this.ty = y + i;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + i, y + dy, z + j);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
                bid = this.worldObj.getBlock(x + i, y - dy, z + j);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    final int d = dy * dy + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y - dy;
                        this.tz = z + j;
                        ++found;
                    }
                }
            }
        }
        for (int i = -dx; i <= dx; ++i) {
            for (int j = -dy; j <= dy; ++j) {
                Block bid = this.worldObj.getBlock(x + i, y + j, z + dz);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z + dz;
                        ++found;
                    }
                }
                bid = this.worldObj.getBlock(x + i, y + j, z - dz);
                if (bid == Blocks.water || bid == Blocks.flowing_water) {
                    final int d = dz * dz + j * j + i * i;
                    if (d < this.closest) {
                        this.closest = d;
                        this.tx = x + i;
                        this.ty = y + j;
                        this.tz = z - dz;
                        ++found;
                    }
                }
            }
        }
        return found != 0;
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.rand.nextInt(6) == 1) {
            if (this.getHealth() < 1250.0f && this.getHealth() > 750.0f) {
                this.PinchHarder(this.posX, this.posY, this.posZ, 12.0, 110.0, 1);
            }
            if (this.getHealth() < 750.0f && this.getHealth() > 250.0f) {
                this.PinchHarder(this.posX, this.posY, this.posZ, 12.0, 135.0, 1);
            }
            if (this.getHealth() < 250.0f) {
                this.PinchHarder(this.posX, this.posY, this.posZ, 12.0, 165.0, 1);
            }
        }
        if (this.dmgDelay > 0) {
            --this.dmgDelay;
        }
        if (!this.isInWater() && this.worldObj.rand.nextInt(25) == 0 && !this.isSitting()) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 12; ++i) {
                int j = i;
                if (j > 10) {
                    j = 10;
                }
                if (this.Scanfor((int) this.posX, (int) this.posY - 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ((double) this.tx, (double) (this.ty - 1), (double) this.tz, 1.33);
            } else {
                if (this.worldObj.rand.nextInt(50) == 1 && this.getHealth() < this.mygetMaxHealth()) {
                    this.heal(5.0f);
                }
                if (this.getHealth() <= 0.0f) {
                    this.setDead();
                    return;
                }
            }
        }
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 1) {
            EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                this.setAttacking(1);
                if (this.getDistanceSqToEntity(e) < (16.0f + e.width / 2.0f) * (16.0f + e.width / 2.0f)) {
                    this.worldObj.rand.nextInt(1);
                    this.attackEntityAsMob(e);
                    if (!this.worldObj.isRemote) {
                        if (this.worldObj.rand.nextInt(9) == 1) {
                            this.worldObj.playSoundAtEntity(e, Tags.MODID + ":pincer_a1", 3.5f, 1.0f);
                        } else {
                            this.worldObj.playSoundAtEntity(e, Tags.MODID + ":pincer_a2", 3.5f, 1.0f);
                        }
                    }
                }
                if (this.getDistanceSqToEntity(e) < (60.0f + e.width / 2.0f) * (60.0f + e.width / 2.0f)) {
                    e = null;
                    e = this.findSomethingToAttack();
                    if (e != null) {
                        this.faceEntity(e, 10.0f, 10.0f);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.0);
                }
            } else {
                this.setAttacking(0);
            }
        }
        if (this.worldObj.rand.nextInt(100) == 1 && this.isInWater() && this.getHealth() < this.mygetMaxHealth()) {
            this.heal(7.0f);
        }
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
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof MyCrabzilla) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return true;
        }
        if (this.isTamed()) {
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
        if (this.isChild()) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB( EntityLivingBase.class, this.boundingBox.expand(64.0, 64.0, 64.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7;
        EntityLivingBase var8;
        final EntityLivingBase e = this.getAttackTarget();
        if (e != null && e.isEntityAlive()) {
            return e;
        }
        this.setAttackTarget(null);
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8)) {
                return var8;
            }
        }
        return null;
    }

    public int getAttacking() {
        return this.dataWatcher.getWatchableObjectByte(20);
    }

    public void setAttacking(final int par1) {
        this.dataWatcher.updateObject(20, (byte) par1);
    }

    public boolean getCanSpawnHere() {
        for (int k = -8; k < 8; ++k) {
            for (int j = -12; j < 12; ++j) {
                for (int i = 0; i < 10; ++i) {
                    final Block bid = this.worldObj
                        .getBlock((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                    if (bid == Blocks.mob_spawner) {
                        TileEntityMobSpawner tileentitymobspawner = null;
                        tileentitymobspawner = (TileEntityMobSpawner) this.worldObj
                            .getTileEntity((int) this.posX + j, (int) this.posY + i, (int) this.posZ + k);
                        final String s = tileentitymobspawner.func_145881_a()
                            .getEntityNameToSpawn();
                        if (s != null && s.equals("MyCrabzilla")) {
                            return true;
                        }
                    }
                }
            }
        }
        MyCrabzilla target;
        if (this.posY < 50.0) {
            return false;
        }
        if (!this.worldObj.isDaytime()) {
            return false;
        }
        target = (MyCrabzilla) this.worldObj.findNearestEntityWithinAABB(
             MyCrabzilla.class,
            this.boundingBox.expand(256.0, 256.0, 256.0),
            this);
        return target == null;
    }

    private EntityLivingBase PinchHarder(final double X, final double Y, final double Z, final double dist,
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
            if (var8 != null && var8 != this && var8.isEntityAlive() && !(var8 instanceof MyCrabzilla)) {
                DamageSource var9;
                var9 = DamageSource.setExplosionSource(null);
                var9.setExplosion();
                var8.attackEntityFrom(var9, (float) damage / 1.0f);
                var8.attackEntityFrom(DamageSource.fall, (float) damage / 1.0f);
                this.worldObj.playSoundAtEntity(
                    (Entity) var8,
                    Tags.MODID + ":pincer_a",
                    3.5f,
                    1.0f + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.5f);
                final double ks = 2.6;
                final double inair = 0.75;
                final float f3 = (float) Math.atan2(var8.posZ - this.posZ, var8.posX - this.posX);
                var8.addVelocity(Math.cos(f3) * ks, inair, Math.sin(f3) * ks);
            }
        }
        return null;
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return null;
    }

    public MyCrabzilla spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return null;
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.fish;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return false;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }
}
