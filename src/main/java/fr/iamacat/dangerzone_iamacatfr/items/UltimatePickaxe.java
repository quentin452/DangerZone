package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UltimatePickaxe extends ItemPickaxe {
    public UltimatePickaxe(ToolMaterial p_i45347_1_) {
        super(p_i45347_1_);
        this.setTextureName(Tags.MODID + ":ultimatepickaxe");
    }
    private boolean enchantmentsAdded = false;

    public void onUpdate(final ItemStack stack, final World world, final Entity entity, final int i,
                         final boolean i2) {
        this.onUsingTick(stack, null, 0);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (!enchantmentsAdded) {
            stack.addEnchantment(Enchantment.efficiency, 5);
            stack.addEnchantment(Enchantment.fortune, 5);
            enchantmentsAdded = true;
        }
    }
}
