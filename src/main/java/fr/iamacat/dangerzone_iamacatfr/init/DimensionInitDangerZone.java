package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions.*;
import net.minecraftforge.common.DimensionManager;

public class DimensionInitDangerZone {

    public static int UtopiaDimensionId = 150;
    // todo need to make a butterfly entity and make the implementation to tp to the dimension
    public static int ChaosDimensionId = 151;
    public static int CrystalDimensionId = 152;
    public static int DangerDimensionId = 153;
    public static int MiningDimensionId = 154;
    public static int VillageDimensionId = 155;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        DimensionManager.registerProviderType(UtopiaDimensionId, UtopiaWorldProvider.class, false);
        DimensionManager.registerDimension(UtopiaDimensionId, UtopiaDimensionId);

        DimensionManager.registerProviderType(ChaosDimensionId, ChaosWorldProvider.class, false);
        DimensionManager.registerDimension(ChaosDimensionId, ChaosDimensionId);

        DimensionManager.registerProviderType(CrystalDimensionId, CrystalWorldProvider.class, false);
        DimensionManager.registerDimension(CrystalDimensionId, CrystalDimensionId);

        DimensionManager.registerProviderType(DangerDimensionId, DangerWorldProvider.class, false);
        DimensionManager.registerDimension(DangerDimensionId, DangerDimensionId);
        DimensionManager.registerProviderType(MiningDimensionId, MiningWorldProvider.class, false);
        DimensionManager.registerDimension(MiningDimensionId, MiningDimensionId);

        DimensionManager.registerProviderType(VillageDimensionId, VillageWorldProvider.class, false);
        DimensionManager.registerDimension(VillageDimensionId, VillageDimensionId);
    }

}
