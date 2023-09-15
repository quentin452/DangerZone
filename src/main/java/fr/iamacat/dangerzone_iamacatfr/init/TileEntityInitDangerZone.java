package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.registry.GameRegistry;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.ContainerCrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.TileEntityCrystalFurnace;

public class TileEntityInitDangerZone {

    public static ContainerCrystalFurnace CrystalFurnaceTile;

    public static void init() {

    }

    public static void register() {
        GameRegistry.registerTileEntity(TileEntityCrystalFurnace.class, "TileEntityCrystalFurnaceDangerZone");
    }
}
