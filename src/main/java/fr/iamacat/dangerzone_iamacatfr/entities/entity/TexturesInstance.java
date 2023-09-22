
package fr.iamacat.dangerzone_iamacatfr.entities.entity;

import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;

@SideOnly(Side.CLIENT)
public class TexturesInstance {

    public static final ResourceLocation mavisOrbTexture;

    static {
        mavisOrbTexture = new ResourceLocation(Tags.MODID + ":" + "textures/items/MavisOrbModel.png");
    }
}
