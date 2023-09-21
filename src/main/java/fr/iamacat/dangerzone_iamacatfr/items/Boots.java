package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.BootsInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Boots extends Item {

    public Boots() {
        this.maxStackSize = 64;
        this.setTextureName(Tags.MODID + ":boots");
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity(entityPlayer, "random.bow", 3.0f, 1.0f);
        if (!world.isRemote) {
            world.spawnEntityInWorld(new BootsInstance(world, entityPlayer));
        }
        return stack;
    }

}
