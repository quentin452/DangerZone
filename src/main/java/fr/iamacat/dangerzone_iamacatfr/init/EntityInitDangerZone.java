package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
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

        EntityRegistry
            .registerGlobalEntityID(BlackHeelsInstance.class, "Black Heels Entity DangerZone", BlackHeelsInstance);

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

        EntityRegistry.registerGlobalEntityID(
            DeadIrukandjInstance.class,
            "Dead Irukandji Entity DangerZone",
            DeadIrukandjInstance);

        EntityRegistry.registerModEntity(
            DeadIrukandjInstance.class,
            "Dead Irukandji Entity DangerZone",
            DeadIrukandjInstance, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);
        int GameControllerInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            GameControllerInstance.class,
            "GameControllerInstanceDangerZone",
            GameControllerInstance);

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

        EntityRegistry
            .registerGlobalEntityID(SunspotUrchinInstance.class, "SunspotUrchinInstance", SunspotUrchinInstance);

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

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.RatInstance.class,
            "RatInstance",
            RatInstance);

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

        int AttackSquidInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AttackSquidInstance.class, "AttackSquidInstance", AttackSquidInstance);

        EntityRegistry.registerModEntity(
            AttackSquidInstance.class,
            "AttackSquidInstance",
            AttackSquidInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityAlpsDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityAlpsDragon.class,
            "EntityAlpsDragon",
            EntityAlpsDragon);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityAlpsDragon.class,
            "EntityAlpsDragon",
            EntityAlpsDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityAngelDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityAngelDragon.class, "EntityAngelDragon", EntityAngelDragon);

        EntityRegistry.registerModEntity(
            EntityAngelDragon.class,
            "EntityAngelDragon",
            EntityAngelDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityBirchDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBirchDragon.class,
            "EntityBirchDragon",
            EntityBirchDragon);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBirchDragon.class,
            "EntityBirchDragon",
            EntityBirchDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityBlazeDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBlazeDragon.class,
            "EntityBlazeDragon",
            EntityBlazeDragon);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBlazeDragon.class,
            "EntityBlazeDragon",
            EntityBlazeDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityBluestoneDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBluestoneDragon.class,
            "EntityBluestoneDragon",
            EntityBluestoneDragon);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.EntityBluestoneDragon.class,
            "EntityBluestoneDragon",
            EntityBluestoneDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityBoneDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityBoneDragon.class, "EntityBoneDragon", EntityBoneDragon);

        EntityRegistry.registerModEntity(
            EntityBoneDragon.class,
            "EntityBoneDragon",
            EntityBoneDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityCactusDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityCactusDragon.class, "EntityCactusDragon", EntityCactusDragon);

        EntityRegistry.registerModEntity(
            EntityCactusDragon.class,
            "EntityCactusDragon",
            EntityCactusDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityCaveDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityCaveDragon.class, "EntityCaveDragon", EntityCaveDragon);

        EntityRegistry.registerModEntity(
            EntityCaveDragon.class,
            "EntityCaveDragon",
            EntityCaveDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityCloudDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityCloudDragon.class, "EntityCloudDragon", EntityCloudDragon);

        EntityRegistry.registerModEntity(
            EntityCloudDragon.class,
            "EntityCloudDragon",
            EntityCloudDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityDesertDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityDesertDragon.class, "EntityDesertDragon", EntityDesertDragon);

        EntityRegistry.registerModEntity(
            EntityDesertDragon.class,
            "EntityDesertDragon",
            EntityDesertDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityDiamondDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityDiamondDragon.class, "EntityDiamondDragon", EntityDiamondDragon);

        EntityRegistry.registerModEntity(
            EntityDiamondDragon.class,
            "EntityDiamondDragon",
            EntityDiamondDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityEmeraldDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityEmeraldDragon.class, "EntityEmeraldDragon", EntityEmeraldDragon);

        EntityRegistry.registerModEntity(
            EntityEmeraldDragon.class,
            "EntityEmeraldDragon",
            EntityEmeraldDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityEndDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityEndDragon.class, "EntityEndDragon", EntityEndDragon);

        EntityRegistry.registerModEntity(
            EntityEndDragon.class,
            "EntityEndDragon",
            EntityEndDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityEnthralledDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(EntityEnthralledDragon.class, "EntityEnthralledDragon", EntityEnthralledDragon);

        EntityRegistry.registerModEntity(
            EntityEnthralledDragon.class,
            "EntityEnthralledDragon",
            EntityEnthralledDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityExHillsDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityExHillsDragon.class, "EntityExHillsDragon", EntityExHillsDragon);

        EntityRegistry.registerModEntity(
            EntityExHillsDragon.class,
            "EntityExHillsDragon",
            EntityExHillsDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityForestDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityForestDragon.class, "EntityForestDragon", EntityForestDragon);

        EntityRegistry.registerModEntity(
            EntityForestDragon.class,
            "EntityForestDragon",
            EntityForestDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityGoldDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityGoldDragon.class, "EntityGoldDragon", EntityGoldDragon);

        EntityRegistry.registerModEntity(
            EntityGoldDragon.class,
            "EntityGoldDragon",
            EntityGoldDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityIronDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityIronDragon.class, "EntityIronDragon", EntityIronDragon);

        EntityRegistry.registerModEntity(
            EntityIronDragon.class,
            "EntityIronDragon",
            EntityIronDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityJugleDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityJungleDragon.class, "EntityJugleDragon", EntityJugleDragon);

        EntityRegistry.registerModEntity(
            EntityJungleDragon.class,
            "EntityJugleDragon",
            EntityJugleDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityKleurloosDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityKleurloos.class, "EntityKleurloosDragon", EntityKleurloosDragon);

        EntityRegistry.registerModEntity(
            EntityKleurloos.class,
            "EntityKleurloosDragon",
            EntityKleurloosDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityLapisDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityLapisDragon.class, "EntityLapisDragon", EntityLapisDragon);

        EntityRegistry.registerModEntity(
            EntityLapisDragon.class,
            "EntityLapisDragon",
            EntityLapisDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityMesaDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityMesaDragon.class, "EntityMesaDragon", EntityMesaDragon);

        EntityRegistry.registerModEntity(
            EntityMesaDragon.class,
            "EntityMesaDragon",
            EntityMesaDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityMushroomDragon1 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(EntityMushroomDragon1.class, "EntityMushroomDragon1", EntityMushroomDragon1);

        EntityRegistry.registerModEntity(
            EntityMushroomDragon1.class,
            "EntityMushroomDragon1",
            EntityMushroomDragon1, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityMushroomDragon2 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(EntityMushroomDragon2.class, "EntityMushroomDragon2", EntityMushroomDragon2);

        EntityRegistry.registerModEntity(
            EntityMushroomDragon2.class,
            "EntityMushroomDragon2",
            EntityMushroomDragon2, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityNetherDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityNetherDragon.class, "EntityNetherDragon", EntityNetherDragon);

        EntityRegistry.registerModEntity(
            EntityNetherDragon.class,
            "EntityNetherDragon",
            EntityNetherDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityOceanDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityOceanDragon.class, "EntityOceanDragon", EntityOceanDragon);

        EntityRegistry.registerModEntity(
            EntityOceanDragon.class,
            "EntityOceanDragon",
            AttackSquidInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityPlainsDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityPlainsDragon.class, "EntityPlainsDragon", EntityPlainsDragon);

        EntityRegistry.registerModEntity(
            EntityPlainsDragon.class,
            "EntityPlainsDragon",
            EntityPlainsDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityPlainsDragon2 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityPlainsDragon2.class, "EntityPlainsDragon2", EntityPlainsDragon2);

        EntityRegistry.registerModEntity(
            EntityPlainsDragon2.class,
            "EntityPlainsDragon2",
            EntityPlainsDragon2, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityRedstoneDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityRedstoneDragon.class, "EntityRedstoneDragon", EntityRedstoneDragon);

        EntityRegistry.registerModEntity(
            EntityRedstoneDragon.class,
            "EntityRedstoneDragon",
            EntityRedstoneDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityRiverDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityRiverDragon.class, "EntityRiverDragon", EntityRiverDragon);

        EntityRegistry.registerModEntity(
            EntityRiverDragon.class,
            "EntityRiverDragon",
            EntityRiverDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntitySavanaDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntitySavannaDragon.class, "EntitySavanaDragon", EntitySavanaDragon);

        EntityRegistry.registerModEntity(
            EntitySavannaDragon.class,
            "EntitySavanaDragon",
            EntitySavanaDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntitySnowDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntitySnowDragon.class, "EntitySnowDragon", EntitySnowDragon);

        EntityRegistry.registerModEntity(
            EntitySnowDragon.class,
            "EntitySnowDragon",
            EntitySnowDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntityStarDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityStarDragon.class, "EntityStarDragon", EntityStarDragon);

        EntityRegistry.registerModEntity(
            EntityStarDragon.class,
            "EntityStarDragon",
            EntityStarDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EntitySwampDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntitySwampDragon.class, "EntitySwampDragon", EntitySwampDragon);

        EntityRegistry.registerModEntity(
            EntitySwampDragon.class,
            "EntitySwampDragon",
            EntitySwampDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int EntityZombieDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityZombieDragon.class, "EntityZombieDragon", EntityZombieDragon);

        EntityRegistry.registerModEntity(
            EntityZombieDragon.class,
            "EntityZombieDragon",
            EntityZombieDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BaryonyxInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BaryonyxInstance.class, "BaryonyxInstance", BaryonyxInstance);

        EntityRegistry.registerModEntity(
            BaryonyxInstance.class,
            "BaryonyxInstance",
            BaryonyxInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MassoInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MassoInstance.class, "MassoInstance", MassoInstance);

        EntityRegistry.registerModEntity(
            MassoInstance.class,
            "MassoInstance",
            MassoInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BasilikInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BasilikInstance.class, "BasilikInstance", BasilikInstance);

        EntityRegistry.registerModEntity(
            BasilikInstance.class,
            "BasilikInstance",
            BasilikInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BeaverInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BeaverInstance.class, "BeaverInstance", BeaverInstance);

        EntityRegistry.registerModEntity(
            BeaverInstance.class,
            "BeaverInstance",
            BeaverInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
    }

}
