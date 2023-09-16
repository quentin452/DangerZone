package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RubyAxe extends ItemAxe {
    public RubyAxe(ToolMaterial p_i45327_1_) {
        super(p_i45327_1_);
        this.setTextureName(Tags.MODID + ":rubyaxe");
    }
}
