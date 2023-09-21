
package danger.orespawn.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.model.ModelSpider;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderFish;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import danger.orespawn.entities.entityinstance.*;
import danger.orespawn.entities.model.*;
import danger.orespawn.entities.other.RiderControl;
import danger.orespawn.entities.renderer.*;
import danger.orespawn.items.CrystalCow;
import danger.orespawn.items.UltimateFishHook;
import danger.orespawn.utils.KeyHandler;
import danger.orespawn.utils.OreSpawnSounds;

public class ClientProxyOreSpawn extends CommonProxyOreSpawn {

    @Override
    public void registerRenderThings() {
        MinecraftForge.EVENT_BUS.register((Object) new GirlfriendOverlayGui(Minecraft.getMinecraft()));
        RenderingRegistry
            .registerEntityRenderingHandler(Girlfriend.class, (Render) new RenderGirlfriend(new ModelBiped(), 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Boyfriend.class, (Render) new RenderBoyfriend(new ModelBiped(), 0.55f));
        RenderingRegistry
            .registerEntityRenderingHandler(RedCow.class, (Render) new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(GoldCow.class, (Render) new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(EnchantedCow.class, (Render) new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(CrystalCow.class, (Render) new RenderEnchantedCow(new ModelCow(), 0.7f));
        RenderingRegistry.registerEntityRenderingHandler(Shoes.class, (Render) new RenderShoe());
        RenderingRegistry.registerEntityRenderingHandler(SunspotUrchin.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(WaterBall.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(InkSack.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(LaserBall.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(IceBall.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(Acid.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(DeadIrukandji.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(BerthaHit.class, (Render) new RenderItemUrchin());
        RenderingRegistry.registerEntityRenderingHandler(EntityCage.class, (Render) new RenderCage());
        RenderingRegistry.registerEntityRenderingHandler(UltimateFishHook.class, (Render) new RenderFish());
        RenderingRegistry.registerEntityRenderingHandler(UltimateArrow.class, (Render) new RenderArrow());
        RenderingRegistry.registerEntityRenderingHandler(EntityThrownRock.class, (Render) new RenderThrownRock());
        RenderingRegistry.registerEntityRenderingHandler(
            EntityButterfly.class,
            (Render) new RenderButterfly(new ModelButterfly(1.0f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Firefly.class,
            (Render) new RenderFirefly(new ModelFirefly(2.5f), 0.2f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityLunaMoth.class,
            (Render) new RenderButterfly(new ModelButterfly(0.75f), 0.4f, 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityMosquito.class,
            (Render) new RenderMosquito(new ModelMosquito(), 0.3f, 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Ghost.class, (Render) new RenderGhost(new ModelGhost(), 0.0f, 0.65f));
        RenderingRegistry.registerEntityRenderingHandler(
            GhostSkelly.class,
            (Render) new RenderGhostSkelly(new ModelGhostSkelly(), 0.0f, 1.05f));
        RenderingRegistry.registerEntityRenderingHandler(
            Mothra.class,
            (Render) new RenderButterfly(new ModelButterfly(0.2f), 0.75f, 10.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityAnt.class, (Render) new RenderAnt(new ModelAnt(), 0.1f, 0.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(EntityRedAnt.class, (Render) new RenderAnt(new ModelAnt(), 0.15f, 0.35f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityRainbowAnt.class,
            (Render) new RenderAnt(new ModelAnt(), 0.1f, 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(
            EntityUnstableAnt.class,
            (Render) new RenderAnt(new ModelAnt(), 0.1f, 0.25f));
        RenderingRegistry.registerEntityRenderingHandler(
            Alosaurus.class,
            (Render) new RenderAlosaurus(new ModelAlosaurus(0.22f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(TRex.class, (Render) new RenderTRex(new ModelTRex(0.2f), 1.0f, 1.2f));
        RenderingRegistry.registerEntityRenderingHandler(
            Tshirt.class,
            (Render) new RenderTshirt(new ModelTshirt(0.22f), 1.0f, 0.33f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cryolophosaurus.class,
            (Render) new RenderCryolophosaurus(new ModelCryolophosaurus(0.75f), 0.75f, 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            Basilisk.class,
            (Render) new RenderBasilisk(new ModelBasilisk(0.3f), 0.5f, 1.25f));
        RenderingRegistry.registerEntityRenderingHandler(
            Camarasaurus.class,
            (Render) new RenderCamarasaurus(new ModelCamarasaurus(0.65f), 0.65f, 0.65f));
        RenderingRegistry.registerEntityRenderingHandler(
            Hydrolisc.class,
            (Render) new RenderHydrolisc(new ModelHydrolisc(0.65f), 0.65f, 0.65f));
        RenderingRegistry.registerEntityRenderingHandler(
            VelocityRaptor.class,
            (Render) new RenderVelocityRaptor(new ModelVelocityRaptor(1.25f), 0.55f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Dragonfly.class,
            (Render) new RenderDragonfly(new ModelDragonfly(2.0f), 0.3f, 1.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Bee.class, (Render) new RenderBee(new ModelBee(2.0f), 0.9f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            EmperorScorpion.class,
            (Render) new RenderEmperorScorpion(new ModelEmperorScorpion(0.22f), 0.95f, 1.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Spyro.class, (Render) new RenderSpyro(new ModelSpyro(0.65f), 0.65f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Baryonyx.class,
            (Render) new RenderBaryonyx(new ModelBaryonyx(0.25f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            GammaMetroid.class,
            (Render) new RenderGammaMetroid(new ModelGammaMetroid(0.45f), 0.75f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cockateil.class,
            (Render) new RenderCockateil(new ModelCockateil(1.0f), 0.3f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            RubyBird.class,
            (Render) new RenderCockateil(new ModelCockateil(1.0f), 0.3f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(Kyuubi.class, (Render) new RenderKyuubi(new ModelKyuubi(0.5f), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Scorpion.class,
            (Render) new RenderScorpion(new ModelScorpion(0.62f), 0.35f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            CaveFisher.class,
            (Render) new RenderCaveFisher(new ModelCaveFisher(0.62f), 0.35f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(Alien.class, (Render) new RenderAlien(new ModelAlien(0.22f), 0.35f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            WaterDragon.class,
            (Render) new RenderWaterDragon(new ModelWaterDragon(0.5f), 0.85f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            AttackSquid.class,
            (Render) new RenderAttackSquid(new ModelAttackSquid(1.0f), 0.25f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(Elevator.class, (Render) new RenderElevator());
        RenderingRegistry
            .registerEntityRenderingHandler(Robot1.class, (Render) new RenderRobot1(new ModelRobot1(2.0f), 0.3f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot2.class, (Render) new RenderRobot2(new ModelRobot2(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot3.class, (Render) new RenderRobot3(new ModelRobot3(1.0f), 1.0f, 0.5f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot4.class, (Render) new RenderRobot4(new ModelRobot4(1.0f), 1.0f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Robot5.class, (Render) new RenderRobot5(new ModelRobot5(1.0f), 0.5f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Kraken.class, (Render) new RenderKraken(new ModelKraken(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Lizard.class,
            (Render) new RenderLizard(new ModelLizard(0.65f), 0.75f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cephadrome.class,
            (Render) new RenderCephadrome(new ModelCephadrome(0.55f), 1.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Dragon.class,
            (Render) new RenderDragon(new ModelDragon(0.65f), 1.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Chipmunk.class,
            (Render) new RenderChipmunk(new ModelChipmunk(1.0f), 0.15f, 0.9f));
        RenderingRegistry.registerEntityRenderingHandler(
            Gazelle.class,
            (Render) new RenderGazelle(new ModelGazelle(0.65f), 0.45f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Ostrich.class,
            (Render) new RenderOstrich(new ModelOstrich(0.65f), 0.55f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            TrooperBug.class,
            (Render) new RenderTrooperBug(new ModelTrooperBug(0.22f), 0.95f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpitBug.class,
            (Render) new RenderSpitBug(new ModelSpitBug(0.55f), 0.55f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            StinkBug.class,
            (Render) new RenderStinkBug(new ModelStinkBug(0.75f), 0.35f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            Island.class,
            (Render) new RenderIsland(new ModelIsland(1.0f), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            IslandToo.class,
            (Render) new RenderIslandToo(new ModelIsland(1.0f), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CreepingHorror.class,
            (Render) new RenderCreepingHorror(new ModelCreepingHorror(), 0.45f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            TerribleTerror.class,
            (Render) new RenderTerribleTerror(new ModelTerribleTerror(), 0.45f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            CliffRacer.class,
            (Render) new RenderCliffRacer(new ModelCliffRacer(1.0f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Triffid.class,
            (Render) new RenderTriffid(new ModelTriffid(1.0f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            PitchBlack.class,
            (Render) new RenderPitchBlack(new ModelPitchBlack(0.65f), 1.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            LurkingTerror.class,
            (Render) new RenderLurkingTerror(new ModelLurkingTerror(), 0.45f, 0.85f));
        RenderingRegistry.registerEntityRenderingHandler(
            Godzilla.class,
            (Render) new RenderGodzilla(new ModelGodzilla(0.2f), 1.0f, 2.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(GodzillaHead.class, (Render) new RenderGodzillaHead(null, 0.0f, 0.0f));
        RenderingRegistry.registerEntityRenderingHandler(KingHead.class, (Render) new RenderKingHead(null, 0.0f, 0.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(QueenHead.class, (Render) new RenderQueenHead(null, 0.0f, 0.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WormSmall.class,
            (Render) new RenderWormSmall(new ModelWormSmall(), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WormMedium.class,
            (Render) new RenderWormMedium(new ModelWormMedium(), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            WormLarge.class,
            (Render) new RenderWormLarge(new ModelWormLarge(), 0.9f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cassowary.class,
            (Render) new RenderCassowary(new ModelCassowary(0.55f), 0.5f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            GoldFish.class,
            (Render) new RenderGoldFish(new ModelGoldFish(0.7f), 0.2f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CloudShark.class,
            (Render) new RenderCloudShark(new ModelCloudShark(1.0f), 0.5f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            LeafMonster.class,
            (Render) new RenderLeafMonster(new ModelLeafMonster(), 0.65f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            EnderKnight.class,
            (Render) new RenderEnderKnight(new ModelEnderKnight(0.21f), 0.3f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            EnderReaper.class,
            (Render) new RenderEnderReaper(new ModelEnderReaper(0.23f), 0.2f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Beaver.class,
            (Render) new RenderBeaver(new ModelBeaver(0.5f), 0.15f, 0.75f));
        RenderingRegistry
            .registerEntityRenderingHandler(Termite.class, (Render) new RenderAnt(new ModelAnt(), 0.15f, 0.35f));
        RenderingRegistry
            .registerEntityRenderingHandler(Fairy.class, (Render) new RenderFairy(new ModelFairy(1.5f), 0.1f, 0.35f));
        RenderingRegistry.registerEntityRenderingHandler(
            Peacock.class,
            (Render) new RenderPeacock(new ModelPeacock(0.75f), 0.25f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Rotator.class,
            (Render) new RenderRotator(new ModelRotator(0.25f), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Vortex.class,
            (Render) new RenderVortex(new ModelVortex(0.25f), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            DungeonBeast.class,
            (Render) new RenderDungeonBeast(new ModelDungeonBeast(0.62f), 0.25f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Rat.class, (Render) new RenderRat(new ModelRat(1.0f), 0.1f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Flounder.class,
            (Render) new RenderFlounder(new ModelFlounder(), 0.1f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Whale.class, (Render) new RenderWhale(new ModelWhale(), 0.1f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Irukandji.class,
            (Render) new RenderIrukandji(new ModelIrukandji(1.0f), 0.1f, 0.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(Skate.class, (Render) new RenderSkate(new ModelSkate(1.0f), 0.1f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Urchin.class,
            (Render) new RenderUrchin(new ModelUrchin(1.0f), 0.35f, 1.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(Mantis.class, (Render) new RenderMantis(new ModelMantis(2.0f), 0.9f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            HerculesBeetle.class,
            (Render) new RenderHerculesBeetle(new ModelHerculesBeetle(1.0f), 0.99f, 1.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            Stinky.class,
            (Render) new RenderStinky(new ModelStinky(0.65f), 0.75f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Coin.class, (Render) new RenderCoin(new ModelCoin(0.22f), 0.75f, 0.125f));
        RenderingRegistry.registerEntityRenderingHandler(
            TheKing.class,
            (Render) new RenderTheKing(new ModelTheKing(0.65f), 1.9f, 2.1f));
        RenderingRegistry.registerEntityRenderingHandler(
            TheQueen.class,
            (Render) new RenderTheQueen(new ModelTheQueen(0.65f), 1.9f, 2.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrince.class,
            (Render) new RenderThePrince(new ModelThePrince(0.65f), 0.75f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Molenoid.class,
            (Render) new RenderMolenoid(new ModelMolenoid(0.5f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SeaMonster.class,
            (Render) new RenderSeaMonster(new ModelSeaMonster(0.5f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SeaViper.class,
            (Render) new RenderSeaViper(new ModelSeaViper(0.5f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            EasterBunny.class,
            (Render) new RenderEasterBunny(new ModelEasterBunny(0.55f), 0.5f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            CaterKiller.class,
            (Render) new RenderCaterKiller(new ModelCaterKiller(0.22f), 1.0f, 1.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(Leon.class, (Render) new RenderLeon(new ModelLeon(0.22f), 1.0f, 1.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Hammerhead.class,
            (Render) new RenderHammerhead(new ModelHammerhead(0.33f), 1.0f, 2.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            RubberDucky.class,
            (Render) new RenderRubberDucky(new ModelRubberDucky(1.0f), 0.15f, 0.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrinceTeen.class,
            (Render) new RenderThePrinceTeen(new ModelThePrinceTeen(0.65f), 1.0f, 1.25f));
        RenderingRegistry
            .registerEntityRenderingHandler(BandP.class, (Render) new RenderBandP(new ModelBandP(0.4f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            RockBase.class,
            (Render) new RenderRockBase(new ModelRockBase(1.0f), 0.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            PurplePower.class,
            (Render) new RenderPurplePower(new ModelPurplePower(1.0f), 0.3f, 2.75f));
        RenderingRegistry.registerEntityRenderingHandler(
            Brutalfly.class,
            (Render) new RenderBrutalfly(new ModelBrutalfly(0.2f), 0.75f, 9.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Nastysaurus.class,
            (Render) new RenderNastysaurus(new ModelNastysaurus(0.65f), 1.0f, 1.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            Pointysaurus.class,
            (Render) new RenderPointysaurus(new ModelPointysaurus(1.0f), 1.0f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            Cricket.class,
            (Render) new RenderCricket(new ModelCricket(2.5f), 0.15f, 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrincess.class,
            (Render) new RenderThePrincess(new ModelThePrincess(0.65f), 0.7f, 0.7f));
        RenderingRegistry
            .registerEntityRenderingHandler(Frog.class, (Render) new RenderFrog(new ModelFrog(1.0f), 0.35f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            ThePrinceAdult.class,
            (Render) new RenderThePrinceAdult(new ModelThePrinceAdult(0.65f), 1.2f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpiderRobot.class,
            (Render) new RenderSpiderRobot(new ModelSpiderRobot(1.0f), 0.99f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            SpiderDriver.class,
            (Render) new RenderSpiderDriver(new ModelSpider(), 0.5f));
        RenderingRegistry.registerEntityRenderingHandler(
            GiantRobot.class,
            (Render) new RenderGiantRobot(new ModelGiantRobot(0.25f), 0.99f, 1.0f));
        RenderingRegistry.registerEntityRenderingHandler(
            AntRobot.class,
            (Render) new RenderAntRobot(new ModelAntRobot(1.0f), 0.99f, 1.0f));
        RenderingRegistry
            .registerEntityRenderingHandler(Crab.class, (Render) new RenderCrab(new ModelCrab(1.0f), 0.99f, 1.0f));
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyBertha, (IItemRenderer) new RenderBertha());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MySlice, (IItemRenderer) new RenderSlice());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyRoyal, (IItemRenderer) new RenderRoyal());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MySquidZooka, (IItemRenderer) new RenderSquidZooka());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyHammy, (IItemRenderer) new RenderHammy());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyBattleAxe, (IItemRenderer) new RenderBattleAxe());
        MinecraftForgeClient.registerItemRenderer(OreSpawnMain.MyChainsaw, (IItemRenderer) new RenderChainsaw());
        MinecraftForgeClient
            .registerItemRenderer(OreSpawnMain.MyQueenBattleAxe, (IItemRenderer) new RenderQueenBattleAxe());
    }

    @Override
    public void registerSoundThings() {
        MinecraftForge.EVENT_BUS.register((Object) new OreSpawnSounds());
    }

    @Override
    public void registerKeyboardInput() {
        final KeyHandler k = new KeyHandler();
        FMLCommonHandler.instance()
            .bus()
            .register((Object) k);
        OreSpawnMain.MyKeyhandler = k;
    }

    @Override
    public void registerNetworkStuff() {
        super.registerNetworkStuff();
        FMLCommonHandler.instance()
            .bus()
            .register((Object) new RiderControl(this.getNetwork()));
    }

    @Override
    public int setArmorPrefix(final String string) {
        return RenderingRegistry.addNewArmourRendererPrefix(string);
    }
}
