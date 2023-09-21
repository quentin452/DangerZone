
package danger.orespawn.items;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

import danger.orespawn.entities.entityinstance.IceBall;

public final class MyDispenserBehaviorIceball extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final IceBall entityarrow = new IceBall(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
