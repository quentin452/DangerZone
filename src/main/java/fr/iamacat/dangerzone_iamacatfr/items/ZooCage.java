
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ZooCage extends Item {

    private int cage_size;

    public ZooCage(final int i, final int j) {
        this.cage_size = 2;
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.cage_size = j;
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer Player, final World world,
        final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9,
        final float par10) {
        final int bid = 0;
        int dirx = 0;
        int dirz = 0;
        final int length;
        final int height;
        final int width = height = (length = this.cage_size / 2 + 1);
        if (cposx < 0) {
            dirx = -1;
        }
        if (cposz < 0) {
            dirz = -1;
        }
        final int x = (int) (Player.posX + 0.99 * dirx);
        final int y = (int) Player.posY - 1;
        final int z = (int) (Player.posZ + 0.99 * dirz);
        Player.worldObj.playSoundAtEntity(Player, "random.explode", 1.0f, 1.5f);
        if (world.isRemote) {
            return true;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k <= height + 1; ++k) {
                    if (k == height + 1) {
                        world.setBlock(x + i, y + k, z + j, Blocks.quartz_block);
                    } else if (k == 0) {
                        world.setBlock(x + i, y + k, z + j, Blocks.quartz_block);
                    } else if (i == width || j == length || i == -width || j == -length) {
                        world.setBlock(x + i, y + k, z + j, Blocks.glass);
                    } else {
                        world.setBlock(x + i, y + k, z + j, Blocks.air);
                    }
                }
            }
        }
        if (!Player.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
