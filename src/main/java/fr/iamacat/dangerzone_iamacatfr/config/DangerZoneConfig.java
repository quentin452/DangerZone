package fr.iamacat.dangerzone_iamacatfr.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class DangerZoneConfig extends Configuration {

    public static boolean allowExtraBossLoot;
    public static int MeteorStrikeDamage;

    public static int bossDamageCap = 25;
    public static int SPAWN_FACTION_MIN_SIZE = 8;
    public static int SPAWN_FACTION_MAX_SIZE = 10;
    public static int DarkCrystalDamage = 9750;

    public static double GENERAL_HEALTH_BASE = 15.0D;
    public static float GENERAL_SPEED_BASE = 0.9F;
    public static float GENERAL_SPEED_SCOUT = 1.05F;
    public static float GENERAL_SPEED_WITHER_MULT = 0.75F;

    public static float BEHAVIOR_PATH_RANGE = 16F;
    public static float BEHAVIOR_PURSUE_RANGE = BEHAVIOR_PATH_RANGE;
    public static float BEHAVIOR_DEFEND_RANGE = BEHAVIOR_PURSUE_RANGE / 2;
    public static float BEHAVIOR_FEAR_RANGE = 12F;

    // how long will tame fairies stay mad? 3x for wild
    public static int BEHAVIOR_AGGRO_TIMER = 15;

    // fall speed
    public static double DEF_FLOAT_RATE = -0.2D;
    // fly speed
    public static double DEF_FLAP_RATE = 0.15D;
    // bonus to flight while unburdened
    public static double DEF_SOLO_FLAP_MULT = 1.25D;
    // bonus to flight when launching
    public static double DEF_LIFTOFF_MULT = 2.0D;

    public static int DEF_MAX_PARTICLES = 5;

    public DangerZoneConfig(File file) {
        super(file);

        load();
        init();
        save();
    }

    private void init() {
        /**
         * Spawning behaviors
         */
        SPAWN_FACTION_MAX_SIZE = getInt(
            "max",
            "spawning",
            SPAWN_FACTION_MAX_SIZE,
            0,
            30,
            "maximum fairy spawn group size");
        SPAWN_FACTION_MIN_SIZE = getInt(
            "min",
            "spawning",
            SPAWN_FACTION_MIN_SIZE,
            0,
            30,
            "minimum fairy spawn group size");
        // TODO: validate that min is <= max

        /**
         * General fairy stats
         */
        GENERAL_HEALTH_BASE = getFloat(
            "health.base",
            "general",
            (float) GENERAL_HEALTH_BASE,
            1.0F,
            40.0F,
            "base maximum health");
        GENERAL_SPEED_BASE = getFloat("speed.base", "general", GENERAL_SPEED_BASE, 0.1F, 2.0F, "base move speed");
        GENERAL_SPEED_SCOUT = getFloat(
            "speed.scout",
            "general",
            GENERAL_SPEED_SCOUT,
            0.1F,
            2.0F,
            "move speed for scouts");
        GENERAL_SPEED_WITHER_MULT = getFloat(
            "speed.wither_mult",
            "general",
            GENERAL_SPEED_WITHER_MULT,
            0.05F,
            0.95F,
            "multiplier to speed for wither debuff (lower is slower)");

        /**
         * Behavior modifiers
         */
        BEHAVIOR_PATH_RANGE = getFloat(
            "range.path",
            "behavior",
            BEHAVIOR_PATH_RANGE,
            4.0F,
            32F,
            "how far will we path to something?");
        final float pursue_range_mult = getFloat(
            "range.pursue_mult",
            "behavior",
            1.0F,
            0.25F,
            2F,
            "how much farther will we chase something than our normal pathing?");
        final float defend_range_mult = getFloat(
            "range.defend_mult",
            "behavior",
            0.5F,
            0.25F,
            2F,
            "how close will guards stay to the queen?");
        BEHAVIOR_FEAR_RANGE = getFloat(
            "range.fear",
            "behavior",
            BEHAVIOR_FEAR_RANGE,
            4.0F,
            32F,
            "how far will we run away when afraid?");

        BEHAVIOR_PURSUE_RANGE = BEHAVIOR_PATH_RANGE * pursue_range_mult;
        BEHAVIOR_DEFEND_RANGE = BEHAVIOR_PATH_RANGE * defend_range_mult;

        BEHAVIOR_AGGRO_TIMER = getInt(
            "timer.anger",
            "behavior",
            BEHAVIOR_AGGRO_TIMER,
            1,
            100,
            "how long will tame fairies stay angry? (wild are 3x this)");

        allowExtraBossLoot = getBoolean(
            "allowExtraBossLoot",
            "general",
            true,
            "Can Bosses drop a lot of extra normal loot in addition to their specific drops?");

        bossDamageCap = getInt(
            "bossDamageCap",
            "general",
            25,
            1,
            Integer.MAX_VALUE,
            "Maximum damage cap for boss creatures");

        DarkCrystalDamage = getInt(
            "DarkCrystalDamage",
            "general",
            9750,
            0,
            Integer.MAX_VALUE,
            "Dark Crystal Projectile Damage");
        MeteorStrikeDamage = getInt("DarkCrystalDamage", "general", 350, 0, Integer.MAX_VALUE, "Meteor Strike Damage");

    }

}
