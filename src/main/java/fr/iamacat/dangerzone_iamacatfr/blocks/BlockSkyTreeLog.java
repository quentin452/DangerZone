
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class BlockSkyTreeLog extends Block {

    public BlockSkyTreeLog(final int par1, final int par2) {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public void getSubBlocks(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.getItemFromBlock((Block) this), 1, 0));
    }

    protected ItemStack createStackedBlock(final int par1) {
        return new ItemStack(Item.getItemFromBlock((Block) this), 1, 0);
    }

    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }

    public boolean isWood(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Item.getItemFromBlock(OreSpawnMain.MySkyTreeLog);
    }

    public void breakRecursor(final World world, final int x, final int y, final int z, final int xf, final int yf,
        final int zf, final int recursion) {
        final int var7 = 1;
        if (recursion > 1000) {
            return;
        }
        for (int var8 = -var7; var8 <= var7; ++var8) {
            for (int var9 = -var7; var9 <= var7; ++var9) {
                for (int var10 = -var7; var10 <= var7; ++var10) {
                    if (var8 != 0 || var9 != 0 || var10 != 0) {
                        if (x + var8 != xf || y + var9 != yf || z + var10 != zf) {
                            if (recursion <= 0 || x + var8 < xf - var7
                                || x + var8 > xf + var7
                                || y + var9 < yf - var7
                                || y + var9 > yf + var7
                                || z + var10 < zf - var7
                                || z + var10 > zf + var7) {
                                final Block var11 = world.getBlock(x + var8, y + var9, z + var10);
                                if (var11 == this) {
                                    world.setBlock(x + var8, y + var9, z + var10, Blocks.air, 0, 2);
                                    this.dropBlockAsItem(world, x + var8, y + var9, z + var10, 0, 0);
                                    this.breakRecursor(world, x + var8, y + var9, z + var10, x, y, z, recursion + 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void onBlockDestroyedByPlayer(final World par1World, final int par2, final int par3, final int par4,
        final int par5) {
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        this.breakRecursor(par1World, par2, par3, par4, par2, par3, par4, 0);
        this.dropBlockAsItem(par1World, par2, par3, par4, 0, 0);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
