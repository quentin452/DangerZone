package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class UltimatePickaxe extends ItemPickaxe {
    public UltimatePickaxe(ToolMaterial p_i45347_1_) {
        super(p_i45347_1_);
        this.setTextureName(Tags.MODID + ":ultimatepickaxe");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.efficiency, 5);
            stack.addEnchantment(Enchantment.fortune, 5);
        }
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.efficiency, 5);
            stack.addEnchantment(Enchantment.fortune, 5);
        }
        return super.onEntitySwing(entityLiving, stack);
    }
    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.efficiency, 5);
            stack.addEnchantment(Enchantment.fortune, 5);
        }
    }

}
