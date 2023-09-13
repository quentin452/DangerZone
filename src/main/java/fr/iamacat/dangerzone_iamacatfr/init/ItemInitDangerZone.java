package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalApple;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;

public class ItemInitDangerZone {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        Constants.CrystalApple = new CrystalApple(4, 0.6f, false).setUnlocalizedName("CrystalApple");
        GameRegistry.registerItem(Constants.CrystalApple, "crystal_apple");
    }
}
