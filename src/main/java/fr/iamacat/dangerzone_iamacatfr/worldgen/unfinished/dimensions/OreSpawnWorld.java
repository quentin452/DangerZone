
package fr.iamacat.dangerzone_iamacatfr.worldgen.unfinished.dimensions;

import cpw.mods.fml.common.IWorldGenerator;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import java.util.Random;

public class OreSpawnWorld implements IWorldGenerator {

    public static int recently_placed;

    public void generate(final Random random, final int chunkX, final int chunkZ, final World world,
        final IChunkProvider chunkGenerator, final IChunkProvider chunkProvider) {
        if (world.isRemote) {
            return;
        }
        final Chunk chunk = world.getChunkFromChunkCoords(chunkX, chunkZ);
        if (OreSpawnWorld.recently_placed > 0) {
            --OreSpawnWorld.recently_placed;
        }
        if (world.provider.dimensionId == DimensionInitDangerZone.UtopiaDimensionId) {
            this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
            if (!this.addHugeTree(world, random, chunkX * 16, chunkZ * 16, chunk)) {
                if (!this.addAppleTrees(world, random, chunkX * 16, chunkZ * 16, chunk)
                    && !this.addOtherTrees(world, random, chunkX * 16, chunkZ * 16)
                    && OreSpawnWorld.recently_placed == 0) {
                    this.addKingAltar(world, random, chunkX * 16, chunkZ * 16);
                }
                this.addVeggies(world, random, chunkX * 16, chunkZ * 16);
            }
            boolean rbd = false;
            rbd = this.addRubyDungeon(world, random, chunkX * 16, chunkZ * 16);
            if (!rbd) {
                this.addGenericDungeon(world, random, chunkX * 16, chunkZ * 16);
            }
            return;
        }
        if (world.provider.dimensionId == DimensionInitDangerZone.MiningDimensionId) {
            this.generateRuby(world, random, chunkX * 16, chunkZ * 16);
                this.generateRuby(world, random, chunkX * 16, chunkZ * 16);
                this.generateRuby(world, random, chunkX * 16, chunkZ * 16);
                for (int i = 0; i < 45; ++i) {
                    final int randPosX = chunkX * 16 + random.nextInt(16);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = chunkZ * 16 + random.nextInt(16);
                    if (randPosY < 50) {
                        new WorldGenMinable(Blocks.lapis_ore, 7).generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
                for (int i = 0; i < 25; ++i) {
                    final int randPosX = chunkX * 16 + random.nextInt(16);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = chunkZ * 16 + random.nextInt(16);
                    if (randPosY < 50) {
                        new WorldGenMinable(Blocks.lapis_ore, 4).generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            if (OreSpawnWorld.recently_placed == 0 && random.nextInt(95) == 1) {
                final int i = random.nextInt(7);
                if (i == 0) {
                    this.addBasiliskMaze(world, random, chunkX * 16, chunkZ * 16);
                }
                if (i == 1) {
                    this.addKyuubiDungeon(world, random, chunkX * 16, chunkZ * 16);
                }
                if (i == 2) {
                    this.addBeeHive(world, random, chunkX * 16, chunkZ * 16);
                }
                if (i == 3) {
                    this.addShadowDungeon(world, random, chunkX * 16, chunkZ * 16);
                }
                if (i == 4) {
                    this.addAlienWTF(world, random, chunkX * 16, chunkZ * 16);
                }
                if (i == 5) {
                    this.addEnderKnight(world, random, chunkX * 16, chunkZ * 16);
                }
                if (i == 6) {
                    this.addLeonNest(world, random, chunkX * 16, chunkZ * 16);
                }
            } else {
                this.addGenericDungeon(world, random, chunkX * 16, chunkZ * 16);
            }
            this.addLavaAndWater(world, random, chunkX * 16, chunkZ * 16);
            this.addAnts(world, random, chunkX * 16, chunkZ * 16, 2);
            this.addAnts(world, random, chunkX * 16, chunkZ * 16, 2);
            this.addMosquitos(world, random, chunkX * 16, chunkZ * 16);
            this.addMosquitos(world, random, chunkX * 16, chunkZ * 16);
            this.addVeggies(world, random, chunkX * 16, chunkZ * 16);
            this.addRocks(world, random, chunkX * 16, chunkZ * 16);
            return;
        }
        if (world.provider.dimensionId == DimensionInitDangerZone.VillageDimensionId) {
                this.addMosquitos(world, random, chunkX, chunkZ);
            this.addAnts(world, random, chunkX * 16, chunkZ * 16, 4);
            this.addAppleTrees(world, random, chunkX * 16, chunkZ * 16, chunk);
            this.addGenericDungeon(world, random, chunkX * 16, chunkZ * 16);
            if (OreSpawnWorld.recently_placed == 0) {
                this.addDamselInDistress(world, random, chunkX * 16, chunkZ * 16);
            }
            if (OreSpawnWorld.recently_placed == 0) {
                this.addSpiderHangout(world, random, chunkX * 16, chunkZ * 16);
            }
            if (OreSpawnWorld.recently_placed == 0) {
                this.addRedAntHangout(world, random, chunkX * 16, chunkZ * 16);
            }
            return;
        }
        if (world.provider.dimensionId == DimensionInitDangerZone.DangerDimensionId) {
            if (OreSpawnWorld.recently_placed == 0 && random.nextInt(100) == 0
                && this.D4BigSpaceCheck(world, chunkX * 16, 7, chunkZ * 16)) {
                final int i = random.nextInt(19);
                if (i < 3) {
                    this.addD4Castle(world, random, chunkX * 16, chunkZ * 16);
                } else if (i < 7) {
                    this.addD4GenericDungeon(world, random, chunkX * 16, chunkZ * 16);
                } else {
                    if (i == 7) {
                        this.addD4EnderCastle(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 8) {
                        this.addD4IncaPyramid(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 9) {
                        this.addD4RobotLab(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 10) {
                        this.addD4Mini(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 11) {
                        this.addD4RubyDungeon(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 12) {
                        this.addD4CephadromeAltar(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 13) {
                        this.addD4Greenhouse(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 14) {
                        this.addD4NightmareRookery(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 15) {
                        this.addD4StinkyHouse(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 16) {
                        this.addD4WhiteHouse(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 17) {
                        this.addPumpkin(world, random, chunkX * 16, chunkZ * 16);
                    }
                    if (i == 18) {
                        this.addD4Rainbow(world, random, chunkX * 16, chunkZ * 16);
                    }
                }
            }
            final int i = random.nextInt(300);
            if (i == 0) {
                this.addD4CloudShark(world, random, chunkX * 16, chunkZ * 16);
            }
            this.addUnstableAnts(world, random, chunkX * 16, chunkZ * 16);
            this.addIslands(world, random, chunkX * 16, chunkZ * 16);
            this.addD4Rocks(world, random, chunkX * 16, chunkZ * 16);
            return;
        }
        if (world.provider.dimensionId == DimensionInitDangerZone.CrystalDimensionId) {
            if (!this.addFairyTree(world, random, chunkX * 16, chunkZ * 16)) {
                this.addCrystalTermites(world, random, chunkX * 16, chunkZ * 16);
                if (OreSpawnWorld.recently_placed == 0) {
                    if (!this.addRotatorStation(world, random, chunkX * 16, chunkZ * 16)
                        && !this.addUrchinSpawner(world, random, chunkX * 16, chunkZ * 16)
                        && !this.addCrystalHauntedHouse(world, random, chunkX * 16, chunkZ * 16)
                        && !this.addRoundRotator(world, random, chunkX * 16, chunkZ * 16)) {
                        this.addCrystalBattleTower(world, random, chunkX * 16, chunkZ * 16);
                    }
                    this.addIrukandji(world, random, chunkX * 16, chunkZ * 16);
                }
            }
            this.addCrystalChestsAndSpawners(world, random, chunkX * 16, chunkZ * 16);
            if (world.rand.nextInt(4) == 1) {
                this.addRocks(world, random, chunkX * 16, chunkZ * 16);
            }
            return;
        }
        if (world.provider.dimensionId == DimensionInitDangerZone.ChaosDimensionId) {
            this.addButterfliesAndMoths(world, random, chunkX * 16, chunkZ * 16);
            this.addVeggies(world, random, chunkX * 16, chunkZ * 16);
            this.addAnts(world, random, chunkX * 16, chunkZ * 16, 2);
            return;
        }
        switch (world.provider.dimensionId) {
            case -1: {
                this.generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 0: {
                this.generateSurface(world, random, chunkX * 16, chunkZ * 16);
                this.generateOres(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
            case 1: {
                this.generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
            }
        }
    }

    private void generateEnd(final World world, final Random random, final int chunkX, final int chunkZ) {
        this.addEndAnts(world, random, chunkX, chunkZ);
        final int i = world.rand.nextInt(4);
        if (i == 0) {
            this.addEndKnights(world, random, chunkX, chunkZ);
        }
        if (i == 1) {
            this.addEndReapers(world, random, chunkX, chunkZ);
        }
        if (i == 2) {
            this.addHospital(world, random, chunkX, chunkZ);
        }
        if (i == 3) {
            this.addEnderCastle(world, random, chunkX, chunkZ);
        }
    }

    private void generateNether(final World world, final Random random, final int chunkX, final int chunkZ) {
            this.addNetherMosquitos(world, random, chunkX, chunkZ);
        this.addNetherAnts(world, random, chunkX, chunkZ);
        int patchy = 15 + random.nextInt(10);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(13);
            final int randPosY = random.nextInt(108) + 10;
            final int randPosZ = 3 + chunkZ + random.nextInt(13);
            new WorldGenMinable(BlockInitDangerZone.Lavafoam, 6, Blocks.netherrack)
                .generate(world, random, randPosX, randPosY, randPosZ);
        }
        patchy = 5 + random.nextInt(5);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(13);
            final int randPosY = random.nextInt(108) + 10;
            final int randPosZ = 3 + chunkZ + random.nextInt(13);
            new WorldGenMinable(BlockInitDangerZone.RubyBlockOre, 2, Blocks.netherrack)
                .generate(world, random, randPosX, randPosY, randPosZ);
        }
    }

    public void generateSurface(final World world, final Random random, final int chunkX, final int chunkZ) {
        boolean ahh = false;
        this.addStrawberries(world, random, chunkX, chunkZ);
        this.addCorn(world, random, chunkX, chunkZ);
        this.addTomatoes(world, random, chunkX, chunkZ);
        this.addVeggies(world, random, chunkX, chunkZ);
        this.addButterfliesAndMoths(world, random, chunkX, chunkZ);
        this.addMosquitos(world, random, chunkX, chunkZ);
        if (world.provider.dimensionId == 0
            && OreSpawnWorld.recently_placed == 0) {
            final int i = world.rand.nextInt(6);
            if (i == 0) {
                this.addPlayPool(world, random, chunkX, chunkZ);
            }
            if (i == 1) {
                this.addWaterDragonLair(world, random, chunkX, chunkZ);
            }
            if (i == 2) {
                this.addGoldFishBowl(world, random, chunkX, chunkZ);
            }
            if (i == 3) {
                this.addGirlfriendIsland(world, random, chunkX, chunkZ);
            }
            if (i == 4) {
                this.addMonsterIsland(world, random, chunkX, chunkZ);
            }
            if (i == 5) {
                this.addFrogPond(world, random, chunkX, chunkZ);
            }
            ahh = this.addANest(world, random, chunkX, chunkZ);
            if (!ahh) {
                ahh = this.addHauntedHouse(world, random, chunkX, chunkZ);
            }
            if (!ahh) {
                ahh = this.addLeafMonster(world, random, chunkX, chunkZ);
            }
            if (!ahh) {
                ahh = this.addSpitBug(world, random, chunkX, chunkZ);
            }
            if (!ahh) {
                ahh = this.addIgloo(world, random, chunkX, chunkZ);
            }
            if (!ahh) {
                ahh = this.addBouncyCastle(world, random, chunkX, chunkZ);
            }
            if (!ahh) {
                ahh = this.addRubberDuckyPond(world, random, chunkX, chunkZ);
            }
        }
        this.addAnts(world, random, chunkX, chunkZ, 4);
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("River") || b.biomeName.equals("Extreme Hills") || b.biomeName.equals("Desert")) {
            this.addRocks(world, random, chunkX, chunkZ);
        }
    }

    public void generateRuby(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.Ruby_stats.rate <= 0) {
            return;
        }
        for (int patchy = DangerZone.Ruby_stats.rate + random.nextInt(7), i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= DangerZone.Ruby_stats.maxdepth && randPosY >= DangerZone.Ruby_stats.mindepth) {
                for (int m = randPosY; m > 5; --m) {
                    Block bid = world.getBlock(randPosX, m, randPosZ);
                    if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
                        bid = world.getBlock(randPosX, m - 1, randPosZ);
                        if (bid == Blocks.stone) {
                            DangerZone.setBlockFast(world, randPosX, m - 1, randPosZ, BlockInitDangerZone.RubyBlockOre, 0, 2);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void generateOres(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.SpawnOres_stats.rate > 0) {
            int patchy = DangerZone.SpawnOres_stats.rate + random.nextInt(20);
            if (random.nextInt(20) == 0) {
                patchy += 30;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= DangerZone.SpawnOres_stats.maxdepth
                    && randPosY >= DangerZone.SpawnOres_stats.mindepth) {
                    if (random.nextInt(104) < 7) {
                        final int j = random.nextInt(7);
                        Block b = Blocks.air;
                        switch (j) {
                            case 0: {
                                b = (Block) BlockInitDangerZone.MyBrutalflySpawnBlock;
                                break;
                            }
                            case 1: {
                                b = (Block) BlockInitDangerZone.MyNastysaurusSpawnBlock;
                                break;
                            }
                            case 2: {
                                b = (Block) BlockInitDangerZone.MyPointysaurusSpawnBlock;
                                break;
                            }
                            case 3: {
                                b = (Block) BlockInitDangerZone.MyCricketSpawnBlock;
                                break;
                            }
                            case 4: {
                                b = (Block) BlockInitDangerZone.MyFrogSpawnBlock;
                                break;
                            }
                            case 5: {
                                b = (Block) BlockInitDangerZone.MySpiderDriverSpawnBlock;
                                break;
                            }
                            case 6: {
                                b = (Block) BlockInitDangerZone.MyCrabSpawnBlock;
                                break;
                            }
                        }
                        new WorldGenMinable(b, DangerZone.SpawnOres_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    } else {
                        final int j = random.nextInt(98);
                        Block b = Blocks.air;
                        switch (j) {
                            case 0: {
                                b = (Block) BlockInitDangerZone.MySpiderSpawnBlock;
                                break;
                            }
                            case 1: {
                                b = (Block) BlockInitDangerZone.MyBatSpawnBlock;
                                break;
                            }
                            case 2: {
                                b = (Block) BlockInitDangerZone.MyCowSpawnBlock;
                                break;
                            }
                            case 3: {
                                b = (Block) BlockInitDangerZone.MyPigSpawnBlock;
                                break;
                            }
                            case 4: {
                                b = (Block) BlockInitDangerZone.MySquidSpawnBlock;
                                break;
                            }
                            case 5: {
                                b = (Block) BlockInitDangerZone.MyChickenSpawnBlock;
                                break;
                            }
                            case 6: {
                                b = (Block) BlockInitDangerZone.MyCreeperSpawnBlock;
                                break;
                            }
                            case 7: {
                                b = (Block) BlockInitDangerZone.MySkeletonSpawnBlock;
                                break;
                            }
                            case 8: {
                                b = (Block) BlockInitDangerZone.MyZombieSpawnBlock;
                                break;
                            }
                            case 9: {
                                b = (Block) BlockInitDangerZone.MySlimeSpawnBlock;
                                break;
                            }
                            case 10: {
                                b = (Block) BlockInitDangerZone.MyGhastSpawnBlock;
                                break;
                            }
                            case 11: {
                                b = (Block) BlockInitDangerZone.MyZombiePigmanSpawnBlock;
                                break;
                            }
                            case 12: {
                                b = (Block) BlockInitDangerZone.MyEndermanSpawnBlock;
                                break;
                            }
                            case 13: {
                                b = (Block) BlockInitDangerZone.MyCaveSpiderSpawnBlock;
                                break;
                            }
                            case 14: {
                                b = (Block) BlockInitDangerZone.MySilverfishSpawnBlock;
                                break;
                            }
                            case 15: {
                                b = (Block) BlockInitDangerZone.MyMagmaCubeSpawnBlock;
                                break;
                            }
                            case 16: {
                                b = (Block) BlockInitDangerZone.MyWitchSpawnBlock;
                                break;
                            }
                            case 17: {
                                b = (Block) BlockInitDangerZone.MySheepSpawnBlock;
                                break;
                            }
                            case 18: {
                                b = (Block) BlockInitDangerZone.MyWolfSpawnBlock;
                                break;
                            }
                            case 19: {
                                b = (Block) BlockInitDangerZone.MyMooshroomSpawnBlock;
                                break;
                            }
                            case 20: {
                                b = (Block) BlockInitDangerZone.MyOcelotSpawnBlock;
                                break;
                            }
                            case 21: {
                                b = (Block) BlockInitDangerZone.MyBlazeSpawnBlock;
                                break;
                            }
                            case 22: {
                                b = (Block) BlockInitDangerZone.MyWitherSkeletonSpawnBlock;
                                break;
                            }
                            case 23: {
                                b = (Block) BlockInitDangerZone.MyEnderDragonSpawnBlock;
                                break;
                            }
                            case 24: {
                                b = (Block) BlockInitDangerZone.MySnowGolemSpawnBlock;
                                break;
                            }
                            case 25: {
                                b = (Block) BlockInitDangerZone.MyIronGolemSpawnBlock;
                                break;
                            }
                            case 26: {
                                b = (Block) BlockInitDangerZone.MyWitherBossSpawnBlock;
                                break;
                            }
                            case 27: {
                                b = (Block) BlockInitDangerZone.MyGirlfriendSpawnBlock;
                                break;
                            }
                            case 28: {
                                b = (Block) BlockInitDangerZone.MyRedCowSpawnBlock;
                                break;
                            }
                            case 29: {
                                b = (Block) BlockInitDangerZone.MyGoldCowSpawnBlock;
                                break;
                            }
                            case 30: {
                                b = (Block) BlockInitDangerZone.MyEnchantedCowSpawnBlock;
                                break;
                            }
                            case 31: {
                                b = (Block) BlockInitDangerZone.MyMOTHRASpawnBlock;
                                break;
                            }
                            case 32: {
                                b = (Block) BlockInitDangerZone.MyAloSpawnBlock;
                                break;
                            }
                            case 33: {
                                b = (Block) BlockInitDangerZone.MyCryoSpawnBlock;
                                break;
                            }
                            case 34: {
                                b = (Block) BlockInitDangerZone.MyCamaSpawnBlock;
                                break;
                            }
                            case 35: {
                                b = (Block) BlockInitDangerZone.MyVeloSpawnBlock;
                                break;
                            }
                            case 36: {
                                b = (Block) BlockInitDangerZone.MyHydroSpawnBlock;
                                break;
                            }
                            case 37: {
                                b = (Block) BlockInitDangerZone.MyBasilSpawnBlock;
                                break;
                            }
                            case 38: {
                                b = (Block) BlockInitDangerZone.MyDragonflySpawnBlock;
                                break;
                            }
                            case 39: {
                                b = (Block) BlockInitDangerZone.MyEmperorScorpionSpawnBlock;
                                break;
                            }
                            case 40: {
                                b = (Block) BlockInitDangerZone.MyScorpionSpawnBlock;
                                break;
                            }
                            case 41: {
                                b = (Block) BlockInitDangerZone.MyCaveFisherSpawnBlock;
                                break;
                            }
                            case 42: {
                                b = (Block) BlockInitDangerZone.MySpyroSpawnBlock;
                                break;
                            }
                            case 43: {
                                b = (Block) BlockInitDangerZone.MyBaryonyxSpawnBlock;
                                break;
                            }
                            case 44: {
                                b = (Block) BlockInitDangerZone.MyGammaMetroidSpawnBlock;
                                break;
                            }
                            case 45: {
                                b = (Block) BlockInitDangerZone.MyCockateilSpawnBlock;
                                break;
                            }
                            case 46: {
                                b = (Block) BlockInitDangerZone.MyKyuubiSpawnBlock;
                                break;
                            }
                            case 47: {
                                b = (Block) BlockInitDangerZone.MyAlienSpawnBlock;
                                break;
                            }
                            case 48: {
                                b = (Block) BlockInitDangerZone.MyAttackSquidSpawnBlock;
                                break;
                            }
                            case 49: {
                                b = (Block) BlockInitDangerZone.MyWaterDragonSpawnBlock;
                                break;
                            }
                            case 50: {
                                b = (Block) BlockInitDangerZone.MyKrakenSpawnBlock;
                                break;
                            }
                            case 51: {
                                b = (Block) BlockInitDangerZone.MyLizardSpawnBlock;
                                break;
                            }
                            case 52: {
                                b = (Block) BlockInitDangerZone.MyCephadromeSpawnBlock;
                                break;
                            }
                            case 53: {
                                b = (Block) BlockInitDangerZone.MyDragonSpawnBlock;
                                break;
                            }
                            case 54: {
                                b = (Block) BlockInitDangerZone.MyBeeSpawnBlock;
                                break;
                            }
                            case 55: {
                                b = (Block) BlockInitDangerZone.MyHorseSpawnBlock;
                                break;
                            }
                            case 56: {
                                b = (Block) BlockInitDangerZone.MyTrooperBugSpawnBlock;
                                break;
                            }
                            case 57: {
                                b = (Block) BlockInitDangerZone.MySpitBugSpawnBlock;
                                break;
                            }
                            case 58: {
                                b = (Block) BlockInitDangerZone.MyStinkBugSpawnBlock;
                                break;
                            }
                            case 59: {
                                b = (Block) BlockInitDangerZone.MyOstrichSpawnBlock;
                                break;
                            }
                            case 60: {
                                b = (Block) BlockInitDangerZone.MyGazelleSpawnBlock;
                                break;
                            }
                            case 61: {
                                b = (Block) BlockInitDangerZone.MyChipmunkSpawnBlock;
                                break;
                            }
                            case 62: {
                                b = (Block) BlockInitDangerZone.MyCreepingHorrorSpawnBlock;
                                break;
                            }
                            case 63: {
                                b = (Block) BlockInitDangerZone.MyTerribleTerrorSpawnBlock;
                                break;
                            }
                            case 64: {
                                b = (Block) BlockInitDangerZone.MyCliffRacerSpawnBlock;
                                break;
                            }
                            case 65: {
                                b = (Block) BlockInitDangerZone.MyTriffidSpawnBlock;
                                break;
                            }
                            case 66: {
                                b = (Block) BlockInitDangerZone.MyPitchBlackSpawnBlock;
                                break;
                            }
                            case 67: {
                                b = (Block) BlockInitDangerZone.MyLurkingTerrorSpawnBlock;
                                break;
                            }
                            case 68: {
                                b = (Block) BlockInitDangerZone.MyGodzillaPartSpawnBlock;
                                break;
                            }
                            case 69: {
                                b = (Block) BlockInitDangerZone.MyGodzillaSpawnBlock;
                                break;
                            }
                            case 70: {
                                b = (Block) BlockInitDangerZone.MySmallWormSpawnBlock;
                                break;
                            }
                            case 71: {
                                b = (Block) BlockInitDangerZone.MyMediumWormSpawnBlock;
                                break;
                            }
                            case 72: {
                                b = (Block) BlockInitDangerZone.MyLargeWormSpawnBlock;
                                break;
                            }
                            case 73: {
                                b = (Block) BlockInitDangerZone.MyCassowarySpawnBlock;
                                break;
                            }
                            case 74: {
                                b = (Block) BlockInitDangerZone.MyCloudSharkSpawnBlock;
                                break;
                            }
                            case 75: {
                                b = (Block) BlockInitDangerZone.MyGoldFishSpawnBlock;
                                break;
                            }
                            case 76: {
                                b = (Block) BlockInitDangerZone.MyLeafMonsterSpawnBlock;
                                break;
                            }
                            case 77: {
                                b = (Block) BlockInitDangerZone.MyTshirtSpawnBlock;
                                break;
                            }
                            case 78: {
                                b = (Block) BlockInitDangerZone.MyEnderKnightSpawnBlock;
                                break;
                            }
                            case 79: {
                                b = (Block) BlockInitDangerZone.MyEnderReaperSpawnBlock;
                                break;
                            }
                            case 80: {
                                b = (Block) BlockInitDangerZone.MyBeaverSpawnBlock;
                                break;
                            }
                            case 81: {
                                b = (Block) BlockInitDangerZone.MyTRexSpawnBlock;
                                break;
                            }
                            case 82: {
                                b = (Block) BlockInitDangerZone.MyHerculesSpawnBlock;
                                break;
                            }
                            case 83: {
                                b = (Block) BlockInitDangerZone.MyMantisSpawnBlock;
                                break;
                            }
                            case 84: {
                                b = (Block) BlockInitDangerZone.MyStinkySpawnBlock;
                                break;
                            }
                            case 85: {
                                b = (Block) BlockInitDangerZone.MyBoyfriendSpawnBlock;
                                break;
                            }
                            case 86: {
                                b = (Block) BlockInitDangerZone.MyTheKingPartSpawnBlock;
                                break;
                            }
                            case 87: {
                                b = (Block) BlockInitDangerZone.MyEasterBunnySpawnBlock;
                                break;
                            }
                            case 88: {
                                b = (Block) BlockInitDangerZone.MyCaterKillerSpawnBlock;
                                break;
                            }
                            case 89: {
                                b = (Block) BlockInitDangerZone.MyMolenoidSpawnBlock;
                                break;
                            }
                            case 90: {
                                b = (Block) BlockInitDangerZone.MySeaMonsterSpawnBlock;
                                break;
                            }
                            case 91: {
                                b = (Block) BlockInitDangerZone.MySeaViperSpawnBlock;
                                break;
                            }
                            case 92: {
                                b = (Block) BlockInitDangerZone.MyLeonSpawnBlock;
                                break;
                            }
                            case 93: {
                                b = (Block) BlockInitDangerZone.MyHammerheadSpawnBlock;
                                break;
                            }
                            case 94: {
                                b = (Block) BlockInitDangerZone.MyRubberDuckySpawnBlock;
                                break;
                            }
                            case 95: {
                                b = (Block) BlockInitDangerZone.MyVillagerSpawnBlock;
                                break;
                            }
                            case 96: {
                                b = (Block) BlockInitDangerZone.MyCriminalSpawnBlock;
                                break;
                            }
                            case 97: {
                                b = (Block) BlockInitDangerZone.MyTheQueenPartSpawnBlock;
                                break;
                            }
                        }
                        new WorldGenMinable(b, DangerZone.SpawnOres_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
        }
        if (DangerZone.Uranium_stats.rate > 0) {
            int patchy = DangerZone.Uranium_stats.rate + random.nextInt(9);
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= DangerZone.Uranium_stats.maxdepth && randPosY >= DangerZone.Uranium_stats.mindepth) {
                    new WorldGenMinable(DangerZone.MyOreUraniumBlock, DangerZone.Uranium_stats.clumpsize)
                        .generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
        if (DangerZone.Titanium_stats.rate > 0) {
            int patchy = DangerZone.Titanium_stats.rate + random.nextInt(9);
            if (DangerZone.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= DangerZone.Titanium_stats.maxdepth && randPosY >= DangerZone.Titanium_stats.mindepth) {
                    new WorldGenMinable(DangerZone.MyOreTitaniumBlock, DangerZone.Titanium_stats.clumpsize)
                        .generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
        if (DangerZone.Amethyst_stats.rate > 0) {
            int patchy = DangerZone.Amethyst_stats.rate + random.nextInt(12);
            if (DangerZone.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= DangerZone.Amethyst_stats.maxdepth && randPosY >= DangerZone.Amethyst_stats.mindepth) {
                    new WorldGenMinable(DangerZone.MyOreAmethystBlock, DangerZone.Amethyst_stats.clumpsize)
                        .generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
        if (DangerZone.Salt_stats.rate > 0) {
            int patchy = DangerZone.Salt_stats.rate + random.nextInt(9);
            if (DangerZone.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= DangerZone.Salt_stats.maxdepth && randPosY >= DangerZone.Salt_stats.mindepth) {
                    new WorldGenMinable(DangerZone.MyOreSaltBlock, DangerZone.Salt_stats.clumpsize)
                        .generate(world, random, randPosX, randPosY, randPosZ);
                }
            }
        }
        int patchy = 4 + random.nextInt(4);
        if (DangerZone.LessOre != 0) {
            patchy /= 2;
        }
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= 50 && randPosY >= 5) {
                new WorldGenMinable(DangerZone.RedAntTroll, 4).generate(world, random, randPosX, randPosY, randPosZ);
            }
        }

        patchy = 4 + random.nextInt(4);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= 50 && randPosY >= 5) {
                new WorldGenMinable(DangerZone.TermiteTroll, 4).generate(world, random, randPosX, randPosY, randPosZ);
            }
        }

        if (DangerZone.Ruby_stats.rate > 0) {
            patchy = DangerZone.Ruby_stats.rate + random.nextInt(5);
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= DangerZone.Ruby_stats.maxdepth && randPosY >= DangerZone.Ruby_stats.mindepth) {
                    for (int m = randPosY; m > 5; --m) {
                        Block bid = world.getBlock(randPosX, m, randPosZ);
                        if (bid == Blocks.lava || bid == Blocks.flowing_lava) {
                            bid = world.getBlock(randPosX, m - 1, randPosZ);
                            if (bid == Blocks.stone) {
                                DangerZone
                                    .setBlockFast(world, randPosX, m - 1, randPosZ, DangerZone.MyOreRubyBlock, 0, 2);
                                break;
                            }
                        }
                    }
                }
            }
        }
            if (DangerZone.Diamond_stats.rate > 0) {
                for (int i = 0; i < DangerZone.Diamond_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.Diamond_stats.maxdepth
                        && randPosY >= DangerZone.Diamond_stats.mindepth) {
                        new WorldGenMinable(Blocks.diamond_ore, DangerZone.Diamond_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
            if (DangerZone.BlkDiamond_stats.rate > 0) {
                for (int i = 0; i < DangerZone.BlkDiamond_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.BlkDiamond_stats.maxdepth
                        && randPosY >= DangerZone.BlkDiamond_stats.mindepth) {
                        new WorldGenMinable(Blocks.diamond_block, DangerZone.BlkDiamond_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
            if (DangerZone.Emerald_stats.rate > 0) {
                for (int i = 0; i < DangerZone.Emerald_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.Emerald_stats.maxdepth
                        && randPosY >= DangerZone.Emerald_stats.mindepth) {
                        new WorldGenMinable(Blocks.emerald_ore, DangerZone.Emerald_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
            if (DangerZone.BlkEmerald_stats.rate > 0) {
                for (int i = 0; i < DangerZone.BlkEmerald_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.BlkEmerald_stats.maxdepth
                        && randPosY >= DangerZone.BlkEmerald_stats.mindepth) {
                        new WorldGenMinable(Blocks.emerald_block, DangerZone.BlkEmerald_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
            if (DangerZone.Gold_stats.rate > 0) {
                for (int i = 0; i < DangerZone.Gold_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.Gold_stats.maxdepth && randPosY >= DangerZone.Gold_stats.mindepth) {
                        new WorldGenMinable(Blocks.gold_ore, DangerZone.Gold_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
            if (DangerZone.BlkGold_stats.rate > 0) {
                for (int i = 0; i < DangerZone.BlkGold_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.BlkGold_stats.maxdepth
                        && randPosY >= DangerZone.BlkGold_stats.mindepth) {
                        new WorldGenMinable(Blocks.gold_block, DangerZone.BlkGold_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
            if (DangerZone.BlkRuby_stats.rate > 0) {
                for (int i = 0; i < DangerZone.BlkRuby_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= DangerZone.BlkRuby_stats.maxdepth
                        && randPosY >= DangerZone.BlkRuby_stats.mindepth) {
                        new WorldGenMinable(DangerZone.MyBlockRubyBlock, DangerZone.BlkRuby_stats.clumpsize)
                            .generate(world, random, randPosX, randPosY, randPosZ);
                    }
                }
            }
    }

    public void addStrawberries(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(20) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (world.provider.dimensionId == DangerZone.DimensionID || b.biomeName.equals("Forest")
            || b.biomeName.equals("ForestHills")
            || b.biomeName.equals("Birch Forest Hills")
            || b.biomeName.equals("Birch Forest")) {
            for (int i = 0; i < 5; ++i) {
                for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 100; posY > 40
                    && world.isAirBlock(posX, posY, posZ); --posY) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyStrawberryPlant, 0, 2);
                        break;
                    }
                }
            }
        }
    }

    public boolean addHauntedHouse(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(285) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Plains") || b.biomeName.equals("Taiga") || b.biomeName.equals("Swampland")) {
            for (int i = 0; i < 5; ++i) {
                for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 100; posY > 40
                    && world.isAirBlock(posX, posY, posZ); --posY) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.MyDungeon.makeHauntedHouse(world, posX, posY, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addANest(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(230) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Forest") || b.biomeName.equals("ForestHills")
            || b.biomeName.equals("Jungle")
            || b.biomeName.equals("JungleHills")
            || b.biomeName.equals("Birch Forest")
            || b.biomeName.equals("Birch Forest Hills")) {
            for (int i = 0; i < 5; ++i) {
                for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 128; posY > 40
                    && world.isAirBlock(posX, posY, posZ); --posY) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        if (random.nextInt(2) == 0) {
                            DangerZone.MyDungeon.makeSmallBeeHive(world, posX, posY, posZ);
                        } else {
                            DangerZone.MyDungeon.makeMantisHive(world, posX, posY, posZ);
                        }
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addCorn(final World world, final Random random, final int chunkX, final int chunkZ) {
        int is_all_air = 1;
        int nc = 6;
        if (random.nextInt(35) != 1) {
            return;
        }
        if (DangerZone.LessLag == 1) {
            nc = 5;
        }
        if (DangerZone.LessLag == 2) {
            nc = 3;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (world.provider.dimensionId == DangerZone.DimensionID
            || world.provider.dimensionId == DangerZone.DimensionID3
            || b.biomeName.equals("Plains")) {
            for (int j = 0; j < nc; ++j) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                is_all_air = 1;
                int posY = 100;
                while (posY > 40 && world.isAirBlock(posX, posY, posZ)) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        for (int i = 1; i < 10; ++i) {
                            if (!world.isAirBlock(posX, posY + i, posZ)) {
                                is_all_air = 0;
                            }
                        }
                        if (is_all_air == 0) {
                            break;
                        }
                        int corn_height = random.nextInt(5);
                        if (++corn_height == 1) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyCornPlant1, 0, 2);
                        }
                        if (corn_height == 2) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyCornPlant2, 0, 2);
                            DangerZone.setBlockFast(world, posX, posY + 1, posZ, DangerZone.MyCornPlant1, 0, 2);
                        }
                        if (corn_height > 2) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyCornPlant2, 0, 2);
                            for (int i = 1; i < corn_height; ++i) {
                                DangerZone.setBlockFast(world, posX, posY + i, posZ, DangerZone.MyCornPlant4, 0, 2);
                            }
                            DangerZone
                                .setBlockFast(world, posX, posY + corn_height, posZ, DangerZone.MyCornPlant1, 0, 2);
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
    }

    public void addTomatoes(final World world, final Random random, final int chunkX, final int chunkZ) {
        int is_all_air = 1;
        if (random.nextInt(70) != 1) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (world.provider.dimensionId == DangerZone.DimensionID
            || world.provider.dimensionId == DangerZone.DimensionID3
            || b.biomeName.equals("Plains")) {
            for (int j = 0; j < 5; ++j) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                is_all_air = 1;
                int posY = 100;
                while (posY > 40 && world.isAirBlock(posX, posY, posZ)) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        for (int i = 1; i < 10; ++i) {
                            if (!world.isAirBlock(posX, posY + i, posZ)) {
                                is_all_air = 0;
                            }
                        }
                        if (is_all_air == 0) {
                            break;
                        }
                        int corn_height = random.nextInt(3);
                        if (++corn_height == 1) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyTomatoPlant1, 0, 2);
                        }
                        if (corn_height == 2) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyTomatoPlant2, 0, 2);
                            DangerZone.setBlockFast(world, posX, posY + 1, posZ, DangerZone.MyTomatoPlant1, 0, 2);
                        }
                        if (corn_height > 2) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyTomatoPlant3, 0, 2);
                            for (int i = 1; i < corn_height; ++i) {
                                DangerZone.setBlockFast(world, posX, posY + i, posZ, DangerZone.MyTomatoPlant4, 0, 2);
                            }
                            DangerZone
                                .setBlockFast(world, posX, posY + corn_height, posZ, DangerZone.MyTomatoPlant1, 0, 2);
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
    }

    public void addButterfliesAndMoths(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(10 + DangerZone.LessLag * 2) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (world.provider.dimensionId == DangerZone.DimensionID
            || world.provider.dimensionId == DangerZone.DimensionID6
            || b.biomeName.equals("Forest")
            || b.biomeName.equals("ForestHills")
            || b.biomeName.equals("River")
            || b.biomeName.equals("Jungle")
            || b.biomeName.equals("JungleHills")
            || b.biomeName.equals("Swampland")
            || b.biomeName.equals("Birch Forest")
            || b.biomeName.equals("Birch Forest Hills")
            || b.biomeName.equals("Roofed Forest")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                int which = 0;
                int posY = 100;
                while (posY > 40 && world.isAirBlock(posX, posY, posZ)) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        which = random.nextInt(3);
                        if (which == 0) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyButterflyPlant, 0, 2);
                            break;
                        }
                        if (which == 1) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyMothPlant, 0, 2);
                            break;
                        }
                        DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyFireflyPlant, 0, 2);
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
    }

    public void addPlayPool(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(350) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Ocean")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
                        DangerZone.MyDungeon.makePlayPool(world, posX, posY, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return;
                    }
                }
            }
        }
    }

    public void addFrogPond(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(350) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Plains")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.MyDungeon.makeFrogPond(world, posX, posY - 1, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return;
                    }
                }
            }
        }
    }

    public void addGoldFishBowl(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(350) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Ocean")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
                        DangerZone.MyDungeon.makeGoldFishBowl(world, posX, posY - 1, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return;
                    }
                }
            }
        }
    }

    public boolean addLeafMonster(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(275) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Plains")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.MyDungeon.makeLeafMonsterDungeon(world, posX, posY, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addRubberDuckyPond(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(275) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Plains")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.MyDungeon.makeRubberDuckyPond(world, posX, posY, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addSpitBug(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(190) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Swampland")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.MyDungeon.makeSpitBugLair(world, posX, posY, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addIgloo(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(220) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Ice Plains")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.snow) {
                        DangerZone.MyDungeon.makeIgloo(world, posX, posY - 2, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addBouncyCastle(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(230) != 0) {
            return false;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Desert")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.sand) {
                        DangerZone.MyDungeon.makeBouncyCastle(world, posX, posY - 1, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean addDamselInDistress(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(250) != 0) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            final int which = 0;
            for (int posY = 100; posY > 40; --posY) {
                if (world.getBlock(posX, posY, posZ) == Blocks.air
                    && world.getBlock(posX, posY - 1, posZ) == Blocks.grass
                    && this.quickSpaceCheck(world, posX, posY - 1, posZ)) {
                    DangerZone.MyDungeon.makeDamselInDistress(world, posX, posY - 1, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addSpiderHangout(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(350) != 0) {
            return false;
        }
        if (DangerZone.SpiderDriverEnable == 0) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            final int which = 0;
            for (int posY = 100; posY > 40; --posY) {
                if (world.getBlock(posX, posY, posZ) == Blocks.air
                    && world.getBlock(posX, posY - 1, posZ) == Blocks.grass
                    && this.quickSpaceCheck(world, posX, posY - 1, posZ)) {
                    DangerZone.MyDungeon.makeSpiderHangout(world, posX, posY - 1, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addRedAntHangout(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(250) != 0) {
            return false;
        }
        for (int i = 0; i < 4; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            final int which = 0;
            for (int posY = 100; posY > 40; --posY) {
                if (world.getBlock(posX, posY, posZ) == Blocks.air
                    && world.getBlock(posX, posY - 1, posZ) == Blocks.grass
                    && this.quickSpaceCheck(world, posX, posY - 1, posZ)) {
                    DangerZone.MyDungeon.makeRedAntHangout(world, posX, posY - 1, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public void addWaterDragonLair(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(350) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Ocean")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
                        DangerZone.MyDungeon.makeWaterDragonLair(world, posX, posY - 1, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return;
                    }
                }
            }
        }
    }

    public void addGirlfriendIsland(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(300) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Ocean")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
                        DangerZone.MyDungeon.makeGirlfriendIsland(world, posX, posY - 1, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return;
                    }
                }
            }
        }
    }

    public void addMonsterIsland(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(300) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (b.biomeName.equals("Ocean")) {
            for (int i = 0; i < 4; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                final int which = 0;
                for (int posY = 100; posY > 40; --posY) {
                    if (world.getBlock(posX, posY, posZ) == Blocks.air
                        && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
                        DangerZone.MyDungeon.makeMonsterIsland(world, posX, posY - 1, posZ);
                        OreSpawnWorld.recently_placed = 50;
                        return;
                    }
                }
            }
        }
    }

    public void addMosquitos(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(25 + DangerZone.LessLag * 2) != 0) {
            return;
        }
        if ((world.provider.dimensionId == DangerZone.DimensionID
            || world.provider.dimensionId == DangerZone.DimensionID3) && random.nextInt(3) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (world.provider.dimensionId == DangerZone.DimensionID
            || world.provider.dimensionId == DangerZone.DimensionID2
            || world.provider.dimensionId == DangerZone.DimensionID3
            || b.biomeName.equals("Jungle")
            || b.biomeName.equals("Swampland")) {
            for (int i = 0; i < 2; ++i) {
                for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 100; posY > 40
                    && world.isAirBlock(posX, posY, posZ); --posY) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyMosquitoPlant, 0, 2);
                        break;
                    }
                }
            }
        }
    }

    public void addNetherMosquitos(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(25) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 90; posY > 20; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.netherrack) {
                    DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyMosquitoPlant, 0, 2);
                    break;
                }
            }
        }
    }

    public void addNetherAnts(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.RedAntEnable == 0) {
            return;
        }
        if (random.nextInt(25) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 90; posY > 20; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.netherrack) {
                    DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.MyRedAntBlock, 0, 2);
                    break;
                }
            }
        }
    }

    public void addAnts(final World world, final Random random, final int chunkX, final int chunkZ, int redfreq) {
        if (DangerZone.RedAntEnable == 0 && DangerZone.BlackAntEnable == 0
            && DangerZone.RainbowAntEnable == 0
            && DangerZone.UnstableAntEnable == 0) {
            return;
        }
        if (redfreq < 2) {
            redfreq = 2;
        }
        if (random.nextInt(30 + DangerZone.LessLag * 4) != 0) {
            return;
        }
        for (int i = 0; i < 4; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            int posY = 100;
            while (posY > 40 && world.isAirBlock(posX, posY, posZ)) {
                if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    if (random.nextInt(redfreq) == 0) {
                        final int which = random.nextInt(4);
                        if (which == 0 && DangerZone.RedAntEnable != 0) {
                            DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.MyRedAntBlock, 0, 2);
                        }
                        if (which == 1 && DangerZone.RainbowAntEnable != 0) {
                            DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.MyRainbowAntBlock, 0, 2);
                        }
                        if (which == 2 && DangerZone.UnstableAntEnable != 0) {
                            DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.MyUnstableAntBlock, 0, 2);
                        }
                        if (which == 3 && DangerZone.TermiteEnable != 0) {
                            DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.TermiteBlock, 0, 2);
                        }
                        break;
                    }
                    if (DangerZone.BlackAntEnable != 0) {
                        DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.MyAntBlock, 0, 2);
                        break;
                    }
                    break;
                } else {
                    --posY;
                }
            }
        }
    }

    public void addEndAnts(final World world, final Random random, final int chunkX, final int chunkZ) {}

    public void addEndKnights(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(25) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 90; posY > 10; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone
                    && this.quickSpaceCheck(world, posX, posY, posZ)) {
                    DangerZone.MyDungeon.makeEnderKnightDungeon(world, posX, posY, posZ);
                    return;
                }
            }
        }
    }

