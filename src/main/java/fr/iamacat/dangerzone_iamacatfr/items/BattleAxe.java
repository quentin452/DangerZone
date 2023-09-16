package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class BattleAxe extends ItemSword {
    private boolean hasUsedTick = false;

    public BattleAxe(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setTextureName(Tags.MODID + ":battleaxesmall");
    }

    @Override
    public void onUpdate(final ItemStack stack, final World world, final Entity entity, final int i,
                         final boolean i2) {
        if (!hasUsedTick) {
            this.onUsingTick(stack, null, 0);
            hasUsedTick = true; // Marquer que l'utilisation de la tick a eu lieu.
        }
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (!stack.getTagCompound().getBoolean("usedTick")) {
            stack.addEnchantment(Enchantment.looting, 3);
            stack.addEnchantment(Enchantment.unbreaking, 3);

            stack.getTagCompound().setBoolean("usedTick", true); // Marquer que l'utilisation de la tick a eu lieu.
        }
    }
}

