
package fr.iamacat.dangerzone_iamacatfr.worldgen.dungeons;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class RubyBirdDungeon {

    private final WeightedRandomChestContent[] chestContentsList;

    public RubyBirdDungeon() {
        this.chestContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(DangerZone.CageEmpty, 0, 3, 10, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyIngot, 0, 2, 8, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.CookedBacon, 0, 6, 12, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.ButterCandy, 0, 6, 12, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubySword, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyChestplate, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyLeggings, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.ThunderStaff, 0, 1, 1, 5) };
    }

    private void setThisBlock(final World world, final int cposx, final int cposy, final int cposz) {
        if (world.rand.nextInt(20) == 1) {
            this.FastSetBlock(world, cposx, cposy, cposz, BlockInitDangerZone.RubyBlockOre);
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
        DangerZone.setBlockFast(world, ix, iy, iz, id, 0, 2);
    }
}
