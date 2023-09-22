package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.MavisBallInstance;

public class MavisOrb extends Item {

    public MavisOrb() {
        this.maxStackSize = 64;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        final double xzoff = 0.4;
        final double yoff = 1.25;
        final MavisBallInstance lb = new MavisBallInstance(par2World, par3EntityPlayer);
        lb.setLocationAndAngles(
            par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.posY + yoff,
            par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.rotationYawHead,
            par3EntityPlayer.rotationPitch);
        final MavisBallInstance mavisBall = lb;
        mavisBall.motionX *= 1.8;
        final MavisBallInstance mavisBall2 = lb;
        mavisBall2.motionY *= 1.8;
        final MavisBallInstance mavisBall3 = lb;
        mavisBall3.motionZ *= 1.8;
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity) lb);
        }
        par1ItemStack.damageItem(1, (EntityLivingBase) par3EntityPlayer);
        return par1ItemStack;
    }
}
