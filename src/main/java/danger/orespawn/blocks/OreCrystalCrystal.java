
package danger.orespawn.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreCrystalCrystal extends Block {

    public OreCrystalCrystal(final int par1, final float lv, final float f1, final float f2) {
        super(Material.rock);
        this.setHardness(f1);
        this.setResistance(f2);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setLightLevel(lv);
        this.setTickRandomly(true);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (par1World.rand.nextInt(20) == 0) {
            this.sparkle(par1World, par2, par3, par4);
        }
    }

    private void sparkle(final World par1World, final int par2, final int par3, final int par4) {
        final int which = 0;
        final float dx = 0.5f;
        final float dz = 0.5f;
        final float dy = 0.5f;
        if (this == OreSpawnMain.TigersEye) {
            par1World.spawnParticle(
                "flame",
                (par2 + dx),
                par3 + dy,
                (par4 + dz),
                ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f),
                ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f),
                ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f));
        } else {
            par1World.spawnParticle(
                "fireworksSpark",
                (par2 + dx),
                par3 + dy,
                (par4 + dz),
                ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f),
                ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f),
                ((par1World.rand.nextFloat() - par1World.rand.nextFloat()) / 4.0f));
        }
    }

    public int getRenderType() {
        return 1;
    }

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    public void onBlockDestroyedByPlayer(final World par1World, final int par2, final int par3, final int par4,
        final int par5) {
        if (this == OreSpawnMain.CrystalCrystal && !par1World.isRemote && par1World.rand.nextInt(10) == 1) {
            par1World.newExplosion(
                null,
                (par2 + 0.5f),
                (par3 + 0.5f),
                (par4 + 0.5f),
                1.0f,
                true,
                par1World.getGameRules()
                    .getGameRuleBooleanValue("mobGriefing"));
        }
        super.onBlockDestroyedByPlayer(par1World, par2, par3, par4, par5);
    }

    public void dropBlockAsItemWithChance(final World par1World, final int par2, final int par3, final int par4,
        final int par5, final float par6, final int par7) {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
        final int j1 = 5 + par1World.rand.nextInt(5) + par1World.rand.nextInt(10);
        if (par3 < 40) {
            this.dropXpOnBlockBreak(par1World, par2, par3, par4, j1);
        }
    }

    public int quantityDropped(final Random par1Random) {
        if (this != OreSpawnMain.TigersEye) {
            return 1;
        }
        return par1Random.nextInt(2);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(
            "OreSpawn:" + this.getUnlocalizedName()
                .substring(5));
    }
}
