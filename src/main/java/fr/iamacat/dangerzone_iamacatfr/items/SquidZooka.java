package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.item.Item;
// todo add model/render/entity Throwable
public class SquidZooka extends Item {
    public SquidZooka() {
        this.maxStackSize = 1;
        this.setTextureName(Tags.MODID + ":squidzookasmall");
    }
}
