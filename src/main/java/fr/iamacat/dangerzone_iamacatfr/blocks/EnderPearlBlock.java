package fr.iamacat.dangerzone_iamacatfr.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EnderPearlBlock extends Block {

    public EnderPearlBlock() {
        super(Material.rock);
        setHardness(2.0F);
        setResistance(10.0F);
        setBlockName("EnderPearlBlock");
        setBlockTextureName(Tags.MODID + ":blockenderpearl");
    }
}
