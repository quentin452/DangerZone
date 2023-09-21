
package danger.orespawn.items;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

import danger.orespawn.entities.entityinstance.IrukandjiArrow;

public final class MyDispenserBehaviorArrow extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final IrukandjiArrow entityarrow = new IrukandjiArrow(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        entityarrow.canBePickedUp = 1;
        return (IProjectile) entityarrow;
    }
}
