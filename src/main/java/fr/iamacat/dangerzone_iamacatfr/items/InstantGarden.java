package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class InstantGarden extends Item {

    private static final int WIDTH = 5; // Largeur du champ de culture
    private static final int LENGTH = 5; // Longueur du champ de culture

    public InstantGarden() {
        this.maxStackSize = 16;
        this.setTextureName(Tags.MODID + ":instantgarden");
    }

    public boolean onItemUse(final ItemStack itemStack, final EntityPlayer player, final World world, final int targetX,
        final int targetY, final int targetZ, final int side, final float hitX, final float hitY, final float hitZ) {

        final int playerX = (int) player.posX;
        final int playerY = (int) player.posY - 1;
        final int playerZ = (int) player.posZ;

        if (world.isRemote) {
            return true;
        }

        createGarden(world, playerX, playerY, playerZ);

        if (!player.capabilities.isCreativeMode) {
            itemStack.stackSize--;
        }

        return true;
    }

    private void createGarden(World world, int x, int y, int z) {
        // Création du champ de culture avec des terres labourables et des cultures (par exemple, Blé, Carottes, Pommes
        // de terre)
        for (int i = -WIDTH / 2; i <= WIDTH / 2; i++) {
            for (int j = -LENGTH / 2; j <= LENGTH / 2; j++) {
                // Vérifiez si le bloc sous les terres labourables est solide (non aérien)
                if (world.isAirBlock(x + i, y, z + j)) {
                    continue; // Si c'est un bloc en l'air, passez au suivant
                }

                // Placez de l'eau à côté des cultures
                placeWaterSource(world, x + i, y - 1, z + j);

                // Placez des terres labourables en remplaçant les blocs d'herbe existants
                world.setBlock(x + i, y, z + j, Blocks.farmland, 0, 2);

                // Placez des cultures aléatoires (Blé, Carottes, Pommes de terre, etc.)
                placeRandomCrop(world, x + i, y + 1, z + j);
            }
        }
    }

    private void placeWaterSource(World world, int x, int y, int z) {
        if (world.getBlock(x, y, z) != Blocks.water) {
            world.setBlock(x, y, z, Blocks.water);
        }
    }

    private void placeRandomCrop(World world, int x, int y, int z) {
        // Créez une liste des cultures possibles
        Block[] cropBlocks = { Blocks.wheat, Blocks.carrots, Blocks.potatoes };

        // Choisissez un type de culture au hasard parmi la liste
        Block cropBlock = cropBlocks[world.rand.nextInt(cropBlocks.length)];

        // Placez la culture sur les terres labourables
        world.setBlock(x, y, z, cropBlock);
    }
}
