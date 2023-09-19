package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.List;

public class DangerChunkProvider implements IChunkProvider {

    private World worldObj;

    public DangerChunkProvider(World world, long seed) {
        this.worldObj = world;
    }

    @Override
    public boolean chunkExists(int x, int z) {
        return true;
    }

    @Override
    public Chunk provideChunk(int x, int z) {
        Chunk chunk = new Chunk(worldObj, x, z);
        generateTerrain(chunk);
        return chunk;
    }

    @Override
    public Chunk loadChunk(int x, int z) {
        return provideChunk(x, z);
    }

    private void generateTerrain(Chunk chunk) {
        Block dirtBlock = Blocks.dirt;
        Block grassBlock = Blocks.grass;
        Block bedrockBlock = Blocks.bedrock;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                for (int y = 0; y < 256; y++) {
                    Block block;

                    if (y == 0) {
                        block = bedrockBlock; // Couche de bedrock au niveau 0
                    } else if (y <= 6) {
                        block = dirtBlock; // 6 couches de DIRT
                    } else if (y == 7) {
                        block = grassBlock; // 1 couche de GRASS
                    } else {
                        block = Blocks.air; // Le reste de l'air
                    }

                    chunk.func_150807_a(x, y, z, block, 0);
                }
            }
        }
    }

    // Implement other methods as needed

    @Override
    public void populate(IChunkProvider provider, int x, int z) {}

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
        return "DangerChunkProvider";
    }

    @Override
    public List<BiomeGenBase.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, int x, int y, int z) {
        // Add creatures that can spawn in this dimension here
        return null;
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
        return null;
    }

    @Override
    public void recreateStructures(int x, int z) {}

    @Override
    public void saveExtraData() {}

    @Override
    public int getLoadedChunkCount() {
        return 0;
    }
}
