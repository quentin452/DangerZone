package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class MinersDream extends Item {

    public MinersDream(final int i) {
        this.maxStackSize = 16;
    }

    public boolean onItemUse(final ItemStack itemStack, final EntityPlayer player, final World world, final int targetX,
        final int targetY, final int targetZ, final int par7, final float par8, final float par9, final float par10) {
        // Vérifiez si la position Y du joueur est supérieure à 50
        if (player.posY > 50) {
            // Si la condition est vraie, retournez false pour empêcher l'utilisation de l'objet
            return false;
        }

        int deltaX = 0;
        int deltaZ = 0;
        int dirX = 0;
        int dirZ = 0;
        final int maxHeight = 5;
        final int maxWidth = 5;
        final int maxLength = 64;
        final int torchCount = 5;

        if (targetX < 0) {
            dirX = -1;
        }
        if (targetZ < 0) {
            dirZ = -1;
        }

        final int playerPosX = (int) (player.posX + 0.99 * dirX);
        final int playerPosY = (int) player.posY;
        final int playerPosZ = (int) (player.posZ + 0.99 * dirZ);

        if (targetX - playerPosX != 0 && targetZ - playerPosZ != 0) {
            return false;
        }
        if (targetX - playerPosX < 0) {
            deltaX = -1;
        }
        if (targetX - playerPosX > 0) {
            deltaX = 1;
        }
        if (targetZ - playerPosZ < 0) {
            deltaZ = -1;
        }
        if (targetZ - playerPosZ > 0) {
            deltaZ = 1;
        }
        if (deltaX == 0 && deltaZ == 0) {
            return false;
        }

        player.worldObj.playSoundAtEntity(player, "random.explode", 1.0f, 1.5f);

        if (world.isRemote) {
            return true;
        }

        for (int i = 0; i < maxHeight; ++i) {
            for (int k = 0; k < maxLength; ++k) {
                int solidBlockCount = processBlocks(
                    world,
                    targetX,
                    targetZ,
                    playerPosY,
                    i,
                    k,
                    deltaX,
                    deltaZ,
                    maxWidth);

                if (i == maxHeight - 1 && solidBlockCount == 0) {
                    clearBlocks(world, targetX, targetZ, playerPosY, i, k, deltaX, deltaZ, maxWidth);
                }
            }
        }

        for (int k = 0; k < maxLength; k += torchCount) {
            final Block targetBlock = world.getBlock(targetX + k * deltaX, playerPosY - 1, targetZ + k * deltaZ);

            if ((targetBlock == Blocks.stone || targetBlock == Blocks.dirt
                || targetBlock == Blocks.gravel
                || targetBlock == Blocks.netherrack
                || targetBlock == Blocks.end_stone
                || targetBlock == Blocks.bedrock)
                && world.isAirBlock(targetX + k * deltaX, playerPosY, targetZ + k * deltaZ)) {

                world.setBlock(
                    targetX + k * deltaX,
                    playerPosY,
                    targetZ + k * deltaZ,
                    BlockInitDangerZone.blocktorch,
                    0,
                    2);
            }
        }

        if (!player.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }

        return true;
    }

    private int processBlocks(World world, int targetX, int targetZ, int playerPosY, int i, int k, int deltaX,
        int deltaZ, int maxWidth) {
        int solidBlockCount = 0;

        for (int j = -maxWidth; j <= maxWidth; ++j) {
            Block targetBlock = world
                .getBlock(targetX + k * deltaX + j * deltaZ, playerPosY + i, targetZ + k * deltaZ + j * deltaX);

            if (isReplaceable(targetBlock)) {
                world.setBlock(
                    targetX + k * deltaX + j * deltaZ,
                    playerPosY + i,
                    targetZ + k * deltaZ + j * deltaX,
                    Blocks.air,
                    0,
                    2);
            }

            if (i == 50 - 1) {
                targetBlock = world
                    .getBlock(targetX + k * deltaX + j * deltaZ, playerPosY + i + 1, targetZ + k * deltaZ + j * deltaX);

                if (targetBlock != Blocks.air) {
                    ++solidBlockCount;
                }

                if (isReplaceable(targetBlock)) {
                    world.setBlock(
                        targetX + k * deltaX + j * deltaZ,
                        playerPosY + i + 1,
                        targetZ + k * deltaZ + j * deltaX,
                        Blocks.cobblestone,
                        0,
                        2);
                }
            }
        }

        return solidBlockCount;
    }

    private void clearBlocks(World world, int targetX, int targetZ, int playerPosY, int i, int k, int deltaX,
        int deltaZ, int maxWidth) {
        for (int j = -maxWidth; j <= maxWidth; ++j) {
            world.setBlock(
                targetX + k * deltaX + j * deltaZ,
                playerPosY + i + 1,
                targetZ + k * deltaZ + j * deltaX,
                Blocks.air,
                0,
                2);
        }
    }

    private boolean isReplaceable(Block block) {
        return block == Blocks.stone || block == Blocks.dirt
            || block == Blocks.gravel
            || block == Blocks.flowing_water
            || block == Blocks.water
            || block == Blocks.flowing_lava
            || block == Blocks.lava
            || block == Blocks.netherrack
            || block == Blocks.end_stone;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
