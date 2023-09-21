package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.BoyfriendInstance;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.GirlfriendInstance;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class UltimateSword extends ItemSword {

    private int swingtimer;
    private boolean leaf;

    public UltimateSword(final ToolMaterial par2EnumToolMaterial) {
        super(par2EnumToolMaterial);
        this.swingtimer = 0;
        this.leaf = false;
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    public void onCreated(final ItemStack par1ItemStack, final World par2World, final EntityPlayer par3EntityPlayer) {
        if (this == ItemInitDangerZone.MyChainsaw) {
            return;
        }
        if (this != ItemInitDangerZone.BattleAxe) {
            par1ItemStack.addEnchantment(Enchantment.sharpness, DangerZone.UltimateSwordMagic);
            par1ItemStack.addEnchantment(Enchantment.smite, DangerZone.UltimateSwordMagic);
            par1ItemStack.addEnchantment(Enchantment.baneOfArthropods, DangerZone.UltimateSwordMagic);
            par1ItemStack.addEnchantment(Enchantment.knockback, 1 + DangerZone.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.looting, 1 + DangerZone.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.unbreaking, 1 + DangerZone.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.fireAspect, 1 + DangerZone.UltimateSwordMagic / 3);
        } else {
            par1ItemStack.addEnchantment(Enchantment.looting, 1 + DangerZone.UltimateSwordMagic / 2);
            par1ItemStack.addEnchantment(Enchantment.unbreaking, 1 + DangerZone.UltimateSwordMagic / 2);
        }
    }

    public boolean onEntitySwing(final EntityLivingBase entityLiving, final ItemStack stack) {
        if (this == ItemInitDangerZone.MyChainsaw && entityLiving != null && this.swingtimer == 0) {
            entityLiving
                .playSound(Tags.MODID + ":chainsawshort", 1.0f, entityLiving.worldObj.rand.nextFloat() * 0.2f + 0.9f);
            this.swingtimer = 50;
        }
        return false;
    }

    public void onUsingTick(final ItemStack stack, final EntityPlayer player, final int count) {
        if (this == ItemInitDangerZone.MyChainsaw) {
            return;
        }
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, stack);
        if (lvl <= 0) {
            if (this != ItemInitDangerZone.BattleAxe) {
                stack.addEnchantment(Enchantment.sharpness, DangerZone.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.smite, DangerZone.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.baneOfArthropods, DangerZone.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.knockback, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.looting, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.fireAspect, 1 + DangerZone.UltimateSwordMagic / 3);
            } else {
                stack.addEnchantment(Enchantment.looting, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + DangerZone.UltimateSwordMagic / 2);
            }
        }
    }

    public void onUpdate(final ItemStack stack, final World par2World, final Entity par3Entity, final int par4,
                         final boolean par5) {
        if (this == ItemInitDangerZone.MyChainsaw) {
            if (this.swingtimer > 0) {
                --this.swingtimer;
            }
            if (par2World.isRemote && this.swingtimer > 0) {
                final float f = 1.0f;
                final float dx = (float) (f * Math.cos(Math.toRadians(par3Entity.rotationYaw + 90.0f + 45.0f)));
                final float dz = (float) (f * Math.sin(Math.toRadians(par3Entity.rotationYaw + 90.0f + 45.0f)));
                if (par2World.rand.nextInt(8) == 0) {
                    par2World.spawnParticle(
                        "flame",
                        par3Entity.posX + dx,
                        par3Entity.posY,
                        par3Entity.posZ + dz,
                        ((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f),
                        (par2World.rand.nextFloat() / 10.0f),
                        ((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f));
                }
                if (par2World.rand.nextInt(2) == 0) {
                    par2World.spawnParticle(
                        "smoke",
                        par3Entity.posX + dx,
                        par3Entity.posY,
                        par3Entity.posZ + dz,
                        ((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f),
                        (par2World.rand.nextFloat() / 10.0f),
                        ((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f));
                }
                if (par2World.rand.nextInt(10) == 0) {
                    par2World.spawnParticle(
                        "fireworksSpark",
                        par3Entity.posX + dx,
                        par3Entity.posY,
                        par3Entity.posZ + dz,
                        ((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f),
                        (par2World.rand.nextFloat() / 5.0f),
                        ((par2World.rand.nextFloat() - par2World.rand.nextFloat()) / 20.0f));
                }
            }
            return;
        }
        final int lvl = EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, stack);
        if (lvl <= 0) {
            if (this != ItemInitDangerZone.BattleAxe) {
                stack.addEnchantment(Enchantment.sharpness, DangerZone.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.smite, DangerZone.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.baneOfArthropods, DangerZone.UltimateSwordMagic);
                stack.addEnchantment(Enchantment.knockback, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.looting, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.fireAspect, 1 + DangerZone.UltimateSwordMagic / 3);
            } else {
                stack.addEnchantment(Enchantment.looting, 1 + DangerZone.UltimateSwordMagic / 2);
                stack.addEnchantment(Enchantment.unbreaking, 1 + DangerZone.UltimateSwordMagic / 2);
            }
        }
    }

    public String getMaterialName() {
        return "Uranium/Titanium";
    }

    public boolean hitEntity(final ItemStack par1ItemStack, final EntityLiving par2EntityLiving,
                             final EntityLiving par3EntityLiving) {
        par1ItemStack.damageItem(1, par3EntityLiving);
        return true;
    }

    public boolean onLeftClickEntity(final ItemStack stack, final EntityPlayer player, final Entity entity) {
        if (entity != null) {
            if (entity instanceof EntityPlayer || entity instanceof GirlfriendInstance || entity instanceof BoyfriendInstance) {
                return true;
            }
            if (entity instanceof EntityTameable) {
                final EntityTameable t = (EntityTameable) entity;
                if (t.isTamed()) {
                    return true;
                }
            }
        }
        if (this == ItemInitDangerZone.MyChainsaw && player != null) {
            this.findSomethingToHit(player);
        }
        return false;
    }

    public int getMaxItemUseDuration(final ItemStack par1ItemStack) {
        return 9000;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(final IIconRegister iconRegister) {
        this.itemIcon = iconRegister.registerIcon(
              Tags.MODID + ":"  + this.getUnlocalizedName()
                .substring(5));
    }

    private void findSomethingToHit(final EntityPlayer player) {
        final List var5 = player.worldObj
            .getEntitiesWithinAABB(EntityLivingBase.class, player.boundingBox.expand(5.0, 5.0, 5.0));
        final Iterator var6 = var5.iterator();
        Entity var7 = null;
        EntityLivingBase var8 = null;
        while (var6.hasNext()) {
            var7 = (Entity) var6.next();
            var8 = (EntityLivingBase) var7;
            if (this.isSuitableTarget(var8, false, player)) {
                var8.attackEntityFrom(
                    DamageSource.causePlayerDamage(player),
                    (float) 56);
            }
        }
    }

    private boolean isSuitableTarget(final EntityLivingBase par1EntityLiving, final boolean par2,
                                     final EntityPlayer player) {
        if (par1EntityLiving == null) {
            return false;
        }
        if (par1EntityLiving == player) {
            return false;
        }
        if (!par1EntityLiving.isEntityAlive()) {
            return false;
        }
            if (par1EntityLiving instanceof EntityPlayer || par1EntityLiving instanceof GirlfriendInstance
                || par1EntityLiving instanceof BoyfriendInstance) {
                return false;
            }
            if (par1EntityLiving instanceof EntityTameable) {
                final EntityTameable t = (EntityTameable) par1EntityLiving;
                if (t.isTamed()) {
                    return false;
                }
            }
        return this.MyCanSee(par1EntityLiving, player);
    }

    public boolean MyCanSee(final EntityLivingBase e, final EntityPlayer player) {
        int nblks = 10;
        final double cx = player.posX;
        final double cz = player.posZ;
        float startx = (float) cx;
        float starty = (float) (player.posY + 1.399999976158142);
        float startz = (float) cz;
        float dx = (float) ((e.posX - startx) / 10.0);
        float dy = (float) ((e.posY + e.height / 2.0f - starty) / 10.0);
        float dz = (float) ((e.posZ - startz) / 10.0);
        if (Math.abs(dx) > 1.0) {
            dy /= Math.abs(dx);
            dz /= Math.abs(dx);
            nblks *= (int) Math.abs(dx);
            if (dx > 1.0f) {
                dx = 1.0f;
            }
            if (dx < -1.0f) {
                dx = -1.0f;
            }
        }
        if (Math.abs(dy) > 1.0) {
            dx /= Math.abs(dy);
            dz /= Math.abs(dy);
            nblks *= (int) Math.abs(dy);
            if (dy > 1.0f) {
                dy = 1.0f;
            }
            if (dy < -1.0f) {
                dy = -1.0f;
            }
        }
        if (Math.abs(dz) > 1.0) {
            dy /= Math.abs(dz);
            dx /= Math.abs(dz);
            nblks *= (int) Math.abs(dz);
            if (dz > 1.0f) {
                dz = 1.0f;
            }
            if (dz < -1.0f) {
                dz = -1.0f;
            }
        }
        for (int i = 0; i < nblks; ++i) {
            startx += dx;
            starty += dy;
            startz += dz;
            final Block bid = player.worldObj.getBlock((int) startx, (int) starty, (int) startz);
            if (bid != Blocks.air) {
                return false;
            }
        }
        return true;
    }

    public boolean canHarvestBlock(final Block par1Block) {
        return this.canCrush(par1Block);
    }

    private boolean canCrush(final Block blockID) {
        if (this == ItemInitDangerZone.MyChainsaw) {
            return blockID == Blocks.web || blockID == Blocks.log
                || blockID == Blocks.leaves
                || blockID == Blocks.planks
                || blockID == Blocks.sapling
                || blockID == Blocks.tallgrass
                || blockID == Blocks.cactus
                || blockID == BlockInitDangerZone.CrystalWood
                || blockID == BlockInitDangerZone.BlockAppleLeaves
                || blockID == BlockInitDangerZone.BlockSkyTreeLog
                || blockID == BlockInitDangerZone.BlockDuctTape
                || blockID == BlockInitDangerZone.BlockExperienceLeaves
                || blockID == BlockInitDangerZone.BlockScaryLeaves
                || blockID == BlockInitDangerZone.MyPeachLeaves
                || blockID == BlockInitDangerZone.MyCherryLeaves
                || blockID == BlockInitDangerZone.BlockCrystalLeaves
                || blockID == BlockInitDangerZone.BlockCrystalLeaves2
                || blockID == BlockInitDangerZone.BlockCrystalLeaves3
                || blockID == BlockInitDangerZone.BlockCrystalTreeLog;
        }
        return blockID == Blocks.web;
    }

    private boolean isLeaves(final Block blockID) {
        return blockID == Blocks.web || blockID == Blocks.leaves
            || blockID == Blocks.sapling
            || blockID == Blocks.tallgrass
            || blockID == BlockInitDangerZone.BlockAppleLeaves
            || blockID == BlockInitDangerZone.BlockExperienceLeaves
            || blockID == BlockInitDangerZone.BlockScaryLeaves
            || blockID == BlockInitDangerZone.MyPeachLeaves
            || blockID == BlockInitDangerZone.MyCherryLeaves
            || blockID == BlockInitDangerZone.BlockCrystalLeaves
            || blockID == BlockInitDangerZone.BlockCrystalLeaves2
            || blockID == BlockInitDangerZone.BlockCrystalLeaves3;
    }

    public boolean onBlockDestroyed(final ItemStack par1ItemStack, final World par2World, final Block par3,
                                    final int par4, final int par5, final int par6, final EntityLivingBase par7EntityLivingBase) {
        if (this == ItemInitDangerZone.MyChainsaw && !par2World.isRemote) {
            for (int i = -5; i <= 5; ++i) {
                for (int j = -5; j <= 10; ++j) {
                    for (int k = -5; k <= 5; ++k) {
                        final Block bid = par2World.getBlock(par4 + i, par5 + j, par6 + k);
                        if (this.leaf) {
                            if (this.isLeaves(bid)) {
                                this.dropItemRand(
                                    par2World,
                                    Item.getItemFromBlock(bid),
                                    1,
                                    par4 + i,
                                    par5 + j,
                                    par6 + k);
                                par2World.setBlock(par4 + i, par5 + j, par6 + k, Blocks.air);
                            }
                        } else if (this.canCrush(bid)) {
                            this.dropItemRand(par2World, Item.getItemFromBlock(bid), 1, par4 + i, par5 + j, par6 + k);
                            par2World.setBlock(par4 + i, par5 + j, par6 + k, Blocks.air);
                        }
                    }
                }
            }
        }
        return super.onBlockDestroyed(par1ItemStack, par2World, par3, par4, par5, par6, par7EntityLivingBase);
    }

    private ItemStack dropItemRand(final World world, final Item index, final int par1, final int x, final int y,
                                   final int z) {
        Random Rand = new Random();
        EntityItem var3;
        final ItemStack is = new ItemStack(index, par1, 0);
        var3 = new EntityItem(
            world,
            (x + Rand.nextInt(5) - Rand.nextInt(5)),
            y + 1.0 + world.rand.nextInt(5),
            (z + Rand.nextInt(5) - Rand.nextInt(5)),
            is);
        if (var3 != null) {
            world.spawnEntityInWorld(var3);
        }
        return is;
    }

    public float getStrVsBlock(final ItemStack par1ItemStack, final Block par2Block) {
        if (par2Block != null && this == ItemInitDangerZone.MyChainsaw) {
            this.leaf = this.isLeaves(par2Block);
            if (par2Block.getMaterial() == Material.wood || par2Block.getMaterial() == Material.plants
                || par2Block.getMaterial() == Material.vine) {
                return (float) 10;
            }
            if (this.canCrush(par2Block)) {
                return (float) 10;
            }
        }
        return 2.0f;
    }
}
