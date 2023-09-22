
package fr.iamacat.dangerzone_iamacatfr.items;

import java.awt.*;
import java.util.Vector;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;

public class CrystalMaze {

    public static final int WTOP = 1;
    public static final int WRGT = 2;
    public static final int WBOT = 4;
    public static final int WLFT = 8;

    public void buildCrystalMaze(final World world, final int x, final int y, final int z, final Chunk chunk) {
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                for (int k = 0; k < 3; ++k) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + j, y + k, z + i, Blocks.air, 0);
                }
            }
        }
        this.makeMaze(world, x, y, z, 4, 4, 4, 1, chunk);
        this.openCrystalMaze(world, x, y, z, 4, 4, 4, chunk);
    }

    private void openCrystalMaze(final World world, final int xx, final int yy, final int zz, final int xw,
        final int zw, final int csz, final Chunk chunk) {
        for (int i = 0; i < zw * csz; ++i) {
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx, yy, zz + i, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx, yy + 1, zz + i, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx, yy + 2, zz + i, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy, zz, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 1, zz, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 2, zz, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + zw * csz - 1, yy, zz + i, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + zw * csz - 1, yy + 1, zz + i, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + zw * csz - 1, yy + 2, zz + i, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy, zz + zw * csz - 1, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 1, zz + zw * csz - 1, Blocks.air, 0);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + i, yy + 2, zz + zw * csz - 1, Blocks.air, 0);
        }
        for (int i = 0; i < zw * csz; ++i) {
            for (int j = 0; j < zw * csz; ++j) {
                OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + j, yy - 1, zz + i, Blocks.bedrock, 0);
                OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + j, yy + 3, zz + i, Blocks.bedrock, 0);
            }
        }
        for (int k = 0; k < 4; ++k) {
            final int i = world.rand.nextInt(zw * csz);
            final int j = world.rand.nextInt(zw * csz);
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + j, yy + 3, zz + i, OreSpawnMain.CrystalStone, 0);
        }
        int i = world.rand.nextInt(zw * csz);
        int j = world.rand.nextInt(zw * csz);
        OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, xx + j, yy - 1, zz + i, OreSpawnMain.CrystalStone, 0);
    }

    private void makeMaze(final World world, final int xx, final int yy, final int zz, final int xw, final int zw,
        final int csz, final int b, final Chunk chunk) {
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
        final Vector outlist = new Vector(gridw * gridh);
        final Vector inlist = new Vector(10, 10);
        final Vector frontlist = new Vector(10, 10);
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
                        b,
                        chunk);
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
                        b,
                        chunk);
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
                        b,
                        chunk);
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
                        b,
                        chunk);
                }
            }
        }
    }

    private void drawSide(final World world, int fromx, int fromz, int tox, int toz, final int x, final int y,
        final int z, final int cellsize, final int gridh, final int gridw, final int bb, final Chunk chunk) {
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
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y, j + z, blk, 0);
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 1, j + z, blk, 0);
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 2, j + z, blk, 0);
                }
            }
        } else {
            final int j = fromz;
            for (int i = fromx; i <= tox; ++i) {
                if (i < cellsize * gridw) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y, j + z, blk, 0);
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 1, j + z, blk, 0);
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, i + x, y + 2, j + z, blk, 0);
                }
            }
        }
    }

    private int findInNbr(final Point p, final int[][] cells, final Vector inlist) {
        int d = this.rnd(4) - 1;
        for (int k = 0; k < 4; ++k) {
            switch (d) {
                case 0: {
                    if ((cells[p.x][p.y] & 0x10) != 0x0) {
                        break;
                    }
                    if (inlist.indexOf(new Point(p.x, p.y - 1)) >= 0) {
                        return 1;
                    }
                    break;
                }
                case 1: {
                    if ((cells[p.x][p.y] & 0x20) != 0x0) {
                        break;
                    }
                    if (inlist.indexOf(new Point(p.x + 1, p.y)) >= 0) {
                        return 2;
                    }
                    break;
                }
                case 2: {
                    if ((cells[p.x][p.y] & 0x40) != 0x0) {
                        break;
                    }
                    if (inlist.indexOf(new Point(p.x, p.y + 1)) >= 0) {
                        return 4;
                    }
                    break;
                }
                case 3: {
                    if ((cells[p.x][p.y] & 0x80) != 0x0) {
                        break;
                    }
                    if (inlist.indexOf(new Point(p.x - 1, p.y)) >= 0) {
                        return 8;
                    }
                    break;
                }
            }
            d = (d + 1) % 4;
        }
        return 0;
    }

    private void moveNbrs(final Point p, final int[][] cells, final Vector outlist, final Vector frontlist) {
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

    private void movePoint(final Point p, final Vector v, final Vector w) {
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

    private Object rndElement(final Vector v) {
        final int i = this.rnd(v.size()) - 1;
        final Object s = v.elementAt(i);
        v.removeElementAt(i);
        return s;
    }

    private void clearArea(final World world, final int x, final int y, final int z, final Chunk chunk) {
        for (int i = 0; i < 60; ++i) {
            int hi = 5;
            if (i >= 30) {
                hi = 7;
            }
            for (int j = 0; j < hi; ++j) {
                for (int k = 0; k < 30; ++k) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x + i, y + j, z + k, Blocks.air, 0);
                }
            }
        }
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 6; ++j) {
                for (int k = 0; k < 30; ++k) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x - i, y + j, z + k, Blocks.air, 0);
                }
            }
        }
    }
}
