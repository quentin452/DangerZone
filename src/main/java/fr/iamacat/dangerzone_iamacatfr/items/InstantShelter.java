package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

public class InstantShelter extends Item {

    private static final int WIDTH = 5; // Largeur de la maison
    private static final int HEIGHT = 4; // Hauteur de la maison

    public InstantShelter() {
        this.maxStackSize = 16;
        this.setTextureName(Tags.MODID + ":InstantShelter");
    }

    public boolean onItemUse(final ItemStack itemStack, final EntityPlayer player, final World world,
                             final int targetX, final int targetY, final int targetZ, final int side, final float hitX, final float hitY,
                             final float hitZ) {
        int deltaX = 0;
        int deltaZ = 0;
        int directionX = 0;
        int directionZ = 0;
        int stuffDirection = 0;

        if (targetX < 0) {
            directionX = -1;
        }
        if (targetZ < 0) {
            directionZ = -1;
        }

        final int playerX = (int) (player.posX + 0.99 * directionX);
        final int playerY = (int) player.posY;
        final int playerZ = (int) (player.posZ + 0.99 * directionZ);

        if (targetX - playerX != 0 && targetZ - playerZ != 0) {
            return false;
        }

        int x = targetX;
        final int y = playerY - 1;
        int z = targetZ;

        if (x - playerX < 0) {
            deltaX = -1;
            stuffDirection = 3;
        } else if (x - playerX > 0) {
            deltaX = 1;
            stuffDirection = 2;
        }

        if (z - playerZ < 0) {
            deltaZ = -1;
            stuffDirection = 5;
        } else if (z - playerZ > 0) {
            deltaZ = 1;
            stuffDirection = 4;
        }

        if (deltaX == 0 && deltaZ == 0) {
            return false;
        }

        x = playerX;
        z = playerZ;

        player.worldObj.playSoundAtEntity(player, "random.explode", 1.0f, 1.5f);

        if (world.isRemote) {
            return true;
        }

        buildHouse(world, x, y, z, deltaX, deltaZ, stuffDirection);
        createChest(world, x, y, z, deltaX, deltaZ, stuffDirection, player);

        if (!player.capabilities.isCreativeMode) {
            itemStack.stackSize--;
        }

        return true;
    }
    private void buildHouse(World world, int x, int y, int z, int deltaX, int deltaZ, int stuffDirection) {
        // Construction des murs extérieurs
        for (int i = -WIDTH; i <= WIDTH; ++i) {
            for (int j = -WIDTH; j <= WIDTH; ++j) {
                for (int k = 0; k <= HEIGHT + 1; ++k) {
                    if (k == HEIGHT + 1) {
                        world.setBlock(x + i, y + k, z + j, Blocks.planks);
                    } else if (k == 0) {
                        world.setBlock(x + i, y + k, z + j, Blocks.planks);
                    } else if (i == WIDTH || j == WIDTH || i == -WIDTH || j == -WIDTH) {
                        if (k == HEIGHT) {
                            world.setBlock(x + i, y + k, z + j, Blocks.glass);
                        } else if ((k == 1 || k == 2) && i == deltaX * WIDTH && j == deltaZ * WIDTH) {
                            world.setBlockToAir(x + i, y + k, z + j);
                        } else {
                            world.setBlock(x + i, y + k, z + j, Blocks.planks);
                        }
                    } else {
                        world.setBlockToAir(x + i, y + k, z + j);
                    }
                }
            }
        }

        // Autres éléments de la maison comme le toit, la porte, etc.
        // Vous pouvez ajouter votre propre logique ici pour personnaliser la maison.

        // Ajout de torches à l'intérieur de la maison
        world.setBlock(x, y + 1, z, Blocks.torch);
        world.setBlock(x, y + 2, z, Blocks.torch);

        // Ajout d'un four à l'intérieur de la maison
        world.setBlock(x + deltaX * 2, y + 1, z + deltaZ * 2, Blocks.furnace);
    }

    private void createChest(World world, int x, int y, int z, int deltaX, int deltaZ, int stuffDirection, EntityPlayer player) {
        // Création d'un coffre
        world.setBlock(x + deltaX * (WIDTH / 2), y + 1, z + deltaZ * (WIDTH / 2), Blocks.chest);
        int chestMeta = 2; // Vous pouvez ajuster la métadonnée du coffre en fonction de stuffDirection
        world.setBlockMetadataWithNotify(x + deltaX * (WIDTH / 2), y + 1, z + deltaZ * (WIDTH / 2), chestMeta, 3);

        TileEntityChest chest = (TileEntityChest) world.getTileEntity(x + deltaX * (WIDTH / 2), y + 1, z + deltaZ * (WIDTH / 2));

        if (chest != null) {
            // Ajout d'objets dans le coffre
            chest.setInventorySlotContents(0, new ItemStack(Items.compass));
            chest.setInventorySlotContents(1, new ItemStack(Items.map));
            chest.setInventorySlotContents(2, new ItemStack(Items.porkchop, 8));
            chest.setInventorySlotContents(3, new ItemStack(Blocks.torch, 32));
            chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16));
            chest.setInventorySlotContents(5, new ItemStack(Items.bed));
            chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door));
            chest.setInventorySlotContents(8, new ItemStack(Items.wooden_pickaxe));
            chest.setInventorySlotContents(11, new ItemStack(Items.bucket));
            chest.setInventorySlotContents(12, new ItemStack(BlockInitDangerZone.SaltOre, 4));
            chest.setInventorySlotContents(13, new ItemStack(Blocks.chest));
        }
    }

}
