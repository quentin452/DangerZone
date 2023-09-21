
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.ai.MyEntityAIWander;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

public class Baryonyx extends EntityAnimal {

    private float moveSpeed;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public Baryonyx(final World par1World) {
        super(par1World);
        this.moveSpeed = 0.25f;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(1.5f, 2.8f);
        this.moveSpeed = 0.25f;
        this.fireResistance = 100;
        this.experienceValue = 5;
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIMate((EntityAnimal) this, 1.0));
        this.tasks.addTask(2, new EntityAIAvoidEntity(this, EntityMob.class, 8.0f, 1.0, 1.399999976158142));
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
            .setBaseValue(8.0);
    }

    protected void entityInit() {
        super.entityInit();
    }

    public boolean getCanSpawnHere() {
        return this.posY >= 50.0 && this.worldObj.isDaytime() && this.findBuddies() <= 8;
    }

    public void onUpdate() {
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        super.onUpdate();
    }

    public boolean isAIEnabled() {
        return true;
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    public int mygetMaxHealth() {
        return 40;
    }

    protected String getLivingSound() {
        return null;
    }

    protected String getHurtSound() {
        return Tags.MODID + ":duck_hurt";
    }

    protected String getDeathSound() {
        return Tags.MODID + ":duck_hurt";
    }

    protected float getSoundVolume() {
        return 0.4f;
    }

    protected Item getDropItem() {
        return Items.beef;
    }

    protected void dropFewItems(final boolean par1, final int par2) {
        int var3 = 0;
        var3 = this.rand.nextInt(5);
        var3 += 2;
        for (int var4 = 0; var4 < var3; ++var4) {
            this.dropItem(Items.beef, 1);
        }
    }

    private boolean scan_it(final int x, final int y, final int z, final int dx, final int dy, final int dz) {
        int found = 0;
        for (int i = -dy; i <= dy; ++i) {
            for (int j = -dz; j <= dz; ++j) {
                Block bid = this.worldObj.getBlock(x + dx, y + i, z + j);
                if (bid == Blocks.grass) {
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
                if (bid == Blocks.grass) {
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
                if (bid == Blocks.grass) {
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
                if (bid == Blocks.grass) {
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
                if (bid == Blocks.grass) {
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
                if (bid == Blocks.grass) {
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
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(60) == 0 && OreSpawnMain.PlayNicely == 0) {
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
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0);
                if (this.closest < 12) {
                    if (this.worldObj.getGameRules()
                        .getGameRuleBooleanValue("mobGriefing")) {
                        this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.dirt, 0, 2);
                    }
                    this.heal(1.0f);
                    this.playSound("random.burp", 1.0f, this.worldObj.rand.nextFloat() * 0.2f + 0.9f);
                }
            }
        }
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

    public Baryonyx spawnBabyAnimal(final EntityAgeable par1EntityAgeable) {
        return new Baryonyx(this.worldObj);
    }

    public boolean isWheat(final ItemStack par1ItemStack) {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.apple;
    }

    public boolean isBreedingItem(final ItemStack par1ItemStack) {
        return par1ItemStack.getItem() == OreSpawnMain.MyCrystalApple;
    }

    private int findBuddies() {
        final List var5 = this.worldObj
            .getEntitiesWithinAABB(Baryonyx.class, this.boundingBox.expand(20.0, 10.0, 20.0));
        return var5.size();
    }
}
