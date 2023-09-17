package fr.iamacat.dangerzone_iamacatfr.network;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.InputConfusedMovement;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.AlienInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.entities.model.*;
import fr.iamacat.dangerzone_iamacatfr.entities.model.AlienModel;
import fr.iamacat.dangerzone_iamacatfr.entities.projectile.EyeRayInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.render.*;
import fr.iamacat.dangerzone_iamacatfr.entities.render.AlienRenderer;
import fr.iamacat.dangerzone_iamacatfr.entities.render.babydragon.*;
import fr.iamacat.dangerzone_iamacatfr.gui.FairyGui;
import fr.iamacat.dangerzone_iamacatfr.util.Helper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;

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

        RenderingRegistry.registerEntityRenderingHandler(
            AlienInstance.class,
            new AlienRenderer(new AlienModel(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            RatInstance.class,
            new RatRenderer(new RatModel(), 0.5f));

        RenderingRegistry.registerEntityRenderingHandler(
            AlosaurusInstance.class,
            new AlosaurusRenderer(new AlosaurusModel(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            AttackSquidInstance.class,
            new AttackSquidRenderer(new AttackSquidModel(), 0.5f));

        RenderingRegistry.registerEntityRenderingHandler(EntityBirchDragon.class, new RenderBirchDragon());
        RenderingRegistry.registerEntityRenderingHandler( EntityBlazeDragon.class, new RenderBlazeDragon());
        RenderingRegistry.registerEntityRenderingHandler( EntityAlpsDragon.class, new RenderAlpsDragon());
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
        RenderingRegistry.registerEntityRenderingHandler(EntityKleurloos.class, new RenderKleurloos());
        RenderingRegistry.registerEntityRenderingHandler(EntityAngelDragon.class, new RenderAngelDragon());

        RenderingRegistry.registerEntityRenderingHandler(BaryonyxInstance.class, new BaryonyxRenderer(new BaryonyxModel(), shadowSize, 2.5f));
        RenderingRegistry.registerEntityRenderingHandler(MassoInstance.class, new MassoRenderer(new MassoModel(), shadowSize));
        RenderingRegistry.registerEntityRenderingHandler(BasilikInstance.class, new BasilikRenderer(new BasilikModel(), 0.5f));

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
}
