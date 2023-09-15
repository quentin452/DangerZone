package fr.iamacat.dangerzone_iamacatfr.materials;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import java.util.Random;

public class AmethystOre extends Block {

    public AmethystOre() {
        super(Material.rock);
        this.setHardness(10.0f);
        this.setResistance(4.0f);
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
                                          final int par5, final float par6, final int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(5);
        this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return ItemInitDangerZone.AmethystIngot;
    }

    public int quantityDroppedWithBonus(final int par1, final Random par2Random) {
        return 1 + par2Random.nextInt(2);
    }

    public int quantityDropped(final Random par1Random) {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID +  ":" +  this.getUnlocalizedName()
                .substring(5));
    }
}
