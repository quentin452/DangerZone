package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ButterCandy extends ItemFood {

    // Définissez les constantes pour les propriétés de l'aliment
    private static final int HEALS_AMOUNT = 4;
    private static final float SATURATION_MODIFIER = 0.5f;

    public ButterCandy() {
        // Utilisez les constantes pour définir les propriétés de l'aliment
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".butter_candy");
        this.setTextureName(Tags.MODID + ":butter_candy");
    }
}
