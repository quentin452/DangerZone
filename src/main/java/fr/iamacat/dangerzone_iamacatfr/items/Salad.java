package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class Salad extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 10;
    private static final float SATURATION_MODIFIER = 0.95f;

    public Salad() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".salad");
        this.setTextureName(Tags.MODID + ":salad");
    }
}
