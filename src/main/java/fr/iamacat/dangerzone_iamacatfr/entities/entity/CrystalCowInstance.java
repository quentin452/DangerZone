package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.entity.passive.EntityCow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.items.CrystalApple;

public class CrystalCowInstance extends EntityCow {

    public CrystalCowInstance(World p_i1683_1_) {
        super(p_i1683_1_);
    }

    @Override
    protected void dropFewItems(boolean wasRecentlyHit, int lootingModifier) {
        int dropCount = rand.nextInt(3);

        for (int i = 0; i < dropCount; i++) {
            ItemStack dropItemStack = getDropItemStack();
            entityDropItem(dropItemStack, 0);
        }

        super.dropFewItems(wasRecentlyHit, lootingModifier);
    }

    private ItemStack getDropItemStack() {
        if (rand.nextInt(10) < 2) { // 20% de chance
            return new ItemStack(CrystalApple.crystalApple); // todo fixme : this isn't dropped
        } else {
            return new ItemStack(Items.apple);
        }
    }
}
