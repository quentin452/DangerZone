package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;

import java.util.Collections;
import java.util.List;
import java.util.Random;

// todo add structures , dungeons etc.... finish noise implementation
public class UtopiaChunkProvider implements IChunkProvider {

    private World worldObj;
    private Random random;

    public UtopiaChunkProvider(World world, long seed) {
        this.worldObj = world;
        this.random = new Random(seed);
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
        // Votre logique de chargement de chunk va ici
        // Vous devez retourner le chunk chargé ou généré
        // Si le chunk n'existe pas, vous pouvez générer un nouveau chunk

        // Exemple de génération d'un nouveau chunk :
        Chunk chunk = this.provideChunk(x, z); // Utilisez votre méthode provideChunk

        // Si vous avez une sauvegarde du chunk, chargez-la ici
        // Sinon, générez le contenu du chunk

        return chunk;
    }

    private void generateTerrain(Chunk chunk) {
        int chunkX = chunk.xPosition * 16;
        int chunkZ = chunk.zPosition * 16;

        for (int x = 0; x < 16; x++) {
            for (int z = 0; z < 16; z++) {
                int worldX = chunkX + x;
                int worldZ = chunkZ + z;

                // Configure these values to control terrain generation
                double terrainScale = 0.1;
                double noiseValue = random.nextDouble(); // Use Perlin noise or another noise function here

                int seaLevel = 63;
                int terrainHeight = (int) (noiseValue * 20 + seaLevel);

                for (int y = 0; y < 256; y++) {
                    Block block = Blocks.air;

                    if (y == terrainHeight || (y < terrainHeight && y > seaLevel)) {
                        block = Blocks.stone; // Adjust this to your desired terrain block
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
        return null;
    }

    @Override
    public List getPossibleCreatures(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
        // todo add creatures type that can spawn in this dim
        return Collections.emptyList();
    }

    @Override
    public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_,
        int p_147416_5_) {
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
