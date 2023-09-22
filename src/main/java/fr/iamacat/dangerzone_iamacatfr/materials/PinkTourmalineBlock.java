package fr.iamacat.dangerzone_iamacatfr.materials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class PinkTourmalineBlock extends Block {

    public PinkTourmalineBlock() {
        super(Material.rock);
        setBlockName("crystalpink_block");
        setBlockTextureName(Tags.MODID + ":crystalpink_block");
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }
}
