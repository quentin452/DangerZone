package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CreeperLauncher extends Item {

    public CreeperLauncher() {
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setMaxDamage(1);
        this.setTextureName(Tags.MODID + ":creeperlauncher");
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity instanceof EntityCreeper) {
            World world = player.worldObj;
            for (int i = 0; i < 3; i++) {
                float f1 = world.rand.nextFloat() - world.rand.nextFloat();
                float f2 = 0.25f + world.rand.nextFloat() * 6.0f;
                float f3 = world.rand.nextFloat() - world.rand.nextFloat();
                spawnParticle(world, "smoke", entity.posX + f1, entity.posY + f2, entity.posZ + f3);
                spawnParticle(world, "explode", entity.posX + f1, entity.posY + f2, entity.posZ + f3);
                spawnParticle(world, "reddust", entity.posX + f1, entity.posY + f2, entity.posZ + f3);
            }
            world.playSoundAtEntity(player, "fireworks.launch", 2.0f, 1.2f);
            EntityLiving e = (EntityLiving) entity;
            e.addVelocity(0.0, 4.5, 0.0);
            if (!player.capabilities.isCreativeMode) {
                stack.stackSize--;
            }
            return true;
        }
        return false;
    }

    private void spawnParticle(World world, String particleName, double posX, double posY, double posZ) {
        world.spawnParticle(particleName, posX, posY, posZ, 0.0, 0.25, 0.0);
    }
}
