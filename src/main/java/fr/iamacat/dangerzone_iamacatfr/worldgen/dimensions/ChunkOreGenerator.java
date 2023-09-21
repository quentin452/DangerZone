
package fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions;

import java.util.Random;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class ChunkOreGenerator {

    public void generateOresInChunk(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if (OreSpawnMain.SpawnOres_stats.rate > 0) {
            int patchy = OreSpawnMain.SpawnOres_stats.rate + random.nextInt(30);
            if (random.nextInt(20) == 0) {
                patchy += 30;
            }
            if (OreSpawnMain.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= OreSpawnMain.SpawnOres_stats.maxdepth
                    && randPosY >= OreSpawnMain.SpawnOres_stats.mindepth) {
                    if (random.nextInt(104) < 7) {
                        final int j = random.nextInt(7);
                        Block b = Blocks.air;
                        switch (j) {
                            case 0: {
                                b = OreSpawnMain.MyBrutalflySpawnBlock;
                                break;
                            }
                            case 1: {
                                b = OreSpawnMain.MyNastysaurusSpawnBlock;
                                break;
                            }
                            case 2: {
                                b = OreSpawnMain.MyPointysaurusSpawnBlock;
                                break;
                            }
                            case 3: {
                                b = OreSpawnMain.MyCricketSpawnBlock;
                                break;
                            }
                            case 4: {
                                b = OreSpawnMain.MyFrogSpawnBlock;
                                break;
                            }
                            case 5: {
                                b = OreSpawnMain.MySpiderDriverSpawnBlock;
                                break;
                            }
                            case 6: {
                                b = OreSpawnMain.MyCrabSpawnBlock;
                                break;
                            }
                        }
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            b,
                            OreSpawnMain.SpawnOres_stats.clumpsize);
                    } else {
                        final int j = random.nextInt(98);
                        Block b = Blocks.air;
                        switch (j) {
                            case 0: {
                                b = OreSpawnMain.MySpiderSpawnBlock;
                                break;
                            }
                            case 1: {
                                b = OreSpawnMain.MyBatSpawnBlock;
                                break;
                            }
                            case 2: {
                                b = OreSpawnMain.MyCowSpawnBlock;
                                break;
                            }
                            case 3: {
                                b = OreSpawnMain.MyPigSpawnBlock;
                                break;
                            }
                            case 4: {
                                b = OreSpawnMain.MySquidSpawnBlock;
                                break;
                            }
                            case 5: {
                                b = OreSpawnMain.MyChickenSpawnBlock;
                                break;
                            }
                            case 6: {
                                b = OreSpawnMain.MyCreeperSpawnBlock;
                                break;
                            }
                            case 7: {
                                b = OreSpawnMain.MySkeletonSpawnBlock;
                                break;
                            }
                            case 8: {
                                b = OreSpawnMain.MyZombieSpawnBlock;
                                break;
                            }
                            case 9: {
                                b = OreSpawnMain.MySlimeSpawnBlock;
                                break;
                            }
                            case 10: {
                                b = OreSpawnMain.MyGhastSpawnBlock;
                                break;
                            }
                            case 11: {
                                b = OreSpawnMain.MyZombiePigmanSpawnBlock;
                                break;
                            }
                            case 12: {
                                b = OreSpawnMain.MyEndermanSpawnBlock;
                                break;
                            }
                            case 13: {
                                b = OreSpawnMain.MyCaveSpiderSpawnBlock;
                                break;
                            }
                            case 14: {
                                b = OreSpawnMain.MySilverfishSpawnBlock;
                                break;
                            }
                            case 15: {
                                b = OreSpawnMain.MyMagmaCubeSpawnBlock;
                                break;
                            }
                            case 16: {
                                b = OreSpawnMain.MyWitchSpawnBlock;
                                break;
                            }
                            case 17: {
                                b = OreSpawnMain.MySheepSpawnBlock;
                                break;
                            }
                            case 18: {
                                b = OreSpawnMain.MyWolfSpawnBlock;
                                break;
                            }
                            case 19: {
                                b = OreSpawnMain.MyMooshroomSpawnBlock;
                                break;
                            }
                            case 20: {
                                b = OreSpawnMain.MyOcelotSpawnBlock;
                                break;
                            }
                            case 21: {
                                b = OreSpawnMain.MyBlazeSpawnBlock;
                                break;
                            }
                            case 22: {
                                b = OreSpawnMain.MyWitherSkeletonSpawnBlock;
                                break;
                            }
                            case 23: {
                                b = OreSpawnMain.MyEnderDragonSpawnBlock;
                                break;
                            }
                            case 24: {
                                b = OreSpawnMain.MySnowGolemSpawnBlock;
                                break;
                            }
                            case 25: {
                                b = OreSpawnMain.MyIronGolemSpawnBlock;
                                break;
                            }
                            case 26: {
                                b = OreSpawnMain.MyWitherBossSpawnBlock;
                                break;
                            }
                            case 27: {
                                b = OreSpawnMain.MyGirlfriendSpawnBlock;
                                break;
                            }
                            case 28: {
                                b = OreSpawnMain.MyRedCowSpawnBlock;
                                break;
                            }
                            case 29: {
                                b = OreSpawnMain.MyGoldCowSpawnBlock;
                                break;
                            }
                            case 30: {
                                b = OreSpawnMain.MyEnchantedCowSpawnBlock;
                                break;
                            }
                            case 31: {
                                b = OreSpawnMain.MyMOTHRASpawnBlock;
                                break;
                            }
                            case 32: {
                                b = OreSpawnMain.MyAloSpawnBlock;
                                break;
                            }
                            case 33: {
                                b = OreSpawnMain.MyCryoSpawnBlock;
                                break;
                            }
                            case 34: {
                                b = OreSpawnMain.MyCamaSpawnBlock;
                                break;
                            }
                            case 35: {
                                b = OreSpawnMain.MyVeloSpawnBlock;
                                break;
                            }
                            case 36: {
                                b = OreSpawnMain.MyHydroSpawnBlock;
                                break;
                            }
                            case 37: {
                                b = OreSpawnMain.MyBasilSpawnBlock;
                                break;
                            }
                            case 38: {
                                b = OreSpawnMain.MyDragonflySpawnBlock;
                                break;
                            }
                            case 39: {
                                b = OreSpawnMain.MyEmperorScorpionSpawnBlock;
                                break;
                            }
                            case 40: {
                                b = OreSpawnMain.MyScorpionSpawnBlock;
                                break;
                            }
                            case 41: {
                                b = OreSpawnMain.MyCaveFisherSpawnBlock;
                                break;
                            }
                            case 42: {
                                b = OreSpawnMain.MySpyroSpawnBlock;
                                break;
                            }
                            case 43: {
                                b = OreSpawnMain.MyBaryonyxSpawnBlock;
                                break;
                            }
                            case 44: {
                                b = OreSpawnMain.MyGammaMetroidSpawnBlock;
                                break;
                            }
                            case 45: {
                                b = OreSpawnMain.MyCockateilSpawnBlock;
                                break;
                            }
                            case 46: {
                                b = OreSpawnMain.MyKyuubiSpawnBlock;
                                break;
                            }
                            case 47: {
                                b = OreSpawnMain.MyAlienSpawnBlock;
                                break;
                            }
                            case 48: {
                                b = OreSpawnMain.MyAttackSquidSpawnBlock;
                                break;
                            }
                            case 49: {
                                b = OreSpawnMain.MyWaterDragonSpawnBlock;
                                break;
                            }
                            case 50: {
                                b = OreSpawnMain.MyKrakenSpawnBlock;
                                break;
                            }
                            case 51: {
                                b = OreSpawnMain.MyLizardSpawnBlock;
                                break;
                            }
                            case 52: {
                                b = OreSpawnMain.MyCephadromeSpawnBlock;
                                break;
                            }
                            case 53: {
                                b = OreSpawnMain.MyDragonSpawnBlock;
                                break;
                            }
                            case 54: {
                                b = OreSpawnMain.MyBeeSpawnBlock;
                                break;
                            }
                            case 55: {
                                b = OreSpawnMain.MyHorseSpawnBlock;
                                break;
                            }
                            case 56: {
                                b = OreSpawnMain.MyTrooperBugSpawnBlock;
                                break;
                            }
                            case 57: {
                                b = OreSpawnMain.MySpitBugSpawnBlock;
                                break;
                            }
                            case 58: {
                                b = OreSpawnMain.MyStinkBugSpawnBlock;
                                break;
                            }
                            case 59: {
                                b = OreSpawnMain.MyOstrichSpawnBlock;
                                break;
                            }
                            case 60: {
                                b = OreSpawnMain.MyGazelleSpawnBlock;
                                break;
                            }
                            case 61: {
                                b = OreSpawnMain.MyChipmunkSpawnBlock;
                                break;
                            }
                            case 62: {
                                b = OreSpawnMain.MyCreepingHorrorSpawnBlock;
                                break;
                            }
                            case 63: {
                                b = OreSpawnMain.MyTerribleTerrorSpawnBlock;
                                break;
                            }
                            case 64: {
                                b = OreSpawnMain.MyCliffRacerSpawnBlock;
                                break;
                            }
                            case 65: {
                                b = OreSpawnMain.MyTriffidSpawnBlock;
                                break;
                            }
                            case 66: {
                                b = OreSpawnMain.MyPitchBlackSpawnBlock;
                                break;
                            }
                            case 67: {
                                b = OreSpawnMain.MyLurkingTerrorSpawnBlock;
                                break;
                            }
                            case 68: {
                                b = OreSpawnMain.MyGodzillaPartSpawnBlock;
                                break;
                            }
                            case 69: {
                                b = OreSpawnMain.MyGodzillaSpawnBlock;
                                break;
                            }
                            case 70: {
                                b = OreSpawnMain.MySmallWormSpawnBlock;
                                break;
                            }
                            case 71: {
                                b = OreSpawnMain.MyMediumWormSpawnBlock;
                                break;
                            }
                            case 72: {
                                b = OreSpawnMain.MyLargeWormSpawnBlock;
                                break;
                            }
                            case 73: {
                                b = OreSpawnMain.MyCassowarySpawnBlock;
                                break;
                            }
                            case 74: {
                                b = OreSpawnMain.MyCloudSharkSpawnBlock;
                                break;
                            }
                            case 75: {
                                b = OreSpawnMain.MyGoldFishSpawnBlock;
                                break;
                            }
                            case 76: {
                                b = OreSpawnMain.MyLeafMonsterSpawnBlock;
                                break;
                            }
                            case 77: {
                                b = OreSpawnMain.MyTshirtSpawnBlock;
                                break;
                            }
                            case 78: {
                                b = OreSpawnMain.MyEnderKnightSpawnBlock;
                                break;
                            }
                            case 79: {
                                b = OreSpawnMain.MyEnderReaperSpawnBlock;
                                break;
                            }
                            case 80: {
                                b = OreSpawnMain.MyBeaverSpawnBlock;
                                break;
                            }
                            case 81: {
                                b = OreSpawnMain.MyTRexSpawnBlock;
                                break;
                            }
                            case 82: {
                                b = OreSpawnMain.MyHerculesSpawnBlock;
                                break;
                            }
                            case 83: {
                                b = OreSpawnMain.MyMantisSpawnBlock;
                                break;
                            }
                            case 84: {
                                b = OreSpawnMain.MyStinkySpawnBlock;
                                break;
                            }
                            case 85: {
                                b = OreSpawnMain.MyBoyfriendSpawnBlock;
                                break;
                            }
                            case 86: {
                                b = OreSpawnMain.MyTheKingPartSpawnBlock;
                                break;
                            }
                            case 87: {
                                b = OreSpawnMain.MyEasterBunnySpawnBlock;
                                break;
                            }
                            case 88: {
                                b = OreSpawnMain.MyCaterKillerSpawnBlock;
                                break;
                            }
                            case 89: {
                                b = OreSpawnMain.MyMolenoidSpawnBlock;
                                break;
                            }
                            case 90: {
                                b = OreSpawnMain.MySeaMonsterSpawnBlock;
                                break;
                            }
                            case 91: {
                                b = OreSpawnMain.MySeaViperSpawnBlock;
                                break;
                            }
                            case 92: {
                                b = OreSpawnMain.MyLeonSpawnBlock;
                                break;
                            }
                            case 93: {
                                b = OreSpawnMain.MyHammerheadSpawnBlock;
                                break;
                            }
                            case 94: {
                                b = OreSpawnMain.MyRubberDuckySpawnBlock;
                                break;
                            }
                            case 95: {
                                b = OreSpawnMain.MyVillagerSpawnBlock;
                                break;
                            }
                            case 96: {
                                b = OreSpawnMain.MyCriminalSpawnBlock;
                                break;
                            }
                            case 97: {
                                b = OreSpawnMain.MyTheQueenPartSpawnBlock;
                                break;
                            }
                        }
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            b,
                            OreSpawnMain.SpawnOres_stats.clumpsize);
                    }
                }
            }
        }
        if (OreSpawnMain.Uranium_stats.rate > 0) {
            int patchy = OreSpawnMain.Uranium_stats.rate + random.nextInt(9);
            if (OreSpawnMain.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= OreSpawnMain.Uranium_stats.maxdepth
                    && randPosY >= OreSpawnMain.Uranium_stats.mindepth) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        OreSpawnMain.MyOreUraniumBlock,
                        OreSpawnMain.Uranium_stats.clumpsize);
                }
            }
        }
        if (OreSpawnMain.Titanium_stats.rate > 0) {
            int patchy = OreSpawnMain.Titanium_stats.rate + random.nextInt(9);
            if (OreSpawnMain.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= OreSpawnMain.Titanium_stats.maxdepth
                    && randPosY >= OreSpawnMain.Titanium_stats.mindepth) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        OreSpawnMain.MyOreTitaniumBlock,
                        OreSpawnMain.Titanium_stats.clumpsize);
                }
            }
        }
        if (OreSpawnMain.Amethyst_stats.rate > 0) {
            int patchy = OreSpawnMain.Amethyst_stats.rate + random.nextInt(12);
            if (OreSpawnMain.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= OreSpawnMain.Amethyst_stats.maxdepth
                    && randPosY >= OreSpawnMain.Amethyst_stats.mindepth) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        OreSpawnMain.MyOreAmethystBlock,
                        OreSpawnMain.Amethyst_stats.clumpsize);
                }
            }
        }
        if (OreSpawnMain.Salt_stats.rate > 0) {
            int patchy = OreSpawnMain.Salt_stats.rate + random.nextInt(9);
            if (OreSpawnMain.LessOre != 0) {
                patchy /= 3;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= OreSpawnMain.Salt_stats.maxdepth && randPosY >= OreSpawnMain.Salt_stats.mindepth) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        OreSpawnMain.MyOreSaltBlock,
                        OreSpawnMain.Salt_stats.clumpsize);
                }
            }
        }
        int patchy = 4 + random.nextInt(4);
        if (OreSpawnMain.LessOre != 0) {
            patchy /= 2;
        }
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= 50 && randPosY >= 5) {
                this.generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.RedAntTroll, 4);
            }
        }
        patchy = 4 + random.nextInt(4);
        if (OreSpawnMain.LessOre != 0) {
            patchy /= 2;
        }
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= 50 && randPosY >= 5) {
                this.generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, OreSpawnMain.TermiteTroll, 4);
            }
        }
        if (OreSpawnMain.LessOre == 0) {
            if (OreSpawnMain.Diamond_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.Diamond_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.Diamond_stats.maxdepth
                        && randPosY >= OreSpawnMain.Diamond_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.diamond_ore,
                            OreSpawnMain.Diamond_stats.clumpsize);
                    }
                }
            }
            if (OreSpawnMain.BlkDiamond_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.BlkDiamond_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.BlkDiamond_stats.maxdepth
                        && randPosY >= OreSpawnMain.BlkDiamond_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.diamond_block,
                            OreSpawnMain.BlkDiamond_stats.clumpsize);
                    }
                }
            }
            if (OreSpawnMain.Emerald_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.Emerald_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.Emerald_stats.maxdepth
                        && randPosY >= OreSpawnMain.Emerald_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.emerald_ore,
                            OreSpawnMain.Emerald_stats.clumpsize);
                    }
                }
            }
            if (OreSpawnMain.BlkEmerald_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.BlkEmerald_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.BlkEmerald_stats.maxdepth
                        && randPosY >= OreSpawnMain.BlkEmerald_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.emerald_block,
                            OreSpawnMain.BlkEmerald_stats.clumpsize);
                    }
                }
            }
            if (OreSpawnMain.Gold_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.Gold_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.Gold_stats.maxdepth && randPosY >= OreSpawnMain.Gold_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.gold_ore,
                            OreSpawnMain.Gold_stats.clumpsize);
                    }
                }
            }
            if (OreSpawnMain.BlkGold_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.BlkGold_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.BlkGold_stats.maxdepth
                        && randPosY >= OreSpawnMain.BlkGold_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.gold_block,
                            OreSpawnMain.BlkGold_stats.clumpsize);
                    }
                }
            }
            if (OreSpawnMain.BlkRuby_stats.rate > 0) {
                for (int i = 0; i < OreSpawnMain.BlkRuby_stats.rate; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= OreSpawnMain.BlkRuby_stats.maxdepth
                        && randPosY >= OreSpawnMain.BlkRuby_stats.mindepth) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            OreSpawnMain.MyBlockRubyBlock,
                            OreSpawnMain.BlkRuby_stats.clumpsize);
                    }
                }
            }
        }
    }

    public boolean generateBlockOre(final World par1World, final Random par2Random, final int par3, final int par4,
        final int par5, final Chunk chunk, final Block newbid, final int numberOfBlocks) {
        final float f = par2Random.nextFloat() * 3.1415927f;
        final double d0 = par3 + 8 + MathHelper.sin(f) * numberOfBlocks / 8.0f;
        final double d2 = par3 + 8 - MathHelper.sin(f) * numberOfBlocks / 8.0f;
        final double d3 = par5 + 8 + MathHelper.cos(f) * numberOfBlocks / 8.0f;
        final double d4 = par5 + 8 - MathHelper.cos(f) * numberOfBlocks / 8.0f;
        final double d5 = par4 + par2Random.nextInt(3) - 2;
        final double d6 = par4 + par2Random.nextInt(3) - 2;
        for (int l = 0; l <= numberOfBlocks; ++l) {
            final double d7 = d0 + (d2 - d0) * l / numberOfBlocks;
            final double d8 = d5 + (d6 - d5) * l / numberOfBlocks;
            final double d9 = d3 + (d4 - d3) * l / numberOfBlocks;
            final double d10 = par2Random.nextDouble() * numberOfBlocks / 16.0;
            final double d11 = (MathHelper.sin(l * 3.1415927f / numberOfBlocks) + 1.0f) * d10 + 1.0;
            final double d12 = (MathHelper.sin(l * 3.1415927f / numberOfBlocks) + 1.0f) * d10 + 1.0;
            final int i1 = MathHelper.floor_double(d7 - d11 / 2.0);
            final int j1 = MathHelper.floor_double(d8 - d12 / 2.0);
            final int k1 = MathHelper.floor_double(d9 - d11 / 2.0);
            final int l2 = MathHelper.floor_double(d7 + d11 / 2.0);
            final int i2 = MathHelper.floor_double(d8 + d12 / 2.0);
            final int j2 = MathHelper.floor_double(d9 + d11 / 2.0);
            for (int k2 = i1; k2 <= l2; ++k2) {
                final double d13 = (k2 + 0.5 - d7) / (d11 / 2.0);
                if (d13 * d13 < 1.0) {
                    for (int l3 = j1; l3 <= i2; ++l3) {
                        final double d14 = (l3 + 0.5 - d8) / (d12 / 2.0);
                        if (d13 * d13 + d14 * d14 < 1.0) {
                            for (int i3 = k1; i3 <= j2; ++i3) {
                                final double d15 = (i3 + 0.5 - d9) / (d11 / 2.0);
                                final Block bid = OreSpawnMain.getBlockIDInChunk(chunk, k2, l3, i3);
                                if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0 && bid == Blocks.stone) {
                                    OreSpawnMain.setBlockIDWithMetadataInChunk(chunk, k2, l3, i3, newbid, 0);
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
