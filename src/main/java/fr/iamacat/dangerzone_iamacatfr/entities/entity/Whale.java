
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class Whale extends EntityAnimal {

    private float moveSpeed;
    private int spray;
    private int spray_timer;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public Whale(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.35f;
        this.spray = 0;
        this.spray_timer = 0;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(1.5f, 2.5f);
        this.moveSpeed = 0.35f;
        this.fireResistance = 100;
        this.experienceValue = 40;
        this.getNavigator()
            .setAvoidsWater(false);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new EntityAITempt(this, 1.2000000476837158, Items.fish, false));
        this.tasks.addTask(4, new EntityAIPanic(this, 1.5));
        this.tasks.addTask(5, new EntityAIWatchClosest(this, EntityPlayer.class, 12.0f));
        this.tasks.addTask(6, new MyEntityAIWander(this, 1.0f));
        this.tasks.addTask(7, new EntityAILookIdle(this));
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
            .setBaseValue(0.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
        if (this.spray == 0) {
            if (this.spray_timer > 0) {
                --this.spray_timer;
            }
            if (this.spray_timer == 0) {
                this.spray_timer = 250 + this.worldObj.rand.nextInt(250);
                this.spray = 25 + this.worldObj.rand.nextInt(25);
            }
        }
        if (this.worldObj.isRemote && this.spray > 0) {
            for (int i = 0; i < 20; ++i) {
                double d = this.worldObj.rand.nextDouble() * 0.75;
                d *= d;
                double dir = this.worldObj.rand.nextDouble() * 2.0 * 3.141592653589793;
                dir -= 3.141592653589793;
                final double dx = Math.cos(dir) * d / 2.0;
                final double dz = Math.sin(dir) * d / 2.0;
                dir += 1.5707963267948966;
                if (i < 10) {
                    this.worldObj.spawnParticle(
                        "bubble",
                        this.posX + dx,
                        this.posY + 1.0 + d,
                        this.posZ + dz,
                        Math.cos(dir) * this.worldObj.rand.nextFloat() / 4.0,
                        (this.worldObj.rand.nextFloat() * 2.0f),
                        Math.sin(dir) * this.worldObj.rand.nextFloat() / 4.0);
                } else {
                    this.worldObj.spawnParticle(
                        "splash",
                        this.posX + dx,
                        this.posY + 1.0 + d,
                        this.posZ + dz,
                        Math.cos(dir) * this.worldObj.rand.nextFloat() / 4.0,
                        (this.worldObj.rand.nextFloat() * 2.0f),
                        Math.sin(dir) * this.worldObj.rand.nextFloat() / 4.0);
                }
            }
            --this.spray;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.heal(1.0f);
        }
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return true;
    }

    public int mygetMaxHealth() {
        return 100;
    }

    protected String getLivingSound() {
        return "splash";
    }

    protected String getHurtSound() {
        return Tags.MODID + ":little_splat";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":big_splat";
    }

    protected float getSoundVolume() {
        return 0.9f;
    }

    protected float getSoundPitch() {
        return 0.5f;
    }

    protected Item getDropItem() {
        return Items.fish;
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
        int var3 = 0;
        var3 = this.rand.nextInt(25);
        var3 += 20;
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItemRand(Items.fish, 1);
        }
    }

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
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

    protected void updateAITick() {
        super.updateAITick();
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (!this.isInWater() && this.worldObj.rand.nextInt(20) == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 11; ++i) {
                int j = i;
                if (j > 4) {
                    j = 4;
                }
                if (this.scan_it((int) this.posX, (int) this.posY - 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, (this.ty - 1), this.tz, 1.0);
            } else {
                if (this.worldObj.rand.nextInt(25) == 1) {
                    this.heal(-4.0f);
                }
                if (this.getHealth() <= 0.0f) {
                    this.setDead();
                    return;
                }
            }
        }
        if (this.isInWater() && this.worldObj.rand.nextInt(50) == 0) {
            this.playSound("splash", 1.0f, this.worldObj.rand.nextFloat() * 0.2f + 0.9f);
            this.heal(1.0f);
        }
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Whale.class, this.boundingBox.expand(32.0, 8.0, 32.0));
        return var5.size();
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0 && this.worldObj.isDaytime()
            && this.worldObj.rand.nextInt(50) == 1
            && this.findBuddies() <= 0;
    }

    protected boolean canDespawn() {
        if (this.isChild()) {
            this.func_110163_bv();
            return false;
        }
        return !this.isNoDespawnRequired();
    }

    public EntityAgeable createChild(final EntityAgeable entityageable) {
        return (EntityAgeable) this.spawnBabyAnimal(entityageable);
    }

    public Whale spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Whale(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.fish;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }
}
