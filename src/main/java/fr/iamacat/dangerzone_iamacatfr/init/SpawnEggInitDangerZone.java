package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
import fr.iamacat.dangerzone_iamacatfr.spawnable.SpawnEggs;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;

public class SpawnEggInitDangerZone {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {

        SpawnEggs appleCowSpawnEgg = new SpawnEggs(AppleCowInstance.class);
        appleCowSpawnEgg.setUnlocalizedName("apple_cow_egg");
        Constants.AppleCowSpawnEgg = appleCowSpawnEgg;
        GameRegistry.registerItem(Constants.AppleCowSpawnEgg, "Apple Cow Egg");

        SpawnEggs crystalCowSpawnEgg = new SpawnEggs(CrystalCowInstance.class);
        crystalCowSpawnEgg.setUnlocalizedName("crystal_cow_egg");
        Constants.CrystalCowSpawnEgg = crystalCowSpawnEgg;
        GameRegistry.registerItem(Constants.CrystalCowSpawnEgg, "Crystal Cow Egg");

        SpawnEggs enchantedGoldenAppleCowSpawnEgg = new SpawnEggs(EnchantedGoldenAppleCowInstance.class);
        enchantedGoldenAppleCowSpawnEgg.setUnlocalizedName("enchanted_golden_apple_cow_egg");
        Constants.EnchantedGoldenAppleCowSpawnEgg = enchantedGoldenAppleCowSpawnEgg;
        GameRegistry.registerItem(Constants.EnchantedGoldenAppleCowSpawnEgg, "Enchanted Golden Apple Cow Egg");

        SpawnEggs TheKingSpawnEgg = new SpawnEggs(TheKing.class);
        TheKingSpawnEgg.setUnlocalizedName("the_king_egg");
        Constants.TheKingSpawnEgg = TheKingSpawnEgg;
        GameRegistry.registerItem(Constants.TheKingSpawnEgg, "The King Egg");

        SpawnEggs TheQueenSpawnEgg = new SpawnEggs(TheQueen.class);
        TheQueenSpawnEgg.setUnlocalizedName("the_queen_egg");
        Constants.TheQueenSpawnEgg = TheQueenSpawnEgg;
        GameRegistry.registerItem(Constants.TheQueenSpawnEgg, "The Queen Egg");

        SpawnEggs Girlfriend = new SpawnEggs(Girlfriend.class);
        Girlfriend.setUnlocalizedName("girlfriend_egg");
        Constants.Girlfriend = Girlfriend;
        GameRegistry.registerItem(Constants.Girlfriend, "Girlfriend Egg");

        SpawnEggs Boyfriend = new SpawnEggs(Boyfriend.class);
        Boyfriend.setUnlocalizedName("boyfriend_egg");
        Constants.Boyfriend = Boyfriend;
        GameRegistry.registerItem(Constants.Boyfriend, "Boyfriend Egg");

        SpawnEggs ThePrinceSpawnEgg = new SpawnEggs(ThePrince.class);
        ThePrinceSpawnEgg.setUnlocalizedName("the_prince_egg");
        Constants.ThePrinceSpawnEgg = ThePrinceSpawnEgg;
        GameRegistry.registerItem(Constants.ThePrinceSpawnEgg, "The Prince Egg");

        SpawnEggs MOTHRASpawnEgg = new SpawnEggs(Mothra.class);
        MOTHRASpawnEgg.setUnlocalizedName("mothra_egg");
        Constants.MOTHRASpawnEgg = MOTHRASpawnEgg;
        GameRegistry.registerItem(Constants.MOTHRASpawnEgg, "MOTHRA! Egg");

        SpawnEggs EnderKnightSpawnEgg = new SpawnEggs(EnderKnight.class);
        EnderKnightSpawnEgg.setUnlocalizedName("ender_knight_egg");
        Constants.EnderKnightSpawnEgg = EnderKnightSpawnEgg;
        GameRegistry.registerItem(Constants.EnderKnightSpawnEgg, "Ender Knight Egg");

        SpawnEggs EnderReaperSpawnEgg = new SpawnEggs(EnderReaper.class);
        EnderReaperSpawnEgg.setUnlocalizedName("ender_reaper_egg");
        Constants.EnderReaperSpawnEgg = EnderReaperSpawnEgg;
        GameRegistry.registerItem(Constants.EnderReaperSpawnEgg, "Ender Reaper Egg");

        SpawnEggs BeaverSpawnEgg = new SpawnEggs(BeaverInstance.class);
        BeaverSpawnEgg.setUnlocalizedName("beaver_egg");
        Constants.BeaverSpawnEgg = BeaverSpawnEgg;
        GameRegistry.registerItem(Constants.BeaverSpawnEgg, "Beaver Egg");

        SpawnEggs CloudSharkSpawnEgg = new SpawnEggs(CloudShark.class);
        CloudSharkSpawnEgg.setUnlocalizedName("cloud_shark_egg");
        Constants.CloudSharkSpawnEgg = CloudSharkSpawnEgg;
        GameRegistry.registerItem(Constants.CloudSharkSpawnEgg, "Cloud Shark Egg");

        SpawnEggs CassowarySpawnEgg = new SpawnEggs(Cassowary.class);
        CassowarySpawnEgg.setUnlocalizedName("cassowary_egg");
        Constants.CassowarySpawnEgg = CassowarySpawnEgg;
        GameRegistry.registerItem(Constants.CassowarySpawnEgg, "Cassowary Egg");

        SpawnEggs LargeWormSpawnEgg = new SpawnEggs(WormLarge.class);
        LargeWormSpawnEgg.setUnlocalizedName("large_worm_egg");
        Constants.LargeWormSpawnEgg = LargeWormSpawnEgg;
        GameRegistry.registerItem(Constants.LargeWormSpawnEgg, "Large Worm Egg");

        SpawnEggs MediumWormSpawnEgg = new SpawnEggs(WormMedium.class);
        MediumWormSpawnEgg.setUnlocalizedName("medium_worm_egg");
        Constants.MediumWormSpawnEgg = MediumWormSpawnEgg;
        GameRegistry.registerItem(Constants.MediumWormSpawnEgg, "Medium Worm Egg");

        SpawnEggs SmallWormSpawnEgg = new SpawnEggs(WormSmall.class);
        SmallWormSpawnEgg.setUnlocalizedName("small_worm_egg");
        Constants.SmallWormSpawnEgg = SmallWormSpawnEgg;
        GameRegistry.registerItem(Constants.SmallWormSpawnEgg, "Small Worm Egg");

        SpawnEggs GoldFishSpawnEgg = new SpawnEggs(GoldFish.class);
        GoldFishSpawnEgg.setUnlocalizedName("gold_fish_egg");
        Constants.GoldFishSpawnEgg = GoldFishSpawnEgg;
        GameRegistry.registerItem(Constants.GoldFishSpawnEgg, "Gold Fish Egg");

        SpawnEggs LeonopteryxSpawnEgg = new SpawnEggs(Leon.class);
        LeonopteryxSpawnEgg.setUnlocalizedName("leonopteryx_egg");
        Constants.LeonopteryxSpawnEgg = LeonopteryxSpawnEgg;
        GameRegistry.registerItem(Constants.LeonopteryxSpawnEgg, "Leonopteryx Egg");

        SpawnEggs ThePrincessSpawnEgg = new SpawnEggs(ThePrincess.class);
        ThePrincessSpawnEgg.setUnlocalizedName("the_princess_egg");
        Constants.ThePrincessSpawnEgg = ThePrincessSpawnEgg;
        GameRegistry.registerItem(Constants.ThePrincessSpawnEgg, "The Pricess Egg");

        SpawnEggs CrabSpawnEgg = new SpawnEggs(CrabInstance.class);
        CrabSpawnEgg.setUnlocalizedName("crab_egg");
        Constants.CrabSpawnEgg = CrabSpawnEgg;
        GameRegistry.registerItem(Constants.CrabSpawnEgg, "Crab Egg");

        SpawnEggs SpiderDriverSpawnEgg = new SpawnEggs(SpiderDriver.class);
        SpiderDriverSpawnEgg.setUnlocalizedName("spider_driver_egg");
        Constants.SpiderDriverSpawnEgg = SpiderDriverSpawnEgg;
        GameRegistry.registerItem(Constants.SpiderDriverSpawnEgg, "Spider Driver Egg");

        SpawnEggs CricketSpawnEgg = new SpawnEggs(Cricket.class);
        CricketSpawnEgg.setUnlocalizedName("cricket_egg");
        Constants.CricketSpawnEgg = CricketSpawnEgg;
        GameRegistry.registerItem(Constants.CricketSpawnEgg, "Cricket Egg");

        SpawnEggs HammerheadSpawnEgg = new SpawnEggs(Hammerhead.class);
        HammerheadSpawnEgg.setUnlocalizedName("hammerhead_egg");
        Constants.HammerheadSpawnEgg = HammerheadSpawnEgg;
        GameRegistry.registerItem(Constants.HammerheadSpawnEgg, "Hammer Head Egg");

