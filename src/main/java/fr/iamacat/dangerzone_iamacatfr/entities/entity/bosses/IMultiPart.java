package fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses;

import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public interface IMultiPart {
// for bosses
	World getWorld();

	boolean attackEntityFromPart(EntityPart entity, DamageSource source, float damage);

	EntityPart getDefaultPart();
}
