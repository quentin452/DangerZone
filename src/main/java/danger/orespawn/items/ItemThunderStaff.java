
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.entities.entityinstance.ThunderBolt;

public class ItemThunderStaff extends Item {

    private int ticker;

    public ItemThunderStaff(final int i) {
        this.ticker = 50;
        this.maxStackSize = 1;
        this.setMaxDamage(50);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
            return par1ItemStack;
        }
        final double xzoff = 1.0;
        final double yoff = 1.55;
        final ThunderBolt lb = new ThunderBolt(par2World, par3EntityPlayer);
        lb.setLocationAndAngles(
            par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.posY + yoff,
            par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.rotationYawHead,
            par3EntityPlayer.rotationPitch);
        final ThunderBolt thunderBolt = lb;
        thunderBolt.motionX *= 3.0;
        final ThunderBolt thunderBolt2 = lb;
        thunderBolt2.motionY *= 3.0;
        final ThunderBolt thunderBolt3 = lb;
        thunderBolt3.motionZ *= 3.0;
        par2World.spawnEntityInWorld(lb);
        par3EntityPlayer.swingItem();
        par3EntityPlayer.addVelocity(
            Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 0.5,
            0.15,
            Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 0.5);
        par1ItemStack.damageItem(1, par3EntityPlayer);
        return par1ItemStack;
    }

    public void onUpdate(final ItemStack par1ItemStack, final World world, final Entity par3Entity, final int par4,
        final boolean par5) {
        if (world.isRaining() && world.isThundering()) {
            if (this.ticker > 0) {
                --this.ticker;
            }
            if (this.ticker <= 0 && par1ItemStack.getItemDamage() > 0) {
                par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
                this.ticker = 50;
            }
        }
    }

    public String getMaterialName() {
        return "Unknown";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
