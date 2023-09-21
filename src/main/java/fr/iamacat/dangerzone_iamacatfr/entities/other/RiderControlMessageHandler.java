
package fr.iamacat.dangerzone_iamacatfr.entities.other;

import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import io.netty.channel.ChannelHandler;

@ChannelHandler.Sharable
public class RiderControlMessageHandler implements IMessageHandler<RiderControlMessage, IMessage> {

    private static final Logger L;

    public IMessage onMessage(final RiderControlMessage message, final MessageContext ctx) {
        if (ctx.side == Side.CLIENT) {
            return null;
        }
        OreSpawnMain.flyup_keystate = message.keystate;
        return null;
    }

    static {
        L = LogManager.getLogger();
    }
}
