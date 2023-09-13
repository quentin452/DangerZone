package fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class AppleCowInstance extends EntityCow {

    public AppleCowInstance(World p_i1683_1_) {
        super(p_i1683_1_);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {

        int appleCount = rand.nextInt(3);

        for (int i = 0; i < appleCount; i++) {
            entityDropItem(new ItemStack(Items.apple), 0);
        }

        super.dropFewItems(wasRecentlyHit, lootingModifier);

    }
}
