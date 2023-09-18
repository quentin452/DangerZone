
package fr.iamacat.dangerzone_iamacatfr.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public abstract class SubItemPotion {

    public final Item item;
    public final int subID;
    public final String baseName;

    SubItemPotion(final Item item, final int subID, final String baseName) {
        this.subID = subID;
        this.item = item;
        this.baseName = baseName;
    }

    public String getDisplayName(final ItemStack itemStack) {
        return StatCollector.translateToLocal(this.baseName)
            .trim() + " Potion";
    }

    public abstract void register();

    public abstract boolean hasPotionEffects(final ItemStack p0);

    public ItemStack getPotionResult(final ItemStack ingredient, final ItemStack brewingStack) {
        return null;
    }

    public abstract List<PotionEffect> getPotionEffects(final int p0);

    public List<PotionEffect> getPotionEffects(final ItemStack itemStack) {
        return this.getPotionEffects(itemStack.getItemDamage());
    }

    public abstract void getSubItems(final Item p0, final CreativeTabs p1, final List<ItemStack> p2);

    public abstract boolean isEffectInstant(final int p0);

    public abstract void addInformation(final ItemStack p0, final EntityPlayer p1, final List<String> p2,
        final boolean p3);

    public ItemStack onEaten(final ItemStack itemStack, final World world, final EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) {
            --itemStack.stackSize;
        }
        if (!world.isRemote) {
            final List<PotionEffect> list = this.getPotionEffects(itemStack);
            if (list != null) {
                for (final PotionEffect potioneffect : list) {
                    player.addPotionEffect(new PotionEffect(potioneffect));
                }
            }
        }
        if (!player.capabilities.isCreativeMode) {
            if (itemStack.stackSize <= 0) {
                return new ItemStack(Items.glass_bottle);
            }
            player.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle));
        }
        return itemStack;
    }

    public ItemStack onItemRightClick(final ItemStack itemStack, final World world, final EntityPlayer player) {
        if (PotionParser.isSplash(itemStack.getItemDamage())) {
            if (!player.capabilities.isCreativeMode) {
                --itemStack.stackSize;
            }
            world.playSoundAtEntity((Entity) player, "random.bow", 0.5f, 0.4f / (world.rand.nextFloat() * 0.4f + 0.8f));
            if (!world.isRemote) {
                world.spawnEntityInWorld((Entity) this.getEntityPotion(itemStack, world, player));
            }
            return itemStack;
        }
        player.setItemInUse(
            itemStack,
            itemStack.getItem()
                .getMaxItemUseDuration(itemStack));
        return itemStack;
    }

    protected EntityPotion getEntityPotion(final ItemStack itemStack, final World world, final EntityPlayer player) {
        return new EntityPotion(world, (EntityLivingBase) player, itemStack);
    }
}
