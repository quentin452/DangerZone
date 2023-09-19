
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.BrownAntInstance;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class OreSalt extends Block {

    public OreSalt() {
        super(Material.rock);
        this.setHardness(5.0f);
        this.setResistance(2.0f);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    public void onEntityCollidedWithBlock(final World par1World, final int par2, final int par3, final int par4,
        final Entity par5Entity) {
        if (par5Entity instanceof BrownAntInstance) {
            par5Entity.attackEntityFrom(DamageSource.cactus, 5.0f);
        }
    }

    public void onEntityWalking(final World par1World, final int par2, final int par3, final int par4,
        final Entity par5Entity) {
        if (par5Entity instanceof BrownAntInstance) {
            par5Entity.attackEntityFrom(DamageSource.cactus, 5.0f);
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            Tags.MODID + ":"
                + this.getUnlocalizedName()
                    .substring(5));
    }
}
