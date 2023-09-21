
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.entities.entityinstance.DeadIrukandji;

public class ItemIrukandji extends Item {

    public ItemIrukandji(final int i) {
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 3.0f, 1.0f);
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld(new DeadIrukandji(par2World, par3EntityPlayer));
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
