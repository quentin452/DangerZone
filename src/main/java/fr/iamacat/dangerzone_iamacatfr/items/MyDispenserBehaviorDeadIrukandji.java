package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.dispenser.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.DeadIrukandji;

public final class MyDispenserBehaviorDeadIrukandji extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final DeadIrukandji entityarrow = new fr.iamacat.dangerzone_iamacatfr.entities.entity.DeadIrukandji(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
