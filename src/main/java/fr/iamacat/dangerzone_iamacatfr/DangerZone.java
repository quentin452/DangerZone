package fr.iamacat.dangerzone_iamacatfr;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.config.DangerZoneConfig;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;
import fr.iamacat.dangerzone_iamacatfr.init.*;
import fr.iamacat.dangerzone_iamacatfr.spawnable.CritterCage;
import fr.iamacat.dangerzone_iamacatfr.network.ISidedProxy;
import fr.iamacat.dangerzone_iamacatfr.network.PZPacketHandler;
import fr.iamacat.dangerzone_iamacatfr.util.KeyHandler;
import fr.iamacat.dangerzone_iamacatfr.util.MyUtils;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions.ChunkOreGenerator;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions.OreSpawnWorld;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeons.BasiliskMaze;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeons.GenericDungeon;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeons.RubyBirdDungeon;
import fr.iamacat.dangerzone_iamacatfr.worldgen.trees.Trees;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import java.io.File;
import java.util.List;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = Tags.MCVERSION)
public class DangerZone {
    public static int UltimateSwordMagic;
    public static KeyHandler MyKeyhandler;

    public static int flyup_keystate;
    public static int FullPowerKingEnable;
    public static int IslandSizeFactor;
    public static int NightmareSize;
    public OreSpawnWorld OreSpawnGen;
    public static Item CageEmpty;
    public static Item CagedSpider;
    public static Item CagedBat;
    public static Item CagedCow;
    public static Item CagedPig;
    public static Item CagedSquid;
    public static Item CagedChicken;
    public static int IslandSpeedFactor;
    public static Item CagedCreeper;
    public static Item CagedSkeleton;
    public static Item CagedZombie;
    public static Item CagedSlime;
    public static Item CagedGhast;
    public static Item CagedZombiePigman;
    public static Item CagedEnderman;
    public static Item CagedCaveSpider;
    public static Item CagedSilverfish;
    public static Item CagedMagmaCube;
    public static Item CagedWitch;
    public static int RatPlayerFriendly;
    public static int RatPetFriendly;
    public static Item CagedSheep;
    public static Item CagedWolf;
    public static Item CagedMooshroom;
    public static Item CagedOcelot;
    public static Item CagedBlaze;
    public static Item CagedGirlfriend;
    public static Item CagedBoyfriend;
    public static Item CagedWitherSkeleton;
    public static Item CagedEnderDragon;
    public static Item CagedSnowGolem;
    public static Item CagedIronGolem;
    public static Item CagedWitherBoss;
    public static Item CagedRedCow;
    public static Item CagedCrystalCow;
    public static Item CagedVillager;
    public static Item CagedGoldCow;
    public static Item CagedEnchantedCow;
    public static Item CagedMOTHRA;
    public static Item CagedAlo;
    public static Item CagedCryo;
    public static Item CagedCama;
    public static Item CagedVelo;
    public static Item CagedHydro;
    public static Item CagedBasil;
    public static Item CagedDragonfly;
    public static Item CagedEmperorScorpion;
    public static Item CagedScorpion;
    public static Item CagedCaveFisher;
    public static Item CagedSpyro;
    public static Item CagedBaryonyx;
    public static Item CagedGammaMetroid;
    public static Item CagedCockateil;
    public static Item CagedKyuubi;
    public static Item CagedAlien;
    public static Item CagedAttackSquid;
    public static Item CagedWaterDragon;
    public static Item CagedCephadrome;
    public static Item CagedDragon;
    public static Item CagedKraken;
    public static Item CagedLizard;
    public static Item CagedBee;
    public static Item CagedHorse;
    public static Item CagedFirefly;
    public static Item CagedChipmunk;
    public static Item CagedGazelle;
    public static Item CagedOstrich;
    public static Item CagedTrooper;
    public static Item CagedSpit;
    public static Item CagedStink;
    public static Item CagedCreepingHorror;
    public static Item CagedTerribleTerror;
    public static Item CagedCliffRacer;
    public static Item CagedTriffid;
    public static Item CagedPitchBlack;
    public static Item CagedLurkingTerror;
    public static Item CagedSmallWorm;
    public static Item CagedMediumWorm;
    public static Item CagedLargeWorm;
    public static Item CagedCassowary;
    public static Item CagedCloudShark;
    public static Item CagedGoldFish;
    public static Item CagedLeafMonster;
    public static Item CagedEnderKnight;
    public static Item CagedEnderReaper;
    public static Item CagedBeaver;
    public static Item CagedUrchin;
    public static Item CagedFlounder;
    public static Item CagedSkate;
    public static Item CagedRotator;
    public static Item CagedPeacock;
    public static Item CagedFairy;
    public static Item CagedDungeonBeast;
    public static Item CagedVortex;
    public static Item CagedRat;
    public static Item CagedWhale;
    public static Item CagedIrukandji;
    public static Item CagedTRex;
    public static Item CagedHercules;
    public static Item CagedMantis;
    public static Item CagedStinky;
    public static Item CagedEasterBunny;
    public static Item CagedCaterKiller;
    public static Item CagedMolenoid;
    public static Item CagedSeaMonster;
    public static Item CagedSeaViper;
    public static Item CagedLeon;
    public static Item CagedHammerhead;
    public static Item CagedRubberDucky;
    public static Item CagedCriminal;
    public static Item CagedBrutalfly;
    public static Item CagedNastysaurus;
    public static Item CagedPointysaurus;
    public static Item CagedCricket;
    public static Item CagedFrog;
    public static Item CagedSpiderDriver;
    public static Item CagedCrab;
    public static int BaseItemID;

