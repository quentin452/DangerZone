package fr.iamacat.dangerzone_iamacatfr.init;

import net.minecraftforge.common.DimensionManager;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions.*;

public class DimensionInitDangerZone {

    public static int DimensionID = OreSpawnMain.BaseDimensionID;
    public static int DimensionID2 = OreSpawnMain.BaseDimensionID + 1;
    public static int DimensionID3 = OreSpawnMain.BaseDimensionID + 2;
    public static int DimensionID4 = OreSpawnMain.BaseDimensionID + 3;
    public static int DimensionID5 = OreSpawnMain.BaseDimensionID + 4;
    public static int DimensionID6 = OreSpawnMain.BaseDimensionID + 5;
    public static int DimensionID7 = OreSpawnMain.BaseDimensionID + 6;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        DimensionManager.registerProviderType(DimensionID, WorldProviderOreSpawn.class, false);
        DimensionManager.registerDimension(DimensionID, DimensionID);
        DimensionManager.registerProviderType(DimensionID2, WorldProviderOreSpawn2.class, false);
        DimensionManager.registerDimension(DimensionID2, DimensionID2);
        DimensionManager.registerProviderType(DimensionID3, WorldProviderOreSpawn3.class, false);
        DimensionManager.registerDimension(DimensionID3, DimensionID3);
        DimensionManager.registerProviderType(DimensionID4, WorldProviderOreSpawn4.class, false);
        DimensionManager.registerDimension(DimensionID4, DimensionID4);
        DimensionManager.registerProviderType(DimensionID5, WorldProviderOreSpawn5.class, false);
        DimensionManager.registerDimension(DimensionID5, DimensionID5);
        DimensionManager.registerProviderType(DimensionID6, WorldProviderOreSpawn6.class, false);
        DimensionManager.registerDimension(DimensionID6, DimensionID6);
        DimensionManager.registerProviderType(DimensionID7, WorldProviderOreSpawn7.class, false);
        DimensionManager.registerDimension(DimensionID7, DimensionID7);
    }
}
