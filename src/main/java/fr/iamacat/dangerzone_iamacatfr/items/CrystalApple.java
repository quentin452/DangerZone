package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class CrystalApple extends ItemFood {

    // Ajoutez ces constantes pour les modifications souhaitées
    private static final int HEALS_AMOUNT = 5;
    private static final float SATURATION_MODIFIER = 0.85f;
    private static final int EFFECT_DURATION = 150;

    public CrystalApple() {
        // Utilisez les constantes pour définir les propriétés de l'aliment
        super(HEALS_AMOUNT, SATURATION_MODIFIER, false);
        this.setUnlocalizedName(Tags.MODID + ".crystal_apple");
        this.setTextureName(Tags.MODID + ":crystal_apple");
    }

    // Surchargez la méthode onFoodEaten pour ajouter les effets supplémentaires
    @Override
    protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
        super.onFoodEaten(stack, world, player);

        player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, EFFECT_DURATION * 20, 1)); // Strength
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, EFFECT_DURATION * 20, 0)); // Regeneration
    }
}
