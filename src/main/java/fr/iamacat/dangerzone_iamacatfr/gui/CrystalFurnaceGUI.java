
package fr.iamacat.dangerzone_iamacatfr.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.ContainerCrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.TileEntityCrystalFurnace;

@SideOnly(Side.CLIENT)
public class CrystalFurnaceGUI extends GuiContainer {

    private static final ResourceLocation furnaceGuiTextures;
    private TileEntityCrystalFurnace furnaceInventory;

    public CrystalFurnaceGUI(final InventoryPlayer par1InventoryPlayer,
        final TileEntityCrystalFurnace par2TileEntityCrystalFurnace) {
        super((Container) new ContainerCrystalFurnace(par1InventoryPlayer, par2TileEntityCrystalFurnace));
        this.furnaceInventory = par2TileEntityCrystalFurnace;
    }

    protected void drawGuiContainerForegroundLayer(final int par1, final int par2) {
        final String s = this.furnaceInventory.hasCustomInventoryName() ? this.furnaceInventory.getInventoryName()
            : I18n.format(this.furnaceInventory.getInventoryName(), new Object[0]);
        this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
        this.fontRendererObj
            .drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
    }

    protected void drawGuiContainerBackgroundLayer(final float par1, final int par2, final int par3) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager()
            .bindTexture(CrystalFurnaceGUI.furnaceGuiTextures);
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        if (this.furnaceInventory.isBurning()) {
            final int i1 = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
        }
        final int i1 = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
    }

    static {
        furnaceGuiTextures = new ResourceLocation("textures/gui/container/furnace.png");
    }
}
