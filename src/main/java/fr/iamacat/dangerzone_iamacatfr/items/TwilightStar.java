package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilicornArrowInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class TwilightStar extends Item {

    public TwilightStar(final int id) {
        this.setMaxStackSize(64);
        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setUnlocalizedName("twilightStar");
        this.setTextureName(Tags.MODID.toLowerCase() + ":twilightstar");
    }

    public boolean hasEffect(final ItemStack par1ItemStack) {
        return true;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        final double xzoff = 0.4;
        final double yoff = 1.25;
        final TwilicornArrowInstance lb = new TwilicornArrowInstance(par2World, par3EntityPlayer);
        lb.setLocationAndAngles(
            par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.posY + yoff,
            par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.rotationYawHead,
            par3EntityPlayer.rotationPitch);
        lb.motionX *= 1.8;
        lb.motionY *= 1.8;
        lb.motionZ *= 1.8;
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld(lb);
        }
        par1ItemStack.damageItem(1, par3EntityPlayer);
        return par1ItemStack;
    }
}
