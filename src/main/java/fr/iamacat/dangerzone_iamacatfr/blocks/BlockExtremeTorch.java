
package fr.iamacat.dangerzone_iamacatfr.blocks;

import java.util.Random;

import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class BlockExtremeTorch extends BlockTorch {

    public BlockExtremeTorch(final int par1) {
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        final int var6 = par1World.getBlockMetadata(par2, par3, par4);
        final double var7 = par2 + 0.5f;
        final double var8 = par3 + 0.7f;
        final double var9 = par4 + 0.5f;
        final double var10 = 0.213;
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
            par1World.spawnParticle("smoke", var7, var8, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("flame", var7, var8, var9, 0.0, 0.0, 0.0);
            par1World.spawnParticle("reddust", var7, var8, var9, 0.0, 0.0, 0.0);
        }
        this.onBlockPlacedBy(par1World, par2, par3, par4, null, null);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    public void onBlockPlacedBy(final World world, final int par2, final int par3, final int par4,
        final EntityLivingBase par5EntityLiving, final ItemStack par6ItemStack) {
        int x = par2;
        int y = par3;
        int z = par4;
        int found = 0;
        if (world.getBlock(x, y - 1, z) == OreSpawnMain.MyEyeOfEnderBlock) {
            for (int tries = 0; tries < 100 && found == 0; ++tries) {
                if (world.rand.nextInt(2) == 0) {
                    x = par2 + 4 + world.rand.nextInt(3) - world.rand.nextInt(3);
                } else {
                    x = par2 - 4 + world.rand.nextInt(3) - world.rand.nextInt(3);
                }
                if (world.rand.nextInt(2) == 0) {
                    z = par4 + 4 + world.rand.nextInt(3) - world.rand.nextInt(3);
                } else {
                    z = par4 - 4 + world.rand.nextInt(3) - world.rand.nextInt(3);
                }
                for (y = par3 - 2; y <= par3 + 2; ++y) {
                    if (world.getBlock(x, y - 1, z)
                        .getMaterial()
                        .isSolid() && world.getBlock(x, y, z) == Blocks.air
                        && world.getBlock(x, y + 1, z) == Blocks.air) {
                        found = 1;
                        break;
                    }
                }
            }
            if (found != 0) {
                if (!world.isRemote) {
                    Entity ent = null;
                    ent = spawnCreature(world, "Cephadrome", x + 0.5, y + 0.01, z + 0.5);
                } else {
                    for (int var3 = 0; var3 < 16; ++var3) {
                        world.spawnParticle(
                            "smoke",
                            (par2 + world.rand.nextFloat() - world.rand.nextFloat()),
                            (par3 + world.rand.nextFloat()),
                            (par4 + world.rand.nextFloat() - world.rand.nextFloat()),
                            0.0,
                            0.0,
                            0.0);
                        world.spawnParticle(
                            "explode",
                            (par2 + world.rand.nextFloat() - world.rand.nextFloat()),
                            (par3 + world.rand.nextFloat()),
                            (par4 + world.rand.nextFloat() - world.rand.nextFloat()),
                            0.0,
                            0.0,
                            0.0);
                        world.spawnParticle(
                            "reddust",
                            (par2 + world.rand.nextFloat() - world.rand.nextFloat()),
                            (par3 + world.rand.nextFloat()),
                            (par4 + world.rand.nextFloat() - world.rand.nextFloat()),
                            0.0,
                            0.0,
                            0.0);
                    }
                }
                if (par5EntityLiving != null) {
                    par5EntityLiving.worldObj.playSoundAtEntity(
                        par5EntityLiving,
                        "random.explode",
                        1.0f,
                        world.rand.nextFloat() * 0.2f + 0.9f);
                } else {
                    world.playSound(
                        par2,
                        par3,
                        par4,
                        "random.explode",
                        1.0f,
                        world.rand.nextFloat() * 0.2f + 0.9f,
                        false);
                }
                world.setBlock(par2, par3, par4, Blocks.air);
            }
        }
        super.onBlockPlacedBy(world, par2, par3, par4, par5EntityLiving, par6ItemStack);
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
