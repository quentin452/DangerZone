
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.List;
import java.util.Random;

public class BlockScaryLeaves extends BlockLeaves {

    private IIcon scary_solid;
    private IIcon generic_solid;

    public BlockScaryLeaves(final int par1) {
        this.scary_solid = null;
        this.generic_solid = null;
    }

    public void getSubBlocks(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.getItemFromBlock((Block) this), 1, 0));
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        if (!par1World.isRemote && par1World.rand.nextInt(25) == 1) {
            if (this == OreSpawnMain.MyCherryLeaves) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCherry));
            }
            if (this == OreSpawnMain.MyPeachLeaves) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyPeach));
            }
        }
    }

    public int quantityDropped(final Random par1Random) {
        if (this == OreSpawnMain.MyCherryLeaves) {
            return par1Random.nextInt(4);
        }
        if (this == OreSpawnMain.MyPeachLeaves) {
            return par1Random.nextInt(1);
        }
        return 0;
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        final int var7 = 2;
        int totaldist = 0;
        if (!par1World.isRemote && par1World
            .checkChunksExist(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
            for (int var8 = -var7; var8 <= var7; ++var8) {
                for (int var9 = -var7; var9 <= 0; ++var9) {
                    for (int var10 = -var7; var10 <= var7; ++var10) {
                        totaldist = Math.abs(var8) + Math.abs(var9) + Math.abs(var10);
                        if (totaldist <= 3) {
                            Block bid = par1World.getBlock(par2 + var8, par3 + var9, par4 + var10);
                            if (bid != null && bid
                                .canSustainLeaves((IBlockAccess) par1World, par2 + var8, par3 + var9, par4 + var10)) {
                                long t = par1World.getWorldTime();
                                t %= 24000L;
                                if (this == OreSpawnMain.MyScaryLeaves && t < 12000L) {
                                    OreSpawnMain
                                        .setBlockFast(par1World, par2, par3, par4, OreSpawnMain.MyAppleLeaves, 0, 3);
                                }
                                bid = par1World.getBlock(par2, par3 - 1, par4);
                                if (bid == Blocks.air && par1World.rand.nextInt(20) == 3) {
                                    this.dropBlockAsItemWithChance(par1World, par2, par3 - 1, par4, 0, 0.0f, 0);
                                }
                                return;
                            }
                        }
                    }
                }
            }
            this.removeLeaves(par1World, par2, par3, par4);
        }
    }

    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {}

    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
    }

    public boolean isOpaqueCube() {
        return OreSpawnMain.FastGraphicsLeaves != 0;
    }

    private boolean areAtLeastTwoAdjacentBlocksLeaves(IBlockAccess world, int x, int y, int z, Block leafBlock) {
        int leafCount = 0;
        for (EnumFacing facing : EnumFacing.values()) {
            Block adjacentBlock = world.getBlock(x + facing.getFrontOffsetX(), y + facing.getFrontOffsetY(), z + facing.getFrontOffsetZ());
            if (adjacentBlock == leafBlock && adjacentBlock instanceof BlockScaryLeaves) {
                leafCount++;
                if (leafCount >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z, int side) {
        Block block = world.getBlock(x, y, z);
        Block adjacentBlock = world.getBlock(x + ForgeDirection.VALID_DIRECTIONS[side].offsetX, y + ForgeDirection.VALID_DIRECTIONS[side].offsetY, z + ForgeDirection.VALID_DIRECTIONS[side].offsetZ);

        // Si le bloc adjacent est une feuille du même type et qu'au moins deux blocs adjacents sont aussi des feuilles du même type, ne pas rendre le côté.
        if (block == adjacentBlock && block instanceof BlockScaryLeaves) {
            if (areAtLeastTwoAdjacentBlocksLeaves(world, x, y, z, block)) {
                return false;
            }
            return true;
        }

        return super.shouldSideBeRendered(world, x, y, z, side);
    }



    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
        this.generic_solid = iconRegister.registerIcon(Tags.MODID + ":generic_solid");
        this.scary_solid = iconRegister.registerIcon(Tags.MODID + ":scary_solid");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        if (OreSpawnMain.FastGraphicsLeaves == 0) {
            return this.blockIcon;
        }
        if (this == OreSpawnMain.MyCherryLeaves) {
            return this.generic_solid;
        }
        if (this == OreSpawnMain.MyPeachLeaves) {
            return this.generic_solid;
        }
        return this.scary_solid;
    }

    public String[] func_150125_e() {
        return null;
    }

}
