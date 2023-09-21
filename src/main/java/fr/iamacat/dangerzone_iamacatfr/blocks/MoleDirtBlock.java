
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Random;

public class MoleDirtBlock extends Block {

    public MoleDirtBlock(final int i) {
        super(Material.ground);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setTickRandomly(true);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.isRemote) {
            return;
        }
        par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(final World par1World, final int par2, final int par3,
        final int par4) {
        final float f = 0.125f;
        return AxisAlignedBB.getBoundingBox(par2, par3, par4, (par2 + 1), (par3 + 1 - f), (par4 + 1));
    }

    public void onEntityCollidedWithBlock(final World par1World, final int par2, final int par3, final int par4,
        final Entity par5Entity) {
        if (par5Entity != null) {
            par5Entity.motionX *= 0.3;
            par5Entity.motionZ *= 0.3;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"+ this.getUnlocalizedName()
                .substring(5));
    }
}
