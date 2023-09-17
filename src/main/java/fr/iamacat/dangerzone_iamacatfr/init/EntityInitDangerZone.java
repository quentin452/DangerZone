package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AlienInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.items.IrukandjiArrows;
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
            32,
            1,
            true);

        int CrystalCowId = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrystalCowInstance.class, "Crystal Cow DangerZone", CrystalCowId);

        EntityRegistry.registerModEntity(
            CrystalCowInstance.class,
            "Crystal Cow DangerZone",
            CrystalCowId, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

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
            32,
            1,
            true);

        int GoldenAppleCow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(GoldenAppleCowInstance.class, "Golden Apple Cow DangerZone", GoldenAppleCow);

        EntityRegistry.registerModEntity(
            GoldenAppleCowInstance.class,
            "Golden Apple Cow DangerZone",
            GoldenAppleCow, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BrownAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BrownAntInstance.class, "Brown Ant DangerZone", BrownAnt);

        EntityRegistry.registerModEntity(
            BrownAntInstance.class,
            "Brown Ant DangerZone",
            BrownAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            true);

        int RedAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RedAntInstance.class, "Red Ant DangerZone", RedAnt);

        EntityRegistry.registerModEntity(
            RedAntInstance.class,
            "Red Ant DangerZone",
            RedAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            true);
        int UnstableAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UnstableAntInstance.class, "Unstable Ant DangerZone", UnstableAnt);

        EntityRegistry.registerModEntity(
            UnstableAntInstance.class,
            "Unstable Ant DangerZone",
            UnstableAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            true);
        int RainbowAnt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowAntInstance.class, "Rainbow Ant DangerZone", RainbowAnt);

        EntityRegistry.registerModEntity(
            RainbowAntInstance.class,
            "Rainbow Ant DangerZone",
            RainbowAnt, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            true);
        int Termite = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TermiteInstance.class, "Termite DangerZone", Termite);

        EntityRegistry.registerModEntity(
            TermiteInstance.class,
            "Termite DangerZone",
            Termite, // Use the chosen unique ID
            Tags.MODID,
            22,
            1,
            true);

        int GirlFriend = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GirlFriendInstance.class, "Girl Friend DangerZone", GirlFriend);

        EntityRegistry.registerModEntity(
            TermiteInstance.class,
            "Girl Friend DangerZone",
            GirlFriend, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BoyFriend = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BoyFriendInstance.class, "Boy Friend DangerZone", BoyFriend);

        EntityRegistry.registerModEntity(
            TermiteInstance.class,
            "Boy Friend DangerZone",
            BoyFriend, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int TinyBird = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TinyBirdsInstance.class, "Tiny Bird DangerZone", TinyBird);

        EntityRegistry.registerModEntity(
            TinyBirdsInstance.class,
            "Boy Friend DangerZone",
            TinyBird, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int Bird = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BirdsInstance.class, "Bird DangerZone", Bird);

        EntityRegistry.registerModEntity(
            BirdsInstance.class,
            "Boy Friend DangerZone",
            Bird, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int CaveFisher = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CaveFisherInstance.class, "Cave Fisher DangerZone", CaveFisher);

        EntityRegistry.registerModEntity(
            CaveFisherInstance.class,
            "Cave Fisher DangerZone",
            CaveFisher, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int EyeRayProjectile = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EyeRayInstance.class, "Eye Ray DangerZone", EyeRayProjectile);

        EntityRegistry.registerModEntity(
            EyeRayInstance.class,
            "Eye Ray DangerZone",
            EyeRayProjectile, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int Fairy = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(FairyInstance.class, "Fairy DangerZone", Fairy);

        EntityRegistry.registerModEntity(
            FairyInstance.class,
            "Fairy DangerZone",
            Fairy, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int Crab = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrabInstance.class, "Crab DangerZone", Crab);

        EntityRegistry.registerModEntity(
            CrabInstance.class,
            "Crab DangerZone",
            Crab, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int LaserBall = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LaserBallInstance.class, "Laser Ball DangerZone", LaserBall);

        EntityRegistry.registerModEntity(
            LaserBallInstance.class,
            "Laser Ball DangerZone",
            LaserBall, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);
        int IrukandjiArrows = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IrukandjiArrows.class, "Irukandji Arrows DangerZone", IrukandjiArrows);

        EntityRegistry.registerModEntity(
            IrukandjiArrows.class,
            "Irukandji Arrows DangerZone",
            IrukandjiArrows, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int BlackHeelsInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BlackHeelsInstance.class, "Black Heels Entity DangerZone", BlackHeelsInstance);

        EntityRegistry.registerModEntity(
            BlackHeelsInstance.class,
            "Black Heels Entity DangerZone",
            BlackHeelsInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int BootsInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BootsInstance.class, "Boots DangerZone", BootsInstance);

        EntityRegistry.registerModEntity(
            BootsInstance.class,
            "Boots DangerZone",
            BootsInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int DeadIrukandjInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DeadIrukandjInstance.class, "Dead Irukandji Entity DangerZone", DeadIrukandjInstance);

        EntityRegistry.registerModEntity(
            DeadIrukandjInstance.class,
            "Dead Irukandji Entity DangerZone",
            DeadIrukandjInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);
        int GameControllerInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GameControllerInstance.class, "GameControllerInstanceDangerZone", GameControllerInstance);

        EntityRegistry.registerModEntity(
            GameControllerInstance.class,
            "GameControllerInstanceDangerZone",
            GameControllerInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int WaterBallInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WaterBallInstance.class, "WaterBallDangerZone", WaterBallInstance);

        EntityRegistry.registerModEntity(
            WaterBallInstance.class,
            "WaterBallDangerZone",
            WaterBallInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int ThunderStaffInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThunderStaffInstance.class, "ThunderStaffInstance", ThunderStaffInstance);

        EntityRegistry.registerModEntity(
            ThunderStaffInstance.class,
            "ThunderStaffInstance",
            ThunderStaffInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        int SunspotUrchinInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SunspotUrchinInstance.class, "SunspotUrchinInstance", SunspotUrchinInstance);

        EntityRegistry.registerModEntity(
            SunspotUrchinInstance.class,
            "SunspotUrchinInstance",
            SunspotUrchinInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);
        int SlippersInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SlippersInstance.class, "SlippersInstance", SlippersInstance);

        EntityRegistry.registerModEntity(
            SlippersInstance.class,
            "SlippersInstance",
            SlippersInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);
        int AlienInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AlienInstance.class, "AlienInstance", AlienInstance);

        EntityRegistry.registerModEntity(
            AlienInstance.class,
            "AlienInstance",
            AlienInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int RatInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(fr.iamacat.dangerzone_iamacatfr.entities.entity.RatInstance.class, "RatInstance", RatInstance);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.RatInstance.class,
            "RatInstance",
            RatInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);
        int AlosaurusInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AlosaurusInstance.class, "AlosaurusInstance", AlosaurusInstance);

        EntityRegistry.registerModEntity(
            AlosaurusInstance.class,
            "AlosaurusInstance",
            AlosaurusInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
    }

}
