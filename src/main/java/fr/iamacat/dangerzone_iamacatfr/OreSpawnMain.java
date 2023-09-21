package fr.iamacat.dangerzone_iamacatfr;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.blocks.*;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.*;
import fr.iamacat.dangerzone_iamacatfr.gui.OreSpawnGUIHandler;
import fr.iamacat.dangerzone_iamacatfr.init.*;
import fr.iamacat.dangerzone_iamacatfr.items.CrystalWorkbench;
import fr.iamacat.dangerzone_iamacatfr.items.ItemIrukandjiArrow;
import fr.iamacat.dangerzone_iamacatfr.items.MantisClaw;
import fr.iamacat.dangerzone_iamacatfr.items.SunspotUrchin;
import fr.iamacat.dangerzone_iamacatfr.items.*;
import fr.iamacat.dangerzone_iamacatfr.network.ISidedProxy;
import fr.iamacat.dangerzone_iamacatfr.network.PZPacketHandler;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.TileEntityCrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.util.*;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dimensions.*;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon.BasiliskMaze;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon.GenericDungeon;
import fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon.RubyBirdDungeon;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.util.EnumHelper;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

@Mod(modid = Tags.MODID, version = Tags.VERSION, name = Tags.MODNAME, acceptedMinecraftVersions = Tags.MCVERSION)
public class OreSpawnMain {

    private File BaseDir;
    @Mod.Instance(Tags.MODID)
    public static OreSpawnMain instance;
    @SideOnly(Side.CLIENT)
    public static InputConfusedMovement confusedMovementInput;

    @SidedProxy(clientSide = Tags.CLIENTPROXY, serverSide = Tags.SERVERPROXY)
    public static ISidedProxy packetproxy;
    public static PZPacketHandler packetHandler;

    public static Configuration config;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(packetproxy);
    }
        public static KeyHandler MyKeyhandler;
        public static int flyup_keystate;
        public static int BaseBlockID;
        public static int BaseItemID;
        public static int BaseBiomeID;
        public static int BaseDimensionID;
        public static int BiomeUtopiaID;
        public static int BiomeIslandsID;
        public static int BiomeCrystalID;
        public static int BiomeVillageID;
        public static int BiomeChaosID;
        public static int DimensionID;
        public static int DimensionID2;
        public static int DimensionID3;
        public static int DimensionID4;
        public static int DimensionID5;
        public static int DimensionID6;
        public static int godzilla_has_spawned;
        public static int current_dimension;
        public static int valentines_day;
        public static int easter_day;
        public static int ultimate_sword_pvp;
        public static int big_bertha_pvp;
        public static int bro_mode;
        public static int enableduplicatortree;
        public static int RoyalGlideEnable;
        public static int DragonflyHorseFriendly;
        public static int PlayNicely;
        public static int MinersDreamExpensive;
        public static int DisableOverworldDungeons;
        public static int FullPowerKingEnable;
        public static ArmorStats Amethyst_armorstats;
        public static ArmorStats Emerald_armorstats;
        public static ArmorStats Experience_armorstats;
        public static ArmorStats MothScale_armorstats;
        public static ArmorStats LavaEel_armorstats;
        public static ArmorStats Ultimate_armorstats;
        public static ArmorStats Pink_armorstats;
        public static ArmorStats TigersEye_armorstats;
        public static ArmorStats Peacock_armorstats;
        public static ArmorStats Mobzilla_armorstats;
        public static ArmorStats Ruby_armorstats;
        public static ArmorStats Royal_armorstats;
        public static ArmorStats Lapis_armorstats;
        public static ArmorStats Queen_armorstats;
        public static int AllMobsDisable;
        public static int MosquitoEnable;
        public static int RockEnable;
        public static int GhostEnable;
        public static int GhostSkellyEnable;
        public static int SpiderDriverEnable;
        public static int JefferyEnable;
        public static int MothraEnable;
        public static int BrutalflyEnable;
        public static int NastysaurusEnable;
        public static int PointysaurusEnable;
        public static int CricketEnable;
        public static int FrogEnable;
        public static int MothraPeaceful;
        public static int BlackAntEnable;
        public static int RedAntEnable;
        public static int TermiteEnable;
        public static int UnstableAntEnable;
        public static int RainbowAntEnable;
        public static int AlosaurusEnable;
        public static int HammerheadEnable;
        public static int LeonEnable;
        public static int CaterKillerEnable;
        public static int MolenoidEnable;
        public static int TRexEnable;
        public static int CriminalEnable;
        public static int CryolophosaurusEnable;
        public static int RatEnable;
        public static int RatPlayerFriendly;
        public static int RatPetFriendly;
        public static int UrchinEnable;
        public static int CamarasaurusEnable;
        public static int ChipmunkEnable;
        public static int OstrichEnable;
        public static int GazelleEnable;
        public static int VelocityRaptorEnable;
        public static int HydroliscEnable;
        public static int SpyroEnable;
        public static int BaryonyxEnable;
        public static int CockateilEnable;
        public static int CassowaryEnable;
        public static int EasterBunnyEnable;
        public static int PeacockEnable;
        public static int KyuubiEnable;
        public static int CephadromeEnable;
        public static int DragonEnable;
        public static int GammaMetroidEnable;
        public static int BasiliskEnable;
        public static int DragonflyEnable;
        public static int EmperorScorpionEnable;
        public static int TrooperBugEnable;
        public static int SpitBugEnable;
        public static int StinkBugEnable;
        public static int ScorpionEnable;
        public static int CaveFisherEnable;
        public static int AlienEnable;
        public static int WaterDragonEnable;
        public static int SeaMonsterEnable;
        public static int SeaViperEnable;
        public static int AttackSquidEnable;
        public static int GodzillaEnable;
        public static int LessOre;
        public static int LessLag;
        public static int Robot1Enable;
        public static int Robot2Enable;
        public static int Robot3Enable;
        public static int Robot4Enable;
        public static int Robot5Enable;
        public static int RotatorEnable;
        public static int VortexEnable;
        public static int DungeonBeastEnable;
        public static int KrakenEnable;
        public static int LizardEnable;
        public static int RubberDuckyEnable;
        public static int GirlfriendEnable;
        public static int BoyfriendEnable;
        public static int FireflyEnable;
        public static int FairyEnable;
        public static int BeeEnable;
        public static int TheKingEnable;
        public static int TheQueenEnable;
        public static int ThePrinceEnable;
        public static int ThePrincessEnable;
        public static int MantisEnable;
        public static int StinkyEnable;
        public static int HerculesBeetleEnable;
        public static int CowEnable;
        public static int ButterflyEnable;
        public static int MothEnable;
        public static int TshirtEnable;
        public static int CoinEnable;
        public static int CreepingHorrorEnable;
        public static int TerribleTerrorEnable;
        public static int CliffRacerEnable;
        public static int TriffidEnable;
        public static int UltimateSwordMagic;
        public static int UltimateBowDamage;
        public static int PitchBlackEnable;
        public static int NightmareSize;
        public static int LurkingTerrorEnable;
        public static int IslandSpeedFactor;
        public static int IslandSizeFactor;
        public static int GinormousEmeraldTreeEnable;
        public static int GuiOverlayEnable;
        public static int FastGraphicsLeaves;
        public static int WormEnable;
        public static int CloudSharkEnable;
        public static int GoldFishEnable;
        public static int LeafMonsterEnable;
        public static int EnderKnightEnable;
        public static int EnderReaperEnable;
        public static int BeaverEnable;
        public static int IrukandjiEnable;
        public static int SkateEnable;
        public static int WhaleEnable;
        public static int FlounderEnable;
        public static int CrabEnable;
        public OreSpawnWorld OreSpawnGen;
        public static Random OreSpawnRand;
        public static Trees OreSpawnTrees;
        public static BasiliskMaze BMaze;
        public static RubyBirdDungeon RubyDungeon;
        public static GenericDungeon MyDungeon;
        public static MyUtils OreSpawnUtils;
        public static ChunkOreGenerator Chunker;
        public static OreGenericEgg MySpiderSpawnBlock;
        public static OreGenericEgg MyBatSpawnBlock;
        public static OreGenericEgg MyCowSpawnBlock;
        public static OreGenericEgg MyPigSpawnBlock;
        public static OreGenericEgg MySquidSpawnBlock;
        public static OreGenericEgg MyChickenSpawnBlock;
        public static OreGenericEgg MyCreeperSpawnBlock;
        public static OreGenericEgg MySkeletonSpawnBlock;
        public static OreGenericEgg MyZombieSpawnBlock;
        public static OreGenericEgg MySlimeSpawnBlock;
        public static OreGenericEgg MyGhastSpawnBlock;
        public static OreGenericEgg MyZombiePigmanSpawnBlock;
        public static OreGenericEgg MyEndermanSpawnBlock;
        public static OreGenericEgg MyCaveSpiderSpawnBlock;
        public static OreGenericEgg MySilverfishSpawnBlock;
        public static OreGenericEgg MyMagmaCubeSpawnBlock;
        public static OreGenericEgg MyWitchSpawnBlock;
        public static OreGenericEgg MySheepSpawnBlock;
        public static OreGenericEgg MyWolfSpawnBlock;
        public static OreGenericEgg MyMooshroomSpawnBlock;
        public static OreGenericEgg MyOcelotSpawnBlock;
        public static OreGenericEgg MyBlazeSpawnBlock;
        public static OreGenericEgg MyWitherSkeletonSpawnBlock;
        public static OreGenericEgg MyEnderDragonSpawnBlock;
        public static OreGenericEgg MySnowGolemSpawnBlock;
        public static OreGenericEgg MyIronGolemSpawnBlock;
        public static OreGenericEgg MyWitherBossSpawnBlock;
        public static OreGenericEgg MyGirlfriendSpawnBlock;
        public static OreGenericEgg MyBoyfriendSpawnBlock;
        public static OreGenericEgg MyRedCowSpawnBlock;
        public static OreGenericEgg MyCrystalCowSpawnBlock;
        public static OreGenericEgg MyVillagerSpawnBlock;
        public static OreGenericEgg MyGoldCowSpawnBlock;
        public static OreGenericEgg MyEnchantedCowSpawnBlock;
        public static OreGenericEgg MyMOTHRASpawnBlock;
        public static OreGenericEgg MyAloSpawnBlock;
        public static OreGenericEgg MyCryoSpawnBlock;
        public static OreGenericEgg MyCamaSpawnBlock;
        public static OreGenericEgg MyVeloSpawnBlock;
        public static OreGenericEgg MyHydroSpawnBlock;
        public static OreGenericEgg MyBasilSpawnBlock;
        public static OreGenericEgg MyDragonflySpawnBlock;
        public static OreGenericEgg MyEmperorScorpionSpawnBlock;
        public static OreGenericEgg MyScorpionSpawnBlock;
        public static OreGenericEgg MyCaveFisherSpawnBlock;
        public static OreGenericEgg MySpyroSpawnBlock;
        public static OreGenericEgg MyBaryonyxSpawnBlock;
        public static OreGenericEgg MyGammaMetroidSpawnBlock;
        public static OreGenericEgg MyCockateilSpawnBlock;
        public static OreGenericEgg MyKyuubiSpawnBlock;
        public static OreGenericEgg MyAlienSpawnBlock;
        public static OreGenericEgg MyAttackSquidSpawnBlock;
        public static OreGenericEgg MyWaterDragonSpawnBlock;
        public static OreGenericEgg MyKrakenSpawnBlock;
        public static OreGenericEgg MyLizardSpawnBlock;
        public static OreGenericEgg MyCephadromeSpawnBlock;
        public static OreGenericEgg MyDragonSpawnBlock;
        public static OreGenericEgg MyBeeSpawnBlock;
        public static OreGenericEgg MyHorseSpawnBlock;
        public static OreGenericEgg MyTrooperBugSpawnBlock;
        public static OreGenericEgg MySpitBugSpawnBlock;
        public static OreGenericEgg MyStinkBugSpawnBlock;
        public static OreGenericEgg MyOstrichSpawnBlock;
        public static OreGenericEgg MyGazelleSpawnBlock;
        public static OreGenericEgg MyChipmunkSpawnBlock;
        public static OreGenericEgg MyCreepingHorrorSpawnBlock;
        public static OreGenericEgg MyTerribleTerrorSpawnBlock;
        public static OreGenericEgg MyCliffRacerSpawnBlock;
        public static OreGenericEgg MyTriffidSpawnBlock;
        public static OreGenericEgg MyPitchBlackSpawnBlock;
        public static OreGenericEgg MyLurkingTerrorSpawnBlock;
        public static OreGenericEgg MyGodzillaPartSpawnBlock;
        public static OreGenericEgg MyGodzillaSpawnBlock;
        public static OreGenericEgg MyTheKingPartSpawnBlock;
        public static OreGenericEgg MyTheQueenPartSpawnBlock;
        public static OreGenericEgg MyTheKingSpawnBlock;
        public static OreGenericEgg MyTheQueenSpawnBlock;
        public static OreGenericEgg MySmallWormSpawnBlock;
        public static OreGenericEgg MyMediumWormSpawnBlock;
        public static OreGenericEgg MyLargeWormSpawnBlock;
        public static OreGenericEgg MyCassowarySpawnBlock;
        public static OreGenericEgg MyCloudSharkSpawnBlock;
        public static OreGenericEgg MyGoldFishSpawnBlock;
        public static OreGenericEgg MyLeafMonsterSpawnBlock;
        public static OreGenericEgg MyTshirtSpawnBlock;
        public static OreGenericEgg MyEnderKnightSpawnBlock;
        public static OreGenericEgg MyEnderReaperSpawnBlock;
        public static OreGenericEgg MyBeaverSpawnBlock;
        public static OreGenericEgg MyUrchinSpawnBlock;
        public static OreGenericEgg MyFlounderSpawnBlock;
        public static OreGenericEgg MySkateSpawnBlock;
        public static OreGenericEgg MyRotatorSpawnBlock;
        public static OreGenericEgg MyPeacockSpawnBlock;
        public static OreGenericEgg MyFairySpawnBlock;
        public static OreGenericEgg MyDungeonBeastSpawnBlock;
        public static OreGenericEgg MyVortexSpawnBlock;
        public static OreGenericEgg MyRatSpawnBlock;
        public static OreGenericEgg MyWhaleSpawnBlock;
        public static OreGenericEgg MyIrukandjiSpawnBlock;
        public static OreGenericEgg MyTRexSpawnBlock;
        public static OreGenericEgg MyHerculesSpawnBlock;
        public static OreGenericEgg MyMantisSpawnBlock;
        public static OreGenericEgg MyStinkySpawnBlock;
        public static OreGenericEgg MyEasterBunnySpawnBlock;
        public static OreGenericEgg MyCaterKillerSpawnBlock;
        public static OreGenericEgg MyMolenoidSpawnBlock;
        public static OreGenericEgg MySeaMonsterSpawnBlock;
        public static OreGenericEgg MySeaViperSpawnBlock;
        public static OreGenericEgg MyLeonSpawnBlock;
        public static OreGenericEgg MyHammerheadSpawnBlock;
        public static OreGenericEgg MyRubberDuckySpawnBlock;
        public static OreGenericEgg MyCriminalSpawnBlock;
        public static OreGenericEgg MyBrutalflySpawnBlock;
        public static OreGenericEgg MyNastysaurusSpawnBlock;
        public static OreGenericEgg MyPointysaurusSpawnBlock;
        public static OreGenericEgg MyCricketSpawnBlock;
        public static OreGenericEgg MyFrogSpawnBlock;
        public static OreGenericEgg MySpiderDriverSpawnBlock;
        public static OreGenericEgg MyCrabSpawnBlock;
        public static Block MyOreUraniumBlock;
        public static Block MyOreTitaniumBlock;
        public static Item MyIngotUranium;
        public static Item MyIngotTitanium;
        public static Block MyBlockUraniumBlock;
        public static Block MyBlockTitaniumBlock;
        public static Block MyBlockMobzillaScaleBlock;
        public static Block MyBlockRubyBlock;
        public static Block MyBlockAmethystBlock;
        public static Block MyLavafoamBlock;
        public static Block MyPizzaBlock;
        public static Item MyPizzaItem;
        public static Block MyDuctTapeBlock;
        public static Item MyDuctTapeItem;
        public static Block MyAntBlock;
        public static Block MyRedAntBlock;
        public static Block TermiteBlock;
        public static Block CrystalTermiteBlock;
        public static Block MyRainbowAntBlock;
        public static Block MyUnstableAntBlock;
        public static Block MyFlowerPinkBlock;
        public static Block MyFlowerBlueBlock;
        public static Block MyFlowerBlackBlock;
        public static Block MyFlowerScaryBlock;
        public static Block CrystalFlowerRedBlock;
        public static Block CrystalFlowerGreenBlock;
        public static Block CrystalFlowerBlueBlock;
        public static Block CrystalFlowerYellowBlock;
        public static Block CrystalPlanksBlock;
        public static Block CrystalWorkbenchBlock;
        public static CrystalFurnace CrystalFurnaceBlock;
        public static Block CrystalFurnaceOnBlock;
        public static Item MyUltimateSword;
        public static Item MyUltimatePickaxe;
        public static Item MyUltimateShovel;
        public static Item MyUltimateHoe;
        public static Item MyUltimateAxe;
        public static Item MyNightmareSword;
        public static Item MyBertha;
        public static Item MyHammy;
        public static Item MyBattleAxe;
        public static Item MyQueenBattleAxe;
        public static Item MyChainsaw;
        public static Item MySquidZooka;
        public static Item MySlice;
        public static Item MyRoyal;
        public static Item MyEmeraldSword;
        public static Item MyEmeraldPickaxe;
        public static Item MyEmeraldShovel;
        public static Item MyEmeraldHoe;
        public static Item MyEmeraldAxe;
        public static Item MyExperienceSword;
        public static Item MyPoisonSword;
        public static Item MyRatSword;
        public static Item MyFairySword;
        public static Item MyMantisClaw;
        public static Item MyBigHammer;
        public static Item MyRubySword;
        public static Item MyRubyPickaxe;
        public static Item MyRubyShovel;
        public static Item MyRubyHoe;
        public static Item MyRubyAxe;
        public static Item MyAmethystSword;
        public static Item MyAmethystPickaxe;
        public static Item MyAmethystShovel;
        public static Item MyAmethystHoe;
        public static Item MyAmethystAxe;
        public static Item MyRoseSword;
        static Item.ToolMaterial toolULTIMATE;
        static Item.ToolMaterial toolNIGHTMARE;
        static Item.ToolMaterial toolBERTHA;
        static Item.ToolMaterial toolCRYSTALWOOD;
        static Item.ToolMaterial toolCRYSTALSTONE;
        static Item.ToolMaterial toolCRYSTALPINK;
        static Item.ToolMaterial toolTIGERSEYE;
        static Item.ToolMaterial toolRUBY;
        static Item.ToolMaterial toolAMETHYST;
        static Item.ToolMaterial toolEMERALD;
        static Item.ToolMaterial toolROYAL;
        static Item.ToolMaterial toolHAMMY;
        static Item.ToolMaterial toolBATTLE;
        static Item.ToolMaterial toolCHAINSAW;
        static Item.ToolMaterial toolQUEENBATTLE;
        static WeaponStats ultimate_stats;
        static WeaponStats nightmare_stats;
        public static WeaponStats bertha_stats;
        public static WeaponStats crystalwood_stats;
        public static WeaponStats crystalstone_stats;
        public static WeaponStats crystalpink_stats;
        public static WeaponStats tigerseye_stats;
        public static WeaponStats ruby_stats;
        public static WeaponStats amethyst_stats;
        public static WeaponStats emerald_stats;
        public static WeaponStats royal_stats;
        public static WeaponStats hammy_stats;
        public static WeaponStats battleaxe_stats;
        public static WeaponStats queenbattleaxe_stats;
        public static WeaponStats chainsaw_stats;
        public static Item MyCrystalWoodSword;
        public static Item MyCrystalWoodPickaxe;
        public static Item MyCrystalWoodShovel;
        public static Item MyCrystalWoodHoe;
        public static Item MyCrystalWoodAxe;
        public static Item MyCrystalPinkSword;
        public static Item MyCrystalPinkPickaxe;
        public static Item MyCrystalPinkShovel;
        public static Item MyCrystalPinkHoe;
        public static Item MyCrystalPinkAxe;
        public static Item MyTigersEyeSword;
        public static Item MyTigersEyePickaxe;
        public static Item MyTigersEyeShovel;
        public static Item MyTigersEyeHoe;
        public static Item MyTigersEyeAxe;
        public static Item MyCrystalStoneSword;
        public static Item MyCrystalStonePickaxe;
        public static Item MyCrystalStoneShovel;
        public static Item MyCrystalStoneHoe;
        public static Item MyCrystalStoneAxe;
        public static Item MyCrystalPinkIngot;
        public static Block MyCrystalPinkBlock;
        public static Item MyTigersEyeIngot;
        public static Block MyTigersEyeBlock;
        public static Item MyItemShoes;
        public static Item MyItemShoes_1;
        public static Item MyItemShoes_2;
        public static Item MyItemShoes_3;
        public static Item MyItemGameController;
        public static Item MyUltimateBow;
        public static Item MySkateBow;
        public static Item MyUltimateFishingRod;
        public static ItemStack UltimateFishingRod;
        public static Item MyFireFish;
        public static Item MySunFish;
        public static Item MyLavaEel;
        public static Item MyMothScale;
        public static Item MyQueenScale;
        public static Item MyNightmareScale;
        public static Item MyEmperorScorpionScale;
        public static Item MyBasiliskScale;
        public static Item MyWaterDragonScale;
        public static Item MyJumpyBugScale;
        public static Item MyKrakenTooth;
        public static Item MyGodzillaScale;
        public static Item GreenGoo;
        public static Item SpiderRobotKit;
        public static Item AntRobotKit;
        public static Item ZooKeeper;
        public static Item CreeperLauncher;
        public static Item NetherLost;
        public static Item CrystalSticks;
        public static Item Sifter;
        public static Item MySunspotUrchin;
        public static Item MySparkFish;
        public static Item MyWaterBall;
        public static Item MyLaserBall;
        public static Item MyRayGun;
        public static Item MyThunderStaff;
        public static Item MyWrench;
        public static Item MyIceBall;
        public static Item MySmallRock;
        public static Item MyRock;
        public static Item MyRedRock;
        public static Item MyCrystalRedRock;
        public static Item MyCrystalGreenRock;
        public static Item MyCrystalBlueRock;
        public static Item MyCrystalTNTRock;
        public static Item MyBlueRock;
        public static Item MyGreenRock;
        public static Item MyPurpleRock;
        public static Item MySpikeyRock;
        public static Item MyTNTRock;
        public static Item MyAcid;
        public static Item MyIrukandji;
        public static Item MyIrukandjiArrow;
        public static Item MyGreenFish;
        public static Item MyBlueFish;
        public static Item MyPinkFish;
        public static Item MyRockFish;
        public static Item MyWoodFish;
        public static Item MyGreyFish;
        public static Item BerthaHandle;
        public static Item BerthaGuard;
        public static Item BerthaBlade;
        public static Item MolenoidNose;
        public static Item SeaMonsterScale;
        public static Item WormTooth;
        public static Item TRexTooth;
        public static Item CaterKillerJaw;
        public static Item SeaViperTongue;
        public static Item VortexEye;
        public static Item MyStepUp;
        public static Item MyStepDown;
        public static Item MyStepAccross;
        static ItemArmor.ArmorMaterial armorULTIMATE;
        public static ItemArmor.ArmorMaterial armorMOBZILLA;
        public static ItemArmor.ArmorMaterial armorLAVAEEL;
        public static ItemArmor.ArmorMaterial armorMOTHSCALE;
        public static ItemArmor.ArmorMaterial armorEMERALD;
        public static ItemArmor.ArmorMaterial armorEXPERIENCE;
        public static ItemArmor.ArmorMaterial armorRUBY;
        public static ItemArmor.ArmorMaterial armorAMETHYST;
        public static ItemArmor.ArmorMaterial armorPINK;
        public static ItemArmor.ArmorMaterial armorTIGERSEYE;
        public static ItemArmor.ArmorMaterial armorPEACOCK;
        public static ItemArmor.ArmorMaterial armorROYAL;
        public static ItemArmor.ArmorMaterial armorLAPIS;
        public static ItemArmor.ArmorMaterial armorQUEEN;
        public static ItemOreSpawnArmor UltimateHelmet;
        public static ItemOreSpawnArmor UltimateBody;
        public static ItemOreSpawnArmor UltimateLegs;
        public static ItemOreSpawnArmor UltimateBoots;
        public static ItemOreSpawnArmor LavaEelHelmet;
        public static ItemOreSpawnArmor LavaEelBody;
        public static ItemOreSpawnArmor LavaEelLegs;
        public static ItemOreSpawnArmor LavaEelBoots;
        public static ItemOreSpawnArmor MothScaleHelmet;
        public static ItemOreSpawnArmor MothScaleBody;
        public static ItemOreSpawnArmor MothScaleLegs;
        public static ItemOreSpawnArmor MothScaleBoots;
        public static ItemOreSpawnArmor EmeraldHelmet;
        public static ItemOreSpawnArmor EmeraldBody;
        public static ItemOreSpawnArmor EmeraldLegs;
        public static ItemOreSpawnArmor EmeraldBoots;
        public static ItemOreSpawnArmor ExperienceHelmet;
        public static ItemOreSpawnArmor ExperienceBody;
        public static ItemOreSpawnArmor ExperienceLegs;
        public static ItemOreSpawnArmor ExperienceBoots;
        public static ItemOreSpawnArmor RubyHelmet;
        public static ItemOreSpawnArmor RubyBody;
        public static ItemOreSpawnArmor RubyLegs;
        public static ItemOreSpawnArmor RubyBoots;
        public static ItemOreSpawnArmor AmethystHelmet;
        public static ItemOreSpawnArmor AmethystBody;
        public static ItemOreSpawnArmor AmethystLegs;
        public static ItemOreSpawnArmor AmethystBoots;
        public static ItemOreSpawnArmor CrystalPinkHelmet;
        public static ItemOreSpawnArmor CrystalPinkBody;
        public static ItemOreSpawnArmor CrystalPinkLegs;
        public static ItemOreSpawnArmor CrystalPinkBoots;
        public static ItemOreSpawnArmor TigersEyeHelmet;
        public static ItemOreSpawnArmor TigersEyeBody;
        public static ItemOreSpawnArmor TigersEyeLegs;
        public static ItemOreSpawnArmor TigersEyeBoots;
        public static Block TigersEye;
        public static ItemOreSpawnArmor PeacockFeatherBoots;
        public static ItemOreSpawnArmor PeacockFeatherHelmet;
        public static ItemOreSpawnArmor PeacockFeatherBody;
        public static ItemOreSpawnArmor PeacockFeatherLegs;
        public static ItemOreSpawnArmor MobzillaHelmet;
        public static ItemOreSpawnArmor MobzillaBody;
        public static ItemOreSpawnArmor MobzillaLegs;
        public static ItemOreSpawnArmor MobzillaBoots;
        public static ItemOreSpawnArmor RoyalHelmet;
        public static ItemOreSpawnArmor RoyalBody;
        public static ItemOreSpawnArmor RoyalLegs;
        public static ItemOreSpawnArmor RoyalBoots;
        public static ItemOreSpawnArmor LapisHelmet;
        public static ItemOreSpawnArmor LapisBody;
        public static ItemOreSpawnArmor LapisLegs;
        public static ItemOreSpawnArmor LapisBoots;
        public static ItemOreSpawnArmor QueenHelmet;
        public static ItemOreSpawnArmor QueenBody;
        public static ItemOreSpawnArmor QueenLegs;
        public static ItemOreSpawnArmor QueenBoots;
        public static Block MyOreSaltBlock;
        public static Block MyRTPBlock;
        public static Block MyMoleDirtBlock;
        public static Item MySalt;
        public static Item MyPopcorn;
        public static Item MyButteredPopcorn;
        public static Item MyButteredSaltedPopcorn;
        public static Item MyPopcornBag;
        public static Item MyButter;
        public static Item MyCornDog;
        public static Item MyRawCornDog;
        public static Item MyPeacock;
        public static Item MyRawPeacock;
        public static Item MyElevator;
        public static Block MyOreRubyBlock;
        public static Item MyRuby;
        public static Item MyBacon;
        public static Item MyRawBacon;
        public static Item MyCrabMeat;
        public static Item MyRawCrabMeat;
        public static Item MyButterCandy;
        public static Block MyOreAmethystBlock;
        public static Item MyAmethyst;
        public static Item UraniumNugget;
        public static Item TitaniumNugget;
        public static Item MySalad;
        public static Item MyBLT;
        public static Item MyCrabbyPatty;
        public static Block CrystalStone;
        public static Block CrystalRat;
        public static Block CrystalFairy;
        public static Block CrystalCoal;
        public static Block CrystalGrass;
        public static Block CrystalCrystal;
        public static Block RedAntTroll;
        public static Block TermiteTroll;
        public static Item CageEmpty;
        public static Item CagedSpider;
        public static Item CagedBat;
        public static Item CagedCow;
        public static Item CagedPig;
        public static Item CagedSquid;
        public static Item CagedChicken;
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
        public static Item WitherSkeletonEgg;
        public static Item EnderDragonEgg;
        public static Item SnowGolemEgg;
        public static Item IronGolemEgg;
        public static Item WitherBossEgg;
        public static Item GirlfriendEgg;
        public static Item RedCowEgg;
        public static Item CrystalCowEgg;
        public static Item GoldCowEgg;
        public static Item EnchantedCowEgg;
        public static Item MOTHRAEgg;
        public static Item AloEgg;
        public static Item CryoEgg;
        public static Item CamaEgg;
        public static Item VeloEgg;
        public static Item HydroEgg;
        public static Item BasilEgg;
        public static Item DragonflyEgg;
        public static Item EmperorScorpionEgg;
        public static Item ScorpionEgg;
        public static Item CaveFisherEgg;
        public static Item SpyroEgg;
        public static Item BaryonyxEgg;
        public static Item GammaMetroidEgg;
        public static Item CockateilEgg;
        public static Item KyuubiEgg;
        public static Item AlienEgg;
        public static Item AttackSquidEgg;
        public static Item WaterDragonEgg;
        public static Item CephadromeEgg;
        public static Item DragonEgg;
        public static Item KrakenEgg;
        public static Item LizardEgg;
        public static Item BeeEgg;
        public static Item TrooperBugEgg;
        public static Item SpitBugEgg;
        public static Item StinkBugEgg;
        public static Item OstrichEgg;
        public static Item GazelleEgg;
        public static Item ChipmunkEgg;
        public static Item CreepingHorrorEgg;
        public static Item TerribleTerrorEgg;
        public static Item CliffRacerEgg;
        public static Item TriffidEgg;
        public static Item PitchBlackEgg;
        public static Item LurkingTerrorEgg;
        public static Item GodzillaEgg;
        public static Item SmallWormEgg;
        public static Item MediumWormEgg;
        public static Item LargeWormEgg;
        public static Item CassowaryEgg;
        public static Item CloudSharkEgg;
        public static Item GoldFishEgg;
        public static Item LeafMonsterEgg;
        public static Item TshirtEgg;
        public static Item EnderKnightEgg;
        public static Item EnderReaperEgg;
        public static Item BeaverEgg;
        public static Item RotatorEgg;
        public static Item VortexEgg;
        public static Item PeacockEgg;
        public static Item FairyEgg;
        public static Item DungeonBeastEgg;
        public static Item RatEgg;
        public static Item FlounderEgg;
        public static Item WhaleEgg;
        public static Item IrukandjiEgg;
        public static Item SkateEgg;
        public static Item UrchinEgg;
        public static Item Robot1Egg;
        public static Item Robot2Egg;
        public static Item Robot3Egg;
        public static Item Robot4Egg;
        public static Item GhostEgg;
        public static Item GhostSkellyEgg;
        public static Item BrownAntEgg;
        public static Item RedAntEgg;
        public static Item RainbowAntEgg;
        public static Item UnstableAntEgg;
        public static Item TermiteEgg;
        public static Item ButterflyEgg;
        public static Item MothEgg;
        public static Item MosquitoEgg;
        public static Item FireflyEgg;
        public static Item TRexEgg;
        public static Item HerculesEgg;
        public static Item MantisEgg;
        public static Item StinkyEgg;
        public static Item Robot5Egg;
        public static Item CoinEgg;
        public static Item BoyfriendEgg;
        public static Item TheKingEgg;
        public static Item TheQueenEgg;
        public static Item ThePrinceEgg;
        public static Item EasterBunnyEgg;
        public static Item MolenoidEgg;
        public static Item SeaMonsterEgg;
        public static Item SeaViperEgg;
        public static Item CaterKillerEgg;
        public static Item LeonEgg;
        public static Item HammerheadEgg;
        public static Item RubberDuckyEgg;
        public static Item CriminalEgg;
        public static Item BrutalflyEgg;
        public static Item NastysaurusEgg;
        public static Item PointysaurusEgg;
        public static Item CricketEgg;
        public static Item ThePrincessEgg;
        public static Item FrogEgg;
        public static Item JefferyEgg;
        public static Item AntRobotEgg;
        public static Item SpiderRobotEgg;
        public static Item SpiderDriverEgg;
        public static Item CrabEgg;
        public static Item MyStrawberry;

        public static Item MyCrystalApple;
        public static Item MyLove;
        public static Item MyCheese;
        public static Item MyCherry;
        public static Item MyPeach;
        public static Item MyStrawberrySeed;
        public static Block MyStrawberryPlant;
        public static Item MyButterflySeed;
        public static Block MyButterflyPlant;
        public static Item MyMothSeed;
        public static Block MyMothPlant;
        public static Item MyMosquitoSeed;
        public static Block MyMosquitoPlant;
        public static Item MyFireflySeed;
        public static Block MyFireflyPlant;
        public static Item MyRadish;
        public static Item MyRice;
        public static Block MyRadishPlant;
        public static Block MyRicePlant;
        public static Block MyCornPlant1;
        public static Block MyCornPlant2;
        public static Block MyCornPlant3;
        public static Block MyCornPlant4;
        public static Item MyCornCob;
        public static Block MyQuinoaPlant1;
        public static Block MyQuinoaPlant2;
        public static Block MyQuinoaPlant3;
        public static Block MyQuinoaPlant4;
        public static Item MyQuinoa;
        public static Block MyTomatoPlant1;
        public static Block MyTomatoPlant2;
        public static Block MyTomatoPlant3;
        public static Block MyTomatoPlant4;
        public static Item MyTomato;
        public static Block MyLettucePlant1;
        public static Block MyLettucePlant2;
        public static Block MyLettucePlant3;
        public static Block MyLettucePlant4;
        public static Item MyLettuce;
        public static Item MagicApple;
        public static Item RandomDungeon;
        public static Item MinersDream;
        public static Block ExtremeTorch;
        public static Block MyEnderPearlBlock;
        public static Block MyEyeOfEnderBlock;
        public static Block MyExperiencePlant;
        public static Block KrakenRepellent;
        public static Block MyIslandBlock;
        public static Block CreeperRepellent;
        public static Item ZooCage2;
        public static Item ZooCage4;
        public static Item ZooCage6;
        public static Item ZooCage8;
        public static Item ZooCage10;
        public static Item InstantShelter;
        public static Item InstantGarden;
        public static Block CrystalTorch;
        public static Item MyPeacockFeather;
        public static Block MyKingSpawnerBlock;
        public static Block MyQueenSpawnerBlock;
        public static Block MyDungeonSpawnerBlock;
        public static Block MyCrystalPlant;
        public static Block MyCrystalPlant2;
        public static Block MyCrystalPlant3;
        public static Block MyAppleLeaves;
        public static Item MyAppleSeed;
        public static Item MyCherrySeed;
        public static Item MyPeachSeed;
        public static Block MySkyTreeLog;
        public static Block MyDT;
        public static Block MyExperienceLeaves;
        public static Block MyScaryLeaves;
        public static Block MyCherryLeaves;
        public static Block MyPeachLeaves;
        public static Item MyExperienceCatcher;
        public static Item MyExperienceTreeSeed;
        public static Item MyDeadStinkBug;
        public static Block MyCrystalLeaves;
        public static Block MyCrystalLeaves2;
        public static Block MyCrystalLeaves3;
        public static Block MyCrystalTreeLog;
        public static int GirlfriendID;
        public static int BoyfriendID;
        public static int RedCowID;
        public static int GoldCowID;
        public static int CrystalCowID;
        public static int ButterflyID;
        public static int FireflyID;
        public static int FairyID;
        public static int BeeID;
        public static int TheKingID;
        public static int TheQueenID;
        public static int ThePrinceID;
        public static int ThePrincessID;
        public static int ThePrinceTeenID;
        public static int ThePrinceAdultID;
        public static int MantisID;
        public static int StinkyID;
        public static int HerculesBeetleID;
        public static int LunaMothID;
        public static int MosquitoID;
        public static int GhostID;
        public static int GhostSkellyID;
        public static int SpiderRobotID;
        public static int AntRobotID;
        public static int JefferyID;
        public static int SpiderDriverID;
        public static int MothraID;
        public static int BrutalflyID;
        public static int NastysaurusID;
        public static int PointysaurusID;
        public static int CricketID;
        public static int FrogID;
        public static int EnchantedCowID;
        public static int AntID;
        public static int UnstableAntID;
        public static int RedAntID;
        public static int TermiteID;
        public static int RockBaseID;
        public static int RainbowAntID;
        public static int AlosaurusID;
        public static int LeonID;
        public static int CaterKillerID;
        public static int MolenoidID;
        public static int TRexID;
        public static int BandPID;
        public static int CryolophosaurusID;
        public static int RatID;
        public static int UrchinID;
        public static int CamarasaurusID;
        public static int VelocityRaptorID;
        public static int HydroliscID;
        public static int SpyroID;
        public static int BaryonyxID;
        public static int CassowaryID;
        public static int EasterBunnyID;
        public static int PeacockID;
        public static int CockateilID;
        public static int RubyBirdID;
        public static int KyuubiID;
        public static int CephadromeID;
        public static int DragonID;
        public static int GammaMetroidID;
        public static int BasiliskID;
        public static int DragonflyID;
        public static int EmperorScorpionID;
        public static int TrooperBugID;
        public static int SpitBugID;
        public static int StinkBugID;
        public static int ScorpionID;
        public static int CaveFisherID;
        public static int AlienID;
        public static int WaterDragonID;
        public static int SeaMonsterID;
        public static int SeaViperID;
        public static int AttackSquidID;
        public static int ElevatorID;
        public static int Robot1ID;
        public static int Robot2ID;
        public static int Robot3ID;
        public static int Robot4ID;
        public static int Robot5ID;
        public static int RotatorID;
        public static int VortexID;
        public static int DungeonBeastID;
        public static int KrakenID;
        public static int LizardID;
        public static int RubberDuckyID;
        public static int ChipmunkID;
        public static int OstrichID;
        public static int GazelleID;
        public static int TshirtID;
        public static int CoinID;
        public static int IslandID;
        public static int IslandTooID;
        public static int CreepingHorrorID;
        public static int TerribleTerrorID;
        public static int CliffRacerID;
        public static int TriffidID;
        public static int PitchBlackID;
        public static int LurkingTerrorID;
        public static int GodzillaID;
        public static int WormSmallID;
        public static int WormMediumID;
        public static int WormLargeID;
        public static int CloudSharkID;
        public static int GoldFishID;
        public static int LeafMonsterID;
        public static int GodzillaHeadID;
        public static int KingHeadID;
        public static int QueenHeadID;
        public static int EnderKnightID;
        public static int EnderReaperID;
        public static int BeaverID;
        public static int SkateID;
        public static int IrukandjiID;
        public static int FlounderID;
        public static int WhaleID;
        public static int HammerheadID;
        public static int CrabID;
        public static MobStats Bee_stats;
        public static MobStats Mantis_stats;
        public static MobStats HerculesBeetle_stats;
        public static MobStats Mothra_stats;
        public static MobStats Brutalfly_stats;
        public static MobStats Nastysaurus_stats;
        public static MobStats Pointysaurus_stats;
        public static MobStats Alosaurus_stats;
        public static MobStats SpiderRobot_stats;
        public static MobStats AntRobot_stats;
        public static MobStats Jeffery_stats;
        public static MobStats Hammerhead_stats;
        public static MobStats Leon_stats;
        public static MobStats CaterKiller_stats;
        public static MobStats Molenoid_stats;
        public static MobStats TRex_stats;
        public static MobStats BandP_stats;
        public static MobStats Cryolophosaurus_stats;
        public static MobStats Rat_stats;
        public static MobStats Urchin_stats;
        public static MobStats Kyuubi_stats;
        public static MobStats GammaMetroid_stats;
        public static MobStats Basilisk_stats;
        public static MobStats EmperorScorpion_stats;
        public static MobStats TrooperBug_stats;
        public static MobStats SpitBug_stats;
        public static MobStats Alien_stats;
        public static MobStats WaterDragon_stats;
        public static MobStats SeaMonster_stats;
        public static MobStats SeaViper_stats;
        public static MobStats Robot2_stats;
        public static MobStats Robot3_stats;
        public static MobStats Robot4_stats;
        public static MobStats Robot5_stats;
        public static MobStats Rotator_stats;
        public static MobStats Vortex_stats;
        public static MobStats DungeonBeast_stats;
        public static MobStats Triffid_stats;
        public static MobStats LurkingTerror_stats;
        public static MobStats WormSmall_stats;
        public static MobStats WormMedium_stats;
        public static MobStats WormLarge_stats;
        public static MobStats EnderKnight_stats;
        public static MobStats EnderReaper_stats;
        public static MobStats Irukandji_stats;
        public static MobStats AttackSquid_stats;
        public static MobStats CaveFisher_stats;
        public static MobStats CloudShark_stats;
        public static MobStats CreepingHorror_stats;
        public static MobStats Godzilla_stats;
        public static MobStats Kraken_stats;
        public static MobStats LeafMonster_stats;
        public static MobStats PitchBlack_stats;
        public static MobStats Crab_stats;
        public static MobStats Scorpion_stats;
        public static MobStats Skate_stats;
        public static MobStats TerribleTerror_stats;
        public static MobStats TheKing_stats;
        public static MobStats TheQueen_stats;
        public static OreStats Ruby_stats;
        public static OreStats BlkRuby_stats;
        public static OreStats Uranium_stats;
        public static OreStats Titanium_stats;
        public static OreStats Amethyst_stats;
        public static OreStats Salt_stats;
        public static OreStats SpawnOres_stats;
        public static OreStats Diamond_stats;
        public static OreStats BlkDiamond_stats;
        public static OreStats Emerald_stats;
        public static OreStats BlkEmerald_stats;
        public static OreStats Gold_stats;
        public static OreStats BlkGold_stats;

        public OreSpawnMain() {
            this.OreSpawnGen = new OreSpawnWorld();
        }

        @Mod.EventHandler
        public void preInit(final FMLPreInitializationEvent event) {
            final Configuration config = new Configuration(event.getSuggestedConfigurationFile());
            final String ids = "OreSpawnIDS";
            final String mobs = "OreSpawnMOBS";
            final String tweaks = "OreSpawnTWEAKS";
            final String weapons = "OreSpawnWEAPONS";
            final String ores = "OreSpawnORES";
            config.load();
            packetproxy.registerRenders();
            EntityInitDangerZone.preInit(event);
            SpawnEggInitDangerZone.preInit(event);
            ItemInitDangerZone.init();
            ItemInitDangerZone.register();
            BlockInitDangerZone.init();
            BlockInitDangerZone.register();
            RecipeHandler.preInit(event);
            DimensionInitDangerZone.preInit(event);
            EntitySpawningHandler.preInit(event);
            NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandlerDangerZone());
            BaseBlockID = config.get(ids, "BaseBlockID", 2700)
                .getInt();
            BaseItemID = config.get(ids, "BaseItemID", 9000)
                .getInt();
            BaseBiomeID = config.get(ids, "BaseBiomeID", 120)
                .getInt();
            BaseDimensionID = config.get(ids, "BaseDimensionID", 80)
                .getInt();
            this.getMobs(config, mobs);
            AllMobsDisable = config.get(tweaks, "AllMobsDisable", 0)
                .getInt();
            LessOre = config.get(tweaks, "LessOre", 0)
                .getInt();
            LessLag = config.get(tweaks, "LessLag", 0)
                .getInt();
            RatPlayerFriendly = config.get(tweaks, "RatPlayerFriendly", 1)
                .getInt();
            RatPetFriendly = config.get(tweaks, "RatPetFriendly", 1)
                .getInt();
            NightmareSize = config.get(tweaks, "NightmareSize", 0)
                .getInt();
            IslandSpeedFactor = config.get(tweaks, "IslandSpeedFactor", 2)
                .getInt();
            IslandSizeFactor = config.get(tweaks, "IslandSizeFactor", 2)
                .getInt();
            GinormousEmeraldTreeEnable = config.get(tweaks, "GinormousEmeraldTreeEnable", 1)
                .getInt();
            GuiOverlayEnable = config.get(tweaks, "GuiOverlayEnable", 1)
                .getInt();
            ultimate_sword_pvp = config.get(tweaks, "UltimateSwordPvp", 0)
                .getInt();
            big_bertha_pvp = config.get(tweaks, "BigBerthaPvp", 0)
                .getInt();
            bro_mode = config.get(tweaks, "BoyfriendBroMode", 0)
                .getInt();
            enableduplicatortree = config.get(tweaks, "DuplicatorTreeEnable", 1)
                .getInt();
            RoyalGlideEnable = config.get(tweaks, "RoyalGlideEnable", 1)
                .getInt();
            DragonflyHorseFriendly = config.get(tweaks, "DragonflyHorseFriendly", 0)
                .getInt();
            PlayNicely = config.get(tweaks, "PlayNicely", 0)
                .getInt();
            MinersDreamExpensive = config.get(tweaks, "MinersDreamExpensive", 0)
                .getInt();
            DisableOverworldDungeons = config.get(tweaks, "DisableOverworldDungeons", 0)
                .getInt();
            FullPowerKingEnable = config.get(tweaks, "FullPowerKingEnable", 0)
                .getInt();
            Amethyst_armorstats = this
                .get_armorstats(config, "Amethyst", 100, 4, 8, 7, 3, 40, 0, 0, 0, 0, 0, 0, 0, 0);
            Emerald_armorstats = this
                .get_armorstats(config, "Emerald", 60, 3, 8, 6, 3, 40, 0, 0, 0, 0, 0, 0, 0, 0);
            Experience_armorstats = this
                .get_armorstats(config, "Experience", 70, 5, 9, 7, 4, 50, 0, 0, 2, 0, 1, 0, 0, 1);
            MothScale_armorstats = this
                .get_armorstats(config, "MothScale", 50, 2, 7, 5, 2, 50, 0, 0, 3, 3, 3, 0, 0, 5);
            LavaEel_armorstats = this
                .get_armorstats(config, "LavaEel", 40, 2, 7, 5, 2, 35, 1, 2, 3, 2, 10, 0, 0, 2);
            Ultimate_armorstats = this
                .get_armorstats(config, "Ultimate", 200, 6, 12, 10, 6, 100, 2, 3, 5, 5, 5, 5, 0, 3);
            Pink_armorstats = this.get_armorstats(config, "Pink", 50, 3, 7, 5, 2, 40, 0, 0, 0, 0, 0, 0, 0, 0);
            TigersEye_armorstats = this
                .get_armorstats(config, "TigersEye", 80, 4, 8, 7, 4, 55, 0, 0, 0, 0, 0, 0, 0, 0);
            Peacock_armorstats = this
                .get_armorstats(config, "Peacock", 40, 2, 5, 4, 2, 30, 0, 0, 0, 0, 0, 0, 0, 10);
            Mobzilla_armorstats = this
                .get_armorstats(config, "Mobzilla", 1000, 7, 13, 11, 7, 150, 0, 0, 10, 10, 10, 10, 5, 10);
            Ruby_armorstats = this.get_armorstats(config, "Ruby", 90, 4, 9, 8, 4, 40, 0, 0, 0, 0, 0, 0, 0, 0);
            Royal_armorstats = this
                .get_armorstats(config, "Royal", 2000, 8, 14, 12, 8, 200, 1, 2, 10, 10, 10, 10, 5, 10);
            Lapis_armorstats = this
                .get_armorstats(config, "Lapis", 60, 2, 7, 5, 2, 60, 1, 1, 1, 0, 0, 1, 0, 0);
            Queen_armorstats = this
                .get_armorstats(config, "Queen", 1500, 9, 16, 14, 9, 150, 0, 0, 0, 0, 0, 0, 0, 0);
            ultimate_stats = this.get_weaponstats(config, weapons, "Ultimate", 10, 3000, 15, 36, 100);
            nightmare_stats = this.get_weaponstats(config, weapons, "Nightmare", 3, 1800, 12, 26, 60);
            bertha_stats = this.get_weaponstats(config, weapons, "Bertha", 3, 9000, 15, 496, 100);
            crystalwood_stats = this.get_weaponstats(config, weapons, "CrystalWood", 2, 300, 3, 2, 15);
            crystalstone_stats = this.get_weaponstats(config, weapons, "CrystalStone", 3, 800, 6, 5, 45);
            crystalpink_stats = this.get_weaponstats(config, weapons, "Pink", 4, 1100, 10, 7, 65);
            tigerseye_stats = this.get_weaponstats(config, weapons, "TigersEye", 4, 1600, 12, 8, 75);
            ruby_stats = this.get_weaponstats(config, weapons, "Ruby", 5, 1500, 11, 16, 85);
            amethyst_stats = this.get_weaponstats(config, weapons, "Amethyst", 4, 2000, 11, 11, 70);
            emerald_stats = this.get_weaponstats(config, weapons, "Emerald", 3, 1300, 10, 6, 75);
            royal_stats = this.get_weaponstats(config, weapons, "Royal", 3, 10000, 15, 746, 150);
            hammy_stats = this.get_weaponstats(config, weapons, "Attitude", 5, 2000, 15, 82, 100);
            battleaxe_stats = this.get_weaponstats(config, weapons, "BattleAxe", 3, 1500, 15, 46, 75);
            chainsaw_stats = this.get_weaponstats(config, weapons, "Chainsaw", 3, 1500, 10, 56, 75);
            queenbattleaxe_stats = this
                .get_weaponstats(config, weapons, "QueenBattleAxe", 3, 2200, 15, 662, 100);
            UltimateSwordMagic = config.get(weapons, "UltimateSwordEnchantmentLevel", 5)
                .getInt();
            UltimateBowDamage = config.get(weapons, "UltimateBowDamage", 10)
                .getInt();
            if (UltimateSwordMagic < 1) {
                UltimateSwordMagic = 1;
            }
            if (UltimateSwordMagic > 10) {
                UltimateSwordMagic = 10;
            }
            if (UltimateBowDamage < 2) {
                UltimateBowDamage = 2;
            }
            if (UltimateBowDamage > 20) {
                UltimateBowDamage = 20;
            }
            if (IslandSpeedFactor < 1) {
                IslandSpeedFactor = 1;
            }
            if (IslandSpeedFactor > 5) {
                IslandSpeedFactor = 5;
            }
            if (IslandSizeFactor < 1) {
                IslandSizeFactor = 1;
            }
            if (IslandSizeFactor > 5) {
                IslandSizeFactor = 5;
            }
            if (NightmareSize < 0) {
                NightmareSize = 0;
            }
            if (NightmareSize > 5) {
                NightmareSize = 5;
            }
            if (LessLag < 0) {
                LessLag = 0;
            }
            if (LessLag > 2) {
                LessLag = 2;
            }
            if (LessLag == 1) {
                if (IslandSizeFactor > 2) {
                    IslandSizeFactor = 2;
                }
                if (IslandSpeedFactor > 2) {
                    IslandSpeedFactor = 2;
                }
            }
            if (LessLag == 2) {
                if (IslandSizeFactor > 1) {
                    IslandSizeFactor = 1;
                }
                if (IslandSpeedFactor > 1) {
                    IslandSpeedFactor = 1;
                }
                LessOre = 1;
            }
            Ruby_stats = this.get_orestats(config, ores, "Ruby", 10, 1, 0, 50);
            BlkRuby_stats = this.get_orestats(config, ores, "BlockRuby", 1, 2, 0, 15);
            Uranium_stats = this.get_orestats(config, ores, "Uranium", 3, 4, 0, 30);
            Titanium_stats = this.get_orestats(config, ores, "Titanium", 3, 4, 0, 20);
            Amethyst_stats = this.get_orestats(config, ores, "Amethyst", 2, 6, 0, 25);
            Salt_stats = this.get_orestats(config, ores, "Salt", 5, 12, 50, 128);
            SpawnOres_stats = this.get_orestats(config, ores, "SpawnOres", 28, 4, 50, 128);
            Diamond_stats = this.get_orestats(config, ores, "Diamond", 4, 6, 0, 30);
            BlkDiamond_stats = this.get_orestats(config, ores, "BlockDiamond", 2, 4, 0, 20);
            Emerald_stats = this.get_orestats(config, ores, "Emerald", 4, 6, 0, 40);
            BlkEmerald_stats = this.get_orestats(config, ores, "BlockEmerald", 2, 4, 0, 20);
            Gold_stats = this.get_orestats(config, ores, "Gold", 4, 8, 0, 40);
            BlkGold_stats = this.get_orestats(config, ores, "BlockGold", 2, 4, 0, 25);
            config.save();
            if (AllMobsDisable != 0) {
                this.disableAllMobs();
            }
            BiomeUtopiaID = BaseBiomeID;
            BiomeIslandsID = BaseBiomeID + 1;
            BiomeCrystalID = BaseBiomeID + 2;
            BiomeVillageID = BaseBiomeID + 3;
            BiomeChaosID = BaseBiomeID + 4;
            DimensionID = BaseDimensionID;
            DimensionID2 = BaseDimensionID + 1;
            DimensionID3 = BaseDimensionID + 2;
            DimensionID4 = BaseDimensionID + 3;
            DimensionID5 = BaseDimensionID + 4;
            DimensionID6 = BaseDimensionID + 5;
            packetproxy.registerSoundThings();
            this.laySomeEggs();
            MyOreUraniumBlock = new OreUranium(BaseBlockID + 101).setBlockName("oreuranium");
            MyOreTitaniumBlock = new OreTitanium(BaseBlockID + 102).setBlockName("oretitanium");
            MyIngotUranium = new IngotUranium(BaseItemID + 152)
                .setUnlocalizedName("ingoturanium");
            MyIngotTitanium = new IngotTitanium(BaseItemID + 153)
                .setUnlocalizedName("ingottitanium");
            MyBlockUraniumBlock = new BlockUranium(BaseBlockID + 107)
                .setBlockName("blockuranium");
            MyBlockTitaniumBlock = new BlockTitanium(BaseBlockID + 108)
                .setBlockName("blocktitanium");
            MyBlockMobzillaScaleBlock = new BlockRuby(BaseBlockID + 124)
                .setBlockName("blockmobzillascale");
            MyLavafoamBlock = new Lavafoam(BaseBlockID + 106).setBlockName("lavafoam");
            MyBlockRubyBlock = new BlockRuby(BaseBlockID + 109).setBlockName("blockruby");
            MyBlockAmethystBlock = new BlockRuby(BaseBlockID + 110).setBlockName("blockamethyst");
            MyCrystalPinkBlock = new BlockCrystal(BaseBlockID + 216)
                .setBlockName("crystalpink_block");
            MyCrystalPinkIngot = new IngotUranium(BaseItemID + 348)
                .setUnlocalizedName("crystalpink_ingot");
            MyTigersEyeBlock = new BlockCrystal(BaseBlockID + 218)
                .setBlockName("tigerseye_block");
            MyTigersEyeIngot = new IngotUranium(BaseItemID + 358)
                .setUnlocalizedName("tigerseye_ingot");
            MyPizzaBlock = new BlockPizza(BaseBlockID + 194).setBlockName("pizza");
            MyPizzaItem = new ItemPizza(BaseItemID + 204, MyPizzaBlock)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabFood)
                .setUnlocalizedName("pizza");
            MyDuctTapeBlock = new BlockDuctTape(BaseBlockID + 198).setBlockName("ducttape");
            MyDuctTapeItem = new ItemDuctTape(BaseItemID + 458, MyDuctTapeBlock)
                .setMaxStackSize(1)
                .setCreativeTab(CreativeTabs.tabTools)
                .setUnlocalizedName("ducttape");
            toolULTIMATE = EnumHelper.addToolMaterial(
                "ULTIMATE",
                ultimate_stats.harvestlevel,
                ultimate_stats.maxuses,
                (float) ultimate_stats.efficiency,
                (float) ultimate_stats.damage,
                ultimate_stats.enchantability);
            toolNIGHTMARE = EnumHelper.addToolMaterial(
                "NIGHTMARE",
                nightmare_stats.harvestlevel,
                nightmare_stats.maxuses,
                (float) nightmare_stats.efficiency,
                (float) nightmare_stats.damage,
                nightmare_stats.enchantability);
            toolEMERALD = EnumHelper.addToolMaterial(
                "REALEMERALD",
                emerald_stats.harvestlevel,
                emerald_stats.maxuses,
                (float) emerald_stats.efficiency,
                (float) emerald_stats.damage,
                emerald_stats.enchantability);
            toolRUBY = EnumHelper.addToolMaterial(
                "RUBY",
                ruby_stats.harvestlevel,
                ruby_stats.maxuses,
                (float) ruby_stats.efficiency,
                (float) ruby_stats.damage,
                ruby_stats.enchantability);
            toolAMETHYST = EnumHelper.addToolMaterial(
                "AMETHYST",
                amethyst_stats.harvestlevel,
                amethyst_stats.maxuses,
                (float) amethyst_stats.efficiency,
                (float) amethyst_stats.damage,
                amethyst_stats.enchantability);
            toolBERTHA = EnumHelper.addToolMaterial(
                "BERTHA",
                bertha_stats.harvestlevel,
                bertha_stats.maxuses,
                (float) bertha_stats.efficiency,
                (float) bertha_stats.damage,
                bertha_stats.enchantability);
            toolCRYSTALWOOD = EnumHelper.addToolMaterial(
                "CRYSTALWOOD",
                crystalwood_stats.harvestlevel,
                crystalwood_stats.maxuses,
                (float) crystalwood_stats.efficiency,
                (float) crystalwood_stats.damage,
                crystalwood_stats.enchantability);
            toolCRYSTALSTONE = EnumHelper.addToolMaterial(
                "CRYSTALSTONE",
                crystalstone_stats.harvestlevel,
                crystalstone_stats.maxuses,
                (float) crystalstone_stats.efficiency,
                (float) crystalstone_stats.damage,
                crystalstone_stats.enchantability);
            toolCRYSTALPINK = EnumHelper.addToolMaterial(
                "CRYSTALPINK",
                crystalpink_stats.harvestlevel,
                crystalpink_stats.maxuses,
                (float) crystalpink_stats.efficiency,
                (float) crystalpink_stats.damage,
                crystalpink_stats.enchantability);
            toolTIGERSEYE = EnumHelper.addToolMaterial(
                "TIGERSEYE",
                tigerseye_stats.harvestlevel,
                tigerseye_stats.maxuses,
                (float) tigerseye_stats.efficiency,
                (float) tigerseye_stats.damage,
                tigerseye_stats.enchantability);
            toolROYAL = EnumHelper.addToolMaterial(
                "ROYAL",
                royal_stats.harvestlevel,
                royal_stats.maxuses,
                (float) royal_stats.efficiency,
                (float) royal_stats.damage,
                royal_stats.enchantability);
            toolHAMMY = EnumHelper.addToolMaterial(
                "HAMMY",
                hammy_stats.harvestlevel,
                hammy_stats.maxuses,
                (float) hammy_stats.efficiency,
                (float) hammy_stats.damage,
                hammy_stats.enchantability);
            toolBATTLE = EnumHelper.addToolMaterial(
                "BATTLE",
                battleaxe_stats.harvestlevel,
                battleaxe_stats.maxuses,
                (float) battleaxe_stats.efficiency,
                (float) battleaxe_stats.damage,
                battleaxe_stats.enchantability);
            toolCHAINSAW = EnumHelper.addToolMaterial(
                "CHAINSAW",
                chainsaw_stats.harvestlevel,
                chainsaw_stats.maxuses,
                (float) chainsaw_stats.efficiency,
                (float) chainsaw_stats.damage,
                chainsaw_stats.enchantability);
            toolQUEENBATTLE = EnumHelper.addToolMaterial(
                "QUEENBATTLE",
                queenbattleaxe_stats.harvestlevel,
                queenbattleaxe_stats.maxuses,
                (float) queenbattleaxe_stats.efficiency,
                (float) queenbattleaxe_stats.damage,
                queenbattleaxe_stats.enchantability);
            MyUltimateSword = new UltimateSword(BaseItemID + 302, toolULTIMATE)
                .setUnlocalizedName("ultimatesword");
            (MyUltimatePickaxe = new UltimatePickaxe(BaseItemID + 305, toolULTIMATE)
                .setUnlocalizedName("ultimatepickaxe"))
                .setHarvestLevel("pickaxe", ultimate_stats.harvestlevel);
            (MyUltimateShovel = new UltimateShovel(BaseItemID + 306, toolULTIMATE)
                .setUnlocalizedName("ultimateshovel")).setHarvestLevel("shovel", ultimate_stats.harvestlevel);
            MyUltimateHoe = new UltimateHoe(BaseItemID + 307, toolULTIMATE)
                .setUnlocalizedName("ultimatehoe");
            (MyUltimateAxe = new UltimateAxe(BaseItemID + 308, toolULTIMATE)
                .setUnlocalizedName("ultimateaxe")).setHarvestLevel("axe", ultimate_stats.harvestlevel);
            MyNightmareSword = new NightmareSword(BaseItemID + 326, toolNIGHTMARE)
                .setUnlocalizedName("nightmaresword");
            MyBertha = new Bertha(BaseItemID + 313, toolBERTHA)
                .setUnlocalizedName("berthasmall");
            MySlice = new Bertha(BaseItemID + 314, toolBERTHA)
                .setUnlocalizedName("slicesmall");
            MyRoyal = new Bertha(BaseItemID + 318, toolROYAL)
                .setUnlocalizedName("royalsmall");
            MyHammy = new Bertha(BaseItemID + 319, toolHAMMY)
                .setUnlocalizedName("hammysmall");
            MyBattleAxe = new UltimateSword(BaseItemID + 422, toolBATTLE)
                .setUnlocalizedName("battleaxesmall");
            MyChainsaw = new UltimateSword(BaseItemID + 447, toolCHAINSAW)
                .setUnlocalizedName("chainsawsmall");
            MyQueenBattleAxe = new UltimateSword(BaseItemID + 470, toolQUEENBATTLE)
                .setUnlocalizedName("queenbattleaxesmall");
            MyEmeraldSword = new EmeraldSword(BaseItemID + 280, toolEMERALD)
                .setUnlocalizedName("emeraldsword");
            MyEmeraldPickaxe = new EmeraldPickaxe(BaseItemID + 281, toolEMERALD)
                .setUnlocalizedName("emeraldpickaxe");
            MyEmeraldShovel = new EmeraldShovel(BaseItemID + 282, toolEMERALD)
                .setUnlocalizedName("emeraldshovel");
            MyEmeraldHoe = new EmeraldHoe(BaseItemID + 283, toolEMERALD)
                .setUnlocalizedName("emeraldhoe");
            MyEmeraldAxe = new EmeraldAxe(BaseItemID + 284, toolEMERALD)
                .setUnlocalizedName("emeraldaxe");
            MyExperienceSword = new ExperienceSword(BaseItemID + 289, toolEMERALD)
                .setUnlocalizedName("experiencesword");
            MyPoisonSword = new PoisonSword(BaseItemID + 241, toolEMERALD)
                .setUnlocalizedName("poisonsword");
            MyRatSword = new RatSword(BaseItemID + 256, toolEMERALD)
                .setUnlocalizedName("ratsword");
            MyFairySword = new FairySword(BaseItemID + 257, toolEMERALD)
                .setUnlocalizedName("fairysword");
            MyMantisClaw = new MantisClaw(BaseItemID + 315, toolEMERALD)
                .setUnlocalizedName("mantisclaw");
            MyBigHammer = new BigHammer(BaseItemID + 316, toolAMETHYST)
                .setUnlocalizedName("bighammer");
            MyRubySword = new RubySword(BaseItemID + 271, toolRUBY)
                .setUnlocalizedName("rubysword");
            (MyRubyPickaxe = new RubyPickaxe(BaseItemID + 272, toolRUBY)
                .setUnlocalizedName("rubypickaxe")).setHarvestLevel("pickaxe", ruby_stats.harvestlevel);
            (MyRubyShovel = new RubyShovel(BaseItemID + 273, toolRUBY)
                .setUnlocalizedName("rubyshovel")).setHarvestLevel("shovel", ruby_stats.harvestlevel);
            MyRubyHoe = new RubyHoe(BaseItemID + 274, toolRUBY)
                .setUnlocalizedName("rubyhoe");
            (MyRubyAxe = new RubyAxe(BaseItemID + 275, toolRUBY)
                .setUnlocalizedName("rubyaxe")).setHarvestLevel("axe", ruby_stats.harvestlevel);
            MyAmethystSword = new AmethystSword(BaseItemID + 261, toolAMETHYST)
                .setUnlocalizedName("amethystsword");
            (MyAmethystPickaxe = new AmethystPickaxe(BaseItemID + 262, toolAMETHYST)
                .setUnlocalizedName("amethystpickaxe"))
                .setHarvestLevel("pickaxe", amethyst_stats.harvestlevel);
            (MyAmethystShovel = new AmethystShovel(BaseItemID + 263, toolAMETHYST)
                .setUnlocalizedName("amethystshovel")).setHarvestLevel("shovel", amethyst_stats.harvestlevel);
            MyAmethystHoe = new AmethystHoe(BaseItemID + 264, toolAMETHYST)
                .setUnlocalizedName("amethysthoe");
            (MyAmethystAxe = new AmethystAxe(BaseItemID + 265, toolAMETHYST)
                .setUnlocalizedName("amethystaxe")).setHarvestLevel("axe", amethyst_stats.harvestlevel);
            MyCrystalWoodSword = new CrystalSword(BaseItemID + 329, toolCRYSTALWOOD)
                .setUnlocalizedName("crystalwoodsword");
            MyCrystalWoodPickaxe = new CrystalPickaxe(
                BaseItemID + 330,
                toolCRYSTALWOOD).setUnlocalizedName("crystalwoodpickaxe");
            MyCrystalWoodShovel = new CrystalShovel(
                BaseItemID + 331,
                toolCRYSTALWOOD).setUnlocalizedName("crystalwoodshovel");
            MyCrystalWoodHoe = new CrystalHoe(BaseItemID + 332, toolCRYSTALWOOD)
                .setUnlocalizedName("crystalwoodhoe");
            MyCrystalWoodAxe = new CrystalAxe(BaseItemID + 333, toolCRYSTALWOOD)
                .setUnlocalizedName("crystalwoodaxe");
            MyCrystalPinkSword = new CrystalSword(BaseItemID + 334, toolCRYSTALPINK)
                .setUnlocalizedName("crystalpinksword");
            MyCrystalPinkPickaxe = new CrystalPickaxe(
                BaseItemID + 335,
                toolCRYSTALPINK).setUnlocalizedName("crystalpinkpickaxe");
            MyCrystalPinkShovel = new CrystalShovel(
                BaseItemID + 336,
                toolCRYSTALPINK).setUnlocalizedName("crystalpinkshovel");
            MyCrystalPinkHoe = new CrystalHoe(BaseItemID + 337, toolCRYSTALPINK)
                .setUnlocalizedName("crystalpinkhoe");
            MyCrystalPinkAxe = new CrystalAxe(BaseItemID + 338, toolCRYSTALPINK)
                .setUnlocalizedName("crystalpinkaxe");
            MyCrystalStoneSword = new CrystalSword(
                BaseItemID + 339,
                toolCRYSTALSTONE).setUnlocalizedName("crystalstonesword");
            MyCrystalStonePickaxe = new CrystalPickaxe(
                BaseItemID + 340,
                toolCRYSTALSTONE).setUnlocalizedName("crystalstonepickaxe");
            MyCrystalStoneShovel = new CrystalShovel(
                BaseItemID + 341,
                toolCRYSTALSTONE).setUnlocalizedName("crystalstoneshovel");
            MyCrystalStoneHoe = new CrystalHoe(BaseItemID + 342, toolCRYSTALSTONE)
                .setUnlocalizedName("crystalstonehoe");
            MyCrystalStoneAxe = new CrystalAxe(BaseItemID + 343, toolCRYSTALSTONE)
                .setUnlocalizedName("crystalstoneaxe");
            MyTigersEyeSword = new CrystalSword(BaseItemID + 349, toolTIGERSEYE)
                .setUnlocalizedName("tigerseye_sword");
            MyTigersEyePickaxe = new CrystalPickaxe(BaseItemID + 350, toolTIGERSEYE)
                .setUnlocalizedName("tigerseye_pickaxe");
            MyTigersEyeShovel = new CrystalShovel(BaseItemID + 351, toolTIGERSEYE)
                .setUnlocalizedName("tigerseye_shovel");
            MyTigersEyeHoe = new CrystalHoe(BaseItemID + 352, toolTIGERSEYE)
                .setUnlocalizedName("tigerseye_hoe");
            MyTigersEyeAxe = new CrystalAxe(BaseItemID + 353, toolTIGERSEYE)
                .setUnlocalizedName("tigerseye_axe");
            MyRoseSword = new EmeraldSword(BaseItemID + 484, toolEMERALD)
                .setUnlocalizedName("rosesword");
            MyItemShoes = new ItemShoes(BaseItemID + 248, 2).setUnlocalizedName("redheels");
            MyItemShoes_1 = new ItemShoes(BaseItemID + 249, 3).setUnlocalizedName("blackheels");
            MyItemShoes_2 = new ItemShoes(BaseItemID + 250, 4).setUnlocalizedName("slippers");
            MyItemShoes_3 = new ItemShoes(BaseItemID + 251, 5).setUnlocalizedName("boots");
            MyItemGameController = new ItemShoes(BaseItemID + 259, 6)
                .setUnlocalizedName("gamecontroller");
            MyUltimateBow = new UltimateBow(BaseItemID + 303).setUnlocalizedName("ultimatebow");
            MySkateBow = new SkateBow(BaseItemID + 373).setUnlocalizedName("skatebow");
            MyUltimateFishingRod = new UltimateFishingRod(BaseItemID + 304)
                .setUnlocalizedName("ultimatefishingrod");
            UltimateFishingRod = new ItemStack(MyUltimateFishingRod);
            MyFireFish = new ItemFireFish(BaseItemID + 175, 4, 0.6f, false)
                .setUnlocalizedName("firefish");
            MySunFish = new ItemSunFish(BaseItemID + 176, 6, 0.6f, false)
                .setUnlocalizedName("sunfish");
            MyLavaEel = new ItemLavaEel(BaseItemID + 157, 2, 0.6f, false)
                .setUnlocalizedName("lavaeel");
            MyMothScale = new ItemSalt(BaseItemID + 156).setUnlocalizedName("mothscale");
            MyQueenScale = new ItemSalt(BaseItemID + 453).setUnlocalizedName("queenscale");
            MyNightmareScale = new ItemSalt(BaseItemID + 158)
                .setUnlocalizedName("nightmarescale");
            MyEmperorScorpionScale = new ItemSalt(BaseItemID + 159)
                .setUnlocalizedName("emperorscorpionscale");
            MyBasiliskScale = new ItemSalt(BaseItemID + 160).setUnlocalizedName("basiliskscale");
            MyWaterDragonScale = new ItemSalt(BaseItemID + 161)
                .setUnlocalizedName("waterdragonscale");
            MyPeacockFeather = new ItemSalt(BaseItemID + 255)
                .setUnlocalizedName("peacockfeather");
            MyJumpyBugScale = new ItemSalt(BaseItemID + 162).setUnlocalizedName("jumpybugscale");
            MyKrakenTooth = new ItemSalt(BaseItemID + 163).setUnlocalizedName("krakentooth");
            MyGodzillaScale = new ItemSalt(BaseItemID + 164).setUnlocalizedName("godzillascale");
            GreenGoo = new ItemSalt(BaseItemID + 154).setUnlocalizedName("greengoo");
            SpiderRobotKit = new ItemSpiderRobotKit(BaseItemID + 471)
                .setUnlocalizedName("spiderrobotkit");
            AntRobotKit = new ItemSpiderRobotKit(BaseItemID + 473)
                .setUnlocalizedName("antrobotkit");
            ZooKeeper = new ItemZooKeeper(BaseItemID + 230).setUnlocalizedName("zookeeper");
            CreeperLauncher = new ItemCreeperLauncher(BaseItemID + 252)
                .setUnlocalizedName("creeperlauncher");
            NetherLost = new ItemNetherLost(BaseItemID + 253).setUnlocalizedName("netherlost");
            CrystalSticks = new ItemCrystalSticks(BaseItemID + 254)
                .setUnlocalizedName("crystalsticks");
            MySunspotUrchin = new ItemSunspotUrchin().setUnlocalizedName("sunspoturchin2").setTextureName(Tags.MODID + ":sunspoturchin");
            MySparkFish = new ItemSparkFish(BaseItemID + 177, 1, 0.2f, false)
                .setUnlocalizedName("sparkfish");
            MyWaterBall = new ItemWaterBall(BaseItemID + 244).setUnlocalizedName("waterball");
            MyLaserBall = new ItemLaserBall(BaseItemID + 242).setUnlocalizedName("laserball");
            MyIceBall = new ItemIceBall(BaseItemID + 239).setUnlocalizedName("iceball");
            MySmallRock = new ItemRock(BaseItemID + 436).setUnlocalizedName("rocksmall");
            MyRock = new ItemRock(BaseItemID + 435).setUnlocalizedName("rock");
            MyRedRock = new ItemRock(BaseItemID + 437).setUnlocalizedName("rockred");
            MyCrystalRedRock = new ItemRock(BaseItemID + 443)
                .setUnlocalizedName("rockcrystalred");
            MyCrystalGreenRock = new ItemRock(BaseItemID + 444)
                .setUnlocalizedName("rockcrystalgreen");
            MyCrystalBlueRock = new ItemRock(BaseItemID + 445)
                .setUnlocalizedName("rockcrystalblue");
            MyCrystalTNTRock = new ItemRock(BaseItemID + 446)
                .setUnlocalizedName("rockcrystaltnt");
            MyGreenRock = new ItemRock(BaseItemID + 438).setUnlocalizedName("rockgreen");
            MyBlueRock = new ItemRock(BaseItemID + 439).setUnlocalizedName("rockblue");
            MyPurpleRock = new ItemRock(BaseItemID + 440).setUnlocalizedName("rockpurple");
            MySpikeyRock = new ItemRock(BaseItemID + 441).setUnlocalizedName("rockspikey");
            MyTNTRock = new ItemRock(BaseItemID + 442).setUnlocalizedName("rocktnt");
            MyRayGun = new ItemRayGun(BaseItemID + 243).setUnlocalizedName("RayGun");
            MyThunderStaff = new ItemThunderStaff(BaseItemID + 240)
                .setUnlocalizedName("thunderstaff");
            MyWrench = new ItemWrench(BaseItemID + 472).setUnlocalizedName("wrench");
            MyAcid = new ItemAcid(BaseItemID + 247).setUnlocalizedName("acid");
            MyIrukandjiArrow = new ItemIrukandjiArrow(BaseItemID + 372)
                .setUnlocalizedName("irukandjiarrow");
            MyIrukandji = new fr.iamacat.dangerzone_iamacatfr.items.DeadIrukandji(OreSpawnMain.BaseItemID + 258).setUnlocalizedName("deadirukandji");

            MyGreenFish = new ItemGenericFish(BaseItemID + 191, 3, 0.5f, false)
                .setUnlocalizedName("greenfish");
            MyBlueFish = new ItemGenericFish(BaseItemID + 192, 4, 0.4f, false) .setUnlocalizedName("bluefish");
            MyPinkFish = new ItemGenericFish(BaseItemID + 193, 4, 0.6f, false)
                .setUnlocalizedName("pinkfish");
            MyRockFish = new ItemGenericFish(BaseItemID + 194, 3, 0.7f, false)
                .setUnlocalizedName("rockfish");
            MyWoodFish = new ItemGenericFish(BaseItemID + 195, 5, 0.7f, false)
                .setUnlocalizedName("woodfish");
            MyGreyFish = new ItemGenericFish(BaseItemID + 196, 5, 0.5f, false)
                .setUnlocalizedName("greyfish");
            Sifter = new ItemSifter(BaseItemID + 325).setUnlocalizedName("sifter");
            MySquidZooka = new ItemSquidZooka(BaseItemID + 317)
                .setUnlocalizedName("squidzookasmall");
            BerthaHandle = new ItemSalt(BaseItemID + 406).setUnlocalizedName("bbhandle");
            BerthaGuard = new ItemSalt(BaseItemID + 407).setUnlocalizedName("bbguard");
            BerthaBlade = new ItemSalt(BaseItemID + 408).setUnlocalizedName("bbblade");
            MolenoidNose = new ItemSalt(BaseItemID + 409).setUnlocalizedName("molenoidnose");
            SeaMonsterScale = new ItemSalt(BaseItemID + 410)
                .setUnlocalizedName("seamonsterscale");
            WormTooth = new ItemSalt(BaseItemID + 411).setUnlocalizedName("wormtooth");
            TRexTooth = new ItemSalt(BaseItemID + 412).setUnlocalizedName("trextooth");
            CaterKillerJaw = new ItemSalt(BaseItemID + 413).setUnlocalizedName("caterkillerjaw");
            SeaViperTongue = new ItemSalt(BaseItemID + 414).setUnlocalizedName("seavipertongue");
            VortexEye = new ItemSalt(BaseItemID + 415).setUnlocalizedName("vortexeye");
            armorULTIMATE = EnumHelper.addArmorMaterial(
                "ULTIMATE",
                Ultimate_armorstats.durability,
                new int[] { Ultimate_armorstats.head_protection,
                    Ultimate_armorstats.chest_protection, Ultimate_armorstats.leg_protection,
                    Ultimate_armorstats.boot_protection },
                Ultimate_armorstats.enchantability);
            armorMOBZILLA = EnumHelper.addArmorMaterial(
                "MOBZILLA",
                Mobzilla_armorstats.durability,
                new int[] { Mobzilla_armorstats.head_protection,
                    Mobzilla_armorstats.chest_protection, Mobzilla_armorstats.leg_protection,
                    Mobzilla_armorstats.boot_protection },
                Mobzilla_armorstats.enchantability);
            armorLAVAEEL = EnumHelper.addArmorMaterial(
                "LAVAEEL",
                LavaEel_armorstats.durability,
                new int[] { LavaEel_armorstats.head_protection,
                    LavaEel_armorstats.chest_protection, LavaEel_armorstats.leg_protection,
                    LavaEel_armorstats.boot_protection },
                LavaEel_armorstats.enchantability);
            armorMOTHSCALE = EnumHelper.addArmorMaterial(
                "MOTHSCALE",
                MothScale_armorstats.durability,
                new int[] { MothScale_armorstats.head_protection,
                    MothScale_armorstats.chest_protection, MothScale_armorstats.leg_protection,
                    MothScale_armorstats.boot_protection },
                MothScale_armorstats.enchantability);
            armorEMERALD = EnumHelper.addArmorMaterial(
                "EMERALD",
                Emerald_armorstats.durability,
                new int[] { Emerald_armorstats.head_protection,
                    Emerald_armorstats.chest_protection, Emerald_armorstats.leg_protection,
                    Emerald_armorstats.boot_protection },
                Emerald_armorstats.enchantability);
            armorEXPERIENCE = EnumHelper.addArmorMaterial(
                "EXPERIENCE",
                Experience_armorstats.durability,
                new int[] { Experience_armorstats.head_protection,
                    Experience_armorstats.chest_protection, Experience_armorstats.leg_protection,
                    Experience_armorstats.boot_protection },
                Experience_armorstats.enchantability);
            armorRUBY = EnumHelper.addArmorMaterial(
                "RUBY",
                Ruby_armorstats.durability,
                new int[] { Ruby_armorstats.head_protection, Ruby_armorstats.chest_protection,
                    Ruby_armorstats.leg_protection, Ruby_armorstats.boot_protection },
                Ruby_armorstats.enchantability);
            armorAMETHYST = EnumHelper.addArmorMaterial(
                "AMETHYST",
                Amethyst_armorstats.durability,
                new int[] { Amethyst_armorstats.head_protection,
                    Amethyst_armorstats.chest_protection, Amethyst_armorstats.leg_protection,
                    Amethyst_armorstats.boot_protection },
                Amethyst_armorstats.enchantability);
            armorPINK = EnumHelper.addArmorMaterial(
                "PINK",
                Pink_armorstats.durability,
                new int[] { Pink_armorstats.head_protection, Pink_armorstats.chest_protection,
                    Pink_armorstats.leg_protection, Pink_armorstats.boot_protection },
                Pink_armorstats.enchantability);
            armorTIGERSEYE = EnumHelper.addArmorMaterial(
                "TIGERSEYE",
                TigersEye_armorstats.durability,
                new int[] { TigersEye_armorstats.head_protection,
                    TigersEye_armorstats.chest_protection, TigersEye_armorstats.leg_protection,
                    TigersEye_armorstats.boot_protection },
                TigersEye_armorstats.enchantability);
            armorPEACOCK = EnumHelper.addArmorMaterial(
                "PEACOCK",
                Peacock_armorstats.durability,
                new int[] { Peacock_armorstats.head_protection,
                    Peacock_armorstats.chest_protection, Peacock_armorstats.leg_protection,
                    Peacock_armorstats.boot_protection },
                Peacock_armorstats.enchantability);
            armorROYAL = EnumHelper.addArmorMaterial(
                "ROYAL",
                Royal_armorstats.durability,
                new int[] { Royal_armorstats.head_protection, Royal_armorstats.chest_protection,
                    Royal_armorstats.leg_protection, Royal_armorstats.boot_protection },
                Royal_armorstats.enchantability);
            armorLAPIS = EnumHelper.addArmorMaterial(
                "LAPIS",
                Lapis_armorstats.durability,
                new int[] { Lapis_armorstats.head_protection, Lapis_armorstats.chest_protection,
                    Lapis_armorstats.leg_protection, Lapis_armorstats.boot_protection },
                Lapis_armorstats.enchantability);
            armorQUEEN = EnumHelper.addArmorMaterial(
                "QUEEN",
                Queen_armorstats.durability,
                new int[] { Queen_armorstats.head_protection, Queen_armorstats.chest_protection,
                    Queen_armorstats.leg_protection, Queen_armorstats.boot_protection },
                Queen_armorstats.enchantability);
            UltimateHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 309,
                armorULTIMATE,
                packetproxy.setArmorPrefix("ultimate"),
                0).setUnlocalizedName("ultimate_helmet");
            UltimateBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 310,
                armorULTIMATE,
                packetproxy.setArmorPrefix("ultimate"),
                1).setUnlocalizedName("ultimate_chest");
            UltimateLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 311,
                armorULTIMATE,
                packetproxy.setArmorPrefix("ultimate"),
                2).setUnlocalizedName("ultimate_leggings");
            UltimateBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 312,
                armorULTIMATE,
                packetproxy.setArmorPrefix("ultimate"),
                3).setUnlocalizedName("ultimate_boots");
            LavaEelHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 298,
                armorLAVAEEL,
                packetproxy.setArmorPrefix("lavaeel"),
                0).setUnlocalizedName("lavaeel_helmet");
            LavaEelBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 299,
                armorLAVAEEL,
                packetproxy.setArmorPrefix("lavaeel"),
                1).setUnlocalizedName("lavaeel_chest");
            LavaEelLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 300,
                armorLAVAEEL,
                packetproxy.setArmorPrefix("lavaeel"),
                2).setUnlocalizedName("lavaeel_leggings");
            LavaEelBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 301,
                armorLAVAEEL,
                packetproxy.setArmorPrefix("lavaeel"),
                3).setUnlocalizedName("lavaeel_boots");
            MothScaleHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 294,
                armorMOTHSCALE,
                packetproxy.setArmorPrefix("mothscale"),
                0).setUnlocalizedName("mothscale_helmet");
            MothScaleBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 295,
                armorMOTHSCALE,
                packetproxy.setArmorPrefix("mothscale"),
                1).setUnlocalizedName("mothscale_chest");
            MothScaleLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 296,
                armorMOTHSCALE,
                packetproxy.setArmorPrefix("mothscale"),
                2).setUnlocalizedName("mothscale_leggings");
            MothScaleBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 297,
                armorMOTHSCALE,
                packetproxy.setArmorPrefix("mothscale"),
                3).setUnlocalizedName("mothscale_boots");
            EmeraldHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 285,
                armorEMERALD,
                packetproxy.setArmorPrefix("emerald"),
                0).setUnlocalizedName("emerald_helmet");
            EmeraldBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 286,
                armorEMERALD,
                packetproxy.setArmorPrefix("emerald"),
                1).setUnlocalizedName("emerald_chest");
            EmeraldLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 287,
                armorEMERALD,
                packetproxy.setArmorPrefix("emerald"),
                2).setUnlocalizedName("emerald_leggings");
            EmeraldBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 288,
                armorEMERALD,
                packetproxy.setArmorPrefix("emerald"),
                3).setUnlocalizedName("emerald_boots");
            ExperienceHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 290,
                armorEXPERIENCE,
                packetproxy.setArmorPrefix("experience"),
                0).setUnlocalizedName("experience_helmet");
            ExperienceBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 291,
                armorEXPERIENCE,
                packetproxy.setArmorPrefix("experience"),
                1).setUnlocalizedName("experience_chest");
            ExperienceLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 292,
                armorEXPERIENCE,
                packetproxy.setArmorPrefix("experience"),
                2).setUnlocalizedName("experience_leggings");
            ExperienceBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 293,
                armorEXPERIENCE,
                packetproxy.setArmorPrefix("experience"),
                3).setUnlocalizedName("experience_boots");
            RubyHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 276,
                armorRUBY,
                packetproxy.setArmorPrefix("ruby"),
                0).setUnlocalizedName("ruby_helmet");
            RubyBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 277,
                armorRUBY,
                packetproxy.setArmorPrefix("ruby"),
                1).setUnlocalizedName("ruby_chest");
            RubyLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 278,
                armorRUBY,
                packetproxy.setArmorPrefix("ruby"),
                2).setUnlocalizedName("ruby_leggings");
            RubyBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 279,
                armorRUBY,
                packetproxy.setArmorPrefix("ruby"),
                3).setUnlocalizedName("ruby_boots");
            AmethystHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 266,
                armorAMETHYST,
                packetproxy.setArmorPrefix("amethyst"),
                0).setUnlocalizedName("amethyst_helmet");
            AmethystBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 267,
                armorAMETHYST,
                packetproxy.setArmorPrefix("amethyst"),
                1).setUnlocalizedName("amethyst_chest");
            AmethystLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 268,
                armorAMETHYST,
                packetproxy.setArmorPrefix("amethyst"),
                2).setUnlocalizedName("amethyst_leggings");
            AmethystBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 269,
                armorAMETHYST,
                packetproxy.setArmorPrefix("amethyst"),
                3).setUnlocalizedName("amethyst_boots");
            CrystalPinkHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 344,
                armorPINK,
                packetproxy.setArmorPrefix("pink"),
                0).setUnlocalizedName("pink_helmet");
            CrystalPinkBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 345,
                armorPINK,
                packetproxy.setArmorPrefix("pink"),
                1).setUnlocalizedName("pink_chest");
            CrystalPinkLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 346,
                armorPINK,
                packetproxy.setArmorPrefix("pink"),
                2).setUnlocalizedName("pink_leggings");
            CrystalPinkBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 347,
                armorPINK,
                packetproxy.setArmorPrefix("pink"),
                3).setUnlocalizedName("pink_boots");
            TigersEyeHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 354,
                armorTIGERSEYE,
                packetproxy.setArmorPrefix("tigerseye"),
                0).setUnlocalizedName("tigerseye_helmet");
            TigersEyeBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 355,
                armorTIGERSEYE,
                packetproxy.setArmorPrefix("tigerseye"),
                1).setUnlocalizedName("tigerseye_chest");
            TigersEyeLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 356,
                armorTIGERSEYE,
                packetproxy.setArmorPrefix("tigerseye"),
                2).setUnlocalizedName("tigerseye_leggings");
            TigersEyeBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 357,
                armorTIGERSEYE,
                packetproxy.setArmorPrefix("tigerseye"),
                3).setUnlocalizedName("tigerseye_boots");
            PeacockFeatherBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 371,
                armorPEACOCK,
                packetproxy.setArmorPrefix("peacock"),
                3).setUnlocalizedName("peacock_boots");
            PeacockFeatherHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 359,
                armorPEACOCK,
                packetproxy.setArmorPrefix("peacock"),
                0).setUnlocalizedName("peacock_helmet");
            PeacockFeatherBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 360,
                armorPEACOCK,
                packetproxy.setArmorPrefix("peacock"),
                1).setUnlocalizedName("peacock_chest");
            PeacockFeatherLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 370,
                armorPEACOCK,
                packetproxy.setArmorPrefix("peacock"),
                2).setUnlocalizedName("peacock_leggings");
            MobzillaHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 395,
                armorMOBZILLA,
                packetproxy.setArmorPrefix("mobzilla"),
                0).setUnlocalizedName("mobzilla_helmet");
            MobzillaBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 396,
                armorMOBZILLA,
                packetproxy.setArmorPrefix("mobzilla"),
                1).setUnlocalizedName("mobzilla_chest");
            MobzillaLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 397,
                armorMOBZILLA,
                packetproxy.setArmorPrefix("mobzilla"),
                2).setUnlocalizedName("mobzilla_leggings");
            MobzillaBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 398,
                armorMOBZILLA,
                packetproxy.setArmorPrefix("mobzilla"),
                3).setUnlocalizedName("mobzilla_boots");
            RoyalHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 402,
                armorROYAL,
                packetproxy.setArmorPrefix("royal"),
                0).setUnlocalizedName("royal_helmet");
            RoyalBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 403,
                armorROYAL,
                packetproxy.setArmorPrefix("royal"),
                1).setUnlocalizedName("royal_chest");
            RoyalLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 404,
                armorROYAL,
                packetproxy.setArmorPrefix("royal"),
                2).setUnlocalizedName("royal_leggings");
            RoyalBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 405,
                armorROYAL,
                packetproxy.setArmorPrefix("royal"),
                3).setUnlocalizedName("royal_boots");
            LapisHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 449,
                armorLAPIS,
                packetproxy.setArmorPrefix("lapis"),
                0).setUnlocalizedName("lapis_helmet");
            LapisBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 450,
                armorLAPIS,
                packetproxy.setArmorPrefix("lapis"),
                1).setUnlocalizedName("lapis_chest");
            LapisLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 451,
                armorLAPIS,
                packetproxy.setArmorPrefix("lapis"),
                2).setUnlocalizedName("lapis_leggings");
            LapisBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 452,
                armorLAPIS,
                packetproxy.setArmorPrefix("lapis"),
                3).setUnlocalizedName("lapis_boots");
            QueenHelmet = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 454,
                armorQUEEN,
                packetproxy.setArmorPrefix("queen"),
                0).setUnlocalizedName("queen_helmet");
            QueenBody = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 455,
                armorQUEEN,
                packetproxy.setArmorPrefix("queen"),
                1).setUnlocalizedName("queen_chest");
            QueenLegs = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 456,
                armorQUEEN,
                packetproxy.setArmorPrefix("queen"),
                2).setUnlocalizedName("queen_leggings");
            QueenBoots = (ItemOreSpawnArmor) new ItemOreSpawnArmor(
                BaseItemID + 457,
                armorQUEEN,
                packetproxy.setArmorPrefix("queen"),
                3).setUnlocalizedName("queen_boots");
            MyOreSaltBlock = new OreSalt(BaseBlockID + 100).setBlockName("oresalt");
            MySalt = new ItemSalt(BaseItemID + 178).setUnlocalizedName("salt");
            MyPopcorn = new ItemPopcorn(BaseItemID + 179, 1, 0.5f, false)
                .setUnlocalizedName("popcorn");
            MyButteredPopcorn = new ItemPopcorn(BaseItemID + 180, 2, 0.6f, false)
                .setUnlocalizedName("popcorn_buttered");
            MyButteredSaltedPopcorn = new ItemPopcorn(BaseItemID + 181, 3, 0.75f, false)
                .setUnlocalizedName("popcorn_buttered_salted");
            MyPopcornBag = new ItemPopcorn(BaseItemID + 182, 10, 1.25f, false)
                .setUnlocalizedName("popcorn_bag");
            MyButter = new ItemPopcorn(BaseItemID + 183, 1, 0.5f, false)
                .setUnlocalizedName("butter");
            MyCornDog = new ItemPopcorn(BaseItemID + 186, 16, 2.5f, false)
                .setUnlocalizedName("corndog_cooked");
            MyRawCornDog = new ItemPopcorn(BaseItemID + 187, 4, 0.6f, false)
                .setUnlocalizedName("corndog_raw");
            MyButterCandy = new ItemSunFish(BaseItemID + 188, 4, 0.5f, false)
                .setUnlocalizedName("buttercandy");
            MyBacon = new ItemSunFish(BaseItemID + 189, 14, 1.5f, false)
                .setUnlocalizedName("cookedbacon");
            MyRawBacon = new ItemPopcorn(BaseItemID + 190, 8, 1.0f, false)
                .setUnlocalizedName("bacon");
            MyCrabMeat = new ItemSunFish(BaseItemID + 480, 6, 0.75f, false)
                .setUnlocalizedName("cookedcrabmeat");
            MyRawCrabMeat = new ItemPopcorn(BaseItemID + 479, 4, 0.25f, false)
                .setUnlocalizedName("crabmeat");
            MyCheese = new ItemPopcorn(BaseItemID + 205, 4, 0.5f, false)
                .setUnlocalizedName("cheese");
            MySalad = new ItemPopcorn(BaseItemID + 200, 10, 0.95f, false)
                .setUnlocalizedName("salad");
            MyBLT = new ItemPopcorn(BaseItemID + 201, 12, 0.95f, false)
                .setUnlocalizedName("blt_sandwich");
            MyCrabbyPatty = new ItemPopcorn(BaseItemID + 481, 16, 2.35f, false)
                .setUnlocalizedName("crabbypatty");
            MyOreRubyBlock = new OreRuby(BaseBlockID + 104).setBlockName("oreruby");
            MyRuby = new ItemSalt(BaseItemID + 270).setUnlocalizedName("ruby");
            MyOreAmethystBlock = new OreAmethyst(BaseBlockID + 103).setBlockName("oreamethyst");
            MyAmethyst = new ItemSalt(BaseItemID + 260).setUnlocalizedName("amethyst");
            UraniumNugget = new ItemSalt(BaseItemID + 150).setUnlocalizedName("uranium_nugget");
            TitaniumNugget = new ItemSalt(BaseItemID + 151).setUnlocalizedName("titanium_nugget");
            CrystalStone = new OreBasicStone(BaseBlockID + 200, 2.0f, 10.0f)
                .setBlockName("crystalstone");
            CrystalCoal = new OreCrystal(BaseBlockID + 201, 0.6f, 6.0f, 20.0f)
                .setBlockName("crystalcoal");
            CrystalGrass = new CrystalGrass(BaseBlockID + 202, 0.6f, 2.0f)
                .setBlockName("crystalgrass");
            CrystalCrystal = new OreCrystalCrystal(BaseBlockID + 209, 0.4f, 12.0f, 40.0f)
                .setBlockName("crystalcrystal");
            TigersEye = new OreCrystalCrystal(BaseBlockID + 217, 0.5f, 15.0f, 60.0f)
                .setBlockName("tigerseye");
            CrystalPlanksBlock = new CrystalWood(BaseBlockID + 210, 1.5f, 4.0f)
                .setBlockName("crystalplanks");
            CrystalWorkbenchBlock = new CrystalWorkbench(BaseBlockID + 211, 1.0f, 5.0f)
                .setBlockName("crystalworkbench");
            CrystalFurnaceBlock = (CrystalFurnace) new CrystalFurnace(
                BaseBlockID + 212,
                false,
                2.0f,
                10.0f).setBlockName("crystalfurnace");
            CrystalFurnaceOnBlock = new CrystalFurnace(BaseBlockID + 213, true, 2.0f, 10.0f)
                .setBlockName("crystalfurnace");
            MyPeacock = new ItemPopcorn(BaseItemID + 207, 12, 1.4f, false)
                .setUnlocalizedName("cookedpeacock");
            MyRawPeacock = new ItemPopcorn(BaseItemID + 206, 6, 0.7f, false)
                .setUnlocalizedName("rawpeacock");
            CrystalRat = new OreBasicStone(BaseBlockID + 219, 2.5f, 14.0f)
                .setBlockName("crystalrat");
            CrystalFairy = new OreBasicStone(BaseBlockID + 220, 2.5f, 14.0f)
                .setBlockName("crystalfairy");
            RedAntTroll = new OreBasicStone(BaseBlockID + 225, 2.5f, 14.0f)
                .setBlockName("redanttroll");
            TermiteTroll = new OreBasicStone(BaseBlockID + 226, 2.5f, 14.0f)
                .setBlockName("termitetroll");
            MyRTPBlock = new RTPBlock(BaseBlockID + 105).setBlockName("blockteleport")
                .setStepSound(Block.soundTypeStone);
            MyStepUp = new StepUp(BaseItemID + 232).setUnlocalizedName("step_up");
            MyStepDown = new StepDown(BaseItemID + 233).setUnlocalizedName("step_down");
            MyStepAccross = new StepAccross(BaseItemID + 234).setUnlocalizedName("step_accross");
            MyMoleDirtBlock = new MoleDirtBlock(BaseBlockID + 123).setHardness(0.6f)
                .setBlockName("moledirt")
                .setStepSound(new Block.SoundType("gravel", 1.0f, 1.0f));
            this.initializeCagesAndEggs();
            MyStrawberry = new ItemStrawberry(BaseItemID + 184, 2, 0.65f, false)
                .setUnlocalizedName("strawberry");
            MyStrawberryPlant = new BlockStrawberry(BaseBlockID + 153);
            MyStrawberrySeed = new ItemStrawberrySeed(
                BaseItemID + 210,
                MyStrawberryPlant,
                Blocks.farmland).setUnlocalizedName("strawberry_seed");
            MyButterflyPlant = new BlockButterflyPlant(BaseBlockID + 155);
            MyButterflySeed = new ItemButterflySeed(
                BaseItemID + 212,
                MyButterflyPlant,
                Blocks.farmland).setUnlocalizedName("butterfly_seed");
            MyMothPlant = new BlockMothPlant(BaseBlockID + 156);
            MyMothSeed = new ItemMothSeed(
                BaseItemID + 213,
                MyMothPlant,
                Blocks.farmland).setUnlocalizedName("moth_seed");
            MyMosquitoPlant = new BlockMosquitoPlant(BaseBlockID + 157);
            MyMosquitoSeed = new ItemMosquitoSeed(
                BaseItemID + 214,
                MyMosquitoPlant,
                Blocks.farmland).setUnlocalizedName("mosquito_seed");
            MyFireflyPlant = new BlockFireflyPlant(BaseBlockID + 154);
            MyFireflySeed = new ItemFireflySeed(
                BaseItemID + 215,
                MyFireflyPlant,
                Blocks.farmland).setUnlocalizedName("firefly_seed");
            MyRadishPlant = new BlockRadish(BaseBlockID + 175);
            MyRadish = new ItemRadish(
                BaseItemID + 199,
                2,
                0.45f,
                MyRadishPlant,
                Blocks.farmland).setUnlocalizedName("radish");
            MyCherry = new ItemStrawberry(BaseItemID + 202, 3, 0.45f, false)
                .setUnlocalizedName("cherries");
            MyPeach = new ItemStrawberry(BaseItemID + 203, 4, 0.55f, false)
                .setUnlocalizedName("peach");
            MyCrystalApple = new ItemSunFish(BaseItemID + 208, 5, 0.85f, false)
                .setUnlocalizedName("crystalapple");
            MyLove = new ItemSunFish(BaseItemID + 485, 8, 0.95f, false)
                .setUnlocalizedName("heart");
            MyRicePlant = new BlockRice(BaseBlockID + 178);
            MyRice = new ItemRadish(
                BaseItemID + 209,
                5,
                0.65f,
                MyRicePlant,
                CrystalGrass).setUnlocalizedName("rice");
            MyElevator = new ItemElevator(BaseItemID + 235).setUnlocalizedName("elevator");
            MyCornPlant1 = new BlockCorn(BaseBlockID + 163).setBlockName("corn_0");
            MyCornPlant2 = new BlockCorn(BaseBlockID + 164).setBlockName("corn_1");
            MyCornPlant3 = new BlockCorn(BaseBlockID + 165).setBlockName("corn_2");
            MyCornPlant4 = new BlockCorn(BaseBlockID + 166).setBlockName("corn_3");
            MyCornCob = new ItemCornCob(
                BaseItemID + 185,
                6,
                0.75f,
                MyCornPlant1,
                Blocks.farmland).setUnlocalizedName("corn_seed");
            MyQuinoaPlant1 = new BlockQuinoa(BaseBlockID + 179).setBlockName("quinoa_0");
            MyQuinoaPlant2 = new BlockQuinoa(BaseBlockID + 180).setBlockName("quinoa_1");
            MyQuinoaPlant3 = new BlockQuinoa(BaseBlockID + 181).setBlockName("quinoa_2");
            MyQuinoaPlant4 = new BlockQuinoa(BaseBlockID + 182).setBlockName("quinoa_3");
            MyQuinoa = new ItemCornCob(
                BaseItemID + 224,
                7,
                0.85f,
                MyQuinoaPlant1,
                CrystalGrass).setUnlocalizedName("quinoa");
            MyTomatoPlant1 = new BlockTomato(BaseBlockID + 167).setBlockName("tomato_0");
            MyTomatoPlant2 = new BlockTomato(BaseBlockID + 168).setBlockName("tomato_1");
            MyTomatoPlant3 = new BlockTomato(BaseBlockID + 169).setBlockName("tomato_2");
            MyTomatoPlant4 = new BlockTomato(BaseBlockID + 170).setBlockName("tomato_3");
            MyTomato = new ItemTomato(
                BaseItemID + 197,
                4,
                0.55f,
                MyTomatoPlant1,
                Blocks.farmland).setUnlocalizedName("tomato_seed");
            MyLettucePlant1 = new BlockLettuce(BaseBlockID + 171).setBlockName("lettuce_0");
            MyLettucePlant2 = new BlockLettuce(BaseBlockID + 172).setBlockName("lettuce_1");
            MyLettucePlant3 = new BlockLettuce(BaseBlockID + 173).setBlockName("lettuce_2");
            MyLettucePlant4 = new BlockLettuce(BaseBlockID + 174).setBlockName("lettuce_3");
            MyLettuce = new ItemLettuce(
                BaseItemID + 198,
                3,
                0.45f,
                MyLettucePlant1,
                Blocks.farmland).setUnlocalizedName("lettuce_seed");
            MagicApple = new ItemMagicApple(BaseItemID + 236).setUnlocalizedName("magicapple");
            MinersDream = new ItemMinersDream(BaseItemID + 237).setUnlocalizedName("minersdream");
            ExtremeTorch = new BlockExtremeTorch(BaseBlockID + 192).setLightLevel(1.0f)
                .setBlockName("extremetorch");
            KrakenRepellent = new KrakenRepellent(BaseBlockID + 190).setLightLevel(0.8f)
                .setBlockName("krakenrepellent");
            MyIslandBlock = new IslandBlock(BaseBlockID + 193).setLightLevel(0.9f)
                .setBlockName("island");
            CreeperRepellent = new CreeperRepellent(BaseBlockID + 191).setLightLevel(0.8f)
                .setBlockName("creeperrepellent");
            ZooCage2 = new ZooCage(BaseItemID + 320, 3).setUnlocalizedName("zoo2");
            ZooCage4 = new ZooCage(BaseItemID + 321, 5).setUnlocalizedName("zoo4");
            ZooCage6 = new ZooCage(BaseItemID + 322, 9).setUnlocalizedName("zoo6");
            ZooCage8 = new ZooCage(BaseItemID + 323, 13).setUnlocalizedName("zoo8");
            ZooCage10 = new ZooCage(BaseItemID + 324, 17).setUnlocalizedName("zoo10");
            InstantShelter = new InstantShelter(BaseItemID + 327)
                .setUnlocalizedName("instantshelter");
            InstantGarden = new InstantGarden(BaseItemID + 328)
                .setUnlocalizedName("instantgarden");
            CrystalTorch = new BlockCrystalTorch(BaseBlockID + 214).setLightLevel(0.99f)
                .setBlockName("crystaltorch");
            MyKingSpawnerBlock = new KingSpawnerBlock(BaseBlockID + 195).setLightLevel(0.9f)
                .setBlockName("kingspawner");
            MyQueenSpawnerBlock = new QueenSpawnerBlock(BaseBlockID + 197).setLightLevel(0.9f)
                .setBlockName("queenspawner");
            RandomDungeon = new ItemRandomDungeon(BaseItemID + 421)
                .setUnlocalizedName("randomdungeon");
            MyDungeonSpawnerBlock = new DungeonSpawnerBlock(BaseBlockID + 196).setLightLevel(0.9f)
                .setBlockName("dungeonspawner");
            MyAppleLeaves = new BlockAppleLeaves(BaseBlockID + 150).setHardness(0.2f)
                .setLightOpacity(1)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("leaves_apple");
            MyAppleSeed = new ItemAppleSeed(BaseItemID + 211)
                .setUnlocalizedName("appletree_seed");
            MySkyTreeLog = new BlockSkyTreeLog(BaseBlockID + 113, 20).setHardness(0.2f)
                .setStepSound(Block.soundTypeWood)
                .setBlockName("skytreelog");
            MyDT = new BlockDuplicatorLog(BaseBlockID + 114).setHardness(0.2f)
                .setStepSound(Block.soundTypeWood)
                .setBlockName("duplicatortreelog");
            MyExperienceLeaves = new BlockExperienceLeaves(BaseBlockID + 151).setHardness(0.2f)
                .setLightOpacity(1)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("leaves_experience");
            MyExperienceCatcher = new ExperienceCatcher(BaseItemID + 238)
                .setUnlocalizedName("experiencecatcher");
            MyExperienceTreeSeed = new ItemExperienceTreeSeed(BaseItemID + 216)
                .setUnlocalizedName("experiencetree_seed");
            MyExperiencePlant = new BlockExperiencePlant(BaseBlockID + 158)
                .setBlockName("experiencesapling");
            MyDeadStinkBug = new ItemSalt(BaseItemID + 155).setUnlocalizedName("deadstinkbug");
            MyFlowerPinkBlock = new MyBlockFlower(BaseBlockID + 159).setHardness(0.0f)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("flower_pink");
            MyFlowerBlueBlock = new MyBlockFlower(BaseBlockID + 160).setHardness(0.0f)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("flower_blue");
            MyFlowerBlackBlock = new MyBlockFlower(BaseBlockID + 161).setHardness(0.0f)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("flower_black");
            MyFlowerScaryBlock = new MyBlockFlower(BaseBlockID + 162).setHardness(0.0f)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("flower_scary");
            MyScaryLeaves = new BlockScaryLeaves(BaseBlockID + 152).setHardness(0.2f)
                .setLightOpacity(1)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("leaves_scary");
            MyCherryLeaves = new BlockScaryLeaves(BaseBlockID + 176).setHardness(0.15f)
                .setLightOpacity(1)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("leaves_cherry");
            MyPeachLeaves = new BlockScaryLeaves(BaseBlockID + 177).setHardness(0.15f)
                .setLightOpacity(1)
                .setStepSound(Block.soundTypeGrass)
                .setBlockName("leaves_peach");
            MyCherrySeed = new ItemAppleSeed(BaseItemID + 217)
                .setUnlocalizedName("cherrytree_seed");
            MyPeachSeed = new ItemAppleSeed(BaseItemID + 218)
                .setUnlocalizedName("peachtree_seed");
            CrystalFlowerRedBlock = new MyBlockFlower(BaseBlockID + 203).setHardness(0.0f)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystalflower_red");
            CrystalFlowerGreenBlock = new MyBlockFlower(BaseBlockID + 204).setHardness(0.0f)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystalflower_green");
            CrystalFlowerBlueBlock = new MyBlockFlower(BaseBlockID + 205).setHardness(0.0f)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystalflower_blue");
            CrystalFlowerYellowBlock = new MyBlockFlower(BaseBlockID + 206).setHardness(0.0f)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystalflower_yellow");
            MyCrystalLeaves = new BlockCrystalLeaves(BaseBlockID + 208).setHardness(0.2f)
                .setLightOpacity(1)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystaltreeleaves");
            MyCrystalTreeLog = new BlockCrystalTreeLog(BaseBlockID + 207, 20).setHardness(0.2f)
                .setStepSound(new Block.SoundType("wood", 1.0f, 1.0f))
                .setBlockName("crystaltreelog");
            MyCrystalLeaves2 = new BlockCrystalLeaves(BaseBlockID + 215).setHardness(0.25f)
                .setLightOpacity(1)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystaltreeleaves2");
            MyCrystalLeaves3 = new BlockCrystalLeaves(BaseBlockID + 221).setHardness(0.25f)
                .setLightOpacity(1)
                .setStepSound(new Block.SoundType("grass", 1.0f, 1.0f))
                .setBlockName("crystaltreeleaves3");
            MyCrystalPlant = new BlockCrystalPlant(BaseBlockID + 222)
                .setBlockName("crystalsapling");
            MyCrystalPlant2 = new BlockCrystalPlant(BaseBlockID + 223)
                .setBlockName("crystalsapling2");
            MyCrystalPlant3 = new BlockCrystalPlant(BaseBlockID + 224)
                .setBlockName("crystalsapling3");
            MyEnderPearlBlock = new OreGenericEgg(BaseBlockID + 111)
                .setBlockName("blockenderpearl");
            MyEyeOfEnderBlock = new OreGenericEgg(BaseBlockID + 112)
                .setBlockName("blockeyeofender");
            this.make_some_more_things();
        }

        private void make_some_more_things() {
            GameRegistry.registerBlock(MySpiderSpawnBlock, "OreSpawn_SpiderSpawnBlock");
            GameRegistry.registerBlock(MyBatSpawnBlock, "OreSpawn_BatSpawnBlock");
            GameRegistry.registerBlock(MyCowSpawnBlock, "OreSpawn_CowSpawnBlock");
            GameRegistry.registerBlock(MyPigSpawnBlock, "OreSpawn_PigSpawnBlock");
            GameRegistry.registerBlock(MySquidSpawnBlock, "OreSpawn_SquidSpawnBlock");
            GameRegistry.registerBlock(MyChickenSpawnBlock, "OreSpawn_ChickenSpawnBlock");
            GameRegistry.registerBlock(MyCreeperSpawnBlock, "OreSpawn_CreeperSpawnBlock");
            GameRegistry.registerBlock(MySkeletonSpawnBlock, "OreSpawn_SkeletonSpawnBlock");
            GameRegistry.registerBlock(MyZombieSpawnBlock, "OreSpawn_ZombieSpawnBlock");
            GameRegistry.registerBlock(MySlimeSpawnBlock, "OreSpawn_SlimeSpawnBlock");
            GameRegistry.registerBlock(MyGhastSpawnBlock, "OreSpawn_GhastSpawnBlock");
            GameRegistry.registerBlock(MyZombiePigmanSpawnBlock, "OreSpawn_ZombiePigmanSpawnBlock");
            GameRegistry.registerBlock(MyEndermanSpawnBlock, "OreSpawn_EndermanSpawnBlock");
            GameRegistry.registerBlock(MyCaveSpiderSpawnBlock, "OreSpawn_CaveSpiderSpawnBlock");
            GameRegistry.registerBlock(MySilverfishSpawnBlock, "OreSpawn_SilverfishSpawnBlock");
            GameRegistry.registerBlock(MyMagmaCubeSpawnBlock, "OreSpawn_MagmaCubeSpawnBlock");
            GameRegistry.registerBlock(MyWitchSpawnBlock, "OreSpawn_WitchSpawnBlock");
            GameRegistry.registerBlock(MySheepSpawnBlock, "OreSpawn_SheepSpawnBlock");
            GameRegistry.registerBlock(MyWolfSpawnBlock, "OreSpawn_WolfSpawnBlock");
            GameRegistry.registerBlock(MyMooshroomSpawnBlock, "OreSpawn_MooshroomSpawnBlock");
            GameRegistry.registerBlock(MyWitherBossSpawnBlock, "OreSpawn_WitherBossSpawnBlock");
            GameRegistry.registerBlock(MyGirlfriendSpawnBlock, "OreSpawn_GirlfriendSpawnBlock");
            GameRegistry.registerBlock(MyBoyfriendSpawnBlock, "OreSpawn_BoyfriendSpawnBlock");
            GameRegistry.registerBlock(MyRedCowSpawnBlock, "OreSpawn_RedCowSpawnBlock");
            GameRegistry.registerBlock(MyCrystalCowSpawnBlock, "OreSpawn_CrystalCowSpawnBlock");
            GameRegistry.registerBlock(MyVillagerSpawnBlock, "OreSpawn_VillagerSpawnBlock");
            GameRegistry.registerBlock(MyGoldCowSpawnBlock, "OreSpawn_GoldCowSpawnBlock");
            GameRegistry.registerBlock(MyEnchantedCowSpawnBlock, "OreSpawn_EnchantedCowSpawnBlock");
            GameRegistry.registerBlock(MyMOTHRASpawnBlock, "OreSpawn_MOTHRASpawnBlock");
            GameRegistry.registerBlock(MyAloSpawnBlock, "OreSpawn_AloSpawnBlock");
            GameRegistry.registerBlock(MyCryoSpawnBlock, "OreSpawn_CryoSpawnBlock");
            GameRegistry.registerBlock(MyCamaSpawnBlock, "OreSpawn_CamaSpawnBlock");
            GameRegistry.registerBlock(MyVeloSpawnBlock, "OreSpawn_VeloSpawnBlock");
            GameRegistry.registerBlock(MyHydroSpawnBlock, "OreSpawn_HydroSpawnBlock");
            GameRegistry.registerBlock(MyBasilSpawnBlock, "OreSpawn_BasilSpawnBlock");
            GameRegistry.registerBlock(MyDragonflySpawnBlock, "OreSpawn_DragonflySpawnBlock");
            GameRegistry.registerBlock(MyEmperorScorpionSpawnBlock, "OreSpawn_EmperorScorpionSpawnBlock");
            GameRegistry.registerBlock(MyScorpionSpawnBlock, "OreSpawn_ScorpionSpawnBlock");
            GameRegistry.registerBlock(MyCaveFisherSpawnBlock, "OreSpawn_CaveFisherSpawnBlock");
            GameRegistry.registerBlock(MySpyroSpawnBlock, "OreSpawn_SpyroSpawnBlock");
            GameRegistry.registerBlock(MyBaryonyxSpawnBlock, "OreSpawn_BaryonyxSpawnBlock");
            GameRegistry.registerBlock(MyGammaMetroidSpawnBlock, "OreSpawn_GammaMetroidSpawnBlock");
            GameRegistry.registerBlock(MyCockateilSpawnBlock, "OreSpawn_CockateilSpawnBlock");
            GameRegistry.registerBlock(MyKyuubiSpawnBlock, "OreSpawn_KyuubiSpawnBlock");
            GameRegistry.registerBlock(MyAlienSpawnBlock, "OreSpawn_AlienSpawnBlock");
            GameRegistry.registerBlock(MyIronGolemSpawnBlock, "OreSpawn_IronGolemSpawnBlock");
            GameRegistry.registerBlock(MySnowGolemSpawnBlock, "OreSpawn_SnowGolemSpawnBlock");
            GameRegistry.registerBlock(MyEnderDragonSpawnBlock, "OreSpawn_EnderDragonSpawnBlock");
            GameRegistry.registerBlock(MyOcelotSpawnBlock, "OreSpawn_OcelotSpawnBlock");
            GameRegistry.registerBlock(MyWitherSkeletonSpawnBlock, "OreSpawn_WitherSkeletonSpawnBlock");
            GameRegistry.registerBlock(MyBlazeSpawnBlock, "OreSpawn_BlazeSpawnBlock");
            GameRegistry.registerBlock(MyAttackSquidSpawnBlock, "OreSpawn_AttackSquidSpawnBlock");
            GameRegistry.registerBlock(MyWaterDragonSpawnBlock, "OreSpawn_WaterDragonSpawnBlock");
            GameRegistry.registerBlock(MyCephadromeSpawnBlock, "OreSpawn_CephadromeSpawnBlock");
            GameRegistry.registerBlock(MyKrakenSpawnBlock, "OreSpawn_KrakenSpawnBlock");
            GameRegistry.registerBlock(MyLizardSpawnBlock, "OreSpawn_LizardSpawnBlock");
            GameRegistry.registerBlock(MyDragonSpawnBlock, "OreSpawn_DragonSpawnBlock");
            GameRegistry.registerBlock(MyBeeSpawnBlock, "OreSpawn_BeeSpawnBlock");
            GameRegistry.registerBlock(MyHorseSpawnBlock, "OreSpawn_HorseSpawnBlock");
            GameRegistry.registerBlock(MyTrooperBugSpawnBlock, "OreSpawn_TrooperBugSpawnBlock");
            GameRegistry.registerBlock(MySpitBugSpawnBlock, "OreSpawn_SpitBugSpawnBlock");
            GameRegistry.registerBlock(MyStinkBugSpawnBlock, "OreSpawn_StinkBugSpawnBlock");
            GameRegistry.registerBlock(MyOstrichSpawnBlock, "OreSpawn_OstrichSpawnBlock");
            GameRegistry.registerBlock(MyGazelleSpawnBlock, "OreSpawn_GazelleSpawnBlock");
            GameRegistry.registerBlock(MyChipmunkSpawnBlock, "OreSpawn_ChipmunkSpawnBlock");
            GameRegistry.registerBlock(MyCreepingHorrorSpawnBlock, "OreSpawn_CreepingHorrorSpawnBlock");
            GameRegistry.registerBlock(MyTerribleTerrorSpawnBlock, "OreSpawn_TerribleTerrorSpawnBlock");
            GameRegistry.registerBlock(MyCliffRacerSpawnBlock, "OreSpawn_CliffRacerSpawnBlock");
            GameRegistry.registerBlock(MyTriffidSpawnBlock, "OreSpawn_TriffidSpawnBlock");
            GameRegistry.registerBlock(MyPitchBlackSpawnBlock, "OreSpawn_PitchBlackSpawnBlock");
            GameRegistry.registerBlock(MyLurkingTerrorSpawnBlock, "OreSpawn_LurkingTerrorSpawnBlock");
            GameRegistry.registerBlock(MyGodzillaPartSpawnBlock, "OreSpawn_GodzillaPartSpawnBlock");
            GameRegistry.registerBlock(MyGodzillaSpawnBlock, "OreSpawn_GodzillaSpawnBlock");
            GameRegistry.registerBlock(MyTheKingPartSpawnBlock, "OreSpawn_TheKingPartSpawnBlock");
            GameRegistry.registerBlock(MyTheKingSpawnBlock, "OreSpawn_TheKingSpawnBlock");
            GameRegistry.registerBlock(MyTheQueenPartSpawnBlock, "OreSpawn_TheQueenPartSpawnBlock");
            GameRegistry.registerBlock(MyTheQueenSpawnBlock, "OreSpawn_TheQueenSpawnBlock");
            GameRegistry.registerBlock(MySmallWormSpawnBlock, "OreSpawn_SmallWormSpawnBlock");
            GameRegistry.registerBlock(MyMediumWormSpawnBlock, "OreSpawn_MediumWormSpawnBlock");
            GameRegistry.registerBlock(MyLargeWormSpawnBlock, "OreSpawn_LargeWormSpawnBlock");
            GameRegistry.registerBlock(MyCassowarySpawnBlock, "OreSpawn_CassowarySpawnBlock");
            GameRegistry.registerBlock(MyCloudSharkSpawnBlock, "OreSpawn_CloudSharkSpawnBlock");
            GameRegistry.registerBlock(MyGoldFishSpawnBlock, "OreSpawn_GoldFishSpawnBlock");
            GameRegistry.registerBlock(MyLeafMonsterSpawnBlock, "OreSpawn_LeafMonsterSpawnBlock");
            GameRegistry.registerBlock(MyTshirtSpawnBlock, "OreSpawn_TshirtSpawnBlock");
            GameRegistry.registerBlock(MyEnderKnightSpawnBlock, "OreSpawn_EnderKnightSpawnBlock");
            GameRegistry.registerBlock(MyEnderReaperSpawnBlock, "OreSpawn_EnderReaperSpawnBlock");
            GameRegistry.registerBlock(MyBeaverSpawnBlock, "OreSpawn_BeaverSpawnBlock");
            GameRegistry.registerBlock(MyUrchinSpawnBlock, "OreSpawn_UrchinSpawnBlock");
            GameRegistry.registerBlock(MyFlounderSpawnBlock, "OreSpawn_FlounderSpawnBlock");
            GameRegistry.registerBlock(MySkateSpawnBlock, "OreSpawn_SkateSpawnBlock");
            GameRegistry.registerBlock(MyRotatorSpawnBlock, "OreSpawn_RotatorSpawnBlock");
            GameRegistry.registerBlock(MyPeacockSpawnBlock, "OreSpawn_PeacockSpawnBlock");
            GameRegistry.registerBlock(MyFairySpawnBlock, "OreSpawn_FairySpawnBlock");
            GameRegistry.registerBlock(MyDungeonBeastSpawnBlock, "OreSpawn_DungeonBeastSpawnBlock");
            GameRegistry.registerBlock(MyVortexSpawnBlock, "OreSpawn_VortexSpawnBlock");
            GameRegistry.registerBlock(MyRatSpawnBlock, "OreSpawn_RatSpawnBlock");
            GameRegistry.registerBlock(MyWhaleSpawnBlock, "OreSpawn_WhaleSpawnBlock");
            GameRegistry.registerBlock(MyIrukandjiSpawnBlock, "OreSpawn_IrukandjiSpawnBlock");
            GameRegistry.registerBlock(MyTRexSpawnBlock, "OreSpawn_TRexSpawnBlock");
            GameRegistry.registerBlock(MyHerculesSpawnBlock, "OreSpawn_HerculesSpawnBlock");
            GameRegistry.registerBlock(MyMantisSpawnBlock, "OreSpawn_MantisSpawnBlock");
            GameRegistry.registerBlock(MyStinkySpawnBlock, "OreSpawn_StinkySpawnBlock");
            GameRegistry.registerBlock(MyEasterBunnySpawnBlock, "OreSpawn_EasterBunnySpawnBlock");
            GameRegistry.registerBlock(MyCaterKillerSpawnBlock, "OreSpawn_CaterKillerSpawnBlock");
            GameRegistry.registerBlock(MyMolenoidSpawnBlock, "OreSpawn_MolenoidSpawnBlock");
            GameRegistry.registerBlock(MySeaMonsterSpawnBlock, "OreSpawn_SeaMonsterSpawnBlock");
            GameRegistry.registerBlock(MySeaViperSpawnBlock, "OreSpawn_SeaViperSpawnBlock");
            GameRegistry.registerBlock(MyLeonSpawnBlock, "OreSpawn_LeonSpawnBlock");
            GameRegistry.registerBlock(MyHammerheadSpawnBlock, "OreSpawn_HammerheadSpawnBlock");
            GameRegistry.registerBlock(MyRubberDuckySpawnBlock, "OreSpawn_RubberDuckySpawnBlock");
            GameRegistry.registerBlock(MyCriminalSpawnBlock, "OreSpawn_CriminalSpawnBlock");
            GameRegistry.registerBlock(MyBrutalflySpawnBlock, "OreSpawn_BrutalflySpawnBlock");
            GameRegistry.registerBlock(MyNastysaurusSpawnBlock, "OreSpawn_NastysaurusSpawnBlock");
            GameRegistry.registerBlock(MyPointysaurusSpawnBlock, "OreSpawn_PointysaurusSpawnBlock");
            GameRegistry.registerBlock(MyCricketSpawnBlock, "OreSpawn_CricketSpawnBlock");
            GameRegistry.registerBlock(MyFrogSpawnBlock, "OreSpawn_FrogSpawnBlock");
            GameRegistry.registerBlock(MySpiderDriverSpawnBlock, "OreSpawn_SpiderDriverSpawnBlock");
            GameRegistry.registerBlock(MyCrabSpawnBlock, "OreSpawn_CrabSpawnBlock");
            GameRegistry.registerBlock(MyOreSaltBlock, "OreSpawn_OreSaltBlock");
            GameRegistry.registerBlock(MyRTPBlock, "OreSpawn_RTPBlock");
            GameRegistry.registerBlock(MyMoleDirtBlock, "OreSpawn_MoleDirtBlock");
            GameRegistry.registerBlock(MyOreTitaniumBlock, "OreSpawn_OreTitaniumBlock");
            GameRegistry.registerBlock(MyOreUraniumBlock, "OreSpawn_OreUraniumBlock");
            GameRegistry.registerBlock(MyBlockTitaniumBlock, "OreSpawn_BlockTitaniumBlock");
            GameRegistry.registerBlock(MyBlockMobzillaScaleBlock, "OreSpawn_BlockMobzillaScaleBlock");
            GameRegistry.registerBlock(MyBlockUraniumBlock, "OreSpawn_BlockUraniumBlock");
            GameRegistry.registerBlock(MyLavafoamBlock, "OreSpawn_LavafoamBlock");
            GameRegistry.registerBlock(MyOreRubyBlock, "OreSpawn_OreRubyBlock");
            GameRegistry.registerBlock(MyBlockRubyBlock, "OreSpawn_BlockRubyBlock");
            GameRegistry.registerBlock(MyOreAmethystBlock, "OreSpawn_OreAmethystBlock");
            GameRegistry.registerBlock(MyBlockAmethystBlock, "OreSpawn_BlockAmethystBlock");
            GameRegistry.registerBlock(MyCrystalPinkBlock, "OreSpawn_CrystalPinkBlock");
            GameRegistry.registerBlock(MyTigersEyeBlock, "OreSpawn_TigersEyeBlock");
            GameRegistry.registerBlock(MyPizzaBlock, "OreSpawn_PizzaBlock");
            GameRegistry.registerItem(MyPizzaItem, "OreSpawn_PizzaItem");
            GameRegistry.registerBlock(MyDuctTapeBlock, "OreSpawn_DuctTapeBlock");
            GameRegistry.registerItem(MyDuctTapeItem, "OreSpawn_DuctTapeItem");
            GameRegistry.registerBlock(CrystalStone, "OreSpawn_OreCrystalStoneBlock");
            GameRegistry.registerBlock(CrystalRat, "OreSpawn_OreCrystalRatBlock");
            GameRegistry.registerBlock(RedAntTroll, "OreSpawn_OreRedAntTrollBlock");
            GameRegistry.registerBlock(TermiteTroll, "OreSpawn_OreTermiteTrollBlock");
            GameRegistry.registerBlock(CrystalFairy, "OreSpawn_OreCrystalFairyBlock");
            GameRegistry.registerBlock(CrystalCoal, "OreSpawn_OreCrystalCoalBlock");
            GameRegistry.registerBlock(CrystalGrass, "OreSpawn_OreCrystalGrassBlock");
            GameRegistry.registerBlock(CrystalCrystal, "OreSpawn_OreCrystalCrystalBlock");
            GameRegistry.registerBlock(TigersEye, "OreSpawn_OreTigersEyeBlock");
            GameRegistry.registerBlock(CrystalPlanksBlock, "OreSpawn_CrystalPlanksBlock");
            GameRegistry.registerBlock(CrystalWorkbenchBlock, "OreSpawn_CrystalWorkbenchBlock");
            GameRegistry.registerBlock(CrystalFurnaceBlock, "OreSpawn_CrystalFurnaceBlock");
            GameRegistry.registerBlock(CrystalFurnaceOnBlock, "OreSpawn_CrystalFurnaceOnBlock");
            GameRegistry.registerBlock(MyStrawberryPlant, "OreSpawn_StrawberryPlant");
            GameRegistry.registerBlock(MyRadishPlant, "OreSpawn_RadishPlant");
            GameRegistry.registerBlock(MyRicePlant, "OreSpawn_RicePlant");
            GameRegistry.registerBlock(MyButterflyPlant, "OreSpawn_ButterflyPlant");
            GameRegistry.registerBlock(MyMothPlant, "OreSpawn_MothPlant");
            GameRegistry.registerBlock(MyMosquitoPlant, "OreSpawn_MosquitoPlant");
            GameRegistry.registerBlock(MyFireflyPlant, "OreSpawn_FireflyPlant");
            GameRegistry.registerBlock(MyCornPlant1, "OreSpawn_CornPlant1");
            GameRegistry.registerBlock(MyCornPlant2, "OreSpawn_CornPlant2");
            GameRegistry.registerBlock(MyCornPlant3, "OreSpawn_CornPlant3");
            GameRegistry.registerBlock(MyCornPlant4, "OreSpawn_CornPlant4");
            GameRegistry.registerBlock(MyQuinoaPlant1, "OreSpawn_QuinoaPlant1");
            GameRegistry.registerBlock(MyQuinoaPlant2, "OreSpawn_QuinoaPlant2");
            GameRegistry.registerBlock(MyQuinoaPlant3, "OreSpawn_QuinoaPlant3");
            GameRegistry.registerBlock(MyQuinoaPlant4, "OreSpawn_QuinoaPlant4");
            GameRegistry.registerBlock(MyTomatoPlant1, "OreSpawn_TomatoPlant1");
            GameRegistry.registerBlock(MyTomatoPlant2, "OreSpawn_TomatoPlant2");
            GameRegistry.registerBlock(MyTomatoPlant3, "OreSpawn_TomatoPlant3");
            GameRegistry.registerBlock(MyTomatoPlant4, "OreSpawn_TomatoPlant4");
            GameRegistry.registerBlock(MyLettucePlant1, "OreSpawn_LettucePlant1");
            GameRegistry.registerBlock(MyLettucePlant2, "OreSpawn_LettucePlant2");
            GameRegistry.registerBlock(MyLettucePlant3, "OreSpawn_LettucePlant3");
            GameRegistry.registerBlock(MyLettucePlant4, "OreSpawn_LettucePlant4");
            GameRegistry.registerBlock(MyAppleLeaves, "OreSpawn_AppleLeaves");
            GameRegistry.registerBlock(MyExperienceLeaves, "OreSpawn_ExperienceLeaves");
            GameRegistry.registerBlock(MyScaryLeaves, "OreSpawn_ScaryLeaves");
            GameRegistry.registerBlock(MyCherryLeaves, "OreSpawn_CherryLeaves");
            GameRegistry.registerBlock(MyPeachLeaves, "OreSpawn_PeachLeaves");
            GameRegistry.registerBlock(MySkyTreeLog, "OreSpawn_SkyTreeLog");
            GameRegistry.registerBlock(MyDT, "OreSpawn_DuplicatorLog");
            GameRegistry.registerBlock(MyExperiencePlant, "OreSpawn_ExperiencePlant");
            GameRegistry.registerBlock(MyCrystalPlant, "OreSpawn_CrystalPlant");
            GameRegistry.registerBlock(MyCrystalPlant2, "OreSpawn_CrystalPlant2");
            GameRegistry.registerBlock(MyCrystalPlant3, "OreSpawn_CrystalPlant3");
            GameRegistry.registerBlock(MyFlowerPinkBlock, "OreSpawn_FlowerPink");
            GameRegistry.registerBlock(MyFlowerBlueBlock, "OreSpawn_FlowerBlue");
            GameRegistry.registerBlock(MyFlowerBlackBlock, "OreSpawn_FlowerBlack");
            GameRegistry.registerBlock(MyFlowerScaryBlock, "OreSpawn_FlowerScary");
            GameRegistry.registerBlock(CrystalFlowerRedBlock, "OreSpawn_CrystalFlowerRed");
            GameRegistry.registerBlock(CrystalFlowerGreenBlock, "OreSpawn_CrystalFlowerGreen");
            GameRegistry.registerBlock(CrystalFlowerBlueBlock, "OreSpawn_CrystalFlowerBlue");
            GameRegistry.registerBlock(CrystalFlowerYellowBlock, "OreSpawn_CrystalFlowerYellow");
            GameRegistry.registerBlock(MyCrystalLeaves, "OreSpawn_CrystalLeaves");
            GameRegistry.registerBlock(MyCrystalLeaves2, "OreSpawn_CrystalLeaves2");
            GameRegistry.registerBlock(MyCrystalLeaves3, "OreSpawn_CrystalLeaves3");
            GameRegistry.registerBlock(MyCrystalTreeLog, "OreSpawn_CrystalTreeLog");
            GameRegistry.registerBlock(ExtremeTorch, "OreSpawn_ExtremeTorch");
            GameRegistry.registerBlock(CrystalTorch, "OreSpawn_CrystalTorch");
            GameRegistry.registerBlock(KrakenRepellent, "OreSpawn_KrakenRepellent");
            GameRegistry.registerBlock(CreeperRepellent, "OreSpawn_CreeperRepellent");
            GameRegistry.registerBlock(MyIslandBlock, "OreSpawn_Island");
            GameRegistry.registerBlock(MyKingSpawnerBlock, "OreSpawn_KingSpawner");
            GameRegistry.registerBlock(MyQueenSpawnerBlock, "OreSpawn_QueenSpawner");
            GameRegistry.registerBlock(MyDungeonSpawnerBlock, "OreSpawn_DungeonSpawner");
            GameRegistry.registerBlock(MyEnderPearlBlock, "OreSpawn_EnderPearlBlock");
            GameRegistry.registerBlock(MyEyeOfEnderBlock, "OreSpawn_EyeOfEnderBlock");
            GameRegistry.registerBlock(MyAntBlock, "OreSpawn_AntBlock");
            GameRegistry.registerBlock(MyRedAntBlock, "OreSpawn_RedAntBlock");
            GameRegistry.registerBlock(TermiteBlock, "OreSpawn_TermiteBlock");
            GameRegistry.registerBlock(CrystalTermiteBlock, "OreSpawn_CrystalTermiteBlock");
            GameRegistry.registerBlock(MyRainbowAntBlock, "OreSpawn_RainbowAntBlock");
            GameRegistry.registerBlock(MyUnstableAntBlock, "OreSpawn_UnstableAntBlock");
            GameRegistry.registerItem(MyIngotUranium, "OreSpawn_IngotUranium");
            GameRegistry.registerItem(MyCrystalPinkIngot, "OreSpawn_CrystalPinkIngot");
            GameRegistry.registerItem(MyTigersEyeIngot, "OreSpawn_TigersEyeIngot");
            GameRegistry.registerItem(MyIngotTitanium, "OreSpawn_IngotTitanium");
            GameRegistry.registerItem(MyUltimateSword, "OreSpawn_UltimateSword");
            GameRegistry.registerItem(MyNightmareSword, "OreSpawn_NightmareSword");
            GameRegistry.registerItem(MyBertha, "OreSpawn_Bertha");
            GameRegistry.registerItem(MyHammy, "OreSpawn_Hammy");
            GameRegistry.registerItem(MySlice, "OreSpawn_Slice");
            GameRegistry.registerItem(MyRoyal, "OreSpawn_Royal");
            GameRegistry.registerItem(MyBattleAxe, "OreSpawn_BattleAxe");
            GameRegistry.registerItem(MyQueenBattleAxe, "OreSpawn_QueenBattleAxe");
            GameRegistry.registerItem(MyChainsaw, "OreSpawn_Chainsaw");
            GameRegistry.registerItem(MyUltimatePickaxe, "OreSpawn_UltimatePickaxe");
            GameRegistry.registerItem(MyUltimateShovel, "OreSpawn_UltimateShovel");
            GameRegistry.registerItem(MyUltimateHoe, "OreSpawn_UltimateHoe");
            GameRegistry.registerItem(MyUltimateAxe, "OreSpawn_UltimateAxe");
            GameRegistry.registerItem(MyEmeraldSword, "OreSpawn_EmeraldSword");
            GameRegistry.registerItem(MyRoseSword, "OreSpawn_RoseSword");
            GameRegistry.registerItem(MyExperienceSword, "OreSpawn_ExperienceSword");
            GameRegistry.registerItem(MyPoisonSword, "OreSpawn_PoisonSword");
            GameRegistry.registerItem(MyRatSword, "OreSpawn_RatSword");
            GameRegistry.registerItem(MyFairySword, "OreSpawn_FairySword");
            GameRegistry.registerItem(MyMantisClaw, "OreSpawn_MantisClaw");
            GameRegistry.registerItem(MyBigHammer, "OreSpawn_BigHammer");
            GameRegistry.registerItem(MyEmeraldPickaxe, "OreSpawn_EmeraldPickaxe");
            GameRegistry.registerItem(MyEmeraldShovel, "OreSpawn_EmeraldShovel");
            GameRegistry.registerItem(MyEmeraldHoe, "OreSpawn_EmeraldHoe");
            GameRegistry.registerItem(MyEmeraldAxe, "OreSpawn_EmeraldAxe");
            GameRegistry.registerItem(MyCrystalWoodSword, "OreSpawn_CrystalWoodSword");
            GameRegistry.registerItem(MyCrystalWoodPickaxe, "OreSpawn_CrystalWoodPickaxe");
            GameRegistry.registerItem(MyCrystalWoodShovel, "OreSpawn_CrystalWoodShovel");
            GameRegistry.registerItem(MyCrystalWoodHoe, "OreSpawn_CrystalWoodHoe");
            GameRegistry.registerItem(MyCrystalWoodAxe, "OreSpawn_CrystalWoodAxe");
            GameRegistry.registerItem(MyCrystalPinkSword, "OreSpawn_CrystalPinkSword");
            GameRegistry.registerItem(MyCrystalPinkPickaxe, "OreSpawn_CrystalPinkPickaxe");
            GameRegistry.registerItem(MyCrystalPinkShovel, "OreSpawn_CrystalPinkShovel");
            GameRegistry.registerItem(MyCrystalPinkHoe, "OreSpawn_CrystalPinkHoe");
            GameRegistry.registerItem(MyCrystalPinkAxe, "OreSpawn_CrystalPinkAxe");
            GameRegistry.registerItem(MyTigersEyeSword, "OreSpawn_TigersEyeSword");
            GameRegistry.registerItem(MyTigersEyePickaxe, "OreSpawn_TigersEyePickaxe");
            GameRegistry.registerItem(MyTigersEyeShovel, "OreSpawn_TigersEyeShovel");
            GameRegistry.registerItem(MyTigersEyeHoe, "OreSpawn_TigersEyeHoe");
            GameRegistry.registerItem(MyTigersEyeAxe, "OreSpawn_TigersEyeAxe");
            GameRegistry.registerItem(MyCrystalStoneSword, "OreSpawn_CrystalStoneSword");
            GameRegistry.registerItem(MyCrystalStonePickaxe, "OreSpawn_CrystalStonePickaxe");
            GameRegistry.registerItem(MyCrystalStoneShovel, "OreSpawn_CrystalStoneShovel");
            GameRegistry.registerItem(MyCrystalStoneHoe, "OreSpawn_CrystalStoneHoe");
            GameRegistry.registerItem(MyCrystalStoneAxe, "OreSpawn_CrystalStoneAxe");
            GameRegistry.registerItem(MyRubySword, "OreSpawn_RubySword");
            GameRegistry.registerItem(MyRubyPickaxe, "OreSpawn_RubyPickaxe");
            GameRegistry.registerItem(MyRubyShovel, "OreSpawn_RubyShovel");
            GameRegistry.registerItem(MyRubyHoe, "OreSpawn_RubyHoe");
            GameRegistry.registerItem(MyRubyAxe, "OreSpawn_RubyAxe");
            GameRegistry.registerItem(MyAmethystSword, "OreSpawn_AmethystSword");
            GameRegistry.registerItem(MyAmethystPickaxe, "OreSpawn_AmethystPickaxe");
            GameRegistry.registerItem(MyAmethystShovel, "OreSpawn_AmethystShovel");
            GameRegistry.registerItem(MyAmethystHoe, "OreSpawn_AmethystHoe");
            GameRegistry.registerItem(MyAmethystAxe, "OreSpawn_AmethystAxe");
            GameRegistry.registerItem(MyItemShoes, "OreSpawn_RedHeels");
            GameRegistry.registerItem(MyItemShoes_1, "OreSpawn_BlackHeels");
            GameRegistry.registerItem(MyItemShoes_2, "OreSpawn_Slippers");
            GameRegistry.registerItem(MyItemShoes_3, "OreSpawn_Boots");
            GameRegistry.registerItem(MyItemGameController, "OreSpawn_GameController");
            GameRegistry.registerItem(MyUltimateBow, "OreSpawn_UltimateBow");
            GameRegistry.registerItem(MySkateBow, "OreSpawn_SkateBow");
            GameRegistry.registerItem(MyUltimateFishingRod, "OreSpawn_UltimateFishingRod");
            GameRegistry.registerItem(MyFireFish, "OreSpawn_FireFish");
            GameRegistry.registerItem(MySunFish, "OreSpawn_SunFish");
            GameRegistry.registerItem(MyLavaEel, "OreSpawn_LavaEel");
            GameRegistry.registerItem(MyMothScale, "OreSpawn_MothScale");
            GameRegistry.registerItem(MyQueenScale, "OreSpawn_QueenScale");
            GameRegistry.registerItem(MyNightmareScale, "OreSpawn_NightmareScale");
            GameRegistry.registerItem(MyEmperorScorpionScale, "OreSpawn_EmperorScorpionScale");
            GameRegistry.registerItem(MyBasiliskScale, "OreSpawn_BasiliskScale");
            GameRegistry.registerItem(MyWaterDragonScale, "OreSpawn_WaterDragonScale");
            GameRegistry.registerItem(MyPeacockFeather, "OreSpawn_PeacockFeather");
            GameRegistry.registerItem(MyJumpyBugScale, "OreSpawn_JumpyBugScale");
            GameRegistry.registerItem(MyKrakenTooth, "OreSpawn_KrakenTooth");
            GameRegistry.registerItem(MyGodzillaScale, "OreSpawn_GodzillaScale");
            GameRegistry.registerItem(GreenGoo, "OreSpawn_GreenGoo");
            GameRegistry.registerItem(SpiderRobotKit, "OreSpawn_SpiderRobotKit");
            GameRegistry.registerItem(AntRobotKit, "OreSpawn_AntRobotKit");
            GameRegistry.registerItem(ZooKeeper, "OreSpawn_ZooKeeper");
            GameRegistry.registerItem(CreeperLauncher, "OreSpawn_CreeperLauncher");
            GameRegistry.registerItem(NetherLost, "OreSpawn_NetherLost");
            GameRegistry.registerItem(CrystalSticks, "OreSpawn_CrystalSticks");
            GameRegistry.registerItem(Sifter, "OreSpawn_Sifter");
            GameRegistry.registerItem(MySunspotUrchin, "OreSpawn_SunspotUrchin");
            GameRegistry.registerItem(MyWaterBall, "OreSpawn_WaterBall");
            GameRegistry.registerItem(MyLaserBall, "OreSpawn_LaserBall");
            GameRegistry.registerItem(MyIceBall, "OreSpawn_IceBall");
            GameRegistry.registerItem(MySmallRock, "OreSpawn_SmallRock");
            GameRegistry.registerItem(MyRock, "OreSpawn_Rock");
            GameRegistry.registerItem(MyRedRock, "OreSpawn_RedRock");
            GameRegistry.registerItem(MyCrystalRedRock, "OreSpawn_CrystalRedRock");
            GameRegistry.registerItem(MyCrystalGreenRock, "OreSpawn_CrystalGreenRock");
            GameRegistry.registerItem(MyCrystalBlueRock, "OreSpawn_CrystalBlueRock");
            GameRegistry.registerItem(MyCrystalTNTRock, "OreSpawn_CrystalTNTRock");
            GameRegistry.registerItem(MyGreenRock, "OreSpawn_GreenRock");
            GameRegistry.registerItem(MyBlueRock, "OreSpawn_BlueRock");
            GameRegistry.registerItem(MyPurpleRock, "OreSpawn_PurpleRock");
            GameRegistry.registerItem(MySpikeyRock, "OreSpawn_SpikeyRock");
            GameRegistry.registerItem(MyTNTRock, "OreSpawn_TNTRock");
            GameRegistry.registerItem(MyAcid, "OreSpawn_Acid");
            GameRegistry.registerItem(MyIrukandji, "OreSpawn_Irukandji");
            GameRegistry.registerItem(MyIrukandjiArrow, "OreSpawn_IrukandjiArrow");
            GameRegistry.registerItem(MyRayGun, "OreSpawn_RayGun");
            GameRegistry.registerItem(MySquidZooka, "OreSpawn_SquidZooka");
            GameRegistry.registerItem(MySparkFish, "OreSpawn_SparkFish");
            GameRegistry.registerItem(MySalt, "OreSpawn_Salt");
            GameRegistry.registerItem(MyPopcorn, "OreSpawn_Popcorn");
            GameRegistry.registerItem(MyButteredPopcorn, "OreSpawn_ButteredPopcorn");
            GameRegistry.registerItem(MyButteredSaltedPopcorn, "OreSpawn_ButteredSaltedPopcorn");
            GameRegistry.registerItem(MyPopcornBag, "OreSpawn_PopcornBag");
            GameRegistry.registerItem(MyButter, "OreSpawn_Butter");
            GameRegistry.registerItem(MyCornDog, "OreSpawn_CornDog");
            GameRegistry.registerItem(MyCheese, "OreSpawn_Cheese");
            GameRegistry.registerItem(MyRawCornDog, "OreSpawn_RawCornDog");
            GameRegistry.registerItem(MyPeacock, "OreSpawn_Peacock");
            GameRegistry.registerItem(MyRawPeacock, "OreSpawn_RawPeacock");
            GameRegistry.registerItem(MyRuby, "OreSpawn_Ruby");
            GameRegistry.registerItem(MyAmethyst, "OreSpawn_Amethyst");
            GameRegistry.registerItem(MyThunderStaff, "OreSpawn_ThunderStaff");
            GameRegistry.registerItem(MyWrench, "OreSpawn_Wrench");
            GameRegistry.registerItem(MyRawBacon, "OreSpawn_RawBacon");
            GameRegistry.registerItem(MyBacon, "OreSpawn_Bacon");
            GameRegistry.registerItem(MyRawCrabMeat, "OreSpawn_RawCrabMeat");
            GameRegistry.registerItem(MyCrabMeat, "OreSpawn_CrabMeat");
            GameRegistry.registerItem(MyButterCandy, "OreSpawn_ButterCandy");
            GameRegistry.registerItem(UraniumNugget, "OreSpawn_UraniumNugget");
            GameRegistry.registerItem(TitaniumNugget, "OreSpawn_TitaniumNugget");
            GameRegistry.registerItem(MyGreenFish, "OreSpawn_GreenFish");
            GameRegistry.registerItem(MyBlueFish, "OreSpawn_BlueFish");
            GameRegistry.registerItem(MyPinkFish, "OreSpawn_PinkFish");
            GameRegistry.registerItem(MyRockFish, "OreSpawn_RockFish");
            GameRegistry.registerItem(MyWoodFish, "OreSpawn_WoodFish");
            GameRegistry.registerItem(MyGreyFish, "OreSpawn_GreyFish");
            GameRegistry.registerItem(MySalad, "OreSpawn_Salad");
            GameRegistry.registerItem(MyBLT, "OreSpawn_BLT");
            GameRegistry.registerItem(MyCrabbyPatty, "OreSpawn_CrabbyPatty");
            GameRegistry.registerItem(BerthaHandle, "OreSpawn_BerthaHandle");
            GameRegistry.registerItem(BerthaGuard, "OreSpawn_BerthaGuard");
            GameRegistry.registerItem(BerthaBlade, "OreSpawn_BerthaBlade");
            GameRegistry.registerItem(MolenoidNose, "OreSpawn_MolenoidNose");
            GameRegistry.registerItem(SeaMonsterScale, "OreSpawn_SeaMonsterScale");
            GameRegistry.registerItem(WormTooth, "OreSpawn_WormTooth");
            GameRegistry.registerItem(TRexTooth, "OreSpawn_TRexTooth");
            GameRegistry.registerItem(CaterKillerJaw, "OreSpawn_CaterKillerJaw");
            GameRegistry.registerItem(SeaViperTongue, "OreSpawn_SeaViperTongue");
            GameRegistry.registerItem(VortexEye, "OreSpawn_VortexEye");
            GameRegistry.registerItem(CageEmpty, "OreSpawn_CageEmpty");
            GameRegistry.registerItem(CagedSpider, "OreSpawn_CagedSpider");
            GameRegistry.registerItem(CagedBat, "OreSpawn_CagedBat");
            GameRegistry.registerItem(CagedCow, "OreSpawn_CagedCow");
            GameRegistry.registerItem(CagedPig, "OreSpawn_CagePig");
            GameRegistry.registerItem(CagedSquid, "OreSpawn_CagedSquid");
            GameRegistry.registerItem(CagedChicken, "OreSpawn_CagedChicken");
            GameRegistry.registerItem(CagedCreeper, "OreSpawn_CagedCreeper");
            GameRegistry.registerItem(CagedSkeleton, "OreSpawn_CagedSkeleton");
            GameRegistry.registerItem(CagedZombie, "OreSpawn_CagedZombie");
            GameRegistry.registerItem(CagedSlime, "OreSpawn_CagedSlime");
            GameRegistry.registerItem(CagedGhast, "OreSpawn_CagedGhast");
            GameRegistry.registerItem(CagedZombiePigman, "OreSpawn_CagedZombiePigman");
            GameRegistry.registerItem(CagedEnderman, "OreSpawn_CagedEnderman");
            GameRegistry.registerItem(CagedCaveSpider, "OreSpawn_CagedCaveSpider");
            GameRegistry.registerItem(CagedSilverfish, "OreSpawn_CagedSilverfish");
            GameRegistry.registerItem(CagedMagmaCube, "OreSpawn_CagedMagmaCube");
            GameRegistry.registerItem(CagedWitch, "OreSpawn_CagedWitch");
            GameRegistry.registerItem(CagedSheep, "OreSpawn_CagedSheep");
            GameRegistry.registerItem(CagedWolf, "OreSpawn_CagedWolf");
            GameRegistry.registerItem(CagedMooshroom, "OreSpawn_CagedMooshroom");
            GameRegistry.registerItem(CagedOcelot, "OreSpawn_CagedOcelot");
            GameRegistry.registerItem(CagedBlaze, "OreSpawn_CagedBlaze");
            GameRegistry.registerItem(CagedGirlfriend, "OreSpawn_CagedGirlfriend");
            GameRegistry.registerItem(CagedBoyfriend, "OreSpawn_CagedBoyfriend");
            GameRegistry.registerItem(CagedWitherSkeleton, "OreSpawn_CagedWitherSkeleton");
            GameRegistry.registerItem(CagedEnderDragon, "OreSpawn_CagedEnderDragon");
            GameRegistry.registerItem(CagedSnowGolem, "OreSpawn_CagedSnowGolem");
            GameRegistry.registerItem(CagedIronGolem, "OreSpawn_CagedIronGolem");
            GameRegistry.registerItem(CagedWitherBoss, "OreSpawn_CagedWitherBoss");
            GameRegistry.registerItem(CagedRedCow, "OreSpawn_CagedRedCow");
            GameRegistry.registerItem(CagedCrystalCow, "OreSpawn_CagedCrystalCow");
            GameRegistry.registerItem(CagedVillager, "OreSpawn_CagedVillager");
            GameRegistry.registerItem(CagedGoldCow, "OreSpawn_CagedGoldCow");
            GameRegistry.registerItem(CagedEnchantedCow, "OreSpawn_CagedEnchantedCow");
            GameRegistry.registerItem(CagedMOTHRA, "OreSpawn_CagedMOTHRA");
            GameRegistry.registerItem(CagedAlo, "OreSpawn_CagedAlo");
            GameRegistry.registerItem(CagedCryo, "OreSpawn_CagedCryo");
            GameRegistry.registerItem(CagedCama, "OreSpawn_CagedCama");
            GameRegistry.registerItem(CagedVelo, "OreSpawn_CagedVelo");
            GameRegistry.registerItem(CagedHydro, "OreSpawn_CagedHydro");
            GameRegistry.registerItem(CagedBasil, "OreSpawn_CagedBasil");
            GameRegistry.registerItem(CagedDragonfly, "OreSpawn_CagedDragonfly");
            GameRegistry.registerItem(CagedEmperorScorpion, "OreSpawn_CagedEmperorScorpion");
            GameRegistry.registerItem(CagedScorpion, "OreSpawn_CagedScorpion");
            GameRegistry.registerItem(CagedCaveFisher, "OreSpawn_CagedCaveFisher");
            GameRegistry.registerItem(CagedSpyro, "OreSpawn_CagedSpyro");
            GameRegistry.registerItem(CagedBaryonyx, "OreSpawn_CagedBaryonyx");
            GameRegistry.registerItem(CagedGammaMetroid, "OreSpawn_CagedGammaMetroid");
            GameRegistry.registerItem(CagedCockateil, "OreSpawn_CagedCockateil");
            GameRegistry.registerItem(CagedKyuubi, "OreSpawn_CagedKyuubi");
            GameRegistry.registerItem(CagedAlien, "OreSpawn_CagedAlien");
            GameRegistry.registerItem(MyElevator, "OreSpawn_Elevator");
            GameRegistry.registerItem(CagedAttackSquid, "OreSpawn_CagedAttackSquid");
            GameRegistry.registerItem(CagedWaterDragon, "OreSpawn_CagedWaterDragon");
            GameRegistry.registerItem(CagedCephadrome, "OreSpawn_CagedCephadrome");
            GameRegistry.registerItem(CagedKraken, "OreSpawn_CagedKraken");
            GameRegistry.registerItem(CagedLizard, "OreSpawn_CagedLizard");
            GameRegistry.registerItem(CagedDragon, "OreSpawn_CagedDragon");
            GameRegistry.registerItem(CagedBee, "OreSpawn_CagedBee");
            GameRegistry.registerItem(CagedHorse, "OreSpawn_CagedHorse");
            GameRegistry.registerItem(CagedFirefly, "OreSpawn_CagedFirefly");
            GameRegistry.registerItem(CagedChipmunk, "OreSpawn_CagedChipmunk");
            GameRegistry.registerItem(CagedGazelle, "OreSpawn_CagedGazelle");
            GameRegistry.registerItem(CagedOstrich, "OreSpawn_CagedOstrich");
            GameRegistry.registerItem(CagedTrooper, "OreSpawn_CagedTrooper");
            GameRegistry.registerItem(CagedSpit, "OreSpawn_CagedSpit");
            GameRegistry.registerItem(CagedStink, "OreSpawn_CagedStink");
            GameRegistry.registerItem(CagedCreepingHorror, "OreSpawn_CagedCreepingHorror");
            GameRegistry.registerItem(CagedTerribleTerror, "OreSpawn_CagedTerribleTerror");
            GameRegistry.registerItem(CagedCliffRacer, "OreSpawn_CagedCliffRacer");
            GameRegistry.registerItem(CagedTriffid, "OreSpawn_CagedTriffid");
            GameRegistry.registerItem(CagedPitchBlack, "OreSpawn_CagedPitchBlack");
            GameRegistry.registerItem(CagedLurkingTerror, "OreSpawn_CagedLurkingTerror");
            GameRegistry.registerItem(CagedSmallWorm, "OreSpawn_CagedSmallWorm");
            GameRegistry.registerItem(CagedMediumWorm, "OreSpawn_CagedMediumWorm");
            GameRegistry.registerItem(CagedLargeWorm, "OreSpawn_CagedLargeWorm");
            GameRegistry.registerItem(CagedCassowary, "OreSpawn_CagedCassowary");
            GameRegistry.registerItem(CagedCloudShark, "OreSpawn_CagedCloudShark");
            GameRegistry.registerItem(CagedGoldFish, "OreSpawn_CagedGoldFish");
            GameRegistry.registerItem(CagedLeafMonster, "OreSpawn_CagedLeafMonster");
            GameRegistry.registerItem(CagedEnderKnight, "OreSpawn_CagedEnderKnight");
            GameRegistry.registerItem(CagedEnderReaper, "OreSpawn_CagedEnderReaper");
            GameRegistry.registerItem(CagedBeaver, "OreSpawn_CagedBeaver");
            GameRegistry.registerItem(CagedUrchin, "OreSpawn_CagedUrchin");
            GameRegistry.registerItem(CagedFlounder, "OreSpawn_CagedFlounder");
            GameRegistry.registerItem(CagedSkate, "OreSpawn_CagedSkate");
            GameRegistry.registerItem(CagedRotator, "OreSpawn_CagedRotator");
            GameRegistry.registerItem(CagedPeacock, "OreSpawn_CagedPeacock");
            GameRegistry.registerItem(CagedFairy, "OreSpawn_CagedFairy");
            GameRegistry.registerItem(CagedDungeonBeast, "OreSpawn_CagedDungeonBeast");
            GameRegistry.registerItem(CagedVortex, "OreSpawn_CagedVortex");
            GameRegistry.registerItem(CagedRat, "OreSpawn_CagedRat");
            GameRegistry.registerItem(CagedWhale, "OreSpawn_CagedWhale");
            GameRegistry.registerItem(CagedIrukandji, "OreSpawn_CagedIrukandji");
            GameRegistry.registerItem(CagedTRex, "OreSpawn_CagedTRex");
            GameRegistry.registerItem(CagedHercules, "OreSpawn_CagedHercules");
            GameRegistry.registerItem(CagedMantis, "OreSpawn_CagedMantis");
            GameRegistry.registerItem(CagedStinky, "OreSpawn_CagedStinky");
            GameRegistry.registerItem(CagedEasterBunny, "OreSpawn_CagedEasterBunny");
            GameRegistry.registerItem(CagedCaterKiller, "OreSpawn_CagedCaterKiller");
            GameRegistry.registerItem(CagedMolenoid, "OreSpawn_CagedMolenoid");
            GameRegistry.registerItem(CagedSeaMonster, "OreSpawn_CagedSeaMonster");
            GameRegistry.registerItem(CagedSeaViper, "OreSpawn_CagedSeaViper");
            GameRegistry.registerItem(CagedLeon, "OreSpawn_CagedLeon");
            GameRegistry.registerItem(CagedHammerhead, "OreSpawn_CagedHammerhead");
            GameRegistry.registerItem(CagedRubberDucky, "OreSpawn_CagedRubberDucky");
            GameRegistry.registerItem(CagedCriminal, "OreSpawn_CagedCriminal");
            GameRegistry.registerItem(CagedBrutalfly, "OreSpawn_CagedBrutalfly");
            GameRegistry.registerItem(CagedNastysaurus, "OreSpawn_CagedNastysaurus");
            GameRegistry.registerItem(CagedPointysaurus, "OreSpawn_CagedPointysaurus");
            GameRegistry.registerItem(CagedCricket, "OreSpawn_CagedCricket");
            GameRegistry.registerItem(CagedFrog, "OreSpawn_CagedFrog");
            GameRegistry.registerItem(CagedSpiderDriver, "OreSpawn_CagedSpiderDriver");
            GameRegistry.registerItem(CagedCrab, "OreSpawn_CagedCrab");
            GameRegistry.registerItem(MyStrawberry, "OreSpawn_Strawberry");
            GameRegistry.registerItem(MyCrystalApple, "OreSpawn_CrystalApple");
            GameRegistry.registerItem(MyLove, "OreSpawn_Love");
            GameRegistry.registerItem(MyCherry, "OreSpawn_Cherry");
            GameRegistry.registerItem(MyPeach, "OreSpawn_Peach");
            GameRegistry.registerItem(MyRadish, "OreSpawn_Radish");
            GameRegistry.registerItem(MyRice, "OreSpawn_Rice");
            GameRegistry.registerItem(MyCornCob, "OreSpawn_CornCob");
            GameRegistry.registerItem(MyQuinoa, "OreSpawn_Quinoa");
            GameRegistry.registerItem(MyTomato, "OreSpawn_Tomato");
            GameRegistry.registerItem(MyLettuce, "OreSpawn_Lettuce");
            GameRegistry.registerItem(MyStrawberrySeed, "OreSpawn_StrawberrySeed");
            GameRegistry.registerItem(MyButterflySeed, "OreSpawn_ButterflySeed");
            GameRegistry.registerItem(MyMothSeed, "OreSpawn_MothSeed");
            GameRegistry.registerItem(MyMosquitoSeed, "OreSpawn_MosquitoSeed");
            GameRegistry.registerItem(MyFireflySeed, "OreSpawn_FireflySeed");
            GameRegistry.registerItem(MagicApple, "OreSpawn_MagicApple");
            GameRegistry.registerItem(RandomDungeon, "OreSpawn_RandomDungeon");
            GameRegistry.registerItem(MinersDream, "OreSpawn_MinersDream");
            GameRegistry.registerItem(UltimateHelmet, "OreSpawn_UltimateHelmet");
            GameRegistry.registerItem(UltimateBody, "OreSpawn_UltimateBody");
            GameRegistry.registerItem(UltimateLegs, "OreSpawn_UltimateLegs");
            GameRegistry.registerItem(UltimateBoots, "OreSpawn_UltimateBoots");
            GameRegistry.registerItem(LavaEelHelmet, "OreSpawn_LavaEelHelmet");
            GameRegistry.registerItem(LavaEelBody, "OreSpawn_LavaEelBody");
            GameRegistry.registerItem(LavaEelLegs, "OreSpawn_LavaEelLegs");
            GameRegistry.registerItem(LavaEelBoots, "OreSpawn_LavaEelBoots");
            GameRegistry.registerItem(MothScaleHelmet, "OreSpawn_MothScaleHelmet");
            GameRegistry.registerItem(MothScaleBody, "OreSpawn_MothScaleBody");
            GameRegistry.registerItem(MothScaleLegs, "OreSpawn_MothScaleLegs");
            GameRegistry.registerItem(MothScaleBoots, "OreSpawn_MothScaleBoots");
            GameRegistry.registerItem(MyAppleSeed, "OreSpawn_AppleSeed");
            GameRegistry.registerItem(MyCherrySeed, "OreSpawn_CherrySeed");
            GameRegistry.registerItem(MyPeachSeed, "OreSpawn_PeachSeed");
            GameRegistry.registerItem(MyStepUp, "OreSpawn_StepUp");
            GameRegistry.registerItem(MyStepDown, "OreSpawn_StepDown");
            GameRegistry.registerItem(MyStepAccross, "OreSpawn_StepAccross");
            GameRegistry.registerItem(EmeraldHelmet, "OreSpawn_EmeraldHelmet");
            GameRegistry.registerItem(EmeraldBody, "OreSpawn_EmeraldBody");
            GameRegistry.registerItem(EmeraldLegs, "OreSpawn_EmeraldLegs");
            GameRegistry.registerItem(EmeraldBoots, "OreSpawn_EmeraldBoots");
            GameRegistry.registerItem(MyExperienceCatcher, "OreSpawn_ExperienceCatcher");
            GameRegistry.registerItem(MyDeadStinkBug, "OreSpawn_DeadStinkBug");
            GameRegistry.registerItem(MyExperienceTreeSeed, "OreSpawn_ExperienceTreeSeed");
            GameRegistry.registerItem(ExperienceHelmet, "OreSpawn_ExperienceHelmet");
            GameRegistry.registerItem(ExperienceBody, "OreSpawn_ExperienceBody");
            GameRegistry.registerItem(ExperienceLegs, "OreSpawn_ExperienceLegs");
            GameRegistry.registerItem(ExperienceBoots, "OreSpawn_ExperienceBoots");
            GameRegistry.registerItem(RubyHelmet, "OreSpawn_RubyHelmet");
            GameRegistry.registerItem(RubyBody, "OreSpawn_RubyBody");
            GameRegistry.registerItem(RubyLegs, "OreSpawn_RubyLegs");
            GameRegistry.registerItem(RubyBoots, "OreSpawn_RubyBoots");
            GameRegistry.registerItem(AmethystHelmet, "OreSpawn_AmethystHelmet");
            GameRegistry.registerItem(AmethystBody, "OreSpawn_AmethystBody");
            GameRegistry.registerItem(AmethystLegs, "OreSpawn_AmethystLegs");
            GameRegistry.registerItem(AmethystBoots, "OreSpawn_AmethystBoots");
            GameRegistry.registerItem(ZooCage2, "OreSpawn_ZooCage2");
            GameRegistry.registerItem(ZooCage4, "OreSpawn_ZooCage4");
            GameRegistry.registerItem(ZooCage6, "OreSpawn_ZooCage6");
            GameRegistry.registerItem(ZooCage8, "OreSpawn_ZooCage8");
            GameRegistry.registerItem(ZooCage10, "OreSpawn_ZooCage10");
            GameRegistry.registerItem(InstantShelter, "OreSpawn_InstantShelter");
            GameRegistry.registerItem(InstantGarden, "OreSpawn_InstantGarden");
            GameRegistry.registerItem(CrystalPinkHelmet, "OreSpawn_CrystalPinkHelmet");
            GameRegistry.registerItem(CrystalPinkBody, "OreSpawn_CrystalPinkBody");
            GameRegistry.registerItem(CrystalPinkLegs, "OreSpawn_CrystalPinkLegs");
            GameRegistry.registerItem(CrystalPinkBoots, "OreSpawn_CrystalPinkBoots");
            GameRegistry.registerItem(TigersEyeHelmet, "OreSpawn_TigersEyeHelmet");
            GameRegistry.registerItem(TigersEyeBody, "OreSpawn_TigersEyeBody");
            GameRegistry.registerItem(TigersEyeLegs, "OreSpawn_TigersEyeLegs");
            GameRegistry.registerItem(TigersEyeBoots, "OreSpawn_TigersEyeBoots");
            GameRegistry.registerItem(PeacockFeatherBoots, "OreSpawn_PeacockFeatherBoots");
            GameRegistry.registerItem(PeacockFeatherHelmet, "OreSpawn_PeacockFeatherHelmet");
            GameRegistry.registerItem(PeacockFeatherBody, "OreSpawn_PeacockFeatherBody");
            GameRegistry.registerItem(PeacockFeatherLegs, "OreSpawn_PeacockFeatherLegs");
            GameRegistry.registerItem(MobzillaHelmet, "OreSpawn_MobzillaHelmet");
            GameRegistry.registerItem(MobzillaBody, "OreSpawn_MobzillaBody");
            GameRegistry.registerItem(MobzillaLegs, "OreSpawn_MobzillaLegs");
            GameRegistry.registerItem(MobzillaBoots, "OreSpawn_MobzillaBoots");
            GameRegistry.registerItem(RoyalHelmet, "OreSpawn_RoyalHelmet");
            GameRegistry.registerItem(RoyalBody, "OreSpawn_RoyalBody");
            GameRegistry.registerItem(RoyalLegs, "OreSpawn_RoyalLegs");
            GameRegistry.registerItem(RoyalBoots, "OreSpawn_RoyalBoots");
            GameRegistry.registerItem(LapisHelmet, "OreSpawn_LapisHelmet");
            GameRegistry.registerItem(LapisBody, "OreSpawn_LapisBody");
            GameRegistry.registerItem(LapisLegs, "OreSpawn_LapisLegs");
            GameRegistry.registerItem(LapisBoots, "OreSpawn_LapisBoots");
            GameRegistry.registerItem(QueenHelmet, "OreSpawn_QueenHelmet");
            GameRegistry.registerItem(QueenBody, "OreSpawn_QueenBody");
            GameRegistry.registerItem(QueenLegs, "OreSpawn_QueenLegs");
            GameRegistry.registerItem(QueenBoots, "OreSpawn_QueenBoots");
            final ItemStack OreSpiderEggStack = new ItemStack(MySpiderSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 52),
                new ItemStack(Items.water_bucket),
                OreSpiderEggStack);
            final ItemStack OreBatEggStack = new ItemStack(MyBatSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 65),
                new ItemStack(Items.water_bucket),
                OreBatEggStack);
            final ItemStack OreCowEggStack = new ItemStack(MyCowSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 92),
                new ItemStack(Items.water_bucket),
                OreCowEggStack);
            final ItemStack OrePigEggStack = new ItemStack(MyPigSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 90),
                new ItemStack(Items.water_bucket),
                OrePigEggStack);
            final ItemStack OreSquidEggStack = new ItemStack(MySquidSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 94),
                new ItemStack(Items.water_bucket),
                OreSquidEggStack);
            final ItemStack OreChickenEggStack = new ItemStack(MyChickenSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 93),
                new ItemStack(Items.water_bucket),
                OreChickenEggStack);
            final ItemStack OreCreeperEggStack = new ItemStack(MyCreeperSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 50),
                new ItemStack(Items.water_bucket),
                OreCreeperEggStack);
            final ItemStack OreSkeletonEggStack = new ItemStack(MySkeletonSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 51),
                new ItemStack(Items.water_bucket),
                OreSkeletonEggStack);
            final ItemStack OreZombieEggStack = new ItemStack(MyZombieSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 54),
                new ItemStack(Items.water_bucket),
                OreZombieEggStack);
            final ItemStack OreSlimeEggStack = new ItemStack(MySlimeSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 55),
                new ItemStack(Items.water_bucket),
                OreSlimeEggStack);
            final ItemStack OreGhastEggStack = new ItemStack(MyGhastSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 56),
                new ItemStack(Items.water_bucket),
                OreGhastEggStack);
            final ItemStack OreZombiePigmanEggStack = new ItemStack(MyZombiePigmanSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 57),
                new ItemStack(Items.water_bucket),
                OreZombiePigmanEggStack);
            final ItemStack OreEndermanEggStack = new ItemStack(MyEndermanSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 58),
                new ItemStack(Items.water_bucket),
                OreEndermanEggStack);
            final ItemStack OreCaveSpiderEggStack = new ItemStack(MyCaveSpiderSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 59),
                new ItemStack(Items.water_bucket),
                OreCaveSpiderEggStack);
            final ItemStack OreSilverfishEggStack = new ItemStack(MySilverfishSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 60),
                new ItemStack(Items.water_bucket),
                OreSilverfishEggStack);
            final ItemStack OreMagmaCubeEggStack = new ItemStack(MyMagmaCubeSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 62),
                new ItemStack(Items.water_bucket),
                OreMagmaCubeEggStack);
            final ItemStack OreWitchEggStack = new ItemStack(MyWitchSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 66),
                new ItemStack(Items.water_bucket),
                OreWitchEggStack);
            final ItemStack OreSheepEggStack = new ItemStack(MySheepSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 91),
                new ItemStack(Items.water_bucket),
                OreSheepEggStack);
            final ItemStack OreWolfEggStack = new ItemStack(MyWolfSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 95),
                new ItemStack(Items.water_bucket),
                OreWolfEggStack);
            final ItemStack OreMooshroomEggStack = new ItemStack(MyMooshroomSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 96),
                new ItemStack(Items.water_bucket),
                OreMooshroomEggStack);
            final ItemStack OreOcelotEggStack = new ItemStack(MyOcelotSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 98),
                new ItemStack(Items.water_bucket),
                OreOcelotEggStack);
            final ItemStack OreBlazeEggStack = new ItemStack(MyBlazeSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 61),
                new ItemStack(Items.water_bucket),
                OreBlazeEggStack);
            final ItemStack OreWitherSkeletonEggStack = new ItemStack(MyWitherSkeletonSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(WitherSkeletonEgg),
                new ItemStack(Items.water_bucket),
                OreWitherSkeletonEggStack);
            final ItemStack OreEnderDragonEggStack = new ItemStack(MyEnderDragonSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(EnderDragonEgg),
                new ItemStack(Items.water_bucket),
                OreEnderDragonEggStack);
            final ItemStack OreSnowGolemEggStack = new ItemStack(MySnowGolemSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SnowGolemEgg),
                new ItemStack(Items.water_bucket),
                OreSnowGolemEggStack);
            final ItemStack OreIronGolemEggStack = new ItemStack(MyIronGolemSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(IronGolemEgg),
                new ItemStack(Items.water_bucket),
                OreIronGolemEggStack);
            final ItemStack OreWitherBossEggStack = new ItemStack(MyWitherBossSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(WitherBossEgg, 1, 64),
                new ItemStack(Items.water_bucket),
                OreWitherBossEggStack);
            final ItemStack OreGirlfriendEggStack = new ItemStack(MyGirlfriendSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(GirlfriendEgg),
                new ItemStack(Items.water_bucket),
                OreGirlfriendEggStack);
            final ItemStack OreBoyfriendEggStack = new ItemStack(MyBoyfriendSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BoyfriendEgg),
                new ItemStack(Items.water_bucket),
                OreBoyfriendEggStack);
            final ItemStack OreRedCowEggStack = new ItemStack(MyRedCowSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(RedCowEgg),
                new ItemStack(Items.water_bucket),
                OreRedCowEggStack);
            final ItemStack OreCrystalCowEggStack = new ItemStack(MyCrystalCowSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CrystalCowEgg),
                new ItemStack(Items.water_bucket),
                OreCrystalCowEggStack);
            final ItemStack OreVillagerEggStack = new ItemStack(MyVillagerSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 120),
                new ItemStack(Items.water_bucket),
                OreVillagerEggStack);
            final ItemStack OreGoldCowEggStack = new ItemStack(MyGoldCowSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(GoldCowEgg),
                new ItemStack(Items.water_bucket),
                OreGoldCowEggStack);
            final ItemStack OreEnchantedCowEggStack = new ItemStack(MyEnchantedCowSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(EnchantedCowEgg),
                new ItemStack(Items.water_bucket),
                OreEnchantedCowEggStack);
            final ItemStack OreMOTHRAEggStack = new ItemStack(MyMOTHRASpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MOTHRAEgg),
                new ItemStack(Items.water_bucket),
                OreMOTHRAEggStack);
            final ItemStack OreAloEggStack = new ItemStack(MyAloSpawnBlock);
            GameRegistry
                .addShapelessRecipe(new ItemStack(AloEgg), new ItemStack(Items.water_bucket), OreAloEggStack);
            final ItemStack OreCryoEggStack = new ItemStack(MyCryoSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CryoEgg),
                new ItemStack(Items.water_bucket),
                OreCryoEggStack);
            final ItemStack OreCamaEggStack = new ItemStack(MyCamaSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CamaEgg),
                new ItemStack(Items.water_bucket),
                OreCamaEggStack);
            final ItemStack OreVeloEggStack = new ItemStack(MyVeloSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(VeloEgg),
                new ItemStack(Items.water_bucket),
                OreVeloEggStack);
            final ItemStack OreHydroEggStack = new ItemStack(MyHydroSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(HydroEgg),
                new ItemStack(Items.water_bucket),
                OreHydroEggStack);
            final ItemStack OreBasilEggStack = new ItemStack(MyBasilSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BasilEgg),
                new ItemStack(Items.water_bucket),
                OreBasilEggStack);
            final ItemStack OreDragonflyEggStack = new ItemStack(MyDragonflySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(DragonflyEgg),
                new ItemStack(Items.water_bucket),
                OreDragonflyEggStack);
            final ItemStack OreEmperorScorpionEggStack = new ItemStack(MyEmperorScorpionSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(EmperorScorpionEgg),
                new ItemStack(Items.water_bucket),
                OreEmperorScorpionEggStack);
            final ItemStack OreScorpionEggStack = new ItemStack(MyScorpionSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ScorpionEgg),
                new ItemStack(Items.water_bucket),
                OreScorpionEggStack);
            final ItemStack OreCaveFisherEggStack = new ItemStack(MyCaveFisherSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CaveFisherEgg),
                new ItemStack(Items.water_bucket),
                OreCaveFisherEggStack);
            final ItemStack OreSpyroEggStack = new ItemStack(MySpyroSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SpyroEgg),
                new ItemStack(Items.water_bucket),
                OreSpyroEggStack);
            final ItemStack OreBaryonyxEggStack = new ItemStack(MyBaryonyxSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BaryonyxEgg),
                new ItemStack(Items.water_bucket),
                OreBaryonyxEggStack);
            final ItemStack OreGammaMetroidEggStack = new ItemStack(MyGammaMetroidSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(GammaMetroidEgg),
                new ItemStack(Items.water_bucket),
                OreGammaMetroidEggStack);
            final ItemStack OreCockateilEggStack = new ItemStack(MyCockateilSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CockateilEgg),
                new ItemStack(Items.water_bucket),
                OreCockateilEggStack);
            final ItemStack OreKyuubiEggStack = new ItemStack(MyKyuubiSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(KyuubiEgg),
                new ItemStack(Items.water_bucket),
                OreKyuubiEggStack);
            final ItemStack OreAlienEggStack = new ItemStack(MyAlienSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(AlienEgg),
                new ItemStack(Items.water_bucket),
                OreAlienEggStack);
            final ItemStack OreAttackSquidEggStack = new ItemStack(MyAttackSquidSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(AttackSquidEgg),
                new ItemStack(Items.water_bucket),
                OreAttackSquidEggStack);
            final ItemStack OreWaterDragonEggStack = new ItemStack(MyWaterDragonSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(WaterDragonEgg),
                new ItemStack(Items.water_bucket),
                OreWaterDragonEggStack);
            final ItemStack OreKrakenEggStack = new ItemStack(MyKrakenSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(KrakenEgg),
                new ItemStack(Items.water_bucket),
                OreKrakenEggStack);
            final ItemStack OreLizardEggStack = new ItemStack(MyLizardSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(LizardEgg),
                new ItemStack(Items.water_bucket),
                OreLizardEggStack);
            final ItemStack OreCephadromeEggStack = new ItemStack(MyCephadromeSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CephadromeEgg),
                new ItemStack(Items.water_bucket),
                OreCephadromeEggStack);
            final ItemStack OreDragonEggStack = new ItemStack(MyDragonSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(DragonEgg),
                new ItemStack(Items.water_bucket),
                OreDragonEggStack);
            final ItemStack OreBeeEggStack = new ItemStack(MyBeeSpawnBlock);
            GameRegistry
                .addShapelessRecipe(new ItemStack(BeeEgg), new ItemStack(Items.water_bucket), OreBeeEggStack);
            final ItemStack OreHorseEggStack = new ItemStack(MyHorseSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.spawn_egg, 1, 100),
                new ItemStack(Items.water_bucket),
                OreHorseEggStack);
            final ItemStack OreTrooperBugEggStack = new ItemStack(MyTrooperBugSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TrooperBugEgg),
                new ItemStack(Items.water_bucket),
                OreTrooperBugEggStack);
            final ItemStack OreSpitBugEggStack = new ItemStack(MySpitBugSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SpitBugEgg),
                new ItemStack(Items.water_bucket),
                OreSpitBugEggStack);
            final ItemStack OreStinkBugEggStack = new ItemStack(MyStinkBugSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(StinkBugEgg),
                new ItemStack(Items.water_bucket),
                OreStinkBugEggStack);
            final ItemStack OreOstrichEggStack = new ItemStack(MyOstrichSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(OstrichEgg),
                new ItemStack(Items.water_bucket),
                OreOstrichEggStack);
            final ItemStack OreGazelleEggStack = new ItemStack(MyGazelleSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(GazelleEgg),
                new ItemStack(Items.water_bucket),
                OreGazelleEggStack);
            final ItemStack OreChipmunkEggStack = new ItemStack(MyChipmunkSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ChipmunkEgg),
                new ItemStack(Items.water_bucket),
                OreChipmunkEggStack);
            final ItemStack OreCreepingHorrorEggStack = new ItemStack(MyCreepingHorrorSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CreepingHorrorEgg),
                new ItemStack(Items.water_bucket),
                OreCreepingHorrorEggStack);
            final ItemStack OreTerribleTerrorEggStack = new ItemStack(MyTerribleTerrorSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TerribleTerrorEgg),
                new ItemStack(Items.water_bucket),
                OreTerribleTerrorEggStack);
            final ItemStack OreCliffRacerEggStack = new ItemStack(MyCliffRacerSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CliffRacerEgg),
                new ItemStack(Items.water_bucket),
                OreCliffRacerEggStack);
            final ItemStack OreTriffidEggStack = new ItemStack(MyTriffidSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TriffidEgg),
                new ItemStack(Items.water_bucket),
                OreTriffidEggStack);
            final ItemStack OrePitchBlackEggStack = new ItemStack(MyPitchBlackSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(PitchBlackEgg),
                new ItemStack(Items.water_bucket),
                OrePitchBlackEggStack);
            final ItemStack OreLurkingTerrorEggStack = new ItemStack(MyLurkingTerrorSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(LurkingTerrorEgg),
                new ItemStack(Items.water_bucket),
                OreLurkingTerrorEggStack);
            final ItemStack OreEnderKnightEggStack = new ItemStack(MyEnderKnightSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(EnderKnightEgg),
                new ItemStack(Items.water_bucket),
                OreEnderKnightEggStack);
            final ItemStack OreEnderReaperEggStack = new ItemStack(MyEnderReaperSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(EnderReaperEgg),
                new ItemStack(Items.water_bucket),
                OreEnderReaperEggStack);
            final ItemStack OreGodzillaPartEggStack = new ItemStack(MyGodzillaPartSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyGodzillaSpawnBlock),
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack,
                OreGodzillaPartEggStack);
            final ItemStack OreGodzillaEggStack = new ItemStack(MyGodzillaSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(GodzillaEgg),
                new ItemStack(Items.water_bucket),
                OreGodzillaEggStack);
            final ItemStack OreTheKingPartEggStack = new ItemStack(MyTheKingPartSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyTheKingSpawnBlock),
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack,
                OreTheKingPartEggStack);
            final ItemStack OreTheKingEggStack = new ItemStack(MyTheKingSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TheKingEgg),
                new ItemStack(Items.water_bucket),
                OreTheKingEggStack);
            final ItemStack OreTheQueenPartEggStack = new ItemStack(MyTheQueenPartSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyTheQueenSpawnBlock),
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack,
                OreTheQueenPartEggStack);
            final ItemStack OreTheQueenEggStack = new ItemStack(MyTheQueenSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TheQueenEgg),
                new ItemStack(Items.water_bucket),
                OreTheQueenEggStack);
            final ItemStack OreSmallWormEggStack = new ItemStack(MySmallWormSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SmallWormEgg),
                new ItemStack(Items.water_bucket),
                OreSmallWormEggStack);
            final ItemStack OreMediumWormEggStack = new ItemStack(MyMediumWormSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MediumWormEgg),
                new ItemStack(Items.water_bucket),
                OreMediumWormEggStack);
            final ItemStack OreLargeWormEggStack = new ItemStack(MyLargeWormSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(LargeWormEgg),
                new ItemStack(Items.water_bucket),
                OreLargeWormEggStack);
            final ItemStack OreCassowaryEggStack = new ItemStack(MyCassowarySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CassowaryEgg),
                new ItemStack(Items.water_bucket),
                OreCassowaryEggStack);
            final ItemStack OreCloudSharkEggStack = new ItemStack(MyCloudSharkSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CloudSharkEgg),
                new ItemStack(Items.water_bucket),
                OreCloudSharkEggStack);
            final ItemStack OreGoldFishEggStack = new ItemStack(MyGoldFishSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(GoldFishEgg),
                new ItemStack(Items.water_bucket),
                OreGoldFishEggStack);

            final ItemStack OreLeafMonsterEggStack = new ItemStack(MyLeafMonsterSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(LeafMonsterEgg),
                new ItemStack(Items.water_bucket),
                OreLeafMonsterEggStack);

            final ItemStack OreTshirtEggStack = new ItemStack(MyTshirtSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TshirtEgg),
                new ItemStack(Items.water_bucket),
                OreTshirtEggStack);

            final ItemStack OreBeaverEggStack = new ItemStack(MyBeaverSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BeaverEgg),
                new ItemStack(Items.water_bucket),
                OreBeaverEggStack);

            final ItemStack OreUrchinEggStack = new ItemStack(MyUrchinSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(UrchinEgg),
                new ItemStack(Items.water_bucket),
                OreUrchinEggStack);

            final ItemStack OreFlounderEggStack = new ItemStack(MyFlounderSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(FlounderEgg),
                new ItemStack(Items.water_bucket),
                OreFlounderEggStack);

            final ItemStack OreSkateEggStack = new ItemStack(MySkateSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SkateEgg),
                new ItemStack(Items.water_bucket),
                OreSkateEggStack);

            final ItemStack OreRotatorEggStack = new ItemStack(MyRotatorSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(RotatorEgg),
                new ItemStack(Items.water_bucket),
                OreRotatorEggStack);

            final ItemStack OrePeacockEggStack = new ItemStack(MyPeacockSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(PeacockEgg),
                new ItemStack(Items.water_bucket),
                OrePeacockEggStack);

            final ItemStack OreFairyEggStack = new ItemStack(MyFairySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(FairyEgg),
                new ItemStack(Items.water_bucket),
                OreFairyEggStack);

            final ItemStack OreDungeonBeastEggStack = new ItemStack(MyDungeonBeastSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(DungeonBeastEgg),
                new ItemStack(Items.water_bucket),
                OreDungeonBeastEggStack);

            final ItemStack OreVortexEggStack = new ItemStack(MyVortexSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(VortexEgg),
                new ItemStack(Items.water_bucket),
                OreVortexEggStack);

            final ItemStack OreRatEggStack = new ItemStack(MyRatSpawnBlock);
            GameRegistry
                .addShapelessRecipe(new ItemStack(RatEgg), new ItemStack(Items.water_bucket), OreRatEggStack);

            final ItemStack OreWhaleEggStack = new ItemStack(MyWhaleSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(WhaleEgg),
                new ItemStack(Items.water_bucket),
                OreWhaleEggStack);

            final ItemStack OreIrukandjiEggStack = new ItemStack(MyIrukandjiSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(IrukandjiEgg),
                new ItemStack(Items.water_bucket),
                OreIrukandjiEggStack);

            final ItemStack OreTRexEggStack = new ItemStack(MyTRexSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TRexEgg),
                new ItemStack(Items.water_bucket),
                OreTRexEggStack);

            final ItemStack OreHerculesEggStack = new ItemStack(MyHerculesSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(HerculesEgg),
                new ItemStack(Items.water_bucket),
                OreHerculesEggStack);

            final ItemStack OreMantisEggStack = new ItemStack(MyMantisSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MantisEgg),
                new ItemStack(Items.water_bucket),
                OreMantisEggStack);

            final ItemStack OreStinkyEggStack = new ItemStack(MyStinkySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(StinkyEgg),
                new ItemStack(Items.water_bucket),
                OreStinkyEggStack);

            final ItemStack OreEasterBunnyEggStack = new ItemStack(MyEasterBunnySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(EasterBunnyEgg),
                new ItemStack(Items.water_bucket),
                OreEasterBunnyEggStack);

            final ItemStack OreCriminalEggStack = new ItemStack(MyCriminalSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CriminalEgg),
                new ItemStack(Items.water_bucket),
                OreCriminalEggStack);

            final ItemStack OreBrutalflyEggStack = new ItemStack(MyBrutalflySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BrutalflyEgg),
                new ItemStack(Items.water_bucket),
                OreBrutalflyEggStack);

            final ItemStack OreNastysaurusEggStack = new ItemStack(MyNastysaurusSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(NastysaurusEgg),
                new ItemStack(Items.water_bucket),
                OreNastysaurusEggStack);

            final ItemStack OrePointysaurusEggStack = new ItemStack(MyPointysaurusSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(PointysaurusEgg),
                new ItemStack(Items.water_bucket),
                OrePointysaurusEggStack);

            final ItemStack OreCricketEggStack = new ItemStack(MyCricketSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CricketEgg),
                new ItemStack(Items.water_bucket),
                OreCricketEggStack);

            final ItemStack OreFrogEggStack = new ItemStack(MyFrogSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(FrogEgg),
                new ItemStack(Items.water_bucket),
                OreFrogEggStack);

            final ItemStack OreSpiderDriverEggStack = new ItemStack(MySpiderDriverSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SpiderDriverEgg),
                new ItemStack(Items.water_bucket),
                OreSpiderDriverEggStack);

            final ItemStack OreCrabEggStack = new ItemStack(MyCrabSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CrabEgg),
                new ItemStack(Items.water_bucket),
                OreCrabEggStack);

            final ItemStack OreCaterKillerEggStack = new ItemStack(MyCaterKillerSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CaterKillerEgg),
                new ItemStack(Items.water_bucket),
                OreCaterKillerEggStack);

            final ItemStack OreMolenoidEggStack = new ItemStack(MyMolenoidSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MolenoidEgg),
                new ItemStack(Items.water_bucket),
                OreMolenoidEggStack);

            final ItemStack OreSeaMonsterEggStack = new ItemStack(MySeaMonsterSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SeaMonsterEgg),
                new ItemStack(Items.water_bucket),
                OreSeaMonsterEggStack);

            final ItemStack OreSeaViperEggStack = new ItemStack(MySeaViperSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(SeaViperEgg),
                new ItemStack(Items.water_bucket),
                OreSeaViperEggStack);

            final ItemStack OreRubberDuckyEggStack = new ItemStack(MyRubberDuckySpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(RubberDuckyEgg),
                new ItemStack(Items.water_bucket),
                OreRubberDuckyEggStack);

            final ItemStack OreHammerheadEggStack = new ItemStack(MyHammerheadSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(HammerheadEgg),
                new ItemStack(Items.water_bucket),
                OreHammerheadEggStack);

            final ItemStack OreLeonEggStack = new ItemStack(MyLeonSpawnBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(LeonEgg),
                new ItemStack(Items.water_bucket),
                OreLeonEggStack);

            GameRegistry
                .addShapelessRecipe(new ItemStack(CrystalPlanksBlock, 4), MyCrystalTreeLog);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CrystalWorkbenchBlock),
                CrystalPlanksBlock,
                CrystalPlanksBlock,
                CrystalPlanksBlock,
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(CrystalFurnaceBlock),
                "FFF",
                "F F",
                "FFF",
                'F',
                CrystalStone);
            GameRegistry.addRecipe(new ItemStack(Blocks.chest), "FFF", "F F", "FFF", 'F', CrystalPlanksBlock);
            GameRegistry
                .addRecipe(new ItemStack(Items.wooden_door), "FF ", "FF ", "FF ", 'F', CrystalPlanksBlock);
            GameRegistry
                .addRecipe(new ItemStack(Items.wooden_door), " FF", " FF", " FF", 'F', CrystalPlanksBlock);
            GameRegistry.addSmelting(MyOreSaltBlock, new ItemStack(MySalt, 8), 0.1f);
            GameRegistry.addSmelting(MyCornCob, new ItemStack(MyPopcorn), 0.1f);
            GameRegistry.addSmelting(MyRawCornDog, new ItemStack(MyCornDog), 0.4f);
            GameRegistry.addSmelting(MyRawBacon, new ItemStack(MyBacon), 0.2f);
            GameRegistry.addSmelting(CrystalCrystal, new ItemStack(MyCrystalPinkIngot), 0.3f);
            GameRegistry.addSmelting(TigersEye, new ItemStack(MyTigersEyeIngot), 0.3f);
            GameRegistry.addSmelting(MyRawPeacock, new ItemStack(MyPeacock), 0.4f);
            GameRegistry.addSmelting(MyRawCrabMeat, new ItemStack(MyCrabMeat), 0.2f);
            GameRegistry.addSmelting(MyGreenFish, new ItemStack(Items.cooked_fished), 0.2f);
            GameRegistry.addSmelting(MyBlueFish, new ItemStack(Items.cooked_fished), 0.2f);
            GameRegistry.addSmelting(MyPinkFish, new ItemStack(Items.cooked_fished), 0.2f);
            GameRegistry.addSmelting(MyRockFish, new ItemStack(Items.cooked_fished), 0.2f);
            GameRegistry.addSmelting(MyWoodFish, new ItemStack(Items.cooked_fished), 0.2f);
            GameRegistry.addSmelting(MyGreyFish, new ItemStack(Items.cooked_fished), 0.2f);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateSword),
                " T ",
                " U ",
                " I ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateSword),
                "T  ",
                "U  ",
                "I  ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateSword),
                "  T",
                "  U",
                "  I",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimatePickaxe),
                "TUT",
                " U ",
                " I ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateShovel),
                " U ",
                " T ",
                " I ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateShovel),
                "U  ",
                "T  ",
                "I  ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateShovel),
                "  U",
                "  T",
                "  I",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateHoe),
                "TU ",
                " I ",
                " I ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateAxe),
                "TU ",
                "TI ",
                " I ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateBow),
                " TS",
                "I S",
                " US",
                'S',
                Items.string,
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MySkateBow),
                " TS",
                "T S",
                " TS",
                'S',
                Items.string,
                'T',
                CrystalSticks);
            GameRegistry.addRecipe(
                new ItemStack(MyUltimateFishingRod),
                "  T",
                " US",
                "I S",
                'S',
                Items.string,
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyNightmareSword),
                "ODO",
                "RTR",
                "OIO",
                'I',
                Items.iron_ingot,
                'O',
                MyNightmareScale,
                'D',
                Items.diamond,
                'R',
                Items.redstone,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldSword),
                " E ",
                " E ",
                " I ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldSword),
                "  E",
                "  E",
                "  I",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyRoseSword),
                " E ",
                " E ",
                " I ",
                'I',
                Items.stick,
                'E',
                Blocks.red_flower);
            GameRegistry.addRecipe(
                new ItemStack(MyRoseSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                Blocks.red_flower);
            GameRegistry.addRecipe(
                new ItemStack(MyRoseSword),
                "  E",
                "  E",
                "  I",
                'I',
                Items.stick,
                'E',
                Blocks.red_flower);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldPickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldShovel),
                " E ",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldShovel),
                "  E",
                "  I",
                "  I",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyEmeraldAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                Items.stick,
                'E',
                Items.emerald);
            GameRegistry.addRecipe(
                new ItemStack(MyExperienceSword),
                "EEE",
                "EIE",
                "EEE",
                'I',
                MyEmeraldSword,
                'E',
                Items.experience_bottle);
            GameRegistry.addRecipe(
                new ItemStack(MyPoisonSword),
                "EEE",
                "EIE",
                "EEE",
                'I',
                MyEmeraldSword,
                'E',
                MyDeadStinkBug);
            GameRegistry.addRecipe(
                new ItemStack(MyRatSword),
                " E ",
                " E ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalRat);
            GameRegistry.addRecipe(
                new ItemStack(MyRatSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                CrystalRat);
            GameRegistry.addRecipe(
                new ItemStack(MyRatSword),
                "  E",
                "  E",
                "  I",
                'I',
                CrystalSticks,
                'E',
                CrystalRat);
            GameRegistry.addRecipe(
                new ItemStack(MyFairySword),
                " E ",
                " E ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalFairy);
            GameRegistry.addRecipe(
                new ItemStack(MyFairySword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                CrystalFairy);
            GameRegistry.addRecipe(
                new ItemStack(MyFairySword),
                "  E",
                "  E",
                "  I",
                'I',
                CrystalSticks,
                'E',
                CrystalFairy);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodSword),
                " E ",
                " E ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodSword),
                "  E",
                "  E",
                "  I",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodPickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodShovel),
                " E ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodShovel),
                "  E",
                "  I",
                "  I",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalWoodAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalPlanksBlock);
            GameRegistry.addRecipe(new ItemStack(Blocks.chest), "EEE", "E E", "EEE", 'E', CrystalPlanksBlock);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkSword),
                " E ",
                " E ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkSword),
                "  E",
                "  E",
                "  I",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkPickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkShovel),
                " E ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkShovel),
                "  E",
                "  I",
                "  I",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(new ItemStack(Items.bucket), "   ", "I I", " I ", 'I', MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeSword),
                " E ",
                " E ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeSword),
                "  E",
                "  E",
                "  I",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyePickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeShovel),
                " E ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeShovel),
                "  E",
                "  I",
                "  I",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneSword),
                " E ",
                " E ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneSword),
                "  E",
                "  E",
                "  I",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStonePickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneShovel),
                " E ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneShovel),
                "  E",
                "  I",
                "  I",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalStoneAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                CrystalSticks,
                'E',
                CrystalStone);
            GameRegistry.addRecipe(
                new ItemStack(MyRubySword),
                " E ",
                " E ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubySword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubySword),
                "  E",
                "  E",
                "  I",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubyPickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubyShovel),
                " E ",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubyShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubyShovel),
                "  E",
                "  I",
                "  I",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubyHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyRubyAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyRuby);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystSword),
                " E ",
                " E ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystSword),
                "E  ",
                "E  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystSword),
                "  E",
                "  E",
                "  I",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystPickaxe),
                "EEE",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystShovel),
                " E ",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystShovel),
                "E  ",
                "I  ",
                "I  ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystShovel),
                "  E",
                "  I",
                "  I",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystHoe),
                "EE ",
                " I ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyAmethystAxe),
                "EE ",
                "EI ",
                " I ",
                'I',
                Items.stick,
                'E',
                MyAmethyst);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyHammy),
                MyUltimateSword,
                MyUltimateSword,
                MyBigHammer,
                GreenGoo);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyBattleAxe),
                MyUltimateSword,
                MyUltimateAxe,
                GreenGoo);
            GameRegistry.addRecipe(
                new ItemStack(MyChainsaw),
                "EEE",
                "EIE",
                "EEE",
                'I',
                MyUltimateAxe,
                'E',
                Blocks.redstone_block);
            GameRegistry.addRecipe(
                new ItemStack(MyQueenBattleAxe),
                "EIE",
                "EIE",
                " I ",
                'I',
                Items.iron_ingot,
                'E',
                MyQueenScale);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyBertha),
                BerthaHandle,
                BerthaGuard,
                BerthaBlade);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BerthaHandle),
                MyRayGun,
                MyBigHammer,
                MyMantisClaw,
                MyWaterDragonScale,
                GreenGoo);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BerthaGuard),
                MolenoidNose,
                SeaMonsterScale,
                MyMothScale,
                MyBasiliskScale,
                MyNightmareScale,
                MyEmperorScorpionScale,
                MyJumpyBugScale);
            GameRegistry.addShapelessRecipe(
                new ItemStack(BerthaBlade),
                MyKrakenTooth,
                WormTooth,
                TRexTooth,
                MyUltimateSword,
                CaterKillerJaw,
                SeaViperTongue,
                VortexEye);
            GameRegistry.addShapelessRecipe(new ItemStack(MySlice), MyBertha, Items.iron_ingot);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyIrukandjiArrow),
                MyPeacockFeather,
                MyIrukandji,
                CrystalSticks);
            GameRegistry.addShapelessRecipe(
                new ItemStack(Items.bed),
                MyPeacockFeather,
                CrystalPlanksBlock,
                MyPeacockFeather,
                CrystalPlanksBlock,
                MyPeacockFeather,
                CrystalPlanksBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MySquidZooka),
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.dye,
                Items.dye,
                Items.dye,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot);
            GameRegistry.addRecipe(
                new ItemStack(MyIngotUranium),
                "UUU",
                "UUU",
                "UUU",
                'U',
                UraniumNugget);
            GameRegistry.addShapelessRecipe(
                new ItemStack(UraniumNugget, 9),
                new ItemStack(MyIngotUranium));
            GameRegistry.addRecipe(
                new ItemStack(MyIngotTitanium),
                "UUU",
                "UUU",
                "UUU",
                'U',
                TitaniumNugget);
            GameRegistry.addShapelessRecipe(
                new ItemStack(TitaniumNugget, 9),
                new ItemStack(MyIngotTitanium));
            GameRegistry.addRecipe(
                new ItemStack(MyBlockUraniumBlock),
                "UUU",
                "UUU",
                "UUU",
                'U',
                MyIngotUranium);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyIngotUranium, 9),
                new ItemStack(MyBlockUraniumBlock));
            GameRegistry.addRecipe(
                new ItemStack(MyBlockTitaniumBlock),
                "TTT",
                "TTT",
                "TTT",
                'T',
                MyIngotTitanium);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyIngotTitanium, 9),
                new ItemStack(MyBlockTitaniumBlock));
            GameRegistry.addRecipe(
                new ItemStack(MyBlockMobzillaScaleBlock),
                "TTT",
                "TTT",
                "TTT",
                'T',
                MyGodzillaScale);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyGodzillaScale, 9),
                new ItemStack(MyBlockMobzillaScaleBlock));
            GameRegistry
                .addRecipe(new ItemStack(MyBlockRubyBlock), "TTT", "TTT", "TTT", 'T', MyRuby);
            GameRegistry
                .addShapelessRecipe(new ItemStack(MyRuby, 9), new ItemStack(MyBlockRubyBlock));
            GameRegistry.addRecipe(
                new ItemStack(MyBlockAmethystBlock),
                "TTT",
                "TTT",
                "TTT",
                'T',
                MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(MyCrystalPinkBlock),
                "TTT",
                "TTT",
                "TTT",
                'T',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MyTigersEyeBlock),
                "TTT",
                "TTT",
                "TTT",
                'T',
                MyTigersEyeIngot);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyAmethyst, 9),
                new ItemStack(MyBlockAmethystBlock));
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyCrystalPinkIngot, 9),
                new ItemStack(MyCrystalPinkBlock));
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyTigersEyeIngot, 9),
                new ItemStack(MyTigersEyeBlock));
            GameRegistry
                .addRecipe(new ItemStack(MyEnderPearlBlock), "TTT", "TTT", "TTT", 'T', Items.ender_pearl);
            GameRegistry
                .addShapelessRecipe(new ItemStack(Items.ender_pearl, 9), new ItemStack(MyEnderPearlBlock));
            GameRegistry
                .addRecipe(new ItemStack(MyEyeOfEnderBlock), "TTT", "TTT", "TTT", 'T', Items.ender_eye);
            GameRegistry
                .addShapelessRecipe(new ItemStack(Items.ender_eye, 9), new ItemStack(MyEyeOfEnderBlock));
            GameRegistry.addRecipe(
                new ItemStack(MyThunderStaff),
                "DR ",
                "RR ",
                "  R",
                'D',
                Items.diamond,
                'R',
                MyRuby);
            GameRegistry.addRecipe(new ItemStack(MyWrench), "D D", " D ", " D ", 'D', Items.iron_ingot);
            final ItemStack MilkBucket = new ItemStack(Items.milk_bucket);
            final ItemStack SomePaper = new ItemStack(Items.paper);
            GameRegistry.addShapelessRecipe(new ItemStack(MyButter, 4), MilkBucket, MilkBucket);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyCheese, 2),
                MilkBucket,
                MilkBucket,
                MilkBucket,
                MilkBucket);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyButteredPopcorn),
                MyPopcorn,
                MyButter);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyButteredSaltedPopcorn),
                MyButteredPopcorn,
                MySalt);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyButteredSaltedPopcorn),
                MyPopcorn,
                MySalt,
                MyButter);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyPopcornBag),
                MyButteredSaltedPopcorn,
                MyButteredSaltedPopcorn,
                MyButteredSaltedPopcorn,
                MyButteredSaltedPopcorn,
                MyButteredSaltedPopcorn,
                MyButteredSaltedPopcorn,
                SomePaper,
                SomePaper,
                SomePaper);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyRawCornDog, 4),
                MyCornCob,
                Items.chicken,
                Items.porkchop,
                Items.stick);
            GameRegistry.addShapelessRecipe(new ItemStack(MyRawBacon, 2), MySalt, Items.porkchop);
            GameRegistry
                .addShapelessRecipe(new ItemStack(MyButterCandy, 4), MyButter, Items.sugar);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MySalad, 1),
                MyLettuce,
                MyTomato,
                MyRadish,
                Items.carrot,
                Items.bowl);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyBLT, 1),
                MyBacon,
                MyLettuce,
                MyTomato,
                MyButter,
                Items.bread);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyPizzaItem, 1),
                MyTomato,
                MyCheese,
                MyBacon,
                Items.bread);
            GameRegistry.addRecipe(
                new ItemStack(MyDuctTapeItem),
                "   ",
                "AAA",
                "RRR",
                'R',
                Items.string,
                'A',
                Items.slime_ball);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyCrabbyPatty, 1),
                MyCrabMeat,
                MyLettuce,
                MyTomato,
                Items.bread);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ZooCage2),
                Blocks.iron_block,
                Blocks.glass,
                Blocks.quartz_block);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ZooCage4),
                ZooCage2,
                Blocks.iron_block,
                Blocks.glass,
                Blocks.quartz_block);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ZooCage6),
                ZooCage4,
                Blocks.iron_block,
                Blocks.glass,
                Blocks.quartz_block);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ZooCage8),
                ZooCage6,
                Blocks.iron_block,
                Blocks.glass,
                Blocks.quartz_block);
            GameRegistry.addShapelessRecipe(
                new ItemStack(ZooCage10),
                ZooCage8,
                Blocks.iron_block,
                Blocks.glass,
                Blocks.quartz_block);
            GameRegistry.addShapelessRecipe(
                new ItemStack(InstantShelter),
                Blocks.redstone_block,
                Items.stick,
                Blocks.cobblestone);
            GameRegistry.addShapelessRecipe(
                new ItemStack(InstantGarden),
                Blocks.redstone_block,
                Items.wheat,
                Items.gunpowder);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CreeperLauncher, 4),
                Items.paper,
                Items.redstone,
                Items.stick);
            GameRegistry
                .addShapelessRecipe(new ItemStack(NetherLost, 1), Items.nether_star, Blocks.netherrack);
            GameRegistry
                .addRecipe(new ItemStack(Sifter), "RRR", "RAR", "RRR", 'R', Items.stick, 'A', Items.string);
            GameRegistry.addRecipe(
                new ItemStack(MagicApple),
                "RRR",
                "RAR",
                "RRR",
                'R',
                Blocks.redstone_block,
                'A',
                Items.apple);
            GameRegistry.addRecipe(
                new ItemStack(RandomDungeon),
                "RRR",
                "RAR",
                "RRR",
                'R',
                Blocks.redstone_block,
                'A',
                Items.coal);
            if (MinersDreamExpensive == 0) {
                GameRegistry.addRecipe(
                    new ItemStack(MinersDream),
                    "CCC",
                    "RRR",
                    "GGG",
                    'R',
                    Blocks.redstone_block,
                    'C',
                    Blocks.cactus,
                    'G',
                    Items.gunpowder);
            } else {
                GameRegistry.addRecipe(
                    new ItemStack(MinersDream),
                    "CCC",
                    "RRR",
                    "GGG",
                    'R',
                    Blocks.redstone_block,
                    'C',
                    Blocks.cactus,
                    'G',
                    Blocks.tnt);
            }
            GameRegistry.addRecipe(
                new ItemStack(MyStepUp, 8),
                "GC ",
                " C ",
                " C ",
                'C',
                Blocks.cobblestone,
                'G',
                Items.gunpowder);
            GameRegistry.addRecipe(
                new ItemStack(MyStepDown, 8),
                " C ",
                " C ",
                "GC ",
                'C',
                Blocks.cobblestone,
                'G',
                Items.gunpowder);
            GameRegistry.addRecipe(
                new ItemStack(MyStepAccross, 8),
                " C ",
                "GC ",
                " C ",
                'C',
                Blocks.cobblestone,
                'G',
                Items.gunpowder);
            GameRegistry
                .addShapelessRecipe(new ItemStack(ExtremeTorch, 4), Items.redstone, Items.stick, Items.coal);
            GameRegistry.addShapelessRecipe(new ItemStack(ExtremeTorch, 1), Items.redstone, Blocks.torch);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CrystalSticks, 6),
                CrystalPlanksBlock,
                CrystalPlanksBlock);
            GameRegistry.addShapelessRecipe(
                new ItemStack(CrystalTorch, 6),
                CrystalCoal,
                CrystalSticks);
            GameRegistry.addRecipe(
                new ItemStack(KrakenRepellent, 1),
                "D D",
                "STS",
                "D D",
                'D',
                MyDeadStinkBug,
                'T',
                ExtremeTorch,
                'S',
                Items.string);
            GameRegistry.addRecipe(
                new ItemStack(CreeperRepellent, 1),
                "D D",
                "STS",
                "D D",
                'D',
                GreenGoo,
                'T',
                ExtremeTorch,
                'S',
                Items.string);
            GameRegistry.addShapelessRecipe(new ItemStack(MyAppleSeed, 6), Items.apple);
            GameRegistry.addShapelessRecipe(new ItemStack(MyCherrySeed, 1), MyCherry);
            GameRegistry.addShapelessRecipe(new ItemStack(MyPeachSeed, 1), MyPeach);
            GameRegistry.addShapelessRecipe(
                new ItemStack(MyExperienceCatcher, 1),
                Items.glass_bottle,
                Items.stick,
                Items.string);
            GameRegistry.addRecipe(
                new ItemStack(MyExperienceTreeSeed, 1),
                "EEE",
                "EAE",
                "EEE",
                'A',
                MyAppleSeed,
                'E',
                Items.experience_bottle);

            final int hookid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(UltimateFishHook.class, "UltimateFishHook", hookid);

            final int urchinid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(SunspotUrchin.class, "SunspotUrchin", urchinid);

            EntityRegistry.registerModEntity(SunspotUrchin.class, "SunspotUrchin", urchinid, this, 64, 1, true);

            final int waterballid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(WaterBall.class, "WaterBall", waterballid);

            EntityRegistry.registerModEntity(WaterBall.class, "WaterBall", waterballid, this, 64, 1, true);

            final int inksackid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(InkSack.class, "InkSack", inksackid);

            EntityRegistry.registerModEntity(InkSack.class, "InkSack", inksackid, this, 64, 1, true);

            final int laserballid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(LaserBall.class, "LaserBall", laserballid);

            EntityRegistry.registerModEntity(LaserBall.class, "LaserBall", laserballid, this, 64, 1, true);

            final int iceballid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(IceBall.class, "IceBall", iceballid);

            EntityRegistry.registerModEntity(IceBall.class, "IceBall", iceballid, this, 64, 1, true);

            final int acidid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(fr.iamacat.dangerzone_iamacatfr.entities.entity.Acid.class, "Acid", acidid);

            EntityRegistry.registerModEntity(fr.iamacat.dangerzone_iamacatfr.entities.entity.Acid.class, "Acid", acidid, this, 64, 1, true);

            final int Irukandjiid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(fr.iamacat.dangerzone_iamacatfr.entities.entity.DeadIrukandji.class, "DeadIrukandji", Irukandjiid);

            EntityRegistry.registerModEntity(fr.iamacat.dangerzone_iamacatfr.entities.entity.DeadIrukandji.class, "DeadIrukandji", Irukandjiid, this, 64, 1, true);

            final int berthahitid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(BerthaHit.class, "BerthaHit", berthahitid);

            EntityRegistry.registerModEntity(BerthaHit.class, "BerthaHit", berthahitid, this, 64, 1, true);

            final int purplepowerid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(PurplePower.class, "PurplePower", purplepowerid);

            EntityRegistry.registerModEntity(PurplePower.class, "PurplePower", purplepowerid, this, 64, 1, true);

            final int rockid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityThrownRock.class, "EntityThrownRock", rockid);

            EntityRegistry.registerModEntity(EntityThrownRock.class, "EntityThrownRock", rockid, this, 64, 1, true);
            final ItemStack RayStack = new ItemStack(MyRayGun);
            RayStack.setItemDamage(32767);
            GameRegistry
                .addShapelessRecipe(new ItemStack(MyRayGun), new ItemStack(Blocks.redstone_block), RayStack);
            final ItemStack SquidStack = new ItemStack(MySquidZooka);
            SquidStack.setItemDamage(32767);
            GameRegistry.addShapelessRecipe(new ItemStack(MySquidZooka), new ItemStack(Items.dye), SquidStack);

            GirlfriendID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Girlfriend.class, "Girlfriend", GirlfriendID);

            EntityRegistry.registerModEntity(Girlfriend.class, "Girlfriend", GirlfriendID, this, 64, 1, false);

            RedCowID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(RedCow.class, "Apple Cow", RedCowID);

            EntityRegistry.registerModEntity(RedCow.class, "Apple Cow", RedCowID, this, 64, 1, false);

            GoldCowID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(GoldCow.class, "Golden Apple Cow", GoldCowID);

            EntityRegistry.registerModEntity(GoldCow.class, "Golden Apple Cow", GoldCowID, this, 64, 1, false);

            EnchantedCowID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry
                .registerGlobalEntityID(EnchantedCow.class, "Enchanted Golden Apple Cow", EnchantedCowID);

            EntityRegistry.registerModEntity(
                EnchantedCow.class,
                "Enchanted Golden Apple Cow",
                EnchantedCowID,
                this,
                64,
                1,
                false);

            ButterflyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityButterfly.class, "Butterfly", ButterflyID);

            EntityRegistry
                .registerModEntity(EntityButterfly.class, "Butterfly", ButterflyID, this, 32, 1, false);

            LunaMothID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityLunaMoth.class, "Moth", LunaMothID);

            EntityRegistry.registerModEntity(EntityLunaMoth.class, "Moth", LunaMothID, this, 32, 1, false);

            MosquitoID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityMosquito.class, "Mosquito", MosquitoID);

            EntityRegistry.registerModEntity(EntityMosquito.class, "Mosquito", MosquitoID, this, 16, 1, false);

            FireflyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Firefly.class, "Firefly", FireflyID);

            EntityRegistry.registerModEntity(Firefly.class, "Firefly", FireflyID, this, 64, 1, false);

            BeeID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Bee.class, "Bee", BeeID);

            EntityRegistry.registerModEntity(Bee.class, "Bee", BeeID, this, 64, 1, false);

            MothraID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Mothra.class, "Mothra", MothraID);

            EntityRegistry.registerModEntity(Mothra.class, "Mothra", MothraID, this, 128, 1, false);

            AntID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityAnt.class, "Ant", AntID);
            EntityRegistry.registerModEntity(EntityAnt.class, "Ant", AntID, this, 16, 1, false);

            RedAntID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityRedAnt.class, "Red Ant", RedAntID);

            EntityRegistry.registerModEntity(EntityRedAnt.class, "Red Ant", RedAntID, this, 16, 1, false);

            RainbowAntID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityRainbowAnt.class, "Rainbow Ant", RainbowAntID);

            EntityRegistry
                .registerModEntity(EntityRainbowAnt.class, "Rainbow Ant", RainbowAntID, this, 16, 1, false);

            UnstableAntID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityUnstableAnt.class, "Unstable Ant", UnstableAntID);

            EntityRegistry
                .registerModEntity(EntityUnstableAnt.class, "Unstable Ant", UnstableAntID, this, 16, 1, false);

            Robot1ID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Robot1.class, "Bomb-Omb", Robot1ID);

            EntityRegistry.registerModEntity(Robot1.class, "Bomb-Omb", Robot1ID, this, 32, 1, false);

            Robot2ID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Robot2.class, "Robo-Pounder", Robot2ID);

            EntityRegistry.registerModEntity(Robot2.class, "Robo-Pounder", Robot2ID, this, 64, 1, false);

            Robot3ID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Robot3.class, "Robo-Gunner", Robot3ID);

            EntityRegistry.registerModEntity(Robot3.class, "Robo-Gunner", Robot3ID, this, 64, 1, false);

            Robot4ID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Robot4.class, "Robo-Warrior", Robot4ID);

            EntityRegistry.registerModEntity(Robot4.class, "Robo-Warrior", Robot4ID, this, 64, 1, false);

            Robot5ID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Robot5.class, "Robo-Sniper", Robot5ID);

            EntityRegistry.registerModEntity(Robot5.class, "Robo-Sniper", Robot5ID, this, 64, 1, false);

            AlosaurusID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Alosaurus.class, "Alosaurus", AlosaurusID);

            EntityRegistry.registerModEntity(Alosaurus.class, "Alosaurus", AlosaurusID, this, 64, 1, false);

            CryolophosaurusID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Cryolophosaurus.class, "Cryolophosaurus", CryolophosaurusID);

            EntityRegistry.registerModEntity(
                Cryolophosaurus.class,
                "Cryolophosaurus",
                CryolophosaurusID,
                this,
                64,
                1,
                false);

            BasiliskID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Basilisk.class, "Basilisk", BasiliskID);

            EntityRegistry.registerModEntity(Basilisk.class, "Basilisk", BasiliskID, this, 64, 1, false);

            CamarasaurusID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Camarasaurus.class, "Camarasaurus", CamarasaurusID);

            EntityRegistry
                .registerModEntity(Camarasaurus.class, "Camarasaurus", CamarasaurusID, this, 64, 1, false);

            HydroliscID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Hydrolisc.class, "Hydrolisc", HydroliscID);

            EntityRegistry.registerModEntity(Hydrolisc.class, "Hydrolisc", HydroliscID, this, 64, 1, false);

            VelocityRaptorID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(VelocityRaptor.class, "Velocity Raptor", VelocityRaptorID);

            EntityRegistry.registerModEntity(
                VelocityRaptor.class,
                "Velocity Raptor",
                VelocityRaptorID,
                this,
                64,
                1,
                false);

            DragonflyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Dragonfly.class, "Dragonfly", DragonflyID);

            EntityRegistry.registerModEntity(Dragonfly.class, "Dragonfly", DragonflyID, this, 64, 1, false);

            EmperorScorpionID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry
                .registerGlobalEntityID(EmperorScorpion.class, "Emperor Scorpion", EmperorScorpionID);

            EntityRegistry.registerModEntity(
                EmperorScorpion.class,
                "Emperor Scorpion",
                EmperorScorpionID,
                this,
                64,
                1,
                false);

            ScorpionID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Scorpion.class, "Scorpion", ScorpionID);

            EntityRegistry.registerModEntity(Scorpion.class, "Scorpion", ScorpionID, this, 32, 1, false);

            CaveFisherID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(CaveFisher.class, "CaveFisher", CaveFisherID);

            EntityRegistry.registerModEntity(CaveFisher.class, "CaveFisher", CaveFisherID, this, 32, 1, false);

            SpyroID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Spyro.class, "Baby Dragon", SpyroID);

            EntityRegistry.registerModEntity(Spyro.class, "Baby Dragon", SpyroID, this, 64, 1, false);

            BaryonyxID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Baryonyx.class, "Baryonyx", BaryonyxID);

            EntityRegistry.registerModEntity(Baryonyx.class, "Baryonyx", BaryonyxID, this, 64, 1, false);

            GammaMetroidID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(GammaMetroid.class, "WTF?", GammaMetroidID);

            EntityRegistry.registerModEntity(GammaMetroid.class, "WTF?", GammaMetroidID, this, 64, 1, false);

            CockateilID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Cockateil.class, "Bird", CockateilID);

            EntityRegistry.registerModEntity(Cockateil.class, "Bird", CockateilID, this, 32, 1, false);

            RubyBirdID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(RubyBird.class, "Ruby Bird", RubyBirdID);

            EntityRegistry.registerModEntity(RubyBird.class, "Ruby Bird", RubyBirdID, this, 32, 1, false);

            KyuubiID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Kyuubi.class, "Kyuubi", KyuubiID);

            EntityRegistry.registerModEntity(Kyuubi.class, "Kyuubi", KyuubiID, this, 64, 1, false);

            WaterDragonID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(WaterDragon.class, "Water Dragon", WaterDragonID);

            EntityRegistry
                .registerModEntity(WaterDragon.class, "Water Dragon", WaterDragonID, this, 64, 1, false);

            AttackSquidID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(AttackSquid.class, "Attack Squid", AttackSquidID);

            EntityRegistry
                .registerModEntity(AttackSquid.class, "Attack Squid", AttackSquidID, this, 32, 1, false);

            AlienID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Alien.class, "Alien", AlienID);

            EntityRegistry.registerModEntity(Alien.class, "Alien", AlienID, this, 64, 1, false);

            ElevatorID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Elevator.class, "Hoverboard", ElevatorID);

            EntityRegistry.registerModEntity(Elevator.class, "Hoverboard", ElevatorID, this, 128, 1, true);

            KrakenID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Kraken.class, "The Kraken", KrakenID);

            EntityRegistry.registerModEntity(Kraken.class, "The Kraken", KrakenID, this, 128, 1, false);

            LizardID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Lizard.class, "Lizard", LizardID);

            EntityRegistry.registerModEntity(Lizard.class, "Lizard", LizardID, this, 64, 1, false);

            CephadromeID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Cephadrome.class, "Cephadrome", CephadromeID);

            EntityRegistry.registerModEntity(Cephadrome.class, "Cephadrome", CephadromeID, this, 128, 1, true);

            DragonID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Dragon.class, "Dragon", DragonID);

            EntityRegistry.registerModEntity(Dragon.class, "Dragon", DragonID, this, 128, 1, true);

            ChipmunkID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Chipmunk.class, "Chipmunk", ChipmunkID);

            EntityRegistry.registerModEntity(Chipmunk.class, "Chipmunk", ChipmunkID, this, 32, 1, false);

            GazelleID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Gazelle.class, "Gazelle", GazelleID);

            EntityRegistry.registerModEntity(Gazelle.class, "Gazelle", GazelleID, this, 64, 1, false);

            OstrichID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Ostrich.class, "Ostrich", OstrichID);

            EntityRegistry.registerModEntity(Ostrich.class, "Ostrich", OstrichID, this, 64, 1, true);

            TrooperBugID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(TrooperBug.class, "Jumpy Bug", TrooperBugID);

            EntityRegistry.registerModEntity(TrooperBug.class, "Jumpy Bug", TrooperBugID, this, 64, 1, false);

            SpitBugID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(SpitBug.class, "Spit Bug", SpitBugID);

            EntityRegistry.registerModEntity(SpitBug.class, "Spit Bug", SpitBugID, this, 64, 1, false);

            StinkBugID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(StinkBug.class, "Stink Bug", StinkBugID);

            EntityRegistry.registerModEntity(StinkBug.class, "Stink Bug", StinkBugID, this, 32, 1, false);

            TshirtID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Tshirt.class, "T-Shirt", TshirtID);

            EntityRegistry.registerModEntity(Tshirt.class, "T-Shirt", TshirtID, this, 32, 1, false);

            IslandID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Island.class, "Island", IslandID);

            EntityRegistry.registerModEntity(Island.class, "Island", IslandID, this, 64, 1, false);

            IslandTooID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(IslandToo.class, "IslandToo", IslandTooID);

            EntityRegistry.registerModEntity(IslandToo.class, "IslandToo", IslandTooID, this, 64, 1, false);

            CreepingHorrorID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(CreepingHorror.class, "Creeping Horror", CreepingHorrorID);

            EntityRegistry.registerModEntity(
                CreepingHorror.class,
                "Creeping Horror",
                CreepingHorrorID,
                this,
                64,
                1,
                false);

            TerribleTerrorID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(TerribleTerror.class, "Terrible Terror", TerribleTerrorID);

            EntityRegistry.registerModEntity(
                TerribleTerror.class,
                "Terrible Terror",
                TerribleTerrorID,
                this,
                64,
                1,
                false);

            CliffRacerID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(CliffRacer.class, "Cliff Racer", CliffRacerID);

            EntityRegistry
                .registerModEntity(CliffRacer.class, "Cliff Racer", CliffRacerID, this, 32, 1, false);

            TriffidID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Triffid.class, "Triffid", TriffidID);

            EntityRegistry.registerModEntity(Triffid.class, "Triffid", TriffidID, this, 64, 1, false);

            PitchBlackID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(PitchBlack.class, "Nightmare", PitchBlackID);

            EntityRegistry.registerModEntity(PitchBlack.class, "Nightmare", PitchBlackID, this, 64, 1, false);

            LurkingTerrorID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(LurkingTerror.class, "Lurking Terror", LurkingTerrorID);

            EntityRegistry
                .registerModEntity(LurkingTerror.class, "Lurking Terror", LurkingTerrorID, this, 64, 1, false);

            GodzillaID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Godzilla.class, "Mobzilla", GodzillaID);

            EntityRegistry.registerModEntity(Godzilla.class, "Mobzilla", GodzillaID, this, 128, 1, false);

            GhostID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Ghost.class, "Ghost", GhostID);

            EntityRegistry.registerModEntity(Ghost.class, "Ghost", GhostID, this, 32, 1, false);

            GhostSkellyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(GhostSkelly.class, "Ghost Pumpkin Skelly", GhostSkellyID);

            EntityRegistry.registerModEntity(
                GhostSkelly.class,
                "Ghost Pumpkin Skelly",
                GhostSkellyID,
                this,
                64,
                1,
                false);

            WormSmallID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(WormSmall.class, "Small Worm", WormSmallID);

            EntityRegistry.registerModEntity(WormSmall.class, "Small Worm", WormSmallID, this, 32, 1, false);

            WormMediumID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(WormMedium.class, "Medium Worm", WormMediumID);

            EntityRegistry
                .registerModEntity(WormMedium.class, "Medium Worm", WormMediumID, this, 64, 1, false);

            WormLargeID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(WormLarge.class, "Large Worm", WormLargeID);

            EntityRegistry.registerModEntity(WormLarge.class, "Large Worm", WormLargeID, this, 64, 1, false);

            CassowaryID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Cassowary.class, "Cassowary", CassowaryID);

            EntityRegistry.registerModEntity(Cassowary.class, "Cassowary", CassowaryID, this, 64, 1, false);

            CloudSharkID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(CloudShark.class, "Cloud Shark", CloudSharkID);

            EntityRegistry
                .registerModEntity(CloudShark.class, "Cloud Shark", CloudSharkID, this, 64, 1, false);

            GoldFishID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(GoldFish.class, "Gold Fish", GoldFishID);

            EntityRegistry.registerModEntity(GoldFish.class, "Gold Fish", GoldFishID, this, 32, 1, false);

            LeafMonsterID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(LeafMonster.class, "Leaf Monster", LeafMonsterID);

            EntityRegistry
                .registerModEntity(LeafMonster.class, "Leaf Monster", LeafMonsterID, this, 64, 1, false);

            GodzillaHeadID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(GodzillaHead.class, "MobzillaHead", GodzillaHeadID);

            EntityRegistry
                .registerModEntity(GodzillaHead.class, "MobzillaHead", GodzillaHeadID, this, 128, 10, true);

            EnderKnightID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EnderKnight.class, "Ender Knight", EnderKnightID);

            EntityRegistry
                .registerModEntity(EnderKnight.class, "Ender Knight", EnderKnightID, this, 64, 1, false);

            EnderReaperID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EnderReaper.class, "Ender Reaper", EnderReaperID);

            EntityRegistry
                .registerModEntity(EnderReaper.class, "Ender Reaper", EnderReaperID, this, 64, 1, false);

            BeaverID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Beaver.class, "Beaver", BeaverID);

            EntityRegistry.registerModEntity(Beaver.class, "Beaver", BeaverID, this, 64, 1, false);

            TermiteID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Termite.class, "Termite", TermiteID);

            EntityRegistry.registerModEntity(Termite.class, "Termite", TermiteID, this, 32, 1, false);

            FairyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Fairy.class, "Fairy", FairyID);

            EntityRegistry.registerModEntity(Fairy.class, "Fairy", FairyID, this, 32, 1, false);

            PeacockID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Peacock.class, "Peacock", PeacockID);

            EntityRegistry.registerModEntity(Peacock.class, "Peacock", PeacockID, this, 64, 1, false);

            RotatorID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Rotator.class, "Rotator", RotatorID);

            EntityRegistry.registerModEntity(Rotator.class, "Rotator", RotatorID, this, 64, 1, false);

            VortexID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Vortex.class, "Vortex", VortexID);

            EntityRegistry.registerModEntity(Vortex.class, "Vortex", VortexID, this, 64, 1, false);

            DungeonBeastID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(DungeonBeast.class, "Dungeon Beast", DungeonBeastID);

            EntityRegistry
                .registerModEntity(DungeonBeast.class, "Dungeon Beast", DungeonBeastID, this, 64, 1, false);

            RatID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Rat.class, "Rat", RatID);

            EntityRegistry.registerModEntity(Rat.class, "Rat", RatID, this, 32, 1, false);

            FlounderID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Flounder.class, "Flounder", FlounderID);

            EntityRegistry.registerModEntity(Flounder.class, "Flounder", FlounderID, this, 32, 1, false);

            WhaleID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Whale.class, "Whale", WhaleID);

            EntityRegistry.registerModEntity(Whale.class, "Whale", WhaleID, this, 64, 1, false);

            IrukandjiID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Irukandji.class, "Irukandji", IrukandjiID);

            EntityRegistry.registerModEntity(Irukandji.class, "Irukandji", IrukandjiID, this, 32, 1, false);

            SkateID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Skate.class, "Skate", SkateID);

            EntityRegistry.registerModEntity(Skate.class, "Skate", SkateID, this, 32, 1, false);

            UrchinID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Urchin.class, "Crystal Urchin", UrchinID);

            EntityRegistry.registerModEntity(Urchin.class, "Crystal Urchin", UrchinID, this, 64, 1, false);

            MantisID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Mantis.class, "Mantis", MantisID);

            EntityRegistry.registerModEntity(Mantis.class, "Mantis", MantisID, this, 64, 1, false);

            HerculesBeetleID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(HerculesBeetle.class, "Hercules Beetle", HerculesBeetleID);

            EntityRegistry.registerModEntity(
                HerculesBeetle.class,
                "Hercules Beetle",
                HerculesBeetleID,
                this,
                64,
                1,
                false);

            TRexID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(TRex.class, "T. Rex", TRexID);

            EntityRegistry.registerModEntity(TRex.class, "T. Rex", TRexID, this, 64, 1, false);

            StinkyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Stinky.class, "Stinky", StinkyID);

            EntityRegistry.registerModEntity(Stinky.class, "Stinky", StinkyID, this, 64, 1, false);

            CoinID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Coin.class, "Coin", CoinID);

            EntityRegistry.registerModEntity(Coin.class, "Coin", CoinID, this, 64, 1, false);

            TheKingID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(TheKing.class, "The King", TheKingID);

            EntityRegistry.registerModEntity(TheKing.class, "The King", TheKingID, this, 128, 1, false);

            KingHeadID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(KingHead.class, "KingHead", KingHeadID);

            EntityRegistry.registerModEntity(KingHead.class, "KingHead", KingHeadID, this, 128, 10, true);

            TheQueenID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(TheQueen.class, "The Queen", TheQueenID);

            EntityRegistry.registerModEntity(TheQueen.class, "The Queen", TheQueenID, this, 128, 1, false);

            QueenHeadID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(QueenHead.class, "QueenHead", QueenHeadID);

            EntityRegistry.registerModEntity(QueenHead.class, "QueenHead", QueenHeadID, this, 128, 10, true);

            BoyfriendID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Boyfriend.class, "Boyfriend", BoyfriendID);

            EntityRegistry.registerModEntity(Boyfriend.class, "Boyfriend", BoyfriendID, this, 64, 1, false);

            ThePrinceID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(ThePrince.class, "The Prince", ThePrinceID);

            EntityRegistry.registerModEntity(ThePrince.class, "The Prince", ThePrinceID, this, 64, 1, false);

            MolenoidID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Molenoid.class, "Molenoid", MolenoidID);

            EntityRegistry.registerModEntity(Molenoid.class, "Molenoid", MolenoidID, this, 64, 1, false);

            SeaMonsterID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(SeaMonster.class, "Sea Monster", SeaMonsterID);

            EntityRegistry
                .registerModEntity(SeaMonster.class, "Sea Monster", SeaMonsterID, this, 64, 1, false);

            SeaViperID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(SeaViper.class, "Sea Viper", SeaViperID);

            EntityRegistry.registerModEntity(SeaViper.class, "Sea Viper", SeaViperID, this, 64, 1, false);

            EasterBunnyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EasterBunny.class, "Easter Bunny", EasterBunnyID);

            EntityRegistry
                .registerModEntity(EasterBunny.class, "EasterBunny", EasterBunnyID, this, 64, 1, false);

            CaterKillerID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(CaterKiller.class, "CaterKiller", CaterKillerID);

            EntityRegistry
                .registerModEntity(CaterKiller.class, "CaterKiller", CaterKillerID, this, 64, 1, false);

            CrystalCowID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(CrystalCow.class, "Crystal Apple Cow", CrystalCowID);

            EntityRegistry
                .registerModEntity(CrystalCow.class, "Crystal Apple Cow", CrystalCowID, this, 64, 1, false);

            LeonID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Leon.class, "Leonopteryx", LeonID);

            EntityRegistry.registerModEntity(Leon.class, "Leonopteryx", LeonID, this, 64, 1, false);

            HammerheadID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Hammerhead.class, "Hammerhead", HammerheadID);

            EntityRegistry.registerModEntity(Hammerhead.class, "Hammerhead", HammerheadID, this, 64, 1, false);

            RubberDuckyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(RubberDucky.class, "Rubber Ducky", RubberDuckyID);

            EntityRegistry
                .registerModEntity(RubberDucky.class, "Rubber Ducky", RubberDuckyID, this, 64, 1, false);

            ThePrinceTeenID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(ThePrinceTeen.class, "The Young Prince", ThePrinceTeenID);

            EntityRegistry.registerModEntity(
                ThePrinceTeen.class,
                "The Young Prince",
                ThePrinceTeenID,
                this,
                64,
                1,
                false);

            BandPID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(BandP.class, "Criminal", BandPID);

            EntityRegistry.registerModEntity(BandP.class, "Criminal", BandPID, this, 64, 1, false);

            RockBaseID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(RockBase.class, "Rock", RockBaseID, 1118481, 16777215);

            EntityRegistry.registerModEntity(RockBase.class, "Rock", RockBaseID, this, 32, 1, false);

            BrutalflyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Brutalfly.class, "Brutalfly", BrutalflyID);

            EntityRegistry.registerModEntity(Brutalfly.class, "Brutalfly", BrutalflyID, this, 128, 1, false);

            NastysaurusID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Nastysaurus.class, "Nastysaurus", NastysaurusID);

            EntityRegistry
                .registerModEntity(Nastysaurus.class, "Nastysaurus", NastysaurusID, this, 128, 1, false);

            PointysaurusID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Pointysaurus.class, "Pointysaurus", PointysaurusID);

            EntityRegistry
                .registerModEntity(Pointysaurus.class, "Pointysaurus", PointysaurusID, this, 64, 1, false);

            CricketID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Cricket.class, "Cricket", CricketID);

            EntityRegistry.registerModEntity(Cricket.class, "Cricket", CricketID, this, 32, 1, false);

            ThePrincessID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(ThePrincess.class, "The Princess", ThePrincessID);

            EntityRegistry
                .registerModEntity(ThePrincess.class, "The Princess", ThePrincessID, this, 64, 1, false);

            FrogID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Frog.class, "Frog", FrogID);

            EntityRegistry.registerModEntity(Frog.class, "Frog", FrogID, this, 32, 1, false);

            ThePrinceAdultID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry
                .registerGlobalEntityID(ThePrinceAdult.class, "The Young Adult Prince", ThePrinceAdultID);

            EntityRegistry.registerModEntity(
                ThePrinceAdult.class,
                "The Young Adult Prince",
                ThePrinceAdultID,
                this,
                128,
                1,
                false);

            SpiderRobotID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(SpiderRobot.class, "Robot Spider", SpiderRobotID);

            EntityRegistry
                .registerModEntity(SpiderRobot.class, "Robot Spider", SpiderRobotID, this, 128, 1, false);

            SpiderDriverID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(SpiderDriver.class, "Spider Driver", SpiderDriverID);
            EntityRegistry
                .registerModEntity(SpiderDriver.class, "Spider Driver", SpiderDriverID, this, 64, 1, false);

            JefferyID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(GiantRobot.class, "Jeffery", JefferyID);

            EntityRegistry.registerModEntity(GiantRobot.class, "Jeffery", JefferyID, this, 128, 1, false);

            AntRobotID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(AntRobot.class, "Robot Red Ant", AntRobotID);

            EntityRegistry.registerModEntity(AntRobot.class, "Robot Red Ant", AntRobotID, this, 128, 1, false);

            CrabID = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Crab.class, "Crab", CrabID);

            EntityRegistry.registerModEntity(Crab.class, "Crab", CrabID, this, 64, 1, false);
            final GregorianCalendar gcalendar = new GregorianCalendar();
            final int nowmonth = gcalendar.get(2);
            final int nowday = gcalendar.get(5);
            if (nowmonth == 9 && nowday == 31) {
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.beach);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry
                    .addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesa);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaigaHills);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.beach);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesa);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaigaHills);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
                EntityRegistry.addSpawn(Ghost.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (nowmonth == 1 && nowday == 14) {
                valentines_day = 1;
            }
            if (nowmonth == 3 && nowday == 20) {
                easter_day = 1;
            }
            if (GirlfriendEnable != 0) {
                EntityRegistry.addSpawn(Girlfriend.class, 30, 8, 15, EnumCreatureType.creature, BiomeGenBase.beach);
                EntityRegistry.addSpawn(Girlfriend.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Girlfriend.class, 8, 2, 5, EnumCreatureType.creature, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 3, EnumCreatureType.creature, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Girlfriend.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.river);
                EntityRegistry.addSpawn(Girlfriend.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.stoneBeach);
                EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 4, EnumCreatureType.creature, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(Girlfriend.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Girlfriend.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Girlfriend.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Girlfriend.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            }
            if (BoyfriendEnable != 0) {
                EntityRegistry.addSpawn(Boyfriend.class, 30, 8, 15, EnumCreatureType.creature, BiomeGenBase.beach);
                EntityRegistry.addSpawn(Boyfriend.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Boyfriend.class, 8, 2, 5, EnumCreatureType.creature, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 3, EnumCreatureType.creature, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Boyfriend.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.river);
                EntityRegistry.addSpawn(Boyfriend.class, 10, 3, 6, EnumCreatureType.creature, BiomeGenBase.stoneBeach);
                EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 4, EnumCreatureType.creature, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Boyfriend.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Boyfriend.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Boyfriend.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            }
            if (BeaverEnable != 0) {
                EntityRegistry.addSpawn(Beaver.class, 10, 2, 4, EnumCreatureType.creature, BiomeGenBase.river);
                EntityRegistry.addSpawn(Beaver.class, 3, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Beaver.class, 2, 2, 4, EnumCreatureType.creature, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Beaver.class, 2, 2, 5, EnumCreatureType.creature, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Beaver.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Beaver.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
            }
            if (CowEnable != 0) {
                EntityRegistry.addSpawn(RedCow.class, 8, 4, 8, EnumCreatureType.creature, BiomeGenBase.plains);
                EntityRegistry.addSpawn(RedCow.class, 8, 4, 8, EnumCreatureType.creature, BiomeGenBase.forest);
                EntityRegistry.addSpawn(RedCow.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(RedCow.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(RedCow.class, 8, 1, 3, EnumCreatureType.creature, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(RedCow.class, 2, 1, 3, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
                EntityRegistry.addSpawn(GoldCow.class, 5, 2, 6, EnumCreatureType.creature, BiomeGenBase.plains);
                EntityRegistry.addSpawn(GoldCow.class, 5, 2, 6, EnumCreatureType.creature, BiomeGenBase.forest);
                EntityRegistry.addSpawn(GoldCow.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(GoldCow.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(EnchantedCow.class, 3, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest);
                EntityRegistry.addSpawn(EnchantedCow.class, 3, 2, 4, EnumCreatureType.creature, BiomeGenBase.plains);
                EntityRegistry.addSpawn(EnchantedCow.class, 5, 2, 5, EnumCreatureType.creature, BiomeGenBase.megaTaiga);
                EntityRegistry
                    .addSpawn(EnchantedCow.class, 15, 3, 6, EnumCreatureType.creature, BiomeGenBase.mushroomIsland);
            }
            if (CriminalEnable != 0) {
                EntityRegistry.addSpawn(BandP.class, 20, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(BandP.class, 20, 1, 2, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(BandP.class, 20, 1, 2, EnumCreatureType.ambient, BiomeGenBase.savanna);
            }
            if (WormEnable != 0) {
                EntityRegistry.addSpawn(WormLarge.class, 25, 1, 1, EnumCreatureType.creature, BiomeGenBase.plains);
                EntityRegistry.addSpawn(WormLarge.class, 15, 1, 1, EnumCreatureType.creature, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(WormLarge.class, 10, 1, 1, EnumCreatureType.creature, BiomeGenBase.savannaPlateau);
            }
            if (ButterflyEnable != 0) {
                EntityRegistry.addSpawn(EntityButterfly.class, 8, 5, 15, EnumCreatureType.ambient, BiomeGenBase.beach);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(EntityButterfly.class, 30, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(EntityButterfly.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(EntityButterfly.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(EntityButterfly.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(EntityButterfly.class, 20, 4, 10, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(EntityButterfly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(EntityButterfly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(EntityButterfly.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry
                    .addSpawn(EntityButterfly.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (MothEnable != 0) {
                EntityRegistry.addSpawn(EntityLunaMoth.class, 8, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry
                    .addSpawn(EntityLunaMoth.class, 8, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry
                    .addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(EntityLunaMoth.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry
                    .addSpawn(EntityLunaMoth.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (CassowaryEnable != 0) {
                EntityRegistry.addSpawn(Cassowary.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry.addSpawn(Cassowary.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(Cassowary.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsPlus);
                EntityRegistry.addSpawn(Cassowary.class, 5, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Cassowary.class, 5, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Cassowary.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Cassowary.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
                EntityRegistry.addSpawn(Cassowary.class, 3, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Cassowary.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (EasterBunnyEnable != 0 && easter_day != 0) {
                EntityRegistry.addSpawn(EasterBunny.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(EasterBunny.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(EasterBunny.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(EasterBunny.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(EasterBunny.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(EasterBunny.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(EasterBunny.class, 8, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taiga);
            }
            if (FireflyEnable != 0) {
                EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Firefly.class, 10, 4, 8, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Firefly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Firefly.class, 10, 3, 6, EnumCreatureType.ambient, BiomeGenBase.stoneBeach);
                EntityRegistry.addSpawn(Firefly.class, 15, 3, 10, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Firefly.class, 15, 3, 10, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Firefly.class, 15, 2, 10, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
                EntityRegistry.addSpawn(Firefly.class, 10, 2, 8, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Firefly.class, 10, 2, 8, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (WhaleEnable != 0) {
                EntityRegistry.addSpawn(Whale.class, 1, 1, 2, EnumCreatureType.waterCreature, BiomeGenBase.deepOcean);
            }
            if (BeeEnable != 0) {
                EntityRegistry.addSpawn(Bee.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Bee.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Bee.class, 5, 3, 5, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Bee.class, 5, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Bee.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Bee.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Bee.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Bee.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Bee.class, 3, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Bee.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (MantisEnable != 0) {
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Mantis.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Mantis.class, 1, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Mantis.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (HerculesBeetleEnable != 0) {
                EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry
                    .addSpawn(HerculesBeetle.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taigaHills);
                EntityRegistry
                    .addSpawn(HerculesBeetle.class, 5, 1, 1, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry
                    .addSpawn(HerculesBeetle.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.coldTaigaHills);
                EntityRegistry
                    .addSpawn(HerculesBeetle.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
            }
            if (MolenoidEnable != 0) {
                EntityRegistry.addSpawn(Molenoid.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Molenoid.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Molenoid.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (CaterKillerEnable != 0) {
                EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(CaterKiller.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(CaterKiller.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(CaterKiller.class, 6, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(CaterKiller.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(CaterKiller.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (ChipmunkEnable != 0) {
                EntityRegistry.addSpawn(Chipmunk.class, 8, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Chipmunk.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Chipmunk.class, 4, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Chipmunk.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Chipmunk.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Chipmunk.class, 4, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Chipmunk.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
                EntityRegistry.addSpawn(Chipmunk.class, 2, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Chipmunk.class, 6, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            }
            if (OstrichEnable != 0) {
                EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.stoneBeach);
                EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Ostrich.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (CephadromeEnable != 0) {
                EntityRegistry.addSpawn(Cephadrome.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.icePlains);
                EntityRegistry.addSpawn(Cephadrome.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
            }
            if (MosquitoEnable != 0) {
                EntityRegistry.addSpawn(EntityMosquito.class, 30, 5, 10, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(EntityMosquito.class, 20, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry
                    .addSpawn(EntityMosquito.class, 20, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry
                    .addSpawn(EntityMosquito.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (GhostEnable != 0) {
                EntityRegistry.addSpawn(Ghost.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
                EntityRegistry.addSpawn(Ghost.class, 10, 5, 10, EnumCreatureType.ambient, BiomeGenBase.taigaHills);
                EntityRegistry.addSpawn(Ghost.class, 6, 4, 6, EnumCreatureType.ambient, BiomeGenBase.frozenRiver);
                EntityRegistry.addSpawn(Ghost.class, 2, 1, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Ghost.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (GhostSkellyEnable != 0) {
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 5, 10, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
                EntityRegistry.addSpawn(GhostSkelly.class, 10, 5, 10, EnumCreatureType.ambient, BiomeGenBase.taigaHills);
                EntityRegistry.addSpawn(GhostSkelly.class, 6, 4, 6, EnumCreatureType.ambient, BiomeGenBase.frozenRiver);
                EntityRegistry.addSpawn(GhostSkelly.class, 2, 1, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(GhostSkelly.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (DragonflyEnable != 0) {
                EntityRegistry.addSpawn(Dragonfly.class, 5, 3, 5, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Dragonfly.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.river);
            }
            if (KyuubiEnable != 0) {
                EntityRegistry.addSpawn(Kyuubi.class, 10, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
            }
            if (StinkyEnable != 0) {
                EntityRegistry.addSpawn(Stinky.class, 2, 1, 1, EnumCreatureType.monster, BiomeGenBase.hell);
                EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesa);
                EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
                EntityRegistry.addSpawn(Stinky.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
            }
            if (CockateilEnable != 0) {
                EntityRegistry.addSpawn(Cockateil.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.beach);
                EntityRegistry.addSpawn(Cockateil.class, 10, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry.addSpawn(Cockateil.class, 10, 2, 4, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(Cockateil.class, 25, 5, 10, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Cockateil.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Cockateil.class, 35, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Cockateil.class, 25, 5, 10, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Cockateil.class, 10, 2, 4, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Cockateil.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(Cockateil.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.stoneBeach);
                EntityRegistry.addSpawn(Cockateil.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Cockateil.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Cockateil.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Cockateil.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Cockateil.class, 11, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Cockateil.class, 11, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (HydroliscEnable != 0) {
                EntityRegistry.addSpawn(Hydrolisc.class, 25, 3, 6, EnumCreatureType.creature, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Hydrolisc.class, 15, 2, 5, EnumCreatureType.creature, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Hydrolisc.class, 10, 1, 3, EnumCreatureType.creature, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Hydrolisc.class, 5, 3, 6, EnumCreatureType.creature, BiomeGenBase.stoneBeach);
            }
            if (MothraEnable != 0) {
                EntityRegistry.addSpawn(Mothra.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry.addSpawn(Mothra.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.extremeHillsPlus);
            }
            if (BrutalflyEnable != 0) {
                EntityRegistry.addSpawn(Brutalfly.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.megaTaigaHills);
                EntityRegistry.addSpawn(Brutalfly.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.extremeHillsPlus);
                EntityRegistry.addSpawn(Brutalfly.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            }
            if (WaterDragonEnable != 0) {
                EntityRegistry.addSpawn(WaterDragon.class, 5, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.river);
                EntityRegistry.addSpawn(WaterDragon.class, 3, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(WaterDragon.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
                EntityRegistry
                    .addSpawn(WaterDragon.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            }
            if (SeaMonsterEnable != 0) {
                EntityRegistry.addSpawn(SeaMonster.class, 4, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
                EntityRegistry.addSpawn(SeaMonster.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
            }
            if (SeaViperEnable != 0) {
                EntityRegistry.addSpawn(SeaViper.class, 3, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
                EntityRegistry.addSpawn(SeaViper.class, 2, 1, 1, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            }
            if (CrabEnable != 0) {
                EntityRegistry.addSpawn(Crab.class, 2, 3, 6, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
                EntityRegistry.addSpawn(Crab.class, 1, 3, 6, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Crab.class, 1, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            }
            if (AttackSquidEnable != 0) {
                EntityRegistry.addSpawn(AttackSquid.class, 12, 6, 10, EnumCreatureType.waterCreature, BiomeGenBase.river);
                EntityRegistry
                    .addSpawn(AttackSquid.class, 10, 5, 9, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(AttackSquid.class, 7, 4, 8, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            }
            if (LizardEnable != 0) {
                EntityRegistry.addSpawn(Lizard.class, 5, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.river);
                EntityRegistry.addSpawn(Lizard.class, 4, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Lizard.class, 2, 2, 4, EnumCreatureType.waterCreature, BiomeGenBase.ocean);
            }
            if (RubberDuckyEnable != 0) {
                EntityRegistry.addSpawn(RubberDucky.class, 10, 10, 20, EnumCreatureType.waterCreature, BiomeGenBase.river);
                EntityRegistry
                    .addSpawn(RubberDucky.class, 4, 4, 6, EnumCreatureType.waterCreature, BiomeGenBase.stoneBeach);
            }
            if (BasiliskEnable != 0) {
                EntityRegistry.addSpawn(Basilisk.class, 3, 1, 1, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Basilisk.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Basilisk.class, 4, 1, 2, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Basilisk.class, 15, 1, 2, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (EmperorScorpionEnable != 0) {
                EntityRegistry.addSpawn(EmperorScorpion.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(EmperorScorpion.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.savanna);
            }
            if (TrooperBugEnable != 0) {
                EntityRegistry.addSpawn(TrooperBug.class, 3, 1, 2, EnumCreatureType.ambient, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(TrooperBug.class, 1, 1, 1, EnumCreatureType.ambient, BiomeGenBase.mesa);
            }
            if (SpitBugEnable != 0) {
                EntityRegistry.addSpawn(SpitBug.class, 6, 1, 2, EnumCreatureType.ambient, BiomeGenBase.swampland);
            }
            if (StinkBugEnable != 0) {
                EntityRegistry.addSpawn(StinkBug.class, 10, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(StinkBug.class, 8, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(StinkBug.class, 6, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(StinkBug.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(StinkBug.class, 8, 2, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            }
            if (ScorpionEnable != 0) {
                EntityRegistry.addSpawn(Scorpion.class, 15, 3, 6, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(Scorpion.class, 28, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
                EntityRegistry.addSpawn(Scorpion.class, 15, 3, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
                EntityRegistry.addSpawn(Scorpion.class, 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
                EntityRegistry.addSpawn(Scorpion.class, 6, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesa);
                EntityRegistry.addSpawn(Scorpion.class, 4, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
                EntityRegistry.addSpawn(Scorpion.class, 5, 3, 6, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau_F);
            }
            if (LeafMonsterEnable != 0) {
                EntityRegistry.addSpawn(LeafMonster.class, 5, 2, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(LeafMonster.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(LeafMonster.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(LeafMonster.class, 3, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(LeafMonster.class, 3, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry
                    .addSpawn(LeafMonster.class, 2, 3, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(LeafMonster.class, 2, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(LeafMonster.class, 2, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            }
            if (EnderKnightEnable != 0) {
                EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry
                    .addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(EnderKnight.class, 4, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(EnderKnight.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(EnderKnight.class, 20, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (EnderReaperEnable != 0) {
                EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
                EntityRegistry
                    .addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
                EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(EnderReaper.class, 2, 1, 2, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(EnderReaper.class, 1, 1, 2, EnumCreatureType.ambient, BiomeGenBase.desert);
                EntityRegistry.addSpawn(EnderReaper.class, 38, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (CoinEnable != 0) {
                EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.coldTaiga);
                EntityRegistry.addSpawn(Coin.class, 2, 1, 1, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            }
            if (CricketEnable != 0) {
                EntityRegistry.addSpawn(Cricket.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forest);
                EntityRegistry.addSpawn(Cricket.class, 2, 2, 4, EnumCreatureType.ambient, BiomeGenBase.forestHills);
                EntityRegistry.addSpawn(Cricket.class, 3, 2, 4, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Cricket.class, 2, 3, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
                EntityRegistry.addSpawn(Cricket.class, 3, 4, 8, EnumCreatureType.ambient, BiomeGenBase.plains);
                EntityRegistry.addSpawn(Cricket.class, 2, 2, 6, EnumCreatureType.ambient, BiomeGenBase.birchForest);
                EntityRegistry.addSpawn(Cricket.class, 2, 2, 6, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
                EntityRegistry.addSpawn(Cricket.class, 3, 1, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
                EntityRegistry.addSpawn(Cricket.class, 2, 1, 6, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
                EntityRegistry.addSpawn(Cricket.class, 2, 1, 6, EnumCreatureType.ambient, BiomeGenBase.taiga);
                EntityRegistry.addSpawn(Cricket.class, 1, 1, 4, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
            }
            if (FrogEnable != 0) {
                EntityRegistry.addSpawn(Frog.class, 20, 3, 6, EnumCreatureType.waterCreature, BiomeGenBase.river);
                EntityRegistry.addSpawn(Frog.class, 3, 3, 6, EnumCreatureType.ambient, BiomeGenBase.river);
                EntityRegistry.addSpawn(Frog.class, 3, 3, 6, EnumCreatureType.ambient, BiomeGenBase.jungle);
                EntityRegistry.addSpawn(Frog.class, 20, 2, 6, EnumCreatureType.waterCreature, BiomeGenBase.swampland);
                EntityRegistry.addSpawn(Frog.class, 2, 2, 6, EnumCreatureType.ambient, BiomeGenBase.swampland);
            }
            if (PeacockEnable != 0) {
                EntityRegistry.addSpawn(Peacock.class, 1, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesa);
                EntityRegistry.addSpawn(Peacock.class, 1, 1, 3, EnumCreatureType.ambient, BiomeGenBase.mesaPlateau);
            }
            if (FairyEnable != 0) {
                EntityRegistry.addSpawn(Fairy.class, 25, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }
            if (RatEnable != 0) {
                EntityRegistry.addSpawn(Rat.class, 35, 10, 20, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
                EntityRegistry.addSpawn(Rat.class, 25, 2, 8, EnumCreatureType.ambient, BiomeGenBase.taiga);
            }
            if (DungeonBeastEnable != 0) {
                EntityRegistry.addSpawn(DungeonBeast.class, 20, 2, 4, EnumCreatureType.ambient, BiomeGenBase.roofedForest);
            }

            final int shoeid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(Shoes.class, "Shoes", shoeid);

            EntityRegistry.registerModEntity(Shoes.class, "Shoes", shoeid, this, 64, 1, true);
            GameRegistry.addRecipe(
                new ItemStack(UltimateHelmet),
                "   ",
                "TIT",
                "U U",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(UltimateHelmet),
                "TIT",
                "U U",
                "   ",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(UltimateBody),
                "I I",
                "TTT",
                "UUU",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(UltimateLegs),
                "III",
                "T T",
                "U U",
                'I',
                Items.iron_ingot,
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(UltimateBoots),
                "   ",
                "T T",
                "U U",
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry.addRecipe(
                new ItemStack(UltimateBoots),
                "T T",
                "U U",
                "   ",
                'U',
                MyIngotUranium,
                'T',
                MyIngotTitanium);
            GameRegistry
                .addRecipe(new ItemStack(LavaEelHelmet), "   ", "***", "* *", '*', MyLavaEel);
            GameRegistry
                .addRecipe(new ItemStack(LavaEelHelmet), "***", "* *", "   ", '*', MyLavaEel);
            GameRegistry
                .addRecipe(new ItemStack(LavaEelBody), "* *", "***", "***", '*', MyLavaEel);
            GameRegistry
                .addRecipe(new ItemStack(LavaEelLegs), "***", "* *", "* *", '*', MyLavaEel);
            GameRegistry
                .addRecipe(new ItemStack(LavaEelBoots), "   ", "* *", "* *", '*', MyLavaEel);
            GameRegistry
                .addRecipe(new ItemStack(MothScaleHelmet), "   ", "***", "* *", '*', MyMothScale);
            GameRegistry
                .addRecipe(new ItemStack(MothScaleHelmet), "***", "* *", "   ", '*', MyMothScale);
            GameRegistry
                .addRecipe(new ItemStack(MothScaleBody), "* *", "***", "***", '*', MyMothScale);
            GameRegistry
                .addRecipe(new ItemStack(MothScaleLegs), "***", "* *", "* *", '*', MyMothScale);
            GameRegistry
                .addRecipe(new ItemStack(MothScaleBoots), "   ", "* *", "* *", '*', MyMothScale);
            GameRegistry.addRecipe(new ItemStack(EmeraldHelmet), "   ", "***", "* *", '*', Items.emerald);
            GameRegistry.addRecipe(new ItemStack(EmeraldHelmet), "***", "* *", "   ", '*', Items.emerald);
            GameRegistry.addRecipe(new ItemStack(EmeraldBody), "* *", "***", "***", '*', Items.emerald);
            GameRegistry.addRecipe(new ItemStack(EmeraldLegs), "***", "* *", "* *", '*', Items.emerald);
            GameRegistry.addRecipe(new ItemStack(EmeraldBoots), "   ", "* *", "* *", '*', Items.emerald);
            GameRegistry.addRecipe(new ItemStack(RubyHelmet), "   ", "***", "* *", '*', MyRuby);
            GameRegistry.addRecipe(new ItemStack(RubyHelmet), "***", "* *", "   ", '*', MyRuby);
            GameRegistry.addRecipe(new ItemStack(RubyBody), "* *", "***", "***", '*', MyRuby);
            GameRegistry.addRecipe(new ItemStack(RubyLegs), "***", "* *", "* *", '*', MyRuby);
            GameRegistry.addRecipe(new ItemStack(RubyBoots), "   ", "* *", "* *", '*', MyRuby);
            GameRegistry
                .addRecipe(new ItemStack(AmethystHelmet), "   ", "***", "* *", '*', MyAmethyst);
            GameRegistry
                .addRecipe(new ItemStack(AmethystHelmet), "***", "* *", "   ", '*', MyAmethyst);
            GameRegistry
                .addRecipe(new ItemStack(AmethystBody), "* *", "***", "***", '*', MyAmethyst);
            GameRegistry
                .addRecipe(new ItemStack(AmethystLegs), "***", "* *", "* *", '*', MyAmethyst);
            GameRegistry
                .addRecipe(new ItemStack(AmethystBoots), "   ", "* *", "* *", '*', MyAmethyst);
            GameRegistry.addRecipe(
                new ItemStack(CrystalPinkHelmet),
                "   ",
                "***",
                "* *",
                '*',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(CrystalPinkHelmet),
                "***",
                "* *",
                "   ",
                '*',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(CrystalPinkBody),
                "* *",
                "***",
                "***",
                '*',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(CrystalPinkLegs),
                "***",
                "* *",
                "* *",
                '*',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(CrystalPinkBoots),
                "   ",
                "* *",
                "* *",
                '*',
                MyCrystalPinkIngot);
            GameRegistry.addRecipe(
                new ItemStack(MobzillaHelmet),
                "   ",
                "***",
                "* *",
                '*',
                MyGodzillaScale);
            GameRegistry.addRecipe(
                new ItemStack(MobzillaHelmet),
                "***",
                "* *",
                "   ",
                '*',
                MyGodzillaScale);
            GameRegistry.addRecipe(
                new ItemStack(MobzillaBody),
                "* *",
                "***",
                "***",
                '*',
                MyGodzillaScale);
            GameRegistry.addRecipe(
                new ItemStack(MobzillaLegs),
                "***",
                "* *",
                "* *",
                '*',
                MyGodzillaScale);
            GameRegistry.addRecipe(
                new ItemStack(MobzillaBoots),
                "   ",
                "* *",
                "* *",
                '*',
                MyGodzillaScale);
            GameRegistry.addRecipe(new ItemStack(LapisHelmet), "   ", "***", "* *", '*', Blocks.lapis_block);
            GameRegistry.addRecipe(new ItemStack(LapisHelmet), "***", "* *", "   ", '*', Blocks.lapis_block);
            GameRegistry.addRecipe(new ItemStack(LapisBody), "* *", "***", "***", '*', Blocks.lapis_block);
            GameRegistry.addRecipe(new ItemStack(LapisLegs), "***", "* *", "* *", '*', Blocks.lapis_block);
            GameRegistry.addRecipe(new ItemStack(LapisBoots), "   ", "* *", "* *", '*', Blocks.lapis_block);
            GameRegistry
                .addRecipe(new ItemStack(QueenHelmet), "   ", "***", "* *", '*', MyQueenScale);
            GameRegistry
                .addRecipe(new ItemStack(QueenHelmet), "***", "* *", "   ", '*', MyQueenScale);
            GameRegistry
                .addRecipe(new ItemStack(QueenBody), "* *", "***", "***", '*', MyQueenScale);
            GameRegistry
                .addRecipe(new ItemStack(QueenLegs), "***", "* *", "* *", '*', MyQueenScale);
            GameRegistry
                .addRecipe(new ItemStack(QueenBoots), "   ", "* *", "* *", '*', MyQueenScale);
            GameRegistry.addRecipe(
                new ItemStack(PeacockFeatherHelmet),
                "   ",
                "***",
                "* *",
                '*',
                MyPeacockFeather);
            GameRegistry.addRecipe(
                new ItemStack(PeacockFeatherHelmet),
                "***",
                "* *",
                "   ",
                '*',
                MyPeacockFeather);
            GameRegistry.addRecipe(
                new ItemStack(PeacockFeatherBody),
                "* *",
                "***",
                "***",
                '*',
                MyPeacockFeather);
            GameRegistry.addRecipe(
                new ItemStack(PeacockFeatherLegs),
                "***",
                "* *",
                "* *",
                '*',
                MyPeacockFeather);
            GameRegistry.addRecipe(
                new ItemStack(PeacockFeatherBoots),
                "   ",
                "* *",
                "* *",
                '*',
                MyPeacockFeather);
            GameRegistry.addRecipe(
                new ItemStack(TigersEyeHelmet),
                "   ",
                "***",
                "* *",
                '*',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(TigersEyeHelmet),
                "***",
                "* *",
                "   ",
                '*',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(TigersEyeBody),
                "* *",
                "***",
                "***",
                '*',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(TigersEyeLegs),
                "***",
                "* *",
                "* *",
                '*',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(TigersEyeBoots),
                "   ",
                "* *",
                "* *",
                '*',
                MyTigersEyeIngot);
            GameRegistry.addRecipe(
                new ItemStack(ExperienceHelmet),
                "EEE",
                "EAE",
                "EEE",
                'A',
                EmeraldHelmet,
                'E',
                Items.experience_bottle);
            GameRegistry.addRecipe(
                new ItemStack(ExperienceBody),
                "EEE",
                "EAE",
                "EEE",
                'A',
                EmeraldBody,
                'E',
                Items.experience_bottle);
            GameRegistry.addRecipe(
                new ItemStack(ExperienceLegs),
                "EEE",
                "EAE",
                "EEE",
                'A',
                EmeraldLegs,
                'E',
                Items.experience_bottle);
            GameRegistry.addRecipe(
                new ItemStack(ExperienceBoots),
                "EEE",
                "EAE",
                "EEE",
                'A',
                EmeraldBoots,
                'E',
                Items.experience_bottle);
            GameRegistry.addRecipe(new ItemStack(Blocks.web), "***", "* *", "***", '*', Items.string);

            final int cageid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(EntityCage.class, "EntityCage", cageid);

            EntityRegistry.registerModEntity(EntityCage.class, "EntityCage", cageid, this, 64, 1, true);
            GameRegistry.addRecipe(
                new ItemStack(CageEmpty, 2),
                "IWI",
                "W W",
                "IWI",
                'W',
                Items.stick,
                'I',
                Items.iron_ingot);
            GameRegistry.addRecipe(
                new ItemStack(CageEmpty, 2),
                "IWI",
                "W W",
                "IWI",
                'W',
                CrystalSticks,
                'I',
                MyCrystalPinkIngot);

            final int arrowid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(UltimateArrow.class, "UltimateArrow", arrowid);

            final int irukandiarrowid = EntityRegistry.findGlobalUniqueEntityId();

            EntityRegistry.registerGlobalEntityID(IrukandjiArrow.class, "IrukandjiArrow", irukandiarrowid);
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new ItemStack(MySkyTreeLog));
            GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 4), new ItemStack(MyDT));
            GameRegistry.addRecipe(
                new ItemStack(MyElevator),
                "   ",
                "WWW",
                "DRD",
                'W',
                Blocks.planks,
                'R',
                Items.redstone,
                'D',
                Items.diamond);
            GameRegistry.registerWorldGenerator(this.OreSpawnGen, 10);
            packetproxy.registerRenderThings();
            packetproxy.registerKeyboardInput();
            packetproxy.registerNetworkStuff();
            DimensionManager.registerProviderType(DimensionID, WorldProviderOreSpawn.class, true);
            DimensionManager.registerDimension(DimensionID, DimensionID);
            DimensionManager.registerProviderType(DimensionID2, WorldProviderOreSpawn2.class, true);
            DimensionManager.registerDimension(DimensionID2, DimensionID2);
            DimensionManager.registerProviderType(DimensionID3, WorldProviderOreSpawn3.class, true);
            DimensionManager.registerDimension(DimensionID3, DimensionID3);
            DimensionManager.registerProviderType(DimensionID4, WorldProviderOreSpawn4.class, true);
            DimensionManager.registerDimension(DimensionID4, DimensionID4);
            DimensionManager.registerProviderType(DimensionID5, WorldProviderOreSpawn5.class, true);
            DimensionManager.registerDimension(DimensionID5, DimensionID5);
            DimensionManager.registerProviderType(DimensionID6, WorldProviderOreSpawn6.class, true);
            DimensionManager.registerDimension(DimensionID6, DimensionID6);
            final ChestGenHooks chestGenHooksDungeon = ChestGenHooks.getInfo("dungeonChest");
            chestGenHooksDungeon.addItem(new WeightedRandomChestContent(new ItemStack(MyRuby), 1, 1, 3));
            chestGenHooksDungeon.addItem(new WeightedRandomChestContent(new ItemStack(MyAmethyst), 1, 1, 3));
            chestGenHooksDungeon
                .addItem(new WeightedRandomChestContent(new ItemStack(MyThunderStaff), 1, 1, 2));
            final ChestGenHooks chestGenHooksJungleChest = ChestGenHooks.getInfo("pyramidJungleChest");
            chestGenHooksJungleChest.addItem(new WeightedRandomChestContent(new ItemStack(MyRuby), 1, 1, 3));
            chestGenHooksJungleChest
                .addItem(new WeightedRandomChestContent(new ItemStack(MyAmethyst), 1, 1, 3));
            chestGenHooksJungleChest
                .addItem(new WeightedRandomChestContent(new ItemStack(AntRobotKit), 1, 1, 3));
            final ChestGenHooks chestGenHooksDesertChest = ChestGenHooks.getInfo("pyramidDesertyChest");
            chestGenHooksDesertChest.addItem(new WeightedRandomChestContent(new ItemStack(MyRuby), 1, 1, 2));
            chestGenHooksDesertChest
                .addItem(new WeightedRandomChestContent(new ItemStack(MyAmethyst), 1, 1, 2));
            chestGenHooksDesertChest
                .addItem(new WeightedRandomChestContent(new ItemStack(SpiderRobotKit), 1, 1, 2));
            GameRegistry.registerTileEntity(TileEntityCrystalFurnace.class, "TileEntityCrystalFurnace");
            NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler) new OreSpawnGUIHandler());
            this.DoDispenserRegistrations();
        }

        public void initializeCagesAndEggs() {
            CageEmpty = new CritterCage(BaseItemID, 160).setUnlocalizedName("cageempty");
            CagedSpider = new CritterCage(BaseItemID + 1, 161).setUnlocalizedName("cagespider");
            CagedBat = new CritterCage(BaseItemID + 2, 162).setUnlocalizedName("cagebat");
            CagedCow = new CritterCage(BaseItemID + 3, 163).setUnlocalizedName("cagecow");
            CagedPig = new CritterCage(BaseItemID + 4, 164).setUnlocalizedName("cagepig");
            CagedSquid = new CritterCage(BaseItemID + 5, 165).setUnlocalizedName("cagesquid");
            CagedChicken = new CritterCage(BaseItemID + 6, 166).setUnlocalizedName("cagechicken");
            CagedCreeper = new CritterCage(BaseItemID + 7, 167).setUnlocalizedName("cagecreeper");
            CagedSkeleton = new CritterCage(BaseItemID + 8, 168)
                .setUnlocalizedName("cageskeleton");
            CagedZombie = new CritterCage(BaseItemID + 9, 169).setUnlocalizedName("cagezombie");
            CagedSlime = new CritterCage(BaseItemID + 10, 170).setUnlocalizedName("cageslime");
            CagedGhast = new CritterCage(BaseItemID + 11, 171).setUnlocalizedName("cageghast");
            CagedZombiePigman = new CritterCage(BaseItemID + 12, 172)
                .setUnlocalizedName("cagezombiepigman");
            CagedEnderman = new CritterCage(BaseItemID + 13, 173)
                .setUnlocalizedName("cageenderman");
            CagedCaveSpider = new CritterCage(BaseItemID + 14, 174)
                .setUnlocalizedName("cagecavespider");
            CagedSilverfish = new CritterCage(BaseItemID + 15, 175)
                .setUnlocalizedName("cagesilverfish");
            CagedMagmaCube = new CritterCage(BaseItemID + 16, 176)
                .setUnlocalizedName("cagemagmacube");
            CagedWitch = new CritterCage(BaseItemID + 17, 177).setUnlocalizedName("cagewitch");
            CagedSheep = new CritterCage(BaseItemID + 18, 178).setUnlocalizedName("cagesheep");
            CagedWolf = new CritterCage(BaseItemID + 19, 179).setUnlocalizedName("cagewolf");
            CagedMooshroom = new CritterCage(BaseItemID + 20, 180)
                .setUnlocalizedName("cagemooshroom");
            CagedOcelot = new CritterCage(BaseItemID + 21, 181).setUnlocalizedName("cageocelot");
            CagedBlaze = new CritterCage(BaseItemID + 22, 182).setUnlocalizedName("cageblaze");
            CagedGirlfriend = new CritterCage(BaseItemID + 23, 183)
                .setUnlocalizedName("cagegirlfriend");
            CagedBoyfriend = new CritterCage(BaseItemID + 95, 215)
                .setUnlocalizedName("cageboyfriend");
            CagedWitherSkeleton = new CritterCage(BaseItemID + 24, 188)
                .setUnlocalizedName("cagewitherskeleton");
            CagedEnderDragon = new CritterCage(BaseItemID + 25, 184)
                .setUnlocalizedName("cageenderdragon");
            CagedSnowGolem = new CritterCage(BaseItemID + 26, 185)
                .setUnlocalizedName("cagesnowgolem");
            CagedIronGolem = new CritterCage(BaseItemID + 27, 186)
                .setUnlocalizedName("cageirongolem");
            CagedWitherBoss = new CritterCage(BaseItemID + 28, 187)
                .setUnlocalizedName("cagewitherboss");
            CagedRedCow = new CritterCage(BaseItemID + 29, 189).setUnlocalizedName("cageredcow");
            CagedGoldCow = new CritterCage(BaseItemID + 30, 190)
                .setUnlocalizedName("cagegoldcow");
            CagedEnchantedCow = new CritterCage(BaseItemID + 31, 191)
                .setUnlocalizedName("cageenchantedcow");
            CagedMOTHRA = new CritterCage(BaseItemID + 32, 208).setUnlocalizedName("cageMOTHRA");
            CagedAlo = new CritterCage(BaseItemID + 33, 209).setUnlocalizedName("cagealosaurus");
            CagedCryo = new CritterCage(BaseItemID + 34, 210)
                .setUnlocalizedName("cagecryolophosaurus");
            CagedCama = new CritterCage(BaseItemID + 35, 211)
                .setUnlocalizedName("cagecamarasaurus");
            CagedVelo = new CritterCage(BaseItemID + 36, 212)
                .setUnlocalizedName("cagevelocityraptor");
            CagedHydro = new CritterCage(BaseItemID + 37, 213)
                .setUnlocalizedName("cagehydrolisc");
            CagedBasil = new CritterCage(BaseItemID + 38, 214).setUnlocalizedName("cagebasilisc");
            CagedDragonfly = new CritterCage(BaseItemID + 39, 220)
                .setUnlocalizedName("cagedragonfly");
            CagedEmperorScorpion = new CritterCage(BaseItemID + 41, 222)
                .setUnlocalizedName("cageemperorscorpion");
            CagedScorpion = new CritterCage(BaseItemID + 40, 224)
                .setUnlocalizedName("cagescorpion");
            CagedCaveFisher = new CritterCage(BaseItemID + 45, 226)
                .setUnlocalizedName("cagecavefisher");
            CagedSpyro = new CritterCage(BaseItemID + 42, 228).setUnlocalizedName("cagespyro");
            CagedBaryonyx = new CritterCage(BaseItemID + 43, 230)
                .setUnlocalizedName("cagebaryonyx");
            CagedGammaMetroid = new CritterCage(BaseItemID + 44, 232)
                .setUnlocalizedName("cagegammametroid");
            CagedCockateil = new CritterCage(BaseItemID + 46, 234)
                .setUnlocalizedName("cagecockateil");
            CagedKyuubi = new CritterCage(BaseItemID + 47, 236).setUnlocalizedName("cagekyuubi");
            CagedAlien = new CritterCage(BaseItemID + 48, 238).setUnlocalizedName("cagealien");
            CagedAttackSquid = new CritterCage(BaseItemID + 49, 240)
                .setUnlocalizedName("cageattacksquid");
            CagedWaterDragon = new CritterCage(BaseItemID + 50, 242)
                .setUnlocalizedName("cagewaterdragon");
            CagedCephadrome = new CritterCage(BaseItemID + 53, 248)
                .setUnlocalizedName("cagecephadrome");
            CagedKraken = new CritterCage(BaseItemID + 51, 244).setUnlocalizedName("cagekraken");
            CagedLizard = new CritterCage(BaseItemID + 52, 246).setUnlocalizedName("cagelizard");
            CagedDragon = new CritterCage(BaseItemID + 54, 250).setUnlocalizedName("cagedragon");
            CagedBee = new CritterCage(BaseItemID + 55, 252).setUnlocalizedName("cagebee");
            CagedHorse = new CritterCage(BaseItemID + 56, 253).setUnlocalizedName("cagehorse");
            CagedFirefly = new CritterCage(BaseItemID + 57, 255)
                .setUnlocalizedName("cagefirefly");
            CagedChipmunk = new CritterCage(BaseItemID + 58, 256)
                .setUnlocalizedName("cagechipmunk");
            CagedGazelle = new CritterCage(BaseItemID + 59, 257)
                .setUnlocalizedName("cagegazelle");
            CagedOstrich = new CritterCage(BaseItemID + 60, 258)
                .setUnlocalizedName("cageostrich");
            CagedTrooper = new CritterCage(BaseItemID + 61, 259)
                .setUnlocalizedName("cagetrooper");
            CagedSpit = new CritterCage(BaseItemID + 62, 260).setUnlocalizedName("cagespit");
            CagedStink = new CritterCage(BaseItemID + 63, 261).setUnlocalizedName("cagestink");
            CagedCreepingHorror = new CritterCage(BaseItemID + 64, 268)
                .setUnlocalizedName("cagecreepinghorror");
            CagedTerribleTerror = new CritterCage(BaseItemID + 65, 269)
                .setUnlocalizedName("cageterribleterror");
            CagedCliffRacer = new CritterCage(BaseItemID + 66, 270)
                .setUnlocalizedName("cagecliffracer");
            CagedTriffid = new CritterCage(BaseItemID + 67, 271)
                .setUnlocalizedName("cagetriffid");
            CagedPitchBlack = new CritterCage(BaseItemID + 68, 272)
                .setUnlocalizedName("cagenightmare");
            CagedLurkingTerror = new CritterCage(BaseItemID + 69, 273)
                .setUnlocalizedName("cagelurkingterror");
            CagedSmallWorm = new CritterCage(BaseItemID + 70, 281)
                .setUnlocalizedName("cagesmallworm");
            CagedMediumWorm = new CritterCage(BaseItemID + 71, 282)
                .setUnlocalizedName("cagemediumworm");
            CagedLargeWorm = new CritterCage(BaseItemID + 72, 283)
                .setUnlocalizedName("cagelargeworm");
            CagedCassowary = new CritterCage(BaseItemID + 73, 284)
                .setUnlocalizedName("cagecassowary");
            CagedCloudShark = new CritterCage(BaseItemID + 74, 285)
                .setUnlocalizedName("cagecloudshark");
            CagedGoldFish = new CritterCage(BaseItemID + 75, 286)
                .setUnlocalizedName("cagegoldfish");
            CagedLeafMonster = new CritterCage(BaseItemID + 76, 287)
                .setUnlocalizedName("cageleafmonster");
            CagedEnderKnight = new CritterCage(BaseItemID + 77, 296)
                .setUnlocalizedName("cageenderknight");
            CagedEnderReaper = new CritterCage(BaseItemID + 78, 297)
                .setUnlocalizedName("cageenderreaper");
            CagedBeaver = new CritterCage(BaseItemID + 79, 300).setUnlocalizedName("cagebeaver");
            CagedUrchin = new CritterCage(BaseItemID + 80, 323).setUnlocalizedName("cageurchin");
            CagedFlounder = new CritterCage(BaseItemID + 81, 319)
                .setUnlocalizedName("cageflounder");
            CagedSkate = new CritterCage(BaseItemID + 82, 322).setUnlocalizedName("cageskate");
            CagedRotator = new CritterCage(BaseItemID + 83, 313)
                .setUnlocalizedName("cagerotator");
            CagedPeacock = new CritterCage(BaseItemID + 84, 315)
                .setUnlocalizedName("cagepeacock");
            CagedFairy = new CritterCage(BaseItemID + 85, 316).setUnlocalizedName("cagefairy");
            CagedDungeonBeast = new CritterCage(BaseItemID + 86, 317)
                .setUnlocalizedName("cagedungeonbeast");
            CagedVortex = new CritterCage(BaseItemID + 87, 314).setUnlocalizedName("cagevortex");
            CagedRat = new CritterCage(BaseItemID + 88, 318).setUnlocalizedName("cagerat");
            CagedWhale = new CritterCage(BaseItemID + 89, 320).setUnlocalizedName("cagewhale");
            CagedIrukandji = new CritterCage(BaseItemID + 90, 321)
                .setUnlocalizedName("cageirukandji");
            CagedTRex = new CritterCage(BaseItemID + 91, 345).setUnlocalizedName("cagetrex");
            CagedHercules = new CritterCage(BaseItemID + 92, 346)
                .setUnlocalizedName("cagehercules");
            CagedMantis = new CritterCage(BaseItemID + 93, 347).setUnlocalizedName("cagemantis");
            CagedStinky = new CritterCage(BaseItemID + 94, 348).setUnlocalizedName("cagestinky");
            CagedEasterBunny = new CritterCage(BaseItemID + 96, 150)
                .setUnlocalizedName("cageeasterbunny");
            CagedCaterKiller = new CritterCage(BaseItemID + 97, 151)
                .setUnlocalizedName("cagecaterkiller");
            CagedMolenoid = new CritterCage(BaseItemID + 98, 152)
                .setUnlocalizedName("cagemolenoid");
            CagedSeaMonster = new CritterCage(BaseItemID + 99, 153)
                .setUnlocalizedName("cageseamonster");
            CagedSeaViper = new CritterCage(BaseItemID + 174, 154)
                .setUnlocalizedName("cageseaviper");
            CagedLeon = new CritterCage(BaseItemID + 423, 357).setUnlocalizedName("cageleon");
            CagedHammerhead = new CritterCage(BaseItemID + 425, 359)
                .setUnlocalizedName("cagehammerhead");
            CagedRubberDucky = new CritterCage(BaseItemID + 427, 361)
                .setUnlocalizedName("cagerubberducky");
            CagedCrystalCow = new CritterCage(BaseItemID + 429, 216)
                .setUnlocalizedName("cagecrystalcow");
            CagedVillager = new CritterCage(BaseItemID + 430, 217)
                .setUnlocalizedName("cagevillager");
            CagedCriminal = new CritterCage(BaseItemID + 433, 218)
                .setUnlocalizedName("cagecriminal");
            CagedBrutalfly = new CritterCage(BaseItemID + 465, 373)
                .setUnlocalizedName("cagebrutalfly");
            CagedNastysaurus = new CritterCage(BaseItemID + 466, 374)
                .setUnlocalizedName("cagenastysaurus");
            CagedPointysaurus = new CritterCage(BaseItemID + 467, 375)
                .setUnlocalizedName("cagepointysaurus");
            CagedCricket = new CritterCage(BaseItemID + 468, 376)
                .setUnlocalizedName("cagecricket");
            CagedFrog = new CritterCage(BaseItemID + 469, 377).setUnlocalizedName("cagefrog");
            CagedSpiderDriver = new CritterCage(BaseItemID + 478, 382)
                .setUnlocalizedName("cagespiderdriver");
            CagedCrab = new CritterCage(BaseItemID + 483, 384).setUnlocalizedName("cagecrab");
        }

        private void DoDispenserRegistrations() {
            BlockDispenser.dispenseBehaviorRegistry.putObject(LizardEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(WitherSkeletonEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(EnderDragonEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(SnowGolemEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(IronGolemEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(WitherBossEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(GirlfriendEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(BoyfriendEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(TheKingEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(TheQueenEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(ThePrinceEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(RedCowEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CrystalCowEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(GoldCowEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(EnchantedCowEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MOTHRAEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(AloEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(CryoEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(CamaEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(VeloEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(HydroEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(BasilEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(DragonflyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(EmperorScorpionEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(ScorpionEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CaveFisherEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(SpyroEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(BaryonyxEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(GammaMetroidEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CockateilEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(KyuubiEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(AlienEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(AttackSquidEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(WaterDragonEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CephadromeEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(DragonEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(KrakenEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(LizardEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(BeeEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(TrooperBugEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(SpitBugEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(StinkBugEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(OstrichEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(GazelleEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(ChipmunkEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CreepingHorrorEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(TerribleTerrorEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CliffRacerEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(TriffidEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(PitchBlackEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(LurkingTerrorEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(GodzillaEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(SmallWormEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(MediumWormEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(LargeWormEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CassowaryEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CloudSharkEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(GoldFishEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(LeafMonsterEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(TshirtEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(EnderKnightEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(EnderReaperEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(BeaverEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(RotatorEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(VortexEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(PeacockEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(FairyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(DungeonBeastEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(RatEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(FlounderEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(WhaleEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(IrukandjiEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(SkateEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(UrchinEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(Robot1Egg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(Robot2Egg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(Robot3Egg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(Robot4Egg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(GhostEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(GhostSkellyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(BrownAntEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(RedAntEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(RainbowAntEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(UnstableAntEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(TermiteEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(ButterflyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MothEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MosquitoEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(FireflyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(TRexEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(HerculesEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MantisEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(StinkyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(Robot5Egg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(CoinEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(EasterBunnyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MolenoidEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(SeaMonsterEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(SeaViperEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(CaterKillerEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(LeonEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(HammerheadEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(RubberDuckyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(CriminalEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(BrutalflyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(NastysaurusEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(PointysaurusEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(CricketEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(ThePrincessEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(FrogEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(JefferyEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(AntRobotEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(SpiderRobotEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(SpiderDriverEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry.putObject(CrabEgg, new DispenserBehaviorOreSpawnEgg());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(MyIrukandjiArrow, new MyDispenserBehaviorArrow());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyWaterBall, new MyDispenserBehaviorWDCharge());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(MySunspotUrchin, new MyDispenserBehaviorSunspotUrchin());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyAcid, new MyDispenserBehaviorAcid());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyIceBall, new MyDispenserBehaviorIceball());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(MyIrukandji, new MyDispenserBehaviorDeadIrukandji());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyLaserBall, new MyDispenserBehaviorLaserball());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MySmallRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyRedRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyCrystalRedRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(MyCrystalGreenRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry
                .putObject(MyCrystalBlueRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyCrystalTNTRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyBlueRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyGreenRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyPurpleRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MySpikeyRock, new MyDispenserBehaviorRock());
            BlockDispenser.dispenseBehaviorRegistry.putObject(MyTNTRock, new MyDispenserBehaviorRock());
        }

        @Mod.EventHandler
        public void load(final FMLInitializationEvent event) {}

        @Mod.EventHandler
        public static void postInit(final FMLPostInitializationEvent event) {
            BMaze = new BasiliskMaze();
            RubyDungeon = new RubyBirdDungeon();
            MyDungeon = new GenericDungeon();
            OreSpawnTrees = new Trees();
            OreSpawnUtils = new MyUtils();
            Chunker = new ChunkOreGenerator();
        }

        @SideOnly(Side.CLIENT)
        public Entity spawnEntity(final int entityId, final World world, final double scaledX, final double scaledY,
                                  final double scaledZ) {
            return null;
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
            if (par2 >= 256) {
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

        private ArmorStats get_armorstats(final Configuration config, final String s, final int dura, final int head,
                                          final int chest, final int leg, final int boots, final int enchant, final int e_resp, final int e_aqua,
                                          final int e_prot, final int e_fire, final int e_blast, final int e_proj, final int e_unbreak,
                                          final int e_feather) {
            final ArmorStats a = new ArmorStats();
            final String arm = "OreSpawnARMOR";
            a.durability = config.get(arm, s + "_durability", dura)
                .getInt();
            if (a.durability < dura / 2) {
                a.durability = dura / 2;
            }
            if (a.durability > dura * 2) {
                a.durability = dura * 2;
            }
            a.head_protection = config.get(arm, s + "_head_damage_reduce", head)
                .getInt();
            if (a.head_protection < head - 2) {
                a.head_protection = head - 2;
            }
            a.chest_protection = config.get(arm, s + "_chest_damage_reduce", chest)
                .getInt();
            if (a.chest_protection < chest - 2) {
                a.chest_protection = chest - 2;
            }
            a.leg_protection = config.get(arm, s + "_leggings_damage_reduce", leg)
                .getInt();
            if (a.leg_protection < leg - 2) {
                a.leg_protection = leg - 2;
            }
            a.boot_protection = config.get(arm, s + "_boots_damage_reduce", boots)
                .getInt();
            if (a.boot_protection < boots - 2) {
                a.boot_protection = boots - 2;
            }
            a.enchantability = config.get(arm, s + "_enchantability", enchant)
                .getInt();
            if (a.enchantability < enchant / 2) {
                a.enchantability = enchant / 2;
            }
            if (a.enchantability > enchant * 2) {
                a.enchantability = enchant * 2;
            }
            a.e_respiration = config.get(arm, s + "_enchant_respiration", e_resp)
                .getInt();
            if (a.e_respiration < e_resp / 2) {
                a.e_respiration = e_resp / 2;
            }
            a.e_aquaaffinity = config.get(arm, s + "_enchant_aquaaffinity", e_aqua)
                .getInt();
            if (a.e_aquaaffinity < e_aqua / 2) {
                a.e_aquaaffinity = e_aqua / 2;
            }
            a.e_protection = config.get(arm, s + "_enchant_protection", e_prot)
                .getInt();
            if (a.e_protection < e_prot / 2) {
                a.e_protection = e_prot / 2;
            }
            a.e_fireprotection = config.get(arm, s + "_enchant_fireprotection", e_fire)
                .getInt();
            if (a.e_fireprotection < e_fire / 2) {
                a.e_fireprotection = e_fire / 2;
            }
            a.e_blastprotection = config.get(arm, s + "_enchant_blastprotection", e_blast)
                .getInt();
            if (a.e_blastprotection < e_blast / 2) {
                a.e_blastprotection = e_blast / 2;
            }
            a.e_projectileprotection = config.get(arm, s + "_enchant_projectileprotection", e_proj)
                .getInt();
            if (a.e_projectileprotection < e_proj / 2) {
                a.e_projectileprotection = e_proj / 2;
            }
            a.e_unbreaking = config.get(arm, s + "_enchant_unbreaking", e_unbreak)
                .getInt();
            if (a.e_unbreaking < e_unbreak / 2) {
                a.e_unbreaking = e_unbreak / 2;
            }
            a.e_featherfalling = config.get(arm, s + "_enchant_featherfalling", e_feather)
                .getInt();
            if (a.e_featherfalling < e_feather / 2) {
                a.e_featherfalling = e_feather / 2;
            }
            return a;
        }

        private WeaponStats get_weaponstats(final Configuration config, final String arm, final String s, final int harvest,
                                            final int maxuses, final int efficiency, final int damage, final int enchantability) {
            final WeaponStats w = new WeaponStats();
            w.harvestlevel = config.get(arm, s + "_harvestlevel", harvest)
                .getInt();
            if (w.harvestlevel < harvest - 1) {
                w.harvestlevel = harvest;
            }
            w.maxuses = config.get(arm, s + "_maxuses", maxuses)
                .getInt();
            if (w.maxuses < maxuses / 2) {
                w.maxuses = maxuses / 2;
            }
            if (w.maxuses > maxuses * 2) {
                w.maxuses = maxuses * 2;
            }
            w.efficiency = config.get(arm, s + "_efficiency", efficiency)
                .getInt();
            if (w.efficiency < efficiency / 2) {
                w.efficiency = efficiency / 2;
            }
            if (w.efficiency > efficiency * 2) {
                w.efficiency = efficiency * 2;
            }
            w.damage = config.get(arm, s + "_damage", damage)
                .getInt();
            if (w.damage < damage / 2) {
                w.damage = damage / 2;
            }
            if (w.damage > damage * 2) {
                w.damage = damage * 2;
            }
            w.enchantability = config.get(arm, s + "_enchantability", enchantability)
                .getInt();
            if (w.enchantability < enchantability / 2) {
                w.enchantability = enchantability / 2;
            }
            if (w.enchantability > enchantability * 2) {
                w.enchantability = enchantability * 2;
            }
            return w;
        }

        private MobStats get_mobstats(final Configuration config, final String arm, final String s, final int health,
                                      final int attack, final int defense) {
            final MobStats m = new MobStats();
            m.health = config.get(arm, s + "_health", health)
                .getInt();
            if (m.health < health / 2) {
                m.health = health / 2;
            }
            if (m.health > health * 2) {
                m.health = health * 2;
            }
            m.attack = config.get(arm, s + "_attack", attack)
                .getInt();
            if (m.attack < attack / 2) {
                m.attack = attack / 2;
            }
            if (m.attack > attack * 2) {
                m.attack = attack * 2;
            }
            m.defense = config.get(arm, s + "_defense", defense)
                .getInt();
            if (m.defense < defense - 4) {
                m.defense = defense - 4;
            }
            if (m.defense > defense + 4) {
                m.defense = defense + 4;
            }
            if (m.defense > 22) {
                m.defense = 22;
            }
            if (m.defense < 0) {
                m.defense = 0;
            }
            return m;
        }

        private OreStats get_orestats(final Configuration config, final String arm, final String s, final int rate,
                                      final int clumpsize, final int min, final int max) {
            final OreStats o = new OreStats();
            o.rate = config.get(arm, s + "_rate", rate)
                .getInt();
            if (o.rate < rate / 2) {
                o.rate = rate / 2;
            }
            if (o.rate > rate * 2) {
                o.rate = rate * 2;
            }
            o.clumpsize = config.get(arm, s + "_clumpsize", clumpsize)
                .getInt();
            if (o.clumpsize < clumpsize / 2) {
                o.clumpsize = clumpsize / 2;
            }
            if (o.clumpsize > clumpsize * 2) {
                o.clumpsize = clumpsize * 2;
            }
            if (o.clumpsize < 1) {
                o.clumpsize = 1;
            }
            o.mindepth = config.get(arm, s + "_mindepth", min)
                .getInt();
            if (o.mindepth < 0) {
                o.mindepth = 0;
            }
            o.maxdepth = config.get(arm, s + "_maxdepth", max)
                .getInt();
            if (o.maxdepth < 0) {
                o.maxdepth = 0;
            }
            if (o.maxdepth - o.mindepth < 10) {
                o.mindepth = min;
                o.maxdepth = max;
            }
            return o;
        }

        private void disableAllMobs() {
            MosquitoEnable = 0;
            GhostEnable = 0;
            GhostSkellyEnable = 0;
            SpiderDriverEnable = 0;
            CrabEnable = 0;
            JefferyEnable = 0;
            MothraEnable = 0;
            BrutalflyEnable = 0;
            NastysaurusEnable = 0;
            PointysaurusEnable = 0;
            MothraPeaceful = 0;
            BlackAntEnable = 0;
            RedAntEnable = 0;
            TermiteEnable = 0;
            UnstableAntEnable = 0;
            RainbowAntEnable = 0;
            AlosaurusEnable = 0;
            HammerheadEnable = 0;
            LeonEnable = 0;
            CaterKillerEnable = 0;
            MolenoidEnable = 0;
            TRexEnable = 0;
            CriminalEnable = 0;
            CryolophosaurusEnable = 0;
            RatEnable = 0;
            UrchinEnable = 0;
            CamarasaurusEnable = 0;
            VelocityRaptorEnable = 0;
            HydroliscEnable = 0;
            SpyroEnable = 0;
            BaryonyxEnable = 0;
            CockateilEnable = 0;
            CassowaryEnable = 0;
            EasterBunnyEnable = 0;
            PeacockEnable = 0;
            KyuubiEnable = 0;
            CephadromeEnable = 0;
            DragonEnable = 0;
            GammaMetroidEnable = 0;
            BasiliskEnable = 0;
            DragonflyEnable = 0;
            EmperorScorpionEnable = 0;
            TrooperBugEnable = 0;
            SpitBugEnable = 0;
            StinkBugEnable = 0;
            ScorpionEnable = 0;
            CaveFisherEnable = 0;
            AlienEnable = 0;
            WaterDragonEnable = 0;
            SeaMonsterEnable = 0;
            SeaViperEnable = 0;
            AttackSquidEnable = 0;
            Robot1Enable = 0;
            Robot2Enable = 0;
            Robot3Enable = 0;
            Robot4Enable = 0;
            Robot5Enable = 0;
            RotatorEnable = 0;
            VortexEnable = 0;
            DungeonBeastEnable = 0;
            KrakenEnable = 0;
            LizardEnable = 0;
            RubberDuckyEnable = 0;
            GirlfriendEnable = 0;
            BoyfriendEnable = 0;
            FireflyEnable = 0;
            FairyEnable = 0;
            BeeEnable = 0;
            TheKingEnable = 0;
            TheQueenEnable = 0;
            MantisEnable = 0;
            StinkyEnable = 0;
            HerculesBeetleEnable = 0;
            ChipmunkEnable = 0;
            OstrichEnable = 0;
            GazelleEnable = 0;
            CowEnable = 0;
            ButterflyEnable = 0;
            MothEnable = 0;
            TshirtEnable = 0;
            CoinEnable = 0;
            CreepingHorrorEnable = 0;
            TerribleTerrorEnable = 0;
            CliffRacerEnable = 0;
            TriffidEnable = 0;
            WormEnable = 0;
            CloudSharkEnable = 0;
            GoldFishEnable = 0;
            LeafMonsterEnable = 0;
            EnderKnightEnable = 0;
            EnderReaperEnable = 0;
            BeaverEnable = 0;
            IrukandjiEnable = 0;
            SkateEnable = 0;
            WhaleEnable = 0;
            FlounderEnable = 0;
            PitchBlackEnable = 0;
            LurkingTerrorEnable = 0;
            GodzillaEnable = 0;
        }

        private void laySomeEggs() {
            MySpiderSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID)
                .setBlockName("orespider");
            MyBatSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 1)
                .setBlockName("orebat");
            MyCowSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 2)
                .setBlockName("orecow");
            MyPigSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 3)
                .setBlockName("orepig");
            MySquidSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 4)
                .setBlockName("oresquid");
            MyChickenSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 5)
                .setBlockName("orechicken");
            MyCreeperSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 6)
                .setBlockName("orecreeper");
            MySkeletonSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 7)
                .setBlockName("oreskeleton");
            MyZombieSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 8)
                .setBlockName("orezombie");
            MySlimeSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 9)
                .setBlockName("oreslime");
            MyGhastSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 10)
                .setBlockName("oreghast");
            MyZombiePigmanSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 11)
                .setBlockName("orezombiepigman");
            MyEndermanSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 12)
                .setBlockName("oreenderman");
            MyCaveSpiderSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 13)
                .setBlockName("orecavespider");
            MySilverfishSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 14)
                .setBlockName("oresilverfish");
            MyMagmaCubeSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 15)
                .setBlockName("oremagmacube");
            MyWitchSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 16)
                .setBlockName("orewitch");
            MySheepSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 17)
                .setBlockName("oresheep");
            MyWolfSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 18)
                .setBlockName("orewolf");
            MyMooshroomSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 19)
                .setBlockName("oremooshroom");
            MyOcelotSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 20)
                .setBlockName("oreocelot");
            MyBlazeSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 21)
                .setBlockName("oreblaze");
            MyWitherSkeletonSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 22)
                .setBlockName("orewitherskeleton");
            MyEnderDragonSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 23)
                .setBlockName("oreenderdragon");
            MySnowGolemSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 24)
                .setBlockName("oresnowgolem");
            MyIronGolemSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 25)
                .setBlockName("oreirongolem");
            MyWitherBossSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 26)
                .setBlockName("orewitherboss");
            MyGirlfriendSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 27)
                .setBlockName("oregirlfriend");
            MyBoyfriendSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 84)
                .setBlockName("oreboyfriend");
            MyRedCowSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 28)
                .setBlockName("oreredcow");
            MyCrystalCowSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 261)
                .setBlockName("orecrystalcow");
            MyVillagerSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 94)
                .setBlockName("orevillager");
            MyGoldCowSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 29)
                .setBlockName("oregoldcow");
            MyEnchantedCowSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 30)
                .setBlockName("oreenchantedcow");
            MyMOTHRASpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 31)
                .setBlockName("oreMOTHRA");
            MyAntBlock = new AntBlock(BaseBlockID + 115).setBlockName("AntBlock");
            MyRedAntBlock = new AntBlock(BaseBlockID + 116).setBlockName("RedAntBlock");
            TermiteBlock = new AntBlock(BaseBlockID + 120).setBlockName("TermiteBlock");
            CrystalTermiteBlock = new CrystalAntBlock(BaseBlockID + 121)
                .setBlockName("CrystalTermiteBlock");
            MyRainbowAntBlock = new AntBlock(BaseBlockID + 117).setBlockName("RainbowAntBlock");
            MyUnstableAntBlock = new AntBlock(BaseBlockID + 118).setBlockName("UnstableAntBlock");
            MyAloSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 32)
                .setBlockName("orealosaurus");
            MyCryoSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 33)
                .setBlockName("orecryolophosaurus");
            MyCamaSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 34)
                .setBlockName("orecamarasaurus");
            MyVeloSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 35)
                .setBlockName("orevelocityraptor");
            MyHydroSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 36)
                .setBlockName("orehydrolisc");
            MyBasilSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 37)
                .setBlockName("orebasilisc");
            MyDragonflySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 38)
                .setBlockName("oredragonfly");
            MyEmperorScorpionSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 39)
                .setBlockName("oreemperorscorpion");
            MyScorpionSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 40)
                .setBlockName("orescorpion");
            MyCaveFisherSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 41)
                .setBlockName("orecavefisher");
            MySpyroSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 42)
                .setBlockName("orespyro");
            MyBaryonyxSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 43)
                .setBlockName("orebaryonyx");
            MyGammaMetroidSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 44)
                .setBlockName("oregammametroid");
            MyCockateilSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 45)
                .setBlockName("orecockateil");
            MyKyuubiSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 46)
                .setBlockName("orekyuubi");
            MyAlienSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 47)
                .setBlockName("orealien");
            MyAttackSquidSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 48)
                .setBlockName("oreattacksquid");
            MyWaterDragonSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 49)
                .setBlockName("orewaterdragon");
            MyCephadromeSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 52)
                .setBlockName("orecephadrome");
            MyDragonSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 53)
                .setBlockName("oredragon");
            MyKrakenSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 50)
                .setBlockName("orekraken");
            MyLizardSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 51)
                .setBlockName("orelizard");
            MyBeeSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 54)
                .setBlockName("orebee");
            MyHorseSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 55)
                .setBlockName("orehorse");
            MyTrooperBugSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 56)
                .setBlockName("oretrooper");
            MySpitBugSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 57)
                .setBlockName("orespit");
            MyStinkBugSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 58)
                .setBlockName("orestink");
            MyOstrichSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 59)
                .setBlockName("oreostrich");
            MyGazelleSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 60)
                .setBlockName("oregazelle");
            MyChipmunkSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 61)
                .setBlockName("orechipmunk");
            MyCreepingHorrorSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 62)
                .setBlockName("orecreepinghorror");
            MyTerribleTerrorSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 63)
                .setBlockName("oreterribleterror");
            MyCliffRacerSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 64)
                .setBlockName("orecliffracer");
            MyTriffidSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 65)
                .setBlockName("oretriffid");
            MyPitchBlackSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 66)
                .setBlockName("orenightmare");
            MyLurkingTerrorSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 67)
                .setBlockName("orelurkingterror");
            MyGodzillaPartSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 68)
                .setBlockName("oregodzillapart");
            MyGodzillaSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 119)
                .setBlockName("oregodzilla");
            MySmallWormSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 69)
                .setBlockName("oresmallworm");
            MyMediumWormSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 70)
                .setBlockName("oremediumworm");
            MyLargeWormSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 71)
                .setBlockName("orelargeworm");
            MyCassowarySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 72)
                .setBlockName("orecassowary");
            MyCloudSharkSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 73)
                .setBlockName("orecloudshark");
            MyGoldFishSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 74)
                .setBlockName("oregoldfish");
            MyLeafMonsterSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 75)
                .setBlockName("oreleafmonster");
            MyTshirtSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 76)
                .setBlockName("oretshirt");
            MyEnderKnightSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 77)
                .setBlockName("oreenderknight");
            MyEnderReaperSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 78)
                .setBlockName("oreenderreaper");
            MyBeaverSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 79)
                .setBlockName("orebeaver");
            MyUrchinSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 250)
                .setBlockName("oreurchin");
            MyFlounderSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 251)
                .setBlockName("oreflounder");
            MySkateSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 252)
                .setBlockName("oreskate");
            MyRotatorSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 253)
                .setBlockName("orerotator");
            MyPeacockSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 254)
                .setBlockName("orepeacock");
            MyFairySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 255)
                .setBlockName("orefairy");
            MyDungeonBeastSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 256)
                .setBlockName("oredungeonbeast");
            MyVortexSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 257)
                .setBlockName("orevortex");
            MyRatSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 258)
                .setBlockName("orerat");
            MyWhaleSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 259)
                .setBlockName("orewhale");
            MyIrukandjiSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 260)
                .setBlockName("oreirukandji");
            MyTRexSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 80)
                .setBlockName("oretrex");
            MyHerculesSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 81)
                .setBlockName("orehercules");
            MyMantisSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 82)
                .setBlockName("oremantis");
            MyStinkySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 83)
                .setBlockName("orestinky");
            MyTheKingPartSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 85)
                .setBlockName("orethekingpart");
            MyTheKingSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 122)
                .setBlockName("oretheking");
            MyTheQueenPartSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 96)
                .setBlockName("orethequeenpart");
            MyTheQueenSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 125)
                .setBlockName("orethequeen");
            MyEasterBunnySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 86)
                .setBlockName("oreeasterbunny");
            MyCaterKillerSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 87)
                .setBlockName("orecaterkiller");
            MyMolenoidSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 88)
                .setBlockName("oremolenoid");
            MySeaMonsterSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 89)
                .setBlockName("oreseamonster");
            MySeaViperSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 90)
                .setBlockName("oreseaviper");
            MyLeonSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 91)
                .setBlockName("oreleon");
            MyHammerheadSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 92)
                .setBlockName("orehammerhead");
            MyRubberDuckySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 93)
                .setBlockName("orerubberducky");
            MyCriminalSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 95)
                .setBlockName("orecriminal");
            MyBrutalflySpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 300)
                .setBlockName("orebrutalfly");
            MyNastysaurusSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 301)
                .setBlockName("orenastysaurus");
            MyPointysaurusSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 302)
                .setBlockName("orepointysaurus");
            MyCricketSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 303)
                .setBlockName("orecricket");
            MyFrogSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 304)
                .setBlockName("orefrog");
            MySpiderDriverSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 305)
                .setBlockName("orespiderdriver");
            MyCrabSpawnBlock = (OreGenericEgg) new OreGenericEgg(BaseBlockID + 306)
                .setBlockName("orecrab");
        }

        private void getMobs(final Configuration config, final String mobs) {
            MosquitoEnable = config.get(mobs, "MosquitoEnable", 1)
                .getInt();
            RockEnable = config.get(mobs, "RockEnable", 1)
                .getInt();
            GhostEnable = config.get(mobs, "GhostEnable", 1)
                .getInt();
            GhostSkellyEnable = config.get(mobs, "GhostSkellyEnable", 1)
                .getInt();
            SpiderDriverEnable = config.get(mobs, "SpiderDriverEnable", 1)
                .getInt();
            JefferyEnable = config.get(mobs, "JefferyEnable", 1)
                .getInt();
            MothraEnable = config.get(mobs, "MothraEnable", 1)
                .getInt();
            BrutalflyEnable = config.get(mobs, "BrutalflyEnable", 1)
                .getInt();
            NastysaurusEnable = config.get(mobs, "NastysaurusEnable", 1)
                .getInt();
            PointysaurusEnable = config.get(mobs, "PointysaurusEnable", 1)
                .getInt();
            CricketEnable = config.get(mobs, "CricketEnable", 1)
                .getInt();
            FrogEnable = config.get(mobs, "FrogEnable", 1)
                .getInt();
            MothraPeaceful = config.get(mobs, "MothraPeaceful", 0)
                .getInt();
            BlackAntEnable = config.get(mobs, "BlackAntEnable", 1)
                .getInt();
            RedAntEnable = config.get(mobs, "RedAntEnable", 1)
                .getInt();
            TermiteEnable = config.get(mobs, "TermiteEnable", 1)
                .getInt();
            UnstableAntEnable = config.get(mobs, "UnstableAntEnable", 1)
                .getInt();
            RainbowAntEnable = config.get(mobs, "RainbowedAntEnable", 1)
                .getInt();
            AlosaurusEnable = config.get(mobs, "AlosaurusEnable", 1)
                .getInt();
            HammerheadEnable = config.get(mobs, "HammerheadEnable", 1)
                .getInt();
            LeonEnable = config.get(mobs, "LeonEnable", 1)
                .getInt();
            CaterKillerEnable = config.get(mobs, "CaterKillerEnable", 1)
                .getInt();
            MolenoidEnable = config.get(mobs, "MolenoidEnable", 1)
                .getInt();
            TRexEnable = config.get(mobs, "TRexEnable", 1)
                .getInt();
            CriminalEnable = config.get(mobs, "CriminalEnable", 1)
                .getInt();
            CryolophosaurusEnable = config.get(mobs, "CryolophosaurusEnable", 1)
                .getInt();
            RatEnable = config.get(mobs, "RatEnable", 1)
                .getInt();
            UrchinEnable = config.get(mobs, "UrchinEnable", 1)
                .getInt();
            CamarasaurusEnable = config.get(mobs, "CamarasaurusEnable", 1)
                .getInt();
            VelocityRaptorEnable = config.get(mobs, "VelocityRaptorEnable", 1)
                .getInt();
            HydroliscEnable = config.get(mobs, "HydroliscEnable", 1)
                .getInt();
            SpyroEnable = config.get(mobs, "SpyroEnable", 1)
                .getInt();
            BaryonyxEnable = config.get(mobs, "BaryonyxEnable", 1)
                .getInt();
            CockateilEnable = config.get(mobs, "BirdEnable", 1)
                .getInt();
            CassowaryEnable = config.get(mobs, "CassowaryEnable", 1)
                .getInt();
            EasterBunnyEnable = config.get(mobs, "EasterBunnyEnable", 1)
                .getInt();
            PeacockEnable = config.get(mobs, "PeacockEnable", 1)
                .getInt();
            KyuubiEnable = config.get(mobs, "KyuubiEnable", 1)
                .getInt();
            CephadromeEnable = config.get(mobs, "CephadromeEnable", 1)
                .getInt();
            DragonEnable = config.get(mobs, "DragonEnable", 1)
                .getInt();
            GammaMetroidEnable = config.get(mobs, "GammaMetroidEnable", 1)
                .getInt();
            BasiliskEnable = config.get(mobs, "BasiliskEnable", 1)
                .getInt();
            DragonflyEnable = config.get(mobs, "DragonflyEnable", 1)
                .getInt();
            EmperorScorpionEnable = config.get(mobs, "EmperorScorpionEnable", 1)
                .getInt();
            TrooperBugEnable = config.get(mobs, "TrooperBugEnable", 1)
                .getInt();
            SpitBugEnable = config.get(mobs, "SpitBugEnable", 1)
                .getInt();
            StinkBugEnable = config.get(mobs, "StinkBugEnable", 1)
                .getInt();
            ScorpionEnable = config.get(mobs, "ScorpionEnable", 1)
                .getInt();
            CaveFisherEnable = config.get(mobs, "CaveFisherEnable", 1)
                .getInt();
            AlienEnable = config.get(mobs, "AlienEnable", 1)
                .getInt();
            WaterDragonEnable = config.get(mobs, "WaterDragonEnable", 1)
                .getInt();
            SeaMonsterEnable = config.get(mobs, "SeaMonsterEnable", 1)
                .getInt();
            SeaViperEnable = config.get(mobs, "SeaViperEnable", 1)
                .getInt();
            AttackSquidEnable = config.get(mobs, "AttackSquidEnable", 1)
                .getInt();
            Robot1Enable = config.get(mobs, "Robot1Enable", 1)
                .getInt();
            Robot2Enable = config.get(mobs, "Robot2Enable", 1)
                .getInt();
            Robot3Enable = config.get(mobs, "Robot3Enable", 1)
                .getInt();
            Robot4Enable = config.get(mobs, "Robot4Enable", 1)
                .getInt();
            Robot5Enable = config.get(mobs, "Robot5Enable", 1)
                .getInt();
            RotatorEnable = config.get(mobs, "RotatorEnable", 1)
                .getInt();
            VortexEnable = config.get(mobs, "VortexEnable", 1)
                .getInt();
            DungeonBeastEnable = config.get(mobs, "DungeonBeastEnable", 1)
                .getInt();
            KrakenEnable = config.get(mobs, "KrakenEnable", 1)
                .getInt();
            LizardEnable = config.get(mobs, "LizardEnable", 1)
                .getInt();
            RubberDuckyEnable = config.get(mobs, "RubberDuckyEnable", 1)
                .getInt();
            GirlfriendEnable = config.get(mobs, "GirlfriendEnable", 1)
                .getInt();
            BoyfriendEnable = config.get(mobs, "BoyfriendEnable", 0)
                .getInt();
            FireflyEnable = config.get(mobs, "FireflyEnable", 1)
                .getInt();
            FairyEnable = config.get(mobs, "FairyEnable", 1)
                .getInt();
            BeeEnable = config.get(mobs, "BeeEnable", 1)
                .getInt();
            TheKingEnable = config.get(mobs, "TheKingEnable", 1)
                .getInt();
            TheQueenEnable = config.get(mobs, "TheQueenEnable", 1)
                .getInt();
            MantisEnable = config.get(mobs, "MantisEnable", 1)
                .getInt();
            StinkyEnable = config.get(mobs, "StinkyEnable", 1)
                .getInt();
            HerculesBeetleEnable = config.get(mobs, "HerculesBeetleEnable", 1)
                .getInt();
            ChipmunkEnable = config.get(mobs, "ChipmunkEnable", 1)
                .getInt();
            OstrichEnable = config.get(mobs, "OstrichEnable", 1)
                .getInt();
            GazelleEnable = config.get(mobs, "GazelleEnable", 1)
                .getInt();
            CowEnable = config.get(mobs, "CowEnable", 1)
                .getInt();
            ButterflyEnable = config.get(mobs, "ButterflyEnable", 1)
                .getInt();
            MothEnable = config.get(mobs, "MothEnable", 1)
                .getInt();
            TshirtEnable = config.get(mobs, "TshirtEnable", 1)
                .getInt();
            CoinEnable = config.get(mobs, "CoinEnable", 1)
                .getInt();
            CreepingHorrorEnable = config.get(mobs, "CreepingHorrorEnable", 1)
                .getInt();
            TerribleTerrorEnable = config.get(mobs, "TerribleTerrorEnable", 1)
                .getInt();
            CliffRacerEnable = config.get(mobs, "CliffRacerEnable", 1)
                .getInt();
            TriffidEnable = config.get(mobs, "TriffidEnable", 1)
                .getInt();
            WormEnable = config.get(mobs, "WormEnable", 1)
                .getInt();
            CloudSharkEnable = config.get(mobs, "CloudSharkEnable", 1)
                .getInt();
            GoldFishEnable = config.get(mobs, "GoldFishEnable", 1)
                .getInt();
            LeafMonsterEnable = config.get(mobs, "LeafMonsterEnable", 1)
                .getInt();
            EnderKnightEnable = config.get(mobs, "EnderKnightEnable", 1)
                .getInt();
            EnderReaperEnable = config.get(mobs, "EnderReaperEnable", 1)
                .getInt();
            BeaverEnable = config.get(mobs, "BeaverEnable", 1)
                .getInt();
            IrukandjiEnable = config.get(mobs, "IrukandjiEnable", 1)
                .getInt();
            SkateEnable = config.get(mobs, "SkateEnable", 1)
                .getInt();
            WhaleEnable = config.get(mobs, "WhaleEnable", 1)
                .getInt();
            FlounderEnable = config.get(mobs, "FlounderEnable", 1)
                .getInt();
            PitchBlackEnable = config.get(mobs, "NightmareEnable", 1)
                .getInt();
            LurkingTerrorEnable = config.get(mobs, "LurkingTerrorEnable", 1)
                .getInt();
            GodzillaEnable = config.get(mobs, "GodzillaEnable", 1)
                .getInt();
            CrabEnable = config.get(mobs, "CrabEnable", 1)
                .getInt();
            Bee_stats = this.get_mobstats(config, mobs, "Bee", 80, 12, 5);
            Mantis_stats = this.get_mobstats(config, mobs, "Mantis", 120, 16, 10);
            HerculesBeetle_stats = this.get_mobstats(config, mobs, "HerculesBeetle", 250, 30, 19);
            Mothra_stats = this.get_mobstats(config, mobs, "Mothra", 150, 12, 8);
            Brutalfly_stats = this.get_mobstats(config, mobs, "Brutalfly", 110, 10, 6);
            Nastysaurus_stats = this.get_mobstats(config, mobs, "Nastysaurus", 200, 32, 17);
            Pointysaurus_stats = this.get_mobstats(config, mobs, "Pointysaurus", 80, 10, 16);
            Alosaurus_stats = this.get_mobstats(config, mobs, "Alosaurus", 110, 18, 8);
            SpiderRobot_stats = this.get_mobstats(config, mobs, "SpiderRobot", 1500, 100, 16);
            AntRobot_stats = this.get_mobstats(config, mobs, "AntRobot", 300, 30, 16);
            Jeffery_stats = this.get_mobstats(config, mobs, "Jeffery", 550, 40, 18);
            Hammerhead_stats = this.get_mobstats(config, mobs, "Hammerhead", 240, 75, 20);
            Molenoid_stats = this.get_mobstats(config, mobs, "Molenoid", 200, 18, 12);
            TRex_stats = this.get_mobstats(config, mobs, "TRex", 160, 22, 14);
            BandP_stats = this.get_mobstats(config, mobs, "BandP", 100, 1, 18);
            CaterKiller_stats = this.get_mobstats(config, mobs, "CaterKiller", 450, 32, 19);
            Cryolophosaurus_stats = this.get_mobstats(config, mobs, "Cryolophosaurus", 10, 3, 1);
            Rat_stats = this.get_mobstats(config, mobs, "Rat", 5, 3, 1);
            Urchin_stats = this.get_mobstats(config, mobs, "Urchin", 25, 10, 4);
            Kyuubi_stats = this.get_mobstats(config, mobs, "Kyuubi", 125, 10, 10);
            GammaMetroid_stats = this.get_mobstats(config, mobs, "GammaMetroid", 100, 10, 12);
            Basilisk_stats = this.get_mobstats(config, mobs, "Basilisk", 200, 24, 15);
            EmperorScorpion_stats = this.get_mobstats(config, mobs, "EmperorScorpion", 350, 35, 20);
            TrooperBug_stats = this.get_mobstats(config, mobs, "TrooperBug", 200, 20, 15);
            SpitBug_stats = this.get_mobstats(config, mobs, "SpitBug", 100, 10, 12);
            Alien_stats = this.get_mobstats(config, mobs, "Alien", 100, 12, 8);
            WaterDragon_stats = this.get_mobstats(config, mobs, "WaterDragon", 150, 20, 8);
            SeaMonster_stats = this.get_mobstats(config, mobs, "SeaMonster", 110, 14, 8);
            SeaViper_stats = this.get_mobstats(config, mobs, "SeaViper", 160, 22, 12);
            Robot2_stats = this.get_mobstats(config, mobs, "Robot2", 200, 22, 18);
            Robot3_stats = this.get_mobstats(config, mobs, "Robot3", 80, 16, 14);
            Robot4_stats = this.get_mobstats(config, mobs, "Robot4", 170, 12, 18);
            Robot5_stats = this.get_mobstats(config, mobs, "Robot5", 20, 5, 6);
            Rotator_stats = this.get_mobstats(config, mobs, "Rotator", 35, 10, 8);
            Vortex_stats = this.get_mobstats(config, mobs, "Vortex", 150, 26, 10);
            DungeonBeast_stats = this.get_mobstats(config, mobs, "DungeonBeast", 65, 12, 6);
            Triffid_stats = this.get_mobstats(config, mobs, "Triffid", 100, 20, 12);
            LurkingTerror_stats = this.get_mobstats(config, mobs, "LurkingTerror", 30, 6, 5);
            WormSmall_stats = this.get_mobstats(config, mobs, "WormSmall", 10, 3, 0);
            WormMedium_stats = this.get_mobstats(config, mobs, "WormMedium", 30, 10, 8);
            WormLarge_stats = this.get_mobstats(config, mobs, "WormLarge", 90, 18, 14);
            EnderKnight_stats = this.get_mobstats(config, mobs, "EnderKnight", 60, 12, 6);
            EnderReaper_stats = this.get_mobstats(config, mobs, "EnderReaper", 90, 18, 8);
            Irukandji_stats = this.get_mobstats(config, mobs, "Irukandji", 1, 20, 0);
            AttackSquid_stats = this.get_mobstats(config, mobs, "AttackSquid", 10, 8, 0);
            CaveFisher_stats = this.get_mobstats(config, mobs, "CaveFisher", 10, 4, 4);
            CloudShark_stats = this.get_mobstats(config, mobs, "CloudShark", 15, 6, 5);
            CreepingHorror_stats = this.get_mobstats(config, mobs, "CreepingHorror", 10, 3, 2);
            Godzilla_stats = this.get_mobstats(config, mobs, "Mobzilla", 4000, 175, 21);
            Kraken_stats = this.get_mobstats(config, mobs, "Kraken", 1000, 40, 10);
            LeafMonster_stats = this.get_mobstats(config, mobs, "LeafMonster", 6, 2, 1);
            PitchBlack_stats = this.get_mobstats(config, mobs, "Nightmare", 250, 30, 10);
            Scorpion_stats = this.get_mobstats(config, mobs, "Scorpion", 15, 4, 10);
            Skate_stats = this.get_mobstats(config, mobs, "Skate", 8, 8, 4);
            TerribleTerror_stats = this.get_mobstats(config, mobs, "TerribleTerror", 10, 5, 3);
            TheKing_stats = this.get_mobstats(config, mobs, "TheKing", 7000, 350, 21);
            TheQueen_stats = this.get_mobstats(config, mobs, "TheQueen", 6000, 225, 21);
            Leon_stats = this.get_mobstats(config, mobs, "Leonopteryx", 150, 20, 8);
            Crab_stats = this.get_mobstats(config, mobs, "Crab", 180, 24, 16);
        }

        static {
            MyKeyhandler = null;
            flyup_keystate = 0;
            BaseBlockID = 2700;
            BaseItemID = 9000;
            BaseBiomeID = 120;
            BaseDimensionID = 80;
            BiomeUtopiaID = 0;
            BiomeIslandsID = 0;
            BiomeCrystalID = 0;
            BiomeVillageID = 0;
            BiomeChaosID = 0;
            DimensionID = 0;
            DimensionID2 = 0;
            DimensionID3 = 0;
            DimensionID4 = 0;
            DimensionID5 = 0;
            DimensionID6 = 0;
            godzilla_has_spawned = 0;
            current_dimension = 0;
            valentines_day = 0;
            easter_day = 0;
            ultimate_sword_pvp = 0;
            big_bertha_pvp = 0;
            bro_mode = 0;
            enableduplicatortree = 1;
            RoyalGlideEnable = 1;
            DragonflyHorseFriendly = 0;
            PlayNicely = 0;
            MinersDreamExpensive = 0;
            DisableOverworldDungeons = 0;
            FullPowerKingEnable = 0;
            Amethyst_armorstats = null;
            Emerald_armorstats = null;
            Experience_armorstats = null;
            MothScale_armorstats = null;
            LavaEel_armorstats = null;
            Ultimate_armorstats = null;
            Pink_armorstats = null;
            TigersEye_armorstats = null;
            Peacock_armorstats = null;
            Mobzilla_armorstats = null;
            Ruby_armorstats = null;
            Royal_armorstats = null;
            Lapis_armorstats = null;
            Queen_armorstats = null;
            AllMobsDisable = 0;
            MosquitoEnable = 1;
            RockEnable = 1;
            GhostEnable = 1;
            GhostSkellyEnable = 1;
            SpiderDriverEnable = 1;
            JefferyEnable = 1;
            MothraEnable = 1;
            BrutalflyEnable = 1;
            NastysaurusEnable = 1;
            PointysaurusEnable = 1;
            CricketEnable = 1;
            FrogEnable = 1;
            MothraPeaceful = 0;
            BlackAntEnable = 1;
            RedAntEnable = 1;
            TermiteEnable = 1;
            UnstableAntEnable = 1;
            RainbowAntEnable = 1;
            AlosaurusEnable = 1;
            HammerheadEnable = 1;
            LeonEnable = 1;
            CaterKillerEnable = 1;
            MolenoidEnable = 1;
            TRexEnable = 1;
            CriminalEnable = 1;
            CryolophosaurusEnable = 1;
            RatEnable = 1;
            RatPlayerFriendly = 0;
            RatPetFriendly = 0;
            UrchinEnable = 1;
            CamarasaurusEnable = 1;
            ChipmunkEnable = 1;
            OstrichEnable = 1;
            GazelleEnable = 1;
            VelocityRaptorEnable = 1;
            HydroliscEnable = 1;
            SpyroEnable = 1;
            BaryonyxEnable = 1;
            CockateilEnable = 1;
            CassowaryEnable = 1;
            EasterBunnyEnable = 1;
            PeacockEnable = 1;
            KyuubiEnable = 1;
            CephadromeEnable = 1;
            DragonEnable = 1;
            GammaMetroidEnable = 1;
            BasiliskEnable = 1;
            DragonflyEnable = 1;
            EmperorScorpionEnable = 1;
            TrooperBugEnable = 1;
            SpitBugEnable = 1;
            StinkBugEnable = 1;
            ScorpionEnable = 1;
            CaveFisherEnable = 1;
            AlienEnable = 1;
            WaterDragonEnable = 1;
            SeaMonsterEnable = 1;
            SeaViperEnable = 1;
            AttackSquidEnable = 1;
            GodzillaEnable = 1;
            LessOre = 0;
            LessLag = 0;
            Robot1Enable = 1;
            Robot2Enable = 1;
            Robot3Enable = 1;
            Robot4Enable = 1;
            Robot5Enable = 1;
            RotatorEnable = 1;
            VortexEnable = 1;
            DungeonBeastEnable = 1;
            KrakenEnable = 1;
            LizardEnable = 1;
            RubberDuckyEnable = 1;
            GirlfriendEnable = 1;
            BoyfriendEnable = 0;
            FireflyEnable = 1;
            FairyEnable = 1;
            BeeEnable = 1;
            TheKingEnable = 1;
            TheQueenEnable = 1;
            ThePrinceEnable = 1;
            ThePrincessEnable = 1;
            MantisEnable = 1;
            StinkyEnable = 1;
            HerculesBeetleEnable = 1;
            CowEnable = 1;
            ButterflyEnable = 1;
            MothEnable = 1;
            TshirtEnable = 1;
            CoinEnable = 1;
            CreepingHorrorEnable = 1;
            TerribleTerrorEnable = 1;
            CliffRacerEnable = 1;
            TriffidEnable = 1;
            UltimateSwordMagic = 10;
            UltimateBowDamage = 10;
            PitchBlackEnable = 1;
            NightmareSize = 0;
            LurkingTerrorEnable = 1;
            IslandSpeedFactor = 2;
            IslandSizeFactor = 2;
            GinormousEmeraldTreeEnable = 1;
            GuiOverlayEnable = 1;
            FastGraphicsLeaves = 0;
            WormEnable = 1;
            CloudSharkEnable = 1;
            GoldFishEnable = 1;
            LeafMonsterEnable = 1;
            EnderKnightEnable = 1;
            EnderReaperEnable = 1;
            BeaverEnable = 1;
            IrukandjiEnable = 1;
            SkateEnable = 1;
            WhaleEnable = 1;
            FlounderEnable = 1;
            CrabEnable = 1;
            OreSpawnRand = new Random(151L);
            OreSpawnTrees = null;
            ultimate_stats = null;
            nightmare_stats = null;
            bertha_stats = null;
            crystalwood_stats = null;
            crystalstone_stats = null;
            crystalpink_stats = null;
            tigerseye_stats = null;
            ruby_stats = null;
            amethyst_stats = null;
            emerald_stats = null;
            royal_stats = null;
            hammy_stats = null;
            battleaxe_stats = null;
            queenbattleaxe_stats = null;
            chainsaw_stats = null;
            GirlfriendID = 0;
            BoyfriendID = 0;
            RedCowID = 0;
            GoldCowID = 0;
            CrystalCowID = 0;
            ButterflyID = 0;
            FireflyID = 0;
            FairyID = 0;
            BeeID = 0;
            TheKingID = 0;
            TheQueenID = 0;
            ThePrinceID = 0;
            ThePrincessID = 0;
            ThePrinceTeenID = 0;
            ThePrinceAdultID = 0;
            MantisID = 0;
            StinkyID = 0;
            HerculesBeetleID = 0;
            LunaMothID = 0;
            MosquitoID = 0;
            GhostID = 0;
            GhostSkellyID = 0;
            SpiderRobotID = 0;
            AntRobotID = 0;
            JefferyID = 0;
            SpiderDriverID = 0;
            MothraID = 0;
            BrutalflyID = 0;
            NastysaurusID = 0;
            PointysaurusID = 0;
            CricketID = 0;
            FrogID = 0;
            EnchantedCowID = 0;
            AntID = 0;
            UnstableAntID = 0;
            RedAntID = 0;
            TermiteID = 0;
            RockBaseID = 0;
            RainbowAntID = 0;
            AlosaurusID = 0;
            LeonID = 0;
            CaterKillerID = 0;
            MolenoidID = 0;
            TRexID = 0;
            BandPID = 0;
            CryolophosaurusID = 0;
            RatID = 0;
            UrchinID = 0;
            CamarasaurusID = 0;
            VelocityRaptorID = 0;
            HydroliscID = 0;
            SpyroID = 0;
            BaryonyxID = 0;
            CassowaryID = 0;
            EasterBunnyID = 0;
            PeacockID = 0;
            CockateilID = 0;
            RubyBirdID = 0;
            KyuubiID = 0;
            CephadromeID = 0;
            DragonID = 0;
            GammaMetroidID = 0;
            BasiliskID = 0;
            DragonflyID = 0;
            EmperorScorpionID = 0;
            TrooperBugID = 0;
            SpitBugID = 0;
            StinkBugID = 0;
            ScorpionID = 0;
            CaveFisherID = 0;
            AlienID = 0;
            WaterDragonID = 0;
            SeaMonsterID = 0;
            SeaViperID = 0;
            AttackSquidID = 0;
            ElevatorID = 0;
            Robot1ID = 0;
            Robot2ID = 0;
            Robot3ID = 0;
            Robot4ID = 0;
            Robot5ID = 0;
            RotatorID = 0;
            VortexID = 0;
            DungeonBeastID = 0;
            KrakenID = 0;
            LizardID = 0;
            RubberDuckyID = 0;
            ChipmunkID = 0;
            OstrichID = 0;
            GazelleID = 0;
            TshirtID = 0;
            CoinID = 0;
            IslandID = 0;
            IslandTooID = 0;
            CreepingHorrorID = 0;
            TerribleTerrorID = 0;
            CliffRacerID = 0;
            TriffidID = 0;
            PitchBlackID = 0;
            LurkingTerrorID = 0;
            GodzillaID = 0;
            WormSmallID = 0;
            WormMediumID = 0;
            WormLargeID = 0;
            CloudSharkID = 0;
            GoldFishID = 0;
            LeafMonsterID = 0;
            GodzillaHeadID = 0;
            KingHeadID = 0;
            QueenHeadID = 0;
            EnderKnightID = 0;
            EnderReaperID = 0;
            BeaverID = 0;
            SkateID = 0;
            IrukandjiID = 0;
            FlounderID = 0;
            WhaleID = 0;
            HammerheadID = 0;
            CrabID = 0;
            Bee_stats = null;
            Mantis_stats = null;
            HerculesBeetle_stats = null;
            Mothra_stats = null;
            Brutalfly_stats = null;
            Nastysaurus_stats = null;
            Pointysaurus_stats = null;
            Alosaurus_stats = null;
            SpiderRobot_stats = null;
            AntRobot_stats = null;
            Jeffery_stats = null;
            Hammerhead_stats = null;
            Leon_stats = null;
            CaterKiller_stats = null;
            Molenoid_stats = null;
            TRex_stats = null;
            BandP_stats = null;
            Cryolophosaurus_stats = null;
            Rat_stats = null;
            Urchin_stats = null;
            Kyuubi_stats = null;
            GammaMetroid_stats = null;
            Basilisk_stats = null;
            EmperorScorpion_stats = null;
            TrooperBug_stats = null;
            SpitBug_stats = null;
            Alien_stats = null;
            WaterDragon_stats = null;
            SeaMonster_stats = null;
            SeaViper_stats = null;
            Robot2_stats = null;
            Robot3_stats = null;
            Robot4_stats = null;
            Robot5_stats = null;
            Rotator_stats = null;
            Vortex_stats = null;
            DungeonBeast_stats = null;
            Triffid_stats = null;
            LurkingTerror_stats = null;
            WormSmall_stats = null;
            WormMedium_stats = null;
            WormLarge_stats = null;
            EnderKnight_stats = null;
            EnderReaper_stats = null;
            Irukandji_stats = null;
            AttackSquid_stats = null;
            CaveFisher_stats = null;
            CloudShark_stats = null;
            CreepingHorror_stats = null;
            Godzilla_stats = null;
            Kraken_stats = null;
            LeafMonster_stats = null;
            PitchBlack_stats = null;
            Crab_stats = null;
            Scorpion_stats = null;
            Skate_stats = null;
            TerribleTerror_stats = null;
            TheKing_stats = null;
            TheQueen_stats = null;
            Ruby_stats = null;
            BlkRuby_stats = null;
            Uranium_stats = null;
            Titanium_stats = null;
            Amethyst_stats = null;
            Salt_stats = null;
            SpawnOres_stats = null;
            Diamond_stats = null;
            BlkDiamond_stats = null;
            Emerald_stats = null;
            BlkEmerald_stats = null;
            Gold_stats = null;
            BlkGold_stats = null;
        }
    }
