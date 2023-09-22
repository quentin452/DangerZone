package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ExtraSmallZooCage extends Item {

    public ExtraSmallZooCage() {
        this.setMaxStackSize(16);
        this.setTextureName(Tags.MODID + ":zoo2");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            // Get the block position the player is looking at
            int x = (int) Math.floor(player.posX);
            int y = (int) Math.floor(player.posY) - 1; // Abaissez la structure d'un bloc;
            int z = (int) Math.floor(player.posZ);

            // Generate the complex structure
            generateComplexStructure(world, x, y, z);

            // Reduce the item stack size by 1
            if (!player.capabilities.isCreativeMode) {
                itemStack.stackSize--;
                if (itemStack.stackSize <= 0) {
                    player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                }
            }
        }

        return itemStack;
    }

    private void generateComplexStructure(World world, int x, int y, int z) {
        // Ceiling and floor made of quartz blocks
        for (int dx = -2; dx <= 2; dx++) {
            for (int dz = -2; dz <= 2; dz++) {
                world.setBlock(x + dx, y, z + dz, Blocks.quartz_block);
                world.setBlock(x + dx, y + 4, z + dz, Blocks.quartz_block);
            }
        }

        // Walls made of glass
        for (int dy = 1; dy <= 3; dy++) {
            for (int dx = -2; dx <= 2; dx++) {
                world.setBlock(x + dx, y + dy, z - 2, Blocks.glass);
                world.setBlock(x + dx, y + dy, z + 2, Blocks.glass);
            }

            for (int dz = -2; dz <= 2; dz++) {
                world.setBlock(x - 2, y + dy, z + dz, Blocks.glass);
                world.setBlock(x + 2, y + dy, z + dz, Blocks.glass);
            }
        }
    }
}
