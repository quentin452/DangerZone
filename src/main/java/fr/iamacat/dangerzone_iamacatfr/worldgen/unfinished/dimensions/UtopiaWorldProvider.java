package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.UtopiaBiomeProvider;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class UtopiaWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Utopia";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new UtopiaChunkProvider(worldObj, getSeed());
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z) {
        return UtopiaBiomeProvider.utopia;
    }
}
