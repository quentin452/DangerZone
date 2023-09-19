
package fr.iamacat.dangerzone_iamacatfr.blocks;

import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import java.util.Random;

public class PortalBlock extends BlockPortal {

    public PortalBlock() {}

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {}

    public boolean tryToCreatePortal(final World par1World, final int par2, final int par3, final int par4) {
        return false;
    }

    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4,
        final int par5) {}

    public void onEntityCollidedWithBlock(final World par1World, final int par2, final int par3, final int par4,
        final Entity entity) {}
}
