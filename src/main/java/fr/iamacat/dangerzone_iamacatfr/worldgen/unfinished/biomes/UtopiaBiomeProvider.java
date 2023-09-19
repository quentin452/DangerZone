
package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.biomes;

import java.util.ArrayList;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
import net.minecraft.world.biome.BiomeGenBase;

public class UtopiaBiomeProvider extends BiomeGenBase {

    public UtopiaBiomeProvider() {
        super(par1);
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(Gazelle.class, 10, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 15, 3, 6));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GirlfriendInstance.class, 5, 2, 3));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(BoyfriendInstance.class, 5, 2, 3));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(AppleCowInstance.class, 10, 4, 8));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldenAppleCowInstance.class, 8, 2, 6));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedGoldenAppleCowInstance.class, 5, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ButterflyInstance.class, 20, 3, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(LunaMothInstance.class, 10, 1, 5));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ChipMunkInstance.class, 3, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CockateilInstance.class, 10, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 1, 1, 1));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(WhaleRenderer.WhaleInstance.class, 1, 1, 1));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Flounder.class, 2, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CricketInstance.class, 5, 4, 6));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Frog.class, 5, 4, 6));
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
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ButterflyInstance.class, 5, 2, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CockateilInstance.class, 4, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(LunaMothInstance.class, 5, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 10, 4, 8));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(DragonInstance.class, 1, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Stinky.class, 2, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CliffRacerInstance.class, 20, 3, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CloudSharkInstance.class, 1, 1, 1));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 5, 2, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CreepingHorrorInstance.class, 60, 4, 8));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TerribleTerror.class, 25, 3, 6));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LurkingTerror.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(PitchBlack.class, 15, 3, 6));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LeafMonster.class, 35, 2, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderReaper.class, 25, 2, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(HerculesBeetle.class, 5, 1, 2));
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
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(CrystalCowInstance.class, 1, 1, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(FairyInstance.class, 10, 4, 8));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Peacock.class, 5, 4, 8));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Mantis.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rotator.class, 4, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Vortex.class, 3, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Urchin.class, 15, 2, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(DungeonBeastInstance.class, 30, 4, 6));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rat.class, 40, 4, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ButterflyInstance.class, 10, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CockateilInstance.class, 4, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(LunaMothInstance.class, 4, 1, 2));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(WhaleRenderer.WhaleInstance.class, 1, 1, 2));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(CrabInstance.class, 1, 1, 2));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Flounder.class, 5, 6, 8));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Irukandji.class, 4, 2, 3));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Skate.class, 2, 3, 6));
            this.spawnableWaterCreatureList.add(new BiomeGenBase.SpawnListEntry(Frog.class, 1, 3, 5));
        this.theBiomeDecorator.flowersPerChunk = -999;
        this.theBiomeDecorator.grassPerChunk = -999;
        this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.bigMushroomsPerChunk = -999;
        this.theBiomeDecorator.mushroomsPerChunk = -999;
        this.theBiomeDecorator.reedsPerChunk = -999;
    }

    public void setVillageCreatures() {
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot1.class, 25, 4, 8));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot2.class, 16, 2, 8));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot3.class, 12, 2, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot4.class, 8, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot5.class, 20, 4, 8));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GiantRobot.class, 8, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(SpiderDriver.class, 20, 3, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Godzilla.class, 2, 1, 1));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 10, 3, 6));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GirlfriendInstance.class, 1, 2, 3));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(BoyfriendInstance.class, 1, 2, 3));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(AppleCowInstance.class, 8, 4, 8));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldenAppleCowInstance.class, 6, 2, 6));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedGoldenAppleCowInstance.class, 4, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ButterflyInstance.class, 25, 3, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(LunaMothInstance.class, 20, 1, 5));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ChipMunkInstance.class, 5, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CockateilInstance.class, 15, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(BandPInstance.class, 15, 1, 2));
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
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ButterflyInstance.class, 20, 3, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(LunaMothInstance.class, 10, 1, 5));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CockateilInstance.class, 10, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Firefly.class, 15, 3, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CliffRacerInstance.class, 30, 3, 6));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CloudSharkInstance.class, 2, 1, 1));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldFish.class, 10, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(FairyInstance.class, 5, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(BaryonyxInstance.class, 2, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(BeeInstance.class, 2, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(CassowaryInstance.class, 2, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(DragonflyInstance.class, 2, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Peacock.class, 2, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(StinkBug.class, 3, 2, 4));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(Ostrich.class, 1, 1, 2));
            this.spawnableCaveCreatureList.add(new BiomeGenBase.SpawnListEntry(ChipMunkInstance.class, 1, 1, 2));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(BeaverInstance.class, 1, 1, 2));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(AppleCowInstance.class, 3, 2, 4));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(GoldenAppleCowInstance.class, 2, 2, 4));
            this.spawnableCreatureList.add(new BiomeGenBase.SpawnListEntry(EnchantedGoldenAppleCowInstance.class, 1, 2, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Vortex.class, 1, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(PitchBlack.class, 1, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TerribleTerror.class, 4, 2, 6));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(AlosaurusInstance.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(BasiliskInstance.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot1.class, 5, 2, 8));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot2.class, 2, 1, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot3.class, 2, 1, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot4.class, 1, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Robot5.class, 2, 3, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CaterKillerInstance.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CaveFisherInstance.class, 5, 1, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CreepingHorrorInstance.class, 5, 1, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(CryolophosaurusInstance.class, 5, 1, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Urchin.class, 2, 1, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(DungeonBeastInstance.class, 2, 1, 5));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EmperorScorpion.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderKnight.class, 2, 1, 2));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EnderReaper.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Hammerhead.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(HerculesBeetle.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TrooperBug.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Molenoid.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Mothra.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(BrutalflyInstance.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rat.class, 10, 1, 10));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Rotator.class, 1, 1, 3));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Scorpion.class, 2, 1, 3));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(SpitBug.class, 2, 1, 3));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Nastysaurus.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(TRex.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LeafMonster.class, 2, 1, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Pointysaurus.class, 2, 1, 4));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Leon.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(Mantis.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(LurkingTerror.class, 1, 1, 1));
            this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(GammaMetroid.class, 1, 1, 1));
    }
}
