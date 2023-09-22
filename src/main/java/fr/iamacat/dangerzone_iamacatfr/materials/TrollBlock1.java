package fr.iamacat.dangerzone_iamacatfr.materials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class TrollBlock1 extends Block {

    public TrollBlock1() {
        super(Material.rock);
        setHardness(2.0F);
        setResistance(10.0F);
        setBlockName("termitetroll");
        setBlockTextureName(Tags.MODID + ":termitetroll");
    }
}
