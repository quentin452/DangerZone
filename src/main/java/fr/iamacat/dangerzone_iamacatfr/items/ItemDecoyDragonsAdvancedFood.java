
package fr.iamacat.dangerzone_iamacatfr.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ItemDecoyDragonsAdvancedFood extends ItemFood {

    private List<PotionEffect> effects;
    private List<Double> propabilities;

    public ItemDecoyDragonsAdvancedFood(final String unlocalizedName, final int healAmount,
        final float saturationModifier, final boolean wolvesFavorite) {
        super(healAmount, saturationModifier, wolvesFavorite);
        this.effects = new ArrayList<PotionEffect>();
        this.propabilities = new ArrayList<Double>();
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Tags.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabFood);
    }

    protected void onFoodEaten(final ItemStack stack, final World world, final EntityPlayer player) {
        super.onFoodEaten(stack, world, player);
        for (int i = 0; i < this.effects.size(); ++i) {
            if (!world.isRemote && this.effects.get(i) != null
                && this.effects.get(i)
                    .getPotionID() > 0
                && Math.random() < this.propabilities.get(i)) {
                player.addPotionEffect(
                    new PotionEffect(
                        this.effects.get(i)
                            .getPotionID(),
                        this.effects.get(i)
                            .getDuration(),
                        this.effects.get(i)
                            .getAmplifier(),
                        this.effects.get(i)
                            .getIsAmbient()));
            }
        }
    }

    public ItemDecoyDragonsAdvancedFood addPotionEffect(final PotionEffect effect, final double propability) {
        this.effects.add(effect);
        this.propabilities.add(propability);
        return this;
    }

    public ItemDecoyDragonsAdvancedFood addPotionEffect(final PotionEffect effect) {
        return this.addPotionEffect(effect, 1.0);
    }

    public ItemDecoyDragonsAdvancedFood removePotionEffect(final PotionEffect effect) {
        final int index = this.effects.indexOf(effect);
        if (index == -1) {
            return this;
        }
        this.effects.remove(index);
        this.propabilities.remove(index);
        return this;
    }
}
