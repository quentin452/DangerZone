
package danger.orespawn.blocks;

import java.util.Random;

import net.minecraft.block.BlockPortal;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class PortalBlock extends BlockPortal {

    public PortalBlock(final int i, final int j) {}

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
