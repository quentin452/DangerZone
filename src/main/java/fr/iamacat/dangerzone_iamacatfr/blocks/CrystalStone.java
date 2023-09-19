package fr.iamacat.dangerzone_iamacatfr.blocks;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class CrystalStone extends Block {

    public CrystalStone(Material materialIn) {
        super(materialIn);
        this.setBlockTextureName(Tags.MODID + ":crystalstone");
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Item.getItemFromBlock(this);
    }
}
