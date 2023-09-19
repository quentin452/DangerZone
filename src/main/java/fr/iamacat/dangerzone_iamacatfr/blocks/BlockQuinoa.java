
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

public class BlockQuinoa extends BlockReed {

    private int myMaxHeight;

    public BlockQuinoa(final int par1) {
        this.myMaxHeight = 0;
        final float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        final Block bid = par1World.getBlock(par2, par3 - 1, par4);
        return bid != Blocks.air && (bid == BlockInitDangerZone.BlockQuinoa1 || bid == BlockInitDangerZone.BlockQuinoa2
            || bid == BlockInitDangerZone.BlockQuinoa3
            || bid == BlockInitDangerZone.BlockQuinoa4
            || bid == Blocks.grass
            || bid == Blocks.dirt
            || bid == Blocks.farmland
            || bid == BlockInitDangerZone.CrystalGrass);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        Random rand = new Random();
        int Height = 1;
        int dontGrow = 0;
        if (par1World.isRemote) {
            return;
        }
        if (this != BlockInitDangerZone.BlockQuinoa1 && this != BlockInitDangerZone.BlockQuinoa2) {
            return;
        }
        int var7 = par1World.getBlockMetadata(par2, par3, par4);
        this.myMaxHeight = var7 >> 8;
        var7 &= 0xFF;
        if (this.myMaxHeight == 0) {
            this.myMaxHeight = 2 + rand.nextInt(3);
        }
        Block bid = par1World.getBlock(par2, par3 + 1, par4);
        if (bid == Blocks.air) {
            for (int var8 = 1; var8 < 10; ++var8) {
                bid = par1World.getBlock(par2, par3 - var8, par4);
                if (bid != BlockInitDangerZone.BlockQuinoa1 && bid != BlockInitDangerZone.BlockQuinoa2
                    && bid != BlockInitDangerZone.BlockQuinoa3
                    && bid != BlockInitDangerZone.BlockQuinoa4) {
                    break;
                }
                ++Height;
                if (bid == BlockInitDangerZone.BlockQuinoa3 || bid == BlockInitDangerZone.BlockQuinoa4) {
                    dontGrow = 1;
                }
            }
            if (dontGrow != 0) {
                this.myMaxHeight = Height;
            }
            if (var7 >= 5 - this.myMaxHeight / 3) {
                if (Height < this.myMaxHeight) {
                    par1World
                        .setBlock(par2, par3 + 1, par4, BlockInitDangerZone.BlockQuinoa1, this.myMaxHeight << 8, 2);
                    par1World.setBlock(par2, par3, par4, BlockInitDangerZone.BlockQuinoa2, this.myMaxHeight << 8, 2);
                } else {
                    bid = par1World.getBlock(par2, par3, par4);
                    if (bid == BlockInitDangerZone.BlockQuinoa1) {
                        par1World
                            .setBlock(par2, par3, par4, BlockInitDangerZone.BlockQuinoa3, this.myMaxHeight << 8, 2);
                    } else if (bid == BlockInitDangerZone.BlockQuinoa3) {
                        par1World
                            .setBlock(par2, par3, par4, BlockInitDangerZone.BlockQuinoa4, this.myMaxHeight << 8, 2);
                    }
                    bid = par1World.getBlock(par2, par3, par4);
                    par1World.setBlock(par2, par3, par4, bid, this.myMaxHeight << 8, 2);
                }
            } else {
                bid = par1World.getBlock(par2, par3, par4);
                par1World.setBlock(par2, par3, par4, bid, this.myMaxHeight << 8 | var7 + 1, 2);
            }
        }
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return ItemInitDangerZone.Quinoa;
    }

    public int quantityDropped(final Random par1Random) {
        if (this == BlockInitDangerZone.BlockQuinoa4) {
            return 3 + par1Random.nextInt(3);
        }
        return 0;
    }

    public Item itemPicked(final World par1World, final int par2, final int par3, final int par4) {
        return ItemInitDangerZone.Quinoa;
    }

    protected Item getSeedItem() {
        return ItemInitDangerZone.Quinoa;
    }

    protected Item getCropItem() {
        return ItemInitDangerZone.Quinoa;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
