package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.UltimateArrow;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Random;

public class UltimateBow extends Item {

    public UltimateBow() {
        this.maxStackSize = 1;
        this.setMaxDamage(1000);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.power, 5);
        par1ItemStack.addEnchantment(Enchantment.flame, 3);
        par1ItemStack.addEnchantment(Enchantment.punch, 2);
        par1ItemStack.addEnchantment(Enchantment.infinity, 1);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.power, 5);
            stack.addEnchantment(Enchantment.flame, 3);
            stack.addEnchantment(Enchantment.punch, 2);
            stack.addEnchantment(Enchantment.infinity, 1);
        }
    }

    public void onPlayerStoppedUsing(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer, final int par4) {
        Random rand = new Random();
        final EntityArrow var8 = (EntityArrow) new UltimateArrow(par2World, par3EntityPlayer, 3.0f);
        if (par2World.rand.nextInt(4) == 1) {
            var8.setIsCritical(true);
        }
        final int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);
        if (var9 > 0) {
            var8.setKnockbackStrength(var9);
        }
        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0) {
            var8.setFire(100);
        }
        par1ItemStack.damageItem(1, par3EntityPlayer);
        par2World.playSoundAtEntity(
            par3EntityPlayer,
            "random.bow",
            1.0f,
            1.0f / (rand.nextFloat() * 0.4f + 1.2f)
                + 0.5f);
        var8.canBePickedUp = 2;
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld(var8);
        }
    }

    public ItemStack onFoodEaten(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        return par1ItemStack;
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 9000;
    }

    public EnumAction getItemUseAction(final ItemStack par1ItemStack) {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        return par1ItemStack;
    }

    public int getItemEnchantability() {
        return 50;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
