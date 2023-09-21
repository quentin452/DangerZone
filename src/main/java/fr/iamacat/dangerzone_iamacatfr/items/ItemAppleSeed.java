
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public class ItemAppleSeed extends Item {

    public ItemAppleSeed() {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world,
        final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        if (!world.isRemote) {
            final Block bid = world.getBlock(x, y, z);
            if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
                return false;
            }
            if (this == ItemInitDangerZone.ItemAppleSeed) {
                this.makeTree(world, x, y, z, BlockInitDangerZone.BlockAppleLeaves, null);
            } else if (this == ItemInitDangerZone.MyCherrySeed) {
                this.makeTree(world, x, y, z, BlockInitDangerZone.BlockScaryLeaves, null);
            } else {
                this.makeTree(world, x, y, z, BlockInitDangerZone.MyPeachLeaves, null);
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public void makeTree(final World world, final int x, final int y, final int z, final Block blkid,
        final Chunk chunk) {
        Block bid = world.getBlock(x, y, z);
        if (bid != Blocks.grass && bid != Blocks.dirt && bid != Blocks.farmland) {
            return;
        }
        int h1 = 12;
        int h2 = 6;
        int h3 = 9;
        int h4 = 6;
        int h5 = 14;
        int w1 = 5;
        int w2 = 3;
        if (blkid == BlockInitDangerZone.BlockScaryLeaves) {
            h1 = 10;
            h2 = 5;
            h3 = 7;
            h4 = 5;
            h5 = 12;
            w1 = 4;
            w2 = 2;
        }
        if (blkid == BlockInitDangerZone.MyPeachLeaves) {
            h1 = 8;
            h2 = 3;
            h3 = 5;
            h4 = 3;
            h5 = 10;
            w1 = 3;
            w2 = 1;
        }
        for (int j = 1; j < h1; ++j) {
            world.setBlock(x, y + j, z, Blocks.log, 0, 2);
        }
        for (int j = 1; j < w1; ++j) {
            DangerZone.setBlockSuperFast(world, x + j, y + h2, z, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w1; ++j) {
            DangerZone.setBlockSuperFast(world, x - j, y + h2, z, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w1; ++j) {
            DangerZone.setBlockSuperFast(world, x, y + h2, z + j, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w1; ++j) {
            DangerZone.setBlockSuperFast(world, x, y + h2, z - j, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            DangerZone.setBlockSuperFast(world, x + j, y + h3, z, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            DangerZone.setBlockSuperFast(world, x - j, y + h3, z, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            DangerZone.setBlockSuperFast(world, x, y + h3, z + j, Blocks.log, 0, 2, chunk);
        }
        for (int j = 1; j < w2; ++j) {
            DangerZone.setBlockSuperFast(world, x, y + h3, z - j, Blocks.log, 0, 2, chunk);
        }
        for (int i = h4; i < h5; ++i) {
            int width = 6;
            if (i > 8) {
                width = 5;
            }
            if (i > 10) {
                width = 4;
            }
            if (blkid != BlockInitDangerZone.BlockAppleLeaves) {
                --width;
            }
            for (int j = -width; j <= width; ++j) {
                for (int k = -width; k <= width; ++k) {
                    bid = world.getBlock(x + k, y + i, z + j);
                    if (bid == Blocks.air) {
                        DangerZone.setBlockSuperFast(world, x + k, y + i, z + j, blkid, 0, 2, chunk);
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
