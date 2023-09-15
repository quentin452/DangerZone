package fr.iamacat.dangerzone_iamacatfr.spawnable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SpawnEggs extends Item {

    public Class<? extends Entity> entityClass;

    public SpawnEggs(Class<? extends Entity> entityClass) {
        this.entityClass = entityClass;
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        final int par4, final int par5, final int par6, final int par7, final float par8, final float par9,
        final float par10) {
        if (par3World.isRemote) {
            return true;
        }

        // Calculate the new spawn location based on the side clicked (par7)
        double x = par4 + 0.5;
        double y = par5 + 1.01;
        double z = par6 + 0.5;

        if (par7 == 0) { // Bottom side
            y -= 1.0;
        } else if (par7 == 1) { // Top side
            y += 1.0;
        } else if (par7 == 2) { // North side
            z -= 1.0;
        } else if (par7 == 3) { // South side
            z += 1.0;
        } else if (par7 == 4) { // West side
            x -= 1.0;
        } else if (par7 == 5) { // East side
            x += 1.0;
        }

        // Adjust the y-coordinate for the top side
        if (par7 == 1) {
            y += 1.0;
        }

        final Entity ent = spawner(this.entityClass, par3World, x, y, z);
        if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
            ((EntityLiving) ent).setCustomNameTag(par1ItemStack.getDisplayName());
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawner(Class<? extends Entity> entityClass, World world, double x, double y, double z) {
        Entity ent = null;
        try {
            ent = entityClass.getConstructor(World.class)
                .newInstance(world);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ent != null) {

            ent.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360.0f, 0.0f);
            world.spawnEntityInWorld(ent);

        }

        return ent;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        String textureName = getEntityTextureName(entityClass);
        itemIcon = iconRegister.registerIcon(textureName);
    }

    private String getEntityTextureName(Class<? extends Entity> entityClass) {
        String entityClassName = entityClass.getSimpleName();

        // Remove the "Instance" suffix if it's present
        if (entityClassName.endsWith("Instance")) {
            entityClassName = entityClassName.substring(0, entityClassName.length() - "Instance".length());
        }

        // Convert to lowercase and add the "egg" prefix
        String lowerCaseEntityClassName = entityClassName.toLowerCase();
        return Tags.MODID + ":" + "egg" + lowerCaseEntityClassName;
    }
}
