package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class MediumZooCage extends Item {

    public MediumZooCage() {
        this.setMaxStackSize(16);
        this.setTextureName(Tags.MODID + ":zoo6");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            // Get the block position the player is looking at
            int x = (int) Math.floor(player.posX);
            int y = (int) Math.floor(player.posY) - 1; // Abaissez la structure d'un bloc
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
        int size = 2; // Augmentez la taille de 2 blocs dans toutes les dimensions

        // Plafond et sol
        for (int dx = -3 - size; dx <= 3 + size; dx++) {
            for (int dz = -3 - size; dz <= 3 + size; dz++) {
                world.setBlock(x + dx, y, z + dz, Blocks.quartz_block);
                world.setBlock(x + dx, y + 4 + size, z + dz, Blocks.quartz_block);
            }
        }

        // Murs
        for (int dy = 1; dy <= 3 + size; dy++) {
            for (int dx = -3 - size; dx <= 3 + size; dx++) {
                world.setBlock(x + dx, y + dy, z - 3 - size, Blocks.glass);
                world.setBlock(x + dx, y + dy, z + 3 + size, Blocks.glass);
            }

            for (int dz = -3 - size; dz <= 3 + size; dz++) {
                world.setBlock(x - 3 - size, y + dy, z + dz, Blocks.glass);
                world.setBlock(x + 3 + size, y + dy, z + dz, Blocks.glass);
            }
        }

        // Intérieur
        for (int dy = 1; dy <= 3 + size; dy++) {
            for (int dx = -2 - size; dx <= 2 + size; dx++) {
                for (int dz = -2 - size; dz <= 2 + size; dz++) {
                    world.setBlock(x + dx, y + dy, z + dz, Blocks.air);
                }
            }
        }
    }
}
