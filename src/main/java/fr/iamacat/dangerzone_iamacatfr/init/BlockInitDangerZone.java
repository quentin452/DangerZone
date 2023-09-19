package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.blocks.*;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.materials.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockInitDangerZone {

    public static Block EnderPearlBlock;
    public static Block blocktorch;
    public static Block BrownAntNest;
    public static Block RainbowAntNest;
    public static Block RedAntNest;
    public static Block UnstablenAntNest;
    public static Block TermiteNest;
    public static Block CreeperRepellent;
    public static Block CrystalWorkbench;
    public static Block ContainerCrystalFurnaceBlock;

    public static Block ContainerCrystalFurnaceOnBlock;

    public static Block AmethystBlock;
    public static Block TigersEyeBlock;
    public static Block RubyBlock;
    public static Block TitaniumBlock;
    public static Block UraniumBlock;
    public static Block PinkTourmalineBlock;

    public static Block AmethystBlockOre;
    public static Block TigersEyeBlockOre;
    public static Block RubyBlockOre;
    public static Block TitaniumBlockOre;
    public static Block UraniumBlockOre;
    public static Block CrystalTorch;
    public static Block TeleportBlock;

    public static Block MobzillaScaleBlock;
    public static Block EyeOfEnderBlock;
    public static Block SaltOre;
    public static Block CrystalStone;
    public static Block RockBlock;
    public static Block CrystalGrass;
    public static Block CrystalWood;

    public static Block BlockAppleLeaves;

    public static Block BlockButterflyPlant;
    public static Block BlockCorn1;
    public static Block BlockCorn2;
    public static Block BlockCorn3;
    public static Block BlockCorn4;
    public static Block BlockCrystalLeaves;
    public static Block BlockCrystalLeaves2;

    public static Block BlockCrystalLeaves3;

    public static Block BlockCrystalPlant;
    public static Block BlockCrystalPlant2;

    public static Block BlockCrystalPlant3;

    public static Block BlockCrystalTreeLog;
    public static Block BlockDuctTape;
    public static Block BlockDuplicatorLog;
    public static Block BlockExperienceLeaves;
    public static Block BlockExperiencePlant;

    public static Block BlockFireflyPlant;
    public static Block BlockLettuce1;
    public static Block BlockLettuce2;

    public static Block BlockLettuce3;

    public static Block BlockLettuce4;

    public static Block BlockMosquitoPlant;
    public static Block BlockMothPlant;
    public static Block BlockPizza;
    public static Block BlockQuinoa1;
    public static Block BlockQuinoa2;

    public static Block BlockQuinoa3;

    public static Block BlockQuinoa4;

    public static Block BlockRadish;
    public static Block BlockRice;
    public static Block BlockScaryLeaves;
    public static Block BlockScaryLeaves2;
    public static Block BlockScaryLeaves3;

    public static Block BlockSkyTreeLog;

    public static Block BlockStrawberry;
    public static Block BlockTomato1;
    public static Block BlockTomato2;
    public static Block BlockTomato3;
    public static Block BlockTomato4;

    public static Block CrystalTermiteBlock;
    public static Block DungeonSpawnerBlock;
    public static Block IslandBlock;
    public static Block KingSpawnerBlock;
    public static Block MoleDirtBlock;
    public static Block MyFlowerPinkBlock;
    public static Block MyFlowerBlackBlock;
    public static Block MyFlowerBlueBlock;
    public static Block MyFlowerScaryBlock;

    public static Block OreBasicStone;
    public static Block CrystalCoal;
    public static Block OreCrystalCrystal;
    public static Block OreGenericEgg;
    public static Block OreSalt;
    public static Block OreTitanium;
    public static Block OreUranium;
    public static Block PortalBlock;
    public static Block QueenSpawnerBlock;
    public static Block KrakenRepellent;
    public static Block CrystalRat;
    public static Block CrystalFairy;
    public static Block TrollBlock1;
    public static Block TermiteTroll;
    public static Block CrystalFlowerRedBlock;
    public static Block CrystalFlowerYellowBlock;
    public static Block Lavafoam;

    public static OreGenericEgg WaterDragonSpawnBlock;
    public static OreGenericEgg EnderKnightSpawnBlock;
    public static OreGenericEgg EnderReaperSpawnBlock;
    public static OreGenericEgg EnderManSpawnBlock;
    public static OreGenericEgg EnderDragonSpawnBlock;

    public static OreGenericEgg MySpiderSpawnBlock;
    public static OreGenericEgg MyBatSpawnBlock;
    public static OreGenericEgg MyCowSpawnBlock;
    public static OreGenericEgg MyPigSpawnBlock;
    public static OreGenericEgg MySquidSpawnBlock;
    public static OreGenericEgg MyChickenSpawnBlock;
    public static OreGenericEgg MyCreeperSpawnBlock;
    public static OreGenericEgg MySkeletonSpawnBlock;
    public static OreGenericEgg MyZombieSpawnBlock;
    public static OreGenericEgg MySlimeSpawnBlock;
    public static OreGenericEgg MyGhastSpawnBlock;
    public static OreGenericEgg MyZombiePigmanSpawnBlock;
    public static OreGenericEgg MyEndermanSpawnBlock;
    public static OreGenericEgg MyCaveSpiderSpawnBlock;
    public static OreGenericEgg MySilverfishSpawnBlock;
    public static OreGenericEgg MyMagmaCubeSpawnBlock;
    public static OreGenericEgg MyWitchSpawnBlock;
    public static OreGenericEgg MySheepSpawnBlock;
    public static OreGenericEgg MyWolfSpawnBlock;
    public static OreGenericEgg MyMooshroomSpawnBlock;
    public static OreGenericEgg MyOcelotSpawnBlock;
    public static OreGenericEgg MyBlazeSpawnBlock;
    public static OreGenericEgg MyWitherSkeletonSpawnBlock;
    public static OreGenericEgg MyEnderDragonSpawnBlock;
    public static OreGenericEgg MySnowGolemSpawnBlock;
    public static OreGenericEgg MyIronGolemSpawnBlock;
    public static OreGenericEgg MyWitherBossSpawnBlock;
    public static OreGenericEgg MyGirlfriendSpawnBlock;
    public static OreGenericEgg MyBoyfriendSpawnBlock;
    public static OreGenericEgg MyRedCowSpawnBlock;
    public static OreGenericEgg MyCrystalCowSpawnBlock;
    public static OreGenericEgg MyVillagerSpawnBlock;
    public static OreGenericEgg MyGoldCowSpawnBlock;
    public static OreGenericEgg MyEnchantedCowSpawnBlock;
    public static OreGenericEgg MyMOTHRASpawnBlock;
    public static OreGenericEgg MyAloSpawnBlock;
    public static OreGenericEgg MyCryoSpawnBlock;
    public static OreGenericEgg MyCamaSpawnBlock;
    public static OreGenericEgg MyVeloSpawnBlock;
    public static OreGenericEgg MyHydroSpawnBlock;
    public static OreGenericEgg MyBasilSpawnBlock;
    public static OreGenericEgg MyDragonflySpawnBlock;
    public static OreGenericEgg MyEmperorScorpionSpawnBlock;
    public static OreGenericEgg MyScorpionSpawnBlock;
    public static OreGenericEgg MyCaveFisherSpawnBlock;
    public static OreGenericEgg MySpyroSpawnBlock;
    public static OreGenericEgg MyBaryonyxSpawnBlock;
    public static OreGenericEgg MyGammaMetroidSpawnBlock;
    public static OreGenericEgg MyCockateilSpawnBlock;
    public static OreGenericEgg MyKyuubiSpawnBlock;
    public static OreGenericEgg MyAlienSpawnBlock;
    public static OreGenericEgg MyAttackSquidSpawnBlock;
    public static OreGenericEgg MyWaterDragonSpawnBlock;
    public static OreGenericEgg MyKrakenSpawnBlock;
    public static OreGenericEgg MyLizardSpawnBlock;
    public static OreGenericEgg MyCephadromeSpawnBlock;
    public static OreGenericEgg MyDragonSpawnBlock;
    public static OreGenericEgg MyBeeSpawnBlock;
    public static OreGenericEgg MyHorseSpawnBlock;
    public static OreGenericEgg MyTrooperBugSpawnBlock;
    public static OreGenericEgg MySpitBugSpawnBlock;
    public static OreGenericEgg MyStinkBugSpawnBlock;
    public static OreGenericEgg MyOstrichSpawnBlock;
    public static OreGenericEgg MyGazelleSpawnBlock;
    public static OreGenericEgg MyChipmunkSpawnBlock;
    public static OreGenericEgg MyCreepingHorrorSpawnBlock;
    public static OreGenericEgg MyTerribleTerrorSpawnBlock;
    public static OreGenericEgg MyCliffRacerSpawnBlock;
    public static OreGenericEgg MyTriffidSpawnBlock;
    public static OreGenericEgg MyPitchBlackSpawnBlock;
    public static OreGenericEgg MyLurkingTerrorSpawnBlock;
    public static OreGenericEgg MyGodzillaPartSpawnBlock;
    public static OreGenericEgg MyGodzillaSpawnBlock;
    public static OreGenericEgg MyTheKingPartSpawnBlock;
    public static OreGenericEgg MyTheQueenPartSpawnBlock;
    public static OreGenericEgg MyTheKingSpawnBlock;
    public static OreGenericEgg MyTheQueenSpawnBlock;
    public static OreGenericEgg MySmallWormSpawnBlock;
    public static OreGenericEgg MyMediumWormSpawnBlock;
    public static OreGenericEgg MyLargeWormSpawnBlock;
    public static OreGenericEgg MyCassowarySpawnBlock;
    public static OreGenericEgg MyCloudSharkSpawnBlock;
    public static OreGenericEgg MyGoldFishSpawnBlock;
    public static OreGenericEgg MyLeafMonsterSpawnBlock;
    public static OreGenericEgg MyTshirtSpawnBlock;
    public static OreGenericEgg MyEnderKnightSpawnBlock;
    public static OreGenericEgg MyEnderReaperSpawnBlock;
    public static OreGenericEgg MyBeaverSpawnBlock;
    public static OreGenericEgg MyUrchinSpawnBlock;
    public static OreGenericEgg MyFlounderSpawnBlock;
    public static OreGenericEgg MySkateSpawnBlock;
    public static OreGenericEgg MyRotatorSpawnBlock;
    public static OreGenericEgg MyPeacockSpawnBlock;
    public static OreGenericEgg MyFairySpawnBlock;
    public static OreGenericEgg MyDungeonBeastSpawnBlock;
    public static OreGenericEgg MyVortexSpawnBlock;
    public static OreGenericEgg MyRatSpawnBlock;
    public static OreGenericEgg MyWhaleSpawnBlock;
    public static OreGenericEgg MyIrukandjiSpawnBlock;
    public static OreGenericEgg MyTRexSpawnBlock;
    public static OreGenericEgg MyHerculesSpawnBlock;
    public static OreGenericEgg MyMantisSpawnBlock;
    public static OreGenericEgg MyStinkySpawnBlock;
    public static OreGenericEgg MyEasterBunnySpawnBlock;
    public static OreGenericEgg MyCaterKillerSpawnBlock;
    public static OreGenericEgg MyMolenoidSpawnBlock;
    public static OreGenericEgg MySeaMonsterSpawnBlock;
    public static OreGenericEgg MySeaViperSpawnBlock;
    public static OreGenericEgg MyLeonSpawnBlock;
    public static OreGenericEgg MyHammerheadSpawnBlock;
    public static OreGenericEgg MyRubberDuckySpawnBlock;
    public static OreGenericEgg MyCriminalSpawnBlock;
    public static OreGenericEgg MyBrutalflySpawnBlock;
    public static OreGenericEgg MyNastysaurusSpawnBlock;
    public static OreGenericEgg MyPointysaurusSpawnBlock;
    public static OreGenericEgg MyCricketSpawnBlock;
    public static OreGenericEgg MyFrogSpawnBlock;
    public static OreGenericEgg MySpiderDriverSpawnBlock;
    public static OreGenericEgg MyCrabSpawnBlock;
    public static Block CrystalFlowerGreenBlock;
    public static Block CrystalFlowerBlueBlock;
    public static void init() {

        blocktorch = new ExtremeTorch();

        blocktorch.setBlockName("ExtremeTorch");
        blocktorch.setBlockTextureName(Tags.MODID + ":extreme_torch");

        BrownAntNest = new BrownAntNest();

        BrownAntNest.setBlockName("BrownAntNest");

        RainbowAntNest = new RainbowAntNest();

        RainbowAntNest.setBlockName("RainbowAntNest");
        RedAntNest = new RedAntNest();

        RedAntNest.setBlockName("RedAntNest");
        UnstablenAntNest = new UnstableAntNest();

        UnstablenAntNest.setBlockName("UnstableAntNest");

        TermiteNest = new TermiteAntNest();

        TermiteNest.setBlockName("TermiteAntNest");

        CreeperRepellent = new CreeperRepellent();

        CreeperRepellent.setBlockName("CreeperRepelent");
        ContainerCrystalFurnaceBlock = new CrystalFurnace(212, false, 2.0f, 10.0f).setBlockName("crystalfurnace");

        ContainerCrystalFurnaceOnBlock = new CrystalFurnace(213, true, 2.0f, 10.0f).setBlockName("crystalfurnace");
        CrystalWorkbench = new CrystalWorkbench().setBlockName("crystalworkbench");

        TigersEyeBlock = new TigersEyeBlock();

        TigersEyeBlock.setBlockName("TigersEyeBlock");

        AmethystBlock = new AmethystBlock();

        AmethystBlock.setBlockName("AmethystBlock");

        RubyBlock = new RubyBlock();

        RubyBlock.setBlockName("RubyBlock");

        TitaniumBlock = new TitaniumBlock();

        TitaniumBlock.setBlockName("TitaniumBlock");

        UraniumBlock = new UraniumBlock();

        UraniumBlock.setBlockName("UraniumBlock");

        PinkTourmalineBlock = new PinkTourmalineBlock();

        PinkTourmalineBlock.setBlockName("PinkTourmalineBlock");

        TigersEyeBlockOre = new TigersEyeOre();

        TigersEyeBlockOre.setBlockName("TigersEyeBlockOre");

        AmethystBlockOre = new AmethystOre();

        AmethystBlockOre.setBlockName("AmethystBlockOre");

        RubyBlockOre = new RubyOre();

        RubyBlockOre.setBlockName("RubyBlockOre");

        TitaniumBlockOre = new TitaniumOre();

        TitaniumBlockOre.setBlockName("TitaniumBlockOre");

        UraniumBlockOre = new UraniumOre();
        UraniumBlockOre.setBlockName("UraniumBlockOre");

        CrystalTorch = new CrystalTorch();

        CrystalTorch.setBlockName("CrystalTorch");

        TeleportBlock = new TeleportBlock();

        TeleportBlock.setBlockName("TeleportBlock");

        EnderPearlBlock = new EnderPearlBlock();
        EnderPearlBlock.setBlockName("EnderPearlBlock");

        MobzillaScaleBlock = new MobzillaScaleBlock();
        MobzillaScaleBlock.setBlockName("MobzillaScaleBlock");

        EyeOfEnderBlock = new EyeOfEnderBlock();
        EyeOfEnderBlock.setBlockName("EyeOfEnderBlock");

        SaltOre = new SaltOre();
        SaltOre.setBlockName("SaltOre");

        CrystalStone = new CrystalStone(Material.rock);
        CrystalStone.setBlockName("CrystalStone");
        RockBlock = new RockBlock();
        RockBlock.setBlockName("RockBlock");

        CrystalGrass = new CrystalGrass(0, 2.0f, 3.0f);
        CrystalWood = new CrystalWood(0, 2.0f, 3.0f);

        BlockAppleLeaves = new BlockAppleLeaves();
        BlockButterflyPlant = new BlockButterflyPlant();
        BlockCorn1 = new BlockCorn(1);
        BlockCorn2 = new BlockCorn(2);

        BlockCorn3 = new BlockCorn(3);

        BlockCorn4 = new BlockCorn(4);

        BlockCrystalLeaves = new BlockCrystalLeaves(1);
        BlockCrystalLeaves3 = new BlockCrystalLeaves(2);

        BlockCrystalLeaves2 = new BlockCrystalLeaves(3);

        BlockCrystalPlant = new BlockCrystalPlant(1);
        BlockCrystalPlant2 = new BlockCrystalPlant(2);

        BlockCrystalPlant3 = new BlockCrystalPlant(3);

        BlockCrystalTreeLog = new BlockCrystalTreeLog();
        BlockDuctTape = new BlockDuctTape();
        BlockDuplicatorLog = new BlockDuplicatorLog();
        BlockExperienceLeaves = new BlockExperienceLeaves();

        BlockExperiencePlant = new BlockExperiencePlant();
        BlockFireflyPlant = new BlockFireflyPlant();
        BlockLettuce1 = new BlockLettuce(1);
        BlockLettuce2 = new BlockLettuce(2);
        BlockLettuce3 = new BlockLettuce(3);
        BlockLettuce4 = new BlockLettuce(4);

        BlockMosquitoPlant = new BlockMosquitoPlant();
        BlockMothPlant = new BlockMothPlant();
        BlockPizza = new BlockPizza();
        BlockQuinoa1 = new BlockQuinoa(1);
        BlockQuinoa2 = new BlockQuinoa(2);
        BlockQuinoa3 = new BlockQuinoa(3);
        BlockQuinoa4 = new BlockQuinoa(4);

        BlockRadish = new BlockRadish();
        BlockRice = new BlockRice();

        BlockScaryLeaves = new BlockScaryLeaves(1);
        BlockScaryLeaves2 = new BlockScaryLeaves(2);

        BlockSkyTreeLog = new BlockSkyTreeLog();
        BlockStrawberry = new BlockStrawberry();
        BlockTomato1 = new BlockTomato(1);
        BlockTomato2 = new BlockTomato(2);
        BlockTomato3 = new BlockTomato(3);
        BlockTomato4 = new BlockTomato(4);
        CrystalTermiteBlock = new CrystaltermiteBlock();
        DungeonSpawnerBlock = new DungeonSpawnerBlock();
        IslandBlock = new IslandBlock();
        KingSpawnerBlock = new KingSpawnerBlock();
        MoleDirtBlock = new MoleDirtBlock();

        MyFlowerPinkBlock = new MyBlockFlower(1);
        MyFlowerBlackBlock = new MyBlockFlower(2);
        MyFlowerBlueBlock = new MyBlockFlower(3);
        MyFlowerScaryBlock = new MyBlockFlower(4);

        OreBasicStone = new OreBasicStone(0, 2.0f, 3.0f);
        OreCrystalCrystal = new OreCrystalCrystal(0, 2.0f, 3.0f, 4.0f);
        OreGenericEgg = new OreGenericEgg();
        OreSalt = new OreSalt();
        OreTitanium = new OreTitanium();
        OreUranium = new OreUranium();
        PortalBlock = new PortalBlock();
        QueenSpawnerBlock = new QueenSpawnerBlock();
        KrakenRepellent = new KrakenRepellent();

        CrystalRat = new OreBasicStone(0, 2.0f, 3.0f);
        CrystalFairy = new OreBasicStone(0, 2.0f, 3.0f);
        TrollBlock1 = new OreBasicStone(0, 2.0f, 3.0f);
        TermiteTroll = new OreBasicStone(0, 2.0f, 3.0f);
        CrystalCoal = new OreCrystal(0,2.0f, 3.0f);
        WaterDragonSpawnBlock = new OreGenericEgg();
        EnderKnightSpawnBlock = new OreGenericEgg();
        EnderReaperSpawnBlock = new OreGenericEgg();
        EnderManSpawnBlock = new OreGenericEgg();
        EnderDragonSpawnBlock = new OreGenericEgg();


        MySpiderSpawnBlock = new OreGenericEgg();
        MyBatSpawnBlock = new OreGenericEgg();
        MyCowSpawnBlock = new OreGenericEgg();
        MyPigSpawnBlock = new OreGenericEgg();
        MySquidSpawnBlock = new OreGenericEgg();
        MyChickenSpawnBlock = new OreGenericEgg();
        MyCreeperSpawnBlock = new OreGenericEgg();
        MySkeletonSpawnBlock = new OreGenericEgg();
        MyZombieSpawnBlock = new OreGenericEgg();
        MySlimeSpawnBlock = new OreGenericEgg();
        MyGhastSpawnBlock = new OreGenericEgg();
        MyZombieSpawnBlock = new OreGenericEgg();
        MyEndermanSpawnBlock = new OreGenericEgg();
        MyCaveSpiderSpawnBlock = new OreGenericEgg();
        MySilverfishSpawnBlock = new OreGenericEgg();
        MyMagmaCubeSpawnBlock = new OreGenericEgg();
        MyWitchSpawnBlock = new OreGenericEgg();
        MySheepSpawnBlock = new OreGenericEgg();
        MyWolfSpawnBlock = new OreGenericEgg();
        MyMooshroomSpawnBlock = new OreGenericEgg();
        MyOcelotSpawnBlock = new OreGenericEgg();
        MyBlazeSpawnBlock = new OreGenericEgg();
        MyWitchSpawnBlock = new OreGenericEgg();
        MyEnderDragonSpawnBlock = new OreGenericEgg();
        MySnowGolemSpawnBlock = new OreGenericEgg();
        MyIronGolemSpawnBlock = new OreGenericEgg();
        MyWitherBossSpawnBlock = new OreGenericEgg();
        MyGirlfriendSpawnBlock = new OreGenericEgg();
        MyBoyfriendSpawnBlock = new OreGenericEgg();
        MyRedCowSpawnBlock = new OreGenericEgg();
        MyCrystalCowSpawnBlock = new OreGenericEgg();
        MyVillagerSpawnBlock = new OreGenericEgg();
        MyGoldCowSpawnBlock = new OreGenericEgg();
        MyEnchantedCowSpawnBlock = new OreGenericEgg();
        MyMOTHRASpawnBlock = new OreGenericEgg();
        MyAloSpawnBlock = new OreGenericEgg();
        MyCryoSpawnBlock = new OreGenericEgg();
        MyCamaSpawnBlock = new OreGenericEgg();
        MyVeloSpawnBlock = new OreGenericEgg();
        MyHydroSpawnBlock = new OreGenericEgg();
        MyBasilSpawnBlock = new OreGenericEgg();
        MyDragonflySpawnBlock = new OreGenericEgg();
        MyEmperorScorpionSpawnBlock = new OreGenericEgg();
        MyScorpionSpawnBlock = new OreGenericEgg();
        MyCaveFisherSpawnBlock = new OreGenericEgg();
        MySpyroSpawnBlock = new OreGenericEgg();
        MyBaryonyxSpawnBlock = new OreGenericEgg();
        MyGammaMetroidSpawnBlock = new OreGenericEgg();
        MyCockateilSpawnBlock = new OreGenericEgg();
        MyKyuubiSpawnBlock = new OreGenericEgg();
        MyAlienSpawnBlock = new OreGenericEgg();
        MyAttackSquidSpawnBlock = new OreGenericEgg();
        MyWaterDragonSpawnBlock = new OreGenericEgg();
        MyKrakenSpawnBlock = new OreGenericEgg();
        MyLizardSpawnBlock = new OreGenericEgg();
        MyCephadromeSpawnBlock = new OreGenericEgg();
        MyDragonSpawnBlock = new OreGenericEgg();
        MyBeeSpawnBlock = new OreGenericEgg();
        MyHorseSpawnBlock = new OreGenericEgg();
        MyTrooperBugSpawnBlock = new OreGenericEgg();
        MySpitBugSpawnBlock = new OreGenericEgg();
        MyStinkBugSpawnBlock = new OreGenericEgg();
        MyOstrichSpawnBlock = new OreGenericEgg();
        MyGazelleSpawnBlock = new OreGenericEgg();
        MyChipmunkSpawnBlock = new OreGenericEgg();
        MyCreepingHorrorSpawnBlock = new OreGenericEgg();
        MyTerribleTerrorSpawnBlock = new OreGenericEgg();
        MyCliffRacerSpawnBlock = new OreGenericEgg();
        MyTriffidSpawnBlock = new OreGenericEgg();
        MyPitchBlackSpawnBlock = new OreGenericEgg();
        MyLurkingTerrorSpawnBlock = new OreGenericEgg();
        MyGodzillaPartSpawnBlock = new OreGenericEgg();
        MyGodzillaSpawnBlock = new OreGenericEgg();
        MyTheKingPartSpawnBlock = new OreGenericEgg();
        MyTheQueenPartSpawnBlock = new OreGenericEgg();
        MyTheKingSpawnBlock = new OreGenericEgg();
        MyTheQueenSpawnBlock = new OreGenericEgg();
        MySmallWormSpawnBlock = new OreGenericEgg();
        MyMediumWormSpawnBlock = new OreGenericEgg();
        MyLargeWormSpawnBlock = new OreGenericEgg();
        MyCassowarySpawnBlock = new OreGenericEgg();
        MyCloudSharkSpawnBlock = new OreGenericEgg();
        MyGoldFishSpawnBlock = new OreGenericEgg();
        MyLeafMonsterSpawnBlock = new OreGenericEgg();
        MyEnderKnightSpawnBlock = new OreGenericEgg();
        MyEnderReaperSpawnBlock = new OreGenericEgg();
        MyBeaverSpawnBlock = new OreGenericEgg();
        MyUrchinSpawnBlock = new OreGenericEgg();
        MyFlounderSpawnBlock = new OreGenericEgg();
        MySkateSpawnBlock = new OreGenericEgg();
        MyRotatorSpawnBlock = new OreGenericEgg();
        MyPeacockSpawnBlock = new OreGenericEgg();
        MyFairySpawnBlock = new OreGenericEgg();
        MyDungeonBeastSpawnBlock = new OreGenericEgg();
        MyVortexSpawnBlock = new OreGenericEgg();
        MyRatSpawnBlock = new OreGenericEgg();
        MyWhaleSpawnBlock = new OreGenericEgg();
        MyIrukandjiSpawnBlock = new OreGenericEgg();
        MyTRexSpawnBlock = new OreGenericEgg();
        MyHerculesSpawnBlock = new OreGenericEgg();
        MyMantisSpawnBlock = new OreGenericEgg();
        MyStinkySpawnBlock = new OreGenericEgg();
        MyEasterBunnySpawnBlock = new OreGenericEgg();
        MyCaterKillerSpawnBlock = new OreGenericEgg();
        MyMolenoidSpawnBlock = new OreGenericEgg();
        MySeaMonsterSpawnBlock = new OreGenericEgg();
        MySeaViperSpawnBlock = new OreGenericEgg();
        MyLeonSpawnBlock = new OreGenericEgg();
        MyHammerheadSpawnBlock = new OreGenericEgg();
        MyRubberDuckySpawnBlock = new OreGenericEgg();
        MyCriminalSpawnBlock = new OreGenericEgg();
        MyBrutalflySpawnBlock = new OreGenericEgg();
        MyNastysaurusSpawnBlock = new OreGenericEgg();
        MyPointysaurusSpawnBlock = new OreGenericEgg();
        MyCricketSpawnBlock = new OreGenericEgg();
        MyFrogSpawnBlock = new OreGenericEgg();
        MySpiderDriverSpawnBlock = new OreGenericEgg();
        MyCrabSpawnBlock = new OreGenericEgg();
        CrystalFlowerYellowBlock = new MyBlockFlower(10);
        BlockScaryLeaves3 = new BlockScaryLeaves(11);
        CrystalRat = new OreGenericEgg();
        CrystalFlowerGreenBlock = new MyBlockFlower();
        CrystalFlowerBlueBlock = new MyBlockFlower();
        Lavafoam = new Lavafoam();

    }

    public static void register() {
        GameRegistry.registerBlock(blocktorch, "ExtremeTorch");
        blocktorch.setLightLevel(15);
        GameRegistry.registerBlock(CrystalTorch, "CrystalTorch");
        CrystalTorch.setLightLevel(14);
        CrystalTorch.setBlockTextureName(Tags.MODID + ":crystaltorch");
        GameRegistry.registerBlock(BrownAntNest, "BrownAntNest");
        GameRegistry.registerBlock(RainbowAntNest, "RainbowAntNest");
        GameRegistry.registerBlock(RedAntNest, "RedAntNest");
        GameRegistry.registerBlock(UnstablenAntNest, "UnstableAntNest");
        GameRegistry.registerBlock(TermiteNest, "TermiteNest");
        GameRegistry.registerBlock(CreeperRepellent, "CreeperRepelent");
        GameRegistry.registerBlock(ContainerCrystalFurnaceBlock, "CrystalFurnaceBlock");
        GameRegistry.registerBlock(ContainerCrystalFurnaceOnBlock, "CrystalFurnaceOnBlock");
        GameRegistry.registerBlock(CrystalWorkbench, "CrystalWorkbenchBlock");
        GameRegistry.registerBlock(TigersEyeBlock, "TigersEyeBlock");
        GameRegistry.registerBlock(AmethystBlock, "AmethystBlock");
        GameRegistry.registerBlock(RubyBlock, "RubyBlock");
        GameRegistry.registerBlock(TitaniumBlock, "TitaniumBlock");
        GameRegistry.registerBlock(UraniumBlock, "UraniumBlock");
        GameRegistry.registerBlock(PinkTourmalineBlock, "PinkTourmalineBlock");
        GameRegistry.registerBlock(TigersEyeBlockOre, "TigersEyeBlockOre");
        GameRegistry.registerBlock(AmethystBlockOre, "AmethystBlockOre");
        GameRegistry.registerBlock(RubyBlockOre, "RubyBlockOre");
        GameRegistry.registerBlock(TitaniumBlockOre, "TitaniumBlockOre");
        GameRegistry.registerBlock(UraniumBlockOre, "UraniumBlockOre");
        GameRegistry.registerBlock(TeleportBlock, "TeleportBlock");
        TeleportBlock.setBlockTextureName(Tags.MODID + ":blockteleport");
        GameRegistry.registerBlock(EnderPearlBlock, "EnderPearlBlock");
        GameRegistry.registerBlock(MobzillaScaleBlock, "MobzillaScaleBlock");
        GameRegistry.registerBlock(EyeOfEnderBlock, "EyeOfEnderBlock");
        GameRegistry.registerBlock(SaltOre, "SaltOre");
        GameRegistry.registerBlock(CrystalStone, "CrystalStone");
        GameRegistry.registerBlock(RockBlock, "RockBlock");
        GameRegistry.registerItem(Item.getItemFromBlock(CrystalGrass), "CrystalGrass");
        GameRegistry.registerBlock(CrystalWood, "CrystalWood");
        GameRegistry.registerBlock(BlockAppleLeaves, "BlockAppleLeaves");
        GameRegistry.registerBlock(BlockButterflyPlant, "BlockButterflyPlant");
        GameRegistry.registerBlock(BlockCorn1, "BlockCorn1");
        GameRegistry.registerBlock(BlockCorn2, "BlockCorn2");
        GameRegistry.registerBlock(BlockCorn3, "BlockCorn3");
        GameRegistry.registerBlock(BlockCorn4, "BlockCorn4");
        GameRegistry.registerBlock(BlockCrystalLeaves3, "BlockCrystalLeaves");
        GameRegistry.registerBlock(BlockCrystalLeaves2, "BlockCrystalLeaves");
        GameRegistry.registerBlock(BlockCrystalLeaves, "BlockCrystalLeaves");
        GameRegistry.registerBlock(BlockCrystalPlant, "BlockCrystalPlant");
        GameRegistry.registerBlock(BlockCrystalPlant2, "BlockCrystalPlant2");
        GameRegistry.registerBlock(BlockCrystalPlant3, "BlockCrystalPlant3");
        GameRegistry.registerBlock(BlockCrystalTreeLog, "BlockCrystalTreeLog");
        GameRegistry.registerBlock(BlockDuctTape, "BlockDuctTape");
        GameRegistry.registerBlock(BlockDuplicatorLog, "BlockDuplicatorLog");
        GameRegistry.registerBlock(BlockExperienceLeaves, "BlockExperienceLeaves");
        GameRegistry.registerBlock(BlockExperiencePlant, "BlockExperiencePlant");
        GameRegistry.registerBlock(BlockFireflyPlant, "BlockFireflyPlant");
        GameRegistry.registerBlock(BlockLettuce4, "BlockLettuce4");
        GameRegistry.registerBlock(BlockLettuce1, "BlockLettuce1");
        GameRegistry.registerBlock(BlockLettuce2, "BlockLettuce2");
        GameRegistry.registerBlock(BlockLettuce3, "BlockLettuce3");
        GameRegistry.registerBlock(BlockMosquitoPlant, "BlockMosquitoPlant");
        GameRegistry.registerBlock(BlockMothPlant, "BlockMothPlant");
        GameRegistry.registerBlock(BlockPizza, "BlockPizza");
        GameRegistry.registerBlock(BlockRadish, "BlockRadish");
        GameRegistry.registerBlock(BlockRice, "BlockRice");
        GameRegistry.registerBlock(BlockScaryLeaves, "BlockScaryLeaves");
        GameRegistry.registerBlock(BlockScaryLeaves2, "BlockScaryLeaves2");
        GameRegistry.registerBlock(BlockQuinoa1, "BlockQuinoa1");
        GameRegistry.registerBlock(BlockQuinoa2, "BlockQuinoa2");
        GameRegistry.registerBlock(BlockQuinoa3, "BlockQuinoa3");
        GameRegistry.registerBlock(BlockQuinoa4, "BlockQuinoa4");
        GameRegistry.registerBlock(BlockSkyTreeLog, "BlockSkyTreeLog");
        GameRegistry.registerBlock(BlockStrawberry, "BlockStrawberry");
        GameRegistry.registerBlock(BlockTomato1, "BlockTomato1");
        GameRegistry.registerBlock(BlockTomato2, "BlockTomato2");
        GameRegistry.registerBlock(BlockTomato3, "BlockTomato3");
        GameRegistry.registerBlock(BlockTomato4, "BlockTomato4");
        GameRegistry.registerBlock(CrystalTermiteBlock, "CrystalTermiteBlock");
        GameRegistry.registerBlock(DungeonSpawnerBlock, "DungeonSpawnerBlock");
        GameRegistry.registerBlock(IslandBlock, "IslandBlock");
        GameRegistry.registerBlock(KingSpawnerBlock, "KingSpawnerBlock");
        GameRegistry.registerBlock(MoleDirtBlock, "MoleDirtBlock");
        GameRegistry.registerBlock(MyFlowerPinkBlock, "MyFlowerPinkBlock");
        GameRegistry.registerBlock(MyFlowerBlackBlock, "MyFlowerBlackBlock");
        GameRegistry.registerBlock(MyFlowerBlueBlock, "MyFlowerBlueBlock");
        GameRegistry.registerBlock(MyFlowerScaryBlock, "MyFlowerScaryBlock");
        GameRegistry.registerBlock(OreBasicStone, "OreBasicStone");
        GameRegistry.registerBlock(OreCrystalCrystal, "OreCrystalCrystal");
        GameRegistry.registerBlock(OreGenericEgg, "OreGenericEgg");
        GameRegistry.registerBlock(OreSalt, "OreSalt");
        GameRegistry.registerBlock(OreTitanium, "OreTitanium");
        GameRegistry.registerBlock(OreUranium, "OreUranium");
        GameRegistry.registerBlock(PortalBlock, "PortalBlock");
        GameRegistry.registerBlock(QueenSpawnerBlock, "QueenSpawnerBlock");
        GameRegistry.registerBlock(KrakenRepellent, "KrakenRepellent");
        GameRegistry.registerBlock(CrystalRat, "CrystalRat");
        GameRegistry.registerBlock(CrystalFairy, "CrystalFairy");
        GameRegistry.registerBlock(TrollBlock1, "TrollBlock1");
        GameRegistry.registerBlock(TermiteTroll, "TermiteTroll");
        GameRegistry.registerBlock(CrystalCoal, "CrystalCoal");
        GameRegistry.registerBlock(WaterDragonSpawnBlock, "WaterDragonSpawnBlock");
        GameRegistry.registerBlock(EnderKnightSpawnBlock, "EnderKnightSpawnBlock");
        GameRegistry.registerBlock(EnderReaperSpawnBlock, "EnderReaperSpawnBlock");
        GameRegistry.registerBlock(EnderManSpawnBlock, "EnderManSpawnBlock");
        GameRegistry.registerBlock(CrystalFlowerRedBlock, "CrystalFlowerRedBlock");
        GameRegistry.registerBlock(CrystalFlowerYellowBlock, "CrystalFlowerYellowBlock");
        GameRegistry.registerBlock(MySpiderSpawnBlock, "MySpiderSpawnBlock");
        GameRegistry.registerBlock(MyBatSpawnBlock, "MyBatSpawnBlock");
        GameRegistry.registerBlock(MyCowSpawnBlock, "MyCowSpawnBlock");
        GameRegistry.registerBlock(MyPigSpawnBlock, "MyPigSpawnBlock");
        GameRegistry.registerBlock(MySquidSpawnBlock, "MySquidSpawnBlock");
        GameRegistry.registerBlock(MyChickenSpawnBlock, "MyChickenSpawnBlock");
        GameRegistry.registerBlock(MyCreeperSpawnBlock, "MyCreeperSpawnBlock");
        GameRegistry.registerBlock(MySkeletonSpawnBlock, "MySkeletonSpawnBlock");
        GameRegistry.registerBlock(MyZombieSpawnBlock, "MyZombieSpawnBlock");
        GameRegistry.registerBlock(MySlimeSpawnBlock, "MySlimeSpawnBlock");
        GameRegistry.registerBlock(MyGhastSpawnBlock, "MyGhastSpawnBlock");
        GameRegistry.registerBlock(MyZombiePigmanSpawnBlock, "MyZombiePigmanSpawnBlock");
        GameRegistry.registerBlock(MyEndermanSpawnBlock, "MyEndermanSpawnBlock");
        GameRegistry.registerBlock(MyCaveSpiderSpawnBlock, "MyCaveSpiderSpawnBlock");
        GameRegistry.registerBlock(MySilverfishSpawnBlock, "MySilverfishSpawnBlock");
        GameRegistry.registerBlock(MyMagmaCubeSpawnBlock, "MyMagmaCubeSpawnBlock");
        GameRegistry.registerBlock(MyWitchSpawnBlock, "MyWitchSpawnBlock");
        GameRegistry.registerBlock(MySheepSpawnBlock, "MySheepSpawnBlock");
        GameRegistry.registerBlock(MyWolfSpawnBlock, "MyWolfSpawnBlock");
        GameRegistry.registerBlock(MyMooshroomSpawnBlock, "MyMooshroomSpawnBlock");
        GameRegistry.registerBlock(MyOcelotSpawnBlock, "MyOcelotSpawnBlock");
        GameRegistry.registerBlock(MyBlazeSpawnBlock, "MyBlazeSpawnBlock");
        GameRegistry.registerBlock(MyWitherSkeletonSpawnBlock, "MyWitherSkeletonSpawnBlock");
        GameRegistry.registerBlock(MyEnderDragonSpawnBlock, "MyEnderDragonSpawnBlock");
        GameRegistry.registerBlock(MySnowGolemSpawnBlock, "MySnowGolemSpawnBlock");
        GameRegistry.registerBlock(MyIronGolemSpawnBlock, "MyIronGolemSpawnBlock");
        GameRegistry.registerBlock(MyWitherBossSpawnBlock, "MyWitherBossSpawnBlock");
        GameRegistry.registerBlock(MyGirlfriendSpawnBlock, "MyGirlfriendSpawnBlock");
        GameRegistry.registerBlock(MyBoyfriendSpawnBlock, "MyBoyfriendSpawnBlock");
        GameRegistry.registerBlock(MyCrystalCowSpawnBlock, "MyCrystalCowSpawnBlock");
        GameRegistry.registerBlock(MyVillagerSpawnBlock, "MyVillagerSpawnBlock");
        GameRegistry.registerBlock(MyGoldCowSpawnBlock, "MyGoldCowSpawnBlock");
        GameRegistry.registerBlock(MyEnchantedCowSpawnBlock, "MyEnchantedCowSpawnBlock");
        GameRegistry.registerBlock(MyMOTHRASpawnBlock, "MyMOTHRASpawnBlock");
        GameRegistry.registerBlock(MyAloSpawnBlock, "MyAloSpawnBlock");
        GameRegistry.registerBlock(MyCryoSpawnBlock, "MyCryoSpawnBlock");
        GameRegistry.registerBlock(MyCamaSpawnBlock, "MyCamaSpawnBlock");
        GameRegistry.registerBlock(MyVeloSpawnBlock, "MyVeloSpawnBlock");
        GameRegistry.registerBlock(MyHydroSpawnBlock, "MyHydroSpawnBlock");
        GameRegistry.registerBlock(MyBasilSpawnBlock, "MyBasilSpawnBlock");
        GameRegistry.registerBlock(MyDragonflySpawnBlock, "MyDragonflySpawnBlock");
        GameRegistry.registerBlock(MyEmperorScorpionSpawnBlock, "MyEmperorScorpionSpawnBlock");
        GameRegistry.registerBlock(MyScorpionSpawnBlock, "MyScorpionSpawnBlock");
        GameRegistry.registerBlock(MyCaveFisherSpawnBlock, "MyCaveFisherSpawnBlock");
        GameRegistry.registerBlock(MySpyroSpawnBlock, "MySpyroSpawnBlock");
        GameRegistry.registerBlock(MyBaryonyxSpawnBlock, "MyBaryonyxSpawnBlock");
        GameRegistry.registerBlock(MyGammaMetroidSpawnBlock, "MyGammaMetroidSpawnBlock");
        GameRegistry.registerBlock(MyCockateilSpawnBlock, "MyCockateilSpawnBlock");
        GameRegistry.registerBlock(MyKyuubiSpawnBlock, "MyKyuubiSpawnBlock");
        GameRegistry.registerBlock(MyAlienSpawnBlock, "MyAlienSpawnBlock");
        GameRegistry.registerBlock(MyAttackSquidSpawnBlock, "MyAttackSquidSpawnBlock");
        GameRegistry.registerBlock(MyWaterDragonSpawnBlock, "MyWaterDragonSpawnBlock");
        GameRegistry.registerBlock(MyKrakenSpawnBlock, "MyKrakenSpawnBlock");
        GameRegistry.registerBlock(MyLizardSpawnBlock, "MyLizardSpawnBlock");
        GameRegistry.registerBlock(MyCephadromeSpawnBlock, "MyCephadromeSpawnBlock");
        GameRegistry.registerBlock(MyDragonSpawnBlock, "MyDragonSpawnBlock");
        GameRegistry.registerBlock(MyBeeSpawnBlock, "MyBeeSpawnBlock");
        GameRegistry.registerBlock(MyHorseSpawnBlock, "MyHorseSpawnBlock");
        GameRegistry.registerBlock(MyTrooperBugSpawnBlock, "MyTrooperBugSpawnBlock");
        GameRegistry.registerBlock(MySpitBugSpawnBlock, "MySpitBugSpawnBlock");
        GameRegistry.registerBlock(MyStinkBugSpawnBlock, "MyStinkBugSpawnBlock");
        GameRegistry.registerBlock(MyOstrichSpawnBlock, "MyOstrichSpawnBlock");
        GameRegistry.registerBlock(MyGazelleSpawnBlock, "MyGazelleSpawnBlock");
        GameRegistry.registerBlock(MyChipmunkSpawnBlock, "MyChipmunkSpawnBlock");
        GameRegistry.registerBlock(MyCreepingHorrorSpawnBlock, "MyCreepingHorrorSpawnBlock");
        GameRegistry.registerBlock(MyTerribleTerrorSpawnBlock, "MyTerribleTerrorSpawnBlock");
        GameRegistry.registerBlock(MyCliffRacerSpawnBlock, "MyCliffRacerSpawnBlock");
        GameRegistry.registerBlock(MyTriffidSpawnBlock, "MyTriffidSpawnBlock");
        GameRegistry.registerBlock(MyPitchBlackSpawnBlock, "MyPitchBlackSpawnBlock");
        GameRegistry.registerBlock(MyLurkingTerrorSpawnBlock, "MyLurkingTerrorSpawnBlock");
        GameRegistry.registerBlock(MyGodzillaPartSpawnBlock, "MyGodzillaPartSpawnBlock");
        GameRegistry.registerBlock(MyGodzillaSpawnBlock, "MyGodzillaSpawnBlock");
        GameRegistry.registerBlock(MyTheKingPartSpawnBlock, "MyTheKingPartSpawnBlock");
        GameRegistry.registerBlock(MyTheQueenPartSpawnBlock, "MyTheQueenPartSpawnBlock");
        GameRegistry.registerBlock(MyTheKingSpawnBlock, "MyTheKingSpawnBlock");
        GameRegistry.registerBlock(MyTheQueenSpawnBlock, "MyTheQueenSpawnBlock");
        GameRegistry.registerBlock(MySmallWormSpawnBlock, "MySmallWormSpawnBlock");
        GameRegistry.registerBlock(MyMediumWormSpawnBlock, "MyMediumWormSpawnBlock");
        GameRegistry.registerBlock(MyLargeWormSpawnBlock, "MyLargeWormSpawnBlock");
        GameRegistry.registerBlock(MyCassowarySpawnBlock, "MyCassowarySpawnBlock");
        GameRegistry.registerBlock(MyCloudSharkSpawnBlock, "MyCloudSharkSpawnBlock");
        GameRegistry.registerBlock(MyGoldFishSpawnBlock, "MyGoldFishSpawnBlock");
        GameRegistry.registerBlock(MyLeafMonsterSpawnBlock, "MyLeafMonsterSpawnBlock");
        GameRegistry.registerBlock(MyEnderKnightSpawnBlock, "MyEnderKnightSpawnBlock");
        GameRegistry.registerBlock(MyEnderReaperSpawnBlock, "MyEnderReaperSpawnBlock");
        GameRegistry.registerBlock(MyBeaverSpawnBlock, "MyBeaverSpawnBlock");
        GameRegistry.registerBlock(MyUrchinSpawnBlock, "MyUrchinSpawnBlock");
        GameRegistry.registerBlock(MyFlounderSpawnBlock, "MyFlounderSpawnBlock");
        GameRegistry.registerBlock(MySkateSpawnBlock, "MySkateSpawnBlock");
        GameRegistry.registerBlock(MyRotatorSpawnBlock, "MyRotatorSpawnBlock");
        GameRegistry.registerBlock(MyPeacockSpawnBlock, "MyPeacockSpawnBlock");
        GameRegistry.registerBlock(MyFairySpawnBlock, "MyFairySpawnBlock");
        GameRegistry.registerBlock(MyDungeonBeastSpawnBlock, "MyDungeonBeastSpawnBlock");
        GameRegistry.registerBlock(MyVortexSpawnBlock, "MyVortexSpawnBlock");
        GameRegistry.registerBlock(MyRatSpawnBlock, "MyRatSpawnBlock");
        GameRegistry.registerBlock(MyWhaleSpawnBlock, "MyWhaleSpawnBlock");
        GameRegistry.registerBlock(MyIrukandjiSpawnBlock, "MyIrukandjiSpawnBlock");
        GameRegistry.registerBlock(MyTRexSpawnBlock, "MyTRexSpawnBlock");
        GameRegistry.registerBlock(MyHerculesSpawnBlock, "MyHerculesSpawnBlock");
        GameRegistry.registerBlock(MyMantisSpawnBlock, "MyMantisSpawnBlock");
        GameRegistry.registerBlock(MyStinkySpawnBlock, "MyStinkySpawnBlock");
        GameRegistry.registerBlock(MyEasterBunnySpawnBlock, "MyEasterBunnySpawnBlock");
        GameRegistry.registerBlock(MyCaterKillerSpawnBlock, "MyCaterKillerSpawnBlock");
        GameRegistry.registerBlock(MyMolenoidSpawnBlock, "MyMolenoidSpawnBlock");
        GameRegistry.registerBlock(MySeaMonsterSpawnBlock, "MySeaMonsterSpawnBlock");
        GameRegistry.registerBlock(MySeaViperSpawnBlock, "MySeaViperSpawnBlock");
        GameRegistry.registerBlock(MyLeonSpawnBlock, "MyLeonSpawnBlock");
        GameRegistry.registerBlock(MyHammerheadSpawnBlock, "MyHammerheadSpawnBlock");
        GameRegistry.registerBlock(MyRubberDuckySpawnBlock, "MyRubberDuckySpawnBlock");
        GameRegistry.registerBlock(MyCriminalSpawnBlock, "MyCriminalSpawnBlock");
        GameRegistry.registerBlock(MyBrutalflySpawnBlock, "MyBrutalflySpawnBlock");
        GameRegistry.registerBlock(MyNastysaurusSpawnBlock, "MyNastysaurusSpawnBlock");
        GameRegistry.registerBlock(MyPointysaurusSpawnBlock, "MyPointysaurusSpawnBlock");
        GameRegistry.registerBlock(MyCricketSpawnBlock, "MyCricketSpawnBlock");
        GameRegistry.registerBlock(MyFrogSpawnBlock, "MyFrogSpawnBlock");
        GameRegistry.registerBlock(MySpiderDriverSpawnBlock, "MySpiderDriverSpawnBlock");
        GameRegistry.registerBlock(MyCrabSpawnBlock, "MyCrabSpawnBlock");
        GameRegistry.registerBlock(CrystalFlowerRedBlock, "CrystalFlowerRedBlock");
        GameRegistry.registerBlock(BlockScaryLeaves3, "BlockScaryLeaves3");
        GameRegistry.registerBlock(CrystalRat, "CrystalRat");
        GameRegistry.registerBlock(CrystalFlowerGreenBlock, "CrystalFlowerGreenBlock");
        GameRegistry.registerBlock(CrystalFlowerBlueBlock, "CrystalFlowerBlueBlock");
        GameRegistry.registerBlock(Lavafoam, "Lavafoam");

    }

}
