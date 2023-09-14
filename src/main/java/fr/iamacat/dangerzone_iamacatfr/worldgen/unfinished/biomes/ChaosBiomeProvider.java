package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class ChaosBiomeProvider extends BiomeGenBase {

    public static final BiomeGenBase chaos = new ChaosBiomeProvider(220);

    private ChaosBiomeProvider(int id) {
        super(id, false);
        this.setBiomeName("Chaos");
        this.setColor(0xFFFFFF);
        this.setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
    }
}
