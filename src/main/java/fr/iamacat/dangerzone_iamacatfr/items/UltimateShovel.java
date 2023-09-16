package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UltimateShovel extends ItemSpade {

    public UltimateShovel(ToolMaterial p_i45353_1_) {
        super(p_i45353_1_);
        this.setTextureName(Tags.MODID + ":ultimateshovel");
    }
    private boolean enchantmentsAdded = false;

    public void onUpdate(final ItemStack stack, final World world, final Entity entity, final int i,
                         final boolean i2) {
        this.onUsingTick(stack, null, 0);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (!enchantmentsAdded) {
            stack.addEnchantment(Enchantment.efficiency, 5);

            enchantmentsAdded = true;
        }
    }
}
