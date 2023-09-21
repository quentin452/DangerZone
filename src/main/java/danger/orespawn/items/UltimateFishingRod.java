
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class UltimateFishingRod extends Item {

    public UltimateFishingRod(final int par1) {
        this.setMaxDamage(3000);
        this.setMaxStackSize(1);
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean isFull3D() {
        return true;
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.unbreaking, 2);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.unbreaking, 2);
        }
    }

    public boolean shouldRotateAroundWhenRendering() {
        return true;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (par3EntityPlayer.fishEntity != null) {
            final int var4 = par3EntityPlayer.fishEntity.func_146034_e();
            par1ItemStack.damageItem(var4, par3EntityPlayer);
            par3EntityPlayer.swingItem();
        } else {
            par2World.playSoundAtEntity(
                par3EntityPlayer,
                "random.bow",
                0.5f,
                0.4f / (UltimateFishingRod.itemRand.nextFloat() * 0.4f + 0.8f));
            if (!par2World.isRemote) {
                par2World.spawnEntityInWorld(new UltimateFishHook(par2World, par3EntityPlayer));
            }
            par3EntityPlayer.swingItem();
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
