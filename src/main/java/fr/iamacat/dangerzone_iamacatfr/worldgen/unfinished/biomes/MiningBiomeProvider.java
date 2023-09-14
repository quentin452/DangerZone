package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class MiningBiomeProvider extends BiomeGenBase {

    public static final BiomeGenBase mining = new MiningBiomeProvider(220);

    private MiningBiomeProvider(int id) {
        super(id, false);
        this.setBiomeName("Mining");
        this.setColor(0xFFFFFF);
        this.setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
    }
}
