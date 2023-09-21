
package danger.orespawn.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockReed;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class IslandBlock extends BlockReed {

    public IslandBlock(final int par1) {
        final float var3 = 0.375f;
        this.setBlockBounds(0.5f - var3, 0.0f, 0.5f - var3, 0.5f + var3, 1.0f, 0.5f + var3);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return par1World.getBlock(par2, par3 - 1, par4)
            .getMaterial()
            .isSolid();
    }

    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.rand.nextInt(20) != 1) {
            return;
        }
        for (int j1 = 0; j1 < 20; ++j1) {
            par1World.spawnParticle(
                "happyVillager",
                (par2 + par1World.rand.nextFloat()),
                par3 + par1World.rand.nextFloat(),
                (par4 + par1World.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
        }
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        int isok = 1;
        if (par1World.isRemote) {
            return;
        }
        final int n = 1 + par1World.rand.nextInt(3);
        int m = 64;
        if (OreSpawnMain.IslandSizeFactor == 2) {
            m = 55;
        }
        if (OreSpawnMain.IslandSizeFactor == 1) {
            m = 45;
        }
        for (int i = 0; i < n; ++i) {
            final int height = 12 + par1World.rand.nextInt(m);
            isok = 1;
            for (int k = -10; k <= 10; ++k) {
                for (int j = -10; j <= 10; ++j) {
                    final Block bid = par1World.getBlock(par2 + j, par3 + height, par4 + k);
                    if (bid != Blocks.air) {
                        isok = 0;
                        break;
                    }
                }
            }
            if (isok != 0) {
                if (par1World.rand.nextInt(25) == 1) {
                    spawnCreature(par1World, "Island", par2, par3 + height, par4);
                } else {
                    spawnCreature(par1World, "IslandToo", par2, par3 + height, par4);
                }
            }
        }
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
        par1World.setBlock(par2, par3 + 1, par4, Blocks.air, 0, 2);
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Item.getItemFromBlock(OreSpawnMain.MyIslandBlock);
    }

    public int quantityDropped(final Random par1Random) {
        return 1;
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8;
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
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
