package fr.iamacat.dangerzone_iamacatfr.worldgen.dungeon;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;

public class GenericDungeon {

    private final WeightedRandomChestContent[] RainbowContentsList;
    private final WeightedRandomChestContent[] WhiteHouseContentsList;
    private final WeightedRandomChestContent[] RubberDuckyContentsList;
    private final WeightedRandomChestContent[] StinkyHouseContentsList;
    private final WeightedRandomChestContent[] NightmareRookeryContentsList;
    private final WeightedRandomChestContent[] MonsterIslandContentsList;
    private final WeightedRandomChestContent[] GreenhouseContentsList;
    private final WeightedRandomChestContent[] CrystalBattleTowerRatContentsList;
    private final WeightedRandomChestContent[] CrystalBattleTowerDungeonBeastContentsList;
    private final WeightedRandomChestContent[] CrystalBattleTowerUrchinContentsList;
    private final WeightedRandomChestContent[] CrystalBattleTowerRotatorContentsList;
    private final WeightedRandomChestContent[] CrystalBattleTowerVortexContentsList;
    private final WeightedRandomChestContent[] RobotContentsList;
    private final WeightedRandomChestContent[] IncaPyramidContentsList;
    private final WeightedRandomChestContent[] DamselContentsList;
    private final WeightedRandomChestContent[] EnderCastleContentsList;
    private final WeightedRandomChestContent[] BouncyContentsList;
    private final WeightedRandomChestContent[] SpitBugContentsList;
    private final WeightedRandomChestContent[] GraveContentsList;
    private final WeightedRandomChestContent[] HospitalContentsList;
    private final WeightedRandomChestContent[] MiniContentsList;
    private final WeightedRandomChestContent[] LeafMonsterContentsList;
    private final WeightedRandomChestContent[] CloudSharkContentsList;
    private final WeightedRandomChestContent[] WaterDragonContentsList;
    private final WeightedRandomChestContent[] SquidContentsList;
    private final WeightedRandomChestContent[] KnightContentsList;
    private final WeightedRandomChestContent[] AlienWTFContentsList;
    private final WeightedRandomChestContent[] shadowContentsList;
    private final WeightedRandomChestContent[] kyuubiContentsList;
    private final WeightedRandomChestContent[] blazeContentsList;
    private final WeightedRandomChestContent[] beeContentsList;
    private final WeightedRandomChestContent[] mantisContentsList;
    private final WeightedRandomChestContent[] level1ContentsList;
    private final WeightedRandomChestContent[] level2ContentsList;
    private final WeightedRandomChestContent[] level3ContentsList;
    private final WeightedRandomChestContent[] level4ContentsList;
    private final WeightedRandomChestContent[] level5ContentsList;
    private final WeightedRandomChestContent[] chestContentsList;
    private int[] king;
    private int[] queen;
    private int[] blkcolors;

