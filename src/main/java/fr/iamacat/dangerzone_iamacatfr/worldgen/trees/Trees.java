
package fr.iamacat.dangerzone_iamacatfr.worldgen.trees;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

public class Trees {

    public static final WeightedRandomChestContent[] CrystalChestContentsList;

    private void WindTreeBranch(final World world, final int x, final int y, final int z, final int length,
        final int dirx, final int dirz) {
        for (int i = 1; i <= length; ++i) {
            DangerZone.setBlockFast(world, x + i * dirx, y, z + i * dirz, Blocks.log, 0, 2);
            if (Blocks.air == world.getBlock(x + i * dirx, y + 1, z + i * dirz)) {
                DangerZone.setBlockFast(world, x + i * dirx, y + 1, z + i * dirz, Blocks.leaves, 0, 2);
            }
            if (i < length / 3 && Blocks.air == world.getBlock(x + i * dirx, y + 2, z + i * dirz)) {
                DangerZone.setBlockFast(world, x + i * dirx, y + 2, z + i * dirz, Blocks.leaves, 0, 2);
            }
            if (i > length / 3) {
                if (Blocks.air == world.getBlock(x + i * dirx + dirz, y, z + i * dirz + dirx)) {
                    DangerZone.setBlockFast(world, x + i * dirx + dirz, y, z + i * dirz + dirx, Blocks.leaves, 0, 2);
                }
                if (Blocks.air == world.getBlock(x + i * dirx - dirz, y, z + i * dirz - dirx)) {
                    DangerZone.setBlockFast(world, x + i * dirx - dirz, y, z + i * dirz - dirx, Blocks.leaves, 0, 2);
                }
            }
        }
        if (Blocks.air == world.getBlock(x + (length + 1) * dirx, y, z + (length + 1) * dirz)) {
            DangerZone.setBlockFast(world, x + (length + 1) * dirx, y, z + (length + 1) * dirz, Blocks.leaves, 0, 2);
        }
        if (Blocks.air == world.getBlock(x + (length + 2) * dirx, y, z + (length + 2) * dirz)) {
            DangerZone.setBlockFast(world, x + (length + 2) * dirx, y, z + (length + 2) * dirz, Blocks.leaves, 0, 2);
        }
    }

    public void WindTree(final World world, final int x, final int y, final int z, final int dir) {
        if (dir < 0 || dir > 3) {
            return;
        }
        int dirx = 1;
        int dirz = 0;
        if (dir == 1) {
            dirx = -1;
            dirz = 0;
        }
        if (dir == 2) {
            dirx = 0;
            dirz = 1;
        }
        if (dir == 3) {
            dirx = 0;
            dirz = -1;
        }
        final Block bid = world.getBlock(x, y, z);
        if (bid != Blocks.grass && bid != Blocks.dirt) {
            return;
        }
        final int height = world.rand.nextInt(8) + 40;
        final int width = world.rand.nextInt(4) + 8;
        for (int j = 0; j < height; ++j) {
            DangerZone.setBlockFast(world, x, j + y, z, Blocks.log, 0, 2);
            if (j > height / 5) {
                DangerZone.setBlockFast(world, x + dirx, j + y, z + dirz, Blocks.leaves, 0, 2);
                if (j > height / 4 && j % 4 == 0) {
                    this.WindTreeBranch(world, x, j + y, z, height - j, dirx, dirz);
                }
            }
        }
        DangerZone.setBlockFast(world, x, y + height, z, Blocks.leaves, 0, 2);
    }

