
package fr.iamacat.dangerzone_iamacatfr.entities.other;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;

public class RiderControlMessage implements IMessage {

    public int keystate;
    private int previous;

    public RiderControlMessage() {
        this.keystate = 0;
    }

    public void fromBytes(final ByteBuf buf) {
        this.fromInteger(buf.readUnsignedByte());
    }

    public void toBytes(final ByteBuf buf) {
        buf.writeByte(this.toInteger());
    }

    public void fromInteger(final int value) {
        this.keystate = value;
    }

    public int toInteger() {
        return this.keystate;
    }

    public boolean hasChanged() {
        final int current = this.keystate;
        final boolean changed = this.previous != current;
        this.previous = current;
        return changed;
    }
}
