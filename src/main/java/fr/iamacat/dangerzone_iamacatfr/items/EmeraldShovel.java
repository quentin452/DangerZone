package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmeraldShovel extends ItemSpade {

    public EmeraldShovel(ToolMaterial p_i45353_1_) {
        super(p_i45353_1_);
        this.setTextureName(Tags.MODID + ":ultimateshovel");
    }


}
