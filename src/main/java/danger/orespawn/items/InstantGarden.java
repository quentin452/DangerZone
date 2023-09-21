
package danger.orespawn.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class InstantGarden extends Item {

    public InstantGarden(final int i) {
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer Player, final World world,
        final int cposx, final int cposy, final int cposz, final int par7, final float par8, final float par9,
        final float par10) {
        int deltax = 0;
        int deltaz = 0;
        final int bid = 0;
        int dirx = 0;
        int dirz = 0;
        final int height = 10;
        final int width = 7;
        final int length = 18;
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
                for (int j = -width; j <= width; ++j) {
                    world.setBlock(x + k * deltax + j * deltaz, y + i, z + k * deltaz + j * deltax, Blocks.air, 0, 2);
                    if (i == 0) {
                        world.setBlock(
                            x + k * deltax + j * deltaz,
                            y + i - 1,
                            z + k * deltaz + j * deltax,
                            (Block) Blocks.grass,
                            0,
                            2);
                    }
                }
            }
        }
        for (int k = 1; k < length - 1; ++k) {
            int i = 0;
            for (int j = -width; j <= width; ++j) {
                if (i == 1) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y,
                        z + k * deltaz + j * deltax,
                        OreSpawnMain.MyRadishPlant,
                        0,
                        2);
                }
                if (i == 2) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y,
                        z + k * deltaz + j * deltax,
                        OreSpawnMain.MyLettucePlant1,
                        0,
                        2);
                }
                if (i == 3) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.carrots, 0, 2);
                }
                if (i == 4) {
                    world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.water, 0, 2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 2,
                        z + k * deltaz + j * deltax,
                        Blocks.cobblestone,
                        0,
                        2);
                }
                if (i == 5) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.potatoes, 0, 2);
                }
                if (i == 6) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.wheat, 0, 2);
                }
                if (i == 7) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y,
                        z + k * deltaz + j * deltax,
                        OreSpawnMain.MyTomatoPlant1,
                        0,
                        2);
                }
                if (i == 8) {
                    world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.water, 0, 2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 2,
                        z + k * deltaz + j * deltax,
                        Blocks.cobblestone,
                        0,
                        2);
                }
                if (i == 9) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y,
                        z + k * deltaz + j * deltax,
                        OreSpawnMain.MyCornPlant1,
                        0,
                        2);
                }
                if (i == 10) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y,
                        z + k * deltaz + j * deltax,
                        OreSpawnMain.MyStrawberryPlant,
                        0,
                        2);
                }
                if (i == 11) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 2,
                        z + k * deltaz + j * deltax,
                        Blocks.cobblestone,
                        0,
                        2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        (Block) Blocks.sand,
                        0,
                        2);
                    world.setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.reeds, 0, 2);
                }
                if (i == 12) {
                    world.setBlock(x + k * deltax + j * deltaz, y - 1, z + k * deltaz + j * deltax, Blocks.water, 0, 2);
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 2,
                        z + k * deltaz + j * deltax,
                        Blocks.cobblestone,
                        0,
                        2);
                }
                if (i == 13) {
                    world.setBlock(
                        x + k * deltax + j * deltaz,
                        y - 1,
                        z + k * deltaz + j * deltax,
                        Blocks.farmland,
                        0,
                        2);
                    world
                        .setBlock(x + k * deltax + j * deltaz, y, z + k * deltaz + j * deltax, Blocks.melon_stem, 0, 2);
                }
                ++i;
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
