
package danger.orespawn.items;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemSifter extends Item {

    public ItemSifter(final int i) {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.tabDecorations);
        this.setMaxDamage(600);
    }

    private void dropItemRand(final Item index, final int par1, final World world, final int x, final int y,
        final int z) {
        final EntityItem var3 = new EntityItem(
            world,
            x + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2) + 0.5,
            y + 1.1,
            z + OreSpawnMain.OreSpawnRand.nextInt(2) - OreSpawnMain.OreSpawnRand.nextInt(2) + 0.5,
            new ItemStack(index, par1, 0));
        world.spawnEntityInWorld(var3);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        final int par4, final int par5, final int par6, final int par7, final float par8, final float par9,
        final float par10) {
        if (par3World.isRemote) {
            return true;
        }
        Block bid = par3World.getBlock(par4, par5, par6);
        final Block bid2 = par3World.getBlock(par4, par5 + 1, par6);
        if (bid2 == Blocks.flowing_water) {
            bid = Blocks.water;
        }
        if (bid2 == Blocks.water) {
            bid = Blocks.water;
        }
        if (bid == Blocks.water) {
            final int i = par3World.rand.nextInt(160);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.fish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(OreSpawnMain.MyGreenFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(OreSpawnMain.MyBlueFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(OreSpawnMain.MyPinkFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(OreSpawnMain.MyRockFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(OreSpawnMain.MyWoodFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(OreSpawnMain.MyGreyFish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.iron_ingot, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.gold_nugget, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_1, 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_2, 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_3, 1, par3World, par4, par5, par6);
                    break;
                }
                case 14: {
                    this.dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 15: {
                    this.dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
                    break;
                }
                case 16: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.stone), 1, par3World, par4, par5, par6);
                    break;
                }
                case 17: {
                    this.dropItemRand(Items.bucket, 1, par3World, par4, par5, par6);
                    break;
                }
                case 18: {
                    this.dropItemRand(Items.water_bucket, 1, par3World, par4, par5, par6);
                    break;
                }
                case 19: {
                    if (par3World.rand.nextInt(3) == 1) {
                        this.dropItemRand(Items.emerald, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
                case 20: {
                    if (par3World.rand.nextInt(3) == 1) {
                        this.dropItemRand(OreSpawnMain.MyRuby, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
                case 21: {
                    if (par3World.rand.nextInt(3) == 1) {
                        this.dropItemRand(OreSpawnMain.MyAmethyst, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
                case 22: {
                    this.dropItemRand(OreSpawnMain.MyMothScale, 1, par3World, par4, par5, par6);
                    break;
                }
                case 23: {
                    this.dropItemRand(OreSpawnMain.UraniumNugget, 1, par3World, par4, par5, par6);
                    break;
                }
                case 24: {
                    this.dropItemRand(OreSpawnMain.TitaniumNugget, 1, par3World, par4, par5, par6);
                    break;
                }
                case 25: {
                    if (par3World.rand.nextInt(2) == 1) {
                        this.dropItemRand(Items.diamond, 1, par3World, par4, par5, par6);
                        break;
                    }
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
                case 26: {
                    this.dropItemRand(Items.iron_ingot, 1, par3World, par4, par5, par6);
                    break;
                }
                case 27: {
                    this.dropItemRand(Items.gold_nugget, 1, par3World, par4, par5, par6);
                    break;
                }
                case 28: {
                    this.dropItemRand(Items.redstone, 1, par3World, par4, par5, par6);
                    break;
                }
                case 29: {
                    this.dropItemRand(Items.coal, 1, par3World, par4, par5, par6);
                    break;
                }
                case 30: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes, 1, par3World, par4, par5, par6);
                    break;
                }
                case 31: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_1, 1, par3World, par4, par5, par6);
                    break;
                }
                case 32: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_2, 1, par3World, par4, par5, par6);
                    break;
                }
                case 33: {
                    this.dropItemRand(OreSpawnMain.MyItemShoes_3, 1, par3World, par4, par5, par6);
                    break;
                }
                case 34: {
                    this.dropItemRand(Items.fish, 1, par3World, par4, par5, par6);
                    break;
                }
                case 35: {
                    this.dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 36: {
                    this.dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
                    break;
                }
                case 37: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.stone), 1, par3World, par4, par5, par6);
                    break;
                }
                case 38: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.stone_button), 1, par3World, par4, par5, par6);
                    break;
                }
                case 39: {
                    this.dropItemRand(Items.bucket, 1, par3World, par4, par5, par6);
                    break;
                }
                case 40: {
                    this.dropItemRand(Items.water_bucket, 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.sand) {
            final int i = par3World.rand.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.iron_horse_armor, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(Items.shears, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(Items.carrot_on_a_stick, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Items.poisonous_potato, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Items.item_frame, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(Items.compass, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.saddle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.iron_helmet, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Items.iron_chestplate, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Items.iron_leggings, 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(Items.iron_boots, 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(Item.getItemFromBlock((Block) Blocks.sand), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.gravel) {
            final int i = par3World.rand.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.flint, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(OreSpawnMain.MySalt, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(Items.flint_and_steel, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Items.spider_eye, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Items.item_frame, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Items.feather, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(Items.string, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.lead, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.name_tag, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Item.getItemFromBlock((Block) Blocks.sand), 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.dirt) {
            final int i = par3World.rand.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(Items.string, 1, par3World, par4, par5, par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(OreSpawnMain.MySalt, 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(Items.shears, 1, par3World, par4, par5, par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(Items.stick, 1, par3World, par4, par5, par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(Items.bowl, 1, par3World, par4, par5, par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(Items.flower_pot, 1, par3World, par4, par5, par6);
                    break;
                }
                case 6: {
                    this.dropItemRand(Items.sign, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.brick, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.paper, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.bone, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Items.glass_bottle, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Item.getItemFromBlock((Block) Blocks.sand), 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.dirt), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        if (bid == Blocks.grass) {
            final int i = par3World.rand.nextInt(60);
            switch (i) {
                case 0: {
                    this.dropItemRand(
                        Item.getItemFromBlock((Block) Blocks.yellow_flower),
                        1,
                        par3World,
                        par4,
                        par5,
                        par6);
                    break;
                }
                case 1: {
                    this.dropItemRand(Item.getItemFromBlock((Block) Blocks.red_flower), 1, par3World, par4, par5, par6);
                    break;
                }
                case 2: {
                    this.dropItemRand(
                        Item.getItemFromBlock(OreSpawnMain.MyFlowerPinkBlock),
                        1,
                        par3World,
                        par4,
                        par5,
                        par6);
                    break;
                }
                case 3: {
                    this.dropItemRand(
                        Item.getItemFromBlock(OreSpawnMain.MyFlowerBlueBlock),
                        1,
                        par3World,
                        par4,
                        par5,
                        par6);
                    break;
                }
                case 4: {
                    this.dropItemRand(
                        Item.getItemFromBlock(OreSpawnMain.MyFlowerBlackBlock),
                        1,
                        par3World,
                        par4,
                        par5,
                        par6);
                    break;
                }
                case 5: {
                    this.dropItemRand(
                        Item.getItemFromBlock(OreSpawnMain.MyFlowerScaryBlock),
                        1,
                        par3World,
                        par4,
                        par5,
                        par6);
                }
                case 6: {
                    this.dropItemRand(Items.wheat, 1, par3World, par4, par5, par6);
                    break;
                }
                case 7: {
                    this.dropItemRand(Items.pumpkin_seeds, 1, par3World, par4, par5, par6);
                    break;
                }
                case 8: {
                    this.dropItemRand(Items.melon_seeds, 1, par3World, par4, par5, par6);
                    break;
                }
                case 9: {
                    this.dropItemRand(Items.carrot, 1, par3World, par4, par5, par6);
                    break;
                }
                case 10: {
                    this.dropItemRand(Items.potato, 1, par3World, par4, par5, par6);
                    break;
                }
                case 11: {
                    this.dropItemRand(Item.getItemFromBlock((Block) Blocks.deadbush), 1, par3World, par4, par5, par6);
                    break;
                }
                case 12: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.gravel), 1, par3World, par4, par5, par6);
                    break;
                }
                case 13: {
                    this.dropItemRand(Item.getItemFromBlock(Blocks.dirt), 1, par3World, par4, par5, par6);
                    break;
                }
                case 14: {
                    this.dropItemRand(Item.getItemFromBlock((Block) Blocks.grass), 1, par3World, par4, par5, par6);
                    break;
                }
            }
        }
        par1ItemStack.damageItem(1, par2EntityPlayer);
        return true;
    }

    public String getMaterialName() {
        return "Unknown";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
