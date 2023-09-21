
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import java.util.Random;

public class BlockUranium extends Block {

    public BlockUranium(final int par1) {
        super(Material.rock);
        this.setHardness(5.0f);
        this.setResistance(5.0f);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setLightLevel(0.2f);
    }

    public int tickRate() {
        return 100;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.rand.nextInt(20) == 0) {
            this.sparkle(par1World, par2, par3, par4);
        }
    }

    private void sparkle(final World par1World, final int par2, final int par3, final int par4) {
        final Random var5 = par1World.rand;
        final double var6 = 0.0625;
        for (int var7 = 0; var7 < 6; ++var7) {
            double var8 = par2 + var5.nextFloat();
            double var9 = par3 + var5.nextFloat();
            double var10 = par4 + var5.nextFloat();
            if (var7 == 0 && !par1World.getBlock(par2, par3 + 1, par4)
                .isOpaqueCube()) {
                var9 = par3 + 1 + var6;
            }
            if (var7 == 1 && !par1World.getBlock(par2, par3 - 1, par4)
                .isOpaqueCube()) {
                var9 = par3 + 0 - var6;
            }
            if (var7 == 2 && !par1World.getBlock(par2, par3, par4 + 1)
                .isOpaqueCube()) {
                var10 = par4 + 1 + var6;
            }
            if (var7 == 3 && !par1World.getBlock(par2, par3, par4 - 1)
                .isOpaqueCube()) {
                var10 = par4 + 0 - var6;
            }
            if (var7 == 4 && !par1World.getBlock(par2 + 1, par3, par4)
                .isOpaqueCube()) {
                var8 = par2 + 1 + var6;
            }
            if (var7 == 5 && !par1World.getBlock(par2 - 1, par3, par4)
                .isOpaqueCube()) {
                var8 = par2 + 0 - var6;
            }
            if (var8 < par2 || var8 > par2 + 1 || var9 < 0.0 || var9 > par3 + 1 || var10 < par4 || var10 > par4 + 1) {
                final int which = par1World.rand.nextInt(3);
                if (which == 0) {
                    par1World.spawnParticle("flame", var8, var9, var10, 0.0, 0.0, 0.0);
                }
                if (which == 1) {
                    par1World.spawnParticle("smoke", var8, var9, var10, 0.0, 0.0, 0.0);
                }
                if (which == 2) {
                    par1World.spawnParticle("reddust", var8, var9, var10, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"+ this.getUnlocalizedName()
                .substring(5));
    }
}
