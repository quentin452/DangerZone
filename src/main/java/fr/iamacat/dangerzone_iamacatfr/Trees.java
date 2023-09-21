//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\iamacat\Downloads\Minecraft-Deobfuscator3000-1.2.3\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package fr.iamacat.dangerzone_iamacatfr;

import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.block.*;
import net.minecraft.tileentity.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.init.*;

public class Trees
{
    public static final WeightedRandomChestContent[] CrystalChestContentsList;

    private void WindTreeBranch(final World world, final int x, final int y, final int z, final int length, final int dirx, final int dirz) {
        for (int i = 1; i <= length; ++i) {
            OreSpawnMain.setBlockFast(world, x + i * dirx, y, z + i * dirz, Blocks.log, 0, 2);
            if (Blocks.air == world.getBlock(x + i * dirx, y + 1, z + i * dirz)) {
                OreSpawnMain.setBlockFast(world, x + i * dirx, y + 1, z + i * dirz, (Block)Blocks.leaves, 0, 2);
            }
            if (i < length / 3 && Blocks.air == world.getBlock(x + i * dirx, y + 2, z + i * dirz)) {
                OreSpawnMain.setBlockFast(world, x + i * dirx, y + 2, z + i * dirz, (Block)Blocks.leaves, 0, 2);
            }
            if (i > length / 3) {
                if (Blocks.air == world.getBlock(x + i * dirx + dirz, y, z + i * dirz + dirx)) {
                    OreSpawnMain.setBlockFast(world, x + i * dirx + dirz, y, z + i * dirz + dirx, (Block)Blocks.leaves, 0, 2);
                }
                if (Blocks.air == world.getBlock(x + i * dirx - dirz, y, z + i * dirz - dirx)) {
                    OreSpawnMain.setBlockFast(world, x + i * dirx - dirz, y, z + i * dirz - dirx, (Block)Blocks.leaves, 0, 2);
                }
            }
        }
        if (Blocks.air == world.getBlock(x + (length + 1) * dirx, y, z + (length + 1) * dirz)) {
            OreSpawnMain.setBlockFast(world, x + (length + 1) * dirx, y, z + (length + 1) * dirz, (Block)Blocks.leaves, 0, 2);
        }
        if (Blocks.air == world.getBlock(x + (length + 2) * dirx, y, z + (length + 2) * dirz)) {
            OreSpawnMain.setBlockFast(world, x + (length + 2) * dirx, y, z + (length + 2) * dirz, (Block)Blocks.leaves, 0, 2);
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
            OreSpawnMain.setBlockFast(world, x, j + y, z, Blocks.log, 0, 2);
            if (j > height / 5) {
                OreSpawnMain.setBlockFast(world, x + dirx, j + y, z + dirz, (Block)Blocks.leaves, 0, 2);
                if (j > height / 4 && j % 4 == 0) {
                    this.WindTreeBranch(world, x, j + y, z, height - j, dirx, dirz);
                }
            }
        }
        OreSpawnMain.setBlockFast(world, x, y + height, z, (Block)Blocks.leaves, 0, 2);
    }

