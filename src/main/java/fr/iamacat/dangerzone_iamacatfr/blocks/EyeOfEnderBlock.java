package fr.iamacat.dangerzone_iamacatfr.blocks;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class EyeOfEnderBlock extends Block {

    public EyeOfEnderBlock() {
        super(Material.rock);
        setHardness(2.0F);
        setResistance(10.0F);
        setBlockName("EyeOfEnderBlock");
        setBlockTextureName(Tags.MODID + ":blockeyeofender");
    }
}
