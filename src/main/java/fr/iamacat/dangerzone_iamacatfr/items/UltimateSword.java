package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class UltimateSword extends ItemSword {
    public UltimateSword(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setTextureName(Tags.MODID + ":ultimatesword");
    }
    private boolean enchantmentsAdded = false;

    public void onUpdate(final ItemStack stack, final World world, final Entity entity, final int i,
                         final boolean i2) {
        this.onUsingTick(stack, null, 0);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (!enchantmentsAdded) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.smite, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 5);
            stack.addEnchantment(Enchantment.knockback, 3);
            stack.addEnchantment(Enchantment.looting, 3);
            stack.addEnchantment(Enchantment.unbreaking, 3);
            stack.addEnchantment(Enchantment.fireAspect, 2);

            enchantmentsAdded = true;
        }
    }
}