        SpawnEggs EasterbunnySpawnEgg = new SpawnEggs(EasterBunny.class);
        EasterbunnySpawnEgg.setUnlocalizedName("easter_bunny_egg");
        Constants.EasterbunnySpawnEgg = EasterbunnySpawnEgg;
        GameRegistry.registerItem(Constants.EasterbunnySpawnEgg, "Easter Bunny Egg");

        SpawnEggs TrexSpawnEgg = new SpawnEggs(TRex.class);
        TrexSpawnEgg.setUnlocalizedName("trex_egg");
        Constants.TrexSpawnEgg = TrexSpawnEgg;
        GameRegistry.registerItem(Constants.TrexSpawnEgg, "T.Rex Egg");

        SpawnEggs PointysaurusSpawnEgg = new SpawnEggs(Pointysaurus.class);
        PointysaurusSpawnEgg.setUnlocalizedName("pointysaurus_egg");
        Constants.PointysaurusSpawnEgg = PointysaurusSpawnEgg;
        GameRegistry.registerItem(Constants.PointysaurusSpawnEgg, "Pointysaurus Egg");

        SpawnEggs FireflySpawnEgg = new SpawnEggs(Firefly.class);
        FireflySpawnEgg.setUnlocalizedName("firefly_egg");
        Constants.FireflySpawnEgg = FireflySpawnEgg;
        GameRegistry.registerItem(Constants.FireflySpawnEgg, "Firefly Egg");

        SpawnEggs RubberDuckySpawnegg = new SpawnEggs(RubberDucky.class);
        RubberDuckySpawnegg.setUnlocalizedName("rubbr_ducky_egg");
        Constants.RubberDuckySpawnegg = RubberDuckySpawnegg;
        GameRegistry.registerItem(Constants.RubberDuckySpawnegg, "Rubber Ducky Egg");

        SpawnEggs RedAntRobotSpawnEgg = new SpawnEggs(AntRobot.class);
        RedAntRobotSpawnEgg.setUnlocalizedName("red_ant_robot_egg");
        Constants.RedAntRobot = RedAntRobotSpawnEgg;
        GameRegistry.registerItem(Constants.RedAntRobot, "Red Ant Robot Egg");

        SpawnEggs GiantSpiderRobotSpawnEgg = new SpawnEggs(SpiderRobot.class);
        GiantSpiderRobotSpawnEgg.setUnlocalizedName("giant_spider_robot_egg");
        Constants.GiantSpiderRobotSpawnEgg = GiantSpiderRobotSpawnEgg;
        GameRegistry.registerItem(Constants.GiantSpiderRobotSpawnEgg, "Giant Spider Robot Egg");

        SpawnEggs CaterKillerSpawnEgg = new SpawnEggs(CaterKiller.class);
        CaterKillerSpawnEgg.setUnlocalizedName("catterkiller_egg");
        Constants.CaterKillerSpawnEgg = CaterKillerSpawnEgg;
        GameRegistry.registerItem(Constants.CaterKillerSpawnEgg, "Cater Killer Egg");

        SpawnEggs NastysaurusSpawnEgg = new SpawnEggs(Nastysaurus.class);
        NastysaurusSpawnEgg.setUnlocalizedName("nastysaurus_egg");
        Constants.NastysaurusSpawnEgg = NastysaurusSpawnEgg;
        GameRegistry.registerItem(Constants.NastysaurusSpawnEgg, "Nastysaurus Egg");

        SpawnEggs RoboSniperSpawnEgg = new SpawnEggs(Robot5.class);
        RoboSniperSpawnEgg.setUnlocalizedName("robot_sniper_egg");
        Constants.RoboSniperSpawnEgg = RoboSniperSpawnEgg;
        GameRegistry.registerItem(Constants.RoboSniperSpawnEgg, "Robot-Sniper Egg");

        SpawnEggs BrownAntSpawnEgg = new SpawnEggs(EntityAnt.class);
        BrownAntSpawnEgg.setUnlocalizedName("brown_ant_egg");
        Constants.BrownAntSpawnEgg = BrownAntSpawnEgg;
        GameRegistry.registerItem(Constants.BrownAntSpawnEgg, "Brown Ant Egg");

        SpawnEggs MosquitoSpawnEgg = new SpawnEggs(EntityMosquito.class);
        MosquitoSpawnEgg.setUnlocalizedName("mosquito_egg");
        Constants.MosquitoSpawnEgg = MosquitoSpawnEgg;
        GameRegistry.registerItem(Constants.MosquitoSpawnEgg, "Mosquito Egg");

        SpawnEggs MothSpawnEgg = new SpawnEggs(Mothra.class);
        MothSpawnEgg.setUnlocalizedName("moth_egg");
        Constants.MothSpawnEgg = MothSpawnEgg;
        GameRegistry.registerItem(Constants.MothSpawnEgg, "Moth Egg");

        SpawnEggs RoboWarriorSpawnEgg = new SpawnEggs(Robot4.class);
        RoboWarriorSpawnEgg.setUnlocalizedName("robo_warrior_egg");
        Constants.RoboWarriorSpawnEgg = RoboWarriorSpawnEgg;
        GameRegistry.registerItem(Constants.RoboWarriorSpawnEgg, "Robo Warrior Egg");

        SpawnEggs UnstableAntSpawnEgg = new SpawnEggs(EntityUnstableAnt.class);
        UnstableAntSpawnEgg.setUnlocalizedName("unstable_ant_egg");
        Constants.UnstableAntSpawnEgg = UnstableAntSpawnEgg;
        GameRegistry.registerItem(Constants.UnstableAntSpawnEgg, "Unstable Ant Egg");

        SpawnEggs GhostSpawnEgg = new SpawnEggs(Ghost.class);
        GhostSpawnEgg.setUnlocalizedName("ghost_egg");
        Constants.GhostSpawnEgg = GhostSpawnEgg;
        GameRegistry.registerItem(Constants.GhostSpawnEgg, "Ghost Egg");
        SpawnEggs GhostSkellySpawnEgg = new SpawnEggs(GhostSkelly.class);
        GhostSkellySpawnEgg.setUnlocalizedName("ghost_skelly_egg");
        Constants.GhostSkellySpawnEgg = GhostSkellySpawnEgg;
        GameRegistry.registerItem(Constants.GhostSkellySpawnEgg, "Ghost Skelly Egg");
        SpawnEggs termiteSPawnEgg = new SpawnEggs(Termite.class);
        termiteSPawnEgg.setUnlocalizedName("termite_egg");
        Constants.termiteSPawnEgg = termiteSPawnEgg;
        GameRegistry.registerItem(Constants.termiteSPawnEgg, "Termite Egg");

        SpawnEggs ButterflySpawnEgg = new SpawnEggs(EntityButterfly.class);
        ButterflySpawnEgg.setUnlocalizedName("butterfly_egg");
        Constants.ButterflySpawnEgg = ButterflySpawnEgg;
        GameRegistry.registerItem(Constants.ButterflySpawnEgg, "Butterfly Egg");

        SpawnEggs BombombSpawnEgg = new SpawnEggs(Robot1.class);
        BombombSpawnEgg.setUnlocalizedName("bomb_omb_egg");
        Constants.BombombSpawnEgg = BombombSpawnEgg;
        GameRegistry.registerItem(Constants.BombombSpawnEgg, "Bomb Omb Egg");

        SpawnEggs RatSpawnEgg = new SpawnEggs(RatInstance.class);
        RatSpawnEgg.setUnlocalizedName("rat_egg");
        Constants.RatSpawnEgg = RatSpawnEgg;
        GameRegistry.registerItem(Constants.RatSpawnEgg, "Rat Egg");

        SpawnEggs FairySpawnEgg = new SpawnEggs(Fairy.class);
        FairySpawnEgg.setUnlocalizedName("fairy_egg");
        Constants.FairySpawnEgg = FairySpawnEgg;
        GameRegistry.registerItem(Constants.FairySpawnEgg, "Fairy Egg");

        SpawnEggs PeacockSpawnEgg = new SpawnEggs(Peacock.class);
        PeacockSpawnEgg.setUnlocalizedName("peacock_egg");
        Constants.PeacockSpawnEgg = PeacockSpawnEgg;
        GameRegistry.registerItem(Constants.PeacockSpawnEgg, "Peacock Egg");

        SpawnEggs VortexSpawnEgg = new SpawnEggs(Vortex.class);
        VortexSpawnEgg.setUnlocalizedName("vortex_egg");
        Constants.VortexSpawnEgg = VortexSpawnEgg;
        GameRegistry.registerItem(Constants.VortexSpawnEgg, "Vortex Egg");

        SpawnEggs RotatorSpawnEgg = new SpawnEggs(Rotator.class);
        RotatorSpawnEgg.setUnlocalizedName("rotator_egg");
        Constants.RotatorSpawnEgg = RotatorSpawnEgg;
        GameRegistry.registerItem(Constants.RotatorSpawnEgg, "Rotator Egg");

