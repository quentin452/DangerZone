
package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dungeons.CrystalMaze;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.List;
import java.util.Random;

public class CrystalChunkProvider implements IChunkProvider {

    private Random rand;
    private NoiseGeneratorOctaves field_147431_j;
    private NoiseGeneratorOctaves field_147432_k;
    private NoiseGeneratorOctaves field_147429_l;
    private NoiseGeneratorPerlin field_147430_m;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private WorldType field_147435_p;
    private final double[] field_147434_q;
    private final float[] parabolicField;
    private double[] stoneNoise;
    private BiomeGenBase[] biomesForGeneration;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j;

    public CrystalChunkProvider(final World par1World, final long par2, final boolean par4) {
        this.stoneNoise = new double[256];
        this.field_73219_j = new int[32][32];
        this.worldObj = par1World;
        this.mapFeaturesEnabled = par4;
        this.field_147435_p = par1World.getWorldInfo()
            .getTerrainType();
        this.rand = new Random(par2);
        this.field_147431_j = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147432_k = new NoiseGeneratorOctaves(this.rand, 16);
        this.field_147429_l = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147430_m = new NoiseGeneratorPerlin(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
        this.field_147434_q = new double[825];
        this.parabolicField = new float[25];
        for (int j = -2; j <= 2; ++j) {
            for (int k = -2; k <= 2; ++k) {
                final float f = 10.0f / MathHelper.sqrt_float(j * j + k * k + 0.2f);
                this.parabolicField[j + 2 + (k + 2) * 5] = f;
            }
        }
        NoiseGenerator[] noiseGens = { (NoiseGenerator) this.field_147431_j, (NoiseGenerator) this.field_147432_k,
            (NoiseGenerator) this.field_147429_l, (NoiseGenerator) this.field_147430_m, (NoiseGenerator) this.noiseGen5,
            (NoiseGenerator) this.noiseGen6, (NoiseGenerator) this.mobSpawnerNoise };
        noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
        this.field_147431_j = (NoiseGeneratorOctaves) noiseGens[0];
        this.field_147432_k = (NoiseGeneratorOctaves) noiseGens[1];
        this.field_147429_l = (NoiseGeneratorOctaves) noiseGens[2];
        this.field_147430_m = (NoiseGeneratorPerlin) noiseGens[3];
        this.noiseGen5 = (NoiseGeneratorOctaves) noiseGens[4];
        this.noiseGen6 = (NoiseGeneratorOctaves) noiseGens[5];
        this.mobSpawnerNoise = (NoiseGeneratorOctaves) noiseGens[6];
    }

    public void func_147424_a(final int p_147424_1_, final int p_147424_2_, final Block[] p_147424_3_) {
        final byte b0 = 63;
        this.biomesForGeneration = this.worldObj.getWorldChunkManager()
            .getBiomesForGeneration(this.biomesForGeneration, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10);
        this.func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4);
        for (int k = 0; k < 4; ++k) {
            final int l = k * 5;
            final int i1 = (k + 1) * 5;
            for (int j1 = 0; j1 < 4; ++j1) {
                final int k2 = (l + j1) * 33;
                final int l2 = (l + j1 + 1) * 33;
                final int i2 = (i1 + j1) * 33;
                final int j2 = (i1 + j1 + 1) * 33;
                for (int k3 = 0; k3 < 32; ++k3) {
                    final double d0 = 0.125;
                    double d2 = this.field_147434_q[k2 + k3];
                    double d3 = this.field_147434_q[l2 + k3];
                    double d4 = this.field_147434_q[i2 + k3];
                    double d5 = this.field_147434_q[j2 + k3];
                    final double d6 = (this.field_147434_q[k2 + k3 + 1] - d2) * d0;
                    final double d7 = (this.field_147434_q[l2 + k3 + 1] - d3) * d0;
                    final double d8 = (this.field_147434_q[i2 + k3 + 1] - d4) * d0;
                    final double d9 = (this.field_147434_q[j2 + k3 + 1] - d5) * d0;
                    for (int l3 = 0; l3 < 8; ++l3) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i3 = 0; i3 < 4; ++i3) {
                            int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k3 * 8 + l3;
                            final short short1 = 256;
                            j3 -= short1;
                            final double d15 = 0.25;
                            final double d16 = (d12 - d11) * d15;
                            double d17 = d11 - d16;
                            for (int k4 = 0; k4 < 4; ++k4) {
                                if ((d17 += d16) > 0.0) {
                                    p_147424_3_[j3 += short1] = BlockInitDangerZone.CrystalStone;
                                } else if (k3 * 8 + l3 < b0) {
                                    p_147424_3_[j3 += short1] = Blocks.water;
                                } else {
                                    p_147424_3_[j3 += short1] = null;
                                }
                            }
                            d11 += d13;
                            d12 += d14;
                        }
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                        d5 += d9;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(final int p_147422_1_, final int p_147422_2_, final Block[] p_147422_3_,
        final byte[] p_147422_4_, final BiomeGenBase[] p_147422_5_) {
        final double d0 = 0.03125;
        this.stoneNoise = this.field_147430_m
            .func_151599_a(this.stoneNoise, (p_147422_1_ * 16), (p_147422_2_ * 16), 16, 16, d0 * 2.0, d0 * 2.0, 1.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                this.MygenTerrainBlocks(
                    this.worldObj,
                    this.rand,
                    p_147422_3_,
                    p_147422_4_,
                    p_147422_1_ * 16 + k,
                    p_147422_2_ * 16 + l,
                    this.stoneNoise[l + k * 16]);
            }
        }
    }

    private void MygenTerrainBlocks(final World p_150573_1_, final Random p_150573_2_, final Block[] p_150573_3_,
        final byte[] p_150573_4_, final int p_150573_5_, final int p_150573_6_, final double p_150573_7_) {
        this.MygenBiomeTerrain(
            p_150573_1_,
            p_150573_2_,
            p_150573_3_,
            p_150573_4_,
            p_150573_5_,
            p_150573_6_,
            p_150573_7_);
    }

    private final void MygenBiomeTerrain(final World p_150560_1_, final Random p_150560_2_, final Block[] p_150560_3_,
        final byte[] p_150560_4_, final int p_150560_5_, final int p_150560_6_, final double p_150560_7_) {
        final boolean flag = true;
        Block block = BlockInitDangerZone.CrystalGrass;
        byte b0 = 0;
        Block block2 = BlockInitDangerZone.CrystalStone;
        int k = -1;
        final int l = (int) (p_150560_7_ / 3.0 + 3.0 + p_150560_2_.nextDouble() * 0.25);
        final int i1 = p_150560_5_ & 0xF;
        final int j1 = p_150560_6_ & 0xF;
        final int k2 = p_150560_3_.length / 256;
        for (int l2 = 255; l2 >= 0; --l2) {
            final int i2 = (j1 * 16 + i1) * k2 + l2;
            if (l2 <= 0 + p_150560_2_.nextInt(5)) {
                p_150560_3_[i2] = Blocks.bedrock;
            } else {
                final Block block3 = p_150560_3_[i2];
                if (block3 != null && block3.getMaterial() != Material.air) {
                    if (block3 == BlockInitDangerZone.CrystalStone) {
                        if (k == -1) {
                            if (l <= 0) {
                                block = null;
                                b0 = 0;
                                block2 = BlockInitDangerZone.CrystalStone;
                            } else if (l2 >= 59 && l2 <= 64) {
                                block = BlockInitDangerZone.CrystalGrass;
                                b0 = 0;
                                block2 = BlockInitDangerZone.CrystalStone;
                            }
                            if (l2 < 63 && (block == null || block.getMaterial() == Material.air)) {
                                block = Blocks.water;
                                b0 = 0;
                            }
                            k = l;
                            if (l2 >= 62) {
                                p_150560_3_[i2] = block;
                                p_150560_4_[i2] = b0;
                            } else {
                                p_150560_3_[i2] = block2;
                            }
                        } else if (k > 0) {
                            --k;
                            p_150560_3_[i2] = block2;
                        }
                    }
                } else {
                    k = -1;
                }
            }
        }
    }

    public Chunk loadChunk(final int par1, final int par2) {
        return this.provideChunk(par1, par2);
    }

    public Chunk provideChunk(final int par1, final int par2) {
        this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
        final Block[] ablock = new Block[65536];
        final byte[] abyte = new byte[65536];
        this.func_147424_a(par1, par2, ablock);
        this.replaceBlocksForBiome(
            par1,
            par2,
            ablock,
            abyte,
            this.biomesForGeneration = this.worldObj.getWorldChunkManager()
                .loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16));
        final Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        final CrystalMaze cm = new CrystalMaze();
        cm.buildCrystalMaze(this.worldObj, par1 * 16, 25, par2 * 16, chunk);
        this.generateCrystals(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addCrystalTrees(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.generateCrystalOres(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addCrystalFlowers(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addRice(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        this.addQuinoa(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
        chunk.generateSkylightMap();
        return chunk;
    }

    private void func_147423_a(final int p_147423_1_, final int p_147423_2_, final int p_147423_3_) {
        final double d0 = 684.412;
        final double d2 = 684.412;
        final double d3 = 512.0;
        final double d4 = 512.0;
        this.field_147426_g = this.noiseGen6
            .generateNoiseOctaves(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0, 200.0, 0.5);
        this.field_147427_d = this.field_147429_l.generateNoiseOctaves(
            this.field_147427_d,
            p_147423_1_,
            p_147423_2_,
            p_147423_3_,
            5,
            33,
            5,
            8.555150000000001,
            4.277575000000001,
            8.555150000000001);
        this.field_147428_e = this.field_147431_j.generateNoiseOctaves(
            this.field_147428_e,
            p_147423_1_,
            p_147423_2_,
            p_147423_3_,
            5,
            33,
            5,
            684.412,
            684.412,
            684.412);
        this.field_147425_f = this.field_147432_k.generateNoiseOctaves(
            this.field_147425_f,
            p_147423_1_,
            p_147423_2_,
            p_147423_3_,
            5,
            33,
            5,
            684.412,
            684.412,
            684.412);
        final boolean flag1 = false;
        final boolean flag2 = false;
        int l = 0;
        int i1 = 0;
        final double d5 = 8.5;
        for (int j1 = 0; j1 < 5; ++j1) {
            for (int k1 = 0; k1 < 5; ++k1) {
                float f = 0.0f;
                float f2 = 0.0f;
                float f3 = 0.0f;
                final byte b0 = 2;
                final BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
                for (int l2 = -b0; l2 <= b0; ++l2) {
                    for (int i2 = -b0; i2 <= b0; ++i2) {
                        final BiomeGenBase biomegenbase2 = this.biomesForGeneration[j1 + l2 + 2 + (k1 + i2 + 2) * 10];
                        float f4 = biomegenbase2.rootHeight;
                        float f5 = biomegenbase2.heightVariation;
                        if (this.field_147435_p == WorldType.AMPLIFIED && f4 > 0.0f) {
                            f4 = 1.0f + f4 * 2.0f;
                            f5 = 1.0f + f5 * 4.0f;
                        }
                        float f6 = this.parabolicField[l2 + 2 + (i2 + 2) * 5] / (f4 + 2.0f);
                        if (biomegenbase2.rootHeight > biomegenbase.rootHeight) {
                            f6 /= 2.0f;
                        }
                        f += f5 * f6;
                        f2 += f4 * f6;
                        f3 += f6;
                    }
                }
                f /= f3;
                f2 /= f3;
                f = f * 0.9f + 0.1f;
                f2 = (f2 * 4.0f - 1.0f) / 8.0f;
                double d6 = this.field_147426_g[i1] / 8000.0;
                if (d6 < 0.0) {
                    d6 = -d6 * 0.3;
                }
                d6 = d6 * 3.0 - 2.0;
                if (d6 < 0.0) {
                    d6 /= 2.0;
                    if (d6 < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                } else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 8.0;
                }
                ++i1;
                double d7 = f2;
                final double d8 = f;
                d7 += d6 * 0.2;
                d7 = d7 * 8.5 / 8.0;
                final double d9 = 8.5 + d7 * 4.0;
                for (int j2 = 0; j2 < 33; ++j2) {
                    double d10 = (j2 - d9) * 12.0 * 128.0 / 256.0 / d8;
                    if (d10 < 0.0) {
                        d10 *= 4.0;
                    }
                    final double d11 = this.field_147428_e[l] / 512.0;
                    final double d12 = this.field_147425_f[l] / 512.0;
                    final double d13 = (this.field_147427_d[l] / 10.0 + 1.0) / 2.0;
                    double d14 = MathHelper.denormalizeClamp(d11, d12, d13) - d10;
                    if (j2 > 29) {
                        final double d15 = (j2 - 29) / 3.0f;
                        d14 = d14 * (1.0 - d15) + -10.0 * d15;
                    }
                    this.field_147434_q[l] = d14;
                    ++l;
                }
            }
        }
    }

    public boolean chunkExists(final int par1, final int par2) {
        return true;
    }

    public void populate(final IChunkProvider par1IChunkProvider, final int par2, final int par3) {
        BlockFalling.fallInstantly = true;
        final int k = par2 * 16;
        final int l = par3 * 16;
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        final long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
        final boolean flag = false;
        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        BlockFalling.fallInstantly = false;
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
        return "CrystalDimension";
    }

    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3,
        final int par4) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        return biomegenbase.getSpawnableList(par1EnumCreatureType);
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(final int par1, final int par2) {}

    public void generateCrystals(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        this.addPinkTourmaline(world, random, chunkX, chunkZ, chunk);
        this.addTigersEye(world, random, chunkX, chunkZ, chunk);
    }

    public void addPinkTourmaline(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if (random.nextInt(30) != 1) {
            return;
        }
        final int randPosX = 3 + chunkX + random.nextInt(10);
        final int randPosY = 30 + random.nextInt(5);
        final int randPosZ = 3 + chunkZ + random.nextInt(10);
        for (int patchy = 1 + random.nextInt(10), i = 0; i < patchy; ++i) {
            final float dx = random.nextFloat() - random.nextFloat();
            final float dz = random.nextFloat() - random.nextFloat();
            final float dy = 0.5f + random.nextFloat() / 2.0f;
            final int width = random.nextInt(2);
            final int length = 1 + width * 3 + random.nextInt(15);
            float rx = (float) randPosX;
            float ry = (float) randPosY;
            float rz = (float) randPosZ;
            for (int iy = 0; iy <= length; ++iy) {
                for (int ix = 0; ix <= width; ++ix) {
                    for (int iz = 0; iz <= width; ++iz) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            (int) (rx + ix),
                            (int) ry,
                            (int) (rz + iz),
                            BlockInitDangerZone.OreCrystalCrystal,
                            0);
                    }
                }
                ry += dy;
                rx += dx;
                rz += dz;
            }
        }
    }

    public void addTigersEye(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if (random.nextInt(30) != 1) {
            return;
        }
        final int randPosX = 3 + chunkX + random.nextInt(10);
        final int randPosY = 5 + random.nextInt(5);
        final int randPosZ = 3 + chunkZ + random.nextInt(10);
        for (int patchy = 1 + random.nextInt(5), i = 0; i < patchy; ++i) {
            final float dx = random.nextFloat() - random.nextFloat();
            final float dz = random.nextFloat() - random.nextFloat();
            final float dy = 0.5f + random.nextFloat() / 2.0f;
            final int width = 0;
            final int length = width * 3 + random.nextInt(6);
            float rx = (float) randPosX;
            float ry = (float) randPosY;
            float rz = (float) randPosZ;
            for (int iy = 0; iy <= length; ++iy) {
                for (int ix = 0; ix <= width; ++ix) {
                    for (int iz = 0; iz <= width; ++iz) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            (int) (rx + ix),
                            (int) ry,
                            (int) (rz + iz),
                            BlockInitDangerZone.TigersEyeBlock,
                            0);
                    }
                }
                ry += dy;
                rx += dx;
                rz += dz;
            }
        }
    }

    public void addCrystalTrees(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if (random.nextInt(5) != 0) {
            return;
        }
        int howmany = 0;
        final int what = random.nextInt(5);
        howmany = random.nextInt(8);
        if (what != 0) {
            howmany *= 2;
        }
        for (int i = 0; i < howmany; ++i) {
            final int posX = 4 + chunkX + random.nextInt(8);
            final int posZ = 4 + chunkZ + random.nextInt(8);
            int posY = 128;
            while (posY > 40) {
                if (DangerZone.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air
                    && DangerZone.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == BlockInitDangerZone.CrystalGrass) {
                    if (what == 0) {
                        this.TallCrystalTree(world, posX, posY, posZ, chunk);
                        break;
                    }
                    this.ScragglyCrystalTreeWithBranches(world, posX, posY, posZ, chunk);
                    break;
                } else {
                    --posY;
                }
            }
        }
    }

    public void makeScragglyCrystalBranch(final World world, int x, int y, int z, final int len, final int biasx,
        final int biasz, final Chunk chunk) {
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
            Block bid = DangerZone.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.air && bid != BlockInitDangerZone.BlockCrystalTreeLog
                && bid != BlockInitDangerZone.BlockCrystalLeaves2) {
                return;
            }
            DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y, z, BlockInitDangerZone.BlockCrystalTreeLog, 0);
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = DangerZone.getBlockIDInChunk(chunk, x + m, y, z + n);
                        if (bid == Blocks.air) {
                            DangerZone
                                .setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, BlockInitDangerZone.BlockCrystalLeaves2, 0);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = DangerZone.getBlockIDInChunk(chunk, x, y + 1, z);
                if (bid == Blocks.air) {
                    DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, BlockInitDangerZone.BlockCrystalLeaves2, 0);
                }
            }
        }
    }

    public void ScragglyCrystalTreeWithBranches(final World world, int x, int y, int z, final Chunk chunk) {
        final int i = 1 + world.rand.nextInt(2);
        final int j = i + world.rand.nextInt(8);
        for (int k = 0; k < i; ++k) {
            final Block bid = DangerZone.getBlockIDInChunk(chunk, x, y + k, z);
            if (k >= 1 && bid != Blocks.air
                && bid != BlockInitDangerZone.BlockCrystalTreeLog
                && bid != BlockInitDangerZone.BlockCrystalLeaves2) {
                return;
            }
            DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, BlockInitDangerZone.BlockCrystalTreeLog, 0);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            final int ix = world.rand.nextInt(2) - world.rand.nextInt(2);
            final int iz = world.rand.nextInt(2) - world.rand.nextInt(2);
            final int iy = (world.rand.nextInt(4) > 0) ? 1 : 0;
            x += ix;
            z += iz;
            y += iy;
            Block bid = DangerZone.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.air && bid != BlockInitDangerZone.BlockCrystalTreeLog
                && bid != BlockInitDangerZone.BlockCrystalLeaves2) {
                break;
            }
            DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y, z, BlockInitDangerZone.BlockCrystalTreeLog, 0);
            if (world.rand.nextInt(4) == 1) {
                this.makeScragglyCrystalBranch(
                    world,
                    x,
                    y,
                    z,
                    world.rand.nextInt(1 + j - k),
                    world.rand.nextInt(2) - world.rand.nextInt(2),
                    world.rand.nextInt(2) - world.rand.nextInt(2),
                    chunk);
            }
            for (int m = -1; m < 2; ++m) {
                for (int n = -1; n < 2; ++n) {
                    if (world.rand.nextInt(2) == 1) {
                        bid = DangerZone.getBlockIDInChunk(chunk, x + m, y, z + n);
                        if (bid == Blocks.air) {
                            DangerZone
                                .setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, BlockInitDangerZone.BlockCrystalLeaves2, 0);
                        }
                    }
                }
            }
            if (world.rand.nextInt(2) == 1) {
                bid = DangerZone.getBlockIDInChunk(chunk, x, y + 1, z);
                if (bid == Blocks.air) {
                    DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y + 1, z, BlockInitDangerZone.BlockCrystalLeaves2, 0);
                }
            }
        }
    }

    public void TallCrystalTree(final World world, final int x, int y, final int z, final Chunk chunk) {
        int i = 10 + world.rand.nextInt(12);
        final int j = i + world.rand.nextInt(18);
        for (int k = 0; k < i; ++k) {
            final Block bid = DangerZone.getBlockIDInChunk(chunk, x, y + k, z);
            if (k >= 1 && bid != Blocks.air
                && bid != BlockInitDangerZone.BlockCrystalTreeLog
                && bid != BlockInitDangerZone.BlockCrystalLeaves) {
                return;
            }
            DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y + k, z, BlockInitDangerZone.BlockCrystalTreeLog, 0);
        }
        y += i - 1;
        for (int k = i; k < j; ++k) {
            ++y;
            Block bid = DangerZone.getBlockIDInChunk(chunk, x, y, z);
            if (bid != Blocks.air && bid != BlockInitDangerZone.BlockCrystalTreeLog
                && bid != BlockInitDangerZone.BlockCrystalLeaves) {
                break;
            }
            DangerZone.setBlockIDWithMetadataInChunk(chunk, x, y, z, BlockInitDangerZone.BlockCrystalTreeLog, 0);
            if (k % 4 == 0) {
                for (int m = -1; m < 2; ++m) {
                    for (int n = -1; n < 2; ++n) {
                        if (world.rand.nextInt(2) == 1) {
                            bid = DangerZone.getBlockIDInChunk(chunk, x + m, y, z + n);
                            if (bid == Blocks.air) {
                                DangerZone.setBlockIDWithMetadataInChunk(
                                    chunk,
                                    x + m,
                                    y,
                                    z + n,
                                    BlockInitDangerZone.BlockCrystalLeaves,
                                    0);
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
                    final Block bid = DangerZone.getBlockIDInChunk(chunk, x + m, y, z + n);
                    if (bid == Blocks.air) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            x + m,
                            y,
                            z + n,
                            BlockInitDangerZone.BlockCrystalTreeLog,
                            0);
                    }
                }
            }
        }
        for (int m = -3; m < 4; ++m) {
            for (int n = -3; n < 4; ++n) {
                final Block bid = DangerZone.getBlockIDInChunk(chunk, x + m, y, z + n);
                if (bid == Blocks.air) {
                    DangerZone.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, BlockInitDangerZone.BlockCrystalLeaves, 0);
                }
            }
        }
        ++y;
        for (int m = -1; m < 2; ++m) {
            for (int n = -1; n < 2; ++n) {
                final Block bid = DangerZone.getBlockIDInChunk(chunk, x + m, y, z + n);
                if (bid == Blocks.air) {
                    DangerZone.setBlockIDWithMetadataInChunk(chunk, x + m, y, z + n, BlockInitDangerZone.BlockCrystalLeaves, 0);
                }
            }
        }
    }

    public void generateCrystalOres(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        int patchy = 25 + random.nextInt(30);
        if (random.nextInt(20) == 0) {
            patchy += 30;
        }
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 2 + chunkX + random.nextInt(12);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 2 + chunkZ + random.nextInt(12);
            if (randPosY > 45) {
                final int j = random.nextInt(11);
                Block b = Blocks.air;
                switch (j) {
                    case 0: {
                        b = BlockInitDangerZone.MyUrchinSpawnBlock;
                        break;
                    }
                    case 1: {
                        b = BlockInitDangerZone.MyFlounderSpawnBlock;
                        break;
                    }
                    case 2: {
                        b = BlockInitDangerZone.MySkateSpawnBlock;
                        break;
                    }
                    case 3: {
                        b = BlockInitDangerZone.MyRotatorSpawnBlock;
                        break;
                    }
                    case 4: {
                        b = BlockInitDangerZone.MyPeacockSpawnBlock;
                        break;
                    }
                    case 5: {
                        b = BlockInitDangerZone.MyFairySpawnBlock;
                        break;
                    }
                    case 6: {
                        b = BlockInitDangerZone.MyDungeonBeastSpawnBlock;
                        break;
                    }
                    case 7: {
                        b = BlockInitDangerZone.MyVortexSpawnBlock;
                        break;
                    }
                    case 8: {
                        b = BlockInitDangerZone.MyRatSpawnBlock;
                        break;
                    }
                    case 9: {
                        b = BlockInitDangerZone.MyWhaleSpawnBlock;
                        break;
                    }
                    case 10: {
                        b = BlockInitDangerZone.MyIrukandjiSpawnBlock;
                        break;
                    }
                }
                this.generateOre(world, random, randPosX, randPosY, randPosZ, chunk, b, 4, BlockInitDangerZone.CrystalStone);
            }
        }
        patchy = 3 + random.nextInt(8);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 2 + chunkX + random.nextInt(12);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 2 + chunkZ + random.nextInt(12);
            this.generateOre(
                world,
                random,
                randPosX,
                randPosY,
                randPosZ,
                chunk,
                BlockInitDangerZone.CrystalCoal,
                6,
                BlockInitDangerZone.CrystalStone);
        }
        patchy = 15 + random.nextInt(20);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 2 + chunkX + random.nextInt(12);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 2 + chunkZ + random.nextInt(12);
            if (randPosY < 25) {
                this.generateOre(
                    world,
                    random,
                    randPosX,
                    randPosY,
                    randPosZ,
                    chunk,
                    BlockInitDangerZone.CrystalRat,
                    6,
                    BlockInitDangerZone.CrystalStone);
            }
        }
        patchy = 12 + random.nextInt(20);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 2 + chunkX + random.nextInt(12);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 2 + chunkZ + random.nextInt(12);
            if (randPosY < 25) {
                this.generateOre(
                    world,
                    random,
                    randPosX,
                    randPosY,
                    randPosZ,
                    chunk,
                    BlockInitDangerZone.CrystalFairy,
                    6,
                    BlockInitDangerZone.CrystalStone);
            }
        }
    }

    public boolean generateOre(final World par1World, final Random par2Random, final int par3, final int par4,
        final int par5, final Chunk chunk, final Block newbid, final int numberOfBlocks, final Block oldbid) {
        final float f = par2Random.nextFloat() * 3.1415927f;
        final double d0 = par3 + 8 + MathHelper.sin(f) * numberOfBlocks / 8.0f;
        final double d2 = par3 + 8 - MathHelper.sin(f) * numberOfBlocks / 8.0f;
        final double d3 = par5 + 8 + MathHelper.cos(f) * numberOfBlocks / 8.0f;
        final double d4 = par5 + 8 - MathHelper.cos(f) * numberOfBlocks / 8.0f;
        final double d5 = par4 + par2Random.nextInt(3) - 2;
        final double d6 = par4 + par2Random.nextInt(3) - 2;
        for (int l = 0; l <= numberOfBlocks; ++l) {
            final double d7 = d0 + (d2 - d0) * l / numberOfBlocks;
            final double d8 = d5 + (d6 - d5) * l / numberOfBlocks;
            final double d9 = d3 + (d4 - d3) * l / numberOfBlocks;
            final double d10 = par2Random.nextDouble() * numberOfBlocks / 16.0;
            final double d11 = (MathHelper.sin(l * 3.1415927f / numberOfBlocks) + 1.0f) * d10 + 1.0;
            final double d12 = (MathHelper.sin(l * 3.1415927f / numberOfBlocks) + 1.0f) * d10 + 1.0;
            final int i1 = MathHelper.floor_double(d7 - d11 / 2.0);
            final int j1 = MathHelper.floor_double(d8 - d12 / 2.0);
            final int k1 = MathHelper.floor_double(d9 - d11 / 2.0);
            final int l2 = MathHelper.floor_double(d7 + d11 / 2.0);
            final int i2 = MathHelper.floor_double(d8 + d12 / 2.0);
            final int j2 = MathHelper.floor_double(d9 + d11 / 2.0);
            for (int k2 = i1; k2 <= l2; ++k2) {
                final double d13 = (k2 + 0.5 - d7) / (d11 / 2.0);
                if (d13 * d13 < 1.0) {
                    for (int l3 = j1; l3 <= i2; ++l3) {
                        final double d14 = (l3 + 0.5 - d8) / (d12 / 2.0);
                        if (d13 * d13 + d14 * d14 < 1.0) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                final double d15 = (i3 + 0.5 - d9) / (d11 / 2.0);
                                final Block bid = DangerZone.getBlockIDInChunk(chunk, k2, l3, i3);
                                if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0 && bid == oldbid) {
                                    DangerZone.setBlockIDWithMetadataInChunk(chunk, k2, l3, i3, newbid, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public void addRice(final World world, final Random random, final int chunkX, final int chunkZ, final Chunk chunk) {
        if (random.nextInt(10) != 0) {
            return;
        }
        for (int i = 0; i < 5; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 128; posY > 40; --posY) {
                if (DangerZone.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air
                    && DangerZone.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == BlockInitDangerZone.CrystalGrass) {
                    DangerZone.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, BlockInitDangerZone.BlockRice, 0);
                    break;
                }
            }
        }
    }

    public void addQuinoa(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if (random.nextInt(20) != 0) {
            return;
        }
        for (int i = 0; i < 5; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 128; posY > 40; --posY) {
                if (DangerZone.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air
                    && DangerZone.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == BlockInitDangerZone.CrystalGrass) {
                    DangerZone.setBlockIDWithMetadataInChunk(chunk, posX, posY, posZ, BlockInitDangerZone.BlockQuinoa1, 0);
                    break;
                }
            }
        }
    }

    public void addCrystalFlowers(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if (random.nextInt(3) != 0) {
            return;
        }
        int howmany = 0;
        howmany = 1 + random.nextInt(13);
        final int what = random.nextInt(4);
        for (int i = 0; i < howmany; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            int posY = 128;
            while (posY > 40) {
                if (DangerZone.getBlockIDInChunk(chunk, posX, posY, posZ) == Blocks.air
                    && DangerZone.getBlockIDInChunk(chunk, posX, posY - 1, posZ) == BlockInitDangerZone.CrystalGrass) {
                    if (what == 0) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            posX,
                            posY,
                            posZ,
                            BlockInitDangerZone.CrystalFlowerRedBlock,
                            0);
                        break;
                    }
                    if (what == 1) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            posX,
                            posY,
                            posZ,
                            BlockInitDangerZone.CrystalFlowerGreenBlock,
                            0);
                        break;
                    }
                    if (what == 2) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            posX,
                            posY,
                            posZ,
                            BlockInitDangerZone.CrystalFlowerBlueBlock,
                            0);
                        break;
                    }
                    if (what == 3) {
                        DangerZone.setBlockIDWithMetadataInChunk(
                            chunk,
                            posX,
                            posY,
                            posZ,
                            BlockInitDangerZone.CrystalFlowerYellowBlock,
                            0);
                        break;
                    }
                    break;
                } else {
                    --posY;
                }
            }
        }
    }

    public ChunkPosition func_147416_a(final World var1, final String var2, final int var3, final int var4,
        final int var5) {
        return null;
    }
}
