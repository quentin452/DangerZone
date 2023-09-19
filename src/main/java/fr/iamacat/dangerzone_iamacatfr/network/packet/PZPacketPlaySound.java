
package fr.iamacat.dangerzone_iamacatfr.network.packet;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import fr.iamacat.dangerzone_iamacatfr.DangerLogger;
import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import java.io.IOException;

public class PZPacketPlaySound implements IMessage, IMessageHandler<PZPacketPlaySound, IMessage> {

    private int posX;
    private int posY;
    private int posZ;
    private String sound;

    public PZPacketPlaySound setPacketData(final int xPos, final int yPos, final int zPos, final String sound) {
        this.posX = xPos;
        this.posY = yPos;
        this.posZ = zPos;
        this.sound = sound;
        return this;
    }

    public IMessage onMessage(final PZPacketPlaySound message, final MessageContext ctx) {
        if (ctx.side != Side.CLIENT) {
            return null;
        }
        final EntityPlayer player = DangerZone.packetProxy.getClientPlayer();
        final World worldObj = player.worldObj;
        worldObj
            .playSound(message.posX, (double) message.posY, (double) message.posZ, message.sound, 1.0f, 1.0f, false);
        return null;
    }

    protected void writeData(final ByteBufOutputStream buffer) throws IOException {
        buffer.writeInt(this.posX);
        buffer.writeInt(this.posY);
        buffer.writeInt(this.posZ);
        buffer.writeInt(this.sound.length());
        buffer.writeChars(this.sound);
    }

    protected void readData(final ByteBufInputStream buffer) throws IOException {
        this.posX = buffer.readInt();
        this.posY = buffer.readInt();
        this.posZ = buffer.readInt();
        final int soundLength = buffer.readInt();
        final char[] soundChars = new char[soundLength];
        for (int i = 0; i < soundChars.length; ++i) {
            soundChars[i] = buffer.readChar();
        }
        this.sound = new String(soundChars);
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
}
