
package fr.iamacat.dangerzone_iamacatfr.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.TheKing;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.TheQueen;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ItemMagicApple extends Item {

    public int tree_radius;
    public boolean no_critters;
    Random rand;
    private final WeightedRandomChestContent[] chestContentsList;

    public ItemMagicApple(final int i) {
        this.tree_radius = 6;
        this.no_critters = false;
        this.rand = OreSpawnMain.OreSpawnRand;
        this.chestContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.ender_pearl, 0, 1, 2, 3),
            new WeightedRandomChestContent(Items.diamond, 0, 1, 5, 15),
            new WeightedRandomChestContent(Items.blaze_rod, 0, 1, 3, 10),
            new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 1, 10, 7),
            new WeightedRandomChestContent(OreSpawnMain.CagedGirlfriend, 0, 1, 2, 6),
            new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 10, 16),
            new WeightedRandomChestContent(Items.gold_ingot, 0, 1, 6, 16),
            new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 1, 6, 6),
            new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 1, 4, 6),
            new WeightedRandomChestContent(Items.bread, 0, 1, 8, 20),
            new WeightedRandomChestContent(Items.apple, 0, 1, 8, 20),
            new WeightedRandomChestContent(Items.cookie, 0, 1, 16, 20),
            new WeightedRandomChestContent(Items.cooked_beef, 0, 1, 8, 20),
            new WeightedRandomChestContent(Items.cooked_chicken, 0, 1, 8, 20),
            new WeightedRandomChestContent(Items.cooked_fished, 0, 1, 8, 20),
            new WeightedRandomChestContent(Items.cooked_porkchop, 0, 1, 8, 20),
            new WeightedRandomChestContent(Items.pumpkin_pie, 0, 1, 4, 20),
            new WeightedRandomChestContent(Items.carrot, 0, 1, 16, 20),
            new WeightedRandomChestContent(Items.potato, 0, 1, 16, 20),
            new WeightedRandomChestContent(OreSpawnMain.MySunFish, 0, 1, 4, 6),
            new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 1, 8, 6),
            new WeightedRandomChestContent(OreSpawnMain.MyPopcornBag, 0, 1, 4, 16),
            new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.bow, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.arrow, 0, 1, 64, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 2),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 1),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateFishingRod, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.iron_chestplate, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.iron_helmet, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.iron_leggings, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.iron_boots, 0, 1, 1, 20),
            new WeightedRandomChestContent(Items.diamond_chestplate, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.diamond_helmet, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.diamond_leggings, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.diamond_boots, 0, 1, 1, 5),
            new WeightedRandomChestContent(Items.golden_apple, 0, 1, 1, 5) };
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.fortune, 2);
    }

    private Entity spawnCreature(World world, double x, double y, double z) {

        Entity entity = EntityList.createEntityByID(99, world);

        if (entity != null) {
            entity.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360F, 0F);

            world.spawnEntityInWorld(entity);

            return entity;
        }

        return null;

    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.fortune.effectId, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.fortune, 2);
        }
    }

    public void onUpdate(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4,
        final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }

    private Boolean isBoringBlock(final World world, final int x, final int y, final int z) {
        final Block var1 = world.getBlock(x, y, z);
        if (var1 == Blocks.tallgrass) {
            return true;
        }
        if (var1 == Blocks.cactus) {
            return true;
        }
        if (var1 == Blocks.red_flower) {
            return true;
        }
        if (var1 == Blocks.yellow_flower) {
            return true;
        }
        if (var1 == Blocks.leaves) {
            return true;
        }
        if (var1 == Blocks.snow) {
            return true;
        }
        if (var1 == OreSpawnMain.MyStrawberryPlant) {
            return true;
        }
        if (var1 == OreSpawnMain.MyAppleLeaves) {
            return true;
        }
        if (world.isAirBlock(x, y, z)) {
            return true;
        }
        if (var1 == null) {
            return true;
        }
        return false;
    }

    private Boolean isBoringBaseBlock(final World world, final int x, final int y, final int z) {
        if (world.isAirBlock(x, y, z)) {
            return true;
        }
        final Block var1 = world.getBlock(x, y, z);
        if (var1 == Blocks.stone) {
            return false;
        }
        if (var1 == Blocks.bedrock) {
            return false;
        }
        return true;
    }

    private void growVines(final World world, final int par2, int par3, final int par4, final int par5, int par6,
        final Chunk chunk) {
        if (world.getBlock(par2, par3, par4) != Blocks.air) {
            return;
        }
        this.FastSetBlock(world, par2, par3, par4, Blocks.vine, par5, 2, chunk);
        while (par6 > 0) {
            --par3;
            if (world.getBlock(par2, par3, par4) != Blocks.air) {
                return;
            }
            this.FastSetBlock(world, par2, par3, par4, Blocks.vine, par5, 2, chunk);
            --par6;
        }
    }

    private void make_branch(final World world, final int x, final int y, final int z, final int this_width,
        final int dirx, final int dirz, final Block ID, final Block leafID, final int tree_type, final int t_radius,
        final boolean bad_critters, final Chunk chunk) {
        int current_width = this_width;
        int last_branch = 0;
        int branch_side = 1;
        int leaf_depth = 0;
        int leaf_width = 0;
        int xaccum = dirx;
        int zaccum = dirz;
        if (this.rand.nextInt(2) == 0) {
            branch_side = -1;
        }
        while (current_width >= 0) {
            for (int length = this_width * 3 + this.rand.nextInt(this_width + 3), i = 0; i < length; ++i) {
                for (int j = -current_width; j <= current_width; ++j) {
                    final int realx = x + j * dirz + xaccum;
                    final int realz = z + j * dirx + zaccum;
                    if (this.isBoringBlock(world, realx, y, realz)) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, realx, y, realz, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, realx, y, realz, ID, 0, 2, chunk);
                        }
                    }
                    if (i > 0 && j == 0 && current_width >= 3) {
                        if ((tree_type >= 0 && this.rand.nextInt(75) == 0)
                            || (tree_type < 0 && this.rand.nextInt(50) == 0)) {
                            if (!bad_critters && world.isAirBlock(realx, y + 1, realz)) {
                                this.FastSetBlock(world, realx, y + 1, realz, (Block) Blocks.chest, 0, 2, chunk);
                                final TileEntityChest chest = (TileEntityChest) world
                                    .getTileEntity(realx, y + 1, realz);
                                if (chest != null) {
                                    WeightedRandomChestContent.generateChestContents(
                                        this.rand,
                                        this.chestContentsList,
                                        (IInventory) chest,
                                        1 + this.rand.nextInt(8));
                                }
                            }
                        } else if (this.rand.nextInt(50) == 0 && !bad_critters
                            && world.isAirBlock(realx, y + 1, realz)
                            && world.isAirBlock(realx, y + 2, realz)
                            && world.isAirBlock(realx, y + 3, realz)) {
                                Entity ent = null;
                                ent = this.spawnCreature(world, realx + 0.5, y + 1.01, realz + 0.5);
                            }
                    }
                }
                if (current_width < 3 || this_width <= 1) {
                    leaf_depth = 2 + this.rand.nextInt(2);
                    leaf_width = 2 + this.rand.nextInt(3);
                    for (int n = 0; n < leaf_depth; ++n) {
                        int lw = current_width + leaf_width - n;
                        if (current_width == 0 && length - i <= 2 && lw >= length - i) {
                            lw = length - i - 1;
                        }
                        if (lw < 0) {
                            lw = 0;
                        }
                        for (int j = -lw; j <= lw; ++j) {
                            final int realx = x + j * Math.abs(dirz) + xaccum + dirx;
                            final int realz = z + j * Math.abs(dirx) + zaccum + dirz;
                            if (this.isBoringBlock(world, realx, y + n, realz)) {
                                if (tree_type >= 0) {
                                    this.FastSetBlock(world, realx, y + n, realz, leafID, tree_type, 2, chunk);
                                    if (n == 0 && tree_type == 3
                                        && lw != 0
                                        && (j == lw || j == -lw)
                                        && this.rand.nextInt(5) == 0) {
                                        if (dirx == 0) {
                                            if (j == lw) {
                                                this.growVines(
                                                    world,
                                                    realx + 1,
                                                    y,
                                                    realz,
                                                    2,
                                                    this.rand.nextInt(10),
                                                    chunk);
                                            } else {
                                                this.growVines(
                                                    world,
                                                    realx - 1,
                                                    y,
                                                    realz,
                                                    8,
                                                    this.rand.nextInt(10),
                                                    chunk);
                                            }
                                        } else if (j == lw) {
                                            this.growVines(world, realx, y, realz + 1, 4, this.rand.nextInt(10), chunk);
                                        } else {
                                            this.growVines(world, realx, y, realz - 1, 1, this.rand.nextInt(10), chunk);
                                        }
                                    }
                                } else {
                                    Block local_leaf_type = leafID;
                                    if (this.rand.nextInt(20) == 1) {
                                        if (this.rand.nextInt(3) != 0) {
                                            local_leaf_type = Blocks.redstone_block;
                                        } else {
                                            final int ilt = this.rand.nextInt(4);
                                            if (ilt == 0) {
                                                local_leaf_type = OreSpawnMain.MyBlockUraniumBlock;
                                            }
                                            if (ilt == 1) {
                                                local_leaf_type = OreSpawnMain.MyBlockTitaniumBlock;
                                            }
                                            if (ilt == 2) {
                                                local_leaf_type = OreSpawnMain.MyBlockRubyBlock;
                                            }
                                            if (ilt == 3) {
                                                local_leaf_type = OreSpawnMain.MyBlockAmethystBlock;
                                            }
                                        }
                                    }
                                    this.FastSetBlock(world, realx, y + n, realz, local_leaf_type, 0, 2, chunk);
                                }
                            }
                        }
                    }
                }
                if (current_width > 0 && last_branch > current_width
                    && current_width != this_width
                    && this.rand.nextInt(current_width + 1) == 0) {
                    int subdirx = branch_side;
                    int subdirz = 0;
                    if (dirx != 0) {
                        subdirx = 0;
                        subdirz = branch_side;
                    }
                    this.make_branch(
                        world,
                        x + xaccum + current_width * subdirx,
                        y,
                        z + zaccum + current_width * subdirz,
                        current_width - 1,
                        subdirx,
                        subdirz,
                        ID,
                        leafID,
                        tree_type,
                        t_radius,
                        bad_critters,
                        chunk);
                    last_branch = 0;
                    if (branch_side < 0) {
                        branch_side = 1;
                    } else {
                        branch_side = -1;
                    }
                }
                xaccum += dirx;
                zaccum += dirz;
                ++last_branch;
            }
            --current_width;
        }
    }

    public void MakeBigSquareTree(final World world, final int x, final int y, final int z, final Block ID,
        final Block leafID, final Block stepID, final int tree_type, final int t_radius, final boolean bad_critters,
        final Chunk chunk) {
        int this_height = t_radius + this.rand.nextInt(t_radius);
        int this_width = t_radius;
        int base_height = t_radius * 3;
        int spiral = 0;
        int current_y = 0;
        final int branch = 0;
        int do_floor = 0;
        int platform_looper = 1;
        int last = -1;
        int last_last = -1;
        for (int i = -t_radius; i <= t_radius; ++i) {
            if (this.isBoringBaseBlock(world, x + i, y, z - t_radius)) {
                for (int j = 0; j < 20; ++j) {
                    if (y - j > 0) {
                        if (!this.isBoringBaseBlock(world, x + i, y - j, z - t_radius)) {
                            break;
                        }
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + i, y - j, z - t_radius, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + i, y - j, z - t_radius, ID, 0, 2, chunk);
                        }
                    }
                }
            }
            if (this.isBoringBaseBlock(world, x + i, y, z + t_radius)) {
                for (int j = 0; j < 20; ++j) {
                    if (y - j > 0) {
                        if (!this.isBoringBaseBlock(world, x + i, y - j, z + t_radius)) {
                            break;
                        }
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + i, y - j, z + t_radius, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + i, y - j, z + t_radius, ID, 0, 2, chunk);
                        }
                    }
                }
            }
            if (this.isBoringBaseBlock(world, x - t_radius, y, z + i)) {
                for (int j = 0; j < 20; ++j) {
                    if (y - j > 0) {
                        if (!this.isBoringBaseBlock(world, x - t_radius, y - j, z + i)) {
                            break;
                        }
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x - t_radius, y - j, z + i, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x - t_radius, y - j, z + i, ID, 0, 2, chunk);
                        }
                    }
                }
            }
            if (this.isBoringBaseBlock(world, x + t_radius, y, z + i)) {
                for (int j = 0; j < 20; ++j) {
                    if (y - j > 0) {
                        if (!this.isBoringBaseBlock(world, x + t_radius, y - j, z + i)) {
                            break;
                        }
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + t_radius, y - j, z + i, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + t_radius, y - j, z + i, ID, 0, 2, chunk);
                        }
                    }
                }
            }
        }
        current_y = y;
        do_floor = 0;
        spiral = -this_width;
        while (this_width >= 0) {
            if (this_width != t_radius) {
                base_height = 0;
            }
            for (int j = 0; j < this_height + base_height; ++j) {
                do_floor = 0;
                for (int i = -this_width; i <= this_width; ++i) {
                    if (this.isBoringBaseBlock(world, x + i, current_y, z - this_width)) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + i, current_y, z - this_width, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + i, current_y, z - this_width, ID, 0, 2, chunk);
                        }
                    }
                    if (this.isBoringBaseBlock(world, x + i, current_y, z + this_width)) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + i, current_y, z + this_width, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + i, current_y, z + this_width, ID, 0, 2, chunk);
                        }
                    }
                    if (this.isBoringBaseBlock(world, x - this_width, current_y, z + i)) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x - this_width, current_y, z + i, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x - this_width, current_y, z + i, ID, 0, 2, chunk);
                        }
                    }
                    if (this.isBoringBaseBlock(world, x + this_width, current_y, z + i)) {
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + this_width, current_y, z + i, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + this_width, current_y, z + i, ID, 0, 2, chunk);
                        }
                    }
                }
                if (this_width != 0 || j < this_height / 2) {
                    platform_looper = 1;
                    if ((spiral == 0 && this_width >= 2) || spiral == this_width
                        || (spiral == this_width - 1 && j == this_height + base_height - 1)) {
                        ++platform_looper;
                        if (spiral != 0 && this_width >= 3) {
                            ++platform_looper;
                        }
                        if (spiral == 0) {
                            do_floor = 1;
                        }
                    }
                    for (int k = 0; k < platform_looper; ++k) {
                        if (this.isBoringBlock(world, x - spiral, current_y, z - this_width - 1)) {
                            this.FastSetBlock(world, x - spiral, current_y, z - this_width - 1, stepID, 0, 2, chunk);
                        }
                        if (this.isBoringBlock(world, x + spiral, current_y, z + this_width + 1)) {
                            this.FastSetBlock(world, x + spiral, current_y, z + this_width + 1, stepID, 0, 2, chunk);
                        }
                        if (this.isBoringBlock(world, x - this_width - 1, current_y, z + spiral)) {
                            this.FastSetBlock(world, x - this_width - 1, current_y, z + spiral, stepID, 0, 2, chunk);
                        }
                        if (this.isBoringBlock(world, x + this_width + 1, current_y, z - spiral)) {
                            this.FastSetBlock(world, x + this_width + 1, current_y, z - spiral, stepID, 0, 2, chunk);
                        }
                        if (this_width >= 3) {
                            if (this.isBoringBlock(world, x - spiral, current_y, z - this_width - 2)) {
                                this.FastSetBlock(
                                    world,
                                    x - spiral,
                                    current_y,
                                    z - this_width - 2,
                                    stepID,
                                    0,
                                    2,
                                    chunk);
                            }
                            if (this.isBoringBlock(world, x + spiral, current_y, z + this_width + 2)) {
                                this.FastSetBlock(
                                    world,
                                    x + spiral,
                                    current_y,
                                    z + this_width + 2,
                                    stepID,
                                    0,
                                    2,
                                    chunk);
                            }
                            if (this.isBoringBlock(world, x - this_width - 2, current_y, z + spiral)) {
                                this.FastSetBlock(
                                    world,
                                    x - this_width - 2,
                                    current_y,
                                    z + spiral,
                                    stepID,
                                    0,
                                    2,
                                    chunk);
                            }
                            if (this.isBoringBlock(world, x + this_width + 2, current_y, z - spiral)) {
                                this.FastSetBlock(
                                    world,
                                    x + this_width + 2,
                                    current_y,
                                    z - spiral,
                                    stepID,
                                    0,
                                    2,
                                    chunk);
                            }
                        }
                        if (platform_looper != 1) {
                            ++spiral;
                        }
                    }
                    if (do_floor != 0) {
                        for (int m = -this_width; m <= this_width; ++m) {
                            for (int n = -this_width; n <= this_width; ++n) {
                                if (this.isBoringBlock(world, x + m, current_y, z + n)) {
                                    if (tree_type >= 0) {
                                        this.FastSetBlock(world, x + m, current_y, z + n, ID, tree_type, 2, chunk);
                                    } else {
                                        this.FastSetBlock(world, x + m, current_y, z + n, ID, 0, 2, chunk);
                                    }
                                    if (m == 0 && n == 0
                                        && this.rand.nextInt(2) == 0
                                        && !bad_critters
                                        && world.isAirBlock(x, current_y + 1, z)) {
                                        this.FastSetBlock(
                                            world,
                                            x,
                                            current_y + 1,
                                            z,
                                            (Block) Blocks.chest,
                                            0,
                                            2,
                                            chunk);
                                        final TileEntityChest chest = (TileEntityChest) world
                                            .getTileEntity(x, current_y + 1, z);
                                        if (chest != null) {
                                            WeightedRandomChestContent.generateChestContents(
                                                this.rand,
                                                this.chestContentsList,
                                                (IInventory) chest,
                                                t_radius - this_width + this.rand.nextInt(10));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                if (this_width != t_radius) {
                    int next;
                    for (next = this.rand.nextInt(4 + this_width); next == last
                        || next == last_last; next = this.rand.nextInt(4 + this_width)) {}
                    if (next < 4) {
                        last_last = last;
                        last = next;
                    }
                    switch (next) {
                        case 0: {
                            this.make_branch(
                                world,
                                x + this_width,
                                current_y,
                                z,
                                this_width,
                                1,
                                0,
                                ID,
                                leafID,
                                tree_type,
                                t_radius,
                                bad_critters,
                                chunk);
                            break;
                        }
                        case 1: {
                            this.make_branch(
                                world,
                                x - this_width,
                                current_y,
                                z,
                                this_width,
                                -1,
                                0,
                                ID,
                                leafID,
                                tree_type,
                                t_radius,
                                bad_critters,
                                chunk);
                            break;
                        }
                        case 2: {
                            this.make_branch(
                                world,
                                x,
                                current_y,
                                z + this_width,
                                this_width,
                                0,
                                1,
                                ID,
                                leafID,
                                tree_type,
                                t_radius,
                                bad_critters,
                                chunk);
                            break;
                        }
                        case 3: {
                            this.make_branch(
                                world,
                                x,
                                current_y,
                                z - this_width,
                                this_width,
                                0,
                                -1,
                                ID,
                                leafID,
                                tree_type,
                                t_radius,
                                bad_critters,
                                chunk);
                            break;
                        }
                    }
                }
                ++current_y;
                if (do_floor == 0) {
                    ++spiral;
                }
                if (spiral > this_width) {
                    spiral = -this_width;
                }
            }
            --this_width;
            if (Math.abs(spiral) > this_width) {
                spiral = -this_width;
            }
            this_height += this.rand.nextInt(t_radius);
        }
        if (this.isBoringBaseBlock(world, x, current_y, z)) {
            this.FastSetBlock(world, x, current_y, z, Blocks.emerald_block, 0, 2, chunk);
            this.FastSetBlock(world, x, current_y + 1, z, Blocks.emerald_block, 0, 2, chunk);
            if (stepID == Blocks.diamond_block) {
                Entity var8 = null;
                var8 = EntityList.createEntityByName("The King", world);
                if (var8 != null) {
                    var8.setLocationAndAngles(x, (current_y + 4), z, world.rand.nextFloat() * 360.0f, 0.0f);
                    world.spawnEntityInWorld(var8);
                    ((EntityLiving) var8).playLivingSound();
                    ((TheKing) var8).setGuardMode(1);
                }
            }
            if (stepID == OreSpawnMain.MyBlockAmethystBlock) {
                Entity var8 = null;
                var8 = EntityList.createEntityByName("The Queen", world);
                if (var8 != null) {
                    var8.setLocationAndAngles(x, (current_y + 4), z, world.rand.nextFloat() * 360.0f, 0.0f);
                    world.spawnEntityInWorld(var8);
                    ((EntityLiving) var8).playLivingSound();
                    ((TheQueen) var8).setGuardMode(1);
                    ((TheQueen) var8).setBadMood(1);
                }
            }
        }
    }

    private void MakeCirclularBranch(final World world, final int iangle, final int branchlen, final int width,
        final int startx, final int starty, final int startz, final int twist, final Block ID, final Block leafID,
        final int tree_type, final Chunk chunk) {
        double curlen = 0.0;
        int curangle = iangle;
        double curx = startx;
        double curz = startz;
        for (curlen = 0.0; curlen < branchlen; curlen += 0.5) {
            curx += 0.5 * Math.sin(Math.toRadians(curangle));
            curz += 0.5 * Math.cos(Math.toRadians(curangle));
            for (double tw = width - width * curlen / branchlen, wd = 0.0; wd <= tw; wd += 0.5) {
                Block id = leafID;
                if (wd < tw / 2.0) {
                    id = ID;
                }
                if (tw < 0.9) {
                    id = leafID;
                }
                int ta = curangle + 90;
                if (ta > 360) {
                    ta -= 360;
                }
                double wx = curx + wd * Math.sin(Math.toRadians(ta));
                double wz = curz + wd * Math.cos(Math.toRadians(ta));
                if (this.isBoringBlock(world, (int) wx, starty, (int) wz)) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int) wx, starty, (int) wz, id, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int) wx, starty, (int) wz, id, 0, 2, chunk);
                    }
                }
                if (id == ID && this.isBoringBlock(world, (int) wx, starty + 1, (int) wz)) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int) wx, starty + 1, (int) wz, leafID, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int) wx, starty + 1, (int) wz, leafID, 0, 2, chunk);
                    }
                }
                ta = curangle - 90;
                if (ta < 0) {
                    ta += 360;
                }
                wx = curx + wd * Math.sin(Math.toRadians(ta));
                wz = curz + wd * Math.cos(Math.toRadians(ta));
                if (this.isBoringBlock(world, (int) wx, starty, (int) wz)) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int) wx, starty, (int) wz, id, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int) wx, starty, (int) wz, id, 0, 2, chunk);
                    }
                }
                if (id == ID && this.isBoringBlock(world, (int) wx, starty + 1, (int) wz)) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, (int) wx, starty + 1, (int) wz, leafID, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, (int) wx, starty + 1, (int) wz, leafID, 0, 2, chunk);
                    }
                }
            }
            curangle += twist;
            if (curangle < 0) {
                curangle += 360;
            }
            if (curangle >= 360) {
                curangle -= 360;
            }
        }
    }

    public void MakeBigCircularTree(final World world, final int x, final int y, final int z, final Block ID,
        final Block leafID, final Block stepID, final int tree_type, final int t_radius, final boolean bad_critters,
        final Chunk chunk) {
        double rad = t_radius;
        int curx = 0;
        int cury = 0;
        int curz = 0;
        int stepindex = this.rand.nextInt(360);
        int ibranch = 0;
        cury = y;
        for (int i = 0; i < 360; ++i) {
            double dt = rad * Math.sin(Math.toRadians(i)) + 0.5;
            curx = (int) dt;
            dt = rad * Math.cos(Math.toRadians(i)) + 0.5;
            curz = (int) dt;
            if (this.isBoringBaseBlock(world, x + curx, cury, z + curz)) {
                for (int j = 0; j < 20; ++j) {
                    if (cury - j > 0) {
                        if (!this.isBoringBaseBlock(world, x + curx, cury - j, z + curz)) {
                            break;
                        }
                        if (tree_type >= 0) {
                            this.FastSetBlock(world, x + curx, cury - j, z + curz, ID, tree_type, 2, chunk);
                        } else {
                            this.FastSetBlock(world, x + curx, cury - j, z + curz, ID, 0, 2, chunk);
                        }
                    }
                }
            }
        }
        cury = 1;
        while (rad > 0.0) {
            for (int i = 0; i < 360; ++i) {
                double dt = rad * Math.sin(Math.toRadians(i)) + 0.5;
                curx = (int) dt;
                dt = rad * Math.cos(Math.toRadians(i)) + 0.5;
                curz = (int) dt;
                if (this.isBoringBaseBlock(world, x + curx, y + cury, z + curz)) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, tree_type, 2, chunk);
                    } else {
                        this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, 0, 2, chunk);
                    }
                }
                if (i >= stepindex - 1 && i <= stepindex + 1 && rad > 1.0) {
                    dt = (rad + 1.9) * Math.sin(Math.toRadians(i)) + 0.5;
                    curx = (int) dt;
                    dt = (rad + 1.9) * Math.cos(Math.toRadians(i)) + 0.5;
                    curz = (int) dt;
                    for (int m = -1; m <= 1; ++m) {
                        for (int n = -1; n <= 1; ++n) {
                            if (this.isBoringBaseBlock(world, x + curx + m, y + cury, z + curz + n)) {
                                this.FastSetBlock(world, x + curx + m, y + cury, z + curz + n, stepID, 0, 2, chunk);
                            }
                        }
                    }
                }
            }
            if (cury > (int) rad) {
                ibranch += 80 + this.rand.nextInt(80);
                if (ibranch > 360) {
                    ibranch -= 360;
                }
                final int ibranchlen = (int) (rad * 5.0) + this.rand.nextInt((int) rad + 2);
                double dt = rad * Math.sin(Math.toRadians(ibranch)) + 0.5;
                curx = (int) dt;
                dt = rad * Math.cos(Math.toRadians(ibranch)) + 0.5;
                curz = (int) dt;
                this.MakeCirclularBranch(
                    world,
                    ibranch,
                    ibranchlen,
                    (int) rad + 1,
                    x + curx,
                    y + cury,
                    z + curz,
                    this.rand.nextInt(2) * ((this.rand.nextInt(2) == 0) ? -1 : 1),
                    ID,
                    leafID,
                    tree_type,
                    chunk);
            }
            if (cury % 6 == 0 && rad > 3.0) {
                for (double dr = rad - 0.25; dr > 0.0; dr -= 0.25) {
                    for (int i = 0; i < 360; ++i) {
                        double dt = dr * Math.sin(Math.toRadians(i)) + 0.5;
                        curx = (int) dt;
                        dt = dr * Math.cos(Math.toRadians(i)) + 0.5;
                        curz = (int) dt;
                        if (this.isBoringBaseBlock(world, x + curx, y + cury, z + curz)) {
                            if (tree_type >= 0) {
                                this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, tree_type, 2, chunk);
                            } else {
                                this.FastSetBlock(world, x + curx, y + cury, z + curz, ID, 0, 2, chunk);
                            }
                        }
                    }
                }
                if (this.rand.nextInt(2) == 0 && !bad_critters && world.isAirBlock(x, y + cury + 1, z)) {
                    this.FastSetBlock(world, x, y + cury + 1, z, (Block) Blocks.chest, 0, 2, chunk);
                    final TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y + cury + 1, z);
                    if (chest != null) {
                        WeightedRandomChestContent.generateChestContents(
                            this.rand,
                            this.chestContentsList,
                            (IInventory) chest,
                            t_radius - (int) rad + this.rand.nextInt(10));
                    }
                }
            }
            stepindex += 15 + (int) ((t_radius - rad) * 3.0);
            if (stepindex > 360) {
                stepindex -= 360;
            }
            ++cury;
            rad -= 0.01 * this.rand.nextInt(15);
            if (rad <= 0.0 && this.isBoringBaseBlock(world, x, y + cury, z)) {
                this.FastSetBlock(world, x, y + cury, z, Blocks.diamond_block, 0, 2, chunk);
            }
        }
    }

    public void MakeBigRoundTree(final World world, final int inx, final int y, final int inz, final Block ID,
        final Block leafID, final Block stepID, final int tree_type, final int t_radius, final Chunk chunk) {
        double rad = t_radius;
        int cury = 0;
        int ibranch = 0;
        float fx = (float) inx;
        fx += 0.5f;
        float fz = (float) inz;
        fz += 0.5f;
        cury = y;
        for (int i = 0; i < 360; ++i) {
            double dt = rad * Math.sin(Math.toRadians(i));
            final float fcurx = (float) dt;
            dt = rad * Math.cos(Math.toRadians(i));
            final float fcurz = (float) dt;
            if (this.isBoringBaseBlock(world, (int) (fx + fcurx), cury, (int) (fz + fcurz))) {
                for (int j = 0; j < 20; ++j) {
                    if (cury - j > 0) {
                        if (!this.isBoringBaseBlock(world, (int) (fx + fcurx), cury - j, (int) (fz + fcurz))) {
                            break;
                        }
                        if (tree_type >= 0) {
                            this.FastSetBlock(
                                world,
                                (int) (fx + fcurx),
                                cury - j,
                                (int) (fz + fcurz),
                                ID,
                                tree_type,
                                2,
                                chunk);
                        } else {
                            this.FastSetBlock(world, (int) (fx + fcurx), cury - j, (int) (fz + fcurz), ID, 0, 2, chunk);
                        }
                    }
                }
            }
        }
        cury = 1;
        while (rad > 0.0) {
            for (int i = 0; i < 360; ++i) {
                double dt = rad * Math.sin(Math.toRadians(i));
                final float fcurx = (float) dt;
                dt = rad * Math.cos(Math.toRadians(i));
                final float fcurz = (float) dt;
                if (this.isBoringBaseBlock(world, (int) (fx + fcurx), y + cury, (int) (fz + fcurz))) {
                    if (tree_type >= 0) {
                        this.FastSetBlock(
                            world,
                            (int) (fx + fcurx),
                            y + cury,
                            (int) (fz + fcurz),
                            ID,
                            tree_type,
                            2,
                            chunk);
                    } else {
                        this.FastSetBlock(world, (int) (fx + fcurx), y + cury, (int) (fz + fcurz), ID, 0, 2, chunk);
                    }
                }
            }
            if (cury > (int) rad) {
                ibranch += 80 + world.rand.nextInt(80);
                if (ibranch > 360) {
                    ibranch -= 360;
                }
                final int ibranchlen = (int) (rad * 5.0) + world.rand.nextInt((int) rad + 2);
                double dt = rad * Math.sin(Math.toRadians(ibranch));
                final float fcurx = (float) dt;
                dt = rad * Math.cos(Math.toRadians(ibranch));
                final float fcurz = (float) dt;
                this.MakeRoundBranch(
                    world,
                    ibranch,
                    ibranchlen,
                    (int) rad + 1,
                    fx + fcurx,
                    y + cury,
                    fz + fcurz,
                    ID,
                    leafID,
                    tree_type,
                    chunk);
            }
            if (cury % 6 == 0 && rad > 3.0) {
                for (double dr = rad - 0.25; dr > 0.0; dr -= 0.25) {
                    for (int i = 0; i < 360; ++i) {
                        double dt = dr * Math.sin(Math.toRadians(i));
                        final float fcurx = (float) dt;
                        dt = dr * Math.cos(Math.toRadians(i));
                        final float fcurz = (float) dt;
                        if (this.isBoringBaseBlock(world, (int) (fx + fcurx), y + cury, (int) (fz + fcurz))) {
                            if (tree_type >= 0) {
                                this.FastSetBlock(
                                    world,
                                    (int) (fx + fcurx),
                                    y + cury,
                                    (int) (fz + fcurz),
                                    ID,
                                    tree_type,
                                    2,
                                    chunk);
                            } else {
                                this.FastSetBlock(
                                    world,
                                    (int) (fx + fcurx),
                                    y + cury,
                                    (int) (fz + fcurz),
                                    ID,
                                    0,
                                    2,
                                    chunk);
                            }
                        }
                    }
                }
            }
            ++cury;
            rad -= 0.01 * world.rand.nextInt(15);
            if (rad <= 0.0 && this.isBoringBaseBlock(world, (int) fx, y + cury, (int) fz)) {
                this.FastSetBlock(world, (int) fx, y + cury, (int) fz, Blocks.diamond_block, 0, 2, chunk);
            }
        }
    }

    private void MakeRoundBranch(final World world, final int iangle, final int branchlen, final int width,
        final float startx, final int starty, final float startz, final Block ID, final Block leafID,
        final int tree_type, final Chunk chunk) {
        final double deltadir = 0.06283185200000001;
        final double deltamag = 0.3499999940395355;
        int ixlast = 0;
        int izlast = 0;
        final int xoff = 0;
        final int zoff = 0;
        final int radius = branchlen / 2;
        final float centerx = (float) (startx + radius * Math.sin(Math.toRadians(iangle)));
        final float centerz = (float) (startz + radius * Math.cos(Math.toRadians(iangle)));
        izlast = (ixlast = 0);
        for (double curdir = -3.1415926; curdir < 3.1415926; curdir += deltadir) {
            for (double h = 0.75; h < radius; h += deltamag) {
                final int ix = (int) (centerx + Math.cos(curdir) * h);
                final int iz = (int) (centerz + Math.sin(curdir) * h);
                if (ix != ixlast || iz != izlast) {
                    ixlast = ix;
                    izlast = iz;
                    Block id = ID;
                    if (radius - h < 2.0) {
                        id = leafID;
                    }
                    if (this.isBoringBlock(world, ix, starty, iz)) {
                        this.FastSetBlock(world, ix, starty, iz, id, tree_type, 2, chunk);
                    }
                }
            }
        }
    }

    public void FastSetBlock(final World world, final int ix, final int iy, final int iz, final Block id, final int im,
        final int iflg, final Chunk chunk) {
        OreSpawnMain.setBlockSuperFast(world, ix, iy, iz, id, im, 2, chunk);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world,
        final int clickedX, final int clickedY, final int clickedZ, final int par7, final float par8, final float par9,
        final float par10) {
        final Block var1 = world.getBlock(clickedX, clickedY, clickedZ);
        if (var1 != Blocks.grass && var1 != Blocks.farmland && var1 != Blocks.dirt) {
            return false;
        }
        final int tree_type = this.rand.nextInt(4);
        Block leaf_type = (Block) Blocks.leaves;
        this.no_critters = true;
        if (this.rand.nextInt(2) == 1) {
            this.no_critters = false;
        }
        if (!world.isRemote) {
            world.setBlock(clickedX, clickedY, clickedZ, Blocks.gold_block, 0, 2);
        }
        for (int var2 = 0; var2 < 6; ++var2) {
            par2EntityPlayer.worldObj.spawnParticle(
                "largesmoke",
                (clickedX + 0.5f),
                (clickedY + 1 + 0.25f),
                (clickedZ + 0.5f),
                0.0,
                0.0,
                0.0);
            par2EntityPlayer.worldObj.spawnParticle(
                "largeexplode",
                (clickedX + 0.5f),
                (clickedY + 1 + 0.25f),
                (clickedZ + 0.5f),
                0.0,
                0.0,
                0.0);
            par2EntityPlayer.worldObj
                .spawnParticle("reddust", (clickedX + 0.5f), (clickedY + 1 + 0.25f), (clickedZ + 0.5f), 0.0, 0.0, 0.0);
        }
        par2EntityPlayer.worldObj.playSoundAtEntity(par2EntityPlayer, "random.explode", 2.8f, 1.5f);
        if (!world.isRemote) {
            final int rand_treetype = this.rand.nextInt(100);
            if (rand_treetype >= 20) {
                if (rand_treetype >= 40) {
                    if (tree_type != 3 && this.rand.nextInt(10) == 1) {
                        leaf_type = OreSpawnMain.MyAppleLeaves;
                    }
                    this.MakeBigSquareTree(
                        world,
                        clickedX,
                        clickedY,
                        clickedZ,
                        Blocks.log,
                        leaf_type,
                        Blocks.mossy_cobblestone,
                        tree_type,
                        this.tree_radius,
                        this.no_critters,
                        null);
                } else {
                    this.MakeBigRoundTree(
                        world,
                        clickedX,
                        clickedY,
                        clickedZ,
                        Blocks.log,
                        leaf_type,
                        Blocks.mossy_cobblestone,
                        tree_type,
                        this.tree_radius,
                        null);
                }
            } else if (rand_treetype == 1) {
                if (OreSpawnMain.GinormousEmeraldTreeEnable != 0) {
                    if (this.rand.nextInt(2) == 0) {
                        this.MakeBigSquareTree(
                            world,
                            clickedX,
                            clickedY,
                            clickedZ,
                            Blocks.gold_block,
                            Blocks.emerald_block,
                            Blocks.diamond_block,
                            -1,
                            this.tree_radius,
                            true,
                            null);
                    } else {
                        this.MakeBigSquareTree(
                            world,
                            clickedX,
                            clickedY,
                            clickedZ,
                            Blocks.obsidian,
                            OreSpawnMain.MyBlockRubyBlock,
                            OreSpawnMain.MyBlockAmethystBlock,
                            -1,
                            this.tree_radius,
                            true,
                            null);
                    }
                } else {
                    this.MakeBigSquareTree(
                        world,
                        clickedX,
                        clickedY,
                        clickedZ,
                        Blocks.log,
                        leaf_type,
                        Blocks.iron_ore,
                        tree_type,
                        this.tree_radius,
                        this.no_critters,
                        null);
                }
            } else {
                this.MakeBigCircularTree(
                    world,
                    clickedX,
                    clickedY,
                    clickedZ,
                    Blocks.log,
                    leaf_type,
                    Blocks.mossy_cobblestone,
                    tree_type,
                    this.tree_radius,
                    this.no_critters,
                    null);
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
