
package danger.orespawn.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MyBlockFlower extends Block implements IPlantable {

    protected MyBlockFlower(final int par1, final Material par2Material) {
        super(par2Material);
        this.setTickRandomly(true);
        final float f = 0.2f;
        this.setBlockBounds(0.5f - f, 0.0f, 0.5f - f, 0.5f + f, f * 3.0f, 0.5f + f);
        this.setCreativeTab(CreativeTabs.tabDecorations);
    }

    public MyBlockFlower(final int par1) {
        this(par1, Material.plants);
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }

    protected boolean canPlaceBlockOn(final Block par1) {
        return par1 == Blocks.grass || par1 == Blocks.dirt
            || par1 == Blocks.farmland
            || par1 == OreSpawnMain.CrystalGrass;
    }

    public void onNeighborBlockChange(final World par1World, final int par2, final int par3, final int par4,
        final Block par5) {
        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
        this.checkFlowerChange(par1World, par2, par3, par4);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        this.checkFlowerChange(par1World, par2, par3, par4);
    }

    protected final void checkFlowerChange(final World par1World, final int par2, final int par3, final int par4) {
        if (!this.canBlockStay(par1World, par2, par3, par4)) {
            this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            return;
        }
        long t = par1World.getWorldTime();
        t %= 24000L;
        if (t > 12000L) {
            if (this == OreSpawnMain.MyFlowerPinkBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerBlackBlock);
            }
            if (this == OreSpawnMain.MyFlowerBlueBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerScaryBlock);
            }
        } else {
            if (this == OreSpawnMain.MyFlowerBlackBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerPinkBlock);
            }
            if (this == OreSpawnMain.MyFlowerScaryBlock) {
                par1World.setBlock(par2, par3, par4, OreSpawnMain.MyFlowerBlueBlock);
            }
        }
    }

    public boolean canBlockStay(final World p_149718_1_, final int p_149718_2_, final int p_149718_3_,
        final int p_149718_4_) {
        return p_149718_1_.getBlock(p_149718_2_, p_149718_3_ - 1, p_149718_4_)
            .canSustainPlant(
                (IBlockAccess) p_149718_1_,
                p_149718_2_,
                p_149718_3_ - 1,
                p_149718_4_,
                ForgeDirection.UP,
                (IPlantable) this);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3,
        final int par4) {
        return null;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public int getRenderType() {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }

    public EnumPlantType getPlantType(final IBlockAccess world, final int x, final int y, final int z) {
        return EnumPlantType.Plains;
    }

    public Block getPlant(final IBlockAccess world, final int x, final int y, final int z) {
        return this;
    }

    public int getPlantMetadata(final IBlockAccess world, final int x, final int y, final int z) {
        return world.getBlockMetadata(x, y, z);
    }
}
