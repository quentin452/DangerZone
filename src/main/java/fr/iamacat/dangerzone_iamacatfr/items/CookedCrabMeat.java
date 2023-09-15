package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class CookedCrabMeat extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 6;
    private static final float SATURATION_MODIFIER = 0.74f;

    public CookedCrabMeat() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".cooked_crab_meat");
        this.setTextureName(Tags.MODID + ":cooked_crab_meat");
    }
}
