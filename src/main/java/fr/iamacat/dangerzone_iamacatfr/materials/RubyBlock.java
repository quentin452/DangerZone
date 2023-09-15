package fr.iamacat.dangerzone_iamacatfr.materials;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class RubyBlock  extends Block {
    public RubyBlock() {
        super(Material.rock);
        setBlockName("blockruby");
        setBlockTextureName(Tags.MODID +":blockruby");
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }
}
