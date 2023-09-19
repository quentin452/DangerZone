
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityThrownRockInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.RockBase;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRock extends Item {

    public ItemRock() {
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
            if (this == ItemInitDangerZone.MySmallRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 1));
            }
            if (this == ItemInitDangerZone.MyRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 2));
            }
            if (this == ItemInitDangerZone.MyRedRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 3));
            }
            if (this == ItemInitDangerZone.MyGreenRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 4));
            }
            if (this == ItemInitDangerZone.MyBlueRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 5));
            }
            if (this == ItemInitDangerZone.MyPurpleRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 6));
            }
            if (this == ItemInitDangerZone.MySpikeyRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 7));
            }
            if (this == ItemInitDangerZone.MyTNTRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 8));
            }
            if (this == ItemInitDangerZone.MyCrystalRedRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 9));
            }
            if (this == ItemInitDangerZone.MyCrystalGreenRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 10));
            }
            if (this == ItemInitDangerZone.MyCrystalBlueRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 11));
            }
            if (this == ItemInitDangerZone.MyCrystalTNTRock) {
                par2World.spawnEntityInWorld(new EntityThrownRockInstance(par2World, par3EntityPlayer, 12));
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
                if (this == ItemInitDangerZone.MySmallRock) {
                    r.placeRock(1);
                }
                if (this == ItemInitDangerZone.MyRock) {
                    r.placeRock(2);
                }
                if (this == ItemInitDangerZone.MyRedRock) {
                    r.placeRock(3);
                }
                if (this == ItemInitDangerZone.MyGreenRock) {
                    r.placeRock(4);
                }
                if (this == ItemInitDangerZone.MyBlueRock) {
                    r.placeRock(5);
                }
                if (this == ItemInitDangerZone.MyPurpleRock) {
                    r.placeRock(6);
                }
                if (this == ItemInitDangerZone.MySpikeyRock) {
                    r.placeRock(7);
                }
                if (this == ItemInitDangerZone.MyTNTRock) {
                    r.placeRock(8);
                }
                if (this == ItemInitDangerZone.MyCrystalRedRock) {
                    r.placeRock(9);
                }
                if (this == ItemInitDangerZone.MyCrystalGreenRock) {
                    r.placeRock(10);
                }
                if (this == ItemInitDangerZone.MyCrystalBlueRock) {
                    r.placeRock(11);
                }
                if (this == ItemInitDangerZone.MyCrystalTNTRock) {
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
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