    public GenericDungeon() {
        this.RainbowContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MagicApple, 0, 1, 1, 25),
            new WeightedRandomChestContent(OreSpawnMain.CloudSharkEgg, 0, 4, 10, 25),
            new WeightedRandomChestContent(Items.bone, 0, 2, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 2, 16, 25),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 25),
            new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 25) };
        this.WhiteHouseContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 6, 12, 35),
            new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 2, 6, 10),
            new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 2, 6, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 6, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 6, 25),
            new WeightedRandomChestContent(OreSpawnMain.CriminalEgg, 0, 4, 10, 35),
            new WeightedRandomChestContent(Items.emerald, 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.porkchop, 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.cooked_porkchop, 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.diamond, 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.gold_ingot, 0, 6, 16, 35) };
        this.RubberDuckyContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyDeadStinkBug, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MySunFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MySparkFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyGreenFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyBlueFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyPinkFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyRockFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyWoodFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyGreyFish, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.RubberDuckyEgg, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyPeacockFeather, 0, 4, 10, 35),
            new WeightedRandomChestContent(Items.feather, 0, 6, 16, 35) };
        this.StinkyHouseContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyDeadStinkBug, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.StinkyEgg, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.StinkBugEgg, 0, 4, 10, 35),
            new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.coal, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 35) };
        this.NightmareRookeryContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyDeadStinkBug, 0, 4, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyFlowerBlackBlock), 0, 4, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyFlowerScaryBlock), 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 4, 10, 25),
            new WeightedRandomChestContent(OreSpawnMain.AntRobotKit, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.SpiderRobotKit, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 35) };
        this.MonsterIslandContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 0, 4, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.KrakenRepellent), 0, 4, 10, 35),
            new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.porkchop, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.beef, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.chicken, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.fish, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyRawBacon, 0, 6, 16, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyRawPeacock, 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 6, 16, 25) };
        this.GreenhouseContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.GreenGoo, 0, 4, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 0, 4, 10, 35),
            new WeightedRandomChestContent(Items.flower_pot, 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.leaves), 0, 6, 16, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dirt), 0, 6, 16, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 6, 16, 25) };
        this.CrystalBattleTowerRatContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.cooked_porkchop, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.beef, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.cooked_chicken, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.cooked_fished, 0, 3, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyBLT, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MySalad, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 4, 10, 35) };
        this.CrystalBattleTowerDungeonBeastContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 25),
            new WeightedRandomChestContent(Items.gold_nugget, 0, 5, 15, 15),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
        this.CrystalBattleTowerUrchinContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyFairySword, 0, 1, 1, 15) };
        this.CrystalBattleTowerRotatorContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyRatSword, 0, 1, 1, 15) };
        this.CrystalBattleTowerVortexContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 0, 6, 10, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CrystalCoal), 0, 6, 10, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyTigersEyeSword, 0, 1, 1, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyTigersEyeBlock), 0, 4, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15) };
        this.RobotContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.redstone, 0, 1, 10, 35),
            new WeightedRandomChestContent(Items.repeater, 0, 1, 10, 35),
            new WeightedRandomChestContent(Items.minecart, 0, 1, 1, 35),
            new WeightedRandomChestContent(Items.fire_charge, 0, 1, 10, 35),
            new WeightedRandomChestContent(Items.hopper_minecart, 0, 1, 1, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_block), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.detector_rail), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.sticky_piston), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.piston), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_torch), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.tnt), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.rail), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.lever), 0, 1, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.AntRobotKit, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.SpiderRobotKit, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.iron_door, 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_torch), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.wooden_button), 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.iron_bars), 0, 1, 10, 35),
            new WeightedRandomChestContent(Items.comparator, 0, 1, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.activator_rail), 0, 1, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyRayGun, 0, 1, 1, 35) };
        this.IncaPyramidContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.golden_sword, 0, 1, 1, 35),
            new WeightedRandomChestContent((Item) Items.golden_boots, 0, 1, 1, 35),
            new WeightedRandomChestContent((Item) Items.golden_leggings, 0, 1, 1, 35),
            new WeightedRandomChestContent((Item) Items.golden_helmet, 0, 1, 1, 35),
            new WeightedRandomChestContent((Item) Items.golden_chestplate, 0, 1, 1, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.yellow_flower), 0, 3, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.red_flower), 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.gold_nugget, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.gold_ingot, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.experience_bottle, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyCornCob, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 25),
            new WeightedRandomChestContent(Items.bone, 0, 4, 10, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.gold_block), 0, 4, 10, 35) };
        this.DamselContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.iron_pickaxe, 0, 1, 1, 35),
            new WeightedRandomChestContent(Items.iron_sword, 0, 1, 1, 35),
            new WeightedRandomChestContent(Items.cooked_porkchop, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.beef, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.cooked_chicken, 0, 3, 10, 35),
            new WeightedRandomChestContent(Items.cooked_fished, 0, 3, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyBLT, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MySalad, 0, 4, 10, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 4, 10, 35) };
        this.EnderCastleContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.ender_chest), 0, 2, 4, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.diamond_block), 0, 2, 4, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dragon_egg), 0, 1, 1, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyEnderPearlBlock), 0, 3, 6, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyEyeOfEnderBlock), 0, 3, 6, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 25),
            new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 4, 35),
            new WeightedRandomChestContent(Items.ender_eye, 0, 2, 4, 35) };
        this.BouncyContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 6, 16, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.red_flower), 0, 6, 16, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.yellow_flower), 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 4, 20) };
        this.SpitBugContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.InstantGarden, 0, 2, 4, 25),
            new WeightedRandomChestContent(OreSpawnMain.InstantShelter, 0, 2, 4, 25) };
        this.GraveContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.ender_eye, 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.red_flower), 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.yellow_flower), 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.ender_pearl, 0, 6, 16, 35) };
        this.HospitalContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.ender_chest), 0, 2, 4, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.diamond_block), 0, 2, 4, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dragon_egg), 0, 1, 1, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.MyEnderPearlBlock), 0, 3, 6, 35),
            new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 4, 35),
            new WeightedRandomChestContent(Items.ender_eye, 0, 2, 4, 35) };
        this.MiniContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.golden_apple, 0, 6, 16, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyCrystalApple, 0, 6, 16, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 16, 35),
            new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 6, 16, 35),
            new WeightedRandomChestContent(OreSpawnMain.InstantGarden, 0, 2, 4, 25),
            new WeightedRandomChestContent(OreSpawnMain.InstantShelter, 0, 2, 4, 25) };
        this.LeafMonsterContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.flower_pot, 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 6, 16, 35),
            new WeightedRandomChestContent(Items.flower_pot, 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.sapling), 0, 6, 16, 35),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.leaves), 0, 6, 16, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.dirt), 0, 6, 16, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.log), 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
        this.CloudSharkContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.bone, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.string, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.paper, 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceTreeSeed, 0, 1, 2, 15),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
        this.WaterDragonContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.fish, 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimatePickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 25),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.iron_block), 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
        this.SquidContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.gold_nugget, 0, 5, 15, 15),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
        this.KnightContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.paper, 0, 2, 8, 20),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.planks), 0, 4, 8, 20),
            new WeightedRandomChestContent(Items.ender_eye, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.ender_pearl, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25) };
        this.AlienWTFContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.diamond_block), 0, 1, 2, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 1, 1, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 1, 1, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyIngotUranium, 0, 1, 2, 5),
            new WeightedRandomChestContent(OreSpawnMain.MyIngotTitanium, 0, 1, 2, 5),
            new WeightedRandomChestContent((Item) OreSpawnMain.UltimateHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.UltimateBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.UltimateLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.UltimateBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRayGun, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 1, 10, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyCornDog, 0, 1, 10, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 1, 5, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyPopcornBag, 0, 2, 8, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyFireFish, 0, 2, 8, 15) };
        this.shadowContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.glowstone_dust, 0, 2, 8, 20),
            new WeightedRandomChestContent(Items.nether_wart, 0, 4, 8, 20),
            new WeightedRandomChestContent(Items.blaze_rod, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.blaze_powder, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.fire_charge, 0, 4, 8, 15),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.dye, 0, 6, 16, 25),
            new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceTreeSeed, 0, 2, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyElevator, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRatSword, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyRubySword, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyBigHammer, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyIngotTitanium, 0, 1, 1, 5),
            new WeightedRandomChestContent(OreSpawnMain.MyIngotUranium, 0, 1, 1, 5),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateSword, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyUltimateBow, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.EnderReaperEgg, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 2, 8, 15) };
        this.kyuubiContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.redstone, 0, 2, 8, 10),
            new WeightedRandomChestContent(Item.getItemFromBlock(Blocks.redstone_block), 0, 4, 8, 15),
            new WeightedRandomChestContent(Items.quartz, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.coal, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 20),
            new WeightedRandomChestContent(OreSpawnMain.KyuubiEgg, 0, 2, 8, 15) };
        this.blazeContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.blaze_rod, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.blaze_powder, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.fire_charge, 0, 4, 8, 15),
            new WeightedRandomChestContent(Items.flint_and_steel, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(Items.spawn_egg, 61, 2, 8, 15) };
        this.beeContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.sugar, 0, 2, 8, 15),
            new WeightedRandomChestContent(Item.getItemFromBlock((Block) Blocks.yellow_flower), 0, 4, 8, 15),
            new WeightedRandomChestContent(Items.gold_nugget, 0, 5, 15, 15),
            new WeightedRandomChestContent(Items.paper, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyFairySword, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 10),
            new WeightedRandomChestContent(OreSpawnMain.BeeEgg, 0, 2, 8, 15) };
        this.mantisContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyMantisClaw, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.gold_nugget, 0, 4, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.UraniumNugget, 0, 1, 3, 5),
            new WeightedRandomChestContent(OreSpawnMain.TitaniumNugget, 0, 1, 3, 5),
            new WeightedRandomChestContent(OreSpawnMain.MantisEgg, 0, 2, 4, 20),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.rotten_flesh, 0, 6, 16, 25),
            new WeightedRandomChestContent(Items.diamond, 0, 1, 3, 15) };
        this.level1ContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.emerald, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MinersDream, 0, 4, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldSword, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldBoots, 0, 1, 1, 15) };
        this.level2ContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(Items.experience_bottle, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.experience_bottle, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.CreeperLauncher, 0, 2, 10, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.CrystalPinkBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyFairySword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldSword, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceBoots, 0, 1, 1, 15) };
        this.level3ContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MySquidZooka, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRatSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethyst, 0, 2, 8, 15),
            new WeightedRandomChestContent(Items.dye, 0, 2, 8, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeHelmet, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeBody, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeLegs, 0, 1, 1, 10),
            new WeightedRandomChestContent((Item) OreSpawnMain.TigersEyeBoots, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyAmethystSword, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.AmethystBoots, 0, 1, 1, 15) };
        this.level4ContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyRuby, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MagicApple, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRayGun, 0, 1, 1, 15),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.CreeperRepellent), 0, 4, 10, 15),
            new WeightedRandomChestContent(Item.getItemFromBlock(OreSpawnMain.KrakenRepellent), 0, 4, 10, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceCatcher, 0, 4, 10, 15),
            new WeightedRandomChestContent(OreSpawnMain.ZooKeeper, 0, 10, 16, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubyAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyRubySword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyThunderStaff, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.RubyBoots, 0, 1, 1, 15) };
        this.level5ContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyNightmareSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyPoisonSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.WitherSkeletonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EnderDragonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SnowGolemEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.IronGolemEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.WitherBossEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.RedCowEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GoldCowEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EnchantedCowEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MOTHRAEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AloEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CryoEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CamaEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.VeloEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.HydroEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BasilEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.DragonflyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EmperorScorpionEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.ScorpionEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CaveFisherEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SpyroEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BaryonyxEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CockateilEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GammaMetroidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.KyuubiEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AlienEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AttackSquidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.WaterDragonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CephadromeEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.KrakenEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LizardEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.DragonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BeeEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TrooperBugEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SpitBugEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.StinkBugEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.OstrichEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GazelleEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.ChipmunkEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CreepingHorrorEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TerribleTerrorEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CliffRacerEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TriffidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LurkingTerrorEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SmallWormEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MediumWormEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LargeWormEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TRexEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GodzillaEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MantisEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.HerculesEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.VortexEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.RatEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.DungeonBeastEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.FairyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.WhaleEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SkateEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.IrukandjiEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.Robot1Egg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.Robot2Egg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.Robot3Egg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.Robot4Egg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.Robot5Egg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CriminalEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CoinEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BoyfriendEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EasterBunnyEgg, 0, 1, 4, 5),
            new WeightedRandomChestContent(OreSpawnMain.MolenoidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SeaMonsterEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SeaViperEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CaterKillerEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LeonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.HammerheadEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.RubberDuckyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.NastysaurusEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.PointysaurusEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BrutalflyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CricketEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.FrogEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AntRobotKit, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.SpiderRobotKit, 0, 1, 1, 10),
            new WeightedRandomChestContent(OreSpawnMain.JefferyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SpiderDriverEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CrabEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CassowaryEgg, 0, 1, 4, 15) };
        this.chestContentsList = new WeightedRandomChestContent[] {
            new WeightedRandomChestContent(OreSpawnMain.MyBacon, 0, 6, 12, 20),
            new WeightedRandomChestContent(OreSpawnMain.MyButterCandy, 0, 6, 12, 20),
            new WeightedRandomChestContent(Items.emerald, 0, 2, 8, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldPickaxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldShovel, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldHoe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldAxe, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyEmeraldSword, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.EmeraldBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyMothScale, 0, 2, 8, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.MothScaleBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.MothScaleLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.MothScaleHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.MothScaleBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyLavaEel, 0, 2, 8, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.LavaEelBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceBody, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceLegs, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceHelmet, 0, 1, 1, 15),
            new WeightedRandomChestContent((Item) OreSpawnMain.ExperienceBoots, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.MyExperienceSword, 0, 1, 1, 15),
            new WeightedRandomChestContent(OreSpawnMain.WitherSkeletonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EnderDragonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SnowGolemEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.IronGolemEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.WitherBossEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.RedCowEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GoldCowEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EnchantedCowEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MOTHRAEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AloEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CryoEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CamaEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.VeloEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.HydroEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BasilEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.DragonflyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.EmperorScorpionEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.ScorpionEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CaveFisherEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SpyroEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BaryonyxEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CockateilEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GammaMetroidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.KyuubiEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AlienEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.AttackSquidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.WaterDragonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CephadromeEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.KrakenEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LizardEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.DragonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BeeEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TrooperBugEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SpitBugEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.StinkBugEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.OstrichEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.GazelleEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.ChipmunkEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CreepingHorrorEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TerribleTerrorEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CliffRacerEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.TriffidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.PitchBlackEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LurkingTerrorEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SmallWormEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MediumWormEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LargeWormEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CassowaryEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.MolenoidEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SeaMonsterEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SeaViperEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CaterKillerEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.LeonEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.HammerheadEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.RubberDuckyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.NastysaurusEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.PointysaurusEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.BrutalflyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CricketEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.FrogEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.JefferyEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.SpiderDriverEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CrabEgg, 0, 1, 4, 15),
            new WeightedRandomChestContent(OreSpawnMain.CageEmpty, 0, 3, 10, 20) };
        this.king = new int[] { -1, -1, 24, 3, -1, 24, 5, -1, 17, 12, -1, 16, 15, -1, 15, 14, -1, 15, 6, 3, 5, -1, 14,
            6, 4, 3, -1, 14, 5, -1, 14, 5, -1, 12, 9, -1, 11, 11, -1, 8, 17, -1, 5, 23, -1, 3, 27, -1, 2, 29, -1, 1, 31,
            -1, 0, 33, -1, 13, 6, -1, 12, 9, -1, 11, 3, 1, 2, 1, 4, -1, 10, 3, 2, 2, 3, 2, -1, 10, 2, 4, 2, 3, 2, -1, 9,
            2, 5, 2, 4, 6, -1, 9, 2, 5, 2, 6, 4, -1, 8, 2, 6, 1, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 15,
            2, -1, -1, -1 };
        this.queen = new int[] { -1, -1, 24, 3, -1, 24, 5, -1, 17, 12, -1, 16, 15, -1, 15, 14, -1, 15, 6, 3, 5, -1, 14,
            6, 4, 3, -1, 14, 5, -1, 14, 5, -1, 12, 9, -1, 11, 11, -1, 8, 17, -1, 5, 23, -1, 3, 27, -1, 2, 29, -1, 1, 31,
            -1, 0, 33, -1, 13, 6, -1, 12, 9, -1, 11, 3, 1, 2, 1, 4, -1, 10, 3, 2, 2, 3, 2, -1, 10, 2, 4, 2, 3, 2, -1, 9,
            2, 5, 2, 4, 6, -1, 9, 2, 5, 2, 6, 4, -1, 8, 2, 6, 1, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 8, 2, 5, 2, -1, 15,
            2, -1, -1, -1 };
        this.blkcolors = new int[] { 14, 1, 4, 5, 3, 11, 10, 6 };
    }

    private void setThisBlock(final World world, final int cposx, final int cposy, final int cposz) {
        if (world.rand.nextInt(2) == 1) {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.mossy_cobblestone);
        } else {
            this.FastSetBlock(world, cposx, cposy, cposz, Blocks.cobblestone);
        }
    }

    private TileEntityChest getChestTileEntity(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityChest chest = null;
        TileEntity t = null;
        t = world.getTileEntity(cposx, cposy, cposz);
        if (t != null && t instanceof TileEntityChest) {
            chest = (TileEntityChest) t;
            return chest;
        }
        return null;
    }

    private TileEntityMobSpawner getSpawnerTileEntity(final World world, final int cposx, final int cposy,
        final int cposz) {
        TileEntityMobSpawner chest = null;
        TileEntity t = null;
        t = world.getTileEntity(cposx, cposy, cposz);
        if (t != null && t instanceof TileEntityMobSpawner) {
            chest = (TileEntityMobSpawner) t;
            return chest;
        }
        return null;
    }

    public void makeDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 12;
        final int height = 6;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.mossy_cobblestone);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height - 1;
            for (int k = 0; k < width; ++k) {
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int k = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                k = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 0; j < height; ++j) {
                int i = 0;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
                i = width - 1;
                this.setThisBlock(world, cposx + i, cposy + j, cposz + k);
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        final TileEntityMobSpawner tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2, cposy + 1, cposz + width / 2);
        if (tileentitymobspawner != null) {
            final int t = world.rand.nextInt(12);
            if (t == 0) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Scorpion");
            }
            if (t == 1) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Alien");
            }
            if (t == 2) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Cryolophosaurus");
            }
            if (t == 3) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("WTF?");
            }
            if (t == 4) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Kyuubi");
            }
            if (t == 5) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Bee");
            }
            if (t == 6) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Cloud Shark");
            }
            if (t == 7) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Lurking Terror");
            }
            if (t == 8) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Terrible Terror");
            }
            if (t == 9) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Rotator");
            }
            if (t == 10) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Rat");
            }
            if (t == 11) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Dungeon Beast");
            }
        }
        TileEntityChest chest = null;
        world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent.generateChestContents(
                world.rand,
                this.chestContentsList,
                (IInventory) chest,
                5 + world.rand.nextInt(7));
        }
    }

    public void FastSetBlock(final World world, final int ix, final int iy, final int iz, final Block id) {
        OreSpawnMain.setBlockFast(world, ix, iy, iz, id, 0, 2);
    }

    public void makeEnormousCastle(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 28;
        final int height = 16;
        final int platformwidth = 11;
        int level = 0;
        if (world.isRemote) {
            return;
        }
        level = 1 + world.rand.nextInt(6);
        if (level <= 3 && world.rand.nextInt(3) != 1) {
            level += 3;
        }
        for (int i = -20; i < width + 4; ++i) {
            for (int j = 1; j < height + 10; ++j) {
                for (int k = -4; k < width + 4; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 1; j < height; ++j) {
                int k = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
                k = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 1; j < height; ++j) {
                int i = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
                i = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
            }
        }
        world.setBlock(cposx + 1, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
        world.setBlock(cposx + 1, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
        world.setBlock(cposx + width - 2, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
        world.setBlock(cposx + width - 2, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
        for (int i = -4; i < width + 4; ++i) {
            for (int k = -4; k < width + 4; ++k) {
                if (i < 0 || k < 0 || i >= width || k >= width) {
                    this.FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.stone);
                }
                if (i == -4 || k == -4 || i == width + 3 || k == width + 3) {
                    this.FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence);
                }
            }
        }
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j < 4; ++j) {
            world.setBlock(cposx - 3, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz - 3);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Terrible Terror");
            }
            world.setBlock(cposx - 3, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz + width + 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Terrible Terror");
            }
            world.setBlock(cposx + width + 2, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz - 3);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Terrible Terror");
            }
            world.setBlock(cposx + width + 2, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz + width + 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Terrible Terror");
            }
        }
        world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Emperor Scorpion");
        }
        world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Emperor Scorpion");
        }
        world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Emperor Scorpion");
        }
        int j = height;
        this.buildLevel(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Cloud Shark", 1, -1, 5, 1, level);
        j += 10;
        if (level >= 2) {
            this.buildLevel(
                world,
                cposx + 1,
                cposy + j,
                cposz + 1,
                width - 2,
                10,
                4,
                "Lurking Terror",
                0,
                0,
                4,
                2,
                level);
        }
        j += 10;
        if (level >= 3) {
            this.buildLevel(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 4, "Rotator", 1, 1, 4, 3, level);
        }
        j += 9;
        if (level >= 4) {
            this.buildLevel(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 3, "Bee", 0, 0, 4, 4, level);
        }
        j += 9;
        if (level >= 5) {
            this.buildLevel(world, cposx + 3, cposy + j, cposz + 3, width - 6, 8, 3, "Mantis", 1, 1, 4, 5, level);
        }
        j += 8;
        if (level >= 6) {
            this.buildLevel(world, cposx + 3, cposy + j, cposz + 3, width - 6, 16, 3, "Mothra", 0, 0, 3, 6, level);
        }
        j += 16;
        for (int i = 0; i < platformwidth; ++i) {
            j = height;
            for (int k = -(platformwidth / 2); k <= platformwidth / 2; ++k) {
                this.FastSetBlock(world, cposx + i - 20, cposy + j, cposz + k + width / 2, Blocks.quartz_block);
                if ((i == 0 || i == platformwidth - 1 || k == -(platformwidth / 2) || k == platformwidth / 2)
                    && (i != 0 || k < -1 || k > 1)) {
                    this.FastSetBlock(
                        world,
                        cposx + i - 20,
                        cposy + j + 1,
                        cposz + k + width / 2,
                        Blocks.nether_brick_fence);
                }
            }
        }
        for (int i = -10; i <= -3; ++i) {
            j = height;
            for (int k = -2; k < 3; ++k) {
                if (i == -3 || i == -10) {
                    if (k != -2 && k != 2) {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block) Blocks.fire);
                    }
                } else {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + width / 2, Blocks.quartz_block);
                    if (k == -2 || k == 2) {
                        this.FastSetBlock(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k + width / 2,
                            Blocks.nether_brick_fence);
                    }
                }
            }
        }
        int i = -21;
        for (j = height; j >= 0; --j) {
            for (int k = -2; k < 3; ++k) {
                for (int t = 0; t < 6; ++t) {
                    this.FastSetBlock(world, cposx + i, cposy + j + t + 1, cposz + k + width / 2, Blocks.air);
                }
                if (j == 0) {
                    if (k != -2 && k != 2) {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block) Blocks.fire);
                    }
                } else {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + width / 2, Blocks.quartz_block);
                    if (k == -2 || k == 2) {
                        this.FastSetBlock(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k + width / 2,
                            Blocks.nether_brick_fence);
                    }
                }
            }
            --i;
        }
        if (level >= 6) {
            final int span = width * 3;
            for (int tries = 0; tries < 100; ++tries) {
                j = -1;
                i = world.rand.nextInt(span);
                int k = world.rand.nextInt(span);
                if (i < span / 4 || i > span * 3 / 4 || k < span / 4 || k > span * 3 / 4) {
                    i -= span / 2;
                    k -= span / 2;
                    world.setBlock(cposx + i + width / 2, cposy + j, cposz + k + width / 2, Blocks.mob_spawner, 0, 2);
                    tileentitymobspawner = this
                        .getSpawnerTileEntity(world, cposx + i + width / 2, cposy + j, cposz + k + width / 2);
                    if (tileentitymobspawner != null) {
                        tileentitymobspawner.func_145881_a()
                            .setEntityName("Large Worm");
                    }
                }
            }
        }
    }

    public void buildLevel(final World world, final int cposx, final int cposy, final int cposz, final int width,
        final int height, final int pw, final String critter, final int stepside, final int stepoff, final int holelen,
        final int decor, final int level) {
        for (int i = -pw; i < width + pw; ++i) {
            for (int j = 1; j < height; ++j) {
                for (int k = -pw; k < width + pw; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 1; j < height; ++j) {
                int k = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
                k = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 1; j < height; ++j) {
                Block blk = Blocks.bedrock;
                if (k == 0 || k == width - 1) {
                    blk = Blocks.gold_block;
                }
                int i = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                i = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = -pw; i < width + pw; ++i) {
            for (int k = -pw; k < width + pw; ++k) {
                if (i < 0 || k < 0 || i >= width || k >= width) {
                    this.FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.stone);
                }
                if (i == -pw || k == -pw || i == width + (pw - 1) || k == width + (pw - 1)) {
                    this.FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence);
                }
            }
        }
        int i = -(height / 2);
        i += width / 2;
        for (int j = 1; j < height; ++j) {
            if (stepside != 0) {
                final int k = -1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
            } else {
                final int k = width;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
            }
            ++i;
        }
        if (stepoff >= 0) {
            int k;
            if (stepside == 0) {
                k = -1;
                k -= stepoff;
            } else {
                k = width;
                k += stepoff;
            }
            i = width / 2;
            final int j = 0;
            for (int l = 0; l < holelen; ++l) {
                this.FastSetBlock(world, cposx + i + l, cposy + j, cposz + k, Blocks.air);
            }
        }
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j < 4; ++j) {
            world.setBlock(cposx - (pw - 1), cposy + j + 1, cposz - (pw - 1), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - (pw - 1), cposy + j + 1, cposz - (pw - 1));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx - (pw - 1), cposy + j + 1, cposz + width + (pw - 2), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx - (pw - 1), cposy + j + 1, cposz + width + (pw - 2));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width + (pw - 2), cposy + j + 1, cposz - (pw - 1), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width + (pw - 2), cposy + j + 1, cposz - (pw - 1));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width + (pw - 2), cposy + j + 1, cposz + width + (pw - 2), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width + (pw - 2), cposy + j + 1, cposz + width + (pw - 2));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
        }
        this.addLevelDecorations(world, cposx, cposy, cposz, width, height, decor, level);
    }

    public void addLevelDecorations(final World world, final int cposx, final int cposy, final int cposz,
        final int width, final int height, final int decor, final int difficulty) {
        TileEntityMobSpawner tileentitymobspawner = null;
        int reward = 1;
        String critter = "Alosaurus";
        if (decor == 6) {
            this.FastSetBlock(world, cposx, cposy + height, cposz, Blocks.netherrack);
            this.FastSetBlock(world, cposx, cposy + height + 1, cposz, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx, cposy + height, cposz + width - 1, Blocks.netherrack);
            this.FastSetBlock(world, cposx, cposy + height + 1, cposz + width - 1, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx + width - 1, cposy + height, cposz, Blocks.netherrack);
            this.FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx + width - 1, cposy + height, cposz + width - 1, Blocks.netherrack);
            this.FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz + width - 1, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx + width / 2, cposy + height, cposz + width / 2, Blocks.air);
            world.setBlock(cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            world.setBlock(cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            for (int i = 1; i < width - 1; ++i) {
                for (int j = 1; j < 5; ++j) {
                    for (int k = 1; k < width - 1; ++k) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.dirt);
                    }
                }
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Large Worm");
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Large Worm");
            }
            world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Large Worm");
            }
            for (int j = 0; j < 10; ++j) {
                this.FastSetBlock(world, cposx + 1, cposy + j, cposz + 1, Blocks.air);
            }
            this.fill_chests(world, cposx, cposy + 4, cposz, width, height, decor, reward);
        }
        if (decor == 5) {
            if (difficulty == 5) {
                critter = "Alosaurus";
                reward = 1;
            }
            if (difficulty == 6) {
                critter = "T. Rex";
                reward = 2;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
            this.FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 4) {
            if (difficulty == 4) {
                critter = "Alosaurus";
                reward = 1;
            }
            if (difficulty == 5) {
                critter = "T. Rex";
                reward = 2;
            }
            if (difficulty == 6) {
                critter = "Basilisk";
                reward = 3;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
            this.FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 3) {
            if (difficulty == 3) {
                critter = "Alosaurus";
                reward = 1;
            }
            if (difficulty == 4) {
                critter = "T. Rex";
                reward = 2;
            }
            if (difficulty == 5) {
                critter = "Basilisk";
                reward = 3;
            }
            if (difficulty == 6) {
                critter = "Hercules Beetle";
                reward = 4;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
            this.FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 2) {
            if (difficulty == 2) {
                critter = "Alosaurus";
                reward = 1;
            }
            if (difficulty == 3) {
                critter = "T. Rex";
                reward = 2;
            }
            if (difficulty == 4) {
                critter = "Basilisk";
                reward = 3;
            }
            if (difficulty == 5) {
                critter = "Hercules Beetle";
                reward = 4;
            }
            if (difficulty == 6) {
                critter = "Jumpy Bug";
                reward = 5;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
            this.FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 1) {
            if (difficulty == 1) {
                critter = "Alosaurus";
            }
            if (difficulty == 2) {
                critter = "T. Rex";
            }
            if (difficulty == 3) {
                critter = "Basilisk";
            }
            if (difficulty == 4) {
                critter = "Hercules Beetle";
            }
            if (difficulty == 5) {
                critter = "Jumpy Bug";
            }
            if (difficulty == 6) {
                critter = "Hammerhead";
            }
            reward = difficulty;
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
    }

    private void fill_chests(final World world, final int cposx, final int cposy, final int cposz, final int width,
        final int height, final int decor, final int reward) {
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.level1ContentsList;
        if (reward == 2) {
            chestContents = this.level2ContentsList;
        }
        if (reward == 3) {
            chestContents = this.level3ContentsList;
        }
        if (reward == 4) {
            chestContents = this.level4ContentsList;
        }
        if (reward == 5) {
            chestContents = this.level5ContentsList;
        }
        world.setBlock(cposx + 1, cposy + 1, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + 1, cposy + 1, cposz + width / 2, 5, 3);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + 1, cposz + width / 2);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.ThePrinceEgg, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
        world.setBlock(cposx + width - 2, cposy + 1, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width - 2, cposy + 1, cposz + width / 2, 4, 3);
        chest = this.getChestTileEntity(world, cposx + width - 2, cposy + 1, cposz + width / 2);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack((Item) OreSpawnMain.RoyalHelmet, 1, 0));
                chest.setInventorySlotContents(2, new ItemStack((Item) OreSpawnMain.RoyalBody, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + 1, 3, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack((Item) OreSpawnMain.RoyalLegs, 1, 0));
                chest.setInventorySlotContents(2, new ItemStack((Item) OreSpawnMain.RoyalBoots, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + width - 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + width - 2, 2, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + width - 2);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.MyRoyal, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
    }

    public void makeRotatorStation(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        world.setBlock(cposx, cposy + 4, cposz, OreSpawnMain.CrystalStone, 0, 2);
        world.setBlock(cposx, cposy + 5, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 5, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 6, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx, cposy + 7, cposz, OreSpawnMain.CrystalStone, 0, 2);
        world.setBlock(cposx, cposy + 8, cposz, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx, cposy + 8, cposz, 2, 3);
        chest = this.getChestTileEntity(world, cposx, cposy + 8, cposz);
        if (chest != null) {
            chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.RotatorEgg, 1 + world.rand.nextInt(5), 0));
            chest.setInventorySlotContents(2, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
            chest.setInventorySlotContents(3, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
        }
    }

    public void makeBeeHive(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 10;
        final int height = 30;
        if (world.isRemote) {
            return;
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < 5; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy - j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy - j, cposz + k, Blocks.coal_ore);
            }
        }
        Block blk = Blocks.coal_ore;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = 1; j < height; ++j) {
                    if (k == 0 || i == 0 || k == width - 1 || i == width - 1) {
                        blk = Blocks.coal_ore;
                        if ((j & 0x1) == 0x1) {
                            blk = Blocks.gold_ore;
                        }
                        this.FastSetBlock(world, cposx + i, cposy - j, cposz + k, blk);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy - j, cposz + k, Blocks.air);
                    }
                }
            }
        }
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j < 4; ++j) {
            world
                .setBlock(cposx + width / 2, cposy - 2 - j * (height / 4), cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2, cposy - 2 - j * (height / 4), cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Bee");
            }
        }
        this.fill_beehive_chests(world, cposx, cposy, cposz, width, height);
    }

    private void fill_beehive_chests(final World world, final int cposx, final int cposy, final int cposz,
        final int width, final int height) {
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.beeContentsList;
        for (int j = 2; j < height - 1; j += 2) {
            world.setBlock(cposx + 1, cposy - j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
            world.setBlockMetadataWithNotify(cposx + 1, cposy - j, cposz + width / 2, 5, 3);
            chest = this.getChestTileEntity(world, cposx + 1, cposy - j, cposz + width / 2);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 1 + world.rand.nextInt(5));
            }
            world.setBlock(cposx + width - 2, cposy - j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
            world.setBlockMetadataWithNotify(cposx + width - 2, cposy - j, cposz + width / 2, 4, 3);
            chest = this.getChestTileEntity(world, cposx + width - 2, cposy - j, cposz + width / 2);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 1 + world.rand.nextInt(5));
            }
            world.setBlock(cposx + width / 2, cposy - j, cposz + 1, (Block) Blocks.chest, 0, 2);
            world.setBlockMetadataWithNotify(cposx + width / 2, cposy - j, cposz + 1, 3, 3);
            chest = this.getChestTileEntity(world, cposx + width / 2, cposy - j, cposz + 1);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 1 + world.rand.nextInt(5));
            }
            world.setBlock(cposx + width / 2, cposy - j, cposz + width - 2, (Block) Blocks.chest, 0, 2);
            world.setBlockMetadataWithNotify(cposx + width / 2, cposy - j, cposz + width - 2, 2, 3);
            chest = this.getChestTileEntity(world, cposx + width / 2, cposy - j, cposz + width - 2);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 1 + world.rand.nextInt(5));
            }
        }
    }

    public void makeHauntedHouse(final World world, final int cposx, final int cposy, final int cposz) {
        int deltax = 0;
        final int deltaz = 0;
        final int bid = 0;
        final int dirx = 0;
        final int dirz = 0;
        int stuffdir = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        final int width;
        final int length = width = 3;
        final int height = 3;
        deltax = 1;
        stuffdir = 2;
        final int x = cposx;
        final int z = cposz;
        final int y = cposy;
        if (world.isRemote) {
            return;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k <= height + 1; ++k) {
                    if (k == height + 1) {
                        world.setBlock(x + i, y + k, z + j, Blocks.planks);
                    } else if (k == 0) {
                        world.setBlock(x + i, y + k, z + j, Blocks.cobblestone);
                    } else if (i == width || j == length || i == -width || j == -length) {
                        if (k == height) {
                            world.setBlock(x + i, y + k, z + j, Blocks.glass);
                        } else if ((k == 1 || k == 2) && i == deltax * width && j == deltaz * length) {
                            world.setBlock(x + i, y + k, z + j, Blocks.air);
                        } else {
                            world.setBlock(x + i, y + k, z + j, Blocks.planks);
                        }
                    } else {
                        world.setBlock(x + i, y + k, z + j, Blocks.air);
                    }
                }
            }
        }
        int i = 2;
        int k = 1;
        int j = length - 1;
        world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.furnace);
        world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
        i = 1;
        world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, Blocks.crafting_table);
        i = 0;
        world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block) Blocks.chest);
        world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
        final TileEntityChest chest = this
            .getChestTileEntity(world, x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
        if (chest != null) {
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(0, new ItemStack(Items.compass));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(1, new ItemStack((Item) Items.map));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(2, new ItemStack(Items.cooked_porkchop, 8));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(3, new ItemStack(Item.getItemFromBlock(Blocks.torch), 32));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(5, new ItemStack(Items.bed));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(6, new ItemStack(Items.bed));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(8, new ItemStack(Items.iron_pickaxe));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(9, new ItemStack(Items.iron_sword));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(10, new ItemStack(Items.iron_axe));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(11, new ItemStack(Items.bucket));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(12, new ItemStack(OreSpawnMain.MyOreSaltBlock, 4));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(13, new ItemStack((Block) Blocks.chest));
            }
        }
        world.setBlock(cposx, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost");
        }
        world.setBlock(cposx, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost Pumpkin Skelly");
        }
    }

    public void makeMantisHive(final World world, final int cposx, final int cposy, final int cposz) {
        int width = 13;
        TileEntityMobSpawner tileentitymobspawner = null;
        if (world.isRemote) {
            return;
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < 20; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        int yoff;
        int xoff;
        int zoff = xoff = (yoff = 0);
        while (width > 0) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < width; ++k) {
                    if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                        Block blk = Blocks.gold_ore;
                        if ((yoff & 0x1) != 0x0) {
                            blk = Blocks.emerald_ore;
                        }
                        this.FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, blk);
                    } else {
                        this.FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, Blocks.air);
                    }
                }
            }
            if (width <= 11 && width >= 7) {
                this.fill_mantishive_chests(world, cposx + xoff, cposy - yoff, cposz + zoff, width, 0);
            }
            ++xoff;
            ++zoff;
            ++yoff;
            width -= 2;
        }
        --xoff;
        --zoff;
        --yoff;
        for (int j = 4; j < 7; ++j) {
            world.setBlock(cposx + xoff, cposy + j - yoff, cposz + yoff, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + xoff, cposy + j - yoff, cposz + yoff);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Mantis");
            }
        }
    }

    private void fill_mantishive_chests(final World world, final int cposx, final int cposy, final int cposz,
        final int width, final int height) {
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.mantisContentsList;
        final int j = height;
        world.setBlock(cposx + 1, cposy + j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + 1, cposy + j, cposz + width / 2, 5, 3);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + j, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
        world.setBlock(cposx + width - 2, cposy + j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width - 2, cposy + j, cposz + width / 2, 4, 3);
        chest = this.getChestTileEntity(world, cposx + width - 2, cposy + j, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
        world.setBlock(cposx + width / 2, cposy + j, cposz + 1, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + 1, 3, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
        world.setBlock(cposx + width / 2, cposy + j, cposz + width - 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + width - 2, 2, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width - 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
    }

    public void makeKyuubiDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 5;
        final int height = 5;
        final int depth = 20;
        final int length = 12;
        final int rwidth = 30;
        final int rheight = 18;
        final int rlength = 20;
        if (world.isRemote) {
            return;
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < 5; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy - j, cposz + k, Blocks.air);
                }
            }
        }
        int j = height;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sandstone);
            }
        }
        this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2, Blocks.air);
        Block blk = Blocks.sandstone;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (j = 0; j < height; ++j) {
                    if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                    }
                }
            }
        }
        blk = Blocks.stone;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (j = -1; j > -depth; --j) {
                    if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                    }
                }
            }
        }
        for (int i = 1; i < width - 1; ++i) {
            for (int k = 1; k < width - 1; ++k) {
                for (j = -depth; j > -(depth + 2); --j) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.water);
                }
            }
        }
        for (int i = 1; i < width - 1; ++i) {
            for (int k = 1; k < width - 1; ++k) {
                j = -(depth + 2);
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
            }
        }
        int x = cposx + width + length - 2;
        int z = cposz - rwidth / 2;
        int y = cposy - depth;
        blk = Blocks.netherrack;
        for (int i = 0; i < rlength; ++i) {
            for (int k = 0; k < rwidth; ++k) {
                for (j = 0; j < rheight; ++j) {
                    if (k == 0 || k == rwidth - 1 || j == 0 || j == rheight - 1 || i == 0 || i == rlength - 1) {
                        this.FastSetBlock(world, x + i, y + j, z + k, blk);
                    } else {
                        this.FastSetBlock(world, x + i, y + j, z + k, Blocks.air);
                    }
                }
            }
        }
        x = cposx + width - 1;
        z = cposz;
        y = cposy - depth;
        for (int i = 0; i < length; ++i) {
            for (int k = 0; k < width; ++k) {
                for (j = 0; j < width; ++j) {
                    if (k == 0 || k == width - 1 || j == 0 || j == width - 1) {
                        blk = Blocks.stone;
                        if (j > 0 && j < width - 1) {
                            blk = Blocks.lava;
                        }
                        this.FastSetBlock(world, x + i, y + j, z + k, blk);
                    } else {
                        this.FastSetBlock(world, x + i, y + j, z + k, Blocks.air);
                    }
                }
            }
        }
        x = cposx + width + length - 2;
        z = cposz - rwidth / 2;
        y = cposy - depth;
        ++y;
        this.addlavasquare(world, x + 2, y, z + 2);
        this.addlavasquare(world, x + 4, y, z + 6);
        this.addlavasquare(world, x + 12, y, z + 10);
        this.addlavasquare(world, x + 6, y, z + 15);
        this.addlavasquare(world, x + 3, y, z + 22);
        this.addkyuubi(world, x + rlength / 4, y, z + rwidth * 3 / 4 - 3);
        this.addblaze(world, x + rlength * 2 / 3 - 3, y, z + rwidth / 4 - 2);
        this.FastSetBlock(world, x + 7, y, z + 1, (Block) Blocks.fire);
        this.FastSetBlock(world, x + 5, y, z + 9, (Block) Blocks.fire);
        this.FastSetBlock(world, x + 2, y, z + 12, (Block) Blocks.fire);
        this.FastSetBlock(world, x + 16, y, z + 18, (Block) Blocks.fire);
        this.FastSetBlock(world, x + 2, y, z + 27, (Block) Blocks.fire);
        this.FastSetBlock(world, x + 18, y, z + 28, (Block) Blocks.fire);
    }

    private void addlavasquare(final World world, final int x, final int y, final int z) {
        this.FastSetBlock(world, x - 1, y, z, Blocks.netherrack);
        this.FastSetBlock(world, x + 1, y, z, Blocks.netherrack);
        this.FastSetBlock(world, x, y, z + 1, Blocks.netherrack);
        this.FastSetBlock(world, x, y, z - 1, Blocks.netherrack);
        this.FastSetBlock(world, x, y, z, Blocks.lava);
    }

    private void addkyuubi(final World world, final int x, final int y, final int z) {
        int width = 9;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        TileEntityMobSpawner tileentitymobspawner = null;
        chestContents = this.kyuubiContentsList;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                    this.FastSetBlock(world, x + i, y, z + k, Blocks.nether_brick);
                } else {
                    this.FastSetBlock(world, x + i, y, z + k, Blocks.lava);
                }
            }
        }
        width = 7;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                    this.FastSetBlock(world, x + i + 1, y + 1, z + k + 1, Blocks.nether_brick);
                } else {
                    this.FastSetBlock(world, x + i + 1, y + 1, z + k + 1, Blocks.lava);
                }
            }
        }
        for (int j = 0; j < 3; ++j) {
            world.setBlock(x + 4, y + j + 2, z + 4, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, x + 4, y + j + 2, z + 4);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Kyuubi");
            }
        }
        world.setBlock(x + 4, y + 5, z + 4, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(x + 4, y + 5, z + 4, 2, 3);
        chest = this.getChestTileEntity(world, x + 4, y + 5, z + 4);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 7 + world.rand.nextInt(7));
        }
    }

    private void addblaze(final World world, final int x, final int y, final int z) {
        int width = 7;
        int height = 4;
        int xx = x;
        int yy = y;
        int zz = z;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        TileEntityMobSpawner tileentitymobspawner = null;
        chestContents = this.blazeContentsList;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = 0; j < height; ++j) {
                    this.FastSetBlock(world, xx + i, yy + j, zz + k, Blocks.obsidian);
                }
            }
        }
        ++xx;
        yy += height;
        ++zz;
        width = 5;
        height = 1;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = 0; j < height; ++j) {
                    this.FastSetBlock(world, xx + i, yy + j, zz + k, Blocks.obsidian);
                }
            }
        }
        ++xx;
        yy += height;
        ++zz;
        width = 3;
        height = 6;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = 0; j < height; ++j) {
                    this.FastSetBlock(world, xx + i, yy + j, zz + k, Blocks.obsidian);
                }
            }
        }
        ++xx;
        yy += height;
        ++zz;
        width = 1;
        height = 5;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = 0; j < height; ++j) {
                    this.FastSetBlock(world, xx + i, yy + j, zz + k, Blocks.obsidian);
                }
            }
        }
        for (int j = 0; j < 2; ++j) {
            world.setBlock(xx - 1, yy + height + j - 3, zz, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, xx - 1, yy + height + j - 3, zz);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Blaze");
            }
            world.setBlock(xx + 1, yy + height + j - 3, zz, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, xx + 1, yy + height + j - 3, zz);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Blaze");
            }
            world.setBlock(xx, yy + height + j - 3, zz - 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, xx, yy + height + j - 3, zz - 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Blaze");
            }
            world.setBlock(xx, yy + height + j - 3, zz + 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, xx, yy + height + j - 3, zz + 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Blaze");
            }
        }
        world.setBlock(x, y + 4, z + 3, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(x, y + 4, z + 3, 4, 3);
        chest = this.getChestTileEntity(world, x, y + 4, z + 3);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
        world.setBlock(x + 3, y + 4, z, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(x + 3, y + 4, z, 2, 3);
        chest = this.getChestTileEntity(world, x + 3, y + 4, z);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
        world.setBlock(x + 3, y + 4, z + 6, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(x + 3, y + 4, z + 6, 3, 3);
        chest = this.getChestTileEntity(world, x + 3, y + 4, z + 6);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(5));
        }
        world.setBlock(x + 6, y + 4, z + 3, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(x + 6, y + 4, z + 3, 5, 3);
        chest = this.getChestTileEntity(world, x + 6, y + 4, z + 3);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(5));
        }
    }

    public void makeSmallBeeHive(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 7;
        final int height = 21;
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        if (world.isRemote) {
            return;
        }
        for (int i = -3; i < width + 3; ++i) {
            for (int j = height * 2 / 3; j < height; ++j) {
                for (int k = -3; k < width + 3; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                int j = height * 2 / 3;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
                int blk = world.rand.nextInt(height / 3);
                blk *= 2;
                blk -= Math.abs(i - width / 2);
                blk -= Math.abs(k - width / 2);
                if (blk < 1) {
                    blk = 1;
                }
                if (i == width / 2 && k == width / 2) {
                    blk = height * 2 / 3;
                }
                for (j = 0; j < blk; ++j) {
                    this.FastSetBlock(
                        world,
                        cposx + i,
                        cposy + height * 2 / 3 - j,
                        cposz + k,
                        Blocks.mossy_cobblestone);
                }
            }
        }
        int j = height * 2 / 3;
        for (int blk = 0; blk < height / 6; ++blk) {
            ++j;
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < width; ++k) {
                    if (k == 0 || i == 0 || k == width - 1 || i == width - 1) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                    }
                }
            }
            ++j;
            for (int i = -1; i < width + 1; ++i) {
                for (int k = -1; k < width + 1; ++k) {
                    if (k == -1 || i == -1 || k == width || i == width) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                    }
                }
            }
        }
        ++j;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.sponge);
            }
        }
        j = height * 2 / 3 + 1;
        for (int i = -1; i < 1; ++i) {
            for (int k = 2; k < 4; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, Blocks.air);
                this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k, Blocks.air);
            }
        }
        for (int blk = 0; blk < 3; ++blk) {
            world.setBlock(cposx + 1, cposy + blk + j, cposz + 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + blk + j, cposz + 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Bee");
            }
        }
        chestContents = this.beeContentsList;
        world.setBlock(cposx + width / 2, cposy + j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + width / 2, 5, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 7 + world.rand.nextInt(5));
        }
    }

    public void makeShadowDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        final int totalwidth = 19;
        TileEntityMobSpawner tileentitymobspawner = null;
        String whichmob = null;
        if (world.isRemote) {
            return;
        }
        int yoff;
        int xoff;
        int zoff = xoff = (yoff = 0);
        for (int width = totalwidth; width > 0; width -= 2) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < width; ++k) {
                    if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                        Block blk = Blocks.obsidian;
                        if ((yoff & 0x1) != 0x0) {
                            blk = Blocks.bedrock;
                        }
                        if ((k >= width / 2 - 1 && k <= width / 2 + 1) || (i >= width / 2 - 1 && i <= width / 2 + 1)) {
                            blk = Blocks.soul_sand;
                        }
                        this.FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, blk);
                    } else {
                        this.FastSetBlock(world, cposx + i + xoff, cposy - yoff, cposz + k + zoff, Blocks.air);
                    }
                }
            }
            if (width <= 15 && width >= 9) {
                if ((yoff & 0x1) != 0x0) {
                    this.fill_shadow_chests(world, cposx + xoff, cposy - yoff, cposz + zoff, width, 0);
                    whichmob = "Ender Reaper";
                } else {
                    whichmob = "Nightmare";
                }
                world.setBlock(cposx + xoff + 1, cposy - yoff, cposz + zoff + 1, Blocks.mob_spawner, 0, 2);
                tileentitymobspawner = this
                    .getSpawnerTileEntity(world, cposx + xoff + 1, cposy - yoff, cposz + zoff + 1);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName(whichmob);
                }
                world.setBlock(cposx + xoff + width - 2, cposy - yoff, cposz + zoff + 1, Blocks.mob_spawner, 0, 2);
                tileentitymobspawner = this
                    .getSpawnerTileEntity(world, cposx + xoff + width - 2, cposy - yoff, cposz + zoff + 1);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName(whichmob);
                }
                world.setBlock(cposx + xoff + 1, cposy - yoff, cposz + zoff + width - 2, Blocks.mob_spawner, 0, 2);
                tileentitymobspawner = this
                    .getSpawnerTileEntity(world, cposx + xoff + 1, cposy - yoff, cposz + zoff + width - 2);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName(whichmob);
                }
                world.setBlock(
                    cposx + xoff + width - 2,
                    cposy - yoff,
                    cposz + zoff + width - 2,
                    Blocks.mob_spawner,
                    0,
                    2);
                tileentitymobspawner = this
                    .getSpawnerTileEntity(world, cposx + xoff + width - 2, cposy - yoff, cposz + zoff + width - 2);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName(whichmob);
                }
            }
            ++xoff;
            ++zoff;
            ++yoff;
        }
        zoff = (xoff = (yoff = 0));
        for (int width = totalwidth; width > 0; width -= 2) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < width; ++k) {
                    if (k == 0 || k == width - 1 || i == 0 || i == width - 1) {
                        Block blk = Blocks.obsidian;
                        if ((yoff & 0x1) != 0x0) {
                            blk = Blocks.bedrock;
                        }
                        this.FastSetBlock(world, cposx + i + xoff, cposy + yoff, cposz + k + zoff, blk);
                    } else {
                        this.FastSetBlock(world, cposx + i + xoff, cposy + yoff, cposz + k + zoff, Blocks.air);
                    }
                }
            }
            ++xoff;
            ++zoff;
            ++yoff;
        }
    }

    private void fill_shadow_chests(final World world, final int cposx, final int cposy, final int cposz,
        final int width, final int height) {
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.shadowContentsList;
        final int j = height;
        world.setBlock(cposx + 1, cposy + j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + 1, cposy + j, cposz + width / 2, 5, 3);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + j, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
        world.setBlock(cposx + width - 2, cposy + j, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width - 2, cposy + j, cposz + width / 2, 4, 3);
        chest = this.getChestTileEntity(world, cposx + width - 2, cposy + j, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
        world.setBlock(cposx + width / 2, cposy + j, cposz + 1, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + 1, 3, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
        world.setBlock(cposx + width / 2, cposy + j, cposz + width - 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + j, cposz + width - 2, 2, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width - 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(7));
        }
    }

    public void makeAlienWTFDungeon(final World world, int cposx, int cposy, int cposz) {
        final int width = 5;
        final int height = 5;
        int xwidth = 3;
        int zwidth = 6;
        final int depth = 20;
        cposy -= depth - 3;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < width; ++k) {
                    if (i == 0 || j == 0 || k == 0 || i == width - 1 || j == height - 1 || k == width - 1) {
                        this.FastSetBlock(world, cposx + i - 2, cposy + j, cposz + k - 2, Blocks.lapis_ore);
                    } else {
                        this.FastSetBlock(world, cposx + i - 2, cposy + j, cposz + k - 2, Blocks.air);
                    }
                }
            }
        }
        int s = 0;
        --cposx;
        --cposz;
        for (int j = 3; j < depth; ++j) {
            for (int i = 0; i < 4; ++i) {
                for (int k = 0; k < 4; ++k) {
                    Block blk = Blocks.air;
                    if (i == 0 || k == 0 || i == 3 || k == 3) {
                        blk = Blocks.lapis_ore;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, 0, 2);
                }
            }
            switch (s) {
                case 0: {
                    OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz + 1, Blocks.stone, 0, 2);
                    break;
                }
                case 1: {
                    OreSpawnMain.setBlockFast(world, cposx + 2, cposy + j, cposz + 1, Blocks.stone, 0, 2);
                    break;
                }
                case 2: {
                    OreSpawnMain.setBlockFast(world, cposx + 2, cposy + j, cposz + 2, Blocks.stone, 0, 2);
                    break;
                }
                default: {
                    OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz + 2, Blocks.stone, 0, 2);
                    break;
                }
            }
            if (++s > 3) {
                s = 0;
            }
        }
        ++cposx;
        ++cposz;
        this.makePart(world, cposx, cposy, cposz + 7, 9, 5, 1, 1, 1);
        for (int i = 0; i < xwidth; ++i) {
            for (int k = 0; k < zwidth; ++k) {
                for (int j = 0; j < 4; ++j) {
                    Block blk = Blocks.air;
                    if (j == 0 || j == 3) {
                        blk = Blocks.lapis_ore;
                    }
                    if (i == 0 || i == xwidth - 1) {
                        blk = Blocks.lapis_ore;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 2, blk);
                }
            }
        }
        this.makePart(world, cposx + 7, cposy, cposz, 11, 6, 1, -1, 2);
        xwidth = 6;
        zwidth = 3;
        for (int i = 0; i < xwidth; ++i) {
            for (int k = 0; k < zwidth; ++k) {
                for (int j = 0; j < 4; ++j) {
                    Block blk = Blocks.air;
                    if (j == 0 || j == 3) {
                        blk = Blocks.lapis_ore;
                    }
                    if (k == 0 || k == zwidth - 1) {
                        blk = Blocks.lapis_ore;
                    }
                    this.FastSetBlock(world, cposx + i + 2, cposy + j, cposz - k, blk);
                }
            }
        }
        this.makePart(world, cposx - 7, cposy, cposz, 13, 7, -1, 1, 3);
        xwidth = 6;
        zwidth = 3;
        for (int i = 0; i < xwidth; ++i) {
            for (int k = 0; k < zwidth; ++k) {
                for (int j = 0; j < 4; ++j) {
                    Block blk = Blocks.air;
                    if (j == 0 || j == 3) {
                        blk = Blocks.lapis_ore;
                    }
                    if (k == 0 || k == zwidth - 1) {
                        blk = Blocks.lapis_ore;
                    }
                    this.FastSetBlock(world, cposx - i - 2, cposy + j, cposz + k, blk);
                }
            }
        }
        this.makePart(world, cposx, cposy, cposz - 7, 15, 8, -1, -1, 4);
        xwidth = 3;
        zwidth = 6;
        for (int i = 0; i < xwidth; ++i) {
            for (int k = 0; k < zwidth; ++k) {
                for (int j = 0; j < 4; ++j) {
                    Block blk = Blocks.air;
                    if (j == 0 || j == 3) {
                        blk = Blocks.lapis_ore;
                    }
                    if (i == 0 || i == xwidth - 1) {
                        blk = Blocks.lapis_ore;
                    }
                    this.FastSetBlock(world, cposx - i, cposy + j, cposz - k - 2, blk);
                }
            }
        }
    }

    private void makePart(final World world, final int cposx, final int cposy, final int cposz, final int width,
        final int height, final int dx, final int dz, final int difficulty) {
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < width; ++k) {
                    this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                Block blk = Blocks.quartz_block;
                if (i == width / 2 || k == width / 2) {
                    blk = Blocks.obsidian;
                }
                this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, blk);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height;
            for (int k = 0; k < width; ++k) {
                final Block blk = Blocks.obsidian;
                this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, blk);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                final Block blk = Blocks.obsidian;
                int k = 0;
                this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, blk);
                k = width - 1;
                this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, blk);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 0; j < height; ++j) {
                int i = 0;
                this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, Blocks.obsidian);
                i = width - 1;
                this.FastSetBlock(world, cposx + i * dx, cposy + j, cposz + k * dz, Blocks.obsidian);
            }
        }
        for (int j = 0; j < difficulty; ++j) {
            world.setBlock(cposx + dx * width / 2, cposy + j + 2, cposz + dz * width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + dx * width / 2, cposy + j + 2, cposz + dz * width / 2);
            if (tileentitymobspawner != null) {
                final int t = world.rand.nextInt(2);
                if (t == 0) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Alien");
                }
                if (t == 1) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("WTF?");
                }
            }
            world.setBlock(
                cposx + dx * width / 2 + dx,
                cposy + j + 2,
                cposz + dz * width / 2 + dz,
                Blocks.mob_spawner,
                0,
                2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + dx * width / 2 + dx, cposy + j + 2, cposz + dz * width / 2 + dz);
            if (tileentitymobspawner != null) {
                final int t = world.rand.nextInt(2);
                if (t == 0) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Alien");
                }
                if (t == 1) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("WTF?");
                }
            }
        }
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.AlienWTFContentsList;
        world.setBlock(cposx + width * dx / 2, cposy + 1, cposz + dz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + width * dx / 2, cposy + 1, cposz + dz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
        if (difficulty > 1) {
            world.setBlock(cposx + width * dx / 2, cposy + 1, cposz + (width - 2) * dz, (Block) Blocks.chest, 0, 2);
            chest = this.getChestTileEntity(world, cposx + width * dx / 2, cposy + 1, cposz + (width - 2) * dz);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
            }
        }
        if (difficulty > 2) {
            world.setBlock(cposx + dx, cposy + 1, cposz + width / 2 * dz, (Block) Blocks.chest, 0, 2);
            chest = this.getChestTileEntity(world, cposx + dx, cposy + 1, cposz + width / 2 * dz);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
            }
        }
        if (difficulty > 3) {
            world.setBlock(cposx + (width - 2) * dx, cposy + 1, cposz + width / 2 * dz, (Block) Blocks.chest, 0, 2);
            chest = this.getChestTileEntity(world, cposx + (width - 2) * dx, cposy + 1, cposz + width / 2 * dz);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
            }
        }
    }

    public void makeEnderKnightDungeon(final World world, int cposx, final int cposy, int cposz) {
        final int height = 6;
        int zwidth = 5;
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 5; ++k) {
                for (int j = 0; j < 5; ++j) {
                    this.FastSetBlock(world, cposx, cposy + j, cposz + k, Blocks.air);
                }
            }
            ++cposx;
        }
        zwidth = 5;
        for (int k = 0; k < zwidth; ++k) {
            for (int j = 0; j < height; ++j) {
                Block blk = Blocks.obsidian;
                if (k == 2 && j >= 1 && j <= 3) {
                    blk = Blocks.air;
                }
                this.FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
            }
        }
        ++cposx;
        --cposz;
        zwidth = 7;
        for (int k = 0; k < zwidth; ++k) {
            for (int j = 0; j < height; ++j) {
                Block blk = Blocks.air;
                if (j == 0 || j == height - 1) {
                    blk = Blocks.obsidian;
                }
                if (j == 0 && k > 0 && k < zwidth - 1) {
                    blk = Blocks.end_stone;
                }
                if (k == 0 || k == zwidth - 1) {
                    blk = Blocks.obsidian;
                }
                this.FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
            }
            if (k == 1 || k == 2 || k == zwidth - 3 || k == zwidth - 2) {
                this.makeShelves(world, cposx, cposy + 1, cposz + k);
            }
        }
        --cposz;
        for (int m = 0; m < 5; ++m) {
            ++cposx;
            zwidth = 9;
            for (int k = 0; k < zwidth; ++k) {
                for (int j = 0; j < height; ++j) {
                    Block blk = Blocks.air;
                    if (j == 0 || j == height - 1) {
                        blk = Blocks.obsidian;
                    }
                    if (j == 0 && k > 0 && k < zwidth - 1) {
                        blk = Blocks.end_stone;
                    }
                    if (k == 0 || k == zwidth - 1) {
                        blk = Blocks.obsidian;
                    }
                    this.FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
                }
                if (k == 1 || k == 2 || k == zwidth - 3 || k == zwidth - 2) {
                    this.makeShelves(world, cposx, cposy + 1, cposz + k);
                }
                if (m == 2 && k == 4) {
                    world.setBlock(cposx, cposy + 2, cposz + k, Blocks.mob_spawner, 0, 2);
                    tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz + k);
                    if (tileentitymobspawner != null) {
                        tileentitymobspawner.func_145881_a()
                            .setEntityName("Ender Knight");
                    }
                    world.setBlock(cposx, cposy + 3, cposz + k, Blocks.mob_spawner, 0, 2);
                    tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz + k);
                    if (tileentitymobspawner != null) {
                        tileentitymobspawner.func_145881_a()
                            .setEntityName("Ender Knight");
                    }
                }
            }
        }
        ++cposz;
        ++cposx;
        zwidth = 7;
        for (int k = 0; k < zwidth; ++k) {
            for (int j = 0; j < height; ++j) {
                Block blk = Blocks.air;
                if (j == 0 || j == height - 1) {
                    blk = Blocks.obsidian;
                }
                if (j == 0 && k > 0 && k < zwidth - 1) {
                    blk = Blocks.end_stone;
                }
                if (k == 0 || k == zwidth - 1) {
                    blk = Blocks.obsidian;
                }
                this.FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
            }
            if (k == 1 || k == 2 || k == zwidth - 3 || k == zwidth - 2) {
                this.makeShelves(world, cposx, cposy + 1, cposz + k);
            }
        }
        ++cposz;
        ++cposx;
        zwidth = 5;
        for (int k = 0; k < zwidth; ++k) {
            for (int j = 0; j < height; ++j) {
                final Block blk = Blocks.obsidian;
                this.FastSetBlock(world, cposx, cposy + j, cposz + k, blk);
            }
        }
    }

    private void makeShelves(final World world, final int cposx, final int cposy, final int cposz) {
        final int i = world.rand.nextInt(4);
        Block blk = Blocks.air;
        if (i == 0) {
            TileEntityChest chest = null;
            WeightedRandomChestContent[] chestContents = null;
            chestContents = this.KnightContentsList;
            world.setBlock(cposx, cposy, cposz, (Block) Blocks.chest, 0, 2);
            chest = this.getChestTileEntity(world, cposx, cposy, cposz);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
            }
        }
        if (i == 1) {
            blk = Blocks.bookshelf;
            for (int k = 1 + world.rand.nextInt(4), j = 0; j < k; ++j) {
                this.FastSetBlock(world, cposx, cposy + j, cposz, blk);
            }
        }
        if (i == 2) {
            blk = Blocks.web;
            for (int k = 1 + world.rand.nextInt(4), j = 0; j < k; ++j) {
                this.FastSetBlock(world, cposx, cposy + j, cposz, blk);
            }
        }
    }

    public void makePlayPool(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.SquidContentsList;
        for (int i = 0; i < 4; ++i) {
            world.setBlock(cposx + i, cposy + 16, cposz, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + 16, cposz);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Attack Squid");
            }
        }
        world.setBlock(cposx + 1, cposy + 17, cposz, (Block) Blocks.chest, 0, 2);
        world.setBlock(cposx + 2, cposy + 17, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + 17, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
        for (int i = 0; i < 4; ++i) {
            world.setBlock(cposx + i, cposy + 18, cposz, Blocks.water, 0, 3);
        }
        world.setBlock(cposx - 1, cposy + 18, cposz, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx + 4, cposy + 18, cposz, (Block) Blocks.flowing_water, 0, 3);
    }

    public void makeWaterDragonLair(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.WaterDragonContentsList;
        for (float radius = 10.0f, currad = 0.0f; currad < radius; currad += 0.33f) {
            for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
                final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
                final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
                Block blk = Blocks.bedrock;
                if (currad > 5.0f && currad < 6.0f) {
                    blk = Blocks.iron_block;
                }
                this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 7, (int) (cposz + curz + 0.5f), blk);
            }
        }
        for (int i = 1; i < 10; ++i) {
            this.FastSetBlock(world, (int) (cposx + i + 0.5f), cposy + 7, (int) (cposz + 0.5f), Blocks.iron_block);
            this.FastSetBlock(world, (int) (cposx - i + 0.5f), cposy + 7, (int) (cposz + 0.5f), Blocks.iron_block);
            this.FastSetBlock(world, (int) (cposx + 0.5f), cposy + 7, (int) (cposz + i + 0.5f), Blocks.iron_block);
            this.FastSetBlock(world, (int) (cposx + 0.5f), cposy + 7, (int) (cposz - i + 0.5f), Blocks.iron_block);
        }
        this.FastSetBlock(world, (int) (cposx + 0.5f), cposy + 7, (int) (cposz + 0.5f), Blocks.air);
        this.FastSetBlock(world, (int) (cposx + 1 + 0.5f), cposy + 7, (int) (cposz + 0.5f), Blocks.glowstone);
        this.FastSetBlock(world, (int) (cposx - 1 + 0.5f), cposy + 7, (int) (cposz + 0.5f), Blocks.glowstone);
        this.FastSetBlock(world, (int) (cposx + 0.5f), cposy + 7, (int) (cposz + 1 + 0.5f), Blocks.glowstone);
        this.FastSetBlock(world, (int) (cposx + 0.5f), cposy + 7, (int) (cposz - 1 + 0.5f), Blocks.glowstone);
        float currad = 10.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(
                world,
                (int) (cposx + curx + 0.5f),
                cposy + 1,
                (int) (cposz + curz + 0.5f),
                Blocks.glowstone);
            Block blk = Blocks.lapis_block;
            if (world.rand.nextInt(2) == 0) {
                blk = OreSpawnMain.MyWaterDragonSpawnBlock;
            }
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 2, (int) (cposz + curz + 0.5f), blk);
            blk = Blocks.lapis_block;
            if (world.rand.nextInt(2) == 0) {
                blk = OreSpawnMain.MyWaterDragonSpawnBlock;
            }
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 3, (int) (cposz + curz + 0.5f), blk);
            this.FastSetBlock(
                world,
                (int) (cposx + curx + 0.5f),
                cposy + 4,
                (int) (cposz + curz + 0.5f),
                Blocks.glowstone);
            this.FastSetBlock(
                world,
                (int) (cposx + curx + 0.5f),
                cposy + 5,
                (int) (cposz + curz + 0.5f),
                Blocks.bedrock);
            this.FastSetBlock(
                world,
                (int) (cposx + curx + 0.5f),
                cposy + 6,
                (int) (cposz + curz + 0.5f),
                Blocks.bedrock);
        }
        for (int i = -3; i <= 3; ++i) {
            for (int j = -3; j <= 3; ++j) {
                this.FastSetBlock(world, cposx + i, cposy, cposz + j, (Block) Blocks.sand);
                this.FastSetBlock(world, cposx + i, cposy - 1, cposz + j, Blocks.stone);
            }
        }
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                this.FastSetBlock(world, cposx + i, cposy + 3, cposz + j, (Block) Blocks.leaves);
            }
        }
        this.FastSetBlock(world, cposx, cposy + 4, cposz, (Block) Blocks.leaves);
        this.FastSetBlock(world, cposx, cposy + 3, cposz, Blocks.log);
        this.FastSetBlock(world, cposx, cposy + 2, cposz, Blocks.log);
        this.FastSetBlock(world, cposx, cposy + 1, cposz, Blocks.log);
        this.FastSetBlock(world, cposx + 1, cposy + 3, cposz + 1, Blocks.log);
        this.FastSetBlock(world, cposx - 1, cposy + 3, cposz - 1, Blocks.log);
        this.FastSetBlock(world, cposx + 1, cposy + 3, cposz - 1, Blocks.log);
        this.FastSetBlock(world, cposx - 1, cposy + 3, cposz + 1, Blocks.log);
        world.setBlock(cposx + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Water Dragon");
        }
        world.setBlock(cposx - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Water Dragon");
        }
        world.setBlock(cposx, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Water Dragon");
        }
        world.setBlock(cposx, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Water Dragon");
        }
        world.setBlock(cposx, cposy + 1, cposz - 1, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
    }

    public void makeCloudSharkDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.CloudSharkContentsList;
        this.FastSetBlock(world, cposx, cposy, cposz, Blocks.glowstone);
        this.FastSetBlock(world, cposx, cposy - 1, cposz, Blocks.glowstone);
        world.setBlock(cposx + 1, cposy, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Cloud Shark");
        }
        world.setBlock(cposx - 1, cposy, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Cloud Shark");
        }
        world.setBlock(cposx, cposy, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Cloud Shark");
        }
        world.setBlock(cposx, cposy, cposz - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy, cposz - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Cloud Shark");
        }
        world.setBlock(cposx, cposy + 1, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
    }

    public void makeLeafMonsterDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.LeafMonsterContentsList;
        for (int i = -2; i < 6; ++i) {
            for (int k = -3; k < 2; ++k) {
                for (int j = 0; j < 4; ++j) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 4; ++k) {
                for (int j = -1; j > -5; --j) {
                    final Block blk = Blocks.log;
                    final Block bid = world.getBlock(cposx + i, cposy + j, cposz + k);
                    if (bid == Blocks.air || bid == Blocks.tallgrass) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                    }
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 4; ++k) {
                for (int j = 0; j < 10; ++j) {
                    Block blk = Blocks.log;
                    if (j < 2 && (k == 0 || k == 1) && (i == 1 || i == 2)) {
                        blk = Blocks.air;
                    }
                    if (k == 1 && (i == 1 || i == 2)) {
                        blk = Blocks.air;
                    }
                    if (k == 2) {
                        if (i == 1) {
                            continue;
                        }
                        if (i == 2) {
                            continue;
                        }
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 4; ++k) {
                for (int j = 0; j < 10; ++j) {
                    if (k == 2 && (i == 1 || i == 2)) {
                        final Block blk = Blocks.ladder;
                        world.setBlock(cposx + i, cposy + j, cposz + k, blk, 2, 3);
                    }
                }
            }
        }
        this.FastSetBlock(world, cposx + 1, cposy + 2, cposz - 1, (Block) Blocks.leaves);
        this.FastSetBlock(world, cposx + 2, cposy + 2, cposz - 1, (Block) Blocks.leaves);
        for (int i = -3; i < 7; ++i) {
            for (int k = -3; k < 7; ++k) {
                final int j = 9;
                if (i < 0 || i > 3 || k < 0 || k > 3) {
                    Block blk = Blocks.log;
                    if (i == -3 || i == 6 || k == -3 || k == 6) {
                        blk = (Block) Blocks.leaves;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        for (int i = -3; i < 7; ++i) {
            for (int k = -3; k < 7; ++k) {
                for (int j = 10; j < 13; ++j) {
                    Block blk = Blocks.air;
                    if (i == -3 || i == 6 || k == -3 || k == 6) {
                        blk = (Block) Blocks.leaves;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        for (int i = -2; i < 6; ++i) {
            for (int k = -2; k < 6; ++k) {
                final int j = 13;
                Block blk = Blocks.air;
                if (i == -2 || i == 5 || k == -2 || k == 5) {
                    blk = Blocks.log;
                }
                if (i == -1 || i == 4 || k == -1 || k == 4) {
                    blk = (Block) Blocks.leaves;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = -1; i < 5; ++i) {
            for (int k = -1; k < 5; ++k) {
                final int j = 14;
                final Block blk = (Block) Blocks.leaves;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int k = 0; k < 4; ++k) {
                final int j = 15;
                final Block blk = Blocks.log;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = 1; i < 3; ++i) {
            for (int k = 1; k < 3; ++k) {
                final int j = 16;
                final Block blk = (Block) Blocks.leaves;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        world.setBlock(cposx - 2, cposy + 10, cposz - 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 2, cposy + 10, cposz - 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Leaf Monster");
        }
        world.setBlock(cposx + 5, cposy + 10, cposz + 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 5, cposy + 10, cposz + 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Leaf Monster");
        }
        world.setBlock(cposx - 2, cposy + 10, cposz + 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 2, cposy + 10, cposz + 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Leaf Monster");
        }
        world.setBlock(cposx + 5, cposy + 10, cposz - 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 5, cposy + 10, cposz - 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Leaf Monster");
        }
        world.setBlock(cposx + 1, cposy + 10, cposz + 5, (Block) Blocks.chest, 0, 2);
        world.setBlock(cposx + 2, cposy + 10, cposz + 5, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + 10, cposz + 5);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 12 + world.rand.nextInt(5));
        }
    }

    public void makeMiniDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.MiniContentsList;
        for (int i = 0; i < 10; ++i) {
            for (int k = 0; k < 10; ++k) {
                for (int j = 0; j < 7; ++j) {
                    Block blk = Blocks.air;
                    if (i == 0 || k == 0 || i == 9 || k == 9) {
                        blk = Blocks.iron_bars;
                    }
                    if (i == 0 && k == 0) {
                        blk = Blocks.cobblestone;
                    }
                    if (i == 9 && k == 9) {
                        blk = Blocks.cobblestone;
                    }
                    if (i == 0 && k == 9) {
                        blk = Blocks.cobblestone;
                    }
                    if (i == 9 && k == 0) {
                        blk = Blocks.cobblestone;
                    }
                    if (j == 0) {
                        blk = Blocks.cobblestone;
                    }
                    if (j == 6 && (i == 0 || k == 0 || i == 9 || k == 9)) {
                        blk = Blocks.cobblestone;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        for (int i = 1; i < 9; ++i) {
            for (int k = 1; k < 9; ++k) {
                final int j = 7;
                Block blk = Blocks.air;
                if (i == 1 || i == 8 || k == 1 || k == 8) {
                    blk = (Block) Blocks.grass;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = 2; i < 8; ++i) {
            for (int k = 2; k < 8; ++k) {
                final int j = 8;
                Block blk = Blocks.air;
                if (i == 2 || i == 7 || k == 2 || k == 7) {
                    blk = (Block) Blocks.grass;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        int i = -6;
        int j = 1;
        int k = 3;
        for (int m = 0; m < 6; ++m) {
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.planks);
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.planks);
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 2, Blocks.planks);
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 3, Blocks.planks);
            this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, Blocks.fence);
            this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + 3, Blocks.fence);
            this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k, Blocks.torch);
            this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + 3, Blocks.torch);
            ++i;
            ++j;
        }
        for (i = 3; i < 7; ++i) {
            for (k = 3; k < 7; ++k) {
                j = 9;
                final Block blk = Blocks.air;
                if (i == 3 || i == 6 || k == 3 || k == 6) {
                    world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
                    tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
                    if (tileentitymobspawner != null) {
                        tileentitymobspawner.func_145881_a()
                            .setEntityName("Butterfly");
                    }
                }
            }
        }
        k = (i = 0);
        for (j = 7; j < 11; ++j) {
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
        }
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Terrible Terror");
        }
        k = (i = 9);
        for (j = 7; j < 11; ++j) {
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
        }
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Butterfly");
        }
        i = 0;
        k = 9;
        for (j = 7; j < 11; ++j) {
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
        }
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Terrible Terror");
        }
        i = 9;
        k = 0;
        for (j = 7; j < 11; ++j) {
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.cobblestone);
        }
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Butterfly");
        }
        k = (i = 1);
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Terrible Terror");
        }
        k = (i = 8);
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Terrible Terror");
        }
        i = 8;
        k = 1;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Butterfly");
        }
        i = 1;
        k = 8;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Butterfly");
        }
        i = 4;
        k = 4;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Lurking Terror");
        }
        i = 5;
        k = 5;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Lurking Terror");
        }
        world.setBlock(cposx + 3, cposy + 1, cposz + 3, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + 3, cposy + 1, cposz + 3);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
    }

    public void makeGoldFishBowl(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        int j = 1;
        Block blk = Blocks.glass;
        for (int i = 0; i < 5; ++i) {
            for (int k = 0; k < 5; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        j = 2;
        for (int i = -1; i < 6; ++i) {
            for (int k = -1; k < 6; ++k) {
                blk = (Block) Blocks.sand;
                if (i == -1 || k == -1 || i == 5 || k == 5) {
                    blk = Blocks.glass;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        j = 3;
        for (int i = -1; i < 6; ++i) {
            for (int k = -1; k < 6; ++k) {
                blk = Blocks.water;
                if (i == -1 || k == -1 || i == 5 || k == 5) {
                    blk = Blocks.glass;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        int k = 0;
        int i = 0;
        blk = Blocks.glowstone;
        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
        k = 4;
        i = 4;
        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
        k = 4;
        i = 0;
        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
        k = 0;
        i = 4;
        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
        j = 4;
        for (i = -1; i < 6; ++i) {
            for (k = -1; k < 6; ++k) {
                blk = Blocks.water;
                if (i == -1 || k == -1 || i == 5 || k == 5) {
                    blk = Blocks.glass;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (j = 5; j < 8; ++j) {
            for (i = -1; i < 6; ++i) {
                for (k = -1; k < 6; ++k) {
                    blk = Blocks.air;
                    if (i == -1 || k == -1 || i == 5 || k == 5) {
                        blk = Blocks.glass;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        j = 8;
        blk = Blocks.glass;
        for (i = 0; i < 5; ++i) {
            for (k = 0; k < 5; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        i = 2;
        k = 2;
        j = 6;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Gold Fish");
        }
    }

    public void makeEnderReaperGraveyard(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 11;
        final int length = 13;
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 1; j < 5; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < length; ++k) {
                    if (world.getBlock(cposx + i, cposy - j, cposz + k) == Blocks.air) {
                        this.FastSetBlock(world, cposx + i, cposy - j, cposz + k, Blocks.end_stone);
                    }
                }
            }
        }
        int j = 0;
        Block blk = Blocks.end_stone;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < length; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (j = 1; j < 5; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < length; ++k) {
                    blk = Blocks.air;
                    if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                        blk = Blocks.iron_bars;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        int i = 1;
        int k = 1;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = width - 2;
        k = length - 2;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = 1;
        k = length - 2;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = width - 2;
        k = 1;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        this.makeAGrave(world, cposx, cposy, cposz, 1, 6);
        this.makeAGrave(world, cposx, cposy, cposz, 3, 4);
        this.makeAGrave(world, cposx, cposy, cposz, 5, 4);
        this.makeAGrave(world, cposx, cposy, cposz, 7, 4);
        this.makeAGrave(world, cposx, cposy, cposz, 3, 8);
        this.makeAGrave(world, cposx, cposy, cposz, 5, 8);
        this.makeAGrave(world, cposx, cposy, cposz, 7, 8);
        this.makeAGrave(world, cposx, cposy, cposz, 9, 6);
    }

    public void makeAGrave(final World world, final int cposx, final int cposy, final int cposz, final int xoff,
        final int zoff) {
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.GraveContentsList;
        this.FastSetBlock(world, cposx + xoff, cposy + 1, cposz + zoff - 1, Blocks.obsidian);
        this.FastSetBlock(world, cposx + xoff, cposy, cposz + zoff + 1, Blocks.obsidian);
        world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(3));
        }
    }

    public void makeUrchinSpawner(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        for (int patchy = 3, i = 0; i < patchy; ++i) {
            Block bid = OreSpawnMain.CrystalStone;
            if (i == 1) {
                bid = OreSpawnMain.CrystalCrystal;
            }
            if (i == 2) {
                bid = OreSpawnMain.TigersEye;
            }
            final float dx = world.rand.nextFloat() - world.rand.nextFloat();
            final float dz = world.rand.nextFloat() - world.rand.nextFloat();
            final float dy = 0.5f + world.rand.nextFloat() / 2.0f;
            final int width = world.rand.nextInt(2);
            int length = 10 + width * 3 + world.rand.nextInt(5);
            if (i != 0) {
                length /= 2;
            }
            float rx = (float) cposx;
            float ry = (float) cposy;
            float rz = (float) cposz;
            for (int iy = 0; iy <= length; ++iy) {
                for (int ix = 0; ix <= width; ++ix) {
                    for (int iz = 0; iz <= width; ++iz) {
                        OreSpawnMain.setBlockFast(world, (int) (rx + ix), (int) ry, (int) (rz + iz), bid, 0, 2);
                    }
                }
                ry += dy;
                rx += dx;
                rz += dz;
            }
        }
        world.setBlock(cposx, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Crystal Urchin");
        }
        world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Crystal Urchin");
        }
        world.setBlock(cposx, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Crystal Urchin");
        }
        world.setBlock(cposx, cposy, cposz, Blocks.air, 0, 2);
        world.setBlock(cposx, cposy - 1, cposz, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx, cposy - 1, cposz, 2, 3);
        chest = this.getChestTileEntity(world, cposx, cposy - 1, cposz);
        if (chest != null) {
            chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.UrchinEgg, 1 + world.rand.nextInt(5), 0));
            chest.setInventorySlotContents(2, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
            chest.setInventorySlotContents(3, new ItemStack(OreSpawnMain.CrystalCoal, 4 + world.rand.nextInt(16), 0));
        }
    }

    public void makeSpitBugLair(final World world, final int cposx, final int cposy, final int cposz) {
        final int green = 5;
        final int dark_green = 13;
        final int width = 9;
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.SpitBugContentsList;
        for (int i = 0; i < width; ++i) {
            OreSpawnMain.setBlockFast(
                world,
                cposx + i,
                cposy + width - i + 2,
                cposz,
                Blocks.stained_hardened_clay,
                dark_green,
                2);
            OreSpawnMain.setBlockFast(
                world,
                cposx + i,
                cposy + width - i + 1,
                cposz,
                Blocks.stained_hardened_clay,
                dark_green,
                2);
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + width - i, cposz, Blocks.mossy_cobblestone, 0, 2);
            OreSpawnMain.setBlockFast(
                world,
                cposx - i,
                cposy + width - i + 2,
                cposz,
                Blocks.stained_hardened_clay,
                dark_green,
                2);
            OreSpawnMain.setBlockFast(
                world,
                cposx - i,
                cposy + width - i + 1,
                cposz,
                Blocks.stained_hardened_clay,
                dark_green,
                2);
            OreSpawnMain.setBlockFast(world, cposx - i, cposy + width - i, cposz, Blocks.mossy_cobblestone, 0, 2);
        }
        OreSpawnMain.setBlockFast(world, cposx, cposy + width + 3, cposz, Blocks.emerald_ore, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + width + 2, cposz, Blocks.emerald_ore, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + width + 1, cposz, Blocks.emerald_ore, 0, 2);
        world.setBlock(cposx, cposy + width + 0, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + width + 0, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Spit Bug");
        }
        world.setBlock(cposx, cposy + width - 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + width - 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Spit Bug");
        }
        world.setBlock(cposx, cposy + width - 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + width - 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Spit Bug");
        }
        final int k = 0;
        for (int i = 0; i < width; ++i) {
            for (int j = -i; j <= i; ++j) {
                OreSpawnMain.setBlockFast(
                    world,
                    cposx - width + i + 1,
                    cposy,
                    cposz + j,
                    Blocks.stained_hardened_clay,
                    green,
                    2);
                OreSpawnMain.setBlockFast(
                    world,
                    cposx + width - i - 1,
                    cposy,
                    cposz + j,
                    Blocks.stained_hardened_clay,
                    green,
                    2);
                if (j == -i || j == i) {
                    OreSpawnMain.setBlockFast(
                        world,
                        cposx - width + i + 1,
                        cposy + 1,
                        cposz + j,
                        Blocks.stained_hardened_clay,
                        dark_green,
                        2);
                    OreSpawnMain.setBlockFast(
                        world,
                        cposx + width - i - 1,
                        cposy + 1,
                        cposz + j,
                        Blocks.stained_hardened_clay,
                        dark_green,
                        2);
                    OreSpawnMain
                        .setBlockFast(world, cposx - width + i + 1, cposy + 2, cposz + j, Blocks.stonebrick, 3, 2);
                    OreSpawnMain
                        .setBlockFast(world, cposx + width - i - 1, cposy + 2, cposz + j, Blocks.stonebrick, 3, 2);
                } else {
                    OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy + 1, cposz + j, Blocks.air, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy + 1, cposz + j, Blocks.air, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx - width + i + 1, cposy + 2, cposz + j, Blocks.air, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + width - i - 1, cposy + 2, cposz + j, Blocks.air, 0, 2);
                }
            }
        }
        world.setBlock(cposx, cposy + 1, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(4));
        }
    }

    public void makeIgloo(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        float currad = 6.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 1, (int) (cposz + curz + 0.5f), Blocks.snow);
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 2, (int) (cposz + curz + 0.5f), Blocks.ice);
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 3, (int) (cposz + curz + 0.5f), Blocks.snow);
        }
        currad = 5.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 4, (int) (cposz + curz + 0.5f), Blocks.ice);
        }
        currad = 4.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 5, (int) (cposz + curz + 0.5f), Blocks.snow);
        }
        currad = 3.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 10.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 5, (int) (cposz + curz + 0.5f), Blocks.ice);
        }
        currad = 2.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 15.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 5, (int) (cposz + curz + 0.5f), Blocks.snow);
        }
        currad = 1.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 15.0f) {
            final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
            final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + 5, (int) (cposz + curz + 0.5f), Blocks.ice);
        }
        this.FastSetBlock(world, (int) (cposx - 6.0f + 0.5f), cposy, (int) (cposz + 0.5f), Blocks.planks);
        this.FastSetBlock(world, (int) (cposx - 6.0f + 0.5f), cposy + 1, (int) (cposz + 0.5f), Blocks.air);
        this.FastSetBlock(world, (int) (cposx - 6.0f + 0.5f), cposy + 2, (int) (cposz + 0.5f), Blocks.air);
        ItemDoor
            .placeDoorBlock(world, (int) (cposx - 6.0f + 0.5f), cposy + 1, (int) (cposz + 0.5f), 2, Blocks.wooden_door);
        world.setBlock(cposx + 2, cposy + 1, cposz - 4, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 2, cposy + 1, cposz - 4);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx - 1, cposy + 1, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 1, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost");
        }
        world.setBlock(cposx + 3, cposy + 1, cposz + 4, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 3, cposy + 1, cposz + 4);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost Pumpkin Skelly");
        }
        world.setBlock(cposx - 3, cposy + 1, cposz - 3, (Block) Blocks.chest, 2, 2);
        chest = this.getChestTileEntity(world, cposx - 3, cposy + 1, cposz - 3);
        if (chest != null) {
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(0, new ItemStack(Items.compass));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(1, new ItemStack((Item) Items.map));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(2, new ItemStack(Items.cooked_porkchop, 8));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(3, new ItemStack(Blocks.torch, 32));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(4, new ItemStack(Items.coal, 16));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(5, new ItemStack(Items.bed));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(6, new ItemStack(Items.bed));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(8, new ItemStack(Items.iron_pickaxe));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(9, new ItemStack(Items.iron_sword));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(10, new ItemStack(Items.iron_axe));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(11, new ItemStack(Items.bucket));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(13, new ItemStack((Block) Blocks.chest));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(14, new ItemStack(Items.gold_nugget, 6));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(15, new ItemStack(Items.gold_nugget, 8));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(16, new ItemStack(Items.gold_nugget, 10));
            }
        }
    }

    public void makeEnderDragonHospital(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.HospitalContentsList;
        for (int i = 0; i < 10; ++i) {
            for (int k = 0; k < 10; ++k) {
                for (int j = 0; j < 7; ++j) {
                    Block blk = Blocks.air;
                    if (i == 0 || k == 0 || i == 9 || k == 9) {
                        blk = Blocks.iron_bars;
                    }
                    if (i == 0 && k == 0) {
                        blk = Blocks.obsidian;
                    }
                    if (i == 9 && k == 9) {
                        blk = Blocks.obsidian;
                    }
                    if (i == 0 && k == 9) {
                        blk = Blocks.obsidian;
                    }
                    if (i == 9 && k == 0) {
                        blk = Blocks.obsidian;
                    }
                    if (j == 0) {
                        blk = Blocks.end_stone;
                    }
                    if (j == 6 && (i == 0 || k == 0 || i == 9 || k == 9)) {
                        blk = Blocks.end_stone;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        for (int i = 1; i < 9; ++i) {
            for (int k = 1; k < 9; ++k) {
                final int j = 7;
                Block blk = Blocks.air;
                if (i == 1 || i == 8 || k == 1 || k == 8) {
                    blk = OreSpawnMain.MyEyeOfEnderBlock;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = 2; i < 8; ++i) {
            for (int k = 2; k < 8; ++k) {
                final int j = 8;
                Block blk = Blocks.air;
                if (i == 2 || i == 7 || k == 2 || k == 7) {
                    blk = OreSpawnMain.MyEyeOfEnderBlock;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = 3; i < 7; ++i) {
            for (int k = 3; k < 7; ++k) {
                final int j = 9;
                Block blk = Blocks.air;
                if (i == 3 || i == 6 || k == 3 || k == 6) {
                    blk = OreSpawnMain.MyEyeOfEnderBlock;
                }
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        int i = -6;
        int j = 1;
        int k = 3;
        for (int m = 0; m < 6; ++m) {
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.end_stone);
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.end_stone);
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 2, Blocks.end_stone);
            this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 3, Blocks.end_stone);
            this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, Blocks.iron_bars);
            this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + 3, Blocks.iron_bars);
            this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k, Blocks.glowstone);
            this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + 3, Blocks.glowstone);
            ++i;
            ++j;
        }
        this.FastSetBlock(world, cposx + 0, cposy + 7, cposz + 0, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 0, cposy + 7, cposz + 9, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 9, cposy + 7, cposz + 0, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 9, cposy + 7, cposz + 9, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 0, cposy + 8, cposz + 0, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 0, cposy + 8, cposz + 9, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 9, cposy + 8, cposz + 0, Blocks.obsidian);
        this.FastSetBlock(world, cposx + 9, cposy + 8, cposz + 9, Blocks.obsidian);
        EntityEnderCrystal entityendercrystal = new EntityEnderCrystal(world);
        entityendercrystal.setLocationAndAngles(
            (double) (cposx + 0.5f),
            (double) (cposy + 9),
            (double) (cposz + 0.5f),
            world.rand.nextFloat() * 360.0f,
            0.0f);
        world.spawnEntityInWorld((Entity) entityendercrystal);
        this.FastSetBlock(world, cposx, cposy + 9, cposz, Blocks.bedrock);
        entityendercrystal = new EntityEnderCrystal(world);
        entityendercrystal.setLocationAndAngles(
            (double) (cposx + 0.5f),
            (double) (cposy + 9),
            (double) (cposz + 9.5f),
            world.rand.nextFloat() * 360.0f,
            0.0f);
        world.spawnEntityInWorld((Entity) entityendercrystal);
        this.FastSetBlock(world, cposx, cposy + 9, cposz + 9, Blocks.bedrock);
        entityendercrystal = new EntityEnderCrystal(world);
        entityendercrystal.setLocationAndAngles(
            (double) (cposx + 9.5f),
            (double) (cposy + 9),
            (double) (cposz + 0.5f),
            world.rand.nextFloat() * 360.0f,
            0.0f);
        world.spawnEntityInWorld((Entity) entityendercrystal);
        this.FastSetBlock(world, cposx + 9, cposy + 9, cposz, Blocks.bedrock);
        entityendercrystal = new EntityEnderCrystal(world);
        entityendercrystal.setLocationAndAngles(
            (double) (cposx + 9.5f),
            (double) (cposy + 9),
            (double) (cposz + 9.5f),
            world.rand.nextFloat() * 360.0f,
            0.0f);
        world.spawnEntityInWorld((Entity) entityendercrystal);
        this.FastSetBlock(world, cposx + 9, cposy + 9, cposz + 9, Blocks.bedrock);
        i = 3;
        k = 3;
        j = 9;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = 3;
        k = 6;
        j = 9;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = 6;
        k = 3;
        j = 9;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = 6;
        k = 6;
        j = 9;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        i = 1;
        k = 1;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Nightmare");
        }
        i = 1;
        k = 8;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Nightmare");
        }
        i = 8;
        k = 1;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Nightmare");
        }
        i = 8;
        k = 8;
        j = 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Nightmare");
        }
        world.setBlock(cposx + 4, cposy + 1, cposz + 4, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + 4, cposy + 1, cposz + 4);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(5));
        }
    }

    public void makeCrystalHauntedHouse(final World world, final int cposx, final int cposy, final int cposz) {
        int deltax = 0;
        final int deltaz = 0;
        final int bid = 0;
        final int dirx = 0;
        final int dirz = 0;
        int stuffdir = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        final int width;
        final int length = width = 3;
        final int height = 3;
        deltax = 1;
        stuffdir = 2;
        final int x = cposx;
        final int z = cposz;
        final int y = cposy;
        if (world.isRemote) {
            return;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k <= height + 1; ++k) {
                    if (k == height + 1) {
                        world.setBlock(x + i, y + k, z + j, OreSpawnMain.CrystalPlanksBlock);
                    } else if (k == 0) {
                        world.setBlock(x + i, y + k, z + j, OreSpawnMain.CrystalStone);
                    } else if (i == width || j == length || i == -width || j == -length) {
                        if (k == height) {
                            world.setBlock(x + i, y + k, z + j, Blocks.glass);
                        } else if ((k == 1 || k == 2) && i == deltax * width && j == deltaz * length) {
                            world.setBlock(x + i, y + k, z + j, Blocks.air);
                        } else {
                            world.setBlock(x + i, y + k, z + j, OreSpawnMain.CrystalPlanksBlock);
                        }
                    } else {
                        world.setBlock(x + i, y + k, z + j, Blocks.air);
                    }
                }
            }
        }
        int i = 2;
        int k = 1;
        int j = length - 1;
        world.setBlock(
            x + i * deltax + j * deltaz,
            y + k,
            z + i * deltaz + j * deltax,
            (Block) OreSpawnMain.CrystalFurnaceBlock);
        world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
        i = 1;
        world.setBlock(
            x + i * deltax + j * deltaz,
            y + k,
            z + i * deltaz + j * deltax,
            OreSpawnMain.CrystalWorkbenchBlock);
        i = 0;
        world.setBlock(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, (Block) Blocks.chest);
        world.setBlockMetadataWithNotify(x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax, stuffdir, 3);
        final TileEntityChest chest = this
            .getChestTileEntity(world, x + i * deltax + j * deltaz, y + k, z + i * deltaz + j * deltax);
        if (chest != null) {
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(0, new ItemStack(Items.compass));
            }
            if (world.rand.nextInt(3) != 0) {
                chest.setInventorySlotContents(2, new ItemStack(OreSpawnMain.MyPeacock, 8));
            }
            if (world.rand.nextInt(3) != 0) {
                chest.setInventorySlotContents(3, new ItemStack(OreSpawnMain.CrystalTorch, 32));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(4, new ItemStack(OreSpawnMain.CrystalCoal, 16));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(5, new ItemStack(Items.bed));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(6, new ItemStack(Items.bed));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(7, new ItemStack(Items.wooden_door));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(8, new ItemStack(OreSpawnMain.MyCrystalPinkPickaxe));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(9, new ItemStack(OreSpawnMain.MyCrystalPinkSword));
            }
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(10, new ItemStack(OreSpawnMain.MyCrystalPinkAxe));
            }
            chest.setInventorySlotContents(11, new ItemStack(OreSpawnMain.KrakenRepellent));
            if (world.rand.nextInt(2) == 0) {
                chest.setInventorySlotContents(13, new ItemStack((Block) Blocks.chest));
            }
        }
        world.setBlock(cposx, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost");
        }
        world.setBlock(cposx, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost Pumpkin Skelly");
        }
    }

    public void makeBouncyCastle(final World world, final int cposx, final int cposy, final int cposz) {
        int deltax = 0;
        final int deltaz = 0;
        Block bid = Blocks.air;
        int meta = 0;
        final int dirx = 0;
        final int dirz = 0;
        int stuffdir = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.BouncyContentsList;
        final int width;
        final int length = width = 4;
        final int height = 5;
        deltax = 1;
        stuffdir = 2;
        final int x = cposx;
        final int z = cposz;
        final int y = cposy;
        if (world.isRemote) {
            return;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k < height; ++k) {
                    bid = Blocks.air;
                    meta = 0;
                    if (k == height - 1 || k == 0) {
                        bid = OreSpawnMain.MyLavafoamBlock;
                    }
                    if (i == -width || i == width) {
                        bid = OreSpawnMain.MyLavafoamBlock;
                    }
                    if (j == -length || j == length) {
                        bid = OreSpawnMain.MyLavafoamBlock;
                    }
                    if ((i == -width || i == width) && (j == -length || j == length)) {
                        bid = Blocks.stained_hardened_clay;
                        meta = 14;
                    }
                    if ((k == 1 || k == 2) && i == 0 && j == -length) {
                        meta = 0;
                        bid = Blocks.air;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
                }
            }
        }
        world.setBlock(cposx - 1, cposy + 3, cposz + length - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz + length - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Silverfish");
        }
        world.setBlock(cposx, cposy + 3, cposz + length - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz + length - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx + 1, cposy + 3, cposz + length - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz + length - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Scorpion");
        }
        world.setBlock(cposx + width - 1, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width - 1, cposy + 3, cposz - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Silverfish");
        }
        world.setBlock(cposx + width - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width - 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx + width - 1, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width - 1, cposy + 3, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Scorpion");
        }
        world.setBlock(cposx - width + 1, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - width + 1, cposy + 3, cposz - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Silverfish");
        }
        world.setBlock(cposx - width + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - width + 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx - width + 1, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - width + 1, cposy + 3, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Scorpion");
        }
        world.setBlock(cposx + width - 1, cposy + 3, cposz + length - 1, (Block) Blocks.chest, 2, 2);
        chest = this.getChestTileEntity(world, cposx + width - 1, cposy + 3, cposz + length - 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(5));
        }
    }

    public void makeEnderCastle(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 22;
        final int height = 12;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        TileEntityMobSpawner tileentitymobspawner = null;
        chestContents = this.EnderCastleContentsList;
        Block bid = Blocks.obsidian;
        for (int i = -3; i <= width + 3; ++i) {
            for (int k = -3; k <= width + 3; ++k) {
                for (int j = 0; j <= 1; ++j) {
                    bid = Blocks.air;
                    if (j == 0) {
                        bid = Blocks.obsidian;
                    }
                    if (j == 1 && (i == -3 || i == width + 3 || (k == width + 3 | k == -3))) {
                        bid = Blocks.iron_bars;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        for (int i = 0; i <= width; ++i) {
            for (int k = 0; k <= width; ++k) {
                for (int j = 1; j <= height; ++j) {
                    bid = Blocks.air;
                    if (i == 0 || i == width || (k == width | k == 0)) {
                        bid = Blocks.bedrock;
                    }
                    if (j == height && bid == Blocks.bedrock && (i + k & 0x1) == 0x0) {
                        bid = Blocks.air;
                    }
                    if (j == height - 2 && bid == Blocks.bedrock && (i + k & 0x1) == 0x0) {
                        final int which = world.rand.nextInt(4);
                        if (which == 0) {
                            bid = OreSpawnMain.MyEnderKnightSpawnBlock;
                        }
                        if (which == 1) {
                            bid = OreSpawnMain.MyEnderReaperSpawnBlock;
                        }
                        if (which == 2) {
                            bid = OreSpawnMain.MyEndermanSpawnBlock;
                        }
                        if (which == 3) {
                            bid = OreSpawnMain.MyEnderDragonSpawnBlock;
                        }
                    }
                    if (j == 7 && bid == Blocks.bedrock && (i + k & 0x1) != 0x0) {
                        bid = OreSpawnMain.MyEyeOfEnderBlock;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        for (int i = -1; i <= width + 1; ++i) {
            for (int k = -1; k <= width + 1; ++k) {
                for (int j = 1; j <= height - 1; ++j) {
                    bid = Blocks.air;
                    if (j == 6 || j > 8) {
                        if (i == -1 || i == width + 1 || (k == width + 1 | k == -1)) {
                            bid = Blocks.bedrock;
                        }
                        if (j == 6 && bid != Blocks.air && world.rand.nextInt(2) == 1) {
                            OreSpawnMain.setBlockFast(
                                world,
                                cposx + i,
                                cposy + j - 1,
                                cposz + k,
                                OreSpawnMain.MyEnderPearlBlock,
                                0,
                                2);
                            if (world.rand.nextInt(3) == 1) {
                                OreSpawnMain.setBlockFast(
                                    world,
                                    cposx + i,
                                    cposy + j - 2,
                                    cposz + k,
                                    OreSpawnMain.MyEnderPearlBlock,
                                    0,
                                    2);
                            }
                        }
                    }
                    if (j == 7) {
                        if (i == -1 || i == width + 1 || (k == width + 1 | k == -1)) {
                            bid = Blocks.bedrock;
                        }
                        if (bid == Blocks.bedrock && (i + k & 0x1) == 0x0) {
                            bid = Blocks.air;
                        }
                    }
                    if (bid != Blocks.air) {
                        OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                    }
                }
            }
        }
        this.makeAColumn(world, cposx - 2, cposy, cposz - 2, height + 1, 0);
        this.makeAColumn(world, cposx + width - 2, cposy, cposz - 2, height + 1, 1);
        this.makeAColumn(world, cposx - 2, cposy, cposz + width - 2, height + 1, 2);
        this.makeAColumn(world, cposx + width - 2, cposy, cposz + width - 2, height + 1, 3);
        int j = 8;
        for (int i = 1; i <= width - 1; ++i) {
            for (int k = 1; k <= width - 1; ++k) {
                bid = Blocks.obsidian;
                if (i == width / 2 || k == width / 2 || i == k || i == width - k) {
                    bid = Blocks.bedrock;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        j = 9;
        for (int i = -2; i <= 2; ++i) {
            for (int k = -2; k <= 2; ++k) {
                bid = Blocks.lava;
                OreSpawnMain.setBlockFast(world, cposx + i + width / 2, cposy + j, cposz + k + width / 2, bid, 0, 2);
            }
        }
        for (int m = -1; m <= 1; ++m) {
            OreSpawnMain
                .setBlockFast(world, cposx + width / 2 + m, cposy + j, cposz + width / 2 + 3, Blocks.bedrock, 0, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + width / 2 + m, cposy + j, cposz + width / 2 - 3, Blocks.bedrock, 0, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + width / 2 + 3, cposy + j, cposz + width / 2 + m, Blocks.bedrock, 0, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + width / 2 - 3, cposy + j, cposz + width / 2 + m, Blocks.bedrock, 0, 2);
        }
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + j, cposz + width / 2 - 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy + j, cposz + width / 2 + 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + j, cposz + width / 2 + 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy + j, cposz + width / 2 - 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j, cposz + width / 2, Blocks.bedrock, 0, 2);
        world.setBlock(cposx + width / 2, cposy + j + 1, cposz + width / 2, Blocks.ender_chest, 2, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 2, cposz + width / 2, Blocks.obsidian, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 3, cposz + width / 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + j + 3, cposz + width / 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + j + 3, cposz + width / 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 3, cposz + width / 2 - 1, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 3, cposz + width / 2 + 1, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + j + 4, cposz + width / 2, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + j + 4, cposz + width / 2, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 4, cposz + width / 2 - 1, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 4, cposz + width / 2 + 1, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 4, cposz + width / 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 5, cposz + width / 2, Blocks.bedrock, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + j + 6, cposz + width / 2, Blocks.dragon_egg, 0, 2);
        world.setBlock(cposx + width / 2 + 5, cposy + j, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j, cposz + width / 2 + 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        world.setBlock(cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 + 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Knight");
        }
        world.setBlock(cposx + width / 2 - 5, cposy + j, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j, cposz + width / 2 + 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        world.setBlock(cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 + 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 + 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Knight");
        }
        world.setBlock(cposx + width / 2 + 5, cposy + j, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j, cposz + width / 2 - 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        world.setBlock(cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 + 5, cposy + j + 1, cposz + width / 2 - 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Knight");
        }
        world.setBlock(cposx + width / 2 - 5, cposy + j, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j, cposz + width / 2 - 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        world.setBlock(cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 - 5, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 - 5, cposy + j + 1, cposz + width / 2 - 5);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Knight");
        }
        j = 4;
        for (int i = 1; i <= width - 1; ++i) {
            for (int k = 1; k <= width - 1; ++k) {
                bid = Blocks.air;
                if (i <= 5 || k <= 5 || i >= width - 5 || k >= width - 5) {
                    bid = Blocks.bedrock;
                }
                if (bid != Blocks.air) {
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
                if (i == 5 && k >= 5 && k <= width - 5) {
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + k, Blocks.iron_bars, 0, 2);
                }
                if (i == width - 5 && k >= 5 && k <= width - 5) {
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + k, Blocks.iron_bars, 0, 2);
                }
                if (k == 5 && i >= 5 && i <= width - 5) {
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + k, Blocks.iron_bars, 0, 2);
                }
                if (k == width - 5 && i >= 5 && i <= width - 5) {
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.iron_bars, 0, 2);
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + k, Blocks.iron_bars, 0, 2);
                }
            }
        }
        bid = Blocks.bedrock;
        j = 3;
        int k = width / 2;
        int i = width - 6;
        for (int m = -1; m <= 1; ++m) {
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k + m, bid, 0, 2);
        }
        j = 2;
        k = width / 2;
        i = width - 7;
        for (int m = -1; m <= 1; ++m) {
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k + m, bid, 0, 2);
        }
        j = 1;
        k = width / 2;
        i = width - 8;
        for (int m = -1; m <= 1; ++m) {
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k + m, bid, 0, 2);
        }
        j = 4;
        i = width - 5;
        for (int m = -1; m <= 1; ++m) {
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 1, cposz + k + m, Blocks.air, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 2, cposz + k + m, Blocks.air, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + 3, cposz + k + m, Blocks.air, 0, 2);
        }
        j = 1;
        world.setBlock(cposx + width / 2, cposy + j, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + j, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Reaper");
        }
        world.setBlock(cposx + width / 2, cposy + j + 1, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + j + 1, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ender Knight");
        }
        j = 5;
        world.setBlock(cposx + 1, cposy + j, cposz + width / 2 - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + j, cposz + width / 2 - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("CaveFisher");
        }
        world.setBlock(cposx + 1, cposy + j, cposz + width / 2 + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + j, cposz + width / 2 + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("CaveFisher");
        }
        world.setBlock(cposx + 1, cposy + j, cposz + width / 2, (Block) Blocks.chest, 2, 2);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + j, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(5));
        }
        world.setBlock(cposx + width / 2 - 1, cposy + j, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + j, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("CaveFisher");
        }
        world.setBlock(cposx + width / 2 + 1, cposy + j, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + j, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("CaveFisher");
        }
        world.setBlock(cposx + width / 2, cposy + j, cposz + 1, (Block) Blocks.chest, 3, 2);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(5));
        }
        world.setBlock(cposx + width / 2 - 1, cposy + j, cposz + width - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + j, cposz + width - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("CaveFisher");
        }
        world.setBlock(cposx + width / 2 + 1, cposy + j, cposz + width - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + j, cposz + width - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("CaveFisher");
        }
        world.setBlock(cposx + width / 2, cposy + j, cposz + width - 1, (Block) Blocks.chest, 4, 2);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + j, cposz + width - 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(5));
        }
    }

    private void makeAColumn(final World world, final int cposx, final int cposy, final int cposz, final int height,
        final int dir) {
        final int width = 4;
        final int halfwidth = 2;
        int step = dir;
        for (int i = -2; i <= width + 2; ++i) {
            for (int k = -2; k <= width + 2; ++k) {
                final int j = height + 2;
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.obsidian, 0, 2);
            }
        }
        for (int i = -2; i <= width + 2; ++i) {
            for (int k = -2; k <= width + 2; ++k) {
                Block bid = Blocks.air;
                if (i == -2 || i == width + 2 || (k == width + 2 | k == -2)) {
                    bid = Blocks.obsidian;
                }
                final int j = height + 3;
                if (bid != Blocks.air && (i + k & 0x1) == 0x0) {
                    bid = Blocks.air;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        int i;
        for (i = 0; i <= width; ++i) {
            for (int k = 0; k <= width; ++k) {
                for (int j = 1; j <= height + 2; ++j) {
                    Block bid = Blocks.air;
                    if (i == 0 || i == width || (k == width | k == 0)) {
                        bid = Blocks.obsidian;
                    }
                    if ((j % 3 == 0 || j % 3 == 1) && j != height + 2
                        && bid == Blocks.obsidian
                        && (i == halfwidth || k == halfwidth)) {
                        bid = Blocks.iron_bars;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        if (dir == 0) {
            for (int j = 1; j <= 2; ++j) {
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz + width - 1, Blocks.air, 0, 2);
            }
            for (int j = 9; j <= 10; ++j) {
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz + width - 1, Blocks.air, 0, 2);
            }
        }
        if (dir == 1) {
            for (int j = 1; j <= 2; ++j) {
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz + width - 1, Blocks.air, 0, 2);
            }
            for (int j = 9; j <= 10; ++j) {
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz + width, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz + width - 1, Blocks.air, 0, 2);
            }
            if (++step > 3) {
                step = 0;
            }
        }
        if (dir == 2) {
            for (int j = 1; j <= 2; ++j) {
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz + 1, Blocks.air, 0, 2);
            }
            for (int j = 9; j <= 10; ++j) {
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width - 1, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + width, cposy + j, cposz + 1, Blocks.air, 0, 2);
            }
            if (++step > 3) {
                step = 0;
            }
            if (++step > 3) {
                step = 0;
            }
        }
        if (dir == 3) {
            for (int j = 1; j <= 2; ++j) {
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz + 1, Blocks.air, 0, 2);
            }
            for (int j = 9; j <= 10; ++j) {
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx + 1, cposy + j, cposz, Blocks.air, 0, 2);
                OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz + 1, Blocks.air, 0, 2);
            }
            if (++step > 3) {
                step = 0;
            }
            if (++step > 3) {
                step = 0;
            }
        }
        Block bid = Blocks.nether_brick;
        int k = 0;
        for (int j = 1; j <= height + 2; ++j) {
            if (step == 0) {
                k = (i = 1);
            }
            if (step == 1) {
                i = 1;
                k = 3;
            }
            if (step == 2) {
                i = 3;
                k = 3;
            }
            if (step == 3) {
                i = 3;
                k = 1;
            }
            if (++step > 3) {
                step = 0;
            }
            OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
        }
    }

    public void makeDamselInDistress(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        int meta = 0;
        int stuffdir = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.DamselContentsList;
        final int width;
        final int length = width = 4;
        final int height = 5;
        stuffdir = 2;
        if (world.isRemote) {
            return;
        }
        for (int i = -width; i <= width; ++i) {
            for (int j = -length; j <= length; ++j) {
                for (int k = 0; k < height; ++k) {
                    bid = Blocks.air;
                    meta = 0;
                    if (k == 0) {
                        bid = Blocks.cobblestone;
                    }
                    if (i == -width || i == width) {
                        bid = Blocks.cobblestone;
                    }
                    if (j == -length || j == length) {
                        bid = Blocks.cobblestone;
                    }
                    if (bid == Blocks.cobblestone && world.rand.nextInt(8) == 1) {
                        bid = Blocks.mossy_cobblestone;
                    }
                    if ((k == 1 || k == 2 || k == 3) && (i == 0 || i == -1 || i == 1) && j == -length) {
                        meta = 0;
                        bid = Blocks.air;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
                }
            }
        }
        meta = 0;
        for (int i = -width + 1; i <= width - 1; ++i) {
            for (int j = -length; j <= length - 1; ++j) {
                final int k = height;
                bid = Blocks.cobblestone;
                if (world.rand.nextInt(8) == 1) {
                    bid = Blocks.mossy_cobblestone;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
            }
        }
        for (int i = -width + 2; i <= width - 2; ++i) {
            for (int j = -length; j <= length - 2; ++j) {
                final int k = height + 1;
                bid = Blocks.cobblestone;
                if (world.rand.nextInt(8) == 1) {
                    bid = Blocks.mossy_cobblestone;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
            }
        }
        int k = height;
        int j = -length;
        for (int m = width; m >= 0; --m) {
            for (int i = m; i >= 0; --i) {
                bid = Blocks.cobblestone;
                if (world.rand.nextInt(8) == 1) {
                    bid = Blocks.mossy_cobblestone;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + k, cposz + j, bid, meta, 2);
                bid = Blocks.cobblestone;
                if (world.rand.nextInt(8) == 1) {
                    bid = Blocks.mossy_cobblestone;
                }
                OreSpawnMain.setBlockFast(world, cposx - i, cposy + k, cposz + j, bid, meta, 2);
            }
            ++k;
        }
        for (int i = -width + 1; i < width; ++i) {
            for (j = 1; j < height; ++j) {
                k = length - 3;
                OreSpawnMain.setBlockFast(world, cposx - i, cposy + j, cposz + k, Blocks.iron_bars, 0, 2);
            }
        }
        world.setBlock(cposx - width + 1, cposy + 1, cposz - length + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - width + 1, cposy + 1, cposz - length + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Scorpion");
        }
        world.setBlock(cposx + width - 1, cposy + 1, cposz - length + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width - 1, cposy + 1, cposz - length + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Scorpion");
        }
        world.setBlock(cposx + width - 1, cposy + 1, cposz + length - 1, (Block) Blocks.chest, 2, 2);
        chest = this.getChestTileEntity(world, cposx + width - 1, cposy + 1, cposz + length - 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 10 + world.rand.nextInt(5));
        }
        Entity var8 = null;
        var8 = EntityList.createEntityByName("Girlfriend", world);
        if (var8 != null) {
            var8.setLocationAndAngles(
                (double) (cposx - width + 2),
                (double) (cposy + 1),
                (double) (cposz + length - 1),
                world.rand.nextFloat() * 360.0f,
                0.0f);
            world.spawnEntityInWorld(var8);
        }
    }

    public void makeIncaPyramid(final World world, int cposx, int cposy, int cposz) {
        Block bid = Blocks.air;
        int meta = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        final TileEntityChest chest = null;
        final WeightedRandomChestContent[] chestContents = null;
        final int width = 21;
        final int depth = 11;
        final int height = 9;
        final int basewidth = 41;
        final int basedepth = 31;
        final int baseheight = 10;
        if (world.isRemote) {
            return;
        }
        for (int j = 0; j < baseheight; ++j) {
            for (int i = 0; i < basewidth - j * 2; ++i) {
                for (int k = 0; k < basedepth - j * 2; ++k) {
                    meta = 0;
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == basewidth - j * 2 - 1 || k == basedepth - j * 2 - 1) {
                        bid = Blocks.stone;
                        if (world.rand.nextInt(2) == 0) {
                            bid = Blocks.cobblestone;
                        }
                        if (world.rand.nextInt(4) == 0) {
                            bid = Blocks.mossy_cobblestone;
                        }
                    }
                    if (j == 0) {
                        bid = Blocks.stonebrick;
                    }
                    if (k == 1 && j % 3 == 2 && i != 0 && i != basewidth - j * 2 - 1) {
                        bid = Blocks.torch;
                        meta = 3;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i + j, cposy + j, cposz + k + j, bid, meta, 2);
                    if (k == basedepth - j * 2 - 1 && j % 3 == 2 && i != 0 && i != basewidth - j * 2 - 1) {
                        meta = 4;
                        OreSpawnMain
                            .setBlockFast(world, cposx + i + j, cposy + j, cposz + k + j - 1, Blocks.torch, meta, 2);
                    }
                }
            }
        }
        meta = 0;
        for (int m = 0; m < baseheight * 2 - 1; ++m) {
            final int i = -baseheight + m;
            for (int p = -2; p <= 2; ++p) {
                int k = basedepth / 2;
                k += p;
                int j = m / 2;
                if (p < -1 || p > 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain
                            .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.stonebrick, meta, 2);
                        if (m == 0 || m == baseheight * 2 - 2) {
                            OreSpawnMain
                                .setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.torch, meta, 2);
                        }
                    }
                } else if (m % 2 == 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k,
                            (Block) Blocks.stone_slab,
                            meta,
                            2);
                    }
                }
                while (j >= 0) {
                    bid = world.getBlock(cposx + i, cposy + j, cposz + k);
                    if (bid != Blocks.air) {
                        break;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.stone, meta, 2);
                    --j;
                }
            }
        }
        meta = 0;
        for (int m = 0; m < baseheight * 2 - 1; ++m) {
            final int i = basewidth + baseheight - m - 1;
            for (int p = -2; p <= 2; ++p) {
                int k = basedepth / 2;
                k += p;
                int j = m / 2;
                if (p < -1 || p > 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain
                            .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.stonebrick, meta, 2);
                        if (m == 0 || m == baseheight * 2 - 2) {
                            OreSpawnMain
                                .setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.torch, meta, 2);
                        }
                    }
                } else if (m % 2 == 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k,
                            (Block) Blocks.stone_slab,
                            meta,
                            2);
                    }
                }
                while (j >= 0) {
                    bid = world.getBlock(cposx + i, cposy + j, cposz + k);
                    if (bid != Blocks.air) {
                        break;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.stone, meta, 2);
                    --j;
                }
            }
        }
        meta = 0;
        for (int m = 0; m < baseheight * 2 - 1; ++m) {
            final int k = -baseheight + m;
            for (int p = -2; p <= 2; ++p) {
                int i = basewidth / 2;
                i += p;
                int j = m / 2;
                if (p < -1 || p > 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain
                            .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.stonebrick, meta, 2);
                        if (m == 0 || m == baseheight * 2 - 2) {
                            OreSpawnMain
                                .setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.torch, meta, 2);
                        }
                    }
                } else if (m % 2 == 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k,
                            (Block) Blocks.stone_slab,
                            meta,
                            2);
                    }
                }
                while (j >= 0) {
                    bid = world.getBlock(cposx + i, cposy + j, cposz + k);
                    if (bid != Blocks.air) {
                        break;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.stone, meta, 2);
                    --j;
                }
            }
        }
        meta = 0;
        for (int m = 0; m < baseheight * 2 - 1; ++m) {
            final int k = basedepth + baseheight - m - 1;
            for (int p = -2; p <= 2; ++p) {
                int i = basewidth / 2;
                i += p;
                int j = m / 2;
                if (p < -1 || p > 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain
                            .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, Blocks.stonebrick, meta, 2);
                        if (m == 0 || m == baseheight * 2 - 2) {
                            OreSpawnMain
                                .setBlockFast(world, cposx + i, cposy + j + 2, cposz + k, Blocks.torch, meta, 2);
                        }
                    }
                } else if (m % 2 == 1) {
                    bid = world.getBlock(cposx + i, cposy + j + 1, cposz + k);
                    if (bid == Blocks.air) {
                        OreSpawnMain.setBlockFast(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k,
                            (Block) Blocks.stone_slab,
                            meta,
                            2);
                    }
                }
                while (j >= 0) {
                    bid = world.getBlock(cposx + i, cposy + j, cposz + k);
                    if (bid != Blocks.air) {
                        break;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, Blocks.stone, meta, 2);
                    --j;
                }
            }
        }
        cposx += baseheight;
        cposy += baseheight;
        cposz += baseheight;
        for (int j = 0; j < height; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < depth; ++k) {
                    bid = Blocks.air;
                    meta = 0;
                    if (i == 0 || k == 0 || i == width - 1 || k == depth - 1) {
                        bid = Blocks.stone;
                        if (world.rand.nextInt(2) == 0) {
                            bid = Blocks.cobblestone;
                        }
                        if (world.rand.nextInt(4) == 0) {
                            bid = Blocks.mossy_cobblestone;
                        }
                    }
                    if (j == 0 || j == height - 1) {
                        bid = Blocks.stonebrick;
                    }
                    if (j == 1 || j == 2 || j == 3) {
                        if ((k == 0 || k == depth - 1) && i >= width / 2 - 1 && i <= width / 2 + 1) {
                            if (j == 3) {
                                bid = Blocks.fence;
                            } else {
                                bid = Blocks.air;
                            }
                        }
                        if ((i == 0 || i == width - 1) && k >= depth / 2 - 1 && k <= depth / 2 + 1) {
                            if (j == 3) {
                                bid = Blocks.fence;
                            } else {
                                bid = Blocks.air;
                            }
                        }
                    }
                    if ((j == height - 3 || j == height - 2) && (i + k) % 2 == 1) {
                        if (j == height - 3) {
                            if (bid != Blocks.air) {
                                bid = Blocks.lit_redstone_lamp;
                            }
                        } else {
                            bid = Blocks.air;
                        }
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
                }
            }
        }
        bid = (Block) Blocks.stone_slab;
        meta = 0;
        int j = height;
        for (int i = -1; i <= width; ++i) {
            for (int k = -1; k <= depth; ++k) {
                if ((i == -1 || k == -1 || i == width || k == depth) && (i + k & 0x1) == 0x1) {
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
                }
            }
        }
        this.makepoolalter(world, cposx + 1, cposy, cposz + 1);
        this.makepoolalter(world, cposx + width - 2, cposy, cposz + depth - 2);
        this.makepoolalter(world, cposx + 1, cposy, cposz + depth - 2);
        this.makepoolalter(world, cposx + width - 2, cposy, cposz + 1);
        this.makepoolalter(world, cposx + width / 2, cposy, cposz + depth / 2);
        world.setBlock(cposx + width / 2 - 1, cposy + 2, cposz + depth / 2 - 1, OreSpawnMain.CreeperRepellent, 0, 2);
        world.setBlock(cposx + width / 2 + 1, cposy + 2, cposz + depth / 2 + 1, OreSpawnMain.CreeperRepellent, 0, 2);
        world.setBlock(cposx + width / 2 - 1, cposy + 2, cposz + depth / 2 + 1, OreSpawnMain.CreeperRepellent, 0, 2);
        world.setBlock(cposx + width / 2 + 1, cposy + 2, cposz + depth / 2 - 1, OreSpawnMain.CreeperRepellent, 0, 2);
        world.setBlock(cposx + width / 2 - 2, cposy + 1, cposz + depth / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2 - 2, cposy + 1, cposz + depth / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Molenoid");
        }
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy + 1, cposz + depth / 2, Blocks.trapdoor, 3, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 2, cposy, cposz + depth / 2, Blocks.air, 0, 2);
        int i = cposx + width / 2 + 2;
        int k = cposz + depth / 2;
        for (j = 1; j < baseheight; ++j) {
            OreSpawnMain.setBlockFast(world, i, cposy - j, k + 1, Blocks.cobblestone, 0, 2);
            OreSpawnMain.setBlockFast(world, i, cposy - j, k, Blocks.ladder, 2, 2);
        }
        this.makeincagraves(world, cposx - baseheight, cposy - baseheight, cposz - baseheight, basewidth, basedepth);
    }

    private void makepoolalter(final World world, final int cposx, final int cposy, final int cposz) {
        for (int i = -1; i <= 1; ++i) {
            for (int k = -1; k <= 1; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + 1, cposz + k, Blocks.cobblestone, 0, 2);
            }
        }
        OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz, Blocks.water, 0, 2);
    }

    private void makeincagraves(final World world, final int cposx, final int cposy, final int cposz, final int width,
        final int depth) {
        for (int i = 5; i < width - 5; i += 6) {
            this.makeincagrave(world, cposx + i, cposy, cposz + 5, 1);
        }
        for (int i = 5; i < width - 5; i += 6) {
            this.makeincagrave(world, cposx + i, cposy, cposz + 10, 1);
        }
        for (int i = 5; i < width - 5; i += 6) {
            this.makeincagrave(world, cposx + i, cposy, cposz + 20, 3);
        }
        for (int i = 5; i < width - 5; i += 6) {
            this.makeincagrave(world, cposx + i, cposy, cposz + 25, 3);
        }
    }

    private void makeincagrave(final World world, final int cposx, final int cposy, final int cposz, final int dir) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.IncaPyramidContentsList;
        if (dir == 1) {
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz + 1, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz + 1, (Block) Blocks.yellow_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz + 2, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz + 2, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz + 1, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 1, (Block) Blocks.yellow_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz + 2, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 2, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz, Blocks.stone, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz + 1, (Block) Blocks.stone_slab, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz + 2, (Block) Blocks.stone_slab, 0, 2);
            if (world.rand.nextInt(3) == 1) {
                world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
                tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Ghost");
                }
            }
            world.setBlock(cposx, cposy + 1, cposz - 1, (Block) Blocks.chest, 2, 2);
            chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 10 + world.rand.nextInt(5));
            }
        }
        if (dir == 3) {
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz - 1, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz - 1, (Block) Blocks.yellow_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy, cposz - 2, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx - 1, cposy + 1, cposz - 2, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz - 1, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz - 1, (Block) Blocks.yellow_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy, cposz - 2, (Block) Blocks.grass, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz - 2, (Block) Blocks.red_flower, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz, Blocks.stone, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz - 1, (Block) Blocks.stone_slab, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz - 2, (Block) Blocks.stone_slab, 0, 2);
            if (world.rand.nextInt(3) == 1) {
                world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
                tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Ghost");
                }
            }
            world.setBlock(cposx, cposy + 1, cposz + 1, (Block) Blocks.chest, 2, 2);
            chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz + 1);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 10 + world.rand.nextInt(5));
            }
        }
    }

    public void makeRobotLab(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int meta = 0;
        final int width = 10;
        final int length = 20;
        final int height = 5;
        if (world.isRemote) {
            return;
        }
        for (int j = 0; j <= height; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < length; ++k) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                        bid = Blocks.quartz_block;
                    }
                    if (j == 0) {
                        bid = Blocks.quartz_block;
                        if (i == width / 2 || i == width / 2 - 1) {
                            bid = Blocks.iron_block;
                        }
                    }
                    if (j == height) {
                        bid = Blocks.quartz_block;
                        if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                            bid = Blocks.air;
                        }
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 1, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 2, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 1, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 2, cposz, Blocks.air, 0, 2);
        ItemDoor.placeDoorBlock(world, cposx + width / 2, cposy + 1, cposz, 3, Blocks.iron_door);
        ItemDoor.placeDoorBlock(world, cposx + width / 2 - 1, cposy + 1, cposz, 3, Blocks.iron_door);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
        this.makerobomain(world, cposx, cposy, cposz + length - 1);
        this.makerobopillar(world, cposx, cposy, cposz + length / 3, 0);
        this.makerobopillar(world, cposx, cposy, cposz + length * 2 / 3, 0);
        this.makerobopillar(world, cposx, cposy, cposz + (length - 1), 0);
        this.makerobopillar(world, cposx + width - 1, cposy, cposz + length / 3, 1);
        this.makerobopillar(world, cposx + width - 1, cposy, cposz + length * 2 / 3, 1);
        this.makerobopillar(world, cposx + width - 1, cposy, cposz + (length - 1), 1);
    }

    private void makerobopillar(final World world, final int cposx, final int cposy, final int cposz, final int dir) {
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j < 5; ++j) {
            for (int i = -1; i < 2; ++i) {
                for (int k = -1; k < 2; ++k) {
                    Block bid = Blocks.quartz_block;
                    if (j == 2 || j == 3) {
                        if (k == 0 && (i == -1 || i == 1)) {
                            bid = Blocks.redstone_block;
                        }
                        if (i == 0 && (k == -1 || k == 1)) {
                            bid = Blocks.redstone_block;
                        }
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        if (dir == 0) {
            world.setBlock(cposx + 1, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 1, cposz);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Robo-Sniper");
            }
        }
        if (dir == 1) {
            world.setBlock(cposx - 1, cposy + 1, cposz, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 1, cposz);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Robo-Sniper");
            }
        }
    }

    public void makerobomain(final World world, int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int width = 30;
        final int length = 30;
        final int height = 9;
        cposx -= 10;
        for (int j = 0; j <= height; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < length; ++k) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                        bid = Blocks.quartz_block;
                    }
                    if (j == 0) {
                        bid = Blocks.quartz_block;
                        if (i == width / 2 || i == width / 2 - 1) {
                            bid = Blocks.iron_block;
                        }
                    }
                    if (j == height) {
                        bid = Blocks.quartz_block;
                        if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                            bid = Blocks.air;
                        }
                    }
                    if ((j == 1 || j == 2 || j == 3) && k == 0 && i >= width / 3 && i < width * 2 / 3) {
                        bid = Blocks.air;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        this.makeroboaltar(world, cposx + width / 2 - 4, cposy, cposz + 6);
        this.makeroborailway(world, cposx + 3, cposy, cposz + 10);
        this.makeroboassemblyline(world, cposx + width - 4, cposy, cposz + 4);
        this.makerobotreasureroom(world, cposx + 9, cposy, cposz + 18);
        this.makerobotower(world, cposx + width / 2 - 6, cposy + height, cposz + length / 2 - 6);
    }

    public void makerobotower(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        for (int j = 0; j < 2; ++j) {
            for (int i = 0; i < 12; ++i) {
                for (int k = 0; k < 12; ++k) {
                    bid = Blocks.air;
                    if (j == 1) {
                        if (i == 0 || k == 0 || i == 11 || k == 11) {
                            bid = Blocks.iron_bars;
                        }
                        if (i == 0 && (k == 0 || k == 11)) {
                            bid = Blocks.redstone_block;
                        }
                        if (i == 11 && (k == 0 || k == 11)) {
                            bid = Blocks.redstone_block;
                        }
                    }
                    if (j == 0) {
                        bid = Blocks.quartz_block;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        this.makerobopillar(world, cposx + 4, cposy + 1, cposz + 4, 1);
        this.makerobopillar(world, cposx + 7, cposy + 1, cposz + 7, 0);
        this.makerobopillar(world, cposx + 4, cposy + 1, cposz + 7, 1);
        this.makerobopillar(world, cposx + 7, cposy + 1, cposz + 4, 0);
        for (int j = 5; j < 35; ++j) {
            for (int i = 0; i < 2; ++i) {
                for (int k = 0; k < 3; ++k) {
                    bid = Blocks.air;
                    if (j < 15) {
                        bid = Blocks.quartz_block;
                    } else if (j < 25) {
                        bid = Blocks.quartz_block;
                        if (k == 2) {
                            bid = Blocks.iron_bars;
                        }
                    } else {
                        bid = Blocks.quartz_block;
                        if (k == 1) {
                            bid = Blocks.iron_bars;
                        }
                        if (k == 2) {
                            bid = Blocks.air;
                        }
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k + 5, bid, 0, 2);
                }
            }
        }
    }

    public void makeroboaltar(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        TileEntityMobSpawner tileentitymobspawner = null;
        bid = Blocks.iron_block;
        for (int i = 0; i < 8; ++i) {
            for (int k = 0; k < 8; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy, cposz + k, bid, 0, 2);
            }
        }
        bid = Blocks.quartz_block;
        for (int i = 0; i < 6; ++i) {
            for (int k = 0; k < 6; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + 1, cposz + k + 1, bid, 0, 2);
            }
        }
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 2, Blocks.redstone_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 2, cposz + 2, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 1, cposz + 5, Blocks.redstone_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 2, cposz + 5, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 1, cposz + 2, Blocks.redstone_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 5, cposy + 2, cposz + 2, Blocks.torch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 5, Blocks.redstone_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 2, cposz + 5, Blocks.torch, 0, 2);
        world.setBlock(cposx + 3, cposy + 2, cposz + 3, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 3, cposy + 2, cposz + 3);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Robo-Pounder");
        }
        world.setBlock(cposx + 4, cposy + 2, cposz + 4, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 4, cposy + 2, cposz + 4);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Robo-Pounder");
        }
    }

    public void makeroborailway(final World world, final int cposx, final int cposy, final int cposz) {
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 0, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 0, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 1, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 1, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 2, Blocks.golden_rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 2, Blocks.lever, 5, 2);
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 2, Blocks.lever, 5, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 2, Blocks.golden_rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 3, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 3, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 4, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 4, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 5, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 5, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 6, Blocks.golden_rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 6, Blocks.lever, 5, 2);
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 6, Blocks.lever, 5, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 6, Blocks.golden_rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 7, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 7, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 8, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 8, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 9, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 9, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 10, Blocks.golden_rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + 10, Blocks.lever, 5, 2);
        OreSpawnMain.setBlockFast(world, cposx + 2, cposy + 1, cposz + 10, Blocks.lever, 5, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 10, Blocks.golden_rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 11, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 11, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 0, cposy + 1, cposz + 12, Blocks.rail, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 3, cposy + 1, cposz + 12, Blocks.rail, 0, 2);
    }

    public void makeroboassemblyline(final World world, final int cposx, final int cposy, final int cposz) {
        for (int k = 0; k < 24; ++k) {
            if (k % 3 == 1) {
                OreSpawnMain.setBlockFast(world, cposx - 2, cposy + 1, cposz + k, Blocks.quartz_stairs, 1, 2);
                OreSpawnMain.setBlockFast(world, cposx, cposy + 2, cposz + k, (Block) Blocks.sticky_piston, 3, 2);
                OreSpawnMain.setBlockFast(world, cposx, cposy + 3, cposz + k, Blocks.carpet, 0, 2);
            }
            if (k % 3 == 0) {
                OreSpawnMain.setBlockFast(world, cposx, cposy + 2, cposz + k, Blocks.lever, 13, 2);
            }
            OreSpawnMain.setBlockFast(world, cposx, cposy + 1, cposz + k, Blocks.quartz_block, 0, 2);
            OreSpawnMain.setBlockFast(world, cposx + 1, cposy + 1, cposz + k, Blocks.quartz_block, 0, 2);
        }
    }

    public void makerobotreasureroom(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        TileEntityMobSpawner tileentitymobspawner = null;
        chestContents = this.RobotContentsList;
        for (int j = 1; j < 7; ++j) {
            for (int i = 0; i < 12; ++i) {
                for (int k = 0; k < 8; ++k) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == 11 || k == 7) {
                        bid = Blocks.quartz_block;
                    }
                    if (j == 2 && i == 11) {
                        bid = Blocks.iron_bars;
                    }
                    if (j == 3 && bid != Blocks.air) {
                        bid = Blocks.iron_bars;
                    }
                    if ((j == 1 || j == 2 || j == 3) && k == 0 && (i == 1 || i == 2)) {
                        bid = Blocks.air;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        world.setBlock(cposx + 10, cposy + 1, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 10, cposy + 1, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Robo-Warrior");
        }
        world.setBlock(cposx + 8, cposy + 1, cposz + 1, (Block) Blocks.chest, 2, 2);
        chest = this.getChestTileEntity(world, cposx + 8, cposy + 1, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 10 + world.rand.nextInt(5));
        }
        world.setBlock(cposx + 6, cposy + 1, cposz + 1, (Block) Blocks.chest, 2, 2);
        chest = this.getChestTileEntity(world, cposx + 6, cposy + 1, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 10 + world.rand.nextInt(5));
        }
    }

    public void makeKingAltar(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int width = 51;
        final int length = 51;
        final int height = 48;
        if (world.isRemote) {
            return;
        }
        for (int j = 0; j <= height + 10; ++j) {
            for (int i = -5; i < width + 5; ++i) {
                for (int k = -5; k < length + 5; ++k) {
                    bid = Blocks.air;
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        int j = 0;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < length; ++k) {
                bid = (Block) Blocks.grass;
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                for (int v = 1; v < 10; ++v) {
                    bid = world.getBlock(cposx + i, cposy + j - v, cposz + k);
                    if (bid == Blocks.air || bid == Blocks.tallgrass || bid == Blocks.water) {
                        bid = Blocks.dirt;
                        OreSpawnMain.setBlockFast(world, cposx + i, cposy + j - v, cposz + k, bid, 0, 2);
                    }
                }
            }
        }
        this.makekingcolumn(world, cposx + 1, cposy + 1, cposz + 1);
        this.makekingcolumn(world, cposx + width - 8, cposy + 1, cposz + length - 8);
        this.makekingcolumn(world, cposx + 1, cposy + 1, cposz + length - 8);
        this.makekingcolumn(world, cposx + width - 8, cposy + 1, cposz + 1);
        j = height - 1;
        bid = Blocks.quartz_block;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        j = height;
        bid = Blocks.quartz_block;
        for (int i = -1; i <= width; ++i) {
            for (int k = -1; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        this.makekingbackground(world, cposx + 4, cposy + 10, cposz + 9);
        this.makekingcenteraltar(world, cposx + width / 2, cposy, cposz + length / 2);
    }

    private void makekingcolumn(final World world, int cposx, int cposy, int cposz) {
        Block bid = Blocks.air;
        int meta = 0;
        final int width = 5;
        final int length = 5;
        final int height = 44;
        if (world.isRemote) {
            return;
        }
        int j = 0;
        bid = Blocks.quartz_block;
        for (int i = 0; i < width + 2; ++i) {
            for (int k = 0; k < length + 2; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + height + 1, cposz + k, bid, meta, 2);
            }
        }
        ++cposx;
        ++cposz;
        ++cposy;
        for (j = 0; j < height; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < length; ++k) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                        bid = Blocks.quartz_block;
                    }
                    if (j % 4 == 0 && bid != Blocks.air && (i == 2 || k == 2)) {
                        bid = Blocks.gold_block;
                    }
                    if (j % 4 == 1 && bid != Blocks.air) {
                        if (i == 1 || k == 1) {
                            bid = Blocks.gold_block;
                        }
                        if (i == 3 || k == 3) {
                            bid = Blocks.gold_block;
                        }
                    }
                    if (j % 4 == 2 && bid != Blocks.air) {
                        if (i == 1 || k == 1) {
                            bid = Blocks.gold_block;
                        }
                        if (i == 3 || k == 3) {
                            bid = Blocks.gold_block;
                        }
                        if (i == 2 || k == 2) {
                            bid = Blocks.emerald_block;
                        }
                    }
                    if (j % 4 == 3 && bid != Blocks.air) {
                        if (i == 1 || k == 1) {
                            bid = Blocks.gold_block;
                        }
                        if (i == 3 || k == 3) {
                            bid = Blocks.gold_block;
                        }
                    }
                    meta = 0;
                    if (bid == Blocks.quartz_block) {
                        meta = 2;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
                }
            }
        }
    }

    private void makekingbackground(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int meta = 0;
        int curz = 0;
        int cury = 0;
        final int height = 33;
        final int width = 33;
        bid = Blocks.stone;
        for (int m = 0; m < this.king.length; ++m) {
            final int v = this.king[m];
            if (v < 0) {
                bid = Blocks.stone;
                while (curz < width) {
                    OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
                    ++curz;
                }
                ++cury;
                curz = 0;
            } else {
                for (int n = 0; n < v; ++n) {
                    OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
                    ++curz;
                }
                if (bid == Blocks.stone) {
                    bid = Blocks.quartz_block;
                } else {
                    bid = Blocks.stone;
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + i, Blocks.gold_block, 0, 2);
        }
        for (int i = 0; i < width; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy + height, cposz + i, Blocks.gold_block, 0, 2);
        }
        for (int i = -1; i <= height; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz - 1, Blocks.gold_block, 0, 2);
        }
        for (int i = -1; i <= height; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz + width, Blocks.gold_block, 0, 2);
        }
        OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz - 2, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz + width + 1, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz + width + 1, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz - 2, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
    }

    private void makekingcenteraltar(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int meta = 0;
        int width = 10;
        int length = 10;
        int j = 0;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 6;
        length = 20;
        j = 0;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 20;
        length = 6;
        j = 0;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 8;
        length = 8;
        j = 1;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                bid = Blocks.quartz_block;
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 4;
        length = 18;
        j = 1;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                bid = Blocks.quartz_block;
                if (i == width && (k == -length || k == length)) {
                    bid = Blocks.lapis_block;
                }
                if (i == -width && (k == -length || k == length)) {
                    bid = Blocks.lapis_block;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 18;
        length = 4;
        j = 1;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                bid = Blocks.quartz_block;
                if (i == width && (k == -length || k == length)) {
                    bid = Blocks.lapis_block;
                }
                if (i == -width && (k == -length || k == length)) {
                    bid = Blocks.lapis_block;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 7;
        length = 7;
        j = 2;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                if (i == width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
                if (i == -width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
            }
        }
        width = 3;
        length = 17;
        j = 2;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 17;
        length = 3;
        j = 2;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 6;
        length = 6;
        j = 3;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 2;
        length = 16;
        j = 3;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 16;
        length = 2;
        j = 3;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 2;
        length = 2;
        j = 4;
        bid = Blocks.quartz_block;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                if (i == width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
                if (i == -width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
            }
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest);
        world.setBlockMetadataWithNotify(cposx, cposy + j, cposz, 2, 3);
        final TileEntityChest chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            chest.setInventorySlotContents(13, new ItemStack(OreSpawnMain.TheKingEgg));
        }
    }

    public void makeLeonNest(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int rad = 10;
        int dist = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j <= rad; ++j) {
            for (int i = -rad; i <= rad; ++i) {
                for (int k = -rad; k <= rad; ++k) {
                    bid = Blocks.air;
                    dist = j * j + i * i + k * k;
                    dist = (int) Math.sqrt(dist);
                    if (dist <= rad) {
                        if (dist >= rad - 2) {
                            final int which = world.rand.nextInt(6);
                            if (which == 0) {
                                bid = (Block) Blocks.leaves;
                            }
                            if (which == 1) {
                                bid = Blocks.log;
                            }
                            if (which == 2) {
                                bid = Blocks.planks;
                            }
                            if (which == 3) {
                                bid = Blocks.dirt;
                            }
                            if (which == 4) {
                                bid = Blocks.cobblestone;
                            }
                            if (which == 5) {
                                bid = Blocks.mossy_cobblestone;
                            }
                        }
                        OreSpawnMain.setBlockFast(world, cposx + i, cposy - j, cposz + k, bid, 0, 2);
                    }
                }
            }
        }
        for (int j = 1; j <= 5; ++j) {
            for (int i = -rad; i <= rad; ++i) {
                for (int k = -rad; k <= rad; ++k) {
                    bid = Blocks.air;
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        world.setBlock(cposx, cposy - (rad - 4), cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy - (rad - 4), cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Leonopteryx");
        }
    }

    public void makeCephadromeAltar(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        int j = 0;

        // Base layer
        for (int i = -3; i <= 3; ++i) {
            for (int k = -3; k <= 3; ++k) {
                bid = Blocks.cobblestone;
                if (k == 0 || i == 0) {
                    bid = Blocks.stonebrick;
                }
                if ((k == -3 || k == 3) && (i == -3 || i == 3)) {
                    bid = Blocks.stonebrick;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }

        // Upper layers
        for (int layer = 1; layer <= 4; ++layer) {
            j = layer;
            int width = 3 - layer;
            int length = 3 - layer;

            for (int i = -width; i <= width; ++i) {
                for (int k = -length; k <= length; ++k) {
                    bid = Blocks.air;
                    if ((k == -length || k == length) && (i == -width || i == width)) {
                        if (layer == 4) {
                            bid = OreSpawnMain.ExtremeTorch;
                        } else {
                            bid = Blocks.end_stone;
                        }
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }

        // Eye of Ender
        j = 3;
        OreSpawnMain.setBlockFast(world, cposx, cposy + j, cposz, OreSpawnMain.MyEyeOfEnderBlock, 0, 2);
    }

    public void makeCrystalBattleTower(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        float radius = 10.0f;
        for (int j = 0; j <= 20; ++j) {
            Block blk = OreSpawnMain.CrystalStone;
            if (j % 5 == 0) {
                for (float currad = 0.0f; currad < radius; currad += 0.33f) {
                    for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
                        final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
                        final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
                        this.FastSetBlock(
                            world,
                            (int) (cposx + curx + 0.5f),
                            cposy + j,
                            (int) (cposz + curz + 0.5f),
                            blk);
                    }
                }
            } else {
                final float currad = 10.0f;
                for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
                    final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
                    final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
                    blk = OreSpawnMain.CrystalStone;
                    if (j % 5 >= 1 && j % 5 <= 3 && (curdeg < 10.0f || curdeg > 350.0f)) {
                        blk = Blocks.air;
                    }
                    this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + j, (int) (cposz + curz + 0.5f), blk);
                }
            }
        }
        radius = 10.0f;
        for (int j = 21; j <= 22; ++j) {
            final Block blk = OreSpawnMain.CrystalCrystal;
            final float currad = 10.0f;
            for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
                final float curx = (float) (currad * Math.cos(Math.toRadians(curdeg)));
                final float curz = (float) (currad * Math.sin(Math.toRadians(curdeg)));
                this.FastSetBlock(world, (int) (cposx + curx + 0.5f), cposy + j, (int) (cposz + curz + 0.5f), blk);
            }
        }
        int j = 1;
        chestContents = this.CrystalBattleTowerRatContentsList;
        world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rat");
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(5));
        }
        j = 6;
        chestContents = this.CrystalBattleTowerDungeonBeastContentsList;
        world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Dungeon Beast");
        }
        world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Dungeon Beast");
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(5));
        }
        j = 11;
        chestContents = this.CrystalBattleTowerUrchinContentsList;
        world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Crystal Urchin");
        }
        world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Crystal Urchin");
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(5));
        }
        j = 16;
        chestContents = this.CrystalBattleTowerRotatorContentsList;
        world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(5));
        }
        j = 21;
        chestContents = this.CrystalBattleTowerVortexContentsList;
        world.setBlock(cposx, cposy + j + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Vortex");
        }
        world.setBlock(cposx, cposy + j + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + j + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Vortex");
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(6));
        }
    }

    public void makeGirlfriendIsland(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.DamselContentsList;
        for (int i = -5; i <= 5; ++i) {
            int k = 3;
            if (i == -5 || i == 5) {
                k = 1;
            }
            if (i == -4 || i == 4) {
                k = 2;
            }
            if (i == -3 || i == 3) {
                k = 2;
            }
            for (int j = -k; j <= k; ++j) {
                this.FastSetBlock(world, cposx + i, cposy, cposz + j, (Block) Blocks.sand);
                this.FastSetBlock(world, cposx + i, cposy - 1, cposz + j, Blocks.stone);
            }
        }
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                this.FastSetBlock(world, cposx + i, cposy + 3, cposz + j, (Block) Blocks.leaves);
            }
        }
        this.FastSetBlock(world, cposx, cposy + 4, cposz, (Block) Blocks.leaves);
        this.FastSetBlock(world, cposx, cposy + 3, cposz, Blocks.log);
        this.FastSetBlock(world, cposx, cposy + 2, cposz, Blocks.log);
        this.FastSetBlock(world, cposx, cposy + 1, cposz, Blocks.log);
        this.FastSetBlock(world, cposx + 1, cposy + 3, cposz + 1, Blocks.log);
        this.FastSetBlock(world, cposx - 1, cposy + 3, cposz - 1, Blocks.log);
        this.FastSetBlock(world, cposx + 1, cposy + 3, cposz - 1, Blocks.log);
        this.FastSetBlock(world, cposx - 1, cposy + 3, cposz + 1, Blocks.log);
        world.setBlock(cposx + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Girlfriend");
        }
        world.setBlock(cposx - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Boyfriend");
        }
        world.setBlock(cposx, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Gold Fish");
        }
        world.setBlock(cposx, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Gold Fish");
        }
        world.setBlock(cposx, cposy + 1, cposz - 1, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
        world.setBlock(cposx, cposy + 1, cposz + 1, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
    }

    public void makeGreenhouseDungeon(final World world, final int cposx, final int cposy, final int cposz) {
        final int height = 7;
        final int width = 15;
        final int length = 23;
        int t = 0;
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.GreenhouseContentsList;
        for (int i = 0; i < length; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = 0; j < height; ++j) {
                    Block blk = Blocks.air;
                    if (i == 0 || k == 0 || i == length - 1 || k == width - 1) {
                        blk = Blocks.glass;
                    }
                    if (j == height - 1) {
                        blk = Blocks.iron_block;
                        if (i % 4 == 3 && k % 4 == 3) {
                            blk = Blocks.glowstone;
                        }
                        if (k % 4 == 1) {
                            blk = Blocks.glass;
                        }
                    }
                    if (j == 0) {
                        blk = (Block) Blocks.grass;
                        if (i != 0 && k != 0 && i != length - 1 && k != width - 1 && i % 3 == 2) {
                            blk = Blocks.water;
                        }
                    }
                    if (j == 1 && i != 0
                        && k != 0
                        && i != length - 1
                        && k != width - 1
                        && i % 3 != 2
                        && world.rand.nextInt(3) != 1) {
                        blk = Blocks.farmland;
                        this.FastSetBlock(world, cposx + i, cposy + j - 1, cposz + k, blk);
                        t = world.rand.nextInt(20);
                        blk = Blocks.air;
                        if (t == 0) {
                            blk = (Block) Blocks.yellow_flower;
                        }
                        if (t == 1) {
                            blk = (Block) Blocks.red_flower;
                        }
                        if (t == 2) {
                            blk = (Block) Blocks.brown_mushroom;
                        }
                        if (t == 3) {
                            blk = (Block) Blocks.red_mushroom;
                        }
                        if (t == 4) {
                            blk = Blocks.wheat;
                        }
                        if (t == 5) {
                            blk = Blocks.carrots;
                        }
                        if (t == 6) {
                            blk = Blocks.potatoes;
                        }
                        if (t == 7) {
                            blk = Blocks.reeds;
                        }
                        if (t == 9) {
                            blk = OreSpawnMain.MyCornPlant1;
                        }
                        if (t == 10) {
                            blk = OreSpawnMain.MyTomatoPlant1;
                        }
                        if (t == 11) {
                            blk = OreSpawnMain.MyStrawberryPlant;
                        }
                        if (t == 12) {
                            blk = OreSpawnMain.MyButterflyPlant;
                        }
                        if (t == 13) {
                            blk = OreSpawnMain.MyMothPlant;
                        }
                        if (t == 14) {
                            blk = OreSpawnMain.MyRadishPlant;
                        }
                        if (t == 15) {
                            blk = OreSpawnMain.MyLettucePlant1;
                        }
                        if (t == 16) {
                            blk = OreSpawnMain.MyFlowerPinkBlock;
                        }
                        if (t == 17) {
                            blk = OreSpawnMain.MyFlowerBlueBlock;
                        }
                        if (t == 18) {
                            blk = OreSpawnMain.MyQuinoaPlant1;
                        }
                        if (t == 19) {
                            blk = OreSpawnMain.MyRicePlant;
                        }
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                }
            }
        }
        for (int i = 0; i < length; ++i) {
            for (int k = 0; k < width; ++k) {
                for (int j = height; j <= height + 6; ++j) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 1, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2, cposy + 2, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 1, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 1, cposy + 2, cposz, Blocks.air, 0, 2);
        ItemDoor.placeDoorBlock(world, cposx + width / 2, cposy + 1, cposz, 3, Blocks.iron_door);
        ItemDoor.placeDoorBlock(world, cposx + width / 2 - 1, cposy + 1, cposz, 3, Blocks.iron_door);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + 2, cposz, Blocks.stone, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + 2, cposz, Blocks.stone, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 - 2, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
        OreSpawnMain.setBlockFast(world, cposx + width / 2 + 1, cposy + 2, cposz - 1, Blocks.stone_button, 4, 2);
        int i = length / 2;
        int k = width / 2;
        int j = height + 1;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Triffid");
        }
        j = height + 2;
        world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Triffid");
        }
        j = height;
        world.setBlock(cposx + i, cposy + j, cposz + k, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + i, cposy + j, cposz + k);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(5));
        }
    }

    public void makeMonsterIsland(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        String monster = "Sea Viper";
        chestContents = this.MonsterIslandContentsList;
        if (world.rand.nextInt(2) == 0) {
            monster = "Sea Monster";
        }
        for (int i = -5; i <= 5; ++i) {
            int k = 3;
            if (i == -5 || i == 5) {
                k = 1;
            }
            if (i == -4 || i == 4) {
                k = 2;
            }
            if (i == -3 || i == 3) {
                k = 2;
            }
            for (int j = -k; j <= k; ++j) {
                this.FastSetBlock(world, cposx + i, cposy, cposz + j, (Block) Blocks.sand);
                this.FastSetBlock(world, cposx + i, cposy - 1, cposz + j, Blocks.stone);
            }
        }
        for (int i = -2; i <= 2; ++i) {
            for (int j = -2; j <= 2; ++j) {
                this.FastSetBlock(world, cposx + i, cposy + 3, cposz + j, (Block) Blocks.leaves);
            }
        }
        this.FastSetBlock(world, cposx, cposy + 4, cposz, (Block) Blocks.leaves);
        this.FastSetBlock(world, cposx, cposy + 3, cposz, Blocks.log);
        this.FastSetBlock(world, cposx, cposy + 2, cposz, Blocks.log);
        this.FastSetBlock(world, cposx, cposy + 1, cposz, Blocks.log);
        this.FastSetBlock(world, cposx + 1, cposy + 3, cposz + 1, Blocks.log);
        this.FastSetBlock(world, cposx - 1, cposy + 3, cposz - 1, Blocks.log);
        this.FastSetBlock(world, cposx + 1, cposy + 3, cposz - 1, Blocks.log);
        this.FastSetBlock(world, cposx - 1, cposy + 3, cposz + 1, Blocks.log);
        world.setBlock(cposx + 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName(monster);
        }
        world.setBlock(cposx - 1, cposy + 3, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 3, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName(monster);
        }
        world.setBlock(cposx, cposy + 3, cposz + 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz + 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName(monster);
        }
        world.setBlock(cposx, cposy + 3, cposz - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 3, cposz - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName(monster);
        }
        world.setBlock(cposx, cposy + 1, cposz - 1, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz - 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
        world.setBlock(cposx, cposy + 1, cposz + 1, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx, cposy + 1, cposz + 1);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 4 + world.rand.nextInt(5));
        }
    }

    public void makeNightmareRookery(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        final String monster = "Nightmare";
        chestContents = this.NightmareRookeryContentsList;

        // Étape 1 : Génération de la structure de base (sol)
        for (int i = -5; i <= 20; ++i) {
            int k = world.rand.nextInt(3) - 1;
            int h = world.rand.nextInt(20) + 1;
            for (int j = 0; j < h; ++j) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.stone);
                if (world.rand.nextInt(j + 5) == 1) {
                    this.FastSetBlock(world, cposx + i + 1, cposy + j, cposz + k, Blocks.stone);
                }
                if (world.rand.nextInt(j + 5) == 1) {
                    this.FastSetBlock(world, cposx + i - 1, cposy + j, cposz + k, Blocks.stone);
                }
                if (world.rand.nextInt(j + 5) == 1) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k + 1, Blocks.stone);
                }
                if (world.rand.nextInt(j + 5) == 1) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k - 1, Blocks.stone);
                }
            }

            // Étape 2 : Si la hauteur est suffisamment élevée, générez le reste de la structure
            if (h >= 18) {
                world.setBlock(cposx + i, cposy + h + 2, cposz + k, Blocks.mob_spawner, 0, 2);
                tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + h + 2, cposz + k);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName(monster);
                }
                world.setBlock(cposx + i, cposy + h + 1, cposz + k, (Block) Blocks.chest, 0, 2);
                chest = this.getChestTileEntity(world, cposx + i, cposy + h + 1, cposz + k);
                if (chest != null) {
                    WeightedRandomChestContent.generateChestContents(
                        world.rand,
                        chestContents,
                        (IInventory) chest,
                        4 + world.rand.nextInt(5));
                }
            }
        }
    }

    public void makeStinkyHouse(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.StinkyHouseContentsList;
        final int height = 2;
        final int width = 9;
        final int length = 12;
        final int yardwidth = 16;
        for (int yardlength = 24, i = 0; i <= yardlength; ++i) {
            for (int k = 0; k <= yardwidth; ++k) {
                Block bid = Blocks.air;
                if (i == 0 || i == yardlength || k == 0 || k == yardwidth) {
                    bid = Blocks.fence;
                }
                if (bid == Blocks.fence && world.rand.nextInt(3) == 1) {
                    bid = Blocks.air;
                }
                if (bid == Blocks.air && world.rand.nextInt(10) == 1) {
                    bid = (Block) Blocks.deadbush;
                }
                if (bid != Blocks.air) {
                    this.FastSetBlock(world, cposx + i - 5, cposy + 1, cposz + k - 4, bid);
                }
            }
        }
        for (int i = 0; i <= length; ++i) {
            for (int k = 0; k <= width; ++k) {
                for (int j = 0; j <= height; ++j) {
                    Block bid = Blocks.air;
                    if (i == 0 || i == length || k == 0 || k == width) {
                        bid = Blocks.planks;
                    }
                    if (bid == Blocks.planks && j == 1 && (i == 1 || i == length - 1 || k == 1 || k == width - 1)) {
                        bid = Blocks.glass_pane;
                    }
                    if (j == height) {
                        bid = Blocks.planks;
                    }
                    if (world.rand.nextInt(10) == 1) {
                        bid = Blocks.air;
                    }
                    if ((j == 0 || j == 1) && i == 0 && (k == width / 2 || k == width / 2 + 1)) {
                        bid = Blocks.air;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k, bid);
                }
            }
        }
        world.setBlock(cposx + 2, cposy + 1, cposz + 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 2, cposy + 1, cposz + 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Stink Bug");
        }
        world.setBlock(cposx + length - 2, cposy + 1, cposz + width - 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + length - 2, cposy + 1, cposz + width - 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Stinky");
        }
        world.setBlock(cposx + length / 2, cposy + 1, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + length / 2, cposy + 1, cposz + width / 2);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 8 + world.rand.nextInt(5));
        }
    }

    public void makeRubberDuckyPond(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.RubberDuckyContentsList;
        for (int i = 0; i < 2; ++i) {
            world.setBlock(cposx + i, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + 6, cposz);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Rubber Ducky");
            }
        }
        world.setBlock(cposx, cposy + 5, cposz, (Block) Blocks.chest, 0, 2);
        world.setBlock(cposx + 1, cposy + 5, cposz, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + 5, cposz);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 8 + world.rand.nextInt(5));
        }
        world.setBlock(cposx, cposy + 4, cposz, Blocks.glass, 0, 2);
        world.setBlock(cposx + 1, cposy + 4, cposz, Blocks.glass, 0, 2);
        for (int i = 0; i < 2; ++i) {
            world.setBlock(cposx + i, cposy + 3, cposz, Blocks.water, 0, 3);
        }
        world.setBlock(cposx - 1, cposy + 3, cposz, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx + 2, cposy + 3, cposz, (Block) Blocks.flowing_water, 0, 3);
        for (int i = 0; i < 12; ++i) {
            for (int k = 0; k < 11; ++k) {
                bid = Blocks.water;
                if (i == 0 || k == 0 || i == 11 || k == 10) {
                    bid = (Block) Blocks.sand;
                }
                this.FastSetBlock(world, cposx + i - 5, cposy, cposz + k - 5, bid);
                bid = Blocks.air;
                this.FastSetBlock(world, cposx + i - 5, cposy + 1, cposz + k - 5, bid);
                this.FastSetBlock(world, cposx + i - 5, cposy + 2, cposz + k - 5, bid);
            }
        }
    }

    public void makeWhiteHouse(final World world, final int cposx, final int cposy, final int cposz) {
        final TileEntityMobSpawner tileentitymobspawner = null;
        final TileEntityChest chest = null;
        final WeightedRandomChestContent[] chestContents = null;
        this.makefountain(world, cposx - 5, cposy, cposz - 15);
        this.makefountain(world, cposx + 15, cposy, cposz - 15);
        this.makewalkway(world, cposx + 7, cposy, cposz - 15);
        this.makewhbase(world, cposx - 4, cposy, cposz - 6);
        this.makewhwalls(world, cposx - 3, cposy + 2, cposz - 5);
        this.makewhroof(world, cposx - 4, cposy, cposz - 6);
        this.makewhinterior(world, cposx - 1, cposy + 2, cposz - 3);
    }

    private void makefountain(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        for (int i = 0; i < 7; ++i) {
            for (int k = 0; k < 5; ++k) {
                for (int j = 0; j < 15; ++j) {
                    bid = Blocks.water;
                    if (i == 0 || k == 0 || i == 6 || k == 4) {
                        bid = Blocks.quartz_block;
                    }
                    if (j == 0) {
                        bid = Blocks.quartz_block;
                    }
                    if (j == 1 && i == 3 && k == 2) {
                        bid = Blocks.glowstone;
                    }
                    if (j > 1) {
                        bid = Blocks.air;
                        if (j <= 4 && i == 3 && k == 2) {
                            bid = Blocks.quartz_block;
                        }
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, bid);
                }
            }
        }
        world.setBlock(cposx + 3, cposy + 5, cposz + 2, Blocks.water, 0, 3);
        world.setBlock(cposx + 2, cposy + 5, cposz + 2, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx + 4, cposy + 5, cposz + 2, (Block) Blocks.flowing_water, 0, 3);
    }

    private void makewalkway(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        for (int i = 0; i < 3; ++i) {
            for (int k = 0; k < 10; ++k) {
                for (int j = 0; j < 15; ++j) {
                    bid = Blocks.quartz_block;
                    if (j == 1) {
                        bid = Blocks.air;
                        if (k > 6) {
                            bid = Blocks.quartz_block;
                        }
                    }
                    if (j > 1) {
                        bid = Blocks.air;
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, bid);
                }
            }
        }
    }

    private void makewhbase(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        for (int i = 0; i < 25; ++i) {
            for (int k = 0; k < 25; ++k) {
                bid = Blocks.quartz_block;
                this.FastSetBlock(world, cposx + i, cposy + 1, cposz + k, bid);
                if ((i == 0 || i == 24) && (k == 0 || k == 24)) {
                    this.FastSetBlock(world, cposx + i, cposy + 2, cposz + k, OreSpawnMain.CrystalTorch);
                }
            }
        }
        for (int i = 1; i < 24; ++i) {
            for (int k = 1; k < 24; ++k) {
                bid = Blocks.quartz_block;
                this.FastSetBlock(world, cposx + i, cposy + 2, cposz + k, bid);
            }
        }
    }

    private void makewhwalls(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        for (int i = 0; i < 23; ++i) {
            for (int k = 0; k < 23; ++k) {
                for (int j = 0; j < 6; ++j) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == 22 || k == 22) {
                        bid = Blocks.quartz_block;
                    }
                    if (j != 0 && bid != Blocks.air) {
                        if (k == 22) {
                            if ((j & 0x1) == 0x1) {
                                if ((i & 0x1) == 0x0 || (k & 0x1) == 0x0) {
                                    bid = Blocks.glass_pane;
                                }
                            } else if ((i & 0x1) == 0x1 || (k & 0x1) == 0x1) {
                                bid = Blocks.glass_pane;
                            }
                        } else if (k != 0) {
                            if ((j & 0x1) == 0x1) {
                                if (i == 2 || k == 2 || i == 20 || k == 20) {
                                    bid = Blocks.glass_pane;
                                }
                            } else if (i == 1 || k == 1 || i == 21 || k == 21) {
                                bid = Blocks.glass_pane;
                            }
                            if (j > 0 && j < 5 && k > 7 && k < 15) {
                                bid = Blocks.glass_pane;
                            }
                        } else if ((j & 0x1) == 0x1) {
                            if (i == 2 || k == 2 || i == 20 || k == 20) {
                                bid = Blocks.glass_pane;
                            }
                        } else if (i == 1 || k == 1 || i == 21 || k == 21) {
                            bid = Blocks.glass_pane;
                        }
                    }
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, bid);
                }
            }
        }
        OreSpawnMain.setBlockFast(world, cposx + 11, cposy, cposz, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + 11, cposy + 1, cposz, Blocks.air, 0, 2);
        ItemDoor.placeDoorBlock(world, cposx + 11, cposy, cposz, 3, Blocks.iron_door);
        OreSpawnMain.setBlockFast(world, cposx + 12, cposy + 1, cposz - 1, Blocks.stone_button, 4, 2);
    }

    private void makewhroof(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        for (int j = 0; j < 13; ++j) {
            for (int i = 0; i < 25 - 2 * j; ++i) {
                for (int k = 0; k < 25 - 2 * j; ++k) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == 24 - 2 * j || k == 24 - 2 * j) {
                        bid = Blocks.quartz_block;
                    }
                    if (j == 0 && bid != Blocks.air && (i + k & 0x1) == 0x1) {
                        bid = Blocks.emerald_block;
                    }
                    if (j == 12) {
                        bid = Blocks.emerald_block;
                    }
                    this.FastSetBlock(world, cposx + i + j, cposy + 8 + j, cposz + k + j, bid);
                    if ((i == 0 || i == 24 - 2 * j) && (k == 0 || k == 24 - 2 * j)) {
                        this.FastSetBlock(
                            world,
                            cposx + i + j,
                            cposy + 8 + j + 1,
                            cposz + k + j,
                            OreSpawnMain.CrystalTorch);
                    }
                }
            }
        }
        bid = Blocks.fence;
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 11, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 10, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 9, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 8, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 7, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 6, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 5, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 4, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 3, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 2, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 1, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 0, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 11, cposy + 8 + 0, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 13, cposy + 8 + 0, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 0, cposz + 11, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 0, cposz + 13, bid);
        bid = OreSpawnMain.CrystalTorch;
        this.FastSetBlock(world, cposx + 11, cposy + 8 + 1, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 13, cposy + 8 + 1, cposz + 12, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 1, cposz + 11, bid);
        this.FastSetBlock(world, cposx + 12, cposy + 8 + 1, cposz + 13, bid);
    }

    private void makewhinterior(final World world, final int cposx, final int cposy, final int cposz) {
        int zoff = 1;
        int xoff = 0;
        for (int i = 0; i < 8; ++i) {
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
        }
        xoff = 11;
        for (int i = 0; i < 8; ++i) {
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
        }
        zoff = 7;
        xoff = 0;
        for (int i = 0; i < 8; ++i) {
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
        }
        xoff = 11;
        for (int i = 0; i < 8; ++i) {
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
        }
        zoff = 13;
        xoff = 0;
        for (int i = 0; i < 8; ++i) {
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
        }
        xoff = 11;
        for (int i = 0; i < 8; ++i) {
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff, Blocks.quartz_stairs, 3, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 1, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain
                .setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 2, (Block) Blocks.piston_extension, 1, 2);
            OreSpawnMain.setBlockFast(world, cposx + xoff + i, cposy, cposz + zoff + 3, Blocks.quartz_stairs, 2, 2);
        }
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.WhiteHouseContentsList;
        zoff = 18;
        xoff = 2;
        world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Criminal");
        }
        world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
        xoff = 6;
        world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Criminal");
        }
        world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
        xoff = 12;
        world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Criminal");
        }
        world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
        xoff = 16;
        world.setBlock(cposx + xoff, cposy + 1, cposz + zoff, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + xoff, cposy + 1, cposz + zoff);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Criminal");
        }
        world.setBlock(cposx + xoff, cposy, cposz + zoff, (Block) Blocks.chest, 0, 2);
        chest = this.getChestTileEntity(world, cposx + xoff, cposy, cposz + zoff);
        if (chest != null) {
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 3 + world.rand.nextInt(5));
        }
    }

    public void makeQueenAltar(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int width = 51;
        final int length = 51;
        final int height = 48;
        if (world.isRemote) {
            return;
        }
        for (int j = 0; j <= height + 10; ++j) {
            for (int i = -5; i < width + 5; ++i) {
                for (int k = -5; k < length + 5; ++k) {
                    bid = Blocks.air;
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                }
            }
        }
        int j = 0;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < length; ++k) {
                bid = (Block) Blocks.grass;
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                for (int v = 1; v < 10; ++v) {
                    bid = world.getBlock(cposx + i, cposy + j - v, cposz + k);
                    if (bid == Blocks.air || bid == Blocks.tallgrass || bid == Blocks.water) {
                        bid = Blocks.dirt;
                        OreSpawnMain.setBlockFast(world, cposx + i, cposy + j - v, cposz + k, bid, 0, 2);
                    }
                }
            }
        }
        this.makequeencolumn(world, cposx + 1, cposy + 1, cposz + 1);
        this.makequeencolumn(world, cposx + width - 8, cposy + 1, cposz + length - 8);
        this.makequeencolumn(world, cposx + 1, cposy + 1, cposz + length - 8);
        this.makequeencolumn(world, cposx + width - 8, cposy + 1, cposz + 1);
        j = height - 1;
        bid = Blocks.obsidian;
        for (int i = 0; i < width; ++i) {
            for (int k = 0; k < length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        j = height;
        bid = Blocks.obsidian;
        for (int i = -1; i <= width; ++i) {
            for (int k = -1; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        this.makequeenbackground(world, cposx + 4, cposy + 10, cposz + 9);
        this.makequeencenteraltar(world, cposx + width / 2, cposy, cposz + length / 2);
    }

    private void makequeencolumn(final World world, int cposx, int cposy, int cposz) {
        Block bid = Blocks.air;
        int meta = 0;
        final int width = 5;
        final int length = 5;
        final int height = 44;
        if (world.isRemote) {
            return;
        }
        int j = 0;
        bid = Blocks.obsidian;
        for (int i = 0; i < width + 2; ++i) {
            for (int k = 0; k < length + 2; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + height + 1, cposz + k, bid, meta, 2);
            }
        }
        ++cposx;
        ++cposz;
        ++cposy;
        for (j = 0; j < height; ++j) {
            for (int i = 0; i < width; ++i) {
                for (int k = 0; k < length; ++k) {
                    bid = Blocks.air;
                    if (i == 0 || k == 0 || i == width - 1 || k == length - 1) {
                        bid = Blocks.obsidian;
                    }
                    if (j % 4 == 0 && bid != Blocks.air && (i == 2 || k == 2)) {
                        bid = Blocks.redstone_block;
                    }
                    if (j % 4 == 1 && bid != Blocks.air) {
                        if (i == 1 || k == 1) {
                            bid = Blocks.redstone_block;
                        }
                        if (i == 3 || k == 3) {
                            bid = Blocks.redstone_block;
                        }
                    }
                    if (j % 4 == 2 && bid != Blocks.air) {
                        if (i == 1 || k == 1) {
                            bid = Blocks.redstone_block;
                        }
                        if (i == 3 || k == 3) {
                            bid = Blocks.redstone_block;
                        }
                        if (i == 2 || k == 2) {
                            bid = OreSpawnMain.MyBlockAmethystBlock;
                        }
                    }
                    if (j % 4 == 3 && bid != Blocks.air) {
                        if (i == 1 || k == 1) {
                            bid = Blocks.redstone_block;
                        }
                        if (i == 3 || k == 3) {
                            bid = Blocks.redstone_block;
                        }
                    }
                    meta = 0;
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, meta, 2);
                }
            }
        }
    }

    private void makequeenbackground(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int meta = 0;
        int curz = 0;
        int cury = 0;
        final int height = 33;
        final int width = 33;
        bid = Blocks.stone;
        for (int m = 0; m < this.queen.length; ++m) {
            final int v = this.queen[m];
            if (v < 0) {
                bid = Blocks.stone;
                while (curz < width) {
                    OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
                    ++curz;
                }
                ++cury;
                curz = 0;
            } else {
                for (int n = 0; n < v; ++n) {
                    OreSpawnMain.setBlockFast(world, cposx, cposy + cury, cposz + curz, bid, 0, 2);
                    ++curz;
                }
                if (bid == Blocks.stone) {
                    bid = OreSpawnMain.MyBlockRubyBlock;
                } else {
                    bid = Blocks.stone;
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + i, Blocks.diamond_block, 0, 2);
        }
        for (int i = 0; i < width; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy + height, cposz + i, Blocks.diamond_block, 0, 2);
        }
        for (int i = -1; i <= height; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz - 1, Blocks.diamond_block, 0, 2);
        }
        for (int i = -1; i <= height; ++i) {
            OreSpawnMain.setBlockFast(world, cposx, cposy + i, cposz + width, Blocks.diamond_block, 0, 2);
        }
        OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz - 2, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz + width + 1, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy - 2, cposz + width + 1, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 1, cposz - 2, Blocks.diamond_block, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy - 1, cposz + width + 1, OreSpawnMain.CrystalTorch, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx, cposy + height + 2, cposz - 2, OreSpawnMain.CrystalTorch, 0, 2);
    }

    private void makequeencenteraltar(final World world, final int cposx, final int cposy, final int cposz) {
        Block bid = Blocks.air;
        final int meta = 0;
        int width = 10;
        int length = 10;
        int j = 0;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 6;
        length = 20;
        j = 0;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 20;
        length = 6;
        j = 0;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 8;
        length = 8;
        j = 1;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                bid = Blocks.obsidian;
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 4;
        length = 18;
        j = 1;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                bid = Blocks.obsidian;
                if (i == width && (k == -length || k == length)) {
                    bid = OreSpawnMain.MyBlockAmethystBlock;
                }
                if (i == -width && (k == -length || k == length)) {
                    bid = OreSpawnMain.MyBlockAmethystBlock;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 18;
        length = 4;
        j = 1;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                bid = Blocks.obsidian;
                if (i == width && (k == -length || k == length)) {
                    bid = OreSpawnMain.MyBlockAmethystBlock;
                }
                if (i == -width && (k == -length || k == length)) {
                    bid = OreSpawnMain.MyBlockAmethystBlock;
                }
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 7;
        length = 7;
        j = 2;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                if (i == width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
                if (i == -width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
            }
        }
        width = 3;
        length = 17;
        j = 2;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 17;
        length = 3;
        j = 2;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 6;
        length = 6;
        j = 3;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 2;
        length = 16;
        j = 3;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 16;
        length = 2;
        j = 3;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
            }
        }
        width = 2;
        length = 2;
        j = 4;
        bid = Blocks.obsidian;
        for (int i = -width; i <= width; ++i) {
            for (int k = -length; k <= length; ++k) {
                OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, bid, 0, 2);
                if (i == width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
                if (i == -width && (k == -length || k == length)) {
                    OreSpawnMain
                        .setBlockFast(world, cposx + i, cposy + j + 1, cposz + k, OreSpawnMain.CrystalTorch, 0, 2);
                }
            }
        }
        world.setBlock(cposx, cposy + j, cposz, (Block) Blocks.chest);
        world.setBlockMetadataWithNotify(cposx, cposy + j, cposz, 2, 3);
        final TileEntityChest chest = this.getChestTileEntity(world, cposx, cposy + j, cposz);
        if (chest != null) {
            chest.setInventorySlotContents(13, new ItemStack(OreSpawnMain.TheQueenEgg));
        }
    }

    public void makeFrogPond(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        world.setBlock(cposx, cposy + 2, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 2, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Frog");
        }
        for (int i = -3; i <= 3; ++i) {
            for (int j = -3; j <= 3; ++j) {
                world.setBlock(cposx + i, cposy, cposz + j, Blocks.water, 0, 3);
            }
        }
        world.setBlock(cposx, cposy + 1, cposz, Blocks.water, 0, 3);
        world.setBlock(cposx - 1, cposy + 1, cposz, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx + 1, cposy + 1, cposz, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx, cposy + 1, cposz - 1, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx, cposy + 1, cposz + 1, (Block) Blocks.flowing_water, 0, 3);
        world.setBlock(cposx - 1, cposy + 2, cposz, Blocks.waterlily, 0, 3);
        world.setBlock(cposx + 1, cposy + 2, cposz, Blocks.waterlily, 0, 3);
        world.setBlock(cposx, cposy + 2, cposz - 1, Blocks.waterlily, 0, 3);
        world.setBlock(cposx, cposy + 2, cposz + 1, Blocks.waterlily, 0, 3);
    }

    public void makePumpkin(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 14;
        final int depth = 12;
        final int height = 14;
        final int dark_green = 13;
        final int orange = 1;
        int which_color = 0;
        Block blk = Blocks.air;
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                for (int k = 0; k < depth; ++k) {
                    which_color = 0;
                    blk = Blocks.air;
                    if (j == 0 || j == height - 1) {
                        blk = Blocks.stained_hardened_clay;
                        which_color = orange;
                    }
                    if (i == 0 || i == width - 1) {
                        blk = Blocks.stained_hardened_clay;
                        which_color = orange;
                    }
                    if (k == 0 || k == depth - 1) {
                        blk = Blocks.stained_hardened_clay;
                        which_color = orange;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, which_color, 2);
                }
            }
        }
        int i = width / 2 - 1;
        int k = 0;
        int j = 11;
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 10;
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 9;
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 5, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 8;
        OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 7;
        OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 4;
        OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 3;
        OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 2;
        OreSpawnMain.setBlockFast(world, cposx + i + 1, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i + 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 1;
        OreSpawnMain.setBlockFast(world, cposx + i + 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        i = width / 2;
        k = 0;
        j = 11;
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 5, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 10;
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 5, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 9;
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 5, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 8;
        OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 7;
        OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 4;
        OreSpawnMain.setBlockFast(world, cposx + i - 1, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 3;
        OreSpawnMain.setBlockFast(world, cposx + i - 1, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 2;
        OreSpawnMain.setBlockFast(world, cposx + i - 1, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 3, cposy + j, cposz + k, Blocks.air, 0, 2);
        OreSpawnMain.setBlockFast(world, cposx + i - 4, cposy + j, cposz + k, Blocks.air, 0, 2);
        j = 1;
        OreSpawnMain.setBlockFast(world, cposx + i - 2, cposy + j, cposz + k, Blocks.air, 0, 2);
        k = depth / 2 - 1;
        for (j = 0; j < 4; ++j) {
            for (i = 0; i < 3; ++i) {
                OreSpawnMain.setBlockFast(
                    world,
                    cposx + width / 2 - i - j,
                    cposy + height + j,
                    cposz + k,
                    Blocks.stained_hardened_clay,
                    dark_green,
                    2);
            }
        }
        for (j = 0; j < 5; ++j) {
            for (i = 0; i < 2; ++i) {
                for (k = 0; k < 2; ++k) {
                    OreSpawnMain.setBlockFast(
                        world,
                        cposx + width / 2 + i - 1,
                        cposy + j + 1,
                        cposz + depth / 2 + k - 1,
                        Blocks.planks,
                        0,
                        2);
                }
            }
        }
        j = 5;
        for (i = 0; i < 2; ++i) {
            for (k = 0; k < 2; ++k) {
                OreSpawnMain.setBlockFast(
                    world,
                    cposx + width / 2 + i - 1,
                    cposy + j + 1,
                    cposz + depth / 2 + k - 1,
                    Blocks.netherrack,
                    0,
                    2);
            }
        }
        j = 6;
        k = 0;
        for (i = 0; i < 2; ++i) {
            OreSpawnMain.setBlockFast(
                world,
                cposx + width / 2 + i - 1,
                cposy + j + 1,
                cposz + depth / 2 + k - 1,
                (Block) Blocks.fire,
                0,
                2);
        }
        j = 6;
        k = 1;
        i = 0;
        world.setBlock(cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost Pumpkin Skelly");
        }
        i = 1;
        world.setBlock(cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this
            .getSpawnerTileEntity(world, cposx + width / 2 + i - 1, cposy + j + 1, cposz + depth / 2 + k - 1);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Ghost Pumpkin Skelly");
        }
    }

    public void makeRoundRotator(final World world, final int cposx, final int cposy, final int cposz) {
        TileEntityMobSpawner tileentitymobspawner = null;
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        float radius = 6.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
            final float curx = (float) (radius * Math.cos(Math.toRadians(curdeg)));
            final float cury = (float) (radius * Math.sin(Math.toRadians(curdeg)));
            final Block blk = Blocks.bedrock;
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), (int) (cposy + 6 + cury + 0.5f), cposz, blk);
        }
        radius = 2.0f;
        for (float curdeg = 0.0f; curdeg < 360.0f; curdeg += 5.0f) {
            final float curx = (float) (radius * Math.cos(Math.toRadians(curdeg)));
            final float cury = (float) (radius * Math.sin(Math.toRadians(curdeg)));
            final Block blk = OreSpawnMain.MyCrystalPinkBlock;
            this.FastSetBlock(world, (int) (cposx + curx + 0.5f), (int) (cposy + 6 + cury + 0.5f), cposz, blk);
        }
        world.setBlock(cposx + 1, cposy + 6 + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 6 + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx - 1, cposy + 6 - 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 6 - 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx + 1, cposy + 6 - 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 1, cposy + 6 - 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx - 1, cposy + 6 + 1, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 1, cposy + 6 + 1, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Rotator");
        }
        world.setBlock(cposx + 5, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + 5, cposy + 6, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Dungeon Beast");
        }
        world.setBlock(cposx - 5, cposy + 6, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 5, cposy + 6, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Dungeon Beast");
        }
        world.setBlock(cposx, cposy + 6 - 5, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 6 - 5, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Dungeon Beast");
        }
        world.setBlock(cposx, cposy + 6 + 5, cposz, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx, cposy + 6 + 5, cposz);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Dungeon Beast");
        }
        final Block blk = OreSpawnMain.CrystalCoal;
        this.FastSetBlock(world, cposx + 1, cposy + 6, cposz, blk);
        this.FastSetBlock(world, cposx - 1, cposy + 6, cposz, blk);
        this.FastSetBlock(world, cposx, cposy + 6 + 1, cposz, blk);
        this.FastSetBlock(world, cposx, cposy + 6 - 1, cposz, blk);
        world.setBlock(cposx, cposy + 6, cposz, (Block) Blocks.chest);
        world.setBlockMetadataWithNotify(cposx, cposy + 6, cposz, 2, 3);
        chest = this.getChestTileEntity(world, cposx, cposy + 6, cposz);
        if (chest != null) {
            chestContents = this.CrystalBattleTowerVortexContentsList;
            WeightedRandomChestContent
                .generateChestContents(world.rand, chestContents, (IInventory) chest, 6 + world.rand.nextInt(6));
        }
    }

    public void makeRainbow(final World world, final int cposx, final int cposy, final int cposz) {
        int blk_color = 0;
        int j = 35;
        int[] widths = { 12, 13, 14, 13, 12 };
        int[] depths = { 1, 2, 3, 2, 1 };

        for (int level = 0; level < widths.length; level++) {
            int width = widths[level];
            int depth = depths[level];

            for (int i = -width; i < width; ++i) {
                for (int k = -depth; k <= depth; ++k) {
                    Block block = (i == -width || i == width - 1 || k == -depth || k == depth)
                        ? Blocks.stained_hardened_clay
                        : Blocks.air;
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j + level, cposz + k, block, blk_color, 2);
                }
            }
        }

        for (int m = 3; m < 11; ++m) {
            blk_color = this.blkcolors[m - 3];

            for (int i = 0; i < m; ++i) {
                OreSpawnMain
                    .setBlockFast(world, cposx + m, cposy + j + i, cposz, Blocks.stained_hardened_clay, blk_color, 2);
                OreSpawnMain.setBlockFast(
                    world,
                    cposx - (m + 1),
                    cposy + j + i,
                    cposz,
                    Blocks.stained_hardened_clay,
                    blk_color,
                    2);
            }

            for (int i = -(m + 1); i <= m; ++i) {
                OreSpawnMain
                    .setBlockFast(world, cposx + i, cposy + j + m, cposz, Blocks.stained_hardened_clay, blk_color, 2);
            }
        }

        // Créez les blocs des coffres et des spawners en une seule opération
        for (int xOffset : new int[] { 2, -3 }) {
            for (int yOffset : new int[] { 0, 1 }) {
                world.setBlock(cposx + xOffset, cposy + j + yOffset, cposz, Blocks.mob_spawner, 0, 2);
                TileEntityMobSpawner tileentitymobspawner = this
                    .getSpawnerTileEntity(world, cposx + xOffset, cposy + j + yOffset, cposz);
                if (tileentitymobspawner != null) {
                    tileentitymobspawner.func_145881_a()
                        .setEntityName("Cloud Shark");
                }
            }
        }

        // Créez les coffres et leurs contenus en une seule opération
        for (int xOffset : new int[] { 0, -1 }) {
            world.setBlock(cposx + xOffset, cposy + j, cposz, (Block) Blocks.chest);
            world.setBlockMetadataWithNotify(cposx + xOffset, cposy + j, cposz, 2, 3);
            TileEntityChest chest = this.getChestTileEntity(world, cposx + xOffset, cposy + j, cposz);
            if (chest != null) {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, this.RainbowContentsList, chest, 10 + world.rand.nextInt(5));
            }
        }
    }

    public void makeEnormousCastleQ(final World world, final int cposx, final int cposy, final int cposz) {
        final int width = 28;
        final int height = 16;
        final int platformwidth = 11;
        int level = 0;
        if (world.isRemote) {
            return;
        }
        level = 1 + world.rand.nextInt(6);
        if (level <= 3 && world.rand.nextInt(3) != 1) {
            level += 3;
        }
        for (int i = -20; i < width + 4; ++i) {
            for (int j = 1; j < height + 10; ++j) {
                for (int k = -4; k < width + 4; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.obsidian);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 1; j < height; ++j) {
                int k = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
                k = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 1; j < height; ++j) {
                int i = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
                i = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.iron_bars);
            }
        }
        world.setBlock(cposx + 1, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
        world.setBlock(cposx + 1, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
        world.setBlock(cposx + width - 2, cposy + 1, cposz + 1, OreSpawnMain.ExtremeTorch);
        world.setBlock(cposx + width - 2, cposy + 1, cposz + width - 2, OreSpawnMain.ExtremeTorch);
        for (int i = -4; i < width + 4; ++i) {
            for (int k = -4; k < width + 4; ++k) {
                if (i < 0 || k < 0 || i >= width || k >= width) {
                    this.FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.obsidian);
                }
                if (i == -4 || k == -4 || i == width + 3 || k == width + 3) {
                    this.FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence);
                }
            }
        }
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j < 4; ++j) {
            world.setBlock(cposx - 3, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz - 3);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Lurking Terror");
            }
            world.setBlock(cposx - 3, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - 3, cposy + 1 + j, cposz + width + 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Lurking Terror");
            }
            world.setBlock(cposx + width + 2, cposy + 1 + j, cposz - 3, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz - 3);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Lurking Terror");
            }
            world.setBlock(cposx + width + 2, cposy + 1 + j, cposz + width + 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width + 2, cposy + 1 + j, cposz + width + 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Lurking Terror");
            }
        }
        world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Emperor Scorpion");
        }
        world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Emperor Scorpion");
        }
        world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
        tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
        if (tileentitymobspawner != null) {
            tileentitymobspawner.func_145881_a()
                .setEntityName("Emperor Scorpion");
        }
        int j = height;
        this.buildLevelQ(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Rotator", 1, -1, 5, 1, level);
        j += 10;
        if (level >= 2) {
            this.buildLevelQ(world, cposx + 1, cposy + j, cposz + 1, width - 2, 10, 4, "Bee", 0, 0, 4, 2, level);
        }
        j += 10;
        if (level >= 3) {
            this.buildLevelQ(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 4, "Mantis", 1, 1, 4, 3, level);
        }
        j += 9;
        if (level >= 4) {
            this.buildLevelQ(world, cposx + 2, cposy + j, cposz + 2, width - 4, 9, 3, "Mothra", 0, 0, 4, 4, level);
        }
        j += 9;
        if (level >= 5) {
            this.buildLevelQ(world, cposx + 3, cposy + j, cposz + 3, width - 6, 8, 3, "Brutalfly", 1, 1, 4, 5, level);
        }
        j += 8;
        if (level >= 6) {
            this.buildLevelQ(world, cposx + 3, cposy + j, cposz + 3, width - 6, 16, 3, "Vortex", 0, 0, 3, 6, level);
        }
        j += 16;
        for (int i = 0; i < platformwidth; ++i) {
            j = height;
            for (int k = -(platformwidth / 2); k <= platformwidth / 2; ++k) {
                this.FastSetBlock(
                    world,
                    cposx + i - 20,
                    cposy + j,
                    cposz + k + width / 2,
                    OreSpawnMain.MyBlockAmethystBlock);
                if ((i == 0 || i == platformwidth - 1 || k == -(platformwidth / 2) || k == platformwidth / 2)
                    && (i != 0 || k < -1 || k > 1)) {
                    this.FastSetBlock(
                        world,
                        cposx + i - 20,
                        cposy + j + 1,
                        cposz + k + width / 2,
                        Blocks.nether_brick_fence);
                }
            }
        }
        for (int i = -10; i <= -3; ++i) {
            j = height;
            for (int k = -2; k < 3; ++k) {
                if (i == -3 || i == -10) {
                    if (k != -2 && k != 2) {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block) Blocks.fire);
                    }
                } else {
                    this.FastSetBlock(
                        world,
                        cposx + i,
                        cposy + j,
                        cposz + k + width / 2,
                        OreSpawnMain.MyBlockAmethystBlock);
                    if (k == -2 || k == 2) {
                        this.FastSetBlock(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k + width / 2,
                            Blocks.nether_brick_fence);
                    }
                }
            }
        }
        int i = -21;
        for (j = height; j >= 0; --j) {
            for (int k = -2; k < 3; ++k) {
                for (int t = 0; t < 6; ++t) {
                    this.FastSetBlock(world, cposx + i, cposy + j + t + 1, cposz + k + width / 2, Blocks.air);
                }
                if (j == 0) {
                    if (k != -2 && k != 2) {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.air);
                    } else {
                        this.FastSetBlock(world, cposx + i, cposy + j + 1, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 2, cposz + k + width / 2, Blocks.netherrack);
                        this.FastSetBlock(world, cposx + i, cposy + j + 3, cposz + k + width / 2, (Block) Blocks.fire);
                    }
                } else {
                    this.FastSetBlock(
                        world,
                        cposx + i,
                        cposy + j,
                        cposz + k + width / 2,
                        OreSpawnMain.MyBlockAmethystBlock);
                    if (k == -2 || k == 2) {
                        this.FastSetBlock(
                            world,
                            cposx + i,
                            cposy + j + 1,
                            cposz + k + width / 2,
                            Blocks.nether_brick_fence);
                    }
                }
            }
            --i;
        }
        if (level >= 6) {
            final int span = width * 3;
            for (int tries = 0; tries < 100; ++tries) {
                j = -1;
                i = world.rand.nextInt(span);
                int k = world.rand.nextInt(span);
                if (i < span / 4 || i > span * 3 / 4 || k < span / 4 || k > span * 3 / 4) {
                    i -= span / 2;
                    k -= span / 2;
                    world.setBlock(cposx + i + width / 2, cposy + j, cposz + k + width / 2, Blocks.mob_spawner, 0, 2);
                    tileentitymobspawner = this
                        .getSpawnerTileEntity(world, cposx + i + width / 2, cposy + j, cposz + k + width / 2);
                    if (tileentitymobspawner != null) {
                        tileentitymobspawner.func_145881_a()
                            .setEntityName("Large Worm");
                    }
                }
            }
        }
    }

    public void buildLevelQ(final World world, final int cposx, final int cposy, final int cposz, final int width,
        final int height, final int pw, final String critter, final int stepside, final int stepoff, final int holelen,
        final int decor, final int level) {
        for (int i = -pw; i < width + pw; ++i) {
            for (int j = 1; j < height; ++j) {
                for (int k = -pw; k < width + pw; ++k) {
                    this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.air);
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = 0;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int i = 0; i < width; ++i) {
            final int j = height;
            for (int k = 0; k < width; ++k) {
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 1; j < height; ++j) {
                int k = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
                k = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.bedrock);
            }
        }
        for (int k = 0; k < width; ++k) {
            for (int j = 1; j < height; ++j) {
                Block blk = Blocks.bedrock;
                if (k == 0 || k == width - 1) {
                    blk = OreSpawnMain.MyBlockRubyBlock;
                }
                int i = 0;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
                i = width - 1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, blk);
            }
        }
        for (int i = -pw; i < width + pw; ++i) {
            for (int k = -pw; k < width + pw; ++k) {
                if (i < 0 || k < 0 || i >= width || k >= width) {
                    this.FastSetBlock(world, cposx + i, cposy, cposz + k, Blocks.obsidian);
                }
                if (i == -pw || k == -pw || i == width + (pw - 1) || k == width + (pw - 1)) {
                    this.FastSetBlock(world, cposx + i, cposy + 1, cposz + k, Blocks.nether_brick_fence);
                }
            }
        }
        int i = -(height / 2);
        i += width / 2;
        for (int j = 1; j < height; ++j) {
            if (stepside != 0) {
                final int k = -1;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.obsidian);
            } else {
                final int k = width;
                this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.obsidian);
            }
            ++i;
        }
        if (stepoff >= 0) {
            int k;
            if (stepside == 0) {
                k = -1;
                k -= stepoff;
            } else {
                k = width;
                k += stepoff;
            }
            i = width / 2;
            final int j = 0;
            for (int l = 0; l < holelen; ++l) {
                this.FastSetBlock(world, cposx + i + l, cposy + j, cposz + k, Blocks.air);
            }
        }
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int j = 0; j < 4; ++j) {
            world.setBlock(cposx - (pw - 1), cposy + j + 1, cposz - (pw - 1), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx - (pw - 1), cposy + j + 1, cposz - (pw - 1));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx - (pw - 1), cposy + j + 1, cposz + width + (pw - 2), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx - (pw - 1), cposy + j + 1, cposz + width + (pw - 2));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width + (pw - 2), cposy + j + 1, cposz - (pw - 1), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width + (pw - 2), cposy + j + 1, cposz - (pw - 1));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width + (pw - 2), cposy + j + 1, cposz + width + (pw - 2), Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width + (pw - 2), cposy + j + 1, cposz + width + (pw - 2));
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
        }
        this.addLevelDecorationsQ(world, cposx, cposy, cposz, width, height, decor, level);
    }

    public void addLevelDecorationsQ(final World world, final int cposx, final int cposy, final int cposz,
        final int width, final int height, final int decor, final int difficulty) {
        TileEntityMobSpawner tileentitymobspawner = null;
        int reward = 1;
        String critter = "T. Rex";
        if (decor == 6) {
            this.FastSetBlock(world, cposx, cposy + height, cposz, Blocks.netherrack);
            this.FastSetBlock(world, cposx, cposy + height + 1, cposz, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx, cposy + height, cposz + width - 1, Blocks.netherrack);
            this.FastSetBlock(world, cposx, cposy + height + 1, cposz + width - 1, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx + width - 1, cposy + height, cposz, Blocks.netherrack);
            this.FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx + width - 1, cposy + height, cposz + width - 1, Blocks.netherrack);
            this.FastSetBlock(world, cposx + width - 1, cposy + height + 1, cposz + width - 1, (Block) Blocks.fire);
            this.FastSetBlock(world, cposx + width / 2, cposy + height, cposz + width / 2, Blocks.air);
            world.setBlock(cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2 - 1, cposy + height + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            world.setBlock(cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2 + 1, cposy + height + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 - 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            world.setBlock(cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this
                .getSpawnerTileEntity(world, cposx + width / 2, cposy + height + 2, cposz + width / 2 + 1);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Nightmare");
            }
            for (int i = 1; i < width - 1; ++i) {
                for (int j = 1; j < 5; ++j) {
                    for (int k = 1; k < width - 1; ++k) {
                        this.FastSetBlock(world, cposx + i, cposy + j, cposz + k, Blocks.dirt);
                    }
                }
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Large Worm");
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Large Worm");
            }
            world.setBlock(cposx + width / 2, cposy + 4, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 4, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Large Worm");
            }
            for (int j = 0; j < 10; ++j) {
                this.FastSetBlock(world, cposx + 1, cposy + j, cposz + 1, Blocks.air);
            }
            this.fill_chests(world, cposx, cposy + 4, cposz, width, height, decor, reward);
        }
        if (decor == 5) {
            if (difficulty == 5) {
                critter = "T. Rex";
                reward = 1;
            }
            if (difficulty == 6) {
                critter = "Nastysaurus";
                reward = 2;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
            this.FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 4) {
            if (difficulty == 4) {
                critter = "T. Rex";
                reward = 1;
            }
            if (difficulty == 5) {
                critter = "Nastysaurus";
                reward = 2;
            }
            if (difficulty == 6) {
                critter = "Basilisk";
                reward = 3;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
            this.FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 3) {
            if (difficulty == 3) {
                critter = "T. Rex";
                reward = 1;
            }
            if (difficulty == 4) {
                critter = "Nastysaurus";
                reward = 2;
            }
            if (difficulty == 5) {
                critter = "Basilisk";
                reward = 3;
            }
            if (difficulty == 6) {
                critter = "Hercules Beetle";
                reward = 4;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + width - 2, cposy, cposz + width - 2, Blocks.air);
            this.FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 2) {
            if (difficulty == 2) {
                critter = "T. Rex";
                reward = 1;
            }
            if (difficulty == 3) {
                critter = "Nastysaurus";
                reward = 2;
            }
            if (difficulty == 4) {
                critter = "Basilisk";
                reward = 3;
            }
            if (difficulty == 5) {
                critter = "Hercules Beetle";
                reward = 4;
            }
            if (difficulty == 6) {
                critter = "Jumpy Bug";
                reward = 5;
            }
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + 1, cposy, cposz + 1, Blocks.air);
            this.FastSetBlock(world, cposx + width - 2, cposy + height, cposz + width - 2, Blocks.air);
            this.fill_chests(world, cposx, cposy, cposz, width, height, decor, reward);
        }
        if (decor == 1) {
            if (difficulty == 1) {
                critter = "T. Rex";
            }
            if (difficulty == 2) {
                critter = "Nastysaurus";
            }
            if (difficulty == 3) {
                critter = "Basilisk";
            }
            if (difficulty == 4) {
                critter = "Hercules Beetle";
            }
            if (difficulty == 5) {
                critter = "Jumpy Bug";
            }
            if (difficulty == 6) {
                critter = "CaterKiller";
            }
            reward = difficulty;
            world.setBlock(cposx + width / 2, cposy + 2, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 2, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            world.setBlock(cposx + width / 2, cposy + 3, cposz + width / 2, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + width / 2, cposy + 3, cposz + width / 2);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName(critter);
            }
            for (int j = 1; j < 5; ++j) {
                this.FastSetBlock(world, cposx + width / 2 - 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2 + 1, cposy + j, cposz + width / 2, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 - 1, Blocks.bedrock);
                this.FastSetBlock(world, cposx + width / 2, cposy + j, cposz + width / 2 + 1, Blocks.bedrock);
            }
            this.FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + width / 2 + 1, cposy + 1, cposz + width / 2 - 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + width / 2 - 1, cposy + 1, cposz + width / 2 + 1, OreSpawnMain.MyRTPBlock);
            this.FastSetBlock(world, cposx + 1, cposy + height, cposz + 1, Blocks.air);
            this.fill_chestsQ(world, cposx, cposy, cposz, width, height, decor, reward);
        }
    }

    private void fill_chestsQ(final World world, final int cposx, final int cposy, final int cposz, final int width,
        final int height, final int decor, final int reward) {
        TileEntityChest chest = null;
        WeightedRandomChestContent[] chestContents = null;
        chestContents = this.level1ContentsList;
        if (reward == 2) {
            chestContents = this.level2ContentsList;
        }
        if (reward == 3) {
            chestContents = this.level3ContentsList;
        }
        if (reward == 4) {
            chestContents = this.level4ContentsList;
        }
        if (reward == 5) {
            chestContents = this.level5ContentsList;
        }
        world.setBlock(cposx + 1, cposy + 1, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + 1, cposy + 1, cposz + width / 2, 5, 3);
        chest = this.getChestTileEntity(world, cposx + 1, cposy + 1, cposz + width / 2);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.ThePrincessEgg, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
        world.setBlock(cposx + width - 2, cposy + 1, cposz + width / 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width - 2, cposy + 1, cposz + width / 2, 4, 3);
        chest = this.getChestTileEntity(world, cposx + width - 2, cposy + 1, cposz + width / 2);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack((Item) OreSpawnMain.QueenHelmet, 1, 0));
                chest.setInventorySlotContents(2, new ItemStack((Item) OreSpawnMain.QueenBody, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + 1, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + 1, 3, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + 1);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack((Item) OreSpawnMain.QueenLegs, 1, 0));
                chest.setInventorySlotContents(2, new ItemStack((Item) OreSpawnMain.QueenBoots, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
        world.setBlock(cposx + width / 2, cposy + 1, cposz + width - 2, (Block) Blocks.chest, 0, 2);
        world.setBlockMetadataWithNotify(cposx + width / 2, cposy + 1, cposz + width - 2, 2, 3);
        chest = this.getChestTileEntity(world, cposx + width / 2, cposy + 1, cposz + width - 2);
        if (chest != null) {
            if (reward == 6) {
                chest.setInventorySlotContents(1, new ItemStack(OreSpawnMain.MyRoyal, 1, 0));
            } else {
                WeightedRandomChestContent
                    .generateChestContents(world.rand, chestContents, (IInventory) chest, 5 + world.rand.nextInt(7));
            }
        }
    }

    public void makeSpiderHangout(final World world, final int cposx, final int cposy, final int cposz) {
        Entity var8 = null;
        TileEntityMobSpawner tileentitymobspawner = null;
        for (int i = 0; i < 20; ++i) {
            for (int j = -1; j < 20; ++j) {
                for (int k = 0; k < 20; ++k) {
                    Block blk = Blocks.air;
                    if (j == -1) {
                        blk = Blocks.stone;
                    }
                    if (j == 0) {
                        blk = Blocks.gravel;
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, 0, 2);
                }
            }
        }
        for (int j = 1; j < 4; ++j) {
            int k = 0;
            int i = 0;
            world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Spider Driver");
            }
            k = 19;
            i = 19;
            world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Spider Driver");
            }
            k = 0;
            i = 19;
            world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Spider Driver");
            }
            k = 19;
            i = 0;
            world.setBlock(cposx + i, cposy + j, cposz + k, Blocks.mob_spawner, 0, 2);
            tileentitymobspawner = this.getSpawnerTileEntity(world, cposx + i, cposy + j, cposz + k);
            if (tileentitymobspawner != null) {
                tileentitymobspawner.func_145881_a()
                    .setEntityName("Spider Driver");
            }
        }
        var8 = EntityList.createEntityByName("Robot Spider", world);
        if (var8 != null) {
            var8.setLocationAndAngles(
                (double) (cposx + 10),
                (double) (cposy + 1),
                (double) (cposz + 10),
                world.rand.nextFloat() * 360.0f,
                0.0f);
            world.spawnEntityInWorld(var8);
        }
    }

    public void makeRedAntHangout(final World world, final int cposx, final int cposy, final int cposz) {
        Entity var8 = null;
        for (int i = 0; i < 16; ++i) {
            for (int j = -1; j < 16; ++j) {
                for (int k = 0; k < 16; ++k) {
                    Block blk = Blocks.air;
                    if (j == -1) {
                        blk = Blocks.stone;
                    }
                    if (j == 0) {
                        blk = Blocks.gravel;
                        if ((i < 3 || i > 12) && (k < 3 || k > 12)) {
                            blk = OreSpawnMain.MyRedAntBlock;
                        }
                    }
                    OreSpawnMain.setBlockFast(world, cposx + i, cposy + j, cposz + k, blk, 0, 2);
                }
            }
        }
        var8 = EntityList.createEntityByName("Robot Red Ant", world);
        if (var8 != null) {
            var8.setLocationAndAngles(
                (double) (cposx + 8),
                (double) (cposy + 1),
                (double) (cposz + 8),
                world.rand.nextFloat() * 360.0f,
                0.0f);
            world.spawnEntityInWorld(var8);
        }
    }
}
