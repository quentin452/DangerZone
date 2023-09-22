package fr.iamacat.dangerzone_iamacatfr.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.iamacat.dangerzone_iamacatfr.InputConfusedMovement;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.*;
import fr.iamacat.dangerzone_iamacatfr.entities.other.RiderControl;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.RenderDragon;
import fr.iamacat.dangerzone_iamacatfr.entities.render.*;
import fr.iamacat.dangerzone_iamacatfr.entities.render.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalCow;
import fr.iamacat.dangerzone_iamacatfr.items.UltimateFishHook;
import fr.iamacat.dangerzone_iamacatfr.util.Helper;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {


    @Override
    public void registerRenders() {
        final float shadowSize = 0.5f;
        RenderingRegistry
            .registerEntityRenderingHandler(AppleCowInstance.class, new AppleCowRenderer(new AppleCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            CrystalCowInstance.class,
            new CrystalCowRenderer(new CrystalCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            GoldenAppleCowInstance.class,
            new GoldenAppleCowRenderer(new GoldenAppleCowModel(), 0.5F));



        RenderingRegistry
            .registerEntityRenderingHandler(EyeRayInstance.class, new EyeRayRenderer(new EyeRayModel(), 1.0F));

        RenderingRegistry.registerEntityRenderingHandler(EntityBirchDragon.class, new RenderBirchDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityBlazeDragon.class, new RenderBlazeDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityAlpsDragon.class, new RenderAlpsDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityCaveDragon.class, new RenderCaveDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityDesertDragon.class, new RenderDesertDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityDiamondDragon.class, new RenderDiamondDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityEnthralledDragon.class, new RenderEnthralledDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityEndDragon.class, new RenderEndDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityExHillsDragon.class, new RenderExHillsDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldDragon.class, new RenderGoldDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityJungleDragon.class, new RenderJungleDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityNetherDragon.class, new RenderNetherDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityPlainsDragon.class, new RenderPlainsDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityStarDragon.class, new RenderStarDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntitySwampDragon.class, new RenderSwampDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityRedstoneDragon.class, new RenderRedstoneDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityBluestoneDragon.class, new RenderBluestoneDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityForestDragon.class, new RenderForestDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityAetherDragon.class, new RenderAetherDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityCloudDragon.class, new RenderCloudDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityMushroomDragon1.class, new RenderMushroomDragon1());
        RenderingRegistry.registerEntityRenderingHandler(EntityMushroomDragon2.class, new RenderMushroomDragon2());
        RenderingRegistry.registerEntityRenderingHandler(EntitySavannaDragon.class, new RenderSavannaDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityMesaDragon.class, new RenderMesaDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityRiverDragon.class, new RenderRiverDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityOceanDragon.class, new RenderOceanDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityEmeraldDragon.class, new RenderEmeraldDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityIronDragon.class, new RenderIronDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityLapisDragon.class, new RenderLapisDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityCactusDragon.class, new RenderCactusDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntitySnowDragon.class, new RenderSnowDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityPlainsDragon2.class, new RenderPlainsDragon2());
        RenderingRegistry.registerEntityRenderingHandler(EntityZombieDragon.class, new RenderZombieDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityBoneDragon.class, new RenderBoneDragon());
        RenderingRegistry.registerEntityRenderingHandler(EntityAngelDragon.class, new RenderAngelDragon());


        RenderingRegistry
            .registerEntityRenderingHandler(MassoInstance.class, new MassoRenderer(new MassoModel(), shadowSize));

        ResourceLocation textureLocation = new ResourceLocation(Tags.MODID, "textures/entity/beaver.png");


        RenderingRegistry.registerEntityRenderingHandler(BeeInstance.class, new BeeRenderer());
        RenderingRegistry.registerEntityRenderingHandler(DarkCrystalInstance.class, new DarkCrystalRenderer());

        RenderingRegistry.registerEntityRenderingHandler(
            WhaleRenderer.WhaleInstance.class,
            new RenderLiving(new WhaleRenderer.ModelWhale(), 0.0f) {

                protected ResourceLocation getEntityTexture(final Entity par1Entity) {
                    return new ResourceLocation(Tags.MODID + ":textures/entity/BelugaTexture.png");
                }
            });
        RenderingRegistry.registerEntityRenderingHandler(
            TwilightMobInstance.class,
            new TwilightMobInstance.RenderTheMob(new PonyRobotModel(), 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            DemonSpiderInstance.class,
            new BlackWidowRenderer(new BlackWidowModel(0.96f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            LeviathanInstance.class,
            new LeviathanRenderer(new LeviathanModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThunderHoovesInstance.class,
            new ThunderHoovesRenderer(new ChiefThunderHoovesModel(1.0f), 1.8f, 1.8f));
        RenderingRegistry.registerEntityRenderingHandler(
            KingbowserInstance.class,
            new KingbowserInstance.RenderTheMob6(new KingbowserModel(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CentipedeInstance.class,
            new CentipedeRenderer(new CentipedeModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            HydraInstance.class,
            new HydraInstance.RenderTheMob8(new HydraModel(), 30.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WindigoInstance.class,
            new WindigoRenderer(new WindigoModel(30.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            MooseInstance.class,
            new MooseInstance.RenderTheMob10(new MooseModel(), 2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            BuffaloInstance.class,
            new BuffaloInstance.RenderTheMob11(new BufalloModel(), 4.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(DarknessInstance.class, new LeechRenderer(new LeechModel(), 1.2f, 1.2f));
        RenderingRegistry.registerEntityRenderingHandler(
            FlameDragonInstance.class,
            new FlameDragonRenderer(new GarbleModel(7.5f), 2.2f, 2.2f));
        RenderingRegistry.registerEntityRenderingHandler(
            MooseBigInstance.class,
            new MooseBigInstance.RenderTheMob15(new MooseBigModel(), 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            CragadileInstance.class,
            new CragadileRenderer(new CragadileModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(BearInstance.class, new BearInstance.RenderTheMob17(new BearModel(), 3.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ToughGuyInstance.class,
            new ToughGuyInstance.RenderTheMob18(new ToughGuyModel(), 2.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            MavisInstance.class,
            new MavisInstance.RenderTheMob19(new MavisModel(), 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            UrsaMAJORInstance.class,
            new UrsaMAJORInstance.RenderTheMob21(new UrsaMAJORModel(), 32.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            PhoenixInstance.class,
            new PhoenixRenderer(new PhoenixModel(6.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            DashInstance.class,
            new DashRenderer(new RainbowDashModel(0.85f), 0.75f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            ManticoreInstance.class,
            new ManticoreInstance.RenderTheMob24(new ManticoreModel(), 4.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            RainbowCentipedeInstance.class,
            new RainbowCentipedeRenderer(new GiantCentipedeModel(0.52f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ParaspriteInstance.class,
            new ParaspriteRenderer(new ParaspriteModel(0.25f), 0.25f, 0.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(AJInstance.class, new AJRenderer(new AppleJackModel(1.0f), 0.85f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            ArcticScorpionInstance.class,
            new ArcticScorpionRenderer(new ArcticScorpionModel(6.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TimberWolfInstance.class,
            new TimberWolfRenderer(new TimberWolfModel(0.85f), 0.85f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            CockatriceInstance.class,
            new CockatriceRenderer(new CockatriceModel(1.1f), 1.1f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            IronWillInstance.class,
            new IronWillRenderer(new IronWillModel(1.6f), 1.6f, 1.6f));
        RenderingRegistry.registerEntityRenderingHandler(
            CrabzillaInstance.class,
            new CrabzillaRenderer(new CrabzillaModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            DashCloudInstance.class,
            new DashCloudRenderer(new DashCloudModel(2.0f), 2.0f, 2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TrevorPhillipsInstance.class,
            new TrevorPhillipsRenderer(new ModelBiped(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SkullBossInstance.class,
            new SkullBossRenderer(new SkullofDoomModel(), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(SkullInstance.class, new SkullRenderer(new SkullofDoomModel(), 0.5f, 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            YakPrinceInstance.class,
            new YakPrinceRenderer(new PrinceYakFurModel(), 1.2f, 1.2f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpikezillaInstance.class,
            new SpikezillaRenderer(new SpikezillaModel(), 0.9f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(
            RhinocerosInstance.class,
            new RhinoRenderer(new RhinocerosModel(), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(TwilightCannonInstance.class, new RangedRenderer());
        RenderingRegistry.registerEntityRenderingHandler(LaserBallSecondInstance.class, new RangedRenderer());
        RenderingRegistry
            .registerEntityRenderingHandler(MavisBallModel.class, new RenderSnowball(ItemInitDangerZone.mavisOrb));

        RenderingRegistry.registerEntityRenderingHandler(TwilicornArrowInstance.class, new TwilightMagicRenderer());

        RenderingRegistry.registerEntityRenderingHandler(
            PhoenixArrowInstance.class,
            new PhoenixArrowRenderer(ItemInitDangerZone.phoenixFeather));

        RenderingRegistry.registerEntityRenderingHandler(TwilyMagicInstance.class, new TwilyMagic2Renderer());
        RenderingRegistry.registerEntityRenderingHandler(
            DarkCrystalCannonInstance.class,
            new RenderSnowball(ItemInitDangerZone.darkCrystal));
        RenderingRegistry.registerEntityRenderingHandler(WindigoPowerInstance.class, new WindigoPowerRenderer());
        RenderingRegistry.registerEntityRenderingHandler(LongHitInstance.class, new RangedRenderer());
        RenderingRegistry.registerEntityRenderingHandler(MagicInstance.class, new MagicTextureRenderer());
        RenderingRegistry.registerEntityRenderingHandler(BetterFireballInstance.class, new RenderFireball(2.0f));
        RenderingRegistry.registerEntityRenderingHandler(HydraFireballInstance.class, new RenderFireball(8.0f));
        RenderingRegistry.registerEntityRenderingHandler(FreezeBall.class, new RenderFireball(4.0f));
        RenderingRegistry.registerEntityRenderingHandler(RobotBeamInstance.class, new RenderFireball(0.2f));
        RenderingRegistry.registerEntityRenderingHandler(FireCannon.class, new MeteorRenderer());
        RenderingRegistry.registerEntityRenderingHandler(RainbowCannonInstance.class, new RainbowCannonRenderer());
        RenderingRegistry.registerEntityRenderingHandler(ProjectileApplesInstance.class, new ApplesRenderer());

        MinecraftForge.EVENT_BUS.register(new GirlfriendOverlayGui(Minecraft.getMinecraft()));
        RenderingRegistry
            .registerEntityRenderingHandler(Girlfriend.class,  new RenderGirlfriend(new ModelBiped(), 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Boyfriend.class,  new RenderBoyfriend(new ModelBiped(), 0.55f));
        RenderingRegistry
            .registerEntityRenderingHandler(RedCow.class,  new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(GoldCow.class,  new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(EnchantedCow.class,  new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(CrystalCow.class,  new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler(Shoes.class,  new RenderShoe());
        RenderingRegistry.registerEntityRenderingHandler(SunspotUrchin.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(WaterBall.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(InkSack.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(LaserBall.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(IceBall.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(Acid.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(DeadIrukandji.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(BerthaHit.class,  new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(EntityCage.class,  new RenderCage());
        RenderingRegistry.registerEntityRenderingHandler(UltimateFishHook.class,  new RenderFish());
        RenderingRegistry.registerEntityRenderingHandler(UltimateArrow.class,  new RenderArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityThrownRock.class,  new RenderThrownRock());
        RenderingRegistry.registerEntityRenderingHandler(
            EntityButterfly.class,
             new RenderButterfly(new ModelButterfly(1.0f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Firefly.class,
             new RenderFirefly(new ModelFirefly(2.5f), 0.2f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityLunaMoth.class,
             new RenderButterfly(new ModelButterfly(0.75f), 0.4f, 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityMosquito.class,
             new RenderMosquito(new ModelMosquito(), 0.3f, 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Ghost.class,  new RenderGhost(new ModelGhost(), 0.0f, 0.65f));
        RenderingRegistry.registerEntityRenderingHandler(
            GhostSkelly.class,
             new RenderGhostSkelly(new ModelGhostSkelly(), 0.0f, 1.05f));
        RenderingRegistry.registerEntityRenderingHandler(
            Mothra.class,
             new RenderButterfly(new ModelButterfly(0.2f), 0.75f, 10.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityAnt.class,  new RenderAnt(new ModelAnt(), 0.1f, 0.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityRedAnt.class,  new RenderAnt(new ModelAnt(), 0.15f, 0.35f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityRainbowAnt.class,
             new RenderAnt(new ModelAnt(), 0.1f, 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityUnstableAnt.class,
             new RenderAnt(new ModelAnt(), 0.1f, 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(
            Alosaurus.class,
             new RenderAlosaurus(new ModelAlosaurus(0.22f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(TRex.class,  new RenderTRex(new ModelTRex(0.2f), 1.0f, 1.2f));
        RenderingRegistry.registerEntityRenderingHandler(
            Tshirt.class,
             new RenderTshirt(new ModelTshirt(0.22f), 1.0f, 0.33f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cryolophosaurus.class,
             new RenderCryolophosaurus(new ModelCryolophosaurus(0.75f), 0.75f, 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            Basilisk.class,
             new RenderBasilisk(new ModelBasilisk(0.3f), 0.5f, 1.25f));
        RenderingRegistry.registerEntityRenderingHandler(
            Camarasaurus.class,
             new RenderCamarasaurus(new ModelCamarasaurus(0.65f), 0.65f, 0.65f));
        RenderingRegistry.registerEntityRenderingHandler(
            Hydrolisc.class,
             new RenderHydrolisc(new ModelHydrolisc(0.65f), 0.65f, 0.65f));
        RenderingRegistry.registerEntityRenderingHandler(
            VelocityRaptor.class,
             new RenderVelocityRaptor(new ModelVelocityRaptor(1.25f), 0.55f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Dragonfly.class,
             new RenderDragonfly(new ModelDragonfly(2.0f), 0.3f, 1.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Bee.class,  new RenderBee(new ModelBee(2.0f), 0.9f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            EmperorScorpion.class,
             new RenderEmperorScorpion(new ModelEmperorScorpion(0.22f), 0.95f, 1.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Spyro.class,  new RenderSpyro(new ModelSpyro(0.65f), 0.65f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Baryonyx.class,
             new RenderBaryonyx(new ModelBaryonyx(0.25f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            GammaMetroid.class,
             new RenderGammaMetroid(new ModelGammaMetroid(0.45f), 0.75f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cockateil.class,
             new RenderCockateil(new ModelCockateil(1.0f), 0.3f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            RubyBird.class,
             new RenderCockateil(new ModelCockateil(1.0f), 0.3f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(Kyuubi.class,  new RenderKyuubi(new ModelKyuubi(0.5f), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Scorpion.class,
             new RenderScorpion(new ModelScorpion(0.62f), 0.35f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            CaveFisher.class,
             new RenderCaveFisher(new ModelCaveFisher(0.62f), 0.35f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(Alien.class,  new RenderAlien(new ModelAlien(0.22f), 0.35f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            WaterDragon.class,
             new RenderWaterDragon(new ModelWaterDragon(0.5f), 0.85f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            AttackSquid.class,
             new RenderAttackSquid(new ModelAttackSquid(1.0f), 0.25f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(Elevator.class,  new RenderElevator());
        RenderingRegistry
            .registerEntityRenderingHandler(Robot1.class,  new RenderRobot1(new ModelRobot1(2.0f), 0.3f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot2.class,  new RenderRobot2(new ModelRobot2(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot3.class,  new RenderRobot3(new ModelRobot3(1.0f), 1.0f, 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot4.class,  new RenderRobot4(new ModelRobot4(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot5.class,  new RenderRobot5(new ModelRobot5(1.0f), 0.5f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Kraken.class,  new RenderKraken(new ModelKraken(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Lizard.class,
             new RenderLizard(new ModelLizard(0.65f), 0.75f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cephadrome.class,
             new RenderCephadrome(new ModelCephadrome(0.55f), 1.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Dragon.class,
             new RenderDragon(new ModelDragon(0.65f), 1.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Chipmunk.class,
             new RenderChipmunk(new ModelChipmunk(1.0f), 0.15f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(
            Gazelle.class,
             new RenderGazelle(new ModelGazelle(0.65f), 0.45f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Ostrich.class,
             new RenderOstrich(new ModelOstrich(0.65f), 0.55f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TrooperBug.class,
             new RenderTrooperBug(new ModelTrooperBug(0.22f), 0.95f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpitBug.class,
             new RenderSpitBug(new ModelSpitBug(0.55f), 0.55f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            StinkBug.class,
             new RenderStinkBug(new ModelStinkBug(0.75f), 0.35f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            Island.class,
             new RenderIsland(new ModelIsland(1.0f), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            IslandToo.class,
             new RenderIslandToo(new ModelIsland(1.0f), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CreepingHorror.class,
             new RenderCreepingHorror(new ModelCreepingHorror(), 0.45f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            TerribleTerror.class,
             new RenderTerribleTerror(new ModelTerribleTerror(), 0.45f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            CliffRacer.class,
             new RenderCliffRacer(new ModelCliffRacer(1.0f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Triffid.class,
             new RenderTriffid(new ModelTriffid(1.0f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            PitchBlack.class,
             new RenderPitchBlack(new ModelPitchBlack(0.65f), 1.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            LurkingTerror.class,
             new RenderLurkingTerror(new ModelLurkingTerror(), 0.45f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            Godzilla.class,
             new RenderGodzilla(new ModelGodzilla(0.2f), 1.0f, 2.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(GodzillaHead.class,  new RenderGodzillaHead(null, 0.0f, 0.0f));
        RenderingRegistry.registerEntityRenderingHandler(KingHead.class,  new RenderKingHead(null, 0.0f, 0.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(QueenHead.class,  new RenderQueenHead(null, 0.0f, 0.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WormSmall.class,
             new RenderWormSmall(new ModelWormSmall(), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WormMedium.class,
             new RenderWormMedium(new ModelWormMedium(), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WormLarge.class,
             new RenderWormLarge(new ModelWormLarge(), 0.9f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cassowary.class,
             new RenderCassowary(new ModelCassowary(0.55f), 0.5f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            GoldFish.class,
             new RenderGoldFish(new ModelGoldFish(0.7f), 0.2f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CloudShark.class,
             new RenderCloudShark(new ModelCloudShark(1.0f), 0.5f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            LeafMonster.class,
             new RenderLeafMonster(new ModelLeafMonster(), 0.65f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            EnderKnight.class,
             new RenderEnderKnight(new ModelEnderKnight(0.21f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            EnderReaper.class,
             new RenderEnderReaper(new ModelEnderReaper(0.23f), 0.2f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Beaver.class,
             new RenderBeaver(new ModelBeaver(0.5f), 0.15f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(Termite.class, new RenderAnt(new ModelAnt(), 0.15f, 0.35f));
        RenderingRegistry
            .registerEntityRenderingHandler(Fairy.class, new RenderFairy(new ModelFairy(1.5f), 0.1f, 0.35f));
        RenderingRegistry.registerEntityRenderingHandler(
            Peacock.class,
             new RenderPeacock(new ModelPeacock(0.75f), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Rotator.class,
             new RenderRotator(new ModelRotator(0.25f), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Vortex.class,
             new RenderVortex(new ModelVortex(0.25f), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            DungeonBeast.class,
             new RenderDungeonBeast(new ModelDungeonBeast(0.62f), 0.25f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Rat.class,  new RenderRat(new ModelRat(1.0f), 0.1f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Flounder.class,
             new RenderFlounder(new ModelFlounder(), 0.1f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Whale.class,  new RenderWhale(new ModelWhale(), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Irukandji.class,
             new RenderIrukandji(new ModelIrukandji(1.0f), 0.1f, 0.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(Skate.class,  new RenderSkate(new ModelSkate(1.0f), 0.1f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Urchin.class,
             new RenderUrchin(new ModelUrchin(1.0f), 0.35f, 1.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(Mantis.class,  new RenderMantis(new ModelMantis(2.0f), 0.9f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            HerculesBeetle.class,
             new RenderHerculesBeetle(new ModelHerculesBeetle(1.0f), 0.99f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            Stinky.class,
             new RenderStinky(new ModelStinky(0.65f), 0.75f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Coin.class,  new RenderCoin(new ModelCoin(0.22f), 0.75f, 0.125f));
        RenderingRegistry.registerEntityRenderingHandler(
            TheKing.class,
             new RenderTheKing(new ModelTheKing(0.65f), 1.9f, 2.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            TheQueen.class,
             new RenderTheQueen(new ModelTheQueen(0.65f), 1.9f, 2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrince.class,
             new RenderThePrince(new ModelThePrince(0.65f), 0.75f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Molenoid.class,
             new RenderMolenoid(new ModelMolenoid(0.5f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SeaMonster.class,
             new RenderSeaMonster(new ModelSeaMonster(0.5f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SeaViper.class,
             new RenderSeaViper(new ModelSeaViper(0.5f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            EasterBunny.class,
             new RenderEasterBunny(new ModelEasterBunny(0.55f), 0.5f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CaterKiller.class,
             new RenderCaterKiller(new ModelCaterKiller(0.22f), 1.0f, 1.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(Leon.class,  new RenderLeon(new ModelLeon(0.22f), 1.0f, 1.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Hammerhead.class,
             new RenderHammerhead(new ModelHammerhead(0.33f), 1.0f, 2.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            RubberDucky.class,
             new RenderRubberDucky(new ModelRubberDucky(1.0f), 0.15f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrinceTeen.class,
             new RenderThePrinceTeen(new ModelThePrinceTeen(0.65f), 1.0f, 1.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(BandP.class,  new RenderBandP(new ModelBandP(0.4f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            RockBase.class,
             new RenderRockBase(new ModelRockBase(1.0f), 0.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            PurplePower.class,
             new RenderPurplePower(new ModelPurplePower(1.0f), 0.3f, 2.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Brutalfly.class,
             new RenderBrutalfly(new ModelBrutalfly(0.2f), 0.75f, 9.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Nastysaurus.class,
             new RenderNastysaurus(new ModelNastysaurus(0.65f), 1.0f, 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            Pointysaurus.class,
             new RenderPointysaurus(new ModelPointysaurus(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cricket.class,
             new RenderCricket(new ModelCricket(2.5f), 0.15f, 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrincess.class,
             new RenderThePrincess(new ModelThePrincess(0.65f), 0.7f, 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(Frog.class,  new RenderFrog(new ModelFrog(1.0f), 0.35f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrinceAdult.class,
             new RenderThePrinceAdult(new ModelThePrinceAdult(0.65f), 1.2f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpiderRobot.class,
             new RenderSpiderRobot(new ModelSpiderRobot(1.0f), 0.99f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpiderDriver.class,
             new RenderSpiderDriver(new ModelSpider(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            GiantRobot.class,
             new RenderGiantRobot(new ModelGiantRobot(0.25f), 0.99f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            AntRobot.class,
             new RenderAntRobot(new ModelAntRobot(1.0f), 0.99f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Crab.class,  new RenderCrab(new ModelCrab(1.0f), 0.99f, 1.0f));
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyBertha,  new RenderBertha());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MySlice,  new RenderSlice());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyRoyal,  new RenderRoyal());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MySquidZooka,  new RenderSquidZooka());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyHammy,  new RenderHammy());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyBattleAxe,  new RenderBattleAxe());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyChainsaw,  new RenderChainsaw());
        MinecraftForgeClient
            .registerItemRenderer(OreSpawnMain.MyQueenBattleAxe,  new RenderQueenBattleAxe());
    }

    @Override
    public EntityPlayer getCurrentPlayer() {
        return Minecraft.getMinecraft().thePlayer;
    }

    private final double NAME_VISION_DISTANCE = 32.0D;
    private Minecraft mc;
    private World lastWorld;
    private long nextPacketTime;
    private EntityLivingBase retainedTarget;
    public InputConfusedMovement confusedMovementInput;

    public void preInit() {
        FMLCommonHandler.instance()
            .bus()
            .register(this);
        this.mc = FMLClientHandler.instance()
            .getClient();
    }

    public void load() {
        this.nextPacketTime = 0L;

        MinecraftForge.EVENT_BUS.register(this);

        this.retainedTarget = null;
    }

    public void onKnockBackPacket(float xv, float zv) {
        Helper.knockBack(
            FMLClientHandler.instance()
                .getClient().thePlayer,
            xv,
            zv);
    }

    public void onConfusionPacket(boolean b) {
        if (b) Helper.makePlayerConfused(
            FMLClientHandler.instance()
                .getClient().thePlayer);
        else Helper.makePlayerNormal(
            FMLClientHandler.instance()
                .getClient().thePlayer);
    }

    @Override
    public void sendChat(EntityPlayerMP player, String s) {

    }

    @Override
    public EntityPlayer getClientPlayer() {

        return null;
    }

    @Override
    public void registerSoundThings() {

    }

    @Override
    public int setArmorPrefix(String ultimate) {
        return 0;
    }

    @Override
    public void registerRenderThings() {

    }

    @Override
    public void registerKeyboardInput() {

    }

    @Override
    public void registerNetworkStuff() {
        super.registerNetworkStuff();
        FMLCommonHandler.instance()
            .bus()
            .register(new RiderControl(this.getNetwork()));
    }


}
