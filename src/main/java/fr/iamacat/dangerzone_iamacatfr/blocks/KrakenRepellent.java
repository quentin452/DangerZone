package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class KrakenRepellent extends BlockTorch {

    public KrakenRepellent() {
        this.func_149647_a(CreativeTabs.tabRedstone);
    }

    @SideOnly(Side.CLIENT)
    public void func_149734_b(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        final int var6 = par1World.func_72805_g(par2, par3, par4);
        final double var7 = par2 + 0.5f;
        final double var8 = par3 + 0.7f;
        final double var9 = par4 + 0.5f;
        final double var10 = 0.413;
        final double var11 = 0.271;
        if (var6 == 1) {
            par1World.func_72869_a("smoke", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
        } else if (var6 == 2) {
            par1World.func_72869_a("smoke", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
        } else if (var6 == 3) {
            par1World.func_72869_a("smoke", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
        } else if (var6 == 4) {
            par1World.func_72869_a("smoke", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
        } else {
            par1World.func_72869_a("smoke", var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("flame", var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
            par1World.func_72869_a("reddust", var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
        }
    }

    public int func_149738_a(final World par1World) {
        return 10;
    }

    public void func_149674_a(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (!par1World.isRemote) {
            this.findSomethingToRepell(par1World, par2, par3, par4);
            par1World.func_147464_a(par2, par3, par4, (Block) this, this.func_149738_a(par1World));
        }
    }

    public void func_149726_b(final World world, final int x, final int y, final int z) {
        world.func_147464_a(x, y, z, (Block) this, this.func_149738_a(world));
    }

    public void func_149695_a(final World world, final int x, final int y, final int z, final Block blockId) {
        world.func_147464_a(x, y, z, (Block) this, this.func_149738_a(world));
    }

    public boolean func_149742_c(final World par1World, final int par2, final int par3, final int par4) {
        return super.func_149742_c(par1World, par2, par3, par4);
    }

    private void findSomethingToRepell(final World par1World, final int par2, final int par3, final int par4) {
        final AxisAlignedBB bb = AxisAlignedBB
            .func_72330_a(par2 - 20.0, par3 - 10.0, par4 - 20.0, par2 + 20.0, par3 + 40.0, par4 + 20.0);
        final List var5 = par1World.func_72872_a((Class) EntityLivingBase.class, bb);
        final Iterator var6 = var5.iterator();
        EntityLivingBase var7 = null;
        while (var6.hasNext()) {
            var7 = var6.next();
            if (var7 != null && var7 instanceof Kraken) {
                final double d1 = var7.posX - par2;
                final double d2 = var7.posY - 15.0 - par3;
                final double d3 = var7.posZ - par4;
                double f = d1 * d1 + d2 * d2 + d3 * d3;
                f = Math.sqrt(f);
                f = 20.0 - f;
                if (f > 20.0) {
                    f = 20.0;
                }
                if (f < 0.0) {
                    f = 0.0;
                }
                f *= 0.4;
                final double d4 = (float) Math.atan2(var7.posX - par2, var7.posZ - par4);
                final EntityLivingBase entityLivingBase = var7;
                entityLivingBase.motionX += f * Math.sin(d4);
                final EntityLivingBase entityLivingBase2 = var7;
                entityLivingBase2.motionZ += f * Math.cos(d4);
            }
            if (var7 != null && var7 instanceof EntityAnt) {
                final double d1 = var7.posX - par2;
                final double d2 = var7.posY - par3;
                final double d3 = var7.posZ - par4;
                double f = d1 * d1 + d2 * d2 + d3 * d3;
                f = Math.sqrt(f);
                f = 20.0 - f;
                if (f > 20.0) {
                    f = 20.0;
                }
                if (f < 0.0) {
                    f = 0.0;
                }
                f *= 0.4;
                final double d4 = (float) Math.atan2(var7.posX - par2, var7.posZ - par4);
                final EntityLivingBase entityLivingBase3 = var7;
                entityLivingBase3.motionX += f * Math.sin(d4);
                final EntityLivingBase entityLivingBase4 = var7;
                entityLivingBase4.motionZ += f * Math.cos(d4);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void func_149651_a(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.func_94245_a(
            Tags.MODID + ":"
                + this.func_149739_a()
                    .substring(5));
    }
}
