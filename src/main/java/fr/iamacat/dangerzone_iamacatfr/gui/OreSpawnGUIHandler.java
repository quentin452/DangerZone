
package fr.iamacat.dangerzone_iamacatfr.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import cpw.mods.fml.common.network.IGuiHandler;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.ContainerCrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.ContainerCrystalWorkbench;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.TileEntityCrystalFurnace;

public class OreSpawnGUIHandler implements IGuiHandler {

    public Object getServerGuiElement(final int ID, final EntityPlayer player, final World world, final int x,
        final int y, final int z) {
        final TileEntity tileEntity = world.getTileEntity(x, y, z);
        switch (ID) {
            case 0: {
                if (tileEntity instanceof TileEntityCrystalFurnace) {
                    return new ContainerCrystalFurnace(player.inventory, (TileEntityCrystalFurnace) tileEntity);
                }
                break;
            }
            case 1: {
                return new ContainerCrystalWorkbench(player.inventory, world, x, y, z);
            }
        }
        return null;
    }

    public Object getClientGuiElement(final int ID, final EntityPlayer player, final World world, final int x,
        final int y, final int z) {
        final TileEntity tileEntity = world.getTileEntity(x, y, z);
        switch (ID) {
            case 0: {
                if (tileEntity instanceof TileEntityCrystalFurnace) {
                    return new CrystalFurnaceGUI(player.inventory, (TileEntityCrystalFurnace) tileEntity);
                }
                break;
            }
            case 1: {
                return new CrystalWorkbenchGUI(player.inventory, world, x, y, z);
            }
        }
        return null;
    }
}
