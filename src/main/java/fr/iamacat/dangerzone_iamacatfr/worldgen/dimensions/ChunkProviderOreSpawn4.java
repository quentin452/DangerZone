
package fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class ChunkProviderOreSpawn4 implements IChunkProvider {

    private World worldObj;
    private Random random;
    private final Block[] cachedBlockIDs;
    private final byte[] cachedBlockMetadata;

    public ChunkProviderOreSpawn4(final World par1World, final long par2, final boolean par4) {
        this.cachedBlockIDs = new Block[256];
        this.cachedBlockMetadata = new byte[256];
        this.worldObj = par1World;
        this.random = new Random(par2);
        for (int j = 0; j < 8; ++j) {
            if (j == 0) {
                this.cachedBlockIDs[j] = Blocks.bedrock;
            } else if (j == 7) {
                this.cachedBlockIDs[j] = (Block) Blocks.grass;
            } else {
                this.cachedBlockIDs[j] = Blocks.dirt;
            }
        }
    }

    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(final int par1, final int par2) {
        final Chunk chunk = new Chunk(this.worldObj, par1, par2);
        for (int k = 0; k < this.cachedBlockIDs.length; ++k) {
            final Block block = this.cachedBlockIDs[k];
            if (block != null) {
                final int l = k >> 4;
                ExtendedBlockStorage extendedblockstorage = chunk.getBlockStorageArray()[l];
                if (extendedblockstorage == null) {
                    extendedblockstorage = new ExtendedBlockStorage(k, !this.worldObj.provider.hasNoSky);
                    chunk.getBlockStorageArray()[l] = extendedblockstorage;
                }
                for (int i1 = 0; i1 < 16; ++i1) {
                    for (int j1 = 0; j1 < 16; ++j1) {
                        extendedblockstorage.func_150818_a(i1, k & 0xF, j1, block);
                        extendedblockstorage.setExtBlockMetadata(i1, k & 0xF, j1, (int) this.cachedBlockMetadata[k]);
                    }
                }
            }
        }
        this.addScragglyTrees(this.worldObj, par1 * 16, par2 * 16, chunk);
        chunk.generateSkylightMap();
        return chunk;
    }

    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }

    public void populate(final IChunkProvider par1IChunkProvider, final int par2, final int par3) {
        final int k = par2 * 16;
        final int l = par3 * 16;
        this.random.setSeed(this.worldObj.getSeed());
        final long i1 = this.random.nextLong() / 2L * 2L + 1L;
        final long j1 = this.random.nextLong() / 2L * 2L + 1L;
        this.random.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
    }

    public boolean saveChunks(final boolean par1, final IProgressUpdate par2IProgressUpdate) {
        return true;
    }

    public void saveExtraData() {}

    public boolean unloadQueuedChunks() {
        return false;
    }

    public boolean canSave() {
        return true;
    }

    public String makeString() {
        return "DangerDimension";
    }

    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3,
        final int par4) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        return biomegenbase.getSpawnableList(par1EnumCreatureType);
    }

    public ChunkPosition func_147416_a(final World p_147416_1_, final String p_147416_2_, final int p_147416_3_,
        final int p_147416_4_, final int p_147416_5_) {
        return null;
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(final int par1, final int par2) {}

    public void addScragglyTrees(final World world, final int chunkX, final int chunkZ, final Chunk chunk) {
        int howmany = 1 + this.random.nextInt(10);
        if (OreSpawnMain.LessLag == 1) {
            howmany /= 2;
        }
        if (OreSpawnMain.LessLag == 2) {
            howmany /= 4;
        }
        if (howmany == 0) {
            return;
        }
        for (int i = 0; i < howmany; ++i) {
            final int posX = 2 + chunkX + this.random.nextInt(12);
            final int posZ = 2 + chunkZ + this.random.nextInt(12);
            for (int posY = 20; posY > 2; --posY) {
                if (OreSpawnMain.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == Blocks.grass) {
                    this.ScragglyTreeWithBranches(world, posX, posY, posZ, chunk);
                    break;
                }
            }
        }
    }

    public void makeScragglyBranch(final World world, int x, int y, int z, final int len, final int biasx,
        final int biasz, final Chunk chunk) {
        for (int k = 0; k < len; ++k) {
            int ix = this.random.nextInt(2) - this.random.nextInt(2) + biasx;
            int iz = this.random.nextInt(2) - this.random.nextInt(2) + biasz;
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
            final int iy = (this.random.nextInt(3) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, Blocks.log, 0);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (this.random.nextInt(2) == 1) {
                        bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
                        if (bid == Blocks.air) {
                            OreSpawnMain
                                .setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0);
                        }
                    }
                }
            }
            if (this.random.nextInt(2) == 1) {
                bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0);
                }
            }
        }
    }

    public void ScragglyTreeWithBranches(final World world, int x, int y, int z, final Chunk chunk) {
        final int i = 1 + this.random.nextInt(3);
        final int j = i + this.random.nextInt(12);
        for (int k = 0; k < i; ++k) {
            final Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + k, z);
            if (k >= 1 && bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
                return;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, Blocks.log, 0);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            final int ix = this.random.nextInt(2) - this.random.nextInt(2);
            final int iz = this.random.nextInt(2) - this.random.nextInt(2);
            final int iy = (this.random.nextInt(4) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.air && bid != Blocks.log && bid != OreSpawnMain.MyAppleLeaves) {
                break;
            }
            OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y, z, Blocks.log, 0);
            if (this.random.nextInt(4) == 1) {
                this.makeScragglyBranch(
                    world,
                    x,
                    y,
                    z,
                    this.random.nextInt(1 + j - k),
                    this.random.nextInt(2) - this.random.nextInt(2),
                    this.random.nextInt(2) - this.random.nextInt(2),
                    chunk);
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (this.random.nextInt(2) == 1) {
                        bid = OreSpawnMain.getBlockIDInChunk(chunk, x + m, y, z + n);
                        if (bid == Blocks.air) {
                            OreSpawnMain
                                .setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, OreSpawnMain.MyAppleLeaves, 0);
                        }
                    }
                }
            }
            if (this.random.nextInt(2) == 1) {
                bid = OreSpawnMain.getBlockIDInChunk(chunk, x, y + 1, z);
                if (bid == Blocks.air) {
                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, OreSpawnMain.MyAppleLeaves, 0);
                }
            }
        }
    }
}
