
package fr.iamacat.dangerzone_iamacatfr.worldgen.biomes;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalCow;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.ArrayList;

public class BiomeGenUtopianPlains extends BiomeGenBase {

    public BiomeGenUtopianPlains(final int par1) {
        super(par1);
        if (OreSpawnMain.GazelleEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Gazelle.class, 10, 2, 4));
        }
        if (OreSpawnMain.FireflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 15, 3, 6));
        }
        if (OreSpawnMain.GirlfriendEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Girlfriend.class, 5, 2, 3));
        }
        if (OreSpawnMain.BoyfriendEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Boyfriend.class, 5, 2, 3));
        }
        if (OreSpawnMain.CowEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(RedCow.class, 10, 4, 8));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldCow.class, 8, 2, 6));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedCow.class, 5, 2, 4));
        }
        if (OreSpawnMain.ButterflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 20, 3, 6));
        }
        if (OreSpawnMain.MothEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 10, 1, 5));
        }
        if (OreSpawnMain.ChipmunkEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Chipmunk.class, 3, 1, 2));
        }
        if (OreSpawnMain.CockateilEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 10, 2, 4));
        }
        if (OreSpawnMain.GoldFishEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 1, 1, 1));
        }
        if (OreSpawnMain.WhaleEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Whale.class, 1, 1, 1));
        }
        if (OreSpawnMain.FlounderEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Flounder.class, 2, 2, 4));
        }
        if (OreSpawnMain.CoinEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Coin.class, 2, 1, 1));
        }
        if (OreSpawnMain.CricketEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cricket.class, 5, 4, 6));
        }
        if (OreSpawnMain.FrogEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Frog.class, 5, 4, 6));
        }
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.flowersPerChunk = 4;
        this.theBiomeDecorator.grassPerChunk = 6;
    }

    public void setIslandCreatures() {
        this.spawnableCreatureList = null;
        this.spawnableMonsterList = null;
        this.spawnableWaterCreatureList = null;
        this.spawnableCaveCreatureList = null;
        this.spawnableCreatureList = new ArrayList();
        this.spawnableMonsterList = new ArrayList();
        this.spawnableWaterCreatureList = new ArrayList();
        this.spawnableCaveCreatureList = new ArrayList();
        if (OreSpawnMain.ButterflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 5, 2, 6));
        }
        if (OreSpawnMain.CockateilEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 4, 1, 2));
        }
        if (OreSpawnMain.MothEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 5, 2, 4));
        }
        if (OreSpawnMain.FireflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 10, 4, 8));
        }
        if (OreSpawnMain.DragonEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Dragon.class, 1, 1, 2));
        }
        if (OreSpawnMain.StinkyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Stinky.class, 2, 1, 2));
        }
        if (OreSpawnMain.CliffRacerEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CliffRacer.class, 20, 3, 6));
        }
        if (OreSpawnMain.CloudSharkEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CloudShark.class, 1, 1, 1));
        }
        if (OreSpawnMain.GoldFishEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 5, 2, 4));
        }
        if (OreSpawnMain.CreepingHorrorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CreepingHorror.class, 60, 4, 8));
        }
        if (OreSpawnMain.TerribleTerrorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TerribleTerror.class, 25, 3, 6));
        }
        if (OreSpawnMain.LurkingTerrorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LurkingTerror.class, 1, 1, 1));
        }
        if (OreSpawnMain.PitchBlackEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(PitchBlack.class, 15, 3, 6));
        }
        if (OreSpawnMain.LeafMonsterEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LeafMonster.class, 35, 2, 4));
        }
        if (OreSpawnMain.EnderReaperEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderReaper.class, 25, 2, 4));
        }
        if (OreSpawnMain.HerculesBeetleEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(HerculesBeetle.class, 5, 1, 2));
        }
    }

    public void setCrystalCreatures() {
        this.spawnableCreatureList = null;
        this.spawnableMonsterList = null;
        this.spawnableWaterCreatureList = null;
        this.spawnableCaveCreatureList = null;
        this.spawnableCreatureList = new ArrayList();
        this.spawnableMonsterList = new ArrayList();
        this.spawnableWaterCreatureList = new ArrayList();
        this.spawnableCaveCreatureList = new ArrayList();
        if (OreSpawnMain.CowEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(CrystalCow.class, 1, 1, 4));
        }
        if (OreSpawnMain.FairyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Fairy.class, 10, 4, 8));
        }
        if (OreSpawnMain.PeacockEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Peacock.class, 5, 4, 8));
        }
        if (OreSpawnMain.MantisEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Mantis.class, 1, 1, 1));
        }
        if (OreSpawnMain.RotatorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rotator.class, 4, 1, 2));
        }
        if (OreSpawnMain.VortexEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Vortex.class, 3, 1, 2));
        }
        if (OreSpawnMain.UrchinEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Urchin.class, 15, 2, 4));
        }
        if (OreSpawnMain.DungeonBeastEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(DungeonBeast.class, 30, 4, 6));
        }
        if (OreSpawnMain.RatEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rat.class, 40, 4, 6));
        }
        if (OreSpawnMain.ButterflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 10, 2, 4));
        }
        if (OreSpawnMain.CockateilEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 4, 1, 2));
        }
        if (OreSpawnMain.MothEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 4, 1, 2));
        }
        if (OreSpawnMain.WhaleEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Whale.class, 1, 1, 2));
        }
        if (OreSpawnMain.CrabEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Crab.class, 1, 1, 2));
        }
        if (OreSpawnMain.FlounderEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Flounder.class, 5, 6, 8));
        }
        if (OreSpawnMain.IrukandjiEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Irukandji.class, 4, 2, 3));
        }
        if (OreSpawnMain.SkateEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Skate.class, 2, 3, 6));
        }
        if (OreSpawnMain.FrogEnable != 0) {
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Frog.class, 1, 3, 5));
        }
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.bigMushroomsPerChunk = -999;
        this.theBiomeDecorator.mushroomsPerChunk = -999;
        this.theBiomeDecorator.reedsPerChunk = -999;
    }

    public void setVillageCreatures() {
        if (OreSpawnMain.Robot1Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot1.class, 25, 4, 8));
        }
        if (OreSpawnMain.Robot2Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot2.class, 16, 2, 8));
        }
        if (OreSpawnMain.Robot3Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot3.class, 12, 2, 4));
        }
        if (OreSpawnMain.Robot4Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot4.class, 8, 1, 2));
        }
        if (OreSpawnMain.Robot5Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot5.class, 20, 4, 8));
        }
        if (OreSpawnMain.JefferyEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GiantRobot.class, 8, 1, 2));
        }
        if (OreSpawnMain.SpiderDriverEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(SpiderDriver.class, 20, 3, 5));
        }
        if (OreSpawnMain.GodzillaEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Godzilla.class, 2, 1, 1));
        }
        if (OreSpawnMain.FireflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 10, 3, 6));
        }
        if (OreSpawnMain.GirlfriendEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Girlfriend.class, 1, 2, 3));
        }
        if (OreSpawnMain.BoyfriendEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Boyfriend.class, 1, 2, 3));
        }
        if (OreSpawnMain.CowEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(RedCow.class, 8, 4, 8));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldCow.class, 6, 2, 6));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedCow.class, 4, 2, 4));
        }
        if (OreSpawnMain.ButterflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 25, 3, 6));
        }
        if (OreSpawnMain.MothEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 20, 1, 5));
        }
        if (OreSpawnMain.ChipmunkEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Chipmunk.class, 5, 1, 2));
        }
        if (OreSpawnMain.CockateilEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 15, 2, 4));
        }
        if (OreSpawnMain.TshirtEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Tshirt.class, 2, 1, 1));
        }
        if (OreSpawnMain.CoinEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Coin.class, 2, 1, 1));
        }
        if (OreSpawnMain.CriminalEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(BandP.class, 15, 1, 2));
        }
    }

    public void setChaosCreatures() {
        this.spawnableCreatureList = null;
        this.spawnableMonsterList = null;
        this.spawnableWaterCreatureList = null;
        this.spawnableCaveCreatureList = null;
        this.spawnableCreatureList = new ArrayList();
        this.spawnableMonsterList = new ArrayList();
        this.spawnableWaterCreatureList = new ArrayList();
        this.spawnableCaveCreatureList = new ArrayList();
        this.theBiomeDecorator.flowersPerChunk = 2;
        this.theBiomeDecorator.grassPerChunk = 4;
        this.theBiomeDecorator.treesPerChunk = 1;
        this.theBiomeDecorator.bigMushroomsPerChunk = -999;
        this.theBiomeDecorator.mushroomsPerChunk = -999;
        this.theBiomeDecorator.reedsPerChunk = -999;
        if (OreSpawnMain.ButterflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityButterfly.class, 20, 3, 6));
        }
        if (OreSpawnMain.MothEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(EntityLunaMoth.class, 10, 1, 5));
        }
        if (OreSpawnMain.CockateilEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cockateil.class, 10, 2, 4));
        }
        if (OreSpawnMain.FireflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 15, 3, 6));
        }
        if (OreSpawnMain.CliffRacerEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CliffRacer.class, 30, 3, 6));
        }
        if (OreSpawnMain.CloudSharkEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CloudShark.class, 2, 1, 1));
        }
        if (OreSpawnMain.GoldFishEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 10, 2, 4));
        }
        if (OreSpawnMain.FairyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Fairy.class, 5, 2, 4));
        }
        if (OreSpawnMain.BaryonyxEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Baryonyx.class, 2, 2, 4));
        }
        if (OreSpawnMain.BeeEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Bee.class, 2, 2, 4));
        }
        if (OreSpawnMain.CassowaryEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Cassowary.class, 2, 2, 4));
        }
        if (OreSpawnMain.DragonflyEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Dragonfly.class, 2, 2, 4));
        }
        if (OreSpawnMain.PeacockEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Peacock.class, 2, 2, 4));
        }
        if (OreSpawnMain.StinkBugEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(StinkBug.class, 3, 2, 4));
        }
        if (OreSpawnMain.OstrichEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Ostrich.class, 1, 1, 2));
        }
        if (OreSpawnMain.ChipmunkEnable != 0) {
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Chipmunk.class, 1, 1, 2));
        }
        if (OreSpawnMain.BeaverEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Beaver.class, 1, 1, 2));
        }
        if (OreSpawnMain.CowEnable != 0) {
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(RedCow.class, 3, 2, 4));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldCow.class, 2, 2, 4));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedCow.class, 1, 2, 4));
        }
        if (OreSpawnMain.VortexEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Vortex.class, 1, 1, 2));
        }
        if (OreSpawnMain.PitchBlackEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(PitchBlack.class, 1, 1, 2));
        }
        if (OreSpawnMain.TerribleTerrorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TerribleTerror.class, 4, 2, 6));
        }
        if (OreSpawnMain.AlosaurusEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Alosaurus.class, 1, 1, 1));
        }
        if (OreSpawnMain.BasiliskEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Basilisk.class, 1, 1, 1));
        }
        if (OreSpawnMain.Robot1Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot1.class, 5, 2, 8));
        }
        if (OreSpawnMain.Robot2Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot2.class, 2, 1, 4));
        }
        if (OreSpawnMain.Robot3Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot3.class, 2, 1, 4));
        }
        if (OreSpawnMain.Robot4Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot4.class, 1, 1, 2));
        }
        if (OreSpawnMain.Robot5Enable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot5.class, 2, 3, 5));
        }
        if (OreSpawnMain.CaterKillerEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CaterKiller.class, 1, 1, 1));
        }
        if (OreSpawnMain.CaveFisherEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CaveFisher.class, 5, 1, 5));
        }
        if (OreSpawnMain.CreepingHorrorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CreepingHorror.class, 5, 1, 5));
        }
        if (OreSpawnMain.CryolophosaurusEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Cryolophosaurus.class, 5, 1, 5));
        }
        if (OreSpawnMain.UrchinEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Urchin.class, 2, 1, 5));
        }
        if (OreSpawnMain.DungeonBeastEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(DungeonBeast.class, 2, 1, 5));
        }
        if (OreSpawnMain.EmperorScorpionEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EmperorScorpion.class, 1, 1, 1));
        }
        if (OreSpawnMain.EnderKnightEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderKnight.class, 2, 1, 2));
        }
        if (OreSpawnMain.EnderReaperEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderReaper.class, 1, 1, 1));
        }
        if (OreSpawnMain.HammerheadEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Hammerhead.class, 1, 1, 1));
        }
        if (OreSpawnMain.HerculesBeetleEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(HerculesBeetle.class, 1, 1, 1));
        }
        if (OreSpawnMain.TrooperBugEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TrooperBug.class, 1, 1, 1));
        }
        if (OreSpawnMain.MolenoidEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Molenoid.class, 1, 1, 1));
        }
        if (OreSpawnMain.MothraEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Mothra.class, 1, 1, 1));
        }
        if (OreSpawnMain.BrutalflyEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Brutalfly.class, 1, 1, 1));
        }
        if (OreSpawnMain.RatEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rat.class, 10, 1, 10));
        }
        if (OreSpawnMain.RotatorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rotator.class, 1, 1, 3));
        }
        if (OreSpawnMain.ScorpionEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Scorpion.class, 2, 1, 3));
        }
        if (OreSpawnMain.SpitBugEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(SpitBug.class, 2, 1, 3));
        }
        if (OreSpawnMain.NastysaurusEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Nastysaurus.class, 1, 1, 1));
        }
        if (OreSpawnMain.TRexEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TRex.class, 1, 1, 1));
        }
        if (OreSpawnMain.LeafMonsterEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LeafMonster.class, 2, 1, 4));
        }
        if (OreSpawnMain.PointysaurusEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Pointysaurus.class, 2, 1, 4));
        }
        if (OreSpawnMain.LeonEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Leon.class, 1, 1, 1));
        }
        if (OreSpawnMain.MantisEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Mantis.class, 1, 1, 1));
        }
        if (OreSpawnMain.LurkingTerrorEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LurkingTerror.class, 1, 1, 1));
        }
        if (OreSpawnMain.GammaMetroidEnable != 0) {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GammaMetroid.class, 1, 1, 1));
        }
    }
}
