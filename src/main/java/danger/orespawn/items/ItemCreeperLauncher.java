
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCreeperLauncher extends Item {

    public ItemCreeperLauncher(final int i) {
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setMaxDamage(1);
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity != null && entity instanceof EntityCreeper) {
            for (int var3 = 0; var3 < 6; ++var3) {
                float f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                float f2 = 0.25f + player.worldObj.rand.nextFloat() * 6.0f;
                float f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle(
                    "smoke",
                    ((float) entity.posX + f1),
                    ((float) entity.posY + f2),
                    ((float) entity.posZ + f3),
                    0.0,
                    (f2 / 4.0f),
                    0.0);
                f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 6.0f;
                f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle(
                    "explode",
                    ((float) entity.posX + f1),
                    ((float) entity.posY + f2),
                    ((float) entity.posZ + f3),
                    0.0,
                    (f2 / 4.0f),
                    0.0);
                f1 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                f2 = 0.25f + player.worldObj.rand.nextFloat() * 6.0f;
                f3 = player.worldObj.rand.nextFloat() - player.worldObj.rand.nextFloat();
                player.worldObj.spawnParticle(
                    "reddust",
                    ((float) entity.posX + f1),
                    ((float) entity.posY + f2),
                    ((float) entity.posZ + f3),
                    0.0,
                    (f2 / 4.0f),
                    0.0);
            }
            player.worldObj.playSoundAtEntity(player, "fireworks.launch", 2.0f, 1.2f);
            final EntityLiving e = (EntityLiving) entity;
            e.addVelocity(0.0, 4.5, 0.0);
            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
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
