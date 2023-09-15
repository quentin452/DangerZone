package fr.iamacat.dangerzone_iamacatfr.materials;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TigersEyeBlock extends Block {
    public TigersEyeBlock() {
        super(Material.rock);
        setBlockName("tigerseye_block");
        setBlockTextureName(Tags.MODID +":tigerseye_block");
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }
}
