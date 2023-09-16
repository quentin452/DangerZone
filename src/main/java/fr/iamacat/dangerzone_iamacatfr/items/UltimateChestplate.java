package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UltimateChestplate extends ItemArmor {
    public UltimateChestplate(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
        super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
        this.setTextureName(Tags.MODID + ":ultimate_chest");

    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        return Tags.MODID + ":textures/model/armors/ultimate_1.png";
    }
    private boolean enchantmentsAdded = false;

    public void onUpdate(final ItemStack stack, final World world, final Entity entity, final int i,
                         final boolean i2) {
        this.onUsingTick(stack, null, 0);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (!enchantmentsAdded) {
            stack.addEnchantment(Enchantment.protection, 5);
            stack.addEnchantment(Enchantment.fireProtection, 5);
            stack.addEnchantment(Enchantment.blastProtection, 5);
            stack.addEnchantment(Enchantment.projectileProtection, 5);
            enchantmentsAdded = true;
        }
    }
}
