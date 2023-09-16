package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemSword;

public class FairySword extends ItemSword {

    public FairySword(ToolMaterial material) {
        super(material);
        this.setTextureName(Tags.MODID + ":fairysword");
    }

    // damage
    @Override
    public float func_150931_i() {
        return 20f;
    }
}