    public void addEndReapers(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(25) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 90; posY > 10; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone
                    && this.quickSpaceCheck(world, posX, posY, posZ)) {
                    DangerZone.MyDungeon.makeEnderReaperGraveyard(world, posX, posY, posZ);
                    return;
                }
            }
        }
    }

    public void addHospital(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(25) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 90; posY > 10; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone
                    && this.quickSpaceCheck(world, posX, posY, posZ)) {
                    DangerZone.MyDungeon.makeEnderDragonHospital(world, posX, posY, posZ);
                    return;
                }
            }
        }
    }

    public void addEnderCastle(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(50) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 90; posY > 10; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.end_stone
                    && this.quickBigSpaceCheck(world, posX, posY, posZ)) {
                    DangerZone.MyDungeon.makeEnderCastle(world, posX, posY, posZ);
                    return;
                }
            }
        }
    }

    public void addUnstableAnts(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.UnstableAntEnable == 0) {
            return;
        }
        if (random.nextInt(30) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 20; posY > 2
                && world.isAirBlock(posX, posY, posZ); --posY) {
                if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.MyUnstableAntBlock, 0, 2);
                    break;
                }
            }
        }
    }

    public void addCrystalTermites(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.TermiteEnable == 0) {
            return;
        }
        if (random.nextInt(40) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ)
                    && world.getBlock(posX, posY - 1, posZ) == DangerZone.CrystalGrass) {
                    DangerZone.setBlockFast(world, posX, posY - 1, posZ, DangerZone.CrystalTermiteBlock, 0, 2);
                    break;
                }
            }
        }
    }

    public boolean addRotatorStation(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.RotatorEnable == 0) {
            return false;
        }
        if (random.nextInt(150) != 0) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ)
                    && world.getBlock(posX, posY - 1, posZ) == DangerZone.CrystalGrass) {
                    DangerZone.MyDungeon.makeRotatorStation(world, posX, posY, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addRoundRotator(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.RotatorEnable == 0) {
            return false;
        }
        if (random.nextInt(150) != 0) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ)
                    && world.getBlock(posX, posY - 1, posZ) == DangerZone.CrystalGrass) {
                    DangerZone.MyDungeon.makeRoundRotator(world, posX, posY, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addUrchinSpawner(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.UrchinEnable == 0) {
            return false;
        }
        if (random.nextInt(180) != 0) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ)
                    && world.getBlock(posX, posY - 1, posZ) == DangerZone.CrystalGrass) {
                    DangerZone.MyDungeon.makeUrchinSpawner(world, posX, posY, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addCrystalHauntedHouse(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(230) != 0) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ)
                    && world.getBlock(posX, posY - 1, posZ) == DangerZone.CrystalGrass) {
                    DangerZone.MyDungeon.makeCrystalHauntedHouse(world, posX, posY, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addCrystalBattleTower(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(280) != 0) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ)
                    && world.getBlock(posX, posY - 1, posZ) == DangerZone.CrystalGrass) {
                    DangerZone.MyDungeon.makeCrystalBattleTower(world, posX, posY, posZ);
                    OreSpawnWorld.recently_placed = 50;
                    return true;
                }
            }
        }
        return false;
    }

    public void addIrukandji(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (DangerZone.IrukandjiEnable == 0) {
            return;
        }
        if (random.nextInt(80) != 0) {
            return;
        }
        for (int i = 0; i < 3; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            for (int posY = 100; posY > 50; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.water) {
                    DangerZone.setBlockFast(world, posX, posY, posZ, Blocks.mob_spawner, 0, 2);
                    final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world
                        .getTileEntity(posX, posY, posZ);
                    if (tileentitymobspawner != null) {
                        tileentitymobspawner.func_145881_a()
                            .setEntityName("Irukandji");
                    }
                    return;
                }
            }
        }
    }

    public void addCrystalChestsAndSpawners(final World world, final Random random, final int chunkX,
        final int chunkZ) {
        Block bid = Blocks.air;
        int i = 0;
        while (i < 3) {
            final int posX = 1 + chunkX + random.nextInt(14);
            final int posZ = 1 + chunkZ + random.nextInt(14);
            final int posY = 25;
            if (world.isAirBlock(posX, posY, posZ)) {
                bid = world.getBlock(posX, posY, posZ);
                if (bid != Blocks.air) {
                    break;
                }
                bid = world.getBlock(posX + 1, posY, posZ);
                if (bid == Blocks.air) {
                    this.addCrystalChest(world, posX, posY, posZ, 5);
                    break;
                }
                bid = world.getBlock(posX - 1, posY, posZ);
                if (bid == Blocks.air) {
                    this.addCrystalChest(world, posX, posY, posZ, 4);
                    break;
                }
                bid = world.getBlock(posX, posY, posZ + 1);
                if (bid == Blocks.air) {
                    this.addCrystalChest(world, posX, posY, posZ, 2);
                    break;
                }
                bid = world.getBlock(posX, posY, posZ - 1);
                if (bid == Blocks.air) {
                    this.addCrystalChest(world, posX, posY, posZ, 3);
                    break;
                }
                break;
            } else {
                ++i;
            }
        }
    }

    public void addCrystalChest(final World world, final int x, final int y, final int z, final int dir) {
        final int i = world.rand.nextInt(3);
        if (i == 0) {
            DangerZone.setBlockFast(world, x, y, z, (Block) Blocks.chest, 0, 2);
            world.setBlockMetadataWithNotify(x, y, z, dir, 3);
            final TileEntityChest chest = (TileEntityChest) world.getTileEntity(x, y, z);
            if (chest != null) {
                final Random rand = world.rand;
                final Trees oreSpawnTrees = DangerZone.OreSpawnTrees;
                WeightedRandomChestContent.generateChestContents(
                    rand,
                    Trees.CrystalChestContentsList,
                    (IInventory) chest,
                    1 + world.rand.nextInt(3));
            }
        } else {
            DangerZone.setBlockFast(world, x, y, z, Blocks.mob_spawner, 0, 2);
            final TileEntityMobSpawner tileentitymobspawner = (TileEntityMobSpawner) world.getTileEntity(x, y, z);
            if (tileentitymobspawner != null) {
                final int t = world.rand.nextInt(2);
                if (t == 0) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Dungeon Beast");
                }
                if (t == 1) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Rat");
                }
            }
        }
    }

    public void addIslands(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = 2 + chunkX + random.nextInt(12);
        final int posZ = 2 + chunkZ + random.nextInt(12);
        if (random.nextInt(10 + DangerZone.LessLag * 2) != 1) {
            return;
        }
        for (int posY = 20; posY > 2 && world.isAirBlock(posX, posY, posZ); --posY) {
            if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyIslandBlock, 0, 2);
                break;
            }
        }
    }

    public boolean addAppleTrees(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        int freq = Math.abs(chunkX / 16) + Math.abs(chunkZ / 16);
        int howmany = 2;
        int which = 0;
        boolean added = false;
        freq %= 15;
        howmany += random.nextInt(2 + (15 - freq) / 2);
        which = random.nextInt(10);
        if (random.nextInt(15 + freq) != 0) {
            return false;
        }
        if (DangerZone.LessLag == 1) {
            howmany /= 2;
        }
        if (DangerZone.LessLag == 2) {
            howmany /= 4;
            if (howmany < 1) {
                return false;
            }
        }
        for (int i = 0; i < howmany; ++i) {
            for (int posX = 2 + chunkX + random.nextInt(12), posZ = 2 + chunkZ + random.nextInt(12),
                posY = 100; posY > 50 && world.isAirBlock(posX, posY, posZ); --posY) {
                if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    final ItemAppleSeed a = (ItemAppleSeed) DangerZone.MyAppleSeed;
                    if (which < 8) {
                        a.makeTree(world, posX, posY - 1, posZ, BlockInitDangerZone.BlockAppleLeaves, chunk);
                    }
                    if (which == 8) {
                        a.makeTree(world, posX, posY - 1, posZ, DangerZone.MyCherryLeaves, chunk);
                    }
                    if (which == 9) {
                        a.makeTree(world, posX, posY - 1, posZ, DangerZone.MyPeachLeaves, chunk);
                    }
                    added = true;
                    break;
                }
            }
        }
        return added;
    }

    public boolean addHugeTree(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        int made_one = 0;
        if (random.nextInt(50) != 0) {
            return false;
        }
        if (DangerZone.LessLag == 1 && random.nextInt(2) != 0) {
            return false;
        }
        if (DangerZone.LessLag == 2 && random.nextInt(4) != 0) {
            return false;
        }
        for (int i = 0; i < 3 && made_one == 0; ++i) {
            final int posX = 4 + chunkX + random.nextInt(8);
            final int posZ = 4 + chunkZ + random.nextInt(8);
            for (int posY = 127; posY > 50 && made_one == 0; --posY) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    final ItemMagicApple a = (ItemMagicApple) DangerZone.MagicApple;
                    final int tree_type = random.nextInt(4);
                    int tree_radius = 6 - random.nextInt(2);
                    boolean no_critters = false;
                    Block leaf_type = (Block) Blocks.leaves;
                    if (random.nextInt(100) > 25) {
                        no_critters = true;
                    }
                    final int rand_treetype = random.nextInt(100);
                    if (rand_treetype > 75) {
                        if (tree_type != 3 && random.nextInt(20) == 0) {
                            leaf_type = BlockInitDangerZone.BlockAppleLeaves;
                        }
                        a.MakeBigSquareTree(
                            world,
                            posX,
                            posY - 1,
                            posZ,
                            Blocks.log,
                            leaf_type,
                            Blocks.mossy_cobblestone,
                            tree_type,
                            tree_radius,
                            no_critters,
                            chunk);
                    } else if (rand_treetype == 0) {
                        tree_radius = 6;
                        no_critters = true;
                        if (random.nextInt(2) == 0) {
                            a.MakeBigSquareTree(
                                world,
                                posX,
                                posY - 1,
                                posZ,
                                Blocks.gold_block,
                                Blocks.emerald_block,
                                Blocks.diamond_block,
                                -1,
                                tree_radius,
                                no_critters,
                                chunk);
                        } else {
                            a.MakeBigSquareTree(
                                world,
                                posX,
                                posY - 1,
                                posZ,
                                Blocks.obsidian,
                                DangerZone.MyBlockRubyBlock,
                                DangerZone.MyBlockAmethystBlock,
                                -1,
                                tree_radius,
                                no_critters,
                                chunk);
                        }
                    } else if (rand_treetype > 15) {
                        tree_radius = 6 - random.nextInt(3);
                        a.MakeBigCircularTree(
                            world,
                            posX,
                            posY - 1,
                            posZ,
                            Blocks.log,
                            leaf_type,
                            Blocks.mossy_cobblestone,
                            tree_type,
                            tree_radius,
                            no_critters,
                            chunk);
                    } else {
                        tree_radius = 6 - random.nextInt(3);
                        a.MakeBigRoundTree(
                            world,
                            posX,
                            posY - 1,
                            posZ,
                            Blocks.log,
                            leaf_type,
                            Blocks.mossy_cobblestone,
                            tree_type,
                            tree_radius,
                            chunk);
                    }
                    made_one = 1;
                    break;
                }
            }
        }
        return made_one != 0;
    }

    public void addVeggies(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(15) != 0) {
            return;
        }
        final BiomeGenBase b = world.getBiomeGenForCoords(chunkX, chunkZ);
        if (world.provider.dimensionId == DangerZone.DimensionID
            || world.provider.dimensionId == DangerZone.DimensionID2
            || world.provider.dimensionId == DangerZone.DimensionID6
            || b.biomeName.equals("River")
            || b.biomeName.equals("Swampland")) {
            for (int i = 0; i < 8; ++i) {
                final int posX = chunkX + random.nextInt(16);
                final int posZ = chunkZ + random.nextInt(16);
                int posY = 100;
                while (posY > 40 && world.isAirBlock(posX, posY, posZ)) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        final int what = random.nextInt(6);
                        if (what == 0) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, Blocks.carrots, 0, 2);
                            break;
                        }
                        if (what == 1) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, Blocks.potatoes, 0, 2);
                            break;
                        }
                        if (what == 2) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyRadishPlant, 0, 2);
                            break;
                        }
                        if (what == 3) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, DangerZone.MyLettucePlant1, 0, 2);
                            break;
                        }
                        if (what == 4) {
                            if (random.nextInt(10) == 0) {
                                DangerZone.setBlockFast(world, posX, posY, posZ, Blocks.melon_stem, 0, 2);
                                break;
                            }
                            break;
                        } else {
                            if (random.nextInt(50) == 1 && DangerZone.enableduplicatortree != 0) {
                                DangerZone.setBlockFast(
                                    world,
                                    posX,
                                    posY,
                                    posZ,
                                    BlockInitDangerZone.BlockDuplicatorLog,
                                    0,
                                    2);
                                break;
                            }
                            break;
                        }
                    } else {
                        --posY;
                    }
                }
            }
        }
    }

    public void addRocks(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(5) != 0) {
            return;
        }
        if (DangerZone.RockEnable == 0) {
            return;
        }
        for (int howmany = 3 + random.nextInt(10), i = 0; i < howmany; ++i) {
            for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 110; posY > 40
                && world.getBlock(posX, posY, posZ) == Blocks.air; --posY) {
                final Block bid = world.getBlock(posX, posY - 1, posZ);
                if (bid == Blocks.grass || bid == Blocks.sand || bid == DangerZone.CrystalGrass) {
                    this.spawnCreature(world, "Rock", posX, posY, posZ);
                    break;
                }
            }
        }
    }

    public void addD4Rocks(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(7) != 0) {
            return;
        }
        for (int howmany = 3 + random.nextInt(10), i = 0; i < howmany; ++i) {
            for (int posX = chunkX + random.nextInt(16), posZ = chunkZ + random.nextInt(16), posY = 20; posY > 5
                && world.getBlock(posX, posY, posZ) == Blocks.air; --posY) {
                if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    this.spawnCreature(world, "Rock", posX, posY, posZ);
                    break;
                }
            }
        }
    }

    public boolean addFairyTree(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + 8;
        final int posZ = chunkZ + 8;
        if (random.nextInt(5) != 0) {
            return false;
        }
        for (int posY = 128; posY > 40; --posY) {
            if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == BlockInitDangerZone.CrystalGrass) {
                for (int i = -8; i <= 8; ++i) {
                    for (int j = -8; j <= 8; ++j) {
                        final Block bid = world.getBlock(posX + i, posY, posZ + j);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                for (int i = -2; i <= 2; ++i) {
                    for (int j = -2; j <= 2; ++j) {
                        final Block bid = world.getBlock(posX + i, posY - 1, posZ + j);
                        if (bid != BlockInitDangerZone.CrystalGrass) {
                            return false;
                        }
                    }
                }
                if (random.nextInt(5) != 1) {
                    DangerZone.OreSpawnTrees.FairyTree(world, posX, posY - 1, posZ);
                } else {
                    DangerZone.OreSpawnTrees.FairyCastleTree(world, posX, posY, posZ);
                }
                OreSpawnWorld.recently_placed = 50;
                break;
            }
        }
        return true;
    }

    public boolean addRubyDungeon(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(15) != 0) {
            return false;
        }
        for (int i = 0; i < 8; ++i) {
            final int posX = chunkX + random.nextInt(8);
            final int posZ = chunkZ + random.nextInt(8);
            for (int posY = 50; posY > 5; --posY) {
                if (world.getBlock(posX, posY, posZ) == Blocks.lava) {
                    DangerZone.RubyDungeon.makeDungeon(world, posX, posY, posZ);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addGenericDungeon(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(16) != 0) {
            return false;
        }
        final int posX = chunkX + random.nextInt(4);
        final int posZ = chunkZ + random.nextInt(4);
        final int posY = 5 + random.nextInt(40);
        DangerZone.MyDungeon.makeDungeon(world, posX, posY, posZ);
        return true;
    }

    public boolean addBeeHive(final World world, final Random random, final int chunkX, final int chunkZ) {
        int lowestY = 128;
        int lowestX = chunkX;
        int lowestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 30) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) == Blocks.grass) {
                        if (posY < lowestY) {
                            lowestY = posY;
                            lowestX = posX;
                            lowestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && lowestY > 40) {
            DangerZone.MyDungeon.makeBeeHive(world, lowestX, lowestY + 3, lowestZ);
            OreSpawnWorld.recently_placed = 50;
            return true;
        }
        return false;
    }

    public boolean addAlienWTF(final World world, final Random random, final int chunkX, final int chunkZ) {
        int lowestY = 128;
        int lowestX = chunkX;
        int lowestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 30) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) == Blocks.grass) {
                        if (posY < lowestY) {
                            lowestY = posY;
                            lowestX = posX;
                            lowestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && lowestY > 40) {
            DangerZone.MyDungeon.makeAlienWTFDungeon(world, lowestX, lowestY, lowestZ);
            OreSpawnWorld.recently_placed = 50;
            return true;
        }
        return false;
    }

    public boolean addEnderKnight(final World world, final Random random, final int chunkX, final int chunkZ) {
        int lowestY = 128;
        int lowestX = chunkX;
        int lowestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 30) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) == Blocks.grass) {
                        if (posY < lowestY) {
                            lowestY = posY;
                            lowestX = posX;
                            lowestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && lowestY > 40) {
            DangerZone.MyDungeon.makeEnderKnightDungeon(world, lowestX, lowestY, lowestZ);
            OreSpawnWorld.recently_placed = 50;
            return true;
        }
        return false;
    }

    public boolean addLeonNest(final World world, final Random random, final int chunkX, final int chunkZ) {
        int highestY = 30;
        int highestX = chunkX;
        int highestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 80) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) == Blocks.grass) {
                        if (posY > highestY) {
                            highestY = posY + 1;
                            highestX = posX;
                            highestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && highestY > 80) {
            DangerZone.MyDungeon.makeLeonNest(world, highestX, highestY, highestZ);
            OreSpawnWorld.recently_placed = 50;
            return true;
        }
        return false;
    }

    public boolean addShadowDungeon(final World world, final Random random, final int chunkX, final int chunkZ) {
        int lowestY = 128;
        int lowestX = chunkX;
        int lowestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 30) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) == Blocks.grass) {
                        if (posY < lowestY) {
                            lowestY = posY;
                            lowestX = posX;
                            lowestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && lowestY > 40) {
            DangerZone.MyDungeon.makeShadowDungeon(world, lowestX, lowestY, lowestZ);
            OreSpawnWorld.recently_placed = 50;
            return true;
        }
        return false;
    }

    public boolean addD4RubyDungeon(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            final Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                DangerZone.RubyDungeon.makeDungeon(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4CephadromeAltar(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            final Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                DangerZone.MyDungeon.makeCephadromeAltar(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4Castle(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -20; x < 33; ++x) {
                    for (int z = -4; z < 33; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                if (random.nextInt(2) == 1) {
                    DangerZone.MyDungeon.makeEnormousCastle(world, posX, posY, posZ);
                } else {
                    DangerZone.MyDungeon.makeEnormousCastleQ(world, posX, posY, posZ);
                }
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4Greenhouse(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -2; x < 25; ++x) {
                    for (int z = -4; z < 25; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                DangerZone.MyDungeon.makeGreenhouseDungeon(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4NightmareRookery(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -5; x < 25; ++x) {
                    for (int z = -4; z < 5; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                DangerZone.MyDungeon.makeNightmareRookery(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4StinkyHouse(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -8; x < 20; ++x) {
                    for (int z = -8; z < 20; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                DangerZone.MyDungeon.makeStinkyHouse(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4WhiteHouse(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -20; x < 30; ++x) {
                    for (int z = -20; z < 300; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                DangerZone.MyDungeon.makeWhiteHouse(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4EnderCastle(final World world, final Random random, final int chunkX, final int chunkZ) {

        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -5; x < 25; ++x) {
                    for (int z = -5; z < 25; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                DangerZone.MyDungeon.makeEnderCastle(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4IncaPyramid(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -10; x < 50; ++x) {
                    for (int z = -10; z < 40; ++z) {
                        bid = world.getBlock(posX + x, posY + 18, posZ + z);
                        if (bid != Blocks.air) {
                            return false;
                        }
                    }
                }
                DangerZone.MyDungeon.makeIncaPyramid(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4RobotLab(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                for (int x = -5; x < 60; ++x) {
                    for (int z = -5; z < 70; ++z) {
                        bid = world.getBlock(posX + x, posY + 4, posZ + z);
                        if (bid != Blocks.air) {
                            if (bid != Blocks.log) {
                                if (bid != BlockInitDangerZone.BlockAppleLeaves) {
                                    if (bid != BlockInitDangerZone.BlockScaryLeaves) {
                                        if (bid != Blocks.air) {
                                            return false;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                DangerZone.MyDungeon.makeRobotLab(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4Mini(final World world, final Random random, final int chunkX, final int chunkZ) {

        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            final Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                DangerZone.MyDungeon.makeMiniDungeon(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addPumpkin(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            final Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                DangerZone.MyDungeon.makePumpkin(world, posX, posY + 1, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public boolean addD4CloudShark(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = 4 + chunkX + random.nextInt(8);
        final int posZ = 4 + chunkZ + random.nextInt(8);
        DangerZone.MyDungeon.makeCloudSharkDungeon(world, posX, 150 + world.rand.nextInt(10), posZ);
        return true;
    }

    public boolean addD4Rainbow(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = 4 + chunkX + random.nextInt(8);
        final int posZ = 4 + chunkZ + random.nextInt(8);
        DangerZone.MyDungeon.makeRainbow(world, posX, 70 + world.rand.nextInt(20), posZ);
        OreSpawnWorld.recently_placed = 50;
        return true;
    }

    public boolean addD4GenericDungeon(final World world, final Random random, final int chunkX, final int chunkZ) {
        final int posX = chunkX + random.nextInt(8);
        final int posZ = chunkZ + random.nextInt(8);
        for (int posY = 20; posY > 4; --posY) {
            final Block bid = world.getBlock(posX, posY, posZ);
            if (bid == Blocks.grass) {
                DangerZone.MyDungeon.makeDungeon(world, posX, posY, posZ);
                OreSpawnWorld.recently_placed = 50;
                return true;
            }
        }
        return false;
    }

    public void addLavaAndWater(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(5) != 0) {
            return;
        }
        for (int i = 0; i < 6; ++i) {
            final int posX = chunkX + random.nextInt(16);
            final int posZ = chunkZ + random.nextInt(16);
            int posY = 128;
            while (posY > 75 && world.isAirBlock(posX, posY, posZ)) {
                if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    Block bid = world.getBlock(posX, posY - 2, posZ);
                    if (bid != Blocks.dirt && bid != Blocks.stone) {
                        break;
                    }
                    int air = 0;
                    int non_air = 0;
                    bid = world.getBlock(posX + 1, posY - 1, posZ);
                    if (bid == Blocks.air) {
                        ++air;
                    }
                    if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) {
                        ++non_air;
                    }
                    bid = world.getBlock(posX - 1, posY - 1, posZ);
                    if (bid == Blocks.air) {
                        ++air;
                    }
                    if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) {
                        ++non_air;
                    }
                    bid = world.getBlock(posX, posY - 1, posZ + 1);
                    if (bid == Blocks.air) {
                        ++air;
                    }
                    if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) {
                        ++non_air;
                    }
                    bid = world.getBlock(posX, posY - 1, posZ - 1);
                    if (bid == Blocks.air) {
                        ++air;
                    }
                    if (bid == Blocks.dirt || bid == Blocks.stone || bid == Blocks.grass) {
                        ++non_air;
                    }
                    if (air != 0 && non_air != 0) {
                        final int what = random.nextInt(2);
                        if (what == 0) {
                            DangerZone.setBlockFast(world, posX, posY, posZ, (Block) Blocks.flowing_water, 0, 3);
                            DangerZone.setBlockFast(world, posX, posY - 1, posZ, Blocks.water, 0, 3);
                            DangerZone.setBlockFast(world, posX, posY - 2, posZ, Blocks.water, 0, 3);
                        } else {
                            DangerZone.setBlockFast(world, posX, posY, posZ, (Block) Blocks.flowing_lava, 0, 3);
                            DangerZone.setBlockFast(world, posX, posY - 1, posZ, Blocks.lava, 0, 3);
                            DangerZone.setBlockFast(world, posX, posY - 2, posZ, Blocks.lava, 0, 3);
                        }
                        return;
                    }
                    break;
                } else {
                    --posY;
                }
            }
        }
    }

    public boolean addOtherTrees(final World world, final Random random, final int chunkX, final int chunkZ) {
        int nc = 5;
        int count = 0;
        if (random.nextInt(30) != 0) {
            return false;
        }
        if (world.provider.dimensionId == DangerZone.DimensionID) {
            final int dir = 0;
            final int what = random.nextInt(2);
            for (int i = 0; i < nc; ++i) {
                final int posX = 3 + chunkX + random.nextInt(10);
                final int posZ = 3 + chunkZ + random.nextInt(10);
                int posY = 100;
                while (posY > 50 && world.isAirBlock(posX, posY, posZ)) {
                    if (world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                        ++count;
                        if (what == 0) {
                            DangerZone.OreSpawnTrees.WindTree(world, posX, posY - 1, posZ, dir);
                            if (count >= 4) {
                                return true;
                            }
                            break;
                        } else {
                            DangerZone.OreSpawnTrees.SkyTree(world, posX, posY - 1, posZ);
                            if (count >= 3) {
                                return true;
                            }
                            break;
                        }
                    } else {
                        --posY;
                    }
                }
            }
        }
        return count > 0;
    }

    public boolean addKingAltar(final World world, final Random random, final int chunkX, final int chunkZ) {
        if (random.nextInt(2000) != 1) {
            return false;
        }
        for (int i = 0; i < 8; ++i) {
            final int posX = 3 + chunkX + random.nextInt(10);
            final int posZ = 3 + chunkZ + random.nextInt(10);
            int posY = 100;
            while (posY > 50) {
                if (world.isAirBlock(posX, posY, posZ) && world.getBlock(posX, posY - 1, posZ) == Blocks.grass) {
                    if (!this.quickReallyBigSpaceCheck(world, posX, posY - 1, posZ)) {
                        return false;
                    }
                    if (random.nextInt(2) == 0) {
                        DangerZone.MyDungeon.makeKingAltar(world, posX, posY - 1, posZ);
                    } else {
                        DangerZone.MyDungeon.makeQueenAltar(world, posX, posY - 1, posZ);
                    }
                    OreSpawnWorld.recently_placed = 100;
                    return true;
                } else {
                    --posY;
                }
            }
        }
        return false;
    }

    public void addBasiliskMaze(final World world, final Random random, final int chunkX, final int chunkZ) {
        int lowestY = 128;
        int lowestX = chunkX;
        int lowestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 30) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) != Blocks.air) {
                        if (posY < lowestY) {
                            lowestY = posY;
                            lowestX = posX;
                            lowestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && lowestY > 40) {
            DangerZone.BMaze.buildBasiliskMaze(world, lowestX, lowestY - 2, lowestZ);
            OreSpawnWorld.recently_placed = 50;
        }
    }

    public void addKyuubiDungeon(final World world, final Random random, final int chunkX, final int chunkZ) {
        int lowestY = 128;
        int lowestX = chunkX;
        int lowestZ = chunkZ;
        int found = 0;
        for (int i = 0; i < 16; i += 3) {
            for (int j = 0; j < 16; j += 3) {
                final int posX = chunkX + i;
                final int posZ = chunkZ + j;
                int posY = 128;
                while (posY > 30) {
                    if (world.getBlock(posX, posY + 1, posZ) == Blocks.air
                        && world.getBlock(posX, posY, posZ) != Blocks.air) {
                        if (posY < lowestY) {
                            lowestY = posY;
                            lowestX = posX;
                            lowestZ = posZ;
                            found = 1;
                            break;
                        }
                        break;
                    } else {
                        --posY;
                    }
                }
            }
        }
        if (found != 0 && lowestY > 40) {
            DangerZone.MyDungeon.makeKyuubiDungeon(world, lowestX, lowestY - 2, lowestZ);
            OreSpawnWorld.recently_placed = 50;
        }
    }

    private boolean quickSpaceCheck(final World world, final int posX, final int posY, final int posZ) {
        for (int i = -2; i < 10; ++i) {
            for (int k = -2; k < 10; ++k) {
                if (world.getBlock(posX + i, posY + 4, posZ + k) != Blocks.air) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean quickBigSpaceCheck(final World world, final int posX, final int posY, final int posZ) {
        for (int i = -5; i < 25; ++i) {
            for (int k = -5; k < 25; ++k) {
                if (world.getBlock(posX + i, posY + 8, posZ + k) != Blocks.air) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean quickReallyBigSpaceCheck(final World world, final int posX, final int posY, final int posZ) {
        for (int i = -5; i < 55; ++i) {
            for (int k = -5; k < 55; ++k) {
                if (world.getBlock(posX + i, posY + 8, posZ + k) != Blocks.air) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean D4BigSpaceCheck(final World world, final int posX, final int posY, final int posZ) {
        for (int i = -25; i < 40; ++i) {
            for (int k = -25; k < 30; ++k) {
                final Block bid = world.getBlock(posX + i, posY + 4, posZ + k);
                if (bid != Blocks.air) {
                    if (bid != Blocks.log) {
                        if (bid != BlockInitDangerZone.BlockAppleLeaves) {
                            if (bid != BlockInitDangerZone.BlockScaryLeaves) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    private Entity spawnCreature(final World par0World, final String par1, double par2, final double par4,
        double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            if (par2 > 0.0) {
                par2 += 0.5;
            }
            if (par2 < 0.0) {
                par2 -= 0.5;
            }
            if (par6 > 0.0) {
                par6 += 0.5;
            }
            if (par6 < 0.0) {
                par6 -= 0.5;
            }
            var8.setLocationAndAngles(par2, par4 + 0.01, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    static {
        OreSpawnWorld.recently_placed = 50;
    }
}
