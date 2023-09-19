package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.PhoenixArrowInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class PhoenixFeather extends Item {

    public PhoenixFeather() {
        this.setMaxStackSize(64);
        this.setUnlocalizedName("PhoenixFeather");
        this.setTextureName(Tags.MODID.toLowerCase() + ":phoenixfeather");
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
        final PhoenixArrowInstance lb = new PhoenixArrowInstance(par2World, (EntityLivingBase) par3EntityPlayer);
        lb.setLocationAndAngles(
            par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.posY + yoff,
            par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.rotationYawHead,
            par3EntityPlayer.rotationPitch);
        final PhoenixArrowInstance phoenixArrow = lb;
        phoenixArrow.motionX *= 1.8;
        final PhoenixArrowInstance phoenixArrow2 = lb;
        phoenixArrow2.motionY *= 1.8;
        final PhoenixArrowInstance phoenixArrow3 = lb;
        phoenixArrow3.motionZ *= 1.8;
        par2World.spawnEntityInWorld((Entity) lb);
        par1ItemStack.damageItem(1, (EntityLivingBase) par3EntityPlayer);
        return par1ItemStack;
    }
}
