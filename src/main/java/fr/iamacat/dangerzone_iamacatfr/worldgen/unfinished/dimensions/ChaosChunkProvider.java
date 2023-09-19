package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChaosChunkProvider implements IChunkProvider {

    private final Random hellRNG;
    private NoiseGeneratorOctaves netherNoiseGen1;
    private NoiseGeneratorOctaves netherNoiseGen2;
    private NoiseGeneratorOctaves netherNoiseGen3;
    private NoiseGeneratorOctaves slowsandGravelNoiseGen;
    private NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
    public NoiseGeneratorOctaves netherNoiseGen6;
    public NoiseGeneratorOctaves netherNoiseGen7;
    private final World worldObj;
    private double[] noiseField;
    private double[] slowsandNoise;
    private double[] gravelNoise;
    private double[] netherrackExclusivityNoise;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;

    public ChaosChunkProvider(final World p_i2005_1_, final long p_i2005_2_) {
        this.slowsandNoise = new double[256];
        this.gravelNoise = new double[256];
        this.netherrackExclusivityNoise = new double[256];
        this.worldObj = p_i2005_1_;
        this.hellRNG = new Random(p_i2005_2_);
        this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
        this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
        this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
        this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
        this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
        NoiseGenerator[] noiseGens = {this.netherNoiseGen1, this.netherNoiseGen2,
            this.netherNoiseGen3, this.slowsandGravelNoiseGen,
            this.netherrackExculsivityNoiseGen, this.netherNoiseGen6,
            this.netherNoiseGen7};
        noiseGens = TerrainGen.getModdedNoiseGenerators(p_i2005_1_, this.hellRNG, noiseGens);
        this.netherNoiseGen1 = (NoiseGeneratorOctaves) noiseGens[0];
        this.netherNoiseGen2 = (NoiseGeneratorOctaves) noiseGens[1];
        this.netherNoiseGen3 = (NoiseGeneratorOctaves) noiseGens[2];
        this.slowsandGravelNoiseGen = (NoiseGeneratorOctaves) noiseGens[3];
        this.netherrackExculsivityNoiseGen = (NoiseGeneratorOctaves) noiseGens[4];
        this.netherNoiseGen6 = (NoiseGeneratorOctaves) noiseGens[5];
        this.netherNoiseGen7 = (NoiseGeneratorOctaves) noiseGens[6];
    }

    public void func_147419_a(final int p_147419_1_, final int p_147419_2_, final Block[] p_147419_3_) {
        final byte b0 = 4;
        final int k = b0 + 1;
        final byte b3 = 17;
        final int l = b0 + 1;
        Block block;
        this.noiseField = this.initializeNoiseField(this.noiseField, p_147419_1_ * b0, p_147419_2_ * b0);
        for (int i1 = 0; i1 < b0; ++i1) {
            for (int j1 = 0; j1 < b0; ++j1) {
                for (int k2 = 0; k2 < 16; ++k2) {
                    final double d0 = 0.125;
                    double d2 = this.noiseField[((i1) * l + j1) * b3 + k2];
                    double d3 = this.noiseField[((i1) * l + j1 + 1) * b3 + k2];
                    double d4 = this.noiseField[((i1 + 1) * l + j1) * b3 + k2];
                    double d5 = this.noiseField[((i1 + 1) * l + j1 + 1) * b3 + k2];
                    final double d6 = (this.noiseField[((i1) * l + j1) * b3 + k2 + 1] - d2) * d0;
                    final double d7 = (this.noiseField[((i1) * l + j1 + 1) * b3 + k2 + 1] - d3) * d0;
                    final double d8 = (this.noiseField[((i1 + 1) * l + j1) * b3 + k2 + 1] - d4) * d0;
                    final double d9 = (this.noiseField[((i1 + 1) * l + j1 + 1) * b3 + k2 + 1] - d5) * d0;
                    for (int l2 = 0; l2 < 8; ++l2) {
                        final double d10 = 0.25;
                        double d11 = d2;
                        double d12 = d3;
                        final double d13 = (d4 - d2) * d10;
                        final double d14 = (d5 - d3) * d10;
                        for (int i2 = 0; i2 < 4; ++i2) {
                            int j2 = i2 + i1 * 4 << 11 | j1 * 4 << 7 | k2 * 8 + l2;
                            final short short1 = 128;
                            final double d15 = 0.25;
                            double d16 = d11;
                            final double d17 = (d12 - d11) * d15;
                            for (int k3 = 0; k3 < 4; ++k3) {
                                block = Blocks.stone;
                                if (d16 > 0.0) {
                                    block = null;
                                }
                                p_147419_3_[j2] = block;
                                j2 += short1;
                                d16 += d17;
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

    public void replaceBiomeBlocks(final int p_147418_1_, final int p_147418_2_, final Block[] p_147418_3_,
                                   final byte[] meta, final BiomeGenBase[] biomes) {
        final byte b0 = 64;
        final double d0 = 0.03125;
        this.slowsandNoise = this.slowsandGravelNoiseGen
            .generateNoiseOctaves(this.slowsandNoise, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d0, d0, 1.0);
        this.gravelNoise = this.slowsandGravelNoiseGen
            .generateNoiseOctaves(this.gravelNoise, p_147418_1_ * 16, 109, p_147418_2_ * 16, 16, 1, 16, d0, 1.0, d0);
        this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.generateNoiseOctaves(
            this.netherrackExclusivityNoise,
            p_147418_1_ * 16,
            p_147418_2_ * 16,
            0,
            16,
            16,
            1,
            d0 * 2.0,
            d0 * 2.0,
            d0 * 2.0);
        for (int k = 0; k < 16; ++k) {
            for (int l = 0; l < 16; ++l) {
                final boolean flag = this.slowsandNoise[k + l * 16] + this.hellRNG.nextDouble() * 0.2 > 0.0;
                final boolean flag2 = this.gravelNoise[k + l * 16] + this.hellRNG.nextDouble() * 0.2 > 0.0;
                final int i1 = (int) (this.netherrackExclusivityNoise[k + l * 16] / 3.0 + 3.0
                    + this.hellRNG.nextDouble() * 0.25);
                int j1 = -1;
                Block block = Blocks.grass;
                Block block2 = Blocks.dirt;
                for (int k2 = 127; k2 >= 0; --k2) {
                    final int l2 = (l * 16 + k) * 128 + k2;
                    if (k2 < 127 - this.hellRNG.nextInt(5) && k2 > this.hellRNG.nextInt(5)) {
                        final Block block3 = p_147418_3_[l2];
                        if (block3 != null && block3.getMaterial() != Material.air) {
                            if (block3 == Blocks.stone) {
                                if (j1 == -1) {
                                    if (i1 <= 0) {
                                        block = null;
                                        block2 = Blocks.stone;
                                    } else if (k2 >= b0 - 4 && k2 <= b0 + 1) {
                                        block = Blocks.stone;
                                        block2 = Blocks.stone;
                                        if (flag2) {
                                            block = Blocks.grass;
                                            block2 = Blocks.dirt;
                                        }
                                        if (flag) {
                                            block = Blocks.grass;
                                            block2 = Blocks.dirt;
                                        }
                                    }
                                    if (k2 < b0 && block == Blocks.air) {
                                        block = Blocks.water;
                                    }
                                    j1 = i1;
                                    if (k2 >= b0 - 1) {
                                        p_147418_3_[l2] = block;
                                    } else {
                                        p_147418_3_[l2] = block2;
                                    }
                                } else if (j1 > 0) {
                                    --j1;
                                    p_147418_3_[l2] = block2;
                                }
                            }
                        } else {
                            j1 = -1;
                        }
                    } else {
                        p_147418_3_[l2] = null;
                    }
                }
            }
        }
    }

    public Chunk loadChunk(final int p_73158_1_, final int p_73158_2_) {
        return this.provideChunk(p_73158_1_, p_73158_2_);
    }

    public Chunk provideChunk(final int p_73154_1_, final int p_73154_2_) {
        this.hellRNG.setSeed(p_73154_1_ * 341873128712L + p_73154_2_ * 132897987541L);
        final Block[] ablock = new Block[32768];
        final byte[] meta = new byte[ablock.length];
        this.func_147419_a(p_73154_1_, p_73154_2_, ablock);
        this.replaceBiomeBlocks(p_73154_1_, p_73154_2_, ablock, meta, null);
        final Chunk chunk = new Chunk(this.worldObj, ablock, meta, p_73154_1_, p_73154_2_);
        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] initializeNoiseField(double[] p_73164_1_, final int p_73164_2_,
                                          final int p_73164_4_) {
        int k1 = 0;
        int l1 = 0;
        final double[] adouble1 = new double[17];
        if (p_73164_1_ == null) {
            p_73164_1_ = new double[5 * 17 * 5];
        }
        final double d0 = 684.412;
        final double d2 = 2053.236;
        this.noiseData4 = this.netherNoiseGen6.generateNoiseOctaves(
            this.noiseData4,
            p_73164_2_,
            0,
            p_73164_4_,
            5,
            1,
            5,
            1.0,
            0.0,
            1.0);
        this.noiseData5 = this.netherNoiseGen7.generateNoiseOctaves(
            this.noiseData5,
            p_73164_2_,
            0,
            p_73164_4_,
            5,
            1,
            5,
            100.0,
            0.0,
            100.0);
        this.noiseData1 = this.netherNoiseGen3.generateNoiseOctaves(
            this.noiseData1,
            p_73164_2_,
            0,
            p_73164_4_,
            5,
            17,
            5,
            d0 / 80.0,
            d2 / 60.0,
            d0 / 80.0);
        this.noiseData2 = this.netherNoiseGen1.generateNoiseOctaves(
            this.noiseData2,
            p_73164_2_,
            0,
            p_73164_4_,
            5,
            17,
            5,
            d0,
            d2,
            d0);
        this.noiseData3 = this.netherNoiseGen2.generateNoiseOctaves(
            this.noiseData3,
            p_73164_2_,
            0,
            p_73164_4_,
            5,
            17,
            5,
            d0,
            d2,
            d0);
        for (int i2 = 0; i2 < 17; ++i2) {
            adouble1[i2] = Math.cos(i2 * 3.141592653589793 * 6.0 / 17) * 2.0;
            double d3 = i2;
            if (i2 > 17 / 2) {
                d3 = 17 - 1 - i2;
            }
            if (d3 < 4.0) {
                d3 = 4.0 - d3;
                final double[] array = adouble1;
                final int n = i2;
                array[n] -= d3 * d3 * d3 * 10.0;
            }
        }
        for (int i2 = 0; i2 < 5; ++i2) {
            for (int k2 = 0; k2 < 5; ++k2) {
                double d4 = (this.noiseData4[l1] + 256.0) / 512.0;
                if (d4 > 1.0) {
                    d4 = 1.0;
                }
                final double d5 = 0.0;
                double d6 = this.noiseData5[l1] / 8000.0;
                if (d6 < 0.0) {
                    d6 = -d6;
                }
                d6 = d6 * 3.0 - 3.0;
                if (d6 < 0.0) {
                    d6 /= 2.0;
                    if (d6 < -1.0) {
                        d6 = -1.0;
                    }
                    d6 /= 1.4;
                    d6 /= 2.0;
                    d4 = 0.0;
                } else {
                    if (d6 > 1.0) {
                        d6 = 1.0;
                    }
                    d6 /= 6.0;
                }
                d4 += 0.5;
                d6 = d6 * 17 / 16.0;
                ++l1;
                for (int j2 = 0; j2 < 17; ++j2) {
                    double d7;
                    final double d8 = adouble1[j2];
                    final double d9 = this.noiseData2[k1] / 512.0;
                    final double d10 = this.noiseData3[k1] / 512.0;
                    final double d11 = (this.noiseData1[k1] / 10.0 + 1.0) / 2.0;
                    if (d11 < 0.0) {
                        d7 = d9;
                    } else if (d11 > 1.0) {
                        d7 = d10;
                    } else {
                        d7 = d9 + (d10 - d9) * d11;
                    }
                    d7 -= d8;
                    if (j2 > 17 - 4) {
                        final double d12 = (j2 - (17 - 4)) / 3.0f;
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    if (j2 < d5) {
                        double d12 = (d5 - j2) / 4.0;
                        if (d12 < 0.0) {
                            d12 = 0.0;
                        }
                        if (d12 > 1.0) {
                            d12 = 1.0;
                        }
                        d7 = d7 * (1.0 - d12) + -10.0 * d12;
                    }
                    p_73164_1_[k1] = d7;
                    ++k1;
                }
            }
        }
        return p_73164_1_;
    }

    public boolean chunkExists(final int p_73149_1_, final int p_73149_2_) {
        return true;
    }

    public void populate(final IChunkProvider p_73153_1_, final int par2, final int par3) {
        BlockFalling.fallInstantly = false;
        final int var4 = par2 * 16;
        final int var5 = par3 * 16;
        final BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
        var6.decorate(this.worldObj, this.worldObj.rand, var4, var5);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.worldObj.rand);
    }

    public boolean saveChunks(final boolean p_73151_1_, final IProgressUpdate p_73151_2_) {
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
        return "ChaosDimension";
    }

    public List getPossibleCreatures(final EnumCreatureType p_73155_1_, final int p_73155_2_, final int p_73155_3_,
                                     final int p_73155_4_) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(p_73155_2_, p_73155_4_);
        return biomegenbase.getSpawnableList(p_73155_1_);
    }

    public ChunkPosition func_147416_a(final World p_147416_1_, final String p_147416_2_, final int p_147416_3_,
                                       final int p_147416_4_, final int p_147416_5_) {
        return null;
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(final int p_82695_1_, final int p_82695_2_) {}
}
