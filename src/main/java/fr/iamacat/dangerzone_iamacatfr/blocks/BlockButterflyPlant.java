
package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.ButterflyInstance;
import fr.iamacat.dangerzone_iamacatfr.init.ItemInitDangerZone;
import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;

import java.util.Random;

public class BlockButterflyPlant extends BlockCrops {

    @SideOnly(Side.CLIENT)
    private IIcon[] field_94364_a;

    public BlockButterflyPlant() {
        this.setTickRandomly(true);
    }

    public void updateTick(final World par1World, final int par2, final int par3, final int par4,
        final Random par5Random) {
        super.updateTick(par1World, par2, par3, par4, par5Random);
        Random rand = new Random();
        if (par1World.isRemote) {
            return;
        }
        if (par1World.isRaining()) {
            return;
        }
        int rate = par1World.getBlockMetadata(par2, par3, par4);
        rate &= 0x7;
        rate = 7 - rate;
        if (rate > 1 && rand.nextInt(rate) != 0) {
            return;
        }
        final Block bid = par1World.getBlock(par2, par3 + 1, par4);
        if (bid == Blocks.air && par1World.isDaytime()) {
            EntityRegistry.addSpawn(ButterflyInstance.class, 8, 5, 15, EnumCreatureType.ambient, BiomeGenBase.beach);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHills);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 5, 1, 2, EnumCreatureType.ambient, BiomeGenBase.extremeHillsEdge);
            EntityRegistry.addSpawn(ButterflyInstance.class, 30, 3, 6, EnumCreatureType.ambient, BiomeGenBase.forest);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.forestHills);
            EntityRegistry.addSpawn(ButterflyInstance.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungle);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 10, 2, 5, EnumCreatureType.ambient, BiomeGenBase.jungleHills);
            EntityRegistry.addSpawn(ButterflyInstance.class, 20, 3, 6, EnumCreatureType.ambient, BiomeGenBase.plains);
            EntityRegistry.addSpawn(ButterflyInstance.class, 20, 2, 5, EnumCreatureType.ambient, BiomeGenBase.river);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 20, 4, 10, EnumCreatureType.ambient, BiomeGenBase.swampland);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 15, 2, 4, EnumCreatureType.ambient, BiomeGenBase.birchForest);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.birchForestHills);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.megaTaiga);
            EntityRegistry.addSpawn(ButterflyInstance.class, 15, 2, 5, EnumCreatureType.ambient, BiomeGenBase.taiga);
            EntityRegistry.addSpawn(ButterflyInstance.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savanna);
            EntityRegistry
                .addSpawn(ButterflyInstance.class, 10, 1, 5, EnumCreatureType.ambient, BiomeGenBase.savannaPlateau);
        }
        spawnCreature(par1World, "Butterfly", par2 + 0.5, par3 + 1.01, par4 + 0.5);
    }

    public static Entity spawnCreature(final World par0World, final String par1, final double par2, final double par4,
        final double par6) {
        Entity var8;
        var8 = EntityList.createEntityByName(par1, par0World);
        if (var8 != null) {
            var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0f, 0.0f);
            par0World.spawnEntityInWorld(var8);
            ((EntityLiving) var8).playLivingSound();
        }
        return var8;
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(final int par1, int par2) {
        if (par2 < 7) {
            if (par2 >= 6) {
                par2 = 4;
            }
            return this.field_94364_a[par2 >> 1];
        }
        return this.field_94364_a[3];
    }

    public int quantityDropped(final Random par1Random) {
        return 1 + par1Random.nextInt(5);
    }

    protected Item func_149866_i() {
        return ItemInitDangerZone.ItemButterflySeed;
    }

    protected Item func_149865_P() {
        return null;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(final IIconRegister par1IIconRegister) {
        this.field_94364_a = new IIcon[4];
        for (int i = 0; i < this.field_94364_a.length; ++i) {
            this.field_94364_a[i] = par1IIconRegister.registerIcon(Tags.MODID + ":butterfly_" + i);
        }
    }
}
