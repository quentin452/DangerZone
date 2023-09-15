package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSword;


public class RatSword extends ItemSword {
    public RatSword(ToolMaterial material) {
        super(material);
        this.setTextureName(Tags.MODID + ":ratsword");

    }
    // damage
    @Override
    public float func_150931_i() {
        return 10f;
    }
}