        SpawnEggs DungeonBeastSpawnEgg = new SpawnEggs(DungeonBeast.class);
        DungeonBeastSpawnEgg.setUnlocalizedName("dungeon_beast_egg");
        Constants.DungeonBeastSpawnEgg = DungeonBeastSpawnEgg;
        GameRegistry.registerItem(Constants.DungeonBeastSpawnEgg, "Dungeon Beast Egg");

        SpawnEggs LeafMonsterSpawnEgg = new SpawnEggs(LeafMonster.class);
        LeafMonsterSpawnEgg.setUnlocalizedName("leaf_monster_egg");
        Constants.LeafMonsterSpawnEgg = LeafMonsterSpawnEgg;
        GameRegistry.registerItem(Constants.LeafMonsterSpawnEgg, "Leaf Monster Egg");

        SpawnEggs RedAntSpawnEgg = new SpawnEggs(EntityRedAnt.class);
        RedAntSpawnEgg.setUnlocalizedName("red_ant_egg");
        Constants.RedAntSpawnEgg = RedAntSpawnEgg;
        GameRegistry.registerItem(Constants.RedAntSpawnEgg, "Red Ant Egg");

        SpawnEggs RainBowAntSPawnEgg = new SpawnEggs(EntityRainbowAnt.class);
        RainBowAntSPawnEgg.setUnlocalizedName("rainbow_ant_egg");
        Constants.RainBowAntSPawnEgg = RainBowAntSPawnEgg;
        GameRegistry.registerItem(Constants.RainBowAntSPawnEgg, "Rainbow Ant Egg");

        SpawnEggs RoboGunnerSpawnEgg = new SpawnEggs(Robot3.class);
        RoboGunnerSpawnEgg.setUnlocalizedName("robo_gunner_egg");
        Constants.RoboGunnerSpawnEgg = RoboGunnerSpawnEgg;
        GameRegistry.registerItem(Constants.RoboGunnerSpawnEgg, "Robo Gunner Egg");

        SpawnEggs RoboPounderSpawnEgg = new SpawnEggs(Robot2.class);
        RoboPounderSpawnEgg.setUnlocalizedName("robo_pounder_egg");
        Constants.RoboPounderSpawnEgg = RoboPounderSpawnEgg;
        GameRegistry.registerItem(Constants.RoboPounderSpawnEgg, "Robo Pounder Egg");

        SpawnEggs FlounderSPawnEgg = new SpawnEggs(Flounder.class);
        FlounderSPawnEgg.setUnlocalizedName("flounder_egg");
        Constants.FlounderSPawnEgg = FlounderSPawnEgg;
        GameRegistry.registerItem(Constants.FlounderSPawnEgg, "Flounder Egg");

        SpawnEggs WhaleSpawnEgg = new SpawnEggs(WhaleRenderer.WhaleInstance.class);
        WhaleSpawnEgg.setUnlocalizedName("whale_egg");
        Constants.WhaleSpawnEgg = WhaleSpawnEgg;
        GameRegistry.registerItem(Constants.WhaleSpawnEgg, "WhaleInstance Egg");

        SpawnEggs SkateSpawnEgg = new SpawnEggs(Skate.class);
        SkateSpawnEgg.setUnlocalizedName("skate_egg");
        Constants.SkateSpawnEgg = SkateSpawnEgg;
        GameRegistry.registerItem(Constants.SkateSpawnEgg, "Skate Egg");

        SpawnEggs IrukandjiSpawnEgg = new SpawnEggs(Irukandji.class);
        IrukandjiSpawnEgg.setUnlocalizedName("irukandhi_egg");
        Constants.IrukandjiSpawnEgg = IrukandjiSpawnEgg;
        GameRegistry.registerItem(Constants.IrukandjiSpawnEgg, "Irukandji Egg");

        SpawnEggs crystalUrchinSpawnEgg = new SpawnEggs(Urchin.class);
        crystalUrchinSpawnEgg.setUnlocalizedName("crystal_urchin_egg");
        Constants.crystalUrchinSpawnEgg = crystalUrchinSpawnEgg;
        GameRegistry.registerItem(Constants.crystalUrchinSpawnEgg, "Crystal Urchin Egg");

        SpawnEggs goldenAppleCowSpawnEgg = new SpawnEggs(GoldenAppleCowInstance.class);
        goldenAppleCowSpawnEgg.setUnlocalizedName("golden_apple_cow_egg");
        Constants.GoldenAppleCowSpawnEgg = goldenAppleCowSpawnEgg;
        GameRegistry.registerItem(Constants.GoldenAppleCowSpawnEgg, "Golden Apple Cow Egg");

        SpawnEggs GazelleSpawnEgg = new SpawnEggs(Gazelle.class);
        GazelleSpawnEgg.setUnlocalizedName("gazelle_egg");
        Constants.GazelleSpawnEgg = GazelleSpawnEgg;
        GameRegistry.registerItem(Constants.GazelleSpawnEgg, "Gazelle Egg");

        SpawnEggs DragonflySpawnEgg = new SpawnEggs(Dragonfly.class);
        DragonflySpawnEgg.setUnlocalizedName("dragonfly_egg");
        Constants.DragonflySpawnEgg = DragonflySpawnEgg;
        GameRegistry.registerItem(Constants.DragonflySpawnEgg, "Dragonfly Egg");

        SpawnEggs DragonSpawnEgg = new SpawnEggs(Dragon.class);
        DragonSpawnEgg.setUnlocalizedName("dragon_egg");
        Constants.DragonSpawnEgg = DragonSpawnEgg;
        GameRegistry.registerItem(Constants.DragonSpawnEgg, "Dragon Egg");

        SpawnEggs AlosaurusSpawnEgg = new SpawnEggs(AlosaurusInstance.class);
        AlosaurusSpawnEgg.setUnlocalizedName("alosaurus_egg");
        Constants.AlosaurusSpawnEgg = AlosaurusSpawnEgg;
        GameRegistry.registerItem(Constants.AlosaurusSpawnEgg, "Alosaurus Egg");

        SpawnEggs LizardSPawnEgg = new SpawnEggs(Lizard.class);
        LizardSPawnEgg.setUnlocalizedName("lizard_egg");
        Constants.LizardSPawnEgg = LizardSPawnEgg;
        GameRegistry.registerItem(Constants.LizardSPawnEgg, "Lizard Egg");

        SpawnEggs CryolohosaurusSpawnEgg = new SpawnEggs(Cryolophosaurus.class);
        CryolohosaurusSpawnEgg.setUnlocalizedName("cryolophosaurus_egg");
        Constants.CryolohosaurusSpawnEgg = CryolohosaurusSpawnEgg;
        GameRegistry.registerItem(Constants.CryolohosaurusSpawnEgg, "Cryolophosaurus Egg");

        SpawnEggs BasiliskSpawnEgg = new SpawnEggs(BasilikInstance.class);
        BasiliskSpawnEgg.setUnlocalizedName("basilisc_egg");
        Constants.BasiliskSpawnEgg = BasiliskSpawnEgg;
        GameRegistry.registerItem(Constants.BasiliskSpawnEgg, "Basilisk Egg");

        SpawnEggs ChipmunkSpawnEgg = new SpawnEggs(ChipMunkInstance.class);
        ChipmunkSpawnEgg.setUnlocalizedName("chipmunk_egg");
        Constants.ChipmunkSpawnEgg = ChipmunkSpawnEgg;
        GameRegistry.registerItem(Constants.ChipmunkSpawnEgg, "Chipmunk Egg");

        SpawnEggs BrayonyxSPawnEgg = new SpawnEggs(BaryonyxInstance.class);
        BrayonyxSPawnEgg.setUnlocalizedName("baryonyx_egg");
        Constants.BrayonyxSPawnEgg = BrayonyxSPawnEgg;
        GameRegistry.registerItem(Constants.BrayonyxSPawnEgg, "Baryonyx Egg");

        SpawnEggs KrakenSpawnEgg = new SpawnEggs(Kraken.class);
        KrakenSpawnEgg.setUnlocalizedName("kraken_egg");
        Constants.KrakenSpawnEgg = KrakenSpawnEgg;
        GameRegistry.registerItem(Constants.KrakenSpawnEgg, "Uh, no. Don't.");

        SpawnEggs LurkingTerrorSpawnEgg = new SpawnEggs(LurkingTerror.class);
        LurkingTerrorSpawnEgg.setUnlocalizedName("lurking_terror_egg");
        Constants.LurkingTerrorSpawnEgg = LurkingTerrorSpawnEgg;
        GameRegistry.registerItem(Constants.LurkingTerrorSpawnEgg, "Lurking Terror Egg");

