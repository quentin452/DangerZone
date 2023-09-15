package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

public class ToolMaterialModded {

    public static final Item.ToolMaterial POISONMATERIAL = EnumHelper.addToolMaterial(
        "POISONMATERIAL", // Nom du matériau
        3, // Niveau de harvest
        1561, // Durabilité
        8.0F, // Vitesse d'attaque
        8.0F, // Dommages infligés
        10 // Enchantabilité
    );
    public static final Item.ToolMaterial NIGHTMAREMATERIAL = EnumHelper.addToolMaterial(
        "NIGHTMAREMATERIAL", // Nom du matériau
        3, // Niveau de harvest
        1561, // Durabilité
        8.0F, // Vitesse d'attaque
        10.0F, // Dommages infligés
        10 // Enchantabilité
    );
    public static final Item.ToolMaterial RatMATERIAL = EnumHelper.addToolMaterial(
        "RatMATERIAL", // Nom du matériau
        3, // Niveau de harvest
        100, // Durabilité
        8.0F, // Vitesse d'attaque
        5.0F, // Dommages infligés
        10 // Enchantabilité
    );
    public static final Item.ToolMaterial FAIRYMATERIAL = EnumHelper.addToolMaterial(
        "FAIRYMATERIAL", // Nom du matériau
        3, // Niveau de harvest
        100, // Durabilité
        8.0F, // Vitesse d'attaque
        8.0F, // Dommages infligés
        10 // Enchantabilité
    );
}