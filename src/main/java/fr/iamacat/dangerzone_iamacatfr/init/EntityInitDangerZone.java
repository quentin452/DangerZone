package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.AppleCowInstance;
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
    }
}
