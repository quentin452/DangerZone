
package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;
import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes.UtopiaBiomeProvider;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;

public class UtopiaWorldProvider extends WorldProvider {

    private UtopiaBiomeProvider MyPlains;

    public UtopiaWorldProvider() {
        this.MyPlains = (UtopiaBiomeProvider) new UtopiaBiomeProvider(Constants.BiomeUtopiaID).setColor(353825)
            .setBiomeName("Utopia")
            .setTemperatureRainfall(0.7f, 0.5f);
    }

    public void registerWorldChunkManager() {
      //  this.MyPlains.setIslandCreatures();
        this.worldChunkMgr = (WorldChunkManager) new WorldChunkManagerHell((BiomeGenBase) this.MyPlains, 0.5f);
        this.worldChunkMgr.getBiomeGenAt(0, 0)
            .setTemperatureRainfall(0.7f, 0.5f);
        this.dimensionId = DimensionInitDangerZone.UtopiaDimensionId;
    }
    public String getDimensionName() {
        return "Dimension-Utopia";
    }

    public boolean canRespawnHere() {
        return true;
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
        return (IChunkProvider) new UtopiaChunkProvider(this.worldObj, this.worldObj.getSeed(), true);
    }
}
