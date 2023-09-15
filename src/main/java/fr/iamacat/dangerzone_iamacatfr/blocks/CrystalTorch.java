package fr.iamacat.dangerzone_iamacatfr.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.world.IBlockAccess;

public class CrystalTorch extends BlockTorch {

    public CrystalTorch() {
        super();
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        int baseLightValue = super.getLightValue(world, x, y, z);
        int increasedLightValue = (int) (baseLightValue * 1.0);
        return Math.min(increasedLightValue, 14);
    }
}
