package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CrystalApple extends ItemFood {

    public static final Item crystalApple = (Item) Item.itemRegistry.getObject("crystalApple");

    public CrystalApple(int p_i45339_1_, float p_i45339_2_, boolean p_i45339_3_) {
        super(p_i45339_1_, p_i45339_2_, p_i45339_3_);
        this.setTextureName(Tags.MODID + ":crystal_apple");
    }
}
