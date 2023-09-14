package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.CrystalBiomeProvider;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;

public class CrystalWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Crystal";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new CrystalChunkProvider(worldObj, getSeed());
    }

    @Override
    public BiomeGenBase getBiomeGenForCoords(int x, int z) {
        return CrystalBiomeProvider.crystal;
    }
}
