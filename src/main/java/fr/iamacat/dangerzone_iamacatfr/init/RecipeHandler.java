package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Constants;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipeHandler {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        final ItemStack OreSpiderEggStack = new ItemStack(BlockInitDangerZone.MySpiderSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 52),
            new ItemStack(Items.water_bucket),
            OreSpiderEggStack);
        final ItemStack OreBatEggStack = new ItemStack(BlockInitDangerZone.MyBatSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 65),
            new ItemStack(Items.water_bucket),
            OreBatEggStack);
        final ItemStack OreCowEggStack = new ItemStack(BlockInitDangerZone.MyCowSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 92),
            new ItemStack(Items.water_bucket),
            OreCowEggStack);
        final ItemStack OrePigEggStack = new ItemStack(BlockInitDangerZone.MyPigSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 90),
            new ItemStack(Items.water_bucket),
            OrePigEggStack);
        final ItemStack OreSquidEggStack = new ItemStack(BlockInitDangerZone.MySquidSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 94),
            new ItemStack(Items.water_bucket),
            OreSquidEggStack);
        final ItemStack OreChickenEggStack = new ItemStack(BlockInitDangerZone.MyChickenSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 93),
            new ItemStack(Items.water_bucket),
            OreChickenEggStack);
        final ItemStack OreCreeperEggStack = new ItemStack(BlockInitDangerZone.MyCreeperSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 50),
            new ItemStack(Items.water_bucket),
            OreCreeperEggStack);
        final ItemStack OreSkeletonEggStack = new ItemStack(BlockInitDangerZone.MySkeletonSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 51),
            new ItemStack(Items.water_bucket),
            OreSkeletonEggStack);
        final ItemStack OreZombieEggStack = new ItemStack(BlockInitDangerZone.MyZombieSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 54),
            new ItemStack(Items.water_bucket),
            OreZombieEggStack);
        final ItemStack OreSlimeEggStack = new ItemStack(BlockInitDangerZone.MySlimeSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 55),
            new ItemStack(Items.water_bucket),
            OreSlimeEggStack);
        final ItemStack OreGhastEggStack = new ItemStack(BlockInitDangerZone.MyGhastSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 56),
            new ItemStack(Items.water_bucket),
            OreGhastEggStack);
        final ItemStack OreZombiePigmanEggStack = new ItemStack(BlockInitDangerZone.MyZombiePigmanSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 57),
            new ItemStack(Items.water_bucket),
            OreZombiePigmanEggStack);
        final ItemStack OreEndermanEggStack = new ItemStack(BlockInitDangerZone.MyEndermanSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 58),
            new ItemStack(Items.water_bucket),
            OreEndermanEggStack);
        final ItemStack OreCaveSpiderEggStack = new ItemStack(BlockInitDangerZone.MyCaveSpiderSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 59),
            new ItemStack(Items.water_bucket),
            OreCaveSpiderEggStack);
        final ItemStack OreSilverfishEggStack = new ItemStack(BlockInitDangerZone.MySilverfishSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 60),
            new ItemStack(Items.water_bucket),
            OreSilverfishEggStack);
        final ItemStack OreMagmaCubeEggStack = new ItemStack(BlockInitDangerZone.MyMagmaCubeSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 62),
            new ItemStack(Items.water_bucket),
            OreMagmaCubeEggStack);
        final ItemStack OreWitchEggStack = new ItemStack(BlockInitDangerZone.MyWitchSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 66),
            new ItemStack(Items.water_bucket),
            OreWitchEggStack);
        final ItemStack OreSheepEggStack = new ItemStack(BlockInitDangerZone.MySheepSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 91),
            new ItemStack(Items.water_bucket),
            OreSheepEggStack);
        final ItemStack OreWolfEggStack = new ItemStack(BlockInitDangerZone.MyWolfSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 95),
            new ItemStack(Items.water_bucket),
            OreWolfEggStack);
        final ItemStack OreMooshroomEggStack = new ItemStack(BlockInitDangerZone.MyMooshroomSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 96),
            new ItemStack(Items.water_bucket),
            OreMooshroomEggStack);
        final ItemStack OreOcelotEggStack = new ItemStack(BlockInitDangerZone.MyOcelotSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 98),
            new ItemStack(Items.water_bucket),
            OreOcelotEggStack);
        final ItemStack OreBlazeEggStack = new ItemStack(BlockInitDangerZone.MyBlazeSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 61),
            new ItemStack(Items.water_bucket),
            OreBlazeEggStack);
        final ItemStack OreGirlfriendEggStack = new ItemStack(BlockInitDangerZone.MyGirlfriendSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.Girlfriend),
            new ItemStack(Items.water_bucket),
            OreGirlfriendEggStack);
        final ItemStack OreBoyfriendEggStack = new ItemStack(BlockInitDangerZone.MyBoyfriendSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.Boyfriend),
            new ItemStack(Items.water_bucket),
            OreBoyfriendEggStack);
        final ItemStack OreRedCowEggStack = new ItemStack(BlockInitDangerZone.MyRedCowSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.AppleCowSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreRedCowEggStack);
        final ItemStack OreCrystalCowEggStack = new ItemStack(BlockInitDangerZone.MyCrystalCowSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CrystalCowSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCrystalCowEggStack);
        final ItemStack OreVillagerEggStack = new ItemStack(BlockInitDangerZone.MyVillagerSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 120),
            new ItemStack(Items.water_bucket),
            OreVillagerEggStack);
        final ItemStack OreGoldCowEggStack = new ItemStack(BlockInitDangerZone.MyGoldCowSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.GoldenAppleCowSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreGoldCowEggStack);
        final ItemStack OreEnchantedCowEggStack = new ItemStack(BlockInitDangerZone.MyEnchantedCowSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.EnchantedGoldenAppleCowSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreEnchantedCowEggStack);
        final ItemStack OreMOTHRAEggStack = new ItemStack(BlockInitDangerZone.MyMOTHRASpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.MOTHRASpawnEgg),
            new ItemStack(Items.water_bucket),
            OreMOTHRAEggStack);
        final ItemStack OreAloEggStack = new ItemStack(BlockInitDangerZone.MyAloSpawnBlock);
        GameRegistry
            .addShapelessRecipe(new ItemStack(Constants.AlosaurusSpawnEgg), new ItemStack(Items.water_bucket), OreAloEggStack);
        final ItemStack OreCryoEggStack = new ItemStack(BlockInitDangerZone.MyCryoSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CryolohosaurusSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCryoEggStack);
        final ItemStack OreCamaEggStack = new ItemStack(BlockInitDangerZone.MyCamaSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CamarasaurusSPawnEgg),
            new ItemStack(Items.water_bucket),
            OreCamaEggStack);
        final ItemStack OreVeloEggStack = new ItemStack(BlockInitDangerZone.MyVeloSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.VelocityRaptor),
            new ItemStack(Items.water_bucket),
            OreVeloEggStack);
        final ItemStack OreHydroEggStack = new ItemStack(BlockInitDangerZone.MyHydroSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.HydroliscSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreHydroEggStack);
        final ItemStack OreBasilEggStack = new ItemStack(BlockInitDangerZone.MyBasilSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.BasiliskSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreBasilEggStack);
        final ItemStack OreDragonflyEggStack = new ItemStack(BlockInitDangerZone.MyDragonflySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.DragonflySpawnEgg),
            new ItemStack(Items.water_bucket),
            OreDragonflyEggStack);
        final ItemStack OreEmperorScorpionEggStack = new ItemStack(BlockInitDangerZone.MyEmperorScorpionSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.EmperorScorpionEgg),
            new ItemStack(Items.water_bucket),
            OreEmperorScorpionEggStack);
        final ItemStack OreScorpionEggStack = new ItemStack(BlockInitDangerZone.MyScorpionSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.ScorpionSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreScorpionEggStack);
        final ItemStack OreCaveFisherEggStack = new ItemStack(BlockInitDangerZone.MyCaveFisherSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CaveFisherSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCaveFisherEggStack);
        final ItemStack OreSpyroEggStack = new ItemStack(BlockInitDangerZone.MySpyroSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.BabyDragonSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSpyroEggStack);
        final ItemStack OreBaryonyxEggStack = new ItemStack(BlockInitDangerZone.MyBaryonyxSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.BrayonyxSPawnEgg),
            new ItemStack(Items.water_bucket),
            OreBaryonyxEggStack);
        final ItemStack OreGammaMetroidEggStack = new ItemStack(BlockInitDangerZone.MyGammaMetroidSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.WtfSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreGammaMetroidEggStack);
        final ItemStack OreCockateilEggStack = new ItemStack(BlockInitDangerZone.MyCockateilSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.BirdSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCockateilEggStack);
        final ItemStack OreKyuubiEggStack = new ItemStack(BlockInitDangerZone.MyKyuubiSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.KyuubiSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreKyuubiEggStack);
        final ItemStack OreAlienEggStack = new ItemStack(BlockInitDangerZone.MyAlienSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.AlienSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreAlienEggStack);
        final ItemStack OreAttackSquidEggStack = new ItemStack(BlockInitDangerZone.MyAttackSquidSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.AttackSquidSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreAttackSquidEggStack);
        final ItemStack OreWaterDragonEggStack = new ItemStack(BlockInitDangerZone.MyWaterDragonSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.WaterDragonSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreWaterDragonEggStack);
        final ItemStack OreKrakenEggStack = new ItemStack(BlockInitDangerZone.MyKrakenSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.KrakenSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreKrakenEggStack);
        final ItemStack OreLizardEggStack = new ItemStack(BlockInitDangerZone.MyLizardSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.LizardSPawnEgg),
            new ItemStack(Items.water_bucket),
            OreLizardEggStack);
        final ItemStack OreCephadromeEggStack = new ItemStack(BlockInitDangerZone.MyCephadromeSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CepahdromeSPawnEgg),
            new ItemStack(Items.water_bucket),
            OreCephadromeEggStack);
        final ItemStack OreDragonEggStack = new ItemStack(BlockInitDangerZone.MyDragonSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.DragonSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreDragonEggStack);
        final ItemStack OreBeeEggStack = new ItemStack(BlockInitDangerZone.MyBeeSpawnBlock);
        GameRegistry
            .addShapelessRecipe(new ItemStack(Constants.BeeSpawnEgg), new ItemStack(Items.water_bucket), OreBeeEggStack);
        final ItemStack OreHorseEggStack = new ItemStack(BlockInitDangerZone.MyHorseSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.spawn_egg, 1, 100),
            new ItemStack(Items.water_bucket),
            OreHorseEggStack);
        final ItemStack OreTrooperBugEggStack = new ItemStack(BlockInitDangerZone.MyTrooperBugSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TrooperBugSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreTrooperBugEggStack);
        final ItemStack OreSpitBugEggStack = new ItemStack(BlockInitDangerZone.MySpitBugSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.SpitbugSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSpitBugEggStack);
        final ItemStack OreStinkBugEggStack = new ItemStack(BlockInitDangerZone.MyStinkBugSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.StinkBugSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreStinkBugEggStack);
        final ItemStack OreOstrichEggStack = new ItemStack(BlockInitDangerZone.MyOstrichSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.OstrichSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreOstrichEggStack);
        final ItemStack OreGazelleEggStack = new ItemStack(BlockInitDangerZone.MyGazelleSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.GazelleSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreGazelleEggStack);
        final ItemStack OreChipmunkEggStack = new ItemStack(BlockInitDangerZone.MyChipmunkSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.ChipmunkSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreChipmunkEggStack);
        final ItemStack OreCreepingHorrorEggStack = new ItemStack(BlockInitDangerZone.MyCreepingHorrorSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CreepingHorrorSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCreepingHorrorEggStack);
        final ItemStack OreTerribleTerrorEggStack = new ItemStack(BlockInitDangerZone.MyTerribleTerrorSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TerribleTerrorSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreTerribleTerrorEggStack);
        final ItemStack OreCliffRacerEggStack = new ItemStack(BlockInitDangerZone.MyCliffRacerSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CliffRacerSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCliffRacerEggStack);
        final ItemStack OreTriffidEggStack = new ItemStack(BlockInitDangerZone.MyTriffidSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TriffidSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreTriffidEggStack);
        final ItemStack OrePitchBlackEggStack = new ItemStack(BlockInitDangerZone.MyPitchBlackSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.NightMareSpawnEgg),
            new ItemStack(Items.water_bucket),
            OrePitchBlackEggStack);
        final ItemStack OreLurkingTerrorEggStack = new ItemStack(BlockInitDangerZone.MyLurkingTerrorSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.LurkingTerrorSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreLurkingTerrorEggStack);
        final ItemStack OreEnderKnightEggStack = new ItemStack(BlockInitDangerZone.MyEnderKnightSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.EnderKnightSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreEnderKnightEggStack);
        final ItemStack OreEnderReaperEggStack = new ItemStack(BlockInitDangerZone.MyEnderReaperSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.EnderReaperSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreEnderReaperEggStack);
        final ItemStack OreGodzillaPartEggStack = new ItemStack(BlockInitDangerZone.MyGodzillaPartSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(BlockInitDangerZone.MyGodzillaSpawnBlock),
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack,
            OreGodzillaPartEggStack);
        final ItemStack OreGodzillaEggStack = new ItemStack(BlockInitDangerZone.MyGodzillaSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.MobzillaSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreGodzillaEggStack);
        final ItemStack OreTheKingPartEggStack = new ItemStack(BlockInitDangerZone.MyTheKingPartSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TheKingSpawnerSpawnEgg),
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack,
            OreTheKingPartEggStack);
        final ItemStack OreTheKingEggStack = new ItemStack(BlockInitDangerZone.MyTheKingSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TheKingSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreTheKingEggStack);
        final ItemStack OreTheQueenPartEggStack = new ItemStack(BlockInitDangerZone.MyTheQueenPartSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(BlockInitDangerZone.MyTheQueenSpawnBlock),
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack,
            OreTheQueenPartEggStack);
        final ItemStack OreTheQueenEggStack = new ItemStack(BlockInitDangerZone.MyTheQueenSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TheQueenSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreTheQueenEggStack);
        final ItemStack OreSmallWormEggStack = new ItemStack(BlockInitDangerZone.MySmallWormSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.SmallWormSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSmallWormEggStack);
        final ItemStack OreMediumWormEggStack = new ItemStack(BlockInitDangerZone.MyMediumWormSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.MediumWormSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreMediumWormEggStack);
        final ItemStack OreLargeWormEggStack = new ItemStack(BlockInitDangerZone.MyLargeWormSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.LargeWormSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreLargeWormEggStack);
        final ItemStack OreCassowaryEggStack = new ItemStack(BlockInitDangerZone.MyCassowarySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CassowarySpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCassowaryEggStack);
        final ItemStack OreCloudSharkEggStack = new ItemStack(BlockInitDangerZone.MyCloudSharkSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CloudSharkSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCloudSharkEggStack);
        final ItemStack OreGoldFishEggStack = new ItemStack(BlockInitDangerZone.MyGoldFishSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.GoldFishSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreGoldFishEggStack);

        final ItemStack OreLeafMonsterEggStack = new ItemStack(BlockInitDangerZone.MyLeafMonsterSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.LeafMonsterSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreLeafMonsterEggStack);

        final ItemStack OreBeaverEggStack = new ItemStack(BlockInitDangerZone.MyBeaverSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.BeaverSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreBeaverEggStack);

        final ItemStack OreUrchinEggStack = new ItemStack(BlockInitDangerZone.MyUrchinSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.crystalUrchinSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreUrchinEggStack);

        final ItemStack OreFlounderEggStack = new ItemStack(BlockInitDangerZone.MyFlounderSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.FlounderSPawnEgg),
            new ItemStack(Items.water_bucket),
            OreFlounderEggStack);

        final ItemStack OreSkateEggStack = new ItemStack(BlockInitDangerZone.MySkateSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.SkateSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSkateEggStack);

        final ItemStack OreRotatorEggStack = new ItemStack(BlockInitDangerZone.MyRotatorSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.RotatorSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreRotatorEggStack);

        final ItemStack OrePeacockEggStack = new ItemStack(BlockInitDangerZone.MyPeacockSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.PeacockSpawnEgg),
            new ItemStack(Items.water_bucket),
            OrePeacockEggStack);

        final ItemStack OreFairyEggStack = new ItemStack(BlockInitDangerZone.MyFairySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.FairySpawnEgg),
            new ItemStack(Items.water_bucket),
            OreFairyEggStack);

        final ItemStack OreDungeonBeastEggStack = new ItemStack(BlockInitDangerZone.MyDungeonBeastSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.DungeonBeastSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreDungeonBeastEggStack);

        final ItemStack OreVortexEggStack = new ItemStack(BlockInitDangerZone.MyVortexSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.VortexSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreVortexEggStack);

        final ItemStack OreRatEggStack = new ItemStack(BlockInitDangerZone.MyRatSpawnBlock);
        GameRegistry
            .addShapelessRecipe(new ItemStack(Constants.RatSpawnEgg), new ItemStack(Items.water_bucket), OreRatEggStack);

        final ItemStack OreWhaleEggStack = new ItemStack(BlockInitDangerZone.MyWhaleSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.WhaleSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreWhaleEggStack);

        final ItemStack OreIrukandjiEggStack = new ItemStack(BlockInitDangerZone.MyIrukandjiSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.IrukandjiSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreIrukandjiEggStack);

        final ItemStack OreTRexEggStack = new ItemStack(BlockInitDangerZone.MyTRexSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.TrexSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreTRexEggStack);

        final ItemStack OreHerculesEggStack = new ItemStack(BlockInitDangerZone.MyHerculesSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.HerculesBeetleSPawnEgg),
            new ItemStack(Items.water_bucket),
            OreHerculesEggStack);

        final ItemStack OreMantisEggStack = new ItemStack(BlockInitDangerZone.MyMantisSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.MantisSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreMantisEggStack);

        final ItemStack OreStinkyEggStack = new ItemStack(BlockInitDangerZone.MyStinkySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.StinkySpawnEgg),
            new ItemStack(Items.water_bucket),
            OreStinkyEggStack);

        final ItemStack OreEasterBunnyEggStack = new ItemStack(BlockInitDangerZone.MyEasterBunnySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.EasterbunnySpawnEgg),
            new ItemStack(Items.water_bucket),
            OreEasterBunnyEggStack);

        final ItemStack OreCriminalEggStack = new ItemStack(BlockInitDangerZone.MyCriminalSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CriminalSpawnegg),
            new ItemStack(Items.water_bucket),
            OreCriminalEggStack);

        final ItemStack OreBrutalflyEggStack = new ItemStack(BlockInitDangerZone.MyBrutalflySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.BrutalflySpawnEgg),
            new ItemStack(Items.water_bucket),
            OreBrutalflyEggStack);

        final ItemStack OreNastysaurusEggStack = new ItemStack(BlockInitDangerZone.MyNastysaurusSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.NastysaurusSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreNastysaurusEggStack);

        final ItemStack OrePointysaurusEggStack = new ItemStack(BlockInitDangerZone.MyPointysaurusSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.PointysaurusSpawnEgg),
            new ItemStack(Items.water_bucket),
            OrePointysaurusEggStack);

        final ItemStack OreCricketEggStack = new ItemStack(BlockInitDangerZone.MyCricketSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CricketSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCricketEggStack);

        final ItemStack OreFrogEggStack = new ItemStack(BlockInitDangerZone.MyFrogSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.FrogSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreFrogEggStack);

        final ItemStack OreSpiderDriverEggStack = new ItemStack(BlockInitDangerZone.MySpiderDriverSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.SpiderDriverSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSpiderDriverEggStack);

        final ItemStack OreCrabEggStack = new ItemStack(BlockInitDangerZone.MyCrabSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CrabSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCrabEggStack);

        final ItemStack OreCaterKillerEggStack = new ItemStack(BlockInitDangerZone.MyCaterKillerSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.CaterKillerSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreCaterKillerEggStack);

        final ItemStack OreMolenoidEggStack = new ItemStack(BlockInitDangerZone.MyMolenoidSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.MolenoidSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreMolenoidEggStack);

        final ItemStack OreSeaMonsterEggStack = new ItemStack(BlockInitDangerZone.MySeaMonsterSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.SeaMonsterSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSeaMonsterEggStack);

        final ItemStack OreSeaViperEggStack = new ItemStack(BlockInitDangerZone.MySeaViperSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.SeaViperSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreSeaViperEggStack);

        final ItemStack OreRubberDuckyEggStack = new ItemStack(BlockInitDangerZone.MyRubberDuckySpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.RubberDuckySpawnegg),
            new ItemStack(Items.water_bucket),
            OreRubberDuckyEggStack);

        final ItemStack OreHammerheadEggStack = new ItemStack(BlockInitDangerZone.MyHammerheadSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.HammerheadSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreHammerheadEggStack);

        final ItemStack OreLeonEggStack = new ItemStack(BlockInitDangerZone.MyLeonSpawnBlock);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Constants.LeonopteryxSpawnEgg),
            new ItemStack(Items.water_bucket),
            OreLeonEggStack);

        GameRegistry
            .addShapelessRecipe(new ItemStack(BlockInitDangerZone.CrystalWood, 4), BlockInitDangerZone.BlockCrystalTreeLog);
        GameRegistry.addShapelessRecipe(
            new ItemStack(BlockInitDangerZone.CrystalWorkbench),
            BlockInitDangerZone.CrystalWood,
            BlockInitDangerZone.CrystalWood,
            BlockInitDangerZone.CrystalWood,
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.ContainerCrystalFurnaceBlock),
            "FFF",
            "F F",
            "FFF",
            'F',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(new ItemStack(Blocks.chest), "FFF", "F F", "FFF", 'F', BlockInitDangerZone.CrystalWood);
        GameRegistry
            .addRecipe(new ItemStack(Items.wooden_door), "FF ", "FF ", "FF ", 'F', BlockInitDangerZone.CrystalWood);
        GameRegistry
            .addRecipe(new ItemStack(Items.wooden_door), " FF", " FF", " FF", 'F', BlockInitDangerZone.CrystalWood);
        GameRegistry.addSmelting(BlockInitDangerZone.SaltOre, new ItemStack(ItemInitDangerZone.Salt, 8), 0.1f);
        GameRegistry.addSmelting(ItemInitDangerZone.RawCornDog, new ItemStack(ItemInitDangerZone.PopCorn), 0.1f);
        GameRegistry.addSmelting(ItemInitDangerZone.RawCornDog, new ItemStack(ItemInitDangerZone.RawCornDog), 0.4f);
        GameRegistry.addSmelting(ItemInitDangerZone.RawBacon, new ItemStack(ItemInitDangerZone.RawBacon), 0.2f);
        GameRegistry.addSmelting(BlockInitDangerZone.OreCrystalCrystal, new ItemStack(ItemInitDangerZone.UraniumIngot), 0.3f);
        GameRegistry.addSmelting(BlockInitDangerZone.TigersEyeBlock, new ItemStack(ItemInitDangerZone.TigersEyeIngot), 0.3f);
        GameRegistry.addSmelting(ItemInitDangerZone.RawPeacock, new ItemStack(ItemInitDangerZone.RawPeacock), 0.4f);
        GameRegistry.addSmelting(ItemInitDangerZone.CrabMeat, new ItemStack(ItemInitDangerZone.CrabMeat), 0.2f);
        GameRegistry.addSmelting(ItemInitDangerZone.GreenFish, new ItemStack(Items.cooked_fished), 0.2f);
        GameRegistry.addSmelting(ItemInitDangerZone.BlueFish, new ItemStack(Items.cooked_fished), 0.2f);
        GameRegistry.addSmelting(ItemInitDangerZone.PinkFish, new ItemStack(Items.cooked_fished), 0.2f);
        GameRegistry.addSmelting(ItemInitDangerZone.RockFish, new ItemStack(Items.cooked_fished), 0.2f);
        GameRegistry.addSmelting(ItemInitDangerZone.WoodFish, new ItemStack(Items.cooked_fished), 0.2f);
        GameRegistry.addSmelting(ItemInitDangerZone.GreyFish, new ItemStack(Items.cooked_fished), 0.2f);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.MyUltimateSword),
            " T ",
            " U ",
            " I ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.MyUltimateSword),
            "T  ",
            "U  ",
            "I  ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.MyUltimateSword),
            "  T",
            "  U",
            "  I",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimatePickaxe),
            "TUT",
            " U ",
            " I ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateShovel),
            " U ",
            " T ",
            " I ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateShovel),
            "U  ",
            "T  ",
            "I  ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateShovel),
            "  U",
            "  T",
            "  I",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateHoe    ),
            "TU ",
            " I ",
            " I ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateAxe),
            "TU ",
            "TI ",
            " I ",
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateBow),
            " TS",
            "I S",
            " US",
            'S',
            Items.string,
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.SkateBow),
            " TS",
            "T S",
            " TS",
            'S',
            Items.string,
            'T',
            ItemInitDangerZone.ItemCrystalSticks);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UltimateFishingRod),
            "  T",
            " US",
            "I S",
            'S',
            Items.string,
            'I',
            Items.iron_ingot,
            'U',
            ItemInitDangerZone.UraniumIngot,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.NightmareSword),
            "ODO",
            "RTR",
            "OIO",
            'I',
            Items.iron_ingot,
            'O',
            ItemInitDangerZone.NightmareScale,
            'D',
            Items.diamond,
            'R',
            Items.redstone,
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldSword),
            " E ",
            " E ",
            " I ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldSword),
            "  E",
            "  E",
            "  I",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldSword),
            " E ",
            " E ",
            " I ",
            'I',
            Items.stick,
            'E',
            Blocks.red_flower);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            Blocks.red_flower);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldSword),
            "  E",
            "  E",
            "  I",
            'I',
            Items.stick,
            'E',
            Blocks.red_flower);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldPickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldShovel),
            " E ",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldShovel),
            "  E",
            "  I",
            "  I",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            Items.stick,
            'E',
            Items.emerald);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.ExperienceSword),
            "EEE",
            "EIE",
            "EEE",
            'I',
            ItemInitDangerZone.EmeraldSword,
            'E',
            Items.experience_bottle);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.PoisonSword),
            "EEE",
            "EIE",
            "EEE",
            'I',
            ItemInitDangerZone.EmeraldSword,
            'E',
            ItemInitDangerZone.DeadStinkBug);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RatSword),
            " E ",
            " E ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalRat);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RatSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalRat);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RatSword),
            "  E",
            "  E",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalRat);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.FairySword),
            " E ",
            " E ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalFairy);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.FairySword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalFairy);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.FairySword),
            "  E",
            "  E",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalFairy);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            " E ",
            " E ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            "  E",
            "  E",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalPickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            " E ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            "  E",
            "  I",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(new ItemStack(Blocks.chest), "EEE", "E E", "EEE", 'E', BlockInitDangerZone.CrystalWood);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            " E ",
            " E ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            "  E",
            "  E",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalPickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            " E ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            "  E",
            "  I",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(new ItemStack(Items.bucket), "   ", "I I", " I ", 'I', ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeSword),
            " E ",
            " E ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeSword);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeSword),
            "  E",
            "  E",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyePickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeShovel),
            " E ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeShovel),
            "  E",
            "  I",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            " E ",
            " E ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalSword),
            "  E",
            "  E",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalPickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            " E ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalShovel),
            "  E",
            "  I",
            "  I",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.CrystalAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            ItemInitDangerZone.ItemCrystalSticks,
            'E',
            BlockInitDangerZone.CrystalStone);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubySword),
            " E ",
            " E ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubySword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubySword),
            "  E",
            "  E",
            "  I",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubyPickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubyShovel),
            " E ",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubyShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubyShovel),
            "  E",
            "  I",
            "  I",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubyHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RubyAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystSword),
            " E ",
            " E ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystSword),
            "E  ",
            "E  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystSword),
            "  E",
            "  E",
            "  I",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystPickaxe),
            "EEE",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystShovel),
            " E ",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystShovel),
            "E  ",
            "I  ",
            "I  ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystShovel),
            "  E",
            "  I",
            "  I",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystHoe),
            "EE ",
            " I ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.AmethystAxe),
            "EE ",
            "EI ",
            " I ",
            'I',
            Items.stick,
            'E',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.MyHammy),
            ItemInitDangerZone.MyUltimateSword,
            ItemInitDangerZone.MyUltimateSword,
            ItemInitDangerZone.BigHammer,
            ItemInitDangerZone.GreenGoo);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.BattleAxe),
            ItemInitDangerZone.MyUltimateSword,
            ItemInitDangerZone.UltimateAxe,
            ItemInitDangerZone.GreenGoo);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.MyChainsaw),
            "EEE",
            "EIE",
            "EEE",
            'I',
            ItemInitDangerZone.UltimateAxe,
            'E',
            Blocks.redstone_block);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.MyQueenBattleAxe),
            "EIE",
            "EIE",
            " I ",
            'I',
            Items.iron_ingot,
            'E',
            ItemInitDangerZone.QueenScale);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.MyBertha),
            ItemInitDangerZone.BigBerthaHandle,
            ItemInitDangerZone.BigBerthaGuard,
            ItemInitDangerZone.BigBerthaBlade);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.BigBerthaHandle),
            ItemInitDangerZone.ItemRayGun,
            ItemInitDangerZone.BigHammer,
            ItemInitDangerZone.MantisClaw,
            ItemInitDangerZone.WaterDragonScale,
            ItemInitDangerZone.GreenGoo);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.BigBerthaGuard),
            ItemInitDangerZone.MolenoidNose,
            ItemInitDangerZone.SeaMonsterScale,
            ItemInitDangerZone.MothScale,
            ItemInitDangerZone.BasilicsScale,
            ItemInitDangerZone.NightmareScale,
            ItemInitDangerZone.EmperorScorpionScale,
            ItemInitDangerZone.JumpyBugScale);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.BigBerthaBlade),
            ItemInitDangerZone.KrakenTooth,
            ItemInitDangerZone.WormTooth,
            ItemInitDangerZone.TrexTooth,
            ItemInitDangerZone.MyUltimateSword,
            ItemInitDangerZone.CaterKillerJaw,
            ItemInitDangerZone.SeaViperTongue,
            ItemInitDangerZone.VortexEye);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInitDangerZone.MySlice), ItemInitDangerZone.MyBertha, Items.iron_ingot);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ItemIrukandjiArrow),
            ItemInitDangerZone.PeacockFeather,
            ItemInitDangerZone.ItemIrukandji,
            ItemInitDangerZone.ItemCrystalSticks);
        GameRegistry.addShapelessRecipe(
            new ItemStack(Items.bed),
            ItemInitDangerZone.PeacockFeather,
            BlockInitDangerZone.CrystalWood,
            ItemInitDangerZone.PeacockFeather,
            BlockInitDangerZone.CrystalWood,
            ItemInitDangerZone.PeacockFeather,
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.SquidZooka),
            Items.iron_ingot,
            Items.iron_ingot,
            Items.iron_ingot,
            Items.dye,
            Items.dye,
            Items.dye,
            Items.iron_ingot,
            Items.iron_ingot,
            Items.iron_ingot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.UraniumIngot),
            "UUU",
            "UUU",
            "UUU",
            'U',
            ItemInitDangerZone.UraniumNugget);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.UraniumNugget, 9),
            new ItemStack(ItemInitDangerZone.UraniumIngot));
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TitaniumIngot),
            "UUU",
            "UUU",
            "UUU",
            'U',
            ItemInitDangerZone.TitaniumNugget);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.TitaniumNugget, 9),
            new ItemStack(ItemInitDangerZone.TitaniumIngot));
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.UraniumBlock),
            "UUU",
            "UUU",
            "UUU",
            'U',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.UraniumIngot, 9),
            new ItemStack(BlockInitDangerZone.UraniumBlock));
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.TitaniumBlock),
            "TTT",
            "TTT",
            "TTT",
            'T',
            ItemInitDangerZone.TitaniumIngot);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.TitaniumIngot, 9),
            new ItemStack(BlockInitDangerZone.TitaniumBlock));
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.MobzillaScaleBlock),
            "TTT",
            "TTT",
            "TTT",
            'T',
            ItemInitDangerZone.MobzillaScale);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.MobzillaScale, 9),
            new ItemStack(BlockInitDangerZone.MobzillaScaleBlock));
        GameRegistry
            .addRecipe(new ItemStack(BlockInitDangerZone.RubyBlock), "TTT", "TTT", "TTT", 'T', ItemInitDangerZone.RubyIngot);
        GameRegistry
            .addShapelessRecipe(new ItemStack(ItemInitDangerZone.RubyIngot, 9), new ItemStack(BlockInitDangerZone.RubyBlock));
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.AmethystBlock),
            "TTT",
            "TTT",
            "TTT",
            'T',
            ItemInitDangerZone.AmethystIngot);
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.PinkTourmalineBlock),
            "TTT",
            "TTT",
            "TTT",
            'T',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.TigersEyeBlock),
            "TTT",
            "TTT",
            "TTT",
            'T',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.AmethystIngot, 9),
            new ItemStack(BlockInitDangerZone.CrystalStone));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.UraniumIngot, 9),
            new ItemStack(BlockInitDangerZone.CrystalStone));
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeIngot, 9),
            new ItemStack(BlockInitDangerZone.TigersEyeBlock));
        GameRegistry
            .addRecipe(new ItemStack(BlockInitDangerZone.EyeOfEnderBlock), "TTT", "TTT", "TTT", 'T', Items.ender_pearl);
        GameRegistry
            .addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new ItemStack(BlockInitDangerZone.EyeOfEnderBlock));
        GameRegistry
            .addRecipe(new ItemStack(BlockInitDangerZone.EyeOfEnderBlock), "TTT", "TTT", "TTT", 'T', Items.ender_eye);
        GameRegistry
            .addShapelessRecipe(new ItemStack(Items.ender_eye, 9), new ItemStack(BlockInitDangerZone.EyeOfEnderBlock));
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.ThunderStaff),
            "DR ",
            "RR ",
            "  R",
            'D',
            Items.diamond,
            'R',
            ItemInitDangerZone.RubyIngot);
        GameRegistry.addRecipe(new ItemStack(ItemInitDangerZone.Wrench), "D D", " D ", " D ", 'D', Items.iron_ingot);
        final ItemStack MilkBucket = new ItemStack(Items.milk_bucket);
        final ItemStack SomePaper = new ItemStack(Items.paper);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInitDangerZone.Butter, 4), MilkBucket, MilkBucket);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.Cheese, 2),
            MilkBucket,
            MilkBucket,
            MilkBucket,
            MilkBucket);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ButteredPopcorn),
            ItemInitDangerZone.PopCorn,
            ItemInitDangerZone.Butter);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ButteredandSaltedPopcorn),
            ItemInitDangerZone.ButteredPopcorn,
            ItemInitDangerZone.Salt);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ButteredandSaltedPopcorn),
            ItemInitDangerZone.PopCorn,
            ItemInitDangerZone.Salt,
            ItemInitDangerZone.Butter);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.PopCornBag),
            ItemInitDangerZone.ButteredandSaltedPopcorn,
            ItemInitDangerZone.ButteredandSaltedPopcorn,
            ItemInitDangerZone.ButteredandSaltedPopcorn,
            ItemInitDangerZone.ButteredandSaltedPopcorn,
            ItemInitDangerZone.ButteredandSaltedPopcorn,
            ItemInitDangerZone.ButteredandSaltedPopcorn,
            SomePaper,
            SomePaper,
            SomePaper);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.RawCornDog, 4),
            ItemInitDangerZone.ItemCornCob,
            Items.chicken,
            Items.porkchop,
            Items.stick);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInitDangerZone.RawBacon, 2), ItemInitDangerZone.Salt, Items.porkchop);
        GameRegistry
            .addShapelessRecipe(new ItemStack(ItemInitDangerZone.ButterCandy, 4), ItemInitDangerZone.Butter, Items.sugar);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.Salt, 1),
            ItemInitDangerZone.Lettuce,
            ItemInitDangerZone.Tomato,
            ItemInitDangerZone.Radish,
            Items.carrot,
            Items.bowl);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.BltSandwitch, 1),
            ItemInitDangerZone.CookedBacon,
            ItemInitDangerZone.Lettuce,
            ItemInitDangerZone.Tomato,
            ItemInitDangerZone.Butter,
            Items.bread);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.Pizza, 1),
            ItemInitDangerZone.Tomato,
            ItemInitDangerZone.Cheese,
            ItemInitDangerZone.CookedBacon,
            Items.bread);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.DuctTape),
            "   ",
            "AAA",
            "RRR",
            'R',
            Items.string,
            'A',
            Items.slime_ball);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.CrabbyPatty, 1),
            ItemInitDangerZone.CrabMeat,
            ItemInitDangerZone.Lettuce,
            ItemInitDangerZone.Tomato,
            Items.bread);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ExtraSmallZooCage),
            Blocks.iron_block,
            Blocks.glass,
            Blocks.quartz_block);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.SmallZooCage),
            ItemInitDangerZone.ExtraSmallZooCage,
            Blocks.iron_block,
            Blocks.glass,
            Blocks.quartz_block);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.MediumZooCage),
            ItemInitDangerZone.SmallZooCage,
            Blocks.iron_block,
            Blocks.glass,
            Blocks.quartz_block);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.LargeZooCage),
            ItemInitDangerZone.MediumZooCage,
            Blocks.iron_block,
            Blocks.glass,
            Blocks.quartz_block);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ExtraLargeZooCage),
            ItemInitDangerZone.LargeZooCage,
            Blocks.iron_block,
            Blocks.glass,
            Blocks.quartz_block);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.InstantShelter),
            Blocks.redstone_block,
            Items.stick,
            Blocks.cobblestone);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.InstantGarden),
            Blocks.redstone_block,
            Items.wheat,
            Items.gunpowder);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.CreeperLauncher, 4),
            Items.paper,
            Items.redstone,
            Items.stick);
        GameRegistry
            .addShapelessRecipe(new ItemStack(ItemInitDangerZone.NetherTracker, 1), Items.nether_star, Blocks.netherrack);
        GameRegistry
            .addRecipe(new ItemStack(ItemInitDangerZone.Sifter), "RRR", "RAR", "RRR", 'R', Items.stick, 'A', Items.string);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.OmgMagicApple),
            "RRR",
            "RAR",
            "RRR",
            'R',
            Blocks.redstone_block,
            'A',
            Items.apple);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.RandomDungeon),
            "RRR",
            "RAR",
            "RRR",
            'R',
            Blocks.redstone_block,
            'A',
            Items.coal);
      /*  if (ItemInitDangerZone.MinersDreamExpensive == 0) {
            GameRegistry.addRecipe(
                new ItemStack(ItemInitDangerZone.MinersDream),
                "CCC",
                "RRR",
                "GGG",
                'R',
                Blocks.redstone_block,
                'C',
                Blocks.cactus,
                'G',
                Items.gunpowder);
        } else {

       */
            GameRegistry.addRecipe(
                new ItemStack(ItemInitDangerZone.MinersDream),
                "CCC",
                "RRR",
                "GGG",
                'R',
                Blocks.redstone_block,
                'C',
                Blocks.cactus,
                'G',
                Blocks.tnt);
       // }
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.StairsUp, 8),
            "GC ",
            " C ",
            " C ",
            'C',
            Blocks.cobblestone,
            'G',
            Items.gunpowder);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.StairsDown, 8),
            " C ",
            " C ",
            "GC ",
            'C',
            Blocks.cobblestone,
            'G',
            Items.gunpowder);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.StairsAcross, 8),
            " C ",
            "GC ",
            " C ",
            'C',
            Blocks.cobblestone,
            'G',
            Items.gunpowder);
        GameRegistry
            .addShapelessRecipe(new ItemStack(BlockInitDangerZone.blocktorch, 4), Items.redstone, Items.stick, Items.coal);
        GameRegistry.addShapelessRecipe(new ItemStack(BlockInitDangerZone.blocktorch, 1), Items.redstone, Blocks.torch);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ItemCrystalSticks, 6),
            BlockInitDangerZone.CrystalWood,
            BlockInitDangerZone.CrystalWood);
        GameRegistry.addShapelessRecipe(
            new ItemStack(BlockInitDangerZone.CrystalTorch, 6),
            BlockInitDangerZone.CrystalCoal,
            ItemInitDangerZone.ItemCrystalSticks);
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.KrakenRepellent, 1),
            "D D",
            "STS",
            "D D",
            'D',
            ItemInitDangerZone.DeadStinkBug,
            'T',
            BlockInitDangerZone.blocktorch,
            'S',
            Items.string);
        GameRegistry.addRecipe(
            new ItemStack(BlockInitDangerZone.CreeperRepellent, 1),
            "D D",
            "STS",
            "D D",
            'D',
            ItemInitDangerZone.GreenGoo,
            'T',
            BlockInitDangerZone.blocktorch,
            'S',
            Items.string);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInitDangerZone.ItemAppleSeed, 6), Items.apple);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInitDangerZone.MyCherrySeed, 1), ItemInitDangerZone.Cherries);
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInitDangerZone.MyPeachSeed, 1), ItemInitDangerZone.Peach);
        GameRegistry.addShapelessRecipe(
            new ItemStack(ItemInitDangerZone.ExperienceCatcher, 1),
            Items.glass_bottle,
            Items.stick,
            Items.string);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.ItemExperienceTreeSeed, 1),
            "EEE",
            "EAE",
            "EEE",
            'A',
            ItemInitDangerZone.ItemAppleSeed,
            'E',
            Items.experience_bottle);

        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.PeacockHelmet),
            "   ",
            "***",
            "* *",
            '*',
            ItemInitDangerZone.PeacockFeather);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.PeacockHelmet),
            "***",
            "* *",
            "   ",
            '*',
            ItemInitDangerZone.PeacockFeather);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.PeacockChestplate),
            "* *",
            "***",
            "***",
            '*',
            ItemInitDangerZone.PeacockFeather);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.PeacockLeggings),
            "***",
            "* *",
            "* *",
            '*',
            ItemInitDangerZone.PeacockFeather);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.PeacockBoots),
            "   ",
            "* *",
            "* *",
            '*',
            ItemInitDangerZone.PeacockFeather);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeHelmet),
            "   ",
            "***",
            "* *",
            '*',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeHelmet),
            "***",
            "* *",
            "   ",
            '*',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeChestplate),
            "* *",
            "***",
            "***",
            '*',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeLeggings),
            "***",
            "* *",
            "* *",
            '*',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.TigersEyeBoots),
            "   ",
            "* *",
            "* *",
            '*',
            ItemInitDangerZone.TigersEyeIngot);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.ExperienceHelmet),
            "EEE",
            "EAE",
            "EEE",
            'A',
            ItemInitDangerZone.EmeraldHelmet,
            'E',
            Items.experience_bottle);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.EmeraldChestplate),
            "EEE",
            "EAE",
            "EEE",
            'A',
            ItemInitDangerZone.EmeraldChestplate,
            'E',
            Items.experience_bottle);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.ExperienceLeggings),
            "EEE",
            "EAE",
            "EEE",
            'A',
            ItemInitDangerZone.EmeraldLeggings,
            'E',
            Items.experience_bottle);
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.ExperienceBoots),
            "EEE",
            "EAE",
            "EEE",
            'A',
            ItemInitDangerZone.EmeraldBoots,
            'E',
            Items.experience_bottle);
        GameRegistry.addRecipe(new ItemStack(Blocks.web), "***", "* *", "***", '*', Items.string);

        final int cageid = EntityRegistry.findGlobalUniqueEntityId();

         GameRegistry.addRecipe(
            new ItemStack(DangerZone.CageEmpty, 2),
            "IWI",
            "W W",
            "IWI",
            'W',
            Items.stick,
            'I',
            Items.iron_ingot);
        GameRegistry.addRecipe(
            new ItemStack(DangerZone.CageEmpty, 2),
            "IWI",
            "W W",
            "IWI",
            'W',
            ItemInitDangerZone.ItemCrystalSticks,
            'I',
            ItemInitDangerZone.UraniumIngot);
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new ItemStack(BlockInitDangerZone.BlockSkyTreeLog));
        GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new ItemStack(ItemInitDangerZone.DuctTape));
        GameRegistry.addRecipe(
            new ItemStack(ItemInitDangerZone.Hoverboard),
            "   ",
            "WWW",
            "DRD",
            'W',
            Blocks.planks,
            'R',
            Items.redstone,
            'D',
            Items.diamond);
    }
}
