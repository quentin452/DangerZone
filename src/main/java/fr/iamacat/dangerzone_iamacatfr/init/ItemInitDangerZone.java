package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.items.RandomDungeon;
import fr.iamacat.dangerzone_iamacatfr.items.SeaMonsterScale;
import fr.iamacat.dangerzone_iamacatfr.items.SeaViperTongue;
import fr.iamacat.dangerzone_iamacatfr.items.DeadStinkBug;
import fr.iamacat.dangerzone_iamacatfr.items.Sifter;
import fr.iamacat.dangerzone_iamacatfr.items.DuctTape;
import fr.iamacat.dangerzone_iamacatfr.items.KrakenTooth;
import fr.iamacat.dangerzone_iamacatfr.items.TrexTooth;
import fr.iamacat.dangerzone_iamacatfr.items.WormTooth;
import fr.iamacat.dangerzone_iamacatfr.items.EmperorScorpionScale;
import fr.iamacat.dangerzone_iamacatfr.items.VortexEye;
import fr.iamacat.dangerzone_iamacatfr.items.WaterDragonScale;
import fr.iamacat.dangerzone_iamacatfr.items.GreenGoo;
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
    public static Item RandomDungeon;

    public static Item SeaMonsterScale;
    public static Item SeaViperTongue;
    public static Item Sifter;

    public static Item CrystalShard;
    public static Item RedAntRobotKit;
    public static Item SpiderRobotKit;

    public static Item DeadStinkBug;
    public static Item DuctTape;

    public static Item KrakenTooth;

    public static Item TrexTooth;

    public static Item WormTooth;
    public static Item EmperorScorpionScale;
    public static Item VortexEye;
    public static Item WaterDragonScale;

    public static Item GreenGoo;

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
        RandomDungeon = new RandomDungeon().setUnlocalizedName("RandomDungeon");
        SeaMonsterScale = new SeaMonsterScale().setUnlocalizedName("SeaMonsterScale");
        SeaViperTongue = new SeaViperTongue().setUnlocalizedName("SeaViperTongue");
        Sifter = new Sifter().setUnlocalizedName("Sifter");
        CrystalShard = new CrystalShard().setUnlocalizedName("CrystalShard");
        RedAntRobotKit = new RedAntRobotKit().setUnlocalizedName("RedAntRobotKit");
        SpiderRobotKit = new SpiderRobotKit().setUnlocalizedName("SpiderRobotKit");
        DeadStinkBug = new DeadStinkBug().setUnlocalizedName("DeadStinkBug");
        DuctTape = new DuctTape().setUnlocalizedName("DuctTape");
        KrakenTooth = new KrakenTooth().setUnlocalizedName("KrakenTooth");
        TrexTooth = new TrexTooth().setUnlocalizedName("TrexTooth");
        WormTooth = new WormTooth().setUnlocalizedName("WormTooth");
        EmperorScorpionScale = new EmperorScorpionScale().setUnlocalizedName("EmperorScorpionScale");
        VortexEye = new VortexEye().setUnlocalizedName("VortexEye");
        WaterDragonScale = new WaterDragonScale().setUnlocalizedName("WaterDragonScale");
        GreenGoo = new GreenGoo().setUnlocalizedName("GreenGoo");

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
        GameRegistry.registerItem(RandomDungeon, "RandomDungeon");
        GameRegistry.registerItem(SeaMonsterScale, "SeaMonsterScale");
        GameRegistry.registerItem(SeaViperTongue, "SeaViperTongue");
        GameRegistry.registerItem(Sifter, "Sifter");
        GameRegistry.registerItem(CrystalShard, "CrystalShard");
        GameRegistry.registerItem(RedAntRobotKit, "RedAntRobotKit");
        GameRegistry.registerItem(SpiderRobotKit, "SpiderRobotKit");
        GameRegistry.registerItem(DeadStinkBug, "DeadStinkBug");
        GameRegistry.registerItem(DuctTape, "DuctTape");
        GameRegistry.registerItem(KrakenTooth, "KrakenTooth");
        GameRegistry.registerItem(TrexTooth, "TrexTooth");
        GameRegistry.registerItem(WormTooth, "WormTooth");
        GameRegistry.registerItem(EmperorScorpionScale, "EmperorScorpionScale");
        GameRegistry.registerItem(VortexEye, "VortexEye");
        GameRegistry.registerItem(WaterDragonScale, "WaterDragonScale");
        GameRegistry.registerItem(GreenGoo, "GreenGoo");

    }
}
