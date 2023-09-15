package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalApple;
import fr.iamacat.dangerzone_iamacatfr.items.unfinished.MinersDream;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.Item;

public class ItemInitDangerZone {

    public static Item CrystalAppleItem;
    public static Item MinersDream;

    public static void init() {
        CrystalAppleItem = new CrystalApple(4, 0.6f, false).setUnlocalizedName("CrystalApple")
            .setTextureName(Tags.MODID + ":crystal_apple");
        MinersDream = new MinersDream(4).setUnlocalizedName("MinersDream")
            .setTextureName(Tags.MODID + ":crystal_apple");
    }

    public static void register() {
        GameRegistry.registerItem(CrystalAppleItem, "CrystalApple");
        GameRegistry.registerItem(MinersDream, "MinersDream");
    }
}
