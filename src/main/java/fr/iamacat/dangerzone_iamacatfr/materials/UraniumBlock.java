package fr.iamacat.dangerzone_iamacatfr.materials;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class UraniumBlock extends Block {

    public UraniumBlock() {
        super(Material.rock);
        setBlockName("blockuranium");
        setBlockTextureName(Tags.MODID + ":blockuranium");
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }
}
