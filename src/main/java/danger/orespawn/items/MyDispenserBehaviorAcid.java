
package danger.orespawn.items;

import net.minecraft.dispenser.BehaviorProjectileDispense;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

import danger.orespawn.entities.entityinstance.Acid;

public final class MyDispenserBehaviorAcid extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final Acid entityarrow = new Acid(par1World, par2IPosition.getX(), par2IPosition.getY(), par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
