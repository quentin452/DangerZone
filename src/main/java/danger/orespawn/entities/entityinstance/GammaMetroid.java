
package danger.orespawn.entities.entityinstance;

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
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIFollowOwner;
import danger.orespawn.entities.ai.MyEntityAIWanderALot;
import danger.orespawn.utils.GenericTargetSorter;
import danger.orespawn.utils.MyUtils;

public class GammaMetroid extends EntityTameable {

    private GenericTargetSorter TargetSorter;
    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public GammaMetroid(final World par1World) {
        super(par1World);
        this.TargetSorter = null;
        this.moveSpeed = 0.15f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.moveSpeed = 0.15f;
        this.setSize(1.5f, 1.5f);
        this.getNavigator()
            .setAvoidsWater(true);
        this.experienceValue = 20;
        this.fireResistance = 1000;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new MyEntityAIFollowOwner(this, 2.0f, 10.0f, 2.0f));
        this.tasks.addTask(3, new EntityAITempt(this, 1.2000000476837158, Items.iron_ingot, false));
        this.tasks.addTask(4, new MyEntityAIWanderALot(this, 16, 1.0));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0f));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getAttributeMap()
            .registerAttribute(SharedMonsterAttributes.attackDamage);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(OreSpawnMain.GammaMetroid_stats.attack);
    }

    protected boolean canDespawn() {
        if (this.isChild()) {
            this.func_110163_bv();
            return false;
        }
        return !this.isTamed() && !this.isNoDespawnRequired();
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        final boolean var4 = par1Entity
            .attackEntityFrom(DamageSource.causeMobDamage(this), (float) OreSpawnMain.GammaMetroid_stats.attack);
        return var4;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (super.interact(par1EntityPlayer)) {
            return true;
        }
        if (var2 != null && var2.getItem() == Items.iron_ingot && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
            if (!this.isTamed()) {
                if (!this.worldObj.isRemote) {
                    if (this.rand.nextInt(3) == 0) {
                        this.setTamed(true);
                        this.func_152115_b(
                            par1EntityPlayer.getUniqueID()
                                .toString());
                        this.playTameEffect(true);
                        this.worldObj.setEntityState(this, (byte) 7);
                        this.heal(this.mygetMaxHealth() - this.getHealth());
                    } else {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState(this, (byte) 6);
                    }
                }
            } else if (this.func_152114_e(par1EntityPlayer)) {
                if (this.worldObj.isRemote) {
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte) 7);
                }
                if (this.mygetMaxHealth() > this.getHealth()) {
                    this.heal(this.mygetMaxHealth() - this.getHealth());
                }
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack = var2;
                --itemStack.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Item.getItemFromBlock((Block) Blocks.deadbush)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0
            && this.func_152114_e(par1EntityPlayer)) {
            if (!this.worldObj.isRemote) {
                this.setTamed(false);
                this.func_152115_b("");
                this.playTameEffect(false);
                this.worldObj.setEntityState(this, (byte) 6);
            }
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack2 = var2;
                --itemStack2.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && var2 != null
            && var2.getItem() == Items.name_tag
            && par1EntityPlayer.getDistanceSqToEntity(this) < 16.0
            && this.func_152114_e(par1EntityPlayer)) {
            this.setCustomNameTag(var2.getDisplayName());
            if (!par1EntityPlayer.capabilities.isCreativeMode) {
                final ItemStack itemStack3 = var2;
                --itemStack3.stackSize;
                if (var2.stackSize <= 0) {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
                }
            }
            return true;
        }
        if (this.isTamed() && this.func_152114_e(par1EntityPlayer)
            && par1EntityPlayer.getDistanceSqToEntity(this) < 25.0) {
            if (!this.isSitting()) {
                this.setSitting(true);
            } else {
                this.setSitting(false);
            }
            return true;
        }
        return false;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public int mygetMaxHealth() {
        return OreSpawnMain.GammaMetroid_stats.health;
    }

    public int getTotalArmorValue() {
        return OreSpawnMain.GammaMetroid_stats.defense;
    }

    protected boolean isAIEnabled() {
        return true;
    }

    public void onLivingUpdate() {
        super.onLivingUpdate();
    }

    protected String getLivingSound() {
        if (this.worldObj.rand.nextInt(5) == 1) {
            return "orespawn:wtf_living";
        }
        return null;
    }

    protected String getHurtSound() {
        return "orespawn:duck_hurt";
    }

    protected String getDeathSound() {
        return "orespawn:alo_death";
    }

    protected float getSoundVolume() {
        return 1.5f;
    }

    protected float getSoundPitch() {
        return 1.0f;
    }

    protected Item getDropItem() {
        return Items.iron_ingot;
    }

    private void dropItemRand(final Item index, final int par1) {
        final EntityItem var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            this.posY + 1.0,
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            new ItemStack(index, par1, 0));
        this.worldObj.spawnEntityInWorld(var3);
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        for (int i = 5 + OreSpawnMain.OreSpawnRand.nextInt(10), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.gold_nugget, 1);
        }
        for (int i = 6 + OreSpawnMain.OreSpawnRand.nextInt(10), var4 = 0; var4 < i; ++var4) {
            this.dropItemRand(Items.iron_ingot, 1);
        }
    }

    protected void updateAITasks() {
        if (this.isDead) {
            return;
        }
        super.updateAITasks();
        if (this.worldObj.difficultySetting != EnumDifficulty.PEACEFUL && this.worldObj.rand.nextInt(5) == 0) {
            final EntityLivingBase e = this.findSomethingToAttack();
            if (e != null) {
                this.faceEntity(e, 10.0f, 10.0f);
                if (this.getDistanceSqToEntity(e) <= 9.0) {
                    if (this.worldObj.rand.nextInt(4) == 0 || this.worldObj.rand.nextInt(5) == 1) {
                        this.attackEntityAsMob(e);
                    }
                } else {
                    this.getNavigator()
                        .tryMoveToEntityLiving(e, 1.25);
                }
            }
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
        final MyUtils oreSpawnUtils = OreSpawnMain.OreSpawnUtils;
        if (MyUtils.isIgnoreable(par1EntityLiving)) {
            return false;
        }
        if (!this.getEntitySenses()
            .canSee(par1EntityLiving)) {
            return false;
        }
        if (par1EntityLiving instanceof GammaMetroid) {
            return false;
        }
        if (par1EntityLiving instanceof EntityMob) {
            return false;
        }
        if (this.isTamed()) {
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

    private EntityLivingBase findSomethingToAttack() {
        if (OreSpawnMain.PlayNicely != 0) {
            return null;
        }
        if (this.isChild()) {
            return null;
        }
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, this.boundingBox.expand(10.0, 3.0, 10.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
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

    protected boolean isValidLightLevel() {
        final int i = MathHelper.floor_double(this.posX);
        final int j = MathHelper.floor_double(this.boundingBox.minY);
        final int k = MathHelper.floor_double(this.posZ);
        if (this.worldObj.getSavedLightValue(EnumSkyBlock.Sky, i, j, k) > this.rand.nextInt(32)) {
            return false;
        }
        int l = this.worldObj.getBlockLightValue(i, j, k);
        if (this.worldObj.isThundering()) {
            final int i2 = this.worldObj.skylightSubtracted;
            this.worldObj.skylightSubtracted = 10;
            l = this.worldObj.getBlockLightValue(i, j, k);
            this.worldObj.skylightSubtracted = i2;
        }
        return l <= this.rand.nextInt(8);
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
                        if (s != null && s.equals("WTF?")) {
                            return true;
                        }
                    }
                }
            }
        }
        if (!this.isValidLightLevel()) {
            return false;
        }
        if (this.worldObj.provider.dimensionId == OreSpawnMain.DimensionID4) {
            return true;
        }
        if (this.posY > 50.0) {
            return false;
        }
        for (int k = -1; k < 1; ++k) {
            for (int j = -1; j < 1; ++j) {
                for (int i = 1; i < 4; ++i) {
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

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if (bid == Blocks.stone) {
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
                if (bid == Blocks.stone) {
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
                if (bid == Blocks.stone) {
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
                if (bid == Blocks.stone) {
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
                if (bid == Blocks.stone) {
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
                if (bid == Blocks.stone) {
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

    protected void updateAITick() {
        if (this.isDead) {
            return;
        }
        super.updateAITick();
        if (((this.worldObj.rand.nextInt(20) == 0 && this.getHealth() < this.mygetMaxHealth())
            || this.worldObj.rand.nextInt(100) == 0) && OreSpawnMain.PlayNicely == 0 && !this.isSitting()) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 6; ++i) {
                int j = i;
                if (j > 2) {
                    j = 2;
                }
                if (this.scan_it((int) this.posX, (int) this.posY + 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 4) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0);
                if (this.closest < 12) {
                    if (this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing")) {
                        this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
                    }
                    this.heal(1.0f);
                    this.playSound("random.burp", 0.5f, this.worldObj.rand.nextFloat() * 0.2f + 1.5f);
                }
            }
        }
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return (EntityAgeable) this.spawnBabyAnimal(entityageable);
    }

    public GammaMetroid spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        final GammaMetroid w = new GammaMetroid(this.worldObj);
        if (this.isTamed()) {
            this.func_152115_b(this.func_152113_b());
            w.setTamed(true);
        }
        return w;
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.iron_ingot;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }
}
