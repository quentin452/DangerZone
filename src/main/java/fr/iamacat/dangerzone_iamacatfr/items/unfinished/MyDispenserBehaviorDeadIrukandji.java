
package fr.iamacat.dangerzone_iamacatfr.items.unfinished;

import fr.iamacat.dangerzone_iamacatfr.items.DeadIrukandji;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public final class MyDispenserBehaviorDeadIrukandji extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final DeadIrukandji entityarrow = new DeadIrukandji(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
