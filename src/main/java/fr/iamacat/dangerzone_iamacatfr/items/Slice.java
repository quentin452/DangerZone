
package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.BerthaHit;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Boyfriend;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Girlfriend;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class Slice extends ItemSword {

    public Slice(final int par1, final ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.maxStackSize = 1;
        this.setMaxDamage(2600);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        par1ItemStack.addEnchantment(Enchantment.sharpness, 5);
        par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, 1);
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.sharpness.effectId, stack);
        if (lvl <= 0) {
            stack.addEnchantment(Enchantment.sharpness, 5);
            stack.addEnchantment(Enchantment.baneOfArthropods, 1);
        }
    }

    public void onUpdate(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4,
        final boolean par5) {
        this.onUsingTick(stack, null, 0);
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        return entity != null
            && (entity instanceof EntityPlayer || entity instanceof Girlfriend || entity instanceof Boyfriend);
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (entityLiving != null && entityLiving instanceof EntityPlayer) {
            final EntityPlayer p = (EntityPlayer) entityLiving;
            final double xzoff = 2.0;
            final double yoff = 1.55;
            final BerthaHit lb = new BerthaHit(p.worldObj, p);
            lb.setLocationAndAngles(
                p.posX - xzoff * Math.sin(Math.toRadians(p.rotationYawHead)),
                p.posY + yoff,
                p.posZ + xzoff * Math.cos(Math.toRadians(p.rotationYawHead)),
                p.rotationYawHead,
                p.rotationPitch);
            final BerthaHit berthaHit = lb;
            berthaHit.motionX *= 2.0;
            final BerthaHit berthaHit2 = lb;
            berthaHit2.motionY *= 2.0;
            final BerthaHit berthaHit3 = lb;
            berthaHit3.motionZ *= 2.0;
            p.worldObj.spawnEntityInWorld(lb);
            stack.damageItem(1, p);
        }
        return false;
    }

    public String getMaterialName() {
        return "Uranium/Titanium";
    }

    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving,
        final EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 9000;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
