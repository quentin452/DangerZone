package fr.iamacat.dangerzone_iamacatfr.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.init.BlockInitDangerZone;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.TileEntityCrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class CrystalFurnace extends BlockContainer {

    private final Random furnaceRand;
    private final boolean isActive = false;
    private static boolean keepFurnaceInventory;
    @SideOnly(Side.CLIENT)
    private IIcon furnaceIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon furnaceIconFront;

    public CrystalFurnace(final int par1, final boolean par2, final float f1, final float f2) {
        super(Material.rock);
        this.furnaceRand = new Random();
        this.setHardness(f1);
        this.setResistance(f2);
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public Item getItemDropped(final int par1, final Random par2Random, final int par3) {
        return Item.getItemFromBlock(BlockInitDangerZone.ContainerCrystalFurnaceBlock);
    }

    @SideOnly(Side.CLIENT)
    public Item idPicked(final World par1World, final int par2, final int par3, final int par4) {
        return Item.getItemFromBlock(BlockInitDangerZone.ContainerCrystalFurnaceBlock);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, final int par2) {
        return (par1 == 1) ? this.furnaceIconTop
            : ((par1 == 0) ? this.furnaceIconTop : ((par1 != par2) ? this.blockIcon : this.furnaceIconFront));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IIconRegister) {
        this.blockIcon = par1IIconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5) + "_side");
        this.furnaceIconFront = par1IIconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5) + (this.isActive ? "_front_off" : "_front_off"));
        this.furnaceIconTop = par1IIconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5) + "_top");
    }

    public static void updateFurnaceBlockState(final boolean par0, final World par1World, final int par2,
                                               final int par3, final int par4) {
        final int l = par1World.getBlockMetadata(par2, par3, par4);
        final TileEntity tileentity = par1World.getTileEntity(par2, par3, par4);
        CrystalFurnace.keepFurnaceInventory = true;
        if (par0) {
            par1World.setBlock(par2, par3, par4, BlockInitDangerZone.ContainerCrystalFurnaceOnBlock);
        } else {
            par1World.setBlock(par2, par3, par4, BlockInitDangerZone.ContainerCrystalFurnaceBlock);
        }
        CrystalFurnace.keepFurnaceInventory = false;
        par1World.setBlockMetadataWithNotify(par2, par3, par4, l, 2);
        if (tileentity != null) {
            tileentity.validate();
            par1World.setTileEntity(par2, par3, par4, tileentity);
        }
    }

    public void onBlockAdded(final World par1World, final int par2, final int par3, final int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    private void setDefaultDirection(final World par1World, final int par2, final int par3, final int par4) {
        if (!par1World.isRemote) {
            final Block l = par1World.getBlock(par2, par3, par4 - 1);
            final Block i1 = par1World.getBlock(par2, par3, par4 + 1);
            final Block j1 = par1World.getBlock(par2 - 1, par3, par4);
            final Block k1 = par1World.getBlock(par2 + 1, par3, par4);
            byte b0 = 3;
            if (l.func_149730_j() && !i1.func_149730_j()) {
                b0 = 3;
            }
            if (i1.func_149730_j() && !l.func_149730_j()) {
                b0 = 2;
            }
            if (j1.func_149730_j() && !k1.func_149730_j()) {
                b0 = 5;
            }
            if (k1.func_149730_j() && !j1.func_149730_j()) {
                b0 = 4;
            }
            par1World.setBlockMetadataWithNotify(par2, par3, par4, (int) b0, 2);
        }
    }

    public boolean onBlockActivated(final World par1World, final int par2, final int par3, final int par4,
                                    final EntityPlayer par5EntityPlayer, final int par6, final float par7, final float par8, final float par9) {
        if (par1World.isRemote) {
            return true;
        }
        final TileEntityCrystalFurnace tileentitycrystalfurnace = (TileEntityCrystalFurnace) par1World
            .getTileEntity(par2, par3, par4);
        if (tileentitycrystalfurnace != null) {
            par5EntityPlayer.openGui(Tags.MODID, 0, par1World, par2, par3, par4);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
                                  final Random par5Random) {
        if (this.isActive) {
            final int l = par1World.getBlockMetadata(par2, par3, par4);
            final float f = par2 + 0.5f;
            final float f2 = par3 + 0.0f + par5Random.nextFloat() * 6.0f / 16.0f;
            final float f3 = par4 + 0.5f;
            final float f4 = par5Random.nextFloat() * 0.6f - 0.3f;
            final float f5 = par5Random.nextFloat() * 0.6f - 0.3f;
            if (l == 4) {
                par1World.spawnParticle("smoke", (f - f4), f2, (f3 + f5), 0.0, 0.0, 0.0);
                par1World.spawnParticle("flame", (f - f4), f2, (f3 + f5), 0.0, 0.0, 0.0);
            } else if (l == 5) {
                par1World.spawnParticle("smoke", (f + f4), f2, (f3 + f5), 0.0, 0.0, 0.0);
                par1World.spawnParticle("flame", (f + f4), f2, (f3 + f5), 0.0, 0.0, 0.0);
            } else if (l == 2) {
                par1World.spawnParticle("smoke", (f + f5), f2, (f3 - f4), 0.0, 0.0, 0.0);
                par1World.spawnParticle("flame", (f + f5), f2, (f3 - f4), 0.0, 0.0, 0.0);
            } else if (l == 3) {
                par1World.spawnParticle("smoke", (f + f5), f2, (f3 + f4), 0.0, 0.0, 0.0);
                par1World.spawnParticle("flame", (f + f5), f2, (f3 + f4), 0.0, 0.0, 0.0);
            }
        }
    }

    public void onBlockPlacedBy(final World par1World, final int par2, final int par3, final int par4,
                                final EntityLivingBase par5EntityLivingBase, final ItemStack par6ItemStack) {
        final int l = MathHelper.floor_double(par5EntityLivingBase.rotationYaw * 4.0f / 360.0f + 0.5) & 0x3;
        if (l == 0) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }
        if (l == 1) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }
        if (l == 2) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }
        if (l == 3) {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }
        if (par6ItemStack.hasDisplayName()) {
            ((TileEntityCrystalFurnace) par1World.getTileEntity(par2, par3, par4))
                .func_145951_a(par6ItemStack.getDisplayName());
        }
    }

    public void breakBlock(final World par1World, final int par2, final int par3, final int par4, final Block par5,
                           final int par6) {
        if (!CrystalFurnace.keepFurnaceInventory) {
            final TileEntityCrystalFurnace tileentitycrystalfurnace = (TileEntityCrystalFurnace) par1World
                .getTileEntity(par2, par3, par4);
            if (tileentitycrystalfurnace != null) {
                for (int j1 = 0; j1 < tileentitycrystalfurnace.getSizeInventory(); ++j1) {
                    final ItemStack itemstack = tileentitycrystalfurnace.getStackInSlot(j1);
                    if (itemstack != null) {
                        final float f = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                        final float f2 = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                        final float f3 = this.furnaceRand.nextFloat() * 0.8f + 0.1f;
                        while (itemstack.stackSize > 0) {
                            int k1 = this.furnaceRand.nextInt(21) + 10;
                            if (k1 > itemstack.stackSize) {
                                k1 = itemstack.stackSize;
                            }
                            final ItemStack itemStack = itemstack;
                            itemStack.stackSize -= k1;
                            final EntityItem entityitem = new EntityItem(
                                par1World,
                                (par2 + f),
                                (par3 + f2),
                                (par4 + f3),
                                new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
                            if (itemstack.hasTagCompound()) {
                                entityitem.getEntityItem()
                                    .setTagCompound(
                                        (NBTTagCompound) itemstack.getTagCompound()
                                            .copy());
                            }
                            final float f4 = 0.05f;
                            entityitem.motionX = (float) this.furnaceRand.nextGaussian() * f4;
                            entityitem.motionY = (float) this.furnaceRand.nextGaussian() * f4 + 0.2f;
                            entityitem.motionZ = (float) this.furnaceRand.nextGaussian() * f4;
                            par1World.spawnEntityInWorld(entityitem);
                        }
                    }
                }
                par1World.func_147453_f(par2, par3, par4, par5);
            }
        }
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    public boolean hasComparatorInputOverride() {
        return true;
    }

    public int getComparatorInputOverride(final World par1World, final int par2, final int par3, final int par4,
                                          final int par5) {
        return Container.calcRedstoneFromInventory((IInventory) par1World.getTileEntity(par2, par3, par4));
    }

    public TileEntity createNewTileEntity(final World var1, final int var2) {
        return new TileEntityCrystalFurnace();
    }
}
