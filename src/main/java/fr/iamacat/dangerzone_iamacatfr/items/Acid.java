package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.AcidEntityInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.LaserBallInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Acid extends Item {

    // todo fix the model getted is white and don't make any damge/fire aspect

    public Acid() {
        this.maxStackSize = 64;
        this.setTextureName(Tags.MODID +":acid_item");
    }

    public ItemStack onItemRightClick(final ItemStack stack, final World world,
                                      final EntityPlayer entityPlayer) {
        if (!entityPlayer.capabilities.isCreativeMode) {
            --stack.stackSize;
        }
        world.playSoundAtEntity(entityPlayer, "random.bow", 3.0f, 1.0f);
        if (!world.isRemote) {
            world.spawnEntityInWorld(new AcidEntityInstance(world, entityPlayer));
        }
        return stack;
    }

}
