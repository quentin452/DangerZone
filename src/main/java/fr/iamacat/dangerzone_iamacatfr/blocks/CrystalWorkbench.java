package fr.iamacat.dangerzone_iamacatfr.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class CrystalWorkbench extends BlockWorkbench {

    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconTop;
    @SideOnly(Side.CLIENT)
    private IIcon workbenchIconFront;

    public boolean isOpaqueCube() {
        return false;
    }

    public boolean renderAsNormalBlock() {
        return false;
    }

    private static final ResourceLocation TEXTURE_SIDE = new ResourceLocation(Tags.MODID, "crystalworkbench_side");
    private static final ResourceLocation TEXTURE_TOP = new ResourceLocation(Tags.MODID, "crystalworkbench_top");
    private static final ResourceLocation TEXTURE_FRONT = new ResourceLocation(Tags.MODID, "crystalworkbench_bottom");

    public CrystalWorkbench() {
        setHardness(2.0f);
        setResistance(10.0f);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX,
        float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        }
        player.openGui(Tags.MODID, 1, world, x, y, z);
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIcon(int side, int meta) {
        return (side == 1) ? workbenchIconTop
            : ((side == 0) ? blockIcon : ((side != 2 && side != 4) ? blockIcon : workbenchIconFront));
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        blockIcon = iconRegister.registerIcon(TEXTURE_SIDE.toString());
        workbenchIconTop = iconRegister.registerIcon(TEXTURE_TOP.toString());
        workbenchIconFront = iconRegister.registerIcon(TEXTURE_FRONT.toString());
    }
}
