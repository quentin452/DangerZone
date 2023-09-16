package fr.iamacat.dangerzone_iamacatfr.gui;

import fr.iamacat.dangerzone_iamacatfr.tileentities.instance.ContainerCrystalWorkbench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class CrystalWorkbenchGUI extends GuiContainer {

    private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURES = new ResourceLocation(
        "textures/gui/container/crafting_table.png");

    public CrystalWorkbenchGUI(final InventoryPlayer playerInventory, final World world, final int x, final int y,
        final int z) {
        super(new ContainerCrystalWorkbench(playerInventory, world, x, y, z));
    }

    @Override
    protected void drawGuiContainerForegroundLayer(final int mouseX, final int mouseY) {
        final String craftingTitle = I18n.format("container.crafting");
        this.fontRendererObj.drawString(craftingTitle, 28, 6, 4210752);

        final String inventoryTitle = I18n.format("container.inventory");
        this.fontRendererObj.drawString(inventoryTitle, 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(final float partialTicks, final int mouseX, final int mouseY) {
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager()
            .bindTexture(CRAFTING_TABLE_GUI_TEXTURES);

        final int k = (this.width - this.xSize) / 2;
        final int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
    }
}
