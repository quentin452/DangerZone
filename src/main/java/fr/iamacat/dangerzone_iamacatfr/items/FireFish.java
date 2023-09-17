package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class FireFish extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 4;
    private static final float SATURATION_MODIFIER = 0.60f;

    public FireFish() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".fire_fish");
        this.setTextureName(Tags.MODID + ":fire_fish");
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        // Apply the Fire Resistance effect for about 60 seconds (3,000 ticks)
        player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 3000, 0));
        super.onEaten(stack, world, player);
        return stack;
    }
}
