package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.EntityAnt;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.Termite;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class CreeperRepellent extends BlockTorch {

    public CreeperRepellent(int i) {
        super();
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        final int var6 = par1World.getBlockMetadata(par2, par3, par4);
        final double var7 = par2 + 0.5;
        final double var8 = par3 + 0.7;
        final double var9 = par4 + 0.5;
        final double var10 = 0.413;
        final double var11 = 0.271;

        String[] particles = { "smoke", "flame", "reddust" };

        if (var6 >= 1 && var6 <= 4) {
            for (String particle : particles) {
                par1World.spawnParticle(
                    particle,
                    var7 + (var6 == 2 ? var11 : (var6 == 3 ? -var11 : 0)),
                    var8 + var10,
                    var9 + (var6 == 1 ? -var11 : (var6 == 4 ? var11 : 0)),
                    0.0,
                    0.0,
                    0.0);
            }
        } else {
            for (String particle : particles) {
                par1World.spawnParticle(particle, var7, var8 + 0.21, var9, 0.0, 0.0, 0.0);
            }
        }
    }

    public int tickRate(final World par1World) {
        return 10;
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        if (!par1World.isRemote) {
            this.findSomethingToRepel(par1World, par2, par3, par4);
            par1World.scheduleBlockUpdate(par2, par3, par4, this, this.tickRate(par1World));
        }
    }

    public void onBlockAdded(final World world, final int x, final int y, final int z) {
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
    }

    public void onNeighborBlockChange(final World world, final int x, final int y, final int z, final Block blockId) {
        world.scheduleBlockUpdate(x, y, z, this, this.tickRate(world));
    }

    public boolean canPlaceBlockAt(final World par1World, final int par2, final int par3, final int par4) {
        return super.canPlaceBlockAt(par1World, par2, par3, par4);
    }

    private void findSomethingToRepel(final World par1World, final int par2, final int par3, final int par4) {
        final AxisAlignedBB bb = AxisAlignedBB
            .getBoundingBox(par2 - 20.0, par3 - 10.0, par4 - 20.0, par2 + 20.0, par3 + 40.0, par4 + 20.0);
        final List<EntityLivingBase> entities = par1World.getEntitiesWithinAABB(EntityLivingBase.class, bb);

        for (EntityLivingBase entity : entities) {
            double f = 0.0;

            if (entity instanceof EntityCreeper) {
                f = 20.0 - entity.getDistance(par2, par3, par4);
                f = Math.max(0.0, Math.min(20.0, f)) * 0.4;
            } else if (entity instanceof EntityAnt || entity instanceof Termite) {
                    f = 20.0 - entity.getDistance(par2, par3, par4);
                    f = Math.max(0.0, Math.min(20.0, f)) * 0.4;
                }

            if (f > 0.0) {
                double d1 = entity.posX - par2;
                double d3 = entity.posZ - par4;
                double d4 = Math.atan2(d1, d3);
                entity.motionX += f * Math.sin(d4);
                entity.motionZ += f * Math.cos(d4);
            }
        }
    }

    private static final ResourceLocation texture = new ResourceLocation(Tags.MODID, "creeperrepellent");

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister) {
        this.blockIcon = iconRegister.registerIcon(texture.toString());
    }
}
