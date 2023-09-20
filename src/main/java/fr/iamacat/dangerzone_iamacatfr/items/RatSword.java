package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Rat;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class RatSword extends ItemSword {

    private int weaponDamage;
    private final ToolMaterial toolMaterial;

    public RatSword(final ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.toolMaterial = par2EnumToolMaterial;
        this.weaponDamage = 15;
        this.maxStackSize = 1;
        this.setMaxDamage(1300);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public String getMaterialName() {
        return "Rat";
    }

    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLivingBase par2EntityLiving,
        final EntityLivingBase par3EntityLiving) {
        final int var2 = 5;
        if (par2EntityLiving != null && !par2EntityLiving.worldObj.isRemote) {
            for (int num = 1 + par2EntityLiving.worldObj.rand.nextInt(6), i = 0; i < num; ++i) {
                Rat r = null;
                r = (Rat) spawnCreature(
                    par2EntityLiving.worldObj,
                    0,
                    "Rat",
                    par2EntityLiving.posX
                        + (par2EntityLiving.worldObj.rand.nextFloat() - par2EntityLiving.worldObj.rand.nextFloat())
                            * 0.5,
                    par2EntityLiving.posY + par2EntityLiving.worldObj.rand.nextFloat() + 0.01,
                    par2EntityLiving.posZ
                        + (par2EntityLiving.worldObj.rand.nextFloat() - par2EntityLiving.worldObj.rand.nextFloat())
                            * 0.5);
                if (r != null) {
                    r.setOwner(par3EntityLiving);
                }
            }
        }
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
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

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 3000;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
