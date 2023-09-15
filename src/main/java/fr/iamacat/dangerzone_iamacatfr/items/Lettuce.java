package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class Lettuce extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 3;
    private static final float SATURATION_MODIFIER = 0.45f;

    public Lettuce() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".lettuce");
        this.setTextureName(Tags.MODID + ":lettuce");
    }
}