    private void SkyTreeBranch(final World world, final int x, final int y, final int z, final int length, final int dirx, final int dirz) {
        for (int i = 1; i < length; ++i) {
            OreSpawnMain.setBlockFast(world, x + i * dirx, y, z + i * dirz, OreSpawnMain.MySkyTreeLog, 0, 2);
            if (Blocks.air == world.getBlock(x + i * dirx, y + 1, z + i * dirz)) {
                OreSpawnMain.setBlockFast(world, x + i * dirx, y + 1, z + i * dirz, (Block)Blocks.leaves, 0, 2);
            }
            if (Blocks.air == world.getBlock(x + i * dirx + dirz, y, z + i * dirz + dirx)) {
                OreSpawnMain.setBlockFast(world, x + i * dirx + dirz, y, z + i * dirz + dirx, (Block)Blocks.leaves, 0, 2);
            }
            if (Blocks.air == world.getBlock(x + i * dirx - dirz, y, z + i * dirz - dirx)) {
                OreSpawnMain.setBlockFast(world, x + i * dirx - dirz, y, z + i * dirz - dirx, (Block)Blocks.leaves, 0, 2);
            }
        }
        if (Blocks.air == world.getBlock(x + length * dirx, y, z + length * dirz)) {
            OreSpawnMain.setBlockFast(world, x + length * dirx, y, z + length * dirz, (Block)Blocks.leaves, 0, 2);
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
            OreSpawnMain.setBlockFast(world, x, j, z, OreSpawnMain.MySkyTreeLog, 0, 2);
        }
        OreSpawnMain.setBlockFast(world, x, height + 1, z, (Block)Blocks.leaves, 0, 2);
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
            }
            else {
                realy = y - 2;
            }
            return;
        }
        realy = y - 1;
        bid = world.getBlock(x, realy + 1, z);
        if (bid != OreSpawnMain.MyDT) {
            OreSpawnMain.setBlockFast(world, x, realy + 1, z, OreSpawnMain.MyDT, 0, 2);
            return;
        }
        bid = world.getBlock(x, realy + 2, z);
        if (bid != OreSpawnMain.MyDT) {
            OreSpawnMain.setBlockFast(world, x, realy + 2, z, OreSpawnMain.MyDT, 0, 2);
            return;
        }
        bid = world.getBlock(x, realy + 3, z);
        if (bid != OreSpawnMain.MyDT) {
            OreSpawnMain.setBlockFast(world, x, realy + 3, z, OreSpawnMain.MyDT, 0, 2);
            return;
        }
        bid = world.getBlock(x, realy + 4, z);
        if (bid != OreSpawnMain.MyAppleLeaves) {
            OreSpawnMain.setBlockFast(world, x, realy + 4, z, OreSpawnMain.MyAppleLeaves, 0, 2);
            return;
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                if (j != 0 || i != 0) {
                    bid = world.getBlock(x + i, realy + 3, z + j);
                    if (bid != OreSpawnMain.MyAppleLeaves) {
                        OreSpawnMain.setBlockFast(world, x + i, realy + 3, z + j, OreSpawnMain.MyAppleLeaves, 0, 2);
                        return;
                    }
                }
            }
        }
        Block bidm = Blocks.air;
        for (int tries = 0; tries < 20 && (bidm == Blocks.air || bidm == OreSpawnMain.MyDT); ++tries) {
            int i = world.rand.nextInt(5) - 2;
            int j = world.rand.nextInt(5) - 2;
            bidm = world.getBlock(x + i, realy + 1, z + j);
            final int meta = world.getBlockMetadata(x + i, realy + 1, z + j);
            if (bidm != Blocks.air && bidm != OreSpawnMain.MyDT) {
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
                        OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyExperienceLeaves, 0, 2);
                    }
                }
            }
        }
    }

    private void grow_small_branch(final World world, final int x, final int y, final int z, final int xdir, final int zdir, final int xxdir, final int zzdir) {
        int i2 = 0;
        int k2 = 0;
        int j2 = 0;
        int l = x;
        int m = y;
        int k3 = z;
        for (int grow = 4 + world.rand.nextInt(2), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            ++m;
            l += xdir;
            k3 += zdir;
            i2 = l;
            k2 = k3;
        }
        for (int grow = 4 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
        }
        for (int grow = 4 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, i2, m, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, m, k2);
            i2 += xxdir;
            k2 += zzdir;
        }
        j2 = --m;
        for (int grow = 3 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
            --m;
        }
        for (int grow = 3 + world.rand.nextInt(3), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, i2, j2, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, j2, k2);
            i2 += xxdir;
            k2 += zzdir;
            --j2;
        }
    }

    private void grow_branch(final World world, final int x, final int y, final int z, final int xdir, final int zdir, final int xxdir, final int zzdir) {
        int i2 = 0;
        int k2 = 0;
        int j2 = 0;
        int l = x;
        int m = y;
        int k3 = z;
        for (int grow = 5 + world.rand.nextInt(4), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            ++m;
            l += xdir;
            k3 += zdir;
            i2 = l;
            k2 = k3;
        }
        for (int grow = 6 + world.rand.nextInt(5), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
        }
        for (int grow = 6 + world.rand.nextInt(5), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, i2, m, k2, Blocks.log, 0, 2);
            this.make_leaves(world, i2, m, k2);
            i2 += xxdir;
            k2 += zzdir;
        }
        j2 = --m;
        for (int grow = 4 + world.rand.nextInt(4), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, Blocks.log, 0, 2);
            this.make_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
            --m;
        }
        for (int grow = 4 + world.rand.nextInt(4), n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, i2, j2, k2, Blocks.log, 0, 2);
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
                    OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
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
                    OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
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
                    OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, Blocks.log, 0, 2);
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
                    OreSpawnMain.setBlockFast(world, x, y, z, Blocks.air, 0, 2);
                    return;
                }
                realy = y - 3;
            }
            else {
                realy = y - 2;
            }
            return;
        }
        realy = y - 1;
        bid = world.getBlock(x, realy + 1, z);
        if (bid == Blocks.air) {
            OreSpawnMain.setBlockFast(world, x, realy + 1, z, OreSpawnMain.MySkyTreeLog, 0, 2);
        }
        if (world.rand.nextInt(2) == 1) {
            bid = world.getBlock(x, realy + 2, z);
            if (bid == Blocks.air) {
                OreSpawnMain.setBlockFast(world, x, realy + 2, z, OreSpawnMain.MySkyTreeLog, 0, 2);
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, realy + 3, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x, realy + 3, z, OreSpawnMain.MySkyTreeLog, 0, 2);
                }
            }
            else {
                --realy;
            }
        }
        else {
            realy -= 2;
        }
        bid = world.getBlock(x, realy + 4, z);
        if (bid == Blocks.air) {
            OreSpawnMain.setBlockFast(world, x, realy + 4, z, OreSpawnMain.MyAppleLeaves, 0, 2);
        }
        for (int i = -1; i <= 1; ++i) {
            for (int j = -1; j <= 1; ++j) {
                bid = world.getBlock(x + i, realy + 3, z + j);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x + i, realy + 3, z + j, OreSpawnMain.MyAppleLeaves, 0, 2);
                }
            }
        }
    }

    public void makeScragglyBranch(final World world, int x, int y, int z, final int len, final int biasx, final int biasz) {
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
            if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
                return;
            }
            OreSpawnMain.setBlockFast(world, x, y, z, Blocks.log, 0, 2);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = world.getBlock(x + m, y, z + n);
                        if (bid == Blocks.air) {
                            OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0, 2);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, y + 1, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0, 2);
                }
            }
        }
    }

    public void ScragglyTreeWithBranches(final World world, int x, int y, int z) {
        final int i = 1 + world.rand.nextInt(3);
        final int j = i + world.rand.nextInt(12);
        for (int k = 0; k < i; ++k) {
            final Block bid = world.getBlock(x, y + k, z);
            if (k >= 1 && bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
                return;
            }
            OreSpawnMain.setBlockFast(world, x, y + k, z, Blocks.log, 0, 2);
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
            if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
                break;
            }
            OreSpawnMain.setBlockFast(world, x, y, z, Blocks.log, 0, 2);
            if (world.rand.nextInt(4) == 1) {
                this.makeScragglyBranch(world, x, y, z, world.rand.nextInt(1 + j - k), world.rand.nextInt(2) - world.rand.nextInt(2), world.rand.nextInt(2) - world.rand.nextInt(2));
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = world.getBlock(x + m, y, z + n);
                        if (bid == Blocks.air) {
                            OreSpawnMain.setBlockFast(world, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0, 2);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = world.getBlock(x, y + 1, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockFast(world, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0, 2);
                }
            }
        }
    }

    public void FairyTree(final World world, final int x, final int y, final int z) {
        for (int j = 1; j < 6; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 2; ++k) {
                    OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
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
                    OreSpawnMain.setBlockFast(world, x + i, y + j, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                    this.make_crystal_leaves(world, x + i, y + j, z + k);
                }
            }
        }
        world.setBlock(x - 1, y + 1, z, Blocks.mob_spawner, 0, 2);
        final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x - 1, y + 1, z);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a().setEntityName("Fairy");
        }
        world.setBlock(x + 2, y + 1, z, (Block)Blocks.chest, 0, 2);
        final TileEntityChest chest = (TileEntityChest)world.getTileEntity(x + 2, y + 1, z);
        if (chest != null) {
            WeightedRandomChestContent.generateChestContents(world.rand, Trees.CrystalChestContentsList, (IInventory)chest, 1 + world.rand.nextInt(5));
        }
    }

    private void make_crystal_leaves(final World world, final int x, final int y, final int z) {
        for (int l1 = -2; l1 <= 2; ++l1) {
            for (int l2 = -2; l2 <= 2; ++l2) {
                for (int l3 = 0; l3 <= 1; ++l3) {
                    final Block bid = world.getBlock(x + l1, y + l3, z + l2);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyCrystalLeaves3, 0, 2);
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
                            OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyCrystalLeaves3, 0, 2);
                        }
                        else {
                            OreSpawnMain.setBlockFast(world, x + l1, y + l3, z + l2, OreSpawnMain.MyCrystalLeaves2, 0, 2);
                        }
                    }
                }
            }
        }
    }

    private void grow_crystal_branch(final World world, final int x, final int y, final int z, final int xdir, final int zdir, final int xxdir, final int zzdir, final int ydir) {
        int i2 = 0;
        int k2 = 0;
        int j2 = 0;
        int l = x;
        int m = y;
        int k3 = z;
        int grow = 4 + world.rand.nextInt(4);
        if (OreSpawnMain.LessLag == 1) {
            --grow;
        }
        if (OreSpawnMain.LessLag == 2) {
            grow -= 2;
        }
        for (int n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, l, m, k3);
            ++m;
            l += xdir;
            k3 += zdir;
            i2 = l;
            k2 = k3;
        }
        grow = 5 + world.rand.nextInt(5);
        if (OreSpawnMain.LessLag == 1) {
            --grow;
        }
        if (OreSpawnMain.LessLag == 2) {
            grow -= 2;
        }
        for (int n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
        }
        grow = 5 + world.rand.nextInt(5);
        if (OreSpawnMain.LessLag == 1) {
            --grow;
        }
        if (OreSpawnMain.LessLag == 2) {
            grow -= 2;
        }
        for (int n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, i2, m, k2, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, i2, m, k2);
            i2 += xxdir;
            k2 += zzdir;
        }
        j2 = --m;
        grow = 4 + world.rand.nextInt(4);
        if (OreSpawnMain.LessLag == 1) {
            --grow;
        }
        if (OreSpawnMain.LessLag == 2) {
            grow -= 2;
        }
        for (int n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, l, m, k3, OreSpawnMain.MyCrystalTreeLog, 0, 2);
            this.make_crystal_leaves(world, l, m, k3);
            l += xdir;
            k3 += zdir;
            m += ydir;
        }
        grow = 4 + world.rand.nextInt(4);
        if (OreSpawnMain.LessLag == 1) {
            --grow;
        }
        if (OreSpawnMain.LessLag == 2) {
            grow -= 2;
        }
        for (int n = 0; n < grow; ++n) {
            OreSpawnMain.setBlockFast(world, i2, j2, k2, OreSpawnMain.MyCrystalTreeLog, 0, 2);
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
            final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner)world.getTileEntity(x, y + 1, z);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a().setEntityName("Fairy");
            }
        }
        if (i == 2) {
            world.setBlock(x, y + 1, z, (Block)Blocks.chest, 0, 2);
            final TileEntityChest chest = (TileEntityChest)world.getTileEntity(x, y + 1, z);
            if (chest != null) {
                WeightedRandomChestContent.generateChestContents(world.rand, Trees.CrystalChestContentsList, (IInventory)chest, 1 + world.rand.nextInt(5));
            }
        }
    }

    public void FairyCastleTree(final World world, final int x, final int y, final int z) {
        int nc = 6;
        if (OreSpawnMain.LessLag == 1) {
            --nc;
        }
        if (OreSpawnMain.LessLag == 2) {
            nc -= 2;
        }
        int j = 3 + world.rand.nextInt(3);
        int spread = 0;
        for (int iter = 0; iter < nc; ++iter) {
            final int grow = 4 + world.rand.nextInt(3);
            int width = 1 + world.rand.nextInt(3);
            int randy = world.rand.nextInt(3) - 1;
            for (int i = -width; i <= width; ++i) {
                for (int k = -width; k <= width; ++k) {
                    OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                    if (i == -width || i == width || k == -width || k == width) {
                        this.make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k);
                    }
                    if (iter != 0 && i == 0 && k == 0) {
                        this.addSomething(world, x + i + spread, y + j + randy, z + k);
                    }
                    if (i == -width && (k == -width || k == width)) {
                        OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2);
                    }
                    if (i == width && (k == -width || k == width)) {
                        OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2);
                    }
                }
            }
            if (iter != 0) {
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy, z + k, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i - spread, y + j + randy, z + k);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i, y + j + randy, z + k + spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i, y + j + randy, z + k + spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i, y + j + randy, z + k + spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i, y + j + randy, z + k - spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i, y + j + randy, z + k - spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i, y + j + randy, z + k - spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                    }
                }
            }
            if (iter >= 2) {
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy, z + k + spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k + spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i + spread, y + j + randy, z + k + spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy, z + k - spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k - spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i - spread, y + j + randy, z + k - spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy, z + k + spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i - spread, y + j + randy, z + k + spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i - spread, y + j + randy, z + k + spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i - spread, y + j + randy + 1, z + k + spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                    }
                }
                width = 1 + world.rand.nextInt(3 + iter);
                randy = world.rand.nextInt(3) - 1;
                for (int i = -width; i <= width; ++i) {
                    for (int k = -width; k <= width; ++k) {
                        OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy, z + k - spread, OreSpawnMain.MyCrystalTreeLog, 0, 2);
                        if (i == -width || i == width || k == -width || k == width) {
                            this.make_crystal_castle_leaves(world, x + i + spread, y + j + randy, z + k - spread);
                        }
                        if (i == 0 && k == 0) {
                            this.addSomething(world, x + i + spread, y + j + randy, z + k - spread);
                        }
                        if (i == -width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2);
                        }
                        if (i == width && (k == -width || k == width)) {
                            OreSpawnMain.setBlockFast(world, x + i + spread, y + j + randy + 1, z + k - spread, OreSpawnMain.CrystalTorch, 0, 2);
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
        CrystalChestContentsList = new WeightedRandomChestContent[] { new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalTermiteBlock), 0, 1, 5, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerRedBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerBlueBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerGreenBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFlowerYellowBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalPlanksBlock), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalWorkbenchBlock), 0, 1, 1, 10), new WeightedRandomChestContent(Item.getItemFromBlock((Block)OreSpawnMain.CrystalFurnaceBlock), 0, 1, 1, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyTigersEyeBlock), 0, 1, 10, 5), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalStone), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalRat), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalFairy), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalGrass), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCrystal), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalTorch), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalLeaves), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalLeaves2), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalLeaves3), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyCrystalTreeLog), 0, 1, 10, 10), new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.TigersEye), 0, 1, 10, 5), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodAxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodShovel, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodPickaxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalWoodHoe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkAxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkShovel, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkPickaxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkHoe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeSword, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeAxe, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeShovel, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyePickaxe, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeHoe, 0, 1, 1, 5), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneSword, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneAxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneShovel, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStonePickaxe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalStoneHoe, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeIngot, 0, 1, 5, 5), new WeightedRandomChestContent(OreSpawnMain.MyCrystalPinkIngot, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MyCrystalApple, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MyPeacockFeather, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MyPeacock, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyRawPeacock, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyRice, 0, 1, 10, 20), new WeightedRandomChestContent(OreSpawnMain.MyQuinoa, 0, 1, 10, 20), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBody, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeLegs, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.TigersEyeBoots, 0, 1, 1, 5), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherHelmet, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherBody, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherLegs, 0, 1, 1, 10), new WeightedRandomChestContent((Item)OreSpawnMain.PeacockFeatherBoots, 0, 1, 1, 10), new WeightedRandomChestContent(OreSpawnMain.RotatorEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.VortexEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.PeacockEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.DungeonBeastEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.FairyEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.RatEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.FlounderEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.WhaleEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.IrukandjiEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.SkateEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.UrchinEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.GhostEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.GhostSkellyEgg, 0, 1, 5, 10), new WeightedRandomChestContent(OreSpawnMain.MySkateBow, 0, 1, 1, 2), new WeightedRandomChestContent(OreSpawnMain.MyIrukandjiArrow, 0, 5, 10, 2), new WeightedRandomChestContent(OreSpawnMain.MyIrukandji, 0, 2, 8, 5), new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 2), new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 2), new WeightedRandomChestContent(Items.iron_ingot, 0, 1, 4, 10), new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 1, 4, 10), new WeightedRandomChestContent(Items.golden_apple, 0, 1, 5, 2) };
    }
}
