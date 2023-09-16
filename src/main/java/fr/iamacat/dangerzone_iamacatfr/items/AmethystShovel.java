package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class AmethystShovel extends ItemSpade {

    public AmethystShovel(ToolMaterial p_i45353_1_) {
        super(p_i45353_1_);
        this.setTextureName(Tags.MODID + ":amethystshovel");
    }
}
