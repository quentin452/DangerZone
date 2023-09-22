package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
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

        EntityRegistry.registerGlobalEntityID(BetterFireballInstance.class, "BetterFireball", BetterFireball);

        EntityRegistry.registerModEntity(
            BetterFireballInstance.class,
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
        int Ghost = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
           Ghost.class,
            "Ghost",
            Ghost);

        EntityRegistry.registerModEntity(
            Ghost.class,
            "Ghost",
            Ghost, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        int GhostSkelly = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
            GhostSkelly.class,
            "GhostSkelly",
            GhostSkelly);

        EntityRegistry.registerModEntity(
            GhostSkelly.class,
            "GhostSkelly",
            GhostSkelly, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);




    }

}
