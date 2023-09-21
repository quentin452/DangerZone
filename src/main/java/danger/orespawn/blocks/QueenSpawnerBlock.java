
package danger.orespawn.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.entities.entityinstance.TheQueen;

public class QueenSpawnerBlock extends BlockReed {

    public QueenSpawnerBlock(final int par1) {
        final float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.getBlock(par2, par3 - 1, par4)
            .getMaterial()
            .isSolid();
    }

    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (!par1World.isRemote) {
            this.updateTick(par1World, par2, par3, par4, par5Random);
            return;
        }
        if (par1World.rand.nextInt(20) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 20; ++j1) {
            par1World.spawnParticle(
                "fireworksSpark",
                (par2 + par1World.rand.nextFloat()),
                par3 + par1World.rand.nextFloat(),
                (par4 + par1World.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
        }
    }

    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        if (world.isRemote) {
            return;
        }
        world.scheduleBlockUpdate(x, y, z, (Block) this, 100);
    }

    public void onBlockDestroyedByPlayer(final World par1World, final int par2, final int par3, final int par4,
        final int par5) {
        this.updateTick(par1World, par2, par3, par4, null);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.isRemote) {
            return;
        }
        if (OreSpawnMain.TheQueenEnable != 0) {
            spawnTheQueen(par1World, par2, par3 + 8, par4);
        }
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        par1World.setBlock(par2, par3 + 1, par4, Blocks.air, 0, 2);
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Item.getItemFromBlock(OreSpawnMain.MyQueenSpawnerBlock);
    }

    public int quantityDropped(final Random par1Random) {
        return 1;
    }

    public static Entity spawnTheQueen(final World par0World, final double par2, final double par4, final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName("The Queen", par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
            ((TheQueen) var8).setGuardMode(1);
        }
        return var8;
    }

    public boolean canBlockStay(final World par1World, final int par2, final int par3, final int par4) {
        this.updateTick(par1World, par2, par3, par4, null);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
