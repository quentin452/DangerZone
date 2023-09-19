package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class ButteredPopcorn extends ItemFood {

    // Définissez les constantes pour les propriétés de l'aliment
    private static final int HEALS_AMOUNT = 2;
    private static final float SATURATION_MODIFIER = 0.6f;

    public ButteredPopcorn() {
        // Utilisez les constantes pour définir les propriétés de l'aliment
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".buttered_popcorn");
        this.setTextureName(Tags.MODID + ":buttered_popcorn");
    }
}
