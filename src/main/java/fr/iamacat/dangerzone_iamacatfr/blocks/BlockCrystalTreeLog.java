
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockCrystalTreeLog extends BlockRotatedPillar {

    @SideOnly(Side.CLIENT)
    private IIcon field_111052_c;
    @SideOnly(Side.CLIENT)
    private IIcon tree_top;

    public BlockCrystalTreeLog() {
        super(Material.wood);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    protected ItemStack createStackedBlock(final int par1) {
        return new ItemStack(Item.getItemFromBlock(this), 1, 0);
    }

    public boolean canSustainLeaves(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }

    public boolean isWood(final IBlockAccess world, final int x, final int y, final int z) {
        return true;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public Item getItemDropped(final int p_149650_1_, final Random p_149650_2_, final int p_149650_3_) {
        return Item.getItemFromBlock(BlockInitDangerZone.BlockCrystalTreeLog);
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getSideIcon(final int par1) {
        return this.field_111052_c;
    }

    @SideOnly(Side.CLIENT)
    protected IIcon getTopIcon(final int par1) {
        return this.tree_top;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.field_111052_c = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
        this.tree_top = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5)
                + "_top");
    }
}
