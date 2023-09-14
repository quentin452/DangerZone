package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.VillageBiomeProvider;

public class VillageWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Village";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new VillageChunkProvider(worldObj, getSeed());
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z) {
        return VillageBiomeProvider.village;
    }
}
