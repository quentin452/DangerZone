package fr.iamacat.dangerzone_iamacatfr.blocks;

import net.minecraft.block.BlockTorch;
import net.minecraft.world.IBlockAccess;

public class ExtremeTorch extends BlockTorch {

    public ExtremeTorch() {
        super();
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        int baseLightValue = super.getLightValue(world, x, y, z);
        // Augmentez la luminosité de 10 %
        int increasedLightValue = (int) (baseLightValue * 1.1);
        // Assurez-vous que la luminosité maximale est de 15 (valeur maximale)
        return Math.min(increasedLightValue, 15);
    }
}
