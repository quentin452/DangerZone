
package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
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

public class CrystalWorldProvider extends WorldProvider {

    private UtopiaBiomeProvider MyPlains;

    public CrystalWorldProvider() {
        this.MyPlains = (UtopiaBiomeProvider) new UtopiaBiomeProvider().setColor(353825)
            .setBiomeName("Crystal")
            .setTemperatureRainfall(0.7f, 0.5f);
    }

    public String getDimensionName() {
        return "Dimension-Crystal";
    }

    public boolean canRespawnHere() {
        return true;
    }

    public void registerWorldChunkManager() {
        this.MyPlains.setCrystalCreatures();
        this.MyPlains.setHeight(new BiomeGenBase.Height(0.1f, 0.5f));
        this.worldChunkMgr = (WorldChunkManager) new WorldChunkManagerHell((BiomeGenBase) this.MyPlains, 0.01f);
        this.worldChunkMgr.getBiomeGenAt(0, 0)
            .setTemperatureRainfall(0.8f, 0.01f);
        this.dimensionId = DimensionInitDangerZone.CrystalDimensionId;
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
        return (IChunkProvider) new CrystalChunkProvider(this.worldObj, this.worldObj.getSeed(), true);
    }
}
