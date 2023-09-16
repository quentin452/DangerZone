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

public class StairsUp extends Item {

    private static final int MAX_STACK_SIZE = 32;
    private static final int LENGTH = 33;
    private static final int PARTICLE_COUNT = 6;

    // Déclarez la matrice DELTAS pour les valeurs de déplacement
    private static final int[][] DELTAS = { { 0, 1 }, { -1, 1 }, { -1, 0 }, { -1, -1 }, { 0, -1 }, { 1, -1 }, { 1, 0 },
        { 1, 1 } };

    public StairsUp() {
        this.maxStackSize = MAX_STACK_SIZE;
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer Player, final World world,
        final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9,
        final float par10) {
        int deltax = 0;
        int deltaz = 0;
        final int x = cposx;
        final int y = cposy + 1;
        final int z = cposz;

        if (world.isRemote) {
            return true; // Sortez si le code s'exécute côté client
        }

        float f = Player.rotationYawHead;
        f += 22.5f;
        f %= 360.0f;
        f /= 45.0f;

        // Assurez-vous que f est dans la plage de 0 à 7
        if (f < 0) {
            f += 8;
        }

        // Supprimez la deuxième déclaration de deltax et deltaz
        deltax = DELTAS[(int) f][0];
        deltaz = DELTAS[(int) f][1];

        if (deltax == 0 && deltaz == 0) {
            return false;
        }

        Player.worldObj.playSoundAtEntity(Player, "random.explode", 1.0f, 1.5f);

        for (int var3 = 0; var3 < PARTICLE_COUNT; ++var3) {
            world.spawnParticle(
                "largesmoke",
                (x + world.rand.nextFloat() - world.rand.nextFloat()),
                (y + world.rand.nextFloat() + 1.0f),
                (z + world.rand.nextFloat() - world.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
            world.spawnParticle(
                "largeexplode",
                (x + world.rand.nextFloat() - world.rand.nextFloat()),
                (y + world.rand.nextFloat() + 1.0f),
                (z + world.rand.nextFloat() - world.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
            world.spawnParticle(
                "reddust",
                (x + world.rand.nextFloat() - world.rand.nextFloat()),
                (y + world.rand.nextFloat() + 1.0f),
                (z + world.rand.nextFloat() - world.rand.nextFloat()),
                0.0,
                0.0,
                0.0);
        }

        for (int k = 1; k < LENGTH; ++k) {
            Block bid = world.getBlock(x + k * deltax, y + k - 1, z + k * deltaz);
            if (bid != Blocks.air) {
                break;
            }
            world.setBlock(x + k * deltax, y + k - 1, z + k * deltaz, Blocks.cobblestone, 0, 2);
            if ((k - 1) % 8 == 0) {
                bid = world.getBlock(x + k * deltax, y + k, z + k * deltaz);
                if (bid == Blocks.air) {
                    world.setBlock(x + k * deltax, y + k, z + k * deltaz, BlockInitDangerZone.blocktorch, 0, 2);
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
