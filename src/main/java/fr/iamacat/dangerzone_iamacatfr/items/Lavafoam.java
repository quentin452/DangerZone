
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Random;

public class Lavafoam extends Block {

    public Lavafoam(final int par1) {
        super(Material.rock);
        this.setHardness(5.0f);
        this.setResistance(5.0f);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
        this.slipperiness = 1.1f;
    }

    public int tickRate() {
        return 10;
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
                final int which = par1World.rand.nextInt(10);
                if (which == 1) {
                    par1World.spawnParticle("smoke", var8, var9, var10, 0.0, 0.0, 0.0);
                }
                if (which == 2) {
                    par1World.spawnParticle("reddust", var8, var9, var10, 0.0, 0.0, 0.0);
                }
            }
        }
    }

    public void onEntityCollidedWithBlock(final World par1World, final int par2, final int par3, final int par4,
        final Entity par5Entity) {
        final double pi = 3.14159;
        final double pi2 = pi / 2.0;
        final double pi3 = pi / 4.0;
        super.onEntityCollidedWithBlock(par1World, par2, par3, par4, par5Entity);
        if (par5Entity == null) {
            return;
        }
        if (!(par5Entity instanceof EntityLivingBase)) {
            return;
        }
        double d = Math.atan2(par5Entity.posX - (par2 + 0.5f), par5Entity.posZ - (par4 + 0.5f));
        if (d < 0.0) {
            d += pi * 2.0;
        }
        if (d > pi2 - pi3 && d < pi2 + pi3) {
            par5Entity.motionX = 0.44999998807907104;
            par5Entity.motionZ *= 1.350000023841858;
        } else if (d > pi - pi3 && d < pi + pi3) {
            par5Entity.motionZ = -0.44999998807907104;
            par5Entity.motionX *= 1.350000023841858;
        } else if (d > pi + pi2 - pi3 && d < pi + pi2 + pi3) {
            par5Entity.motionX = -0.44999998807907104;
            par5Entity.motionZ *= 1.350000023841858;
        } else {
            par5Entity.motionZ = 0.44999998807907104;
            par5Entity.motionX *= 1.350000023841858;
        }
        d = Math.sqrt(par5Entity.motionZ * par5Entity.motionZ + par5Entity.motionX * par5Entity.motionX);
        if (d > 1.0) {
            par5Entity.attackEntityFrom(DamageSource.fall, (float) d);
        }
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(5);
        if (par1World.provider.dimensionId == -1) {
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3,
        final int par4) {
        final float f = 0.0125f;
        return AxisAlignedBB
            .getBoundingBox((par2 + f), par3, (par4 + f), (par2 + 1 - f), (float) (par3 + 1), (par4 + 1 - f));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