    private void SkyTreeBranch(final World world, final int x, final int y, final int z, final int length,
        final int dirx, final int dirz) {
        for (int i = 1; i < length; ++i) {
            DangerZone.setBlockFast(world, x + i * dirx, y, z + i * dirz, BlockInitDangerZone.BlockSkyTreeLog, 0, 2);
            if (Blocks.air == world.getBlock(x + i * dirx, y + 1, z + i * dirz)) {
                DangerZone.setBlockFast(world, x + i * dirx, y + 1, z + i * dirz, (Block) Blocks.leaves, 0, 2);
            }
            if (Blocks.air == world.getBlock(x + i * dirx + dirz, y, z + i * dirz + dirx)) {
                DangerZone
                    .setBlockFast(world, x + i * dirx + dirz, y, z + i * dirz + dirx, (Block) Blocks.leaves, 0, 2);
            }
            if (Blocks.air == world.getBlock(x + i * dirx - dirz, y, z + i * dirz - dirx)) {
                DangerZone
                    .setBlockFast(world, x + i * dirx - dirz, y, z + i * dirz - dirx, (Block) Blocks.leaves, 0, 2);
            }
        }
        if (Blocks.air == world.getBlock(x + length * dirx, y, z + length * dirz)) {
            DangerZone.setBlockFast(world, x + length * dirx, y, z + length * dirz, (Block) Blocks.leaves, 0, 2);
        }
    }

    public void SkyTree(final World world, final int x, final int y, final int z) {
        final Block bid = world.getBlock(x, y, z);
        if (bid != Blocks.grass && bid != Blocks.dirt) {
            return;
        }
        int height = world.rand.nextInt(15) + 190;
        if (height - y < 20) {
            return;
        }
        int width = world.rand.nextInt(10) + 25;
        for (int j = y; j <= height; ++j) {
            DangerZone.setBlockFast(world, x, j, z, BlockInitDangerZone.BlockSkyTreeLog, 0, 2);
        }
        DangerZone.setBlockFast(world, x, height + 1, z, Blocks.leaves, 0, 2);
        this.SkyTreeBranch(world, x, height, z, width, 1, 0);
        this.SkyTreeBranch(world, x, height, z, width, -1, 0);
        this.SkyTreeBranch(world, x, height, z, width, 0, 1);
        this.SkyTreeBranch(world, x, height, z, width, 0, -1);
        height -= 5;
        height -= world.rand.nextInt(4);
        width /= 3;
        this.SkyTreeBranch(world, x, height, z, width, 1, 0);
        this.SkyTreeBranch(world, x, height, z, width, -1, 0);
        this.SkyTreeBranch(world, x, height, z, width, 0, 1);
        this.SkyTreeBranch(world, x, height, z, width, 0, -1);
    }

