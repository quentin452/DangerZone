package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class Butter extends ItemFood {

    private static final int HEALS_AMOUNT = 1;
    private static final float SATURATION_MODIFIER = 0.5f;

    public Butter() {
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".butter");
        this.setTextureName(Tags.MODID + ":butter");
    }
}
