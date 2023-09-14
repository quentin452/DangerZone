package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EntityInitDangerZone {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        // Choose a unique ID for the "Apple Cow" entity
        int appleCowId = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AppleCowInstance.class, "Apple Cow DangerZone", appleCowId);

        EntityRegistry.registerModEntity(
            AppleCowInstance.class,
            "Apple Cow DangerZone",
            appleCowId, // Use the chosen unique ID
            Tags.MODID,
            64,
            1,
            false);

        int CrystalCowId = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrystalCowInstance.class, "Crystal Cow DangerZone", CrystalCowId);

        EntityRegistry.registerModEntity(
            CrystalCowInstance.class,
            "Crystal Cow DangerZone",
            CrystalCowId, // Use the chosen unique ID
            Tags.MODID,
            64,
            1,
            false);

        int EnchantedGoldenAppleCow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            EnchantedGoldenAppleCowInstance.class,
            "Enchanted Golden Apple Cow DangerZone",
            EnchantedGoldenAppleCow);

        EntityRegistry.registerModEntity(
            EnchantedGoldenAppleCowInstance.class,
            "Enchanted Golden Apple Cow DangerZone",
            EnchantedGoldenAppleCow, // Use the chosen unique ID
            Tags.MODID,
            64,
            1,
            false);

        int GoldenAppleCow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(GoldenAppleCowInstance.class, "Golden Apple Cow DangerZone", GoldenAppleCow);

        EntityRegistry.registerModEntity(
            GoldenAppleCowInstance.class,
            "Golden Apple Cow DangerZone",
            GoldenAppleCow, // Use the chosen unique ID
            Tags.MODID,
            64,
            1,
            false);

        int BrownAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BrownAntInstance.class, "Brown Ant DangerZone", BrownAnt);

        EntityRegistry.registerModEntity(
            BrownAntInstance.class,
            "Brown Ant DangerZone",
            BrownAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            false);

        int RedAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RedAntInstance.class, "Red Ant DangerZone", RedAnt);

        EntityRegistry.registerModEntity(
            RedAntInstance.class,
            "Red Ant DangerZone",
            RedAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            false);
        int UnstableAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UnstableAntInstance.class, "Unstable Ant DangerZone", UnstableAnt);

        EntityRegistry.registerModEntity(
            UnstableAntInstance.class,
            "Unstable Ant DangerZone",
            UnstableAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            false);
        int RainbowAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowAntInstance.class, "Rainbow Ant DangerZone", RainbowAnt);

        EntityRegistry.registerModEntity(
            RainbowAntInstance.class,
            "Rainbow Ant DangerZone",
            RainbowAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            false);
        int Termite = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TermiteInstance.class, "Termite DangerZone", Termite);

        EntityRegistry.registerModEntity(
            TermiteInstance.class,
            "Termite DangerZone",
            Termite, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            false);
    }

}
