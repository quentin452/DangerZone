package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;
// todo make a model to make the item larger
public class AttitudeAdjuster extends ItemSword {
    public AttitudeAdjuster(Item.ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setTextureName(Tags.MODID + ":AttitudeAdjusterSword");
    }
}
