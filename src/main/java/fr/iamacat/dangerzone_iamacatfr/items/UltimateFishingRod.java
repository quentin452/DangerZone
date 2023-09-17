package fr.iamacat.dangerzone_iamacatfr.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFishingRod;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

public class UltimateFishingRod extends ItemFishingRod {

    public UltimateFishingRod() {
        super();
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(Tags.MODID + ":ultimatefishingrod");
    }
}
