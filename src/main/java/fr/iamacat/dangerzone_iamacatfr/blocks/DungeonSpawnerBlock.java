
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class DungeonSpawnerBlock extends BlockReed {

    public DungeonSpawnerBlock() {
        final float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.getBlock(par2, par3 - 1, par4)
            .getMaterial()
            .isSolid();
    }

    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        for (int j1 = 0; j1 < 5; ++j1) {
            par1World.spawnParticle(
                "fireworksSpark",
                (par2 + par1World.rand.nextFloat()),
                par3 + par1World.rand.nextFloat(),
                (par4 + par1World.rand.nextFloat()),
                (par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0,
                par1World.rand.nextFloat() / 2.0,
                (par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0);
        }
    }

    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        if (world.isRemote) {
            return;
        }
        world.scheduleBlockUpdate(x, y, z, (Block) this, 400);
    }

    public void onBlockDestroyedByPlayer(final World par1World, final int par2, final int par3, final int par4,
        final int par5) {
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    public void updateTick(final World world, final int clickedX, final int clickedY, final int clickedZ,
        final Random par5Random) {
        if (world.isRemote) {
            return;
        }
        world.setBlock(clickedX, clickedY, clickedZ, Blocks.air, 0, 2);
        world.setBlock(clickedX, clickedY + 1, clickedZ, Blocks.air, 0, 2);
        final int type = world.rand.nextInt(50);
        if (type == 0) {
            DangerZone.OreSpawnTrees.FairyTree(world, clickedX, clickedY, clickedZ);
        }
        if (type == 1) {
            DangerZone.OreSpawnTrees.FairyCastleTree(world, clickedX, clickedY, clickedZ);
        }
        if (type == 2) {
            DangerZone.MyDungeon.makeEnormousCastle(world, clickedX, clickedY, clickedZ);
        }
        if (type == 3) {
            DangerZone.MyDungeon.makeRotatorStation(world, clickedX, clickedY, clickedZ);
        }
        if (type == 4) {
            DangerZone.MyDungeon.makeBeeHive(world, clickedX, clickedY, clickedZ);
        }
        if (type == 5) {
            DangerZone.MyDungeon.makeHauntedHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 6) {
            DangerZone.MyDungeon.makeMantisHive(world, clickedX, clickedY, clickedZ);
        }
        if (type == 7) {
            DangerZone.MyDungeon.makeKyuubiDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 8) {
            DangerZone.MyDungeon.makeSmallBeeHive(world, clickedX, clickedY, clickedZ);
        }
        if (type == 9) {
            DangerZone.MyDungeon.makeShadowDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 10) {
            DangerZone.MyDungeon.makeAlienWTFDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 11) {
            DangerZone.MyDungeon.makeEnderKnightDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 12) {
            DangerZone.MyDungeon.makePlayPool(world, clickedX, clickedY, clickedZ);
        }
        if (type == 13) {
            DangerZone.MyDungeon.makeWaterDragonLair(world, clickedX, clickedY, clickedZ);
        }
        if (type == 14) {
            DangerZone.MyDungeon.makeCloudSharkDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 15) {
            DangerZone.MyDungeon.makeLeafMonsterDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 16) {
            DangerZone.MyDungeon.makeMiniDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 17) {
            DangerZone.MyDungeon.makeGoldFishBowl(world, clickedX, clickedY, clickedZ);
        }
        if (type == 18) {
            DangerZone.MyDungeon.makeEnderReaperGraveyard(world, clickedX, clickedY, clickedZ);
        }
        if (type == 19) {
            DangerZone.MyDungeon.makeSpitBugLair(world, clickedX, clickedY, clickedZ);
        }
        if (type == 20) {
            DangerZone.MyDungeon.makeIgloo(world, clickedX, clickedY, clickedZ);
        }
        if (type == 21) {
            DangerZone.MyDungeon.makeDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 22) {
            DangerZone.RubyDungeon.makeDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 23) {
            DangerZone.BMaze.buildBasiliskMaze(world, clickedX, clickedY, clickedZ);
        }
        if (type == 24) {
            DangerZone.MyDungeon.makeEnderDragonHospital(world, clickedX, clickedY, clickedZ);
        }
        if (type == 25) {
            DangerZone.MyDungeon.makeCrystalHauntedHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 26) {
            DangerZone.MyDungeon.makeBouncyCastle(world, clickedX, clickedY, clickedZ);
        }
        if (type == 27) {
            DangerZone.MyDungeon.makeEnderCastle(world, clickedX, clickedY, clickedZ);
        }
        if (type == 28) {
            DangerZone.MyDungeon.makeDamselInDistress(world, clickedX, clickedY, clickedZ);
        }
        if (type == 29) {
            DangerZone.MyDungeon.makeIncaPyramid(world, clickedX, clickedY, clickedZ);
        }
        if (type == 30) {
            DangerZone.MyDungeon.makeRobotLab(world, clickedX, clickedY, clickedZ);
        }
        if (type == 31) {
            DangerZone.MyDungeon.makeKingAltar(world, clickedX, clickedY, clickedZ);
        }
        if (type == 32) {
            DangerZone.MyDungeon.makeLeonNest(world, clickedX, clickedY, clickedZ);
        }
        if (type == 33) {
            DangerZone.MyDungeon.makeCrystalBattleTower(world, clickedX, clickedY, clickedZ);
        }
        if (type == 34) {
            DangerZone.MyDungeon.makeCephadromeAltar(world, clickedX, clickedY, clickedZ);
        }
        if (type == 35) {
            DangerZone.MyDungeon.makeGirlfriendIsland(world, clickedX, clickedY, clickedZ);
        }
        if (type == 36) {
            DangerZone.MyDungeon.makeGreenhouseDungeon(world, clickedX, clickedY, clickedZ);
        }
        if (type == 37) {
            DangerZone.MyDungeon.makeMonsterIsland(world, clickedX, clickedY, clickedZ);
        }
        if (type == 38) {
            DangerZone.MyDungeon.makeNightmareRookery(world, clickedX, clickedY, clickedZ);
        }
        if (type == 39) {
            DangerZone.MyDungeon.makeStinkyHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 40) {
            DangerZone.MyDungeon.makeRubberDuckyPond(world, clickedX, clickedY, clickedZ);
        }
        if (type == 41) {
            DangerZone.MyDungeon.makeWhiteHouse(world, clickedX, clickedY, clickedZ);
        }
        if (type == 42) {
            DangerZone.MyDungeon.makeQueenAltar(world, clickedX, clickedY, clickedZ);
        }
        if (type == 43) {
            DangerZone.MyDungeon.makeFrogPond(world, clickedX, clickedY + 1, clickedZ);
        }
        if (type == 44) {
            DangerZone.MyDungeon.makePumpkin(world, clickedX, clickedY + 1, clickedZ);
        }
        if (type == 45) {
            DangerZone.MyDungeon.makeRoundRotator(world, clickedX, clickedY + 1, clickedZ);
        }
        if (type == 46) {
            DangerZone.MyDungeon.makeRainbow(world, clickedX, clickedY, clickedZ);
        }
        if (type == 47) {
            DangerZone.MyDungeon.makeEnormousCastleQ(world, clickedX, clickedY, clickedZ);
        }
        if (type == 48) {
            DangerZone.MyDungeon.makeSpiderHangout(world, clickedX, clickedY, clickedZ);
        }
        if (type == 49) {
            DangerZone.MyDungeon.makeRedAntHangout(world, clickedX, clickedY, clickedZ);
        }
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(final World p_149694_1_, final int p_149694_2_, final int p_149694_3_, final int p_149694_4_) {
        return ItemInitDangerZone.RandomDungeon;
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return ItemInitDangerZone.RandomDungeon;
    }

    public int quantityDropped(final Random par1Random) {
        return 1;
    }

    public boolean canBlockStay(final World par1World, final int par2, final int par3, final int par4) {
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
