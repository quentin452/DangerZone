package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class DangerBiomeProvider extends BiomeGenBase {

    public static final BiomeGenBase danger = new DangerBiomeProvider(220);

    private DangerBiomeProvider(int id) {
        super(id, false);
        this.setBiomeName("Danger");
        this.setColor(0xFFFFFF);
        this.setHeight(new Height(0.1F, 0.2F));
    }
}
