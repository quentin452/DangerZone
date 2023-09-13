package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.CrystalCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EnchantedGoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GoldenAppleCowInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.*;
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

        SpawnEggs TheKingSpawnEgg = new SpawnEggs(TheKingInstance.class);
        TheKingSpawnEgg.setUnlocalizedName("the_king_egg");
        Constants.TheKingSpawnEgg = TheKingSpawnEgg;
        GameRegistry.registerItem(Constants.TheKingSpawnEgg, "The King Egg");

        SpawnEggs TheQueenSpawnEgg = new SpawnEggs(TheQueenInstance.class);
        TheQueenSpawnEgg.setUnlocalizedName("the_queen_egg");
        Constants.TheQueenSpawnEgg = TheQueenSpawnEgg;
        GameRegistry.registerItem(Constants.TheQueenSpawnEgg, "The Queen Egg");

        SpawnEggs Girlfriend = new SpawnEggs(GirlFriendInstance.class);
        Girlfriend.setUnlocalizedName("girlfriend_egg");
        Constants.Girlfriend = Girlfriend;
        GameRegistry.registerItem(Constants.Girlfriend, "Girlfriend Egg");

        SpawnEggs Boyfriend = new SpawnEggs(BoyFriendInstance.class);
        Boyfriend.setUnlocalizedName("boyfriend_egg");
        Constants.Boyfriend = Boyfriend;
        GameRegistry.registerItem(Constants.Boyfriend, "Boyfriend Egg");

        SpawnEggs ThePrinceSpawnEgg = new SpawnEggs(ThePrinceInstance.class);
        ThePrinceSpawnEgg.setUnlocalizedName("the_prince_egg");
        Constants.ThePrinceSpawnEgg = ThePrinceSpawnEgg;
        GameRegistry.registerItem(Constants.ThePrinceSpawnEgg, "The Prince Egg");

        SpawnEggs MOTHRASpawnEgg = new SpawnEggs(MOTHRAInstance.class);
        MOTHRASpawnEgg.setUnlocalizedName("mothra_egg");
        Constants.MOTHRASpawnEgg = MOTHRASpawnEgg;
        GameRegistry.registerItem(Constants.MOTHRASpawnEgg, "MOTHRA! Egg");

        SpawnEggs EnderKnightSpawnEgg = new SpawnEggs(EnderKnightInstance.class);
        EnderKnightSpawnEgg.setUnlocalizedName("ender_knight_egg");
        Constants.EnderKnightSpawnEgg = EnderKnightSpawnEgg;
        GameRegistry.registerItem(Constants.EnderKnightSpawnEgg, "Ender Knight Egg");

        SpawnEggs EnderReaperSpawnEgg = new SpawnEggs(EnderReaperInstance.class);
        EnderReaperSpawnEgg.setUnlocalizedName("ender_reaper_egg");
        Constants.EnderReaperSpawnEgg = EnderReaperSpawnEgg;
        GameRegistry.registerItem(Constants.EnderReaperSpawnEgg, "Ender Reaper Egg");

        SpawnEggs BeaverSpawnEgg = new SpawnEggs(BeaverInstance.class);
        BeaverSpawnEgg.setUnlocalizedName("beaver_egg");
        Constants.BeaverSpawnEgg = BeaverSpawnEgg;
        GameRegistry.registerItem(Constants.BeaverSpawnEgg, "Beaver Egg");

        SpawnEggs CloudSharkSpawnEgg = new SpawnEggs(CloudSharkInstance.class);
        CloudSharkSpawnEgg.setUnlocalizedName("cloud_shark_egg");
        Constants.CloudSharkSpawnEgg = CloudSharkSpawnEgg;
        GameRegistry.registerItem(Constants.CloudSharkSpawnEgg, "Cloud Shark Egg");

        SpawnEggs CassowarySpawnEgg = new SpawnEggs(CassowaryInstance.class);
        CassowarySpawnEgg.setUnlocalizedName("cassowary_egg");
        Constants.CassowarySpawnEgg = CassowarySpawnEgg;
        GameRegistry.registerItem(Constants.CassowarySpawnEgg, "Cassowary Egg");

        SpawnEggs LargeWormSpawnEgg = new SpawnEggs(LargeWormInstance.class);
        LargeWormSpawnEgg.setUnlocalizedName("large_worm_egg");
        Constants.LargeWormSpawnEgg = LargeWormSpawnEgg;
        GameRegistry.registerItem(Constants.LargeWormSpawnEgg, "Large Worm Egg");

        SpawnEggs MediumWormSpawnEgg = new SpawnEggs(MediumWormInstance.class);
        MediumWormSpawnEgg.setUnlocalizedName("medium_worm_egg");
        Constants.MediumWormSpawnEgg = MediumWormSpawnEgg;
        GameRegistry.registerItem(Constants.MediumWormSpawnEgg, "Medium Worm Egg");

        SpawnEggs SmallWormSpawnEgg = new SpawnEggs(SmallWormInstance.class);
        SmallWormSpawnEgg.setUnlocalizedName("small_worm_egg");
        Constants.SmallWormSpawnEgg = SmallWormSpawnEgg;
        GameRegistry.registerItem(Constants.SmallWormSpawnEgg, "Small Worm Egg");

        SpawnEggs GoldFishSpawnEgg = new SpawnEggs(GoldFishInstance.class);
        GoldFishSpawnEgg.setUnlocalizedName("gold_fish_egg");
        Constants.GoldFishSpawnEgg = GoldFishSpawnEgg;
        GameRegistry.registerItem(Constants.GoldFishSpawnEgg, "Gold Fish Egg");

        SpawnEggs LeonopteryxSpawnEgg = new SpawnEggs(LeonopteryxInstance.class);
        LeonopteryxSpawnEgg.setUnlocalizedName("leonopteryx_egg");
        Constants.LeonopteryxSpawnEgg = LeonopteryxSpawnEgg;
        GameRegistry.registerItem(Constants.LeonopteryxSpawnEgg, "Leonopteryx Egg");

        SpawnEggs EmperorScorpionEgg = new SpawnEggs(EmperorScorpionInstance.class);
        EmperorScorpionEgg.setUnlocalizedName("emperor_scorpion_egg");
        Constants.EmperorScorpionEgg = EmperorScorpionEgg;
        GameRegistry.registerItem(Constants.EmperorScorpionEgg, "Emperor Scorpion Egg");

        SpawnEggs ThePrincessSpawnEgg = new SpawnEggs(ThePrincessInstance.class);
        ThePrincessSpawnEgg.setUnlocalizedName("the_princess_egg");
        Constants.ThePrincessSpawnEgg = ThePrincessSpawnEgg;
        GameRegistry.registerItem(Constants.ThePrincessSpawnEgg, "The Pricess Egg");

        SpawnEggs CrabSpawnEgg = new SpawnEggs(CrabInstance.class);
        CrabSpawnEgg.setUnlocalizedName("crab_egg");
        Constants.CrabSpawnEgg = CrabSpawnEgg;
        GameRegistry.registerItem(Constants.CrabSpawnEgg, "Crab Egg");

        SpawnEggs SpiderDriverSpawnEgg = new SpawnEggs(SpiderDriverInstance.class);
        SpiderDriverSpawnEgg.setUnlocalizedName("spider_driver_egg");
        Constants.SpiderDriverSpawnEgg = SpiderDriverSpawnEgg;
        GameRegistry.registerItem(Constants.SpiderDriverSpawnEgg, "Spider Driver Egg");

        SpawnEggs CricketSpawnEgg = new SpawnEggs(CricketInstance.class);
        CricketSpawnEgg.setUnlocalizedName("cricket_egg");
        Constants.CricketSpawnEgg = CricketSpawnEgg;
        GameRegistry.registerItem(Constants.CricketSpawnEgg, "Cricket Egg");

        SpawnEggs HammerheadSpawnEgg = new SpawnEggs(HammerheadInstance.class);
        HammerheadSpawnEgg.setUnlocalizedName("hammerhead_egg");
        Constants.HammerheadSpawnEgg = HammerheadSpawnEgg;
        GameRegistry.registerItem(Constants.HammerheadSpawnEgg, "Hammer Head Egg");

        SpawnEggs EasterbunnySpawnEgg = new SpawnEggs(EasterBunnyInstance.class);
        EasterbunnySpawnEgg.setUnlocalizedName("easter_bunny_egg");
        Constants.EasterbunnySpawnEgg = EasterbunnySpawnEgg;
        GameRegistry.registerItem(Constants.EasterbunnySpawnEgg, "Easter Bunny Egg");

        SpawnEggs TrexSpawnEgg = new SpawnEggs(TrexInstance.class);
        TrexSpawnEgg.setUnlocalizedName("trex_egg");
        Constants.TrexSpawnEgg = TrexSpawnEgg;
        GameRegistry.registerItem(Constants.TrexSpawnEgg, "T.Rex Egg");

        SpawnEggs PointysaurusSpawnEgg = new SpawnEggs(PointysaurusInstance.class);
        PointysaurusSpawnEgg.setUnlocalizedName("pointysaurus_egg");
        Constants.PointysaurusSpawnEgg = PointysaurusSpawnEgg;
        GameRegistry.registerItem(Constants.PointysaurusSpawnEgg, "Pointysaurus Egg");

        SpawnEggs FireflySpawnEgg = new SpawnEggs(FireflyInstance.class);
        FireflySpawnEgg.setUnlocalizedName("firefly_egg");
        Constants.FireflySpawnEgg = FireflySpawnEgg;
        GameRegistry.registerItem(Constants.FireflySpawnEgg, "Firefly Egg");

        SpawnEggs RubberDuckySpawnegg = new SpawnEggs(RubberDuckyInstance.class);
        RubberDuckySpawnegg.setUnlocalizedName("rubbr_ducky_egg");
        Constants.RubberDuckySpawnegg = RubberDuckySpawnegg;
        GameRegistry.registerItem(Constants.RubberDuckySpawnegg, "Rubber Ducky Egg");

        SpawnEggs RedAntRobotSpawnEgg = new SpawnEggs(RedAntRobotInstance.class);
        RedAntRobotSpawnEgg.setUnlocalizedName("red_ant_robot_egg");
        Constants.RedAntRobot = RedAntRobotSpawnEgg;
        GameRegistry.registerItem(Constants.RedAntRobot, "Red Ant Robot Egg");

        SpawnEggs GiantSpiderRobotSpawnEgg = new SpawnEggs(SpiderRobotInstance.class);
        GiantSpiderRobotSpawnEgg.setUnlocalizedName("giant_spider_robot_egg");
        Constants.GiantSpiderRobotSpawnEgg = GiantSpiderRobotSpawnEgg;
        GameRegistry.registerItem(Constants.GiantSpiderRobotSpawnEgg, "Giant Spider Robot Egg");

        SpawnEggs CaterKillerSpawnEgg = new SpawnEggs(CaterkillerInstance.class);
        CaterKillerSpawnEgg.setUnlocalizedName("catterkiller_egg");
        Constants.CaterKillerSpawnEgg = CaterKillerSpawnEgg;
        GameRegistry.registerItem(Constants.CaterKillerSpawnEgg, "Cater Killer Egg");

        SpawnEggs NastysaurusSpawnEgg = new SpawnEggs(NastysaurusInstance.class);
        NastysaurusSpawnEgg.setUnlocalizedName("nastysaurus_egg");
        Constants.NastysaurusSpawnEgg = NastysaurusSpawnEgg;
        GameRegistry.registerItem(Constants.NastysaurusSpawnEgg, "Nastysaurus Egg");

        SpawnEggs RoboSniperSpawnEgg = new SpawnEggs(RoboSniperInstance.class);
        RoboSniperSpawnEgg.setUnlocalizedName("robot_sniper_egg");
        Constants.RoboSniperSpawnEgg = RoboSniperSpawnEgg;
        GameRegistry.registerItem(Constants.RoboSniperSpawnEgg, "Robot-Sniper Egg");

        SpawnEggs BrownAntSpawnEgg = new SpawnEggs(BrownAntInstance.class);
        BrownAntSpawnEgg.setUnlocalizedName("brown_ant_egg");
        Constants.BrownAntSpawnEgg = BrownAntSpawnEgg;
        GameRegistry.registerItem(Constants.BrownAntSpawnEgg, "Brown Ant Egg");

        SpawnEggs MosquitoSpawnEgg = new SpawnEggs(MosquitoInstance.class);
        MosquitoSpawnEgg.setUnlocalizedName("mosquito_egg");
        Constants.MosquitoSpawnEgg = MosquitoSpawnEgg;
        GameRegistry.registerItem(Constants.MosquitoSpawnEgg, "Mosquito Egg");

        SpawnEggs MothSpawnEgg = new SpawnEggs(MothInstance.class);
        MothSpawnEgg.setUnlocalizedName("moth_egg");
        Constants.MothSpawnEgg = MothSpawnEgg;
        GameRegistry.registerItem(Constants.MothSpawnEgg, "Moth Egg");

        SpawnEggs RoboWarriorSpawnEgg = new SpawnEggs(RoboWarriorInstance.class);
        RoboWarriorSpawnEgg.setUnlocalizedName("robo_warrior_egg");
        Constants.RoboWarriorSpawnEgg = RoboWarriorSpawnEgg;
        GameRegistry.registerItem(Constants.RoboWarriorSpawnEgg, "Robo Warrior Egg");

        SpawnEggs UnstableAntSpawnEgg = new SpawnEggs(UnstableAntInstance.class);
        UnstableAntSpawnEgg.setUnlocalizedName("unstable_ant_egg");
        Constants.UnstableAntSpawnEgg = UnstableAntSpawnEgg;
        GameRegistry.registerItem(Constants.UnstableAntSpawnEgg, "Unstable Ant Egg");

        SpawnEggs GhostSpawnEgg = new SpawnEggs(GhostInstance.class);
        GhostSpawnEgg.setUnlocalizedName("ghost_egg");
        Constants.GhostSpawnEgg = GhostSpawnEgg;
        GameRegistry.registerItem(Constants.GhostSpawnEgg, "Ghost Egg");

        SpawnEggs termiteSPawnEgg = new SpawnEggs(TermiteInstance.class);
        termiteSPawnEgg.setUnlocalizedName("termite_egg");
        Constants.termiteSPawnEgg = termiteSPawnEgg;
        GameRegistry.registerItem(Constants.termiteSPawnEgg, "Termite Egg");

        SpawnEggs GhostPunpkinSkellySpawnEgg = new SpawnEggs(GhostSkeletonInstance.class);
        GhostPunpkinSkellySpawnEgg.setUnlocalizedName("ghost_pumpkin_skelly_egg");
        Constants.GhostPunpkinSkellySpawnEgg = GhostPunpkinSkellySpawnEgg;
        GameRegistry.registerItem(Constants.GhostPunpkinSkellySpawnEgg, "Ghost Pumpkin Skelly Egg");

        SpawnEggs ButterflySpawnEgg = new SpawnEggs(ButterflyInstance.class);
        ButterflySpawnEgg.setUnlocalizedName("butterfly_egg");
        Constants.ButterflySpawnEgg = ButterflySpawnEgg;
        GameRegistry.registerItem(Constants.ButterflySpawnEgg, "Butterfly Egg");

        SpawnEggs BombombSpawnEgg = new SpawnEggs(Bomb_ombInstance.class);
        BombombSpawnEgg.setUnlocalizedName("bomb_omb_egg");
        Constants.BombombSpawnEgg = BombombSpawnEgg;
        GameRegistry.registerItem(Constants.BombombSpawnEgg, "Bomb Omb Egg");

        SpawnEggs RatSpawnEgg = new SpawnEggs(RatInstance.class);
        RatSpawnEgg.setUnlocalizedName("rat_egg");
        Constants.RatSpawnEgg = RatSpawnEgg;
        GameRegistry.registerItem(Constants.RatSpawnEgg, "Rat Egg");

        SpawnEggs FairySpawnEgg = new SpawnEggs(FairyInstance.class);
        FairySpawnEgg.setUnlocalizedName("fairy_egg");
        Constants.FairySpawnEgg = FairySpawnEgg;
        GameRegistry.registerItem(Constants.FairySpawnEgg, "Fairy Egg");

        SpawnEggs PeacockSpawnEgg = new SpawnEggs(PeacockInstance.class);
        PeacockSpawnEgg.setUnlocalizedName("peacock_egg");
        Constants.PeacockSpawnEgg = PeacockSpawnEgg;
        GameRegistry.registerItem(Constants.PeacockSpawnEgg, "Peacock Egg");

        SpawnEggs VortexSpawnEgg = new SpawnEggs(VortexInstance.class);
        VortexSpawnEgg.setUnlocalizedName("vortex_egg");
        Constants.VortexSpawnEgg = VortexSpawnEgg;
        GameRegistry.registerItem(Constants.VortexSpawnEgg, "Vortex Egg");

        SpawnEggs RotatorSpawnEgg = new SpawnEggs(RotatorInstance.class);
        RotatorSpawnEgg.setUnlocalizedName("rotator_egg");
        Constants.RotatorSpawnEgg = RotatorSpawnEgg;
        GameRegistry.registerItem(Constants.RotatorSpawnEgg, "Rotator Egg");

        SpawnEggs DungeonBeastSpawnEgg = new SpawnEggs(DungeonBeastInstance.class);
        DungeonBeastSpawnEgg.setUnlocalizedName("dungeon_beast_egg");
        Constants.DungeonBeastSpawnEgg = DungeonBeastSpawnEgg;
        GameRegistry.registerItem(Constants.DungeonBeastSpawnEgg, "Dungeon Beast Egg");

        SpawnEggs LeafMonsterSpawnEgg = new SpawnEggs(LeafMonsterInstance.class);
        LeafMonsterSpawnEgg.setUnlocalizedName("leaf_monster_egg");
        Constants.LeafMonsterSpawnEgg = LeafMonsterSpawnEgg;
        GameRegistry.registerItem(Constants.LeafMonsterSpawnEgg, "Leaf Monster Egg");

        SpawnEggs RedAntSpawnEgg = new SpawnEggs(RedAntInstance.class);
        RedAntSpawnEgg.setUnlocalizedName("red_ant_egg");
        Constants.RedAntSpawnEgg = RedAntSpawnEgg;
        GameRegistry.registerItem(Constants.RedAntSpawnEgg, "Red Ant Egg");

        SpawnEggs RainBowAntSPawnEgg = new SpawnEggs(RainbowAntInstance.class);
        RainBowAntSPawnEgg.setUnlocalizedName("rainbow_ant_egg");
        Constants.RainBowAntSPawnEgg = RainBowAntSPawnEgg;
        GameRegistry.registerItem(Constants.RainBowAntSPawnEgg, "Rainbow Ant Egg");

        SpawnEggs RoboGunnerSpawnEgg = new SpawnEggs(RoboGunnerInstance.class);
        RoboGunnerSpawnEgg.setUnlocalizedName("robo_gunner_egg");
        Constants.RoboGunnerSpawnEgg = RoboGunnerSpawnEgg;
        GameRegistry.registerItem(Constants.RoboGunnerSpawnEgg, "Robo Gunner Egg");

        SpawnEggs RoboPounderSpawnEgg = new SpawnEggs(RoboPounderInstance.class);
        RoboPounderSpawnEgg.setUnlocalizedName("robo_pounder_egg");
        Constants.RoboPounderSpawnEgg = RoboPounderSpawnEgg;
        GameRegistry.registerItem(Constants.RoboPounderSpawnEgg, "Robo Pounder Egg");

        SpawnEggs FlounderSPawnEgg = new SpawnEggs(FlounderInstance.class);
        FlounderSPawnEgg.setUnlocalizedName("flounder_egg");
        Constants.FlounderSPawnEgg = FlounderSPawnEgg;
        GameRegistry.registerItem(Constants.FlounderSPawnEgg, "Flounder Egg");

        SpawnEggs WhaleSpawnEgg = new SpawnEggs(WhaleInstance.class);
        WhaleSpawnEgg.setUnlocalizedName("whale_egg");
        Constants.WhaleSpawnEgg = WhaleSpawnEgg;
        GameRegistry.registerItem(Constants.WhaleSpawnEgg, "Whale Egg");

        SpawnEggs SkateSpawnEgg = new SpawnEggs(SkateInstance.class);
        SkateSpawnEgg.setUnlocalizedName("skate_egg");
        Constants.SkateSpawnEgg = SkateSpawnEgg;
        GameRegistry.registerItem(Constants.SkateSpawnEgg, "Skate Egg");

        SpawnEggs IrukandjiSpawnEgg = new SpawnEggs(IrukandjiInstance.class);
        IrukandjiSpawnEgg.setUnlocalizedName("irukandhi_egg");
        Constants.IrukandjiSpawnEgg = IrukandjiSpawnEgg;
        GameRegistry.registerItem(Constants.IrukandjiSpawnEgg, "Irukandji Egg");

        SpawnEggs crystalUrchinSpawnEgg = new SpawnEggs(CrystalUrchinInstance.class);
        crystalUrchinSpawnEgg.setUnlocalizedName("crystal_urchin_egg");
        Constants.crystalUrchinSpawnEgg = crystalUrchinSpawnEgg;
        GameRegistry.registerItem(Constants.crystalUrchinSpawnEgg, "Crystal Urchin Egg");

        SpawnEggs goldenAppleCowSpawnEgg = new SpawnEggs(GoldenAppleCowInstance.class);
        goldenAppleCowSpawnEgg.setUnlocalizedName("golden_apple_cow_egg");
        Constants.GoldenAppleCowSpawnEgg = goldenAppleCowSpawnEgg;
        GameRegistry.registerItem(Constants.GoldenAppleCowSpawnEgg, "Golden Apple Cow Egg");

        SpawnEggs GazelleSpawnEgg = new SpawnEggs(GazelleInstance.class);
        GazelleSpawnEgg.setUnlocalizedName("gazelle_egg");
        Constants.GazelleSpawnEgg = GazelleSpawnEgg;
        GameRegistry.registerItem(Constants.GazelleSpawnEgg, "Gazelle Egg");

        SpawnEggs DragonflySpawnEgg = new SpawnEggs(DragonflyInstance.class);
        DragonflySpawnEgg.setUnlocalizedName("dragonfly_egg");
        Constants.DragonflySpawnEgg = DragonflySpawnEgg;
        GameRegistry.registerItem(Constants.DragonflySpawnEgg, "Dragonfly Egg");

        SpawnEggs DragonSpawnEgg = new SpawnEggs(DragonInstance.class);
        DragonSpawnEgg.setUnlocalizedName("dragon_egg");
        Constants.DragonSpawnEgg = DragonSpawnEgg;
        GameRegistry.registerItem(Constants.DragonSpawnEgg, "Dragon Egg");

        SpawnEggs AlosaurusSpawnEgg = new SpawnEggs(AlosaurusInstance.class);
        AlosaurusSpawnEgg.setUnlocalizedName("alosaurus_egg");
        Constants.AlosaurusSpawnEgg = AlosaurusSpawnEgg;
        GameRegistry.registerItem(Constants.AlosaurusSpawnEgg, "Alosaurus Egg");

        SpawnEggs LizardSPawnEgg = new SpawnEggs(LizardInstance.class);
        LizardSPawnEgg.setUnlocalizedName("lizard_egg");
        Constants.LizardSPawnEgg = LizardSPawnEgg;
        GameRegistry.registerItem(Constants.LizardSPawnEgg, "Lizard Egg");

        SpawnEggs CryolohosaurusSpawnEgg = new SpawnEggs(CryolophosaurusInstance.class);
        CryolohosaurusSpawnEgg.setUnlocalizedName("cryolophosaurus_egg");
        Constants.CryolohosaurusSpawnEgg = CryolohosaurusSpawnEgg;
        GameRegistry.registerItem(Constants.CryolohosaurusSpawnEgg, "Cryolophosaurus Egg");

        SpawnEggs BasiliskSpawnEgg = new SpawnEggs(BasiliscInstance.class);
        BasiliskSpawnEgg.setUnlocalizedName("basilisc_egg");
        Constants.BasiliskSpawnEgg = BasiliskSpawnEgg;
        GameRegistry.registerItem(Constants.BasiliskSpawnEgg, "Basilisk Egg");

        SpawnEggs ChipmunkSpawnEgg = new SpawnEggs(ChipmunkInstance.class);
        ChipmunkSpawnEgg.setUnlocalizedName("chipmunk_egg");
        Constants.ChipmunkSpawnEgg = ChipmunkSpawnEgg;
        GameRegistry.registerItem(Constants.ChipmunkSpawnEgg, "Chipmunk Egg");

        SpawnEggs BrayonyxSPawnEgg = new SpawnEggs(BaryonyxInstance.class);
        BrayonyxSPawnEgg.setUnlocalizedName("baryonyx_egg");
        Constants.BrayonyxSPawnEgg = BrayonyxSPawnEgg;
        GameRegistry.registerItem(Constants.BrayonyxSPawnEgg, "Baryonyx Egg");

        SpawnEggs KrakenSpawnEgg = new SpawnEggs(KrakenInstance.class);
        KrakenSpawnEgg.setUnlocalizedName("kraken_egg");
        Constants.KrakenSpawnEgg = KrakenSpawnEgg;
        GameRegistry.registerItem(Constants.KrakenSpawnEgg, "Uh, no. Don't.");

        SpawnEggs LurkingTerrorSpawnEgg = new SpawnEggs(LurkingTerrorInstance.class);
        LurkingTerrorSpawnEgg.setUnlocalizedName("lurking_terror_egg");
        Constants.LurkingTerrorSpawnEgg = LurkingTerrorSpawnEgg;
        GameRegistry.registerItem(Constants.LurkingTerrorSpawnEgg, "Lurking Terror Egg");

        SpawnEggs CamarasaurusSPawnEgg = new SpawnEggs(CamarasaurusInstance.class);
        CamarasaurusSPawnEgg.setUnlocalizedName("camarasaurus_egg");
        Constants.CamarasaurusSPawnEgg = CamarasaurusSPawnEgg;
        GameRegistry.registerItem(Constants.CamarasaurusSPawnEgg, "Camarasaurus Egg");

        SpawnEggs LargeNightMareSpawnEgg = new SpawnEggs(LargeNightmareInstance.class);
        LargeNightMareSpawnEgg.setUnlocalizedName("large_nightmare_egg");
        Constants.LargeNightMareSpawnEgg = LargeNightMareSpawnEgg;
        GameRegistry.registerItem(Constants.LargeNightMareSpawnEgg, "Large Nightmare!!! Egg");

        SpawnEggs SmallNightMareSpawnEgg = new SpawnEggs(MediumNightmareInstance.class);
        SmallNightMareSpawnEgg.setUnlocalizedName("small_nightmare_egg");
        Constants.SmallNightMareSpawnEgg = SmallNightMareSpawnEgg;
        GameRegistry.registerItem(Constants.SmallNightMareSpawnEgg, "Small Nightmare Egg");

        SpawnEggs VelocityRaptor = new SpawnEggs(VelocityRaptorInstance.class);
        VelocityRaptor.setUnlocalizedName("velocityraptor_egg");
        Constants.VelocityRaptor = VelocityRaptor;
        GameRegistry.registerItem(Constants.VelocityRaptor, "Velocity Raptor Egg");

        SpawnEggs CepahdromeSPawnEgg = new SpawnEggs(CephadromeInstance.class);
        CepahdromeSPawnEgg.setUnlocalizedName("cephadrom_egg");
        Constants.CepahdromeSPawnEgg = CepahdromeSPawnEgg;
        GameRegistry.registerItem(Constants.CepahdromeSPawnEgg, "Cephadrome Egg");

        SpawnEggs WtfSpawnEgg = new SpawnEggs(WTFInstance.class);
        WtfSpawnEgg.setUnlocalizedName("wtf_egg");
        Constants.WtfSpawnEgg = WtfSpawnEgg;
        GameRegistry.registerItem(Constants.WtfSpawnEgg, "WTF? Egg");

        SpawnEggs BirdSpawnEgg = new SpawnEggs(BirdsInstance.class);
        BirdSpawnEgg.setUnlocalizedName("bird_egg");
        Constants.BirdSpawnEgg = BirdSpawnEgg;
        GameRegistry.registerItem(Constants.BirdSpawnEgg, "Bird Egg");

        SpawnEggs WaterDragonSpawnEgg = new SpawnEggs(WaterDragonInstance.class);
        WaterDragonSpawnEgg.setUnlocalizedName("water_dragon_egg");
        Constants.WaterDragonSpawnEgg = WaterDragonSpawnEgg;
        GameRegistry.registerItem(Constants.WaterDragonSpawnEgg, "Water Dragon Egg");

        SpawnEggs BabyDragonSpawnEgg = new SpawnEggs(BabyDragonInstance.class);
        BabyDragonSpawnEgg.setUnlocalizedName("baby_dragon_egg");
        Constants.BabyDragonSpawnEgg = BabyDragonSpawnEgg;
        GameRegistry.registerItem(Constants.BabyDragonSpawnEgg, "Baby Dragon Egg");

        SpawnEggs TriffidSpawnEgg = new SpawnEggs(TriffidInstance.class);
        TriffidSpawnEgg.setUnlocalizedName("triffid_egg");
        Constants.TriffidSpawnEgg = TriffidSpawnEgg;
        GameRegistry.registerItem(Constants.TriffidSpawnEgg, "Triffid Egg");

        SpawnEggs HydroliscSpawnEgg = new SpawnEggs(HydroliscInstance.class);
        HydroliscSpawnEgg.setUnlocalizedName("hydrolisc_egg");
        Constants.HydroliscSpawnEgg = HydroliscSpawnEgg;
        GameRegistry.registerItem(Constants.HydroliscSpawnEgg, "Hydrolisc Egg");

        SpawnEggs JumpyBugSpawnEgg = new SpawnEggs(JumpyBugInstance.class);
        JumpyBugSpawnEgg.setUnlocalizedName("jumpy_bug_egg");
        Constants.JumpyBugSpawnEgg = JumpyBugSpawnEgg;
        GameRegistry.registerItem(Constants.JumpyBugSpawnEgg, "Jumpy Bug Egg");

        SpawnEggs TerribleTerrorSpawnEgg = new SpawnEggs(TerribleTerrorInstance.class);
        TerribleTerrorSpawnEgg.setUnlocalizedName("terrible_terror_egg");
        Constants.TerribleTerrorSpawnEgg = TerribleTerrorSpawnEgg;
        GameRegistry.registerItem(Constants.TerribleTerrorSpawnEgg, "Terrible Terror Egg");

        SpawnEggs KyuubiSpawnEgg = new SpawnEggs(KyuubiInstance.class);
        KyuubiSpawnEgg.setUnlocalizedName("kyuubi_egg");
        Constants.KyuubiSpawnEgg = KyuubiSpawnEgg;
        GameRegistry.registerItem(Constants.KyuubiSpawnEgg, "Kyuubi Egg");

        SpawnEggs SpitbugSpawnEgg = new SpawnEggs(SpitInstance.class);
        SpitbugSpawnEgg.setUnlocalizedName("spitbug_egg");
        Constants.SpitbugSpawnEgg = SpitbugSpawnEgg;
        GameRegistry.registerItem(Constants.SpitbugSpawnEgg, "Spit Bug Egg");

        SpawnEggs CliffRacerSpawnEgg = new SpawnEggs(CliffRacerInstance.class);
        CliffRacerSpawnEgg.setUnlocalizedName("cliff_racer_egg");
        Constants.CliffRacerSpawnEgg = CliffRacerSpawnEgg;
        GameRegistry.registerItem(Constants.CliffRacerSpawnEgg, "Cliff Racer Egg");

        SpawnEggs CreepingHorrorSpawnEgg = new SpawnEggs(CreepingHorrorInstance.class);
        CreepingHorrorSpawnEgg.setUnlocalizedName("creeping_horror_egg");
        Constants.CreepingHorrorSpawnEgg = CreepingHorrorSpawnEgg;
        GameRegistry.registerItem(Constants.CreepingHorrorSpawnEgg, "Creeping Horror Egg");

        SpawnEggs ScorpionSpawnEgg = new SpawnEggs(ScorpionInstance.class);
        ScorpionSpawnEgg.setUnlocalizedName("scorpion_egg");
        Constants.ScorpionSpawnEgg = ScorpionSpawnEgg;
        GameRegistry.registerItem(Constants.ScorpionSpawnEgg, "Scorpion Egg");

        SpawnEggs CaveFisherSpawnEgg = new SpawnEggs(CaveFisherInstance.class);
        CaveFisherSpawnEgg.setUnlocalizedName("cave_fisher_egg");
        Constants.CaveFisherSpawnEgg = CaveFisherSpawnEgg;
        GameRegistry.registerItem(Constants.CaveFisherSpawnEgg, "Cave Fisher Egg");

        SpawnEggs StinkBugSpawnEgg = new SpawnEggs(StinkInstance.class);
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

        SpawnEggs MobzillaSpawnEgg = new SpawnEggs(MobzillaInstance.class);
        MobzillaSpawnEgg.setUnlocalizedName("mobzilla_egg");
        Constants.MobzillaSpawnEgg = MobzillaSpawnEgg;
        GameRegistry.registerItem(Constants.MobzillaSpawnEgg, "Mobzilla Egg");

        SpawnEggs OstrichSpawnEgg = new SpawnEggs(OstrichInstance.class);
        OstrichSpawnEgg.setUnlocalizedName("ostrich_egg");
        Constants.OstrichSpawnEgg = OstrichSpawnEgg;
        GameRegistry.registerItem(Constants.OstrichSpawnEgg, "Ostrich Egg");

        SpawnEggs BeeSpawnEgg = new SpawnEggs(BeeInstance.class);
        BeeSpawnEgg.setUnlocalizedName("bee_egg");
        Constants.BeeSpawnEgg = BeeSpawnEgg;
        GameRegistry.registerItem(Constants.BeeSpawnEgg, "Bee Egg");

        SpawnEggs StinkySpawnEgg = new SpawnEggs(StinkyInstance.class);
        StinkySpawnEgg.setUnlocalizedName("stinky_egg");
        Constants.StinkySpawnEgg = StinkySpawnEgg;
        GameRegistry.registerItem(Constants.StinkySpawnEgg, "Stinky Egg");

        SpawnEggs SeaViperSpawnEgg = new SpawnEggs(SeaViperInstance.class);
        SeaViperSpawnEgg.setUnlocalizedName("sea_viper_egg");
        Constants.SeaViperSpawnEgg = SeaViperSpawnEgg;
        GameRegistry.registerItem(Constants.SeaViperSpawnEgg, "Sea Viper Egg");

        SpawnEggs BrutalflySpawnEgg = new SpawnEggs(BrutalflyInstance.class);
        BrutalflySpawnEgg.setUnlocalizedName("brutalfly_egg");
        Constants.BrutalflySpawnEgg = BrutalflySpawnEgg;
        GameRegistry.registerItem(Constants.BrutalflySpawnEgg, "Brutalfly Egg");

        SpawnEggs JefferySpawnEgg = new SpawnEggs(RoboJefferyInstance.class);
        JefferySpawnEgg.setUnlocalizedName("jeffery_egg");
        Constants.JefferySpawnEgg = JefferySpawnEgg;
        GameRegistry.registerItem(Constants.JefferySpawnEgg, "Jeffery Egg");

        SpawnEggs FrogSpawnEgg = new SpawnEggs(FrogInstance.class);
        FrogSpawnEgg.setUnlocalizedName("frog_egg");
        Constants.FrogSpawnEgg = FrogSpawnEgg;
        GameRegistry.registerItem(Constants.FrogSpawnEgg, "Frog Egg");

        SpawnEggs CriminalSpawnegg = new SpawnEggs(CriminalInstance.class);
        CriminalSpawnegg.setUnlocalizedName("criminal_egg");
        Constants.CriminalSpawnegg = CriminalSpawnegg;
        GameRegistry.registerItem(Constants.CriminalSpawnegg, "Criminal Egg");

        SpawnEggs SeaMonsterSpawnEgg = new SpawnEggs(SeaMonsterInstance.class);
        SeaMonsterSpawnEgg.setUnlocalizedName("sea_monster_egg");
        Constants.SeaMonsterSpawnEgg = SeaMonsterSpawnEgg;
        GameRegistry.registerItem(Constants.SeaMonsterSpawnEgg, "Sea Monster Egg");

        SpawnEggs MantisSpawnEgg = new SpawnEggs(MantisInstance.class);
        MantisSpawnEgg.setUnlocalizedName("mantis_egg");
        Constants.MantisSpawnEgg = MantisSpawnEgg;
        GameRegistry.registerItem(Constants.MantisSpawnEgg, "Mantis Egg");

        SpawnEggs HerculesBeetleSPawnEgg = new SpawnEggs(HerculesInstance.class);
        HerculesBeetleSPawnEgg.setUnlocalizedName("hercules_egg");
        Constants.HerculesBeetleSPawnEgg = HerculesBeetleSPawnEgg;
        GameRegistry.registerItem(Constants.HerculesBeetleSPawnEgg, "Hercules Beetle Egg");

        SpawnEggs MolenoidSpawnEgg = new SpawnEggs(MolenoidInstance.class);
        MolenoidSpawnEgg.setUnlocalizedName("molenoid_egg");
        Constants.MolenoidSpawnEgg = MolenoidSpawnEgg;
        GameRegistry.registerItem(Constants.MolenoidSpawnEgg, "Molenoid Egg");

    }
}
