package fr.iamacat.dangerzone_iamacatfr.spawnable;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class CritterCage extends Item {

    private final int cageId;

    public CritterCage(int cageId) {
        super();
        this.cageId = cageId;
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            spawnCreature(world, cageId, null, player.posX, player.posY + 1.1, player.posZ);
            if (!player.capabilities.isCreativeMode) {
                itemStack.stackSize--;
            }
        }
        return itemStack;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side,
                             float hitX, float hitY, float hitZ) {
        // Handle placement logic here, if needed.
        return false;
    }

    public static Entity spawnCreature(World world, int entityId, String name, double x, double y, double z) {
        Entity entity = null;
        if (name == null) {
            entity = EntityList.createEntityByID(entityId, world);
        } else {
            entity = EntityList.createEntityByName(name, world);
        }

        if (entity instanceof EntityLiving) {
            EntityLiving entityLiving = (EntityLiving) entity;
            entityLiving.setLocationAndAngles(x, y, z, world.rand.nextFloat() * 360.0f, 0.0f);
            entityLiving.onSpawnWithEgg(null);
            entityLiving.playLivingSound();
        }

        if (entity != null) {
            if (!world.isRemote) {
                world.spawnEntityInWorld(entity);
            }
        }

        return entity;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(Tags.MODID + ":" + this.getUnlocalizedName().substring(5));
    }
}
