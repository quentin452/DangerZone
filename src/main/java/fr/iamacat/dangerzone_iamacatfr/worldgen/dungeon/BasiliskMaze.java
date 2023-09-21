
package fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon;

import java.awt.*;
import java.util.Vector;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.BasiliskInstance;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;

public class BasiliskMaze {

    private final WeightedRandomChestContent[] chestContentsList;

    public BasiliskMaze() {
        this.chestContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.ender_pearl, 0, 3, 6, 15),
            new WeightedRandomChestContent(Items.diamond, 0, 15, 25, 20),
            new WeightedRandomChestContent(Items.blaze_rod, 0, 4, 12, 15),
            new WeightedRandomChestContent(DangerZone.CageEmpty, 0, 3, 10, 20),
            new WeightedRandomChestContent(DangerZone.CagedGirlfriend, 0, 2, 4, 15),
            new WeightedRandomChestContent(Items.iron_ingot, 0, 2, 20, 20),
            new WeightedRandomChestContent(Items.gold_ingot, 0, 4, 16, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.UraniumIngot, 0, 2, 8, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.TitaniumIngot, 0, 2, 6, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.SunFish, 0, 2, 8, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.FireFish, 0, 3, 8, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.LavaEel, 0, 5, 24, 20),
            new WeightedRandomChestContent(ItemInitDangerZone.CookedCornDog, 0, 6, 12, 20),
            new WeightedRandomChestContent(Items.diamond_pickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.diamond_sword, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimatePickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.MyUltimateSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateFishingRod, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateBow, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.diamond_chestplate, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.diamond_helmet, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.diamond_leggings, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.diamond_boots, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateChestplate, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateLeggings, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.UltimateBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(ItemInitDangerZone.RubyIngot, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.ThunderStaff, 0, 1, 1, 5),
            new WeightedRandomChestContent(ItemInitDangerZone.OmgMagicApple, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.golden_apple, 0, 2, 4, 15) };
    }

    public void buildBasiliskMaze(final World world, final int x, final int y, final int z) {
        final int depth = 20 + world.rand.nextInt(10);
        this.clearArea(world, x + 3, y - depth - 4, z - 20);
        this.makeMaze(world, x + 3, y - depth - 3, z - 20, 10, 10, 3, 0);
        this.openMaze(world, x + 3, y - depth - 3, z - 20, 10, 10, 3);
        this.buildCastle(world, x + 3, y - depth - 4, z - 20);
        this.makeEntrance(world, x, y, z, depth);
    }

    private void makeMaze(final World world, final int xx, final int yy, final int zz, final int xw, final int zw,
        final int csz, final int b) {
        final int gridw = xw;
        final int gridh = zw;
        int cellsize = csz;
        if (cellsize < 3) {
            cellsize = 3;
        }
        final int[][] cells = new int[gridw][gridh];
        final int full = 15;
        for (int x = 0; x < gridw; ++x) {
            for (int y = 0; y < gridh; ++y) {
                cells[x][y] = full;
            }
        }
        final int left = 128;
        final int right = 32;
        for (int y = 0; y < gridh; ++y) {
            final int[] array = cells[0];
            final int n = y;
            array[n] |= left;
            final int[] array2 = cells[gridw - 1];
            final int n2 = y;
            array2[n2] |= right;
        }
        final int top = 16;
        final int bottom = 64;
        for (int x = 0; x < gridw; ++x) {
            final int[] array3 = cells[x];
            final int n3 = 0;
            array3[n3] |= top;
            final int[] array4 = cells[x];
            final int n4 = gridh - 1;
            array4[n4] |= bottom;
        }
        final Vector<Point> outlist = new Vector<Point>(gridw * gridh);
        final Vector<Point> inlist = new Vector<Point>(10, 10);
        final Vector<Point> frontlist = new Vector<>(10, 10);
        for (int x = 0; x < gridw; ++x) {
            for (int y = 0; y < gridh; ++y) {
                outlist.addElement(new Point(x, y));
            }
        }
        Point current_cell = (Point) this.rndElement(outlist);
        inlist.addElement(current_cell);
        this.moveNbrs(current_cell, cells, outlist, frontlist);
        while (!frontlist.isEmpty()) {
            current_cell = (Point) this.rndElement(frontlist);
            inlist.addElement(current_cell);
            this.moveNbrs(current_cell, cells, outlist, frontlist);
            final int dir = this.findInNbr(current_cell, cells, inlist);
            this.removeWall(current_cell, dir, cells);
        }
        current_cell = null;
        for (int x = 0; x < gridw; ++x) {
            for (int y = 0; y < gridh; ++y) {
                final int val = cells[x][y];
                if ((val & 0x1) != 0x0) {
                    this.drawSide(
                        world,
                        x * cellsize,
                        y * cellsize,
                        (x + 1) * cellsize,
                        y * cellsize,
                        xx,
                        yy,
                        zz,
                        cellsize,
                        gridh,
                        gridw,
                        b);
                }
                if ((val & 0x2) != 0x0) {
                    this.drawSide(
                        world,
                        (x + 1) * cellsize - 1,
                        y * cellsize,
                        (x + 1) * cellsize - 1,
                        (y + 1) * cellsize,
                        xx,
                        yy,
                        zz,
                        cellsize,
                        gridh,
                        gridw,
                        b);
                }
                if ((val & 0x4) != 0x0) {
                    this.drawSide(
                        world,
                        x * cellsize,
                        (y + 1) * cellsize - 1,
                        (x + 1) * cellsize,
                        (y + 1) * cellsize - 1,
                        xx,
                        yy,
                        zz,
                        cellsize,
                        gridh,
                        gridw,
                        b);
                }
                if ((val & 0x8) != 0x0) {
                    this.drawSide(
                        world,
                        x * cellsize,
                        y * cellsize,
                        x * cellsize,
                        (y + 1) * cellsize,
                        xx,
                        yy,
                        zz,
                        cellsize,
                        gridh,
                        gridw,
                        b);
                }
            }
        }
    }

    private void drawSide(final World world, int fromx, int fromz, int tox, int toz, final int x, final int y,
        final int z, final int cellsize, final int gridh, final int gridw, final int bb) {
        Block blk = Blocks.obsidian;
        if (bb != 0) {
            blk = Blocks.bedrock;
        }
        if (fromx > tox) {
            final int i = fromx;
            fromx = tox;
            tox = i;
        }
        if (fromz > toz) {
            final int i = fromz;
            fromz = toz;
            toz = i;
        }
        if (fromx == tox) {
            final int i = fromx;
            for (int j = fromz; j <= toz; ++j) {
                if (j < cellsize * gridh) {
                    DangerZone.setBlockFast(world, i + x, y, j + z, blk, 0, 2);
                    DangerZone.setBlockFast(world, i + x, y + 1, j + z, blk, 0, 2);
                    DangerZone.setBlockFast(world, i + x, y + 2, j + z, blk, 0, 2);
                }
            }
        } else {
            final int j = fromz;
            for (int i = fromx; i <= tox; ++i) {
                if (i < cellsize * gridw) {
                    DangerZone.setBlockFast(world, i + x, y, j + z, blk, 0, 2);
                    DangerZone.setBlockFast(world, i + x, y + 1, j + z, blk, 0, 2);
                    DangerZone.setBlockFast(world, i + x, y + 2, j + z, blk, 0, 2);
                }
            }
        }
    }

    private int findInNbr(final Point p, final int[][] cells, final Vector<Point> inlist) {
        int d = this.rnd(4) - 1;
        for (int k = 0; k < 4; ++k) {
            switch (d) {
                case 0: {
                    if ((cells[p.x][p.y] & 0x10) != 0x0) {
                        break;
                    }
                    if (inlist.contains(new Point(p.x, p.y - 1))) {
                        return 1;
                    }
                    break;
                }
                case 1: {
                    if ((cells[p.x][p.y] & 0x20) != 0x0) {
                        break;
                    }
                    if (inlist.contains(new Point(p.x + 1, p.y))) {
                        return 2;
                    }
                    break;
                }
                case 2: {
                    if ((cells[p.x][p.y] & 0x40) != 0x0) {
                        break;
                    }
                    if (inlist.contains(new Point(p.x, p.y + 1))) {
                        return 4;
                    }
                    break;
                }
                case 3: {
                    if ((cells[p.x][p.y] & 0x80) != 0x0) {
                        break;
                    }
                    if (inlist.contains(new Point(p.x - 1, p.y))) {
                        return 8;
                    }
                    break;
                }
            }
            d = (d + 1) % 4;
        }
        return 0;
    }

    private void moveNbrs(final Point p, final int[][] cells, final Vector<Point> outlist,
        final Vector<Point> frontlist) {
        if ((cells[p.x][p.y] & 0x10) == 0x0) {
            final Point s = new Point(p.x, p.y - 1);
            this.movePoint(s, outlist, frontlist);
        }
        if ((cells[p.x][p.y] & 0x20) == 0x0) {
            final Point s = new Point(p.x + 1, p.y);
            this.movePoint(s, outlist, frontlist);
        }
        if ((cells[p.x][p.y] & 0x40) == 0x0) {
            final Point s = new Point(p.x, p.y + 1);
            this.movePoint(s, outlist, frontlist);
        }
        if ((cells[p.x][p.y] & 0x80) == 0x0) {
            final Point s = new Point(p.x - 1, p.y);
            this.movePoint(s, outlist, frontlist);
        }
    }

    private void movePoint(final Point p, final Vector<Point> v, final Vector<Point> w) {
        final int i = v.indexOf(p);
        if (i >= 0) {
            v.removeElementAt(i);
            w.addElement(p);
        }
    }

    private void removeWall(final Point p, final int d, final int[][] cells) {
        final int[] array = cells[p.x];
        final int y = p.y;
        array[y] ^= d;
        switch (d) {
            case 1: {
                final int[] array2 = cells[p.x];
                final int n = p.y - 1;
                array2[n] ^= 0x4;
                break;
            }
            case 2: {
                final int[] array3 = cells[p.x + 1];
                final int y2 = p.y;
                array3[y2] ^= 0x8;
                break;
            }
            case 4: {
                final int[] array4 = cells[p.x];
                final int n2 = p.y + 1;
                array4[n2] ^= 0x1;
                break;
            }
            case 8: {
                final int[] array5 = cells[p.x - 1];
                final int y3 = p.y;
                array5[y3] ^= 0x2;
                break;
            }
        }
    }

    private int rnd(final int n) {
        return (int) (Math.random() * n + 1.0);
    }

    private Object rndElement(final Vector<Point> v) {
        final int i = this.rnd(v.size()) - 1;
        final Object s = v.elementAt(i);
        v.removeElementAt(i);
        return s;
    }

    private Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    private void clearArea(final World world, final int x, final int y, final int z) {
        for (int i = 0; i < 60; ++i) {
            int hi = 5;
            if (i >= 30) {
                hi = 7;
            }
            for (int j = 0; j < hi; ++j) {
                for (int k = 0; k < 30; ++k) {
                    DangerZone.setBlockFast(world, x + i, y + j, z + k, Blocks.air, 0, 2);
                }
            }
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 6; ++j) {
                for (int k = 0; k < 30; ++k) {
                    DangerZone.setBlockFast(world, x - i, y + j, z + k, Blocks.air, 0, 2);
                }
            }
        }
    }

    private void openMaze(final World world, final int xx, final int yy, final int zz, final int xw, final int zw,
        final int csz) {
        for (int i = 0; i < zw * csz; ++i) {
            final Block bid = world.getBlock(xx + 1, yy, zz + i);
            if (bid == Blocks.air) {
                DangerZone.setBlockFast(world, xx, yy, zz + i, Blocks.air, 0, 2);
                DangerZone.setBlockFast(world, xx, yy + 1, zz + i, Blocks.air, 0, 2);
                DangerZone.setBlockFast(world, xx, yy + 2, zz + i, Blocks.air, 0, 2);
                break;
            }
        }
        for (int i = zw * csz - 1; i >= 0; --i) {
            final Block bid = world.getBlock(xx + xw * csz - 2, yy, zz + i);
            if (bid == Blocks.air) {
                DangerZone.setBlockFast(world, xx + xw * csz - 1, yy, zz + i, Blocks.air, 0, 2);
                DangerZone.setBlockFast(world, xx + xw * csz - 1, yy + 1, zz + i, Blocks.air, 0, 2);
                DangerZone.setBlockFast(world, xx + xw * csz - 1, yy + 2, zz + i, Blocks.air, 0, 2);
                break;
            }
        }
    }

    private void buildCastle(final World world, final int x, final int y, final int z) {
        for (int i = 0; i < 60; ++i) {
            for (int k = 0; k < 30; ++k) {
                DangerZone.setBlockFast(world, x + i, y, z + k, Blocks.obsidian, 0, 2);
            }
        }
        for (int i = 0; i < 80; ++i) {
            DangerZone.setBlockFast(
                world,
                x + world.rand.nextInt(28) + 1,
                y,
                z + world.rand.nextInt(28) + 1,
                Blocks.lava,
                0,
                2);
        }
        for (int i = 0; i < 20; ++i) {
            DangerZone.setBlockFast(
                world,
                x + 30 + world.rand.nextInt(28) + 1,
                y,
                z + world.rand.nextInt(28) + 1,
                BlockInitDangerZone.TeleportBlock,
                0,
                2);
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 30; ++k) {
                DangerZone.setBlockFast(world, x + i, y + 4, z + k, Blocks.bedrock, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 30; ++k) {
                DangerZone.setBlockFast(world, x + i + 30, y + 6, z + k, Blocks.bedrock, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 5; ++k) {
                DangerZone.setBlockFast(world, x + 59, y + k + 1, z + i, Blocks.obsidian, 0, 2);
                DangerZone.setBlockFast(world, x + 60, y + k + 1, z + i, Blocks.bedrock, 0, 2);
                DangerZone.setBlockFast(world, x + 61, y + k + 1, z + i, Blocks.bedrock, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 5; ++k) {
                DangerZone.setBlockFast(world, x + 30 + i, y + k + 1, z, Blocks.obsidian, 0, 2);
                DangerZone.setBlockFast(world, x + 30 + i, y + k + 1, z - 1, Blocks.bedrock, 0, 2);
                DangerZone.setBlockFast(world, x + 30 + i, y + k + 1, z - 2, Blocks.bedrock, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 5; ++k) {
                DangerZone.setBlockFast(world, x + 30 + i, y + k + 1, z + 29, Blocks.obsidian, 0, 2);
                DangerZone.setBlockFast(world, x + 30 + i, y + k + 1, z + 30, Blocks.bedrock, 0, 2);
                DangerZone.setBlockFast(world, x + 30 + i, y + k + 1, z + 31, Blocks.bedrock, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            DangerZone.setBlockFast(world, x + 30, y + 5, z + i, Blocks.obsidian, 0, 2);
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 4; ++k) {
                DangerZone.setBlockFast(world, x - 4 + k, y, z + i, Blocks.sandstone, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 0; k < 4; ++k) {
                DangerZone.setBlockFast(world, x - 4 + k, y + 5, z + i, Blocks.obsidian, 0, 2);
            }
        }
        for (int i = 0; i < 30; ++i) {
            for (int k = 1; k < 5; ++k) {
                DangerZone.setBlockFast(world, x - 5, y + k, z + i, Blocks.iron_ore, 0, 2);
            }
        }
        for (int i = 0; i < 5; ++i) {
            for (int k = 1; k < 5; ++k) {
                DangerZone.setBlockFast(world, x - 4 + i, y + k, z - 1, Blocks.iron_ore, 0, 2);
            }
        }
        for (int i = 0; i < 5; ++i) {
            for (int k = 1; k < 5; ++k) {
                DangerZone.setBlockFast(world, x - 4 + i, y + k, z + 30, Blocks.iron_ore, 0, 2);
            }
        }
        for (int k = 0; k < 4; ++k) {
            DangerZone.setBlockFast(world, x - 4, y + 1 + k, z, Blocks.sandstone, 0, 2);
        }
        for (int k = 0; k < 4; ++k) {
            DangerZone.setBlockFast(world, x - 4, y + 1 + k, z + 15, Blocks.sandstone, 0, 2);
        }
        for (int k = 0; k < 4; ++k) {
            DangerZone.setBlockFast(world, x - 4, y + 1 + k, z + 29, Blocks.sandstone, 0, 2);
        }
        DangerZone.setBlockFast(world, x - 3, y + 3, z, BlockInitDangerZone.blocktorch, 0, 2);
        DangerZone.setBlockFast(world, x - 3, y + 3, z + 15, BlockInitDangerZone.blocktorch, 0, 2);
        DangerZone.setBlockFast(world, x - 3, y + 3, z + 29, BlockInitDangerZone.blocktorch, 0, 2);
        DangerZone.setBlockFast(world, x + 30, y + 4, z + 2, Blocks.redstone_torch, 0, 2);
        DangerZone.setBlockFast(world, x + 30, y + 4, z + 15, Blocks.redstone_torch, 0, 2);
        DangerZone.setBlockFast(world, x + 30, y + 4, z + 27, Blocks.redstone_torch, 0, 2);
        TileEntityChest chest = null;
        for (int i = 2 + world.rand.nextInt(3), k = 0; k < i; ++k) {
            DangerZone.setBlockFast(world, x + 58, y + 4, z + 2 + k * 2, Blocks.torch, 0, 2);
            DangerZone.setBlockFast(world, x + 58, y + 1, z + 2 + k * 2, (Block) Blocks.chest, 0, 2);
            chest = (TileEntityChest) world.getTileEntity(x + 58, y + 1, z + 2 + k * 2);
            if (chest != null) {
                WeightedRandomChestContent.generateChestContents(
                    world.rand,
                    this.chestContentsList,
                    (IInventory) chest,
                    5 + world.rand.nextInt(6));
            }
        }
        Entity ent = null;
        ent = this.spawnCreature(world, "Basilisk", x + 45.0, y + 1.01, z + 15.0);
        if (ent != null) {
            final BasiliskInstance b = (BasiliskInstance) ent;
            b.func_110163_bv();
        }
        ent = this.spawnCreature(world, "Basilisk", x + 46.0, y + 1.01, z + 15.0);
        if (ent != null) {
            final BasiliskInstance b = (BasiliskInstance) ent;
            b.func_110163_bv();
        }
        ent = this.spawnCreature(world, "Basilisk", x + 47.0, y + 1.01, z + 15.0);
        if (ent != null) {
            final BasiliskInstance b = (BasiliskInstance) ent;
            b.func_110163_bv();
        }
    }

    public void makeEntrance(final World world, final int x, final int y, final int z, final int depth) {
        int j;
        int width;
        for (width = (j = 8); j >= 0; --j) {
            for (int i = 0; i < j * 2 + 4; ++i) {
                DangerZone.setBlockFast(world, x + i - j, y + width - j, z - j, Blocks.sandstone, 0, 2);
                DangerZone.setBlockFast(world, x + i - j, y + width - j, z + j + 3, Blocks.sandstone, 0, 2);
                DangerZone.setBlockFast(world, x - j, y + width - j, z + i - j, Blocks.sandstone, 0, 2);
                DangerZone.setBlockFast(world, x + j + 3, y + width - j, z + i - j, Blocks.sandstone, 0, 2);
            }
        }
        int k = 0;
        for (j = width; j > -depth; --j) {
            for (int i = 0; i < 4; ++i) {
                DangerZone.setBlockFast(world, x + i, y + j, z, Blocks.bedrock, 0, 2);
                DangerZone.setBlockFast(world, x + i, y + j, z + 3, Blocks.bedrock, 0, 2);
                DangerZone.setBlockFast(world, x, y + j, z + i, Blocks.bedrock, 0, 2);
                DangerZone.setBlockFast(world, x + 3, y + j, z + i, Blocks.bedrock, 0, 2);
            }
            for (int l = 0; l < 2; ++l) {
                for (int m = 0; m < 2; ++m) {
                    DangerZone.setBlockFast(world, x + 1 + l, y + j, z + 1 + m, Blocks.air, 0, 2);
                }
            }
            switch (k) {
                case 0: {
                    DangerZone.setBlockFast(world, x + 1, y + j, z + 1, Blocks.obsidian, 0, 2);
                    break;
                }
                case 1: {
                    DangerZone.setBlockFast(world, x + 2, y + j, z + 1, Blocks.obsidian, 0, 2);
                    break;
                }
                case 2: {
                    DangerZone.setBlockFast(world, x + 2, y + j, z + 2, Blocks.obsidian, 0, 2);
                    break;
                }
                default: {
                    DangerZone.setBlockFast(world, x + 1, y + j, z + 2, Blocks.obsidian, 0, 2);
                    break;
                }
            }
            if (++k > 3) {
                k = 0;
            }
        }
    }
}
