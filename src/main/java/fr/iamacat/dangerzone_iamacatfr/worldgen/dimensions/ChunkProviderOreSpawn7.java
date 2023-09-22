
package fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
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
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenScatteredFeature;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon.MapGenMoreVillages;

public class ChunkProviderOreSpawn7 implements IChunkProvider {

    private final Random rand;
    private NoiseGeneratorOctaves field_147431_j;
    private NoiseGeneratorOctaves field_147432_k;
    private NoiseGeneratorOctaves field_147429_l;
    private NoiseGeneratorPerlin field_147430_m;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;
    public NoiseGeneratorOctaves mobSpawnerNoise;
    private final World worldObj;
    private final boolean mapFeaturesEnabled;
    private final WorldType field_147435_p;
    private final double[] field_147434_q;
    private final float[] parabolicField;
    private double[] stoneNoise;
    private final MapGenBase caveGenerator;
    private final MapGenStronghold strongholdGenerator;
    private final MapGenMoreVillages villageGenerator;
    private final MapGenMineshaft mineshaftGenerator;
    private final MapGenScatteredFeature scatteredFeatureGenerator;
    private final MapGenBase ravineGenerator;
    private BiomeGenBase[] biomesForGeneration;
    double[] field_147427_d;
    double[] field_147428_e;
    double[] field_147425_f;
    double[] field_147426_g;
    int[][] field_73219_j;

    public ChunkProviderOreSpawn7(final World par1World, final long par2, final boolean par4) {
        this.stoneNoise = new double[256];
        this.caveGenerator = (MapGenBase) new MapGenCaves();
        this.strongholdGenerator = new MapGenStronghold();
        this.villageGenerator = new MapGenMoreVillages();
        this.mineshaftGenerator = new MapGenMineshaft();
        this.scatteredFeatureGenerator = new MapGenScatteredFeature();
        this.ravineGenerator = (MapGenBase) new MapGenRavine();
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
        NoiseGenerator[] noiseGens = { this.field_147431_j, (NoiseGenerator) this.field_147432_k,
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
                                    p_147424_3_[j3 += short1] = Blocks.stone;
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
                final BiomeGenBase biomegenbase = p_147422_5_[l + k * 16];
                biomegenbase.genTerrainBlocks(
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
        this.caveGenerator.func_151539_a((IChunkProvider) this, this.worldObj, par1, par2, ablock);
        this.ravineGenerator.func_151539_a((IChunkProvider) this, this.worldObj, par1, par2, ablock);
        if (this.mapFeaturesEnabled) {
            this.villageGenerator.func_151539_a((IChunkProvider) this, this.worldObj, par1, par2, ablock);
            this.scatteredFeatureGenerator.func_151539_a((IChunkProvider) this, this.worldObj, par1, par2, ablock);
        }
        final Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
        OreSpawnMain.Chunker.generateOresInChunk(this.worldObj, this.rand, par1 * 16, par2 * 16, chunk);
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
        int k = par2 * 16;
        int l = par3 * 16;
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        final long i1 = this.rand.nextLong() / 2L * 2L + 1L;
        final long j1 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.getSeed());
        boolean flag = false;
        if (this.mapFeaturesEnabled) {
            this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
            this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
        }
        if (biomegenbase != BiomeGenBase.desert && biomegenbase != BiomeGenBase.desertHills
            && !flag
            && this.rand.nextInt(4) == 0
            && TerrainGen.populate(
                par1IChunkProvider,
                this.worldObj,
                this.rand,
                par2,
                par3,
                flag,
                PopulateChunkEvent.Populate.EventType.LAKE)) {
            final int k2 = k + this.rand.nextInt(16) + 8;
            final int l2 = this.rand.nextInt(256);
            final int i2 = l + this.rand.nextInt(16) + 8;
            new WorldGenLakes(Blocks.water).generate(this.worldObj, this.rand, k2, l2, i2);
        }
        if (TerrainGen.populate(
            par1IChunkProvider,
            this.worldObj,
            this.rand,
            par2,
            par3,
            flag,
            PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
            final int k2 = k + this.rand.nextInt(16) + 8;
            final int l2 = this.rand.nextInt(this.rand.nextInt(248) + 8);
            final int i2 = l + this.rand.nextInt(16) + 8;
            if (l2 < 63 || this.rand.nextInt(10) == 0) {
                new WorldGenLakes(Blocks.lava).generate(this.worldObj, this.rand, k2, l2, i2);
            }
        }
        int k2;
        int l3;
        int i2;
        boolean doGen;
        int j2;
        for (doGen = TerrainGen.populate(
            par1IChunkProvider,
            this.worldObj,
            this.rand,
            par2,
            par3,
            flag,
            PopulateChunkEvent.Populate.EventType.DUNGEON), k2 = 0; doGen && k2 < 8; ++k2) {
            l3 = k + this.rand.nextInt(16) + 8;
            i2 = this.rand.nextInt(256);
            j2 = l + this.rand.nextInt(16) + 8;
            new WorldGenDungeons().generate(this.worldObj, this.rand, l3, i2, j2);
        }
        biomegenbase.decorate(this.worldObj, this.rand, k, l);
        SpawnerAnimals.performWorldGenSpawning(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
        k += 8;
        l += 8;
        for (doGen = TerrainGen.populate(
            par1IChunkProvider,
            this.worldObj,
            this.rand,
            par2,
            par3,
            flag,
            PopulateChunkEvent.Populate.EventType.ICE), k2 = 0; doGen && k2 < 16; ++k2) {
            for (int l2 = 0; l2 < 16; ++l2) {
                i2 = this.worldObj.getPrecipitationHeight(k + k2, l + l2);
                if (this.worldObj.isBlockFreezable(k2 + k, i2 - 1, l2 + l)) {
                    this.worldObj.setBlock(k2 + k, i2 - 1, l2 + l, Blocks.ice, 0, 2);
                }
                if (this.worldObj.func_147478_e(k2 + k, i2, l2 + l, true)) {
                    this.worldObj.setBlock(k2 + k, i2, l2 + l, Blocks.snow_layer, 0, 2);
                }
            }
        }
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
        return "MiningDimension";
    }

    public List getPossibleCreatures(final EnumCreatureType par1EnumCreatureType, final int par2, final int par3,
        final int par4) {
        final BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
        return (par1EnumCreatureType == EnumCreatureType.monster
            && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4))
                ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList()
                : biomegenbase.getSpawnableList(par1EnumCreatureType);
    }

    public ChunkPosition func_147416_a(final World p_147416_1_, final String p_147416_2_, final int p_147416_3_,
        final int p_147416_4_, final int p_147416_5_) {
        return ("Stronghold".equals(p_147416_2_) && this.strongholdGenerator != null)
            ? this.strongholdGenerator.func_151545_a(p_147416_1_, p_147416_3_, p_147416_4_, p_147416_5_)
            : null;
    }

    public int getLoadedChunkCount() {
        return 0;
    }

    public void recreateStructures(final int par1, final int par2) {
        if (this.mapFeaturesEnabled) {
            this.mineshaftGenerator.func_151539_a(this, this.worldObj, par1, par2, null);
            this.villageGenerator.func_151539_a(this, this.worldObj, par1, par2, null);
            this.strongholdGenerator.func_151539_a(this, this.worldObj, par1, par2, null);
            this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, null);
        }
    }
}
