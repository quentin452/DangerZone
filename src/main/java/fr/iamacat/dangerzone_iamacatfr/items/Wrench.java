package fr.iamacat.dangerzone_iamacatfr.items;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class Wrench extends Item {

    public Wrench() {
        this.maxStackSize = 1;
        this.setTextureName(Tags.MODID + ":wrench");
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) {
        // Vérifiez si l'entité est une araignée (Spider)
        if (entity instanceof EntitySpider) {
            EntitySpider spider = (EntitySpider) entity;

            // Tuez l'araignée
            spider.setDead();
        }

        return true;
    }
}
