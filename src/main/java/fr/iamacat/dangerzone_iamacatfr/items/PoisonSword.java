package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class PoisonSword extends ItemSword {

    public PoisonSword(ToolMaterial material) {
        super(material);
        this.setTextureName(Tags.MODID + ":poisonsword");
    }

    // damage
    @Override
    public float func_150931_i() {
        return 10f;
    }

    @Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {

        // Infliger les dégâts normaux
        super.hitEntity(stack, target, attacker);

        // Appliquer le statut poison
        if (target instanceof EntityLivingBase) {
            // Poison for 5 seconds
            target.addPotionEffect(new PotionEffect(Potion.poison.getId(), 100));
        }

        return true;
    }
}
