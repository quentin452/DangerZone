
package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSpawnEgg extends Item {

    public int my_id;

    public ItemSpawnEgg(final int i, final int j) {
        this.my_id = 0;
        this.my_id = j;
        this.maxStackSize = 64;
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    public boolean onItemUse(final ItemStack par1ItemStack, final EntityPlayer par2EntityPlayer, final World par3World,
        final int par4, final int par5, final int par6, final int par7, final float par8, final float par9,
        final float par10) {
        if (par3World.isRemote) {
            return true;
        }
        final Entity ent = spawn_something(this.my_id, par3World, par4 + 0.5, par5 + 1.01, par6 + 0.5);
        if (ent != null && ent instanceof EntityLiving && par1ItemStack.hasDisplayName()) {
            ((EntityLiving) ent).setCustomNameTag(par1ItemStack.getDisplayName());
        }
        if (!par2EntityPlayer.capabilities.isCreativeMode) {
            --par1ItemStack.stackSize;
        }
        return true;
    }

    public static Entity spawn_something(final int id, final World world, final double d0, final double d1,
        final double d2) {
        int entityID = 0;
        int skelly_type = 0;
        String name = null;
        switch (id) {
            case 192: {
                skelly_type = 1;
                entityID = 51;
                break;
            }
            case 193: {
                entityID = 63;
                break;
            }
            case 194: {
                entityID = 97;
                break;
            }
            case 195: {
                entityID = 99;
                break;
            }
            case 196: {
                entityID = 64;
                break;
            }
            case 197: {
                name = "Girlfriend";
                break;
            }
            case 198: {
                name = "Apple Cow";
                break;
            }
            case 363: {
                name = "Crystal Apple Cow";
                break;
            }
            case 199: {
                name = "Golden Apple Cow";
                break;
            }
            case 200: {
                name = "Enchanted Golden Apple Cow";
                break;
            }
            case 202: {
                name = "Alosaurus";
                break;
            }
            case 203: {
                name = "Cryolophosaurus";
                break;
            }
            case 204: {
                name = "Camarasaurus";
                break;
            }
            case 205: {
                name = "Velocity Raptor";
                break;
            }
            case 206: {
                name = "Hydrolisc";
                break;
            }
            case 207: {
                name = "Basilisk";
                break;
            }
            case 201: {
                name = "Mothra";
                break;
            }
            case 221: {
                name = "Dragonfly";
                break;
            }
            case 223: {
                name = "Emperor Scorpion";
                break;
            }
            case 225: {
                name = "Scorpion";
                break;
            }
            case 227: {
                name = "CaveFisher";
                break;
            }
            case 229: {
                name = "Baby Dragon";
                break;
            }
            case 231: {
                name = "Baryonyx";
                break;
            }
            case 233: {
                name = "WTF?";
                break;
            }
            case 235: {
                name = "Bird";
                break;
            }
            case 237: {
                name = "Kyuubi";
                break;
            }
            case 239: {
                name = "Alien";
                break;
            }
            case 241: {
                name = "Attack Squid";
                break;
            }
            case 243: {
                name = "Water Dragon";
                break;
            }
            case 245: {
                name = "The Kraken";
                break;
            }
            case 247: {
                name = "Lizard";
                break;
            }
            case 249: {
                name = "Cephadrome";
                break;
            }
            case 251: {
                name = "Dragon";
                break;
            }
            case 254: {
                name = "Bee";
                break;
            }
            case 262: {
                name = "Jumpy Bug";
                break;
            }
            case 263: {
                name = "Spit Bug";
                break;
            }
            case 264: {
                name = "Stink Bug";
                break;
            }
            case 265: {
                name = "Ostrich";
                break;
            }
            case 266: {
                name = "Gazelle";
                break;
            }
            case 267: {
                name = "Chipmunk";
                break;
            }
            case 274: {
                name = "Creeping Horror";
                break;
            }
            case 275: {
                name = "Terrible Terror";
                break;
            }
            case 276: {
                name = "Cliff Racer";
                break;
            }
            case 277: {
                name = "Triffid";
                break;
            }
            case 278: {
                name = "Nightmare";
                break;
            }
            case 279: {
                name = "Lurking Terror";
                break;
            }
            case 288: {
                name = "Small Worm";
                break;
            }
            case 289: {
                name = "Medium Worm";
                break;
            }
            case 290: {
                name = "Large Worm";
                break;
            }
            case 291: {
                name = "Cassowary";
                break;
            }
            case 292: {
                name = "Cloud Shark";
                break;
            }
            case 293: {
                name = "Gold Fish";
                break;
            }
            case 294: {
                name = "Leaf Monster";
                break;
            }
            case 295: {
                name = "T-Shirt";
                break;
            }
            case 280: {
                name = "Mobzilla";
                break;
            }
            case 298: {
                name = "Ender Knight";
                break;
            }
            case 299: {
                name = "Ender Reaper";
                break;
            }
            case 301: {
                name = "Beaver";
                break;
            }
            case 306: {
                name = "Dungeon Beast";
                break;
            }
            case 303: {
                name = "Vortex";
                break;
            }
            case 302: {
                name = "Rotator";
                break;
            }
            case 304: {
                name = "Peacock";
                break;
            }
            case 305: {
                name = "Fairy";
                break;
            }
            case 307: {
                name = "Rat";
                break;
            }
            case 308: {
                name = "Flounder";
                break;
            }
            case 309: {
                name = "Whale";
                break;
            }
            case 310: {
                name = "Irukandji";
                break;
            }
            case 311: {
                name = "Skate";
                break;
            }
            case 312: {
                name = "Crystal Urchin";
                break;
            }
            case 324: {
                name = "Bomb-Omb";
                break;
            }
            case 325: {
                name = "Robo-Pounder";
                break;
            }
            case 326: {
                name = "Robo-Gunner";
                break;
            }
            case 327: {
                name = "Robo-Warrior";
                break;
            }
            case 328: {
                name = "Ghost";
                break;
            }
            case 329: {
                name = "Ghost Pumpkin Skelly";
                break;
            }
            case 330: {
                name = "Ant";
                break;
            }
            case 331: {
                name = "Red Ant";
                break;
            }
            case 332: {
                name = "Rainbow Ant";
                break;
            }
            case 333: {
                name = "Unstable Ant";
                break;
            }
            case 334: {
                name = "Termite";
                break;
            }
            case 335: {
                name = "Butterfly";
                break;
            }
            case 336: {
                name = "Moth";
                break;
            }
            case 337: {
                name = "Mosquito";
                break;
            }
            case 338: {
                name = "Firefly";
                break;
            }
            case 339: {
                name = "T. Rex";
                break;
            }
            case 340: {
                name = "Hercules Beetle";
                break;
            }
            case 341: {
                name = "Mantis";
                break;
            }
            case 342: {
                name = "Stinky";
                break;
            }
            case 343: {
                name = "Robo-Sniper";
                break;
            }
            case 344: {
                name = "Coin";
                break;
            }
            case 349: {
                name = "Boyfriend";
                break;
            }
            case 350: {
                name = "The King";
                break;
            }
            case 366: {
                name = "The Queen";
                break;
            }
            case 351: {
                name = "The Prince";
                break;
            }
            case 352: {
                name = "Easter Bunny";
                break;
            }
            case 353: {
                name = "Molenoid";
                break;
            }
            case 354: {
                name = "Sea Monster";
                break;
            }
            case 355: {
                name = "Sea Viper";
                break;
            }
            case 356: {
                name = "CaterKiller";
                break;
            }
            case 358: {
                name = "Leonopteryx";
                break;
            }
            case 360: {
                name = "Hammerhead";
                break;
            }
            case 362: {
                name = "Rubber Ducky";
                break;
            }
            case 365: {
                name = "Criminal";
                break;
            }
            case 367: {
                name = "Brutalfly";
                break;
            }
            case 368: {
                name = "Nastysaurus";
                break;
            }
            case 369: {
                name = "Pointysaurus";
                break;
            }
            case 370: {
                name = "Cricket";
                break;
            }
            case 371: {
                name = "The Princess";
                break;
            }
            case 372: {
                name = "Frog";
                break;
            }
            case 378: {
                name = "Jeffery";
                break;
            }
            case 379: {
                name = "Robot Red Ant";
                break;
            }
            case 380: {
                name = "Robot Spider";
                break;
            }
            case 381: {
                name = "Spider Driver";
                break;
            }
            case 383: {
                name = "Crab";
                break;
            }
        }
        Entity ent = null;
        if (entityID != 0 || name != null) {
            ent = spawnCreature(world, entityID, name, d0, d1, d2);
            if (ent != null && entityID == 51 && skelly_type != 0) {
                final EntitySkeleton sk = (EntitySkeleton) ent;
                sk.setSkeletonType(skelly_type);
            }
        }
        return ent;
    }

    public static Entity spawnCreature(final World par0World, final int par1, final String name, final double par2,
        final double par4, final double par6) {
        Entity var8 = null;
        if (name == null) {
            var8 = EntityList.createEntityByID(par1, par0World);
        } else {
            var8 = EntityList.createEntityByName(name, par0World);
        }
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
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
