
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemZooKeeper extends Item {

    public ItemZooKeeper(final int i) {
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(1);
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        for (int var3 = 0; var3 < 8; ++var3) {
            float f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
            float f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
            float f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
            player.worldObj.spawnParticle(
                "smoke",
                ((float) entity.posX + f1),
                ((float) entity.posY + f2),
                ((float) entity.posZ + f3),
                0.0,
                0.0,
                0.0);
            f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
            f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
            f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
            player.worldObj.spawnParticle(
                "explode",
                ((float) entity.posX + f1),
                ((float) entity.posY + f2),
                ((float) entity.posZ + f3),
                0.0,
                0.0,
                0.0);
            f1 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
            f2 = 0.25f + player.worldObj.rand.nextFloat() * 2.0f;
            f3 = player.worldObj.rand.nextFloat() * 3.0f - player.worldObj.rand.nextFloat() * 3.0f;
            player.worldObj.spawnParticle(
                "reddust",
                ((float) entity.posX + f1),
                ((float) entity.posY + f2),
                ((float) entity.posZ + f3),
                0.0,
                0.0,
                0.0);
        }
        player.worldObj.playSoundAtEntity(player, "random.explode", 0.5f, 1.5f);
        if (entity != null && entity instanceof EntityLiving) {
            final EntityLiving e = (EntityLiving) entity;
            e.func_110163_bv();
            stack.damageItem(2, player);
            if (stack.stackSize <= 0) {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
            }
            return true;
        }
        return false;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
