
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class CrystaltermiteBlock extends Block {

    @SideOnly(Side.CLIENT)
    private IIcon[] field_94364_a;

    public CrystaltermiteBlock() {
        super(Material.grass);
        this.setTickRandomly(true);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        if (this.field_94364_a == null) {
            return null;
        }
        return (par1 == 1) ? this.field_94364_a[0] : ((par1 == 0) ? this.field_94364_a[1] : this.field_94364_a[2]);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getBlockTexture(final IBlockAccess par1IBlockAccess, final int par2, final int par3, final int par4,
        final int par5) {
        if (this.field_94364_a == null) {
            return null;
        }
        if (par5 == 1) {
            return this.field_94364_a[0];
        }
        if (par5 == 0) {
            return this.field_94364_a[1];
        }
        return this.field_94364_a[2];
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        int howmany = 0;
        if (!par1World.isRemote) {
            if (par1World.isRaining()) {
                return;
            }
            final Block bid = par1World.getBlock(par2, par3 + 1, par4);
            if (bid == Blocks.air) {
                howmany = par5Random.nextInt(6) + 2;
                for (int i = 0; i < howmany; ++i) {
                    if (this == BlockInitDangerZone.BrownAntNest) {
                        spawnCreature(par1World, "Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                    } else if (this == BlockInitDangerZone.RedAntNest) {

                        spawnCreature(par1World, "Red Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);

                    } else if (this == BlockInitDangerZone.UnstablenAntNest) {

                        spawnCreature(par1World, "Unstable Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);

                    } else if (this == BlockInitDangerZone.TermiteNest) {
                        spawnCreature(par1World, "Termite", par2 + 0.5, par3 + 1.01, par4 + 0.5);

                    } else if (this == BlockInitDangerZone.CrystalTermiteBlock) {
                        spawnCreature(par1World, "Termite", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                        spawnCreature(par1World, "Rainbow Ant", par2 + 0.5, par3 + 1.01, par4 + 0.5);
                    }
                }
            }
        }
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Item.getItemFromBlock(this);
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

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IIconRegister) {
        (this.field_94364_a = new IIcon[3])[0] = par1IIconRegister.registerIcon(Tags.MODID + ":crystaltermite_top");
        this.field_94364_a[1] = par1IIconRegister.registerIcon(Tags.MODID + ":crystaltermite_bottom");
        this.field_94364_a[2] = par1IIconRegister.registerIcon(Tags.MODID + ":crystaltermite_side");
    }
}
