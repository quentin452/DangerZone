
package fr.iamacat.dangerzone_iamacatfr.entities.entity.packets;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;

import java.io.IOException;

public class PZPacketTileText implements IMessage, IMessageHandler<PZPacketTileText, IMessage> {

    private int tileLocationX;
    private int tileLocationY;
    private int tileLocationZ;
    private String[] text;

    public PZPacketTileText setPacketData(final int tileLocationX, final int tileLocationY, final int tileLocationZ,
        final String[] text) {
        this.tileLocationX = tileLocationX;
        this.tileLocationY = tileLocationY;
        this.tileLocationZ = tileLocationZ;
        this.text = text;
        return this;
    }

    public void toBytes(final ByteBuf buffer) {
        final ByteBufOutputStream data = new ByteBufOutputStream(buffer);
        try {
            this.writeData(data);
        } catch (Exception e) {
            DangerLogger.LOGGER.error("Error writing packet %s to ByteBufOutputStream", this);
            e.printStackTrace();
        }
    }

    public void fromBytes(final ByteBuf buffer) {
        final ByteBufInputStream byteStream = new ByteBufInputStream(buffer);
        try {
            this.readData(byteStream);
        } catch (Exception e) {
            DangerLogger.LOGGER.error("Error reading packet %s from ByteBufInputStream", this);
            e.printStackTrace();
        }
    }

    protected void writeData(final ByteBufOutputStream buffer) throws IOException {
        buffer.writeInt(this.tileLocationX);
        buffer.writeInt(this.tileLocationY);
        buffer.writeInt(this.tileLocationZ);
        buffer.writeInt(this.text.length);
        for (final String string : this.text) {
            buffer.writeInt(string.length());
            buffer.writeChars(string);
        }
    }

    protected void readData(final ByteBufInputStream buffer) throws IOException {
        this.tileLocationX = buffer.readInt();
        this.tileLocationY = buffer.readInt();
        this.tileLocationZ = buffer.readInt();
        final int numTexts = buffer.readInt();
        this.text = new String[numTexts];
        for (int i = 0; i < numTexts; ++i) {
            final int stringLength = buffer.readInt();
            final char[] stringChars = new char[stringLength];
            for (int j = 0; j < stringLength; ++j) {
                stringChars[j] = buffer.readChar();
            }
            this.text[i] = new String(stringChars);
        }
    }

    public IMessage onMessage(final PZPacketTileText message, final MessageContext ctx) {
        if (ctx.side != Side.SERVER) {
            return null;
        }
        /*
         * final EntityPlayer player = (EntityPlayer)ctx.getServerHandler().playerEntity;
         * if (player.worldObj.getTileEntity(message.tileLocationX, message.tileLocationY, message.tileLocationZ)
         * instanceof TileEntityTombstone) {
         * final TileEntity tile = player.worldObj.getTileEntity(message.tileLocationX, message.tileLocationY,
         * message.tileLocationZ);
         * if (tile != null && tile instanceof TileEntityTombstone) {
         * final TileEntityTombstone tombstone = (TileEntityTombstone)tile;
         * tombstone.signText = message.text;
         * player.worldObj.markBlockForUpdate(message.tileLocationX, message.tileLocationY, message.tileLocationZ);
         * }
         * }
         */
        return null;
    }
}
