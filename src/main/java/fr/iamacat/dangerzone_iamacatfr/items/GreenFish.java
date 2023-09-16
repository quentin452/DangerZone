package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class GreenFish extends ItemFood {

    // Utilisez les mêmes valeurs que le poisson vanilla
    private static final int HEALS_AMOUNT = 2;
    private static final float SATURATION_MODIFIER = 0.1f;

    public GreenFish() {
        // Utilisez les constantes pour définir les propriétés de l'aliment
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".green_fish");
        this.setTextureName(Tags.MODID + ":green_fish");
    }
}
