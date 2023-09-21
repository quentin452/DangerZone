
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPizza extends Item {

    private Block spawnID;

    public ItemPizza(final int par1, final Block par2Block) {
        this.spawnID = par2Block;
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        int par4, int par5, int par6, int par7, final float par8, final float par9, final float par10) {
        final Block i1 = par3World.getBlock(par4, par5, par6);
        if (i1 == Blocks.snow && (par3World.getBlockMetadata(par4, par5, par6) & 0x7) < 1) {
            par7 = 1;
        } else if (i1 != Blocks.vine && i1 != Blocks.tallgrass && i1 != Blocks.deadbush) {
            if (par7 == 0) {
                --par5;
            }
            if (par7 == 1) {
                ++par5;
            }
            if (par7 == 2) {
                --par6;
            }
            if (par7 == 3) {
                ++par6;
            }
            if (par7 == 4) {
                --par4;
            }
            if (par7 == 5) {
                ++par4;
            }
        }
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        if (par1ItemStack.stackSize == 0) {
            return false;
        }
        if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, null, par1ItemStack)) {
            final int j1 = this.spawnID.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
            if (par3World.setBlock(par4, par5, par6, this.spawnID, j1, 3)) {
                if (par3World.getBlock(par4, par5, par6) == this.spawnID) {
                    this.spawnID.onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
                    this.spawnID.onPostBlockPlaced(par3World, par4, par5, par6, j1);
                }
                par3World.playSoundEffect(
                    (par4 + 0.5f),
                    (par5 + 0.5f),
                    (par6 + 0.5f),
                    this.spawnID.stepSound.getStepResourcePath(),
                    (this.spawnID.stepSound.getVolume() + 1.0f) / 2.0f,
                    this.spawnID.stepSound.getPitch() * 0.8f);
                --par1ItemStack.stackSize;
            }
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
