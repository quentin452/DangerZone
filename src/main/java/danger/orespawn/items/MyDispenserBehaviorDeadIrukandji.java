
package danger.orespawn.items;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

import danger.orespawn.entities.entityinstance.DeadIrukandji;

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
