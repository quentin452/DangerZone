package fr.iamacat.dangerzone_iamacatfr.gui;

import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.ContainerCrystalFurnace;
import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.TileEntityCrystalFurnace;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CrystalFurnaceGUI extends GuiContainer {

    private static final ResourceLocation FURNACE_GUI_TEXTURES = new ResourceLocation("textures/gui/container/furnace.png");
    private final TileEntityCrystalFurnace furnaceInventory;

    public CrystalFurnaceGUI(final InventoryPlayer playerInventory, final TileEntityCrystalFurnace furnace) {
        super(new ContainerCrystalFurnace(playerInventory, furnace));
        this.furnaceInventory = furnace;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
        final String inventoryName = this.furnaceInventory.hasCustomInventoryName()
            ? this.furnaceInventory.getInventoryName()
            : I18n.format(this.furnaceInventory.getInventoryName());
        final int centerX = this.xSize / 2 - this.fontRendererObj.getStringWidth(inventoryName) / 2;
        final int centerY = 6;
        this.fontRendererObj.drawString(inventoryName, centerX, centerY, 4210752);
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, final int mouseY) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(FURNACE_GUI_TEXTURES);
        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

        if (this.furnaceInventory.isBurning()) {
            final int burnTimeRemainingScaled = this.furnaceInventory.getBurnTimeRemainingScaled(12);
            this.drawTexturedModalRect(k + 56, l + 36 + 12 - burnTimeRemainingScaled, 176, 12 - burnTimeRemainingScaled, 14, burnTimeRemainingScaled + 2);
        }

        final int cookProgressScaled = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, cookProgressScaled + 1, 16);
    }
}
