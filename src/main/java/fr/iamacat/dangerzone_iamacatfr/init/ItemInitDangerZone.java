package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.ItemIrukandjiArrow;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalShard;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.items.Acid;
import fr.iamacat.dangerzone_iamacatfr.items.BattleAxe;
import fr.iamacat.dangerzone_iamacatfr.items.BigBerthaSword;
import fr.iamacat.dangerzone_iamacatfr.items.BigHammer;
import fr.iamacat.dangerzone_iamacatfr.items.Blackheels;
import fr.iamacat.dangerzone_iamacatfr.items.ExperienceCatcher;
import fr.iamacat.dangerzone_iamacatfr.items.GameController;
import fr.iamacat.dangerzone_iamacatfr.items.InstantShelter;
import fr.iamacat.dangerzone_iamacatfr.items.InstantGarden;
import fr.iamacat.dangerzone_iamacatfr.items.Wrench;
import fr.iamacat.dangerzone_iamacatfr.items.WatterBall;
import fr.iamacat.dangerzone_iamacatfr.items.ThunderStaff;
import fr.iamacat.dangerzone_iamacatfr.materials.*;
import fr.iamacat.dangerzone_iamacatfr.util.ArmorMaterialModded;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import fr.iamacat.dangerzone_iamacatfr.util.ToolMaterialModded;
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

    public static Item NightmareSword;
    public static Item PoisonSword;
    public static Item RatSword;
    public static Item FairySword;
    public static Item InstantShelter;
    public static Item JumpyBugScale;
    public static Item LavaEel;
    public static Item SliceSword;
    public static Item AttitudeAdjuster;
    public static Item LaserCharge;
    public static Item SkateBow;
    public static Item ItemAcid;
    public static Item ItemIrukandjiArrow;
    public static Item BattleAxe;
    public static Item BigBerthaSword;
    public static Item BigHammer;
    public static Item Blackheels;
    public static Item Boots;
    public static Item DeadIrukandji;
    public static Item ExperienceCatcher;
    public static Item GameController;
    public static Item InstantGarden;
    public static Item Wrench;
    public static Item MantisClaw;
    public static Item NetherTracker;
    public static Item WaterBall;
    public static Item ThunderStaff;
    public static Item SunspotUrchin;
    public static Item AmethystSword;
    public static Item AmethystShovel;
    public static Item AmethystPickaxe;
    public static Item AmethystHoe;
    public static Item AmethystAxe;
    public static Item AmethystBoots;
    public static Item AmethystChestplate;
    public static Item AmethystHelmet;
    public static Item AmethystLeggings;

    public static Item TigersEyeSword;
    public static Item TigersEyeShovel;
    public static Item TigersEyePickaxe;
    public static Item TigersEyeHoe;
    public static Item TigersEyeAxe;
    public static Item TigersEyeBoots;
    public static Item TigersEyeChestplate;
    public static Item TigersEyeHelmet;
    public static Item TigersEyeLeggings;
    public static Item UltimateSword;
    public static Item UltimateShovel;
    public static Item UltimatePickaxe;
    public static Item UltimateHoe;
    public static Item UltimateAxe;
    public static Item UltimateBoots;
    public static Item UltimateChestplate;
    public static Item UltimateHelmet;
    public static Item UltimateLeggings;
    public static Item UltimateBow;
    public static Item UltimateFishingRod;

    public static Item RubySword;
    public static Item RubyShovel;
    public static Item RubyPickaxe;
    public static Item RubyHoe;
    public static Item RubyAxe;
    public static Item RubyBoots;
    public static Item RubyChestplate;
    public static Item RubyHelmet;
    public static Item RubyLeggings;
    public static Item EmeraldSword;
    public static Item EmeraldShovel;
    public static Item EmeraldPickaxe;
    public static Item EmeraldHoe;
    public static Item EmeraldAxe;
    public static Item EmeraldBoots;
    public static Item EmeraldChestplate;
    public static Item EmeraldHelmet;
    public static Item EmeraldLeggings;
    public static Item ExperienceSword;
    public static Item ExperienceBoots;
    public static Item ExperienceChestplate;
    public static Item ExperienceHelmet;
    public static Item ExperienceLeggings;

    public static Item KyaniteShovel;
    public static Item KyanitePickaxe;
    public static Item KyaniteHoe;
    public static Item KyaniteAxe;
    public static Item KyaniteSword;
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
        RatSword = new RatSword(ToolMaterialModded.RatMATERIAL).setUnlocalizedName("RatSword");
        PoisonSword = new PoisonSword(ToolMaterialModded.POISONMATERIAL).setUnlocalizedName("PoisonSword");
        NightmareSword = new NightmareSword(ToolMaterialModded.NIGHTMAREMATERIAL).setUnlocalizedName("NightmareSword");
        FairySword = new FairySword(ToolMaterialModded.FAIRYMATERIAL).setUnlocalizedName("FairySword");
        InstantShelter = new InstantShelter().setUnlocalizedName("InstantShelter");
        JumpyBugScale = new JumpyBugScale().setUnlocalizedName("JumpyBugScale");
        LavaEel = new LavaEel().setUnlocalizedName("LavaEel");
        SliceSword = new SliceSword(ToolMaterialModded.SLICEMATERIAL).setUnlocalizedName("SliceSword");
        AttitudeAdjuster = new AttitudeAdjuster(ToolMaterialModded.AttitudeAdjusterMaterial).setUnlocalizedName("AttitudeAdjuster");
        LaserCharge = new LaserCharge().setUnlocalizedName("RobotLaserCharge");
        SkateBow = new SkateBow().setUnlocalizedName("SkateBow");
        ItemAcid = new Acid().setUnlocalizedName("ItemAcid");
        ItemIrukandjiArrow = new ItemIrukandjiArrow().setUnlocalizedName("ItemIrukandjiArrow");
        BattleAxe = new BattleAxe(ToolMaterialModded.BATTLEAXE).setUnlocalizedName("BattleAxe");
        BigBerthaSword = new BigBerthaSword(ToolMaterialModded.BIGBERTHA).setUnlocalizedName("BigBerthaSword");
        BigHammer = new BigHammer(ToolMaterialModded.BIGHAMMER).setUnlocalizedName("BigHammer");
        Blackheels = new Blackheels().setUnlocalizedName("Blackheels");
        Boots = new Boots().setUnlocalizedName("Boots");
        DeadIrukandji = new DeadIrukandji().setUnlocalizedName("DeadIrukandji");
        ExperienceCatcher = new ExperienceCatcher().setUnlocalizedName("ExperienceCatcher");
        GameController = new GameController().setUnlocalizedName("GameController");
        InstantGarden = new InstantGarden().setUnlocalizedName("InstantGarden");
        Wrench = new Wrench().setUnlocalizedName("Wrench");
        MantisClaw = new MantisClaw(ToolMaterialModded.MantisClaw).setUnlocalizedName("MantisClaw");
        NetherTracker = new NetherTracker().setUnlocalizedName("NetherTracker");
        WaterBall = new WatterBall().setUnlocalizedName("WaterBall");
        ThunderStaff = new ThunderStaff().setUnlocalizedName("ThunderStaff");
        SunspotUrchin = new SunspotUrchin().setUnlocalizedName("SunspotUrchin");
        AmethystSword = new AmethystSword(ToolMaterialModded.AMETHYSTSword).setUnlocalizedName("AmethystSword");
        AmethystShovel = new AmethystShovel(ToolMaterialModded.AmethystSHovel).setUnlocalizedName("AmethystShovel");
        AmethystPickaxe = new AmethystPickaxe(ToolMaterialModded.AmethystPickaxe).setUnlocalizedName("AmethystPickaxe");
        AmethystHoe = new AmethystHoe(ToolMaterialModded.AmethystHoe).setUnlocalizedName("AmethystHoe");
        AmethystAxe = new AmethystAxe(ToolMaterialModded.AmethystAxe).setUnlocalizedName("AmethystAxe");
        AmethystBoots = new AmethystBoots(ArmorMaterialModded.AmethystBoots, 3, 3).setUnlocalizedName("AmethystBoots");
        AmethystChestplate = new AmethystChestplate(ArmorMaterialModded.AmethystChestplate, 1, 1).setUnlocalizedName("AmethystChestplate");
        AmethystHelmet = new AmethystHelmet(ArmorMaterialModded.AmethystHelmet, 0, 0).setUnlocalizedName("AmethystHelmet");
        AmethystLeggings = new AmethystLeggings(ArmorMaterialModded.AmethystLeggings, 2, 2).setUnlocalizedName("AmethystLeggings");
        TigersEyeSword = new TigersEyeSword(ToolMaterialModded.TigersEyeSword).setUnlocalizedName("TigersEyeSword");
        TigersEyeShovel = new TigersEyeShovel(ToolMaterialModded.TigersEyeSHovel).setUnlocalizedName("TigersEyeShovel");
        TigersEyePickaxe = new TigersEyePickaxe(ToolMaterialModded.TigersEyePickaxe).setUnlocalizedName("TigersEyePickaxe");
        TigersEyeHoe = new TigersEyeHoe(ToolMaterialModded.TigersEyetHoe).setUnlocalizedName("TigersEyeHoe");
        TigersEyeAxe = new TigersEyeAxe(ToolMaterialModded.TigersEyeAxe).setUnlocalizedName("TigersEyeAxe");
        TigersEyeBoots = new TigersEyeBoots(ArmorMaterialModded.TigersEyeBoots, 3, 3).setUnlocalizedName("TigersEyeBoots");
        TigersEyeChestplate = new TigersEyeChestplate(ArmorMaterialModded.TigersEyeChestplate, 1, 1).setUnlocalizedName("TigersEyeChestplate");
        TigersEyeHelmet = new TigersEyeHelmet(ArmorMaterialModded.TigersEyeHelmet, 0, 0).setUnlocalizedName("TigersEyeHelmet");
        TigersEyeLeggings = new TigersEyeLeggings(ArmorMaterialModded.TigersEyeLeggings, 2, 2).setUnlocalizedName("TigersEyeLeggings");
        UltimateSword = new UltimateSword(ToolMaterialModded.UltimateSword).setUnlocalizedName("UltimateSword");
        UltimateShovel = new UltimateShovel(ToolMaterialModded.UltimateShovel).setUnlocalizedName("UltimateShovel");
        UltimatePickaxe = new UltimatePickaxe(ToolMaterialModded.UltimatePickaxe).setUnlocalizedName("UltimatePickaxe");
        UltimateHoe = new UltimateHoe(ToolMaterialModded.UltimateHoe).setUnlocalizedName("UltimateHoe");
        UltimateAxe = new UltimateAxe(ToolMaterialModded.UltimateAxe).setUnlocalizedName("UltimateAxe");
        UltimateBoots = new UltimateBoots(ArmorMaterialModded.UltimateBoots, 3, 3).setUnlocalizedName("UltimateBoots");
        UltimateChestplate = new UltimateChestplate(ArmorMaterialModded.UltimateChestplate, 1, 1).setUnlocalizedName("UltimateChestplate");
        UltimateHelmet = new UltimateHelmet(ArmorMaterialModded.UltimateHelmet, 0, 0).setUnlocalizedName("UltimateHelmet");
        UltimateLeggings = new UltimateLeggings(ArmorMaterialModded.UltimateLeggings, 2, 2).setUnlocalizedName("UltimateLeggings");
        UltimateBow = new UltimateBow().setUnlocalizedName("UltimateBow");
        UltimateFishingRod = new UltimateFishingRod().setUnlocalizedName("UltimateFishingRod");
        RubySword = new RubySword(ToolMaterialModded.RubySword).setUnlocalizedName("RubySword");
        RubyShovel = new RubyShovel(ToolMaterialModded.RubyShovel).setUnlocalizedName("RubyShovel");
        RubyPickaxe = new RubyPickaxe(ToolMaterialModded.RubyPickaxe).setUnlocalizedName("RubyPickaxe");
        RubyHoe = new RubyHoe(ToolMaterialModded.RubyHoe).setUnlocalizedName("RubyHoe");
        RubyAxe = new RubyAxe(ToolMaterialModded.RubyAxe).setUnlocalizedName("RubyAxe");
        RubyBoots = new RubyBoots(ArmorMaterialModded.RubyBoots, 3, 3).setUnlocalizedName("RubyBoots");
        RubyChestplate = new RubyChestplate(ArmorMaterialModded.RubyChestplate, 1, 1).setUnlocalizedName("RubyChestplate");
        RubyHelmet = new RubyHelmet(ArmorMaterialModded.RubyHelmet, 0, 0).setUnlocalizedName("RubyHelmet");
        RubyLeggings = new RubyLeggings(ArmorMaterialModded.RubyLeggings, 2, 2).setUnlocalizedName("RubyLeggings");
        EmeraldSword = new EmeraldSword(ToolMaterialModded.EmeraldSword).setUnlocalizedName("EmeraldSword");
        EmeraldShovel = new EmeraldShovel(ToolMaterialModded.EmeraldShovel).setUnlocalizedName("EmeraldShovel");
        EmeraldPickaxe = new EmeraldPickaxe(ToolMaterialModded.EmeraldPickaxe).setUnlocalizedName("EmeraldPickaxe");
        EmeraldHoe = new EmeraldHoe(ToolMaterialModded.EmeraldHoe).setUnlocalizedName("EmeraldHoe");
        EmeraldAxe = new EmeraldAxe(ToolMaterialModded.EmeraldAxe).setUnlocalizedName("EmeraldAxe");
        EmeraldBoots = new EmeraldBoots(ArmorMaterialModded.EmeraldBoots, 3, 3).setUnlocalizedName("EmeraldBoots");
        EmeraldChestplate = new EmeraldChestplate(ArmorMaterialModded.EmeraldChestplate, 1, 1).setUnlocalizedName("EmeraldChestplate");
        EmeraldHelmet = new EmeraldHelmet(ArmorMaterialModded.EmeraldHelmet, 0, 0).setUnlocalizedName("EmeraldHelmet");
        EmeraldLeggings = new EmeraldLeggings(ArmorMaterialModded.EmeraldLeggings, 2, 2).setUnlocalizedName("EmeraldLeggings");
        ExperienceSword = new ExperienceSword(ToolMaterialModded.ExperienceSword).setUnlocalizedName("ExperienceSword");
        ExperienceBoots = new ExperienceBoots(ArmorMaterialModded.ExperienceBoots, 3, 3).setUnlocalizedName("ExperienceBoots");
        ExperienceChestplate = new ExperienceChestplate(ArmorMaterialModded.ExperienceChestplate, 1, 1).setUnlocalizedName("ExperienceChestplate");
        ExperienceHelmet = new ExperienceHelmet(ArmorMaterialModded.ExperienceHelmet, 0, 0).setUnlocalizedName("ExperienceHelmet");
        ExperienceLeggings = new ExperienceLeggings(ArmorMaterialModded.ExperienceLeggings, 2, 2).setUnlocalizedName("ExperienceLeggings");

        KyaniteSword = new KyaniteSword(ToolMaterialModded.KyaniteSword).setUnlocalizedName("KyaniteSword");
        KyaniteShovel = new KyaniteShovel(ToolMaterialModded.KyaniteShovel).setUnlocalizedName("KyaniteShovel");
        KyanitePickaxe = new KyanitePickaxe(ToolMaterialModded.KyanitePickaxe).setUnlocalizedName("KyanitePickaxe");
        KyaniteHoe = new KyaniteHoe(ToolMaterialModded.KyaniteHoe).setUnlocalizedName("KyaniteHoe");
        KyaniteAxe = new KyaniteAxe(ToolMaterialModded.KyaniteAxe).setUnlocalizedName("KyaniteAxe");
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
        GameRegistry.registerItem(NightmareSword, "NightmareSword");
        GameRegistry.registerItem(PoisonSword, "PoisonSword");
        GameRegistry.registerItem(RatSword, "RatSword");
        GameRegistry.registerItem(FairySword, "FairySword");
        GameRegistry.registerItem(InstantShelter, "InstantShelter");
        GameRegistry.registerItem(JumpyBugScale, "JumpyBugScale");
        GameRegistry.registerItem(LavaEel, "LavaEel");
        GameRegistry.registerItem(SliceSword, "SliceSword");
        GameRegistry.registerItem(AttitudeAdjuster, "AttitudeAdjuster");
        GameRegistry.registerItem(LaserCharge, "RobotLaserCharge");
        GameRegistry.registerItem(SkateBow, "SkateBow");
        GameRegistry.registerItem(ItemAcid, "ItemAcid");
        GameRegistry.registerItem(ItemIrukandjiArrow, "ItemIrukandjiArrow");
        GameRegistry.registerItem(BattleAxe, "BattleAxe");
        GameRegistry.registerItem(BigBerthaSword, "BigBerthaSword");
        GameRegistry.registerItem(BigHammer, "BigHammer");
        GameRegistry.registerItem(Blackheels, "Blackheels");
        GameRegistry.registerItem(Boots, "Boots");
        GameRegistry.registerItem(DeadIrukandji, "DeadIrukandji");
        GameRegistry.registerItem(ExperienceCatcher, "ExperienceCatcher");
        GameRegistry.registerItem(GameController, "GameController");
        GameRegistry.registerItem(InstantGarden, "InstantGarden");
        GameRegistry.registerItem(Wrench, "Wrench");
        GameRegistry.registerItem(MantisClaw, "MantisClaw");
        GameRegistry.registerItem(NetherTracker, "NetherTracker");
        GameRegistry.registerItem(WaterBall, "WaterBall");
        GameRegistry.registerItem(ThunderStaff, "ThunderStaff");
        GameRegistry.registerItem(SunspotUrchin, "SunspotUrchin");
        GameRegistry.registerItem(AmethystSword, "AmethystSword");
        GameRegistry.registerItem(AmethystShovel, "AmethystShovel");
        GameRegistry.registerItem(AmethystPickaxe, "AmethystPickaxe");
        GameRegistry.registerItem(AmethystHoe, "AmethystHoe");
        GameRegistry.registerItem(AmethystAxe, "AmethystAxe");
        GameRegistry.registerItem(AmethystBoots, "AmethystBoots");
        GameRegistry.registerItem(AmethystChestplate, "AmethystChestplate");
        GameRegistry.registerItem(AmethystHelmet, "AmethystHelmet");
        GameRegistry.registerItem(AmethystLeggings, "AmethystLeggings");
        GameRegistry.registerItem(TigersEyeSword, "TigersEyeSword");
        GameRegistry.registerItem(TigersEyeShovel, "TigersEyeShovel");
        GameRegistry.registerItem(TigersEyePickaxe, "TigersEyePickaxe");
        GameRegistry.registerItem(TigersEyeHoe, "TigersEyeHoe");
        GameRegistry.registerItem(TigersEyeAxe, "TigersEyeAxe");
        GameRegistry.registerItem(TigersEyeBoots, "TigersEyeBoots");
        GameRegistry.registerItem(TigersEyeChestplate, "TigersEyeChestplate");
        GameRegistry.registerItem(TigersEyeHelmet, "TigersEyeHelmet");
        GameRegistry.registerItem(TigersEyeLeggings, "TigersEyeLeggings");
        GameRegistry.registerItem(UltimateSword, "UltimateSword");
        GameRegistry.registerItem(UltimateShovel, "UltimateShovel");
        GameRegistry.registerItem(UltimatePickaxe, "UltimatePickaxe");
        GameRegistry.registerItem(UltimateHoe, "UltimateHoe");
        GameRegistry.registerItem(UltimateAxe, "UltimateAxe");
        GameRegistry.registerItem(UltimateBoots, "UltimateBoots");
        GameRegistry.registerItem(UltimateChestplate, "UltimateChestplate");
        GameRegistry.registerItem(UltimateHelmet, "UltimateHelmet");
        GameRegistry.registerItem(UltimateLeggings, "UltimateLeggings");
        GameRegistry.registerItem(UltimateBow, "UltimateBow");
        GameRegistry.registerItem(UltimateFishingRod, "UltimateFishingRod");
        GameRegistry.registerItem(RubySword, "RubySword");
        GameRegistry.registerItem(RubyShovel, "RubyShovel");
        GameRegistry.registerItem(RubyPickaxe, "RubyPickaxe");
        GameRegistry.registerItem(RubyHoe, "RubyHoe");
        GameRegistry.registerItem(RubyAxe, "RubyAxe");
        GameRegistry.registerItem(RubyBoots, "RubyBoots");
        GameRegistry.registerItem(RubyChestplate, "RubyChestplate");
        GameRegistry.registerItem(RubyHelmet, "RubyHelmet");
        GameRegistry.registerItem(RubyLeggings, "RubyLeggings");
        GameRegistry.registerItem(EmeraldSword, "EmeraldSword");
        GameRegistry.registerItem(EmeraldShovel, "EmeraldShovel");
        GameRegistry.registerItem(EmeraldPickaxe, "EmeraldPickaxe");
        GameRegistry.registerItem(EmeraldHoe, "EmeraldHoe");
        GameRegistry.registerItem(EmeraldAxe, "EmeraldAxe");
        GameRegistry.registerItem(EmeraldBoots, "EmeraldBoots");
        GameRegistry.registerItem(EmeraldChestplate, "EmeraldChestplate");
        GameRegistry.registerItem(EmeraldHelmet, "EmeraldHelmet");
        GameRegistry.registerItem(EmeraldLeggings, "EmeraldLeggings");
        GameRegistry.registerItem(ExperienceSword, "ExperienceSword");
        GameRegistry.registerItem(ExperienceBoots, "ExperienceBoots");
        GameRegistry.registerItem(ExperienceChestplate, "ExperienceChestplate");
        GameRegistry.registerItem(ExperienceHelmet, "ExperienceHelmet");
        GameRegistry.registerItem(ExperienceLeggings, "ExperienceLeggings");


        GameRegistry.registerItem(KyaniteSword, "KyaniteSword");
        GameRegistry.registerItem(KyaniteShovel, "KyaniteShovel");
        GameRegistry.registerItem(KyanitePickaxe, "KyanitePickaxe");
        GameRegistry.registerItem(KyaniteHoe, "KyaniteHoe");
        GameRegistry.registerItem(KyaniteAxe, "KyaniteAxe");
    }
}
