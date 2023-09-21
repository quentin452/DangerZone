package fr.iamacat.dangerzone_iamacatfr.event;

import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import fr.iamacat.dangerzone_iamacatfr.entities.entity.FairyInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.PacketBuffer;

import java.io.IOException;

public class PacketSetFairyName extends FairyPacket {

    public static final int MIN_NAME_LENGTH = 3;
    public static final int MAX_NAME_LENGTH = 16;

    private int fairyID;
    private String name;

    public PacketSetFairyName() {
        super(FairyEventListener.PacketType.SET_FAIRY_NAME);
    }

    public PacketSetFairyName(final FairyInstance fairy, final String name) {
        this();
        this.fairyID = fairy.getEntityId();
        this.name = name;
        pack();
    }

    @Override
    protected void pack() {
        DangerLogger.LOGGER.info("PacketSetFairyName.pack");

        final PacketBuffer buf = (PacketBuffer) this.payload();
        buf.writeInt(this.fairyID);
        try {
            buf.writeStringToBuffer(this.name);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void init(PacketBuffer buf) {
        DangerLogger.LOGGER.info("PacketSetFairyName.init");

        fairyID = buf.readInt();
        try {
            name = buf.readStringFromBuffer(MAX_NAME_LENGTH)
                .trim();
            if (name.length() < MIN_NAME_LENGTH) {
                name = "";
            }
        } catch (IOException e) {
            name = "";
        }
    }

    @Override
    public void handle(NetworkManager origin) {
        DangerLogger.LOGGER.info("PacketSetFairyName.handle");

        final EntityPlayerMP player = ((NetHandlerPlayServer) origin.getNetHandler()).playerEntity;
        if (player != null) {
            final FairyInstance fairy = DangerZone.getFairy(this.fairyID);
            if (fairy == null) {
                DangerLogger.LOGGER.warn("Unable to find fairy " + this.fairyID + " to rename.");
                return;
            }

            final String username = player.getGameProfile()
                .getName();
            final String rulername = fairy.rulerName();
            if (fairy.nameEnabled() && rulername.equals(username)) {
                fairy.setCustomName(this.name);
            } else {
                DangerLogger.LOGGER.warn("Attempt by '" + username + "' to rename fairy owned by '" + rulername + "'");
            }
            fairy.setNameEnabled(false);
        }
    }

}
