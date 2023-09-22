
package fr.iamacat.dangerzone_iamacatfr.items;

import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemTool;

import com.google.common.collect.Sets;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CrystalShovel extends ItemTool {

    public static final Set blocksEffectiveAgainst;

    public CrystalShovel(final int par1, final ToolMaterial par2) {
        super(1.0f, par2, CrystalShovel.blocksEffectiveAgainst);
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean canHarvestBlock(final Block par1Block) {
        return par1Block == Blocks.snow;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }

    static {
        blocksEffectiveAgainst = Sets.newHashSet(
            (Object[]) new Block[] { (Block) Blocks.grass, Blocks.dirt, (Block) Blocks.sand, Blocks.gravel, Blocks.snow,
                Blocks.snow_layer, Blocks.clay, Blocks.farmland, (Block) Blocks.mycelium, OreSpawnMain.CrystalGrass });
    }
}
