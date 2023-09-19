
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class BlockLettuce extends BlockReed {

    public BlockLettuce(final int par1) {
        final float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        final Block bid = par1World.getBlock(par2, par3 - 1, par4);
        return bid != Blocks.air
            && (bid == BlockInitDangerZone.BlockLettuce1 || bid == BlockInitDangerZone.BlockLettuce2
                || bid == BlockInitDangerZone.BlockLettuce3
                || bid == BlockInitDangerZone.BlockLettuce4
                || bid == Blocks.grass
                || bid == Blocks.dirt
                || bid == Blocks.farmland);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        final int dontGrow = 0;
        if (par1World.isRemote) {
            return;
        }
        int var7 = par1World.getBlockMetadata(par2, par3, par4);
        var7 &= 0xFF;
        if (var7 >= 4) {
            final Block bid = par1World.getBlock(par2, par3, par4);
            if (bid == BlockInitDangerZone.BlockLettuce1) {
                par1World.setBlock(par2, par3, par4, BlockInitDangerZone.BlockLettuce2, 0, 2);
            } else if (bid == BlockInitDangerZone.BlockLettuce2) {
                par1World.setBlock(par2, par3, par4, BlockInitDangerZone.BlockLettuce3, 0, 2);
            } else if (bid == BlockInitDangerZone.BlockLettuce3) {
                par1World.setBlock(par2, par3, par4, BlockInitDangerZone.BlockLettuce4, 0, 2);
            }
        } else {
            final Block bid = par1World.getBlock(par2, par3, par4);
            par1World.setBlock(par2, par3, par4, bid, var7 + 1, 2);
        }
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return ItemInitDangerZone.Lettuce;
    }

    public int quantityDropped(final Random par1Random) {
        if (this == BlockInitDangerZone.BlockLettuce1) {
            return 2 + par1Random.nextInt(3);
        }
        return 0;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
