package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.DangerBiomeProvider;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class DangerWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Danger";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new DangerChunkProvider(worldObj, getSeed());
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z) {
        return DangerBiomeProvider.danger;
    }
}
