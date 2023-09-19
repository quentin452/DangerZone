package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.GhostInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
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
        int EntityAetherDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityAetherDragon.class, "EntityAetherDragon", EntityAetherDragon);

        EntityRegistry.registerModEntity(
            EntityAetherDragon.class,
            "EntityAetherDragon",
            EntityAetherDragon, // Use the chosen unique ID
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
            EntityOceanDragon, // Use the chosen unique ID
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

        int BeeInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance.class,
            "BeeInstance",
            BeeInstance);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance.class,
            "BeeInstance",
            BeeInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ButerflyInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ButterflyInstance.class, "ButerflyInstance", ButerflyInstance);

        EntityRegistry.registerModEntity(
            ButterflyInstance.class,
            "ButerflyInstance",
            ButerflyInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ChipMunkInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ChipMunkInstance.class, "ChipMunkInstance", ChipMunkInstance);

        EntityRegistry.registerModEntity(
            ChipMunkInstance.class,
            "ChipMunkInstance",
            ChipMunkInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int WhaleInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WhaleRenderer.WhaleInstance.class, "WhaleInstance", WhaleInstance);

        EntityRegistry.registerModEntity(
            WhaleRenderer.WhaleInstance.class,
            "WhaleInstance",
            WhaleInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int TwilightMob = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightMob.class, "TwilightMob", TwilightMob);

        EntityRegistry.registerModEntity(
            TwilightMob.class,
            "TwilightMob",
            TwilightMob, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int DemonSpiderEntity = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DemonSpiderEntity.class, "DemonSpiderEntity", DemonSpiderEntity);

        EntityRegistry.registerModEntity(
            DemonSpiderEntity.class,
            "DemonSpiderEntity",
            DemonSpiderEntity, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyLeviathan = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyLeviathan.class, "MyLeviathan", MyLeviathan);

        EntityRegistry.registerModEntity(
            MyLeviathan.class,
            "MyLeviathan",
            MyLeviathan, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyThunderHooves = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyThunderHooves.class, "MyThunderHooves", MyThunderHooves);

        EntityRegistry.registerModEntity(
            MyThunderHooves.class,
            "MyThunderHooves",
            MyThunderHooves, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyTwilicorn = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyTwilicorn.class, "MyTwilicorn", MyTwilicorn);

        EntityRegistry.registerModEntity(
            MyTwilicorn.class,
            "MyTwilicorn",
            MyTwilicorn, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyKingbowser = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyKingbowser.class, "MyKingbowser", MyKingbowser);

        EntityRegistry.registerModEntity(
            MyKingbowser.class,
            "MyKingbowser",
            MyKingbowser, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyCentipede = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyCentipede.class, "MyCentipede", MyCentipede);

        EntityRegistry.registerModEntity(
            MyCentipede.class,
            "MyCentipede",
            MyCentipede, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMLPHydra = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyMLPHydra.class, "MyMLPHydra", MyMLPHydra);

        EntityRegistry.registerModEntity(
            MyMLPHydra.class,
            "MyMLPHydra",
            MyMLPHydra, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyWindigo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyWindigo.class, "MyWindigo", MyWindigo);

        EntityRegistry.registerModEntity(
            MyWindigo.class,
            "MyWindigo",
            MyWindigo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMoose = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyMoose.class, "MyMoose", MyMoose);

        EntityRegistry.registerModEntity(
            MyMoose.class,
            "MyMoose",
            MyMoose, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyMLPBuffalo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyMLPBuffalo.class, "MyMLPBuffalo", MyMLPBuffalo);

        EntityRegistry.registerModEntity(
            MyMLPBuffalo.class,
            "MyMLPBuffalo",
            MyMLPBuffalo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyDarkness = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyDarkness.class, "MyDarkness", MyDarkness);

        EntityRegistry.registerModEntity(
            MyDarkness.class,
            "MyDarkness",
            MyDarkness, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyTwilightMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyTwilightMagic.class, "MyTwilightMagic", MyTwilightMagic);

        EntityRegistry.registerModEntity(
            MyTwilightMagic.class,
            "MyTwilightMagic",
            MyTwilightMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int RobotBeam = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RobotBeam.class, "RobotBeam", RobotBeam);

        EntityRegistry.registerModEntity(
            RobotBeam.class,
            "RobotBeam",
            RobotBeam, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int FireCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(FireCannon.class, "FireCannon", FireCannon);

        EntityRegistry.registerModEntity(
            FireCannon.class,
            "FireCannon",
            FireCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyFlameDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyFlameDragon.class, "MyFlameDragon", MyFlameDragon);

        EntityRegistry.registerModEntity(
            MyFlameDragon.class,
            "MyFlameDragon",
            MyFlameDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMooseBig = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyMooseBig.class, "MyMooseBig", MyMooseBig);

        EntityRegistry.registerModEntity(
            MyMooseBig.class,
            "MyMooseBig",
            MyMooseBig, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyCragadile = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyCragadile.class, "MyCragadile", MyCragadile);

        EntityRegistry.registerModEntity(
            MyCragadile.class,
            "MyCragadile",
            MyCragadile, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyBear = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyBear.class, "MyBear", MyBear);

        EntityRegistry.registerModEntity(
            MyBear.class,
            "MyBear",
            MyBear, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyToughGuy = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyToughGuy.class, "MyToughGuy", MyToughGuy);

        EntityRegistry.registerModEntity(
            MyToughGuy.class,
            "MyToughGuy",
            MyToughGuy, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyMavis = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyMavis.class, "MyMavis", MyMavis);

        EntityRegistry.registerModEntity(
            MyMavis.class,
            "MyMavis",
            MyMavis, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyUrsaMAJOR = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyUrsaMAJOR.class, "MyUrsaMAJOR", MyUrsaMAJOR);

        EntityRegistry.registerModEntity(
            MyUrsaMAJOR.class,
            "MyUrsaMAJOR",
            MyUrsaMAJOR, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyPhoenix = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyPhoenix.class, "MyPhoenix", MyPhoenix);

        EntityRegistry.registerModEntity(
            MyPhoenix.class,
            "MyPhoenix",
            MyPhoenix, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyDash = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyDash.class, "MyDash", MyDash);

        EntityRegistry.registerModEntity(
            MyDash.class,
            "MyDash",
            MyDash, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyManticore = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyManticore.class, "MyManticore", MyManticore);

        EntityRegistry.registerModEntity(
            MyManticore.class,
            "MyManticore",
            MyManticore, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyRainbowCentipede = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyRainbowCentipede.class, "MyRainbowCentipede", MyRainbowCentipede);

        EntityRegistry.registerModEntity(
            MyRainbowCentipede.class,
            "MyRainbowCentipede",
            MyRainbowCentipede, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyParasprite = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyParasprite.class, "MyParasprite", MyParasprite);

        EntityRegistry.registerModEntity(
            MyParasprite.class,
            "MyParasprite",
            MyParasprite, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyAJ = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyAJ.class, "MyAJ", MyAJ);

        EntityRegistry.registerModEntity(
            MyAJ.class,
            "MyAJ",
            MyAJ, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyArcticScorpion = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyArcticScorpion.class, "MyArcticScorpion", MyArcticScorpion);

        EntityRegistry.registerModEntity(
            MyArcticScorpion.class,
            "MyArcticScorpion",
            MyArcticScorpion, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyTimberWolf = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyTimberWolf.class, "MyTimberWolf", MyTimberWolf);

        EntityRegistry.registerModEntity(
            MyTimberWolf.class,
            "MyTimberWolf",
            MyTimberWolf, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyCockatrice = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyCockatrice.class, "MyCockatrice", MyCockatrice);

        EntityRegistry.registerModEntity(
            MyCockatrice.class,
            "MyCockatrice",
            MyCockatrice, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyIronWill = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyIronWill.class, "MyIronWill", MyIronWill);

        EntityRegistry.registerModEntity(
            MyIronWill.class,
            "MyIronWill",
            MyIronWill, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int RainbowCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowCannon.class, "RainbowCannon", RainbowCannon);

        EntityRegistry.registerModEntity(
            RainbowCannon.class,
            "RainbowCannon",
            RainbowCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ProjectileApples = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ProjectileApples.class, "ProjectileApples", ProjectileApples);

        EntityRegistry.registerModEntity(
            ProjectileApples.class,
            "ProjectileApples",
            ProjectileApples, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyCrabzilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyCrabzilla.class, "MyCrabzilla", MyCrabzilla);

        EntityRegistry.registerModEntity(
            MyCrabzilla.class,
            "MyCrabzilla",
            MyCrabzilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyDashCloud = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyDashCloud.class, "MyDashCloud", MyDashCloud);

        EntityRegistry.registerModEntity(
            MyDashCloud.class,
            "MyDashCloud",
            MyDashCloud, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TrevorPhillips = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TrevorPhillips.class, "TrevorPhillips", TrevorPhillips);

        EntityRegistry.registerModEntity(
            TrevorPhillips.class,
            "TrevorPhillips",
            TrevorPhillips, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MySkullBoss = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MySkullBoss.class, "MySkullBoss", MySkullBoss);

        EntityRegistry.registerModEntity(
            MySkullBoss.class,
            "MySkullBoss",
            MySkullBoss, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MySkull = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MySkull.class, "MySkull", MySkull);

        EntityRegistry.registerModEntity(
            MySkull.class,
            "MySkull",
            MySkull, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyYakPrince = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyYakPrince.class, "MyYakPrince", MyYakPrince);

        EntityRegistry.registerModEntity(
            MyYakPrince.class,
            "MyYakPrince",
            MyYakPrince, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MySpikezilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MySpikezilla.class, "MySpikezilla", MySpikezilla);

        EntityRegistry.registerModEntity(
            MySpikezilla.class,
            "MySpikezilla",
            MySpikezilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyRhinoceros = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyRhinoceros.class, "MyRhinoceros", MyRhinoceros);

        EntityRegistry.registerModEntity(
            MyRhinoceros.class,
            "MyRhinoceros",
            MyRhinoceros, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int TwilightCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightCannon.class, "TwilightCannon", TwilightCannon);

        EntityRegistry.registerModEntity(
            TwilightCannon.class,
            "TwilightCannon",
            TwilightCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int LaserBallMLP = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LaserBallMLP.class, "LaserBallMLP", LaserBallMLP);

        EntityRegistry.registerModEntity(
            LaserBallMLP.class,
            "LaserBallMLP",
            LaserBallMLP, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MavisBallDangerZone = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.model.MavisBall.class,
            "MavisBallDangerZone",
            MavisBallDangerZone);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.model.MavisBall.class,
            "MavisBallDangerZone",
            MavisBallDangerZone, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TwilicornArrow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilicornArrow.class, "TwilicornArrow", TwilicornArrow);

        EntityRegistry.registerModEntity(
            TwilicornArrow.class,
            "TwilicornArrow",
            TwilicornArrow, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int PhoenixArrow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PhoenixArrow.class, "PhoenixArrow", PhoenixArrow);

        EntityRegistry.registerModEntity(
            PhoenixArrow.class,
            "PhoenixArrow",
            PhoenixArrow, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TwilyMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilyMagic.class, "TwilyMagic", TwilyMagic);

        EntityRegistry.registerModEntity(
            TwilyMagic.class,
            "TwilyMagic",
            TwilyMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int DarkCrystalCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DarkCrystalCannon.class, "DarkCrystalCannon", DarkCrystalCannon);

        EntityRegistry.registerModEntity(
            DarkCrystalCannon.class,
            "DarkCrystalCannon",
            DarkCrystalCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WindigoPowerDangerZone = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WindigoPower.class, "WindigoPowerDangerZone", WindigoPowerDangerZone);

        EntityRegistry.registerModEntity(
            WindigoPower.class,
            "WindigoPowerDangerZone",
            WindigoPowerDangerZone, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int LongHit = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LongHit.class, "LongHit", LongHit);

        EntityRegistry.registerModEntity(
            LongHit.class,
            "LongHit",
            LongHit, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MyMagic.class, "MyMagic", MyMagic);

        EntityRegistry.registerModEntity(
            MyMagic.class,
            "MyMagic",
            MyMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int BetterFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BetterFireball.class, "BetterFireball", BetterFireball);

        EntityRegistry.registerModEntity(
            BetterFireball.class,
            "BetterFireball",
            BetterFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TwilightFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightFireball.class, "TwilightFireball", TwilightFireball);

        EntityRegistry.registerModEntity(
            TwilightFireball.class,
            "TwilightFireball",
            TwilightFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int HydraFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HydraFireball.class, "HydraFireball", HydraFireball);

        EntityRegistry.registerModEntity(
            HydraFireball.class,
            "HydraFireball",
            HydraFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int FreezeBall = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(FreezeBall.class, "FreezeBall", FreezeBall);

        EntityRegistry.registerModEntity(
            FreezeBall.class,
            "FreezeBall",
            FreezeBall, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int GhostInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.GhostInstance.class, "GhostInstance", GhostInstance);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.GhostInstance.class,
            "GhostInstance",
            GhostInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

    }

}
