
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.init.DimensionInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockCrystalLeaves extends BlockLeaves {

    public BlockCrystalLeaves(final int par1) {
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public void getSubBlocks(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.getItemFromBlock((Block) this), 1, 0));
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        if (!par1World.isRemote) {
            if (par1World.rand.nextInt(100) == 1) {
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalApple));
            }
            if (par1World.rand.nextInt(50) == 1) {
                if (this == OreSpawnMain.MyCrystalLeaves) {
                    this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant));
                }
                if (this == OreSpawnMain.MyCrystalLeaves2) {
                    this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant2));
                }
                if (this == OreSpawnMain.MyCrystalLeaves3) {
                    this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MyCrystalPlant3));
                }
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
        if (par1World.provider.dimensionId == DimensionInitDangerZone.DimensionID4) {
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
                            if (bid != null && bid
                                .canSustainLeaves((IBlockAccess) par1World, par2 + var8, par3 + var9, par4 + var10)) {
                                bid = par1World.getBlock(par2, par3 - 1, par4);
                                if (bid == Blocks.air && par1World.rand.nextInt(chance) == 3) {
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

    private void removeLeaves(final World par1World, final int par2, final int par3, final int par4) {
        this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
    }

    public boolean isOpaqueCube() {
        return OreSpawnMain.FastGraphicsLeaves != 0;
    }

    public boolean renderAsNormalBlock() {
        return OreSpawnMain.FastGraphicsLeaves != 0;
    }

    public int getRenderType() {
        if (OreSpawnMain.FastGraphicsLeaves != 0) {
            return super.getRenderType();
        }
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess, final int par2, final int par3,
        final int par4, final int par5) {
        final Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return OreSpawnMain.FastGraphicsLeaves == 0 || i1 != this;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return 14540253;
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(final int par1) {
        return 14540253;
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4) {
        return 14540253;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        return this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"+ this.getUnlocalizedName()
                .substring(5));
    }

    public String[] func_150125_e() {
        return null;
    }
}
