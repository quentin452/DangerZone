
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWanderALot;
import fr.iamacat.dangerzone_iamacatfr.util.GenericTargetSorter;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Beaver extends EntityAnimal {

    private float moveSpeed;
    private GenericTargetSorter TargetSorter;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public Beaver(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.15f;
        this.TargetSorter = null;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(0.6f, 0.8f);
        this.moveSpeed = 0.2f;
        this.fireResistance = 100;
        this.getNavigator()
            .setAvoidsWater(false);
        this.experienceValue = 5;
        this.TargetSorter = new GenericTargetSorter(this);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityMob.class, 8.0f, 1.0, 1.5));
        this.tasks.addTask(4, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(5, new EntityAIAvoidEntity(this, EntityPlayer.class, 8.0f, 1.0, 1.5));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0f));
        this.tasks.addTask(7, new MyEntityAIWanderALot(this, 10, 1.0));
        this.tasks.addTask(8, new EntityAILookIdle(this));
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
            .setBaseValue(1.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public boolean isWood(final Block bid) {
        return bid == Blocks.log || bid == OreSpawnMain.MyDT
            || bid == OreSpawnMain.MySkyTreeLog
            || (bid == Blocks.fence || bid == Blocks.fence_gate || bid == Blocks.standing_sign);
    }

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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
                if (this.isWood(bid)) {
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

    private ItemStack dropItemRand(final Item index, final int par1) {
        EntityItem var3 = null;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            this.worldObj,
            this.posX + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            this.posY + 4.0 + this.worldObj.rand.nextInt(4),
            this.posZ + OreSpawnMain.OreSpawnRand.nextInt(4) - OreSpawnMain.OreSpawnRand.nextInt(4),
            is);
        if (var3 != null) {
            this.worldObj.spawnEntityInWorld(var3);
        }
        return is;
    }

    public void breakRecursor(final World world, final int x, final int y, final int z, final int xf, final int yf,
        final int zf, final int recursion) {
        final int var7 = 1;
        if (recursion > 200) {
            return;
        }
        for (int var8 = -var7; var8 <= var7; ++var8) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    if (var8 != 0 || var9 != 0 || var10 != 0) {
                        if (x + var8 != xf || y + var9 != yf || z + var10 != zf) {
                            if (recursion <= 0 || x + var8 < xf - var7
                                || x + var8 > xf + var7
                                || y + var9 < yf - var7
                                || y + var9 > yf + var7
                                || z + var10 < zf - var7
                                || z + var10 > zf + var7) {
                                final Block var11 = world.getBlock(x + var8, y + var9, z + var10);
                                if (this.isWood(var11)) {
                                    world.setBlock(x + var8, y + var9, z + var10, Blocks.air, 0, 2);
                                    this.dropItemRand(Item.getItemFromBlock(var11), 1);
                                    this.breakRecursor(world, x + var8, y + var9, z + var10, x, y, z, recursion + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    protected void updateAITick() {
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (((this.worldObj.rand.nextInt(30) == 0 && this.getBeaverHealth() < this.mygetMaxHealth())
            || this.worldObj.rand.nextInt(350) == 1) && OreSpawnMain.PlayNicely == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 11; ++i) {
                int j = i;
                if (j > 2) {
                    j = 2;
                }
                if (this.scan_it((int) this.posX, (int) this.posY + 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 6) {
                    ++i;
                }
            }
            int i = 0;
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0);
                if (this.closest < 12) {
                    if (this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing")) {
                        this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
                        this.breakRecursor(this.worldObj, this.tx, this.ty, this.tz, this.tx, this.ty, this.tz, i);
                    }
                    this.heal(1.0f);
                    this.playSound(Tags.MODID + ":chainsaw", 1.0f, this.worldObj.rand.nextFloat() * 0.2f + 0.9f);
                }
            }
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            final Beaver buddy = this.findBuddy();
            if (buddy != null) {
                this.getNavigator()
                    .tryMoveToXYZ(buddy.posX, buddy.posY, buddy.posZ, 0.5);
            }
        }
        super.updateAITick();
    }

    private Beaver findBuddy() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Beaver.class, this.boundingBox.expand(16.0, 6.0, 16.0));
        Collections.sort((List<Object>) var5, this.TargetSorter);
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        Beaver var8 = null;
        if (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (Beaver) var7;
            return var8;
        }
        return null;
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        return 15;
    }

    public int getBeaverHealth() {
        return (int) this.getHealth();
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":scorpion_hit";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":cryo_death";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }

    protected Item getDropItem() {
        return Items.porkchop;
    }

    protected float getSoundPitch() {
        return this.isChild() ? ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f + 1.5f)
            : ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.1f + 1.0f);
    }

    public boolean getCanSpawnHere() {
        if (this.posY < 50.0) {
            return false;
        }
        if (this.posY > 100.0) {
            return false;
        }
        final Block bid = this.worldObj.getBlock((int) this.posX, (int) this.posY - 1, (int) this.posZ);
        return bid == Blocks.dirt || bid == Blocks.grass || bid == Blocks.tallgrass || bid == Blocks.leaves;
    }

    protected boolean canDespawn() {
        return false;
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return (EntityAgeable) this.spawnBabyAnimal(entityageable);
    }

    public Beaver spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Beaver(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.apple;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }
}
