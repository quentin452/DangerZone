
package danger.orespawn.entities.entityinstance;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;

import danger.orespawn.entities.ai.MyEntityAIWanderALot;
import danger.orespawn.worldgen.OreSpawnTeleporter;

public class Termite extends EntityAnt {

    int attack_delay;
    private int closest;
    private int tx;
    private int ty;
    private int tz;

    public Termite(final World par1World) {
        super(par1World);
        this.attack_delay = 20;
        this.closest = 99999;
        this.tx = 0;
        this.ty = 0;
        this.tz = 0;
        this.setSize(0.2f, 0.2f);
        this.moveSpeed = 0.20000000298023224;
        this.experienceValue = 1;
        this.getNavigator()
            .setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAIPanic(this, 1.399999976158142));
        this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0, false));
        this.tasks.addTask(2, new MyEntityAIWanderALot(this, 8, 1.0));
        if (OreSpawnMain.PlayNicely == 0) {
            this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 6, true));
        }
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth)
            .setBaseValue(this.mygetMaxHealth());
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed)
            .setBaseValue(this.moveSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage)
            .setBaseValue(2.0);
    }

    public int mygetMaxHealth() {
        return 5;
    }

    public boolean attackEntityAsMob(final Entity par1Entity) {
        if (OreSpawnMain.OreSpawnRand.nextInt(15) != 0) {
            return false;
        }
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return false;
        }
        final boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 1.0f);
        return var4;
    }

    public boolean interact(final EntityPlayer par1EntityPlayer) {
        if (par1EntityPlayer == null) {
            return false;
        }
        if (!(par1EntityPlayer instanceof EntityPlayerMP)) {
            return false;
        }
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        if (var2 != null && var2.stackSize <= 0) {
            par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, null);
            var2 = null;
        }
        if (var2 != null) {
            par1EntityPlayer.addChatComponentMessage((IChatComponent) new ChatComponentText("Empty your hand!"));
            return false;
        }
        if (par1EntityPlayer.dimension != OreSpawnMain.DimensionID5) {
            for (int i = 0; i < par1EntityPlayer.inventory.mainInventory.length; ++i) {
                if (par1EntityPlayer.inventory.mainInventory[i] != null) {
                    par1EntityPlayer
                        .addChatComponentMessage((IChatComponent) new ChatComponentText("Empty your inventory!"));
                    return false;
                }
            }
            for (int i = 0; i < par1EntityPlayer.inventory.armorInventory.length; ++i) {
                if (par1EntityPlayer.inventory.armorInventory[i] != null) {
                    par1EntityPlayer
                        .addChatComponentMessage((IChatComponent) new ChatComponentText("Take off your armor!"));
                    return false;
                }
            }
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    OreSpawnMain.DimensionID5,
                    (Teleporter) new OreSpawnTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension(OreSpawnMain.DimensionID5),
                        OreSpawnMain.DimensionID5,
                        this.worldObj));
        } else {
            MinecraftServer.getServer()
                .getConfigurationManager()
                .transferPlayerToDimension(
                    (EntityPlayerMP) par1EntityPlayer,
                    0,
                    (Teleporter) new OreSpawnTeleporter(
                        MinecraftServer.getServer()
                            .worldServerForDimension(0),
                        0,
                        this.worldObj));
        }
        return true;
    }

    public void onUpdate() {
        super.onUpdate();
        if (this.isDead) {
            return;
        }
        if (this.attack_delay > 0) {
            --this.attack_delay;
        }
        if (this.attack_delay > 0) {
            return;
        }
        this.attack_delay = 20;
        if (this.worldObj.difficultySetting == EnumDifficulty.PEACEFUL) {
            return;
        }
        final EntityLivingBase e = this.worldObj.getClosestVulnerablePlayerToEntity(this, 1.5);
        if (e != null) {
            this.attackEntityAsMob(e);
        }
    }

    public boolean isWood(final Block bid) {
        return bid == Blocks.fence || bid == Blocks.fence_gate
            || bid == Blocks.planks
            || bid == Blocks.wooden_slab
            || (bid == Blocks.double_wooden_slab || bid == Blocks.bed || bid == Blocks.crafting_table)
            || (bid == Blocks.standing_sign || bid == Blocks.bookshelf
                || bid == Blocks.wooden_door
                || bid == Blocks.wooden_pressure_plate)
            || (bid == Blocks.birch_stairs || bid == Blocks.oak_stairs
                || bid == Blocks.jungle_stairs
                || bid == Blocks.spruce_stairs)
            || bid == OreSpawnMain.CrystalPlanksBlock;
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

    public void updateAITick() {
        if (this.isDead) {
            return;
        }
        if (this.worldObj.rand.nextInt(200) == 1) {
            this.setRevengeTarget(null);
        }
        if (this.worldObj.rand.nextInt(200) == 1 && OreSpawnMain.PlayNicely == 0) {
            this.closest = 99999;
            final int tx = 0;
            this.tz = tx;
            this.ty = tx;
            this.tx = tx;
            for (int i = 1; i < 8; ++i) {
                int j = i;
                if (j > 4) {
                    j = 4;
                }
                if (this.scan_it((int) this.posX, (int) this.posY + 1, (int) this.posZ, i, j, i)) {
                    break;
                }
                if (i >= 5) {
                    ++i;
                }
            }
            int i = 0;
            if (this.closest < 99999) {
                this.getNavigator()
                    .tryMoveToXYZ(this.tx, this.ty, this.tz, 1.0);
                if (this.closest < 6) {
                    if (this.worldObj.rand.nextInt(3) != 0) {
                        if (this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing")) {
                            this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.dirt, 0, 2);
                        }
                        if (this.findBuddies() < 10) {
                            spawnCreature(
                                this.worldObj,
                                "Termite",
                                this.posX + 0.10000000149011612,
                                this.posY + 0.10000000149011612,
                                this.posZ + 0.10000000149011612);
                        }
                    } else {
                        if (this.worldObj.getGameRules()
                            .getGameRuleBooleanValue("mobGriefing")) {
                            this.worldObj.setBlock(this.tx, this.ty, this.tz, Blocks.air, 0, 2);
                        }
                        if (this.findBuddies() < 10) {
                            spawnCreature(this.worldObj, "Termite", this.tx + 0.1f, this.ty + 0.1f, this.tz + 0.1f);
                        }
                    }
                    this.heal(1.0f);
                }
            }
        }
        super.updateAITick();
    }

    private int findBuddies() {
        final List var5 = this.worldObj.getEntitiesWithinAABB(Termite.class, this.boundingBox.expand(3.0, 3.0, 3.0));
        return var5.size();
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
}
