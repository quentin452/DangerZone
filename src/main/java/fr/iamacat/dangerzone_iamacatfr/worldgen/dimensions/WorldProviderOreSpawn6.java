
package fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.worldgen.biomes.BiomeGenUtopianPlains;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;

public class WorldProviderOreSpawn6 extends WorldProvider {

    private final BiomeGenUtopianPlains MyPlains;

    public WorldProviderOreSpawn6() {
        this.MyPlains = (BiomeGenUtopianPlains) new BiomeGenUtopianPlains(OreSpawnMain.BiomeChaosID).setColor(353825)
            .setBiomeName("Chaos")
            .setTemperatureRainfall(0.7f, 0.5f);
    }

    public String getDimensionName() {
        return "Dimension-Chaos";
    }


    public void registerWorldChunkManager() {
        this.MyPlains.setChaosCreatures();
        this.worldChunkMgr = new WorldChunkManagerHell(this.MyPlains, 0.01f);
        this.worldChunkMgr.getBiomeGenAt(0, 0)
            .setTemperatureRainfall(0.8f, 0.01f);
        this.dimensionId = DimensionInitDangerZone.DimensionID6;
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
        return new ChunkProviderOreSpawn6(this.worldObj, this.worldObj.getSeed());
    }
}
