package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.dispenser.*;
import net.minecraft.entity.*;
import net.minecraft.world.*;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.Acid;

public final class MyDispenserBehaviorAcid extends BehaviorProjectileDispense {

    protected IProjectile getProjectileEntity(final World par1World, final IPosition par2IPosition) {
        final Acid entityarrow = new fr.iamacat.dangerzone_iamacatfr.entities.entity.Acid(
            par1World,
            par2IPosition.getX(),
            par2IPosition.getY(),
            par2IPosition.getZ());
        return (IProjectile) entityarrow;
    }
}
