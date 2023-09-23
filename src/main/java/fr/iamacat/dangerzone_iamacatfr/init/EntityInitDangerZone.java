package fr.iamacat.dangerzone_iamacatfr.init;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.WhaleRenderer;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalCow;
import fr.iamacat.dangerzone_iamacatfr.items.UltimateFishHook;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class EntityInitDangerZone {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        // Choose a unique ID for the "Apple Cow" entity

        final int appleCowId = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AppleCowInstance.class, "Apple Cow DangerZone", appleCowId);

        EntityRegistry.registerModEntity(
            AppleCowInstance.class,
            "Apple Cow DangerZone",
            appleCowId, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int CrystalCowId = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrystalCowInstance.class, "Crystal Cow DangerZone", CrystalCowId);

        EntityRegistry.registerModEntity(
            CrystalCowInstance.class,
            "Crystal Cow DangerZone",
            CrystalCowId, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int GoldenAppleCow = EntityRegistry.findGlobalUniqueEntityId();

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

        final int EyeRayProjectile = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EyeRayInstance.class, "Eye Ray DangerZone", EyeRayProjectile);

        EntityRegistry.registerModEntity(
            EyeRayInstance.class,
            "Eye Ray DangerZone",
            EyeRayProjectile, // Use the chosen unique ID
            Tags.MODID,
            16,
            1,
            true);

        final int MassoInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MassoInstance.class, "MassoInstance", MassoInstance);

        EntityRegistry.registerModEntity(
            MassoInstance.class,
            "MassoInstance",
            MassoInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);


        final int WhaleInstance = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WhaleRenderer.WhaleInstance.class, "WhaleInstance", WhaleInstance);

        EntityRegistry.registerModEntity(
            WhaleRenderer.WhaleInstance.class,
            "WhaleInstance",
            WhaleInstance, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int TwilightMob = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightMobInstance.class, "TwilightMob", TwilightMob);

        EntityRegistry.registerModEntity(
            TwilightMobInstance.class,
            "TwilightMob",
            TwilightMob, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int DemonSpiderEntity = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DemonSpiderInstance.class, "DemonSpiderEntity", DemonSpiderEntity);

        EntityRegistry.registerModEntity(
            DemonSpiderInstance.class,
            "DemonSpiderEntity",
            DemonSpiderEntity, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyLeviathan = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LeviathanInstance.class, "MyLeviathan", MyLeviathan);

        EntityRegistry.registerModEntity(
            LeviathanInstance.class,
            "MyLeviathan",
            MyLeviathan, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyThunderHooves = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThunderHoovesInstance.class, "MyThunderHooves", MyThunderHooves);

        EntityRegistry.registerModEntity(
            ThunderHoovesInstance.class,
            "MyThunderHooves",
            MyThunderHooves, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyKingbowser = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(KingbowserInstance.class, "MyKingbowser", MyKingbowser);

        EntityRegistry.registerModEntity(
            KingbowserInstance.class,
            "MyKingbowser",
            MyKingbowser, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyCentipede = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CentipedeInstance.class, "MyCentipede", MyCentipede);

        EntityRegistry.registerModEntity(
            CentipedeInstance.class,
            "MyCentipede",
            MyCentipede, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyMLPHydra = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HydraInstance.class, "MyMLPHydra", MyMLPHydra);

        EntityRegistry.registerModEntity(
            HydraInstance.class,
            "MyMLPHydra",
            MyMLPHydra, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyWindigo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WindigoInstance.class, "MyWindigo", MyWindigo);

        EntityRegistry.registerModEntity(
            WindigoInstance.class,
            "MyWindigo",
            MyWindigo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyMoose = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MooseInstance.class, "MyMoose", MyMoose);

        EntityRegistry.registerModEntity(
            MooseInstance.class,
            "MyMoose",
            MyMoose, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyMLPBuffalo = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BuffaloInstance.class, "MyMLPBuffalo", MyMLPBuffalo);

        EntityRegistry.registerModEntity(
            BuffaloInstance.class,
            "MyMLPBuffalo",
            MyMLPBuffalo, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyDarkness = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DarknessInstance.class, "MyDarkness", MyDarkness);

        EntityRegistry.registerModEntity(
            DarknessInstance.class,
            "MyDarkness",
            MyDarkness, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int RobotBeam = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RobotBeamInstance.class, "RobotBeam", RobotBeam);

        EntityRegistry.registerModEntity(
            RobotBeamInstance.class,
            "RobotBeam",
            RobotBeam, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int FireCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(FireCannon.class, "FireCannon", FireCannon);

        EntityRegistry.registerModEntity(
            FireCannon.class,
            "FireCannon",
            FireCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyFlameDragon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(FlameDragonInstance.class, "MyFlameDragon", MyFlameDragon);

        EntityRegistry.registerModEntity(
            FlameDragonInstance.class,
            "MyFlameDragon",
            MyFlameDragon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyMooseBig = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MooseBigInstance.class, "MyMooseBig", MyMooseBig);

        EntityRegistry.registerModEntity(
            MooseBigInstance.class,
            "MyMooseBig",
            MyMooseBig, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyCragadile = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CragadileInstance.class, "MyCragadile", MyCragadile);

        EntityRegistry.registerModEntity(
            CragadileInstance.class,
            "MyCragadile",
            MyCragadile, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyToughGuy = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ToughGuyInstance.class, "MyToughGuy", MyToughGuy);

        EntityRegistry.registerModEntity(
            ToughGuyInstance.class,
            "MyToughGuy",
            MyToughGuy, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyMavis = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MavisInstance.class, "MyMavis", MyMavis);

        EntityRegistry.registerModEntity(
            MavisInstance.class,
            "MyMavis",
            MyMavis, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyUrsaMAJOR = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UrsaMAJORInstance.class, "MyUrsaMAJOR", MyUrsaMAJOR);

        EntityRegistry.registerModEntity(
            UrsaMAJORInstance.class,
            "MyUrsaMAJOR",
            MyUrsaMAJOR, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyPhoenix = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PhoenixInstance.class, "MyPhoenix", MyPhoenix);

        EntityRegistry.registerModEntity(
            PhoenixInstance.class,
            "MyPhoenix",
            MyPhoenix, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyDash = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DashInstance.class, "MyDash", MyDash);

        EntityRegistry.registerModEntity(
            DashInstance.class,
            "MyDash",
            MyDash, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyManticore = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ManticoreInstance.class, "MyManticore", MyManticore);

        EntityRegistry.registerModEntity(
            ManticoreInstance.class,
            "MyManticore",
            MyManticore, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyRainbowCentipede = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowCentipedeInstance.class, "MyRainbowCentipede", MyRainbowCentipede);

        EntityRegistry.registerModEntity(
            RainbowCentipedeInstance.class,
            "MyRainbowCentipede",
            MyRainbowCentipede, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyParasprite = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ParaspriteInstance.class, "MyParasprite", MyParasprite);

        EntityRegistry.registerModEntity(
            ParaspriteInstance.class,
            "MyParasprite",
            MyParasprite, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyAJ = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AJInstance.class, "MyAJ", MyAJ);

        EntityRegistry.registerModEntity(
            AJInstance.class,
            "MyAJ",
            MyAJ, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyArcticScorpion = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ArcticScorpionInstance.class, "MyArcticScorpion", MyArcticScorpion);

        EntityRegistry.registerModEntity(
            ArcticScorpionInstance.class,
            "MyArcticScorpion",
            MyArcticScorpion, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyTimberWolf = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TimberWolfInstance.class, "MyTimberWolf", MyTimberWolf);

        EntityRegistry.registerModEntity(
            TimberWolfInstance.class,
            "MyTimberWolf",
            MyTimberWolf, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyCockatrice = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CockatriceInstance.class, "MyCockatrice", MyCockatrice);

        EntityRegistry.registerModEntity(
            CockatriceInstance.class,
            "MyCockatrice",
            MyCockatrice, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyIronWill = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IronWillInstance.class, "MyIronWill", MyIronWill);

        EntityRegistry.registerModEntity(
            IronWillInstance.class,
            "MyIronWill",
            MyIronWill, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int RainbowCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RainbowCannonInstance.class, "RainbowCannon", RainbowCannon);

        EntityRegistry.registerModEntity(
            RainbowCannonInstance.class,
            "RainbowCannon",
            RainbowCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int ProjectileApples = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ProjectileApplesInstance.class, "ProjectileApples", ProjectileApples);

        EntityRegistry.registerModEntity(
            ProjectileApplesInstance.class,
            "ProjectileApples",
            ProjectileApples, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyCrabzilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrabzillaInstance.class, "MyCrabzilla", MyCrabzilla);

        EntityRegistry.registerModEntity(
            CrabzillaInstance.class,
            "MyCrabzilla",
            MyCrabzilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyDashCloud = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DashCloudInstance.class, "MyDashCloud", MyDashCloud);

        EntityRegistry.registerModEntity(
            DashCloudInstance.class,
            "MyDashCloud",
            MyDashCloud, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int TrevorPhillips = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TrevorPhillipsInstance.class, "TrevorPhillips", TrevorPhillips);

        EntityRegistry.registerModEntity(
            TrevorPhillipsInstance.class,
            "TrevorPhillips",
            TrevorPhillips, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MySkullBoss = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SkullBossInstance.class, "MySkullBoss", MySkullBoss);

        EntityRegistry.registerModEntity(
            SkullBossInstance.class,
            "MySkullBoss",
            MySkullBoss, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MySkull = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SkullInstance.class, "MySkull", MySkull);

        EntityRegistry.registerModEntity(
            SkullInstance.class,
            "MySkull",
            MySkull, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MyYakPrince = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(YakPrinceInstance.class, "MyYakPrince", MyYakPrince);

        EntityRegistry.registerModEntity(
            YakPrinceInstance.class,
            "MyYakPrince",
            MyYakPrince, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MySpikezilla = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpikezillaInstance.class, "MySpikezilla", MySpikezilla);

        EntityRegistry.registerModEntity(
            SpikezillaInstance.class,
            "MySpikezilla",
            MySpikezilla, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int MyRhinoceros = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RhinocerosInstance.class, "MyRhinoceros", MyRhinoceros);

        EntityRegistry.registerModEntity(
            RhinocerosInstance.class,
            "MyRhinoceros",
            MyRhinoceros, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int TwilightCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilightCannonInstance.class, "TwilightCannon", TwilightCannon);

        EntityRegistry.registerModEntity(
            TwilightCannonInstance.class,
            "TwilightCannon",
            TwilightCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int LaserBallMLP = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LaserBallSecondInstance.class, "LaserBallMLP", LaserBallMLP);

        EntityRegistry.registerModEntity(
            LaserBallSecondInstance.class,
            "LaserBallMLP",
            LaserBallMLP, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int MavisBallDangerZone = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MavisBallInstance.class, "MavisBallDangerZone", MavisBallDangerZone);

        EntityRegistry.registerModEntity(
            MavisBallInstance.class,
            "MavisBallDangerZone",
            MavisBallDangerZone, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int PhoenixArrow = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PhoenixArrowInstance.class, "PhoenixArrow", PhoenixArrow);

        EntityRegistry.registerModEntity(
            PhoenixArrowInstance.class,
            "PhoenixArrow",
            PhoenixArrow, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);

        final int  TwilyMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TwilyMagicInstance.class, "TwilyMagic", TwilyMagic);

        EntityRegistry.registerModEntity(
            TwilyMagicInstance.class,
            "TwilyMagic",
            TwilyMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int DarkCrystalCannon = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DarkCrystalCannonInstance.class, "DarkCrystalCannon", DarkCrystalCannon);

        EntityRegistry.registerModEntity(
            DarkCrystalCannonInstance.class,
            "DarkCrystalCannon",
            DarkCrystalCannon, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int WindigoPowerDangerZone = EntityRegistry.findGlobalUniqueEntityId();

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
        final int  LongHit = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LongHitInstance.class, "LongHit", LongHit);

        EntityRegistry.registerModEntity(
            LongHitInstance.class,
            "LongHit",
            LongHit, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
         final int MyMagic = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(MagicInstance.class, "MyMagic", MyMagic);

        EntityRegistry.registerModEntity(
            MagicInstance.class,
            "MyMagic",
            MyMagic, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int  BetterFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BetterFireballInstance.class, "BetterFireball", BetterFireball);

        EntityRegistry.registerModEntity(
            BetterFireballInstance.class,
            "BetterFireball",
            BetterFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int  HydraFireball = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HydraFireballInstance.class, "HydraFireball", HydraFireball);

        EntityRegistry.registerModEntity(
            HydraFireballInstance.class,
            "HydraFireball",
            HydraFireball, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int  FreezeBall = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(FreezeBall.class, "FreezeBall", FreezeBall);

        EntityRegistry.registerModEntity(
            FreezeBall.class,
            "FreezeBall",
            FreezeBall, // Use the chosen unique ID
            Tags.MODID,
            32,
            1,
            true);
        final int shoeid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Shoes.class, "Shoes", shoeid);

        EntityRegistry.registerModEntity(Shoes.class, "Shoes", shoeid, Tags.MODID, 64, 1, true);

    final int  hookid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UltimateFishHook .class, "UltimateFishHook", hookid);

    final int  urchinid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(fr.iamacat.dangerzone_iamacatfr.items.SunspotUrchin .class, "SunspotUrchin", urchinid);

        EntityRegistry.registerModEntity(fr.iamacat.dangerzone_iamacatfr.items.SunspotUrchin .class, "SunspotUrchin", urchinid, Tags.MODID, 64, 1, true);

    final int  waterballid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WaterBall.class, "WaterBall", waterballid);

        EntityRegistry.registerModEntity(WaterBall.class, "WaterBall", waterballid, Tags.MODID, 64, 1, true);

    final int  inksackid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(InkSack.class, "InkSack", inksackid);

        EntityRegistry.registerModEntity(InkSack.class, "InkSack", inksackid, Tags.MODID, 64, 1, true);

    final int  laserballid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LaserBall.class, "LaserBall", laserballid);

        EntityRegistry.registerModEntity(LaserBall.class, "LaserBall", laserballid, Tags.MODID, 64, 1, true);

    final int  iceballid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IceBall.class, "IceBall", iceballid);

        EntityRegistry.registerModEntity(IceBall.class, "IceBall", iceballid, Tags.MODID, 64, 1, true);

        final int arrowid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(UltimateArrow.class, "UltimateArrow", arrowid);

        final int irukandiarrowid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IrukandjiArrow.class, "IrukandjiArrow", irukandiarrowid);
    final int  acidid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry
            .registerGlobalEntityID(fr.iamacat.dangerzone_iamacatfr.entities.entity.Acid.class, "Acid", acidid);

        EntityRegistry.registerModEntity(
    fr.iamacat.dangerzone_iamacatfr.entities.entity.Acid.class,
        "Acid",
    acidid,
        Tags.MODID,
        64,
        1,
        true);
        final int cageid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityCage.class, "EntityCage", cageid);

        EntityRegistry.registerModEntity(EntityCage.class, "EntityCage", cageid, Tags.MODID, 64, 1, true);
    final int  Irukandjiid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(
    fr.iamacat.dangerzone_iamacatfr.entities.entity.DeadIrukandji.class,
        "DeadIrukandji",
    Irukandjiid);

        EntityRegistry.registerModEntity(
    fr.iamacat.dangerzone_iamacatfr.entities.entity.DeadIrukandji.class,
        "DeadIrukandji",
    Irukandjiid,
        Tags.MODID,
        64,
        1,
        true);

    final int  berthahitid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BerthaHit.class, "BerthaHit", berthahitid);

        EntityRegistry.registerModEntity(BerthaHit.class, "BerthaHit", berthahitid, Tags.MODID, 64, 1, true);

    final int  purplepowerid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PurplePower.class, "PurplePower", purplepowerid);

        EntityRegistry.registerModEntity(PurplePower.class, "PurplePower", purplepowerid, Tags.MODID, 64, 1, true);

    final int  rockid = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityThrownRock.class, "EntityThrownRock", rockid);

        EntityRegistry.registerModEntity(EntityThrownRock.class, "EntityThrownRock", rockid, Tags.MODID, 64, 1, true);


        final int  GirlfriendID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Girlfriend.class, "Girlfriend", GirlfriendID);

        EntityRegistry.registerModEntity(Girlfriend.class, "Girlfriend", GirlfriendID, Tags.MODID, 64, 1, false);

        final int   RedCowID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RedCow.class, "Apple Cow", RedCowID);

        EntityRegistry.registerModEntity(RedCow.class, "Apple Cow", RedCowID, Tags.MODID, 64, 1, false);

        final int   GoldCowID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GoldCow.class, "Golden Apple Cow", GoldCowID);

        EntityRegistry.registerModEntity(GoldCow.class, "Golden Apple Cow", GoldCowID, Tags.MODID, 64, 1, false);

        final int   EnchantedCowID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EnchantedCow.class, "Enchanted Golden Apple Cow", EnchantedCowID);

        EntityRegistry
            .registerModEntity(EnchantedCow.class, "Enchanted Golden Apple Cow", EnchantedCowID, Tags.MODID, 64, 1, false);

        final int   ButterflyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityButterfly.class, "Butterfly", ButterflyID);

        EntityRegistry.registerModEntity(EntityButterfly.class, "Butterfly", ButterflyID, Tags.MODID, 32, 1, false);

        final int  LunaMothID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityLunaMoth.class, "Moth", LunaMothID);

        EntityRegistry.registerModEntity(EntityLunaMoth.class, "Moth", LunaMothID, Tags.MODID, 32, 1, false);

        final int  MosquitoID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityMosquito.class, "Mosquito", MosquitoID);

        EntityRegistry.registerModEntity(EntityMosquito.class, "Mosquito", MosquitoID, Tags.MODID, 16, 1, false);

        final int FireflyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Firefly.class, "Firefly", FireflyID);

        EntityRegistry.registerModEntity(Firefly.class, "Firefly", FireflyID, Tags.MODID, 64, 1, false);

        final int  BeeID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Bee.class, "Bee", BeeID);

        EntityRegistry.registerModEntity(Bee.class, "Bee", BeeID, Tags.MODID, 64, 1, false);

        final int   MothraID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Mothra.class, "Mothra", MothraID);

        EntityRegistry.registerModEntity(Mothra.class, "Mothra", MothraID, Tags.MODID, 128, 1, false);

        final int  AntID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityAnt.class, "Ant", AntID);
        EntityRegistry.registerModEntity(EntityAnt.class, "Ant", AntID, Tags.MODID, 16, 1, false);

        final int  RedAntID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityRedAnt.class, "Red Ant", RedAntID);

        EntityRegistry.registerModEntity(EntityRedAnt.class, "Red Ant", RedAntID, Tags.MODID, 16, 1, false);

        final int  RainbowAntID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityRainbowAnt.class, "Rainbow Ant", RainbowAntID);

        EntityRegistry.registerModEntity(EntityRainbowAnt.class, "Rainbow Ant", RainbowAntID, Tags.MODID, 16, 1, false);

        final int     UnstableAntID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EntityUnstableAnt.class, "Unstable Ant", UnstableAntID);

        EntityRegistry.registerModEntity(EntityUnstableAnt.class, "Unstable Ant", UnstableAntID, Tags.MODID, 16, 1, false);

        final int   Robot1ID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot1.class, "Bomb-Omb", Robot1ID);

        EntityRegistry.registerModEntity(Robot1.class, "Bomb-Omb", Robot1ID, Tags.MODID, 32, 1, false);

        final int  Robot2ID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot2.class, "Robo-Pounder", Robot2ID);

        EntityRegistry.registerModEntity(Robot2.class, "Robo-Pounder", Robot2ID, Tags.MODID, 64, 1, false);

        final int  Robot3ID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot3.class, "Robo-Gunner", Robot3ID);

        EntityRegistry.registerModEntity(Robot3.class, "Robo-Gunner", Robot3ID, Tags.MODID, 64, 1, false);

        final int   Robot4ID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot4.class, "Robo-Warrior", Robot4ID);

        EntityRegistry.registerModEntity(Robot4.class, "Robo-Warrior", Robot4ID, Tags.MODID, 64, 1, false);

        final int   Robot5ID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Robot5.class, "Robo-Sniper", Robot5ID);

        EntityRegistry.registerModEntity(Robot5.class, "Robo-Sniper", Robot5ID, Tags.MODID, 64, 1, false);

        final int  AlosaurusID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Alosaurus.class, "Alosaurus", AlosaurusID);

        EntityRegistry.registerModEntity(Alosaurus.class, "Alosaurus", AlosaurusID, Tags.MODID, 64, 1, false);

        final int  CryolophosaurusID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Cryolophosaurus.class, "Cryolophosaurus", CryolophosaurusID);

        EntityRegistry
            .registerModEntity(Cryolophosaurus.class, "Cryolophosaurus", CryolophosaurusID, Tags.MODID, 64, 1, false);

        final int  BasiliskID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Basilisk.class, "Basilisk", BasiliskID);

        EntityRegistry.registerModEntity(Basilisk.class, "Basilisk", BasiliskID, Tags.MODID, 64, 1, false);

        final int   CamarasaurusID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Camarasaurus.class, "Camarasaurus", CamarasaurusID);

        EntityRegistry.registerModEntity(Camarasaurus.class, "Camarasaurus", CamarasaurusID, Tags.MODID, 64, 1, false);

        final int   HydroliscID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Hydrolisc.class, "Hydrolisc", HydroliscID);

        EntityRegistry.registerModEntity(Hydrolisc.class, "Hydrolisc", HydroliscID, Tags.MODID, 64, 1, false);

        final int  VelocityRaptorID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(VelocityRaptor.class, "Velocity Raptor", VelocityRaptorID);

        EntityRegistry.registerModEntity(VelocityRaptor.class, "Velocity Raptor", VelocityRaptorID, Tags.MODID, 64, 1, false);

        final int   DragonflyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Dragonfly.class, "Dragonfly", DragonflyID);

        EntityRegistry.registerModEntity(Dragonfly.class, "Dragonfly", DragonflyID, Tags.MODID, 64, 1, false);

        final int  EmperorScorpionID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EmperorScorpion.class, "Emperor Scorpion", EmperorScorpionID);

        EntityRegistry
            .registerModEntity(EmperorScorpion.class, "Emperor Scorpion", EmperorScorpionID, Tags.MODID, 64, 1, false);

        final int   ScorpionID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Scorpion.class, "Scorpion", ScorpionID);

        EntityRegistry.registerModEntity(Scorpion.class, "Scorpion", ScorpionID, Tags.MODID, 32, 1, false);

        final int   CaveFisherID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CaveFisher.class, "CaveFisher", CaveFisherID);

        EntityRegistry.registerModEntity(CaveFisher.class, "CaveFisher", CaveFisherID, Tags.MODID, 32, 1, false);

        final int  SpyroID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Spyro.class, "Baby Dragon", SpyroID);

        EntityRegistry.registerModEntity(Spyro.class, "Baby Dragon", SpyroID, Tags.MODID, 64, 1, false);

        final int   BaryonyxID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Baryonyx.class, "Baryonyx", BaryonyxID);

        EntityRegistry.registerModEntity(Baryonyx.class, "Baryonyx", BaryonyxID, Tags.MODID, 64, 1, false);

        final int    GammaMetroidID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GammaMetroid.class, "WTF?", GammaMetroidID);

        EntityRegistry.registerModEntity(GammaMetroid.class, "WTF?", GammaMetroidID, Tags.MODID, 64, 1, false);

        final int   CockateilID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Cockateil.class, "Bird", CockateilID);

        EntityRegistry.registerModEntity(Cockateil.class, "Bird", CockateilID, Tags.MODID, 32, 1, false);

        final int    RubyBirdID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RubyBird.class, "Ruby Bird", RubyBirdID);

        EntityRegistry.registerModEntity(RubyBird.class, "Ruby Bird", RubyBirdID, Tags.MODID, 32, 1, false);

        final int   KyuubiID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Kyuubi.class, "Kyuubi", KyuubiID);

        EntityRegistry.registerModEntity(Kyuubi.class, "Kyuubi", KyuubiID, Tags.MODID, 64, 1, false);

        final int   WaterDragonID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WaterDragon.class, "Water Dragon", WaterDragonID);

        EntityRegistry.registerModEntity(WaterDragon.class, "Water Dragon", WaterDragonID, Tags.MODID, 64, 1, false);

        final int   AttackSquidID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AttackSquid.class, "Attack Squid", AttackSquidID);

        EntityRegistry.registerModEntity(AttackSquid.class, "Attack Squid", AttackSquidID, Tags.MODID, 32, 1, false);

        final int   AlienID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Alien.class, "Alien", AlienID);

        EntityRegistry.registerModEntity(Alien.class, "Alien", AlienID, Tags.MODID, 64, 1, false);

        final int    ElevatorID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Elevator.class, "Hoverboard", ElevatorID);

        EntityRegistry.registerModEntity(Elevator.class, "Hoverboard", ElevatorID, Tags.MODID, 128, 1, true);

        final int   KrakenID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Kraken.class, "The Kraken", KrakenID);

        EntityRegistry.registerModEntity(Kraken.class, "The Kraken", KrakenID, Tags.MODID, 128, 1, false);

        final int   LizardID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Lizard.class, "Lizard", LizardID);

        EntityRegistry.registerModEntity(Lizard.class, "Lizard", LizardID, Tags.MODID, 64, 1, false);

        final int  CephadromeID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Cephadrome.class, "Cephadrome", CephadromeID);

        EntityRegistry.registerModEntity(Cephadrome.class, "Cephadrome", CephadromeID, Tags.MODID, 128, 1, true);

        final int   DragonID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Dragon.class, "Dragon", DragonID);

        EntityRegistry.registerModEntity(Dragon.class, "Dragon", DragonID, Tags.MODID, 128, 1, true);

        final int  ChipmunkID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Chipmunk.class, "Chipmunk", ChipmunkID);

        EntityRegistry.registerModEntity(Chipmunk.class, "Chipmunk", ChipmunkID, Tags.MODID, 32, 1, false);

        final int  GazelleID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Gazelle.class, "Gazelle", GazelleID);

        EntityRegistry.registerModEntity(Gazelle.class, "Gazelle", GazelleID, Tags.MODID, 64, 1, false);

        final int   OstrichID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Ostrich.class, "Ostrich", OstrichID);

        EntityRegistry.registerModEntity(Ostrich.class, "Ostrich", OstrichID, Tags.MODID, 64, 1, true);

        final int  TrooperBugID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TrooperBug.class, "Jumpy Bug", TrooperBugID);

        EntityRegistry.registerModEntity(TrooperBug.class, "Jumpy Bug", TrooperBugID, Tags.MODID, 64, 1, false);

        final int   SpitBugID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpitBug.class, "Spit Bug", SpitBugID);

        EntityRegistry.registerModEntity(SpitBug.class, "Spit Bug", SpitBugID, Tags.MODID, 64, 1, false);

        final int   StinkBugID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(StinkBug.class, "Stink Bug", StinkBugID);

        EntityRegistry.registerModEntity(StinkBug.class, "Stink Bug", StinkBugID, Tags.MODID, 32, 1, false);

        final int  TshirtID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Tshirt.class, "T-Shirt", TshirtID);

        EntityRegistry.registerModEntity(Tshirt.class, "T-Shirt", TshirtID, Tags.MODID, 32, 1, false);

        final int   IslandID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Island.class, "Island", IslandID);

        EntityRegistry.registerModEntity(Island.class, "Island", IslandID, Tags.MODID, 64, 1, false);

        final int  IslandTooID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(IslandToo.class, "IslandToo", IslandTooID);

        EntityRegistry.registerModEntity(IslandToo.class, "IslandToo", IslandTooID, Tags.MODID, 64, 1, false);

        final int    CreepingHorrorID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CreepingHorror.class, "Creeping Horror", CreepingHorrorID);

        EntityRegistry.registerModEntity(CreepingHorror.class, "Creeping Horror", CreepingHorrorID, Tags.MODID, 64, 1, false);

        final int   TerribleTerrorID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TerribleTerror.class, "Terrible Terror", TerribleTerrorID);

        EntityRegistry.registerModEntity(TerribleTerror.class, "Terrible Terror", TerribleTerrorID, Tags.MODID, 64, 1, false);

        final int   CliffRacerID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CliffRacer.class, "Cliff Racer", CliffRacerID);

        EntityRegistry.registerModEntity(CliffRacer.class, "Cliff Racer", CliffRacerID, Tags.MODID, 32, 1, false);

        final int   TriffidID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Triffid.class, "Triffid", TriffidID);

        EntityRegistry.registerModEntity(Triffid.class, "Triffid", TriffidID, Tags.MODID, 64, 1, false);

        final int    PitchBlackID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(PitchBlack.class, "Nightmare", PitchBlackID);

        EntityRegistry.registerModEntity(PitchBlack.class, "Nightmare", PitchBlackID, Tags.MODID, 64, 1, false);

        final int   LurkingTerrorID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LurkingTerror.class, "Lurking Terror", LurkingTerrorID);

        EntityRegistry.registerModEntity(LurkingTerror.class, "Lurking Terror", LurkingTerrorID, Tags.MODID, 64, 1, false);

        final int    GodzillaID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Godzilla.class, "Mobzilla", GodzillaID);

        EntityRegistry.registerModEntity(Godzilla.class, "Mobzilla", GodzillaID, Tags.MODID, 128, 1, false);

        final int   GhostID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Ghost.class, "Ghost", GhostID);

        EntityRegistry.registerModEntity(Ghost.class, "Ghost", GhostID, Tags.MODID, 32, 1, false);

        final int   GhostSkellyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GhostSkelly.class, "Ghost Pumpkin Skelly", GhostSkellyID);

        EntityRegistry.registerModEntity(GhostSkelly.class, "Ghost Pumpkin Skelly", GhostSkellyID, Tags.MODID, 64, 1, false);

        final int   WormSmallID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WormSmall.class, "Small Worm", WormSmallID);

        EntityRegistry.registerModEntity(WormSmall.class, "Small Worm", WormSmallID, Tags.MODID, 32, 1, false);

        final int  WormMediumID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WormMedium.class, "Medium Worm", WormMediumID);

        EntityRegistry.registerModEntity(WormMedium.class, "Medium Worm", WormMediumID, Tags.MODID, 64, 1, false);

        final int   WormLargeID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(WormLarge.class, "Large Worm", WormLargeID);

        EntityRegistry.registerModEntity(WormLarge.class, "Large Worm", WormLargeID, Tags.MODID, 64, 1, false);

        final int    CassowaryID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Cassowary.class, "Cassowary", CassowaryID);

        EntityRegistry.registerModEntity(Cassowary.class, "Cassowary", CassowaryID, Tags.MODID, 64, 1, false);

        final int    CloudSharkID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CloudShark.class, "Cloud Shark", CloudSharkID);

        EntityRegistry.registerModEntity(CloudShark.class, "Cloud Shark", CloudSharkID, Tags.MODID, 64, 1, false);

        final int   GoldFishID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GoldFish.class, "Gold Fish", GoldFishID);

        EntityRegistry.registerModEntity(GoldFish.class, "Gold Fish", GoldFishID, Tags.MODID, 32, 1, false);

        final int    LeafMonsterID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(LeafMonster.class, "Leaf Monster", LeafMonsterID);

        EntityRegistry.registerModEntity(LeafMonster.class, "Leaf Monster", LeafMonsterID, Tags.MODID, 64, 1, false);

        final int   GodzillaHeadID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GodzillaHead.class, "MobzillaHead", GodzillaHeadID);

        EntityRegistry.registerModEntity(GodzillaHead.class, "MobzillaHead", GodzillaHeadID, Tags.MODID, 128, 10, true);

        final int   EnderKnightID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EnderKnight.class, "Ender Knight", EnderKnightID);

        EntityRegistry.registerModEntity(EnderKnight.class, "Ender Knight", EnderKnightID, Tags.MODID, 64, 1, false);

        final int    EnderReaperID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EnderReaper.class, "Ender Reaper", EnderReaperID);

        EntityRegistry.registerModEntity(EnderReaper.class, "Ender Reaper", EnderReaperID, Tags.MODID, 64, 1, false);

        final int   BeaverID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Beaver.class, "Beaver", BeaverID);

        EntityRegistry.registerModEntity(Beaver.class, "Beaver", BeaverID, Tags.MODID, 64, 1, false);

        final int   TermiteID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Termite.class, "Termite", TermiteID);

        EntityRegistry.registerModEntity(Termite.class, "Termite", TermiteID, Tags.MODID, 32, 1, false);

        final int   FairyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Fairy.class, "Fairy", FairyID);

        EntityRegistry.registerModEntity(Fairy.class, "Fairy", FairyID, Tags.MODID, 32, 1, false);

        final int   PeacockID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Peacock.class, "Peacock", PeacockID);

        EntityRegistry.registerModEntity(Peacock.class, "Peacock", PeacockID, Tags.MODID, 64, 1, false);

        final int   RotatorID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Rotator.class, "Rotator", RotatorID);

        EntityRegistry.registerModEntity(Rotator.class, "Rotator", RotatorID, Tags.MODID, 64, 1, false);

        final int    VortexID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Vortex.class, "Vortex", VortexID);

        EntityRegistry.registerModEntity(Vortex.class, "Vortex", VortexID, Tags.MODID, 64, 1, false);

        final int   DungeonBeastID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(DungeonBeast.class, "Dungeon Beast", DungeonBeastID);

        EntityRegistry.registerModEntity(DungeonBeast.class, "Dungeon Beast", DungeonBeastID, Tags.MODID, 64, 1, false);

        final int   RatID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Rat.class, "Rat", RatID);

        EntityRegistry.registerModEntity(Rat.class, "Rat", RatID, Tags.MODID, 32, 1, false);

        final int   FlounderID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Flounder.class, "Flounder", FlounderID);

        EntityRegistry.registerModEntity(Flounder.class, "Flounder", FlounderID, Tags.MODID, 32, 1, false);

        final int     WhaleID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Whale.class, "Whale", WhaleID);

        EntityRegistry.registerModEntity(Whale.class, "Whale", WhaleID, Tags.MODID, 64, 1, false);

        final int    IrukandjiID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Irukandji.class, "Irukandji", IrukandjiID);

        EntityRegistry.registerModEntity(Irukandji.class, "Irukandji", IrukandjiID, Tags.MODID, 32, 1, false);

        final int    SkateID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Skate.class, "Skate", SkateID);

        EntityRegistry.registerModEntity(Skate.class, "Skate", SkateID, Tags.MODID, 32, 1, false);

        final int     UrchinID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Urchin.class, "Crystal Urchin", UrchinID);

        EntityRegistry.registerModEntity(Urchin.class, "Crystal Urchin", UrchinID, Tags.MODID, 64, 1, false);

        final int    MantisID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Mantis.class, "Mantis", MantisID);

        EntityRegistry.registerModEntity(Mantis.class, "Mantis", MantisID, Tags.MODID, 64, 1, false);

        final int   HerculesBeetleID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(HerculesBeetle.class, "Hercules Beetle", HerculesBeetleID);

        EntityRegistry.registerModEntity(HerculesBeetle.class, "Hercules Beetle", HerculesBeetleID, Tags.MODID, 64, 1, false);

        final int    TRexID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TRex.class, "T. Rex", TRexID);

        EntityRegistry.registerModEntity(TRex.class, "T. Rex", TRexID, Tags.MODID, 64, 1, false);

        final int    StinkyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Stinky.class, "Stinky", StinkyID);

        EntityRegistry.registerModEntity(Stinky.class, "Stinky", StinkyID, Tags.MODID, 64, 1, false);

        final int   CoinID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Coin.class, "Coin", CoinID);

        EntityRegistry.registerModEntity(Coin.class, "Coin", CoinID, Tags.MODID, 64, 1, false);

        final int   TheKingID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TheKing.class, "The King", TheKingID);

        EntityRegistry.registerModEntity(TheKing.class, "The King", TheKingID, Tags.MODID, 128, 1, false);

        final int   KingHeadID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(KingHead.class, "KingHead", KingHeadID);

        EntityRegistry.registerModEntity(KingHead.class, "KingHead", KingHeadID, Tags.MODID, 128, 10, true);

        final int   TheQueenID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(TheQueen.class, "The Queen", TheQueenID);

        EntityRegistry.registerModEntity(TheQueen.class, "The Queen", TheQueenID, Tags.MODID, 128, 1, false);

        final int   QueenHeadID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(QueenHead.class, "QueenHead", QueenHeadID);

        EntityRegistry.registerModEntity(QueenHead.class, "QueenHead", QueenHeadID, Tags.MODID, 128, 10, true);

        final int   BoyfriendID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Boyfriend.class, "Boyfriend", BoyfriendID);

        EntityRegistry.registerModEntity(Boyfriend.class, "Boyfriend", BoyfriendID, Tags.MODID, 64, 1, false);

        final int  ThePrinceID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrince.class, "The Prince", ThePrinceID);

        EntityRegistry.registerModEntity(ThePrince.class, "The Prince", ThePrinceID, Tags.MODID, 64, 1, false);

        final int  MolenoidID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Molenoid.class, "Molenoid", MolenoidID);

        EntityRegistry.registerModEntity(Molenoid.class, "Molenoid", MolenoidID, Tags.MODID, 64, 1, false);

        final int   SeaMonsterID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SeaMonster.class, "Sea Monster", SeaMonsterID);

        EntityRegistry.registerModEntity(SeaMonster.class, "Sea Monster", SeaMonsterID, Tags.MODID, 64, 1, false);

        final int   SeaViperID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SeaViper.class, "Sea Viper", SeaViperID);

        EntityRegistry.registerModEntity(SeaViper.class, "Sea Viper", SeaViperID, Tags.MODID, 64, 1, false);

        final int  EasterBunnyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(EasterBunny.class, "Easter Bunny", EasterBunnyID);

        EntityRegistry.registerModEntity(EasterBunny.class, "EasterBunny", EasterBunnyID, Tags.MODID, 64, 1, false);

        final int   CaterKillerID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CaterKiller.class, "CaterKiller", CaterKillerID);

        EntityRegistry.registerModEntity(CaterKiller.class, "CaterKiller", CaterKillerID, Tags.MODID, 64, 1, false);

        final int   CrystalCowID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(CrystalCow .class, "Crystal Apple Cow", CrystalCowID);

        EntityRegistry.registerModEntity(CrystalCow.class, "Crystal Apple Cow", CrystalCowID, Tags.MODID, 64, 1, false);

        final int   LeonID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Leon.class, "Leonopteryx", LeonID);

        EntityRegistry.registerModEntity(Leon.class, "Leonopteryx", LeonID, Tags.MODID, 64, 1, false);

        final int   HammerheadID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Hammerhead.class, "Hammerhead", HammerheadID);

        EntityRegistry.registerModEntity(Hammerhead.class, "Hammerhead", HammerheadID, Tags.MODID, 64, 1, false);

        final int  RubberDuckyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RubberDucky.class, "Rubber Ducky", RubberDuckyID);

        EntityRegistry.registerModEntity(RubberDucky.class, "Rubber Ducky", RubberDuckyID, Tags.MODID, 64, 1, false);

        final int   ThePrinceTeenID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrinceTeen.class, "The Young Prince", ThePrinceTeenID);

        EntityRegistry.registerModEntity(ThePrinceTeen.class, "The Young Prince", ThePrinceTeenID, Tags.MODID, 64, 1, false);

        final int BandPID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(BandP.class, "Criminal", BandPID);

        EntityRegistry.registerModEntity(BandP.class, "Criminal", BandPID, Tags.MODID, 64, 1, false);

        final int   RockBaseID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(RockBase.class, "Rock", RockBaseID, 1118481, 16777215);

        EntityRegistry.registerModEntity(RockBase.class, "Rock", RockBaseID, Tags.MODID, 32, 1, false);

        final int    BrutalflyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Brutalfly.class, "Brutalfly", BrutalflyID);

        EntityRegistry.registerModEntity(Brutalfly.class, "Brutalfly", BrutalflyID, Tags.MODID, 128, 1, false);

        final int    NastysaurusID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Nastysaurus.class, "Nastysaurus", NastysaurusID);

        EntityRegistry.registerModEntity(Nastysaurus.class, "Nastysaurus", NastysaurusID, Tags.MODID, 128, 1, false);

        final int  PointysaurusID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Pointysaurus.class, "Pointysaurus", PointysaurusID);

        EntityRegistry.registerModEntity(Pointysaurus.class, "Pointysaurus", PointysaurusID, Tags.MODID, 64, 1, false);

        final int   CricketID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Cricket.class, "Cricket", CricketID);

        EntityRegistry.registerModEntity(Cricket.class, "Cricket", CricketID, Tags.MODID, 32, 1, false);

        final int  ThePrincessID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrincess.class, "The Princess", ThePrincessID);

        EntityRegistry.registerModEntity(ThePrincess.class, "The Princess", ThePrincessID, Tags.MODID, 64, 1, false);

        final int  FrogID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Frog.class, "Frog", FrogID);

        EntityRegistry.registerModEntity(Frog.class, "Frog", FrogID, Tags.MODID, 32, 1, false);

        final int   ThePrinceAdultID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(ThePrinceAdult.class, "The Young Adult Prince", ThePrinceAdultID);

        EntityRegistry
            .registerModEntity(ThePrinceAdult.class, "The Young Adult Prince", ThePrinceAdultID, Tags.MODID, 128, 1, false);

        final int     SpiderRobotID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpiderRobot.class, "Robot Spider", SpiderRobotID);

        EntityRegistry.registerModEntity(SpiderRobot.class, "Robot Spider", SpiderRobotID, Tags.MODID, 128, 1, false);

        final int   SpiderDriverID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(SpiderDriver.class, "Spider Driver", SpiderDriverID);
        EntityRegistry.registerModEntity(SpiderDriver.class, "Spider Driver", SpiderDriverID, Tags.MODID, 64, 1, false);

        final int   JefferyID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(GiantRobot.class, "Jeffery", JefferyID);

        EntityRegistry.registerModEntity(GiantRobot.class, "Jeffery", JefferyID, Tags.MODID, 128, 1, false);

        final int   AntRobotID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(AntRobot.class, "Robot Red Ant", AntRobotID);

        EntityRegistry.registerModEntity(AntRobot.class, "Robot Red Ant", AntRobotID, Tags.MODID, 128, 1, false);

        final int    CrabID = EntityRegistry.findGlobalUniqueEntityId();

        EntityRegistry.registerGlobalEntityID(Crab.class, "Crab", CrabID);

        EntityRegistry.registerModEntity(Crab.class, "Crab", CrabID, Tags.MODID, 64, 1, false);

}
}
