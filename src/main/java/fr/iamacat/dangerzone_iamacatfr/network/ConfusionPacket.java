package fr.iamacat.dangerzone_iamacatfr.network;

import fr.iamacat.dangerzone_iamacatfr.DangerZone;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

public class ConfusionPacket implements NetworkHelper.IPacket {

    private boolean doConfuse;

    public ConfusionPacket() {}

    public ConfusionPacket(boolean b) {
        this.doConfuse = b;
    }

    public void writeBytes(ChannelHandlerContext ctx, ByteBuf bytes) {
        bytes.writeBoolean(this.doConfuse);
    }

    public void readBytes(ChannelHandlerContext ctx, ByteBuf bytes) {
        this.doConfuse = bytes.readBoolean();

        DangerZone.packetProxy.onConfusionPacket(this.doConfuse);
    }
}
