

package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemDecoyDragonFood extends ItemFood
{
    private PotionEffect[] effects;

    public ItemDecoyDragonFood(final String unlocalizedName, final int healAmount, final float saturationModifier, final boolean wolvesFavorite, final PotionEffect... effects) {
        super(healAmount, saturationModifier, wolvesFavorite);
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(  Tags.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabFood);
        this.effects = effects;
    }

    protected void onFoodEaten(final ItemStack stack, final World world, final EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
        for (int i = 0; i < this.effects.length; ++i) {
            if (!world.isRemote && this.effects[i] != null && this.effects[i].getPotionID() > 0) {
                player.addPotionEffect(new PotionEffect(this.effects[i].getPotionID(), this.effects[i].getDuration(), this.effects[i].getAmplifier(), this.effects[i].getIsAmbient()));
            }
        }
    }
}
