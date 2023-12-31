package fr.iamacat.dangerzone_iamacatfr.materials;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class AmethystBlock extends Block {

    public AmethystBlock() {
        super(Material.rock);
        setBlockName("blockamethyst");
        setBlockTextureName(Tags.MODID + ":blockamethyst");
        setHardness(1.5F);
        setResistance(10.0F);
        setStepSound(soundTypeStone);
    }
}
