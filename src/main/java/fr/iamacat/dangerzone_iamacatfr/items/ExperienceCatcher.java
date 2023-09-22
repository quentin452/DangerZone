
package fr.iamacat.dangerzone_iamacatfr.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ExperienceCatcher extends Item {

    public ExperienceCatcher(final int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabTools);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world,
        final int x, final int y, final int z, final int par7, final float par8, final float par9, final float par10) {
        par2EntityPlayer.swingItem();
        System.out.printf("x, y,z, 7,8,9,10 == %d, %d, %d - %d, %f, %f, %f\n", x, y, z, par7, par8, par9, par10);
        if (!par2EntityPlayer.worldObj.isRemote) {
            final AxisAlignedBB bb = AxisAlignedBB
                .getBoundingBox(x - 0.5 + par8, y, z - 0.5 + par10, x + 0.5 + par8, y + 2.0, z + 0.5 + par10);
            final List var5 = world.getEntitiesWithinAABB(EntityXPOrb.class, bb);
            for (final Object var7 : var5) {
                if (var7 instanceof EntityXPOrb) {
                    final EntityXPOrb ex = (EntityXPOrb) var7;
                    if (ex.getXpValue() < 3) {
                        continue;
                    }
                    if (world.rand.nextInt(5) == 1) {
                        continue;
                    }
                    ((EntityXPOrb) var7).setDead();
                    EntityItem var8 = null;
                    ItemStack is = new ItemStack(Items.experience_bottle, 1, 0);
                    var8 = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0, (par10 + z), is);
                    if (var8 != null) {
                        par2EntityPlayer.worldObj.spawnEntityInWorld(var8);
                    }
                    is = new ItemStack(Items.string, 1, 0);
                    var8 = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0, (par10 + z), is);
                    if (var8 != null) {
                        par2EntityPlayer.worldObj.spawnEntityInWorld(var8);
                    }
                    is = new ItemStack(Items.stick, 1, 0);
                    var8 = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0, (par10 + z), is);
                    if (var8 != null) {
                        par2EntityPlayer.worldObj.spawnEntityInWorld(var8);
                    }
                    if (!par2EntityPlayer.capabilities.isCreativeMode) {
                        --par1ItemStack.stackSize;
                    }
                    return true;
                }
            }
            EntityItem var9 = null;
            final ItemStack is2 = new ItemStack(OreSpawnMain.MyExperienceCatcher, 1, 0);
            var9 = new EntityItem(par2EntityPlayer.worldObj, (par8 + x), y + 1.0, (par10 + z), is2);
            if (var9 != null) {
                par2EntityPlayer.worldObj.spawnEntityInWorld(var9);
            }
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        par3EntityPlayer.swingItem();
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
