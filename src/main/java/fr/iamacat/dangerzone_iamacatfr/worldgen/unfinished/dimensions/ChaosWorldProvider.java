package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.ChaosBiomeProvider;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class ChaosWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Chaos";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new ChaosChunkProvider(worldObj, getSeed());
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z) {
        return ChaosBiomeProvider.chaos;
    }
}
