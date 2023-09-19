
package fr.iamacat.dangerzone_iamacatfr.items.unfinished;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.IceBall;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public final class MyDispenserBehaviorIceball extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final IceBall entityarrow = new IceBall(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return entityarrow;
    }
}
