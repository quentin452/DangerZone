
package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.WaterBall;

public final class MyDispenserBehaviorWDCharge extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final WaterBall entityarrow = new WaterBall(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
