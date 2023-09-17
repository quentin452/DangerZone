package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;

public class DamageHelper {

    public static DamageSource bleed = new DamageSource("bleed").setDamageBypassesArmor(); //for the bleed potion effect
    public static DamageSource corruption = new DamageSource("corruption").setMagicDamage(); //for corruption/pure corruption potion effect damage
    public static DamageSource selfInflicted = new DamageSource("selfInflicted").setDamageIsAbsolute(); //for blood sacrifice and possibly other abilities in the future
    public static DamageSource spike = new DamageSource("spike").setDamageBypassesArmor(); //for ice spike damage

    /**
     * Should be used to inflict suffocation damage on entities
     * @param entity
     * @return
     */
    public static DamageSource causeSuffocationDamageFromMob(EntityLivingBase entity)
    {
        EntityDamageSource source = (EntityDamageSource) new EntityDamageSource("suffocation", entity).setDamageBypassesArmor().setDamageIsAbsolute();
        return source;
    }

    /**
     * Should be used for inflicting magic damage instead of using vanilla magic
     * @param entity
     * @return
     */
    public static DamageSource causeModMagicDamageToEntity(EntityLivingBase entity)
    {
        EntityDamageSource source = (EntityDamageSource) new EntityDamageSource("modMagic", entity).setDamageBypassesArmor().setMagicDamage();
        return source;
    }

    /**
     * Should be used to inflict damage from things that should be armor piercing, such as various Doomsday attacks
     * @param entity
     * @return
     */
    public static DamageSource causeArmorPiercingDamageToEntity(EntityLivingBase entity)
    {
        EntityDamageSource source = (EntityDamageSource) new EntityDamageSource("armorPiercing", entity).setDamageBypassesArmor();
        return source;
    }
}
