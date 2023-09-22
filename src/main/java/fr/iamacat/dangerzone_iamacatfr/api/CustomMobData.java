
package fr.iamacat.dangerzone_iamacatfr.api;

import java.util.*;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;

import fr.iamacat.dangerzone_iamacatfr.util.EntityProperties;

public class CustomMobData {

    public String mobName;
    public final HashMap<String, Object> customData;
    public int secondarySpawnRate;
    public boolean reportSpawningInLog;
    public boolean shouldDespawn;
    public int maxSpawnInChunk;
    public EnumCreatureType creatureType;
    public EnumCreatureType spawnType;
    public EntityProperties entityProperties;
    public int minDropNum;
    public int maxDropNum;
    private List<WeightedItemStack> lootItems;

    public CustomMobData(final String mobName) {
        this.mobName = "";
        this.customData = new HashMap<String, Object>();
        this.secondarySpawnRate = 100;
        this.reportSpawningInLog = false;
        this.shouldDespawn = true;
        this.maxSpawnInChunk = 4;
        this.minDropNum = 0;
        this.maxDropNum = 0;
        this.lootItems = new ArrayList<WeightedItemStack>();
        this.mobName = mobName;
    }

    public void addLootToMob(final ItemStack itemStack, final int weight) {
        this.lootItems.add(
            new WeightedItemStack(
                Item.itemRegistry.getNameForObject((Object) itemStack.getItem()),
                itemStack.getItemDamage(),
                itemStack.stackSize,
                weight));
    }

    public void addLootToMob(final String itemID, final int itemDamage, final int stackSize, final int weight) {
        this.lootItems.add(new WeightedItemStack(itemID, itemDamage, stackSize, weight));
    }

    public ItemStack getLootItem(final Random rand) {
        if (this.lootItems != null && !this.lootItems.isEmpty()) {
            final WeightedItemStack stack = (WeightedItemStack) WeightedRandom
                .getRandomItem(rand, (Collection) this.lootItems);
            final Item item = (Item) Item.itemRegistry.getObject(stack.itemID);
            if (item != null) {
                return new ItemStack(item, stack.stackSize, stack.itemDamage);
            }
        }
        return null;
    }

    public Collection<ItemStack> getLoot(final Random rand, final int extraDrops) {
        final int numberOfItems = this.minDropNum + rand.nextInt(1 + this.maxDropNum - this.minDropNum + extraDrops);
        final List<ItemStack> items = new ArrayList<ItemStack>(numberOfItems);
        for (int i = 0; i < numberOfItems; ++i) {
            final ItemStack stack = this.getLootItem(rand);
            if (stack != null) {
                items.add(stack);
            }
        }
        return items;
    }

    public static class WeightedItemStack extends WeightedRandom.Item {

        public final String itemID;
        public final int itemDamage;
        public final int stackSize;

        public WeightedItemStack(final String itemID, final int itemDamage, final int stackSize, final int weight) {
            super(weight);
            this.itemID = itemID;
            this.itemDamage = itemDamage;
            this.stackSize = stackSize;
        }
    }
}
