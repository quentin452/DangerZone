package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Shoes;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SunspotUrchin extends Item {

    public SunspotUrchin() {
        this.maxStackSize = 64;
        this.setTextureName(Tags.MODID + ":sunspoturchin");
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World world, final EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity(entityPlayer, "random.bow", 3.0f, 1.0f);
        if (!world.isRemote) {
            world.spawnEntityInWorld(new Shoes(world, entityPlayer));
        }
        return stack;
    }

}
