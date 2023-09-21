
package fr.iamacat.dangerzone_iamacatfr.entities.other;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import fr.iamacat.dangerzone_iamacatfr.OreSpawnMain;
import fr.iamacat.dangerzone_iamacatfr.util.KeyHandler;

public class RiderControl {

    private final RiderControlMessage rcm;
    private final SimpleNetworkWrapper network;
    private int keystate;

    public RiderControl(final SimpleNetworkWrapper network) {
        this.rcm = new RiderControlMessage();
        this.keystate = 0;
        this.network = network;
    }

    @SubscribeEvent
    public void onTick(final TickEvent.ClientTickEvent evt) {
        int newkeystate = 0;
        final KeyHandler myKeyhandler = OreSpawnMain.MyKeyhandler;
        if (KeyHandler.KEY_FLY_UP.getIsKeyPressed()) {
            newkeystate = 1;
        }
        if (this.keystate != newkeystate) {
            this.rcm.keystate = newkeystate;
            this.network.sendToServer((IMessage) this.rcm);
            this.keystate = newkeystate;
        }
    }
}
