package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CookedBacon extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 14;
    private static final float SATURATION_MODIFIER = 1.5f;
    private static final int EFFECT_DURATION = 100;

    public CookedBacon() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".cooked_bacon");
        this.setTextureName(Tags.MODID + ":cooked_bacon");
    }

    // Override the onFoodEaten method to add the specified effects
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        // Add the strength (ID: 5) and regeneration (ID: 10) effects
        player.addPotionEffect(new PotionEffect(5, EFFECT_DURATION * 20, 1)); // Strength
        player.addPotionEffect(new PotionEffect(10, EFFECT_DURATION * 20, 0)); // Regeneration
    }
}
