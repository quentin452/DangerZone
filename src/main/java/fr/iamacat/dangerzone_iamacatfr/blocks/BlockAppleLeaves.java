
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityAnt;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.PurplePower;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class BlockAppleLeaves extends BlockLeaves {

    private IIcon generic_solid;

    public BlockAppleLeaves(final int par1) {
        this.generic_solid = null;
    }

    public void getSubBlocks(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.getItemFromBlock((Block) this), 1, 0));
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
                this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(OreSpawnMain.MagicApple));
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
        if (par1World.provider.dimensionId == OreSpawnMain.DimensionID4) {
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
                                if (t > 12000L && par1World.provider.dimensionId == OreSpawnMain.DimensionID4) {
                                    OreSpawnMain
                                        .setBlockFast(par1World, par2, par3, par4, OreSpawnMain.MyScaryLeaves, 0, 3);
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

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(final IBlockAccess par1IBlockAccess, final int par2, final int par3,
        final int par4, final int par5) {
        final Block i1 = par1IBlockAccess.getBlock(par2, par3, par4);
        return OreSpawnMain.FastGraphicsLeaves == 0 || i1 != this;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
        this.generic_solid = iconRegister.registerIcon("OreSpawn:generic_solid");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        if (OreSpawnMain.FastGraphicsLeaves != 0) {
            return this.generic_solid;
        }
        return this.blockIcon;
    }

    public String[] func_150125_e() {
        return null;
    }

    public static class CreeperRepellent extends BlockTorch {

        public CreeperRepellent(final int par1) {
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
                .getBoundingBox(par2 - 20.0, par3 - 10.0, par4 - 20.0, par2 + 20.0, par3 + 10.0, par4 + 20.0);
            final List var5 = par1World.getEntitiesWithinAABB(EntityLivingBase.class, bb);
            final Iterator var6 = var5.iterator();
            EntityLivingBase var7;
            while (var6.hasNext()) {
                var7 = (EntityLivingBase) var6.next();
                if (var7 != null && var7 instanceof EntityCreeper) {
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
                if (var7 != null && var7 instanceof PurplePower) {
                    final PurplePower p = (PurplePower) var7;
                    if (p.getPurpleType() == 10) {
                        return;
                    }
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
                    final EntityLivingBase entityLivingBase5 = var7;
                    entityLivingBase5.motionX += f * Math.sin(d4);
                    final EntityLivingBase entityLivingBase6 = var7;
                    entityLivingBase6.motionZ += f * Math.cos(d4);
                }
            }
        }

        @SideOnly(Side.CLIENT)
        public void registerBlockIcons(final IIconRegister iconRegister) {
            this.blockIcon = iconRegister.registerIcon(
                "OreSpawn:" + this.getUnlocalizedName()
                    .substring(5));
        }
    }
}
