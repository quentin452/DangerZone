package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class RawBacon extends ItemFood {

    // Définissez les constantes pour les modifications souhaitées
    private static final int HEALS_AMOUNT = 8;
    private static final float SATURATION_MODIFIER = 1.0f;

    public RawBacon() {
        // Utilisez les constantes pour définir les propriétés de l'aliment
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".raw_bacon");
        this.setTextureName(Tags.MODID + ":raw_bacon");
    }
}
