package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class UltimateSword extends ItemSword {
    public UltimateSword(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setTextureName(Tags.MODID + ":ultimatesword");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.smite, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 5);
            stack.addEnchantment(Enchantment.knockback, 3);
            stack.addEnchantment(Enchantment.looting, 3);
            stack.addEnchantment(Enchantment.unbreaking, 3);
            stack.addEnchantment(Enchantment.fireAspect, 2);
        }
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.smite, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 5);
            stack.addEnchantment(Enchantment.knockback, 3);
            stack.addEnchantment(Enchantment.looting, 3);
            stack.addEnchantment(Enchantment.unbreaking, 3);
            stack.addEnchantment(Enchantment.fireAspect, 2);
        }
        return super.onEntitySwing(entityLiving, stack);
    }
    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.smite, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 5);
            stack.addEnchantment(Enchantment.knockback, 3);
            stack.addEnchantment(Enchantment.looting, 3);
            stack.addEnchantment(Enchantment.unbreaking, 3);
            stack.addEnchantment(Enchantment.fireAspect, 2);
        }
    }

}