    public void DuplicatorTree(final World world, final int x, final int y, final int z) {
        int realy = y;
        Block bid = world.getBlock(x, y - 1, z);
        if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
            bid = world.getBlock(x, y - 2, z);
            if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
                bid = world.getBlock(x, y - 3, z);
                if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
                    return;
                }
                realy = y - 3;
            } else {
                realy = y - 2;
            }
            return;
        }
        realy = y - 1;
        bid = world.getBlock(x, realy + 1, z);
        if (bid != BlockInitDangerZone.BlockDuplicatorLog) {
            DangerZone.setBlockFast(world, x, realy + 1, z, BlockInitDangerZone.BlockDuplicatorLog, 0, 2);
            return;
        }
        bid = world.getBlock(x, realy + 2, z);
        if (bid != BlockInitDangerZone.BlockDuplicatorLog) {
            DangerZone.setBlockFast(world, x, realy + 2, z, BlockInitDangerZone.BlockDuplicatorLog, 0, 2);
            return;
        }
        bid = world.getBlock(x, realy + 3, z);
        if (bid != BlockInitDangerZone.BlockDuplicatorLog) {
            DangerZone.setBlockFast(world, x, realy + 3, z, BlockInitDangerZone.BlockDuplicatorLog, 0, 2);
            return;
        }
        bid = world.getBlock(x, realy + 4, z);
        if (bid != BlockInitDangerZone.BlockAppleLeaves) {
            DangerZone.setBlockFast(world, x, realy + 4, z, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
            return;
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (j != 0 || i != 0) {
                    bid = world.getBlock(x + i, realy + 3, z + j);
                    if (bid != BlockInitDangerZone.BlockAppleLeaves) {
                        DangerZone
                            .setBlockFast(world, x + i, realy + 3, z + j, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
                        return;
                    }
                }
            }
        }
        Block bidm = Blocks.air;
        for (int tries = 0; tries < 20
            && (bidm == Blocks.air || bidm == BlockInitDangerZone.BlockDuplicatorLog); ++tries) {
            int i = world.rand.nextInt(5) - 2;
            int j = world.rand.nextInt(5) - 2;
            bidm = world.getBlock(x + i, realy + 1, z + j);
            final int meta = world.getBlockMetadata(x + i, realy + 1, z + j);
            if (bidm != Blocks.air && bidm != BlockInitDangerZone.BlockDuplicatorLog) {
                for (int k = 0; k < 20; ++k) {
                    i = world.rand.nextInt(5) - 2;
                    j = world.rand.nextInt(5) - 2;
                    bid = world.getBlock(x + i, realy + 1, z + j);
                    if (bid == Blocks.air) {
                        world.setBlock(x + i, realy + 1, z + j, bidm, meta, 2);
                        return;
                    }
                }
            }
        }
    }

    private void make_leaves(final World world, final int x, final int y, final int z) {
        for (int l1 = -3; l1 <= 3; ++l1) {
            for (int l2 = -3; l2 <= 3; ++l2) {
                for (int l3 = 0; l3 <= 2; ++l3) {
                    final Block bid = world.getBlock(x + l1, y + l3, z + l2);
                    if (bid == Blocks.air) {
                        DangerZone.setBlockFast(
                            world,
                            x + l1,
                            y + l3,
                            z + l2,
                            BlockInitDangerZone.BlockExperienceLeaves,
                            0,
                            2);
                    }
                }
            }
        }
    }

    private void grow_small_branch(final World world, final int x, final int y, final int z, final int xdir,
        final int zdir, final int xxdir, final int zzdir) {
        int i2 = 0;
        int k2 = 0;
        int j2 = 0;
        int l = x;
        int m = y;
        int k3 = z;
        for (int grow = 4 + world.rand.nextInt(2), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            ++m;
            l += xdir;
            k3 += zdir;
            i2 = l;
            k2 = k3;
        }
        for (int grow = 4 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
        }
        for (int grow = 4 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, i2, m, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, m, k2);
            i2 += xxdir;
            k2 += zzdir;
        }
        j2 = --m;
        for (int grow = 3 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
            --m;
        }
        for (int grow = 3 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, i2, j2, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, j2, k2);
            i2 += xxdir;
            k2 += zzdir;
            --j2;
        }
    }

    private void grow_branch(final World world, final int x, final int y, final int z, final int xdir, final int zdir,
        final int xxdir, final int zzdir) {
        int i2 = 0;
        int k2 = 0;
        int j2 = 0;
        int l = x;
        int m = y;
        int k3 = z;
        for (int grow = 5 + world.rand.nextInt(4), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            ++m;
            l += xdir;
            k3 += zdir;
            i2 = l;
            k2 = k3;
        }
        for (int grow = 6 + world.rand.nextInt(5), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
        }
        for (int grow = 6 + world.rand.nextInt(5), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, i2, m, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, m, k2);
            i2 += xxdir;
            k2 += zzdir;
        }
        j2 = --m;
        for (int grow = 4 + world.rand.nextInt(4), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
            --m;
        }
        for (int grow = 4 + world.rand.nextInt(4), n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, i2, j2, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, j2, k2);
            i2 += xxdir;
            k2 += zzdir;
            --j2;
        }
    }

    public void ExperienceTree(final World world, final int x, final int y, final int z) {
        final Block bid = world.getBlock(x, y, z);
        if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
            return;
        }
        for (int j = 1; j < 6; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 2; ++k) {
                    DangerZone.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
                }
            }
        }
        this.grow_branch(world, x, y + 6, z, 0, 1, 1, 1);
        this.grow_branch(world, x + 1, y + 6, z, 1, 0, 1, -1);
        this.grow_branch(world, x, y + 6, z + 1, -1, 0, -1, 1);
        this.grow_branch(world, x + 1, y + 6, z + 1, 0, -1, -1, -1);
        for (int j = 7; j < 19; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 2; ++k) {
                    DangerZone.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
                }
            }
        }
        this.grow_small_branch(world, x, y + 19, z, 0, 1, -1, 1);
        this.grow_small_branch(world, x + 1, y + 19, z, 1, 0, 1, 1);
        this.grow_small_branch(world, x, y + 19, z + 1, -1, 0, -1, -1);
        this.grow_small_branch(world, x + 1, y + 19, z + 1, 0, -1, 1, -1);
        for (int grow = 5 + world.rand.nextInt(6), j = 19; j < 19 + grow; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 2; ++k) {
                    DangerZone.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
                    this.make_leaves(world, x + i, y + j, z + k);
                }
            }
        }
    }

    public void SmallTree(final World world, final int x, final int y, final int z) {
        int realy = y;
        Block bid = world.getBlock(x, y - 1, z);
        if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
            bid = world.getBlock(x, y - 2, z);
            if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
                bid = world.getBlock(x, y - 3, z);
                if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
                    DangerZone.setBlockFast(world, x, y, z, Blocks.air, 0, 2);
                    return;
                }
                realy = y - 3;
            } else {
                realy = y - 2;
            }
            return;
        }
        realy = y - 1;
        bid = world.getBlock(x, realy + 1, z);
        if (bid == Blocks.air) {
            DangerZone.setBlockFast(world, x, realy + 1, z, BlockInitDangerZone.BlockSkyTreeLog, 0, 2);
        }
        if (world.rand.nextInt(2) == 1) {
            bid = world.getBlock(x, realy + 2, z);
            if (bid == Blocks.air) {
                DangerZone.setBlockFast(world, x, realy + 2, z, BlockInitDangerZone.BlockSkyTreeLog, 0, 2);
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, realy + 3, z);
                if (bid == Blocks.air) {
                    DangerZone.setBlockFast(world, x, realy + 3, z, BlockInitDangerZone.BlockSkyTreeLog, 0, 2);
                }
            } else {
                --realy;
            }
        } else {
            realy -= 2;
        }
        bid = world.getBlock(x, realy + 4, z);
        if (bid == Blocks.air) {
            DangerZone.setBlockFast(world, x, realy + 4, z, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                bid = world.getBlock(x + i, realy + 3, z + j);
                if (bid == Blocks.air) {
                    DangerZone.setBlockFast(world, x + i, realy + 3, z + j, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
                }
            }
        }
    }

    public void makeScragglyBranch(final World world, int x, int y, int z, final int len, final int biasx,
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
            if (bid != Blocks.air && bid != Blocks.log && bid != BlockInitDangerZone.BlockAppleLeaves) {
                return;
            }
            DangerZone.setBlockFast(world, x, y, z, Blocks.log, 0, 2);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = world.getBlock(x + m, y, z + n);
                        if (bid == Blocks.air) {
                            DangerZone.setBlockFast(world, x + m, y, z + n, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, y + 1, z);
                if (bid == Blocks.air) {
                    DangerZone.setBlockFast(world, x, y + 1, z, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
                }
            }
        }
    }

    public void ScragglyTreeWithBranches(final World world, int x, int y, int z) {
        final int i = 1 + world.rand.nextInt(3);
        final int j = i + world.rand.nextInt(12);
        for (int k = 0; k < i; ++k) {
            final Block bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air && bid != Blocks.log && bid != BlockInitDangerZone.BlockAppleLeaves) {
                return;
            }
            DangerZone.setBlockFast(world, x, y + k, z, Blocks.log, 0, 2);
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
            if (bid != Blocks.air && bid != Blocks.log && bid != BlockInitDangerZone.BlockAppleLeaves) {
                break;
            }
            DangerZone.setBlockFast(world, x, y, z, Blocks.log, 0, 2);
            if (world.rand.nextInt(4) == 1) {
                this.makeScragglyBranch(
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
                            DangerZone.setBlockFast(world, x + m, y, z + n, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, y + 1, z);
                if (bid == Blocks.air) {
                    DangerZone.setBlockFast(world, x, y + 1, z, BlockInitDangerZone.BlockAppleLeaves, 0, 2);
                }
            }
        }
    }

    public void FairyTree(final World world, final int x, final int y, final int z) {
        for (int j = 1; j < 6; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 2; ++k) {
                    DangerZone.setBlockFast(world, x + i, y + j, z + k, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
                }
            }
        }
        this.grow_crystal_branch(world, x, y + 5, z, 0, 1, 1, 1, -1);
        this.grow_crystal_branch(world, x + 1, y + 5, z, 1, 0, 1, -1, -1);
        this.grow_crystal_branch(world, x, y + 5, z + 1, -1, 0, -1, 1, -1);
        this.grow_crystal_branch(world, x + 1, y + 5, z + 1, 0, -1, -1, -1, -1);
        this.grow_crystal_branch(world, x, y + 6, z, 0, 1, -1, 1, -1);
        this.grow_crystal_branch(world, x + 1, y + 6, z, 1, 0, 1, 1, -1);
        this.grow_crystal_branch(world, x, y + 6, z + 1, -1, 0, -1, -1, -1);
        this.grow_crystal_branch(world, x + 1, y + 6, z + 1, 0, -1, 1, -1, -1);
        for (int grow = 5 + world.rand.nextInt(5), j = 6; j < 6 + grow; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 2; ++k) {
                    DangerZone.setBlockFast(world, x + i, y + j, z + k, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
                    this.make_crystal_leaves(world, x + i, y + j, z + k);
                }
            }
        }
        world.setBlock(x - 1, y + 1, z, Blocks.mob_spawner, 0, 2);
        final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world.getTileEntity(x - 1, y + 1, z);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Fairy");
        }
        world.setBlock(x + 2, y + 1, z, (Block) Blocks.chest, 0, 2);
        final TileEntityChest chest = (TileEntityChest) world.getTileEntity(x + 2, y + 1, z);
        if (chest != null) {
            WeightedRandomChestContent.generateChestContents(
                world.rand,
                Trees.CrystalChestContentsList,
                (IInventory) chest,
                1 + world.rand.nextInt(5));
        }
    }

    private void make_crystal_leaves(final World world, final int x, final int y, final int z) {
        for (int l1 = -2; l1 <= 2; ++l1) {
            for (int l2 = -2; l2 <= 2; ++l2) {
                for (int l3 = 0; l3 <= 1; ++l3) {
                    final Block bid = world.getBlock(x + l1, y + l3, z + l2);
                    if (bid == Blocks.air) {
                        DangerZone
                            .setBlockFast(world, x + l1, y + l3, z + l2, BlockInitDangerZone.BlockCrystalLeaves2, 0, 2);
                    }
                }
            }
        }
    }

    private void make_crystal_castle_leaves(final World world, final int x, final int y, final int z) {
        for (int l1 = -1; l1 <= 1; ++l1) {
            for (int l2 = -1; l2 <= 1; ++l2) {
                for (int l3 = 0; l3 <= 1; ++l3) {
                    final Block bid = world.getBlock(x + l1, y + l3, z + l2);
                    if (bid == Blocks.air) {
                        if (l3 != 0) {
                            DangerZone.setBlockFast(
                                world,
                                x + l1,
                                y + l3,
                                z + l2,
                                BlockInitDangerZone.BlockCrystalLeaves3,
                                0,
                                2);
                        } else {
                            DangerZone.setBlockFast(
                                world,
                                x + l1,
                                y + l3,
                                z + l2,
                                BlockInitDangerZone.BlockCrystalLeaves2,
                                0,
                                2);
                        }
                    }
                }
            }
        }
    }

    private void grow_crystal_branch(final World world, final int x, final int y, final int z, final int xdir,
        final int zdir, final int xxdir, final int zzdir, final int ydir) {
        int i2 = 0;
        int k2 = 0;
        int j2 = 0;
        int l = x;
        int m = y;
        int k3 = z;
        int grow = 4 + world.rand.nextInt(4);
        for (int n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, l, m, k3);
            ++m;
            l += xdir;
            k3 += zdir;
            i2 = l;
            k2 = k3;
        }
        grow = 5 + world.rand.nextInt(5);
        for (int n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
        }
        grow = 5 + world.rand.nextInt(5);
        for (int n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, i2, m, k2, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, i2, m, k2);
            i2 += xxdir;
            k2 += zzdir;
        }
        j2 = --m;
        grow = 4 + world.rand.nextInt(4);
        for (int n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, l, m, k3, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
            m += ydir;
        }
        grow = 4 + world.rand.nextInt(4);
        for (int n = 0; n < grow; ++n) {
            DangerZone.setBlockFast(world, i2, j2, k2, BlockInitDangerZone.BlockCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, i2, j2, k2);
            i2 += xxdir;
            k2 += zzdir;
            j2 += ydir;
        }
    }

    public void addSomething(final World world, final int x, final int y, final int z) {
        final int i = world.rand.nextInt(3);
        if (i == 1) {
            world.setBlock(x, y + 1, z, Blocks.mob_spawner, 0, 2);
            final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world.getTileEntity(x, y + 1, z);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Fairy");
            }
        }
        if (i == 2) {
            world.setBlock(x, y + 1, z, (Block) Blocks.chest, 0, 2);
            final TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y + 1, z);
            if (chest != null) {
                WeightedRandomChestContent.generateChestContents(
                    world.rand,
                    Trees.CrystalChestContentsList,
                    (IInventory) chest,
                    1 + world.rand.nextInt(5));
            }
        }
    }

    public void FairyCastleTree(final World world, final int x, final int y, final int z) {
        int nc = 6;
        int j = 3 + world.rand.nextInt(3);
        int spread = 0;
        for (int iter = 0; iter < nc; ++iter) {
            final int grow = 4 + world.rand.nextInt(3);
            int width = 1 + world.rand.nextInt(3);
            int randy = world.rand.nextInt(3) - 1;
            for (int i = -width; i <= width; ++i) {
                for (int k = -width; k <= width; ++k) {
                    DangerZone.setBlockFast(
                        world,
                        x + i + spread,
                        y + j + randy,
                        z + k,
                        BlockInitDangerZone.BlockCrystalTreeLog,
                        0,
                        2);
                    if (i == -width || i == width || k == -width || k == width) {
                        this.make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k);
                    }
                    if (iter != 0 && i == 0 && k == 0) {
                        this.addSomething(world, x + i + spread, y + j + randy, z + k);
                    }
                    if (i == -width && (k == -width || k == width)) {
                        DangerZone.setBlockFast(
                            world,
                            x + i + spread,
                            y + j + randy + 1,
                            z + k,
                            BlockInitDangerZone.CrystalTorch,
                            0,
                            2);
                    }
                    if (i == width && (k == -width || k == width)) {
                        DangerZone.setBlockFast(
                            world,
                            x + i + spread,
                            y + j + randy + 1,
                            z + k,
                            BlockInitDangerZone.CrystalTorch,
                            0,
                            2);
                    }
                }
            }
            if (iter != 0) {
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i - spread,
                            y + j + randy,
                            z + k,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i - spread, y + j + randy, z + k);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i - spread,
                                y + j + randy + 1,
                                z + k,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i - spread,
                                y + j + randy + 1,
                                z + k,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i,
                            y + j + randy,
                            z + k + spread,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i, y + j + randy, z + k + spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i, y + j + randy, z + k + spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i,
                                y + j + randy + 1,
                                z + k + spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i,
                                y + j + randy + 1,
                                z + k + spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i,
                            y + j + randy,
                            z + k - spread,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i, y + j + randy, z + k - spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i, y + j + randy, z + k - spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i,
                                y + j + randy + 1,
                                z + k - spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i,
                                y + j + randy + 1,
                                z + k - spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
            }
            if (iter >= 2) {
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i + spread,
                            y + j + randy,
                            z + k + spread,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k + spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i + spread, y + j + randy, z + k + spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i + spread,
                                y + j + randy + 1,
                                z + k + spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i + spread,
                                y + j + randy + 1,
                                z + k + spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i - spread,
                            y + j + randy,
                            z + k - spread,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k - spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i - spread, y + j + randy, z + k - spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i - spread,
                                y + j + randy + 1,
                                z + k - spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i - spread,
                                y + j + randy + 1,
                                z + k - spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i - spread,
                            y + j + randy,
                            z + k + spread,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k + spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i - spread, y + j + randy, z + k + spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i - spread,
                                y + j + randy + 1,
                                z + k + spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i - spread,
                                y + j + randy + 1,
                                z + k + spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        DangerZone.setBlockFast(
                            world,
                            x + i + spread,
                            y + j + randy,
                            z + k - spread,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0,
                            2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k - spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i + spread, y + j + randy, z + k - spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i + spread,
                                y + j + randy + 1,
                                z + k - spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            DangerZone.setBlockFast(
                                world,
                                x + i + spread,
                                y + j + randy + 1,
                                z + k - spread,
                                BlockInitDangerZone.CrystalTorch,
                                0,
                                2);
                        }
                    }
                }
            }
            j += grow;
            if (iter == 0) {
                spread = 3;
            }
            spread += grow;
        }
    }

    static {
        CrystalChestContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalTermiteBlock), 0, 1, 5, 10),
            new WeightedRandomChestContent(
                Item.getItemFromBlock(BlockInitDangerZone.CrystalFlowerRedBlock),
                0,
                1,
                10,
                10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.MyFlowerBlueBlock), 0, 1, 10, 10),
            new WeightedRandomChestContent(
                Item.getItemFromBlock(BlockInitDangerZone.CrystalFlowerGreenBlock),
                0,
                1,
                10,
                10),
            new WeightedRandomChestContent(
                Item.getItemFromBlock(BlockInitDangerZone.CrystalFlowerYellowBlock),
                0,
                1,
                10,
                10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalWood), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalWorkbench), 0, 1, 1, 10),
            new WeightedRandomChestContent(
                Item.getItemFromBlock(BlockInitDangerZone.ContainerCrystalFurnaceBlock),
                0,
                1,
                1,
                10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.TigersEyeBlock), 0, 1, 10, 5),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalStone), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalRat), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalFairy), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalCoal), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalGrass), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.OreCrystalCrystal), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.CrystalTorch), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.BlockCrystalLeaves), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.BlockCrystalLeaves2), 0, 1, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.BlockCrystalLeaves3), 0, 1, 10, 10),
            new WeightedRandomChestContent(
                Item.getItemFromBlock(BlockInitDangerZone.BlockCrystalTreeLog),
                0,
                1,
                10,
                10),
            new WeightedRandomChestContent(Item.getItemFromBlock(BlockInitDangerZone.OreCrystalCrystal), 0, 1, 10, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalSword, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalAxe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalShovel, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalPickaxe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalHoe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalSword, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalAxe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalShovel, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalHoe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalPickaxe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeSword, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeAxe, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeShovel, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyePickaxe, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeHoe, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalSword, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalAxe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalShovel, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalPickaxe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalHoe, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeIngot, 0, 1, 5, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.UraniumIngot, 0, 1, 5, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CrystalAppleItem, 0, 1, 5, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PeacockFeather, 0, 1, 5, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.CookedPeacock, 0, 1, 10, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.RawPeacock, 0, 1, 10, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.Rice, 0, 1, 10, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.Quinoa, 0, 1, 10, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.PinkTourmalineHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PinkTourmalineChestplate, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PinkTourmalineLeggings, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PinkTourmalineBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeHelmet, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeChestplate, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeLeggings, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.TigersEyeBoots, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.PeacockHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PeacockChestplate, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PeacockLeggings, 0, 1, 1, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.PeacockBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(Constants.RotatorSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.VortexSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.PeacockSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.DungeonBeastSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.FairySpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.RatSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.FlounderSPawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.WhaleSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.IrukandjiSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.SkateSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.crystalUrchinSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.GhostSpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(Constants.GhostPunpkinSkellySpawnEgg, 0, 1, 5, 10),
            new WeightedRandomChestContent(ItemInitDangerZone.SkateBow, 0, 1, 1, 2),
            new WeightedRandomChestContent(ItemInitDangerZone.ItemIrukandjiArrow, 0, 5, 10, 2),
            new WeightedRandomChestContent(ItemInitDangerZone.ItemIrukandji, 0, 2, 8, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateBow, 0, 1, 1, 2),
            new WeightedRandomChestContent(ItemInitDangerZone.MyUltimateSword, 0, 1, 1, 2),
            new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 1, 4, 10),
            new WeightedRandomChestContent(Items.golden_apple, 0, 1, 5, 2) };
    }
}
