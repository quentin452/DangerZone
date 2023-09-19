package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.LaserBallInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LaserCharge extends Item {

    public LaserCharge() {
        this.maxStackSize = 64;
        this.setTextureName(Tags.MODID + ":laserball");
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity(entityPlayer, "fireworks.launch", 3.0f, 1.0f);
        if (!world.isRemote) {
            world.spawnEntityInWorld(new LaserBallInstance(world, entityPlayer));
        }
        return stack;
    }
}
