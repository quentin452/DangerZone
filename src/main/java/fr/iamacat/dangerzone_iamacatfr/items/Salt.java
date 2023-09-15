package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class Salt extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 1;
    private static final float SATURATION_MODIFIER = 0.5f;

    public Salt() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".salt");
        this.setTextureName(Tags.MODID + ":salt");
    }
}
