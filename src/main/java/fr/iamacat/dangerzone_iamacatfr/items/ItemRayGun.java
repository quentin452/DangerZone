
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.LaserBall;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRayGun extends Item {

    public ItemRayGun(final int i) {
        this.maxStackSize = 1;
        this.setMaxDamage(50);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
            return par1ItemStack;
        }
        par2World.playSoundAtEntity(par3EntityPlayer, "fireworks.launch", 3.5f, 0.5f);
        if (!par2World.isRemote) {
            final double xzoff = 1.0;
            final double yoff = 1.55;
            final LaserBall lb = new LaserBall(par2World, par3EntityPlayer);
            lb.setSpecial();
            lb.setLocationAndAngles(
                par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
                par3EntityPlayer.posY + yoff,
                par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
                par3EntityPlayer.rotationYawHead,
                par3EntityPlayer.rotationPitch);
            final LaserBall laserBall = lb;
            laserBall.motionX *= 3.0;
            final LaserBall laserBall2 = lb;
            laserBall2.motionY *= 3.0;
            final LaserBall laserBall3 = lb;
            laserBall3.motionZ *= 3.0;
            par2World.spawnEntityInWorld(lb);
        }
        par3EntityPlayer.swingItem();
        par3EntityPlayer.addVelocity(
            Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 1.5,
            0.3,
            Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 1.5);
        par1ItemStack.damageItem(1, par3EntityPlayer);
        return par1ItemStack;
    }

    public String getMaterialName() {
        return "Unknown";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"+ this.getUnlocalizedName()
                .substring(5));
    }
}
