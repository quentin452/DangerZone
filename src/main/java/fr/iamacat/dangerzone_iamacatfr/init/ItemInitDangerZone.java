package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.ItemIrukandjiArrow;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalShard;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.materials.*;
import fr.iamacat.dangerzone_iamacatfr.util.ArmorMaterialModded;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import fr.iamacat.dangerzone_iamacatfr.util.ToolMaterialModded;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

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
    public static Item MyChainsaw;
    public static Item MyQueenBattleAxe;

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

    public static Item LapisBoots;
    public static Item LapisChestplate;
    public static Item LapisHelmet;
    public static Item LapisLeggings;
    public static Item LavaEelBoots;
    public static Item LavaEelChestplate;
    public static Item LavaEelHelmet;
    public static Item LavaEelLeggings;
    public static Item MobzillaBoots;
    public static Item MobzillaChestplate;
    public static Item MobzillaHelmet;
    public static Item MobzillaLeggings;
    public static Item MothScaleBoots;
    public static Item MothScaleChestplate;
    public static Item MothScaleHelmet;
    public static Item MothScaleLeggings;
    public static Item PeacockBoots;
    public static Item PeacockChestplate;
    public static Item PeacockHelmet;
    public static Item PeacockLeggings;
    public static Item PinkTourmalineBoots;
    public static Item PinkTourmalineChestplate;
    public static Item PinkTourmalineHelmet;
    public static Item PinkTourmalineLeggings;
    public static Item QueenBoots;
    public static Item QueenChestplate;
    public static Item QueenHelmet;
    public static Item QueenLeggings;
    public static Item RoyalBoots;
    public static Item RoyalChestplate;
    public static Item RoyalHelmet;
    public static Item RoyalLeggings;
    public static Item ExtraSmallZooCage;
    public static Item SmallZooCage;
    public static Item MediumZooCage;
    public static Item LargeZooCage;
    public static Item ExtraLargeZooCage;
    public static Item TheZooKeeper;
    public static Item SquidZooka;
    public static Item Slippers;
    public static Item rainbowOpalGem;
    public static Item rainbowOpalChunk;
    public static Item pureRainbowOpalGem;
    public static Item dragonMeat;
    public static Item dragonMeatCooked;
    public static Item mavisOrb;
    public static Item phoenixFeather;
    public static Item darkCrystal;
    public static Item twilightStar;
    public static Item Bertha;
    static Item.ToolMaterial toolBERTHA;

    public static Item royalsword;
    static Item.ToolMaterial toolRoyal;

    public static Item ItemAppleSeed;
    public static Item ItemButterflySeed;
    public static Item ItemCornCob;
    public static Item ItemCreeperLauncher;
    public static Item ItemCrystalSticks;
    public static Item Hoverboard;
    public static Item ItemExperienceTreeSeed;

    public static Item ItemFireflySeed;
    public static Item ItemIceBall;
    public static Item ItemIrukandji;
    public static Item ItemMosquitoSeed;
    public static Item ItemMothSeed;

    public static Item ItemRayGun;
    public static Item ItemRock;
    public static Item ItemShoes;
    public static Item ItemStrawberrySeed;
    public static Item KrakenRepellent;
    public static Item Lavafoam;
    public static Item LavaLovingItem;
    public static Item CrystalSword;
    public static Item MyBertha;
    public static Item MyHammy;
    public static Item MySlice;
    public static Item TitaniumNugget;
    public static Item UraniumNugget;
    public static Item CrystalPickaxe;
    public static Item CrystalAxe;
    public static Item ItemShoes1;
    public static Item ItemShoes2;
    public static Item ItemShoes3;
    public static Item CrystalShovel;
    public static Item CrystalHoe;
    static Item.ToolMaterial toolBATTLE;
    static Item.ToolMaterial toolQUEENBATTLE;
    public static Item MyCherrySeed;
    public static Item MyPeachSeed;

    public static Item MySmallRock;
    public static Item MyRock;
    public static Item MyRedRock;
    public static Item MyCrystalRedRock;
    public static Item MyCrystalGreenRock;
    public static Item MyCrystalBlueRock;
    public static Item MyCrystalTNTRock;
    public static Item MyBlueRock;
    public static Item MyGreenRock;
    public static Item MyPurpleRock;
    public static Item MySpikeyRock;
    public static Item MyTNTRock;

    static Item.ToolMaterial toolCRYSTALWOOD;
    static Item.ToolMaterial toolCRYSTALSTONE;
    static Item.ToolMaterial toolCRYSTALPINK;

    public static void init() {
        toolCRYSTALWOOD = EnumHelper.addToolMaterial(
            "CRYSTALWOOD",
            2,
            300,
            (float)3,
            (float)2,
           15);
      toolCRYSTALSTONE = EnumHelper.addToolMaterial(
            "CRYSTALSTONE",
          3,
           800,
            (float)6,
            (float)5,
      45);
      toolCRYSTALPINK = EnumHelper.addToolMaterial(
            "CRYSTALPINK",
            4,
           1100,
            (float) 10,
            (float)7,
            65);

        toolBERTHA = EnumHelper.addToolMaterial("BERTHA", 3, 9000, (float) 15, (float) 496, 100);
        toolRoyal = EnumHelper.addToolMaterial("ROYAL", 3, 10000, (float) 15, (float) 746, 150);
        toolBATTLE = EnumHelper.addToolMaterial(
            "BATTLE",
            3,
            1500,
            (float)15,
            (float) 46,
           75);
        toolQUEENBATTLE = EnumHelper.addToolMaterial(
            "QUEENBATTLE",
            3, 2200, (float )15, (float )662, 100);

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
        CrystalAppleItem = new CrystalApple().setUnlocalizedName("CrystalApple")
            .setTextureName(Tags.MODID + ":crystal_apple");
        MinersDream = new MinersDream(4).setUnlocalizedName("MinersDream");
        BasilicsScale = new BasilicsScale().setUnlocalizedName("BasiclicsScale");
        MobzillaScale = new MobzillaScale().setUnlocalizedName("MobzillaScale");
        MothScale = new MothScale().setUnlocalizedName("MothScale");
        MolenoidNose = new MolenoidNose().setUnlocalizedName("MolenoidNose");
        NightmareScale = new NightmareScale().setUnlocalizedName("NightmareScale");
        OmgMagicApple = new OmgMagicApple().setUnlocalizedName("OmgMagicApple")
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
        DuctTape ductTape = (fr.iamacat.dangerzone_iamacatfr.items.DuctTape) new DuctTape(Blocks.stone).setUnlocalizedName("DuctTape");
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
        AttitudeAdjuster = new AttitudeAdjuster(ToolMaterialModded.AttitudeAdjusterMaterial)
            .setUnlocalizedName("AttitudeAdjuster");
        LaserCharge = new LaserCharge().setUnlocalizedName("RobotLaserCharge");
        SkateBow = new SkateBow().setUnlocalizedName("SkateBow");
        ItemAcid = new Acid().setUnlocalizedName("ItemAcid");
        ItemIrukandjiArrow = new ItemIrukandjiArrow().setUnlocalizedName("ItemIrukandjiArrow");
        BattleAxe = new UltimateSword(toolBATTLE).setUnlocalizedName("BattleAxe");
        BigHammer = new BigHammer(ToolMaterialModded.BIGHAMMER).setUnlocalizedName("BigHammer");
        Blackheels = new ItemShoes(51,3).setUnlocalizedName("Blackheels");
        Boots = new Boots().setUnlocalizedName("Boots");
        ExperienceCatcher = new ExperienceCatcher().setUnlocalizedName("ExperienceCatcher");
        GameController = new ItemShoes(50, 2).setUnlocalizedName("GameController");
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
        AmethystChestplate = new AmethystChestplate(ArmorMaterialModded.AmethystChestplate, 1, 1)
            .setUnlocalizedName("AmethystChestplate");
        AmethystHelmet = new AmethystHelmet(ArmorMaterialModded.AmethystHelmet, 0, 0)
            .setUnlocalizedName("AmethystHelmet");
        AmethystLeggings = new AmethystLeggings(ArmorMaterialModded.AmethystLeggings, 2, 2)
            .setUnlocalizedName("AmethystLeggings");
        TigersEyeSword = new TigersEyeSword(ToolMaterialModded.TigersEyeSword).setUnlocalizedName("TigersEyeSword");
        TigersEyeShovel = new TigersEyeShovel(ToolMaterialModded.TigersEyeSHovel).setUnlocalizedName("TigersEyeShovel");
        TigersEyePickaxe = new TigersEyePickaxe(ToolMaterialModded.TigersEyePickaxe)
            .setUnlocalizedName("TigersEyePickaxe");
        TigersEyeHoe = new TigersEyeHoe(ToolMaterialModded.TigersEyetHoe).setUnlocalizedName("TigersEyeHoe");
        TigersEyeAxe = new TigersEyeAxe(ToolMaterialModded.TigersEyeAxe).setUnlocalizedName("TigersEyeAxe");
        TigersEyeBoots = new TigersEyeBoots(ArmorMaterialModded.TigersEyeBoots, 3, 3)
            .setUnlocalizedName("TigersEyeBoots");
        TigersEyeChestplate = new TigersEyeChestplate(ArmorMaterialModded.TigersEyeChestplate, 1, 1)
            .setUnlocalizedName("TigersEyeChestplate");
        TigersEyeHelmet = new TigersEyeHelmet(ArmorMaterialModded.TigersEyeHelmet, 0, 0)
            .setUnlocalizedName("TigersEyeHelmet");
        TigersEyeLeggings = new TigersEyeLeggings(ArmorMaterialModded.TigersEyeLeggings, 2, 2)
            .setUnlocalizedName("TigersEyeLeggings");
        UltimateSword = new UltimateSword(ToolMaterialModded.UltimateSword).setUnlocalizedName("UltimateSword");
        MyChainsaw = new UltimateSword(toolBATTLE).setUnlocalizedName("MyChainSaw");
        MyQueenBattleAxe = new UltimateSword(toolQUEENBATTLE).setUnlocalizedName("MyQueenBattleAxe");

        UltimateShovel = new UltimateShovel(ToolMaterialModded.UltimateShovel).setUnlocalizedName("UltimateShovel");
        UltimatePickaxe = new UltimatePickaxe(ToolMaterialModded.UltimatePickaxe).setUnlocalizedName("UltimatePickaxe");
        UltimateHoe = new UltimateHoe(ToolMaterialModded.UltimateHoe).setUnlocalizedName("UltimateHoe");
        UltimateAxe = new UltimateAxe(ToolMaterialModded.UltimateAxe).setUnlocalizedName("UltimateAxe");
        UltimateBoots = new UltimateBoots(ArmorMaterialModded.UltimateBoots, 3, 3).setUnlocalizedName("UltimateBoots");
        UltimateChestplate = new UltimateChestplate(ArmorMaterialModded.UltimateChestplate, 1, 1)
            .setUnlocalizedName("UltimateChestplate");
        UltimateHelmet = new UltimateHelmet(ArmorMaterialModded.UltimateHelmet, 0, 0)
            .setUnlocalizedName("UltimateHelmet");
        UltimateLeggings = new UltimateLeggings(ArmorMaterialModded.UltimateLeggings, 2, 2)
            .setUnlocalizedName("UltimateLeggings");
        UltimateBow = new UltimateBow().setUnlocalizedName("UltimateBow");
        UltimateFishingRod = new UltimateFishingRod().setUnlocalizedName("UltimateFishingRod");
        RubySword = new RubySword(ToolMaterialModded.RubySword).setUnlocalizedName("RubySword");
        RubyShovel = new RubyShovel(ToolMaterialModded.RubyShovel).setUnlocalizedName("RubyShovel");
        RubyPickaxe = new RubyPickaxe(ToolMaterialModded.RubyPickaxe).setUnlocalizedName("RubyPickaxe");
        RubyHoe = new RubyHoe(ToolMaterialModded.RubyHoe).setUnlocalizedName("RubyHoe");
        RubyAxe = new RubyAxe(ToolMaterialModded.RubyAxe).setUnlocalizedName("RubyAxe");
        RubyBoots = new RubyBoots(ArmorMaterialModded.RubyBoots, 3, 3).setUnlocalizedName("RubyBoots");
        RubyChestplate = new RubyChestplate(ArmorMaterialModded.RubyChestplate, 1, 1)
            .setUnlocalizedName("RubyChestplate");
        RubyHelmet = new RubyHelmet(ArmorMaterialModded.RubyHelmet, 0, 0).setUnlocalizedName("RubyHelmet");
        RubyLeggings = new RubyLeggings(ArmorMaterialModded.RubyLeggings, 2, 2).setUnlocalizedName("RubyLeggings");
        EmeraldSword = new EmeraldSword(ToolMaterialModded.EmeraldSword).setUnlocalizedName("EmeraldSword");
        EmeraldShovel = new EmeraldShovel(ToolMaterialModded.EmeraldShovel).setUnlocalizedName("EmeraldShovel");
        EmeraldPickaxe = new EmeraldPickaxe(ToolMaterialModded.EmeraldPickaxe).setUnlocalizedName("EmeraldPickaxe");
        EmeraldHoe = new EmeraldHoe(ToolMaterialModded.EmeraldHoe).setUnlocalizedName("EmeraldHoe");
        EmeraldAxe = new EmeraldAxe(ToolMaterialModded.EmeraldAxe).setUnlocalizedName("EmeraldAxe");
        EmeraldBoots = new EmeraldBoots(ArmorMaterialModded.EmeraldBoots, 3, 3).setUnlocalizedName("EmeraldBoots");
        EmeraldChestplate = new EmeraldChestplate(ArmorMaterialModded.EmeraldChestplate, 1, 1)
            .setUnlocalizedName("EmeraldChestplate");
        EmeraldHelmet = new EmeraldHelmet(ArmorMaterialModded.EmeraldHelmet, 0, 0).setUnlocalizedName("EmeraldHelmet");
        EmeraldLeggings = new EmeraldLeggings(ArmorMaterialModded.EmeraldLeggings, 2, 2)
            .setUnlocalizedName("EmeraldLeggings");
        ExperienceSword = new ExperienceSword(ToolMaterialModded.ExperienceSword).setUnlocalizedName("ExperienceSword");
        ExperienceBoots = new ExperienceBoots(ArmorMaterialModded.ExperienceBoots, 3, 3)
            .setUnlocalizedName("ExperienceBoots");
        ExperienceChestplate = new ExperienceChestplate(ArmorMaterialModded.ExperienceChestplate, 1, 1)
            .setUnlocalizedName("ExperienceChestplate");
        ExperienceHelmet = new ExperienceHelmet(ArmorMaterialModded.ExperienceHelmet, 0, 0)
            .setUnlocalizedName("ExperienceHelmet");
        ExperienceLeggings = new ExperienceLeggings(ArmorMaterialModded.ExperienceLeggings, 2, 2)
            .setUnlocalizedName("ExperienceLeggings");
        KyaniteSword = new KyaniteSword(ToolMaterialModded.KyaniteSword).setUnlocalizedName("KyaniteSword");
        KyaniteShovel = new KyaniteShovel(ToolMaterialModded.KyaniteShovel).setUnlocalizedName("KyaniteShovel");
        KyanitePickaxe = new KyanitePickaxe(ToolMaterialModded.KyanitePickaxe).setUnlocalizedName("KyanitePickaxe");
        KyaniteHoe = new KyaniteHoe(ToolMaterialModded.KyaniteHoe).setUnlocalizedName("KyaniteHoe");
        KyaniteAxe = new KyaniteAxe(ToolMaterialModded.KyaniteAxe).setUnlocalizedName("KyaniteAxe");
        LapisBoots = new LapisBoots(ArmorMaterialModded.LapisBoots, 3, 3).setUnlocalizedName("LapisBoots");
        LapisChestplate = new LapisChestplate(ArmorMaterialModded.LapisChestplate, 1, 1)
            .setUnlocalizedName("LapisChestplate");
        LapisHelmet = new LapisHelmet(ArmorMaterialModded.LapisHelmet, 0, 0).setUnlocalizedName("LapisHelmet");
        LapisLeggings = new LapisLeggings(ArmorMaterialModded.LapisLeggings, 2, 2).setUnlocalizedName("LapisLeggings");
        LavaEelBoots = new LavaEelBoots(ArmorMaterialModded.LavaEelBoots, 3, 3).setUnlocalizedName("LavaEelBoots");
        LavaEelChestplate = new LavaEelChestplate(ArmorMaterialModded.LavaEelChestplate, 1, 1)
            .setUnlocalizedName("LavaEelChestplate");
        LavaEelHelmet = new LavaEelHelmet(ArmorMaterialModded.LavaEelHelmet, 0, 0).setUnlocalizedName("LavaEelHelmet");
        LavaEelLeggings = new LavaEelLeggings(ArmorMaterialModded.LavaEelLeggings, 2, 2)
            .setUnlocalizedName("LavaEelLeggings");
        MobzillaBoots = new MobzillaBoots(ArmorMaterialModded.MobzillaBoots, 3, 3).setUnlocalizedName("MobzillaBoots");
        MobzillaChestplate = new MobzillaChestplate(ArmorMaterialModded.MobzillaChestplate, 1, 1)
            .setUnlocalizedName("MobzillaChestplate");
        MobzillaHelmet = new MobzillaHelmet(ArmorMaterialModded.MobzillaHelmet, 0, 0)
            .setUnlocalizedName("MobzillaHelmet");
        MobzillaLeggings = new MobzillaLeggings(ArmorMaterialModded.MobzillaLeggings, 2, 2)
            .setUnlocalizedName("MobzillaLeggings");
        MothScaleBoots = new MothScaleBoots(ArmorMaterialModded.MothScaleBoots, 3, 3)
            .setUnlocalizedName("MothScaleBoots");
        MothScaleChestplate = new MothScaleChestplate(ArmorMaterialModded.MothScaleChestplate, 1, 1)
            .setUnlocalizedName("MothScaleChestplate");
        MothScaleHelmet = new MothScaleHelmet(ArmorMaterialModded.MothScaleHelmet, 0, 0)
            .setUnlocalizedName("MothScaleHelmet");
        MothScaleLeggings = new MothScaleLeggings(ArmorMaterialModded.MothScaleLeggings, 2, 2)
            .setUnlocalizedName("MothScaleLeggings");
        PeacockBoots = new PeacockBoots(ArmorMaterialModded.PeacockBoots, 3, 3).setUnlocalizedName("PeacockBoots");
        PeacockChestplate = new PeacockChestplate(ArmorMaterialModded.PeacockChestplate, 1, 1)
            .setUnlocalizedName("PeacockChestplate");
        PeacockHelmet = new PeacockHelmet(ArmorMaterialModded.PeacockHelmet, 0, 0).setUnlocalizedName("PeacockHelmet");
        PeacockLeggings = new PeacockLeggings(ArmorMaterialModded.PeacockLeggings, 2, 2)
            .setUnlocalizedName("PeacockLeggings");
        PinkTourmalineBoots = new PinkTourmalineBoots(ArmorMaterialModded.PinktourmalineBoots, 3, 3)
            .setUnlocalizedName("PinkTourmalineBoots");
        PinkTourmalineChestplate = new PinkTourmalineChestplate(ArmorMaterialModded.PinktourmalineChestplate, 1, 1)
            .setUnlocalizedName("PinkTourmalineChestplate");
        PinkTourmalineHelmet = new PinkTourmalineHelmet(ArmorMaterialModded.PinktourmalineHelmet, 0, 0)
            .setUnlocalizedName("PinkTourmalineHelmet");
        PinkTourmalineLeggings = new PinkTourmalineLeggings(ArmorMaterialModded.PinktourmalineLeggings, 2, 2)
            .setUnlocalizedName("PinkTourmalineLeggings");
        QueenBoots = new QueenBoots(ArmorMaterialModded.QueenBoots, 3, 3).setUnlocalizedName("QueenBoots");
        QueenChestplate = new QueenChestplate(ArmorMaterialModded.QueenChestplate, 1, 1)
            .setUnlocalizedName("QueenChestplate");
        QueenHelmet = new QueenHelmet(ArmorMaterialModded.QueenHelmet, 0, 0).setUnlocalizedName("QueenHelmet");
        QueenLeggings = new QueenLeggings(ArmorMaterialModded.QueenLeggings, 2, 2).setUnlocalizedName("QueenLeggings");
        RoyalBoots = new RoyalBoots(ArmorMaterialModded.RoyalBoots, 3, 3).setUnlocalizedName("RoyalBoots");
        RoyalChestplate = new RoyalChestplate(ArmorMaterialModded.RoyalChestplate, 1, 1)
            .setUnlocalizedName("RoyalChestplate");
        RoyalHelmet = new RoyalChestplate(ArmorMaterialModded.RoyalHelmet, 0, 0).setUnlocalizedName("RoyalHelmet");
        RoyalLeggings = new RoyalLeggings(ArmorMaterialModded.RoyalLeggings, 2, 2).setUnlocalizedName("RoyalLeggings");
        ExtraSmallZooCage = new ExtraSmallZooCage().setUnlocalizedName("ExtraSmallZooCage");
        SmallZooCage = new SmallZooCage().setUnlocalizedName("SmallZooCage");
        MediumZooCage = new MediumZooCage().setUnlocalizedName("MediumZooCage");
        LargeZooCage = new LargeZooCage().setUnlocalizedName("LargeZooCage");
        ExtraLargeZooCage = new ExtraLargeZooCage().setUnlocalizedName("ExtraLargeZooCage");
        TheZooKeeper = new TheZooKeeper().setUnlocalizedName("TheZooKeeper");
        SquidZooka = new SquidZooka().setUnlocalizedName("SquidZooka");
        Slippers = new ItemShoes(5, 2).setUnlocalizedName("Slippers");
        mavisOrb = new MavisOrb().setTextureName(Tags.MODID + ":MavisOrb")
            .setUnlocalizedName("MavisOrb");
        phoenixFeather = new PhoenixFeather();
        darkCrystal = new DarkCrystal();
        twilightStar = new TwilightStar();
        Bertha = new Bertha(toolBERTHA).setUnlocalizedName("berthasmall");

        ItemAppleSeed = new ItemAppleSeed();
        ItemButterflySeed = new ItemButterflySeed(
            212,
            BlockInitDangerZone.BlockButterflyPlant,
            Blocks.farmland).setUnlocalizedName("butterfly_seed");
        ItemCornCob = new ItemCornCob(
            185,
            6,
            0.75f,
            BlockInitDangerZone.BlockCorn1,
            Blocks.farmland).setUnlocalizedName("corn_seed");
        ItemCreeperLauncher = new ItemCreeperLauncher();
        ItemCrystalSticks = new ItemCrystalSticks();
        Hoverboard = new Hoverboard();
        ItemExperienceTreeSeed = new ItemExperienceTreeSeed();
       ItemFireflySeed = new ItemFireflySeed(
            215,
            BlockInitDangerZone.BlockFireflyPlant,
            Blocks.farmland).setUnlocalizedName("firefly_seed");
        ItemIceBall = new ItemIceBall();
        ItemIrukandji = new ItemIrukandji();
       ItemMosquitoSeed = new ItemMosquitoSeed(
            214,
            BlockInitDangerZone.BlockMosquitoPlant,
            Blocks.farmland).setUnlocalizedName("mosquito_seed");
     ItemMothSeed = new ItemMothSeed(213,BlockInitDangerZone.BlockMothPlant,
            Blocks.farmland);
        ItemRayGun = new ItemRayGun(243).setUnlocalizedName("RayGun");
       BlueFish= new BlueFish();
       ItemShoes= new ItemShoes( 248, 2).setUnlocalizedName("redheels");

        ItemStrawberrySeed= new ItemStrawberrySeed(
         210,BlockInitDangerZone.BlockStrawberry, Blocks.farmland);
        KrakenRepellent = Item.getItemFromBlock(new KrakenRepellent());
        royalsword = new Bertha(toolRoyal);

        MyBertha = new Bertha(toolRoyal).setUnlocalizedName("berthasmall");
        MySlice = new Bertha(toolRoyal).setUnlocalizedName("slicesmall");
        royalsword = new Bertha(toolRoyal).setUnlocalizedName("royalsmall");
        MyHammy = new Bertha(toolRoyal).setUnlocalizedName("hammysmall");
       CrystalSword = new CrystalSword( 329, toolCRYSTALWOOD)
            .setUnlocalizedName("crystalwoodsword");
        TitaniumNugget = new TitaniumNugget();
        UraniumNugget = new UraniumNugget();
        CrystalPickaxe = new CrystalPickaxe(
          330,
           toolCRYSTALWOOD).setUnlocalizedName("crystalwoodpickaxe");
        CrystalShovel = new CrystalShovel(
             331,
           toolCRYSTALWOOD).setUnlocalizedName("crystalwoodshovel");
        CrystalAxe = new CrystalAxe(338, toolCRYSTALPINK);

       ItemShoes1 = new ItemShoes( 249, 3).setUnlocalizedName("blackheels");
       ItemShoes2 = new ItemShoes(250, 4).setUnlocalizedName("slippers");
        ItemShoes3 = new ItemShoes(251, 5).setUnlocalizedName("boots");
        CrystalHoe = new CrystalHoe(342,toolCRYSTALSTONE);

       MyCherrySeed = new ItemAppleSeed()
            .setUnlocalizedName("cherrytree_seed");
        MyPeachSeed = new ItemAppleSeed()
            .setUnlocalizedName("peachtree_seed");

       MySmallRock = new ItemRock().setUnlocalizedName("rocksmall");
        MyRock = new ItemRock().setUnlocalizedName("rock");
       MyRedRock = new ItemRock().setUnlocalizedName("rockred");
        MyCrystalRedRock = new ItemRock()
            .setUnlocalizedName("rockcrystalred");
       MyCrystalGreenRock = new ItemRock()
            .setUnlocalizedName("rockcrystalgreen");
      MyCrystalBlueRock = new ItemRock()
            .setUnlocalizedName("rockcrystalblue");
        MyCrystalTNTRock = new ItemRock()
            .setUnlocalizedName("rockcrystaltnt");
        MyGreenRock = new ItemRock().setUnlocalizedName("rockgreen");
       MyBlueRock = new ItemRock().setUnlocalizedName("rockblue");
       MyPurpleRock = new ItemRock().setUnlocalizedName("rockpurple");
       MySpikeyRock = new ItemRock().setUnlocalizedName("rockspikey");
       MyTNTRock = new ItemRock().setUnlocalizedName("rocktnt");
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
        GameRegistry.registerItem(LapisBoots, "LapisBoots");
        GameRegistry.registerItem(LapisChestplate, "LapisChestplate");
        GameRegistry.registerItem(LapisHelmet, "LapisHelmet");
        GameRegistry.registerItem(LapisLeggings, "LapisLeggings");
        GameRegistry.registerItem(LavaEelBoots, "LavaEelBoots");
        GameRegistry.registerItem(LavaEelChestplate, "LavaEelChestplate");
        GameRegistry.registerItem(LavaEelHelmet, "LavaEelHelmet");
        GameRegistry.registerItem(LavaEelLeggings, "LavaEelLeggings");
        GameRegistry.registerItem(MobzillaBoots, "MobzillaBoots");
        GameRegistry.registerItem(MobzillaChestplate, "MobzillaChestplate");
        GameRegistry.registerItem(MobzillaHelmet, "MobzillaHelmet");
        GameRegistry.registerItem(MobzillaLeggings, "MobzillaLeggings");
        GameRegistry.registerItem(MothScaleBoots, "MothScaleBoots");
        GameRegistry.registerItem(MothScaleChestplate, "MothScaleChestplate");
        GameRegistry.registerItem(MothScaleHelmet, "MothScaleHelmet");
        GameRegistry.registerItem(MothScaleLeggings, "MothScaleLeggings");
        GameRegistry.registerItem(PeacockBoots, "PeacockBoots");
        GameRegistry.registerItem(PeacockChestplate, "PeacockChestplate");
        GameRegistry.registerItem(PeacockHelmet, "PeacockHelmet");
        GameRegistry.registerItem(PeacockLeggings, "PeacockLeggings");
        GameRegistry.registerItem(PinkTourmalineBoots, "PinkTourmalineBoots");
        GameRegistry.registerItem(PinkTourmalineChestplate, "PinkTourmalineChestplate");
        GameRegistry.registerItem(PinkTourmalineHelmet, "PinkTourmalineHelmet");
        GameRegistry.registerItem(PinkTourmalineLeggings, "PinkTourmalineLeggings");
        GameRegistry.registerItem(QueenBoots, "QueenBoots");
        GameRegistry.registerItem(QueenChestplate, "QueenChestplate");
        GameRegistry.registerItem(QueenHelmet, "QueenHelmet");
        GameRegistry.registerItem(QueenLeggings, "QueenLeggings");
        GameRegistry.registerItem(RoyalBoots, "RoyalBoots");
        GameRegistry.registerItem(RoyalChestplate, "RoyalChestplate");
        GameRegistry.registerItem(RoyalHelmet, "RoyalHelmet");
        GameRegistry.registerItem(RoyalLeggings, "RoyalLeggings");
        GameRegistry.registerItem(ExtraSmallZooCage, "ExtraSmallZooCage");
        GameRegistry.registerItem(SmallZooCage, "SmallZooCage");
        GameRegistry.registerItem(MediumZooCage, "MediumZooCage");
        GameRegistry.registerItem(LargeZooCage, "LargeZooCage");
        GameRegistry.registerItem(ExtraLargeZooCage, "ExtraLargeZooCage");
        GameRegistry.registerItem(TheZooKeeper, "TheZooKeeper");
        GameRegistry.registerItem(SquidZooka, "SquidZooka");
        GameRegistry.registerItem(Slippers, "Slippers");
        GameRegistry.registerItem(mavisOrb, "MavisOrb");
        GameRegistry.registerItem(phoenixFeather, "phoenixFeather");
        GameRegistry.registerItem(darkCrystal, "darkCrystal");
        GameRegistry.registerItem(twilightStar, "twilightStar");
        GameRegistry.registerItem(Bertha, "Bertha");
        GameRegistry.registerItem(ItemAppleSeed, "ItemAppleSeed");
        GameRegistry.registerItem(ItemButterflySeed, "ItemButterflySeed");
        GameRegistry.registerItem(ItemCornCob, "ItemCornCob");
        GameRegistry.registerItem(ItemCreeperLauncher, "ItemCreeperLauncher");
        GameRegistry.registerItem(ItemCrystalSticks, "ItemCrystalSticks");
        GameRegistry.registerItem(Hoverboard, "Hoverboard");
        GameRegistry.registerItem(ItemExperienceTreeSeed, "ItemExperienceTreeSeed");
        GameRegistry.registerItem(ItemFireflySeed, "ItemFireflySeed");
        GameRegistry.registerItem(ItemIceBall, "ItemIceBall");
        GameRegistry.registerItem(ItemIrukandji, "ItemIrukandji");
        GameRegistry.registerItem(ItemMosquitoSeed, "ItemMosquitoSeed");
        GameRegistry.registerItem(ItemMothSeed, "ItemMothSeed");
        GameRegistry.registerItem(ItemRayGun, "ItemRayGun");
        GameRegistry.registerItem(ItemRock, "ItemRock");
        GameRegistry.registerItem(ItemShoes, "ItemShoes");
        GameRegistry.registerItem(ItemStrawberrySeed, "ItemStrawberrySeed");
        GameRegistry.registerItem(KrakenRepellent, "KrakenRepellent");
        GameRegistry.registerItem(royalsword, "royalsword");
        GameRegistry.registerItem(LavaLovingItem, "LavaLovingItem");
        GameRegistry.registerItem(CrystalSword, "CrystalSword");
        GameRegistry.registerItem(MyBertha, "MyBertha");
        GameRegistry.registerItem(MyHammy, "MyHammy");
        GameRegistry.registerItem(MySlice, "MySlice");
        GameRegistry.registerItem(TitaniumNugget, "TitaniumNugget");
        GameRegistry.registerItem(UraniumNugget, "UraniumNugget");
        GameRegistry.registerItem(CrystalPickaxe, "CrystalPickaxe");
        GameRegistry.registerItem(CrystalAxe, "CrystalAxe");
        GameRegistry.registerItem(ItemShoes1, "ItemShoes1");
        GameRegistry.registerItem(ItemShoes2, "ItemShoes2");
        GameRegistry.registerItem(ItemShoes, "ItemShoes3");
        GameRegistry.registerItem(CrystalShovel, "CrystalShovel");
        GameRegistry.registerItem(MyChainsaw, "MyChainsaw");
        GameRegistry.registerItem(MyQueenBattleAxe, "MyQueenBattleAxe");
        GameRegistry.registerItem(MyCherrySeed, "MyCherrySeed");
        GameRegistry.registerItem(MyPeachSeed, "MyPeachSeed");
        GameRegistry.registerItem(MySmallRock, "OreSpawn_SmallRock");
        GameRegistry.registerItem(MyRock, "OreSpawn_Rock");
        GameRegistry.registerItem(MyRedRock, "OreSpawn_RedRock");
        GameRegistry.registerItem(MyCrystalRedRock, "OreSpawn_CrystalRedRock");
        GameRegistry.registerItem(MyCrystalGreenRock, "OreSpawn_CrystalGreenRock");
        GameRegistry.registerItem(MyCrystalBlueRock, "OreSpawn_CrystalBlueRock");
        GameRegistry.registerItem(MyCrystalTNTRock, "OreSpawn_CrystalTNTRock");
        GameRegistry.registerItem(MyGreenRock, "OreSpawn_GreenRock");
        GameRegistry.registerItem(MyBlueRock, "OreSpawn_BlueRock");
        GameRegistry.registerItem(MyPurpleRock, "OreSpawn_PurpleRock");
        GameRegistry.registerItem(MySpikeyRock, "OreSpawn_SpikeyRock");
        GameRegistry.registerItem(MyTNTRock, "OreSpawn_TNTRock");

    }
}
