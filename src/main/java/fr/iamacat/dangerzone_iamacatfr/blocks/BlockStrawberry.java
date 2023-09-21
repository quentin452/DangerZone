
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockStrawberry extends BlockCrops {

    private IIcon[] iconArray;

    public BlockStrawberry(final int par1) {}

    public IIcon getIcon(final int par1, int par2) {
        if (par2 < 7) {
            if (par2 >= 6) {
                par2 = 4;
            }
            return this.iconArray[par2 >> 1];
        }
        return this.iconArray[3];
    }

    public int quantityDropped(final Random par1Random) {
        return 1 + par1Random.nextInt(5);
    }

    protected Item func_149866_i() {
        return OreSpawnMain.MyStrawberrySeed;
    }

    protected Item func_149865_P() {
        return OreSpawnMain.MyStrawberry;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IIconRegister) {
        this.iconArray = new IIcon[4];
        for (int i = 0; i < this.iconArray.length; ++i) {
            this.iconArray[i] = par1IIconRegister.registerIcon(Tags.MODID +":strawberry_" + i);
        }
    }
}
