package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.MiningBiomeProvider;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class MiningWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Mining";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new MiningChunkProvider(worldObj, getSeed());
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z) {
        return MiningBiomeProvider.mining;
    }
}
