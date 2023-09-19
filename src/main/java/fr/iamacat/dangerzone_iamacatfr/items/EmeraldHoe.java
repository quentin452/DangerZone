package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemHoe;

public class EmeraldHoe extends ItemHoe {

    public EmeraldHoe(ToolMaterial material) {
        super(material);
        setTextureName(Tags.MODID + ":ultimatehoe");
    }

}
