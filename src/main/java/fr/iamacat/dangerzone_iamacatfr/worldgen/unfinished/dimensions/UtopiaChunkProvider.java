package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderGenerate;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UtopiaChunkProvider implements IChunkProvider {

    private final World world;
    private final long seed;
    private final ChunkProviderGenerate generateProvider;

    public UtopiaChunkProvider(World world, long seed) {
        this.world = world;
        this.seed = seed;
        this.generateProvider = new ChunkProviderGenerate(world, seed, false);
    }

    @Override
    public boolean chunkExists(int p_73149_1_, int p_73149_2_) {
        return false;
    }

    @Override
    public Chunk provideChunk(int x, int z) {
        return this.generateProvider.provideChunk(x, z);
    }

    @Override
    public Chunk loadChunk(int x, int z) {
        return this.generateProvider.loadChunk(x, z);
    }

    @Override
    public void populate(IChunkProvider provider, int x, int z) {
        this.generateProvider.populate(provider, x, z);
    }

    @Override
    public boolean saveChunks(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
        return false;
    }

    @Override
    public boolean unloadQueuedChunks() {
        return false;
    }

    @Override
    public boolean canSave() {
        return false;
    }

    @Override
    public String makeString() {
        return null;
    }

    @Override
    public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
        // todo add creatures type that can spawn in this dim
        return Collections.emptyList();
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null;
    }

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }

    @Override
    public void recreateStructures(int p_82695_1_, int p_82695_2_) {

    }

    @Override
    public void saveExtraData() {

    }
}
