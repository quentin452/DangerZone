
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.util.Random;

public class OreTitanium extends Block {

    private boolean glowing;
    private int glowcount;

    public OreTitanium() {
        super(Material.rock);
        this.glowing = false;
        this.glowcount = 0;
        this.setHardness(15.0f);
        this.setResistance(5.0f);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
        this.glowing = false;
    }

    public int tickRate() {
        return 30;
    }

    public void onBlockClicked(final World par1World, final int par2, final int par3, final int par4,
        final EntityPlayer par5EntityPlayer) {
        this.glow(par1World, par2, par3, par4);
        super.onBlockClicked(par1World, par2, par3, par4, par5EntityPlayer);
    }

    public void onEntityWalking(final World par1World, final int par2, final int par3, final int par4,
        final Entity par5Entity) {
        this.glow(par1World, par2, par3, par4);
        super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
    }

    public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4,
        final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        this.glow(par1World, par2, par3, par4);
        return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
    }

    private void glow(final World par1World, final int par2, final int par3, final int par4) {
        this.glowing = true;
        this.glowcount = 5;
        this.sparkle(par1World, par2, par3, par4);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {}

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (this.glowing) {
            this.sparkle(par1World, par2, par3, par4);
            if (this.glowcount > 0) {
                --this.glowcount;
            } else {
                this.glowing = false;
            }
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
                par1World.spawnParticle("reddust", var8, var9, var10, 0.0, 0.0, 0.0);
            }
        }
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(10);
        if (par3 < 40) {
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
