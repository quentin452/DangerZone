package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class ItemInitDangerZone {
    public static Item dragonMeat;
    public static Item dragonMeatCooked;
    public static Item rainbowOpalGem;
    public static Item rainbowOpalChunk;
    public static Item pureRainbowOpalGem;
    public static Item darkCrystal;
    public static Item phoenixFeather;
    public static Item twilightStar;
    public static Item mavisOrb;
    public static void init() {

        GameRegistry.registerItem(
            ItemInitDangerZone.rainbowOpalGem = new Item().setUnlocalizedName("rainbowOpalGem")
                .setCreativeTab(CreativeTabs.tabMaterials)
                .setTextureName(Tags.MODID + ":rainbowOpalGem"),
            "rainbowOpalGem");
        GameRegistry.registerItem(
            ItemInitDangerZone.pureRainbowOpalGem = new Item().setUnlocalizedName("pureRainbowOpalGem")
                .setCreativeTab(CreativeTabs.tabMaterials)
                .setTextureName(Tags.MODID + ":pureRainbowOpalGem"),
            "pureRainbowOpalGem");
        GameRegistry.registerItem(
            ItemInitDangerZone.rainbowOpalChunk = new Item().setUnlocalizedName("rainbowOpalChunk")
                .setCreativeTab(CreativeTabs.tabMaterials)
                .setTextureName(Tags.MODID + ":rainbowOpalChunk"),
            "rainbowOpalChunk");
        GameRegistry.registerItem(
            ItemInitDangerZone.dragonMeat = new ItemDecoyDragonFood(
                "dragonMeat",
                3,
                0.3f,
                false,
                new PotionEffect(Potion.regeneration.id, 0, 0)).setAlwaysEdible(),
            "dragonMeat");
        GameRegistry.registerItem(
            ItemInitDangerZone.dragonMeatCooked = new ItemDecoyDragonFood(
                "dragonMeatCooked",
                3,
                1.0f,
                false,
                new PotionEffect(Potion.regeneration.id, 2, 1)).setAlwaysEdible(),
            "dragonMeatCooked");
        phoenixFeather = new PhoenixFeather();
        darkCrystal = new DarkCrystal();
        twilightStar = new TwilightStar(510);
        mavisOrb = new MavisOrb().setTextureName(Tags.MODID + ":MavisOrb")
            .setUnlocalizedName("MavisOrb");
    }


    public static void register() {
        GameRegistry.registerItem(rainbowOpalGem, "rainbowOpalGem");
        GameRegistry.registerItem(pureRainbowOpalGem, "pureRainbowOpalGem");
        GameRegistry.registerItem(rainbowOpalChunk, "rainbowOpalChunk");
        GameRegistry.registerItem(dragonMeat, "dragonMeat");
        GameRegistry.registerItem(dragonMeatCooked, "dragonMeatCooked");
        GameRegistry.registerItem(phoenixFeather, "phoenixFeather");
        GameRegistry.registerItem(darkCrystal, "darkCrystal");
        GameRegistry.registerItem(twilightStar, "twilightStar");
        GameRegistry.registerItem(mavisOrb, "MavisOrb");
    }
}
