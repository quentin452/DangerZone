package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.ItemSword;

public class NightmareSword extends ItemSword {

    public NightmareSword(ToolMaterial material) {
        super(material);
        this.setTextureName(Tags.MODID + ":nightmaresword");
    }

    // damage
    @Override
    public float func_150931_i() {
        return 20f;
    }
}
