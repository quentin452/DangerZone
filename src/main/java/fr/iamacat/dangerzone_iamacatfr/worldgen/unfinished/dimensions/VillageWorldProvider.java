
package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import danger.orespawn.DangerZone;
import danger.orespawn.worldgen.biomes.BiomeGenUtopianPlains;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.DimensionManager;

public class VillageWorldProvider extends WorldProvider {

    private BiomeGenUtopianPlains MyPlains;

    public VillageWorldProvider() {
        this.MyPlains = (BiomeGenUtopianPlains) new BiomeGenUtopianPlains(DangerZone.BiomeVillageID).setColor(353825)
            .setBiomeName("Villages")
            .setTemperatureRainfall(0.7f, 0.5f);
    }

    public String getDimensionName() {
        return "Dimension-VillageMania";
    }

    public boolean canRespawnHere() {
        return true;
    }

    public void registerWorldChunkManager() {
        this.MyPlains.setVillageCreatures();
        this.worldChunkMgr = (WorldChunkManager) new WorldChunkManagerHell((BiomeGenBase) this.MyPlains, 0.5f);
        this.worldChunkMgr.getBiomeGenAt(0, 0)
            .setTemperatureRainfall(0.7f, 0.5f);
        this.dimensionId = DangerZone.DimensionID3;
        BiomeManager.addVillageBiome((BiomeGenBase) this.MyPlains, true);
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
        return (IChunkProvider) new VillageChunkProvider(this.worldObj, this.worldObj.getSeed(), true);
    }
}
