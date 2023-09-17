package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EmeraldLeggings extends ItemArmor {

    public EmeraldLeggings(ArmorMaterial p_i45325_1_, int p_i45325_2_, int p_i45325_3_) {
        super(p_i45325_1_, p_i45325_2_, p_i45325_3_);
        this.setTextureName(Tags.MODID + ":ultimate_leggings");

    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {

        return Tags.MODID + ":textures/model/armors/ultimate_2.png";
    }

}
