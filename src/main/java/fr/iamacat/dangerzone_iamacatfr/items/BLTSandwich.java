package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class BLTSandwich extends ItemFood {

    private static final int HEALS_AMOUNT = 12;
    private static final float SATURATION_MODIFIER = 0.95f;

    public BLTSandwich() {
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".blt_sandwich");
        this.setTextureName(Tags.MODID + ":blt_sandwich");
    }
}
