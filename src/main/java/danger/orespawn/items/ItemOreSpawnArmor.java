
package danger.orespawn.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import danger.orespawn.utils.ArmorStats;

public class ItemOreSpawnArmor extends ItemArmor {

    private int armor_material;
    private int armor_type;
    private int original_d;

    public ItemOreSpawnArmor(final int par1, final ItemArmor.ArmorMaterial par2EnumArmorMaterial, final int par3,
        final int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        this.armor_material = 0;
        this.armor_type = 0;
        this.original_d = 0;
        this.setCreativeTab(CreativeTabs.tabCombat);
        this.armor_material = 0;
        if (par2EnumArmorMaterial == OreSpawnMain.armorLAVAEEL) {
            this.armor_material = 1;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorMOTHSCALE) {
            this.armor_material = 2;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorEMERALD) {
            this.armor_material = 3;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorEXPERIENCE) {
            this.armor_material = 4;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorRUBY) {
            this.armor_material = 5;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorAMETHYST) {
            this.armor_material = 6;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorPINK) {
            this.armor_material = 7;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorTIGERSEYE) {
            this.armor_material = 8;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorPEACOCK) {
            this.armor_material = 9;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorMOBZILLA) {
            this.armor_material = 10;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorROYAL) {
            this.armor_material = 11;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorLAPIS) {
            this.armor_material = 12;
        }
        if (par2EnumArmorMaterial == OreSpawnMain.armorQUEEN) {
            this.armor_material = 13;
        }
        this.armor_type = par4;
        this.original_d = this.damageReduceAmount;
    }

    public int get_armor_material() {
        return this.armor_material;
    }

    public int get_armor_type() {
        return this.armor_type;
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        ArmorStats a = null;
        if (this.armor_material == 0) {
            a = OreSpawnMain.Ultimate_armorstats;
        }
        if (this.armor_material == 1) {
            a = OreSpawnMain.LavaEel_armorstats;
        }
        if (this.armor_material == 2) {
            a = OreSpawnMain.MothScale_armorstats;
        }
        if (this.armor_material == 3) {
            a = OreSpawnMain.Emerald_armorstats;
        }
        if (this.armor_material == 4) {
            a = OreSpawnMain.Experience_armorstats;
        }
        if (this.armor_material == 5) {
            a = OreSpawnMain.Ruby_armorstats;
        }
        if (this.armor_material == 6) {
            a = OreSpawnMain.Amethyst_armorstats;
        }
        if (this.armor_material == 7) {
            a = OreSpawnMain.Pink_armorstats;
        }
        if (this.armor_material == 8) {
            a = OreSpawnMain.TigersEye_armorstats;
        }
        if (this.armor_material == 9) {
            a = OreSpawnMain.Peacock_armorstats;
        }
        if (this.armor_material == 10) {
            a = OreSpawnMain.Mobzilla_armorstats;
        }
        if (this.armor_material == 11) {
            a = OreSpawnMain.Royal_armorstats;
        }
        if (this.armor_material == 12) {
            a = OreSpawnMain.Lapis_armorstats;
        }
        if (this.armor_material == 13) {
            a = OreSpawnMain.Queen_armorstats;
        }
        if (a != null) {
            if (a.e_protection != 0) {
                par1ItemStack.addEnchantment(Enchantment.protection, a.e_protection);
            }
            if (a.e_fireprotection != 0) {
                par1ItemStack.addEnchantment(Enchantment.fireProtection, a.e_fireprotection);
            }
            if (a.e_blastprotection != 0) {
                par1ItemStack.addEnchantment(Enchantment.blastProtection, a.e_blastprotection);
            }
            if (a.e_projectileprotection != 0) {
                par1ItemStack.addEnchantment(Enchantment.projectileProtection, a.e_projectileprotection);
            }
            if (a.e_unbreaking != 0) {
                par1ItemStack.addEnchantment(Enchantment.unbreaking, a.e_unbreaking);
            }
            if (this.armor_type == 3 && a.e_featherfalling != 0) {
                par1ItemStack.addEnchantment(Enchantment.featherFalling, a.e_featherfalling);
            }
            if (this.armor_type == 0) {
                if (a.e_respiration != 0) {
                    par1ItemStack.addEnchantment(Enchantment.respiration, a.e_respiration);
                }
                if (a.e_aquaaffinity != 0) {
                    par1ItemStack.addEnchantment(Enchantment.aquaAffinity, a.e_aquaaffinity);
                }
            }
        }
    }

