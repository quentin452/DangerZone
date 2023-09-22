
package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ItemSunFish extends ItemFood {

    public ItemSunFish(final int par1, final int par2, final float par3, final boolean par4) {
        super(par2, par3, par4);
        this.setAlwaysEdible();
    }

    public void onFoodEaten(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        super.onFoodEaten(par1ItemStack, par2World, par3EntityPlayer);
        if (!par2World.isRemote && this == OreSpawnMain.MySunFish) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 0));
        }
        if (!par2World.isRemote && this == OreSpawnMain.MyButterCandy) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 2000, 0));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 2000, 0));
        }
        if (!par2World.isRemote && this == OreSpawnMain.MyBacon) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 2000, 0));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 2000, 0));
        }
        if (!par2World.isRemote && this == OreSpawnMain.MyCrystalApple) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 3000, 0));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 3000, 0));
        }
        if (!par2World.isRemote && this == OreSpawnMain.MyLove) {
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.regeneration.id, 6000, 3));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 6000, 2));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 6000, 2));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.resistance.id, 6000, 1));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 5000, 0));
            par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.jump.id, 5000, 0));
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
