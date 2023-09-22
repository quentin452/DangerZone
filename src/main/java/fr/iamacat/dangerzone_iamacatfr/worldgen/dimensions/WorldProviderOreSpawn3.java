
package fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.worldgen.biomes.BiomeGenUtopianPlains;

public class WorldProviderOreSpawn3 extends WorldProvider {

    private final BiomeGenUtopianPlains MyPlains;

    public WorldProviderOreSpawn3() {
        this.MyPlains = (BiomeGenUtopianPlains) new BiomeGenUtopianPlains(OreSpawnMain.BiomeVillageID).setColor(353825)
            .setBiomeName("Mining")
            .setTemperatureRainfall(0.7f, 0.5f);
    }

    public String getDimensionName() {
        return "Dimension-Mining";
    }

    public void registerWorldChunkManager() {
        this.MyPlains.setVillageCreatures();
        this.worldChunkMgr = new WorldChunkManagerHell(this.MyPlains, 0.5f);
        this.worldChunkMgr.getBiomeGenAt(0, 0)
            .setTemperatureRainfall(0.7f, 0.5f);
        this.dimensionId = DimensionInitDangerZone.DimensionID3;
        BiomeManager.addVillageBiome(this.MyPlains, true);
    }

    public void setWorldTime(final long time) {
        final WorldServer ws = DimensionManager.getWorld(this.dimensionId);
        if (ws != null) {
            final WorldInfo w = ws.getWorldInfo();
            if (w != null) {
                if (time % 24000L > 12000L && ws.areAllPlayersAsleep()) {
                    long i = time + 24000L;
                    i -= i % 24000L;
                    for (int j = 0; j < MinecraftServer.getServer().worldServers.length; ++j) {
                        MinecraftServer.getServer().worldServers[j].setWorldTime(i);
                    }
                } else {
                    super.setWorldTime(time);
                }
            } else {
                super.setWorldTime(time);
            }
        } else {
            super.setWorldTime(time);
        }
    }

    public IChunkProvider createChunkGenerator() {
        return new ChunkProviderOreSpawn3(this.worldObj, this.worldObj.getSeed(), true);
    }
}
