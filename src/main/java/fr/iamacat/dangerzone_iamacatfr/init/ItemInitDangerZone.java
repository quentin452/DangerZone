package fr.iamacat.dangerzone_iamacatfr.init;

import net.minecraft.item.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalShard;
import fr.iamacat.dangerzone_iamacatfr.materials.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

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
    public static Item RawBacon;
    public static Item Peach;
    public static Item CookedBacon;
    public static Item RawPeacock;
    public static Item CookedPeacock;
    public static Item BltSandwitch;
    public static Item PinkFish;
    public static Item BlueFish;
    public static Item Pizza;
    public static Item Butter;
    public static Item PopCorn;
    public static Item ButterCandy;
    public static Item ButteredPopcorn;
    public static Item Cheese;
    public static Item ButteredandSaltedPopcorn;
    public static Item Cherries;
    public static Item PopCornBag;
    public static Item Corn;
    public static Item RawCornDog;
    public static Item Quinoa;
    public static Item Radish;
    public static Item CookedCornDog;
    public static Item Rice;
    public static Item CrabMeat;
    public static Item RockFish;
    public static Item CookedCrabMeat;
    public static Item Salad;
    public static Item CrabbyPatty;
    public static Item Salt;
    public static Item SparkFish;
    public static Item FireFish;
    public static Item Strawberry;
    public static Item SunFish;
    public static Item GreyFish;
    public static Item GreenFish;
    public static Item Tomato;
    public static Item Lettuce;
    public static Item WoodFish;

    public static Item AmethystIngot;
    public static Item TigersEyeIngot;
    public static Item TitaniumIngot;
    public static Item UraniumIngot;
    public static Item RubyIngot;

    public static Item StairsAcross;
    public static Item StairsUp;
    public static Item StairsDown;

    public static void init() {
        CrystalAppleItem = new CrystalApple().setUnlocalizedName("CrystalApple")
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
        RawBacon = new RawBacon().setUnlocalizedName("RawBacon");
        Peach = new Peach().setUnlocalizedName("Peach");
        CookedBacon = new CookedBacon().setUnlocalizedName("CookedBacon");
        RawPeacock = new RawPeacock().setUnlocalizedName("RawPeacock");
        CookedPeacock = new CookedPeacock().setUnlocalizedName("CookedPeacock");
        BltSandwitch = new BLTSandwich().setUnlocalizedName("BltSandwitch");
        PinkFish = new PinkFish().setUnlocalizedName("PinkFish");
        BlueFish = new BlueFish().setUnlocalizedName("BlueFish");
        Pizza = new Pizza().setUnlocalizedName("Pizza");
        Butter = new Butter().setUnlocalizedName("Butter");
        PopCorn = new Popcorn().setUnlocalizedName("PopCorn");
        ButterCandy = new ButterCandy().setUnlocalizedName("ButterCandy");
        ButteredPopcorn = new ButteredPopcorn().setUnlocalizedName("ButteredPopcorn");
        Cheese = new Cheese().setUnlocalizedName("Cheese");
        ButteredandSaltedPopcorn = new ButteredandSaltedPopcorn().setUnlocalizedName("ButteredandSaltedPopcorn");
        Cherries = new Cherries().setUnlocalizedName("Cherries");
        PopCornBag = new PopCornBag().setUnlocalizedName("PopCornBag");
        Corn = new Corn().setUnlocalizedName("Corn");
        RawCornDog = new RawCornDog().setUnlocalizedName("RawCornDog");
        Quinoa = new Quinoa().setUnlocalizedName("Quinoa");
        Radish = new Radish().setUnlocalizedName("Radish");
        CookedCornDog = new CookedCornDog().setUnlocalizedName("CookedCornDog");
        Rice = new Rice().setUnlocalizedName("Rice");
        CrabMeat = new CrabMeat().setUnlocalizedName("CrabMeat");
        RockFish = new RockFish().setUnlocalizedName("RockFish");
        CookedCrabMeat = new CookedCrabMeat().setUnlocalizedName("CookedCrabMeat");
        Salad = new Salad().setUnlocalizedName("Salad");
        CrabbyPatty = new CrabbyPatty().setUnlocalizedName("CrabbyPatty");
        Salt = new Salt().setUnlocalizedName("Salt");
        SparkFish = new SparkFish().setUnlocalizedName("SparkFish");
        FireFish = new FireFish().setUnlocalizedName("FireFish");
        Strawberry = new Strawberry().setUnlocalizedName("Strawberry");
        SunFish = new SunFish().setUnlocalizedName("SunFish");
        GreyFish = new GreyFish().setUnlocalizedName("GreyFish");
        GreenFish = new GreenFish().setUnlocalizedName("GreenFish");
        Tomato = new Tomato().setUnlocalizedName("Tomato");
        Lettuce = new Lettuce().setUnlocalizedName("Lettuce");
        WoodFish = new WoodFish().setUnlocalizedName("WoodFish");
        AmethystIngot = new AmethystIngot().setUnlocalizedName("AmethystIngot");
        TigersEyeIngot = new TigersEyeIngot().setUnlocalizedName("TigersEyeIngot");
        TitaniumIngot = new TitaniumIngot().setUnlocalizedName("TitaniumIngot");
        UraniumIngot = new UraniumIngot().setUnlocalizedName("UraniumIngot");
        RubyIngot = new RubyIngot().setUnlocalizedName("RubyIngot");
        StairsAcross = new StairsAcross().setUnlocalizedName("StairsAcross");
        StairsUp = new StairsUp().setUnlocalizedName("StairsUp");
        StairsDown = new StairsDown().setUnlocalizedName("StairsDown");

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
        GameRegistry.registerItem(RawBacon, "RawBacon");
        GameRegistry.registerItem(Peach, "Peach");
        GameRegistry.registerItem(CookedBacon, "CookedBacon");
        GameRegistry.registerItem(RawPeacock, "RawPeacock");
        GameRegistry.registerItem(CookedPeacock, "CookedPeacock");
        GameRegistry.registerItem(BltSandwitch, "BltSandwitch");
        GameRegistry.registerItem(PinkFish, "PinkFish");
        GameRegistry.registerItem(BlueFish, "BlueFish");
        GameRegistry.registerItem(Pizza, "Pizza");
        GameRegistry.registerItem(Butter, "Butter");
        GameRegistry.registerItem(PopCorn, "PopCorn");
        GameRegistry.registerItem(ButterCandy, "ButterCandy");
        GameRegistry.registerItem(ButteredPopcorn, "ButteredPopcorn");
        GameRegistry.registerItem(Cheese, "Cheese");
        GameRegistry.registerItem(ButteredandSaltedPopcorn, "ButteredandSaltedPopcorn");
        GameRegistry.registerItem(Cherries, "Cherries");
        GameRegistry.registerItem(PopCornBag, "PopCornBag");
        GameRegistry.registerItem(Corn, "Corn");
        GameRegistry.registerItem(RawCornDog, "RawCornDog");
        GameRegistry.registerItem(Quinoa, "Quinoa");
        GameRegistry.registerItem(Radish, "Radish");
        GameRegistry.registerItem(CookedCornDog, "CookedCornDog");
        GameRegistry.registerItem(Rice, "Rice");
        GameRegistry.registerItem(CrabMeat, "CrabMeat");
        GameRegistry.registerItem(RockFish, "RockFish");
        GameRegistry.registerItem(CookedCrabMeat, "CookedCrabMeat");
        GameRegistry.registerItem(Salad, "Salad");
        GameRegistry.registerItem(CrabbyPatty, "CrabbyPatty");
        GameRegistry.registerItem(Salt, "Salt");
        GameRegistry.registerItem(SparkFish, "SparkFish");
        GameRegistry.registerItem(FireFish, "FireFish");
        GameRegistry.registerItem(Strawberry, "Strawberry");
        GameRegistry.registerItem(SunFish, "SunFish");
        GameRegistry.registerItem(GreyFish, "GreyFish");
        GameRegistry.registerItem(GreenFish, "GreenFish");
        GameRegistry.registerItem(Tomato, "Tomato");
        GameRegistry.registerItem(Lettuce, "Lettuce");
        GameRegistry.registerItem(WoodFish, "WoodFish");
        GameRegistry.registerItem(AmethystIngot, "AmethystIngot");
        GameRegistry.registerItem(TigersEyeIngot, "TigersEyeIngot");
        GameRegistry.registerItem(TitaniumIngot, "TitaniumIngot");
        GameRegistry.registerItem(UraniumIngot, "UraniumIngot");
        GameRegistry.registerItem(RubyIngot, "RubyIngot");
        GameRegistry.registerItem(StairsAcross, "StairsAcross");
        GameRegistry.registerItem(StairsUp, "StairsUp");
        GameRegistry.registerItem(StairsDown, "StairsDown");

    }
}
