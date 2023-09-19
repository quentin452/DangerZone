package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class UltimateBow extends ItemBow {

    // todo fix cannot throw IrukandjiArrows
    // todo make sure that the UltimateBow can send arrows without charging at full the bow
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;

    public UltimateBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(100);
    }

    public void onPlayerStoppedUsing(final ItemStack itemStack, final World world, final EntityPlayer entityPlayer,
        final int par4) {
        final int var6 = this.getMaxItemUseDuration(itemStack) - par4;
        final boolean flag = entityPlayer.capabilities.isCreativeMode
            || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemStack) > 0;
        if (flag || entityPlayer.inventory.hasItem(Items.arrow)) {
            float f = var6 / 20.0f;
            f = (f * f + f * 2.0f) / 3.0f;
            if (f < 0.1) {
                return;
            }
            if (f > 1.75f) {
                f = 1.75f;
            }
            final IrukandjiArrows var7 = new IrukandjiArrows(world);
            if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, itemStack) > 0) {
                var7.setFire(100);
            }
            itemStack.damageItem(1, entityPlayer);
            world.playSoundAtEntity(
                entityPlayer,
                "random.bow",
                1.0f,
                1.0f / (UltimateBow.itemRand.nextFloat() * 0.4f + 1.2f) + 0.5f);
            if (!flag) {
                entityPlayer.inventory.consumeInventoryItem(Items.arrow);
            }
            if (!world.isRemote) {
                world.spawnEntityInWorld(var7);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Tags.MODID + ":ultimatebow");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side,
        float hitX, float hitY, float hitZ) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.power, 5);
            stack.addEnchantment(Enchantment.flame, 3);
            stack.addEnchantment(Enchantment.punch, 2);
            stack.addEnchantment(Enchantment.infinity, 1);
        }
        return super.onItemUse(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.power, 5);
            stack.addEnchantment(Enchantment.flame, 3);
            stack.addEnchantment(Enchantment.punch, 2);
            stack.addEnchantment(Enchantment.infinity, 1);
        }
        return super.onEntitySwing(entityLiving, stack);
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if (!stack.isItemEnchanted()) {
            stack.addEnchantment(Enchantment.power, 5);
            stack.addEnchantment(Enchantment.flame, 3);
            stack.addEnchantment(Enchantment.punch, 2);
            stack.addEnchantment(Enchantment.infinity, 1);
        }
    }

}
