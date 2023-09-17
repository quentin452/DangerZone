package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class SparkFish extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 1;
    private static final float SATURATION_MODIFIER = 0.20f;

    public SparkFish() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".spark_fish");
        this.setTextureName(Tags.MODID + ":spark_fish");
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        // Apply the Fire Resistance effect for 5 seconds
        player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 5 * 20, 0));
        super.onEaten(stack, world, player);
        return stack;
    }

}
