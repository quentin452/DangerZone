package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MobzillaHelmet extends ItemArmor {
    public MobzillaHelmet(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
        super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
        this.setTextureName(Tags.MODID + ":mobzilla_helmet");

    }
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        return Tags.MODID + ":textures/model/armors/mobzilla_1.png";
    }


    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.protection, 10);
            stack.addEnchantment(Enchantment.fireProtection, 10);
            stack.addEnchantment(Enchantment.blastProtection, 10);
            stack.addEnchantment(Enchantment.projectileProtection, 10);
            stack.addEnchantment(Enchantment.unbreaking, 5);
        }
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.protection, 10);
            stack.addEnchantment(Enchantment.fireProtection, 10);
            stack.addEnchantment(Enchantment.blastProtection, 10);
            stack.addEnchantment(Enchantment.projectileProtection, 10);
            stack.addEnchantment(Enchantment.unbreaking, 5);
        }
        return super.onEntitySwing(entityLiving, stack);
    }
    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.protection, 10);
            stack.addEnchantment(Enchantment.fireProtection, 10);
            stack.addEnchantment(Enchantment.blastProtection, 10);
            stack.addEnchantment(Enchantment.projectileProtection, 10);
            stack.addEnchantment(Enchantment.unbreaking, 5);
        }
    }

}
