package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

// todo fix reach + make a model to make the item larger
public class SliceSword extends ItemSword {

    private final float field_150934_a;

    public SliceSword(ToolMaterial p_i45356_1_) {
        super(p_i45356_1_);
        this.setTextureName(Tags.MODID + ":Slicesword");
        this.field_150934_a = 8.0F + p_i45356_1_.getDamageVsEntity();
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
        return super.onEntitySwing(entityLiving, stack);
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
    }

    public Multimap getItemAttributeModifiers() {
        Multimap multimap = super.getItemAttributeModifiers();
        multimap.put(
            SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(),
            new AttributeModifier(field_111210_e, "Weapon modifier", this.field_150934_a, 0));
        return multimap;
    }
}
