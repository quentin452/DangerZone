package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterialModded {
    public static final ItemArmor.ArmorMaterial AmethystBoots = EnumHelper.addArmorMaterial(
        "AmethystBoots",
        1500,
        new int[] {0, 0, 0, 3}, // Indice 3 pour les bottes
        70
    );
    public static final ItemArmor.ArmorMaterial AmethystChestplate = EnumHelper.addArmorMaterial(
        "AmethystChestplate",
        1500,
        new int[] {0, 8, 0, 0}, // Indice 1 pour le plastron
        70
    );
    public static final ItemArmor.ArmorMaterial AmethystHelmet = EnumHelper.addArmorMaterial(
        "AmethystHelmet",
        1500,
        new int[] {7,0, 0, 0}, // Indice 0 pour le casque
        70
    );
    public static final ItemArmor.ArmorMaterial AmethystLeggings = EnumHelper.addArmorMaterial(
        "AmethystLeggings",
        1500,
        new int[] {0, 0, 4, 0}, // Indice 2 pour les jambières
        70
    );
}