        SpawnEggs CamarasaurusSPawnEgg = new SpawnEggs(Camarasaurus.class);
        CamarasaurusSPawnEgg.setUnlocalizedName("camarasaurus_egg");
        Constants.CamarasaurusSPawnEgg = CamarasaurusSPawnEgg;
        GameRegistry.registerItem(Constants.CamarasaurusSPawnEgg, "Camarasaurus Egg");

        SpawnEggs SmallNightMareSpawnEgg = new SpawnEggs(PitchBlack.class);
        SmallNightMareSpawnEgg.setUnlocalizedName("nightmare_egg");
        Constants.SmallNightMareSpawnEgg = SmallNightMareSpawnEgg;
        GameRegistry.registerItem(Constants.SmallNightMareSpawnEgg, "Nightmare Egg");

        SpawnEggs VelocityRaptor = new SpawnEggs(VelocityRaptor.class);
        VelocityRaptor.setUnlocalizedName("velocityraptor_egg");
        Constants.VelocityRaptor = VelocityRaptor;
        GameRegistry.registerItem(Constants.VelocityRaptor, "Velocity Raptor Egg");

        SpawnEggs CepahdromeSPawnEgg = new SpawnEggs(Cephadrome.class);
        CepahdromeSPawnEgg.setUnlocalizedName("cephadrom_egg");
        Constants.CepahdromeSPawnEgg = CepahdromeSPawnEgg;
        GameRegistry.registerItem(Constants.CepahdromeSPawnEgg, "Cephadrome Egg");

        SpawnEggs WtfSpawnEgg = new SpawnEggs(GammaMetroid.class);
        WtfSpawnEgg.setUnlocalizedName("wtf_egg");
        Constants.WtfSpawnEgg = WtfSpawnEgg;
        GameRegistry.registerItem(Constants.WtfSpawnEgg, "WTF? Egg");

        SpawnEggs BirdSpawnEgg = new SpawnEggs(TinyBirdsInstance.class);
        BirdSpawnEgg.setUnlocalizedName("bird_egg");
        Constants.BirdSpawnEgg = BirdSpawnEgg;
        GameRegistry.registerItem(Constants.BirdSpawnEgg, "Bird Egg");

        SpawnEggs TinyBirdsSpawnEgg = new SpawnEggs(TinyBirdsInstance.class);
        TinyBirdsSpawnEgg.setUnlocalizedName("tiny_bird_egg");
        Constants.TinyBirdsSpawnEgg = TinyBirdsSpawnEgg;
        GameRegistry.registerItem(Constants.TinyBirdsSpawnEgg, "Tiny Bird Egg");

        SpawnEggs WaterDragonSpawnEgg = new SpawnEggs(WaterDragon.class);
        WaterDragonSpawnEgg.setUnlocalizedName("water_dragon_egg");
        Constants.WaterDragonSpawnEgg = WaterDragonSpawnEgg;
        GameRegistry.registerItem(Constants.WaterDragonSpawnEgg, "Water Dragon Egg");

        SpawnEggs EntityAetherDragonSpawnEgg = new SpawnEggs(EntityAetherDragon.class);
        EntityAetherDragonSpawnEgg.setUnlocalizedName("Entity Aether Dragon Egg");
        Constants.EntityAetherDragonSpawnEgg = EntityAetherDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityAetherDragonSpawnEgg, "Entity Aether Dragon Egg");

