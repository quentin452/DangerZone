package fr.iamacat.dangerzone_iamacatfr.materials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class TitaniumBlock extends Block {

    public TitaniumBlock() {
        super(Material.rock);
        setBlockName("blocktitanium");
        setBlockTextureName(Tags.MODID + ":blocktitanium");
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }
}
