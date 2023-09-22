
package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AntRobot;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ItemSpiderRobotKit extends Item {

    public ItemSpiderRobotKit(final int i) {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabTools);
        if (i == OreSpawnMain.BaseItemID + 471) {
            this.setMaxDamage(OreSpawnMain.SpiderRobot_stats.health);
        } else {
            this.setMaxDamage(OreSpawnMain.AntRobot_stats.health);
        }
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        final int par4, final int par5, final int par6, final int par7, final float par8, final float par9,
        final float par10) {
        if (par3World.isRemote) {
            return true;
        }
        String name = null;
        name = "Robot Spider";
        if (par1ItemStack.getItem() == OreSpawnMain.AntRobotKit) {
            name = "Robot Red Ant";
        }
        final Entity ent = spawnCreature(par3World, 0, name, par4 + 0.5, par5 + 1.01, par6 + 0.5);
        if (ent != null) {
            final EntityLiving e = (EntityLiving) ent;
            e.setHealth((float) (this.getMaxDamage() - this.getDamage(par1ItemStack)));
            if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
                ((EntityLiving) ent).setCustomNameTag(par1ItemStack.getDisplayName());
            }
            par3World
                .playSoundAtEntity(par2EntityPlayer, "random.explode", 1.0f, par3World.rand.nextFloat() * 0.2f + 0.9f);
            if (ent instanceof AntRobot) {
                final AntRobot a = (AntRobot) ent;
                a.setOwned();
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawnCreature(final World par0World, final int par1, final String name, final double par2,
        final double par4, final double par6) {
        Entity var8 = null;
        if (name == null) {
            var8 = EntityList.createEntityByID(par1, par0World);
        } else {
            var8 = EntityList.createEntityByName(name, par0World);
        }
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
