
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSparkFish extends ItemFood {

    public ItemSparkFish(final int par1, final int par2, final float par3, final boolean par4) {
        super(par2, par3, par4);
        this.setAlwaysEdible();
    }

    public void onFoodEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.isRemote) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 100, 0));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
