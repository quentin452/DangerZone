package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CrabbyPatty extends ItemFood {

    // Define constants for the food properties
    private static final int HEALS_AMOUNT = 16;
    private static final float SATURATION_MODIFIER = 2.35f;

    public CrabbyPatty() {
        // Use the constants to set the food properties
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".crabby_patty");
        this.setTextureName(Tags.MODID + ":crabby_patty");
    }
}
