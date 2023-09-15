package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CookedCornDog extends ItemFood {

    // Définissez les constantes pour les propriétés de l'aliment
    private static final int HEALS_AMOUNT = 14;
    private static final float SATURATION_MODIFIER = 1.5f;

    public CookedCornDog() {
        // Utilisez les constantes pour définir les propriétés de l'aliment
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".cooked_corn_dog");
        this.setTextureName(Tags.MODID + ":cooked_corn_dog");
    }
}
