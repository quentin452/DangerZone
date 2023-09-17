package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.ItemSword;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

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
