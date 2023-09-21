
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMinersDream extends Item {

    public ItemMinersDream(final int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer Player, final World world,
        final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9,
        final float par10) {
        int deltax = 0;
        int deltaz = 0;
        int dirx = 0;
        int dirz = 0;
        final int height = 5;
        final int width = 5;
        final int length = 64;
        final int torches = 5;
        int solid_count = 0;
        if (cposx < 0) {
            dirx = -1;
        }
        if (cposz < 0) {
            dirz = -1;
        }
        final int pposx = (int) (Player.posX + 0.99 * dirx);
        final int pposy = (int) Player.posY;
        final int pposz = (int) (Player.posZ + 0.99 * dirz);
        if (cposx - pposx != 0 && cposz - pposz != 0) {
            return false;
        }
        final int x = cposx;
        final int y = pposy;
        final int z = cposz;
        if (x - pposx < 0) {
            deltax = -1;
        }
        if (x - pposx > 0) {
            deltax = 1;
        }
        if (z - pposz < 0) {
            deltaz = -1;
        }
        if (z - pposz > 0) {
            deltaz = 1;
        }
        if (deltax == 0 && deltaz == 0) {
            return false;
        }
        if (deltax != 0 && deltaz != 0) {
            return false;
        }
        Player.worldObj.playSoundAtEntity(Player, "random.explode", 1.0f, 1.5f);
        if (world.isRemote) {
            return true;
        }
        for (int i = 0; i < height; ++i) {
            for (int k = 0; k < length; ++k) {
                solid_count = 0;
                for (int j = -width; j <= width; ++j) {
                    Block bid = world.getBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax);
                    if (bid == Blocks.stone || bid == Blocks.dirt
                        || bid == Blocks.gravel
                        || bid == Blocks.flowing_water
                        || bid == Blocks.water
                        || bid == Blocks.flowing_lava
                        || bid == Blocks.lava
                        || bid == Blocks.netherrack
                        || bid == Blocks.end_stone
                        || bid == OreSpawnMain.CrystalStone) {
                        world.setBlock(
                            x + k * deltax + j * deltaz,
                            y + i,
                            z + k * deltaz + j * deltax,
                            Blocks.air,
                            0,
                            2);
                    }
                    if (i == height - 1) {
                        bid = world.getBlock(x + k * deltax + j * deltaz, y + i + 1, z + k * deltaz + j * deltax);
                        if (bid != Blocks.air) {
                            ++solid_count;
                        }
                        if (bid == Blocks.air || bid == Blocks.gravel
                            || bid == Blocks.sand
                            || bid == Blocks.flowing_water
                            || bid == Blocks.water
                            || bid == Blocks.flowing_lava
                            || bid == Blocks.lava) {
                            if (world.provider.dimensionId == OreSpawnMain.DimensionID5) {
                                world.setBlock(
                                    x + k * deltax + j * deltaz,
                                    y + i + 1,
                                    z + k * deltaz + j * deltax,
                                    OreSpawnMain.CrystalStone,
                                    0,
                                    2);
                            } else {
                                world.setBlock(
                                    x + k * deltax + j * deltaz,
                                    y + i + 1,
                                    z + k * deltaz + j * deltax,
                                    Blocks.cobblestone,
                                    0,
                                    2);
                            }
                        }
                    }
                }
                if (i == height - 1 && solid_count == 0) {
                    for (int j = -width; j <= width; ++j) {
                        world.setBlock(
                            x + k * deltax + j * deltaz,
                            y + i + 1,
                            z + k * deltaz + j * deltax,
                            Blocks.air,
                            0,
                            2);
                    }
                }
            }
        }
        for (int k = 0; k < length; k += torches) {
            final Block bid = world.getBlock(x + k * deltax, y - 1, z + k * deltaz);
            if ((bid == Blocks.stone || bid == Blocks.dirt
                || bid == Blocks.gravel
                || bid == Blocks.netherrack
                || bid == Blocks.end_stone
                || bid == Blocks.bedrock) && world.isAirBlock(x + k * deltax, y, z + k * deltaz)) {
                world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.ExtremeTorch, 0, 2);
            }
            if (bid == OreSpawnMain.CrystalStone && world.isAirBlock(x + k * deltax, y, z + k * deltaz)) {
                world.setBlock(x + k * deltax, y, z + k * deltaz, OreSpawnMain.CrystalTorch, 0, 2);
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
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
