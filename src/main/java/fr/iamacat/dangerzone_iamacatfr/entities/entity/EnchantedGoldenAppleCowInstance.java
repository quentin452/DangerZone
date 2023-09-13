package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import java.util.Random;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EnchantedGoldenAppleCowInstance extends EntityCow {

    public EnchantedGoldenAppleCowInstance(World p_i1683_1_) {
        super(p_i1683_1_);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        Random rand = this.rand;
        int dropCount = rand.nextInt(3);

        for (int i = 0; i < dropCount; i++) {

            int random = rand.nextInt(100);

            if (random < 30) { // 5% chance
                entityDropItem(new ItemStack(Items.golden_apple, 1, 1), 0);
            } else {
                entityDropItem(new ItemStack(Items.apple), 0);
            }

        }

        super.dropFewItems(wasRecentlyHit, lootingModifier);

    }
}
