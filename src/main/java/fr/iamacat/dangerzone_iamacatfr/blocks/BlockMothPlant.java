
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.Random;

public class BlockMothPlant extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private IIcon[] field_94364_a;

    public BlockMothPlant(final int par1) {
        this.setTickRandomly(true);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);
        if (par1World.isRemote) {
            return;
        }
        if (par1World.isRaining()) {
            return;
        }
        int rate = par1World.getBlockMetadata(par2, par3, par4);
        rate &= 0x7;
        rate = 7 - rate;
        if (rate > 1 && OreSpawnMain.OreSpawnRand.nextInt(rate) != 0) {
            return;
        }
        final Block bid = par1World.getBlock(par2, par3 + 1, par4);
        if (bid == Blocks.air && !par1World.isDaytime() && OreSpawnMain.MothEnable != 0) {
            spawnCreature(par1World, "Moth", par2 + 0.5, par3 + 1.01, par4 + 0.5);
        }
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
    public IIcon getIcon(final int par1, int par2) {
        if (par2 < 7) {
            if (par2 >= 6) {
                par2 = 4;
            }
            return this.field_94364_a[par2 >> 1];
        }
        return this.field_94364_a[3];
    }

    public int quantityDropped(final Random par1Random) {
        return 1 + par1Random.nextInt(5);
    }

    protected Item func_149866_i() {
        return OreSpawnMain.MyMothSeed;
    }

    protected Item func_149865_P() {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IIconRegister) {
        this.field_94364_a = new IIcon[4];
        for (int i = 0; i < this.field_94364_a.length; ++i) {
            this.field_94364_a[i] = par1IIconRegister.registerIcon("OreSpawn:moth_" + i);
        }
    }
}
