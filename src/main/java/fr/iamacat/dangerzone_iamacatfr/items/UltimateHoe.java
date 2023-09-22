
package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class UltimateHoe extends ItemHoe {

    public UltimateHoe(final int par1, final ToolMaterial par2) {
        super(par2);
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.efficiency, 2);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.efficiency.effectId, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.efficiency, 2);
        }
    }

    public void onUpdate(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4,
        final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        final int par4, final int par5, final int par6, final int par7, final float par8, final float par9,
        final float par10) {
        if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack)) {
            return false;
        }
        Block i1 = par3World.getBlock(par4, par5, par6);
        boolean air = par3World.isAirBlock(par4, par5 + 1, par6);
        if (par7 == 0 || !air || (i1 != Blocks.grass && i1 != Blocks.dirt)) {
            return false;
        }
        final Block block = Blocks.farmland;
        par3World.playSoundEffect(
            (par4 + 0.5f),
            (par5 + 0.5f),
            (par6 + 0.5f),
            block.stepSound.getBreakSound(),
            (block.stepSound.getVolume() + 1.0f) / 2.0f,
            block.stepSound.getPitch() * 0.8f);
        if (par3World.isRemote) {
            return true;
        }
        for (int j = -1; j <= 1; ++j) {
            for (int k = -1; k <= 1; ++k) {
                for (int l = -1; l <= 1; ++l) {
                    i1 = par3World.getBlock(par4 + j, par5 + l, par6 + k);
                    air = par3World.isAirBlock(par4 + j, par5 + l + 1, par6 + k);
                    if (air && (i1 == Blocks.grass || i1 == Blocks.dirt)) {
                        par3World.setBlock(par4 + j, par5 + l, par6 + k, block, 7, 2);
                    }
                }
            }
        }
        par1ItemStack.damageItem(1, par2EntityPlayer);
        return true;
    }

    public String getMaterialName() {
        return "Uranium/Titanium";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
