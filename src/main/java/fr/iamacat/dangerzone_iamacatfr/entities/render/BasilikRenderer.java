//Deobfuscated with https://github.com/SimplyProgrammer/Minecraft-Deobfuscator3000 using mappings "C:\Users\Administrator\Downloads\Minecraft-Deobfuscator3000-1.2.3\Minecraft-Deobfuscator3000-1.2.3\1.7.10 stable mappings"!

//Decompiled by Procyon!

package fr.iamacat.dangerzone_iamacatfr.entities.render;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.util.Tags;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class BasilikRenderer extends RenderLiving
{
    private static final ResourceLocation texture;

    public BasilikRenderer(final ModelBase modelBase, final float f) {
        super(modelBase, f);
    }

    protected ResourceLocation getEntityTexture(final Entity entity) {
        return BasilikRenderer.texture;
    }

    static {
        texture = new ResourceLocation(Tags.MODID +":textures/entity/basilisk.png");
    }
}