    public static int FastGraphicsLeaves; // todo maybe should remove this
    public static Trees OreSpawnTrees;
    public static BasiliskMaze BMaze;
    public static RubyBirdDungeon RubyDungeon;
    public static GenericDungeon MyDungeon;
    public static MyUtils OreSpawnUtils;
    public static ChunkOreGenerator Chunker;
    public static int current_dimension;
    private File BaseDir;
    private static DangerZoneConfig Config;
    @Mod.Instance(Tags.MODID)
    public static DangerZone instance;
    @SideOnly(Side.CLIENT)
    public static InputConfusedMovement confusedMovementInput;

    @SidedProxy(clientSide = Tags.CLIENTPROXY, serverSide = Tags.SERVERPROXY)
    public static ISidedProxy packetProxy;
    public static PZPacketHandler packetHandler;

    public static Configuration config;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        BaseDir = new File(event.getModConfigurationDirectory(), Tags.MODID);
        Config = new DangerZoneConfig(event.getSuggestedConfigurationFile());

        if (!BaseDir.exists()) BaseDir.mkdir();

        packetProxy.registerRenders();
        EntityInitDangerZone.preInit(event);
        SpawnEggInitDangerZone.preInit(event);
        ItemInitDangerZone.init();
        ItemInitDangerZone.register();
        BlockInitDangerZone.init();
        BlockInitDangerZone.register();
        TileEntityInitDangerZone.init();
        TileEntityInitDangerZone.register();
        RecipeHandler.preInit(event);
        DimensionInitDangerZone.preInit(event);
        EntitySpawningHandler.preInit(event);
        initializeCagesAndEggs();
        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandlerDangerZone());
    }
    public DangerZone() {
        this.OreSpawnGen = new OreSpawnWorld();
    }
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        OreSpawnTrees = new Trees();
        BMaze = new BasiliskMaze();
        RubyDungeon = new RubyBirdDungeon();
        MyDungeon = new GenericDungeon();
        Chunker = new ChunkOreGenerator();
        OreSpawnUtils = new MyUtils();

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(packetProxy);
    }


    public void initializeCagesAndEggs() {
        CageEmpty = new CritterCage(160).setUnlocalizedName("cageempty").setTextureName("cageempty");
        CagedSpider = new CritterCage(161).setUnlocalizedName("cagespider").setTextureName("cagespider");
        CagedBat = new CritterCage(162).setUnlocalizedName("cagebat").setTextureName("cagebat");
        CagedCow = new CritterCage(163).setUnlocalizedName("cagecow").setTextureName("cagecow");
        CagedPig = new CritterCage(164).setUnlocalizedName("cagepig").setTextureName("cagepig");
        CagedSquid = new CritterCage(165).setUnlocalizedName("cagesquid").setTextureName("cagesquid");
        CagedChicken = new CritterCage( 166).setUnlocalizedName("cagechicken").setTextureName("cagechicken");
        CagedCreeper = new CritterCage( 167).setUnlocalizedName("cagecreeper").setTextureName("cagecreeper");
        CagedSkeleton = new CritterCage( 168).setUnlocalizedName("cageskeleton").setTextureName("cageskeleton");
        CagedZombie = new CritterCage( 169).setUnlocalizedName("cagezombie").setTextureName("cagezombie");
        CagedSlime = new CritterCage( 170).setUnlocalizedName("cageslime").setTextureName("cageslime");
        CagedGhast = new CritterCage( 171).setUnlocalizedName("cageghast").setTextureName("cageghast");
        CagedZombiePigman = new CritterCage( 172).setUnlocalizedName("cagezombiepigman").setTextureName("cagezombiepigman");
        CagedEnderman = new CritterCage(173).setUnlocalizedName("cageenderman").setTextureName("cageenderman");
        CagedCaveSpider = new CritterCage( 174).setUnlocalizedName("cagecavespider").setTextureName("cagecavespider");
        CagedSilverfish = new CritterCage( 175).setUnlocalizedName("cagesilverfish").setTextureName("cagesilverfish");
        CagedMagmaCube = new CritterCage( 176).setUnlocalizedName("cagemagmacube").setTextureName("cagemagmacube");
        CagedWitch = new CritterCage(177).setUnlocalizedName("cagewitch").setTextureName("cagewitch");
        CagedSheep = new CritterCage( 178).setUnlocalizedName("cagesheep").setTextureName("cagesheep");
        CagedWolf = new CritterCage(179).setUnlocalizedName("cagewolf").setTextureName("cagewolf");
        CagedMooshroom = new CritterCage( 180).setUnlocalizedName("cagemooshroom").setTextureName("cagemooshroom");
        CagedOcelot = new CritterCage(181).setUnlocalizedName("cageocelot").setTextureName("cageocelot");
        CagedBlaze = new CritterCage(182).setUnlocalizedName("cageblaze").setTextureName("cageblaze");
        CagedGirlfriend = new CritterCage( 183).setUnlocalizedName("cagegirlfriend").setTextureName("cagegirlfriend");
        CagedBoyfriend = new CritterCage(215).setUnlocalizedName("cageboyfriend").setTextureName("cageboyfriend");
        CagedWitherSkeleton = new CritterCage( 188).setUnlocalizedName("cagewitherskeleton").setTextureName("cagewitherskeleton");
        CagedEnderDragon = new CritterCage(184).setUnlocalizedName("cageenderdragon").setTextureName("cageenderdragon");
        CagedSnowGolem = new CritterCage(185).setUnlocalizedName("cagesnowgolem").setTextureName("cagesnowgolem");
        CagedIronGolem = new CritterCage( 186).setUnlocalizedName("cageirongolem").setTextureName("cageirongolem");
        CagedWitherBoss = new CritterCage( 187).setUnlocalizedName("cagewitherboss").setTextureName("cagewitherboss");
        CagedRedCow = new CritterCage( 189).setUnlocalizedName("cageredcow").setTextureName("cageredcow");
        CagedGoldCow = new CritterCage( 190).setUnlocalizedName("cagegoldcow").setTextureName("cagegoldcow");
        CagedEnchantedCow = new CritterCage( 191).setUnlocalizedName("cageenchantedcow").setTextureName("cageenchantedcow");
        CagedMOTHRA = new CritterCage(208).setUnlocalizedName("cageMOTHRA").setTextureName("cageMOTHRA");
        CagedAlo = new CritterCage(209).setUnlocalizedName("cagealosaurus").setTextureName("cagealosaurus");
        CagedCryo = new CritterCage( 210).setUnlocalizedName("cagecryolophosaurus").setTextureName("cagecryolophosaurus");
        CagedCama = new CritterCage( 211).setUnlocalizedName("cagecamarasaurus").setTextureName("cagecamarasaurus");
        CagedVelo = new CritterCage(212).setUnlocalizedName("cagevelocityraptor").setTextureName("cagevelocityraptor");
        CagedHydro = new CritterCage(213).setUnlocalizedName("cagehydrolisc").setTextureName("cagehydrolisc");
        CagedBasil = new CritterCage( 214).setUnlocalizedName("cagebasilisc").setTextureName("cagebasilisc");
        CagedDragonfly = new CritterCage( 220).setUnlocalizedName("cagedragonfly").setTextureName("cagedragonfly");
        CagedEmperorScorpion = new CritterCage( 222).setUnlocalizedName("cageemperorscorpion").setTextureName("cageemperorscorpion");
        CagedScorpion = new CritterCage(224).setUnlocalizedName("cagescorpion").setTextureName("cagescorpion");
        CagedCaveFisher = new CritterCage( 226).setUnlocalizedName("cagecavefisher").setTextureName("cagecavefisher");
        CagedSpyro = new CritterCage( 228).setUnlocalizedName("cagespyro").setTextureName("cagespyro");
        CagedBaryonyx = new CritterCage( 230).setUnlocalizedName("cagebaryonyx").setTextureName("cagebaryonyx");
        CagedGammaMetroid = new CritterCage( 232).setUnlocalizedName("cagegammametroid").setTextureName("cagegammametroid");
        CagedCockateil = new CritterCage( 234).setUnlocalizedName("cagecockateil").setTextureName("cagecockateil");
        CagedKyuubi = new CritterCage( 236).setUnlocalizedName("cagekyuubi").setTextureName("cagekyuubi");
        CagedAlien = new CritterCage( 238).setUnlocalizedName("cagealien").setTextureName("cagealien");
        CagedAttackSquid = new CritterCage( 240).setUnlocalizedName("cageattacksquid").setTextureName("cageattacksquid");
        CagedWaterDragon = new CritterCage( 242).setUnlocalizedName("cagewaterdragon").setTextureName("cagewaterdragon");
        CagedCephadrome = new CritterCage( 248).setUnlocalizedName("cagecephadrome").setTextureName("cagecephadrome");
        CagedKraken = new CritterCage( 244).setUnlocalizedName("cagekraken").setTextureName("cagekraken");
        CagedLizard = new CritterCage( 246).setUnlocalizedName("cagelizard").setTextureName("cagelizard");
        CagedDragon = new CritterCage( 250).setUnlocalizedName("cagedragon").setTextureName("cagedragon");
        CagedBee = new CritterCage(252).setUnlocalizedName("cagebee").setTextureName("cagebee");
        CagedHorse = new CritterCage(253).setUnlocalizedName("cagehorse").setTextureName("cagehorse");
        CagedFirefly = new CritterCage( 255).setUnlocalizedName("cagefirefly").setTextureName("cagefirefly");
        CagedChipmunk = new CritterCage( 256).setUnlocalizedName("cagechipmunk").setTextureName("cagechipmunk");
        CagedGazelle = new CritterCage( 257).setUnlocalizedName("cagegazelle").setTextureName("cagegazelle");
        CagedOstrich = new CritterCage(258).setUnlocalizedName("cageostrich").setTextureName("cageostrich");
        CagedTrooper = new CritterCage( 259).setUnlocalizedName("cagetrooper").setTextureName("cagetrooper");
        CagedSpit = new CritterCage( 260).setUnlocalizedName("cagespit").setTextureName("cagespit");
        CagedStink = new CritterCage( 261).setUnlocalizedName("cagestink").setTextureName("cagestink");
        CagedCreepingHorror = new CritterCage( 268).setUnlocalizedName("cagecreepinghorror").setTextureName("cagecreepinghorror");
        CagedTerribleTerror = new CritterCage( 269).setUnlocalizedName("cageterribleterror").setTextureName("cageterribleterror");
        CagedCliffRacer = new CritterCage( 270).setUnlocalizedName("cagecliffracer").setTextureName("cagecliffracer");
        CagedTriffid = new CritterCage( 271).setUnlocalizedName("cagetriffid").setTextureName("cagetriffid");
        CagedPitchBlack = new CritterCage(272).setUnlocalizedName("cagenightmare").setTextureName("cagenightmare");
        CagedLurkingTerror = new CritterCage( 273).setUnlocalizedName("cagelurkingterror").setTextureName("cagelurkingterror");
        CagedSmallWorm = new CritterCage(281).setUnlocalizedName("cagesmallworm").setTextureName("cagesmallworm");
        CagedMediumWorm = new CritterCage( 282).setUnlocalizedName("cagemediumworm").setTextureName("cagemediumworm");
        CagedLargeWorm = new CritterCage( 283).setUnlocalizedName("cagelargeworm").setTextureName("cagelargeworm");
        CagedCassowary = new CritterCage(284).setUnlocalizedName("cagecassowary").setTextureName("cagecassowary");
        CagedCloudShark = new CritterCage( 285).setUnlocalizedName("cagecloudshark").setTextureName("cagecloudshark");
        CagedGoldFish = new CritterCage(286).setUnlocalizedName("cagegoldfish").setTextureName("cagegoldfish");
        CagedLeafMonster = new CritterCage(287).setUnlocalizedName("cageleafmonster").setTextureName("cageleafmonster");
        CagedEnderKnight = new CritterCage(296).setUnlocalizedName("cageenderknight").setTextureName("cageenderknight");
        CagedEnderReaper = new CritterCage(297).setUnlocalizedName("cageenderreaper").setTextureName("cageenderreaper");
        CagedBeaver = new CritterCage(300).setUnlocalizedName("cagebeaver").setTextureName("cagebeaver");
        CagedUrchin = new CritterCage(323).setUnlocalizedName("cageurchin").setTextureName("cageurchin");
        CagedFlounder = new CritterCage( 319).setUnlocalizedName("cageflounder").setTextureName("cageflounder");
        CagedSkate = new CritterCage(322).setUnlocalizedName("cageskate").setTextureName("cageskate");
        CagedRotator = new CritterCage(313).setUnlocalizedName("cagerotator").setTextureName("cagerotator");
        CagedPeacock = new CritterCage( 315).setUnlocalizedName("cagepeacock").setTextureName("cagepeacock");
        CagedFairy = new CritterCage(316).setUnlocalizedName("cagefairy").setTextureName("cagefairy");
        CagedDungeonBeast = new CritterCage(317).setUnlocalizedName("cagedungeonbeast").setTextureName("cagedungeonbeast");
        CagedVortex = new CritterCage( 314).setUnlocalizedName("cagevortex").setTextureName("cagevortex");
        CagedRat = new CritterCage(318).setUnlocalizedName("cagerat").setTextureName("cagerat");
        CagedWhale = new CritterCage(320).setUnlocalizedName("cagewhale").setTextureName("cagewhale");
        CagedIrukandji = new CritterCage( 321).setUnlocalizedName("cageirukandji").setTextureName("cageirukandji");
        CagedTRex = new CritterCage( 345).setUnlocalizedName("cagetrex").setTextureName("cagetrex");
        CagedHercules = new CritterCage(  346).setUnlocalizedName("cagehercules").setTextureName("cagehercules");
        CagedMantis = new CritterCage( 347).setUnlocalizedName("cagemantis").setTextureName("cagemantis");
        CagedStinky = new CritterCage( 348).setUnlocalizedName("cagestinky").setTextureName("cagestinky");
        CagedEasterBunny = new CritterCage( 150).setUnlocalizedName("cageeasterbunny").setTextureName("cageeasterbunny");
        CagedCaterKiller = new CritterCage(151).setUnlocalizedName("cagecaterkiller").setTextureName("cagecaterkiller");
        CagedMolenoid = new CritterCage(152).setUnlocalizedName("cagemolenoid").setTextureName("cagemolenoid");
        CagedSeaMonster = new CritterCage(153).setUnlocalizedName("cageseamonster").setTextureName("cageseamonster");
        CagedSeaViper = new CritterCage(154).setUnlocalizedName("cageseaviper").setTextureName("cageseaviper");
        CagedLeon = new CritterCage( 357).setUnlocalizedName("cageleon").setTextureName("cageleon");
        CagedHammerhead = new CritterCage( 359).setUnlocalizedName("cagehammerhead").setTextureName("cagehammerhead");
        CagedRubberDucky = new CritterCage(361).setUnlocalizedName("cagerubberducky").setTextureName("cagerubberducky");
        CagedCrystalCow = new CritterCage(216).setUnlocalizedName("cagecrystalcow").setTextureName("cagecrystalcow");
        CagedVillager = new CritterCage(217).setUnlocalizedName("cagevillager").setTextureName("cagevillager");
        CagedCriminal = new CritterCage( 218).setUnlocalizedName("cagecriminal").setTextureName("cagecriminal");
        CagedBrutalfly = new CritterCage( 373).setUnlocalizedName("cagebrutalfly").setTextureName("cagebrutalfly");
        CagedNastysaurus = new CritterCage(374).setUnlocalizedName("cagenastysaurus").setTextureName("cagenastysaurus");
        CagedPointysaurus = new CritterCage( 375).setUnlocalizedName("cagepointysaurus").setTextureName("cagepointysaurus");
        CagedCricket = new CritterCage( 376).setUnlocalizedName("cagecricket").setTextureName("cagecricket");
        CagedFrog = new CritterCage( 377).setUnlocalizedName("cagefrog").setTextureName("cagefrog");
        CagedSpiderDriver = new CritterCage( 382).setUnlocalizedName("cagespiderdriver").setTextureName("cagespiderdriver");
        CagedCrab = new CritterCage( 384).setUnlocalizedName("cagecrab").setTextureName("cagecrab");
    }

    static {
        BaseItemID = 9000;
        flyup_keystate = 0;
        IslandSpeedFactor = 2;
        RatPlayerFriendly = 0;
        RatPetFriendly = 0;
        IslandSizeFactor = 2;
        FullPowerKingEnable = 0;
        MyKeyhandler = null;
        UltimateSwordMagic = 5;
        OreSpawnTrees = null;
    }

    public static Entity getPointedAtEntity(final World world, final EntityPlayer player, final double dist) {
        Entity pointedAt = null;
        if (player != null && world != null) {
            final double d0 = dist;
            final double d2 = dist;
            final Vec3 vec3 = player.getPosition(1.0f);
            final Vec3 vec4 = player.getLook(1.0f);
            final Vec3 vec5 = vec3.addVector(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0);
            pointedAt = null;
            final float f1 = 1.0f;
            final List list = world.getEntitiesWithinAABBExcludingEntity(
                player,
                player.boundingBox.addCoord(vec4.xCoord * d0, vec4.yCoord * d0, vec4.zCoord * d0)
                    .expand(f1, f1, f1));
            double d3 = d2;
            for (int i = 0; i < list.size(); ++i) {
                final Entity entity = (Entity) list.get(i);
                if (entity.canBeCollidedWith()) {
                    final float f2 = entity.getCollisionBorderSize();
                    final AxisAlignedBB axisalignedbb = entity.boundingBox.expand(f2, f2, f2);
                    final MovingObjectPosition movingobjectposition = axisalignedbb.calculateIntercept(vec3, vec5);
                    if (axisalignedbb.isVecInside(vec3)) {
                        if (0.0 < d3 || d3 == 0.0) {
                            pointedAt = entity;
                            d3 = 0.0;
                        }
                    } else if (movingobjectposition != null) {
                        final double d4 = vec3.distanceTo(movingobjectposition.hitVec);
                        if (d4 < d3 || d3 == 0.0) {
                            if (entity == player.ridingEntity && !entity.canRiderInteract()) {
                                if (d3 == 0.0) {
                                    pointedAt = entity;
                                }
                            } else {
                                pointedAt = entity;
                                d3 = d4;
                            }
                        }
                    }
                }
            }
        }
        return pointedAt;
    }

    public static boolean setBlockFast(final World world, final int par1, final int par2, final int par3,
                                       final Block par4, final int par5, final int par6) {
        if (par1 < -30000000 || par3 < -30000000 || par1 >= 30000000 || par3 >= 30000000) {
            return false;
        }
        if (par2 < 0) {
            return false;
        }
        if (par2 >= 256) {
            return false;
        }
        final Chunk chunk = world.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
        Block k1 = Blocks.air;
        if ((par6 & 0x1) != 0x0) {
            k1 = chunk.getBlock(par1 & 0xF, par2, par3 & 0xF);
        }
        final boolean flag = setBlockIDWithMetadataFast(chunk, par1 & 0xF, par2, par3 & 0xF, par4, par5);
        if (flag) {
            if ((par6 & 0x2) != 0x0 && (!world.isRemote || (par6 & 0x4) == 0x0)) {
                world.markBlockForUpdate(par1, par2, par3);
            }
            if (!world.isRemote && (par6 & 0x1) != 0x0) {
                world.notifyBlockChange(par1, par2, par3, k1);
            }
        }
        return flag;
    }

    public static boolean setBlockSuperFast(final World world, final int par1, final int par2, final int par3,
                                            final Block par4, final int par5, final int par6, final Chunk refChunk) {
        if (par1 < -30000000 || par3 < -30000000 || par1 >= 30000000 || par3 >= 30000000) {
            return false;
        }
        if (par2 < 0) {
            return false;
        }
        if (par2 >= 255) {
            return false;
        }
        final Chunk chunk = world.getChunkFromChunkCoords(par1 >> 4, par3 >> 4);
        boolean flag = true;
        if (chunk != refChunk) {
            Block k1 = Blocks.air;
            if ((par6 & 0x1) != 0x0) {
                k1 = chunk.getBlock(par1 & 0xF, par2, par3 & 0xF);
            }
            flag = setBlockIDWithMetadataFast(chunk, par1 & 0xF, par2, par3 & 0xF, par4, par5);
            if (flag) {
                if ((par6 & 0x2) != 0x0 && (!world.isRemote || (par6 & 0x4) == 0x0)) {
                    world.markBlockForUpdate(par1, par2, par3);
                }
                if (!world.isRemote && (par6 & 0x1) != 0x0) {
                    world.notifyBlockChange(par1, par2, par3, k1);
                }
            }
        } else {
            setBlockIDWithMetadataFast(chunk, par1 & 0xF, par2, par3 & 0xF, par4, par5);
        }
        return flag;
    }

    public static boolean setBlockIDWithMetadataFast(final Chunk chunk, final int par1, final int par2, final int par3,
                                                     final Block par4, final int par5) {
        if (par1 < -30000000 || par3 < -30000000 || par1 >= 30000000 || par3 >= 30000000) {
            return false;
        }
        if (par2 < 0 || par2 > 255) {
            return false;
        }
        final ExtendedBlockStorage[] mystorage = chunk.getBlockStorageArray();
        ExtendedBlockStorage extendedblockstorage = mystorage[par2 >> 4];
        if (extendedblockstorage == null) {
            if (par4 == Blocks.air) {
                return false;
            }
            final ExtendedBlockStorage[] array = mystorage;
            final int n = par2 >> 4;
            final ExtendedBlockStorage extendedBlockStorage = new ExtendedBlockStorage(
                par2 >> 4 << 4,
                !chunk.worldObj.provider.hasNoSky);
            array[n] = extendedBlockStorage;
            extendedblockstorage = extendedBlockStorage;
            chunk.setStorageArrays(mystorage);
        }
        extendedblockstorage.func_150818_a(par1, par2 & 0xF, par3, par4);
        extendedblockstorage.setExtBlockMetadata(par1, par2 & 0xF, par3, par5);
        return true;
    }

    public static Block getBlockIDInChunk(final Chunk chunk, final int par1, final int par2, final int par3) {
        if (par1 < -30000000 || par3 < -30000000 || par1 >= 30000000 || par3 >= 30000000) {
            return Blocks.air;
        }
        if (par1 >> 4 != chunk.xPosition) {
            return Blocks.air;
        }
        if (par3 >> 4 != chunk.zPosition) {
            return Blocks.air;
        }
        if (par2 < 0 || par2 > 255) {
            return Blocks.air;
        }
        return chunk.getBlock(par1 & 0xF, par2, par3 & 0xF);
    }

    public static boolean setBlockIDWithMetadataInChunk(final Chunk chunk, int par1, final int par2, int par3,
                                                        final Block par4, final int par5) {
        if (par1 < -30000000 || par3 < -30000000 || par1 >= 30000000 || par3 >= 30000000) {
            return false;
        }
        if (par1 >> 4 != chunk.xPosition) {
            return false;
        }
        if (par3 >> 4 != chunk.zPosition) {
            return false;
        }
        if (par2 < 0 || par2 > 255) {
            return false;
        }
        final ExtendedBlockStorage[] mystorage = chunk.getBlockStorageArray();
        ExtendedBlockStorage extendedblockstorage = mystorage[par2 >> 4];
        par1 &= 0xF;
        par3 &= 0xF;
        if (extendedblockstorage == null) {
            if (par4 == Blocks.air || par4 == null) {
                return false;
            }
            final int n = par2 >> 4;
            final ExtendedBlockStorage extendedBlockStorage = new ExtendedBlockStorage(
                par2 >> 4 << 4,
                !chunk.worldObj.provider.hasNoSky);
            mystorage[n] = extendedBlockStorage;
            extendedblockstorage = extendedBlockStorage;
            chunk.setStorageArrays(mystorage);
        }
        extendedblockstorage.func_150818_a(par1, par2 & 0xF, par3, par4);
        extendedblockstorage.setExtBlockMetadata(par1, par2 & 0xF, par3, par5);
        return true;
    }
}
