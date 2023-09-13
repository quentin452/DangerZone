package fr.iamacat.dangerzone_iamacatfr.spawnable;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class SpawnEggs extends Item {

    private final ResourceLocation texture;
    public Class<? extends Entity> entityClass;

    public SpawnEggs(Class<? extends Entity> entityClass) {
        this.entityClass = entityClass;
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMisc);
        texture = new ResourceLocation(Tags.MODID, "apple_cow_egg");
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        final int par4, final int par5, final int par6, final int par7, final float par8, final float par9,
        final float par10) {
        if (par3World.isRemote) {
            return true;
        }
        final Entity ent = spawner(this.entityClass, par3World, par4 + 0.5, par5 + 1.01, par6 + 0.5);
        if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
            ((EntityLiving) ent).setCustomNameTag(par1ItemStack.getDisplayName());
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawner(final Class<? extends Entity> entityClass, final World world, final double d0,
        final double d1, final double d2) {
        Entity ent = null;
        try {
            ent = entityClass.getConstructor(World.class)
                .newInstance(world);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ent != null) {
            ent.setLocationAndAngles(d0, d1, d2, world.rand.nextFloat() * 360.0f, 0.0f);
            world.spawnEntityInWorld(ent);
            if (ent instanceof EntityLiving) {
                ((EntityLiving) ent).playLivingSound();
            }
        }
        return ent;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(texture.toString());
    }
}
