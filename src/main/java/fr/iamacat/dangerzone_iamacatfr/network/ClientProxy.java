package fr.iamacat.dangerzone_iamacatfr.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.InputConfusedMovement;
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
import fr.iamacat.dangerzone_iamacatfr.util.Helper;
import fr.iamacat.dangerzone_iamacatfr.util.KeyHandler;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
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

import static cpw.mods.fml.client.registry.RenderingRegistry.registerEntityRenderingHandler;

public class ClientProxy implements ISidedProxy {

    @Override
    public void registerRenders() {
        final float shadowSize = 0.5f;
        registerEntityRenderingHandler(AppleCowInstance.class, new AppleCowRenderer(new AppleCowModel(), 0.5F));
        registerEntityRenderingHandler(CrystalCowInstance.class, new CrystalCowRenderer(new CrystalCowModel(), 0.5F));
        registerEntityRenderingHandler(
            EnchantedGoldenAppleCowInstance.class,
            new EnchantedGoldenAppleCowRenderer(new EnchantedGoldenAppleCowModel(), 0.5F));
        registerEntityRenderingHandler(
            GoldenAppleCowInstance.class,
            new GoldenAppleCowRenderer(new GoldenAppleCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            LunaMothInstance.class,
            new ButterflyRenderer(new ButterflyModel(0.75f), 0.4f, 1.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(BrownAntInstance.class, new BrownAntRenderer(new BrownAntModel(), 0.1f, 0.25f));
        registerEntityRenderingHandler(RedAntInstance.class, new RedAntRenderer(new RedAntModel(), 0.1f, 0.25f));
        registerEntityRenderingHandler(RainbowAntInstance.class, new RainBowAntRenderer(new RainBowAntModel(), 0.1f, 0.25f));
        registerEntityRenderingHandler(UnstableAntInstance.class, new UnstableAntRenderer(new UnstableAntModel(), 0.1f, 0.25f));
        registerEntityRenderingHandler(TermiteInstance.class, new TermiteRenderer(new TermiteModel(), 0.1f, 0.25f));

        registerEntityRenderingHandler(GirlfriendInstance.class, new GirlFriendRenderer(new ModelBiped(0.5f), 0.5f));
        registerEntityRenderingHandler(BoyfriendInstance.class, new BoyFriendRenderer(new ModelBiped(0.5f), 0.5f));

        registerEntityRenderingHandler(TinyBirdsInstance.class, new TinyBirdsRenderer(new TinyBirdsModel(), 1.0F));

        registerEntityRenderingHandler(
            BirdsInstance.class,
            new BirdsRenderer(new BirdsModel(), 1.0F, "tinybirdbrown.png"));

        registerEntityRenderingHandler(CaveFisherInstance.class, new CaveFisherRenderer(new CaveFisherModel(0.62f), 1.0F));
        registerEntityRenderingHandler(EyeRayInstance.class, new EyeRayRenderer(new EyeRayModel(), 1.0F));

        RenderingRegistry
            .registerEntityRenderingHandler(FairyInstance.class, new FairyRenderer(new FairyModel(1.5f), 0.1f, 0.35f));
        registerEntityRenderingHandler(
            CrabInstance.class,
            new CrabRenderer(new CrabModel(1.0f), 0.625F, ":textures/entity/helmetcrab.png"));

        registerEntityRenderingHandler(AlienInstance.class, new AlienRenderer(new AlienModel(), 0.5f));
        registerEntityRenderingHandler(RatInstance.class, new RatRenderer(new RatModel(), 0.5f));

        registerEntityRenderingHandler(AlosaurusInstance.class, new AlosaurusRenderer(new AlosaurusModel(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            Mothra.class,
            new ButterflyRenderer(new ButterflyModel(0.2f), 0.75f, 10.0f));
        registerEntityRenderingHandler(EntityBirchDragon.class, new RenderBirchDragon());
        registerEntityRenderingHandler(EntityBlazeDragon.class, new RenderBlazeDragon());
        registerEntityRenderingHandler(EntityAlpsDragon.class, new RenderAlpsDragon());
        registerEntityRenderingHandler(EntityCaveDragon.class, new RenderCaveDragon());
        registerEntityRenderingHandler(EntityDesertDragon.class, new RenderDesertDragon());
        registerEntityRenderingHandler(EntityDiamondDragon.class, new RenderDiamondDragon());
        registerEntityRenderingHandler(EntityEnthralledDragon.class, new RenderEnthralledDragon());
        registerEntityRenderingHandler(EntityEndDragon.class, new RenderEndDragon());
        registerEntityRenderingHandler(EntityExHillsDragon.class, new RenderExHillsDragon());
        registerEntityRenderingHandler(EntityGoldDragon.class, new RenderGoldDragon());
        registerEntityRenderingHandler(EntityJungleDragon.class, new RenderJungleDragon());
        registerEntityRenderingHandler(EntityNetherDragon.class, new RenderNetherDragon());
        registerEntityRenderingHandler(EntityPlainsDragon.class, new RenderPlainsDragon());
        registerEntityRenderingHandler(EntityStarDragon.class, new RenderStarDragon());
        registerEntityRenderingHandler(EntitySwampDragon.class, new RenderSwampDragon());
        registerEntityRenderingHandler(EntityRedstoneDragon.class, new RenderRedstoneDragon());
        registerEntityRenderingHandler(EntityBluestoneDragon.class, new RenderBluestoneDragon());
        registerEntityRenderingHandler(EntityForestDragon.class, new RenderForestDragon());
        registerEntityRenderingHandler(EntityAetherDragon.class, new RenderAetherDragon());
        registerEntityRenderingHandler(EntityCloudDragon.class, new RenderCloudDragon());
        registerEntityRenderingHandler(EntityMushroomDragon1.class, new RenderMushroomDragon1());
        registerEntityRenderingHandler(EntityMushroomDragon2.class, new RenderMushroomDragon2());
        registerEntityRenderingHandler(EntitySavannaDragon.class, new RenderSavannaDragon());
        registerEntityRenderingHandler(EntityMesaDragon.class, new RenderMesaDragon());
        registerEntityRenderingHandler(EntityRiverDragon.class, new RenderRiverDragon());
        registerEntityRenderingHandler(EntityOceanDragon.class, new RenderOceanDragon());
        registerEntityRenderingHandler(EntityEmeraldDragon.class, new RenderEmeraldDragon());
        registerEntityRenderingHandler(EntityIronDragon.class, new RenderIronDragon());
        registerEntityRenderingHandler(EntityLapisDragon.class, new RenderLapisDragon());
        registerEntityRenderingHandler(EntityCactusDragon.class, new RenderCactusDragon());
        registerEntityRenderingHandler(EntitySnowDragon.class, new RenderSnowDragon());
        registerEntityRenderingHandler(EntityPlainsDragon2.class, new RenderPlainsDragon2());
        registerEntityRenderingHandler(EntityZombieDragon.class, new RenderZombieDragon());
        registerEntityRenderingHandler(EntityBoneDragon.class, new RenderBoneDragon());
        registerEntityRenderingHandler(EntityAngelDragon.class, new RenderAngelDragon());

        registerEntityRenderingHandler(
            BaryonyxInstance.class,
            new BaryonyxRenderer(new BaryonyxModel(), shadowSize, 2.5f));
        registerEntityRenderingHandler(MassoInstance.class, new MassoRenderer(new MassoModel(), shadowSize));
        registerEntityRenderingHandler(BasilikInstance.class, new BasilikRenderer(new BasilikModel(0.3f), 0.5f));
        ResourceLocation textureLocation = new ResourceLocation(Tags.MODID, "textures/entity/beaver.png");

        registerEntityRenderingHandler(
            BeaverInstance.class,
            new GenericLivingRenderer(new BeaverModel(), 0.5f, textureLocation));
        registerEntityRenderingHandler(BeeInstance.class, new BeeRenderer());
        registerEntityRenderingHandler(DarkCrystalInstance.class, new DarkCrystalRenderer());
        registerEntityRenderingHandler(ButterflyInstance.class, new ButterflyRenderer(new ButterflyModel(0.75f), 0.5f, 1.5f));

        registerEntityRenderingHandler(
            WhaleRenderer.WhaleInstance.class,
            new RenderLiving(new WhaleRenderer.ModelWhale(), 0.0f) {

                protected ResourceLocation getEntityTexture(final Entity par1Entity) {
                    return new ResourceLocation(Tags.MODID + ":textures/entity/BelugaTexture.png");
                }
            });
        registerEntityRenderingHandler(
            TwilightMobInstance.class,
            new TwilightMobInstance.RenderTheMob(new PonyRobotModel(), 1.5f));
        registerEntityRenderingHandler(
            DemonSpiderInstance.class,
            new BlackWidowRenderer(new BlackWidowModel(0.96f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            LeviathanInstance.class,
            new LeviathanRenderer(new LeviathanModel(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            ThunderHoovesInstance.class,
            new ThunderHoovesRenderer(new ChiefThunderHoovesModel(1.0f), 1.8f, 1.8f));
        registerEntityRenderingHandler(
            TwilicornInstance.class,
            new TwilicornRenderer(new TwilicornModel(0.85f), 0.75f, 0.75f));
        registerEntityRenderingHandler(
            KingbowserInstance.class,
            new KingbowserInstance.RenderTheMob6(new KingbowserModel(), 1.0f));
        registerEntityRenderingHandler(
            CentipedeInstance.class,
            new CentipedeRenderer(new CentipedeModel(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(HydraInstance.class, new HydraInstance.RenderTheMob8(new HydraModel(), 30.0f));
        registerEntityRenderingHandler(WindigoInstance.class, new WindigoRenderer(new WindigoModel(30.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(MooseInstance.class, new MooseInstance.RenderTheMob10(new MooseModel(), 2.0f));
        registerEntityRenderingHandler(
            BuffaloInstance.class,
            new BuffaloInstance.RenderTheMob11(new BufalloModel(), 4.0f));
        registerEntityRenderingHandler(DarknessInstance.class, new LeechRenderer(new LeechModel(), 1.2f, 1.2f));
        registerEntityRenderingHandler(
            TwilightMagicInstance.class,
            new TwiMagicRenderer(new TwilicornOrbsModel(0.8f), 0.8f, 0.8f));
        registerEntityRenderingHandler(
            FlameDragonInstance.class,
            new FlameDragonRenderer(new GarbleModel(7.5f), 2.2f, 2.2f));
        registerEntityRenderingHandler(
            MooseBigInstance.class,
            new MooseBigInstance.RenderTheMob15(new MooseBigModel(), 1.5f));
        registerEntityRenderingHandler(
            CragadileInstance.class,
            new CragadileRenderer(new CragadileModel(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(BearInstance.class, new BearInstance.RenderTheMob17(new BearModel(), 3.0f));
        registerEntityRenderingHandler(
            ToughGuyInstance.class,
            new ToughGuyInstance.RenderTheMob18(new ToughGuyModel(), 2.5f));
        registerEntityRenderingHandler(MavisInstance.class, new MavisInstance.RenderTheMob19(new MavisModel(), 1.0f));
        registerEntityRenderingHandler(
            UrsaMAJORInstance.class,
            new UrsaMAJORInstance.RenderTheMob21(new UrsaMAJORModel(), 32.0f));
        registerEntityRenderingHandler(PhoenixInstance.class, new PhoenixRenderer(new PhoenixModel(6.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(DashInstance.class, new DashRenderer(new RainbowDashModel(0.85f), 0.75f, 0.75f));
        registerEntityRenderingHandler(
            ManticoreInstance.class,
            new ManticoreInstance.RenderTheMob24(new ManticoreModel(), 4.5f));
        registerEntityRenderingHandler(
            RainbowCentipedeInstance.class,
            new RainbowCentipedeRenderer(new GiantCentipedeModel(0.52f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            ParaspriteInstance.class,
            new ParaspriteRenderer(new ParaspriteModel(0.25f), 0.25f, 0.25f));
        registerEntityRenderingHandler(AJInstance.class, new AJRenderer(new AppleJackModel(1.0f), 0.85f, 0.85f));
        registerEntityRenderingHandler(
            ArcticScorpionInstance.class,
            new ArcticScorpionRenderer(new ArcticScorpionModel(6.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            TimberWolfInstance.class,
            new TimberWolfRenderer(new TimberWolfModel(0.85f), 0.85f, 0.85f));
        registerEntityRenderingHandler(
            CockatriceInstance.class,
            new CockatriceRenderer(new CockatriceModel(1.1f), 1.1f, 1.1f));
        registerEntityRenderingHandler(
            IronWillInstance.class,

            new IronWillRenderer(new IronWillModel(1.6f), 1.6f, 1.6f));
        registerEntityRenderingHandler(
            CrabzillaInstance.class,
            new CrabzillaRenderer(new CrabzillaModel(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            DashCloudInstance.class,
            new DashCloudRenderer(new DashCloudModel(2.0f), 2.0f, 2.0f));
        registerEntityRenderingHandler(
            TrevorPhillipsInstance.class,
            new TrevorPhillipsRenderer(new ModelBiped(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            SkullBossInstance.class,
            new SkullBossRenderer(new SkullofDoomModel(), 1.0f, 1.0f));
        registerEntityRenderingHandler(SkullInstance.class, new SkullRenderer(new SkullofDoomModel(), 0.5f, 0.5f));
        registerEntityRenderingHandler(
            YakPrinceInstance.class,
            new YakPrinceRenderer(new PrinceYakFurModel(), 1.2f, 1.2f));
        registerEntityRenderingHandler(
            SpikezillaInstance.class,
            new SpikezillaRenderer(new SpikezillaModel(), 0.9f, 0.9f));
        registerEntityRenderingHandler(RhinocerosInstance.class, new RhinoRenderer(new RhinocerosModel(), 1.0f, 1.0f));
        registerEntityRenderingHandler(TwilightCannonInstance.class, new RangedRenderer());
        registerEntityRenderingHandler(LaserBallSecondInstance.class, new RangedRenderer());
        registerEntityRenderingHandler(MavisBallModel.class, new RenderSnowball(ItemInitDangerZone.mavisOrb));

        registerEntityRenderingHandler(TwilicornArrowInstance.class, new TwilightMagicRenderer());

        registerEntityRenderingHandler(
            PhoenixArrowInstance.class,
            new PhoenixArrowRenderer(ItemInitDangerZone.phoenixFeather));

        registerEntityRenderingHandler(TwilyMagicInstance.class, new TwilyMagic2Renderer());
        registerEntityRenderingHandler(
            DarkCrystalCannonInstance.class,
            new RenderSnowball(ItemInitDangerZone.darkCrystal));
        registerEntityRenderingHandler(WindigoPowerInstance.class, new WindigoPowerRenderer());
        registerEntityRenderingHandler(LongHitInstance.class, new RangedRenderer());
        registerEntityRenderingHandler(MagicInstance.class, new MagicTextureRenderer());
        registerEntityRenderingHandler(BetterFireballInstancemMLP.class, new RenderFireball(2.0f));
        registerEntityRenderingHandler(
            TwilightFireballInstance.class,
            new RenderSnowball(ItemInitDangerZone.twilightStar));
        registerEntityRenderingHandler(HydraFireballInstance.class, new RenderFireball(8.0f));
        registerEntityRenderingHandler(FreezeBall.class, new RenderFireball(4.0f));
        registerEntityRenderingHandler(RobotBeamInstance.class, new RenderFireball(0.2f));
        registerEntityRenderingHandler(FireCannon.class, new MeteorRenderer());
        registerEntityRenderingHandler(RainbowCannonInstance.class, new RainbowCannonRenderer());
        registerEntityRenderingHandler(ProjectileApplesInstance.class, new ApplesRenderer());

        registerEntityRenderingHandler(GhostInstance.class, new GhostRenderer(new ModelBiped(), 0.0f));

        MinecraftForge.EVENT_BUS.register(new GirlfriendOverlayGui(Minecraft.getMinecraft()));
        registerEntityRenderingHandler(BoyfriendInstance.class, new BoyFriendRenderer(new ModelBiped(), 0.55f));
        registerEntityRenderingHandler(Shoes.class, new RenderShoe());
        registerEntityRenderingHandler(SunspotUrchin.class, new RenderItemUrchin());
        registerEntityRenderingHandler(WaterBallInstance.class, new RenderItemUrchin());
        registerEntityRenderingHandler(InkSack.class, new RenderItemUrchin());
        registerEntityRenderingHandler(LaserBallInstance.class, new RenderItemUrchin());
        registerEntityRenderingHandler(IceBall.class, new RenderItemUrchin());
        registerEntityRenderingHandler(AcidEntityInstance.class, new RenderItemUrchin());
        registerEntityRenderingHandler(DeadIrukandjiInstance.class, new RenderItemUrchin());
        registerEntityRenderingHandler(BerthaHit.class, new RenderItemUrchin());
        registerEntityRenderingHandler(CageInstance.class, new RenderCage());
        registerEntityRenderingHandler(UltimateFishHook.class, new RenderFish());
        registerEntityRenderingHandler(UltimateArrow.class, new RenderArrow());
        registerEntityRenderingHandler(EntityThrownRockInstance.class, new RenderThrownRock());
        registerEntityRenderingHandler(TRex.class, new RenderTRex(new ModelTRex(0.2f), 1.0f, 1.2f));
        registerEntityRenderingHandler(
            CryolophosaurusInstance.class,
            new RenderCryolophosaurus(new ModelCryolophosaurus(0.75f), 0.75f, 0.5f));
        registerEntityRenderingHandler(
            BasiliskInstance.class,
            new RenderBasilisk(new BasilikModel(0.3f), 0.5f, 1.25f));
        registerEntityRenderingHandler(
            CamarasaurusInstance.class,
            new RenderCamarasaurus(new ModelCamarasaurus(0.65f), 0.65f, 0.65f));
        registerEntityRenderingHandler(Hydrolisc.class, new RenderHydrolisc(new ModelHydrolisc(0.65f), 0.65f, 0.65f));
        registerEntityRenderingHandler(
            VelocityRaptor.class,
            new RenderVelocityRaptor(new ModelVelocityRaptor(1.25f), 0.55f, 0.75f));
        registerEntityRenderingHandler(
            DragonflyInstance.class,
            new RenderDragonfly(new ModelDragonfly(2.0f), 0.3f, 1.5f));
        registerEntityRenderingHandler(
            EmperorScorpion.class,
            new RenderEmperorScorpion(new ModelEmperorScorpion(0.22f), 0.95f, 1.5f));
        registerEntityRenderingHandler(Spyro.class, new RenderSpyro(new ModelSpyro(0.65f), 0.65f, 0.75f));
        registerEntityRenderingHandler(
            GammaMetroid.class,
            new RenderGammaMetroid(new ModelGammaMetroid(0.45f), 0.75f, 0.9f));
        registerEntityRenderingHandler(
            CockateilInstance.class,
            new RenderCockateil(new ModelCockateil(1.0f), 0.3f, 0.75f));
        registerEntityRenderingHandler(RubyBird.class, new RenderCockateil(new ModelCockateil(1.0f), 0.3f, 0.75f));
        registerEntityRenderingHandler(Kyuubi.class, new RenderKyuubi(new ModelKyuubi(0.5f), 0.1f, 1.0f));
        registerEntityRenderingHandler(Scorpion.class, new RenderScorpion(new ModelScorpion(0.62f), 0.35f, 0.75f));
        registerEntityRenderingHandler(
            CaveFisherInstance.class,
            new RenderCaveFisher(new CaveFisherModel(0.62f), 0.35f, 0.75f));
        registerEntityRenderingHandler(
            WaterDragon.class,
            new RenderWaterDragon(new ModelWaterDragon(0.5f), 0.85f, 1.1f));
        registerEntityRenderingHandler(
            AttackSquidInstance.class,
            new AttackSquidRenderer(new AttackSquidModel(1.0f), 0.25f, 0.9f));
        registerEntityRenderingHandler(HoverboardInstance.class, new RenderElevator());
        registerEntityRenderingHandler(Robot1.class, new RenderRobot1(new ModelRobot1(2.0f), 0.3f, 1.0f));
        registerEntityRenderingHandler(Robot2.class, new RenderRobot2(new ModelRobot2(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(Robot3.class, new RenderRobot3(new ModelRobot3(1.0f), 1.0f, 0.5f));
        registerEntityRenderingHandler(Robot4.class, new RenderRobot4(new ModelRobot4(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(Robot5.class, new RenderRobot5(new ModelRobot5(1.0f), 0.5f, 1.0f));
        registerEntityRenderingHandler(Kraken.class, new RenderKraken(new ModelKraken(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(Lizard.class, new RenderLizard(new ModelLizard(0.65f), 0.75f, 1.0f));
        registerEntityRenderingHandler(
            CephadromeInstance.class,
            new RenderCephadrome(new ModelCephadrome(0.55f), 1.25f, 1.0f));
        registerEntityRenderingHandler(DragonInstance.class, new RenderDragon(new ModelDragon(0.65f), 1.25f, 1.0f));
        registerEntityRenderingHandler(ChipMunkInstance.class, new RenderChipmunk(new ChipmunkModel(1.0f), 0.15f, 0.9f));
        registerEntityRenderingHandler(Gazelle.class, new RenderGazelle(new ModelGazelle(0.65f), 0.45f, 1.0f));
        registerEntityRenderingHandler(Ostrich.class, new RenderOstrich(new ModelOstrich(0.65f), 0.55f, 1.0f));
        registerEntityRenderingHandler(TrooperBug.class, new RenderTrooperBug(new ModelTrooperBug(0.22f), 0.95f, 1.1f));
        registerEntityRenderingHandler(SpitBug.class, new RenderSpitBug(new ModelSpitBug(0.55f), 0.55f, 0.75f));
        registerEntityRenderingHandler(StinkBug.class, new RenderStinkBug(new ModelStinkBug(0.75f), 0.35f, 0.85f));
        registerEntityRenderingHandler(Island.class, new RenderIsland(new ModelIsland(1.0f), 0.25f, 1.0f));
        registerEntityRenderingHandler(IslandToo.class, new RenderIslandToo(new ModelIsland(1.0f), 0.25f, 1.0f));
        registerEntityRenderingHandler(
            CreepingHorrorInstance.class,
            new RenderCreepingHorror(new ModelCreepingHorror(), 0.45f, 0.75f));
        registerEntityRenderingHandler(
            TerribleTerror.class,
            new RenderTerribleTerror(new ModelTerribleTerror(), 0.45f, 0.75f));
        registerEntityRenderingHandler(
            CliffRacerInstance.class,
            new RenderCliffRacer(new ModelCliffRacer(1.0f), 0.3f, 1.0f));
        registerEntityRenderingHandler(Triffid.class, new RenderTriffid(new ModelTriffid(1.0f), 0.3f, 1.0f));
        registerEntityRenderingHandler(PitchBlack.class, new RenderPitchBlack(new ModelPitchBlack(0.65f), 1.25f, 1.0f));
        registerEntityRenderingHandler(
            LurkingTerror.class,
            new RenderLurkingTerror(new ModelLurkingTerror(), 0.45f, 0.85f));
        registerEntityRenderingHandler(Godzilla.class, new RenderGodzilla(new ModelGodzilla(0.2f), 1.0f, 2.0f));
        registerEntityRenderingHandler(GodzillaHead.class, new RenderGodzillaHead(null, 0.0f, 0.0f));
        registerEntityRenderingHandler(KingHead.class, new RenderKingHead(null, 0.0f, 0.0f));
        registerEntityRenderingHandler(QueenHead.class, new RenderQueenHead(null, 0.0f, 0.0f));
        registerEntityRenderingHandler(WormSmall.class, new RenderWormSmall(new ModelWormSmall(), 0.1f, 1.0f));
        registerEntityRenderingHandler(WormMedium.class, new RenderWormMedium(new ModelWormMedium(), 0.25f, 1.0f));
        registerEntityRenderingHandler(WormLarge.class, new RenderWormLarge(new ModelWormLarge(), 0.9f, 1.0f));
        registerEntityRenderingHandler(
            CassowaryInstance.class,
            new RenderCassowary(new ModelCassowary(0.55f), 0.5f, 1.0f));
        registerEntityRenderingHandler(GoldFish.class, new RenderGoldFish(new ModelGoldFish(0.7f), 0.2f, 1.0f));
        registerEntityRenderingHandler(
            CloudSharkInstance.class,
            new RenderCloudShark(new ModelCloudShark(1.0f), 0.5f, 1.0f));
        registerEntityRenderingHandler(LeafMonster.class, new RenderLeafMonster(new ModelLeafMonster(), 0.65f, 1.0f));
        registerEntityRenderingHandler(
            EnderKnight.class,
            new RenderEnderKnight(new ModelEnderKnight(0.21f), 0.3f, 1.0f));
        registerEntityRenderingHandler(
            EnderReaper.class,
            new RenderEnderReaper(new ModelEnderReaper(0.23f), 0.2f, 1.0f));
        registerEntityRenderingHandler(Peacock.class, new RenderPeacock(new ModelPeacock(0.75f), 0.25f, 1.0f));
        registerEntityRenderingHandler(Rotator.class, new RenderRotator(new ModelRotator(0.25f), 0.1f, 1.0f));
        registerEntityRenderingHandler(Vortex.class, new RenderVortex(new ModelVortex(0.25f), 0.1f, 1.0f));
        registerEntityRenderingHandler(
            DungeonBeastInstance.class,
            new RenderDungeonBeast(new ModelDungeonBeast(0.62f), 0.25f, 1.0f));
        registerEntityRenderingHandler(Rat.class, new RenderRat(new ModelRat(1.0f), 0.1f, 0.75f));
        registerEntityRenderingHandler(Flounder.class, new RenderFlounder(new ModelFlounder(), 0.1f, 1.0f));registerEntityRenderingHandler(Irukandji.class, new RenderIrukandji(new ModelIrukandji(1.0f), 0.1f, 0.25f));
        registerEntityRenderingHandler(Skate.class, new RenderSkate(new ModelSkate(1.0f), 0.1f, 0.75f));
        registerEntityRenderingHandler(Urchin.class, new RenderUrchin(new ModelUrchin(1.0f), 0.35f, 1.25f));
        registerEntityRenderingHandler(Mantis.class, new RenderMantis(new ModelMantis(2.0f), 0.9f, 1.1f));
        registerEntityRenderingHandler(
            HerculesBeetle.class,
            new RenderHerculesBeetle(new ModelHerculesBeetle(1.0f), 0.99f, 1.1f));
        registerEntityRenderingHandler(Stinky.class, new RenderStinky(new ModelStinky(0.65f), 0.75f, 1.0f));
        registerEntityRenderingHandler(TheKing.class, new RenderTheKing(new ModelTheKing(0.65f), 1.9f, 2.1f));
        registerEntityRenderingHandler(TheQueen.class, new RenderTheQueen(new ModelTheQueen(0.65f), 1.9f, 2.0f));
        registerEntityRenderingHandler(ThePrince.class, new RenderThePrince(new ModelThePrince(0.65f), 0.75f, 0.75f));
        registerEntityRenderingHandler(Molenoid.class, new RenderMolenoid(new ModelMolenoid(0.5f), 1.0f, 1.0f));
        registerEntityRenderingHandler(SeaMonster.class, new RenderSeaMonster(new ModelSeaMonster(0.5f), 1.0f, 1.0f));
        registerEntityRenderingHandler(SeaViper.class, new RenderSeaViper(new ModelSeaViper(0.5f), 1.0f, 1.0f));
        registerEntityRenderingHandler(
            EasterBunnyInstance.class,
            new RenderEasterBunny(new ModelEasterBunny(0.55f), 0.5f, 1.0f));
        registerEntityRenderingHandler(
            CaterKillerInstance.class,
            new RenderCaterKiller(new ModelCaterKiller(0.22f), 1.0f, 1.25f));
        registerEntityRenderingHandler(Leon.class, new RenderLeon(new ModelLeon(0.22f), 1.0f, 1.75f));
        registerEntityRenderingHandler(Hammerhead.class, new RenderHammerhead(new ModelHammerhead(0.33f), 1.0f, 2.5f));
        registerEntityRenderingHandler(
            RubberDucky.class,
            new RenderRubberDucky(new ModelRubberDucky(1.0f), 0.15f, 0.75f));
        registerEntityRenderingHandler(
            ThePrinceTeen.class,
            new RenderThePrinceTeen(new ModelThePrinceTeen(0.65f), 1.0f, 1.25f));
        registerEntityRenderingHandler(BandPInstance.class, new RenderBandP(new ModelBandP(0.4f), 1.0f, 1.0f));
        registerEntityRenderingHandler(RockBase.class, new RenderRockBase(new ModelRockBase(1.0f), 0.0f, 1.0f));
        registerEntityRenderingHandler(
            PurplePower.class,
            new RenderPurplePower(new ModelPurplePower(1.0f), 0.3f, 2.75f));
        registerEntityRenderingHandler(
            BrutalflyInstance.class,
            new RenderBrutalfly(new ModelBrutalfly(0.2f), 0.75f, 9.0f));
        registerEntityRenderingHandler(
            Nastysaurus.class,
            new RenderNastysaurus(new ModelNastysaurus(0.65f), 1.0f, 1.5f));
        registerEntityRenderingHandler(
            Pointysaurus.class,
            new RenderPointysaurus(new ModelPointysaurus(1.0f), 1.0f, 1.0f));
        registerEntityRenderingHandler(CricketInstance.class, new RenderCricket(new ModelCricket(2.5f), 0.15f, 0.5f));
        registerEntityRenderingHandler(
            ThePrincess.class,
            new RenderThePrincess(new ModelThePrincess(0.65f), 0.7f, 0.7f));
        registerEntityRenderingHandler(Frog.class, new RenderFrog(new ModelFrog(1.0f), 0.35f, 1.0f));
        registerEntityRenderingHandler(
            ThePrinceAdult.class,
            new RenderThePrinceAdult(new ModelThePrinceAdult(0.65f), 1.2f, 1.0f));
        registerEntityRenderingHandler(
            SpiderRobot.class,
            new RenderSpiderRobot(new ModelSpiderRobot(1.0f), 0.99f, 1.0f));
        registerEntityRenderingHandler(SpiderDriver.class, new RenderSpiderDriver(new ModelSpider(), 0.5f));
        registerEntityRenderingHandler(GiantRobot.class, new RenderGiantRobot(new ModelGiantRobot(0.25f), 0.99f, 1.0f));
        registerEntityRenderingHandler(
            RedAntRobotInstance.class,
            new RenderAntRobot(new ModelAntRobot(1.0f), 0.99f, 1.0f));
        registerEntityRenderingHandler(CrabInstance.class, new RenderCrab(new CrabModel(1.0f), 0.99f, 1.0f));
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.MyBertha, new RenderBertha());
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.MySlice, new RenderSlice());
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.royalsword, new RenderRoyal());
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.SquidZooka, new RenderSquidZooka());
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.MyHammy, new RenderHammy());
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.BattleAxe, new RenderBattleAxe());
        MinecraftForgeClient.registerItemRenderer(ItemInitDangerZone.MyChainsaw, new RenderChainsaw());
        MinecraftForgeClient
            .registerItemRenderer(ItemInitDangerZone.MyQueenBattleAxe, new RenderQueenBattleAxe());

    }

    @Override
    public void openRenameGUI(FairyInstance fairy) {

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
    public void sendFairyDespawn(FairyInstance fairyInstance) {

    }

    @Override
    public void sendFairyMount(FairyInstance fairy, Entity ridingEntity) {

    }

    @Override
    public void sendChat(EntityPlayerMP player, String s) {

    }

    @Override
    public void sendFairyRename(FairyInstance fairy, String nameText) {

    }

    @Override
    public EntityPlayer getClientPlayer() {

        return null;
    }

    @Override
    public void registerKeyboardInput() {
        final KeyHandler k = new KeyHandler();
        FMLCommonHandler.instance()
            .bus()
            .register((Object) k);
        DangerZone.MyKeyhandler = k;
    }

    @Override
    public void registerNetworkStuff() {
        FMLCommonHandler.instance()
            .bus()
            .register((Object) new RiderControl(this.getNetwork()));
    }


    @Override
    public int setArmorPrefix(final String string) {
        return RenderingRegistry.addNewArmourRendererPrefix(string);
    }

    @Override
    public SimpleNetworkWrapper getNetwork() {
        return null;
    }
}
