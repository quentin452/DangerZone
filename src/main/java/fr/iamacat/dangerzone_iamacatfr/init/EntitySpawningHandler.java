package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class EntitySpawningHandler {


    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        final GregorianCalendar gcalendar = new GregorianCalendar();
        final int nowmonth = gcalendar.get(2);
        final int nowday = gcalendar.get(5);
        if (nowmonth == 9 && nowday == 31) {
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.beach);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry
                .addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesa);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaigaHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.beach);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesa);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaigaHills);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 30, 8, 15, EnumCreatureType.creature, BiomeGenBase.beach);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.forest);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 8, 2, 5, EnumCreatureType.creature, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 3, EnumCreatureType.creature, BiomeGenBase.plains);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.river);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 4, EnumCreatureType.creature, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(GirlfriendInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 30, 8, 15, EnumCreatureType.creature, BiomeGenBase.beach);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.forest);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 8, 2, 5, EnumCreatureType.creature, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 3, EnumCreatureType.creature, BiomeGenBase.plains);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.river);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 4, EnumCreatureType.creature, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(GirlfriendInstance.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(BeaverInstance.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.river);
            EntityRegistry.addSpawn(BeaverInstance.class, 3, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest);
            EntityRegistry.addSpawn(BeaverInstance.class, 2, 2, 4, EnumCreatureType.creature, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(BeaverInstance.class, 2, 2, 5, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(BeaverInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(BeaverInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(AppleCowInstance.class, 8, 4, 8, EnumCreatureType.creature, BiomeGenBase.plains);
            EntityRegistry.addSpawn(BeaverInstance.class, 8, 4, 8, EnumCreatureType.creature, BiomeGenBase.forest);
            EntityRegistry.addSpawn(BeaverInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(BeaverInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(BeaverInstance.class, 8, 1, 3, EnumCreatureType.creature, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(BeaverInstance.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(GoldenAppleCowInstance.class, 5, 2, 6, EnumCreatureType.creature, BiomeGenBase.plains);
            EntityRegistry.addSpawn(GoldenAppleCowInstance.class, 5, 2, 6, EnumCreatureType.creature, BiomeGenBase.forest);
            EntityRegistry.addSpawn(GoldenAppleCowInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(GoldenAppleCowInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(EnchantedGoldenAppleCowInstance.class, 3, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest);
            EntityRegistry.addSpawn(EnchantedGoldenAppleCowInstance.class, 3, 2, 4, EnumCreatureType.creature, BiomeGenBase.plains);
            EntityRegistry.addSpawn(EnchantedGoldenAppleCowInstance.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
            EntityRegistry
                .addSpawn(EnchantedGoldenAppleCowInstance.class, 15, 3, 6, EnumCreatureType.creature, BiomeGenBase.mushroomIsland);
            EntityRegistry.addSpawn(BandPInstance.class, 20, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(BandPInstance.class, 20, 1, 2, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(BandPInstance.class, 20, 1, 2, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(WormLarge.class, 25, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains);
            EntityRegistry.addSpawn(WormLarge.class, 15, 1, 1, EnumCreatureType.creature, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(WormLarge.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(Firefly.class, 8, 5, 15, EnumCreatureType.ambient, BiomeGenBase.beach);
            EntityRegistry
                .addSpawn(Firefly.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry
                .addSpawn(Firefly.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(Firefly.class, 30, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry
                .addSpawn(Firefly.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(Firefly.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry
                .addSpawn(Firefly.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(Firefly.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(Firefly.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(Firefly.class, 20, 4, 10, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry
                .addSpawn(Firefly.class, 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(Firefly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(Firefly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(Firefly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(Firefly.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry
                .addSpawn(Firefly.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 8, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry
                .addSpawn(String.valueOf(LunaMothInstance.class), 8, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(String.valueOf(LunaMothInstance.class), 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry
                .addSpawn(String.valueOf(LunaMothInstance.class), 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(String.valueOf(LunaMothInstance.class), 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry
                .addSpawn(String.valueOf(LunaMothInstance.class), 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(CassowaryInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry.addSpawn(CassowaryInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(CassowaryInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsPlus);
            EntityRegistry.addSpawn(CassowaryInstance.class, 5, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(CassowaryInstance.class, 5, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(CassowaryInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(CassowaryInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
            EntityRegistry.addSpawn(CassowaryInstance.class, 3, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(CassowaryInstance.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(EasterBunnyInstance.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(EasterBunnyInstance.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(EasterBunnyInstance.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(EasterBunnyInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(EasterBunnyInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(EasterBunnyInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(EasterBunnyInstance.class, 8, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(Firefly.class, 10, 4, 8, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(Firefly.class, 10, 3, 6, EnumCreatureType.ambient, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(Firefly.class, 15, 3, 10, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(Firefly.class, 15, 3, 10, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
            EntityRegistry.addSpawn(Firefly.class, 10, 2, 8, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(Firefly.class, 10, 2, 8, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(WhaleRenderer.WhaleInstance.class, 1, 1, 2, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean);
            EntityRegistry.addSpawn(BeeInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(BeeInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(BeeInstance.class, 5, 3, 5, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(BeeInstance.class, 5, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(BeeInstance.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(BeeInstance.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(BeeInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(BeeInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(BeeInstance.class, 3, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(BeeInstance.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(Mantis.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(Mantis.class, 1, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry
                .addSpawn(HerculesBeetle.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taigaHills);
            EntityRegistry
                .addSpawn(HerculesBeetle.class, 5, 1, 1, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry
                .addSpawn(HerculesBeetle.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.coldTaigaHills);
            EntityRegistry
                .addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
            EntityRegistry.addSpawn(Molenoid.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(Molenoid.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(Molenoid.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 6, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(CaterKillerInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(CaterKillerInstance.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 8, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 4, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 4, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 2, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(ChipMunkInstance.class, 6, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(CephadromeInstance.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.icePlains);
            EntityRegistry.addSpawn(CephadromeInstance.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
            EntityRegistry.addSpawn(EntityMosquito.class, 30, 5, 10, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(EntityMosquito.class, 20, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry
                .addSpawn(EntityMosquito.class, 20, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry
                .addSpawn(EntityMosquito.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
            EntityRegistry.addSpawn(GhostInstance.class, 10, 5, 10, EnumCreatureType.ambient, BiomeGenBase.taigaHills);
            EntityRegistry.addSpawn(GhostInstance.class, 6, 4, 6, EnumCreatureType.ambient, BiomeGenBase.frozenRiver);
            EntityRegistry.addSpawn(GhostInstance.class, 2, 1, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
            EntityRegistry.addSpawn(GhostInstance.class, 10, 5, 10, EnumCreatureType.ambient, BiomeGenBase.taigaHills);
            EntityRegistry.addSpawn(GhostInstance.class, 6, 4, 6, EnumCreatureType.ambient, BiomeGenBase.frozenRiver);
            EntityRegistry.addSpawn(GhostInstance.class, 2, 1, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(GhostInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(DragonflyInstance.class, 5, 3, 5, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(DragonflyInstance.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(Kyuubi.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
            EntityRegistry.addSpawn(Stinky.class, 2, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
            EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesa);
            EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
            EntityRegistry.addSpawn(CockateilInstance.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.beach);
            EntityRegistry.addSpawn(CockateilInstance.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry.addSpawn(CockateilInstance.class, 10, 2, 4, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(CockateilInstance.class, 25, 5, 10, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(CockateilInstance.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(CockateilInstance.class, 35, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(CockateilInstance.class, 25, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(CockateilInstance.class, 10, 2, 4, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(CockateilInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(CockateilInstance.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(CockateilInstance.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(CockateilInstance.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(CockateilInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(CockateilInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(CockateilInstance.class, 11, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(CockateilInstance.class, 11, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(Hydrolisc.class, 25, 3, 6, EnumCreatureType.creature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(Hydrolisc.class, 15, 2, 5, EnumCreatureType.creature, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(Hydrolisc.class, 10, 1, 3, EnumCreatureType.creature, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(Hydrolisc.class, 5, 3, 6, EnumCreatureType.creature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(Mothra.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry.addSpawn(Mothra.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.extremeHillsPlus);
            EntityRegistry.addSpawn(BrutalflyInstance.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
            EntityRegistry.addSpawn(BrutalflyInstance.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.extremeHillsPlus);
            EntityRegistry.addSpawn(BrutalflyInstance.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            EntityRegistry.addSpawn(WaterDragon.class, 5, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.river);
            EntityRegistry.addSpawn(WaterDragon.class, 3, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(WaterDragon.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            EntityRegistry
                .addSpawn(WaterDragon.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(SeaMonster.class, 4, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            EntityRegistry.addSpawn(SeaMonster.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(SeaViper.class, 3, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            EntityRegistry.addSpawn(SeaViper.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(CrabInstance.class, 2, 3, 6, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            EntityRegistry.addSpawn(CrabInstance.class, 1, 3, 6, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(CrabInstance.class, 1, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(AttackSquidInstance.class, 12, 6, 10, EnumCreatureType.waterCreature, BiomeGenBase.river);
            EntityRegistry
                .addSpawn(AttackSquidInstance.class, 10, 5, 9, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(AttackSquidInstance.class, 7, 4, 8, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            EntityRegistry.addSpawn(Lizard.class, 5, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.river);
            EntityRegistry.addSpawn(Lizard.class, 4, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(Lizard.class, 2, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            EntityRegistry.addSpawn(RubberDucky.class, 10, 10, 20, EnumCreatureType.waterCreature, BiomeGenBase.river);
            EntityRegistry
                .addSpawn(RubberDucky.class, 4, 4, 6, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            EntityRegistry.addSpawn(BasiliskInstance.class, 3, 1, 1, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(BasiliskInstance.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(BasiliskInstance.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(BasiliskInstance.class, 15, 1, 2, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(EmperorScorpion.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(EmperorScorpion.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(TrooperBug.class, 3, 1, 2, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(TrooperBug.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesa);
            EntityRegistry.addSpawn(SpitBug.class, 6, 1, 2, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(StinkBug.class, 10, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(StinkBug.class, 8, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(StinkBug.class, 6, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(StinkBug.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(StinkBug.class, 8, 2, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(Scorpion.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(Scorpion.class, 28, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(Scorpion.class, 15, 3, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry.addSpawn(Scorpion.class, 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(Scorpion.class, 6, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesa);
            EntityRegistry.addSpawn(Scorpion.class, 4, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            EntityRegistry.addSpawn(Scorpion.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
            EntityRegistry.addSpawn(LeafMonster.class, 5, 2, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(LeafMonster.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(LeafMonster.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(LeafMonster.class, 3, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(LeafMonster.class, 3, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(LeafMonster.class, 2, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(LeafMonster.class, 2, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(LeafMonster.class, 2, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry
                .addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(EnderKnight.class, 20, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry
                .addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.desert);
            EntityRegistry.addSpawn(EnderReaper.class, 38, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(CricketInstance.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry.addSpawn(CricketInstance.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(CricketInstance.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(CricketInstance.class, 2, 3, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(CricketInstance.class, 3, 4, 8, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(CricketInstance.class, 2, 2, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry.addSpawn(CricketInstance.class, 2, 2, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry.addSpawn(CricketInstance.class, 3, 1, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(CricketInstance.class, 2, 1, 6, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(CricketInstance.class, 2, 1, 6, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(CricketInstance.class, 1, 1, 4, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            EntityRegistry.addSpawn(Frog.class, 20, 3, 6, EnumCreatureType.waterCreature, BiomeGenBase.river);
            EntityRegistry.addSpawn(Frog.class, 3, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry.addSpawn(Frog.class, 3, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry.addSpawn(Frog.class, 20, 2, 6, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(Frog.class, 2, 2, 6, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry.addSpawn(Peacock.class, 1, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesa);
            EntityRegistry.addSpawn(Peacock.class, 1, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            EntityRegistry.addSpawn(FairyInstance.class, 25, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(Rat.class, 35, 10, 20, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            EntityRegistry.addSpawn(Rat.class, 25, 2, 8, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(DungeonBeastInstance.class, 20, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
        }
    }
}
