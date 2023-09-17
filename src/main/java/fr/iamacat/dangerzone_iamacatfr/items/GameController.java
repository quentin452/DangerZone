package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.GameControllerInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class GameController extends Item {

    public GameController() {
        this.maxStackSize = 64;
        this.setTextureName(Tags.MODID + ":gamecontroller");
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity(entityPlayer, "random.bow", 3.0f, 1.0f);
        if (!world.isRemote) {
            world.spawnEntityInWorld(new GameControllerInstance(world, entityPlayer));
        }
        return stack;
    }
}
