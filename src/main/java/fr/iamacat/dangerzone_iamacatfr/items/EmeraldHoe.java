package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemHoe;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EmeraldHoe extends ItemHoe {

    public EmeraldHoe(ToolMaterial material) {
        super(material);
        setTextureName(Tags.MODID + ":ultimatehoe");
    }

}
