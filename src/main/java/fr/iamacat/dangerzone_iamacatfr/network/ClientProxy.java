package fr.iamacat.dangerzone_iamacatfr.network;

import fr.iamacat.dangerzone_iamacatfr.entities.entity.unfinished.GhostInstance;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderFireball;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.InputConfusedMovement;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.bosses.BeeInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.model.*;
import fr.iamacat.dangerzone_iamacatfr.entities.model.MavisBallModel;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.*;
import fr.iamacat.dangerzone_iamacatfr.entities.render.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.entities.render.unfinished.RenderTFGenericLiving;
import fr.iamacat.dangerzone_iamacatfr.gui.FairyGui;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Helper;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class ClientProxy implements ISidedProxy {

    @Override
    public void registerRenders() {
        final float shadowSize = 0.5f;
        RenderingRegistry
            .registerEntityRenderingHandler(AppleCowInstance.class, new AppleCowRenderer(new AppleCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            CrystalCowInstance.class,
            new CrystalCowRenderer(new CrystalCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            EnchantedGoldenAppleCowInstance.class,
            new EnchantedGoldenAppleCowRenderer(new EnchantedGoldenAppleCowModel(), 0.5F));
        RenderingRegistry.registerEntityRenderingHandler(
            GoldenAppleCowInstance.class,
            new GoldenAppleCowRenderer(new GoldenAppleCowModel(), 0.5F));

        RenderingRegistry.registerEntityRenderingHandler(BrownAntInstance.class, new BrownAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(RedAntInstance.class, new RedAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(RainbowAntInstance.class, new RainBowAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(UnstableAntInstance.class, new UnstableAntRenderer());
        RenderingRegistry.registerEntityRenderingHandler(TermiteInstance.class, new TermiteRenderer());

        RenderingRegistry.registerEntityRenderingHandler(
            GirlFriendInstance.class,
            new GirlFriendRenderer(new ModelBiped(0.5f), 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(BoyFriendInstance.class, new BoyFriendRenderer(new ModelBiped(0.5f), 0.5f));

        RenderingRegistry
            .registerEntityRenderingHandler(TinyBirdsInstance.class, new TinyBirdsRenderer(new TinyBirdsModel(), 1.0F));

        RenderingRegistry.registerEntityRenderingHandler(
            BirdsInstance.class,
            new BirdsRenderer(new BirdsModel(), 1.0F, "tinybirdbrown.png"));

        RenderingRegistry.registerEntityRenderingHandler(
            CaveFisherInstance.class,
            new CaveFisherRenderer(new CaveFisherModel(), 1.0F));
        RenderingRegistry
            .registerEntityRenderingHandler(EyeRayInstance.class, new EyeRayRenderer(new EyeRayModel(), 1.0F));

        RenderingRegistry
            .registerEntityRenderingHandler(FairyInstance.class, new FairyRenderer(new FairyModel(), 1.0F));
        RenderingRegistry.registerEntityRenderingHandler(FairyFishHookInstance.class, new FishRenderer());
        RenderingRegistry.registerEntityRenderingHandler(
            CrabInstance.class,
            new CrabRenderer(new CrabModel(), 0.625F, ":textures/entity/helmetcrab.png"));

        RenderingRegistry
            .registerEntityRenderingHandler(AlienInstance.class, new AlienRenderer(new AlienModel(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(RatInstance.class, new RatRenderer(new RatModel(), 0.5f));

        RenderingRegistry
            .registerEntityRenderingHandler(AlosaurusInstance.class, new AlosaurusRenderer(new AlosaurusModel(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            AttackSquidInstance.class,
            new AttackSquidRenderer(new AttackSquidModel(), 0.5f));

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

        RenderingRegistry.registerEntityRenderingHandler(
            BaryonyxInstance.class,
            new BaryonyxRenderer(new BaryonyxModel(), shadowSize, 2.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(MassoInstance.class, new MassoRenderer(new MassoModel(), shadowSize));
        RenderingRegistry
            .registerEntityRenderingHandler(BasilikInstance.class, new BasilikRenderer(new BasilikModel(), 0.5f));
        ResourceLocation textureLocation = new ResourceLocation(Tags.MODID, "textures/entity/beaver.png");

        RenderingRegistry.registerEntityRenderingHandler(
            BeaverInstance.class,
            new GenericLivingRenderer(new BeaverModel(), 0.5f, textureLocation));
        RenderingRegistry.registerEntityRenderingHandler(BeeInstance.class, new BeeRenderer());
        RenderingRegistry.registerEntityRenderingHandler(DarkCrystalInstance.class, new DarkCrystalRenderer());
        RenderingRegistry
            .registerEntityRenderingHandler(ButterflyInstance.class, new ButterflyRenderer(new ButterflyModel(), 0.5f));

        RenderingRegistry.registerEntityRenderingHandler(
            ChipMunkInstance.class,
            new RenderTFGenericLiving(new ChipmunkModel(), 1.0F, ":textures/entity/squirrel2.png"));

        RenderingRegistry.registerEntityRenderingHandler(
            WhaleRenderer.WhaleInstance.class,
            new RenderLiving(new WhaleRenderer.ModelWhale(), 0.0f) {

                protected ResourceLocation getEntityTexture(final Entity par1Entity) {
                    return new ResourceLocation(Tags.MODID + ":textures/entity/BelugaTexture.png");
                }
            });
        RenderingRegistry
            .registerEntityRenderingHandler(TwilightMobInstance.class, new TwilightMobInstance.RenderTheMob(new PonyRobotModel(), 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            DemonSpiderInstance.class,
            new BlackWidowRenderer(new BlackWidowModel(0.96f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(LeviathanInstance.class, new LeviathanRenderer(new LeviathanModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThunderHoovesInstance.class,
            new ThunderHoovesRenderer(new ChiefThunderHoovesModel(1.0f), 1.8f, 1.8f));
        RenderingRegistry
            .registerEntityRenderingHandler(TwilicornInstance.class, new TwilicornRenderer(new TwilicornModel(0.85f), 0.75f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(KingbowserInstance.class, new KingbowserInstance.RenderTheMob6(new KingbowserModel(), 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(CentipedeInstance.class, new CentipedeRenderer(new CentipedeModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(HydraInstance.class, new HydraInstance.RenderTheMob8(new HydraModel(), 30.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(WindigoInstance.class, new WindigoRenderer(new WindigoModel(30.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(MooseInstance.class, new MooseInstance.RenderTheMob10(new MooseModel(), 2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            BuffaloInstance.class,
            new BuffaloInstance.RenderTheMob11(new BufalloModel(), 4.0f));
        RenderingRegistry.registerEntityRenderingHandler(DarknessInstance.class, new LeechRenderer(new LeechModel(), 1.2f, 1.2f));
        RenderingRegistry.registerEntityRenderingHandler(
            TwilightMagicInstance.class,
            new TwiMagicRenderer(new TwilicornOrbsModel(0.8f), 0.8f, 0.8f));
        RenderingRegistry
            .registerEntityRenderingHandler(FlameDragonInstance.class, new FlameDragonRenderer(new GarbleModel(7.5f), 2.2f, 2.2f));
        RenderingRegistry
            .registerEntityRenderingHandler(MooseBigInstance.class, new MooseBigInstance.RenderTheMob15(new MooseBigModel(), 1.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(CragadileInstance.class, new CragadileRenderer(new CragadileModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(BearInstance.class, new BearInstance.RenderTheMob17(new BearModel(), 3.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(ToughGuyInstance.class, new ToughGuyInstance.RenderTheMob18(new ToughGuyModel(), 2.5f));
        RenderingRegistry.registerEntityRenderingHandler(MavisInstance.class, new MavisInstance.RenderTheMob19(new MavisModel(), 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(UrsaMAJORInstance.class, new UrsaMAJORInstance.RenderTheMob21(new UrsaMAJORModel(), 32.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(PhoenixInstance.class, new PhoenixRenderer(new PhoenixModel(6.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(DashInstance.class, new DashRenderer(new RainbowDashModel(0.85f), 0.75f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(ManticoreInstance.class, new ManticoreInstance.RenderTheMob24(new ManticoreModel(), 4.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            RainbowCentipedeInstance.class,
            new RainbowCentipedeRenderer(new GiantCentipedeModel(0.52f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ParaspriteInstance.class,
            new ParaspriteRenderer(new ParaspriteModel(0.25f), 0.25f, 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(AJInstance.class, new AJRenderer(new AppleJackModel(1.0f), 0.85f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            ArcticScorpionInstance.class,
            new ArcticScorpionRenderer(new ArcticScorpionModel(6.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TimberWolfInstance.class,
            new TimberWolfRenderer(new TimberWolfModel(0.85f), 0.85f, 0.85f));
        RenderingRegistry
            .registerEntityRenderingHandler(CockatriceInstance.class, new CockatriceRenderer(new CockatriceModel(1.1f), 1.1f, 1.1f));
        RenderingRegistry
            .registerEntityRenderingHandler(IronWillInstance.class, new IronWillRenderer(new IronWillModel(1.6f), 1.6f, 1.6f));
        RenderingRegistry
            .registerEntityRenderingHandler(CrabzillaInstance.class, new CrabzillaRenderer(new CrabzillaModel(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(DashCloudInstance.class, new DashCloudRenderer(new DashCloudModel(2.0f), 2.0f, 2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TrevorPhillipsInstance.class,
            new TrevorPhillipsRenderer(new ModelBiped(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(SkullBossInstance.class, new SkullBossRenderer(new SkullofDoomModel(), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(SkullInstance.class, new SkullRenderer(new SkullofDoomModel(), 0.5f, 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(YakPrinceInstance.class, new YakPrinceRenderer(new PrinceYakFurModel(), 1.2f, 1.2f));
        RenderingRegistry
            .registerEntityRenderingHandler(SpikezillaInstance.class, new SpikezillaRenderer(new SpikezillaModel(), 0.9f, 0.9f));
        RenderingRegistry
            .registerEntityRenderingHandler(RhinocerosInstance.class, new RhinoRenderer(new RhinocerosModel(), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(TwilightCannonInstance.class, new RangedRenderer());
        RenderingRegistry.registerEntityRenderingHandler(LaserBallSecondInstance.class, new RangedRenderer());
        RenderingRegistry
            .registerEntityRenderingHandler(MavisBallModel.class, new RenderSnowball(ItemInitDangerZone.mavisOrb));

        RenderingRegistry.registerEntityRenderingHandler(TwilicornArrowInstance.class, new TwilightMagicRenderer());

        RenderingRegistry
            .registerEntityRenderingHandler(PhoenixArrowInstance.class, new PhoenixArrowRenderer(ItemInitDangerZone.phoenixFeather));

        RenderingRegistry.registerEntityRenderingHandler(TwilyMagicInstance.class, new TwilyMagic2Renderer());
        RenderingRegistry.registerEntityRenderingHandler(
            DarkCrystalCannonInstance.class,
            new RenderSnowball(ItemInitDangerZone.darkCrystal));
        RenderingRegistry.registerEntityRenderingHandler(WindigoPowerInstance.class, new WindigoPowerRenderer());
        RenderingRegistry.registerEntityRenderingHandler(LongHitInstance.class, new RangedRenderer());
        RenderingRegistry.registerEntityRenderingHandler(MagicInstance.class, new MagicTextureRenderer());
        RenderingRegistry.registerEntityRenderingHandler(BetterFireballInstance.class, new RenderFireball(2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TwilightFireballInstance.class,
            new RenderSnowball(ItemInitDangerZone.twilightStar));
        RenderingRegistry.registerEntityRenderingHandler(HydraFireballInstance.class, new RenderFireball(8.0f));
        RenderingRegistry.registerEntityRenderingHandler(FreezeBall.class, new RenderFireball(4.0f));
        RenderingRegistry.registerEntityRenderingHandler(RobotBeamInstance.class, new RenderFireball(0.2f));
        RenderingRegistry.registerEntityRenderingHandler(FireCannon.class, new MeteorRenderer());
        RenderingRegistry.registerEntityRenderingHandler(RainbowCannonInstance.class, new RainbowCannonRenderer());
        RenderingRegistry.registerEntityRenderingHandler(ProjectileApplesInstance.class, new ApplesRenderer());

        RenderingRegistry.registerEntityRenderingHandler(GhostInstance.class, new GhostRenderer(new ModelBiped(), 0.0f));


    }

    @Override
    public void openRenameGUI(FairyInstance fairy) {
        DangerLogger.LOGGER.info("ClientProxy.openRenameGUI");

        if (fairy.isRuler(getCurrentPlayer())) {
            DangerLogger.LOGGER.info("ClientProxy.openRenameGUI: current player is ruler, displaying gui");
            fairy.setNameEnabled(false);
            Minecraft.getMinecraft()
                .displayGuiScreen(new FairyGui(fairy));
        }
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
}
