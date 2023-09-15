package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class Tomato extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 4;
    private static final float SATURATION_MODIFIER = 0.55f;

    public Tomato() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".tomato");
        this.setTextureName(Tags.MODID + ":tomato");
    }
}
