package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.TwilicornArrow;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class TwilightStar extends Item {

    public TwilightStar() {
        this.setMaxStackSize(64);
        this.setUnlocalizedName("TwilightStar");
        this.setTextureName(Tags.MODID.toLowerCase() + ":twilightstar");
    }

    public boolean hasEffect(final ItemStack par1ItemStack) {
        return true;
    }

    public int getItemEnchantability() {
        return 0;
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 0;
    }

    public float getStrVsBlock(final ItemStack par1ItemStack, final Block par2Block) {
        return 1.0f;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        final double xzoff = 0.4;
        final double yoff = 1.25;
        final TwilicornArrow lb = new TwilicornArrow(par2World, (EntityLivingBase) par3EntityPlayer);
        lb.setLocationAndAngles(
            par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.posY + yoff,
            par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.rotationYawHead,
            par3EntityPlayer.rotationPitch);
        final TwilicornArrow twilicornArrow = lb;
        twilicornArrow.motionX *= 1.8;
        final TwilicornArrow twilicornArrow2 = lb;
        twilicornArrow2.motionY *= 1.8;
        final TwilicornArrow twilicornArrow3 = lb;
        twilicornArrow3.motionZ *= 1.8;
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity) lb);
        }
        par1ItemStack.damageItem(1, (EntityLivingBase) par3EntityPlayer);
        return par1ItemStack;
    }
}
