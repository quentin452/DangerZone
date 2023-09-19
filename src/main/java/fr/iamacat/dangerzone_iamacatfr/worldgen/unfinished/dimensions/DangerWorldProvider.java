package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.IChunkProvider;

public class DangerWorldProvider extends WorldProvider {

    @Override
    public String getDimensionName() {
        return "Danger";
    }

    @Override
    public String getWelcomeMessage() {
        return "Entering the Danger Dimension!";
    }

    @Override
    public String getDepartMessage() {
        return "Leaving the Danger Dimension.";
    }

    @Override
    public IChunkProvider createChunkGenerator() {
        return new DangerChunkProvider(worldObj, worldObj.getSeed());
    }
}
