package fr.iamacat.dangerzone_iamacatfr.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ChatAllowedCharacters;

import org.lwjgl.input.Keyboard;

import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;

public class GuiName extends GuiScreen {

    protected String screenTitle;
    private FairyInstance fairy;
    private int updateCounter;
    private String nameText;

    public GuiName(FairyInstance entityfairy) {
        DangerLogger.LOGGER.info("GuiName: constructed");

        screenTitle = "Enter custom name or leave blank for default:";
        fairy = entityfairy;
        nameText = "";

        if (fairy != null && fairy.getCustomName() != null) {
            nameText = fairy.getCustomName();
        }
    }

    @Override
    public void initGui() {
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 120, "Done"));
    }

    @Override
    public void onGuiClosed() {
        Keyboard.enableRepeatEvents(false);

        if (fairy != null) {
            DangerLogger.LOGGER.info("GuiName.onGuiClosed: isRemote = " + fairy.worldObj.isRemote);

            if (fairy.worldObj.isRemote) {
                // String s1 = "setfryname " + fairy.getEntityId() + " " + nameText;
                DangerZone.packetProxy.sendFairyRename(fairy, nameText);
            } else {
                fairy.setCustomName(nameText);
            }
        }
    }

    @Override
    public void updateScreen() {
        updateCounter++;

        if (fairy == null || fairy.isDead) {
            mc.displayGuiScreen(null);
        }
    }

    @Override
    protected void actionPerformed(GuiButton guibutton) {
        if (!guibutton.enabled) {
            return;
        }

        if (guibutton.id == 0) {
            mc.displayGuiScreen(null);
        }
    }

    @Override
    protected void keyTyped(char c, int i) {
        if (i == 28) {
            mc.displayGuiScreen(null);
        }

        if (i == 14 && nameText.length() > 0) {
            nameText = nameText.substring(0, nameText.length() - 1);
        }

        if (ChatAllowedCharacters.isAllowedCharacter(c) && nameText.length() < 12) {
            nameText += c;
        }
    }

    @Override
    public void drawScreen(int i, int j, float f) {
        drawDefaultBackground();
        drawCenteredString(fontRendererObj, screenTitle, width / 2, 40, 0xffffff);
        drawCenteredString(fontRendererObj, nameText, width / 2, 56, 0xffffff);
        super.drawScreen(i, j, f);
    }

}