    public void onUpdate(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4,
        final boolean par5) {
        ArmorStats a = null;
        int lvl = 0;
        int enchanted = 0;
        if (this.armor_material == 0) {
            a = OreSpawnMain.Ultimate_armorstats;
        }
        if (this.armor_material == 1) {
            a = OreSpawnMain.LavaEel_armorstats;
        }
        if (this.armor_material == 2) {
            a = OreSpawnMain.MothScale_armorstats;
        }
        if (this.armor_material == 3) {
            a = OreSpawnMain.Emerald_armorstats;
        }
        if (this.armor_material == 4) {
            a = OreSpawnMain.Experience_armorstats;
        }
        if (this.armor_material == 5) {
            a = OreSpawnMain.Ruby_armorstats;
        }
        if (this.armor_material == 6) {
            a = OreSpawnMain.Amethyst_armorstats;
        }
        if (this.armor_material == 7) {
            a = OreSpawnMain.Pink_armorstats;
        }
        if (this.armor_material == 8) {
            a = OreSpawnMain.TigersEye_armorstats;
        }
        if (this.armor_material == 9) {
            a = OreSpawnMain.Peacock_armorstats;
        }
        if (this.armor_material == 10) {
            a = OreSpawnMain.Mobzilla_armorstats;
        }
        if (this.armor_material == 11) {
            a = OreSpawnMain.Royal_armorstats;
        }
        if (this.armor_material == 12) {
            a = OreSpawnMain.Lapis_armorstats;
        }
        if (this.armor_material == 13) {
            a = OreSpawnMain.Queen_armorstats;
        }
        if (a != null) {
            enchanted = a.e_aquaaffinity + a.e_blastprotection + a.e_featherfalling + a.e_fireprotection;
            enchanted += a.e_projectileprotection + a.e_protection + a.e_respiration + a.e_unbreaking;
            if (enchanted > 0) {
                lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.protection.effectId, stack);
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireProtection.effectId, stack);
                }
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.blastProtection.effectId, stack);
                }
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.projectileProtection.effectId, stack);
                }
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.respiration.effectId, stack);
                }
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.aquaAffinity.effectId, stack);
                }
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.effectId, stack);
                }
                if (lvl <= 0) {
                    lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.featherFalling.effectId, stack);
                }
                if (lvl == 0) {
                    if (a.e_protection != 0) {
                        stack.addEnchantment(Enchantment.protection, a.e_protection);
                    }
                    if (a.e_fireprotection != 0) {
                        stack.addEnchantment(Enchantment.fireProtection, a.e_fireprotection);
                    }
                    if (a.e_blastprotection != 0) {
                        stack.addEnchantment(Enchantment.blastProtection, a.e_blastprotection);
                    }
                    if (a.e_projectileprotection != 0) {
                        stack.addEnchantment(Enchantment.projectileProtection, a.e_projectileprotection);
                    }
                    if (a.e_unbreaking != 0) {
                        stack.addEnchantment(Enchantment.unbreaking, a.e_unbreaking);
                    }
                    if (this.armor_type == 3 && a.e_featherfalling != 0) {
                        stack.addEnchantment(Enchantment.featherFalling, a.e_featherfalling);
                    }
                    if (this.armor_type == 0) {
                        if (a.e_respiration != 0) {
                            stack.addEnchantment(Enchantment.respiration, a.e_respiration);
                        }
                        if (a.e_aquaaffinity != 0) {
                            stack.addEnchantment(Enchantment.aquaAffinity, a.e_aquaaffinity);
                        }
                    }
                }
            }
        }
    }

    public String getArmorTexture(final ItemStack armor, final Entity e, final int slot, final String layer) {
        if (this.armor_type == 0 || this.armor_type == 1 || this.armor_type == 3) {
            if (this.armor_material == 0) {
                return "orespawn:ultimate_1.png";
            }
            if (this.armor_material == 1) {
                return "orespawn:lavaeel_1.png";
            }
            if (this.armor_material == 2) {
                return "orespawn:mothscale_1.png";
            }
            if (this.armor_material == 4) {
                return "orespawn:experience_1.png";
            }
            if (this.armor_material == 5) {
                return "orespawn:ruby_1.png";
            }
            if (this.armor_material == 6) {
                return "orespawn:amethyst_1.png";
            }
            if (this.armor_material == 7) {
                return "orespawn:pink_1.png";
            }
            if (this.armor_material == 8) {
                return "orespawn:tigerseye_1.png";
            }
            if (this.armor_material == 9) {
                return "orespawn:peacock_1.png";
            }
            if (this.armor_material == 10) {
                return "orespawn:mobzilla_1.png";
            }
            if (this.armor_material == 11) {
                return "orespawn:royal_1.png";
            }
            if (this.armor_material == 12) {
                return "orespawn:lapis_1.png";
            }
            if (this.armor_material == 13) {
                return "orespawn:queen_1.png";
            }
            return "orespawn:emerald_1.png";
        } else {
            if (this.armor_material == 0) {
                return "orespawn:ultimate_2.png";
            }
            if (this.armor_material == 1) {
                return "orespawn:lavaeel_2.png";
            }
            if (this.armor_material == 2) {
                return "orespawn:mothscale_2.png";
            }
            if (this.armor_material == 4) {
                return "orespawn:experience_2.png";
            }
            if (this.armor_material == 5) {
                return "orespawn:ruby_2.png";
            }
            if (this.armor_material == 6) {
                return "orespawn:amethyst_2.png";
            }
            if (this.armor_material == 7) {
                return "orespawn:pink_2.png";
            }
            if (this.armor_material == 8) {
                return "orespawn:tigerseye_2.png";
            }
            if (this.armor_material == 9) {
                return "orespawn:peacock_2.png";
            }
            if (this.armor_material == 10) {
                return "orespawn:mobzilla_2.png";
            }
            if (this.armor_material == 11) {
                return "orespawn:royal_2.png";
            }
            if (this.armor_material == 12) {
                return "orespawn:lapis_2.png";
            }
            if (this.armor_material == 13) {
                return "orespawn:queen_2.png";
            }
            return "orespawn:emerald_2.png";
        }
    }

    public void onArmorTick(final World world, final EntityPlayer player, final ItemStack itemStack) {
        ItemStack boots = null;
        final Item ia = null;
        final ItemOreSpawnArmor it = null;
        if ((this.armor_material == 11 || this.armor_material == 9) && player != null) {
            boots = player.getEquipmentInSlot(1);
            if (boots != null && ((boots.getItem() == OreSpawnMain.RoyalBoots && OreSpawnMain.RoyalGlideEnable != 0)
                || boots.getItem() == OreSpawnMain.PeacockFeatherBoots)) {
                if (player.motionY < -0.10000000149011612) {
                    player.motionY = -0.10000000149011612;
                }
                player.fallDistance = 0.0f;
            }
        }
        if (this.armor_material == 13 && player != null) {
            boots = player.getEquipmentInSlot(1);
            if (boots != null && boots.getItem() == OreSpawnMain.QueenBoots && OreSpawnMain.RoyalGlideEnable != 0) {
                if (player.motionY < -0.25) {
                    player.motionY = -0.25;
                }
                player.fallDistance = 0.0f;
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
