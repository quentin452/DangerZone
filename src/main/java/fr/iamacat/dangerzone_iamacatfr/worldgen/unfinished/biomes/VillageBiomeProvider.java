package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class VillageBiomeProvider extends BiomeGenBase {

    public static final BiomeGenBase village = new VillageBiomeProvider(220);

    private VillageBiomeProvider(int id) {
        super(id, false);
        this.setBiomeName("Village");
        this.setColor(0xFFFFFF);
        this.setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
    }
}
