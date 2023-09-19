
package fr.iamacat.dangerzone_iamacatfr.items.unfinished;

import fr.iamacat.dangerzone_iamacatfr.items.Acid;
import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public final class MyDispenserBehaviorAcid extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final Acid entityarrow = new Acid(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
