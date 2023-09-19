package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemFood;

public class Pizza extends ItemFood {

    // Définissez les constantes pour les propriétés de l'aliment par tranche
    private static final int HEALS_AMOUNT_PER_SLICE = 4;
    private static final float SATURATION_MODIFIER_PER_SLICE = 0.2f;

    public Pizza() {
        // Utilisez les constantes pour définir les propriétés de l'aliment par tranche
        super(HEALS_AMOUNT_PER_SLICE, SATURATION_MODIFIER_PER_SLICE, false);
        this.setUnlocalizedName(Tags.MODID + ".pizza");
        this.setTextureName(Tags.MODID + ":pizza");
    }
}
