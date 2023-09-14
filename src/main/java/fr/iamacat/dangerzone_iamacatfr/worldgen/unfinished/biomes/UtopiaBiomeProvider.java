package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import net.minecraft.world.biome.BiomeGenBase;

public class UtopiaBiomeProvider extends BiomeGenBase {

    public static final BiomeGenBase utopia = new UtopiaBiomeProvider(220);

    private UtopiaBiomeProvider(int id) {
        super(id, false);
        this.setBiomeName("Utopia");
        this.setColor(0xFFFFFF);
        this.setHeight(new BiomeGenBase.Height(0.1F, 0.2F));
    }
}
