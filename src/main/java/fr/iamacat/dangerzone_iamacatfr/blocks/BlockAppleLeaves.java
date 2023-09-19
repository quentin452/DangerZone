
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockAppleLeaves extends BlockLeaves {

    private IIcon generic_solid;

    public BlockAppleLeaves() {
        this.generic_solid = null;
    }

    public void getSubBlocks(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.getItemFromBlock(this), 1, 0));
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        if (!par1World.isRemote) {
            if (par1World.rand.nextInt(25) == 1) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.apple));
            }
            if (par1World.rand.nextInt(500) == 2) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.golden_apple, 1, 0));
            }
            if (par1World.rand.nextInt(1000) == 3) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(Items.golden_apple, 1, 1));
            }
            if (par1World.rand.nextInt(10000) == 4) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(ItemInitDangerZone.OmgMagicApple));
            }
        }
    }

    public int quantityDropped(final Random par1Random) {
        return 1;
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        int var7 = 2;
        int totaldist = 0;
        int chance = 20;
        if (par1World.provider.dimensionId == DimensionInitDangerZone.DangerDimensionId) {
            chance = 100;
            var7 = 1;
        }
        if (!par1World.isRemote && par1World
            .checkChunksExist(par2 - var7, par3 - var7, par4 - var7, par2 + var7, par3 + var7, par4 + var7)) {
            for (int var8 = -var7; var8 <= var7; ++var8) {
                for (int var9 = -var7; var9 <= 0; ++var9) {
                    for (int var10 = -var7; var10 <= var7; ++var10) {
                        totaldist = Math.abs(var8) + Math.abs(var9) + Math.abs(var10);
                        if (totaldist <= 3) {
                            Block bid = par1World.getBlock(par2 + var8, par3 + var9, par4 + var10);
                            if (bid != Blocks.air && bid
                                .canSustainLeaves((IBlockAccess) par1World, par2 + var8, par3 + var9, par4 + var10)) {
                                bid = par1World.getBlock(par2, par3 - 1, par4);
                                if (bid == Blocks.air && par1World.rand.nextInt(chance) == 3) {
                                    this.dropBlockAsItemWithChance(par1World, par2, par3 - 1, par4, 0, 0.0f, 0);
                                }
                                long t = par1World.getWorldTime();
                                t %= 24000L;
                                if (t > 12000L
                                    && par1World.provider.dimensionId == DimensionInitDangerZone.DangerDimensionId) {
                                    DangerZone.setBlockFast(
                                        par1World,
                                        par2,
                                        par3,
                                        par4,
                                        BlockInitDangerZone.BlockScaryLeaves,
                                        0,
                                        3);
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

    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
    }

    public boolean isOpaqueCube() {
        return DangerZone.FastGraphicsLeaves != 0;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess, final int par2, final int par3,
        final int par4, final int par5) {
        final Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return DangerZone.FastGraphicsLeaves == 0 || i1 != this;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
        this.generic_solid = iconRegister.registerIcon(Tags.MODID + ":generic_solid");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        if (DangerZone.FastGraphicsLeaves != 0) {
            return this.generic_solid;
        }
        return this.blockIcon;
    }

    public String[] func_150125_e() {
        return null;
    }
}