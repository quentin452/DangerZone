package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
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

        EntityRegistry.registerGlobalEntityID(GirlfriendInstance.class, "Girl Friend DangerZone", GirlFriend);

        EntityRegistry.registerModEntity(
            TermiteInstance.class,
            "Girl Friend DangerZone",
            GirlFriend, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BoyFriend = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BoyfriendInstance.class, "Boy Friend DangerZone", BoyFriend);

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

        int DeadIrukandjInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(Irukandji.class, "Dead Irukandji Entity DangerZone", DeadIrukandjInstance);

        EntityRegistry.registerModEntity(
            Irukandji.class,
            "Dead Irukandji Entity DangerZone",
            DeadIrukandjInstance, // Use the chosen unique ID
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

        EntityRegistry.registerGlobalEntityID(TwilightMobInstance.class, "TwilightMob", TwilightMob);

        EntityRegistry.registerModEntity(
            TwilightMobInstance.class,
            "TwilightMob",
            TwilightMob, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int DemonSpiderEntity = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DemonSpiderInstance.class, "DemonSpiderEntity", DemonSpiderEntity);

        EntityRegistry.registerModEntity(
            DemonSpiderInstance.class,
            "DemonSpiderEntity",
            DemonSpiderEntity, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyLeviathan = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LeviathanInstance.class, "MyLeviathan", MyLeviathan);

        EntityRegistry.registerModEntity(
            LeviathanInstance.class,
            "MyLeviathan",
            MyLeviathan, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyThunderHooves = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThunderHoovesInstance.class, "MyThunderHooves", MyThunderHooves);

        EntityRegistry.registerModEntity(
            ThunderHoovesInstance.class,
            "MyThunderHooves",
            MyThunderHooves, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyTwilicorn = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilicornInstance.class, "MyTwilicorn", MyTwilicorn);

        EntityRegistry.registerModEntity(
            TwilicornInstance.class,
            "MyTwilicorn",
            MyTwilicorn, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyKingbowser = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(KingbowserInstance.class, "MyKingbowser", MyKingbowser);

        EntityRegistry.registerModEntity(
            KingbowserInstance.class,
            "MyKingbowser",
            MyKingbowser, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyCentipede = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CentipedeInstance.class, "MyCentipede", MyCentipede);

        EntityRegistry.registerModEntity(
            CentipedeInstance.class,
            "MyCentipede",
            MyCentipede, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMLPHydra = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HydraInstance.class, "MyMLPHydra", MyMLPHydra);

        EntityRegistry.registerModEntity(
            HydraInstance.class,
            "MyMLPHydra",
            MyMLPHydra, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyWindigo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WindigoInstance.class, "MyWindigo", MyWindigo);

        EntityRegistry.registerModEntity(
            WindigoInstance.class,
            "MyWindigo",
            MyWindigo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMoose = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MooseInstance.class, "MyMoose", MyMoose);

        EntityRegistry.registerModEntity(
            MooseInstance.class,
            "MyMoose",
            MyMoose, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyMLPBuffalo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BuffaloInstance.class, "MyMLPBuffalo", MyMLPBuffalo);

        EntityRegistry.registerModEntity(
            BuffaloInstance.class,
            "MyMLPBuffalo",
            MyMLPBuffalo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyDarkness = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DarknessInstance.class, "MyDarkness", MyDarkness);

        EntityRegistry.registerModEntity(
            DarknessInstance.class,
            "MyDarkness",
            MyDarkness, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyTwilightMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightMagicInstance.class, "MyTwilightMagic", MyTwilightMagic);

        EntityRegistry.registerModEntity(
            TwilightMagicInstance.class,
            "MyTwilightMagic",
            MyTwilightMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int RobotBeam = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RobotBeamInstance.class, "RobotBeam", RobotBeam);

        EntityRegistry.registerModEntity(
            RobotBeamInstance.class,
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

        EntityRegistry.registerGlobalEntityID(FlameDragonInstance.class, "MyFlameDragon", MyFlameDragon);

        EntityRegistry.registerModEntity(
            FlameDragonInstance.class,
            "MyFlameDragon",
            MyFlameDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMooseBig = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MooseBigInstance.class, "MyMooseBig", MyMooseBig);

        EntityRegistry.registerModEntity(
            MooseBigInstance.class,
            "MyMooseBig",
            MyMooseBig, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyCragadile = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CragadileInstance.class, "MyCragadile", MyCragadile);

        EntityRegistry.registerModEntity(
            CragadileInstance.class,
            "MyCragadile",
            MyCragadile, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyBear = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BeaverInstance.class, "MyBear", MyBear);

        EntityRegistry.registerModEntity(
            BeaverInstance.class,
            "MyBear",
            MyBear, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyToughGuy = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ToughGuyInstance.class, "MyToughGuy", MyToughGuy);

        EntityRegistry.registerModEntity(
            ToughGuyInstance.class,
            "MyToughGuy",
            MyToughGuy, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyMavis = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MavisInstance.class, "MyMavis", MyMavis);

        EntityRegistry.registerModEntity(
            MavisInstance.class,
            "MyMavis",
            MyMavis, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyUrsaMAJOR = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UrsaMAJORInstance.class, "MyUrsaMAJOR", MyUrsaMAJOR);

        EntityRegistry.registerModEntity(
            UrsaMAJORInstance.class,
            "MyUrsaMAJOR",
            MyUrsaMAJOR, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyPhoenix = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PhoenixInstance.class, "MyPhoenix", MyPhoenix);

        EntityRegistry.registerModEntity(
            PhoenixInstance.class,
            "MyPhoenix",
            MyPhoenix, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyDash = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DashInstance.class, "MyDash", MyDash);

        EntityRegistry.registerModEntity(
            DashInstance.class,
            "MyDash",
            MyDash, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyManticore = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ManticoreInstance.class, "MyManticore", MyManticore);

        EntityRegistry.registerModEntity(
            ManticoreInstance.class,
            "MyManticore",
            MyManticore, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyRainbowCentipede = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowCentipedeInstance.class, "MyRainbowCentipede", MyRainbowCentipede);

        EntityRegistry.registerModEntity(
            RainbowCentipedeInstance.class,
            "MyRainbowCentipede",
            MyRainbowCentipede, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyParasprite = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ParaspriteInstance.class, "MyParasprite", MyParasprite);

        EntityRegistry.registerModEntity(
            ParaspriteInstance.class,
            "MyParasprite",
            MyParasprite, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyAJ = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AJInstance.class, "MyAJ", MyAJ);

        EntityRegistry.registerModEntity(
            AJInstance.class,
            "MyAJ",
            MyAJ, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyArcticScorpion = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ArcticScorpionInstance.class, "MyArcticScorpion", MyArcticScorpion);

        EntityRegistry.registerModEntity(
            ArcticScorpionInstance.class,
            "MyArcticScorpion",
            MyArcticScorpion, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyTimberWolf = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TimberWolfInstance.class, "MyTimberWolf", MyTimberWolf);

        EntityRegistry.registerModEntity(
            TimberWolfInstance.class,
            "MyTimberWolf",
            MyTimberWolf, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyCockatrice = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CockatriceInstance.class, "MyCockatrice", MyCockatrice);

        EntityRegistry.registerModEntity(
            CockatriceInstance.class,
            "MyCockatrice",
            MyCockatrice, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyIronWill = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IronWillInstance.class, "MyIronWill", MyIronWill);

        EntityRegistry.registerModEntity(
            IronWillInstance.class,
            "MyIronWill",
            MyIronWill, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int RainbowCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowCannonInstance.class, "RainbowCannon", RainbowCannon);

        EntityRegistry.registerModEntity(
            RainbowCannonInstance.class,
            "RainbowCannon",
            RainbowCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ProjectileApples = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ProjectileApplesInstance.class, "ProjectileApples", ProjectileApples);

        EntityRegistry.registerModEntity(
            ProjectileApplesInstance.class,
            "ProjectileApples",
            ProjectileApples, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyCrabzilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrabzillaInstance.class, "MyCrabzilla", MyCrabzilla);

        EntityRegistry.registerModEntity(
            CrabzillaInstance.class,
            "MyCrabzilla",
            MyCrabzilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyDashCloud = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DashCloudInstance.class, "MyDashCloud", MyDashCloud);

        EntityRegistry.registerModEntity(
            DashCloudInstance.class,
            "MyDashCloud",
            MyDashCloud, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TrevorPhillips = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TrevorPhillipsInstance.class, "TrevorPhillips", TrevorPhillips);

        EntityRegistry.registerModEntity(
            TrevorPhillipsInstance.class,
            "TrevorPhillips",
            TrevorPhillips, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MySkullBoss = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SkullBossInstance.class, "MySkullBoss", MySkullBoss);

        EntityRegistry.registerModEntity(
            SkullBossInstance.class,
            "MySkullBoss",
            MySkullBoss, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MySkull = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SkullInstance.class, "MySkull", MySkull);

        EntityRegistry.registerModEntity(
            SkullInstance.class,
            "MySkull",
            MySkull, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyYakPrince = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(YakPrinceInstance.class, "MyYakPrince", MyYakPrince);

        EntityRegistry.registerModEntity(
            YakPrinceInstance.class,
            "MyYakPrince",
            MyYakPrince, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MySpikezilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpikezillaInstance.class, "MySpikezilla", MySpikezilla);

        EntityRegistry.registerModEntity(
            SpikezillaInstance.class,
            "MySpikezilla",
            MySpikezilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int MyRhinoceros = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RhinocerosInstance.class, "MyRhinoceros", MyRhinoceros);

        EntityRegistry.registerModEntity(
            RhinocerosInstance.class,
            "MyRhinoceros",
            MyRhinoceros, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int TwilightCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightCannonInstance.class, "TwilightCannon", TwilightCannon);

        EntityRegistry.registerModEntity(
            TwilightCannonInstance.class,
            "TwilightCannon",
            TwilightCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int LaserBallMLP = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LaserBallSecondInstance.class, "LaserBallMLP", LaserBallMLP);

        EntityRegistry.registerModEntity(
            LaserBallSecondInstance.class,
            "LaserBallMLP",
            LaserBallMLP, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MavisBallDangerZone = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MavisBallInstance.class, "MavisBallDangerZone", MavisBallDangerZone);

        EntityRegistry.registerModEntity(
            MavisBallInstance.class,
            "MavisBallDangerZone",
            MavisBallDangerZone, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TwilicornArrow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilicornInstance.class, "TwilicornArrow", TwilicornArrow);

        EntityRegistry.registerModEntity(
            TwilicornInstance.class,
            "TwilicornArrow",
            TwilicornArrow, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int PhoenixArrow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PhoenixArrowInstance.class, "PhoenixArrow", PhoenixArrow);

        EntityRegistry.registerModEntity(
            PhoenixArrowInstance.class,
            "PhoenixArrow",
            PhoenixArrow, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TwilyMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilyMagicInstance.class, "TwilyMagic", TwilyMagic);

        EntityRegistry.registerModEntity(
            TwilyMagicInstance.class,
            "TwilyMagic",
            TwilyMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int DarkCrystalCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DarkCrystalCannonInstance.class, "DarkCrystalCannon", DarkCrystalCannon);

        EntityRegistry.registerModEntity(
            DarkCrystalCannonInstance.class,
            "DarkCrystalCannon",
            DarkCrystalCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WindigoPowerDangerZone = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(WindigoPowerInstance.class, "WindigoPowerDangerZone", WindigoPowerDangerZone);

        EntityRegistry.registerModEntity(
            WindigoPowerInstance.class,
            "WindigoPowerDangerZone",
            WindigoPowerDangerZone, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int LongHit = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LongHitInstance.class, "LongHit", LongHit);

        EntityRegistry.registerModEntity(
            LongHitInstance.class,
            "LongHit",
            LongHit, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int MyMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MagicInstance.class, "MyMagic", MyMagic);

        EntityRegistry.registerModEntity(
            MagicInstance.class,
            "MyMagic",
            MyMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int BetterFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BetterFireballInstancemMLP.class, "BetterFireball", BetterFireball);

        EntityRegistry.registerModEntity(
            BetterFireballInstancemMLP.class,
            "BetterFireball",
            BetterFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TwilightFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightFireballInstance.class, "TwilightFireball", TwilightFireball);

        EntityRegistry.registerModEntity(
            TwilightFireballInstance.class,
            "TwilightFireball",
            TwilightFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int HydraFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HydraFireballInstance.class, "HydraFireball", HydraFireball);

        EntityRegistry.registerModEntity(
            HydraFireballInstance.class,
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

        EntityRegistry.registerGlobalEntityID(
           GhostInstance.class,
            "GhostInstance",
            GhostInstance);

        EntityRegistry.registerModEntity(
            GhostInstance.class,
            "GhostInstance",
            GhostInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int RedAntRobotInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RedAntRobotInstance.class, "RedAntRobotInstance", RedAntRobotInstance);

        EntityRegistry.registerModEntity(
            RedAntRobotInstance.class,
            "RedAntRobotInstance",
            RedAntRobotInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BandPInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.BandPInstance.class,
            "BandPInstance",
            BandPInstance);

        EntityRegistry.registerModEntity(
            fr.iamacat.dangerzone_iamacatfr.entities.entity.BandPInstance.class,
            "BandPInstance",
            BandPInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int BasiliskInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BasiliskInstance.class, "BasiliskInstance", BasiliskInstance);

        EntityRegistry.registerModEntity(
            BasiliskInstance.class,
            "BasiliskInstance",
            BasiliskInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BrutalflyInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BrutalflyInstance.class, "BrutalflyInstance", BrutalflyInstance);

        EntityRegistry.registerModEntity(
            BrutalflyInstance.class,
            "BrutalflyInstance",
            BrutalflyInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int CamarasaurusInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CamarasaurusInstance.class, "CamarasaurusInstance", CamarasaurusInstance);

        EntityRegistry.registerModEntity(
            CamarasaurusInstance.class,
            "CamarasaurusInstance",
            CamarasaurusInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int CassowaryInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CassowaryInstance.class, "CassowaryInstance", CassowaryInstance);

        EntityRegistry.registerModEntity(
            CassowaryInstance.class,
            "CassowaryInstance",
            CassowaryInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int CaterKillerInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CaterKillerInstance.class, "CaterKillerInstance", CaterKillerInstance);

        EntityRegistry.registerModEntity(
            CaterKillerInstance.class,
            "CaterKillerInstance",
            CaterKillerInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int CephadromeInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CephadromeInstance.class, "CephadromeInstance", CephadromeInstance);

        EntityRegistry.registerModEntity(
            CephadromeInstance.class,
            "CephadromeInstance",
            CephadromeInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int CliffRacerInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CliffRacerInstance.class, "CliffRacerInstance", CliffRacerInstance);

        EntityRegistry.registerModEntity(
            CliffRacerInstance.class,
            "CliffRacerInstance",
            CliffRacerInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int CloudSharkInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CloudSharkInstance.class, "CloudSharkInstance", CloudSharkInstance);

        EntityRegistry.registerModEntity(
            CloudSharkInstance.class,
            "CloudSharkInstance",
            CloudSharkInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int CockateilInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CockateilInstance.class, "CockateilInstance", CockateilInstance);

        EntityRegistry.registerModEntity(
            CockateilInstance.class,
            "CockateilInstance",
            CockateilInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int CreepingHorrorInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(CreepingHorrorInstance.class, "CreepingHorrorInstance", CreepingHorrorInstance);

        EntityRegistry.registerModEntity(
            CreepingHorrorInstance.class,
            "CreepingHorrorInstance",
            CreepingHorrorInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int CricketInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CricketInstance.class, "CricketInstance", CricketInstance);

        EntityRegistry.registerModEntity(
            CricketInstance.class,
            "CricketInstance",
            CricketInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Cryolophosaurus = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CryolophosaurusInstance.class, "Cryolophosaurus", Cryolophosaurus);

        EntityRegistry.registerModEntity(
            CryolophosaurusInstance.class,
            "Cryolophosaurus",
            Cryolophosaurus, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int DeadIrukandjiInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(DeadIrukandjiInstance.class, "DeadIrukandjiInstance", DeadIrukandjiInstance);

        EntityRegistry.registerModEntity(
            DeadIrukandjiInstance.class,
            "DeadIrukandjiInstance",
            DeadIrukandjiInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int DragonInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DragonInstance.class, "DragonInstance", DragonInstance);

        EntityRegistry.registerModEntity(
            DragonInstance.class,
            "DragonInstance",
            DragonInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int DragonflyInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DragonflyInstance.class, "DragonflyInstance", DragonflyInstance);

        EntityRegistry.registerModEntity(
            DragonflyInstance.class,
            "DragonflyInstance",
            DragonflyInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int DungeonBeastInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DungeonBeastInstance.class, "DungeonBeastInstance", DungeonBeastInstance);

        EntityRegistry.registerModEntity(
            DungeonBeastInstance.class,
            "DungeonBeastInstance",
            DungeonBeastInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int EasterBunnyInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EasterBunnyInstance.class, "EasterBunnyInstance", EasterBunnyInstance);

        EntityRegistry.registerModEntity(
            EasterBunnyInstance.class,
            "EasterBunnyInstance",
            EasterBunnyInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int HoverboardInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HoverboardInstance.class, "HoverboardInstance", HoverboardInstance);

        EntityRegistry.registerModEntity(
            HoverboardInstance.class,
            "HoverboardInstance",
            HoverboardInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EmperorScorpion = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EmperorScorpion.class, "EmperorScorpion", EmperorScorpion);

        EntityRegistry.registerModEntity(
            EmperorScorpion.class,
            "EmperorScorpion",
            EmperorScorpion, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int EnderKnight = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EnderKnight.class, "EnderKnight", EnderKnight);

        EntityRegistry.registerModEntity(
            EnderKnight.class,
            "EnderKnight",
            EnderKnight, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int EnderReaper = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EnderReaper.class, "EnderReaper", EnderReaper);

        EntityRegistry.registerModEntity(
            EnderReaper.class,
            "EnderReaper",
            EnderReaper, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int CageInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CageInstance.class, "CageInstance", CageInstance);

        EntityRegistry.registerModEntity(
            CageInstance.class,
            "CageInstance",
            CageInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int CannonFodderInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CannonFodderInstance.class, "CannonFodderInstance", CannonFodderInstance);

        EntityRegistry.registerModEntity(
            CannonFodderInstance.class,
            "CannonFodderInstance",
            CannonFodderInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int LunaMothInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LunaMothInstance.class, "LunaMothInstance", LunaMothInstance);

        EntityRegistry.registerModEntity(
            LunaMothInstance.class,
            "LunaMothInstance",
            LunaMothInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int EntityThrownRockInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            EntityThrownRockInstance.class,
            "EntityThrownRockInstance",
            EntityThrownRockInstance);

        EntityRegistry.registerModEntity(
            EntityThrownRockInstance.class,
            "EntityThrownRockInstance",
            EntityThrownRockInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Firefly = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Firefly.class, "Firefly", Firefly);

        EntityRegistry.registerModEntity(
            Firefly.class,
            "Firefly",
            Firefly, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Flounder = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Flounder.class, "Flounder", Flounder);

        EntityRegistry.registerModEntity(
            Flounder.class,
            "Flounder",
            Flounder, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Frog = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Frog.class, "Frog", Frog);

        EntityRegistry.registerModEntity(
            Frog.class,
            "Frog",
            Frog, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int GammaMetroid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GammaMetroid.class, "GammaMetroid", GammaMetroid);

        EntityRegistry.registerModEntity(
            GammaMetroid.class,
            "GammaMetroid",
            GammaMetroid, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Gazelle = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Gazelle.class, "Gazelle", Gazelle);

        EntityRegistry.registerModEntity(
            Gazelle.class,
            "Gazelle",
            Gazelle, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int GiantRobot = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GiantRobot.class, "GiantRobot", GiantRobot);

        EntityRegistry.registerModEntity(
            GiantRobot.class,
            "GiantRobot",
            GiantRobot, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Godzilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Godzilla.class, "Godzilla", Godzilla);

        EntityRegistry.registerModEntity(
            Godzilla.class,
            "Godzilla",
            Godzilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int GodzillaHead = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GodzillaHead.class, "GodzillaHead", GodzillaHead);

        EntityRegistry.registerModEntity(
            GodzillaHead.class,
            "GodzillaHead",
            GodzillaHead, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int GoldFish = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GoldFish.class, "GoldFish", GoldFish);

        EntityRegistry.registerModEntity(
            GoldFish.class,
            "GoldFish",
            GoldFish, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Hammerhead = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Hammerhead.class, "Hammerhead", Hammerhead);

        EntityRegistry.registerModEntity(
            Hammerhead.class,
            "Hammerhead",
            Hammerhead, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int HerculesBeetle = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HerculesBeetle.class, "HerculesBeetle", HerculesBeetle);

        EntityRegistry.registerModEntity(
            HerculesBeetle.class,
            "HerculesBeetle",
            HerculesBeetle, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Hydrolisc = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Hydrolisc.class, "Hydrolisc", Hydrolisc);

        EntityRegistry.registerModEntity(
            Hydrolisc.class,
            "Hydrolisc",
            Hydrolisc, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int IceBall = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IceBall.class, "IceBall", IceBall);

        EntityRegistry.registerModEntity(
            IceBall.class,
            "IceBall",
            IceBall, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Kraken = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Kraken.class, "Kraken", Kraken);

        EntityRegistry.registerModEntity(
            Kraken.class,
            "Kraken",
            Kraken, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int InkSack = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(InkSack.class, "InkSackDangerZone", InkSack);

        EntityRegistry.registerModEntity(
            InkSack.class,
            "InkSackDangerZone",
            InkSack, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Island = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Island.class, "Island", Island);

        EntityRegistry.registerModEntity(
            Island.class,
            "Island",
            Island, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int IslandToo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IslandToo.class, "IslandToo", IslandToo);

        EntityRegistry.registerModEntity(
            IslandToo.class,
            "IslandToo",
            IslandToo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int KingHead = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(KingHead.class, "KingHead", KingHead);

        EntityRegistry.registerModEntity(
            KingHead.class,
            "KingHead",
            KingHead, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Kyuubi = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Kyuubi.class, "Kyuubi", Kyuubi);

        EntityRegistry.registerModEntity(
            Kyuubi.class,
            "Kyuubi",
            Kyuubi, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int LeafMonster = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LeafMonster.class, "LeafMonster", LeafMonster);

        EntityRegistry.registerModEntity(
            LeafMonster.class,
            "LeafMonster",
            LeafMonster, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Leon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Leon.class, "Leon", Leon);

        EntityRegistry.registerModEntity(
            Leon.class,
            "Leon",
            Leon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Lizard = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Lizard.class, "Lizard", Lizard);

        EntityRegistry.registerModEntity(
            Lizard.class,
            "Lizard",
            Lizard, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int LurkingTerror = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LurkingTerror.class, "LurkingTerror", LurkingTerror);

        EntityRegistry.registerModEntity(
            LurkingTerror.class,
            "LurkingTerror",
            LurkingTerror, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Mantis = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Mantis.class, "Mantis", Mantis);

        EntityRegistry.registerModEntity(
            Mantis.class,
            "Mantis",
            Mantis, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Molenoid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Molenoid.class, "Molenoid", Molenoid);

        EntityRegistry.registerModEntity(
            Molenoid.class,
            "Molenoid",
            Molenoid, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Mothra = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Mothra.class, "Mothra", Mothra);

        EntityRegistry.registerModEntity(
            Mothra.class,
            "Mothra",
            Mothra, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int Robot1 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot1.class, "Robot1", Robot1);

        EntityRegistry.registerModEntity(
            Robot1.class,
            "Robot1",
            Robot1, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Robot2 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot2.class, "Robot2", Robot2);

        EntityRegistry.registerModEntity(
            Robot2.class,
            "Robot2",
            Robot2, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Robot3 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot3.class, "Robot3", Robot3);

        EntityRegistry.registerModEntity(
            Robot3.class,
            "Robot3",
            Robot3, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Robot4 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot4.class, "Robot4", Robot4);

        EntityRegistry.registerModEntity(
            Robot4.class,
            "Robot4",
            Robot4, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Robot5 = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot5.class, "Robot5", Robot5);

        EntityRegistry.registerModEntity(
            Robot5.class,
            "Robot5",
            Robot5, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Nastysaurus = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Nastysaurus.class, "Nastysaurus", Nastysaurus);

        EntityRegistry.registerModEntity(
            Nastysaurus.class,
            "Nastysaurus",
            Nastysaurus, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Ostrich = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Ostrich.class, "Ostrich", Ostrich);

        EntityRegistry.registerModEntity(
            Ostrich.class,
            "Ostrich",
            Ostrich, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WormLarge = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WormLarge.class, "WormLarge", WormLarge);

        EntityRegistry.registerModEntity(
            WormLarge.class,
            "WormLarge",
            WormLarge, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WormMedium = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WormMedium.class, "WormMedium", WormMedium);

        EntityRegistry.registerModEntity(
            WormMedium.class,
            "WormMedium",
            WormMedium, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WormSmall = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WormSmall.class, "WormSmall", WormSmall);

        EntityRegistry.registerModEntity(
            WormSmall.class,
            "WormSmall",
            WormSmall, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Rat = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Rat.class, "Rat", Rat);

        EntityRegistry.registerModEntity(
            Rat.class,
            "Rat",
            Rat, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Peacock = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Peacock.class, "Peacock", Peacock);

        EntityRegistry.registerModEntity(
            Peacock.class,
            "Peacock",
            Peacock, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int PitchBlack = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PitchBlack.class, "PitchBlack", PitchBlack);

        EntityRegistry.registerModEntity(
            PitchBlack.class,
            "PitchBlack",
            PitchBlack, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Pointysaurus = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Pointysaurus.class, "Pointysaurus", Pointysaurus);

        EntityRegistry.registerModEntity(
            Pointysaurus.class,
            "Pointysaurus",
            Pointysaurus, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int PurplePower = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PurplePower.class, "PurplePower", PurplePower);

        EntityRegistry.registerModEntity(
            PurplePower.class,
            "PurplePower",
            PurplePower, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int QueenHead = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(QueenHead.class, "QueenHead", QueenHead);

        EntityRegistry.registerModEntity(
            QueenHead.class,
            "QueenHead",
            QueenHead, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int RockBase = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RockBase.class, "RockBase", RockBase);

        EntityRegistry.registerModEntity(
            RockBase.class,
            "RockBase",
            RockBase, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Rotator = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Rotator.class, "Rotator", Rotator);

        EntityRegistry.registerModEntity(
            Rotator.class,
            "Rotator",
            Rotator, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TheKing = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TheKing.class, "TheKing", TheKing);

        EntityRegistry.registerModEntity(
            TheKing.class,
            "TheKing",
            TheKing, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ThePrince = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrince.class, "ThePrince", ThePrince);

        EntityRegistry.registerModEntity(
            ThePrince.class,
            "ThePrince",
            ThePrince, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ThePrinceAdult = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrinceAdult.class, "ThePrinceAdult", ThePrinceAdult);

        EntityRegistry.registerModEntity(
            ThePrinceAdult.class,
            "ThePrinceAdult",
            ThePrinceAdult, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int ThePrincess = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrincess.class, "ThePrincess", ThePrincess);

        EntityRegistry.registerModEntity(
            ThePrincess.class,
            "ThePrincess",
            ThePrincess, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int ThePrinceTeen = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrinceTeen.class, "ThePrinceTeen", ThePrinceTeen);

        EntityRegistry.registerModEntity(
            ThePrinceTeen.class,
            "ThePrinceTeen",
            ThePrinceTeen, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TerribleTerror = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TerribleTerror.class, "TerribleTerror", TerribleTerror);

        EntityRegistry.registerModEntity(
            TerribleTerror.class,
            "TerribleTerror",
            TerribleTerror, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TheQueen = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TheQueen.class, "TheQueen", TheQueen);

        EntityRegistry.registerModEntity(
            TheQueen.class,
            "TheQueen",
            TheQueen, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int RubberDucky = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RubberDucky.class, "RubberDucky", RubberDucky);

        EntityRegistry.registerModEntity(
            RubberDucky.class,
            "RubberDucky",
            RubberDucky, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int RubyBird = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RubyBird.class, "RubyBird", RubyBird);

        EntityRegistry.registerModEntity(
            RubyBird.class,
            "RubyBird",
            RubyBird, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Scorpion = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Scorpion.class, "Scorpion", Scorpion);

        EntityRegistry.registerModEntity(
            Scorpion.class,
            "Scorpion",
            Scorpion, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int SeaMonster = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SeaMonster.class, "SeaMonster", SeaMonster);

        EntityRegistry.registerModEntity(
            SeaMonster.class,
            "SeaMonster",
            SeaMonster, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Vortex = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Vortex.class, "Vortex", Vortex);

        EntityRegistry.registerModEntity(
            Vortex.class,
            "Vortex",
            Vortex, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WaterDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WaterDragon.class, "WaterDragon", WaterDragon);

        EntityRegistry.registerModEntity(
            WaterDragon.class,
            "WaterDragon",
            WaterDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int TRex = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TRex.class, "TRex", TRex);

        EntityRegistry.registerModEntity(
            TRex.class,
            "TRex",
            TRex, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Triffid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Triffid.class, "Triffid", Triffid);

        EntityRegistry.registerModEntity(
            Triffid.class,
            "Triffid",
            Triffid, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int SeaViper = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SeaViper.class, "SeaViper", SeaViper);

        EntityRegistry.registerModEntity(
            SeaViper.class,
            "SeaViper",
            SeaViper, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Shoes = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Shoes.class, "Shoes", Shoes);

        EntityRegistry.registerModEntity(
            Shoes.class,
            "Shoes",
            Shoes, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Skate = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Skate.class, "Skate", Skate);

        EntityRegistry.registerModEntity(
            Skate.class,
            "Skate",
            Skate, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int SpiderDriver = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpiderDriver.class, "SpiderDriver", SpiderDriver);

        EntityRegistry.registerModEntity(
            SpiderDriver.class,
            "SpiderDriver",
            SpiderDriver, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int SpiderRobot = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpiderRobot.class, "SpiderRobot", SpiderRobot);

        EntityRegistry.registerModEntity(
            SpiderRobot.class,
            "SpiderRobot",
            SpiderRobot, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int SpitBug = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpitBug.class, "SpitBug", SpitBug);

        EntityRegistry.registerModEntity(
            SpitBug.class,
            "SpitBug",
            SpitBug, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Spyro = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Spyro.class, "Spyro", Spyro);

        EntityRegistry.registerModEntity(
            Spyro.class,
            "Spyro",
            Spyro, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int StinkBug = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(StinkBug.class, "StinkBug", StinkBug);

        EntityRegistry.registerModEntity(
            StinkBug.class,
            "StinkBug",
            StinkBug, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Stinky = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Stinky.class, "Stinky", Stinky);

        EntityRegistry.registerModEntity(
            Stinky.class,
            "Stinky",
            Stinky, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int SunspotUrchin = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SunspotUrchin.class, "SunspotUrchinDangerZone", SunspotUrchin);

        EntityRegistry.registerModEntity(
            SunspotUrchin.class,
            "SunspotUrchinDangerZone",
            SunspotUrchin, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int ThunderBolt = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThunderBolt.class, "ThunderBolt", ThunderBolt);

        EntityRegistry.registerModEntity(
            ThunderBolt.class,
            "ThunderBolt",
            ThunderBolt, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int TrooperBug = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TrooperBug.class, "TrooperBug", TrooperBug);

        EntityRegistry.registerModEntity(
            TrooperBug.class,
            "TrooperBug",
            TrooperBug, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int UltimateArrow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UltimateArrow.class, "UltimateArrow", UltimateArrow);

        EntityRegistry.registerModEntity(
            ThunderBolt.class,
            "ThunderBolt",
            ThunderBolt, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int Urchin = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Urchin.class, "Urchin", Urchin);

        EntityRegistry.registerModEntity(
            Urchin.class,
            "Urchin",
            Urchin, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int VelocityRaptor = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(VelocityRaptor.class, "VelocityRaptor", VelocityRaptor);

        EntityRegistry.registerModEntity(
            VelocityRaptor.class,
            "VelocityRaptor",
            VelocityRaptor, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        int BetterFireballInstanceOrespawn = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BetterFireballInstanceOrespawn.class, "BetterFireballInstanceOrespawn", BetterFireballInstanceOrespawn);

        EntityRegistry.registerModEntity(
            BetterFireballInstanceOrespawn.class,
            "BetterFireballInstanceOrespawn",
            BetterFireballInstanceOrespawn, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int WaterBallInstanceOrespawn = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WaterBallInstanceOrespawn.class, "WaterBallInstanceOrespawn", WaterBallInstanceOrespawn);

        EntityRegistry.registerModEntity(
            WaterBallInstanceOrespawn.class,
            "WaterBallInstanceOrespawn",
            WaterBallInstanceOrespawn, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
    }

}
