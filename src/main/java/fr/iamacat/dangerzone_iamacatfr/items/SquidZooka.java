package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AttackSquidInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class SquidZooka extends Item {

    public SquidZooka() {
        this.maxStackSize = 1;
        this.setMaxDamage(100);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (par1ItemStack.getMaxDamage() - par1ItemStack.getItemDamage() <= 1) {
            return par1ItemStack;
        }
        par2World.playSoundAtEntity(par3EntityPlayer, "random.explode", 0.5f, 0.5f);
        if (!par2World.isRemote) {
            final double xzoff = 2.5;
            final double yoff = 1.65;
            final Entity e = spawnCreature(
                par2World,
                "Attack Squid",
                par3EntityPlayer.posX - xzoff * Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead + 15.0f)),
                par3EntityPlayer.posY + yoff,
                par3EntityPlayer.posZ + xzoff * Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead + 15.0f)));
            if (e instanceof AttackSquidInstance) {
                final AttackSquidInstance a = (AttackSquidInstance) e;
                a.setWasShot();
            }
            final float f = 3.6f;
            e.motionX = -MathHelper.sin(par3EntityPlayer.rotationYaw / 180.0f * 3.1415927f)
                * MathHelper.cos(par3EntityPlayer.rotationPitch / 180.0f * 3.1415927f)
                * f;
            e.motionZ = MathHelper.cos(par3EntityPlayer.rotationYaw / 180.0f * 3.1415927f)
                * MathHelper.cos(par3EntityPlayer.rotationPitch / 180.0f * 3.1415927f)
                * f;
            e.motionY = -MathHelper.sin(par3EntityPlayer.rotationPitch / 180.0f * 3.1415927f) * f;
            final Entity entity = e;
            entity.motionX += (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05;
            final Entity entity2 = e;
            entity2.motionY += (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05;
            final Entity entity3 = e;
            entity3.motionZ += (par2World.rand.nextFloat() - par2World.rand.nextFloat()) * 0.05;
        }
        par3EntityPlayer.swingItem();
        par3EntityPlayer.addVelocity(
            Math.cos(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 0.45,
            0.1,
            Math.sin(Math.toRadians(par3EntityPlayer.rotationYawHead - 90.0f)) * 0.45);
        par1ItemStack.damageItem(1, par3EntityPlayer);
        return par1ItemStack;
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
        }
        return var8;
    }

    public String getMaterialName() {
        return "Unknown";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
