
package fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

import java.util.Random;

public class ChunkOreGenerator {

    public void generateOresInChunk(final World world, final Random random, final int chunkX, final int chunkZ,
        final Chunk chunk) {
        if(38f/100f > 0) {
            int patchy = 38 + random.nextInt(30);
            if (random.nextInt(20) == 0) {
                patchy += 30;
            }
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= 128
                    && randPosY >= 50) {
                    if (random.nextInt(104) < 7) {
                        final int j = random.nextInt(7);
                        Block b = Blocks.air;
                        switch (j) {
                            case 0: {
                                b = BlockInitDangerZone.MyBrutalflySpawnBlock;
                                break;
                            }
                            case 1: {
                                b = BlockInitDangerZone.MyNastysaurusSpawnBlock;
                                break;
                            }
                            case 2: {
                                b = BlockInitDangerZone.MyPointysaurusSpawnBlock;
                                break;
                            }
                            case 3: {
                                b = BlockInitDangerZone.MyCricketSpawnBlock;
                                break;
                            }
                            case 4: {
                                b = BlockInitDangerZone.MyFrogSpawnBlock;
                                break;
                            }
                            case 5: {
                                b = BlockInitDangerZone.MySpiderDriverSpawnBlock;
                                break;
                            }
                            case 6: {
                                b = BlockInitDangerZone.MyCrabSpawnBlock;
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
                            4);
                    } else {
                        final int j = random.nextInt(98);
                        Block b = Blocks.air;
                        switch (j) {
                            case 0: {
                                b = BlockInitDangerZone.MySpiderSpawnBlock;
                                break;
                            }
                            case 1: {
                                b = BlockInitDangerZone.MyBatSpawnBlock;
                                break;
                            }
                            case 2: {
                                b = BlockInitDangerZone.MyCowSpawnBlock;
                                break;
                            }
                            case 3: {
                                b = BlockInitDangerZone.MyPigSpawnBlock;
                                break;
                            }
                            case 4: {
                                b = BlockInitDangerZone.MySquidSpawnBlock;
                                break;
                            }
                            case 5: {
                                b = BlockInitDangerZone.MyChickenSpawnBlock;
                                break;
                            }
                            case 6: {
                                b = BlockInitDangerZone.MyCreeperSpawnBlock;
                                break;
                            }
                            case 7: {
                                b = BlockInitDangerZone.MySkeletonSpawnBlock;
                                break;
                            }
                            case 8: {
                                b = BlockInitDangerZone.MyZombieSpawnBlock;
                                break;
                            }
                            case 9: {
                                b = BlockInitDangerZone.MySlimeSpawnBlock;
                                break;
                            }
                            case 10: {
                                b = BlockInitDangerZone.MyGhastSpawnBlock;
                                break;
                            }
                            case 11: {
                                b = BlockInitDangerZone.MyZombiePigmanSpawnBlock;
                                break;
                            }
                            case 12: {
                                b = BlockInitDangerZone.MyEndermanSpawnBlock;
                                break;
                            }
                            case 13: {
                                b = BlockInitDangerZone.MyCaveSpiderSpawnBlock;
                                break;
                            }
                            case 14: {
                                b = BlockInitDangerZone.MySilverfishSpawnBlock;
                                break;
                            }
                            case 15: {
                                b = BlockInitDangerZone.MyMagmaCubeSpawnBlock;
                                break;
                            }
                            case 16: {
                                b = BlockInitDangerZone.MyWitchSpawnBlock;
                                break;
                            }
                            case 17: {
                                b = BlockInitDangerZone.MySheepSpawnBlock;
                                break;
                            }
                            case 18: {
                                b = BlockInitDangerZone.MyWolfSpawnBlock;
                                break;
                            }
                            case 19: {
                                b = BlockInitDangerZone.MyMooshroomSpawnBlock;
                                break;
                            }
                            case 20: {
                                b = BlockInitDangerZone.MyOcelotSpawnBlock;
                                break;
                            }
                            case 21: {
                                b = BlockInitDangerZone.MyBlazeSpawnBlock;
                                break;
                            }
                            case 22: {
                                b = BlockInitDangerZone.MyWitherSkeletonSpawnBlock;
                                break;
                            }
                            case 23: {
                                b = BlockInitDangerZone.MyEnderDragonSpawnBlock;
                                break;
                            }
                            case 24: {
                                b = BlockInitDangerZone.MySnowGolemSpawnBlock;
                                break;
                            }
                            case 25: {
                                b = BlockInitDangerZone.MyIronGolemSpawnBlock;
                                break;
                            }
                            case 26: {
                                b = BlockInitDangerZone.MyWitherBossSpawnBlock;
                                break;
                            }
                            case 27: {
                                b = BlockInitDangerZone.MyGirlfriendSpawnBlock;
                                break;
                            }
                            case 28: {
                                b = BlockInitDangerZone.MyRedCowSpawnBlock;
                                break;
                            }
                            case 29: {
                                b = BlockInitDangerZone.MyGoldCowSpawnBlock;
                                break;
                            }
                            case 30: {
                                b = BlockInitDangerZone.MyEnchantedCowSpawnBlock;
                                break;
                            }
                            case 31: {
                                b = BlockInitDangerZone.MyMOTHRASpawnBlock;
                                break;
                            }
                            case 32: {
                                b = BlockInitDangerZone.MyAloSpawnBlock;
                                break;
                            }
                            case 33: {
                                b = BlockInitDangerZone.MyCryoSpawnBlock;
                                break;
                            }
                            case 34: {
                                b = BlockInitDangerZone.MyCamaSpawnBlock;
                                break;
                            }
                            case 35: {
                                b = BlockInitDangerZone.MyVeloSpawnBlock;
                                break;
                            }
                            case 36: {
                                b = BlockInitDangerZone.MyHydroSpawnBlock;
                                break;
                            }
                            case 37: {
                                b = BlockInitDangerZone.MyBasilSpawnBlock;
                                break;
                            }
                            case 38: {
                                b = BlockInitDangerZone.MyDragonflySpawnBlock;
                                break;
                            }
                            case 39: {
                                b = BlockInitDangerZone.MyEmperorScorpionSpawnBlock;
                                break;
                            }
                            case 40: {
                                b = BlockInitDangerZone.MyScorpionSpawnBlock;
                                break;
                            }
                            case 41: {
                                b = BlockInitDangerZone.MyCaveFisherSpawnBlock;
                                break;
                            }
                            case 42: {
                                b = BlockInitDangerZone.MySpyroSpawnBlock;
                                break;
                            }
                            case 43: {
                                b = BlockInitDangerZone.MyBaryonyxSpawnBlock;
                                break;
                            }
                            case 44: {
                                b = BlockInitDangerZone.MyGammaMetroidSpawnBlock;
                                break;
                            }
                            case 45: {
                                b = BlockInitDangerZone.MyCockateilSpawnBlock;
                                break;
                            }
                            case 46: {
                                b = BlockInitDangerZone.MyKyuubiSpawnBlock;
                                break;
                            }
                            case 47: {
                                b = BlockInitDangerZone.MyAlienSpawnBlock;
                                break;
                            }
                            case 48: {
                                b = BlockInitDangerZone.MyAttackSquidSpawnBlock;
                                break;
                            }
                            case 49: {
                                b = BlockInitDangerZone.MyWaterDragonSpawnBlock;
                                break;
                            }
                            case 50: {
                                b = BlockInitDangerZone.MyKrakenSpawnBlock;
                                break;
                            }
                            case 51: {
                                b = BlockInitDangerZone.MyLizardSpawnBlock;
                                break;
                            }
                            case 52: {
                                b = BlockInitDangerZone.MyCephadromeSpawnBlock;
                                break;
                            }
                            case 53: {
                                b = BlockInitDangerZone.MyDragonSpawnBlock;
                                break;
                            }
                            case 54: {
                                b = BlockInitDangerZone.MyBeeSpawnBlock;
                                break;
                            }
                            case 55: {
                                b = BlockInitDangerZone.MyHorseSpawnBlock;
                                break;
                            }
                            case 56: {
                                b = BlockInitDangerZone.MyTrooperBugSpawnBlock;
                                break;
                            }
                            case 57: {
                                b = BlockInitDangerZone.MySpitBugSpawnBlock;
                                break;
                            }
                            case 58: {
                                b = BlockInitDangerZone.MyStinkBugSpawnBlock;
                                break;
                            }
                            case 59: {
                                b = BlockInitDangerZone.MyOstrichSpawnBlock;
                                break;
                            }
                            case 60: {
                                b = BlockInitDangerZone.MyGazelleSpawnBlock;
                                break;
                            }
                            case 61: {
                                b = BlockInitDangerZone.MyChipmunkSpawnBlock;
                                break;
                            }
                            case 62: {
                                b = BlockInitDangerZone.MyCreepingHorrorSpawnBlock;
                                break;
                            }
                            case 63: {
                                b = BlockInitDangerZone.MyTerribleTerrorSpawnBlock;
                                break;
                            }
                            case 64: {
                                b = BlockInitDangerZone.MyCliffRacerSpawnBlock;
                                break;
                            }
                            case 65: {
                                b = BlockInitDangerZone.MyTriffidSpawnBlock;
                                break;
                            }
                            case 66: {
                                b = BlockInitDangerZone.MyPitchBlackSpawnBlock;
                                break;
                            }
                            case 67: {
                                b = BlockInitDangerZone.MyLurkingTerrorSpawnBlock;
                                break;
                            }
                            case 68: {
                                b = BlockInitDangerZone.MyGodzillaPartSpawnBlock;
                                break;
                            }
                            case 69: {
                                b = BlockInitDangerZone.MyGodzillaSpawnBlock;
                                break;
                            }
                            case 70: {
                                b = BlockInitDangerZone.MySmallWormSpawnBlock;
                                break;
                            }
                            case 71: {
                                b = BlockInitDangerZone.MyMediumWormSpawnBlock;
                                break;
                            }
                            case 72: {
                                b = BlockInitDangerZone.MyLargeWormSpawnBlock;
                                break;
                            }
                            case 73: {
                                b = BlockInitDangerZone.MyCassowarySpawnBlock;
                                break;
                            }
                            case 74: {
                                b = BlockInitDangerZone.MyCloudSharkSpawnBlock;
                                break;
                            }
                            case 75: {
                                b = BlockInitDangerZone.MyGoldFishSpawnBlock;
                                break;
                            }
                            case 76: {
                                b = BlockInitDangerZone.MyLeafMonsterSpawnBlock;
                                break;
                            }
                            case 77: {
                                b = BlockInitDangerZone.MyTshirtSpawnBlock;
                                break;
                            }
                            case 78: {
                                b = BlockInitDangerZone.MyEnderKnightSpawnBlock;
                                break;
                            }
                            case 79: {
                                b = BlockInitDangerZone.MyEnderReaperSpawnBlock;
                                break;
                            }
                            case 80: {
                                b = BlockInitDangerZone.MyBeaverSpawnBlock;
                                break;
                            }
                            case 81: {
                                b = BlockInitDangerZone.MyTRexSpawnBlock;
                                break;
                            }
                            case 82: {
                                b = BlockInitDangerZone.MyHerculesSpawnBlock;
                                break;
                            }
                            case 83: {
                                b = BlockInitDangerZone.MyMantisSpawnBlock;
                                break;
                            }
                            case 84: {
                                b = BlockInitDangerZone.MyStinkySpawnBlock;
                                break;
                            }
                            case 85: {
                                b = BlockInitDangerZone.MyBoyfriendSpawnBlock;
                                break;
                            }
                            case 86: {
                                b = BlockInitDangerZone.MyTheKingPartSpawnBlock;
                                break;
                            }
                            case 87: {
                                b = BlockInitDangerZone.MyEasterBunnySpawnBlock;
                                break;
                            }
                            case 88: {
                                b = BlockInitDangerZone.MyCaterKillerSpawnBlock;
                                break;
                            }
                            case 89: {
                                b = BlockInitDangerZone.MyMolenoidSpawnBlock;
                                break;
                            }
                            case 90: {
                                b = BlockInitDangerZone.MySeaMonsterSpawnBlock;
                                break;
                            }
                            case 91: {
                                b = BlockInitDangerZone.MySeaViperSpawnBlock;
                                break;
                            }
                            case 92: {
                                b = BlockInitDangerZone.MyLeonSpawnBlock;
                                break;
                            }
                            case 93: {
                                b = BlockInitDangerZone.MyHammerheadSpawnBlock;
                                break;
                            }
                            case 94: {
                                b = BlockInitDangerZone.MyRubberDuckySpawnBlock;
                                break;
                            }
                            case 95: {
                                b = BlockInitDangerZone.MyVillagerSpawnBlock;
                                break;
                            }
                            case 96: {
                                b = BlockInitDangerZone.MyCriminalSpawnBlock;
                                break;
                            }
                            case 97: {
                                b = BlockInitDangerZone.MyTheQueenPartSpawnBlock;
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
                            4);
                    }
                }
            }
        }
        if (3 > 0) {
            int patchy = 3 + random.nextInt(9);
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= 30 && randPosY >=0) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        BlockInitDangerZone.UraniumBlockOre,
                        4);
                }
            }
        }
        if (3 > 0) {
            int patchy =3 + random.nextInt(9);
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= 20 && randPosY >=0) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        BlockInitDangerZone.TitaniumBlockOre,
                       4);
                }
            }
        }
        if (2 > 0) {
            int patchy = 2 + random.nextInt(12);
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= 25 && randPosY >= 0) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        BlockInitDangerZone.AmethystBlock,
                       6);
                }
            }
        }
        if (5 > 0) {
            int patchy = 5 + random.nextInt(9);
            for (int i = 0; i < patchy; ++i) {
                final int randPosX = 3 + chunkX + random.nextInt(10);
                final int randPosY = random.nextInt(128);
                final int randPosZ = 3 + chunkZ + random.nextInt(10);
                if (randPosY <= 128 && randPosY >= 50) {
                    this.generateBlockOre(
                        world,
                        random,
                        randPosX,
                        randPosY,
                        randPosZ,
                        chunk,
                        BlockInitDangerZone.OreSalt,
                        12);
                }
            }
        }
        int patchy = 4 + random.nextInt(4);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= 50 && randPosY >= 5) {
                this.generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, BlockInitDangerZone.TrollBlock1, 4);
            }
        }
        patchy = 4 + random.nextInt(4);
        for (int i = 0; i < patchy; ++i) {
            final int randPosX = 3 + chunkX + random.nextInt(10);
            final int randPosY = random.nextInt(128);
            final int randPosZ = 3 + chunkZ + random.nextInt(10);
            if (randPosY <= 50 && randPosY >= 5) {
                this.generateBlockOre(world, random, randPosX, randPosY, randPosZ, chunk, BlockInitDangerZone.TermiteTroll, 4);
            }
        }
            if (4 > 0) {
                for (int i = 0; i < 4; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 30
                        && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.diamond_ore,
                            6);
                    }
                }
            if (2 > 0) {
                for (int i = 0; i < 2; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 20
                        && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.diamond_block,
                            4);
                    }
                }
            }
            if (4 > 0) {
                for (int i = 0; i < 4; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 40
                        && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.emerald_ore,
                            6);
                    }
                }
            }
            if (2 > 0) {
                for (int i = 0; i < 2; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 20
                        && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.emerald_block,
                           4);
                    }
                }
            }
            if (4 > 0) {
                for (int i = 0; i < 4; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 40 && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.gold_ore,
                            8);
                    }
                }
            }
            if (2 > 0) {
                for (int i = 0; i < 2; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 25
                        && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            Blocks.gold_block,
                            4);
                    }
                }
            }
            if (1 > 0) {
                for (int i = 0; i < 1; ++i) {
                    final int randPosX = 3 + chunkX + random.nextInt(10);
                    final int randPosY = random.nextInt(128);
                    final int randPosZ = 3 + chunkZ + random.nextInt(10);
                    if (randPosY <= 15
                        && randPosY >= 0) {
                        this.generateBlockOre(
                            world,
                            random,
                            randPosX,
                            randPosY,
                            randPosZ,
                            chunk,
                            BlockInitDangerZone.RubyBlock,
                            2);
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
                                final Block bid = DangerZone.getBlockIDInChunk(chunk, k2, l3, i3);
                                if (d13 * d13 + d14 * d14 + d15 * d15 < 1.0 && bid == Blocks.stone) {
                                    DangerZone.setBlockIDWithMetadataInChunk(chunk, k2, l3, i3, newbid, 0);
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
