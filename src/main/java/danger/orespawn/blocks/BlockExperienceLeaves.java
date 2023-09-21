
package danger.orespawn.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockExperienceLeaves extends BlockLeaves {

    private IIcon generic_solid;

    public BlockExperienceLeaves(final int par1) {
        this.generic_solid = null;
    }

    public void getSubBlocks(final Item par1, final CreativeTabs par2CreativeTabs, final List par3List) {
        par3List.add(new ItemStack(Item.getItemFromBlock((Block) this), 1, 0));
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        if (!par1World.isRemote) {}
    }

    public int quantityDropped(final Random par1Random) {
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
                                if (t < 14000L || t > 22000L) {
                                    return;
                                }
                                if (par1World.rand.nextInt(65) == 1) {
                                    bid = par1World.getBlock(par2, par3 + 1, par4);
                                    if (bid == Blocks.air) {
                                        this.dropBlockAsItem(
                                            par1World,
                                            par2,
                                            par3 + 2,
                                            par4,
                                            new ItemStack(Items.experience_bottle));
                                    }
                                }
                                if (par1World.rand.nextInt(75) == 1) {
                                    bid = par1World.getBlock(par2, par3 - 1, par4);
                                    if (bid == Blocks.air) {
                                        final EntityExpBottle var11 = new EntityExpBottle(
                                            par1World,
                                            par2,
                                            (par3 - 1),
                                            par4);
                                        var11.setLocationAndAngles(par2, (par3 - 1), par4, 0.0f, 0.0f);
                                        var11.setThrowableHeading(
                                            ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 2.0f),
                                            -0.10000000149011612,
                                            ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 2.0f),
                                            0.4f,
                                            5.0f);
                                        par1World.spawnEntityInWorld(var11);
                                    }
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
        final Random par5Random) {
        long t = par1World.getWorldTime();
        t %= 24000L;
        if (t < 13000L || t > 23000L) {
            return;
        }
        int rate = 0;
        if (t < 14000L) {
            rate = (14000 - (int) t) / 2;
        }
        if (t > 22000L) {
            rate = (int) (t - 22000L) / 2;
        }
        if (par1World.rand.nextInt(200 + rate) == 1) {
            final Block bid = par1World.getBlock(par2, par3 + 1, par4);
            if (bid == Blocks.air) {
                for (int i = 0; i < 10; ++i) {
                    par1World.spawnParticle(
                        "fireworksSpark",
                        par2,
                        par3 + 1.25,
                        par4,
                        par1World.rand.nextGaussian(),
                        Math.abs(par1World.rand.nextGaussian()),
                        par1World.rand.nextGaussian());
                }
            }
        }
        if (par1World.rand.nextInt(40 + rate) == 1) {
            final Block bid = par1World.getBlock(par2, par3 - 1, par4);
            if (bid == Blocks.air) {
                for (int i = 0; i < 4; ++i) {
                    par1World.spawnParticle(
                        "fireworksSpark",
                        par2,
                        par3 - 1.25,
                        par4,
                        (par1World.rand.nextFloat() - par1World.rand.nextFloat()),
                        (-Math.abs(par1World.rand.nextFloat())),
                        (par1World.rand.nextFloat() - par1World.rand.nextFloat()));
                }
            }
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
}
