package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class StairsAcross extends Item {

    private static final int MAX_STACK_SIZE = 32;
    private static final int LENGTH = 16; // Réduisez la taille à 16
    private static final int[][] DELTAS = {{0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    public StairsAcross() {
        this.maxStackSize = MAX_STACK_SIZE;
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer Player, final World world,
                             final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9,
                             final float par10) {
        float f = Player.rotationYawHead;
        f += 22.5f;
        f %= 360.0f;
        f /= 45.0f;

        // Assurez-vous que f est dans la plage de 0 à 7
        if (f < 0) {
            f += 8;
        }

        int deltax = DELTAS[(int) f][0];
        int deltaz = DELTAS[(int) f][1];

        if (deltax == 0 && deltaz == 0) {
            return false;
        }

        Player.worldObj.playSoundAtEntity(Player, "random.explode", 1.0f, 1.5f);

        for (int particleCount = 0; particleCount < 6; ++particleCount) {
            world.spawnParticle(
                "largesmoke",
                (cposx + world.rand.nextFloat() - world.rand.nextFloat()),
                (cposy + 1 + world.rand.nextFloat()), // Augmentez y de 1
                (cposz + world.rand.nextFloat() - world.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
            world.spawnParticle(
                "largeexplode",
                (cposx + world.rand.nextFloat() - world.rand.nextFloat()),
                (cposy + 1 + world.rand.nextFloat()), // Augmentez y de 1
                (cposz + world.rand.nextFloat() - world.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
            world.spawnParticle(
                "reddust",
                (cposx + world.rand.nextFloat() - world.rand.nextFloat()),
                (cposy + 1 + world.rand.nextFloat()), // Augmentez y de 1
                (cposz + world.rand.nextFloat() - world.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
        }

        for (int k = 1; k < LENGTH; ++k) {
            Block bid = world.getBlock(cposx + k * deltax, cposy, cposz + k * deltaz); // Augmentez y de 1
            if (bid != Blocks.air) {
                break;
            }
            world.setBlock(cposx + k * deltax, cposy, cposz + k * deltaz, Blocks.cobblestone, 0, 2);
            if ((k - 1) % 8 == 0) {
                bid = world.getBlock(cposx + k * deltax, cposy + 1, cposz + k * deltaz); // Augmentez y de 1
                if (bid == Blocks.air) {
                    world.setBlock(cposx + k * deltax, cposy + 1, cposz + k * deltaz, BlockInitDangerZone.blocktorch, 0, 2);
                }
            }
        }

        if (!Player.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                .substring(5));
    }
}
