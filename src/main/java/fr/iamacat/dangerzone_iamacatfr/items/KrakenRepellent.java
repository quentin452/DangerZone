
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
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
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        final int var6 = par1World.getBlockMetadata(par2, par3, par4);
        final double var7 = par2 + 0.5f;
        final double var8 = par3 + 0.7f;
        final double var9 = par4 + 0.5f;
        final double var10 = 0.413;
        final double var11 = 0.271;
        if (var6 == 1) {
            par1World.spawnParticle("smoke", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7 - var11, var8 + var10, var9, 0.0, 0.0, 0.0);
        } else if (var6 == 2) {
            par1World.spawnParticle("smoke", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7 + var11, var8 + var10, var9, 0.0, 0.0, 0.0);
        } else if (var6 == 3) {
            par1World.spawnParticle("smoke", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var8 + var10, var9 - var11, 0.0, 0.0, 0.0);
        } else if (var6 == 4) {
            par1World.spawnParticle("smoke", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var8 + var10, var9 + var11, 0.0, 0.0, 0.0);
        } else {
            par1World.spawnParticle("smoke", var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
        }
    }

    public int tickRate(final World par1World) {
        return 10;
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (!par1World.isRemote) {
            this.findSomethingToRepell(par1World, par2, par3, par4);
            par1World.scheduleBlockUpdate(par2, par3, par4, (Block) this, this.tickRate(par1World));
        }
    }

    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        world.scheduleBlockUpdate(x, y, z, (Block) this, this.tickRate(world));
    }

    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block blockId) {
        world.scheduleBlockUpdate(x, y, z, (Block) this, this.tickRate(world));
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    private void findSomethingToRepell(final World par1World, final int par2, final int par3, final int par4) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(par2 - 20.0, par3 - 10.0, par4 - 20.0, par2 + 20.0, par3 + 40.0, par4 + 20.0);
        final List var5 = par1World.getEntitiesWithinAABB(EntityLivingBase.class, bb);
        final Iterator var6 = var5.iterator();
        EntityLivingBase var7 = null;
        while (var6.hasNext()) {
            var7 = (EntityLivingBase) var6.next();
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
            if (var7 != null && var7 instanceof BrownAntInstance) {
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
            if (var7 != null && var7 instanceof RedAntInstance) {
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
            if (var7 != null && var7 instanceof RainbowAntInstance) {
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
            if (var7 != null && var7 instanceof UnstableAntInstance) {
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
            if (var7 != null && var7 instanceof TermiteInstance) {
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
                var7.motionX += f * Math.sin(d4);
                var7.motionZ += f * Math.cos(d4);
            }
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
