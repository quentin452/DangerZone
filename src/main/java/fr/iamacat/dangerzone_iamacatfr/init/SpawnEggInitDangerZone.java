package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.AppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.spawnable.SpawnEggs;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;

public class SpawnEggInitDangerZone {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        SpawnEggs appleCowSpawnEgg = new SpawnEggs(AppleCowInstance.class);
        appleCowSpawnEgg.setUnlocalizedName("apple_cow_egg");

        Constants.AppleCowSpawnEgg = appleCowSpawnEgg;

        GameRegistry.registerItem(Constants.AppleCowSpawnEgg, "Apple Cow Egg");
    }
}
