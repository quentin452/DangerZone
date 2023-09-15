package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.Item;

public class ItemInitDangerZone {

    public static Item CrystalAppleItem;
    public static Item MinersDream;
    public static Item BasilicsScale;
    public static Item MobzillaScale;
    public static Item MothScale;

    public static Item MolenoidNose;
    public static Item BigBerthaBlade;

    public static Item BigBerthaHandle;

    public static Item BigBerthaGuard;

    public static Item NightmareScale;
    public static Item OmgMagicApple;
    public static Item PeacockFeather;
    public static Item CaterKillerJaw;

    public static Item QueenScale;
    public static Item CreeperLauncher;

    public static void init() {
        CrystalAppleItem = new CrystalApple(4, 0.6f, false).setUnlocalizedName("CrystalApple")
            .setTextureName(Tags.MODID + ":crystal_apple");
        MinersDream = new MinersDream(4).setUnlocalizedName("MinersDream");
        BasilicsScale = new BasilicsScale().setUnlocalizedName("BasiclicsScale");
        MobzillaScale = new MobzillaScale().setUnlocalizedName("MobzillaScale");
        MothScale = new MothScale().setUnlocalizedName("MothScale");
        MolenoidNose = new MolenoidNose().setUnlocalizedName("MolenoidNose");
        BigBerthaBlade = new BigBerthaBlade().setUnlocalizedName("BigBerthaBlade");
        BigBerthaHandle = new BigBerthaHandle().setUnlocalizedName("BigBerthaHandle");
        BigBerthaGuard = new BigBerthaGuard().setUnlocalizedName("BigBerthaGuard");
        NightmareScale = new NightmareScale().setUnlocalizedName("NightmareScale");
        OmgMagicApple = new OmgMagicApple(4, 0.6f, false).setUnlocalizedName("OmgMagicApple")
            .setTextureName(Tags.MODID + ":magicapple");
        PeacockFeather = new PeacockFeather().setUnlocalizedName("PeacockFeather");
        CaterKillerJaw = new CaterkillerJaw().setUnlocalizedName("CaterKillerJaw");
        QueenScale = new QueenScale().setUnlocalizedName("QueenScale");
        CreeperLauncher = new CreeperLauncher().setUnlocalizedName("CreeperLauncher");
    }

    public static void register() {
        GameRegistry.registerItem(CrystalAppleItem, "CrystalApple");
        GameRegistry.registerItem(MinersDream, "MinersDream");
        GameRegistry.registerItem(BasilicsScale, "BasiclicsScale");
        GameRegistry.registerItem(MobzillaScale, "MobzillaScale");
        GameRegistry.registerItem(MothScale, "MothScale");
        GameRegistry.registerItem(MolenoidNose, "MolenoidNose");
        GameRegistry.registerItem(BigBerthaBlade, "BigBerthaBlade");
        GameRegistry.registerItem(BigBerthaHandle, "BigBerthaHandle");
        GameRegistry.registerItem(BigBerthaGuard, "BigBerthaGuard");
        GameRegistry.registerItem(NightmareScale, "NightmareScale");
        GameRegistry.registerItem(OmgMagicApple, "OmgMagicApple");
        GameRegistry.registerItem(PeacockFeather, "PeacockFeather");
        GameRegistry.registerItem(CaterKillerJaw, "CaterKillerJaw");
        GameRegistry.registerItem(QueenScale, "QueenScale");
        GameRegistry.registerItem(CreeperLauncher, "CreeperLauncher");
    }
}