        SpawnEggs EntityAlpsDragonSpawnEgg = new SpawnEggs(EntityAlpsDragon.class);
        EntityAlpsDragonSpawnEgg.setUnlocalizedName("Entity Alps Dragon Egg");
        Constants.EntityAlpsDragonSpawnEgg = EntityAlpsDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityAlpsDragonSpawnEgg, "Entity Alps Dragon Egg");

        /*
         * SpawnEggs EntityAngelDragonSpawnEgg = new SpawnEggs(EntityAngelDragon.class);
         * EntityAngelDragonSpawnEgg.setUnlocalizedName("Entity Angel Dragon Egg");
         * Constants.EntityAngelDragonSpawnEgg = EntityAngelDragonSpawnEgg;
         * GameRegistry.registerItem(Constants.EntityAngelDragonSpawnEgg, "Entity Angel Dragon Egg");
         */

        SpawnEggs EntityBirchDragonSpawnEgg = new SpawnEggs(EntityBirchDragon.class);
        EntityBirchDragonSpawnEgg.setUnlocalizedName("Entity Birch Dragon Egg");
        Constants.EntityBirchDragonSpawnEgg = EntityBirchDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityBirchDragonSpawnEgg, "Entity Birch Dragon Egg");

        SpawnEggs EntityBlazeDragonSpawnEgg = new SpawnEggs(EntityBlazeDragon.class);
        EntityBlazeDragonSpawnEgg.setUnlocalizedName("Entity Blaze Dragon Egg");
        Constants.EntityBlazeDragonSpawnEgg = EntityBlazeDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityBlazeDragonSpawnEgg, "Entity Blaze Dragon Egg");

        SpawnEggs EntityBluestoneDragonSpawnEgg = new SpawnEggs(EntityBluestoneDragon.class);
        EntityBluestoneDragonSpawnEgg.setUnlocalizedName("Entity Bluestone Dragon Egg");
        Constants.EntityBluestoneDragonSpawnEgg = EntityBluestoneDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityBluestoneDragonSpawnEgg, "Entity Bluestone Dragon Egg");

        SpawnEggs EntityBoneDragonSpawnEgg = new SpawnEggs(EntityBoneDragon.class);
        EntityBoneDragonSpawnEgg.setUnlocalizedName("Entity Bone Dragon Egg");
        Constants.EntityBoneDragonSpawnEgg = EntityBoneDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityBoneDragonSpawnEgg, "Entity Bone Dragon Egg");

        SpawnEggs EntityCactusDragonSpawnEgg = new SpawnEggs(EntityCactusDragon.class);
        EntityCactusDragonSpawnEgg.setUnlocalizedName("Entity Cactus Dragon Egg");
        Constants.EntityCactusDragonSpawnEgg = EntityCactusDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityCactusDragonSpawnEgg, "Entity Cactus Dragon Egg");

        SpawnEggs EntityCaveDragonSpawnEgg = new SpawnEggs(EntityCaveDragon.class);
        EntityCaveDragonSpawnEgg.setUnlocalizedName("Entity Cave Dragon Egg");
        Constants.EntityCaveDragonSpawnEgg = EntityCaveDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityCaveDragonSpawnEgg, "Entity Cave Dragon Egg");

        SpawnEggs EntityCloudDragonSpawnEgg = new SpawnEggs(EntityCloudDragon.class);
        EntityCloudDragonSpawnEgg.setUnlocalizedName("Entity Cloud Dragon Egg");
        Constants.EntityCloudDragonSpawnEgg = EntityCloudDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityCloudDragonSpawnEgg, "Entity Cloud Dragon Egg");

        SpawnEggs EntityDesertDragonSpawnEgg = new SpawnEggs(EntityDesertDragon.class);
        EntityDesertDragonSpawnEgg.setUnlocalizedName("Entity Desert Dragon Egg");
        Constants.EntityDesertDragonSpawnEgg = EntityDesertDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityDesertDragonSpawnEgg, "Entity Desert Dragon Egg");

        SpawnEggs EntityDiamondDragonSpawnEgg = new SpawnEggs(EntityDiamondDragon.class);
        EntityDiamondDragonSpawnEgg.setUnlocalizedName("Entity Diamond Dragon Egg");
        Constants.EntityDiamondDragonSpawnEgg = EntityDiamondDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityDiamondDragonSpawnEgg, "Entity Diamond Dragon Egg");

        SpawnEggs EntityEndDragonSpawnEgg = new SpawnEggs(EntityEndDragon.class);
        EntityEndDragonSpawnEgg.setUnlocalizedName("Entity End Dragon Egg");
        Constants.EntityEndDragonSpawnEgg = EntityEndDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityEndDragonSpawnEgg, "Entity End Dragon Egg");

        SpawnEggs EntityEnthralledDragonSpawnEgg = new SpawnEggs(EntityEnthralledDragon.class);
        EntityEnthralledDragonSpawnEgg.setUnlocalizedName("Entity Enthralled Dragon Egg");
        Constants.EntityEnthralledDragonSpawnEgg = EntityEnthralledDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityEnthralledDragonSpawnEgg, "Entity Enthralled Dragon Egg");

        SpawnEggs EntityEmeraldDragonSpawnEgg = new SpawnEggs(EntityEmeraldDragon.class);
        EntityEmeraldDragonSpawnEgg.setUnlocalizedName("Entity Emerald Dragon Egg");
        Constants.EntityEmeraldDragonSpawnEgg = EntityEmeraldDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityEmeraldDragonSpawnEgg, "Entity Emerald Dragon Egg");

        SpawnEggs EntityExHillsDragonSpawnEgg = new SpawnEggs(EntityExHillsDragon.class);
        EntityExHillsDragonSpawnEgg.setUnlocalizedName("Entity ExHills Dragon Egg");
        Constants.EntityExHillsDragonSpawnEgg = EntityExHillsDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityExHillsDragonSpawnEgg, "Entity ExHills Dragon Egg");

        SpawnEggs EntityForestDragonSpawnEgg = new SpawnEggs(EntityForestDragon.class);
        EntityForestDragonSpawnEgg.setUnlocalizedName("Entity Forest Dragon Egg");
        Constants.EntityForestDragonSpawnEgg = EntityForestDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityForestDragonSpawnEgg, "Entity Forest Dragon Egg");

        SpawnEggs EntityGoldDragonSpawnEgg = new SpawnEggs(EntityGoldDragon.class);
        EntityGoldDragonSpawnEgg.setUnlocalizedName("Entity Gold Dragon Egg");
        Constants.EntityGoldDragonSpawnEgg = EntityGoldDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityGoldDragonSpawnEgg, "Entity Gold Dragon Egg");

        SpawnEggs EntityIronDragonSpawnEgg = new SpawnEggs(EntityIronDragon.class);
        EntityIronDragonSpawnEgg.setUnlocalizedName("Entity Iron Dragon Egg");
        Constants.EntityIronDragonSpawnEgg = EntityIronDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityIronDragonSpawnEgg, "Entity Iron Dragon Egg");

        SpawnEggs EntityJungleDragonSpawnEgg = new SpawnEggs(EntityJungleDragon.class);
        EntityJungleDragonSpawnEgg.setUnlocalizedName("Entity Jungle Dragon Egg");
        Constants.EntityJungleDragonSpawnEgg = EntityJungleDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityJungleDragonSpawnEgg, "Entity Jungle Dragon Egg");

        SpawnEggs EntityKleurloosSpawnEgg = new SpawnEggs(EntityKleurloos.class);
        EntityKleurloosSpawnEgg.setUnlocalizedName("Entity Kleurloos Egg");
        Constants.EntityKleurloosSpawnEgg = EntityKleurloosSpawnEgg;
        GameRegistry.registerItem(Constants.EntityKleurloosSpawnEgg, "Entity Kleurloos Egg");

        SpawnEggs EntityLapisDragonSpawnEgg = new SpawnEggs(EntityLapisDragon.class);
        EntityLapisDragonSpawnEgg.setUnlocalizedName("Entity Lapis Dragon Egg");
        Constants.EntityLapisDragonSpawnEgg = EntityLapisDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityLapisDragonSpawnEgg, "Entity Lapis Dragon Egg");

        SpawnEggs EntityMesaDragonSpawnEgg = new SpawnEggs(EntityMesaDragon.class);
        EntityMesaDragonSpawnEgg.setUnlocalizedName("Entity Mesa Dragon Egg");
        Constants.EntityMesaDragonSpawnEgg = EntityMesaDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityMesaDragonSpawnEgg, "Entity Mesa Dragon Egg");

        SpawnEggs EntityMushroomDragon1SpawnEgg = new SpawnEggs(EntityMushroomDragon1.class);
        EntityMushroomDragon1SpawnEgg.setUnlocalizedName("Entity Mushroom Dragon1 Egg");
        Constants.EntityMushroomDragon1SpawnEgg = EntityMushroomDragon1SpawnEgg;
        GameRegistry.registerItem(Constants.EntityMushroomDragon1SpawnEgg, "Entity Mushroom Dragon1 Egg");

        SpawnEggs EntityMushroomDragon2SpawnEgg = new SpawnEggs(EntityMushroomDragon2.class);
        EntityMushroomDragon2SpawnEgg.setUnlocalizedName("Entity Mushroom Dragon2 Egg");
        Constants.EntityMushroomDragon2SpawnEgg = EntityMushroomDragon2SpawnEgg;
        GameRegistry.registerItem(Constants.EntityMushroomDragon2SpawnEgg, "Entity Mushroom Dragon2 Egg");

        SpawnEggs EntityNetherDragonSpawnEgg = new SpawnEggs(EntityNetherDragon.class);
        EntityNetherDragonSpawnEgg.setUnlocalizedName("Entity Nether Dragon Egg");
        Constants.EntityNetherDragonSpawnEgg = EntityNetherDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityNetherDragonSpawnEgg, "Entity Nether Dragon Egg");

        SpawnEggs EntityOceanDragonSpawnEgg = new SpawnEggs(EntityOceanDragon.class);
        EntityOceanDragonSpawnEgg.setUnlocalizedName("Entity Ocean Dragon Egg");
        Constants.EntityOceanDragonSpawnEgg = EntityOceanDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityOceanDragonSpawnEgg, "Entity Ocean Dragon Egg");

        SpawnEggs EntityPlainsDragonSpawnEgg = new SpawnEggs(EntityPlainsDragon.class);
        EntityPlainsDragonSpawnEgg.setUnlocalizedName("Entity Plains Dragon1 Egg");
        Constants.EntityPlainsDragonSpawnEgg = EntityPlainsDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityPlainsDragonSpawnEgg, "Entity Plains Dragon1 Egg");
        SpawnEggs EntityPlainsDragon2SpawnEgg = new SpawnEggs(EntityPlainsDragon2.class);
        EntityPlainsDragon2SpawnEgg.setUnlocalizedName("Entity Plains Dragon2 Egg");
        Constants.EntityPlainsDragon2SpawnEgg = EntityPlainsDragon2SpawnEgg;
        GameRegistry.registerItem(Constants.EntityPlainsDragon2SpawnEgg, "Entity Plains Dragon2 Egg");
        SpawnEggs EntityRedstoneDragonSpawnEgg = new SpawnEggs(EntityRedstoneDragon.class);
        EntityRedstoneDragonSpawnEgg.setUnlocalizedName("Entity Redstone Dragon Egg");
        Constants.EntityRedstoneDragonSpawnEgg = EntityRedstoneDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityRedstoneDragonSpawnEgg, "Entity Redstone Dragon Egg");
        SpawnEggs EntityRiverDragonSpawnEgg = new SpawnEggs(EntityRiverDragon.class);
        EntityRiverDragonSpawnEgg.setUnlocalizedName("Entity River Dragon Egg");
        Constants.EntityRiverDragonSpawnEgg = EntityRiverDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityRiverDragonSpawnEgg, "Entity River Dragon Egg");
        SpawnEggs EntitySavannaDragonSpawnEgg = new SpawnEggs(EntitySavannaDragon.class);
        EntitySavannaDragonSpawnEgg.setUnlocalizedName("Entity Savanna Dragon Egg");
        Constants.EntitySavannaDragonSpawnEgg = EntitySavannaDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntitySavannaDragonSpawnEgg, "Entity Savanna Dragon Egg");
        SpawnEggs EntitySnowDragonSpawnEgg = new SpawnEggs(EntitySnowDragon.class);
        EntitySnowDragonSpawnEgg.setUnlocalizedName("Entity Snow Dragon Egg");
        Constants.EntitySnowDragonSpawnEgg = EntitySnowDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntitySnowDragonSpawnEgg, "Entity Snow Dragon Egg");
        SpawnEggs EntityStarDragonSpawnEgg = new SpawnEggs(EntityStarDragon.class);
        EntityStarDragonSpawnEgg.setUnlocalizedName("Entity Star Dragon Egg");
        Constants.EntityStarDragonSpawnEgg = EntityStarDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityStarDragonSpawnEgg, "Entity Star Dragon Egg");
        SpawnEggs EntitySwampDragonSpawnEgg = new SpawnEggs(EntitySwampDragon.class);
        EntitySwampDragonSpawnEgg.setUnlocalizedName("Entity Swamp Dragon Egg");
        Constants.EntitySwampDragonSpawnEgg = EntitySwampDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntitySwampDragonSpawnEgg, "Entity Swamp Dragon Egg");
        SpawnEggs EntityZombieDragonSpawnEgg = new SpawnEggs(EntityZombieDragon.class);
        EntityZombieDragonSpawnEgg.setUnlocalizedName("Entity Zombie Dragon Egg");
        Constants.EntityZombieDragonSpawnEgg = EntityZombieDragonSpawnEgg;
        GameRegistry.registerItem(Constants.EntityZombieDragonSpawnEgg, "Entity Zombie Dragon Egg");

        SpawnEggs MassoSpawnEgg = new SpawnEggs(MassoInstance.class);
        MassoSpawnEgg.setUnlocalizedName("Masso Egg");
        Constants.MassoSpawnEgg = MassoSpawnEgg;
        GameRegistry.registerItem(Constants.MassoSpawnEgg, "Masso Egg");

        SpawnEggs TriffidSpawnEgg = new SpawnEggs(Triffid.class);
        TriffidSpawnEgg.setUnlocalizedName("triffid_egg");
        Constants.TriffidSpawnEgg = TriffidSpawnEgg;
        GameRegistry.registerItem(Constants.TriffidSpawnEgg, "Triffid Egg");

        SpawnEggs HydroliscSpawnEgg = new SpawnEggs(Hydrolisc.class);
        HydroliscSpawnEgg.setUnlocalizedName("hydrolisc_egg");
        Constants.HydroliscSpawnEgg = HydroliscSpawnEgg;
        GameRegistry.registerItem(Constants.HydroliscSpawnEgg, "Hydrolisc Egg");

        SpawnEggs JumpyBugSpawnEgg = new SpawnEggs(TrooperBug.class);
        JumpyBugSpawnEgg.setUnlocalizedName("jumpy_bug_egg");
        Constants.JumpyBugSpawnEgg = JumpyBugSpawnEgg;
        GameRegistry.registerItem(Constants.JumpyBugSpawnEgg, "Jumpy Bug Egg");

        SpawnEggs TerribleTerrorSpawnEgg = new SpawnEggs(TerribleTerror.class);
        TerribleTerrorSpawnEgg.setUnlocalizedName("terrible_terror_egg");
        Constants.TerribleTerrorSpawnEgg = TerribleTerrorSpawnEgg;
        GameRegistry.registerItem(Constants.TerribleTerrorSpawnEgg, "Terrible Terror Egg");

        SpawnEggs KyuubiSpawnEgg = new SpawnEggs(Kyuubi.class);
        KyuubiSpawnEgg.setUnlocalizedName("kyuubi_egg");
        Constants.KyuubiSpawnEgg = KyuubiSpawnEgg;
        GameRegistry.registerItem(Constants.KyuubiSpawnEgg, "Kyuubi Egg");

        SpawnEggs SpitbugSpawnEgg = new SpawnEggs(SpitBug.class);
        SpitbugSpawnEgg.setUnlocalizedName("spitbug_egg");
        Constants.SpitbugSpawnEgg = SpitbugSpawnEgg;
        GameRegistry.registerItem(Constants.SpitbugSpawnEgg, "Spit Bug Egg");

        SpawnEggs CliffRacerSpawnEgg = new SpawnEggs(CliffRacer.class);
        CliffRacerSpawnEgg.setUnlocalizedName("cliff_racer_egg");
        Constants.CliffRacerSpawnEgg = CliffRacerSpawnEgg;
        GameRegistry.registerItem(Constants.CliffRacerSpawnEgg, "Cliff Racer Egg");

        SpawnEggs CreepingHorrorSpawnEgg = new SpawnEggs(CreepingHorror.class);
        CreepingHorrorSpawnEgg.setUnlocalizedName("creeping_horror_egg");
        Constants.CreepingHorrorSpawnEgg = CreepingHorrorSpawnEgg;
        GameRegistry.registerItem(Constants.CreepingHorrorSpawnEgg, "Creeping Horror Egg");

        SpawnEggs ScorpionSpawnEgg = new SpawnEggs(Scorpion.class);
        ScorpionSpawnEgg.setUnlocalizedName("scorpion_egg");
        Constants.ScorpionSpawnEgg = ScorpionSpawnEgg;
        GameRegistry.registerItem(Constants.ScorpionSpawnEgg, "Scorpion Egg");

        SpawnEggs CaveFisherSpawnEgg = new SpawnEggs(CaveFisherInstance.class);
        CaveFisherSpawnEgg.setUnlocalizedName("cave_fisher_egg");
        Constants.CaveFisherSpawnEgg = CaveFisherSpawnEgg;
        GameRegistry.registerItem(Constants.CaveFisherSpawnEgg, "Cave Fisher Egg");

        SpawnEggs StinkBugSpawnEgg = new SpawnEggs(StinkBug.class);
        StinkBugSpawnEgg.setUnlocalizedName("stink_bug_egg");
        Constants.StinkBugSpawnEgg = StinkBugSpawnEgg;
        GameRegistry.registerItem(Constants.StinkBugSpawnEgg, "Stink Bug Egg");

        SpawnEggs AttackSquidSpawnEgg = new SpawnEggs(AttackSquidInstance.class);
        AttackSquidSpawnEgg.setUnlocalizedName("attacksquid_egg");
        Constants.AttackSquidSpawnEgg = AttackSquidSpawnEgg;
        GameRegistry.registerItem(Constants.AttackSquidSpawnEgg, "Attack Squid Egg");

        SpawnEggs AlienSpawnEgg = new SpawnEggs(AlienInstance.class);
        AlienSpawnEgg.setUnlocalizedName("alien_egg");
        Constants.AlienSpawnEgg = AlienSpawnEgg;
        GameRegistry.registerItem(Constants.AlienSpawnEgg, "Alien Egg");

        SpawnEggs OstrichSpawnEgg = new SpawnEggs(Ostrich.class);
        OstrichSpawnEgg.setUnlocalizedName("ostrich_egg");
        Constants.OstrichSpawnEgg = OstrichSpawnEgg;
        GameRegistry.registerItem(Constants.OstrichSpawnEgg, "Ostrich Egg");

        SpawnEggs BeeSpawnEgg = new SpawnEggs(BeeInstance.class);
        BeeSpawnEgg.setUnlocalizedName("bee_egg");
        Constants.BeeSpawnEgg = BeeSpawnEgg;
        GameRegistry.registerItem(Constants.BeeSpawnEgg, "Bee Egg");

        SpawnEggs StinkySpawnEgg = new SpawnEggs(Stinky.class);
        StinkySpawnEgg.setUnlocalizedName("stinky_egg");
        Constants.StinkySpawnEgg = StinkySpawnEgg;
        GameRegistry.registerItem(Constants.StinkySpawnEgg, "Stinky Egg");

        SpawnEggs SeaViperSpawnEgg = new SpawnEggs(SeaViper.class);
        SeaViperSpawnEgg.setUnlocalizedName("sea_viper_egg");
        Constants.SeaViperSpawnEgg = SeaViperSpawnEgg;
        GameRegistry.registerItem(Constants.SeaViperSpawnEgg, "Sea Viper Egg");

        SpawnEggs BrutalflySpawnEgg = new SpawnEggs(Brutalfly.class);
        BrutalflySpawnEgg.setUnlocalizedName("brutalfly_egg");
        Constants.BrutalflySpawnEgg = BrutalflySpawnEgg;
        GameRegistry.registerItem(Constants.BrutalflySpawnEgg, "Brutalfly Egg");

        SpawnEggs JefferySpawnEgg = new SpawnEggs(GiantRobot.class);
        JefferySpawnEgg.setUnlocalizedName("jeffery_egg");
        Constants.JefferySpawnEgg = JefferySpawnEgg;
        GameRegistry.registerItem(Constants.JefferySpawnEgg, "Jeffery Egg");

        SpawnEggs FrogSpawnEgg = new SpawnEggs(Frog.class);
        FrogSpawnEgg.setUnlocalizedName("frog_egg");
        Constants.FrogSpawnEgg = FrogSpawnEgg;
        GameRegistry.registerItem(Constants.FrogSpawnEgg, "Frog Egg");

        SpawnEggs CriminalSpawnegg = new SpawnEggs(BandP.class);
        CriminalSpawnegg.setUnlocalizedName("criminal_egg");
        Constants.CriminalSpawnegg = CriminalSpawnegg;
        GameRegistry.registerItem(Constants.CriminalSpawnegg, "Criminal Egg");

        SpawnEggs SeaMonsterSpawnEgg = new SpawnEggs(SeaMonster.class);
        SeaMonsterSpawnEgg.setUnlocalizedName("sea_monster_egg");
        Constants.SeaMonsterSpawnEgg = SeaMonsterSpawnEgg;
        GameRegistry.registerItem(Constants.SeaMonsterSpawnEgg, "Sea Monster Egg");

        SpawnEggs MantisSpawnEgg = new SpawnEggs(Mantis.class);
        MantisSpawnEgg.setUnlocalizedName("mantis_egg");
        Constants.MantisSpawnEgg = MantisSpawnEgg;
        GameRegistry.registerItem(Constants.MantisSpawnEgg, "Mantis Egg");

        SpawnEggs HerculesBeetleSPawnEgg = new SpawnEggs(HerculesBeetle.class);
        HerculesBeetleSPawnEgg.setUnlocalizedName("hercules_egg");
        Constants.HerculesBeetleSPawnEgg = HerculesBeetleSPawnEgg;
        GameRegistry.registerItem(Constants.HerculesBeetleSPawnEgg, "Hercules Beetle Egg");

        SpawnEggs MolenoidSpawnEgg = new SpawnEggs(Molenoid.class);
        MolenoidSpawnEgg.setUnlocalizedName("molenoid_egg");
        Constants.MolenoidSpawnEgg = MolenoidSpawnEgg;
        GameRegistry.registerItem(Constants.MolenoidSpawnEgg, "Molenoid Egg");

        SpawnEggs TwilightMob = new SpawnEggs(TwilightMobInstance.class);
        MolenoidSpawnEgg.setUnlocalizedName("Twilight Mob Egg");
        Constants.TwilightMob = TwilightMob;
        GameRegistry.registerItem(Constants.TwilightMob, "Twilight Mob Egg");

        SpawnEggs DemonSpiderEntity = new SpawnEggs(DemonSpiderInstance.class);
        DemonSpiderEntity.setUnlocalizedName("Demon Spider Entity Egg");
        Constants.DemonSpiderEntity = DemonSpiderEntity;
        GameRegistry.registerItem(Constants.DemonSpiderEntity, "Demon Spider Entity Egg");

        SpawnEggs MyLeviathan = new SpawnEggs(LeviathanInstance.class);
        MyLeviathan.setUnlocalizedName("My Leviathan Egg");
        Constants.MyLeviathan = MyLeviathan;
        GameRegistry.registerItem(Constants.MyLeviathan, "My Leviathan Egg");
        SpawnEggs MyThunderHooves = new SpawnEggs(ThunderHoovesInstance.class);
        MyThunderHooves.setUnlocalizedName("My Thunder Hooves Egg");
        Constants.MyThunderHooves = MyThunderHooves;
        GameRegistry.registerItem(Constants.MyThunderHooves, "My Thunder Hooves Egg");
        SpawnEggs MyTwilicorn = new SpawnEggs(TwilicornInstance.class);
        MyTwilicorn.setUnlocalizedName("My Twilicorn Egg");
        Constants.MyTwilicorn = MyTwilicorn;
        GameRegistry.registerItem(Constants.MyTwilicorn, "My Twilicorn Egg");
        SpawnEggs MyKingbowser = new SpawnEggs(KingbowserInstance.class);
        MyKingbowser.setUnlocalizedName("My King bowser Egg");
        Constants.MyKingbowser = MyKingbowser;
        GameRegistry.registerItem(Constants.MyKingbowser, "My King bowser Egg");

        SpawnEggs MyCentipede = new SpawnEggs(CentipedeInstance.class);
        MyCentipede.setUnlocalizedName("My Centipede Egg");
        Constants.MyCentipede = MyCentipede;
        GameRegistry.registerItem(Constants.MyCentipede, "My Centipede Egg");

        SpawnEggs MyMLPHydra = new SpawnEggs(HydraInstance.class);
        MyMLPHydra.setUnlocalizedName("My MLP Hydra Egg");
        Constants.MyMLPHydra = MyMLPHydra;
        GameRegistry.registerItem(Constants.MyMLPHydra, "My MLP Hydra Egg");

        SpawnEggs MyWindigo = new SpawnEggs(WindigoInstance.class);
        MyWindigo.setUnlocalizedName("My Windigo Egg");
        Constants.MyWindigo = MyWindigo;
        GameRegistry.registerItem(Constants.MyWindigo, "My Windigo Egg");

        SpawnEggs MyMoose = new SpawnEggs(MooseInstance.class);
        MyMoose.setUnlocalizedName("My Moose Egg");
        Constants.MyMoose = MyMoose;
        GameRegistry.registerItem(Constants.MyMoose, "My Moose Egg");

        SpawnEggs MyMLPBuffalo = new SpawnEggs(BuffaloInstance.class);
        MyMLPBuffalo.setUnlocalizedName("My MLP Buffalo Egg");
        Constants.MyMLPBuffalo = MyMLPBuffalo;
        GameRegistry.registerItem(Constants.MyMLPBuffalo, "My MLP Buffalo Egg");

        SpawnEggs MyDarkness = new SpawnEggs(DarknessInstance.class);
        MyDarkness.setUnlocalizedName("My Darkness Egg");
        Constants.MyDarkness = MyDarkness;
        GameRegistry.registerItem(Constants.MyDarkness, "My Darkness Egg");

        SpawnEggs MyTwilightMagic = new SpawnEggs(TwilightMagicInstance.class);
        MyTwilightMagic.setUnlocalizedName("My Twilight Magic Egg");
        Constants.MyTwilightMagic = MyTwilightMagic;
        GameRegistry.registerItem(Constants.MyTwilightMagic, "My Twilight Magic Egg");

        SpawnEggs MyFlameDragon = new SpawnEggs(FlameDragonInstance.class);
        MyFlameDragon.setUnlocalizedName("My Flame Dragon Egg");
        Constants.MyFlameDragon = MyFlameDragon;
        GameRegistry.registerItem(Constants.MyFlameDragon, "My Flame Dragon Egg");

        SpawnEggs MyMooseBig = new SpawnEggs(MooseBigInstance.class);
        MyMooseBig.setUnlocalizedName("My Moose Big Egg");
        Constants.MyMooseBig = MyMooseBig;
        GameRegistry.registerItem(Constants.MyMooseBig, "My Moose Big Egg");

        SpawnEggs MyCragadile = new SpawnEggs(CragadileInstance.class);
        MyCragadile.setUnlocalizedName("My Cragadile Egg");
        Constants.MyCragadile = MyCragadile;
        GameRegistry.registerItem(Constants.MyCragadile, "My Cragadile Egg");

        SpawnEggs MyBear = new SpawnEggs(BearInstance.class);
        MyBear.setUnlocalizedName("My Bear Egg");
        Constants.MyBear = MyBear;
        GameRegistry.registerItem(Constants.MyBear, "My Bear Egg");

        SpawnEggs MyToughGuy = new SpawnEggs(ToughGuyInstance.class);
        MyToughGuy.setUnlocalizedName("My Tough Guy Egg");
        Constants.MyToughGuy = MyToughGuy;
        GameRegistry.registerItem(Constants.MyToughGuy, "My Tough Guy Egg");

        SpawnEggs MyMavis = new SpawnEggs(MavisInstance.class);
        MyMavis.setUnlocalizedName("My Mavis Egg");
        Constants.MyMavis = MyMavis;
        GameRegistry.registerItem(Constants.MyMavis, "My Mavis Egg");

        SpawnEggs MyUrsaMAJOR = new SpawnEggs(UrsaMAJORInstance.class);
        MyUrsaMAJOR.setUnlocalizedName("My Ursa MAJOR Egg");
        Constants.MyUrsaMAJOR = MyUrsaMAJOR;
        GameRegistry.registerItem(Constants.MyUrsaMAJOR, "My Ursa MAJOR Egg");

        SpawnEggs MyPhoenix = new SpawnEggs(PhoenixInstance.class);
        MyPhoenix.setUnlocalizedName("My Phoenix Egg");
        Constants.MyPhoenix = MyPhoenix;
        GameRegistry.registerItem(Constants.MyPhoenix, "My Phoenix Egg");

        SpawnEggs MyDash = new SpawnEggs(DashInstance.class);
        MyDash.setUnlocalizedName("My Dash Egg");
        Constants.MyDash = MyDash;
        GameRegistry.registerItem(Constants.MyDash, "My Dash Egg");

        SpawnEggs MyManticore = new SpawnEggs(ManticoreInstance.class);
        MyManticore.setUnlocalizedName("My Manticore Egg");
        Constants.MyManticore = MyManticore;
        GameRegistry.registerItem(Constants.MyManticore, "My Manticore Egg");

        SpawnEggs MyRainbowCentipede = new SpawnEggs(RainbowCentipedeInstance.class);
        MyRainbowCentipede.setUnlocalizedName("My Rainbow Centipede Egg");
        Constants.MyRainbowCentipede = MyRainbowCentipede;
        GameRegistry.registerItem(Constants.MyRainbowCentipede, "My Rainbow Centipede Egg");

        SpawnEggs MyParasprite = new SpawnEggs(ParaspriteInstance.class);
        MyParasprite.setUnlocalizedName("My Parasprite Egg");
        Constants.MyParasprite = MyParasprite;
        GameRegistry.registerItem(Constants.MyParasprite, "My Parasprite Egg");

        SpawnEggs MyAJ = new SpawnEggs(AJInstance.class);
        MyAJ.setUnlocalizedName("My AJ Egg");
        Constants.MyAJ = MyAJ;
        GameRegistry.registerItem(Constants.MyAJ, "My AJ Egg");

        SpawnEggs MyArcticScorpion = new SpawnEggs(ArcticScorpionInstance.class);
        MyArcticScorpion.setUnlocalizedName("My Arctic Scorpion Egg");
        Constants.MyArcticScorpion = MyArcticScorpion;
        GameRegistry.registerItem(Constants.MyArcticScorpion, "My Arctic Scorpion Egg");

        SpawnEggs MyTimberWolf = new SpawnEggs(TimberWolfInstance.class);
        MyTimberWolf.setUnlocalizedName("My Timber Wolf Egg");
        Constants.MyTimberWolf = MyTimberWolf;
        GameRegistry.registerItem(Constants.MyTimberWolf, "My Timber Wolf Egg");

        SpawnEggs MyCockatrice = new SpawnEggs(CockatriceInstance.class);
        MyCockatrice.setUnlocalizedName("My Cockatrice Egg");
        Constants.MyCockatrice = MyCockatrice;
        GameRegistry.registerItem(Constants.MyCockatrice, "My Cockatrice Egg");

        SpawnEggs MyIronWill = new SpawnEggs(IronWillInstance.class);
        MyIronWill.setUnlocalizedName("My Iron Will Egg");
        Constants.MyIronWill = MyIronWill;
        GameRegistry.registerItem(Constants.MyIronWill, "My Iron Will Egg");

        SpawnEggs MyCrabzilla = new SpawnEggs(CrabzillaInstance.class);
        MyCrabzilla.setUnlocalizedName("My Crabzilla Egg");
        Constants.MyCrabzilla = MyCrabzilla;
        GameRegistry.registerItem(Constants.MyCrabzilla, "My Crabzilla Egg");

        SpawnEggs MyDashCloud = new SpawnEggs(DashCloudInstance.class);
        MyDashCloud.setUnlocalizedName("My Dash Cloud Egg");
        Constants.MyDashCloud = MyDashCloud;
        GameRegistry.registerItem(Constants.MyDashCloud, "My Dash Cloud Egg");

        SpawnEggs TrevorPhillips = new SpawnEggs(TrevorPhillipsInstance.class);
        TrevorPhillips.setUnlocalizedName("Trevor Phillips Egg");
        Constants.TrevorPhillips = TrevorPhillips;
        GameRegistry.registerItem(Constants.TrevorPhillips, "Trevor Phillips Egg");

        SpawnEggs MySkullBoss = new SpawnEggs(SkullBossInstance.class);
        MySkullBoss.setUnlocalizedName("My Skull Boss Egg");
        Constants.MySkullBoss = MySkullBoss;
        GameRegistry.registerItem(Constants.MySkullBoss, "My Skull Boss Egg");

        SpawnEggs MySkull = new SpawnEggs(SkullInstance.class);
        MySkull.setUnlocalizedName("My Skull Egg");
        Constants.MySkull = MySkull;
        GameRegistry.registerItem(Constants.MySkull, "My Skull Egg");

        SpawnEggs MyYakPrince = new SpawnEggs(YakPrinceInstance.class);
        MyYakPrince.setUnlocalizedName("My Yak Prince Egg");
        Constants.MyYakPrince = MyYakPrince;
        GameRegistry.registerItem(Constants.MyYakPrince, "My Yak Prince Egg");

        SpawnEggs MySpikezilla = new SpawnEggs(SpikezillaInstance.class);
        MySpikezilla.setUnlocalizedName("My Spikezilla Egg");
        Constants.MySpikezilla = MySpikezilla;
        GameRegistry.registerItem(Constants.MySpikezilla, "My Spikezilla Egg");

        SpawnEggs MyRhinoceros = new SpawnEggs(RhinocerosInstance.class);
        MyRhinoceros.setUnlocalizedName("My Rhinoceros Egg");
        Constants.MyRhinoceros = MyRhinoceros;
        GameRegistry.registerItem(Constants.MyRhinoceros, "My Rhinoceros Egg");

        SpawnEggs TwilightCannon = new SpawnEggs(TwilightCannonInstance.class);
        TwilightCannon.setUnlocalizedName("Twilight Cannon Egg");
        Constants.TwilightCannon = TwilightCannon;
        GameRegistry.registerItem(Constants.TwilightCannon, "Twilight Cannon Egg");

        SpawnEggs LaserBallMLP = new SpawnEggs(LaserBallSecondInstance.class);
        LaserBallMLP.setUnlocalizedName("Laser Ball MLP Egg");
        Constants.LaserBallMLP = LaserBallMLP;
        GameRegistry.registerItem(Constants.LaserBallMLP, "Laser Ball MLP Egg");

        /*
         * SpawnEggs MavisBallInstance = new
         * SpawnEggs(fr.iamacat.dangerzone_iamacatfr.entities.entity.MavisBallInstance.class);
         * MavisBallInstance.setUnlocalizedName("Mavis Ball Egg");
         * Constants.MavisBallInstance = MolenoidSpawnEgg;
         * GameRegistry.registerItem(Constants.MavisBallInstance, "Mavis Ball Egg");
         */

        SpawnEggs TwilicornArrow = new SpawnEggs(TwilicornArrowInstance.class);
        TwilicornArrow.setUnlocalizedName("Twilicorn Arrow Egg");
        Constants.TwilicornArrow = TwilicornArrow;
        GameRegistry.registerItem(Constants.TwilicornArrow, "Twilicorn Arrow Egg");

        SpawnEggs PhoenixArrow = new SpawnEggs(PhoenixArrowInstance.class);
        PhoenixArrow.setUnlocalizedName("Phoenix Arrow Egg");
        Constants.PhoenixArrow = PhoenixArrow;
        GameRegistry.registerItem(Constants.PhoenixArrow, "Phoenix Arrow Egg");

        SpawnEggs TwilyMagic = new SpawnEggs(TwilyMagicInstance.class);
        TwilyMagic.setUnlocalizedName("Twily Magic Egg");
        Constants.TwilyMagic = TwilyMagic;
        GameRegistry.registerItem(Constants.TwilyMagic, "Twily Magic Egg");

        SpawnEggs DarkCrystalCannon = new SpawnEggs(DarkCrystalCannonInstance.class);
        DarkCrystalCannon.setUnlocalizedName("Dark Crystal Cannon Egg");
        Constants.DarkCrystalCannon = DarkCrystalCannon;
        GameRegistry.registerItem(Constants.DarkCrystalCannon, "Dark Crystal Cannon Egg");

        SpawnEggs WindigoPower = new SpawnEggs(WindigoPowerInstance.class);
        WindigoPower.setUnlocalizedName("Windigo Power Egg");
        Constants.WindigoPower = WindigoPower;
        GameRegistry.registerItem(Constants.WindigoPower, "Windigo Power Egg");

        SpawnEggs LongHit = new SpawnEggs(LongHitInstance.class);
        LongHit.setUnlocalizedName("Long Hit Egg");
        Constants.LongHit = LongHit;
        GameRegistry.registerItem(Constants.LongHit, "Long Hit Egg");

        SpawnEggs MyMagic = new SpawnEggs(MagicInstance.class);
        MyMagic.setUnlocalizedName("My Magic Egg");
        Constants.MyMagic = MyMagic;
        GameRegistry.registerItem(Constants.MyMagic, "My Magic Egg");

        SpawnEggs BetterFireball = new SpawnEggs(BetterFireballInstance.class);
        BetterFireball.setUnlocalizedName("Better Fireball Egg");
        Constants.BetterFireball = BetterFireball;
        GameRegistry.registerItem(Constants.BetterFireball, "Better Fireball Egg");

        SpawnEggs TwilightFireball = new SpawnEggs(TwilightFireballInstance.class);
        TwilightFireball.setUnlocalizedName("Twilight Fireball Egg");
        Constants.TwilightFireball = TwilightFireball;
        GameRegistry.registerItem(Constants.TwilightFireball, "Twilight Fireball Egg");

        SpawnEggs HydraFireball = new SpawnEggs(HydraFireballInstance.class);
        HydraFireball.setUnlocalizedName("Hydra Fire ball Egg");
        Constants.HydraFireball = HydraFireball;
        GameRegistry.registerItem(Constants.HydraFireball, "Hydra Fire ball Egg");

        SpawnEggs FreezeBall = new SpawnEggs(FreezeBall.class);
        FreezeBall.setUnlocalizedName("Freeze Ball Egg");
        Constants.FreezeBall = FreezeBall;
        GameRegistry.registerItem(Constants.FreezeBall, "Freeze Ball Egg");

        SpawnEggs RobotBeam = new SpawnEggs(RobotBeamInstance.class);
        RobotBeam.setUnlocalizedName("Robot Beam Egg");
        Constants.RobotBeam = RobotBeam;
        GameRegistry.registerItem(Constants.RobotBeam, "Robot Beam Egg");

        SpawnEggs FireCannon = new SpawnEggs(FireCannon.class);
        FireCannon.setUnlocalizedName("Fire Cannon Egg");
        Constants.FireCannon = FireCannon;
        GameRegistry.registerItem(Constants.FireCannon, "Fire Cannon Egg");

        SpawnEggs RainbowCannon = new SpawnEggs(RainbowCannonInstance.class);
        RainbowCannon.setUnlocalizedName("Rainbow Cannon Egg");
        Constants.RainbowCannon = RainbowCannon;
        GameRegistry.registerItem(Constants.RainbowCannon, "Rainbow Cannon Egg");

        SpawnEggs ProjectileApples = new SpawnEggs(ProjectileApplesInstance.class);
        ProjectileApples.setUnlocalizedName("Projectile Apples Egg");
        Constants.ProjectileApples = ProjectileApples;
        GameRegistry.registerItem(Constants.ProjectileApples, "Projectile Apples Egg");


    }
}
