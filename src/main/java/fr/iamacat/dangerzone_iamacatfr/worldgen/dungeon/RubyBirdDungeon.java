
package fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;

public class RubyBirdDungeon {

    private final WeightedRandomChestContent[] chestContentsList;

    public RubyBirdDungeon() {
        this.chestContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubySword, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 5) };
    }

    private void setThisBlock(final World world, final int cposx, final int cposy, final int cposz) {
        if (world.rand.nextInt(20) == 1) {
            this.FastSetBlock(world, cposx, cposy, cposz, OreSpawnMain.MyOreRubyBlock);
        } else if (world.rand.nextInt(2) == 1) {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.mossy_cobblestone);
        } else {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.cobblestone);
        }
    }

    public void makeDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 10;
        final int height = 5;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.mossy_cobblestone);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height - 1;
            for (int k = 0; k < width; ++k) {
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int k = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                k = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 0; j < height; ++j) {
                int i = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                i = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world
            .getTileEntity(cposx + width / 2, cposy + 1, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ruby Bird");
        }
        TileEntityChest chest = null;
        world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block) Blocks.chest, 0, 2);
        chest = (TileEntityChest) world.getTileEntity(cposx + width / 2, cposy + 1, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent.generateChestContents(
                world.rand,
                this.chestContentsList,
                (IInventory) chest,
                4 + world.rand.nextInt(7));
        }
    }

    public void FastSetBlock(final World world, final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(world, ix, iy, iz, id, 0, 2);
    }
}
