package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class CrystalBiomeProvider extends BiomeGenBase {

    public static final BiomeGenBase crystal = new CrystalBiomeProvider(220);

    private CrystalBiomeProvider(int id) {
        super(id, false);
        this.setBiomeName("Crystal");
        this.setColor(0xFFFFFF);
        this.setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
    }
}
