package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DarkCrystalCannonInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DarkCrystal extends Item {

    public DarkCrystal() {
        this.setMaxStackSize(64);
        this.setUnlocalizedName("DarkCrystal");
        this.setTextureName(Tags.MODID.toLowerCase() + ":darkcrystal");
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        final double xzoff = 0.4;
        final double yoff = 1.25;
        final DarkCrystalCannonInstance lb = new DarkCrystalCannonInstance(
            par2World,
            (EntityLivingBase) par3EntityPlayer);
        lb.setLocationAndAngles(
            par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.posY + yoff,
            par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 45.0f)),
            par3EntityPlayer.rotationYawHead,
            par3EntityPlayer.rotationPitch);
        final DarkCrystalCannonInstance darkCrystalCannon = lb;
        darkCrystalCannon.motionX *= 1.8;
        final DarkCrystalCannonInstance darkCrystalCannon2 = lb;
        darkCrystalCannon2.motionY *= 1.8;
        final DarkCrystalCannonInstance darkCrystalCannon3 = lb;
        darkCrystalCannon3.motionZ *= 1.8;
        if (!par2World.isRemote) {
            par2World.spawnEntityInWorld((Entity) lb);
        }
        return par1ItemStack;
    }
}
