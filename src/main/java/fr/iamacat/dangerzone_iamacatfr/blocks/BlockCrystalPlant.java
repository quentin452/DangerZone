
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockCrystalPlant extends BlockReed {

    public BlockCrystalPlant(final int par1) {
        final float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        final Block bid = par1World.getBlock(par2, par3 - 1, par4);
        return bid != Blocks.air && (bid == Blocks.grass || bid == Blocks.dirt
            || bid == Blocks.farmland
            || bid == OreSpawnMain.CrystalGrass);
    }

    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.rand.nextInt(30) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 10; ++j1) {
            par1World.spawnParticle(
                "happyVillager",
                (par2 + par1World.rand.nextFloat()),
                par3 + par1World.rand.nextFloat(),
                (par4 + par1World.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
        }
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.isRemote) {
            return;
        }
        if (par1World.rand.nextInt(5) != 1) {
            return;
        }
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        if (this == OreSpawnMain.MyCrystalPlant) {
            this.TallCrystalTree(par1World, par2, par3, par4);
        }
        if (this == OreSpawnMain.MyCrystalPlant2) {
            this.ScragglyCrystalTreeWithBranches(par1World, par2, par3, par4);
        }
        if (this == OreSpawnMain.MyCrystalPlant3) {
            this.TallCrystalTreeBlue(par1World, par2, par3, par4);
        }
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        if (this == OreSpawnMain.MyCrystalPlant) {
            return Item.getItemFromBlock(OreSpawnMain.MyCrystalPlant);
        }
        if (this == OreSpawnMain.MyCrystalPlant2) {
            Item.getItemFromBlock(OreSpawnMain.MyCrystalPlant2);
        }
        return Item.getItemFromBlock(OreSpawnMain.MyCrystalPlant3);
    }

    public int quantityDropped(final Random par1Random) {
        return 1;
    }

    public int idPicked(final World par1World, final int par2, final int par3, final int par4) {
        return 0;
    }

    protected int getSeedItem() {
        return 0;
    }

    protected int getCropItem() {
        return 0;
    }

    public void TallCrystalTree(final World world, final int x, int y, final int z) {
        final int i = 10 + world.rand.nextInt(12);
        final int j = i + world.rand.nextInt(18);
        for (int k = 0; k < i; ++k) {
            final Block bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air
                && bid != OreSpawnMain.MyCrystalTreeLog
                && bid != OreSpawnMain.MyCrystalLeaves) {
                return;
            }
            OreSpawnMain.setBlockFast(world, x, y + k, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            ++y;
            Block bid = world.getBlock(x, y, z);
            if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves) {
                break;
            }
            OreSpawnMain.setBlockFast(world, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            if (k % 4 == 0) {
                for (int m = -1; m < 2; ++m) {
                    for (int n = -1; n < 2; ++n) {
                        if (world.rand.nextInt(2) == 1) {
                            bid = world.getBlock(x + m, y, z + n);
                            if (bid == Blocks.air) {
                                OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves, 0, 2);
                            }
                        }
                    }
                }
            }
        }
        ++y;
        for (int m = -1; m < 2; ++m) {
            for (int n = -1; n < 2; ++n) {
                if (world.rand.nextInt(2) == 1) {
                    final Block bid = world.getBlock(x + m, y, z + n);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                    }
                }
            }
        }
        for (int m = -3; m < 4; ++m) {
            for (int n = -3; n < 4; ++n) {
                final Block bid = world.getBlock(x + m, y, z + n);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves, 0, 2);
                }
            }
        }
        ++y;
        for (int m = -1; m < 2; ++m) {
            for (int n = -1; n < 2; ++n) {
                final Block bid = world.getBlock(x + m, y, z + n);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves, 0, 2);
                }
            }
        }
    }

    public void makeScragglyCrystalBranch(final World world, int x, int y, int z, final int len, final int biasx,
        final int biasz) {
        for (int k = 0; k < len; ++k) {
            int ix = world.rand.nextInt(2) - world.rand.nextInt(2) + biasx;
            int iz = world.rand.nextInt(2) - world.rand.nextInt(2) + biasz;
            if (ix > 1) {
                ix = 1;
            }
            if (ix < -1) {
                ix = -1;
            }
            if (iz > 1) {
                iz = 1;
            }
            if (iz < -1) {
                iz = -1;
            }
            final int iy = (world.rand.nextInt(3) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = world.getBlock(x, y, z);
            if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
                return;
            }
            OreSpawnMain.setBlockFast(world, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = world.getBlock(x + m, y, z + n);
                        if (bid == Blocks.air) {
                            OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves2, 0, 2);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, y + 1, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x, y + 1, z, OreSpawnMain.MyCrystalLeaves2, 0, 2);
                }
            }
        }
    }

    public void ScragglyCrystalTreeWithBranches(final World world, int x, int y, int z) {
        final int i = 1 + world.rand.nextInt(2);
        final int j = i + world.rand.nextInt(8);
        for (int k = 0; k < i; ++k) {
            final Block bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air
                && bid != OreSpawnMain.MyCrystalTreeLog
                && bid != OreSpawnMain.MyCrystalLeaves2) {
                return;
            }
            OreSpawnMain.setBlockFast(world, x, y + k, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            final int ix = world.rand.nextInt(2) - world.rand.nextInt(2);
            final int iz = world.rand.nextInt(2) - world.rand.nextInt(2);
            final int iy = (world.rand.nextInt(4) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = world.getBlock(x, y, z);
            if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves2) {
                break;
            }
            OreSpawnMain.setBlockFast(world, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            if (world.rand.nextInt(4) == 1) {
                this.makeScragglyCrystalBranch(
                    world,
                    x,
                    y,
                    z,
                    world.rand.nextInt(1 + j - k),
                    world.rand.nextInt(2) - world.rand.nextInt(2),
                    world.rand.nextInt(2) - world.rand.nextInt(2));
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = world.getBlock(x + m, y, z + n);
                        if (bid == Blocks.air) {
                            OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves2, 0, 2);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, y + 1, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x, y + 1, z, OreSpawnMain.MyCrystalLeaves2, 0, 2);
                }
            }
        }
    }

    public void TallCrystalTreeBlue(final World world, final int x, int y, final int z) {
        final int i = 5 + world.rand.nextInt(6);
        final int j = 2 + i + world.rand.nextInt(12);
        for (int k = 0; k < i; ++k) {
            final Block bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air
                && bid != OreSpawnMain.MyCrystalTreeLog
                && bid != OreSpawnMain.MyCrystalLeaves3) {
                return;
            }
            OreSpawnMain.setBlockFast(world, x, y + k, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            ++y;
            Block bid = world.getBlock(x, y, z);
            if (bid != Blocks.air && bid != OreSpawnMain.MyCrystalTreeLog && bid != OreSpawnMain.MyCrystalLeaves3) {
                break;
            }
            OreSpawnMain.setBlockFast(world, x, y, z, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            if (k % 3 == 0) {
                for (int m = -1; m < 2; ++m) {
                    for (int n = -1; n < 2; ++n) {
                        if (world.rand.nextInt(2) == 1) {
                            bid = world.getBlock(x + m, y, z + n);
                            if (bid == Blocks.air) {
                                OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves3, 0, 2);
                            }
                        }
                    }
                }
            }
        }
        ++y;
        for (int m = -1; m < 2; ++m) {
            for (int n = -1; n < 2; ++n) {
                if (world.rand.nextInt(2) == 1) {
                    final Block bid = world.getBlock(x + m, y, z + n);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                    }
                }
            }
        }
        for (int m = -3; m < 4; ++m) {
            for (int n = -3; n < 4; ++n) {
                final Block bid = world.getBlock(x + m, y, z + n);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves3, 0, 2);
                }
            }
        }
        ++y;
        for (int m = -1; m < 2; ++m) {
            for (int n = -1; n < 2; ++n) {
                final Block bid = world.getBlock(x + m, y, z + n);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyCrystalLeaves3, 0, 2);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"+ this.getUnlocalizedName()
                .substring(5));
    }
}
