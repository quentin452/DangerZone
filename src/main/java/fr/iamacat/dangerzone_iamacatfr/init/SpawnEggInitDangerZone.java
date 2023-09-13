package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.CrystalCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EnchantedGoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.spawnable.SpawnEggs;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;

public class SpawnEggInitDangerZone {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        // Apple Cow
        SpawnEggs appleCowSpawnEgg = new SpawnEggs(AppleCowInstance.class);
        appleCowSpawnEgg.setUnlocalizedName("apple_cow_egg");
        Constants.AppleCowSpawnEgg = appleCowSpawnEgg;
        GameRegistry.registerItem(Constants.AppleCowSpawnEgg, "Apple Cow Egg");

        // Crystal Cow
        SpawnEggs crystalCowSpawnEgg = new SpawnEggs(CrystalCowInstance.class);
        crystalCowSpawnEgg.setUnlocalizedName("crystal_cow_egg");
        Constants.CrystalCowSpawnEgg = crystalCowSpawnEgg;
        GameRegistry.registerItem(Constants.CrystalCowSpawnEgg, "Crystal Cow Egg");

        // Enchanted Golden Apple Cow
        SpawnEggs enchantedGoldenAppleCowSpawnEgg = new SpawnEggs(EnchantedGoldenAppleCowInstance.class);
        enchantedGoldenAppleCowSpawnEgg.setUnlocalizedName("enchanted_golden_apple_cow_egg");
        Constants.EnchantedGoldenAppleCowSpawnEgg = enchantedGoldenAppleCowSpawnEgg;
        GameRegistry.registerItem(Constants.EnchantedGoldenAppleCowSpawnEgg, "Enchanted Golden Apple Cow Egg");

        // Golden Apple Cow
        SpawnEggs goldenAppleCowSpawnEgg = new SpawnEggs(GoldenAppleCowInstance.class);
        goldenAppleCowSpawnEgg.setUnlocalizedName("golden_apple_cow_egg");
        Constants.GoldenAppleCowSpawnEgg = goldenAppleCowSpawnEgg;
        GameRegistry.registerItem(Constants.GoldenAppleCowSpawnEgg, "Golden Apple Cow Egg");
    }
}
