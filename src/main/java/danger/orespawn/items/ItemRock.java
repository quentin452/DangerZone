
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.entities.entityinstance.EntityThrownRock;
import danger.orespawn.entities.entityinstance.RockBase;

public class ItemRock extends Item {

    public ItemRock(final int i) {
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public ItemStack onItemRightClick(final ItemStack par1ItemStack, final World par2World,
        final EntityPlayer par3EntityPlayer) {
        if (!par3EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        par2World.playSoundAtEntity(
            par3EntityPlayer,
            "random.bow",
            0.5f,
            0.4f / (ItemRock.itemRand.nextFloat() * 0.4f + 0.8f));
        if (!par2World.isRemote) {
            if (this == OreSpawnMain.MySmallRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 1));
            }
            if (this == OreSpawnMain.MyRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 2));
            }
            if (this == OreSpawnMain.MyRedRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 3));
            }
            if (this == OreSpawnMain.MyGreenRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 4));
            }
            if (this == OreSpawnMain.MyBlueRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 5));
            }
            if (this == OreSpawnMain.MyPurpleRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 6));
            }
            if (this == OreSpawnMain.MySpikeyRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 7));
            }
            if (this == OreSpawnMain.MyTNTRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 8));
            }
            if (this == OreSpawnMain.MyCrystalRedRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 9));
            }
            if (this == OreSpawnMain.MyCrystalGreenRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 10));
            }
            if (this == OreSpawnMain.MyCrystalBlueRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 11));
            }
            if (this == OreSpawnMain.MyCrystalTNTRock) {
                par2World.spawnEntityInWorld(new EntityThrownRock(par2World, par3EntityPlayer, 12));
            }
        }
        return par1ItemStack;
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World world,
        int x, final int y, int z, final int par7, final float par8, final float par9, final float par10) {
        if (!world.isRemote) {
            if (x < 0) {
                ++x;
            }
            if (z < 0) {
                ++z;
            }
            final Entity e = this.spawnCreature(world, "Rock", x, y + 1.01, z);
            if (e != null) {
                final RockBase r = (RockBase) e;
                if (this == OreSpawnMain.MySmallRock) {
                    r.placeRock(1);
                }
                if (this == OreSpawnMain.MyRock) {
                    r.placeRock(2);
                }
                if (this == OreSpawnMain.MyRedRock) {
                    r.placeRock(3);
                }
                if (this == OreSpawnMain.MyGreenRock) {
                    r.placeRock(4);
                }
                if (this == OreSpawnMain.MyBlueRock) {
                    r.placeRock(5);
                }
                if (this == OreSpawnMain.MyPurpleRock) {
                    r.placeRock(6);
                }
                if (this == OreSpawnMain.MySpikeyRock) {
                    r.placeRock(7);
                }
                if (this == OreSpawnMain.MyTNTRock) {
                    r.placeRock(8);
                }
                if (this == OreSpawnMain.MyCrystalRedRock) {
                    r.placeRock(9);
                }
                if (this == OreSpawnMain.MyCrystalGreenRock) {
                    r.placeRock(10);
                }
                if (this == OreSpawnMain.MyCrystalBlueRock) {
                    r.placeRock(11);
                }
                if (this == OreSpawnMain.MyCrystalTNTRock) {
                    r.placeRock(12);
                }
            }
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    private Entity spawnCreature(final World par0World, final String par1, double par2, final double par4,
        double par6) {
        Entity var8 = null;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            if (par2 > 0.0) {
                par2 += 0.5;
            }
            if (par2 < 0.0) {
                par2 -= 0.5;
            }
            if (par6 > 0.0) {
                par6 += 0.5;
            }
            if (par6 < 0.0) {
                par6 -= 0.5;
            }
            var8.setLocationAndAngles(par2, par4 + 0.01, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
