
package fr.iamacat.dangerzone_iamacatfr.util;

import net.minecraftforge.common.config.Configuration;

public class EntityProperties {

    public final float maxHealth;
    public final float attackDamage;
    public final float moveSpeed;
    public final float followRange;
    public final float knockbackResistance;
    public final float flightChance;
    public final float aggroLevel;
    public final double aggroRange;

    public EntityProperties(final float health, final float strength, final float moveSpeed) {
        this(health, strength, moveSpeed, 0.0f);
    }

    public EntityProperties(final float health, final float strength, final float moveSpeed, final float flightChance) {
        this(health, strength, moveSpeed, flightChance, 0.0f, 32.0f);
    }

    public EntityProperties(final float health, final float strength, final float moveSpeed, final float flightChance,
        final float knockback, final float followRange) {
        this(health, strength, moveSpeed, flightChance, knockback, followRange, 10.0f, 16.0);
    }

    public EntityProperties(final float health, final float strength, final float moveSpeed, final float flightChance,
        final float knockback, final float followRange, final float aggroLevel, final double aggroRange) {
        this.maxHealth = health;
        this.attackDamage = strength;
        this.moveSpeed = moveSpeed;
        this.flightChance = flightChance;
        this.knockbackResistance = knockback;
        this.followRange = followRange;
        this.aggroLevel = aggroLevel;
        this.aggroRange = aggroRange;
    }

    public EntityProperties createFromConfig(final Configuration config, final String entityName) {
        final float maxHealth = (float) config.get("MOB CONTROLS." + entityName, "maxHealth", (double) this.maxHealth)
            .getDouble((double) this.maxHealth);
        final float attackDamage = (float) config
            .get("MOB CONTROLS." + entityName, "attackDamage", (double) this.attackDamage)
            .getDouble((double) this.attackDamage);
        final float moveSpeed = (float) config.get("MOB CONTROLS." + entityName, "moveSpeed", (double) this.moveSpeed)
            .getDouble((double) this.moveSpeed);
        final float flightChance = (float) config
            .get("MOB CONTROLS." + entityName, "flightChance", (double) this.flightChance)
            .getDouble((double) this.flightChance);
        final float knockbackResistance = (float) config
            .get("MOB CONTROLS." + entityName, "knockbackResistance", (double) this.knockbackResistance)
            .getDouble((double) this.knockbackResistance);
        final float followRange = (float) config
            .get("MOB CONTROLS." + entityName, "followRange", (double) this.followRange)
            .getDouble((double) this.followRange);
        final float aggroLevel = (float) config
            .get("MOB CONTROLS." + entityName, "aggroLevel", (double) this.aggroLevel)
            .getDouble((double) this.aggroLevel);
        final double aggroRange = config.get("MOB CONTROLS." + entityName, "aggroRange", this.aggroRange)
            .getDouble(this.aggroRange);
        return new EntityProperties(
            maxHealth,
            attackDamage,
            moveSpeed,
            flightChance,
            knockbackResistance,
            followRange,
            aggroLevel,
            aggroRange);
    }
}
